package com.iii.pel.forms.PM001_A;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PM001_A_COMPOSITE_ACTION{
	public final static int TAB_PM_DIVISION = 1;
	public final static int TAB_PM_DEPARTMENT = 2;
	private TabbedBar tabbedBar ;
	private PM_DIVISION_ACTION PM_DIVISION_ACTION_BEAN ;
	private PM_DEPARTMENT_ACTION PM_DEPARTMENT_ACTION_BEAN ;
	 
	public String callPM_DIVISION(){
		preTabClick();
		return "PM001_A_PM_DIVISION";
		
	}
	public String callPM_DEPARTMENT(){
		preTabClick();
		return "PM001_A_PM_DEPARTMENT";
		
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
			case 1 :PM_DIVISION_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PM_DEPARTMENT_ACTION_BEAN.setBlockFlag(true);
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
	 
	public void setPM_DIVISION_ACTION_BEAN(PM_DIVISION_ACTION PM_DIVISION_ACTION_BEAN){
		this.PM_DIVISION_ACTION_BEAN=PM_DIVISION_ACTION_BEAN;
		
	}
	public PM_DIVISION_ACTION getPM_DIVISION_ACTION_BEAN(){
		return this.PM_DIVISION_ACTION_BEAN;
		
	}
	public void setPM_DEPARTMENT_ACTION_BEAN(PM_DEPARTMENT_ACTION PM_DEPARTMENT_ACTION_BEAN){
		this.PM_DEPARTMENT_ACTION_BEAN=PM_DEPARTMENT_ACTION_BEAN;
		
	}
	public PM_DEPARTMENT_ACTION getPM_DEPARTMENT_ACTION_BEAN(){
		return this.PM_DEPARTMENT_ACTION_BEAN;
		
	}
	
	public PM001_A_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_DIVISION_ACTION_BEAN = new PM_DIVISION_ACTION();
		PM_DEPARTMENT_ACTION_BEAN = new PM_DEPARTMENT_ACTION();
		PM_DIVISION_ACTION_BEAN.compositeAction = this;
		PM_DEPARTMENT_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_DIVISION, "#{PM001_A_COMPOSITE_ACTION.callPM_DIVISION}", Messages.getString("messageProperties_PM001_A", "PM001_A$PM_DIVISION$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_DEPARTMENT, "#{PM001_A_COMPOSITE_ACTION.callPM_DEPARTMENT}", Messages.getString("messageProperties_PM001_A", "PM001_A$PM_DEPARTMENT$displayCaption"), false);
			
		}
		catch(Exception exc){
			exc.printStackTrace();
			
		}
		
	}
	
}
