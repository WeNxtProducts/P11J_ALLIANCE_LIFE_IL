package com.iii.pel.forms.PILT084;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.forms.PILP002_APAC.DUMMY_ACTION;
import com.iii.pel.forms.PILP008.PILP008_DUMMY_ACTION;
import com.iii.pel.forms.PILT013.PILT013_COMPOSITE_ACTION;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;


public class PILT084_COMPOSITE_ACTION_BEAN {
	public final static int TAB_DUMMY = 1;
	private TabbedBar tabbedBar;
    
	private PT_IL_PAYOUT_PROCESS_ACTION PT_IL_PAYOUT_PROCESS_ACTION_BEAN;
	private PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
	private PT_IL_OCD_DOC_TODO_LIST_ACTION PT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN;
	//Added by kavitha on 09.01.2020 for ocd process
	private PILP008_DUMMY_ACTION PILP008_DUMMY_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	//Added by kavitha on 10.02.2020 for orient
	private PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN;
	//End
	public PILT084_COMPOSITE_ACTION_BEAN() throws Exception{
		PT_IL_PAYOUT_PROCESS_ACTION_BEAN = new PT_IL_PAYOUT_PROCESS_ACTION();
		PT_IL_PAYOUT_PROCESS_ACTION_BEAN.compositeAction=this;
		PT_IL_PAYOUT_PROCESS_ACTION_BEAN.setBlockFlag(true);
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = new PM_IL_DOC_TODO_GROUP_ACTION();
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.compositeAction=this;
		PT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN = new PT_IL_OCD_DOC_TODO_LIST_ACTION();
		PT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN.compositeAction=this;
		//Added by kavitha on 09.01.2020 for ocd process
		PILP008_DUMMY_ACTION_BEAN = new PILP008_DUMMY_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		//Added by kavitha on 10.02.2020 for orient
		PILT013_COMPOSITE_ACTION_BEAN = new PILT013_COMPOSITE_ACTION();
		//End
		tabbedBar = new TabbedBar();
		try {
			tabbedBar.addTab(TAB_DUMMY,
					"#{PP039_A_APAC_COMPOSITE_ACTION.callPT_IL_PAYOUT_PROCESS}", Messages
							.getString("messageProperties_PILT084",
									"PILT084$PAYOUT_PROCESS$displayCaption"), false);
		} catch (Exception exc) {
			exc.printStackTrace();
			PT_IL_PAYOUT_PROCESS_ACTION_BEAN.getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			PT_IL_PAYOUT_PROCESS_ACTION_BEAN.getErrorMap().put("OK", exc.getMessage());
		}
	}

	
	public PT_IL_PAYOUT_PROCESS_ACTION getPT_IL_PAYOUT_PROCESS_ACTION_BEAN() {
		return PT_IL_PAYOUT_PROCESS_ACTION_BEAN;
	}


	public void setPT_IL_PAYOUT_PROCESS_ACTION_BEAN(
			PT_IL_PAYOUT_PROCESS_ACTION pT_IL_PAYOUT_PROCESS_ACTION_BEAN) {
		PT_IL_PAYOUT_PROCESS_ACTION_BEAN = pT_IL_PAYOUT_PROCESS_ACTION_BEAN;
	}


	public String callPT_IL_PAYOUT_PROCESS() {
		preTabClick();
		return "PILT084_PT_IL_PAYOUT_PROCESS";
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

	private void preTabClick() {
		int currentTabId = tabbedBar.getCurrentTabId();
		switch (currentTabId) {
		case 1:
			PT_IL_PAYOUT_PROCESS_ACTION_BEAN.setBlockFlag(true);
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
	public static int getTAB_DUMMY() {
		return TAB_DUMMY;
	}


	public PM_IL_DOC_TODO_GROUP_ACTION getPM_IL_DOC_TODO_GROUP_ACTION_BEAN() {
		return PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
	}


	public void setPM_IL_DOC_TODO_GROUP_ACTION_BEAN(
			PM_IL_DOC_TODO_GROUP_ACTION pM_IL_DOC_TODO_GROUP_ACTION_BEAN) {
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = pM_IL_DOC_TODO_GROUP_ACTION_BEAN;
	}


	public PT_IL_OCD_DOC_TODO_LIST_ACTION getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN() {
		return PT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN;
	}


	public void setPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN(
			PT_IL_OCD_DOC_TODO_LIST_ACTION pT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN) {
		PT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN = pT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN;
	}


	public PILP008_DUMMY_ACTION getPILP008_DUMMY_ACTION_BEAN() {
		return PILP008_DUMMY_ACTION_BEAN;
	}


	public void setPILP008_DUMMY_ACTION_BEAN(PILP008_DUMMY_ACTION pILP008_DUMMY_ACTION_BEAN) {
		PILP008_DUMMY_ACTION_BEAN = pILP008_DUMMY_ACTION_BEAN;
	}


	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}


	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dUMMY_ACTION_BEAN) {
		DUMMY_ACTION_BEAN = dUMMY_ACTION_BEAN;
	}


	public PILT013_COMPOSITE_ACTION getPILT013_COMPOSITE_ACTION_BEAN() {
		return PILT013_COMPOSITE_ACTION_BEAN;
	}


	public void setPILT013_COMPOSITE_ACTION_BEAN(
			PILT013_COMPOSITE_ACTION pILT013_COMPOSITE_ACTION_BEAN) {
		PILT013_COMPOSITE_ACTION_BEAN = pILT013_COMPOSITE_ACTION_BEAN;
	}

	
	
	 

}
