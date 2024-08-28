package com.iii.pel.forms.PILM036_APAC;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;


public class PILM036_APAC_COMPOSITE_ACTION {

	private PM_IL_SUB_PLAN_ACTION PM_IL_SUB_PLAN_ACTION_BEAN ;

	private PM_IL_SUB_PLAN_GROUP_ACTION PM_IL_SUB_PLAN_GROUP_ACTION_BEAN ;
	
	

	public PM_IL_SUB_PLAN_GROUP_ACTION getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN() {
		return PM_IL_SUB_PLAN_GROUP_ACTION_BEAN;
	}

	public void setPM_IL_SUB_PLAN_GROUP_ACTION_BEAN(
			PM_IL_SUB_PLAN_GROUP_ACTION pM_IL_SUB_PLAN_GROUP_ACTION_BEAN) {
		PM_IL_SUB_PLAN_GROUP_ACTION_BEAN = pM_IL_SUB_PLAN_GROUP_ACTION_BEAN;
	}
	
	
	public PM_IL_SUB_PLAN_ACTION getPM_IL_SUB_PLAN_ACTION_BEAN() {
		return PM_IL_SUB_PLAN_ACTION_BEAN;
	}

	public void setPM_IL_SUB_PLAN_ACTION_BEAN(
			PM_IL_SUB_PLAN_ACTION pM_IL_SUB_PLAN_ACTION_BEAN) {
		PM_IL_SUB_PLAN_ACTION_BEAN = pM_IL_SUB_PLAN_ACTION_BEAN;
	}


	private UIWizard wizard=null;
	
	
	
	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		this.wizard = wizard;
	}

	public PILM036_APAC_COMPOSITE_ACTION(){
		
		PM_IL_SUB_PLAN_ACTION_BEAN = new PM_IL_SUB_PLAN_ACTION();
		
		PM_IL_SUB_PLAN_ACTION_BEAN.compositeAction = this;
		
		PM_IL_SUB_PLAN_GROUP_ACTION_BEAN = new PM_IL_SUB_PLAN_GROUP_ACTION();
		
		PM_IL_SUB_PLAN_GROUP_ACTION_BEAN.compositeAction = this;
	}
	
	public String navigationEnabled() {
		//setImmediate(true);
		getPM_IL_SUB_PLAN_ACTION_BEAN().getErrorMap().clear();
		getWizard().setImmediate("true");
		return "";

	}
}
