package com.iii.pel.forms.PILM012;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.forms.PILM064_APAC.BP_ACTION;
import com.iii.pel.forms.PILM064_APAC.CTRL_ACTION;
import com.iii.pel.forms.PILM064_APAC.PILM064_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM064_APAC.PM_MISC_ITEM_SETUP_ACTION;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM012_COMPOSITE_ACTION {
	public final static int TAB_PM_IL_BROKER_SETUP = 1;
	public final static int TAB_CTRL1 = 2;
	public final static int TAB_CTRL = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar;
	private PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN;
	private CTRL1_ACTION CTRL1_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;

	public String callPM_IL_BROKER_SETUP() {
		preTabClick();
		return "PILM012_PM_IL_BROKER_SETUP";

	}

	public String callCTRL1() {
		preTabClick();
		return "PILM012_CTRL1";

	}

	public String callCTRL() {
		preTabClick();
		return "PILM012_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILM012_BP";

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
			PM_IL_BROKER_SETUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			CTRL1_ACTION_BEAN.setBlockFlag(true);
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

	public void setPM_IL_BROKER_SETUP_ACTION_BEAN(
			PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN) {
		this.PM_IL_BROKER_SETUP_ACTION_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN;

	}

	public PM_IL_BROKER_SETUP_ACTION getPM_IL_BROKER_SETUP_ACTION_BEAN() {
		return this.PM_IL_BROKER_SETUP_ACTION_BEAN;

	}

	public void setCTRL1_ACTION_BEAN(CTRL1_ACTION CTRL1_ACTION_BEAN) {
		this.CTRL1_ACTION_BEAN = CTRL1_ACTION_BEAN;

	}

	public CTRL1_ACTION getCTRL1_ACTION_BEAN() {
		return this.CTRL1_ACTION_BEAN;

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

	public PILM012_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PM_IL_BROKER_SETUP_ACTION_BEAN = new PM_IL_BROKER_SETUP_ACTION();
		CTRL1_ACTION_BEAN = new CTRL1_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_IL_BROKER_SETUP_ACTION_BEAN.compositeAction = this;
		CTRL1_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar
					.addTab(
							TAB_PM_IL_BROKER_SETUP,
							"#{PILM012_COMPOSITE_ACTION.callPM_IL_BROKER_SETUP}",
							Messages
									.getString("messageProperties_PILM012",
											"PILM012$PM_IL_BROKER_SETUP$displayCaption"),
							false);
			tabbedBar.addTab(TAB_CTRL1,
					"#{PILM012_COMPOSITE_ACTION.callCTRL1}", Messages
							.getString("messageProperties_PILM012",
									"PILM012$CTRL1$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILM012_COMPOSITE_ACTION.callCTRL}",
					Messages.getString("messageProperties_PILM012",
							"PILM012$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILM012_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILM012",
							"PILM012$BP$displayCaption"), false);

		} catch (Exception exc) {
			// TODO Auto generated catch block;
			exc.printStackTrace();

		}

	}

	
	
	public String updateButtonAction(String rowId) {
	
		PILM012_COMPOSITE_ACTION compositeAction= new PILM012_COMPOSITE_ACTION(); 
		String outcome = null;
		CommonUtils.setGlobalObject("PILM012_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_BROKER_SETUP_ACTION_BEAN().getPM_IL_BROKER_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM012_PM_IL_BROKER_SETUP";
		return outcome;
    }

    public String insertButtonAction() {

    	PILM012_COMPOSITE_ACTION compositeAction= new PILM012_COMPOSITE_ACTION();
    	String outcome = null;
		CommonUtils.setGlobalObject("PILM012_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILM012_PM_IL_BROKER_SETUP";

		return outcome;
	
    }
	
}
