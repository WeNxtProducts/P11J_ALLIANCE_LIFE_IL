package com.iii.pel.forms.PILM072_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_DELEGATE {
	
	public List listAllRecords(){
		String mappedBeanName="PILM072_APAC_PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_ACTION";
		List recordList=new ArrayList<PM_IL_IF_ACCNT_SETUP_HDR>();
		
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		
		StringBuffer queryString =new StringBuffer(PILM072_APAC_SQLQUERY_CONSTANTS.SELECT_ALL_PM_IL_IF_ACCNT_SETUP_HDR);
		boolean firstConditionAdded=false;
		
		ResultSet result=null;
		
		//get the action bean for the search page from session
		PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_ACTION actionBean=
			(PM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		//getting the initial search criteria 
		String searchCondition1=
			actionBean.getPM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE1();
		String searchCondition2=
			actionBean.getPM_IL_IF_ACCNT_SETUP_HDR_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE2();
		System.out.println(searchCondition1+"**********"+searchCondition2);
		if(!(searchCondition1==null) && !(searchCondition1.trim().length()== 0)){
			//add criteria 1
			queryString=queryString.append(" WHERE UPPER(PIFH_MAIN_ACNT_CODE)LIKE"+" '"+searchCondition1.toUpperCase()+"%'");
			firstConditionAdded=true;
		}
		if(!(searchCondition2==null) && !(searchCondition2.trim().length()== 0)){
			// check if first criteria added and add criteria 2 appropriately
			if(firstConditionAdded){
				queryString=queryString.append(" AND UPPER(PIFH_SUB_ACNT_CODE)LIKE"+"'"+searchCondition2.toUpperCase()+"%'");
			}else{
				queryString=queryString.append(" WHERE UPPER(PIFH_SUB_ACNT_CODE)LIKE"+"'"+searchCondition2.toUpperCase()+"%'");
			}
		}
			System.out.println(queryString.toString());
		try {
			result=handler.executeSelectStatement(queryString.toString(),CommonUtils.getConnection());
			if(result!=null){
				while(result.next()){
					PM_IL_IF_ACCNT_SETUP_HDR bean=new PM_IL_IF_ACCNT_SETUP_HDR();
					bean.setPIFH_MAIN_ACNT_CODE(result.getString("PIFH_MAIN_ACNT_CODE"));
					bean.setPIFH_SUB_ACNT_CODE(result.getString("PIFH_SUB_ACNT_CODE"));
					bean.setPIFH_DIVN_CODE(result.getString("PIFH_DIVN_CODE"));
					bean.setPIFH_DEPT_CODE(result.getString("PIFH_DEPT_CODE"));
					bean.setPIFH_ANLY_CODE_1(result.getString("PIFH_ANLY_CODE_1"));
					bean.setPIFH_ANLY_CODE_2(result.getString("PIFH_ANLY_CODE_2"));
					bean.setPIFH_ACTY_CODE_1(result.getString("PIFH_ACTY_CODE_1"));
					bean.setPIFH_ACTY_CODE_2(result.getString("PIFH_ACTY_CODE_2"));
					bean.setPIFH_DRCR_FLAG(result.getString("PIFH_DRCR_FLAG"));
					bean.setROWID(result.getString("ROWID"));
					recordList.add(bean);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return recordList;
	}
	
}
