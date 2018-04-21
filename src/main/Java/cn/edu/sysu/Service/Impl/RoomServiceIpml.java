package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.RoomDao;
import cn.edu.sysu.Entity.Room;
import cn.edu.sysu.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by lijinzhu on 2018/4/17
 * Description: 实现RoomService的有关业务层接口
 */
@Service
public class RoomServiceIpml implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public String addRoom(Room room) {
        roomDao.addRoom(room);
        return "添加成功";
    }

    @Override
    public String deleteRoom(int id, String type) {
        roomDao.deleteRoom(id,type);
        return "删除成功";
    }

    @Override
    public String bookingRoom(int id, String type, Date startTime, Date endTime) {
        roomDao.bookingRoom(id,type,startTime,(int)(endTime.getTime() - startTime.getTime()));
        return "订房成功";
    }

    @Override
    public String checkoutRoom(int id, String type) {
        roomDao.checkoutRoom(id,type);
        return "查询房间成功";
    }

    @Override
    public String renewRoom(int id, String type, int hours) {
        roomDao.renewRoom(id, type, hours);
        return "更新成功";
    }

    @Override
    public Room queryRoom(int id, String type) {
        return roomDao.queryRoom(id, type);
    }

    @Override
    public List<Room> queryAllRoom() {
        return roomDao.queryAllRoom();
    }

    @Override
    public List<Room> queryEmptyRoom() {
        return roomDao.queryEmptyRoom();
    }

    @Override
    public List<Room> queryEmptyRoomByType(String type) {
        return roomDao.queryEmptyRoomByType(type);
    }
}
