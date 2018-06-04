package cn.edu.sysu.Web;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Order;
import cn.edu.sysu.Entity.OrderDetail;
import cn.edu.sysu.Entity.Room;
import cn.edu.sysu.Entity.VIP;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Service.OrderService;
import cn.edu.sysu.Service.RoomService;
import cn.edu.sysu.Service.VIPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lihan on 2018/4/26
 * Description: Room相关页面的Controller
 */

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private VIPService vipService;

    @RequestMapping(method = RequestMethod.GET)
    public String RoomManagement() {
        return "roomManagement";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allRoom(Model model) {
        List<Room> roomList = roomService.queryAllRoom();
        model.addAttribute("list", roomList);
        model.addAttribute("rows", Math.ceil(roomList.size() / 6.0));
        model.addAttribute("title", "所有房间");
        return "roomList";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String queryRoom() {
        return "roomQuery";
    }

    @RequestMapping(value = "/query")
    public String doRoomQuery(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String keyWord = request.getParameter("key");

        if (keyWord.length() == 1 && String.valueOf(keyWord.charAt(0)).equals("空")) {
            List<Room> result = roomService.queryEmptyRoom();
            if (result == null) {
                model.addAttribute("msg", "未查询到空房间！");
                return "roomQuery";
            }
            model.addAttribute("list", result);
            model.addAttribute("rows", Math.ceil(result.size() / 6.0));
            model.addAttribute("title", "查询结果");
            return "roomList";
        } else if (keyWord.length() == 2 && String.valueOf(keyWord.charAt(0)).equals("空")) {
            List<Room> result = roomService.queryEmptyRoomByType(String.valueOf(keyWord.charAt(1)));
            if (result == null) {
                model.addAttribute("msg", "未查询到类型为" + String.valueOf(keyWord.charAt(1)) + "空房间！");
                return "roomQuery";
            }
            model.addAttribute("list", result);
            model.addAttribute("rows", Math.ceil(result.size() / 6.0));
            model.addAttribute("title", "查询结果");
            return "roomList";
        } else if (keyWord.length() == 2 && !String.valueOf(keyWord.charAt(0)).equals("空")) {
            Room room = roomService.queryRoom(Integer.parseInt(keyWord.substring(1)), keyWord.substring(0, 1));
            if (room == null) {
                model.addAttribute("msg", "未查询到相关房间信息！");
                return "roomQuery";
            }
            model.addAttribute("room", room);
            model.addAttribute("title", "房间详情");
            return "roomDetail";
        } else {
            model.addAttribute("msg", "请输入有效字符！");
            return "roomQuery";
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRoom() {
        return "roomAdd";
    }

    @RequestMapping(value = "/add")
    public String doRoomAdd(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String roomType = request.getParameter("roomType");
        String roomNum = request.getParameter("roomNum");
        Room room = new Room();
        room.setType(roomType);
        room.setPrice(roomType.equals("L") ? 200.0 : roomType.equals("M") ? 130.0 : 80.0);
        room.setId(Integer.parseInt(roomNum));
        OperationStatus result;
        try {
            result = roomService.addRoom(room);
        } catch (KTVException e) {
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            return "roomAdd";
        }
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        return "roomAdd";
    }

    @RequestMapping(value = "/{type}-{id}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id,
                         @PathVariable("type") String type, Model model) {
        if (id == null) {
            return "redirect:/room/all";
        }
        Room room = roomService.queryRoom(id, type);
        if (room == null) {
            return "redirect:/room/all";
        }
        model.addAttribute("room", room);
        model.addAttribute("title", "房间详情");
        return "roomDetail";
    }

    @RequestMapping(value = "/booking")
    public String bookingRoom(HttpServletRequest request, Model model) throws UnsupportedEncodingException, JsonProcessingException {
        request.setCharacterEncoding("UTF-8");
        String roomType = request.getParameter("roomType");
        String roomNum = request.getParameter("roomNum");
        String hours = request.getParameter("hours");
        String cname = request.getParameter("cname");
        Room room = roomService.queryRoom(Integer.parseInt(roomNum), roomType);
        OperationStatus result;
        try {
            VIP vip = vipService.queryVIPByName(cname);
            if (vip == null) {
                throw new KTVException("会员名字错误，请重新输入！");
            }
            Date now = new Date();
            result = roomService.bookingRoom(Integer.parseInt(roomNum), roomType, now, Integer.parseInt(hours));
            ObjectMapper mapper = new ObjectMapper();
            OrderDetail roomDetail = new OrderDetail();
            double unitPrice = roomType.equals("L") ? 200.0 : roomType.equals("M") ? 130.0 : 80.0;
            roomDetail.setName(roomType + roomNum);
            roomDetail.setUnitPrice(unitPrice);
            roomDetail.setNumber(Integer.parseInt(hours));
            roomDetail.setTotalPrice(unitPrice * Integer.parseInt(hours));
            List<OrderDetail> detail = new ArrayList<>();
            detail.add(roomDetail);
            Order order = new Order();
            order.setRoom(roomType + roomNum);
            order.setOrderTime(now);
            order.setCname(cname);
            order.setPhone(vip.getPhone());
            order.setPrice(unitPrice * Integer.parseInt(hours));
            order.setPay(0);
            order.setDetail(mapper.writeValueAsString(detail));
            orderService.addOrder(order);
            room = roomService.queryRoom(Integer.parseInt(roomNum), roomType);
        } catch (KTVException e) {
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            model.addAttribute("room", room);
            return "roomDetail";
        }
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        model.addAttribute("room", room);
        return "roomDetail";
    }

    @RequestMapping(value = "/checkout")
    public String checkoutRoom(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String roomType = request.getParameter("roomType");
        String roomNum = request.getParameter("roomNum");
        Room room = roomService.queryRoom(Integer.parseInt(roomNum), roomType);
        OperationStatus result;
        try {
            result = roomService.checkoutRoom(Integer.parseInt(roomNum), roomType);
            Order order = orderService.queryOrder(roomType + roomNum, room.getStartTime());
            orderService.payOrder(order.getId());
            room = roomService.queryRoom(Integer.parseInt(roomNum), roomType);
        } catch (KTVException e) {
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            model.addAttribute("room", room);
            model.addAttribute("title", "房间详情");
            return "roomDetail";
        }
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        model.addAttribute("room", room);
        model.addAttribute("title", "房间详情");
        return "roomDetail";
    }

}
