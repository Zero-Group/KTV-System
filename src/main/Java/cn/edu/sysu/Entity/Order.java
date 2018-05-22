package cn.edu.sysu.Entity;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by Houben on 2018/4/10
 * Description:Order实体类，Order包含
 * 包含id，room，cname，phone，price，
 * pay，detail等信息，以及对上述信息的
 * get，set方法和toString方法
 */
public class Order {

    private int id;
    private String room;
    private String cname;
    private String phone;
    private int price;
    private int pay;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "room='" + room + '\'' +
                ", cname='" + cname + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", pay=" + pay +
                ", detail='" + detail + '\'' +
                '}';
    }
}
