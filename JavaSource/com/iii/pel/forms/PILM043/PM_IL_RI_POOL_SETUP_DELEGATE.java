package com.iii.pel.forms.PILM043;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_SETUP_DELEGATE {
	
	public int preDelete()
	{
		Connection connection = null;
		CRUDHandler handler = null;
		int rowsdeleted = 0;
		try
		{
			PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
			String poolCode = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_CUST_CHRG = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_CUST_CHRG;
			String PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_COVER = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_COVER;
			String PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_CUST = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_CUST;
			String PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_SETUP = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_SETUP;
			
			Object[] param = {poolCode};
			handler.executeDeleteStatement(PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_CUST_CHRG, connection, param);
			handler.executeDeleteStatement(PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_COVER, connection, param);
			handler.executeDeleteStatement(PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_CUST, connection, param);
			rowsdeleted = handler.executeDeleteStatement(PILM043$PM_IL_RI_POOL_SETUP$DELETE_PM_IL_RI_POOL_SETUP, connection, param);
			connection.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowsdeleted;
	}
}
