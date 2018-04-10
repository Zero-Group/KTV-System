package cn.edu.sysu.Entity;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by lihan on 2018/4/6
 * Description: Food的实体类，Food包含fname，
 * price，stock等信息，提供对应的get()、set()
 * 方法以及toString方法。
 */
public class Food {

    private String fname;
    private double price;
    private int stock;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Food{" +
                "fname='" + fname + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
