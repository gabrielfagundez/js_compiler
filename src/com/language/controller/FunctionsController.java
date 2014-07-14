package com.language.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.language.model.*;

public class FunctionsController {

	private static FunctionsController instance = null;
	private Map<String, Function> functions;
	public String actual_function_name = null;
	
	public ArrayList<Ast> currentArgumentsOnCall = null;

	
	// Se trata de un singleton por lo que el inicializador es privado
	private FunctionsController() {
    	this.functions = new HashMap<String, Function>();
    	this.currentArgumentsOnCall = new ArrayList<Ast>();
    }

	// Obtiene la instancia
    public static FunctionsController getInstance() {
        if (instance == null) {
        	instance = new FunctionsController();
        }
        return instance;
    }
    
    public void addArgument(Ast arg){
    	this.currentArgumentsOnCall.add(arg);
    }
    
    public ArrayList<Ast> getAndResetArguments(){
    	ArrayList<Ast> current = this.currentArgumentsOnCall;
    	this.currentArgumentsOnCall = new ArrayList<Ast>();
    	return current;
    }

    // Agrega una nueva funcion a la tabla de funciones que se almacena
    public void addFunction(String function_name, Integer scope){
    	Function function = new Function();
    	function.scope = scope;
    	this.functions.put(function_name, function);
    }
    
    public Function getFunction(String function_name){
    	if(functions.size() == 0){
    		return null;
    	} else {
    		return functions.get(function_name);
    	}
    }

    // Funcion de prueba para ver las funciones que tenemos guardadas
    public String toString(){
    	return this.functions.toString();
    }
}
