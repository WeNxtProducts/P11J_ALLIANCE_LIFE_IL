package com.iii.pel.forms.PM023_A;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.CHART.ChartBean;
import com.iii.pel.forms.PM075_A.PM_CUSTOMER;
import com.iii.pel.forms.PM075_A.PM_CUST_DIVN;
import com.iii.pel.forms.PM075_A.PM_CUST_DIVN_DELEGATE;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM023_CUSTOM_REPORT_HELPER implements Serializable{

	private static final long serialVersionUID = 6050702705978032346L;
	
	
	public PM023_CUSTOM_REPORT_HELPER(){
		super();
	}


	public List<PM_CUSTOMIZED_REPORT> executeQuery(PM023_A_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_CUSTOMIZED_REPORT>  PM_CUSTOMIZED_REPORT_LIST = new ArrayList<PM_CUSTOMIZED_REPORT>();
		try{
			new DelegateDb().executeSelectStatement(compositeAction);
			PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT = new PM_CUSTOMIZED_REPORT();
			PM_CUSTOMIZED_REPORT_LIST = compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getTableList();
			/*String query = "SELECT * FROM PM_CUSTOMIZED_REPORT";
			
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			
			while(resultSet.next()){
				PM_CUSTOMIZED_REPORT.setREP_ID(resultSet.getString(1));
				PM_CUSTOMIZED_REPORT.setREP_DESC(resultSet.getString(2));
				PM_CUSTOMIZED_REPORT_LIST.add(PM_CUSTOMIZED_REPORT);
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return PM_CUSTOMIZED_REPORT_LIST;
		
	}
	
	
	
	public PM_CUSTOMIZED_REPORT getDetails(PM023_A_COMPOSITE_ACTION compositeAction) {
		
		ResultSet resultSet = null;
		PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT_BEAN = new PM_CUSTOMIZED_REPORT();
		try{
			
			String query = "SELECT ROWID,REP_ID,REP_DESC FROM PM_CUSTOMIZED_REPORT where REP_ID = ?";
			
			resultSet = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_ID()} );
			
			if(resultSet.next()){
				PM_CUSTOMIZED_REPORT_BEAN.setROWID(resultSet.getString(1));
				PM_CUSTOMIZED_REPORT_BEAN.setREP_ID(compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_ID());
				PM_CUSTOMIZED_REPORT_BEAN.setREP_DESC(compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_DESC());
			}else{
				PM_CUSTOMIZED_REPORT_BEAN.setREP_ID(compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_ID());
				PM_CUSTOMIZED_REPORT_BEAN.setREP_DESC(compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_DESC());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return PM_CUSTOMIZED_REPORT_BEAN;
		
	}


	public void preInsert(PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT_BEAN) throws Exception{
		
		try {
			new CRUDHandler().executeInsert(PM_CUSTOMIZED_REPORT_BEAN, CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	
public void postQuery(PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT_BEAN) throws Exception{
		
		
		String CURSOR_C1 = "select rep_id,rep_desc from pm_customized_report  WHERE  rep_id =  ? and rep_desc = ? ";
		  ResultSet resultSet = null;
		  try {
			resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1,CommonUtils.getConnection(), new Object[]{PM_CUSTOMIZED_REPORT_BEAN.getREP_ID(),PM_CUSTOMIZED_REPORT_BEAN.getREP_DESC()} );
			if (resultSet.next()) {
				PM_CUSTOMIZED_REPORT_BEAN.setREP_ID(resultSet.getString(1));
				PM_CUSTOMIZED_REPORT_BEAN.setREP_DESC(resultSet.getString(2));
			}
		
		  
		  } catch (SQLException e) {
			  e.printStackTrace();
			  throw new Exception(e.getMessage());
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		  
	}

public void executeDelete(PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT) throws Exception{
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	String query = "DELETE FROM PM_CUSTOMIZED_REPORT WHERE REP_ID=?";
	
	try {
		connection = CommonUtils.getConnection();
		
		handler.executeDeleteStatement(query, connection, 
				new Object[]{PM_CUSTOMIZED_REPORT.getREP_ID()});
		connection.commit();
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	} 
	}
	

}
