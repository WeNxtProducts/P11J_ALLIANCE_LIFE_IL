package com.iii.pel.forms.PILP109_APAC;

public class PILP109_APAC_COMPOSITE_ACTION {
	public final static int TAB_BP = 1;
	public final static int TAB_CTRL = 2;

	private PILP109_APAC_DUMMY_ACTION DUMMY_ACTION = null;

	public String callBP() {
		preTabClick();
		return "PILP109_APAC_BP";

	}

	public String callCTRL() {
		preTabClick();
		return "PILP109_APAC_CTRL";

	}

	public String navigationEnabled() {
		setImmediate(true);
		return "";

	}

	private void setImmediate(boolean flag) {/*
	 * ArrayList<TabItem>
	 * tabItemList =
	 * tabbedBar.getTabList();
	 * Iterator<TabItem>
	 * tabIterator =
	 * tabItemList.iterator(); while
	 * (tabIterator.hasNext()) {
	 * TabItem item =
	 * tabIterator.next();
	 * item.setImmediate(flag); }
	 * 
	 */
	}

	/**
	 * @return the dUMMY_ACTION
	 */
	public PILP109_APAC_DUMMY_ACTION getDUMMY_ACTION() {
		return DUMMY_ACTION;
	}

	/**
	 * @param dummy_action
	 *            the dUMMY_ACTION to set
	 */
	public void setDUMMY_ACTION(PILP109_APAC_DUMMY_ACTION dummy_action) {
		DUMMY_ACTION = dummy_action;
	}

	private void preTabClick() {/*
	 * int currentTabId =
	 * tabbedBar.getCurrentTabId();
	 * switch(currentTabId){ case 1
	 * :BP_ACTION_BEAN.setBlockFlag(true);
	 * setImmediate(false); break; case 2
	 * :CTRL_ACTION_BEAN.setBlockFlag(true);
	 * setImmediate(false); break; }
	 * 
	 */
	}

	public PILP109_APAC_COMPOSITE_ACTION() {
		DUMMY_ACTION = new PILP109_APAC_DUMMY_ACTION();
	}

}
