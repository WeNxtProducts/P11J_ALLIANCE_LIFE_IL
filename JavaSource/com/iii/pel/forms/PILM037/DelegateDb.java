package com.iii.pel.forms.PILM037;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class DelegateDb {
	public DelegateDb() {
		super();
	}
	
	public ArrayList<PM_IL_BONUS_SETUP> populatePlanCodeLov(String planCode){
		
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PM_IL_BONUS_SETUP> list=null;
		ResultSet resultSet=null;
		Connection connection = null;
		String query=null;
		try 
		{
			connection = CommonUtils.getConnection();
			if(connection != null) {
				list = new ArrayList<PM_IL_BONUS_SETUP>();
				if("*".equalsIgnoreCase(planCode))
				{
					query = PILM037_SQLQUERY_CONSTANTS.PM_IL_PLAN_LOV;
				}
				else
				{
					query = PILM037_SQLQUERY_CONSTANTS.PM_IL_PLAN_LOV_1;
					query=query.replace("{0}", planCode);
				}
			}else{
				System.out.println("DelegateDb.parameterTypeLov()**************Connection is Null"); 
			}
			Object[] value={};
			resultSet=handler.executeSelectStatement(query,connection, value);
			while(resultSet.next())
			{
				PM_IL_BONUS_SETUP valueBean = new PM_IL_BONUS_SETUP();
				valueBean.setBSET_PLAN_CODE(resultSet.getString(1));
				System.out.println("*****************PLAN CODE*******************"+resultSet.getString(1));
				valueBean.setUI_M_PLAN_CODE_DESC(resultSet.getString(2));
				System.out.println("*****************CODE DESC*******************"+resultSet.getString(2));
				list.add(valueBean);
			}
			
			
			//connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
public ArrayList<PM_IL_BONUS_SETUP> populateBonusCodeLov(String bonusCode){
		
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PM_IL_BONUS_SETUP> list=null;
		ResultSet resultSet=null;
		Connection connection = null;
		String query=null;
		try 
		{
			connection = CommonUtils.getConnection();
			if(connection != null) {
				list = new ArrayList<PM_IL_BONUS_SETUP>();
				if("*".equalsIgnoreCase(bonusCode))
				{
					query = PILM037_SQLQUERY_CONSTANTS.PM_IL_BONUS_BSET_BONUS_LOV;
				}
				else
				{
					query = PILM037_SQLQUERY_CONSTANTS.PM_IL_BONUS_BSET_BONUS_LOV1;
					query=query.replace("{0}", bonusCode);
				}
			}else{
				System.out.println("DelegateDb.parameterTypeLov()**************Connection is Null"); 
			}
			Object[] value={};
			resultSet=handler.executeSelectStatement(query,connection, value);
			while(resultSet.next())
			{
				PM_IL_BONUS_SETUP valueBean = new PM_IL_BONUS_SETUP();
				valueBean.setBSET_BONUS_CODE(resultSet.getString(1));
				System.out.println("*****************BONUS CODE*******************"+resultSet.getString(1));
				valueBean.setUI_M_BSET_BONUS_CODE_DESC(resultSet.getString(2));
				System.out.println("*****************CODE DESC*******************"+resultSet.getString(2));
				list.add(valueBean);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*finally
		{
			try {
				//connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		return list;
	}
	
	
	
	
	public ArrayList<SelectItem> selectValueForComboBox(String formName, String blockName, String fieldName, String queryString) {
		Connection con = null;
		ConnectionAgent agent = null;
		ResultSet resultSet=null;
		ArrayList<SelectItem> drpDwn = null;
		Object value[]={}; 
		try {
			con = agent.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);
			
			resultSet = handler.executeSelectStatement(queryString, con, value);
			
			drpDwn = new ArrayList<SelectItem>();
			while(resultSet.next()){
				System.out.println(">>Comming here");
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				System.out.println("Item: "+selectItem.getLabel()+", "+selectItem.getValue());
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drpDwn;		
	} 
	 
	/**
	 * Populates the bonus setup table
	 * @param planCode
	 * @return ArrayList<PM_IL_BONUS_SETUP>
	 */
	public ArrayList<PM_IL_BONUS_SETUP> dataBaseCallForTableValues(String planCode) {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		ArrayList<PM_IL_BONUS_SETUP> valueBeanList = null;
		PM_IL_BONUS_SETUP valueBean = null;
		try{
			connection = CommonUtils.getConnection();
			if(connection != null) {
				query = PILM037_SQLQUERY_CONSTANTS.PM_IL_BONUS_Table_Values;
				query=query.replace("{0}", planCode);
				Object[] value={};
				resultSet = handler.executeSelectStatement(query, connection,value);
				valueBeanList = new ArrayList<PM_IL_BONUS_SETUP>();
				while(resultSet.next()){
					valueBean = new PM_IL_BONUS_SETUP();
					valueBean.setBSET_PLAN_CODE(resultSet.getString(1));
					valueBean.setBSET_BONUS_CODE(resultSet.getString(2));
					valueBean.setUI_M_BSET_BONUS_CODE_DESC(resultSet.getString(3));
					valueBean.setBSET_YEAR(resultSet.getInt(4));
					valueBean.setBSET_RATE(resultSet.getDouble(5));
					valueBean.setBSET_RATE_PER(resultSet.getDouble(6));
					valueBean.setROWID(resultSet.getString(7));
					valueBean.setBSET_CR_DT(resultSet.getDate(8));
					valueBean.setBSET_CR_UID(resultSet.getString(9));
					valueBeanList.add(valueBean);
				}
			}

			//connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueBeanList;
	}
	
	/**
	 * Method to delete Row
	 * @param detailsBean
	 * @return
	 */
	public int deleteData(PM_IL_BONUS_SETUP detailsBean)
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
	public int updateData(PM_IL_BONUS_SETUP detailsBean) throws Exception
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
	
 
	public void executeSelectStatement (PILM037_COMPOSITE_ACTION PILM037_COMPOSITE_ACTION_BEAN) throws Exception { 
	    String selectStatement=" SELECT PM_IL_BONUS_SETUP.ROWID, PM_IL_BONUS_SETUP.* FROM PM_IL_BONUS_SETUP WHERE " +
	    		" PM_IL_BONUS_SETUP.BSET_PLAN_CODE IN " +
	    		"	( SELECT PLAN_CODE  FROM PM_IL_PLAN  WHERE  PM_IL_PLAN.ROWID= ? ) ORDER BY BSET_BONUS_CODE, BSET_YEAR";
	   Connection connection=null;
	   ResultSet resultSet=null;
	  PILM037_COMPOSITE_ACTION_BEAN.getPM_IL_BONUS_SETUP_ACTION_BEAN().getTableList().clear();
	   try {
	  connection=CommonUtils.getConnection();
	   resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection,
		   new Object[]{PILM037_COMPOSITE_ACTION_BEAN.getPM_IL_BONUS_SETUP_ACTION_BEAN().getPM_IL_PLAN_BEAN().getROWID()});
	   while (resultSet.next()) {
	   PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN = new PM_IL_BONUS_SETUP();
	   PM_IL_BONUS_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(resultSet.getString("BSET_PLAN_CODE"));
	//   PILM037_COMPOSITE_ACTION_BEAN.getPM_IL_BONUS_SETUP_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_CODE(resultSet.getString("BSET_PLAN_CODE"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_CODE(resultSet.getString("BSET_BONUS_CODE"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_YEAR(resultSet.getInt("BSET_YEAR"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_RATE(resultSet.getDouble("BSET_RATE"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_RATE_PER(resultSet.getDouble("BSET_RATE_PER"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_CR_DT(resultSet.getDate("BSET_CR_DT"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_CR_UID(resultSet.getString("BSET_CR_UID"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_DT(resultSet.getDate("BSET_UPD_DT"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_UID(resultSet.getString("BSET_UPD_UID"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_GIVEN_IN(resultSet.getString("BSET_BONUS_GIVEN_IN"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_APPLIED_ON(resultSet.getString("BSET_APPLIED_ON"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_UNIT_PUR_YN(resultSet.getString("BSET_UNIT_PUR_YN"));
	  PM_IL_BONUS_SETUP_BEAN.setBSET_BUY_SELL(resultSet.getString("BSET_BUY_SELL"));
	  new PILM037_Helper().postQuery(PM_IL_BONUS_SETUP_BEAN);
	  PILM037_COMPOSITE_ACTION_BEAN.getPM_IL_BONUS_SETUP_ACTION_BEAN().getTableList().add(PM_IL_BONUS_SETUP_BEAN);
	  }
	   } 
	   finally { 
	   CommonUtils.closeCursor(resultSet);
	  } 
	  } 


}
