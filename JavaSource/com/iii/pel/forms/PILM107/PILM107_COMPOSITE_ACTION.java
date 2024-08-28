package com.iii.pel.forms.PILM107;


public class PILM107_COMPOSITE_ACTION {

	private PM_BANK_ACTION PM_BANK_ACTION_BEAN;	
	
	
	public PM_BANK_ACTION getPM_BANK_ACTION_BEAN() {
		return PM_BANK_ACTION_BEAN;
	}


	public void setPM_BANK_ACTION_BEAN(PM_BANK_ACTION pM_BANK_ACTION_BEAN) {
		PM_BANK_ACTION_BEAN = pM_BANK_ACTION_BEAN;
	}


	public PILM107_COMPOSITE_ACTION()
	{
		System.out.println("Welcome to PILM107_COMPOSITE_ACTION");
		PM_BANK_ACTION_BEAN=new PM_BANK_ACTION();
		PM_BANK_ACTION_BEAN.compositeAction=this;
		/*Added by ganesh on 30-10-2017 for bank detail issue*/
		PM_BANK_BRANCH_ACTION_BEAN = new PM_BANK_BRANCH_ACTION();
		PM_BANK_BRANCH_ACTION_BEAN.compositeAction = this;
		/*end*/
	}
	
	/*Added by ganesh on 30-10-2017 for bank detail issue*/
	private PM_BANK_BRANCH_ACTION PM_BANK_BRANCH_ACTION_BEAN;


	public PM_BANK_BRANCH_ACTION getPM_BANK_BRANCH_ACTION_BEAN() {
		return PM_BANK_BRANCH_ACTION_BEAN;
	}


	public void setPM_BANK_BRANCH_ACTION_BEAN(
			PM_BANK_BRANCH_ACTION pM_BANK_BRANCH_ACTION_BEAN) {
		PM_BANK_BRANCH_ACTION_BEAN = pM_BANK_BRANCH_ACTION_BEAN;
	}
	/*end*/
	
	
}
