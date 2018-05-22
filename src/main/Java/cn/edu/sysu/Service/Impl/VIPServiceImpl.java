package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.VIPDao;
import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.VIP;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Exception.VIPException;
import cn.edu.sysu.Service.VIPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by Houben on 2018/4/17
 * Description:业务层接口的实现类。
 * 实现会员管理中的增加会员，删除会员，
 * 查询会员，会员姓名信息更改的功能。
 */
@Service
public class VIPServiceImpl implements VIPService {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VIPDao vipDao;

    @Override
    @Transactional
    public OperationStatus addVIP(VIP vip) throws KTVException {
        try {
            if (vipDao.queryVIPByName(vip.getCname()) != null) {
                throw new VIPException("该会员名已注册！");
            }
            if (vipDao.queryVIPByPhone(vip.getPhone()) != null) {
                throw new VIPException("该电话号码已被注册！");
            }
            vipDao.addVIP(vip);
            return new OperationStatus("新增会员成功！");
        } catch (VIPException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus deleteVIP(String cname) throws KTVException {
        try {
            if (vipDao.queryVIPByName(cname) == null) {
                throw new VIPException("该会员名未注册！");
            }
            vipDao.deleteVIP(cname);
            return new OperationStatus("删除会员成功！");
        } catch (VIPException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    public List<VIP> queryAllVIP() {
        return vipDao.queryAllVIP();
    }

    @Override
    public VIP queryVIPById(int id) {
        return vipDao.queryVIPById(id);
    }

    @Override
    public VIP queryVIPByName(String cname) {
        return vipDao.queryVIPByName(cname);
    }

    @Override
    public VIP queryVIPByPhone(String phone) {
        return vipDao.queryVIPByPhone(phone);
    }

    @Override
    @Transactional
    public OperationStatus changeName(int id, String cname) throws KTVException {
        try {
            if (vipDao.queryVIPById(id).getCname().equals(cname)) {
                throw new VIPException("新用户名与原用户名相同！");
            }
            vipDao.changeName(id, cname);
            return new OperationStatus("会员姓名更改成功！");
        } catch (VIPException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

}
