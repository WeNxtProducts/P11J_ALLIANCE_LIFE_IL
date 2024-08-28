package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate {
	Connection con =getConnection();
	
	public List fetchValues(String benefitCode){
		String code = benefitCode;
		Connection con = null;
		CRUDHandler dbHandler = new CRUDHandler();
		String fetchQuery = "select ROWID,PM_AGENT_BENEFIT_APPL_RANK.* from PM_AGENT_BENEFIT_APPL_RANK where ABAR_ABH_BNF_CODE='"+code+"'";
		List list = null;
		try{
			list =new ArrayList();
		//	con = getConnection();
			list = dbHandler.fetch(fetchQuery, "com.iii.pel.forms.PM_AGENT_BENEFIT_APPL_RANK", con);
			System.out
					.println("fetchValues()---["+list.size()+"]");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateData(PM_AGENT_BENEFIT_APPL_RANK dataGridBean) 
	{
		System.out.println("PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate.updateData()------UPDATE");
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dataGridBean, con);
			con.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return rowUpdated;
	}

	
	
	public int deleteData(PM_AGENT_BENEFIT_APPL_RANK gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, con);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public String saveData(PM_AGENT_BENEFIT_APPL_RANK_ACTION gridActionBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_AGENT_BENEFIT_APPL_RANK> valueBeanList = new ArrayList<PM_AGENT_BENEFIT_APPL_RANK>();
		try {
			connection = getConnection();
			valueBeanList = gridActionBean.getRankTableList();
			for(int index = 0;index<valueBeanList.size(); index++)
			{
				PM_AGENT_BENEFIT_APPL_RANK gridValueBean = (PM_AGENT_BENEFIT_APPL_RANK)valueBeanList.get(index);
				handler.executeInsert(gridValueBean, connection);
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
		try
		{
			con=CommonUtils.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
