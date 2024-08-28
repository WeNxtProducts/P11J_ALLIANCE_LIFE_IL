package com.iii.pel.forms.PILP084_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILP084_APAC_COMPOSITE_ACTION{
	public final static int TAB_JOBS_SCHD = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	private TabbedBar tabbedBar ;
	private JOBS_SCHD_ACTION JOBS_SCHD_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callJOBS_SCHD(){
		preTabClick();
		return "PILP084_APAC_JOBS_SCHD";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILP084_APAC_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILP084_APAC_BP";
		
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
			case 1 :JOBS_SCHD_ACTION_BEAN.setBlockFlag(true);
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
	public void setJOBS_SCHD_ACTION_BEAN(JOBS_SCHD_ACTION JOBS_SCHD_ACTION_BEAN){
		this.JOBS_SCHD_ACTION_BEAN=JOBS_SCHD_ACTION_BEAN;
		
	}
	public JOBS_SCHD_ACTION getJOBS_SCHD_ACTION_BEAN(){
		return this.JOBS_SCHD_ACTION_BEAN;
		
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
	public PILP084_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		JOBS_SCHD_ACTION_BEAN = new JOBS_SCHD_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		JOBS_SCHD_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_JOBS_SCHD, "#{PILP084_APAC_COMPOSITE_ACTION.callJOBS_SCHD}", Messages.getString("messageProperties_PILP084_APAC", "PILP084_APAC$JOBS_SCHD$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILP084_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILP084_APAC", "PILP084_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILP084_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILP084_APAC", "PILP084_APAC$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
