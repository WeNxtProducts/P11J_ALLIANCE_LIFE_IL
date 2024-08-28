package com.iii.pel.forms.PILM024;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILM024_COMPOSITE_ACTION {

	private PM_IL_CLM_ACCOUNT_SETUP_ACTION PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN;
	private ControlBean CONTROLBEAN = null;
	private TabbedBar tabbedBar;

	public static final int documentSetup = 1;
	
	public String backToSearch(){
		PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN.setFormFlag(true);
		PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN.setBlockFlag(true);
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}

	public PILM024_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN = new PM_IL_CLM_ACCOUNT_SETUP_ACTION();
		// TODO controlBean.clone
		// CONTROLBEAN = new ControlBean();
		// CONTROLBEAN = CommonUtils.getControlBean();

		// tab Creation
		try {
			// Adding tabs
			// id action value disabled
			tabbedBar.addTab(documentSetup,
					"#{PILM024_COMPOSITE_ACTION.callDocumentSetup}", Messages
							.getString("messageProperties_PILM024",
									"PILM024$PM_IL_CLM_ACCOUNT_SETUP$TAB"),
					false);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN.compositeAction = this;
		
	}
	
	public void callDocumentSetup(){
		
	}

	public String disableTab(int tabId) {
		TabbedBar tabbedBar = null;
		tabbedBar = getTabbedBar();
		if (tabbedBar != null) {
			tabbedBar.setTabDisabled(tabId);

		}
		return null;
	}

	public String enableTab(int tabId) {
		TabbedBar tabbedBar = null;
		tabbedBar = getTabbedBar();
		if (tabbedBar != null) {
			tabbedBar.setTabEnabled(tabId);
		}
		return null;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
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
	
	/*public String retrieveTabId(){
		ExternalContext externalContext = null;
		HttpServletRequest request = null;
		HttpSession session = null;
		String tabId = null;
		FacesContext context = null;
		context = FacesContext.getCurrentInstance();
		if (context != null) {
			 externalContext = context.getExternalContext();
			if (externalContext != null) {
				request = (HttpServletRequest) externalContext.getRequest();
			}
			tabId = request.getParameter("tabid");
		}
		return tabId;	
	}*/
	


	public ControlBean getCONTROLBEAN() {
		return CONTROLBEAN;
	}

	public void setCONTROLBEAN(ControlBean controlbean) {
		CONTROLBEAN = controlbean;
	}

	public PM_IL_CLM_ACCOUNT_SETUP_ACTION getPM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN() {
		return PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN;
	}

	public void setPM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN(
			PM_IL_CLM_ACCOUNT_SETUP_ACTION pm_il_clm_account_setup_action_bean) {
		PM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN = pm_il_clm_account_setup_action_bean;
	}

}

