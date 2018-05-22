package cn.edu.sysu.Service;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Order;

import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by lihan on 2018/4/14
 * Description: Order的业务层接口，提供
 * 对Order的增加、删除、修改以及查询等方法。
 */
public interface OrderService {

    /**
     * 新增一个订单
     *
     * @param order 将要被增加的订单
     * @return 返回增加订单的结果
     */
    OperationStatus addOrder(Order order);

    /**
     * 删除一个订单
     *
     * @param id 订单编号
     * @return 返回删除订单的结果
     */
    OperationStatus deleteOrder(int id);

    /**
     * 查询系统中的所有订单信息
     *
     * @return 系统中所有的订单
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
     * @return 返回支付订单的结果
     */
    OperationStatus payOrder(int id);

}
