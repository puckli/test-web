package web.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -2126594539793638037L;

    public static final String ERROR = "-1";

    // 错误代码
    private String code;
    private String msg;
    private Object data;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        this(ERROR, message);
    }

    public BusinessException(String errorCode, String message) {
        super(message);
        this.code = errorCode;
    }

    public BusinessException(String message, Throwable cause) {
        // 利用通用错误代码
        this(ERROR, message, cause);
    }

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.code = errorCode;
    }

}
