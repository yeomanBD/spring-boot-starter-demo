package com.mlbd.springstarterdemo.commons.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Label {
	
	L1(1), L2(2), L3(3), L4(4);
	
	int value;
	
	Label (int value) {
		this.value = value;
	}
	
	@JsonValue
	private int getValue() {
		return this.value;
	}
}
