package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_SETUP_HELPER {

	public void RPS_CODE_WHEN_VALIDATE_ITEM(PM_IL_RI_POOL_SETUP PM_IL_RI_POOL_SETUP_BEAN) throws Exception{
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
						
			String query = "SELECT 'X' FROM PM_IL_RI_POOL_SETUP WHERE RPS_CODE =  ? ";
			Object[] values = {PM_IL_RI_POOL_SETUP_BEAN.getRPS_CODE()};
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"1801"));	
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
	}
	
	public void RPS_EFF_FM_DT_WHEN_VALIDATE_ITEM(Date fromDate, PM_IL_RI_POOL_SETUP_ACTION setupAction) throws Exception{
		Date toDate = setupAction.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_EFF_TO_DT();
		try{
		if(fromDate != null && toDate != null){ 
			if(fromDate.after(toDate)){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91010"));	
			}			
		}
		
		if(fromDate != null){
			Date sysDate = new java.util.Date(Calendar.getInstance().getTimeInMillis());
			if(sysDate.before(fromDate)){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"12505"));	
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void RPS_EFF_TO_DT_WHEN_VALIDATE_ITEM(Date toDate, PM_IL_RI_POOL_SETUP_ACTION setupAction) throws Exception{
		Date fromDate = setupAction.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_EFF_FM_DT();
		try{
		if(fromDate != null && toDate != null){
			if(fromDate.after(toDate)){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91010"));	
			}			
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void RPS_DESC_WHEN_VALIDATE_ITEM(String RPS_DESC_STRING, PM_IL_RI_POOL_SETUP_ACTION setupAction){
		String RPS_DESC_STRING_LOCAL = RPS_DESC_STRING.substring(0,30);
		setupAction.getPM_IL_RI_POOL_SETUP_BEAN().setRPS_DESC(RPS_DESC_STRING_LOCAL);
		
	}
	
	
	
	public void preInsert(PM_IL_RI_POOL_SETUP setupBean) throws Exception{
		
		String M_RPS_CODE = null;
		ResultSet resultSet = null;
		String CURSOR_C1 = "SELECT RPS_CODE FROM   PM_IL_RI_POOL_SETUP  WHERE  RPS_CODE =  ? ";

		try {
		setupBean.setRPS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			setupBean.setRPS_CR_DT(new CommonUtils().getCurrentDate());
		resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection() , new Object[]{setupBean.getRPS_CODE()});
		if (resultSet.next()) {
		throw new Exception(Messages.getString(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "1801"));	
		}
		   	 
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}}

		     
		   
	}
	
	
	public void preUpdate(PM_IL_RI_POOL_SETUP setupBean) throws Exception{
		try {
			setupBean.setRPS_UPD_DT(new CommonUtils().getCurrentDate());
			setupBean.setRPS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
}
