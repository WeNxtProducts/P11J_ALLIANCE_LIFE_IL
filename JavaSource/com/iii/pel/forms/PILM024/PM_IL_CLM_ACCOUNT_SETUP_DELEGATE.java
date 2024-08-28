package com.iii.pel.forms.PILM024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_ACCOUNT_SETUP_DELEGATE {

	public ArrayList<PM_IL_CLM_ACCOUNT_SETUP> fetchPolicyDetails(PM_IL_CLM_ACCOUNT_SETUP_SEARCH action) throws Exception{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PM_IL_CLM_ACCOUNT_SETUP details = null;
		ArrayList<PM_IL_CLM_ACCOUNT_SETUP> detailsList = null;
		//PM_IL_CLM_ACCOUNT_SETUP searchBean = action.getSearchBean();
		System.out.println("INSIDE NULL");
		String sqlQuery = "select CLMAS_MAIN_ACNT_CODE , CLMAS_SUB_ACNT_CODE, CLMAS_DIVN_CODE, ROWID FROM PM_IL_CLM_ACCOUNT_SETUP";
		
		if(action.getInitMainAccountcode()!=null&&action.getInitMainAccountcode().trim().length()>0){
			System.out.println("INSIDE ! NULL");
			sqlQuery = sqlQuery+" WHERE CLMAS_MAIN_ACNT_CODE LIKE '"+ action.getInitMainAccountcode()+ "%'";
		}
		else if(action.getInitSubAccountcode()!=null&&action.getInitSubAccountcode().trim().length()>0){
			sqlQuery = sqlQuery+" WHERE CLMAS_SUB_ACNT_CODE LIKE '"+ action.getInitSubAccountcode()+ "%'";
		}
		else if(action.getInitDivisioncode()!=null&&action.getInitDivisioncode().trim().length()>0){
			sqlQuery = sqlQuery+" WHERE CLMAS_DIVN_CODE LIKE '"+ action.getInitDivisioncode()+ "%'";
		}
		/*String sqlQuery = "select PM_IL_CLM_ACCOUNT_SETUP.* FROM PM_IL_CLM_ACCOUNT_SETUP" +
		"WHERE CLMAS_MAIN_ACNT_CODE = '"+ action.getInitMainAccountcode() +"' AND CLMAS_SUB_ACNT_CODE = '"+ action.getInitSubAccountcode()+"'" +
				" AND CLMAS_DIVN_CODE = '"+ action.getInitDivisioncode()+"'";*/
		
		System.out.println("PM_IL_CLM_ACCOUNT_SETUP_DELEGATE.fetchPolicyDetails()-sqlQuery"+sqlQuery);

		// Fetch details
		connection = CommonUtils.getConnection();
		if(connection != null){
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				detailsList = new ArrayList<PM_IL_CLM_ACCOUNT_SETUP>();
				while (resultSet.next()) {
					details = new PM_IL_CLM_ACCOUNT_SETUP();
					details.setCLMAS_MAIN_ACNT_CODE(resultSet.getString("CLMAS_MAIN_ACNT_CODE"));
					details.setCLMAS_SUB_ACNT_CODE(resultSet.getString("CLMAS_SUB_ACNT_CODE"));
					details.setCLMAS_DIVN_CODE(resultSet.getString("CLMAS_DIVN_CODE"));
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
	
	public void fieldDescription(PM_IL_CLM_ACCOUNT_SETUP claimBean)
	{
		String mainAcntDesc = null;
		String subAcntdesc = null;
		String divnCodeDesc = null;
		String deptCodeDesc = null;
		String analysisDesc01 = null;
		String analysisDesc02 = null;
		
		String mainAcntQuery = "SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE = ? ";
		String subAcntQuery = "SELECT SUB_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE NVL(SUB_FRZ_FLAG,'N') = 'N' AND SUB_ACNT_CODE =?";
		//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
		//String divnCodeQuery = "select DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE = '001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE = ?";
		String divnCodeQuery = "select DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE = ?";
		//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
		//String deptCodeQuery = "SELECT DEPT_NAME FROM PM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND DEPT_CODE =  ?";
		String deptCodeQuery = "SELECT DEPT_NAME FROM FM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND DEPT_CODE =  ?";
		String analysisQuery01 = "select ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ?";
		String analysisQuery02 = "select ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ?";
	
		mainAcntDesc = fetchClaimDesc(claimBean.getCLMAS_MAIN_ACNT_CODE(), mainAcntQuery, "MAIN_ACNT_NAME");
		subAcntdesc = fetchClaimDesc(claimBean.getCLMAS_SUB_ACNT_CODE(), subAcntQuery, "SUB_ACNT_NAME");
		divnCodeDesc = fetchClaimDesc(claimBean.getCLMAS_DIVN_CODE(), divnCodeQuery, "DIVN_NAME");
		deptCodeDesc = fetchClaimDesc(claimBean.getCLMAS_DEPT_CODE(), deptCodeQuery, "DEPT_NAME");
		analysisDesc01 = fetchClaimDesc(claimBean.getCLMAS_ANLY_CODE_1(), analysisQuery01, "ANLY_NAME");
		analysisDesc02 = fetchClaimDesc(claimBean.getCLMAS_ANLY_CODE_2(), analysisQuery02, "ANLY_NAME");
		/*
		System.out.println("mainAcntDesc`#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#"+mainAcntDesc);
		System.out.println("subAcntdesc`#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#"+subAcntdesc);
		System.out.println("divnCodeDesc`#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#"+divnCodeDesc);
		System.out.println("deptCodeDesc`#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#"+deptCodeDesc);
		System.out.println("analysisDesc01`#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#"+analysisDesc01);
		System.out.println("analysisDesc02`#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#"+analysisDesc02);
		*/
		claimBean.setUI_M_MAIN_ACNT_NAME(mainAcntDesc);
		claimBean.setUI_M_SUB_ACNT_NAME(subAcntdesc);
		claimBean.setUI_M_DIVN_NAME(divnCodeDesc);
		claimBean.setUI_M_DEPT_NAME(deptCodeDesc);
		claimBean.setUI_M_ANLY_NAME(analysisDesc01);
		claimBean.setUI_M_ANLY_NAME_1(analysisDesc02);
	}
	
	public String fetchClaimDesc(String AccountCode,String selectQuery,String filedValue){
		String assignValue = null;
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = {AccountCode};
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					assignValue = rst.getString(filedValue);
					assignValue = assignValue == null ? "" : assignValue;
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignValue;
	}
}
