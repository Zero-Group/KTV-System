package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dao
 * Created by Houben on 2018/4/10
 * Description:Order（订单）数据访问接口
 */
public interface OrderDao {
    /**
     * 新增一个订单
     *
     * @param order 将要被增加的订单
     */
    void addOrder(Order order);

    /**
     * 根据订单编号删除一个订单
     *
     * @param id 订单编号
     */
    void deleteOrder(int id);

    /**
     * 查询数据库中的所有订单信息
     *
     * @return 数据库中所有的订单
     */
    List<Order> queryAllOrder();

    /**
     * 根据订单编号订单信息
     *
     * @param id 查询订单编号
     * @return 订单信息
     */
    Order queryOrderById(int id);

    /**
     * 根据房间信息以及时间查询订单信息
     *
     * @param room      查询订单房间编号
     * @param orderTime 查询订单时间
     * @return 订单信息
     */
    Order queryOrder(@Param("room") String room, @Param("orderTime") Date orderTime);

    /**
     * 查询一个VIP会员的所有订单信息
     *
     * @param cname 查询的VIP姓名
     * @return 该VIP所有订单信息列表
     */
    List<Order> queryOrderByVIP(String cname);

    /**
     * 查询已付费（未付费）的所有订单
     *
     * @param pay 是否付块信息
     * @return 未付费的所有订单列表
     */
    List<Order> queryOrderByPay(int pay);

    /**
     * 根据主键把一个订单的状态设置为已支付
     *
     * @param id 订单编号
     * @return 修改数据库的行数
     */
    int payOrder(int id);

    /**
     * 在房间续费和消费的时候更新订单详情
     *
     * @param id        订单编号
     * @param newDetail 新的订单详情
     * @param newPrice  新的订单价格
     */
    void updateDetail(@Param("id") int id, @Param("newdetail") String newDetail, @Param("newprice") double newPrice);
}
