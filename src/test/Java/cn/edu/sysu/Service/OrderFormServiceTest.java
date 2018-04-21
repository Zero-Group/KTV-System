package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.OrderForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class OrderFormServiceTest {
    @Resource
    private OrderFormService orderFormService;
    @Test
    public void addOrderForm() {
        OrderForm test = new OrderForm();
        test.setVipphone("13900000005");
        test.setPrice(500);
        test.setOrderTime(new Date(1000));
        test.setPay(0);
        test.setRoom("room_test");
        test.setDetail("hhhhhh");
        orderFormService.addOrderForm(test);
        assert(orderFormService.queryOrderFormByVIP("13900000005").size() > 0);
    }

    @Test
    public void deleteOrderForm() {
        OrderForm test = new OrderForm();
        test.setVipphone("13900000005");
        test.setPrice(500);
        test.setOrderTime(new Date(1000));
        test.setPay(0);
        test.setRoom("room_test");
        test.setDetail("hhhhhh");
        orderFormService.deleteOrderForm(new Date(1000),"room_test");
        assert(orderFormService.queryOrderFormByVIP("13900000005").size() < 1);
    }

    @Test
    public void queryOrderFormByVIP() {
        assert (orderFormService.queryOrderFormByVIP("13900000005").size() > 0);
    }

    @Test
    public void queryOrderFormByPay() {
        assert (orderFormService.queryOrderFormByPay(0).size() > 0);
    }

    @Test
    public void payOrder() {
        orderFormService.payOrder(new Date(1000),"room_test");
        assert (orderFormService.queryOrderFormByPay(0).size() < 1);
    }
}