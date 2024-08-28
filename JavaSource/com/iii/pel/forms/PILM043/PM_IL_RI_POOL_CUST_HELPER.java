package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_CUST_HELPER {

	/*
	 * Share %
	 */
	public void RPCUST_SHARE_PERC_WHEN_VALIDATE_ITEM(Double RPCUST_SHARE_PERC_DOUBLE,PM_IL_RI_POOL_CUST_ACTION pm_il_ri_pool_cust_action) throws Exception {
		Double RPCUST_RETRO_SHARE_PERC_DOUBLE = null;
		try{
			if (RPCUST_SHARE_PERC_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "60111"));
			}
			if (RPCUST_SHARE_PERC_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
			if (pm_il_ri_pool_cust_action.getPM_IL_RI_POOL_CUST_BEAN().getRPCUST_RETRO_SHARE_PERC() == null) {
				pm_il_ri_pool_cust_action.getPM_IL_RI_POOL_CUST_BEAN().setRPCUST_RETRO_SHARE_PERC(0.0);
				RPCUST_RETRO_SHARE_PERC_DOUBLE = pm_il_ri_pool_cust_action.getPM_IL_RI_POOL_CUST_BEAN().getRPCUST_RETRO_SHARE_PERC();
			} else {
				RPCUST_RETRO_SHARE_PERC_DOUBLE = pm_il_ri_pool_cust_action.getPM_IL_RI_POOL_CUST_BEAN().getRPCUST_RETRO_SHARE_PERC();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		
	public void RPCUST_NEW_COMM_WHEN_VALIDATE_ITEM(Double RPCUST_NEW_COMM_DOUBLE) throws Exception {
		try{
			if (RPCUST_NEW_COMM_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_NEW_COMM_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		


	/*
	 * Renewal Commission %
	 */
	public void RPCUST_REN_COMM_WHEN_VALIDATE_ITEM(Double RPCUST_REN_COMM_DOUBLE) throws Exception {

		try{
			if (RPCUST_REN_COMM_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_REN_COMM_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}



	/*
	 * New Tax %
	 */
	public void RPCUST_NEW_TAX_WHEN_VALIDATE_ITEM(Double RPCUST_NEW_TAX_DOUBLE) throws Exception {

		try{
			if (RPCUST_NEW_TAX_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_NEW_TAX_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		


	/*
	 * Renewal Tax %
	 */
	public void RPCUST_REN_TAX_WHEN_VALIDATE_ITEM(Double RPCUST_REN_TAX_DOUBLE) throws Exception {
		try{
			if (RPCUST_REN_TAX_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_REN_TAX_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
			


	/*
	 * Retro Share %
	 */
	public void RPCUST_RETRO_SHARE_PERC_WHEN_VALIDATE_ITEM(Double RPCUST_RETRO_SHARE_PERC_DOUBLE,Double RPCUST_SHARE_PERC_DOUBLE,PM_IL_RI_POOL_CUST_ACTION pm_il_ri_pool_cust_action) throws Exception {
			
		try{
			if (RPCUST_RETRO_SHARE_PERC_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}

			if (RPCUST_RETRO_SHARE_PERC_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}

			if (RPCUST_SHARE_PERC_DOUBLE == null) {
				pm_il_ri_pool_cust_action.getPM_IL_RI_POOL_CUST_BEAN().setRPCUST_SHARE_PERC(0.0);
				RPCUST_SHARE_PERC_DOUBLE = pm_il_ri_pool_cust_action.getPM_IL_RI_POOL_CUST_BEAN().getRPCUST_SHARE_PERC();
			}
			if (RPCUST_RETRO_SHARE_PERC_DOUBLE >= RPCUST_SHARE_PERC_DOUBLE) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91263"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}



	/*
	 * Retro Share %
	 */
	public void RPCUST_RETRO_SHARE_PERC_KEY_NEXT_ITEM(Double RPCUST_RETRO_SHARE_PERC_DOUBLE,PM_IL_RI_POOL_CUST_ACTION pm_il_ri_pool_cust_action) {
		if (RPCUST_RETRO_SHARE_PERC_DOUBLE > 0) {
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_COMM().setDisabled(false);
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_COMM().setSubmittedValue("");
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_TAX().setDisabled(false);
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_TAX().setSubmittedValue("");
		} else {
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_COMM().setDisabled(true);
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_TAX().setDisabled(true);
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_COMM().setSubmittedValue("");
			pm_il_ri_pool_cust_action.getCOMP_RPCUST_RETRO_NEW_TAX().setSubmittedValue("");
		}
	}

	/*
	 * New Retro Commission.
	 */
	public void RPCUST_RETRO_NEW_COMM_WHEN_VALIDATE_ITEM(Double RPCUST_RETRO_NEW_COMM_DOUBLE) throws Exception {
		
		try{
			if (RPCUST_RETRO_NEW_COMM_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_RETRO_NEW_COMM_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		
	

	/*
	 * Retro Renewal Commission %
	 */
	public void RPCUST_RETRO_REN_COMM_WHEN_VALIDATE_ITEM(Double RPCUST_RETRO_REN_COMM_DOUBLE) throws Exception {
		try{
			if (RPCUST_RETRO_REN_COMM_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_RETRO_REN_COMM_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		


	/*
	 * Retro New Tax %
	 */

	public void RPCUST_RETRO_NEW_TAX_WHEN_VALIDATE_ITEM(Double RPCUST_RETRO_NEW_TAX_DOUBLE) throws Exception {
		try{
			if (RPCUST_RETRO_NEW_TAX_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			
			if (RPCUST_RETRO_NEW_TAX_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
			


	/*
	 * Retro Renewal Tax %
	 */
	public void RPCUST_RETRO_REN_TAX_WHEN_VALIDATE_ITEM(Double RPCUST_RETRO_REN_TAX_DOUBLE) throws Exception {
		try {
			if (RPCUST_RETRO_REN_TAX_DOUBLE < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71042"));
			}
			if (RPCUST_RETRO_REN_TAX_DOUBLE > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
			
		


	/**
	 * Share Percentage Logic
	 */
	public void sharePercentageLogic() {
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
	}

	public void RPCUST_CODE_WHEN_VALIDATE_ITEM(String RPCUST_CODE_STRING) throws Exception {

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String poolCode = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
		String RPCVR_CODE_STRING = null;
		try{
		connection = CommonUtils.getConnection();
		int custRowCount = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_COVER_ACTION().getDataTable().getRowCount();
		for (int index = 0; index < custRowCount; index++) {
			PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) pm_il_ri_pool_setup_composite_action
					.getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().get(index);
			if("dataTableSelectedRow".equalsIgnoreCase(pm_il_ri_pool_cover.getRowSelected())){
				RPCVR_CODE_STRING = pm_il_ri_pool_cover.getRPCVR_CODE();
			}
		}
			
		String query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCUST_CODE;
		Object[] values = { poolCode, RPCVR_CODE_STRING };
		resultSet = handler.executeSelectStatement(query, connection,values);
		while (resultSet.next()) {
			if (RPCUST_CODE_STRING.equalsIgnoreCase(resultSet.getString("RPCUST_CODE"))){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91041", new Object[] { "Customer Code" }));
			}
		}
		}catch (DBException  e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
				
	}
		

	public void RPCUST_CODE_WHEN_VALIDATE_ITEM_UPDATE(String RPCUST_CODE_STRING) throws Exception{

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String poolCode = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
		String RPCVR_CODE_STRING = null;
		
		try {
			int custRowCount = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_COVER_ACTION().getDataTable().getRowCount();
			for (int index = 0; index < custRowCount; index++) {
				PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) pm_il_ri_pool_setup_composite_action
				.getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().get(index);
				if("dataTableSelectedRow".equalsIgnoreCase(pm_il_ri_pool_cover.getRowSelected())){
					RPCVR_CODE_STRING = pm_il_ri_pool_cover.getRPCVR_CODE();
					System.out.println("RPCVR_CODE_STRING" + RPCVR_CODE_STRING);
				}
			}

			
			connection = CommonUtils.getConnection();
			String query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCUST_CODE_UPDATE;
			Object[] values = { poolCode, RPCVR_CODE_STRING, RPCUST_CODE_STRING };

			resultSet = handler.executeSelectStatement(query, connection,values);
			
			
				if (resultSet.next()) {
					int count = resultSet.getInt("CNT");
					if (count >= 2) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91041", new Object[] { "Customer Code" }));
					}
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {	try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}}
	}

}
