package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.VIP;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dao
 * Created by Houben on 2018/4/5
 * Description:
 */
public interface VIPDao {
    /**
     * 商家添加会员顾客
     * @param VIP 将要添加的会员顾客
     */
    void addVIP(VIP VIP);

    void deleteVIP(VIP VIP);

    List<VIP> queryVIPByName(String cname);

    List<VIP> queryVIPByPhone(String phone);
}
