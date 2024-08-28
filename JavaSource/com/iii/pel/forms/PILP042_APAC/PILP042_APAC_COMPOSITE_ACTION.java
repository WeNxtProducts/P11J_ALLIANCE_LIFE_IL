package com.iii.pel.forms.PILP042_APAC;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PILP042_APAC_COMPOSITE_ACTION {

	private PT_IL_FUND_TRAN_HDR_ACTION PT_IL_FUND_TRAN_HDR_ACTION_BEAN;

	private PT_IL_FUND_TRAN_DTL_1_ACTION PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN;

	private PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION;

	private PT_IL_TRAN_STATUS_ACTION PT_IL_TRAN_STATUS_ACTION;

	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	
	
	private ControlBean controlBean;

	public PT_IL_FUND_TRAN_HDR_ACTION getPT_IL_FUND_TRAN_HDR_ACTION_BEAN() {
		return PT_IL_FUND_TRAN_HDR_ACTION_BEAN;
	}

	public void setPT_IL_FUND_TRAN_HDR_ACTION_BEAN(
			PT_IL_FUND_TRAN_HDR_ACTION pt_il_fund_tran_hdr_action_bean) {
		PT_IL_FUND_TRAN_HDR_ACTION_BEAN = pt_il_fund_tran_hdr_action_bean;
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public PILP042_APAC_COMPOSITE_ACTION() {
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
		PT_IL_FUND_TRAN_HDR_ACTION_BEAN = new PT_IL_FUND_TRAN_HDR_ACTION();
		PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN = new PT_IL_FUND_TRAN_DTL_1_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PT_IL_FUND_TRAN_DTL_ACTION = new PT_IL_FUND_TRAN_DTL_ACTION();
		PT_IL_TRAN_STATUS_ACTION = new PT_IL_TRAN_STATUS_ACTION();
		CommonUtils.setGlobalObject("PILP042_APAC_COMPOSITE_ACTION", this);
		PT_IL_FUND_TRAN_HDR_ACTION_BEAN.compositeAction = this;
		PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN.compositeAction = this;
		PT_IL_FUND_TRAN_DTL_ACTION.compositeAction = this;
	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

	public PT_IL_FUND_TRAN_DTL_1_ACTION getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN() {
		return PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN;
	}

	public void setPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN(
			PT_IL_FUND_TRAN_DTL_1_ACTION pt_il_fund_tran_dtl_1_action_bean) {
		PT_IL_FUND_TRAN_DTL_1_ACTION_BEAN = pt_il_fund_tran_dtl_1_action_bean;
	}

	public PT_IL_FUND_TRAN_DTL_ACTION getPT_IL_FUND_TRAN_DTL_ACTION() {
		return PT_IL_FUND_TRAN_DTL_ACTION;
	}

	public void setPT_IL_FUND_TRAN_DTL_ACTION(
			PT_IL_FUND_TRAN_DTL_ACTION pt_il_fund_tran_dtl_action) {
		PT_IL_FUND_TRAN_DTL_ACTION = pt_il_fund_tran_dtl_action;
	}

	public PT_IL_TRAN_STATUS_ACTION getPT_IL_TRAN_STATUS_ACTION() {
		return PT_IL_TRAN_STATUS_ACTION;
	}

	public void setPT_IL_TRAN_STATUS_ACTION(
			PT_IL_TRAN_STATUS_ACTION pt_il_tran_status_action) {
		PT_IL_TRAN_STATUS_ACTION = pt_il_tran_status_action;
	}


}
