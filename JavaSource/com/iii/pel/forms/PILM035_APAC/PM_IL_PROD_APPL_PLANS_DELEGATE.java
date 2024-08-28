package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_PLANS_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PROD_APPL_SUB_PLAN.* FROM PM_IL_PROD_APPL_SUB_PLAN " +
				"WHERE PAP_PROD_CODE = ? ";
		
		/*Added by kavitha on 20.07.2018 for FLALIFEQC-1757107 */
		String selectStatementOne = "SELECT SPLAN_DESC FROM PM_IL_SUB_PLAN WHERE SPLAN_CODE = ?";
		ResultSet resultSetOne = null;
		
		/*End*/
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_PLANS().clear();
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] {pm_il_product_bean.getPROD_CODE()});
			while (resultSet.next()) {
				PM_IL_PROD_APPL_SUB_PLAN PM_IL_PROD_APPL_PLANS_BEAN = new PM_IL_PROD_APPL_SUB_PLAN();
				PM_IL_PROD_APPL_PLANS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_APPL_PLANS_BEAN .setPAP_SR_NO(resultSet.getInt("PAP_SR_NO"));
 				PM_IL_PROD_APPL_PLANS_BEAN .setPAP_SUB_PLAN_CODE(resultSet.getString("PAP_SUB_PLAN_CODE"));
				PM_IL_PROD_APPL_PLANS_BEAN .setPAP_PROD_CODE(resultSet.getString("PAP_PROD_CODE"));
				
				/*Added by kavitha on 20.07.2018 for FLALIFEQC-1757107 */
				
				//new PM_IL_PROD_APPL_PLANS_HELPER().POST_QUERY(PILM035_APAC_COMPOSITE_ACTION_BEAN);
				resultSetOne = new CRUDHandler().executeSelectStatement(
						selectStatementOne, connection,
						new Object[] {PM_IL_PROD_APPL_PLANS_BEAN.getPAP_SUB_PLAN_CODE()});
				
				while (resultSetOne.next()){
				
					PM_IL_PROD_APPL_PLANS_BEAN.setUI_M_PAP_SUB_PLAN_CODE(resultSetOne.getString("SPLAN_DESC"));
			
					
					PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
						.getDataList_PM_IL_PROD_APPL_PLANS().add(
								PM_IL_PROD_APPL_PLANS_BEAN);
			}
			}
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSetOne);
		}
	}

}
