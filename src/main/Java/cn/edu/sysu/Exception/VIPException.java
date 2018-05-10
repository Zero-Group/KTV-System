package cn.edu.sysu.Exception;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Exception
 * Created by lihan on 2018/5/7
 * Description: VIP相关操作的运行时异常
 */
public class VIPException extends KTVException {

    public VIPException(String message) {
        super(message);
    }

    public VIPException(String message, Throwable cause) {
        super(message, cause);
    }

}
