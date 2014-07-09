package com.language.model;

public class ConsoleLog {
	private Object value;
	
	public ConsoleLog(Object value) {
		this.value = value;
	}
	
	public void execute(){
		System.out.println(this.value);
	}
	
}
