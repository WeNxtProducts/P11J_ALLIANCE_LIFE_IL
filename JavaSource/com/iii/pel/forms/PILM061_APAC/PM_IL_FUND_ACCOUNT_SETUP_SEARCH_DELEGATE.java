package com.iii.pel.forms.PILM061_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_FUND_ACCOUNT_SETUP_SEARCH_DELEGATE {

	public ArrayList fetchMasterBlock(
			PM_IL_FUND_ACCOUNT_SETUP_SEARCH_ACTION searchAction) {
		ArrayList<PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN> masterList = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN>();
		PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN searchBean = searchAction
				.getSearchBean();
		String FAS_MAIN_ACNT_CODE = searchBean.getFAS_MAIN_ACNT_CODE();
		String FAS_SUB_ACNT_CODE = searchBean.getFAS_SUB_ACNT_CODE();
		String query = null;
		ResultSet rs = null;
		System.out.println("The pol code: " + FAS_MAIN_ACNT_CODE);
		if ((FAS_MAIN_ACNT_CODE == null || "".equals(FAS_MAIN_ACNT_CODE))
				&& (FAS_SUB_ACNT_CODE == null || "".equals(FAS_SUB_ACNT_CODE))) {
			query = "SELECT ROWID, FAS_MAIN_ACNT_CODE, FAS_SUB_ACNT_CODE, FAS_DIVN_CODE FROM PM_IL_FUND_ACCOUNT_SETUP";
		} else if ((FAS_MAIN_ACNT_CODE != null || !""
				.equals(FAS_MAIN_ACNT_CODE))
				&& (FAS_SUB_ACNT_CODE == null || "".equals(FAS_SUB_ACNT_CODE))) {
			query = "SELECT ROWID, FAS_MAIN_ACNT_CODE, FAS_SUB_ACNT_CODE, FAS_DIVN_CODE FROM PM_IL_FUND_ACCOUNT_SETUP WHERE FAS_MAIN_ACNT_CODE LIKE '"
					+ FAS_MAIN_ACNT_CODE + "'";
		} else if ((FAS_MAIN_ACNT_CODE == null || "".equals(FAS_MAIN_ACNT_CODE))
				&& (FAS_SUB_ACNT_CODE != null || !"".equals(FAS_SUB_ACNT_CODE))) {
			query = "SELECT ROWID, FAS_MAIN_ACNT_CODE, FAS_SUB_ACNT_CODE, FAS_DIVN_CODE FROM PM_IL_FUND_ACCOUNT_SETUP WHERE FAS_SUB_ACNT_CODE LIKE '"
					+ FAS_SUB_ACNT_CODE + "'";
		} else if ((FAS_MAIN_ACNT_CODE != null || !""
				.equals(FAS_MAIN_ACNT_CODE))
				&& (FAS_SUB_ACNT_CODE != null || !"".equals(FAS_SUB_ACNT_CODE))) {
			query = "SELECT ROWID, FAS_MAIN_ACNT_CODE, FAS_SUB_ACNT_CODE, FAS_DIVN_CODE FROM PM_IL_FUND_ACCOUNT_SETUP WHERE FAS_MAIN_ACNT_CODE LIKE '"
					+ FAS_MAIN_ACNT_CODE
					+ "'"
					+ " AND FAS_SUB_ACNT_CODE LIKE '" + FAS_SUB_ACNT_CODE + "'";
		}
		try {
			System.out.println("The query is: " + query);
			rs = getHandler().executeSelectStatement(query, getConnection());
			while (rs.next()) {
				PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN secondSearchBean = new PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN();
				secondSearchBean.setFAS_MAIN_ACNT_CODE(rs
						.getString("FAS_MAIN_ACNT_CODE"));
				secondSearchBean.setFAS_SUB_ACNT_CODE(rs
						.getString("FAS_SUB_ACNT_CODE"));
				secondSearchBean
						.setFAS_DIVN_CODE(rs.getString("FAS_DIVN_CODE"));
				secondSearchBean.setROWID(rs.getString("ROWID"));
				masterList.add(secondSearchBean);
			}
		} catch (Exception er) {
			er.printStackTrace();
		}
		return masterList;

	}

	

	public Connection getConnection() {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}
}
