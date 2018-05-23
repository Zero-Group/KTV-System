package cn.edu.sysu.Web;

import cn.edu.sysu.Entity.VIP;
import cn.edu.sysu.Service.VIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Web
 * Created by lihan on 2018/5/7
 * Description: VIP相关页面的Controller
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allVIP(Model model) {
        List<VIP> allVIP = vipService.queryAllVIP();
        model.addAttribute("list", allVIP);
        model.addAttribute("rows", Math.ceil(allVIP.size() / 6.0));
        model.addAttribute("title", "所有会员");
        return "vipList";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String queryVIP() {
        return "vipQuery";
    }

    @RequestMapping(value = "/query")
    public String doVIPQuery(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String keyWord = request.getParameter("key");
        if (keyWord.equals("")) {
            model.addAttribute("msg", "请输入有效字符！");
            return "vipQuery";
        }
        VIP name = vipService.queryVIPByName(keyWord);
        VIP phone = vipService.queryVIPByPhone(keyWord);
        List<VIP> result = new ArrayList<>();
        if (name != null) {
            result.add(name);
        }
        if (phone != null) {
            result.add(phone);
        }
        if (result.size() == 0) {
            model.addAttribute("msg", "未查询到相关会员信息！");
            return "vipQuery";
        }
        model.addAttribute("list", result);
        model.addAttribute("rows", Math.ceil(result.size() / 6.0));
        model.addAttribute("title", "查询结果");
        return "vipList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addVIP() {
        return "vipAdd";
    }

    @RequestMapping(value = "/id={id}/detail", method = RequestMethod.GET)
    public String VIPByPhone(@PathVariable("id") Integer id, Model model) {
        if (id == null) {
            return "redirect:/vip/all";
        }
        VIP vip = vipService.queryVIPById(id);
        if (vip == null) {
            return "redirect:/vip/all";
        }
        model.addAttribute("vip", vip);
        model.addAttribute("title", "会员详情");
        return "vipDetail";
    }

}
