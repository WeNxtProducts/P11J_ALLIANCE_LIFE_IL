package com.iii.pel.forms.PILM201;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILM201_COMPOSITE_ACTION {
    public final static int TAB_PM_IL_CVR_GROUP_HDR = 1;
    public final static int TAB_PM_IL_CVR_GROUP_DTL = 2;
    public final static int TAB_CTRL1 = 3;
    public final static int TAB_CTRL = 4;
    public final static int TAB_BP = 5;
    public final static int TAB_BP_BL = 6;
    private TabbedBar tabbedBar;
    private PM_IL_CVR_GROUP_HDR_ACTION PM_IL_CVR_GROUP_HDR_ACTION_BEAN;
    private PM_IL_CVR_GROUP_DTL_ACTION PM_IL_CVR_GROUP_DTL_ACTION_BEAN;
    private CTRL1_ACTION CTRL1_ACTION_BEAN;
    private CTRL_ACTION CTRL_ACTION_BEAN;
    private BP_ACTION BP_ACTION_BEAN;
    private BP_BL_ACTION BP_BL_ACTION_BEAN;

    public String callPM_IL_CVR_GROUP_HDR() {
	preTabClick();
	return "PILM201_PM_IL_CVR_GROUP_HDR";

    }

    public String callPM_IL_CVR_GROUP_DTL() {
	preTabClick();
	return "PILM201_PM_IL_CVR_GROUP_DTL";

    }

    public String callCTRL1() {
	preTabClick();
	return "PILM201_CTRL1";

    }

    public String callCTRL() {
	preTabClick();
	return "PILM201_CTRL";

    }

    public String callBP() {
	preTabClick();
	return "PILM201_BP";

    }

    public String callBP_BL() {
	preTabClick();
	return "PILM201_BP_BL";

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
	    PM_IL_CVR_GROUP_HDR_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 2:
	    PM_IL_CVR_GROUP_DTL_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 3:
	    CTRL1_ACTION_BEAN.setBlockFlag(true);
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
	case 6:
	    BP_BL_ACTION_BEAN.setBlockFlag(true);
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

    public void setPM_IL_CVR_GROUP_HDR_ACTION_BEAN(
	    PM_IL_CVR_GROUP_HDR_ACTION PM_IL_CVR_GROUP_HDR_ACTION_BEAN) {
	this.PM_IL_CVR_GROUP_HDR_ACTION_BEAN = PM_IL_CVR_GROUP_HDR_ACTION_BEAN;

    }

    public PM_IL_CVR_GROUP_HDR_ACTION getPM_IL_CVR_GROUP_HDR_ACTION_BEAN() {
	return this.PM_IL_CVR_GROUP_HDR_ACTION_BEAN;

    }

    public void setPM_IL_CVR_GROUP_DTL_ACTION_BEAN(
	    PM_IL_CVR_GROUP_DTL_ACTION PM_IL_CVR_GROUP_DTL_ACTION_BEAN) {
	this.PM_IL_CVR_GROUP_DTL_ACTION_BEAN = PM_IL_CVR_GROUP_DTL_ACTION_BEAN;

    }

    public PM_IL_CVR_GROUP_DTL_ACTION getPM_IL_CVR_GROUP_DTL_ACTION_BEAN() {
	return this.PM_IL_CVR_GROUP_DTL_ACTION_BEAN;

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

    public void setBP_BL_ACTION_BEAN(BP_BL_ACTION BP_BL_ACTION_BEAN) {
	this.BP_BL_ACTION_BEAN = BP_BL_ACTION_BEAN;

    }

    public BP_BL_ACTION getBP_BL_ACTION_BEAN() {
	return this.BP_BL_ACTION_BEAN;

    }

    public PILM201_COMPOSITE_ACTION() {
	tabbedBar = new TabbedBar();
	PM_IL_CVR_GROUP_HDR_ACTION_BEAN = new PM_IL_CVR_GROUP_HDR_ACTION();
	PM_IL_CVR_GROUP_DTL_ACTION_BEAN = new PM_IL_CVR_GROUP_DTL_ACTION();
	CTRL1_ACTION_BEAN = new CTRL1_ACTION();
	CTRL_ACTION_BEAN = new CTRL_ACTION();
	BP_ACTION_BEAN = new BP_ACTION();
	BP_BL_ACTION_BEAN = new BP_BL_ACTION();
	PM_IL_CVR_GROUP_HDR_ACTION_BEAN.compositeAction = this;
	PM_IL_CVR_GROUP_DTL_ACTION_BEAN.compositeAction = this;
	CTRL1_ACTION_BEAN.compositeAction = this;
	CTRL_ACTION_BEAN.compositeAction = this;
	BP_ACTION_BEAN.compositeAction = this;
	BP_BL_ACTION_BEAN.compositeAction = this;
	try {
	    /*   tabbedBar.addTab(TAB_PM_IL_CVR_GROUP_HDR,
		    "#{PILM201_COMPOSITE_ACTION.callPM_IL_CVR_GROUP_HDR}",
		    Messages.getString("messageProperties_PILM201",
			    "PILM201$PM_IL_CVR_GROUP_HDR$displayCaption"),
		    false);
	    tabbedBar.addTab(TAB_PM_IL_CVR_GROUP_DTL,
		    "#{PILM201_COMPOSITE_ACTION.callPM_IL_CVR_GROUP_DTL}",
		    Messages.getString("messageProperties_PILM201",
			    "PILM201$PM_IL_CVR_GROUP_DTL$displayCaption"),
		    false);
	    tabbedBar.addTab(TAB_CTRL1,
		    "#{PILM201_COMPOSITE_ACTION.callCTRL1}", Messages
			    .getString("messageProperties_PILM201",
				    "PILM201$CTRL1$displayCaption"), false);
	    
	    tabbedBar.addTab(TAB_CTRL, "#{PILM201_COMPOSITE_ACTION.callCTRL}",
		    Messages.getString("messageProperties_PILM201",
			    "PILM201$CTRL$displayCaption"), false);
	    tabbedBar.addTab(TAB_BP, "#{PILM201_COMPOSITE_ACTION.callBP}",
		    Messages.getString("messageProperties_PILM201",
			    "PILM201$BP$displayCaption"), false);
	    tabbedBar.addTab(TAB_BP_BL,
		    "#{PILM201_COMPOSITE_ACTION.callBP_BL}", Messages
			    .getString("messageProperties_PILM201",
				    "PILM201$BP_BL$displayCaption"), false);*/

	} catch (Exception exc) {
	    // TODO Auto generated catch block;
	    exc.printStackTrace();

	}

    }

}
