package com.language.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.language.model.Ast;

public class AstController {
	
	private static AstController instance = null;
	public ArrayList<Ast> statementsList = null;
	
	// Se trata de un singleton por lo que el inicializador es privado
	private AstController() {
    	this.statementsList = new ArrayList<Ast>();
    }

	// Obtiene la instancia
    public static AstController getInstance() {
        if (instance == null) {
        	instance = new AstController();
        }
        return instance;
    }

    // Agrega un nuevo statement
    public void addStatement(Ast stmt){
    	this.statementsList.add(stmt);
    }

    // Ejecuta el AST principal
    public void execute(){
    	for(int i = 0; i < this.statementsList.size(); i++){
    		//System.out.println(((Ast)this.statementsList.get(i)).getMainNodeType());
    		if(this.statementsList.get(i) != null){
                ((Ast) this.statementsList.get(i)).evaluate();	
    		}
    	}
    }
}
