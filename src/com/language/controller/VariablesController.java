package com.language.controller;

import java.util.Map;
import java.util.HashMap;

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

    public void addVariable(Variable variable){
    	this.variables.put(variable.getName(), variable);
    }

    public Variable getVariable(String variable_name){
    	if(variables.size() == 0){
    		return null;
    	} else {
    		return variables.get(variable_name);
    	}
    }
}