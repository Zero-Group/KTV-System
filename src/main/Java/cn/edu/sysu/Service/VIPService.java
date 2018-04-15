package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.VIP;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by lihan on 2018/4/14
 * Description: VIP的业务层接口，提供
 * 对VIP的增加、删除、修改以及查询等方法。
 */
public interface VIPService {

    /**
     * 商家添加VIP会员
     *
     * @param VIP 将要添加的VIP会员
     * @return 返回添加的结果
     */
    String addVIP(VIP VIP);

    /**
     * 商家删除VIP会员
     *
     * @param VIP 将要被删除的VIP会员
     * @return 返回删除的结果
     */
    String deleteVIP(VIP VIP);

    /**
     * 根据姓名信息查询VIP信息
     *
     * @param cname 表示查询所依据的姓名信息
     * @return 返回符合姓名查询的VIP列表
     */
    List<VIP> queryVIPByName(String cname);

    /**
     * 根据电话查询VIP信息
     *
     * @param phone 电话号码
     * @return 返回电话号码为phone的VIP
     */
    VIP queryVIPByPhone(String phone);

    /**
     * 更改用户名
     *
     * @param phone 需要更改的用户主键(phone)
     * @param cname 需要更改的名字
     * @return 返回修改的结果
     */
    String changeName(String phone, String cname);

}
