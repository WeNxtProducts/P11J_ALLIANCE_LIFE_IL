package com.iii.pel.forms.PILP024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POLICY_FM_LABEL;

	private HtmlInputText COMP_UI_M_POLICY_FM;

	private HtmlOutputLabel COMP_UI_M_POLICY_TO_LABEL;

	private HtmlInputText COMP_UI_M_POLICY_TO;

	private HtmlOutputLabel COMP_UI_M_DIVN_FM_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_FM;

	private HtmlInputText COMP_UI_M_DIVN_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_DIVN_TO_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_TO;

	private HtmlOutputLabel COMP_UI_M_DEPT_FM_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_FM;

	private HtmlOutputLabel COMP_UI_M_DEPT_TO_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_TO;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DT;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_TO;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_FM;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_FM;

	private DUMMY DUMMY_BEAN;

	private HtmlCommandButton test;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		preForm();
	}

	public HtmlInputText getCOMP_UI_M_DIVN_FM_DESC() {
		return COMP_UI_M_DIVN_FM_DESC;
	}

	public void setCOMP_UI_M_DIVN_FM_DESC(HtmlInputText COMP_UI_M_DIVN_FM_DESC) {
		this.COMP_UI_M_DIVN_FM_DESC = COMP_UI_M_DIVN_FM_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POLICY_FM_LABEL() {
		return COMP_UI_M_POLICY_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POLICY_FM() {
		return COMP_UI_M_POLICY_FM;
	}

	public void setCOMP_UI_M_POLICY_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_POLICY_FM_LABEL) {
		this.COMP_UI_M_POLICY_FM_LABEL = COMP_UI_M_POLICY_FM_LABEL;
	}

	public void setCOMP_UI_M_POLICY_FM(HtmlInputText COMP_UI_M_POLICY_FM) {
		this.COMP_UI_M_POLICY_FM = COMP_UI_M_POLICY_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POLICY_TO_LABEL() {
		return COMP_UI_M_POLICY_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POLICY_TO() {
		return COMP_UI_M_POLICY_TO;
	}

	public void setCOMP_UI_M_POLICY_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_POLICY_TO_LABEL) {
		this.COMP_UI_M_POLICY_TO_LABEL = COMP_UI_M_POLICY_TO_LABEL;
	}

	public void setCOMP_UI_M_POLICY_TO(HtmlInputText COMP_UI_M_POLICY_TO) {
		this.COMP_UI_M_POLICY_TO = COMP_UI_M_POLICY_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_FM_LABEL() {
		return COMP_UI_M_DIVN_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_FM() {
		return COMP_UI_M_DIVN_FM;
	}

	public void setCOMP_UI_M_DIVN_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_FM_LABEL) {
		this.COMP_UI_M_DIVN_FM_LABEL = COMP_UI_M_DIVN_FM_LABEL;
	}

	public void setCOMP_UI_M_DIVN_FM(HtmlInputText COMP_UI_M_DIVN_FM) {
		this.COMP_UI_M_DIVN_FM = COMP_UI_M_DIVN_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_TO_LABEL() {
		return COMP_UI_M_DIVN_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_TO() {
		return COMP_UI_M_DIVN_TO;
	}

	public void setCOMP_UI_M_DIVN_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_TO_LABEL) {
		this.COMP_UI_M_DIVN_TO_LABEL = COMP_UI_M_DIVN_TO_LABEL;
	}

	public void setCOMP_UI_M_DIVN_TO(HtmlInputText COMP_UI_M_DIVN_TO) {
		this.COMP_UI_M_DIVN_TO = COMP_UI_M_DIVN_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_FM_LABEL() {
		return COMP_UI_M_DEPT_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_FM() {
		return COMP_UI_M_DEPT_FM;
	}

	public void setCOMP_UI_M_DEPT_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_FM_LABEL) {
		this.COMP_UI_M_DEPT_FM_LABEL = COMP_UI_M_DEPT_FM_LABEL;
	}

	public void setCOMP_UI_M_DEPT_FM(HtmlInputText COMP_UI_M_DEPT_FM) {
		this.COMP_UI_M_DEPT_FM = COMP_UI_M_DEPT_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_TO_LABEL() {
		return COMP_UI_M_DEPT_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_TO() {
		return COMP_UI_M_DEPT_TO;
	}

	public void setCOMP_UI_M_DEPT_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_TO_LABEL) {
		this.COMP_UI_M_DEPT_TO_LABEL = COMP_UI_M_DEPT_TO_LABEL;
	}

	public void setCOMP_UI_M_DEPT_TO(HtmlInputText COMP_UI_M_DEPT_TO) {
		this.COMP_UI_M_DEPT_TO = COMP_UI_M_DEPT_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_DT_LABEL() {
		return COMP_UI_M_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DT() {
		return COMP_UI_M_FM_DT;
	}

	public void setCOMP_UI_M_FM_DT_LABEL(HtmlOutputLabel COMP_UI_M_FM_DT_LABEL) {
		this.COMP_UI_M_FM_DT_LABEL = COMP_UI_M_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_FM_DT(HtmlCalendar COMP_UI_M_FM_DT) {
		this.COMP_UI_M_FM_DT = COMP_UI_M_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DT_LABEL() {
		return COMP_UI_M_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DT() {
		return COMP_UI_M_TO_DT;
	}

	public void setCOMP_UI_M_TO_DT_LABEL(HtmlOutputLabel COMP_UI_M_TO_DT_LABEL) {
		this.COMP_UI_M_TO_DT_LABEL = COMP_UI_M_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_TO_DT(HtmlCalendar COMP_UI_M_TO_DT) {
		this.COMP_UI_M_TO_DT = COMP_UI_M_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL) {
		this.COMP_UI_M_PROCESS_DT_LABEL = COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar COMP_UI_M_PROCESS_DT) {
		this.COMP_UI_M_PROCESS_DT = COMP_UI_M_PROCESS_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_POLICY_TO() {
		return COMP_UI_M_BUTT_LOV_POLICY_TO;
	}

	public void setCOMP_UI_M_BUTT_LOV_POLICY_TO(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_TO) {
		this.COMP_UI_M_BUTT_LOV_POLICY_TO = COMP_UI_M_BUTT_LOV_POLICY_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DEPT_FM() {
		return COMP_UI_M_BUTT_LOV_DEPT_FM;
	}

	public void setCOMP_UI_M_BUTT_LOV_DEPT_FM(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_FM) {
		this.COMP_UI_M_BUTT_LOV_DEPT_FM = COMP_UI_M_BUTT_LOV_DEPT_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DEPT_TO() {
		return COMP_UI_M_BUTT_LOV_DEPT_TO;
	}

	public void setCOMP_UI_M_BUTT_LOV_DEPT_TO(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_TO) {
		this.COMP_UI_M_BUTT_LOV_DEPT_TO = COMP_UI_M_BUTT_LOV_DEPT_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DIVN_FM() {
		return COMP_UI_M_BUTT_LOV_DIVN_FM;
	}

	public void setCOMP_UI_M_BUTT_LOV_DIVN_FM(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_FM) {
		this.COMP_UI_M_BUTT_LOV_DIVN_FM = COMP_UI_M_BUTT_LOV_DIVN_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DIVN_TO() {
		return COMP_UI_M_BUTT_LOV_DIVN_TO;
	}

	public void setCOMP_UI_M_BUTT_LOV_DIVN_TO(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_TO) {
		this.COMP_UI_M_BUTT_LOV_DIVN_TO = COMP_UI_M_BUTT_LOV_DIVN_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_POLICY_FM() {
		return COMP_UI_M_BUTT_LOV_POLICY_FM;
	}

	public void setCOMP_UI_M_BUTT_LOV_POLICY_FM(
			HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_FM) {
		this.COMP_UI_M_BUTT_LOV_POLICY_FM = COMP_UI_M_BUTT_LOV_POLICY_FM;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	Connection con = null;
	ResultSet rs;
	CommonUtils util = new CommonUtils();
	CRUDHandler handler = new CRUDHandler();

	// public String WHEN_NEW_RECORD_INSTAMCE(){
	// getTest().setDisabled(true);
	// getSystemDate();
	//		
	// return "";
	// }

	public void preForm() {
		System.out.println("DUMMY_ACTION.preForm()");
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
	}

	public List UI_M_POLICY_FM_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;
		System.out.println("OBJECT VLAUE" + obj.toString());
		String query = null;
		if (obj.toString().equals("*")) {
			query = "SELECT /*+ FIRST_ROWS */ POL_NO FROM pt_il_policy WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND ROWNUM  <25";
		} else {
			String value = obj.toString().toUpperCase();
			query = "select /*+ FIRST_ROWS */ POL_NO from pt_il_policy where NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND POL_NO LIKE('"
					+ obj.toString().toUpperCase() + "%')AND ROWNUM  <25";
			System.out.println("the policy query is" + query);
		}
		Connection connection = util.getConnection();
		rs = handler.executeSelectStatement(query, connection);
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setPOL_NO(rs.getString("POL_NO"));
			lovList.add(lovBox);
		}
		rs.close();
		// connection.close();
		return lovList;

	}


	public List UI_M_DIVN_FM_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;
		System.out.println("OBJECT VLAUE" + obj.toString());
		String query = null;
		/*
		 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to
		 * FM_DEPARTMENT. Added by : Mallika.S, 01-Apr-2009
		 */
		if (obj.toString().equals("*")) {
			query = "select /*+ FIRST_ROWS */ DEPT_DIVN_CODE from FM_DEPARTMENT where DEPT_COMP_CODE = '001' order by 1";
		} else {
			query = "select /*+ FIRST_ROWS */ DEPT_DIVN_CODE from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE LIKE('"
					+ obj.toString().toUpperCase() + "%')";
		}
		// Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, util.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setDIVN(rs.getString("DEPT_DIVN_CODE"));
			lovList.add(lovBox);
		}
		rs.close();
		// util.getConnection().close();
		return lovList;

	}

	// LOV For DEPT_CODE FM and TO
	public List UI_M_DEPT_FM_lovAction(Object obj) throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;
		System.out.println("OBJECT VLAUE" + obj.toString());
		String query = null;
		/*
		 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to
		 * FM_DEPARTMENT. Added by : Mallika.S, 01-Apr-2009
		 */
		if (obj.toString().equals("*")) {
			query = "select /*+ FIRST_ROWS */ DEPT_CODE from FM_DEPARTMENT where DEPT_COMP_CODE ='001' and DEPT_DIVN_CODE BETWEEN 'A%' and 'Z%' ORDER BY 1";
		} else {
			query = "select /*+ FIRST_ROWS */ DEPT_CODE from FM_DEPARTMENT where DEPT_COMP_CODE ='001' and DEPT_DIVN_CODE BETWEEN 'A%' and 'Z%' AND DEPT_CODE LIKE('"
					+ obj.toString().toUpperCase() + "%')";
		}
		// Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, util.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovList.add(lovBox);
		}
		rs.close();
		// util.getConnection().close();
		return lovList;
	}

	// Calling all Triggers
	public void UI_M_FM_DT_whenValidateItem(ActionEvent event) {

		System.out.println("when validate from date on blur");
		HtmlCalendar fromCalendarComponent = (HtmlCalendar) (event
				.getComponent().getParent());

		System.out
				.println(fromCalendarComponent.getAsDate(fromCalendarComponent
						.getSubmittedValue().toString()));
		this.DUMMY_BEAN
				.setUI_M_FM_DT(fromCalendarComponent
						.getAsDate(fromCalendarComponent.getSubmittedValue()
								.toString()));

		ErrorHelpUtil.validate(fromCalendarComponent, getErrorMap());
	}

	public void validateUI_M_FM_DT(FacesContext context, UIComponent component,
			Object value) {
		System.out.println("validate from date on submit");
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_fm_dt_when_validate_item();

	}

	public void UI_M_TO_DT_whenValidateItem(ActionEvent event) {
		System.out.println("when validate to date onblur");
		HtmlCalendar toCalendarComponent = (HtmlCalendar) (event.getComponent()
				.getParent());

		System.out.println(toCalendarComponent.getAsDate(toCalendarComponent
				.getSubmittedValue().toString()));
		this.DUMMY_BEAN.setUI_M_TO_DT(toCalendarComponent
				.getAsDate(toCalendarComponent.getSubmittedValue().toString()));

		ErrorHelpUtil.validate(toCalendarComponent, getErrorMap());

	}

	public void validateUI_M_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		System.out.println("validate to date onsubmit");
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_to_dt_when_validate_item();

	}

	public void UI_M_PROCESS_DT_whenValidateItem(ActionEvent event) {

		System.out.println("when validate from date on blur");
		HtmlCalendar fromCalendarComponent = (HtmlCalendar) (event
				.getComponent().getParent());

		System.out
				.println(fromCalendarComponent.getAsDate(fromCalendarComponent
						.getSubmittedValue().toString()));
		this.DUMMY_BEAN
				.setUI_M_PROCESS_DT(fromCalendarComponent
						.getAsDate(fromCalendarComponent.getSubmittedValue()
								.toString()));

		ErrorHelpUtil.validate(fromCalendarComponent, getErrorMap());
	}

	public void validateUI_M_PROCESS_DT(FacesContext context,
			UIComponent component, Object value) {
		System.out.println("validate from date on submit");
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_process_fm_dt_when_validate_item();

	}

	public void UI_M_POLICY_FM_WHEN_VALIDATE(ActionEvent event) {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_policy_fm_when_validate_item();
	}

	public void UI_M_POLICY_TO_WHEN_VALIDATE(ActionEvent event) {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_policy_to_when_validate_item();
	}

	public void UI_M_DIVN_FM_WHEN_VALIDATE(ActionEvent event) {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_divn_fm_when_validate_item();
	}

	public void UI_M_DIVN_TO_WHEN_VALIDATE(ActionEvent event) {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_divn_to_when_validate_item();
	}

	public void UI_M_DEPT_FM_WHEN_VALIDATE(ActionEvent event) {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_dept_fm_when_validate_item();
	}

	public void UI_M_DEPT_TO_WHEN_VALIDATE(ActionEvent event) {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		helper.pilp024_dummy_ui_m_dept_to_when_validate_item();
	}


	public void WHEN_BUTTON_PRESSED(ActionEvent ae) {
		System.out.println("the value of UI_M_POLICY_FM is"
				+ getCOMP_UI_M_POLICY_FM().getValue());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String FM_DT = simpleDateFormat.format(getCOMP_UI_M_FM_DT().getValue());
		String TO_DT = simpleDateFormat.format(getCOMP_UI_M_TO_DT().getValue());

		String sql_query_one = " SELECT DISTINCT RS_REPORT_NAME FROM PW_IL_REMINDER_SUMMARY WHERE RS_REPORT_NAME IS NOT NULL "
				+ "AND RS_POL_SYS_ID IN (SELECT  POL_SYS_ID FROM  PT_IL_POLICY WHERE POL_PLAN_CODE IN(SELECT PLAN_CODE "
				+ "FROM PM_IL_PLAN WHERE PLAN_TYPE  = 'M') AND POL_NO BETWEEN '"
				+ getCOMP_UI_M_POLICY_FM().getValue()
				+ "' AND '"
				+ getCOMP_UI_M_POLICY_TO().getValue()
				+ "'"
				+ "AND POL_DIVN_CODE BETWEEN '"
				+ getCOMP_UI_M_DIVN_FM().getValue()
				+ "' AND '"
				+ getCOMP_UI_M_DIVN_TO().getValue()
				+ "' AND POL_DEPT_CODE BETWEEN '"
				+ getCOMP_UI_M_DEPT_FM().getValue()
				+ "' "
				+ "AND '"
				+ getCOMP_UI_M_DEPT_TO().getValue()
				+ "' AND POL_ISSUE_DT BETWEEN TO_DATE('"
				+ FM_DT
				+ "') AND TO_DATE('"
				+ TO_DT
				+ "'))"
				+ "GROUP BY RS_REPORT_NAME";

		System.out.println("the query is " + sql_query_one);
	}

	public void processBatchPrntLttrs() {
		DUMMY_HELPER_ACTION helper = new DUMMY_HELPER_ACTION();
		try {
			helper.process(DUMMY_BEAN);
			// helper.callReport();
		} catch (Exception ex) {
			ex.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					ex.getMessage());
			getErrorMap().put("saveRecord", ex.getMessage());
		}

	}

	public void UI_M_DATE_COMPARIISION(ActionEvent event) {
		UIInput component = (UIInput) event.getComponent().getParent();
		String toDate = (String) getCOMP_UI_M_TO_DT().getSubmittedValue();
		String fromDate = (String) getCOMP_UI_M_FM_DT().getSubmittedValue();

		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date dateFromDate;
		try {
			Date dateFromDate1 = format.parse(fromDate);
			Date dateToDate = format.parse(toDate);

			if (dateToDate.before(dateFromDate1)) {
				System.out
						.println("There is an Error in Date it should not ne greater than Zero");
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "71145");
				System.out.println("ERROR MSG::::::::::::::" + message);
				Map<String, String> errMap = getErrorMap();
				errMap.put("current", message);
				errMap.put("someKey", message);
			} else {
				System.out.println("SHANKAR DONE");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
