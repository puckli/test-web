package web.domain.enums;

/**
 * @author lwz
 * @Description
 * @Date: 13:31 2019-10-17
 */
public enum StatusEnum {
	WAIT_RETRY(1, "待重试"),
	RETRY_SUCCESS(2, "重试成功"),
	RETRY_FAIL(3, "重试失败"),
	RECORD(4, "仅记录"),
	SYS_BAND(5, "系统禁用"),
			;


	private int key;
	private String value;

	StatusEnum(int key, String value){
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static String getValueByKey(int key){
		for (StatusEnum anEnum : StatusEnum.values()) {
			if(anEnum.getKey() == key){
				return anEnum.getValue();
			}
		}
		return null;
	}
}
