package com.language.model;

import com.language.controller.FunctionsController;
import com.language.controller.VariablesController;

import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Ast {

	// Tipos de nodo
	public static final int BOOLEAN 	= 1;
	public static final int INTEGER 	= 2;
	public static final int FLOAT 		= 3;
	public static final int STRING 		= 4;
	public static final int NULL 		= 5;
	public static final int VAR 		= 6;
	public static final int PLUS 		= 7;
	public static final int DIV 		= 8;
	public static final int TIMES 		= 9;
	public static final int MINUS 		= 10;
	public static final int INCREMENT 	= 11;
	public static final int DECREMENT	= 12;
	public static final int AND 		= 13;
	public static final int OR	 		= 14;
	public static final int NOT 		= 15;
	public static final int GREATER		= 16;
	public static final int LESS 		= 17;
	public static final int GREATER_EQ	= 18;
	public static final int LESS_EQ		= 19;
	public static final int EQ_EQ 		= 20;
	public static final int NOT_EQ 		= 21;
	public static final int FUNCTION	= 22;
	public static final int NAN			= 23;
	public static final int ARRAY		= 24;
	public static final int IF  		= 25;
	public static final int CONSOLE		= 26;
	public static final int ALERT		= 27;
	public static final int CALL_FUNCTION = 28;
	public static final int RETURN		= 29;
	public static final int BLOCK		= 30;
	public static final int CONCAT		= 31;
	public static final int LENGTH		= 32;
	public static final int TUC			= 33;
	public static final int TLC			= 34;
	public static final int CHAR_AT		= 35;
	public static final int INDEX_OF	= 36;
	public static final int LAST_INDEX_OF = 37;
	public static final int INCREMENT_P	= 38;
	public static final int DECREMENT_P	= 39;
	public static final int FOR 		= 40;
	public static final int SPLIT 		= 41;
	public static final int SUBSTRING	= 42;
	public static final int IS_NAN		= 43;
	public static final int PARSE		= 44;
	public static final int PUSH		= 45;
	public static final int POP  		= 46;
	public static final int SHIFT  		= 47;
	public static final int REVERSE		= 48;
	public static final int JOIN 		= 49;
	public static final int BREAK		= 50;
	public static final int CONTINUE	= 51;
	public static final int V_ADD 		= 52;
	public static final int MEMBER_OP	= 53;

	// Definicion del nodo AST
	public Integer type;
	public Object value;
	public Ast left;
	public Ast right;
	private Ast condition;
	private Integer current_type;
	public Boolean inFunction = false;
	public ArrayList<Ast> argsForFunction = null;
	public Integer scope = 0;
	
	// Manejo de variables
	public String id;
	public Ast vi;

	// Metodo privado para crear instancias con todos los parametros
	private Ast(Integer type, Object value, Ast left, Ast right, Ast condition) {
		this.type 	= type;
		this.value 	= value;
		this.left 	= left;
		this.right 	= right;
		this.condition = condition;
		this.current_type = type;
	}
	
	public Ast(String id, Ast vi){
		this.type = V_ADD;
		this.id = id;
		this.vi = vi;
	};

	// Este metodo incializa nodos intermedios, y calcula en base a los nodos izquierdo y derecho,  
	// el tipo de la expresion.
	public Ast(Integer type, Ast left, Ast right) {
		this.type 	= type;
		this.left 	= left;
		this.right 	= right; 
	}
	
	// Este metodo incializa nodos intermedios, y calcula en base a los nodos izquierdo y derecho,  
	// el tipo de la expresion.
	public Ast(Integer type, Ast left, Ast right, Ast condition) {
		this.type 	= type;
		this.right 	= right;
		this.left 	= left;
		this.condition = condition;
	}

	// Metodos para crear hojas
	public static Ast createBooleanNode(Object value) {
		Boolean casted_value = new Boolean((String)value);
		return new Ast(BOOLEAN, casted_value, null, null, null);
	}

	public static Ast createIntegerNode(Object value) {
		Integer casted_value = new Integer((String)value);
		return new Ast(INTEGER, casted_value, null, null, null);
	}

	public static Ast createFloatNode(Object value) {
		Float casted_value = new Float((String)value);
		return new Ast(FLOAT, casted_value, null, null, null);
	}

	public static Ast createStringNode(Object value) {
		String casted_value = new String(((String)value).substring(1, ((String)value).length() - 1));
		return new Ast(STRING, casted_value, null, null, null);
	}

	public static Ast createArrayNode(Object value) {
		List<Object> casted_value = createArray((Ast)value);
		return new Ast(ARRAY, casted_value, null, null, null);
	}
	
	public static Ast createNullNode() {
		return new Ast(NULL, null, null, null);
	}

	public static Ast createVarNode(Object value) {
		return new Ast(VAR, value, null, null, null);
	}
	
	public static Ast createConsoleLogNode(Ast expression){
		return new Ast(CONSOLE, null, expression, null, null); 
	}

	public static Ast createAlertNode(Ast expression){
		return new Ast(ALERT, null, expression, null, null); 
	}
	
	public static Ast createFunctionNode(){
		return new Ast(FUNCTION, null, null, null, null); 
	}
	
	public static Ast createCallFunctionNode(Ast ast, ArrayList<Ast> args){
		Ast newAst = new Ast(CALL_FUNCTION, ast.value, null, null, null);
		newAst.argsForFunction = args;
		return newAst; 
	}
	
	public static Ast createNotNode(Ast ast){
		return new Ast(NOT, null, ast, null, null); 
	}
	
	public static Ast createReturnNode(Ast ast){
		return new Ast(RETURN, null, ast, null, null);
	};
	
	public static Ast createConcatNode(Ast right){
		return new Ast(CONCAT, null, null, right, null);
	}
	
	public static Ast createLengthNode(){
		return new Ast(LENGTH, null, null, null, null);
	}
	
	public static Ast createTUCNode(){
		return new Ast(TUC, null, null, null, null);
	}
	
	public static Ast createPushNode(Ast right){
		return new Ast(PUSH, null, null, right, null);
	}
	
	public static Ast createJoinNode(Ast right){
		return new Ast(JOIN, null, null, right, null);
	}
	
	public static Ast createPopNode(){
		return new Ast(POP, null, null, null, null);
	}
	
	public static Ast createContinueNode(){
		return new Ast(CONTINUE, null, null, null, null);
	}
	
	public static Ast createBreakNode(){
		return new Ast(BREAK, null, null, null, null);
	}
	
	public static Ast createShiftNode(){
		return new Ast(SHIFT, null, null, null, null);
	}
	
	public static Ast createReverseNode(){
		return new Ast(REVERSE, null, null, null, null);
	}
	
	public static Ast createTLCNode(){
		return new Ast(TLC, null, null, null, null);
	}
	
	public static Ast createCharAtNode(Ast right){
		return new Ast(CHAR_AT, null, null, right, null);
	}
	
	public static Ast createIndexOfNode(Ast right){
		return new Ast(INDEX_OF, null, null, right, null);
	}
	
	public static Ast createLastIndexOfNode(Ast right){
		return new Ast(LAST_INDEX_OF, null, null, right, null);
	}
	
	public static Ast createIncNode(Ast left){
		return new Ast(INCREMENT, left.value, left, null, null);
	}
	
	public static Ast createDecNode(Ast left){
		return new Ast(DECREMENT, left.value, left, null, null);
	}
	
	public static Ast createIncPNode(Ast left){
		return new Ast(INCREMENT_P, left.value, left, null, null);
	}
	
	public static Ast createDecPNode(Ast left){
		return new Ast(DECREMENT_P, left.value, left, null, null);
	}

	public static Ast createNameVariableNode(String name_variable) {
		return new Ast(STRING, name_variable, null, null, null);
	}
	
	public static Ast createSplitNode(Ast right){
		return new Ast(SPLIT, null, null, right, null);
	}
	
	public static Ast createSubstrNode1(Ast right){
		return new Ast(SUBSTRING, null, null, right, null);
	}
	
	public static Ast createSubstrNode2(Ast right, Ast condition){
		return new Ast(SUBSTRING, null, right, condition);
	}
	
	public static Ast createisNaNNode(Ast left){
		return new Ast(IS_NAN, null, left, null, null);
	}

	public static Ast createNaNNode(Ast right){
		return new Ast(NAN, null, null, right, null);
	}

	public static Ast createParseNode(Ast left){
		return new Ast(PARSE, null, left, null, null);
	}
	
	public static Ast createVarAddNode(String id, Ast vi){
		return new Ast(id, vi);
	}
	
	public static Ast createMemberOperatorNode(Ast var, Ast index) {
		return new Ast(MEMBER_OP, var, index);
	}
	
	// Metodo recursivo que retorna el valor de la expresion. 
	// Defino metodos para evaluar cada uno de los casos.
	// Los nodos que son hojas retornan el valor.
	public Object evaluate(){
		Integer previousScope; 
		switch(this.type){
			case V_ADD:
				VariablesController.getInstance().addVariable(this.id, this.vi);
			case MEMBER_OP:
				if (this.left != null) { 
					return this.left.evaluateArray(this.right);
				}
				return null;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case STRING:
				return this.value;
			case NULL:
				return null;
			case VAR:
				VariablesController variables = VariablesController.getInstance();
				return variables.getVariable((String)this.value).getValue(VariablesController.getInstance().actualScope);
			case AND:
				this.current_type = this.evaluateType();
				if (this.left.isFalse()) {
					return this.left.evaluate();
				} else {
					return this.right.evaluate();
				}
			case OR:
				this.current_type = this.evaluateType();
				if (this.left.isTrue()) {
					return this.left.evaluate();
				}else{
					return this.right.evaluate();
				}
			case NOT:
				this.current_type = this.evaluateType();
				return evaluateNot();
			case EQ_EQ:
			case LESS_EQ:
			case GREATER_EQ:
			case LESS:
			case GREATER:
			case NOT_EQ:
				this.current_type = this.evaluateType();
				return evaluateComparison();
			case PLUS:
			case MINUS:
			case TIMES:
			case DIV:
				this.current_type = this.evaluateType();
				return evaluateArithmetic();
			case CONSOLE:
			case ALERT:
				System.out.println(this.left.evaluate());
				return null;
			case CALL_FUNCTION:
				FunctionsController fc = FunctionsController.getInstance();
				Function f = fc.getFunction((String)this.value);
				return f.execute(this.argsForFunction);
			case RETURN:
				if(this.left != null){
					return this.left.evaluate();
				} else {
					return null;
				}
			case CHAR_AT:
				Integer position = (Integer)this.right.evaluate();
				if(position > ((String)this.left.evaluate()).length() - 1 || position < 0){
					return "";
				} else {
					return ((String)this.left.evaluate().toString()).charAt(position);	
				}
			case TLC:
				return this.left.evaluate().toString().toLowerCase();
			case TUC:
				return this.left.evaluate().toString().toUpperCase();
			case LENGTH:
				if(this.left.type == ARRAY){
					return ((ArrayList)this.left.value).size();
				}else{
					return this.left.evaluate().toString().length();	
				}
			case CONCAT:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.left.value);
					if(v.getType(VariablesController.getInstance().actualScope) == ARRAY){
						ArrayList array = new ArrayList((ArrayList) v.getValue(VariablesController.getInstance().actualScope));
						((ArrayList)array).add(this.right.evaluate());
						return array;
					} else {
						return (String)this.left.evaluate().toString() + (String)this.right.evaluate().toString();	
					}
				}
				else if(this.left.type == ARRAY){
					((ArrayList)this.left.value).add(this.right.evaluate());
					return this.left.value;
				} else {
					return (String)this.left.evaluate().toString() + (String)this.right.evaluate().toString();	
				}
			case SUBSTRING:
				// Caso en el que tiene 1 parte
				if(this.condition == null){
					if(((String)this.left.evaluate()).length() > (Integer)this.right.evaluate()){
						return ((String)this.left.evaluate()).substring((Integer)this.right.evaluate());
					}else{
						return ((String)this.left.evaluate()).substring(((String)this.left.evaluate()).length());	
					}
				} else {
					if((Integer)this.right.evaluate() > (Integer)this.condition.evaluate()){
						if(((String)this.left.evaluate()).length() > (Integer)this.right.evaluate()){
							return ((String)this.left.evaluate()).substring((Integer)this.condition.evaluate(), (Integer)this.right.evaluate());
						}else{
							return ((String)this.left.evaluate()).substring((Integer)this.condition.evaluate(), ((String)this.left.evaluate()).length());	
						}
					}else {
						if(((String)this.left.evaluate()).length() > (Integer)this.condition.evaluate()){
							return ((String)this.left.evaluate()).substring((Integer)this.right.evaluate(), (Integer)this.condition.evaluate());
						}else{
							return ((String)this.left.evaluate()).substring((Integer)this.right.evaluate(), ((String)this.left.evaluate()).length());	
						}
					}
				}
			case PUSH:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.left.value);
					if(v.getType(VariablesController.getInstance().actualScope) == ARRAY){
						if (((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).size()>0){
							return ((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).add(this.right.evaluate());
						}else{
							return null;
						}
					} else {
						return null;	
					}
				}
				else if(this.left.type == ARRAY){
					((ArrayList)this.left.value).add(this.right.evaluate());
					return ((ArrayList)this.left.value).size();
				} else {
					return null;	
				}
			case POP:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.left.value);
					if(v.getType(VariablesController.getInstance().actualScope) == ARRAY){
						if (((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).size()>0){
							return ((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).remove(((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).size()-1);
						}else{
							return null;
						}
					} else {
						return null;	
					}
				}
				else if(this.left.type == ARRAY){
					if (((ArrayList)this.left.value).size()>0){
						Object value = ((ArrayList)this.left.value).remove(((ArrayList)this.left.value).size()-1);
						return value;
					}else{
						return null;
					}
				} else {
					return null;	
				}
			case SHIFT:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.left.value);
					if(v.getType(VariablesController.getInstance().actualScope) == ARRAY){
						if (((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).size()>0){
							return ((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).remove(0);
						}else{
							return null;
						}
					} else {
						return null;	
					}
				}
				else if(this.left.type == ARRAY){
					if (((ArrayList)this.left.value).size()>0){
						Object value = ((ArrayList)this.left.value).remove(0);
						return value;
					}else{
						return null;
					}
				} else {
					return null;	
				}
			case JOIN:
				String join = ((String)this.right.evaluate()).toString();
				
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.left.value);
					if (((ArrayList)v.getValue(VariablesController.getInstance().actualScope)).size()>0){
						return Utils.arrayToStringWithJoin((List)v.getValue(VariablesController.getInstance().actualScope), join);
					}else{
						return null;
					}
				}
				else if(this.left.type == ARRAY){
					if (((ArrayList)this.left.value).size()>0){
						return Utils.arrayToStringWithJoin((List)this.left.value, join);
					}else{
						return null;
					}
				} else {
					return null;	
				}
			case REVERSE:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.left.value);
					if(v.getType(VariablesController.getInstance().actualScope) == ARRAY){
						Collections.reverse((ArrayList)v.getValue(VariablesController.getInstance().actualScope));
						return v.getValue(VariablesController.getInstance().actualScope);
					} else {
						return null;	
					}
				}
				else if(this.left.type == ARRAY){
					Collections.reverse((ArrayList)this.left.value);
					return (ArrayList)this.left.value;
				} else {
					return null;	
				}
			case INDEX_OF:
				return ((String)this.left.evaluate()).indexOf((String)this.right.evaluate());
			case LAST_INDEX_OF:
				return ((String)this.left.evaluate()).lastIndexOf((String)this.right.evaluate());
			case IS_NAN:
				try{
					if(this.left.type == FLOAT || this.left.type == INTEGER){
						return false;
					}
					Integer.parseInt(((String)this.left.evaluate()));
					return false;
				} catch (Exception ex) { 
					try {
						Float.parseFloat(((String)this.left.evaluate()));
						return false;
					} catch (Exception ex2) {
						return true;	
					}
				}
			case NAN:
				return "NaN";
			case PARSE:
				try{
					return Integer.parseInt(((String)this.left.evaluate()));
				} catch (Exception ex) { 
					return Float.parseFloat(((String)this.left.evaluate()));
				}
			case SPLIT:
				String[] out = ((String)this.left.evaluate()).split((String)this.right.evaluate());
				ArrayList<String> stringList = new ArrayList<String>();
				for(int i = 0; i < out.length; i++){
					stringList.add("\"" + out[i] + "\"");
				}
				return stringList.toString();
			case IF: 
				previousScope = VariablesController.getInstance().actualScope;
				VariablesController.getInstance().actualScope = this.scope;
				Object return_value;
				
				this.current_type = IF;
				this.condition.current_type = this.condition.evaluateType();	

				boolean condition = this.condition.isTrue();
				if (condition){
					if(this.left != null){
						return_value = this.left.evaluate();
						VariablesController.getInstance().actualScope = previousScope;
						return return_value;
					}
					VariablesController.getInstance().actualScope = previousScope;
				}else{
					if (this.right !=null){
						return_value = this.right.evaluate();
						VariablesController.getInstance().actualScope = previousScope;
						return return_value; 
					}

					VariablesController.getInstance().actualScope = previousScope; 
					return null;
				}
			case ARRAY:
				return this.value;
			case INCREMENT:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.value);
					if(v.getType(VariablesController.getInstance().actualScope) == INTEGER){
						Integer prevVal = (Integer)v.getValue(VariablesController.getInstance().actualScope);
						v.setValue(VariablesController.getInstance().actualScope, (Integer)v.getValue(VariablesController.getInstance().actualScope) + 1);
						return prevVal;
					}
					if(v.getType(VariablesController.getInstance().actualScope) == FLOAT){
						Float prevVal = (Float)v.getValue(VariablesController.getInstance().actualScope);
						v.setValue(VariablesController.getInstance().actualScope, (Float)v.getValue(VariablesController.getInstance().actualScope) + 1.0);
						return prevVal;
					}
				}
				return "NaN";
			case INCREMENT_P:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.value);
					if(v.getType(VariablesController.getInstance().actualScope) == INTEGER){
						v.setValue(VariablesController.getInstance().actualScope, (Integer)v.getValue(VariablesController.getInstance().actualScope) + 1);
						return v.getValue(VariablesController.getInstance().actualScope);
					}
					if(v.getType(VariablesController.getInstance().actualScope) == FLOAT){
						v.setValue(VariablesController.getInstance().actualScope, (Float)v.getValue(VariablesController.getInstance().actualScope) + 1.0);
						return v.getValue(VariablesController.getInstance().actualScope);
					}
				}
				return "NaN";
			case DECREMENT:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.value);
					if(v.getType(VariablesController.getInstance().actualScope) == INTEGER){
						Integer prevVal = (Integer)v.getValue(VariablesController.getInstance().actualScope);
						v.setValue(VariablesController.getInstance().actualScope, (Integer)v.getValue(VariablesController.getInstance().actualScope) - 1);
						return prevVal;
					}
					if(v.getType(VariablesController.getInstance().actualScope) == FLOAT){
						Float prevVal = (Float)v.getValue(VariablesController.getInstance().actualScope);
						v.setValue(VariablesController.getInstance().actualScope, (Float)v.getValue(VariablesController.getInstance().actualScope) - 1.0);
						return prevVal;
					}
				}
				return "NaN";
			case DECREMENT_P:
				if(this.left.type == VAR){
					VariablesController vc = VariablesController.getInstance();
					Variable v = vc.getVariable((String)this.value);
					if(v.getType(VariablesController.getInstance().actualScope) == INTEGER){
						v.setValue(VariablesController.getInstance().actualScope, (Integer)v.getValue(VariablesController.getInstance().actualScope) - 1);
						return v.getValue(VariablesController.getInstance().actualScope);
					}
					if(v.getType(VariablesController.getInstance().actualScope) == FLOAT){
						v.setValue(VariablesController.getInstance().actualScope, (Float)v.getValue(VariablesController.getInstance().actualScope) - 1.0);
						return v.getValue(VariablesController.getInstance().actualScope);
					}
				}
				return "NaN";
			case FOR: 
				previousScope = VariablesController.getInstance().actualScope;
				VariablesController.getInstance().actualScope = this.scope;
				Object for_value_return;
				
				this.current_type = FOR;
				this.condition.current_type = this.condition.evaluateType();
				boolean condition_true = this.condition.isTrue();
				if (condition_true){
					if (this.left !=null){
						this.left.evaluate();
					}
					//do the (.;.;here)
					if (this.right !=null){
						this.right.evaluate();
					}

					for_value_return = this.evaluate();
					VariablesController.getInstance().actualScope = previousScope;

					return for_value_return;
				}else{
					VariablesController.getInstance().actualScope = previousScope; 
					return null;
				}
			case BLOCK:
				previousScope = VariablesController.getInstance().actualScope;
				VariablesController.getInstance().actualScope = this.scope;
				if(this.left != null){
					this.left.evaluate();
				}
				if(this.right != null){
					this.right.evaluate();
				}
				VariablesController.getInstance().actualScope = previousScope; 
				return null;
			case BREAK:
				return null;
			case CONTINUE:
				return null;
			default:
				return "Error";
		}
	}
	
	// Funcion auxiliar que verifica que sea true
	private boolean isTrue(){
		if (this.current_type == INTEGER || this.current_type == FLOAT){
			return (Integer)this.evaluate() > 0;
		} else if (this.current_type == BOOLEAN){
			return (Boolean)this.evaluate();
		} else if (this.current_type == STRING){
			return ((String)this.evaluate()).length() > 0;
		} else if (this.current_type == VAR){
			return (boolean)VariablesController.getInstance().getVariable((String)this.value).getValue(VariablesController.getInstance().actualScope);
		} else {
			return false;
		}
	}

	// Funcion auxiliar que verifica que sea false
	private boolean isFalse(){
		return !isTrue();
	}
	
	// Funcion auxiliar que evalua comparaciones
	private Object evaluateComparison(){
		double left = getComparisonEvaluationForRamification(this.left);
		double right = getComparisonEvaluationForRamification(this.right);
			
		switch(this.type){
			case EQ_EQ:
				return left == right;
			case NOT_EQ:
				return left != right;
			case LESS_EQ:
				return left <= right;
			case GREATER_EQ:
				return left >= right;
			case GREATER:
				return left > right;
			default:
				// case "<":
				return left < right;
		}
	}
	
	// Funcion auxiliar que evalua comparaciones
		private Object evaluateNot(){
			double left = getComparisonEvaluationForRamification(this.left);
				
			return !(left>0);
		}
	
	// Funcion auxiliar que evalua aritmeticamente
	private Object evaluateArithmetic(){
		if(this.left.current_type == STRING || this.right.current_type == STRING || this.left.current_type == ARRAY || this.right.current_type == ARRAY){
			if (this.type == PLUS){
				String left_string = (this.left.evaluate() instanceof ArrayList) ? Utils.arrayToString((List) this.left.evaluate()).substring(0,Utils.arrayToString((List) this.left.evaluate()).length()-1) : this.left.evaluate().toString() ; 
				String right_string = (this.right.evaluate() instanceof ArrayList) ? Utils.arrayToString((List) this.right.evaluate()).substring(0,Utils.arrayToString((List) this.right.evaluate()).length()-1) : this.right.evaluate().toString() ;

				return left_string + right_string;
			} else {
				return "NaN";
			}
		} else if (this.left.current_type == VAR || this.right.current_type == VAR) {
			Integer left_type;
			Integer right_type;
			Object left_value;
			Object right_value;

			if (this.left.current_type == VAR && this.right.current_type == VAR) {
				// Los dos nodos son VAR

				Variable var_left = VariablesController.getInstance().getVariable(this.left.value.toString());
				Variable var_right = VariablesController.getInstance().getVariable(this.right.value.toString());

				left_type = var_left.getType(VariablesController.getInstance().actualScope);
				right_type = var_right.getType(VariablesController.getInstance().actualScope);

				left_value = var_left.getValue(VariablesController.getInstance().actualScope);
				right_value = var_right.getValue(VariablesController.getInstance().actualScope);
			} else if (this.left.current_type == VAR) {
				// El nodo izquierdo es VAR

				Variable var = VariablesController.getInstance().getVariable(this.left.value.toString());

				left_type = var.getType(VariablesController.getInstance().actualScope);
				right_type = this.right.evaluateType();

				left_value = var.getValue(VariablesController.getInstance().actualScope);
				right_value = this.right.evaluate();
			} else {
				// El nodo derecho

				Variable var = VariablesController.getInstance().getVariable(this.right.value.toString());

				left_type = this.left.evaluateType();
				right_type = var.getType(VariablesController.getInstance().actualScope);

				left_value = this.left.evaluate();
				right_value = var.getValue(VariablesController.getInstance().actualScope);
			}

			return evaluateArithmeticWithVars(this.type, left_type, left_value, right_type, right_value);
		} else {
			double left = getArithmeticEvaluationForRamification(this.left);
			double right = getArithmeticEvaluationForRamification(this.right);

			double result = 0;
			switch(this.type){
				case PLUS:
					result = left + right;
					break;
				case MINUS:
					result = left - right;
					break;
				case TIMES:
					result = left * right;
					break;
				default:
					try{
						result = left / right;
					}catch(ArithmeticException e){
						//habria que hacer un mejor control de estos casos borde
						result = 0;
					}
					break;
			}

			if (Math.floor(result) == (result)){
				//la suma de doubles es .0, retorno un integer
				return new Integer((int) (result));
			}else
				//la suma de doubles es .x con x>0 entonces retorno un float
				return new Float(result);
		}
	}
	
	// Funciones auxiliares para comparaciones
		private double getComparisonEvaluationForRamification(Ast e){
			double returnValue = 0;

			switch(e.current_type){
				case BOOLEAN:
					if ((Boolean)e.evaluate()){
						returnValue += 1;
					}
					break;
				case INTEGER:
					returnValue = (Integer)e.evaluate();
					break;
				case FLOAT:
					returnValue = (Float)e.evaluate();
					break;
				case VAR:
					VariablesController variables = VariablesController.getInstance();
					Variable var = variables.getVariable((String)e.value);

					switch(var.getType(VariablesController.getInstance().actualScope)){
					case BOOLEAN:
						if ((Boolean)var.getValue(VariablesController.getInstance().actualScope)){
							returnValue += 1;
						}
						break;
					case 0: //workaround, no se por que
					case INTEGER:
						returnValue = (Integer)var.getValue(VariablesController.getInstance().actualScope);
						break;
					case FLOAT:
						returnValue = (Float)var.getValue(VariablesController.getInstance().actualScope);
						break;
					case STRING:

						try{
							returnValue = new Integer((String)var.getValue(VariablesController.getInstance().actualScope));
						}catch (NumberFormatException exc){	
							//habria que manejar mas este caso borde y devolver NaN
							returnValue = 0;
						}
						break;
					}
					break;
				case STRING:
					try{
						returnValue = new Integer((String)e.evaluate());
					}catch (NumberFormatException exc){	
						//habria que manejar mas este caso borde y devolver NaN
						returnValue = 0;
					}
					break;
				default:
					returnValue = (Integer)e.evaluate();
					break;
			}

			return returnValue;
		}

	// Funciones auxiliares para aritmetica
	private double getArithmeticEvaluationForRamification(Ast ast){
		double returnValue = 0;

		switch(ast.current_type){
			case BOOLEAN:
				if ((Boolean)ast.evaluate()){
					returnValue+=1;
				}
				break;
			case INTEGER:
				returnValue = (Integer)ast.evaluate();
				break;
			case FLOAT:
				returnValue = (Float)ast.evaluate();
				break;
			default:
				returnValue = (Integer)ast.evaluate();
				break;
		}

		return returnValue;
	}
	
	private static List<Object> createArray(Ast ast_array) {
		List<Object> array = new ArrayList<Object>();

		if ((ast_array.type == ARRAY) && (ast_array.left != null)) {
			// El array tiene mas de un elemento

			Ast element_list = ast_array;
			Object element;
			do {
				element = element_list.right.value;
				array.add(0, element);
				element_list = element_list.left;
			} while (element_list.left != null);

			element = element_list.value;
			array.add(0, element);

		} else if (ast_array.type != ARRAY) {
			// El array tiene un elemento

			array.add(ast_array.value);
		}

		// System.out.println(array);
		return array;
	}
	
	public Object evaluateArray(Ast index_ast) {
		Variable var = VariablesController.getInstance().getVariable(this.value.toString());

		List<Object> array = (List<Object>) var.getValue(VariablesController.getInstance().actualScope);

		Integer index = (Integer) index_ast.value;

		Object result = null;
		if ((array.size() - 1) >= index) {
			result = array.get(index);
		}
		return result;
	}

	public Ast getCondition() {
		return condition;
	}

	public void setCondition(Ast condition) {
		this.condition = condition;
	}

	public Integer getCurrent_type() {
		return current_type;
	}

	public void setCurrent_type(Integer current_type) {
		this.current_type = current_type;
	}
	
	public Integer getMainNodeType(){
		return this.type;
	}

