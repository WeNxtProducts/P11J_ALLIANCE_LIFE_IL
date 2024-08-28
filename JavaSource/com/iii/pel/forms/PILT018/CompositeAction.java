package com.iii.pel.forms.PILT018;

import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.utils.CommonUtils;

public class CompositeAction {
	
	private PT_IL_BROK_ADV_HDR_ACTION parentAction;
	
	private PT_IL_BROK_ADV_DTL_ACTION childAction;
	
	private TabbedBar tabbedBar;
	
	public DUMMY_ACTION DUMMY_ACTION =null; 
	
	public CompositeAction()
	{
		
		parentAction = new PT_IL_BROK_ADV_HDR_ACTION();
		childAction = new  PT_IL_BROK_ADV_DTL_ACTION();
		DUMMY_ACTION = new DUMMY_ACTION();
		parentAction.compositeAction = this;
		childAction.compositeAction = this;

		//tab Creation
		tabbedBar = new TabbedBar();
		try {
			// Adding tabs
			//               id  action   value       disabled
			tabbedBar.addTab(1, "PILT018_GO_MAIN", "Broker Management", false);
			tabbedBar.addTab(2, "#{PILT018_CompositeAction.gotoAdvanceDetails}", "Advance Details", false);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gotoAdvanceDetails(){
		String outcome = "PILT018_GO_GRID";
		
		// Restting Action Bean into session
		PT_IL_BROK_ADV_DTL_ACTION PT_IL_BROK_ADV_DTL_ACTION_BEAN = new PT_IL_BROK_ADV_DTL_ACTION();
		PT_IL_BROK_ADV_DTL_ACTION_BEAN.setBlockFlag(true);
		PT_IL_BROK_ADV_DTL_ACTION_BEAN.setFormFlag(true);
		CommonUtils.setGlobalObject("PT_IL_BROK_ADV_DTL_ACTION", 
				PT_IL_BROK_ADV_DTL_ACTION_BEAN);
		
		return outcome;
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



	public PT_IL_BROK_ADV_HDR_ACTION getParentAction() {
		return parentAction;
	}



	public void setParentAction(PT_IL_BROK_ADV_HDR_ACTION parentAction) {
		this.parentAction = parentAction;
	}



	public PT_IL_BROK_ADV_DTL_ACTION getChildAction() {
		return childAction;
	}



	public void setChildAction(PT_IL_BROK_ADV_DTL_ACTION childAction) {
		this.childAction = childAction;
	}

	/**
	 * @return the dUMMY_ACTION
	 */
	public DUMMY_ACTION getDUMMY_ACTION() {
		return DUMMY_ACTION;
	}

	/**
	 * @param dummy_action the dUMMY_ACTION to set
	 */
	public void setDUMMY_ACTION(DUMMY_ACTION dummy_action) {
		DUMMY_ACTION = dummy_action;
	}
}
