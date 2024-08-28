package com.iii.pel.forms.PILM055_APAC;

import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.utils.CommonUtils;

public class CompositeAction {
	
	private PM_IL_FUND_SETUP_ACTION parentAction;
	
	private PM_IL_FUND_PRICE_DTL_ACTION childAction;
	
	private TabbedBar tabbedBar;
	
	public CompositeAction()
	{
		
		parentAction = new PM_IL_FUND_SETUP_ACTION();
		childAction = new  PM_IL_FUND_PRICE_DTL_ACTION();
		
		parentAction.PILM055_APAC_CompositeAction=this;
		childAction.PILM055_APAC_CompositeAction = this;
		
		//tab Creation
		tabbedBar = new TabbedBar();
		try {
			// Adding tabs
			//               id  action   value       disabled
			tabbedBar.addTab(1, "#{PILM055_APAC_CompositeAction.parentAction.goto_PM_IL_FUND_SETUP}", "Fund Master", false);
			tabbedBar.addTab(2, "#{PILM055_APAC_CompositeAction.parentAction.goto_PM_IL_PRICE_DTL}", "Unit Details", false);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	public String demoAction(){
		System.out.println("------------> Hey! Custom method is getting called");
		return "second";
	}



	public PM_IL_FUND_SETUP_ACTION getParentAction() {
		return parentAction;
	}



	public void setParentAction(PM_IL_FUND_SETUP_ACTION parentAction) {
		this.parentAction = parentAction;
	}



	public PM_IL_FUND_PRICE_DTL_ACTION getChildAction() {
		return childAction;
	}



	public void setChildAction(PM_IL_FUND_PRICE_DTL_ACTION childAction) {
		this.childAction = childAction;
	}
}
