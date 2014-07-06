package com.language.model;

import java.lang.Math;
public class Expression {

	private Object value;
	private Expression left;
	private Expression right;
	private String type;
	
	public Expression(Object value, String type) {
		switch(type){
			case "Boolean":
				this.value =  new Boolean((String)value);
				break;
			case "Integer":
				this.value =  new Integer((String)value);
				break;
			case "Float":
				this.value =  new Float((String)value);
				break;
			case "String":	
				this.value =  new String(((String)value).substring(1, ((String)value).length() - 1));
				break;
			default:
				this.value =  new String((String)value);
				break;
		}
		this.left = null;
		this.right = null;
		this.type = type;
	}
	
	public Expression(Object value, Expression left, Expression right) {
		this.value = value;
		this.left = left;
		this.right = right;
		evaluateType();
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
	
	public String getType() {
		return type;
	}
	
	public void evaluateType(){
		if(this.value=="+"){
			if(this.left.type=="String" || this.right.type=="String"){
				this.type = "String";
			}else if (this.left.type=="Float" || this.right.type=="Float"){
				this.type = "Float";
			}else {
				this.type = "Integer";
			}
		}else if ((this.value=="-") || (this.value=="*") || (this.value=="/")){
			if (this.left.type=="String" || this.right.type=="String"){
				this.type = "NaN";
			}else if (this.left.type=="Float" || this.right.type=="Float"){
				this.type = "Float";
			}else{
				this.type = "Integer";
			}
		}else if (this.value=="&&"){
			if (this.left.isFalse()){
				this.type = this.left.type;
			}else{
				this.type = this.right.type;
			}			
		}else if ((this.value=="||")){
			if (this.left.isTrue()){
				this.type = this.left.type;
			}else{
				this.type = this.right.type;
			}			
		}else if ((this.value=="==") || (this.value=="!=")|| (this.value=="<=") || 
				(this.value==">=") || (this.value=="<") || (this.value==">")){
			this.type = "Boolean";
		}
	}

	public boolean isTrue(){
		if (this.type=="Integer" || this.type == "Float"){
			return (Integer)this.evaluate()>0;
		} else if (this.type=="Boolean"){
			return (Boolean)this.evaluate();
		} else if (this.type=="String"){
			return ((String)this.evaluate()).length()>0;
		} else {
			return false;
		}
	}
	
	public boolean isFalse(){
		return !isTrue();
	}
	
	public double getArithmeticEvaluationForRamification(Expression exp){
		double returnValue = 0;
		switch(exp.type){
			case "Boolean":
				if ((Boolean)exp.evaluate()){
					returnValue+=1;
				}
				break;
			case "Integer":
				returnValue = (Integer)exp.evaluate();
				break;
			case "Float":
				returnValue = (Float)exp.evaluate();
				break;
			default:
				returnValue = (Integer)exp.evaluate();
				break;
		}
		
		return returnValue;
	}
	
	public Object evaluateArithmetic(){
		if(this.left.type=="String" || this.right.type=="String"){
			if (this.value=="+"){
				return this.left.evaluate().toString() + this.right.evaluate().toString();
			}else{
				return "NaN";	
			}
		}
		else{
			double left = getArithmeticEvaluationForRamification(this.left);
			double right = getArithmeticEvaluationForRamification(this.right);
			
			double result = 0;
			switch(this.value.toString()){
				case "+":
					result = left + right;
					break;
				case "-":
					result = left - right;
					break;
				case "*":
					result = left * right;
					break;
				default:
					// /
					try{
						result = left / right;
					}catch(ArithmeticException e){
						//habria que hacer un mejor control de estos casos borde
						result = 0;
					}
					break;
			}
			if (Math.floor(result)==(result)){
				//la suma de doubles es .0, retorno un integer
				return new Integer((int) (result));
			}else
				//la suma de doubles es .x con x>0 entonces retorno un float
				return new Float(result);
		}
	}
	
	public double getComparisonEvaluationForRamification(Expression e){
		double returnValue = 0;
		switch(e.type){
			case "Boolean":
				if ((Boolean)e.evaluate()){
					returnValue+=1;
				}
				break;
			case "Integer":
				returnValue = (Integer)e.evaluate();
				break;
			case "Float":
				returnValue = (Float)e.evaluate();
				break;
			case "String":
				try{
					returnValue = new Integer((String)e.evaluate());
				}catch (NumberFormatException exc){	
					//habria que manejar mas este caso borde y devolver NaN
					returnValue = 0;
				}
			default:
				returnValue = (Integer)e.evaluate();
				break;
		}
		
		return returnValue;
	}
	
	public Object evaluateComparison(){

		double left = getComparisonEvaluationForRamification(this.left);
		double right = getComparisonEvaluationForRamification(this.right);
			
		switch(this.value.toString()){
			case "==":
				return left == right;
			case "!=":
				return left != right;
			case "<=":
				return left <= right;
			case ">=":
				return left >= right;
			case ">":
				return left > right;
			default:
				// case "<":
				return left < right;
		}
		
	}
	
	public Object evaluate(){
		
		switch(this.value.toString()){
			case "&&":
				if(this.left.isFalse()){
					return this.left.evaluate();
				}else {
					return this.right.evaluate();
				}
			case "||":
				if(this.left.isTrue()){
					return this.left.evaluate();
				}else{
					return this.right.evaluate();
				}	
			case "==":
				return evaluateComparison();
			case "<=":
				return evaluateComparison();
			case ">=":
				return evaluateComparison();
			case "<":
				return evaluateComparison();
			case ">":
				return evaluateComparison();
			case "!=":
				return evaluateComparison();
			case "+":
				return evaluateArithmetic();
			case "-":
				return evaluateArithmetic();
			case "*":
				return evaluateArithmetic();
			case "/":
				return evaluateArithmetic();
			default:
				//es un valor, no un simbolo
				return this.value;
		}
	}
}
