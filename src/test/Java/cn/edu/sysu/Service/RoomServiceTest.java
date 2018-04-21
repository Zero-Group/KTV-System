package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class RoomServiceTest {
    @Resource
    private RoomService roomService;

    @Test
    public void addRoom() {
        Room room = new Room();
        room.setId(4);
        room.setType("L");
        room.setStatus(0);
        assert (roomService.addRoom(room).equals("添加成功"));
    }

    @Test
    public void deleteRoom() {
        assert (roomService.deleteRoom(0,"L").equals("删除成功"));
    }

    @Test
    public  void bookingRoom() {
        long currentTime = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(currentTime));
        calendar.add(Calendar.HOUR,1);
        Date endDate = calendar.getTime();
        assert (roomService.bookingRoom(2, "L", new Date(currentTime), endDate).equals("订房成功"));
    }

    @Test
    public void checkoutRoom() {
        assert (roomService.checkoutRoom(2, "L").equals("查询房间成功"));
    }

    @Test
    public void renewRoom() {
        assert (roomService.renewRoom(2, "L", 1).equals("更新成功"));
    }

    @Test
    public void queryAllRoom() {
        List<Room> rooms = roomService.queryAllRoom();
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    @Test
    public void queryEmptyRoom() {
        List<Room> rooms = roomService.queryEmptyRoomByType("L");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    @Test
    public void queryEmptyRoomByType() {
        List<Room> rooms = roomService.queryEmptyRoomByType("L");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }
}
