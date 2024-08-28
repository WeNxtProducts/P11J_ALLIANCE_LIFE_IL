package com.iii.pel.forms.PILM043;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;

public class PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION {

	PM_IL_RI_POOL_SETUP_ACTION PM_IL_RI_POOL_SETUP_ACTION;
	PM_IL_RI_POOL_COVER_ACTION PM_IL_RI_POOL_COVER_ACTION;
	PM_IL_RI_POOL_CUST_ACTION PM_IL_RI_POOL_CUST_ACTION;
	PM_IL_RI_CUST_CHRG_ACTION PM_IL_RI_CUST_CHRG_ACTION;
	PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION;
	
	private TabbedBar tabbedBar;

	public PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION() throws DBException{
		
		tabbedBar = new TabbedBar();
		PM_IL_RI_POOL_SETUP_ACTION = new PM_IL_RI_POOL_SETUP_ACTION();
		PM_IL_RI_POOL_COVER_ACTION = new PM_IL_RI_POOL_COVER_ACTION();
		PM_IL_RI_POOL_CUST_ACTION = new PM_IL_RI_POOL_CUST_ACTION();
		PM_IL_RI_CUST_CHRG_ACTION = new PM_IL_RI_CUST_CHRG_ACTION();
		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION = new PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION();
		/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1719314*/
		PM_IL_RI_POOL_CUST_ACTION.compositeAction=this;
		/*end*/
		
		
		
		try {
			
			tabbedBar.addTab(1, "#{PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION.callRIPoolSetup}", Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_POOL_CUST$TAB$RI_POOL_SETUP$caption"), false);
			tabbedBar.addTab(2, "#{PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION.callCoverDetails}", Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_POOL_CUST$TAB$COVER_DETAILS$caption"), false);
			tabbedBar.addTab(3, "#{PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION.callCustDetail}", Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_POOL_CUST$TAB$PM_IL_RI_POOL_CUST$caption"), false);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PM_IL_RI_POOL_SETUP_ACTION getPM_IL_RI_POOL_SETUP_ACTION() {
		return PM_IL_RI_POOL_SETUP_ACTION;
	}

	public void setPM_IL_RI_POOL_SETUP_ACTION(
			PM_IL_RI_POOL_SETUP_ACTION pm_il_ri_pool_setup_action) {
		PM_IL_RI_POOL_SETUP_ACTION = pm_il_ri_pool_setup_action;
	}	
	
	/*
	 * For Navigation 
	 */
	
	public String callRIPoolSetup(){
	
		System.out.println("pool setup.............");
		return "PILM043_PM_IL_RI_POOL_SETUP";
	}
	
	public String callCoverDetails(){
		
		PM_IL_RI_POOL_COVER_DELEGATE pm_il_ri_pool_cover_delegate = new PM_IL_RI_POOL_COVER_DELEGATE();
		getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().clear();
		List outputList = pm_il_ri_pool_cover_delegate.getCoverDetailsValues();
		if(outputList.size() > 0){
			
			getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().clear();
		
			for(int index = 0; index < outputList.size(); index++){
				PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) outputList.get(index);
				String coverCode = pm_il_ri_pool_cover.getRPCVR_CODE();
				String coverDesc = pm_il_ri_pool_cover_delegate.getRPCVR_DESC(coverCode);
				pm_il_ri_pool_cover.setUI_M_RPCVR_CODE_DESC(coverDesc);
				getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().add(pm_il_ri_pool_cover);
			}
			
			for(int i =0;i<getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().size();i++){
				PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().get(i);
				if(i==0){
					pm_il_ri_pool_cover.setRowSelected(true);
					getPM_IL_RI_POOL_COVER_ACTION().setPM_IL_RI_POOL_COVER_BEAN(pm_il_ri_pool_cover);
				}else{
					pm_il_ri_pool_cover.setRowSelected(false);
				}
			}
		}	
		return "PILM043_PM_IL_RI_POOL_COVER";
	}
	
	public String callCustDetail(){
		return "PILM043_PM_IL_RI_POOL_CUST";
	}
		
	
	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public PM_IL_RI_POOL_COVER_ACTION getPM_IL_RI_POOL_COVER_ACTION() {
		return PM_IL_RI_POOL_COVER_ACTION;
	}

	public void setPM_IL_RI_POOL_COVER_ACTION(
			PM_IL_RI_POOL_COVER_ACTION pm_il_ri_pool_cover_action) {
		PM_IL_RI_POOL_COVER_ACTION = pm_il_ri_pool_cover_action;
	}

	public PM_IL_RI_POOL_CUST_ACTION getPM_IL_RI_POOL_CUST_ACTION() {
		return PM_IL_RI_POOL_CUST_ACTION;
	}

	public void setPM_IL_RI_POOL_CUST_ACTION(
			PM_IL_RI_POOL_CUST_ACTION pm_il_ri_pool_cust_action) {
		PM_IL_RI_POOL_CUST_ACTION = pm_il_ri_pool_cust_action;
	}

	public PM_IL_RI_CUST_CHRG_ACTION getPM_IL_RI_CUST_CHRG_ACTION() {
		return PM_IL_RI_CUST_CHRG_ACTION;
	}

	public void setPM_IL_RI_CUST_CHRG_ACTION(
			PM_IL_RI_CUST_CHRG_ACTION pm_il_ri_cust_chrg_action) {
		PM_IL_RI_CUST_CHRG_ACTION = pm_il_ri_cust_chrg_action;
	}

	public PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION getPM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION() {
		return PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION;
	}

	public void setPM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION(
			PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION pm_il_ri_pool_setup_search_page_action) {
		PM_IL_RI_POOL_SETUP_SEARCH_PAGE_ACTION = pm_il_ri_pool_setup_search_page_action;
	}
	
	
	public String navigationEnabled() {
		setImmediate(true);
		return "";

	}

	private void setImmediate(boolean flag) {
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);

		}

	}

}
