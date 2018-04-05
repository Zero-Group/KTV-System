package cn.edu.sysu.Entity;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by lihan on 2018/4/5
 * Description: Customer的实体类，Customer包含
 *              id信息，提供对应的get、set方法以
 *              及toString方法。
 */
public class Customer {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
