package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void addCustomer() {
        assert (customerService.addCustomer(new Customer()).getMessage().equals("新增顾客成功！"));
    }

    @Test
    public void deleteAllCustomer() {
        assert (customerService.deleteAllCustomer().getMessage().equals("删除所有顾客成功！"));
    }
}