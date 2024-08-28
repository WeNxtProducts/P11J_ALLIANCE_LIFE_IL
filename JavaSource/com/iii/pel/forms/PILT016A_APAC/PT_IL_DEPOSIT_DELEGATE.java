package com.iii.pel.forms.PILT016A_APAC;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT017.PILT017_QUERY_CONSTANTS;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DEPOSIT_DELEGATE {

	public void updatePaymentDetailsAmounts(Double amount,Long sysId)
	{
		Connection connection = null;
		CRUDHandler handler = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String query = PILT017_QUERY_CONSTANTS.UPDATE_QUERY_PAYDTLS;
			String paymentTransactionType = (String)CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE");
			//String paymentTransactionSysid = CommonUtils.getGlobalVariable("GLOBAL.TXN_SYS_ID");
			System.out.println("AMT:::::"+amount+" "+sysId+" "+paymentTransactionType);
			Object[] params = {amount,amount,paymentTransactionType.trim(),sysId};
			int rowsUpdated = handler.executeUpdateStatement(query, connection, params);
			System.out.println("Updated row count:::::::::::::"+rowsUpdated);
			connection.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}
