package com.iii.pel.forms.PILM052_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM052_APAC_COMPOSITE_ACTION {
	public final static int TAB_PM_DEPT_DRCR_LINK = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	private TabbedBar tabbedBar;
	private PM_DEPT_DRCR_LINK_ACTION PM_DEPT_DRCR_LINK_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;

	public String callPM_DEPT_DRCR_LINK() {
		preTabClick();
		return "PILM052_APAC_PM_DEPT_DRCR_LINK";

	}

	public String callCTRL() {
		preTabClick();
		return "PILM052_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILM052_APAC_BP";

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
			PM_DEPT_DRCR_LINK_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
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

	public void setPM_DEPT_DRCR_LINK_ACTION_BEAN(
			PM_DEPT_DRCR_LINK_ACTION PM_DEPT_DRCR_LINK_ACTION_BEAN) {
		this.PM_DEPT_DRCR_LINK_ACTION_BEAN = PM_DEPT_DRCR_LINK_ACTION_BEAN;

	}

	public PM_DEPT_DRCR_LINK_ACTION getPM_DEPT_DRCR_LINK_ACTION_BEAN() {
		return this.PM_DEPT_DRCR_LINK_ACTION_BEAN;

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

	public PILM052_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PM_DEPT_DRCR_LINK_ACTION_BEAN = new PM_DEPT_DRCR_LINK_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_DEPT_DRCR_LINK_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PM_DEPT_DRCR_LINK,
					"#{PILM052_APAC_COMPOSITE_ACTION.callPM_DEPT_DRCR_LINK}",
					Messages.getString("messageProperties_PILM052_APAC",
							"PILM052_APAC$PM_DEPT_DRCR_LINK$displayCaption"),
					false);
			tabbedBar.addTab(TAB_CTRL,
					"#{PILM052_APAC_COMPOSITE_ACTION.callCTRL}", Messages
							.getString("messageProperties_PILM052_APAC",
									"PILM052_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILM052_APAC_COMPOSITE_ACTION.callBP}",
					Messages.getString("messageProperties_PILM052_APAC",
							"PILM052_APAC$BP$displayCaption"), false);

		} catch (Exception exc) {
			exc.printStackTrace();

		}

	}
	public String updateButtonAction(String rowId) {
		PILM052_APAC_COMPOSITE_ACTION compositeAction= new PILM052_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM052_APAC_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_DEPT_DRCR_LINK_ACTION_BEAN().getPM_DEPT_DRCR_LINK_BEAN().setROWID(rowId);
	
		outcome = "PILM052_APAC_PM_DEPT_DRCR_LINK";
		return outcome;
    }

    public String insertButtonAction() {
    	PILM052_APAC_COMPOSITE_ACTION compositeAction= new PILM052_APAC_COMPOSITE_ACTION();
    	String outcome = null;
	
    	CommonUtils.setGlobalObject("PILM052_APAC_COMPOSITE_ACTION",
				compositeAction);
		outcome = "PILM052_APAC_PM_DEPT_DRCR_LINK";

		return outcome;
	
    }
}
