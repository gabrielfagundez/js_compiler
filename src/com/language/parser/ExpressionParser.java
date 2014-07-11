package com.language.parser;

import java.io.ByteArrayInputStream;

import java_cup.runtime.Symbol;

import com.language.exceptions.ParsingException;
import com.language.model.*;

public class ExpressionParser {

	public static Ast parse(String expText) throws Exception {

		byte[] expbytes = expText.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(expbytes);

		Parser parser = new Parser(new Scanner(bais));
//		try {
			Symbol topsym = parser.parse();

			Ast exp = (Ast) topsym.value;
			return exp;

//		} catch (Throwable ex) {
//			throw new ParsingException("Error parsing source: " + ex.getMessage());
//		}

	}
}
