package com.iii.pel.forms.PM023_A;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM075_A.PM_CUST_DIVN;
import com.iii.pel.forms.PM075_A.PM_CUST_DIVN_HELPER;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class DelegateDb implements Serializable {
	
	private static final long serialVersionUID = -8979017245598320611L;


	public DelegateDb() {
		super();
	}
	

	/**
	 * Method to delete Row
	 * @param detailsBean
	 * @return
	 */
	public int deleteData(PM_CUSTOMIZED_REPORT detailsBean)
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(detailsBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	
	/**
	 * Method to update or insert row 
	 * @param detailsBean
	 * @return
	 * @throws Exception
	 */
	public int updateData(PM_CUSTOMIZED_REPORT detailsBean) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		int rowUpdated = 0;
		
		try {
			connection = CommonUtils.getConnection();
			System.out.println("DelegateDb.updateData()IN UPDATE DATA");
			
			rowUpdated = handler.executeInsert(detailsBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}


	public void executeSelectStatement(PM023_A_COMPOSITE_ACTION compositeAction) throws Exception { 
		  String selectStatement="select * from pm_customized_report";
		  Connection connection=null;
		  ResultSet resultSet=null;
		  compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getTableList().clear();
		  try {
		 connection=CommonUtils.getConnection();
		  resultSet=new CRUDHandler().executeSelectStatement(selectStatement, connection);
		  while (resultSet.next()) {
			  PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT = new PM_CUSTOMIZED_REPORT();
			  PM_CUSTOMIZED_REPORT.setREP_ID(resultSet.getString("REP_ID"));
			  PM_CUSTOMIZED_REPORT.setREP_DESC(resultSet.getString("REP_DESC"));
			  new PM023_CUSTOM_REPORT_HELPER().postQuery(PM_CUSTOMIZED_REPORT);

		 compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getTableList().add(PM_CUSTOMIZED_REPORT);
		 }
		  } 
		  finally { 
		  CommonUtils.closeCursor(resultSet);
		 } 
}
	
 
	
}
