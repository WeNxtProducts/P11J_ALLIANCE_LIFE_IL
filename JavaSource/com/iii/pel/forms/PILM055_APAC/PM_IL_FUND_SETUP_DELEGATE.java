package com.iii.pel.forms.PILM055_APAC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_FUND_SETUP_DELEGATE {

	

	

		/*public ArrayList fetchMasterBlock(PM_IL_CLM_ACCOUNT_SETUP_SEARCH searchAction) {
			ArrayList<PM_IL_CLM_ACCOUNT_SETUP> masterList = new ArrayList<PM_IL_CLM_ACCOUNT_SETUP>();
			PM_IL_CLM_ACCOUNT_SETUP searchBean = searchAction.getSearchBean();
			String CLMAS_MAIN_ACNT_CODE = searchBean.getCLMAS_MAIN_ACNT_CODE();
			String query = null;
			ResultSet rs = null;
			if(CLMAS_MAIN_ACNT_CODE == null || "".equals(CLMAS_MAIN_ACNT_CODE)){
				query = "SELECT * FROM PM_IL_CLM_ACCOUNT_SETUP";
			}else if(CLMAS_MAIN_ACNT_CODE!= null || !"".equals(CLMAS_MAIN_ACNT_CODE)){
				query = "SELECT * PM_IL_CLM_ACCOUNT_SETUP WHERE CLMAS_MAIN_ACNT_CODE LIKE '"+CLMAS_MAIN_ACNT_CODE+"%'";
			}
			try{
				rs = getHandler().executeSelectStatement(query, getConnection());
				while(rs.next()){
					PM_IL_CLM_ACCOUNT_SETUP secondSearchBean = new PM_IL_CLM_ACCOUNT_SETUP();
					secondSearchBean.setCLMAS_MAIN_ACNT_CODE(rs.getString("CLMAS_MAIN_ACNT_CODE"));
					secondSearchBean.setCLMAS_SUB_ACNT_CODE(rs.getString("CLMAS_SUB_ACNT_CODE"));
					secondSearchBean.setCLMAS_DIVN_CODE(rs.getString("CLMAS_DIVN_CODE"));
					secondSearchBean.setROWID(rs.getString("ROWID"));
					masterList.add(secondSearchBean);
				}
			}catch(Exception er){
				er.printStackTrace();
			}
			return masterList;
			
		}*/
		
		
		
		
		
		
		
		public ArrayList<PM_IL_FUND_SETUP> fetchPolicyDetails(PM_IL_FUND_SETUP_SEARCH_PAGE  action) throws Exception{
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			PM_IL_FUND_SETUP details = null;
			ArrayList<PM_IL_FUND_SETUP> detailsList = null;
			//PM_IL_CLM_ACCOUNT_SETUP searchBean = action.getSearchBean();
			System.out.println("INSIDE NULL");
			String sqlQuery = "select FS_CODE, FS_DESC,ROWID FROM PM_IL_FUND_SETUP";
			
			if(action.getInitFundCode()!=null&&action.getInitFundCode().trim().length()>0){
				System.out.println("INSIDE ! NULL");
				sqlQuery = sqlQuery+" WHERE FS_CODE like '"+ action.getInitFundCode()+ "%'";
				System.out.println("PM_IL_FUND_SETUP_DELEGATE.fetchPolicyDetails()-sqlQuery-FS_CODE------" +sqlQuery);
			}
			else if(action.getInitFundDescription()!=null&&action.getInitFundDescription().trim().length()>0){
				sqlQuery = sqlQuery+" WHERE FS_DESC like '"+ action.getInitFundDescription()+ "%'";
			}
			/*else if(action.getInitWaitingPeriod()!=null&&action.getInitWaitingPeriod().trim().length()>0){
				sqlQuery = sqlQuery+" WHERE CLMAS_DIVN_CODE = '"+ action.getInitWaitingPeriod()+ "'";
			}*/
			/*String sqlQuery = "select PM_IL_CLM_ACCOUNT_SETUP.* FROM PM_IL_CLM_ACCOUNT_SETUP" +
			"WHERE CLMAS_MAIN_ACNT_CODE = '"+ action.getInitMainAccountcode() +"' AND CLMAS_SUB_ACNT_CODE = '"+ action.getInitSubAccountcode()+"'" +
					" AND CLMAS_DIVN_CODE = '"+ action.getInitDivisioncode()+"'";*/
			
			System.out.println("PM_IL_FUND_SETUP_DELEGATE.fetchPolicyDetails()-sqlQuery"+sqlQuery);

			// Fetch details
			connection = CommonUtils.getConnection();
			if(connection != null){
				try {
					statement = connection.createStatement();
					resultSet = statement.executeQuery(sqlQuery);
					detailsList = new ArrayList<PM_IL_FUND_SETUP>();
					while (resultSet.next()) {
						details = new PM_IL_FUND_SETUP();
						details.setFS_CODE(resultSet.getString("FS_CODE"));
						details.setFS_DESC(resultSet.getString("FS_DESC"));
						
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

	
	
	
	
	
	
	
	

