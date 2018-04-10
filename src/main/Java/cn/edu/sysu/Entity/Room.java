package cn.edu.sysu.Entity;

import java.util.Date;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by lihan on 2018/4/7
 * Description: Room的实体类，Room包含id，type，
 * status，startTime，endTime等信息，提供对应的
 * get()、set()方法以及toString方法。
 */
public class Room {

    private int id;
    private String type;
    private int status;
    private Date startTime;
    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
