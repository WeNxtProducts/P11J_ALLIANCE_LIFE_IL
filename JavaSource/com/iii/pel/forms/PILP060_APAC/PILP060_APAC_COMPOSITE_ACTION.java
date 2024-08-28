package com.iii.pel.forms.PILP060_APAC;

public class PILP060_APAC_COMPOSITE_ACTION {
	
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	
	private PT_IL_BONUS_ACTION PT_IL_BONUS_ACTION_BEAN;
	
	private PT_IL_PROCESS_ACTION PT_IL_PROCESS_ACTION_BEAN;

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

	public PT_IL_BONUS_ACTION getPT_IL_BONUS_ACTION_BEAN() {
		return PT_IL_BONUS_ACTION_BEAN;
	}

	public void setPT_IL_BONUS_ACTION_BEAN(
			PT_IL_BONUS_ACTION pt_il_bonus_action_bean) {
		PT_IL_BONUS_ACTION_BEAN = pt_il_bonus_action_bean;
	}

	public PT_IL_PROCESS_ACTION getPT_IL_PROCESS_ACTION_BEAN() {
		return PT_IL_PROCESS_ACTION_BEAN;
	}

	public void setPT_IL_PROCESS_ACTION_BEAN(
			PT_IL_PROCESS_ACTION pt_il_process_action_bean) {
		PT_IL_PROCESS_ACTION_BEAN = pt_il_process_action_bean;
	}

	public PILP060_APAC_COMPOSITE_ACTION() {
		DUMMY_ACTION_BEAN=new DUMMY_ACTION();
		PT_IL_BONUS_ACTION_BEAN=new PT_IL_BONUS_ACTION();
		PT_IL_PROCESS_ACTION_BEAN=new PT_IL_PROCESS_ACTION();
	}
	
	
}
