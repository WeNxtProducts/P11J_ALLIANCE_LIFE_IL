package com.iii.pel.forms.PILP017;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
 
public class PILP017_COMPOSITE_ACTION{
	public final static int TAB_DUMMY1 = 1;
	public final static int TAB_BP = 2;
	public final static int TAB_CTRL = 3;
	private TabbedBar tabbedBar ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private PT_IL_CHECK_OFF_TRANS_DTL_ACTION PT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN;
	
	
	
	
	public PT_IL_CHECK_OFF_TRANS_DTL_ACTION getPT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN() {
		return PT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN;
	}
	public void setPT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN(
			PT_IL_CHECK_OFF_TRANS_DTL_ACTION pt_il_check_off_trans_dtl_action_bean) {
		PT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN = pt_il_check_off_trans_dtl_action_bean;
	}
	public String callDUMMY1(){
		preTabClick();
		return "PILP017_DUMMY1";
		
	}
	public String callBP(){
		preTabClick();
		return "PILP017_BP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILP017_CTRL";
		
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
			case 1 :DUMMY_ACTION_BEAN.setBlockFlag(true);
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
	public PILP017_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		PT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN=new PT_IL_CHECK_OFF_TRANS_DTL_ACTION();
		
		
		DUMMY_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		PT_IL_CHECK_OFF_TRANS_DTL_ACTION_BEAN.compositeAction = this;
		
		
		try{
			tabbedBar.addTab(TAB_DUMMY1, "#{PILP017_COMPOSITE_ACTION.callDUMMY1}", Messages.getString("messageProperties_PILP017", "PILP017$DUMMY1$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILP017_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILP017", "PILP017$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILP017_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILP017", "PILP017$CTRL$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	
}
