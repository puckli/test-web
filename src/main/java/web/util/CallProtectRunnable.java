package web.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author lwz
 * @Description 重试线程
 * @Date: 10:58 2019-08-22
 */
@Slf4j
public class CallProtectRunnable implements Runnable, Delayed{
	String beanName;
	String methodName;
	Class[] clzs;
	Object[] args;
	long time;
	long timeSec;
	int cnt = 0;
	int maxRetry = 3;

	/**
	 *
	 * @param beanName
	 * @param methodName
	 * @param clzs
	 * @param args
	 * @param time 重试时间间隔
	 * @param cnt
	 */
	public CallProtectRunnable(String beanName, String methodName, Class[] clzs, Object[] args, long time, int cnt, int maxRetry){
		this.timeSec = time;
		this.time = TimeUnit.MILLISECONDS.convert(time, TimeUnit.SECONDS) + System.currentTimeMillis();
		this.cnt = cnt;
		this.beanName = beanName;
		this.methodName = methodName;
		this.clzs = clzs;
		this.args = args;
		this.maxRetry = maxRetry;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		return time > o.getDelay(TimeUnit.MILLISECONDS) ? 1 : 0;
	}

	@Override
	public void run() {
		Object result = null;
		try{
			log.info("CallProtectRunnable in. beanName={},methodName={},maxRetry={},cnt={},pool activating thread={}",  beanName, methodName, maxRetry, cnt, DelayThreadPool.pool.getActiveCount());
			Object bean = SpringBeanContextUtil.get(beanName);
			if(bean != null){
				Class clazz2 = bean.getClass();
				Method method = clazz2.getDeclaredMethod(methodName, clzs);

				result = method.invoke(bean, args);
				log.info("CallProtectRunnable redo success, beanName={},methodName={},param={},result={}", beanName, methodName, args, result);
			} else {
				log.error("CallProtectRunnable redo fail, can't find bean,beanName={},methodName={}", beanName, methodName);
			}

		} catch (Exception e){
			log.error("CallProtectRunnable redo fail, beanName={},methodName={},param={},cnt={}, e={}", beanName, methodName, args, cnt, e);
			try {
				if(cnt <= maxRetry){
					this.time = TimeUnit.MILLISECONDS.convert(timeSec, TimeUnit.SECONDS) + System.currentTimeMillis();
					++this.cnt;
					DelayThreadPool.pool.execute(this);
				} else {
					//TODO Monitor
					log.error("CallProtectRunnable error. beanName={},methodName={},queue size={}, e={}", beanName, methodName, DelayThreadPool.queue.size(), e);
				}
			} catch (Exception e1){
				e1.printStackTrace();
			}
		}
	}
}
