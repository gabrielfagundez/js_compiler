package com.language.model;

import java.util.ArrayList;

import com.language.controller.VariablesController;
import com.language.model.*;

public class Function {
	public ArrayList<Ast> statementsList = null;
	private Integer cantParameters = 0;
	public Integer scope = 0;
	public ArrayList<String> parametersName = null;
	
	public Function() {
		this.statementsList = new ArrayList<Ast>();
		this.parametersName = new ArrayList<String>();
	}
	
    // Agrega un nuevo statement
    public void addStatement(Ast stmt){
    	if(stmt != null){
        	this.statementsList.add(stmt);
    	}
    }
    
    public void addParameterName(String name){
    	this.parametersName.add(name);
    }
	
	public Object execute(ArrayList<Ast> argumentsOnCall) {
		Boolean returnDetected = false;
		Integer previousScope;
		
		Ast var_def = null;
		if(argumentsOnCall.size() <= this.cantParameters){
			for(int j = 0; j < argumentsOnCall.size(); j++){
				var_def = Ast.createVarAddNode(this.parametersName.get(j), argumentsOnCall.get(j));
				var_def.evaluate();
			}
			for(int k = argumentsOnCall.size(); k < this.cantParameters; k++){
				var_def = Ast.createVarAddNode(this.parametersName.get(k), null);
				var_def.evaluate();
			}
		} else {
			for(int k = 0; k < this.cantParameters; k++){
				var_def = Ast.createVarAddNode(this.parametersName.get(k), null);
				var_def.evaluate();
			}
		}
		for(int j = 0; j < this.cantParameters; j++){
			var_def = Ast.createVarAddNode(this.parametersName.get(j), argumentsOnCall.get(j));
			var_def.evaluate();
		}
		
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
