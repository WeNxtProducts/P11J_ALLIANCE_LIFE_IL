package com.iii.pel.forms.PILM073_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILM073_APAC_COMPOSITE_ACTION{
	public final static int TAB_FM_BANK_IN_SLIP_SETUP = 1;
	public final static int TAB_BP = 2;
	public final static int TAB_CTRL = 3;
	private TabbedBar tabbedBar ;
	private FM_BANK_IN_SLIP_SETUP_ACTION FM_BANK_IN_SLIP_SETUP_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	public String callFM_BANK_IN_SLIP_SETUP(){
		preTabClick();
		return "PILM073_APAC_FM_BANK_IN_SLIP_SETUP";
		
	}
	public String callBP(){
		preTabClick();
		return "PILM073_APAC_BP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILM073_APAC_CTRL";
		
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
			case 1 :FM_BANK_IN_SLIP_SETUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :CTRL_ACTION_BEAN.setBlockFlag(true);
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
	public void setFM_BANK_IN_SLIP_SETUP_ACTION_BEAN(FM_BANK_IN_SLIP_SETUP_ACTION FM_BANK_IN_SLIP_SETUP_ACTION_BEAN){
		this.FM_BANK_IN_SLIP_SETUP_ACTION_BEAN=FM_BANK_IN_SLIP_SETUP_ACTION_BEAN;
		
	}
	public FM_BANK_IN_SLIP_SETUP_ACTION getFM_BANK_IN_SLIP_SETUP_ACTION_BEAN(){
		return this.FM_BANK_IN_SLIP_SETUP_ACTION_BEAN;
		
	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;
		
	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public PILM073_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		FM_BANK_IN_SLIP_SETUP_ACTION_BEAN = new FM_BANK_IN_SLIP_SETUP_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		FM_BANK_IN_SLIP_SETUP_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_FM_BANK_IN_SLIP_SETUP, "#{PILM073_APAC_COMPOSITE_ACTION.callFM_BANK_IN_SLIP_SETUP}", Messages.getString("messageProperties_PILM073_APAC", "PILM073_APAC$FM_BANK_IN_SLIP_SETUP$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILM073_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILM073_APAC", "PILM073_APAC$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILM073_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILM073_APAC", "PILM073_APAC$CTRL$displayCaption"), false);
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}
	
}
