package cn.edu.sysu.Web;

import cn.edu.sysu.Service.FoodService;
import cn.edu.sysu.Service.OrderFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
