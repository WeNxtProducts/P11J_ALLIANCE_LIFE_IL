package com.iii.pel.forms.PILP051_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILP051_APAC_COMPOSITE_ACTION {
	public final static int TAB_BP = 1;
	public final static int TAB_CTRL = 2;
	private TabbedBar tabbedBar;
	private BP_ACTION BP_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	
	public String callBP() {
		preTabClick();
		return "PILP051_APAC_BP";

	}

	public String callCTRL() {
		preTabClick();
		return "PILP051_APAC_CTRL";

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
			BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
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

	public PILP051_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		BP_ACTION_BEAN = new BP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		BP_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_BP, "#{PILP051_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILP051_APAC",
							"PILP051_APAC$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL,
					"#{PILP051_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILP051_APAC",
									"PILP051_APAC$CTRL$displayCaption"), false);

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
