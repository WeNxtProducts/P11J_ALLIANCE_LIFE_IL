package com.iii.pel.forms.PILM042;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.component.html.HtmlCommandButton;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILM042_COMPOSITE_ACTION {

	private HtmlCommandButton test;

	private PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN;
	private PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN;

	PM_IL_DATA_UPLOAD_DEFN_HDR claimESTAction = null;

	private TabbedBar tabbedBar;

	public PILM042_COMPOSITE_ACTION() {

		PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN = new PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION();
		PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN = new PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION();
		
		PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.compositeAction = this;
		PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN.compositeAction = this;

		this.tabbedBar = new TabbedBar();
		try {
			this.tabbedBar.addTab(1,"#{PILM042_COMPOSITE_ACTION.page_PM_IL_DATA_UPLOAD_HDR}","Data Upload Definition", false);
			this.tabbedBar.addTab(2,"#{PILM042_COMPOSITE_ACTION.page_PM_IL_DATA_UPLOAD_DTL}","Data Upload Definition Details", false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN() {
		return PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN;
	}

	public void setPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN(
			PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION pm_il_data_upload_defn_dtl_action_bean) {
		PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN = pm_il_data_upload_defn_dtl_action_bean;
	}

	public PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN() {
		return PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN;
	}

	public void setPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN(
			PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION pm_il_data_upload_defn_hdr_action_bean) {
		PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN = pm_il_data_upload_defn_hdr_action_bean;
	}

	public String page_PM_IL_DATA_UPLOAD_DTL() {
		PM_IL_DATA_UPLOAD_DEFN_HDR_DELEGATE delegate = new PM_IL_DATA_UPLOAD_DEFN_HDR_DELEGATE();
		PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION detailAction = null;
		PM_IL_DATA_UPLOAD_DEFN_DTL detailBean = null;
		detailAction =this.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN();
		detailBean = delegate.populateDetailValues(this);
		if(detailBean == null){
			detailBean = new PM_IL_DATA_UPLOAD_DEFN_DTL();
		}
		detailAction.setPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN(detailBean);
		
		 return "definitionDetail";
	}

	public String page_PM_IL_DATA_UPLOAD_HDR() {
		return "definitionHeader";
	}

	private void preTabClick(){
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
			case 1 :PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN.saveRecord();
			break;
			case 2 :PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			/*case 3 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);*/
			//break;
			
		}
		
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
	
	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

}
