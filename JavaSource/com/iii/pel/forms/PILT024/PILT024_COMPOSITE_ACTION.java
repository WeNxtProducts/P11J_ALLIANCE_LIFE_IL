package com.iii.pel.forms.PILT024;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.commonimpl.summaryimpl.UISummary;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILT024_COMPOSITE_ACTION {
	public final static int TAB_PT_IL_POLICY = 1;
	public final static int TAB_PT_IL_PREM_COLL = 2;
	public final static int TAB_PT_IL_PREM_COLL_CVR_DTL = 3;
	public final static int TAB_PT_IL_LOAN_INT_COLL = 4;
	public final static int TAB_PT_IL_BROKER_VALUES = 5;
	public final static int TAB_PT_AGENT_COMM_VALUES = 6;
	public final static int TAB_PT_IL_PREM_COLL_CHARGE = 7;
	public final static int TAB_PT_IL_PREM_COLL_BREAKUP = 8;
	public final static int TAB_PS_IL_POL_INVEST_SUMMARY = 9;
	public final static int TAB_PT_IL_BROK_DEDC_VALUES = 10;
	public final static int TAB_PT_IL_PYMT_DTLS = 11;
	public final static int TAB_PT_AGENT_DEDC_VALUES = 12;
	public final static int TAB_PT_IL_MULTI_PREM_COLL = 13;
	private TabbedBar tabbedBar;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	private PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN;
	private PT_IL_PREM_COLL_CVR_DTL_ACTION PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN;
	private PT_IL_LOAN_INT_COLL_ACTION PT_IL_LOAN_INT_COLL_ACTION_BEAN;
	private PT_IL_BROKER_VALUES_ACTION PT_IL_BROKER_VALUES_ACTION_BEAN;
	private PT_AGENT_COMM_VALUES_ACTION PT_AGENT_COMM_VALUES_ACTION_BEAN;
	private PT_IL_PREM_COLL_CHARGE_ACTION PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;
	private PT_IL_PREM_COLL_BREAKUP_ACTION PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN;
	private PS_IL_POL_INVEST_SUMMARY_ACTION PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN;
	private PT_IL_BROK_DEDC_VALUES_ACTION PT_IL_BROK_DEDC_VALUES_ACTION_BEAN;
	private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN;
	private PT_AGENT_DEDC_VALUES_ACTION PT_AGENT_DEDC_VALUES_ACTION_BEAN;
	private PT_IL_MULTI_PREM_COLL_ACTION PT_IL_MULTI_PREM_COLL_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	
	private UISummary comp;
	private UIWizard wizard;

	public UISummary getComp() {
		return comp;
	}

	public void setComp(UISummary comp) {
		this.comp = comp;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public String callPT_IL_POLICY() {
		preTabClick();
		return "PILT024_PT_IL_POLICY";

	}
	
	public String callINSTALMENT_DETAILS() {
		preTabClick();
		return "PILT024_INSTALMENT_DETAILS";
	}
	
	public String callPREMIUM_DETAILS() {
		preTabClick();
		return "PILT024_PREMIUM_DETAILS";
	}
	
	public String callMULTI_PREM_COLL_DETAILS() {
		preTabClick();
		return "PILT024_MULTI_PREM_COLL_DETAILS";
	}

	public String callPT_IL_PREM_COLL() {
		preTabClick();
		return "PILT024_PT_IL_PREM_COLL";

	}

	public String callPT_IL_PREM_COLL_CVR_DTL() {
		preTabClick();
		return "PILT024_PT_IL_PREM_COLL_CVR_DTL";

	}

	public String callPT_IL_LOAN_INT_COLL() {
		preTabClick();
		return "PILT024_PT_IL_LOAN_INT_COLL";

	}

	public String callPT_IL_BROKER_VALUES() {
		preTabClick();
		return "PILT024_PT_IL_BROKER_VALUES";

	}

	public String callPT_AGENT_COMM_VALUES() {
		preTabClick();
		return "PILT024_PT_AGENT_COMM_VALUES";

	}

	public String callPT_IL_PREM_COLL_CHARGE() {
		preTabClick();
		return "PILT024_PT_IL_PREM_COLL_CHARGE";

	}

	public String callPT_IL_PREM_COLL_BREAKUP() {
		preTabClick();
		return "PILT024_PT_IL_PREM_COLL_BREAKUP";

	}

	public String callPS_IL_POL_INVEST_SUMMARY() {
		preTabClick();
		return "PILT024_PS_IL_POL_INVEST_SUMMARY";

	}

	public String callPT_IL_BROK_DEDC_VALUES() {
		preTabClick();
		return "PILT024_PT_IL_BROK_DEDC_VALUES";

	}

	public String callPT_IL_PYMT_DTLS() {
		preTabClick();
		return "PILT024_PT_IL_PYMT_DTLS";

	}

	public String callPT_AGENT_DEDC_VALUES() {
		preTabClick();
		return "PILT024_PT_AGENT_DEDC_VALUES";

	}

	public String callPT_IL_MULTI_PREM_COLL() {
		preTabClick();
		return "PILT024_PT_IL_MULTI_PREM_COLL";

	}

	public String navigationEnabled() {
		setImmediate(true);
		return "";

	}

	private void setImmediate(boolean flag) {
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);

		}

	}

	private void preTabClick() {
		int currentTabId = tabbedBar.getCurrentTabId();
		switch (currentTabId) {
		case 1:
			PT_IL_POLICY_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_IL_PREM_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			PT_IL_LOAN_INT_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:
			PT_IL_BROKER_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 6:
			PT_AGENT_COMM_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 7:
			PT_IL_PREM_COLL_CHARGE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 8:
			PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 9:
			PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 10:
			PT_IL_BROK_DEDC_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 11:
			PT_IL_PYMT_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 12:
			PT_AGENT_DEDC_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 13:
			PT_IL_MULTI_PREM_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;

		}

	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;

	}

	public TabbedBar getTabbedBar() {
		return this.tabbedBar;

	}

	public void setPT_IL_POLICY_ACTION_BEAN(
			PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN) {
		this.PT_IL_POLICY_ACTION_BEAN = PT_IL_POLICY_ACTION_BEAN;

	}

	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
		return this.PT_IL_POLICY_ACTION_BEAN;

	}

	public void setPT_IL_PREM_COLL_ACTION_BEAN(
			PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN) {
		this.PT_IL_PREM_COLL_ACTION_BEAN = PT_IL_PREM_COLL_ACTION_BEAN;

	}

	public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN() {
		return this.PT_IL_PREM_COLL_ACTION_BEAN;

	}

	public void setPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN(
			PT_IL_PREM_COLL_CVR_DTL_ACTION PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN) {
		this.PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN = PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN;

	}

	public PT_IL_PREM_COLL_CVR_DTL_ACTION getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN() {
		return this.PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN;

	}

	public void setPT_IL_LOAN_INT_COLL_ACTION_BEAN(
			PT_IL_LOAN_INT_COLL_ACTION PT_IL_LOAN_INT_COLL_ACTION_BEAN) {
		this.PT_IL_LOAN_INT_COLL_ACTION_BEAN = PT_IL_LOAN_INT_COLL_ACTION_BEAN;

	}

	public PT_IL_LOAN_INT_COLL_ACTION getPT_IL_LOAN_INT_COLL_ACTION_BEAN() {
		return this.PT_IL_LOAN_INT_COLL_ACTION_BEAN;

	}

	public void setPT_IL_BROKER_VALUES_ACTION_BEAN(
			PT_IL_BROKER_VALUES_ACTION PT_IL_BROKER_VALUES_ACTION_BEAN) {
		this.PT_IL_BROKER_VALUES_ACTION_BEAN = PT_IL_BROKER_VALUES_ACTION_BEAN;

	}

	public PT_IL_BROKER_VALUES_ACTION getPT_IL_BROKER_VALUES_ACTION_BEAN() {
		return this.PT_IL_BROKER_VALUES_ACTION_BEAN;

	}

	public void setPT_AGENT_COMM_VALUES_ACTION_BEAN(
			PT_AGENT_COMM_VALUES_ACTION PT_AGENT_COMM_VALUES_ACTION_BEAN) {
		this.PT_AGENT_COMM_VALUES_ACTION_BEAN = PT_AGENT_COMM_VALUES_ACTION_BEAN;

	}

	public PT_AGENT_COMM_VALUES_ACTION getPT_AGENT_COMM_VALUES_ACTION_BEAN() {
		return this.PT_AGENT_COMM_VALUES_ACTION_BEAN;

	}

	public void setPT_IL_PREM_COLL_CHARGE_ACTION_BEAN(
			PT_IL_PREM_COLL_CHARGE_ACTION PT_IL_PREM_COLL_CHARGE_ACTION_BEAN) {
		this.PT_IL_PREM_COLL_CHARGE_ACTION_BEAN = PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;

	}

	public PT_IL_PREM_COLL_CHARGE_ACTION getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN() {
		return this.PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;

	}

	public void setPT_IL_PREM_COLL_BREAKUP_ACTION_BEAN(
			PT_IL_PREM_COLL_BREAKUP_ACTION PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN) {
		this.PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN = PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN;

	}

	public PT_IL_PREM_COLL_BREAKUP_ACTION getPT_IL_PREM_COLL_BREAKUP_ACTION_BEAN() {
		return this.PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN;

	}

	public void setPS_IL_POL_INVEST_SUMMARY_ACTION_BEAN(
			PS_IL_POL_INVEST_SUMMARY_ACTION PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN) {
		this.PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN = PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN;

	}

	public PS_IL_POL_INVEST_SUMMARY_ACTION getPS_IL_POL_INVEST_SUMMARY_ACTION_BEAN() {
		return this.PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN;

	}

	public void setPT_IL_BROK_DEDC_VALUES_ACTION_BEAN(
			PT_IL_BROK_DEDC_VALUES_ACTION PT_IL_BROK_DEDC_VALUES_ACTION_BEAN) {
		this.PT_IL_BROK_DEDC_VALUES_ACTION_BEAN = PT_IL_BROK_DEDC_VALUES_ACTION_BEAN;

	}

	public PT_IL_BROK_DEDC_VALUES_ACTION getPT_IL_BROK_DEDC_VALUES_ACTION_BEAN() {
		return this.PT_IL_BROK_DEDC_VALUES_ACTION_BEAN;

	}

	public void setPT_IL_PYMT_DTLS_ACTION_BEAN(
			PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN) {
		this.PT_IL_PYMT_DTLS_ACTION_BEAN = PT_IL_PYMT_DTLS_ACTION_BEAN;

	}

	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN() {
		return this.PT_IL_PYMT_DTLS_ACTION_BEAN;

	}

	public void setPT_AGENT_DEDC_VALUES_ACTION_BEAN(
			PT_AGENT_DEDC_VALUES_ACTION PT_AGENT_DEDC_VALUES_ACTION_BEAN) {
		this.PT_AGENT_DEDC_VALUES_ACTION_BEAN = PT_AGENT_DEDC_VALUES_ACTION_BEAN;

	}

	public PT_AGENT_DEDC_VALUES_ACTION getPT_AGENT_DEDC_VALUES_ACTION_BEAN() {
		return this.PT_AGENT_DEDC_VALUES_ACTION_BEAN;

	}

	public void setPT_IL_MULTI_PREM_COLL_ACTION_BEAN(
			PT_IL_MULTI_PREM_COLL_ACTION PT_IL_MULTI_PREM_COLL_ACTION_BEAN) {
		this.PT_IL_MULTI_PREM_COLL_ACTION_BEAN = PT_IL_MULTI_PREM_COLL_ACTION_BEAN;

	}

	public PT_IL_MULTI_PREM_COLL_ACTION getPT_IL_MULTI_PREM_COLL_ACTION_BEAN() {
		return this.PT_IL_MULTI_PREM_COLL_ACTION_BEAN;

	}

	public PILT024_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		PT_IL_PREM_COLL_ACTION_BEAN = new PT_IL_PREM_COLL_ACTION();
		PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN = new PT_IL_PREM_COLL_CVR_DTL_ACTION();
		PT_IL_LOAN_INT_COLL_ACTION_BEAN = new PT_IL_LOAN_INT_COLL_ACTION();
		PT_IL_BROKER_VALUES_ACTION_BEAN = new PT_IL_BROKER_VALUES_ACTION();
		PT_AGENT_COMM_VALUES_ACTION_BEAN = new PT_AGENT_COMM_VALUES_ACTION();
		PT_IL_PREM_COLL_CHARGE_ACTION_BEAN = new PT_IL_PREM_COLL_CHARGE_ACTION();
		PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN = new PT_IL_PREM_COLL_BREAKUP_ACTION();
		PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN = new PS_IL_POL_INVEST_SUMMARY_ACTION();
		PT_IL_BROK_DEDC_VALUES_ACTION_BEAN = new PT_IL_BROK_DEDC_VALUES_ACTION();
		PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		PT_AGENT_DEDC_VALUES_ACTION_BEAN = new PT_AGENT_DEDC_VALUES_ACTION();
		PT_IL_MULTI_PREM_COLL_ACTION_BEAN = new PT_IL_MULTI_PREM_COLL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();

		PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_LOAN_INT_COLL_ACTION_BEAN.compositeAction = this;
		PT_IL_BROKER_VALUES_ACTION_BEAN.compositeAction = this;
		PT_AGENT_COMM_VALUES_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_CHARGE_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_BREAKUP_ACTION_BEAN.compositeAction = this;
		PS_IL_POL_INVEST_SUMMARY_ACTION_BEAN.compositeAction = this;
		PT_IL_BROK_DEDC_VALUES_ACTION_BEAN.compositeAction = this;
		PT_IL_PYMT_DTLS_ACTION_BEAN.compositeAction = this;
		PT_AGENT_DEDC_VALUES_ACTION_BEAN.compositeAction = this;
		PT_IL_MULTI_PREM_COLL_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		
		wizard = new UIWizard();
		try {
			tabbedBar.addTab(TAB_PT_IL_POLICY,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_POLICY}", Messages
							.getString("messageProperties_PILT024",
									"PILT024$PT_IL_POLICY$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_PREM_COLL}", Messages
							.getString("messageProperties_PILT024",
									"PILT024$PT_IL_PREM_COLL$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL_CVR_DTL,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_PREM_COLL_CVR_DTL}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_PREM_COLL_CVR_DTL$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_LOAN_INT_COLL,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_LOAN_INT_COLL}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_LOAN_INT_COLL$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_BROKER_VALUES,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_BROKER_VALUES}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_BROKER_VALUES$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_AGENT_COMM_VALUES,
					"#{PILT024_COMPOSITE_ACTION.callPT_AGENT_COMM_VALUES}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_AGENT_COMM_VALUES$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL_CHARGE,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_PREM_COLL_CHARGE}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_PREM_COLL_CHARGE$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL_BREAKUP,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_PREM_COLL_BREAKUP}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_PREM_COLL_BREAKUP$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PS_IL_POL_INVEST_SUMMARY,
					"#{PILT024_COMPOSITE_ACTION.callPS_IL_POL_INVEST_SUMMARY}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PS_IL_POL_INVEST_SUMMARY$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_BROK_DEDC_VALUES,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_BROK_DEDC_VALUES}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_BROK_DEDC_VALUES$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_PYMT_DTLS,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_PYMT_DTLS}", Messages
							.getString("messageProperties_PILT024",
									"PILT024$PT_IL_PYMT_DTLS$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_AGENT_DEDC_VALUES,
					"#{PILT024_COMPOSITE_ACTION.callPT_AGENT_DEDC_VALUES}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_AGENT_DEDC_VALUES$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_MULTI_PREM_COLL,
					"#{PILT024_COMPOSITE_ACTION.callPT_IL_MULTI_PREM_COLL}",
					Messages.getString("messageProperties_PILT024",
							"PILT024$PT_IL_MULTI_PREM_COLL$displayCaption"),
					false);
			

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

}
