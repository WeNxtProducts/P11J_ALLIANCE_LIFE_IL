package com.iii.pel.forms.PILM024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.el.ELResolver;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_ACCOUNT_SETUP_SEARCH {

	private HtmlDataTable dataTable;
	private PM_IL_CLM_ACCOUNT_SETUP searchBean;
	private ArrayList<PM_IL_CLM_ACCOUNT_SETUP> policyList;
	private String initMainAccountcode; 
	private String initSubAccountcode;
	private String initDivisioncode;
	PM_IL_CLM_ACCOUNT_SETUP details = null;
	private String searchedName;
	ServletContext context;
	CRUDHandler handler = new CRUDHandler();
	Connection con ;
	ResultSet rs = null;

	public String fetchPolicyDetails(){
		PM_IL_CLM_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_CLM_ACCOUNT_SETUP_DELEGATE();
		try {
			this.policyList = delegate.fetchPolicyDetails(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String clearList() throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		/*HttpSession session = request.getSession();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action = new PM_IL_PREM_ACCOUNT_SETUP_ACTION();
		PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE pm_il_prem_account_setup_action_delegate = new PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE();
		session.setAttribute("PILM022_PM_IL_PREM_ACCOUNT_SETUP_ACTION", pm_il_prem_account_setup_action);*/
		String code = request.getParameter("ROWID");
		ELResolver resolver = context.getApplication().getELResolver();
		PM_IL_CLM_ACCOUNT_SETUP_ACTION actionBean= (PM_IL_CLM_ACCOUNT_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM024_PM_IL_CLM_ACCOUNT_SETUP_ACTION");
		prepareDetails(code,actionBean.getPM_IL_CLM_ACCOUNT_SETUP_BEAN());
		String returnStr = "PILM024goMainPage";
		return returnStr;
	}

	/*private void  prepareDetails(String code,PM_IL_CLM_ACCOUNT_SETUP_ACTION actionBean) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("PILM024_PM_IL_CLM_ACCOUNT_SETUP_ACTION", actionBean);
		PM_IL_CLM_ACCOUNT_SETUP pm_il_bank_account_setup=actionBean.getPM_IL_CLM_ACCOUNT_SETUP_BEAN();
		String selectQuery  = "select ROWID,CLMAS_MAIN_ACNT_CODE,CLMAS_SUB_ACNT_CODE,CLMAS_DIVN_CODE,CLMAS_DEPT_CODE FROM PM_IL_CLM_ACCOUNT_SETUP where ROWID LIKE '"+code+"'";
		System.out.println("selectQuery"+selectQuery);
		con = CommonUtils.getConnection();
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM024.PM_IL_CLM_ACCOUNT_SETUP",con);
		pm_il_bank_account_setup = (PM_IL_CLM_ACCOUNT_SETUP)list.get(0);
		
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		String CLMAS_MAIN_ACNT_CODE = actionBean.getPM_IL_CLM_ACCOUNT_SETUP_BEAN().getCLMAS_MAIN_ACNT_CODE();
		pm_il_bank_account_setup.setCLMAS_MAIN_ACNT_CODE(CLMAS_MAIN_ACNT_CODE);
		
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		String CLMAS_SUB_ACNT_CODE = actionBean.getPM_IL_CLM_ACCOUNT_SETUP_BEAN().getCLMAS_SUB_ACNT_CODE();
		pm_il_bank_account_setup.setCLMAS_SUB_ACNT_CODE(CLMAS_SUB_ACNT_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DIVN_CODE = actionBean.getPM_IL_CLM_ACCOUNT_SETUP_BEAN().getCLMAS_DIVN_CODE();
		pm_il_bank_account_setup.setCLMAS_DIVN_CODE(CLMAS_DIVN_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DEPT_CODE = actionBean.getPM_IL_CLM_ACCOUNT_SETUP_BEAN().getCLMAS_DEPT_CODE();
		pm_il_bank_account_setup.setCLMAS_DEPT_CODE(CLMAS_DEPT_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String sqlQuery = "SELECT * FROM PM_IL_CLM_ACCOUNT_SETUP";
		Connection connection = CommonUtils.getConnection();
		PM_IL_CLM_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_CLM_ACCOUNT_SETUP_DELEGATE();
		if(connection != null){
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);
				ArrayList<PM_IL_CLM_ACCOUNT_SETUP> detailsList = new ArrayList<PM_IL_CLM_ACCOUNT_SETUP>();
				while (resultSet.next()) {
					details = new PM_IL_CLM_ACCOUNT_SETUP();
					details.setCLMAS_BUS_FM_CODE(resultSet.getString("CLMAS_BUS_FM_CODE"));
					details.setCLMAS_BUS_TO_CODE(resultSet.getString("CLMAS_BUS_TO_CODE"));
					details.setCLMAS_DIVN_FM_CODE(resultSet.getString("CLMAS_DIVN_FM_CODE"));
					details.setCLMAS_DIVN_TO_CODE(resultSet.getString("CLMAS_DIVN_TO_CODE"));
					details.setCLMAS_DEPT_FM_CODE(resultSet.getString("CLMAS_DEPT_FM_CODE"));
					details.setCLMAS_DEPT_TO_CODE(resultSet.getString("CLMAS_DEPT_TO_CODE"));
					details.setCLMAS_DOC_FM_TYPE(resultSet.getString("CLMAS_DOC_FM_TYPE"));
					details.setCLMAS_DOC_TO_TYPE(resultSet.getString("CLMAS_DOC_TO_TYPE"));
					details.setCLMAS_CLM_TYPE_FM_CODE(resultSet.getString("CLMAS_CLM_TYPE_FM_CODE"));
					details.setCLMAS_CLM_TYPE_TO_CODE(resultSet.getString("CLMAS_CLM_TYPE_TO_CODE"));
					details.setCLMAS_MAIN_ACNT_CODE(resultSet.getString("CLMAS_MAIN_ACNT_CODE"));
					details.setCLMAS_SUB_ACNT_CODE(resultSet.getString("CLMAS_SUB_ACNT_CODE"));
					details.setCLMAS_DIVN_CODE(resultSet.getString("CLMAS_DIVN_CODE"));
					details.setCLMAS_DEPT_CODE(resultSet.getString("CLMAS_DEPT_CODE"));
					details.setCLMAS_ANLY_CODE_1(resultSet.getString("CLMAS_ANLY_CODE_1"));
					details.setCLMAS_ANLY_CODE_2(resultSet.getString("CLMAS_ANLY_CODE_2"));
					details.setCLMAS_ACTY_CODE_1(resultSet.getString("CLMAS_ACTY_CODE_1"));
					details.setCLMAS_ACTY_CODE_2(resultSet.getString("CLMAS_ACTY_CODE_2"));
					details.setCLMAS_SRC_BUS_FM(resultSet.getString("CLMAS_SRC_BUS_FM"));
					details.setCLMAS_SRC_BUS_TO(resultSet.getString("CLMAS_SRC_BUS_TO"));
					details.setCLMAS_PROD_CODE_FM(resultSet.getString("CLMAS_PROD_CODE_FM"));
					details.setCLMAS_PROD_CODE_TO(resultSet.getString("CLMAS_PROD_CODE_TO"));
					details.setCLMAS_COVER_CODE_FM(resultSet.getString("CLMAS_COVER_CODE_FM"));
					details.setCLMAS_COVER_CODE_TO(resultSet.getString("CLMAS_COVER_CODE_TO"));
					details.setCLMAS_CUST_CLS_FM_CODE(resultSet.getString("CLMAS_CUST_CLS_FM_CODE"));
					details.setCLMAS_CUST_CLS_TO_CODE(resultSet.getString("CLMAS_CUST_CLS_TO_CODE"));
					delegate.fieldDescription(details);
					detailsList.add(details);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String CLMAS_BUS_FM_CODE = details.getCLMAS_BUS_FM_CODE();
		pm_il_bank_account_setup.setCLMAS_BUS_FM_CODE(CLMAS_BUS_FM_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_BUS_TO_CODE = details.getCLMAS_BUS_TO_CODE();
		pm_il_bank_account_setup.setCLMAS_BUS_TO_CODE(CLMAS_BUS_TO_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DIVN_FM_CODE = details.getCLMAS_DIVN_FM_CODE();
		pm_il_bank_account_setup.setCLMAS_DIVN_FM_CODE(CLMAS_DIVN_FM_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DIVN_TO_CODE = details.getCLMAS_DIVN_TO_CODE();
		pm_il_bank_account_setup.setCLMAS_DIVN_TO_CODE(CLMAS_DIVN_TO_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DEPT_FM_CODE = details.getCLMAS_DEPT_FM_CODE();
		pm_il_bank_account_setup.setCLMAS_DEPT_FM_CODE(CLMAS_DEPT_FM_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DEPT_TO_CODE = details.getCLMAS_DEPT_TO_CODE();
		pm_il_bank_account_setup.setCLMAS_DEPT_TO_CODE(CLMAS_DEPT_TO_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DOC_FM_TYPE = details.getCLMAS_DOC_FM_TYPE();
		pm_il_bank_account_setup.setCLMAS_DOC_FM_TYPE(CLMAS_DOC_FM_TYPE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_DOC_TO_TYPE = details.getCLMAS_DOC_TO_TYPE();
		pm_il_bank_account_setup.setCLMAS_DOC_TO_TYPE(CLMAS_DOC_TO_TYPE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_CLM_TYPE_FM_CODE = details.getCLMAS_CLM_TYPE_FM_CODE();
		pm_il_bank_account_setup.setCLMAS_CLM_TYPE_FM_CODE(CLMAS_CLM_TYPE_FM_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_CLM_TYPE_TO_CODE = details.getCLMAS_CLM_TYPE_TO_CODE();
		pm_il_bank_account_setup.setCLMAS_CLM_TYPE_TO_CODE(CLMAS_CLM_TYPE_TO_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_FORCE_DIVN_YN = details.getCLMAS_FORCE_DIVN_YN();
		pm_il_bank_account_setup.setCLMAS_FORCE_DIVN_YN(CLMAS_FORCE_DIVN_YN);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_FORCE_DEPT_YN = details.getCLMAS_FORCE_DEPT_YN();
		pm_il_bank_account_setup.setCLMAS_FORCE_DEPT_YN(CLMAS_FORCE_DEPT_YN);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_ANLY_CODE_1 = details.getCLMAS_ANLY_CODE_1();
		pm_il_bank_account_setup.setCLMAS_ANLY_CODE_1(CLMAS_ANLY_CODE_1);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_ANLY_CODE_2 = details.getCLMAS_ANLY_CODE_2();
		pm_il_bank_account_setup.setCLMAS_ANLY_CODE_2(CLMAS_ANLY_CODE_2);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_ACTY_CODE_1 = details.getCLMAS_ACTY_CODE_1();
		pm_il_bank_account_setup.setCLMAS_ACTY_CODE_1(CLMAS_ACTY_CODE_1);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_ACTY_CODE_2 = details.getCLMAS_ACTY_CODE_2();
		pm_il_bank_account_setup.setCLMAS_ACTY_CODE_2(CLMAS_ACTY_CODE_2);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_FRZ_FLAG = details.getCLMAS_FRZ_FLAG();
		pm_il_bank_account_setup.setCLMAS_FRZ_FLAG(CLMAS_FRZ_FLAG);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_ASSURED_TYPE = details.getCLMAS_ASSURED_TYPE();
		pm_il_bank_account_setup.setCLMAS_ASSURED_TYPE(CLMAS_ASSURED_TYPE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_SRC_BUS_FM = details.getCLMAS_SRC_BUS_FM();
		pm_il_bank_account_setup.setCLMAS_SRC_BUS_FM(CLMAS_SRC_BUS_FM);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_SRC_BUS_TO = details.getCLMAS_SRC_BUS_TO();
		pm_il_bank_account_setup.setCLMAS_SRC_BUS_TO(CLMAS_SRC_BUS_TO);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_TYPE = details.getCLMAS_TYPE();
		pm_il_bank_account_setup.setCLMAS_TYPE(CLMAS_TYPE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_PROD_CODE_FM = details.getCLMAS_PROD_CODE_FM();
		pm_il_bank_account_setup.setCLMAS_PROD_CODE_FM(CLMAS_PROD_CODE_FM);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_PROD_CODE_TO = details.getCLMAS_PROD_CODE_TO();
		pm_il_bank_account_setup.setCLMAS_PROD_CODE_TO(CLMAS_PROD_CODE_TO);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_COVER_CODE_FM = details.getCLMAS_COVER_CODE_FM();
		pm_il_bank_account_setup.setCLMAS_COVER_CODE_FM(CLMAS_COVER_CODE_FM);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_COVER_CODE_TO = details.getCLMAS_COVER_CODE_TO();
		pm_il_bank_account_setup.setCLMAS_COVER_CODE_TO(CLMAS_COVER_CODE_TO);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_CUST_CLS_FM_CODE = details.getCLMAS_CUST_CLS_FM_CODE();
		pm_il_bank_account_setup.setCLMAS_CUST_CLS_FM_CODE(CLMAS_CUST_CLS_FM_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String CLMAS_CUST_CLS_TO_CODE = details.getCLMAS_CUST_CLS_TO_CODE();
		pm_il_bank_account_setup.setCLMAS_CUST_CLS_TO_CODE(CLMAS_CUST_CLS_TO_CODE);
		actionBean.setPM_IL_CLM_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
	}*/
	
	public Object prepareDetails(String rowId, Object obj)throws DBException
	{
		PM_IL_CLM_ACCOUNT_SETUP beanClass = (PM_IL_CLM_ACCOUNT_SETUP) obj;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		
		try {
			connection = CommonUtils.getConnection();
			String query = "SELECT CLMAS_BUS_FM_CODE,CLMAS_BUS_TO_CODE,CLMAS_DIVN_FM_CODE," +
					"CLMAS_DIVN_TO_CODE,CLMAS_DEPT_FM_CODE,CLMAS_DEPT_TO_CODE,CLMAS_DOC_FM_TYPE," +
					"CLMAS_DOC_TO_TYPE,CLMAS_CLM_TYPE_FM_CODE,CLMAS_CLM_TYPE_TO_CODE," +
					"CLMAS_FORCE_DIVN_YN,CLMAS_FORCE_DEPT_YN,CLMAS_MAIN_ACNT_CODE," +
					"CLMAS_SUB_ACNT_CODE,CLMAS_DIVN_CODE,CLMAS_DEPT_CODE,CLMAS_ANLY_CODE_1," +
					"CLMAS_ANLY_CODE_2,CLMAS_ACTY_CODE_1,CLMAS_ACTY_CODE_2,CLMAS_FRZ_FLAG," +
					"CLMAS_ASSURED_TYPE,CLMAS_SRC_BUS_FM,CLMAS_SRC_BUS_TO,CLMAS_TYPE," +
					"CLMAS_PROD_CODE_FM,CLMAS_PROD_CODE_TO,CLMAS_COVER_CODE_FM,CLMAS_COVER_CODE_TO," +
					"CLMAS_CUST_CLS_FM_CODE,CLMAS_CUST_CLS_TO_CODE, ROWID FROM PM_IL_CLM_ACCOUNT_SETUP WHERE ROWID = ?";
			System.out.println("Query:::"+query+"   ROWID:::::::"+rowId);
			PM_IL_CLM_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_CLM_ACCOUNT_SETUP_DELEGATE();
			Object values[] = {rowId};
			resultSet = handler.executeSelectStatement(query, connection, values);
			while (resultSet.next()) {
				beanClass.setCLMAS_BUS_FM_CODE(resultSet.getString("CLMAS_BUS_FM_CODE"));
				beanClass.setCLMAS_BUS_TO_CODE(resultSet.getString("CLMAS_BUS_TO_CODE"));
				beanClass.setCLMAS_DIVN_FM_CODE(resultSet.getString("CLMAS_DIVN_FM_CODE"));
				beanClass.setCLMAS_DIVN_TO_CODE(resultSet.getString("CLMAS_DIVN_TO_CODE"));
				beanClass.setCLMAS_DEPT_FM_CODE(resultSet.getString("CLMAS_DEPT_FM_CODE"));
				beanClass.setCLMAS_DEPT_TO_CODE(resultSet.getString("CLMAS_DEPT_TO_CODE"));
				beanClass.setCLMAS_DOC_FM_TYPE(resultSet.getString("CLMAS_DOC_FM_TYPE"));
				beanClass.setCLMAS_DOC_TO_TYPE(resultSet.getString("CLMAS_DOC_TO_TYPE"));
				beanClass.setCLMAS_CLM_TYPE_FM_CODE(resultSet.getString("CLMAS_CLM_TYPE_FM_CODE"));
				beanClass.setCLMAS_CLM_TYPE_TO_CODE(resultSet.getString("CLMAS_CLM_TYPE_TO_CODE"));
				beanClass.setCLMAS_MAIN_ACNT_CODE(resultSet.getString("CLMAS_MAIN_ACNT_CODE"));
				beanClass.setCLMAS_SUB_ACNT_CODE(resultSet.getString("CLMAS_SUB_ACNT_CODE"));
				beanClass.setCLMAS_DIVN_CODE(resultSet.getString("CLMAS_DIVN_CODE"));
				beanClass.setCLMAS_DEPT_CODE(resultSet.getString("CLMAS_DEPT_CODE"));
				beanClass.setCLMAS_ANLY_CODE_1(resultSet.getString("CLMAS_ANLY_CODE_1"));
				beanClass.setCLMAS_ANLY_CODE_2(resultSet.getString("CLMAS_ANLY_CODE_2"));
				beanClass.setCLMAS_ACTY_CODE_1(resultSet.getString("CLMAS_ACTY_CODE_1"));
				beanClass.setCLMAS_ACTY_CODE_2(resultSet.getString("CLMAS_ACTY_CODE_2"));
				beanClass.setCLMAS_SRC_BUS_FM(resultSet.getString("CLMAS_SRC_BUS_FM"));
				beanClass.setCLMAS_SRC_BUS_TO(resultSet.getString("CLMAS_SRC_BUS_TO"));
				beanClass.setCLMAS_PROD_CODE_FM(resultSet.getString("CLMAS_PROD_CODE_FM"));
				beanClass.setCLMAS_PROD_CODE_TO(resultSet.getString("CLMAS_PROD_CODE_TO"));
				beanClass.setCLMAS_COVER_CODE_FM(resultSet.getString("CLMAS_COVER_CODE_FM"));
				beanClass.setCLMAS_COVER_CODE_TO(resultSet.getString("CLMAS_COVER_CODE_TO"));
				beanClass.setCLMAS_CUST_CLS_FM_CODE(resultSet.getString("CLMAS_CUST_CLS_FM_CODE"));
				beanClass.setCLMAS_CUST_CLS_TO_CODE(resultSet.getString("CLMAS_CUST_CLS_TO_CODE"));
				beanClass.setCLMAS_TYPE(resultSet.getString("CLMAS_TYPE"));
				beanClass.setCLMAS_ASSURED_TYPE(resultSet.getString("CLMAS_ASSURED_TYPE"));
				beanClass.setCLMAS_FRZ_FLAG(resultSet.getString("CLMAS_FRZ_FLAG"));
				beanClass.setROWID(resultSet.getString("ROWID"));
				delegate.fieldDescription(beanClass);
	}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanClass;
	}
	
	public PM_IL_CLM_ACCOUNT_SETUP_SEARCH(){
		super();
		policyList = new ArrayList<PM_IL_CLM_ACCOUNT_SETUP>();
		searchBean = new PM_IL_CLM_ACCOUNT_SETUP();
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_CLM_ACCOUNT_SETUP> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(ArrayList<PM_IL_CLM_ACCOUNT_SETUP> policyList) {
		this.policyList = policyList;
	}

	public String getSearchedName() {
		return searchedName;
	}

	public void setSearchedName(String searchedName) {
		this.searchedName = searchedName;
	}
	
	public String getInitMainAccountcode() {
		return initMainAccountcode;
	}

	public void setInitMainAccountcode(String initMainAccountcode) {
		this.initMainAccountcode = initMainAccountcode;
	}

	public String getInitSubAccountcode() {
		return initSubAccountcode;
	}

	public void setInitSubAccountcode(String initSubAccountcode) {
		this.initSubAccountcode = initSubAccountcode;
	}

	public String getInitDivisioncode() {
		return initDivisioncode;
	}

	public void setInitDivisioncode(String initDivisioncode) {
		this.initDivisioncode = initDivisioncode;
	}

	public String clearSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PILM024_PM_IL_CLM_ACCOUNT_SETUP_ACTION") != null) {
			session.removeAttribute("PILM024_PM_IL_CLM_ACCOUNT_SETUP_ACTION");
		}
		return "PILM024goMainPage";
	}

	public PM_IL_CLM_ACCOUNT_SETUP getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PM_IL_CLM_ACCOUNT_SETUP searchBean) {
		this.searchBean = searchBean;
	}
	
	public void deleteRow(ActionEvent event) throws Exception{
		PM_IL_CLM_ACCOUNT_SETUP valuebean = null;
		int DeletedRecordIndex = 0;
		Connection connection = CommonUtils.getConnection();
		if(policyList != null){
			for(int index =0 ;index<policyList.size();){
				valuebean = policyList.get(index);
				if(valuebean.isCHECK_BOX()){
					policyList.remove(valuebean);
					int n = handler.executeDelete(valuebean, connection);
					connection.commit();
				}else{
					index++;
				}
			}

		}
	}
}
