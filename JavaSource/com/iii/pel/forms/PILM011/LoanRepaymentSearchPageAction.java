package com.iii.pel.forms.PILM011;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class LoanRepaymentSearchPageAction {
	
	private HtmlInputText PC_CODE;
	private HtmlInputText PC_DESC;
	
	List<PM_CODES> searchList = new ArrayList<PM_CODES>();
	
	PM_CODES pm_codes_bean; 
	
	private UIDataTable searchDataTable;

	public UIDataTable getSearchDataTable() {
		return searchDataTable;
	}
	public void setSearchDataTable(UIDataTable searchDataTable) {
		this.searchDataTable = searchDataTable;
	}
	public LoanRepaymentSearchPageAction() {
		pm_codes_bean = new PM_CODES();
		
	}

	public List<PM_CODES> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<PM_CODES> searchList) {
		this.searchList = searchList;
	}

	public String executeQuery() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, Exception{
		PM_CODES_ACTION action = new PM_CODES_ACTION();
		Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("PILM011_PM_CODES_ACTION", action);
		action.loadValues();
		return "mainPage";
	}
	
	public String insertNavigation() {
		return "insertNavigation";
	}

	public void fetchData(ActionEvent ae){
		try {
			String query="";
			String codeValue = (String) getPC_CODE().getSubmittedValue();
			String descValue = (String) getPC_DESC().getSubmittedValue();
			
			query = "SELECT ROWID,PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE LIKE '%"+codeValue+"%' AND PC_DESC LIKE '%"+descValue+"%' AND PC_TYPE='IL_LOAN_CODE' AND NVL(PC_FRZ_FLAG,'N') = 'N' " ;
			
			CRUDHandler handler = new CRUDHandler();
			searchList = handler.fetch(query, "com.iii.pel.forms.PILM011.PM_CODES", getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	private Connection getConnection() throws Exception{
		/*ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection con = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");*/
		Connection con = CommonUtils.getConnection();
		return con;
	}
	public PM_CODES getPm_codes_bean() {
		return pm_codes_bean;
	}
	public void setPm_codes_bean(PM_CODES pm_codes_bean) {
		this.pm_codes_bean = pm_codes_bean;
	}
	public HtmlInputText getPC_CODE() {
		return PC_CODE;
	}
	public void setPC_CODE(HtmlInputText pc_code) {
		PC_CODE = pc_code;
	}
	public HtmlInputText getPC_DESC() {
		return PC_DESC;
	}
	public void setPC_DESC(HtmlInputText pc_desc) {
		PC_DESC = pc_desc;
	}
}
