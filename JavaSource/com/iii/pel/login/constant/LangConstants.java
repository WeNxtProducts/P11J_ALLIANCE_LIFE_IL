package com.iii.pel.login.constant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.pel.login.model.LoginDelegate;
import com.iii.premia.common.utils.ListItemUtil;

public class LangConstants {
	
	private List<SelectItem> langCodeList;
	Connection connection = null;
	
	public LangConstants(){
		langCodeList = new ArrayList<SelectItem>();
		/*Modified by ganesh on 05-09-2017 for common dropdown creation*/
		/*langCodeList.add(new SelectItem("en","English"));
		langCodeList.add(new SelectItem("ge","German"));
		langCodeList.add(new SelectItem("vi","Vietnamese"));*/
		
		try {
			connection = new LoginDelegate().getConnection();
			langCodeList = ListItemUtil.getDropDownListValue(
					connection, "LOGIN", "DUMMY",
					"DUMMY.LANG", "IL_LANG_CODE");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*end*/
		
	}

	public List<SelectItem> getLangCodeList() {
		return langCodeList;
	}

}
