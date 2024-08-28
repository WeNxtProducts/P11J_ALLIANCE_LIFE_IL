/**
 * 
 */
package com.iii.pel.forms.PILQ109;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILQ108_APAC.PILQ108_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILQ108_APAC.POLICY_DETAILS;
import com.iii.pel.forms.PILQ108_APAC.POLICY_DETAILS_HELPER;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55944
 *
 */
public class PT_IL_HF_DELEGATE {

	public void executeSelectStatement(
			DUMMY DUMMY_ACTION_BEAN)
			throws Exception {
		String selectStatement = "";
		Connection connection = null;
		ResultSet resultSet = null;
		List<POLICY_DETAILS > list = new ArrayList<POLICY_DETAILS>();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			
			while (resultSet.next()) {
				PT_IL_CLAIM PT_IL_CLAIM_BEAN = new PT_IL_CLAIM();
/*				PT_IL_CLAIM_BEAN.setR.setROWID();
				
				list.add(POLICY_DETAILS_BEAN);
*/			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}


}
