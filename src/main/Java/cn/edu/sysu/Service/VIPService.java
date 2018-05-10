package cn.edu.sysu.Service;

import cn.edu.sysu.Dto.OperationStatus;
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
     * @return 返回添加VIP会员的结果
     */
    OperationStatus addVIP(VIP VIP);

    /**
     * 商家删除VIP会员
     *
     * @param phone 将要被删除的VIP会员电话号码
     * @return 返回删除VIP会员的结果
     */
    OperationStatus deleteVIP(String phone);

    /**
     * 查询所有VIP会员信息
     *
     * @return 返回所有会员列表
     */
    List<VIP> queryAllVIP();

    /**
     * 根据姓名信息查询VIP会员信息
     *
     * @param cname VIP会员姓名
     * @return 返回符合姓名查询的VIP列表
     */
    List<VIP> queryVIPByName(String cname);

    /**
     * 根据电话查询VIP信息
     *
     * @param phone VIP会员电话号码
     * @return 返回电话号码为phone的VIP
     */
    VIP queryVIPByPhone(String phone);

    /**
     * 更改会员名字
     *
     * @param phone 需要更改的VIP会员phone
     * @param cname 新的VIP会员名字
     * @return 返回更改VIP会员名字的结果
     */
    OperationStatus changeName(String phone, String cname);

}
