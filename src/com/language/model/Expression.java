package com.language.model;

import java.util.ArrayList;
import java.util.List;

public class Expression {

	private Object value;
	private Expression left;
	private Expression right;
	
	public Expression(Object value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Expression(Object value, Expression left, Expression right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getLeft() {
		return left;
	}
	
	public void setLeft(Expression left) {
		this.left = left;
	}
	
	public Object getRight() {
		return right;
	}
	
	public void setRight(Expression right) {
		this.right = right;
	}
	
	public String evaluateType(){
		return "string";
	}

	public String evaluate(){
		if(this.value == "+"){
			Integer int_value = new Integer(left.evaluate()) + new Integer(right.evaluate());
			return int_value.toString();
		} else {
			return (String)this.value;
		}
	}
	
	public String toString() {
		return this.toString(0);
	}

	public String toString(int level) {
		StringBuffer sb = new StringBuffer();

		String tab = "";
		for (int i = 0; i < level; i++) {
			tab += "  ";
		}

		sb.append(tab);
		sb.append(this.value);

		Expression l = this.left;
		if(l != null){
			sb.append("(\n");

			String exptext = l.toString(level + 1);
			sb.append(exptext);

			Expression r = this.right;
			if(r != null){
				exptext = r.toString(level + 1);
				sb.append(exptext);
			} else {
				sb.append("\n");
			}

			if(l != null){
				sb.append(tab);
				sb.append(")");
			}
		}

		sb.append("\n");
		return sb.toString();
	}
}
