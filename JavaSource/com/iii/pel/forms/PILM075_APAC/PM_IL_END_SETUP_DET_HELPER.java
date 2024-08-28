package com.iii.pel.forms.PILM075_APAC;

import java.util.ArrayList;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_END_SETUP_DET_HELPER {
	
	public String  POST_QUERY(String ESD_CODE) throws Exception{
		ArrayList description = null;
		String desc="";
		try{
			description = DBProcedures.P_VAL_SYSTEM("IL_USER_PARA", ESD_CODE, "N");
		desc= (String) description.get(0);
	}catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
	return desc;
	}
	

}
