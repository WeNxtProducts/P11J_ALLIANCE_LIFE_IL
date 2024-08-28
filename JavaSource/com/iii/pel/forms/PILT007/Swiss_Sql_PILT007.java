package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class Swiss_Sql_PILT007 {

	public void PRE_FORM(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		String sql_BUY_SELL = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_PILT007_QUERY2;

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();

		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_BASE_CURR = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		String P_CURR_CODE = null;
		int P_DECIMAL = -1;
		String P_NAME = null;
		DBProcedures dbProcedures = new DBProcedures();
		try {
			PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
			claimAction.getPT_IL_CLAIM_BEAN().setUI_M_BASE_CURR(CommonUtils.getControlBean().getM_BASE_CURR());
			String BUY_SELL = null;
			rst1 = handler.executeSelectStatement(sql_BUY_SELL, CommonUtils.getConnection(),
					new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1") });
			while (rst1.next()) {
				BUY_SELL = rst1.getString("DS_CURR_RATE_BS");
			}
			claimAction.getPT_IL_CLAIM_BEAN().setUI_M_BUY_SELL(BUY_SELL);
			claimAction.getPT_IL_CLAIM_BEAN().setUI_M_PT_IL_CLAIM_BENEFICIARY_CF("N");
			claimAction.getPT_IL_CLAIM_BEAN().setUI_M_PT_IL_CLAIM_PAID_CF("P");
			String IL_CALC_MTHD = new PILT007_PROCEDURE().P_VAL_SYSTEM(
					CommonUtils.getConnection(), "IL_CALC_MTHD", "IL_CALC_MTHD", "E", null);
			claimAction.getPT_IL_CLAIM_BEAN().setUI_M_CALC_METHOD(IL_CALC_MTHD);

			String IL_BEN_LMT = new PILT007_PROCEDURE().P_VAL_SYSTEM(
					CommonUtils.getConnection(), "IL_BEN_LMT", "IL_BEN_LMT", "N", null);
			claimAction.getPT_IL_CLAIM_BEAN().setUI_M_IL_BEN_VALUE(new Double(IL_BEN_LMT));
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rst);CommonUtils.closeCursor(rst1);} catch (Exception e) {
				
			}
		}
	}

	public void whenNewFormInstance(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		
		if (CommonUtils.getGlobalVariable("CALLING_FORM").equals("PILT006_APAC")) {
			PT_IL_CLAIM_ACTION claimAction = compositeAction.getPILT007_PT_IL_CLAIM_ACTION();
			claimAction.setUI_M_BUT_MAIN_DIS(true);
			try {
				new PT_IL_CLAIM_HELPER().preQuery(compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN());
				new PT_IL_CLAIM_HELPER().executeQuery(compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN());
				new PT_IL_CLAIM_HELPER().postQuery(compositeAction);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	

}
