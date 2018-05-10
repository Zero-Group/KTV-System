package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.VIP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class VIPDaoTest {
    @Resource
    private VIPDao vipDao;

    @Test
    public void addVIP() {
        VIP vip = new VIP();
        vip.setCname("Test");
        vip.setPhone("10101");
        assert (vipDao.addVIP(vip) == 1);
    }

    @Test
    public void deleteVIP() {
        assert (vipDao.deleteVIP("10101") == 1);
    }

    @Test
    public void queryAllVIP() {
        List<VIP> result = vipDao.queryAllVIP();
        result.forEach(System.out::println);
    }

    @Test
    public void queryVIPByName() {
        List<VIP> result = vipDao.queryVIPByName("Alice");
        result.forEach(System.out::println);
    }

    @Test
    public void queryVIPByPhone() {
        VIP result = vipDao.queryVIPByPhone("12345678910");
        System.out.println(result.toString());
    }

    @Test
    public void changeName(){
        assert(vipDao.changeName("10101","newName") == 1);
    }
}