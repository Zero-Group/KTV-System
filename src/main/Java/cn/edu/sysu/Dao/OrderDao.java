package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Order;

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

}
