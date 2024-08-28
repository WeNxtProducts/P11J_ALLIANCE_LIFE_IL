package com.iii.pel.forms.PQ123;


public class PV_POL_QUERY_COMPOSITE {

	private PV_POL_QUERY_ACTION PV_POL_QUERY_ACTION;

	private PV_CVR_QUERY_ACTION PV_CVR_QUERY_ACTION;

	private PV_CLM_QUERY_ACTION PV_CLM_QUERY_ACTION;

	private PV_FAC_IN_QUERY_ACTION PV_FAC_IN_QUERY_ACTION;

	private PM_CUSTOMER_ACTION PM_CUSTOMER_ACTION;

	private FAC_CO_INS_ACTION FAC_CO_INS_ACTION;

	private PREMIUM_ACTION PREMIUM_ACTION;
	
	private DUMMY_ACTION DUMMY_ACTION;

	public DUMMY_ACTION getDUMMY_ACTION() {
		return DUMMY_ACTION;
	}

	public void setDUMMY_ACTION(DUMMY_ACTION dummy_action) {
		DUMMY_ACTION = dummy_action;
	}

	public PV_POL_QUERY_COMPOSITE() {
		PV_POL_QUERY_ACTION = new PV_POL_QUERY_ACTION();
		PV_CVR_QUERY_ACTION = new PV_CVR_QUERY_ACTION();
		PV_CLM_QUERY_ACTION = new PV_CLM_QUERY_ACTION();
		PV_FAC_IN_QUERY_ACTION = new PV_FAC_IN_QUERY_ACTION();
		PM_CUSTOMER_ACTION = new PM_CUSTOMER_ACTION();
		FAC_CO_INS_ACTION = new FAC_CO_INS_ACTION();
		PREMIUM_ACTION = new PREMIUM_ACTION();
		DUMMY_ACTION = new DUMMY_ACTION();
//		CommonUtils.setGlobalObject("PV_POL_QUERY_COMPOSITE", this);
		
		PV_POL_QUERY_ACTION.compositeAction = this;
		PV_CVR_QUERY_ACTION.compositeAction = this;
		PV_CLM_QUERY_ACTION.compositeAction = this;
		PV_FAC_IN_QUERY_ACTION.compositeAction = this;
		PM_CUSTOMER_ACTION.compositeAction = this;
		FAC_CO_INS_ACTION.compositeAction = this;
		PREMIUM_ACTION.compositeAction = this;
		DUMMY_ACTION.compositeAction = this;

	}

	public PV_POL_QUERY_ACTION getPV_POL_QUERY_ACTION() {
		return PV_POL_QUERY_ACTION;
	}

	public void setPV_POL_QUERY_ACTION(PV_POL_QUERY_ACTION pv_pol_query_action) {
		PV_POL_QUERY_ACTION = pv_pol_query_action;
	}

	public PV_CVR_QUERY_ACTION getPV_CVR_QUERY_ACTION() {
		return PV_CVR_QUERY_ACTION;
	}

	public void setPV_CVR_QUERY_ACTION(PV_CVR_QUERY_ACTION pv_cvr_query_action) {
		PV_CVR_QUERY_ACTION = pv_cvr_query_action;
	}

	public PV_CLM_QUERY_ACTION getPV_CLM_QUERY_ACTION() {
		return PV_CLM_QUERY_ACTION;
	}

	public void setPV_CLM_QUERY_ACTION(PV_CLM_QUERY_ACTION pv_clm_query_action) {
		PV_CLM_QUERY_ACTION = pv_clm_query_action;
	}

	public PV_FAC_IN_QUERY_ACTION getPV_FAC_IN_QUERY_ACTION() {
		return PV_FAC_IN_QUERY_ACTION;
	}

	public void setPV_FAC_IN_QUERY_ACTION(
			PV_FAC_IN_QUERY_ACTION pv_fac_in_query_action) {
		PV_FAC_IN_QUERY_ACTION = pv_fac_in_query_action;
	}

	public PM_CUSTOMER_ACTION getPM_CUSTOMER_ACTION() {
		return PM_CUSTOMER_ACTION;
	}

	public void setPM_CUSTOMER_ACTION(PM_CUSTOMER_ACTION pm_customer_action) {
		PM_CUSTOMER_ACTION = pm_customer_action;
	}

	public FAC_CO_INS_ACTION getFAC_CO_INS_ACTION() {
		return FAC_CO_INS_ACTION;
	}

	public void setFAC_CO_INS_ACTION(FAC_CO_INS_ACTION fac_co_ins_action) {
		FAC_CO_INS_ACTION = fac_co_ins_action;
	}

	public PREMIUM_ACTION getPREMIUM_ACTION() {
		return PREMIUM_ACTION;
	}

	public void setPREMIUM_ACTION(PREMIUM_ACTION premium_action) {
		PREMIUM_ACTION = premium_action;
	}

}
