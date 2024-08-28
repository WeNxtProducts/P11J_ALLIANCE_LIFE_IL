package com.iii.pel.forms.PILM075_APAC;

import java.util.ArrayList;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_END_SETUP_DET_HELPER1 {

	public ArrayList POST_QUERY(String ESD_CODE) throws  Exception{
		ArrayList description = null;
		description = DBProcedures.P_VAL_SYSTEM("IL_ENDT_PARA", ESD_CODE, "N");
		return description;
	}
}
