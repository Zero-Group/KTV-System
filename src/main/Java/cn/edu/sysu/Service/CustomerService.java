package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.Customer;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by lihan on 2018/4/14
 * Description: Customer业务层接口，提供
 * 增加一个顾客和删除所有顾客的方法。
 */
public interface CustomerService {

    /**
     * 顾客订房时，商家增加一个顾客
     *
     * @param customer 将要增加的顾客
     */
    void addCustomer(Customer customer);

    /**
     * 商家清理数据库时，删除所有顾客信息
     *
     * @return 返回删除的结果
     */
    String deleteAllCustomer();

}
