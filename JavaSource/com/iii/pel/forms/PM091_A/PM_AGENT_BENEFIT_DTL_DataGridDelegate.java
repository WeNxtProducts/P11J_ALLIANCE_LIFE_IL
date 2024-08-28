package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BENEFIT_DTL_DataGridDelegate {
	
	public List fetchValues(String benefitCode){
		String code = benefitCode;
		Connection con = null;
		CRUDHandler dbHandler = new CRUDHandler();
		String fetchQuery = "select ROWID,PM_AGENT_BENEFIT_DTL.* from PM_AGENT_BENEFIT_DTL where ABD_ABH_BNF_CODE='"+code+"'";
		List list = null;
		try{
			list =new ArrayList();
			con = getConnection();
			System.out		.println("fetchValues()--QUERY---["+fetchQuery+"]");
			list = dbHandler.fetch(fetchQuery, "com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_DTL", con);
			System.out
					.println("fetchValues()---["+list.size()+"]");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int updateData(PM_AGENT_BENEFIT_DTL dataGridBean) 
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
			System.out
					.println("PM_AGENT_BENEFIT_DTL_DataGridDelegate.updateData()--["+rowUpdated+"]");
			//connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return rowUpdated;
	}

	
	
	public int deleteData(PM_AGENT_BENEFIT_DTL gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			//connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public String saveData(PM_AGENT_BENEFIT_DTL_ACTION gridActionBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_AGENT_BENEFIT_DTL> valueBeanList = new ArrayList<PM_AGENT_BENEFIT_DTL>();
		try {
			connection = getConnection();
			valueBeanList = gridActionBean.getDtlTableList();
			for(int index = 0;index<valueBeanList.size(); index++)
			{
				PM_AGENT_BENEFIT_DTL gridValueBean = (PM_AGENT_BENEFIT_DTL)valueBeanList.get(index);
				handler.executeInsert(gridValueBean, connection);
			}
			
			connection.commit();
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
		/*FacesContext context= FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		
		
		con=(Connection)sessionMap.get("CLIENT_CON");*/
		
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return con;
	}

	public String duplicateCheck(PM_AGENT_BENEFIT_DTL pm_agent_benefit_dtl)
	{
		String M_DUMMY = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String query = null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(pm_agent_benefit_dtl.getROWID()==null)
			{
				System.out.println("came inside if in dup check");
				query=PM_AGENT_BENEFIT_QUERY_CONSTANTS.PM_AGENT_BENEFIT_DTL_DUP_CHECK_QUERY1;
				/*System.out.println(": "+pm_agent_benefit_dtl.getABD_ABH_BNF_CODE());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_BNF_FREQ());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_PROD_TYPE());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_LC_FYC_FM());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_LC_FYC_TO());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_LC_FYC_FM());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_LC_FYC_TO());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_LC_FYC_FM());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_LC_FYC_TO());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_NO_OF_POL_FM());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_NO_OF_POL_TO());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_NO_OF_POL_FM());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_NO_OF_POL_TO());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_NO_OF_POL_FM());
				System.out.println(": "+pm_agent_benefit_dtl.getABD_NO_OF_POL_TO());*/
				
				Object[] params = {pm_agent_benefit_dtl.getABD_ABH_BNF_CODE(),pm_agent_benefit_dtl.getABD_BNF_FREQ(),pm_agent_benefit_dtl.getABD_PROD_TYPE(),
						pm_agent_benefit_dtl.getABD_LC_FYC_FM(),pm_agent_benefit_dtl.getABD_LC_FYC_TO(),pm_agent_benefit_dtl.getABD_LC_FYC_FM(),pm_agent_benefit_dtl.getABD_LC_FYC_TO(),
						pm_agent_benefit_dtl.getABD_LC_FYC_FM(),pm_agent_benefit_dtl.getABD_LC_FYC_TO(),pm_agent_benefit_dtl.getABD_NO_OF_POL_FM(),pm_agent_benefit_dtl.getABD_NO_OF_POL_TO(),
						pm_agent_benefit_dtl.getABD_NO_OF_POL_FM(),pm_agent_benefit_dtl.getABD_NO_OF_POL_TO(),pm_agent_benefit_dtl.getABD_NO_OF_POL_FM(),pm_agent_benefit_dtl.getABD_NO_OF_POL_TO()};
				for(int i = 0; i<params.length; i++){
					System.out.println((i+1)+": "+params[i]);
				}
				resultSet = handler.executeSelectStatement(query, connection, params);
			}else{
				System.out.println("came inside else in dup check");
				query=PM_AGENT_BENEFIT_QUERY_CONSTANTS.PM_AGENT_BENEFIT_DTL_DUP_CHECK_QUERY2;		
				Object[] params = {pm_agent_benefit_dtl.getABD_ABH_BNF_CODE(),pm_agent_benefit_dtl.getABD_BNF_FREQ(),pm_agent_benefit_dtl.getABD_PROD_TYPE(),
						pm_agent_benefit_dtl.getABD_LC_FYC_FM(),pm_agent_benefit_dtl.getABD_LC_FYC_TO(),pm_agent_benefit_dtl.getABD_LC_FYC_FM(),pm_agent_benefit_dtl.getABD_LC_FYC_TO(),
						pm_agent_benefit_dtl.getABD_LC_FYC_FM(),pm_agent_benefit_dtl.getABD_LC_FYC_TO(),pm_agent_benefit_dtl.getABD_NO_OF_POL_FM(),pm_agent_benefit_dtl.getABD_NO_OF_POL_TO(),
						pm_agent_benefit_dtl.getABD_NO_OF_POL_FM(),pm_agent_benefit_dtl.getABD_NO_OF_POL_TO(),pm_agent_benefit_dtl.getABD_NO_OF_POL_FM(),pm_agent_benefit_dtl.getABD_NO_OF_POL_TO(),
						pm_agent_benefit_dtl.getROWID()};
				for(int i = 0; i<params.length; i++){
					System.out.println((i+1)+": "+params[i]);
				}
				resultSet = handler.executeSelectStatement(query, connection, params);
			}
			while(resultSet.next())
			{
				M_DUMMY = resultSet.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("M_DUMMY: "+M_DUMMY);
		return M_DUMMY;
	}
	

}
