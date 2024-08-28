package com.iii.pel.forms.PILT021;

import java.util.ArrayList;
import java.util.Iterator;



import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/*Modified by Janani on 05.09.2017 for ZBILQC-1732415*/
/*public class PILT021_COMPOSITE_ACTION*/ 

public class PILT021_COMPOSITE_ACTION extends CommonAction {

/*End of ZBILQC-1732415*/
	public final static int TAB_PT_IL_WITHDRAWAL = 1;
	public final static int TAB_PT_IL_WITHDRAWAL_CHARGE = 2;
	public final static int TAB_PT_IL_FUND_TRAN_DTL = 3;
	//public final static int TAB_PT_IL_TRAN_STATUS = 4;
	public final static int TAB_PM_IL_DOC_TODO_GROUP = 5;
	//public final static int TAB_PT_IL_DOC_TODO_LIST_STATUS = 6;
	public final static int TAB_PT_IL_WITHDRAWAL_UNIT = 7;
	/*
	 * public final static int TAB_CTRL1 = 8; public final static int TAB_CTRL =
	 * 9; public final static int TAB_BP = 10;
	 */
	private TabbedBar tabbedBar;
	private PT_IL_WITHDRAWAL_ACTION PT_IL_WITHDRAWAL_ACTION_BEAN;
	private PT_IL_WITHDRAWAL_CHARGE_ACTION PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN;
	private PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION_BEAN;
	private PT_IL_TRAN_STATUS_ACTION PT_IL_TRAN_STATUS_ACTION_BEAN;
	private PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
	private PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;
	private PT_IL_WITHDRAWAL_UNIT_ACTION PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN;
	private CTRL1_ACTION CTRL1_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	private BP_ACTION BP_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	public String callPT_IL_WITHDRAWAL() {
		getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap().clear();
		preTabClick();
		return "PILT021_PT_IL_WITHDRAWAL";

	}

	public String callPT_IL_WITHDRAWAL_CHARGE() {
		getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN().getErrorMap().clear();
		preTabClick();
		return "PILT021_PT_IL_WITHDRAWAL_CHARGE";

	}

	public String callPT_IL_FUND_TRAN_DTL() {
		getPT_IL_FUND_TRAN_DTL_ACTION_BEAN().getErrorMap().clear();
		preTabClick();
		return "PILT021_PT_IL_FUND_TRAN_DTL";

	}

	public String callPT_IL_TRAN_STATUS() {
		preTabClick();
		return "PILT021_PT_IL_TRAN_STATUS";

	}

	public String callPM_IL_DOC_TODO_GROUP() {
		preTabClick();
		return "PILT021_PM_IL_DOC_TODO_GROUP";

	}

	public String callPT_IL_DOC_TODO_LIST_STATUS() {
		preTabClick();
		return "PILT021_PT_IL_DOC_TODO_LIST_STATUS";

	}

	public String callPT_IL_WITHDRAWAL_UNIT() {
		preTabClick();
		return "PILT021_PT_IL_WITHDRAWAL_UNIT";

	}

	public String callCTRL1() {
		preTabClick();
		return "PILT021_CTRL1";

	}

	public String callCTRL() {
		preTabClick();
		return "PILT021_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILT021_BP";

	}

