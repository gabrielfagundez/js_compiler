package com.language;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Tester {

	public static void main(String[] args) {

		String exptext = "NaN - NaN;";
		Expression expobj = ExpressionParser.parse(exptext);

	}

}
