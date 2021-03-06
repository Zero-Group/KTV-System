package cn.edu.sysu.Exception;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Exception
 * Created by lihan on 2018/5/9
 * Description: Food相关操作的运行时异常
 */
public class FoodException extends KTVException {

    public FoodException(String message) {
        super(message);
    }

    public FoodException(String message, Throwable cause) {
        super(message, cause);
    }

}
