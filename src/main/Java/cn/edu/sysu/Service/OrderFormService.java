package cn.edu.sysu.Service;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.OrderForm;

import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by lihan on 2018/4/14
 * Description: OrderForm的业务层接口，提供
 * 对OrderForm的增加、删除、修改以及查询等方法。
 */
public interface OrderFormService {

    /**
     * 新增一个订单
     *
     * @param orderForm 将要被增加的订单
     * @return 返回增加订单的结果
     */
    OperationStatus addOrderForm(OrderForm orderForm);

    /**
     * 删除一个订单
     *
     * @param orderTime 下订单的时间
     * @param room      下订单的房间号
     * @return 返回删除订单的结果
     */
    OperationStatus deleteOrderForm(Date orderTime, String room);

    /**
     * 查询系统中的所有订单信息
     *
     * @return 系统中所有的订单
     */
    List<OrderForm> queryAllOrderForm();

    /**
     * 查询一个VIP会员的所有订单信息
     *
     * @param phone 查询的VIP的电话号码
     * @return 该VIP所有订单信息列表
     */
    List<OrderForm> queryOrderFormByVIP(String phone);

    /**
     * 查询已付费（未付费）的所有订单
     *
     * @param pay 是否付块信息
     * @return 未付费的所有订单列表
     */
    List<OrderForm> queryOrderFormByPay(int pay);

    /**
     * 根据主键把一个订单的状态设置为已支付
     *
     * @param orderTime 下订单的时间
     * @param room      下订单的房间
     * @return 返回支付订单的结果
     */
    OperationStatus payOrder(Date orderTime, String room);

}
