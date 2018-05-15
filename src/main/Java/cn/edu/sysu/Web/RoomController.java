package cn.edu.sysu.Web;

import cn.edu.sysu.Entity.Room;
import cn.edu.sysu.Service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Created by lihan on 2018/4/26
 * Description:
 */

@Controller
@RequestMapping("/room")
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public String RoomManagement() {
        return "roomManagement";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allRoom(Model model) {
        List<Room> roomList = roomService.queryAllRoom();
        model.addAttribute("list", roomList);
        model.addAttribute("title", "所有房间");
        return "roomList";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String queryRoom() {
        return "roomQuery";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRoom() {
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
        model.addAttribute("title", "房间 " + type + id + " 详情");
        return "roomDetail";
    }

}
