package com.language.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

import com.language.model.Ast;
import com.language.model.Variable;

public class VariablesController {

	private static VariablesController instance = null;
	private Map<String, Variable> variables;

    private VariablesController() {
    	this.variables = new HashMap<String, Variable>();
    }

    public static VariablesController getInstance() {
        if (instance == null) {
        	instance = new VariablesController();
        }
        return instance;
    }

    public void addVariable(String var_name, Ast var_ast){
    	//System.out.println("Agregar variable: " + var_name);
    	//System.out.println(var_ast.evaluate());

    	//Object value = var_ast.evaluate();
    	Object value = var_ast.value;

    	Variable variable = new Variable(var_name, var_ast.type.toString(), value);
    	this.variables.put(variable.getName(), variable);
    }

    public Variable getVariable(String variable_name){
    	if(variables.size() == 0){
    		return null;
    	} else {
    		return variables.get(variable_name);
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
    		System.out.println("\tType: " + entry_value.getType());
    		System.out.println("\tValue: " + entry_value.getValue());
    	}
    }
}
