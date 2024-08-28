package com.iii.pel.forms.PT051_A;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.context.FacesContext;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.utils.CommonUtils;

public class PT051_A_COMPOSITE_ACTION extends CommonAction{
	
	private PT_AGENT_BUDGET_BREAKUP_ACTION PT_AGENT_BUDGET_BREAKUP_ACTION_BEAN;
	
	private PT_AGENT_BUDGET_ACTION PT_AGENT_BUDGET_ACTION_BEAN;
	
	private PT_AGENT_BUDGET_RANK_ACTION PT_AGENT_BUDGET_RANK_ACTION_BEAN;
	
	
	private ControlBean controlBean;
	
	private TabbedBar tabbedBar;
	
	public static final int AGENCY_BUDGET_TRANSACTION = 1;
	
	public static final int RANKWISE_DETAILS = 2;
	
	public static final int AGENT_DETAILS = 3;

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public PT_AGENT_BUDGET_BREAKUP_ACTION getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN() {
		return PT_AGENT_BUDGET_BREAKUP_ACTION_BEAN;
	}

	public void setPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN(
			PT_AGENT_BUDGET_BREAKUP_ACTION pt_agent_budget_breakup_action_bean) {
		PT_AGENT_BUDGET_BREAKUP_ACTION_BEAN = pt_agent_budget_breakup_action_bean;
	}

	public PT_AGENT_BUDGET_ACTION getPT_AGENT_BUDGET_ACTION_BEAN() {
		return PT_AGENT_BUDGET_ACTION_BEAN;
	}

	public void setPT_AGENT_BUDGET_ACTION_BEAN(
			PT_AGENT_BUDGET_ACTION pt_agent_budget_action_bean) {
		PT_AGENT_BUDGET_ACTION_BEAN = pt_agent_budget_action_bean;
	}

	public PT_AGENT_BUDGET_RANK_ACTION getPT_AGENT_BUDGET_RANK_ACTION_BEAN() {
		return PT_AGENT_BUDGET_RANK_ACTION_BEAN;
	}

	public void setPT_AGENT_BUDGET_RANK_ACTION_BEAN(
			PT_AGENT_BUDGET_RANK_ACTION pt_agent_budget_rank_action_bean) {
		PT_AGENT_BUDGET_RANK_ACTION_BEAN = pt_agent_budget_rank_action_bean;
	}

	

	public PT051_A_COMPOSITE_ACTION(){
		
		PT_AGENT_BUDGET_ACTION_BEAN = new PT_AGENT_BUDGET_ACTION();
		PT_AGENT_BUDGET_BREAKUP_ACTION_BEAN = new PT_AGENT_BUDGET_BREAKUP_ACTION();
		PT_AGENT_BUDGET_RANK_ACTION_BEAN = new PT_AGENT_BUDGET_RANK_ACTION();
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
		tabbedBar=new TabbedBar();
		 try {
			 tabbedBar.addTab(AGENCY_BUDGET_TRANSACTION, "#{PT051_A_COMPOSITE_ACTION.goToPT_AGENT_BUDGET}", "Agency Budget Transaction", false);
			 tabbedBar.addTab(RANKWISE_DETAILS, "#{PT051_A_COMPOSITE_ACTION.goToPT_AGENT_BUDGET_RANK}", "Rankwise Details", false);
			 tabbedBar.addTab(AGENT_DETAILS, "#{PT051_A_COMPOSITE_ACTION.goToPT_AGENT_BUDGET_BREAKUP}", "Agent Details", false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		PT_AGENT_BUDGET_ACTION_BEAN.compositeAction = this;
		PT_AGENT_BUDGET_BREAKUP_ACTION_BEAN.compositeAction = this;
		PT_AGENT_BUDGET_RANK_ACTION_BEAN.compositeAction = this;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	public String goToPT_AGENT_BUDGET_RANK(){
		/*FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();*/
		preTabClick();
		try{
			/*PT051_A_COMPOSITE_ACTION compositeAction = (PT051_A_COMPOSITE_ACTION) (new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION"));
			PT_AGENT_BUDGET_RANK_ACTION budgetRankAction = compositeAction.getPT_AGENT_BUDGET_RANK_ACTION_BEAN();*/
			System.out.println("The Sys Id of Budget block is: "+PT_AGENT_BUDGET_ACTION_BEAN.getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID());
			//budgetRankAction.whenNewBlockInstance(compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID());
			/*if("QUERY_UPDATE".equalsIgnoreCase(CommonUtils.getGlobalVariable("PT051_A_MODE"))){
				getPT_AGENT_BUDGET_RANK_ACTION_BEAN().postQuery();
			}*/
			//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PT051_A_COMPOSITE_ACTION", compositeAction);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "agentBudgetRank";
	}
	
	
	private void preTabClick() {
		int currentTabId = tabbedBar.getCurrentTabId();
		switch (currentTabId) {
		case 1:
			PT_AGENT_BUDGET_ACTION_BEAN.setBlockFlag(true);
		//	PT_GL_POLICY_ACTION_BEAN.saveRecord();
			setImmediate(false);
			break;
		case 2:
			PT_AGENT_BUDGET_RANK_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PT_AGENT_BUDGET_BREAKUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		}
	}
	
	private void setImmediate(boolean flag) {
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
		    TabItem item = tabIterator.next();
		    item.setImmediate(flag);

		}

	    }
	
	public String goToPT_AGENT_BUDGET(){
		/*FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		PT_AGENT_BUDGET_ACTION budgetAction =  (PT_AGENT_BUDGET_ACTION) sessionMap.get("PT051_A_PT_AGENT_BUDGET_ACTION");
		budgetAction.getWarningMap().clear();
		budgetAction.getErrorMap().clear();*/
		
		return "agentBudget";
				
	}
	
	public String goToPT_AGENT_BUDGET_BREAKUP(){
		try{
			PT051_A_COMPOSITE_ACTION compositeAction = (PT051_A_COMPOSITE_ACTION) (new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION"));
			PT_AGENT_BUDGET_BREAKUP_ACTION budgetBreakUpAction = compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN();
			System.out.println("The ");
			budgetBreakUpAction.whenNewBlockInstance(compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID());
			if("QUERY_UPDATE".equalsIgnoreCase(CommonUtils.getGlobalVariable("PT051_A_MODE"))){
				compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN().postQuery();
			}
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PT051_A_COMPOSITE_ACTION", compositeAction);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "agentBudgetBreakup";
	}

}
