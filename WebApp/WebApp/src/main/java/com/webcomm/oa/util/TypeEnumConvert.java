package com.webcomm.oa.util;

import javax.persistence.AttributeConverter;

import com.webcomm.oa.data.CaseTypeEnum;

public class TypeEnumConvert implements AttributeConverter<CaseTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CaseTypeEnum attribute) {
		return attribute.getData();
	}

	@Override
	public CaseTypeEnum convertToEntityAttribute(Integer dbData) {
		return CaseTypeEnum.fromValue(dbData);
	}

}
