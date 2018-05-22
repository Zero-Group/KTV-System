package cn.edu.sysu.Entity;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by Houben on 2018/4/5
 * Description:VIP实体类，包含cname，phone信息
 * 并提供set，get，tostring等方法
 */
public class VIP {

    private int id;
    private String cname;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "VIP{" +
                "cname='" + cname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
