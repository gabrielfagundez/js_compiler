package com.language.model;

import com.language.controller.FunctionsController;
import com.language.controller.VariablesController;

import java.lang.Math;
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

	// Definicion del nodo AST
	public Integer type;
	public Object value;
	public Ast left;
	public Ast right;
	private Ast condition;
	private Integer current_type;
	public Boolean inFunction = false;
	public ArrayList<Ast> argsForFunction = null;

	// Metodo privado para crear instancias con todos los parametros
	private Ast(Integer type, Object value, Ast left, Ast right, Ast condition) {
		this.type 	= type;
		this.value 	= value;
		this.left 	= left;
		this.right 	= right;
		this.condition = condition;
		this.current_type = type;
	}

	// Este metodo incializa nodos intermedios, y calcula en base a los nodos izquierdo y derecho,  
	// el tipo de la expresion.
	public Ast(Integer type, Ast left, Ast right) {
		this.type 	= type;
		this.left 	= left;
		this.right 	= right; 
	}
	
	// Este metodo incializa nodos intermedios, y calcula en base a los nodos izquierdo y derecho,  
	// el tipo de la expresion.
	public Ast	(Integer type, Ast left, Ast right, Ast condition) {
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
	
	public static Ast createTLCNode(){
		return new Ast(TLC, null, null, null, null);
	}
	
	public static Ast createCharAtNode(Ast right){
		return new Ast(CHAR_AT, null, null, right, null);
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
				return this.left.evaluate().toString().length();
			case CONCAT:
				return (String)this.left.evaluate().toString() + (String)this.right.evaluate().toString();
			case IF: 
				this.current_type = IF;
				this.condition.current_type = this.condition.evaluateType();	

				boolean condition = this.condition.isTrue();
				if (condition){
					return this.left.evaluate();
				}else{
					if (this.right !=null){
						return this.right.evaluate(); 
					}
					return null;
				}
			case BLOCK:
				this.left.evaluate();
				this.right.evaluate();
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
		
		if(this.left.current_type == STRING || this.right.current_type == STRING){
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

			switch(e.current_type){
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

		//List<Object> array = (List<Object>) ((Ast) var.getValue()).value;
		List<Object> array = (List<Object>) var.getValue();

		Integer index = (Integer) index_ast.value;

		String result = var.getName() + "[" + index + "]";
		if ((array.size() - 1) >= index) {
			result += " = " + array.get(index);
		} else {
			result += " Error: El ������ndice excede el largo del array.";
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
			if(this.left.current_type == STRING || this.right.current_type == STRING){
				return STRING;
			} else if (this.left.current_type == FLOAT || this.right.current_type == FLOAT){
				return FLOAT;
			} else {
				return INTEGER;
			}
		} else if ((this.type == MINUS) || (this.type == TIMES) || (this.type == DIV)){
			if(this.left.current_type == STRING || this.right.current_type == STRING){
				return NAN;
			} else if (this.left.current_type == FLOAT || this.right.current_type == FLOAT){
				return FLOAT;
			}else{
				return INTEGER;
			}
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

}
