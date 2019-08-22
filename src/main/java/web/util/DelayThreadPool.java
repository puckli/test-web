package web.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lwz
 * @Description 延迟线程池
 * @Date: 10:03 2019-08-22
 */
@Slf4j
public class DelayThreadPool {
	/** 延迟队列 */
	public static DelayQueue queue = new DelayQueue<>();
	public static ThreadPoolExecutor pool = new ThreadPoolExecutor(2,2, 0L, TimeUnit.MILLISECONDS, queue);
	static {
		pool.prestartAllCoreThreads();
	}
	public static ThreadPoolExecutor getPool(){
		return pool;
	}

	public static void execute(Runnable runnable){
		if(pool == null){
			pool = new ThreadPoolExecutor(2,2, 0L, TimeUnit.MILLISECONDS, queue);
		}
		pool.execute(runnable);
	}
}
