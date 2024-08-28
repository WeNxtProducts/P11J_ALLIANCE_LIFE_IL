package com.iii.pel.forms.PILM043;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;

public class PM_IL_RI_CUST_CHRG_HELPER {

	/*
	 * RCC_SRNO
	 */
	public void RCC_SRNO_WHEN_VALIDATE_ITEM(Double RCC_SRNO_DOUBLE, PM_IL_RI_CUST_CHRG_ACTION chrgAction) throws Exception{
		if(RCC_SRNO_DOUBLE < 0.0){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71043"));
		}else{
			chrgAction.getPM_IL_RI_CUST_CHRG_BEAN().setRCC_SRNO(RCC_SRNO_DOUBLE);
		}
	}
	
	/*
	 * RCC_RATE_PER
	 */
	public void RCC_RATE_PER_WHEN_VALIDATE_ITEM(Double RCC_RATE_PER_DOUBLE, PM_IL_RI_CUST_CHRG_ACTION chrgAction) throws Exception{
		if(RCC_RATE_PER_DOUBLE == 0.0 || RCC_RATE_PER_DOUBLE < 0.00){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206",new Object[]{"Rate per cannot be Null or Zero"}));
		}else{
			chrgAction.getPM_IL_RI_CUST_CHRG_BEAN().setRCC_RATE_PER(RCC_RATE_PER_DOUBLE);
		}
	}

	/*
	 * RCC_CUST_SHARE_PERC
	 */
	public void RCC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(Double RCC_CUST_SHARE_PERC_DOUBLE, PM_IL_RI_CUST_CHRG_ACTION chrgAction) throws Exception{
		if(RCC_CUST_SHARE_PERC_DOUBLE > 100 || RCC_CUST_SHARE_PERC_DOUBLE < 0){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71070"));
		}else{
			chrgAction.getPM_IL_RI_CUST_CHRG_BEAN().setRCC_CUST_SHARE_PERC(RCC_CUST_SHARE_PERC_DOUBLE);
		}
	}
}
