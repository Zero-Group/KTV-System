package cn.edu.sysu.Entity;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by lihan on 2018/6/1
 * Description: 订单条目明细
 */
public class OrderDetail {

    private String name;
    private double unitPrice;
    private int number;
    private double totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
