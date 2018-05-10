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
    private VIPService VIPService;

    @Test
    public void test() {
        addVIP();
        queryByName();
        queryByPhone();
        changeName();
        deleteVIP();
    }

    private void addVIP() {
        VIP vip = new VIP();
        vip.setCname("Test");
        vip.setPhone("10101");
        assert (VIPService.addVIP(vip)
                .getMessage().equals("新增会员成功！"));
    }

    private void queryByName() {
        List<VIP> vips = VIPService.queryVIPByName("Test");
        vips.forEach(System.out::println);
    }

    private void queryByPhone() {
        VIP vip = VIPService.queryVIPByPhone("10101");
        System.out.println(vip.toString());
    }

    private void changeName() {
        String new_name = "newName";
        String phone = "10101";
        assert (VIPService.changeName(phone, new_name)
                .getMessage().equals("会员姓名更改成功！"));
    }

    private void deleteVIP() {
        assert (VIPService.deleteVIP("10101")
                .getMessage().equals("删除会员成功！"));
    }

}