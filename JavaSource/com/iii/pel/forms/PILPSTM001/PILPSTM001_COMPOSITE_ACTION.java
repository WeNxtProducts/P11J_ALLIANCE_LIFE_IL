package com.iii.pel.forms.PILPSTM001;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;

public class PILPSTM001_COMPOSITE_ACTION extends CommonAction{
	public final static int TAB_CTRL = 1; 
	public final static int TAB_BP = 2;
	public final static int TAB_DUMMY1 = 3;
	private TabbedBar tabbedBar;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	public String callCTRL() {
		preTabClick();
		return "PILPSTM001_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILPSTM001_BP";

	}

	public String callDUMMY1() {
		preTabClick();
		return "PILPSTM001_DUMMY1";

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
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		/*
		 * case 2 :BP_ACTION_BEAN.setBlockFlag(true); setImmediate(false);
		 * break;
		 */
		case 3:
			//DUMMY1_ACTION_BEAN.setBlockFlag(true);
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

	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
		this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

	}

	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return this.CTRL_ACTION_BEAN;

	}



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

	public PILPSTM001_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		CTRL_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_CTRL,
					"#{PILPSTM001_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILPSTM001",
									"PILPSTM001$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILPSTM001_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILPSTM001",
							"PILPSTM001$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_DUMMY1,
					"#{PILPSTM001_COMPOSITE_ACTION.callDUMMY1}", Messages
							.getString("messageProperties_PILPSTM001",
									"PILPSTM001$DUMMY1$displayCaption"), false);

		} catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Exception Occurs :: " + exc.getMessage());
		}

	}

}
