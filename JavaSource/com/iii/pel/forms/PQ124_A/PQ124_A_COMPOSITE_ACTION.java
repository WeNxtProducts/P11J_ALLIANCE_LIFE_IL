package com.iii.pel.forms.PQ124_A;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PQ124_A_COMPOSITE_ACTION {
	public final static int TAB_PT_WAKALAH_DAILY_DRIP_1 = 1;
	public final static int TAB_PT_WAKALAH_DAILY_DRIP = 2;
	public final static int TAB_PS_IL_CONT_PAID_INVEST = 3;
	public final static int TAB_CTRL = 4;
	public final static int TAB_BP = 5;
	private TabbedBar tabbedBar;
	private PT_WAKALAH_DAILY_DRIP_1_ACTION PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN;
	private PT_WAKALAH_DAILY_DRIP_ACTION PT_WAKALAH_DAILY_DRIP_ACTION_BEAN;
	private PS_IL_CONT_PAID_INVEST_ACTION PS_IL_CONT_PAID_INVEST_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;

	public String callPT_WAKALAH_DAILY_DRIP_1() {
		preTabClick();
		return "PQ124_A_PT_WAKALAH_DAILY_DRIP_1";

	}

	public String callPT_WAKALAH_DAILY_DRIP() {
		preTabClick();
		return "PQ124_A_PT_WAKALAH_DAILY_DRIP";

	}

	public String callPS_IL_CONT_PAID_INVEST() {
		preTabClick();
		return "PQ124_A_PS_IL_CONT_PAID_INVEST";

	}

	public String callCTRL() {
		preTabClick();
		return "PQ124_A_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PQ124_A_BP";

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
			PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_WAKALAH_DAILY_DRIP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PS_IL_CONT_PAID_INVEST_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:// CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:// BP_ACTION_BEAN.setBlockFlag(true);
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

	public void setPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN(
			PT_WAKALAH_DAILY_DRIP_1_ACTION PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN) {
		this.PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN = PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN;

	}

	public PT_WAKALAH_DAILY_DRIP_1_ACTION getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN() {
		return this.PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN;

	}

	public void setPT_WAKALAH_DAILY_DRIP_ACTION_BEAN(
			PT_WAKALAH_DAILY_DRIP_ACTION PT_WAKALAH_DAILY_DRIP_ACTION_BEAN) {
		this.PT_WAKALAH_DAILY_DRIP_ACTION_BEAN = PT_WAKALAH_DAILY_DRIP_ACTION_BEAN;

	}

	public PT_WAKALAH_DAILY_DRIP_ACTION getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN() {
		return this.PT_WAKALAH_DAILY_DRIP_ACTION_BEAN;

	}

	public void setPS_IL_CONT_PAID_INVEST_ACTION_BEAN(
			PS_IL_CONT_PAID_INVEST_ACTION PS_IL_CONT_PAID_INVEST_ACTION_BEAN) {
		this.PS_IL_CONT_PAID_INVEST_ACTION_BEAN = PS_IL_CONT_PAID_INVEST_ACTION_BEAN;

	}

	public PS_IL_CONT_PAID_INVEST_ACTION getPS_IL_CONT_PAID_INVEST_ACTION_BEAN() {
		return this.PS_IL_CONT_PAID_INVEST_ACTION_BEAN;

	}

	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
		this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

	}

	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return this.CTRL_ACTION_BEAN;

	}

	public PQ124_A_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN = new PT_WAKALAH_DAILY_DRIP_1_ACTION();
		PT_WAKALAH_DAILY_DRIP_ACTION_BEAN = new PT_WAKALAH_DAILY_DRIP_ACTION();
		PS_IL_CONT_PAID_INVEST_ACTION_BEAN = new PS_IL_CONT_PAID_INVEST_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		PT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN.compositeAction = this;
		PT_WAKALAH_DAILY_DRIP_ACTION_BEAN.compositeAction = this;
		PS_IL_CONT_PAID_INVEST_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PT_WAKALAH_DAILY_DRIP_1,
					"#{PQ124_A_COMPOSITE_ACTION.callPT_WAKALAH_DAILY_DRIP_1}",
					Messages.getString("messageProperties_PQ124_A",
							"PQ124_A$PT_WAKALAH_DAILY_DRIP_1$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_WAKALAH_DAILY_DRIP,
					"#{PQ124_A_COMPOSITE_ACTION.callPT_WAKALAH_DAILY_DRIP}",
					Messages.getString("messageProperties_PQ124_A",
							"PQ124_A$PT_WAKALAH_DAILY_DRIP$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PS_IL_CONT_PAID_INVEST,
					"#{PQ124_A_COMPOSITE_ACTION.callPS_IL_CONT_PAID_INVEST}",
					Messages.getString("messageProperties_PQ124_A",
							"PQ124_A$PS_IL_CONT_PAID_INVEST$displayCaption"),
					false);
			tabbedBar.addTab(TAB_CTRL, "#{PQ124_A_COMPOSITE_ACTION.callCTRL}",
					Messages.getString("messageProperties_PQ124_A",
							"PQ124_A$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PQ124_A_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PQ124_A",
							"PQ124_A$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
