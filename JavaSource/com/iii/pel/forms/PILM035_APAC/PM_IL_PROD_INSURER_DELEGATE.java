package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_INSURER_DELEGATE {
	
    public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PAT_AGE_FM,PAT_AGE_TO,PAT_SA_FM,PAT_SA_TO,PAT_TERM_FM,PAT_TERM_TO FROM PM_IL_PROD_APPL_TERM WHERE pat_prod_code = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN()
				.getDataList_PM_IL_PROD_Insurer().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE(),
							});

			while (resultSet.next()) {
				PM_IL_PROD_INSURER PM_IL_PROD_APPL_COVER_BEAN = new PM_IL_PROD_INSURER();
				PM_IL_PROD_APPL_COVER_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_APPL_COVER_BEAN.setPT_AGE_FROM(resultSet.getInt("PAT_AGE_FM"));
				PM_IL_PROD_APPL_COVER_BEAN.setPT_AGE_TO(resultSet.getInt("PAT_AGE_TO"));
				PM_IL_PROD_APPL_COVER_BEAN.setPT_SUM_ASSR_FROM(resultSet.getInt("PAT_SA_FM"));
				PM_IL_PROD_APPL_COVER_BEAN.setPT_SUM_ASSR_TO(resultSet.getInt("PAT_SA_TO"));
				PM_IL_PROD_APPL_COVER_BEAN.setPT_TERM_FROM(resultSet.getInt("PAT_TERM_FM"));
				PM_IL_PROD_APPL_COVER_BEAN.setPT_TERM_TO(resultSet.getInt("PAT_TERM_TO"));
				
				compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN().getDataList_PM_IL_PROD_Insurer().add(
								PM_IL_PROD_APPL_COVER_BEAN);
			}

			/*if(compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN().getDataList_PM_IL_PROD_Insurer()!=null &&
					!compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN().getDataList_PM_IL_PROD_Insurer().isEmpty()){
				PM_IL_PROD_INSURER pm_il_prod_insurer = compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN().getDataList_PM_IL_PROD_Insurer().get(0);
			}*/
			
				List<PM_IL_PROD_INSURER> dataList = compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN().getDataList_PM_IL_PROD_Insurer();
				if (dataList != null && dataList.size() > 0) {
					PM_IL_PROD_INSURER PM_IL_PROD_INSURER_BEAN = dataList
							.get(0);
					PM_IL_PROD_INSURER_BEAN.setRowSelected(true);
					compositeAction.getPM_IL_PROD_INSURER_ACTION_BEAN()
							.setPM_IL_PROD_INSURER(
									PM_IL_PROD_INSURER_BEAN);
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
