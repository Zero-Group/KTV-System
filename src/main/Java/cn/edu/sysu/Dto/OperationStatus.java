package cn.edu.sysu.Dto;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dto
 * Created by lihan on 2018/5/7
 * Description: Service层各种操作的返回结果
 */
public class OperationStatus {

    private String message;

    public OperationStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
