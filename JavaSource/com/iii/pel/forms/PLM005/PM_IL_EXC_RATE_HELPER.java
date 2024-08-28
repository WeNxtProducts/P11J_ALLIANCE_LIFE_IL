package com.iii.pel.forms.PLM005;

import java.util.List;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_EXC_RATE_HELPER {
	
	
	public void executeExc_rate_Query(PLM005_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
			
			
			/*String CURR_CODE =compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE();
			
			System.out.println("CURR_CODE          :"+compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());
			
			compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getFM_EXCHANGE_RATE_BEAN().setCER_CONV_FM_CURR_CODE(CURR_CODE);*/
			
		new PM_IL_EXC_RATE_DELEGATE().executeExchangeSelectStatement(compositeAction);
	
		List<FM_EXCHANGE_RATE> dataList = compositeAction
				.getPM_IL_CURRENCY_ACTION_BEAN().getDataList_FM_EXCHANGE_RATE();
		if (dataList != null && dataList.size() > 0) {
			FM_EXCHANGE_RATE FM_EXCHANGE_RATE_BEAN = dataList.get(0);
			FM_EXCHANGE_RATE_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CURRENCY_ACTION_BEAN()
					.setFM_EXCHANGE_RATE_BEAN(FM_EXCHANGE_RATE_BEAN);
			System.out.println(" Date field start          " +compositeAction.getPM_IL_CURRENCY_ACTION_BEAN()
					.getFM_EXCHANGE_RATE_BEAN().getCER_EFF_FRM_DT());
		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}
	public void whenValidateCER_EFF_FRM_DT(FM_EXCHANGE_RATE FM_EXCHANGE_RATE_BEAN)
			throws Exception {
		try {
			if ((FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT() != null)) {
				/*if ((FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT())
						.after(FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT())) {*/
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91010",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*Added by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.*/
	
	public void pm_executeExc_rate_Query(PLM005_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
			
		new PM_IL_EXC_RATE_DELEGATE().executeExchangeStatement(compositeAction);
	
		List<PM_EXCHANGE_RATE> dataList = compositeAction
				.getPM_IL_CURRENCY_ACTION_BEAN().getDataList_PM_EXCHANGE_RATE();
		if (dataList != null && dataList.size() > 0) {
			PM_EXCHANGE_RATE PM_EXCHANGE_RATE_BEAN = dataList.get(0);
			PM_EXCHANGE_RATE_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CURRENCY_ACTION_BEAN()
					.setPM_EXCHANGE_RATE_BEAN(PM_EXCHANGE_RATE_BEAN);
			System.out.println(" Date field start          " +compositeAction.getPM_IL_CURRENCY_ACTION_BEAN()
					.getPM_EXCHANGE_RATE_BEAN().getCER_EFF_FRM_DT());
		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}
	/*eND*/

}
