package com.iii.pel.forms.PILM035_APAC;

import javax.faces.component.html.HtmlInputText;

import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PM_IL_PROD_COMPOSITE_ACTION {

	private TabbedBar tabbedBar;

	private PM_IL_PRODUCT_ACTION PM_IL_PRODUCT_ACTION;

	private PM_IL_PROD_APPL_COVER_ACTION PM_IL_PROD_APPL_COVER_ACTION_BEAN;

	private PM_IL_PROD_APPL_COVER_1_ACTION PM_IL_PROD_APPL_COVER_1_ACTION_BEAN;

	private PM_IL_PROD_APPL_COND_ACTION PM_IL_PROD_APPL_COND_ACTION_BEAN;

	private PM_IL_PROD_APPL_PLANS_ACTION PM_IL_PROD_APPL_PLANS_ACTION;

	private PM_IL_PROD_APPL_FUND_ACTION PM_IL_PROD_APPL_FUND_ACTION_BEAN;

	private PM_IL_PROD_APPL_FUND_1_ACTION PM_IL_PROD_APPL_FUND_1_ACTION_BEAN;

	private PM_IL_PROD_PREM_LIMIT_ACTION PM_IL_PROD_PREM_LIMIT_ACTION_BEAN;

	private PM_IL_SA_INST_PYMT1_ACTION PM_IL_SA_INST_PYMT1_ACTION_BEAN;

	private PM_IL_SA_INST_PYMT_ACTION PM_IL_SA_INST_PYMT_ACTION_BEAN;

	private PM_IL_PROD_APPL_BONUS_ACTION PM_IL_PROD_APPL_BONUS_ACTION_BEAN;

	private PM_IL_TOP_UP_CHARGE_ACTION PM_IL_TOP_UP_CHARGE_ACTION_BEAN;

	private PM_IL_PROD_TOPUP_PARAM_ACTION PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN;

	private PM_IL_PROD_WD_PARAM_HDR_ACTION PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN;

	private PM_IL_PROD_WD_PARAM_DTL_ACTION PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN;

	private PM_IL_PROD_APPL_LOAD_TARIFF_ACTION PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN;

	public PM_IL_PROD_COMPOSITE_ACTION() throws Exception {

		PM_IL_PRODUCT_ACTION = new PM_IL_PRODUCT_ACTION();

		PM_IL_PROD_APPL_COVER_ACTION_BEAN = new PM_IL_PROD_APPL_COVER_ACTION();

		PM_IL_PROD_APPL_COVER_1_ACTION_BEAN = new PM_IL_PROD_APPL_COVER_1_ACTION();

		PM_IL_PROD_APPL_COND_ACTION_BEAN = new PM_IL_PROD_APPL_COND_ACTION();

		PM_IL_PROD_APPL_PLANS_ACTION = new PM_IL_PROD_APPL_PLANS_ACTION();

		PM_IL_PROD_APPL_FUND_ACTION_BEAN = new PM_IL_PROD_APPL_FUND_ACTION();

		PM_IL_PROD_PREM_LIMIT_ACTION_BEAN = new PM_IL_PROD_PREM_LIMIT_ACTION();

		PM_IL_PROD_APPL_FUND_1_ACTION_BEAN = new PM_IL_PROD_APPL_FUND_1_ACTION();

		PM_IL_SA_INST_PYMT1_ACTION_BEAN = new PM_IL_SA_INST_PYMT1_ACTION();

		PM_IL_SA_INST_PYMT_ACTION_BEAN = new PM_IL_SA_INST_PYMT_ACTION();

		PM_IL_PROD_APPL_BONUS_ACTION_BEAN = new PM_IL_PROD_APPL_BONUS_ACTION();

		PM_IL_TOP_UP_CHARGE_ACTION_BEAN = new PM_IL_TOP_UP_CHARGE_ACTION();

		PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN = new PM_IL_PROD_TOPUP_PARAM_ACTION();

		PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN = new PM_IL_PROD_WD_PARAM_HDR_ACTION();

		PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN = new PM_IL_PROD_WD_PARAM_DTL_ACTION();

		PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN = new PM_IL_PROD_APPL_LOAD_TARIFF_ACTION();

		tabbedBar = new TabbedBar();
		tabbedBar.addTab(1, "pilm035_apac_mainForm", Messages.getString(
				"messageProperties_PILM035_APAC",
				"PILM035_APAC$PM_IL_PRODUCT$TAB$HEADER$caption"), false);
		tabbedBar.addTab(2, "#{PM_IL_PROD_COMPOSITE_ACTION.moreInfo1}",
				Messages.getString("messageProperties_PILM035_APAC",
						"PILM035_APAC$PM_IL_PRODUCT$TAB$MOREINFO1$caption"),
				false);
		tabbedBar.addTab(3, "pilm035_apac_moreinfo2", Messages.getString(
				"messageProperties_PILM035_APAC",
				"PILM035_APAC$PM_IL_PRODUCT$TAB$MOREINFO2$caption"), false);
		tabbedBar
				.addTab(
						4,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PRODUCT_ACTION.openMoreInfo3}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$MOREINFO3$caption"),
						false);
		tabbedBar
				.addTab(
						5,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN.prepareCoverGroupDetails}",
						Messages.getString("messageProperties_PILM035_APAC",
								"PILM035_APAC$PM_IL_PRODUCT$TAB$COVER$caption"),
						false);
		// tabbedBar.addTab(5,"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_COVER_ACTION_BEAN.callAppl_Cover}","Applicable
		// Covers",false);
		tabbedBar
				.addTab(
						6,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_COND_ACTION_BEAN.callAppl_CondList}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$CONDITION$caption"),
						false);
		tabbedBar
				.addTab(
						7,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_SA_INST_PYMT_ACTION_BEAN.prepareSA_Inst_PymtList}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$SA_PAY_MULTIPLE$caption"),
						false);
		tabbedBar
				.addTab(
						8,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_SA_INST_PYMT1_ACTION_BEAN.prepareSA_MaturityList}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$SA_PAY_MATURITY$caption"),
						false);
		tabbedBar
				.addTab(
						9,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_BONUS_ACTION_BEAN.callAppl_plan_bonus}",
						Messages.getString("messageProperties_PILM035_APAC",
								"PILM035_APAC$PM_IL_PRODUCT$TAB$BONUS$caption"),
						false);
		tabbedBar
				.addTab(
						10,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN.callLoadTariff}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$DISC_LOAD_TARIFF$caption"),
						false);
		tabbedBar
				.addTab(
						11,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_PREM_LIMIT_ACTION_BEAN.preparePremLimitList}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$PREM_LIMIT$caption"),
						false);
		tabbedBar
				.addTab(
						12,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_FUND_ACTION_BEAN.displayDetails}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$APP_FUND$caption"),
						false);
		tabbedBar
				.addTab(
						13,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_APPL_FUND_1_ACTION_BEAN.displayDetails}",
						Messages
								.getString("messageProperties_PILM035_APAC",
										"PILM035_APAC$PM_IL_PRODUCT$TAB$APP_FUND1$caption"),
						false);
		tabbedBar
				.addTab(
						14,
						"#{PM_IL_PROD_COMPOSITE_ACTION.PM_IL_PROD_SURR_PAID_FACTOR_ACTION_BEAN.callSurr_factor}",
						Messages.getString("messageProperties_PILM035_APAC",
								"PILM035_APAC$PM_IL_PRODUCT$TAB$SAF$caption"),
						false);
	}

	public void setPM_IL_PROD_APPL_COVER_ACTION(
			PM_IL_PROD_APPL_COVER_ACTION PM_IL_PROD_APPL_COVER_ACTION) {
		PM_IL_PROD_APPL_COVER_ACTION = PM_IL_PROD_APPL_COVER_ACTION;
	}

	public PM_IL_PRODUCT_ACTION getPM_IL_PRODUCT_ACTION() {
		return PM_IL_PRODUCT_ACTION;
	}

	public void setPM_IL_PRODUCT_ACTION(
			PM_IL_PRODUCT_ACTION pm_il_product_action) {
		PM_IL_PRODUCT_ACTION = pm_il_product_action;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public PM_IL_PROD_APPL_COVER_ACTION getPM_IL_PROD_APPL_COVER_ACTION_BEAN() {
		return PM_IL_PROD_APPL_COVER_ACTION_BEAN;
	}

	public PM_IL_PROD_APPL_COVER_1_ACTION getPM_IL_PROD_APPL_COVER_1_ACTION_BEAN() {
		return PM_IL_PROD_APPL_COVER_1_ACTION_BEAN;
	}

	public PM_IL_PROD_APPL_COND_ACTION getPM_IL_PROD_APPL_COND_ACTION_BEAN() {
		return PM_IL_PROD_APPL_COND_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_COVER_ACTION_BEAN(
			PM_IL_PROD_APPL_COVER_ACTION pm_il_prod_appl_cover_action_bean) {
		PM_IL_PROD_APPL_COVER_ACTION_BEAN = pm_il_prod_appl_cover_action_bean;
	}

	public void setPM_IL_PROD_APPL_COVER_1_ACTION_BEAN(
			PM_IL_PROD_APPL_COVER_1_ACTION pm_il_prod_appl_cover_1_action_bean) {
		PM_IL_PROD_APPL_COVER_1_ACTION_BEAN = pm_il_prod_appl_cover_1_action_bean;
	}

	public void setPM_IL_PROD_APPL_COND_ACTION_BEAN(
			PM_IL_PROD_APPL_COND_ACTION pm_il_prod_appl_cond_action_bean) {
		PM_IL_PROD_APPL_COND_ACTION_BEAN = pm_il_prod_appl_cond_action_bean;
	}

	public PM_IL_PROD_APPL_PLANS_ACTION getPM_IL_PROD_APPL_PLANS_ACTION() {
		return PM_IL_PROD_APPL_PLANS_ACTION;
	}

	public void setPM_IL_PROD_APPL_PLANS_ACTION(
			PM_IL_PROD_APPL_PLANS_ACTION pm_il_prod_appl_plans_action) {
		PM_IL_PROD_APPL_PLANS_ACTION = pm_il_prod_appl_plans_action;
	}

	public PM_IL_PROD_APPL_FUND_ACTION getPM_IL_PROD_APPL_FUND_ACTION_BEAN() {
		return PM_IL_PROD_APPL_FUND_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_FUND_ACTION_BEAN(
			PM_IL_PROD_APPL_FUND_ACTION pm_il_prod_appl_fund_action_bean) {
		PM_IL_PROD_APPL_FUND_ACTION_BEAN = pm_il_prod_appl_fund_action_bean;
	}

	public PM_IL_PROD_PREM_LIMIT_ACTION getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN() {
		return PM_IL_PROD_PREM_LIMIT_ACTION_BEAN;
	}

	public void setPM_IL_PROD_PREM_LIMIT_ACTION_BEAN(
			PM_IL_PROD_PREM_LIMIT_ACTION pm_il_prod_prem_limit_action_bean) {
		PM_IL_PROD_PREM_LIMIT_ACTION_BEAN = pm_il_prod_prem_limit_action_bean;
	}

	public PM_IL_PROD_APPL_FUND_1_ACTION getPM_IL_PROD_APPL_FUND_1_ACTION_BEAN() {
		return PM_IL_PROD_APPL_FUND_1_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_FUND_1_ACTION_BEAN(
			PM_IL_PROD_APPL_FUND_1_ACTION pm_il_prod_appl_fund_1_action_bean) {
		PM_IL_PROD_APPL_FUND_1_ACTION_BEAN = pm_il_prod_appl_fund_1_action_bean;
	}

	public PM_IL_SA_INST_PYMT1_ACTION getPM_IL_SA_INST_PYMT1_ACTION_BEAN() {
		return PM_IL_SA_INST_PYMT1_ACTION_BEAN;
	}

	public PM_IL_SA_INST_PYMT_ACTION getPM_IL_SA_INST_PYMT_ACTION_BEAN() {
		return PM_IL_SA_INST_PYMT_ACTION_BEAN;
	}

	public void setPM_IL_SA_INST_PYMT1_ACTION_BEAN(
			PM_IL_SA_INST_PYMT1_ACTION pm_il_sa_inst_pymt1_action_bean) {
		PM_IL_SA_INST_PYMT1_ACTION_BEAN = pm_il_sa_inst_pymt1_action_bean;
	}

	public void setPM_IL_SA_INST_PYMT_ACTION_BEAN(
			PM_IL_SA_INST_PYMT_ACTION pm_il_sa_inst_pymt_action_bean) {
		PM_IL_SA_INST_PYMT_ACTION_BEAN = pm_il_sa_inst_pymt_action_bean;
	}

	public PM_IL_PROD_APPL_BONUS_ACTION getPM_IL_PROD_APPL_BONUS_ACTION_BEAN() {
		return PM_IL_PROD_APPL_BONUS_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_BONUS_ACTION_BEAN(
			PM_IL_PROD_APPL_BONUS_ACTION pm_il_prod_appl_bonus_action_bean) {
		PM_IL_PROD_APPL_BONUS_ACTION_BEAN = pm_il_prod_appl_bonus_action_bean;
	}

	public PM_IL_TOP_UP_CHARGE_ACTION getPM_IL_TOP_UP_CHARGE_ACTION_BEAN() {
		return PM_IL_TOP_UP_CHARGE_ACTION_BEAN;
	}

	public void setPM_IL_TOP_UP_CHARGE_ACTION_BEAN(
			PM_IL_TOP_UP_CHARGE_ACTION pm_il_top_up_charge_action_bean) {
		PM_IL_TOP_UP_CHARGE_ACTION_BEAN = pm_il_top_up_charge_action_bean;
	}

	public PM_IL_PROD_TOPUP_PARAM_ACTION getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN() {
		return PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN;
	}

	public void setPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN(
			PM_IL_PROD_TOPUP_PARAM_ACTION pm_il_prod_topup_param_action_bean) {
		PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN = pm_il_prod_topup_param_action_bean;
	}

	public PM_IL_PROD_WD_PARAM_HDR_ACTION getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN() {
		return PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN;
	}

	public void setPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN(
			PM_IL_PROD_WD_PARAM_HDR_ACTION pm_il_prod_wd_param_hdr_action_bean) {
		PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN = pm_il_prod_wd_param_hdr_action_bean;
	}

	public PM_IL_PROD_WD_PARAM_DTL_ACTION getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN() {
		return PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN;
	}

	public void setPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN(
			PM_IL_PROD_WD_PARAM_DTL_ACTION pm_il_prod_wd_param_dtl_action_bean) {
		PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN = pm_il_prod_wd_param_dtl_action_bean;
	}

	public PM_IL_PROD_APPL_LOAD_TARIFF_ACTION getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN() {
		return PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN(
			PM_IL_PROD_APPL_LOAD_TARIFF_ACTION pm_il_prod_appl_load_tariff_action_bean) {
		PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN = pm_il_prod_appl_load_tariff_action_bean;
	}

	public String moreInfo1() {
		if ("N".equalsIgnoreCase(getPM_IL_PRODUCT_ACTION()
				.getPM_IL_PRODUCT_BEAN().getPROD_ROUND_OPTION())) {
			HtmlInputText ROUND_VALUE = new HtmlInputText();
			ROUND_VALUE.setDisabled(true);
			getPM_IL_PRODUCT_ACTION().setCOMP_PROD_ROUND_VALUE(ROUND_VALUE);
		}
		return "pilm035_apac_moreinfo1";
	}

}
