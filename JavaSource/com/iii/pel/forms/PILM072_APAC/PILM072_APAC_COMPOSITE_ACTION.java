package com.iii.pel.forms.PILM072_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILM072_APAC_COMPOSITE_ACTION{
	public final static int TAB_PM_IL_IF_ACCNT_SETUP_HDR = 1;
	public final static int TAB_PM_IL_IF_ACCNT_SETUP_DTL = 2;
	public final static int TAB_CTRL = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar ;
	private PM_IL_IF_ACCNT_SETUP_HDR_ACTION PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN ;
	private PM_IL_IF_ACCNT_SETUP_DTL_ACTION PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN = null;
	public String callPM_IL_IF_ACCNT_SETUP_HDR(){
		preTabClick();
		return "PILM072_APAC_PM_IL_IF_ACCNT_SETUP_HDR";
		
	}
	public String callPM_IL_IF_ACCNT_SETUP_DTL(){
		preTabClick();
		return "PILM072_APAC_PM_IL_IF_ACCNT_SETUP_DTL";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILM072_APAC_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILM072_APAC_BP";
		
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
			case 1 :PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN.saveRecord();
			break;
			case 2 :PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :BP_ACTION_BEAN.setBlockFlag(true);
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
	public void setPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN(PM_IL_IF_ACCNT_SETUP_HDR_ACTION PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN){
		this.PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN=PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN;
		
	}
	public PM_IL_IF_ACCNT_SETUP_HDR_ACTION getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN(){
		return this.PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN;
		
	}
	public void setPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN(PM_IL_IF_ACCNT_SETUP_DTL_ACTION PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN){
		this.PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN=PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN;
		
	}
	public PM_IL_IF_ACCNT_SETUP_DTL_ACTION getPM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN(){
		return this.PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN;
		
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
	public PILM072_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN = new PM_IL_IF_ACCNT_SETUP_HDR_ACTION();
		PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN = new PM_IL_IF_ACCNT_SETUP_DTL_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN.compositeAction = this;
		PM_IL_IF_ACCNT_SETUP_DTL_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_IL_IF_ACCNT_SETUP_HDR, "#{PILM072_APAC_COMPOSITE_ACTION.callPM_IL_IF_ACCNT_SETUP_HDR}", Messages.getString("messageProperties_PILM072_APAC", "PILM072_APAC$PM_IL_IF_ACCNT_SETUP_HDR$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_IF_ACCNT_SETUP_DTL, "#{PILM072_APAC_COMPOSITE_ACTION.callPM_IL_IF_ACCNT_SETUP_DTL}", Messages.getString("messageProperties_PILM072_APAC", "PILM072_APAC$PM_IL_IF_ACCNT_SETUP_DTL$displayCaption"), false);
		//	tabbedBar.addTab(TAB_CTRL, "#{PILM072_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILM072_APAC", "PILM072_APAC$CTRL$displayCaption"), false);
		//	tabbedBar.addTab(TAB_BP, "#{PILM072_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILM072_APAC", "PILM072_APAC$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	/**
	 * @return the dUMMY_ACTION_BEAN
	 */
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}
	/**
	 * @param dummy_action_bean the dUMMY_ACTION_BEAN to set
	 */
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	
}
