package com.language.model;

import java.util.ArrayList;

import com.language.model.expression.Expression;

public class Var {
	private Object value;
	private String name;
	private Boolean scope;

	public Var() {
		this.scope = true;
	}
	
	public Var(Object value, String name) {
		this.value = value;
		this.name = name;
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
	
	public Boolean getScope() {
		return scope;
	}
}
