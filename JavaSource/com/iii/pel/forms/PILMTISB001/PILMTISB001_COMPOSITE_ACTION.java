package com.iii.pel.forms.PILMTISB001;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILMTISB001_COMPOSITE_ACTION {
	public final static int TAB_PM_LIFE_WAK_MORT_TABLE = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	private TabbedBar tabbedBar;
	private PM_LIFE_WAK_MORT_TABLE_ACTION PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	public String backButtonAction() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

	public String callPM_LIFE_WAK_MORT_TABLE() {
		preTabClick();
		return "PILMTISB001_PM_LIFE_WAK_MORT_TABLE";

	}

	public String callCTRL() {
		preTabClick();
		return "PILMTISB001_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILMTISB001_BP";

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
			PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN.setBlockFlag(true);
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

	public void setPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN(
			PM_LIFE_WAK_MORT_TABLE_ACTION PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN) {
		this.PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN = PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN;

	}

	public PM_LIFE_WAK_MORT_TABLE_ACTION getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN() {
		return this.PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN;

	}

	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
		this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

	}

	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return this.CTRL_ACTION_BEAN;

	}

	public PILMTISB001_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN = new PM_LIFE_WAK_MORT_TABLE_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		PM_LIFE_WAK_MORT_TABLE_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar
					.addTab(
							TAB_PM_LIFE_WAK_MORT_TABLE,
							"#{PILMTISB001_COMPOSITE_ACTION.callPM_LIFE_WAK_MORT_TABLE}",
							Messages
									.getString("messageProperties_PILMTISB001",
											"PILMTISB001$PM_LIFE_WAK_MORT_TABLE$displayCaption"),
							false);
			tabbedBar.addTab(TAB_CTRL,
					"#{PILMTISB001_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILMTISB001",
									"PILMTISB001$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILMTISB001_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILMTISB001",
							"PILMTISB001$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
