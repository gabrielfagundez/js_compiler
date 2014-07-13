package com.language.model;

import java.util.List;

public class Utils {
	public static String arrayToString(List<Object> array) {

		String array_string = array.toString();

		return array_string.substring(1, array_string.length() - 1);
	}
}
