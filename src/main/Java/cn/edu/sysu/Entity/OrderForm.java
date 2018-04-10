package cn.edu.sysu.Entity;

import java.util.Date;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by Houben on 2018/4/10
 * Description:OrderForm实体类
 * 包含oid（订单号）, vipphone（下单VIP的手机号信息）, Price（该订单价格）, orderTime（下单时间） ,pay（是否已经付费）的信息
 * 对上述信息的get，set方法
 * 以及toString方法
 */
public class OrderForm {

    private String vipphone;
    private int Price;
    private Date orderTime;
    private int pay;
    private String detail;
    private String room;

    public String getVipphone() {
        return vipphone;
    }

    public void setVipphone(String vipphone) {
        this.vipphone = vipphone;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "vipphone='" + vipphone + '\'' +
                ", Price=" + Price +
                ", orderTime=" + orderTime +
                ", pay=" + pay +
                ", detail='" + detail + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
