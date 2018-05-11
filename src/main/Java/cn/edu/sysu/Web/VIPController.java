package cn.edu.sysu.Web;

import cn.edu.sysu.Entity.VIP;
import cn.edu.sysu.Service.VIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lihan on 2018/5/7
 * Description:
 */

@Controller
@RequestMapping("/vip")
public class VIPController {

    @Autowired
    private VIPService vipService;

    @RequestMapping(method = RequestMethod.GET)
    public String VIPManagement() {
        return "vipManagement";
    }

    @RequestMapping(value = "/{phone}/detail", method = RequestMethod.GET)
    public String VIPByPhone(@PathVariable("phone") String phone, Model model) {
        if (phone == null) {
            return "redirect:/vip/all";
        }
        VIP vip = vipService.queryVIPByPhone(phone);
        if (vip == null) {
            return "redirect:/vip/all";
        }
        model.addAttribute("vip", vip);
        model.addAttribute("title", "会员：" + vip.getCname() + "电话：" + phone);
        return "vipDetail";
    }

    @RequestMapping(value = "/{cname}", method = RequestMethod.GET)
    public String VIPByName(@PathVariable("cname") String cname, Model model) {
        if (cname == null) {
            return "redirect:/vip/all";
        }
        List<VIP> vipList = vipService.queryVIPByName(cname);
        if (vipList == null) {
            return "redirect:/vip/all";
        }
        model.addAttribute("list", vipList);
        model.addAttribute("title", "名字为" + cname + "的会员");
        return "vipList";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allVIP(Model model) {
        List<VIP> allVIP = vipService.queryAllVIP();
        model.addAttribute("list", allVIP);
        model.addAttribute("title", "所有会员");
        return "vipList";
    }

}
