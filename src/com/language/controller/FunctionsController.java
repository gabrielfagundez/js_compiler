package com.language.controller;

import java.util.HashMap;
import java.util.Map;

import com.language.model.*;

public class FunctionsController {

	private static FunctionsController instance = null;
	private Map<String, Function> functions;
	
	// Se trata de un singleton por lo que el inicializador es privado
	private FunctionsController() {
    	this.functions = new HashMap<String, Function>();
    }

	// Obtiene la instancia
    public static FunctionsController getInstance() {
        if (instance == null) {
        	instance = new FunctionsController();
        }
        return instance;
    }

    // Agrega una nueva funcion a la tabla de funciones que se almacena
    public void addFunction(String function_name, Ast ast){
    	Function function = new Function(ast);
    	this.functions.put(function_name, function);
    }

    // Ejecuta el AST asociado a la funcion
    public void execute(String function_name){
    	
    }

    // Funcion de prueba para ver las funciones que tenemos guardadas
    public String toString(){
    	return this.functions.toString();
    }
}
