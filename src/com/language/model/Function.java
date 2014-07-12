package com.language.model;

import java.util.ArrayList;

import com.language.model.*;

public class Function {
	public ArrayList<Ast> statementsList = null;
	
	public Function() {
		this.statementsList = new ArrayList<Ast>();
	}
	
    // Agrega un nuevo statement
    public void addStatement(Ast stmt){
    	if(stmt != null){
        	this.statementsList.add(stmt);
    	}
    }

	
	public void execute() {
		for(int i = 0; i < this.statementsList.size(); i++){
    		if(this.statementsList.get(i) != null){
                ((Ast) this.statementsList.get(i)).evaluate();	
    		}
    	}
	}
	
}
