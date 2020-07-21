package com.webcomm.test;

public enum EnumTest {
	SUN("sunday", 1),
	MON("Monday", 2),
	TUE("Tuesday", 3);
	EnumTest(String day, Integer number) {
		this.day = day;
		this.number = number;
	}
	
	private final String day;
	private final Integer number;
	public String getDay() {
		return day;
	}
	public Integer getNumber() {
		return number;
	}
	
	public static EnumTest getEnumTest(Integer i) {
		for(EnumTest enumtest : EnumTest.values()) {
			if(enumtest.getNumber() == i) {
				return enumtest;
			}
		}
	
		return null;
	}
	
}
	