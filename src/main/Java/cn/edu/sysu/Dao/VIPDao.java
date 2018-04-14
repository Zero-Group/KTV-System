package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.VIP;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dao
 * Created by Houben on 2018/4/5
 * Description:VIP数据访问接口，提供
 * 添加，删除，查询vip会员的功能
 */
public interface VIPDao {
    /**
     * 商家添加会员顾客
     *
     * @param VIP 将要添加的会员顾客
     */
    void addVIP(VIP VIP);

    /**
     * 商家删除vip顾客
     *
     * @param VIP 将要被删除的vip
     */
    void deleteVIP(VIP VIP);

    /**
     * 根据姓名信息查询vip信息
     *
     * @param cname 表示查询所依据的姓名信息
     * @return 返回符合姓名查询的vip列表
     */
    List<VIP> queryVIPByName(String cname);

    /**
     * 根据电话查询vip信息
     *
     * @param phone 表示查询所一局的电话号
     * @return 返回符合按照电话查询返回的VIP列表
     */
    List<VIP> queryVIPByPhone(String phone);

    /**
     * 用户更改用户名
     *
     * @param phone 需要更改的用户主键（phone）
     * @param cname 需要更改的名字
     * @return 修改数据库的行数
     */
    int changeName(@Param("phone") String phone, @Param("cname") String cname);
}
