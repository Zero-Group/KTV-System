package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.OrderFormDao;
import cn.edu.sysu.Dao.RoomDao;
import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.OrderForm;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Exception.OrderFormException;
import cn.edu.sysu.Service.OrderFormService;
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
 * Created by Houben on 2018/4/17
 * Description:业务层接口的实现类
 * 实现订单类的增加，删除，查询，支付等功能
 */
@Service
public class OrderFormServiceImpl implements OrderFormService {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderFormDao orderFormDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    @Transactional
    public OperationStatus addOrderForm(OrderForm orderForm) throws KTVException {
        try {
            if (roomDao.queryRoom(orderForm.getRoom().charAt(1) - '0', String.valueOf(orderForm.getRoom().charAt(0))) == null) {
                throw new OrderFormException("房间不存在，订单无效！");
            }
            orderFormDao.addOrderForm(orderForm);
            return new OperationStatus("新增订单成功！");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus deleteOrderForm(Date orderTime, String room) throws KTVException {
        try {
            if (roomDao.queryRoom(room.charAt(1) - '0', String.valueOf(room.charAt(0))) == null) {
                throw new OrderFormException("房间不存在，订单无效！");
            }
            orderFormDao.deleteOrderForm(orderTime, room);
            return new OperationStatus("删除订单成功！");
        } catch (OrderFormException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    public List<OrderForm> queryAllOrderForm() {
        return orderFormDao.queryAllOrderForm();
    }

    @Override
    public List<OrderForm> queryOrderFormByVIP(String phone) {
        return orderFormDao.queryOrderFormByVIP(phone);
    }

    @Override
    public List<OrderForm> queryOrderFormByPay(int pay) {
        return orderFormDao.queryOrderFormByPay(pay);
    }

    @Override
    @Transactional
    public OperationStatus payOrder(Date orderTime, String room) throws KTVException {
        try {
            if (roomDao.queryRoom(room.charAt(1) - '0', String.valueOf(room.charAt(0))) == null) {
                throw new OrderFormException("房间不存在，订单无效！");
            }
            orderFormDao.payOrder(orderTime, room);
            return new OperationStatus("支付订单成功！");
        } catch (OrderFormException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

}
