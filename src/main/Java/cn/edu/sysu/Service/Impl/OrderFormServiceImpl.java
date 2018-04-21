package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.OrderFormDao;
import cn.edu.sysu.Entity.OrderForm;
import cn.edu.sysu.Service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by Houben on 2018/4/17
 * Description:业务层接口的实现类
 * 实现订单类的增加，删除，查询，支付等功能
 */
@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    private OrderFormDao orderFormDao;

    @Override
    public String addOrderForm(OrderForm OrderForm) {
        try{
            orderFormDao.addOrderForm(OrderForm);
        }catch(Exception e){
            return "订单新增失败，请联系管理员";
        }
        return "订单新增已完成";
    }

    @Override
    public String deleteOrderForm(Date orderTime, String room) {
        try{
            orderFormDao.deleteOrderForm(orderTime,room);
        }catch(Exception e){
            return "订单删除失败，请联系管理员";
        }
        return "订单删除已完成";
    }

    @Override
    public List<OrderForm> queryOrderFormByVIP(String phone) {
        List<OrderForm> result = new ArrayList<>();
        try{
            result = orderFormDao.queryOrderFormByVIP(phone);
        }catch(Exception e){
            return result;
        }
        return result;

    }

    @Override
    public List<OrderForm> queryOrderFormByPay(int pay) {
        List<OrderForm> result = new ArrayList<>();
        try{
            result = orderFormDao.queryOrderFormByPay(pay);
        }catch(Exception e){
            return result;
        }
        return result;
    }

    @Override
    public String payOrder(Date orderTime, String room) {
        try{
            orderFormDao.payOrder(orderTime,room);
        }catch (Exception e){
            return "订单支付失败，请联系管理员";
        }

        return "订单支付已完成";
    }

}
