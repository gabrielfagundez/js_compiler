package com.language.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.language.exceptions.SyntaxError;
import com.language.model.Ast;
import com.language.model.Variable;

public class VariablesController {

	private static VariablesController instance = null;
	private Map<String, Variable> variables;
	public Integer actualScope = 0;
	public Integer previousActualScope = 0;
	public Integer blockScope = 0;

    private VariablesController() {
    	this.variables = new HashMap<String, Variable>();
    }

    public static VariablesController getInstance() {
        if (instance == null) {
        	instance = new VariablesController();
        }
        return instance;
    }
    
    public void setBeginBlockScope() {
    	this.previousActualScope = actualScope;
    	this.blockScope++;
    	this.actualScope = this.blockScope;
    }

    public void setEndBlockScope() {
    	this.actualScope = this.previousActualScope;
    	this.previousActualScope--;
    	if (this.previousActualScope < 0) this.previousActualScope = 0; 
    }
    
    public void addVariable(String var_name, Ast var_ast){
    	Object value = var_ast.evaluate();
    	Integer type = var_ast.evaluateType();
    	
    	if (variables.containsKey(var_name)) {
    		Variable var = variables.get(var_name);
    		var.setType(this.actualScope, type);
    		var.setValue(this.actualScope, value);
    	} else {
	    	Variable variable = new Variable(var_name, type, value, this.actualScope);
	    	this.variables.put(variable.getName(), variable);
    	}
    }

    public Variable getVariable(String variable_name){
    	Variable v = variables.get(variable_name);
    	if(v == null){
    		throw new SyntaxError("Variable no conocida: \"" + variable_name + "\"");
    	}else{
    		return v;
    	}
    }

    public void showVariables() {
    	Iterator<Map.Entry<String, Variable>> it = this.variables.entrySet().iterator();

    	while (it.hasNext()) {
    		Map.Entry<String, Variable> entry = (Entry<String, Variable>) it.next();
    		Variable entry_value = (Variable) entry.getValue();

    		System.out.println("Datos:");
    		System.out.println("\tKey: " + entry.getKey());
    		System.out.println("\tName: " + entry_value.getName());
    		
    		System.out.println("\tTipos: ");
    		
    		Iterator it_types = entry_value.getScopeTypeRelation().entrySet().iterator();
    		
    		while (it_types.hasNext()) {
    			Map.Entry<Integer, Integer> type = (Entry<Integer, Integer>) it_types.next();
    			System.out.println("\t\tScope: " + type.getKey());
    			System.out.println("\t\tTipo: " + type.getValue());
    		}
    		
    		System.out.println("\tValores: ");
    		
    		Iterator it_values = entry_value.getScopeValueRelation().entrySet().iterator();
    		
    		while (it_values.hasNext()) {
    			Map.Entry<Integer, Object> value = (Entry<Integer, Object>) it_values.next();
    			System.out.println("\t\tScope: " + value.getKey());
    			System.out.println("\t\tValor: " + value.getValue());
    		}
    	}
    }
}
