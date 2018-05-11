package cn.edu.sysu.Web;

import cn.edu.sysu.Dao.ManagerDao;
import cn.edu.sysu.Entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lihan on 2018/5/10
 * Description:
 */
@Controller
@RequestMapping("")
public class LoginController {

    @Resource
    private ManagerDao managerDao;

    @RequestMapping("/login")
    public String check(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || username.equals("")) {
            model.addAttribute("msg", "请输入管理员信息");
            return "login";
        }
        Manager manager = managerDao.getManager(username);
        if (manager == null) {
            model.addAttribute("msg", "用户名错误！");
            return "login";
        }
        if (!manager.getPassword().equals(password)) {
            model.addAttribute("msg", "密码错误！");
            return "login";
        }

        return "success";
    }

    @RequestMapping("/ktv")
    public String success() {
        return "ktvManagement";
    }

}
