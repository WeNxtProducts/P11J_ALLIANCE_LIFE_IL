package com.iii.pel.forms.PILP053_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILP053_APAC_COMPOSITE_ACTION {
	public final static int TAB_PT_IL_SUR_MAT_VALUES = 1;
	public final static int TAB_SURRENDER = 2;
	public final static int TAB_PW_IL_REVIEW_MED_DTL = 3;
	public final static int TAB_CTRL = 4;
	public final static int TAB_BP = 5;
	private TabbedBar tabbedBar;
	private PT_IL_SUR_MAT_VALUES_ACTION PT_IL_SUR_MAT_VALUES_ACTION_BEAN;
	private SURRENDER_ACTION SURRENDER_ACTION_BEAN;
	private PW_IL_REVIEW_MED_DTL_ACTION PW_IL_REVIEW_MED_DTL_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;

	public String callPT_IL_SUR_MAT_VALUES() {
		preTabClick();
		return "PILP053_APAC_PT_IL_SUR_MAT_VALUES";

	}

	public String callSURRENDER() {
		preTabClick();
		return "PILP053_APAC_SURRENDER";

	}

	public String callPW_IL_REVIEW_MED_DTL() {
		preTabClick();
		return "PILP053_APAC_PW_IL_REVIEW_MED_DTL";

	}

	public String callCTRL() {
		preTabClick();
		return "PILP053_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILP053_APAC_BP";

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
			PT_IL_SUR_MAT_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			SURRENDER_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PW_IL_REVIEW_MED_DTL_ACTION_BEAN.setBlockFlag(true);
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

	public void setPT_IL_SUR_MAT_VALUES_ACTION_BEAN(
			PT_IL_SUR_MAT_VALUES_ACTION PT_IL_SUR_MAT_VALUES_ACTION_BEAN) {
		this.PT_IL_SUR_MAT_VALUES_ACTION_BEAN = PT_IL_SUR_MAT_VALUES_ACTION_BEAN;

	}

	public PT_IL_SUR_MAT_VALUES_ACTION getPT_IL_SUR_MAT_VALUES_ACTION_BEAN() {
		return this.PT_IL_SUR_MAT_VALUES_ACTION_BEAN;

	}

	public void setSURRENDER_ACTION_BEAN(SURRENDER_ACTION SURRENDER_ACTION_BEAN) {
		this.SURRENDER_ACTION_BEAN = SURRENDER_ACTION_BEAN;

	}

	public SURRENDER_ACTION getSURRENDER_ACTION_BEAN() {
		return this.SURRENDER_ACTION_BEAN;

	}

	public void setPW_IL_REVIEW_MED_DTL_ACTION_BEAN(
			PW_IL_REVIEW_MED_DTL_ACTION PW_IL_REVIEW_MED_DTL_ACTION_BEAN) {
		this.PW_IL_REVIEW_MED_DTL_ACTION_BEAN = PW_IL_REVIEW_MED_DTL_ACTION_BEAN;

	}

	public PW_IL_REVIEW_MED_DTL_ACTION getPW_IL_REVIEW_MED_DTL_ACTION_BEAN() {
		return this.PW_IL_REVIEW_MED_DTL_ACTION_BEAN;

	}


	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dUMMY_ACTION_BEAN) {
		DUMMY_ACTION_BEAN = dUMMY_ACTION_BEAN;
	}

	public PILP053_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PT_IL_SUR_MAT_VALUES_ACTION_BEAN = new PT_IL_SUR_MAT_VALUES_ACTION();
		SURRENDER_ACTION_BEAN = new SURRENDER_ACTION();
		PW_IL_REVIEW_MED_DTL_ACTION_BEAN = new PW_IL_REVIEW_MED_DTL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();

		PT_IL_SUR_MAT_VALUES_ACTION_BEAN.compositeAction = this;
		SURRENDER_ACTION_BEAN.compositeAction = this;
		PW_IL_REVIEW_MED_DTL_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;

		try {
			

		} catch (Exception exc) {
			exc.printStackTrace();

		}

	}

}
