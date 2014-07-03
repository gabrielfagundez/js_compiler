package com.language;

import java.io.*;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		String fileName = "tests/unit/syntax/test1.js";
		String exptext = null;
		BufferedReader br = null;

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

	    System.out.println("Parsing started..");
	    System.out.println(exptext);
	    System.out.println("");
	    System.out.println("");
		Expression expobj = ExpressionParser.parse(exptext);

		//System.out.println("Parsing exitoso");

	}

}
