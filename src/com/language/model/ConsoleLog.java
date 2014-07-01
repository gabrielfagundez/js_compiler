package com.language.model;

public class ConsoleLog {
	private String value;
	
	public ConsoleLog(String value) {
		this.value = value;
	}
	
	public void execute(){
		System.out.println(this.value);
	}
	
}
