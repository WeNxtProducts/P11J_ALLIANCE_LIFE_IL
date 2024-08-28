package com.iii.pel.forms.PILT036_APAC;
public class PILT036_APAC_COMPOSITE_ACTION{
	public PT_IL_POL_RED_SA_ACTION PT_IL_POL_RED_SA_ACTION_BEAN;
	
	public PILT036_APAC_COMPOSITE_ACTION(){
		
		try {
			PT_IL_POL_RED_SA_ACTION_BEAN = new PT_IL_POL_RED_SA_ACTION();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PT_IL_POL_RED_SA_ACTION_BEAN.setBlockFlag(true);
		
	}
	public PT_IL_POL_RED_SA_ACTION getPT_IL_POL_RED_SA_ACTION_BEAN() {
		return PT_IL_POL_RED_SA_ACTION_BEAN;
	}
	public void setPT_IL_POL_RED_SA_ACTION_BEAN(
			PT_IL_POL_RED_SA_ACTION pt_il_pol_red_sa_action_bean) {
		PT_IL_POL_RED_SA_ACTION_BEAN = pt_il_pol_red_sa_action_bean;
	}
	
	
}
