package web.util;
/**
 */
public class BusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -2126594539793638037L;

    // 默认错误代码
    public static final String GENERIC = "0000";

    // 错误代码
    private String errorCode;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        this(GENERIC, message);
    }

    public BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause) {
        // 利用通用错误代码
        this(GENERIC, message, cause);
    }

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
