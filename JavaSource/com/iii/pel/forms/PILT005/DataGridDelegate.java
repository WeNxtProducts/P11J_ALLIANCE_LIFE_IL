package com.iii.pel.forms.PILT005;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;

public class DataGridDelegate {
	
	
	public Connection getConnection() throws Exception{
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection connection = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");
		return connection;
	}
	
	public List getValues()
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection = getConnection();
			String query = "select RSA_PLAN_CODE,RSA_YEAR_FROM,RSA_YEAR_TO,RSA_PERIOD_FROM,RSA_PERIOD_TO," +
			"RSA_RI_RATE,RSA_CQS_RATE,RSA_RATE_PER,ROWID from PM_IL_RED_SA where RSA_PLAN_CODE='dee'";
			list = dbHandler.fetch(query,"com.iii.pel.forms.PILM003_APAC.DataGridValueBean",connection);
			System.out.println("______________Check for rowid: "+((PT_IL_LOAN_REPAYMENT)list.get(0)).getROWID());
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}
	
	public int updateData(PT_IL_LOAN_REPAYMENT dataGridBean) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		System.out.println("getLR_SYS_ID#########################"+dataGridBean.getLR_LOAN_SYS_ID());
		try {
			connection = getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public String saveData(DataGridAction dataGridAction)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PT_IL_LOAN_REPAYMENT> valueBeanList = null;
		try {
			connection = getConnection();
			valueBeanList = dataGridAction.getDataTableList();
			for(int index = 0;index<valueBeanList.size(); index++)
			{
				PT_IL_LOAN_REPAYMENT gridValueBean = (PT_IL_LOAN_REPAYMENT)valueBeanList.get(index);
//				gridValueBean.setRSA_PLAN_CODE("dee");
				handler.executeInsert(gridValueBean, connection);
			}
			
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	/*public String onFocusSaveAction(DataGridAction dataGridAction,int currentindex)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<DataGridValueBean> valueBeanList = null;
		try {
			connection = getConnection();
			valueBeanList = dataGridAction.getDataTableList();
			DataGridValueBean gridValueBean = (DataGridValueBean)valueBeanList.get(currentindex);
			gridValueBean.setRSA_PLAN_CODE("dee");
			handler.executeInsert(gridValueBean, connection);
			
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	
	}*/
	
	
	public int deleteData(PT_IL_LOAN_REPAYMENT gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	/*public List getRowIdValues()
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List rowidList = null;
		try {
			rowidList = new ArrayList();
			connection = getConnection();
			String query = "select ROWID from PM_IL_RED_SA";
			rowidList = dbHandler.fetch(query,"com.iii.pel.forms.PILM003_APAC.DataGridValueBean",connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return rowidList;
	}*/
	
}
