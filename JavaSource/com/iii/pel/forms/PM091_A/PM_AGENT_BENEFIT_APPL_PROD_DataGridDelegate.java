package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate {
	
	
	public int updateData(PM_AGENT_BENEFIT_APPL_PROD dataGridBean) 
	{
		System.out.println("PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate.updateData()------UPDATE");
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			Connection con = getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dataGridBean, con);
			System.out.println("PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate.updateData()----ROWUPDATED---["+rowUpdated+"]");
			con.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return rowUpdated;
	}

	
	
	public int deleteData(PM_AGENT_BENEFIT_APPL_PROD gridValueBean)
	{
		System.out
				.println("PM_AGENT_BENEFIT_APPL_PROD_DataGridDelegate.deleteData()----TTTTTTTTTTTTTTTTTT");
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			con = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, con);
			//con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public String saveData(PM_AGENT_BENEFIT_APPL_PROD_ACTION gridActionBean)
	{
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_AGENT_BENEFIT_APPL_PROD> valueBeanList = new ArrayList<PM_AGENT_BENEFIT_APPL_PROD>();
		try {
			con = getConnection();
			valueBeanList = gridActionBean.getProdTableList();
			for(int index = 0;index<valueBeanList.size(); index++)
			{
				PM_AGENT_BENEFIT_APPL_PROD gridValueBean = (PM_AGENT_BENEFIT_APPL_PROD)valueBeanList.get(index);
				handler.executeInsert(gridValueBean, con);
			}
			
			con.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	
	public Connection getConnection() {
		Connection con =null;
		
		
		try{
		con=CommonUtils.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	return con;
		
	}

}
