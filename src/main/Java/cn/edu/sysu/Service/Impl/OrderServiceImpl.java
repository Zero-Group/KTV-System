package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.OrderDao;
import cn.edu.sysu.Dao.RoomDao;
import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Order;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Exception.OrderException;
import cn.edu.sysu.Service.OrderService;
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
public class OrderServiceImpl implements OrderService {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    @Transactional
    public OperationStatus addOrder(Order order) throws KTVException {
        try {
            if (roomDao.queryRoom(Integer.parseInt(order.getRoom().substring(1)), order.getRoom().substring(0, 1)) == null) {
                throw new OrderException("房间不存在，订单无效！");
            }
            orderDao.addOrder(order);
            return new OperationStatus("新增订单成功！");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus deleteOrder(int id) throws KTVException {
        try {
            orderDao.deleteOrder(id);
            return new OperationStatus("删除订单成功！");
        } catch (OrderException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderDao.queryAllOrder();
    }

    @Override
    public Order queryOrderById(int id) {
        return orderDao.queryOrderById(id);
    }

    @Override
    public Order queryOrder(String room, Date orderTime) {
        return orderDao.queryOrder(room, orderTime);
    }

    @Override
    public List<Order> queryOrderByVIP(String cname) {
        return orderDao.queryOrderByVIP(cname);
    }

    @Override
    public List<Order> queryOrderByPay(int pay) {
        return orderDao.queryOrderByPay(pay);
    }

    @Override
    @Transactional
    public OperationStatus payOrder(int id) throws KTVException {
        try {
            if (orderDao.queryOrderById(id).getPay() == 1) {
                throw new OrderException("该订单已支付，请勿重复支付！");
            }
            orderDao.payOrder(id);
            return new OperationStatus("支付订单成功！");
        } catch (OrderException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

}
