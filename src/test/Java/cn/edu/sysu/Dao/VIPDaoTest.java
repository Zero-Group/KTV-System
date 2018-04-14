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
        vipDao.addVIP(vip);
        assert (vipDao.queryVIPByName("Test").size() > 0);
    }

    @Test
    public void deleteVIP() {
        VIP vip = new VIP();
        vip.setCname("Test");
        vip.setPhone("10101");
        vipDao.deleteVIP(vip);
        assert (vipDao.queryVIPByName("Test").isEmpty());
    }

    @Test
    public void queryVIPByName() {
        List<VIP> result = vipDao.queryVIPByName("Alice");
        for (VIP vip : result)
            System.out.println(vip.toString());
        assert (result.size() > 0);
    }

    @Test
    public void queryVIPByPhone() {
        List<VIP> result = vipDao.queryVIPByPhone("123456789");
        for (VIP vip : result)
            System.out.println(vip.toString());
        assert (result.size() > 0);
    }

    @Test
    public void changeName(){
        assert(vipDao.changeName("10101","newName") > 0);
    }
}