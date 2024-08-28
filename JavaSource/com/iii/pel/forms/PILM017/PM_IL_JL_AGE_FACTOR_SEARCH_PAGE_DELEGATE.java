package com.iii.pel.forms.PILM017;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE {
	
	public List listAllRecords(){
		
		String mappedBeanName="PILM017_PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION";
		List recordList=new ArrayList<PM_IL_JL_AGE_FACTOR>();
		ConnectionAgent agent=new ConnectionAgent();
		CommonUtils util = new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		StringBuffer queryString =new StringBuffer(PILM017_SQLQUERY_CONSTANTS.SELECT_ALL_PM_IL_JL_AGE_FACTOR);
		//String queryString="Select ROWID,PM_IL_RI_POOL_SETUP.* from PM_IL_RI_POOL_SETUP";
		boolean firstConditionAdded=false;
		PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION actionBean=
			(PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		String searchCondition1=
			actionBean.getPM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE1();
		String searchCondition2=
			actionBean.getPM_IL_JL_AGE_FACTOR_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE2();
		System.out.println(searchCondition1+"**********"+searchCondition2);
		if(!(searchCondition1==null) && !(searchCondition1.trim().length()== 0)){
			//add criteria 1
			queryString=queryString.append(" WHERE UPPER(JAF_DIFF_AGE_FROM)LIKE"+" '"+searchCondition1.toUpperCase()+"%'");
			firstConditionAdded=true;
		}
		if(!(searchCondition2==null) && !(searchCondition2.trim().length()== 0)){
			// check if first criteria added and add criteria 2 appropriately
			if(firstConditionAdded){
				queryString=queryString.append(" AND UPPER(JAF_DIFF_AGE_TO)LIKE"+"'"+searchCondition2.toUpperCase()+"%'");
			}else{
				queryString=queryString.append(" WHERE UPPER(JAF_DIFF_AGE_TO)LIKE"+"'"+searchCondition2.toUpperCase()+"%'");
			}
		}
		ResultSet result=null;
		try {
			System.out
					.println("PM_IL_JL_AGE_FACTOR_SEARCH_PAGE_DELEGATE.listAllRecords() query "+queryString);
			result=handler.executeSelectStatement(queryString.toString(),util.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(result!=null){
				while(result.next()){
					PM_IL_JL_AGE_FACTOR bean=new PM_IL_JL_AGE_FACTOR();
					bean.setJAF_DIFF_AGE_FROM(result.getInt("JAF_DIFF_AGE_FROM"));
					bean.setJAF_DIFF_AGE_TO(result.getInt("JAF_DIFF_AGE_TO"));
					bean.setJAF_AGE_FACTOR(result.getDouble("JAF_AGE_FACTOR"));
					bean.setJAF_EFF_FM_DT(result.getDate("JAF_EFF_FM_DT"));
					bean.setJAF_EFF_TO_DT(result.getDate("JAF_EFF_TO_DT"));
					bean.setUI_JAF_EFF_FM_DT(CommonUtils.dateToPELStringFormatter(result.getDate("JAF_EFF_FM_DT")));
					bean.setUI_JAF_EFF_To_DT(CommonUtils.dateToPELStringFormatter(result.getDate("JAF_EFF_TO_DT")));
					bean.setROWID(result.getString("ROWID"));
					recordList.add(bean);				
				}
				System.out.println("Bean Size \t" + recordList.size());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordList;
	}

	public void preInsert(PM_IL_JL_AGE_FACTOR pm_il_jl_age_factor_bean) { 
		
		System.out.println("Age From....."+pm_il_jl_age_factor_bean.getJAF_DIFF_AGE_FROM());
		System.out.println("Age From....."+pm_il_jl_age_factor_bean.getJAF_DIFF_AGE_TO());
		
		
		pm_il_jl_age_factor_bean.setUI_JAF_EFF_FM_DT(CommonUtils.dateToPELStringFormatter(pm_il_jl_age_factor_bean.getJAF_EFF_FM_DT()));
		pm_il_jl_age_factor_bean.setUI_JAF_EFF_To_DT(CommonUtils.dateToPELStringFormatter(pm_il_jl_age_factor_bean.getJAF_EFF_TO_DT()));
	}
	
}
