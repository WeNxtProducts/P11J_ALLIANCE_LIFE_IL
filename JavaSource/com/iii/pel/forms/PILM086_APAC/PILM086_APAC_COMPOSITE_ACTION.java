package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.pel.forms.PILM106.PILM106_EMAIL_ACTION;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;


public class PILM086_APAC_COMPOSITE_ACTION extends CommonUtils{
	private PM_BUS_RULE_DTL2_ACTION PM_BUS_RULE_DTL2_ACTION_BEAN;
	private PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_BEAN;
	private PM_IL_COLUMN_LINK_ACTION PM_IL_COLUMN_LINK_ACTION_BEAN;
	private PILM086_APP_CUST_ACTION PILM086_APP_ACTION_BEAN;
	private PILM086_APAC_SQLSCRIPT_ACTION PILM086_APAC_SQLSCRIPT_ACTION_BEAN;
	private PILM086_APAC_ACTION PILM086_ACTION_BEAN;
	private PILM086_VAL_RNG_DTLS_ACTION PILM086_VAL_ACTION_BEAN;
	private PILM086_APP_USRS_ACTION PILM086_APP_USRS_ACTION_BEAN;
	private PM_IL_BUS_COVER_ACTION PM_IL_BUS_COVER_ACTION_BEAN;
	
	
	
	UIWizard wizard ;	
	
	public PM_BUS_RULE_DTL2_ACTION getPM_BUS_RULE_DTL2_ACTION_BEAN() {
		return PM_BUS_RULE_DTL2_ACTION_BEAN;
	}

	public void setPM_BUS_RULE_DTL2_ACTION_BEAN(
			PM_BUS_RULE_DTL2_ACTION pM_BUS_RULE_DTL2_ACTION_BEAN) {
		PM_BUS_RULE_DTL2_ACTION_BEAN = pM_BUS_RULE_DTL2_ACTION_BEAN;
	}

	public PM_BUS_RULE_DTL2 getPM_BUS_RULE_DTL2_BEAN() {
		return PM_BUS_RULE_DTL2_BEAN;
	}

	public void setPM_BUS_RULE_DTL2_BEAN(PM_BUS_RULE_DTL2 pM_BUS_RULE_DTL2_BEAN) {
		PM_BUS_RULE_DTL2_BEAN = pM_BUS_RULE_DTL2_BEAN;
	}

	public PM_IL_COLUMN_LINK_ACTION getPM_IL_COLUMN_LINK_ACTION_BEAN() {
		return PM_IL_COLUMN_LINK_ACTION_BEAN;
	}

	public void setPM_IL_COLUMN_LINK_ACTION_BEAN(
			PM_IL_COLUMN_LINK_ACTION pM_IL_COLUMN_LINK_ACTION_BEAN) {
		PM_IL_COLUMN_LINK_ACTION_BEAN = pM_IL_COLUMN_LINK_ACTION_BEAN;
	}

	public PILM086_APP_CUST_ACTION getPILM086_APP_ACTION_BEAN() {
		return PILM086_APP_ACTION_BEAN;
	}

	public void setPILM086_APP_ACTION_BEAN(
			PILM086_APP_CUST_ACTION pILM086_APP_ACTION_BEAN) {
		PILM086_APP_ACTION_BEAN = pILM086_APP_ACTION_BEAN;
	}

	public PILM086_APAC_SQLSCRIPT_ACTION getPILM086_APAC_SQLSCRIPT_ACTION_BEAN() {
		return PILM086_APAC_SQLSCRIPT_ACTION_BEAN;
	}

	public void setPILM086_APAC_SQLSCRIPT_ACTION_BEAN(
			PILM086_APAC_SQLSCRIPT_ACTION pILM086_APAC_SQLSCRIPT_ACTION_BEAN) {
		PILM086_APAC_SQLSCRIPT_ACTION_BEAN = pILM086_APAC_SQLSCRIPT_ACTION_BEAN;
	}

	public PILM086_VAL_RNG_DTLS_ACTION getPILM086_VAL_ACTION_BEAN() {
		return PILM086_VAL_ACTION_BEAN;
	}

	public void setPILM086_VAL_ACTION_BEAN(
			PILM086_VAL_RNG_DTLS_ACTION pILM086_VAL_ACTION_BEAN) {
		PILM086_VAL_ACTION_BEAN = pILM086_VAL_ACTION_BEAN;
	}

	public UIWizard getWizard() {
		return wizard;
	}
	
