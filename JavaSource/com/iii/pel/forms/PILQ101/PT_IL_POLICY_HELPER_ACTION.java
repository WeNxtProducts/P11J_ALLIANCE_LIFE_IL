package com.iii.pel.forms.PILQ101;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POLICY_HELPER_ACTION {
	CRUDHandler handler = new CRUDHandler();
	CommonUtils util = new CommonUtils();
	
/*Added By saranya For The ssp Call ID : FALCONQC-1715539 */
	
	public void loadcurrency() throws DBException, Exception{
		String base_currency = null;

		ArrayList<String> pValList = new ArrayList<String>();

		pValList = DBProcedures.P_VAL_FINAL_PARAMETER(CommonUtils.getConnection(),
				"BASE.CURR", "E");
		// ('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;
		if (pValList != null && pValList.size() > 0) {
			base_currency=pValList.get(0);
		}
		CommonUtils.setGlobalObject("CURRENCY", makeCurrDecimalglobal(base_currency));	

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********"    +CommonUtils.getGlobalObject("CURRENCY"));
	}


	public int makeCurrDecimalglobal(String currcode){

		System.out.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********");
		System.out.println("currcode    : "+currcode);

		String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY where CURR_CODE= ?";

		int CURR_DECI = 0;

		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { currcode });
			if (resultSet.next()) {
				CURR_DECI = resultSet.getInt("CURR_DECIMAL");
			}

			System.out.println("CURR_DECI    : "+CURR_DECI);
			CommonUtils.setGlobalObject("GLOBAL.CURR_DECIMAL", CURR_DECI);
			System.out.println("Dhinesh------GLOBAL.CURR_DECIMAL    : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CURR_DECI;
	} 
	
	/*End*/
	

}
