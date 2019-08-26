package web.util;

/**
 * @author lwz
 * @Description
 * @Date: 16:13 2019-08-26
 */
public class CallProtectThreadLocal {

	private static final ThreadLocal<Boolean> holder = new ThreadLocal();

	private CallProtectThreadLocal(){
		holder.set(false);
	}

	public static void remove() {
		holder.remove();
	}

	public static Boolean get(){
		return holder.get();
	}

	public static void set(){
		holder.set(true);
	}
}
