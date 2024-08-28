package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_COND_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_APPL_COND.* FROM PM_IL_PROD_APPL_COND "
				+ "WHERE PACOND_PROD_CODE = ? ORDER BY PACOND_DISP_SEQ_NO";
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] c1values = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_COND().clear();
		/*Added by Ram on 16/03/2017 for Condition Code handling*/
		int count = 0;
/*End*/		
		try {
			connection = CommonUtils.getConnection();
			c1values = new Object[] { pm_il_product_bean.getPROD_CODE() };
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, c1values);
			while (resultSet.next()) {
				/*Added by Ram on 16/03/2017 for Condition Code handling*/
				count++;
				/*End*/
				PM_IL_PROD_APPL_COND PM_IL_PROD_APPL_COND_BEAN = new PM_IL_PROD_APPL_COND();
				PM_IL_PROD_APPL_COND_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_PROD_CODE(resultSet
						.getString("PACOND_PROD_CODE"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_COND_CODE(resultSet
						.getString("PACOND_COND_CODE"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_CR_DT(resultSet
						.getDate("PACOND_CR_DT"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_CR_UID(resultSet
						.getString("PACOND_CR_UID"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_UPD_DT(resultSet
						.getDate("PACOND_UPD_DT"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_UPD_UID(resultSet
						.getString("PACOND_UPD_UID"));
				PM_IL_PROD_APPL_COND_BEAN.setUI_M_PACOND_COND_CODE_DESC(getDesc(PM_IL_PROD_APPL_COND_BEAN));
				
				/*Added by Ram on 16/03/2017 for Condition Code handling*/
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_DFLT_YN(resultSet.getString("PACOND_DFLT_YN"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_FLEX_01(resultSet.getString("PACOND_FLEX_01"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_COVER_CODE(resultSet.getString("PACOND_COVER_CODE"));
				PM_IL_PROD_APPL_COND_BEAN.setPACOND_DISP_SEQ_NO(resultSet.getInt("PACOND_DISP_SEQ_NO"));
				/*End*/
				
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
						.getDataList_PM_IL_PROD_APPL_COND().add(
								PM_IL_PROD_APPL_COND_BEAN);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	private String getDesc(PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean) throws Exception{
		ArrayList<String> retList = null;
		String desc = null;
		try {
			retList = PILM035_PROCEDURES.P_VAL_CODES("IL_COND",
					pm_il_prod_appl_cond_bean.getPACOND_COND_CODE(),
					pm_il_prod_appl_cond_bean.getUI_M_PACOND_COND_CODE_DESC(),
					"N", "E", null);
			if (retList != null) {
				desc = retList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return desc;
	}

	
	public List<LovBean> prepareLovList(String query, Object[] obj)
			throws Exception {

		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			LovBean bean = null;
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				 bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		return suggestionList;
	}
}
