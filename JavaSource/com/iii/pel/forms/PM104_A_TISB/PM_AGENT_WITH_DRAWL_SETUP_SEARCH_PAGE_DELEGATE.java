package com.iii.pel.forms.PM104_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_DELEGATE {
	
	public List listAllRecords(){
		List recordList=new ArrayList<PM_AGENT_WITH_DRAWL_SETUP>();
		
		CRUDHandler handler=new CRUDHandler();
		CommonUtils util = new CommonUtils();
	
		String mappedBeanName="PM104_A_TISB_PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_ACTION";
		boolean firstConditionAdded=false;
		PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_ACTION actionBean = (PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		StringBuffer queryString = new StringBuffer("Select ROWID,PM_AGENT_WITH_DRAWL_SETUP.* from PM_AGENT_WITH_DRAWL_SETUP");
		
		ResultSet result=null;
		
		//getting the initial search criteria 
		
		String searchCondition1= 
			actionBean.getPM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE1();
		if(!(searchCondition1==null) && !(searchCondition1.trim().length()== 0)){
			//add criteria 1
			queryString=queryString.append(" WHERE AWDS_TYPE LIKE '"+searchCondition1+"%'");			
			firstConditionAdded=true;
		}
		 
		try {
			result=handler.executeSelectStatement(queryString.toString(),CommonUtils.getConnection());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (DBException db) {
			
			db.printStackTrace();
		}
		try {
			if(result!=null){
				while(result.next()){
					PM_AGENT_WITH_DRAWL_SETUP bean=new PM_AGENT_WITH_DRAWL_SETUP();
					bean.setROWID(result.getString("rowid"));
					bean.setAWDS_TYPE(result.getString("AWDS_TYPE"));
					bean.setAWDS_JOIN_AGE_FM(result.getInt("AWDS_JOIN_AGE_FM"));
					bean.setAWDS_JOIN_AGE_TO(result.getInt("AWDS_JOIN_AGE_TO"));
					bean.setAWDS_CURR_AGE_FM(result.getInt("AWDS_CURR_AGE_FM"));
					bean.setAWDS_CURR_AGE_TO(result.getInt("AWDS_CURR_AGE_TO"));
					bean.setAWDS_NO_YRS_EXP_FM(result.getInt("AWDS_NO_YRS_EXP_FM"));
					bean.setAWDS_NO_YRS_EXP_TO(result.getInt("AWDS_NO_YRS_EXP_TO"));
					bean.setAWDS_PAY_RATE(result.getDouble("AWDS_PAY_RATE"));
					bean.setAWDS_PAY_RATE_PER(result.getInt("AWDS_PAY_RATE_PER"));
					bean.setAWDS_PAY_SHARE_TYPE(result.getString("AWDS_PAY_SHARE_TYPE"));
					bean.setAWDS_LC_FUND_BAL(result.getDouble("AWDS_LC_FUND_BAL"));
					bean.setAWDS_CR_DT(result.getDate("AWDS_CR_DT"));
					bean.setAWDS_CR_UID(result.getString("AWDS_CR_UID"));
					bean.setAWDS_UPD_DT(result.getDate("AWDS_UPD_DT"));
					bean.setAWDS_UPD_UID(result.getString("AWDS_UPD_UID"));				
					
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

	public String getDescForAwardCode(String awdTypeCode) {
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		Connection connection=null;
		String desc=null;
		String query="SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM='APFCLMTYP' AND LIV_CODE='"+awdTypeCode+"'";
		try {
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query, connection,new Object[]{});
			if(resultSet.next()){
				desc=resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return desc;
	}	
}
