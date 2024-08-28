package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_MED_HIST_ACTION_DELEGATE {

	public PM_IL_DOC_MED_HIST_ACTION_DELEGATE() {
	}

	
	public List getDocumentMedicalHistoryValues()
	{
		Connection connection = null;
		
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection =CommonUtils.getConnection();
			if(getSessionValue()!=null)
			{
				String type = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				String code = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
				
				String query = "select DMH_DS_TYPE,DMH_DS_CODE,DMH_SR_NO,DMH_CAPTION,DMH_BL_CAPTION,DMH_DATA_TYPE," +
						"DMH_MANDATORY_YN,DMH_EFF_FM_DT,DMH_EFF_TO_DT,DMH_CR_DT,DMH_CR_UID,DMH_UPD_DT,DMH_UPD_UID," +
						"DMH_APPL_ON,ROWID from PM_IL_DOC_MED_HIST where DMH_DS_TYPE='"+type+"' and DMH_DS_CODE='"+code+"' ";
				list = dbHandler.fetch(query,"com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_MED_HIST",connection);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}
	
	
	public int updateData(PM_IL_DOC_MED_HIST pm_il_doc_med_hist)
			throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		PM_IL_DOC_MED_HIST_ACTION_HELPER pm_il_doc_med_hist_action_helper = new PM_IL_DOC_MED_HIST_ACTION_HELPER();
		try {
			
			connection = CommonUtils.getConnection();
		
			rowUpdated = dbHandler
					.executeInsert(pm_il_doc_med_hist, connection);
			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_DOC_MED_HIST pm_il_doc_med_hist)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		connection = CommonUtils.getConnection();
		deletedRows = handler.executeDelete(pm_il_doc_med_hist, connection);
		connection.commit();
		return deletedRows;
	}

	/**
	 * Method used to fetch the list of detailed values for a given document
	 * type and code
	 * 
	 * @param dmhDSType
	 * @param dmhDSCode
	 * @return
	 */
	public List getValues(String dmhDSType, String dmhDSCode) {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		String query = "";
		try {
			list = new ArrayList();
			System.out.println("Fetching medical hist for doc type <"
					+ dmhDSType + "> doc code <" + dmhDSCode + ">");
			connection = CommonUtils.getConnection();
			if (dmhDSType != null || dmhDSCode != null) {
				query = "select PM_IL_DOC_MED_HIST.ROWID,DMH_DS_TYPE,DMH_DS_CODE,DMH_SR_NO,DMH_CAPTION,DMH_BL_CAPTION,DMH_DATA_TYPE,DMH_MANDATORY_YN,DMH_EFF_FM_DT,DMH_EFF_TO_DT,DMH_CR_DT,DMH_CR_UID,DMH_UPD_DT,DMH_UPD_UID,DMH_APPL_ON from PM_IL_DOC_MED_HIST where DMH_DS_TYPE = '"+dmhDSType+"' and DMH_DS_CODE = '"+dmhDSCode+"'";
			} else {
				query = "select PM_IL_DOC_MED_HIST.ROWID,DMH_DS_TYPE,DMH_DS_CODE,DMH_SR_NO,DMH_CAPTION,DMH_BL_CAPTION,DMH_DATA_TYPE,DMH_MANDATORY_YN,DMH_EFF_FM_DT,DMH_EFF_TO_DT,DMH_CR_DT,DMH_CR_UID,DMH_UPD_DT,DMH_UPD_UID,DMH_APPL_ON from PM_IL_DOC_MED_HIST";
			}
			list = dbHandler
			.fetch(query,
					"com.iii.pel.forms.PILM013_APAC_PM_ILDOC_MED_HIST",
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}

	 public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
		{
			CommonUtils commonUtils = new CommonUtils();
			PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			if(actionBean == null)
			{
				return null;
			}else{
				PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
				return pm_il_doc_setup_composite_action;
				
			}
		}
	 
	 public String saveData(PM_IL_DOC_MED_HIST_ACTION pm_il_doc_med_hist_action )
		{
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();
				connection.commit();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			return "";
		}
}
