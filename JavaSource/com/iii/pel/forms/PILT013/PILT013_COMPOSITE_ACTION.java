package com.iii.pel.forms.PILT013;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.forms.PILP078.INTERNAL_TRANSFER_ACTION;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILT013_COMPOSITE_ACTION {
	public final static int TAB_PT_IL_POLICY = 1;
	public final static int TAB_PT_IL_SURR_MAT_VALUES = 2;
	public final static int TAB_PT_IL_FUND_TRAN_DTL = 3;
	//public final static int TAB_PT_IL_BONUS = 4;
	public final static int TAB_PT_IL_SURR_CHRG = 5;
	public final static int TAB_PM_IL_DOC_TODO_GROUP = 6;
	public final static int TAB_PT_IL_DOC_TODO_LIST_STATUS = 7;
	public final static int TAB_CTRL1 = 8;
	public final static int TAB_CTRL = 9;
	public final static int TAB_BP = 10;
	private TabbedBar tabbedBar;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	private PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN;
	private PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION_BEAN;
	private PT_IL_BONUS_ACTION PT_IL_BONUS_ACTION_BEAN;
	private PT_IL_SURR_CHRG_ACTION PT_IL_SURR_CHRG_ACTION_BEAN;
	private PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
	private PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	/*Added by dhinesh for questinaire report config*/
	
	
	
	private PRINT_ACTION PRINT_ACTION_BEAN;

	public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}
	
	
	/*end*/
	
	/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
	private PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN;
	
	public PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION getPT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN() {
		return PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN;
	}

	public void setPT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN(
			PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION pT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN) {
		PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN = pT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN;
	}
	/*End*/

	public String backButtonAction() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

	public String callPT_IL_POLICY() {
		preTabClick();
		return "PILT013_PT_IL_POLICY";

	}

	public String callPT_IL_SURR_MAT_VALUES() {
		preTabClick();
		return "PILT013_PT_IL_SURR_MAT_VALUES";

	}

	public String callPT_IL_FUND_TRAN_DTL() {
		preTabClick();
		return "PILT013_PT_IL_FUND_TRAN_DTL";

	}

	/*public String callPT_IL_BONUS() {
		preTabClick();
		return "PILT013_PT_IL_BONUS";

	}*/

	public String callPT_IL_SURR_CHRG() {
		preTabClick();
		return "PILT013_PT_IL_SURR_CHRG";

	}

	public String callPM_IL_DOC_TODO_GROUP() {
		preTabClick();
		return "PILT013_PM_IL_DOC_TODO_GROUP";

	}

	public String callPT_IL_DOC_TODO_LIST_STATUS() {
		preTabClick();
		return "PILT013_PT_IL_DOC_TODO_LIST_STATUS";

	}

	public String callCTRL1() {
		preTabClick();
		return "PILT013_CTRL1";

	}

	public String callCTRL() {
		preTabClick();
		return "PILT013_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILT013_BP";

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
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PT_IL_FUND_TRAN_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			PT_IL_BONUS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:
			PT_IL_SURR_CHRG_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 6:
			PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 7:
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setBlockFlag(true);
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

	public void setPT_IL_SURR_MAT_VALUES_ACTION_BEAN(
			PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN) {
		this.PT_IL_SURR_MAT_VALUES_ACTION_BEAN = PT_IL_SURR_MAT_VALUES_ACTION_BEAN;

	}

	public PT_IL_SURR_MAT_VALUES_ACTION getPT_IL_SURR_MAT_VALUES_ACTION_BEAN() {
		return this.PT_IL_SURR_MAT_VALUES_ACTION_BEAN;

	}

	public void setPT_IL_FUND_TRAN_DTL_ACTION_BEAN(
			PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION_BEAN) {
		this.PT_IL_FUND_TRAN_DTL_ACTION_BEAN = PT_IL_FUND_TRAN_DTL_ACTION_BEAN;

	}

	public PT_IL_FUND_TRAN_DTL_ACTION getPT_IL_FUND_TRAN_DTL_ACTION_BEAN() {
		return this.PT_IL_FUND_TRAN_DTL_ACTION_BEAN;

	}

	public void setPT_IL_BONUS_ACTION_BEAN(
			PT_IL_BONUS_ACTION PT_IL_BONUS_ACTION_BEAN) {
		this.PT_IL_BONUS_ACTION_BEAN = PT_IL_BONUS_ACTION_BEAN;

	}

	public PT_IL_BONUS_ACTION getPT_IL_BONUS_ACTION_BEAN() {
		return this.PT_IL_BONUS_ACTION_BEAN;

	}

	public void setPT_IL_SURR_CHRG_ACTION_BEAN(
			PT_IL_SURR_CHRG_ACTION PT_IL_SURR_CHRG_ACTION_BEAN) {
		this.PT_IL_SURR_CHRG_ACTION_BEAN = PT_IL_SURR_CHRG_ACTION_BEAN;

	}

	public PT_IL_SURR_CHRG_ACTION getPT_IL_SURR_CHRG_ACTION_BEAN() {
		return this.PT_IL_SURR_CHRG_ACTION_BEAN;

	}

	public void setPM_IL_DOC_TODO_GROUP_ACTION_BEAN(
			PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN) {
		this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN = PM_IL_DOC_TODO_GROUP_ACTION_BEAN;

	}

	public PM_IL_DOC_TODO_GROUP_ACTION getPM_IL_DOC_TODO_GROUP_ACTION_BEAN() {
		return this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN;

	}

	public void setPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(
			PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN) {
		this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;

	}

	public PT_IL_DOC_TODO_LIST_STATUS_ACTION getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN() {
		return this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;

	}

	/*Added by Janani on 24.07.2017 for ZBILQC-1731997*/
	
	private INTERNAL_TRANSFER_ACTION INTERNAL_TRANSFER_ACTION_BEAN;
	public INTERNAL_TRANSFER_ACTION getINTERNAL_TRANSFER_ACTION_BEAN() {
		return INTERNAL_TRANSFER_ACTION_BEAN;
	}

	public void setINTERNAL_TRANSFER_ACTION_BEAN(
			INTERNAL_TRANSFER_ACTION iNTERNAL_TRANSFER_ACTION_BEAN) {
		INTERNAL_TRANSFER_ACTION_BEAN = iNTERNAL_TRANSFER_ACTION_BEAN;
	}

	/*End*/
	public PILT013_COMPOSITE_ACTION() throws Exception{
		tabbedBar = new TabbedBar();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN = new PT_IL_SURR_MAT_VALUES_ACTION();
		PT_IL_FUND_TRAN_DTL_ACTION_BEAN = new PT_IL_FUND_TRAN_DTL_ACTION();
		PT_IL_BONUS_ACTION_BEAN = new PT_IL_BONUS_ACTION();
		PT_IL_SURR_CHRG_ACTION_BEAN = new PT_IL_SURR_CHRG_ACTION();
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = new PM_IL_DOC_TODO_GROUP_ACTION();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = new PT_IL_DOC_TODO_LIST_STATUS_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		/*Added by Janani on 24.07.2017 for ZBILQC-1731997*/
		INTERNAL_TRANSFER_ACTION_BEAN = new INTERNAL_TRANSFER_ACTION();
		/*End*/
		PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN.compositeAction = this;
		PT_IL_FUND_TRAN_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_BONUS_ACTION_BEAN.compositeAction = this;
		PT_IL_SURR_CHRG_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.compositeAction = this;
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		
		/*Added by dhinesh for questinaire report config*/
		
		PRINT_ACTION_BEAN = new PRINT_ACTION();
		PRINT_ACTION_BEAN.compositeAction= this;
		
		/*End*/
		
		/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
		PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN = new PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION();
		PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN.compositeAction = this;
		/*End*/
		try {
			tabbedBar.addTab(TAB_PT_IL_POLICY,
					"#{PILT013_COMPOSITE_ACTION.callPT_IL_POLICY}", Messages
							.getString("messageProperties_PILT013",
									"PILT013$PT_IL_POLICY$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_SURR_MAT_VALUES,
					"#{PILT013_COMPOSITE_ACTION.callPT_IL_SURR_MAT_VALUES}",
					Messages.getString("messageProperties_PILT013",
							"PILT013$PT_IL_SURR_MAT_VALUES$displayCaption"),
					false);
			/*tabbedBar.addTab(TAB_PT_IL_FUND_TRAN_DTL,
					"#{PILT013_COMPOSITE_ACTION.callPT_IL_FUND_TRAN_DTL}",
					Messages.getString("messageProperties_PILT013",
							"PILT013$PT_IL_FUND_TRAN_DTL$displayCaption"),
					false);*/
		/*	tabbedBar.addTab(TAB_PT_IL_BONUS,
					"#{PILT013_COMPOSITE_ACTION.callPT_IL_BONUS}", Messages
							.getString("messageProperties_PILT013",
									"PILT013$PT_IL_BONUS$displayCaption"),
					false);*/
			tabbedBar.addTab(TAB_PT_IL_SURR_CHRG,
					"#{PILT013_COMPOSITE_ACTION.callPT_IL_SURR_CHRG}", Messages
							.getString("messageProperties_PILT013",
									"PILT013$PT_IL_SURR_CHRG$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PM_IL_DOC_TODO_GROUP,
					"#{PILT013_COMPOSITE_ACTION.callPM_IL_DOC_TODO_GROUP}",
					Messages.getString("messageProperties_PILT013",
							"PILT013$PM_IL_DOC_TODO_GROUP$displayCaption"),
					false);
			
			//as  the checklist is brought inside chklist group
		/*	tabbedBar
					.addTab(
							TAB_PT_IL_DOC_TODO_LIST_STATUS,
							"#{PILT013_COMPOSITE_ACTION.callPT_IL_DOC_TODO_LIST_STATUS}",
							Messages
									.getString("messageProperties_PILT013",
											"PILT013$PT_IL_DOC_TODO_LIST_STATUS$displayCaption"),
							false);*/
			/*tabbedBar.addTab(TAB_CTRL1,
					"#{PILT013_COMPOSITE_ACTION.callCTRL1}", Messages
							.getString("messageProperties_PILT013",
									"PILT013$CTRL1$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILT013_COMPOSITE_ACTION.callCTRL}",
					Messages.getString("messageProperties_PILT013",
							"PILT013$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILT013_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILT013",
							"PILT013$BP$displayCaption"), false);*/

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();
			throw exc;

		}

	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

}
