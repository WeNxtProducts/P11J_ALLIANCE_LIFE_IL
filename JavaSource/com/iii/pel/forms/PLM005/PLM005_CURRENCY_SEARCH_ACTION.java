package com.iii.pel.forms.PLM005;



import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PLM005_CURRENCY_SEARCH_ACTION  extends CommonAction{
	
		
	/*public String updateButtonAction(String rowId){
		
		System.out.println("WELCOME TO updateButtonAction");
		
		PM_IL_CURRENCY_ACTION action = new PM_IL_CURRENCY_ACTION();
		String outcome = null;
		action.getPM_CURRENCY_BEAN().setROWID(rowId);
		
		CommonUtils.setGlobalObject("PM_IL_CURRENCY_ACTION", action);
		outcome = "GO_TO_PLM005_PM_IL_CURRENCY_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
	
		System.out.println("WELCOME TO insertButtonAction");
		
		PM_IL_CURRENCY_ACTION action = new PM_IL_CURRENCY_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_CURRENCY_ACTION", action);
		outcome = "GO_TO_PLM005_PM_IL_CURRENCY_SETUP";
		return outcome;

	}*/

	
	
	
	public String updateButtonAction(String rowId){
		
		System.out.println("WELCOME TO updateButtonAction");
		
		PLM005_COMPOSITE_ACTION action = new PLM005_COMPOSITE_ACTION();
		String outcome = null;
		action.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().setROWID(rowId);
		
		CommonUtils.setGlobalObject("PLM005_COMPOSITE_ACTION", action);
		outcome = "GO_TO_PLM005_PM_IL_CURRENCY_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
	
		System.out.println("WELCOME TO insertButtonAction");
		
		PLM005_COMPOSITE_ACTION action = new PLM005_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PLM005_COMPOSITE_ACTION", action);
		outcome = "GO_TO_PLM005_PM_IL_CURRENCY_SETUP";
		return outcome;

	}

	
	

}
