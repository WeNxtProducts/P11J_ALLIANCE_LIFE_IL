package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_CLAIM_STATUS_3_DELEGATE {
	public void preInsert(PT_IL_CLAIM claimBean,
			PT_IL_CLAIM_STATUS_3 status3Bean, CTRL ctrlBean) throws Exception{
		String PT_IL_CLAIM_STATUS_3_CS_SYS_ID_CURSOR_C1 = "SELECT PIL_CS_SYS_ID.NEXTVAL FROM DUAL";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			status3Bean.setCS_TYPE("C");
			status3Bean.setCS_CR_UID(ctrlBean.getUI_M_USER_ID());
			status3Bean.setCS_CR_DT(new CommonUtils().getCurrentDate());
			
			// Setting Claim Sys Id, since required for relationship
			status3Bean.setCS_CLM_SYS_ID(claimBean.getCLAIM_SYS_ID());

			// Setting SYSID as discussed with Vishnu
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(PT_IL_CLAIM_STATUS_3_CS_SYS_ID_CURSOR_C1, 
					connection);
			if(resultSet.next()){
				status3Bean.setCS_SYS_ID(resultSet.getLong(1));
			}
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	public void preUpdate(PT_IL_CLAIM_STATUS_3 status3Bean, CTRL ctrlBean) throws Exception{
		try {
			status3Bean.setCS_UPD_UID(ctrlBean.getUI_M_USER_ID());
			status3Bean.setCS_UPD_DT(new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(PT_IL_CLAIM_STATUS_3 status3Bean, CTRL ctrlBean) throws Exception{
		String PT_IL_CLAIM_STATUS_3_WCR_CURSOR_C1 = "SELECT USER_DESC "
			+ "FROM   MENU_USER " 
			+ "WHERE  USER_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			status3Bean.setCS_STATUS_UID(ctrlBean.getUI_M_USER_ID());
			
			/*Added by Janani on 14.06.2017 for ZBILQC-1724476*/
			
			/*status3Bean.setCS_STATUS_DT(new CommonUtils().getCurrentDate());*/
			status3Bean.setCS_STATUS_DT(new CommonUtils().getCurrentDateAndTimeNew());
			
			/*End*/
		
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(PT_IL_CLAIM_STATUS_3_WCR_CURSOR_C1, 
					connection, new Object[]{ctrlBean.getUI_M_USER_ID()});
			if(resultSet.next()){
				status3Bean.setUI_M_CS_UID_NAME(resultSet.getString("USER_DESC"));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	/**
	 * No use for java implementation, execute query will be called in sequence in onload
	 * @param claimBean
	 * @param status3Bean
	 * @param ctrlBean
	 * @throws Exception
	 */
	public void whenNewBlockInstance(PT_IL_CLAIM claimBean, 
			PT_IL_CLAIM_STATUS_3 status3Bean) throws Exception{
		String PT_IL_CLAIM_STATUS_3_WNBI_CURSOR_C1 = "SELECT 'X' "
			+ "FROM   PT_IL_CLAIM_STATUS "
			+ "WHERE  CS_CLM_SYS_ID = ? "
			+ "AND    CS_TYPE = 'C'";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String M_TEMP = null;
		
		/*try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(PT_IL_CLAIM_STATUS_3_WCR_CURSOR_C1, 
					connection, new Object[]{claimBean.getCLM_SYS_ID()});
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}*/
	}
	
	/**
	 * Rerender UI_M_CS_UID_NAME
	 * @param status3Bean
	 * @param ctrlBean
	 * @throws Exception
	 */
	public void postQuery(PT_IL_CLAIM_STATUS_3 status3Bean, CTRL ctrlBean) throws Exception{
		String PT_IL_CLAIM_STATUS_3_PQ_CURSOR_C1 = "SELECT USER_DESC "
			+ "FROM   MENU_USER " 
			+ "WHERE  USER_ID = ?"; 
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(PT_IL_CLAIM_STATUS_3_PQ_CURSOR_C1, 
					connection, new Object[]{ctrlBean.getUI_M_USER_ID()});
			if(resultSet.next()){
				status3Bean.setUI_M_CS_UID_NAME(resultSet.getString("USER_DESC"));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
}
