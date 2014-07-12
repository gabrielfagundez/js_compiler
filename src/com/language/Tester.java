package com.language;

import java.io.*;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) throws Exception {
	  	String fileName = "tests/unit/known_functions/test1.js";
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
}
