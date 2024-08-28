package com.iii.pel.forms.PILM021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CUST_ACCOUNT_SETUP_DELEGATE {

	public ArrayList<PM_IL_CUST_ACCOUNT_SETUP> fetchPolicyDetails(PM_IL_CUST_ACCOUNT_SETUP_SEARCH action) throws ValidatorException{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PM_IL_CUST_ACCOUNT_SETUP details = null;
		ArrayList<PM_IL_CUST_ACCOUNT_SETUP> detailsList = null;
		//PM_IL_CLM_ACCOUNT_SETUP searchBean = action.getSearchBean();
		System.out.println("INSIDE NULL");
		String sqlQuery = "select CAS_MAIN_ACNT_CODE,CAS_DIVN_CODE,ROWID FROM PM_IL_CUST_ACCOUNT_SETUP";
		
		if(action.getInitControlAccountcode()!=null&&action.getInitControlAccountcode().trim().length()>0){
			System.out.println("INSIDE ! NULL");
			sqlQuery = sqlQuery+" WHERE CAS_MAIN_ACNT_CODE LIKE '"+ action.getInitControlAccountcode()+ "%'";
		}
		else if(action.getInitBranchcode()!=null&&action.getInitBranchcode().trim().length()>0){
			sqlQuery = sqlQuery+" WHERE CAS_DIVN_CODE LIKE '"+ action.getInitBranchcode().toUpperCase() + "%'";
		}
		
		/*String sqlQuery = "select PM_IL_CLM_ACCOUNT_SETUP.* FROM PM_IL_CLM_ACCOUNT_SETUP" +
		"WHERE CLMAS_MAIN_ACNT_CODE = '"+ action.getInitMainAccountcode() +"' AND CLMAS_SUB_ACNT_CODE = '"+ action.getInitSubAccountcode()+"'" +
				" AND CLMAS_DIVN_CODE = '"+ action.getInitDivisioncode()+"'";*/
		
		System.out.println("PM_IL_CUST_ACCOUNT_SETUP_DELEGATE.fetchPolicyDetails()-sqlQuery"+sqlQuery);

		// Fetch details
			try {
				connection = CommonUtils.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				if (resultSet != null) {
				detailsList = new ArrayList<PM_IL_CUST_ACCOUNT_SETUP>();
				while (resultSet.next()) {
					details = new PM_IL_CUST_ACCOUNT_SETUP();
					details.setCAS_MAIN_ACNT_CODE(resultSet
							.getString("CAS_MAIN_ACNT_CODE"));
					details.setCAS_DIVN_CODE(resultSet
							.getString("CAS_DIVN_CODE"));
					details.setROWID(resultSet.getString("ROWID"));
					// details.setCLMAS_BUS_FM_CODE(resultSet.getString("CLMAS_BUS_FM_CODE"));
					// details.setCLMAS_BUS_TO_CODE(resultSet.getString("CLMAS_BUS_TO_CODE"));

					detailsList.add(details);
				}
			}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}finally{
				try {
					if(resultSet != null){
						CommonUtils.closeCursor(resultSet);
					}
				} catch (Exception e) {
				}
			}
		return detailsList;
	}
}
