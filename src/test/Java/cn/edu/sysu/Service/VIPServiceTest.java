package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.VIP;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by Houben on 2018/4/17
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class VIPServiceTest {
    @Resource
    private VIPService VIPService;

    @Test
    public void addVIP(){
        VIP vip = new VIP();
        vip.setCname("Test");
        vip.setPhone("10101");
        VIPService.addVIP(vip);
        assert (VIPService.queryVIPByName("Test").size() > 0);
    }

    @Test
    public void deleteVIP(){
        VIP vip = new VIP();
        vip.setCname("Test");
        vip.setPhone("10101");
        VIPService.deleteVIP(vip);
        assert (VIPService.queryVIPByName("Test").size() < 1);
    }

    @Test
    public void queryByName(){
        String s = "Test";
        assert(VIPService.queryVIPByName(s).size() > 0);
    }

    @Test
    public void queryByPhone(){
        String s = "10101";
        assert (VIPService.queryVIPByPhone(s).getCname().equals("Test"));
    }

    @Test
    public void changeName(){
        String new_name = "newName";
        String phone = "10101";
        VIPService.changeName(phone ,new_name);
        assert(VIPService.queryVIPByPhone(phone).getCname().equals(new_name));
    }

}