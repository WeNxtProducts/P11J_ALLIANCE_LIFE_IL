package com.iii.pel.forms.PILQ116_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILQ116_APAC_COMPOSITE_ACTION {
	public final static int TAB_PT_IL_PAYVOU_HDR = 1;
	public final static int TAB_PT_IL_PAYVOU_AMT_DTL = 2;
	public final static int TAB_PT_IL_PAYVOU_DRCR_DTL = 3;
	public final static int TAB_PT_IL_PAYVOU_PAY_DTL = 4;
	public final static int TAB_DUMMY_BUTTON = 5;
	public final static int TAB_CTRL = 6;
	public final static int TAB_BP = 7;
	private TabbedBar tabbedBar;
	private PT_IL_PAYVOU_HDR_ACTION PT_IL_PAYVOU_HDR_ACTION_BEAN;
	private PT_IL_PAYVOU_AMT_DTL_ACTION PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN;
	private PT_IL_PAYVOU_DRCR_DTL_ACTION PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN;
	private PT_IL_PAYVOU_PAY_DTL_ACTION PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN;
	private DUMMY_BUTTON_ACTION DUMMY_BUTTON_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;

	public String callPT_IL_PAYVOU_HDR() {
		preTabClick();
		return "PILQ116_APAC_PT_IL_PAYVOU_HDR";

	}

	public String callPT_IL_PAYVOU_AMT_DTL() {
		preTabClick();
		return "PILQ116_APAC_PT_IL_PAYVOU_AMT_DTL";

	}

	public String callPT_IL_PAYVOU_DRCR_DTL() {
		preTabClick();
		return "PILQ116_APAC_PT_IL_PAYVOU_DRCR_DTL";

	}

	public String callPT_IL_PAYVOU_PAY_DTL() {
		preTabClick();
		return "PILQ116_APAC_PT_IL_PAYVOU_PAY_DTL";

	}

	public String callDUMMY_BUTTON() {
		preTabClick();
		return "PILQ116_APAC_DUMMY_BUTTON";

	}

	public String callCTRL() {
		preTabClick();
		return "PILQ116_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILQ116_APAC_BP";

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
			PT_IL_PAYVOU_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:
			DUMMY_BUTTON_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 6:
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 7:
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

	public void setPT_IL_PAYVOU_HDR_ACTION_BEAN(
			PT_IL_PAYVOU_HDR_ACTION PT_IL_PAYVOU_HDR_ACTION_BEAN) {
		this.PT_IL_PAYVOU_HDR_ACTION_BEAN = PT_IL_PAYVOU_HDR_ACTION_BEAN;

	}

	public PT_IL_PAYVOU_HDR_ACTION getPT_IL_PAYVOU_HDR_ACTION_BEAN() {
		return this.PT_IL_PAYVOU_HDR_ACTION_BEAN;

	}

	public void setPT_IL_PAYVOU_AMT_DTL_ACTION_BEAN(
			PT_IL_PAYVOU_AMT_DTL_ACTION PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN) {
		this.PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN = PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN;

	}

	public PT_IL_PAYVOU_AMT_DTL_ACTION getPT_IL_PAYVOU_AMT_DTL_ACTION_BEAN() {
		return this.PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN;

	}

	public void setPT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN(
			PT_IL_PAYVOU_DRCR_DTL_ACTION PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN) {
		this.PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN = PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN;

	}

	public PT_IL_PAYVOU_DRCR_DTL_ACTION getPT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN() {
		return this.PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN;

	}

	public void setPT_IL_PAYVOU_PAY_DTL_ACTION_BEAN(
			PT_IL_PAYVOU_PAY_DTL_ACTION PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN) {
		this.PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN = PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN;

	}

	public PT_IL_PAYVOU_PAY_DTL_ACTION getPT_IL_PAYVOU_PAY_DTL_ACTION_BEAN() {
		return this.PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN;

	}

	public void setDUMMY_BUTTON_ACTION_BEAN(
			DUMMY_BUTTON_ACTION DUMMY_BUTTON_ACTION_BEAN) {
		this.DUMMY_BUTTON_ACTION_BEAN = DUMMY_BUTTON_ACTION_BEAN;

	}

	public DUMMY_BUTTON_ACTION getDUMMY_BUTTON_ACTION_BEAN() {
		return this.DUMMY_BUTTON_ACTION_BEAN;

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

	public PILQ116_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_IL_PAYVOU_HDR_ACTION_BEAN = new PT_IL_PAYVOU_HDR_ACTION();
		PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN = new PT_IL_PAYVOU_AMT_DTL_ACTION();
		PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN = new PT_IL_PAYVOU_DRCR_DTL_ACTION();
		PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN = new PT_IL_PAYVOU_PAY_DTL_ACTION();
		DUMMY_BUTTON_ACTION_BEAN = new DUMMY_BUTTON_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PT_IL_PAYVOU_HDR_ACTION_BEAN.compositeAction = this;
		PT_IL_PAYVOU_AMT_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_PAYVOU_PAY_DTL_ACTION_BEAN.compositeAction = this;
		DUMMY_BUTTON_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PT_IL_PAYVOU_HDR,
					"#{PILQ116_APAC_COMPOSITE_ACTION.callPT_IL_PAYVOU_HDR}",
					Messages.getString("messageProperties_PILQ116_APAC",
							"PILQ116_APAC$PT_IL_PAYVOU_HDR$displayCaption"),
					false);
			tabbedBar
					.addTab(
							TAB_PT_IL_PAYVOU_AMT_DTL,
							"#{PILQ116_APAC_COMPOSITE_ACTION.callPT_IL_PAYVOU_AMT_DTL}",
							Messages
									.getString(
											"messageProperties_PILQ116_APAC",
											"PILQ116_APAC$PT_IL_PAYVOU_AMT_DTL$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PT_IL_PAYVOU_DRCR_DTL,
							"#{PILQ116_APAC_COMPOSITE_ACTION.callPT_IL_PAYVOU_DRCR_DTL}",
							Messages
									.getString(
											"messageProperties_PILQ116_APAC",
											"PILQ116_APAC$PT_IL_PAYVOU_DRCR_DTL$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PT_IL_PAYVOU_PAY_DTL,
							"#{PILQ116_APAC_COMPOSITE_ACTION.callPT_IL_PAYVOU_PAY_DTL}",
							Messages
									.getString(
											"messageProperties_PILQ116_APAC",
											"PILQ116_APAC$PT_IL_PAYVOU_PAY_DTL$displayCaption"),
							false);
			tabbedBar.addTab(TAB_DUMMY_BUTTON,
					"#{PILQ116_APAC_COMPOSITE_ACTION.callDUMMY_BUTTON}",
					Messages.getString("messageProperties_PILQ116_APAC",
							"PILQ116_APAC$DUMMY_BUTTON$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL,
					"#{PILQ116_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILQ116_APAC",
									"PILQ116_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILQ116_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILQ116_APAC",
							"PILQ116_APAC$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

}
