package com.webcomm.oa.data;

public enum CaseMonitorLevelEnum {
	Default_ALL(0, "全部"),
	ReportForControl(1, "報部列管"),
	DeptControl(2, "科室列管"),
	BureauControl(3, "列管局"),
	NoControl(4, "不列管");
	private Integer number;
	private String monitorLevel;
	
	public Integer getNumber() {
		return number;
	}
	public String getMonitorLevel() {
		return monitorLevel;
	}
	CaseMonitorLevelEnum(Integer number, String monitorLevel) {
		this.number = number;
		this.monitorLevel = monitorLevel;
	}
	public static CaseMonitorLevelEnum fromValue(Integer value) {
		for(CaseMonitorLevelEnum caseMonitorLevelEnum : CaseMonitorLevelEnum.values()) {
			if(caseMonitorLevelEnum.number == value) {
				return caseMonitorLevelEnum;
			}
		}
		return null;
	}
	
}
