package com.iii.pel.forms.PILQ114_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILQ114_APAC_COMPOSITE_ACTION {
	public final static int TAB_PT_IL_SURR_VALUE = 1;
	public final static int TAB_BP = 2;
	public final static int TAB_CTRL = 3;
	private TabbedBar tabbedBar;
	private PT_IL_SURR_VALUE_ACTION PT_IL_SURR_VALUE_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;

	public String callPT_IL_SURR_VALUE() {
		preTabClick();
		return "PILQ114_APAC_PT_IL_SURR_VALUE";

	}

	public String callBP() {
		preTabClick();
		return "PILQ114_APAC_BP";

	}

	public String callCTRL() {
		preTabClick();
		return "PILQ114_APAC_CTRL";

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
			PT_IL_SURR_VALUE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			CTRL_ACTION_BEAN.setBlockFlag(true);
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

	public void setPT_IL_SURR_VALUE_ACTION_BEAN(
			PT_IL_SURR_VALUE_ACTION PT_IL_SURR_VALUE_ACTION_BEAN) {
		this.PT_IL_SURR_VALUE_ACTION_BEAN = PT_IL_SURR_VALUE_ACTION_BEAN;

	}

	public PT_IL_SURR_VALUE_ACTION getPT_IL_SURR_VALUE_ACTION_BEAN() {
		return this.PT_IL_SURR_VALUE_ACTION_BEAN;

	}

	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN) {
		this.BP_ACTION_BEAN = BP_ACTION_BEAN;

	}

	public BP_ACTION getBP_ACTION_BEAN() {
		return this.BP_ACTION_BEAN;

	}

	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
		this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

	}

	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return this.CTRL_ACTION_BEAN;

	}

	public PILQ114_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_IL_SURR_VALUE_ACTION_BEAN = new PT_IL_SURR_VALUE_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		PT_IL_SURR_VALUE_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PT_IL_SURR_VALUE,
					"#{PILQ114_APAC_COMPOSITE_ACTION.callPT_IL_SURR_VALUE}",
					Messages.getString("messageProperties_PILQ114_APAC",
							"PILQ114_APAC$PT_IL_SURR_VALUE$displayCaption"),
					false);
			tabbedBar.addTab(TAB_BP, "#{PILQ114_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILQ114_APAC",
							"PILQ114_APAC$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL,
					"#{PILQ114_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILQ114_APAC",
									"PILQ114_APAC$CTRL$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
