package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_COVER_HELPER {

	public void RPCVR_CODE_WHEN_VALIDATE_ITEM(String RPCVR_CODE_STRING) throws Exception{
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String poolCode = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
		String result =null;
		try {
			connection = CommonUtils.getConnection();
			
			String query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCVR_CODE;
			Object[] values = {RPCVR_CODE_STRING, poolCode};
			
			resultSet = handler.executeSelectStatement(query, connection, values);
			
				if(resultSet.next()){
					result = resultSet.getString(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71040"));
				}else {
				}
					
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
	}
	
	// Cover Code Update
	public void RPCVR_CODE_WHEN_VALIDATE_ITEM_UPDATE(String RPCVR_CODE_STRING) throws DBException{
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String poolCode = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
		String result =null;
		try {
			connection = CommonUtils.getConnection();
			String query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCVR_CODE_UPDATE;
			Object[] values = {RPCVR_CODE_STRING, poolCode};
			
			resultSet = handler.executeSelectStatement(query, connection, values);
			if (resultSet != null) {
				if (resultSet.next()) {
					int count = resultSet.getInt("CNT");
					if (count >= 2) {
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71040"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	
	public void RPCVR_SHARE_PERC_WHEN_VALIDATE_ITEM(Double RPCVR_SHARE_PERC_DOUBLE,PM_IL_RI_POOL_COVER_ACTION pm_il_ri_pool_cover_action)
	{
		if(RPCVR_SHARE_PERC_DOUBLE <= 0 ){
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","60111"));	
		}
		else if(RPCVR_SHARE_PERC_DOUBLE > 100){
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","71017"));	
		}/*else{
			pm_il_ri_pool_cover_action.lastColumnListener();
		}*/
	}
}
