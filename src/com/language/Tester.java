package com.language;

import com.language.model.expression.Expression;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		String exptext = "var esteEsElNombreLPM = 1, esteEsElOtro = 'asdasda', yEsteEsForlan = 1.3";

		Expression expobj = ExpressionParser.parse(exptext);

		System.out.println("Expresion obtenida: ");
		System.out.println(expobj.toString());

	}

}
