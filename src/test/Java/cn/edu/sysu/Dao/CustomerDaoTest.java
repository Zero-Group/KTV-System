package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class CustomerDaoTest {

    @Resource
    private CustomerDao customerDao;

    @Test
    public void addCustomer() {
        customerDao.addCustomer(new Customer());
    }
}