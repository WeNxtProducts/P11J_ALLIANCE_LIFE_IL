package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_NO_SETUP_DELEGATE {
	
	public PM_IL_DOC_NO_SETUP_DELEGATE()
	{
	}
	public void getDocumentNoSetupValues(PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action)
	{
		Connection connection = null;
		
		CRUDHandler dbHandler = new CRUDHandler();
		ResultSet resultSet = null;
		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = null;
		try {
			connection =CommonUtils.getConnection();
			pm_il_doc_no_setup =(PM_IL_DOC_NO_SETUP) pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN();
			if(getSessionValue()!=null)
			{
				String type =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				String code = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				String query = "select DNS_TYPE,DNS_CODE,DNS_FS,DNS_LEVEL_1,DNS_L1_ATTACH_YN,DNS_LEVEL_2,DNS_L2_ATTACH_YN," +
						"DNS_LEVEL_3,DNS_L3_ATTACH_YN,DNS_LEVEL_4,DNS_L4_ATTACH_YN,DNS_FRZ_FLAG,DNS_CR_DT,DNS_CR_UID," +
						"DNS_PREFIX_YN,DNS_PREFIX,DNS_PAD_YN,DNS_PAD_LENGTH,DNS_CHK_DIGIT_YN," +
						"DNS_LEVEL_5,DNS_L5_ATTACH_YN,DNS_YEAR_NUM,DNS_ATTACH_SEQ_LEVEL,ROWID from PM_IL_DOC_NO_SETUP " +
						"where DNS_TYPE=? and DNS_CODE=?";
				
				Object values[] = {type,code};
				resultSet = dbHandler.executeSelectStatement(query, connection, values);
				while(resultSet.next())
				{
					pm_il_doc_no_setup.setDNS_TYPE(resultSet.getString(1));
					pm_il_doc_no_setup.setDNS_CODE(resultSet.getString(2));
					pm_il_doc_no_setup.setDNS_FS(resultSet.getString(3));
					pm_il_doc_no_setup.setDNS_LEVEL_1(resultSet.getString(4));
					pm_il_doc_no_setup.setDNS_L1_ATTACH_YN(resultSet.getString(5));
					pm_il_doc_no_setup.setDNS_LEVEL_2(resultSet.getString(6));
					pm_il_doc_no_setup.setDNS_L2_ATTACH_YN(resultSet.getString(7));
					pm_il_doc_no_setup.setDNS_LEVEL_3(resultSet.getString(8));
					pm_il_doc_no_setup.setDNS_L3_ATTACH_YN(resultSet.getString(9));
					pm_il_doc_no_setup.setDNS_LEVEL_4(resultSet.getString(10));
					pm_il_doc_no_setup.setDNS_L4_ATTACH_YN(resultSet.getString(11));
					pm_il_doc_no_setup.setDNS_FRZ_FLAG(resultSet.getString(12));
					//pm_il_doc_no_setup.setDNS_CR_DT(resultSet.getString(13));
					pm_il_doc_no_setup.setDNS_CR_UID(resultSet.getString(14));
					pm_il_doc_no_setup.setDNS_PREFIX_YN(resultSet.getString(15));
					pm_il_doc_no_setup.setDNS_PREFIX(resultSet.getString(16));
					pm_il_doc_no_setup.setDNS_PAD_YN(resultSet.getString(17));
					pm_il_doc_no_setup.setDNS_PAD_LENGTH(Integer.parseInt(resultSet.getString(18)));
					pm_il_doc_no_setup.setDNS_CHK_DIGIT_YN(resultSet.getString(19));
					pm_il_doc_no_setup.setDNS_LEVEL_5(resultSet.getString(20));
					pm_il_doc_no_setup.setDNS_L5_ATTACH_YN(resultSet.getString(21));
					pm_il_doc_no_setup.setDNS_YEAR_NUM(resultSet.getString(22));
					pm_il_doc_no_setup.setDNS_ATTACH_SEQ_LEVEL(resultSet.getString(23));
					pm_il_doc_no_setup.setROWID(resultSet.getString(24));
					
				}
				
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("PM_IL_DOC_NO_SETUP_ACTION", pm_il_doc_no_setup_action);
				
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int updateData(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_doc_no_setup, connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	
	public int deleteData(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_doc_no_setup, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	
/* Fetch Applied On Combobox values */
	
	public ArrayList<SelectItem> fetchComboBoxValues(String formName,
			String blockName, String fieldName) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
			connection = CommonUtils.getConnection();
			queryString = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME = '{0}' AND LI_BLOCK_NAME = '{1}' AND LI_ITEM_NAME = '{2}'";
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);

			resultSet = handler.executeSelectStatement(queryString, connection);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}
	
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
	{
		PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if(actionBean == null)
		{
			return null;
		}else{
			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			return pm_il_doc_setup_composite_action;
			
		}
	}
	
}
