package com.iii.pel.forms.PILP024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.jasperreports.CallJasPerReport;
import com.iii.pel.jasperreports.OpenJasPerReport;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY_HELPER_ACTION {

	Map<String, Object> session = getSession();

	// Triggers Starts from Here
	CRUDHandler handler = new CRUDHandler();
	CommonUtils util = new CommonUtils();
	ControlBean ctrlBean = null;

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

	public void STD_PRE_FORM() {
		// P_GET_LOGO;
		// COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
		createCtrlBean();
		ctrlBean = getCtrlBean();
		Map<String, Object> session = getSession();
		System.out.println("DUMMY_ACTION.STD_PRE_FORM()\n---------->\n"
				+ session.toString() + "\n----------");
		ctrlBean.setM_PARA_1((String) session.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_USER_ID((String) session.get("GLOBAL.M_USER_ID"));
		// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		// ctrlBean.setM_PROG_NAME("PILT010");
		// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		// 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("DUMMY_ACTION.STD_PRE_FORM(------)"
				+ (String) session.get("GLOBAL.M_NAME"));
		ctrlBean.setM_SCR_NAME(((String) session.get("GLOBAL.M_NAME"))
				.substring(30, 42));
		// COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		ctrlBean.setM_LANG_CODE((String) session.get("GLOBAL.M_LANG_CODE"));
		ctrlBean.setM_COMP_CODE(((String) session.get("GLOBAL.M_DFLT_VALUES"))
				.substring(0, 3));
		ctrlBean.setM_DIVN_CODE(((String) session.get("GLOBAL.M_DFLT_VALUES"))
				.substring(3, 6));
		System.out.println("DUMMY_ACTION.STD_PRE_FORM(!!!! ) "
				+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		ctrlBean.setM_DEPT_CODE(((String) session.get("GLOBAL.M_DFLT_VALUES"))
				.substring(9, 11));

		putCtrlBean(ctrlBean);
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "
				+ ctrlBean.getM_LANG_CODE() + "\t" + ctrlBean.getM_COMP_CODE()
				+ "\t" + ctrlBean.getM_PARA_1());
		/**
		 * GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN
		 * RECORD GROUP *
		 */

	}

	public void pilp024_dummy_ui_m_policy_fm_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		System.out.println("in helper");
		CommonUtils utility = new CommonUtils();
		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		if (actionBean.getCOMP_UI_M_POLICY_FM().getSubmittedValue() == null
				|| ((String) actionBean.getCOMP_UI_M_POLICY_FM()
						.getSubmittedValue()).trim().length() == 0) {

			System.out.println("Policy From value is "
					+ actionBean.getCOMP_UI_M_POLICY_FM().getSubmittedValue()
					+ " Setting from product code value to 0");
			actionBean.getDUMMY_BEAN().setUI_M_POLICY_FM("0");
			// actionBean.getDUMMY_BEAN().setUI_M_FM_PROD_DESC("");
			// setting submitted values to null so that JSF will pick values for
			// the fields from value bean
			actionBean.getCOMP_UI_M_POLICY_FM().setSubmittedValue(null);
			// actionBean.getCOMP_UI_M_FM_PROD_DESC().setSubmittedValue(null);
		}
	}

	public void pilp024_dummy_ui_m_policy_to_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		List resultList = null;
		CommonUtils utility = new CommonUtils();

		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String fromPolicyCode = (String) actionBean.getCOMP_UI_M_POLICY_FM()
				.getSubmittedValue();
		String toPolicyCode = (String) actionBean.getCOMP_UI_M_POLICY_TO()
				.getSubmittedValue();

		if (toPolicyCode == null || toPolicyCode.trim().length() == 0) {

			if (fromPolicyCode.equals("0")) {
				actionBean.getDUMMY_BEAN().setUI_M_POLICY_TO("zzzzzzzzzzzzzzz");
				// actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC("");
			} else {
				actionBean.getDUMMY_BEAN().setUI_M_POLICY_TO(fromPolicyCode);
				// actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC
				// ((String)actionBean.getCOMP_UI_M_FM_PROD_DESC().getSubmittedValue());

			}
			// setting submitted values to null so that JSF will pick values for
			// the fields from value bean
			actionBean.getCOMP_UI_M_POLICY_TO().setSubmittedValue(null);
			//			
		} else {
			// procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					fromPolicyCode);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					toPolicyCode);
			OracleParameter param3 = new OracleParameter("in3", "STRING",
					"OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList) paramList, utility
						.getConnection(), "PR_VALIDATE_FM_TO");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Map<String, String> errMap = actionBean.getErrorMap();
			System.out
					.println("PILP024.to_Policy_code action \n--------------- OUTPUTPARAM -----------------	--\n"
							+ ((OracleParameter) resultList.get(0)).getValue()
							+ "\n----------------");
			if (Integer.parseInt(((OracleParameter) resultList.get(0))
					.getValue()) == 1) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "10064");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_POLICY_TO$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("someKey", message);
			} else {
				errMap.clear();
			}
		}
	}

	// For Set First field field UI_M_DIVN_FM
	public void pilp024_dummy_ui_m_divn_fm_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		System.out.println("in helper");
		CommonUtils utility = new CommonUtils();
		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		if (actionBean.getCOMP_UI_M_DIVN_FM().getSubmittedValue() == null
				|| ((String) actionBean.getCOMP_UI_M_DIVN_FM()
						.getSubmittedValue()).trim().length() == 0) {

			System.out.println("UI_M_DIVN_FM From value is "
					+ actionBean.getCOMP_UI_M_POLICY_FM().getSubmittedValue()
					+ " Setting from product code value to 0");
			actionBean.getDUMMY_BEAN().setUI_M_DIVN_FM("0");
			// actionBean.getDUMMY_BEAN().setUI_M_FM_PROD_DESC("");
			// setting submitted values to null so that JSF will pick values for
			// the fields from value bean
			actionBean.getCOMP_UI_M_DIVN_FM().setSubmittedValue(null);
			// actionBean.getCOMP_UI_M_FM_PROD_DESC().setSubmittedValue(null);
		}
	}

	// For setting the secong Field Value
	public void pilp024_dummy_ui_m_divn_to_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		List resultList = null;
		CommonUtils utility = new CommonUtils();

		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String fromDivnCode = (String) actionBean.getCOMP_UI_M_DIVN_FM()
				.getSubmittedValue();
		String toDivnCode = (String) actionBean.getCOMP_UI_M_DIVN_TO()
				.getSubmittedValue();

		if (toDivnCode == null || toDivnCode.trim().length() == 0) {

			if (fromDivnCode.equals("0")) {
				actionBean.getDUMMY_BEAN().setUI_M_DIVN_TO("zzzzzzzzzz");
				// actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC("");
			} else {
				actionBean.getDUMMY_BEAN().setUI_M_DIVN_TO(fromDivnCode);
				// actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC
				// ((String)actionBean.getCOMP_UI_M_FM_PROD_DESC().getSubmittedValue());

			}
			// setting submitted values to null so that JSF will pick values for
			// the fields from value bean
			actionBean.getCOMP_UI_M_DIVN_TO().setSubmittedValue(null);
			//			
		} else {
			// procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					fromDivnCode);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					toDivnCode);
			OracleParameter param3 = new OracleParameter("in3", "STRING",
					"OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList) paramList, utility
						.getConnection(), "PR_VALIDATE_FM_TO");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Map<String, String> errMap = actionBean.getErrorMap();
			System.out
					.println("PILP024.to_prod_code action \n--------------- OUTPUTPARAM -----------------	--\n"
							+ ((OracleParameter) resultList.get(0)).getValue()
							+ "\n----------------");
			if (Integer.parseInt(((OracleParameter) resultList.get(0))
					.getValue()) == 1) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "10064");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_DIVN_TO$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("someKey", message);
			} else {
				errMap.clear();
			}
		}
	}

	// For setting first value for UI_M_DEPT_FM
	public void pilp024_dummy_ui_m_dept_fm_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		System.out.println("in helper");
		CommonUtils utility = new CommonUtils();
		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		if (actionBean.getCOMP_UI_M_DEPT_FM().getSubmittedValue() == null
				|| ((String) actionBean.getCOMP_UI_M_DEPT_FM()
						.getSubmittedValue()).trim().length() == 0) {

			System.out.println("UI_M_DEPT_FM From value is "
					+ actionBean.getCOMP_UI_M_DEPT_FM().getSubmittedValue()
					+ " Setting from product code value to 0");
			actionBean.getDUMMY_BEAN().setUI_M_DEPT_FM("0");
			// actionBean.getDUMMY_BEAN().setUI_M_FM_PROD_DESC("");
			// setting submitted values to null so that JSF will pick values for
			// the fields from value bean
			actionBean.getCOMP_UI_M_DEPT_FM().setSubmittedValue(null);
			// actionBean.getCOMP_UI_M_FM_PROD_DESC().setSubmittedValue(null);
		}
	}

	// For setting first value for UI_M_DEPT_TO
	public void pilp024_dummy_ui_m_dept_to_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		List resultList = null;
		CommonUtils utility = new CommonUtils();

		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String fromDivnCode = (String) actionBean.getCOMP_UI_M_DEPT_FM()
				.getSubmittedValue();
		String toDivnCode = (String) actionBean.getCOMP_UI_M_DEPT_TO()
				.getSubmittedValue();

		if (toDivnCode == null || toDivnCode.trim().length() == 0) {
			if (fromDivnCode.equals("0")) {
				actionBean.getDUMMY_BEAN().setUI_M_DEPT_TO("zzzzzzzzzz");
				// actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC("");
			} else {
				actionBean.getDUMMY_BEAN().setUI_M_DEPT_TO(fromDivnCode);
				// actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC
				// ((String)actionBean.getCOMP_UI_M_FM_PROD_DESC().getSubmittedValue());

			}
			// setting submitted values to null so that JSF will pick values for
			// the fields from value bean
			actionBean.getCOMP_UI_M_DEPT_TO().setSubmittedValue(null);
		} else {
			// procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					fromDivnCode);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					toDivnCode);
			OracleParameter param3 = new OracleParameter("in3", "STRING",
					"OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList) paramList, utility
						.getConnection(), "PR_VALIDATE_FM_TO");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Map<String, String> errMap = actionBean.getErrorMap();
			System.out
					.println("PILP024.to_prod_code action \n--------------- OUTPUTPARAM -----------------	--\n"
							+ ((OracleParameter) resultList.get(0)).getValue()
							+ "\n----------------");
			if (Integer.parseInt(((OracleParameter) resultList.get(0))
					.getValue()) == 1) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "10064");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_DEPT_TO$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("someKey", message);
			} else {
				errMap.clear();
			}
		}
	}

	public void pilp024_dummy_ui_m_fm_dt_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		System.out.println("in helper");
		CommonUtils utility = new CommonUtils();

		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		Date fromDate = actionBean.getCOMP_UI_M_FM_DT().getAsDate(
				actionBean.getCOMP_UI_M_FM_DT().getSubmittedValue());
		Date toDate = actionBean.getCOMP_UI_M_TO_DT().getAsDate(
				actionBean.getCOMP_UI_M_TO_DT().getValue());
		actionBean.getDUMMY_BEAN().setUI_M_FM_DT(fromDate);
		try {

			Date currentDate = utility.getCurrentDate();
			System.out.println(fromDate + "**" + currentDate + "**" + toDate);
			if (fromDate.after(currentDate)) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "2181");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_FM_DT$caption");
				message = msg + ":" + message;

				errMap.put("current", message);
				errMap.put("fromDate1", message);
				return;
			} else if (toDate.before(fromDate)) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "1050");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_FM_DT$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("fromDate2", message);
				return;
			} else {
				errMap.clear();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void pilp024_dummy_ui_m_to_dt_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		System.out.println("in helper");
		CommonUtils utility = new CommonUtils();

		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		Date fromDate = actionBean.getCOMP_UI_M_FM_DT().getAsDate(
				actionBean.getCOMP_UI_M_FM_DT().getValue());
		Date toDate = actionBean.getCOMP_UI_M_TO_DT().getAsDate(
				actionBean.getCOMP_UI_M_TO_DT().getSubmittedValue());
		actionBean.getDUMMY_BEAN().setUI_M_TO_DT(toDate);
		try {
			Date currentDate = utility.getCurrentDate();
			System.out.println(fromDate + "**" + currentDate + "**" + toDate);
			if (toDate.before(fromDate)) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "1050");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_TO_DT$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("toDate1", message);
				return;
			} else {
				errMap.clear();
			}

			if (toDate.after(currentDate)) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "2181");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_TO_DT$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("toDate2", message);
				return;
			} else {
				errMap.clear();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void pilp024_dummy_ui_process_fm_dt_when_validate_item() {
		String mappedBeanName = "PILP024_DUMMY_ACTION";
		System.out.println("in helper");
		CommonUtils utility = new CommonUtils();

		DUMMY_ACTION actionBean = (DUMMY_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		Date fromDate = actionBean.getCOMP_UI_M_PROCESS_DT().getAsDate(
				actionBean.getCOMP_UI_M_PROCESS_DT().getSubmittedValue());
		Date toDate = actionBean.getCOMP_UI_M_PROCESS_DT().getAsDate(
				actionBean.getCOMP_UI_M_PROCESS_DT().getValue());
		actionBean.getDUMMY_BEAN().setUI_M_PROCESS_DT(fromDate);
		try {

			Date currentDate = utility.getCurrentDate();
			System.out.println(fromDate + "**" + currentDate + "**" + toDate);
			if (fromDate.after(currentDate)) {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "2181");
				String msg = ResourceBundle.getBundle(
						"messageProperties_PILP024").getString(
						"PILP024$DUMMY$UI_M_PROCESS_DT$caption");
				message = msg + ":" + message;
				errMap.put("current", message);
				errMap.put("fromDate1", message);
				return;
			} else {
				errMap.clear();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void process(DUMMY dummy_bean) {

		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		ResultSet resultSet1 = null;
		PILP024_DB_PROCEDURE db_procedures = new PILP024_DB_PROCEDURE();
		String M_RS_REPORT_NAME = null;// PW_IL_REMINDER_SUMMARY.RS_REPORT_NAME%TYPE;
		Long M_DSRC_SYS_ID = null; // PW_IL_DATA_SOURCE.DSRC_SYS_ID%TYPE;
		String M_FLAG = null; // VARCHAR2(1) ;
		String M_PS_VALUE = null; // PP_SYSTEM.PS_VALUE%TYPE;
		Long M_SMV_POL_SYS_ID = null; // PT_IL_SURR_MAT_VALUES.SMV_POL_SYS_ID%TYPE
		String M_SMV_TYPE = null; // PT_IL_SURR_MAT_VALUES.SMV_TYPE%TYPE;
		Long M_CLAIM_SYS_ID = null; // PT_IL_CLAIM.CLAIM_SYS_ID%TYPE;
		String M_REP_NAME = null; // PM_CODES.PC_DESC%TYPE ;
		String M_PC_DESC = null; // PM_CODES.PC_DESC%TYPE ;
		String M_PC_BL_DESC = null; // PM_CODES.PC_BL_DESC%TYPE;
		String M_CONT_PREFERRED_LANG = null; // PM_IL_CONTRACTOR.CONT_PREFERRED_LANG%TYPE;
		String M_PRINT_TYPE = null; // VARCHAR2(1) ;
		Long M_POL_SYS_ID = null; // PW_IL_REMINDER_SUMMARY.RS_POL_SYS_ID%TYPE;
		String M_RS_DS_TYPE = null; // PW_IL_REMINDER_SUMMARY.RS_DS_TYPE%TYPE;
		Integer M_RS_END_NO_IDX = null; // PW_IL_REMINDER_SUMMARY.RS_END_NO_IDX%TYPE;
		Integer M_DUMMY = null; // NUMBER :=0;
		String M_PS_CODE_DESC = null; // PP_SYSTEM.PS_CODE_DESC%TYPE ;
		Integer M_CALC_METHOD = null; // PP_SYSTEM.PS_VALUE%TYPE ;
		String M_PLAN_TYPE = null; // PM_IL_PLAN.PLAN_TYPE%TYPE;
		String insertQuery = null;
		String deleteQuery = null;
		PILP024_RETURN_VALUES pilp024_return_values = null;
		String reportName = null;

		try {

			String CIA = " SELECT DISTINCT RS_REPORT_NAME "
					+ "  FROM   PW_IL_REMINDER_SUMMARY "
					+ "  WHERE RS_REPORT_NAME IS NOT NULL "
					+ "  AND   RS_POL_SYS_ID IN (SELECT  POL_SYS_ID "
					+ "  FROM    PT_IL_POLICY"
					+ " WHERE   POL_PLAN_CODE IN(SELECT  PLAN_CODE"
					+ "FROM    PM_IL_PLAN" + " WHERE   PLAN_TYPE  = 'M')  "
					+ "AND     POL_NO        BETWEEN '"
					+ dummy_bean.getUI_M_POLICY_FM()
					+ "'    "
					+ "  AND '"
					+ dummy_bean.getUI_M_POLICY_TO()
					+ "' "
					+ "AND     POL_DIVN_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DIVN_FM()
					+ "'  "
					+ " AND '"
					+ dummy_bean.getUI_M_DIVN_TO()
					+ "' "
					+ "AND     POL_DEPT_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DEPT_FM()
					+ "'      "
					+ "  AND '"
					+ dummy_bean.getUI_M_DEPT_TO()
					+ "' "
					+ "AND     POL_ISSUE_DT "
					+ " BETWEEN TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_FM_DT())
					+ "') AND TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_TO_DT())
					+ "'))"
					+ " GROUP BY RS_REPORT_NAME";

			reportName = excuteC1A(resultSet, CIA, connection, handler);
			M_RS_REPORT_NAME = reportName;

			String C1 = "SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID"
					+ "FROM   PW_IL_REMINDER_SUMMARY"
					+ "WHERE RS_REPORT_NAME IS NOT NULL "
					+ "AND   RS_POL_SYS_ID IN (SELECT  POL_SYS_ID"
					+ "FROM    PT_IL_POLICY"
					+ "WHERE   POL_PLAN_CODE IN(SELECT  PLAN_CODE"
					+ "FROM    PM_IL_PLAN" + "WHERE   PLAN_TYPE  = 'M') "
					+ "AND     POL_NO        BETWEEN '"
					+ dummy_bean.getUI_M_POLICY_FM()
					+ "'  "
					+ " AND '"
					+ dummy_bean.getUI_M_POLICY_TO()
					+ "' "
					+ "AND POL_DIVN_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DIVN_FM()
					+ "'  AND '"
					+ dummy_bean.getUI_M_DIVN_TO()
					+ "' "
					+ "AND     POL_DEPT_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DEPT_FM()
					+ "'  "
					+ "  AND '"
					+ dummy_bean.getUI_M_DEPT_TO()
					+ "' "
					+ "AND     POL_ISSUE_DT  BETWEEN TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_FM_DT())
					+ "') "
					+ "AND TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_TO_DT())
					+ "'))"
					+ "AND  RS_REPORT_NAME = '" + M_RS_REPORT_NAME + "' ";

			M_DUMMY = 0;
			pilp024_return_values = excuteC1(resultSet, C1, connection,
					handler, db_procedures);
			M_RS_REPORT_NAME = pilp024_return_values.getName1();
			M_POL_SYS_ID = pilp024_return_values.getLongNumber1();
			M_DUMMY = pilp024_return_values.getNumber1();

			/* LETTER II */

			String C8A = " SELECT DISTINCT RS_REPORT_NAME"
					+ "FROM   PW_IL_REMINDER_SUMMARY"
					+ "WHERE  RS_REPORT_NAME IS NOT NULL"
					+ "AND    RS_POL_SYS_ID IN (SELECT  CLAIM_SYS_ID"
					+ "FROM    PT_IL_CLAIM"
					+ "WHERE   CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID"
					+ "FROM   PT_IL_POLICY"
					+ "WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE"
					+ "AND    POL_NO        BETWEEN '"
					+ dummy_bean.getUI_M_POLICY_FM()
					+ "'      "
					+ "AND '"
					+ dummy_bean.getUI_M_POLICY_TO()
					+ "' "
					+ "AND    POL_DIVN_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DIVN_FM()
					+ "'  "
					+ "      AND '"
					+ dummy_bean.getUI_M_DIVN_TO()
					+ "' "
					+ "AND    POL_DEPT_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DEPT_FM()
					+ "'  "
					+ "      AND '"
					+ dummy_bean.getUI_M_DEPT_TO()
					+ "' "
					+ "  AND    POL_ISSUE_DT  BETWEEN TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_FM_DT())
					+ "') "
					+ "AND TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_TO_DT())
					+ "') ))"
					+ "GROUP BY RS_REPORT_NAME";

			String C9 = " SELECT DSRC_SYS_ID.NEXTVAL  " + " FROM   DUAL";

			pilp024_return_values = excuteC8A(resultSet, C8A, connection,
					handler, db_procedures, C9, dummy_bean);
			reportName = pilp024_return_values.getName1();
			M_DUMMY = pilp024_return_values.getNumber1();
			M_CLAIM_SYS_ID = pilp024_return_values.getLongNumber2();
			M_RS_REPORT_NAME = reportName;

			String C4 = " SELECT PC_DESC,PC_BL_DESC"
					+ " FROM PM_CODES WHERE  PC_TYPE = 'IL_REMIN_RPT' "
					+ " AND PC_CODE IN (SELECT PS_CODE_DESC FROM   "
					+ " PP_SYSTEM WHERE  PS_TYPE = 'MATURITY_LTR'"
					+ " AND    PS_CODE = 'MAT_ACK') ";

			String C5 = " SELECT CONT_PREFERRED_LANG "
					+ " FROM   PM_IL_CONTRACTOR "
					+ " WHERE  CONT_CODE = (SELECT POL_CONT_CODE "
					+ " FROM PT_IL_POLICY WHERE  POL_SYS_ID = '"
					+ M_SMV_POL_SYS_ID + "' AND POL_DS_TYPE = '2')";

			String C6 = " SELECT SMV_POL_SYS_ID,SMV_TYPE "
					+ " FROM   PT_IL_SURR_MAT_VALUES WHERE  SMV_DATE "
					+ " BETWEEN '"
					+ dummy_bean.getUI_M_PROCESS_DT()
					+ "' "
					+ " AND ('"
					+ dummy_bean.getUI_M_PROCESS_DT()
					+ "' + '"
					+ M_PS_VALUE
					+ "') "
					+ " AND SMV_POL_SYS_ID IN (SELECT POL_SYS_ID "
					+ " FROM PT_IL_POLICY WHERE POL_NO BETWEEN '"
					+ dummy_bean.getUI_M_POLICY_FM()
					+ "' "
					+ " AND '"
					+ dummy_bean.getUI_M_POLICY_TO()
					+ "' AND POL_DIVN_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DIVN_FM()
					+ "' "
					+ " AND '"
					+ dummy_bean.getUI_M_DIVN_TO()
					+ "' AND POL_DEPT_CODE "
					+ " BETWEEN '"
					+ dummy_bean.getUI_M_DEPT_FM()
					+ "' AND '"
					+ dummy_bean.getUI_M_DEPT_TO()
					+ "' "
					+ " AND POL_ISSUE_DT  BETWEEN TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_FM_DT())
					+ "') "
					+ " AND TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_TO_DT()) + "')AND POL_DS_TYPE = '2')";

			String C7 = "SELECT POL_SYS_ID " + " FROM   PT_IL_POLICY WHERE  "
					+ " TRUNC(POL_POSTPONE_EXPIRY_DT) = TRUNC('"
					+ dummy_bean.getUI_M_PROCESS_DT() + "')"
					+ " AND POL_ADDL_STATUS = 'B07' AND POL_DS_TYPE= '1' ";

			String C2A = " SELECT RS_REPORT_NAME "
					+ " FROM PW_IL_REMINDER_SUMMARY "
					+ " WHERE  RS_POL_SYS_ID IN (SELECT   POL_SYS_ID "
					+ " FROM PT_IL_POLICY WHERE"
					+ " POL_PLAN_CODE IN (SELECT PLAN_CODE"
					+ " FROM   PM_IL_PLAN WHERE  PLAN_TYPE <> 'M') "
					+ " AND POL_NO BETWEEN '"
					+ dummy_bean.getUI_M_POLICY_FM()
					+ "' "
					+ " AND '"
					+ dummy_bean.getUI_M_POLICY_TO()
					+ "' AND "
					+ " POL_DIVN_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DIVN_FM()
					+ "' "
					+ " AND '"
					+ dummy_bean.getUI_M_DIVN_TO()
					+ "' AND"
					+ " POL_DEPT_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DEPT_FM()
					+ "' "
					+ " AND '"
					+ dummy_bean.getUI_M_DEPT_TO()
					+ "' AND"
					+ " POL_ISSUE_DT  BETWEEN TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_FM_DT())
					+ "') AND TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_TO_DT()) + "')) GROUP BY RS_REPORT_NAME";

			pilp024_return_values = excuteC2A(resultSet, C2A, connection,
					handler, db_procedures, C9, dummy_bean, M_CLAIM_SYS_ID);
			reportName = pilp024_return_values.getName1();
			M_DUMMY = pilp024_return_values.getNumber1();
			M_POL_SYS_ID = pilp024_return_values.getLongNumber2();
			M_RS_REPORT_NAME = reportName;

			String C3A = "SELECT DISTINCT RS_REPORT_NAME "
					+ " FROM   PW_IL_REMINDER_SUMMARY "
					+ " WHERE  RS_REPORT_NAME IS NOT NULL "
					+ " AND RS_POL_SYS_ID IN (SELECT CLAIM_SYS_ID "
					+ " FROM PT_IL_CLAIM WHERE    "
					+ " CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID "
					+ " FROM   PT_IL_POLICY WHERE  "
					+ " POL_PLAN_CODE IN ( SELECT PLAN_CODE FROM PM_IL_PLAN "
					+ " WHERE  PLAN_TYPE <> 'M') AND POL_NO BETWEEN '"
					+ dummy_bean.getUI_M_POLICY_FM()
					+ "' "
					+ " AND '"
					+ dummy_bean.getUI_M_POLICY_TO()
					+ "' AND POL_DIVN_CODE "
					+ " BETWEEN '"
					+ dummy_bean.getUI_M_DIVN_FM()
					+ "' AND '"
					+ dummy_bean.getUI_M_DIVN_TO()
					+ "' "
					+ " AND POL_DEPT_CODE BETWEEN '"
					+ dummy_bean.getUI_M_DEPT_FM()
					+ "' AND '"
					+ dummy_bean.getUI_M_DEPT_TO()
					+ "' "
					+ " AND POL_ISSUE_DT  BETWEEN TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_FM_DT())
					+ "') "
					+ " AND TO_DATE('"
					+ CommonUtils.dateToPELStringFormatter(dummy_bean
							.getUI_M_TO_DT()) + "'))) GROUP BY RS_REPORT_NAME";

			pilp024_return_values = excuteC3A(resultSet, C3A, connection,
					handler, db_procedures, C9, dummy_bean);

			reportName = pilp024_return_values.getName1();
			M_DUMMY = pilp024_return_values.getNumber1();
			M_DSRC_SYS_ID = pilp024_return_values.getLongNumber1();
			M_RS_REPORT_NAME = reportName;

			if (M_DUMMY == 1) {
				// P_LIFE_LETTER_BATCH(M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE);

				deleteQuery = "DELETE PW_IL_DATA_SOURCE WHERE  DSRC_SYS_ID = '"
						+ M_DSRC_SYS_ID + "' ";

				handler.executeDeleteStatement(deleteQuery, connection);
			}

			if (M_DUMMY == 1) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60315"));
			}
			new DBProcedures().callP_VAL_SYSTEM("IL_MATU_DAYS", "IL_MATU_DAYS",
					M_PS_CODE_DESC, "E", M_PS_VALUE);
			resultSet = handler.executeSelectStatement(C6, connection);
			while (resultSet.next()) {

				M_SMV_POL_SYS_ID = resultSet.getLong("SMV_POL_SYS_ID");
				M_SMV_TYPE = resultSet.getString("SMV_TYPE");
				if (M_SMV_TYPE.equalsIgnoreCase("M")) {
					String updateQuery = " UPDATE PT_IL_POLICY "
							+ " SET POL_ADDL_STATUS = 'M001'"
							+ " WHERE  POL_SYS_ID = '" + M_SMV_POL_SYS_ID
							+ "' " + " AND POL_DS_TYPE = '2' ";

					handler.executeUpdateStatement(updateQuery, connection);

					M_PRINT_TYPE = "B";

					resultSet1 = handler.executeSelectStatement(C4, connection);
					while (resultSet1.next()) {
						M_PC_DESC = resultSet1.getString("PC_DESC");
						M_PC_BL_DESC = resultSet1.getString("PC_BL_DESC");
					}
					resultSet1.close();

					resultSet1 = handler.executeSelectStatement(C5, connection);

					while (resultSet1.next()) {
						M_CONT_PREFERRED_LANG = resultSet1
								.getString("CONT_PREFERRED_LANG");
					}

					if (M_CONT_PREFERRED_LANG == "E") {
						M_REP_NAME = M_PC_DESC;
					} else {
						M_REP_NAME = M_PC_BL_DESC;
					}
					// P9ILPK_UW_LETTERS.GEN_MATURITY_ACK_LETTER(M_DSRC_SYS_ID,M_REP_NAME,M_SMV_POL_SYS_ID);

					ArrayList<String> list = db_procedures
							.callP9ILPK_UW_LETTERS_GEN_MATURITY_ACK_LETTER(
									M_RS_REPORT_NAME, CommonUtils
											.getProcedureValue(M_CLAIM_SYS_ID));
					if (list != null && list.size() > 0) {
						M_DSRC_SYS_ID = Long.parseLong(list.get(0));
					}

					// P_LIFE_LETTER(
					// M_DSRC_SYS_ID,M_REP_NAME,M_PRINT_TYPE,NULL);
				}
			}

			deleteQuery = " DELETE FROM PW_IL_DATA_SOURCE ";

			handler.executeDeleteStatement(deleteQuery, connection);

			deleteQuery = "DELETE FROM PW_IL_REMINDER_SUMMARY";

			handler.executeDeleteStatement(deleteQuery, connection);

			connection.commit();

			if (M_FLAG == "Y") {

				// STD_MESSAGE_ROUTINE(3083,:CTRL.M_LANG_CODE);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3083"));
				// CLEAR_BLOCK(NO_VALIDATE);
			} else {

				// STD_MESSAGE_ROUTINE(91130,:CTRL.M_LANG_CODE,:DUMMY.M_PROCESS_DT,(:DUMMY.M_PROCESS_DT
				// + M_PS_VALUE));
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91130"));

			}
			//

		} catch (Exception proc_Call) {

		}
	}

	private PILP024_RETURN_VALUES excuteC3A(ResultSet resultSet, String c3a,
			Connection connection, CRUDHandler handler2,
			PILP024_DB_PROCEDURE db_procedures, String c9, DUMMY dummy_bean) {
		PILP024_RETURN_VALUES pilp024_return_values = null;
		ResultSet resultSet1;
		ResultSet resultSet2;
		try {

			resultSet = handler.executeSelectStatement(c3a, connection);
			while (resultSet.next()) {

				pilp024_return_values = new PILP024_RETURN_VALUES();

				pilp024_return_values.setName1(resultSet
						.getString("RS_REPORT_NAME"));

				pilp024_return_values.setNumber1(0);

				resultSet1 = handler.executeSelectStatement(c9, connection);
				while (resultSet1.next()) {
					pilp024_return_values.setLongNumber1(resultSet1
							.getLong("DSRC_SYS_ID"));
				}

				String C3 = " SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID"
						+ " FROM   PW_IL_REMINDER_SUMMARY WHERE  "
						+ " RS_POL_SYS_ID IN (SELECT CLAIM_SYS_ID "
						+ " FROM PT_IL_CLAIM WHERE "
						+ " CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID FROM   "
						+ " PT_IL_POLICY WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE "
						+ " FROM   PM_IL_PLAN WHERE  PLAN_TYPE <> 'M') "
						+ " AND POL_NO BETWEEN '"
						+ dummy_bean.getUI_M_POLICY_FM()
						+ "' "
						+ " AND '"
						+ dummy_bean.getUI_M_POLICY_TO()
						+ "' AND     "
						+ " POL_DIVN_CODE BETWEEN '"
						+ dummy_bean.getUI_M_DIVN_FM()
						+ "'       "
						+ " AND '"
						+ dummy_bean.getUI_M_DIVN_TO()
						+ "' AND     "
						+ " POL_DEPT_CODE BETWEEN '"
						+ dummy_bean.getUI_M_DEPT_FM()
						+ "'        "
						+ " AND '"
						+ dummy_bean.getUI_M_DEPT_TO()
						+ "' AND     POL_ISSUE_DT  "
						+ " BETWEEN TO_DATE('"
						+ CommonUtils.dateToPELStringFormatter(dummy_bean
								.getUI_M_FM_DT())
						+ "') AND TO_DATE('"
						+ CommonUtils.dateToPELStringFormatter(dummy_bean
								.getUI_M_TO_DT())
						+ "'))) "
						+ " AND RS_REPORT_NAME = '"
						+ pilp024_return_values.getName1() + "' ";

				resultSet2 = handler.executeSelectStatement(C3, connection);
				while (resultSet2.next()) {

					pilp024_return_values.setName1(resultSet2
							.getString("RS_REPORT_NAME"));
					pilp024_return_values.setLongNumber2(resultSet2
							.getLong("CLAIM_SYS_ID"));

					if (pilp024_return_values.getName1().equalsIgnoreCase(
							"D01_1")) {
						pilp024_return_values.setNumber1(1);

						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_D01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_CLAIMANT_D01(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

						// P_LIFE_LETTER(
						// M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,NULL);

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("T01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_T01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_CLAIMANT_T01(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

						// P_LIFE_LETTER(
						// M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,NULL);

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("FM01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_PHYSICIAN_FM01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_PHYSICIAN_FM01(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

						// P_LIFE_LETTER(
						// M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,NULL);

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("LM01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_PHYSICIAN(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_PHYSICIAN(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					}

					String insertQuery = " INSERT INTO PS_IL_REMINDER_SUMMARY "
							+ " (SELECT * FROM PW_IL_REMINDER_SUMMARY "
							+ " WHERE  RS_REPORT_NAME  = '"
							+ pilp024_return_values.getName1() + "' "
							+ " AND    RS_POL_SYS_ID   = '"
							+ pilp024_return_values.getLongNumber2() + "' )";

					handler.executeInsertStatement(insertQuery, connection);

					String deleteQuery = " DELETE PW_IL_REMINDER_SUMMARY  WHERE"
							+ " RS_REPORT_NAME = '"
							+ pilp024_return_values.getName1()
							+ "' "
							+ " AND RS_POL_SYS_ID  = '"
							+ pilp024_return_values.getLongNumber2() + "'";

					handler.executeDeleteStatement(deleteQuery, connection);

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	private PILP024_RETURN_VALUES excuteC2A(ResultSet resultSet, String c2a,
			Connection connection, CRUDHandler handler2,
			PILP024_DB_PROCEDURE db_procedures, String c9, DUMMY dummy_bean,
			Long m_claim_sys_id) {
		PILP024_RETURN_VALUES pilp024_return_values = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try {
			resultSet = handler.executeSelectStatement(c2a, connection);
			while (resultSet.next()) {

				pilp024_return_values = new PILP024_RETURN_VALUES();
				pilp024_return_values.setName1(resultSet
						.getString("RS_REPORT_NAME"));

				resultSet1 = handler.executeSelectStatement(c9, connection);
				while (resultSet1.next()) {
					pilp024_return_values.setLongNumber1(resultSet1
							.getLong("DSRC_SYS_ID"));
				}

				String C2 = "SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID"
						+ " FROM PW_IL_REMINDER_SUMMARY WHERE  RS_POL_SYS_ID "
						+ " IN (SELECT   POL_SYS_ID FROM PT_IL_POLICY "
						+ " WHERE POL_PLAN_CODE IN (SELECT PLAN_CODE FROM"
						+ " PM_IL_PLAN WHERE  PLAN_TYPE <> 'M') AND     "
						+ " POL_NO BETWEEN '"
						+ dummy_bean.getUI_M_POLICY_FM()
						+ "' AND '"
						+ dummy_bean.getUI_M_POLICY_TO()
						+ "' "
						+ " AND POL_DIVN_CODE BETWEEN '"
						+ dummy_bean.getUI_M_DIVN_FM()
						+ "' "
						+ " AND '"
						+ dummy_bean.getUI_M_DIVN_TO()
						+ "' AND POL_DEPT_CODE BETWEEN '"
						+ dummy_bean.getUI_M_DEPT_FM()
						+ "' "
						+ " AND '"
						+ dummy_bean.getUI_M_DEPT_TO()
						+ "' AND POL_ISSUE_DT  BETWEEN TO_DATE('"
						+ CommonUtils.dateToPELStringFormatter(dummy_bean
								.getUI_M_FM_DT())
						+ "') "
						+ " AND TO_DATE('"
						+ CommonUtils.dateToPELStringFormatter(dummy_bean
								.getUI_M_TO_DT())
						+ "'))AND RS_REPORT_NAME = '"
						+ pilp024_return_values.getName1() + "' ";

				resultSet2 = handler.executeSelectStatement(C2, connection);
				while (resultSet2.next()) {
					pilp024_return_values.setName1(resultSet2
							.getString("RS_REPORT_NAME"));
					pilp024_return_values.setLongNumber2(resultSet2
							.getLong("POL_SYS_ID"));
					if (pilp024_return_values.getName1()
							.equalsIgnoreCase("B02")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_UW_LETTERS.GEN_JE_MEDICAL_REQUIREMENT(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_UW_LETTERS_GEN_JE_MEDICAL_REQUIREMENT(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("R01%")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_UW_LETTERS.GEN_JE_PENDING_REQUIREMENT(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_UW_LETTERS_GEN_JE_PENDING_REQUIREMENT(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("B09")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_UW_LETTERS.GEN_JE_COUNTER_FIRST(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_UW_LETTERS_GEN_JE_COUNTER_FIRST(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("C02")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_UW_LETTERS.GEN_JE_SHORT_PAYMENT(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_UW_LETTERS_GEN_JE_SHORT_PAYMENT(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("B11")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_UW_LETTERS.GEN_JE_POSTPONED_EXPIRED(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_UW_LETTERS_GEN_JE_POSTPONED_EXPIRED(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getName1()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("I00-1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_PS_LETTERS.GEN_PS_RENEWAL_NOTICE(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_PS_LETTERS_GEN_PS_RENEWAL_NOTICE(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("I00-2")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_PS_LETTERS.GEN_PS_SHORTCOLL_NOTICE(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_PS_LETTERS_GEN_PS_SHORTCOLL_NOTICE(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("I00-3")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_PS_LETTERS.GEN_PS_REMINDER_NOTICE(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_PS_LETTERS_GEN_PS_REMINDER_NOTICE(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("I00-4")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_PS_LETTERS.GEN_PS_REMINDER_NOTICE(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_PS_LETTERS_GEN_PS_REMINDER_NOTICE(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("%I05")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_PS_LETTERS.GEN_PS_LAPSED_NOTICE(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_PS_LETTERS_GEN_PS_LAPSED_NOTICE(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("I06")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_PS_LETTERS.GEN_PS_PIA_NOTICE(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_POL_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_PS_LETTERS_GEN_PS_PIA_NOTICE(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(m_claim_sys_id));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					}

					String insertQuery = " INSERT INTO PS_IL_REMINDER_SUMMARY "
							+ " (SELECT * FROM PW_IL_REMINDER_SUMMARY "
							+ " WHERE  RS_REPORT_NAME  = '"
							+ pilp024_return_values.getName1() + "' "
							+ " AND    RS_POL_SYS_ID   = '"
							+ pilp024_return_values.getLongNumber2() + "' )";

					handler.executeInsertStatement(insertQuery, connection);

					String deleteQuery = " DELETE PW_IL_REMINDER_SUMMARY WHERE  "
							+ " RS_REPORT_NAME = '"
							+ pilp024_return_values.getName1()
							+ "' "
							+ " AND RS_POL_SYS_ID  = '"
							+ pilp024_return_values.getLongNumber2() + "' ";

					handler.executeInsertStatement(deleteQuery, connection);

				}

				// P_LIFE_LETTER(
				// M_DSRC_SYS_ID,M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE,NULL);
				// "DELETE PW_IL_DATA_SOURCE WHERE DSRC_SYS_ID =
				// M_DSRC_SYS_ID";
			}

			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	private PILP024_RETURN_VALUES excuteC8A(ResultSet resultSet, String C8A,
			Connection connection, CRUDHandler handler2,
			PILP024_DB_PROCEDURE db_procedures, String c9, DUMMY dummy_bean) {
		PILP024_RETURN_VALUES pilp024_return_values = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try {

			resultSet = handler.executeSelectStatement(C8A, connection);

			while (resultSet.next()) {

				pilp024_return_values = new PILP024_RETURN_VALUES();

				// M_RS_REPORT_NAME = resultSet.getString("RS_REPORT_NAME");
				pilp024_return_values.setName1(resultSet
						.getString("RS_REPORT_NAME"));

				pilp024_return_values.setNumber1(0);

				resultSet1 = handler.executeSelectStatement(c9, connection);

				if (resultSet1.next()) {
					// M_DSRC_SYS_ID = resultSet1.getLong("DSRC_SYS_ID");
					pilp024_return_values.setLongNumber1(resultSet1
							.getLong("DSRC_SYS_ID"));
				}

				String C8 = " SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID "
						+ "  FROM   PW_IL_REMINDER_SUMMARY"
						+ "WHERE  RS_POL_SYS_ID IN (SELECT  CLAIM_SYS_ID"
						+ "FROM    PT_IL_CLAIM"
						+ "WHERE   CLAIM_POL_SYS_ID IN (SELECT POL_SYS_ID"
						+ "FROM   PT_IL_POLICY"
						+ "WHERE  POL_PLAN_CODE IN ( SELECT PLAN_CODE"
						+ "FROM   PM_IL_PLAN   WHERE  PLAN_TYPE = 'M')"
						+ " AND POL_NO BETWEEN '"
						+ dummy_bean.getUI_M_POLICY_FM()
						+ "'  "
						+ "    AND '"
						+ dummy_bean.getUI_M_POLICY_TO()
						+ "' "
						+ "AND    POL_DIVN_CODE BETWEEN '"
						+ dummy_bean.getUI_M_DIVN_FM()
						+ "' "
						+ "AND '"
						+ dummy_bean.getUI_M_DIVN_TO()
						+ "' "
						+ "AND    POL_DEPT_CODE BETWEEN '"
						+ dummy_bean.getUI_M_DEPT_FM()
						+ "' "
						+ " AND '"
						+ dummy_bean.getUI_M_DEPT_TO()
						+ "' "
						+ "   AND    POL_ISSUE_DT  BETWEEN TO_DATE('"
						+ CommonUtils.dateToPELStringFormatter(dummy_bean
								.getUI_M_FM_DT())
						+ "')"
						+ " AND TO_DATE('"
						+ CommonUtils.dateToPELStringFormatter(dummy_bean
								.getUI_M_TO_DT())
						+ "')))"
						+ "  AND RS_REPORT_NAME = '"
						+ pilp024_return_values.getName1() + "' ";

				resultSet2 = handler.executeSelectStatement(C8, connection);

				while (resultSet2.next()) {
					pilp024_return_values.setName1(resultSet2
							.getString("RS_REPORT_NAME"));
					pilp024_return_values.setLongNumber2(resultSet2
							.getLong("CLAIM_SYS_ID"));
					if (pilp024_return_values.getName1().equalsIgnoreCase(
							"D01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_D01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);
						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_CLAIMANT_D01(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("T01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_CLAIMANT_T01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);
						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_CLAIMANT_T01(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("FM01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_PHYSICIAN_FM01(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_PHYSICIAN_FM01(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					} else if (pilp024_return_values.getName1()
							.equalsIgnoreCase("LM01_1")) {
						pilp024_return_values.setNumber1(1);
						// P9ILPK_CLAIM_LETTERS.GEN_REMINDER_PHYSICIAN(M_DSRC_SYS_ID,M_RS_REPORT_NAME,M_CLAIM_SYS_ID);

						ArrayList<String> list = db_procedures
								.callP9ILPK_CLAIM_LETTERS_GEN_REMINDER_PHYSICIAN(
										pilp024_return_values.getName1(),
										CommonUtils
												.getProcedureValue(pilp024_return_values
														.getLongNumber2()));
						if (list != null && list.size() > 0) {
							pilp024_return_values.setLongNumber1(Long
									.parseLong(list.get(0)));
						}

					}

					String insertQuery = " INSERT INTO PS_IL_REMINDER_SUMMARY "
							+ " (SELECT * FROM PW_IL_REMINDER_SUMMARY "
							+ " WHERE  RS_REPORT_NAME  = '"
							+ pilp024_return_values.getName1() + "' "
							+ " AND RS_POL_SYS_ID   = '"
							+ pilp024_return_values.getLongNumber2() + "')";

					handler.executeInsertStatement(insertQuery, connection);

					String deleteQuery = " DELETE PW_IL_REMINDER_SUMMARY WHERE "
							+ " RS_REPORT_NAME = '"
							+ pilp024_return_values.getName1()
							+ "' AND"
							+ " RS_POL_SYS_ID  = '"
							+ pilp024_return_values.getLongNumber2() + "'";

					handler.executeDeleteStatement(deleteQuery, connection);

				}

				// CLOSE C8;--C8 CLOSED

				if (pilp024_return_values.getNumber1() == 1) {
					// P_LIFE_LETTER_BATCH(M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE);
					// "DELETE PW_IL_DATA_SOURCE WHERE DSRC_SYS_ID =
					// M_DSRC_SYS_ID";
					db_procedures.callP_LIFE_LETTER_BATCH(pilp024_return_values
							.getName1(), "B");
					callReport("P_LIFE_LETTER_BATCH");
				}
			}

		} catch (Exception e) {

		}

		return pilp024_return_values;
	}

	private PILP024_RETURN_VALUES excuteC1(ResultSet resultSet, String C1,
			Connection connection, CRUDHandler handler2,
			PILP024_DB_PROCEDURE db_procedures) {
		PILP024_RETURN_VALUES pilp024_return_values = null;
		try {
			pilp024_return_values = new PILP024_RETURN_VALUES();
			resultSet = handler.executeSelectStatement(C1, connection);
			while (resultSet.next()) {
				pilp024_return_values.setName1(resultSet
						.getString("RS_REPORT_NAME"));
				pilp024_return_values.setLongNumber1(resultSet
						.getLong("POL_SYS_ID"));
				if (pilp024_return_values.getName1().equalsIgnoreCase("B03")) {
					pilp024_return_values.setNumber1(1);
					db_procedures.callP_ADD_UW_DOC(pilp024_return_values
							.getName1(), "B");
					callReport("P_ADD_UW_DOC");
					// P_ADD_UW_DOC(M_RS_REPORT_NAME,'B');
				} else if (pilp024_return_values.getName1().equalsIgnoreCase(
						"R01")) {
					pilp024_return_values.setNumber1(1);
					//db_procedures.callP_INCOMPLETE_DOC(pilp024_return_values
					//		.getName1(), "B");
					//callReport("P_INCOMPLETE_DOC");
					// P_INCOMPLETE_DOC(M_RS_REPORT_NAME,'B');
				} else if (pilp024_return_values.getName1().equalsIgnoreCase(
						"N02")) {
					pilp024_return_values.setNumber1(1);
					
					db_procedures.callP_NOT_TAKEN_UP_DOC(pilp024_return_values
							.getName1(), "B");
					
					callReport("P_NOT_TAKEN_UP_DOC");
					// P_NOT_TAKEN_UP_DOC(M_RS_REPORT_NAME,'B');
				} else if (pilp024_return_values.getName1().equalsIgnoreCase(
						"B02")
						|| pilp024_return_values.getName1().equalsIgnoreCase(
								"B04")) {
					pilp024_return_values.setNumber1(1);
					db_procedures.callP_MEDICAL_DOC(pilp024_return_values
							.getName1(), "B");
					callReport("P_MEDICAL_DOC");
					// P_MEDICAL_DOC(M_RS_REPORT_NAME,'B');

				} else if (pilp024_return_values.getName1().equalsIgnoreCase(
						"C02")) {
					pilp024_return_values.setNumber1(1);
					db_procedures.callP_SHORT_PAY_DOC(pilp024_return_values
							.getName1(), "B");
					callReport("P_SHORT_PAY_DOC");
					// P_SHORT_PAY_DOC(M_RS_REPORT_NAME,'B');
				} else if (pilp024_return_values.getName1().equalsIgnoreCase(
						"C04")) {
					pilp024_return_values.setNumber1(1);
					db_procedures.callP_EXTENSION_APPRV_LETTER(pilp024_return_values
							.getName1(), "B");
					callReport("P_EXTENSION_APPRV_LETTER");
					// P_EXTENSION_APPRV_LETTER(M_RS_REPORT_NAME,'B');
				} else if (pilp024_return_values.getName1().equalsIgnoreCase(
						"C06")) {
					pilp024_return_values.setNumber1(1);
					db_procedures.callP_EXT_ACCEPT_LETTER(pilp024_return_values
							.getName1(), "B");
					callReport("P_EXT_ACCEPT_LETTER");
					// P_EXT_ACCEPT_LETTER (M_RS_REPORT_NAME,'B');
				}
				String insertQuery = " INSERT INTO PS_IL_REMINDER_SUMMARY(SELECT * FROM  PW_IL_REMINDER_SUMMARY "
						+ "  WHERE  RS_REPORT_NAME  = '"
						+ pilp024_return_values.getName1()
						+ "' AND    RS_POL_SYS_ID   = '"
						+ pilp024_return_values.getLongNumber1() + "' )";
				handler.executeInsertStatement(insertQuery, connection);
				String deleteQuery = " DELETE PW_IL_REMINDER_SUMMARY WHERE  RS_REPORT_NAME = M_RS_REPORT_NAME "
						+ "  AND    RS_POL_SYS_ID  = M_POL_SYS_ID";
				handler.executeDeleteStatement(deleteQuery, connection);
				if (pilp024_return_values.getNumber1() == 1) {
					// P_LIFE_LETTER_BATCH(M_RS_REPORT_NAME,:DUMMY.M_PRINT_TYPE);
					// "DELETE PW_IL_DATA_SOURCE";
					db_procedures.callP_LIFE_LETTER_BATCH(pilp024_return_values
							.getName1(), "B");
					callReport("P_LIFE_LETTER_BATCH");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return pilp024_return_values;
	}

	private String excuteC1A(ResultSet resultSet, String CIA,
			Connection connection, CRUDHandler handler) {
		String reportName = null;
		try {
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(CIA, connection);
			if (resultSet.next()) {
				reportName = resultSet.getString("RS_REPORT_NAME");
			}
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reportName;
	}

	public void callReport(String reportName) throws Exception {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			HttpServletResponse response = (HttpServletResponse) context
					.getExternalContext().getResponse();
			String filename = null;
			String generatedFilename = null;
			String callingReport = reportName;
			if (callingReport.equalsIgnoreCase("P_ADD_UW_DOC")) {
				filename = "BATCHPRINTING.jrxml";
				generatedFilename = "BATCHPRINTING";
			} else if (callingReport.equalsIgnoreCase("P_MEDICAL_DOC")) {
				filename = "P_MEDICAL_DOC_BATCH_PRNT.jrxml";
				generatedFilename = "P_MEDICAL_DOC_BATCH_PRNT";
			} else if (callingReport.equalsIgnoreCase("P_NOT_TAKEN_UP_DOC")) {
				filename = "P_NOT_TAKEN_UP_DOC_BATCH_PRNT.jrxml";
				generatedFilename = "P_NOT_TAKEN_UP_DOC_BATCH_PRNT";
			} else if (callingReport.equalsIgnoreCase("P_SHORT_PAY_DOC")) {
				filename = "P_SHORT_PAY_DOC_BATCH_PRNT.jrxml";
				generatedFilename = "P_SHORT_PAY_DOC_BATCH_PRNT";
			} else if (callingReport
					.equalsIgnoreCase("P_EXTENSION_APPRV_LETTER")) {
				filename = "P_EXTENSION_APPRV_LETTER_BATCH_PRNT.jrxml";
				generatedFilename = "P_EXTENSION_APPRV_LETTER_BATCH_PRNT";
			} else if (callingReport.equalsIgnoreCase("P_EXT_ACCEPT_LETTER")) {
				filename = "P_EXT_ACCEPT_LETTER_BATCH_PRNT.jrxml";
				generatedFilename = "P_EXT_ACCEPT_LETTER_BATCH_PRNT";
			}

			if (callingReport.equalsIgnoreCase("P_LIFE_LETTER_BATCH")) {
				filename = "P_LIFE_LETTER_BATCH_BATCH_PRNT.jrxml";
				generatedFilename = "P_LIFE_LETTER_BATCH_BATCH_PRNT";
			}

			Map params = new HashMap();
			params.put("name", "Batch Printing Letters");
			new CallJasPerReport().generateReport(request, filename,
					generatedFilename, params);
			new OpenJasPerReport().generateReport(request, response, context,
					generatedFilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
