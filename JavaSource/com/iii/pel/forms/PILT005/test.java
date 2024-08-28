package com.iii.pel.forms.PILT005;


public class test {
	public static void main(String[] args) {
		String str="1234.2";
		String z = "";
		String[] tok = str.split("\\.");
		if(tok[0].length()<5){
			
			int x = 5 - tok[0].length();
			for(int n=1;n<=x;n++){
				z=z+"z";
			}
//			System.out.println(z+tok[0]);
		}
		String d = "";
		if(tok[1].length()<5){
			
			int y = 5 - tok[1].length();
			for(int n=1;n<=y;n++){
				d=d+"x";
			}
			System.out.println(tok[1]+d);
		}
		str = z+tok[0]+"."+tok[1]+d;
		System.out.println("Final String = "+str);
	}
}
