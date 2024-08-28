package com.iii.pel.forms.PILP201;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DT;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlOutputLabel COMP_UI_PROCESS_LABEL;

	private HtmlCommandLink COMP_UI_PRINT_LINK;

	private DUMMY DUMMY_BEAN;

	private DUMMY_HELPER DUMMY_HELPER;

	private IP_REP_INFO IP_REP_INFO_BEAN = null;

	private List<LovBean> suggestionList = null;

	private String redirectUrl;

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * @param redirectUrl
	 *            the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public DUMMY_ACTION() throws Exception {
		DUMMY_BEAN = new DUMMY();
		DUMMY_HELPER = new DUMMY_HELPER();
		IP_REP_INFO_BEAN = new com.iii.pel.forms.PILP201.IP_REP_INFO();
	}

	public List<LovBean> UI_M_POLICY_FM_lovAction(Object currValue) {
		/*
		 * ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new
		 * ArrayList<com.iii.premia.common.bean.LovBean>(); ListItemUtil
		 * listitemutil = new ListItemUtil(); try { suggestionList =
		 * listitemutil.P_CALL_LOV("PILP014", "DUMMY", "M_POL_NO_FM", null,
		 * null, null, null, null, (String) currValue); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		suggestionList = DUMMY_HELPER.getPolicyNumber((String) currValue);
		return suggestionList;
	}

	public List<LovBean> UI_M_POLICY_TO_lovAction(Object currValue) {
		/*
		 * ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new
		 * ArrayList<com.iii.premia.common.bean.LovBean>(); ListItemUtil
		 * listitemutil = new ListItemUtil(); try { suggestionList =
		 * listitemutil.P_CALL_LOV("PILP014", "DUMMY", "M_POL_NO_TO", null,
		 * null, null, null, null, (String) currValue); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		suggestionList = DUMMY_HELPER.getPolicyNumber((String) currValue);
		return suggestionList;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 * @throws ParseException
	 */
	public void validator_M_POL_NO_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) value);
			if (!"0".equalsIgnoreCase(DUMMY_BEAN.getUI_M_POL_NO_FM())) {
				validatePolicyNo(DUMMY_BEAN.getUI_M_POL_NO_FM());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 * @throws ParseException
	 */
	public void validator_M_POL_NO_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) value);
			if (!"zzzzz".equalsIgnoreCase(DUMMY_BEAN.getUI_M_POL_NO_TO())) {
				validatePolicyNo(DUMMY_BEAN.getUI_M_POL_NO_TO());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param listener
	 * @throws ValidatorException
	 * @throws ParseException
	 */
	public void validatorPolicyFrom(ActionEvent event) {
		try {
			getErrorMap().clear();

			String value = (String) COMP_UI_M_POL_NO_FM.getSubmittedValue();
			System.out.println("Value" + value);
			DUMMY_BEAN.setUI_M_POL_NO_FM(value);

			if (value == null || "".equalsIgnoreCase(value)) {
				COMP_UI_M_POL_NO_FM.setSubmittedValue("0");
				DUMMY_BEAN.setUI_M_POL_NO_FM("0");
			} else if (!"0".equalsIgnoreCase(value)) {
				validatePolicyNo(DUMMY_BEAN.getUI_M_POL_NO_FM());
			}
			COMP_UI_M_POL_NO_FM.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}

	/**
	 * 
	 * @param listener
	 * @throws ValidatorException
	 * @throws ParseException
	 */
	public void validatorPolicyTo(ActionEvent event) {
		try {
			getErrorMap().clear();
			String value = (String) COMP_UI_M_POL_NO_TO.getSubmittedValue();
			System.out.println("Value TO" + value);
			DUMMY_BEAN.setUI_M_POL_NO_TO(value);

			if (value == null || "".equalsIgnoreCase(value)) {
				COMP_UI_M_POL_NO_TO.setSubmittedValue("zzzzz");
				DUMMY_BEAN.setUI_M_POL_NO_TO("zzzzz");
			} else if (!"zzzzz".equalsIgnoreCase(value)) {
				validatePolicyNo(DUMMY_BEAN.getUI_M_POL_NO_TO());
			}

			COMP_UI_M_POL_NO_TO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}

	public void validatorProcessDate(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		DUMMY_BEAN.setUI_M_PROCESS_DT((Date) value);
	}

	/**
	 * 
	 * @param policyNo
	 * @throws Exception
	 */
	public void validatePolicyNo(String policyNo) throws Exception {
		Object[] values = null;
		ResultSet rs = null;
		String M_TEMP = null;
		String C1_Validate = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { policyNo };
			rs = handler
					.executeSelectStatement(C1_Validate, connection, values);
			if (rs.next()) {
				M_TEMP = rs.getString(1);
			} else {
				throw new Exception("Invalid Policy No Please re enter");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rs != null) {
				CommonUtils.closeCursor(rs);
			}
		}

	}

	public void L_CHK_POL_NO(String M_POL_NO) throws Exception {
		String C1 = " SELECT 'X'" + " FROM   PT_IL_POLICY"
				+ " WHERE  POL_NO = ?";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Object[] values = null;
		CRUDHandler handler = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			values = new Object[] { M_POL_NO };
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2411"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				String moduleName = (String) CommonUtils
						.getGlobalVariable("GLOBAL.M_MODULE_NAME");
				CommonUtils.setGlobalVariable("FORM_ID", moduleName);
				System.out.println("Module Name===========>" + moduleName);
				DUMMY_BEAN.setUI_M_PROCESS_DT(new CommonUtils()
						.getCurrentDate());

				if (moduleName != null
						&& moduleName.equalsIgnoreCase("PILP201")) {
					COMP_UI_PROCESS_LABEL
							.setValue("Computation Of Anniversary Cash value");
					COMP_UI_PRINT_LINK.setDisabled(true);
				} else if (moduleName != null
						&& moduleName.equalsIgnoreCase("PILP202")) {
					COMP_UI_PROCESS_LABEL
							.setValue("Policy Over Loan Processing");
					COMP_UI_PRINT_LINK.setDisabled(true);
				} 
				
				/*commentted by saritha below code suggestted by siva sir on 27-01-2017*/ 
				
				/*else if (moduleName != null
						&& moduleName.equalsIgnoreCase("PILP203")) {
					COMP_UI_PROCESS_LABEL.setValue("APL Processing");
					COMP_UI_PRINT_LINK.setDisabled(false);
				} */
				
				/*End*/
				
				else if (moduleName != null
						&& moduleName.equalsIgnoreCase("PILP204")) {
					COMP_UI_PROCESS_LABEL.setValue("Bonus Processing");
					COMP_UI_PRINT_LINK.setDisabled(true);
				}

				setFormFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}

	}

	/**
	 * @return the cOMP_UI_M_POL_NO_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	/**
	 * @param comp_ui_m_pol_no_fm_label
	 *            the cOMP_UI_M_POL_NO_FM_LABEL to set
	 */
	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_fm_label) {
		COMP_UI_M_POL_NO_FM_LABEL = comp_ui_m_pol_no_fm_label;
	}

	/**
	 * @return the cOMP_UI_M_POL_NO_FM
	 */
	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	/**
	 * @param comp_ui_m_pol_no_fm
	 *            the cOMP_UI_M_POL_NO_FM to set
	 */
	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText comp_ui_m_pol_no_fm) {
		COMP_UI_M_POL_NO_FM = comp_ui_m_pol_no_fm;
	}

	/**
	 * @return the cOMP_UI_M_POL_NO_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	/**
	 * @param comp_ui_m_pol_no_to_label
	 *            the cOMP_UI_M_POL_NO_TO_LABEL to set
	 */
	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_to_label) {
		COMP_UI_M_POL_NO_TO_LABEL = comp_ui_m_pol_no_to_label;
	}

	/**
	 * @return the cOMP_UI_M_POL_NO_TO
	 */
	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	/**
	 * @param comp_ui_m_pol_no_to
	 *            the cOMP_UI_M_POL_NO_TO to set
	 */
	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText comp_ui_m_pol_no_to) {
		COMP_UI_M_POL_NO_TO = comp_ui_m_pol_no_to;
	}

	/**
	 * @return the cOMP_UI_M_PROCESS_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	/**
	 * @param comp_ui_m_process_dt_label
	 *            the cOMP_UI_M_PROCESS_DT_LABEL to set
	 */
	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_dt_label) {
		COMP_UI_M_PROCESS_DT_LABEL = comp_ui_m_process_dt_label;
	}

	/**
	 * @return the cOMP_UI_M_PROCESS_DT
	 */
	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	/**
	 * @param comp_ui_m_process_dt
	 *            the cOMP_UI_M_PROCESS_DT to set
	 */
	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar comp_ui_m_process_dt) {
		COMP_UI_M_PROCESS_DT = comp_ui_m_process_dt;
	}

	/**
	 * @return the cOMP_UI_M_BUT_OK
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	/**
	 * @param comp_ui_m_but_ok
	 *            the cOMP_UI_M_BUT_OK to set
	 */
	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	/**
	 * @return the dUMMY_BEAN
	 */
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	/**
	 * @param dummy_bean
	 *            the dUMMY_BEAN to set
	 */
	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 * @throws ParseException
	 */
	public void validator_M_POL_PROCESS_DATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			ParseException {
		try {

			DUMMY_BEAN.setUI_M_PROCESS_DT((Date) value);
			if (DUMMY_BEAN.getUI_M_PROCESS_DT().after(
					new CommonUtils().getCurrentDate())) {
				throw new Exception(
						"Premium due date cannot be greater than current date");
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
	 */
	public void buttonPressProcess() throws Exception {
		String polNoFrom = DUMMY_BEAN.getUI_M_POL_NO_FM();
		String polNoTo = DUMMY_BEAN.getUI_M_POL_NO_TO();
		Date processDt = DUMMY_BEAN.getUI_M_PROCESS_DT();
		System.out.println("polNoFrom " + polNoFrom);
		System.out.println("polNoTo " + polNoTo);
		System.out.println("processDt " + processDt);

		String formId = CommonUtils.getGlobalVariable("FORM_ID");

		try {

			if ("PILP201".equalsIgnoreCase(formId)) {
				System.out.println("Inside PILP201");
				DUMMY_HELPER.PROC_ANIVR_PROCESS(polNoFrom, polNoTo, processDt,
						"PROC_ANIVR_PROCESS");
			} else if ("PILP202".equalsIgnoreCase(formId)) {
				System.out.println("Inside PILP202 Policy Over Loan");
				DUMMY_HELPER.PROC_ANIVR_PROCESS(polNoFrom, polNoTo, processDt,
						"P9ILPK_POLICY_LOAN.OVER_LOAN_END_OF_DAY");
			} 
			
			/*commentted by saritha below code suggestted by siva sir on 27-01-2017*/  
			/*else if ("PILP203".equalsIgnoreCase(formId)) {
				System.out.println("Inside PILP203 Apl Processing");
				DUMMY_HELPER.PROC_ANIVR_PROCESS(polNoFrom, polNoTo, processDt,
						"P9ILPK_POLICY_LOAN.CALL_APL");
			} else if ("PILP204".equalsIgnoreCase(formId)) {
				System.out.println("Inside PILP204 Bank Loan Processing");
				// DUMMY_HELPER.PROC_ANIVR_PROCESS(polNoFrom, polNoTo,
				// processDt,"PROC_ANIVR_PROCESS");
			}*/

			getWarningMap().put("current", "Process Completed Sucessfully");
		} catch (Exception exception) {
			exception.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new ProcedureException(exception.getMessage());
		} finally {
			CommonUtils.getConnection().commit();
			CommonUtils.setGlobalVariable("FORM_ID", null);
		}
	}

	/**
	 * @return the cOMP_UI_PROCESS_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_PROCESS_LABEL() {
		return COMP_UI_PROCESS_LABEL;
	}

	/**
	 * @param comp_ui_process_label
	 *            the cOMP_UI_PROCESS_LABEL to set
	 */
	public void setCOMP_UI_PROCESS_LABEL(HtmlOutputLabel comp_ui_process_label) {
		COMP_UI_PROCESS_LABEL = comp_ui_process_label;
	}

	/**
	 * @return the cOMP_UI_PRINT_LINK
	 */
	public HtmlCommandLink getCOMP_UI_PRINT_LINK() {
		return COMP_UI_PRINT_LINK;
	}

	/**
	 * @param comp_ui_print_link
	 *            the cOMP_UI_PRINT_LINK to set
	 */
	public void setCOMP_UI_PRINT_LINK(HtmlCommandLink comp_ui_print_link) {
		COMP_UI_PRINT_LINK = comp_ui_print_link;
	}

	public void printAction() {
		String polNoFrom = DUMMY_BEAN.getUI_M_POL_NO_FM();
		String polNoTo = DUMMY_BEAN.getUI_M_POL_NO_TO();
		Date processDt = DUMMY_BEAN.getUI_M_PROCESS_DT();
		System.out.println("polNoFrom " + polNoFrom);
		System.out.println("polNoTo " + polNoTo);
		System.out.println("processDt " + processDt);

		String formId = CommonUtils.getGlobalVariable("FORM_ID");

		try {

			runAction();

		} catch (Exception exception) {
			exception.printStackTrace();

		} finally {
			CommonUtils.setGlobalVariable("FORM_ID", null);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String runAction() {
		CommonUtils.clearMaps(this);
		String redirectUrl = null;
		setRedirectUrl(null);
		HttpServletResponse response = null;
		String moduleCode = CommonUtils
				.getGlobalVariable("GLOBAL.M_MODULE_NAME");
		Map<String, String> map = new HashMap<String, String>();
		String polNoFrom = DUMMY_BEAN.getUI_M_POL_NO_FM();
		String polNoTo = DUMMY_BEAN.getUI_M_POL_NO_TO();
		Date processDt = DUMMY_BEAN.getUI_M_PROCESS_DT();
		System.out.println("polNoFrom " + polNoFrom);
		System.out.println("polNoTo " + polNoTo);
		System.out.println("processDt " + processDt);
		try {
			// if (IP_REP_INFO_BEAN.getSelectedFileType() != null) {

			if (IP_REP_INFO_BEAN.getROWID() == null) {

				PRE_INSERT(this.IP_REP_INFO_BEAN);

			} else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}
			// new
			// PGLR039_012_DELEGATE().executeSaveAction(this.IP_REP_INFO_BEAN);
			response = (HttpServletResponse) FacesContext.getCurrentInstance()
					.getExternalContext().getResponse();
			map.put("P_POL_FROM", polNoFrom);
			map.put("P_POL_TO", polNoTo);
			map.put("P_POL_PROCESS_DATE", String.valueOf(processDt));

			map.put("MAXIMIZE", "YES");

			redirectUrl = ReportUtils.getReportRedirectString(IP_REP_INFO_BEAN
					.getREP_KEY_NO(), IP_REP_INFO_BEAN.getREP_ID(),
					IP_REP_INFO_BEAN.getREP_ID(), "PDF", map);
			System.out.println("redirectUrl" + redirectUrl);
			// response.sendRedirect(redirectUrl);
			setRedirectUrl(redirectUrl);
			// }

		} catch (Exception e) {

			e.printStackTrace();
		}

		return redirectUrl;
	}

	/**
	 * @return the iP_REP_INFO_BEAN
	 */
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	/**
	 * @param ip_rep_info_bean
	 *            the iP_REP_INFO_BEAN to set
	 */
	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}

	public void PRE_INSERT(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {

			IP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
