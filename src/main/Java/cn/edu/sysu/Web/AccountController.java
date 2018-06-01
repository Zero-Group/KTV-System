package cn.edu.sysu.Web;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Food;
import cn.edu.sysu.Entity.Order;
import cn.edu.sysu.Entity.OrderDetail;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Service.FoodService;
import cn.edu.sysu.Service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lihan on 2018/5/8
 * Description: Account相关页面的Controller
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String AccountManagement() {
        return "accountManagement";
    }

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public String FoodManagement() {
        return "foodManagement";
    }

    @RequestMapping(value = "/food/all", method = RequestMethod.GET)
    public String allRoom(Model model) {
        List<Food> foodList = foodService.queryAllFood();
        model.addAttribute("list", foodList);
        model.addAttribute("rows", Math.ceil(foodList.size() / 6.0));
        model.addAttribute("title", "所有食物");
        return "foodList";
    }

    @RequestMapping(value = "/food/query", method = RequestMethod.GET)
    public String queryFood() {
        return "foodQuery";
    }

    @RequestMapping(value = "/food/query")
    public String doFoodQuery(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String keyWord = request.getParameter("key");
        if (keyWord.equals("")) {
            model.addAttribute("msg", "请输入有效字符！");
            return "foodQuery";
        }
        Food food = foodService.queryFoodByFName(keyWord);
        if (food == null) {
            model.addAttribute("msg", "未查询到相关食物信息！");
            return "foodQuery";
        }
        model.addAttribute("food", food);
        model.addAttribute("title", "查询结果");
        return "foodDetail";
    }

    @RequestMapping(value = "/food/add", method = RequestMethod.GET)
    public String addFood() {
        return "foodAdd";
    }

    @RequestMapping(value = "/food/add")
    public String doFoodAdd(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String foodName = request.getParameter("name");
        String foodPrice = request.getParameter("price");
        String foodStock = request.getParameter("number");
        Food food = new Food();
        food.setFname(foodName);
        food.setPrice(Double.parseDouble(foodPrice));
        food.setStock(Integer.parseInt(foodStock));
        OperationStatus result;
        try {
            result = foodService.addFood(food);
        } catch (KTVException e) {
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            return "foodAdd";
        }
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        return "foodAdd";
    }

    @RequestMapping(value = "/food/delete")
    public String doFoodDelete(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        try {
            foodService.deleteFood(fname);
        } catch (KTVException e) {
            model.addAttribute("msg", e.getMessage());
            return "redirect:/account/food/all";
        }
        return "redirect:/account/food/all";
    }

    @RequestMapping(value = "/food/changeprice")
    public String doFoodChangePrice(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String newprice = request.getParameter("newprice");
        OperationStatus result;
        Food food = foodService.queryFoodByFName(fname);
        try {
            result = foodService.changePrice(fname, Double.parseDouble(newprice));
            food = foodService.queryFoodByFName(fname);
        } catch (KTVException e) {
            model.addAttribute("food", food);
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            return "foodDetail";
        }
        model.addAttribute("food", food);
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        return "foodDetail";
    }

    @RequestMapping(value = "/food/increase")
    public String doFoodIncrease(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String increase = request.getParameter("increase");
        OperationStatus result;
        Food food = foodService.queryFoodByFName(fname);
        try {
            result = foodService.increaseStock(fname, Integer.parseInt(increase));
            food = foodService.queryFoodByFName(fname);
        } catch (KTVException e) {
            model.addAttribute("food", food);
            model.addAttribute("succeed", false);
            model.addAttribute("msg", e.getMessage());
            return "foodDetail";
        }
        model.addAttribute("food", food);
        model.addAttribute("succeed", true);
        model.addAttribute("msg", result.getMessage());
        return "foodDetail";
    }

    @RequestMapping(value = "/food/id={id}/detail", method = RequestMethod.GET)
    public String foodDetail(@PathVariable("id") Integer id, Model model) {
        if (id == null) {
            return "redirect:/account/food/all";
        }
        Food food = foodService.queryFoodById(id);
        if (food == null) {
            return "redirect:/account/food/all";
        }
        model.addAttribute("food", food);
        model.addAttribute("title", "食物详情");
        return "foodDetail";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String OrderManagement() {
        return "orderManagement";
    }

    @RequestMapping(value = "/order/all", method = RequestMethod.GET)
    public String allOrder(Model model) {
        List<Order> orderList = orderService.queryAllOrder();
        model.addAttribute("list", orderList);
        model.addAttribute("rows", Math.ceil(orderList.size() / 6.0));
        model.addAttribute("title", "所有订单");
        return "orderList";
    }

    @RequestMapping(value = "/order/query", method = RequestMethod.GET)
    public String queryOrder() {
        return "orderQuery";
    }

    @RequestMapping(value = "/order/query")
    public String doOrderQuery(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String keyWord = request.getParameter("key");
        if (keyWord.equals("")) {
            model.addAttribute("msg", "请输入有效字符！");
            return "orderQuery";
        }
        List<Order> result = orderService.queryOrderByVIP(keyWord);
        model.addAttribute("list", result);
        model.addAttribute("rows", Math.ceil(result.size() / 6.0));
        model.addAttribute("title", "查询结果");
        return "orderList";
    }

    @RequestMapping(value = "/order/id={id}/detail", method = RequestMethod.GET)
    public String orderDetail(@PathVariable("id") Integer id, Model model) throws IOException {
        if (id == null) {
            return "redirect:/account/order/all";
        }
        Order order = orderService.queryOrderById(id);
        if (order == null) {
            return "redirect:/account/order/all";
        }
        ObjectMapper mapper = new ObjectMapper();
        String orderDetail = order.getDetail();
        List<OrderDetail> detailList = mapper
                .readValue(orderDetail, new TypeReference<List<OrderDetail>>() {
                });
        model.addAttribute("list", detailList);
        model.addAttribute("order", order);
        model.addAttribute("title", "账单详情");
        return "orderDetail";
    }
}
