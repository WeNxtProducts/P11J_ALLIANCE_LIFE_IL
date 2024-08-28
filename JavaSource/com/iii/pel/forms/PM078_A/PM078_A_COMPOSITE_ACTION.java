package com.iii.pel.forms.PM078_A;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
public class PM078_A_COMPOSITE_ACTION{
	public final static int TAB_PM_LIFE_WAKALAH_SETUP = 2;
	private TabbedBar tabbedBar ;
	private PM_LIFE_WAKALAH_HDR_ACTION PM_LIFE_WAKALAH_HDR_ACTION_BEAN ;
	private PM_LIFE_WAKALAH_SETUP_ACTION PM_LIFE_WAKALAH_SETUP_ACTION_BEAN ;
	public String callPM_LIFE_WAKALAH_HDR(){
		preTabClick();
		return "PM078_A_PM_LIFE_WAKALAH_HDR";

	}
	public String callPM_LIFE_WAKALAH_SETUP(){
		preTabClick();
		return "PM078_A_PM_LIFE_WAKALAH_SETUP";

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
		case 1 :PM_LIFE_WAKALAH_HDR_ACTION_BEAN.setBlockFlag(true);
		setImmediate(false);
		break;
		case 2 :PM_LIFE_WAKALAH_SETUP_ACTION_BEAN.setBlockFlag(true);
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
	public void setPM_LIFE_WAKALAH_HDR_ACTION_BEAN(PM_LIFE_WAKALAH_HDR_ACTION PM_LIFE_WAKALAH_HDR_ACTION_BEAN){
		this.PM_LIFE_WAKALAH_HDR_ACTION_BEAN=PM_LIFE_WAKALAH_HDR_ACTION_BEAN;

	}
	public PM_LIFE_WAKALAH_HDR_ACTION getPM_LIFE_WAKALAH_HDR_ACTION_BEAN(){
		return this.PM_LIFE_WAKALAH_HDR_ACTION_BEAN;

	}
	public void setPM_LIFE_WAKALAH_SETUP_ACTION_BEAN(PM_LIFE_WAKALAH_SETUP_ACTION PM_LIFE_WAKALAH_SETUP_ACTION_BEAN){
		this.PM_LIFE_WAKALAH_SETUP_ACTION_BEAN=PM_LIFE_WAKALAH_SETUP_ACTION_BEAN;

	}
	public PM_LIFE_WAKALAH_SETUP_ACTION getPM_LIFE_WAKALAH_SETUP_ACTION_BEAN(){
		return this.PM_LIFE_WAKALAH_SETUP_ACTION_BEAN;

	}
	public PM078_A_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_LIFE_WAKALAH_HDR_ACTION_BEAN = new PM_LIFE_WAKALAH_HDR_ACTION();
		PM_LIFE_WAKALAH_SETUP_ACTION_BEAN = new PM_LIFE_WAKALAH_SETUP_ACTION();
		PM_LIFE_WAKALAH_HDR_ACTION_BEAN.compositeAction = this;
		PM_LIFE_WAKALAH_SETUP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_LIFE_WAKALAH_SETUP, "#{PM078_A_COMPOSITE_ACTION.callPM_LIFE_WAKALAH_SETUP}", Messages.getString("messageProperties_PM078_A", "PM078_A$PM_LIFE_WAKALAH_SETUP$displayCaption"), false);
		}
		catch(Exception exc){
			PM_LIFE_WAKALAH_SETUP_ACTION_BEAN.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			PM_LIFE_WAKALAH_SETUP_ACTION_BEAN.getErrorMap().put("PM078_A_COMPOSITE_ACTION",exc.getMessage());
		}
	}
}
