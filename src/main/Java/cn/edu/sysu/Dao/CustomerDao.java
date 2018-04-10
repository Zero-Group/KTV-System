package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Customer;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dao
 * Created by lihan on 2018/4/5
 * Description: Customer的数据访问层接口，
 * 提供向数据库中添加Customer的方法。
 */
public interface CustomerDao {

    /**
     * 向数据库中添加顾客
     *
     * @param customer 将要添加的顾客
     */
    void addCustomer(Customer customer);

}
