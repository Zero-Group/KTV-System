package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class OrderDaoTest {
    @Resource
    private OrderDao orderDao;

    @Test
    public void addOrder() {
        Order order = new Order();
        order.setRoom("L1");
        order.setCname("Alice");
        order.setPhone("12345678910");
        order.setPrice(120);
        order.setPay(0);
        order.setDetail("无详细信息！");
        orderDao.addOrder(order);
    }

    @Test
    public void deleteOrder() {
        orderDao.deleteOrder(101);
    }

    @Test
    public void queryAllOrder() {
        List<Order> result = orderDao.queryAllOrder();
        result.forEach(System.out::println);
    }

    @Test
    public void queryOrderByvipphone() {
        List<Order> result = orderDao.queryOrderByVIP("Alice");
        result.forEach(System.out::println);
    }

    @Test
    public void queryOrderByPay() {
        List<Order> result = orderDao.queryOrderByPay(0);
        result.forEach(System.out::println);
    }

    @Test
    public void payOrder() {
        assert (orderDao.payOrder(101) == 1);
    }
}
