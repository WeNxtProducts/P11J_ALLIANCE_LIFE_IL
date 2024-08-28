package com.iii.pel.forms.PILP_STP;

public class PILP_STP_COMPOSITE_ACTION {
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private VIEWLOG_ACTION VIEWLOG_ACTION_BEAN;
	private VIEW_PROCESSED_ACTION VIEW_PROCESSED_ACTION_BEAN;

	public VIEW_PROCESSED_ACTION getVIEW_PROCESSED_ACTION_BEAN() {
		return VIEW_PROCESSED_ACTION_BEAN;
	}

	public void setVIEW_PROCESSED_ACTION_BEAN(
			VIEW_PROCESSED_ACTION view_processed_action_bean) {
		VIEW_PROCESSED_ACTION_BEAN = view_processed_action_bean;
	}

	public PILP_STP_COMPOSITE_ACTION() {
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		VIEWLOG_ACTION_BEAN = new VIEWLOG_ACTION();
		VIEW_PROCESSED_ACTION_BEAN = new VIEW_PROCESSED_ACTION();

		DUMMY_ACTION_BEAN.compositeAction = this;
		VIEWLOG_ACTION_BEAN.compositeAction = this;
		VIEW_PROCESSED_ACTION_BEAN.compositeAction = this;
	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

	public VIEWLOG_ACTION getVIEWLOG_ACTION_BEAN() {
		return VIEWLOG_ACTION_BEAN;
	}

	public void setVIEWLOG_ACTION_BEAN(VIEWLOG_ACTION viewlog_action_bean) {
		VIEWLOG_ACTION_BEAN = viewlog_action_bean;
	}

}
