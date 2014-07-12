package com.language.model;

public class Variable {
	private String name = null;
	private Integer type = null;
	private Object value = null;

	public Variable() {}

	public Variable(String name, Integer type, Object value) {
		this.name 	= name;
		this.type 	= type;
		this.value 	= value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
