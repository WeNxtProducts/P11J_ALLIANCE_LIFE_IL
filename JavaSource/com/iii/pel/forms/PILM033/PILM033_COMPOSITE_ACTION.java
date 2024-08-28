package com.iii.pel.forms.PILM033;

public class PILM033_COMPOSITE_ACTION {
	private PM_IL_PREM_INTEREST_ACTION PM_IL_PREM_INTEREST_ACTION_BEAN;

	public void setPM_IL_PREM_INTEREST_ACTION_BEAN(
			PM_IL_PREM_INTEREST_ACTION PM_IL_PREM_INTEREST_ACTION_BEAN) {
		this.PM_IL_PREM_INTEREST_ACTION_BEAN = PM_IL_PREM_INTEREST_ACTION_BEAN;

	}

	public PM_IL_PREM_INTEREST_ACTION getPM_IL_PREM_INTEREST_ACTION_BEAN() {
		return this.PM_IL_PREM_INTEREST_ACTION_BEAN;

	}

	public PILM033_COMPOSITE_ACTION() {
		PM_IL_PREM_INTEREST_ACTION_BEAN = new PM_IL_PREM_INTEREST_ACTION();
		PM_IL_PREM_INTEREST_ACTION_BEAN.compositeAction = this;

	}
	public String navigationEnabled() {
		setImmediate(true);
	    //	getWizard().setImmediate("true");
		return "";

	    }

	private void setImmediate(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
