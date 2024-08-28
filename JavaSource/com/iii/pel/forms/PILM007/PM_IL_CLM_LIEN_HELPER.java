package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_LIEN_HELPER {
	PILM007_PROCS_HELPER pilm007_procs_helper = new PILM007_PROCS_HELPER();

	public void CL_TO_AGE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if ((Integer) currValue < pm_il_clm_lien_bean.getCL_FM_AGE()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91008"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CL_RATE_PER_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if ((Double) currValue < 1) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "81085"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_INSERT(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			pilm007_procs_helper.L_CHK_UNIQUE_LIEN(compositeAction);
			pm_il_clm_lien_bean.setCL_COVER_CODE(pm_il_clm_repay_bean
					.getCR_COVER_CODE());
			pm_il_clm_lien_bean.setCL_LOSS_CODE(pm_il_clm_repay_bean
					.getCR_LOSS_TYPE());
			pm_il_clm_lien_bean.setCL_DISABLE_TYPE(pm_il_clm_repay_bean
					.getCR_DISABLE_TYPE());
			pm_il_clm_lien_bean.setCL_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pm_il_clm_lien_bean.setCL_CR_DT(new CommonUtils().getCurrentDate());
			if("H".equals(CommonUtils.getGlobalVariable("GLOBAL.M_CL_BASIS")))
			 pm_il_clm_lien_bean.setCL_BASIS("H");
			else if("L".equals(CommonUtils.getGlobalVariable("GLOBAL.M_CL_BASIS")))
			 pm_il_clm_lien_bean.setCL_BASIS("L");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_UPDATE(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();

		try {
			pilm007_procs_helper.L_CHK_UNIQUE_LIEN(compositeAction);
			pm_il_clm_lien_bean.setCL_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pm_il_clm_lien_bean
					.setCL_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_CREATE_RECORD(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			pm_il_clm_lien_bean.setCL_APPLIED_ON("S");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			// new PM_IL_CLM_LIEN_HELPER().executeQuery();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_CLM_LIEN_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_CLM_LIEN> dataList = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getDataList_PM_IL_CLM_LIEN();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_CLM_LIEN PM_IL_CLM_LIEN_BEAN = dataList.get(0);
			PM_IL_CLM_LIEN_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CLM_LIEN_ACTION_BEAN()
					.setPM_IL_CLM_LIEN_BEAN(PM_IL_CLM_LIEN_BEAN);
		}
	}

	public void preQuery(PILM007_COMPOSITE_ACTION compositeAction) {
		// TODO Auto-generated method stub
		PM_IL_CLM_LIEN pm_il_clm_lien_bean = compositeAction
				.getPM_IL_CLM_LIEN_ACTION_BEAN().getPM_IL_CLM_LIEN_BEAN();
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		pm_il_clm_lien_bean.setCL_COVER_CODE(pm_il_clm_repay_bean
				.getCR_COVER_CODE());
		pm_il_clm_lien_bean.setCL_LOSS_CODE(pm_il_clm_repay_bean
				.getCR_LOSS_TYPE());
		pm_il_clm_lien_bean.setCL_DISABLE_TYPE(pm_il_clm_repay_bean
				.getCR_DISABLE_TYPE());

	}
	
	public void checkDuplicateRangeInsert(PM_IL_CLM_REPAY pm_il_clm_repay_bean,PM_IL_CLM_LIEN PM_IL_CLM_LIEN_BEAN) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 'X' FROM PM_IL_CLM_LIEN WHERE CL_COVER_CODE = ? " +
				"AND CL_LOSS_CODE = ? AND CL_DISABLE_TYPE = ? AND " +
				"((? BETWEEN CL_FM_AGE AND CL_TO_AGE) " +
				"OR (? BETWEEN CL_FM_AGE AND CL_TO_AGE))";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					PM_IL_CLM_LIEN_BEAN.getCL_FM_AGE(),PM_IL_CLM_LIEN_BEAN.getCL_TO_AGE()});
			if(resultSet.next()){
				throw new Exception("Range already exists");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try{CommonUtils.closeCursor(resultSet);}catch (Exception e) {}}
	}
	
	
	public void checkDuplicateRangeUpdate(PM_IL_CLM_REPAY pm_il_clm_repay_bean,PM_IL_CLM_LIEN PM_IL_CLM_LIEN_BEAN) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 'X' FROM PM_IL_CLM_LIEN WHERE CL_COVER_CODE = ? " +
				"AND CL_LOSS_CODE = ? AND CL_DISABLE_TYPE = ? " +
				"AND ((? BETWEEN CL_FM_AGE AND CL_TO_AGE) " +
				"OR (? BETWEEN CL_FM_AGE AND CL_TO_AGE))  " +
				"AND ROWID <> ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					PM_IL_CLM_LIEN_BEAN.getCL_FM_AGE(),PM_IL_CLM_LIEN_BEAN.getCL_TO_AGE(),
					PM_IL_CLM_LIEN_BEAN.getROWID()});
			if(resultSet.next()){
				throw new Exception("Range already exists");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try{CommonUtils.closeCursor(resultSet);}catch (Exception e) {}}
	}
}
