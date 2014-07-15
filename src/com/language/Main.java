package com.language;

import java.io.*;

import com.language.controller.VariablesController;
import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Main {
	public static void main(String[] args) throws IOException {
		//Reader fr = new BufferedReader(new FileReader(args[0]));

		String fileName = "tests/unit/evaluation/test5.js";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
            if(line != null) {
            	sb.append("\n");
            }
        }
        String exptext = sb.toString();

		br.close();

	    Ast expobj = ExpressionParser.parse(exptext);

	    //VariablesController.getInstance().showVariables();
	}
}
