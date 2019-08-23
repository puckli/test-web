package web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import web.util.CallProtectRunnable;
import web.util.DelayThreadPool;

/**
 * @author lwz
 * @Description
 * @Date: 22:21 2019-08-20
 */
@Component
@Slf4j
public class LocalRetryHanlder {

	/**
	 * LocalRetry切点
	 */
	@Pointcut("@annotation(LocalRetry)")
	public void localRetryPointCut(){}

	/**
	 * 与@ResponseBody共同使用时，返回自定义对象可能报错? 需要对应jackson版本才行
	 * @param joinPoint
	 * @return
	 */
	@Around("localRetryPointCut()&&@annotation(localRetry)")
	public Object aroundCut(ProceedingJoinPoint joinPoint, LocalRetry localRetry) throws Throwable{
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			log.error("callProtect LocalRetryHanlder get error, e=" + e);

			String[] typeS = localRetry.argsClassName();
			Class[] classes = new Class[typeS.length];
			for (int i = 0; i < typeS.length; i++) {
				classes[i] = Class.forName(typeS[i]);
			}
			Object[] args = joinPoint.getArgs();
			DelayThreadPool.pool.execute(
					new CallProtectRunnable(localRetry.beanName(), joinPoint.getSignature().getName(), classes, args,
							localRetry.gapSec(), 1, localRetry.maxRetry()));

			if(!localRetry.catched()){
				throw e;
			}
		}
		return obj;
	}

}
