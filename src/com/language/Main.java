package com.language;

import java.io.*;

import com.language.model.*;
import com.language.parser.ExpressionParser;

public class Main {
	public static void main(String[] args) throws IOException {
		//Reader fr = new BufferedReader(new FileReader(args[0]));
		String fileName = System.getProperty("user.dir")+ "/tests/";
		if (args.length == 2){
			fileName += args[1] + "/" +args[0] ;
		}else if (args.length == 3){
			fileName += args[2] + "/" + args[1] + "/" +args[0] ;
		}else if (args.length == 4){
			fileName += args[3] + "/" + args[2] + "/" + args[1] + "/" +args[0] ;
		}else{
			fileName = "tests/functional/iva.js";
		}
		
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
	}
}
