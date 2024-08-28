package com.iii.pel.forms.PILQ002;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP134.CUST_DTL_UPD_BEAN;
import com.iii.pel.forms.PILP134.PILP134_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT003_APAC.PILT003_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PT_IL_POLICY_ACTION extends CommonAction {

	private String filterByCLAIM_NO;
	private String filterByCLAIM_TYPE;
	private String filterByCLAIM_STATUS;
	private String filterByCP_FC_PAID_AMT;
	private String filterByCP_LC_PAID_AMT;
	private String filterByCBEN_BNF_TYPE;
	private String filterByUI_M_TYPE_DESC;
	private String filterByCBEN_RELATION_CODE;
	private String filterByCBEN_BNF_NAME;
	private String filterByCBEN_FC_PAID_AMT;
	private String filterByCBEN_LC_PAID_AMT;

	private UIDataTable dataTable2;

	private HtmlSelectOneMenu COMP_CLAIM_TYPE;
	private HtmlInputText COMP_CBEN_BNF_TYPE;
	private HtmlInputText COMP_CP_LC_PAID_AMT;
	private HtmlInputText COMP_UI_M_TYPE_DESC;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_POL_ASSRD_REF_ID1;

	private HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL;

	private HtmlInputText COMP_POL_ASSRD_REF_ID2;

	private HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_POL_PROD_CODE;

	private HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL;

	private HtmlInputText COMP_POL_PLAN_CODE;

	private HtmlOutputLabel COMP_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_CODE;

	private HtmlOutputLabel COMP_POL_RES_ADDRESS_1_LABEL;

	private HtmlInputText COMP_POL_RES_ADDRESS_1;

	private HtmlOutputLabel COMP_POL_RES_ADDRESS_2_LABEL;

	private HtmlInputText COMP_POL_RES_ADDRESS_2;

	private HtmlOutputLabel COMP_POL_RES_ADDRESS_3_LABEL;

	private HtmlInputText COMP_POL_RES_ADDRESS_3;

	private HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_DESC;

	private HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PLAN_DESC;

	private HtmlOutputLabel COMP_WD_NET_FC_VALUE_LABEL;

	private HtmlOutputLabel COMP_WDC_FC_VALUE_LABEL;

	private HtmlInputText COMP_WDC_FC_VALUE;

	private HtmlInputText COMP_WD_NET_FC_VALUE;

	private HtmlOutputLabel COMP_UI_M_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CUST_DESC;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlInputText COMP_LOAN_LC_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_LC_REPAID_AMT;

	private HtmlOutputLabel COMP_LOAN_LC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_LOAN_LC_INTEREST;

	private HtmlOutputLabel COMP_LOAN_LC_INTEREST_LABEL;

	private HtmlInputText COMP_LOAN_LC_OS_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_LC_OS_AMOUNT_LABEL;

	private HtmlCommandButton COMP_UI_M_ED_CUST_NAME;

	private HtmlCommandButton COMP_UI_M_ED_PLAN_DESC;

	private HtmlCommandButton COMP_UI_M_ED_PROD_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_POLICY;
	
	private HtmlAjaxCommandButton COMP_M_BUT_ENDORSEMENT;

	private UIData dataTableA;

	private UIDataTable pvDataTable;

	private String filterByWD_NUMBER;

	private String filterByWD_NET_LC_VALUE;

	private String filterByWDC_RATE;

	private String filterByWDC_RATE_PER;

	private String filterByWDC_LC_VALUE;

	private HtmlOutputLabel COMP_WD_DATE_LABEL;

	private UIDataTable dataTable;

	private UIDataTable phDataTable;

	private UIDataTable pvClaimDataTable;
	
	private UIDataTable pvBonusDataTable;

	private String filterByPOLH_N_END_CODE;

	private String filterByPOLH_N_END_NO;

	private String filterByPOLH_N_END_NO_IDX;

	private String filterByUI_M_POLH_N_END_CODE_DESC;

	private String filterByPOLH_N_END_EFF_FROM_DT;

	private String filterByPOLH_N_END_EFF_TO_DT;
	
	private int UI_M_PV_BONUS_TOTAL;
	
	private int UI_M_PV_BONUS_INTEREST_TOTAL;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private HtmlOutputLabel COMP_POLH_N_END_DESC_LABEL;

	private HtmlInputText COMP_POLH_N_END_DESC;

	private HtmlCalendar COMP_WD_DATE;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	private PV_IL_CLAIM PV_IL_CLAIM_BEAN;

	private PV_IL_LOAN PV_IL_LOAN_BEAN;
	
	private PV_IL_BONUS PV_IL_BONUS_BEAN;

	private PV_IL_WITHDRAWAL PV_IL_WITHDRAWAL_BEAN;

	private PH_IL_POLICY PH_IL_POLICY_BEAN;
	
	PILQ002_COMPOSITE_ACTION compositeAction;
	
	//[Added by Akash from MAU customization dated nov,22,2012
	
	private PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN;
	private PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN;
	private PT_IL_POLICY_1 PT_IL_POLICY_1_BEAN;
	
	private UIDataTable phStatusDataTable;
	private UIDataTable phSurrMatDataTable;
	private UIDataTable phPolCustDatatable;
	
	private HtmlOutputLabel COMP_PS_REMARKS_LABEL;
	private HtmlInputText COMP_PS_REMARKS;
	
	private HtmlTabPanel COMP_TAB_PANEL;

	private HtmlOutputLabel COMP_UI_M_STAT_DESC_LABEL;
	private HtmlInputText COMP_UI_M_STAT_DESC;
	

	private HtmlOutputLabel COMP_UI_M_PC_DESC_LABEL;
	private HtmlInputText COMP_UI_M_PC_DESC;
	
	private List<PT_IL_POL_STATUS> phStatusList = new ArrayList<PT_IL_POL_STATUS>();
	private List<PT_IL_SURR_MAT_VALUES> phSurrMatList =  new ArrayList<PT_IL_SURR_MAT_VALUES>();
	private List<PT_IL_POLICY_1> phPolCustList = new ArrayList<PT_IL_POLICY_1>();
	
	
	
	//Added by Akash from MAU customization dated nov,22,2012 ]
	
	Connection connection = null;
	Map<String, Object> session = null;
	String RD_POL_SYS_ID = null;
	String RD_END_NO_IDX = null;
	String RPA_RD_SYS_ID = null;
	String RD_COVER_CODE = null;
	String selectQuery = null;
	
	PT_IL_POLICY_HELPER helper = null;

	FacesContext ctx = FacesContext.getCurrentInstance();

	private List<PH_IL_POLICY> phList = new ArrayList<PH_IL_POLICY>();
	private List<PV_IL_CLAIM> pvClaimList = new ArrayList<PV_IL_CLAIM>();
	private List<PV_IL_LOAN> pvLoanList = new ArrayList<PV_IL_LOAN>();
	private List<PV_IL_BONUS> pvBonusList = new ArrayList<PV_IL_BONUS>();
	private List<PV_IL_WITHDRAWAL> pvWdList = new ArrayList<PV_IL_WITHDRAWAL>();
	private List<SelectItem> claimTypeList = new ArrayList<SelectItem>();
	
	// ArrayList<PT_IL_RI_PREM_ALLOC> listOfAlloc = new
	// ArrayList<PT_IL_RI_PREM_ALLOC>();
	ArrayList suggesionList = new ArrayList();
	int rowCount = 1;
	private String CLAIM_TYPE;

	public HtmlSelectOneMenu getCOMP_CLAIM_TYPE() {
		return COMP_CLAIM_TYPE;
	}

	public void setCOMP_CLAIM_TYPE(HtmlSelectOneMenu comp_claim_type) {
		COMP_CLAIM_TYPE = comp_claim_type;
	}

	public HtmlInputText getCOMP_CBEN_BNF_TYPE() {
		return COMP_CBEN_BNF_TYPE;
	}

	public void setCOMP_CBEN_BNF_TYPE(HtmlInputText comp_cben_bnf_type) {
		COMP_CBEN_BNF_TYPE = comp_cben_bnf_type;
	}

	public HtmlInputText getCOMP_CP_LC_PAID_AMT() {
		return COMP_CP_LC_PAID_AMT;
	}

	public void setCOMP_CP_LC_PAID_AMT(HtmlInputText comp_cp_lc_paid_amt) {
		COMP_CP_LC_PAID_AMT = comp_cp_lc_paid_amt;
	}

	public HtmlInputText getCOMP_UI_M_TYPE_DESC() {
		return COMP_UI_M_TYPE_DESC;
	}

	public void setCOMP_UI_M_TYPE_DESC(HtmlInputText comp_ui_m_type_desc) {
		COMP_UI_M_TYPE_DESC = comp_ui_m_type_desc;
	}

	public String getFilterByCLAIM_NO() {
		return filterByCLAIM_NO;
	}

	public void setFilterByCLAIM_NO(String filterByCLAIM_NO) {
		this.filterByCLAIM_NO = filterByCLAIM_NO;
	}

	public String getFilterByCLAIM_TYPE() {
		return filterByCLAIM_TYPE;
	}

	public void setFilterByCLAIM_TYPE(String filterByCLAIM_TYPE) {
		this.filterByCLAIM_TYPE = filterByCLAIM_TYPE;
	}

	public String getFilterByCLAIM_STATUS() {
		return filterByCLAIM_STATUS;
	}

	public void setFilterByCLAIM_STATUS(String filterByCLAIM_STATUS) {
		this.filterByCLAIM_STATUS = filterByCLAIM_STATUS;
	}

	public String getFilterByCP_FC_PAID_AMT() {
		return filterByCP_FC_PAID_AMT;
	}

	public void setFilterByCP_FC_PAID_AMT(String filterByCP_FC_PAID_AMT) {
		this.filterByCP_FC_PAID_AMT = filterByCP_FC_PAID_AMT;
	}

	public String getFilterByCP_LC_PAID_AMT() {
		return filterByCP_LC_PAID_AMT;
	}

	public void setFilterByCP_LC_PAID_AMT(String filterByCP_LC_PAID_AMT) {
		this.filterByCP_LC_PAID_AMT = filterByCP_LC_PAID_AMT;
	}

	public String getFilterByCBEN_BNF_TYPE() {
		return filterByCBEN_BNF_TYPE;
	}

	public void setFilterByCBEN_BNF_TYPE(String filterByCBEN_BNF_TYPE) {
		this.filterByCBEN_BNF_TYPE = filterByCBEN_BNF_TYPE;
	}

	public String getFilterByUI_M_TYPE_DESC() {
		return filterByUI_M_TYPE_DESC;
	}

	public void setFilterByUI_M_TYPE_DESC(String filterByUI_M_TYPE_DESC) {
		this.filterByUI_M_TYPE_DESC = filterByUI_M_TYPE_DESC;
	}

	public String getFilterByCBEN_RELATION_CODE() {
		return filterByCBEN_RELATION_CODE;
	}

	public void setFilterByCBEN_RELATION_CODE(String filterByCBEN_RELATION_CODE) {
		this.filterByCBEN_RELATION_CODE = filterByCBEN_RELATION_CODE;
	}

	public String getFilterByCBEN_BNF_NAME() {
		return filterByCBEN_BNF_NAME;
	}

	public void setFilterByCBEN_BNF_NAME(String filterByCBEN_BNF_NAME) {
		this.filterByCBEN_BNF_NAME = filterByCBEN_BNF_NAME;
	}

	public String getFilterByCBEN_FC_PAID_AMT() {
		return filterByCBEN_FC_PAID_AMT;
	}

	public void setFilterByCBEN_FC_PAID_AMT(String filterByCBEN_FC_PAID_AMT) {
		this.filterByCBEN_FC_PAID_AMT = filterByCBEN_FC_PAID_AMT;
	}

	public String getFilterByCBEN_LC_PAID_AMT() {
		return filterByCBEN_LC_PAID_AMT;
	}

	public void setFilterByCBEN_LC_PAID_AMT(String filterByCBEN_LC_PAID_AMT) {
		this.filterByCBEN_LC_PAID_AMT = filterByCBEN_LC_PAID_AMT;
	}

	public String getCLAIM_TYPE() {
		return CLAIM_TYPE;
	}

	public void setCLAIM_TYPE(String claim_type) {
		CLAIM_TYPE = claim_type;
	}

	// cons

	public PT_IL_POLICY_ACTION() {
		helper = new PT_IL_POLICY_HELPER();
		PV_IL_WITHDRAWAL_BEAN = new PV_IL_WITHDRAWAL();
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		PV_IL_CLAIM_BEAN = new PV_IL_CLAIM();
		PV_IL_LOAN_BEAN = new PV_IL_LOAN();
		PV_IL_BONUS_BEAN = new PV_IL_BONUS();
		PT_IL_POL_STATUS_BEAN = new PT_IL_POL_STATUS();
		PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
		PT_IL_POLICY_1_BEAN = new PT_IL_POLICY_1();
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID1_LABEL() {
		return COMP_POL_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSRD_REF_ID1() {
		return COMP_POL_ASSRD_REF_ID1;
	}

	public void setCOMP_POL_ASSRD_REF_ID1_LABEL(
			HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL) {
		this.COMP_POL_ASSRD_REF_ID1_LABEL = COMP_POL_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_POL_ASSRD_REF_ID1(HtmlInputText COMP_POL_ASSRD_REF_ID1) {
		this.COMP_POL_ASSRD_REF_ID1 = COMP_POL_ASSRD_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID2_LABEL() {
		return COMP_POL_ASSRD_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSRD_REF_ID2() {
		return COMP_POL_ASSRD_REF_ID2;
	}

	public void setCOMP_POL_ASSRD_REF_ID2_LABEL(
			HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL) {
		this.COMP_POL_ASSRD_REF_ID2_LABEL = COMP_POL_ASSRD_REF_ID2_LABEL;
	}

	public void setCOMP_POL_ASSRD_REF_ID2(HtmlInputText COMP_POL_ASSRD_REF_ID2) {
		this.COMP_POL_ASSRD_REF_ID2 = COMP_POL_ASSRD_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_POL_ISSUE_DT_LABEL() {
		return COMP_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_ISSUE_DT() {
		return COMP_POL_ISSUE_DT;
	}

	public void setCOMP_POL_ISSUE_DT_LABEL(
			HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL) {
		this.COMP_POL_ISSUE_DT_LABEL = COMP_POL_ISSUE_DT_LABEL;
	}

	public void setCOMP_POL_ISSUE_DT(HtmlCalendar COMP_POL_ISSUE_DT) {
		this.COMP_POL_ISSUE_DT = COMP_POL_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(
			HtmlOutputLabel COMP_POL_START_DT_LABEL) {
		this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
	}

	public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
		this.COMP_POL_START_DT = COMP_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
		return COMP_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROD_CODE() {
		return COMP_POL_PROD_CODE;
	}

	public void setCOMP_POL_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
		this.COMP_POL_PROD_CODE_LABEL = COMP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_POL_PROD_CODE(HtmlInputText COMP_POL_PROD_CODE) {
		this.COMP_POL_PROD_CODE = COMP_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_PLAN_CODE_LABEL() {
		return COMP_POL_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PLAN_CODE() {
		return COMP_POL_PLAN_CODE;
	}

	public void setCOMP_POL_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL) {
		this.COMP_POL_PLAN_CODE_LABEL = COMP_POL_PLAN_CODE_LABEL;
	}

	public void setCOMP_POL_PLAN_CODE(HtmlInputText COMP_POL_PLAN_CODE) {
		this.COMP_POL_PLAN_CODE = COMP_POL_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CODE_LABEL() {
		return COMP_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CODE() {
		return COMP_POL_CUST_CODE;
	}

	public void setCOMP_POL_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
		this.COMP_POL_CUST_CODE_LABEL = COMP_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_POL_CUST_CODE(HtmlInputText COMP_POL_CUST_CODE) {
		this.COMP_POL_CUST_CODE = COMP_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_RES_ADDRESS_1_LABEL() {
		return COMP_POL_RES_ADDRESS_1_LABEL;
	}

	public HtmlInputText getCOMP_POL_RES_ADDRESS_1() {
		return COMP_POL_RES_ADDRESS_1;
	}

	public void setCOMP_POL_RES_ADDRESS_1_LABEL(
			HtmlOutputLabel COMP_POL_RES_ADDRESS_1_LABEL) {
		this.COMP_POL_RES_ADDRESS_1_LABEL = COMP_POL_RES_ADDRESS_1_LABEL;
	}

	public void setCOMP_POL_RES_ADDRESS_1(HtmlInputText COMP_POL_RES_ADDRESS_1) {
		this.COMP_POL_RES_ADDRESS_1 = COMP_POL_RES_ADDRESS_1;
	}

	public HtmlOutputLabel getCOMP_POL_RES_ADDRESS_2_LABEL() {
		return COMP_POL_RES_ADDRESS_2_LABEL;
	}

	public HtmlInputText getCOMP_POL_RES_ADDRESS_2() {
		return COMP_POL_RES_ADDRESS_2;
	}

	public void setCOMP_POL_RES_ADDRESS_2_LABEL(
			HtmlOutputLabel COMP_POL_RES_ADDRESS_2_LABEL) {
		this.COMP_POL_RES_ADDRESS_2_LABEL = COMP_POL_RES_ADDRESS_2_LABEL;
	}

	public void setCOMP_POL_RES_ADDRESS_2(HtmlInputText COMP_POL_RES_ADDRESS_2) {
		this.COMP_POL_RES_ADDRESS_2 = COMP_POL_RES_ADDRESS_2;
	}

	public HtmlOutputLabel getCOMP_POL_RES_ADDRESS_3_LABEL() {
		return COMP_POL_RES_ADDRESS_3_LABEL;
	}

	public HtmlInputText getCOMP_POL_RES_ADDRESS_3() {
		return COMP_POL_RES_ADDRESS_3;
	}

	public void setCOMP_POL_RES_ADDRESS_3_LABEL(
			HtmlOutputLabel COMP_POL_RES_ADDRESS_3_LABEL) {
		this.COMP_POL_RES_ADDRESS_3_LABEL = COMP_POL_RES_ADDRESS_3_LABEL;
	}

	public void setCOMP_POL_RES_ADDRESS_3(HtmlInputText COMP_POL_RES_ADDRESS_3) {
		this.COMP_POL_RES_ADDRESS_3 = COMP_POL_RES_ADDRESS_3;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_DESC_LABEL() {
		return COMP_UI_M_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_DESC() {
		return COMP_UI_M_PROD_DESC;
	}

	public void setCOMP_UI_M_PROD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL) {
		this.COMP_UI_M_PROD_DESC_LABEL = COMP_UI_M_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_DESC(HtmlInputText COMP_UI_M_PROD_DESC) {
		this.COMP_UI_M_PROD_DESC = COMP_UI_M_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PLAN_DESC_LABEL() {
		return COMP_UI_M_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_DESC() {
		return COMP_UI_M_PLAN_DESC;
	}

	public void setCOMP_UI_M_PLAN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL) {
		this.COMP_UI_M_PLAN_DESC_LABEL = COMP_UI_M_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_PLAN_DESC(HtmlInputText COMP_UI_M_PLAN_DESC) {
		this.COMP_UI_M_PLAN_DESC = COMP_UI_M_PLAN_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_DESC_LABEL() {
		return COMP_UI_M_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_DESC() {
		return COMP_UI_M_CUST_DESC;
	}

	public void setCOMP_UI_M_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_DESC_LABEL) {
		this.COMP_UI_M_CUST_DESC_LABEL = COMP_UI_M_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_CUST_DESC(HtmlInputText COMP_UI_M_CUST_DESC) {
		this.COMP_UI_M_CUST_DESC = COMP_UI_M_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(
			HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_ED_CUST_NAME() {
		return COMP_UI_M_ED_CUST_NAME;
	}

	public void setCOMP_UI_M_ED_CUST_NAME(
			HtmlCommandButton COMP_UI_M_ED_CUST_NAME) {
		this.COMP_UI_M_ED_CUST_NAME = COMP_UI_M_ED_CUST_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_ED_PLAN_DESC() {
		return COMP_UI_M_ED_PLAN_DESC;
	}

	public void setCOMP_UI_M_ED_PLAN_DESC(
			HtmlCommandButton COMP_UI_M_ED_PLAN_DESC) {
		this.COMP_UI_M_ED_PLAN_DESC = COMP_UI_M_ED_PLAN_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_ED_PROD_DESC() {
		return COMP_UI_M_ED_PROD_DESC;
	}

	public void setCOMP_UI_M_ED_PROD_DESC(
			HtmlCommandButton COMP_UI_M_ED_PROD_DESC) {
		this.COMP_UI_M_ED_PROD_DESC = COMP_UI_M_ED_PROD_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POLICY() {
		return COMP_UI_M_BUT_POLICY;
	}

	public void setCOMP_UI_M_BUT_POLICY(HtmlCommandButton COMP_UI_M_BUT_POLICY) {
		this.COMP_UI_M_BUT_POLICY = COMP_UI_M_BUT_POLICY;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}


	/*ADDED BY GOPI FOR QUOTATION LETTER GENERATE ON 30/05/17*/
	
	private List<SelectItem> listQUOTATION_TYPE = new ArrayList<SelectItem>();
	

	public List<SelectItem> getListQUOTATION_TYPE() {
		return listQUOTATION_TYPE;
	}

	public void setListQUOTATION_TYPE(List<SelectItem> listQUOTATION_TYPE) {
		this.listQUOTATION_TYPE = listQUOTATION_TYPE;
	}
	
	private HtmlOutputLabel COMP_UI_M_QUOT_TYPE_LABEL;
	
	public HtmlOutputLabel getCOMP_UI_M_QUOT_TYPE_LABEL() {
		return COMP_UI_M_QUOT_TYPE_LABEL;
	}

	public void setCOMP_UI_M_QUOT_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_M_QUOT_TYPE_LABEL) {
		COMP_UI_M_QUOT_TYPE_LABEL = cOMP_UI_M_QUOT_TYPE_LABEL;
	}
	private HtmlSelectOneMenu COMP_UI_M_QUOT_TYPE;
	
	
	public HtmlSelectOneMenu getCOMP_UI_M_QUOT_TYPE() {
		return COMP_UI_M_QUOT_TYPE;
	}

	public void setCOMP_UI_M_QUOT_TYPE(HtmlSelectOneMenu cOMP_UI_M_QUOT_TYPE) {
		COMP_UI_M_QUOT_TYPE = cOMP_UI_M_QUOT_TYPE;
	}

	private HtmlCommandButton COMP_POL_PRINT;
	
	
	public HtmlCommandButton getCOMP_POL_PRINT() {
		return COMP_POL_PRINT;
	}

	public void setCOMP_POL_PRINT(HtmlCommandButton cOMP_POL_PRINT) {
		COMP_POL_PRINT = cOMP_POL_PRINT;
	}

	public void preparDropDownList() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String PRODUCT_CODE=PT_IL_POLICY_BEAN.getPOL_PROD_CODE();
			System.out.println("<************PRODUCT_CODE********>"+PRODUCT_CODE);
			
			/*listQUOTATION_TYPE = ListItemUtil.getDropDownListValue(connection,
					"PILQ002", "DUMMY",
					"DUMMY.M_QUOT_TYPE", "IL_QUOT_TYPE");*/
			listQUOTATION_TYPE=getDropDownListValue(connection, 
					"N", 
					"SUR_QUOT_LIST","M",PRODUCT_CODE);
		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}

	}
	/*ADDED BY GOPI FOR QUOTATION LETTER GENERATE ON 30/05/17*/
	public static List<SelectItem> getDropDownListValue(Connection connection,String pol_status, String report_type, String typevalue,String Product_code){
	
	System.out.println("enters inside getDropDownListValue in commonREport action");
	
	
	List<SelectItem> listValues = null;
	String query = null;
	System.out.println("pol_status          :"+pol_status        +
			"report_type        :"+report_type        +"typevalue          :"+typevalue);
	
	
	
	query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
			  "FROM pm_rep_tab_dtl " +
			 " WHERE SYS_PARAM = ? " +
			   " AND ITEM_NAME = ? " +
			   " AND PMLIT_FLAG = ? "+
			   " AND PMILT_ADDL_STS like ?" ;
			
		
		CRUDHandler handler = null;
		Object[] values = {pol_status , report_type ,typevalue,"%"+ Product_code+"%"};
		try {
			handler = new CRUDHandler();
			System.out.println("query            :"+query);
			System.out.println("connection            :"+connection);
			System.out.println("values            :"+values);
			
			/*Added by Ram on 08/09/2016*/
			int resultCount = 0;
			/*End*/
			
			ResultSet rst = handler.executeSelectStatement(query, connection, values);
			listValues = new ArrayList<SelectItem>();
			while(rst.next()){
				
				System.out.println("INSIDE WHILE LOOP");
				
				listValues.add(new SelectItem(rst.getString("PMLIT_KEY"),rst.getString("PMLIT_VALUE")));
				resultCount++;
			}
			rst.close();
			rst.getStatement().close();
			/*Added by Ram on 08/09/2016*/
			if(resultCount == 0)
			{
				listValues.add(new SelectItem("0","--Select--"));
			}
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return listValues;
}

	public void validateQUOT_TYPE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			PT_IL_POLICY_BEAN.setUI_M_QUOT_TYPE(value.toString());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateProduct_code(FacesContext fc, UIComponent component,
			Object value) {
		try {
			PT_IL_POLICY_BEAN.setPOL_PROD_CODE(value.toString());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public String callPrint(){
		String outcome="";
		outcome = "PILQ002_PT_IL_POLICY_PRINT";
		
		return outcome;
	}
	/*END*/
	
	
	
	
	
	
	
	
	
	public String preForm() {
		System.out.println("PT_IL_RI_DETL_ACTION.preForm()");
		ArrayList<OracleParameter> list = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		Connection connection = null;
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");

		// values should take from
		// GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
		// Developing purpose hard coded it.
		session.put("GLOBAL.M_MODULE_NAME", "PILT010");
		System.out.println("PT_IL_RI_DETL_ACTION.preForm()\n"
				+ fc.getExternalContext().getSessionMap());

		// calling STD_PRE_FORM PLL
		compositeAction.getDUMMY_BEAN().setPT_IL_POLICY_CF("N") ;
		compositeAction.getDUMMY_BEAN().setPH_IL_POLICY_CF("N") ;
		STD_PRE_FORM();

		ControlBean ctrlbean = CommonUtils.getControlBean();
		String M_TITLE = ctrlbean.getM_USER_ID() + " "
				+ ctrlbean.getM_SCR_NAME() + " " + new Date();

		return null;
	}

	public void STD_PRE_FORM() {
		// P_GET_LOGO;
		// COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String) session.get("GLOBAL.M_PARA_1"));
		// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		// ctrlBean.setM_PROG_NAME("PILT010");
		// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		// 'BUTTON_PALETTE.M_COMP_NAME') ;

		// COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		WHEN_NEW_FORM_INSTANCE();

		/**
		 * GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN
		 * RECORD GROUP *
		 */
		/*
		 * M_MODULE_NAME :=
		 * GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
		 * COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ; M_TITLE:=
		 * NAME_IN('CTRL.M_USER_ID') ||' '||NAME_IN('CTRL.M_SCR_NAME')||'
		 * '||TO_CHAR(SYSDATE,'DD/MM/YY');
		 * SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
		 * HIDE_VIEW('ABOUT'); M_FIRST_BLOCK :=
		 * GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY( CURRENT_FORM_NAME),
		 * FIRSTBLOCK) ;
		 * 
		 * LOOP IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE'
		 * THEN IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
		 * SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
		 * ELSE SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED,
		 * PROPERTY_FALSE) ; END IF ; END IF; IF
		 * GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN IF
		 * SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
		 * SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
		 * ELSE SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED,
		 * PROPERTY_FALSE) ; END IF ; END IF; IF
		 * GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN IF
		 * SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
		 * SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
		 * ELSE SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED,
		 * PROPERTY_FALSE) ; END IF ; END IF; M_FIRST_BLOCK :=
		 * GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ; IF M_FIRST_BLOCK IN
		 * ('DUAL','CTRL','BUTTON_PALETTE') THEN EXIT ; END IF ; END LOOP ;
		 * 
		 * RG_ID := FIND_GROUP('RG_HINT') ; IF ID_NULL(RG_ID) THEN NULL ; ELSE
		 * M_QUERY_OK := POPULATE_GROUP(RG_ID) ; END IF ; RG_ID :=
		 * FIND_GROUP('RG_ALERT_MSG') ; IF ID_NULL(RG_ID) THEN NULL ; ELSE
		 * M_QUERY_OK := POPULATE_GROUP(RG_ID) ; END IF ; LOAD_BP;
		 * ENABLE_BUTTONS ; IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
		 * LOAD_BALOON_LABEL; END IF; END;
		 */
	}

	public Connection getConnection() throws Exception {
		return CommonUtils.getConnection();
	}

	public List suggesion(Object obj) throws Exception {
		getCOMP_POL_NO().setSubmittedValue(null);
		String query = null;
		suggesionList.clear();
		System.out.println("PT_IL_POLICY_ACTION.suggesion() " + obj.toString()
				+ "\t " + obj.toString().equals("*"));
		if (obj.toString().equals("*")) {
			query = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_DS_TYPE='2' AND  rownum < 25";
		} else {
			query = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_NO LIKE '"
					+ obj.toString()
					+ "%' and POL_DS_TYPE ='2' and rownum < 25";
		}
		System.out.println("PT_IL_POLICY_ACTION.suggesion()");
		connection = getConnection();
		System.out.println("PT_IL_POLICY_ACTION.suggesion() Query " + query);
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(query, connection);
		rs.setFetchSize(25);
		while (rs.next()) {
			PolicyNoSuggessionBean bean = new PolicyNoSuggessionBean();
			bean.setPolicyNo(rs.getString("POL_NO"));
			suggesionList.add(bean);
		}
		rs.close();
		return suggesionList;
	}

	public void loadingBaseValues(PhaseEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		if (session.get("PT_IL_POLICY_ACTION_FORM") == null) {
			preForm();
			session.put("PT_IL_POLICY_ACTION_FORM", "true");
		}
	}

	public List<PH_IL_POLICY> getPhList() {
		return phList;
	}

	public void setPhList(List<PH_IL_POLICY> phList) {
		this.phList = phList;
	}

	public List<PV_IL_CLAIM> getPvClaimList() {
		return pvClaimList;
	}

	public void setPvClaimList(List<PV_IL_CLAIM> pvClaimList) {
		this.pvClaimList = pvClaimList;

	}

	public List<PV_IL_LOAN> getPvLoanList() {
		return pvLoanList;
	}

	public void setPvLoanList(List<PV_IL_LOAN> pvLoanList) {
		this.pvLoanList = pvLoanList;
	}

	public List<PV_IL_WITHDRAWAL> getPvWdList() {
		return pvWdList;
	}

	public void setPvWdList(List<PV_IL_WITHDRAWAL> pvWdList) {
		this.pvWdList = pvWdList;
	}

	public List<SelectItem> getClaimTypeList() {
		if (claimTypeList.size() == 0) {
			claimTypeList.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				claimTypeList = ListItemUtil.getDropDownListValue(con,
						"PILQ002", "PV_IL_CLAIM", "PV_IL_CLAIM.CLAIM_TYPE",
						"CLMTYPE");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return claimTypeList;
	}

	public void setClaimTypeList(List<SelectItem> claimTypeList) {
		this.claimTypeList = claimTypeList;
	}

	public String save() {

		System.out.println("CLAIM TYPE VALUE*********" + getCLAIM_TYPE());
		return null;
	}

	// Muthu Added
	private ResultSet resultSet;
	private CRUDHandler handler = new CRUDHandler();
	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	List resultList = new ArrayList();
	OracleProcedureHandler ora_handler = new OracleProcedureHandler();
	String WHERE_CLAUSE = "";
	String M_FLAG = "";

	public void getHistoryDetails(ActionEvent ae) throws Exception {
		
		String polSysID = "";
		PT_IL_POLICY_PRE_QUERY();
		ResultSet rs = null;
		UIInput input = (UIInput) ae.getComponent() // Ajax4jsf comp
				.getParent();
		
		try{
		if ("".equals(getCOMP_POL_NO().getSubmittedValue().toString())) {
			// selectQuery = "SELECT * FROM " +
			// "(SELECT PV_IL_POL_RI_DETL.*, ROWNUM r FROM
			// PV_IL_POL_RI_DETL)WHERE r <="+rowCount+" and r >="+rowCount;
			ErrorHelpUtil.validate(input, getErrorMap());
			return;
		} else {
			getErrorMap().clear();
			selectQuery = "SELECT * FROM PT_IL_POLICY WHERE POL_NO='"
					+ (String) getCOMP_POL_NO().getSubmittedValue() + "' AND "
					+ WHERE_CLAUSE;
		}
		System.out.println(selectQuery);
		CRUDHandler handler = new CRUDHandler();
		connection = getConnection();
		rs = handler.executeSelectStatement(selectQuery, connection);
		if (rs.next()) {
			getErrorMap().clear();
			getCOMP_POL_ASSRD_REF_ID1().setSubmittedValue(
					rs.getString("POL_ASSRD_REF_ID1"));
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(rs
					.getString("POL_ASSRD_REF_ID1"));
			getCOMP_POL_ASSRD_REF_ID2().setSubmittedValue(
					rs.getString("POL_ASSRD_REF_ID2"));
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(rs
					.getString("POL_ASSRD_REF_ID2"));
			getCOMP_POL_CUST_CODE().setSubmittedValue(
					rs.getString("POL_CUST_CODE"));
			PT_IL_POLICY_BEAN.setPOL_CUST_CODE(rs.getString("POL_CUST_CODE"));
			getCOMP_POL_EXPIRY_DT().setSubmittedValue(
					rs.getDate("POL_EXPIRY_DT"));
			PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(rs.getDate("POL_EXPIRY_DT"));
			getCOMP_POL_ISSUE_DT()
					.setSubmittedValue(rs.getDate("POL_ISSUE_DT"));
			PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(rs.getDate("POL_ISSUE_DT"));
			getCOMP_POL_PLAN_CODE().setSubmittedValue(
					rs.getString("POL_PLAN_CODE"));
			PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(rs.getString("POL_PLAN_CODE"));
			getCOMP_POL_PROD_CODE().setSubmittedValue(
					rs.getString("POL_PROD_CODE"));
			PT_IL_POLICY_BEAN.setPOL_PROD_CODE(rs.getString("POL_PROD_CODE"));
			getCOMP_POL_RES_ADDRESS_1().setSubmittedValue(
					rs.getString("POL_RES_ADDRESS_1"));
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1(rs
					.getString("POL_RES_ADDRESS_1"));
			getCOMP_POL_RES_ADDRESS_2().setSubmittedValue(
					rs.getString("POL_RES_ADDRESS_2"));
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2(rs
					.getString("POL_RES_ADDRESS_2"));
			getCOMP_POL_RES_ADDRESS_3().setSubmittedValue(
					rs.getString("POL_RES_ADDRESS_3"));
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3(rs
					.getString("POL_RES_ADDRESS_3"));
			getCOMP_POL_START_DT()
					.setSubmittedValue(rs.getDate("POL_START_DT"));
			PT_IL_POLICY_BEAN.setPOL_START_DT(rs.getDate("POL_START_DT"));
			polSysID = rs.getString("POL_SYS_ID");
			PT_IL_POLICY_BEAN.setPOL_SYS_ID(rs.getLong("POL_SYS_ID"));
			System.out.println("Start DAte"
					+ getCOMP_POL_START_DT().getSubmittedValue());
		} else {
			getErrorMap().put("current",
					"Query caused no records to be retrived. Re-enter");
			return;
		}

		String query = "select CUST_NAME from PM_CUSTOMER WHERE  CUST_CODE ='"
				+ getCOMP_POL_CUST_CODE().getSubmittedValue() + "'";
		rs = handler.executeSelectStatement(query, connection);
		while (rs.next()) {

			System.out.println("CUST_NAME" + rs.getString("CUST_NAME"));
			getCOMP_UI_M_CUST_DESC().setSubmittedValue(
					rs.getString("CUST_NAME"));

		}
		query = "SELECT PROD_DESC FROM   PM_IL_PRODUCT  WHERE  PROD_CODE ='"
				+ getCOMP_POL_PROD_CODE().getSubmittedValue() + "'";
		rs = handler.executeSelectStatement(query, connection);
		while (rs.next()) {
			System.out.println("PROD_DESC" + rs.getString("PROD_DESC"));
			getCOMP_UI_M_PROD_DESC().setSubmittedValue(
					rs.getString("PROD_DESC"));

		}

		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String) getCOMP_POL_PLAN_CODE().getSubmittedValue());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT",
				"");
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN", "N");
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN", "N");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		System.out.println("calProcedure()");
		System.out.println("polSysID" + polSysID);
		List outParamList = procHandler.execute(paramList, connection,
				"P_VAL_PLAN");
		System.out.println("List Size" + outParamList.size());
		OracleParameter planDescPar = (OracleParameter) outParamList.get(0);
		getCOMP_UI_M_PLAN_DESC().setSubmittedValue((planDescPar.getValue()));

		query = "select * from PH_IL_POLICY where PH_IL_POLICY.POLH_SYS_ID ="
				+ polSysID;
		System.out.println("PH_IL_POLICY  [ " + query + " ]");
		rs = handler.executeSelectStatement(query, connection);

		phList.clear();
		this.setPH_IL_POLICY_BEAN(new PH_IL_POLICY());
		phList = handler.fetch(query, "com.iii.pel.forms.PILQ002.PH_IL_POLICY",
				connection);

		/*
		 * if (phList.size() != 5 ){ for (int i=phList.size(); i<5;i++){
		 * PH_IL_POLICY phILPolicy = new PH_IL_POLICY(); phList.add(phILPolicy); } }
		 */
		PH_IL_POLICY_WHEN_NEW_RECORD_INSTANCE();
		PH_IL_POLICY_POST_QUERY();
		query = "select * from PV_IL_CLAIM where PV_IL_CLAIM.CLAIM_POL_SYS_ID ="
				+ polSysID;
		System.out.println("PH_IL_POLICY  [ " + query + " ]");
		// Added for aligning the grid value properly
		
		for (int i = 0; i < phList.size(); i++) {
			PH_IL_POLICY ph_il_policy = phList.get(i);
			if (i == 0) {
				ph_il_policy.setRowSelected(true);
				setPH_IL_POLICY_BEAN(ph_il_policy);
			} else {
				ph_il_policy.setRowSelected(false);
			}
		}

		/*
		 * Iterator<PH_IL_POLICY> it = phList.iterator(); PH_IL_POLICY
		 * PH_IL_POLICY_BEAN = null; while(it.hasNext()){ PH_IL_POLICY_BEAN =
		 * it.next(); PH_IL_POLICY_BEAN.setRowSelected(false); }
		 */
		// rs = handler.executeSelectStatement(query, connection);
		pvClaimList.clear();
		this.setPV_IL_CLAIM_BEAN(new PV_IL_CLAIM());
		
		
		
		pvClaimList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_CLAIM", connection);

		for (int i = 0; i < pvClaimList.size(); i++) {
			PV_IL_CLAIM pv_il_claim = pvClaimList.get(i);
			if (i == 0) {
				pv_il_claim.setRowSelected(true);
				setPV_IL_CLAIM_BEAN(pv_il_claim);
			} else {
				pv_il_claim.setRowSelected(false);
			}
		}
		
	
	//[ Added by Akash to add status Block in history  Screen
		
		phStatusList.clear();
		query="select * from pt_il_pol_status where ps_pol_sys_id = "+polSysID;
		for(int i=0; i< phStatusList.size() ; i++){
			PT_IL_POL_STATUS pt_il_pol_status_bean = new PT_IL_POL_STATUS();
			if(i==0){
				pt_il_pol_status_bean.setRowSelected(true);
				setPT_IL_POL_STATUS_BEAN(pt_il_pol_status_bean);
			}else{
				pt_il_pol_status_bean.setRowSelected(false);
			}
		}

		// Added by Akash to add status Block in history  Screen]
		
		
		
		query = "select * from PV_IL_LOAN where PV_IL_LOAN.LOAN_POL_SYS_ID ="
				+ polSysID;
		// rs = handler.executeSelectStatement(query, connection);
		pvLoanList.clear();
		this.setPV_IL_LOAN_BEAN(new PV_IL_LOAN());
		pvLoanList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_LOAN", connection);

		/*if (pvLoanList.size() != 5) {
			for (int i = pvLoanList.size(); i < 5; i++) {
				PV_IL_LOAN pvILLoan = new PV_IL_LOAN();
				pvLoanList.add(pvILLoan);
			}
		}*/
		
		for (int i = 0; i < pvLoanList.size(); i++) {
			PV_IL_LOAN PV_IL_LOAN_BEAN = pvLoanList.get(i);
			if (i == 0) {
				PV_IL_LOAN_BEAN.setRowSelected(true);
				setPV_IL_LOAN_BEAN(PV_IL_LOAN_BEAN);
			} else {
				PV_IL_LOAN_BEAN.setRowSelected(false);
			}
		}

		
		query = "select * from PV_IL_WITHDRAWAL where PV_IL_WITHDRAWAL.WD_POL_SYS_ID ="
				+ polSysID;
		// rs = handler.executeSelectStatement(query, connection);
		pvWdList.clear();
		this.setPV_IL_WITHDRAWAL_BEAN(new PV_IL_WITHDRAWAL());
		pvWdList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_WITHDRAWAL", connection);


		for (int i = 0; i < pvWdList.size(); i++) {
			PV_IL_WITHDRAWAL PV_IL_WITHDRAWAL_BEAN = pvWdList.get(i);
			if (i == 0) {
				PV_IL_WITHDRAWAL_BEAN.setRowSelected(true);
				setPV_IL_WITHDRAWAL_BEAN(PV_IL_WITHDRAWAL_BEAN);
			} else {
				PV_IL_WITHDRAWAL_BEAN.setRowSelected(false);
			}
		}
		/*
		 * if (pvWdList.size() != 5 ){ for (int i=pvWdList.size(); i<5;i++){
		 * PV_IL_WITHDRAWAL pvILWithdrawal = new PV_IL_WITHDRAWAL();
		 * pvWdList.add(pvILWithdrawal); } }
		 */

		resetAllComponent();
		resetAllComponent2();
		resetAllComponent3();
		resetAllComponentA();
		
	}catch(Exception e){
		e.printStackTrace();
		getWarningMap().put("POL_NO", e.getMessage());
		getErrorMap().put("current", e.getMessage());
	}

	}
	
	
	
	
	
	public void getAllHistoryDetails(PT_IL_POLICY PT_IL_POLICY_BEAN) throws Exception {
		
		String polSysID = "";
		PT_IL_POLICY_PRE_QUERY();
		ResultSet rs = null;
		String polCustCode= null;
//		UIInput input = (UIInput) ae.getComponent() // Ajax4jsf comp
//				.getParent();
		
		try{
			selectQuery = "SELECT * FROM PT_IL_POLICY WHERE POL_NO='"
					+ PT_IL_POLICY_BEAN.getPOL_NO() + "' AND "
					+ WHERE_CLAUSE;
		
		System.out.println(selectQuery);
		CRUDHandler handler = new CRUDHandler();
		connection = getConnection();
		rs = handler.executeSelectStatement(selectQuery, connection);
		if (rs.next()) {
			getErrorMap().clear();
			getCOMP_POL_ASSRD_REF_ID1().setSubmittedValue(
					rs.getString("POL_ASSRD_REF_ID1"));
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(rs
					.getString("POL_ASSRD_REF_ID1"));
			getCOMP_POL_ASSRD_REF_ID2().setSubmittedValue(
					rs.getString("POL_ASSRD_REF_ID2"));
			PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(rs
					.getString("POL_ASSRD_REF_ID2"));
			getCOMP_POL_CUST_CODE().setSubmittedValue(
					rs.getString("POL_CUST_CODE"));
			polCustCode = rs.getString("POL_CUST_CODE");
			PT_IL_POLICY_BEAN.setPOL_CUST_CODE(rs.getString("POL_CUST_CODE"));
			getCOMP_POL_EXPIRY_DT().setSubmittedValue(
					rs.getDate("POL_EXPIRY_DT"));
			PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(rs.getDate("POL_EXPIRY_DT"));
			getCOMP_POL_ISSUE_DT()
					.setSubmittedValue(rs.getDate("POL_ISSUE_DT"));
			PT_IL_POLICY_BEAN.setPOL_ISSUE_DT(rs.getDate("POL_ISSUE_DT"));
			getCOMP_POL_PLAN_CODE().setSubmittedValue(
					rs.getString("POL_PLAN_CODE"));
			PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(rs.getString("POL_PLAN_CODE"));
			getCOMP_POL_PROD_CODE().setSubmittedValue(
					rs.getString("POL_PROD_CODE"));
			PT_IL_POLICY_BEAN.setPOL_PROD_CODE(rs.getString("POL_PROD_CODE"));
			getCOMP_POL_RES_ADDRESS_1().setSubmittedValue(
					rs.getString("POL_RES_ADDRESS_1"));
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_1(rs
					.getString("POL_RES_ADDRESS_1"));
			getCOMP_POL_RES_ADDRESS_2().setSubmittedValue(
					rs.getString("POL_RES_ADDRESS_2"));
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_2(rs
					.getString("POL_RES_ADDRESS_2"));
			getCOMP_POL_RES_ADDRESS_3().setSubmittedValue(
					rs.getString("POL_RES_ADDRESS_3"));
			PT_IL_POLICY_BEAN.setPOL_RES_ADDRESS_3(rs
					.getString("POL_RES_ADDRESS_3"));
			getCOMP_POL_START_DT()
					.setSubmittedValue(rs.getDate("POL_START_DT"));
			PT_IL_POLICY_BEAN.setPOL_START_DT(rs.getDate("POL_START_DT"));
			polSysID = rs.getString("POL_SYS_ID");
			PT_IL_POLICY_BEAN.setPOL_SYS_ID(rs.getLong("POL_SYS_ID"));
			System.out.println("Start DAte"
					+ getCOMP_POL_START_DT().getSubmittedValue());
		} else {
			getErrorMap().put("current",
					"Query caused no records to be retrived. Re-enter");
			return;
		}

		String query = "select CUST_NAME from PM_CUSTOMER WHERE  CUST_CODE ='"
				+ getCOMP_POL_CUST_CODE().getSubmittedValue() + "'";
		rs = handler.executeSelectStatement(query, connection);
		while (rs.next()) {

			System.out.println("CUST_NAME" + rs.getString("CUST_NAME"));
			getCOMP_UI_M_CUST_DESC().setSubmittedValue(
					rs.getString("CUST_NAME"));

		}
		query = "SELECT PROD_DESC FROM   PM_IL_PRODUCT  WHERE  PROD_CODE ='"
				+ getCOMP_POL_PROD_CODE().getSubmittedValue() + "'";
		rs = handler.executeSelectStatement(query, connection);
		while (rs.next()) {
			System.out.println("PROD_DESC" + rs.getString("PROD_DESC"));
			getCOMP_UI_M_PROD_DESC().setSubmittedValue(
					rs.getString("PROD_DESC"));

		}

		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String) getCOMP_POL_PLAN_CODE().getSubmittedValue());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT",
				"");
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN", "N");
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN", "N");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		System.out.println("calProcedure()");
		System.out.println("polSysID" + polSysID);
		List outParamList = procHandler.execute(paramList, connection,
				"P_VAL_PLAN");
		System.out.println("List Size" + outParamList.size());
		OracleParameter planDescPar = (OracleParameter) outParamList.get(0);
		getCOMP_UI_M_PLAN_DESC().setSubmittedValue((planDescPar.getValue()));

		query = "select * from PH_IL_POLICY where PH_IL_POLICY.POLH_SYS_ID ="
				+ polSysID;
		System.out.println("PH_IL_POLICY  [ " + query + " ]");
		rs = handler.executeSelectStatement(query, connection);

		phList.clear();
		this.setPH_IL_POLICY_BEAN(new PH_IL_POLICY());
		phList = handler.fetch(query, "com.iii.pel.forms.PILQ002.PH_IL_POLICY",
				connection);

		/*
		 * if (phList.size() != 5 ){ for (int i=phList.size(); i<5;i++){
		 * PH_IL_POLICY phILPolicy = new PH_IL_POLICY(); phList.add(phILPolicy); } }
		 */
		PH_IL_POLICY_WHEN_NEW_RECORD_INSTANCE();
		PH_IL_POLICY_POST_QUERY();
		/*query = "select * from PV_IL_CLAIM where PV_IL_CLAIM.CLAIM_POL_SYS_ID ="
				+ polSysID;*/
		System.out.println("PH_IL_POLICY  [ " + query + " ]");
		// Added for aligning the grid value properly
		
		for (int i = 0; i < phList.size(); i++) {
			PH_IL_POLICY ph_il_policy = phList.get(i);
			if (i == 0) {
				ph_il_policy.setRowSelected(true);
				setPH_IL_POLICY_BEAN(ph_il_policy);
			} else {
				ph_il_policy.setRowSelected(false);
			}
		}

		
		//[ Added by Akash to add status Block in history  Screen
		
		phStatusList.clear();
		
		/*
		 * 
		 * 
		 * 
		 * Commented by Janani on 4.03.2017 for ZB status desc
		
		//query="select * from pt_il_pol_status where ps_pol_sys_id = "+polSysID;
		
	phStatusList = handler.fetch(query, "com.iii.pel.forms.PILQ002.PT_IL_POL_STATUS",
				connection);

		this.setPT_IL_POL_STATUS_BEAN(new PT_IL_POL_STATUS());
		
		status_desc();	
		System.out.println("STATUS_DESC          :"+PT_IL_POL_STATUS_BEAN);
		System.out.println("STATUS_DESC          :"+PT_IL_POL_STATUS_BEAN.getUI_M_STAT_DESC());
		
		for(int i=0; i< phStatusList.size() ; i++){
			PT_IL_POL_STATUS pt_il_pol_status_bean = phStatusList.get(i);
			if(i==0){
				pt_il_pol_status_bean.setRowSelected(true);
				setPT_IL_POL_STATUS_BEAN(pt_il_pol_status_bean);
			}else{
				pt_il_pol_status_bean.setRowSelected(false);
			}
		}*/

		
		
		
		//String selectStatement = "SELECT ROWID,PS_STATUS_DT,PS_STATUS,PS_REASON_CODE,PS_STATUS_UID,PS_REMARKS FROM pt_il_pol_status WHERE ps_pol_sys_id=?";
	
		
		/*Added by Janani on 4.03.2017 for ZB status desc*/
		
		String selectStatement = "SELECT PT_IL_POL_STATUS.ROWID,PS_STATUS_DT,PS_REASON_CODE,PS_STATUS_UID,PS_REMARKS,PS_STATUS,PS_CODE_DESC UI_M_STAT_DESC FROM PT_IL_POL_STATUS,PP_SYSTEM WHERE PS_POL_SYS_ID =  ? AND PS_STATUS = PS_CODE   AND PS_TYPE='IL_ADDL_STAT'";
		
		Connection connection = null;
		ResultSet resultSet = null;
		
				
			connection = CommonUtils.getConnection();
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, 
					new Object[] {polSysID});
			while (resultSet.next()) {
				PT_IL_POL_STATUS BEAN = new PT_IL_POL_STATUS();
				
				BEAN.setPS_STATUS_DT(resultSet
						.getDate("PS_STATUS_DT"));
				BEAN.setPS_REASON_CODE(resultSet
						.getString("PS_REASON_CODE"));
				BEAN.setPS_STATUS_UID(resultSet
						.getString("PS_STATUS_UID"));
				BEAN.setPS_REMARKS(resultSet
						.getString("PS_REMARKS"));
				BEAN.setPS_STATUS(resultSet
						.getString("PS_STATUS"));
				BEAN.setUI_M_STAT_DESC(resultSet
						.getString("UI_M_STAT_DESC"));
				
				
				System.out.println("PS_STATUS                 :"+BEAN.getPS_STATUS());
				
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPhStatusList().add(BEAN);
		
			}
			
			/*end*/
			
			
		
		// Added by Akash to add status Block in history  Screen]
		
		
		//[ Added by Akash to add maturity Block in history  Screen
		
		phSurrMatList.clear();
		query="SELECT * FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID= "+polSysID;
		phSurrMatList = handler.fetch(query, "com.iii.pel.forms.PILQ002.PT_IL_SURR_MAT_VALUES",
				connection);

		this.setPT_IL_SURR_MAT_VALUES_BEAN(new PT_IL_SURR_MAT_VALUES());
		for(int i=0; i< phSurrMatList.size() ; i++){
			PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = phSurrMatList.get(i);
			if(i==0){
				pt_il_surr_mat_values_bean.setRowSelected(true);
				setPT_IL_SURR_MAT_VALUES_BEAN(pt_il_surr_mat_values_bean);
			}else{
				pt_il_surr_mat_values_bean.setRowSelected(false);
			}
		}

		// Added by Akash to add maturity Block in history  Screen]
		
		
		
		//[ Added by Akash to add Other Policies Block in history  Screen
		
		phPolCustList.clear();
		query="SELECT * FROM PT_IL_POLICY WHERE POL_CUST_CODE= '"+ polCustCode +"'";
		phPolCustList = handler.fetch(query, "com.iii.pel.forms.PILQ002.PT_IL_POLICY_1",
				connection);
		this.setPT_IL_POLICY_1_BEAN(new PT_IL_POLICY_1());
		custOtherPolicyPostQuery();
		for(int i=0; i< phPolCustList.size() ; i++){
			PT_IL_POLICY_1 pt_il_policy_1_bean = phPolCustList.get(i);
			if(i==0){
				//pt_il_policy_1_bean.setRowSelected(true);
				setPT_IL_POLICY_1_BEAN(pt_il_policy_1_bean);
			}else{
				//pt_il_policy_1_bean.setRowSelected(false);
			}
		}

		// Added by Akash to add Other Policies Block in history  Screen]
		
		
		/*
		 * Iterator<PH_IL_POLICY> it = phList.iterator(); PH_IL_POLICY
		 * PH_IL_POLICY_BEAN = null; while(it.hasNext()){ PH_IL_POLICY_BEAN =
		 * it.next(); PH_IL_POLICY_BEAN.setRowSelected(false); }
		 */
		// rs = handler.executeSelectStatement(query, connection);
	/*	pvClaimList.clear();
		query="SELECT * FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID= "+polSysID;
		this.setPV_IL_CLAIM_BEAN(new PV_IL_CLAIM());
		pvClaimList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_CLAIM", connection);

		for (int i = 0; i < pvClaimList.size(); i++) {
			PV_IL_CLAIM pv_il_claim = pvClaimList.get(i);
			if (i == 0) {
				pv_il_claim.setRowSelected(true);
				setPV_IL_CLAIM_BEAN(pv_il_claim);
			} else {
				pv_il_claim.setRowSelected(false);
			}
		}*////commented for claim visiblity in policy history 
		pvClaimList.clear();
		
		
		
		
		
		
		/*
		 * 
		 * Commented by Janani on 4.03.2017
		 * 
		 * 
		 * query="SELECT * FROM PV_IL_CLAIM WHERE CLAIM_POL_SYS_ID= "+polSysID;
		this.setPV_IL_CLAIM_BEAN(new PV_IL_CLAIM());
		
		pvClaimList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_CLAIM", connection);

		for (int i = 0; i < pvClaimList.size(); i++) {
			PV_IL_CLAIM pv_il_claim = pvClaimList.get(i);
			if (i == 0) {
				pv_il_claim.setRowSelected(true);
				setPV_IL_CLAIM_BEAN(pv_il_claim);
			} else {
				pv_il_claim.setRowSelected(false);
			}
		}*/
		//PV_IL_CLAIM_POST_QUERY();
		
		
		/*Added by Janani on 04.03.2017 for ZB status desc issue*/
		
		
 	
	

 String claim_selectStatement = "select CLAIM_NO,CLAIM_TYPE,CLAIM_STATUS,CP_FC_PAID_AMT,CP_LC_PAID_AMT,CP_PAID_DT,CBEN_BNF_TYPE,CBEN_RELATION_CODE,"
		+"CBEN_BNF_NAME,CBEN_FC_PAID_AMT,CBEN_LC_PAID_AMT, PS_CODE_DESC UI_M_STATUS_DESC from PV_IL_CLAIM,PP_SYSTEM WHERE PV_IL_CLAIM.CLAIM_POL_SYS_ID =? "
		+" AND CLAIM_STATUS = PS_CODE AND PS_TYPE = 'IL_REC_STA' ";




Connection claim_connection = null;
		ResultSet claim_resultSet = null;
		
				
		claim_connection = CommonUtils.getConnection();
			
		claim_resultSet = new CRUDHandler().executeSelectStatement(
				claim_selectStatement, claim_connection, 
					new Object[] {polSysID});
			while (claim_resultSet.next()) {
				PV_IL_CLAIM BEAN = new PV_IL_CLAIM();
				
				BEAN.setCLAIM_NO(claim_resultSet
						.getString("CLAIM_NO"));
				BEAN.setCLAIM_TYPE(claim_resultSet
						.getString("CLAIM_TYPE"));
				BEAN.setCLAIM_STATUS(claim_resultSet
						.getString("CLAIM_STATUS"));
				BEAN.setCP_FC_PAID_AMT(claim_resultSet
						.getDouble("CP_FC_PAID_AMT"));
				BEAN.setCP_LC_PAID_AMT(claim_resultSet
						.getDouble("CP_LC_PAID_AMT"));
				BEAN.setCP_PAID_DT(claim_resultSet
						.getDate("CP_PAID_DT"));
				BEAN.setCBEN_BNF_TYPE(claim_resultSet
						.getString("CBEN_BNF_TYPE"));
				BEAN.setCBEN_RELATION_CODE(claim_resultSet
						.getString("CBEN_RELATION_CODE"));
				BEAN.setCBEN_BNF_NAME(claim_resultSet
						.getString("CBEN_BNF_NAME"));
				BEAN.setCBEN_FC_PAID_AMT(claim_resultSet
						.getDouble("CBEN_FC_PAID_AMT"));
				BEAN.setCBEN_LC_PAID_AMT(claim_resultSet
						.getDouble("CBEN_LC_PAID_AMT"));
				BEAN.setUI_M_STATUS_DESC(claim_resultSet
						.getString("UI_M_STATUS_DESC"));
				
				System.out.println("CLAIM_STATUS                 :"+BEAN.getCLAIM_STATUS());
				
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPvClaimList().add(BEAN);
		
			}
		
		
			
			/*end*/
		
		typeDesc();
		

		query = "select * from PV_IL_LOAN where PV_IL_LOAN.LOAN_POL_SYS_ID ="
				+ polSysID;
		// rs = handler.executeSelectStatement(query, connection);
		pvLoanList.clear();
		this.setPV_IL_LOAN_BEAN(new PV_IL_LOAN());
		pvLoanList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_LOAN", connection);

		/*if (pvLoanList.size() != 5) {
			for (int i = pvLoanList.size(); i < 5; i++) {
				PV_IL_LOAN pvILLoan = new PV_IL_LOAN();
				pvLoanList.add(pvILLoan);
			}
		}*/
		
		for (int i = 0; i < pvLoanList.size(); i++) {
			PV_IL_LOAN PV_IL_LOAN_BEAN = pvLoanList.get(i);
			if (i == 0) {
				PV_IL_LOAN_BEAN.setRowSelected(true);
				setPV_IL_LOAN_BEAN(PV_IL_LOAN_BEAN);
			} else {
				PV_IL_LOAN_BEAN.setRowSelected(false);
			}
		}

		
		query = "select * from PV_IL_WITHDRAWAL where PV_IL_WITHDRAWAL.WD_POL_SYS_ID ="
				+ polSysID;
		// rs = handler.executeSelectStatement(query, connection);
		pvWdList.clear();
		this.setPV_IL_WITHDRAWAL_BEAN(new PV_IL_WITHDRAWAL());
		pvWdList = handler.fetch(query,
				"com.iii.pel.forms.PILQ002.PV_IL_WITHDRAWAL", connection);


		for (int i = 0; i < pvWdList.size(); i++) {
			PV_IL_WITHDRAWAL PV_IL_WITHDRAWAL_BEAN = pvWdList.get(i);
			if (i == 0) {
				PV_IL_WITHDRAWAL_BEAN.setRowSelected(true);
				setPV_IL_WITHDRAWAL_BEAN(PV_IL_WITHDRAWAL_BEAN);
			} else {
				PV_IL_WITHDRAWAL_BEAN.setRowSelected(false);
			}
		}
		/*
		 * if (pvWdList.size() != 5 ){ for (int i=pvWdList.size(); i<5;i++){
		 * PV_IL_WITHDRAWAL pvILWithdrawal = new PV_IL_WITHDRAWAL();
		 * pvWdList.add(pvILWithdrawal); } }
		 */

		resetAllComponent();
		resetAllComponent2();
		resetAllComponent3();
		resetAllComponentA();
		
	}catch(Exception e){
		e.printStackTrace();
		getWarningMap().put("POL_NO", e.getMessage());
		getErrorMap().put("current", e.getMessage());
	}

	}
	
	
	
	
	
	

	private void WHEN_NEW_FORM_INSTANCE() {
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		session.put("GLOBAL.M_POL_SYS_ID", null);
		session.put("GLOBAL.M_POLH_SYS_ID", null);
		session.put("GLOBAL.M_POLH_END_NO_IDX", null);
		session.put("GLOBAL.M_POLH_N_END_NO", null);
		session.put("GLOBAL.DTG_DS_TYPE", null);
		session.put("GLOBAL.DTG_DS_CODE", null);
		session.put("GLOBAL.POLH_N_END_CODE", null);

		/*
		 * IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT021%' THEN
		 * GO_BLOCK('PT_IL_POLICY'); END IF;
		 */
	}

	private void PT_IL_POLICY_POST_QUERY() {
		String C1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE  PROD_CODE = '"
				+ PT_IL_POLICY_BEAN.getPOL_PROD_CODE() + "'";
		String C2 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE  CUST_CODE = '"
				+ PT_IL_POLICY_BEAN.getPOL_CUST_CODE() + "'";
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			while (resultSet.next()) {
				PT_IL_POLICY_BEAN.setUI_M_PROD_DESC(resultSet
						.getString("PROD_DESC"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			resultSet = handler.executeSelectStatement(C2, getConnection());
			while (resultSet.next()) {
				PT_IL_POLICY_BEAN.setUI_M_CUST_DESC(resultSet
						.getString("CUST_NAME"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		PT_IL_POLICY_BEAN.setUI_M_PLAN_DESC(P_VAL_PLAN(PT_IL_POLICY_BEAN
				.getPOL_PLAN_CODE(), "", "N", "N"));
	}

	private String P_VAL_PLAN(String P_PLAN_CODE, String P_PLAN_DESC,
			String P_NAME_FLAG, String P_ERR_FLAG) {
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_PLAN_CODE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT",
				P_PLAN_DESC);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_NAME_FLAG);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_ERR_FLAG);

		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);

		try {
			resultList = ora_handler.execute(paramList, getConnection(),
					"P_VAL_PLAN");
			OracleParameter plan_Desc = (OracleParameter) resultList.get(0);
			P_PLAN_DESC = plan_Desc.getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return P_PLAN_DESC;
	}

	private void PT_IL_POLICY_WHEN_NEW_RECORD_INSTANCE() {
		String C1 = "SELECT 'X' FROM PH_IL_POLICY WHERE  POLH_SYS_ID = "
				+ PT_IL_POLICY_BEAN.getPOL_SYS_ID();
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			while (resultSet.next()) {
				PT_IL_POLICY_BEAN.setM_DUMMY(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (PT_IL_POLICY_BEAN.getM_DUMMY().equals("X")) {
			// SET_ITEM_PROPERTY('PH_IL_POLICY.M_BUT_ENDORSEMENT',ENABLED,PROPERTY_TRUE);
		} else {
			// SET_ITEM_PROPERTY('PH_IL_POLICY.M_BUT_ENDORSEMENT',ENABLED,PROPERTY_FALSE);
		}
		session.put("GLOBAL.M_POL_SYS_ID", PT_IL_POLICY_BEAN.getPOL_SYS_ID());
	}

	private void PT_IL_POLICY_ON_POPULATE_DETAILS() {
		/*
		 * DECLARE recstat VARCHAR2(20) := :System.record_status; startitm
		 * VARCHAR2(61) := :System.cursor_item; rel_id Relation; BEGIN IF (
		 * recstat = 'NEW' or recstat = 'INSERT' ) THEN RETURN; END IF; IF (
		 * (:PT_IL_POLICY.POL_SYS_ID is not null) ) THEN rel_id :=
		 * Find_Relation('PT_IL_POLICY.PT_IL_POLICY_PV_IL_WITHDRAWAL');
		 * Query_Master_Details(rel_id, 'PV_IL_WITHDRAWAL'); END IF; IF (
		 * (:PT_IL_POLICY.POL_SYS_ID is not null) ) THEN rel_id :=
		 * Find_Relation('PT_IL_POLICY.PT_IL_POLICY_PV_IL_LOAN');
		 * Query_Master_Details(rel_id, 'PV_IL_LOAN'); END IF; IF (
		 * (:PT_IL_POLICY.POL_SYS_ID is not null) ) THEN rel_id :=
		 * Find_Relation('PT_IL_POLICY.PT_IL_POLICY_PV_IL_CLAIM');
		 * Query_Master_Details(rel_id, 'PV_IL_CLAIM'); END IF; IF (
		 * (:PT_IL_POLICY.POL_SYS_ID is not null) ) THEN rel_id :=
		 * Find_Relation('PT_IL_POLICY.PT_IL_POLICY_PH_IL_POLICY');
		 * Query_Master_Details(rel_id, 'PH_IL_POLICY'); END IF; IF (
		 * :System.cursor_item <> startitm ) THEN Go_Item(startitm);
		 * Check_Package_Failure; END IF; END;
		 */
	}

	private void PT_IL_POLICY_PRE_QUERY() {
		if (PT_IL_POLICY_BEAN.getUI_M_CUST_DESC() != null
				&& !PT_IL_POLICY_BEAN.getUI_M_CUST_DESC().equals("")) {
			WHERE_CLAUSE = "POL_DS_TYPE ='2' AND POL_CUST_CODE  IN (SELECT CUST_CODE FROM PM_CUSTOMER WHERE  CUST_NAME LIKE '"
					+ PT_IL_POLICY_BEAN.getUI_M_CUST_DESC() + "')";
		} else {
			WHERE_CLAUSE = "POL_DS_TYPE ='2'";
		}
		// SET_BLOCK_PROPERTY('PT_IL_POLICY',DEFAULT_WHERE,WHERE_CLAUSE);
		/*
		 * IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT021%' THEN
		 * :PT_IL_POLICY.POL_NO := :GLOBAL.POL_NO; END IF;
		 */}

	public void PT_IL_POLICY_ON_CHECK_DELETE_MASTER() {
		/*
		 * DECLARE Dummy_Define CHAR(1); CURSOR PV_IL_WITHDRAWAL_cur IS SELECT 1
		 * FROM PV_IL_WITHDRAWAL P WHERE P.WD_POL_SYS_ID =
		 * :PT_IL_POLICY.POL_SYS_ID; CURSOR PV_IL_LOAN_cur IS SELECT 1 FROM
		 * PV_IL_LOAN P WHERE P.LOAN_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID;
		 * CURSOR PV_IL_CLAIM_cur IS SELECT 1 FROM PV_IL_CLAIM P WHERE
		 * P.CLAIM_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID; BEGIN OPEN
		 * PV_IL_WITHDRAWAL_cur; FETCH PV_IL_WITHDRAWAL_cur INTO Dummy_Define;
		 * IF ( PV_IL_WITHDRAWAL_cur%found ) THEN Message('Cannot delete master
		 * record when matching detail records exist.'); CLOSE
		 * PV_IL_WITHDRAWAL_cur; RAISE Form_Trigger_Failure; END IF; CLOSE
		 * PV_IL_WITHDRAWAL_cur; OPEN PV_IL_LOAN_cur; FETCH PV_IL_LOAN_cur INTO
		 * Dummy_Define; IF ( PV_IL_LOAN_cur%found ) THEN Message('Cannot delete
		 * master record when matching detail records exist.'); CLOSE
		 * PV_IL_LOAN_cur; RAISE Form_Trigger_Failure; END IF; CLOSE
		 * PV_IL_LOAN_cur; OPEN PV_IL_CLAIM_cur; FETCH PV_IL_CLAIM_cur INTO
		 * Dummy_Define; IF ( PV_IL_CLAIM_cur%found ) THEN Message('Cannot
		 * delete master record when matching detail records exist.'); CLOSE
		 * PV_IL_CLAIM_cur; RAISE Form_Trigger_Failure; END IF; CLOSE
		 * PV_IL_CLAIM_cur; END;
		 */
	}

	public void PT_IL_POLICY_WHEN_NEW_BLOCK_INSTANCE() {
		/*
		 * IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PILT021%' THEN
		 * EXECUTE_QUERY; END IF;
		 */}

	private void PV_IL_CLAIM_POST_QUERY() {
		// PV_IL_CLAIM pv_il_claim_Bean = new PV_IL_CLAIM();
		String C1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE  PS_TYPE = 'ILBENFTYPE'";
		String[][] PS_CODE = new String[2][2];
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			int i = 0;
			while (resultSet.next()) {
				PS_CODE[i][0] = resultSet.getString("PS_CODE");
				PS_CODE[i][1] = resultSet.getString("PS_CODE_DESC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pvClaimList.size(); i++) {
			PV_IL_CLAIM pvIlClaim = pvClaimList.get(i);

			if (!("".equalsIgnoreCase(pvIlClaim.getCBEN_BNF_TYPE()))) {
				for (int j = 0; j < PS_CODE.length; j++) {
					if(PS_CODE[j][0] != null){
					if (PS_CODE[j][0].equals(pvIlClaim.getCBEN_BNF_TYPE())) {
						pvIlClaim.setUI_M_TYPE_DESC(PS_CODE[j][1]);
						setM_FLAG("Y");
					} else {
						setM_FLAG("N");
					}
					}
				}
			}
		}
		if (getM_FLAG().equals("N")) {
			// STD_MESSAGE_ROUTINE(71253,NAME_IN('GLOBAL.M_LANG_CODE'));
			// RAISE FORM_TRIGGER_FAILURE;
		}

	}

	private String getM_FLAG() {
		return M_FLAG;
	}

	private void setM_FLAG(String m_flag) {
		M_FLAG = m_flag;
	}

	PH_IL_POLICY ph_il_policy_Bean = new PH_IL_POLICY();

	private void PH_IL_POLICY_WHEN_NEW_RECORD_INSTANCE() throws Exception {
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		session.put("GLOBAL.M_POLH_END_NO_IDX", ph_il_policy_Bean
				.getPOLH_END_NO_IDX());
		session.put("GLOBAL.M_POLH_SYS_ID", ph_il_policy_Bean.getPOLH_SYS_ID());
		String  C1 = "SELECT 'X' FROM   PH_IL_POLICY WHERE  POLH_SYS_ID = ?";
		String M_DUMMY = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{this.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			while(rs.next()){
				M_DUMMY = rs.getString(1);
			}
			if("X".equals(M_DUMMY)) 
				 this.getCOMP_M_BUT_ENDORSEMENT().setDisabled(false);
			else
				this.getCOMP_M_BUT_ENDORSEMENT().setDisabled(true);
		  
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public void PH_IL_POLICY_POST_QUERY() throws Exception {
		for (int i = 0; i < phList.size(); i++) {
			PH_IL_POLICY phIlpoloicy = phList.get(i);
			if (phIlpoloicy.getPOLH_N_END_CODE() != null) {
				String C1 = "SELECT DS_DESC FROM PM_IL_DOC_SETUP WHERE 	DS_TYPE = '3' AND DS_CODE ='"
						+ phIlpoloicy.getPOLH_N_END_CODE() + "'";
				System.out.println(C1);
				resultSet = handler.executeSelectStatement(C1, getConnection());
				while (resultSet.next()) {
					phIlpoloicy.setUI_M_POLH_N_END_CODE_DESC(resultSet
							.getString("DS_DESC"));
				}
			}
		}

	}
	
	
	public void custOtherPolicyPostQuery() throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String query="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_REC_STA' AND PS_CODE=? ";
		try{
			connection = CommonUtils.getConnection();
			for (int i = 0; i < phPolCustList.size(); i++) {
				PT_IL_POLICY_1 policyBean = phPolCustList.get(i);
				if(policyBean.getPOL_STATUS() != null){
					resultSet = new CRUDHandler().executeSelectStatement(query, connection, 
							new Object[]{policyBean.getPOL_STATUS()});
					if(resultSet.next()){
						policyBean.setUI_POL_REC_STATUS_DESC(resultSet.getString(1));
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	
	
	public String UI_M_BUT_POLICY_WHEN_BUTTON_PRESSED() {
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		try {
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILQ002");
			if (PT_IL_POLICY_BEAN.getPOL_NO() == null
					|| PT_IL_POLICY_BEAN.getPOL_NO().equals("")) {
				throw new Exception("No Policy No. Entered");
			} else {
				CommonUtils.setGlobalVariable("GLOBAL.M_POLH_N_END_NO","");	
				CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",PT_IL_POLICY_BEAN.getPOL_SYS_ID());
				CommonUtils.setGlobalObject("GLOBAL.M_POLH_SYS_ID",PH_IL_POLICY_BEAN.getPOLH_SYS_ID()); // 06-7-2004
				CommonUtils.setGlobalVariable("GLOBAL.M_POLH_END_NO_IDX",null);
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_END_FLAG","P");
				CommonUtils.setGlobalVariable("GLOBAL.DTG_DS_TYPE",PT_IL_POLICY_BEAN.getPOL_DS_TYPE());
				CommonUtils.setGlobalVariable("GLOBAL.DTG_DS_CODE",PT_IL_POLICY_BEAN.getPOL_DS_CODE());
				
				
				/*added by raja on 15-03-2017*/
				CommonUtils.setGlobalVariable("GLOBAL.CALL_QUERY","QUERY");
				CommonUtils.setGlobalVariable("GLOBAL.QUERY_BACK","TRUE");
				CommonUtils.setGlobalVariable("GLOBAL.POL_ROW_ID",PT_IL_POLICY_BEAN.getROWID());
				System.out.println("ROW ID ==== > "+CommonUtils.getGlobalVariable("GLOBAL.POL_ROW_ID"));
				
				if(CommonUtils.getGlobalVariable("CALLING_FORM")!=null && CommonUtils.getGlobalVariable("CALLING_FORM").startsWith("PQ123")){
//					L_DB_CON ('GL01');
				}
				
				/*IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PQ123%' THEN
				L_DB_CON ('P02');*/

			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_BUT_POLICY", e.getMessage());
		}
		// CALL_FORM('PILQ003_APAC',HIDE,NO_REPLACE,QUERY_ONLY);
		return "PILQ003";
	}
	
	
	//Added by akash to forward on Renewal premium collection Screen..
		
	public String buttonPressRenewal(){
		String outcome = "";
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", PT_IL_POLICY_BEAN
				.getPOL_NO());
		try {
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILQ002");
			//new PILT003_APAC_COMPOSITE_ACTION();
			
			outcome = "PILT003_APAC_PT_IL_PREM_COLL";
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return outcome;
		
	}
	
	//Added by akash to forward on Renewal premium collection Screen..
	
	
	//Added by akash to forward on Renewal premium collection Screen..
	
	public String UI_M_BUT_ENDORSEMENT_WHEN_BUTTON_PRESSED() {
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		try {
			if (PH_IL_POLICY_BEAN.getPOLH_END_NO_IDX() == null
					|| PT_IL_POLICY_BEAN.getPOL_NO().equals("")) {
				throw new Exception("No Endorsement For This Policy");
			} else {
				CommonUtils.setGlobalVariable("GLOBAL.M_POLH_END_NO_IDX",String.valueOf(PH_IL_POLICY_BEAN.getPOLH_END_NO_IDX()+1));	
				CommonUtils.setGlobalObject("GLOBAL.M_POLH_N_END_NO","Endorsement No   "+PH_IL_POLICY_BEAN.getPOLH_N_END_NO());
				CommonUtils.setGlobalObject("GLOBAL.M_POLH_SYS_ID",PH_IL_POLICY_BEAN.getPOLH_SYS_ID());
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_END_FLAG","E");
				CommonUtils.setGlobalVariable("GLOBAL.DTG_DS_TYPE",PH_IL_POLICY_BEAN.getPOLH_DS_TYPE());
				CommonUtils.setGlobalVariable("GLOBAL.DTG_DS_CODE",PH_IL_POLICY_BEAN.getPOLH_DS_CODE());
				CommonUtils.setGlobalVariable("GLOBAL.POLH_N_END_CODE",PH_IL_POLICY_BEAN.getPOLH_N_END_CODE());

				if(CommonUtils.getGlobalVariable("CALLING_FORM")!=null && CommonUtils.getGlobalVariable("CALLING_FORM").startsWith("PQ123")){
//					L_DB_CON ('GL01');
				}
				
				/*IF GET_APPLICATION_PROPERTY(CALLING_FORM) LIKE 'PQ123%' THEN
				L_DB_CON ('P02');*/
				CommonUtils.setGlobalVariable("CALLING_FORM", "PILQ002");
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("UI_M_BUT_POLICY", e.getMessage());
		}
		// CALL_FORM('PILQ003_APAC',HIDE,NO_REPLACE,QUERY_ONLY);
		return "PILQ003";
	}

	public String DUMMY_M_BUT_POLICY_WHEN_BUTTON_PRESSED() {
		System.out
				.println("PT_IL_POLICY_ACTION.DUMMY_M_BUT_POLICY_WHEN_BUTTON_PRESSED(******************************)");
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		String C1 = "SELECT POL_PLAN_CODE, POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = "
				+ PT_IL_POLICY_BEAN.getPOL_NO();
		String str = null;
		if (PT_IL_POLICY_BEAN.getPOL_NO() == null
				|| PT_IL_POLICY_BEAN.getPOL_NO().equals("")) {
			// DISP_ALERT('No Policy No. Entered');
			// RAISE FORM_TRIGGER_FAILURE;
		} else {
			try {
				resultSet = handler.executeSelectStatement(C1, getConnection());
				while (resultSet.next()) {
					PT_IL_POLICY_BEAN.setM_POL_PLAN_CODE(resultSet
							.getString("POL_PLAN_CODE"));
					PT_IL_POLICY_BEAN.setM_POL_PROD_CODE(resultSet
							.getString("POL_PROD_CODE"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "policyscr";
		}
		session.put("GLOBAL.M_PARA_3", PT_IL_POLICY_BEAN.getM_POL_PLAN_CODE());
		session.put("GLOBAL.M_PARA_6", PT_IL_POLICY_BEAN.getM_POL_PROD_CODE());
		session.put("GLOBAL.M_POLH_N_END_NO", "");
		session.put("GLOBAL.M_POL_SYS_ID", PT_IL_POLICY_BEAN.getPOL_SYS_ID());
		session.put("GLOBAL.M_POLH_SYS_ID", ph_il_policy_Bean.getPOLH_SYS_ID());
		session.put("GLOBAL.M_POLH_END_NO_IDX", null);
		session.put("GLOBAL.M_POL_END_FLAG", "P");
		session.put("GLOBAL.DTG_DS_TYPE", PT_IL_POLICY_BEAN.getPOL_DS_TYPE());
		session.put("GLOBAL.DTG_DS_CODE", PT_IL_POLICY_BEAN.getPOL_DS_CODE());

		// CALL_FORM('PILQ003_APAC',HIDE,NO_REPLACE,QUERY_ONLY);
		return str;
	}

	// Muthu Added

	public PV_IL_CLAIM getPV_IL_CLAIM_BEAN() {
		return PV_IL_CLAIM_BEAN;
	}

	public void setPV_IL_CLAIM_BEAN(PV_IL_CLAIM pv_il_claim_bean) {
		PV_IL_CLAIM_BEAN = pv_il_claim_bean;
	}

	public void getDetails2() {
		try {
			//if (pvClaimList.size() != 0) {
				PV_IL_CLAIM_BEAN = (PV_IL_CLAIM) dataTable2.getRowData();
				typeDesc();
			//}
			resetAllComponent2();
			resetSelectedRow2();
			PV_IL_CLAIM_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void typeDesc() throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'ILBENFTYPE' AND PS_CODE = ?  ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{PV_IL_CLAIM_BEAN.getCBEN_BNF_TYPE()});
			if(resultSet.next()){
				PV_IL_CLAIM_BEAN.setUI_M_TYPE_DESC(resultSet.getString(1));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		 
	}

	public void resetAllComponent2() {
		// Reseting HtmlInputText
		COMP_CLAIM_TYPE.resetValue();
		COMP_CBEN_BNF_TYPE.resetValue();
		COMP_CP_LC_PAID_AMT.resetValue();
		COMP_UI_M_TYPE_DESC.resetValue();
	}
	

	private void resetSelectedRow2() {
		Iterator<PV_IL_CLAIM> iterator = pvClaimList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public UIData getDataTableA() {
		return dataTable;
	}

	public void setDataTableA(UIData dataTableA) {
		this.dataTableA = dataTableA;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getRD_POL_SYS_ID() {
		return RD_POL_SYS_ID;
	}

	public void setRD_POL_SYS_ID(String rd_pol_sys_id) {
		RD_POL_SYS_ID = rd_pol_sys_id;
	}

	public String getRD_END_NO_IDX() {
		return RD_END_NO_IDX;
	}

	public void setRD_END_NO_IDX(String rd_end_no_idx) {
		RD_END_NO_IDX = rd_end_no_idx;
	}

	public String getRPA_RD_SYS_ID() {
		return RPA_RD_SYS_ID;
	}

	public void setRPA_RD_SYS_ID(String rpa_rd_sys_id) {
		RPA_RD_SYS_ID = rpa_rd_sys_id;
	}

	public String getRD_COVER_CODE() {
		return RD_COVER_CODE;
	}

	public void setRD_COVER_CODE(String rd_cover_code) {
		RD_COVER_CODE = rd_cover_code;
	}

	public String getSelectQuery() {
		return selectQuery;
	}

	public void setSelectQuery(String selectQuery) {
		this.selectQuery = selectQuery;
	}

	public FacesContext getCtx() {
		return ctx;
	}

	public void setCtx(FacesContext ctx) {
		this.ctx = ctx;
	}

	public ArrayList getSuggesionList() {
		return suggesionList;
	}

	public void setSuggesionList(ArrayList suggesionList) {
		this.suggesionList = suggesionList;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public CRUDHandler getHandler() {
		return handler;
	}

	public void setHandler(CRUDHandler handler) {
		this.handler = handler;
	}

	public ArrayList<OracleParameter> getParamList() {
		return paramList;
	}

	public void setParamList(ArrayList<OracleParameter> paramList) {
		this.paramList = paramList;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public OracleProcedureHandler getOra_handler() {
		return ora_handler;
	}

	public void setOra_handler(OracleProcedureHandler ora_handler) {
		this.ora_handler = ora_handler;
	}

	public String getWHERE_CLAUSE() {
		return WHERE_CLAUSE;
	}

	public void setWHERE_CLAUSE(String where_clause) {
		WHERE_CLAUSE = where_clause;
	}

	public PH_IL_POLICY getPh_il_policy_Bean() {
		return ph_il_policy_Bean;
	}

	public void setPh_il_policy_Bean(PH_IL_POLICY ph_il_policy_Bean) {
		this.ph_il_policy_Bean = ph_il_policy_Bean;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public HtmlInputText getCOMP_LOAN_LC_AMOUNT() {
		return COMP_LOAN_LC_AMOUNT;
	}

	public void setCOMP_LOAN_LC_AMOUNT(HtmlInputText comp_loan_lc_amount) {
		COMP_LOAN_LC_AMOUNT = comp_loan_lc_amount;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_AMOUNT_LABEL() {
		return COMP_LOAN_LC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_LC_AMOUNT_LABEL(
			HtmlOutputLabel comp_loan_lc_amount_label) {
		COMP_LOAN_LC_AMOUNT_LABEL = comp_loan_lc_amount_label;
	}

	public HtmlInputText getCOMP_LOAN_LC_REPAID_AMT() {
		return COMP_LOAN_LC_REPAID_AMT;
	}

	public void setCOMP_LOAN_LC_REPAID_AMT(HtmlInputText comp_loan_lc_repaid_amt) {
		COMP_LOAN_LC_REPAID_AMT = comp_loan_lc_repaid_amt;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_REPAID_AMT_LABEL() {
		return COMP_LOAN_LC_REPAID_AMT_LABEL;
	}

	public void setCOMP_LOAN_LC_REPAID_AMT_LABEL(
			HtmlOutputLabel comp_loan_lc_repaid_amt_label) {
		COMP_LOAN_LC_REPAID_AMT_LABEL = comp_loan_lc_repaid_amt_label;
	}

	public HtmlInputText getCOMP_LOAN_LC_INTEREST() {
		return COMP_LOAN_LC_INTEREST;
	}

	public void setCOMP_LOAN_LC_INTEREST(HtmlInputText comp_loan_lc_interest) {
		COMP_LOAN_LC_INTEREST = comp_loan_lc_interest;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_INTEREST_LABEL() {
		return COMP_LOAN_LC_INTEREST_LABEL;
	}

	public void setCOMP_LOAN_LC_INTEREST_LABEL(
			HtmlOutputLabel comp_loan_lc_interest_label) {
		COMP_LOAN_LC_INTEREST_LABEL = comp_loan_lc_interest_label;
	}

	public HtmlInputText getCOMP_LOAN_LC_OS_AMOUNT() {
		return COMP_LOAN_LC_OS_AMOUNT;
	}

	public void setCOMP_LOAN_LC_OS_AMOUNT(HtmlInputText comp_loan_lc_os_amount) {
		COMP_LOAN_LC_OS_AMOUNT = comp_loan_lc_os_amount;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_OS_AMOUNT_LABEL() {
		return COMP_LOAN_LC_OS_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_LC_OS_AMOUNT_LABEL(
			HtmlOutputLabel comp_loan_lc_os_amount_label) {
		COMP_LOAN_LC_OS_AMOUNT_LABEL = comp_loan_lc_os_amount_label;
	}

	public PV_IL_LOAN getPV_IL_LOAN_BEAN() {
		return PV_IL_LOAN_BEAN;
	}

	public void setPV_IL_LOAN_BEAN(PV_IL_LOAN pv_il_loan_bean) {
		PV_IL_LOAN_BEAN = pv_il_loan_bean;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (pvLoanList.size() != 0) {
				PV_IL_LOAN_BEAN = (PV_IL_LOAN) dataTable.getRowData();
			}
			resetAllComponentA();
			// Reset selection for other beans
			resetSelectedRowA();
			PV_IL_LOAN_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	public void displayBonusRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRowBonus();
			PV_IL_BONUS_BEAN = (PV_IL_BONUS) pvBonusDataTable.getRowData();
			PV_IL_BONUS_BEAN.setRowSelected(true);
			resetAllComponentBonus();
			/*resetSelectedRow();
			PM_IL_PROD_APPL_BONUS_BEAN = (PM_IL_PROD_APPL_BONUS) dataTable
					.getRowData();
			PM_IL_PROD_APPL_BONUS_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);*/
		} catch (Exception exc) {
			getErrorMap()
			.put(
					com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	private void resetSelectedRowBonus(){
		Iterator<PV_IL_BONUS> iterator = pvBonusList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	private void resetAllComponentBonus(){
		
	}

	private void resetSelectedRowA() {
		Iterator<PV_IL_LOAN> iterator = pvLoanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponentA() {
		COMP_LOAN_LC_OS_AMOUNT.resetValue();
		COMP_LOAN_LC_AMOUNT.resetValue();
		COMP_LOAN_LC_REPAID_AMT.resetValue();
		COMP_LOAN_LC_INTEREST.resetValue();

	}

	public void resetAllComponent3() {

		// Reseting HtmlInputText
		COMP_WDC_FC_VALUE.resetValue();
		COMP_WD_NET_FC_VALUE.resetValue();
		COMP_WD_DATE.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow3() {
		Iterator<PV_IL_WITHDRAWAL> iterator = pvWdList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void getDetails3() {
		try {
			if (pvWdList.size() != 0) {
				PV_IL_WITHDRAWAL_BEAN = (PV_IL_WITHDRAWAL) pvDataTable
						.getRowData();
			}
			resetAllComponent3();
			resetSelectedRow3();
			PV_IL_WITHDRAWAL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDetails() {
		try {
			if (phList.size() != 0) {
				PH_IL_POLICY_BEAN = (PH_IL_POLICY) phDataTable.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PH_IL_POLICY_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[Added by Akash to add status block .
	
	public void resetAllStatusComponent(){
		COMP_PS_REMARKS.resetValue();
		COMP_UI_M_STAT_DESC.resetValue();
		COMP_UI_M_PC_DESC.resetValue();
	}
	
	private void resetSelectedRowStatus() {
		Iterator<PT_IL_POL_STATUS> iterator = phStatusList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void getStatusDetails() {
		try {
			resetSelectedRowStatus();
			if (phStatusList.size() != 0) {
				PT_IL_POL_STATUS_BEAN = (PT_IL_POL_STATUS) phStatusDataTable.getRowData();
				
				/*Commented by Janani on 4.03.2017 for ZB status desc*/
				//postQueryStatus();
			
			/*end*/
			
			}
			PT_IL_POL_STATUS_BEAN.setRowSelected(true);
			resetAllStatusComponent();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	//aaa
	
	public void postQueryStatus() throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String descReason = " SELECT PC_DESC FROM PM_CODES WHERE PC_CODE = ? AND PC_TYPE='IL_REASON' ";
		String descStaus = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_CODE = ?  AND PS_TYPE='IL_ADDL_STAT'";
		try{
			connection = CommonUtils.getConnection();
			
			System.out.println("getPS_REASON_CODE         :"+PT_IL_POL_STATUS_BEAN.getPS_REASON_CODE());
			
			
			
			resultSet = handler.executeSelectStatement(descReason, connection, 
					new Object[]{PT_IL_POL_STATUS_BEAN.getPS_REASON_CODE()});
			if(resultSet.next()){
				PT_IL_POL_STATUS_BEAN.setUI_M_PC_DESC(resultSet.getString(1));
			}
			CommonUtils.closeCursor(resultSet);
			
			
			System.out.println("getPS_STATUS         :"+PT_IL_POL_STATUS_BEAN.getPS_STATUS());
			
			
			resultSet = handler.executeSelectStatement(descStaus, connection, 
					new Object[]{PT_IL_POL_STATUS_BEAN.getPS_STATUS()});
			if(resultSet.next()){
				PT_IL_POL_STATUS_BEAN.setUI_M_STAT_DESC(resultSet.getString(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	//Added by Akash to add status block .]
	
	
	private void resetSelectedRow() {
		Iterator<PH_IL_POLICY> iterator = phList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_POLH_N_END_DESC.resetValue();
	}

	public String getFilterByWD_NUMBER() {
		return filterByWD_NUMBER;
	}

	public void setFilterByWD_NUMBER(String filterByWD_NUMBER) {
		this.filterByWD_NUMBER = filterByWD_NUMBER;
	}

	public String getFilterByWD_NET_LC_VALUE() {
		return filterByWD_NET_LC_VALUE;
	}

	public void setFilterByWD_NET_LC_VALUE(String filterByWD_NET_LC_VALUE) {
		this.filterByWD_NET_LC_VALUE = filterByWD_NET_LC_VALUE;
	}

	public String getFilterByWDC_RATE() {
		return filterByWDC_RATE;
	}

	public void setFilterByWDC_RATE(String filterByWDC_RATE) {
		this.filterByWDC_RATE = filterByWDC_RATE;
	}

	public String getFilterByWDC_RATE_PER() {
		return filterByWDC_RATE_PER;
	}

	public void setFilterByWDC_RATE_PER(String filterByWDC_RATE_PER) {
		this.filterByWDC_RATE_PER = filterByWDC_RATE_PER;
	}

	public String getFilterByWDC_LC_VALUE() {
		return filterByWDC_LC_VALUE;
	}

	public void setFilterByWDC_LC_VALUE(String filterByWDC_LC_VALUE) {
		this.filterByWDC_LC_VALUE = filterByWDC_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_DATE_LABEL() {
		return COMP_WD_DATE_LABEL;
	}

	public void setCOMP_WD_DATE_LABEL(HtmlOutputLabel comp_wd_date_label) {
		COMP_WD_DATE_LABEL = comp_wd_date_label;
	}

	public HtmlCalendar getCOMP_WD_DATE() {
		return COMP_WD_DATE;
	}

	public void setCOMP_WD_DATE(HtmlCalendar comp_wd_date) {
		COMP_WD_DATE = comp_wd_date;
	}

	public HtmlOutputLabel getCOMP_WD_NET_FC_VALUE_LABEL() {
		return COMP_WD_NET_FC_VALUE_LABEL;
	}

	public void setCOMP_WD_NET_FC_VALUE_LABEL(
			HtmlOutputLabel comp_wd_net_fc_value_label) {
		COMP_WD_NET_FC_VALUE_LABEL = comp_wd_net_fc_value_label;
	}

	public HtmlInputText getCOMP_WD_NET_FC_VALUE() {
		return COMP_WD_NET_FC_VALUE;
	}

	public void setCOMP_WD_NET_FC_VALUE(HtmlInputText comp_wd_net_fc_value) {
		COMP_WD_NET_FC_VALUE = comp_wd_net_fc_value;
	}

	public HtmlOutputLabel getCOMP_WDC_FC_VALUE_LABEL() {
		return COMP_WDC_FC_VALUE_LABEL;
	}

	public void setCOMP_WDC_FC_VALUE_LABEL(
			HtmlOutputLabel comp_wdc_fc_value_label) {
		COMP_WDC_FC_VALUE_LABEL = comp_wdc_fc_value_label;
	}

	public HtmlInputText getCOMP_WDC_FC_VALUE() {
		return COMP_WDC_FC_VALUE;
	}

	public void setCOMP_WDC_FC_VALUE(HtmlInputText comp_wdc_fc_value) {
		COMP_WDC_FC_VALUE = comp_wdc_fc_value;
	}

	public PV_IL_WITHDRAWAL getPV_IL_WITHDRAWAL_BEAN() {
		return PV_IL_WITHDRAWAL_BEAN;
	}

	public void setPV_IL_WITHDRAWAL_BEAN(PV_IL_WITHDRAWAL pv_il_withdrawal_bean) {
		PV_IL_WITHDRAWAL_BEAN = pv_il_withdrawal_bean;
	}

	public UIDataTable getPvDataTable() {
		return pvDataTable;
	}

	public void setPvDataTable(UIDataTable pvDataTable) {
		this.pvDataTable = pvDataTable;
	}

	/**
	 * @return the phDataTable
	 */
	public UIDataTable getPhDataTable() {
		return phDataTable;
	}

	/**
	 * @param phDataTable
	 *            the phDataTable to set
	 */
	public void setPhDataTable(UIDataTable phDataTable) {
		this.phDataTable = phDataTable;
	}

	/**
	 * @return the pvClaimDataTable
	 */
	public UIDataTable getPvClaimDataTable() {
		return pvClaimDataTable;
	}

	/**
	 * @param pvClaimDataTable
	 *            the pvClaimDataTable to set
	 */
	public void setPvClaimDataTable(UIDataTable pvClaimDataTable) {
		this.pvClaimDataTable = pvClaimDataTable;
	}

	/**
	 * @return the filterByPOLH_N_END_CODE
	 */
	public String getFilterByPOLH_N_END_CODE() {
		return filterByPOLH_N_END_CODE;
	}

	/**
	 * @param filterByPOLH_N_END_CODE
	 *            the filterByPOLH_N_END_CODE to set
	 */
	public void setFilterByPOLH_N_END_CODE(String filterByPOLH_N_END_CODE) {
		this.filterByPOLH_N_END_CODE = filterByPOLH_N_END_CODE;
	}

	/**
	 * @return the filterByPOLH_N_END_NO
	 */
	public String getFilterByPOLH_N_END_NO() {
		return filterByPOLH_N_END_NO;
	}

	/**
	 * @param filterByPOLH_N_END_NO
	 *            the filterByPOLH_N_END_NO to set
	 */
	public void setFilterByPOLH_N_END_NO(String filterByPOLH_N_END_NO) {
		this.filterByPOLH_N_END_NO = filterByPOLH_N_END_NO;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add
	 *            the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete
	 *            the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post
	 *            the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the pH_IL_POLICY_BEAN
	 */
	public PH_IL_POLICY getPH_IL_POLICY_BEAN() {
		return PH_IL_POLICY_BEAN;
	}

	/**
	 * @param ph_il_policy_bean
	 *            the pH_IL_POLICY_BEAN to set
	 */
	public void setPH_IL_POLICY_BEAN(PH_IL_POLICY ph_il_policy_bean) {
		PH_IL_POLICY_BEAN = ph_il_policy_bean;
	}

	/**
	 * @return the dataTable
	 */
	public UIDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the filterByPOLH_N_END_NO_IDX
	 */
	public String getFilterByPOLH_N_END_NO_IDX() {
		return filterByPOLH_N_END_NO_IDX;
	}

	/**
	 * @param filterByPOLH_N_END_NO_IDX
	 *            the filterByPOLH_N_END_NO_IDX to set
	 */
	public void setFilterByPOLH_N_END_NO_IDX(String filterByPOLH_N_END_NO_IDX) {
		this.filterByPOLH_N_END_NO_IDX = filterByPOLH_N_END_NO_IDX;
	}

	/**
	 * @return the filterByUI_M_POLH_N_END_CODE_DESC
	 */
	public String getFilterByUI_M_POLH_N_END_CODE_DESC() {
		return filterByUI_M_POLH_N_END_CODE_DESC;
	}

	/**
	 * @param filterByUI_M_POLH_N_END_CODE_DESC
	 *            the filterByUI_M_POLH_N_END_CODE_DESC to set
	 */
	public void setFilterByUI_M_POLH_N_END_CODE_DESC(
			String filterByUI_M_POLH_N_END_CODE_DESC) {
		this.filterByUI_M_POLH_N_END_CODE_DESC = filterByUI_M_POLH_N_END_CODE_DESC;
	}

	/**
	 * @return the filterByPOLH_N_END_EFF_FROM_DT
	 */
	public String getFilterByPOLH_N_END_EFF_FROM_DT() {
		return filterByPOLH_N_END_EFF_FROM_DT;
	}

	/**
	 * @param filterByPOLH_N_END_EFF_FROM_DT
	 *            the filterByPOLH_N_END_EFF_FROM_DT to set
	 */
	public void setFilterByPOLH_N_END_EFF_FROM_DT(
			String filterByPOLH_N_END_EFF_FROM_DT) {
		this.filterByPOLH_N_END_EFF_FROM_DT = filterByPOLH_N_END_EFF_FROM_DT;
	}

	/**
	 * @return the filterByPOLH_N_END_EFF_TO_DT
	 */
	public String getFilterByPOLH_N_END_EFF_TO_DT() {
		return filterByPOLH_N_END_EFF_TO_DT;
	}

	/**
	 * @param filterByPOLH_N_END_EFF_TO_DT
	 *            the filterByPOLH_N_END_EFF_TO_DT to set
	 */
	public void setFilterByPOLH_N_END_EFF_TO_DT(
			String filterByPOLH_N_END_EFF_TO_DT) {
		this.filterByPOLH_N_END_EFF_TO_DT = filterByPOLH_N_END_EFF_TO_DT;
	}

	/**
	 * @return the cOMP_POLH_N_END_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_POLH_N_END_DESC_LABEL() {
		return COMP_POLH_N_END_DESC_LABEL;
	}

	/**
	 * @param comp_polh_n_end_desc_label
	 *            the cOMP_POLH_N_END_DESC_LABEL to set
	 */
	public void setCOMP_POLH_N_END_DESC_LABEL(
			HtmlOutputLabel comp_polh_n_end_desc_label) {
		COMP_POLH_N_END_DESC_LABEL = comp_polh_n_end_desc_label;
	}

	/**
	 * @return the cOMP_POLH_N_END_DESC
	 */
	public HtmlInputText getCOMP_POLH_N_END_DESC() {
		return COMP_POLH_N_END_DESC;
	}

	/**
	 * @param comp_polh_n_end_desc
	 *            the cOMP_POLH_N_END_DESC to set
	 */
	public void setCOMP_POLH_N_END_DESC(HtmlInputText comp_polh_n_end_desc) {
		COMP_POLH_N_END_DESC = comp_polh_n_end_desc;
	}

	 
	
	public HtmlAjaxCommandButton getCOMP_M_BUT_ENDORSEMENT() {
		return COMP_M_BUT_ENDORSEMENT;
	}

	public void setCOMP_M_BUT_ENDORSEMENT(
			HtmlAjaxCommandButton comp_m_but_endorsement) {
		COMP_M_BUT_ENDORSEMENT = comp_m_but_endorsement;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				preForm();
				WHEN_NEW_FORM_INSTANCE();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.executeSelect(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
				/*ADDED BY GOPI FOR QUOTATION LETTER GENERATE ON 30/05/17*/
				preparDropDownList();
				//END
				getAllHistoryDetails(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				PH_IL_POLICY_WHEN_NEW_RECORD_INSTANCE();
				getBonusDetails(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
				FETCH_BUTTON_PRESSED();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getWarningMap().put("onLoad", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}

	public PV_IL_BONUS getPV_IL_BONUS_BEAN() {
		return PV_IL_BONUS_BEAN;
	}

	public void setPV_IL_BONUS_BEAN(PV_IL_BONUS pv_il_bonus_bean) {
		PV_IL_BONUS_BEAN = pv_il_bonus_bean;
	}

	public List<PV_IL_BONUS> getPvBonusList() {
		return pvBonusList;
	}

	public void setPvBonusList(List<PV_IL_BONUS> pvBonusList) {
		this.pvBonusList = pvBonusList;
	}

	public UIDataTable getPvBonusDataTable() {
		return pvBonusDataTable;
	}

	public void setPvBonusDataTable(UIDataTable pvBonusDataTable) {
		this.pvBonusDataTable = pvBonusDataTable;
	}

	
	
	/**
	 * @return the uI_M_PV_BONUS_TOTAL
	 */
	public int getUI_M_PV_BONUS_TOTAL() {
		return UI_M_PV_BONUS_TOTAL;
	}

	/**
	 * @param ui_m_pv_bonus_total the uI_M_PV_BONUS_TOTAL to set
	 */
	public void setUI_M_PV_BONUS_TOTAL(int ui_m_pv_bonus_total) {
		UI_M_PV_BONUS_TOTAL = ui_m_pv_bonus_total;
	}

	public void getBonusDetails(PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN) throws Exception{
		executeSelect(PT_IL_POLICY_ACTION_BEAN);
	}
	
	public void executeSelect(PT_IL_POLICY_ACTION pt_il_policy_action) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String Select_query = "SELECT AVR_POL_SYS_ID,AVR_LOAN_DT,AVR_LOAN_AMT,AVR_BONUS_AMT,AVR_LOAN_INT FROM PS_IL_ANIVR_PROCESS WHERE AVR_POL_SYS_ID = ?";
		//PM_IL_PROD_GROUP_HDR header = null;
		PT_IL_POLICY PT_IL_POLICY_BEAN = pt_il_policy_action.getPT_IL_POLICY_BEAN();
		List<PV_IL_BONUS> list = new ArrayList<PV_IL_BONUS>();
		PV_IL_BONUS PV_IL_BONUS_BEAN = null;
		int totalBonusAmount = 0;
		int totalBonusInterest = 0;
		try {
			System.out.println("PT_IL_POLICY_BEAN.getPOL_SYS_ID()"+PT_IL_POLICY_BEAN.getPOL_SYS_ID());
			rs = handler.executeSelectStatement(Select_query,CommonUtils.getConnection(),
					new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			
			while (rs.next()) {
				PV_IL_BONUS_BEAN = new PV_IL_BONUS();
				PV_IL_BONUS_BEAN.setAVR_POL_SYS_ID(rs.getInt("AVR_POL_SYS_ID"));
				PV_IL_BONUS_BEAN.setPV_BONUS_YEAR(rs.getDate("AVR_LOAN_DT"));
				PV_IL_BONUS_BEAN.setPV_BONUS(rs.getInt("AVR_LOAN_AMT"));
				PV_IL_BONUS_BEAN.setPV_BONUS_INT(rs.getInt("AVR_LOAN_INT"));
				list.add(PV_IL_BONUS_BEAN);
				totalBonusAmount = totalBonusAmount + PV_IL_BONUS_BEAN.getPV_BONUS();
				totalBonusInterest = totalBonusInterest + PV_IL_BONUS_BEAN.getPV_BONUS_INT();
			}
			System.out.println("totalBonusAmount"+totalBonusAmount);
			pt_il_policy_action.setPvBonusList(list);
			pt_il_policy_action.setUI_M_PV_BONUS_TOTAL(totalBonusAmount);
			pt_il_policy_action.setUI_M_PV_BONUS_INTEREST_TOTAL(totalBonusInterest);
			
			if(pt_il_policy_action.getPvBonusList()!=null 
					&& !pt_il_policy_action.getPvBonusList().isEmpty()){
				for(int i = 0;i<pt_il_policy_action.getPvBonusList().size();i++){
					PV_IL_BONUS PV_IL_BONUS_BEAN_1 = pt_il_policy_action.getPvBonusList().get(i);
					if(i==0){
						PV_IL_BONUS_BEAN_1.setRowSelected(true);
						pt_il_policy_action.setPV_IL_BONUS_BEAN(PV_IL_BONUS_BEAN_1);
					}else{
						PV_IL_BONUS_BEAN_1.setRowSelected(false);
						}
					}
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(rs);
		}
}

	/**
	 * @return the uI_M_PV_BONUS_INTEREST_TOTAL
	 */
	public int getUI_M_PV_BONUS_INTEREST_TOTAL() {
		return UI_M_PV_BONUS_INTEREST_TOTAL;
	}

	/**
	 * @param ui_m_pv_bonus_interest_total the uI_M_PV_BONUS_INTEREST_TOTAL to set
	 */
	public void setUI_M_PV_BONUS_INTEREST_TOTAL(int ui_m_pv_bonus_interest_total) {
		UI_M_PV_BONUS_INTEREST_TOTAL = ui_m_pv_bonus_interest_total;
	}

	public UIDataTable getDataTable2() {
		return dataTable2;
	}

	public void setDataTable2(UIDataTable dataTable2) {
		this.dataTable2 = dataTable2;
	}

	public PILQ002_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ002_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlOutputLabel getCOMP_PS_REMARKS_LABEL() {
		return COMP_PS_REMARKS_LABEL;
	}

	public void setCOMP_PS_REMARKS_LABEL(HtmlOutputLabel comp_ps_remarks_label) {
		COMP_PS_REMARKS_LABEL = comp_ps_remarks_label;
	}

	public HtmlInputText getCOMP_PS_REMARKS() {
		return COMP_PS_REMARKS;
	}

	public void setCOMP_PS_REMARKS(HtmlInputText comp_ps_remarks) {
		COMP_PS_REMARKS = comp_ps_remarks;
	}

	public HtmlOutputLabel getCOMP_UI_M_STAT_DESC_LABEL() {
		return COMP_UI_M_STAT_DESC_LABEL;
	}

	public void setCOMP_UI_M_STAT_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_stat_desc_label) {
		COMP_UI_M_STAT_DESC_LABEL = comp_ui_m_stat_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_STAT_DESC() {
		return COMP_UI_M_STAT_DESC;
	}

	public void setCOMP_UI_M_STAT_DESC(HtmlInputText comp_ui_m_stat_desc) {
		COMP_UI_M_STAT_DESC = comp_ui_m_stat_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_DESC_LABEL() {
		return COMP_UI_M_PC_DESC_LABEL;
	}

	public void setCOMP_UI_M_PC_DESC_LABEL(HtmlOutputLabel comp_ui_m_pc_desc_label) {
		COMP_UI_M_PC_DESC_LABEL = comp_ui_m_pc_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PC_DESC() {
		return COMP_UI_M_PC_DESC;
	}

	public void setCOMP_UI_M_PC_DESC(HtmlInputText comp_ui_m_pc_desc) {
		COMP_UI_M_PC_DESC = comp_ui_m_pc_desc;
	}

	public PT_IL_POLICY_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POLICY_HELPER helper) {
		this.helper = helper;
	}

	public PT_IL_POL_STATUS getPT_IL_POL_STATUS_BEAN() {
		return PT_IL_POL_STATUS_BEAN;
	}

	public void setPT_IL_POL_STATUS_BEAN(PT_IL_POL_STATUS pt_il_pol_status_bean) {
		PT_IL_POL_STATUS_BEAN = pt_il_pol_status_bean;
	}

	

	public List<PT_IL_POL_STATUS> getPhStatusList() {
		return phStatusList;
	}

	public void setPhStatusList(List<PT_IL_POL_STATUS> phStatusList) {
		this.phStatusList = phStatusList;
	}

	public UIDataTable getPhStatusDataTable() {
		return phStatusDataTable;
	}

	public void setPhStatusDataTable(UIDataTable phStatusDataTable) {
		this.phStatusDataTable = phStatusDataTable;
	}

	public PT_IL_SURR_MAT_VALUES getPT_IL_SURR_MAT_VALUES_BEAN() {
		return PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_BEAN(
			PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean) {
		PT_IL_SURR_MAT_VALUES_BEAN = pt_il_surr_mat_values_bean;
	}

	public UIDataTable getPhSurrMatDataTable() {
		return phSurrMatDataTable;
	}

	public void setPhSurrMatDataTable(UIDataTable phSurrMatDataTable) {
		this.phSurrMatDataTable = phSurrMatDataTable;
	}

	public List<PT_IL_SURR_MAT_VALUES> getPhSurrMatList() {
		return phSurrMatList;
	}

	public void setPhSurrMatList(List<PT_IL_SURR_MAT_VALUES> phSurrMatList) {
		this.phSurrMatList = phSurrMatList;
	}

	public PT_IL_POLICY_1 getPT_IL_POLICY_1_BEAN() {
		return PT_IL_POLICY_1_BEAN;
	}

	public void setPT_IL_POLICY_1_BEAN(PT_IL_POLICY_1 pt_il_policy_1_bean) {
		PT_IL_POLICY_1_BEAN = pt_il_policy_1_bean;
	}

	public UIDataTable getPhPolCustDatatable() {
		return phPolCustDatatable;
	}

	public void setPhPolCustDatatable(UIDataTable phPolCustDatatable) {
		this.phPolCustDatatable = phPolCustDatatable;
	}

	public List<PT_IL_POLICY_1> getPhPolCustList() {
		return phPolCustList;
	}

	public void setPhPolCustList(List<PT_IL_POLICY_1> phPolCustList) {
		this.phPolCustList = phPolCustList;
	}

	public HtmlTabPanel getCOMP_TAB_PANEL() {
		return COMP_TAB_PANEL;
	}

	public void setCOMP_TAB_PANEL(HtmlTabPanel comp_tab_panel) {
		COMP_TAB_PANEL = comp_tab_panel;
	}

	
	//added by agalya for ssp call- FALCONQC-1715634 on 25/07/2016
	
		private HtmlOutputLabel COMP_AS_ON_DT_LABEL;

		private HtmlCalendar COMP_AS_ON_DT;
		
		private HtmlOutputLabel COMP_M_UI_LAST_PREM_PAID_DATE_LABEL;

		private HtmlCalendar COMP_M_UI_LAST_PREM_PAID_DATE;
		
		private HtmlOutputLabel COMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL;

		private HtmlCalendar COMP_M_UI_LAST_UNPAID_PREM_DUE_DATE;
		
		private HtmlCommandButton COMP_UI_M_FETCH;
		
		private HtmlOutputLabel COMP_UI_SURR_VALUE_LABEL;
		private HtmlInputText COMP_UI_SURR_VALUE;
		
		private HtmlOutputLabel COMP_TOT_PREM_LOAN_LABEL;
		private HtmlInputText COMP_TOT_PREM_LOAN;
		
		private HtmlOutputLabel COMP_DUE_PREM_INT_LABEL;
		private HtmlInputText COMP_DUE_PREM_INT;
		
		public HtmlOutputLabel getCOMP_TOT_PREM_LOAN_LABEL() {
			return COMP_TOT_PREM_LOAN_LABEL;
		}

		public void setCOMP_TOT_PREM_LOAN_LABEL(HtmlOutputLabel cOMP_TOT_PREM_LOAN_LABEL) {
			COMP_TOT_PREM_LOAN_LABEL = cOMP_TOT_PREM_LOAN_LABEL;
		}

		public HtmlInputText getCOMP_TOT_PREM_LOAN() {
			return COMP_TOT_PREM_LOAN;
		}

		public void setCOMP_TOT_PREM_LOAN(HtmlInputText cOMP_TOT_PREM_LOAN) {
			COMP_TOT_PREM_LOAN = cOMP_TOT_PREM_LOAN;
		}

		public HtmlOutputLabel getCOMP_DUE_PREM_INT_LABEL() {
			return COMP_DUE_PREM_INT_LABEL;
		}

		public void setCOMP_DUE_PREM_INT_LABEL(HtmlOutputLabel cOMP_DUE_PREM_INT_LABEL) {
			COMP_DUE_PREM_INT_LABEL = cOMP_DUE_PREM_INT_LABEL;
		}

		public HtmlInputText getCOMP_DUE_PREM_INT() {
			return COMP_DUE_PREM_INT;
		}

		public void setCOMP_DUE_PREM_INT(HtmlInputText cOMP_DUE_PREM_INT) {
			COMP_DUE_PREM_INT = cOMP_DUE_PREM_INT;
		}

		private HtmlOutputLabel COMP_LOAN_FC_UNPAID_PREM_LABEL;
		private HtmlInputText COMP_LOAN_FC_UNPAID_PREM;
		
		private HtmlOutputLabel COMP_LOAN_FC_UNPAID_PREM_INT_LABEL;
		private HtmlInputText COMP_LOAN_FC_UNPAID_PREM_INT;
		
		private HtmlOutputLabel COMP_LOAN_FC_OS_AMOUNT_LABEL;
		public HtmlOutputLabel getCOMP_UM_EXCESS_DEPOSIT_LABEL() {
			return COMP_UM_EXCESS_DEPOSIT_LABEL;
		}

		public void setCOMP_UM_EXCESS_DEPOSIT_LABEL(
				HtmlOutputLabel cOMP_UM_EXCESS_DEPOSIT_LABEL) {
			COMP_UM_EXCESS_DEPOSIT_LABEL = cOMP_UM_EXCESS_DEPOSIT_LABEL;
		}

		public HtmlInputText getCOMP_UM_EXCESS_DEPOSIT() {
			return COMP_UM_EXCESS_DEPOSIT;
		}

		public void setCOMP_UM_EXCESS_DEPOSIT(HtmlInputText cOMP_UM_EXCESS_DEPOSIT) {
			COMP_UM_EXCESS_DEPOSIT = cOMP_UM_EXCESS_DEPOSIT;
		}

		private HtmlInputText COMP_LOAN_FC_OS_AMOUNT;
		
		private HtmlOutputLabel COMP_UM_EXCESS_DEPOSIT_LABEL;
		private HtmlInputText COMP_UM_EXCESS_DEPOSIT;
		
		private HtmlOutputLabel COMP_EXCESS_DEPOSIT_LABEL;
		private HtmlInputText COMP_EXCESS_DEPOSIT;
				
		public HtmlOutputLabel getCOMP_EXCESS_DEPOSIT_LABEL() {
			return COMP_EXCESS_DEPOSIT_LABEL;
		}

		public void setCOMP_EXCESS_DEPOSIT_LABEL(
				HtmlOutputLabel cOMP_EXCESS_DEPOSIT_LABEL) {
			COMP_EXCESS_DEPOSIT_LABEL = cOMP_EXCESS_DEPOSIT_LABEL;
		}

		public HtmlInputText getCOMP_EXCESS_DEPOSIT() {
			return COMP_EXCESS_DEPOSIT;
		}

		public void setCOMP_EXCESS_DEPOSIT(HtmlInputText cOMP_EXCESS_DEPOSIT) {
			COMP_EXCESS_DEPOSIT = cOMP_EXCESS_DEPOSIT;
		}

		private HtmlOutputLabel COMP_LOAN_FC_OS_LOAN_INT_LABEL;
		public HtmlOutputLabel getCOMP_LOAN_FC_UNPAID_PREM_LABEL() {
			return COMP_LOAN_FC_UNPAID_PREM_LABEL;
		}

		public void setCOMP_LOAN_FC_UNPAID_PREM_LABEL(
				HtmlOutputLabel cOMP_LOAN_FC_UNPAID_PREM_LABEL) {
			COMP_LOAN_FC_UNPAID_PREM_LABEL = cOMP_LOAN_FC_UNPAID_PREM_LABEL;
		}

		public HtmlInputText getCOMP_LOAN_FC_UNPAID_PREM() {
			return COMP_LOAN_FC_UNPAID_PREM;
		}

		public void setCOMP_LOAN_FC_UNPAID_PREM(HtmlInputText cOMP_LOAN_FC_UNPAID_PREM) {
			COMP_LOAN_FC_UNPAID_PREM = cOMP_LOAN_FC_UNPAID_PREM;
		}

		public HtmlOutputLabel getCOMP_LOAN_FC_UNPAID_PREM_INT_LABEL() {
			return COMP_LOAN_FC_UNPAID_PREM_INT_LABEL;
		}

		public void setCOMP_LOAN_FC_UNPAID_PREM_INT_LABEL(
				HtmlOutputLabel cOMP_LOAN_FC_UNPAID_PREM_INT_LABEL) {
			COMP_LOAN_FC_UNPAID_PREM_INT_LABEL = cOMP_LOAN_FC_UNPAID_PREM_INT_LABEL;
		}

		public HtmlInputText getCOMP_LOAN_FC_UNPAID_PREM_INT() {
			return COMP_LOAN_FC_UNPAID_PREM_INT;
		}

		public void setCOMP_LOAN_FC_UNPAID_PREM_INT(
				HtmlInputText cOMP_LOAN_FC_UNPAID_PREM_INT) {
			COMP_LOAN_FC_UNPAID_PREM_INT = cOMP_LOAN_FC_UNPAID_PREM_INT;
		}

		public HtmlOutputLabel getCOMP_LOAN_FC_OS_AMOUNT_LABEL() {
			return COMP_LOAN_FC_OS_AMOUNT_LABEL;
		}

		public void setCOMP_LOAN_FC_OS_AMOUNT_LABEL(
				HtmlOutputLabel cOMP_LOAN_FC_OS_AMOUNT_LABEL) {
			COMP_LOAN_FC_OS_AMOUNT_LABEL = cOMP_LOAN_FC_OS_AMOUNT_LABEL;
		}

		public HtmlInputText getCOMP_LOAN_FC_OS_AMOUNT() {
			return COMP_LOAN_FC_OS_AMOUNT;
		}

		public void setCOMP_LOAN_FC_OS_AMOUNT(HtmlInputText cOMP_LOAN_FC_OS_AMOUNT) {
			COMP_LOAN_FC_OS_AMOUNT = cOMP_LOAN_FC_OS_AMOUNT;
		}

		public HtmlOutputLabel getCOMP_LOAN_FC_OS_LOAN_INT_LABEL() {
			return COMP_LOAN_FC_OS_LOAN_INT_LABEL;
		}

		public void setCOMP_LOAN_FC_OS_LOAN_INT_LABEL(
				HtmlOutputLabel cOMP_LOAN_FC_OS_LOAN_INT_LABEL) {
			COMP_LOAN_FC_OS_LOAN_INT_LABEL = cOMP_LOAN_FC_OS_LOAN_INT_LABEL;
		}

		public HtmlInputText getCOMP_LOAN_FC_OS_LOAN_INT() {
			return COMP_LOAN_FC_OS_LOAN_INT;
		}

		public void setCOMP_LOAN_FC_OS_LOAN_INT(HtmlInputText cOMP_LOAN_FC_OS_LOAN_INT) {
			COMP_LOAN_FC_OS_LOAN_INT = cOMP_LOAN_FC_OS_LOAN_INT;
		}

		private HtmlInputText COMP_LOAN_FC_OS_LOAN_INT;
		
		private HtmlOutputLabel COMP_UI_PAIDUP_VALUE_LABEL;

		public HtmlOutputLabel getCOMP_UI_PAIDUP_VALUE_LABEL() {
			return COMP_UI_PAIDUP_VALUE_LABEL;
		}

		public void setCOMP_UI_PAIDUP_VALUE_LABEL(
				HtmlOutputLabel cOMP_UI_PAIDUP_VALUE_LABEL) {
			COMP_UI_PAIDUP_VALUE_LABEL = cOMP_UI_PAIDUP_VALUE_LABEL;
		}

		

		public HtmlInputText getCOMP_UI_PAIDUP_VALUE() {
			return COMP_UI_PAIDUP_VALUE;
		}

		public void setCOMP_UI_PAIDUP_VALUE(HtmlInputText cOMP_UI_PAIDUP_VALUE) {
			COMP_UI_PAIDUP_VALUE = cOMP_UI_PAIDUP_VALUE;
		}

		private HtmlInputText COMP_UI_PAIDUP_VALUE;
		
		
		//end
		 public void fireFieldValidation(ActionEvent actionEvent) {
				UIInput input = (UIInput) actionEvent.getComponent().getParent();
				ErrorHelpUtil.validate(input, getErrorMap());
			    }

	
	//added by agalya for ssp call- FALCONQC-1715634 on 25/07/2016
	
	public void FETCH_BUTTON_PRESSED() throws Exception {
	
		try {
			int POL_SYS_ID = 0;
			int POL_PERIOD = 0;
			String POL_PLAN_CODE = null;
			Double POL_FC_SUM_ASSURED = 0.0 ;
			String POL_SA_CURR_CODE = null;
			Double LOAN_EXCH_RATE =0.0;
			Double POL_NO_YRS_PREM_PAID=0.0;
			Date POL_START_DT = null ;
			ResultSet resultSet = null;
			CRUDHandler handler = new CRUDHandler();
			Connection connection = null;
			connection = CommonUtils.getConnection();
			System.out.println("PT_IL_POLICY_BEAN.getPOL_NO()    ::"+PT_IL_POLICY_BEAN.getPOL_NO());
			String C1 = "SELECT POL_SYS_ID, POL_PLAN_CODE, POL_PERIOD, POL_NO_YRS_PREM_PAID, POL_FC_SUM_ASSURED,"
              +" POL_START_DT,  POL_SA_CURR_CODE, LOAN_EXCH_RATE  FROM PT_IL_POLICY, PT_IL_LOAN"
              +"  WHERE LOAN_POL_SYS_ID = POL_SYS_ID AND POL_NO = '"+ PT_IL_POLICY_BEAN.getPOL_NO() +"'";
			 resultSet = handler.executeSelectStatement(C1, connection);
			 if(resultSet.next()){
		       POL_SYS_ID=resultSet.getInt(1);
		       POL_PLAN_CODE = resultSet.getString(2);
		       POL_PERIOD = resultSet.getInt(3);
		       POL_NO_YRS_PREM_PAID= resultSet.getDouble(4);
		       POL_FC_SUM_ASSURED = resultSet.getDouble(5);
		       POL_START_DT = resultSet.getDate(6);
		       POL_SA_CURR_CODE = resultSet.getString(7);
		       LOAN_EXCH_RATE =resultSet.getDouble(8);
			 }
			 
			    Date AS_ON_DT=PT_IL_POLICY_BEAN.getAS_ON_DT();
				ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();

				pValOrclList=  helper.CALC_GROSS_SV_AMT_PREM_PAID(String.valueOf(POL_SYS_ID),POL_PLAN_CODE,String.valueOf(POL_PERIOD),String.valueOf(POL_NO_YRS_PREM_PAID),
        		   String.valueOf(POL_FC_SUM_ASSURED),CommonUtils.dateToStringFormatter(POL_START_DT),
        		   POL_SA_CURR_CODE,String.valueOf(LOAN_EXCH_RATE),CommonUtils.dateToStringFormatter(AS_ON_DT) );
				
				if (pValOrclList != null && !pValOrclList.isEmpty()) {
					if (pValOrclList.get(2).getValue() != null) {
						
						PT_IL_POLICY_BEAN.setUI_SURR_VALUE(Double.parseDouble(pValOrclList.get(2).getValue()));
						System.out.println("PT_IL_POLICY_BEAN.getUI_SURR_VALUE          :"+PT_IL_POLICY_BEAN.getUI_SURR_VALUE());
						
					}
				}
				
				/*for paidup*/
				
				ArrayList<OracleParameter> pValOrclList1 = new ArrayList<OracleParameter>();

				pValOrclList1=  helper.CALC_GROSS_SV_AMT_PREM_PAID1(String.valueOf(POL_SYS_ID),POL_PLAN_CODE,String.valueOf(POL_PERIOD),String.valueOf(POL_NO_YRS_PREM_PAID),
        		   String.valueOf(POL_FC_SUM_ASSURED),CommonUtils.dateToStringFormatter(POL_START_DT),
        		   POL_SA_CURR_CODE,String.valueOf(LOAN_EXCH_RATE),CommonUtils.dateToStringFormatter(AS_ON_DT) );
				
				if (pValOrclList1 != null && !pValOrclList1.isEmpty()) {
					if (pValOrclList1.get(2).getValue() != null) {
						//CommonUtils.objectSysout(pValOrclList1);
						PT_IL_POLICY_BEAN.setUI_PAIDUP_VALUE(Double.parseDouble(pValOrclList1.get(2).getValue()));
						System.out.println("PT_IL_POLICY_BEAN.getUI_PAIDUP_VALUE         :"+PT_IL_POLICY_BEAN.getUI_PAIDUP_VALUE());
						
					}
				}
			
				COMP_UI_SURR_VALUE.resetValue();
				COMP_UI_PAIDUP_VALUE.resetValue();
				
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		
	}

	public HtmlOutputLabel getCOMP_AS_ON_DT_LABEL() {
		return COMP_AS_ON_DT_LABEL;
	}

	public void setCOMP_AS_ON_DT_LABEL(HtmlOutputLabel cOMP_AS_ON_DT_LABEL) {
		COMP_AS_ON_DT_LABEL = cOMP_AS_ON_DT_LABEL;
	}

	public HtmlCalendar getCOMP_AS_ON_DT() {
		return COMP_AS_ON_DT;
	}

	public void setCOMP_AS_ON_DT(HtmlCalendar cOMP_AS_ON_DT) {
		COMP_AS_ON_DT = cOMP_AS_ON_DT;
	}

	public HtmlOutputLabel getCOMP_M_UI_LAST_PREM_PAID_DATE_LABEL() {
		return COMP_M_UI_LAST_PREM_PAID_DATE_LABEL;
	}

	public void setCOMP_M_UI_LAST_PREM_PAID_DATE_LABEL(
			HtmlOutputLabel cOMP_M_UI_LAST_PREM_PAID_DATE_LABEL) {
		COMP_M_UI_LAST_PREM_PAID_DATE_LABEL = cOMP_M_UI_LAST_PREM_PAID_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_M_UI_LAST_PREM_PAID_DATE() {
		return COMP_M_UI_LAST_PREM_PAID_DATE;
	}

	public void setCOMP_M_UI_LAST_PREM_PAID_DATE(
			HtmlCalendar cOMP_M_UI_LAST_PREM_PAID_DATE) {
		COMP_M_UI_LAST_PREM_PAID_DATE = cOMP_M_UI_LAST_PREM_PAID_DATE;
	}

	public HtmlOutputLabel getCOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL() {
		return COMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL;
	}

	public void setCOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL(
			HtmlOutputLabel cOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL) {
		COMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL = cOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE() {
		return COMP_M_UI_LAST_UNPAID_PREM_DUE_DATE;
	}

	public void setCOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE(
			HtmlCalendar cOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE) {
		COMP_M_UI_LAST_UNPAID_PREM_DUE_DATE = cOMP_M_UI_LAST_UNPAID_PREM_DUE_DATE;
	}

	public HtmlCommandButton getCOMP_UI_M_FETCH() {
		return COMP_UI_M_FETCH;
	}

	public void setCOMP_UI_M_FETCH(HtmlCommandButton cOMP_UI_M_FETCH) {
		COMP_UI_M_FETCH = cOMP_UI_M_FETCH;
	}

	public HtmlOutputLabel getCOMP_UI_SURR_VALUE_LABEL() {
		return COMP_UI_SURR_VALUE_LABEL;
	}

	public void setCOMP_UI_SURR_VALUE_LABEL(HtmlOutputLabel cOMP_UI_SURR_VALUE_LABEL) {
		COMP_UI_SURR_VALUE_LABEL = cOMP_UI_SURR_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_SURR_VALUE() {
		return COMP_UI_SURR_VALUE;
	}

	public void setCOMP_UI_SURR_VALUE(HtmlInputText cOMP_UI_SURR_VALUE) {
		COMP_UI_SURR_VALUE = cOMP_UI_SURR_VALUE;
	}
	
	
	public void validateAS_ON_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException{
		System.out.println("inside as on date validator");

		try {
			
			PT_IL_POLICY_BEAN.setAS_ON_DT((Date) value);

			System.out.println("ISSUE DATE  :"+PT_IL_POLICY_BEAN.getAS_ON_DT());
			/*ADDED BY GOPI FOR QUOTATION LETTER GENERATE ON 30/05/17*/
			String Pol_no=PT_IL_POLICY_BEAN.getPOL_NO();
			Date As_on_date=PT_IL_POLICY_BEAN.getAS_ON_DT();
			String type_of_Quotation=PT_IL_POLICY_BEAN.getUI_M_QUOT_TYPE();
			/*SURRENDER_VALIDATION(Pol_no,As_on_date,type_of_Quotation);*/
			ArrayList<OracleParameter> outputList = SURRENDER_VALIDATION(Pol_no,As_on_date,type_of_Quotation);
			if(outputList!=null && outputList.get(0).getValueObject()!=null){
				throw new Exception(outputList.get(0).getValueObject().toString());
			}
			COMP_UI_M_QUOT_TYPE.resetValue();
			COMP_UI_M_QUOT_TYPE.setDisabled(false);
		    /*end*/
		
			
		} catch (Exception e) {
			/*ADDED BY GOPI FOR QUOTATION LETTER GENERATE ON 30/05/17*/
			if(PT_IL_POLICY_BEAN.getUI_M_QUOT_TYPE().equalsIgnoreCase("S")){
			PT_IL_POLICY_BEAN.setUI_M_QUOT_TYPE("P");
			COMP_UI_M_QUOT_TYPE.resetValue();
			COMP_UI_M_QUOT_TYPE.setDisabled(true);
			//end
			e.printStackTrace();
			
			
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("key", e.getMessage());
			
			
		}
			throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
	//end
	}
/*ADDED BY GOPI FOR QUOTATION LETTER GENERATE ON 30/05/17*/
	
	public ArrayList<OracleParameter>SURRENDER_VALIDATION(String Pol_no,Object As_on_date,String type_of_Quotation )
			throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			//IN params
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, Pol_no);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, As_on_date);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, type_of_Quotation);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_SCH_REPORTS.P_SURRENDER_VALIDATION");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new Exception(e.getMessage());
		}
		return outputList;
	}
	/*end*/
	
	/*Added by Ameen on 03-07-2018 for KIC as per Ajay sugg.*/
	private String filterByPOLH_N_END_DT;

	public String getFilterByPOLH_N_END_DT() {
		return filterByPOLH_N_END_DT;
	}

	public void setFilterByPOLH_N_END_DT(String filterByPOLH_N_END_DT) {
		this.filterByPOLH_N_END_DT = filterByPOLH_N_END_DT;
	}
	
	/*end*/
	

	
}
