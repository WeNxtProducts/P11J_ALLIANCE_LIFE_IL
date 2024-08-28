package com.iii.pel.forms.PILT004;

public class String1 {

	public static void main(String[] args) {
		
		String original = "Can + 'you' + 'fix' + 'this' + 'to' + 'have' + 'two' + 'double' + 'quotes' ";
		String revised = "";
		for (int i = 0; i < original.length(); i++){
		char c = original.charAt(i);
		if (c == '\'') {
		revised += "''";
		}else{
		revised += c;
		}
		}
		System.out.println(original);
		System.out.println(revised);


		Object obj = null;
		
		if(obj==null){
			System.out.println("NULL2");
		}
		

	}

}
