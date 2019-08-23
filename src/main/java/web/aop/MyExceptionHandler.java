package web.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import web.domain.HttpResult;
import web.util.BusinessException;
import web.util.CallProtectRunnable;
import web.util.DelayThreadPool;

/**
 * @author lwz
 * @Description aop test，need @EnableAspectJAutoProxy
 * ("execution(* web..*(..))") // 切点表达式
 * @Date: 15:47 2019-02-15
 */
@Component
@Aspect
@Slf4j
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
	@Around("myPointCut()&&@annotation(exceptionPointCut)")
	public Object aroundCut(ProceedingJoinPoint joinPoint, ExceptionPointCut exceptionPointCut){
		Signature sig = joinPoint.getSignature();
		log.info("{},method={},param={},getDeclaringTypeName={}", sig.getDeclaringType(), sig.getName(), joinPoint.getArgs(), sig.getDeclaringTypeName());
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (BusinessException | IllegalArgumentException e) {
			log.error("ExceptionHandler, BizException | IllegalArgumentException =" + e.getMessage());
			return HttpResult.fail(e.getMessage());
		} catch (Throwable throwable) {
			log.error("ExceptionHandler error, e=" + throwable);
			return HttpResult.fail("操作异常");
		}
		log.debug("ExceptionHandler aroundCut end");
		return obj;
	}

	/**
	 * 切点
	 */
	@Pointcut("@annotation(LocalRetry)")
	public void localRetryPointCut(){}

	/**
	 * 与@ResponseBody共同使用时，返回自定义对象可能报错，需要对应jackson版本才行
	 * @param joinPoint
	 * @return
	 */
	@Around("localRetryPointCut()&&@annotation(localRetry)")
	public Object aroundCut(ProceedingJoinPoint joinPoint, LocalRetry localRetry) throws Throwable{
		Signature sig = joinPoint.getSignature();
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			log.error("LocalRetryHanlder error, e=" + e);

			if(localRetry.retryClazz().equals(Throwable.class))
			{
				System.out.println("1");
			}

			Object[] args = joinPoint.getArgs();
			String[] typeS = localRetry.argsClassName();
			Class[] classes = new Class[typeS.length];
			for (int i = 0; i < typeS.length; i++) {
				classes[i] = Class.forName(typeS[i]);
			}
			DelayThreadPool.execute(
					new CallProtectRunnable(localRetry.beanName(), sig.getName(), classes, args,
							localRetry.gapSec(), 0, localRetry.maxRetry()));
			log.error("LocalRetryHanlder in DelayThreadPool");
			throw e;
		}
		return obj;
	}
}
