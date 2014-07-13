package com.language.parser;

import java.io.ByteArrayInputStream;

import java_cup.runtime.Symbol;

import com.language.exceptions.ParsingException;
import com.language.model.*;

public class ExpressionParser {

	public static Ast parse(String expText) {

		byte[] expbytes = expText.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(expbytes);

		Scanner scanner = new Scanner(bais);
		Parser parser = new Parser(scanner, scanner);
		try {
			Symbol topsym = parser.parse();

			Ast exp = (Ast) topsym.value;
			return exp;

		} catch (Throwable ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}
}
