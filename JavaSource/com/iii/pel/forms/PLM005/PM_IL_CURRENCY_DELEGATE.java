package com.iii.pel.forms.PLM005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CURRENCY_DELEGATE {
	
	
	public void executeSelectStatement(
			PLM005_COMPOSITE_ACTION PLM005_COMPOSITE_ACTION_BEAN)
			throws Exception {
		
		String selectStatement = "Select ROWID, PM_CURRENCY.* from PM_CURRENCY where ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		
		System.out.println("getPM_IL_CURRENCY_ACTION_BEAN    :"+PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN());
		
	System.out.println("getPM_CURRENCY_BEAN    :"+PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN());
		
		
		PM_CURRENCY pm_currency_bean = PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN();
	
		
		
		
		try{

					
			//System.out.println("In The Select Statement: "+query);
			connection=CommonUtils.getConnection();
		//	CRUDHandler handler=new CRUDHandler();
			System.out.println("Connection    "+connection+"     "+pm_currency_bean.getROWID());
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{pm_currency_bean.getROWID()});
			PM_CURRENCY PM_CURRENCY_BEAN = new PM_CURRENCY();
			
			while(resultSet.next())
			{
				PM_CURRENCY_BEAN.setROWID(resultSet.getString("ROWID"));
				
				System.out.println("ROWID :"+PM_CURRENCY_BEAN.getROWID());
				
				PM_CURRENCY_BEAN.setCURR_CODE(resultSet.getString("CURR_CODE"));
				
				System.out.println("CURR_CODE :"+PM_CURRENCY_BEAN.getCURR_CODE());
				
				PM_CURRENCY_BEAN.setCURR_NAME(resultSet.getString("CURR_NAME"));
				
				System.out.println("CURR_NAME :"+PM_CURRENCY_BEAN.getCURR_NAME());
				/* commented by pidugu raj dt: 31-08-2018 for uat only*/
				/*PM_CURRENCY_BEAN.setCURR_SHORT_NAME(resultSet.getString("CURR_SHORT_NAME"));
				
				System.out.println("CURR_SHORT_NAME :"+PM_CURRENCY_BEAN.getCURR_SHORT_NAME());
				 */
				PM_CURRENCY_BEAN.setCURR_UNIT_NAME(resultSet.getString("CURR_UNIT_NAME"));
				
				System.out.println("CURR_UNIT_NAME :"+PM_CURRENCY_BEAN.getCURR_UNIT_NAME());
				
				PM_CURRENCY_BEAN.setCURR_DECIMAL(resultSet.getInt("CURR_DECIMAL"));
				
				System.out.println("CURR_DECIMAL :"+PM_CURRENCY_BEAN.getCURR_DECIMAL());
				//beanClass.setInsertMode(false);

				
			}
			System.out.println("PM_CURRENCY_BEAN    "+PM_CURRENCY_BEAN.getCURR_CODE());
			PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().setPM_CURRENCY_BEAN(PM_CURRENCY_BEAN);
		
		}
		 finally {
				CommonUtils.closeCursor(resultSet);
			}
		
	}
	
	
	
	public ArrayList<SelectItem> EXC_RATE_FLAGLIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PLM005_QUERYCONSTANTS.EXC_RATE_FLAG_Values;
			resultSet = handler.executeSelectStatement(query, connection);
			
			SelectItem selectItem = null;
			while(resultSet.next()){
			 selectItem = new SelectItem();

				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				
				System.out.println("getValue    :"+selectItem.getValue());
				System.out.println("getLabel    :"+selectItem.getLabel());
				list.add(selectItem);
			}
			
		//	if(sel)
			
			
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	

}
