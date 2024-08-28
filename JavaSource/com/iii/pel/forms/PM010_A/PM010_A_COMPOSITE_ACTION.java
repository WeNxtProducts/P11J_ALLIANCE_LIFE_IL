package com.iii.pel.forms.PM010_A;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM001_A.PM_DEPARTMENT;
import com.iii.pel.forms.PM001_A.PM_DIVISION;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM010_A_COMPOSITE_ACTION {
	private PM010_A_COMPANY_MASTER_ACTION PM010_A_COMPANY_MASTER_ACTION_BEAN;
	private PM010_A_COMPANY PM010_A_COMPANY_BEAN;
	private PM_DIVISION pm_division_bean;
	
	public PM010_A_COMPOSITE_ACTION()
	{
		PM010_A_COMPANY_MASTER_ACTION_BEAN = new PM010_A_COMPANY_MASTER_ACTION();
		System.out.println("inside composite const");
		PM010_A_COMPANY_MASTER_ACTION_BEAN.compositeAction = this;
		//PM010_A_COMPANY_BEAN = new PM010_A_COMPANY();
	}
	
	public PM010_A_COMPANY_MASTER_ACTION getPM010_A_COMPANY_MASTER_ACTION_BEAN() {
		return PM010_A_COMPANY_MASTER_ACTION_BEAN;
	}

	public void setPM010_A_COMPANY_MASTER_ACTION_BEAN(
			PM010_A_COMPANY_MASTER_ACTION pM010_A_COMPANY_MASTER_ACTION_BEAN) {
		PM010_A_COMPANY_MASTER_ACTION_BEAN = pM010_A_COMPANY_MASTER_ACTION_BEAN;
	}
	

	public PM010_A_COMPANY getPM010_A_COMPANY_BEAN() {
		return PM010_A_COMPANY_BEAN;
	}

	public void setPM010_A_COMPANY_BEAN(PM010_A_COMPANY pM010_A_COMPANY_BEAN) {
		PM010_A_COMPANY_BEAN = pM010_A_COMPANY_BEAN;
	}

	/*public String updateButtonAction(String rowId) throws Exception{
		PM010_A_COMPANY_MASTER_ACTION action = new PM010_A_COMPANY_MASTER_ACTION();
		String outcome = null;
		try {
			CommonUtils.setGlobalObject("PM010_A_SYSTEM_SEARCH_ACTION",action);
			System.out.println(" ********** PM010_A_COMPOSITE_ACTION **********  ");
			
			System.out.println("rowId    : "+rowId);
			PM010_A_COMPANY_MASTER_ACTION_BEAN.getPM010_A_COMPANY_BEAN().setROWID(rowId);
			
			
			outcome = executeSelectStatement(action);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return outcome; 
	}*/
	
	public String executeSelectStatement(PM010_A_COMPANY_MASTER_ACTION detailsActionBean) throws Exception{
		String outCome = "PM010_A_Master";
		
		return outCome;
	}
	
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	 
	 /*public String insertButtonAction() {
		 System.out.println("testing");
		 PM010_A_COMPANY_MASTER_ACTION action = new PM010_A_COMPANY_MASTER_ACTION();
		 String outcome = null;
		 CommonUtils.setGlobalObject("PM010_A_COMPANY_MASTER_ACTION", action);
		 outcome ="PM010_A_Master";
		return outcome;		
	}*/
	 
	 public List prepareDivisionList(Connection connection,String cityCode, List cityCodeList) {
		 System.out.println("ïnside sugg **************");
			String query = null;
			if ("*".equalsIgnoreCase(cityCode)) {
				System.out.println("sugg * - - - if");
				query ="SELECT DIVN_CODE,DIVN_NAME FROM PM_DIVISION";
					Object[] object={};
					cityCodeList = divnCode(connection, query,object);
					System.out.println("check2222222222222222222222222222222 "+cityCodeList.get(0));
					
			} else {
				System.out.println("sugg * - - - else");
				query ="SELECT DIVN_CODE,DIVN_NAME FROM PM_DIVISION";
				Object[] object={};
				cityCodeList = divnCode(connection, query,object);
				System.out.println("check2222222222222222222222222222222 "+cityCodeList.get(0));
			}
			return cityCodeList;
		}
	 
	 
	 
	 public List<PM010_A_COMPANY> divnCode(Connection connection,String query,Object[] object)
		{
		 System.out.println("inside divn code after");
		List<PM010_A_COMPANY> divnCodeList = new ArrayList<PM010_A_COMPANY>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM010_A_COMPANY pm_a_company = new PM010_A_COMPANY();
				pm_a_company.setCOMP_DFLT_DIVN(resultSet.getString("DIVN_CODE"));
				pm_a_company.setCOMP_DFLT_DIVN_NAME(resultSet.getString("DIVN_NAME"));
				System.out.println("cheeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeck"+pm_a_company.getCOMP_DFLT_DIVN());
				divnCodeList.add(pm_a_company);
				//new PM010_A_COMPANY_MASTER_ACTION().setSubmitValue(divnCodeList);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return divnCodeList;
	}
	 
	 public String getCityDescforCode(String divnCode,List cityCodeList){
		 System.out.println("composite");
			Iterator iterator = cityCodeList.iterator();
			String divnDesc = null;
		 	while(iterator.hasNext()){
		 		PM010_A_COMPANY pm_division=(PM010_A_COMPANY)iterator.next();
		 		if(divnCode.equalsIgnoreCase(pm_division.getCOMP_DFLT_DIVN())){
		 			divnDesc = pm_division.getCOMP_DFLT_DIVN_NAME();
		 		}
		 	}
		 	
				
			return divnDesc;
		}
	 
	 // DEFAULT DEPARTMENT PART -- PM_DEPARTMENT
	 
	 public List prepareDepartmentList(Connection connection,String deptCode, List deptList) {
		 System.out.println("ïnside DepartmentList");
			String query = null;
			if ("*".equalsIgnoreCase(deptCode)) {
				System.out.println("DepartmentList * - - - if");
				query ="SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT";
					Object[] deptObject={};
					deptList = deptCodeFunc(connection, query,deptObject);
			} else {
				System.out.println("DepartmentList * - - - else");
				query ="SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT";
				Object[] deptObject={};
				deptList = deptCodeFunc(connection, query,deptObject);
			}
			return deptList;
		}
	 
	 public List<PM010_A_COMPANY> deptCodeFunc(Connection connection,String query,Object[] object)
		{
		 System.out.println("inside deptCodeFunc code after");
		List<PM010_A_COMPANY> deptCodeList = new ArrayList<PM010_A_COMPANY>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM010_A_COMPANY pm_a_company = new PM010_A_COMPANY();
				pm_a_company.setCOMP_DFLT_DEPT(resultSet.getString("DEPT_CODE"));
				pm_a_company.setCOMP_DFLT_DEPT_NAME(resultSet.getString("DEPT_NAME"));
				deptCodeList.add(pm_a_company);
				//new PM010_A_COMPANY_MASTER_ACTION().setSubmitValue(divnCodeList);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return deptCodeList;
	}
	 
	 public String getDeptName(String deptCode,List department){
		 System.out.println("composite");
			Iterator iterator = department.iterator();
			String deptName = null;
		 	while(iterator.hasNext()){
		 		PM010_A_COMPANY pm_division=(PM010_A_COMPANY)iterator.next();
		 		if(deptCode.equalsIgnoreCase(pm_division.getCOMP_DFLT_DEPT())){
		 			deptName = pm_division.getCOMP_DFLT_DEPT_NAME();
		 		}
		 	}
			return deptName;
		}
	 
}
