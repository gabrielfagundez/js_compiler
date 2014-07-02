package com.language;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		//String exptext = "while (a == b) { var a = true; var b = 4; var c = [1,2,3]; };";
		String exptext = "for (var a = 1; a > 5; a++) { var a = true; var b = 4; var c = [1,2,3]; };";
		
		Expression expobj = ExpressionParser.parse(exptext);
		
		System.out.println("Parsing exitoso");

	}

}
