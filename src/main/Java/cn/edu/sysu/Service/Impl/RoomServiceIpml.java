package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.RoomDao;
import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Room;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Exception.RoomException;
import cn.edu.sysu.Service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomDao roomDao;

    @Override
    @Transactional
    public OperationStatus addRoom(Room room) throws KTVException {
        try {
            if (roomDao.queryRoom(room.getId(), room.getType()) != null) {
                throw new RoomException("房间" + room.getType() + room.getId() + "已存在！");
            }
            roomDao.addRoom(room);
            return new OperationStatus("新增房间成功！");
        } catch (RoomException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus deleteRoom(int id, String type) throws KTVException {
        try {
            if (roomDao.queryRoom(id, type) == null) {
                throw new RoomException("房间" + type + id + "不存在！");
            }
            roomDao.deleteRoom(id, type);
            return new OperationStatus("删除房间成功！");
        } catch (RoomException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus bookingRoom(int id, String type, Date startTime, int hours) throws KTVException {
        try {
            if (roomDao.queryRoom(id, type) == null) {
                throw new RoomException("房间" + type + id + "不存在！");
            }
            if (roomDao.queryRoom(id, type).getStatus() == 1) {
                throw new RoomException("房间正在使用！");
            }
            roomDao.bookingRoom(id, type, startTime, hours);
            return new OperationStatus("订房成功！");
        } catch (RoomException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    public OperationStatus checkoutRoom(int id, String type) throws KTVException {
        try {
            if (roomDao.queryRoom(id, type) == null) {
                throw new RoomException("房间" + type + id + "不存在！");
            }
            roomDao.checkoutRoom(id, type);
            return new OperationStatus("结束使用房间成功！");
        } catch (RoomException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    public OperationStatus renewRoom(int id, String type, int hours) throws KTVException {
        try {
            if (roomDao.queryRoom(id, type) == null) {
                throw new RoomException("房间" + type + id + "不存在！");
            }
            roomDao.renewRoom(id, type, hours);
            return new OperationStatus("续费房间成功！");
        } catch (RoomException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
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
