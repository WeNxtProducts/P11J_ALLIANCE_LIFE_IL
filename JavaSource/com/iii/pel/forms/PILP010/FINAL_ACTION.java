package com.iii.pel.forms.PILP010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT030_APAC.DUMMY_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class FINAL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_TXN_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TXN_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TXN_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TXN_TO_DT;

	private HtmlOutputLabel COMP_UI_M_DRCR_FM_TXN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_FM_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_DRCR_TO_TXN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_TO_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_DRCR_FM_DOC_NO_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_FM_DOC_NO;

	private HtmlOutputLabel COMP_UI_M_DRCR_TO_DOC_NO_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_TO_DOC_NO;

	private HtmlOutputLabel COMP_UI_M_STATUS_LABEL;

	private HtmlInputText COMP_UI_M_STATUS;

	private HtmlCommandButton COMP_UI_M_BUT_TXN_CODE_LOV_1;

	private HtmlCommandButton COMP_UI_M_BUT_TRAN_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_FM_DOC_NO;

	private HtmlCommandButton COMP_UI_M_BUT_TO_DOC_NO;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private HtmlCommandButton PREFORMBUTTON;

	private FINAL FINAL_BEAN;

	private PW_ERROR_MESSAGE PW_ERROR_MESSAGE_BEAN;

	private String query;

	Map attributes;

	Map<String, Object> session = null;

	private ArrayList<PW_ERROR_MESSAGE> pwErrorMessageList = new ArrayList<PW_ERROR_MESSAGE>();

	private List suggestionList;

	public ArrayList<PW_ERROR_MESSAGE> getPwErrorMessageList() {
		if (pwErrorMessageList.size() == 0) {
			for (int i = 0; i < 5; i++) {
				PW_ERROR_MESSAGE pwError = new PW_ERROR_MESSAGE();
				pwErrorMessageList.add(pwError);
			}
		}
		return pwErrorMessageList;
	}

	public void setPwErrorMessageList(
			ArrayList<PW_ERROR_MESSAGE> pwErrorMessageList) {
		this.pwErrorMessageList = pwErrorMessageList;
	}

	public FINAL_ACTION() {
		FINAL_BEAN = new FINAL();
		PW_ERROR_MESSAGE_BEAN = new PW_ERROR_MESSAGE();
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_FM_DT_LABEL() {
		return COMP_UI_M_TXN_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TXN_FM_DT() {
		return COMP_UI_M_TXN_FM_DT;
	}

	public void setCOMP_UI_M_TXN_FM_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_FM_DT_LABEL) {
		this.COMP_UI_M_TXN_FM_DT_LABEL = COMP_UI_M_TXN_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_TXN_FM_DT(HtmlCalendar COMP_UI_M_TXN_FM_DT) {
		this.COMP_UI_M_TXN_FM_DT = COMP_UI_M_TXN_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_TO_DT_LABEL() {
		return COMP_UI_M_TXN_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TXN_TO_DT() {
		return COMP_UI_M_TXN_TO_DT;
	}

	public void setCOMP_UI_M_TXN_TO_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_TO_DT_LABEL) {
		this.COMP_UI_M_TXN_TO_DT_LABEL = COMP_UI_M_TXN_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_TXN_TO_DT(HtmlCalendar COMP_UI_M_TXN_TO_DT) {
		this.COMP_UI_M_TXN_TO_DT = COMP_UI_M_TXN_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_FM_TXN_CODE_LABEL() {
		return COMP_UI_M_DRCR_FM_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_FM_TXN_CODE() {
		return COMP_UI_M_DRCR_FM_TXN_CODE;
	}

	public void setCOMP_UI_M_DRCR_FM_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_DRCR_FM_TXN_CODE_LABEL) {
		this.COMP_UI_M_DRCR_FM_TXN_CODE_LABEL = COMP_UI_M_DRCR_FM_TXN_CODE_LABEL;
	}

	public void setCOMP_UI_M_DRCR_FM_TXN_CODE(
			HtmlInputText COMP_UI_M_DRCR_FM_TXN_CODE) {
		this.COMP_UI_M_DRCR_FM_TXN_CODE = COMP_UI_M_DRCR_FM_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_TO_TXN_CODE_LABEL() {
		return COMP_UI_M_DRCR_TO_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_TO_TXN_CODE() {
		return COMP_UI_M_DRCR_TO_TXN_CODE;
	}

	public void setCOMP_UI_M_DRCR_TO_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_DRCR_TO_TXN_CODE_LABEL) {
		this.COMP_UI_M_DRCR_TO_TXN_CODE_LABEL = COMP_UI_M_DRCR_TO_TXN_CODE_LABEL;
	}

	public void setCOMP_UI_M_DRCR_TO_TXN_CODE(
			HtmlInputText COMP_UI_M_DRCR_TO_TXN_CODE) {
		this.COMP_UI_M_DRCR_TO_TXN_CODE = COMP_UI_M_DRCR_TO_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_FM_DOC_NO_LABEL() {
		return COMP_UI_M_DRCR_FM_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_FM_DOC_NO() {
		return COMP_UI_M_DRCR_FM_DOC_NO;
	}

	public void setCOMP_UI_M_DRCR_FM_DOC_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_DRCR_FM_DOC_NO_LABEL) {
		this.COMP_UI_M_DRCR_FM_DOC_NO_LABEL = COMP_UI_M_DRCR_FM_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DRCR_FM_DOC_NO(
			HtmlInputText COMP_UI_M_DRCR_FM_DOC_NO) {
		this.COMP_UI_M_DRCR_FM_DOC_NO = COMP_UI_M_DRCR_FM_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_TO_DOC_NO_LABEL() {
		return COMP_UI_M_DRCR_TO_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_TO_DOC_NO() {
		return COMP_UI_M_DRCR_TO_DOC_NO;
	}

	public void setCOMP_UI_M_DRCR_TO_DOC_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_DRCR_TO_DOC_NO_LABEL) {
		this.COMP_UI_M_DRCR_TO_DOC_NO_LABEL = COMP_UI_M_DRCR_TO_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DRCR_TO_DOC_NO(
			HtmlInputText COMP_UI_M_DRCR_TO_DOC_NO) {
		this.COMP_UI_M_DRCR_TO_DOC_NO = COMP_UI_M_DRCR_TO_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_LABEL() {
		return COMP_UI_M_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}

	public void setCOMP_UI_M_STATUS_LABEL(HtmlOutputLabel COMP_UI_M_STATUS_LABEL) {
		this.COMP_UI_M_STATUS_LABEL = COMP_UI_M_STATUS_LABEL;
	}

	public void setCOMP_UI_M_STATUS(HtmlInputText COMP_UI_M_STATUS) {
		this.COMP_UI_M_STATUS = COMP_UI_M_STATUS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TXN_CODE_LOV_1() {
		return COMP_UI_M_BUT_TXN_CODE_LOV_1;
	}

	public void setCOMP_UI_M_BUT_TXN_CODE_LOV_1(
			HtmlCommandButton COMP_UI_M_BUT_TXN_CODE_LOV_1) {
		this.COMP_UI_M_BUT_TXN_CODE_LOV_1 = COMP_UI_M_BUT_TXN_CODE_LOV_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TRAN_CODE_LOV() {
		return COMP_UI_M_BUT_TRAN_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_TRAN_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_TRAN_CODE_LOV) {
		this.COMP_UI_M_BUT_TRAN_CODE_LOV = COMP_UI_M_BUT_TRAN_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FM_DOC_NO() {
		return COMP_UI_M_BUT_FM_DOC_NO;
	}

	public void setCOMP_UI_M_BUT_FM_DOC_NO(
			HtmlCommandButton COMP_UI_M_BUT_FM_DOC_NO) {
		this.COMP_UI_M_BUT_FM_DOC_NO = COMP_UI_M_BUT_FM_DOC_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TO_DOC_NO() {
		return COMP_UI_M_BUT_TO_DOC_NO;
	}

	public void setCOMP_UI_M_BUT_TO_DOC_NO(
			HtmlCommandButton COMP_UI_M_BUT_TO_DOC_NO) {
		this.COMP_UI_M_BUT_TO_DOC_NO = COMP_UI_M_BUT_TO_DOC_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public FINAL getFINAL_BEAN() {
		return FINAL_BEAN;
	}

	public void setFINAL_BEAN(FINAL FINAL_BEAN) {
		this.FINAL_BEAN = FINAL_BEAN;
	}

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public String postFormsCommit() {
		session.put("GLOBAL.M_FAILURE", "FALSE");
		return null;
	}

	public void preForm(PhaseEvent event) {
		System.out.println("PILP010 preform");
		session = getSessionMap();

		session.put("GLOBAL.M_FAILURE", "FALSE");

		// calling STD_PRE_FORM PLL
		STD_PRE_FORM();

		ControlBean ctrlBean = CommonUtils.getControlBean();
		String M_TITLE = ctrlBean.getM_USER_ID() + " "
				+ ctrlBean.getM_SCR_NAME() + " " + new Date();

		// Implementation of WHEN-NEW-FORM-INSTANCE
		ArrayList<OracleParameter> paramList = null;
		OracleProcedureHandler procHandler = null;
		OracleParameter param1 = null;
		OracleParameter param2 = null;
		OracleParameter param3 = null;
		Connection connection = null;
		int errorCodeValue = -1;
		String errorCode = null;
		ArrayList list = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		// L_ONLINE_POSTING
		if (session.get("CALLING_FORM").toString().startsWith("PP00")
				|| session.get("CALLING_FORM").toString()
						.startsWith("PILT016A")
				|| session.get("CALLING_FORM").toString().startsWith(
						"PILP002_APAC")
				|| session.get("CALLING_FORM").toString().startsWith("PILP023")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_POL_SYS_ID"));
			param2 = new OracleParameter("in2", "STRING", "IN",
					(String) session.get("GLOBAL.M_CLM_SYS_ID"));
			param3 = new OracleParameter("out1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// ELSIF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT030%' THEN
		// L_PAYVOU_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT030")) {
			Double M_PAH_SYS_ID = (Double) session.get("GLOBAL.M_PAH_SYS_ID");
			String sql_C1 = "SELECT DISTINCT PADD_TXN_CODE, PADD_DOC_NO, PADD_DOC_DT "
					+ "FROM   PT_IL_PAYVOU_DRCR_DTL "
					+ "WHERE  NVL(PADD_POST_YN,'N') = 'N' "
					+ "AND    PADD_PAH_SYS_ID = ? "
					+ "AND    NVL(PADD_SELECTED_YN,'N') = 'Y'";
			CRUDHandler handler = new CRUDHandler();
			ResultSet rst = null;
			try {
				rst = handler.executeSelectStatement(sql_C1, connection,
						new Object[] { M_PAH_SYS_ID });
				while (rst.next()) {
					getFINAL_BEAN().setUI_M_DRCR_FM_TXN_CODE(rst.getString(1));
					getFINAL_BEAN().setUI_M_DRCR_TO_TXN_CODE(rst.getString(1));
					getFINAL_BEAN().setUI_M_DRCR_FM_DOC_NO(rst.getLong(2));
					getFINAL_BEAN().setUI_M_DRCR_TO_DOC_NO(rst.getLong(2));
					getFINAL_BEAN().setUI_M_TXN_FM_DT(rst.getDate(3));
					getFINAL_BEAN().setUI_M_TXN_TO_DT(rst.getDate(3));
				}
				getCOMP_UI_M_DRCR_FM_DOC_NO().resetValue();
				getCOMP_UI_M_DRCR_FM_TXN_CODE().resetValue();
				getCOMP_UI_M_DRCR_TO_DOC_NO().resetValue();
				getCOMP_UI_M_DRCR_TO_TXN_CODE().resetValue();
				getCOMP_UI_M_TXN_FM_DT().resetValue();
				getCOMP_UI_M_TXN_TO_DT().resetValue();
			} catch (SQLException e) {
				getErrorMap().put("current", e.getMessage());
				setErrorMessages(e.getMessage());
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN", M_PAH_SYS_ID
					+ "");
			param2 = new OracleParameter("out1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_PAYVOU_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
				System.out.println("The Procedure output is **************:"
						+ errorCodeValue);
			} catch (Exception e1) {
				e1.printStackTrace();
				getErrorMap().put("current", e1.getMessage());
				setErrorMessages(e1.getMessage());
			} finally {
				ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(
						connection, FacesContext.getCurrentInstance(),
						"PILP010", getErrorMap(), getWarningMap());
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILP060%' THEN
		// L_BONUS_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILP060")) {
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(null, connection,
						"P9ILPK_ONLINE_POSTING.L_BONUS_ONLINE_POSTING");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT033%' THEN
		// L_PAYVOU_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT033")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_PAH_SYS_ID"));
			param2 = new OracleParameter("out1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_PAYVOU_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
				System.out.println("The Procedure output is **************:"
						+ ((OracleParameter) list.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT031%' THEN
		// L_BATCH_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT031")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_RH_CONTROL_NO"));
			paramList.add(param1);
			procHandler = new OracleProcedureHandler();
			try {
				procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_BATCH_ONLINE_POSTING");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILP036%' THEN
		// L_PDC_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILP036")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_PDC_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
				System.out.println("The Procedure output is **************:"
						+ ((OracleParameter) list.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT039%' THEN
		// L_PREM_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT039")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_PIH_SYS_ID"));
			param2 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_PREM_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILP001_APAC%' THEN
		// L_PROP_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILP001_APAC")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_PROP_SYS_ID"));
			param2 = new OracleParameter("in2", "STRING", "IN",
					(String) session.get("GLOBAL.M_CLM_SYS_ID"));
			param3 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_PROP_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT013%' THEN
		// L_SURR_ONLINE_POSTING

		if ("PILT013".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					String.valueOf(session.get("GLOBAL.M_POL_SYS_ID")));
			param2 = new OracleParameter("in2", "STRING", "IN",null);
			//param3 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
		//	paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_SURR_ONLINE_POSTING");
				/*errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());*/
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT021%' THEN
		// L_WITHDRAWAL_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT021")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_POL_SYS_ID"));
			param2 = new OracleParameter("in2", "STRING", "IN",
					(String) session.get("GLOBAL.M_CLM_SYS_ID"));
			param3 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_WITHDRAWAL_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILP005%' THEN
		// L_FAC_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILP005")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_POL_SYS_ID"));
			param2 = new OracleParameter("in2", "STRING", "IN",
					(String) session.get("GLOBAL.M_CLM_SYS_ID"));
			param3 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_FAC_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT006_APAC%' THEN
		// L_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT006_APAC")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_POL_SYS_ID"));
			param2 = new OracleParameter("in2", "STRING", "IN",
					(String) session.get("GLOBAL.M_CLM_SYS_ID"));
			param3 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT007%' THEN
		// L_ONLINE_POSTING

		if (session.get("CALLING_FORM").toString().startsWith("PILT007")) {
			paramList = new ArrayList<OracleParameter>();
			param1 = new OracleParameter("in1", "STRING", "IN",
					(String) session.get("GLOBAL.M_POL_SYS_ID"));
			param2 = new OracleParameter("in2", "STRING", "IN",
					(String) session.get("GLOBAL.M_CLM_SYS_ID"));
			param3 = new OracleParameter("inout1", "STRING", "OUT", errorCode);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"P9ILPK_ONLINE_POSTING.L_ONLINE_POSTING");
				errorCodeValue = Integer.parseInt(((OracleParameter) list
						.get(0)).getValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (errorCodeValue != -1 && errorCodeValue == 1) {
			query = "SELECT EM_ENG_MSG, EM_ENG_ACTION FROM PW_ERROR_MESSAGE";
			pwErrorMessageList.clear();
			try {
				pwErrorMessageList = (ArrayList<PW_ERROR_MESSAGE>) getHandler()
						.fetch(query,
								"com.iii.pel.forms.PILP010.PW_ERROR_MESSAGE",
								connection);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				setErrorMessages(e.getMessage());
			}
		}
		// return null;
	}

	public void STD_PRE_FORM() {

		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String) session.get("GLOBAL.M_PARAM_1"));
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}

	public void whenNewFormInstance() {
	}


	// Action Method for -- Form:PILP010 Block: DUMMY Field: M_DRCR_FM_TXN_CODE
	public void PILP010_M_DRCR_FM_TXN_CODE_whenValidateItem(ActionEvent ae) {
		FacesContext fc = FacesContext.getCurrentInstance();
		UIViewRoot ui = fc.getViewRoot();
		ui.findComponent("FINAL:UI_M_M_DRCR_FM_TXN_CODE");
		PILP010_M_DRCR_FM_TXN_CODE_setRepFirstField(ui
				.findComponent("FINAL:UI_M_M_DRCR_FM_TXN_CODE"), ui
				.findComponent("FINAL:UI_M_M_DRCR_TO_TXN_CODE"));
		getFINAL_BEAN().setUI_M_DRCR_FM_TXN_CODE(
				(String) getCOMP_UI_M_DRCR_FM_TXN_CODE().getSubmittedValue());
	}

	void PILP010_M_DRCR_FM_TXN_CODE_setRepFirstField(UIComponent field1,
			UIComponent field2) {
		int M_FIELD_LENGTH = 0;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "String";
		if ((String) getCOMP_UI_M_DRCR_FM_TXN_CODE().getSubmittedValue() == "") {
			attributes = getCOMP_UI_M_DRCR_FM_TXN_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			getCOMP_UI_M_DRCR_FM_TXN_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		if (!M_DATA_TYPE.equalsIgnoreCase("Date")) {
			getCOMP_UI_M_DRCR_TO_TXN_CODE().setSubmittedValue(
					getCOMP_UI_M_DRCR_TO_TXN_CODE().getSubmittedValue());
		}
	}

	// Action Method for -- Form:PILP010 Block: DUMMY Field: M_DRCR_TO_TXN_CODE
	public void PILP010_M_DRCR_TO_TXN_CODE_whenValidateItem(ActionEvent ae) {
		System.out.println("The value of to txn code is: "
				+ (getCOMP_UI_M_DRCR_TO_TXN_CODE().getSubmittedValue()));
		int M_FIELD_LENGTH = -1;
		String M_DATA_TYPE = "String", M_FIELD_DATA = "";
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
																	// comp
		if ("".equals(((String) (getCOMP_UI_M_DRCR_TO_TXN_CODE()
				.getSubmittedValue())).trim())) {
			attributes = getCOMP_UI_M_DRCR_TO_TXN_CODE().findComponent(
					"FINAL:UI_M_DRCR_TO_TXN_CODE").getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			if (M_DATA_TYPE.equalsIgnoreCase("String")) {
				
				if (((String) (getCOMP_UI_M_DRCR_FM_TXN_CODE())
						.getSubmittedValue()).trim().equalsIgnoreCase(
						M_FIELD_DATA.trim())
				) {
					M_FIELD_DATA = "zzzzzzzzzzzzzzzzzzzzzz".substring(0,
							M_FIELD_LENGTH);
					getCOMP_UI_M_DRCR_TO_TXN_CODE().setSubmittedValue(
							M_FIELD_DATA);
				} else if (M_DATA_TYPE.equalsIgnoreCase("String")) {
					getCOMP_UI_M_DRCR_TO_TXN_CODE()
							.setSubmittedValue(
									getCOMP_UI_M_DRCR_FM_TXN_CODE()
											.getSubmittedValue());
				}
			} else if (M_DATA_TYPE.equalsIgnoreCase("int")) {
				if (Integer
						.parseInt(((String) (getCOMP_UI_M_DRCR_FM_TXN_CODE())
								.getSubmittedValue())) == Integer
						.parseInt(M_FIELD_DATA)) {
					M_FIELD_DATA = "9999999999999999999999".substring(0,
							M_FIELD_LENGTH);
					getCOMP_UI_M_DRCR_TO_TXN_CODE().setSubmittedValue(
							M_FIELD_DATA);
				} else {
					getCOMP_UI_M_DRCR_TO_TXN_CODE().setSubmittedValue(
							(getCOMP_UI_M_DRCR_FM_TXN_CODE())
									.getSubmittedValue());
				}
			}
			getFINAL_BEAN().setUI_M_DRCR_TO_TXN_CODE(
					(String) getCOMP_UI_M_DRCR_TO_TXN_CODE()
							.getSubmittedValue());
			return;
		} else {
			M_FIELD_DATA = ((String) (getCOMP_UI_M_DRCR_TO_TXN_CODE())
					.getSubmittedValue());
			getCOMP_UI_M_DRCR_TO_TXN_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());

	}

	public void validateM_DRCR_TO_DOC_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			FINAL_BEAN.setUI_M_DRCR_TO_DOC_NO((Long) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

		if (getCOMP_UI_M_DRCR_TO_TXN_CODE().getSubmittedValue() != null) {
			FacesContext fc = FacesContext.getCurrentInstance();
			UIViewRoot ui = fc.getViewRoot();
			pilp010_dummy_m_drcr_to_txn_code_set_rep_second_field(
					getCOMP_UI_M_DRCR_FM_TXN_CODE(),
					getCOMP_UI_M_DRCR_TO_TXN_CODE());
		}

	}

	public void when_validate_item_M_DRCR_TO_DOC_NO() {

	}

	public void pilp010_dummy_m_drcr_to_txn_code_set_rep_second_field(
			UIInput field1, UIInput field2) {
		int M_FIELD_LENGTH = -1;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "String";
		ArrayList<OracleParameter> list = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		if (M_DATA_TYPE.equalsIgnoreCase("String")) {
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					(String) getCOMP_UI_M_DRCR_FM_TXN_CODE().getValue());
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					(String) ((UIInput) field2).getSubmittedValue());
			OracleParameter param3 = new OracleParameter("in3", "STRING",
					"OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				list = procHandler.execute(paramList, connection,
						"PR_VALIDATE_FM_TO");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (Integer.parseInt(((OracleParameter) list.get(0)).getValue()) == 1) {
				throw new ValidatorException(new FacesMessage(
						"The to txn number is less than from txn number"));
			}

		} else if (M_DATA_TYPE.equalsIgnoreCase("int")) {
			if (Integer.parseInt((String) ((UIInput) field2)
					.getSubmittedValue()) < Integer
					.parseInt((String) getCOMP_UI_M_DRCR_FM_TXN_CODE()
							.getSubmittedValue())) {
				throw new ValidatorException(new FacesMessage(
						"The to txn number is less than from txn number"));
			}
		}
	}

	public void validateUI_M_M_DRCR_TO_DOC_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		if (getCOMP_UI_M_DRCR_TO_DOC_NO().getSubmittedValue() != null) {
			UIInput comp = (UIInput) component;
			if (getCOMP_UI_M_DRCR_FM_DOC_NO().getSubmittedValue() != null
					&& !("".equals((String) getCOMP_UI_M_DRCR_FM_DOC_NO()
							.getSubmittedValue()))) {
				if (Double.parseDouble((String) comp.getSubmittedValue()) < Double
						.parseDouble((String) getCOMP_UI_M_DRCR_FM_DOC_NO()
								.getSubmittedValue())) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"3200"));
				}
			}
		}
	}

	public void PILP010_M_DRCR_TO_DOC_NO_whenValidateItem(ActionEvent ae) {
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
																	// comp
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void M_BUT_OK_WhenButtonPressed(ActionEvent ae) {
		Connection con = null;
		DBProcedures procedures = new DBProcedures();
		ArrayList<OracleParameter> returnList = new ArrayList<OracleParameter>();
		


		
		
		Date fromDate = FINAL_BEAN.getUI_M_TXN_FM_DT();
		Date toDate = FINAL_BEAN.getUI_M_TXN_TO_DT();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				PELConstants.dbDateFormat);
		String txnFmDate = dateFormat.format(fromDate);
		String txnToDate = dateFormat.format(toDate);

		Object[] values = new Object[6];
		ResultSet rs = null;
		String M_TMP = null;
		String M_STATUS = null;
		try {
			CommonUtils.clearMaps(this);
			con = CommonUtils.getConnection();
			pwErrorMessageList.clear();
			String query = "SELECT 'X' FROM PS_IL_DRCR WHERE DRCR_DOC_NO BETWEEN ? AND ? AND DRCR_TXN_CODE BETWEEN ? AND ?"
					+ " AND TRUNC(DRCR_DOC_DT) BETWEEN ? AND TO_DATE(?,'dd/mm/rrrr') AND NVL(DRCR_POST_YN,'N') = 'N'";

			values[0] = CommonUtils.getCurrentValue(COMP_UI_M_DRCR_FM_DOC_NO);
			values[1] = CommonUtils.getCurrentValue(COMP_UI_M_DRCR_TO_DOC_NO);
			values[2] = CommonUtils.getCurrentValue(COMP_UI_M_DRCR_FM_TXN_CODE);
			values[3] = CommonUtils.getCurrentValue(COMP_UI_M_DRCR_TO_TXN_CODE);
			values[4] = txnFmDate;
			values[5] = txnToDate;
			FINAL_BEAN.setUI_M_STATUS(null);
			rs = getHandler().executeSelectStatement(query, con, values);
			if (rs.next()) {
				M_TMP = rs.getString(1);
				returnList = WBP_M_BUT_OK(FINAL_BEAN.getUI_M_DRCR_FM_TXN_CODE(), 
											FINAL_BEAN.getUI_M_DRCR_TO_TXN_CODE(),
											FINAL_BEAN.getUI_M_DRCR_FM_DOC_NO(), 
											FINAL_BEAN.getUI_M_DRCR_TO_DOC_NO(),
											CommonUtils.getControlBean().getM_USER_ID(),
											CommonUtils.getControlBean().getM_COMP_CODE(),
											0,
											fromDate,
											toDate);
				
			

				
				
				if (!returnList.isEmpty()) {
					M_STATUS = (String)returnList.get(0).getValueObject();
					FINAL_BEAN.setUI_M_STATUS(M_STATUS);
				}
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3205"));
			}

			query = "SELECT EM_ENG_MSG, EM_ENG_ACTION FROM PW_ERROR_MESSAGE";
			
			pwErrorMessageList = getErrorMessageList(con);
			CommonUtils.getControlBean().setM_COMM_DEL("C");
			CommonUtils.getConnection().commit();

			if (pwErrorMessageList.isEmpty()) {
				Object errParams[] = {
						CommonUtils.getCurrentValue(COMP_UI_M_DRCR_FM_TXN_CODE)
								+ "",
						CommonUtils.getCurrentValue(COMP_UI_M_DRCR_TO_TXN_CODE)
								+ "",
						CommonUtils.getCurrentValue(COMP_UI_M_DRCR_FM_DOC_NO)
								+ "",
						CommonUtils.getCurrentValue(COMP_UI_M_DRCR_TO_DOC_NO)
								+ "" };
				getWarningMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"3203", errParams).getSummary());
			} else {
				
			
				/*Added by Ram on 12/12/2016 for Displaying Error Message
				 * 
				 * throwMessage("Not posted!");*/
				
				//throwMessage("Not posted!");
				throwMessage("Kindly check and solve the issues while Post before");
				
				/*End*/
			
			}

			

		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con,
					FacesContext.getCurrentInstance(),
					COMP_UI_M_BUT_OK.getId(), getErrorMap(), getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String PILP010_Cancel_WhenButtonPressed() {
		return "premia-home";
	}

	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public List getDocNo(Object obj) {
		try {
			suggestionList = new ArrayList();
			getCOMP_UI_M_DRCR_FM_DOC_NO().setSubmittedValue(null);
			String query = null;
			Object[] values = null;
			if ("*".equals(obj.toString())) {
				
				
				   
				
				query = " SELECT DRCR_TXN_CODE,DRCR_DOC_NO FROM PS_IL_DRCR WHERE  DRCR_DOC_DT BETWEEN ? AND ? AND DRCR_TXN_CODE BETWEEN ? AND ? AND DRCR_SEQ_NO = 1 AND DRCR_POST_YN = 'N' ORDER BY DRCR_DOC_NO";
				values = new Object[] {FINAL_BEAN.getUI_M_TXN_FM_DT(),FINAL_BEAN.getUI_M_TXN_TO_DT(),FINAL_BEAN.getUI_M_DRCR_FM_TXN_CODE(),FINAL_BEAN.getUI_M_DRCR_TO_TXN_CODE()};
			} else {
				query = "  SELECT DRCR_TXN_CODE,DRCR_DOC_NO FROM PS_IL_DRCR WHERE DRCR_DOC_DT BETWEEN ? AND ? AND DRCR_TXN_CODE BETWEEN ? AND ? AND DRCR_SEQ_NO = 1 AND DRCR_POST_YN = 'N' AND"
						+ " (DRCR_TXN_CODE LIKE ? OR DRCR_DOC_NO LIKE ?) ORDER BY DRCR_DOC_NO";
				values = new Object[] {FINAL_BEAN.getUI_M_TXN_FM_DT(),FINAL_BEAN.getUI_M_TXN_TO_DT(),FINAL_BEAN.getUI_M_DRCR_FM_TXN_CODE(),FINAL_BEAN.getUI_M_DRCR_TO_TXN_CODE(),obj.toString() + "%",
						obj.toString() + "%" };
			}
			ResultSet rs = getHandler().executeSelectStatement(query,
					CommonUtils.getConnection(), values);
			while (rs.next()) {
				FINAL_DOC_FM_NO_BEAN finalDocFmno = new FINAL_DOC_FM_NO_BEAN();
				finalDocFmno.setCOVER_CODE(rs.getString("DRCR_TXN_CODE"));
				finalDocFmno.setDRCR_DOC_NO(rs.getString("DRCR_DOC_NO"));
				suggestionList.add(finalDocFmno);
			}
			rs.close();
			// connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List getTxnNo(Object obj) throws Exception {
		suggestionList = new ArrayList();
		Object[] values = null;
		getCOMP_UI_M_DRCR_FM_DOC_NO().setSubmittedValue(null);
		String query = null;
		if ("*".equals(obj.toString())) {
			// query = "SELECT DRCR_TXN_CODE FROM PS_IL_DRCR WHERE
			// DRCR_INT_ENT_YN = 'N' AND ROWNUM<=50";
			query = " SELECT TRAN_CODE,TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_FRZ_FLAG = 'N' AND ROWNUM<=25 ORDER BY TRAN_CODE";
			values = new Object[] {};
		} else {
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * query = "  SELECT TRAN_CODE,TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_FRZ_FLAG = 'N' "
					+ " AND ( TRAN_CODE LIKE ? OR TRAN_NAME LIKE ? ) AND ROWNUM <= 25 ORDER BY TRAN_CODE";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			query = "  SELECT TRAN_CODE,TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_FRZ_FLAG = 'N' "
					+ " AND ( UPPER(TRAN_CODE) LIKE UPPER(?) OR UPPER(TRAN_NAME) LIKE UPPER(?) ) AND ROWNUM <= 25 ORDER BY TRAN_CODE";
			/*end*/
			values = new Object[] { obj.toString() + "%", obj.toString() + "%" };
		}
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection(), values);
		rs.setFetchSize(25);
		while (rs.next()) {
			FINAL_DOC_FM_NO_BEAN finalDocFmno = new FINAL_DOC_FM_NO_BEAN();
			finalDocFmno.setTRAN_CODE(rs.getString("TRAN_CODE"));
			finalDocFmno.setTRAN_NAME(rs.getString("TRAN_NAME"));
			suggestionList.add(finalDocFmno);
		}
		CommonUtils.closeCursor(rs);
		return suggestionList;
	}

	public String mainButton() {
		try {
			Map<String, Object> sessionMap = getSessionMap();
			String callingForm = (String) sessionMap.get("CALLING_FORM");
			getPREFORMBUTTON().setDisabled(false);
			getErrorMap().clear();
			setErrorMessages(null);
			getWarningMap().clear();
			setWarningMessages(null);
			deleteErrorMessages();
			P9ILPK_ONLINE_POSTING_L_DELETE_PLSQL_TAB();
			setFINAL_BEAN(new FINAL());
			if (callingForm.equals("PILT030_APAC")) {
				return "payVoucherHeader";
			} else if (callingForm.equals("PILT030_APAC_1")) {
				new DUMMY_HELPER().postApproval();
				return "payVoucherHeader";
			} else if (callingForm.equals("PILT006_APAC")) {
				return "claimsMaster";
			} else if (callingForm.equals("PILT007")) {
				return "claimPaid";
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
			return null;
		}
		return null;
	}

	public void P9ILPK_ONLINE_POSTING_L_DELETE_PLSQL_TAB()
			throws ValidatorException {
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(new ArrayList<OracleParameter>(), CommonUtils
					.getConnection(),
					"P9ILPK_ONLINE_POSTING.L_DELETE_PLSQL_TAB");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void deleteErrorMessages() throws ValidatorException {
		String query = "DELETE FROM PW_ERROR_MESSAGE";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			handler.executeDeleteStatement(query, connection);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<PW_ERROR_MESSAGE> getErrorMessageList(Connection connection) {
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT EM_ENG_MSG, EM_ENG_ACTION FROM PW_ERROR_MESSAGE";
		ResultSet rst = null;
		ArrayList<PW_ERROR_MESSAGE> messageList = null;
		try {
			rst = handler.executeSelectStatement(query, connection);
			messageList = new ArrayList<PW_ERROR_MESSAGE>();
			while (rst.next()) {
				PW_ERROR_MESSAGE errMessage = new PW_ERROR_MESSAGE();
				errMessage.setEM_ENG_MSG(rst.getString(1));
				errMessage.setEM_ENG_ACTION(rst.getString(2));
				messageList.add(errMessage);
			}
		} catch (SQLException e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return messageList;
	}

	// new code

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validator_M_TXN_FROM_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			FINAL_BEAN.setUI_M_TXN_FM_DT((Date) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void validator_M_TXN_TO_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			FINAL_BEAN.setUI_M_TXN_TO_DT((Date) value);
			if (FINAL_BEAN.getUI_M_TXN_TO_DT() != null
					&& FINAL_BEAN.getUI_M_TXN_FM_DT() != null) {
				if (FINAL_BEAN.getUI_M_TXN_TO_DT().before(
						FINAL_BEAN.getUI_M_TXN_FM_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "01",new Object[]{FINAL_BEAN.getUI_M_TXN_TO_DT(),FINAL_BEAN.getUI_M_TXN_FM_DT()}));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void throwMessage(String s) {
		/*Added by Ram on 12/12/2016 for Displaying Error Messages
		 * 
		 * getErrorMap().put("current", "");*/
		
		getErrorMap().put("current", s);
		
		/*End*/
	}

	public void validator_M_DRCR_FM_TXN_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			FINAL_BEAN.setUI_M_DRCR_FM_TXN_CODE((String) value);
			when_validate_item_M_DRCR_FM_TXN_CODE();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void when_validate_item_M_DRCR_FM_TXN_CODE() throws Exception {
		try {
			new CommonUtils().SET_REP_FIRST_FIELD(FINAL_BEAN
					.getUI_M_DRCR_FM_TXN_CODE(), "String");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void clearMap() {
		getErrorMap().clear();
		getWarningMap().clear();
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		clearMap();
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void actionListenerM_DRCR_FM_TXN_CODE(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			COMP_UI_M_DRCR_FM_TXN_CODE
					.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
			FINAL_BEAN.setUI_M_DRCR_FM_TXN_CODE(PELConstants.PROCESS_FROMVALUE);
		} else {
			FINAL_BEAN.setUI_M_DRCR_FM_TXN_CODE(inputValue);
		}
		COMP_UI_M_DRCR_FM_TXN_CODE.resetValue();
		setErrorMessagesInMap(actionEvent);
	}

	public void validator_M_DRCR_TO_TXN_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			FINAL_BEAN.setUI_M_DRCR_TO_TXN_CODE((String) value);
			when_validate_item_M_DRCR_TO_TXN_CODE();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void when_validate_item_M_DRCR_TO_TXN_CODE() throws Exception {
		try {
			new CommonUtils().SET_REP_SECOND_FIELD(FINAL_BEAN
					.getUI_M_DRCR_FM_TXN_CODE(), FINAL_BEAN
					.getUI_M_DRCR_TO_TXN_CODE(), "String");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void actionListenerM_POL_NO_TO(ActionEvent actionEvent) {
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent()
				.getParent();
		String inputTextString = (String) inputText.getSubmittedValue();
		if (inputTextString == "") {
			if (!COMP_UI_M_DRCR_FM_TXN_CODE.getSubmittedValue().equals(
					PELConstants.PROCESS_FROMVALUE)) {
				COMP_UI_M_DRCR_TO_TXN_CODE.setSubmittedValue(FINAL_BEAN
						.getUI_M_DRCR_FM_TXN_CODE());
				FINAL_BEAN.setUI_M_DRCR_TO_TXN_CODE(FINAL_BEAN
						.getUI_M_DRCR_TO_TXN_CODE());
			} else {
				COMP_UI_M_DRCR_TO_TXN_CODE
						.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				FINAL_BEAN
						.setUI_M_DRCR_TO_TXN_CODE(PELConstants.PROCESS_TOVALUE);
			}
		} else {
			FINAL_BEAN.setUI_M_DRCR_TO_TXN_CODE(inputTextString);
		}
		setErrorMessagesInMap(actionEvent);
	}

	public void validator_M_DRCR_FM_DOC_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			FINAL_BEAN.setUI_M_DRCR_FM_DOC_NO((Long) value);
			when_validate_item_M_DRCR_FM_DOC_NO();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void when_validate_item_M_DRCR_FM_DOC_NO() {
		FINAL_BEAN.setUI_M_DRCR_TO_DOC_NO(FINAL_BEAN.getUI_M_DRCR_TO_DOC_NO());
	}

	public void validator_M_DRCR_TO_DOC_NO(FacesContext context,
			UIComponent component, Object value) {
		try {
			FINAL_BEAN.setUI_M_DRCR_TO_DOC_NO((Long) value);
			if (FINAL_BEAN.getUI_M_DRCR_FM_DOC_NO() != null
					&& FINAL_BEAN.getUI_M_DRCR_TO_DOC_NO() != null) {
				if (FINAL_BEAN.getUI_M_DRCR_FM_DOC_NO() > FINAL_BEAN
						.getUI_M_DRCR_TO_DOC_NO()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3200"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	/**
	 * 
	 * @param P_FM_TXN_CODE-IN
	 * @param P_TO_TXN_CODE-IN
	 * @param P_FM_DOC_NO-IN
	 * @param P_TO_DOC_NO-IN
	 * @param P_USER_ID-IN
	 * @param P_COMP_CODE-IN
	 * @param P_DOC_ERR_NO-IN
	 * @param P_TXN_FM_DT-IN
	 * @param P_TXN_TO_DT-IN
	 * @param P_STATUS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public static ArrayList<OracleParameter> WBP_M_BUT_OK(Object P_FM_TXN_CODE,
			Object P_TO_TXN_CODE, Object P_FM_DOC_NO, Object P_TO_DOC_NO,
			Object P_USER_ID, Object P_COMP_CODE, Object P_DOC_ERR_NO,
			Object P_TXN_FM_DT, Object P_TXN_TO_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_FM_TXN_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TO_TXN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_FM_DOC_NO);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_TO_DOC_NO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_USER_ID);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_COMP_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_DOC_ERR_NO);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_TXN_FM_DT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_TXN_TO_DT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("OUT10",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param10);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_PILP010.WBP_M_BUT_OK");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
	
	/*Added by Ram on 12/12/2016 for post Finance to P9*/
	public static ArrayList<OracleParameter> PR_FIN_INS_HDR(Object P_FM_TXN_CODE,
			Object P_TO_TXN_CODE, Object P_FM_DOC_NO, Object P_TO_DOC_NO,
			Object P_USER_ID, Object P_COMP_CODE, Object P_DOC_ERR_NO,
			Object P_TXN_FM_DT, Object P_TXN_TO_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_FM_TXN_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TO_TXN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_FM_DOC_NO);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_TO_DOC_NO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_USER_ID);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_COMP_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_DOC_ERR_NO);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_TXN_FM_DT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_TXN_TO_DT);
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P10ILPK_POST_ONLINE_P7.PR_FIN_INS_HDR");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	/*End*/

}
