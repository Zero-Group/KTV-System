package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.OrderForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml",
        "classpath*:spring/spring-service.xml"})
public class OrderFormServiceTest {

    @Resource
    private OrderFormService orderFormService;

    @Test
    public void test() {
        addOrderForm();
        queryOrderFormByPay();
        queryOrderFormByVIP();
        payOrder();
        deleteOrderForm();
    }

    private void addOrderForm() {
        OrderForm test = new OrderForm();
        test.setVipphone("13900000005");
        test.setPrice(500);
        test.setOrderTime(new Date(1000));
        test.setPay(0);
        test.setRoom("L1");
        test.setDetail("hhhhhh");
        assert (orderFormService.addOrderForm(test)
                .getMessage().equals("新增订单成功！"));
    }

    private void queryOrderFormByVIP() {
        List<OrderForm> result = orderFormService
                .queryOrderFormByVIP("13900000005");
        result.forEach(System.out::println);
    }

    private void queryOrderFormByPay() {
        List<OrderForm> result = orderFormService
                .queryOrderFormByPay(0);
        result.forEach(System.out::println);
    }

    private void payOrder() {
        assert (orderFormService.payOrder(new Date(1000), "L1")
                .getMessage().equals("支付订单成功！"));
    }

    private void deleteOrderForm() {
        assert (orderFormService.deleteOrderForm(new Date(1000), "L1")
                .getMessage().equals("删除订单成功！"));
    }

}