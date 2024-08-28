package com.iii.pel.forms.PILM054_APAC;

public class PILM054_APAC_COMPOSITE_ACTION {

	private SearchAction searchBean;
	private PM_IL_RI_ACCOUNT_SETUP_ACTION actionBean;
	
	private PM_IL_RI_ACCOUNT_SETUP_ACTION PM_IL_RI_ACCOUNT_SETUP_ACTION_BEAN = null;
	private DUMMY_ACTION DUMMY_ACTION_BEAN = null;
	
	public PILM054_APAC_COMPOSITE_ACTION() {
		searchBean = new  SearchAction();
		actionBean = new PM_IL_RI_ACCOUNT_SETUP_ACTION();
		actionBean.compositeAction = this;
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		
	}

	public SearchAction getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(SearchAction searchBean) {
		this.searchBean = searchBean;
	}

	public PM_IL_RI_ACCOUNT_SETUP_ACTION getActionBean() {
		return actionBean;
	}

	public void setActionBean(PM_IL_RI_ACCOUNT_SETUP_ACTION actionBean) {
		this.actionBean = actionBean;
	}

	/**
	 * @return the dUMMY_ACTION_BEAN
	 */
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	/**
	 * @param dummy_action_bean the dUMMY_ACTION_BEAN to set
	 */
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	

}
