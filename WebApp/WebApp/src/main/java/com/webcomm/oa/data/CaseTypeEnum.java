package com.webcomm.oa.data;

public enum CaseTypeEnum {
	Default_ALL(0, "全部"),
	General(1, "總綱目"),
	TempControl(2, "臨時總管"),
	NoControl(3, "非列管(原A類案件");
	
	CaseTypeEnum(Integer data, String type) {
		this.data = data;
		this.type = type;
	}
	
	private Integer data;
	private String type;
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static CaseTypeEnum fromValue(Integer value) {
		for(CaseTypeEnum caseTypeEnum : CaseTypeEnum.values()) {
			if(caseTypeEnum.data == value) {
				return caseTypeEnum;
			}
		}
		return null;
	}
}
