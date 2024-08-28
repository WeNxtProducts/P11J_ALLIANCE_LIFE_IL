package com.iii.pel.forms.PILM106;


import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;

public class PILM106_EMAIL_COMPOSITE_ACTION extends CommonUtils {
/*	Bean for Action class*/
	private PILM106_EMAIL_ACTION EMAIL_ACTION_BEAN;				

	public PILM106_EMAIL_COMPOSITE_ACTION()
	{
		
		//EMAIL_ACTION_BEAN = (PILM106_EMAIL_ACTION) new CommonUtils().getMappedBeanFromSession("PILM106_EMAIL_ACTION");
		EMAIL_ACTION_BEAN	=new PILM106_EMAIL_ACTION();
		EMAIL_ACTION_BEAN.compositeAction=this;
		 
	}
	public PILM106_EMAIL_ACTION getEMAIL_ACTION_BEAN() {
		return EMAIL_ACTION_BEAN;
	}

	public void setEMAIL_ACTION_BEAN(PILM106_EMAIL_ACTION eMAIL_ACTION_BEAN) {
		EMAIL_ACTION_BEAN = eMAIL_ACTION_BEAN;
	}

	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	 

	/*public String updateButtonAction(String rowId) {
		PILM106_EMAIL_ACTION action = new PILM106_EMAIL_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM106_EMAIL_ACTION", action);
		//compositeAction.
		getEMAIL_ACTION_BEAN().getEmailBean().setROWID(rowId);
		System.out.println("hellow"+getEMAIL_ACTION_BEAN().getEmailBean().getROWID());
		outcome = "EmailTemplate";
		return outcome;

	} 

	public String insertButtonAction() {
		PILM106_EMAIL_ACTION action = new PILM106_EMAIL_ACTION();
		String outcome = null;
		CommonUtils
				.setGlobalObject("PILM106_EMAIL_ACTION", action);

		outcome = "EmailTemplate";

		return outcome;
	
	}*/
	
	


}
