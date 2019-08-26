package web.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwz
 * @Description
 * @Date: 19:31 2019-08-20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalRetry {

	/** 当前bean name,Spring容器中可以通过此name获取到bean对象 */
	String beanName() default "_n";

	/** 最大重试次数 */
	int maxRetry() default 3;

	/** 间隔时间 */
	int gapSec() default  10;

	Class retryClazz() default Throwable.class;

	/** 是否将异常捕获，true时捕获异常，返回null */
	boolean catched() default false;

	/** 此方法参数类型数组，如new Class[]{"org.springframework.ui.Model", "java.lang.String"} */
	String[] argsClassName() ;
}
