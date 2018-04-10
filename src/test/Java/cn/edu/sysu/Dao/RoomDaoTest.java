package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class RoomDaoTest {

    @Resource
    private RoomDao roomDao;

    @Test
    public void addRoom() {
        Room room = new Room();
        room.setId(2);
        room.setType("L");
        room.setStatus(0);
        roomDao.addRoom(room);
    }

    @Test
    public void deleteRoom() {
        roomDao.deleteRoom(0, "L");
    }

    @Test
    public void bookingRoom() {
        long currentTime = System.currentTimeMillis();
        assert (roomDao.bookingRoom(2, "L", new Date(currentTime), new Date(currentTime + 3 * 3600 * 1000)) == 1);
    }

    @Test
    public void checkoutRoom() {
        assert (roomDao.checkoutRoom(2, "L") == 1);
    }

    @Test
    public void queryRoom() {
        System.out.println(roomDao.queryRoom(2, "L").toString());
    }

    @Test
    public void queryAllRoom() {
        List<Room> rooms = roomDao.queryAllRoom();
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    @Test
    public void queryEmptyRoom() {
        List<Room> rooms = roomDao.queryEmptyRoom();
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    @Test
    public void queryEmptyRoomByType() {
        List<Room> rooms = roomDao.queryEmptyRoomByType("L");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

}