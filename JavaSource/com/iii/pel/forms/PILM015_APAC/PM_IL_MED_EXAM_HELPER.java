package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_IL_MED_EXAM_HELPER {

	public void SA_ASSURED_TO_WHEN_VALIDATE(PM_IL_MED_EXAM_HDR medHeadBean)
			throws Exception {
		try{
			Double saTo = medHeadBean.getMEH_SUM_ASSURED_TO();
			Double saFrom = medHeadBean.getMEH_SUM_ASSURED_FM();
			if(CommonUtils.nvl(saTo, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "333000"));
			}
			if (CommonUtils.nvl(saTo, 0) < CommonUtils.nvl(saFrom, 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71223"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void AGE_TO_WHEN_VALIDATE_ITEM(PM_IL_MED_EXAM_HDR medHeadBean) throws Exception {
		try{
			Integer ageTo = medHeadBean.getMEH_AGE_TO();
			Integer ageFrom = medHeadBean.getMEH_AGE_FM();
			if(CommonUtils.nvl(ageTo, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "333000"));
			}
			if (CommonUtils.nvl(ageTo, 0) < CommonUtils.nvl(ageFrom, 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71224"));
			}
			L_VALIDATE_RANGE(medHeadBean);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SA_ASSURED_FROM(PM_IL_MED_EXAM_HDR medHeadBean) throws Exception {
		try{
			Double saFrom = medHeadBean.getMEH_SUM_ASSURED_FM();
			if(CommonUtils.nvl(saFrom, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "333000"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void AGE_FROM(PM_IL_MED_EXAM_HDR medHeadBean)
			throws Exception {
		try{
			Integer ageFrom = medHeadBean.getMEH_AGE_FM();
			if(CommonUtils.nvl(ageFrom, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "333000"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * Validation For Medical Header Range
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void L_VALIDATE_RANGE(PM_IL_MED_EXAM_HDR medExamHeaderBean)
	throws Exception {
		String M_DUMMY = null;
		String query = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Object values[] = null;
		CRUDHandler handler = new CRUDHandler();
		String rowId = medExamHeaderBean.getROWID();
		try {
			connection = CommonUtils.getConnection();
			query = "SELECT ROWID FROM PM_IL_MED_EXAM_HDR WHERE (MEH_SUM_ASSURED_FM BETWEEN ? AND ? " +
			" OR MEH_SUM_ASSURED_TO BETWEEN ? AND ? OR ? BETWEEN MEH_SUM_ASSURED_FM " +
			" AND MEH_SUM_ASSURED_TO) AND (MEH_AGE_FM BETWEEN ? AND ? OR MEH_AGE_TO BETWEEN ? AND ? OR " +
			" ? BETWEEN MEH_AGE_FM AND MEH_AGE_TO) AND MEH_PT_SYS_ID = ?";

			values = new Object[11];
			values[0] = medExamHeaderBean.getMEH_SUM_ASSURED_FM();
			values[1] = medExamHeaderBean.getMEH_SUM_ASSURED_TO();
			values[2] = medExamHeaderBean.getMEH_SUM_ASSURED_FM();
			values[3] = medExamHeaderBean.getMEH_SUM_ASSURED_TO();
			values[4] = medExamHeaderBean.getMEH_SUM_ASSURED_TO();
			values[5] = medExamHeaderBean.getMEH_AGE_FM();
			values[6] = medExamHeaderBean.getMEH_AGE_TO();
			values[7] = medExamHeaderBean.getMEH_AGE_FM();
			values[8] = medExamHeaderBean.getMEH_AGE_TO();
			values[9] = medExamHeaderBean.getMEH_AGE_TO();
			values[10] = medExamHeaderBean.getMEH_PT_SYS_ID();
			resultSet = handler.executeSelectStatement(query, connection, values);
			if(resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
			}
			if(M_DUMMY != null && !M_DUMMY.equals(rowId)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71015"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void L_VALIDATE_DTL_RANGE(PM_IL_MED_EXAM_DTL medDtlsBean) throws Exception {
		String M_DUMMY = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String rowId = medDtlsBean.getROWID();
		String query = "SELECT ROWID FROM PM_IL_MED_EXAM_DTL WHERE MED_MEH_SYS_ID = ? AND MED_EXAM_CODE = ?";
		Object object[] = {medDtlsBean.getMED_MEH_SYS_ID(), medDtlsBean.getMED_EXAM_CODE()};
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, object);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
			}
			if (M_DUMMY != null && !M_DUMMY.equals(rowId)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71015"));
			} 
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void medExamDtlsPostQuery(PM_IL_MED_EXAM_DTL_ACTION examDtlAction, PM_IL_MED_EXAM_DTL dtlsBean) throws Exception {
		ArrayList<String> CodeDescList = null;
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		try {
			CodeDescList = procedures.helperP_VAL_CODES(
					"IL_MED_EXM", dtlsBean.getMED_EXAM_CODE(), "N", "N", null);
			if (CodeDescList != null && CodeDescList.size() != 0) {
				dtlsBean.setUI_M_MED_EXAM_CODE_DESC(CodeDescList.get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					"PM_IL_MED_EXAM_DTL", examDtlAction.getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void medExamHeaderPreInsert(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, PM_IL_MED_EXAM_HDR medHeadBean) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM DUAL";
		try {
			L_VALIDATE_RANGE(medHeadBean);
			medHeadBean.setMEH_PT_SYS_ID(compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID());
			medHeadBean.setMEH_CR_DT(commonUtils.getCurrentDate());
			medHeadBean.setMEH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			if(resultSet.next()) {
				medHeadBean.setMEH_SYS_ID(resultSet.getDouble(1));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void medExamHeaderPreUpdate(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, PM_IL_MED_EXAM_HDR medHeadBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		medHeadBean.setMEH_PT_SYS_ID(compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID());
		medHeadBean.setMEH_UPD_DT(commonUtils.getCurrentDate());
		medHeadBean.setMEH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}

	public void medExamCodeWhenValidateItem(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		ArrayList<String> CodeDescList = null;
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_MED_EXAM_DTL medDtlsBean = compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getPM_IL_MED_EXAM_DTL_BEAN();
		try {
			CodeDescList = procedures.helperP_VAL_CODES(
					"IL_MED_EXM", medDtlsBean.getMED_EXAM_CODE(), "N", "E", null);
			if (CodeDescList != null && CodeDescList.size() != 0) {
				medDtlsBean.setUI_M_MED_EXAM_CODE_DESC(CodeDescList.get(0));
			}
			L_VALIDATE_DTL_RANGE(medDtlsBean);
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					"PM_IL_MED_EXAM_DTL", compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void medExamDtlPreInsert(PM_IL_MED_EXAM_HDR headerBean, PM_IL_MED_EXAM_DTL medDtlsBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		medDtlsBean.setMED_MEH_SYS_ID(headerBean.getMEH_SYS_ID());
		medDtlsBean.setMED_CR_DT(commonUtils.getCurrentDate());
		medDtlsBean.setMED_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		L_VALIDATE_DTL_RANGE(medDtlsBean);
	}
	
	public void medExamDtlPreUpdate(PM_IL_MED_EXAM_DTL medDtlsBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		medDtlsBean.setMED_UPD_DT(commonUtils.getCurrentDate());
		medDtlsBean.setMED_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
}
