package web.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import web.domain.HttpResult;
import web.util.BusinessException;

/**
 * @author lwz
 * @Description aop test，need @EnableAspectJAutoProxy
 * ("execution(* web..*(..))") // 切点表达式
 * @Date: 15:47 2019-02-15
 */
@Component
@Aspect
public class MyExceptionHandler {

	/**
	 * 定义一个复用切点
	 */
	@Pointcut("@annotation(ExceptionPointCut)")
	public void myPointCut(){}

	@AfterThrowing(value = "execution(* web..*(..))", throwing = "a")
	public Object handleException(Throwable a){
		System.out.println("Aspect in handException");

		return JSONObject.toJSONString(HttpResult.fail());
	}

	/**
	 * 与@ResponseBody共同使用时，返回自定义对象可能报错，需要对应jackson版本才行
	 * @param joinPoint
	 * @return
	 */
	@Around("myPointCut()")
	public HttpResult aroundCut(ProceedingJoinPoint joinPoint){
		System.out.println("Aspect in aroundCut");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (BusinessException | IllegalArgumentException e) {
			System.out.println("Aspect aroundCut, BusinessException | IllegalArgumentException =" + e.getMessage());
			return HttpResult.fail(e.getMessage());
		} catch (Throwable throwable) {
			System.out.println("Aspect aroundCut e=" + throwable);
			// 发生异常后返回特定内容
			return HttpResult.fail("操作异常");
		}
		System.out.println("Aspect end aroundCut");
		return (HttpResult) obj;
	}
}
