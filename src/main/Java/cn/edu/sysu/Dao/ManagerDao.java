package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Manager;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dao
 * Created by lihan on 2018/5/10
 * Description: 系统管理员的数据访问层接口
 */
public interface ManagerDao {

    Manager getManager(String username);

}
