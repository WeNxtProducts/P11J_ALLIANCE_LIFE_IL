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

public class PM_IL_CLM_WAIT_PERIOD_HELPER {

	PILM007_PROCS_HELPER localPrcs_helper = new PILM007_PROCS_HELPER();

	public void executeQuery(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_CLM_WAIT_PERIOD_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_CLM_WAIT_PERIOD> dataList = compositeAction
				.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
				.getDataList_PM_IL_CLM_WAIT_PERIOD();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN = dataList.get(0);
			PM_IL_CLM_WAIT_PERIOD_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
					.setPM_IL_CLM_WAIT_PERIOD_BEAN(PM_IL_CLM_WAIT_PERIOD_BEAN);
		}
	}

	public void CWP_FM_DAYS_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		try {
			PM_IL_CLM_WAIT_PERIOD pm_il_clm_wait_period_bean = compositeAction
					.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
					.getPM_IL_CLM_WAIT_PERIOD_BEAN();
			if (pm_il_clm_wait_period_bean.getCWP_TO_DAYS() != null)
				if ((Integer) currValue > pm_il_clm_wait_period_bean
						.getCWP_TO_DAYS())
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// STD_MESSAGE_ROUTINE(91014, :CTRL.M_LANG_CODE,'From Days','Less than
		// To Days');

	}

	public void CWP_TO_DAYS_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_WAIT_PERIOD pm_il_clm_wait_period_bean = compositeAction
				.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
				.getPM_IL_CLM_WAIT_PERIOD_BEAN();
		if ((Integer) currValue < pm_il_clm_wait_period_bean.getCWP_FM_DAYS())
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91014", new Object[] {
							currValue, "To Days",
							"Greater than or Equal to From Days" }));

		// STD_MESSAGE_ROUTINE(91014, :CTRL.M_LANG_CODE,'To Days','Greater than
		// or Equal to From Days');
	}

	public void CWP_RATE_PER_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		if ((Double) currValue < 1) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "81085"));
		}

	}

	public void WHEN_CREATE_RECORD(PILM007_COMPOSITE_ACTION compositeAction) {
		PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN = compositeAction
				.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN()
				.getPM_IL_CLM_WAIT_PERIOD_BEAN();
		PM_IL_CLM_WAIT_PERIOD_BEAN.setCWP_APPLIED_ON("S");
	}

	public void PRE_INSERT(PM_IL_CLM_WAIT_PERIOD pm_il_clm_wait_period_bean,
			PILM007_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		localPrcs_helper.L_CHK_UNIQUE_WAIT_PERIOD(pm_il_clm_wait_period_bean,
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getPM_IL_CLM_REPAY_BEAN());

		pm_il_clm_wait_period_bean.setCWP_COVER_CODE(pm_il_clm_repay_bean
				.getCR_COVER_CODE());
		pm_il_clm_wait_period_bean.setCWP_LOSS_CODE(pm_il_clm_repay_bean
				.getCR_LOSS_TYPE());
		pm_il_clm_wait_period_bean.setCWP_DISABLE_TYPE(pm_il_clm_repay_bean
				.getCR_DISABLE_TYPE());
		pm_il_clm_wait_period_bean.setCWP_CR_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));
		pm_il_clm_wait_period_bean.setCWP_CR_DT(new CommonUtils()
				.getCurrentDate());
	}

	public void PRE_UPDATE(PM_IL_CLM_WAIT_PERIOD pm_il_clm_wait_period_bean,
			PILM007_COMPOSITE_ACTION compositeAction) throws Exception {
		localPrcs_helper.L_CHK_UNIQUE_WAIT_PERIOD(pm_il_clm_wait_period_bean,
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getPM_IL_CLM_REPAY_BEAN());

		pm_il_clm_wait_period_bean.setCWP_UPD_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));
		pm_il_clm_wait_period_bean.setCWP_UPD_DT(new CommonUtils()
				.getCurrentDate());
	}
	
	public void checkDuplicateRangeInsert(PM_IL_CLM_REPAY pm_il_clm_repay_bean,PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 'X' FROM PM_IL_CLM_WAIT_PERIOD WHERE CWP_COVER_CODE = ? " +
				"AND CWP_LOSS_CODE = ? AND CWP_DISABLE_TYPE = ? AND " +
				"((? BETWEEN CWP_FM_DAYS AND CWP_TO_DAYS) " +
				"OR (? BETWEEN CWP_FM_DAYS AND CWP_TO_DAYS))";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, 
					new Object[]{pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					PM_IL_CLM_WAIT_PERIOD_BEAN.getCWP_FM_DAYS(),
					PM_IL_CLM_WAIT_PERIOD_BEAN.getCWP_TO_DAYS()});
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
	
	
	public void checkDuplicateRangeUpdate(PM_IL_CLM_REPAY pm_il_clm_repay_bean,
			PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 'X' FROM PM_IL_CLM_WAIT_PERIOD WHERE CWP_COVER_CODE = ? " +
				"AND CWP_LOSS_CODE = ? AND CWP_DISABLE_TYPE = ? AND " +
				"((? BETWEEN CWP_FM_DAYS AND CWP_TO_DAYS) " +
				"OR (? BETWEEN CWP_FM_DAYS AND CWP_TO_DAYS)) " + 
				"AND ROWID <> ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, 
					new Object[]{pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					PM_IL_CLM_WAIT_PERIOD_BEAN.getCWP_FM_DAYS(),
					PM_IL_CLM_WAIT_PERIOD_BEAN.getCWP_TO_DAYS(),
					PM_IL_CLM_WAIT_PERIOD_BEAN.getROWID()});
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
