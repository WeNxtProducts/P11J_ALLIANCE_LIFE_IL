package com.iii.pel.forms.PILQ015;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_COMPOSITE {

	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION;

	private PS_IL_DRCR_ACTION PS_IL_DRCR_ACTION;

	private ControlBean controlBean;

	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION() {
		return PT_IL_POLICY_ACTION;
	}

	public void setPT_IL_POLICY_ACTION(PT_IL_POLICY_ACTION pt_il_policy_action) {
		PT_IL_POLICY_ACTION = pt_il_policy_action;
	}

	public PS_IL_DRCR_ACTION getPS_IL_DRCR_ACTION() {
		return PS_IL_DRCR_ACTION;
	}

	public void setPS_IL_DRCR_ACTION(PS_IL_DRCR_ACTION ps_il_drcr_action) {
		PS_IL_DRCR_ACTION = ps_il_drcr_action;
	}

	public PT_IL_POLICY_COMPOSITE() {
		controlBean = (ControlBean) CommonUtils.getControlBean();
		PT_IL_POLICY_ACTION = new PT_IL_POLICY_ACTION();
		PS_IL_DRCR_ACTION = new PS_IL_DRCR_ACTION();
		CommonUtils.setGlobalObject("PT_IL_POLICY_COMPOSITE", this);
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

}
