package com.iii.pel.forms.PILP026;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILP026_COMPOSITE_ACTION{
	public final static int TAB_PT_IL_POLICY = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_CONTROL = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar ;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private CONTROL_ACTION CONTROL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPT_IL_POLICY(){
		preTabClick();
		return "PILP026_PT_IL_POLICY";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILP026_CTRL";
		
	}
	public String callCONTROL(){
		preTabClick();
		return "PILP026_CONTROL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILP026_BP";
		
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
			case 1 :PT_IL_POLICY_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			/*break;
		//	case 2 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			//case 3 :CONTROL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);*/
			break;
			
		}
		
	}
	public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}
	public void setPT_IL_POLICY_ACTION_BEAN(PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN){
		this.PT_IL_POLICY_ACTION_BEAN=PT_IL_POLICY_ACTION_BEAN;
		
	}
	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN(){
		return this.PT_IL_POLICY_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public void setCONTROL_ACTION_BEAN(CONTROL_ACTION CONTROL_ACTION_BEAN){
		this.CONTROL_ACTION_BEAN=CONTROL_ACTION_BEAN;
		
	}
	public CONTROL_ACTION getCONTROL_ACTION_BEAN(){
		return this.CONTROL_ACTION_BEAN;
		
	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;
		
	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;
		
	}
	public PILP026_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		CONTROL_ACTION_BEAN = new CONTROL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		CONTROL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PT_IL_POLICY, "#{PILP026_COMPOSITE_ACTION.callPT_IL_POLICY}", Messages.getString("messageProperties_PILP026", "PILP026$PT_IL_POLICY$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILP026_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILP026", "PILP026$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_CONTROL, "#{PILP026_COMPOSITE_ACTION.callCONTROL}", Messages.getString("messageProperties_PILP026", "PILP026$CONTROL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILP026_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILP026", "PILP026$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
