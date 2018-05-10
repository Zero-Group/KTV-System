package cn.edu.sysu.Exception;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Exception
 * Created by lihan on 2018/5/9
 * Description: OrderForm相关操作的运行时异常
 */
public class OrderFormException extends KTVException {

    public OrderFormException(String message) {
        super(message);
    }

    public OrderFormException(String message, Throwable cause) {
        super(message, cause);
    }

}
