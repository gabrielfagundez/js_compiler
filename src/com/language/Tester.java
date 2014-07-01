package com.language;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		String exptext = "/* a continuaci—n se muestra un mensaje */ var a = 1 + 20 + 13 + (2 + 2 + 8)";

		Expression expobj = ExpressionParser.parse(exptext);

		System.out.println("Expresion obtenida: ");
		System.out.println(expobj.toString());

	}

}
