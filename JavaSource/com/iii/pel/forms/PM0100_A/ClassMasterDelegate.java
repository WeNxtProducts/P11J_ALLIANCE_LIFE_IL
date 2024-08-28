package com.iii.pel.forms.PM0100_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClassMasterDelegate {

	public Connection getConnection() throws Exception
	{
		Connection con = PM_AGENT_CONTRACT_MAINT_DTL_ACTION.getConnection();
		return con;
	}
	/*public Object fetchClassDetails(String classCode,Object obj)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		PM_IL_CONTRACTOR_SEARCH beanClass=(PM_IL_CONTRACTOR_SEARCH)obj;
		try 
		{
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT CLASS_CODE,CLASS_NAME,CLASS_SHORT_NAME " +
					"FROM PM_IL_CLASS WHERE CLASS_CODE='"+classCode+"'");
			while(resultSet.next())
			{
				beanClass.setCLASS_CODE(resultSet.getString(1));
				beanClass.setCLASS_NAME(resultSet.getString(2));
				beanClass.setCLASS_SHORT_NAME(resultSet.getString(3));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return beanClass;
	}*/

	public ArrayList<PM_AGENT_CONTRACT_MAINT_DTL_SEARCH> fetchClassMasterDetails(PM_AGENT_CONTRACT_MAINT_DTL_SEARCH_ACTION  pm_il_contractor_search_action)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		ArrayList<PM_AGENT_CONTRACT_MAINT_DTL_SEARCH> classMasterList=new ArrayList<PM_AGENT_CONTRACT_MAINT_DTL_SEARCH>();
		try 
		{
			String query = "SELECT  ACMD_RANK_CODE,ACMD_PROD_TYPE,ACMD_FM_DT,ACMD_TO_DT ,PM_AGENT_CONTRACT_MAINT_DTL.ROWID  " +
			"FROM PM_AGENT_CONTRACT_MAINT_DTL";
			if(pm_il_contractor_search_action.getACMD_RANK_CODE()!=null && pm_il_contractor_search_action.getACMD_RANK_CODE().trim().length()>0)
			{
				query=query+" WHERE UPPER(ACMD_RANK_CODE) LIKE " + "'"
				+ pm_il_contractor_search_action.getACMD_RANK_CODE().toUpperCase() + "%'";
			}
			System.out.println("ClassMasterDelegate.fetchClassMasterDetails() query check "+query);
			connection=getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next()){
				//Bala modified For PREMIA-GDC-1139199
				PM_AGENT_CONTRACT_MAINT_DTL_SEARCH pm_il_agent=new PM_AGENT_CONTRACT_MAINT_DTL_SEARCH();
				pm_il_agent.setACMD_RANK_CODE(resultSet.getString(1));
				pm_il_agent.setACMD_PROD_TYPE(resultSet.getString(2));		
				System.out
				.println("The date is:   **********************"+resultSet.getDate(3));

				pm_il_agent.setACMD_FM_DT(convertDate(resultSet.getDate(3)));
				pm_il_agent.setACMD_TO_DT(convertDate(resultSet.getDate(4)));
				pm_il_agent.setROWID(resultSet.getString(5));
				System.out
				.println("ClassMasterDelegate.fetchClassMasterDetails()>>>>> "+resultSet.getString(5));

				System.out.println("\n\n The values are:"+resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));
				classMasterList.add(pm_il_agent);
				System.out
				.println("The list is:  "+pm_il_agent.getACMD_RANK_CODE()+"  "+pm_il_agent.getACMD_PROD_TYPE());
			}
		} 
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return classMasterList;
	}
	public static String convertDate(java.util.Date d ) {
		String result=null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		result = sdf.format(d).toString();
		return result;
	} 
	
}
