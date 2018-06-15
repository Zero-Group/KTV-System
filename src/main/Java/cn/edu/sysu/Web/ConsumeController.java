package cn.edu.sysu.Web;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Food;
import cn.edu.sysu.Entity.Order;
import cn.edu.sysu.Entity.OrderDetail;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Service.FoodService;
import cn.edu.sysu.Service.OrderService;
import cn.edu.sysu.Service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lishanjian on 2018/6/5
 * Description:
 */

@Controller
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/id={id}", method = RequestMethod.GET)
    public String consumeDetail(@PathVariable("id") Integer id, Model model) {
        Order order = orderService.queryOrderById(id);
        if (order == null || order.getPay() == 1) {
            return "welcome";
        }
        List<Food> allFood = foodService.queryAllFood();
        model.addAttribute("oid", id);
        model.addAttribute("allfood", allFood);
        model.addAttribute("rows", Math.ceil(allFood.size() / 6.0));
        return "consume";
    }

    @RequestMapping(value = "/placeorder")
    public String placeAnOrder(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String add = request.getParameter("jsonStr");
        String oid = request.getParameter("oid");
        String totalPrice = request.getParameter("total");
        Order order = orderService.queryOrderById(Integer.parseInt(oid));
        if (order == null || order.getPay() == 1) {
            return "welcome";
        }
        ObjectMapper mapper = new ObjectMapper();
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, OrderDetail.class);
        List<OrderDetail> addDetail = mapper.readValue(add, listType);
        List<OrderDetail> listDetail = mapper.readValue(order.getDetail(), listType);
        listDetail.addAll(addDetail);
        String newDetail = mapper.writeValueAsString(listDetail);
        double newPrice = Double.parseDouble(totalPrice) + order.getPrice();
        try {
            addDetail.forEach(orderDetail -> foodService.reduceStock(orderDetail.getName(), orderDetail.getNumber()));
            orderService.updateDetail(Integer.parseInt(oid), newDetail, newPrice);
        } catch (KTVException e) {
            return null;
        }
        return "consume";
    }

    @RequestMapping(value = "renew")
    public String renewRoom(HttpServletRequest request, Model model) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String hours = request.getParameter("hours");
        String oid = request.getParameter("oid");
        List<Food> allFood = foodService.queryAllFood();
        Order order = orderService.queryOrderById(Integer.parseInt(oid));
        if (order == null || order.getPay() == 1) {
            return "welcome";
        }
        String room = order.getRoom();
        OperationStatus result;
        try {
            result = roomService.renewRoom(Integer.parseInt(room.substring(1)),
                    room.substring(0, 1), Integer.parseInt(hours));
            ObjectMapper mapper = new ObjectMapper();
            String detail = order.getDetail();
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, OrderDetail.class);
            List<OrderDetail> listDetail = mapper.readValue(detail, listType);
            listDetail.get(0).setNumber(listDetail.get(0).getNumber() + Integer.parseInt(hours));
            listDetail.get(0).setTotalPrice(listDetail.get(0).getNumber() * listDetail.get(0).getUnitPrice());
            String newDetail = mapper.writeValueAsString(listDetail);
            double unitPrice = room.substring(0, 1).equals("L") ? 200.0 : room.substring(0, 1).equals("M") ? 130.0 : 80.0;
            double newPrice = order.getPrice() + Integer.parseInt(hours) * unitPrice;
            orderService.updateDetail(Integer.parseInt(oid), newDetail, newPrice);
        } catch (KTVException e) {
            model.addAttribute("oid", oid);
            model.addAttribute("allfood", allFood);
            model.addAttribute("rows", Math.ceil(allFood.size() / 6.0));
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            return "consume";
        }
        model.addAttribute("oid", oid);
        model.addAttribute("allfood", allFood);
        model.addAttribute("rows", Math.ceil(allFood.size() / 6.0));
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        return "consume";
    }

}