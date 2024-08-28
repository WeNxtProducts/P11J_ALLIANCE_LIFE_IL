package com.iii.pel.forms.PILM039;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PILM039Helper {
	public boolean isValidNumber(String name) {
		char[] str = new char[name.length()];
		name.getChars(0, name.length(), str, 0);
		for (int i = 0; i < str.length; i++) {
			if ((Character.getNumericValue(str[i]) < 10 || Character
					.getNumericValue(str[i]) > 35)
					&& Character.isSpaceChar(str[i]) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isCheckValue1Pattern(String value) {
		boolean flag = false;

		Pattern pattern = Pattern.compile("^[+]?\\d+(\\.\\d+)?$");
		Matcher matcher = pattern.matcher(value);
		if ((matcher.matches())) {
			flag = true;
		}
		return flag;
	}

	public static boolean isCheckValue(String textValue) {
		boolean result = false;
		String numberList = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuiopasdfghjklzxcvbnm,./';][`~!@#$%^&*()_-+=\\";
		for (int i = 0; i < textValue.length(); i++) {
			if (numberList.indexOf(textValue.charAt(i)) != -1) {
				result = true;
			}
		}
		if (result == true) {
			System.out.println("Is String / Special Character ");
		} else {
			System.out.println("Is Number ");
		}

		return result;
	}

	public static void main(String[] args) {
		if(isCheckValue1Pattern("02222@"))
		{
			System.out.println("is Number");
		}
		else
		{
			System.out.println("is Not Number");
		}
	}

	public boolean isDouble(String boolString) {
		boolean checkCondition = false;
		try {

			if (isValidNumber(boolString)) {
				checkCondition = true;
			} else {
				checkCondition = false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return checkCondition;
	}
}
