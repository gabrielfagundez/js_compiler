package com.language.model;

import java.util.ArrayList;

import com.language.controller.VariablesController;
import com.language.model.*;

public class Function {
	public ArrayList<Ast> statementsList = null;
	private Integer cantParameters = 0;
	public Integer scope = 0;
	
	public Function() {
		this.statementsList = new ArrayList<Ast>();
	}
	
    // Agrega un nuevo statement
    public void addStatement(Ast stmt){
    	if(stmt != null){
        	this.statementsList.add(stmt);
    	}
    }
	
	public Object execute(ArrayList<Ast> argumentsOnCall) {
		Boolean returnDetected = false;
		Integer previousScope;
		
		for(int i = 0; i < this.statementsList.size(); i++){
    		if(this.statementsList.get(i) != null && 
    				this.statementsList.get(i).getMainNodeType() != Ast.RETURN &&
    				!returnDetected){
    			previousScope = VariablesController.getInstance().actualScope;
				VariablesController.getInstance().actualScope = this.scope;
				
                ((Ast) this.statementsList.get(i)).evaluate();
                
                VariablesController.getInstance().actualScope = previousScope;
    		}
    		
    		if(this.statementsList.get(i).getMainNodeType() == Ast.RETURN){
    			previousScope = VariablesController.getInstance().actualScope;
				VariablesController.getInstance().actualScope = this.scope;
				
				Object return_value = ((Ast) this.statementsList.get(i)).evaluate();
				
				VariablesController.getInstance().actualScope = previousScope;
				
    			return return_value;
    		}
    	}
		
		return null;
	}

	public Integer getCantParameters() {
		return cantParameters;
	}

	public void setCantParameters(Integer cantParameters) {
		this.cantParameters = cantParameters;
	}
	
}
