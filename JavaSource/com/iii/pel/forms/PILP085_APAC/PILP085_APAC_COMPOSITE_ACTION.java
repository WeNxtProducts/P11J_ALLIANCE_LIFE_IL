package com.iii.pel.forms.PILP085_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILP085_APAC_COMPOSITE_ACTION {
	public final static int TAB_DUMMY1 = 1;
	public final static int TAB_PT_IL_HIBAH_FEE_PRCSS = 2;
	public final static int TAB_CTRL = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar;
	private DUMMY1_ACTION DUMMY1_ACTION_BEAN;
	private PT_IL_HIBAH_FEE_PRCSS_ACTION PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;

	public String callDUMMY1() {
		preTabClick();
		return "PILP085_APAC_DUMMY1";

	}

	public String callPT_IL_HIBAH_FEE_PRCSS() {
		preTabClick();
		return "PILP085_APAC_PT_IL_HIBAH_FEE_PRCSS";

	}

	public String callCTRL() {
		preTabClick();
		return "PILP085_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILP085_APAC_BP";

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
			DUMMY1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			BP_ACTION_BEAN.setBlockFlag(true);
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

	public void setDUMMY1_ACTION_BEAN(DUMMY1_ACTION DUMMY1_ACTION_BEAN) {
		this.DUMMY1_ACTION_BEAN = DUMMY1_ACTION_BEAN;

	}

	public DUMMY1_ACTION getDUMMY1_ACTION_BEAN() {
		return this.DUMMY1_ACTION_BEAN;

	}

	public void setPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN(
			PT_IL_HIBAH_FEE_PRCSS_ACTION PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN) {
		this.PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN = PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN;

	}

	public PT_IL_HIBAH_FEE_PRCSS_ACTION getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN() {
		return this.PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN;

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

	public PILP085_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		DUMMY1_ACTION_BEAN = new DUMMY1_ACTION();
		PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN = new PT_IL_HIBAH_FEE_PRCSS_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		DUMMY1_ACTION_BEAN.compositeAction = this;
		PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_DUMMY1,
					"#{PILP085_APAC_COMPOSITE_ACTION.callDUMMY1}", Messages
							.getString("messageProperties_PILP085_APAC",
									"PILP085_APAC$DUMMY1$displayCaption"),
					false);
			tabbedBar
					.addTab(
							TAB_PT_IL_HIBAH_FEE_PRCSS,
							"#{PILP085_APAC_COMPOSITE_ACTION.callPT_IL_HIBAH_FEE_PRCSS}",
							Messages
									.getString(
											"messageProperties_PILP085_APAC",
											"PILP085_APAC$PT_IL_HIBAH_FEE_PRCSS$displayCaption"),
							false);
			tabbedBar.addTab(TAB_CTRL,
					"#{PILP085_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILP085_APAC",
									"PILP085_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILP085_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILP085_APAC",
							"PILP085_APAC$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
