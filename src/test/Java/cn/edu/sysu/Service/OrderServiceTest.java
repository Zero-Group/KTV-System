package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml",
        "classpath*:spring/spring-service.xml"})
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void test() {
        addOrder();
        queryOrderByPay();
        queryOrderByVIP();
        payOrder();
        deleteOrder();
    }

    private void addOrder() {
        Order order = new Order();
        order.setRoom("L1");
        order.setCname("Alice");
        order.setPhone("12345678910");
        order.setPrice(120);
        order.setPay(0);
        order.setDetail("无详细信息！");
        assert (orderService.addOrder(order)
                .getMessage().equals("新增订单成功！"));
    }

    private void queryOrderByVIP() {
        List<Order> result = orderService
                .queryOrderByVIP("Alice");
        result.forEach(System.out::println);
    }

    private void queryOrderByPay() {
        List<Order> result = orderService
                .queryOrderByPay(0);
        result.forEach(System.out::println);
    }

    private void payOrder() {
        assert (orderService.payOrder(100)
                .getMessage().equals("支付订单成功！"));
    }

    private void deleteOrder() {
        assert (orderService.deleteOrder(100)
                .getMessage().equals("删除订单成功！"));
    }

}