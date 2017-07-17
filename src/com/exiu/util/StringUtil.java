package com.exiu.util;

public class StringUtil {
	public static boolean isEmpty(String carPlate) {
		if (null == carPlate || carPlate.length() == 0) {
			return true;
		}
		return false;
	}
}
