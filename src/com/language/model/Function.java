package com.language.model;

import java.util.ArrayList;

import com.language.model.*;

public class Function {
	public ArrayList<Ast> statementsList = null;
	private Integer cantParameters = 0;
	
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
		
		for(int i = 0; i < this.statementsList.size(); i++){
    		if(this.statementsList.get(i) != null && 
    				this.statementsList.get(i).getMainNodeType() != Ast.RETURN &&
    				!returnDetected){
                ((Ast) this.statementsList.get(i)).evaluate();	
    		}
    		
    		if(this.statementsList.get(i).getMainNodeType() == Ast.RETURN){
    			return ((Ast) this.statementsList.get(i)).evaluate();
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
