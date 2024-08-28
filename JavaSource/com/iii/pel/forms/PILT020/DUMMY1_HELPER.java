package com.iii.pel.forms.PILT020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY1_HELPER extends CommonAction {

	// Triggers Starts from Here
	CRUDHandler handler = new CRUDHandler();
	CommonUtils utility = new CommonUtils();
	ControlBean ctrlBean = null;
	ResultSet rs = null;
	Map<String, Object> session = getSession();

	public void createCtrlBean() {
		ControlBean bean = new ControlBean();
		getSession().put("ctrlbean", bean);
	}

	public Map<String, Object> getSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public ControlBean getCtrlBean() {
		return (ControlBean) getSession().get("ctrlbean");
	}

	public void putCtrlBean(ControlBean bean) {
		getSession().put("ctrlbean", bean);
	}

	// trigger for Employer Code
	public void when_validate_ui_m_employer_code() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		// CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String C1 = "SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_CODE ='"
				+ actionBean.getDUMMY1_ACTION_BEAN()
						.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue()
				+ "' AND NVL(CONT_EMPLOYER_YN,'N') = 'Y'";
		Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN()
				.getErrorMap();
		try {
			if (actionBean.getDUMMY1_ACTION_BEAN().getCOMP_UI_M_EMPLOYER_CODE()
					.getSubmittedValue() != null
					&& !"".equals(actionBean.getDUMMY1_ACTION_BEAN()
							.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue())) {
				rs = handler.executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (rs.next()) {
					String EMPLOYER_CODE_DESC = rs.getString("CONT_NAME");
					System.out.println("CONT_NAME IS***************"
							+ EMPLOYER_CODE_DESC);
					actionBean.getDUMMY1_ACTION_BEAN()
							.getCOMP_UI_M_EMPLOYER_CODE_DESC()
							.setSubmittedValue(EMPLOYER_CODE_DESC);
				}

			} else {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "91089");
				throw new ValidatorException(new FacesMessage(message));
				//errMap.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				//errMap.put("someKey", message);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		errMap.clear();
	}

	// end of trigger
	public void when_validate_ui_m_contractor_code() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String C1 = "SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_CODE ='"
				+ actionBean.getDUMMY1_ACTION_BEAN()
						.getCOMP_UI_M_CONTRACTOR_CODE().getSubmittedValue()
				+ "' AND NVL(CONT_EMPLOYER_YN,'N') = 'N'";
		System.out.println("Query output in trigger+++++++++" + C1);
		try {
			if (actionBean.getDUMMY1_ACTION_BEAN()
					.getCOMP_UI_M_CONTRACTOR_CODE().getSubmittedValue() == null
					&& (actionBean.getDUMMY1_ACTION_BEAN()
							.getCOMP_UI_M_CONTRACTOR_CODE().getSubmittedValue()) == "") {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "91090");
				//Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN()
				//		.getErrorMap();
				//errMap.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				//errMap.put("someKey", message);
				throw new ValidatorException(new FacesMessage(message));
			}
			if (actionBean.getDUMMY1_ACTION_BEAN()
					.getCOMP_UI_M_CONTRACTOR_CODE().getSubmittedValue() != null
					&& !""
							.equals(actionBean.getDUMMY1_ACTION_BEAN()
									.getCOMP_UI_M_CONTRACTOR_CODE()
									.getSubmittedValue())) {
				rs = handler.executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (rs.next()) {
					String CONT_DESC = rs.getString("CONT_NAME");
					actionBean.getDUMMY1_ACTION_BEAN()
							.getCOMP_UI_M_CONTRACTOR_CODE_DESC()
							.setSubmittedValue(rs.getString("CONT_NAME"));
				}
			} else {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "91069");
				//Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN()
				//		.getErrorMap();
				//errMap.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				//errMap.put("someKey", message);
				throw new ValidatorException(new FacesMessage(message));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// end of trigger
	// trigger for Currency
	public void when_validate_ui_m_curr_code() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		/*
		 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_CURRENCY to
		 * FM_CURRENCY. Added by : Mallika.S, 01-Apr-2009
		 */
		// String C1 = "select CURR_NAME from FM_CURRENCY WHERE CURR_CODE
		// ='"+actionBean.getDUMMY1_ACTION_BEAN().getCOMP_UI_M_POL_CURR_CODE().getSubmittedValue()+"'";
		// System.out.println("Query output in trigger+++++++++"+C1);
		try {
			if (actionBean.getDUMMY1_ACTION_BEAN().getCOMP_UI_M_POL_CURR_CODE()
					.getSubmittedValue() != null
					&& !"".equals(actionBean.getDUMMY1_ACTION_BEAN()
							.getCOMP_UI_M_POL_CURR_CODE().getSubmittedValue())) {
				// rs = handler.executeSelectStatement(C1,
				// CommonUtils.getConnection());
				// if(rs.next())
				// {
				// String CONT_DESC = rs.getString("CURR_NAME");
				// System.out.println("the currency name---------->"+CONT_DESC);
				// actionBean.getDUMMY1_ACTION_BEAN().getCOMP_UI_M_CURR_NAME().setSubmittedValue(rs.getString("CURR_NAME"));
				// }

				if (null != actionBean.getDUMMY1_ACTION_BEAN()
						.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue()
						&& !actionBean.getDUMMY1_ACTION_BEAN()
								.getCOMP_UI_M_EMPLOYER_CODE()
								.getSubmittedValue().toString().isEmpty()) {

					ArrayList<String> currDesc = new DBProcedures().P_VAL_CURR(
							actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
									.getUI_M_POL_CURR_CODE(), "N", "E",
							actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
									.getUI_M_EMPLOYER_CODE());
					String CONT_DESC = currDesc.get(0);
					actionBean.getDUMMY1_ACTION_BEAN().getCOMP_UI_M_CURR_NAME()
							.setSubmittedValue(CONT_DESC);

				} else {
					ArrayList<String> currDesc = new DBProcedures().P_VAL_CURR(
							actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
									.getUI_M_POL_CURR_CODE(), "N", "E", "");
					String CONT_DESC = currDesc.get(0);
					actionBean.getDUMMY1_ACTION_BEAN().getCOMP_UI_M_CURR_NAME()
							.setSubmittedValue(CONT_DESC);
				}

			}
			rs.close();
		} catch (Exception e) {
			// ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
			// FacesContext.getCurrentInstance(), "", getErrorMap());
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"", getErrorMap());
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		} finally {

		}
	}

	// end of trigger Currency
	// trigger for paid dt
	public void when_validate_ui_m_paid_dt() throws Exception {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		int M_COUNT;
		Object params[] = null;
		Object params2[] = null;
		String tempCodeName = null;
		String M_CONT_CODE = actionBean.getDUMMY1_ACTION_BEAN()
				.getDUMMY1_BEAN().getUI_M_CONTRACTOR_CODE();
		String fmDate = CommonUtils.dateToStringFormatter(actionBean
				.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
				.getUI_M_DUE_PERIOD_FM());
		String toDate = CommonUtils.dateToStringFormatter(actionBean
				.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
				.getUI_M_DUE_PERIOD_TO());
		String C1 = "SELECT COUNT(*) FROM PT_IL_PREM_COLL WHERE  PC_CONT_CODE ='"
				+ M_CONT_CODE
				+ "' AND PC_SCHD_PYMT_DT BETWEEN "
				+ "'"
				+ fmDate
				+ "' AND '"
				+ toDate
				+ "' "
				+ "AND NVL(PC_PAID_FLAG,'N') IN ('Y','N')";
		String C2 = "SELECT COUNT(*) FROM   PT_IL_PREM_COLL WHERE  PC_CONT_CODE='"
				+ actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_CONTRACTOR_CODE()
				+ "' "
				+ "AND PC_SCHD_PYMT_DT <'"
				+ fmDate
				+ "' AND NVL(PC_PAID_FLAG,'N') != 'A'";

		// :GLOBAL.M_CONTRACTOR_CODE := NULL;
		// :GLOBAL.M_EMPLOYER_CODE := NULL;
		if (actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
				.getUI_M_EMPLOYER_CODE() != null
				&& actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_EMPLOYER_CODE() != "") {
			M_CONT_CODE = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
					.getUI_M_EMPLOYER_CODE();
			tempCodeName = "Employer Code";

		} else if (actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
				.getUI_M_CONTRACTOR_CODE() != null
				&& actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_CONTRACTOR_CODE() != "") {
			M_CONT_CODE = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
					.getUI_M_CONTRACTOR_CODE();
			tempCodeName = "Contractor Code ";
		}
		// :GLOBAL.M_CONTRACTOR_CODE := M_CONT_CODE;
		params = new Object[3];
		params[0] = tempCodeName;
		params[1] = "Due Period From";
		params[2] = "Due Period To";
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		if (rs.next()) {
			M_COUNT = rs.getInt(1);
			if (M_COUNT == 0) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "91132", params);
				actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_POPUP().setDisabled(
						true);
				throw new ValidatorException(new FacesMessage(message));
				// throw new
				// Exception(Messages.getString(PELConstants.pelErrorMessagePath,
				// "91132", params));
			} else if (M_COUNT > 0) {
				actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_POPUP().setDisabled(
						false);
			}
		}
		rs.close();

		params2 = new Object[1];
		params2[0] = "Due Period From";
		rs = handler.executeSelectStatement(C2, CommonUtils.getConnection());
		if (rs.next()) {
			M_COUNT = rs.getInt(1);
			if (M_COUNT == 0) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "91133", params2);
				actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_POPUP().setDisabled(
						true);
				throw new ValidatorException(new FacesMessage(message));
				//throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91133", params2));
			} else if (M_COUNT > 0) {
				actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_POPUP().setDisabled(false);
			}
		}
		rs.close();

	}

	//end of trigger for paid_dt
	public void approvePremim() {
		try {
			PILT020_BUTTON_LEVEL_PROCEDURES pilt020_button_level_procedures = new PILT020_BUTTON_LEVEL_PROCEDURES();
			pilt020_button_level_procedures
					.pilt_020_when_button_press_approve();
		} catch (Exception e) {
			
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	e.getMessage());
		}
	}
}
