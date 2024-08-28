package com.iii.pel.forms.PILT016A_APAC;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS;
import com.iii.pel.util.RUPEE_TO_WORD;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POL_APPROVAL;
import com.iii.pel.utils.PCOPK_SYS_VARS;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_DEPOSIT_ACTION extends CommonReportAction {

	private HtmlOutputLabel COMP_UI_M_DEP_UPD_UID;

	private HtmlOutputLabel COMP_UI_M_DEP_REV_STATUS;

	// private HtmlOutputLabel COMP_UI_M_POL_STATUS;

	private HtmlOutputLabel COMP_UI_M_PDC;

	private HtmlOutputText COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_DEP_CONT_REF_ID1_LABEL;

	private HtmlInputText COMP_DEP_CONT_REF_ID1;

	private HtmlOutputLabel COMP_DEP_GROSS_NET_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_DEP_GROSS_NET_FLAG;

	private HtmlOutputLabel COMP_DEP_CONT_REF_ID2_LABEL;

	private HtmlInputText COMP_DEP_CONT_REF_ID2;

	private HtmlOutputLabel COMP_DEP_TXN_CODE_LABEL;

	private HtmlInputText COMP_DEP_TXN_CODE;

	private HtmlOutputLabel COMP_DEP_REF_NO_LABEL;

	private HtmlInputText COMP_DEP_REF_NO;

	private HtmlOutputLabel COMP_DEP_DOC_NO_LABEL;

	private HtmlInputText COMP_DEP_DOC_NO;

	private HtmlOutputLabel COMP_DEP_TEMP_RCPT_NO_LABEL;

	private HtmlInputText COMP_DEP_TEMP_RCPT_NO;
	
	private HtmlOutputLabel COMP_DEP_ADTH_BATCH_NO_LABEL;
	
	private HtmlOutputText COMP_UI_M_REC_REVERSE;
	
	private HtmlInputText COMP_DEP_ADTH_BATCH_NO;

	private HtmlOutputLabel COMP_DEP_DOC_DT_LABEL;

	private HtmlCalendar COMP_DEP_DOC_DT;

	private HtmlOutputLabel COMP_DEP_CUST_CODE_LABEL;

	private HtmlInputText COMP_DEP_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CUST_NAME;

	private HtmlOutputLabel COMP_DEP_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_DEP_ACNT_YEAR;

	private HtmlOutputLabel COMP_DEP_CONT_CODE_LABEL;

	private HtmlInputText COMP_DEP_CONT_CODE;

	private HtmlOutputLabel COMP_UI_M_CONT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CONT_NAME;
	
	private HtmlOutputLabel COMP_DEP_MAST_RCPT_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_DEP_MAST_RCPT_YN;

	private HtmlOutputLabel COMP_DEP_REPL_RCPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_DEP_REPL_RCPT_YN;

	private HtmlOutputLabel COMP_DEP_PROD_CODE_LABEL;

	private HtmlInputText COMP_DEP_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_DEP_REP_BANK_IN_SLIP_NO_LABEL;

	private HtmlInputText COMP_DEP_REP_BANK_IN_SLIP_NO;

	private HtmlOutputLabel COMP_DEP_REPL_TXN_CODE_LABEL;

	private HtmlInputText COMP_DEP_REPL_TXN_CODE;

	private HtmlOutputLabel COMP_DEP_AGENT_CODE_LABEL;

	private HtmlInputText COMP_DEP_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_AGENT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_AGENT_CODE_DESC;

	private HtmlOutputLabel COMP_DEP_REPL_DOC_NO_LABEL;

	private HtmlInputText COMP_DEP_REPL_DOC_NO;

	private HtmlOutputLabel COMP_DEP_COLL_AGENT_CODE_LABEL;

	private HtmlInputText COMP_DEP_COLL_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_COLL_AGENT_CODE_DESC;

	private HtmlOutputLabel COMP_DEP_REPL_ACC_YR_LABEL;

	private HtmlInputText COMP_DEP_REPL_ACC_YR;

	private HtmlOutputLabel COMP_UI_M_POL_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_UI_M_POL_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_DEP_AMT;

	private HtmlOutputLabel COMP_UI_M_POL_LC_COMMISSION_LABEL;

	private HtmlInputText COMP_UI_M_POL_LC_COMMISSION;

	private HtmlOutputLabel COMP_DEP_LC_OTH_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_OTH_AMT;

	private HtmlOutputLabel COMP_DEP_LC_TOT_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_TOT_AMT;

	private HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_POL_LC_NET_PREM;

	private HtmlOutputLabel COMP_DEP_LC_TOTAL_AMT_LABEL;

	private HtmlInputText COMP_DEP_LC_TOTAL_AMT;

	private HtmlOutputLabel COMP_DEP_BANK_IN_SLIP_NO_LABEL;

	private HtmlInputText COMP_DEP_BANK_IN_SLIP_NO;

	private HtmlOutputLabel COMP_DEP_DIVN_CODE_LABEL;

	private HtmlInputText COMP_DEP_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_DIVN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_DIVN_DESC;

	private HtmlOutputLabel COMP_DEP_DEPT_CODE_LABEL;

	private HtmlInputText COMP_DEP_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_DEPT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_DEPT_DESC;

	private HtmlOutputLabel COMP_DEP_CLASS_CODE_LABEL;

	private HtmlInputText COMP_DEP_CLASS_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_CLASS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_CLASS_CODE_DESC;

	private HtmlOutputLabel COMP_DEP_BANKIN_CODE_LABEL;

	private HtmlInputText COMP_DEP_BANKIN_CODE;

	private HtmlOutputLabel COMP_UI_M_BANKIN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_BANKIN_NAME;

	private HtmlOutputLabel COMP_DEP_PLAN_CODE_LABEL;

	private HtmlInputText COMP_DEP_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_PLAN_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_PLAN_CODE_DESC;

	private HtmlOutputLabel COMP_DEP_DS_CODE_LABEL;

	private HtmlInputText COMP_DEP_DS_CODE;

	private HtmlOutputLabel COMP_UI_M_DEP_DS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_DS_CODE_DESC;

	private HtmlOutputLabel COMP_DEP_SRC_OF_BUS_LABEL;

	private HtmlInputText COMP_DEP_SRC_OF_BUS;

	private HtmlOutputLabel COMP_UI_M_DEP_BUS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEP_BUS_DESC;

	private HtmlOutputLabel COMP_DEP_REV_REMARKS_LABEL;

	private HtmlInputText COMP_DEP_REV_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CUST_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CONT_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_AGENT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_COLL_AGENT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BU_LOV_DEP_REF_NO;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVAL;

	private HtmlCommandButton COMP_UI_M_BUT_CONTRACTOR;

	private HtmlCommandButton COMP_UI_M_BUT_DEP_PROD_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_POL_DET;
	
	private HtmlCommandButton COMP_UI_M_BUT_REPORT;
	
	private IP_REP_INFO  IP_REP_INFO_BEAN; 
 
	private HtmlCommandButton COMP_UI_M_CHEQUE;

	private PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN;

	private HtmlOutputText COMP_UI_M_POL_STATUS;
	
	private HtmlTab COMP_MORE_INFO_1;
	
	private HtmlTab COMP_MORE_INFO_2;

	private PT_IL_DEPOSIT_HELPER helper;
	
	private PILT016A_APAC_PT_IL_DEPOSIT_DELEGATE delegate;

	// ControlBean ctrlBean ;

	String ps_value = null;

	private HtmlCommandButton prBt;
	// private HtmlAjaxCommandButton prBt;

	private List<SelectItem> rcptYNList = new ArrayList<SelectItem>();
	private List<SelectItem> grossNetComboList = new ArrayList<SelectItem>();

	private String divisionDesc; // FROM MERGING SENTHIL CODE
	
	private List<LovBean> suggesionList = null;

	private TabbedBar tabbedBar;

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	// public ControlBean getCtrlBean() {
	// return ctrlBean;
	// }
	//
	// public void setCtrlBean(ControlBean ctrlBean) {
	// this.ctrlBean = ctrlBean;
	// }

	PILT016A_APAC_COMPOSITE_ACTION compositeAction;

	
	
	private HtmlCommandLink COMP_SAVE_BTN;

	public HtmlCommandLink getCOMP_SAVE_BTN() {
		return COMP_SAVE_BTN;
	}

	public void setCOMP_SAVE_BTN(HtmlCommandLink cOMP_SAVE_BTN) {
		COMP_SAVE_BTN = cOMP_SAVE_BTN;
	}
	
	public PT_IL_DEPOSIT_ACTION() {
		try {
			PT_IL_DEPOSIT_BEAN = new PT_IL_DEPOSIT();
			helper = new PT_IL_DEPOSIT_HELPER();
			delegate = new PILT016A_APAC_PT_IL_DEPOSIT_DELEGATE();
			IP_REP_INFO_BEAN = new IP_REP_INFO();
			List list1 = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT016A_APAC", "PT_IL_DEPOSIT",
					"PT_IL_DEPOSIT.DEP_GROSS_NET_FLAG", "NET_GROSS");
			setGrossNetComboList(list1);
			List list2 = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT016A_APAC", "PT_IL_DEPOSIT",
					"PT_IL_DEPOSIT.DEP_REPL_RCPT_YN", "YESNO");
			setRcptYNList(list2);
			
			/*Added by Ram on 23/12/2016 for Credit Business field*/
			setCreditYNList(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT016A_APAC", "PT_IL_DEPOSIT",
					"PT_IL_DEPOSIT.DEP_REPL_RCPT_YN", "YESNO"));
			/*End*/
			
			/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
			setCommisionYNList(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT016A_APAC", "PT_IL_DEPOSIT",
					"PT_IL_DEPOSIT.DEP_COMM_YN", "YESNO"));
			/*End*/
			
			instantiateAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// resetAllComponent();

	}

	/**
	 * Instantiates all components in PT_IL_DEPOSIT_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_DEP_CONT_REF_ID1 = new HtmlInputText();
		COMP_DEP_CONT_REF_ID2 = new HtmlInputText();
		COMP_DEP_TXN_CODE = new HtmlInputText();
		COMP_DEP_REF_NO = new HtmlInputText();
		COMP_DEP_DOC_NO = new HtmlInputText();
		COMP_DEP_TEMP_RCPT_NO = new HtmlInputText();
		COMP_DEP_CUST_CODE = new HtmlInputText();
		COMP_UI_M_CUST_NAME = new HtmlInputText();
		COMP_DEP_ACNT_YEAR = new HtmlInputText();
		COMP_DEP_CONT_CODE = new HtmlInputText();
		COMP_UI_M_CONT_NAME = new HtmlInputText();
		COMP_DEP_PROD_CODE = new HtmlInputText();
		COMP_UI_M_DEP_PROD_CODE_DESC = new HtmlInputText();
		COMP_DEP_REP_BANK_IN_SLIP_NO = new HtmlInputText();
		COMP_DEP_REPL_TXN_CODE = new HtmlInputText();
		COMP_DEP_AGENT_CODE = new HtmlInputText();
		COMP_UI_M_DEP_AGENT_CODE_DESC = new HtmlInputText();
		COMP_DEP_REPL_DOC_NO = new HtmlInputText();
		COMP_DEP_COLL_AGENT_CODE = new HtmlInputText();
		COMP_UI_M_DEP_COLL_AGENT_CODE_DESC = new HtmlInputText();
		COMP_DEP_REPL_ACC_YR = new HtmlInputText();
		COMP_UI_M_POL_LC_GROSS_PREM = new HtmlInputText();
		COMP_DEP_LC_DEP_AMT = new HtmlInputText();
		COMP_UI_M_POL_LC_COMMISSION = new HtmlInputText();
		COMP_DEP_LC_OTH_AMT = new HtmlInputText();
		COMP_DEP_LC_TOT_AMT = new HtmlInputText();
		COMP_UI_M_POL_LC_NET_PREM = new HtmlInputText();
		COMP_DEP_LC_TOTAL_AMT = new HtmlInputText();
		COMP_DEP_BANK_IN_SLIP_NO = new HtmlInputText();
		COMP_DEP_DIVN_CODE = new HtmlInputText();
		COMP_UI_M_DEP_DIVN_DESC = new HtmlInputText();
		COMP_DEP_DEPT_CODE = new HtmlInputText();
		COMP_UI_M_DEP_DEPT_DESC = new HtmlInputText();
		COMP_DEP_CLASS_CODE = new HtmlInputText();
		COMP_UI_M_DEP_CLASS_CODE_DESC = new HtmlInputText();
		COMP_DEP_BANKIN_CODE = new HtmlInputText();
		COMP_UI_M_BANKIN_NAME = new HtmlInputText();
		COMP_DEP_PLAN_CODE = new HtmlInputText();
		COMP_UI_M_DEP_PLAN_CODE_DESC = new HtmlInputText();
		COMP_DEP_DS_CODE = new HtmlInputText();
		COMP_UI_M_DEP_DS_CODE_DESC = new HtmlInputText();
		COMP_DEP_SRC_OF_BUS = new HtmlInputText();
		COMP_UI_M_DEP_BUS_DESC = new HtmlInputText();
		COMP_DEP_REV_REMARKS = new HtmlInputText();
		
		COMP_SAVE_BTN=new HtmlCommandLink();

		// Instantiating HtmlSelectOneMenu
		COMP_DEP_GROSS_NET_FLAG = new HtmlSelectOneMenu();
		COMP_DEP_REPL_RCPT_YN = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_DEP_DOC_DT = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_CUST_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_CONT_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_AGENT_CODE_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_COLL_AGENT_CODE_LOV = new HtmlCommandButton();
		COMP_UI_M_BU_LOV_DEP_REF_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_PYMT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL = new HtmlCommandButton();
		COMP_UI_M_BUT_CONTRACTOR = new HtmlCommandButton();
		COMP_UI_M_BUT_DEP_PROD_CODE_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_POL_DET = new HtmlCommandButton();
		COMP_UI_M_CHEQUE = new HtmlCommandButton();
		prBt = new HtmlCommandButton();
		
		/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
		COMP_DEP_COMM_YN_LABEL = new HtmlOutputLabel();
		COMP_DEP_COMM_YN       = new HtmlSelectOneMenu();
		/*End*/
		
		/*Newly added into kic from fidelity by pidugu raj dt: 01-10-2018 as suggested by sivaraman*/
		COMP_UI_M_DEP_SUS_AMT = new HtmlInputText();
		/*End Newly added into kic from fidelity by pidugu raj dt: 01-10-2018 as suggested by sivaraman*/
		/*Added by rakesh on 06-03-2020 for orient uat issue receipting currency */
		COMP_DEP_CURR_CODE_LABEL= new HtmlOutputLabel();
		COMP_DEP_CURR_CODE = new HtmlInputText();
		COMP_DEP_CURR_DESC = new HtmlInputText();
		//END
		
		//Added by rakesh on 06-07-2020 for total paid amount in FC instead of LC
				COMP_DEP_FC_TOTAL_AMT_LABEL= new HtmlOutputLabel();
				COMP_DEP_FC_TOTAL_AMT= new HtmlInputText();
				//END

	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_UPD_UID() {
		return COMP_UI_M_DEP_UPD_UID;
	}

	public void setCOMP_UI_M_DEP_UPD_UID(HtmlOutputLabel COMP_UI_M_DEP_UPD_UID) {
		this.COMP_UI_M_DEP_UPD_UID = COMP_UI_M_DEP_UPD_UID;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_REV_STATUS() {
		return COMP_UI_M_DEP_REV_STATUS;
	}

	public void setCOMP_UI_M_DEP_REV_STATUS(
			HtmlOutputLabel COMP_UI_M_DEP_REV_STATUS) {
		this.COMP_UI_M_DEP_REV_STATUS = COMP_UI_M_DEP_REV_STATUS;
	}

	/*
	 * public HtmlOutputLabel getCOMP_UI_M_POL_STATUS() { return
	 * COMP_UI_M_POL_STATUS; }
	 * 
	 * public void setCOMP_UI_M_POL_STATUS(HtmlOutputLabel COMP_UI_M_POL_STATUS) {
	 * this.COMP_UI_M_POL_STATUS = COMP_UI_M_POL_STATUS; }
	 */
	public HtmlOutputLabel getCOMP_UI_M_PDC() {
		return COMP_UI_M_PDC;
	}

	public void setCOMP_UI_M_PDC(HtmlOutputLabel COMP_UI_M_PDC) {
		this.COMP_UI_M_PDC = COMP_UI_M_PDC;
	}

	public HtmlOutputText getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputText COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_DEP_CONT_REF_ID1_LABEL() {
		return COMP_DEP_CONT_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_DEP_CONT_REF_ID1() {
		return COMP_DEP_CONT_REF_ID1;
	}

	public void setCOMP_DEP_CONT_REF_ID1_LABEL(
			HtmlOutputLabel COMP_DEP_CONT_REF_ID1_LABEL) {
		this.COMP_DEP_CONT_REF_ID1_LABEL = COMP_DEP_CONT_REF_ID1_LABEL;
	}

	public void setCOMP_DEP_CONT_REF_ID1(HtmlInputText COMP_DEP_CONT_REF_ID1) {
		this.COMP_DEP_CONT_REF_ID1 = COMP_DEP_CONT_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_DEP_GROSS_NET_FLAG_LABEL() {
		return COMP_DEP_GROSS_NET_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DEP_GROSS_NET_FLAG() {
		return COMP_DEP_GROSS_NET_FLAG;
	}

	public void setCOMP_DEP_GROSS_NET_FLAG_LABEL(
			HtmlOutputLabel COMP_DEP_GROSS_NET_FLAG_LABEL) {
		this.COMP_DEP_GROSS_NET_FLAG_LABEL = COMP_DEP_GROSS_NET_FLAG_LABEL;
	}

	public void setCOMP_DEP_GROSS_NET_FLAG(
			HtmlSelectOneMenu COMP_DEP_GROSS_NET_FLAG) {
		this.COMP_DEP_GROSS_NET_FLAG = COMP_DEP_GROSS_NET_FLAG;
	}

	public HtmlOutputLabel getCOMP_DEP_CONT_REF_ID2_LABEL() {
		return COMP_DEP_CONT_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_DEP_CONT_REF_ID2() {
		return COMP_DEP_CONT_REF_ID2;
	}

	public void setCOMP_DEP_CONT_REF_ID2_LABEL(
			HtmlOutputLabel COMP_DEP_CONT_REF_ID2_LABEL) {
		this.COMP_DEP_CONT_REF_ID2_LABEL = COMP_DEP_CONT_REF_ID2_LABEL;
	}

	public void setCOMP_DEP_CONT_REF_ID2(HtmlInputText COMP_DEP_CONT_REF_ID2) {
		this.COMP_DEP_CONT_REF_ID2 = COMP_DEP_CONT_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_DEP_TXN_CODE_LABEL() {
		return COMP_DEP_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_TXN_CODE() {
		return COMP_DEP_TXN_CODE;
	}

	public void setCOMP_DEP_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_TXN_CODE_LABEL) {
		this.COMP_DEP_TXN_CODE_LABEL = COMP_DEP_TXN_CODE_LABEL;
	}

	public void setCOMP_DEP_TXN_CODE(HtmlInputText COMP_DEP_TXN_CODE) {
		this.COMP_DEP_TXN_CODE = COMP_DEP_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_DEP_REF_NO_LABEL() {
		return COMP_DEP_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_REF_NO() {
		return COMP_DEP_REF_NO;
	}

	public void setCOMP_DEP_REF_NO_LABEL(HtmlOutputLabel COMP_DEP_REF_NO_LABEL) {
		this.COMP_DEP_REF_NO_LABEL = COMP_DEP_REF_NO_LABEL;
	}

	public void setCOMP_DEP_REF_NO(HtmlInputText COMP_DEP_REF_NO) {
		this.COMP_DEP_REF_NO = COMP_DEP_REF_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_DOC_NO_LABEL() {
		return COMP_DEP_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_DOC_NO() {
		return COMP_DEP_DOC_NO;
	}

	public void setCOMP_DEP_DOC_NO_LABEL(HtmlOutputLabel COMP_DEP_DOC_NO_LABEL) {
		this.COMP_DEP_DOC_NO_LABEL = COMP_DEP_DOC_NO_LABEL;
	}

	public void setCOMP_DEP_DOC_NO(HtmlInputText COMP_DEP_DOC_NO) {
		this.COMP_DEP_DOC_NO = COMP_DEP_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_TEMP_RCPT_NO_LABEL() {
		return COMP_DEP_TEMP_RCPT_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_TEMP_RCPT_NO() {
		return COMP_DEP_TEMP_RCPT_NO;
	}

	public void setCOMP_DEP_TEMP_RCPT_NO_LABEL(
			HtmlOutputLabel COMP_DEP_TEMP_RCPT_NO_LABEL) {
		this.COMP_DEP_TEMP_RCPT_NO_LABEL = COMP_DEP_TEMP_RCPT_NO_LABEL;
	}

	public void setCOMP_DEP_TEMP_RCPT_NO(HtmlInputText COMP_DEP_TEMP_RCPT_NO) {
		this.COMP_DEP_TEMP_RCPT_NO = COMP_DEP_TEMP_RCPT_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_DOC_DT_LABEL() {
		return COMP_DEP_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DEP_DOC_DT() {
		return COMP_DEP_DOC_DT;
	}

	public void setCOMP_DEP_DOC_DT_LABEL(HtmlOutputLabel COMP_DEP_DOC_DT_LABEL) {
		this.COMP_DEP_DOC_DT_LABEL = COMP_DEP_DOC_DT_LABEL;
	}

	public void setCOMP_DEP_DOC_DT(HtmlCalendar COMP_DEP_DOC_DT) {
		this.COMP_DEP_DOC_DT = COMP_DEP_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_DEP_CUST_CODE_LABEL() {
		return COMP_DEP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_CUST_CODE() {
		return COMP_DEP_CUST_CODE;
	}

	public void setCOMP_DEP_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_CUST_CODE_LABEL) {
		this.COMP_DEP_CUST_CODE_LABEL = COMP_DEP_CUST_CODE_LABEL;
	}

	public void setCOMP_DEP_CUST_CODE(HtmlInputText COMP_DEP_CUST_CODE) {
		this.COMP_DEP_CUST_CODE = COMP_DEP_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_NAME_LABEL() {
		return COMP_UI_M_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_NAME() {
		return COMP_UI_M_CUST_NAME;
	}

	public void setCOMP_UI_M_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL) {
		this.COMP_UI_M_CUST_NAME_LABEL = COMP_UI_M_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_CUST_NAME(HtmlInputText COMP_UI_M_CUST_NAME) {
		this.COMP_UI_M_CUST_NAME = COMP_UI_M_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_DEP_ACNT_YEAR_LABEL() {
		return COMP_DEP_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_DEP_ACNT_YEAR() {
		return COMP_DEP_ACNT_YEAR;
	}

	public void setCOMP_DEP_ACNT_YEAR_LABEL(
			HtmlOutputLabel COMP_DEP_ACNT_YEAR_LABEL) {
		this.COMP_DEP_ACNT_YEAR_LABEL = COMP_DEP_ACNT_YEAR_LABEL;
	}

	public void setCOMP_DEP_ACNT_YEAR(HtmlInputText COMP_DEP_ACNT_YEAR) {
		this.COMP_DEP_ACNT_YEAR = COMP_DEP_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_DEP_CONT_CODE_LABEL() {
		return COMP_DEP_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_CONT_CODE() {
		return COMP_DEP_CONT_CODE;
	}

	public void setCOMP_DEP_CONT_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_CONT_CODE_LABEL) {
		this.COMP_DEP_CONT_CODE_LABEL = COMP_DEP_CONT_CODE_LABEL;
	}

	public void setCOMP_DEP_CONT_CODE(HtmlInputText COMP_DEP_CONT_CODE) {
		this.COMP_DEP_CONT_CODE = COMP_DEP_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_NAME_LABEL() {
		return COMP_UI_M_CONT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_NAME() {
		return COMP_UI_M_CONT_NAME;
	}

	public void setCOMP_UI_M_CONT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_NAME_LABEL) {
		this.COMP_UI_M_CONT_NAME_LABEL = COMP_UI_M_CONT_NAME_LABEL;
	}

	public void setCOMP_UI_M_CONT_NAME(HtmlInputText COMP_UI_M_CONT_NAME) {
		this.COMP_UI_M_CONT_NAME = COMP_UI_M_CONT_NAME;
	}

	public HtmlOutputLabel getCOMP_DEP_REPL_RCPT_YN_LABEL() {
		return COMP_DEP_REPL_RCPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DEP_REPL_RCPT_YN() {
		return COMP_DEP_REPL_RCPT_YN;
	}

	public void setCOMP_DEP_REPL_RCPT_YN_LABEL(
			HtmlOutputLabel COMP_DEP_REPL_RCPT_YN_LABEL) {
		this.COMP_DEP_REPL_RCPT_YN_LABEL = COMP_DEP_REPL_RCPT_YN_LABEL;
	}

	public void setCOMP_DEP_REPL_RCPT_YN(HtmlSelectOneMenu COMP_DEP_REPL_RCPT_YN) {
		this.COMP_DEP_REPL_RCPT_YN = COMP_DEP_REPL_RCPT_YN;
	}

	public HtmlOutputLabel getCOMP_DEP_PROD_CODE_LABEL() {
		return COMP_DEP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_PROD_CODE() {
		return COMP_DEP_PROD_CODE;
	}

	public void setCOMP_DEP_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_PROD_CODE_LABEL) {
		this.COMP_DEP_PROD_CODE_LABEL = COMP_DEP_PROD_CODE_LABEL;
	}

	public void setCOMP_DEP_PROD_CODE(HtmlInputText COMP_DEP_PROD_CODE) {
		this.COMP_DEP_PROD_CODE = COMP_DEP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_DEP_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_PROD_CODE_DESC() {
		return COMP_UI_M_DEP_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_DEP_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEP_PROD_CODE_DESC_LABEL = COMP_UI_M_DEP_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_PROD_CODE_DESC(
			HtmlInputText COMP_UI_M_DEP_PROD_CODE_DESC) {
		this.COMP_UI_M_DEP_PROD_CODE_DESC = COMP_UI_M_DEP_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_REP_BANK_IN_SLIP_NO_LABEL() {
		return COMP_DEP_REP_BANK_IN_SLIP_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_REP_BANK_IN_SLIP_NO() {
		return COMP_DEP_REP_BANK_IN_SLIP_NO;
	}

	public void setCOMP_DEP_REP_BANK_IN_SLIP_NO_LABEL(
			HtmlOutputLabel COMP_DEP_REP_BANK_IN_SLIP_NO_LABEL) {
		this.COMP_DEP_REP_BANK_IN_SLIP_NO_LABEL = COMP_DEP_REP_BANK_IN_SLIP_NO_LABEL;
	}

	public void setCOMP_DEP_REP_BANK_IN_SLIP_NO(
			HtmlInputText COMP_DEP_REP_BANK_IN_SLIP_NO) {
		this.COMP_DEP_REP_BANK_IN_SLIP_NO = COMP_DEP_REP_BANK_IN_SLIP_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_REPL_TXN_CODE_LABEL() {
		return COMP_DEP_REPL_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_REPL_TXN_CODE() {
		return COMP_DEP_REPL_TXN_CODE;
	}

	public void setCOMP_DEP_REPL_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_REPL_TXN_CODE_LABEL) {
		this.COMP_DEP_REPL_TXN_CODE_LABEL = COMP_DEP_REPL_TXN_CODE_LABEL;
	}

	public void setCOMP_DEP_REPL_TXN_CODE(HtmlInputText COMP_DEP_REPL_TXN_CODE) {
		this.COMP_DEP_REPL_TXN_CODE = COMP_DEP_REPL_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_DEP_AGENT_CODE_LABEL() {
		return COMP_DEP_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_AGENT_CODE() {
		return COMP_DEP_AGENT_CODE;
	}

	public void setCOMP_DEP_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_AGENT_CODE_LABEL) {
		this.COMP_DEP_AGENT_CODE_LABEL = COMP_DEP_AGENT_CODE_LABEL;
	}

	public void setCOMP_DEP_AGENT_CODE(HtmlInputText COMP_DEP_AGENT_CODE) {
		this.COMP_DEP_AGENT_CODE = COMP_DEP_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_AGENT_CODE_DESC_LABEL() {
		return COMP_UI_M_DEP_AGENT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_AGENT_CODE_DESC() {
		return COMP_UI_M_DEP_AGENT_CODE_DESC;
	}

	public void setCOMP_UI_M_DEP_AGENT_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_AGENT_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEP_AGENT_CODE_DESC_LABEL = COMP_UI_M_DEP_AGENT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_AGENT_CODE_DESC(
			HtmlInputText COMP_UI_M_DEP_AGENT_CODE_DESC) {
		this.COMP_UI_M_DEP_AGENT_CODE_DESC = COMP_UI_M_DEP_AGENT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_REPL_DOC_NO_LABEL() {
		return COMP_DEP_REPL_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_REPL_DOC_NO() {
		return COMP_DEP_REPL_DOC_NO;
	}

	public void setCOMP_DEP_REPL_DOC_NO_LABEL(
			HtmlOutputLabel COMP_DEP_REPL_DOC_NO_LABEL) {
		this.COMP_DEP_REPL_DOC_NO_LABEL = COMP_DEP_REPL_DOC_NO_LABEL;
	}

	public void setCOMP_DEP_REPL_DOC_NO(HtmlInputText COMP_DEP_REPL_DOC_NO) {
		this.COMP_DEP_REPL_DOC_NO = COMP_DEP_REPL_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_COLL_AGENT_CODE_LABEL() {
		return COMP_DEP_COLL_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_COLL_AGENT_CODE() {
		return COMP_DEP_COLL_AGENT_CODE;
	}

	public void setCOMP_DEP_COLL_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_COLL_AGENT_CODE_LABEL) {
		this.COMP_DEP_COLL_AGENT_CODE_LABEL = COMP_DEP_COLL_AGENT_CODE_LABEL;
	}

	public void setCOMP_DEP_COLL_AGENT_CODE(
			HtmlInputText COMP_DEP_COLL_AGENT_CODE) {
		this.COMP_DEP_COLL_AGENT_CODE = COMP_DEP_COLL_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL() {
		return COMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_COLL_AGENT_CODE_DESC() {
		return COMP_UI_M_DEP_COLL_AGENT_CODE_DESC;
	}

	public void setCOMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL = COMP_UI_M_DEP_COLL_AGENT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_COLL_AGENT_CODE_DESC(
			HtmlInputText COMP_UI_M_DEP_COLL_AGENT_CODE_DESC) {
		this.COMP_UI_M_DEP_COLL_AGENT_CODE_DESC = COMP_UI_M_DEP_COLL_AGENT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_REPL_ACC_YR_LABEL() {
		return COMP_DEP_REPL_ACC_YR_LABEL;
	}

	public HtmlInputText getCOMP_DEP_REPL_ACC_YR() {
		return COMP_DEP_REPL_ACC_YR;
	}

	public void setCOMP_DEP_REPL_ACC_YR_LABEL(
			HtmlOutputLabel COMP_DEP_REPL_ACC_YR_LABEL) {
		this.COMP_DEP_REPL_ACC_YR_LABEL = COMP_DEP_REPL_ACC_YR_LABEL;
	}

	public void setCOMP_DEP_REPL_ACC_YR(HtmlInputText COMP_DEP_REPL_ACC_YR) {
		this.COMP_DEP_REPL_ACC_YR = COMP_DEP_REPL_ACC_YR;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_GROSS_PREM_LABEL() {
		return COMP_UI_M_POL_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_GROSS_PREM() {
		return COMP_UI_M_POL_LC_GROSS_PREM;
	}

	public void setCOMP_UI_M_POL_LC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_LC_GROSS_PREM_LABEL) {
		this.COMP_UI_M_POL_LC_GROSS_PREM_LABEL = COMP_UI_M_POL_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_GROSS_PREM(
			HtmlInputText COMP_UI_M_POL_LC_GROSS_PREM) {
		this.COMP_UI_M_POL_LC_GROSS_PREM = COMP_UI_M_POL_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_DEP_AMT_LABEL() {
		return COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_DEP_AMT() {
		return COMP_DEP_LC_DEP_AMT;
	}

	public void setCOMP_DEP_LC_DEP_AMT_LABEL(
			HtmlOutputLabel COMP_DEP_LC_DEP_AMT_LABEL) {
		this.COMP_DEP_LC_DEP_AMT_LABEL = COMP_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_DEP_AMT(HtmlInputText COMP_DEP_LC_DEP_AMT) {
		this.COMP_DEP_LC_DEP_AMT = COMP_DEP_LC_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_COMMISSION_LABEL() {
		return COMP_UI_M_POL_LC_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_COMMISSION() {
		return COMP_UI_M_POL_LC_COMMISSION;
	}

	public void setCOMP_UI_M_POL_LC_COMMISSION_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_LC_COMMISSION_LABEL) {
		this.COMP_UI_M_POL_LC_COMMISSION_LABEL = COMP_UI_M_POL_LC_COMMISSION_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_COMMISSION(
			HtmlInputText COMP_UI_M_POL_LC_COMMISSION) {
		this.COMP_UI_M_POL_LC_COMMISSION = COMP_UI_M_POL_LC_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_OTH_AMT_LABEL() {
		return COMP_DEP_LC_OTH_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_OTH_AMT() {
		return COMP_DEP_LC_OTH_AMT;
	}

	public void setCOMP_DEP_LC_OTH_AMT_LABEL(
			HtmlOutputLabel COMP_DEP_LC_OTH_AMT_LABEL) {
		this.COMP_DEP_LC_OTH_AMT_LABEL = COMP_DEP_LC_OTH_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_OTH_AMT(HtmlInputText COMP_DEP_LC_OTH_AMT) {
		this.COMP_DEP_LC_OTH_AMT = COMP_DEP_LC_OTH_AMT;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_TOT_AMT_LABEL() {
		return COMP_DEP_LC_TOT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_TOT_AMT() {
		return COMP_DEP_LC_TOT_AMT;
	}

	public void setCOMP_DEP_LC_TOT_AMT_LABEL(
			HtmlOutputLabel COMP_DEP_LC_TOT_AMT_LABEL) {
		this.COMP_DEP_LC_TOT_AMT_LABEL = COMP_DEP_LC_TOT_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_TOT_AMT(HtmlInputText COMP_DEP_LC_TOT_AMT) {
		this.COMP_DEP_LC_TOT_AMT = COMP_DEP_LC_TOT_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_LC_NET_PREM_LABEL() {
		return COMP_UI_M_POL_LC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_LC_NET_PREM() {
		return COMP_UI_M_POL_LC_NET_PREM;
	}

	public void setCOMP_UI_M_POL_LC_NET_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_LC_NET_PREM_LABEL) {
		this.COMP_UI_M_POL_LC_NET_PREM_LABEL = COMP_UI_M_POL_LC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_POL_LC_NET_PREM(
			HtmlInputText COMP_UI_M_POL_LC_NET_PREM) {
		this.COMP_UI_M_POL_LC_NET_PREM = COMP_UI_M_POL_LC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_DEP_LC_TOTAL_AMT_LABEL() {
		return COMP_DEP_LC_TOTAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_LC_TOTAL_AMT() {
		return COMP_DEP_LC_TOTAL_AMT;
	}

	public void setCOMP_DEP_LC_TOTAL_AMT_LABEL(
			HtmlOutputLabel COMP_DEP_LC_TOTAL_AMT_LABEL) {
		this.COMP_DEP_LC_TOTAL_AMT_LABEL = COMP_DEP_LC_TOTAL_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_TOTAL_AMT(HtmlInputText COMP_DEP_LC_TOTAL_AMT) {
		this.COMP_DEP_LC_TOTAL_AMT = COMP_DEP_LC_TOTAL_AMT;
	}

	public HtmlOutputLabel getCOMP_DEP_BANK_IN_SLIP_NO_LABEL() {
		return COMP_DEP_BANK_IN_SLIP_NO_LABEL;
	}

	public HtmlInputText getCOMP_DEP_BANK_IN_SLIP_NO() {
		return COMP_DEP_BANK_IN_SLIP_NO;
	}

	public void setCOMP_DEP_BANK_IN_SLIP_NO_LABEL(
			HtmlOutputLabel COMP_DEP_BANK_IN_SLIP_NO_LABEL) {
		this.COMP_DEP_BANK_IN_SLIP_NO_LABEL = COMP_DEP_BANK_IN_SLIP_NO_LABEL;
	}

	public void setCOMP_DEP_BANK_IN_SLIP_NO(
			HtmlInputText COMP_DEP_BANK_IN_SLIP_NO) {
		this.COMP_DEP_BANK_IN_SLIP_NO = COMP_DEP_BANK_IN_SLIP_NO;
	}

	public HtmlOutputLabel getCOMP_DEP_DIVN_CODE_LABEL() {
		return COMP_DEP_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_DIVN_CODE() {
		return COMP_DEP_DIVN_CODE;
	}

	public void setCOMP_DEP_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_DIVN_CODE_LABEL) {
		this.COMP_DEP_DIVN_CODE_LABEL = COMP_DEP_DIVN_CODE_LABEL;
	}

	public void setCOMP_DEP_DIVN_CODE(HtmlInputText COMP_DEP_DIVN_CODE) {
		this.COMP_DEP_DIVN_CODE = COMP_DEP_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_DIVN_DESC_LABEL() {
		return COMP_UI_M_DEP_DIVN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_DIVN_DESC() {
		return COMP_UI_M_DEP_DIVN_DESC;
	}

	public void setCOMP_UI_M_DEP_DIVN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_DIVN_DESC_LABEL) {
		this.COMP_UI_M_DEP_DIVN_DESC_LABEL = COMP_UI_M_DEP_DIVN_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_DIVN_DESC(HtmlInputText COMP_UI_M_DEP_DIVN_DESC) {
		this.COMP_UI_M_DEP_DIVN_DESC = COMP_UI_M_DEP_DIVN_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_DEPT_CODE_LABEL() {
		return COMP_DEP_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_DEPT_CODE() {
		return COMP_DEP_DEPT_CODE;
	}

	public void setCOMP_DEP_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_DEPT_CODE_LABEL) {
		this.COMP_DEP_DEPT_CODE_LABEL = COMP_DEP_DEPT_CODE_LABEL;
	}

	public void setCOMP_DEP_DEPT_CODE(HtmlInputText COMP_DEP_DEPT_CODE) {
		this.COMP_DEP_DEPT_CODE = COMP_DEP_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_DEPT_DESC_LABEL() {
		return COMP_UI_M_DEP_DEPT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_DEPT_DESC() {
		return COMP_UI_M_DEP_DEPT_DESC;
	}

	public void setCOMP_UI_M_DEP_DEPT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_DEPT_DESC_LABEL) {
		this.COMP_UI_M_DEP_DEPT_DESC_LABEL = COMP_UI_M_DEP_DEPT_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_DEPT_DESC(HtmlInputText COMP_UI_M_DEP_DEPT_DESC) {
		this.COMP_UI_M_DEP_DEPT_DESC = COMP_UI_M_DEP_DEPT_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_CLASS_CODE_LABEL() {
		return COMP_DEP_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_CLASS_CODE() {
		return COMP_DEP_CLASS_CODE;
	}

	public void setCOMP_DEP_CLASS_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_CLASS_CODE_LABEL) {
		this.COMP_DEP_CLASS_CODE_LABEL = COMP_DEP_CLASS_CODE_LABEL;
	}

	public void setCOMP_DEP_CLASS_CODE(HtmlInputText COMP_DEP_CLASS_CODE) {
		this.COMP_DEP_CLASS_CODE = COMP_DEP_CLASS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_CLASS_CODE_DESC_LABEL() {
		return COMP_UI_M_DEP_CLASS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_CLASS_CODE_DESC() {
		return COMP_UI_M_DEP_CLASS_CODE_DESC;
	}

	public void setCOMP_UI_M_DEP_CLASS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_CLASS_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEP_CLASS_CODE_DESC_LABEL = COMP_UI_M_DEP_CLASS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_CLASS_CODE_DESC(
			HtmlInputText COMP_UI_M_DEP_CLASS_CODE_DESC) {
		this.COMP_UI_M_DEP_CLASS_CODE_DESC = COMP_UI_M_DEP_CLASS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_BANKIN_CODE_LABEL() {
		return COMP_DEP_BANKIN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_BANKIN_CODE() {
		return COMP_DEP_BANKIN_CODE;
	}

	public void setCOMP_DEP_BANKIN_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_BANKIN_CODE_LABEL) {
		this.COMP_DEP_BANKIN_CODE_LABEL = COMP_DEP_BANKIN_CODE_LABEL;
	}

	public void setCOMP_DEP_BANKIN_CODE(HtmlInputText COMP_DEP_BANKIN_CODE) {
		this.COMP_DEP_BANKIN_CODE = COMP_DEP_BANKIN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANKIN_NAME_LABEL() {
		return COMP_UI_M_BANKIN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BANKIN_NAME() {
		return COMP_UI_M_BANKIN_NAME;
	}

	public void setCOMP_UI_M_BANKIN_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_BANKIN_NAME_LABEL) {
		this.COMP_UI_M_BANKIN_NAME_LABEL = COMP_UI_M_BANKIN_NAME_LABEL;
	}

	public void setCOMP_UI_M_BANKIN_NAME(HtmlInputText COMP_UI_M_BANKIN_NAME) {
		this.COMP_UI_M_BANKIN_NAME = COMP_UI_M_BANKIN_NAME;
	}

	public HtmlOutputLabel getCOMP_DEP_PLAN_CODE_LABEL() {
		return COMP_DEP_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_PLAN_CODE() {
		return COMP_DEP_PLAN_CODE;
	}

	public void setCOMP_DEP_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_DEP_PLAN_CODE_LABEL) {
		this.COMP_DEP_PLAN_CODE_LABEL = COMP_DEP_PLAN_CODE_LABEL;
	}

	public void setCOMP_DEP_PLAN_CODE(HtmlInputText COMP_DEP_PLAN_CODE) {
		this.COMP_DEP_PLAN_CODE = COMP_DEP_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_PLAN_CODE_DESC_LABEL() {
		return COMP_UI_M_DEP_PLAN_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_PLAN_CODE_DESC() {
		return COMP_UI_M_DEP_PLAN_CODE_DESC;
	}

	public void setCOMP_UI_M_DEP_PLAN_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_PLAN_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEP_PLAN_CODE_DESC_LABEL = COMP_UI_M_DEP_PLAN_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_PLAN_CODE_DESC(
			HtmlInputText COMP_UI_M_DEP_PLAN_CODE_DESC) {
		this.COMP_UI_M_DEP_PLAN_CODE_DESC = COMP_UI_M_DEP_PLAN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_DS_CODE_LABEL() {
		return COMP_DEP_DS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEP_DS_CODE() {
		return COMP_DEP_DS_CODE;
	}

	public void setCOMP_DEP_DS_CODE_LABEL(HtmlOutputLabel COMP_DEP_DS_CODE_LABEL) {
		this.COMP_DEP_DS_CODE_LABEL = COMP_DEP_DS_CODE_LABEL;
	}

	public void setCOMP_DEP_DS_CODE(HtmlInputText COMP_DEP_DS_CODE) {
		this.COMP_DEP_DS_CODE = COMP_DEP_DS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_DS_CODE_DESC_LABEL() {
		return COMP_UI_M_DEP_DS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_DS_CODE_DESC() {
		return COMP_UI_M_DEP_DS_CODE_DESC;
	}

	public void setCOMP_UI_M_DEP_DS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_DS_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEP_DS_CODE_DESC_LABEL = COMP_UI_M_DEP_DS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_DS_CODE_DESC(
			HtmlInputText COMP_UI_M_DEP_DS_CODE_DESC) {
		this.COMP_UI_M_DEP_DS_CODE_DESC = COMP_UI_M_DEP_DS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_SRC_OF_BUS_LABEL() {
		return COMP_DEP_SRC_OF_BUS_LABEL;
	}

	public HtmlInputText getCOMP_DEP_SRC_OF_BUS() {
		return COMP_DEP_SRC_OF_BUS;
	}

	public void setCOMP_DEP_SRC_OF_BUS_LABEL(
			HtmlOutputLabel COMP_DEP_SRC_OF_BUS_LABEL) {
		this.COMP_DEP_SRC_OF_BUS_LABEL = COMP_DEP_SRC_OF_BUS_LABEL;
	}

	public void setCOMP_DEP_SRC_OF_BUS(HtmlInputText COMP_DEP_SRC_OF_BUS) {
		this.COMP_DEP_SRC_OF_BUS = COMP_DEP_SRC_OF_BUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_BUS_DESC_LABEL() {
		return COMP_UI_M_DEP_BUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_BUS_DESC() {
		return COMP_UI_M_DEP_BUS_DESC;
	}

	public void setCOMP_UI_M_DEP_BUS_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEP_BUS_DESC_LABEL) {
		this.COMP_UI_M_DEP_BUS_DESC_LABEL = COMP_UI_M_DEP_BUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEP_BUS_DESC(HtmlInputText COMP_UI_M_DEP_BUS_DESC) {
		this.COMP_UI_M_DEP_BUS_DESC = COMP_UI_M_DEP_BUS_DESC;
	}

	public HtmlOutputLabel getCOMP_DEP_REV_REMARKS_LABEL() {
		return COMP_DEP_REV_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_DEP_REV_REMARKS() {
		return COMP_DEP_REV_REMARKS;
	}

	public void setCOMP_DEP_REV_REMARKS_LABEL(
			HtmlOutputLabel COMP_DEP_REV_REMARKS_LABEL) {
		this.COMP_DEP_REV_REMARKS_LABEL = COMP_DEP_REV_REMARKS_LABEL;
	}

	public void setCOMP_DEP_REV_REMARKS(HtmlInputText COMP_DEP_REV_REMARKS) {
		this.COMP_DEP_REV_REMARKS = COMP_DEP_REV_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CUST_CODE() {
		return COMP_UI_M_BUT_LOV_CUST_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_CUST_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CUST_CODE) {
		this.COMP_UI_M_BUT_LOV_CUST_CODE = COMP_UI_M_BUT_LOV_CUST_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CONT_CODE() {
		return COMP_UI_M_BUT_LOV_CONT_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_CONT_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CONT_CODE) {
		this.COMP_UI_M_BUT_LOV_CONT_CODE = COMP_UI_M_BUT_LOV_CONT_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_AGENT_CODE_LOV() {
		return COMP_UI_M_BUT_AGENT_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_AGENT_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_AGENT_CODE_LOV) {
		this.COMP_UI_M_BUT_AGENT_CODE_LOV = COMP_UI_M_BUT_AGENT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COLL_AGENT_CODE_LOV() {
		return COMP_UI_M_BUT_COLL_AGENT_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_COLL_AGENT_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_COLL_AGENT_CODE_LOV) {
		this.COMP_UI_M_BUT_COLL_AGENT_CODE_LOV = COMP_UI_M_BUT_COLL_AGENT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BU_LOV_DEP_REF_NO() {
		return COMP_UI_M_BU_LOV_DEP_REF_NO;
	}

	public void setCOMP_UI_M_BU_LOV_DEP_REF_NO(
			HtmlCommandButton COMP_UI_M_BU_LOV_DEP_REF_NO) {
		this.COMP_UI_M_BU_LOV_DEP_REF_NO = COMP_UI_M_BU_LOV_DEP_REF_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS) {
		this.COMP_UI_M_BUT_PYMT_DTLS = COMP_UI_M_BUT_PYMT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(
			HtmlCommandButton COMP_UI_M_BUT_APPROVAL) {
		this.COMP_UI_M_BUT_APPROVAL = COMP_UI_M_BUT_APPROVAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CONTRACTOR() {
		return COMP_UI_M_BUT_CONTRACTOR;
	}

	public void setCOMP_UI_M_BUT_CONTRACTOR(
			HtmlCommandButton COMP_UI_M_BUT_CONTRACTOR) {
		this.COMP_UI_M_BUT_CONTRACTOR = COMP_UI_M_BUT_CONTRACTOR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEP_PROD_CODE_LOV() {
		return COMP_UI_M_BUT_DEP_PROD_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_DEP_PROD_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DEP_PROD_CODE_LOV) {
		this.COMP_UI_M_BUT_DEP_PROD_CODE_LOV = COMP_UI_M_BUT_DEP_PROD_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_DET() {
		return COMP_UI_M_BUT_POL_DET;
	}

	public void setCOMP_UI_M_BUT_POL_DET(HtmlCommandButton COMP_UI_M_BUT_POL_DET) {
		this.COMP_UI_M_BUT_POL_DET = COMP_UI_M_BUT_POL_DET;
	}

	public HtmlCommandButton getCOMP_UI_M_CHEQUE() {
		return COMP_UI_M_CHEQUE;
	}

	public void setCOMP_UI_M_CHEQUE(HtmlCommandButton COMP_UI_M_CHEQUE) {
		this.COMP_UI_M_CHEQUE = COMP_UI_M_CHEQUE;
	}

	public PT_IL_DEPOSIT getPT_IL_DEPOSIT_BEAN() {
		return PT_IL_DEPOSIT_BEAN;
	}

	public void setPT_IL_DEPOSIT_BEAN(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		this.PT_IL_DEPOSIT_BEAN = PT_IL_DEPOSIT_BEAN;
	}

	public void setSessionParameters() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext()
				.getSessionMap();

		// session.put("GLOBAL.M_PRIVILEGE", "YYY");
		// session.put("GLOBAL.M_FAILURE", "FALSE");
		// session.put("GLOBAL.M_USER_ID",
		// CommonUtils.getControlBean().getM_USER_ID());
		// session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM
		// NAME");
		// session.put("GLOBAL.M_LANG_CODE", "ENG");
		session.put("GLOBAL.M_PARAM_1", "");
		session.put("GLOBAL.M_PARAM_2", "WDNO");
		// session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR2");
		// session.put("GLOBAL.M_MODULE_NAME", "PILT016A_APAC");
		// session.put("GLOBAL.M_DFLT_VALUES", "00101 01 ");

	}

	public void std_pre_form() {

		// FacesContext context = FacesContext.getCurrentInstance();
		// Map<String, Object> session =
		// context.getExternalContext().getSessionMap();
		//
		// ControlBean ctrlBean = CommonUtils.getControlBean();
		// if(ctrlBean == null) {
		// //ctrlBean = new ControlBean();
		// ctrlBean = CommonUtils.getControlBean();
		// // setCtrlBean(ctrlBean);
		// System.out.println("Control bean null");
		// }
		// System.out.println("---------------->His: GLOBAL.M_NAME-"
		// +((String)session.get("GLOBAL.M_NAME")).substring(30, 42));
		// System.out.println("---------------->Man: GLOBAL.M_NAME-"
		// +ctrlBean.getM_SCR_NAME());
		// System.out.println("---------------->His: GLOBAL.M_DFLT_VALUES-"
		// +((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		// System.out.println("---------------->Man: GLOBAL.M_DFLT_VALUES-"
		// +ctrlBean.getM_COMP_CODE());
		// System.out.println("---------------->His: GLOBAL.M_DFLT_VALUES-"
		// +((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		// System.out.println("---------------->Man: GLOBAL.M_DFLT_VALUES-"
		// +ctrlBean.getM_DIVN_CODE());
		// System.out.println("---------------->His: GLOBAL.M_DFLT_VALUES-"
		// +((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		// System.out.println("---------------->Man: GLOBAL.M_DFLT_VALUES-"
		// +ctrlBean.getM_DEPT_CODE());

		// ctrlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30,
		// 42));

		// System.out.println("session STD_PRE_FORM "+session.toString());

		/*
		 * ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		 * ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID")); //
		 * bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		 * ctrlBean.setM_PROG_NAME("PILT016A_APAC"); //
		 * COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		 * 'BUTTON_PALETTE.M_COMP_NAME') ;
		 * System.out.println((String)session.get("GLOBAL.M_NAME"));
		 *  // COPY('10','SYSTEM.MESSAGE_LEVEL');
		 * session.put("GLOBAL.M_FAILURE", "FALSE");
		 * ctrlBean.setM_GOFLD_NAME("NULL");
		 * ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
		 */
		/*
		 * ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		 * ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		 * 
		 * System.out.println((String)session.get("GLOBAL.M_DFLT_VALUES"));
		 * 
		 * ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		 */

		// System.out.println("std_pre
		// _last"+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	}
	public void preForm(){
		CRUDHandler handler = null;
		Connection connection =null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ArrayList<String> pValList = null;
		String C1="SELECT	PARA_VALUE  FROM	  FP_PARAMETER  WHERE	PARA_ID = 'BASE.CURR'";
		String C2 = "SELECT PLAN_TYPE " + "FROM   PM_IL_PLAN "
				+ " WHERE  PLAN_CODE = (SELECT PROD_PLAN_CODE "
				+ "FROM   PM_IL_PRODUCT " + "WHERE  PROD_CODE = ? ) ";
		String C3="SELECT PS_VALUE   FROM PP_SYSTEM    WHERE PS_CODE ='CUSTREFMAN'";
		
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		DBProcedures dbProcedures = new DBProcedures();
		PCOPK_SYS_VARS pcopk_sys_vars = new PCOPK_SYS_VARS();
		int M_PS_VALUE = 0;
		try{
			pcopk_sys_vars.P_SET_PARA_VALUES(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"), CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DIVN_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DEPT_CODE"), CommonUtils.getControlBean()
					.getM_BASE_CURR(), "2", CommonUtils.getControlBean()
					.getM_PROG_NAME());
			
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1 , connection);
			if(C1_REC.next()){
				compositeAction.getDUMMY_BEAN().setUI_BASE_CURR_CODE(C1_REC.getString(1));
			}
			
			
			if(CALLING_FORM==null){
			//	
			}
			STD_PRE_FORM(compositeAction);
			CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", null);
			//CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",Long.parseLong("0"));
			CommonUtils.setGlobalVariable("GLOBAL.CURR_CODE", null);
			CommonUtils.setGlobalObject("GLOBAL.FC_AMT", new Double(0.0));
			CommonUtils.setGlobalObject("GLOBAL.LC_AMT",new Double(0.0));
			CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE", new Double(1.0));
			CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
			
			 pValList = dbProcedures.callP_VAL_SYSTEM("ILUWMEDHT", "ILUWMEDHT",
			    "N");
		    if (pValList != null && pValList.size() > 0) {
		    	compositeAction.getDUMMY_BEAN().setUI_M_CALC_METHOD(pValList.get(1));
		    }
		    
		    C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE()});
		    if(C2_REC.next()){
		    	compositeAction.getDUMMY_BEAN().setUI_M_PLAN_TYPE(C2_REC.getString(1));
		    }
		    
		    if(compositeAction.getDUMMY_BEAN().getUI_M_CALC_METHOD() != null ){
		    	/* SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_COMMISSION',VISIBLE,PROPERTY_TRUE);
		      	  SET_ITEM_PROPERTY('BP.B_POL_LC_COMMISSION',VISIBLE,PROPERTY_TRUE);
		      	  SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_GROSS_PREM',VISIBLE,PROPERTY_TRUE);
		      	  SET_ITEM_PROPERTY('BP.B_M_POL_LC_GROSS_PREM',VISIBLE,PROPERTY_TRUE);
		      	  IF :DUMMY.M_PLAN_TYPE = 'M'AND NVL(:DUMMY.M_PROD_PREM_CALC_MTHD,'N') = 'X' THEN
		      	  	 --SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_GROSS_NET_FLAG',VISIBLE,PROPERTY_TRUE);
		      	  	-- SET_ITEM_PROPERTY('BP.B_DEP_GROSS_NET_FLAG',VISIBLE,PROPERTY_TRUE);
		      	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_NET_PREM',VISIBLE,PROPERTY_TRUE);
		      	     SET_ITEM_PROPERTY('BP.B_POL_LC_NET_PREM',VISIBLE,PROPERTY_TRUE);
		      	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_NET_PREM',Y_POS,202);
		      	     SET_ITEM_PROPERTY('BP.B_POL_LC_NET_PREM',Y_POS,202);
		      	   --  SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_LC_DEP_AMT',Y_POS,219);
		      	    -- SET_ITEM_PROPERTY('BP.B_DEP_LC_DEP_AMT',Y_POS,219);
		    
		      	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_LC_TOTAL_AMT',Y_POS,240);
		      	     SET_ITEM_PROPERTY('BP.B_DEP_LC_TOTAL_PAID_AMT',Y_POS,240);    --VED
		      --	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_BANKIN_CODE',Y_POS,240);
		     --	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_BANKIN_NAME',Y_POS,240);
		      --     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_BUT_LOV_BANKIN',Y_POS,240);
		      	 --   SET_ITEM_PROPERTY('BP.B_BANKIN_CODE',Y_POS,240);
		      	  ELSE
		      	  	 --SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_GROSS_NET_FLAG',VISIBLE,PROPERTY_FALSE);
		      	  	 --SET_ITEM_PROPERTY('BP.B_DEP_GROSS_NET_FLAG',VISIBLE,PROPERTY_FALSE);
		      	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_NET_PREM',VISIBLE,PROPERTY_FALSE);
		      	     SET_ITEM_PROPERTY('BP.B_POL_LC_NET_PREM',VISIBLE,PROPERTY_FALSE);
		   	   	   --SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_LC_DEP_AMT',Y_POS,202);
		   	   	   --SET_ITEM_PROPERTY('BP.B_DEP_LC_DEP_AMT',Y_POS,202);
		   	   	   
		   	   	   SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_LC_TOTAL_AMT',Y_POS,218.5);
		   	   	   SET_ITEM_PROPERTY('BP.B_DEP_LC_TOTAL_PAID_AMT',Y_POS,218.5);--VED
		   	--   	   SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_BANKIN_CODE',Y_POS,222);
		     -- 	     SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_BANKIN_NAME',Y_POS,222);
		     -- 	     SET_ITEM_PROPERTY('BP.B_BANKIN_CODE',Y_POS,222);
		     -- 	      SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_BUT_LOV_BANKIN',Y_POS,222);
		      	  END IF;*/
		    }/*else if("2".equalsIgnoreCase(compositeAction.getDUMMY_BEAN().getUI_M_CALC_METHOD())){
		    	  SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_NET_PREM',VISIBLE,PROPERTY_FALSE);
		       	  SET_ITEM_PROPERTY('BP.B_POL_LC_NET_PREM',VISIBLE,PROPERTY_FALSE);
		       	  SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_COMMISSION',VISIBLE,PROPERTY_FALSE);
		       	  SET_ITEM_PROPERTY('BP.B_POL_LC_COMMISSION',VISIBLE,PROPERTY_FALSE);
		       	  SET_ITEM_PROPERTY('PT_IL_DEPOSIT.M_POL_LC_GROSS_PREM',VISIBLE,PROPERTY_FALSE);
		       	  SET_ITEM_PROPERTY('BP.B_M_POL_LC_GROSS_PREM',VISIBLE,PROPERTY_FALSE);
		    	  --	SET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_GROSS_NET_FLAG',VISIBLE,PROPERTY_FALSE);
		      	--  SET_ITEM_PROPERTY('BP.B_DEP_GROSS_NET_FLAG',VISIBLE,PROPERTY_FALSE);
		    }*/
		    
		    /*M_TITLE:= :CTRL.M_USER_ID ||'                 '||:CTRL.M_SCR_NAME||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
		    SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);*/
		    compositeAction.getDUMMY_BEAN().setUI_PT_IL_DEPOSIT_CF("N");
		    compositeAction.getDUMMY_BEAN().setUI_PT_IL_PYMT_DTLS_CF("P");
		    compositeAction.getDUMMY_BEAN().setUI_M_DEL_FLAG("N");
		    
		    
		    CommonUtils.setGlobalVariable("GLOBAL.M_CONT_CODE", null);
		    C3_REC = handler.executeSelectStatement(C3 , connection);
			if(C3_REC.next()){
				M_PS_VALUE = C3_REC.getInt(1);
			}
			
			if(CommonUtils.nvl(M_PS_VALUE, 0) != 1){
				COMP_DEP_CONT_REF_ID1.setRequired(false);
				COMP_DEP_CONT_REF_ID2.setRequired(false);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
				CommonUtils.closeCursor(C3_REC);
			}catch(Exception exception2){}
		}
	}
	
	 /**
	 * 
	 * @param PT_IL_CLAIM_ACTION_BEAN
	 */
	public void STD_PRE_FORM(PILT016A_APAC_COMPOSITE_ACTION compositeAction){
		String CUR_FORM = null;
		String M_FIRST_BLOCK =null;
		String M_MODULE_NAME =null;
		int M_QUERY_OK = 0;
		String M_TITLE = null;
		String M_SCR_NAME =null;
		String M_COMP_CODE = null;
		String M_DIVN_CODE =null;
		String M_DEPT_CODE = null;
		
		String M_PARA_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
		String M_NAME = CommonUtils.getGlobalVariable("GLOBAL.M_NAME");
		String LANG_CODE = CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
		String M_DFLT_VALUES = CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES");
		M_MODULE_NAME =  CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_NAME");
			
		if(M_NAME!=null){
			//M_SCR_NAME = M_NAME.substring(30);
		}
		if(M_DFLT_VALUES==null || "".equalsIgnoreCase(M_DFLT_VALUES)){
			M_COMP_CODE = "001";//M_DFLT_VALUES.substring(1, 3);
			M_DIVN_CODE = "HO";//M_DFLT_VALUES.substring(4, 6);
			M_DEPT_CODE = "001";//M_DFLT_VALUES.substring(10, 6);
		}
		
		CTRL CTRL_BEAN = new CTRL();
		CTRL_BEAN.setUI_M_PARA_1(M_PARA_1);
		CTRL_BEAN.setUI_M_USER_ID(M_USER_ID);
		CTRL_BEAN.setUI_M_LANG_CODE(LANG_CODE);
		CTRL_BEAN.setUI_M_COMP_CODE(M_COMP_CODE);
		CTRL_BEAN.setUI_M_DIVN_CODE(M_DIVN_CODE);
		CTRL_BEAN.setUI_M_DEPT_CODE(M_DEPT_CODE);
		CTRL_BEAN.setUI_M_SCR_NAME(M_SCR_NAME);
		
		compositeAction.setCTRL_BEAN(CTRL_BEAN);
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "false");
		
	}
	
	public void preForm1(){
		System.out
				.println("CommonUtils.getControlBean().getM_DIVN_CODE()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
						+ CommonUtils.getControlBean().getM_DIVN_CODE());

		HtmlCommandButton BUT_APPROVAL = new HtmlCommandButton();
		BUT_APPROVAL.setDisabled(true);
		setCOMP_UI_M_BUT_APPROVAL(BUT_APPROVAL);
		// getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);

		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = context.getExternalContext()
				.getSessionMap();
		// Connection con = (Connection) sessionMap.get("CLIENT_CON");
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
		}

		CRUDHandler handler = new CRUDHandler();

		String qDEP_PROD_CODE = "select DEP_PROD_CODE from PT_IL_DEPOSIT where "
				+ "DEP_REF_NO = '"
				+ getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()
				+ "'";

		HtmlCommandButton prbtButton = new HtmlCommandButton();
		prbtButton.setDisabled(true);
		setPrBt(prbtButton);
		// getPrBt().setDisabled(true);

		try {
			ResultSet rs = handler.executeSelectStatement(qDEP_PROD_CODE, con);
			String DEP_PROD_CODE = null;
			if (rs != null && rs.next()) {
				// rs.next();
				DEP_PROD_CODE = rs.getString("DEP_PROD_CODE");
			}
			getPT_IL_DEPOSIT_BEAN().setDEP_PROD_CODE(DEP_PROD_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setSessionParameters();
		// std_pre_form();

		// String qC1 = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE PARA_ID =
		// 'BASE.CURR'";
		String qC2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE  PLAN_CODE = "
				+ "(SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = '"
				+ getPT_IL_DEPOSIT_BEAN().getDEP_PROD_CODE() + "')";

		System.out.println("qC2 for ps_value " + qC2);

		String qC3 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE ='CUSTREFMAN'";

		String paraValue = null;
		String plan_type = null;
		ps_value = null;
		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures procedures = new DBProcedures();
		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
		try {
			// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added

			ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(
					CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N",
					P_CURR_CODE, P_NAME, P_DECIMAL + "", "E");
			if (list != null && list.size() > 0) {
				P_CURR_CODE = list.get(0);
				P_NAME = list.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list.get(2));
				paraValue = P_CURR_CODE;
			}
			// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
			// String qC1 = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE PARA_ID =
			// '"+ P_CURR_CODE +"'";
			// rs1 = handler.executeSelectStatement(qC1, con);
			rs2 = handler.executeSelectStatement(qC2, con);
			rs3 = handler.executeSelectStatement(qC3, con);

			if (rs2 != null && rs2.next()) {
				plan_type = rs2.getString("PLAN_TYPE");
			}
			// Commented for Validating F_GET_BASE_CURRENCY : Added by Shankar
			// Bodduluri : 20-04-2009
			/*
			 * if(rs1 != null && rs1.next()){ paraValue =
			 * rs1.getString("PARA_VALUE"); }
			 */
			sessionMap.put("DUMMY.BASE_CURR_CODE", paraValue);
			if (rs3 != null && rs3.next()) {
				ps_value = rs3.getString("PS_VALUE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", null);
		CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",Long.parseLong("0"));
		CommonUtils.setGlobalVariable("GLOBAL.CURR_CODE", (String) sessionMap
				.get("DUMMY.BASE_CURR_CODE"));
		CommonUtils.setGlobalObject("GLOBAL.FC_AMT", new Double(0.0));
		CommonUtils.setGlobalObject("GLOBAL.LC_AMT",new Double(0.0));
		CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE", new Double(1.0));
		CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
		// For approval
		getPT_IL_DEPOSIT_BEAN().setDEP_PDC_FLAG("N");

		/*
		 * P_VAL_SYSTEM('IL_CALC_MTHD', 'IL_CALC_MTHD', M_PS_CODE_DESC, 'N',
		 * :DUMMY.M_CALC_METHOD);
		 */
		String code_desc = null;
		int m_calc_mthd = 0;
		ResultSet rs = null;
		try {
			CallableStatement cs = con
					.prepareCall("{call P_VAL_SYSTEM(?,?,?,?,?)}");
			cs.setString(1, "IL_CALC_MTHD");
			cs.setString(2, "IL_CALC_MTHD");
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(4, "N");
			cs.registerOutParameter(5, java.sql.Types.INTEGER);
			rs = cs.executeQuery();
			code_desc = cs.getString(3);
			m_calc_mthd = cs.getInt(5);

			System.out.println("procedure result " + code_desc + "  "
					+ m_calc_mthd);

			CommonUtils.setGlobalVariable("DUMMY.M_CALC_METHOD", String
					.valueOf(m_calc_mthd));

			if (m_calc_mthd == 1) {
				// set item properties
			} else if (m_calc_mthd == 2) {
				// set item property
			}

			String DUMMY_PT_IL_DEPOSIT_CF = "N";
			String DUMMY_PT_IL_PYMT_DTLS_CF = "P";
			/*
			 * PCOPK_SYS_VARS.P_SET_PARA_VALUES(:GLOBAL.M_LANG_CODE,
			 * :GLOBAL.M_FOR_LANG_CODE, :GLOBAL.M_USER_ID, :CTRL.M_COMP_CODE,
			 * :CTRL.M_DIVN_CODE, :CTRL.M_DEPT_CODE, NULL, NULL, 'ILIFE');
			 * 
			 * 
			 */
			// try {
			// CallableStatement cs1 = con.prepareCall("{call
			// PCOPK_SYS_VARS.P_SET_PARA_VALUES(?,?,?,?,?,?,?,?,?)}");
			// cs1.setString(1, (String)sessionMap.get("GLOBAL.M_LANG_CODE"));
			// cs1.setString(2,
			// (String)sessionMap.get("GLOBAL.M_FOR_LANG_CODE"));
			// cs1.setString(3, (String)sessionMap.get("GLOBAL.M_USER_ID"));
			// cs1.setString(4, ctrlBean.getM_COMP_CODE());
			// cs1.setString(5, ctrlBean.getM_DIVN_CODE());
			// cs1.setString(6, ctrlBean.getM_DEPT_CODE());
			// cs1.setNull(7, java.sql.Types.NULL);
			// cs1.setNull(8, java.sql.Types.NULL);
			// cs1.setString(9, "ILIFE");
			// boolean procFlag = cs1.execute();
			// System.out.println(procFlag);
			// }catch (Exception e) {
			// e.printStackTrace();
			// }
			sessionMap.put("GLOBAL.M_CONT_CODE", null);
			System.out.println("PS_VALUE " + ps_value);
			if (ps_value != null) {
				if (Integer.parseInt(ps_value) != 1) {
					getCOMP_DEP_CONT_REF_ID1().setRequired(false);
					getCOMP_DEP_CONT_REF_ID2().setRequired(false);
				}
			}
			// END OF PRE_FORM

			// WHEN NEW BLOCKF INSTANCE begins

			// WHEN CREATE RECORD of FORM LEVEL begins
			String curr_mode = (String) sessionMap.get("CURRENT_MODE");
			/*if (!"INSERT".equals(curr_mode)) {
				whenNewRecordInstanceBLOCK_LEVEL();
				postQuery();
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// [BugId:PREMIAGDC-AGENCY- 0055 Amit Gupta 25-Feb-09 Commented and
	// rewritten below it
	/*
	 * public void whenNewRecordInstanceBLOCK_LEVEL() {
	 * 
	 * FacesContext context = FacesContext.getCurrentInstance(); Map sess =
	 * context.getExternalContext().getSessionMap(); // Connection con =
	 * (Connection)sess.get("CLIENT_CON"); Connection con = null; try { con =
	 * CommonUtils.getConnection(); } catch (Exception e) { }
	 * 
	 * CRUDHandler handler = new CRUDHandler();
	 * 
	 * 
	 * String qC1 = "select count(*) from PT_IL_DEPOSIT where DEP_REF_NO = " + "
	 * '"+getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()+"' OR DEP_REF_NO in " + "
	 * (SELECT POL_PROP_NO FROM PT_IL_POLICY WHERE POL_NO =
	 * '"+getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()+"')" + " AND DEP_DOC_NO IS NOT
	 * NULL";
	 * 
	 * String qC2 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY " + "WHERE POL_NO =
	 * '"+getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()+"'"; int countC1 = 0;
	 * ResultSet rs = null; try { rs = handler.executeSelectStatement(qC1, con);
	 * if( rs != null && rs.next()) { countC1 = rs.getInt(1); }
	 * System.out.println("countC1 "+countC1); String POL_ADDL_STATUS = null; rs =
	 * handler.executeSelectStatement(qC2, con); if(rs.next()) { POL_ADDL_STATUS =
	 * rs.getString("POL_ADDL_STATUS"); }
	 * 
	 * P_VAL_SYSTEM('IL_ADDL_STAT', M_POL_ADDL_STATUS, M_CODE_DESCRIPTION, 'N',
	 * M_TEMP_VAL);
	 * 
	 * CallableStatement cs = con.prepareCall("{call P_VAL_SYSTEM(?,?,?,?,?)}");
	 * cs.setString(1, "IL_ADDL_STAT"); cs.setString(2, POL_ADDL_STATUS);
	 * cs.registerOutParameter(3, java.sql.Types.VARCHAR); cs.setString(4, "N");
	 * cs.registerOutParameter(5, java.sql.Types.INTEGER); boolean executed =
	 * cs.execute(); String desc = cs.getString(3); int tem_val = cs.getInt(5);
	 * System.out
	 * .println("PT_IL_DEPOSIT_ACTION.whenNewRecordInstanceBLOCK_LEVEL()
	 * "+executed+" "+ desc+" "+tem_val);
	 * 
	 * if(CommonUtils.getGlobalVariable("DUMMY.M_CALC_METHOD").equals("1")) {
	 * getPT_IL_DEPOSIT_BEAN().setUI_M_POL_STATUS(POL_ADDL_STATUS+" : "+desc); }
	 * 
	 * 
	 * 
	 * getCOMP_DEP_DEPT_CODE().setDisabled(true);
	 * getCOMP_DEP_DIVN_CODE().setDisabled(true);
	 * getCOMP_UI_M_BUT_APPROVAL().setDisabled(true); //
	 * getCOMP_UI_M_APPRV_STATUS().setValue("Not Approved");
	 * 
	 * if(countC1 > 0) { getCOMP_DEP_GROSS_NET_FLAG().setDisabled(true); }
	 * getCOMP_DEP_REF_NO().setReadonly(true); //
	 * getCOMP_DEP_CUST_CODE().setDisabled(true);
	 * getCOMP_DEP_CONT_CODE().setDisabled(true);
	 * getCOMP_DEP_LC_DEP_AMT().setDisabled(true); //
	 * if(getPT_IL_DEPOSIT_BEAN().getUI_M_APPRV_STATUS().startsWith("A")) {
	 * getCOMP_UI_M_BUT_CONTRACTOR().setDisabled(true); // }
	 * getCOMP_DEP_CLASS_CODE().setDisabled(true);
	 * getCOMP_DEP_BANKIN_CODE().setDisabled(true);
	 * getCOMP_DEP_PLAN_CODE().setDisabled(true);
	 * getCOMP_DEP_SRC_OF_BUS().setDisabled(true);
	 * getCOMP_DEP_PROD_CODE().setDisabled(false);
	 * getCOMP_UI_M_DEP_PROD_CODE_DESC().setReadonly(true);
	 * 
	 * String query = "select DEP_TXN_CODE, DEP_DOC_NO, DEP_DOC_DT from
	 * PT_IL_DEPOSIT where DEP_SYS_ID =
	 * '"+getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID_INTEGER()+"'";
	 * System.out.println("PT_IL_DEPOSIT_ACTION.whenNewRecordInstanceBLOCK_LEVEL(qry)
	 * "+query); rs = handler.executeSelectStatement(query, con); if(rs.next()) {
	 * String txn = rs.getString("DEP_TXN_CODE") ; double doc_no =
	 * rs.getDouble("DEP_DOC_NO"); Date date = rs.getDate("DEP_DOC_DT");
	 * getPT_IL_DEPOSIT_BEAN().setDEP_TXN_CODE(txn);
	 * getPT_IL_DEPOSIT_BEAN().setDEP_DOC_NO(doc_no); String paymentDetails =
	 * getPaymentDetails(); if((txn != null && doc_no != 0.0) ||
	 * paymentDetails!=null) {
	 * System.out.println("PT_IL_DEPOSIT_ACTION.whenNewRecordInstanceBLOCK_LEVEL(************)");
	 * COMP_UI_M_BUT_APPROVAL.setDisabled(true); }else{
	 * System.out.println("PT_IL_DEPOSIT_ACTION.whenNewRecordInstanceBLOCK_LEVEL(-------------------)");
	 * COMP_UI_M_BUT_APPROVAL.setDisabled(false); } }
	 *  } catch (Exception e) { e.printStackTrace(); }finally{ try {
	 * CommonUtils.closeCursor(rs); } catch (Exception e) { e.printStackTrace(); } } }
	 */
	// BugId:PREMIAGDC-AGENCY- 0055 Amit Gupta 25-Feb-09]

	// Entirely rewritten by Amit Gupta - 36077 as the original triggers
	// contains 5 cursors and
	// huge amount of required logic was missing
	// [BugId:PREMIAGDC-AGENCY- 0055 Amit Gupta 25-Feb-09 Whole
	// WHEN-NEW-RECORD-INSTANCE Trigger rewritten
	public void whenNewRecordInstanceBLOCK_LEVEL() throws Exception{
		String query1 = "SELECT COUNT(*) FROM PT_IL_DEPOSIT "
				+ "WHERE (DEP_REF_NO = ? "
				+ "OR 	DEP_REF_NO IN (SELECT POL_PROP_NO FROM PT_IL_POLICY "
				+ "WHERE POL_NO = ? ))" + "AND    DEP_DOC_NO IS NOT NULL";
		String query2 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ?";
		String query3 = "SELECT POL_MODE_OF_PYMT FROM PT_IL_POLICY WHERE POL_NO = ?";
		String query4 = "SELECT DPD_PAY_MODE,DPD_CHQ_NO,DPD_CHQ_DT FROM PT_IL_DEPOSIT_PYMT_DTLS "
				+ "WHERE  DPD_DEP_SYS_ID = ? AND DPD_PAY_MODE   = 'C'";
		String query5 = "SELECT POL_PREM_PAY_YRS,PROD_AGENT_HIRE_YN FROM PT_IL_POLICY,PM_IL_PRODUCT "
				+ "WHERE  POL_NO = ? AND POL_PROD_CODE = PROD_CODE";
		Integer M_COUNT = 0, M_COUNT1 = 0, M_TEMP_VAL = 0, M_POL_PREM_PAY_YRS = 0;
		String M_CURR_BLK = null, M_CURR_ITEM = null, M_TEMP_ITEM = null, M_POL_ADDL_STATUS = null, M_CODE_DESCRIPTION = null, M_PROD_AGENT_HIRE_YN = null, M_PS_CODE_DESC = null, M_POL_MODE_OF_PYMT = null, M_DPD_PAY_MODE = null, M_DPD_CHQ_NO = null;
		Double M_PS_VALUE_DAYS = 0.0;
		Date M_DPD_CHQ_DT = null;
		String Rev_val = null;
		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null;
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_BEAN();
		String Rev_query = "SELECT NVL(DEP_REC_REV_YN,'X') FROM PT_IL_DEPOSIT WHERE DEP_SYS_ID = ? ";
		try {
			

			if (getPT_IL_DEPOSIT_BEAN().getROWID() != null) {
				Object[] values1 = { getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO(),
						getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() };
				rs1 = getHandler().executeSelectStatement(query1,CommonUtils.getConnection(), values1);
				if (rs1.next()) {
					M_COUNT = rs1.getInt(1);
				}

				Object[] values5 = { getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() };
				rs5 = getHandler().executeSelectStatement(query5,CommonUtils.getConnection(), values5);
				if (rs5.next()) {
					M_POL_PREM_PAY_YRS = rs5.getInt(1);
					M_PROD_AGENT_HIRE_YN = rs5.getString(2);
				}

				if (getPT_IL_DEPOSIT_BEAN().getDEP_TXN_CODE() == null
						&& getPT_IL_DEPOSIT_BEAN().getDEP_DOC_NO() == 0
						//&& getPT_IL_DEPOSIT_BEAN().getDEP_DOC_DT() == null
						) {
					disableAllComponent(false);// SET_BLOCK_PROPERTY('PT_IL_DEPOSIT',UPDATE_ALLOWED,PROPERTY_TRUE);
					if (!COMP_DEP_DEPT_CODE.isDisabled()) {
						COMP_DEP_DEPT_CODE.setDisabled(false);
					}

					if (!COMP_DEP_DIVN_CODE.isDisabled()) {
						COMP_DEP_DIVN_CODE.setDisabled(false);
					}

					COMP_UI_M_BUT_APPROVAL.setDisabled(false);
					COMP_DEP_REF_NO.setDisabled(false);
					
					COMP_DEP_CUST_CODE.setDisabled(false);
					COMP_DEP_CONT_CODE.setDisabled(false);
					COMP_DEP_LC_DEP_AMT.setDisabled(false);
					compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(false);
					PT_IL_DEPOSIT_BEAN.setUI_M_APPRV_STATUS("Not Approved");
					
					COMP_UI_M_BUT_CONTRACTOR.setDisabled(true);
					
					//Commented by Akash to make normal flow(Calc_method 2 ) to work dated 03-feb-2013 

					if (/*"1".equalsIgnoreCase(DUMMY_BEAN.getUI_M_CALC_METHOD())
							&& */M_POL_PREM_PAY_YRS == 1
							&& "N".equalsIgnoreCase(M_PROD_AGENT_HIRE_YN)) {
						if (M_COUNT > 0) {
							COMP_DEP_GROSS_NET_FLAG.setDisabled(true);
						} else {
							COMP_DEP_GROSS_NET_FLAG.setDisabled(false);
						}
					}

				} else {
					if (!COMP_DEP_DEPT_CODE.isDisabled()) {
						COMP_DEP_DEPT_CODE.setReadonly(true);
					}

					if (!COMP_DEP_DIVN_CODE.isDisabled()) {
						COMP_DEP_DIVN_CODE.setReadonly(true);
					}

					COMP_UI_M_BUT_APPROVAL.setDisabled(true);
					COMP_DEP_REF_NO.setDisabled(false);
					COMP_DEP_REF_NO.setReadonly(true);

					COMP_DEP_CUST_CODE.setReadonly(true);
					COMP_DEP_CONT_CODE.setReadonly(true);
					COMP_DEP_LC_DEP_AMT.setReadonly(true);
					compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(true);
					PT_IL_DEPOSIT_BEAN.setUI_M_APPRV_STATUS("Approved");
					COMP_UI_M_BUT_CONTRACTOR.setDisabled(true);
					COMP_DEP_GROSS_NET_FLAG.setReadonly(true);
				}
			}

			if (PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE() == null
					&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO() == 0
					//&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_DT() == null
					) {
				COMP_UI_M_BUT_CONTRACTOR.setDisabled(true);
				COMP_UI_M_BUT_POL_DET.setDisabled(true);
			} else {
				COMP_UI_M_BUT_CONTRACTOR.setDisabled(false);
				COMP_UI_M_BUT_POL_DET.setDisabled(false);
			}

			Object[] values2 = { getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() };
			rs2 = getHandler().executeSelectStatement(query2,
					CommonUtils.getConnection(), values2);
			if (rs2.next()) {
				M_POL_ADDL_STATUS = rs2.getString(1);
				ArrayList<String> pValSystem = new DBProcedures()
						.callP_VAL_SYSTEM("IL_ADDL_STAT", M_POL_ADDL_STATUS,
								"N");
				if (!pValSystem.isEmpty()) {
					M_CODE_DESCRIPTION = pValSystem.get(0);

				}
				if ("1".equalsIgnoreCase(DUMMY_BEAN.getUI_M_CALC_METHOD())) {
					getPT_IL_DEPOSIT_BEAN().setUI_M_POL_STATUS(
							M_POL_ADDL_STATUS + " : " + M_CODE_DESCRIPTION);
				}
			}
			if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
					getPT_IL_DEPOSIT_BEAN().getDEP_PDC_FLAG(), "X"))) {
				getPT_IL_DEPOSIT_BEAN().setUI_M_PDC("PDC");
			} else {
				getPT_IL_DEPOSIT_BEAN().setUI_M_PDC("");
			}

			Object[] values3 = { getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() };
			rs3 = getHandler().executeSelectStatement(query3,
					CommonUtils.getConnection(), values3);
			if (rs3.next()) {
				M_POL_MODE_OF_PYMT = rs3.getString(1);
			}
			System.out.println("getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO(): "
					+ getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO());
			Object[] values4 = { getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID() };
			rs4 = getHandler().executeSelectStatement(query4,
					CommonUtils.getConnection(), values4);
			if (rs4.next()) {
				M_DPD_PAY_MODE = rs4.getString(1);
				M_DPD_CHQ_NO = rs4.getString(2);
				M_DPD_CHQ_DT = rs4.getDate(3);
			}

			List pValSystem1 = new DBProcedures().callP_VAL_SYSTEM(
					"IL_CHQ_DAYS", "IL_CHQ_DAYS", "N");
			if (!pValSystem1.isEmpty() && pValSystem1.get(0)!=null) {
				M_PS_CODE_DESC = pValSystem1.get(0).toString();
				M_PS_VALUE_DAYS = Double.parseDouble(pValSystem1.get(1)
						.toString());
			}

			if ("S".equalsIgnoreCase(M_POL_MODE_OF_PYMT)
					&& "N".equalsIgnoreCase(MigratingFunctions.nvl(
							getPT_IL_DEPOSIT_BEAN().getDEP_PDC_FLAG(), "Y"))) {
				if ("C".equalsIgnoreCase(M_DPD_PAY_MODE)
						&& (MigratingFunctions.nvl(M_PS_VALUE_DAYS, 0) > CommonUtils
								.subtractDate(new CommonUtils()
										.truncDate(new Date()),
										new CommonUtils()
												.truncDate(M_DPD_CHQ_DT)))) {
					getCOMP_UI_M_CHEQUE().setDisabled(true);
				} else if ("C".equalsIgnoreCase(M_DPD_PAY_MODE)
						&& (MigratingFunctions.nvl(M_PS_VALUE_DAYS, 0) <= CommonUtils
								.subtractDate(new CommonUtils()
										.truncDate(new Date()),
										new CommonUtils()
												.truncDate(M_DPD_CHQ_DT)))
						&& MigratingFunctions.nvl(M_PS_VALUE_DAYS, 0) != 0) {
					getCOMP_UI_M_CHEQUE().setDisabled(false);
				}
			}else{
				getCOMP_UI_M_CHEQUE().setDisabled(true);
			}

			if (getPT_IL_DEPOSIT_BEAN().getDEP_REPL_RCPT_YN() != null) {
				if ("N".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN()
						.getDEP_REPL_RCPT_YN())) {
					if (!getCOMP_DEP_REP_BANK_IN_SLIP_NO().isDisabled()) {
						getCOMP_DEP_REP_BANK_IN_SLIP_NO().setDisabled(true);
					}

					if (!getCOMP_DEP_REPL_TXN_CODE().isDisabled()) {
						getCOMP_DEP_REPL_TXN_CODE().setDisabled(true);
					}

					if (!getCOMP_DEP_REPL_DOC_NO().isDisabled()) {
						getCOMP_DEP_REPL_DOC_NO().setDisabled(true);
					}

					if (!getCOMP_DEP_REPL_ACC_YR().isDisabled()) {
						getCOMP_DEP_REPL_ACC_YR().setDisabled(true);
					}
				}
			}
			
			rs6 = getHandler().executeSelectStatement(Rev_query,CommonUtils.getConnection(),new Object[]{getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID()});
			if(rs6.next()){
				Rev_val = rs6.getString(1);
			}
			if("Y".equalsIgnoreCase(Rev_val)){
				getPT_IL_DEPOSIT_BEAN().setUI_M_REC_REVERSE("Reversed");
				COMP_UI_M_REC_REVERSE.setValue("Reversed");
			}else{
				getPT_IL_DEPOSIT_BEAN().setUI_M_REC_REVERSE("");
				COMP_UI_M_REC_REVERSE.setValue("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// BugId:PREMIAGDC-AGENCY- 0055 Amit Gupta 25-Feb-09]

	public void postQuery() {
		LIFELIB lifelib = new LIFELIB();
		ArrayList<OracleParameter> list;
		try {
			list = lifelib.P_VAL_DEPT(PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(),
					PT_IL_DEPOSIT_BEAN.getDEP_DEPT_CODE(), PT_IL_DEPOSIT_BEAN
							.getUI_M_DEP_DEPT_DESC(), "N", "N");

			if (list != null && !list.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DEPT_DESC((String) list.get(0)
						.getValueObject());
			}
			ArrayList<OracleParameter> list1 = lifelib.P_VAL_DIVN(
					getPT_IL_DEPOSIT_BEAN().getDEP_DIVN_CODE(),
					PT_IL_DEPOSIT_BEAN.getUI_M_DEP_DIVN_DESC(), "N", "N");
			if (list1 != null && !list1.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC((String) list1.get(0)
						.getValueObject());
			}

		} catch (ProcedureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public HtmlAjaxCommandButton getPrBt() { return prBt; }
	 * 
	 * public void setPrBt(HtmlAjaxCommandButton prBt) { this.prBt = prBt; }
	 */
	public HtmlCommandButton getPrBt() {
		return prBt;
	}

	public void setPrBt(HtmlCommandButton prBt) {
		this.prBt = prBt;
	}

	public List<SelectItem> getRcptYNList() {
		return rcptYNList;
	}

	public void setRcptYNList(List<SelectItem> rcptYNList) {
		this.rcptYNList = rcptYNList;
	}

	public List<SelectItem> getGrossNetComboList() {
		return grossNetComboList;
	}

	public void setGrossNetComboList(List<SelectItem> grossNetComboList) {
		this.grossNetComboList = grossNetComboList;
	}

	public void rcptYNListner(ValueChangeEvent event) {
		// String oldValue = (String)event.getOldValue();
		// String newValue = (String)event.getNewValue();
		// if(oldValue.equals(newValue)) {

		// }else {
		// newValue = oldValue ;
		// }

	}

	public void rcptYNSupport(ActionEvent event) {
		System.out.println("PT_IL_DEPOSIT_ACTION.rcptYNSupport() called");
		// HtmlAjaxSupport one = (HtmlAjaxSupport)event.getComponent();
		// System.out.println(one.getData().toString()+" "+one.getValue());
	}

	public void validateGROSS_NET_FLAG(FacesContext context, UIComponent comp,
			Object value) {

		String val = (String) value;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_GROSS_NET_FLAG(val);
			helper.validateDep_Gross_Net_Flag(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDEP_CONT_REF_ID2(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID2(value);
			helper.validateDep_Cont_Ref_Id2(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_CONT_REF_ID1(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID1(value);
			helper.validateDep_Cont_Ref_Id1(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_TEMP_RCPT_NO(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_TEMP_RCPT_NO(value);
			helper.validateDEP_TEMP_RCPT_NO(PT_IL_DEPOSIT_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_CUST_CODE(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_CUST_CODE(value);
			helper.validateDEP_CUST_CODE(PT_IL_DEPOSIT_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_CONT_CODE(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_CONT_CODE(value);
			helper.validateDEP_CONT_CODE(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_PROD_CODE(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_PROD_CODE(value);
			helper.validateDEP_PROD_CODE(this);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_AGENT_CODE(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_AGENT_CODE(value);
			helper.validateDEP_AGENT_CODE(PT_IL_DEPOSIT_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_REPL_RCPT_YN(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_REPL_RCPT_YN(value);
			helper.validateDEP_REPL_RCPT_YN(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void whenListChangeReplaceRcptYN(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputData = input.getSubmittedValue().toString();
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_REPL_RCPT_YN(inputData);
			helper.validateDEP_REPL_RCPT_YN(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateDEP_REP_BANK_IN_SLIP_NO(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_REP_BANK_IN_SLIP_NO(value);
			helper.validateDEP_REP_BANK_IN_SLIP_NO(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void save() throws Exception {
		getErrorMap().clear();
		getCOMP_UI_M_BUT_APPROVAL().setDisabled(false);
		String message = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map sess = context.getExternalContext().getSessionMap();
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			
			/*Added by Ram on 18/11/2016 for Save issue*/
			System.out.println("PT_IL_DEPOSIT_BEAN       "+PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT());
			if(PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() == null)
			{
				getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(true);
				
				throw new Exception("Total Paid Amount cannot be Empty");
			}
			else
			{
				getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(false);
			}
			/*End*/
			if (getPT_IL_DEPOSIT_BEAN().getROWID() == null) {
				helper.preInsert(PT_IL_DEPOSIT_BEAN);
				handler.executeInsert(PT_IL_DEPOSIT_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			} else {
				helper.preUpdate(PT_IL_DEPOSIT_BEAN);
				handler.executeUpdate(PT_IL_DEPOSIT_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}

			if (PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE() == null
					&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO() == 0
					//&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_DT() == null
					) {
				setINSERT_ALLOWED(true);
				setUPDATE_ALLOWED(true);
				setDELETE_ALLOWED(true);
				getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS("Not Approved");
				COMP_UI_M_APPRV_STATUS.setValue("Not Approved");
				calP_INS_PYMT_DTLS();
			} else if (PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE() != null
					&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO() != 0
					//&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_DT() != null
					) {
				setINSERT_ALLOWED(false);
				setUPDATE_ALLOWED(false);
				setDELETE_ALLOWED(false);
				getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS("Approved");
				COMP_UI_M_APPRV_STATUS.setValue("Approved");
			}
			// newly added by sujatha for updating the dep_pdc_flag for dpli poc tolerance
			PT_IL_DEPOSIT_BEAN.setDEP_PDC_FLAG(CommonUtils.getGlobalVariable("GLOBAL.DEP_PDC_FLAG"));
		
			/* Newly Added By Dhinesh on for ssp call id : ZBILQC-1732974 */
			helper.whenValidateBankCode(PT_IL_DEPOSIT_BEAN);
			/* End */
		
			CommonUtils.getConnection().commit();
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE_RECORD",message);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	/*	return null;*/
	}

	public String deleteRecord() {

		FacesContext context = FacesContext.getCurrentInstance();
		Map sess = context.getExternalContext().getSessionMap();
		// Connection con = (Connection)sess.get("CLIENT_CON");
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
		}

		CRUDHandler handler = new CRUDHandler();

		try {
			int i = handler.executeDelete(getPT_IL_DEPOSIT_BEAN(), con);
			con.commit();

			System.out
					.println("PT_IL_DEPOSIT_ACTION.deleteRecord() rows deleted "
							+ i);
			getErrorMap().put("current", "Record deleted");
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return null;
	}

	public String insert() {

		FacesContext context = FacesContext.getCurrentInstance();
		Map sess = context.getExternalContext().getSessionMap();
		sess.put("CURRENT_MODE", "INSERT");

		Connection con = null;

		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (con == null) {
			System.out.println("PT_IL_DEPOSIT_ACTION.insert() con null");
		}

		// Division code, Department code and Bankin code

		prepareDefaultValues();

		// TODO insert action should be there
		return "insert";
	}

	// BugId:TRACK_PREMIAGDC_GL.10.5-00180: : Fetching DB values using
	// CRUDhandler : added by Shankar B : 01-Apr-2009
	public void prepareDefaultValues() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String DEP_DIVN_CODE = CommonUtils.getControlBean().getM_DIVN_CODE();
		String DEP_DEPT_CODE = CommonUtils.getControlBean().getM_DEPT_CODE();
		String DEP_BANKIN_CODE = (String) sessionMap.get("GLOBAL.M_PARAM_12");
		getPT_IL_DEPOSIT_BEAN().setDEP_DIVN_CODE(DEP_DIVN_CODE);
		getPT_IL_DEPOSIT_BEAN().setDEP_DEPT_CODE(DEP_DEPT_CODE);
		getPT_IL_DEPOSIT_BEAN().setDEP_BANKIN_CODE(DEP_BANKIN_CODE);
		String divDescQuery = "SELECT DIVN_CODE, DIVN_NAME FROM FM_DIVISION WHERE NVL(DIVN_FRZ_FLAG, 'N') = 'N' and DIVN_CODE = ? ";
		String deptDescQuery = "SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?";
		String bankCodeDescQuery = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE BANK_CODE= ?";
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				Object[] values = { DEP_DIVN_CODE };
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(divDescQuery, connection,
						values);
				while (rst.next()) {
					getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DIVN_DESC(
							rst.getString("DIVN_NAME"));
				}
				CommonUtils.closeCursor(rst);
				Object[] values1 = { DEP_DEPT_CODE };
				rst = handler.executeSelectStatement(deptDescQuery, connection,
						values1);
				while (rst.next()) {
					getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DEPT_DESC(
							rst.getString("DEPT_NAME"));
				}
				CommonUtils.closeCursor(rst);
				Object[] values3 = { DEP_BANKIN_CODE };
				rst = handler.executeSelectStatement(bankCodeDescQuery,
						connection, values3);
				while (rst.next()) {
					getPT_IL_DEPOSIT_BEAN().setUI_M_BANKIN_NAME(
							rst.getString("BANK_NAME"));
				}
				CommonUtils.closeCursor(rst);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Commented Code : added by Shankar B : 01-Apr-2009
	/*
	 * private void prepareDefaultValues() { Map<String, Object> sessionMap =
	 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 * String DEP_DIVN_CODE =
	 * CommonUtils.getControlBean().getM_DIVN_CODE();//(String)
	 * sessionMap.get("GLOBAL.M_DIVN_CODE");
	 * getPT_IL_DEPOSIT_BEAN().setDEP_DIVN_CODE(DEP_DIVN_CODE); String
	 * divDescQuery = "SELECT DIVN_CODE, DIVN_NAME FROM PM_DIVISION WHERE
	 * NVL(DIVN_FRZ_FLAG, 'N') = 'N' and DIVN_CODE = ? "; ResultSet rs = null;
	 * try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(divDescQuery);
	 * psmt.setString(1,DEP_DIVN_CODE); rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DIVN_DESC(rs.getString("DIVN_NAME")); }
	 * }catch(Exception ex){ ex.printStackTrace(); }finally{ try {
	 * CommonUtils.closeCursor(rs); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * String DEP_DEPT_CODE =
	 * CommonUtils.getControlBean().getM_DEPT_CODE();//(String)
	 * sessionMap.get("GLOBAL.M_DEPT_CODE");
	 * getPT_IL_DEPOSIT_BEAN().setDEP_DEPT_CODE(DEP_DEPT_CODE); String
	 * deptDescQuery = "SELECT DEPT_CODE, DEPT_NAME FROM PM_DEPARTMENT WHERE
	 * DEPT_FRZ_FLAG = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE
	 * ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND
	 * ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?"; try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(deptDescQuery);
	 * psmt.setString(1,DEP_DEPT_CODE); rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DEPT_DESC(rs.getString("DEPT_NAME")); }
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 * 
	 * String DEP_BANKIN_CODE = (String) sessionMap.get("GLOBAL.M_PARAM_12");
	 * getPT_IL_DEPOSIT_BEAN().setDEP_BANKIN_CODE(DEP_BANKIN_CODE); try{ String
	 * bankCodeDescQuery = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE
	 * BANK_CODE= ?"; PreparedStatement psmt =
	 * getConnection().prepareStatement(bankCodeDescQuery); psmt.setString(1,
	 * DEP_BANKIN_CODE); rs = psmt.executeQuery(); while(rs.next()){ String
	 * UI_M_BANKIN_NAME = rs.getString("BANK_NAME");
	 * getPT_IL_DEPOSIT_BEAN().setUI_M_BANKIN_NAME(UI_M_BANKIN_NAME); } } catch
	 * (Exception e) { e.printStackTrace(); }finally{ try {
	 * CommonUtils.closeCursor(rs); } catch (Exception e) { e.printStackTrace(); } } }
	 */

	public void validateDep_Ref_No(FacesContext context, UIComponent component,
			Object value) {
		String Val = (String) value;
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_REF_NO(Val);
			helper.validateDep_Ref_No(this, compositeAction.getDUMMY_BEAN());
			helper.postQuery(compositeAction);
			chkPropConvertYn(Val);
			//COMP_DEP_REF_NO.resetValue();
			COMP_DEP_CONT_CODE.resetValue();
			COMP_DEP_CUST_CODE.resetValue();
			COMP_UI_M_POL_LC_NET_PREM.resetValue();
			COMP_DEP_CLASS_CODE.resetValue();
			COMP_DEP_DS_CODE.resetValue();
			COMP_DEP_PROD_CODE.resetValue();
			COMP_DEP_PLAN_CODE.resetValue();
			COMP_DEP_CONT_REF_ID1.resetValue();
			COMP_DEP_CONT_REF_ID2.resetValue();
			COMP_DEP_SRC_OF_BUS.resetValue();
			COMP_DEP_DEPT_CODE.resetValue();
			COMP_UI_M_CONT_NAME.resetValue();
			COMP_UI_M_CUST_NAME.resetValue();
			COMP_UI_M_DEP_PROD_CODE_DESC.resetValue();
			COMP_DEP_LC_TOTAL_AMT.resetValue();
			COMP_UI_M_POL_LC_GROSS_PREM.resetValue();
			COMP_UI_M_DEP_DIVN_DESC.resetValue();
			COMP_DEP_DIVN_CODE.resetValue();
			COMP_UI_M_DEP_DEPT_DESC.resetValue();
			COMP_UI_M_DEP_CLASS_CODE_DESC.resetValue();
			COMP_UI_M_BANKIN_NAME.resetValue();
			COMP_UI_M_DEP_PLAN_CODE_DESC.resetValue();
			COMP_UI_M_DEP_BUS_DESC.resetValue();
			COMP_DEP_BANKIN_CODE.resetValue();
			COMP_DEP_LC_DEP_AMT.resetValue();
			COMP_DEP_LC_TOT_AMT.resetValue();
			//Added by Ameen 16-8-16 for defaulting agent and agent collection code (ssp-FALCONQC-1716556 )
			COMP_DEP_AGENT_CODE.resetValue();
			COMP_DEP_COLL_AGENT_CODE.resetValue();
			COMP_UI_M_DEP_AGENT_CODE_DESC.resetValue();
			COMP_UI_M_DEP_COLL_AGENT_CODE_DESC.resetValue();
			COMP_DEP_COMM_YN.resetValue();
			
			/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
			//COMP_DEP_LC_AMT.resetValue();
			//End
			
			//End (ssp-FALCONQC-1716556 )
			COMP_DEP_FC_TOTAL_AMT.resetValue();
			/*Added by kavitha on 13.08.2018 for FLALIFEQC-1761039*/ 	
			   getPol_receipt_dtls();
			   /* End */
			 //Added by rakesh on 07-03-2020 for currency code default from policy issue
				COMP_DEP_CURR_CODE.resetValue();
				COMP_DEP_CURR_DESC.resetValue();
				//END

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void chkPropConvertYn(String refNo) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		String qouery = "select POL_CONVERT_YN from pt_il_policy where POL_NO = ? ";
		String yn = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(qouery, connection, new Object[]{refNo});
			if(resultSet.next()){
				yn = resultSet.getString(1);
			}
			if("Y".equals(yn)){
				throw new Exception("Proposal already converted to policy.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}

	public void fireFieldValidationDoc(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String populateBlockFromSearchAction() {		

		try {
			new PILT016A_APAC_PT_IL_DEPOSIT_DELEGATE()
					.executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * String refNo = PT_IL_DEPOSIT_BEAN.getDEP_REF_NO();
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() ref no
		 * "+refNo);
		 * 
		 * String query2 = "SELECT
		 * POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0),POL_SYS_ID,POL_ADDL_STATUS" + "
		 * FROM PT_IL_POLICY"+ " WHERE POL_DS_TYPE in ('1','2')"+ " AND POL_NO =
		 * '"+refNo+"'"+ " AND POL_END_NO_IDX = (SELECT MAX(POL_END_NO_IDX)" + "
		 * FROM PT_IL_POLICY WHERE POL_NO = '"+refNo+"'"+")" ;
		 * 
		 * String q3 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_DS_TYPE in
		 * ('1','2') AND POL_NO = '"+refNo+"'";
		 * 
		 * 
		 * String query4 = "SELECT
		 * POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0),POL_SYS_ID,POL_ADDL_STATUS " +
		 * "FROM PT_IL_POLICY WHERE POL_DS_TYPE in ('1','2') AND POL_NO =
		 * '"+refNo+"'";
		 * 
		 * 
		 * String query10 = "SELECT POL_CONT_CODE,POL_CUST_CODE,POL_LC_NET_PREM,
		 * POL_SYS_ID, "+ "POL_CLASS_CODE,
		 * POL_DS_CODE,POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS,POL_ASSRD_REF_ID1, "+ "
		 * POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_NET_PREM_YN,POL_STATUS, "+ "
		 * POL_MODE_OF_PYMT "+ " FROM PT_IL_POLICY WHERE POL_DS_TYPE in
		 * ('1','2') AND POL_NO = '"+refNo+"'" + " AND POL_END_NO_IDX = (SELECT
		 * MAX(POL_END_NO_IDX) FROM PT_IL_POLICY "+ " WHERE POL_NO =
		 * '"+refNo+"')";
		 * 
		 * String query6 = "SELECT POL_CONT_CODE, POL_CUST_CODE,POL_LC_NET_PREM,
		 * POL_SYS_ID, POL_CLASS_CODE, POL_DS_CODE, "+ "
		 * POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_NET_PREM_YN," + "
		 * POL_MODE_OF_PYMT FROM PT_IL_POLICY WHERE POL_DS_TYPE in ('1','2') AND " + "
		 * POL_NO = '"+refNo+"'";
		 * 
		 * String M_POL_PROP_NO = null; String DEP_GROSS_NET_FLAG = null;
		 * 
		 * String q19 = "SELECT DEP_GROSS_NET_FLAG FROM PT_IL_DEPOSIT "+ " WHERE
		 * DEP_REF_NO IN( '"+refNo+"','"+M_POL_PROP_NO+"') "+ " AND
		 * NVL(DEP_REC_REV_YN,'N')= 'N' AND ROWNUM=1 ";
		 * 
		 * String q21 = "SELECT POL_PROP_NO FROM PT_IL_POLICY WHERE POL_NO =
		 * '"+refNo+"'";
		 * 
		 * CRUDHandler handler = new CRUDHandler();
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance(); Map
		 * sessionMap = context.getExternalContext().getSessionMap(); Connection
		 * con = null; try { con = CommonUtils.getConnection(); } catch
		 * (Exception e) { }
		 * 
		 * ResultSet rs3=null; ResultSet rs21=null; ResultSet rs19=null;
		 * ResultSet rsqForPOL_SYS=null; ResultSet rsBasicPrem=null; ResultSet
		 * rs=null; ResultSet rs12=null; ResultSet rs14=null; ResultSet
		 * rs15=null;
		 * 
		 * 
		 * String M_TEMP = null; try { rs3 = handler.executeSelectStatement(q3,
		 * con); if(rs3.next()) { M_TEMP = "X"; } if(M_TEMP == null) { M_TEMP =
		 * "Y" ; } if(M_TEMP.equals("X")) { PT_IL_DEPOSIT_BEAN.setDEP_TYPE("P");
		 * }else { PT_IL_DEPOSIT_BEAN.setDEP_TYPE("Q");
		 *  }
		 * 
		 * rs21 = handler.executeSelectStatement(q21, con); if(rs21.next()) {
		 * M_POL_PROP_NO = rs21.getString("POL_PROP_NO"); } rs19 =
		 * handler.executeSelectStatement(q19, con); if(rs19.next()) {
		 * DEP_GROSS_NET_FLAG = rs19.getString("DEP_GROSS_NET_FLAG"); }
		 * if(DEP_GROSS_NET_FLAG != null) {
		 * PT_IL_DEPOSIT_BEAN.setDEP_GROSS_NET_FLAG(DEP_GROSS_NET_FLAG); //
		 * getCOMP_DEP_GROSS_NET_FLAG().setDisabled(true); }else {
		 * PT_IL_DEPOSIT_BEAN.setDEP_GROSS_NET_FLAG("G"); } double
		 * DEPOSIT_M_POL_LC_GROSS_PREM = 0.0;
		 * 
		 * String qForPOL_SYS_ID = "select POL_SYS_ID from PT_IL_POLICY where
		 * POL_NO = '"+refNo+"'"; Long polSysId = 0l;
		 * 
		 * String qForBASIC_PREM = "select POL_FC_BASIC_PREM from PT_IL_POLICY
		 * where " + "POL_SYS_ID = '"+polSysId+"'";
		 * 
		 * double M_FC_TEMP_GROSS_CONT = 0.0; double M_POL_FC_BASIC_PREM = 0.0;
		 * 
		 * rsqForPOL_SYS = handler.executeSelectStatement(qForPOL_SYS_ID, con);
		 * if(rsqForPOL_SYS.next()){ polSysId =
		 * rsqForPOL_SYS.getLong("POL_SYS_ID"); } rsBasicPrem =
		 * handler.executeSelectStatement(qForBASIC_PREM, con);
		 * if(rsBasicPrem.next()) { M_POL_FC_BASIC_PREM =
		 * rsBasicPrem.getDouble("POL_FC_BASIC_PREM"); } M_FC_TEMP_GROSS_CONT =
		 * M_POL_FC_BASIC_PREM ;
		 * 
		 * DEPOSIT_M_POL_LC_GROSS_PREM = M_FC_TEMP_GROSS_CONT ;
		 * 
		 * double M_POL_LC_NET_PREM = 0.0; M_POL_LC_NET_PREM =
		 * DEPOSIT_M_POL_LC_GROSS_PREM;
		 * 
		 * double M_POL_LC_COMMISSION = 0.0; M_POL_LC_COMMISSION =
		 * DEPOSIT_M_POL_LC_GROSS_PREM;
		 * 
		 * ControlBean cb = CommonUtils.getControlBean(); String div_code =
		 * cb.getM_DIVN_CODE(); String dept_code = cb.getM_DEPT_CODE();
		 * 
		 * //Newly added String div_code =
		 * CommonUtils.getControlBean().getM_DIVN_CODE();// (String)
		 * sessionMap.get("GLOBAL.M_DIVN_CODE"); String dept_code =
		 * CommonUtils.getControlBean().getM_DEPT_CODE();//(String)
		 * sessionMap.get("GLOBAL.M_DEPT_CODE");
		 * 
		 * 
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() login params
		 * "+div_code+" "+dept_code);
		 * 
		 * 
		 * :PT_IL_DEPOSIT.M_POL_LC_GROSS_PREM :=
		 * NVL(:PT_IL_DEPOSIT.M_POL_LC_GROSS_PREM,0);
		 * :PT_IL_DEPOSIT.M_POL_LC_NET_PREM :=
		 * NVL(:PT_IL_DEPOSIT.M_POL_LC_GROSS_PREM,0);
		 * :PT_IL_DEPOSIT.M_POL_LC_COMMISSION :=
		 * (:PT_IL_DEPOSIT.M_POL_LC_GROSS_PREM) * M_BROK_PER;
		 * :PT_IL_DEPOSIT.M_POL_LC_COMMISSION :=
		 * NVL(:PT_IL_DEPOSIT.M_POL_LC_COMMISSION,0);
		 * 
		 * 
		 * 
		 * if("Q".equals(PT_IL_DEPOSIT_BEAN.getDEP_TYPE())) {
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() QQQQQ");
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() query6
		 * "+query6);
		 * 
		 * Long M_POL_SYS_ID = 0l; rs = handler.executeSelectStatement(query6,
		 * con); while(rs.next()) { M_POL_SYS_ID = rs.getLong("POL_SYS_ID");
		 * PT_IL_DEPOSIT_BEAN.setDEP_CONT_CODE(rs.getString("POL_CONT_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CUST_CODE(rs.getString("POL_CUST_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM(rs.getDouble("POL_LC_NET_PREM"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CLASS_CODE(rs.getString("POL_CLASS_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_DS_CODE(rs.getString("POL_DS_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_PROD_CODE(rs.getString("POL_PROD_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_PLAN_CODE(rs.getString("POL_PLAN_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID1(rs.getString("POL_ASSRD_REF_ID1"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID2(rs.getString("POL_ASSRD_REF_ID2"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_SRC_OF_BUS(rs.getString("POL_SRC_OF_BUS"));
		 * 
		 * PT_IL_DEPOSIT_BEAN.setDEP_DIVN_CODE(div_code);
		 * PT_IL_DEPOSIT_BEAN.setDEP_DEPT_CODE(dept_code); }
		 * 
		 * PT_IL_DEPOSIT_BEAN.setDEP_SYS_ID_INTEGER(M_POL_SYS_ID);
		 * 
		 * String q12 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = '" +
		 * PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE()+"'";
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlockFromSearchAction()
		 * q12: "+q12);
		 * 
		 * rs12 = handler.executeSelectStatement(q12, con); if(rs12.next()) {
		 * String prod = rs12.getString("PROD_DESC");
		 * PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PROD_CODE_DESC(prod); }
		 * 
		 * String q14 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE =
		 * '"+PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE()+"'" ;
		 * 
		 * rs14 = handler.executeSelectStatement(q14, con); if(rs14.next()) {
		 * String cust = rs14.getString("CUST_NAME");
		 * PT_IL_DEPOSIT_BEAN.setUI_M_CUST_NAME(cust); }
		 * 
		 * String q15 = " SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_CODE = " + "
		 * '"+PT_IL_DEPOSIT_BEAN.getDEP_CONT_CODE()+"'";
		 * 
		 * rs15 = handler.executeSelectStatement(q15, con); if(rs15.next()) {
		 * String cont = rs15.getString("CONT_NAME");
		 * PT_IL_DEPOSIT_BEAN.setUI_M_CONT_NAME(cont); } //
		 * getCOMP_DEP_PROD_CODE().setDisabled(false);
		 *  // L_GROSS_PREM(M_POL_SYS_ID) To be done l_gross_prem (P_POL_SYS_ID
		 * IN NUMBER, P_GLOBAL_CURR_CODE IN VARCHAR2,
		 * P_PT_IL_DEPOSIT_DEP_PROD_CODE IN VARCHAR2,
		 * P_PT_IL_DEPOSIT_M_POL_LC_G_P IN OUT NUMBER,--M_POL_LC_GROSS_PREM
		 * P_PT_IL_DEPOSIT_M_POL_LC_N_P IN OUT NUMBER, -- M_POL_LC_NET_PREM,
		 * P_PT_IL_DEPOSIT_M_POL_LC_COM IN OUT NUMBER,
		 * --:PT_IL_DEPOSIT.M_POL_LC_COMMISSION P_DUMMY_M_PROD_PREM_CALC_MTHD IN
		 * OUT NUMBER-- :DUMMY.M_PROD_PREM_CALC_MTHD )
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Double TOTAL_DEP_LC_TOTAL_AMT = 0.0; TOTAL_DEP_LC_TOTAL_AMT =
		 * M_POL_LC_COMMISSION + DEPOSIT_M_POL_LC_GROSS_PREM ;
		 * 
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM(DEPOSIT_M_POL_LC_GROSS_PREM);
		 * PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(TOTAL_DEP_LC_TOTAL_AMT);
		 *  //
		 * 
		 *  } else if("P".equals(PT_IL_DEPOSIT_BEAN.getDEP_TYPE())) {
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() PPPPP");
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() query
		 * "+query10); rs = handler.executeSelectStatement(query10, con); Long
		 * M_POL_SYS_ID = 0l; while(rs.next()) { M_POL_SYS_ID =
		 * rs.getLong("POL_SYS_ID");
		 * 
		 * PT_IL_DEPOSIT_BEAN.setDEP_CONT_CODE(rs.getString("POL_CONT_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CUST_CODE(rs.getString("POL_CUST_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM(rs.getDouble("POL_LC_NET_PREM"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CLASS_CODE(rs.getString("POL_CLASS_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_DS_CODE(rs.getString("POL_DS_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_PROD_CODE(rs.getString("POL_PROD_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_PLAN_CODE(rs.getString("POL_PLAN_CODE"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID1(rs.getString("POL_ASSRD_REF_ID1"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID2(rs.getString("POL_ASSRD_REF_ID2"));
		 * PT_IL_DEPOSIT_BEAN.setDEP_SRC_OF_BUS(rs.getString("POL_SRC_OF_BUS"));
		 * 
		 * PT_IL_DEPOSIT_BEAN.setDEP_DIVN_CODE(div_code);
		 * PT_IL_DEPOSIT_BEAN.setDEP_DEPT_CODE(dept_code); }
		 * 
		 * System.out.println("M_POL_SYS_ID::"+M_POL_SYS_ID);
		 * PT_IL_DEPOSIT_BEAN.setDEP_SYS_ID_INTEGER(M_POL_SYS_ID);
		 * 
		 * System.out.println("CUST_CODE
		 * "+PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE()+" cont_code "+
		 * PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE()+" ");
		 * 
		 * String q12 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = '" +
		 * PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE()+"'";
		 * 
		 * rs12 = handler.executeSelectStatement(q12, con); if(rs12.next()) {
		 * String prod = rs12.getString("PROD_DESC");
		 * PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PROD_CODE_DESC(prod); }
		 * 
		 * String q14 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE =
		 * '"+PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE()+"'" ;
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() q14 "+q14);
		 * rs14 = handler.executeSelectStatement(q14, con); if(rs14.next()) {
		 * String cust = rs14.getString("CUST_NAME");
		 * PT_IL_DEPOSIT_BEAN.setUI_M_CUST_NAME(cust); }
		 * 
		 * String q15 = " SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_CODE = " + "
		 * '"+PT_IL_DEPOSIT_BEAN.getDEP_CONT_CODE()+"'";
		 * System.out.println("PT_IL_DEPOSIT_ACTION.populateBlock() q15 "+q15);
		 * rs15 = handler.executeSelectStatement(q15, con); if(rs15.next()) {
		 * String cont = rs15.getString("CONT_NAME");
		 * PT_IL_DEPOSIT_BEAN.setUI_M_CONT_NAME(cont); } //
		 * getCOMP_DEP_PROD_CODE().setDisabled(false);
		 *  // L_GROSS_PREM(M_POL_SYS_ID) To be done ArrayList<OracleParameter>
		 * list = L_GROSS_PREM(polSysId, sessionMap.get("GLOBAL.CURR_CODE"),
		 * PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE(),
		 * PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM(),
		 * PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_NET_PREM(),
		 * PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_COMMISSION(),null);
		 * 
		 * if (list != null && !list.isEmpty()) {
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM((Double)list.get(0).getValueObject());
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM((Double)list.get(1).getValueObject());
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_COMMISSION((Double)list.get(2).getValueObject()); }
		 * 
		 *  //
		 * getCOMP_DEP_LC_TOTAL_AMT().setSubmittedValue(String.valueOf(DEPOSIT_M_POL_LC_GROSS_PREM));
		 * double TOTAL_DEP_LC_TOTAL_AMT = 0.0; TOTAL_DEP_LC_TOTAL_AMT =
		 * M_POL_LC_COMMISSION + DEPOSIT_M_POL_LC_GROSS_PREM ;
		 * 
		 * PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM(DEPOSIT_M_POL_LC_GROSS_PREM);
		 * PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(TOTAL_DEP_LC_TOTAL_AMT);
		 *  // getCOMP_DEP_LC_TOTAL_AMT().setDisabled(false); //
		 * getCOMP_UI_M_POL_LC_GROSS_PREM().setDisabled(false);populateBlock }
		 * 
		 * setClassDescIFromSearch(PT_IL_DEPOSIT_BEAN);
		 * setPlanDescIFromSearch(PT_IL_DEPOSIT_BEAN);
		 * setDivisionDescIIFromSearch(PT_IL_DEPOSIT_BEAN);
		 * setSrcBDescIFromSearch(PT_IL_DEPOSIT_BEAN);
		 * setBankCodeDescIFromSearch(PT_IL_DEPOSIT_BEAN);
		 * setDeptDescIFromSearch(PT_IL_DEPOSIT_BEAN);
		 * 
		 * //Newly Added if(PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE()!=null &&
		 * PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO()!=0.0 &&
		 * PT_IL_DEPOSIT_BEAN.getDEP_DOC_DT()!=null) {
		 * getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS("Approved");
		 * 
		 * //COMP_UI_M_APPRV_STATUS.setValue("Approved");
		 * getPT_IL_DEPOSIT_BEAN().setApprovalStatus(true);
		 * settingFieldEnableProperty(true); }else{
		 * getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS("Not Approved"); if("Not
		 * Approved".equals(getPT_IL_DEPOSIT_BEAN().getUI_M_APPRV_STATUS())){
		 * getCOMP_UI_M_BUT_APPROVAL().setDisabled(false); }else{
		 * getCOMP_UI_M_BUT_APPROVAL().setDisabled(true); }
		 * //COMP_UI_M_APPRV_STATUS.setValue("Not Approved");
		 * getPT_IL_DEPOSIT_BEAN().setApprovalStatus(false);
		 * settingFieldEnableProperty(false); }
		 * 
		 * String query = "SELECT PD_DPD_REF_ID FROM PT_IL_PYMT_DTLS " + "WHERE
		 * PD_TXN_SYS_ID =
		 * '"+getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID_INTEGER()+"'";
		 * System.out.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() q3
		 * "+q3); String M_PD_DPD_REF_ID = null; ResultSet resultSet =
		 * handler.executeSelectStatement(query, con); if(rs3.next()) {
		 * M_PD_DPD_REF_ID = rs3.getString("PD_DPD_REF_ID");
		 *  }
		 *  } catch (Exception e) { e.printStackTrace(); }finally{
		 * 
		 * 
		 * try { CommonUtils.closeCursor(rs3); CommonUtils.closeCursor(rs21);
		 * CommonUtils.closeCursor(rs19);
		 * CommonUtils.closeCursor(rsqForPOL_SYS);
		 * CommonUtils.closeCursor(rsBasicPrem); CommonUtils.closeCursor(rs);
		 * CommonUtils.closeCursor(rs12); CommonUtils.closeCursor(rs14);
		 * CommonUtils.closeCursor(rs15); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */
		return null;
	}

	public void settingFieldEnableProperty(boolean flag) {
		HtmlInputText text1 = new HtmlInputText();
		text1.setDisabled(flag);
		setCOMP_UI_M_POL_LC_GROSS_PREM(text1);
		HtmlInputText text2 = new HtmlInputText();
		text2.setDisabled(flag);
		setCOMP_UI_M_POL_LC_COMMISSION(text2);
		HtmlInputText text3 = new HtmlInputText();
		text3.setDisabled(flag);
		setCOMP_DEP_LC_TOTAL_AMT(text3);
	}

	private void setBankCodeDescI() {
		ResultSet rs = null;
		try {
			String Bank_Code = CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_12");
			String bankCodeDescQuery = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE BANK_CODE= ?";

			System.out
					.println("PT_IL_DEPOSIT_ACTION.setBankCodeDesc() BANK_CODE "
							+ bankCodeDescQuery);

			getCOMP_DEP_BANKIN_CODE().setSubmittedValue(Bank_Code);

			PreparedStatement psmt = getConnection().prepareStatement(
					bankCodeDescQuery);
			psmt.setString(1, Bank_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				getCOMP_UI_M_BANKIN_NAME().setSubmittedValue(
						rs.getString("BANK_NAME"));
				getPT_IL_DEPOSIT_BEAN().setUI_M_BANKIN_NAME(
						rs.getString("BANK_NAME"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setBankCodeDescIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		ResultSet rs = null;
		try {
			String Bank_Code = CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_12");
			String bankCodeDescQuery = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE BANK_CODE= ?";

			System.out
					.println("PT_IL_DEPOSIT_ACTION.setBankCodeDesc() BANK_CODE "
							+ bankCodeDescQuery);

			PT_IL_DEPOSIT_BEAN.setDEP_BANKIN_CODE(Bank_Code);

			PreparedStatement psmt = getConnection().prepareStatement(
					bankCodeDescQuery);
			psmt.setString(1, Bank_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_BANKIN_NAME(rs
						.getString("BANK_NAME"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setClassDescI() {
		String classCodeDescQuery = "SELECT CLASS_CODE, CLASS_NAME  FROM PM_IL_CLASS WHERE CLASS_FRZ_FLAG = 'N'AND CLASS_CODE=?";
		if (getCOMP_DEP_CLASS_CODE().getSubmittedValue() != null) {
			String Class_Code = getCOMP_DEP_CLASS_CODE().getSubmittedValue()
					.toString();
			ResultSet rs = null;
			try {
				PreparedStatement psmt = getConnection().prepareStatement(
						classCodeDescQuery);
				psmt.setString(1, Class_Code);
				rs = psmt.executeQuery();
				while (rs.next()) {
					getCOMP_UI_M_DEP_CLASS_CODE_DESC().setSubmittedValue(
							rs.getString("CLASS_NAME"));
					getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_CLASS_CODE_DESC(
							rs.getString("CLASS_NAME"));
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					CommonUtils.closeCursor(rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void setClassDescIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		String classCodeDescQuery = "SELECT CLASS_CODE, CLASS_NAME  FROM PM_IL_CLASS WHERE CLASS_FRZ_FLAG = 'N'AND CLASS_CODE=?";
		String Class_Code = PT_IL_DEPOSIT_BEAN.getDEP_CLASS_CODE();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					classCodeDescQuery);
			psmt.setString(1, Class_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_CLASS_CODE_DESC(rs
						.getString("CLASS_NAME"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setPlanDescI() {
		String coverCodeDescQuery = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER WHERE COVER_TYPE IN('B') AND COVER_CODE=?";
		String Cover_Code = getCOMP_DEP_PLAN_CODE().getSubmittedValue()
				.toString();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					coverCodeDescQuery);
			psmt.setString(1, Cover_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				getCOMP_UI_M_DEP_PLAN_CODE_DESC().setSubmittedValue(
						rs.getString("COVER_DESC"));
				getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_PLAN_CODE_DESC(
						rs.getString("COVER_DESC"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setPlanDescIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		String coverCodeDescQuery = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER WHERE COVER_TYPE IN('B') AND COVER_CODE=?";
		String Cover_Code = PT_IL_DEPOSIT_BEAN.getDEP_PLAN_CODE();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					coverCodeDescQuery);
			psmt.setString(1, Cover_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PLAN_CODE_DESC("COVER_DESC");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// BugId:TRACK_PREMIAGDC_GL.10.5-00180: : Fetching DB values using
	// CRUDhandler : added by Shankar B : 01-Apr-2009
	public void setDivisionDescI() {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> arrayList = new ArrayList<String>();
		if (getCOMP_DEP_DIVN_CODE().getSubmittedValue() != null) {
			String DIVN_CODE = getCOMP_DEP_DIVN_CODE().getSubmittedValue()
					.toString();
			try {
				arrayList = procedures.callP_VAL_DIVN(DIVN_CODE, "N", "E");
				if (arrayList != null && arrayList.size() > 0) {
					getCOMP_UI_M_DEP_DIVN_DESC().setSubmittedValue(
							arrayList.get(0));
					getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DIVN_DESC(
							arrayList.get(0));
					COMP_UI_M_DEP_DIVN_DESC.resetValue();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * private void setDivisionDescI() { String divDescQuery = "SELECT
	 * DIVN_CODE, DIVN_NAME FROM PM_DIVISION WHERE NVL(DIVN_FRZ_FLAG, 'N') = 'N'
	 * and DIVN_CODE = ? ";
	 * if(getCOMP_DEP_DIVN_CODE().getSubmittedValue()!=null) { String DIVN_CODE =
	 * getCOMP_DEP_DIVN_CODE().getSubmittedValue().toString(); ResultSet rs =
	 * null; try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(divDescQuery);
	 * psmt.setString(1,DIVN_CODE); rs = psmt.executeQuery(); while(rs.next()){
	 * getCOMP_UI_M_DEP_DIVN_DESC().setSubmittedValue(rs.getString("DIVN_NAME"));
	 * getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DIVN_DESC(rs.getString("DIVN_NAME")); }
	 * 
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }finally{ try {
	 * CommonUtils.closeCursor(rs); } catch (Exception e) { e.printStackTrace(); } } } }
	 */

	private void setDivisionDescIIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		String divDescQuery = "SELECT DIVN_CODE, DIVN_NAME FROM FM_DIVISION WHERE NVL(DIVN_FRZ_FLAG, 'N') = 'N' and DIVN_CODE = ? ";
		String DIVN_CODE = PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE();
		ResultSet rst = null;

		Connection connection = null;
		CRUDHandler handler = null;

		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				handler = new CRUDHandler();
				Object[] values = { DIVN_CODE };
				rst = handler.executeSelectStatement(divDescQuery, connection,
						values);
				while (rst.next()) {
					PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC(rst
							.getString("DIVN_NAME"));
					if (COMP_UI_M_DEP_DIVN_DESC == null) {
						COMP_UI_M_DEP_DIVN_DESC = new HtmlInputText();
					}
					COMP_UI_M_DEP_DIVN_DESC.resetValue();
				}
			}
		} catch (DBException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * try{ PreparedStatement psmt =
		 * getConnection().prepareStatement(divDescQuery);
		 * psmt.setString(1,DIVN_CODE); rst = psmt.executeQuery();
		 * while(rst.next()){
		 * PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC(rst.getString("DIVN_NAME")); }
		 * }catch(Exception ex){ ex.printStackTrace(); }
		 */
		finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * private void setDivisionDescIIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN ){
	 * String divDescQuery = "SELECT DIVN_CODE, DIVN_NAME FROM PM_DIVISION WHERE
	 * NVL(DIVN_FRZ_FLAG, 'N') = 'N' and DIVN_CODE = ? "; String DIVN_CODE =
	 * PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(); ResultSet rs = null;
	 * 
	 * try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(divDescQuery);
	 * psmt.setString(1,DIVN_CODE); rs = psmt.executeQuery(); while(rs.next()){
	 * PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC(rs.getString("DIVN_NAME")); }
	 * 
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }finally{ try {
	 * CommonUtils.closeCursor(rs); } catch (Exception e) { e.printStackTrace(); } }
	 *  }
	 */

	private void setDeptDescI() {
		String deptDescQuery = "SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?";
		String DEPT_CODE = getCOMP_DEP_DEPT_CODE().getSubmittedValue()
				.toString();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					deptDescQuery);
			psmt.setString(1, DEPT_CODE);
			rs = psmt.executeQuery();
			while (rs.next()) {
				getCOMP_UI_M_DEP_DEPT_DESC().setSubmittedValue(
						rs.getString("DEPT_NAME"));
				getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_DEPT_DESC(
						rs.getString("DEPT_NAME"));
			}
			getCOMP_UI_M_DEP_DEPT_DESC().setDisabled(false);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setDeptDescIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		String deptDescQuery = "SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?";
		String DEPT_CODE = PT_IL_DEPOSIT_BEAN.getDEP_DEPT_CODE();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					deptDescQuery);
			psmt.setString(1, DEPT_CODE);
			rs = psmt.executeQuery();
			while (rs.next()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DEPT_DESC(rs
						.getString("DEPT_NAME"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setSrcBDescI() {
		String srcDescQuery = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE=?";

		String srcBusiness_Code = getCOMP_DEP_SRC_OF_BUS().getSubmittedValue()
				.toString();
		System.out.println("srcBusiness_Code" + srcBusiness_Code);
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					srcDescQuery);
			psmt.setString(1, srcBusiness_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println("PCDESC++++++++++++++"
						+ rs.getString("PC_DESC"));
				getCOMP_UI_M_DEP_BUS_DESC().setSubmittedValue(
						rs.getString("PC_DESC"));
				getPT_IL_DEPOSIT_BEAN().setUI_M_DEP_BUS_DESC(
						rs.getString("PC_DESC"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setSrcBDescIFromSearch(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) {
		String srcDescQuery = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE=?";

		String srcBusiness_Code = PT_IL_DEPOSIT_BEAN.getDEP_SRC_OF_BUS();
		System.out.println("srcBusiness_Code" + srcBusiness_Code);
		ResultSet rs = null;
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					srcDescQuery);
			psmt.setString(1, srcBusiness_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println("PCDESC++++++++++++++"
						+ rs.getString("PC_DESC"));
				PT_IL_DEPOSIT_BEAN
						.setUI_M_DEP_BUS_DESC(rs.getString("PC_DESC"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// SENTHIL CODES MERGED

	public Connection getConnection() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map sess = context.getExternalContext().getSessionMap();
		// Connection con = (Connection)sess.get("CLIENT_CON");
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("PT_IL_DEPOSIT_ACTION.getConnection() - Unable to obtain connection");
		}

		return con;
	}
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List LovAction_division(Object event) {
		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_DIVN_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}
	/**
	 * 
	 * @param context
	 * @param component
	 * @param object
	 */
	public void validateDivisionCode(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_DIVN_CODE(value);
			DBProcedures procedures = new DBProcedures();
			procedures.P_VAL_DIVN(PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(), 
					null, "N", "E");
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<LovBean>  LovAction_department(Object event) {

		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_DEPT_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(), PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(), null,
					null, null, (String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param object
	 */
	public void validateDepartmentCode(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_DEPT_CODE(value);
			helper.validateDEP_DEPT_CODE(PT_IL_DEPOSIT_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<LovBean> LovAction_classCode(Object object) {

		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_CLASS_CODE", null, null, null,
					null, null, (String) object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}

	public List<LovBean> LovAction_bankCode(Object object) {
		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_BANKIN_CODE", null, null, null,
					null, null, (String) object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param object
	 */
	
	 public void validateBankCode(FacesContext facesContext,
	    		UIComponent component, Object value) throws ValidatorException {
	    	CommonUtils.clearMaps(this);
	    	try {
	    		PT_IL_DEPOSIT_BEAN.setDEP_BANKIN_CODE((String) value);
				helper.whenValidateBankCode(PT_IL_DEPOSIT_BEAN);
	    	} catch (Exception exception) {
	    		exception.printStackTrace();
	    		throw new ValidatorException(new FacesMessage(exception
	    				.getMessage()));
	    	} finally {
	    		try {
	    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
	    					.getConnection(), "DEP_BANKIN_CODE", getWarningMap());
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }

	public List<LovBean> LovAction_planCode(Object object) {
		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_DEPT_CODE", CommonUtils.getControlBean().getM_COMP_CODE(), PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(), null,
					null, null, (String) object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param object
	 */
	public void validatePlanCode(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			helper.validateDEP_PLAN_CODE(this);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<LovBean> LovAction_srcOfBusiness(Object object) {

		suggesionList = new ArrayList<LovBean>();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_SRC_OF_BUS", "SRC_BUS_TY", null, null,
					null, null, (String) object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}
	
	public void validateSrcOfBusinessCode(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			helper.validateDEP_SRC_OF_BUS(PT_IL_DEPOSIT_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List suggestionList_division(String query) {
		List lovList = new ArrayList();
		Connection con = getConnection();
		System.out
				.println("PT_IL_DEPOSIT_ACTION.suggestionList_division() called "
						+ query);
		if (con != null) {
			System.out.println("con not null");
		}
		ResultSet rs = null;

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				PT_IL_DEPOSIT_DIVISION lovbox = new PT_IL_DEPOSIT_DIVISION();

				lovbox.setDIVN_CODE(rs.getString(1));
				lovbox.setDIVN_NAME(rs.getString(2));
				lovList.add(lovbox);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;

	}

	public List suggestionList_department(String query) {
		List lovList = new ArrayList();
		Connection con = getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				PT_IL_DEPOSIT_DEPARTMENT lovbox = new PT_IL_DEPOSIT_DEPARTMENT();

				lovbox.setDEPT_CODE(rs.getString(1));
				lovbox.setDEPT_NAME(rs.getString(2));
				lovList.add(lovbox);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;

	}

	public List suggestionList_classCode(String query) {
		List lovList = new ArrayList();
		Connection con = getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				PT_IL_DEPOSIT_CLASSCODE lovbox = new PT_IL_DEPOSIT_CLASSCODE();

				lovbox.setCLASS_CODE(rs.getString(1));
				lovbox.setCLASS_NAME(rs.getString(2));
				lovList.add(lovbox);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;

	}
	
	public String backToSearch(){
		/*Modified by Sivarajan on 08/11/2020 for ALliance IL*/
		String outCome = SearchConstants.BACK_TO_SEARCH_PAGE;
		try{
			String todmsworkflow=CommonUtils.getGlobalVariable("backValue");
			if(!"".equals(todmsworkflow)&&todmsworkflow!=null)
			{
				outCome=todmsworkflow;
				CommonUtils.setGlobalVariable("backValue", "");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return  outCome;
		/*End*/
	}

	public List suggestionList_bankCode(String query) {
		List lovList = new ArrayList();
		Connection con = getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				PT_IL_DEPOSIT_BANKCODE lovbox = new PT_IL_DEPOSIT_BANKCODE();
				lovbox.setBANK_CODE(rs.getString(1));
				lovbox.setBANK_NAME(rs.getString(2));
				lovList.add(lovbox);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;

	}

	public List suggestionList_planCode(String query) {
		List lovList = new ArrayList();
		Connection con = getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				PT_IL_DEPOSIT_COVERCODE lovbox = new PT_IL_DEPOSIT_COVERCODE();
				lovbox.setCOVER_CODE(rs.getString(1));
				lovbox.setCOVER_DESC(rs.getString(2));
				lovList.add(lovbox);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;

	}

	public List suggestionList_srcOfBusiness(String query) {

		List lovList = new ArrayList();
		Connection con = getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				PT_IL_DEPOSIT_SRCBUSINESS lovbox = new PT_IL_DEPOSIT_SRCBUSINESS();
				lovbox.setPC_CODE(rs.getString(1));
				lovbox.setPC_DESC(rs.getString(2));
				lovList.add(lovbox);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;

	}

	/*
	 * public void setDivisionDesc(ActionEvent event){
	 * 
	 * String divDescQuery = "SELECT DIVN_CODE, DIVN_NAME FROM PM_DIVISION WHERE
	 * NVL(DIVN_FRZ_FLAG, 'N') = 'N' and DIVN_CODE = ? "; UIInput input =
	 * (UIInput) event.getComponent().getParent(); String DIVN_CODE = (String)
	 * input.getSubmittedValue();
	 * 
	 * try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(divDescQuery);
	 * psmt.setString(1,DIVN_CODE); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getCOMP_UI_M_DEP_DIVN_DESC().setSubmittedValue(rs.getString("DIVN_NAME")); }
	 * getCOMP_UI_M_DEP_DIVN_DESC().setDisabled(false);
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 * 
	 *  }
	 * 
	 * public void setDepartmentDesc(ActionEvent event){
	 * 
	 * String deptDescQuery = "SELECT DEPT_CODE, DEPT_NAME FROM PM_DEPARTMENT
	 * WHERE DEPT_FRZ_FLAG = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP
	 * WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND
	 * ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?"; UIInput input = (UIInput)
	 * event.getComponent().getParent(); String DEPT_CODE = (String)
	 * input.getSubmittedValue();
	 * 
	 * try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(deptDescQuery);
	 * psmt.setString(1,DEPT_CODE); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getCOMP_UI_M_DEP_DEPT_DESC().setSubmittedValue(rs.getString("DEPT_NAME")); }
	 * getCOMP_UI_M_DEP_DEPT_DESC().setDisabled(false);
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 *  }
	 * 
	 * public void setClassCodeDesc(ActionEvent event){ String
	 * classCodeDescQuery = "SELECT CLASS_CODE, CLASS_NAME FROM PM_IL_CLASS
	 * WHERE CLASS_FRZ_FLAG = 'N'AND CLASS_CODE=?"; UIInput input = (UIInput)
	 * event.getComponent().getParent(); String Class_Code =
	 * (String)input.getSubmittedValue(); try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(classCodeDescQuery);
	 * psmt.setString(1,Class_Code); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getCOMP_UI_M_DEP_CLASS_CODE_DESC().setSubmittedValue(rs.getString("CLASS_NAME")); }
	 * getCOMP_UI_M_DEP_CLASS_CODE_DESC().setDisabled(false);
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 *  }
	 * 
	 * 
	 * public void setBankCodeDesc(ActionEvent event){ String bankCodeDescQuery =
	 * "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE BANK_CODE=?"; UIInput
	 * input = (UIInput) event.getComponent().getParent(); String Bank_Code =
	 * (String)input.getSubmittedValue(); try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(bankCodeDescQuery);
	 * psmt.setString(1,Bank_Code); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getCOMP_UI_M_BANKIN_NAME().setSubmittedValue(rs.getString("BANK_NAME")); }
	 * getCOMP_UI_M_BANKIN_NAME().setDisabled(false);
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 *  }
	 * 
	 * public void setPlanCodeDesc(ActionEvent event){ String coverCodeDescQuery =
	 * "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER WHERE COVER_TYPE IN('B')
	 * AND COVER_CODE=?"; UIInput input = (UIInput)
	 * event.getComponent().getParent(); String Cover_Code =
	 * (String)input.getSubmittedValue(); try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(coverCodeDescQuery);
	 * psmt.setString(1,Cover_Code); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){
	 * getCOMP_UI_M_DEP_PLAN_CODE_DESC().setSubmittedValue(rs.getString("COVER_DESC")); }
	 * getCOMP_UI_M_DEP_PLAN_CODE_DESC().setDisabled(false);
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 *  }
	 * 
	 * public void setSrcBusinessDesc(ActionEvent event){
	 * System.out.println("PT_IL_DEPOSIT_ACTION.setSrcBusinessDesc()"); String
	 * srcDescQuery = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE=?";
	 * UIInput input = (UIInput) event.getComponent().getParent(); String
	 * srcBusiness_Code = (String)input.getSubmittedValue();
	 * System.out.println("srcBusiness_Code" + srcBusiness_Code); try{
	 * PreparedStatement psmt = getConnection().prepareStatement(srcDescQuery);
	 * psmt.setString(1,srcBusiness_Code); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ System.out.println("PCDESC++++++++++++++" +
	 * rs.getString("PC_DESC"));
	 * getCOMP_UI_M_DEP_BUS_DESC().setSubmittedValue(rs.getString("PC_DESC")); }
	 * getCOMP_UI_M_DEP_BUS_DESC().setDisabled(false);
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 *  }
	 */
	// BugId:TRACK_PREMIAGDC_GL.10.5-00180: : Fetching DB values using
	// CRUDhandler : added by Shankar B : 01-Apr-2009
	public void setDivisionDesc(ActionEvent event) {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> arrayList = new ArrayList<String>();
		String DIVN_CODE = (String) getCOMP_DEP_DIVN_CODE().getSubmittedValue();
		try {
			arrayList = procedures.callP_VAL_DIVN(DIVN_CODE, "N", "E");
			if (arrayList != null && arrayList.size() > 0) {
				getCOMP_UI_M_DEP_DIVN_DESC()
						.setSubmittedValue(arrayList.get(0));
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC(arrayList.get(0));
				COMP_UI_M_DEP_DIVN_DESC.resetValue();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void setDivisionDesc(ActionEvent event){
	 * 
	 * String divDescQuery = "SELECT DIVN_CODE, DIVN_NAME FROM PM_DIVISION WHERE
	 * NVL(DIVN_FRZ_FLAG, 'N') = 'N' and DIVN_CODE = ? "; //UIInput input =
	 * (UIInput) event.getComponent().getParent();
	 * 
	 * String DIVN_CODE = (String)getCOMP_DEP_DIVN_CODE().getSubmittedValue();
	 * //String DIVN_CODE = (String) input.getSubmittedValue(); ResultSet rs =
	 * null; try{ PreparedStatement psmt =
	 * getConnection().prepareStatement(divDescQuery);
	 * psmt.setString(1,DIVN_CODE); rs = psmt.executeQuery(); while(rs.next()){
	 * getCOMP_UI_M_DEP_DIVN_DESC().setSubmittedValue(rs.getString("DIVN_NAME")); }
	 * 
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); } finally{ try {
	 * CommonUtils.closeCursor(rs); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 *  }
	 */

	public void setDepartmentDesc(ActionEvent event) {

		String deptDescQuery = "SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE = ?";
		// UIInput input = (UIInput) event.getComponent().getParent();
		// String DEPT_CODE = (String) input.getSubmittedValue();
		ResultSet rs = null;

		String DEPT_CODE = (String) getCOMP_DEP_DEPT_CODE().getSubmittedValue();
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					deptDescQuery);
			psmt.setString(1, DEPT_CODE);
			rs = psmt.executeQuery();
			while (rs.next()) {
				getCOMP_UI_M_DEP_DEPT_DESC().setSubmittedValue(
						rs.getString("DEPT_NAME"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void setClassCodeDesc(FacesContext context, UIComponent component,
			Object object) {

		String value = (String) object;
		try {

			PT_IL_DEPOSIT_BEAN.setDEP_CLASS_CODE(value);
			PT_IL_DEPOSIT_BEAN.setUI_M_DEP_CLASS_CODE_DESC(helper
					.ValidateClassCode(value));
			COMP_UI_M_DEP_CLASS_CODE_DESC.resetValue();
		} catch (Exception ex) {
			throw new ValidatorException(new FacesMessage(ex.getMessage()));
		}

	}

	public void setBankCodeDesc(FacesContext context, UIComponent component,
			Object object) {
		String value = (String) object;
		String bankCodeDescQuery = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE BANK_CODE=?";
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_BANKIN_CODE(value);
			PT_IL_DEPOSIT_BEAN.setUI_M_BANKIN_NAME(helper
					.validateBankcode(value));
			COMP_UI_M_BANKIN_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void setPlanCodeDesc(FacesContext context, UIComponent component,
			Object object) {
		String value = (String) object;
		String coverCodeDescQuery = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER WHERE COVER_TYPE IN('B') AND COVER_CODE=?";
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_PLAN_CODE(value);
			PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PLAN_CODE_DESC(helper
					.validatPlanCode(value));
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void setSrcBusinessDesc(ActionEvent event) {
		System.out.println("PT_IL_DEPOSIT_ACTION.setSrcBusinessDesc()");
		String srcDescQuery = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE=?";
		// UIInput input = (UIInput) event.getComponent().getParent();

		// String srcBusiness_Code = (String)input.getSubmittedValue();
		String srcBusiness_Code = (String) getCOMP_DEP_SRC_OF_BUS()
				.getSubmittedValue();

		ResultSet rs = null;
		// System.out.println("srcBusiness_Code" + srcBusiness_Code);
		try {
			PreparedStatement psmt = getConnection().prepareStatement(
					srcDescQuery);
			psmt.setString(1, srcBusiness_Code);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println("PCDESC++++++++++++++"
						+ rs.getString("PC_DESC"));
				getCOMP_UI_M_DEP_BUS_DESC().setSubmittedValue(
						rs.getString("PC_DESC"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> LovAction_DEP_REF_NO(Object event) {
		suggesionList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String M_REF_ID1 = null;
		String M_REF_ID2 = null;
		try {
			if(PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1() ==null &&
					PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2()==null){
				M_REF_ID1 = CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1(), "");
				M_REF_ID2 = CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2(), "");
			}else{
				M_REF_ID1 = CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1(), "");
				M_REF_ID2 = CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2(), "");
			}
			suggesionList = itemUtil.P_CALL_LOV("PILT016A_APAC", "PT_IL_DEPOSIT",
					"DEP_REF_NO", M_REF_ID1, M_REF_ID2, PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE(), null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggesionList;
	}

	List<LovBean> lovList = new ArrayList<LovBean>();

	public List<LovBean> LovAction_DEP_CUST_CODE(Object object) throws Exception {

		Connection con = null;
		con = CommonUtils.getConnection();
		
		/*
		 * 
		 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE ( CUST_CODE LIKE ? "+
			  " OR CUST_NAME LIKE ? ) AND ROWNUM <20 ORDER BY CUST_CODE";*/
		
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE ( UPPER(CUST_CODE) LIKE UPPER(?) "+
				  " OR UPPER(CUST_NAME) LIKE UPPER(?) ) AND ROWNUM <20 ORDER BY CUST_CODE";
		 /*end*/
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String currentValue= (String)object;
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			
		lovList =	ListItemUtil.prepareSuggestionList(query, new Object[]{currentValue,currentValue});
			/*rs = handler.executeSelectStatement(query, con, new Object[]{currentValue,currentValue});
			while (rs.next()) {
				LOVForDEP_CUST_CODE bean = new LOVForDEP_CUST_CODE();
				bean.setCUST_CODE(rs.getString("CUST_CODE"));
				bean.setCUST_NAME(rs.getString("CUST_NAME"));
				lovList.add(bean);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;
	}

	/*public String setCustName() {
		String cust_code = getCOMP_DEP_CUST_CODE().getSubmittedValue()
				.toString();
		String cust_name = null;
		Iterator<LovBean> itr = lovList.iterator();
		while (itr.hasNext()) {
			LovBean bean = itr.next();
			if (bean.getCUST_CODE().equals(cust_code)) {
				cust_name = bean.getCUST_NAME();
			}
		}
		getCOMP_UI_M_CUST_NAME().setSubmittedValue(cust_name);
		System.out.println("PT_IL_DEPOSIT_ACTION.setCustName() " + cust_code
				+ " " + cust_name);
		return null;
	}*/

	public void populateUI_M_CUST_NAME(PT_IL_DEPOSIT bean) {
		String custCode = bean.getDEP_CUST_CODE();
	}

	List<LOVForDEP_CONT_CODE> lovList_CONT_CODE = new ArrayList<LOVForDEP_CONT_CODE>();

	public List<LOVForDEP_CONT_CODE> LovAction_DEP_CONT_CODE(Object event) {

		String textEntered = event.toString();
		/*
		 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String query ="SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR WHERE  CONT_FRZ_FLAG = 'N' AND ROWNUM <25 "
			+ " AND ( CONT_CODE LIKE  ? OR CONT_NAME LIKE ? ) ";;*/
		
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		String query ="SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR WHERE  CONT_FRZ_FLAG = 'N' AND ROWNUM <25 "
				+ " AND ( UPPER(CONT_CODE) LIKE  UPPER(?) OR UPPER(CONT_NAME) LIKE UPPER(?) ) ";
		/*end*/

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		try {
			textEntered = "*".equals(textEntered)? "%" : textEntered+ "%";
			rs = handler.executeSelectStatement(query, con , new Object[]{textEntered,textEntered});
			while (rs.next()) {
				LOVForDEP_CONT_CODE bean = new LOVForDEP_CONT_CODE();
				bean.setCONT_CODE(rs.getString("CONT_CODE"));
				bean.setCONT_NAME(rs.getString("CONT_NAME"));
				lovList_CONT_CODE.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList_CONT_CODE;

	}

	public String setContName() {
		String code = getCOMP_DEP_CONT_CODE().getSubmittedValue().toString();

		String cont_name = null;
		Iterator<LOVForDEP_CONT_CODE> itr = lovList_CONT_CODE.iterator();
		while (itr.hasNext()) {
			LOVForDEP_CONT_CODE bean = itr.next();
			if (bean.getCONT_CODE().equals(code)) {
				cont_name = bean.getCONT_NAME();
			}
		}

		getCOMP_UI_M_CONT_NAME().setSubmittedValue(cont_name);
		System.out.println("PT_IL_DEPOSIT_ACTION.setContName()");
		return null;
	}

	List<LOVForDEP_PROD_CODE> lovListPROD_CODE = new ArrayList<LOVForDEP_PROD_CODE>();

	public List<LOVForDEP_PROD_CODE> LovAction_DEP_PROD_CODE(Object event) {
		String query = null;
		String text = event.toString();
		if ("*".equals(text)) {
			query = "select PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT where  PROD_CODE IS NOT NULL";
		} else {
			/*
			 * 
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * query = "select PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT where  PROD_CODE IS NOT NULL and PROD_CODE LIKE '"
					+ text + "'";*/
			
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			query = "select PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT where  PROD_CODE IS NOT NULL and UPPER(PROD_CODE) LIKE UPPER('"
					+ text + "')";
			/*end*/
		}
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(query, con);
			while (rs.next()) {
				LOVForDEP_PROD_CODE bean = new LOVForDEP_PROD_CODE();
				bean.setPROD_CODE(rs.getString("PROD_CODE"));
				bean.setPROD_DESC(rs.getString("PROD_DESC"));
				lovListPROD_CODE.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovListPROD_CODE;
	}

	public String setProdDesc() {
		String code = getCOMP_DEP_PROD_CODE().getSubmittedValue().toString();
		try {
			String prod_desc = null;
			Iterator<LOVForDEP_PROD_CODE> itr = lovListPROD_CODE.iterator();
			while (itr.hasNext()) {
				LOVForDEP_PROD_CODE bean = itr.next();
				if (bean.getPROD_CODE().equals(code)) {
					prod_desc = bean.getPROD_DESC();

				}
			}
			getCOMP_UI_M_DEP_PROD_CODE_DESC().setSubmittedValue(prod_desc);
			getCOMP_DEP_PROD_CODE().setSubmittedValue(code);

			PT_IL_DEPOSIT_BEAN.setDEP_PROD_CODE(code);
			PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PROD_CODE_DESC(prod_desc);
			System.out.println("PT_IL_DEPOSIT_ACTION.setProdDesc()");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	List<LOVForAGENT_CODE> lovList_AGENT = new ArrayList<LOVForAGENT_CODE>();

	public List LovAction_DEP_AGENT_CODE(Object event) {
		String text = event.toString();
		String query = null;
		if ("*".equals(text)) {
			query = "select cust_code,cust_name from pm_customer where rownum < 30";
		} else {
			/*
			 * 
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * 
			 * query = "select cust_code,cust_name from pm_customer where  cust_code like '"
					+ text + "' and rownum < 30";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			query = "select cust_code,cust_name from pm_customer where  upper(cust_code) like upper('"
					+ text + "') and rownum < 30";
			/*end*/
		}
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		CRUDHandler handler = new CRUDHandler();
		try {
			ResultSet rs = handler.executeSelectStatement(query, con);
			while (rs.next()) {
				LOVForAGENT_CODE bean = new LOVForAGENT_CODE();
				bean.setCUST_CODE(rs.getString("CUST_CODE"));
				bean.setCUST_NAME(rs.getString("CUST_NAME"));
				lovList_AGENT.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lovList_AGENT;
	}

	public String setCustName_AGENT() {
		String code = getCOMP_DEP_AGENT_CODE().getSubmittedValue().toString();

		String cust_name = null;
		Iterator<LOVForAGENT_CODE> itr = lovList_AGENT.iterator();
		while (itr.hasNext()) {
			LOVForAGENT_CODE bean = itr.next();
			if (bean.getCUST_CODE().equals(code)) {
				cust_name = bean.getCUST_NAME();
			}
		}
		getCOMP_UI_M_DEP_AGENT_CODE_DESC().setSubmittedValue(cust_name);

		System.out.println("PT_IL_DEPOSIT_ACTION.setCustName_AGENT()");

		return null;
	}

	List<LOVForCOLL_AGENT> lovListCOLL_AGENT = new ArrayList<LOVForCOLL_AGENT>();

	public List<LOVForCOLL_AGENT> LovAction_DEP_COLL_AGENT_CODE(Object event) {

		String text = event.toString();
		String query = null;

		if ("*".equals(text)) {
			// whereclause = where CUST_CLASS IN (SELECT CCLAS_CODE FROM
			// PM_CUST_CLASS, PP_SYSTEM WHERE DECODE (PS_VALUE,2,CCLAS_CODE,
			// CCLAS_TYPE)IN (null) AND PS_CODE = null AND PS_TYPE ='LOV_CUST')
			// AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE
			// FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL (null,
			// CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N'))OR
			// (CUST_APPL_ALL_BRAN_YN = 'Y'))
			query = "select cust_code, cust_name from pm_customer where rownum < 30";
		} else {
			/*
			 * 
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * query = "select cust_code, cust_name from pm_customer where rownum < 30 and cust_code like '"
					+ text + "'";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			query = "select cust_code, cust_name from pm_customer where rownum < 30 and upper(cust_code) like upper('"
					+ text + "')";
			/*end*/
		}

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			rs = handler.executeSelectStatement(query, con);
			while (rs.next()) {
				LOVForCOLL_AGENT bean = new LOVForCOLL_AGENT();
				bean.setCUST_CODE(rs.getString("CUST_CODE"));
				bean.setCUST_NAME(rs.getString("CUST_NAME"));
				lovListCOLL_AGENT.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovListCOLL_AGENT;

	}

	public String setCustName_COLL_AGENT() {

		String code = getCOMP_DEP_COLL_AGENT_CODE().getSubmittedValue()
				.toString();
		System.out
				.println("PT_IL_DEPOSIT_ACTION.setCustName_COLL_AGENT() code "
						+ code);
		String cust_name = null;
		Iterator<LOVForCOLL_AGENT> itr = lovListCOLL_AGENT.iterator();
		while (itr.hasNext()) {
			LOVForCOLL_AGENT bean = itr.next();
			if (bean.getCUST_CODE().equals(code)) {
				cust_name = bean.getCUST_NAME();
			}
		}
		getCOMP_UI_M_DEP_COLL_AGENT_CODE_DESC().setSubmittedValue(cust_name);
		System.out.println("PT_IL_DEPOSIT_ACTION.setCustName_COLL_AGENT() "
				+ cust_name);

		return null;
	}

	public String goToPaymentDetailsBlock() {
		String TXN_TYPE = null;
		this.getClass();

		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		String outcome = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		try {

			String dep_type = PT_IL_DEPOSIT_BEAN.getDEP_TYPE();
			if ("Q".equalsIgnoreCase(dep_type)
					&& (PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() > 0)) {
				TXN_TYPE = "QD";
			} else if ("P".equalsIgnoreCase(dep_type)
					&& (PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() > 0)) {
				TXN_TYPE = "PD";
			} else if (("P".equalsIgnoreCase(dep_type) || "Q"
					.equalsIgnoreCase(dep_type))
					&& PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() < 0) {
				TXN_TYPE = "DR";
			}
			/*added by raja on 04-07-2017*/
			
			/*Modified by Janani on 02.02.2018 for ZBLIFE-1456608 */
			
			/*else if (("S".equalsIgnoreCase(dep_type) || "Q"
					.equalsIgnoreCase(dep_type))
					&& PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() > 0) {
				TXN_TYPE = "SD";
			}*/
			
			else if (("S".equalsIgnoreCase(dep_type))
					&& PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() > 0) {
				TXN_TYPE = "PD";
			}
			
			/*End of  ZBLIFE-1456608*/
			
			/*end*/
			connection = CommonUtils.getConnection();
			String Query = "SELECT POL_PYMT_TYPE FROM PT_IL_POLICY WHERE POL_NO = ?";
			resultSet = handler.executeSelectStatement(Query, connection,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
			if (resultSet.next()) {
				CommonUtils.setGlobalObject("GLOBAL.POL_PYMT_TYPE", resultSet
						.getString(1));
			}
			CommonUtils.closeCursor(resultSet);

			CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", TXN_TYPE);
			CommonUtils.setGlobalObject("GLOBAL.G_DEP_REF_NO",
					PT_IL_DEPOSIT_BEAN.getDEP_REF_NO());
			if(PT_IL_DEPOSIT_BEAN
					.getDEP_LC_TOTAL_AMT()!=null){
				CommonUtils.setGlobalObject("GLOBAL.FC_AMT", PT_IL_DEPOSIT_BEAN
						.getDEP_LC_TOTAL_AMT());
			}else{
				CommonUtils.setGlobalObject("GLOBAL.FC_AMT", 0.0);
			}
			
			if(PT_IL_DEPOSIT_BEAN
					.getDEP_LC_TOTAL_AMT()!=null){
				CommonUtils.setGlobalObject("GLOBAL.LC_AMT", PT_IL_DEPOSIT_BEAN
						.getDEP_LC_TOTAL_AMT());
			}else{
				CommonUtils.setGlobalObject("GLOBAL.LC_AMT",0.0);
			}
			
			CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID", PT_IL_DEPOSIT_BEAN
					.getDEP_SYS_ID());// Changed by Deepika for this call
										// PREMIAGDC-266445
			CommonUtils.setGlobalObject("GLOBAL.CURR_CODE", sessionMap
					.get("GLOBAL.CURR_CODE"));
			//CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE", new Double);
			CommonUtils.setGlobalObject("APPROVAL_STATUS",
					getPT_IL_DEPOSIT_BEAN().isApprovalStatus());
			CommonUtils.setGlobalObject("CALLING_FORM", "PILT016A_APAC");
			
			if((PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE()==null || "".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE()))&&
					PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO()==0 
					//&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_DT()==null
					){
				compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(false);
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().disableAllComponent(false);
				CommonUtils.setGlobalVariable("PAYMENT_DISABLE", "false");
			}else{
				compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(true);
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().disableAllComponent(true);
				CommonUtils.setGlobalVariable("PAYMENT_DISABLE", "true");
			}
			if("Approved".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getUI_M_APPRV_STATUS())){
				compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(true);
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().disableAllComponent(true);
				COMP_SAVE_BTN.setDisabled(true);
			}else{
				compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().disableAllComponent(false);
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().disableAllComponent(false);
			}
			/*if (getPT_IL_DEPOSIT_BEAN().isInsertedStatus() == true) {
				getWarningMap()
						.put("current",
								"Please save the record before going to the Payment Details");
				getWarningMap()
						.put("somekey",
								"Please save the record before going to the Payment Details");
			} else {
				outcome = "goToPymtDtls";
			}*/
		} catch (DBException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		setFormFlag(true);
		setBlockFlag(true);
		compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().setFormFlag(true);
		compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().setBlockFlag(true);
		return outcome = "PILT017_PAYMENTDETAILS";

	}

	/*public String approve_PILP001_APAC() {
		
		String returnString = null;
		String M_DUMMY = null;
		String auto_gen_yn = compositeAction.getPT_IL_DEPOSIT_APPROVAL_ACTION_BEAN().getPT_IL_DEPOSIT_APPROVAL_BEAN().getAC_GEN_YN();
		String PYMT_QUERY = "SELECT * FROM PT_IL_PYMT_DTLS  WHERE  PD_TXN_SYS_ID  =  ?  ";
		String q1 = " SELECT DECODE( ? ,'Q','1','P','2') FROM DUAL ";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		
					resultSet1 = handler.executeSelectStatement(q1,connection , new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_TYPE()});
					if (resultSet1.next()) {
						M_DUMMY = resultSet1.getString(1);
						
					}
					
				String cursor1 = "SELECT 'X' FROM PT_IL_PYMT_DTLS WHERE PD_TXN_TYPE = DECODE( ? ,'Q',DECODE(SIGN(?),1,'QD',-1,'DR'),'P', " +
						"DECODE(SIGN( ? ),1,'PD','DR')) AND PD_TXN_SYS_ID = ? ";
				System.out
						.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC(cursor1) ---> "
								+ cursor1);
				ResultSet rsc1 = handler.executeSelectStatement(cursor1,
						CommonUtils.getConnection());
				if (rsc1.next()) {
					String cursor2 = " SELECT SUM(PD_LC_AMT) FROM PT_IL_PYMT_DTLS WHERE PD_TXN_TYPE = DECODE('"
							+ getPT_IL_DEPOSIT_BEAN().getDEP_TYPE()
							+ "','Q',"
							+ "DECODE(SIGN("
							+ getPT_IL_DEPOSIT_BEAN().getDEP_LC_DEP_AMT()
							+ "),1,'QD',-1,'DR'),'P',"
							+ "DECODE(SIGN("
							+ getPT_IL_DEPOSIT_BEAN().getDEP_LC_DEP_AMT()
							+ "),1,'PD','DR')) "
							+ "AND PD_TXN_SYS_ID = "
							+ getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID()
							+ " GROUP BY PD_TXN_SYS_ID";
					System.out
							.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC(cursor2) --> "
									+ cursor2);
					ResultSet rsc2 = handler.executeSelectStatement(cursor2,
							CommonUtils.getConnection());
					if (rsc2.next()) {
						double temp = rsc2.getDouble(1);
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC(tot amount) ---["
										+ temp + "]---");
						if (getPT_IL_DEPOSIT_BEAN().getDEP_LC_TOTAL_AMT() != temp) {
							getErrorMap().put(
									"current",
									Messages.getString(
											PELConstants.pelErrorMessagePath,
											"91043"));
							return "mainAcreen";
						}
					}
					rsc2.close();
				}
				rsc1.close();
				String q2 = " SELECT PT_UW_YEAR FROM   PM_IL_PROP_TREATY WHERE  PT_CLASS_CODE = '"
						+ getPT_IL_DEPOSIT_BEAN().getDEP_CLASS_CODE()
						+ "'"
						+ "AND (TRUNC(SYSDATE) BETWEEN TRUNC(PT_START_DT) AND TRUNC(PT_END_DT)) ";
				System.out
						.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() q2 DEP_CLASS_CODE "
								+ q2);
				int POL_UW_YEAR = 0;
				try {
					rs = handler.executeSelectStatement(q2, con);
					if (rs.next()) {
						POL_UW_YEAR = rs.getInt("PT_UW_YEAR");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				double M_BCSH_CUST_SHARE_PERC = 0.0;

				try {
					// pymt.getPT_IL_PYMT_DTLS_BEAN().setPD_PAY_MODE("C");
					String q4 = "SELECT BCSH_CUST_SHARE_PERC FROM PM_BANK_CHARGE_SETUP_HDR "
							+ "WHERE BCSH_PAY_MODE= '"
							+ pymtBean.getPD_PAY_MODE() + "'";
					// "WHERE BCSH_PAY_MODE= 'C'";

					System.out
							.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() q4 "
									+ q4);

					rs = handler.executeSelectStatement(q4, con);
					if (rs.next()) {
						M_BCSH_CUST_SHARE_PERC = rs
								.getDouble("BCSH_CUST_SHARE_PERC");
					}
					String pay_mode = pymtBean.getPD_PAY_MODE();
					// String pay_mode = "C";
					if ((pay_mode.equals("I") || pay_mode.equals("CC")
							|| pay_mode.equals("C1") || pay_mode.equals("C2")
							|| pay_mode.equals("C3") || pay_mode.equals("C4")
							|| pay_mode.equals("C5") || pay_mode.equals("C6"))
							&& pymt.getPT_IL_PYMT_DTLS_BEAN()
									.getPD_CC_APP_CODE() == null
							&& M_BCSH_CUST_SHARE_PERC != 0) {
						getErrorMap()
								.put(
										"current",
										Messages
												.getMessage(
														"com.iii.premia.common.errorUtil.PELErrorMessages.properties",
														"91922").getSummary());
					}

					String q3 = "SELECT PD_DPD_REF_ID FROM PT_IL_PYMT_DTLS "
							+ "WHERE  PD_TXN_SYS_ID = '"
							+ getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID_INTEGER()
							+ "'";
					System.out
							.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() q3 "
									+ q3);
					String M_PD_DPD_REF_ID = null;
					rs3 = handler.executeSelectStatement(q3, con);
					if (rs3.next()) {
						M_PD_DPD_REF_ID = rs3.getString("PD_DPD_REF_ID");
					}
					if (M_PD_DPD_REF_ID == null) {
						getErrorMap().put("current",
								"CANNOT APPROVE BECAUSE DPD REF ID IS NULL");
					}

					if (getPT_IL_DEPOSIT_BEAN().getDEP_PROD_CODE() == null
							&& getPT_IL_DEPOSIT_BEAN().getDEP_CLASS_CODE() == null
							&& getPT_IL_DEPOSIT_BEAN().getDEP_DS_CODE() == null) {
						getErrorMap()
								.put(
										"current",
										Messages
												.getMessage(
														"com.iii.premia.common.errorUtil.PELErrorMessages.properties",
														"91334").getSummary());
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				String q12 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_CONT_CODE= '"
						+ getPT_IL_DEPOSIT_BEAN().getDEP_CONT_CODE()
						+ "'"
						+ "AND   POL_DS_TYPE IN ('1','2') AND   POL_NO <> '"
						+ getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID_INTEGER()
						+ "'"
						+ "AND   POL_PROP_QUOT_FLAG <> 'Q'";

				try {
					if ("Q".equals(getPT_IL_DEPOSIT_BEAN().getDEP_TYPE())) {
						String M_DUMMY_X = null;
						rs12 = handler.executeSelectStatement(q12, con);
						if (rs12.next()) {
							M_DUMMY_X = "X";
						} else {
							M_DUMMY_X = "Y";
						}
						
						 * if(M_DUMMY_X.equals("X")){
						 * getWarningMap().put("current", "Contractor code
						 * already exist policy/proposal"); }
						 
						// L_GEN_PROPOSAL(:PT_IL_DEPOSIT.DEP_SYS_ID);
						CallableStatement cs = con
								.prepareCall("{call L_GEN_PROPOSAL(?)}");
						cs.setLong(1, getPT_IL_DEPOSIT_BEAN()
								.getDEP_SYS_ID_INTEGER());
						boolean flag = cs.execute();
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() proc executed "
										+ flag);

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() == null) {
					// To be done
					System.out
							.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() in null ref_no "
									+ getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID());
				} else {
					// L_DEPOSIT_APPROVAL
					// :DEP_SYS_ID,:GLOBAL.TXN_TYPE);

					System.out
							.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() not null ref_no "
									+ getPT_IL_DEPOSIT_BEAN()
											.getDEP_SYS_ID_INTEGER()
									+ " "
									+ CommonUtils
											.getGlobalVariable("GLOBAL.TXN_TYPE"));

					try {
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() befor procedure calling "
										+ getPT_IL_DEPOSIT_BEAN()
												.getDEP_DIVN_CODE()
										+ "  "
										+ CommonUtils
												.getGlobalVariable("GLOBAL.TXN_TYPE")
										+ "  "
										+ getPT_IL_DEPOSIT_BEAN()
												.getDEP_SYS_ID());

						System.out.println("params::::::::"
								+ getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID()
								+ " "
								+ CommonUtils
										.getGlobalVariable("GLOBAL.TXN_TYPE")
								+ " " + auto_gen_yn);

						CallableStatement cs = con.prepareCall("{call  P9ILPK_DEP_APPROVAL.DEPOSIT_APPROVAL(?,?,?)}");
						cs.setDouble(1, getPT_IL_DEPOSIT_BEAN()
										.getDEP_SYS_ID());
						cs.setString(2, CommonUtils
								.getGlobalVariable("GLOBAL.TXN_TYPE"));
						cs.setString(3, auto_gen_yn);
						boolean executed = cs.execute();

						OracleParameter param1 = new OracleParameter("in1",
								"STRING", "IN", String
										.valueOf(getPT_IL_DEPOSIT_BEAN()
												.getDEP_SYS_ID()));
						OracleParameter param2 = new OracleParameter("in2",
								"STRING", "IN", CommonUtils
										.getGlobalVariable("GLOBAL.TXN_TYPE"));
						OracleParameter param3 = new OracleParameter("in3",
								"STRING", "IN", auto_gen_yn);
						ArrayList<OracleParameter> listOfParam = new ArrayList<OracleParameter>();
						listOfParam.add(param1);
						listOfParam.add(param2);
						listOfParam.add(param3);
						OracleProcedureHandler procHandler = new OracleProcedureHandler();
						procHandler.execute(listOfParam, CommonUtils
								.getConnection(),
								"P9ILPK_DEP_APPROVAL.DEPOSIT_APPROVAL");
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC(.,.,.,.,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,)");
						ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(
								con, context, COMP_UI_M_BUT_APPROVAL
										.getClientId(context), getErrorMap(),
								getWarningMap());
					}
					try {
						CallableStatement cs = con
								.prepareCall("{call  P9ILPK_DEP_APPROVAL.INS_TOP_UP(?)}");
						cs.setLong(1, getPT_IL_DEPOSIT_BEAN()
								.getDEP_SYS_ID_INTEGER());
						boolean flag = cs.execute();
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() flag "
										+ flag);

					} catch (SQLException e) {
						e.printStackTrace();
						// L_DISPLAY_ERROR_MESSAGE;
					}
					if (getPT_IL_DEPOSIT_BEAN().getDEP_PDC_FLAG() == null) {
						getPT_IL_DEPOSIT_BEAN().setDEP_PDC_FLAG("X");
					}
					if (Integer.parseInt(ps_value) == 1
							&& !"Y".equals(getPT_IL_DEPOSIT_BEAN()
									.getDEP_PDC_FLAG())) {
						// P9ILPK_DEP_APPROVAL.P_UPDATE_PROP_DEP(:PT_IL_DEPOSIT.DEP_SYS_ID);
						try {
							System.out
									.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() befor call222 "
											+ getPT_IL_DEPOSIT_BEAN()
													.getDEP_SYS_ID_INTEGER());
							CallableStatement cs = con
									.prepareCall("{call P9ILPK_DEP_APPROVAL.P_UPDATE_PROP_DEP(?)}");
							cs.setLong(1, getPT_IL_DEPOSIT_BEAN()
									.getDEP_SYS_ID_INTEGER());

							boolean flag = cs.execute();
							System.out
									.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() flag222 "
											+ flag);

						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

					try {
						// P9ILPK_DEP_APPROVAL.P_GEN_PROP_GEN(
						// :GLOBAL.TXN_TYPE,:PT_IL_DEPOSIT.DEP_SYS_ID,:PT_IL_DEPOSIT.M_DUMMY_POLNO);
						CallableStatement cs = con
								.prepareCall("{call P9ILPK_DEP_APPROVAL.P_GEN_PROP_GEN(?,?,?)}");
						cs.setString(1, CommonUtils
								.getGlobalVariable("GLOBAL.TXN_TYPE"));
						cs.setLong(2, getPT_IL_DEPOSIT_BEAN()
								.getDEP_SYS_ID_INTEGER());
						cs
								.setString(3, getPT_IL_DEPOSIT_BEAN()
										.getDEP_REF_NO());

						boolean flag = cs.execute();
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() flag3333  "
										+ flag);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				System.out
						.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() last "
								+ getPT_IL_DEPOSIT_BEAN().getDEP_TXN_CODE()
								+ "  "
								+ getPT_IL_DEPOSIT_BEAN().getDEP_DOC_NO()
								+ "  "
								+ getPT_IL_DEPOSIT_BEAN()
										.getDEP_SYS_ID_INTEGER());

				try {

					String query = "SELECT DEP_TXN_CODE, DEP_DOC_NO, DEP_DOC_DT FROM PT_IL_DEPOSIT WHERE DEP_SYS_ID = '"
							+ getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID_INTEGER()
							+ "'";
					rs = handler.executeSelectStatement(query, con);
					if (rs.next()) {
						System.out
								.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC() queryLASSS "
										+ query);
						String txn = rs.getString("DEP_TXN_CODE");
						double doc_no = rs.getDouble("DEP_DOC_NO");
						Date date = rs.getDate("DEP_DOC_DT");
						getPT_IL_DEPOSIT_BEAN().setDEP_TXN_CODE(txn);
						getPT_IL_DEPOSIT_BEAN().setDEP_DOC_NO(doc_no);
						getPT_IL_DEPOSIT_BEAN().setDEP_DOC_DT(date);
						String paymentDetails = getPaymentDetails();
						if ((txn != null && doc_no != 0.0)
								|| paymentDetails != null) {
							getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS(
									"Approved");
							COMP_UI_M_APPRV_STATUS.setValue("Approved");
							getPT_IL_DEPOSIT_BEAN().setApprovalStatus(true);
							COMP_UI_M_BUT_APPROVAL.setDisabled(true);
							getWarningMap().put("current",
									"Deposit Premium Collection is Approved");
							getWarningMap().put("somekey",
									"Deposit Premium Collection is Approved");
							returnString = "mainAcreen";
						} else {
							getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS(
									"Not Approved");
							COMP_UI_M_APPRV_STATUS.setValue("Not Approved");
							COMP_UI_M_BUT_APPROVAL.setDisabled(false);
							getWarningMap()
									.put("current",
											"Deposit Premium Collection is not Approved");
							getWarningMap()
									.put("somekey",
											"Deposit Premium Collection is not Approved");
							returnString = "";
						}
					} else {
						System.out
								.println("else********************************************************");
						String paymentDetails = getPaymentDetails();
						if (paymentDetails != null) {
							getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS(
									"Approved");
							COMP_UI_M_APPRV_STATUS.setValue("Approved");
							getPT_IL_DEPOSIT_BEAN().setApprovalStatus(true);
							COMP_UI_M_BUT_APPROVAL.setDisabled(true);
							getWarningMap().put("current",
									"Deposit Premium Collection is Approved");
							getWarningMap().put("somekey",
									"Deposit Premium Collection is Approved");
							returnString = "mainAcreen";
						} else {
							getPT_IL_DEPOSIT_BEAN().setUI_M_APPRV_STATUS(
									"Not Approved");
							COMP_UI_M_APPRV_STATUS.setValue("Not Approved");
							COMP_UI_M_BUT_APPROVAL.setDisabled(false);
							getWarningMap()
									.put("current",
											"Deposit Premium Collection is not Approved");
							getWarningMap()
									.put("somekey",
											"Deposit Premium Collection is not Approved");
							returnString = "";
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				getErrorMap().put("current",
						"Please enter the payment details for approval");
				getErrorMap().put("somekey",
						"Please enter the payment details for approval");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				CommonUtils.closeCursor(rs);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs12);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "mainAcreen";
	}*/

	public String getPaymentDetails() {
		String M_DUMMY = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String query = "SELECT 'X'  FROM   PT_IL_DEPOSIT_PYMT_DTLS  WHERE  DPD_DEP_SYS_ID = ?";
			Object[] params = { getPT_IL_DEPOSIT_BEAN().getDEP_SYS_ID_INTEGER() };
			resultSet = handler.executeSelectStatement(query, connection,
					params);
			while (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return M_DUMMY;
	}

	public void grossSupport(FacesContext context, UIComponent component,
			Object object) {
		Double value = (Double) object;
		try {
			PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM(value);
			PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(value);
			PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(value);
			//PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(value);
			COMP_DEP_LC_DEP_AMT.resetValue();
			COMP_DEP_LC_TOT_AMT.resetValue();
			/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
			//COMP_DEP_LC_AMT.resetValue();
			//End
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void setCOMP_UI_M_POL_STATUS(HtmlOutputText comp_ui_m_pol_status) {
		COMP_UI_M_POL_STATUS = comp_ui_m_pol_status;
	}

	public HtmlOutputText getCOMP_UI_M_POL_STATUS() {
		return COMP_UI_M_POL_STATUS;
	}

	public void onLoad(PhaseEvent e) {
		try {
			
			if (isFormFlag()) {
				CommonUtils.clearMaps(this);
				preForm();
				setFormFlag(false);
			}

			if (isBlockFlag()) {
				
				/*Added by Janani on 13.8.2016 for IC no length issue*/
				
				
				int fieldLength = 0;
				int PS_VALUE= (int) CommonUtils.getGlobalObject("M_PS_VALUE");
				fieldLength = 	(int) CommonUtils.getGlobalObject("FIELD_LENGTH");
				System.out.println("fieldLength         "+fieldLength);

				if(PS_VALUE == 1)
				{
					System.out.println("enters into PS_VALUE == 1");
					//compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(12);
					compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getCOMP_DEP_CONT_REF_ID1().setMaxlength(fieldLength);
				}
				else if(PS_VALUE == 2)
				{
					System.out.println("enters into PS_VALUE == 2");
					//compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(24);
					compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getCOMP_DEP_CONT_REF_ID1().setMaxlength(fieldLength);
				}
				
				/*end*/
				helper.preBlock(compositeAction.getCTRL_BEAN());
				helper.whenNewBlockInstance(PT_IL_DEPOSIT_BEAN);
				helper.preQuery();
				helper.executeQuery(compositeAction);
				if (PT_IL_DEPOSIT_BEAN.getROWID() != null) {
					helper.postQuery(compositeAction);
					//helper.onPopulateDetails(compositeAction);
					
					/*Added by Janani on 11.06.2018 for FSD_IL_FLA_019 */
					upt_lc_amt();

					/*End*/
					
					
				} else {
					helper.whenCreateRecord(compositeAction);
					/*Added by Sivarajan on 08/11/2020 for Alliance IL*/
					String workflowPolNo=CommonUtils.getGlobalVariable("WORKFLOW_RECIEPT_POL_NO");
					if(!"".equals(workflowPolNo)&&workflowPolNo!=null)
					{
						PT_IL_DEPOSIT_BEAN.setDEP_REF_NO(workflowPolNo);
						COMP_DEP_REF_NO.resetValue();
						CommonUtils.setGlobalVariable("WORKFLOW_RECIEPT_POL_NO", "");
					}
					/*End*/
					
				}
				whenNewRecordInstanceBLOCK_LEVEL();
				setBlockFlag(false);
				
				/*Added by saritha on 07-11-2017 for Premium Collection Issues*/
				getExcludingCommissionYN();
				/*End*/
				
			}
			
			if("Approved".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getUI_M_APPRV_STATUS())){
				disableAllComponent(true);
			}
			
			setDescriptionDisable();
			
			/*added by raja om 28-02-2017*/
			
			
			
			if(PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() == null)
			{
				getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(true);
				
				
			}
			else
			{
				getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(false);
			}
			/*End*/
			
			//added by kirthika receipt entry screen on 03-06-2016
			COMP_DEP_TXN_CODE.setDisabled(true);
			COMP_DEP_DOC_NO.setDisabled(true);
			COMP_DEP_DOC_DT.setDisabled(true);
			COMP_DEP_ACNT_YEAR.setDisabled(true);
			COMP_DEP_REPL_RCPT_YN.setDisabled(true);
			COMP_DEP_LC_DEP_AMT.setDisabled(true);
			
			/* Newly Added By Dhinesh on 26-6-2017 for ssp call id : */ 
		   if("Y".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_REC_REV_YN()))
		   {
			   getCOMP_UI_M_CHEQUE().setDisabled(false);
		   }
			/* End */
			
			
		   
		} catch (Exception ex) {
			ex.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					ex.getMessage());
			getErrorMap().put("onLoad", ex.getMessage());
		}
		// PT_IL_DEPOSIT_BEAN.setApprovalStatus(true);
	}

	/**
	 * 
	 */
	private void setDescriptionDisable() {
		COMP_UI_M_CUST_NAME.setDisabled(true);
		COMP_UI_M_CONT_NAME.setDisabled(true);
		COMP_UI_M_DEP_PROD_CODE_DESC.setDisabled(true);
		COMP_UI_M_DEP_AGENT_CODE_DESC.setDisabled(true);
		COMP_UI_M_DEP_COLL_AGENT_CODE_DESC.setDisabled(true);
		
		COMP_UI_M_DEP_DIVN_DESC.setDisabled(true);
		COMP_UI_M_DEP_DEPT_DESC.setDisabled(true);
		COMP_UI_M_DEP_CLASS_CODE_DESC.setDisabled(true);
		COMP_UI_M_BANKIN_NAME.setDisabled(true);
		COMP_UI_M_DEP_PLAN_CODE_DESC.setDisabled(true);
		COMP_UI_M_DEP_DS_CODE_DESC.setDisabled(true);
		COMP_UI_M_DEP_BUS_DESC.setDisabled(true);
	}

	public void validateTOTAL_PAID_PREMIUM(FacesContext context,
			UIComponent component, Object object) {
		Double value = (Double) object;
		PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(value);
		try {
			if (value != null) {
				if(value==0){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91004"));
				}
				DBProcedures procedures = new DBProcedures();
				String currCode = CommonUtils.getGlobalVariable("GLOBAL.CURR_CODE");
				procedures.P_VAL_ROUND_AMT(currCode, PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT(), "R", PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE());
				if ("Q".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN().getDEP_TYPE())
						&& value > 0) {
					CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "QD");
				} else if ("P".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN()
						.getDEP_TYPE())
						&& value > 0) {
					CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
				
				
				}
				else if ("S".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN()
						.getDEP_TYPE())
						&& value > 0) {
					
					/*Modified by Janani on 02.02.2018 for ZBLIFE-1456608 */
					//CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "SD");
					CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
				
					/*End of ZBLIFE-1456608 */
				}
				/*Modified by Ram on 10/01/2017 as per Kuzhandhai's suggestion
				 * 
				 * if (PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT() == null 
						|| PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT()==0.0) {*/
				if (PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT() == null 
						|| PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT()==0.0 || PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT() != value) {
					/*End*/
					PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(value);
					PT_IL_DEPOSIT_BEAN.setDEP_LC_OTH_AMT(0.00);
					COMP_DEP_LC_DEP_AMT.setSubmittedValue(value);
					COMP_DEP_LC_DEP_AMT.resetValue();
					
					/*Added by Ram on 10/01/2017 as per Kuzhandhai's suggestion
*/					PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(value);
					COMP_DEP_LC_TOT_AMT.resetValue();
					/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
					//PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(value);
					//COMP_DEP_LC_AMT.resetValue();
					//End
				}


			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public boolean getDeleteDisabled() {
		System.out.println("in side ......deleteDisabled........");
		boolean disabled = false;
		if (getPT_IL_DEPOSIT_BEAN().getUI_M_APPRV_STATUS() != null
				&& "Approved".equals(getPT_IL_DEPOSIT_BEAN()
						.getUI_M_APPRV_STATUS())) {
			disabled = true;
			System.out.println("DISABLED:::::......" + disabled);
		}
		return disabled;
	}

	// Newly Added- Deepika
	public String callApprovalWindow() {
		String returnValue = null;
		try {
			helper.approval(compositeAction);
			COMP_UI_M_APPRV_STATUS.setValue("Approved");
			
			/*Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion*/
			
			if(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() != null && !compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO().isEmpty()){
				int pol_Sys_id = 0;
				pol_Sys_id = helper.doGetPolicySysId(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO());
				/*Newly added by pidugu raj dt:27-07-2020 as suggested by kk*/
				String polStatus = null;
				polStatus =  helper.doGetPolicyStatus(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()); 
				int endorsementNoIdx = 0;
				endorsementNoIdx = helper.doGetPolicyEndorsementNoIdx(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO());
				/*End Newly added by pidugu raj dt:27-07-2020 as suggested by kk*/
				String PDD_STATUS = null;
				
				PDD_STATUS = helper.doGetPdd_SysId(pol_Sys_id);
				System.out.println("PDD_STATUS coming : "+PDD_STATUS);
				
				if(PDD_STATUS != null && !PDD_STATUS.isEmpty()){
					String flag = "R";
					/*Newly added by pidugu raj dt:27-07-2020 as suggested by kk*/
					if(polStatus.equalsIgnoreCase("N") && endorsementNoIdx == '0'){
						new P9ILPK_POL_APPROVAL().PROC_POL_APPROVAL_DIRECT(String.valueOf(pol_Sys_id),PDD_STATUS,flag);
					}else{
						//do nothing	
					}
					/*Newly added by pidugu raj dt:27-07-2020 as suggested by kk*/
				}
			}
			
			/*End Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion*/
			this.setFormFlag(true);
			this.setBlockFlag(true);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			
		}

		
		return "";
	}

	public String getUserApprovalFlagValue() {
		String result = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;

		try {

			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query = "SELECT NVL(ASD_CHAR_VALUE,'N') FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID = ? AND ?"
					+ " BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE AND  ASD_CODE = 'MOD_AC_FLAG'";
			System.out.println("porduct code:::"
					+ PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE());
			Object[] params = { CommonUtils.getControlBean().getM_USER_ID(),
					PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE() };
			resultSet = handler.executeSelectStatement(query, connection,
					params);
			if (resultSet.next()) {
				result = resultSet.getString(1);
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return result;
	}

	public void calP_INS_PYMT_DTLS() {
		PT_IL_DEPOSIT bean = getPT_IL_DEPOSIT_BEAN();
		String dep_type = bean.getDEP_TYPE();
		String TXN_TYPE = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		if ("Q".equalsIgnoreCase(dep_type) && (bean.getDEP_LC_TOTAL_AMT() > 0)) {
			TXN_TYPE = "QD";
		} else if ("P".equalsIgnoreCase(dep_type)
				&& (bean.getDEP_LC_TOTAL_AMT() > 0)) {
			TXN_TYPE = "PD";
		} else if (("P".equalsIgnoreCase(dep_type) || "Q"
				.equalsIgnoreCase(dep_type))
				&& (bean.getDEP_LC_TOTAL_AMT() < 0.0)) {
			TXN_TYPE = "DR";
		}
		
		/*added by raja on 03-07-2017*/
		else if ("S".equalsIgnoreCase(dep_type)
				&&	 (bean.getDEP_LC_TOTAL_AMT() > 0)) {
			
			/*Modified by Janani on 02.02.2018 for ZBLIFE-1456608 */
			//TXN_TYPE = "SD";
			TXN_TYPE = "PD";
			
			/*End of ZBLIFE-1456608*/
		}
		/*end*/
		CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", TXN_TYPE);
		CommonUtils.setGlobalObject("GLOBAL.G_DEP_REF_NO", bean.getDEP_REF_NO());
		CommonUtils.setGlobalObject("GLOBAL.FC_AMT", bean.getDEP_LC_TOTAL_AMT());
		CommonUtils.setGlobalObject("GLOBAL.LC_AMT", bean.getDEP_LC_TOTAL_AMT());
		CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID", bean.getDEP_SYS_ID());
		CommonUtils.setGlobalObject("GLOBAL.CURR_CODE", sessionMap.get("GLOBAL.CURR_CODE"));
		CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE", sessionMap.get("GLOBAL.EXCH_RATE"));

		ArrayList<OracleParameter> list1;
		try {
			list1 = P_INS_PYMT_DTLS(TXN_TYPE, bean.getDEP_SYS_ID(), bean.getDEP_CURR_CODE(), bean.getDEP_FC_TOTAL_AMT(), bean
					.getDEP_LC_TOTAL_AMT(), (String) sessionMap
					.get("GLOBAL.CURR_CODE"),(Double) sessionMap.get("GLOBAL.EXCH_RATE"),
					null);

			if (list1.get(0).getValueObject() != null
					&& list1.get(0).getValueObject().equals("Y")) {
				COMP_UI_M_BUT_APPROVAL.setDisabled(false);
			}

		} catch (ProcedureException e) {
			e.printStackTrace();
		}

	}

	public PT_IL_PYMT_DTLS getPymtDtlRowData() {
		PT_IL_PYMT_DTLS pymtBean = new PT_IL_PYMT_DTLS();
		CRUDHandler handler = new CRUDHandler();
		String TXN_TYPE = null;
		this.getClass();
		PT_IL_DEPOSIT bean = getPT_IL_DEPOSIT_BEAN();
		String dep_type = bean.getDEP_TYPE();
		if ("Q".equalsIgnoreCase(dep_type) && (bean.getDEP_LC_TOTAL_AMT() > 0)) {
			TXN_TYPE = "QD";
		} else if ("P".equalsIgnoreCase(dep_type)
				&& (bean.getDEP_LC_TOTAL_AMT() > 0)) {
			TXN_TYPE = "PD";
		} else if (("P".equalsIgnoreCase(dep_type) || "Q"
				.equalsIgnoreCase(dep_type))
				&& bean.getDEP_LC_TOTAL_AMT() < 0) {
			TXN_TYPE = "DR";
		}
		String pymQry = "SELECT * FROM PT_IL_PYMT_DTLS WHERE "
				+ "	PD_TXN_SYS_ID = " + bean.getDEP_SYS_ID()
				+ " AND PD_TXN_TYPE= '" + TXN_TYPE + "'";
		System.out.println("PT_IL_DEPOSIT_ACTION.getPymtDtlRowData(qry)--- [ "
				+ pymQry + " ]---");
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(pymQry, CommonUtils
					.getConnection());
			if (rs.next()) {
				System.out
						.println("PT_IL_DEPOSIT_ACTION.approve_PILP001_APAC(*******************)");
				pymtBean.setPD_SYS_ID(rs.getLong("PD_SYS_ID"));
				pymtBean.setPD_SR_NO(rs.getInt("PD_SR_NO"));
				pymtBean.setPD_TXN_TYPE(rs.getString("PD_TXN_TYPE"));
				pymtBean.setPD_TXN_SYS_ID(rs.getLong("PD_TXN_SYS_ID"));
				pymtBean.setPD_PAY_MODE(rs.getString("PD_PAY_MODE"));
				pymtBean.setPD_CURR_CODE(rs.getString("PD_CURR_CODE"));
				pymtBean.setPD_FC_AMT(rs.getDouble("PD_FC_AMT"));
				pymtBean.setPD_LC_AMT(rs.getDouble("PD_LC_AMT"));
				pymtBean.setPD_CHQ_NO(rs.getString("PD_CHQ_NO"));
				pymtBean.setPD_CHQ_DT(rs.getDate("PD_CHQ_DT"));
				pymtBean.setPD_BANK_NAME(rs.getString("PD_BANK_NAME"));
				pymtBean.setPD_BRANCH_NAME(rs.getString("PD_BRANCH_NAME"));
				pymtBean.setPD_CC_NO(rs.getString("PD_CC_NO"));
				pymtBean.setPD_CC_NAME(rs.getString("PD_CC_NAME"));
				pymtBean.setPD_CC_EXP_DT(rs.getDate("PD_CC_EXP_DT"));
				pymtBean.setPD_CC_TYPE(rs.getString("PD_CC_TYPE"));
				pymtBean.setPD_CUST_NAME(rs.getString("PD_CUST_NAME"));
				pymtBean.setPD_ADDR_01(rs.getString("PD_ADDR_01"));
				pymtBean.setPD_ADDR_02(rs.getString("PD_ADDR_02"));
				pymtBean.setPD_ADDR_03(rs.getString("PD_ADDR_03"));
				pymtBean.setPD_REMARKS(rs.getString("PD_REMARKS"));
				pymtBean.setPD_CR_UID(rs.getString("PD_CR_UID"));
				pymtBean.setPD_CR_DT(rs.getDate("PD_CR_DT"));
				pymtBean.setPD_UPD_UID(rs.getString("PD_UPD_UID"));
				pymtBean.setPD_UPD_DT(rs.getDate("PD_UPD_DT"));
				pymtBean.setPD_DPD_REF_ID(rs.getString("PD_DPD_REF_ID"));
				pymtBean.setPD_REV_YN(rs.getString("PD_REV_YN"));
				pymtBean.setPD_LC_CHARGE(rs.getDouble("PD_LC_CHARGE"));
				pymtBean.setPD_FC_CHARGE(rs.getDouble("PD_FC_CHARGE"));
				pymtBean.setPD_PAID_FOR(rs.getString("PD_PAID_FOR"));
				pymtBean.setPD_CC_APP_CODE(rs.getString("PD_CC_APP_CODE"));
				pymtBean.setPD_PAYIN_DATE(rs.getDate("PD_PAYIN_DATE"));
				pymtBean.setPD_OUR_BANK_CODE(rs.getString("PD_OUR_BANK_CODE"));
				pymtBean.setPD_DATE_OF_CREDIT(rs.getDate("PD_DATE_OF_CREDIT"));
				pymtBean.setPD_TT_REF_NO(rs.getString("PD_TT_REF_NO"));
				pymtBean.setPD_TT_CURR_CODE(rs.getString("PD_TT_CURR_CODE"));
				pymtBean.setPD_REM_SLIP_GEN_YN(rs
						.getString("PD_REM_SLIP_GEN_YN"));
				pymtBean.setPD_PO_MO_NO(rs.getString("PD_PO_MO_NO"));
				pymtBean.setPD_PO_MO_DT(rs.getDate("PD_PO_MO_DT"));
				pymtBean.setPD_REM_AMT(rs.getDouble("PD_REM_AMT"));
				pymtBean.setPD_BANK_REF_NO(rs.getString("PD_BANK_REF_NO"));
				pymtBean.setPD_CR_ADVICE_NO(rs.getString("PD_CR_ADVICE_NO"));
				pymtBean.setPD_ATM_CARD_NO(rs.getString("PD_ATM_CARD_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return pymtBean;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	/**
	 * 
	 * @param P_PROD_CODE-IN
	 * @param P_CURR_CODE-IN
	 * @param P_AMT-IN
	 *            OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> ROUND_COMM_AMT(Object P_PROD_CODE,
			Object P_CURR_CODE, Object P_AMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT, P_AMT);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_POL_APPROVAL.ROUND_COMM_AMT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	/**
	 * 
	 * @param P_TXN_TYPE-IN
	 * @param P_TXN_SYS_ID-IN
	 * @param P_CURR_CODE-IN
	 * @param P_FC_AMT-IN
	 * @param P_LC_AMT-IN
	 * @param P_BASE_CURR_CODE-IN
	 * @param P_EXCH_RATE-IN
	 * @param P_STATUS_FLAG-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INS_PYMT_DTLS(Object P_TXN_TYPE,
			Object P_TXN_SYS_ID, Object P_CURR_CODE, Object P_FC_AMT,
			Object P_LC_AMT, Object P_BASE_CURR_CODE, Object P_EXCH_RATE,
			Object P_STATUS_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TXN_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_TXN_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_FC_AMT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_LC_AMT);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_BASE_CURR_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_EXCH_RATE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param8);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_DEP_APPROVAL.P_INS_PYMT_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * Resets all components in PT_IL_DEPOSIT_ACTION
	 */
	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DEP_CONT_REF_ID1.resetValue();
		COMP_DEP_CONT_REF_ID2.resetValue();
		COMP_DEP_TXN_CODE.resetValue();
		COMP_DEP_REF_NO.resetValue();
		COMP_DEP_DOC_NO.resetValue();
		COMP_DEP_TEMP_RCPT_NO.resetValue();
		COMP_DEP_CUST_CODE.resetValue();
		COMP_UI_M_CUST_NAME.resetValue();
		COMP_DEP_ACNT_YEAR.resetValue();
		COMP_DEP_CONT_CODE.resetValue();
		COMP_UI_M_CONT_NAME.resetValue();
		COMP_DEP_PROD_CODE.resetValue();
		COMP_UI_M_DEP_PROD_CODE_DESC.resetValue();
		COMP_DEP_REP_BANK_IN_SLIP_NO.resetValue();
		COMP_DEP_REPL_TXN_CODE.resetValue();
		COMP_DEP_AGENT_CODE.resetValue();
		COMP_UI_M_DEP_AGENT_CODE_DESC.resetValue();
		COMP_DEP_REPL_DOC_NO.resetValue();
		COMP_DEP_COLL_AGENT_CODE.resetValue();
		COMP_UI_M_DEP_COLL_AGENT_CODE_DESC.resetValue();
		COMP_DEP_REPL_ACC_YR.resetValue();
		COMP_UI_M_POL_LC_GROSS_PREM.resetValue();
		COMP_DEP_LC_DEP_AMT.resetValue();
		COMP_UI_M_POL_LC_COMMISSION.resetValue();
		COMP_DEP_LC_OTH_AMT.resetValue();
		COMP_DEP_LC_TOT_AMT.resetValue();
		COMP_UI_M_POL_LC_NET_PREM.resetValue();
		COMP_DEP_LC_TOTAL_AMT.resetValue();
		COMP_DEP_BANK_IN_SLIP_NO.resetValue();
		COMP_DEP_DIVN_CODE.resetValue();
		COMP_UI_M_DEP_DIVN_DESC.resetValue();
		COMP_DEP_DEPT_CODE.resetValue();
		COMP_UI_M_DEP_DEPT_DESC.resetValue();
		COMP_DEP_CLASS_CODE.resetValue();
		COMP_UI_M_DEP_CLASS_CODE_DESC.resetValue();
		COMP_DEP_BANKIN_CODE.resetValue();
		COMP_UI_M_BANKIN_NAME.resetValue();
		COMP_DEP_PLAN_CODE.resetValue();
		COMP_UI_M_DEP_PLAN_CODE_DESC.resetValue();
		COMP_DEP_DS_CODE.resetValue();
		COMP_UI_M_DEP_DS_CODE_DESC.resetValue();
		COMP_DEP_SRC_OF_BUS.resetValue();
		COMP_UI_M_DEP_BUS_DESC.resetValue();
		COMP_DEP_REV_REMARKS.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_DEP_GROSS_NET_FLAG.resetValue();
		COMP_DEP_REPL_RCPT_YN.resetValue();

		// Reseting HtmlCalendar
		COMP_DEP_DOC_DT.resetValue();

		// Reseting HtmlCommandButton
		/*
		 * COMP_UI_M_BUT_LOV_CUST_CODE.resetValue();
		 * COMP_UI_M_BUT_LOV_CONT_CODE.resetValue();
		 * COMP_UI_M_BUT_AGENT_CODE_LOV.resetValue();
		 * COMP_UI_M_BUT_COLL_AGENT_CODE_LOV.resetValue();
		 * COMP_UI_M_BU_LOV_DEP_REF_NO.resetValue();
		 * COMP_UI_M_BUT_PYMT_DTLS.resetValue();
		 * COMP_UI_M_BUT_APPROVAL.resetValue();
		 * COMP_UI_M_BUT_CONTRACTOR.resetValue();
		 * COMP_UI_M_BUT_DEP_PROD_CODE_LOV.resetValue();
		 * COMP_UI_M_BUT_POL_DET.resetValue(); COMP_UI_M_CHEQUE.resetValue();
		 * prBt.resetValue();
		 */
		
		/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
		//COMP_DEP_LC_AMT.resetValue();
		//End
		
		/*Added by rakesh on 06-03-2020 for orient uat issue receipting currency */
		COMP_DEP_CURR_CODE.resetValue();
		COMP_DEP_CURR_DESC.resetValue();
		//END
		//Added by rakesh on 06-07-2020 for total paid amount in FC instead of LC
				COMP_DEP_FC_TOTAL_AMT.resetValue();
				//END

	}
	
	public void validateDEP_LC_DEP_AMT(FacesContext context,UIComponent component , Object object){
		Double value = (Double) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(value);
			helper.validateDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * @return the suggesionList
	 */
	public List<LovBean> getSuggesionList() {
		return suggesionList;
	}

	/**
	 * @param suggesionList the suggesionList to set
	 */
	public void setSuggesionList(List<LovBean> suggesionList) {
		this.suggesionList = suggesionList;
	}

	/**
	 * @return the cOMP_MORE_INFO_1
	 */
	public HtmlTab getCOMP_MORE_INFO_1() {
		return COMP_MORE_INFO_1;
	}

	/**
	 * @param comp_more_info_1 the cOMP_MORE_INFO_1 to set
	 */
	public void setCOMP_MORE_INFO_1(HtmlTab comp_more_info_1) {
		COMP_MORE_INFO_1 = comp_more_info_1;
	}


	/**
	 * Disables all components in PT_IL_DEPOSIT_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_DEP_CONT_REF_ID1.setDisabled(disabled);
		COMP_DEP_CONT_REF_ID2.setDisabled(disabled);
		COMP_DEP_TXN_CODE.setDisabled(disabled);
		COMP_DEP_REF_NO.setDisabled(disabled);
		COMP_DEP_DOC_NO.setDisabled(disabled);
		COMP_DEP_TEMP_RCPT_NO.setDisabled(disabled);
		COMP_DEP_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_CUST_NAME.setDisabled(disabled);
		COMP_DEP_ACNT_YEAR.setDisabled(disabled);
		COMP_DEP_CONT_CODE.setDisabled(disabled);
		COMP_UI_M_CONT_NAME.setDisabled(disabled);
		COMP_DEP_PROD_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_PROD_CODE_DESC.setDisabled(disabled);
		COMP_DEP_REP_BANK_IN_SLIP_NO.setDisabled(disabled);
		COMP_DEP_REPL_TXN_CODE.setDisabled(disabled);
		COMP_DEP_AGENT_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_AGENT_CODE_DESC.setDisabled(disabled);
		COMP_DEP_REPL_DOC_NO.setDisabled(disabled);
		COMP_DEP_COLL_AGENT_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_COLL_AGENT_CODE_DESC.setDisabled(disabled);
		COMP_DEP_REPL_ACC_YR.setDisabled(disabled);
		//COMP_UI_M_POL_LC_GROSS_PREM.setDisabled(disabled);
		COMP_DEP_LC_DEP_AMT.setDisabled(disabled);
		COMP_UI_M_POL_LC_COMMISSION.setDisabled(disabled);
		COMP_DEP_LC_OTH_AMT.setDisabled(disabled);
		COMP_DEP_LC_TOT_AMT.setDisabled(disabled);
		COMP_UI_M_POL_LC_NET_PREM.setDisabled(disabled);
		COMP_DEP_LC_TOTAL_AMT.setDisabled(disabled);
		COMP_DEP_BANK_IN_SLIP_NO.setDisabled(disabled);
		COMP_DEP_DIVN_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_DIVN_DESC.setDisabled(disabled);
		COMP_DEP_DEPT_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_DEPT_DESC.setDisabled(disabled);
		COMP_DEP_CLASS_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_CLASS_CODE_DESC.setDisabled(disabled);
		COMP_DEP_BANKIN_CODE.setDisabled(disabled);
		COMP_UI_M_BANKIN_NAME.setDisabled(disabled);
		COMP_DEP_PLAN_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_PLAN_CODE_DESC.setDisabled(disabled);
		COMP_DEP_DS_CODE.setDisabled(disabled);
		COMP_UI_M_DEP_DS_CODE_DESC.setDisabled(disabled);
		COMP_DEP_SRC_OF_BUS.setDisabled(disabled);
		COMP_UI_M_DEP_BUS_DESC.setDisabled(disabled);
		COMP_DEP_REV_REMARKS.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_DEP_GROSS_NET_FLAG.setDisabled(disabled);
		COMP_DEP_REPL_RCPT_YN.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_DEP_DOC_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		/*COMP_UI_M_BUT_LOV_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_CONT_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_AGENT_CODE_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_COLL_AGENT_CODE_LOV.setDisabled(disabled);
		COMP_UI_M_BU_LOV_DEP_REF_NO.setDisabled(disabled);*/
		//COMP_UI_M_BUT_PYMT_DTLS.setDisabled(disabled);
		//COMP_UI_M_BUT_APPROVAL.setDisabled(disabled);
		//COMP_UI_M_BUT_CONTRACTOR.setDisabled(disabled);
		/*COMP_UI_M_BUT_DEP_PROD_CODE_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_POL_DET.setDisabled(disabled);*/
		COMP_UI_M_CHEQUE.setDisabled(disabled);
		prBt.setDisabled(disabled);

		/*Added by Ram on 17/04/2017 for disable all components if it is approved*/
		COMP_SAVE_BTN.setDisabled(disabled);
		COMP_CREDIT_BUS_YN.setDisabled(disabled);
		/*End*/
		
		/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
		COMP_DEP_COMM_YN.setDisabled(disabled);
		/*End*/
		/*Newly added into kic from fidelity by pidugu raj dt: 01-10-2018 as suggested by sivaraman*/
		COMP_UI_M_DEP_SUS_AMT.setDisabled(disabled);
		/*End Newly added into kic from fidelity by pidugu raj dt: 01-10-2018 as suggested by sivaraman*/
		/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
		//COMP_DEP_LC_AMT.setDisabled(disabled);
		//End
		//Added by rakesh on 17-03-2020
				
				COMP_DEP_CURR_CODE.setDisabled(disabled);
				
				//END
				//Added by rakesh on 06-07-2020 for total paid amount in FC instead of LC
				COMP_DEP_FC_TOTAL_AMT.setDisabled(disabled);
				//END

	}

	public HtmlOutputLabel getCOMP_DEP_MAST_RCPT_YN_LABEL() {
		return COMP_DEP_MAST_RCPT_YN_LABEL;
	}

	public void setCOMP_DEP_MAST_RCPT_YN_LABEL(
			HtmlOutputLabel comp_dep_mast_rcpt_yn_label) {
		COMP_DEP_MAST_RCPT_YN_LABEL = comp_dep_mast_rcpt_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_DEP_MAST_RCPT_YN() {
		return COMP_DEP_MAST_RCPT_YN;
	}

	public void setCOMP_DEP_MAST_RCPT_YN(HtmlSelectOneMenu comp_dep_mast_rcpt_yn) {
		COMP_DEP_MAST_RCPT_YN = comp_dep_mast_rcpt_yn;
	}

	public HtmlOutputLabel getCOMP_DEP_ADTH_BATCH_NO_LABEL() {
		return COMP_DEP_ADTH_BATCH_NO_LABEL;
	}

	public void setCOMP_DEP_ADTH_BATCH_NO_LABEL(
			HtmlOutputLabel comp_dep_adth_batch_no_label) {
		COMP_DEP_ADTH_BATCH_NO_LABEL = comp_dep_adth_batch_no_label;
	}

	public HtmlInputText getCOMP_DEP_ADTH_BATCH_NO() {
		return COMP_DEP_ADTH_BATCH_NO;
	}

	public void setCOMP_DEP_ADTH_BATCH_NO(HtmlInputText comp_dep_adth_batch_no) {
		COMP_DEP_ADTH_BATCH_NO = comp_dep_adth_batch_no;
	}
	
	/**
	 * 
	 * @return
	 */
	public String buttonPressContractor(){
		COMP_DEP_CONT_CODE.setRequired(false);
		COMP_DEP_LC_DEP_AMT.setRequired(false);
		CommonUtils.setGlobalVariable("GLOBAL.M_CONT_CODE", PT_IL_DEPOSIT_BEAN.getDEP_CONT_CODE());
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT016A_APAC");
		this.setBlockFlag(true);
		this.setFormFlag(true);
		return "PILM016_APAC_PM_IL_CONTRACTOR";
	}
	
	/**
	 * 
	 * @return
	 */
	public String buttonPressPolicyDetails(){
		try{
			helper.L_POPULATE_POLICY_DETAILS(compositeAction);
		}catch(Exception exception){
			exception.printStackTrace();
			getErrorMap().put("current", exception.getMessage());
		}
		return "goToPolicyDtls";
	}
	
	/**
	 * 
	 * @return
	 */
	public String mainButton(){
		this.setFormFlag(true);
		this.setBlockFlag(true);
		return "PILT016A_APAC_PT_IL_DEPOSIT";
	}
	
	public String callRefound(){
		String outcome = null;
		try{
			outcome = helper.buttonM_cheque(PT_IL_DEPOSIT_BEAN);
		}catch(Exception exception){
			exception.printStackTrace();
			getErrorMap().put("current", exception.getMessage());
		}
		return outcome;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REPORT() {
		return COMP_UI_M_BUT_REPORT;
	}

	public void setCOMP_UI_M_BUT_REPORT(HtmlCommandButton comp_ui_m_but_report) {
		COMP_UI_M_BUT_REPORT = comp_ui_m_but_report;
	}
	
	

/*
 * 
 * Commented by Janani on 12.9.2016 for dynamic report config
 * 
 * 
 * 	public String runAction() {
		String redirectUrl=null;
		CommonUtils.clearMaps(this);
 		setRedirectUrl(null);
		HttpServletResponse response=null;
		Connection connection=null;
		String repid=null;
		IP_REP_INFO_BEAN.setREP_ID("PRM_ADV");
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE() != null
					&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO() != 0) {
			IP_REP_INFO_BEAN.setREP_VALUE_17(PT_IL_DEPOSIT_BEAN.getDEP_SYS_ID().toString());
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				helper.PRE_INSERT(IP_REP_INFO_BEAN);
			} else {
				helper.PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}

			delegate.executeSaveAction(this.IP_REP_INFO_BEAN);
			connection=CommonUtils.getConnection();
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
																				.getResponse();
			map.put("P_LANG_CODE", CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			map.put("P_DEP_SYS_ID",PT_IL_DEPOSIT_BEAN.getDEP_SYS_ID().toString());
			map.put("P_REP_NAME","PILR_REC001");
			redirectUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(),"PILR_REC001",
					repid,IP_REP_INFO_BEAN.getSelectedFileTyp(), map);
			// response.sendRedirect(redirectUrl);
		
			Added By Gopinath 21.3.2016
			
			StringBuffer url=new StringBuffer();
			String DEP_REF_NO=PT_IL_DEPOSIT_BEAN.getDEP_REF_NO();
			System.out.println("PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()   : "+PT_IL_DEPOSIT_BEAN.getDEP_REF_NO());
		
			url=new StringBuffer(redirectUrl);
			url.append("&DEP_REF_NO="+DEP_REF_NO);
			End
			
			setRedirectUrl(url.toString());
			}else {
				throw new Exception("UnApproved Record");
			}
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("RunAction", e.getMessage());
	}
	return redirectUrl;
 }*/

	
	
	
	
/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");
	StringBuffer url=null;
	
	public String printButtonAction() {

		System.out.println("Enter printButtonAction");
		callReportModalPanel();

		return getRedirectUrl();
	}
	
	
	
	@Override
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
			if (PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE() != null
					&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO() != 0) {
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}else {
				throw new Exception("UnApproved Record");
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	
	
	
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=3;
		/*System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");*/
		System.out.println("decimalPlaces   : "+decimalPlaces);
		
		
		BigDecimal bd = new BigDecimal(Value);
	    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	    
	    return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}

	
	
	
	/*END*/
	
	

	/*Modified by Sivarajan on 16/09/2020 for Allaiance IL*/
	public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;

	
	try {
	
		/*Added by Janani on 30.8.2016 for dynamic report config*/
		IP_REP_INFO repInfo = new IP_REP_INFO();
		String sentance1 = resourceBundle.getString("word_1");
		String sentance2 =resourceBundle.getString("word_2");  
		String sentance3 =resourceBundle.getString("word_3"); 
		String DEP_REF_NO=PT_IL_DEPOSIT_BEAN.getDEP_REF_NO();
		int P_DEP_DOC_NO = PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO();
		String Report_Id = resourceBundle.getString("PremiumRecept");
		RUPEE_TO_WORD rupee = new RUPEE_TO_WORD();
		String DEP_LC_DEP_AMT =rupee.getamtfromtable(DEP_REF_NO,String.valueOf(P_DEP_DOC_NO),CommonUtils.getConnection());
		String PAYMENT_MODE=rupee.paymentMode(DEP_REF_NO,CommonUtils.getConnection());
		/*String Amount=rupee.getRupeeinword(CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT));*/
		/*String Totalword=sentance1+DEP_LC_DEP_AMT+"(R.O."+Amount+sentance2+" "+PAYMENT_MODE+" "+sentance3;*/
	
		String User_Id = (String) session.getAttribute("GLOBAL.M_USER_ID");
		String query="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		ResultSet C16_REC = null;
		Long pol_sys_id =null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = CommonUtils.getConnection();
		C16_REC = handler.executeSelectStatement(query, con,
				new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
		if (C16_REC.next()) {
			
			pol_sys_id=C16_REC.getLong("POL_SYS_ID");
			
		}
		
		
		
		String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
		repInfo.setREP_KEY_NO(REP_KEY_NO);
		repInfo.setREP_VALUE_1("7");
		repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+DEP_REF_NO);
		//repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+pol_sys_id);
		repInfo.setREP_VALUE_3("P_DEP_DOC_NO"+"&&&"+P_DEP_DOC_NO);
		repInfo.setREP_VALUE_4("USER_ID"+"&&&"+User_Id);
		/*repInfo.setREP_VALUE_5("CUR_WORD_1"+"&&&"+Totalword);*/
		//added by agalya
		if(DEP_LC_DEP_AMT != null)
		{
			repInfo.setREP_VALUE_6("DEP_LC_DEP_AMT"+"&&&"+CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT));
		
		}
		else
		{
			repInfo.setREP_VALUE_6("DEP_LC_DEP_AMT"+"&&&"+"0.000");
		}
		/*repInfo.setREP_VALUE_7("CUR_WORD_3"+"&&&"+Amount);*/
			
		Connection conn = CommonUtils.getConnection();
		int ins = new CRUDHandler().executeInsert(repInfo, conn);
		conn.commit();
					
		url=new StringBuffer(getRedirectUrl());
		System.out.println("this is url"+url.toString());
		url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+Report_Id);	
		setRedirectUrl(url.toString());	
		
		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
		}
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
/*end*/
	
	
	
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}

	public HtmlTab getCOMP_MORE_INFO_2() {
		return COMP_MORE_INFO_2;
	}

	public void setCOMP_MORE_INFO_2(HtmlTab comp_more_info_2) {
		COMP_MORE_INFO_2 = comp_more_info_2;
	}

	public HtmlOutputText getCOMP_UI_M_REC_REVERSE() {
		return COMP_UI_M_REC_REVERSE;
	}

	public void setCOMP_UI_M_REC_REVERSE(HtmlOutputText comp_ui_m_rec_reverse) {
		COMP_UI_M_REC_REVERSE = comp_ui_m_rec_reverse;
	}
	/*Added by Ram on 23/12/2016 for Credit Business field*/
	private HtmlOutputLabel COMP_CREDIT_BUSINESS_LABEL;
	private HtmlSelectOneMenu COMP_CREDIT_BUS_YN;

	public HtmlOutputLabel getCOMP_CREDIT_BUSINESS_LABEL() {
		return COMP_CREDIT_BUSINESS_LABEL;
	}

	public void setCOMP_CREDIT_BUSINESS_LABEL(
			HtmlOutputLabel cOMP_CREDIT_BUSINESS_LABEL) {
		COMP_CREDIT_BUSINESS_LABEL = cOMP_CREDIT_BUSINESS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CREDIT_BUS_YN() {
		return COMP_CREDIT_BUS_YN;
	}

	public void setCOMP_CREDIT_BUS_YN(HtmlSelectOneMenu cOMP_CREDIT_BUS_YN) {
		COMP_CREDIT_BUS_YN = cOMP_CREDIT_BUS_YN;
	}
	
	public void whenListChangeReplaceCreditBusYN(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputData = input.getSubmittedValue().toString();
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_CREDIT_BUS_YN(inputData);
		 
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateDEP_CREDIT_BUS_YN(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {
			PT_IL_DEPOSIT_BEAN.setDEP_CREDIT_BUS_YN(value);
			 
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	private List<SelectItem> creditYNList = new ArrayList<SelectItem>();

	public List<SelectItem> getCreditYNList() {
		return creditYNList;
	}

	public void setCreditYNList(List<SelectItem> creditYNList) {
		this.creditYNList = creditYNList;
	}
	/*End*/
	
	/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
	private List<SelectItem> commisionYNList = new ArrayList<SelectItem>();
	
	public List<SelectItem> getCommisionYNList() {
		return commisionYNList;
	}

	public void setCommisionYNList(List<SelectItem> commisionYNList) {
		this.commisionYNList = commisionYNList;
	}
	
	/*End*/

	/*Added by Ram on 10/01/2017 as per Kuzhandhai suggestion*/
	public void RefNofireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		System.out.println("Welcome to setTotalAmount");
		System.out.println("PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM()  "+PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		
		/*PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());*/
		 
		System.out.println("PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT()  "+PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT());
		try{
			/*Added by senthilnathan for orient on 06.04.2020*/
		PT_IL_DEPOSIT_BEAN.setDEP_FC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_FC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());//Added since the column present in screen level 
		//Modified by rakesh on 23-06-2020 for orient as per sivaram sugg:
		/*Comment by rakesh on 06-07-2020 for receipt total paid amount Fc value instead of LC amount as sugg by raja sir*/
		ArrayList<String> pValList = new ArrayList<String>();	
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		String CURSOR_C24 = "SELECT POL_CUST_CURR_CODE FROM   PT_IL_POLICY WHERE POL_NO = ? ";
		ResultSet rsC24 = null;
		String pol_cust_curr_code = null;
		rsC24 = new CRUDHandler().executeSelectStatement(CURSOR_C24,
				CommonUtils.getConnection(),
				new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
		
		if (rsC24.next()) {
			pol_cust_curr_code = rsC24.getString(1);
		}
		/*pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE(),
				"S",  CommonUtils
				.getProcedureValue(new Date()), CommonUtils
						.getProcedureValue(PT_IL_DEPOSIT_BEAN
								.getDEP_CUST_EXCH_RATE()), "E");*/
		
		/*Newly added by pidugu raj dt: 13-09-2020 as suggested by KK handled if both policy currency and receipt currency are usd*/
		
		if(pol_cust_curr_code.equalsIgnoreCase("USD")){
			if(pol_cust_curr_code.equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE())){
				/*Changing To currency to Base currency*/
				pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE_AI_IL(pol_cust_curr_code,CommonUtils.getControlBean()
						.getM_BASE_CURR(),
						"S",  CommonUtils
						.getProcedureValue(new Date()), CommonUtils
								.getProcedureValue(PT_IL_DEPOSIT_BEAN
										.getDEP_CUST_EXCH_RATE()), "E");
				
				if (pValList != null) {
					if (pValList.get(0) != null) {
					System.out.println(pValList.get(0));
					
						PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(Double.parseDouble(CommonUtils.nvl(pValList
								.get(0),"1.0")));
						
					}
				}
				else
				{
					
					Double SA_RATE = null;
					SA_RATE =Double.parseDouble(pValList.get(0));
					if(SA_RATE ==null || SA_RATE ==0 || SA_RATE == 0.0 || SA_RATE == 0.00 || SA_RATE == 0.000)
					{
						PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(CommonUtils.nvl(SA_RATE,1.0));	
					}
				}
				
			}
			//roundOff 10July2024
//			PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(CommonUtils.ROUND(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE(),2));
//			PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(CommonUtils.ROUND(PT_IL_DEPOSIT_BEAN.getDEP_FC_TOTAL_AMT() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE(),2));
			PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT());
		}else{
		pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE_AI_IL(pol_cust_curr_code,PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE(),
				"S",  CommonUtils
				.getProcedureValue(new Date()), CommonUtils
						.getProcedureValue(PT_IL_DEPOSIT_BEAN
								.getDEP_CUST_EXCH_RATE()), "E");

		
		if (pValList != null) {
			if (pValList.get(0) != null) {
			System.out.println(pValList.get(0));
			
				PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(Double.parseDouble(CommonUtils.nvl(pValList
						.get(0),"1.0")));
				
			}
		}
		else
		{
			
			Double SA_RATE = null;
			SA_RATE =Double.parseDouble(pValList.get(0));
			if(SA_RATE ==null || SA_RATE ==0 || SA_RATE == 0.0 || SA_RATE == 0.00 || SA_RATE == 0.000)
			{
				PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(CommonUtils.nvl(SA_RATE,1.0));	
			}
		}
		
		//Added by rakesh on 23-06-2020 for orient as per sivaram sugg:
				PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getDEP_FC_TOTAL_AMT() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				//END
		}
		//COMP_DEP_LC_TOTAL_AMT.resetValue();
		COMP_DEP_FC_TOTAL_AMT.resetValue();
		COMP_DEP_LC_DEP_AMT.resetValue();
		COMP_DEP_LC_TOT_AMT.resetValue();
		//COMP_DEP_LC_AMT.resetValue();
		}catch(Exception e){
			e.printStackTrace();
			}
		
		
	}
	public void setTotalAmount()
	{
		
		System.out.println("Welcome to setTotalAmount");
		System.out.println("PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM()  "+PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		
		PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		//PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM());
		System.out.println("PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT()  "+PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT());
		
		COMP_DEP_LC_TOTAL_AMT.resetValue();
		COMP_DEP_LC_DEP_AMT.resetValue();
		COMP_DEP_LC_TOT_AMT.resetValue();
		//COMP_DEP_LC_AMT.resetValue();
		
	}
	/*End*/
	
	/*Added by Ameen on 03-07-2017 FOR ZBILQC-1729834*/
	private HtmlTab COMP_REVERSED_DETAILS;
	
	private HtmlOutputLabel COMP_UI_M_DEP_LC_DEP_AMT_LABEL;
	
	private HtmlInputText COMP_UI_M_DEP_LC_DEP_AMT;
	
	private HtmlOutputLabel COMP_UI_M_DEP_FLEX_01_LABEL;

	private HtmlCalendar COMP_UI_M_DEP_FLEX_01;

	private HtmlOutputLabel COMP_UI_M_DEP_FLEX_02_LABEL;

	private HtmlInputText COMP_UI_M_DEP_FLEX_02;

	private HtmlOutputLabel COMP_UI_M_DEP_FLEX_03_LABEL;

	private HtmlInputText COMP_UI_M_DEP_FLEX_03;

	private HtmlOutputLabel COMP_UI_M_DEP_FLEX_04_LABEL;

	private HtmlInputText COMP_UI_M_DEP_FLEX_04;
	
	private HtmlOutputLabel COMP_UI_M_REASON_CODE_LABEL;

	private HtmlInputText COMP_UI_M_REASON_CODE;
	
	private HtmlInputText COMP_UI_M_REASON_CODE_DESC;

	public HtmlTab getCOMP_REVERSED_DETAILS() {
		return COMP_REVERSED_DETAILS;
	}

	public void setCOMP_REVERSED_DETAILS(HtmlTab cOMP_REVERSED_DETAILS) {
		COMP_REVERSED_DETAILS = cOMP_REVERSED_DETAILS;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_FLEX_01_LABEL() {
		return COMP_UI_M_DEP_FLEX_01_LABEL;
	}

	public void setCOMP_UI_M_DEP_FLEX_01_LABEL(
			HtmlOutputLabel cOMP_UI_M_DEP_FLEX_01_LABEL) {
		COMP_UI_M_DEP_FLEX_01_LABEL = cOMP_UI_M_DEP_FLEX_01_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_DEP_FLEX_01() {
		return COMP_UI_M_DEP_FLEX_01;
	}

	public void setCOMP_UI_M_DEP_FLEX_01(HtmlCalendar cOMP_UI_M_DEP_FLEX_01) {
		COMP_UI_M_DEP_FLEX_01 = cOMP_UI_M_DEP_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_FLEX_02_LABEL() {
		return COMP_UI_M_DEP_FLEX_02_LABEL;
	}

	public void setCOMP_UI_M_DEP_FLEX_02_LABEL(
			HtmlOutputLabel cOMP_UI_M_DEP_FLEX_02_LABEL) {
		COMP_UI_M_DEP_FLEX_02_LABEL = cOMP_UI_M_DEP_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_FLEX_02() {
		return COMP_UI_M_DEP_FLEX_02;
	}

	public void setCOMP_UI_M_DEP_FLEX_02(HtmlInputText cOMP_UI_M_DEP_FLEX_02) {
		COMP_UI_M_DEP_FLEX_02 = cOMP_UI_M_DEP_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_FLEX_03_LABEL() {
		return COMP_UI_M_DEP_FLEX_03_LABEL;
	}

	public void setCOMP_UI_M_DEP_FLEX_03_LABEL(
			HtmlOutputLabel cOMP_UI_M_DEP_FLEX_03_LABEL) {
		COMP_UI_M_DEP_FLEX_03_LABEL = cOMP_UI_M_DEP_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_FLEX_03() {
		return COMP_UI_M_DEP_FLEX_03;
	}

	public void setCOMP_UI_M_DEP_FLEX_03(HtmlInputText cOMP_UI_M_DEP_FLEX_03) {
		COMP_UI_M_DEP_FLEX_03 = cOMP_UI_M_DEP_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_FLEX_04_LABEL() {
		return COMP_UI_M_DEP_FLEX_04_LABEL;
	}

	public void setCOMP_UI_M_DEP_FLEX_04_LABEL(
			HtmlOutputLabel cOMP_UI_M_DEP_FLEX_04_LABEL) {
		COMP_UI_M_DEP_FLEX_04_LABEL = cOMP_UI_M_DEP_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_FLEX_04() {
		return COMP_UI_M_DEP_FLEX_04;
	}

	public void setCOMP_UI_M_DEP_FLEX_04(HtmlInputText cOMP_UI_M_DEP_FLEX_04) {
		COMP_UI_M_DEP_FLEX_04 = cOMP_UI_M_DEP_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_LABEL() {
		return COMP_UI_M_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE_LABEL(
			HtmlOutputLabel cOMP_UI_M_REASON_CODE_LABEL) {
		COMP_UI_M_REASON_CODE_LABEL = cOMP_UI_M_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE() {
		return COMP_UI_M_REASON_CODE;
	}

	public void setCOMP_UI_M_REASON_CODE(HtmlInputText cOMP_UI_M_REASON_CODE) {
		COMP_UI_M_REASON_CODE = cOMP_UI_M_REASON_CODE;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE_DESC() {
		return COMP_UI_M_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC(
			HtmlInputText cOMP_UI_M_REASON_CODE_DESC) {
		COMP_UI_M_REASON_CODE_DESC = cOMP_UI_M_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEP_LC_DEP_AMT_LABEL() {
		return COMP_UI_M_DEP_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_UI_M_DEP_LC_DEP_AMT_LABEL(
			HtmlOutputLabel cOMP_UI_M_DEP_LC_DEP_AMT_LABEL) {
		COMP_UI_M_DEP_LC_DEP_AMT_LABEL = cOMP_UI_M_DEP_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_LC_DEP_AMT() {
		return COMP_UI_M_DEP_LC_DEP_AMT;
	}

	public void setCOMP_UI_M_DEP_LC_DEP_AMT(HtmlInputText cOMP_UI_M_DEP_LC_DEP_AMT) {
		COMP_UI_M_DEP_LC_DEP_AMT = cOMP_UI_M_DEP_LC_DEP_AMT;
	}

	/*End*/
	
	/*added by raja on 16-08-2017 for direct depit disscused with siva sir*/ 
	private HtmlOutputLabel COMP_DEP_AMT_PAYOR_NAME_LABEL;

	private HtmlInputText COMP_DEP_AMT_PAYOR_NAME;
	
	private HtmlOutputLabel COMP_DEP_AMT_PAYOR_CONTACT_LABEL;

	private HtmlInputText COMP_DEP_AMT_PAYOR_CONTACT;

	public HtmlOutputLabel getCOMP_DEP_AMT_PAYOR_NAME_LABEL() {
		return COMP_DEP_AMT_PAYOR_NAME_LABEL;
	}

	public void setCOMP_DEP_AMT_PAYOR_NAME_LABEL(
			HtmlOutputLabel cOMP_DEP_AMT_PAYOR_NAME_LABEL) {
		COMP_DEP_AMT_PAYOR_NAME_LABEL = cOMP_DEP_AMT_PAYOR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEP_AMT_PAYOR_NAME() {
		return COMP_DEP_AMT_PAYOR_NAME;
	}

	public void setCOMP_DEP_AMT_PAYOR_NAME(HtmlInputText cOMP_DEP_AMT_PAYOR_NAME) {
		COMP_DEP_AMT_PAYOR_NAME = cOMP_DEP_AMT_PAYOR_NAME;
	}

	public HtmlOutputLabel getCOMP_DEP_AMT_PAYOR_CONTACT_LABEL() {
		return COMP_DEP_AMT_PAYOR_CONTACT_LABEL;
	}

	public void setCOMP_DEP_AMT_PAYOR_CONTACT_LABEL(
			HtmlOutputLabel cOMP_DEP_AMT_PAYOR_CONTACT_LABEL) {
		COMP_DEP_AMT_PAYOR_CONTACT_LABEL = cOMP_DEP_AMT_PAYOR_CONTACT_LABEL;
	}

	public HtmlInputText getCOMP_DEP_AMT_PAYOR_CONTACT() {
		return COMP_DEP_AMT_PAYOR_CONTACT;
	}

	public void setCOMP_DEP_AMT_PAYOR_CONTACT(
			HtmlInputText cOMP_DEP_AMT_PAYOR_CONTACT) {
		COMP_DEP_AMT_PAYOR_CONTACT = cOMP_DEP_AMT_PAYOR_CONTACT;
	}
	/*end*/
	
	
	/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
	private HtmlOutputLabel COMP_DEP_COMM_YN_LABEL;

	public HtmlOutputLabel getCOMP_DEP_COMM_YN_LABEL() {
		return COMP_DEP_COMM_YN_LABEL;
	}

	public void setCOMP_DEP_COMM_YN_LABEL(HtmlOutputLabel cOMP_DEP_COMM_YN_LABEL) {
		COMP_DEP_COMM_YN_LABEL = cOMP_DEP_COMM_YN_LABEL;
	}
	
	private HtmlSelectOneMenu COMP_DEP_COMM_YN;

	public HtmlSelectOneMenu getCOMP_DEP_COMM_YN() {
		return COMP_DEP_COMM_YN;
	}

	public void setCOMP_DEP_COMM_YN(HtmlSelectOneMenu cOMP_DEP_COMM_YN) {
		COMP_DEP_COMM_YN = cOMP_DEP_COMM_YN;
	}
	
	public void validateDEP_COMM_YN(FacesContext context,
			UIComponent component, Object object) {
		String value = (String) object;
		try {

			PT_IL_DEPOSIT_BEAN.setDEP_COMM_YN(value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void whenListChangeCommissionYN(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputData = input.getSubmittedValue().toString();
		try {

			PT_IL_DEPOSIT_BEAN.setDEP_COMM_YN(inputData);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End*/
	
	/*Added by saritha on 07-11-2017 for Premium Collection Issues*/
	public void getExcludingCommissionYN() {
		Connection connection = null;
		ResultSet resultSet = null;
		String check_value = null;
		Object[] value = null;

		try {

			connection = CommonUtils.getConnection();
			String query = "SELECT 'X' FROM PM_CUSTOMER, PM_CUST_CLASS WHERE CUST_CLASS = CCLAS_CODE AND CCLAS_TYPE = '001' AND CUST_FLEX_SEL_01 = 'Y' AND CUST_CODE = ?";
			value = new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE()};
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,value);
			if(resultSet.next()){
				check_value = resultSet.getString(1);
				getCOMP_DEP_COMM_YN().setRequired(true);
				getCOMP_DEP_COMM_YN().setDisabled(false);

			}

			else {

				getCOMP_DEP_COMM_YN().setRequired(false);
				getCOMP_DEP_COMM_YN().setDisabled(true);
			}


		} catch (Exception exp) {
			exp.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/*End*/
	
	/*Added by Janani on 11.06.2018 for FSD_IL_FLA_019 */
	public void upt_lc_amt() throws Exception
	{
		
		String C16 = "SELECT DEP_LC_TOTAL_AMT FROM PT_IL_DEPOSIT  WHERE DEP_SYS_ID = ?";
		ResultSet C16_REC = null;
		Double lc_tot_amt = 0.0;
		CRUDHandler handler = new CRUDHandler();
		Connection con = CommonUtils.getConnection();
		C16_REC = handler.executeSelectStatement(C16, con,
				new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_SYS_ID() });
		if (C16_REC.next()) {
			
			PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(C16_REC.getDouble(1));
			//PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(C16_REC.getDouble(1));
			
		}
		
		
	}
	/*End*/
	/*Added by kavitha on 13.08.2018 for FLALIFEQC-1761039*/
    private HtmlOutputLabel COMP_UI_M_DEP_SUS_AMT_LABEL;
	
	private HtmlInputText COMP_UI_M_DEP_SUS_AMT;
	
	
	public HtmlOutputLabel getCOMP_UI_M_DEP_SUS_AMT_LABEL() {
		return COMP_UI_M_DEP_SUS_AMT_LABEL;
	}

	public void setCOMP_UI_M_DEP_SUS_AMT_LABEL(
			HtmlOutputLabel cOMP_UI_M_DEP_SUS_AMT_LABEL) {
		COMP_UI_M_DEP_SUS_AMT_LABEL = cOMP_UI_M_DEP_SUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEP_SUS_AMT() {
		return COMP_UI_M_DEP_SUS_AMT;
	}

	public void setCOMP_UI_M_DEP_SUS_AMT(HtmlInputText cOMP_UI_M_DEP_SUS_AMT) {
		COMP_UI_M_DEP_SUS_AMT = cOMP_UI_M_DEP_SUS_AMT;
	}
	/*Added by kavitha on 13.08.2018 for FLALIFEQC-1761039*/ 
	public void getPol_receipt_dtls() {
		
		 Connection connection = null;
		 ResultSet rs = null;
		 String query = "SELECT PDU_DEP_AMT,PDU_UTIL_AMT FROM PT_IL_POL_DEPUTIL WHERE PDU_POL_NO = ?";
		 try {
		
			 connection = CommonUtils.getConnection();
			 rs = new CRUDHandler().executeSelectStatement(query, connection,  new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()});
			
			 if(rs.next()) {
				 
				 PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DEPOSIT_AMT(rs.getDouble("PDU_DEP_AMT"));
				 PT_IL_DEPOSIT_BEAN.setUI_M_DEP_UTIL_AMT(rs.getDouble("PDU_UTIL_AMT"));
				 
				 Double sus_amt = ((PT_IL_DEPOSIT_BEAN.getUI_M_DEP_DEPOSIT_AMT()) - (PT_IL_DEPOSIT_BEAN.getUI_M_DEP_UTIL_AMT()));
				 
				 PT_IL_DEPOSIT_BEAN.setUI_M_DEP_SUS_AMT(sus_amt);
				 
			 }
		
			 System.out.println("getUI_M_DEP_DEPOSIT_AMT                "+PT_IL_DEPOSIT_BEAN.getUI_M_DEP_DEPOSIT_AMT()+
					 "    getUI_M_DEP_UTIL_AMT         "+PT_IL_DEPOSIT_BEAN.getUI_M_DEP_UTIL_AMT());
			 
			
			} catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	/* End*/
	
	/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
	private HtmlOutputLabel COMP_DEP_LC_AMT_LABEL;

	public HtmlOutputLabel getCOMP_DEP_LC_AMT_LABEL() {
		return COMP_DEP_LC_AMT_LABEL;
	}

	public void setCOMP_DEP_LC_AMT_LABEL(HtmlOutputLabel cOMP_DEP_LC_AMT_LABEL) {
		COMP_DEP_LC_AMT_LABEL = cOMP_DEP_LC_AMT_LABEL;
	}
	
	private HtmlInputText COMP_DEP_LC_AMT;

	public HtmlInputText getCOMP_DEP_LC_AMT() {
		return COMP_DEP_LC_AMT;
	}

	public void setCOMP_DEP_LC_AMT(HtmlInputText cOMP_DEP_LC_AMT) {
		COMP_DEP_LC_AMT = cOMP_DEP_LC_AMT;
	}
	
	/*End*/
	
	//Added by rakesh on 06-03-2020 for orient uat issue : currency field 
		private HtmlOutputLabel COMP_DEP_CURR_CODE_LABEL;
		private HtmlInputText COMP_DEP_CURR_CODE;
		private HtmlInputText COMP_DEP_CURR_DESC;

		public HtmlOutputLabel getCOMP_DEP_CURR_CODE_LABEL() {
			return COMP_DEP_CURR_CODE_LABEL;
		}
		public void setCOMP_DEP_CURR_CODE_LABEL(HtmlOutputLabel cOMP_DEP_CURR_CODE_LABEL) {
			COMP_DEP_CURR_CODE_LABEL = cOMP_DEP_CURR_CODE_LABEL;
		}
		public HtmlInputText getCOMP_DEP_CURR_CODE() {
			return COMP_DEP_CURR_CODE;
		}
		public void setCOMP_DEP_CURR_CODE(HtmlInputText cOMP_DEP_CURR_CODE) {
			COMP_DEP_CURR_CODE = cOMP_DEP_CURR_CODE;
		}
		public HtmlInputText getCOMP_DEP_CURR_DESC() {
			return COMP_DEP_CURR_DESC;
		}
		public void setCOMP_DEP_CURR_DESC(HtmlInputText cOMP_DEP_CURR_DESC) {
			COMP_DEP_CURR_DESC = cOMP_DEP_CURR_DESC;
		}
	 public void validateDEP_CURR_CODE(FacesContext facesContext,
			 UIComponent component, Object value) throws ValidatorException {
		 try {
			 PT_IL_DEPOSIT_BEAN.setDEP_CURR_CODE((String) value);
			 COMP_DEP_CURR_CODE.resetValue();
			 COMP_DEP_CURR_DESC.resetValue();
			 ArrayList<String> pValList = new ArrayList<String>();	
				PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			    String date_1 = formatter.format(Calendar.getInstance().getTimeInMillis());
			    System.out.println(date_1);
			    
			    
			/*Added by senthilnathan for orient on 07.04.2020*/   
			String Curr_code =(String)value;
			String Pay_mode = null;
			ResultSet rs1 = null;
			String basepay = "SELECT PARA_VALUE FROM fp_parameter where para_id = 'BASE.CURR'";

			rs1 = new CRUDHandler().executeSelectStatement(basepay,
					CommonUtils.getConnection());
			if (rs1.next()) {
				Pay_mode = rs1.getString(1);
			}
			/*Commented due to everytime taking only USD Currency for exchange rate to calculate
			 * if (Pay_mode.equalsIgnoreCase((String) value)) {
				String CURSOR_C24 = "SELECT POL_SA_CURR_CODE FROM   PT_IL_POLICY WHERE POL_NO = ? ";
				ResultSet rsC24 = null;
				rsC24 = new CRUDHandler().executeSelectStatement(CURSOR_C24,
						CommonUtils.getConnection(),
						new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
				if (rsC24.next()) {
					Curr_code = rsC24.getString(1);
				}

			}*/
			
			/*Newly added by pidugu raj dt:25-08-2020 as suggested by sitrasan for new procedure input of policy currency*/
			String CURSOR_C24 = "SELECT POL_CUST_CURR_CODE FROM   PT_IL_POLICY WHERE POL_NO = ? ";
			ResultSet rsC24 = null;
			String pol_cust_curr_code = null;
			rsC24 = new CRUDHandler().executeSelectStatement(CURSOR_C24,
					CommonUtils.getConnection(),
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
			
			if (rsC24.next()) {
				pol_cust_curr_code = rsC24.getString(1);
			}
			
				/*pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(Curr_code,
						"S",  CommonUtils
						.getProcedureValue(new Date()), CommonUtils
								.getProcedureValue(PT_IL_DEPOSIT_BEAN
										.getDEP_CUST_EXCH_RATE()), "E");*/
			/*Newly added by pidugu raj dt: 13-09-2020 as suggested by KK handled if both policy currency and receipt currency are usd*/
			
			if(pol_cust_curr_code.equalsIgnoreCase("USD")){
				if(pol_cust_curr_code.equalsIgnoreCase(Curr_code)){
					/*Changing To currency to Base currency*/
					pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE_AI_IL(pol_cust_curr_code,CommonUtils.getControlBean()
							.getM_BASE_CURR(),
							"S",  CommonUtils
							.getProcedureValue(new Date()), CommonUtils
									.getProcedureValue(PT_IL_DEPOSIT_BEAN
											.getDEP_CUST_EXCH_RATE()), "E");
					
					if (pValList != null) {
						if (pValList.get(0) != null) {
						System.out.println(pValList.get(0));
						
							PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(Double.parseDouble(CommonUtils.nvl(pValList
									.get(0),"1.0")));
							
						}
					}
					else
					{
						
						Double SA_RATE = null;
						SA_RATE =Double.parseDouble(pValList.get(0));
						if(SA_RATE ==null || SA_RATE ==0 || SA_RATE == 0.0 || SA_RATE == 0.00 || SA_RATE == 0.000)
						{
							PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(CommonUtils.nvl(SA_RATE,1.0));	
						}
					}
					
				}
				PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
			}else{
			
			pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE_AI_IL(pol_cust_curr_code,Curr_code,
					"S",  CommonUtils
					.getProcedureValue(new Date()), CommonUtils
							.getProcedureValue(PT_IL_DEPOSIT_BEAN
									.getDEP_CUST_EXCH_RATE()), "E");
			/*End Newly added by pidugu raj dt: 25-08-2020 as suggested by kk for Alliance IL*/
				
				if (pValList != null) {
					if (pValList.get(0) != null) {
					System.out.println(pValList.get(0));
					
						PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(Double.parseDouble(CommonUtils.nvl(pValList
								.get(0),"1.0")));
						
					}
				}
				else
				{
					
					Double SA_RATE = null;
					SA_RATE =Double.parseDouble(pValList.get(0));
					if(SA_RATE ==null || SA_RATE ==0 || SA_RATE == 0.0 || SA_RATE == 0.00 || SA_RATE == 0.000)
					{
						PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(CommonUtils.nvl(SA_RATE,1.0));	
					}
				}
				PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
			}//If policy currency and local currency are not USD
				//End

				//Commented by rakesh on 23-06-2020 for orient sugg by vinoth and sivaram
				//PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				//PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				//PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				//PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				PT_IL_DEPOSIT_BEAN.setDEP_FC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				PT_IL_DEPOSIT_BEAN.setDEP_FC_DEP_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
				
				System.out.println("PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT()  "+PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT());
				/*end*/
				COMP_DEP_FC_TOTAL_AMT.resetValue();
				COMP_DEP_LC_DEP_AMT.resetValue();
				COMP_DEP_LC_TOT_AMT.resetValue();
				////COMP_DEP_LC_AMT.resetValue();
				
		 } catch (Exception exception) {
			 exception.printStackTrace();
			 throw new ValidatorException(new FacesMessage(exception
					 .getMessage()));
		 } finally {
			 try {
				 ErrorHelpUtil.getWarningForProcedure(CommonUtils
						 .getConnection(), "DEP_CURR_CODE", getWarningMap());
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovDEP_CURR_CODE(
				Object currValue) {
			ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
				suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
						"PT_IL_POLICY", "POL_SA_CURR_CODE", PT_IL_DEPOSIT_BEAN
						.getDEP_CUST_CODE(), PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE(), null, null, null,
						(String) currValue);
				if(currValue == null || currValue.toString().isEmpty()){
					PT_IL_DEPOSIT_BEAN.setUI_M_DEP_CURR_DESC(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}
	 private HtmlOutputLabel COMP_DEP_FC_TOTAL_AMT_LABEL;
	 private HtmlInputText COMP_DEP_FC_TOTAL_AMT;
	 
	 
	 public HtmlOutputLabel getCOMP_DEP_FC_TOTAL_AMT_LABEL() {
		return COMP_DEP_FC_TOTAL_AMT_LABEL;
	}
	public void setCOMP_DEP_FC_TOTAL_AMT_LABEL(
			HtmlOutputLabel cOMP_DEP_FC_TOTAL_AMT_LABEL) {
		COMP_DEP_FC_TOTAL_AMT_LABEL = cOMP_DEP_FC_TOTAL_AMT_LABEL;
	}
	public HtmlInputText getCOMP_DEP_FC_TOTAL_AMT() {
		return COMP_DEP_FC_TOTAL_AMT;
	}
	public void setCOMP_DEP_FC_TOTAL_AMT(HtmlInputText cOMP_DEP_FC_TOTAL_AMT) {
		COMP_DEP_FC_TOTAL_AMT = cOMP_DEP_FC_TOTAL_AMT;
	}
	 public void validateFC_TOTAL_PAID_PREMIUM(FacesContext context,
				UIComponent component, Object object) {
			Double value = (Double) object;
			PT_IL_DEPOSIT_BEAN.setDEP_FC_TOTAL_AMT(value);
			ResultSet currRS = null,rs1=null;
			String CurrQuery = null;
			String currcode= null;
			String Loan_Query = null;
			String loan_policy_no= null;
			try {
				if (value != null) {
					if(value==0){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91004"));
					}
					DBProcedures procedures = new DBProcedures();
					String currCode = CommonUtils.getGlobalVariable("GLOBAL.CURR_CODE");
					procedures.P_VAL_ROUND_AMT(currCode, PT_IL_DEPOSIT_BEAN.getDEP_FC_TOTAL_AMT(), "R", PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE());
					if ("Q".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN().getDEP_TYPE())
							&& value > 0) {
						CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "QD");
					} else if ("P".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN()
							.getDEP_TYPE())
							&& value > 0) {
						CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
					}
					else if ("S".equalsIgnoreCase(getPT_IL_DEPOSIT_BEAN()
							.getDEP_TYPE())
							&& value > 0) {
						CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
					
					}
					ArrayList<String> pValList = new ArrayList<String>();	
					PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
					pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE(),
							"S",  CommonUtils
							.getProcedureValue(new Date()), CommonUtils
									.getProcedureValue(PT_IL_DEPOSIT_BEAN
											.getDEP_CUST_EXCH_RATE()), "E");

					
					if (pValList != null) {
						if (pValList.get(0) != null) {
						System.out.println(pValList.get(0));
						
							PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(Double.parseDouble(CommonUtils.nvl(pValList
									.get(0),"1.0")));
							
						}
					}
					else
					{
						
						Double SA_RATE = null;
						SA_RATE =Double.parseDouble(pValList.get(0));
						if(SA_RATE ==null || SA_RATE ==0 || SA_RATE == 0.0 || SA_RATE == 0.00 || SA_RATE == 0.000)
						{
							PT_IL_DEPOSIT_BEAN.setDEP_CUST_EXCH_RATE(CommonUtils.nvl(SA_RATE,1.0));	
						}
					}
					
					if (CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_FC_TOTAL_AMT(),0) != null) {
						PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT_BEAN.getDEP_FC_TOTAL_AMT() * PT_IL_DEPOSIT_BEAN.getDEP_CUST_EXCH_RATE());
					}
				}

			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	
}