	public String navigationEnabled() {
		
		/*Added by Janani on 05.09.2017 for ZBILQC-1732415*/
		getErrorMap().clear();
		
		/*End of ZBILQC-1732415*/
		
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
			PT_IL_WITHDRAWAL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN.setBlockFlag(true);
			/*Commentted by saritha on 27-07-2017 for withdrawal processing screen postrecord not committed,
			any link&button click system hanging.preTabClick not calling postrecord*/ 
			
			///PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN.postRecord(null);
			/*End*/
			setImmediate(false);
			break;
		case 3:
			PT_IL_FUND_TRAN_DTL_ACTION_BEAN.setBlockFlag(true);
			/*Commentted by saritha on 27-07-2017 for withdrawal processing screen postrecord not committed,
			any link&button click postrecord calling so, system hanging.preTabClick not calling postrecord*/ 
			
			//PT_IL_FUND_TRAN_DTL_ACTION_BEAN.postRecord(null);
			/*End*/
			setImmediate(false);
			break;
		case 4:
			PT_IL_TRAN_STATUS_ACTION_BEAN.setBlockFlag(true);
			/*Commentted by saritha on 27-07-2017 for withdrawal processing screen postrecord not committed,
			any link&button click postrecord calling so, system hanging.preTabClick not calling postrecord*/ 
			
			//PT_IL_TRAN_STATUS_ACTION_BEAN.postRecord(null);
			/*End*/
			setImmediate(false);
			break;
		case 5:
			PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setBlockFlag(true);
			/*Added by saritha on on 12-12-2017 for ssp call id ZBLIFE-1457793*/
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setBlockFlag(true);
			/*End*/
			
			/*Commentted by saritha on 27-07-2017 for withdrawal processing screen postrecord not committed,
			any link&button click postrecord calling so, system hanging.preTabClick not calling postrecord*/ 
			
			//PM_IL_DOC_TODO_GROUP_ACTION_BEAN.postRecord(null);
			/*End*/
			setImmediate(false);
			break;
		case 6:
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setBlockFlag(true);
			/*Commentted by saritha on 27-07-2017 for withdrawal processing screen postrecord not committed,
			any link&button click postrecord calling so, system hanging.preTabClick not calling postrecord*/ 
			
			//PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.postRecord(null);
			/*End*/
			setImmediate(false);
			break;
		case 7:
			PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN.setBlockFlag(true);
			/*Commentted by saritha on 27-07-2017 for withdrawal processing screen postrecord not committed,
			any link&button click postrecord calling so, system hanging.preTabClick not calling postrecord*/ 
			
			//PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN.postRecord(null);
			/*End*/
			setImmediate(false);
			break;
		case 8:
			CTRL1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 9:
			CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 10:
			BP_ACTION_BEAN.setBlockFlag(true);
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

	public void setPT_IL_WITHDRAWAL_ACTION_BEAN(
			PT_IL_WITHDRAWAL_ACTION PT_IL_WITHDRAWAL_ACTION_BEAN) {
		this.PT_IL_WITHDRAWAL_ACTION_BEAN = PT_IL_WITHDRAWAL_ACTION_BEAN;

	}

	public PT_IL_WITHDRAWAL_ACTION getPT_IL_WITHDRAWAL_ACTION_BEAN() {
		return this.PT_IL_WITHDRAWAL_ACTION_BEAN;

	}

	public void setPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN(
			PT_IL_WITHDRAWAL_CHARGE_ACTION PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN) {
		this.PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN = PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN;

	}

	public PT_IL_WITHDRAWAL_CHARGE_ACTION getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN() {
		return this.PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN;

	}

	public void setPT_IL_FUND_TRAN_DTL_ACTION_BEAN(
			PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION_BEAN) {
		this.PT_IL_FUND_TRAN_DTL_ACTION_BEAN = PT_IL_FUND_TRAN_DTL_ACTION_BEAN;

	}

	public PT_IL_FUND_TRAN_DTL_ACTION getPT_IL_FUND_TRAN_DTL_ACTION_BEAN() {
		return this.PT_IL_FUND_TRAN_DTL_ACTION_BEAN;

	}

	public void setPT_IL_TRAN_STATUS_ACTION_BEAN(
			PT_IL_TRAN_STATUS_ACTION PT_IL_TRAN_STATUS_ACTION_BEAN) {
		this.PT_IL_TRAN_STATUS_ACTION_BEAN = PT_IL_TRAN_STATUS_ACTION_BEAN;

	}

	public PT_IL_TRAN_STATUS_ACTION getPT_IL_TRAN_STATUS_ACTION_BEAN() {
		return this.PT_IL_TRAN_STATUS_ACTION_BEAN;

	}

	public void setPM_IL_DOC_TODO_GROUP_ACTION_BEAN(
			PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN) {
		this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN = PM_IL_DOC_TODO_GROUP_ACTION_BEAN;

	}

	public PM_IL_DOC_TODO_GROUP_ACTION getPM_IL_DOC_TODO_GROUP_ACTION_BEAN() {
		return this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN;

	}

	public void setPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(
			PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN) {
		this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;

	}

	public PT_IL_DOC_TODO_LIST_STATUS_ACTION getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN() {
		return this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;

	}

	public void setPT_IL_WITHDRAWAL_UNIT_ACTION_BEAN(
			PT_IL_WITHDRAWAL_UNIT_ACTION PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN) {
		this.PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN = PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN;

	}

	public PT_IL_WITHDRAWAL_UNIT_ACTION getPT_IL_WITHDRAWAL_UNIT_ACTION_BEAN() {
		return this.PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN;

	}

	public void setCTRL1_ACTION_BEAN(CTRL1_ACTION CTRL1_ACTION_BEAN) {
		this.CTRL1_ACTION_BEAN = CTRL1_ACTION_BEAN;

	}

	public CTRL1_ACTION getCTRL1_ACTION_BEAN() {
		return this.CTRL1_ACTION_BEAN;

	}

	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
		this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

	}

	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return this.CTRL_ACTION_BEAN;

	}

	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN) {
		this.BP_ACTION_BEAN = BP_ACTION_BEAN;

	}

	public BP_ACTION getBP_ACTION_BEAN() {
		return this.BP_ACTION_BEAN;

	}

	/*Added by gopi for partial withdrawal process on 01/07/17*/

	private PILT021_PRINT_ACTION PILT021_PRINT_ACTION_BEAN;
	
	public PILT021_PRINT_ACTION getPILT021_PRINT_ACTION_BEAN() {
		return PILT021_PRINT_ACTION_BEAN;
	}

	public void setPILT021_PRINT_ACTION_BEAN(
			PILT021_PRINT_ACTION pILT021_PRINT_ACTION_BEAN) {
		PILT021_PRINT_ACTION_BEAN = pILT021_PRINT_ACTION_BEAN;
	}

	//end
	
	
	/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
	private PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN;
	public PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION getPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN() {
		return PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN;
	}

	public void setPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN(
			PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION pT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN) {
		PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN = pT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN;
	}
	/*End*/	
	public PILT021_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_IL_WITHDRAWAL_ACTION_BEAN = new PT_IL_WITHDRAWAL_ACTION();
		PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN = new PT_IL_WITHDRAWAL_CHARGE_ACTION();
		PT_IL_FUND_TRAN_DTL_ACTION_BEAN = new PT_IL_FUND_TRAN_DTL_ACTION();
		PT_IL_TRAN_STATUS_ACTION_BEAN = new PT_IL_TRAN_STATUS_ACTION();
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = new PM_IL_DOC_TODO_GROUP_ACTION();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = new PT_IL_DOC_TODO_LIST_STATUS_ACTION();
		PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN = new PT_IL_WITHDRAWAL_UNIT_ACTION();
		CTRL1_ACTION_BEAN = new CTRL1_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		/*Added by gopi for partial withdrawal process on 01/07/17*/
		PILT021_PRINT_ACTION_BEAN = new PILT021_PRINT_ACTION();
		PILT021_PRINT_ACTION_BEAN.compositeAction =this;

		/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
		PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN = new PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION();
		PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN.compositeAction = this;
		/*End*/
		
		//end
		
		PT_IL_WITHDRAWAL_ACTION_BEAN.compositeAction = this;
		PT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN.compositeAction = this;
		PT_IL_FUND_TRAN_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_TRAN_STATUS_ACTION_BEAN.compositeAction = this;
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.compositeAction = this;
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.compositeAction = this;
		PT_IL_WITHDRAWAL_UNIT_ACTION_BEAN.compositeAction = this;
		CTRL1_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try {
			tabbedBar.addTab(TAB_PT_IL_WITHDRAWAL,
					"#{PILT021_COMPOSITE_ACTION.callPT_IL_WITHDRAWAL}",
					Messages.getString("messageProperties_PILT021",
							"PILT021$PT_IL_WITHDRAWAL$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_WITHDRAWAL_CHARGE,
					"#{PILT021_COMPOSITE_ACTION.callPT_IL_WITHDRAWAL_CHARGE}",
					Messages.getString("messageProperties_PILT021",
							"PILT021$PT_IL_WITHDRAWAL_CHARGE$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PT_IL_FUND_TRAN_DTL,
					"#{PILT021_COMPOSITE_ACTION.callPT_IL_FUND_TRAN_DTL}",
					Messages.getString("messageProperties_PILT021",
							"PILT021$PT_IL_FUND_TRAN_DTL$displayCaption"),
					false);
		/*	tabbedBar.addTab(TAB_PT_IL_TRAN_STATUS,
					"#{PILT021_COMPOSITE_ACTION.callPT_IL_TRAN_STATUS}",
					Messages.getString("messageProperties_PILT021",
							"PILT021$PT_IL_TRAN_STATUS$displayCaption"), false);*/
			tabbedBar.addTab(TAB_PM_IL_DOC_TODO_GROUP,
					"#{PILT021_COMPOSITE_ACTION.callPM_IL_DOC_TODO_GROUP}",
					Messages.getString("messageProperties_PILT021",
							"PILT021$PM_IL_DOC_TODO_GROUP$displayCaption"),
					false);
			/*tabbedBar
					.addTab(
							TAB_PT_IL_DOC_TODO_LIST_STATUS,
							"#{PILT021_COMPOSITE_ACTION.callPT_IL_DOC_TODO_LIST_STATUS}",
							Messages
									.getString("messageProperties_PILT021",
											"PILT021$PT_IL_DOC_TODO_LIST_STATUS$displayCaption"),
							false);*/
			tabbedBar.addTab(TAB_PT_IL_WITHDRAWAL_UNIT,
					"#{PILT021_COMPOSITE_ACTION.callPT_IL_WITHDRAWAL_UNIT}",
					Messages.getString("messageProperties_PILT021",
							"PILT021$PT_IL_WITHDRAWAL_UNIT$displayCaption"),
					false);
			/*
			 * tabbedBar.addTab(TAB_CTRL1,
			 * "#{PILT021_COMPOSITE_ACTION.callCTRL1}",
			 * Messages.getString("messageProperties_PILT021",
			 * "PILT021$CTRL1$displayCaption"), false);
			 * tabbedBar.addTab(TAB_CTRL,
			 * "#{PILT021_COMPOSITE_ACTION.callCTRL}",
			 * Messages.getString("messageProperties_PILT021",
			 * "PILT021$CTRL$displayCaption"), false); tabbedBar.addTab(TAB_BP,
			 * "#{PILT021_COMPOSITE_ACTION.callBP}",
			 * Messages.getString("messageProperties_PILT021",
			 * "PILT021$BP$displayCaption"), false);
			 */

		} catch (Exception exc) {
			PT_IL_WITHDRAWAL_ACTION_BEAN.getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			PT_IL_WITHDRAWAL_ACTION_BEAN.getErrorMap().put(
					"PILT021_COMPOSITE_ACTION", exc.getMessage());
		}
	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTIONBEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
}
