package com.iii.pel.forms.PILT027;

import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILT027_COMPOSITE_ACTION {

	private PT_AGENT_COMM_VALUES_ACTION PT_AGENT_COMM_VALUES_ACTION_BEAN;

	private PT_IL_DEPOSIT_CHARGE_ACTION PT_IL_DEPOSIT_CHARGE_ACTION_BEAN;

	private PT_IL_TOP_UP_1_ACTION PT_IL_TOP_UP_1_ACTION_BEAN;

	private PT_IL_TOP_UP_2_ACTION PT_IL_TOP_UP_2_ACTION_BEAN;

	private PT_IL_TOP_UP_ACTION PT_IL_TOP_UP_ACTION_BEAN;

	private PT_IL_FUND_DETAIL_ACTION PT_IL_FUND_DETAIL_ACTION_BEAN;
	
	private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN;

	private TabbedBar tabbedBar;

	public PILT027_COMPOSITE_ACTION() {
		this.PT_AGENT_COMM_VALUES_ACTION_BEAN = new PT_AGENT_COMM_VALUES_ACTION();
		/*Added by saritha on 26-07-2017 for ssp call id ZBILQC-1733098*/
		this.PT_IL_DEPOSIT_CHARGE_ACTION_BEAN = new PT_IL_DEPOSIT_CHARGE_ACTION();
		/*End*/
		this.PT_IL_TOP_UP_1_ACTION_BEAN = new PT_IL_TOP_UP_1_ACTION();
		this.PT_IL_TOP_UP_2_ACTION_BEAN = new PT_IL_TOP_UP_2_ACTION();
		this.PT_IL_TOP_UP_ACTION_BEAN = new PT_IL_TOP_UP_ACTION();
		this.PT_IL_FUND_DETAIL_ACTION_BEAN = new PT_IL_FUND_DETAIL_ACTION();
		this.PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		
		this.tabbedBar = new TabbedBar();
		PT_IL_TOP_UP_ACTION_BEAN.pilt027_composite_action = this;
		/*Added by saritha on 26-07-2017 for ssp call id ZBILQC-1733098*/
		PT_IL_DEPOSIT_CHARGE_ACTION_BEAN.composite_action = this;
		/*End*/
		PT_IL_FUND_DETAIL_ACTION_BEAN.composite_action = this;
		PT_IL_PYMT_DTLS_ACTION_BEAN.pilt027_composite_action = this;
		try {
			this.tabbedBar.addTab(1,
					"#{PILT027_COMPOSITE_ACTION.goToPT_IL_TOP_UP}",
					"Transaction Screen", false);
			/*this.tabbedBar.addTab(2,
					"#{PILT027_COMPOSITE_ACTION.goToPT_IL_DEPOSIT_CHARGE}",
					"Charges", false);*/
			this.tabbedBar.addTab(3,
					"#{PILT027_COMPOSITE_ACTION.goToPT_IL_TOP_UP_1}",
					"History", false);
			// this.tabbedBar.addTab(4,
			// "#{PILT027_COMPOSITE_ACTION.goToPM_AGENT_CONTEST_AWARD}",
			// "PM_AGENT_CONTEST_AWARD", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PT_AGENT_COMM_VALUES_ACTION getPT_AGENT_COMM_VALUES_ACTION_BEAN() {
		return PT_AGENT_COMM_VALUES_ACTION_BEAN;
	}

	public void setPT_AGENT_COMM_VALUES_ACTION_BEAN(
			PT_AGENT_COMM_VALUES_ACTION pt_agent_comm_values_action_bean) {
		PT_AGENT_COMM_VALUES_ACTION_BEAN = pt_agent_comm_values_action_bean;
	}

	public PT_IL_DEPOSIT_CHARGE_ACTION getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN() {
		return PT_IL_DEPOSIT_CHARGE_ACTION_BEAN;
	}

	public void setPT_IL_DEPOSIT_CHARGE_ACTION_BEAN(
			PT_IL_DEPOSIT_CHARGE_ACTION pt_il_deposit_charge_action_bean) {
		PT_IL_DEPOSIT_CHARGE_ACTION_BEAN = pt_il_deposit_charge_action_bean;
	}

	public PT_IL_TOP_UP_1_ACTION getPT_IL_TOP_UP_1_ACTION_BEAN() {
		return PT_IL_TOP_UP_1_ACTION_BEAN;
	}

	public void setPT_IL_TOP_UP_1_ACTION_BEAN(
			PT_IL_TOP_UP_1_ACTION pt_il_top_up_1_action_bean) {
		PT_IL_TOP_UP_1_ACTION_BEAN = pt_il_top_up_1_action_bean;
	}

	public PT_IL_TOP_UP_2_ACTION getPT_IL_TOP_UP_2_ACTION_BEAN() {
		return PT_IL_TOP_UP_2_ACTION_BEAN;
	}

	public void setPT_IL_TOP_UP_2_ACTION_BEAN(
			PT_IL_TOP_UP_2_ACTION pt_il_top_up_2_action_bean) {
		PT_IL_TOP_UP_2_ACTION_BEAN = pt_il_top_up_2_action_bean;
	}

	public PT_IL_TOP_UP_ACTION getPT_IL_TOP_UP_ACTION_BEAN() {
		return PT_IL_TOP_UP_ACTION_BEAN;
	}

	public void setPT_IL_TOP_UP_ACTION_BEAN(
			PT_IL_TOP_UP_ACTION pt_il_top_up_action_bean) {
		PT_IL_TOP_UP_ACTION_BEAN = pt_il_top_up_action_bean;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public String goToPT_IL_DEPOSIT_CHARGE() {

		System.out.println("Inside..........goToPT_IL_DEPOSIT_CHARGE");
		System.out.println(PT_IL_TOP_UP_ACTION_BEAN.getPT_IL_TOP_UP_BEAN()
				.getTU_SYS_ID());

		this.PT_IL_DEPOSIT_CHARGE_ACTION_BEAN.populateBlockDEPOSIT_CHARGE();

		String returnString = "GO_TO_PILT027_PT_IL_DEPOSIT_CHARGE";
		return returnString;
	}

	public String goToPT_IL_TOP_UP_1() {
		String returnString = "GO_TO_PILT027_PT_IL_TOP_UP_1";
		this.PT_IL_TOP_UP_1_ACTION_BEAN.populateBlockPT_IL_TOP_UP_1();
		return returnString;
	}

	public String goToPT_IL_TOP_UP() {
		String returnString = "GO_TO_PILT027_PT_IL_TOP_UP";
		return returnString;
	}

	public String page_PILT027_PT_IL_TOP_UP_FUND_DTLS() {
		//this.PT_IL_FUND_DETAIL_ACTION_BEAN.populateBlockDEPOSIT_CHARGE();
		this.PT_IL_FUND_DETAIL_ACTION_BEAN.setBlockFlag(true);
		return "PILT027_PT_IL_TOP_UP_FUND_DETAIL";
	}
	
	
	public PT_IL_FUND_DETAIL_ACTION getPT_IL_FUND_DETAIL_ACTION_BEAN() {

		return PT_IL_FUND_DETAIL_ACTION_BEAN;
	}

	public void setPT_IL_FUND_DETAIL_ACTION_BEAN(
			PT_IL_FUND_DETAIL_ACTION pt_il_fund_detail_action_bean) {
		PT_IL_FUND_DETAIL_ACTION_BEAN = pt_il_fund_detail_action_bean;
	}

	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN() {
		return PT_IL_PYMT_DTLS_ACTION_BEAN;
	}

	public void setPT_IL_PYMT_DTLS_ACTION_BEAN(
			PT_IL_PYMT_DTLS_ACTION pt_il_pymt_dtls_action_bean) {
		PT_IL_PYMT_DTLS_ACTION_BEAN = pt_il_pymt_dtls_action_bean;
	}

	

	
}
