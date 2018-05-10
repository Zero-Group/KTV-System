package cn.edu.sysu.Exception;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Exception
 * Created by lihan on 2018/5/7
 * Description: KTV系统的运行时异常
 */
public class KTVException extends RuntimeException {

    public KTVException(String message) {
        super(message);
    }

    KTVException(String message, Throwable cause) {
        super(message, cause);
    }

}
