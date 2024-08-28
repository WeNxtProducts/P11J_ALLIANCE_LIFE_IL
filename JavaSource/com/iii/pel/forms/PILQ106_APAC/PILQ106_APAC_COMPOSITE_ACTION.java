package com.iii.pel.forms.PILQ106_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILQ106_APAC_COMPOSITE_ACTION {
	public final static int TAB_PT_IL_UNIT_FUND_REG_HDR = 1;
	public final static int TAB_PT_IL_UNIT_FUND_REG_DTL = 2;
	public final static int TAB_PS_IL_UNIT_FUND_REG = 3;
	public final static int TAB_CTRL = 4;
	public final static int TAB_BP = 5;
	private TabbedBar tabbedBar;
	private PT_IL_UNIT_FUND_REG_HDR_ACTION PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN;
	private PT_IL_UNIT_FUND_REG_DTL_ACTION PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN;
	private PS_IL_UNIT_FUND_REG_ACTION PS_IL_UNIT_FUND_REG_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;

	public String callPT_IL_UNIT_FUND_REG_HDR() {
		preTabClick();
		return "PILQ106_APAC_PT_IL_UNIT_FUND_REG_HDR";

	}

	public String callPT_IL_UNIT_FUND_REG_DTL() {
		preTabClick();
		return "PILQ106_APAC_PT_IL_UNIT_FUND_REG_DTL";

	}

	public String callPS_IL_UNIT_FUND_REG() {
		preTabClick();
		return "PILQ106_APAC_PS_IL_UNIT_FUND_REG";

	}

	public String callCTRL() {
		preTabClick();
		return "PILQ106_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILQ106_APAC_BP";

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
			PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PS_IL_UNIT_FUND_REG_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:
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

	public void setPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN(
			PT_IL_UNIT_FUND_REG_HDR_ACTION PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN) {
		this.PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN = PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN;

	}

	public PT_IL_UNIT_FUND_REG_HDR_ACTION getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN() {
		return this.PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN;

	}

	public void setPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN(
			PT_IL_UNIT_FUND_REG_DTL_ACTION PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN) {
		this.PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN = PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN;

	}

	public PT_IL_UNIT_FUND_REG_DTL_ACTION getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN() {
		return this.PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN;

	}

	public void setPS_IL_UNIT_FUND_REG_ACTION_BEAN(
			PS_IL_UNIT_FUND_REG_ACTION PS_IL_UNIT_FUND_REG_ACTION_BEAN) {
		this.PS_IL_UNIT_FUND_REG_ACTION_BEAN = PS_IL_UNIT_FUND_REG_ACTION_BEAN;

	}

	public PS_IL_UNIT_FUND_REG_ACTION getPS_IL_UNIT_FUND_REG_ACTION_BEAN() {
		return this.PS_IL_UNIT_FUND_REG_ACTION_BEAN;

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

	public PILQ106_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN = new PT_IL_UNIT_FUND_REG_HDR_ACTION();
		PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN = new PT_IL_UNIT_FUND_REG_DTL_ACTION();
		PS_IL_UNIT_FUND_REG_ACTION_BEAN = new PS_IL_UNIT_FUND_REG_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		
		PT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN.compositeAction = this;
		PT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN.compositeAction = this;
		PS_IL_UNIT_FUND_REG_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		/* aDDED by Ameen on 05-04-2018 for KIC charge spliting tab */
		PT_IL_UNIT_FUND_CHARGE_ACTION_BEAN = new PT_IL_UNIT_FUND_CHARGE_ACTION();
		PT_IL_UNIT_FUND_CHARGE_ACTION_BEAN.compositeAction = this;
		/*End*/
		try {
		/*	tabbedBar
					.addTab(
							TAB_PT_IL_UNIT_FUND_REG_HDR,
							"#{PILQ106_APAC_COMPOSITE_ACTION.callPT_IL_UNIT_FUND_REG_HDR}",
							Messages
									.getString(
											"messageProperties_PILQ106_APAC",
											"PILQ106_APAC$PT_IL_UNIT_FUND_REG_HDR$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PT_IL_UNIT_FUND_REG_DTL,
							"#{PILQ106_APAC_COMPOSITE_ACTION.callPT_IL_UNIT_FUND_REG_DTL}",
							Messages
									.getString(
											"messageProperties_PILQ106_APAC",
											"PILQ106_APAC$PT_IL_UNIT_FUND_REG_DTL$displayCaption"),
							false);
			tabbedBar.addTab(TAB_PS_IL_UNIT_FUND_REG,
					"#{PILQ106_APAC_COMPOSITE_ACTION.callPS_IL_UNIT_FUND_REG}",
					Messages.getString("messageProperties_PILQ106_APAC",
							"PILQ106_APAC$PS_IL_UNIT_FUND_REG$displayCaption"),
					false);*/
			 
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
	
	/* aDDED by Ameen on 05-04-2018 for KIC charge spliting tab */
	
	private PT_IL_UNIT_FUND_CHARGE_ACTION PT_IL_UNIT_FUND_CHARGE_ACTION_BEAN;

	public PT_IL_UNIT_FUND_CHARGE_ACTION getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN() {
		return PT_IL_UNIT_FUND_CHARGE_ACTION_BEAN;
	}

	public void setPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN(
			PT_IL_UNIT_FUND_CHARGE_ACTION pT_IL_UNIT_FUND_CHARGE_ACTION_BEAN) {
		PT_IL_UNIT_FUND_CHARGE_ACTION_BEAN = pT_IL_UNIT_FUND_CHARGE_ACTION_BEAN;
	}
	
	/*End*/

}
