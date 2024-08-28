package com.iii.pel.forms.PLM005;


import com.iii.premia.common.utils.CommonUtils;

public class PLM005_CURRENCY_COMPOSITE_ACTION{



	public String updateButtonAction(String rowId) throws Exception{
		System.out.println("Welcome to updateButtonAction");
		PLM005_CURRENCY_SEARCH_ACTION action = new PLM005_CURRENCY_SEARCH_ACTION();
		String outcome = null;
		try {
			CommonUtils.setGlobalObject("PLM005_CURRENCY_SEARCH_ACTION",action);
			 
			outcome = executeSelectStatement(action);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		System.out.println("outcome       "+outcome);
		return outcome; 
	}
	
	public String executeSelectStatement(PLM005_CURRENCY_SEARCH_ACTION detailsActionBean) throws Exception{
		String outCome = "CurrencyMaster";
		
		return outCome;
	}


}
