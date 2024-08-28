package com.iii.pel.forms.PILM031;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILM031_COMPOSITE_ACTION {
	public final static int TAB_PM_IL_DISC_AGE = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	private TabbedBar tabbedBar;
	private PM_IL_DISC_AGE_ACTION PM_IL_DISC_AGE_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;

	public String callPM_IL_DISC_AGE() {
	//	preTabClick();
		PM_IL_DISC_AGE_ACTION_BEAN.setBlockFlag(true);
		return "PILM031_PM_IL_DISC_AGE";

	}

	public String callCTRL() {
	//	preTabClick();
		return "PILM031_CTRL";

	}

	public String callBP() {
	//	preTabClick();
		return "PILM031_BP";

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

/*	private void preTabClick() {
		int currentTabId = tabbedBar.getCurrentTabId();
		switch (currentTabId) {
		case 1:
			PM_IL_DISC_AGE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;

}
		}*/


	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;

	}

	public TabbedBar getTabbedBar() {
		return this.tabbedBar;

	}

	public void setPM_IL_DISC_AGE_ACTION_BEAN(
			PM_IL_DISC_AGE_ACTION PM_IL_DISC_AGE_ACTION_BEAN) {
		this.PM_IL_DISC_AGE_ACTION_BEAN = PM_IL_DISC_AGE_ACTION_BEAN;

	}

	public PM_IL_DISC_AGE_ACTION getPM_IL_DISC_AGE_ACTION_BEAN() {
		return this.PM_IL_DISC_AGE_ACTION_BEAN;

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

	public PILM031_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PM_IL_DISC_AGE_ACTION_BEAN = new PM_IL_DISC_AGE_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_IL_DISC_AGE_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PM_IL_DISC_AGE,
					"#{PILM031_COMPOSITE_ACTION.callPM_IL_DISC_AGE}", Messages
							.getString("messageProperties_PILM031",
									"PILM031$PM_IL_DISC_AGE$displayCaption"),
					false);
			tabbedBar.addTab(TAB_CTRL, "#{PILM031_COMPOSITE_ACTION.callCTRL}",
					Messages.getString("messageProperties_PILM031",
							"PILM031$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILM031_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILM031",
							"PILM031$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
