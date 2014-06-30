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

}
