package com.language.model.declaration;

import java.util.ArrayList;
import java.util.List;

public class Declaration {

	private Object value; 
	private List<Declaration> arguments;
	
	public Declaration(Object value) {
		this.value = value;
		this.arguments = new ArrayList<Declaration>();
	}
	
	public Declaration(Object value, List<Declaration> arguments) {
		this.value = value;
		this.arguments = arguments;
		if (this.arguments == null) {
			this.arguments = new ArrayList<Declaration>();
		}
	}
	
	public Declaration(Object value, Declaration left, Declaration right) {
		this.value = value;
		this.arguments = new ArrayList<Declaration>();
		this.arguments.add(left);
		this.arguments.add(right);
	}

	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public List<Declaration> getArguments() {
		return arguments;
	}
	
	public void setArguments(List<Declaration> arguments) {
		this.arguments = arguments;
	} 

	public String toString() {
		return this.toString(0);
	}

	public String toString(int level) {
		StringBuffer sb = new StringBuffer();
		
		String tab = "";
		for (int i = 0; i < level; i++) {
			tab += "   ";
		}
		
		sb.append(tab);
		sb.append(this.value);
		
		if (this.arguments.size() > 0) {
			sb.append("(\n");
	
			for (int i = 0; i < this.arguments.size(); i++) {
				Declaration exparg = this.arguments.get(i);
				if (exparg == null) {
					sb.append("\n");
				} else {
					String exptext = exparg.toString(level + 1);
					sb.append(exptext);
				}
			}
			
			sb.append(tab);
			sb.append(")");
		} 
		
		sb.append("\n");
		
		return sb.toString();
	}
}
