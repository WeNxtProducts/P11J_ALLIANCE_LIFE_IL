package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_COVER_DELEGATE {
	
    public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PROD_APPL_COVER.* FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_COVER().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE(),
							});

			while (resultSet.next()) {
				PM_IL_PROD_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN = new PM_IL_PROD_APPL_COVER();
				PM_IL_PROD_APPL_COVER_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_PROD_CODE(resultSet
						.getString("PAC_PROD_CODE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_GROUP_CVR_CODE(resultSet
						.getString("PAC_GROUP_CVR_CODE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_CODE(resultSet
						.getString("PAC_COVER_CODE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MANDATORY_YN(resultSet
						.getString("PAC_MANDATORY_YN"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_DEFAULT_YN(resultSet
						.getString("PAC_DEFAULT_YN"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_TARIFF_TERM_FLAG(resultSet
						.getString("PAC_TARIFF_TERM_FLAG"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_CR_DT(resultSet
						.getDate("PAC_CR_DT"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_CR_UID(resultSet
						.getString("PAC_CR_UID"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_UPD_DT(resultSet
						.getDate("PAC_UPD_DT"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_UPD_UID(resultSet
						.getString("PAC_UPD_UID"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MAX_AGE_ON_MAT(resultSet
						.getInt("PAC_MAX_AGE_ON_MAT"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_PERIOD(resultSet
						.getInt("PAC_PERIOD"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_PREM_PAY_YRS(resultSet
						.getInt("PAC_PREM_PAY_YRS"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_BCH_CODE(resultSet
						.getString("PAC_BCH_CODE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_BCH_TERM(resultSet
						.getString("PAC_BCH_TERM"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_PRODUCTION_PERC(resultSet
						.getDouble("PAC_PRODUCTION_PERC"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_THRESHOLD_PERC(resultSet
						.getDouble("PAC_THRESHOLD_PERC"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MED_DAYS(resultSet
						.getInt("PAC_MED_DAYS"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MED_AMT(resultSet
						.getDouble("PAC_MED_AMT"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MASTER_COVER_CODE(resultSet
						.getString("PAC_MASTER_COVER_CODE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_GRP_THRESHOLD_PERC(resultSet
						.getDouble("PAC_GRP_THRESHOLD_PERC"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_RSA_CALC_YN(resultSet
						.getString("PAC_RSA_CALC_YN"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_SA_FACTOR(resultSet
						.getString("PAC_SA_FACTOR"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_SA_TARIFF(resultSet
						.getString("PAC_SA_TARIFF"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_PREM_TARIFF(resultSet
						.getString("PAC_PREM_TARIFF"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_ASSR_TYPE(resultSet
						.getString("PAC_COVER_ASSR_TYPE"));
				PM_IL_PROD_APPL_COVER_BEAN
						.setPAC_COVER_START_AGE_VAL_YN(resultSet
								.getString("PAC_COVER_START_AGE_VAL_YN"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_AGE_BASIS(resultSet
						.getString("PAC_AGE_BASIS"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_COVER_START_AGE(resultSet
						.getInt("PAC_COVER_START_AGE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MAT_PAYER_AGE(resultSet
						.getInt("PAC_MAT_PAYER_AGE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_MAT_PAYEE_AGE(resultSet
						.getInt("PAC_MAT_PAYEE_AGE"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_SA_ADD_FACTOR(resultSet
						.getString("PAC_SA_ADD_FACTOR"));
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_COOL_OF_PD(resultSet
						.getInt("PAC_COOL_OF_PD"));
				/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_ATT_CVR_YN(resultSet.getString("PAC_ATT_CVR_YN"));
				//END
/*Added by Ram on 20/11/2016 for AttachedWith field*/		
				PM_IL_PROD_APPL_COVER_BEAN.setPAC_ATT_CVR_CODE(resultSet.getString("PAC_ATT_CVR_CODE"));
				/*End*/
				
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getDataList_PM_IL_PROD_APPL_COVER().add(
								PM_IL_PROD_APPL_COVER_BEAN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
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
