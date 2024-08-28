package com.iii.pel.forms.PILM105_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILM105_APAC_COMPOSITE_ACTION{
	public final static int TAB_PM_PROD_APPL_FIELDS_1 = 1;
	public final static int TAB_PM_PROD_APPL_FIELDS = 2;
	public final static int TAB_CTRL = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar ;
	private PM_PROD_APPL_FIELDS_1_ACTION PM_PROD_APPL_FIELDS_1_ACTION_BEAN ;
	private PM_PROD_APPL_FIELDS_ACTION PM_PROD_APPL_FIELDS_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPM_PROD_APPL_FIELDS_1(){
		preTabClick();
		return "PILM105_APAC_PM_PROD_APPL_FIELDS_1";
		
	}
	public String callPM_PROD_APPL_FIELDS(){
		preTabClick();
		return "PILM105_APAC_PM_PROD_APPL_FIELDS";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILM105_APAC_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILM105_APAC_BP";
		
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
	private void preTabClick(){/*
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
			case 1 :PM_PROD_APPL_FIELDS_1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PM_PROD_APPL_FIELDS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
		}
		
	*/}
	public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}
	public void setPM_PROD_APPL_FIELDS_1_ACTION_BEAN(PM_PROD_APPL_FIELDS_1_ACTION PM_PROD_APPL_FIELDS_1_ACTION_BEAN){
		this.PM_PROD_APPL_FIELDS_1_ACTION_BEAN=PM_PROD_APPL_FIELDS_1_ACTION_BEAN;
		
	}
	public PM_PROD_APPL_FIELDS_1_ACTION getPM_PROD_APPL_FIELDS_1_ACTION_BEAN(){
		return this.PM_PROD_APPL_FIELDS_1_ACTION_BEAN;
		
	}
	public void setPM_PROD_APPL_FIELDS_ACTION_BEAN(PM_PROD_APPL_FIELDS_ACTION PM_PROD_APPL_FIELDS_ACTION_BEAN){
		this.PM_PROD_APPL_FIELDS_ACTION_BEAN=PM_PROD_APPL_FIELDS_ACTION_BEAN;
		
	}
	public PM_PROD_APPL_FIELDS_ACTION getPM_PROD_APPL_FIELDS_ACTION_BEAN(){
		return this.PM_PROD_APPL_FIELDS_ACTION_BEAN;
		
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
	public PILM105_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_PROD_APPL_FIELDS_1_ACTION_BEAN = new PM_PROD_APPL_FIELDS_1_ACTION();
		PM_PROD_APPL_FIELDS_ACTION_BEAN = new PM_PROD_APPL_FIELDS_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_PROD_APPL_FIELDS_1_ACTION_BEAN.compositeAction = this;
		PM_PROD_APPL_FIELDS_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_PROD_APPL_FIELDS_1, "#{PILM105_APAC_COMPOSITE_ACTION.callPM_PROD_APPL_FIELDS_1}", Messages.getString("messageProperties_PILM105_APAC", "PILM105_APAC$PM_PROD_APPL_FIELDS_1$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_PROD_APPL_FIELDS, "#{PILM105_APAC_COMPOSITE_ACTION.callPM_PROD_APPL_FIELDS}", Messages.getString("messageProperties_PILM105_APAC", "PILM105_APAC$PM_PROD_APPL_FIELDS$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILM105_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILM105_APAC", "PILM105_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILM105_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILM105_APAC", "PILM105_APAC$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
