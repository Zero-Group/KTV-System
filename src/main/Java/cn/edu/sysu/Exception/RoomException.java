package cn.edu.sysu.Exception;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Exception
 * Created by lihan on 2018/5/9
 * Description: Room 相关操作的运行时异常
 */
public class RoomException extends KTVException {

    public RoomException(String message) {
        super(message);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }

}
