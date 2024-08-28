package com.iii.pel.forms.PILM002_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.utils.CommonUtils;

public class PILM002_APAC_COMPOSITE_ACTION {
	
	private PM_IL_APPL_WOP_COVER_ACTION PM_IL_APPL_WOP_COVER_ACTION_BEAN;
	
	private PM_IL_COVER_ACTION PM_IL_COVER_ACTION_BEAN;
	
	private PM_IL_CVR_WAITING_PRD_ACTION PM_IL_CVR_WAITING_PRD_ACTION_BEAN;
	
	private PM_IL_CVR_BASIC_CONTR_ACTION PM_IL_CVR_BASIC_CONTR_ACTION_BEAN;

	private TabbedBar tabbedBar;
	
	public static final int PM_IL_COVER=1;
	public static final int PM_IL_APPL_WOP_COVER=2;
	public static final int PM_IL_CVR_WAITING_PRD=4;
	public static final int PM_IL_CVR_CONTR_PRD=3;
	
	public PILM002_APAC_COMPOSITE_ACTION() {
		this.tabbedBar=new TabbedBar();
		this.PM_IL_APPL_WOP_COVER_ACTION_BEAN = new PM_IL_APPL_WOP_COVER_ACTION();
		this.PM_IL_COVER_ACTION_BEAN=new PM_IL_COVER_ACTION();
		this.PM_IL_CVR_WAITING_PRD_ACTION_BEAN=new PM_IL_CVR_WAITING_PRD_ACTION();
		this.PM_IL_CVR_BASIC_CONTR_ACTION_BEAN=new PM_IL_CVR_BASIC_CONTR_ACTION();
		PM_IL_CVR_BASIC_CONTR_ACTION_BEAN.compositeAction=this;
		PM_IL_COVER_ACTION_BEAN.compositeAction=this;
		PM_IL_APPL_WOP_COVER_ACTION_BEAN.compositeAction=this;
		
		try {
			this.tabbedBar.addTab(PM_IL_COVER, "#{PILM002_APAC_COMPOSITE_ACTION.goToPM_IL_COVER}", "Cover Details", false);
			this.tabbedBar.addTab(PM_IL_APPL_WOP_COVER, "#{PILM002_APAC_COMPOSITE_ACTION.goToPM_IL_APPL_WOP_COVER}", "WOP Cover Details", false);
			//this.tabbedBar.addTab(PM_IL_CVR_WAITING_PRD, "#{PILM002_APAC_COMPOSITE_ACTION.goToPM_IL_CVR_WAITING_PRD}", "Waiting Period", false);
			//this.tabbedBar.addTab(PM_IL_CVR_CONTR_PRD, "#{PILM002_APAC_COMPOSITE_ACTION.goToPM_IL_CVR_CONTR_PRD}", "Basic Contribution", false);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	
	public PM_IL_APPL_WOP_COVER_ACTION getPM_IL_APPL_WOP_COVER_ACTION_BEAN() {
		return PM_IL_APPL_WOP_COVER_ACTION_BEAN;
	}

	public void setPM_IL_APPL_WOP_COVER_ACTION_BEAN(
			PM_IL_APPL_WOP_COVER_ACTION pm_il_appl_wop_cover_action_bean) {
		PM_IL_APPL_WOP_COVER_ACTION_BEAN = pm_il_appl_wop_cover_action_bean;
	}

	public PM_IL_COVER_ACTION getPM_IL_COVER_ACTION_BEAN() {
		return PM_IL_COVER_ACTION_BEAN;
	}

	public void setPM_IL_COVER_ACTION_BEAN(
			PM_IL_COVER_ACTION pm_il_cover_action_bean) {
		PM_IL_COVER_ACTION_BEAN = pm_il_cover_action_bean;
	}
	
	public PM_IL_CVR_WAITING_PRD_ACTION getPM_IL_CVR_WAITING_PRD_ACTION_BEAN() {
		return PM_IL_CVR_WAITING_PRD_ACTION_BEAN;
	}

	public void setPM_IL_CVR_WAITING_PRD_ACTION_BEAN(
			PM_IL_CVR_WAITING_PRD_ACTION pm_il_cvr_waiting_prd_action_bean) {
		PM_IL_CVR_WAITING_PRD_ACTION_BEAN = pm_il_cvr_waiting_prd_action_bean;
	}
	
	public String goToPM_IL_COVER(){
		String returnString="GO_TO_PILM002_APAC_PM_IL_COVER";
		return returnString;
	}
	
	public String goToPM_IL_APPL_WOP_COVER(){
		preTabClick();
		String returnString="GO_TO_PILM002_APAC_PM_IL_APPL_WOP_COVER";
		this.PM_IL_COVER_ACTION_BEAN.populateBlockPM_IL_APPL_WOP_COVER();
		return returnString;
	}
	
	public String goToPM_IL_CVR_WAITING_PRD(){
		String returnString="GO_TO_PILM002_APAC_PM_IL_CVR_WAITING_PRD";
		this.PM_IL_APPL_WOP_COVER_ACTION_BEAN.populateBlockPM_IL_CVR_WAITING_PRD();
		return returnString;
	}
	
	public String goToPM_IL_CVR_CONTR_PRD(){
		preTabClick();
		String returnString="GO_TO_PILM002_APAC_PM_IL_CVR_CONTR_PRD";
		this.PM_IL_CVR_BASIC_CONTR_ACTION_BEAN.populateBlockPM_IL_CVR_CONTR_PRD();
		CommonUtils.setGlobalObject("PILM002_APAC_COMPOSITE_ACTION", this);
		return returnString;
	}
	
	

	public PM_IL_CVR_BASIC_CONTR_ACTION getPM_IL_CVR_BASIC_CONTR_ACTION_BEAN() {
		return PM_IL_CVR_BASIC_CONTR_ACTION_BEAN;
	}

	public void setPM_IL_CVR_BASIC_CONTR_ACTION_BEAN(
			PM_IL_CVR_BASIC_CONTR_ACTION pm_il_cvr_basic_contr_action_bean) {
		PM_IL_CVR_BASIC_CONTR_ACTION_BEAN = pm_il_cvr_basic_contr_action_bean;
	}
	
	public String navigationEnabled() {
		setImmediate(true);
		return "";

	    }

    private void setImmediate(boolean flag) {
    	this.PM_IL_COVER_ACTION_BEAN.getErrorMap().clear();
    	this.PM_IL_COVER_ACTION_BEAN.getWarningMap().clear();
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
			PM_IL_APPL_WOP_COVER_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PM_IL_CVR_BASIC_CONTR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		}
    }

}
