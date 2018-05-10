package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml",
        "classpath*:spring/spring-service.xml"})
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void test() {
        addRoom();
        bookingRoom();
        renewRoom();
        checkoutRoom();
        queryAllRoom();
        queryEmptyRoom();
        queryEmptyRoomByType();
        deleteRoom();
    }

    private void addRoom() {
        Room room = new Room();
        room.setId(100);
        room.setType("L");
        room.setStatus(0);
        assert (roomService.addRoom(room)
                .getMessage().equals("新增房间成功！"));
    }

    private void bookingRoom() {
        long currentTime = System.currentTimeMillis();
        assert (roomService.bookingRoom(100, "L", new Date(currentTime), 1)
                .getMessage().equals("订房成功！"));
    }

    private void renewRoom() {
        assert (roomService.renewRoom(100, "L", 1)
                .getMessage().equals("续费房间成功！"));
    }

    private void checkoutRoom() {
        assert (roomService.checkoutRoom(100, "L")
                .getMessage().equals("结束使用房间成功！"));
    }

    private void queryAllRoom() {
        List<Room> rooms = roomService.queryAllRoom();
        rooms.forEach(System.out::println);
    }

    private void queryEmptyRoom() {
        List<Room> rooms = roomService.queryEmptyRoom();
        rooms.forEach(System.out::println);
    }

    private void queryEmptyRoomByType() {
        List<Room> rooms = roomService.queryEmptyRoomByType("L");
        rooms.forEach(System.out::println);
    }

    private void deleteRoom() {
        assert (roomService.deleteRoom(100,"L")
                .getMessage().equals("删除房间成功！"));
    }
}
