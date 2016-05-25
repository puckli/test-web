package web.domain;

import web.upanddown.cvsutil.CsvUtil;

public class CVSDomain extends BaseDomain{

	private String name;
	private String desc;

	public String getName() {
		return name;
	}

	public CVSDomain setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public CVSDomain setDesc(String desc) {
		this.desc = desc;
		return this;
	}
	
	
	public String csvString() {
		StringBuilder sb = new StringBuilder(300);
		sb.append(getName() == null ? "" : warpForCSV(getName()))
				.append(CsvUtil.CSV_SEP)
				.append(getDesc() == null ? "" : warpForCSV(getDesc()))
				.append(CsvUtil.CSV_SEP);
				
		return sb.toString();
	}
	
	// 处理内容中带有表格分割符“,”的情况
	public String warpForCSV(String str){
		return "\"=\"\"" + str + "\"\"\"";
	}

}
