package web.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import web.util.CallProtectRunnable;
import web.util.CallProtectThreadLocal;
import web.util.DelayThreadPool;

/**
 * @author lwz
 * @Description
 * @Date: 22:21 2019-08-20
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Aspect
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
	@Around(value = "@annotation(localRetry)")
	public Object aroundCut(ProceedingJoinPoint joinPoint, LocalRetry localRetry) throws Throwable{
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			log.error("callProtect LocalRetryHanlder get error, e=" + e.getMessage());

			if(CallProtectThreadLocal.get() == null || !CallProtectThreadLocal.get()){
				String[] typeS = localRetry.argsClassName();
				Class[] classes = new Class[typeS.length];
				for (int i = 0; i < typeS.length; i++) {
					classes[i] = Class.forName(typeS[i]);
				}
				Object[] args = joinPoint.getArgs();
				DelayThreadPool.pool.execute(
						new CallProtectRunnable("_n".equals(localRetry.beanName()) ? joinPoint.getSignature().getDeclaringTypeName() : localRetry.beanName(), joinPoint.getSignature().getName(), classes, args,
								localRetry.gapSec(), 1, localRetry.maxRetry()));
			}

			if(!localRetry.catched()){
				throw e;
			} else {
				CallProtectThreadLocal.remove();
			}
		}
		return obj;
	}

}