	public void setWizard(UIWizard wizard) {
		this.wizard = wizard;
	}
			
	
	public PILM086_APP_USRS_ACTION getPILM086_APP_USRS_ACTION_BEAN() {
		return PILM086_APP_USRS_ACTION_BEAN;
	}

	public void setPILM086_APP_USRS_ACTION_BEAN(
			PILM086_APP_USRS_ACTION pILM086_APP_USRS_ACTION_BEAN) {
		PILM086_APP_USRS_ACTION_BEAN = pILM086_APP_USRS_ACTION_BEAN;
	}

	public PILM086_APAC_ACTION getPILM086_ACTION_BEAN() {
		return PILM086_ACTION_BEAN;
	}
	
	public void setPILM086_ACTION_BEAN(PILM086_APAC_ACTION pILM086_ACTION_BEAN) {
		PILM086_ACTION_BEAN = pILM086_ACTION_BEAN;
	}

	
	public PM_IL_BUS_COVER_ACTION getPM_IL_BUS_COVER_ACTION_BEAN() {
		return PM_IL_BUS_COVER_ACTION_BEAN;
	}

	public void setPM_IL_BUS_COVER_ACTION_BEAN(
			PM_IL_BUS_COVER_ACTION pM_IL_BUS_COVER_ACTION_BEAN) {
		PM_IL_BUS_COVER_ACTION_BEAN = pM_IL_BUS_COVER_ACTION_BEAN;
	}

	public PILM086_APAC_COMPOSITE_ACTION()
	{		
		//EMAIL_ACTION_BEAN = (PILM106_EMAIL_ACTION) new CommonUtils().getMappedBeanFromSession("PILM106_EMAIL_ACTION");
		PM_IL_COLUMN_LINK_ACTION_BEAN=new PM_IL_COLUMN_LINK_ACTION();
		PM_IL_COLUMN_LINK_ACTION_BEAN.compositeAction=this;
		PILM086_APP_ACTION_BEAN=new PILM086_APP_CUST_ACTION();
		PILM086_APP_ACTION_BEAN.compositeAction=this;
		PILM086_ACTION_BEAN	=new PILM086_APAC_ACTION();
		PILM086_ACTION_BEAN.compositeAction=this;
		PILM086_VAL_ACTION_BEAN =new PILM086_VAL_RNG_DTLS_ACTION();
		PILM086_VAL_ACTION_BEAN.compositeAction=this;
		PILM086_APAC_SQLSCRIPT_ACTION_BEAN=new PILM086_APAC_SQLSCRIPT_ACTION();
		PILM086_APAC_SQLSCRIPT_ACTION_BEAN.compositeAction=this;
		PM_BUS_RULE_DTL2_ACTION_BEAN = new PM_BUS_RULE_DTL2_ACTION();
		PM_BUS_RULE_DTL2_ACTION_BEAN.compositeAction=this;
		PM_BUS_RULE_DTL2_BEAN = new PM_BUS_RULE_DTL2();
		
		PILM086_APP_USRS_ACTION_BEAN = new PILM086_APP_USRS_ACTION();
		PILM086_APP_USRS_ACTION_BEAN.compositeAction=this;
		
		PM_IL_BUS_COVER_ACTION_BEAN = new PM_IL_BUS_COVER_ACTION();
		
		PM_IL_BUS_COVER_ACTION_BEAN.compositeAction=this;
		
		
	}
	 public List prepareDivisionList(Connection connection,String tablename, List cityCodeList) {
		 System.out.println("ïnside sugg **************");
			String query = null;
			if ("*".equalsIgnoreCase(tablename)) {
				System.out.println("sugg * - - - if");
				query ="SELECT TABLE_NAME FROM USER_TABLES";
					Object[] object={};
					cityCodeList = tablename(connection, query,object);
					System.out.println("check2222222222222222222222222222222 "+cityCodeList.get(0));
					
			} else {
				System.out.println("sugg * - - - else");
				query ="SELECT TABLE_NAME FROM USER_TABLES";
				Object[] object={};
				cityCodeList = tablename(connection, query,object);
				System.out.println("check2222222222222222222222222222222 "+cityCodeList.get(0));
			}
			return cityCodeList;
		}
	
	 
	 
	 
	 
