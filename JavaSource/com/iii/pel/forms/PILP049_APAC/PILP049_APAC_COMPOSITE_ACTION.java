package com.iii.pel.forms.PILP049_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILP049_APAC_COMPOSITE_ACTION {
	public final static int TAB_CTRL = 1;
	public final static int TAB_BP = 2;
	public final static int TAB_DUMMY1 = 3;
	private TabbedBar tabbedBar;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;
	private DUMMY1_ACTION DUMMY1_ACTION_BEAN;

	public String callCTRL() {
		preTabClick();
		return "PILP049_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILP049_APAC_BP";

	}

	public String callDUMMY1() {
		preTabClick();
		return "PILP049_APAC_DUMMY1";

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
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			DUMMY1_ACTION_BEAN.setBlockFlag(true);
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

	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
		this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

	}

	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return this.CTRL_ACTION_BEAN;

	}

	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN) {
		this.BP_ACTION_BEAN = BP_ACTION_BEAN;

	}

	public BP_ACTION getBP_ACTION_BEAN() {
		return this.BP_ACTION_BEAN;

	}

	public void setDUMMY1_ACTION_BEAN(DUMMY1_ACTION DUMMY1_ACTION_BEAN) {
		this.DUMMY1_ACTION_BEAN = DUMMY1_ACTION_BEAN;

	}

	public DUMMY1_ACTION getDUMMY1_ACTION_BEAN() {
		return this.DUMMY1_ACTION_BEAN;

	}

	public PILP049_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		DUMMY1_ACTION_BEAN = new DUMMY1_ACTION();
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		DUMMY1_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_CTRL,
					"#{PILP049_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILP049_APAC",
									"PILP049_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILP049_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILP049_APAC",
							"PILP049_APAC$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_DUMMY1,
					"#{PILP049_APAC_COMPOSITE_ACTION.callDUMMY1}", Messages
							.getString("messageProperties_PILP049_APAC",
									"PILP049_APAC$DUMMY1$displayCaption"),
					false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
