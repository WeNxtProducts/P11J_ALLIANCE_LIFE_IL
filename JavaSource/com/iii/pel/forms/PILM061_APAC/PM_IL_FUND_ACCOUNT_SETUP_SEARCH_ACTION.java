package com.iii.pel.forms.PILM061_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_FUND_ACCOUNT_SETUP_SEARCH_ACTION extends CommonAction{

	private PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN searchBean;
	private List<PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN> dataTableBean;
	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;
	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;
	private UIData dataTable;

	public PM_IL_FUND_ACCOUNT_SETUP_SEARCH_ACTION(){
		searchBean = new PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN();
	}

	public String fetch(){
		PM_IL_FUND_ACCOUNT_SETUP_SEARCH_DELEGATE delegate = new PM_IL_FUND_ACCOUNT_SETUP_SEARCH_DELEGATE();
		this.dataTableBean = delegate.fetchMasterBlock(this);
		return null;
	}

	public String insert(){
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP_ACTION")!=null)
		{
			session.removeAttribute("PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP_ACTION");
		}
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "INSERT");
		sessionMap.put("CLIENT_CON", getConnection());
		return "PILM061_APAC_mainPage";
	}
	
	public String updateButtonAction(String rowId) {
		String outcome = null;
		try {
			PM_IL_FUND_ACCOUNT_SETUP_ACTION action = new PM_IL_FUND_ACCOUNT_SETUP_ACTION();
		
		CommonUtils.setGlobalObject("PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP_ACTION",
				action);
		action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
    }

    public String insertButtonAction() {
    	String outcome = null;
    	try{
    		PM_IL_FUND_ACCOUNT_SETUP_ACTION action = new PM_IL_FUND_ACCOUNT_SETUP_ACTION();
		CommonUtils.setGlobalObject("PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP_ACTION",
				action);
		outcome = "PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP";
    	}catch (Exception e) {
    		e.printStackTrace();
		}
		return outcome;
	
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

	public String fetchMasterRecord(){
		FacesContext context=FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String FAS_MAIN_ACNT_CODE = (String)map.get("FAS_MAIN_ACNT_CODE");
		String FAS_SUB_ACNT_CODE= (String)map.get("FAS_SUB_ACNT_CODE");
		String FAS_DIVN_CODE=(String)map.get("FAS_DIVN_CODE");
		String rowId=(String)map.get("ROWID");
		String selectQuery="";
		PM_IL_FUND_ACCOUNT_SETUP valueBean=null;
		PM_IL_FUND_ACCOUNT_SETUP_ACTION actionBean=null;
		List<PM_IL_FUND_ACCOUNT_SETUP> list=new ArrayList<PM_IL_FUND_ACCOUNT_SETUP>(); 
		try{
			if(!"".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && !"".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && !"".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				"FAS_MAIN_ACNT_CODE='"+FAS_MAIN_ACNT_CODE+"' and  FAS_SUB_ACNT_CODE='"+FAS_SUB_ACNT_CODE+"' and FAS_DIVN_CODE='"+FAS_DIVN_CODE+"'";
			}else if("".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && !"".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && !"".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				" FAS_SUB_ACNT_CODE='"+FAS_SUB_ACNT_CODE+"' and FAS_DIVN_CODE='"+FAS_DIVN_CODE+"'";
			}else if(!"".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && "".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && !"".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				"FAS_MAIN_ACNT_CODE='"+FAS_MAIN_ACNT_CODE+"' and FAS_DIVN_CODE='"+FAS_DIVN_CODE+"'";
			}else if(!"".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && !"".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && "".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				"FAS_MAIN_ACNT_CODE='"+FAS_MAIN_ACNT_CODE+"' and  FAS_SUB_ACNT_CODE='"+FAS_SUB_ACNT_CODE+"'";
		    }else if(!"".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && "".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && "".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				"FAS_MAIN_ACNT_CODE='"+FAS_MAIN_ACNT_CODE+"'";
			}else if("".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && !"".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && "".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				" FAS_SUB_ACNT_CODE='"+FAS_SUB_ACNT_CODE+"'";
			}else if("".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && "".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && !"".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP where ROWID='"+rowId+"' AND " +
				" FAS_DIVN_CODE='"+FAS_DIVN_CODE+"'";
			}else if("".equalsIgnoreCase(FAS_MAIN_ACNT_CODE) && "".equalsIgnoreCase(FAS_SUB_ACNT_CODE) && "".equalsIgnoreCase(FAS_DIVN_CODE)){
				selectQuery = "select ROWID, PM_IL_FUND_ACCOUNT_SETUP.* FROM PM_IL_FUND_ACCOUNT_SETUP";
			}
			System.out.println("INSIDE ACCOUNT SETUP SEARCH ACTION....."+selectQuery); 
			list = getHandler().fetch(selectQuery, "com.iii.pel.forms.PILM061_APAC.PM_IL_FUND_ACCOUNT_SETUP", getConnection());
			if(null!=list&&list.size()>0&&!list.isEmpty()){
			valueBean=list.get(0);
			ELResolver resolver = context.getApplication().getELResolver();
			//actionBean= (PM_IL_FUND_ACCOUNT_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP_ACTION");
			//if(actionBean == null) {
			//	System.out.println("bean null");
			//}
			valueBean.setUI_M_MAIN_ACNT_NAME(mainAccDesc(valueBean.getFAS_MAIN_ACNT_CODE()));
			valueBean.setUI_M_SUB_ACNT_NAME(subAccDesc(valueBean.getFAS_MAIN_ACNT_CODE(), valueBean.getFAS_SUB_ACNT_CODE()));
			valueBean.setUI_M_DIVN_NAME(branchAccDesc(valueBean.getFAS_DIVN_CODE()));
			valueBean.setUI_M_DEPT_NAME(deptAccDesc(valueBean.getFAS_DIVN_CODE(), valueBean.getFAS_DEPT_CODE()));
			valueBean.setUI_M_ANLY_NAME(analysisCode1Desc(valueBean.getFAS_ANLY_CODE_1()));
			valueBean.setUI_M_ANLY_NAME_1(analysisCode2Desc(valueBean.getFAS_ANLY_CODE_2()));
			actionBean = new PM_IL_FUND_ACCOUNT_SETUP_ACTION();
			CommonUtils.setGlobalObject("PILM061_APAC_PM_IL_FUND_ACCOUNT_SETUP_ACTION",actionBean);
			actionBean.setPM_IL_FUND_ACCOUNT_SETUP_BEAN(valueBean);
   		 }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "PILM061_APAC_mainPage";
	}

	public String mainAccDesc(String mainAccNo) throws Exception{
		String desc=null;
		PreparedStatement pstmt = getConnection().prepareStatement("SELECT MAIN_ACNT_CODE, MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25" +
								  "AND MAIN_ACNT_CODE = ?");
		pstmt.setString(1, mainAccNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			desc = rs.getString("MAIN_ACNT_NAME");
		}
		rs.close();
		return desc;
	}
	
	public String subAccDesc(String mainAccNo, String subAccNo) throws Exception{
		String desc=null;
		PreparedStatement pstmt = getConnection().prepareStatement("SELECT SUB_ACNT_CODE, SUB_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE" +
				" FROM FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = ?) AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25"+
				" AND SUB_ACNT_CODE = ?");
		pstmt.setString(1, mainAccNo);
		pstmt.setString(2, subAccNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			desc = rs.getString("SUB_ACNT_NAME");
		}
		rs.close();
		return desc;
	}
	
	
	public String branchAccDesc(String branchAccNo) throws Exception{
		String desc=null;
		String selectQuery = "SELECT DIVN_CODE, DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = ? AND NVL(DIVN_FRZ_FLAG, 'N') = 'N'" +
							 " AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) " +
							 " AND ADS_FRZ_FLAG = 'N') AND DIVN_CODE = ? ";
		String companyCode = CommonUtils.getControlBean().getM_COMP_CODE();
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		connection = CommonUtils.getConnection();
		if (connection != null) {
			handler = new CRUDHandler();
			Object[] values = { companyCode, branchAccNo };
			rst = handler.executeSelectStatement(selectQuery, connection, values);
			if(rst.next()){
				desc = rst.getString("DIVN_NAME");
				desc = desc == null ? "" : desc;
			}
		}
		CommonUtils.closeCursor(rst);
		return desc;
	}
 
	
	public String deptAccDesc(String branchAccNo, String deptAccNo) throws Exception{
		String desc=null;
//		Company Code HARD CODED
		PreparedStatement pstmt = getConnection().prepareStatement("select DEPT_CODE, DEPT_NAME from PM_DEPARTMENT where DEPT_COMP_CODE ='001'"+
		" AND DEPT_DIVN_CODE = ? AND DEPT_FRZ_FLAG  = 'N' " +
		"AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE " +
		"AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) " +
		"AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25 AND DEPT_CODE=?");
		pstmt.setString(1, branchAccNo);
		pstmt.setString(2, deptAccNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			desc = rs.getString("DEPT_NAME");
		}
		rs.close();
		return desc;
	}
	
	public String analysisCode1Desc(String analyCode1) throws Exception{
		String desc=null;
		PreparedStatement pstmt = getConnection().prepareStatement("SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25" +
								  "AND ANLY_CODE = ?");
		pstmt.setString(1, analyCode1);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			desc = rs.getString("ANLY_NAME");
		}
		rs.close();
		return desc;
	}
	
	public String analysisCode2Desc(String analyCode2) throws Exception{
		String desc=null;
		PreparedStatement pstmt = getConnection().prepareStatement("SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25" +
								  "AND ANLY_CODE = ?");
		pstmt.setString(1, analyCode2);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			desc = rs.getString("ANLY_NAME");
		}
		rs.close();
		return desc;
	}
	
	
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN searchBean) {
		this.searchBean = searchBean;
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN> getDataTableBean() {
		return dataTableBean;
	}

	public void setDataTableBean(List<PM_IL_FUND_ACCOUNT_SETUP_SEARCH_BEAN> dataTableBean) {
		this.dataTableBean = dataTableBean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(HtmlInputText comp_ui_m_main_acnt_name) {
		COMP_UI_M_MAIN_ACNT_NAME = comp_ui_m_main_acnt_name;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText comp_ui_m_sub_acnt_name) {
		COMP_UI_M_SUB_ACNT_NAME = comp_ui_m_sub_acnt_name;
	}
}
