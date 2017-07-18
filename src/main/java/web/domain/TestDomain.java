package web.domain;

public class TestDomain extends BaseDomain{

	private String name;
	private String desc;

	public String getName() {
		return name;
	}

	public TestDomain setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public TestDomain setDesc(String desc) {
		this.desc = desc;
		return this;
	}

}
