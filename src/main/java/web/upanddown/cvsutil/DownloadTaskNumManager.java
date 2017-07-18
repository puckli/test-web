package web.upanddown.cvsutil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * export instance control
 * @author lwz
 * @since 2016-05-25
 */
public class DownloadTaskNumManager {
	private static DownloadTaskNumManager mInstance = null;
	private AtomicInteger mTaskNum = new AtomicInteger(0);
	private int mMaxTaskNum = 2;

	private DownloadTaskNumManager(int maxTaskSize) {
		this.mMaxTaskNum = maxTaskSize;
	}

	public static DownloadTaskNumManager GetInst() {
		final int MAX_TASK_NUM = 5;
		if (DownloadTaskNumManager.mInstance == null) {
			DownloadTaskNumManager.mInstance = new DownloadTaskNumManager(MAX_TASK_NUM);
		}

		return DownloadTaskNumManager.mInstance;
	}

	public boolean incrementNum() {
		synchronized (DownloadTaskNumManager.class) {
			int taskNum = this.mTaskNum.incrementAndGet();
			if (taskNum > this.mMaxTaskNum) {
				return false;
			} else {
				return true;
			}
		}
	}

	public void decrementNum() {
		synchronized (DownloadTaskNumManager.class) {
			this.mTaskNum.decrementAndGet();
		}
	}
}
