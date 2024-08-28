package com.iii.pel.forms.PILT005;

import java.sql.Connection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.ServletContext;

import com.iii.apps.persistence.SimpleConnectionAgent;

public class CurrencyConverter implements Converter {

	
	public Object getAsObject(FacesContext ctx, UIComponent comp, String str) {
		String str1 = format(str, "$", 5, "Z", 3);
		return str1;
	}

	
	public String getAsString(FacesContext ctx, UIComponent comp, Object obj) {
//		System.out.println("Id1 = "+comp.getId()+ " Value1 = "+obj.toString());
		return null;
	}
	
	private String format(String input,String lPadStr,int lPadLen,String rPadStr,int rPadLen){
		String finalString = "";
		String lp="";
		String rp="";
		String y = "";
		String z ="";
		String[] tok = input.split("\\.");
		if(tok[0].length()< lPadLen){
			int a = lPadLen - tok[0].length();
			for(int m=1;m<=a;m++){
				y=y+lPadStr;
			}
			lp=y+tok[0];
		}
		if(tok[1].length()< rPadLen){
			int b = rPadLen - tok[1].length();
			for(int n=1;n<=b;n++){
				z=z+rPadStr;
			}
			rp=tok[1]+z;
		}
		finalString = lp+"."+rp;
		return finalString;
	}
	
	private String procedure() throws Exception{
		
		return "";
	}
	
	private Connection getConnection() throws Exception{
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection con = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");
		return con;
	}
}
