package com.language;

import java.io.*;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {
	    /* Generacion del Scanner */
	    String path = "language/jflex/Scanner.jflex";
	    generarLexer(path);
	  
	    /* Generacion del Parser */
	    generarParser();            
		
	  	String fileName = "tests/unit/evaluation/test1.js";
		String exptext = null;
		BufferedReader br = null;
		Boolean showEntry = false;
		Boolean showPrevData = false;

		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found. ");
		}
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	            if(line != null) {
	            	sb.append("\n");
	            }
	        }
	        exptext = sb.toString();
	    } catch (IOException e) {
	    	System.out.println("An IO exception was raised. ");
	    	e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				System.out.println("An IO exception was raised. ");
				e.printStackTrace();
			}
	    };

	    if(showPrevData){
	    	System.out.println("Parsing started..");	
	    }
	    if(showEntry) {
	    	System.out.println(exptext);	
	    }
	    if(showPrevData){
	    	System.out.println("After the next line you can see the output of the compiled JS.");
		    System.out.println("*** *** ***");	
	    }

	    Ast expobj = ExpressionParser.parse(exptext);

	    if(showPrevData){
	    	System.out.println("*** *** ***");
		    System.out.println("Success!");
	    }
	}
	
	public static void generarLexer(String path){
        //File file=new File(path);
        String opciones[] = new String[3];
        opciones[0] = "-d";
        opciones[1] = "language/java/com/language/parser";
        opciones[2] = path;
        try {
            JFlex.Main.generate(opciones);
        } catch (Exception e ){
            System.out.println(e);
        }
    }
	
	public static void generarParser(){
        String opciones[] = new String[5];
        //Se selecciona la opcion de direccion de destino
        opciones[0]= "-destdir";
        //Se pasa la direccion
        opciones[1] = "language/java/com/language/parser";
        //Se selecciona la opcion de nombre de archivo
        opciones[2] = "-parser";
        //Se pasa el nombre que tendra el archivo del parser
        opciones[3] = "Parser";
        //Se pasa la ubicacion del archivo cup
        opciones[4] = "language/cup/Parser.cup";
        
        try{
            java_cup.Main.main(opciones);
        }   catch (Exception e){
                System.out.println(e);
        }
    }

}
