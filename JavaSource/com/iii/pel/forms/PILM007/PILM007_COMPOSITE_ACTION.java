package com.iii.pel.forms.PILM007;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILM007_COMPOSITE_ACTION {
	public final static int TAB_PM_IL_CLM_REPAY = 1;
	public final static int TAB_PM_IL_CLM_REPAY_DTL = 2;
	public final static int TAB_PM_IL_CLM_LATE_FEE = 3;
	public final static int TAB_PM_IL_CLM_WAIT_PERIOD = 4;
	public final static int TAB_PM_IL_CLM_LIEN = 5;
	public final static int TAB_CTRL = 6;
	public final static int TAB_BP = 7;
	private TabbedBar tabbedBar;
	private PM_IL_CLM_REPAY_ACTION PM_IL_CLM_REPAY_ACTION_BEAN;
	private PM_IL_CLM_REPAY_DTL_ACTION PM_IL_CLM_REPAY_DTL_ACTION_BEAN;
	private PM_IL_CLM_LATE_FEE_ACTION PM_IL_CLM_LATE_FEE_ACTION_BEAN;
	private PM_IL_CLM_WAIT_PERIOD_ACTION PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN;
	private PM_IL_CLM_LIEN_ACTION PM_IL_CLM_LIEN_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	public String backButtonAction() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}
	public String callPM_IL_CLM_REPAY() {
		preTabClick();
		return "PILM007_PM_IL_CLM_REPAY";

	}

	public String callPM_IL_CLM_REPAY_DTL() {
		preTabClick();
		return "PILM007_PM_IL_CLM_REPAY_DTL";

	}

	public String callPM_IL_CLM_LATE_FEE() {
		preTabClick();
		return "PILM007_PM_IL_CLM_LATE_FEE";

	}

	public String callPM_IL_CLM_WAIT_PERIOD() {
		preTabClick();
		return "PILM007_PM_IL_CLM_WAIT_PERIOD";

	}

	public String callPM_IL_CLM_LIEN() {
		preTabClick();
		return "PILM007_PM_IL_CLM_LIEN";

	}

	public String callCTRL() {
		preTabClick();
		return "PILM007_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILM007_BP";

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
			PM_IL_CLM_REPAY_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PM_IL_CLM_REPAY_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PM_IL_CLM_LATE_FEE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:
			PM_IL_CLM_LIEN_ACTION_BEAN.setBlockFlag(true);
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

	public void setPM_IL_CLM_REPAY_ACTION_BEAN(
			PM_IL_CLM_REPAY_ACTION PM_IL_CLM_REPAY_ACTION_BEAN) {
		this.PM_IL_CLM_REPAY_ACTION_BEAN = PM_IL_CLM_REPAY_ACTION_BEAN;

	}

	public PM_IL_CLM_REPAY_ACTION getPM_IL_CLM_REPAY_ACTION_BEAN() {
		return this.PM_IL_CLM_REPAY_ACTION_BEAN;

	}

	public void setPM_IL_CLM_REPAY_DTL_ACTION_BEAN(
			PM_IL_CLM_REPAY_DTL_ACTION PM_IL_CLM_REPAY_DTL_ACTION_BEAN) {
		this.PM_IL_CLM_REPAY_DTL_ACTION_BEAN = PM_IL_CLM_REPAY_DTL_ACTION_BEAN;

	}

	public PM_IL_CLM_REPAY_DTL_ACTION getPM_IL_CLM_REPAY_DTL_ACTION_BEAN() {
		return this.PM_IL_CLM_REPAY_DTL_ACTION_BEAN;

	}

	public void setPM_IL_CLM_LATE_FEE_ACTION_BEAN(
			PM_IL_CLM_LATE_FEE_ACTION PM_IL_CLM_LATE_FEE_ACTION_BEAN) {
		this.PM_IL_CLM_LATE_FEE_ACTION_BEAN = PM_IL_CLM_LATE_FEE_ACTION_BEAN;

	}

	public PM_IL_CLM_LATE_FEE_ACTION getPM_IL_CLM_LATE_FEE_ACTION_BEAN() {
		return this.PM_IL_CLM_LATE_FEE_ACTION_BEAN;

	}

	public void setPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN(
			PM_IL_CLM_WAIT_PERIOD_ACTION PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN) {
		this.PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN = PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN;

	}

	public PM_IL_CLM_WAIT_PERIOD_ACTION getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN() {
		return this.PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN;

	}

	public void setPM_IL_CLM_LIEN_ACTION_BEAN(
			PM_IL_CLM_LIEN_ACTION PM_IL_CLM_LIEN_ACTION_BEAN) {
		this.PM_IL_CLM_LIEN_ACTION_BEAN = PM_IL_CLM_LIEN_ACTION_BEAN;

	}

	public PM_IL_CLM_LIEN_ACTION getPM_IL_CLM_LIEN_ACTION_BEAN() {
		return this.PM_IL_CLM_LIEN_ACTION_BEAN;

	}

	public PILM007_COMPOSITE_ACTION() throws Exception {
		tabbedBar = new TabbedBar();
		PM_IL_CLM_REPAY_ACTION_BEAN = new PM_IL_CLM_REPAY_ACTION();
		PM_IL_CLM_REPAY_DTL_ACTION_BEAN = new PM_IL_CLM_REPAY_DTL_ACTION();
		PM_IL_CLM_LATE_FEE_ACTION_BEAN = new PM_IL_CLM_LATE_FEE_ACTION();
		PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN = new PM_IL_CLM_WAIT_PERIOD_ACTION();
		PM_IL_CLM_LIEN_ACTION_BEAN = new PM_IL_CLM_LIEN_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PM_IL_CLM_REPAY_ACTION_BEAN.compositeAction = this;
		PM_IL_CLM_REPAY_DTL_ACTION_BEAN.compositeAction = this;
		PM_IL_CLM_LATE_FEE_ACTION_BEAN.compositeAction = this;
		PM_IL_CLM_WAIT_PERIOD_ACTION_BEAN.compositeAction = this;
		PM_IL_CLM_LIEN_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PM_IL_CLM_REPAY,
					"#{PILM007_COMPOSITE_ACTION.callPM_IL_CLM_REPAY}", Messages
							.getString("messageProperties_PILM007",
									"PILM007$PM_IL_CLM_REPAY$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PM_IL_CLM_REPAY_DTL,
					"#{PILM007_COMPOSITE_ACTION.callPM_IL_CLM_REPAY_DTL}",
					Messages.getString("messageProperties_PILM007",
							"PILM007$PM_IL_CLM_REPAY_DTL$displayCaption"),
					false);
			tabbedBar
					.addTab(
							TAB_PM_IL_CLM_LATE_FEE,
							"#{PILM007_COMPOSITE_ACTION.callPM_IL_CLM_LATE_FEE}",
							Messages
									.getString("messageProperties_PILM007",
											"PILM007$PM_IL_CLM_LATE_FEE$displayCaption"),
							false);
			tabbedBar.addTab(TAB_PM_IL_CLM_WAIT_PERIOD,
					"#{PILM007_COMPOSITE_ACTION.callPM_IL_CLM_WAIT_PERIOD}",
					Messages.getString("messageProperties_PILM007",
							"PILM007$PM_IL_CLM_WAIT_PERIOD$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PM_IL_CLM_LIEN,
					"#{PILM007_COMPOSITE_ACTION.callPM_IL_CLM_LIEN}", Messages
							.getString("messageProperties_PILM007",
									"PILM007$PM_IL_CLM_LIEN$displayCaption"),
					false);
			tabbedBar.addTab(TAB_CTRL, "#{PILM007_COMPOSITE_ACTION.callCTRL}",
					Messages.getString("messageProperties_PILM007",
							"PILM007$CTRL$displayCaption"), false);
//			tabbedBar.addTab(TAB_BP, "#{PILM007_COMPOSITE_ACTION.callBP}",
//					Messages.getString("messageProperties_PILM007",
//							"PILM007$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
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
