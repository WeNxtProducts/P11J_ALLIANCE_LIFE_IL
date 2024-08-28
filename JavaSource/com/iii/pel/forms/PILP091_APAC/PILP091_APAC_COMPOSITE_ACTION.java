package com.iii.pel.forms.PILP091_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILP091_APAC_COMPOSITE_ACTION {
	public final static int TAB_CTRL1 = 1;
	public final static int TAB_PS_IL_CONT_PAID_HDR = 2;
	public final static int TAB_CTRL = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	public PS_IL_CONT_PAID_HDR_ACTION PS_IL_CONT_PAID_HDR_ACTION_BEAN;

	public String callCTRL1() {
		preTabClick();
		return "PILP091_APAC_CTRL1";

	}

	public String callPS_IL_CONT_PAID_HDR() {
		preTabClick();
		return "PILP091_APAC_PS_IL_CONT_PAID_HDR";

	}

	public String callCTRL() {
		preTabClick();
		return "PILP091_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILP091_APAC_BP";

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
		case 2:
			PS_IL_CONT_PAID_HDR_ACTION_BEAN.setBlockFlag(true);
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

	public void setPS_IL_CONT_PAID_HDR_ACTION_BEAN(
			PS_IL_CONT_PAID_HDR_ACTION PS_IL_CONT_PAID_HDR_ACTION_BEAN) {
		this.PS_IL_CONT_PAID_HDR_ACTION_BEAN = PS_IL_CONT_PAID_HDR_ACTION_BEAN;

	}

	public PS_IL_CONT_PAID_HDR_ACTION getPS_IL_CONT_PAID_HDR_ACTION_BEAN() {
		return this.PS_IL_CONT_PAID_HDR_ACTION_BEAN;

	}

	public PILP091_APAC_COMPOSITE_ACTION() throws Exception {
		tabbedBar = new TabbedBar();
		PS_IL_CONT_PAID_HDR_ACTION_BEAN = new PS_IL_CONT_PAID_HDR_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PS_IL_CONT_PAID_HDR_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar
					.addTab(TAB_CTRL1,
							"#{PILP091_APAC_COMPOSITE_ACTION.callCTRL1}",
							Messages.getString(
									"messageProperties_PILP091_APAC",
									"PILP091_APAC$CTRL1$displayCaption"), false);
			/*tabbedBar.addTab(TAB_PS_IL_CONT_PAID_HDR,
					"#{PILP091_APAC_COMPOSITE_ACTION.callPS_IL_CONT_PAID_HDR}",
					Messages.getString("messageProperties_PILP091_APAC",
							"PILP091_APAC$PS_IL_CONT_PAID_HDR$displayCaption"),
					false);*/
			tabbedBar.addTab(TAB_CTRL,
					"#{PILP091_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILP091_APAC",
									"PILP091_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILP091_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILP091_APAC",
							"PILP091_APAC$BP$displayCaption"), false);

		} catch (Exception exc) {
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
