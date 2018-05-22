package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.VIP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml",
        "classpath*:spring/spring-service.xml"})
public class VIPServiceTest {
    @Resource
    private VIPService vipService;

    @Test
    public void test() {
        addVIP();
        queryAll();
        queryById();
        queryByName();
        queryByPhone();
        changeName();
        deleteVIP();
    }

    private void addVIP() {
        VIP vip = new VIP();
        vip.setCname("Test");
        vip.setPhone("110");
        assert (vipService.addVIP(vip)
                .getMessage().equals("新增会员成功！"));
    }

    private void queryAll() {
        List<VIP> result = vipService.queryAllVIP();
        result.forEach(System.out::println);
    }

    private void queryById() {
        VIP vip = vipService.queryVIPById(100);
        System.out.println(vip.toString());
    }

    private void queryByName() {
        VIP vip = vipService.queryVIPByName("Test");
        System.out.println(vip.toString());
    }

    private void queryByPhone() {
        VIP vip = vipService.queryVIPByPhone("10101");
        System.out.println(vip.toString());
    }

    private void changeName() {
        String new_name = "newName";
        assert (vipService.changeName(100, new_name)
                .getMessage().equals("会员姓名更改成功！"));
    }

    private void deleteVIP() {
        assert (vipService.deleteVIP("Test")
                .getMessage().equals("删除会员成功！"));
    }

}