	 public List<PM_IL_COLUMN_LINK_BEAN> tablename(Connection connection,String query,Object[] object)
		{
		 System.out.println("inside divn code after");
		List<PM_IL_COLUMN_LINK_BEAN> divnCodeList = new ArrayList<PM_IL_COLUMN_LINK_BEAN>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				System.out.println("inside while");
				PM_IL_COLUMN_LINK_BEAN bean = new PM_IL_COLUMN_LINK_BEAN();
				bean.setBRD1_TAB_NAME(resultSet.getString("TABLE_NAME"));
				//bean.setBRD1_COL_NAME(resultSet.getString("DIVN_NAME"));
				System.out.println("cheeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeck"+bean.getBRD1_TAB_NAME());
				divnCodeList.add(bean);
				//new PM010_A_COMPANY_MASTER_ACTION().setSubmitValue(divnCodeList);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return divnCodeList;
	}
	 public List preparecolnameList(Connection connection,String tablename, List cityCodeList) {
		 System.out.println("ïnside sugg **************");
			String query = null;
			if ("*".equalsIgnoreCase(tablename)) {
				System.out.println("sugg * - - - if");
				query ="SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PM_BUS_RULE_DTL1'";
					Object[] object={};
					cityCodeList = columnName(connection, query,object);
					System.out.println("check2222222222222222222222222222222 "+cityCodeList.get(0));
					
			} else {
				System.out.println("sugg * - - - else");
				query ="SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PM_BUS_RULE_DTL1'";
				Object[] object={};
				cityCodeList = columnName(connection, query,object);
				System.out.println("check2222222222222222222222222222222 "+cityCodeList.get(0));
			}
			return cityCodeList;
		}
	 
	 
	 public List<PM_IL_COLUMN_LINK_BEAN> columnName(Connection connection,String query,Object[] object)
		{
		 System.out.println("inside column name code after");
		List<PM_IL_COLUMN_LINK_BEAN> divnCodeList = new ArrayList<PM_IL_COLUMN_LINK_BEAN>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				System.out.println("inside while");
				PM_IL_COLUMN_LINK_BEAN bean = new PM_IL_COLUMN_LINK_BEAN();
				bean.setBRD1_COL_NAME(resultSet.getString("COLUMN_NAME"));
				//bean.setBRD1_COL_NAME(resultSet.getString("DIVN_NAME"));
				System.out.println("cheeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeck"+bean.getBRD1_COL_NAME());
				divnCodeList.add(bean);
				//new PM010_A_COMPANY_MASTER_ACTION().setSubmitValue(divnCodeList);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return divnCodeList;
	}
	
	 
	 
	 public List prepareTabNameList(Connection connection,String tabNameCode, List tabNameList) {
		 System.out.println("ïnside sugg compsosition");
			//String query = null;
			String query ="SELECT TABLE_NAME FROM USER_TABLES WHERE ROWNUM<25";
			if ("*".equalsIgnoreCase(tabNameCode)) {
				System.out.println("sugg * - - - if");
				//query ="SELECT TABLE_NAME FROM USER_TABLES WHERE ROWNUM<25";
					Object[] object={};
					tabNameList = tabNameCode(connection, query,object);
					System.out.println("in query  if "+tabNameList.size());
					
			} else {
				System.out.println("sugg * - - - else");
				//query ="SELECT TABLE_NAME FROM USER_TABLES WHERE ROWNUM<25";
				Object[] object={};
				tabNameList = tabNameCode(connection, query,object);
				System.out.println("in query else "+tabNameList.size());
			}
			return tabNameList;
		}
	
	public List<PM_BUS_RULE_DTL2> tabNameCode(Connection connection,String query,Object[] object)
	{
	 System.out.println("inside tabName code after");
	List<PM_BUS_RULE_DTL2> tabList = new ArrayList<PM_BUS_RULE_DTL2>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
		try
		{

		resultSet=handler.executeSelectStatement(query,connection,object);
		while(resultSet.next())
		{
			PM_BUS_RULE_DTL2_BEAN= new PM_BUS_RULE_DTL2();
			PM_BUS_RULE_DTL2_BEAN.setBRD2_TAB_NAME(resultSet.getString("TABLE_NAME"));
			System.out.println("after table in setter"+PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME());
			tabList.add(PM_BUS_RULE_DTL2_BEAN);
		}
		}
		catch (Exception e) {
		e.printStackTrace();
	}
		for(int i=0;i<tabList.size();i++){
			System.out.println("2222"+tabList.get(i).getBRD2_TAB_NAME());
		}
	return tabList;
}
	
	/*public String getTabDescforName(String tabNameCode,List tabNameList){
		 System.out.println("086 composite");
			Iterator iterator = tabNameList.iterator();
			String tabNameDesc = null;
		 	while(iterator.hasNext()){
		 		PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_bean=(PM_BUS_RULE_DTL2)iterator.next();
		 		if(tabNameCode.equalsIgnoreCase(PM_BUS_RULE_DTL2_bean.getBRD2_TAB_NAME())){
		 			tabNameDesc = PM_BUS_RULE_DTL2_bean.getBRD2_TAB_NAME_DESC();
		 		}
		 	}
		 	
				
			return tabNameDesc;
		}*/
	
