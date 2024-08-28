package com.iii.pel.forms.PILM105_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PM_PROD_APPL_FIELDS_DELEGATE {
	public void executeSelectStatement(
			PILM105_APAC_COMPOSITE_ACTION PILM105_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_PROD_APPL_FIELDS.* FROM PM_PROD_APPL_FIELDS WHERE PPAF_PROD_CODE = ? ";
		String selectProd = "SELECT PPAF_PROD_CODE FROM PM_PROD_APPL_FIELDS WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSetPROD = null;
		String prodCode = null;
		PILM105_APAC_COMPOSITE_ACTION_BEAN.getPM_PROD_APPL_FIELDS_ACTION_BEAN()
				.getDataList_PM_PROD_APPL_FIELDS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSetPROD = new CRUDHandler().executeSelectStatement(selectProd, connection,
								new Object[]{PILM105_APAC_COMPOSITE_ACTION_BEAN.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getPM_PROD_APPL_FIELDS_BEAN().getROWID()});
			if(resultSetPROD.next()){
				prodCode = resultSetPROD.getString(1);
			}
			
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{prodCode});
			while (resultSet.next()) {
				PM_PROD_APPL_FIELDS PM_PROD_APPL_FIELDS_BEAN = new PM_PROD_APPL_FIELDS();
				PM_PROD_APPL_FIELDS_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_PROD_CODE(resultSet
						.getString("PPAF_PROD_CODE"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_COL_CODE(resultSet
						.getString("PPAF_COL_CODE"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_COL_NAME(resultSet
						.getString("PPAF_COL_NAME"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_MAND_YN(resultSet
						.getString("PPAF_MAND_YN"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_CR_DT(resultSet
						.getDate("PPAF_CR_DT"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_CR_UID(resultSet
						.getString("PPAF_CR_UID"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_UPD_DT(resultSet
						.getDate("PPAF_UPD_DT"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_UPD_UID(resultSet
						.getString("PPAF_UPD_UID"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX1(resultSet
						.getString("PPAF_FLEX1"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX2(resultSet
						.getString("PPAF_FLEX2"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX3(resultSet
						.getString("PPAF_FLEX3"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX4(resultSet
						.getString("PPAF_FLEX4"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX5(resultSet
						.getString("PPAF_FLEX5"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX6(resultSet
						.getString("PPAF_FLEX6"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX7(resultSet
						.getString("PPAF_FLEX7"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX8(resultSet
						.getString("PPAF_FLEX8"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX9(resultSet
						.getString("PPAF_FLEX9"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_FLEX10(resultSet
						.getString("PPAF_FLEX10"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_NMAND_YN(resultSet
						.getString("PPAF_NMAND_YN"));
				PM_PROD_APPL_FIELDS_BEAN.setPPAF_COL_CODE_DESC(resultSet.getString("PPAF_COL_NAME"));

				PILM105_APAC_COMPOSITE_ACTION_BEAN
						.getPM_PROD_APPL_FIELDS_ACTION_BEAN()
						.getDataList_PM_PROD_APPL_FIELDS().add(
								PM_PROD_APPL_FIELDS_BEAN);
			}
			
			PILM105_APAC_COMPOSITE_ACTION_BEAN.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getCOMP_PROD_CODE().setSubmittedValue(prodCode);
			PILM105_APAC_COMPOSITE_ACTION_BEAN.getPM_PROD_APPL_FIELDS_ACTION_BEAN().setProductCode(prodCode);
			PILM105_APAC_COMPOSITE_ACTION_BEAN.getPM_PROD_APPL_FIELDS_ACTION_BEAN().getCOMP_PROD_CODE().resetValue();
			
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSetPROD);
		}
	}

}