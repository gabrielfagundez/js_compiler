package com.language;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		String exptext = "var a = false, b, c; var d = 4; var x = false; console.log(d); console.log(a);";
		Expression expobj = ExpressionParser.parse(exptext);

	}

}
