package web.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus 的使用范例，Controller抛出此异常时，返回404状态码
 */
@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "resource not found")
public class NotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -2126594539793638037L;

    public static final String ERROR = "-1";

    // 错误代码
    private String code;
    private String msg;
    private Object data;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        this(ERROR, message);
    }

    public NotFoundException(String errorCode, String message) {
        super(message);
        this.code = errorCode;
    }

    public NotFoundException(String message, Throwable cause) {
        // 利用通用错误代码
        this(ERROR, message, cause);
    }

    public NotFoundException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.code = errorCode;
    }

}
