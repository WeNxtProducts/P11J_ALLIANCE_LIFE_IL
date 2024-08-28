package com.iii.pel.forms.PILT020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_EMPLOYER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_EMPLOYER_CODE;

	private HtmlOutputLabel COMP_UI_M_EMPLOYER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_EMPLOYER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CONTRACTOR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CONTRACTOR_CODE;

	private HtmlOutputLabel COMP_UI_M_CONTRACTOR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONTRACTOR_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_DUE_PERIOD_FM_LABEL;

	private HtmlCalendar COMP_UI_M_DUE_PERIOD_FM;

	private HtmlOutputLabel COMP_UI_M_DUE_PERIOD_TO_LABEL;

	private HtmlCalendar COMP_UI_M_DUE_PERIOD_TO;

	private HtmlOutputLabel COMP_UI_M_POL_CURR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_CURR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CURR_NAME;

	private HtmlOutputLabel COMP_UI_M_PAID_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PAID_DT;

	public HtmlCommandButton COMP_POPUP;

	private DUMMY1 DUMMY1_BEAN;

	private DUMMY DUMMY_BEAN;

	private HtmlCommandButton test;
	
	public PILT020_COMPOSITE_ACTION COMPOSITE_BEAN;


	Map<String, Object> session = FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap();

	

	public DUMMY1_ACTION() {

		DUMMY1_BEAN = new DUMMY1();
		DUMMY_BEAN = new DUMMY();
		COMP_POPUP = new HtmlCommandButton();
		COMP_POPUP.setDisabled(true);
		try {
			preForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_EMPLOYER_CODE_LABEL() {
		return COMP_UI_M_EMPLOYER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_EMPLOYER_CODE() {
		return COMP_UI_M_EMPLOYER_CODE;
	}

	public void setCOMP_UI_M_EMPLOYER_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_EMPLOYER_CODE_LABEL) {
		this.COMP_UI_M_EMPLOYER_CODE_LABEL = COMP_UI_M_EMPLOYER_CODE_LABEL;
	}

	public void setCOMP_UI_M_EMPLOYER_CODE(HtmlInputText COMP_UI_M_EMPLOYER_CODE) {
		this.COMP_UI_M_EMPLOYER_CODE = COMP_UI_M_EMPLOYER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_EMPLOYER_CODE_DESC_LABEL() {
		return COMP_UI_M_EMPLOYER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_EMPLOYER_CODE_DESC() {
		return COMP_UI_M_EMPLOYER_CODE_DESC;
	}

	public void setCOMP_UI_M_EMPLOYER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_EMPLOYER_CODE_DESC_LABEL) {
		this.COMP_UI_M_EMPLOYER_CODE_DESC_LABEL = COMP_UI_M_EMPLOYER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_EMPLOYER_CODE_DESC(
			HtmlInputText I_M_EMCOMP_UI_M_EMPLOYER_CODE_DESCPLOYER_CODE_DESC) {
		this.COMP_UI_M_EMPLOYER_CODE_DESC = I_M_EMCOMP_UI_M_EMPLOYER_CODE_DESCPLOYER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONTRACTOR_CODE_LABEL() {
		return COMP_UI_M_CONTRACTOR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONTRACTOR_CODE() {
		return COMP_UI_M_CONTRACTOR_CODE;
	}

	public void setCOMP_UI_M_CONTRACTOR_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_CONTRACTOR_CODE_LABEL) {
		this.COMP_UI_M_CONTRACTOR_CODE_LABEL = COMP_UI_M_CONTRACTOR_CODE_LABEL;
	}

	public void setCOMP_UI_M_CONTRACTOR_CODE(
			HtmlInputText COMP_UI_M_CONTRACTOR_CODE) {
		this.COMP_UI_M_CONTRACTOR_CODE = COMP_UI_M_CONTRACTOR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONTRACTOR_CODE_DESC_LABEL() {
		return COMP_UI_M_CONTRACTOR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONTRACTOR_CODE_DESC() {
		return COMP_UI_M_CONTRACTOR_CODE_DESC;
	}

	public void setCOMP_UI_M_CONTRACTOR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONTRACTOR_CODE_DESC_LABEL) {
		this.COMP_UI_M_CONTRACTOR_CODE_DESC_LABEL = COMP_UI_M_CONTRACTOR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONTRACTOR_CODE_DESC(
			HtmlInputText COMP_UI_M_CONTRACTOR_CODE_DESC) {
		this.COMP_UI_M_CONTRACTOR_CODE_DESC = COMP_UI_M_CONTRACTOR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUE_PERIOD_FM_LABEL() {
		return COMP_UI_M_DUE_PERIOD_FM_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_DUE_PERIOD_FM() {
		return COMP_UI_M_DUE_PERIOD_FM;
	}

	public void setCOMP_UI_M_DUE_PERIOD_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_DUE_PERIOD_FM_LABEL) {
		this.COMP_UI_M_DUE_PERIOD_FM_LABEL = COMP_UI_M_DUE_PERIOD_FM_LABEL;
	}

	public void setCOMP_UI_M_DUE_PERIOD_FM(HtmlCalendar COMP_UI_M_DUE_PERIOD_FM) {
		this.COMP_UI_M_DUE_PERIOD_FM = COMP_UI_M_DUE_PERIOD_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUE_PERIOD_TO_LABEL() {
		return COMP_UI_M_DUE_PERIOD_TO_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_DUE_PERIOD_TO() {
		return COMP_UI_M_DUE_PERIOD_TO;
	}

	public void setCOMP_UI_M_DUE_PERIOD_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_DUE_PERIOD_TO_LABEL) {
		this.COMP_UI_M_DUE_PERIOD_TO_LABEL = COMP_UI_M_DUE_PERIOD_TO_LABEL;
	}

	public void setCOMP_UI_M_DUE_PERIOD_TO(HtmlCalendar COMP_UI_M_DUE_PERIOD_TO) {
		this.COMP_UI_M_DUE_PERIOD_TO = COMP_UI_M_DUE_PERIOD_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CURR_CODE_LABEL() {
		return COMP_UI_M_POL_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CURR_CODE() {
		return COMP_UI_M_POL_CURR_CODE;
	}

	public void setCOMP_UI_M_POL_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CURR_CODE_LABEL) {
		this.COMP_UI_M_POL_CURR_CODE_LABEL = COMP_UI_M_POL_CURR_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_CURR_CODE(HtmlInputText COMP_UI_M_POL_CURR_CODE) {
		this.COMP_UI_M_POL_CURR_CODE = COMP_UI_M_POL_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_NAME_LABEL() {
		return COMP_UI_M_CURR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CURR_NAME() {
		return COMP_UI_M_CURR_NAME;
	}

	public void setCOMP_UI_M_CURR_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CURR_NAME_LABEL) {
		this.COMP_UI_M_CURR_NAME_LABEL = COMP_UI_M_CURR_NAME_LABEL;
	}

	public void setCOMP_UI_M_CURR_NAME(HtmlInputText COMP_UI_M_CURR_NAME) {
		this.COMP_UI_M_CURR_NAME = COMP_UI_M_CURR_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAID_DT_LABEL() {
		return COMP_UI_M_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PAID_DT() {
		return COMP_UI_M_PAID_DT;
	}

	public void setCOMP_UI_M_PAID_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PAID_DT_LABEL) {
		this.COMP_UI_M_PAID_DT_LABEL = COMP_UI_M_PAID_DT_LABEL;
	}

	public void setCOMP_UI_M_PAID_DT(HtmlCalendar COMP_UI_M_PAID_DT) {
		this.COMP_UI_M_PAID_DT = COMP_UI_M_PAID_DT;
	}

	public DUMMY1 getDUMMY1_BEAN() {
		return DUMMY1_BEAN;
	}

	public void setDUMMY1_BEAN(DUMMY1 DUMMY1_BEAN) {
		this.DUMMY1_BEAN = DUMMY1_BEAN;
	}

	CRUDHandler handler = new CRUDHandler();
	private Connection connection = null;

	// LOV for CONT Code
	public List<UI_M_POLICY_FM_LOV> UI_M_EMPLOYER_CODE_lovAction(Object obj)
			throws Exception {
		List<UI_M_POLICY_FM_LOV> lovList = new ArrayList<UI_M_POLICY_FM_LOV>();
		ResultSet rs = null;
		String query = null;
		if (obj.toString().equals("*")) {
			query = "select /*+ FIRST_ROWS */ CONT_CODE,CONT_NAME from PM_IL_CONTRACTOR where CONT_EMPLOYER_YN ='Y' AND ROWNUM<20 ORDER BY 1";
		} else {
			query = "select /*+ FIRST_ROWS */ CONT_CODE,CONT_NAME from PM_IL_CONTRACTOR where CONT_EMPLOYER_YN ='Y' AND ROWNUM<20 AND CONT_CODE LIKE('"
					+ obj.toString().toUpperCase() + "%')";
		}
		// Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setCONT_CODE(rs.getString("CONT_CODE"));
			lovBox.setCONT_DESC(rs.getString("CONT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		// CommonUtils.getConnection().close();
		return lovList;
	}

	public List<UI_M_POLICY_FM_LOV> UI_M_CONT_CODE_lovAction(Object obj)
			throws Exception {
		List<UI_M_POLICY_FM_LOV> lovList = new ArrayList<UI_M_POLICY_FM_LOV>();
		ResultSet rs = null;
		String query = null;
		if (obj.toString().equals("*")) {
			query = "select /*+ FIRST_ROWS */ CONT_CODE,CONT_NAME from PM_IL_CONTRACTOR where CONT_EMPLOYER_YN ='N' AND ROWNUM<20 ORDER BY 1";
		} else {
			query = "select /*+ FIRST_ROWS */ CONT_CODE,CONT_NAME from PM_IL_CONTRACTOR where CONT_EMPLOYER_YN ='N' AND ROWNUM<20 AND CONT_CODE LIKE('"
					+ obj.toString().toUpperCase() + "%')";
		}
		// Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setCONT_CODE(rs.getString("CONT_CODE"));
			lovBox.setCONT_DESC(rs.getString("CONT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		// CommonUtils.getConnection().close();
		return lovList;
	}

	public void setErrorMessagesFromDate(ActionEvent event)
			throws ParseException {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = null;
		today = df.parse(value);
		DUMMY1_BEAN.setUI_M_DUE_PERIOD_FM(today);
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void setErrorMessagesToDate(ActionEvent event) throws ParseException {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = null;
		today = df.parse(value);
		DUMMY1_BEAN.setUI_M_DUE_PERIOD_TO(today);

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List<UI_M_POLICY_FM_LOV> UI_M_CURRENCY_CODE_lovAction(Object obj)
			throws Exception {
		List<UI_M_POLICY_FM_LOV> lovList = new ArrayList<UI_M_POLICY_FM_LOV>();
		ResultSet rs = null;
		String query = null;
		/*
		 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_CURRENCY to
		 * FM_CURRENCY. Added by : Mallika.S, 01-Apr-2009
		 */
		if (obj.toString().equals("*")) {
			query = "select CURR_CODE,CURR_NAME from FM_CURRENCY ORDER BY 1";
		} else {
			query = "select CURR_CODE,CURR_NAME from FM_CURRENCY WHERE CURR_CODE LIKE('"
					+ obj.toString().toUpperCase() + "%')";
		}
		// Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setCURR_CODE(rs.getString("CURR_CODE"));
			lovBox.setCURR_DESC(rs.getString("CURR_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		// CommonUtils.getConnection().close();
		return lovList;
	}

	// SuggestionList for POL_NO in PT_IL_PREM_COLL
	public List<UI_M_POLICY_FM_LOV> UI_M_POL_NO_lovAction(Object obj)
			throws Exception {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		List<UI_M_POLICY_FM_LOV> lovList = new ArrayList<UI_M_POLICY_FM_LOV>();
		ResultSet rs = null;
		String query = null;
		if (obj.toString().equals("*")) {
			query = "select POL_NO from  pt_il_policy where POL_APPRV_STATUS='A' AND POL_CONT_CODE='"
					+ actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
							.getUI_M_CONTRACTOR_CODE() + "'";
		} else {
			query = "select POL_NO from  pt_il_policy where POL_APPRV_STATUS='A' AND POL_CONT_CODE='"
					+ actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
							.getUI_M_CONTRACTOR_CODE()
					+ "' AND POL_NO LIKE('"
					+ obj.toString().toUpperCase() + "%')";
		}
		System.out.println("Query --------------" + query);
		// Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV();
			lovBox.setPOL_NO(rs.getString("POL_NO"));
			actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_PC_POL_NO(rs.getString("POL_NO"));
			lovList.add(lovBox);
		}
		rs.close();
		// CommonUtils.getConnection().close();
		return lovList;
	}

	// end pol_no
	// M_POL_CUST_CURR_CODE for Grid
	// calling of triggers
	public void UI_M_EMPLOYER_CODE_WHEN_VALIDATE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		if (null != value) {
			DUMMY1_BEAN.setUI_M_EMPLOYER_CODE(value.toString());
		}

		DUMMY1_HELPER helper = new DUMMY1_HELPER();
		helper.when_validate_ui_m_employer_code();
	}

	public void UI_M_DUE_PERIOD_FM_WHEN_VALIDATE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		if (null != value) {
			Date temp = (Date) value;
			DUMMY1_BEAN.setUI_M_DUE_PERIOD_FM(temp);
		}

	}

	public void UI_M_CONTRACTOR_CODE_WHEN_VALIDATE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		if (null != value) {
			DUMMY1_BEAN.setUI_M_CONTRACTOR_CODE(value.toString());
		}
		DUMMY1_HELPER helper = new DUMMY1_HELPER();
		helper.when_validate_ui_m_contractor_code();
	}

	public void UI_M_CURR_CODE_WHEN_VALIDATE(FacesContext fc,
			UIComponent component, Object value) {

		if (null != value) {
			String tempValue = value.toString();
			DUMMY1_BEAN.setUI_M_POL_CURR_CODE(tempValue);
		}
		System.out.println("UI_M_CURR_CODE_WHEN_VALIDATE called");
		DUMMY1_HELPER helper = new DUMMY1_HELPER();
		helper.when_validate_ui_m_curr_code();
	}

	public void UI_M_PAID_DT_WHEN_VALIDATE(FacesContext fc,
			UIComponent component, Object value) throws Exception {
		System.out.println("UI_M_PAID_DT_WHEN_VALIDATE called");
		DUMMY1_HELPER helper = new DUMMY1_HELPER();
		helper.when_validate_ui_m_paid_dt();
	}

	// UI_M_DATE_COMPARIISION
	CommonUtils utility = new CommonUtils();

	public void UI_M_DATE_COMPARIISION(FacesContext fc, UIComponent component,
			Object value) {
		getErrorMap().clear();
		String message = null;
		Date tempDate = null;

		if (null != value) {
			tempDate = (Date) value;
			DUMMY1_BEAN.setUI_M_DUE_PERIOD_TO(tempDate);
		}
		Date d1 = DUMMY1_BEAN.getUI_M_DUE_PERIOD_FM();
		Date d2 = DUMMY1_BEAN.getUI_M_DUE_PERIOD_TO();
		if (null == d1) {
			message = "Enter DuePeriod From";
			throw new ValidatorException(new FacesMessage(message));
		}

		if (null == d2) {
			message = "Enter DuePeriod To";
			throw new ValidatorException(new FacesMessage(message));
		}

		try {

			if (null != d1 && null != d2) {
				int results = d1.compareTo(d2);
				if (results > 0) {
					message = Messages.getString(
							PELConstants.pelErrorMessagePath, "91054");
					throw new ValidatorException(new FacesMessage(message));
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public ControlBean getCtrlBean() {
		/*
		 * FacesContext faces2 = FacesContext.getCurrentInstance(); session =
		 * faces2.getExternalContext().getSessionMap(); return (ControlBean)
		 * session.get("ctrlbean");
		 */

		return CommonUtils.getControlBean();
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public void preForm() throws Exception {
		String M_FILE;
		String M_TITLE;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		DUMMY dummyBean = actionBean.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> listCurr = procedures.helperF_GET_BASE_CURRENCY(
				CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N",
				P_CURR_CODE, P_NAME, P_DECIMAL + "", "E");
		if (listCurr != null && listCurr.size() > 0) {
			P_CURR_CODE = listCurr.get(0);
			P_NAME = listCurr.get(1);
			P_DECIMAL = CommonUtils.parseToInt(listCurr.get(2));
			dummyBean.setUI_BASE_CURR_CODE(P_CURR_CODE);
		}
		String C2 = "SELECT DS_CURR_RATE_BS  FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '2' AND    DS_FRZ_FLAG = 'N' AND DS_CODE = '"
				+ CommonUtils.getGlobalVariable("GLOBAL.M_PARA_1") + "'";
		CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE", "YYY");
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
		
		CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME", "PILT020");
		dummyBean.setPT_IL_LOAN_INT_COLL_CF("P");
		dummyBean.setPT_IL_POLICY_CF("F");
		dummyBean.setPT_IL_PREM_COLL_CF("P");
		
		rs = handler.executeSelectStatement(C2, CommonUtils.getConnection());
		if (rs.next()) {
			dummyBean.setUI_M_BUY_SELL(rs.getString("DS_CURR_RATE_BS"));
		}
	}


	// For Broker Values Page
	public String navigate_to_Broker_Values() {
		CommonUtils util = new CommonUtils();
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Integer tempSysId = 0;
		COMPOSITE_BEAN = (PILT020_COMPOSITE_ACTION) util
				.getMappedBeanFromSession("PILT020_COMPOSITE_ACTION");
		PT_IL_BROKER_VALUES BROKER_VALUES = new PT_IL_BROKER_VALUES();
		PT_IL_PREM_COLL premBean = COMPOSITE_BEAN.getDUMMY_ACTION_BEAN()
				.getPT_IL_PREM_COLL_BEAN();
		if (null != premBean.getPC_SYS_ID()) {
			tempSysId = premBean.getPC_SYS_ID();
		}
		String selectQuery = "select * from PT_IL_BROKER_VALUES, PT_IL_PREM_COLL where PT_IL_BROKER_VALUES.BV_PC_SYS_ID = '"
				+ premBean.getPC_SYS_ID()
				+ "' AND PT_IL_BROKER_VALUES.BV_PC_SYS_ID = PT_IL_PREM_COLL.PC_SYS_ID";
		List<PT_IL_BROKER_VALUES> Broker_list = new ArrayList<PT_IL_BROKER_VALUES>();
		DBProcedures proc = new DBProcedures();
		try {
			rs = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection());
			while (rs.next()) {
				PT_IL_BROKER_VALUES bean = new PT_IL_BROKER_VALUES();
				bean.setBV_BROKER_CODE(rs.getString("BV_BROKER_CODE"));
				bean.setBV_COMM_CODE(rs.getString("BV_COMM_CODE"));
				bean.setBV_COVER_CODE(rs.getString("BV_COVER_CODE"));
				bean.setBV_FC_VALUE(rs.getDouble("BV_FC_VALUE"));
				bean.setBV_LC_VALUE(rs.getDouble("BV_LC_VALUE"));
				bean.setBV_POL_SYS_ID(rs.getDouble("BV_POL_SYS_ID"));
				bean.setBV_RATE(rs.getDouble("BV_RATE"));
				bean.setBV_RATE_PER(rs.getDouble("BV_RATE_PER"));
				bean.setBV_YEAR(rs.getDouble("BV_YEAR"));
				List<String> broker_Desc = proc.helperP_VAL_CUST(rs
						.getString("BV_BROKER_CODE"), "N", "N");
				bean.setUI_M_BROKER_DESC(broker_Desc.get(0));
				List<String> cover_Desc = proc.helperP_VAL_COVER(rs
						.getString("BV_COVER_CODE"), "", "N", "N");
				bean.setUI_M_COVER_DESC(cover_Desc.get(0));
				Broker_list.add(bean);

			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		COMPOSITE_BEAN.getPT_IL_BROKER_VALUES_ACTION_BEAN().setFetchList(
				Broker_list);
		return "test";
	}

	boolean checked = false;

	// on Tab out From Dummy Populate the pt-il_prem_coll block
	public void PT_IL_PREM_ONTAB(ActionEvent e) {
		CommonUtils util = new CommonUtils();
		String selectQuery = trig_pre_query_pt_il_prem_coll();
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		DUMMY1 dummy1Bean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_POP = new PT_IL_PREM_COLL();
		COMPOSITE_BEAN = (PILT020_COMPOSITE_ACTION) util
				.getMappedBeanFromSession("PILT020_COMPOSITE_ACTION");
		PT_IL_PREM_COLL_ACTION PREM_COLL = new PT_IL_PREM_COLL_ACTION();

		/*
		 * String PREM_COLL_SYS_ID = COMPOSITE_BEAN
		 * .getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN()
		 * .getPC_SYS_ID(); int CHARGE_SYS_ID;
		 * 
		 * 
		 * try { CHARGE_SYS_ID = Integer.parseInt(COMPOSITE_BEAN
		 * .getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
		 * .getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_SYS_ID() .toString()); }
		 * catch (Exception e1) { // TODO: handle exception
		 * System.out.println("Into Catch"); CHARGE_SYS_ID = 242; }
		 * 
		 * 
		 * System.out.println("........................\n\n");
		 * System.out.println("PERMENANT SYSID .........." + PREM_COLL_SYS_ID);
		 * System.out.println("CHARGE SYSID .........." + CHARGE_SYS_ID);
		 * 
		 * System.out.println("\n\n........................");
		 * 
		 */

		// populate the next bean for the next page
		System.out.println("selectQuery.........................."
				+ selectQuery);
		DBProcedures proc = new DBProcedures();
		List<PT_IL_PREM_COLL> Prem_coll_list = new ArrayList<PT_IL_PREM_COLL>();
		try {
			rs = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection());
			if(rs.next()) {
				PT_IL_PREM_COLL bean = COMPOSITE_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
				bean.setROWID(rs.getString("ROWID"));
				bean.setPC_FAC_CLOSE_FLAG(rs.getString("PC_FAC_CLOSE_FLAG"));
				bean.setPC_FC_ADDL_PREM(rs.getDouble("PC_FC_ADDL_PREM"));
				bean.setPC_FC_AVLB_BAL_AMT(rs.getDouble("PC_FC_AVLB_BAL_AMT"));
				bean.setPC_FC_BASIC_PREM(rs.getDouble("PC_FC_BASIC_PREM"));
				bean.setPC_FC_CHARGE(rs.getDouble("PC_FC_CHARGE"));
				bean.setPC_FC_CHARGE_AMT(rs.getDouble("PC_FC_CHARGE_AMT"));
				bean.setPC_FC_DISCOUNT(rs.getDouble("PC_FC_DISCOUNT"));
				bean.setPC_FC_GROSS_PREM(rs.getDouble("PC_FC_GROSS_PREM"));
				bean.setPC_FC_LOAD_AMT(rs.getDouble("PC_FC_LOAD_AMT"));
				bean.setPC_FC_PAID_AMT(rs.getDouble("PC_FC_PAID_AMT"));
				bean.setPC_FC_UNPAID_PREM_INT(rs
						.getDouble("PC_FC_UNPAID_PREM_INT"));
				List<String> fc_unpaid_prem = proc.callP_VAL_ROUND_AMT(
						actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
								.getUI_M_POL_CURR_CODE(), bean
								.getPC_FC_UNPAID_PREM_INT().toString(), "R");
				bean.setPC_FC_UNPAID_PREM_INT(Double.valueOf(fc_unpaid_prem
						.get(0)));
				bean.setPC_LC_ADDL_PREM(rs.getDouble("PC_LC_ADDL_PREM"));
				bean.setPC_LC_AVLB_BAL_AMT(rs.getDouble("PC_LC_AVLB_BAL_AMT"));
				bean.setPC_LC_BASIC_PREM(rs.getDouble("PC_LC_BASIC_PREM"));
				bean.setPC_LC_CHARGE(rs.getDouble("PC_LC_CHARGE"));
				bean.setPC_LC_CHARGE_AMT(rs.getDouble("PC_LC_CHARGE_AMT"));
				bean.setPC_LC_DISCOUNT(rs.getDouble("PC_LC_DISCOUNT"));
				bean.setPC_LC_GROSS_PREM(rs.getDouble("PC_LC_GROSS_PREM"));
				bean.setPC_LC_LOAD_AMT(rs.getDouble("PC_LC_LOAD_AMT"));
				bean.setPC_LC_PAID_AMT(rs.getDouble("PC_LC_PAID_AMT"));
				bean.setPC_LC_UNPAID_PREM_INT(rs
						.getDouble("PC_LC_UNPAID_PREM_INT"));
				List<String> lc_unpaid_prem = proc.callP_VAL_ROUND_AMT(
						actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
								.getUI_M_POL_CURR_CODE(), bean
								.getPC_LC_UNPAID_PREM_INT().toString(), "R");
				bean.setPC_LC_UNPAID_PREM_INT(Double.valueOf(lc_unpaid_prem
						.get(0)));
				bean.setPC_PAID_DT(rs.getDate("PC_PAID_DT"));
				bean.setPC_PAID_FLAG(rs.getString("PC_PAID_FLAG"));
				bean.setPC_POL_SYS_ID(rs.getDouble("PC_POL_SYS_ID"));
				bean.setPC_PREM_TYPE(rs.getString("PC_PREM_TYPE"));
				bean.setPC_REF_NO(rs.getString("PC_REF_NO"));
				bean.setPC_RI_CLOSE_FLAG(rs.getString("PC_RI_CLOSE_FLAG"));
				bean.setPC_SCHD_PYMT_DT(rs.getDate("PC_SCHD_PYMT_DT"));
				bean.setPC_SYS_ID(rs.getInt("PC_SYS_ID"));
				bean.setUI_M_FC_LOAN_INT(111.0);
				// P_VAL_ROUND_AMT procedure can be used instead of
				// java.lang.Math.rint(bean.getUI_M_FC_NET_PREM());
				bean.setUI_M_LC_LOAN_INT(111.00);
				bean.setUI_M_LC_NET_PREM(bean.getPC_LC_GROSS_PREM()
						+ bean.getPC_LC_CHARGE()
						+ bean.getPC_LC_UNPAID_PREM_INT());
				bean.setUI_M_FC_NET_PREM(bean.getPC_FC_GROSS_PREM()
						+ bean.getPC_FC_CHARGE()
						+ bean.getPC_FC_UNPAID_PREM_INT());
				List<String> lc_net_prem = proc.callP_VAL_ROUND_AMT(actionBean
						.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_POL_CURR_CODE(), bean.getUI_M_LC_NET_PREM()
						.toString(), "R");
				List<String> fc_net_prem = proc.callP_VAL_ROUND_AMT(actionBean
						.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_POL_CURR_CODE(), bean.getUI_M_FC_NET_PREM()
						.toString(), "R");
				bean.setUI_M_LC_NET_PREM(Double.valueOf(lc_net_prem.get(0)));
				bean.setUI_M_FC_NET_PREM(Double.valueOf(fc_net_prem.get(0)));
				bean.setUI_M_POL_CUST_CURR_CODE(dummy1Bean
						.getUI_M_POL_CURR_CODE());
				bean.setUI_M_POL_CUST_EXCH_RATE(PT_IL_PREM_COLL_POP
						.getUI_M_POL_CUST_EXCH_RATE());
				Prem_coll_list.add(bean);

			}
			
			if(Prem_coll_list.size()>0){
				COMPOSITE_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().setFetchList(Prem_coll_list);
				COMPOSITE_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().setPT_IL_PREM_COLL_BEAN(Prem_coll_list.get(0));
				COMPOSITE_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getFetchList().get(0).setRowSelected(true);
			}
			
			
			
			// double M_FC_NET_PREM =

			/*
			 * Prem_coll_list = handler.fetch(selectQuery,
			 * "com.iii.pel.forms.PILT020.PT_IL_PREM_COLL",
			 * CommonUtils.getConnection());
			 */
			// PM_LIFE_TAX_COMPOSITE_BEAN.getPM_LIFE_TAX_APPL_PROD_COMPOSITE().setFetchList(list);
		} catch (Exception e12) {
			// TODO: handle exception
			e12.printStackTrace();
		}

		//return "PT_TL_CHARGE_SETUP";

	}

	// Navigate and populate Charges block
	public String navigate_to_Charges() throws Exception {
		CommonUtils util = new CommonUtils();
		ResultSet rs = null;
		PT_IL_PREM_COLL_CHARGE PT_IL_PREM_COLL_CHARGE_POP = new PT_IL_PREM_COLL_CHARGE();
		COMPOSITE_BEAN = (PILT020_COMPOSITE_ACTION) util
				.getMappedBeanFromSession("PILT020_COMPOSITE_ACTION");
		PT_IL_BROKER_VALUES BROKER_VALUES = new PT_IL_BROKER_VALUES();

		PT_IL_PREM_COLL premBean = COMPOSITE_BEAN.getDUMMY_ACTION_BEAN()
				.getPT_IL_PREM_COLL_BEAN();
		int CHARGE_SYS_ID;

		try {
			CHARGE_SYS_ID = COMPOSITE_BEAN
					.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
					.getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_SYS_ID();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Into Catch");
			CHARGE_SYS_ID = 483;
		}
		COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
				.getPT_IL_PREM_COLL_CHARGE_BEAN().setUI_M_CHARGE_DESC(
						"HardCoded");

		// populate the next bean for the next page
		String selectQuery = "select * from PT_IL_PREM_COLL_CHARGE, PT_IL_PREM_COLL where PT_IL_PREM_COLL_CHARGE.PCC_SYS_ID = "
				+ premBean.getPC_SYS_ID()
				+ " AND PT_IL_PREM_COLL_CHARGE.PCC_SYS_ID = PT_IL_PREM_COLL.PC_SYS_ID";
		System.out.println("selectQuery.........................."
				+ selectQuery);
		List<PT_IL_PREM_COLL_CHARGE> Charge_list = new ArrayList<PT_IL_PREM_COLL_CHARGE>();
		PILT020_DB_PROCEDURES db_proc = new PILT020_DB_PROCEDURES();
		try {
			rs = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection());
			while (rs.next()) {
				PT_IL_PREM_COLL_CHARGE bean = new PT_IL_PREM_COLL_CHARGE();
				bean.setPCC_CHARGE_CODE(rs.getString("PCC_CHARGE_CODE"));

				String Desc = db_proc.P_VAL_CODES(CommonUtils.getConnection(),
						"IL_CHARGE", bean.getPCC_CHARGE_CODE(), bean
								.getUI_M_CHARGE_DESC(), "N", "N", null);
				bean.setUI_M_CHARGE_DESC(Desc);
				bean.setUI_B_CHARGE_DESC("Testing");
				System.out.println("Description inside********* "
						+ bean.getUI_M_CHARGE_DESC());
				bean.setPCC_APPLY_PERIOD(rs.getString("PCC_APPLY_PERIOD"));
				bean
						.setPCC_CUST_SHARE_PERC(rs
								.getDouble("PCC_CUST_SHARE_PERC"));
				bean.setPCC_FC_CHARGE_AMT(rs.getDouble("PCC_FC_CHARGE_AMT"));
				bean.setPCC_FC_INS_CHARGE_AMT(rs
						.getDouble("PCC_FC_INS_CHARGE_AMT"));
				bean.setPCC_LC_CHARGE_AMT(rs.getDouble("PCC_LC_CHARGE_AMT"));
				bean.setPCC_LC_INS_CHARGE_AMT(rs
						.getDouble("PCC_LC_INS_CHARGE_AMT"));
				bean.setPCC_SYS_ID(rs.getInt("PCC_SYS_ID"));

				Charge_list.add(bean);
			}

			/*
			 * Charge_list = handler.fetch(selectQuery,
			 * "com.iii.pel.forms.PILT020.PT_IL_PREM_COLL_CHARGE",
			 * CommonUtils.getConnection());
			 */
			// PM_LIFE_TAX_COMPOSITE_BEAN.getPM_LIFE_TAX_APPL_PROD_COMPOSITE().setFetchList(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("CHARGE_VALUES=============="
				+ PT_IL_PREM_COLL_CHARGE_POP.getPCC_FC_CHARGE_AMT());

		System.out.println("Size of List==============" + Charge_list.size());
		COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().setFetchList(
				Charge_list);

		// System.out.println("PM_LIFE_TAX_COMPOSITE_BEAN.setTAX_TYPE.........................."+PM_LIFE_TAX_COMPOSITE_BEAN.getTAX_TYPE()
		// );
		// COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().setUI_M_CHARGE_DESC("MY
		// Description");

		/*
		 * System.out.println("COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().setUI_M_CHARGE_DESC('MY
		 * Description')...."+
		 * COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getUI_M_CHARGE_DESC());
		 * System.out.println("**********************************************");
		 * System.out.println("COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().setUI_M_CHARGE_DESC('MY
		 * Description')...."+
		 * COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_CHARGE_CODE());
		 * 
		 * String Desc =
		 * db_proc.P_VAL_CODES(CommonUtils.getConnection(),"IL_CHARGE",COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_CHARGE_CODE(),COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getUI_M_CHARGE_DESC(),"N","N",null);
		 * System.out.println("Chandra Desc.............."+Desc); //String
		 * return_Desc =
		 * trig_post_query_pt_il_prem_coll_charge(COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_CHARGE_CODE(),COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getUI_M_CHARGE_DESC());
		 * COMPOSITE_BEAN.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().setUI_M_CHARGE_DESC(Desc);
		 */
		return "PT_TL_CHARGE_SETUP";
	}

	// MEthod to from the query on populate prem-coll

	public String trig_pre_query_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String query = " SELECT ROWID,PC_SYS_ID,PC_RI_CLOSE_FLAG,PC_PREM_TYPE,PC_POL_SYS_ID,PC_SCHD_PYMT_DT,PC_PAID_DT,PC_FAC_CLOSE_FLAG,PC_FC_AVLB_BAL_AMT,PC_FC_PAID_AMT,PC_LC_PAID_AMT,PC_PAID_FLAG,PC_REF_NO,PC_FC_BASIC_PREM,PC_LC_BASIC_PREM,PC_FC_CHARGE_AMT,PC_LC_CHARGE_AMT,PC_FC_ADDL_PREM,PC_LC_ADDL_PREM,PC_FC_CHARGE,PC_LC_CHARGE,PC_FC_LOAD_AMT,PC_LC_LOAD_AMT,PC_FC_DISCOUNT,PC_LC_DISCOUNT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM,PC_FC_UNPAID_PREM_INT,PC_LC_UNPAID_PREM_INT,PC_LC_AVLB_BAL_AMT FROM PT_IL_PREM_COLL ";
		DUMMY1_ACTION dummyBean = (DUMMY1_ACTION) actionBean
				.getDUMMY1_ACTION_BEAN();

		String where = "WHERE ";

		where = where + "PC_EMPLOYER_CODE='"
				+ dummyBean.getDUMMY1_BEAN().getUI_M_EMPLOYER_CODE()
				+ "' AND PC_PAID_FLAG != 'A'";

		/*
		 * String where = null; // Before Approval if
		 * ("N".equals(MigratingFunctions.nvl(CommonUtils
		 * .getGlobalVariable("GLOBAL.M_SUCC"), "N"))) {
		 * 
		 * if (dummyBean.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue() !=
		 * null) { where = "PC_EMPLOYER_CODE = '" +
		 * dummyBean.getCOMP_UI_M_EMPLOYER_CODE() .getSubmittedValue() + "' AND
		 * PC_PAID_FLAG != 'A'"; } else { where = "PC_CONT_CODE = '" +
		 * dummyBean.getCOMP_UI_M_CONTRACTOR_CODE() .getSubmittedValue() + "'
		 * AND PC_PAID_FLAG !='A' AND PC_SCHD_PYMT_DT BETWEEN='" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_FM() .getSubmittedValue() + "' AND '" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_TO() .getSubmittedValue() + "'"; }
		 * }// After Approval else if
		 * (dummyBean.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue() != null) {
		 * where = "PC_EMPLOYER_CODE = '" +
		 * dummyBean.getCOMP_UI_M_EMPLOYER_CODE() .getSubmittedValue() + "' AND
		 * PC_PAID_FLAG != 'A'"; } else { where = "PC_CONT_CODE = '" +
		 * dummyBean.getCOMP_UI_M_CONTRACTOR_CODE() .getSubmittedValue() + "'
		 * AND PC_PAID_FLAG !='A' AND PC_SCHD_PYMT_DT BETWEEN='" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_FM() .getSubmittedValue() + "' AND '" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_TO() .getSubmittedValue() + "'"; }
		 * 
		 */
		query = query + " " + where;
		System.out.println("Formed Query is ............." + query);

		return query;
	}

	// This Method is to be called in the appropriate place

	public void when_Validate_Item_For_All(ActionEvent event) {
		PT_IL_PREM_COLL_ACTION_TRIGGERS coll_action_triggers = new PT_IL_PREM_COLL_ACTION_TRIGGERS();
		String component = event.getComponent().getParent().getId();
		coll_action_triggers.when_Validate_Item_For_All(component);

	}

	// POST_QUERY of PT_IL_PREM_COLL
	public void trig_post_query_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		String C1 = "SELECT POL_CUST_CURR_CODE, POL_CUST_EXCH_RATE, POL_NO FROM   PT_IL_POLICY WHERE  POL_SYS_ID = '"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_POL_SYS_ID() + "'";
		String M_IL_RND_TYPE = null;
		String C2 = "SELECT  PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_RND_TYPE'";
		// L_LOAN_APPBL;
		// /L_BROK_APPBL;

	}

	public void approvePremim() {

		try {
			System.out
					.println("inside approveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			DUMMY1_HELPER dummy1_helper = new DUMMY1_HELPER();
			dummy1_helper.approvePremim();

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}

	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public HtmlCommandButton getCOMP_POPUP() {
		return COMP_POPUP;
	}

	public void setCOMP_POPUP(HtmlCommandButton comp_popup) {
		COMP_POPUP = comp_popup;
	}
}
