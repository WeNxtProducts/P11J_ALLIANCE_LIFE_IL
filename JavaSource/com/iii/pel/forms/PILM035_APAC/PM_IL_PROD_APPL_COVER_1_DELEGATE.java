package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_COVER_1_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_APPL_COVER.* FROM PM_IL_PROD_APPL_COVER "
				+ "WHERE PAC_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_APPL_COVER_1_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_COVER_1().clear();
		try {
			connection = CommonUtils.getConnection();
			Object[] values = new Object[] { pm_il_product_bean.getPROD_CODE() };

			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, values);
			PM_IL_PROD_APPL_COVER_1 PM_IL_PROD_APPL_COVER_1_BEAN = new PM_IL_PROD_APPL_COVER_1();
			while (resultSet.next()) {
					PM_IL_PROD_APPL_COVER_1_BEAN.setROWID(resultSet
							.getString("ROWID"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_COVER_CODE(resultSet
							.getString("PAC_COVER_CODE"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_MANDATORY_YN(resultSet
							.getString("PAC_MANDATORY_YN"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_DEFAULT_YN(resultSet
							.getString("PAC_DEFAULT_YN"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_TARIFF_TERM_FLAG(resultSet
							.getString("PAC_TARIFF_TERM_FLAG"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_CR_DT(resultSet
							.getDate("PAC_CR_DT"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_CR_UID(resultSet
							.getString("PAC_CR_UID"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_UPD_DT(resultSet
							.getDate("PAC_UPD_DT"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_UPD_UID(resultSet
							.getString("PAC_UPD_UID"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_MAX_AGE_ON_MAT(resultSet
							.getInt("PAC_MAX_AGE_ON_MAT"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_PERIOD(resultSet
							.getInt("PAC_PERIOD"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_PREM_PAY_YRS(resultSet
							.getInt("PAC_PREM_PAY_YRS"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_BCH_CODE(resultSet
							.getString("PAC_BCH_CODE"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_BCH_TERM(resultSet
							.getString("PAC_BCH_TERM"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_PRODUCTION_PERC(resultSet
							.getDouble("PAC_PRODUCTION_PERC"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_THRESHOLD_PERC(resultSet
							.getDouble("PAC_THRESHOLD_PERC"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_MED_DAYS(resultSet
							.getInt("PAC_MED_DAYS"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_MED_AMT(resultSet
							.getDouble("PAC_MED_AMT"));
					PM_IL_PROD_APPL_COVER_1_BEAN
							.setPAC_GRP_THRESHOLD_PERC(resultSet
									.getDouble("PAC_GRP_THRESHOLD_PERC"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_COVER_ASSR_TYPE(resultSet
							.getString("PAC_COVER_ASSR_TYPE"));
					PM_IL_PROD_APPL_COVER_1_BEAN
							.setPAC_COVER_START_AGE_VAL_YN(resultSet
									.getString("PAC_COVER_START_AGE_VAL_YN"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_AGE_BASIS(resultSet
							.getString("PAC_AGE_BASIS"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_COVER_START_AGE(resultSet
							.getInt("PAC_COVER_START_AGE"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_MAT_PAYER_AGE(resultSet
							.getInt("PAC_MAT_PAYER_AGE"));
					PM_IL_PROD_APPL_COVER_1_BEAN.setPAC_MAT_PAYEE_AGE(resultSet
							.getInt("PAC_MAT_PAYEE_AGE"));
					new PM_IL_PROD_APPL_COVER_1_HELPER().POST_QUERY(PILM035_APAC_COMPOSITE_ACTION_BEAN);
			}
			PILM035_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_PROD_APPL_COVER_1_ACTION_BEAN()
					.getDataList_PM_IL_PROD_APPL_COVER_1().add(
							PM_IL_PROD_APPL_COVER_1_BEAN);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<LovBean> prepareLovList(String query, Object[] obj) {

		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
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
			}
		}
		return suggestionList;
	}

}
