package com.language.model;

import java.util.List;

public class Utils {
	public static String arrayToString(List<Object> array) {
		String array_return = "";
		for(int i=0;i<array.size();i++){
			if (array.get(i) instanceof List){
				array_return += arrayToString((List)array.get(i));
			}else{
				array_return += array.get(i).toString();
				array_return += ",";
			}
		}

//		String array_string = array.toString();

		return array_return.substring(0, array_return.length());
	}
	
	public static String arrayToStringWithJoin(List<Object> array, String join) {
		String array_return = "";
		for(int i=0;i<array.size();i++){
			if (array.get(i) instanceof List){
				array_return += arrayToString((List)array.get(i));
				array_return = array_return.substring(0,array_return.length()-1);
			}else{
				array_return += array.get(i).toString();
			}
			array_return += join;
		}
	
		return array_return.substring(0,array_return.length()-join.length());
	}
}
