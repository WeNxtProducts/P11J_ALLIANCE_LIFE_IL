package com.iii.pel.forms.PILM200;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;


public class PILM200_COMPOSITE_ACTION {
	
	    public final static int TAB_PM_IL_PROD_GROUP_DTL_ACTION = 2;
	    public final static int TAB_PM_IL_PROD_GROUP_HDR_ACTION = 1;
	   	    private TabbedBar tabbedBar;
	    private PM_IL_PROD_GROUP_DTL_ACTION PM_IL_PROD_GROUP_DTL_ACTION_BEAN;
	    private PM_IL_PROD_GROUP_HDR_ACTION PM_IL_PROD_GROUP_HDR_ACTION_BEAN;
	    
	    
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

	    private void preTabClick() {
		int currentTabId = tabbedBar.getCurrentTabId();
		switch (currentTabId) {
		case 1:
			PM_IL_PROD_GROUP_DTL_ACTION_BEAN.setBlockFlag(true);
		    setImmediate(false);
		    break;
		case 2:
			PM_IL_PROD_GROUP_HDR_ACTION_BEAN.setBlockFlag(true);
		    setImmediate(false);
		    break;
		
		}

	    }

	    public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;

	    }

	    public TabbedBar getTabbedBar() {
		return this.tabbedBar;

	    }

	  	    
	    public String callPM_IL_PROD_GROUP_DTL_ACTION() {
	    	preTabClick();
	    	return "PILM200DETAIL";

	        }

	        public String callPM_IL_PROD_GROUP_HDR_ACTION() {
	    	preTabClick();
	    	return "PILM200execute";

	        }
	    
	    
	    
	    public PILM200_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
	    PM_IL_PROD_GROUP_DTL_ACTION_BEAN = new PM_IL_PROD_GROUP_DTL_ACTION();
	    PM_IL_PROD_GROUP_HDR_ACTION_BEAN = new PM_IL_PROD_GROUP_HDR_ACTION();
	    PM_IL_PROD_GROUP_DTL_ACTION_BEAN.compositeAction = this;
	    PM_IL_PROD_GROUP_HDR_ACTION_BEAN.compositeAction = this;
				try {
		     tabbedBar.addTab(TAB_PM_IL_PROD_GROUP_HDR_ACTION,
					    "#{PILM200_COMPOSITE_ACTION.callPM_IL_PROD_GROUP_HDR_ACTION}",
					    Messages.getString("messageProperties_PILM200",
						    "PILM200$PM_IL_PROD_GROUP_HDR_ACTION$Caption"), false);
		     tabbedBar.addTab(TAB_PM_IL_PROD_GROUP_DTL_ACTION,
		    		 "#{PILM200_COMPOSITE_ACTION.callPM_IL_PROD_GROUP_DTL_ACTION}",
		    		 Messages.getString("messageProperties_PILM200",
		    		 "PILM200$PM_IL_PROD_GROUP_DTL_ACTION$caption"), false);
		     

		} catch (Exception exc) {
		    // TODO Auto generated catch block;
		    exc.printStackTrace();

		}

	    }

		public PM_IL_PROD_GROUP_DTL_ACTION getPM_IL_PROD_GROUP_DTL_ACTION_BEAN() {
			return PM_IL_PROD_GROUP_DTL_ACTION_BEAN;
		}

		public void setPM_IL_PROD_GROUP_DTL_ACTION_BEAN(
				PM_IL_PROD_GROUP_DTL_ACTION pm_il_prod_group_dtl_action_bean) {
			PM_IL_PROD_GROUP_DTL_ACTION_BEAN = pm_il_prod_group_dtl_action_bean;
		}

		public PM_IL_PROD_GROUP_HDR_ACTION getPM_IL_PROD_GROUP_HDR_ACTION_BEAN() {
			return PM_IL_PROD_GROUP_HDR_ACTION_BEAN;
		}

		public void setPM_IL_PROD_GROUP_HDR_ACTION_BEAN(
				PM_IL_PROD_GROUP_HDR_ACTION pm_il_prod_group_hdr_action_bean) {
			PM_IL_PROD_GROUP_HDR_ACTION_BEAN = pm_il_prod_group_hdr_action_bean;
		}

	    

	 
	}


