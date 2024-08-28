package com.iii.pel.forms.PILM061_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_ACTION;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_FUND_ACCOUNT_SETUP_DELEGATE {

	private List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_SRC_BUS_FM_TO(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			System.out.println("I am in if ");
			query = "SELECT PC_CODE, PC_DESC FROM PM_CODES WHERE PC_TYPE = 'SRC_BUS_TY' "
					+ "AND NVL(PC_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25";
		} else {
			System.out.println("I am in else ");
			query = "SELECT PC_CODE, PC_DESC FROM PM_CODES WHERE PC_TYPE = 'SRC_BUS_TY' "
					+ "AND NVL(PC_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25 AND PC_CODE LIKE '"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The PC_CODE is: " + rs.getString("PC_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_SRC_BUS_FM(rs.getString("PC_CODE"));
			fundAccountSetupLov.setFAS_SRC_BUS_FM_DESC(rs.getString("PC_DESC"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		System.out.println("Hey");
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_DIVN_FM_TO_CODE(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			/*
			 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to
			 * FM_DIVISION. Added by : Mallika.S, 31-Mar-2009
			 */
			System.out.println("I am in if ");
			query = "SELECT DIVN_CODE, DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '"
					+ pilfasa.COMP_CODE
					+ "' "
					+ "AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP "
					+ "WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
					+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25";
		} else {
			System.out.println("I am in else ");
			query = "SELECT DIVN_CODE, DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '"
					+ pilfasa.COMP_CODE
					+ "' "
					+ "AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP "
					+ "WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
					+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25 "
					+ "AND DIVN_CODE LIKE '"
					+ obj.toString().toUpperCase()
					+ "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out
					.println("The PROD_CODE is: " + rs.getString("DIVN_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_DIVN_FM_CODE(rs.getString("DIVN_CODE"));
			fundAccountSetupLov.setFAS_DIVN_FM_CODE_DESC(rs
					.getString("DIVN_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}


	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_DEPT_TO_CODE(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The Division Component's value: "
				+ pilfasa.getCOMP_FAS_DIVN_TO_CODE().getValue());
		if (obj.toString().equals("*")) {
			System.out.println("I am in if ");
			/*
			 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to
			 * FM_DEPARTMENT. Added by : Mallika.S, 31-Mar-2009
			 */
			query = "select DEPT_CODE, DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '"
					+ pilfasa.COMP_CODE
					+ "' "
					+ "AND DEPT_DIVN_CODE = '"
					+ pilfasa.getCOMP_FAS_DIVN_TO_CODE().getValue()
					+ "' AND DEPT_FRZ_FLAG  = 'N' "
					+ "AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE "
					+ "AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
					+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25";
		} else {
			System.out.println("I am in else ");
			query = "select DEPT_CODE, DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '"
					+ pilfasa.COMP_CODE
					+ "' "
					+ "AND DEPT_DIVN_CODE = '"
					+ pilfasa.getCOMP_FAS_DIVN_TO_CODE().getValue()
					+ "' AND DEPT_FRZ_FLAG  = 'N' "
					+ "AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE "
					+ "AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
					+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25 AND DEPT_CODE LIKE '"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out
					.println("The PROD_CODE is: " + rs.getString("DEPT_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_DEPT_TO_CODE(rs.getString("DEPT_CODE"));
			fundAccountSetupLov.setFAS_DEPT_TO_CODE_DESC(rs
					.getString("DEPT_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_DOC_CODE_FM_TO(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			System.out.println("I am in if ");
			query = "SELECT DS_CODE, DS_DESC FROM PM_IL_DOC_SETUP "
					+ "WHERE (DS_TYPE = '2' OR DS_TYPE = '') AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND ROWNUM<=25";
		} else {
			System.out.println("I am in else ");
			query = "SELECT DS_CODE, DS_DESC FROM PM_IL_DOC_SETUP "
					+ "WHERE (DS_TYPE = '2' OR DS_TYPE = '') AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND ROWNUM<=25"
					+ " AND DS_CODE LIKE '" + obj.toString().toUpperCase()
					+ "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The DS_CODE is: " + rs.getString("DS_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_DOC_FM_TYPE(rs.getString("DS_CODE"));
			fundAccountSetupLov
					.setFAS_DOC_FM_TYPE_DESC(rs.getString("DS_DESC"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_PROD_CODE_FM_TO(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			System.out.println("I am in if ");
			query = "select PROD_CODE, PROD_DESC from PM_IL_PRODUCT where PROD_CODE IS NOT NULL AND ROWNUM<=25";
		} else {
			System.out.println("I am in else ");
			query = "select PROD_CODE, PROD_DESC from PM_IL_PRODUCT where PROD_CODE IS NOT NULL AND ROWNUM<=25"
					+ " AND PROD_CODE LIKE '"
					+ obj.toString().toUpperCase()
					+ "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out
					.println("The PROD_CODE is: " + rs.getString("PROD_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_PROD_CODE_FM(rs.getString("PROD_CODE"));
			fundAccountSetupLov
					.setFAS_PROD_CODE_DESC(rs.getString("PROD_DESC"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_FUND_CODE_FM_TO(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			query = "select FS_CODE, FS_DESC FROM PM_IL_FUND_SETUP WHERE 1=1 AND ROWNUM<=25";
		} else {
			query = "select FS_CODE, FS_DESC FROM PM_IL_FUND_SETUP WHERE 1=1 AND ROWNUM<=25"
					+ " AND FS_CODE LIKE '"
					+ obj.toString().toUpperCase()
					+ "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The FUND_CODE is: " + rs.getString("FS_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_FUND_CODE_FM(rs.getString("FS_CODE"));
			fundAccountSetupLov.setFAS_FUND_CODE_DESC(rs.getString("FS_DESC"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_NARRATION_CODE(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			query = "SELECT PS_CODE,PS_CODE_DESC  FROM PP_SYSTEM WHERE PS_TYPE = 'IL_ACCDESC' AND ROWNUM<=25";
		} else {
			query = "SELECT PS_CODE,PS_CODE_DESC  FROM PP_SYSTEM WHERE PS_TYPE = 'IL_ACCDESC' AND ROWNUM<=25"
					+ " AND PS_CODE LIKE '"
					+ obj.toString().toUpperCase()
					+ "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The FUND_CODE is: " + rs.getString("PS_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_NARRATION_CODE(rs.getString("PS_CODE"));
			fundAccountSetupLov.setFAS_NARRATION_CODE_DESC(rs
					.getString("PS_CODE_DESC"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_MAIN_ACNT_CODE(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			query = "SELECT MAIN_ACNT_CODE, MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25";
		} else {
			query = "SELECT MAIN_ACNT_CODE, MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25"
					+ " AND MAIN_ACNT_CODE LIKE '"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The FUND_CODE is: "
					+ rs.getString("MAIN_ACNT_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_MAIN_ACNT_CODE(rs
					.getString("MAIN_ACNT_CODE"));
			fundAccountSetupLov.setFAS_MAIN_ACNT_NAME(rs
					.getString("MAIN_ACNT_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_SUB_ACNT_CODE(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			query = "SELECT SUB_ACNT_CODE, SUB_ACNT_NAME FROM FM_SUB_ACCOUNT "
					+ "WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE"
					+ " FROM FM_MAIN_SUB"
					+ " WHERE MS_MAIN_ACNT_CODE = '"
					+ pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN()
							.getFAS_MAIN_ACNT_CODE()
					+ "') AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25";
		} else {
			query = "SELECT SUB_ACNT_CODE, SUB_ACNT_NAME FROM FM_SUB_ACCOUNT "
					+ "WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE"
					+ " FROM FM_MAIN_SUB"
					+ " WHERE MS_MAIN_ACNT_CODE = '"
					+ pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN()
							.getFAS_MAIN_ACNT_CODE()
					+ "') AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25"
					+ " AND SUB_ACNT_CODE LIKE '"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_SUB_ACNT_CODE(rs
					.getString("SUB_ACNT_CODE"));
			fundAccountSetupLov.setFAS_SUB_ACNT_DESC(rs
					.getString("SUB_ACNT_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}


	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_BRANCH(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		
		if (obj.toString().equals("*")) {
			query = "select DEPT_CODE, DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE ="
					+ pilfasa.COMP_CODE
					+ " AND DEPT_DIVN_CODE = '"
					+ pilfasa.getCOMP_FAS_DIVN_CODE().getValue()
					+ "' AND DEPT_FRZ_FLAG  = 'N' "
					+ "AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE "
					+ "AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
					+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25";
		} else {
			query = "select DEPT_CODE, DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE ="
					+ pilfasa.COMP_CODE
					+ " AND DEPT_DIVN_CODE = '"
					+ pilfasa.getCOMP_FAS_DIVN_CODE().getValue()
					+ "' AND DEPT_FRZ_FLAG  = 'N' "
					+ "AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE "
					+ "AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
					+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25 AND DEPT_CODE LIKE '%"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_DEPT_CODE(rs.getString("DEPT_CODE"));
			fundAccountSetupLov
					.setFAS_DEPT_CODE_DESC(rs.getString("DEPT_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public void branchValidation(PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa) {
		
		if (suggestionList.size() > 0 && !pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getFAS_DIVN_CODE().equals("")) {
			for (int j = 0; j < suggestionList.size(); j++) {
				if (pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getFAS_DIVN_CODE().equalsIgnoreCase(
								suggestionList.get(j).getFAS_DIVN_FM_CODE())) {
					pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setUI_M_DIVN_NAME(
							suggestionList.get(j).getFAS_DIVN_FM_CODE_DESC());
				}
			}
		}
	}

	public void departmentValidation(PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa) {
		for (int j = 0; j < suggestionList.size(); j++) {
			if (pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getFAS_DEPT_CODE()
					.equalsIgnoreCase(suggestionList.get(j).getFAS_DEPT_CODE())) {
				pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setUI_M_DEPT_NAME(
						suggestionList.get(j).getFAS_DEPT_CODE_DESC());
			}
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_ANLY_CODE_1(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			query = "SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25";
		} else {
			query = "SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'"
					+ " AND ROWNUM<=25"
					+ " AND ANLY_CODE LIKE '"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The Analysis is: " + rs.getString("ANLY_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_ANLY_CODE_1(rs.getString("ANLY_CODE"));
			fundAccountSetupLov.setFAS_ANLY_CODE_1_DESC(rs
					.getString("ANLY_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public void analysisCode1Validation(PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa) {
		for (int j = 0; j < suggestionList.size(); j++) {
			if (pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN()
					.getFAS_ANLY_CODE_1().equalsIgnoreCase(
							suggestionList.get(j).getFAS_ANLY_CODE_1())) {
				pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setUI_M_ANLY_NAME(
										suggestionList.get(j).getFAS_ANLY_CODE_1_DESC());
			}
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFAS_ANLY_CODE_2(
			PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa, Object obj)
			throws Exception {
		suggestionList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		System.out.println("The obj value is: " + obj.toString());
		if (obj.toString().equals("*")) {
			query = "SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25";
		} else {
			query = "SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'"
					+ " AND ROWNUM<=25"
					+ " AND ANLY_CODE LIKE '"
					+ obj.toString().toUpperCase() + "%'";
		}
		System.out.println("The query is: " + query);
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The Analysis is: " + rs.getString("ANLY_CODE"));
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_ANLY_CODE_2(rs.getString("ANLY_CODE"));
			fundAccountSetupLov.setFAS_ANLY_CODE_2_DESC(rs
					.getString("ANLY_NAME"));
			suggestionList.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList;
	}

	public void analysisCode2Validation(PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa) {
		for (int j = 0; j < suggestionList.size(); j++) {
			if (pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getFAS_ANLY_CODE_2().equalsIgnoreCase(
							suggestionList.get(j).getFAS_ANLY_CODE_2())) {
				pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN()
				.setUI_M_ANLY_NAME_1(
						suggestionList.get(j).getFAS_ANLY_CODE_2_DESC());
			}
		}
	}

	public int saveDelegate(PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa)
			throws Exception {
		System.out.println("I am in Save Method of DELEGATE: "
				+ pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN()
						.getFAS_ANLY_CODE_1());
		int i = getHandler().executeInsert(
				pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN(),
				CommonUtils.getConnection());
		CommonUtils.getConnection().commit();
		return i;
	}

	public int deleteDelegate(PM_IL_FUND_ACCOUNT_SETUP_ACTION pilfasa)
			throws Exception {
		System.out.println("I am in Delete Method"
				+ pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN()
						.getFAS_ANLY_CODE_1());
		int i = getHandler().executeDelete(
				pilfasa.getPM_IL_FUND_ACCOUNT_SETUP_BEAN(),
				CommonUtils.getConnection());
		CommonUtils.getConnection().commit();
		return i;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public String backToSearch() {
		return "PILM061_APAC_backToSearch";
	}

	public void executeSelectStatement(PM_IL_FUND_ACCOUNT_SETUP_ACTION action) throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP WHERE ROWID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		 PM_IL_FUND_ACCOUNT_SETUP  PM_IL_FUND_ACCOUNT_SETUP_BEAN = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getROWID()});
			 PM_IL_FUND_ACCOUNT_SETUP_BEAN = action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
			while (resultSet.next()) {
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SRC_BUS_FM(resultSet
						.getString("FAS_SRC_BUS_FM"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SRC_BUS_TO(resultSet
						.getString("FAS_SRC_BUS_TO"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DIVN_FM_CODE(resultSet
						.getString("FAS_DIVN_FM_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DIVN_TO_CODE(resultSet
						.getString("FAS_DIVN_TO_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DEPT_FM_CODE(resultSet
						.getString("FAS_DEPT_FM_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DEPT_TO_CODE(resultSet
						.getString("FAS_DEPT_TO_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DOC_FM_TYPE(resultSet
						.getString("FAS_DOC_FM_TYPE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DOC_TO_TYPE(resultSet
						.getString("FAS_DOC_TO_TYPE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_PROD_CODE_FM(resultSet
						.getString("FAS_PROD_CODE_FM"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_PROD_CODE_TO(resultSet
						.getString("FAS_PROD_CODE_TO"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FUND_CODE_FM(resultSet
						.getString("FAS_FUND_CODE_FM"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FUND_CODE_TO(resultSet
						.getString("FAS_FUND_CODE_TO"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_FM(resultSet
						.getInt("FAS_POL_YR_FM"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_TO(resultSet
						.getInt("FAS_POL_YR_TO"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SETUP_FOR(resultSet
						.getString("FAS_SETUP_FOR"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SEQ_NO(resultSet
						.getLong("FAS_SEQ_NO"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DIVN_YN(resultSet
						.getString("FAS_FORCE_DIVN_YN"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DEPT_YN(resultSet
						.getString("FAS_FORCE_DEPT_YN"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_MAIN_ACNT_CODE(resultSet
						.getString("FAS_MAIN_ACNT_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SUB_ACNT_CODE(resultSet
						.getString("FAS_SUB_ACNT_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DIVN_CODE(resultSet
						.getString("FAS_DIVN_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DEPT_CODE(resultSet
						.getString("FAS_DEPT_CODE"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ANLY_CODE_1(resultSet
						.getString("FAS_ANLY_CODE_1"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ANLY_CODE_2(resultSet
						.getString("FAS_ANLY_CODE_2"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_1(resultSet
						.getString("FAS_ACTY_CODE_1"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_2(resultSet
						.getString("FAS_ACTY_CODE_2"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FRZ_FLAG(resultSet
						.getString("FAS_FRZ_FLAG"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_CR_DT(resultSet
						.getDate("FAS_CR_DT"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_CR_UID(resultSet
						.getString("FAS_CR_UID"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_UPD_DT(resultSet
						.getDate("FAS_UPD_DT"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_UPD_UID(resultSet
						.getString("FAS_UPD_UID"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DRCR_FLAG(resultSet
						.getString("FAS_DRCR_FLAG"));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_NARRATION_CODE(resultSet
						.getString("FAS_NARRATION_CODE"));

			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/**
	 * Rerenders	CACS_SUB_ACNT_CODE,
	 * 				UI_M_SUB_ACNT_NAME,CACS_ACTY_CODE_1,
	 * 				UI_M_ACTY_NAME,CACS_ACTY_CODE_2,UI_M_ACTY_NAME_1
	 * @param accountSetupAction
	 * @throws DBException
	 * @throws SQLException
	 */	
	 public void L_VAL_MAIN_ACTIVITY(PM_IL_FUND_ACCOUNT_SETUP_ACTION accountSetupAction) throws DBException, SQLException 
	    {
	       ResultSet resultSet=null;
	       Connection connection=CommonUtils.getConnection();
	       CRUDHandler handler=new CRUDHandler();
	       PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN=accountSetupAction.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
	       String mainAcntcode=PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_MAIN_ACNT_CODE();
	       String   M_FLAG=null;
           String   M_ACTY_HEAD_1=null;
           String   M_ACTY_HEAD_2=null;
	       System.out.println("L_VAL_MAIN_ACTIVITY CALLED");
	        try
	        {
	        	if(mainAcntcode!=null){
	           
		            String sql_C1= " SELECT MAIN_CTL_ACNT_FLAG,MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2" +
		            		" FROM   FM_MAIN_ACCOUNT " +
		            		"  WHERE  MAIN_ACNT_CODE  = ?";
		            Object[] objects={PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_MAIN_ACNT_CODE()};
		          
		            resultSet=handler.executeSelectStatement(sql_C1, connection, objects);
		            if(resultSet.next())
		            {
		                M_FLAG=resultSet.getString(1);
		                M_ACTY_HEAD_1=resultSet.getString(2);
		                M_ACTY_HEAD_2=resultSet.getString(3);
		            }
		            else{
		                M_FLAG = "X";
		            }
		           
		            if(!M_FLAG.equals("C"))
		            {
		            	accountSetupAction.getCOMP_FAS_SUB_ACNT_CODE().setRequired(false);
		            	accountSetupAction.getCOMP_FAS_SUB_ACNT_CODE().setDisabled(true);
		            	String subAcntCode=PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SUB_ACNT_CODE(); 
		                if(subAcntCode != null)
		                {
		                	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SUB_ACNT_CODE(null);
		                	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
		                }
		            }
		            else
		            {
		                accountSetupAction.getCOMP_FAS_SUB_ACNT_CODE().setRequired(true);
		                accountSetupAction.getCOMP_FAS_SUB_ACNT_CODE().setDisabled(false);
		                PM_IL_FUND_ACCOUNT_SETUP_BEAN.
		                setFAS_SUB_ACNT_CODE(PM_IL_FUND_ACCOUNT_SETUP_BEAN.
		                		getFAS_SUB_ACNT_CODE());
		            }
		            if(M_ACTY_HEAD_1== null)
		            {
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_1().setRequired(false);
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_1().setDisabled(true);
		            	String actyCode1=PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_1();
		                if(actyCode1 != null)
		                {
		                	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_1(null);
		                	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(null);
		                }
		            }
		            else
		            {
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_1().setRequired(true);
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_1().setDisabled(false);
		            	
		               
		            }
		            if(M_ACTY_HEAD_2== null)
		            {
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_2().setRequired(false);
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_2().setDisabled(true);
		            	String actyCode2=PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_2();
		                if(actyCode2 != null)
		                {
		                	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_2(null);
		                	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
		                }
		            }
		            else
		            {
		            	PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_2(
		            			PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_2());
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_2().setRequired(true);
		            	accountSetupAction.getCOMP_FAS_ACTY_CODE_2().setDisabled(false);
		            }
		            PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
		            PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		            
		            
	        	}
	        }
	        finally
	        {
	        	try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    }
	
}
