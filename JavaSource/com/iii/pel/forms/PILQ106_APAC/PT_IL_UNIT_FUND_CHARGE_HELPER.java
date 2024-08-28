package com.iii.pel.forms.PILQ106_APAC;

import java.util.List;

public class PT_IL_UNIT_FUND_CHARGE_HELPER {

	public void executeQuery(PILQ106_APAC_COMPOSITE_ACTION compAction){
		try {
			new PT_IL_UNIT_FUND_CHARGE_DELEGATE().executeStatement(compAction);

			List<PT_IL_UNIT_FUND_CHARGE> dataList = compAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().getDataList_PT_IL_UNIT_FUND_CHARGE();
			System.out.println("dataList PT_IL_UNIT_FUND_CHARGE       "+dataList);
			if (dataList != null && dataList.size() > 0) {
				compAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().setPT_IL_UNIT_FUND_CHARGE_BEAN( dataList.get(0));
				// dataList.get(0).setRowSelected(true);
			}else{
				PT_IL_UNIT_FUND_CHARGE PT_IL_UNIT_FUND_CHARGE_BEAN=new PT_IL_UNIT_FUND_CHARGE();
				compAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().setPT_IL_UNIT_FUND_CHARGE_BEAN(PT_IL_UNIT_FUND_CHARGE_BEAN);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
