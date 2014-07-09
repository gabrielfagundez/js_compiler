package com.language.model;

import com.language.controller.VariablesController;
import java.lang.Math;

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

	// Definicion del nodo AST
	private Integer type;
	private Object value;
	private Ast left;
	private Ast right;

	// Metodo privado para crear instancias con todos los parametros
	private Ast(Integer type, Object value, Ast left, Ast right) {
		this.type 	= type;
		this.value 	= value;
		this.left 	= left;
		this.right 	= right;
	}

	// Este metodo incializa nodos intermedios, y calcula en base a los nodos izquierdo y derecho,  
	// el tipo de la expresion.
	public Ast(Integer type, Ast left, Ast right) {
		this.type 	= type;
		this.left 	= left;
		this.right 	= right;

		// No debemos llamar a evaluate porque si tenemos variables 
		// no sabemos el valor cuando lo creamos, sino cuando evaluamos
		// this.type 	= evaluateType(); 
	}

	// Metodos para crear hojas
	public static Ast createBooleanNode(Object value) {
		Boolean casted_value = new Boolean((String)value);
		return new Ast(BOOLEAN, casted_value, null, null);
	}

	public static Ast createIntegerNode(Object value) {
		Integer casted_value = new Integer((String)value);
		return new Ast(INTEGER, casted_value, null, null);
	}

	public static Ast createFloatNode(Object value) {
		Float casted_value = new Float((String)value);
		return new Ast(FLOAT, casted_value, null, null);
	}

	public static Ast createStringNode(Object value) {
		String casted_value = new String(((String)value).substring(1, ((String)value).length() - 1));
		return new Ast(STRING, casted_value, null, null);
	}
	
	public static Ast createNullNode() {
		return new Ast(NULL, null, null, null);
	}

	public static Ast createVarNode(Object value) {
		return new Ast(VAR, value, null, null);
	}

	// Metodo recursivo que retorna el valor de la expresion. 
	// Defino metodos para evaluar cada uno de los casos.
	// Los nodos que son hojas retornan el valor.
	public Object evaluate(){
		switch(this.type){
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case STRING:
				return this.value;
			case NULL:
				return null;
			case VAR:
				VariablesController variables = VariablesController.getInstance();
				return variables.getVariable((String)this.value);
			case AND:
				if (this.left.isFalse()) {
					return this.left.evaluate();
				} else {
					return this.right.evaluate();
				}
			case OR:
				if (this.left.isTrue()) {
					return this.left.evaluate();
				}else{
					return this.right.evaluate();
				}
			case EQ_EQ:
			case LESS_EQ:
			case GREATER_EQ:
			case LESS:
			case GREATER:
			case NOT_EQ:
				return evaluateComparison();
			case PLUS:
			case MINUS:
			case TIMES:
			case DIV:
				return evaluateArithmetic();
			default:
				return "Error";
		}
	}
	
	// Funcion auxiliar que verifica que sea true
	private boolean isTrue(){
		if (this.type == INTEGER || this.type == FLOAT){
			return (Integer)this.evaluate() > 0;
		} else if (this.type == BOOLEAN){
			return (Boolean)this.evaluate();
		} else if (this.type == STRING){
			return ((String)this.evaluate()).length() > 0;
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
			case LESS:
				return left > right;
			default:
				// case "<":
				return left < right;
		}
	}
	
	// Funcion auxiliar que evalua aritmeticamente
	private Object evaluateArithmetic(){
		if(this.left.type == STRING || this.right.type == STRING){
			if (this.type == PLUS){
				return this.left.evaluate().toString() + this.right.evaluate().toString();
			} else {
				return "NaN";
			}
		}
		else {
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
			switch(e.type){
				case BOOLEAN:
					if ((Boolean)e.evaluate()){
						returnValue+=1;
					}
					break;
				case INTEGER:
					returnValue = (Integer)e.evaluate();
					break;
				case FLOAT:
					returnValue = (Float)e.evaluate();
					break;
				case STRING:
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

	
	// Funciones auxiliares para aritmetica
	private double getArithmeticEvaluationForRamification(Ast ast){
		double returnValue = 0;

		switch(ast.type){
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
	
// Comentado mientras no se use para evitar confusiones.
//
//	public Integer evaluateType(){
//		if(this.type == PLUS){
//			if(this.left.type == STRING || this.right.type == STRING){
//				return STRING;
//			} else if (this.left.type == FLOAT || this.right.type == FLOAT){
//				return FLOAT;
//			} else {
//				return INTEGER;
//			}
//		} else if ((this.type == MINUS) || (this.type == TIMES) || (this.type == DIV)){
//			if(this.left.type == STRING || this.right.type == STRING){
//				return NAN;
//			} else if (this.left.type == FLOAT || this.right.type == FLOAT){
//				return FLOAT;
//			}else{
//				return INTEGER;
//			}
//		} else if (this.type == AND){
//			if (this.left.isFalse()){
//				return this.left.type;
//			}else{
//				return this.right.type;
//			}
//		} else if ((this.type == OR)){
//			if (this.left.isTrue()){
//				return this.left.type;
//			}else{
//				return this.right.type;
//			}
//		} else if ((this.type == EQ_EQ) || (this.type == NOT_EQ) || (this.type == LESS_EQ) ||  
//				(this.type == GREATER_EQ) || (this.type == LESS) || (this.type == GREATER)) {
//			return BOOLEAN;
//		}
//		return 0;
//	}

}
