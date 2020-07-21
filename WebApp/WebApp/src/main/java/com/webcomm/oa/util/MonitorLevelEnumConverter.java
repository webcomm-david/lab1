package com.webcomm.oa.util;

import javax.persistence.AttributeConverter;

import com.webcomm.oa.data.CaseMonitorLevelEnum;

public class MonitorLevelEnumConverter implements AttributeConverter<CaseMonitorLevelEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(CaseMonitorLevelEnum attribute) {
		return attribute.getNumber();
	}

	@Override
	public CaseMonitorLevelEnum convertToEntityAttribute(Integer dbData) {
		return CaseMonitorLevelEnum.fromValue(dbData);
	}

}