// Comentado mientras no se use para evitar confusiones.
//
	public Integer evaluateType(){
		if (this.left != null){
			// si left es null entonces el right tambien lo va a ser
			this.left.current_type = this.left.evaluateType();
		}else{
			// es una hoja entonces retorno el tipo de la variable
			return this.type;
		}
		
		if (this.right != null){
			// si left es null entonces el right tambien lo va a ser
			this.right.current_type = this.right.evaluateType();
		}
				
		if(this.type == PLUS){
			Integer left_type;
			Integer right_type;

			if(this.left.current_type == VAR || this.right.current_type == VAR) {
				if (this.left.current_type == VAR && this.right.current_type == VAR) {
					left_type = VariablesController.getInstance().getVariable(this.left.value.toString()).getType(VariablesController.getInstance().actualScope);
					right_type = VariablesController.getInstance().getVariable(this.right.value.toString()).getType(VariablesController.getInstance().actualScope);
				} else if (this.left.current_type == VAR) {
					left_type = VariablesController.getInstance().getVariable(this.left.value.toString()).getType(VariablesController.getInstance().actualScope);
					right_type = this.right.current_type;
				} else {
					left_type = this.left.current_type;
					right_type = VariablesController.getInstance().getVariable(this.right.value.toString()).getType(VariablesController.getInstance().actualScope);
				}
			} else {
				left_type = this.left.current_type;
				right_type = this.right.current_type;
			}

			return evaluateTypeForPlus(left_type, right_type);

		} else if ((this.type == MINUS) || (this.type == TIMES) || (this.type == DIV)){
			Integer left_type;
			Integer right_type;

			if(this.left.current_type == VAR || this.right.current_type == VAR) {
				if (this.left.current_type == VAR && this.right.current_type == VAR) {
					left_type = VariablesController.getInstance().getVariable(this.left.value.toString()).getType(VariablesController.getInstance().actualScope);
					right_type = VariablesController.getInstance().getVariable(this.right.value.toString()).getType(VariablesController.getInstance().actualScope);
				} else if (this.left.current_type == VAR) {
					left_type = VariablesController.getInstance().getVariable(this.left.value.toString()).getType(VariablesController.getInstance().actualScope);
					right_type = this.right.current_type;
				} else {
					left_type = this.left.current_type;
					right_type = VariablesController.getInstance().getVariable(this.right.value.toString()).getType(VariablesController.getInstance().actualScope);
				}
			} else {
				left_type = this.left.current_type;
				right_type = this.right.current_type;
			}

			return evaluateTypeForOtherOperators(left_type, right_type);

		} else if (this.type == AND){
			if (this.left.isFalse()){
				return this.left.current_type;
			}else{
				return this.right.current_type;
			}
		} else if ((this.type == OR)){
			if (this.left.isTrue()){
				return this.left.current_type;
			}else{
				return this.right.current_type;
			}
		} else if ((this.type == EQ_EQ) || (this.type == NOT_EQ) || (this.type == LESS_EQ) ||  
				(this.type == GREATER_EQ) || (this.type == LESS) || (this.type == GREATER) || (this.type == NOT)) {
			return BOOLEAN;
		}
		
		return 0;
	}

	private Object evaluateArithmeticWithVars(Integer op_type, Integer left_type, Object left_value, Integer right_type, Object right_value){
		if(left_type == STRING || right_type == STRING || left_type == ARRAY || right_type == ARRAY){
			if (op_type == PLUS){
				String left_string = (left_value instanceof ArrayList) ? Utils.arrayToString((List) left_value) : left_value.toString() ; 
				String right_string = (right_value instanceof ArrayList) ? Utils.arrayToString((List) right_value) : right_value.toString() ;

				return left_string + right_string;
			}

			return "NaN";
		} else {
			double left_value_double = (left_value instanceof Boolean) ? ((Boolean) left_value).compareTo(false) : Double.parseDouble(left_value.toString()) ;
			double right_value_double = (right_value instanceof Boolean) ? ((Boolean) right_value).compareTo(false) : Double.parseDouble(right_value.toString()) ;

			double result = 0;
			switch(op_type){
				case PLUS:
					result = left_value_double + right_value_double;
					break;
				case MINUS:
					result = left_value_double - right_value_double;
					break;
				case TIMES:
					result = left_value_double * right_value_double;
					break;
				default:
					try{
						result = left_value_double / right_value_double;
					}catch(ArithmeticException e){
						//habria que hacer un mejor control de estos casos borde
						result = 0;
					}
					break;
			}

			if (Math.floor(result) == (result)){
				//la suma de doubles es .0, retorno un integer
				return new Integer((int) (result));
			}else
				//la suma de doubles es .x con x>0 entonces retorno un float
				return new Float(result);
		}
	}

	private Integer evaluateTypeForPlus(Integer left_type, Integer right_type) {
		if(left_type == STRING || right_type == STRING){
			return STRING;
		} else if (left_type == FLOAT || right_type == FLOAT){
			return FLOAT;
		} else {
			return INTEGER;
		}
	}

	private Integer evaluateTypeForOtherOperators(Integer left_type, Integer right_type) {
		if(left_type == STRING || right_type == STRING){
			return NAN;
		} else if (left_type == FLOAT || right_type == FLOAT){
			return FLOAT;
		}else{
			return INTEGER;
		}
	}
}
