package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_IL_HTWT_DTL_HELPER {

	/* Individual converted triggers */
	/* Pre-Insert trigger for plan mop block/screen */

	private void L_VALIDATE_HTWT_RANGE(PM_IL_HTWT_DTL pm_il_htwt_dtl) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		Double htFrom = pm_il_htwt_dtl.getHTWT_HEIGHT_FM();
		Double htTo = pm_il_htwt_dtl.getHTWT_HEIGHT_TO();
		Date dateFrom = pm_il_htwt_dtl.getHTWT_EFF_FM_DT();
		Date dateTo = pm_il_htwt_dtl.getHTWT_EFF_TO_DT();
		String rowId = pm_il_htwt_dtl.getROWID();
		Double ptSysId = pm_il_htwt_dtl.getHTWT_PT_SYS_ID();
		Object values[] = {htFrom, htTo, htFrom, htTo, htFrom, htTo, dateFrom,
				dateTo, dateFrom, dateTo, dateFrom, dateTo, ptSysId};
		Connection connection = null;
		ResultSet resultSet1 = null;
		try {
			connection = CommonUtils.getConnection();
			String query = PM_IL_HTWT_DTL_CONSTANTS.htwtRangeValidateQuery;
			resultSet1 = handler.executeSelectStatement(query, connection, values);
			if (resultSet1.next()) {
				M_DUMMY = resultSet1.getString(1);
			}
			if (M_DUMMY != null && !M_DUMMY.equals(rowId)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
				"91011"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			CommonUtils.closeCursor(resultSet1);
		}
	}

	/**
	 * Pre-insert trigger
	 * 
	 * 
	 */
	public void PILM015_APAC_PM_IL_HTWT_DTL_PRE_INSERT(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String sql_C1 = "SELECT PIL_HTWT_SYS_ID.NEXTVAL SYS_ID FROM  DUAL";
		PM_IL_HTWT_DTL htwtBean = compositeAction.getPM_IL_HTWT_DTL_ACTION().getPM_IL_HTWT_DTL_BEAN();
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(sql_C1, connection);
			if (resultSet.next()) {
				htwtBean.setHTWT_SYS_ID(resultSet.getDouble(1));
				htwtBean.setHTWT_PT_SYS_ID(compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID());
				htwtBean.setHTWT_CR_DT(commonUtils.getCurrentDate());
				htwtBean.setHTWT_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
			L_VALIDATE_HTWT_RANGE(htwtBean);
		} catch(Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void preUpdateTrigger(PM_IL_HTWT_DTL htwtBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		htwtBean.setHTWT_UPD_DT(commonUtils.getCurrentDate());
		htwtBean.setHTWT_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		L_VALIDATE_HTWT_RANGE(htwtBean);
	}

	public void EFF_FM_DT_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL htwtBean) throws Exception {
		try{
			Date fromdate = CommonUtils.nvl(htwtBean.getHTWT_EFF_FM_DT(), 
												CommonUtils.stringToUtilDate("01-JAN-1900"));
			Date toDate = CommonUtils.nvl(htwtBean.getHTWT_EFF_TO_DT(), 
												CommonUtils.stringToUtilDate("31-DEC-2999"));
			if (fromdate.after(toDate)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91010"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void EFF_TO_DT_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL htwtBean) throws Exception {
		try{
			Date fromdate = CommonUtils.nvl(htwtBean.getHTWT_EFF_FM_DT(), 
					CommonUtils.stringToUtilDate("01-JAN-1900"));
			Date toDate = CommonUtils.nvl(htwtBean.getHTWT_EFF_TO_DT(), 
					CommonUtils.stringToUtilDate("31-DEC-2999"));
			if (fromdate.after(toDate)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91001"));
			} 
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void HEIGHT_FROM_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL htwtBean) throws Exception {
		try{
			Double heightFrom = MigratingFunctions.nvl(htwtBean.getHTWT_HEIGHT_FM(), 0);
			Double heightTo = htwtBean.getHTWT_HEIGHT_TO();
			if (heightFrom <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007", 
							new Object[]{"From Height"}));
			} else if (heightTo != null && heightFrom > heightTo) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91024"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void HEIGHT_TO_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL htwtBean) throws Exception {
		try{
			Double heightFrom = htwtBean.getHTWT_HEIGHT_FM();
			Double heightTo = MigratingFunctions.nvl(htwtBean.getHTWT_HEIGHT_TO(), 0);
			if (heightTo <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007", new Object[]{"From Height"}));
			} else if (heightFrom != null && heightTo < heightFrom) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90008", new Object[]{"To Height", "From Height"}));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		

	public void WEIGHT_FROM_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL htwtBean) throws Exception {
		try{
			Double weightFrom = CommonUtils.nvl(htwtBean.getHTWT_HEIGHT_FM(), 0);
			Double weightTo = htwtBean.getHTWT_HEIGHT_TO();
			if (weightFrom <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007", new Object[]{"From Weight"}));
			} else if (weightTo != null && weightFrom > weightTo) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91024"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WEIGHT_TO_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL htwtBean) throws Exception {
		try{
			Double weightFrom = htwtBean.getHTWT_HEIGHT_FM();
			Double weightTo = MigratingFunctions.nvl(htwtBean.getHTWT_HEIGHT_TO(), 0);
			if (weightTo <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007", 
							new Object[]{"To Weight"}));
			} else if (weightFrom != null && weightTo < weightFrom) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90008",  
							new Object[]{"To Weight", "From Weight"}));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
