package com.iii.pel.forms.PM079_A;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PM079_A_COMPOSITE_ACTION{
	public final static int TAB_PM_WAKALAH_DAILY_ACC_SETUP = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	private TabbedBar tabbedBar ;
	private PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPM_WAKALAH_DAILY_ACC_SETUP(){
		preTabClick();
		return "PM079_A_PM_WAKALAH_DAILY_ACC_SETUP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PM079_A_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PM079_A_BP";
		
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
			case 1 :PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.setBlockFlag(true);
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
	public void setPM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN(PM_WAKALAH_DAILY_ACC_SETUP_ACTION PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN){
		this.PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN=PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN;
		
	}
	public PM_WAKALAH_DAILY_ACC_SETUP_ACTION getPM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN(){
		return this.PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN;
		
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
	public PM079_A_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN = new PM_WAKALAH_DAILY_ACC_SETUP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_WAKALAH_DAILY_ACC_SETUP_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_WAKALAH_DAILY_ACC_SETUP, "#{PM079_A_COMPOSITE_ACTION.callPM_WAKALAH_DAILY_ACC_SETUP}", Messages.getString("messageProperties_PM079_A", "PM079_A$PM_WAKALAH_DAILY_ACC_SETUP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PM079_A_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PM079_A", "PM079_A$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PM079_A_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PM079_A", "PM079_A$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
