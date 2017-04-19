package cn.edu.exception;

/**
 * 自定义异常
 * @author wangfang
 *
 */
public class UserExistException extends Exception {
    public UserExistException() {
        super();
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

}
