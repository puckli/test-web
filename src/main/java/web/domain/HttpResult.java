package web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lwz
 * @Description
 * @Date: 17:58 2019-02-18
 */
@Setter
@Getter
@Builder
public class HttpResult<T> implements Serializable {

	private String code;
	private String message;
	private T data;

	private static String COMMON_FAIL = "-1";
	private static String SUCCESS = "0000";

	public static HttpResult fail(){
		return HttpResult.builder().code(COMMON_FAIL).message("fail").build();
	}

	public static HttpResult fail(String msg){
		return HttpResult.builder().code(COMMON_FAIL).message(msg).build();
	}

	public static HttpResult success(){
		return HttpResult.builder().code(SUCCESS).message("success").build();
	}

	public static <T> HttpResult success(T data){
		return HttpResult.builder().code(SUCCESS).message("success").data(data).build();
	}

	public static HttpResult create(String code){
		return HttpResult.builder().code(code).message("fail").build();
	}

	public static HttpResult create(String code, String message){
		return HttpResult.builder().code(code).message(message).build();
	}

	public boolean isSuccess(){
		return SUCCESS.equals(this.code);
	}

}
