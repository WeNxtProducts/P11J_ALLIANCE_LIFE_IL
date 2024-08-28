package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_PREM_LIMIT_HELPER {

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		try {
			pm_il_prod_prem_limit_bean.setPPL_MODE_OF_PYMT("M");
			pm_il_prod_prem_limit_bean.setPPL_CHECK_BASIS("B");
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_prod_prem_limit_bean.setPPL_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			pm_il_prod_prem_limit_bean.setPPL_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_prem_limit_bean.setPPL_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			L_UNIQUE_MODETERM(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		try {
			L_UNIQUE_MODETERM(compositeAction);
			pm_il_prod_prem_limit_bean.setPPL_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_prem_limit_bean.setPPL_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PPL_FM_TERM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		int PPL_FM_TERM = (Integer) currValue;
		try {
			if(pm_il_prod_prem_limit_bean.getPPL_TO_TERM() != null){
				if (PPL_FM_TERM != 0 
						&& PPL_FM_TERM > pm_il_prod_prem_limit_bean
								.getPPL_TO_TERM()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Premiuim from term", ">=",
									"Premiuim to term" }));
				} else if (PPL_FM_TERM == 0) {
					pm_il_prod_prem_limit_bean.setPPL_FM_TERM(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PPL_TO_TERM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		int PPL_TO_TERM = (Integer) currValue;
		try {
			if(pm_il_prod_prem_limit_bean.getPPL_FM_TERM() != null){
				if (PPL_TO_TERM < pm_il_prod_prem_limit_bean.getPPL_FM_TERM()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Premiuim to term ", "<=",
									"Premiuim from term" }));
				}
			}
			if (pm_il_prod_prem_limit_bean.getPPL_TO_TERM() == null) {
				pm_il_prod_prem_limit_bean.setPPL_TO_TERM(99);
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_LIST_CHANGED_PPL_MODE_OF_PYMT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		try {
			if (pm_il_prod_prem_limit_bean.getPPL_MODE_OF_PYMT() != null) {
				L_UNIQUE_MODETERM(compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_LIST_CHANGED_PPL_CHECK_BASIS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		try {
			if (pm_il_prod_prem_limit_bean.getPPL_MODE_OF_PYMT() != null) {
				L_UNIQUE_MODETERM(compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PPL_LC_MIN_PREM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		Double PPL_LC_MIN_PREM = (Double) currValue;
		try {
			if (PPL_LC_MIN_PREM != null) {
				pm_il_prod_prem_limit_bean.setPPL_LC_MIN_PREM(1.0);
			}
			if (CommonUtils.nvl(PPL_LC_MIN_PREM, 0) <= 0) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "91014",
								new Object[] { "LC Minimum Premium",
										"Greater than 0" }));
			}
			if (CommonUtils.nvl(
					pm_il_prod_prem_limit_bean.getPPL_LC_MAX_PREM(), 0) > 0) {
				if ((CommonUtils.nvl(PPL_LC_MIN_PREM, 0)) >= (CommonUtils.nvl(
						pm_il_prod_prem_limit_bean.getPPL_LC_MAX_PREM(), 0))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] {
									"LC Minimum Premium",
									"Less Than"
											+ pm_il_prod_prem_limit_bean
													.getPPL_LC_MAX_PREM() }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PPL_LC_MAX_PREM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();
		Double PPL_LC_MAX_PREM = (Double) currValue;
		try {
			if (PPL_LC_MAX_PREM == null) {
				pm_il_prod_prem_limit_bean.setPPL_LC_MAX_PREM(999999.0);
			}
			if (CommonUtils.nvl(PPL_LC_MAX_PREM, 0) <= 0) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "91014",
								new Object[] { "LC Maximum Premium",
										"Greater than 0" }));
			}

			if (CommonUtils.nvl(
					pm_il_prod_prem_limit_bean.getPPL_LC_MIN_PREM(), 0) > 0) {
				if ((CommonUtils.nvl(PPL_LC_MAX_PREM, 0)) <= (CommonUtils.nvl(
						pm_il_prod_prem_limit_bean.getPPL_LC_MIN_PREM(), 0))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] {
									"LC Maximum Premium",
									"Greater than "
											+ pm_il_prod_prem_limit_bean
													.getPPL_LC_MIN_PREM() }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void L_UNIQUE_MODETERM(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_PREM_LIMIT pm_il_prod_prem_limit_bean = compositeAction
				.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
				.getPM_IL_PROD_PREM_LIMIT_BEAN();

		String C1 = " SELECT 'X' FROM   PM_IL_PROD_PREM_LIMIT "
				+ "WHERE  PPL_MODE_OF_PYMT = ? AND	 PPL_PROD_CODE	  = ? "
				+ "AND  ( (?      BETWEEN  PPL_FM_TERM AND PPL_TO_TERM) "
				+ "OR(?  BETWEEN  PPL_FM_TERM AND PPL_TO_TERM)) ";
		String C2 = " SELECT 'X' FROM  PM_IL_PROD_PREM_LIMIT "
				+ "WHERE  PPL_MODE_OF_PYMT = ? AND PPL_PROD_CODE	  = ? "
				+ "AND ( (?  BETWEEN  PPL_FM_TERM AND PPL_TO_TERM) "
				+ "OR  ( ?   BETWEEN  PPL_FM_TERM AND PPL_TO_TERM)) "
				+ "AND  ROWID  <> ? ";
		try {
			con = CommonUtils.getConnection();

			if(pm_il_prod_prem_limit_bean.getROWID() == null){
				Object[] c1values = new Object[] {
						pm_il_prod_prem_limit_bean.getPPL_MODE_OF_PYMT(),
						pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_prem_limit_bean.getPPL_FM_TERM(),
						pm_il_prod_prem_limit_bean.getPPL_TO_TERM() };
				rs1 = handler.executeSelectStatement(C1, con, c1values);
				if (rs1.next()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018",
							new Object[] { "The  combination already exists . Please  re-enter." }));
				}
			}else {
					Object[] c2values = new Object[] {
							pm_il_prod_prem_limit_bean.getPPL_MODE_OF_PYMT(),
							pm_il_product_bean.getPROD_CODE(),
							pm_il_prod_prem_limit_bean.getPPL_FM_TERM(),
							pm_il_prod_prem_limit_bean.getPPL_TO_TERM(),
							pm_il_prod_prem_limit_bean.getROWID() };
					rs2 = handler.executeSelectStatement(C2, con, c2values);
					if (rs2.next()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "60018",
								new Object[] { "The  combination already exists . Please  re-enter." }));
					}
				}
			
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_PREM_LIMIT_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_PREM_LIMIT> dataList = compositeAction
					.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
					.getDataList_PM_IL_PROD_PREM_LIMIT();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_PREM_LIMIT PM_IL_PROD_PREM_LIMIT_BEAN = dataList
						.get(0);
				PM_IL_PROD_PREM_LIMIT_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
						.setPM_IL_PROD_PREM_LIMIT_BEAN(
								PM_IL_PROD_PREM_LIMIT_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
