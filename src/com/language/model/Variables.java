package com.language.model;

import java.util.ArrayList;
import java.util.List;

public class Variables {
	
	private static Variables INSTANCE = null;
	private List<Var> variables;
	
    private Variables() {
    	this.variables = new ArrayList<Var>();
    }

    private synchronized static void createInstance() {
    	if (INSTANCE == null) { 
            INSTANCE = new Variables();
        }
    }

    public static Variables getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    public void addVariable(Var variable){
    	this.variables.add(variable);
    }
    
    public void addScope(Var variable){
    	this.variables.add(variable);
    }
    
    public void removeScope(){
        Var lastVariable = variables.remove(variables.size() - 1);
        if(!lastVariable.getScope()){
        	this.removeScope();
        }
    }
    
    public Var getVariableByName(String name){
    	if(variables.size() == 0){
    		return null;
    	} else {
    		Var curr_var = null;
    		for(int i = variables.size() - 1; i >= 0; i--){
                Var actual_var = variables.get(i);
                if(actual_var.getName().equals(name)){
                	curr_var = actual_var;
                }
    		}
    		return curr_var;
    	}
    }
    
    public String toString(){
    	return variables.get(variables.size() - 1).toString();
    }

}
