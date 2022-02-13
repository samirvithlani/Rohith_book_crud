package com.util;

public class ValidationUtil {

	public static boolean isEmpty(String param) {

		boolean flag = false;
		if (param.trim() == null || param.trim().equals("")) {

			flag = true;
		}

		return flag;
	}
}
