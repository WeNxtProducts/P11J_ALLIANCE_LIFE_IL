package com.iii.pel.forms.PT099_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

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
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_AGENT_TRAN_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_ATH_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_ATH_POL_NO;

	private HtmlOutputLabel COMP_ATH_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ATH_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ATH_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATH_AGENT_NAME;

	private HtmlOutputLabel COMP_ATH_DATE_LABEL;

	private HtmlCalendar COMP_ATH_DATE;

	private HtmlOutputLabel COMP_ATH_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_ATH_EFF_FM_DT;

	private HtmlOutputLabel COMP_ATH_N_AGENT_LABEL;

	private HtmlInputText COMP_ATH_N_AGENT;

	private HtmlOutputLabel COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATH_NEW_AGENT_NAME;

	private HtmlOutputLabel COMP_ATH_PRODN_TRANSFER_YN_LABEL;

	private HtmlSelectOneMenu COMP_ATH_PRODN_TRANSFER_YN;

	private HtmlCommandButton COMP_UI_M_LOV_ATH_POL_NO;

	private HtmlCommandButton COMP_UI_M_LOV_NEW_AGENT;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private PT_AGENT_TRAN_HDR PT_AGENT_TRAN_HDR_BEAN;

	public PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction;

	private boolean approveWithoutReversal;

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form
	// flow proper- 2
	private HtmlOutputText COMP_UI_M_APPRV_STATUS;
	private String UI_M_APPRV_STATUS;
	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow
	// proper- 2 ]

	CRUDHandler handler = new CRUDHandler();
	private HtmlCommandButton test;

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form
	// flow proper- 3
	public HtmlOutputText getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputText comp_ui_m_apprv_status) {
		COMP_UI_M_APPRV_STATUS = comp_ui_m_apprv_status;
	}

	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}

	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow
	// proper- 3 ]

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public PT_AGENT_TRAN_HDR_ACTION() {
		PT_AGENT_TRAN_HDR_BEAN = new PT_AGENT_TRAN_HDR();

		// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the
		// form flow proper- 4
		// Instanciate all components
		instantiateAllComponents();

		// Setting default value of status
		UI_M_APPRV_STATUS = Messages.getString("messageProperties_PT099_A",
				"PT099_A$PT_AGENT_TRAN_HDR$statusnotapproved");
		// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form
		// flow proper- 4 ]

		// Call when Create record
		this.whenCreateRecord();
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_POL_NO_LABEL() {
		return COMP_UI_M_ATH_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_POL_NO() {
		return COMP_UI_M_ATH_POL_NO;
	}

	public void setCOMP_UI_M_ATH_POL_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_POL_NO_LABEL) {
		this.COMP_UI_M_ATH_POL_NO_LABEL = COMP_UI_M_ATH_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_ATH_POL_NO(HtmlInputText COMP_UI_M_ATH_POL_NO) {
		this.COMP_UI_M_ATH_POL_NO = COMP_UI_M_ATH_POL_NO;
	}

	public HtmlOutputLabel getCOMP_ATH_AGENT_CODE_LABEL() {
		return COMP_ATH_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_AGENT_CODE() {
		return COMP_ATH_AGENT_CODE;
	}

	public void setCOMP_ATH_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATH_AGENT_CODE_LABEL) {
		this.COMP_ATH_AGENT_CODE_LABEL = COMP_ATH_AGENT_CODE_LABEL;
	}

	public void setCOMP_ATH_AGENT_CODE(HtmlInputText COMP_ATH_AGENT_CODE) {
		this.COMP_ATH_AGENT_CODE = COMP_ATH_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_AGENT_NAME_LABEL() {
		return COMP_UI_M_ATH_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_AGENT_NAME() {
		return COMP_UI_M_ATH_AGENT_NAME;
	}

	public void setCOMP_UI_M_ATH_AGENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ATH_AGENT_NAME_LABEL = COMP_UI_M_ATH_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATH_AGENT_NAME(
			HtmlInputText COMP_UI_M_ATH_AGENT_NAME) {
		this.COMP_UI_M_ATH_AGENT_NAME = COMP_UI_M_ATH_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_ATH_DATE_LABEL() {
		return COMP_ATH_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_DATE() {
		return COMP_ATH_DATE;
	}

	public void setCOMP_ATH_DATE_LABEL(HtmlOutputLabel COMP_ATH_DATE_LABEL) {
		this.COMP_ATH_DATE_LABEL = COMP_ATH_DATE_LABEL;
	}

	public void setCOMP_ATH_DATE(HtmlCalendar COMP_ATH_DATE) {
		this.COMP_ATH_DATE = COMP_ATH_DATE;
	}

	public HtmlOutputLabel getCOMP_ATH_EFF_FM_DT_LABEL() {
		return COMP_ATH_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_EFF_FM_DT() {
		return COMP_ATH_EFF_FM_DT;
	}

	public void setCOMP_ATH_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_ATH_EFF_FM_DT_LABEL) {
		this.COMP_ATH_EFF_FM_DT_LABEL = COMP_ATH_EFF_FM_DT_LABEL;
	}

	public void setCOMP_ATH_EFF_FM_DT(HtmlCalendar COMP_ATH_EFF_FM_DT) {
		this.COMP_ATH_EFF_FM_DT = COMP_ATH_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ATH_N_AGENT_LABEL() {
		return COMP_ATH_N_AGENT_LABEL;
	}

	public HtmlInputText getCOMP_ATH_N_AGENT() {
		return COMP_ATH_N_AGENT;
	}

	public void setCOMP_ATH_N_AGENT_LABEL(HtmlOutputLabel COMP_ATH_N_AGENT_LABEL) {
		this.COMP_ATH_N_AGENT_LABEL = COMP_ATH_N_AGENT_LABEL;
	}

	public void setCOMP_ATH_N_AGENT(HtmlInputText COMP_ATH_N_AGENT) {
		this.COMP_ATH_N_AGENT = COMP_ATH_N_AGENT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_NEW_AGENT_NAME_LABEL() {
		return COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_NEW_AGENT_NAME() {
		return COMP_UI_M_ATH_NEW_AGENT_NAME;
	}

	public void setCOMP_UI_M_ATH_NEW_AGENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL = COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATH_NEW_AGENT_NAME(
			HtmlInputText COMP_UI_M_ATH_NEW_AGENT_NAME) {
		this.COMP_UI_M_ATH_NEW_AGENT_NAME = COMP_UI_M_ATH_NEW_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_ATH_PRODN_TRANSFER_YN_LABEL() {
		return COMP_ATH_PRODN_TRANSFER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ATH_PRODN_TRANSFER_YN() {
		return COMP_ATH_PRODN_TRANSFER_YN;
	}

	public void setCOMP_ATH_PRODN_TRANSFER_YN_LABEL(
			HtmlOutputLabel COMP_ATH_PRODN_TRANSFER_YN_LABEL) {
		this.COMP_ATH_PRODN_TRANSFER_YN_LABEL = COMP_ATH_PRODN_TRANSFER_YN_LABEL;
	}

	public void setCOMP_ATH_PRODN_TRANSFER_YN(
			HtmlSelectOneMenu COMP_ATH_PRODN_TRANSFER_YN) {
		this.COMP_ATH_PRODN_TRANSFER_YN = COMP_ATH_PRODN_TRANSFER_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_ATH_POL_NO() {
		return COMP_UI_M_LOV_ATH_POL_NO;
	}

	public void setCOMP_UI_M_LOV_ATH_POL_NO(
			HtmlCommandButton COMP_UI_M_LOV_ATH_POL_NO) {
		this.COMP_UI_M_LOV_ATH_POL_NO = COMP_UI_M_LOV_ATH_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_NEW_AGENT() {
		return COMP_UI_M_LOV_NEW_AGENT;
	}

	public void setCOMP_UI_M_LOV_NEW_AGENT(
			HtmlCommandButton COMP_UI_M_LOV_NEW_AGENT) {
		this.COMP_UI_M_LOV_NEW_AGENT = COMP_UI_M_LOV_NEW_AGENT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public PT_AGENT_TRAN_HDR getPT_AGENT_TRAN_HDR_BEAN() {
		return PT_AGENT_TRAN_HDR_BEAN;
	}

	public void setPT_AGENT_TRAN_HDR_BEAN(
			PT_AGENT_TRAN_HDR PT_AGENT_TRAN_HDR_BEAN) {
		this.PT_AGENT_TRAN_HDR_BEAN = PT_AGENT_TRAN_HDR_BEAN;
	}

	private List<String> POLYCODELOV;

	private List<String> AGENTCODELOV;

	public List POLYCODESuggestionBox(Object obj) throws Exception {
		/*
		 * Get the query and execute it. Iterate over the resultset and create a
		 * object "Suggest" Insert the Queried columns into the object and
		 * finally insert this object into List.
		 * 
		 */
		String divisionCode = (String) obj;
		POLYCODELOV = preparePolyCodeList(getConnection(), divisionCode,
				POLYCODELOV);
		System.out.println("Entered String  Is Thissssss= " + obj.toString());
		return POLYCODELOV;
	}

	public List preparePolyCodeList(Connection connection, String divisioncode,
			List divisionlist) {
		String query = null;
		if ("*".equals(divisioncode)) {
			// query="SELECT POL_NO FROM PT_IL_POLICY WHERE POL_DS_TYPE = '2'AND
			// POL_APPRV_STATUS = 'A' AND POL_STATUS='A' AND ROWNUM<15 ORDER BY
			// 1 ASC";
			query = "SELECT POL_NO"
					+ " FROM   PT_IL_POLICY"
					+ " WHERE  POL_DS_TYPE = '2'"
					+ " AND    POL_APPRV_STATUS = 'A'"
					+ " AND    POL_STATUS='A'"
					+ " AND  EXISTS (SELECT 1 FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = POL_SYS_ID) AND ROWNUM<15 ORDER BY 1 ASC";
		} else {
			// query="SELECT POL_NO FROM PT_IL_POLICY WHERE POL_DS_TYPE = '2'AND
			// POL_APPRV_STATUS = 'A' AND POL_STATUS='A' AND ROWNUM<15 AND
			// POL_NO LIKE '"+divisioncode+"%' ORDER BY 1 ASC";
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
			 * 
			 * query = "SELECT POL_NO"
					+ " FROM   PT_IL_POLICY"
					+ " WHERE  POL_DS_TYPE = '2'"
					+ " AND    POL_APPRV_STATUS = 'A'"
					+ " AND    POL_STATUS='A'"
					+ " AND  EXISTS (SELECT 1 FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = POL_SYS_ID) AND ROWNUM<15 AND POL_NO LIKE '"
					+ divisioncode + "%' ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
			query = "SELECT POL_NO"
					+ " FROM   PT_IL_POLICY"
					+ " WHERE  POL_DS_TYPE = '2'"
					+ " AND    POL_APPRV_STATUS = 'A'"
					+ " AND    POL_STATUS='A'"
					+ " AND  EXISTS (SELECT 1 FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = POL_SYS_ID) AND ROWNUM<15 AND UPPER(POL_NO) LIKE UPPER('"
					+ divisioncode + "%') ORDER BY 1 ASC";
			//end
		}
		divisionlist = poly_code_Lov(connection, query);
		return divisionlist;
	}

	public List poly_code_Lov(Connection connection, String query) {

		List polyCodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;

		try {
			System.out.println("Connection object is" + connection);
			System.out.println("Query String" + query);

			rs = handler.executeSelectStatement(query, connection);
			while (rs.next()) {
				PT_AGENT_TRAN_HDR pt_hdr_inst = new PT_AGENT_TRAN_HDR();
				String code = rs.getString(1);
				pt_hdr_inst.setLOV_POLY_CODE(code);

				polyCodeList.add(pt_hdr_inst);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return polyCodeList;
	}

	public List AGENTCODESuggestionBox(Object obj) throws Exception {
		/*
		 * Get the query and execute it. Iterate over the resultset and create a
		 * object "Suggest" Insert the Queried columns into the object and
		 * finally insert this object into List.
		 * 
		 */
		String divisionCode = (String) obj;
		AGENTCODELOV = prepareAgentCodeList(getConnection(), divisionCode,
				AGENTCODELOV);
		System.out.println("Entered String  Is Thissssss= " + obj.toString());
		return AGENTCODELOV;
	}

	public List prepareAgentCodeList(Connection connection,
			String divisioncode, List divisionlist) {
		String query = "";

		if ("*".equals(divisioncode)) {
			query = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER"
					+ " WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM"
					+ " WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE)IN ('001','002')"
					+ " AND PS_CODE ='IL_BROKER' AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N'"
					+ " AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN (SELECT CDIV_CUST_CODE"
					+ " FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL ('HO', CDIV_DIVN_CODE))) AND ROWNUM <20 ORDER BY 1 ASC";
		} else {
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
			 * 
			 * query = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER"
					+ " WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM"
					+ " WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE)IN ('001','002')"
					+ " AND PS_CODE ='IL_BROKER' AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N'"
					+ " AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN (SELECT CDIV_CUST_CODE"
					+ " FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL ('HO', CDIV_DIVN_CODE))) AND ROWNUM <20  AND CUST_CODE LIKE '"
					+ divisioncode + "%' ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
			query = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER"
					+ " WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM"
					+ " WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE)IN ('001','002')"
					+ " AND PS_CODE ='IL_BROKER' AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N'"
					+ " AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN (SELECT CDIV_CUST_CODE"
					+ " FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL ('HO', CDIV_DIVN_CODE))) AND ROWNUM <20  AND UPPER(CUST_CODE) LIKE UPPER('"
					+ divisioncode + "%') ORDER BY 1 ASC";
			/*end*/
		}

		System.out.println("PT_IL_BROK_ADV_HDR_LOVUtils.prepareCustCodeList()"
				+ query);
		divisionlist = agent_code_Lov(connection, query);
		return divisionlist;
	}

	public List agent_code_Lov(Connection connection, String query) {

		List agentCodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		try {
			System.out.println("Connection object is" + connection);
			System.out.println("Query String" + query);

			rs = handler.executeSelectStatement(query, connection);
			while (rs.next()) {
				PT_AGENT_TRAN_HDR pt_hdr_inst = new PT_AGENT_TRAN_HDR();
				String code = rs.getString(1);
				pt_hdr_inst.setLOV_AGENT_CODE(code);
				String desc = rs.getString(2);
				pt_hdr_inst.setLOV_AGENT_DESC(desc);
				agentCodeList.add(pt_hdr_inst);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return agentCodeList;
	}

	public void AGENTCODE_DESCuggestionBox(ActionEvent event) throws Exception {
		/*
		 * Get the query and execute it. Iterate over the resultset and create a
		 * object "Suggest" Insert the Queried columns into the object and
		 * finally insert this object into List.
		 * 
		 */
		String agentCode = getCOMP_ATH_N_AGENT().getSubmittedValue().toString();
		String AGENTCODELOVDEC = prepareAgentCodeDescList(getConnection(),
				agentCode);
		System.out.println("Entered String  Is CODES= " + AGENTCODELOVDEC);
		if (AGENTCODELOVDEC != null) {
			getCOMP_UI_M_ATH_NEW_AGENT_NAME()
					.setSubmittedValue(AGENTCODELOVDEC);
		} else {
			getCOMP_UI_M_ATH_NEW_AGENT_NAME().setSubmittedValue(null);
		}
		// PT_IL_BROK_ADV_HDR_BEAN.setBAH_CUST_CODE_DESC(CUSTCODELOVDEC);

	}

	public String prepareAgentCodeDescList(Connection connection,
			String divisioncode) {
		String query;

		query = " SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=" + "'"
				+ divisioncode + "'";
		System.out.println("PT_IL_BROK_ADV_HDR_LOVUtils.prepareCustCodeList()"
				+ query);

		String custCodeDesc = agent_code_desc_Lov(connection, query);

		return custCodeDesc;
	}

	public String agent_code_desc_Lov(Connection connection, String query) {

		String description = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		try {
			System.out.println("Connection object is" + connection);
			System.out.println("Query String" + query);
			rs = handler.executeSelectStatement(query, connection);
			while (rs.next()) {
				description = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return description;
	}

	private List<SelectItem> APAT_FLAG_LIST = new ArrayList<SelectItem>();

	public List<SelectItem> getAPAT_FLAG_LIST() throws Exception {

		if (APAT_FLAG_LIST.size() == 0) {
			APAT_FLAG_LIST.clear();
			conn = getConnection();
			APAT_FLAG_LIST = ListItemUtil.getDropDownListValue(conn, "PT099_A",
					"PT_AGENT_TRAN_HDR",
					"PT_AGENT_TRAN_HDR.ATH_PRODN_TRANSFER_YN", "YESNO");
		}
		return APAT_FLAG_LIST;

	}

	public void setAPAT_FLAG_LIST(List<SelectItem> apat_flag_list) {
		APAT_FLAG_LIST = apat_flag_list;
	}

	Connection conn;
	Map<String, Object> session = null;
	FacesContext ctx = FacesContext.getCurrentInstance();

	public Connection getConnection() {
		Connection con = null;

		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				if (PT_AGENT_TRAN_HDR_BEAN.getROWID() != null) {
					executeQuery(PT_AGENT_TRAN_HDR_BEAN);
					POST_QUERY();
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/*
	 * public void preForm() throws Exception { ArrayList<OracleParameter> list
	 * =null;
	 * 
	 * try {
	 * 
	 * System.out.println("PT_AGENT_TRAN_HDR_ACTION.preForm()"); FacesContext fc =
	 * FacesContext.getCurrentInstance(); session =
	 * fc.getExternalContext().getSessionMap();
	 * session.put("GLOBAL.M_PRIVILEGE", "YYY"); session.put("GLOBAL.M_FAILURE",
	 * "FALSE"); session.put("GLOBAL.M_USER_ID", "LIFEALL");
	 * session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM
	 * NAME"); session.put("GLOBAL.M_LANG_CODE", "ENG");
	 * session.put("GLOBAL.M_DFLT_VALUES", "00101 01");
	 * session.put("GLOBAL.M_PARA_1", " ");
	 * session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
	 *  // values should take from
	 * GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) //
	 * Developing purpose hard coded it. session.put("GLOBAL.M_MODULE_NAME",
	 * "PT099_A");
	 * System.out.println("PT_AGENT_TRAN_HDR_ACTION.preForm()\n"+fc.getExternalContext().getSessionMap());
	 * 
	 * 
	 * STD_PRE_FORM();
	 * if(Integer.parseInt(((String)session.get("GLOBAL.M_FOR_LANG_CODE")).substring(4,5))==
	 * 1 ){
	 * System.out.println("PT_AGENT_TRAN_HDR_ACTION.preForm()NULLLLLLLLLLLLLLLLL"); //
	 * NULL ; } ControlBean ctrlbean = CommonUtils.getControlBean(); String
	 * M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new
	 * Date(); System.out.println("PT_AGENT_TRAN_HDR_ACTION.preForm()---->>
	 * "+M_TITLE); //M_TITLE=:CTRL.M_USER_ID+" "+:CTRL.M_SCR_NAME+"
	 * "+ConvertFunctions.to_char(new
	 * java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY"); //
	 * SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE); //
	 * gridList();
	 * 
	 * 
	 */

	/*
	 * void STD_PRE_FORM(){
	 *  // P_GET_LOGO; //
	 * COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
	 * 
	 * //createCtrlBean(); ControlBean ctrlBean = CommonUtils.getControlBean();
	 * 
	 * 
	 * System.out.println("PT_AGENT_TRAN_HDR_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
	 * //ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
	 * //ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID")); //
	 * bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
	 * ctrlBean.setM_PROG_NAME("PM102_A_TISB"); //
	 * COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
	 * System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.STD_PRE_FORM(------)"
	 * +(String)session.get("GLOBAL.M_NAME"));
	 * ctrlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30,
	 * 42)); // COPY('10','SYSTEM.MESSAGE_LEVEL');
	 * session.put("GLOBAL.M_FAILURE", "FALSE");
	 * ctrlBean.setM_GOFLD_NAME("NULL");
	 * //ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
	 * //ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
	 * //ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
	 * System.out.println("PT_IL_BROK_ADV_HDR_ACTION.STD_PRE_FORM(!!!! )
	 * "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
	 * //ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));
	 * 
	 * //putCtrlBean(ctrlBean);
	 * System.out.println("PT_AGENT_TRAN_HDR_ACTION.STD_PRE_FORM()--- \n
	 * "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	 *  }
	 */

	public ArrayList<OracleParameter> prepareOracleParam(
			Map<String, Object> session) {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		System.out
				.println("PT_AGENT_TRAN_HDR_ACTION.prepareOracleParam()\n------------! \n"
						+ session.toString());
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String) session.get("GLOBAL.M_LANG_CODE"));
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				(String) session.get("GLOBAL.M_FOR_LANG_CODE"));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				(String) session.get("GLOBAL.M_USER_ID"));
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				CommonUtils.getControlBean().getM_COMP_CODE());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(3, 6));
		System.out
				.println("PT_AGENT_TRAN_HDR_ACTION.prepareOracleParam(.....) "
						+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(9, 11));
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				CommonUtils.getControlBean().getM_BASE_CURR());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN", "2");
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				"PT099_A");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		return paramList;
	}

	public void Press_Save() {

		System.out.println("PT_AGENT_TRAN_HDR_ACTION.Press_Save()"
				+ getPT_AGENT_TRAN_HDR_BEAN().getATH_AGENT_CODE());
		String message = null;
		try {
			Connection conn = getConnection();
			if (PT_AGENT_TRAN_HDR_BEAN.getROWID() == null) {
				pre_insert();
				PT_AGENT_TRAN_HDR_BEAN.setATH_CR_DT(getSysDate());
				System.out.println("M_USER_ID :"
						+ CommonUtils.getControlBean().getM_USER_ID());
				PT_AGENT_TRAN_HDR_BEAN.setATH_CR_UID(CommonUtils
						.getControlBean().getM_USER_ID());
				message = Messages.getString("messageProperties",
						"errorPanel$message$save");
			} else {
				PT_AGENT_TRAN_HDR_BEAN.setATH_UPD_DT(getSysDate());
				PT_AGENT_TRAN_HDR_BEAN.setATH_UPD_UID(CommonUtils
						.getControlBean().getM_USER_ID());
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
			}
			handler.executeInsert(PT_AGENT_TRAN_HDR_BEAN, conn);
			if (message != null) {
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}
			System.out
					.println("PT_AGENT_TRAN_HDR_ACTION.when_PressSave_Button()0-43-043-043-043-043");
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void whenCreateRecord() {
		getPT_AGENT_TRAN_HDR_BEAN().setATH_DATE(getSysDate());
		getPT_AGENT_TRAN_HDR_BEAN().setATH_PRODN_TRANSFER_YN("N");
		getCOMP_ATH_DATE().setDisabled(true);
	}

	public void AthPolNowhenValidateItem(FacesContext context,
			UIComponent component, Object value) {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		String brokerCode = null;
		String name = null;
		Date efft_date=null;
		String query1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? AND POL_DS_TYPE = '2' AND POL_APPRV_STATUS = 'A' AND POL_STATUS='A'";

		String query2 = "SELECT  POBH_BROKER_CODE FROM    PT_IL_POL_BROKER_HEAD WHERE   POBH_POL_SYS_ID = ? "
				+ " AND  POBH_AGENT_LEVEL = (SELECT MAX(POBH_AGENT_LEVEL) FROM   PT_IL_POL_BROKER_HEAD "
				+ " WHERE  POBH_POL_SYS_ID = ?)";
		String query3 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE  CUST_CODE = ? AND    CUST_CLASS IN (SELECT CCLAS_CODE "
				+ " FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002')  AND    CUST_FRZ_FLAG = 'N' ";
		String query4="SELECT MIN(PC_SCHD_PYMT_DT) PC_SCHD_PYMT_DT FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N') = 'N'";
		Connection con = getConnection();
		Double polSysId = null;
		String policyNo = (String) value;
		PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_POL_NO(policyNo);
		System.out.println("Pol No :"
				+ PT_AGENT_TRAN_HDR_BEAN.getUI_M_ATH_POL_NO());

		try {
			if (policyNo != null) {
				rs1 = getHandler().executeSelectStatement(
						query1,
						con,
						new Object[] { PT_AGENT_TRAN_HDR_BEAN
								.getUI_M_ATH_POL_NO() });

				if (rs1.next()) {
					polSysId = rs1.getDouble("POL_SYS_ID");
					System.out
							.println("PT_AGENT_TRAN_HDR_ACTION.AthPolNowhenValidateItem()==POLSYSID==["
									+ polSysId + "]");
					PT_AGENT_TRAN_HDR_BEAN.setATH_POL_SYS_ID(polSysId);
				} else {
					// getErrorMap().put("current",Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
					// "71081").getSummary() );
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71081"));
				}

				// Fetch Agent description
				rs2 = getHandler().executeSelectStatement(
						query2,
						con,
						new Object[] {
								PT_AGENT_TRAN_HDR_BEAN.getATH_POL_SYS_ID(),
								PT_AGENT_TRAN_HDR_BEAN.getATH_POL_SYS_ID() });
				if (rs2.next()) {
					brokerCode = rs2.getString("POBH_BROKER_CODE");
					PT_AGENT_TRAN_HDR_BEAN.setATH_AGENT_CODE(brokerCode);
					rs3 = getHandler().executeSelectStatement(query3, con,
							new Object[] { brokerCode });
					if (rs3.next()) {
						name = rs3.getString("CUST_NAME");
						PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_AGENT_NAME(name);
					}
				}
				System.out.println("****Pol_sys_id***agent_terminal" +PT_AGENT_TRAN_HDR_BEAN.getATH_POL_SYS_ID());
				rs4 = getHandler().executeSelectStatement(query4,con,new Object[] {PT_AGENT_TRAN_HDR_BEAN.getATH_POL_SYS_ID()});
				if (rs4.next()) {
					efft_date = rs4.getDate("PC_SCHD_PYMT_DT");
					PT_AGENT_TRAN_HDR_BEAN.setATH_EFF_FM_DT(efft_date);
					COMP_ATH_EFF_FM_DT.resetValue();
					System.out.println("*efft_date****" +PT_AGENT_TRAN_HDR_BEAN.getATH_EFF_FM_DT());
				}
				
				
			}

			if (policyNo != null) {
				getCOMP_ATH_AGENT_CODE().resetValue();
				getCOMP_UI_M_ATH_AGENT_NAME().resetValue();

			}
			whenCreateRecord();
			getCOMP_ATH_DATE().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(rs3);
			} catch (Exception e) {
			}
		}
	}

	public void pre_insert() throws SQLException, Exception {
		Connection con = getConnection();
		String query1 = "SELECT PAG_ATH_SYS_ID.NEXTVAL FROM DUAL";
		String query2 = "SELECT CUST_AGENT_RANK_CODE FROM PM_CUSTOMER WHERE CUST_CODE=?";
		// P_CUSTCODE
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		double sysId = 0;
		ControlBean ctrBean = CommonUtils.getControlBean();
		java.util.Date sysdate = null;

		try {
			sysdate = getSysDate();
			getPT_AGENT_TRAN_HDR_BEAN().setATH_TYPE("S");
			getPT_AGENT_TRAN_HDR_BEAN().setATH_CR_DT(sysdate);
			getPT_AGENT_TRAN_HDR_BEAN().setATH_CR_UID(ctrBean.getM_USER_ID());
			getPT_AGENT_TRAN_HDR_BEAN().setATH_UPD_DT(sysdate);
			getPT_AGENT_TRAN_HDR_BEAN().setATH_UPD_UID(ctrBean.getM_USER_ID());

			rs2 = getHandler().executeSelectStatement(
					query2,
					con,
					new Object[] { getPT_AGENT_TRAN_HDR_BEAN()
							.getATH_AGENT_CODE() });
			if (rs2.next()) {
				getPT_AGENT_TRAN_HDR_BEAN().setATH_AGENT_RANK_CODE(
						rs2.getString("CUST_AGENT_RANK_CODE"));
			}

			rs3 = getHandler().executeSelectStatement(
					query2,
					con,
					new Object[] { getPT_AGENT_TRAN_HDR_BEAN()
							.getATH_NEW_AGENT_CODE() });
			if (rs2.next()) {
				getPT_AGENT_TRAN_HDR_BEAN().setATH_AGENT_NEW_RANK_CODE(
						rs2.getString("CUST_AGENT_RANK_CODE"));
			}

			rs1 = getHandler().executeSelectStatement(query1, con);
			while (rs1.next()) {
				sysId = rs1.getDouble(1);
				System.out.println("sys id :" + sysId);
				PT_AGENT_TRAN_HDR_BEAN.setATH_SYS_ID(sysId);
				System.out.println("PT_AGENT_TRAN_HDR_BEAN.setATH_SYS_ID :"
						+ PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception exc) {
			}
			;
			try {
				CommonUtils.closeCursor(rs2);
			} catch (Exception exc) {
			}
			;
			try {
				CommonUtils.closeCursor(rs3);
			} catch (Exception exc) {
			}
			;
		}
	}

	public void Press_Delete() {
		try {

			Connection conn = getConnection();
			String deleteQuery = " DELETE FROM PT_AGENT_PYMT_REVERSAL_DTLS P WHERE P.APRD_ATH_SYS_ID = ?";
			Object[] object = { PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID() };
			handler.executeDeleteStatement(deleteQuery, conn, object);// execute
																		// related
																		// data
																		// from
																		// PT_AGENT_PYMT_REVERSAL_DTLS
			handler.executeDelete(getPT_AGENT_TRAN_HDR_BEAN(), conn);
			System.out
					.println("PT_AGENT_TRAN_HDR_ACTION.when_PressSave_Button()0-43-043-043-043-043");
			new CommonUtils().doComitt();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/*
	 * public void When_Press_Approve()throws SQLException,Exception { conn =
	 * getConnection(); try { String M_DUMMY_X=null; String
	 *//** METADATA NOT FOUND ******** */
	/*
	 * M_DSRC_SYS_ID=null; String
	 *//** METADATA NOT FOUND ******** */
	/*
	 * M_REP_NAME=null; String
	 *//** METADATA NOT FOUND ******** */
	/*
	 * M_PC_DESC=null; String
	 *//** METADATA NOT FOUND ******** */
	/*
	 * M_PC_BL_DESC=null; String
	 *//** METADATA NOT FOUND ******** */
	/*
	 * M_CUST_PREFERRED_LANG=null; String M_PS_CODE=null; String sql_C4="SELECT
	 * PC_DESC, PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_REMIN_RPT' AND
	 * PC_CODE IN ( SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE =
	 * 'AGT_LETTER' AND PS_CODE = '"+M_PS_CODE+"' ) "; ResultSet vembu_C4=null;
	 * Statement
	 * stmt_C4=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 * String sql_C5="SELECT CUST_PREFERRED_LANG FROM PM_CUSTOMER WHERE
	 * CUST_CODE = :PT_AGENT_TRAN_HDR.ATH_AGENT_CODE "; ResultSet vembu_C5=null;
	 * Statement
	 * stmt_C5=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 * String sql_C1="SELECT 'X' FROM PT_AGENT_PYMT_REVERSAL_DTLS WHERE
	 * APRD_GEN_FLAG = 'Y' AND APRD_POL_SYS_ID = "+
	 * PT_AGENT_TRAN_HDR_BEAN.getATH_POL_SYS_ID()+" AND ROWID =
	 * PT_AGENT_PYMT_REVERSAL_DTLS.ROWID "; ResultSet vembu_C1=null; Statement
	 * stmt_C1=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"BUSY");
	 * if(:SYSTEM.FORM_STATUS=="CHANGED") {
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(80224,:CTRL.M_LANG_CODE);
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * throw new FORM_TRIGGER_FAILURE(); }
	 * vembu_C1=stmt_C1.executeQuery(sql_C1); if(vembu_C1.next()) {
	 * M_DUMMY_X=vembu_C1.getString(1); } if(vembu_C1.isAfterLast() ||
	 * vembu_C1.isBeforeFirst()) {
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91326,:CTRL.M_LANG_CODE);
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT"); }
	 * vembu_C1.close(); try{
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"BUSY");
	 * p9ilpk_pol_serv_rights.p9ilpk_pol_serv_rights.upd_pol_selling_agent(:PT_AGENT_TRAN_HDR.ATH_SYS_ID,:GLOBAL.M_PARA_2); }
	 * catch(SQLException se){ DISP_ALERT.DISP_ALERT(se.getMessage());
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * throw new FORM_TRIGGER_FAILURE(); } try{
	 * p9ilpk_pol_serv_rights.p9ilpk_pol_serv_rights.gen_agent_reversal_entries(:PT_AGENT_TRAN_HDR.ATH_SYS_ID); }
	 * catch(SQLException se){ DISP_ALERT.DISP_ALERT(se.getMessage());
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * throw new FORM_TRIGGER_FAILURE(); }
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91071,:CTRL.M_LANG_CODE);
	 * COPY.COPY("0","SYSTEM.MESSAGE_LEVEL"); COPY.COPY("C","CTRL.M_COMM_DEL");
	 * COMMIT_FORM.COMMIT_FORM(); COPY.COPY("","CTRL.M_COMM_DEL");
	 * COPY.COPY("","CTRL.M_COMMIT_FLAG");
	 * COPY.COPY("10","SYSTEM.MESSAGE_LEVEL");
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * :GLOBAL.M_ATH_SYS_ID=:PT_AGENT_TRAN_HDR.ATH_SYS_ID;
	 * GO_BLOCK.GO_BLOCK(GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FIRSTBLOCK));
	 * CLEAR_BLOCK.CLEAR_BLOCK(NO_VALIDATE); EXECUTE_QUERY.EXECUTE_QUERY();
	 * if(vembu_C4!=null) { vembu_C4.close(); } M_PS_CODE = "AGT_PROD";
	 * vembu_C4=stmt_C4.executeQuery(sql_C4); if(vembu_C4.next()) {
	 * M_PC_DESC=vembu_C4.getString(1); M_PC_BL_DESC=vembu_C4.getString(2); }
	 * vembu_C4.close(); if(vembu_C5!=null) { vembu_C5.close(); }
	 * vembu_C5=stmt_C5.executeQuery(sql_C5); if(vembu_C5.next()) {
	 * M_CUST_PREFERRED_LANG=vembu_C5.getString(1); } vembu_C5.close();
	 * if(MigratingFunctions.nvl(M_CUST_PREFERRED_LANG,"E")=="E") {
	 * M_REP_NAME=M_PC_DESC; } else { M_REP_NAME=M_PC_BL_DESC; }
	 * p9ilpk_agency_letters.p9ilpk_agency_letters.gen_agent_production_letter(M_DSRC_SYS_ID,M_REP_NAME,:PT_AGENT_TRAN_HDR.ATH_SYS_ID);
	 * P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,"O","AG");
	 * }catch(Exception e) { e.printStackTrace(); throw e; } finally {
	 * if(vembu_conn != null) {
	 * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
	 * 
	 */
	public String whenProcessButtonPressed() {
		String outcome = null;
		PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction = null;
		ResultSet resultSet = null;
		String query = PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_PROCESS_BUTTON_QUERY;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		System.out.println("Pol NO :"
				+ PT_AGENT_TRAN_HDR_BEAN.getUI_M_ATH_POL_NO());
		try {
			connection = CommonUtils.getConnection();
			System.out.println("Process Button Pressed getUI_M_ATH_POL_NO :"
					+ PT_AGENT_TRAN_HDR_BEAN.getUI_M_ATH_POL_NO());
			resultSet = handler
					.executeSelectStatement(query, connection,
							new Object[] { PT_AGENT_TRAN_HDR_BEAN
									.getUI_M_ATH_POL_NO() });
			if (resultSet.next()) {
				PT_AGENT_TRAN_HDR_BEAN
						.setATH_POL_SYS_ID(resultSet.getDouble(1));
				System.out.println("PT_AGENT_TRAN_HDR_BEAN.setATH_POL_SYS_ID :"
						+ resultSet.getDouble(1));
				System.out.println("ATH_SYS_ID :"
						+ PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());

				// Save current record before process
				// handler.executeInsert(getPT_AGENT_TRAN_HDR_BEAN(),
				// conn);//inserting pol sys id
				Press_Save();
				// Removing the save message from warning map, since it is
				// explicit save.
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						null);

				if (PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID() != null) {
					helperP9ILPK_POL_SERV_RIGHTS$INS_AGENT_REVERSAL_DTLS(PT_AGENT_TRAN_HDR_BEAN
							.getATH_SYS_ID().longValue()
							+ "");
				} else {
					throw new Exception("Error on header save");
				}

				// Move to the details page
				compositeAction = (PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION) new CommonUtils()
						.getMappedBeanFromSession("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION");
				compositeAction
						.getTabbedBar()
						.setTabClicked(
								PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION.PT_AGENT_PYMT_REVERSAL_DTLS);
				// Fetch the reversal details
				outcome = compositeAction.gotoPT_AGENT_PYMT_REVERSAL_DTLS();
			} else {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71081"));

			}
		} catch (ValidatorException exception) {
			getErrorMap().put(PELConstants.pelErrorMessagePath,
					exception.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception exc) {
			}
		}

		return outcome;
	}

	public String goToDetailsBlock() {

		FacesContext context = FacesContext.getCurrentInstance();
		String benefitCode = null;
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		double sysId = getPT_AGENT_TRAN_HDR_BEAN().getATH_POL_SYS_ID();
		PT_AGENT_PYMT_REVERSAL_DTLS_ACTION sessionBean = null;
		System.out
				.println("PT_AGENT_TRAN_HDR_ACTION.goToDetailsBlock()---IDDDD---["
						+ sysId + "]");
		try {
			String selectQuery = "select * from PT_AGENT_PYMT_REVERSAL_DTLS where APRD_ATH_SYS_ID ='"
					+ sysId + "'";
			List<PT_AGENT_PYMT_REVERSAL_DTLS> list = getHandler().fetch(
					selectQuery,
					"com.iii.pel.forms.PT099_A.PT_AGENT_PYMT_REVERSAL_DTLS",
					getConnection());
			for (Iterator<PT_AGENT_PYMT_REVERSAL_DTLS> i = list.iterator(); i
					.hasNext();) {
				PT_AGENT_PYMT_REVERSAL_DTLS x = i.next();
			}
			if (session
					.getAttribute("PT099_A_PT_AGENT_PYMT_REVERSAL_DTLS_ACTION") != null) {
				sessionBean = (PT_AGENT_PYMT_REVERSAL_DTLS_ACTION) session
						.getAttribute("PT099_A_PT_AGENT_PYMT_REVERSAL_DTLS_ACTION");
			} else {
				ELResolver resolver = context.getApplication().getELResolver();
				sessionBean = (PT_AGENT_PYMT_REVERSAL_DTLS_ACTION) resolver
						.getValue(context.getELContext(), null,
								"PT099_A_PT_AGENT_PYMT_REVERSAL_DTLS_ACTION");
			}
			if (sessionBean == null) {
				System.out.println("actionbean null");
			}
			sessionBean.setBeanList(list);
			PT_AGENT_PYMT_REVERSAL_DTLS PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = null;
			Iterator<PT_AGENT_PYMT_REVERSAL_DTLS> it = list.iterator();
			while (it.hasNext()) {
				PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = it.next();
				PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setRowSelected(false);
			}
			if (list.size() > 0) {
				sessionBean.setPT_AGENT_PYMT_REVERSAL_DTLS_BEAN(list.get(0));
				sessionBean.getPT_AGENT_PYMT_REVERSAL_DTLS_BEAN()
						.setRowSelected(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "AgentPaymentDetails";
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public java.util.Date getSysDate() {

		java.util.Date jDate = null;
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			String query = "select sysdate from dual";
			rs = getHandler().executeSelectStatement(query, con);
			while (rs.next()) {
				Date date = rs.getDate("SYSDATE");
				jDate = (java.util.Date) date;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jDate;
	}

	private void clearMaps() {
		getWarningMap().clear();
		getErrorMap().clear();
	}

	public ArrayList<String> helperP9ILPK_POL_SERV_RIGHTS$INS_AGENT_REVERSAL_DTLS(
			String P_ATH_SYS_ID) throws SQLException, Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_ATH_SYS_ID);
		parameterList.add(param1);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_POL_SERV_RIGHTS.INS_AGENT_REVERSAL_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public String whenApproveButonClicked() {
		clearMaps();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		String M_PC_DESC = null;
		String M_PC_BL_DESC = null;
		String M_CUST_PREFERRED_LANG = null;
		String M_REP_NAME = null;
		String M_DUMMY_X = null;
		Double M_DSRC_SYS_ID = null;
		String strSysId = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList genAgentProductionLetterList = null;
		int noOfCommTransferred = 0;
		PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction = (PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION");
		DBProcedures procedures = new DBProcedures();
		List<PT_AGENT_PYMT_REVERSAL_DTLS> reversalDtlsList = compositeAction
				.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().getBeanList();

		try {
			
			connection = CommonUtils.getConnection();
			if (reversalDtlsList != null) {
				Iterator itr = reversalDtlsList.iterator();
				while (itr.hasNext()) {
					PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls = (PT_AGENT_PYMT_REVERSAL_DTLS) itr
							.next();

					if ("Y".equals(pt_agent_pymt_reversal_dtls
							.getAPRD_GEN_FLAG())) {
						setApproveWithoutReversal(true);
					}

					resultSet3 = handler
							.executeSelectStatement(
									PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_APPROVAL_BUTTON_QUERY_3,
									connection, new Object[] {
											new Double(PT_AGENT_TRAN_HDR_BEAN
													.getATH_POL_SYS_ID())
													.longValue(),
											pt_agent_pymt_reversal_dtls
													.getROWID() });
					if (approveWithoutReversal && resultSet3.next()) {
						M_DUMMY_X = resultSet3.getString(1);
						noOfCommTransferred++;

						// Do approval
						String mGlobalPara2 = CommonUtils
								.getGlobalVariable("GLOBAL.M_PARA_2");
						System.out.println("GLobal Para 2 :" + mGlobalPara2);
						procedures
								.helperP9ILPK_POL_SERV_RIGHTS$UPD_POL_SELLING_AGENT(
										PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID()
												.longValue()
												+ "", mGlobalPara2);

						procedures
								.helperP9ILPK_POL_SERV_RIGHTS$GEN_AGENT_REVERSAL_ENTRIES(PT_AGENT_TRAN_HDR_BEAN
										.getATH_SYS_ID().longValue()
										+ "");

						CommonUtils.setGlobalObject("GLOBAL.M_ATH_SYS_ID",
								PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());

						new CommonUtils().doComitt();

						// Cursor C4
						resultSet1 = handler
								.executeSelectStatement(
										PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_APPROVAL_BUTTON_QUERY_1,
										connection, new Object[] { "AGT_PROD" });
						if (resultSet1.next()) {
							M_PC_DESC = resultSet1.getString(1);
							M_PC_BL_DESC = resultSet1.getString(2);
						}

						// Cursor C5
						resultSet2 = handler
								.executeSelectStatement(
										PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_APPROVAL_BUTTON_QUERY_2,
										connection,
										new Object[] { PT_AGENT_TRAN_HDR_BEAN
												.getATH_AGENT_CODE() });
						if (resultSet2.next()) {
							M_CUST_PREFERRED_LANG = resultSet2.getString(1);
						}
						if ("E".equals(MigratingFunctions.nvl(
								M_CUST_PREFERRED_LANG, "E"))) {
							M_REP_NAME = M_PC_DESC;
						} else {
							M_REP_NAME = M_PC_BL_DESC;
						}
						genAgentProductionLetterList = procedures
								.helperP9ILPK_AGENCY_LETTERS$GEN_AGENT_PRODUCTION_LETTER(
										"", M_REP_NAME, PT_AGENT_TRAN_HDR_BEAN
												.getATH_SYS_ID().longValue()
												+ "");
						if (genAgentProductionLetterList != null
								&& genAgentProductionLetterList.size() > 0) {
							strSysId = (String) genAgentProductionLetterList
									.get(0);
							M_DSRC_SYS_ID = strSysId == null
									|| strSysId.isEmpty() ? 0.0 : Double
									.parseDouble(strSysId);

							// TODO procedure not converted as linked to reports
							// can be taken care latter
							// P_LIFE_LETTER(M_DSRC_SYS_ID, M_REP_NAME, 'O',
							// 'AG')
						}
					}
				}
			} else {
				String mGlobalPara2 = CommonUtils
						.getGlobalVariable("GLOBAL.M_PARA_2");
				System.out.println("GLobal Para 2 :" + mGlobalPara2);
				procedures
				.helperP9ILPK_POL_SERV_RIGHTS$UPD_POL_SELLING_AGENT(
						PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID()
								.longValue()
								+ "", mGlobalPara2);

		procedures
				.helperP9ILPK_POL_SERV_RIGHTS$GEN_AGENT_REVERSAL_ENTRIES(PT_AGENT_TRAN_HDR_BEAN
						.getATH_SYS_ID().longValue()
						+ "");

		CommonUtils.setGlobalObject("GLOBAL.M_ATH_SYS_ID",
				PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());

		new CommonUtils().doComitt();
		resultSet1 = handler
				.executeSelectStatement(
						PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_APPROVAL_BUTTON_QUERY_1,
						connection, new Object[] { "AGT_PROD" });
		if (resultSet1.next()) {
			M_PC_DESC = resultSet1.getString(1);
			M_PC_BL_DESC = resultSet1.getString(2);
		}

		// Cursor C5
		resultSet2 = handler
				.executeSelectStatement(
						PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_APPROVAL_BUTTON_QUERY_2,
						connection,
						new Object[] { PT_AGENT_TRAN_HDR_BEAN
								.getATH_AGENT_CODE() });
		if (resultSet2.next()) {
			M_CUST_PREFERRED_LANG = resultSet2.getString(1);
		}
		if ("E".equals(MigratingFunctions.nvl(
				M_CUST_PREFERRED_LANG, "E"))) {
			M_REP_NAME = M_PC_DESC;
		} else {
			M_REP_NAME = M_PC_BL_DESC;
		}
		genAgentProductionLetterList = procedures
				.helperP9ILPK_AGENCY_LETTERS$GEN_AGENT_PRODUCTION_LETTER(
						"", M_REP_NAME, PT_AGENT_TRAN_HDR_BEAN
								.getATH_SYS_ID().longValue()
								+ "");
		if (genAgentProductionLetterList != null
				&& genAgentProductionLetterList.size() > 0) {
			strSysId = (String) genAgentProductionLetterList
					.get(0);
			M_DSRC_SYS_ID = strSysId == null
					|| strSysId.isEmpty() ? 0.0 : Double
					.parseDouble(strSysId);

		}
			}

			// If there is no Commission selected to transfer
			if (noOfCommTransferred == 0) {
				setApproveWithoutReversal(true);
				// throw new
				// ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,
				// "91326"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelErrorMessagePath,
								"91326"));
			} else {
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelErrorMessagePath,
								"91071"));

				// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made
				// the form flow proper- 5
				// Set all fields disabled
				compositeAction.setRecordApproved(true);

				// Set approval status
				setApprovalStatus("A");
				// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made
				// the form flow proper- 5 ]
			}
		} catch (SQLException sexc) {
			sexc.printStackTrace();
			ErrorHelpUtil
					.getErrorsforProcedureButtons(connection, FacesContext
							.getCurrentInstance(), COMP_UI_M_BUT_APPROVE,
							getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception exc) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception exc) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception exc) {
			}
		}

		return null;
	}

	public void validateErrorPanel(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		clearMaps();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateAthAgentCode(FacesContext context,
			UIComponent component, Object value) {

		String agentCode = (String) value;
		String query = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		if (agentCode != null) {
			try {
				connection = CommonUtils.getConnection();
				query = PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_ATH_AGENT_NAME;

				resultSet = handler.executeSelectStatement(query, connection,
						new Object[] { agentCode });
				if (resultSet.next()) {
					PT_AGENT_TRAN_HDR_BEAN.setATH_AGENT_CODE(agentCode);
					PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_AGENT_NAME(resultSet
							.getString(1));
				}

			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void validateAthNAgent(FacesContext context, UIComponent component,
			Object value) {

		String nathAgent = (String) value;
		String agentName = null;
		
		// Fetch new selling agent name
		agentName = fetchAgentNameForAgentCode(nathAgent);

		if (agentName != null) {
			PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_NEW_AGENT_NAME(agentName);
		} else {
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "91115",new Object[]{nathAgent}));
		}
	}

	public String fetchAgentNameForAgentCode(String agentCode) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		String query1 = null;
		String agentName = null;

		try {
			connection = CommonUtils.getConnection();
			query1 = PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_TRAN_HDR_ATH_AGENT_NAME;
			resultSet1 = handler.executeSelectStatement(query1, connection,
					new Object[] { agentCode });
			if (resultSet1.next()) {
				agentName = resultSet1.getString("CUST_NAME");
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
		}

		return agentName;
	}

	public void validateTransferYN(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String transferYN = (String) input.getSubmittedValue();
		if (!transferYN.isEmpty()) {
			System.out.println("transferYN :" + transferYN);
			PT_AGENT_TRAN_HDR_BEAN.setATH_PRODN_TRANSFER_YN(transferYN);
		}
	}

	public String preBack() {
		/*
		 * String actionClass = "PT099_A_Search"; String actionMethod = "fetch";
		 * String returnString= "backToAgentTranSearchPage"; CommonUtils
		 * commonUtils = new CommonUtils();
		 * commonUtils.callRetaintion(actionClass, actionMethod);
		 */
		return "PT099_A";
	}

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form
	// flow proper- 6
	public void instantiateAllComponents() {
		COMP_UI_M_ATH_POL_NO = new HtmlInputText();
		COMP_ATH_AGENT_CODE = new HtmlInputText();
		COMP_UI_M_ATH_AGENT_NAME = new HtmlInputText();
		COMP_ATH_N_AGENT = new HtmlInputText();
		COMP_UI_M_ATH_NEW_AGENT_NAME = new HtmlInputText();

		COMP_UI_M_APPRV_STATUS = new HtmlOutputText();

		COMP_ATH_DATE = new HtmlCalendar();
		COMP_ATH_EFF_FM_DT = new HtmlCalendar();

		COMP_ATH_PRODN_TRANSFER_YN = new HtmlSelectOneMenu();

		COMP_UI_M_LOV_ATH_POL_NO = new HtmlCommandButton();
		COMP_UI_M_LOV_NEW_AGENT = new HtmlCommandButton();
		COMP_UI_M_BUT_PROCESS = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
	}

	public void setDisabledAllInputs(boolean disabled) {
		COMP_UI_M_ATH_POL_NO.setDisabled(disabled);
		COMP_ATH_AGENT_CODE.setDisabled(disabled);
		COMP_UI_M_ATH_AGENT_NAME.setDisabled(disabled);
		COMP_ATH_N_AGENT.setDisabled(disabled);
		COMP_UI_M_ATH_NEW_AGENT_NAME.setDisabled(disabled);

		COMP_ATH_DATE.setDisabled(disabled);
		COMP_ATH_EFF_FM_DT.setDisabled(disabled);

		COMP_ATH_PRODN_TRANSFER_YN.setDisabled(disabled);
	}

	public void setDisabledAllButtons(boolean disabled) {
		COMP_UI_M_LOV_ATH_POL_NO.setDisabled(disabled);
		COMP_UI_M_LOV_NEW_AGENT.setDisabled(disabled);
		COMP_UI_M_BUT_PROCESS.setDisabled(disabled);
		COMP_UI_M_BUT_APPROVE.setDisabled(disabled);
	}

	public void setAllComponentsDisabled(boolean disabled) {
		setDisabledAllInputs(disabled);
		setDisabledAllButtons(disabled);
	}

	public void setApprovalStatus(String apprFlag) {
		if (apprFlag != null && "A".equals(apprFlag)) {
			UI_M_APPRV_STATUS = Messages.getString("messageProperties_PT099_A",
					"PT099_A$PT_AGENT_TRAN_HDR$statusapproved");
		} else {
			UI_M_APPRV_STATUS = Messages.getString("messageProperties_PT099_A",
					"PT099_A$PT_AGENT_TRAN_HDR$statusnotapproved");
		}
	}

	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow
	// proper- 6 ]

	public boolean isApproveWithoutReversal() {
		return approveWithoutReversal;
	}

	public void setApproveWithoutReversal(boolean approveWithoutReversal) {
		this.approveWithoutReversal = approveWithoutReversal;
	}

	public void executeQuery(PT_AGENT_TRAN_HDR pt_agent_tran_hdr)
			throws Exception {
		Connection connnection = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT PT_AGENT_TRAN_HDR.*,ROWID FROM PT_AGENT_TRAN_HDR WHERE ROWID = ?";
		Object[] values = null;

		values = new Object[] { pt_agent_tran_hdr.getROWID() };
		try {
			connnection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(query, connnection, values);
			while (rs1.next()) {

				pt_agent_tran_hdr.setATH_SYS_ID(rs1.getDouble("ATH_SYS_ID"));
				pt_agent_tran_hdr.setATH_AGENT_CODE(rs1
						.getString("ATH_AGENT_CODE"));
				pt_agent_tran_hdr.setATH_AGENT_RANK_CODE(rs1
						.getString("ATH_AGENT_RANK_CODE"));
				pt_agent_tran_hdr.setATH_PARENT_CODE(rs1
						.getString("ATH_PARENT_CODE"));
				pt_agent_tran_hdr.setATH_DATE(rs1.getDate("ATH_DATE"));
				pt_agent_tran_hdr
						.setATH_EFF_FM_DT(rs1.getDate("ATH_EFF_FM_DT"));
				pt_agent_tran_hdr.setATH_APPRV_FLAG(rs1
						.getString("ATH_APPRV_FLAG"));
				pt_agent_tran_hdr.setATH_TYPE(rs1.getString("ATH_TYPE"));
				pt_agent_tran_hdr.setATH_CR_DT(rs1.getDate("ATH_CR_DT"));
				pt_agent_tran_hdr.setATH_CR_UID(rs1.getString("ATH_CR_UID"));
				pt_agent_tran_hdr.setATH_UPD_DT(rs1.getDate("ATH_UPD_DT"));
				pt_agent_tran_hdr.setATH_UPD_UID(rs1.getString("ATH_UPD_UID"));
				pt_agent_tran_hdr.setATH_TERMINATION_TYPE(rs1
						.getString("ATH_TERMINATION_TYPE"));
				pt_agent_tran_hdr.setATH_AGENT_NEW_RANK_CODE(rs1
						.getString("ATH_AGENT_NEW_RANK_CODE"));
				pt_agent_tran_hdr.setATH_REVIEW1_DT(rs1
						.getDate("ATH_REVIEW1_DT"));
				pt_agent_tran_hdr.setATH_REVIEW2_DT(rs1
						.getDate("ATH_REVIEW2_DT"));
				pt_agent_tran_hdr.setATH_REVIEW3_DT(rs1
						.getDate("ATH_REVIEW3_DT"));
				pt_agent_tran_hdr.setATH_REVIEW4_DT(rs1
						.getDate("ATH_REVIEW4_DT"));
				pt_agent_tran_hdr.setATH_NEW_AGENT_CODE(rs1
						.getString("ATH_NEW_AGENT_CODE"));
				pt_agent_tran_hdr.setATH_POL_SYS_ID(rs1
						.getDouble("ATH_POL_SYS_ID"));

				pt_agent_tran_hdr.setATH_PRODN_TRANSFER_YN(rs1
						.getString("ATH_PRODN_TRANSFER_YN"));
				pt_agent_tran_hdr.setATH_FLEX_01(rs1.getString("ATH_FLEX_01"));
				pt_agent_tran_hdr.setATH_FLEX_02(rs1.getString("ATH_FLEX_02"));
				pt_agent_tran_hdr.setATH_FLEX_03(rs1.getString("ATH_FLEX_03"));
				pt_agent_tran_hdr.setATH_FLEX_04(rs1.getString("ATH_FLEX_04"));
				pt_agent_tran_hdr.setATH_FLEX_05(rs1.getString("ATH_FLEX_05"));

				pt_agent_tran_hdr.setROWID(rs1.getString("ROWID"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY() throws Exception {
		String C1 = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		String C2 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		Connection connection;
		CRUDHandler handler;
		ResultSet resultSetC1;
		ResultSet resultSetC2;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSetC1 = handler
					.executeSelectStatement(C1, connection,
							new Object[] { PT_AGENT_TRAN_HDR_BEAN
									.getATH_POL_SYS_ID() });
			if (resultSetC1.next()) {
				PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_POL_NO(resultSetC1
						.getString(1));
			}

			resultSetC2 = handler
					.executeSelectStatement(C2, connection,
							new Object[] { PT_AGENT_TRAN_HDR_BEAN
									.getATH_AGENT_CODE() });
			if (resultSetC2.next()) {
				PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_AGENT_NAME(resultSetC2
						.getString(1));
			}

			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { PT_AGENT_TRAN_HDR_BEAN
							.getATH_NEW_AGENT_CODE() });
			if (resultSetC2.next()) {
				PT_AGENT_TRAN_HDR_BEAN.setUI_M_ATH_NEW_AGENT_NAME(resultSetC2
						.getString(1));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
