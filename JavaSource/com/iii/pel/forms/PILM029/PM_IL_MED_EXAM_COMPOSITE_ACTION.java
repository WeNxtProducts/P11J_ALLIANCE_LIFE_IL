package com.iii.pel.forms.PILM029;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PM_IL_MED_EXAM_COMPOSITE_ACTION extends CommonAction {
	
	PM_IL_MED_EXAM_HDR_ACTION PM_IL_MED_EXAM_HDR_ACTION;
	PM_IL_MED_EXAM_DTL_ACTION PM_IL_MED_EXAM_DTL_ACTION;
	private TabbedBar tabbedBar;
	public static final int PM_IL_MED_EXAM_HDR = 1;
	public static final int PM_IL_MED_EXAM_DTL = 2;

	
	public PM_IL_MED_EXAM_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_IL_MED_EXAM_DTL_ACTION = new PM_IL_MED_EXAM_DTL_ACTION();
		PM_IL_MED_EXAM_HDR_ACTION = new PM_IL_MED_EXAM_HDR_ACTION();
		
		try{
		tabbedBar.addTab(PM_IL_MED_EXAM_HDR,
				"#{PM_IL_MED_EXAM_COMPOSITE_ACTION.callPM_IL_MED_EXAM_HDR}", Messages
						.getString("messageProperties_PILM029",
								"PILM029_MEDICAL_EXAM_HEADER"),
				false);
		tabbedBar.addTab(PM_IL_MED_EXAM_DTL,
				"#{PM_IL_MED_EXAM_COMPOSITE_ACTION.callPM_IL_MED_EXAM_DTL}", Messages
						.getString("messageProperties_PILM029",
								"PILM029_MEDICAL_EXAM_DETAILS"),
				false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PM_IL_MED_EXAM_DTL_ACTION.compositeAction = this;
		PM_IL_MED_EXAM_HDR_ACTION.compositeAction = this;
		
	}
	
	public String callPM_IL_MED_EXAM_HDR(){
		
		PM_IL_MED_EXAM_HDR_ACTION.setBlockFlag(true);
		setImmediate(true);
		return "PILM029_PM_IL_MED_EXAM_HDR";
	}
	
	public String callPM_IL_MED_EXAM_DTL(){
	
		PM_IL_MED_EXAM_DTL_ACTION.setBlockFlag(true);
		setImmediate(true);
		return "PILM029_PM_IL_MED_EXAM_DTL";
	}
	

	public String navigationEnabled(){
		setImmediate(true);
		return"";
	}
	
	private void setImmediate(boolean flag){
		 ArrayList<TabItem> tabItemList= tabbedBar.getTabList();
		 Iterator<TabItem> tabIterator = tabItemList.iterator();
		 while (tabIterator.hasNext()){
			 TabItem item = (TabItem) tabIterator.next(); 
			  item.setImmediate(flag);
		 }
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}


	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}


	public PM_IL_MED_EXAM_HDR_ACTION getPM_IL_MED_EXAM_HDR_ACTION() {
		return PM_IL_MED_EXAM_HDR_ACTION;
	}


	public void setPM_IL_MED_EXAM_HDR_ACTION(
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action) {
		PM_IL_MED_EXAM_HDR_ACTION = pm_il_med_exam_hdr_action;
	}


	public PM_IL_MED_EXAM_DTL_ACTION getPM_IL_MED_EXAM_DTL_ACTION() {
		return PM_IL_MED_EXAM_DTL_ACTION;
	}


	public void setPM_IL_MED_EXAM_DTL_ACTION(
			PM_IL_MED_EXAM_DTL_ACTION pm_il_med_exam_dtl_action) {
		PM_IL_MED_EXAM_DTL_ACTION = pm_il_med_exam_dtl_action;
	}
	

}
