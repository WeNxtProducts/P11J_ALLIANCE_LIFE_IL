package com.iii.pel.forms.PP039_A;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;

public class PP039_A_COMPOSITE_ACTION {

	public final static int TAB_DUMMY = 4;
	private TabbedBar tabbedBar;

	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

	public String callDUMMY() {
		preTabClick();
		return "PP039_A_DUMMY";
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
		case 4:
			DUMMY_ACTION_BEAN.setBlockFlag(true);
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

	public PP039_A_COMPOSITE_ACTION() throws Exception {
		tabbedBar = new TabbedBar();

		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		DUMMY_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_DUMMY,
					"#{PP039_A_COMPOSITE_ACTION.callDUMMY}", Messages
							.getString("messageProperties_PP039_A",
									"PP039_A$DUMMY$displayCaption"), false);
		} catch (Exception exc) {
			exc.printStackTrace();
			DUMMY_ACTION_BEAN.getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			DUMMY_ACTION_BEAN.getErrorMap().put("OK", exc.getMessage());
		}

	}

	public static int getTAB_DUMMY() {
		return TAB_DUMMY;
	}

}
