package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_MED_HIST_ACTION_HELPER {
	private String errorMessages;

	private Map<String, String> errorMap = new HashMap<String, String>();

	private Map<String, Object> session = null;
	private ControlBean ctrlBean = null;

	public void setInsertInformationMessage(int size) {
		errorMap.put("somekey", size + " record inserted.");
		errorMap.put("current", size + " record inserted.");
	}

	public void setUpdateInformationMessage(int size) {
		errorMap.put("update:", size + " record updated.");
		errorMap.put("current", size + " record updated.");
	}

	public void setDeleteInformationMessage(int size) {
		errorMap.put("somekey", size + " records deleted.");
		errorMap.put("current", size + " records deleted.");
	}

	/* Error handling */
	public String getErrorMessages() {
		String messageList;
		if ((errorMap == null) || (errorMap.size() == 0)) {
			messageList = "";
		} else {
			Map<String, String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=2><UL>\n";
			for (String message : error.values()) {

				messageList = messageList + "<LI>" + message + "\n";
			}
			messageList = messageList + "</UL></FONT>\n";
		}
		return messageList;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public void PILM013_APAC_PM_IL_DOC_MED_HIST_WHEN_CREATE_RECORD(PM_IL_DOC_MED_HIST_ACTION pm_il_doc_med_hist_action){
//      :PM_IL_DOC_MED_HIST.DMH_DATA_TYPE="C";
//    	:PM_IL_DOC_MED_HIST.DMH_MANDATORY_YN="N";
	}
	
	public void PILM013_APAC_PM_IL_DOC_MED_HIST_PRE_INSERT(PM_IL_DOC_MED_HIST_ACTION pm_il_doc_med_hist_action){
//    	L_DUP_SRLNO.L_DUP_SRLNO();
		//TODO: created user id should be from session/parent form
		PM_IL_DOC_MED_HIST pm_il_doc_med_hist;
		int currentRow;
		currentRow=pm_il_doc_med_hist_action.getDataTable().getRowIndex();
		pm_il_doc_med_hist=pm_il_doc_med_hist_action.getDataTableList().get(currentRow);
		pm_il_doc_med_hist.setDMH_CR_DT(new Date());
		/*TODO: change hard-coded user name*/
		pm_il_doc_med_hist.setDMH_CR_UID(new CommonUtils().getControlBean().getM_USER_ID());
		/*TODO: do l_duplicate check*/
		
	}
	
	public void PILM013_APAC_PM_IL_DOC_MED_HIST_PRE_UPDATE(PM_IL_DOC_MED_HIST_ACTION pm_il_doc_med_hist_action){
//    	L_DUP_SRLNO.L_DUP_SRLNO();
		PM_IL_DOC_MED_HIST pm_il_doc_med_hist;
		int currentRow;
		currentRow=pm_il_doc_med_hist_action.getDataTable().getRowIndex();
		pm_il_doc_med_hist=pm_il_doc_med_hist_action.getDataTableList().get(currentRow);
		/*TODO: Change the hardcoded user id*/
		pm_il_doc_med_hist.setDMH_UPD_DT(new Date());
		pm_il_doc_med_hist.setDMH_CR_UID(new CommonUtils().getControlBean().getM_USER_ID());
		/*TODO: do l_duplicate check*/
	}

	public void validateDMH_SR_NO(PM_IL_DOC_MED_HIST pm_il_doc_med_hist_bean) throws Exception { 
		try {
			if(pm_il_doc_med_hist_bean.getDMH_SR_NO() <= 0){
				throw new Exception("Serial No:Serial Number Should be greater than zero");
				
		}
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		// TODO Auto-generated method stub
		
	}
}
