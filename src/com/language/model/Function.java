package com.language.model;

import com.language.model.*;

public class Function {
	private Ast ast = null;
	
	public Function(Ast ast) {
		this.ast = ast;
	}
	
	public void execute() {
		this.ast.evaluate();
	}
	
}
