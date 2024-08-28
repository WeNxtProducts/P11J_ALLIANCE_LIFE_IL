package com.iii.pel.forms.PILM085_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.forms.PILM065_APAC.PM_IL_ACCRUAL_SETUP_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
public class PILM085_APAC_COMPOSITE_ACTION extends CommonAction{
	public final static int TAB_PM_IL_ANNUITY_PYMT_SETUP = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	private TabbedBar tabbedBar ;
	private PM_IL_ANNUITY_PYMT_SETUP_ACTION PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPM_IL_ANNUITY_PYMT_SETUP(){
		preTabClick();
		return "PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILM085_APAC_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILM085_APAC_BP";
		
	}
	public String navigationEnabled(){
		setImmediate(true);
		 return "";
		
	}
	private void setImmediate(boolean flag){
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);
			
		}
		
	}
	private void preTabClick(){
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
			case 1 :PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
		}
		
	}
	public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}
	public void setPM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN(PM_IL_ANNUITY_PYMT_SETUP_ACTION PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN){
		this.PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN=PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN;
		
	}
	public PM_IL_ANNUITY_PYMT_SETUP_ACTION getPM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN(){
		return this.PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;
		
	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;
		
	}
	public PILM085_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN = new PM_IL_ANNUITY_PYMT_SETUP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_IL_ANNUITY_PYMT_SETUP_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_IL_ANNUITY_PYMT_SETUP, "#{PILM085_APAC_COMPOSITE_ACTION.callPM_IL_ANNUITY_PYMT_SETUP}", Messages.getString("messageProperties_PILM085_APAC", "PILM085_APAC$PM_IL_ANNUITY_PYMT_SETUP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILM085_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILM085_APAC", "PILM085_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILM085_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILM085_APAC", "PILM085_APAC$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
	public String updateButtonAction(String rowId){
		PM_IL_ANNUITY_PYMT_SETUP_ACTION action = new PM_IL_ANNUITY_PYMT_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP_ACTION", action);
		action.getPM_IL_ANNUITY_PYMT_SETUP_BEAN().setROWID(rowId);
		System.out.println("rowId");
		outcome = "PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
		PM_IL_ANNUITY_PYMT_SETUP_ACTION action = new PM_IL_ANNUITY_PYMT_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP_ACTION", action);

		outcome = "PILM085_APAC_PM_IL_ANNUITY_PYMT_SETUP";
		return outcome;

	}
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}
}
