package com.iii.pel.forms.PILT018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BROK_ADV_HDR_DELEGATE {
	
	public ArrayList<PT_IL_BROK_ADV_HDR> fetchPolicyDetails(PT_IL_BROK_ADV_HDR_SEARCH_PAGE_ACTION  action) throws Exception{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PT_IL_BROK_ADV_HDR details = null;
		ArrayList<PT_IL_BROK_ADV_HDR> detailsList = null;
		//PM_IL_CLM_ACCOUNT_SETUP searchBean = action.getSearchBean();
		System.out.println("INSIDE NULL");
		String sqlQuery = "SELECT BAH_CUST_CODE,BAH_CURR_CODE,ROWID FROM  PT_IL_BROK_ADV_HDR";
		
		if(action.getBrokerCode()!=null && action.getBrokerCode().trim().length()>0){
			System.out.println("INSIDE ! NULL");
			sqlQuery = sqlQuery+" WHERE BAH_CUST_CODE like '"+ action.getBrokerCode()+ "%'";
			System.out.println("PT_IL_BROK_ADV_HDR_DELEGATE.fetchPolicyDetails()-sqlQuery-FS_CODE------" +sqlQuery);
		}
		else if(action.getCurrencyCode()!=null && action.getCurrencyCode().trim().length()>0){
			sqlQuery = sqlQuery+" WHERE BAH_CURR_CODE LIKE '"+ action.getCurrencyCode()+ "%'";
		}else if((action.getBrokerCode()!=null && action.getBrokerCode().trim().length()>0) && 
				 (action.getCurrencyCode()!=null && action.getCurrencyCode().trim().length()>0)){
			sqlQuery = sqlQuery+" WHERE BAH_CUST_CODE like '"+ action.getBrokerCode()+ "%' " +
					   "AND BAH_CURR_CODE LIKE '"+ action.getCurrencyCode()+ "%'";
		}
		/*else if(action.getInitWaitingPeriod()!=null&&action.getInitWaitingPeriod().trim().length()>0){
			sqlQuery = sqlQuery+" WHERE CLMAS_DIVN_CODE = '"+ action.getInitWaitingPeriod()+ "'";
		}*/
		/*String sqlQuery = "select PM_IL_CLM_ACCOUNT_SETUP.* FROM PM_IL_CLM_ACCOUNT_SETUP" +
		"WHERE CLMAS_MAIN_ACNT_CODE = '"+ action.getInitMainAccountcode() +"' AND CLMAS_SUB_ACNT_CODE = '"+ action.getInitSubAccountcode()+"'" +
				" AND CLMAS_DIVN_CODE = '"+ action.getInitDivisioncode()+"'";*/
		
		System.out.println("PT_IL_BROK_ADV_HDR_DELEGATE.fetchPolicyDetails()-sqlQuery"+sqlQuery);

		// Fetch details
		connection = CommonUtils.getConnection();
		if(connection != null){
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				detailsList = new ArrayList<PT_IL_BROK_ADV_HDR>();
				while (resultSet.next()) {
					details = new PT_IL_BROK_ADV_HDR();
					details.setBAH_CUST_CODE(resultSet.getString("BAH_CUST_CODE"));
					details.setBAH_CURR_CODE(resultSet.getString("BAH_CURR_CODE"));
					//details.setFS_SW_WAIT_PERIOD(resultSet.getDouble("FS_SW_WAIT_PERIOD"));
					details.setROWID(resultSet.getString("ROWID"));
					//details.setCLMAS_BUS_FM_CODE(resultSet.getString("CLMAS_BUS_FM_CODE"));
					//details.setCLMAS_BUS_TO_CODE(resultSet.getString("CLMAS_BUS_TO_CODE"));
					
					detailsList.add(details);
				}
			}catch (SQLException e) {
				e.printStackTrace();
				//throw new Exception(e.getMessage());
			}finally{
				//connection.close();
			}
		}
		return detailsList;
	}

}
