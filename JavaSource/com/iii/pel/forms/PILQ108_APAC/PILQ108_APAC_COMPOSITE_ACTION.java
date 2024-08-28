package com.iii.pel.forms.PILQ108_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
public class PILQ108_APAC_COMPOSITE_ACTION extends CommonAction{
	public final static int TAB_POLICY_DETAILS = 1;
	public final static int TAB_BP = 2;
	public final static int TAB_CTRL = 3;
	private TabbedBar tabbedBar ;
	private POLICY_DETAILS_ACTION POLICY_DETAILS_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private String WHERE_QUERY;
	
	/**
	 * @return the wHERE_QUERY
	 */
	public String getWHERE_QUERY() {
		return WHERE_QUERY;
	}
	/**
	 * @param where_query the wHERE_QUERY to set
	 */
	public void setWHERE_QUERY(String where_query) {
		WHERE_QUERY = where_query;
	}
	public String callPOLICY_DETAILS(){
		preTabClick();
		return "PILQ108_APAC_POLICY_DETAILS";
		
	}
	public String callBP(){
		preTabClick();
		return "PILQ108_APAC_BP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILQ108_APAC_CTRL";
		
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
			case 1 :POLICY_DETAILS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 ://BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 ://CTRL_ACTION_BEAN.setBlockFlag(true);
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
	public void setPOLICY_DETAILS_ACTION_BEAN(POLICY_DETAILS_ACTION POLICY_DETAILS_ACTION_BEAN){
		this.POLICY_DETAILS_ACTION_BEAN=POLICY_DETAILS_ACTION_BEAN;
		
	}
	public POLICY_DETAILS_ACTION getPOLICY_DETAILS_ACTION_BEAN(){
		return this.POLICY_DETAILS_ACTION_BEAN;
		
	}
	
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public PILQ108_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		POLICY_DETAILS_ACTION_BEAN = new POLICY_DETAILS_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		POLICY_DETAILS_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_POLICY_DETAILS, "#{PILQ108_APAC_COMPOSITE_ACTION.callPOLICY_DETAILS}", Messages.getString("messageProperties_PILQ108_APAC", "PILQ108_APAC$POLICY_DETAILS$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILQ108_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILQ108_APAC", "PILQ108_APAC$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILQ108_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILQ108_APAC", "PILQ108_APAC$CTRL$displayCaption"), false);
			
		}
		catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Exception Occurs :: " + exc.getMessage());
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
