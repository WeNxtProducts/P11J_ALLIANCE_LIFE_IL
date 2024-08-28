package com.iii.pel.forms.PILP089_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILP089_APAC_COMPOSITE_ACTION{
	public final static int TAB_PW_IL_PA_PROFIT = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_BP = 3;
	public final static int TAB_DUMMY1 = 4;
	private TabbedBar tabbedBar ;
	private PW_IL_PA_PROFIT_ACTION PW_IL_PA_PROFIT_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN ;
	public String callPW_IL_PA_PROFIT(){
		preTabClick();
		return "PILP089_APAC_PW_IL_PA_PROFIT";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILP089_APAC_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILP089_APAC_BP";
		
	}
	public String callDUMMY1(){
		preTabClick();
		return "PILP089_APAC_DUMMY1";
		
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
			case 1 :PW_IL_PA_PROFIT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			/*case 2 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :DUMMY1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;*/
			
		}
		
	}
	public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}
	public void setPW_IL_PA_PROFIT_ACTION_BEAN(PW_IL_PA_PROFIT_ACTION PW_IL_PA_PROFIT_ACTION_BEAN){
		this.PW_IL_PA_PROFIT_ACTION_BEAN=PW_IL_PA_PROFIT_ACTION_BEAN;
		
	}
	public PW_IL_PA_PROFIT_ACTION getPW_IL_PA_PROFIT_ACTION_BEAN(){
		return this.PW_IL_PA_PROFIT_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	
	public PILP089_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PW_IL_PA_PROFIT_ACTION_BEAN = new PW_IL_PA_PROFIT_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PW_IL_PA_PROFIT_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try{
			//tabbedBar.addTab(TAB_PW_IL_PA_PROFIT, "#{PILP089_APAC_COMPOSITE_ACTION.callPW_IL_PA_PROFIT}", Messages.getString("messageProperties_PILP089_APAC", "PILP089_APAC$PW_IL_PA_PROFIT$displayCaption"), false);
			//tabbedBar.addTab(TAB_CTRL, "#{PILP089_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILP089_APAC", "PILP089_APAC$CTRL$displayCaption"), false);
			//tabbedBar.addTab(TAB_BP, "#{PILP089_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILP089_APAC", "PILP089_APAC$BP$displayCaption"), false);
			//tabbedBar.addTab(TAB_DUMMY1, "#{PILP089_APAC_COMPOSITE_ACTION.callDUMMY1}", Messages.getString("messageProperties_PILP089_APAC", "PILP089_APAC$DUMMY1$displayCaption"), false);
			
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
