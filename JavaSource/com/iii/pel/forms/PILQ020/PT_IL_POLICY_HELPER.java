package com.iii.pel.forms.PILQ020;

public class PT_IL_POLICY_HELPER {

	public void preForm(PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN) {
		PT_IL_POLICY PT_IL_POLICY_BEAN=PT_IL_POLICY_ACTION_BEAN.getPT_IL_POLICY_BEAN(); 
		String M_FILE = null;
		String M_TITLE = null;

		try {
			
			 } catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void KEY_ENTQRY(PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN){
	
	}
	
	public void executeSelectStatement(PILQ020_COMPOSITE_ACTION compositeAction){
		
		try{
			new PT_IL_POLICY_DELEGATE().executeSelectStatement(compositeAction);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
