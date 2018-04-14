package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.OrderForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class OrderFormDaoTest {
    @Resource
    private OrderFormDao orderFormDao;

    @Test
    public void addOrderForm() {
        OrderForm test = new OrderForm();
        test.setVipphone("13900000005");
        test.setPrice(500);
        test.setOrderTime(new Date(1000));
        test.setPay(0);
        test.setRoom("room_test");
        test.setDetail("hhhhhh");
        orderFormDao.addOrderForm(test);
    }

    @Test
    public void deleteOrderForm() {
        orderFormDao.deleteOrderForm(new Date(1000), "room_test");
    }

    @Test
    public void queryOrderFormByvipphone() {
        List<OrderForm> result = orderFormDao.queryOrderFormByVIP("13900000005");
        for (OrderForm o : result) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void queryOrderFormByPay() {
        List<OrderForm> result = orderFormDao.queryOrderFormByPay(0);
        for (OrderForm o : result) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void payOrder() {
        assert (orderFormDao.payOrder(new Date(1000), "room_test") == 1);
    }
}
