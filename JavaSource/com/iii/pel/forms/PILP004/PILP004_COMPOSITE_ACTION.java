package com.iii.pel.forms.PILP004;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;

public class PILP004_COMPOSITE_ACTION extends CommonAction {
	public final static int TAB_MATURITY = 1;
	// public final static int TAB_PT_IL_PROCESS = 2;
	// public final static int TAB_CTRL = 3;
	// public final static int TAB_BP = 4;
	private TabbedBar tabbedBar;
	private MATURITY_ACTION MATURITY_ACTION_BEAN;
	private PT_IL_PROCESS_ACTION PT_IL_PROCESS_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	/**
	 * @return the dUMMY_ACTION_BEAN
	 */
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	/**
	 * @param dummy_action_bean
	 *            the dUMMY_ACTION_BEAN to set
	 */
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

	public String callMATURITY() {
		preTabClick();
		return "PILP004_MATURITY";

	}

	public String callPT_IL_PROCESS() {
		preTabClick();
		return "PILP004_PT_IL_PROCESS";

	}

	public String callCTRL() {
		preTabClick();
		return "PILP004_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILP004_BP";

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
			MATURITY_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_IL_PROCESS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
		//	CTRL_ACTION_BEAN.setBlockFlag(true);
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

	public void setMATURITY_ACTION_BEAN(MATURITY_ACTION MATURITY_ACTION_BEAN) {
		this.MATURITY_ACTION_BEAN = MATURITY_ACTION_BEAN;

	}

	public MATURITY_ACTION getMATURITY_ACTION_BEAN() {
		return this.MATURITY_ACTION_BEAN;

	}

	public void setPT_IL_PROCESS_ACTION_BEAN(
			PT_IL_PROCESS_ACTION PT_IL_PROCESS_ACTION_BEAN) {
		this.PT_IL_PROCESS_ACTION_BEAN = PT_IL_PROCESS_ACTION_BEAN;

	}

	public PT_IL_PROCESS_ACTION getPT_IL_PROCESS_ACTION_BEAN() {
		return this.PT_IL_PROCESS_ACTION_BEAN;

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

	public PILP004_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		MATURITY_ACTION_BEAN = new MATURITY_ACTION();
		PT_IL_PROCESS_ACTION_BEAN = new PT_IL_PROCESS_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		MATURITY_ACTION_BEAN.compositeAction = this;
		PT_IL_PROCESS_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_MATURITY,
					"#{PILP004_COMPOSITE_ACTION.callMATURITY}", Messages
							.getString("messageProperties_PILP004",
									"PILP004$MATURITY$displayCaption"), false);
			// tabbedBar.addTab(TAB_PT_IL_PROCESS,
			// "#{PILP004_COMPOSITE_ACTION.callPT_IL_PROCESS}",
			// Messages.getString("messageProperties_PILP004",
			// "PILP004$PT_IL_PROCESS$displayCaption"), false);
			// tabbedBar.addTab(TAB_CTRL,
			// "#{PILP004_COMPOSITE_ACTION.callCTRL}",
			// Messages.getString("messageProperties_PILP004",
			// "PILP004$CTRL$displayCaption"), false);
			// tabbedBar.addTab(TAB_BP, "#{PILP004_COMPOSITE_ACTION.callBP}",
			// Messages.getString("messageProperties_PILP004",
			// "PILP004$BP$displayCaption"), false);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			exc.printStackTrace();

		}
	}
}
