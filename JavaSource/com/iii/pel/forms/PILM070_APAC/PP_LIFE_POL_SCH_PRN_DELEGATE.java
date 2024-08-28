package com.iii.pel.forms.PILM070_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LIFE_POL_SCH_PRN_DELEGATE extends CommonAction {
    public void executeSelectStatement( PP_LIFE_POL_SCH_PRN_ACTION PP_LIFE_POL_SCH_PRN_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PP_LIFE_POL_SCH_PRN.* FROM PP_LIFE_POL_SCH_PRN WHERE ROWID=? ";
	Connection connection = null;
	ResultSet resultSet = null;
	 PP_LIFE_POL_SCH_PRN_ACTION_BEAN.getPreQueryResultList().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection,new Object[]{PP_LIFE_POL_SCH_PRN_ACTION_BEAN.getPP_LIFE_POL_SCH_PRN_BEAN().getROWID()});
	    while (resultSet.next()) {
		PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN = new PP_LIFE_POL_SCH_PRN();
		PP_LIFE_POL_SCH_PRN_BEAN.setROWID(resultSet.getString("ROWID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID(resultSet
			.getString("PLSP_MODULE_ID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_TYPE(resultSet
			.getString("PLSP_DS_TYPE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_CODE(resultSet
			.getString("PLSP_DS_CODE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_PROD_CODE(resultSet
			.getString("PLSP_PROD_CODE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_REPORT_ID(resultSet
			.getString("PLSP_REPORT_ID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_REPORT_NAME(resultSet
			.getString("PLSP_REPORT_NAME"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_TYPE(resultSet
			.getString("PLSP_TYPE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_CR_UID(resultSet
			.getString("PLSP_CR_UID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_CR_DT(resultSet
			.getDate("PLSP_CR_DT"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_NAME(resultSet
			.getString("PLSP_MODULE_NAME"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_SRNO(resultSet
			.getInt("PLSP_SRNO"));
			PP_LIFE_POL_SCH_PRN_ACTION_BEAN.getPreQueryResultList().add(
				PP_LIFE_POL_SCH_PRN_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

   /* public ArrayList fetchMasterBlock() {

	ArrayList<PP_LIFE_POL_SCH_PRN> masterList = new ArrayList<PP_LIFE_POL_SCH_PRN>();
	MODULE_ID = searchBean.getPLSP_MODULE_ID();
	String query = null;
	ResultSet rs = null;
	ResultSet resultSet = null;
	// TODO
	try {
	    rs = handler.executeSelectStatement(
			    "SELECT * FROM MENU_MENUS WHERE MENU_ACTION LIKE 'PILM070_APAC' ",
			    getConnection());
	    while (rs.next()) {
		MODULE_ID = rs.getString("MENU_PARAMETER_1");
		if (MODULE_ID == null || "".equals(MODULE_ID)) {
		    throw new Exception();
		} else {
		    // searchBean.setUI_M_PLSP_MODULE_ID(MODULE_ID);
		}

	    }

	} catch (Exception er) {
	    er.printStackTrace();
	    getErrorMap().put(
		    "current",
		    Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "3206",
			    new Object[] { "Invalid MODULE ID" }).getSummary());
	}
	if (MODULE_ID == null || "".equals(MODULE_ID)) {
	    query = "SELECT ROWID, PP_LIFE_POL_SCH_PRN.* FROM PP_LIFE_POL_SCH_PRN";
	} else if (MODULE_ID != null || !"".equals(MODULE_ID)) {
	    query = "SELECT ROWID, PP_LIFE_POL_SCH_PRN.* FROM PP_LIFE_POL_SCH_PRN WHERE PLSP_MODULE_ID = '"
		    + MODULE_ID + "' AND ROWNUM<=25";
	}
	System.out.println("The Module Id  Query is ........................"
		+ query);
	try {
	    resultSet = getHandler().executeSelectStatement(query,
		    getConnection());
	    while (resultSet.next()) {
		PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN = new PP_LIFE_POL_SCH_PRN();
		PP_LIFE_POL_SCH_PRN_BEAN.setROWID(resultSet.getString("ROWID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID(resultSet
			.getString("PLSP_MODULE_ID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_TYPE(resultSet
			.getString("PLSP_DS_TYPE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_CODE(resultSet
			.getString("PLSP_DS_CODE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_PROD_CODE(resultSet
			.getString("PLSP_PROD_CODE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_REPORT_ID(resultSet
			.getString("PLSP_REPORT_ID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_REPORT_NAME(resultSet
			.getString("PLSP_REPORT_NAME"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_TYPE(resultSet
			.getString("PLSP_TYPE"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_CR_UID(resultSet
			.getString("PLSP_CR_UID"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_CR_DT(resultSet
			.getDate("PLSP_CR_DT"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_NAME(resultSet
			.getString("PLSP_MODULE_NAME"));
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_SRNO(resultSet
			.getDouble("PLSP_SRNO"));

		masterList.add(PP_LIFE_POL_SCH_PRN_BEAN);
	    }
	    rs.close();
	    resultSet.close();
	} catch (Exception er) {
	    er.printStackTrace();
	}
	return masterList;

    }

    */     
}
