package com.iii.pel.forms.PILM075_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM075_APAC_DELEGATE {

	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) {
		
		Connection connection = null;
		CRUDHandler handler = null;
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			queryString = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME = ? AND LI_BLOCK_NAME = ? AND LI_ITEM_NAME = ?";
//			queryString = queryString.replace("{0}", formName);
//			queryString = queryString.replace("{1}", blockName);
//			queryString = queryString.replace("{2}", fieldName);
			Object[] values = {formName, blockName, fieldName};

			resultSet = handler.executeSelectStatement(queryString, connection, values);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (resultSet !=null){
					CommonUtils.closeCursor(resultSet);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}

	/**
	 * Search Page Fetch Records Functionality.
	 */
	public ArrayList fetchMasterDetails(PILM075_APAC_SEARCH_ACTION search_action) throws ValidatorException{
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList classMasterList = new ArrayList();
		
		try {
			connection = CommonUtils.getConnection();
			String query = PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$SEARCH_QUERY;
			String userCode = search_action.getUserCode() + "%";
			String fromEntdCode = search_action.getFromEndtCode() + "%";
			String toEntdCode = search_action.getToEndtCode() + "%";
			Object[] values = {userCode, fromEntdCode,toEntdCode};
	
			resultSet = handler.executeSelectStatement(query, connection, values);
			if (resultSet != null) {
				while (resultSet.next()) {
					PM_IL_END_APPR_SETUP bean = new PM_IL_END_APPR_SETUP();
					bean.setEAS_AS_USER_ID(resultSet.getString("EAS_AS_USER_ID"));
					bean.setEAS_FM_END_CODE(resultSet.getString("EAS_FM_END_CODE"));
					bean.setEAS_TO_END_CODE(resultSet.getString("EAS_TO_END_CODE"));
					bean.setROWID(resultSet.getString("ROWID"));
					classMasterList.add(bean);
				}
			}
		} catch (SQLException se) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(se.getMessage()));
		} 
		catch (Exception e) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
		
		finally{
			try {
				if (resultSet !=null){
					CommonUtils.closeCursor(resultSet);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return classMasterList;
	}
	
	public PM_IL_END_APPR_SETUP fetchClassMasterDetails() {
		ResultSet resultSet = null;		
		PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN =null;
		try {
		    CRUDHandler handler = new CRUDHandler();
			
			Connection connection = null;
			PM_IL_END_APPR_SETUP_ACTION action  = (PM_IL_END_APPR_SETUP_ACTION) CommonUtils.getGlobalObject("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION");
			String rowId = action.getPM_IL_END_APPR_SETUP_BEAN().getROWID();
			
			String query = PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$MAIN_PAGE_QUERY;
			Object values[] = {rowId};
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			while (resultSet.next()) {
				/*[BugId:TRACK_PREMIAGDC_GL.10.5-00178: ROWID fetched and set into the bean. Added By : Mallika.S 01-Apr-2009 */
				PM_IL_END_APPR_SETUP_BEAN = new PM_IL_END_APPR_SETUP();
				PM_IL_END_APPR_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_USER_ID(resultSet.getString("EAS_AS_USER_ID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_FM_PROD_CODE(resultSet.getString("EAS_AS_FM_PROD_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_TO_PROD_CODE(resultSet.getString("EAS_AS_TO_PROD_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN(resultSet.getString("EAS_END_PROC_YN"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_APPR_YN(resultSet.getString("EAS_END_APPR_YN"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_CR_DT(resultSet.getDate("EAS_CR_DT"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_CR_UID(resultSet.getString("EAS_CR_UID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_UPD_DT(resultSet.getDate("EAS_UPD_DT"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_UPD_UID(resultSet.getString("EAS_UPD_UID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE(resultSet.getString("EAS_FM_END_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE(resultSet.getString("EAS_TO_END_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_SYS_ID(resultSet.getInt("EAS_SYS_ID"));				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally{
			try {
				if (resultSet !=null){
					CommonUtils.closeCursor(resultSet);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PM_IL_END_APPR_SETUP_BEAN;
	} 
	
	/* [BugId:PREMIAGDC-000069 Deepika 25-Feb-09 Newly added method for requerying the Master details in copy window */

	public void fetchMasterDetails(PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN,String userId)
	{
		ResultSet resultSet = null;		
		try {
		    CRUDHandler handler = new CRUDHandler();
			
			Connection connection = null;
			String query = PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$MAIN_PAGE_QUERY1;
			Object values[] = {userId};
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			while (resultSet.next()) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_USER_ID(resultSet.getString("EAS_AS_USER_ID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_FM_PROD_CODE(resultSet.getString("EAS_AS_FM_PROD_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_TO_PROD_CODE(resultSet.getString("EAS_AS_TO_PROD_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN(resultSet.getString("EAS_END_PROC_YN"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_APPR_YN(resultSet.getString("EAS_END_APPR_YN"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_CR_DT(resultSet.getDate("EAS_CR_DT"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_CR_UID(resultSet.getString("EAS_CR_UID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_UPD_DT(resultSet.getDate("EAS_UPD_DT"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_UPD_UID(resultSet.getString("EAS_UPD_UID"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE(resultSet.getString("EAS_FM_END_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE(resultSet.getString("EAS_TO_END_CODE"));
				PM_IL_END_APPR_SETUP_BEAN.setEAS_SYS_ID(resultSet.getInt("EAS_SYS_ID"));	
				PM_IL_END_APPR_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally{
			try {
				if (resultSet !=null){
					CommonUtils.closeCursor(resultSet);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/* BugId:PREMIAGDC-000069 Deepika 25-Feb-09 Newly added method for requerying the Master details in copy window ]*/
	
}
