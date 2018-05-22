package cn.edu.sysu.Exception;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Exception
 * Created by lihan on 2018/5/9
 * Description: OrderForm相关操作的运行时异常
 */
public class OrderException extends KTVException {

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

}
