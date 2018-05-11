package cn.edu.sysu.Entity;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Entity
 * Created by lihan on 2018/5/10
 * Description: 系统管理员，用于验证
 * 登录KTV管理系统。
 */
public class Manager {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
