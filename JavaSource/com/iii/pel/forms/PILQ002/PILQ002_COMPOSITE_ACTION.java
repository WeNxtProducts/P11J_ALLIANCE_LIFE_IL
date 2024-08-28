package com.iii.pel.forms.PILQ002;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILQ002_COMPOSITE_ACTION {

	private TabbedBar tabbedBar;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	private DUMMY DUMMY_BEAN;
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
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public TabbedBar getTabbedBar() {
		return this.tabbedBar;

	}

	public String callPM_IL_PROD_GROUP_DTL_ACTION() {
		preTabClick();
		return "PILM200DETAIL";

	}

	public String callPM_IL_PROD_GROUP_HDR_ACTION() {
		preTabClick();
		return "PILM200execute";
	}

	/*ADDED BY GOPI FOR QUOTATION LETTER PRINT ON 30/05/17*/
	private PILQ002_PRINT_ACTION PILQ002_PRINT_ACTION_BEAN;
	
	

	public PILQ002_PRINT_ACTION getPILQ002_PRINT_ACTION_BEAN() {
		return PILQ002_PRINT_ACTION_BEAN;
	}

	public void setPILQ002_PRINT_ACTION_BEAN(
			PILQ002_PRINT_ACTION pILQ002_PRINT_ACTION_BEAN) {
		PILQ002_PRINT_ACTION_BEAN = pILQ002_PRINT_ACTION_BEAN;
	}

	//END
	
	
	
	
	
	public PILQ002_COMPOSITE_ACTION() {
		try {
			tabbedBar = new TabbedBar();
			PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
			DUMMY_BEAN= new DUMMY();
			PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
			/*ADDED BY GOPI FOR QUOTATION LETTER PRINT ON 30/05/17*/
			 PILQ002_PRINT_ACTION_BEAN = new PILQ002_PRINT_ACTION();
			 PILQ002_PRINT_ACTION_BEAN.compositeAction = this;
				//end
		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
		return PT_IL_POLICY_ACTION_BEAN;
	}

	public void setPT_IL_POLICY_ACTION_BEAN(
			PT_IL_POLICY_ACTION pt_il_policy_action_bean) {
		PT_IL_POLICY_ACTION_BEAN = pt_il_policy_action_bean;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

}
