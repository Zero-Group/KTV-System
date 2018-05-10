package cn.edu.sysu.Service;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Room;

import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by lihan on 2018/4/14
 * Description: Room的Service层接口，提供
 * 对Room的增加、删除、修改以及查询等方法。
 */

public interface RoomService {

    /**
     * 商家向系统中添加房间
     *
     * @param room 将要被添加的房间
     * @return 返回添加房间的结果
     */
    OperationStatus addRoom(Room room);

    /**
     * 商家删除系统中的房间
     *
     * @param id   将要删除的房间
     * @param type 将要删除的房间类型
     * @return 返回删除房间的结果
     */
    OperationStatus deleteRoom(int id, String type);

    /**
     * 根据给定的房间类型、房间编号、开始时间以
     * 及结束时间来订房
     *
     * @param id        房间编号
     * @param type      房间类型
     * @param startTime 消费开始时间
     * @param hours     消费时长
     * @return 返回订房的结果
     */
    OperationStatus bookingRoom(int id, String type, Date startTime, int hours);

    /**
     * 根据给定的房间类型、房间编号来结束使用
     * 房间
     *
     * @param id   房间编号
     * @param type 房间类型
     * @return 返回结束使用房间的结果
     */
    OperationStatus checkoutRoom(int id, String type);

    /**
     * 根据给定的房间类型、房间编号、续费时间
     * 来进行续费
     *
     * @param id    房间编号
     * @param type  房间类型
     * @param hours 续费小时数
     * @return 返回续订房间的结果
     */
    OperationStatus renewRoom(int id, String type, int hours);

    /**
     * 根据给定的房间类型和房间编号查询房间
     *
     * @param id   房间编号
     * @param type 房间类型
     * @return 返回该房间
     */
    Room queryRoom(int id, String type);

    /**
     * 查询所有房间
     *
     * @return 所有的房间列表
     */
    List<Room> queryAllRoom();

    /**
     * 查询状态为空的房间
     *
     * @return 状态为空的房间列表
     */
    List<Room> queryEmptyRoom();

    /**
     * 根据给定房间类型查询状态为空的房间
     *
     * @param type 房间类型
     * @return 给定类型状态为空的房间
     */
    List<Room> queryEmptyRoomByType(String type);

}
