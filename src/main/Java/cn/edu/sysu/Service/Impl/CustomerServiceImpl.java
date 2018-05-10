package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.CustomerDao;
import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Customer;
import cn.edu.sysu.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by lihan on 2018/4/14
 * Description: Customer业务层接口的实现类，
 * 实现了增加一个顾客和删除所有顾客的方法。
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerDao customerDao;

    @Override
    public OperationStatus addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
        return new OperationStatus("新增顾客成功！");
    }

    @Override
    public OperationStatus deleteAllCustomer() {
        customerDao.deleteAllCustomer();
        return new OperationStatus("删除所有顾客成功！");
    }

}
