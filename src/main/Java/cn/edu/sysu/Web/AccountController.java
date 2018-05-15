package cn.edu.sysu.Web;

import cn.edu.sysu.Entity.Food;
import cn.edu.sysu.Entity.OrderForm;
import cn.edu.sysu.Service.FoodService;
import cn.edu.sysu.Service.OrderFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lihan on 2018/5/8
 * Description:
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderFormService orderFormService;

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
        model.addAttribute("title", "所有食物");
        return "foodList";
    }

    @RequestMapping(value = "/food/query", method = RequestMethod.GET)
    public String queryFood() {
        return "foodQuery";
    }

    @RequestMapping(value = "/food/add", method = RequestMethod.GET)
    public String addFood() {
        return "foodAdd";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String OrderManagement() {
        return "orderManagement";
    }

    @RequestMapping(value = "/order/all", method = RequestMethod.GET)
    public String allOrder(Model model) {
        List<OrderForm> orderformList = orderFormService.queryAllOrderForm();
        model.addAttribute("list", orderformList);
        model.addAttribute("title", "所有订单");
        return "orderList";
    }

    @RequestMapping(value = "/order/query", method = RequestMethod.GET)
    public String queryOrder() {
        return "orderQuery";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String addOrder() {
        return "orderAdd";
    }
}
