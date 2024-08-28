package com.iii.pel.forms.PILM065_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class SearchPageActionPILM065 extends CommonAction {
	
	
	private HtmlInputText ACC_MAIN_ACNT_CODE;
	private HtmlInputText ACC_SUB_ACNT_CODE;
	private HtmlInputText ACC_DIVN_CODE;
	
	private SearchPageBeanPILM065 searchBean;
	
	
	private UIDataTable searchDataTable;

	public UIDataTable getSearchDataTable() {
		return searchDataTable;
	}
	
	List<SearchPageBeanPILM065> searchList = new ArrayList<SearchPageBeanPILM065>();
	
	public SearchPageActionPILM065(){
		searchBean = new SearchPageBeanPILM065();
	}

	
	public void setSearchDataTable(UIDataTable searchDataTable) {
		this.searchDataTable = searchDataTable;
	}

	public void fetchData(ActionEvent ae){
		searchList.clear();
		ResultSet rs = null;
		try {
			String mainAccCode = (String) getACC_MAIN_ACNT_CODE().getSubmittedValue();
			String subAccCode = (String) getACC_SUB_ACNT_CODE().getSubmittedValue();
			String divisionCode = (String) getACC_DIVN_CODE().getSubmittedValue();
			
			String query="SELECT ROWID,ACC_MAIN_ACNT_CODE,ACC_SUB_ACNT_CODE,ACC_DIVN_CODE " +
			"FROM PM_IL_ACCRUAL_SETUP WHERE ACC_MAIN_ACNT_CODE LIKE '"+mainAccCode+"%' " +
			"AND ACC_SUB_ACNT_CODE LIKE '"+subAccCode+"%'" +
			"AND ACC_DIVN_CODE LIKE '"+divisionCode+"%' ";
			
			Connection conn =getConnection();
			
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next()) {
				SearchPageBeanPILM065 bean = new SearchPageBeanPILM065();
				bean.setROWID(rs.getString("ROWID"));
				bean.setACC_MAIN_ACNT_CODE(rs.getString("ACC_MAIN_ACNT_CODE"));
				bean.setACC_SUB_ACNT_CODE(rs.getString("ACC_SUB_ACNT_CODE"));
				bean.setACC_DIVN_CODE(rs.getString("ACC_DIVN_CODE"));
				searchList.add(bean);
			}
			if (searchList.size() == 0) {
				getWarningMap().put("current",
						Messages.getString("messageProperties_PILM065_APAC",
						"PILM065_APAC$PM_IL_ACCRUAL_SETUP_SEARCH$NORECORD$MESSAGE"));
			} else {
				getWarningMap().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String newRecordAction() throws Exception {
		String outcome = null;
		try {
			PM_IL_ACCRUAL_SETUP_ACTION action = new PM_IL_ACCRUAL_SETUP_ACTION();
			CommonUtils.setGlobalObject("PILM065_SEARCH_ACTION",
					action);
			outcome = "PILM065_SEARCH_ACTION";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;

	}
	
	public String executeQuery() {
		System.out.println("SearchPageActionPILM065.executeQuery()");		
		return "ACCRUAL_SETUP";
	}
	
	private Connection getConnection() throws Exception{
		Connection con = CommonUtils.getConnection();
		return con;
	}

	public HtmlInputText getACC_MAIN_ACNT_CODE() {
		return ACC_MAIN_ACNT_CODE;
	}

	public void setACC_MAIN_ACNT_CODE(HtmlInputText acc_main_acnt_code) {
		ACC_MAIN_ACNT_CODE = acc_main_acnt_code;
	}

	public HtmlInputText getACC_SUB_ACNT_CODE() {
		return ACC_SUB_ACNT_CODE;
	}

	public void setACC_SUB_ACNT_CODE(HtmlInputText acc_sub_acnt_code) {
		ACC_SUB_ACNT_CODE = acc_sub_acnt_code;
	}

	public HtmlInputText getACC_DIVN_CODE() {
		return ACC_DIVN_CODE;
	}

	public void setACC_DIVN_CODE(HtmlInputText acc_divn_code) {
		ACC_DIVN_CODE = acc_divn_code;
	}

	public List<SearchPageBeanPILM065> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<SearchPageBeanPILM065> searchList) {
		this.searchList = searchList;
	}

	public SearchPageBeanPILM065 getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(SearchPageBeanPILM065 searchBean) {
		this.searchBean = searchBean;
	}
}
