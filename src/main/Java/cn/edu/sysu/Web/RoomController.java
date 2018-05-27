package cn.edu.sysu.Web;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Room;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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
            Room room = roomService.queryRoom(keyWord.charAt(1) - '0', String.valueOf(keyWord.charAt(0)));
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

}
