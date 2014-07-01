package com.language;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		String exptext = "var a = true, b, c; var d = 4;";
		Expression expobj = ExpressionParser.parse(exptext);

	}

}
