package com.iii.pel.forms.PM091_A;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PM091_A_COMPOSITE_ACTION {

	public final static int TAB_PM_AGENT_BENEFIT_HDR = 1;
	public final static int TAB_PM_AGENT_BENEFIT_DTL = 2;
	public final static int TAB_PM_AGENT_BENEFIT_APPL_RANK = 3;
	public final static int TAB_PM_AGENT_BENEFIT_APPL_PROD = 4;
	private TabbedBar tabbedBar ;
	private PM_AGENT_BENEFIT_HDR_ACTION PM_AGENT_BENEFIT_HDR_ACTION_BEAN;
	private PM_AGENT_BENEFIT_DTL_ACTION  PM_AGENT_BENEFIT_DTL_ACTION_BEAN;
	private PM_AGENT_BENEFIT_APPL_RANK_ACTION PM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN;
	private PM_AGENT_BENEFIT_APPL_PROD_ACTION PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN;
	
	
	
	
	public String callPM_AGENT_BENEFIT_HDR(){
		preTabClick();
		return "PM_AGENT_BENEFIT_HDR";
		
	}
	public String callPM_AGENT_BENEFIT_DTL(){
		preTabClick();
		return "PM_AGENT_BENEFIT_DTL";
		
	}
	public String callPM_AGENT_BENEFIT_APPL_RANK(){
		preTabClick();
		return "PM_AGENT_BENEFIT_APPL_RANK";
		
	}
	public String callPM_AGENT_BENEFIT_APPL_PROD(){
		preTabClick();
		return "PM_AGENT_BENEFIT_APPL_PROD";
		
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
			case 1 :PM_AGENT_BENEFIT_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PM_AGENT_BENEFIT_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN.setBlockFlag(true);
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

	public PM091_A_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		 PM_AGENT_BENEFIT_HDR_ACTION_BEAN = new PM_AGENT_BENEFIT_HDR_ACTION();
		 PM_AGENT_BENEFIT_DTL_ACTION_BEAN = new PM_AGENT_BENEFIT_DTL_ACTION();
		 PM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN = new PM_AGENT_BENEFIT_APPL_RANK_ACTION();
		 PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN = new PM_AGENT_BENEFIT_APPL_PROD_ACTION();
		 PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN.compositeAction = this;
		 PM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN.compositeAction = this;
		 PM_AGENT_BENEFIT_DTL_ACTION_BEAN.compositeAction = this;
		 PM_AGENT_BENEFIT_HDR_ACTION_BEAN.compositeAction = this;
		 
		 
		
		try{
			this.tabbedBar.addTab(TAB_PM_AGENT_BENEFIT_HDR, "#{PM091_A_COMPOSITE_ACTION.callPM_AGENT_BENEFIT_HDR}",Messages.getString("messageProperties_PM091_A", "PM091_A$PM_AGENT_BENEFIT_HDR$TAB$Benefits"), false);
				this.tabbedBar.addTab(TAB_PM_AGENT_BENEFIT_DTL, "#{PM091_A_COMPOSITE_ACTION.callPM_AGENT_BENEFIT_DTL}",Messages.getString("messageProperties_PM091_A", "PM091_A$PM_AGENT_BENEFIT_HDR$TAB$BenefitDetails"), false);
				this.tabbedBar.addTab(TAB_PM_AGENT_BENEFIT_APPL_RANK, "#{PM091_A_COMPOSITE_ACTION.callPM_AGENT_BENEFIT_APPL_RANK}",Messages.getString("messageProperties_PM091_A", "PM091_A$PM_AGENT_BENEFIT_HDR$TAB$ApplicableRanks"), false);
				this.tabbedBar.addTab(TAB_PM_AGENT_BENEFIT_APPL_PROD, "#{PM091_A_COMPOSITE_ACTION.callPM_AGENT_BENEFIT_APPL_PROD}",Messages.getString("messageProperties_PM091_A", "PM091_A$PM_AGENT_BENEFIT_HDR$TAB$ApplicableProducts"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	public PM_AGENT_BENEFIT_HDR_ACTION getPM_AGENT_BENEFIT_HDR_ACTION_BEAN() {
		return PM_AGENT_BENEFIT_HDR_ACTION_BEAN;
	}
	public void setPM_AGENT_BENEFIT_HDR_ACTION_BEAN(
			PM_AGENT_BENEFIT_HDR_ACTION pm_agent_benefit_hdr_action_bean) {
		PM_AGENT_BENEFIT_HDR_ACTION_BEAN = pm_agent_benefit_hdr_action_bean;
	}
	public PM_AGENT_BENEFIT_DTL_ACTION getPM_AGENT_BENEFIT_DTL_ACTION_BEAN() {
		return PM_AGENT_BENEFIT_DTL_ACTION_BEAN;
	}
	public void setPM_AGENT_BENEFIT_DTL_ACTION_BEAN(
			PM_AGENT_BENEFIT_DTL_ACTION pm_agent_benefit_dtl_action_bean) {
		PM_AGENT_BENEFIT_DTL_ACTION_BEAN = pm_agent_benefit_dtl_action_bean;
	}
	public PM_AGENT_BENEFIT_APPL_RANK_ACTION getPM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN() {
		return PM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN;
	}
	public void setPM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN(
			PM_AGENT_BENEFIT_APPL_RANK_ACTION pm_agent_benefit_appl_rank_action_bean) {
		PM_AGENT_BENEFIT_APPL_RANK_ACTION_BEAN = pm_agent_benefit_appl_rank_action_bean;
	}
	public PM_AGENT_BENEFIT_APPL_PROD_ACTION getPM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN() {
		return PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN;
	}
	public void setPM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN(
			PM_AGENT_BENEFIT_APPL_PROD_ACTION pm_agent_benefit_appl_prod_action_bean) {
		PM_AGENT_BENEFIT_APPL_PROD_ACTION_BEAN = pm_agent_benefit_appl_prod_action_bean;
	}
	
}
