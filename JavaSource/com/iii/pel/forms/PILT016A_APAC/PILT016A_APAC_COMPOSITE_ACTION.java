package com.iii.pel.forms.PILT016A_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILT016A_APAC_COMPOSITE_ACTION {

	public final static int TAB_PT_IL_DEPOSIT = 1;
    public final static int TAB_PT_IL_PREM_COLL_1 = 2;
    public final static int TAB_PT_IL_PREM_COLL_2 = 3;
    
    private TabbedBar tabbedBar;
    private PT_IL_DEPOSIT_ACTION PT_IL_DEPOSIT_ACTION_BEAN;
    private DUMMY DUMMY_BEAN;
    private PT_IL_PREM_COLL_1_ACTION PT_IL_PREM_COLL_1_ACTION_BEAN;
    private PT_IL_PREM_COLL_2_ACTION PT_IL_PREM_COLL_2_ACTION_BEAN;
    private PT_IL_DEPOSIT_APPROVAL_ACTION PT_IL_DEPOSIT_APPROVAL_ACTION_BEAN;
    private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN;
    private POLICY_DET_ACTION POLICY_DET_ACTION_BEAN;
    private CTRL CTRL_BEAN=null;
    
    public String callPT_IL_DEPOSIT() {
    	preTabClick();
    	return "PILT016A_APAC_PT_IL_DEPOSIT";

        }

        public String callPT_IL_PREM_COLL_1() {
    	preTabClick();
    	return "PILT016A_APAC_PT_IL_PREM_COLL_1";

        }

        public PT_IL_DEPOSIT_APPROVAL_ACTION getPT_IL_DEPOSIT_APPROVAL_ACTION_BEAN() {
			return PT_IL_DEPOSIT_APPROVAL_ACTION_BEAN;
		}

		public void setPT_IL_DEPOSIT_APPROVAL_ACTION_BEAN(
				PT_IL_DEPOSIT_APPROVAL_ACTION pt_il_deposit_approval_action_bean) {
			PT_IL_DEPOSIT_APPROVAL_ACTION_BEAN = pt_il_deposit_approval_action_bean;
		}

		public String callPT_IL_PREM_COLL_2() {
    	preTabClick();
    	return "PILT016A_APAC_PT_IL_PREM_COLL_2";

        }
    
    public TabbedBar getTabbedBar() {
		return tabbedBar;
	}
	
	
	
	
	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	public PT_IL_DEPOSIT_ACTION getPT_IL_DEPOSIT_ACTION_BEAN() {
		return PT_IL_DEPOSIT_ACTION_BEAN;
	}
	public void setPT_IL_DEPOSIT_ACTION_BEAN(
			PT_IL_DEPOSIT_ACTION pt_il_deposit_action_bean) {
		PT_IL_DEPOSIT_ACTION_BEAN = pt_il_deposit_action_bean;
	}
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}
	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}
	public PT_IL_PREM_COLL_1_ACTION getPT_IL_PREM_COLL_1_ACTION_BEAN() {
		return PT_IL_PREM_COLL_1_ACTION_BEAN;
	}
	public void setPT_IL_PREM_COLL_1_ACTION_BEAN(
			PT_IL_PREM_COLL_1_ACTION pt_il_prem_coll_1_action_bean) {
		PT_IL_PREM_COLL_1_ACTION_BEAN = pt_il_prem_coll_1_action_bean;
	}
	public PT_IL_PREM_COLL_2_ACTION getPT_IL_PREM_COLL_2_ACTION_BEAN() {
		return PT_IL_PREM_COLL_2_ACTION_BEAN;
	}
	public void setPT_IL_PREM_COLL_2_ACTION_BEAN(
			PT_IL_PREM_COLL_2_ACTION pt_il_prem_coll_2_action_bean) {
		PT_IL_PREM_COLL_2_ACTION_BEAN = pt_il_prem_coll_2_action_bean;
	}
    
	
	private void setImmediate(boolean flag) {
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
		    TabItem item = tabIterator.next();
		    item.setImmediate(flag);

		}

	    }
	
	/*Modified by Janani on 12.06.2018 for FSD_IL_FLA_019*/
	/*PILT016A_APAC_COMPOSITE_ACTION()*/
	public PILT016A_APAC_COMPOSITE_ACTION(){
		/*End*/
		tabbedBar = new TabbedBar();
		CTRL_BEAN = new CTRL();
		PT_IL_DEPOSIT_ACTION_BEAN = new PT_IL_DEPOSIT_ACTION();
		PT_IL_PREM_COLL_1_ACTION_BEAN = new PT_IL_PREM_COLL_1_ACTION();
		PT_IL_PREM_COLL_2_ACTION_BEAN = new PT_IL_PREM_COLL_2_ACTION();
		PT_IL_DEPOSIT_APPROVAL_ACTION_BEAN = new PT_IL_DEPOSIT_APPROVAL_ACTION();
		PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		POLICY_DET_ACTION_BEAN = new POLICY_DET_ACTION();
		DUMMY_BEAN = new DUMMY();
		PT_IL_DEPOSIT_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_1_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_2_ACTION_BEAN.compositeAction = this;
		PT_IL_DEPOSIT_APPROVAL_ACTION_BEAN.compositeAction = this;
		DUMMY_BEAN.compositeAction = this; 
		PT_IL_PYMT_DTLS_ACTION_BEAN.compositeAction = this;
		
		
		try {
		     tabbedBar.addTab(TAB_PT_IL_DEPOSIT,
			    "#{PILT016A_APAC_COMPOSITE_ACTION.callPT_IL_DEPOSIT}",
			    "Deposit", false);
		     

		    tabbedBar.addTab(TAB_PT_IL_PREM_COLL_1,
			    "#{PILT016A_APAC_COMPOSITE_ACTION.callPT_IL_PREM_COLL_1}",
			    "Unpaid Collection", false);
		    
		    
		    
		  tabbedBar.addTab(TAB_PT_IL_PREM_COLL_2,
			    "#{PILT016A_APAC_COMPOSITE_ACTION.callPT_IL_PREM_COLL_2}",
			    "Paid Collection",
			    false);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	 private void preTabClick() {
			int currentTabId = tabbedBar.getCurrentTabId();
			switch (currentTabId) {
			case 1:
			    PT_IL_DEPOSIT_ACTION_BEAN.setBlockFlag(true);
			    setImmediate(false);
			    break;
			case 2:
			    PT_IL_PREM_COLL_1_ACTION_BEAN.setBlockFlag(true);
			    setImmediate(false);
			    break;
			case 3:
			    PT_IL_PREM_COLL_2_ACTION_BEAN.setBlockFlag(true);
			    setImmediate(false);
			    break;


		    }
	 }

	/**
	 * @return the cTRL_BEAN
	 */
	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	/**
	 * @param ctrl_bean the cTRL_BEAN to set
	 */
	public void setCTRL_BEAN(CTRL ctrl_bean) {
		CTRL_BEAN = ctrl_bean;
	}

	/**
	 * @return the pT_IL_PYMT_DTLS_ACTION_BEAN
	 */
	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN() {
		return PT_IL_PYMT_DTLS_ACTION_BEAN;
	}

	/**
	 * @param pt_il_pymt_dtls_action_bean the pT_IL_PYMT_DTLS_ACTION_BEAN to set
	 */
	public void setPT_IL_PYMT_DTLS_ACTION_BEAN(
			PT_IL_PYMT_DTLS_ACTION pt_il_pymt_dtls_action_bean) {
		PT_IL_PYMT_DTLS_ACTION_BEAN = pt_il_pymt_dtls_action_bean;
	}

	/**
	 * @return the pOLICY_DET_ACTION_BEAN
	 */
	public POLICY_DET_ACTION getPOLICY_DET_ACTION_BEAN() {
		return POLICY_DET_ACTION_BEAN;
	}

	/**
	 * @param policy_det_action_bean the pOLICY_DET_ACTION_BEAN to set
	 */
	public void setPOLICY_DET_ACTION_BEAN(POLICY_DET_ACTION policy_det_action_bean) {
		POLICY_DET_ACTION_BEAN = policy_det_action_bean;
	}
	
}
