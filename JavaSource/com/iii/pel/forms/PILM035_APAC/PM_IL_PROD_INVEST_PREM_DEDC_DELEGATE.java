package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_INVEST_PREM_DEDC_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_INVEST_PREM_DEDC.* FROM PM_IL_PROD_INVEST_PREM_DEDC "
				+ "WHERE PIPD_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
				.getDataList_PM_IL_PROD_INVEST_PREM_DEDC().clear();
		try {
			
			/*added by raja on 30-05-2017 for ZBILQC-1726955 */
			PM_IL_PROD_INVEST_PREM_DEDC_HELPER helper=new PM_IL_PROD_INVEST_PREM_DEDC_HELPER();
			/*end*/
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pm_il_product_bean.getPROD_CODE() });
			while (resultSet.next()) {
				PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN = new PM_IL_PROD_INVEST_PREM_DEDC();
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_PROD_CODE(resultSet.getString("PIPD_PROD_CODE"));
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_SRNO(resultSet.getInt("PIPD_SRNO"));
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_TYPE(resultSet.getString("PIPD_TYPE"));
				
				/*Newly added By Dhinesh on 12-06-2017 */
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setUI_M_PIPD_TYPE_DESC(executePIPD_TYPE_DESC_STMT(PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE()));
				/*End*/
				
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_CODE(resultSet.getString("PIPD_CODE"));
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_INCL_PREM_YN(resultSet.getString("PIPD_INCL_PREM_YN"));
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_DEDC_YN(resultSet.getString("PIPD_DEDC_YN"));
				
				/*added by raja on 30-05-2017 for ZBILQC-1726955 */
				helper.POST_QUERY(PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
				/*end*/
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
						.getDataList_PM_IL_PROD_INVEST_PREM_DEDC().add(
								PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/*Newly added By Dhinesh on 12-06-2017 */
	
	public String executePIPD_TYPE_DESC_STMT(String PIPD_TYPE)
			throws Exception {
		String selectStatement = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM='IL_DEDC_TYP' AND LIV_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		String PIPD_TYPE_DESC  = null;
		try {
			
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PIPD_TYPE });
			while (resultSet.next()) {
				PIPD_TYPE_DESC = resultSet.getString("LIV_CODE_DESC");	
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return PIPD_TYPE_DESC;
	}
	
	/* End */
}
