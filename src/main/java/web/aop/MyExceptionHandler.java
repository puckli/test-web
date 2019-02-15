package web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lwz
 * @Description aop test
 * @Date: 15:47 2019-02-15
 */
@Component
@Aspect
public class MyExceptionHandler {

	/**
	 * 定义一个切点
	 */
	@Pointcut("@annotation(NeedExceptionHandle)")
	public void myPointCut(){}

	@AfterThrowing("execution(* web..*(..))")
	public void handleException(){
		System.out.println("Aspect in handException");
	}

	@Around("myPointCut()")
	public Object aroundCut(ProceedingJoinPoint joinPoint){
		System.out.println("Aspect in aroundCut");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable throwable) {
			System.out.println("Aspect aroundCut e=" + throwable);
			throwable.printStackTrace();
			// 发生异常后返回特定内容
			return "exception cause";
		}
		System.out.println("Aspect end aroundCut");
		return obj;
	}
}
