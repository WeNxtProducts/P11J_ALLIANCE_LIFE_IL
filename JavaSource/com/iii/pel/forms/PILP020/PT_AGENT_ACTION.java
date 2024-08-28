package com.iii.pel.forms.PILP020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_A_APAC;
import com.iii.pel.forms.PILQ016.PILQ016_COMPOSITE_ACTION;
import com.iii.pel.forms.PM068_A.BUTTON_PALETTE;
import com.iii.pel.utils.P9ILPK_AGENT_PRODUCTION_DAY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_AGENT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_CUST_CLASS_FM_LABEL;

	private HtmlInputText COMP_UI_M_CUST_CLASS_FM;

	private HtmlOutputLabel COMP_UI_M_CUST_CLASS_TO_LABEL;

	private HtmlInputText COMP_UI_M_CUST_CLASS_TO;

	private HtmlOutputLabel COMP_UI_M_AGENCY_FM_LABEL;

	private HtmlInputText COMP_UI_M_AGENCY_FM;
	
	private HtmlInputText COMP_UI_M_CUST_CLASS_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_AGENCY_TO_LABEL;

	private HtmlInputText COMP_UI_M_AGENCY_TO;

	private HtmlOutputLabel COMP_UI_M_AGENT_FM_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_FM;

	private HtmlOutputLabel COMP_UI_M_AGENT_TO_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_TO;
	
	private HtmlInputText COMP_CCLAS_CLASS_DESC;
	
	private HtmlInputText COMP_CCLAS_CLASS_DESC_TO;
	
	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlCommandButton COMP_UI_M_AGENCY_LOV_FM;

	private HtmlCommandButton COMP_UI_M_AGENCY_LOV_TO;

	private HtmlCommandButton COMP_UI_M_CUST_CLASS_LOV_FM;

	private HtmlCommandButton COMP_UI_M_CUST_CLASS_LOV_TO;

	private HtmlCommandButton COMP_UI_M_AGENT_LOV_FM;

	private HtmlCommandButton COMP_UI_M_AGENT_LOV_TO;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_MON_END_PROCESS;

	private HtmlCommandButton COMP_UI_PRE_FORM;

	FacesContext facesContext = FacesContext.getCurrentInstance();

	GNMNF002_A_APAC gnmnf002_a_apac = null;

	// ControlBean controlBean = null;

	private String M_PARA_1;

	private String M_TITLE;

	private String M_MODULE_ID;

	private String M_DUMMY_X;

	private UIData dataGrid;

	private List<PT_AGENT> dataList;

	BUTTON_PALETTE button_palette = new BUTTON_PALETTE();

	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();

	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();

	Map<String, Object> session = null;

	Date M_START_MON, M_END_MON;

	Date M_ACMB_FM_DT, M_ACMB_TO_DT;

	private PT_AGENT PT_AGENT_BEAN;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

	public PT_AGENT_ACTION() {
		PT_AGENT_BEAN = new PT_AGENT();
		PRE_FORM();
		WHEN_NEW_BLOCK_INSTANCE();
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_CLASS_FM_LABEL() {
		return COMP_UI_M_CUST_CLASS_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CLASS_FM() {
		return COMP_UI_M_CUST_CLASS_FM;
	}

	public void setCOMP_UI_M_CUST_CLASS_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_CLASS_FM_LABEL) {
		this.COMP_UI_M_CUST_CLASS_FM_LABEL = COMP_UI_M_CUST_CLASS_FM_LABEL;
	}

	public void setCOMP_UI_M_CUST_CLASS_FM(HtmlInputText COMP_UI_M_CUST_CLASS_FM) {
		this.COMP_UI_M_CUST_CLASS_FM = COMP_UI_M_CUST_CLASS_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_CLASS_TO_LABEL() {
		return COMP_UI_M_CUST_CLASS_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CLASS_TO() {
		return COMP_UI_M_CUST_CLASS_TO;
	}

	public void setCOMP_UI_M_CUST_CLASS_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_CLASS_TO_LABEL) {
		this.COMP_UI_M_CUST_CLASS_TO_LABEL = COMP_UI_M_CUST_CLASS_TO_LABEL;
	}

	public void setCOMP_UI_M_CUST_CLASS_TO(HtmlInputText COMP_UI_M_CUST_CLASS_TO) {
		this.COMP_UI_M_CUST_CLASS_TO = COMP_UI_M_CUST_CLASS_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENCY_FM_LABEL() {
		return COMP_UI_M_AGENCY_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENCY_FM() {
		return COMP_UI_M_AGENCY_FM;
	}

	public void setCOMP_UI_M_AGENCY_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENCY_FM_LABEL) {
		this.COMP_UI_M_AGENCY_FM_LABEL = COMP_UI_M_AGENCY_FM_LABEL;
	}

	public void setCOMP_UI_M_AGENCY_FM(HtmlInputText COMP_UI_M_AGENCY_FM) {
		this.COMP_UI_M_AGENCY_FM = COMP_UI_M_AGENCY_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENCY_TO_LABEL() {
		return COMP_UI_M_AGENCY_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENCY_TO() {
		return COMP_UI_M_AGENCY_TO;
	}

	public void setCOMP_UI_M_AGENCY_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENCY_TO_LABEL) {
		this.COMP_UI_M_AGENCY_TO_LABEL = COMP_UI_M_AGENCY_TO_LABEL;
	}

	public void setCOMP_UI_M_AGENCY_TO(HtmlInputText COMP_UI_M_AGENCY_TO) {
		this.COMP_UI_M_AGENCY_TO = COMP_UI_M_AGENCY_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_LABEL() {
		return COMP_UI_M_AGENT_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_FM() {
		return COMP_UI_M_AGENT_FM;
	}

	public void setCOMP_UI_M_AGENT_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_FM_LABEL) {
		this.COMP_UI_M_AGENT_FM_LABEL = COMP_UI_M_AGENT_FM_LABEL;
	}

	public void setCOMP_UI_M_AGENT_FM(HtmlInputText COMP_UI_M_AGENT_FM) {
		this.COMP_UI_M_AGENT_FM = COMP_UI_M_AGENT_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_LABEL() {
		return COMP_UI_M_AGENT_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_TO() {
		return COMP_UI_M_AGENT_TO;
	}

	public void setCOMP_UI_M_AGENT_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_TO_LABEL) {
		this.COMP_UI_M_AGENT_TO_LABEL = COMP_UI_M_AGENT_TO_LABEL;
	}

	public void setCOMP_UI_M_AGENT_TO(HtmlInputText COMP_UI_M_AGENT_TO) {
		this.COMP_UI_M_AGENT_TO = COMP_UI_M_AGENT_TO;
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

	public HtmlCommandButton getCOMP_UI_M_AGENCY_LOV_FM() {
		return COMP_UI_M_AGENCY_LOV_FM;
	}

	public void setCOMP_UI_M_AGENCY_LOV_FM(
			HtmlCommandButton COMP_UI_M_AGENCY_LOV_FM) {
		this.COMP_UI_M_AGENCY_LOV_FM = COMP_UI_M_AGENCY_LOV_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_AGENCY_LOV_TO() {
		return COMP_UI_M_AGENCY_LOV_TO;
	}

	public void setCOMP_UI_M_AGENCY_LOV_TO(
			HtmlCommandButton COMP_UI_M_AGENCY_LOV_TO) {
		this.COMP_UI_M_AGENCY_LOV_TO = COMP_UI_M_AGENCY_LOV_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_CUST_CLASS_LOV_FM() {
		return COMP_UI_M_CUST_CLASS_LOV_FM;
	}

	public void setCOMP_UI_M_CUST_CLASS_LOV_FM(
			HtmlCommandButton COMP_UI_M_CUST_CLASS_LOV_FM) {
		this.COMP_UI_M_CUST_CLASS_LOV_FM = COMP_UI_M_CUST_CLASS_LOV_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_CUST_CLASS_LOV_TO() {
		return COMP_UI_M_CUST_CLASS_LOV_TO;
	}

	public void setCOMP_UI_M_CUST_CLASS_LOV_TO(
			HtmlCommandButton COMP_UI_M_CUST_CLASS_LOV_TO) {
		this.COMP_UI_M_CUST_CLASS_LOV_TO = COMP_UI_M_CUST_CLASS_LOV_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_AGENT_LOV_FM() {
		return COMP_UI_M_AGENT_LOV_FM;
	}

	public void setCOMP_UI_M_AGENT_LOV_FM(
			HtmlCommandButton COMP_UI_M_AGENT_LOV_FM) {
		this.COMP_UI_M_AGENT_LOV_FM = COMP_UI_M_AGENT_LOV_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_AGENT_LOV_TO() {
		return COMP_UI_M_AGENT_LOV_TO;
	}

	public void setCOMP_UI_M_AGENT_LOV_TO(
			HtmlCommandButton COMP_UI_M_AGENT_LOV_TO) {
		this.COMP_UI_M_AGENT_LOV_TO = COMP_UI_M_AGENT_LOV_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MON_END_PROCESS() {
		return COMP_UI_M_BUT_MON_END_PROCESS;
	}

	public void setCOMP_UI_M_BUT_MON_END_PROCESS(
			HtmlCommandButton COMP_UI_M_BUT_MON_END_PROCESS) {
		this.COMP_UI_M_BUT_MON_END_PROCESS = COMP_UI_M_BUT_MON_END_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_PRE_FORM() {
		return COMP_UI_PRE_FORM;
	}

	public void setCOMP_UI_PRE_FORM(HtmlCommandButton comp_ui_pre_form) {
		COMP_UI_PRE_FORM = comp_ui_pre_form;
	}

	public String getM_PARA_1() {
		return M_PARA_1;
	}

	public void setM_PARA_1(String m_para_1) {
		M_PARA_1 = m_para_1;
	}

	public String getM_TITLE() {
		return M_TITLE;
	}

	public void setM_TITLE(String m_title) {
		M_TITLE = m_title;
	}

	public String getM_MODULE_ID() {
		return M_MODULE_ID;
	}

	public void setM_MODULE_ID(String m_module_id) {
		M_MODULE_ID = m_module_id;
	}

	public PT_AGENT getPT_AGENT_BEAN() {
		return PT_AGENT_BEAN;
	}

	public void setPT_AGENT_BEAN(PT_AGENT PT_AGENT_BEAN) {
		this.PT_AGENT_BEAN = PT_AGENT_BEAN;
	}

	public String getM_DUMMY_X() {
		return M_DUMMY_X;
	}

	public void setM_DUMMY_X(String m_dummy_x) {
		M_DUMMY_X = m_dummy_x;
	}

	public Date getM_START_MON() {
		return M_START_MON;
	}

	public void setM_START_MON(Date m_start_mon) {
		M_START_MON = m_start_mon;
	}

	public Date getM_END_MON() {
		return M_END_MON;
	}

	public void setM_END_MON(Date m_end_mon) {
		M_END_MON = m_end_mon;
	}

	public Date getM_ACMB_FM_DT() {
		return M_ACMB_FM_DT;
	}

	public void setM_ACMB_FM_DT(Date m_acmb_fm_dt) {
		M_ACMB_FM_DT = m_acmb_fm_dt;
	}

	public Date getM_ACMB_TO_DT() {
		return M_ACMB_TO_DT;
	}

	public void setM_ACMB_TO_DT(Date m_acmb_to_dt) {
		M_ACMB_TO_DT = m_acmb_to_dt;
	}

	/*
	 * public void createCtrlBean(){ ControlBean bean = new ControlBean();
	 * session = facesContext.getExternalContext().getSessionMap();
	 * session.put("ctrlbean", bean); }
	 */

	/*
	 * public ControlBean getControlBean() { session =
	 * facesContext.getExternalContext().getSessionMap(); return (ControlBean)
	 * session.get("ctrlbean"); }
	 * 
	 * public void putControlBean(ControlBean controlBean) { session =
	 * facesContext.getExternalContext().getSessionMap();
	 * session.put("ctrlbean", controlBean); }
	 */

	public java.sql.Date getSystemDate() {
		CRUDHandler handler = new CRUDHandler();
		java.sql.Date sysDate = null;
		ResultSet resultSet = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection());
			while (resultSet.next()) {
				// System.out.println("Result is "+resultSet.getDate(1));
				sysDate = resultSet.getDate(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("The SYS Date == "+sysDate);
		return sysDate;
	}

	public String PRE_FORM() {
		Map sessionMap = facesContext.getExternalContext().getSessionMap();

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		COMP_UI_PRE_FORM = new HtmlCommandButton();
		gnmnf002_a_apac = new GNMNF002_A_APAC();
		gnmnf002_a_apac.executePreFormCursors();
		String moduleIDQuery = "SELECT * FROM MENU_MENUS WHERE MENU_ACTION LIKE 'PILP020'";
		try {
			resultSet = handler.executeSelectStatement(moduleIDQuery,
					CommonUtils.getConnection());
			while (resultSet.next()) {
				M_PARA_1 = resultSet.getString("MENU_PARAMETER_1");
			}
			Map<String, Object> session = facesContext.getExternalContext()
					.getSessionMap();
			session.put("CALLING_FORM", "PILP020");
			if ("".equals(session.get("CALLING_FORM"))) {
				session.put("GLOBAL.M_FAILURE", "FALSE");
				// session.put("GLOBAL.M_USER_ID", "LIFEALL");
				session.put("GLOBAL.M_PARA_1", M_PARA_1);
				session.put("GLOBAL.M_MODULE_NAME", "PILM070_APAC");
				session.put("GLOBAL.M_DFLT_VALUES", "12345678911111111");
				session.put("GLOBAL.M_MODULE_NAME", "Number Generation Setup");
			} else {
				// session.put("GLOBAL.M_USER_ID", "LIFEALL");
				session.put("GLOBAL.M_DFLT_VALUES", "12345678911111111");
			}

			// STD_PRE_FORM();
			/*
			 * setM_TITLE(controlBean.getM_USER_ID() + " " +
			 * controlBean.getM_SCR_NAME() + " " + getSystemDate());
			 */

			// SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
			/*
			 * WHEN_CREATE_RECORD(); PRE_BLOCK(); WHEN_NEW_FORM_INSTANCE();
			 * WHEN_NEW_BLOCK_INSTANCE(); WHEN_NEW_RECORD_INSTANCE();
			 */
			// System.out.println("THE CURRENT MODE IS
			// "+sessionMap.get("CURRENT_MODE").toString());
			if (!"UPDATE".equals(sessionMap.get("CURRENT_MODE"))) {
				// WHEN_CREATE_NEW_RECORD();
			}

		} catch (Exception er) {
			er.printStackTrace();
		}
		getCOMP_UI_PRE_FORM().setDisabled(true);
		return "";
	}

	public void STD_PRE_FORM() {
		// createCtrlBean();
		ControlBean controlBean = CommonUtils.getControlBean();
		button_palette = new BUTTON_PALETTE();
		button_palette.setM_RUN_DATE(getSystemDate());
		/*
		 * controlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		 * controlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
		 * controlBean.setM_PROG_NAME("PILP020");
		 */
		button_palette.setM_COMP_NAME(gnmnf002_a_apac.globalParameters().get(
				"GLOBAL.M_NAME").toString().substring(
				1,
				gnmnf002_a_apac.globalParameters().get("GLOBAL.M_COMP_NAME")
						.toString().length()));

		/*
		 * String a =
		 * gnmnf002_a_apac.globalParameters().get("GLOBAL.M_NAME").toString();
		 * System.out.println("a valu --->" + a); int b =
		 * gnmnf002_a_apac.globalParameters().get("GLOBAL.M_COMP_NAME").toString().length()+1;
		 * System.out.println("b value -->"+ b ); int c =
		 * gnmnf002_a_apac.globalParameters().get("GLOBAL.M_SCR_NAME").toString().length();
		 * System.out.println("c value -->"+ c );
		 * System.out.println("a.substring(C,B)--->"+a.substring(c,b));
		 * System.out.println("a.substring(b,c)--->"+a.substring(b,c));
		 */

		// controlBean.setM_SCR_NAME(gnmnf002_a_apac.globalParameters().get("GLOBAL.M_NAME").toString().substring(gnmnf002_a_apac.globalParameters().get("GLOBAL.M_COMP_NAME").toString().length()+1,gnmnf002_a_apac.globalParameters().get("GLOBAL.M_SCR_NAME").toString().length()));
		// session.put("GLOBAL.M_FAILURE", "FALSE");
		/*
		 * controlBean.setM_GOFLD_NAME("NULL");
		 * controlBean.setM_LANG_CODE((String)gnmnf002_a_apac.globalParameters().get("GLOBAL.M_LANG_CODE"));
		 * controlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		 * controlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		 * controlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(6,9));
		 */
		setM_MODULE_ID((String) session.get("GLOBAL.M_MODULE_NAME"));
		setM_TITLE(controlBean.getM_USER_ID() + " "
				+ controlBean.getM_SCR_NAME() + " " + getSystemDate());

		/*
		 * SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
		 * HIDE_VIEW('ABOUT'); M_FIRST_BLOCK :=
		 * GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),
		 * FIRSTBLOCK) ;
		 */
		// IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
		if (((String) session.get("GLOBAL.M_PRIVILEGE")).substring(0, 1)
				.equals("Y")) {
			// SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE)
			// ;
		} else {
			// SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE)
			// ;
		}
		// IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
		if (((String) session.get("GLOBAL.M_PRIVILEGE")).substring(1, 1)
				.equals("Y")) {
			// SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE)
			// ;
		} else {
			// SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE)
			// ;
		}
		// IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
		/*
		 * cOMMENTED BY
		 * VIJAYif(((String)session.get("GLOBAL.M_PRIVILEGE")).substring(2,
		 * 1).equals("Y")){ //SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED,
		 * PROPERTY_TRUE) ; }else { //SET_BLOCK_PROPERTY(M_FIRST_BLOCK,
		 * DELETE_ALLOWED, PROPERTY_FALSE) ; }
		 */
		/*
		 * M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ; IF
		 * M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN EXIT ; END IF ;
		 * END LOOP ;
		 * 
		 * RG_ID := FIND_GROUP('RG_HINT') ; IF ID_NULL(RG_ID) THEN NULL ; ELSE
		 * M_QUERY_OK := POPULATE_GROUP(RG_ID) ; END IF ; RG_ID :=
		 * FIND_GROUP('RG_ALERT_MSG') ; IF ID_NULL(RG_ID) THEN NULL ; ELSE
		 * M_QUERY_OK := POPULATE_GROUP(RG_ID) ; END IF ; LOAD_BP;
		 * ENABLE_BUTTONS ; IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
		 * LOAD_BALOON_LABEL; END IF; IF M_MODULE_NAME NOT LIKE 'GNMN%' THEN
		 * P_GET_LOGO; END IF; END;
		 */

	}

	public void PRE_COMMIT() {
		STD_PRE_COMMIT();
	}

	public void STD_PRE_COMMIT() {
		ControlBean controlBean = CommonUtils.getControlBean();
		if (!"".equals(controlBean.getM_COMM_DEL())
				|| controlBean.getM_COMM_DEL() != null) {
			NVL(controlBean.getM_COMM_DEL());
		}
	}

	public boolean NVL(String value) {
		if (!"C".equals(value) || !"P".equals(value) || !"D".equals(value)) {
			// getWarningMap().put("String", "String");
			// GET_ALERT_MSG('09',M_MESSAGE);
		}

		return true;
	}

	public void POST_DATABASAE_COMMIT() {
		session.put("GLOBAL.M_FAILURE", "FALSE");
	}

	public void POST_FORMS_COMMIT() {
		session.put("GLOBAL.M_FAILURE", "FALSE");
	}

	public void WHEN_NEW_BLOCK_INSTANCE() {
		CRUDHandler handler = new CRUDHandler();
		/*
		 * PT_AGENT_BEAN.setUI_M_CUST_CLASS_FM(PELConstants.PROCESS_FROMVALUE);
		 * PT_AGENT_BEAN.setUI_M_CUST_CLASS_TO(PELConstants.PROCESS_TOVALUE);
		 * PT_AGENT_BEAN.setUI_M_AGENCY_FM(PELConstants.PROCESS_FROMVALUE);
		 * PT_AGENT_BEAN.setUI_M_AGENCY_TO(PELConstants.PROCESS_TOVALUE);
		 */
		ResultSet resultSet = null;
		Date fromDate = null;

		// String C1 = "SELECT NVL(MAX(ACMB_FM_DT),SYSDATE) FROM
		// PS_AGENT_CUR_MON_BUDGET";
		String C1 = "SELECT TRUNC(SYSDATE,'MONTH') FROM DUAL";
		try {
			resultSet = handler.executeSelectStatement(C1, CommonUtils
					.getConnection());
			while (resultSet.next()) {
				fromDate = resultSet.getDate(1);
				PT_AGENT_BEAN.setUI_M_FM_DT(fromDate);
			}
			CommonUtils.closeCursor(resultSet);
			PT_AGENT_BEAN.setUI_M_TO_DT(getToDate(fromDate));
		} catch (Exception er) {
			er.printStackTrace();
		}

	}

	private Date getToDate(Date fromdate) {
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Date toDate = null;

		try {
			if (fromdate != null) {
				String date = simpleDateFormat.format(fromdate);
				String C2 = "SELECT TRUNC(LAST_DAY('" + date + "')) FROM DUAL";
				resultSet = handler.executeSelectStatement(C2, CommonUtils
						.getConnection());
				while (resultSet.next()) {
					toDate = resultSet.getDate(1);
				}
				resultSet.close();
			}
		} catch (Exception er) {
			er.printStackTrace();
		}

		return toDate;
	}

	public List CUST_CLASS_LOV(Object object) {
		List<PT_AGENT> suggestionList = new ArrayList<PT_AGENT>();
		CRUDHandler handler = new CRUDHandler();
		String lovQuery = "";

		ResultSet resultSet = null;

		if (object.equals("*")) {
			lovQuery = "SELECT * FROM PM_CUST_CLASS WHERE CCLAS_FRZ_FLAG = 'N' AND ROWNUM<25 ORDER BY CCLAS_CODE";
		} else {
			lovQuery = "SELECT * FROM PM_CUST_CLASS WHERE CCLAS_FRZ_FLAG = 'N' AND CCLAS_CODE LIKE '"
					+ object.toString() + "%' AND ROWNUM<25 ORDER BY CCLAS_CODE";
		}
		try {
			resultSet = handler.executeSelectStatement(lovQuery, CommonUtils
					.getConnection());
			while (resultSet.next()) {
				PT_AGENT lovBean = new PT_AGENT();
				lovBean.setCCLAS_CODE(resultSet.getString("CCLAS_CODE"));
				lovBean.setCCLAS_CLASS_DESC(resultSet
						.getString("CCLAS_CLASS_DESC"));
				suggestionList.add(lovBean);
			}
			resultSet.close();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return suggestionList;
	}

	public List CUST_AGENCY_LOV(Object object) {
		List<PT_AGENT> suggestionList = new ArrayList<PT_AGENT>();
		String lovQuery = "";
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		if (object.equals("*")) {

			// lovQuery= "SELECT * FROM PM_CUSTOMER WHERE CUST_FRZ_FLAG = 'N'";
			lovQuery = "SELECT * FROM PM_CUSTOMER WHERE CUST_FRZ_FLAG = 'N'";
		} else {
			lovQuery = "SELECT * FROM PM_CUSTOMER WHERE CUST_FRZ_FLAG = 'N' AND CUST_CODE LIKE '"
					+ object.toString() + "%'";
		}

		try {
			resultSet = handler.executeSelectStatement(lovQuery, CommonUtils
					.getConnection());
			while (resultSet.next()) {
				PT_AGENT lovBean = new PT_AGENT();
				lovBean.setCUST_CODE(resultSet.getString("CUST_CODE").trim());
				lovBean.setCUST_NAME(resultSet.getString("CUST_NAME").trim());
				lovBean.setCUST_REF_ID1(resultSet.getString("CUST_REF_ID1"));
				lovBean
						.setCUST_LONG_NAME(resultSet
								.getString("CUST_LONG_NAME"));
				lovBean.setCUST_ADDR1(resultSet.getString("CUST_ADDR1"));

				suggestionList.add(lovBean);
			}

			resultSet.close();
		} catch (Exception er) {
			er.printStackTrace();
		}

		return suggestionList;
	}

	public List CUST_AGENT_LOV(Object object) {
		List<PT_AGENT> suggestionList = new ArrayList<PT_AGENT>();
		String lovQuery = "";
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		if (object.equals("*")) {
			lovQuery = "SELECT * FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','005','009') AND CUST_CLASS = CCLAS_CODE) ";
		} else {
			lovQuery = "SELECT * FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','005','009') AND CUST_CLASS = CCLAS_CODE) AND CUST_CODE LIKE '"
					+ object.toString() + "%'";
		}
		try {
			resultSet = handler.executeSelectStatement(lovQuery, CommonUtils
					.getConnection());
			while (resultSet.next()) {
				PT_AGENT lovBean = new PT_AGENT();
				lovBean.setCUST_CODE(resultSet.getString("CUST_CODE").trim());
				lovBean.setCUST_NAME(resultSet.getString("CUST_NAME").trim());
				suggestionList.add(lovBean);
			}
			resultSet.close();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return suggestionList;
	}

	public void WHEN_VALIDATE_CLASS_FM(ActionEvent actionEvent) {
		String currentValue = (String) COMP_UI_M_CUST_CLASS_FM.getSubmittedValue();

		try {
			PT_AGENT_BEAN.setUI_M_CUST_CLASS_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_UI_M_CUST_CLASS_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_CUST_CLASS_FM", e.getMessage());
		}
		/*String submittedValue = null;

		submittedValue = getCOMP_UI_M_CUST_CLASS_FM().getSubmittedValue()
				.toString();
		if ("".equals(submittedValue)) {
			PT_AGENT_BEAN.setUI_M_CUST_CLASS_FM(PELConstants.PROCESS_FROMVALUE);
		} else {
			PT_AGENT_BEAN.setUI_M_CUST_CLASS_FM(submittedValue);
		}
		getCOMP_UI_M_CUST_CLASS_FM().resetValue();

		String class_fm = submittedValue.trim();
		ErrorUtilMethod(class_fm, actionEvent);*/
	}

	public void WHEN_VALIDATE_CLASS_TO(ActionEvent actionEvent) {
		String currentValue = (String) COMP_UI_M_CUST_CLASS_TO.getSubmittedValue();
		try {
			PT_AGENT_BEAN.setUI_M_CUST_CLASS_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(PT_AGENT_BEAN.getUI_M_CUST_CLASS_FM(),
							currentValue, "String"));
			COMP_UI_M_CUST_CLASS_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_CUST_CLASS_TO", e.getMessage());
		}
		/*String submittedValue = null;
		String fromValue = null;

		submittedValue = getCOMP_UI_M_CUST_CLASS_TO().getSubmittedValue()
				.toString();
		fromValue = PT_AGENT_BEAN.getUI_M_CUST_CLASS_FM();
		if ("".equals(submittedValue)) {
			if (PELConstants.PROCESS_FROMVALUE.equals(fromValue)) {
				PT_AGENT_BEAN
						.setUI_M_CUST_CLASS_TO(PELConstants.PROCESS_TOVALUE);
			} else {
				PT_AGENT_BEAN.setUI_M_CUST_CLASS_TO(fromValue);
			}
		}
		getCOMP_UI_M_CUST_CLASS_TO().resetValue();

		String class_to = submittedValue.trim();
		ErrorUtilMethod(class_to, actionEvent);*/
	}

	public void WHEN_VALIDATE_AGENT_FM(ActionEvent actionEvent)
			throws Exception {
		String currentValue = (String) COMP_UI_M_AGENT_FM.getSubmittedValue();

		try {
			PT_AGENT_BEAN.setUI_M_AGENT_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_UI_M_AGENT_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_AGENT_FM", e.getMessage());
		}
		/*String submittedValue = null;

		submittedValue = getCOMP_UI_M_AGENT_FM().getSubmittedValue().toString();
		if ("".equals(submittedValue)) {
			PT_AGENT_BEAN.setUI_M_AGENT_FM(PELConstants.PROCESS_FROMVALUE);
		} else {
			PT_AGENT_BEAN.setUI_M_AGENT_FM(submittedValue);
		}
		getCOMP_UI_M_AGENT_FM().resetValue();

		String agentFrom = submittedValue.trim();
		// String agentTo = (String) COMP_UI_M_AGENT_TO.getSubmittedValue();
		// compareAgentCodes(agentFrom, agentTo);
		ErrorUtilMethod(agentFrom, actionEvent);*/
	}

	public void WHEN_VALIDATE_AGENT_TO(ActionEvent actionEvent)
			throws Exception {
		String currentValue = (String) COMP_UI_M_AGENT_TO.getSubmittedValue();
		try {
			PT_AGENT_BEAN.setUI_M_AGENT_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(PT_AGENT_BEAN.getUI_M_AGENT_FM(),
							currentValue, "String"));
			COMP_UI_M_AGENT_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_AGENT_TO", e.getMessage());
		}
	}
		/*UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if (input.getSubmittedValue() == null
				|| "".equalsIgnoreCase((String) input.getSubmittedValue())) {
			String submittedValue = null;
			String fromValue = null;
			submittedValue = getCOMP_UI_M_AGENT_TO().getSubmittedValue()
					.toString();
			fromValue = PT_AGENT_BEAN.getUI_M_AGENT_FM();
			if ("".equals(submittedValue)) {
				if (PELConstants.PROCESS_FROMVALUE.equals(fromValue)) {
					PT_AGENT_BEAN
							.setUI_M_AGENT_TO(PELConstants.PROCESS_TOVALUE);
					COMP_UI_M_AGENT_TO.setSubmittedValue(null);
				} else {
					PT_AGENT_BEAN.setUI_M_AGENT_TO(fromValue);
					COMP_UI_M_AGENT_TO.setSubmittedValue(null);
				}
			} else {
				submittedValue = getCOMP_UI_M_AGENT_TO().getSubmittedValue()
						.toString();
				PT_AGENT_BEAN.setUI_M_AGENT_TO(submittedValue);
				COMP_UI_M_AGENT_TO.setSubmittedValue(null);
			}

		} else {
			PT_AGENT_BEAN.setUI_M_AGENT_TO((String) input.getSubmittedValue());
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		
		 * String submittedValue = null; String fromValue = null;
		 * 
		 * submittedValue =
		 * getCOMP_UI_M_AGENT_TO().getSubmittedValue().toString(); fromValue =
		 * PT_AGENT_BEAN.getUI_M_AGENT_FM(); if ("".equals(submittedValue)) { if
		 * (PELConstants.PROCESS_FROMVALUE.equals(fromValue)) {
		 * PT_AGENT_BEAN.setUI_M_AGENT_TO(PELConstants.PROCESS_TOVALUE);
		 * COMP_UI_M_AGENT_TO.setSubmittedValue(null); } else {
		 * PT_AGENT_BEAN.setUI_M_AGENT_TO(fromValue);
		 * COMP_UI_M_AGENT_TO.setSubmittedValue(null); } } else { submittedValue =
		 * getCOMP_UI_M_AGENT_TO().getSubmittedValue() .toString();
		 * PT_AGENT_BEAN.setUI_M_AGENT_TO(submittedValue);
		 * COMP_UI_M_AGENT_TO.setSubmittedValue(null); } //
		 * getCOMP_UI_M_AGENT_TO().resetValue();
		 * 
		 * String agentTo = submittedValue.trim(); String agentFrom =
		 * PT_AGENT_BEAN.getUI_M_AGENT_FM(); ErrorUtilMethod(agentTo,
		 * actionEvent);
		 }*/

	/** Rajesh Added Method For String Comparison * */
	public void compareAgentCodes(String agentFrom, String agentTo)
			throws Exception {
		if (agentTo != null) {
			if (agentFrom.compareTo(agentTo) > 0) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"AGENT_COMPARISON"));
			}

		}

	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void WHEN_VALIDATE_AGENCY_FM(ActionEvent actionEvent) {
		String currentValue = (String) COMP_UI_M_AGENCY_FM.getSubmittedValue();

		try {
			PT_AGENT_BEAN.setUI_M_AGENCY_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_UI_M_AGENCY_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_AGENCY_FM", e.getMessage());
		}
		/*String submittedValue = null;

		submittedValue = getCOMP_UI_M_AGENCY_FM().getSubmittedValue()
				.toString();
		if ("".equals(submittedValue)) {
			PT_AGENT_BEAN.setUI_M_AGENCY_FM(PELConstants.PROCESS_FROMVALUE);
		} else {
			PT_AGENT_BEAN.setUI_M_AGENCY_FM(submittedValue);
		}
		getCOMP_UI_M_AGENCY_FM().resetValue();

		String class_fm = submittedValue.trim();
		ErrorUtilMethod(class_fm, actionEvent);*/
	}

	public void WHEN_VALIDATE_AGENCY_TO(ActionEvent actionEvent) {
		String currentValue = (String) COMP_UI_M_AGENCY_TO.getSubmittedValue();
		try {
			PT_AGENT_BEAN.setUI_M_AGENCY_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(PT_AGENT_BEAN.getUI_M_AGENCY_FM(),
							currentValue, "String"));
			COMP_UI_M_AGENCY_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("AGENCY_TO", e.getMessage());
		}
		/*String submittedValue = null;
		String fromValue = null;

		submittedValue = getCOMP_UI_M_AGENCY_TO().getSubmittedValue()
				.toString();
		fromValue = PT_AGENT_BEAN.getUI_M_AGENCY_FM();
		if ("".equals(submittedValue)) {
			if (PELConstants.PROCESS_FROMVALUE.equals(fromValue)) {
				PT_AGENT_BEAN.setUI_M_AGENCY_TO(PELConstants.PROCESS_TOVALUE);
			} else {
				PT_AGENT_BEAN.setUI_M_AGENCY_TO(fromValue);
			}
		}
		getCOMP_UI_M_AGENCY_TO().resetValue();

		String class_to = submittedValue.trim();
		ErrorUtilMethod(class_to, actionEvent);*/
	}

	public void CUST_CLASS_VALIDATOR(FacesContext context,
			UIComponent component, Object value) throws Exception {
		PT_AGENT_BEAN.setUI_M_CUST_CLASS_FM(getCOMP_UI_M_CUST_CLASS_FM()
				.getValue().toString());
		PT_AGENT_BEAN.setUI_M_CUST_CLASS_TO(getCOMP_UI_M_CUST_CLASS_TO()
				.getSubmittedValue().toString());
		compareAgentCodes(PT_AGENT_BEAN.getUI_M_AGENT_FM(), PT_AGENT_BEAN
				.getUI_M_AGENT_TO());
		/*
		 * L_VAL_FROM_TO(PT_AGENT_BEAN.getUI_M_CUST_CLASS_FM(), PT_AGENT_BEAN
		 * .getUI_M_CUST_CLASS_TO());
		 */
	}

	public void CUST_AGENCY_VALIDATOR(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_AGENT_BEAN.setUI_M_AGENCY_FM(getCOMP_UI_M_AGENCY_FM().getValue()
					.toString());
			PT_AGENT_BEAN.setUI_M_AGENCY_TO(getCOMP_UI_M_AGENCY_TO()
					.getSubmittedValue().toString());
			L_VAL_FROM_TO(PT_AGENT_BEAN.getUI_M_AGENCY_FM(), PT_AGENT_BEAN
					.getUI_M_AGENCY_TO());
		} catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void CUST_AGENT_VALIDATOR(FacesContext context,
			UIComponent component, Object value) throws Exception {
		String agentFrom = PT_AGENT_BEAN.getUI_M_AGENT_FM();
		String agentTo = PT_AGENT_BEAN.getUI_M_AGENT_TO();
		compareAgentCodes(agentFrom, agentTo);
	}

	/*
	 * try { PT_AGENT_BEAN.setUI_M_AGENT_FM(getCOMP_UI_M_AGENT_FM().getValue()
	 * .toString()); PT_AGENT_BEAN.setUI_M_AGENT_TO(getCOMP_UI_M_AGENT_TO()
	 * .getSubmittedValue().toString());
	 * 
	 * L_VAL_FROM_TO(PT_AGENT_BEAN.getUI_M_AGENT_FM(), PT_AGENT_BEAN
	 * .getUI_M_AGENT_TO()); } catch (Exception er) { er.printStackTrace(); }
	 */

	public void L_VAL_FROM_TO(String P_FROM_CODE, String P_TO_CODE) {
		if ("".equals(P_FROM_CODE) || P_FROM_CODE == null) {

			throw new ValidatorException(Messages
					.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"80033"));
		}
		try {
			if (Integer.parseInt(P_TO_CODE) < Integer.parseInt(P_FROM_CODE)) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"80034"));
			}
		} catch (Exception er) {
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"80034"));
			} else {
				getErrorMap().clear();
			}
		}
	}

	private boolean isFmDtValidatingBySupport = false;

	/*
	 * public void CUST_UI_M_FM_DT_VALIDATOR(FacesContext context, UIComponent
	 * component,Object value){ Date fmdate = null; try{
	 * if(isFmDtValidatingBySupport){ fmdate = (Date) value;
	 * System.out.println("-->FMDate- Value: "+fmdate+"Submitted value:
	 * "+((UIInput)component).getSubmittedValue());
	 * PT_AGENT_BEAN.setUI_M_TO_DT(getToDate(fmdate));
	 * COMP_UI_M_TO_DT.resetValue(); } isFmDtValidatingBySupport = false;
	 * }catch(Exception er){ er.printStackTrace(); } }
	 */
	public void CUST_UI_M_FM_DT_SUPPORT(ActionEvent actionEvent) {
		isFmDtValidatingBySupport = true;
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void CUST_M_FM_DT_VALIDATOR(FacesContext context,
			UIComponent component, Object obj) {
		Date fromDate = (Date) obj;
		PT_AGENT_BEAN.setUI_M_FM_DT(fromDate);
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		try {
			Connection connection = CommonUtils.getConnection();
			String fromDateString = CommonUtils
					.dateToStringFormatter(PT_AGENT_BEAN.getUI_M_FM_DT());
			CRUDHandler handler = new CRUDHandler();
			String sql_C1 = "SELECT 'X' FROM DUAL WHERE TO_DATE('"
					+ fromDateString + "','DD-MON-YYYY')=TRUNC(TO_DATE('"
					+ fromDateString + "','DD-MON-YYYY'),'MONTH')";
			resultSet = handler.executeSelectStatement(sql_C1, connection);
			String output = null;
			if (resultSet.next()) {
				output = resultSet.getString(1);
			}
			if ("X".equals(output)) {
				Date toDate = null;
				String sql_C2 = "SELECT TRUNC(LAST_DAY(TO_DATE('"
						+ fromDateString + "'))) FROM DUAL ";
				resultSet1 = handler.executeSelectStatement(sql_C2, connection);
				while (resultSet1.next()) {
					toDate = resultSet1.getDate(1);
				}
				PT_AGENT_BEAN.setUI_M_TO_DT(toDate);
				COMP_UI_M_TO_DT.setSubmittedValue(null);
			} else {
				PT_AGENT_BEAN.setUI_M_TO_DT(null);
				COMP_UI_M_TO_DT.setSubmittedValue(null);
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "92064"));
			}
		} catch (ValidatorException ve) {
			throw ve;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void COMP_MONTH_PROCESS() {
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String FM_DT = simpleDateFormat.format(PT_AGENT_BEAN.getUI_M_FM_DT());
		String TO_DT = simpleDateFormat.format(PT_AGENT_BEAN.getUI_M_TO_DT());
		String C0 = "SELECT MIN(ACMB_FM_DT),MAX(ACMB_TO_DT) FROM PS_AGENT_CUR_MON_BUDGET WHERE ACMB_AGENT_CODE BETWEEN '"
				+ PT_AGENT_BEAN.getUI_M_AGENT_FM()
				+ "' AND '"
				+ PT_AGENT_BEAN.getUI_M_AGENT_TO() + "'";
		try {
			resultSet = handler.executeSelectStatement(C0, getConnection());
			while (resultSet.next()) {
				setM_ACMB_FM_DT(resultSet.getDate(1));
				setM_ACMB_TO_DT(resultSet.getDate(2));
				/*
				 * M_ACMB_FM_DT = resultSet.getDate(1); M_ACMB_TO_DT =
				 * resultSet.getDate(2);
				 */
			}
			resultSet.close();

			String C1 = "SELECT 'X' FROM PS_AGENT_MON_BUDGET WHERE AMB_FREEZE_FLAG='Y' AND (AMB_FM_DT BETWEEN '"
					+ FM_DT
					+ "' AND '"
					+ TO_DT
					+ "' "
					+ "OR AMB_TO_DT BETWEEN '"
					+ FM_DT
					+ "' AND '"
					+ TO_DT
					+ "')";
			resultSet = handler.executeSelectStatement(C1, getConnection());
			try {
				if (resultSet.next()) {
					M_DUMMY_X = resultSet.getString(1);
					/*throw new Exception(); getErrorMap().put( "current",
							Messages.getString(
							 "com.iii.premia.common.errorUtil.PELErrorMessages",
							 "60303"));*/
				}
			} catch (Exception er) {
				//
				// getErrorMap().put("current",
				// Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
				// "60303").getDetail());
				er.printStackTrace();
			}
			resultSet.close();
			String C2 = "SELECT 'X' FROM PS_AGENT_CUR_MON_BUDGET WHERE  MONTHS_BETWEEN('01/'||"
					+ "(TO_CHAR(TO_DATE('"
					+ FM_DT
					+ "','DD/MM/RRRR'),'MON'))||'/'||TO_CHAR(TO_DATE('"
					+ FM_DT
					+ "','DD/MM/RRRR'),'RRRR'),"
					+ "'01/'||(TO_CHAR(TO_DATE('"
					+ simpleDateFormat.format(MigratingFunctions.nvl(
							getM_ACMB_TO_DT(), PT_AGENT_BEAN.getUI_M_TO_DT()))
					+ "','DD/MM/RRRR'),'MON'))||'/'||TO_CHAR(TO_DATE('"
					+ simpleDateFormat.format(MigratingFunctions.nvl(
							getM_ACMB_TO_DT(), PT_AGENT_BEAN.getUI_M_TO_DT()))
					+ "','DD/MM/RRRR'),'RRRR') )>0";

			try {
				resultSet = handler.executeSelectStatement(C2, getConnection());
				if (resultSet.next()) {
					// M_DUMMY_X = resultSet.getString(1);
					// throw new Exception();
					getErrorMap()
							.put(
									"current",
									Messages
											.getString(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"91354"));
				}
			} catch (Exception er) {
				er.printStackTrace();
				// getErrorMap().put("current",
				// Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages",
				// "91354"));
				return;
			}
			resultSet.close();

			String C3 = "SELECT 'X'	FROM PS_AGENT_CUR_MON_BUDGET WHERE ('"
					+ simpleDateFormat.format(MigratingFunctions.nvl(
							getM_ACMB_FM_DT(), PT_AGENT_BEAN.getUI_M_FM_DT()))
					+ "' > "
					+ "TO_DATE('01'||'/'||TO_CHAR(TO_DATE('"
					+ FM_DT
					+ "','DD/MM/RRRR'),'MM')||'/'||TO_CHAR"
					+ "(TO_DATE('"
					+ FM_DT
					+ "','DD/MM/RRRR'),'RR'),'DD/MM/RR') OR '"
					+ simpleDateFormat.format(MigratingFunctions.nvl(
							getM_ACMB_TO_DT(), PT_AGENT_BEAN.getUI_M_TO_DT()))
					+ "' <   LAST_DAY(TO_DATE('" + FM_DT + "','DD/MM/RRRR')))"
					+ " AND ACMB_AGENT_CODE BETWEEN '" + FM_DT + "' AND '"
					+ TO_DT + "'";
			try {
				resultSet = handler.executeSelectStatement(C3, getConnection());
				if (resultSet.next()) {
					// M_DUMMY_X = resultSet.getString(1);
					getErrorMap()
							.put(
									"current",
									Messages
											.getString(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"91355"));
				}
			} catch (Exception er) {
				// getErrorMap().put("current",
				// Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages",
				// "91355"));
				er.printStackTrace();
			}

			resultSet.close();

			String C5 = "SELECT TO_DATE('01/'|| TO_CHAR(TO_DATE('" + FM_DT
					+ "','DD/MM/RRRR')"
					+ ",'MM/RRRR'),'DD/MM/RRRR'), ADD_MONTHS(TO_DATE('01/'|| "
					+ "TO_CHAR(TO_DATE('" + FM_DT
					+ "','DD/MM/RRRR'),'MM/RRRR'),'DD/MM/RRRR'),1)-1 FROM DUAL";
			try {
				resultSet = handler.executeSelectStatement(C5, getConnection());
				while (resultSet.next()) {
					setM_START_MON(resultSet.getDate(1));
					setM_END_MON(resultSet.getDate(2));
					if (getM_START_MON() != null && getM_END_MON() != null) {
						Date user_Date = simpleDateFormat.parse(FM_DT);
						Date start_Date = simpleDateFormat
								.parse(simpleDateFormat
										.format(getM_START_MON()));
						if (user_Date.equals(start_Date)) {
							if (MONTHS_BETWEEN(getM_START_MON(), PT_AGENT_BEAN
									.getUI_M_FM_DT()) != 0
									|| MONTHS_BETWEEN(getM_END_MON(),
											PT_AGENT_BEAN.getUI_M_TO_DT()) != 0) {
								// throw new Exception();
								getErrorMap()
										.put(
												"current",
												Messages
														.getString(
																"com.iii.premia.common.errorUtil.PELErrorMessages",
																"3206",
																new Object[] { "Date should be start of the month" }));
							}
						} else {
							getErrorMap()
									.put(
											"current",
											Messages
													.getString(
															"com.iii.premia.common.errorUtil.PELErrorMessages",
															"3206",
															new Object[] { "Date should be start of the month" }));
						}
					}
				}
			} catch (Exception er) {
				getErrorMap()
						.put(
								"current",
								Messages
										.getString(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"3206",
												new Object[] { "Date should be start and end of the month" }));
				er.printStackTrace();
			}
			resultSet.close();
			// P9ILPK_AGENT_PRODUCTION.INST_FRZ_RECORD(:PT_AGENT.M_AGENCY_FM,:PT_AGENT.M_AGENCY_TO,:PT_AGENT.M_FM_DT,:PT_AGENT.M_TO_DT);
			OracleProcedureHandler ora_Handler = new OracleProcedureHandler();

			try {
				paramList.clear();
				paramList.add(new OracleParameter("in1", "STRING", "IN",
						PT_AGENT_BEAN.getUI_M_AGENT_FM()));
				paramList.add(new OracleParameter("in2", "STRING", "IN",
						PT_AGENT_BEAN.getUI_M_AGENT_TO()));
				paramList
						.add(new OracleParameter("in3", "STRING", "IN", FM_DT));
				paramList
						.add(new OracleParameter("in4", "STRING", "IN", TO_DT));

				list = ora_Handler.execute(paramList, getConnection(),
						"P9ILPK_AGENT_PRODUCTION.INST_FRZ_RECORD");
			} catch (Exception e) {

			} finally {
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (DBException e) {
					e.printStackTrace();

				}
			}
			String C4 = "SELECT ABS_CODE FROM PM_AGENT_BONUS_SETUP WHERE  ABS_BONUS_TYPE = 'MPR'";
			try {
				resultSet = handler.executeSelectStatement(C4, getConnection());
				if (resultSet.next() == false) {
					paramList.clear();
					paramList.add(new OracleParameter("in1", "STRING", "IN",
							PT_AGENT_BEAN.getUI_M_AGENCY_FM()));
					paramList.add(new OracleParameter("in2", "STRING", "IN",
							PT_AGENT_BEAN.getUI_M_AGENCY_TO()));
					paramList.add(new OracleParameter("in3", "STRING", "IN",
							FM_DT));
					paramList.add(new OracleParameter("in4", "STRING", "IN",
							TO_DT));
					paramList.add(new OracleParameter("in5", "STRING", "IN",
							TO_DT));
					list.clear();
					list = ora_Handler
							.execute(paramList, getConnection(),
									"P9ILPK_AGENT_PRODUCTION.CALC_AGT_MONTHLY_PERSISTENCY");
				}
				resultSet.close();
			} catch (Exception er) {
				er.printStackTrace();
			} finally {
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (DBException e) {
					e.printStackTrace();

				}
			}
		} catch (Exception er) {
			er.printStackTrace();
		} 

	}

	public int MONTHS_BETWEEN(Date user_Date, Date start_Date) {
		int dateComparisonValue = 0;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		if (user_Date != null && start_Date != null) {

			String selectQuery = "SELECT MONTHS_BETWEEN(TO_DATE(TO_CHAR(TO_DATE('"
					+ simpleDateFormat.format(user_Date)
					+ "'),'mmyyyy'), 'mmyyyy'), TO_DATE(TO_CHAR("
					+ "TO_DATE('"
					+ simpleDateFormat.format(start_Date)
					+ "'), 'mmyyyy'),'mmyyyy')) Diff_Date  FROM   DUAL";

			// String selectQuery ="SELECT
			// MONTHS_BETWEEN('"+simpleDateFormat.format(user_Date)+"','"+simpleDateFormat.format(start_Date)+"',0)
			// AS MONTHS_BETWEEN FROM DUAL";
			try {
				resultSet = handler.executeSelectStatement(selectQuery,
						getConnection());
				while (resultSet.next()) {
					dateComparisonValue = Integer.parseInt(resultSet
							.getString(1));
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			/*
			 * if(user_Date.compareTo(start_Date)!=0){ System.out.println("The
			 * User Entered Date is................."+user_Date);
			 * System.out.println("The Start Date is
			 * .............."+start_Date);
			 * 
			 * getErrorMap().put("current",
			 * Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
			 * "3206").getDetail());
			 */

		}
		return dateComparisonValue;
	}

	public void ErrorUtilMethod(String value, ActionEvent actionEvent) {
		if (value.trim() != null || value.trim().length() != 0) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent(); // input
			// comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return connection;
	}

	public UIData getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(UIData dataGrid) {
		this.dataGrid = dataGrid;
	}

	public List<PT_AGENT> getDataList() {
		return dataList;
	}

	public void setDataList(List<PT_AGENT> dataList) {
		this.dataList = dataList;
	}

	/*
	 * public String prepareAgentDetails() { dataList=new
	 * PILP020_DELEGATE().agentDetails(getPT_AGENT_BEAN()); return ""; }
	 */
	public String showAgentDetails() {
		String returnString = null;
		try {
			getErrorMap().clear();
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			String agentCode = request.getParameter("agentCode");
			PILQ016_COMPOSITE_ACTION compositeAction = new PILQ016_COMPOSITE_ACTION();
			compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().setRenderBackButton(true);
			compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN()
					.setABGT_AGENT_CODE(agentCode);
			compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN()
					.setUI_M_ABGT_FM_DT(PT_AGENT_BEAN.getUI_M_FM_DT());
			compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN()
					.setUI_M_ABGT_TO_DT(PT_AGENT_BEAN.getUI_M_TO_DT());
			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("PILQ016_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPS_AGENT_MON_BUDGET_ACTION_BEAN().queryAction();
			returnString = "pilq016QueryScreen";
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
		return returnString;
	}

	public void WHEN_BUTTON_PRESSED_M_BUT_PROCESS(PT_AGENT PT_AGENT_BEAN) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_DUMMY_X = null;
		Date M_START_MON;
		Date M_END_MON;

		try {
			connection = CommonUtils.getConnection();

			String C1 = "SELECT 'X' FROM PS_AGENT_MON_BUDGET WHERE AMB_FREEZE_FLAG='Y' "
					+ "AND (AMB_FM_DT BETWEEN ? "
					+ " AND ?  OR AMB_TO_DT BETWEEN ? "
					+ "AND ?) AND AMB_AGENT_CODE BETWEEN " + "? AND ?";

			String C2 = "SELECT TO_DATE('01/'|| TO_CHAR(?,'MM/RRRR'),'DD/MM/RRRR'),"
					+ "TO_DATE('01/'|| TO_CHAR(?,'MM/RRRR'),'DD/MM/RRRR') FROM DUAL";

			Object[] c1values = { PT_AGENT_BEAN.getUI_M_FM_DT(),
					PT_AGENT_BEAN.getUI_M_TO_DT(),
					PT_AGENT_BEAN.getUI_M_FM_DT(),
					PT_AGENT_BEAN.getUI_M_TO_DT(),
					PT_AGENT_BEAN.getUI_M_AGENT_FM(),
					PT_AGENT_BEAN.getUI_M_AGENT_TO() };
			resultSet1 = handler.executeSelectStatement(C1, connection,
					c1values);

			if (resultSet1.next()) {
				M_DUMMY_X = resultSet1.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60303"));

				// STD_MESSAGE_ROUTINE(60303,:CTRL.M_LANG_CODE);
			}

			Object[] c2values = { PT_AGENT_BEAN.getUI_M_FM_DT(),
					PT_AGENT_BEAN.getUI_M_TO_DT() };
			resultSet2 = handler.executeSelectStatement(C2, connection,
					c2values);
			if (resultSet2.next()) {
				M_START_MON = resultSet2.getDate(1);
				M_END_MON = resultSet2.getDate(2);
			}

			if (MONTHS_BETWEEN(getM_START_MON(), getM_END_MON()) != 0) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Date should lie within the same month" }));
				// STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Date should lie
				// within the same month');
			}
			if (MONTHS_BETWEEN(getM_START_MON(), PT_AGENT_BEAN.getUI_M_FM_DT()) != 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Date should be start of the month" }));
				// STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Date should be
				// start of the month');
			}
			new P9ILPK_AGENT_PRODUCTION_DAY().AGENT_PRODUCTION(PT_AGENT_BEAN
					.getUI_M_AGENCY_FM(), PT_AGENT_BEAN.getUI_M_AGENCY_TO(),
					PT_AGENT_BEAN.getUI_M_CUST_CLASS_FM(), PT_AGENT_BEAN
							.getUI_M_CUST_CLASS_TO(), PT_AGENT_BEAN
							.getUI_M_AGENT_FM(), PT_AGENT_BEAN
							.getUI_M_AGENT_TO(), PT_AGENT_BEAN.getUI_M_FM_DT(),
					PT_AGENT_BEAN.getUI_M_TO_DT());
			new P9ILPK_AGENT_PRODUCTION_DAY().CALC_AGT_MONTHLY_PERSISTENCY(
					PT_AGENT_BEAN.getUI_M_AGENT_FM(), PT_AGENT_BEAN
							.getUI_M_AGENT_TO(), PT_AGENT_BEAN.getUI_M_FM_DT(),
					PT_AGENT_BEAN.getUI_M_TO_DT(), PT_AGENT_BEAN
							.getUI_M_TO_DT());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}

	}
	
	public String processAction() {
		String message = null;
		try {
			WHEN_BUTTON_PRESSED_M_BUT_PROCESS(PT_AGENT_BEAN);
			message = Messages.getString(PELConstants.pelErrorMessagePath,
		               "3083");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("Process",
					message);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Process", e.getMessage());
		}

		return message;
	}
	
	public String monthEndProcessAction() {
		String message = null;
		try {
			COMP_MONTH_PROCESS();
			message = Messages.getString(PELConstants.pelErrorMessagePath,
		               "91332");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("Process",
					message);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Process", e.getMessage());
		}

		return message;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CLASS_FM_DESC() {
		return COMP_UI_M_CUST_CLASS_FM_DESC;
	}

	public void setCOMP_UI_M_CUST_CLASS_FM_DESC(
			HtmlInputText comp_ui_m_cust_class_fm_desc) {
		COMP_UI_M_CUST_CLASS_FM_DESC = comp_ui_m_cust_class_fm_desc;
	}

	public HtmlInputText getCOMP_CCLAS_CLASS_DESC() {
		return COMP_CCLAS_CLASS_DESC;
	}

	public void setCOMP_CCLAS_CLASS_DESC(HtmlInputText comp_cclas_class_desc) {
		COMP_CCLAS_CLASS_DESC = comp_cclas_class_desc;
	}

	public HtmlInputText getCOMP_CCLAS_CLASS_DESC_TO() {
		return COMP_CCLAS_CLASS_DESC_TO;
	}

	public void setCOMP_CCLAS_CLASS_DESC_TO(HtmlInputText comp_cclas_class_desc_to) {
		COMP_CCLAS_CLASS_DESC_TO = comp_cclas_class_desc_to;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME(HtmlInputText comp_cust_name) {
		COMP_CUST_NAME = comp_cust_name;
	}
	

}