	//Col Name
	
	public List prepareColNameList(Connection connection,String colNameCode, List colNameList) {
		 System.out.println("ïnside sugg compsosition");
			String query = null;
			if ("*".equalsIgnoreCase(colNameCode)) {
				System.out.println("sugg * - - - if");
				String tableName=PM_BUS_RULE_DTL2_ACTION_BEAN.getCOMP_TAB_NAME().toString();
				System.out.println("tableName ================>>"+tableName);
				System.out.println("PM_BUS_RULE_DTL2_BEAN.getBRD2_LINK_TAB_NAME()  ::"+PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME());
				query ="SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ?";
					colNameList = colNameCode(connection, query,new Object[] {PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME()});
					System.out.println("in query  if "+colNameList.get(0));
					
			} else {
				System.out.println("sugg * - - - else");
				String tableName=PM_BUS_RULE_DTL2_ACTION_BEAN.getCOMP_TAB_NAME().toString();
				System.out.println("tableName ================>>"+tableName);
				System.out.println("PM_BUS_RULE_DTL2_BEAN.getBRD2_LINK_TAB_NAME()  ::"+PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME());
				query ="SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ?";
				colNameList = colNameCode(connection, query,new Object[] {PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME()});
				System.out.println("in query else "+colNameList.get(0));
			}
			return colNameList;
		}
	
	public List<PM_BUS_RULE_DTL2> colNameCode(Connection connection,String query,Object[] object)
	{
	 System.out.println("inside colName code after");
	List<PM_BUS_RULE_DTL2> colNameList = new ArrayList<PM_BUS_RULE_DTL2>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
		try
		{

		resultSet=handler.executeSelectStatement(query,connection,object);
		while(resultSet.next())
		{
			PM_BUS_RULE_DTL2_BEAN = new PM_BUS_RULE_DTL2();
			PM_BUS_RULE_DTL2_BEAN.setBRD2_COL_NAME(resultSet.getString("COLUMN_NAME"));
			//pm_a_company.setCOMP_DFLT_DIVN_NAME(resultSet.getString("DIVN_NAME"));
			System.out.println("after column in setter"+PM_BUS_RULE_DTL2_BEAN.getBRD2_COL_NAME());
			colNameList.add(PM_BUS_RULE_DTL2_BEAN);
			//new PM010_A_COMPANY_MASTER_ACTION().setSubmitValue(divnCodeList);
		}
		}
		catch (Exception e) {
		e.printStackTrace();
	}
	return colNameList;
}
	
	public String getColDescforName(String tabNameCode,List colNameList){
		 System.out.println("086 composite col name");
			Iterator iterator = colNameList.iterator();
			String colNameDesc = null;
		 	while(iterator.hasNext()){
		 		PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_bean=(PM_BUS_RULE_DTL2)iterator.next();
		 		if(colNameDesc.equalsIgnoreCase(PM_BUS_RULE_DTL2_bean.getBRD2_COL_NAME())){
		 			colNameDesc = PM_BUS_RULE_DTL2_bean.getBRD2_COL_NAME_DESC();
		 		}
		 	}
		 	
				
			return colNameDesc;
		}
	
	public String navigationEnabled(){
		//setImmediate(true);
		getWizard().setImmediate("true");
		 return "";		
	}
	
	public String callPILM086_APAC(){
		//preTabClick();
		System.out.println("CALLED");
		return "Business";		
	}
	
	public String callAPP_CUST_CLS(){
		//preTabClick();
		return "PILM086_APAC_APP_CUST_CLS";		
	}
	
	public String callAPP_CVRS(){
		//preTabClick();
		return "PILM086_APAC_APP_CVRS";		
	}
	
	public String callAPP_USRS(){
		//preTabClick();
		return "PILM086_APAC_APP_USRS";		
	}
	
	public String callCOL_LNK_CNDT(){
		//preTabClick();
		return "PILM086_APAC_COL_LNK_CNDT";		
	}
	
	public String callCOL_LNK_DTLS(){
		//preTabClick();
		return "PILM086_APAC_COL_LNK_DTLS";		
	}
	
	public String callSQL_SCRT(){
		//preTabClick();
		return "PILM086_APAC_SQL_SCRT";		
	}
	
	public String callVAL_RNG_DTLS(){
		//preTabClick();
		return "PILM086_APAC_VAL_RNG_DTLS";		
	}
	
}
