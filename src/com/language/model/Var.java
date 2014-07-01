package com.language.model;

public class Var {
	private Object value;
	private String name;
	private String type;
	private Boolean scope;

	public Var() {
		this.scope = true;
	}
	
	public Var(Object value, String name, String type) {
		this.value = value;
		this.name = name;
		this.type = type;
		this.scope = false;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Boolean getScope() {
		return scope;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.name);
		sb.append(" - ");
		sb.append(this.value);
		sb.append(" - ");
		sb.append(this.type);
		
		return sb.toString();
	}
}
