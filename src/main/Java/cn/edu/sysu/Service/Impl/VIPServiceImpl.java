package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.VIPDao;
import cn.edu.sysu.Entity.VIP;
import cn.edu.sysu.Service.VIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by Houben on 2018/4/17
 * Description:业务层接口的实现类
 * 实现会员管理中的增加会员，删除会员，查询会员，会员姓名信息更改的功能
 */
@Service
public class VIPServiceImpl implements VIPService {

    @Autowired
    private VIPDao vipDao;

    @Override
    public String addVIP(VIP VIP) {
        try{
            vipDao.addVIP(VIP);
        }catch(Exception e){
            return "新增会员失败，请联系管理员";
        }

        return "会员新增成功";
    }

    @Override
    public String deleteVIP(VIP VIP) {
        try{
            vipDao.deleteVIP(VIP);
        }catch(Exception e){
            return "会员删除失败，请联系管理员";
        }
        return "会员已成功删除";
    }

    @Override
    public List<VIP> queryVIPByName(String cname) {
        List<VIP> result = new ArrayList<>();
        try{
            result = vipDao.queryVIPByName(cname);
        }catch(Exception e){
            return result;
        }
        return result;
    }

    @Override
    public VIP queryVIPByPhone(String phone) {
        VIP result = new VIP();
        try{
            result = vipDao.queryVIPByPhone(phone);
        }catch (Exception e){
            return result;
        }
        return result;
    }

    @Override
    public String changeName(String phone, String cname) {
        try{
            vipDao.changeName(phone, cname);
        }catch(Exception e){
            return "会员姓名更改失败，请联系管理员";
        }
        return "会员姓名更改已完成";
    }
}
