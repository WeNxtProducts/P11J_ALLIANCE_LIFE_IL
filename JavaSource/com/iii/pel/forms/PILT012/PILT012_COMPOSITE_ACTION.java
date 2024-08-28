	package com.iii.pel.forms.PILT012;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILT012_COMPOSITE_ACTION {

	public final static int TAB_PM_IL_PROD_GROUP_DTL_ACTION = 2;
	public final static int TAB_PM_IL_PROD_GROUP_HDR_ACTION = 1;
	private PS_IL_RI_CLAIM_REG_ACTION PS_IL_RI_CLAIM_REG_ACTION_BEAN;
	private PS_IL_RI_CLAIM_REG_1_ACTION PS_IL_RI_CLAIM_REG_1_ACTION_BEAN;
	private TabbedBar tabbedBar;

	public String backButtonAction() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

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
			PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PS_IL_RI_CLAIM_REG_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;

		}
	}

	public String callPS_IL_RI_CLAIM_REG_1_ACTION() {
		preTabClick();
		return "PILT012_PS_IL_RI_CLAIM_REG_1";

	}

	public String callPS_IL_RI_CLAIM_REG_ACTION() {
		preTabClick();
		return "PILT012_PS_IL_RI_CLAIM_REG";

	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public PILT012_COMPOSITE_ACTION() {
		PS_IL_RI_CLAIM_REG_ACTION_BEAN = new PS_IL_RI_CLAIM_REG_ACTION();
		PS_IL_RI_CLAIM_REG_1_ACTION_BEAN = new PS_IL_RI_CLAIM_REG_1_ACTION();

		PS_IL_RI_CLAIM_REG_ACTION_BEAN.compositeAction = this;
		PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.compositeAction = this;

		this.tabbedBar = new TabbedBar();
		try {
			this.tabbedBar.addTab(1,
					"#{PILT012_COMPOSITE_ACTION.callPS_IL_RI_CLAIM_REG_1_ACTION}",
					"Reinsurance RI Claims Alloc", false);
			this.tabbedBar.addTab(2,
					"#{PILT012_COMPOSITE_ACTION.callPS_IL_RI_CLAIM_REG_ACTION}",
					"Reinsurance RI Claims Details", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PS_IL_RI_CLAIM_REG_ACTION getPS_IL_RI_CLAIM_REG_ACTION_BEAN() {
		return PS_IL_RI_CLAIM_REG_ACTION_BEAN;
	}

	public void setPS_IL_RI_CLAIM_REG_ACTION_BEAN(
			PS_IL_RI_CLAIM_REG_ACTION ps_il_ri_claim_reg_action_bean) {
		PS_IL_RI_CLAIM_REG_ACTION_BEAN = ps_il_ri_claim_reg_action_bean;
	}

	public PS_IL_RI_CLAIM_REG_1_ACTION getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN() {
		return PS_IL_RI_CLAIM_REG_1_ACTION_BEAN;
	}

	public void setPS_IL_RI_CLAIM_REG_1_ACTION_BEAN(
			PS_IL_RI_CLAIM_REG_1_ACTION ps_il_ri_claim_reg_1_action_bean) {
		PS_IL_RI_CLAIM_REG_1_ACTION_BEAN = ps_il_ri_claim_reg_1_action_bean;
	}

	public String goToPS_IL_RI_CLAIM_REG() {
		String returnString = "GO_TO_PILT012_PS_IL_RI_CLAIM_REG";
		System.out.println("goin to claim reg>>>>>>>>>>>>>>>>>>>");
		return returnString;
	}

	public String goToPS_IL_RI_CLAIM_REG_1() {
		String returnString = "GO_TO_PILT012_PS_IL_RI_CLAIM_REG_1";
		System.out.println("goin to claim reg 1>>>>>>>>>>>>>>>>>>>");
		return returnString;
	}

}
