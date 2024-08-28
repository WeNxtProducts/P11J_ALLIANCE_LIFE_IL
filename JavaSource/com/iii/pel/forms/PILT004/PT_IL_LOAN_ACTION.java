package com.iii.pel.forms.PILT004;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.common.dms.DMSUtil;
import com.iii.pel.forms.PILT005.LoanRepaymentSearchPageAction;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_LOAN_ACTION extends CommonReportAction/*CommonAction*/ {

	private String lovQuery_LoanCode = "select PC_CODE,PC_DESC from pm_codes where pc_type = 'IL_LOAN_CODE' and  NVL(PC_FRZ_FLAG,'N') = 'N'";
	private String descQuery_LoanCode = "select PC_CODE,PC_DESC from pm_codes where pc_type = 'IL_LOAN_CODE' and  NVL(PC_FRZ_FLAG,'N') = 'N' and PC_CODE=?";
	private String lovQuery_Polno = "select POL_NO,TO_CHAR(POL_ISSUE_DT) as ISSUE_DT   from PT_IL_POLICY where NVL(POL_STATUS,'N') IN ('A', 'E','R')AND NVL(POL_NO_YRS_PREM_PAID,0) >= (SELECT PLAN_SURR_YRS FROM PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE)AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' and rownum <20";

	String currentMode = null;
	double P_FC_95_VALUE = 0.0;
	double P_LC_95_VALUE = 0.0;
	double P_LOAN_EXCH_RATE = 0.0;
	String M_POL_DIVN_CODE = null;
	Date M_POL_START_DT = null;
	String M_POL_CLASS_CODE = null;
	String M_POL_PLAN_CODE = null;
	int M_POL_UW_YEAR = 0;
	Double M_NO_YRS_PREM_PAID = 0.0;
	String M_POL_STATUS = null;
	String M_POL_SA_CURR_CODE = null;
	String M_POL_PROD_CODE = null;
	Long POL_SYS_ID = null;
	String statusValue = "";

	private HtmlOutputText COMP_STATUS;

	private HtmlOutputText COMP_LOAN_STATUS;

	Hashtable<String, String> PILT004_DUMMY_BEAN = new Hashtable<String, String>();

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_UI_M_LOAN_STATUS;

	private HtmlOutputLabel COMP_LOAN_UNPAID_PREM_INT_CODE_LABEL;

	private HtmlInputText COMP_LOAN_UNPAID_PREM_INT_CODE;

	private HtmlOutputLabel COMP_LOAN_CODE_LABEL;

	private HtmlInputText COMP_LOAN_CODE;

	private HtmlOutputLabel COMP_LOAN_POL_NO_LABEL;

	private HtmlInputText COMP_LOAN_POL_NO;

	private HtmlOutputLabel COMP_LOAN_DT_LABEL;

	private HtmlCalendar COMP_LOAN_DT;

	private HtmlOutputLabel COMP_LOAN_SURR_PERC_LABEL;

	private HtmlInputText COMP_LOAN_SURR_PERC;

	private HtmlOutputLabel COMP_LOAN_REF_NO_LABEL;

	private HtmlInputText COMP_LOAN_REF_NO;

	private HtmlOutputLabel COMP_LOAN_FC_PERM_AMT_LABEL;

	private HtmlInputText COMP_LOAN_FC_PERM_AMT;

	private HtmlOutputLabel COMP_LOAN_FC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_FC_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_REPAY_FREQ_LABEL;

	private HtmlSelectOneMenu COMP_LOAN_REPAY_FREQ;

	private HtmlOutputLabel COMP_LOAN_DUE_DT_LABEL;

	private HtmlCalendar COMP_LOAN_DUE_DT;

	private HtmlOutputLabel COMP_LOAN_INT_RATE_LABEL;

	private HtmlInputText COMP_LOAN_INT_RATE;

	private HtmlOutputLabel COMP_LOAN_TERM_LABEL;

	private HtmlInputText COMP_LOAN_TERM;

	private HtmlOutputLabel COMP_LOAN_FC_INTEREST_LABEL;

	private HtmlInputText COMP_LOAN_FC_INTEREST;

	private HtmlOutputLabel COMP_UI_M_LOAN_FC_CHARGE_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_FC_CHARGE;

	private HtmlOutputLabel COMP_UI_M_LOAN_GR_FC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_GR_FC_AMT;

	private HtmlOutputLabel COMP_LOAN_FC_UNPAID_PREM_LABEL;

	private HtmlInputText COMP_LOAN_FC_UNPAID_PREM;

	private HtmlOutputLabel COMP_LOAN_FC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_LOAN_FC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_LOAN_FC_OS_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_FC_OS_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_FC_OS_LOAN_INT_LABEL;

	private HtmlInputText COMP_LOAN_FC_OS_LOAN_INT;

	private HtmlOutputLabel COMP_LOAN_FC_NET_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_FC_NET_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_FC_REPAY_AMT_LABEL;

	private HtmlInputText COMP_LOAN_FC_REPAY_AMT;

	private HtmlOutputLabel COMP_UI_M_LOAN_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_CODE_DESC;

	private HtmlOutputLabel COMP_LOAN_LC_PERM_AMT_LABEL;

	private HtmlInputText COMP_LOAN_LC_PERM_AMT;

	private HtmlOutputLabel COMP_LOAN_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_LC_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_INT_RATE_PER_LABEL;

	private HtmlInputText COMP_LOAN_INT_RATE_PER;

	private HtmlOutputLabel COMP_LOAN_LC_INTEREST_LABEL;

	private HtmlInputText COMP_LOAN_LC_INTEREST;

	private HtmlOutputLabel COMP_UI_M_LOAN_LC_CHARGE_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_LC_CHARGE;

	private HtmlOutputLabel COMP_UI_M_LOAN_GR_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_GR_LC_AMT;

	private HtmlOutputLabel COMP_LOAN_LC_UNPAID_PREM_LABEL;

	private HtmlInputText COMP_LOAN_LC_UNPAID_PREM;

	private HtmlOutputLabel COMP_LOAN_LC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_LOAN_LC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_LOAN_LC_OS_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_LC_OS_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_LC_OS_LOAN_INT_LABEL;

	private HtmlInputText COMP_LOAN_LC_OS_LOAN_INT;

	private HtmlOutputLabel COMP_LOAN_LC_NET_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAN_LC_NET_AMOUNT;

	private HtmlOutputLabel COMP_LOAN_LC_REPAY_AMT_LABEL;

	private HtmlInputText COMP_LOAN_LC_REPAY_AMT;

	private HtmlOutputLabel COMP_LOAN_CURR_CODE_LABEL;

	private HtmlInputText COMP_LOAN_CURR_CODE;

	private HtmlOutputLabel COMP_LOAN_EXCH_RATE_LABEL;

	private HtmlInputText COMP_LOAN_EXCH_RATE;

	private HtmlCommandButton COMP_UI_M_LOAN_LOV_BUTTON;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_INT_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_RECAL;

	private HtmlCommandButton COMP_UI_M_BUT_CHARGE;

	private HtmlCommandButton COMP_UI_M_BUT_REPAYMENT;

	private HtmlCommandButton COMP_UI_M_BUT_APPRV;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO;

	private HtmlCommandButton PREFORMBUTTON;

	private PT_IL_LOAN PT_IL_LOAN_BEAN;

	private boolean componentDisableStatus = false;

	private List<SelectItem> repaymentComboList = new ArrayList<SelectItem>();

	Long LOAN_SYS_ID = null;

	private boolean compLoanCodeDisabled;

	private boolean compLoanPolNoDisabled;

	private boolean compLoanDateDisabled;

	private boolean compLoanCurrCodeDisabled;

	private boolean compLoanExchRateDisabled;

	private boolean compLoanSurrPercDisabled;

	private boolean compLoanRefNoDisabled;

	private boolean compLoanFcAmountDisabled;

	private boolean compLoanLcAmountDisabled;

	private boolean compLoanRepayFreqDisabled;

	private boolean compLoanDueDtDisabled;

	private boolean compLoanIntRateDisabled;

	private boolean compLoanIntRatePerDisabled;

	private boolean compLoanFcInterestDisabled;

	private boolean compLoanLcInterestDisabled;

	private boolean compUiMLoanFcChargeDisabled;

	private boolean compUiMLoanLcChargeDisabled;

	private boolean compUiMLoanGrFcAmtDisabled;

	private boolean compUiMLoanGrLcAmtDisabled;

	private boolean compLoanFcUnpaidPremDisabled;

	private boolean compLoanLcUnpaidPremDisabled;

	private boolean compLoanUnpaidPremIntCodeDisabled;

	private boolean compLoanFcUnpaidPremIntDisabled;

	private boolean compLoanLcUnpaidPremIntDisabled;

	private boolean compLoanFcOsAmountDisabled;

	private boolean compLoanLcOsAmountDisabled;

	private boolean compLoanFcOsLoanIntDisabled;

	private boolean compLoanLcOsLoanIntDisabled;

	private boolean compLoanFcNetAmountDisabled;

	private boolean compLoanLcNetAmountDisabled;

	private boolean compLoanFcRepayAmtDisabled;

	private boolean compLoanLcRepayAmtDisabled;

	private boolean compLoanFcRepaidAmtDisabled;

	private boolean compLoanLcRepaidAmtDisabled;

	// private boolean compLoanStatusReadOnly;

	// private boolean compLoanSysIdReadOnly;

	// private boolean compUiMNoYrsPremPaidReadOnly;

	// private boolean comLoanPolSysIdReadOnly;

	// private boolean compLoanCrDtReadOnly;

	// private boolean compLoanCrUidReadOnly;

	// private boolean compLoanUpdDtReadOnly;

	// private boolean compLoanUpdUidReadOnly;

	private boolean compLoanLcPermAmtDisabled;

	private boolean compLoanFcPermAmtDisabled;

	private boolean compUiMLoanCodeDescDisabled;

	private boolean compUiMButRecalDisabled;

	private boolean compUiMButRepaymentDisabled;

	// private boolean compLoanExchRateDisabled;

	private boolean blockDeleteAllowed;

	private boolean compUiMButApprvDisabled;

	private boolean compApprStatusRendered;

	private boolean LOANSTATUS;
	// newly added
	private HtmlSelectOneMenu COMP_TYPE;
	private HtmlInputText COMP_MICR_CODE;
	private HtmlInputText COMP_ACC_NO;
	private HtmlOutputLabel COMP_TYPE_LABEL;
	private HtmlOutputLabel COMP_MICR_CODE_LABEL;
	private HtmlOutputLabel COMP_ACC_NO_LABEL;
	private HtmlAjaxCommandButton COMP_EFT_BUT;
	private List<SelectItem> listLOAN_FLEX_04 = new ArrayList<SelectItem>();

	public HtmlAjaxCommandButton getCOMP_EFT_BUT() {
		return COMP_EFT_BUT;
	}

	public void setCOMP_EFT_BUT(HtmlAjaxCommandButton comp_eft_but) {
		COMP_EFT_BUT = comp_eft_but;
	}

	public boolean isLOANSTATUS() {
		return LOANSTATUS;
	}

	public void setLOANSTATUS(boolean loanstatus) {
		LOANSTATUS = loanstatus;
	}

	public boolean isCompUiMButApprvDisabled() {
		return compUiMButApprvDisabled;
	}

	public void setCompUiMButApprvDisabled(boolean compUiMButApprvDisabled) {
		this.compUiMButApprvDisabled = compUiMButApprvDisabled;
	}
//added by gopinath on 31-03-16	for loan review sheet
	
private PRINT_ACTION PRINT_ACTION_BEAN;
	

	public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}
	
	
	
	
	public List<SelectItem> getRepaymentComboList() {
		if (repaymentComboList.size() == 0) {
			repaymentComboList.clear();
			/*
			 * FacesContext fc = FacesContext.getCurrentInstance();
			 * ServletContext context = (ServletContext) fc.getExternalContext()
			 * .getContext(); SimpleConnectionAgent connectionAgent =
			 * (SimpleConnectionAgent) context .getAttribute("connectionAgent");
			 * Connection con;
			 */
			try {
				// con = connectionAgent.getConnection("123");
				Connection con = CommonUtils.getConnection();
				repaymentComboList = ListItemUtil.getDropDownListValue(con,
						"PILT004", "PT_IL_LOAN", "PT_IL_LOAN.LOAN_REPAY_FREQ",
						"IL_LNREP_TYP");
			} catch (Exception e) {
				System.out.println("PT_IL_LOAN_ACTION.getRepaymentComboList()"
						+ "ERrror");
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
		return repaymentComboList;
	}

	public void setRepaymentComboList(List<SelectItem> repaymentComboList) {
		this.repaymentComboList = repaymentComboList;
	}

	//Added By Dhinesh 6.6.2016 -add new field in Loan Frequency in 
	
	private HtmlOutputLabel COMP_LOAN_FREQ_TYPE_LABEL;
	
	
	public HtmlOutputLabel getCOMP_LOAN_FREQ_TYPE_LABEL() {
		return COMP_LOAN_FREQ_TYPE_LABEL;
	}
	public void setCOMP_LOAN_FREQ_TYPE_LABEL(
			HtmlOutputLabel cOMP_LOAN_FREQ_TYPE_LABEL) {
		COMP_LOAN_FREQ_TYPE_LABEL = cOMP_LOAN_FREQ_TYPE_LABEL;
	}
	

	private HtmlSelectOneMenu COMP_LOAN_FREQ_TYPE;
	
	public HtmlSelectOneMenu getCOMP_LOAN_FREQ_TYPE() {
		return COMP_LOAN_FREQ_TYPE;
	}

	public void setCOMP_LOAN_FREQ_TYPE(HtmlSelectOneMenu cOMP_LOAN_FREQ_TYPE) {
		COMP_LOAN_FREQ_TYPE = cOMP_LOAN_FREQ_TYPE;
	}
	
	
	
	
	public void LOAN_FREQ_TYPE_Validation(FacesContext context,
			UIComponent component, Object value) {
		System.out.println("****************** Enter the Loan Disbrsle *******************");
		
		getPT_IL_LOAN_BEAN().setLOAN_FREQ_TYPE((String) value);
		COMP_LOAN_FREQ_TYPE.resetValue();
	
		System.out.println("getPT_IL_LOAN_BEAN().getLOAN_FREQ_TYPE Value    : "+ getPT_IL_LOAN_BEAN().getLOAN_FREQ_TYPE());
	
	}
	private List<SelectItem> frequencyComboList = new ArrayList<SelectItem>();
	
	

	public List<SelectItem> getFrequencyComboList() {
		
		
	/*frequencyComboList=frequencyList();
	
		*/
		return frequencyComboList;
	}

	public void setFrequencyComboList(List<SelectItem> frequencyComboList) {
		this.frequencyComboList = frequencyComboList;
	}
	
	
	
	/*ArrayList<lovbean>  frequencyList =new ArrayList<LovBean>();*/
	
	
	
	
	
	
	
	
	public List<LovBean> frequencyList()
			throws Exception {


		System.out.println("*************  Enter the loadediscloaddatatable ************** ");
		List<LovBean> lovbean_List = new ArrayList<LovBean>();

		String selectStatement = "SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM='IL_REPM_TYP' ";
		Connection connection = null;
		ResultSet rs = null;
		String param_Value="IL_REPM_TYP";
		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {param_Value});


			while (rs.next())
			{
				LovBean lov = new LovBean();
				lov.setLovCode(rs.getString("LIV_CODE"));
				lov.setLovName(rs.getString("LIV_CODE_DESC"));
				lovbean_List.add(lov);
			}

		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		return lovbean_List;

	}

	/*End*/
	
	

	


	public PT_IL_LOAN_ACTION() throws Exception {
		PT_IL_LOAN_BEAN = new PT_IL_LOAN();
		PRINT_ACTION_BEAN = new PRINT_ACTION();//  ADDED BY GOPI
		
		PRINT_ACTION_BEAN.compositeAction=this;//ADDED BY GOPI
		instantiateAllComponent();
		getFrequencyComboList();
		setListItemValues();
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_STATUS() {
		return COMP_UI_M_LOAN_STATUS;
	}

	public void setCOMP_UI_M_LOAN_STATUS(HtmlOutputLabel COMP_UI_M_LOAN_STATUS) {
		this.COMP_UI_M_LOAN_STATUS = COMP_UI_M_LOAN_STATUS;
	}

	public HtmlOutputLabel getCOMP_LOAN_UNPAID_PREM_INT_CODE_LABEL() {
		return COMP_LOAN_UNPAID_PREM_INT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_UNPAID_PREM_INT_CODE() {
		return COMP_LOAN_UNPAID_PREM_INT_CODE;
	}

	public void setCOMP_LOAN_UNPAID_PREM_INT_CODE_LABEL(
			HtmlOutputLabel COMP_LOAN_UNPAID_PREM_INT_CODE_LABEL) {
		this.COMP_LOAN_UNPAID_PREM_INT_CODE_LABEL = COMP_LOAN_UNPAID_PREM_INT_CODE_LABEL;
	}

	public void setCOMP_LOAN_UNPAID_PREM_INT_CODE(
			HtmlInputText COMP_LOAN_UNPAID_PREM_INT_CODE) {
		this.COMP_LOAN_UNPAID_PREM_INT_CODE = COMP_LOAN_UNPAID_PREM_INT_CODE;
	}

	public HtmlOutputLabel getCOMP_LOAN_CODE_LABEL() {
		return COMP_LOAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_CODE() {
		return COMP_LOAN_CODE;
	}

	public void setCOMP_LOAN_CODE_LABEL(HtmlOutputLabel COMP_LOAN_CODE_LABEL) {
		this.COMP_LOAN_CODE_LABEL = COMP_LOAN_CODE_LABEL;
	}

	public void setCOMP_LOAN_CODE(HtmlInputText COMP_LOAN_CODE) {
		this.COMP_LOAN_CODE = COMP_LOAN_CODE;
	}

	public HtmlOutputLabel getCOMP_LOAN_POL_NO_LABEL() {
		return COMP_LOAN_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_POL_NO() {
		return COMP_LOAN_POL_NO;
	}

	public void setCOMP_LOAN_POL_NO_LABEL(HtmlOutputLabel COMP_LOAN_POL_NO_LABEL) {
		this.COMP_LOAN_POL_NO_LABEL = COMP_LOAN_POL_NO_LABEL;
	}

	public void setCOMP_LOAN_POL_NO(HtmlInputText COMP_LOAN_POL_NO) {
		this.COMP_LOAN_POL_NO = COMP_LOAN_POL_NO;
	}

	public HtmlOutputLabel getCOMP_LOAN_DT_LABEL() {
		return COMP_LOAN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LOAN_DT() {
		return COMP_LOAN_DT;
	}

	public void setCOMP_LOAN_DT_LABEL(HtmlOutputLabel COMP_LOAN_DT_LABEL) {
		this.COMP_LOAN_DT_LABEL = COMP_LOAN_DT_LABEL;
	}

	public void setCOMP_LOAN_DT(HtmlCalendar COMP_LOAN_DT) {
		this.COMP_LOAN_DT = COMP_LOAN_DT;
	}

	public HtmlOutputLabel getCOMP_LOAN_SURR_PERC_LABEL() {
		return COMP_LOAN_SURR_PERC_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_SURR_PERC() {
		return COMP_LOAN_SURR_PERC;
	}

	public void setCOMP_LOAN_SURR_PERC_LABEL(
			HtmlOutputLabel COMP_LOAN_SURR_PERC_LABEL) {
		this.COMP_LOAN_SURR_PERC_LABEL = COMP_LOAN_SURR_PERC_LABEL;
	}

	public void setCOMP_LOAN_SURR_PERC(HtmlInputText COMP_LOAN_SURR_PERC) {
		this.COMP_LOAN_SURR_PERC = COMP_LOAN_SURR_PERC;
	}

	public HtmlOutputLabel getCOMP_LOAN_REF_NO_LABEL() {
		return COMP_LOAN_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_REF_NO() {
		return COMP_LOAN_REF_NO;
	}

	public void setCOMP_LOAN_REF_NO_LABEL(HtmlOutputLabel COMP_LOAN_REF_NO_LABEL) {
		this.COMP_LOAN_REF_NO_LABEL = COMP_LOAN_REF_NO_LABEL;
	}

	public void setCOMP_LOAN_REF_NO(HtmlInputText COMP_LOAN_REF_NO) {
		this.COMP_LOAN_REF_NO = COMP_LOAN_REF_NO;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_PERM_AMT_LABEL() {
		return COMP_LOAN_FC_PERM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_PERM_AMT() {
		return COMP_LOAN_FC_PERM_AMT;
	}

	public void setCOMP_LOAN_FC_PERM_AMT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_PERM_AMT_LABEL) {
		this.COMP_LOAN_FC_PERM_AMT_LABEL = COMP_LOAN_FC_PERM_AMT_LABEL;
	}

	public void setCOMP_LOAN_FC_PERM_AMT(HtmlInputText COMP_LOAN_FC_PERM_AMT) {
		this.COMP_LOAN_FC_PERM_AMT = COMP_LOAN_FC_PERM_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_AMOUNT_LABEL() {
		return COMP_LOAN_FC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_AMOUNT() {
		return COMP_LOAN_FC_AMOUNT;
	}

	public void setCOMP_LOAN_FC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_AMOUNT_LABEL) {
		this.COMP_LOAN_FC_AMOUNT_LABEL = COMP_LOAN_FC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_FC_AMOUNT(HtmlInputText COMP_LOAN_FC_AMOUNT) {
		this.COMP_LOAN_FC_AMOUNT = COMP_LOAN_FC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_REPAY_FREQ_LABEL() {
		return COMP_LOAN_REPAY_FREQ_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_LOAN_REPAY_FREQ() {
		return COMP_LOAN_REPAY_FREQ;
	}

	public void setCOMP_LOAN_REPAY_FREQ_LABEL(
			HtmlOutputLabel COMP_LOAN_REPAY_FREQ_LABEL) {
		this.COMP_LOAN_REPAY_FREQ_LABEL = COMP_LOAN_REPAY_FREQ_LABEL;
	}

	public void setCOMP_LOAN_REPAY_FREQ(HtmlSelectOneMenu COMP_LOAN_REPAY_FREQ) {
		this.COMP_LOAN_REPAY_FREQ = COMP_LOAN_REPAY_FREQ;
	}

	public HtmlOutputLabel getCOMP_LOAN_DUE_DT_LABEL() {
		return COMP_LOAN_DUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LOAN_DUE_DT() {
		return COMP_LOAN_DUE_DT;
	}

	public void setCOMP_LOAN_DUE_DT_LABEL(HtmlOutputLabel COMP_LOAN_DUE_DT_LABEL) {
		this.COMP_LOAN_DUE_DT_LABEL = COMP_LOAN_DUE_DT_LABEL;
	}

	public void setCOMP_LOAN_DUE_DT(HtmlCalendar COMP_LOAN_DUE_DT) {
		this.COMP_LOAN_DUE_DT = COMP_LOAN_DUE_DT;
	}

	public HtmlOutputLabel getCOMP_LOAN_INT_RATE_LABEL() {
		return COMP_LOAN_INT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_INT_RATE() {
		return COMP_LOAN_INT_RATE;
	}

	public void setCOMP_LOAN_INT_RATE_LABEL(
			HtmlOutputLabel COMP_LOAN_INT_RATE_LABEL) {
		this.COMP_LOAN_INT_RATE_LABEL = COMP_LOAN_INT_RATE_LABEL;
	}

	public void setCOMP_LOAN_INT_RATE(HtmlInputText COMP_LOAN_INT_RATE) {
		this.COMP_LOAN_INT_RATE = COMP_LOAN_INT_RATE;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_INTEREST_LABEL() {
		return COMP_LOAN_FC_INTEREST_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_INTEREST() {
		return COMP_LOAN_FC_INTEREST;
	}

	public void setCOMP_LOAN_FC_INTEREST_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_INTEREST_LABEL) {
		this.COMP_LOAN_FC_INTEREST_LABEL = COMP_LOAN_FC_INTEREST_LABEL;
	}

	public void setCOMP_LOAN_FC_INTEREST(HtmlInputText COMP_LOAN_FC_INTEREST) {
		this.COMP_LOAN_FC_INTEREST = COMP_LOAN_FC_INTEREST;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_FC_CHARGE_LABEL() {
		return COMP_UI_M_LOAN_FC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_FC_CHARGE() {
		return COMP_UI_M_LOAN_FC_CHARGE;
	}

	public void setCOMP_UI_M_LOAN_FC_CHARGE_LABEL(
			HtmlOutputLabel COMP_UI_M_LOAN_FC_CHARGE_LABEL) {
		this.COMP_UI_M_LOAN_FC_CHARGE_LABEL = COMP_UI_M_LOAN_FC_CHARGE_LABEL;
	}

	public void setCOMP_UI_M_LOAN_FC_CHARGE(
			HtmlInputText COMP_UI_M_LOAN_FC_CHARGE) {
		this.COMP_UI_M_LOAN_FC_CHARGE = COMP_UI_M_LOAN_FC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_GR_FC_AMT_LABEL() {
		return COMP_UI_M_LOAN_GR_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_GR_FC_AMT() {
		return COMP_UI_M_LOAN_GR_FC_AMT;
	}

	public void setCOMP_UI_M_LOAN_GR_FC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_LOAN_GR_FC_AMT_LABEL) {
		this.COMP_UI_M_LOAN_GR_FC_AMT_LABEL = COMP_UI_M_LOAN_GR_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_GR_FC_AMT(
			HtmlInputText COMP_UI_M_LOAN_GR_FC_AMT) {
		this.COMP_UI_M_LOAN_GR_FC_AMT = COMP_UI_M_LOAN_GR_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_UNPAID_PREM_LABEL() {
		return COMP_LOAN_FC_UNPAID_PREM_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_UNPAID_PREM() {
		return COMP_LOAN_FC_UNPAID_PREM;
	}

	public void setCOMP_LOAN_FC_UNPAID_PREM_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_UNPAID_PREM_LABEL) {
		this.COMP_LOAN_FC_UNPAID_PREM_LABEL = COMP_LOAN_FC_UNPAID_PREM_LABEL;
	}

	public void setCOMP_LOAN_FC_UNPAID_PREM(
			HtmlInputText COMP_LOAN_FC_UNPAID_PREM) {
		this.COMP_LOAN_FC_UNPAID_PREM = COMP_LOAN_FC_UNPAID_PREM;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_UNPAID_PREM_INT_LABEL() {
		return COMP_LOAN_FC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_UNPAID_PREM_INT() {
		return COMP_LOAN_FC_UNPAID_PREM_INT;
	}

	public void setCOMP_LOAN_FC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_UNPAID_PREM_INT_LABEL) {
		this.COMP_LOAN_FC_UNPAID_PREM_INT_LABEL = COMP_LOAN_FC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_LOAN_FC_UNPAID_PREM_INT(
			HtmlInputText COMP_LOAN_FC_UNPAID_PREM_INT) {
		this.COMP_LOAN_FC_UNPAID_PREM_INT = COMP_LOAN_FC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_OS_AMOUNT_LABEL() {
		return COMP_LOAN_FC_OS_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_OS_AMOUNT() {
		return COMP_LOAN_FC_OS_AMOUNT;
	}

	public void setCOMP_LOAN_FC_OS_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_OS_AMOUNT_LABEL) {
		this.COMP_LOAN_FC_OS_AMOUNT_LABEL = COMP_LOAN_FC_OS_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_FC_OS_AMOUNT(HtmlInputText COMP_LOAN_FC_OS_AMOUNT) {
		this.COMP_LOAN_FC_OS_AMOUNT = COMP_LOAN_FC_OS_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_OS_LOAN_INT_LABEL() {
		return COMP_LOAN_FC_OS_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_OS_LOAN_INT() {
		return COMP_LOAN_FC_OS_LOAN_INT;
	}

	public void setCOMP_LOAN_FC_OS_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_OS_LOAN_INT_LABEL) {
		this.COMP_LOAN_FC_OS_LOAN_INT_LABEL = COMP_LOAN_FC_OS_LOAN_INT_LABEL;
	}

	public void setCOMP_LOAN_FC_OS_LOAN_INT(
			HtmlInputText COMP_LOAN_FC_OS_LOAN_INT) {
		this.COMP_LOAN_FC_OS_LOAN_INT = COMP_LOAN_FC_OS_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_NET_AMOUNT_LABEL() {
		return COMP_LOAN_FC_NET_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_NET_AMOUNT() {
		return COMP_LOAN_FC_NET_AMOUNT;
	}

	public void setCOMP_LOAN_FC_NET_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_NET_AMOUNT_LABEL) {
		this.COMP_LOAN_FC_NET_AMOUNT_LABEL = COMP_LOAN_FC_NET_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_FC_NET_AMOUNT(HtmlInputText COMP_LOAN_FC_NET_AMOUNT) {
		this.COMP_LOAN_FC_NET_AMOUNT = COMP_LOAN_FC_NET_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_FC_REPAY_AMT_LABEL() {
		return COMP_LOAN_FC_REPAY_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_FC_REPAY_AMT() {
		return COMP_LOAN_FC_REPAY_AMT;
	}

	public void setCOMP_LOAN_FC_REPAY_AMT_LABEL(
			HtmlOutputLabel COMP_LOAN_FC_REPAY_AMT_LABEL) {
		this.COMP_LOAN_FC_REPAY_AMT_LABEL = COMP_LOAN_FC_REPAY_AMT_LABEL;
	}

	public void setCOMP_LOAN_FC_REPAY_AMT(HtmlInputText COMP_LOAN_FC_REPAY_AMT) {
		this.COMP_LOAN_FC_REPAY_AMT = COMP_LOAN_FC_REPAY_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_CODE_DESC_LABEL() {
		return COMP_UI_M_LOAN_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_CODE_DESC() {
		return COMP_UI_M_LOAN_CODE_DESC;
	}

	public void setCOMP_UI_M_LOAN_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_LOAN_CODE_DESC_LABEL) {
		this.COMP_UI_M_LOAN_CODE_DESC_LABEL = COMP_UI_M_LOAN_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_LOAN_CODE_DESC(
			HtmlInputText COMP_UI_M_LOAN_CODE_DESC) {
		this.COMP_UI_M_LOAN_CODE_DESC = COMP_UI_M_LOAN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_PERM_AMT_LABEL() {
		return COMP_LOAN_LC_PERM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_PERM_AMT() {
		return COMP_LOAN_LC_PERM_AMT;
	}

	public void setCOMP_LOAN_LC_PERM_AMT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_PERM_AMT_LABEL) {
		this.COMP_LOAN_LC_PERM_AMT_LABEL = COMP_LOAN_LC_PERM_AMT_LABEL;
	}

	public void setCOMP_LOAN_LC_PERM_AMT(HtmlInputText COMP_LOAN_LC_PERM_AMT) {
		this.COMP_LOAN_LC_PERM_AMT = COMP_LOAN_LC_PERM_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_AMOUNT_LABEL() {
		return COMP_LOAN_LC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_AMOUNT() {
		return COMP_LOAN_LC_AMOUNT;
	}

	public void setCOMP_LOAN_LC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_AMOUNT_LABEL) {
		this.COMP_LOAN_LC_AMOUNT_LABEL = COMP_LOAN_LC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_LC_AMOUNT(HtmlInputText COMP_LOAN_LC_AMOUNT) {
		this.COMP_LOAN_LC_AMOUNT = COMP_LOAN_LC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_INT_RATE_PER_LABEL() {
		return COMP_LOAN_INT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_INT_RATE_PER() {
		return COMP_LOAN_INT_RATE_PER;
	}

	public void setCOMP_LOAN_INT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_LOAN_INT_RATE_PER_LABEL) {
		this.COMP_LOAN_INT_RATE_PER_LABEL = COMP_LOAN_INT_RATE_PER_LABEL;
	}

	public void setCOMP_LOAN_INT_RATE_PER(HtmlInputText COMP_LOAN_INT_RATE_PER) {
		this.COMP_LOAN_INT_RATE_PER = COMP_LOAN_INT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_INTEREST_LABEL() {
		return COMP_LOAN_LC_INTEREST_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_INTEREST() {
		return COMP_LOAN_LC_INTEREST;
	}

	public void setCOMP_LOAN_LC_INTEREST_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_INTEREST_LABEL) {
		this.COMP_LOAN_LC_INTEREST_LABEL = COMP_LOAN_LC_INTEREST_LABEL;
	}

	public void setCOMP_LOAN_LC_INTEREST(HtmlInputText COMP_LOAN_LC_INTEREST) {
		this.COMP_LOAN_LC_INTEREST = COMP_LOAN_LC_INTEREST;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_LC_CHARGE_LABEL() {
		return COMP_UI_M_LOAN_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_LC_CHARGE() {
		return COMP_UI_M_LOAN_LC_CHARGE;
	}

	public void setCOMP_UI_M_LOAN_LC_CHARGE_LABEL(
			HtmlOutputLabel COMP_UI_M_LOAN_LC_CHARGE_LABEL) {
		this.COMP_UI_M_LOAN_LC_CHARGE_LABEL = COMP_UI_M_LOAN_LC_CHARGE_LABEL;
	}

	public void setCOMP_UI_M_LOAN_LC_CHARGE(
			HtmlInputText COMP_UI_M_LOAN_LC_CHARGE) {
		this.COMP_UI_M_LOAN_LC_CHARGE = COMP_UI_M_LOAN_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_GR_LC_AMT_LABEL() {
		return COMP_UI_M_LOAN_GR_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_GR_LC_AMT() {
		return COMP_UI_M_LOAN_GR_LC_AMT;
	}

	public void setCOMP_UI_M_LOAN_GR_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_LOAN_GR_LC_AMT_LABEL) {
		this.COMP_UI_M_LOAN_GR_LC_AMT_LABEL = COMP_UI_M_LOAN_GR_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_GR_LC_AMT(
			HtmlInputText COMP_UI_M_LOAN_GR_LC_AMT) {
		this.COMP_UI_M_LOAN_GR_LC_AMT = COMP_UI_M_LOAN_GR_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_UNPAID_PREM_LABEL() {
		return COMP_LOAN_LC_UNPAID_PREM_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_UNPAID_PREM() {
		return COMP_LOAN_LC_UNPAID_PREM;
	}

	public void setCOMP_LOAN_LC_UNPAID_PREM_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_UNPAID_PREM_LABEL) {
		this.COMP_LOAN_LC_UNPAID_PREM_LABEL = COMP_LOAN_LC_UNPAID_PREM_LABEL;
	}

	public void setCOMP_LOAN_LC_UNPAID_PREM(
			HtmlInputText COMP_LOAN_LC_UNPAID_PREM) {
		this.COMP_LOAN_LC_UNPAID_PREM = COMP_LOAN_LC_UNPAID_PREM;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_UNPAID_PREM_INT_LABEL() {
		return COMP_LOAN_LC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_UNPAID_PREM_INT() {
		return COMP_LOAN_LC_UNPAID_PREM_INT;
	}

	public void setCOMP_LOAN_LC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_UNPAID_PREM_INT_LABEL) {
		this.COMP_LOAN_LC_UNPAID_PREM_INT_LABEL = COMP_LOAN_LC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_LOAN_LC_UNPAID_PREM_INT(
			HtmlInputText COMP_LOAN_LC_UNPAID_PREM_INT) {
		this.COMP_LOAN_LC_UNPAID_PREM_INT = COMP_LOAN_LC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_OS_AMOUNT_LABEL() {
		return COMP_LOAN_LC_OS_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_OS_AMOUNT() {
		return COMP_LOAN_LC_OS_AMOUNT;
	}

	public void setCOMP_LOAN_LC_OS_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_OS_AMOUNT_LABEL) {
		this.COMP_LOAN_LC_OS_AMOUNT_LABEL = COMP_LOAN_LC_OS_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_LC_OS_AMOUNT(HtmlInputText COMP_LOAN_LC_OS_AMOUNT) {
		this.COMP_LOAN_LC_OS_AMOUNT = COMP_LOAN_LC_OS_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_OS_LOAN_INT_LABEL() {
		return COMP_LOAN_LC_OS_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_OS_LOAN_INT() {
		return COMP_LOAN_LC_OS_LOAN_INT;
	}

	public void setCOMP_LOAN_LC_OS_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_OS_LOAN_INT_LABEL) {
		this.COMP_LOAN_LC_OS_LOAN_INT_LABEL = COMP_LOAN_LC_OS_LOAN_INT_LABEL;
	}

	public void setCOMP_LOAN_LC_OS_LOAN_INT(
			HtmlInputText COMP_LOAN_LC_OS_LOAN_INT) {
		this.COMP_LOAN_LC_OS_LOAN_INT = COMP_LOAN_LC_OS_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_NET_AMOUNT_LABEL() {
		return COMP_LOAN_LC_NET_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_NET_AMOUNT() {
		return COMP_LOAN_LC_NET_AMOUNT;
	}

	public void setCOMP_LOAN_LC_NET_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_NET_AMOUNT_LABEL) {
		this.COMP_LOAN_LC_NET_AMOUNT_LABEL = COMP_LOAN_LC_NET_AMOUNT_LABEL;
	}

	public void setCOMP_LOAN_LC_NET_AMOUNT(HtmlInputText COMP_LOAN_LC_NET_AMOUNT) {
		this.COMP_LOAN_LC_NET_AMOUNT = COMP_LOAN_LC_NET_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAN_LC_REPAY_AMT_LABEL() {
		return COMP_LOAN_LC_REPAY_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_LC_REPAY_AMT() {
		return COMP_LOAN_LC_REPAY_AMT;
	}

	public void setCOMP_LOAN_LC_REPAY_AMT_LABEL(
			HtmlOutputLabel COMP_LOAN_LC_REPAY_AMT_LABEL) {
		this.COMP_LOAN_LC_REPAY_AMT_LABEL = COMP_LOAN_LC_REPAY_AMT_LABEL;
	}

	public void setCOMP_LOAN_LC_REPAY_AMT(HtmlInputText COMP_LOAN_LC_REPAY_AMT) {
		this.COMP_LOAN_LC_REPAY_AMT = COMP_LOAN_LC_REPAY_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAN_CURR_CODE_LABEL() {
		return COMP_LOAN_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_CURR_CODE() {
		return COMP_LOAN_CURR_CODE;
	}

	public void setCOMP_LOAN_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_LOAN_CURR_CODE_LABEL) {
		this.COMP_LOAN_CURR_CODE_LABEL = COMP_LOAN_CURR_CODE_LABEL;
	}

	public void setCOMP_LOAN_CURR_CODE(HtmlInputText COMP_LOAN_CURR_CODE) {
		this.COMP_LOAN_CURR_CODE = COMP_LOAN_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_LOAN_EXCH_RATE_LABEL() {
		return COMP_LOAN_EXCH_RATE_LABEL;
	}

	public HtmlInputText getCOMP_LOAN_EXCH_RATE() {
		return COMP_LOAN_EXCH_RATE;
	}

	public void setCOMP_LOAN_EXCH_RATE_LABEL(
			HtmlOutputLabel COMP_LOAN_EXCH_RATE_LABEL) {
		this.COMP_LOAN_EXCH_RATE_LABEL = COMP_LOAN_EXCH_RATE_LABEL;
	}

	public void setCOMP_LOAN_EXCH_RATE(HtmlInputText COMP_LOAN_EXCH_RATE) {
		this.COMP_LOAN_EXCH_RATE = COMP_LOAN_EXCH_RATE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOAN_LOV_BUTTON() {
		return COMP_UI_M_LOAN_LOV_BUTTON;
	}

	public void setCOMP_UI_M_LOAN_LOV_BUTTON(
			HtmlCommandButton COMP_UI_M_LOAN_LOV_BUTTON) {
		this.COMP_UI_M_LOAN_LOV_BUTTON = COMP_UI_M_LOAN_LOV_BUTTON;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_INT_CODE() {
		return COMP_UI_M_BUT_LOV_INT_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_INT_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_INT_CODE) {
		this.COMP_UI_M_BUT_LOV_INT_CODE = COMP_UI_M_BUT_LOV_INT_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RECAL() {
		return COMP_UI_M_BUT_RECAL;
	}

	public void setCOMP_UI_M_BUT_RECAL(HtmlCommandButton COMP_UI_M_BUT_RECAL) {
		this.COMP_UI_M_BUT_RECAL = COMP_UI_M_BUT_RECAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHARGE() {
		return COMP_UI_M_BUT_CHARGE;
	}

	public void setCOMP_UI_M_BUT_CHARGE(HtmlCommandButton COMP_UI_M_BUT_CHARGE) {
		this.COMP_UI_M_BUT_CHARGE = COMP_UI_M_BUT_CHARGE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REPAYMENT() {
		return COMP_UI_M_BUT_REPAYMENT;
	}

	public void setCOMP_UI_M_BUT_REPAYMENT(
			HtmlCommandButton COMP_UI_M_BUT_REPAYMENT) {
		this.COMP_UI_M_BUT_REPAYMENT = COMP_UI_M_BUT_REPAYMENT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPRV() {
		return COMP_UI_M_BUT_APPRV;
	}

	public void setCOMP_UI_M_BUT_APPRV(HtmlCommandButton COMP_UI_M_BUT_APPRV) {
		this.COMP_UI_M_BUT_APPRV = COMP_UI_M_BUT_APPRV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO() {
		return COMP_UI_M_BUT_LOV_POL_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO) {
		this.COMP_UI_M_BUT_LOV_POL_NO = COMP_UI_M_BUT_LOV_POL_NO;
	}

	public PT_IL_LOAN getPT_IL_LOAN_BEAN() {
		return PT_IL_LOAN_BEAN;
	}

	public void setPT_IL_LOAN_BEAN(PT_IL_LOAN PT_IL_LOAN_BEAN) {
		this.PT_IL_LOAN_BEAN = PT_IL_LOAN_BEAN;
	}

	public void LOAN_CODE_Validator(FacesContext context,
			UIComponent component, Object value) {
		String loanCodeValue = (String) value;
		try {
			getPT_IL_LOAN_BEAN().setLOAN_CODE(loanCodeValue);

			ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
			OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
					"IL_LOAN_CODE");
			pList1.add(p1);
			OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN",
					loanCodeValue);
			pList1.add(p2);
			OracleParameter p3 = null;
			if (getPT_IL_LOAN_BEAN().getUI_M_LOAN_CODE_DESC() == null) {
				p3 = new OracleParameter("IN3", "STRING", "IN OUT", "");
				System.out.println("The loan desc is null");
			} else {
				p3 = new OracleParameter("IN3", "STRING", "IN OUT",
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CODE_DESC());
			}
			pList1.add(p3);
			OracleParameter p4 = new OracleParameter("IN4", "STRING", "IN", "N");
			pList1.add(p4);
			OracleParameter p5 = new OracleParameter("IN5", "STRING", "IN", "E");
			pList1.add(p5);
			OracleParameter p6 = new OracleParameter("IN6", "STRING", "IN", "");
			pList1.add(p6);
			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
			ArrayList<OracleParameter> oList1 = pHandler1.execute(pList1,
					CommonUtils.getConnection(), "P_VAL_CODES");

			getPT_IL_LOAN_BEAN().setUI_M_LOAN_CODE_DESC(
					((OracleParameter) oList1.get(0)).getValue());
		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

		/*
		 * finally{ try {
		 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
		 * FacesContext.getCurrentInstance(),
		 * getCOMP_LOAN_CODE().getClientId(FacesContext.getCurrentInstance()),
		 * getErrorMap(), getWarningMap()); } catch (DBException e) {
		 *//**
			 * [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 details error message
			 * removed.
			 */
		/*
		 * getErrorMap().put("current", e.getMessage());
		 *//** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
		/*
		 * e.printStackTrace(); } }
		 */
	}

	/*
	 * public void LOAN_POLNO_Validator(ActionEvent event){ int LOAN_SYS_ID1 =
	 * 0; int LOAN_POL_SYS_ID1 = 0;
	 * 
	 * Connection conn = null; UIInput input = (UIInput)
	 * event.getComponent().getParent(); // Ajax4jsf
	 * ErrorHelpUtil.validate(input, getErrorMap());
	 * 
	 * String POL_NO=""; try { conn = CommonUtils.getConnection();
	 * 
	 * String POLNO = (String) input.getValue(); System.out.println("Policy
	 * Number=" + POLNO);
	 * 
	 * PT_IL_LOAN_BEAN.setLOAN_POL_NO(POLNO);
	 * 
	 * String query1 = "SELECT LOAN_SYS_ID,LOAN_POL_SYS_ID FROM PT_IL_LOAN where
	 * LOAN_SYS_ID in(select LOAND_LOAN_SYS_ID from PT_IL_LOAN_DTL) and
	 * LOAN_POL_NO = ?"; PreparedStatement psmt = conn.prepareStatement(query1);
	 * psmt.setString(1,POL_NO); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ LOAN_SYS_ID1= rs.getInt(1); LOAN_POL_SYS_ID1 =
	 * rs.getInt(2); } rs.close();
	 * 
	 * FacesContext context = FacesContext.getCurrentInstance(); Map<String,
	 * Object> sessionMap = context.getExternalContext().getSessionMap();
	 * PT_IL_LOAN_ACTION actionBean = (PT_IL_LOAN_ACTION)
	 * sessionMap.get("PILT004_PT_IL_LOAN_ACTION"); PT_IL_LOAN valueBean =
	 * actionBean.getPT_IL_LOAN_BEAN(); System.out.println("From loan screen");
	 * System.out.println("LOAN_SYS_ID1" + LOAN_SYS_ID1);
	 * System.out.println("LOAN_POL_SYS_ID1" + LOAN_POL_SYS_ID1);
	 * 
	 * 
	 * if(LOAN_SYS_ID1>0){ valueBean.setLOAN_SYS_ID(LOAN_SYS_ID1); }
	 * if(LOAN_POL_SYS_ID1>0){ valueBean.setLOAN_POL_SYS_ID(LOAN_POL_SYS_ID1); }
	 * 
	 * 
	 * ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();
	 * OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",POLNO);
	 * pList1.add(p1); OracleParameter p3 = new OracleParameter("IN2", "STRING",
	 * "OUT",""); pList1.add(p3); OracleProcedureHandler pHandler1 = new
	 * OracleProcedureHandler(); oList1 = pHandler1.execute(pList1,
	 * CommonUtils.getConnection(),"P9ILPK_LOAN.VALID_POL_NO"); for (Iterator
	 * iterator2 = oList1.iterator(); iterator2.hasNext();) { OracleParameter
	 * name = (OracleParameter) iterator2.next();
	 * if(name.getFieldName().equals("IN2")){ System.out.println("output" +
	 * name.getValue()); } } COMP_LOAN_DT.setSubmittedValue(new Date());
	 * PT_IL_LOAN_BEAN.setLOAN_DT(new Date());
	 * 
	 * }catch(Exception ex){ } finally{
	 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(conn,
	 * FacesContext.getCurrentInstance(),
	 * input.getClientId(FacesContext.getCurrentInstance()), getErrorMap(),
	 * getWarningMap()); } //WhenValidateItem_PT_IL_LOAN_LOAN_DT(); }
	 */

	/*
	 * public void LOAN_POLNO_Validator(ActionEvent event){ UIInput input =
	 * (UIInput) event.getComponent().getParent(); // Ajax4jsf comp
	 * ErrorHelpUtil.validate(input, input.getId(), getErrorMap()); }
	 * 
	 * public void validator_LOAN_POLNO(FacesContext context, UIComponent
	 * component, Object value) throws ValidatorException{
	 * if(getCOMP_LOAN_POL_NO().getSubmittedValue() != null){ Date
	 * M_POL_EXPIRY_DT = null;
	 * 
	 * String queryCur1 = "SELECT POL_EXPIRY_DT FROM PT_IL_POLICY WHERE POL_NO =
	 * ?"; Object[] cursorC1Values =
	 * {getCOMP_LOAN_POL_NO().getSubmittedValue()}; ResultSet rsCursor1 = null;
	 * try{
	 * getPT_IL_LOAN_BEAN().setLOAN_POL_NO(getCOMP_LOAN_POL_NO().getSubmittedValue());
	 * rsCursor1 = getHandler().executeSelectStatement(queryCur1,
	 * CommonUtils.getConnection(),cursorC1Values); while(rsCursor1.next()){
	 * M_POL_EXPIRY_DT = rsCursor1.getDate("POL_EXPIRY_DT"); }
	 * System.out.println("The current date : "+(new Date()));
	 * System.out.println("The M_POL_EXPIRY_DT: "+M_POL_EXPIRY_DT);
	 * 
	 * if(M_POL_EXPIRY_DT != null){ if((new Date()).after(M_POL_EXPIRY_DT)){ //
	 * getErrorMap().put("current", arg1) throw new
	 * ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
	 * "92032")); } } ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
	 * OracleParameter param11 = new
	 * OracleParameter("in1","STRING","IN",getCOMP_LOAN_POL_NO().getSubmittedValue());
	 * OracleParameter param21 = new OracleParameter("out1","STRING","OUT","");
	 * paramList1.add(param11); paramList1.add(param21); OracleProcedureHandler
	 * procHandler1 = new OracleProcedureHandler(); ArrayList listValidPolCheck =
	 * procHandler1.execute(paramList1, CommonUtils.getConnection(),
	 * "P9ILPK_LOAN.VALID_POL_NO"); if(((OracleParameter)
	 * listValidPolCheck.get(0)).getValue() != null){
	 * getPT_IL_LOAN_BEAN().setUI_M_SURR_YRS(Double.parseDouble(((OracleParameter)
	 * listValidPolCheck.get(0)).getValue())); } }catch(ValidatorException ve){
	 * throw ve; }catch(Exception e){ e.printStackTrace(); }finally{ try {
	 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
	 * FacesContext.getCurrentInstance(),
	 * getCOMP_LOAN_POL_NO().getClientId(FacesContext.getCurrentInstance()),
	 * getErrorMap(), getWarningMap()); CommonUtils.closeCursor(rsCursor1);
	 * }catch(DBException dbe){ getErrorMap().put("current", dbe.getMessage());
	 * getErrorMap().put("detail", dbe.getMessage()); dbe.printStackTrace();
	 * }catch (Exception e) { e.printStackTrace(); } } } }
	 */

	public void LOAN_POLNO_Validator(FacesContext context,
			UIComponent component, Object objValue) {
		Date M_POL_EXPIRY_DT = null;
		ResultSet rsCursor1 = null;
		ResultSet rsCursor2 = null;
		String value = (String) objValue;
		String queryCur1 = "SELECT POL_EXPIRY_DT FROM PT_IL_POLICY WHERE POL_NO = ?";
		String queryCur2 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ? AND POL_ADDL_STATUS IN ('L01','L02')";
		Object[] cursorC1Values = { value };
		String addlStatus = null;

		// added by Akash to stop validation on quered record

		if (!value.equals(PT_IL_LOAN_BEAN.getLOAN_POL_NO())) {
			PT_IL_LOAN_BEAN.setLOAN_POL_NO(value);
			try {
				String message = null;
				rsCursor1 = getHandler().executeSelectStatement(queryCur1,
						CommonUtils.getConnection(), cursorC1Values);
				while (rsCursor1.next()) {
					M_POL_EXPIRY_DT = rsCursor1.getDate("POL_EXPIRY_DT");
				}

				if (M_POL_EXPIRY_DT != null) {
					if ((new CommonUtils().getCurrentDate())
							.after(M_POL_EXPIRY_DT)) {

						throw new Exception("Policy is Expired.");
					}
				}
				/*added by  dhinesh for SSP call id FALCONQC-1714734*/
				select_surr_per();
				COMP_LOAN_SURR_PERC.resetValue();
				/*End*/
				ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
				OracleParameter param11 = new OracleParameter("in1", "STRING",
						"IN", CommonUtils.getProcedureValue(value));
				OracleParameter param21 = new OracleParameter("out1", "STRING",
						"OUT", "");
				paramList1.add(param11);
				paramList1.add(param21);
				OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
				ArrayList listValidPolCheck = procHandler1
						.execute(paramList1, CommonUtils.getConnection(),
								"P9ILPK_LOAN.VALID_POL_NO");
				if (((OracleParameter) listValidPolCheck.get(0)).getValue() != null) {
					getPT_IL_LOAN_BEAN()
							.setUI_M_SURR_YRS(
									Double
											.parseDouble(((OracleParameter) listValidPolCheck
													.get(0)).getValue()));
				}
				// checking additional status of policy

				rsCursor2 = getHandler().executeSelectStatement(queryCur2,
						CommonUtils.getConnection(), cursorC1Values);
				if (rsCursor2.next()) {
					getWarningMap().put("current", "policy is pre-lapsed");
				}

			} catch (SQLException exc) {
				exc.printStackTrace();
				try {
					ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
							.getConnection(),
							FacesContext.getCurrentInstance(), "PT_IL_LOAN",
							this.getWarningMap());
				} catch (ValidatorException vexc) {
					vexc.printStackTrace();
					getErrorMap().put("current",
							vexc.getFacesMessage().getSummary());
					throw new ValidatorException(new FacesMessage(vexc
							.getMessage()));
				} catch (DBException e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} finally {
				try {
					CommonUtils.closeCursor(rsCursor1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * public void LOAN_DT_Validator(ActionEvent event){ Connection conn= null;
	 * System.out.println("PT_IL_LOAN_ACTION.LOAN_DT_Validator()"); UIInput
	 * input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
	 * ErrorHelpUtil.validate(input, getErrorMap()); Date loanDate = null;
	 * 
	 * 
	 * try{ conn = CommonUtils.getConnection(); loanDate = (Date)
	 * input.getValue(); Calendar calendar = Calendar.getInstance();
	 * calendar.setTime(loanDate); calendar.add(Calendar.DAY_OF_MONTH,
	 * (364/2)-1); Date loanRepayDate = calendar.getTime();
	 * 
	 * COMP_LOAN_DUE_DT.setSubmittedValue(getAddedDate(loanDate,6));
	 * PT_IL_LOAN_BEAN.setLOAN_DUE_DT(getAddedDate(loanDate,6));
	 * WhenValidateItem_PT_IL_LOAN_LOAN_DT(loanDate); }catch(Exception
	 * ex){ex.printStackTrace();}
	 * 
	 * 
	 * finally{ ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(conn,
	 * FacesContext.getCurrentInstance(),
	 * input.getClientId(FacesContext.getCurrentInstance()), getErrorMap(),
	 * getWarningMap()); } }
	 */

	/*
	 * public void LoanDtWhenValidate(ActionEvent event){ UIInput input =
	 * (UIInput) event.getComponent().getParent(); // Ajax4jsf
	 * if("".equals(getCOMP_LOAN_DT().getSubmittedValue().trim())){
	 * System.out.println("The date is null "+
	 * getCOMP_LOAN_DT().getSubmittedValue());
	 * getCOMP_LOAN_DT().setSubmittedValue(new Date()); }
	 * getPT_IL_LOAN_BEAN().setLOAN_DT(((UICalendar)getCOMP_LOAN_DT()).getAsDate(getCOMP_LOAN_DT().getSubmittedValue())); }
	 */

	public void LoanDtWhenValidate(FacesContext context, UIComponent component,
			Object value) throws Exception {
		Date tempLoanDt = (Date) value;
		getPT_IL_LOAN_BEAN().setLOAN_DT(tempLoanDt);
		// added by akash to stop validation on quered record

		// if (getCOMP_LOAN_DT().getSubmittedValue() != null) {
		Date M_POL_START_DT = null;

		String M_POL_PLAN_CODE = "", M_POL_DIVN_CODE = "", M_POL_CLASS_CODE = "", M_POL_PROD_CODE = "";
		Double M_POL_PREM_PAID = 0.0, M_LOAN_INT_RATE = 0.0;
		Integer M_POL_UW_YEAR = 0;
		String queryCursor0 = "SELECT NVL(PLAN_SURR_YRS, 0) FROM PM_IL_PLAN WHERE PLAN_CODE = ?";

		String queryCursor1 = "SELECT POL_DIVN_CODE, POL_START_DT, POL_CLASS_CODE, POL_PLAN_CODE, POL_UW_YEAR, "
				+ "POL_NO_YRS_PREM_PAID, POL_STATUS,POL_SA_CURR_CODE,POL_PROD_CODE FROM PT_IL_POLICY "
				+ "WHERE  POL_NO = ?";

		Object[] cursorC1Values = { getPT_IL_LOAN_BEAN().getLOAN_POL_NO() };

		String queryCursor2 = "SELECT ABS((MONTHS_BETWEEN(M_POL_START_DT,?)/ 12)) FROM DUAL";
		Object[] cursorC2Values = { tempLoanDt };
		ResultSet rsCursor1 = null, rsCursor0 = null;
		try {

			ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
			OracleParameter p11 = new OracleParameter("IN1", "STRING", "IN",
					CommonUtils.dateToStringFormatter(tempLoanDt));
			pList1.add(p11);
			OracleParameter p22 = new OracleParameter("IN2", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getLOAN_POL_NO() + "");
			pList1.add(p22);
			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
			ArrayList<OracleParameter> oList1 = pHandler1.execute(pList1,
					CommonUtils.getConnection(), "P9ILPK_LOAN.LOAN_DATE_CHECK");

			LD_SA_CURR_EXCHANGE_RATE(getPT_IL_LOAN_BEAN().getLOAN_POL_NO(),
					tempLoanDt);
			rsCursor1 = getHandler().executeSelectStatement(queryCursor1,
					CommonUtils.getConnection(), cursorC1Values);
			while (rsCursor1.next()) {
				M_POL_DIVN_CODE = rsCursor1.getString("POL_STATUS");
				M_POL_START_DT = rsCursor1.getDate("POL_START_DT");
				M_POL_CLASS_CODE = rsCursor1.getString("POL_CLASS_CODE");
				M_POL_PLAN_CODE = rsCursor1.getString("POL_PLAN_CODE");
				M_POL_UW_YEAR = rsCursor1.getInt("POL_UW_YEAR");
				getPT_IL_LOAN_BEAN().setUI_M_NO_YRS_PREM_PAID(
						rsCursor1.getDouble("POL_NO_YRS_PREM_PAID"));

				getPT_IL_LOAN_BEAN().setUI_M_POL_STATUS(
						rsCursor1.getString("POL_STATUS"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_SA_CURR_CODE(
						rsCursor1.getString("POL_SA_CURR_CODE"));
				M_POL_PROD_CODE = rsCursor1.getString("POL_PROD_CODE");
			}

			Object[] cursorC0Values = { M_POL_PLAN_CODE };
			rsCursor0 = getHandler().executeSelectStatement(queryCursor0,
					CommonUtils.getConnection(), cursorC0Values);
			while (rsCursor0.next()) {
				getPT_IL_LOAN_BEAN().setUI_M_SURR_YRS(rsCursor0.getDouble(1));
			}

			if (getPT_IL_LOAN_BEAN().getUI_M_SURR_YRS() != null) {
				if (MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
						.getUI_M_NO_YRS_PREM_PAID(), 0.0) < getPT_IL_LOAN_BEAN()
						.getUI_M_SURR_YRS()) {

					getErrorMap().put(
							"current",
							Messages.getString(
									PELConstants.pelErrorMessagePath, "92032"));
					/** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
				}

			}

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getLOAN_POL_NO());
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					CommonUtils.dateToStringFormatter(tempLoanDt));
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					String.valueOf(getPT_IL_LOAN_BEAN().getLOAN_SURR_PERC()));

			if (getPT_IL_LOAN_BEAN().getUI_M_NO_YRS_PREM_PAID() == null) {
				getPT_IL_LOAN_BEAN().setUI_M_NO_YRS_PREM_PAID(0.0);
			}
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					String.valueOf(getPT_IL_LOAN_BEAN()
							.getUI_M_NO_YRS_PREM_PAID()));
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					PT_IL_LOAN_BEAN.getLOAN_CURR_CODE());
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					String.valueOf(getPT_IL_LOAN_BEAN().getLOAN_SURR_PERC()));
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					String.valueOf(getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE()));
			OracleParameter param8 = new OracleParameter("OUT1", "STRING",
					"OUT", "");
			OracleParameter param9 = new OracleParameter("OUT2", "STRING",
					"OUT", "");
			OracleParameter param10 = new OracleParameter("OUT3", "STRING",
					"OUT", "");
			OracleParameter param11 = new OracleParameter("OUT4", "STRING",
					"OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);
			paramList.add(param7);
			paramList.add(param8);
			paramList.add(param9);
			paramList.add(param10);
			paramList.add(param11);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList = procHandler.execute(
					paramList, CommonUtils.getConnection(),
					"P9ILPK_LOAN.SV_CALCULATION");
			getPT_IL_LOAN_BEAN().setUI_M_FC_95_VALUE(
					Double.parseDouble(((OracleParameter) outputList.get(0))
							.getValue()));
			getPT_IL_LOAN_BEAN().setUI_M_LC_95_VALUE(
					Double.parseDouble(((OracleParameter) outputList.get(1))
							.getValue()));

			getPT_IL_LOAN_BEAN().setLOAN_FC_PERM_AMT(
					Double.parseDouble(((OracleParameter) outputList.get(2))
							.getValue()));
			// COMMENTED TEMPORARY

			/*
			 * getCOMP_LOAN_FC_PERM_AMT().setSubmittedValue( ((OracleParameter)
			 * outputList.get(2)).getValue());
			 */

			getPT_IL_LOAN_BEAN().setLOAN_LC_PERM_AMT(
					Double.parseDouble(((OracleParameter) outputList.get(3))
							.getValue()));
			// COMMENTED TEMPORARY

			/*
			 * getCOMP_LOAN_LC_PERM_AMT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList.get(3)).getValue()));
			 */
			
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_FC_PERM_AMT           "+getPT_IL_LOAN_BEAN().getLOAN_FC_PERM_AMT());
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_LC_PERM_AMT           "+getPT_IL_LOAN_BEAN().getLOAN_LC_PERM_AMT());
			
			COMP_LOAN_FC_PERM_AMT.resetValue();
			COMP_LOAN_LC_PERM_AMT.resetValue();
		
			if ("P".equalsIgnoreCase(getPT_IL_LOAN_BEAN().getUI_M_POL_STATUS())
					|| "Y".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_PREM_WAIVE_YN())) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM(0.0);
				// COMMENTED TEMPORARY
				/* getCOMP_LOAN_FC_UNPAID_PREM().setSubmittedValue(0.0); */

				getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM(0.0);
				// COMMENTED TEMPORARY
				/* getCOMP_LOAN_LC_UNPAID_PREM().setSubmittedValue(0.0); */
			}

			ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
			OracleParameter param12 = new OracleParameter("IN1", "STRING",
					"IN", String.valueOf(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SYS_ID()));
			OracleParameter param22 = new OracleParameter("IN2", "STRING",
					"IN", CommonUtils.dateToStringFormatter(tempLoanDt));
			paramList1.add(param12);
			paramList1.add(param22);
			OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList1 = procHandler1.execute(
					paramList1, CommonUtils.getConnection(),
					"P9ILPK_LOAN.INSERT_PREM_COLL_RECORDS");

			ArrayList<OracleParameter> paramList3 = new ArrayList<OracleParameter>();
			OracleParameter param13 = new OracleParameter("IN1", "STRING",
					"IN", CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SYS_ID()));
			OracleParameter param23 = new OracleParameter("IN2", "STRING",
					"IN", "");
			OracleParameter param33 = new OracleParameter("IN3", "STRING",
					"IN", CommonUtils.dateToStringFormatter(tempLoanDt));
			OracleParameter param43 = new OracleParameter("OUT1", "STRING",
					"OUT", "");
			OracleParameter param53 = new OracleParameter("OUT2", "STRING",
					"OUT", "");
			OracleParameter param63 = new OracleParameter("OUT3", "STRING",
					"OUT", "");
			OracleParameter param73 = new OracleParameter("OUT4", "STRING",
					"OUT", "");
			paramList3.add(param13);
			paramList3.add(param23);
			paramList3.add(param33);
			paramList3.add(param43);
			paramList3.add(param53);
			paramList3.add(param63);
			paramList3.add(param73);
			OracleProcedureHandler procHandler3 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList3 = procHandler3.execute(
					paramList3, CommonUtils.getConnection(),
					"P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");

			
			System.out.println("Dhinesh ************* P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT  Procedure Call ************");
			System.out.println("((OracleParameter) outputList3.get(0)).getValue()    : "+((OracleParameter) outputList3.get(0)).getValue());
			System.out.println("((OracleParameter) outputList3.get(1)).getValue()    : "+((OracleParameter) outputList3.get(1)).getValue());
			if (((OracleParameter) outputList3.get(0)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM(
						Double.parseDouble(((OracleParameter) outputList3
								.get(0)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM(0.0);
			}
			// COMMENTED TEMPORARY
			/*
			 * getCOMP_LOAN_FC_UNPAID_PREM().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList3.get(0)).getValue()));
			 */

			if (((OracleParameter) outputList3.get(1)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM(
						Double.parseDouble(((OracleParameter) outputList3
								.get(1)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM(0.0);
			}
			// COMMENTED TEMPORARY
			/*
			 * getCOMP_LOAN_LC_UNPAID_PREM().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList3.get(1)).getValue()));
			 */
			System.out.println("#################### Dhinesh ######################");
			System.out.println("((OracleParameter) outputList3.get(2)).getValue()    : "+((OracleParameter) outputList3.get(2)).getValue());
			System.out.println("((OracleParameter) outputList3.get(3)).getValue()    : "+((OracleParameter) outputList3.get(3)).getValue());
			System.out.println("#################### End ######################");
			
			if (((OracleParameter) outputList3.get(2)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM_INT(
						Double.parseDouble(((OracleParameter) outputList3
								.get(2)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM_INT(0.0);
			}
			// COMMENTED TEMPORARY

			/*
			 * getCOMP_LOAN_FC_UNPAID_PREM_INT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList3.get(2)).getValue()));
			 */

			if (((OracleParameter) outputList3.get(3)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM_INT(
						Double.parseDouble(((OracleParameter) outputList3
								.get(3)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM_INT(0.0);
			}

			// COMMENTED TEMPORARY

			/*
			 * getCOMP_LOAN_LC_UNPAID_PREM_INT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList3.get(3)).getValue()));
			 */

			L_SET_UNPAID_INT_PROPERTY();

			ArrayList<OracleParameter> paramList4 = new ArrayList<OracleParameter>();
			OracleParameter param14 = new OracleParameter("IN1", "STRING",
					"IN", CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SYS_ID()));
			if (getPT_IL_LOAN_BEAN().getLOAN_FC_OS_AMOUNT() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_OS_AMOUNT(0.0);
			}
			OracleParameter param24 = new OracleParameter("INOUT1", "STRING",
					"IN OUT", CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_OS_AMOUNT()));
			if (getPT_IL_LOAN_BEAN().getLOAN_LC_OS_AMOUNT() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_OS_AMOUNT(0.0);
			}
			OracleParameter param34 = new OracleParameter("INOUT2", "STRING",
					"IN OUT", String.valueOf(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_OS_AMOUNT()));
			OracleParameter param44 = new OracleParameter("INOUT3", "STRING",
					"IN OUT", String.valueOf(M_LOAN_INT_RATE));
			paramList4.add(param14);
			paramList4.add(param24);
			paramList4.add(param34);
			paramList4.add(param44);
			OracleProcedureHandler procHandler4 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList4 = procHandler4.execute(
					paramList4, CommonUtils.getConnection(),
					"P9ILPK_LOAN.CALC_OS_LOAN_AMT");

			if (((OracleParameter) outputList4.get(0)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_OS_AMOUNT(
						Double.parseDouble(((OracleParameter) outputList4
								.get(0)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_FC_OS_AMOUNT(0.0);
			}
			// COMMENTED TEMPORARY

			/*
			 * getCOMP_LOAN_FC_OS_AMOUNT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList4.get(0)).getValue()));
			 */

			if (((OracleParameter) outputList4.get(1)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_OS_AMOUNT(
						Double.parseDouble(((OracleParameter) outputList4
								.get(1)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_LC_OS_AMOUNT(0.0);
			}
			// COMMENTED TEMPORARY
			/*
			 * getCOMP_LOAN_LC_OS_AMOUNT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList4.get(1)).getValue()));
			 */

			if (((OracleParameter) outputList4.get(2)).getValue() != null) {
				M_LOAN_INT_RATE = Double
						.parseDouble(((OracleParameter) outputList4.get(2))
								.getValue());
			} else {
				M_LOAN_INT_RATE = 0.0;
			}

			ArrayList<OracleParameter> paramList5 = new ArrayList<OracleParameter>();
			OracleParameter param15 = new OracleParameter("IN1", "STRING",
					"IN", CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SYS_ID()));
			OracleParameter param25 = new OracleParameter("IN2", "STRING",
					"IN", CommonUtils.dateToStringFormatter(tempLoanDt));
			OracleParameter param35 = new OracleParameter("IN3", "STRING",
					"IN", getPT_IL_LOAN_BEAN().getUI_M_POL_SA_CURR_CODE());
			OracleParameter param45 = new OracleParameter("IN4", "STRING",
					"IN", getPT_IL_LOAN_BEAN().getUI_M_POL_CUST_CURR_CODE());
			OracleParameter param55 = new OracleParameter("IN5", "STRING",
					"IN", getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR());
			OracleParameter param65 = new OracleParameter("IN6", "STRING",
					"IN", String.valueOf(getPT_IL_LOAN_BEAN()
							.getUI_M_CUST_CURR_EXCHANGE_RATE()));

			if (getPT_IL_LOAN_BEAN().getLOAN_FC_OS_LOAN_INT() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_OS_LOAN_INT(0.0);
			}
			OracleParameter param75 = new OracleParameter("INOUT1", "STRING",
					"IN OUT", String.valueOf(getPT_IL_LOAN_BEAN()
							.getLOAN_FC_OS_LOAN_INT()));
			if (getPT_IL_LOAN_BEAN().getLOAN_LC_OS_LOAN_INT() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_OS_LOAN_INT(0.0);
			}
			OracleParameter param85 = new OracleParameter("INOUT2", "STRING",
					"IN OUT", String.valueOf(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_OS_LOAN_INT()));
			paramList5.add(param15);
			paramList5.add(param25);
			paramList5.add(param35);
			paramList5.add(param45);
			paramList5.add(param55);
			paramList5.add(param65);
			paramList5.add(param75);
			paramList5.add(param85);
			OracleProcedureHandler procHandler5 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList5 = procHandler3.execute(
					paramList5, CommonUtils.getConnection(),
					"P9ILPK_LOAN.CALC_OS_LOAN_INT");
			
			if (outputList5 != null && !outputList5.isEmpty()) {

			if (((OracleParameter) outputList5.get(0)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_OS_LOAN_INT(
						Double.parseDouble(((OracleParameter) outputList5
								.get(0)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_FC_OS_LOAN_INT(0.0);
			}
			// COMMENTED TEMPORARY
			/*
			 * getCOMP_LOAN_FC_OS_LOAN_INT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList5.get(0)).getValue()));
			 */

			if (((OracleParameter) outputList5.get(1)).getValue() != null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_OS_LOAN_INT(
						Double.parseDouble(((OracleParameter) outputList5
								.get(1)).getValue()));
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_LC_OS_LOAN_INT(0.0);
			}
			}
			// COMMENTED TEMPORARY
			/*
			 * getCOMP_LOAN_LC_OS_LOAN_INT().setSubmittedValue(Double.parseDouble(
			 * ((OracleParameter) outputList5.get(1)).getValue()));
			 */

			if ("Y".equalsIgnoreCase(getPT_IL_LOAN_BEAN().getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 12));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 12));
				 */
			} else if ("H".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 6));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 6));
				 */
			} else if ("Q".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 3));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 3));
				 */
			} else if ("M".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 1));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 1));
				 */
			}
			// newly added for loan amount
			COMP_LOAN_FC_OS_AMOUNT.resetValue();
			COMP_LOAN_FC_OS_LOAN_INT.resetValue();
			COMP_LOAN_FC_NET_AMOUNT.resetValue();
			COMP_LOAN_LC_OS_AMOUNT.resetValue();
			COMP_LOAN_LC_OS_LOAN_INT.resetValue();
			COMP_LOAN_LC_NET_AMOUNT.resetValue();
			COMP_LOAN_FC_UNPAID_PREM.resetValue();
			COMP_LOAN_LC_UNPAID_PREM.resetValue();
			COMP_LOAN_FC_UNPAID_PREM_INT.resetValue();
			COMP_LOAN_LC_UNPAID_PREM_INT.resetValue();
			
			/*getPT_IL_LOAN_BEAN().setLOAN_FC_PERM_AMT(1000.000);
			getPT_IL_LOAN_BEAN().setLOAN_LC_PERM_AMT(5000.000);
			
			System.out.println(" Dhinesh 1  getPT_IL_LOAN_BEAN().getLOAN_FC_PERM_AMT           "+getPT_IL_LOAN_BEAN().getLOAN_FC_PERM_AMT());
			System.out.println(" Dhinesh 2  getPT_IL_LOAN_BEAN().getLOAN_LC_PERM_AMT           "+getPT_IL_LOAN_BEAN().getLOAN_LC_PERM_AMT());
*/
			// Fixed bug : FC Outstanding loan interest and FC Net loan
			// amount :added by Shankar Bodduluri : 23-Mar-09
			// COMP_LOAN_FC_OS_LOAN_INT.resetValue();
			// COMP_LOAN_LC_OS_LOAN_INT.resetValue();
		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

		finally {
			try {

				CommonUtils.closeCursor(rsCursor0);
				CommonUtils.closeCursor(rsCursor1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Date getAddedDate(Date input_Date, int months) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String from_Date = format_Date(input_Date);
		Date to_Date = null;
		String query = "select add_months(to_date('" + from_Date
				+ "','dd-mon-rrrr')," + months + ") from dual";
		try {
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection());
			while (resultSet.next()) {
				to_Date = resultSet.getDate(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
		return to_Date;
	}

	public String format_Date(Date date) {
		System.out.println("Date inside method >> " + date);
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(date);
		return result;
	}

	private void WhenValidateItem_PT_IL_LOAN_LOAN_DT(Date LoanDate)
			throws SQLException, Exception {
		CommonUtils.clearMaps(this);
		double P_LOAN_LC_PERM_AMOUNT = 0.0;
		double P_LOAN_FC_PERM_AMOUNT = 0.0;
		double P_LC_UNPAID_PREM1 = 0.0;
		double P_FC_UNPAID_PREM1 = 0.0;
		double P_FC_OS_LOAN_INT_AMT = 0.0;
		double P_LC_OS_LOAN_INT_AMT = 0.0;
		double P_LOAN_SURR_PERC = 0.0;
		Date P_LOAN_DT = null;
		double P_NO_YRS_PREM_PAID = 0.0;
		String P_LOAN_CURR_CODE = null;
		String P_BASE_CURR = "BND";
		String M_PLAN_CODE = null;
		String CUST_CURR_CODE = null;
		;
		Connection conn = null;
		String M_POL_PREM_WAIVE_YN = null;

		String LOAN_POL_NO = (String) getCOMP_LOAN_POL_NO().getSubmittedValue();
		LOAN_POL_NO = PT_IL_LOAN_BEAN.getLOAN_POL_NO();
		System.out.println("LOAN_POL_NO 111111111" + LOAN_POL_NO);

		// String cursorC1 = "SELECT POL_SYS_ID,POL_CUST_CURR_CODE,
		// POL_START_DT,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR,POL_NO_YRS_PREM_PAID,POL_STATUS,POL_SA_CURR_CODE,POL_PROD_CODE
		// FROM PT_IL_POLICY WHERE POL_NO = ?";
		String cursorC0 = "SELECT NVL(PLAN_SURR_YRS, 0) FROM PM_IL_PLAN WHERE PLAN_CODE =?";

		String P_LOAN_SURR_PERC_query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_LOAN_MX'";
		//

		int M_SURR_YRS = 0;
		conn = CommonUtils.getConnection();

		String cursorC1 = "SELECT POL_SYS_ID,POL_CUST_CURR_CODE,POL_DIVN_CODE,POL_START_DT,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR,POL_NO_YRS_PREM_PAID,POL_STATUS,POL_SA_CURR_CODE,POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ?";
		String cursorC2 = "SELECT ABS((MONTHS_BETWEEN(M_POL_START_DT,:PT_IL_LOAN.LOAN_DT)/ 12))FROM DUAL";

		// Proc P9ILPK_LOAN.LOAN_DATE_CHECK(:PT_IL_LOAN.LOAN_DT,
		// :PT_IL_LOAN.LOAN_POL_NO);

		ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();

		OracleParameter p11 = new OracleParameter("IN1", "STRING", "IN",
				format_Date(LoanDate));
		pList1.add(p11);
		OracleParameter p22 = new OracleParameter("IN2", "STRING", "IN",
				LOAN_POL_NO);
		pList1.add(p22);
		OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
		oList1 = pHandler1.execute(pList1, conn, "P9ILPK_LOAN.LOAN_DATE_CHECK");
		// proc finished

		LD_SA_CURR_EXCHANGE_RATE1();
		System.out.println("LOAN_POL_NO 22222222" + LOAN_POL_NO);
		PreparedStatement psmt = CommonUtils.getConnection().prepareStatement(
				cursorC1);
		psmt.setString(1, LOAN_POL_NO);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			POL_SYS_ID = rs.getLong("POL_SYS_ID");
			CUST_CURR_CODE = rs.getString("POL_CUST_CURR_CODE");
			M_POL_DIVN_CODE = rs.getString("POL_DIVN_CODE");
			M_POL_START_DT = rs.getDate("POL_START_DT");
			M_POL_CLASS_CODE = rs.getString("POL_CLASS_CODE");
			M_POL_PLAN_CODE = rs.getString("POL_PLAN_CODE");
			M_POL_UW_YEAR = rs.getInt("POL_UW_YEAR");
			M_NO_YRS_PREM_PAID = rs.getDouble("POL_NO_YRS_PREM_PAID");
			M_POL_STATUS = rs.getString("POL_STATUS");
			M_POL_SA_CURR_CODE = rs.getString("POL_SA_CURR_CODE");
			M_POL_PROD_CODE = rs.getString("POL_PROD_CODE");

		}
		// COMMENTD TEMPRORARY
		// COMP_LOAN_CURR_CODE.setSubmittedValue(M_POL_SA_CURR_CODE);
		PT_IL_LOAN_BEAN.setLOAN_CURR_CODE(M_POL_SA_CURR_CODE);
		PILT004_DUMMY_BEAN.put("M_POL_SA_CURR_CODE", M_POL_SA_CURR_CODE);
		PT_IL_LOAN_BEAN.setLOAN_CURR_CODE(M_POL_SA_CURR_CODE);
		CommonUtils.setGlobalVariable("PILT004_M_NO_YRS_PREM_PAID", String
				.valueOf(M_NO_YRS_PREM_PAID));

		// P_SET_DOC_NO_PROP

		String year = String.valueOf(LoanDate.getYear());

		System.out.println("LOAN_POL_NO 3333333333" + LOAN_POL_NO);
		String M_PARA1 = CommonUtils.getGlobalVariable("PILT004_MPARA1");
		P_SET_DOC_NO_PROP(conn, "5", M_PARA1, M_POL_DIVN_CODE,
				M_POL_CLASS_CODE, M_POL_PLAN_CODE, M_POL_PROD_CODE, year,
				PT_IL_LOAN_BEAN.getLOAN_REF_NO(), "PT_IL_LOAN", "Y", "", "",
				"", "");

		PreparedStatement psmt1 = CommonUtils.getConnection().prepareStatement(
				cursorC0);
		psmt1.setString(1, M_POL_PLAN_CODE);
		ResultSet rs1 = psmt1.executeQuery();

		while (rs1.next()) {
			M_SURR_YRS = rs1.getInt(1);
		}
		// IF NVL(:PT_IL_LOAN.M_NO_YRS_PREM_PAID,0) < :DUMMY.M_SURR_YRS THEN
		// STD_MESSAGE_ROUTINE(71069,NAME_IN('GLOBAL.M_LANG_CODE'),TO_CHAR(:DUMMY.M_SURR_YRS));
		// RAISE FORM_TRIGGER_FAILURE;
		// END IF;

		if (M_NO_YRS_PREM_PAID < M_SURR_YRS) {
			/**
			 * [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 details error message
			 * removed, getting error message also changed
			 */
			getErrorMap().put(
					"current",
					Messages.getString(PELConstants.pelErrorMessagePath,
							"71069"));
			/** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
			return;
		} else {
			getErrorMap().clear();
		}

		PreparedStatement psmt2 = CommonUtils.getConnection().prepareStatement(
				P_LOAN_SURR_PERC_query);
		ResultSet rs2 = psmt2.executeQuery();
		while (rs2.next()) {
			P_LOAN_SURR_PERC = rs2.getDouble("PS_VALUE");
			// COMMENTD TEMPRORARY
			// COMP_LOAN_SURR_PERC.setSubmittedValue(P_LOAN_SURR_PERC);
			PT_IL_LOAN_BEAN.setLOAN_SURR_PERC(P_LOAN_SURR_PERC);

		}

		// COMP_LOAN_EXCH_RATE
		String LOAN_EXCH_RATE_query = "SELECT CER_BUY_EXGE_RATE FROM FM_EXCHANGE_RATE  WHERE CER_CURR_CODE = ?";
		psmt2 = CommonUtils.getConnection().prepareStatement(
				LOAN_EXCH_RATE_query);
		psmt2.setString(1, M_POL_SA_CURR_CODE);
		rs2 = psmt2.executeQuery();

		while (rs2.next()) {
			P_LOAN_EXCH_RATE = rs2.getDouble("CER_BUY_EXGE_RATE");
			// COMMENTD TEMPRORARY
			// COMP_LOAN_EXCH_RATE.setSubmittedValue(P_LOAN_EXCH_RATE);
			PT_IL_LOAN_BEAN.setLOAN_EXCH_RATE(P_LOAN_EXCH_RATE);
		}

		System.out.println("LOAN_POL_NO 44444444444" + LOAN_POL_NO);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		String date1 = sdf1.format(LoanDate);

		/* PROCEDURE SV_CALCULATION */

		// P_LOAN_FC_PERM_AMOUNT OUT NUMBER, P_LOAN_LC_PERM_AMOUNT */
		callproc_P9ilpk_Loan_SV_CALCULATION(LOAN_POL_NO, date1, String
				.valueOf(P_LOAN_SURR_PERC));
		/* PROCEDURE P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT */

		String query1 = "SELECT POL_SYS_ID,POL_PREM_WAIVE_YN FROM PT_IL_POLICY WHERE POL_NO = ?";
		PreparedStatement psmt3 = CommonUtils.getConnection().prepareStatement(
				query1);
		psmt3.setString(1, LOAN_POL_NO);
		ResultSet rs3 = psmt3.executeQuery();
		while (rs3.next()) {
			M_POL_PREM_WAIVE_YN = rs3.getString(2);

		}
		if ((M_POL_STATUS != null && M_POL_STATUS.equalsIgnoreCase("P"))
				|| (M_POL_PREM_WAIVE_YN != null && M_POL_PREM_WAIVE_YN
						.equalsIgnoreCase("Y"))) {
			P_LOAN_FC_PERM_AMOUNT = 0.0;
			P_LOAN_LC_PERM_AMOUNT = 0.0;
		} else {

			// P_LOAN_FC_PERM_AMOUNT OUT NUMBER, P_LOAN_LC_PERM_AMOUNT */
			ArrayList<OracleParameter> parameterList1 = new ArrayList<OracleParameter>();

			OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
					String.valueOf(POL_SYS_ID));
			parameterList1.add(p1);
			OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN", "");
			parameterList1.add(p2);
			OracleParameter p3 = new OracleParameter("IN2", "STRING", "IN",
					date1);
			parameterList1.add(p3);
			OracleParameter p4 = new OracleParameter("OUT1", "STRING", "OUT",
					"");
			parameterList1.add(p4);
			OracleParameter p5 = new OracleParameter("OUT2", "STRING", "OUT",
					"");
			parameterList1.add(p5);
			OracleParameter p6 = new OracleParameter("OUT3", "STRING", "OUT",
					"");
			parameterList1.add(p6);
			OracleParameter p7 = new OracleParameter("OUT4", "STRING", "OUT",
					"");
			parameterList1.add(p7);

			OracleProcedureHandler procHandler1 = new OracleProcedureHandler();

			ArrayList<OracleParameter> outputList1 = new ArrayList<OracleParameter>();
			outputList1 = procHandler1
					.execute(parameterList1, CommonUtils.getConnection(),
							"P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");

			Iterator<OracleParameter> iterator = outputList1.iterator();
			System.out.println("LOAN_POL_NO 55555555555" + LOAN_POL_NO);

			while (iterator.hasNext()) {
				OracleParameter name = (OracleParameter) iterator.next();
				if (name.getFieldName().equals("OUT1")
						&& name.getValue() != null) {
					System.out.println("Out1=" + name.getValue());
					getCOMP_LOAN_FC_UNPAID_PREM().setSubmittedValue(
							Double.parseDouble(name.getValue()));
					PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM(Double.valueOf(name
							.getValue()));
				}
				if (name.getFieldName().equals("OUT2")
						&& name.getValue() != null) {
					System.out.println("Out2=" + name.getValue());
					getCOMP_LOAN_LC_UNPAID_PREM().setSubmittedValue(
							Double.parseDouble(name.getValue()));
					PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM(Double.valueOf(name
							.getValue()));
				}
				if (name.getFieldName().equals("OUT3")
						&& name.getValue() != null) {
					System.out.println("Out3=" + name.getValue());
					getCOMP_LOAN_FC_UNPAID_PREM_INT().setSubmittedValue(
							Double.parseDouble(name.getValue()));
					PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(Double
							.valueOf(name.getValue()));
				}
				if (name.getFieldName().equals("OUT4")
						&& name.getValue() != null) {
					System.out.println("Out4=" + name.getValue());
					getCOMP_LOAN_LC_UNPAID_PREM_INT().setSubmittedValue(
							Double.parseDouble(name.getValue()));
					PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM_INT(Double
							.valueOf(name.getValue()));
				}
			}
		}// endif
		// Proceedure CALC_OS_LOAN_AMT//

		ArrayList<OracleParameter> paramlist_CALC_OS = new ArrayList<OracleParameter>();
		OracleParameter para1 = new OracleParameter("IN1", "STRING", "IN",
				String.valueOf(POL_SYS_ID));
		paramlist_CALC_OS.add(para1);
		OracleParameter p12 = new OracleParameter("IN2", "STRING", "IN OUT", "");
		paramlist_CALC_OS.add(p12);
		OracleParameter p13 = new OracleParameter("IN3", "STRING", "IN OUT", "");
		paramlist_CALC_OS.add(p13);
		OracleParameter p14 = new OracleParameter("IN4", "STRING", "IN OUT", "");
		paramlist_CALC_OS.add(p14);
		
		OracleProcedureHandler procHandler_CALC_OS = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputList_CALC_OS = new ArrayList<OracleParameter>();
		outputList_CALC_OS = procHandler_CALC_OS.execute(paramlist_CALC_OS,
				CommonUtils.getConnection(), "P9ILPK_LOAN.CALC_OS_LOAN_AMT");
		Iterator<OracleParameter> iterator_CALC_OS = outputList_CALC_OS
				.iterator();

		while (iterator_CALC_OS.hasNext()) {
			OracleParameter name = (OracleParameter) iterator_CALC_OS.next();
			if (name.getFieldName().equals("IN2") && name.getValue() != null) {
				System.out.println("IN2---------_CALC_OS-------> "
						+ name.getValue());
				getCOMP_LOAN_FC_OS_AMOUNT().setSubmittedValue(
						Double.parseDouble(name.getValue()));
				PT_IL_LOAN_BEAN.setLOAN_FC_AMOUNT(Double.valueOf(name
						.getValue()));

			} else if (name.getFieldName().equals("IN3")
					&& name.getValue() != null) {
				System.out.println("IN3---------_CALC_OS-------> "
						+ name.getValue());
				getCOMP_LOAN_LC_OS_AMOUNT().setSubmittedValue(
						Double.parseDouble(name.getValue()));
				PT_IL_LOAN_BEAN.setLOAN_LC_AMOUNT(Double.valueOf(name
						.getValue()));

			} else {
				System.out.println("IN4---------_CALC_OS-------> "
						+ name.getValue());
				getCOMP_LOAN_LC_OS_AMOUNT().setSubmittedValue(
						Double.parseDouble(name.getValue()));
				PT_IL_LOAN_BEAN.setLOAN_LC_OS_AMOUNT(Double.valueOf(name
						.getValue()));
			}

		}
		// Proceedure CALC_OS_LOAN_AMT-Ends//

		/* PROCEDURE P9ILPK_LOAN.CALC_OS_LOAN_INT */

		// P_LOAN_FC_PERM_AMOUNT OUT NUMBER, P_LOAN_LC_PERM_AMOUNT */
		ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();

		OracleParameter q1 = new OracleParameter("IN1", "STRING", "IN", String
				.valueOf(POL_SYS_ID));
		paramList1.add(q1);
		OracleParameter q2 = new OracleParameter("IN2", "STRING", "IN", date1);
		paramList1.add(q2);
		OracleParameter q3 = new OracleParameter("IN3", "STRING", "IN",
				M_POL_SA_CURR_CODE);
		paramList1.add(q3);
		OracleParameter q4 = new OracleParameter("IN4", "STRING", "IN",
				CUST_CURR_CODE);
		paramList1.add(q4);
		OracleParameter q5 = new OracleParameter("IN5", "STRING", "IN", "BND");
		paramList1.add(q5);
		OracleParameter q6 = new OracleParameter("IN6", "STRING", "IN", String
				.valueOf(P_LOAN_EXCH_RATE));
		paramList1.add(q6);
		OracleParameter q7 = new OracleParameter("IN7", "STRING", "IN OUT", "");
		paramList1.add(q7);
		OracleParameter q8 = new OracleParameter("IN8", "STRING", "IN OUT", "");
		paramList1.add(q8);

		OracleProcedureHandler procHandler2 = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputList2 = new ArrayList<OracleParameter>();
		outputList2 = procHandler2.execute(paramList1, CommonUtils
				.getConnection(), "P9ILPK_LOAN.CALC_OS_LOAN_INT");
		Iterator<OracleParameter> iterator3 = outputList2.iterator();

		System.out.println("LOAN_POL_NO 5555555555" + LOAN_POL_NO);
		while (iterator3.hasNext()) {
			OracleParameter name = (OracleParameter) iterator3.next();
			if (name.getFieldName().equals("IN7") && name.getValue() != null) {
				getCOMP_LOAN_FC_OS_LOAN_INT().setSubmittedValue(
						Double.parseDouble(name.getValue()));
				PT_IL_LOAN_BEAN.setLOAN_FC_OS_LOAN_INT(Double.valueOf(name
						.getValue()));

			}
			if (name.getFieldName().equals("IN8") && name.getValue() != null) {
				getCOMP_LOAN_LC_OS_LOAN_INT().setSubmittedValue(
						(Double.parseDouble(name.getValue())));
				PT_IL_LOAN_BEAN.setLOAN_LC_OS_LOAN_INT(Double.valueOf(name
						.getValue()));
			}

		}

	}

	private void callproc_P9ilpk_Loan_SV_CALCULATION(String loan_pol_no,
			String date1, String p_loan_surr_perc) throws Exception {
		try {

			Double P_LOAN_FC_PERM_AMOUNT = 0.0;
			Double P_LOAN_LC_PERM_AMOUNT = 0.0;
			/*
			 * CommonUtils.setGlobalVariable("PILT004_M_NO_YRS_PREM_PAID",
			 * String.valueOf(M_NO_YRS_PREM_PAID));
			 * CommonUtils.setGlobalVariable("PILT004_M_POL_SA_CURR_CODE",
			 * M_POL_SA_CURR_CODE);
			 * CommonUtils.setGlobalVariable("PILT004_M_POL_LOAN_EXCH_RATE",
			 * String.valueOf(P_LOAN_EXCH_RATE));
			 */

			// M_NO_YRS_PREM_PAID =
			// Double.valueOf(CommonUtils.getGlobalVariable("PILT004_M_NO_YRS_PREM_PAID"));
			// P_LOAN_EXCH_RATE =
			// Double.valueOf(CommonUtils.getGlobalVariable("PILT004_M_POL_LOAN_EXCH_RATE"));
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();

			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					loan_pol_no);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					date1);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					p_loan_surr_perc);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					Double.toString(M_NO_YRS_PREM_PAID));
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					M_POL_SA_CURR_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					"BND"); // P_BASE_CURR);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					Double.toString(P_LOAN_EXCH_RATE));
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING",
					"OUT", "");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING",
					"OUT", "");
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"OUT", "");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"OUT", "");
			parameterList.add(param11);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			outputList = procHandler.execute(parameterList, CommonUtils
					.getConnection(), "P9ilpk_Loan.SV_CALCULATION");

			Iterator<OracleParameter> iterator2 = outputList.iterator();

			while (iterator2.hasNext()) {
				System.out.println("Iter not empty");
				OracleParameter name = (OracleParameter) iterator2.next();

				if (name.getFieldName().equals("IN8")) {
					P_FC_95_VALUE = (name.getValue() == null) ? 0.0 : Double
							.valueOf(name.getValue());
					PILT004_DUMMY_BEAN.put("P_FC_95_VALUE", String
							.valueOf(P_FC_95_VALUE));

				} else if (name.getFieldName().equals("IN9")) {
					P_LC_95_VALUE = (name.getValue() == null) ? 0.0 : Double
							.valueOf(name.getValue());
					PILT004_DUMMY_BEAN.put("P_LC_95_VALUE", String
							.valueOf(P_LC_95_VALUE));

				} else if (name.getFieldName().equals("IN10")) {
					P_LOAN_FC_PERM_AMOUNT = (name.getValue() == null) ? 0.0
							: Double.valueOf(name.getValue());
					System.out
							.println("PT_IL_LOAN_ACTION.callproc_P9ilpk_Loan_SV_CALCULATION() P_LOAN_FC_PERM_AMOUNT: "
									+ P_LOAN_FC_PERM_AMOUNT);
				} else if (name.getFieldName().equals("IN11")) {
					P_LOAN_LC_PERM_AMOUNT = (name.getValue() == null) ? 0.0
							: Double.valueOf(name.getValue());
					System.out
							.println("PT_IL_LOAN_ACTION.callproc_P9ilpk_Loan_SV_CALCULATION() P_LOAN_LC_PERM_AMOUNT: "
									+ P_LOAN_LC_PERM_AMOUNT);
				}
			}
			// COMMENTD TEMPRORARY
			// COMP_LOAN_FC_PERM_AMT.setSubmittedValue(P_LOAN_FC_PERM_AMOUNT);
			getPT_IL_LOAN_BEAN().setLOAN_FC_PERM_AMT(P_LOAN_FC_PERM_AMOUNT);
			// COMMENTD TEMPRORARY
			// COMP_LOAN_LC_PERM_AMT.setSubmittedValue(P_LOAN_LC_PERM_AMOUNT);
			getPT_IL_LOAN_BEAN().setLOAN_LC_PERM_AMT(P_LOAN_LC_PERM_AMOUNT);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {

				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
			}
		}

	}

	public void LoanSurcPercWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Double surrPercentage = null;
		Double valuecmp = (Double) value;

		// ADDED BY AKASH TO STOP THE VALIDATION ON QUERIED RECORD IF THERE IS
		// NO CHANGE
		//As dicussed with raja sir below condition commented by gopi on 04/01/2019 
		/*if (!valuecmp.equals(PT_IL_LOAN_BEAN.getLOAN_SURR_PERC())) {*/
			PT_IL_LOAN_BEAN.setLOAN_SURR_PERC(valuecmp);
			if (valuecmp != null) {
				Date tempLoanDt = PT_IL_LOAN_BEAN.getLOAN_DT();
				try {
					if (valuecmp <= 0) {

						getErrorMap().put(
								"current",
								Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91026"));
					}

					if (valuecmp > 100) {

						getErrorMap().put(
								"current",
								Messages.getString(
										PELConstants.pelErrorMessagePath,
										"71017"));
					}
					String C1 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_LOAN_MX'";
					connection = CommonUtils.getConnection();
					resultSet = handler.executeSelectStatement(C1, connection);
					if (resultSet.next()) {
						surrPercentage = resultSet.getDouble(1);
					}
					if (valuecmp > surrPercentage) {
						getErrorMap().put(
								"current",
								Messages.getString(
										PELConstants.pelErrorMessagePath,
										"11111"));
					}
					ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
					OracleParameter param1 = new OracleParameter("IN1",
							"STRING", "IN", getPT_IL_LOAN_BEAN()
									.getLOAN_POL_NO());
					OracleParameter param2 = new OracleParameter("IN2",
							"STRING", "IN", CommonUtils
									.dateToStringFormatter(tempLoanDt));
					OracleParameter param3 = new OracleParameter("IN3",
							"STRING", "IN", CommonUtils
									.getProcedureValue(valuecmp));
					OracleParameter param4 = new OracleParameter("IN4",
							"STRING", "IN", CommonUtils
									.getProcedureValue(getPT_IL_LOAN_BEAN()
											.getUI_M_NO_YRS_PREM_PAID()));
					OracleParameter param5 = new OracleParameter("IN5",
							"STRING", "IN", getPT_IL_LOAN_BEAN()
									.getLOAN_CURR_CODE());
					OracleParameter param6 = new OracleParameter("IN6",
							"STRING", "IN", getPT_IL_LOAN_BEAN()
									.getUI_M_BASE_CURR()); // P_BASE_CURR);
					OracleParameter param7 = new OracleParameter("IN7",
							"STRING", "IN", CommonUtils
									.getProcedureValue(getPT_IL_LOAN_BEAN()
											.getLOAN_EXCH_RATE()));
					OracleParameter param8 = new OracleParameter("IN8",
							"STRING", "OUT", "");
					OracleParameter param9 = new OracleParameter("IN9",
							"STRING", "OUT", "");
					OracleParameter param10 = new OracleParameter("IN10",
							"STRING", "OUT", "");
					OracleParameter param11 = new OracleParameter("IN11",
							"STRING", "OUT", "");
					parameterList.add(param1);
					parameterList.add(param2);
					parameterList.add(param3);
					parameterList.add(param4);
					parameterList.add(param5);
					parameterList.add(param6);
					parameterList.add(param7);
					parameterList.add(param8);
					parameterList.add(param9);
					parameterList.add(param10);
					parameterList.add(param11);
					OracleProcedureHandler procHandler = new OracleProcedureHandler();
					ArrayList<OracleParameter> outputList = procHandler
							.execute(parameterList,
									CommonUtils.getConnection(),
									"P9ilpk_Loan.SV_CALCULATION");

					if (((OracleParameter) outputList.get(0)).getValue() == null) {
						getPT_IL_LOAN_BEAN().setUI_M_FC_95_VALUE(0.0);
					} else {
						getPT_IL_LOAN_BEAN()
								.setUI_M_FC_95_VALUE(
										Double
												.parseDouble(((OracleParameter) outputList
														.get(0)).getValue()));
					}

					if (((OracleParameter) outputList.get(1)).getValue() == null) {
						getPT_IL_LOAN_BEAN().setUI_M_LC_95_VALUE(0.0);
					} else {
						getPT_IL_LOAN_BEAN()
								.setUI_M_LC_95_VALUE(
										Double
												.parseDouble(((OracleParameter) outputList
														.get(1)).getValue()));
					}

					if (((OracleParameter) outputList.get(2)).getValue() == null) {
						getPT_IL_LOAN_BEAN().setLOAN_FC_PERM_AMT(0.0);
					} else {
						getPT_IL_LOAN_BEAN()
								.setLOAN_FC_PERM_AMT(
										Double
												.parseDouble(((OracleParameter) outputList
														.get(2)).getValue()));
					}

					// COMMENTD TEMPRORARY

					/*
					 * getCOMP_LOAN_FC_PERM_AMT().setSubmittedValue(Double.parseDouble(
					 * ((OracleParameter) outputList.get(2)).getValue()));
					 */

					if (((OracleParameter) outputList.get(3)).getValue() == null) {
						getPT_IL_LOAN_BEAN().setLOAN_LC_PERM_AMT(0.0);
					} else {
						getPT_IL_LOAN_BEAN()
								.setLOAN_LC_PERM_AMT(
										Double
												.parseDouble(((OracleParameter) outputList
														.get(3)).getValue()));
					}
					// COMMENTD TEMPRORARY
					/*
					 * getCOMP_LOAN_LC_PERM_AMT().setSubmittedValue(Double.parseDouble(
					 * ((OracleParameter) outputList.get(3)).getValue()));
					 */
				} catch (SQLException exc) {
					exc.printStackTrace();
					try {
						ErrorHelpUtil.getErrorsAndWarningforProcedure(
								CommonUtils.getConnection(), FacesContext
										.getCurrentInstance(), "PT_IL_LOAN",
								this.getWarningMap());
					} catch (ValidatorException vexc) {
						vexc.printStackTrace();
						getErrorMap().put("current",
								vexc.getFacesMessage().getSummary());
						throw new ValidatorException(new FacesMessage(vexc
								.getMessage()));
					} catch (DBException e) {
						e.printStackTrace();
						throw new ValidatorException(new FacesMessage(e
								.getMessage()));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new ValidatorException(new FacesMessage(ex
							.getMessage()));
				} finally {
					try {

						CommonUtils.closeCursor(resultSet);
					} catch (Exception e) {
						getErrorMap().put("current", e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}

	//}
//end
	public void LOAN_REF_NO_Validator(FacesContext context,
			UIComponent component, Object value) {
		String refno = (String) value;
		// added by akash to stop validation on quered record suggested by
		// haneef
		if (!refno.equalsIgnoreCase(PT_IL_LOAN_BEAN.getLOAN_REF_NO())) {
			PT_IL_LOAN_BEAN.setLOAN_REF_NO(refno);
			currentMode = CommonUtils.getGlobalVariable("PILT004_MODE");
			if (null != currentMode && currentMode.equalsIgnoreCase("update")) {

			} else {
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				ArrayList<OracleParameter> outList = new ArrayList<OracleParameter>();
				ArrayList<String> returnList = new ArrayList<String>();
				OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
						refno);
				paramList.add(p1);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
				try {
					outputList = procHandler.execute(paramList, CommonUtils
							.getConnection(), "P9ILPK_LOAN.UNIQUE_REF_NO");

				} catch (SQLException exc) {
					exc.printStackTrace();
					try {
						ErrorHelpUtil.getErrorsAndWarningforProcedure(
								CommonUtils.getConnection(), FacesContext
										.getCurrentInstance(), "PT_IL_LOAN",
								this.getWarningMap());
					} catch (ValidatorException vexc) {
						vexc.printStackTrace();
						getErrorMap().put("current",
								vexc.getFacesMessage().getSummary());
						throw new ValidatorException(new FacesMessage(vexc
								.getMessage()));
					} catch (DBException e) {
						e.printStackTrace();
						throw new ValidatorException(new FacesMessage(e
								.getMessage()));
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			}
		}
	}

	/*
	 * public void LOAN_FC_AMOUNT_Validator(ActionEvent event){ UIInput input =
	 * (UIInput) event.getComponent().getParent(); // Ajax4jsf comp
	 * ErrorHelpUtil.validate(input, input.getId(), getErrorMap()); }
	 * 
	 * public void validator_LOAN_FC_AMOUNT(FacesContext context, UIComponent
	 * component, Object value) {
	 */
	public void LOAN_FC_AMOUNT_Validator(FacesContext context,
			UIComponent component, Object val) throws Exception {
		Double value = (Double) val;

		PT_IL_LOAN_BEAN.setLOAN_FC_AMOUNT(value);
		try {
			if (value != null
					&& (getPT_IL_LOAN_BEAN().getUI_M_FC_95_VALUE() != null)) {
				/*
				 * if (value > getPT_IL_LOAN_BEAN() .getUI_M_FC_95_VALUE())
				 */
				if (value > PT_IL_LOAN_BEAN.getLOAN_FC_PERM_AMT()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71084"));
					/*
					 * getErrorMap().put( "current", Messages.getString(
					 * PELConstants.pelErrorMessagePath, "71084"));
					 */
				}
			}
			ArrayList<String> pCallValRoundAmount = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(value), "V");

			getPT_IL_LOAN_BEAN().setLOAN_FC_AMOUNT(
					Double.valueOf(pCallValRoundAmount.get(0)));

			getPT_IL_LOAN_BEAN().setLOAN_LC_AMOUNT(
					value * getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE());

			ArrayList<String> pCallValRoundAmount1 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_AMOUNT()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_LC_AMOUNT(
					Double.valueOf(pCallValRoundAmount1.get(0)));

			// LC VALIDATOR CALL FROM FC.

			LOAN_LC_AMOUNT_Validator();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

			/*
			 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			 * e.getMessage()); getErrorMap().put("CURRENT", e.getMessage());
			 */

		}
	}

	public void LOAN_LC_AMOUNT_Validator() throws Exception {

		Double M_VALUE = 0.0;
		Integer M_LOAN_TIME = 0;
		Date tempLoanDt = PT_IL_LOAN_BEAN.getLOAN_DT();
		try {
			ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
			OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getLOAN_CODE());
			paramList1.add(p1);
			OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_AMOUNT()));
			paramList1.add(p2);
			OracleParameter p3 = new OracleParameter("IN3", "STRING", "IN",
					CommonUtils.dateToStringFormatter(tempLoanDt));
			paramList1.add(p3);
			OracleParameter p4 = new OracleParameter("OUT1", "STRING", "OUT",
					"");
			paramList1.add(p4);
			OracleParameter p5 = new OracleParameter("OUT2", "STRING", "OUT",
					"");
			paramList1.add(p5);
			OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList1 = procHandler1.execute(
					paramList1, CommonUtils.getConnection(),
					"P9ILPK_LOAN.GET_LOAN_INTEREST");

			if (((OracleParameter) outputList1.get(0)).getValue() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_INT_RATE(0.0);
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_INT_RATE(
						Double.parseDouble(((OracleParameter) outputList1
								.get(0)).getValue()));
			}

			if (((OracleParameter) outputList1.get(1)).getValue() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_INT_RATE_PER(0.0);
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_INT_RATE_PER(
						Double.parseDouble(((OracleParameter) outputList1
								.get(1)).getValue()));
			}
			
			COMP_LOAN_INT_RATE.resetValue();
			COMP_LOAN_INT_RATE_PER.resetValue();
			COMP_LOAN_LC_AMOUNT.resetValue();

			if (null != getPT_IL_LOAN_BEAN().getUI_M_LC_95_VALUE()) {
				if (getPT_IL_LOAN_BEAN().getLOAN_LC_AMOUNT() > getPT_IL_LOAN_BEAN()
						.getUI_M_LC_95_VALUE()) {

					getErrorMap().put(
							"current",
							Messages.getString(
									PELConstants.pelErrorMessagePath, "71084"));
				}
			}

			ArrayList<String> pCallValRoundAmount = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_AMOUNT()), "V");

			getPT_IL_LOAN_BEAN().setLOAN_LC_AMOUNT(
					Double.parseDouble(pCallValRoundAmount.get(0)));
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()       : "+getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT());
			System.out.println("getCOMP_LOAN_FC_AMOUNT().getSubmittedValue()   : "+CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()));
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_LC_AMOUNT()       : "+CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_LC_AMOUNT()));
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE()       : "+CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE()));
			System.out.println("Call callP_VAL_FC_LC_TOLERANCE Procedure ");
			
			
			ArrayList<String> pValFcLcTolerance = new DBProcedures()
					.callP_VAL_FC_LC_TOLERANCE(CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()).toString(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_AMOUNT()).toString(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_EXCH_RATE()).toString(), "E");

			// COMMENTED BY AKASH CODE NOT AVAILABLE IN FMB.

			/*
			 * if (getPT_IL_LOAN_BEAN().getLOAN_SYS_ID() != 0) { System.out
			 * .println("getCOMP_LOAN_LC_AMOUNT().getSubmittedValue()" +
			 * getCOMP_LOAN_LC_AMOUNT().getSubmittedValue()); ArrayList<OracleParameter>
			 * paramList2 = new ArrayList<OracleParameter>(); OracleParameter
			 * p11 = new OracleParameter("IN1", "STRING", "IN",
			 * getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID() ); paramList2.add(p11);
			 * OracleParameter p21 = new OracleParameter("IN2", "STRING", "IN",
			 * getPT_IL_LOAN_BEAN().getLOAN_SYS_ID()); paramList2.add(p21);
			 * OracleParameter p31 = new OracleParameter("IN3", "STRING", "IN",
			 * (String) getCOMP_LOAN_FC_AMOUNT() .getSubmittedValue());
			 * paramList2.add(p31); OracleParameter p41 = new
			 * OracleParameter("IN4", "STRING", "IN", (String)
			 * getCOMP_LOAN_LC_AMOUNT() .getSubmittedValue());
			 * paramList2.add(p41); OracleParameter p51 = new
			 * OracleParameter("IN5", "STRING", "IN",
			 * getPT_IL_LOAN_BEAN().getLOAN_FC_PERM_AMT() );
			 * paramList2.add(p51); OracleParameter p61 = new
			 * OracleParameter("IN6", "STRING", "IN",
			 * getPT_IL_LOAN_BEAN().getLOAN_LC_PERM_AMT() );
			 * paramList2.add(p61); OracleParameter p71 = new
			 * OracleParameter("IN7", "STRING", "IN",
			 * getPT_IL_LOAN_BEAN().getUI_M_POL_SA_CURR_CODE());
			 * paramList2.add(p71); OracleParameter p81 = new
			 * OracleParameter("IN8", "STRING", "IN",
			 * getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR()); paramList2.add(p81);
			 * OracleProcedureHandler procHandler2 = new
			 * OracleProcedureHandler(); ArrayList<OracleParameter> outList2 =
			 * procHandler2.execute( paramList2, CommonUtils.getConnection(),
			 * "P9ilpk_Loan.P_UPD_LOAN_DTL"); }
			 */

			if ("Y".equalsIgnoreCase(getPT_IL_LOAN_BEAN().getLOAN_REPAY_FREQ())) {
				M_LOAN_TIME = 12;
			} else if ("H".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				M_LOAN_TIME = 6;
			} else if ("Q".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				M_LOAN_TIME = 3;
			} else if ("M".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				M_LOAN_TIME = 1;
			}

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter pa1 = new OracleParameter("IN1", "STRING", "IN",
					"N");
			paramList.add(pa1);
			OracleParameter pa2 = new OracleParameter("IN2", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_SYS_ID()));
			paramList.add(pa2);
			OracleParameter pa3 = new OracleParameter("IN3", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
			paramList.add(pa3);
			OracleParameter pa4 = new OracleParameter("IN4", "STRING", "IN",
					String.valueOf(PT_IL_LOAN_BEAN.getLOAN_EXCH_RATE()));
			paramList.add(pa4);
			OracleParameter pa5 = new OracleParameter("IN5", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR());
			paramList.add(pa5);
			OracleParameter pa6 = new OracleParameter("IN6", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_FC_AMOUNT()));
			paramList.add(pa6);
			OracleParameter pa7 = new OracleParameter("IN7", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_AMOUNT()));
			paramList.add(pa7);
			OracleParameter pa8 = new OracleParameter("IN8", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_FC_INTEREST(), 0.0)
							.toString());
			paramList.add(pa8);
			OracleParameter pa9 = new OracleParameter("IN9", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_LC_INTEREST(), 0.0)
							.toString());
			paramList.add(pa9);
			OracleParameter pa10 = new OracleParameter("IN10", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM(), 0.0)
							.toString());
			paramList.add(pa10);
			OracleParameter pa11 = new OracleParameter("IN11", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_LC_UNPAID_PREM(), 0.0)
							.toString());
			paramList.add(pa11);
			OracleParameter pa12 = new OracleParameter("IN12", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM_INT(),
							0.0).toString());
			paramList.add(pa12);
			OracleParameter pa13 = new OracleParameter("IN13", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_LC_UNPAID_PREM_INT(),
							0.0).toString());
			paramList.add(pa13);
			OracleParameter pa14 = new OracleParameter("IN14", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_FC_OS_AMOUNT(), 0.0)
							.toString());
			paramList.add(pa14);
			OracleParameter pa15 = new OracleParameter("IN15", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_LC_OS_AMOUNT(), 0.0)
							.toString());
			paramList.add(pa15);
			OracleParameter pa16 = new OracleParameter("IN16", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_FC_OS_LOAN_INT(), 0.0)
							.toString());
			paramList.add(pa16);
			OracleParameter pa17 = new OracleParameter("IN17", "STRING", "IN",
					MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_LC_OS_LOAN_INT(), 0.0)
							.toString());
			paramList.add(pa17);
			OracleParameter pa18 = new OracleParameter("OUT18", "STRING",
					"IN OUT", MigratingFunctions.nvl(
							getPT_IL_LOAN_BEAN().getLOAN_FC_NET_AMOUNT(), 0.0)
							.toString());
			paramList.add(pa18);
			OracleParameter pa19 = new OracleParameter("OUT19", "STRING",
					"OUT", "");
			paramList.add(pa19);
			OracleProcedureHandler procHandler4 = new OracleProcedureHandler();
			ArrayList<OracleParameter> outList = procHandler4.execute(
					paramList, CommonUtils.getConnection(),
					"P9ILPK_LOAN.LOAN_CHARGE_RECAL");
			if (((OracleParameter) outList.get(0)).getValue() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(0.0);
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
						Double.parseDouble(((OracleParameter) outList.get(0))
								.getValue()));
			}

			if (((OracleParameter) outList.get(1)).getValue() == null) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(0.0);
			} else {
				getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
						Double.parseDouble(((OracleParameter) outList.get(1))
								.getValue()));
			}

			System.out.println("Parameter value 1 ===="+getPT_IL_LOAN_BEAN().getLOAN_REPAY_FREQ());
			//System.out.println("value in term======"+(String) getPT_IL_LOAN_BEAN().getLOAN_TERM());
			String Term_value=String.valueOf(getPT_IL_LOAN_BEAN().getLOAN_TERM());
			System.out.println("Term_value======"+Term_value);
			
			
			/*String cursor1 = "SELECT PIL_LOAN_SYS_ID.NEXTVAL AS LOAN_SYS_ID FROM DUAL";
			//String cursor2 = "SELECT POL_SYS_ID,POL_DIVN_CODE,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR FROM PT_IL_POLICY WHERE POL_NO = ?";
			Connection con = CommonUtils.getConnection();
			PreparedStatement psmt = con.prepareStatement(cursor1);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				LOAN_SYS_ID = rs.getLong("LOAN_SYS_ID");
			}

			System.out.println("loan Sys id====="+LOAN_SYS_ID);
			getPT_IL_LOAN_BEAN().setLOAN_SYS_ID(LOAN_SYS_ID);*/
			
			if (getPT_IL_LOAN_BEAN().getLOAN_INT_RATE() != null) {
				ArrayList<OracleParameter> paramList5 = new ArrayList<OracleParameter>();
				OracleParameter q1 = new OracleParameter("IN1", "INT", "IN",
						CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
								.getUI_M_POL_SYS_ID()));
				paramList5.add(q1);
				OracleParameter q2 = new OracleParameter("IN2", "DATE", "IN",
						CommonUtils.dateToStringFormatter(tempLoanDt));
				paramList5.add(q2);
				OracleParameter q3 = new OracleParameter("IN3", "STRING", "IN",
						CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
								.getLOAN_CODE()));
				paramList5.add(q3);
				OracleParameter q4 = new OracleParameter("IN4", "INT", "IN",
						CommonUtils.getProcedureValue(M_LOAN_TIME));
				paramList5.add(q4);
				OracleParameter q5 = new OracleParameter("IN5", "INT", "IN",
						CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
								.getLOAN_SYS_ID()));
				paramList5.add(q5);
				OracleParameter q6 = new OracleParameter("IN6", "INT", "IN",
						MigratingFunctions.nvl(
								getPT_IL_LOAN_BEAN().getLOAN_INT_RATE(), 0.0)
								.toString());
				paramList5.add(q6);
				OracleParameter q7 = new OracleParameter("IN7", "INT", "IN",
						MigratingFunctions.nvl(
								getPT_IL_LOAN_BEAN().getLOAN_INT_RATE_PER(),
								0.0).toString());
				paramList5.add(q7);
				OracleParameter q8 = new OracleParameter("IN8", "INT", "IN",
						CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
								.getLOAN_FC_AMOUNT()));
				paramList5.add(q8);
				OracleParameter q9 = new OracleParameter("IN9", "INT", "IN",
						CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
								.getLOAN_LC_AMOUNT()));
				paramList5.add(q9);
				OracleParameter q10 = new OracleParameter("IN10", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
				paramList5.add(q10);
				OracleParameter q11 = new OracleParameter("IN11", "INT",
						"IN", CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getLOAN_EXCH_RATE()));
				paramList5.add(q11);
				/*OracleParameter q12 = new OracleParameter("IN12", "STRING",
						"IN", CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getLOAN_TERM()));
				paramList5.add(q12);*/
				OracleParameter q12 = new OracleParameter("IN12", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR());
				paramList5.add(q12);
				OracleParameter q13 = new OracleParameter("IN13", "INT",
						"IN", MigratingFunctions.nvl(
								getPT_IL_LOAN_BEAN().getLOAN_LC_UNPAID_PREM(),
								0.0).toString());
				paramList5.add(q13);
				OracleParameter q14 = new OracleParameter("IN14", "INT",
						"IN", MigratingFunctions.nvl(
								getPT_IL_LOAN_BEAN()
										.getLOAN_LC_UNPAID_PREM_INT(), 0.0)
								.toString());
				paramList5.add(q14);
				OracleParameter q15 = new OracleParameter("IN15", "INT",
						"IN", MigratingFunctions.nvl(
								getPT_IL_LOAN_BEAN().getLOAN_LC_OS_AMOUNT(),
								0.0).toString());
				paramList5.add(q15);
				OracleParameter q16 = new OracleParameter("IN16", "INT",
						"IN", MigratingFunctions.nvl(
								getPT_IL_LOAN_BEAN().getLOAN_LC_OS_LOAN_INT(),
								0.0).toString());
				paramList5.add(q16);
				//changed int to double for out parameters by ganesh to fix internal conversion failed error
				OracleParameter q17 = new OracleParameter("OUT1", "DOUBLE",
						"OUT", "");
				paramList5.add(q17);
				OracleParameter q18 = new OracleParameter("OUT2", "DOUBLE",
						"OUT", "");
				paramList5.add(q18);
				OracleParameter q19 = new OracleParameter("OUT3", "DOUBLE",
						"OUT", "");
				paramList5.add(q19);
				OracleParameter q20 = new OracleParameter("OUT4", "DOUBLE",
						"OUT", "");
				paramList5.add(q20);
				OracleParameter q21 = new OracleParameter("OUT5", "DOUBLE",
						"OUT", "");
				paramList5.add(q21);
				OracleParameter q22 = new OracleParameter("OUT6", "DOUBLE",
						"OUT", "");
				paramList5.add(q22);
				
				/*added by R.Raja*/
				
				OracleParameter q23 = new OracleParameter("IN17", "STRING",
						"IN",getPT_IL_LOAN_BEAN().getLOAN_REPAY_FREQ());
				paramList5.add(q23);
				OracleParameter q24 = new OracleParameter("IN18", "INT",
						"IN",Term_value);
				paramList5.add(q24);
				OracleParameter q25 = new OracleParameter("OUT7", "DOUBLE",
						"OUT", "");
				paramList5.add(q25);
				OracleParameter q26 = new OracleParameter("OUT8", "DOUBLE",
						"OUT", "");
				paramList5.add(q26);
				
				
				OracleProcedureHandler procHandler5 = new OracleProcedureHandler();
				ArrayList<OracleParameter> outputList5 = procHandler5.execute(
						paramList5, CommonUtils.getConnection(),
						"P9ILPK_LOAN.AT_INT_RATE_CAL");
				if (((OracleParameter) outputList5.get(0)).getValue() == null) {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(0.0);
				} else {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
							Double.parseDouble(((OracleParameter) outputList5
									.get(0)).getValue()));
				}

				if (((OracleParameter) outputList5.get(1)).getValue() == null) {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(0.0);
				} else {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
							Double.parseDouble(((OracleParameter) outputList5
									.get(1)).getValue()));
				}

				if (((OracleParameter) outputList5.get(2)).getValue() == null) {
					getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(0.0);
				} else {
					getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
							Double.parseDouble(((OracleParameter) outputList5
									.get(2)).getValue()));
				}

				if (((OracleParameter) outputList5.get(3)).getValue() == null) {
					getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(0.0);
				} else {
					getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
							Double.parseDouble(((OracleParameter) outputList5
									.get(3)).getValue()));
				}

				if (((OracleParameter) outputList5.get(4)).getValue() == null) {
					getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(0.0);
				} else {
					getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
							Double.parseDouble(((OracleParameter) outputList5
									.get(4)).getValue()));
				}

				if (((OracleParameter) outputList5.get(5)).getValue() == null) {
					getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(0.0);
				} else {
					getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
							Double.parseDouble(((OracleParameter) outputList5
									.get(5)).getValue()));
				}

				COMP_LOAN_INT_RATE.resetValue();
				COMP_LOAN_INT_RATE_PER.resetValue();
				COMP_LOAN_LC_AMOUNT.resetValue();
				COMP_LOAN_LC_NET_AMOUNT.resetValue();
				COMP_UI_M_LOAN_GR_FC_AMT.resetValue();
				COMP_UI_M_LOAN_GR_LC_AMT.resetValue();
				COMP_LOAN_FC_INTEREST.resetValue();
				COMP_LOAN_LC_INTEREST.resetValue();
				COMP_LOAN_LC_NET_AMOUNT.resetValue();
				COMP_LOAN_FC_NET_AMOUNT.resetValue();

			}
		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void callProc_P_UPD_LOAN_DTL() throws Exception {

		String P_LOAN_POL_NO = PT_IL_LOAN_BEAN.getLOAN_POL_NO();
		String cursor1 = "SELECT PIL_LOAN_SYS_ID.NEXTVAL AS LOAN_SYS_ID FROM DUAL";
		String cursor2 = "SELECT POL_SYS_ID,POL_DIVN_CODE,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR FROM PT_IL_POLICY WHERE POL_NO = ?";
		Connection con = CommonUtils.getConnection();
		PreparedStatement psmt = con.prepareStatement(cursor1);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			LOAN_SYS_ID = rs.getLong("LOAN_SYS_ID");
		}

		psmt = con.prepareStatement(cursor2);
		psmt.setString(1, P_LOAN_POL_NO);

		rs = psmt.executeQuery();
		while (rs.next()) {
			POL_SYS_ID = rs.getLong("POL_SYS_ID");

		}

		if (LOAN_SYS_ID == 0) {
			PT_IL_LOAN_BEAN.setLOAN_SYS_ID(LOAN_SYS_ID);
		} else {
			LOAN_SYS_ID = PT_IL_LOAN_BEAN.getLOAN_SYS_ID();
		}

		if (POL_SYS_ID == 0) {
			PT_IL_LOAN_BEAN.setLOAN_POL_SYS_ID(POL_SYS_ID);
		} else {
			POL_SYS_ID = PT_IL_LOAN_BEAN.getLOAN_POL_SYS_ID();
		}
		ArrayList<OracleParameter> paramList2 = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outList2 = new ArrayList<OracleParameter>();

		OracleParameter p11 = new OracleParameter("IN1", "STRING", "IN",
				CommonUtils.getProcedureValue(POL_SYS_ID));
		paramList2.add(p11);
		OracleParameter p21 = new OracleParameter("IN2", "STRING", "IN", String
				.valueOf(LOAN_SYS_ID));
		paramList2.add(p21);
		OracleParameter p31 = new OracleParameter("IN3", "STRING", "IN",
				CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
						.getLOAN_FC_AMOUNT()));
		paramList2.add(p31);
		OracleParameter p41 = new OracleParameter("IN4", "STRING", "IN",
				CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
						.getLOAN_LC_AMOUNT()));
		paramList2.add(p41);
		OracleParameter p51 = new OracleParameter("IN5", "STRING", "IN",
				CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
						.getLOAN_FC_PERM_AMT()));
		paramList2.add(p51);
		OracleParameter p61 = new OracleParameter("IN6", "STRING", "IN",
				CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
						.getLOAN_LC_PERM_AMT()));
		paramList2.add(p61);
		OracleParameter p71 = new OracleParameter("IN7", "STRING", "IN",
				M_POL_SA_CURR_CODE);
		paramList2.add(p71);
		OracleParameter p81 = new OracleParameter("IN8", "STRING", "IN", "BND");
		paramList2.add(p81);
		OracleProcedureHandler procHandler2 = new OracleProcedureHandler();
		outList2 = procHandler2.execute(paramList2,
				CommonUtils.getConnection(), "P9ilpk_Loan.P_UPD_LOAN_DTL");
	}

	public void LOAN_REPAY_FREQ_Validation(FacesContext context,
			UIComponent component, Object value) {
		Integer M_LOAN_TIME = 0;
		getPT_IL_LOAN_BEAN().setLOAN_REPAY_FREQ((String) value);
		Date tempLoanDt = getPT_IL_LOAN_BEAN().getLOAN_DT();
		try {
			if ("Y".equalsIgnoreCase(getPT_IL_LOAN_BEAN().getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 12));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 12));
				 */
			} else if ("H".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 6));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 6));
				 */
			} else if ("Q".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 3));
				// COMMENTED TEMPORARY
				/*
				 * getCOMP_LOAN_DUE_DT().setSubmittedValue(
				 * CommonUtils.addMonthsToDate(tempLoanDt, 3));
				 */
			} else if ("M".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
					.getLOAN_REPAY_FREQ())) {
				getPT_IL_LOAN_BEAN().setLOAN_DUE_DT(
						CommonUtils.addMonthsToDate(tempLoanDt, 1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		/*
		 * try {
		 * 
		 * if ("Y".equalsIgnoreCase(tempLoanRepayFreq)) {
		 * CommonUtils.addMonthsToDate(getPT_IL_LOAN_BEAN() .getLOAN_DUE_DT(),
		 * 12); } else if ("H".equalsIgnoreCase(tempLoanRepayFreq)) {
		 * CommonUtils.addMonthsToDate(getPT_IL_LOAN_BEAN() .getLOAN_DUE_DT(),
		 * 6); } else if ("Q".equalsIgnoreCase(tempLoanRepayFreq)) {
		 * CommonUtils.addMonthsToDate(getPT_IL_LOAN_BEAN() .getLOAN_DUE_DT(),
		 * 3); } else if ("M".equalsIgnoreCase(tempLoanRepayFreq)) {
		 * CommonUtils.addMonthsToDate(getPT_IL_LOAN_BEAN() .getLOAN_DUE_DT(),
		 * 1); }
		 * 
		 * if ("Y".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 12; }
		 * else if ("H".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 6; }
		 * else if ("Q".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 3; }
		 * else if ("M".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 1; }
		 * 
		 * 
		 * if (getPT_IL_LOAN_BEAN().getLOAN_INT_RATE() != null) { ArrayList<OracleParameter>
		 * paramList5 = new ArrayList<OracleParameter>(); OracleParameter q1 =
		 * new OracleParameter("IN1", "STRING", "IN",
		 * CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID()));
		 * paramList5.add(q1); OracleParameter q2 = new OracleParameter("IN2",
		 * "STRING", "IN",
		 * CommonUtils.dateToStringFormatter(getPT_IL_LOAN_BEAN()
		 * .getLOAN_DT())); paramList5.add(q2); OracleParameter q3 = new
		 * OracleParameter("IN3", "STRING", "IN",
		 * getPT_IL_LOAN_BEAN().getLOAN_CODE()); paramList5.add(q3);
		 * OracleParameter q4 = new OracleParameter("IN4", "STRING", "IN",
		 * CommonUtils.getProcedureValue(M_LOAN_TIME)); paramList5.add(q4);
		 * OracleParameter q5 = new OracleParameter("IN5", "STRING", "IN",
		 * CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_SYS_ID()));
		 * paramList5.add(q5); OracleParameter q6 = new OracleParameter("IN6",
		 * "STRING", "IN", MigratingFunctions.nvl(
		 * getPT_IL_LOAN_BEAN().getLOAN_INT_RATE(), 0.0).toString() );
		 * paramList5.add(q6); OracleParameter q7 = new OracleParameter("IN7",
		 * "STRING", "IN", MigratingFunctions.nvl(
		 * getPT_IL_LOAN_BEAN().getLOAN_INT_RATE_PER(), 0.0).toString());
		 * paramList5.add(q7); OracleParameter q8 = new OracleParameter("IN8",
		 * "STRING", "IN",
		 * CommonUtils.getProcedureValue(getCOMP_LOAN_FC_AMOUNT().getSubmittedValue()));
		 * paramList5.add(q8); OracleParameter q9 = new OracleParameter("IN9",
		 * "STRING", "IN",
		 * CommonUtils.getProcedureValue(PT_IL_LOAN_BEAN.getLOAN_LC_AMOUNT()));
		 * paramList5.add(q9); OracleParameter q10 = new OracleParameter("IN10",
		 * "STRING", "IN", getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
		 * paramList5.add(q10); OracleParameter q11 = new
		 * OracleParameter("IN11", "STRING", "IN",
		 * CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE()) );
		 * paramList5.add(q11); OracleParameter q12 = new
		 * OracleParameter("IN12", "STRING", "IN",
		 * getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR()); paramList5.add(q12);
		 * OracleParameter q13 = new OracleParameter("IN13", "STRING", "IN",
		 * MigratingFunctions.nvl(
		 * getPT_IL_LOAN_BEAN().getLOAN_LC_UNPAID_PREM(), 0.0).toString());
		 * paramList5.add(q13); OracleParameter q14 = new
		 * OracleParameter("IN14", "STRING", "IN", MigratingFunctions.nvl(
		 * getPT_IL_LOAN_BEAN() .getLOAN_LC_UNPAID_PREM_INT(), 0.0).toString() );
		 * paramList5.add(q14); OracleParameter q15 = new
		 * OracleParameter("IN15", "STRING", "IN", MigratingFunctions.nvl(
		 * getPT_IL_LOAN_BEAN().getLOAN_LC_OS_AMOUNT(), 0.0).toString());
		 * paramList5.add(q15); OracleParameter q16 = new
		 * OracleParameter("IN16", "STRING", "IN", MigratingFunctions.nvl(
		 * getPT_IL_LOAN_BEAN().getLOAN_LC_OS_LOAN_INT(), 0.0).toString());
		 * paramList5.add(q16); OracleParameter q17 = new
		 * OracleParameter("OUT1", "STRING", "OUT", ""); paramList5.add(q17);
		 * OracleParameter q18 = new OracleParameter("OUT2", "STRING", "OUT",
		 * ""); paramList5.add(q18); OracleParameter q19 = new
		 * OracleParameter("OUT3", "STRING", "OUT", ""); paramList5.add(q19);
		 * OracleParameter q20 = new OracleParameter("OUT4", "STRING", "OUT",
		 * ""); paramList5.add(q20); OracleParameter q21 = new
		 * OracleParameter("OUT5", "STRING", "OUT", ""); paramList5.add(q21);
		 * OracleParameter q22 = new OracleParameter("OUT6", "STRING", "OUT",
		 * ""); paramList5.add(q22); OracleProcedureHandler procHandler5 = new
		 * OracleProcedureHandler(); ArrayList<OracleParameter> outputList5 =
		 * procHandler5.execute( paramList5, CommonUtils.getConnection(),
		 * "P9ILPK_LOAN.AT_INT_RATE_CAL");
		 * 
		 * if (((OracleParameter) outputList5.get(0)).getValue() == null) {
		 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(0.0); } else {
		 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
		 * Double.parseDouble(((OracleParameter) outputList5
		 * .get(0)).getValue())); }
		 * 
		 * 
		 * if (((OracleParameter) outputList5.get(1)).getValue() == null) {
		 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(0.0); } else {
		 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
		 * Double.parseDouble(((OracleParameter) outputList5
		 * .get(1)).getValue())); }
		 * 
		 * if (((OracleParameter) outputList5.get(2)).getValue() == null) {
		 * getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(0.0); } else {
		 * getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
		 * Double.parseDouble(((OracleParameter) outputList5
		 * .get(2)).getValue())); }
		 * 
		 * 
		 * if (((OracleParameter) outputList5.get(3)).getValue() == null) {
		 * getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(0.0); } else {
		 * getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
		 * Double.parseDouble(((OracleParameter) outputList5
		 * .get(3)).getValue())); }
		 * 
		 * 
		 * if (((OracleParameter) outputList5.get(4)).getValue() == null) {
		 * getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(0.0); } else {
		 * getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
		 * Double.parseDouble(((OracleParameter) outputList5
		 * .get(4)).getValue())); }
		 * 
		 * 
		 * if (((OracleParameter) outputList5.get(5)).getValue() == null) {
		 * getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(0.0); } else {
		 * getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
		 * Double.parseDouble(((OracleParameter) outputList5
		 * .get(5)).getValue())); }
		 * 
		 *  } } catch (SQLException exc) { exc.printStackTrace(); try {
		 * ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
		 * .getConnection(), FacesContext.getCurrentInstance(), "PT_IL_LOAN",
		 * this.getWarningMap()); } catch (ValidatorException vexc) {
		 * vexc.printStackTrace(); getErrorMap().put("current",
		 * vexc.getFacesMessage().getSummary()); throw new ValidatorException(
		 * new FacesMessage(vexc.getMessage())); } catch (DBException e) {
		 * e.printStackTrace(); throw new ValidatorException(new
		 * FacesMessage(e.getMessage())); } } catch (Exception e) {
		 * e.printStackTrace();
		 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		 * e.getMessage());
		 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		 * e.getMessage()); }
		 */
	}

	/*
	 * public void LoanRepayFreqWhenValidate(ActionEvent ae) { Integer
	 * M_LOAN_TIME = 0; HtmlSelectOneMenu input = (HtmlSelectOneMenu)
	 * ae.getComponent() .getParent(); String tempLoanRepayFreq = (String)
	 * input.getValue(); UIInput inputChk = (UIInput)
	 * ae.getComponent().getParent(); String value =
	 * (String)inputChk.getSubmittedValue(); if(value != null){
	 * if(!value.equals(PT_IL_LOAN_BEAN.getLOAN_REPAY_FREQ())){ try { if
	 * ("Y".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 12; } else if
	 * ("H".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 6; } else if
	 * ("Q".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 3; } else if
	 * ("M".equalsIgnoreCase(tempLoanRepayFreq)) { M_LOAN_TIME = 1; }
	 * 
	 * if (getPT_IL_LOAN_BEAN().getLOAN_INT_RATE() != null) { ArrayList<OracleParameter>
	 * paramList5 = new ArrayList<OracleParameter>(); OracleParameter q1 = new
	 * OracleParameter("IN1", "STRING", "IN",
	 * String.valueOf(PT_IL_LOAN_BEAN.getUI_M_POL_SYS_ID()));
	 * paramList5.add(q1); OracleParameter q2 = new OracleParameter("IN2",
	 * "STRING", "IN", CommonUtils.dateToStringFormatter(getPT_IL_LOAN_BEAN()
	 * .getLOAN_DT())); paramList5.add(q2); OracleParameter q3 = new
	 * OracleParameter("IN3", "STRING", "IN",
	 * getPT_IL_LOAN_BEAN().getLOAN_CODE()); paramList5.add(q3); OracleParameter
	 * q4 = new OracleParameter("IN4", "STRING", "IN",
	 * CommonUtils.getProcedureValue(M_LOAN_TIME)); paramList5.add(q4);
	 * OracleParameter q5 = new OracleParameter("IN5", "STRING", "IN",
	 * CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_SYS_ID()));
	 * paramList5.add(q5); OracleParameter q6 = new OracleParameter("IN6",
	 * "STRING", "IN", MigratingFunctions.nvl(
	 * getPT_IL_LOAN_BEAN().getLOAN_INT_RATE(), 0.0).toString() );
	 * paramList5.add(q6); OracleParameter q7 = new OracleParameter("IN7",
	 * "STRING", "IN", MigratingFunctions.nvl(
	 * getPT_IL_LOAN_BEAN().getLOAN_INT_RATE_PER(), 0.0).toString());
	 * paramList5.add(q7); OracleParameter q8 = new OracleParameter("IN8",
	 * "STRING", "IN",
	 * CommonUtils.getProcedureValue(getCOMP_LOAN_FC_AMOUNT().getSubmittedValue()));
	 * paramList5.add(q8); OracleParameter q9 = new OracleParameter("IN9",
	 * "STRING", "IN",
	 * CommonUtils.getProcedureValue(PT_IL_LOAN_BEAN.getLOAN_LC_AMOUNT()));
	 * paramList5.add(q9); OracleParameter q10 = new OracleParameter("IN10",
	 * "STRING", "IN", getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
	 * paramList5.add(q10); OracleParameter q11 = new OracleParameter("IN11",
	 * "STRING", "IN",
	 * CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE()) );
	 * paramList5.add(q11); OracleParameter q12 = new OracleParameter("IN12",
	 * "STRING", "IN", getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR());
	 * paramList5.add(q12); OracleParameter q13 = new OracleParameter("IN13",
	 * "STRING", "IN", MigratingFunctions.nvl(
	 * getPT_IL_LOAN_BEAN().getLOAN_LC_UNPAID_PREM(), 0.0).toString());
	 * paramList5.add(q13); OracleParameter q14 = new OracleParameter("IN14",
	 * "STRING", "IN", MigratingFunctions.nvl( getPT_IL_LOAN_BEAN()
	 * .getLOAN_LC_UNPAID_PREM_INT(), 0.0).toString() ); paramList5.add(q14);
	 * OracleParameter q15 = new OracleParameter("IN15", "STRING", "IN",
	 * MigratingFunctions.nvl( getPT_IL_LOAN_BEAN().getLOAN_LC_OS_AMOUNT(),
	 * 0.0).toString()); paramList5.add(q15); OracleParameter q16 = new
	 * OracleParameter("IN16", "STRING", "IN", MigratingFunctions.nvl(
	 * getPT_IL_LOAN_BEAN().getLOAN_LC_OS_LOAN_INT(), 0.0).toString());
	 * paramList5.add(q16); OracleParameter q17 = new OracleParameter("OUT1",
	 * "STRING", "OUT", ""); paramList5.add(q17); OracleParameter q18 = new
	 * OracleParameter("OUT2", "STRING", "OUT", ""); paramList5.add(q18);
	 * OracleParameter q19 = new OracleParameter("OUT3", "STRING", "OUT", "");
	 * paramList5.add(q19); OracleParameter q20 = new OracleParameter("OUT4",
	 * "STRING", "OUT", ""); paramList5.add(q20); OracleParameter q21 = new
	 * OracleParameter("OUT5", "STRING", "OUT", ""); paramList5.add(q21);
	 * OracleParameter q22 = new OracleParameter("OUT6", "STRING", "OUT", "");
	 * paramList5.add(q22); OracleProcedureHandler procHandler5 = new
	 * OracleProcedureHandler(); ArrayList<OracleParameter> outputList5 =
	 * procHandler5.execute( paramList5, CommonUtils.getConnection(),
	 * "P9ILPK_LOAN.AT_INT_RATE_CAL");
	 * 
	 * if (((OracleParameter) outputList5.get(0)).getValue() == null) {
	 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(0.0); } else {
	 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
	 * Double.parseDouble(((OracleParameter) outputList5 .get(0)).getValue())); }
	 * getCOMP_UI_M_LOAN_GR_FC_AMT().setSubmittedValue( ((OracleParameter)
	 * outputList5.get(0)).getValue());
	 * 
	 * if (((OracleParameter) outputList5.get(1)).getValue() == null) {
	 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(0.0); } else {
	 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
	 * Double.parseDouble(((OracleParameter) outputList5 .get(1)).getValue())); }
	 * getCOMP_UI_M_LOAN_GR_LC_AMT().setSubmittedValue( ((OracleParameter)
	 * outputList5.get(1)).getValue());
	 * 
	 * if (((OracleParameter) outputList5.get(2)).getValue() == null) {
	 * getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(0.0); } else {
	 * getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
	 * Double.parseDouble(((OracleParameter) outputList5 .get(2)).getValue())); }
	 * getCOMP_LOAN_FC_INTEREST().setSubmittedValue( ((OracleParameter)
	 * outputList5.get(2)).getValue());
	 * 
	 * if (((OracleParameter) outputList5.get(3)).getValue() == null) {
	 * getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(0.0); } else {
	 * getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
	 * Double.parseDouble(((OracleParameter) outputList5 .get(3)).getValue())); }
	 * getCOMP_LOAN_LC_INTEREST().setSubmittedValue( ((OracleParameter)
	 * outputList5.get(3)).getValue());
	 * 
	 * if (((OracleParameter) outputList5.get(4)).getValue() == null) {
	 * getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(0.0); } else {
	 * getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
	 * Double.parseDouble(((OracleParameter) outputList5 .get(4)).getValue())); }
	 * getCOMP_LOAN_LC_NET_AMOUNT().setSubmittedValue( ((OracleParameter)
	 * outputList5.get(4)).getValue());
	 * 
	 * if (((OracleParameter) outputList5.get(5)).getValue() == null) {
	 * getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(0.0); } else {
	 * getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
	 * Double.parseDouble(((OracleParameter) outputList5 .get(5)).getValue())); }
	 * getCOMP_LOAN_FC_NET_AMOUNT().setSubmittedValue( ((OracleParameter)
	 * outputList5.get(5)).getValue()); } } catch (Exception e) {
	 * e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("CURRENT", e.getMessage()); } finally {
	 * try { //ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection()); }
	 * catch (Exception e) { getErrorMap().put("current", e.getMessage());
	 * e.printStackTrace(); } } } } }
	 */

	/*
	 * public void LOAN_REPAY_FREQ_Validation(ActionEvent event) {
	 * 
	 * Connection conn = null; HtmlSelectOneMenu input = (HtmlSelectOneMenu)
	 * event.getComponent() .getParent(); String inputValue = (String)
	 * input.getValue();
	 * 
	 * try{ conn= CommonUtils.getConnection(); int M_LOAN_TIME = 0;
	 * 
	 * 
	 * String strDate = (String) getCOMP_LOAN_DT().getSubmittedValue();
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); Date loanDate =
	 * sdf.parse(strDate); Date repayDueDate = null; if (inputValue.equals("M")) {
	 * repayDueDate = getAddedDate(loanDate,1); }else if
	 * (inputValue.equals("H")) { repayDueDate = getAddedDate(loanDate,6); }else
	 * if (inputValue.equals("Y")) { repayDueDate = getAddedDate(loanDate,12);
	 * }else if (inputValue.equals("Q")) { repayDueDate =
	 * getAddedDate(loanDate,3); }else{ System.out.println("Invalid"); }
	 * System.out.println("repayDueDate" + repayDueDate);
	 * 
	 * if(inputValue.equals("Y")){M_LOAN_TIME = 12; }
	 * if(inputValue.equals("H")){M_LOAN_TIME = 6; }
	 * if(inputValue.equals("Q")){M_LOAN_TIME = 3; }
	 * if(inputValue.equals("M")){M_LOAN_TIME = 1; }
	 * COMP_LOAN_DUE_DT.setSubmittedValue(repayDueDate);
	 * PT_IL_LOAN_BEAN.setLOAN_DUE_DT(repayDueDate);
	 * 
	 * callproc_P9ILPK_LOAN_AT_INT_RATE_CAL(M_LOAN_TIME);
	 * 
	 * }catch(Exception e){ } finally{ try {
	 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
	 * FacesContext.getCurrentInstance(),
	 * input.getClientId(FacesContext.getCurrentInstance()), getErrorMap(),
	 * getWarningMap()); } catch (DBException e) { getErrorMap().put("current",
	 * e.getMessage()); e.printStackTrace(); } } }
	 */

	public void LOAN_FC_INTEREST_Validator(FacesContext context,
			UIComponent component, Object val) {
		Double M_LOAN_GR_LC_AMT = 0.0, M_LOAN_GR_FC_AMT = 0.0, M_VALUE = 0.0;
		String M_CODE_DESC = "";
		Double value = (Double) val;
		if (value != null) {
			// if(!value.equals(PT_IL_LOAN_BEAN.getLOAN_FC_INTEREST())){
			try {
				getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(value);
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", "IL_LNINT_DED");
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", "ID");
				OracleParameter param3 = new OracleParameter("inout1",
						"STRING", "IN OUT", M_CODE_DESC);
				OracleParameter param4 = new OracleParameter("in4", "STRING",
						"IN", "E");
				OracleParameter param5 = new OracleParameter("inout2",
						"STRING", "IN OUT", CommonUtils
								.getProcedureValue(M_VALUE));
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList<OracleParameter> listP_VAL_SYSTEM = procHandler
						.execute(paramList, CommonUtils.getConnection(),
								"P_VAL_SYSTEM");
				M_CODE_DESC = ((OracleParameter) listP_VAL_SYSTEM.get(0))
						.getValue();
				M_VALUE = Double
						.parseDouble(((OracleParameter) listP_VAL_SYSTEM.get(1))
								.getValue());

				ArrayList<String> pCallValRoundAmount = new DBProcedures()
						.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
								.getUI_M_POL_SA_CURR_CODE(), CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getLOAN_FC_INTEREST()), "R");

				getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
						Double.parseDouble(pCallValRoundAmount.get(0)));

				getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
						getPT_IL_LOAN_BEAN().getLOAN_FC_INTEREST()
								* getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE());

				ArrayList<String> pCallValRoundAmount1 = new DBProcedures()
						.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
								.getUI_M_BASE_CURR(), CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getLOAN_LC_INTEREST()), "R");

				getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
						Double.parseDouble(pCallValRoundAmount1.get(0)));

				if (M_VALUE == 1.0) {
					getPT_IL_LOAN_BEAN()
							.setUI_M_LOAN_GR_LC_AMT(
									MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
											.getLOAN_LC_AMOUNT(), 0.0)
											- MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getLOAN_LC_INTEREST(),
															0.0)
											+ MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getUI_M_LOAN_LC_CHARGE(),
															0.0));

				} else {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_AMOUNT(), 0.0)
									- MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getUI_M_LOAN_LC_CHARGE(),
											0.0));

				}

				ArrayList<String> pCallValRoundAmount2 = new DBProcedures()
						.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
								.getUI_M_BASE_CURR(), CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_GR_LC_AMT()), "R");

				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
						Double.parseDouble(pCallValRoundAmount2.get(0)));

				if (M_VALUE == 1) {
					getPT_IL_LOAN_BEAN()
							.setUI_M_LOAN_GR_FC_AMT(
									MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
											.getLOAN_FC_AMOUNT(), 0.0)
											- MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getLOAN_FC_INTEREST(),
															0.0)
											+ MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getUI_M_LOAN_FC_CHARGE(),
															0.0));

				} else {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_AMOUNT(), 0.0)
									- MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getUI_M_LOAN_FC_CHARGE(),
											0.0));

				}
				ArrayList<String> pCallValRoundAmount3 = new DBProcedures()
						.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
								.getLOAN_CURR_CODE(), CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getLOAN_FC_INTEREST()), "R");

				getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
						Double.parseDouble(pCallValRoundAmount3.get(0)));

			} catch (SQLException exc) {
				exc.printStackTrace();
				try {
					ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
							.getConnection(),
							FacesContext.getCurrentInstance(), "PT_IL_LOAN",
							this.getWarningMap());
				} catch (ValidatorException vexc) {
					vexc.printStackTrace();
					getErrorMap().put("current",
							vexc.getFacesMessage().getSummary());
					throw new ValidatorException(new FacesMessage(vexc
							.getMessage()));
				} catch (DBException e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				}
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("CURRENT", e.getMessage());
			}
			// }
		}

	}

	public void LOAN_LC_INTEREST_Validator(FacesContext context,
			UIComponent component, Object val) {
		Double value = (Double) val;
		PT_IL_LOAN_BEAN.setLOAN_LC_INTEREST(value);
		try {
			ArrayList<String> pCallValRoundAmount2 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getUI_M_LOAN_GR_LC_AMT()), "R");

			getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
					Double.parseDouble(pCallValRoundAmount2.get(0)));

			new DBProcedures().callP_VAL_FC_LC_TOLERANCE(CommonUtils
					.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_FC_INTEREST()), CommonUtils
					.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_INTEREST()),
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_EXCH_RATE()), "E");
		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public void LOAN_FC_UNPAID_PREM_Validator(FacesContext context,
			UIComponent component, Object valObject) {
		try {
			getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM((Double) valObject);
			ArrayList<String> pCallValRoundAmount0 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_UNPAID_PREM()), "V");
			getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM(
					Double.parseDouble(pCallValRoundAmount0.get(0)));

			getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM(
					getPT_IL_LOAN_BEAN().getLOAN_FC_UNPAID_PREM()
							* getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE());

			ArrayList<String> pCallValRoundAmount1 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_UNPAID_PREM()), "R");
			getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM(
					Double.parseDouble(pCallValRoundAmount1.get(0)));

			getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
					MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
							.getUI_M_LOAN_GR_LC_AMT(), 0.0)
							- MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_UNPAID_PREM(), 0.0)
							+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_UNPAID_PREM_INT(), 0.0)
							+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_OS_AMOUNT(), 0.0)
							+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_OS_LOAN_INT(), 0.0));

			ArrayList<String> pCallValRoundAmount2 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_NET_AMOUNT()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
					Double.parseDouble(pCallValRoundAmount2.get(0)));

			getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
					MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
							.getUI_M_LOAN_GR_FC_AMT(), 0.0)
							- MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_UNPAID_PREM(), 0.0)
							+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_UNPAID_PREM_INT(), 0.0)
							+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_OS_AMOUNT(), 0.0)
							+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_OS_LOAN_INT(), 0.0));

			ArrayList<String> pCallValRoundAmount3 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getLOAN_CURR_CODE(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_NET_AMOUNT()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
					Double.parseDouble(pCallValRoundAmount3.get(0)));

		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void LOAN_LC_UNPAID_PREM_Validator(FacesContext context,
			UIComponent component, Object valObject) {
		try {
			getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM((Double) valObject);
			ArrayList<String> pCallValRoundAmount0 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_UNPAID_PREM()), "V");
			getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM(
					Double.parseDouble(pCallValRoundAmount0.get(0)));

			new DBProcedures().callP_VAL_FC_LC_TOLERANCE(CommonUtils
					.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_FC_UNPAID_PREM()), CommonUtils
					.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_UNPAID_PREM()),
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_EXCH_RATE()), "E");

			if (MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
					.getLOAN_LC_UNPAID_PREM(), 0.0) == 0) {
				getPT_IL_LOAN_BEAN().setLOAN_UNPAID_PREM_INT_CODE("");

				getPT_IL_LOAN_BEAN().setLOAN_FC_UNPAID_PREM_INT(0.0);

				getPT_IL_LOAN_BEAN().setLOAN_LC_UNPAID_PREM_INT(0.0);

			}
		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	// TODO here i started submmited value

	public void LOAN_INT_RATE_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		Date M_LOAN_DT = null, M_NEXT_SCHD_DT = null;
		Integer M_DURATION = 0;
		Double M_VALUE = 0.0;
		String M_CODE_DESC = "";
		String queryCursor1 = "SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL "
				+ "WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N') != 'A' "
				+ "AND PC_SCHD_PYMT_DT >= ?";
		Object[] cursorC1Values = { getPT_IL_LOAN_BEAN().getUI_M_POL_SYS_ID(),
				getPT_IL_LOAN_BEAN().getLOAN_DT() };

		String queryCursor2 = "SELECT NVL(SUM(LC_LC_VALUE),0), NVL(SUM(LC_FC_VALUE),0) FROM PT_IL_LOAN_CHARGE WHERE LC_LOAN_SYS_ID = ?";
		Object[] cursorC2Values = { getPT_IL_LOAN_BEAN().getLOAN_SYS_ID() };
		ResultSet rsCursor1 = null, rsCursor2 = null;
		PT_IL_LOAN_BEAN.setLOAN_INT_RATE((Double) value);
		try {
			rsCursor1 = getHandler().executeSelectStatement(queryCursor1,
					CommonUtils.getConnection(), cursorC1Values);
			while (rsCursor1.next()) {
				M_NEXT_SCHD_DT = rsCursor1.getDate(1);
			}

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					"IL_LNINT_DED");
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					"ID");
			OracleParameter param3 = new OracleParameter("inout1", "STRING",
					"IN OUT", M_CODE_DESC);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					"N");
			OracleParameter param5 = new OracleParameter("inout2", "STRING",
					"IN OUT", CommonUtils.getProcedureValue(M_VALUE));
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
					CommonUtils.getConnection(), "P_VAL_SYSTEM");

			M_CODE_DESC = ((OracleParameter) listP_VAL_SYSTEM.get(0))
					.getValue();
			M_VALUE = Double.parseDouble(((OracleParameter) listP_VAL_SYSTEM
					.get(1)).getValue());

			rsCursor2 = getHandler().executeSelectStatement(queryCursor2,
					CommonUtils.getConnection(), cursorC2Values);
			while (rsCursor2.next()) {
				
				System.out.println("setUI_M_LOAN_LC_CHARGE 3 : "+rsCursor2.getDouble(1));
				System.out.println("setUI_M_LOAN_FC_CHARGE 4 : "+rsCursor2.getDouble(2));
				
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_LC_CHARGE(
						rsCursor2.getDouble(1));

				getPT_IL_LOAN_BEAN().setUI_M_LOAN_FC_CHARGE(
						rsCursor2.getDouble(2));

			}

			M_LOAN_DT = getPT_IL_LOAN_BEAN().getLOAN_DT();
			if (null != M_NEXT_SCHD_DT && null != M_LOAN_DT) {
				M_DURATION = CommonUtils
						.subtractDate(M_NEXT_SCHD_DT, M_LOAN_DT)
						/ CommonUtils.subtractDate((CommonUtils
								.addMonthsToDate(M_LOAN_DT, 12)), M_LOAN_DT);
			}

			if (M_VALUE == 1.0) {
				getPT_IL_LOAN_BEAN()
						.setLOAN_FC_INTEREST(
								getPT_IL_LOAN_BEAN().getLOAN_FC_AMOUNT()
										* (Double
												.parseDouble((String) getCOMP_LOAN_INT_RATE()
														.getSubmittedValue()) / 100)
										* MigratingFunctions.nvl(M_DURATION,
												0.0));

			}
			
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE()"+getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
			System.out.println("getPT_IL_LOAN_BEAN().getLOAN_FC_INTEREST()"+getPT_IL_LOAN_BEAN().getLOAN_FC_INTEREST());
			
			ArrayList<String> pCallValRoundAmount = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getLOAN_CURR_CODE(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_INTEREST()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
					Double.parseDouble(pCallValRoundAmount.get(0)));

			getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
					getPT_IL_LOAN_BEAN().getLOAN_FC_INTEREST()
							* getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE());

			ArrayList<String> pCallValRoundAmount1 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(),
							String.valueOf(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_INTEREST()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_LC_INTEREST(
					Double.parseDouble(pCallValRoundAmount1.get(0)));

			if (M_VALUE == 1.0) {
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
						MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
								.getLOAN_LC_AMOUNT(), 0.0)
								- MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
										.getLOAN_LC_INTEREST(), 0.0)
								+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_LC_CHARGE(), 0.0));

			} else {
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
						MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
								.getLOAN_LC_AMOUNT(), 0.0)
								- MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_LC_CHARGE(), 0.0));

			}

			ArrayList<String> pCallValRoundAmount2 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), String
							.valueOf(getPT_IL_LOAN_BEAN()
									.getUI_M_LOAN_GR_LC_AMT()), "R");

			getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
					Double.parseDouble(pCallValRoundAmount2.get(0)));

			if (M_VALUE == 1.0) {
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
						MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
								.getLOAN_FC_AMOUNT(), 0.0)
								- MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
										.getLOAN_FC_INTEREST(), 0.0)
								+ MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_FC_CHARGE(), 0.0));

			} else {
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
						MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
								.getLOAN_FC_AMOUNT(), 0.0)
								- MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_FC_CHARGE(), 0.0));

			}

			ArrayList<String> pCallValRoundAmount3 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getLOAN_CURR_CODE(),
							String.valueOf(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_INTEREST()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_FC_INTEREST(
					Double.parseDouble(pCallValRoundAmount3.get(0)));

			getPT_IL_LOAN_BEAN()
					.setLOAN_LC_NET_AMOUNT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getUI_M_LOAN_GR_LC_AMT(), 0.0)
									- (MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getLOAN_LC_UNPAID_PREM(),
											0.0)
											+ MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getLOAN_LC_UNPAID_PREM_INT(),
															0.0)
											+ MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getLOAN_LC_OS_AMOUNT(),
															0.0) + MigratingFunctions
											.nvl(getPT_IL_LOAN_BEAN()
													.getLOAN_LC_OS_LOAN_INT(),
													0.0)));

			ArrayList<String> pCallValRoundAmount4 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_NET_AMOUNT()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(
					Double.parseDouble(pCallValRoundAmount4.get(0)));

			getPT_IL_LOAN_BEAN()
					.setLOAN_FC_NET_AMOUNT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getUI_M_LOAN_GR_FC_AMT(), 0.0)
									- (MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getLOAN_FC_UNPAID_PREM(),
											0.0)
											+ MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getLOAN_FC_UNPAID_PREM_INT(),
															0.0)
											+ MigratingFunctions
													.nvl(
															getPT_IL_LOAN_BEAN()
																	.getLOAN_FC_OS_AMOUNT(),
															0.0) + MigratingFunctions
											.nvl(getPT_IL_LOAN_BEAN()
													.getLOAN_FC_OS_LOAN_INT(),
													0.0)));

			ArrayList<String> pCallValRoundAmount5 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getLOAN_CURR_CODE(), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_NET_AMOUNT()), "R");

			getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(
					Double.parseDouble(pCallValRoundAmount5.get(0)));

			COMP_LOAN_FC_INTEREST.resetValue();
			COMP_LOAN_LC_INTEREST.resetValue();
			COMP_UI_M_LOAN_GR_LC_AMT.resetValue();
			COMP_UI_M_LOAN_GR_LC_AMT.resetValue();
			COMP_LOAN_LC_NET_AMOUNT.resetValue();
			COMP_LOAN_FC_NET_AMOUNT.resetValue();

		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void LOAN_FC_PERM_AMT_Validator(FacesContext context,
			UIComponent component, Object val) {
		Double LOAN_LC_UNPAID_PREM = 0.0;
		Double LC_NET_AMOUNT = 0.0;
		Double FC_NET_AMOUNT = 0.0;
		PT_IL_LOAN_BEAN.setLOAN_FC_PERM_AMT((Double) val);
		Double LOAN_FC_PERM_AMT = (Double) val;
		LOAN_LC_UNPAID_PREM = LOAN_FC_PERM_AMT * P_LOAN_EXCH_RATE;

		PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM(LOAN_LC_UNPAID_PREM);

	}

	// public void POST_QUERY(int LOAN_SYS_ID, PT_IL_LOAN ptilbean){
	public void postQueryPtIlLoan() {
		CommonUtils.clearMaps(this);
		String queryCursorC1 = "SELECT NVL(SUM(LC_LC_VALUE),0), NVL(SUM(LC_FC_VALUE),0) "
				+ "FROM PT_IL_LOAN_CHARGE WHERE LC_LOAN_SYS_ID = ?";
		Object[] cursorC1Values = { getPT_IL_LOAN_BEAN().getLOAN_SYS_ID() };

		String queryCursorC2 = "SELECT POL_STATUS FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		Object[] cursorC2Values = { getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID() };

		Double M_VALUE = 0.0;
		String M_CODE_DESC = "";

		ResultSet rsCursor2 = null, rsCursor1 = null;

		try {
			rsCursor2 = getHandler().executeSelectStatement(queryCursorC2,
					CommonUtils.getConnection(), cursorC2Values);
			while (rsCursor2.next()) {
				getPT_IL_LOAN_BEAN().setUI_M_POL_STATUS(
						rsCursor2.getString("POL_STATUS"));
			}
			ArrayList<String> pValCodes = new DBProcedures()
					.helperPKG_PILT002$P_VAL_CODES("IL_LOAN_CODE",
							getPT_IL_LOAN_BEAN().getLOAN_CODE(),
							getPT_IL_LOAN_BEAN().getUI_M_LOAN_CODE_DESC(), "N",
							"N", "");
			getPT_IL_LOAN_BEAN().setUI_M_LOAN_CODE_DESC(pValCodes.get(0));

			if ("query_update".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", "IL_LNINT_DED");
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", "ID");
				OracleParameter param3 = new OracleParameter("inout1",
						"STRING", "IN OUT", M_CODE_DESC);
				OracleParameter param4 = new OracleParameter("in4", "STRING",
						"IN", "N");
				OracleParameter param5 = new OracleParameter("inout2",
						"STRING", "IN OUT", CommonUtils
								.getProcedureValue(M_VALUE));
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
						CommonUtils.getConnection(), "P_VAL_SYSTEM");
				System.out.println("The procedure executed******"
						+ ((OracleParameter) listP_VAL_SYSTEM.get(0))
								.getValue());
				M_CODE_DESC = ((OracleParameter) listP_VAL_SYSTEM.get(0))
						.getValue();
				M_VALUE = Double
						.parseDouble(((OracleParameter) listP_VAL_SYSTEM.get(1))
								.getValue());

				LD_SA_CURR_EXCHANGE_RATE1();

				rsCursor1 = getHandler().executeSelectStatement(queryCursorC1,
						CommonUtils.getConnection(), cursorC1Values);
				while (rsCursor1.next()) {
					
					System.out.println("setUI_M_LOAN_LC_CHARGE 1 : "+rsCursor1.getDouble(1));
					System.out.println("setUI_M_LOAN_FC_CHARGE 2 : "+rsCursor1.getDouble(2));
					
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_LC_CHARGE(
							rsCursor1.getDouble(1));
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_FC_CHARGE(
							rsCursor1.getDouble(2));
				}

				if (M_VALUE == 1) {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_AMOUNT(), 0)
									- MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getLOAN_LC_INTEREST(), 0)
									+ MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getUI_M_LOAN_LC_CHARGE(),
											0));
				} else {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_AMOUNT(), 0)
									- MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getUI_M_LOAN_LC_CHARGE(),
											0));
				}
				ArrayList<String> pValRound = new DBProcedures()
						.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
								.getUI_M_BASE_CURR(), CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_GR_LC_AMT()), "R");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
						Double.parseDouble(pValRound.get(0)));

				if (M_VALUE == 1) {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_AMOUNT(), 0)
									- MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getLOAN_FC_INTEREST(), 0)
									+ MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getUI_M_LOAN_FC_CHARGE(),
											0));
				} else {
					getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
							MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_AMOUNT(), 0)
									- MigratingFunctions.nvl(
											getPT_IL_LOAN_BEAN()
													.getUI_M_LOAN_FC_CHARGE(),
											0));
				}
				ArrayList<String> pValRound1 = new DBProcedures()
						.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
								.getLOAN_CURR_CODE(), CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getUI_M_LOAN_GR_FC_AMT()), "R");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
						Double.parseDouble(pValRound1.get(0)));
			}

		} catch (SQLException exc) {
			exc.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), FacesContext.getCurrentInstance(),
						"PT_IL_LOAN", this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rsCursor2);
				CommonUtils.closeCursor(rsCursor1);
				ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onLoad(PhaseEvent phaseEvent) {
		try {
			if (isBlockFlag()) {
				if (PT_IL_LOAN_BEAN.getROWID() == null) {

					whenCreateRecord();
				} else if (PT_IL_LOAN_BEAN.getROWID() != null) {

					executeSelectStatement();
					postQueryPtIlLoan();
					whenNewRecordInstance();
					
					/*Added by saritha on 11-01-2019 for KIC LoanTerm Type &Rate Per values reseting*/
					
					if(PT_IL_LOAN_BEAN.getLOAN_FLEX_17()!=null && PT_IL_LOAN_BEAN.getLOAN_FLEX_17().equalsIgnoreCase("U")){
						COMP_LOAN_INT_RATE_PER.setDisabled(false);

					}
					
					/*End*/

				}
				preForm(phaseEvent);
				setBlockFlag(false);
			}
	
			if ("A".equalsIgnoreCase(PT_IL_LOAN_BEAN.getLOAN_STATUS())) {
				PT_IL_LOAN_BEAN.setUI_M_APPRV_STATUS("Approved");
				this.COMP_UI_M_BUT_APPRV.setDisabled(true);
				COMP_UI_M_BUT_REPAYMENT.setDisabled(false);
				disableAllComponent(true);
			} else if ("C".equalsIgnoreCase(PT_IL_LOAN_BEAN.getLOAN_STATUS())) {
				PT_IL_LOAN_BEAN.setUI_M_APPRV_STATUS("Closed");
				this.COMP_UI_M_BUT_APPRV.setDisabled(true);
				COMP_UI_M_BUT_REPAYMENT.setDisabled(false);
				disableAllComponent(true);
			} else {
				PT_IL_LOAN_BEAN.setUI_M_APPRV_STATUS("Not Approved");
				this.COMP_UI_M_BUT_APPRV.setDisabled(false);
				COMP_UI_M_LOAN_FC_CHARGE.setDisabled(false);
				COMP_UI_M_LOAN_LC_CHARGE.setDisabled(false);
				COMP_LOAN_FC_UNPAID_PREM.setDisabled(false);
				COMP_LOAN_LC_UNPAID_PREM.setDisabled(false);
				COMP_LOAN_FC_OS_AMOUNT.setDisabled(false);
				COMP_LOAN_LC_OS_AMOUNT.setDisabled(false);
				COMP_LOAN_FC_NET_AMOUNT.setDisabled(false);
				COMP_LOAN_LC_NET_AMOUNT.setDisabled(false);
				
				// Added By Dhinesh for the following ssp call id - FALCONQC-1717177
				COMP_UI_M_BUT_REPAYMENT.setDisabled(true); 
				// END ssp call id - FALCONQC-1717177
				
			}
			COMP_LOAN_FC_UNPAID_PREM.resetValue();
			COMP_LOAN_LC_UNPAID_PREM.resetValue();
			COMP_LOAN_FC_UNPAID_PREM_INT.resetValue();
			COMP_LOAN_LC_UNPAID_PREM_INT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}

	}

	/**
	 * Disables all components in PT_IL_LOAN_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		// Newly added BY DHIENSH on 19.2.2017	
				COMP_LOAN_FLEX_17.setDisabled(disabled);
				//END
		COMP_LOAN_UNPAID_PREM_INT_CODE.setDisabled(disabled);
		COMP_LOAN_TERM.setDisabled(disabled);
		COMP_LOAN_CODE.setDisabled(disabled);
		COMP_LOAN_POL_NO.setDisabled(disabled);
		COMP_LOAN_SURR_PERC.setDisabled(disabled);
		COMP_LOAN_REF_NO.setDisabled(disabled);
		COMP_LOAN_FC_PERM_AMT.setDisabled(disabled);
		COMP_LOAN_FC_AMOUNT.setDisabled(disabled);
		COMP_LOAN_INT_RATE.setDisabled(disabled);
		COMP_LOAN_FC_INTEREST.setDisabled(disabled);
		COMP_UI_M_LOAN_FC_CHARGE.setDisabled(disabled);
		COMP_UI_M_LOAN_GR_FC_AMT.setDisabled(disabled);
		COMP_LOAN_FC_UNPAID_PREM.setDisabled(disabled);
		COMP_LOAN_FC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_LOAN_FC_OS_AMOUNT.setDisabled(disabled);
		COMP_LOAN_FC_OS_LOAN_INT.setDisabled(disabled);
		COMP_LOAN_FC_NET_AMOUNT.setDisabled(disabled);
		COMP_LOAN_FC_REPAY_AMT.setDisabled(disabled);
		COMP_UI_M_LOAN_CODE_DESC.setDisabled(disabled);
		COMP_LOAN_LC_PERM_AMT.setDisabled(disabled);
		COMP_LOAN_LC_AMOUNT.setDisabled(disabled);
		COMP_LOAN_INT_RATE_PER.setDisabled(disabled);
		COMP_LOAN_LC_INTEREST.setDisabled(disabled);
		COMP_UI_M_LOAN_LC_CHARGE.setDisabled(disabled);
		COMP_UI_M_LOAN_GR_LC_AMT.setDisabled(disabled);
		COMP_LOAN_LC_UNPAID_PREM.setDisabled(disabled);
		COMP_LOAN_LC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_LOAN_LC_OS_AMOUNT.setDisabled(disabled);
		COMP_LOAN_LC_OS_LOAN_INT.setDisabled(disabled);
		COMP_LOAN_LC_NET_AMOUNT.setDisabled(disabled);
		COMP_LOAN_LC_REPAY_AMT.setDisabled(disabled);
		COMP_LOAN_CURR_CODE.setDisabled(disabled);
		COMP_LOAN_EXCH_RATE.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_LOAN_REPAY_FREQ.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_LOAN_DT.setDisabled(disabled);
		COMP_LOAN_DUE_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_LOAN_LOV_BUTTON.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_INT_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_RECAL.setDisabled(disabled);
		COMP_UI_M_BUT_CHARGE.setDisabled(disabled);
		// COMP_UI_M_BUT_REPAYMENT.setDisabled(disabled);
		COMP_UI_M_BUT_APPRV.setDisabled(disabled);
		COMP_UI_M_BUT_LOV_POL_NO.setDisabled(disabled);
		PREFORMBUTTON.setDisabled(disabled);
		
		/*Newly Added by saritha on 25-Jan-2018 for fields disabled*/
		COMP_LOAN_FREQ_TYPE.setDisabled(disabled);
		COMP_TYPE.setDisabled(disabled);
		COMP_MICR_CODE.setDisabled(disabled);
		COMP_ACC_NO.setDisabled(disabled);
		/*End*/
		
	}

	public void preForm(PhaseEvent ae) throws Exception {
		//commented by Agalya for error message display in Loan Screen on 08-07-2016 ,ref no- FALCONQC-1714734 
		/*CommonUtils.clearMaps(this);*/
		//end
		
		// String currBaseCurrQuery = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE
		// PARA_ID = 'BASE.CURR'";
		//As dicussed with siva sir below query changed by gopi on 04/01/2019
		/*String currBuySell = "SELECT DS_CURR_RATE_BS FROM PM_IL_DOC_SETUP "
				+ "WHERE DS_TYPE = '1' AND DS_CODE = ?";*/
		String currBuySell = "SELECT DS_CURR_RATE_BS FROM PM_IL_DOC_SETUP "
				+ "WHERE DS_TYPE = '5' AND DS_CODE = ?";
		Object[] query_BuySellValues = { CommonUtils
				.getGlobalObject("GLOBAL.M_PARAM_1") };
		System.out.println("PT_IL_LOAN_ACTION.preForm()");
		currentMode = CommonUtils.getGlobalVariable("PILT004_MODE");
		ResultSet rsCurrBase = null, rsCurrBuySell = null;
		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures dbProcedures = new DBProcedures();
		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, Object> session = context.getExternalContext()
					.getSessionMap();
			session = FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap();
			System.out.println("(String)session.get(CALLING_FORM): "
					+ (String) session.get("CALLING_FORM"));
			if ("".equals((String) session.get("CALLING_FORM"))) {
				// session.put("GLOBAL.M_PRIVILEGE", "YYY");
				session.put("GLOBAL.M_FAILURE", "FALSE");
				// session.put("GLOBAL.M_USER_ID",
				// CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				// session.put("GLOBAL.M_LANG_CODE", "ENG");
				// session.put("GLOBAL.M_PARA_1", " ");
				// session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
				// session.put("GLOBAL.M_MODULE_NAME", "PILM055_APAC");
			}
			// STD_PRE_FORM();

			// String GLOBAL_M_USER_ID= "PREMIA";

			// String GLOBAL_M_USER_ID=
			// CommonUtils.getControlBean().getM_USER_ID();
			// String BASE_CURR = "";
			CommonUtils.setGlobalObject("GLOBAL.M_LOAN_SYS_ID", null);
			CommonUtils.setGlobalObject("GLOBAL.M_POL_NO", null);

			// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
			ArrayList<String> list = dbProcedures.helperF_GET_BASE_CURRENCY(
					CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N",
					P_CURR_CODE, P_NAME, P_DECIMAL + "", "E");
			if (list != null && list.size() > 0) {
				P_CURR_CODE = list.get(0);
				P_NAME = list.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list.get(2));
				getPT_IL_LOAN_BEAN().setUI_M_BASE_CURR(P_CURR_CODE);
			}
			// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
			// Commented for Validating F_GET_BASE_CURRENCY : Added by Shankar
			// Bodduluri : 20-04-2009
			// String currBaseCurrQuery = "SELECT PARA_VALUE FROM FP_PARAMETER
			// WHERE PARA_ID = '"+ P_CURR_CODE +"'";
			/*
			 * rsCurrBase =
			 * getHandler().executeSelectStatement(currBaseCurrQuery,
			 * CommonUtils.getConnection()); while(rsCurrBase.next()){
			 * getPT_IL_LOAN_BEAN().setUI_M_BASE_CURR(rsCurrBase.getString("PARA_VALUE")) ; }
			 */

			rsCurrBuySell = getHandler().executeSelectStatement(currBuySell,
					CommonUtils.getConnection(), query_BuySellValues);
			while (rsCurrBuySell.next()) {
				getPT_IL_LOAN_BEAN().setUI_M_BUY_SELL(
						rsCurrBuySell.getString("DS_CURR_RATE_BS"));
			}

			// LD_P_SET_LC_FORMAT

			getPT_IL_LOAN_BEAN().setUI_PT_IL_LOAN_CF("N");
			getPT_IL_LOAN_BEAN().setUI_PT_IL_LOAN_CHARGE_CF("N");
			// getPT_IL_LOAN_BEAN().setUI_M_POL_SYS_ID(null);

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					CommonUtils.getControlBean().getM_USER_ID());
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					CommonUtils.getControlBean().getM_COMP_CODE());
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
					CommonUtils.getControlBean().getM_DIVN_CODE());
			OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
					CommonUtils.getControlBean().getM_DEPT_CODE());
			OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
					"");
			OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
					"");
			OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
					"ILIFE");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);
			paramList.add(param7);
			paramList.add(param8);
			paramList.add(param9);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			CommonUtils.setGlobalObject("GLOBAL.M_LOAN_SYS_ID", null);
			/*
			 * CommonUtils.setGlobalVariable("PILT004_BASE_CURR", BASE_CURR);
			 * CommonUtils.setGlobalVariable("PILT004_GLOBAL_M_USER_ID",
			 * GLOBAL_M_USER_ID);
			 * 
			 * loadValues();
			 * 
			 * getCOMP_status().setValue(statusValue);
			 * PT_IL_LOAN_BEAN.setUI_M_APPRV_STATUS(statusValue);
			 * if("Approved".equalsIgnoreCase(statusValue)){
			 * System.out.println("APPROVED******************************in
			 * PreForm"); getAllFieldsDisabled(true);
			 * setComponentDisableStatus(true);
			 * getCOMP_UI_M_BUT_REPAYMENT().setDisabled(false); }else{
			 * //getAllFieldsDisabled(false);
			 * getCOMP_LOAN_FC_PERM_AMT().setDisabled(true);
			 * getCOMP_LOAN_LC_PERM_AMT().setDisabled(true);
			 * getCOMP_LOAN_FC_INTEREST().setDisabled(true);
			 * getCOMP_LOAN_LC_INTEREST().setDisabled(true);
			 * getCOMP_UI_M_LOAN_LC_CHARGE().setDisabled(true);
			 * getCOMP_UI_M_LOAN_FC_CHARGE().setDisabled(true);
			 * getCOMP_UI_M_LOAN_GR_FC_AMT().setDisabled(true);
			 * getCOMP_UI_M_LOAN_GR_LC_AMT().setDisabled(true);
			 * getCOMP_LOAN_FC_OS_AMOUNT().setDisabled(true);
			 * getCOMP_LOAN_FC_OS_LOAN_INT().setDisabled(true);
			 * getCOMP_LOAN_LC_OS_AMOUNT().setDisabled(true);
			 * getCOMP_LOAN_LC_OS_LOAN_INT().setDisabled(true);
			 * getCOMP_LOAN_LC_NET_AMOUNT().setDisabled(true);
			 * getCOMP_LOAN_FC_NET_AMOUNT().setDisabled(true);
			 * getCOMP_LOAN_FC_UNPAID_PREM().setDisabled(true);
			 * getCOMP_LOAN_LC_UNPAID_PREM().setDisabled(true); }
			 * 
			 * String cursorC1 = "SELECT
			 * POL_SYS_ID,POL_CUST_CURR_CODE,POL_DIVN_CODE,POL_START_DT,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR,POL_NO_YRS_PREM_PAID,POL_STATUS,POL_SA_CURR_CODE,POL_PROD_CODE
			 * FROM PT_IL_POLICY WHERE POL_NO = ?"; try { PreparedStatement psmt =
			 * CommonUtils.getConnection().prepareStatement(cursorC1);
			 * System.out.println("preform POLNO" +
			 * PT_IL_LOAN_BEAN.getLOAN_POL_NO()); psmt.setString(1,
			 * PT_IL_LOAN_BEAN.getLOAN_POL_NO());
			 * if(PT_IL_LOAN_BEAN.getLOAN_POL_NO()==null){}else{ ResultSet rs =
			 * psmt.executeQuery(); while(rs.next()){ M_NO_YRS_PREM_PAID =
			 * rs.getDouble("POL_NO_YRS_PREM_PAID"); M_POL_SA_CURR_CODE =
			 * rs.getString("POL_SA_CURR_CODE");
			 * CommonUtils.setGlobalVariable("PILT004_M_NO_YRS_PREM_PAID",
			 * String.valueOf(M_NO_YRS_PREM_PAID));
			 * CommonUtils.setGlobalVariable("PILT004_M_POL_SA_CURR_CODE",
			 * M_POL_SA_CURR_CODE); }
			 * 
			 * 
			 * //COMP_LOAN_EXCH_RATE String LOAN_EXCH_RATE_query = "SELECT
			 * CER_BUY_EXGE_RATE FROM FM_EXCHANGE_RATE WHERE CER_CURR_CODE = ?";
			 * PreparedStatement psmt1 =
			 * CommonUtils.getConnection().prepareStatement(LOAN_EXCH_RATE_query);
			 * psmt1.setString(1,M_POL_SA_CURR_CODE); ResultSet rs2 =
			 * psmt1.executeQuery();
			 * 
			 * while (rs2.next()) { P_LOAN_EXCH_RATE =
			 * Double.valueOf(rs2.getString("CER_BUY_EXGE_RATE")); }
			 * CommonUtils.setGlobalVariable("PILT004_M_POL_LOAN_EXCH_RATE",
			 * String.valueOf(P_LOAN_EXCH_RATE)); }
			 * 
			 * System.out.println("PREFORM>>>>>>>>>>>>>>>>>>>>>");
			 * System.out.println("M_NO_YRS_PREM_PAID" + M_NO_YRS_PREM_PAID);
			 * System.out.println("P_LOAN_EXCH_RATE" + P_LOAN_EXCH_RATE);
			 * System.out.println("M_POL_SA_CURR_CODE" + M_POL_SA_CURR_CODE);
			 * System.out.println("PREFORM>>>>>>>>>>>>>>>>>>>>>");
			 * 
			 * 
			 * }catch(Exception ex){ ex.printStackTrace(); }
			 */

			PREFORMBUTTON.setDisabled(true);
			preRecord();
			whenNewRecordInstance();
			if ("insert".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				whenCreateRecord();
			}
			System.out.println("After PRE-Form");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				CommonUtils.closeCursor(rsCurrBase);
				CommonUtils.closeCursor(rsCurrBuySell);
				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Instantiates all components in PT_IL_LOAN_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_LOAN_FLEX_17 = new HtmlSelectOneMenu(); // Newly Added by Dhinesh on 20.2.2017
		COMP_LOAN_UNPAID_PREM_INT_CODE = new HtmlInputText();
		COMP_LOAN_TERM = new HtmlInputText();
		COMP_LOAN_CODE = new HtmlInputText();
		COMP_LOAN_POL_NO = new HtmlInputText();
		COMP_LOAN_SURR_PERC = new HtmlInputText();
		COMP_LOAN_REF_NO = new HtmlInputText();
		COMP_LOAN_FC_PERM_AMT = new HtmlInputText();
		COMP_LOAN_FC_AMOUNT = new HtmlInputText();
		COMP_LOAN_INT_RATE = new HtmlInputText();
		COMP_LOAN_FC_INTEREST = new HtmlInputText();
		COMP_UI_M_LOAN_FC_CHARGE = new HtmlInputText();
		COMP_UI_M_LOAN_GR_FC_AMT = new HtmlInputText();
		COMP_LOAN_FC_UNPAID_PREM = new HtmlInputText();
		COMP_LOAN_FC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_LOAN_FC_OS_AMOUNT = new HtmlInputText();
		COMP_LOAN_FC_OS_LOAN_INT = new HtmlInputText();
		COMP_LOAN_FC_NET_AMOUNT = new HtmlInputText();
		COMP_LOAN_FC_REPAY_AMT = new HtmlInputText();
		COMP_UI_M_LOAN_CODE_DESC = new HtmlInputText();
		COMP_LOAN_LC_PERM_AMT = new HtmlInputText();
		COMP_LOAN_LC_AMOUNT = new HtmlInputText();
		COMP_LOAN_INT_RATE_PER = new HtmlInputText();
		COMP_LOAN_LC_INTEREST = new HtmlInputText();
		COMP_UI_M_LOAN_LC_CHARGE = new HtmlInputText();
		COMP_UI_M_LOAN_GR_LC_AMT = new HtmlInputText();
		COMP_LOAN_LC_UNPAID_PREM = new HtmlInputText();
		COMP_LOAN_LC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_LOAN_LC_OS_AMOUNT = new HtmlInputText();
		COMP_LOAN_LC_OS_LOAN_INT = new HtmlInputText();
		COMP_LOAN_LC_NET_AMOUNT = new HtmlInputText();
		COMP_LOAN_LC_REPAY_AMT = new HtmlInputText();
		COMP_LOAN_CURR_CODE = new HtmlInputText();
		COMP_LOAN_EXCH_RATE = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_LOAN_REPAY_FREQ = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_LOAN_DT = new HtmlCalendar();
		COMP_LOAN_DUE_DT = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_LOAN_LOV_BUTTON = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_INT_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_RECAL = new HtmlCommandButton();
		COMP_UI_M_BUT_CHARGE = new HtmlCommandButton();
		COMP_UI_M_BUT_REPAYMENT = new HtmlCommandButton();
		COMP_UI_M_BUT_APPRV = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_POL_NO = new HtmlCommandButton();
		PREFORMBUTTON = new HtmlCommandButton();

		COMP_TYPE = new HtmlSelectOneMenu();
		COMP_MICR_CODE = new HtmlInputText();
		COMP_ACC_NO = new HtmlInputText();

	}

	private void getAllFieldsDisabled(boolean status) {
		getCOMP_LOAN_POL_NO().setDisabled(status);
		getCOMP_LOAN_DT().setDisabled(status);
		getCOMP_LOAN_SURR_PERC().setDisabled(status);
		getCOMP_LOAN_REF_NO().setDisabled(status);
		getCOMP_LOAN_FC_PERM_AMT().setDisabled(status);
		getCOMP_LOAN_FC_AMOUNT().setDisabled(status);
		getCOMP_LOAN_REPAY_FREQ().setDisabled(status);
		getCOMP_LOAN_DUE_DT().setDisabled(status);
		getCOMP_LOAN_INT_RATE().setDisabled(status);
		getCOMP_LOAN_FC_INTEREST().setDisabled(status);
		getCOMP_UI_M_LOAN_FC_CHARGE().setDisabled(status);
		getCOMP_UI_M_LOAN_GR_FC_AMT().setDisabled(status);
		getCOMP_LOAN_FC_UNPAID_PREM().setDisabled(status);
		getCOMP_LOAN_FC_UNPAID_PREM_INT().setDisabled(status);
		getCOMP_LOAN_FC_OS_AMOUNT().setDisabled(status);
		getCOMP_LOAN_FC_OS_LOAN_INT().setDisabled(status);
		getCOMP_LOAN_FC_NET_AMOUNT().setDisabled(status);
		getCOMP_LOAN_FC_REPAY_AMT().setDisabled(status);
		getCOMP_LOAN_FC_PERM_AMT().setDisabled(status);
		getCOMP_LOAN_LC_PERM_AMT().setDisabled(status);
		getCOMP_LOAN_LC_AMOUNT().setDisabled(status);
		getCOMP_LOAN_INT_RATE_PER().setDisabled(status);
		getCOMP_LOAN_LC_INTEREST().setDisabled(status);
		getCOMP_UI_M_LOAN_LC_CHARGE().setDisabled(status);
		getCOMP_UI_M_LOAN_GR_LC_AMT().setDisabled(status);
		getCOMP_LOAN_LC_UNPAID_PREM().setDisabled(status);
		getCOMP_LOAN_LC_UNPAID_PREM_INT().setDisabled(status);
		getCOMP_LOAN_LC_OS_LOAN_INT().setDisabled(status);
		getCOMP_LOAN_LC_NET_AMOUNT().setDisabled(status);
		getCOMP_LOAN_LC_REPAY_AMT().setDisabled(status);
		getCOMP_LOAN_CURR_CODE().setDisabled(status);
		getCOMP_LOAN_EXCH_RATE().setDisabled(status);
		getCOMP_UI_M_BUT_APPRV().setDisabled(status);
		// Newly added below code on 19.2.2017	
				getCOMP_LOAN_FLEX_17().setDisabled(status);
	}

	// public void whenNewRecordInstance(int LOAN_SYS_ID, PT_IL_LOAN valueBean){
	public void whenNewRecordInstance() throws Exception {
		String M_LOAN_STATUS = "";
		String cursorC1 = "SELECT NVL(SUM(LC_LC_VALUE),0), NVL(SUM(LC_FC_VALUE),0) "
				+ "FROM PT_IL_LOAN_CHARGE WHERE LC_LOAN_SYS_ID = ?";
		Object[] cursorC1Values = { getPT_IL_LOAN_BEAN().getLOAN_SYS_ID() };

		String cursorC2 = "SELECT NVL(LOAN_STATUS,'N') FROM PT_IL_LOAN WHERE LOAN_SYS_ID = ?";
		Object[] cursorC2Values = { getPT_IL_LOAN_BEAN().getLOAN_SYS_ID() };
		ResultSet rsCursor2 = null, rsCursor1 = null;
		Connection con = null;
		System.out.println("PT_IL_LOAN_ACTION.whenNewRecordInstance()------>"
				+ LOAN_SYS_ID);
		// getCOMP_LOAN_REF_NO().setDisabled(true);
		// getCOMP_LOAN_REF_NO().setRendered(true);

		try {
			fetchDetails();
			rsCursor2 = getHandler().executeSelectStatement(cursorC2,
					CommonUtils.getConnection(), cursorC2Values);
			while (rsCursor2.next()) {
				System.out
						.println("I am in when new record instance resultset 2");
				M_LOAN_STATUS = rsCursor2.getString(1);
			}
			System.out.println("Heloooooooooo");
			if ("query_update".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				System.out
						.println("CommonUtils.getGlobalVariable(GLOBAL.PILT004_MODE)"
								+ CommonUtils
										.getGlobalVariable("GLOBAL.PILT004_MODE"));
				LD_SA_CURR_EXCHANGE_RATE1();
				System.out.println("After LD_SA_CURR_EXCHANGE_RATE1");
				if (getPT_IL_LOAN_BEAN().getLOAN_STATUS() != null) {
					if (!"N".equalsIgnoreCase(getPT_IL_LOAN_BEAN()
							.getLOAN_STATUS())) {
						setCompUiMButRecalDisabled(true);
					} else {
						setCompUiMButRecalDisabled(false);
					}
				}
			} else {
				setCompUiMButRecalDisabled(true);
			}
			Map m = getSessionMap();
			PT_IL_LOAN_CHARGE_ACTION ptIlLoanChargeAction = (PT_IL_LOAN_CHARGE_ACTION) m
					.get("PILT004_PT_IL_LOAN_CHARGE_ACTION");

			if ("query_update".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				if ("A".equalsIgnoreCase(MigratingFunctions.nvl(M_LOAN_STATUS,
						"N"))
						|| "C".equalsIgnoreCase(MigratingFunctions.nvl(
								M_LOAN_STATUS, "N"))) {
					setCompUiMButRepaymentDisabled(false);
					ptIlLoanBlockDisabled(true);
					setBlockDeleteAllowed(false);
					/*
					 * ptIlLoanChargeAction.setInsertAllowed(false);
					 * ptIlLoanChargeAction.setUpdateAllowed(false);
					 * ptIlLoanChargeAction.setDeleteAllowed(false);
					 */
				} else {
					setCompUiMButRepaymentDisabled(true);
					ptIlLoanBlockDisabled(false);
					setBlockDeleteAllowed(true);
					/*
					 * ptIlLoanChargeAction.setInsertAllowed(true);
					 * ptIlLoanChargeAction.setUpdateAllowed(true);
					 * ptIlLoanChargeAction.setDeleteAllowed(true);
					 */
				}
			} else {
				setCompUiMButRepaymentDisabled(true);
			}

			if ("query_update".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				LD_SA_CURR_EXCHANGE_RATE1();
			} else {
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_1("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_2("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_3("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_4("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_5("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_6("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_7("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_8("");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_9("");
			}

			if ("query_update".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				if (getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE().equalsIgnoreCase(
						getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR())) {
					setCompLoanExchRateDisabled(true);
				} else {
					// setCompLoanExchRateReadOnly(false);
					setCompLoanExchRateDisabled(false);
				}

				if ("N".equalsIgnoreCase(MigratingFunctions.nvl(M_LOAN_STATUS,
						"N"))) {
					setCompUiMButApprvDisabled(false);
				} else {
					setCompUiMButApprvDisabled(true);
				}
			} else {
				setCompUiMButApprvDisabled(false);
			}

			if ("query_update".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.PILT004_MODE"))) {
				if ("A".equalsIgnoreCase(M_LOAN_STATUS)
						|| "C".equalsIgnoreCase(M_LOAN_STATUS)) {
					setCompApprStatusRendered(true);
				} else {
					setCompApprStatusRendered(false);
				}
			} else {
				setCompApprStatusRendered(false);
			}

			rsCursor1 = getHandler().executeSelectStatement(cursorC1,
					CommonUtils.getConnection(), cursorC1Values);
			while (rsCursor1.next()) {
				
				System.out.println("setUI_M_LOAN_LC_CHARGE 5 : "+rsCursor1.getDouble(1));
				System.out.println("setUI_M_LOAN_FC_CHARGE 6 : "+rsCursor1.getDouble(2));
				
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_LC_CHARGE(
						rsCursor1.getDouble(1));
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_FC_CHARGE(
						rsCursor1.getDouble(2));
			}
			L_SET_UNPAID_INT_PROPERTY();
			setCompLoanFcUnpaidPremDisabled(false);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			// throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rsCursor1);
				CommonUtils.closeCursor(rsCursor2);
				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_SET_UNPAID_INT_PROPERTY() {
		if ("N".equalsIgnoreCase(MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
				.getLOAN_STATUS(), "N"))) {
			if (MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
					.getLOAN_LC_UNPAID_PREM(), 0) != 0) {
				setCompLoanUnpaidPremIntCodeDisabled(false);
				setCompLoanFcUnpaidPremIntDisabled(false);
				setCompLoanLcUnpaidPremIntDisabled(false);
			} else {
				setCompLoanUnpaidPremIntCodeDisabled(true);
				setCompLoanFcUnpaidPremIntDisabled(true);
				setCompLoanLcUnpaidPremIntDisabled(true);
			}
		}
	}

	public void preRecord() {
		Double M_VALUE = 0.0;
		try {
			getPT_IL_LOAN_BEAN().setUI_M_APPRV_STATUS("");
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					"IL_LOAN_ST");
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
							.getLOAN_STATUS(), "N"));
			OracleParameter param3 = new OracleParameter("inout1", "STRING",
					"IN OUT", getPT_IL_LOAN_BEAN().getUI_M_APPRV_STATUS());
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					"N");
			OracleParameter param5 = new OracleParameter("inout2", "STRING",
					"IN OUT", "");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList listP_VAL_SYSTEM1 = procHandler.execute(paramList,
					CommonUtils.getConnection(), "P_VAL_SYSTEM");
			System.out.println("In preRecord 11111"
					+ ((OracleParameter) listP_VAL_SYSTEM1.get(0)).getValue());
			getPT_IL_LOAN_BEAN().setUI_M_APPRV_STATUS(
					((OracleParameter) listP_VAL_SYSTEM1.get(0)).getValue());
			if (((OracleParameter) listP_VAL_SYSTEM1.get(0)).getValue() != null) {
				M_VALUE = Double
						.parseDouble(((OracleParameter) listP_VAL_SYSTEM1
								.get(1)).getValue());
			}
			System.out.println("The value of M_VALUE is: " + M_VALUE);

			ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
			OracleParameter param11 = new OracleParameter("in1", "STRING",
					"IN", "IL_LOAN_ST");
			OracleParameter param21 = new OracleParameter("in2", "STRING",
					"IN", MigratingFunctions.nvl(getPT_IL_LOAN_BEAN()
							.getLOAN_FLAG(), "N"));
			OracleParameter param31 = new OracleParameter("inout1", "STRING",
					"IN OUT", getPT_IL_LOAN_BEAN().getUI_M_LOAN_STATUS());
			OracleParameter param41 = new OracleParameter("in4", "STRING",
					"IN", "N");
			OracleParameter param51 = new OracleParameter("inout2", "STRING",
					"IN OUT", CommonUtils.getProcedureValue(M_VALUE));
			paramList1.add(param11);
			paramList1.add(param21);
			paramList1.add(param31);
			paramList1.add(param41);
			paramList1.add(param51);
			OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
			ArrayList listP_VAL_SYSTEM2 = procHandler1.execute(paramList1,
					CommonUtils.getConnection(), "P_VAL_SYSTEM");
			System.out.println("In preRecord 22222222"
					+ ((OracleParameter) listP_VAL_SYSTEM2.get(0)).getValue());
			getPT_IL_LOAN_BEAN().setUI_M_LOAN_STATUS(
					((OracleParameter) listP_VAL_SYSTEM2.get(0)).getValue());
			if (((OracleParameter) listP_VAL_SYSTEM2.get(1)).getValue() != null) {
				M_VALUE = Double
						.parseDouble(((OracleParameter) listP_VAL_SYSTEM2
								.get(1)).getValue());
			} else {
				M_VALUE = 0.0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void whenCreateRecord() {
		String queryCurrC1 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_LOAN_MX'";
		Double M_PERC = 0.0;
		getPT_IL_LOAN_BEAN().setLOAN_REPAY_FREQ("H");
		ResultSet rsCursor1 = null;
		try {
			PT_IL_LOAN_BEAN.setLOAN_DT(new CommonUtils().getCurrentDate());
			rsCursor1 = getHandler().executeSelectStatement(queryCurrC1,
					CommonUtils.getConnection());
			while (rsCursor1.next()) {
				M_PERC = rsCursor1.getDouble("PS_VALUE");
				
				//getPT_IL_LOAN_BEAN().setLOAN_SURR_PERC(M_PERC);
				//getCOMP_LOAN_SURR_PERC().resetValue();
			}
			PT_IL_LOAN_BEAN.setLOAN_TERM(1);
			PT_IL_LOAN_BEAN.setLOAN_FLEX_04("OTHERS");
			
			/* Newly added by dhinesh on 03-03-2017 for loan frequency type value default interest. */
			
			getPT_IL_LOAN_BEAN().setLOAN_FREQ_TYPE("I");
			
			/******************* End *********************/ 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * Double M_LOAN_LC_CHARGE = null; Double M_LOAN_FC_CHARGE = null;
	 * 
	 * 
	 * try {
	 * 
	 * con = CommonUtils.getConnection(); PreparedStatement psmt =
	 * con.prepareStatement(cursorC1); psmt.setInt(1, LOAN_SYS_ID);
	 * 
	 * ResultSet rs = psmt.executeQuery(); while(rs.next()){ M_LOAN_LC_CHARGE =
	 * rs.getDouble(1); M_LOAN_FC_CHARGE = rs.getDouble(2); } rs.close();
	 * 
	 * 
	 * PreparedStatement psmt1 = con.prepareStatement(cursorC2); psmt1.setInt(1,
	 * LOAN_SYS_ID);
	 * 
	 * ResultSet rs1 = psmt1.executeQuery(); while(rs1.next()){ M_LOAN_STATUS =
	 * rs1.getString(1); } rs.close(); rs1.close();
	 * 
	 * if("".equals(M_LOAN_STATUS)){ M_LOAN_STATUS="N";
	 * COMP_UI_M_BUT_APPRV.setDisabled(false); } System.out.println(); ArrayList<OracleParameter>
	 * pList1 = new ArrayList<OracleParameter>(); ArrayList<OracleParameter>
	 * oList1 = new ArrayList<OracleParameter>(); OracleParameter p1 = new
	 * OracleParameter("IN1", "STRING", "IN","IL_LOAN_ST"); pList1.add(p1);
	 * OracleParameter p2 = new OracleParameter("IN2", "STRING",
	 * "IN",M_LOAN_STATUS); pList1.add(p2); OracleParameter p3 = new
	 * OracleParameter("IN3", "STRING", "IN OUT",""); pList1.add(p3);
	 * OracleParameter p4 = new OracleParameter("IN4", "STRING", "IN","N");
	 * pList1.add(p4); OracleParameter p5 = new OracleParameter("IN5", "STRING",
	 * "IN OUT",""); pList1.add(p5);
	 * 
	 * 
	 * OracleProcedureHandler pHandler1 = new OracleProcedureHandler(); oList1 =
	 * pHandler1.execute(pList1, con,"P_VAL_SYSTEM"); for (Iterator iterator2 =
	 * oList1.iterator(); iterator2.hasNext();) { OracleParameter name =
	 * (OracleParameter) iterator2.next();
	 * if(name.getFieldName().equals("IN3")){
	 * System.out.println("IN3------------------------------" +
	 * name.getValue()); statusValue = name.getValue(); //
	 * getPT_IL_LOAN_BEAN().setUI_M_APPRV_STATUS(statusValue); }
	 * 
	 * if(name.getFieldName().equals("IN5")){
	 * System.out.println("IN3------------------------------" +
	 * name.getValue()); } }
	 * 
	 * if(M_LOAN_STATUS.equals("N")){ COMP_UI_M_BUT_APPRV.setDisabled(false);
	 * }else{ COMP_UI_M_BUT_APPRV.setDisabled(true); }
	 * 
	 * LD_SA_CURR_EXCHANGE_RATE1(valueBean.getLOAN_POL_NO()); } catch (Exception
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 */

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public List LovActionForLoanCode(Object object) {
		List lovList = new ArrayList();
		if ("*".equals(object)) {
			try {
				Connection con = CommonUtils.getConnection();
				PreparedStatement psmt = con
						.prepareStatement(lovQuery_LoanCode);
				ResultSet rs = psmt.executeQuery();

				while (rs.next()) {
					PT_IL_LOAN_LOV lovbox = new PT_IL_LOAN_LOV();

					lovbox.setPC_CODE(rs.getString(1));
					lovbox.setPC_DESC(rs.getString(2));
					lovList.add(lovbox);

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return lovList;

		}
		return lovList;

	}

	public List LovActionForPOLNO(Object object) {
		List lovList = new ArrayList();
		if ("*".equals(object)) {
			try {
				Connection con = CommonUtils.getConnection();
				PreparedStatement psmt = con.prepareStatement(lovQuery_Polno);
				ResultSet rs = psmt.executeQuery();

				while (rs.next()) {

					PT_IL_LOAN_POLNO_LOV lovbox = new PT_IL_LOAN_POLNO_LOV();
					lovbox.setPOL_NO(rs.getString("POL_NO"));
					lovbox.setIssueDt(rs.getString("ISSUE_DT"));
					lovList.add(lovbox);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return lovList;

		}
		return lovList;

	}

	public ArrayList<LovBean> lovPOL_NO(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = "SELECT POL_NO,TO_CHAR(POL_ISSUE_DT) AS ISSUE_DT   FROM PT_IL_POLICY "
						+ "WHERE NVL(POL_STATUS,'N') IN ('A', 'E','R')AND "
						+ "NVL(POL_NO_YRS_PREM_PAID,0) >= (SELECT PLAN_SURR_YRS FROM PM_IL_PLAN "
						+ "WHERE PLAN_CODE = POL_PLAN_CODE) AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND ROWNUM < ? ORDER BY 1";
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
				 * 
				 * query = "SELECT POL_NO,TO_CHAR(POL_ISSUE_DT) AS ISSUE_DT   FROM PT_IL_POLICY "
						+ "WHERE NVL(POL_STATUS,'N') IN ('A', 'E','R')AND "
						+ "NVL(POL_NO_YRS_PREM_PAID,0) >= (SELECT PLAN_SURR_YRS FROM PM_IL_PLAN "
						+ "WHERE PLAN_CODE = POL_PLAN_CODE) AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' "
						+ "AND (POL_NO LIKE ? OR POL_ISSUE_DT LIKE ?) AND ROWNUM < ? ORDER BY 1";*/
				/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
				query = "SELECT POL_NO,TO_CHAR(POL_ISSUE_DT) AS ISSUE_DT   FROM PT_IL_POLICY "
						+ "WHERE NVL(POL_STATUS,'N') IN ('A', 'E','R')AND "
						+ "NVL(POL_NO_YRS_PREM_PAID,0) >= (SELECT PLAN_SURR_YRS FROM PM_IL_PLAN "
						+ "WHERE PLAN_CODE = POL_PLAN_CODE) AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' "
						+ "AND (UPPER(POL_NO) LIKE UPPER(?) OR UPPER(POL_ISSUE_DT) LIKE UPPER(?)) AND ROWNUM < ? ORDER BY 1";
				/*end*/
			
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovLOAN_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_LOAN_CODE' AND  "
						+ "NVL(PC_FRZ_FLAG,'N') = 'N'AND ROWNUM <= ? ORDER BY 1";
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
               /*	
                * 
                * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105
                * 
                * 			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_LOAN_CODE' AND  "
						+ "NVL(PC_FRZ_FLAG,'N') = 'N' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) AND ROWNUM <= ? ORDER BY 1";*/
				/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105*/
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_LOAN_CODE' AND  "
						+ "NVL(PC_FRZ_FLAG,'N') = 'N' AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
				/*end*/
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List LovAction_UNPAID_PREM_INT(Object object) {
		System.out.println("PT_IL_LOAN_ACTION.LovAction_UNPAID_PREM_INT()");
		String query = "select PC_CODE, PC_DESC from pm_codes where NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_TYPE='IL_PRM_INT'";
		List lovList = new ArrayList();
		if ("*".equals(object)) {

			try {
				Connection con = CommonUtils.getConnection();
				PreparedStatement psmt = con.prepareStatement(query);
				ResultSet rs = psmt.executeQuery();

				while (rs.next()) {

					PT_IL_LOAN_PREM_INT_LOV lovbox = new PT_IL_LOAN_PREM_INT_LOV();
					lovbox.setPC_CODE(rs.getString("PC_CODE"));
					lovbox.setPC_DESC(rs.getString("PC_DESC"));
					lovList.add(lovbox);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return lovList;
	}

	/*
	 * public void saveFormDetails(){
	 * getCOMP_UI_M_BUT_APPRV().setDisabled(false);
	 * CommonUtils.objectSysout(PT_IL_LOAN_BEAN);
	 * 
	 * try{ if(PT_IL_LOAN_BEAN.getLOAN_FC_NET_AMOUNT()<0){
	 *//**
		 * [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 details error message
		 * removed, getting error message also changed
		 */
	/*
	 * getErrorMap().put("current",
	 * Messages.getString(PELConstants.pelErrorMessagePath, "71086"));
	 *//** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
	/*
	 * } else{ Connection con = CommonUtils.getConnection(); CRUDHandler handler =
	 * new CRUDHandler(); if (PT_IL_LOAN_BEAN.getROWID() == null){ preInsert();
	 * handler.executeInsert(PT_IL_LOAN_BEAN, con); postInsert(); //
	 * getWarningMap().put("current","1 Record Inserted");
	 *//**
		 * [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 details error message
		 * removed
		 */
	/*
	 * getWarningMap().put("current",Messages.getString("messageProperties",
	 * "errorPanel$message$save"));
	 *//** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
	/*
	 * }else{ preUpdate(); handler.executeUpdate(PT_IL_LOAN_BEAN, con); //
	 * getWarningMap().put("current","1 Record Updated");
	 *//**
		 * [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 details error message
		 * removed
		 */
	/*
	 * getWarningMap().put("current",Messages.getString("messageProperties",
	 * "errorPanel$message$update"));
	 *//** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
	/*
	 * } con.commit(); } }catch(Exception ex){ ex.printStackTrace(); } }
	 */

	public void saveFormDetails() {
		String message = null;
		CommonUtils.clearMaps(this);
		try {

			surrPercentageCheck();
			// chkMICRCode(PT_IL_LOAN_BEAN.getLOAN_FLEX_05());
			if (getPT_IL_LOAN_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					preUpdate();
					new CRUDHandler().executeUpdate(PT_IL_LOAN_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				}
			} else {
				if (isINSERT_ALLOWED()) {
					PT_IL_LOAN_BEAN.setLOAN_REF_NO(genLoanRefNo());
					preInsert();
					new CRUDHandler().executeInsert(PT_IL_LOAN_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
				}
			}
			// added to dissable approve if netPayable is -ve
			if (PT_IL_LOAN_BEAN.getLOAN_FC_NET_AMOUNT() > 0) {
				COMP_UI_M_BUT_APPRV.setDisabled(true);
			} else {
				COMP_UI_M_BUT_APPRV.setDisabled(false);
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		} finally {
			try {
				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private String genLoanRefNo() throws Exception {
		String selectQuery = " SELECT POL_DIVN_CODE,POL_START_DT,POL_CLASS_CODE,  "
				+ "POL_PLAN_CODE,POL_UW_YEAR  "
				+ "FROM   PT_IL_POLICY   "
				+ "WHERE  POL_NO = ? ";
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		ResultSet rs = null;

		String divnCode = null;
		Date startDate = null;
		String classCode = null;
		String planCode = null;
		Integer uwyear = null;
		String docNo = null;
		List<String> retList = new ArrayList<String>();

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { PT_IL_LOAN_BEAN.getLOAN_POL_NO() });
			if (rs.next()) {
				divnCode = rs.getString(1);
				startDate = rs.getDate(2);
				classCode = rs.getString(3);
				planCode = rs.getString(4);
				uwyear = rs.getInt(5);
			}
			// always
			List<OracleParameter> retParamList = new PT_IL_LOAN_DELEGATE()
					.P_GEN_DOC_NO("5", planCode, divnCode, classCode, planCode,
							CommonUtils.getProcedureValue(uwyear),
							"'PT_IL_LOAN.LOAN_REF_NO", "PT_IL_LOAN", "N", null);

			if (retParamList != null && retParamList.size() > 0) {
				docNo = (String) retParamList.get(0).getValueObject();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return docNo;
	}

	public void surrPercentageCheck() throws Exception {
		Double surrPercentage = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_LOAN_MX'";
			resultSet = handler.executeSelectStatement(C1, connection);
			if (resultSet.next()) {
				surrPercentage = resultSet.getDouble(1);
			}
			if (PT_IL_LOAN_BEAN.getLOAN_SURR_PERC() > surrPercentage) {
				getErrorMap().put(
						"current",
						Messages.getString(PELConstants.pelErrorMessagePath,
								"11111"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String prevFormDetails() {
		System.out.println("PT_IL_LOAN_ACTION.prevFormDetails()--------------");
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = context.getExternalContext()
				.getSessionMap();
		sessionMap.remove("PILT004_PT_IL_LOAN_ACTION");
		return "previous";
	}

	public void postInsert() {
		try {
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_POL_SYS_ID()));
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_SYS_ID()));
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_FC_AMOUNT()));
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_AMOUNT()));
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_FC_PERM_AMT()));
			OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
					CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getLOAN_LC_PERM_AMT()));
			OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getUI_M_POL_SA_CURR_CODE());
			OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR());
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);
			paramList.add(param7);
			paramList.add(param8);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
					CommonUtils.getConnection(), "P9ilpk_Loan.P_INS_LOAN_DTL");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
			}
		}

	}

	/*
	 * public void preInsert(){
	 * 
	 * //String P_LOAN_POL_NO = (String)
	 * getCOMP_LOAN_POL_NO().getSubmittedValue();
	 * 
	 * String P_LOAN_POL_NO = PT_IL_LOAN_BEAN.getLOAN_POL_NO();
	 * System.out.println("POLNO from PRE-INSERT..........." + P_LOAN_POL_NO);
	 * 
	 * String cursor1 = "SELECT PIL_LOAN_SYS_ID.NEXTVAL AS LOAN_SYS_ID FROM
	 * DUAL"; String cursor2 = "SELECT
	 * POL_SYS_ID,POL_DIVN_CODE,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR FROM
	 * PT_IL_POLICY WHERE POL_NO = ?";
	 * 
	 * int LOAN_SYS_ID=0; int POL_SYS_ID=0;
	 * 
	 * try{ Connection con = CommonUtils.getConnection(); PreparedStatement psmt =
	 * con.prepareStatement(cursor1); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ LOAN_SYS_ID = rs.getInt("LOAN_SYS_ID"); } rs.close();
	 * psmt.close();
	 * 
	 * PreparedStatement psmt1 = con.prepareStatement(cursor2);
	 * psmt1.setString(1,P_LOAN_POL_NO);
	 * 
	 * ResultSet rs1 = psmt1.executeQuery(); while(rs1.next()){ POL_SYS_ID =
	 * rs1.getInt("POL_SYS_ID");
	 * System.out.println("PREFORM--------POL_SYS_ID--------------" +
	 * POL_SYS_ID); }
	 * 
	 * PT_IL_LOAN_BEAN.setLOAN_SYS_ID(LOAN_SYS_ID);
	 * PT_IL_LOAN_BEAN.setLOAN_POL_SYS_ID(POL_SYS_ID);
	 * 
	 * System.out.println("----------------------------------1" + LOAN_SYS_ID);
	 * 
	 * }catch(Exception ex){ex.printStackTrace();}
	 *  }
	 */
	public void preUpdate() {

		getPT_IL_LOAN_BEAN().setLOAN_UPD_DT(new Date());
		getPT_IL_LOAN_BEAN().setLOAN_UPD_UID(
				CommonUtils.getControlBean().getM_USER_ID());
	}

	public void preInsert() {
		String M_POL_DIVN_CODE = "", M_POL_CLASS_CODE = "", M_POL_PLAN_CODE = "";
		Integer M_POL_UW_YEAR = 0;
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		LIFELIB lifelib = new LIFELIB();

		String queryCursor1 = "SELECT PIL_LOAN_SYS_ID.NEXTVAL FROM DUAL";

		String querycursor2 = "SELECT POL_SYS_ID,POL_DIVN_CODE,POL_CLASS_CODE, POL_PLAN_CODE,POL_UW_YEAR "
				+ "FROM PT_IL_POLICY WHERE POL_NO = ?";
		Object[] cursorC2Values = { getPT_IL_LOAN_BEAN().getLOAN_POL_NO() };

		ResultSet rsCursor1 = null, rsCursor2 = null;
		/*
		 * String P_LOAN_POL_NO = (String)
		 * getCOMP_LOAN_POL_NO().getSubmittedValue(); P_LOAN_POL_NO
		 * =PT_IL_LOAN_BEAN.getLOAN_POL_NO(); String cursor1 = "SELECT
		 * PIL_LOAN_SYS_ID.NEXTVAL AS LOAN_SYS_ID FROM DUAL"; String cursor2 =
		 * "SELECT
		 * POL_SYS_ID,POL_DIVN_CODE,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR
		 * FROM PT_IL_POLICY WHERE POL_NO = ?";
		 */
		try {
			ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
			OracleParameter p11 = new OracleParameter("IN1", "STRING", "IN",
					CommonUtils.dateToStringFormatter(getPT_IL_LOAN_BEAN()
							.getLOAN_DT()));
			pList1.add(p11);
			OracleParameter p22 = new OracleParameter("IN2", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getLOAN_POL_NO());
			pList1.add(p22);
			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
			pHandler1.execute(pList1, CommonUtils.getConnection(),
					"P9ILPK_LOAN.LOAN_DATE_CHECK");

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					getPT_IL_LOAN_BEAN().getLOAN_REF_NO());
			paramList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			procHandler.execute(paramList, CommonUtils.getConnection(),
					"P9ILPK_LOAN.UNIQUE_REF_NO");

			ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
			OracleParameter param11 = new OracleParameter("in1", "STRING",
					"IN", getPT_IL_LOAN_BEAN().getLOAN_POL_NO());
			OracleParameter param21 = new OracleParameter("inout1", "STRING",
					"OUT", CommonUtils.getProcedureValue(getPT_IL_LOAN_BEAN()
							.getUI_M_SURR_YRS()));
			paramList1.add(param11);
			paramList1.add(param21);
			OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
			ArrayList listValidPolCheck = procHandler1.execute(paramList1,
					CommonUtils.getConnection(), "P9ILPK_LOAN.VALID_POL_NO");
			getPT_IL_LOAN_BEAN().setUI_M_SURR_YRS(
					Double.parseDouble(((OracleParameter) listValidPolCheck
							.get(0)).getValue()));

			rsCursor1 = getHandler().executeSelectStatement(queryCursor1,
					CommonUtils.getConnection());
			while (rsCursor1.next()) {
				getPT_IL_LOAN_BEAN().setLOAN_SYS_ID(rsCursor1.getLong(1));
			}

			rsCursor2 = getHandler().executeSelectStatement(querycursor2,
					CommonUtils.getConnection(), cursorC2Values);
			while (rsCursor2.next()) {
				getPT_IL_LOAN_BEAN().setLOAN_POL_SYS_ID(
						rsCursor2.getLong("POL_SYS_ID"));
				M_POL_DIVN_CODE = rsCursor2.getString("POL_DIVN_CODE");
				M_POL_CLASS_CODE = rsCursor2.getString("POL_CLASS_CODE");
				M_POL_PLAN_CODE = rsCursor2.getString("POL_PLAN_CODE");
				M_POL_UW_YEAR = rsCursor2.getInt("POL_UW_YEAR");
			}

			/*
			 * pValList = lifelib.P_GEN_DOC_NO("5", CommonUtils
			 * .getGlobalVariable("GLOBAL.M_PARAM_1"), M_POL_DIVN_CODE,
			 * M_POL_CLASS_CODE, M_POL_PLAN_CODE, null, CommonUtils
			 * .getProcedureValue(M_POL_UW_YEAR), "PT_IL_POLICY.POL_NO",
			 * "PT_IL_POLICY", "N", null, null, null);
			 * 
			 * if (!pValList.isEmpty()) {
			 * getPT_IL_LOAN_BEAN().setLOAN_REF_NO(pValList.get(0).getValue()); }
			 */

			getPT_IL_LOAN_BEAN().setLOAN_CR_DT(new Date());
			getPT_IL_LOAN_BEAN().setLOAN_CR_UID(
					CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rsCursor1);
				CommonUtils.closeCursor(rsCursor2);
				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * int LOAN_SYS_ID=0; int POL_SYS_ID=0;
	 * 
	 * try{ Connection con = CommonUtils.getConnection(); PreparedStatement psmt =
	 * con.prepareStatement(cursor1); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ LOAN_SYS_ID = rs.getInt("LOAN_SYS_ID"); }
	 * 
	 * psmt = con.prepareStatement(cursor2); psmt.setString(1,P_LOAN_POL_NO);
	 * 
	 * rs = psmt.executeQuery(); while(rs.next()){ POL_SYS_ID =
	 * rs.getInt("POL_SYS_ID"); }
	 * 
	 * PT_IL_LOAN_BEAN.setLOAN_SYS_ID(LOAN_SYS_ID);
	 * PT_IL_LOAN_BEAN.setLOAN_POL_SYS_ID(POL_SYS_ID);
	 * 
	 * System.out.println("----------------------------------1" + LOAN_SYS_ID);
	 * 
	 * }catch(Exception ex){ex.printStackTrace();}
	 *  }
	 */

	public String repayBtnAction() {
		try {
			CommonUtils.setGlobalObject("GLOBAL.M_LOAN_REF_NO",
					getPT_IL_LOAN_BEAN().getLOAN_REF_NO());
			CommonUtils.setGlobalVariable("PILT004_CALLING_FORM", "PILT004");
			CommonUtils.setGlobalObject("PILT004_PT_IL_LOAN_ACTION", this);
			System.out.println("PT_IL_LOAN_ACTION.repayBtnAction()");
			LoanRepaymentSearchPageAction loanRepaymSearchPgg = new LoanRepaymentSearchPageAction();
			loanRepaymSearchPgg.executeQuery(getPT_IL_LOAN_BEAN().getROWID());
			PT_IL_LOAN_BEAN.setROWID(getPT_IL_LOAN_BEAN().getROWID());
			CommonUtils.setGlobalObject("PILT004_PT_IL_LOAN_BEAN",
					PT_IL_LOAN_BEAN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return "PILT004_REPAY_BTN";
	}

	public String chargeBtnAction() {
		// preInsert();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		Double LOAN_FC_AMOUNT = (Double) session
				.getAttribute("LOAN_FC_AMOUNT ");
		Double LOAN_FC_AMOUNT1 = (Double) getCOMP_LOAN_FC_AMOUNT().getValue();
		Double LOAN_LC_AMOUNT1 = (Double) getCOMP_LOAN_LC_AMOUNT().getValue();
		Map session1 = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		session1.put("LOAN_FC_AMOUNT", LOAN_FC_AMOUNT1);
		session1.put("LOAN_LC_AMOUNT", LOAN_LC_AMOUNT1);
		session1.put("CURRENT_MODE", currentMode);

		// Set the loan charge list
		/*
		 * PT_IL_LOAN_CHARGE_ACTION chargeAction = (PT_IL_LOAN_CHARGE_ACTION)
		 * new CommonUtils()
		 * .getMappedBeanFromSession("PT_IL_LOAN_CHARGE_ACTION"); if
		 * (chargeAction == null) { chargeAction = new
		 * PT_IL_LOAN_CHARGE_ACTION();
		 * CommonUtils.setGlobalObject("PT_IL_LOAN_CHARGE_ACTION",
		 * chargeAction); }
		 */
		// chargeAction.fetchChargeDetails();
		return "charges";
	}

	public String detailBtnAction() {
		System.out.println("PT_IL_LOAN_ACTION.detailBtnAction()");
		return "detail";
	}

	/*
	 * public String apporveBtnAction(){
	 * 
	 * String queryCursor2= "SELECT
	 * POL_CUST_CODE,POL_CASH_YN,POL_DIVN_CODE,CUST_NAME " + "FROM
	 * PT_IL_POLICY,PM_CUSTOMER " + "WHERE POL_NO = ? AND CUST_CODE =
	 * POL_CUST_CODE"; Object[] cursorC2Values =
	 * {getPT_IL_LOAN_BEAN().getLOAN_POL_NO()}; ResultSet rsCursor2= null; try{
	 * PI_LT_LOAN_APPR_ACTION piLtLoanApprAction = new PI_LT_LOAN_APPR_ACTION();
	 * rsCursor2 = getHandler().executeSelectStatement(queryCursor2,
	 * CommonUtils.getConnection(), cursorC2Values ); while(rsCursor2.next()){
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setCUST_CODE(rsCursor2.getString(1));
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setUI_M_CUST_NAME(rsCursor2.getString(2));
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setUI_M_POL_DIVN_CODE(rsCursor2.getString(3));
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setUI_M_CUST_DESC(rsCursor2.getString(4)); }
	 * if("N".equalsIgnoreCase(piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getUI_M_POL_CASH_YN())){
	 * piLtLoanApprAction.setCustCodeDisabled(true); ArrayList<OracleParameter>
	 * paramList = new ArrayList<OracleParameter>(); OracleParameter param1 =
	 * new OracleParameter("in1","STRING","IN","CUSTOMER"); OracleParameter
	 * param2 = new
	 * OracleParameter("in2","STRING","IN",piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getCUST_CODE());
	 * OracleParameter param3 = new OracleParameter("inout1","STRING","IN
	 * OUT",piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getUI_M_CUST_DESC());
	 * OracleParameter param4 = new OracleParameter("in3","STRING","IN","N");
	 * OracleParameter param5 = new OracleParameter("in4","STRING","IN","N");
	 * OracleParameter param6 = new
	 * OracleParameter("in5","STRING","IN",piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getUI_M_POL_DIVN_CODE());
	 * paramList.add(param1); paramList.add(param2); paramList.add(param3);
	 * paramList.add(param4); paramList.add(param5); paramList.add(param6);
	 * OracleProcedureHandler procHandler = new OracleProcedureHandler();
	 * ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
	 * CommonUtils.getConnection(), "P_VAL_CLASS_CUST"); System.out.println("The
	 * procedure executed******"+((OracleParameter)
	 * listP_VAL_SYSTEM.get(0)).getValue());
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setUI_M_CUST_DESC(((OracleParameter)
	 * listP_VAL_SYSTEM.get(0)).getValue()); }else{
	 * piLtLoanApprAction.setCustCodeDisabled(false); ArrayList<OracleParameter>
	 * paramList = new ArrayList<OracleParameter>(); OracleParameter param1 =
	 * new OracleParameter("in1","STRING","IN","CASH"); OracleParameter param2 =
	 * new
	 * OracleParameter("in2","STRING","IN",piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getCUST_CODE());
	 * OracleParameter param3 = new OracleParameter("inout1","STRING","IN
	 * OUT",piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getUI_M_CUST_DESC());
	 * OracleParameter param4 = new OracleParameter("in3","STRING","IN","N");
	 * OracleParameter param5 = new OracleParameter("in4","STRING","IN","N");
	 * OracleParameter param6 = new
	 * OracleParameter("in5","STRING","IN",piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().getUI_M_POL_DIVN_CODE());
	 * paramList.add(param1); paramList.add(param2); paramList.add(param3);
	 * paramList.add(param4); paramList.add(param5); paramList.add(param6);
	 * OracleProcedureHandler procHandler = new OracleProcedureHandler();
	 * ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
	 * CommonUtils.getConnection(), "P_VAL_CLASS_CUST"); System.out.println("The
	 * procedure executed******"+((OracleParameter)
	 * listP_VAL_SYSTEM.get(0)).getValue());
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setUI_M_CUST_DESC(((OracleParameter)
	 * listP_VAL_SYSTEM.get(0)).getValue()); }
	 * piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setAPPR_DT(new Date());
	 * Map m =
	 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 * m.put("PILT004_PT_IL_LOAN_APPROVE_ACTION", piLtLoanApprAction);
	 * }catch(Exception e){ e.printStackTrace(); } return "PILT004_APPROVE"; }
	 */

	/*
	 * public String apporveBtnAction(){
	 * 
	 * System.out.println("PT_IL_LOAN_ACTION.apporveBtnAction()-------------------------------------");
	 * String POL_NO = PT_IL_LOAN_BEAN.getLOAN_POL_NO();
	 * System.out.println("POLNO=====" + POL_NO);
	 * 
	 * 
	 * System.out.println("PT_IL_LOAN_ACTION.apporveBtnAction() >>>
	 * "+M_POL_SA_CURR_CODE);
	 * 
	 * try {
	 * 
	 * String qry1 = "SELECT
	 * POL_SYS_ID,POL_CUST_CURR_CODE,POL_DIVN_CODE,POL_START_DT,POL_CLASS_CODE,POL_PLAN_CODE,POL_UW_YEAR,POL_NO_YRS_PREM_PAID,POL_STATUS,POL_SA_CURR_CODE,POL_PROD_CODE
	 * FROM PT_IL_POLICY WHERE POL_NO = ?"; PreparedStatement psmt =
	 * CommonUtils.getConnection().prepareStatement(qry1);
	 * psmt.setString(1,POL_NO); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ M_POL_SA_CURR_CODE = rs.getString(2); } rs.close();
	 * 
	 * String LOAN_EXCH_RATE_query = "SELECT CER_BUY_EXGE_RATE FROM
	 * FM_EXCHANGE_RATE WHERE CER_CURR_CODE = ?"; PreparedStatement psmt1 =
	 * CommonUtils.getConnection().prepareStatement(LOAN_EXCH_RATE_query);
	 * System.out.println("M_POL_SA_CURR_CODE" + M_POL_SA_CURR_CODE);
	 * psmt1.setString(1,M_POL_SA_CURR_CODE); ResultSet rs1 =
	 * psmt1.executeQuery();
	 * 
	 * while (rs1.next()) { P_LOAN_EXCH_RATE =
	 * Double.valueOf(rs1.getString("CER_BUY_EXGE_RATE"));
	 * System.out.println("P_LOAN_EXCH_RATE" + P_LOAN_EXCH_RATE); } rs1.close();
	 * 
	 * CommonUtils.setGlobalVariable("PILT004_M_POL_SA_CURR_CODE",
	 * M_POL_SA_CURR_CODE);
	 * CommonUtils.setGlobalVariable("PILT004_P_LOAN_EXCH_RATE",
	 * Double.toString(P_LOAN_EXCH_RATE));
	 * System.out.println("PT_IL_LOAN_ACTION.apporveBtnAction()");; String
	 * cursorC2 = "SELECT POL_CUST_CODE,POL_CASH_YN,POL_DIVN_CODE FROM
	 * PT_IL_POLICY WHERE POL_NO = ?"; String M_POL_CUST_CODE=""; String
	 * M_POL_DIVN_CODE=""; String M_POL_CASH_YN=""; String M_TEMP="";
	 * 
	 * Connection con = null; con = CommonUtils.getConnection();
	 * 
	 * PreparedStatement psmt2 = con.prepareStatement(cursorC2);
	 * psmt2.setString(1, POL_NO); ResultSet rs2 = psmt2.executeQuery();
	 * while(rs2.next()){ M_POL_CUST_CODE = rs2.getString("POL_CUST_CODE");
	 * M_POL_DIVN_CODE = rs2.getString("POL_CASH_YN"); M_POL_CASH_YN =
	 * rs2.getString("POL_DIVN_CODE"); } rs2.close();
	 * 
	 * if(M_POL_CASH_YN.equals("N")) { M_TEMP="CUSTOMER"; } else {
	 * M_TEMP="CASH"; }
	 * 
	 * ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();
	 * 
	 * OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",M_TEMP);
	 * pList1.add(p1); OracleParameter p2 = new OracleParameter("IN2", "STRING",
	 * "IN",M_POL_CUST_CODE); pList1.add(p2); OracleParameter p3 = new
	 * OracleParameter("IN3", "STRING", "IN OUT",""); pList1.add(p3);
	 * OracleParameter p4 = new OracleParameter("IN4", "STRING", "IN","N");
	 * pList1.add(p4); OracleParameter p5 = new OracleParameter("IN5", "STRING",
	 * "IN OUT","N"); pList1.add(p5); OracleParameter p6 = new
	 * OracleParameter("IN5", "STRING", "IN OUT",M_POL_DIVN_CODE);
	 * pList1.add(p6);
	 * 
	 * OracleProcedureHandler pHandler1 = new OracleProcedureHandler(); oList1 =
	 * pHandler1.execute(pList1, con,"P_VAL_CLASS_CUST");
	 * CommonUtils.setGlobalVariable("PILT004_POL_CUSTCODE", M_POL_CUST_CODE);
	 * System.out.println("CustomerCode=====" + M_POL_CUST_CODE);
	 * 
	 * 
	 * for (Iterator iterator2 = oList1.iterator(); iterator2.hasNext();) {
	 * OracleParameter name = (OracleParameter) iterator2.next();
	 * if(name.getFieldName().equals("IN3")){ statusValue = name.getValue(); }
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); }
	 * 
	 * return "PILT004_APPROVE"; }
	 */

	public String apporveBtnAction() {
		String returnString = null;
		String queryCursor2 = "SELECT POL_CUST_CODE,CUST_NAME,POL_DIVN_CODE,POL_CASH_YN "
				+ "FROM PT_IL_POLICY,PM_CUSTOMER "
				+ "WHERE  POL_NO = ? AND CUST_CODE = POL_CUST_CODE";
		Object[] cursorC2Values = { getPT_IL_LOAN_BEAN().getLOAN_POL_NO() };
		ResultSet rsCursor2 = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			PI_LT_LOAN_APPR_ACTION piLtLoanApprAction = new PI_LT_LOAN_APPR_ACTION();
			rsCursor2 = getHandler().executeSelectStatement(queryCursor2,
					connection, cursorC2Values);
			while (rsCursor2.next()) {
				/** [ Mallika 23-Mar-09 set the value in to corresponding fields */
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setCUST_CODE(
						rsCursor2.getString(1));
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
						.setUI_M_CUST_NAME(rsCursor2.getString(2));
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
						.setUI_M_CUST_DESC(rsCursor2.getString(2));
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
						.setUI_M_POL_DIVN_CODE(rsCursor2.getString(3));
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
						.setUI_M_POL_CASH_YN(rsCursor2.getString(4));

			}
			if ("N".equalsIgnoreCase(piLtLoanApprAction
					.getPT_IL_LOAN_APPROVE_BEAN().getUI_M_POL_CASH_YN())) {
				piLtLoanApprAction.setCustCodeDisabled(true);
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", "CUSTOMER");
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
								.getCUST_CODE());
				OracleParameter param3 = new OracleParameter("inout1",
						"STRING", "IN OUT", piLtLoanApprAction
								.getPT_IL_LOAN_APPROVE_BEAN()
								.getUI_M_CUST_DESC());
				OracleParameter param4 = new OracleParameter("in3", "STRING",
						"IN", "N");
				OracleParameter param5 = new OracleParameter("in4", "STRING",
						"IN", "N");
				OracleParameter param6 = new OracleParameter("in5", "STRING",
						"IN", piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
								.getUI_M_POL_DIVN_CODE());
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				paramList.add(param6);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
						connection, "P_VAL_CLASS_CUST");
				System.out.println("The procedure executed******"
						+ ((OracleParameter) listP_VAL_SYSTEM.get(0))
								.getValue());
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
						.setUI_M_CUST_DESC(
								((OracleParameter) listP_VAL_SYSTEM.get(0))
										.getValue());
			} else {
				piLtLoanApprAction.setCustCodeDisabled(false);
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", "CASH");
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
								.getCUST_CODE());
				OracleParameter param3 = new OracleParameter("inout1",
						"STRING", "IN OUT", piLtLoanApprAction
								.getPT_IL_LOAN_APPROVE_BEAN()
								.getUI_M_CUST_DESC());
				OracleParameter param4 = new OracleParameter("in3", "STRING",
						"IN", "N");
				OracleParameter param5 = new OracleParameter("in4", "STRING",
						"IN", "N");
				OracleParameter param6 = new OracleParameter("in5", "STRING",
						"IN", piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
								.getUI_M_POL_DIVN_CODE());
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				paramList.add(param6);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList listP_VAL_SYSTEM = procHandler.execute(paramList,
						connection, "P_VAL_CLASS_CUST");
				System.out.println("The procedure executed******"
						+ ((OracleParameter) listP_VAL_SYSTEM.get(0))
								.getValue());
				piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN()
						.setUI_M_CUST_DESC(
								((OracleParameter) listP_VAL_SYSTEM.get(0))
										.getValue());
			}
			piLtLoanApprAction.getPT_IL_LOAN_APPROVE_BEAN().setAPPR_DT(
					new CommonUtils().getCurrentDate());

			Map m = FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap();
			m.put("PILT004_PT_IL_LOAN_APPROVE_ACTION", piLtLoanApprAction);
			
			//calling procedure by ganesh given by somnath for "System should have the option to paid only interest amount." 			
			ResultSet resultSet2 = null;
			try{
			
			String approvalQuery = "SELECT LOAN_LC_AMOUNT,LOAN_INT_RATE,LOAN_INT_RATE_PER,LOAN_DT,LOAN_SYS_ID "+
					  "FROM PT_IL_LOAN, PT_IL_POLICY "+
					  "WHERE LOAN_POL_SYS_ID = POL_SYS_ID "+
					    "AND LOAN_POL_SYS_ID = ?";
			System.out.println("loan pol sys id >"+getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID());
			Object[]  dynamicValue= { getPT_IL_LOAN_BEAN().getLOAN_POL_SYS_ID() };
			
			resultSet2 = getHandler().executeSelectStatement(approvalQuery,
					connection, dynamicValue);
			
			while(resultSet2.next()){
				
				System.out.println("Parameter 1->"+String.valueOf(resultSet2.getDouble("LOAN_LC_AMOUNT")));
				System.out.println("Parameter 2->"+String.valueOf(resultSet2.getDouble("LOAN_INT_RATE")));
				System.out.println("Parameter 3->"+String.valueOf(resultSet2.getLong("LOAN_INT_RATE_PER")));
				System.out.println("Parameter 4->"+new SimpleDateFormat("dd/MM/yyyy").format(resultSet2.getDate("LOAN_DT")));
				System.out.println("Parameter 5->"+String.valueOf(resultSet2.getLong("LOAN_SYS_ID")));
				
				//calling procedures
				ArrayList<OracleParameter> oracleParameters = new ArrayList<OracleParameter>();
				
				OracleParameter param1 = new OracleParameter("IN1",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN,String.valueOf(resultSet2.getDouble("LOAN_LC_AMOUNT")));
				OracleParameter param2 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN,String.valueOf(resultSet2.getDouble("LOAN_INT_RATE")));
				OracleParameter param3 = new OracleParameter("IN3",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN,String.valueOf(resultSet2.getLong("LOAN_INT_RATE_PER")));
				OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE,	OracleParameter.DIRECTION_TYPE.IN,resultSet2.getDate("LOAN_DT"));
				OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, String.valueOf(resultSet2.getLong("LOAN_SYS_ID")));
				System.out.println("param1     : "+param1.getValueObject().toString()); 
				System.out.println("param2     : "+param2.getValueObject().toString());
				System.out.println("param3     : "+param3.getValueObject().toString());
				System.out.println("param4     : "+param4.getValueObject().toString());
				System.out.println("param5     : "+param5.getValueObject().toString());
				oracleParameters.add(param1);
				oracleParameters.add(param2);
				oracleParameters.add(param3);
				oracleParameters.add(param4);
				oracleParameters.add(param5);				
				OracleProcedureHandler procedureHandler = new OracleProcedureHandler();
				procedureHandler.executeProc(oracleParameters,
						connection, "P9ILPK_LOAN.PR_INS_LOAN_REPAY_INT");
				connection.commit();
			}				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				resultSet2.close();
				connection.close();
			}	
			
			//end
			
			returnString = "PILT004_APPROVE";
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			getErrorMap().put("current", message);
			getErrorMap().put("CURRENT", message);
		} finally {
			try {
				// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
			}
		}
		return returnString;

	}

	// MANI//

	public void LOAN_UNPAID_PREM_INT_CODE_Validator(FacesContext context,
			UIComponent component, Object valobject) {

		System.out.println("########## LOAN_UNPAID_PREM_INT_CODE_Validator ##############");
		PT_IL_LOAN_BEAN.setLOAN_UNPAID_PREM_INT_CODE((String) valobject);
		System.out.println("PT_IL_LOAN_BEAN.getLOAN_FC_UNPAID_PREM_INT()  : "+PT_IL_LOAN_BEAN.getLOAN_FC_UNPAID_PREM_INT());
		System.out.println("PT_IL_LOAN_BEAN.getLOAN_LC_UNPAID_PREM_INT()  : "+PT_IL_LOAN_BEAN.getLOAN_LC_UNPAID_PREM_INT());
		if (!"".equals(valobject)) {
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(PT_IL_LOAN_BEAN
					.getLOAN_FC_UNPAID_PREM_INT());
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(PT_IL_LOAN_BEAN
					.getLOAN_FC_UNPAID_PREM_INT());
		} else {
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(PT_IL_LOAN_BEAN
					.getLOAN_FC_UNPAID_PREM_INT());
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(PT_IL_LOAN_BEAN
					.getLOAN_FC_UNPAID_PREM_INT());
		}
		System.out.println("########## END ##############");
	}

	public void LOAN_FC_UNPAID_PREM_INT_Validator(FacesContext context,
			UIComponent component, Object vaObject) {
		Double LOAN_FC_UNPAID_PREM_INT = 0.0;
		LOAN_FC_UNPAID_PREM_INT = (Double) vaObject;

		/*
		 * if (getCOMP_LOAN_FC_UNPAID_PREM_INT().getSubmittedValue()
		 * .equals("")) { LOAN_FC_UNPAID_PREM_INT = 0.0; } else {
		 * LOAN_FC_UNPAID_PREM_INT =
		 * Double.valueOf((String)getCOMP_LOAN_FC_INTEREST()
		 * .getSubmittedValue()); }
		 */

		LOAN_FC_UNPAID_PREM_INT = P_VAL_ROUND_AMT(PILT004_DUMMY_BEAN
				.get("M_POL_SA_CURR_CODE"), LOAN_FC_UNPAID_PREM_INT, "V");
		PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM_INT(LOAN_FC_UNPAID_PREM_INT
				* PT_IL_LOAN_BEAN.getLOAN_EXCH_RATE());

		Double LOAN_LC_UNPAID_PREM_INT = PT_IL_LOAN_BEAN
				.getLOAN_LC_UNPAID_PREM_INT();

		LOAN_LC_UNPAID_PREM_INT = P_VAL_ROUND_AMT(PILT004_DUMMY_BEAN
				.get("M_BASE_CURR"), LOAN_LC_UNPAID_PREM_INT, "R");

		if (PT_IL_LOAN_BEAN.getUI_M_LOAN_GR_LC_AMT() == null) {
			PT_IL_LOAN_BEAN.setUI_M_LOAN_GR_LC_AMT(0.0);
		}
		if (PT_IL_LOAN_BEAN.getUI_M_LOAN_GR_FC_AMT() == null) {
			PT_IL_LOAN_BEAN.setUI_M_LOAN_GR_FC_AMT(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_LC_UNPAID_PREM() == null) {
			PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_LC_OS_AMOUNT() == null) {
			PT_IL_LOAN_BEAN.setLOAN_LC_OS_AMOUNT(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_LC_OS_LOAN_INT() == null) {
			PT_IL_LOAN_BEAN.setLOAN_LC_OS_LOAN_INT(0.0);
		}

		if (PT_IL_LOAN_BEAN.getLOAN_FC_UNPAID_PREM() == null) {
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_FC_OS_AMOUNT() == null) {
			PT_IL_LOAN_BEAN.setLOAN_FC_OS_AMOUNT(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_FC_OS_LOAN_INT() == null) {
			PT_IL_LOAN_BEAN.setLOAN_FC_OS_LOAN_INT(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_FC_UNPAID_PREM() == null) {
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_LC_UNPAID_PREM_INT() == null) {
			PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM_INT(0.0);
		}
		if (PT_IL_LOAN_BEAN.getLOAN_FC_UNPAID_PREM_INT() == null) {
			PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(0.0);
		}

		Double LOAN_LC_NET_AMOUNT = (PT_IL_LOAN_BEAN.getUI_M_LOAN_GR_LC_AMT() - (PT_IL_LOAN_BEAN
				.getLOAN_LC_UNPAID_PREM()
				+ PT_IL_LOAN_BEAN.getLOAN_LC_UNPAID_PREM_INT()
				+ PT_IL_LOAN_BEAN.getLOAN_LC_OS_AMOUNT() + PT_IL_LOAN_BEAN
				.getLOAN_LC_OS_LOAN_INT()));
		PT_IL_LOAN_BEAN.setLOAN_LC_NET_AMOUNT(LOAN_LC_NET_AMOUNT);

		LOAN_LC_NET_AMOUNT = P_VAL_ROUND_AMT(PILT004_DUMMY_BEAN
				.get("M_BASE_CURR"), LOAN_LC_NET_AMOUNT, "R");
		Double LOAN_FC_NET_AMOUNT = (PT_IL_LOAN_BEAN.getUI_M_LOAN_GR_FC_AMT() - (PT_IL_LOAN_BEAN
				.getLOAN_FC_UNPAID_PREM()
				+ PT_IL_LOAN_BEAN.getLOAN_FC_UNPAID_PREM_INT()
				+ PT_IL_LOAN_BEAN.getLOAN_FC_OS_AMOUNT() + PT_IL_LOAN_BEAN
				.getLOAN_FC_OS_LOAN_INT()));
		PT_IL_LOAN_BEAN.setLOAN_FC_NET_AMOUNT(LOAN_FC_NET_AMOUNT);

		LOAN_FC_NET_AMOUNT = P_VAL_ROUND_AMT(PT_IL_LOAN_BEAN
				.getLOAN_CURR_CODE(), PT_IL_LOAN_BEAN.getLOAN_FC_NET_AMOUNT(),
				"R");
		PT_IL_LOAN_BEAN.setLOAN_FC_NET_AMOUNT(LOAN_FC_NET_AMOUNT);
	}

	private Double P_VAL_ROUND_AMT(String CURR_CODE, Double PREM_INT,
			String TYPE) {
		try {
			CallableStatement cs = CommonUtils.getConnection().prepareCall(
					"{call P_VAL_ROUND_AMT(?,?,?)}");
			cs.setString(1, CURR_CODE);
			cs.registerOutParameter(2, java.sql.Types.DOUBLE);
			cs.setDouble(2, PREM_INT);
			cs.setString(3, TYPE);
			boolean flag = cs.execute();
			PREM_INT = cs.getDouble(2);
			System.out
					.println("PM_IL_CVR_SBNF_LINK_ACTION.postQueryPM_IL_CVR_SBNF_LINK() desc: "
							+ PREM_INT);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return PREM_INT;
	}

	public void LOAN_LC_UNPAID_PREM_INT_Validator(FacesContext context,
			UIComponent component, Object valObject) {

		PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM_INT((Double) valObject);

		Double LOAN_LC_UNPAID_PREM_INT = PT_IL_LOAN_BEAN
				.getLOAN_LC_UNPAID_PREM_INT();
		Double LOAN_FC_UNPAID_PREM_INT = PT_IL_LOAN_BEAN
				.getLOAN_FC_UNPAID_PREM_INT();
		// if(getCOMP_LOAN_LC_UNPAID_PREM_INT().getSubmittedValue().equals("")){
		if (LOAN_LC_UNPAID_PREM_INT == null
		/* || LOAN_LC_UNPAID_PREM_INT.isEmpty() */) {
			LOAN_LC_UNPAID_PREM_INT = 0.0;
		}
		/*
		 * else{ LC_UNPAID_PREM_INT =
		 * Double.valueOf(getCOMP_LOAN_LC_UNPAID_PREM_INT().getSubmittedValue()); }
		 */

		// if(getCOMP_LOAN_FC_UNPAID_PREM_INT().getSubmittedValue().equals("")){
		if (LOAN_FC_UNPAID_PREM_INT == null
		/* || ()LOAN_FC_UNPAID_PREM_INT.isEmpty() */) {
			LOAN_FC_UNPAID_PREM_INT = 0.0;
		}
		/*
		 * else{ FC_UNPAID_PREM_INT =
		 * Double.valueOf(getCOMP_LOAN_FC_UNPAID_PREM_INT().getSubmittedValue()); }
		 */

		// Double LOAN_LC_UNPAID_PREM_INT = Double.valueOf(value);
		P_VAL_ROUND_AMT(M_POL_SA_CURR_CODE, LOAN_LC_UNPAID_PREM_INT, "V");

		P_VAL_FC_LC_TOLERANCE(LOAN_FC_UNPAID_PREM_INT, LOAN_LC_UNPAID_PREM_INT,
				P_LOAN_EXCH_RATE, "E");

	}

	private void P_VAL_FC_LC_TOLERANCE(Double LOAN_FC_UNPAID_PREM_INT,
			Double LOAN_LC_UNPAID_PREM_INT, Double LOAN_EXCH_RATE, String TYPE) {
		try {
			CallableStatement cs = CommonUtils.getConnection().prepareCall(
					"{call P_VAL_FC_LC_TOLERANCE(?,?,?,?)}");
			cs.setDouble(1, LOAN_FC_UNPAID_PREM_INT);
			cs.setDouble(2, LOAN_LC_UNPAID_PREM_INT);
			cs.setDouble(3, LOAN_EXCH_RATE);
			cs.setString(4, TYPE);
			boolean flag = cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void LOAN_FC_OS_AMOUNT_Validator(FacesContext context,
			UIComponent component, Object value) {

		Double LOAN_FC_OS_AMOUNT = (Double) value;
		PT_IL_LOAN_BEAN.setLOAN_FC_OS_AMOUNT(LOAN_FC_OS_AMOUNT);

		/*
		 * if (getCOMP_LOAN_FC_OS_AMOUNT().getSubmittedValue().equals( "")) {
		 * LOAN_FC_OS_AMOUNT = 0.0; } else { LOAN_FC_OS_AMOUNT =
		 * Double.valueOf((String)getCOMP_LOAN_FC_OS_AMOUNT()
		 * .getSubmittedValue()); }
		 */

		Double LOAN_LC_OS_AMOUNT = P_VAL_ROUND_AMT(M_POL_SA_CURR_CODE,
				LOAN_FC_OS_AMOUNT, "V");
		LOAN_LC_OS_AMOUNT = LOAN_FC_OS_AMOUNT * P_LOAN_EXCH_RATE;
		// COMMENTD TEMPRORARY
		/*
		 * getCOMP_LOAN_LC_OS_AMOUNT().setSubmittedValue( LOAN_LC_OS_AMOUNT);
		 */
		PT_IL_LOAN_BEAN.setLOAN_LC_OS_AMOUNT(LOAN_LC_OS_AMOUNT);

		// PT_IL_LOAN_BEAN.setLOAN_LC_OS_AMOUNT(LOAN_LC_OS_AMOUNT);
		// P_VAL_ROUND_AMT(PILT004_DUMMY_BEAN.get("M_BASE_CURR"),PT_IL_LOAN_BEAN.getLOAN_LC_OS_AMOUNT(),"R");
	}

	public void LOAN_LC_OS_AMOUNT_Validator(FacesContext context,
			UIComponent component, Object vaObject) {
		/*
		 * UIInput component = (UIInput) event.getComponent().getParent();
		 * String value = (String) component.getSubmittedValue(); Double
		 * LOAN_LC_OS_AMOUNT = Double.valueOf(value); LOAN_LC_OS_AMOUNT =
		 * LOAN_LC_OS_AMOUNT == null ? 0 : LOAN_LC_OS_AMOUNT;
		 */

		Double LC_OS_AMOUNT = (Double) vaObject;
		Double FC_OS_AMOUNT = 0.0;
		PT_IL_LOAN_BEAN.setLOAN_LC_OS_AMOUNT(LC_OS_AMOUNT);
		/*
		 * if (getCOMP_LOAN_LC_OS_AMOUNT().getSubmittedValue().equals( "")) {
		 * LC_OS_AMOUNT = 0.0; } else { LC_OS_AMOUNT =
		 * Double.valueOf((String)getCOMP_LOAN_LC_OS_AMOUNT()
		 * .getSubmittedValue()); }
		 */

		/*
		 * if (getCOMP_LOAN_FC_OS_AMOUNT().getSubmittedValue().equals( "")) {
		 * FC_OS_AMOUNT = 0.0; } else { FC_OS_AMOUNT =
		 * Double.valueOf((String)getCOMP_LOAN_FC_OS_AMOUNT()
		 * .getSubmittedValue()); }
		 */

		P_VAL_ROUND_AMT(M_POL_SA_CURR_CODE, LC_OS_AMOUNT, "V");
		P_VAL_FC_LC_TOLERANCE(FC_OS_AMOUNT, LC_OS_AMOUNT, P_LOAN_EXCH_RATE, "E");
	}

	public void LOAN_LC_REPAY_AMT_Validator(ActionEvent event) {
		try {
			ArrayList<String> pCallValRoundAmount0 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(getCOMP_LOAN_LC_REPAY_AMT()
									.getSubmittedValue()), "V");
			/** [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 null pointer checked */
			if (pCallValRoundAmount0.get(0) != null
					&& (!"".equals(pCallValRoundAmount0.get(0)))) {
				getPT_IL_LOAN_BEAN().setLOAN_LC_REPAY_AMT(
						Double.parseDouble(pCallValRoundAmount0.get(0)));
			}
			/** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
			// COMMENTD TEMPRORARY
			// getCOMP_LOAN_LC_REPAY_AMT().setSubmittedValue(null);
			ArrayList<String> pValFcLcTolerance = new DBProcedures()
					.callP_VAL_FC_LC_TOLERANCE(CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_FC_REPAY_AMT()), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_LC_REPAY_AMT()), CommonUtils
							.getProcedureValue(getPT_IL_LOAN_BEAN()
									.getLOAN_EXCH_RATE()), "E");

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * UIInput component = (UIInput) event.getComponent().getParent(); String
	 * value = (String) component.getSubmittedValue(); Double LOAN_LC_REPAY_AMT =
	 * Double.valueOf(value); LOAN_LC_REPAY_AMT = LOAN_LC_REPAY_AMT == null ? 0 :
	 * LOAN_LC_REPAY_AMT;
	 *//*
		 * Double LC_REPAY_AMT= 0.0; Double FC_REPAY_AMT= 0.0;
		 */

	/*
	 * if(getCOMP_LOAN_LC_REPAY_AMT().getSubmittedValue().equals("")){
	 * LC_REPAY_AMT= 0.0; } else{ LC_REPAY_AMT =
	 * Double.valueOf(getCOMP_LOAN_LC_REPAY_AMT().getSubmittedValue()); }
	 * 
	 * if(getCOMP_LOAN_FC_REPAY_AMT().getSubmittedValue().equals("")){
	 * FC_REPAY_AMT= 0.0; } else{ FC_REPAY_AMT =
	 * Double.valueOf(getCOMP_LOAN_FC_REPAY_AMT().getSubmittedValue()); }
	 * 
	 * 
	 * 
	 * P_VAL_ROUND_AMT(M_POL_SA_CURR_CODE,LC_REPAY_AMT, "V");
	 * P_VAL_FC_LC_TOLERANCE(FC_REPAY_AMT,LC_REPAY_AMT,P_LOAN_EXCH_RATE,"E");
	 */

	public void LOAN_FC_REPAY_AMT_Validator(ActionEvent event) {
		try {
			ArrayList<String> pCallValRoundAmount0 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(getCOMP_LOAN_FC_REPAY_AMT()
									.getSubmittedValue()), "V");
			/** [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 null pointer checked */
			if (pCallValRoundAmount0.get(0) != null
					&& (!"".equals(pCallValRoundAmount0.get(0)))) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_REPAY_AMT(
						Double.parseDouble(pCallValRoundAmount0.get(0)));
				// COMMENTD TEMPRORARY
				/*
				 * getCOMP_LOAN_FC_REPAY_AMT().setSubmittedValue(Double.parseDouble(
				 * pCallValRoundAmount0.get(0)));
				 */
				getPT_IL_LOAN_BEAN().setLOAN_LC_REPAY_AMT(
						getPT_IL_LOAN_BEAN().getLOAN_FC_REPAY_AMT()
								* getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE());
				getCOMP_LOAN_LC_REPAY_AMT().resetValue();
			}
			/** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */

			ArrayList<String> pCallValRoundAmount1 = new DBProcedures()
					.callP_VAL_ROUND_AMT(getPT_IL_LOAN_BEAN()
							.getUI_M_POL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(getCOMP_LOAN_FC_REPAY_AMT()
									.getSubmittedValue()), "R");
			/** [ BugId:PREMIAGDC-0134 Mallika 13-Mar-09 null pointer checked */
			if (pCallValRoundAmount0.get(0) != null
					&& (!"".equals(pCallValRoundAmount0.get(0)))) {
				getPT_IL_LOAN_BEAN().setLOAN_FC_REPAY_AMT(
						Double.parseDouble(pCallValRoundAmount0.get(0)));
				// COMMENTD TEMPRORARY
				/*
				 * getCOMP_LOAN_FC_REPAY_AMT().setSubmittedValue(Double.parseDouble(
				 * pCallValRoundAmount0.get(0)));
				 */
			}
			/** BugId:PREMIAGDC-0134 Mallika 13-Mar-09 ] */
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	/*
	 * UIInput component = (UIInput) event.getComponent().getParent(); String
	 * value = (String) component.getSubmittedValue();
	 * 
	 * System.out.println("FC-REPAY1==" + value);
	 * PT_IL_LOAN_BEAN.setLOAN_FC_REPAY_AMT(Double.valueOf(value));
	 * System.out.println("FC-REPAY2=="
	 * +PT_IL_LOAN_BEAN.getLOAN_FC_REPAY_AMT());
	 * 
	 * 
	 * Double LC_REPAY_AMT= 0.0; Double exchRate =
	 * PT_IL_LOAN_BEAN.getLOAN_EXCH_RATE();
	 * 
	 * 
	 * if(exchRate==null){ exchRate=0.0; }
	 * 
	 * System.out.println("exchRate" + exchRate);
	 * if(PT_IL_LOAN_BEAN.getLOAN_FC_REPAY_AMT()==0){ LC_REPAY_AMT= 0.0; } else{
	 * LC_REPAY_AMT = PT_IL_LOAN_BEAN.getLOAN_FC_REPAY_AMT() * exchRate; }
	 * 
	 * getCOMP_LOAN_LC_REPAY_AMT().setSubmittedValue(String.valueOf(LC_REPAY_AMT));
	 * PT_IL_LOAN_BEAN.setLOAN_LC_REPAY_AMT(LC_REPAY_AMT);
	 * 
	 * 
	 * if(getCOMP_LOAN_FC_REPAY_AMT().getSubmittedValue().equals("")){
	 * LC_REPAY_AMT= 0.0; } else{ LC_REPAY_AMT =
	 * Double.valueOf(getCOMP_LOAN_FC_REPAY_AMT().getSubmittedValue()) *
	 * exchRate; } LC_REPAY_AMT = P_VAL_ROUND_AMT(M_POL_SA_CURR_CODE,
	 * LC_REPAY_AMT, "V");
	 * getCOMP_LOAN_LC_REPAY_AMT().setSubmittedValue(String.valueOf(LC_REPAY_AMT));
	 * PT_IL_LOAN_BEAN.setLOAN_LC_REPAY_AMT(LC_REPAY_AMT);
	 */

	// MANI//
	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public HtmlOutputText getCOMP_STATUS() {
		return COMP_STATUS;
	}

	public void setCOMP_STATUS(HtmlOutputText comp_status) {
		COMP_STATUS = comp_status;
	}

	// commented by akash not using this method anywhere.

	/*
	 * public String deleteFormDetails() { // ON-CHECK-DELELTE-MASTER//
	 * System.out.println("PT_IL_LOAN_ACTION.deleteFormDetails()");
	 *  // int LOAN_SYS_ID = 0; boolean recordExists = false; CRUDHandler
	 * handler = new CRUDHandler();
	 * 
	 * String query1 = "SELECT * FROM PT_IL_LOAN_CHARGE WHERE LC_LOAN_SYS_ID =
	 * ?"; String query2 = "SELECT * FROM PT_IL_LOAN_DTL P WHERE
	 * LOAND_POL_SYS_ID =?"; Connection con = null;
	 * 
	 * FacesContext context = FacesContext.getCurrentInstance(); Map<String,
	 * Object> sessionMap = context.getExternalContext() .getSessionMap();
	 * PT_IL_LOAN_ACTION actionBean = (PT_IL_LOAN_ACTION) sessionMap
	 * .get("PILT004_PT_IL_LOAN_ACTION"); PT_IL_LOAN valueBean =
	 * actionBean.getPT_IL_LOAN_BEAN(); System.out.println("Checking the status
	 * of the loan: " + valueBean.getLOAN_STATUS()); System.out.println("LOAN
	 * SYS ID======" + valueBean.getLOAN_SYS_ID());
	 * 
	 * try { con = CommonUtils.getConnection(); PreparedStatement psmt =
	 * con.prepareStatement(query1); psmt.setLong(1, LOAN_SYS_ID); ResultSet rs =
	 * psmt.executeQuery(); while (rs.next()) { recordExists = true;
	 *  } rs.close();
	 * 
	 * PreparedStatement psmt1 = con.prepareStatement(query2); psmt1.setInt(1,
	 * LOAN_SYS_ID); ResultSet rs1 = psmt.executeQuery(); while (rs1.next()) {
	 * recordExists = true;
	 *  } rs1.close();
	 * 
	 * System.out.println("Record Exists..." + recordExists); if
	 * (valueBean.getLOAN_STATUS().equalsIgnoreCase("A")) { getWarningMap().put(
	 * "current", Messages.getString("messageProperties",
	 * "errorPanel$message$approvedelete")); } else { if (recordExists == false) {
	 * System.out.println("Record is deleted"); int i =
	 * handler.executeDelete(valueBean, con); getWarningMap().put( "current",
	 * Messages.getString("messageProperties", "errorPanel$message$delete"));
	 * con.commit(); } else {
	 * 
	 * String deleteCHARGEQry = "delete from PT_IL_LOAN_CHARGE WHERE
	 * LC_LOAN_SYS_ID =" + LOAN_SYS_ID + " "; String deleteLOAN_DTLQry = "delete
	 * from PT_IL_LOAN_CHARGE WHERE LC_LOAN_SYS_ID = " + LOAN_SYS_ID + " ";
	 * handler.executeDeleteStatement(deleteCHARGEQry, con);
	 * handler.executeDeleteStatement(deleteCHARGEQry, con);
	 * handler.executeDelete(valueBean, con); getWarningMap().put( "current",
	 * Messages.getString("messageProperties", "errorPanel$message$delete"));
	 * con.commit(); // getErrorMap().put("current","Cannot delete master record //
	 * when matching detail records exist"); } }
	 *  } catch (Exception ex) { ex.printStackTrace(); throw new
	 * ValidatorException(new FacesMessage(ex.getMessage())); }
	 * 
	 * return ""; }
	 */

	public void init(PhaseEvent event) {
		System.out
				.println("PT_IL_LOAN_ACTION.init() : "
						+ FacesContext.getCurrentInstance().getViewRoot()
								.getChildren());
		for (int i = 0; i < FacesContext.getCurrentInstance().getViewRoot()
				.getChildren().size(); i++) {
			System.out.println("Comp: "
					+ FacesContext.getCurrentInstance().getViewRoot()
							.getChildren().get(i).getId());
		}
		getAllFieldsDisabled(true);
	}

	public void STD_PRE_FORM() {

		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext()
				.getSessionMap();

		System.out.println("-------INSIDE -STD-PRE-FORM---");
		// P_GET_LOGO;
		// COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
		// createCtrlBean();
		ControlBean ctrlbean = CommonUtils.getControlBean();
		ctrlbean.setM_PARA_1((String) session.get("GLOBAL.M_PARA_1"));
		// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		ctrlbean.setM_PROG_NAME("PILM055_APAC");
		// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		// 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP(------)"
				+ (String) session.get("GLOBAL.M_NAME"));
		// COPY('10','SYSTEM.MESSAGE_LEVEL');
		// session.put("GLOBAL.M_FAILURE", "FALSE");
		// ctrlbean.setM_GOFLD_NAME("NULL");
		/* <<<<<<< PT_IL_LOAN_ACTION.java */
		// ctrlbean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
		// Commented BY amit Gupta
		/*
		 * ctrlbean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		 * ctrlbean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		 */
		System.out.println("DUMMYACTION.STD_PRE_FORM(!!!! ) "
				+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		// ctrlbean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

		// putCtrlBean(ctrlbean);

		/*
		 * ======= >>>>>>> 1.24
		 */
		CommonUtils.setGlobalVariable("PILT004_MPARA1", ctrlbean.getM_PARA_1());
		System.out.println("DUMMYACTION.STD_PRE_FORM()--- \n "
				+ ctrlbean.getM_LANG_CODE() + "\t" + ctrlbean.getM_COMP_CODE()
				+ "\t" + ctrlbean.getM_PARA_1());

	}

	/*
	 * <<<<<<< PT_IL_LOAN_ACTION.java
	 * 
	 * public void createCtrlBean(){ ControlBean bean = new ControlBean();
	 * FacesContext context = FacesContext.getCurrentInstance(); Map<String,
	 * Object> session = context.getExternalContext().getSessionMap();
	 * session.put("ctrlbean", bean); }
	 * 
	 * public void putCtrlBean(ControlBean bean){ FacesContext context =
	 * FacesContext.getCurrentInstance(); Map<String, Object> session =
	 * context.getExternalContext().getSessionMap(); session.put("ctrlbean",
	 * bean); }
	 * 
	 * 
	 * public ControlBean getCtrlBean(){ FacesContext context =
	 * FacesContext.getCurrentInstance(); Map<String, Object> session =
	 * context.getExternalContext().getSessionMap(); return (ControlBean)
	 * session.get("ctrlbean"); }
	 * 
	 * ======= >>>>>>> 1.24
	 */
	public boolean isComponentDisableStatus() {
		return componentDisableStatus;
	}

	public void setComponentDisableStatus(boolean componentDisableStatus) {
		this.componentDisableStatus = componentDisableStatus;
	}

	public ArrayList<String> P_SET_DOC_NO_PROP(Connection connection,
			String P_DOC_TYPE, String P_DOC_CODE, String P_DIVN_CODE,
			String P_CLASS_CODE, String P_PLAN_CODE, String P_PROD_CODE,
			String P_UW_YEAR, String P_DOC_NO_FN, String P_BLOCK_NAME,
			String P_DUMMY_YN, String P_DATE, String P_CLAIM_TYPE,
			String P_REG_DATE, String P_ROWID) {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList;
		returnList = new ArrayList<String>();
		try {
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DOC_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DOC_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_UW_YEAR);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN OUT8", "STRING",
					"IN OUT", P_DOC_NO_FN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_BLOCK_NAME);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_DATE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_CLAIM_TYPE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_REG_DATE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING",
					"IN", P_ROWID);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING",
					"OUT", "");
			parameterList.add(param15);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"PKG_PILT002.P_SET_DOC_NO_PROP");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return returnList;
	}

	public void LD_SA_CURR_EXCHANGE_RATE(Object loanPolNo, Date loanDate) {
		String M_POL_SA_CURR_CODE = "", M_POL_CUST_CURR_CODE = "";
		Date M_POL_ISSUE_DT = null;
		String queryCursorC1 = "SELECT POL_SA_CURR_CODE, POL_ISSUE_DT, POL_CUST_CURR_CODE, POL_FC_CURR_SA, "
				+ "POL_LC_CURR_SA ,POL_SYS_ID,POL_PREM_WAIVE_YN FROM PT_IL_POLICY WHERE  POL_NO = ?";
		Object[] cursorC1Values = { loanPolNo };
		ResultSet rsCursor1 = null;
		Connection con = null;
		boolean found = false;
		try {
			System.out.println("In LD_SA_CURR_EXCHANGE : " + loanPolNo);
			con = CommonUtils.getConnection();
			rsCursor1 = getHandler().executeSelectStatement(queryCursorC1,
					CommonUtils.getConnection(), cursorC1Values);
			while (rsCursor1.next()) {
				System.out.println("In Resultset");
				getPT_IL_LOAN_BEAN().setLOAN_CURR_CODE(
						rsCursor1.getString("POL_SA_CURR_CODE"));
				/*
				 * getCOMP_LOAN_CURR_CODE().setSubmittedValue(
				 * rsCursor1.getString("POL_SA_CURR_CODE"));
				 */
				getPT_IL_LOAN_BEAN().setUI_M_POL_ISSUE_DATE(
						rsCursor1.getDate("POL_ISSUE_DT"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_CUST_CURR_CODE(
						rsCursor1.getString("POL_CUST_CURR_CODE"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_FC_SUM_ASSURED(
						rsCursor1.getDouble("POL_FC_CURR_SA"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_LC_SUM_ASSURED(
						rsCursor1.getDouble("POL_LC_CURR_SA"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_SYS_ID(
						rsCursor1.getInt("POL_SYS_ID"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_PREM_WAIVE_YN(
						rsCursor1.getString("POL_PREM_WAIVE_YN"));

				ArrayList<String> pValCurr = new DBProcedures()
						.helperP_VAL_CURR(getPT_IL_LOAN_BEAN()
								.getLOAN_CURR_CODE(), getPT_IL_LOAN_BEAN()
								.getUI_M_LOAN_CURR_1(), "S", "N", "");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_1(pValCurr.get(0));

				ArrayList<String> pValCurr1 = new DBProcedures()
						.helperP_VAL_CURR(getPT_IL_LOAN_BEAN()
								.getUI_M_POL_CUST_CURR_CODE(),
								getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1(),
								"S", "N", "");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_1(pValCurr1.get(0));

				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_2(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_4(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_5(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_6(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_3());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_7(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_8(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_9(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());

				System.out.println("LD_SA_CURR_EXCHANGE_RATE: LOAN_EXCHG_RATE "
						+ getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE());
				if (getPT_IL_LOAN_BEAN().getLOAN_EXCH_RATE() == null) {
					getPT_IL_LOAN_BEAN().setLOAN_EXCH_RATE(0.0);
				}
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE());
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getUI_M_BUY_SELL());
				OracleParameter param3 = new OracleParameter("in3", "STRING",
						"IN", CommonUtils.dateToStringFormatter(loanDate));
				OracleParameter param4 = new OracleParameter("inout1",
						"STRING", "IN OUT", CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getLOAN_EXCH_RATE()));
				OracleParameter param5 = new OracleParameter("in4", "STRING",
						"IN", "E");
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList listP_GET_EXCHANGE_RATE = procHandler.execute(
						paramList, CommonUtils.getConnection(),
						"P_GET_EXCHANGE_RATE");

				// getPT_IL_LOAN_BEAN().setLOAN_EXCH_RATE();

				Object loanExchRate = ((OracleParameter) listP_GET_EXCHANGE_RATE
						.get(0)).getValue();

				getPT_IL_LOAN_BEAN().setLOAN_EXCH_RATE(
						Double.valueOf((String) loanExchRate));
				// COMMENTD TEMPRORARY
				// getCOMP_LOAN_EXCH_RATE().setSubmittedValue(Double.valueOf((String)loanExchRate));
				if (getPT_IL_LOAN_BEAN().getLOAN_CURR_CODE().equalsIgnoreCase(
						getPT_IL_LOAN_BEAN().getUI_M_BASE_CURR())) {
					// setCompLoanExchRateReadOnly(true);
					setCompLoanExchRateDisabled(true);
				} else {
					// setCompLoanExchRateReadOnly(false);
					setCompLoanExchRateDisabled(false);
				}

				System.out.println("LD_SA_CURR_EXCH: "
						+ getPT_IL_LOAN_BEAN()
								.getUI_M_CUST_CURR_EXCHANGE_RATE());
				if (getPT_IL_LOAN_BEAN().getUI_M_CUST_CURR_EXCHANGE_RATE() == null) {
					getPT_IL_LOAN_BEAN().setUI_M_CUST_CURR_EXCHANGE_RATE(0.0);
				}

				ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
				OracleParameter param11 = new OracleParameter("in1", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getUI_M_POL_CUST_CURR_CODE());
				OracleParameter param21 = new OracleParameter("in2", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getUI_M_BUY_SELL());
				OracleParameter param31 = new OracleParameter("in3", "STRING",
						"IN", CommonUtils.dateToStringFormatter(loanDate));
				OracleParameter param41 = new OracleParameter("inout1",
						"STRING", "IN OUT", CommonUtils
								.getProcedureValue(getPT_IL_LOAN_BEAN()
										.getUI_M_CUST_CURR_EXCHANGE_RATE()));
				OracleParameter param51 = new OracleParameter("in4", "STRING",
						"IN", "E");
				paramList1.add(param11);
				paramList1.add(param21);
				paramList1.add(param31);
				paramList1.add(param41);
				paramList1.add(param51);
				OracleProcedureHandler procHandler1 = new OracleProcedureHandler();
				ArrayList listP_GET_EXCHANGE_RATE1 = procHandler1.execute(
						paramList, CommonUtils.getConnection(),
						"P_GET_EXCHANGE_RATE");
				getPT_IL_LOAN_BEAN()
						.setUI_M_CUST_CURR_EXCHANGE_RATE(
								Double
										.parseDouble(((OracleParameter) listP_GET_EXCHANGE_RATE1
												.get(0)).getValue()));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * PreparedStatement psmt = con.prepareStatement(cursorC1);
	 * psmt.setString(1, POL_NO); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ PILT004_DUMMY_BEAN.put("M_POL_ISSUE_DT",
	 * rs.getString("POL_ISSUE_DT"));
	 * PILT004_DUMMY_BEAN.put("M_POL_CUST_CURR_CODE",
	 * rs.getString("POL_CUST_CURR_CODE"));
	 * PILT004_DUMMY_BEAN.put("M_POL_FC_SUM_ASSURED",
	 * rs.getString("POL_FC_CURR_SA"));
	 * PILT004_DUMMY_BEAN.put("M_POL_LC_SUM_ASSURED",
	 * rs.getString("POL_LC_CURR_SA")); PILT004_DUMMY_BEAN.put("M_POL_SYS_ID",
	 * rs.getString("POL_SYS_ID"));
	 * PILT004_DUMMY_BEAN.put("M_POL_PREM_WAIVE_YN",
	 * rs.getString("POL_PREM_WAIVE_YN")); found = true; }
	 * 
	 * if(found==false){ if(M_POL_SA_CURR_CODE==null){M_POL_SA_CURR_CODE="";}
	 * P_VAL_CURR(:PT_IL_LOAN.LOAN_CURR_CODE,:DUMMY.M_LOAN_CURR_1,'S','N');
	 * 
	 * 
	 * ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();
	 * 
	 * 
	 * 
	 * OracleParameter p11 = new OracleParameter("IN1", "STRING",
	 * "IN",M_POL_SA_CURR_CODE); pList1.add(p11); OracleParameter p22 = new
	 * OracleParameter("IN2", "STRING", "IN OUT",""); pList1.add(p22);
	 * OracleParameter p33 = new OracleParameter("IN3", "STRING", "IN","S");
	 * pList1.add(p33); OracleParameter p44 = new OracleParameter("IN4",
	 * "STRING", "IN","N"); pList1.add(p44);
	 * 
	 * OracleProcedureHandler pHandler1 = new OracleProcedureHandler(); oList1 =
	 * pHandler1.execute(pList1, con,"P_VAL_CURR");
	 * 
	 * //P_VAL_CURR(:DUMMY.M_POL_CUST_CURR_CODE,:DUMMY.M_LOAN_CURR_3,'S','N');
	 * 
	 * ArrayList<OracleParameter> pList11 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList11 = new ArrayList<OracleParameter>();
	 * 
	 * OracleParameter p1 = new OracleParameter("IN1", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_POL_CUST_CURR_CODE")); pList1.add(p1);
	 * OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN OUT","");
	 * pList1.add(p2); OracleParameter p3 = new OracleParameter("IN3", "STRING",
	 * "IN","S"); pList1.add(p3); OracleParameter p4 = new
	 * OracleParameter("IN4", "STRING", "IN","N"); pList1.add(p4);
	 * 
	 * OracleProcedureHandler pHandler11 = new OracleProcedureHandler(); oList1 =
	 * pHandler11.execute(pList1, con,"P_VAL_CURR");
	 * 
	 * 
	 * :DUMMY.M_LOAN_CURR_2 := :DUMMY.M_LOAN_CURR_1; :DUMMY.M_LOAN_CURR_4 :=
	 * :DUMMY.M_LOAN_CURR_1; :DUMMY.M_LOAN_CURR_5 := :DUMMY.M_LOAN_CURR_1;
	 * :DUMMY.M_LOAN_CURR_6 := :DUMMY.M_LOAN_CURR_3 ; :DUMMY.M_LOAN_CURR_7 :=
	 * :DUMMY.M_LOAN_CURR_1; :DUMMY.M_LOAN_CURR_8 := :DUMMY.M_LOAN_CURR_1;
	 * :DUMMY.M_LOAN_CURR_9 := :DUMMY.M_LOAN_CURR_1;
	 * 
	 * 
	 * String BUY_SELL = PILT004_DUMMY_BEAN.get("DUMMY.M_BUY_SELL");
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy"); String date1 =
	 * sdf.format(PT_IL_LOAN_BEAN.getLOAN_DT());
	 * 
	 * 
	 * ArrayList<OracleParameter> pList = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList = new ArrayList<OracleParameter>();
	 * OracleParameter pa1 = new OracleParameter("IN1", "STRING",
	 * "IN",M_POL_SA_CURR_CODE); pList.add(pa1); OracleParameter pa2 = new
	 * OracleParameter("IN2", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_BUY_SELL")); pList.add(pa2);
	 * OracleParameter pa4 = new OracleParameter("IN4", "STRING", "IN",date1);
	 * pList.add(pa4); OracleParameter pa5 = new OracleParameter("IN3",
	 * "STRING", "IN OUT",""); pList.add(pa5); OracleParameter pa6 = new
	 * OracleParameter("IN4", "STRING", "IN","E"); pList.add(pa6);
	 * OracleProcedureHandler pHandler = new OracleProcedureHandler(); oList =
	 * pHandler.execute(pList, con,"P_GET_EXCHANGE_RATE");
	 * 
	 * 
	 * 
	 * ArrayList<OracleParameter> pList2 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList2 = new ArrayList<OracleParameter>();
	 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_POL_CUST_CURR_CODE")); pList2.add(param1);
	 * OracleParameter param2 = new OracleParameter("IN2", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_BUY_SELL")); pList2.add(param2);
	 * OracleParameter param3 = new OracleParameter("IN4", "STRING",
	 * "IN",date1); pList2.add(param3); OracleParameter param4 = new
	 * OracleParameter("IN3", "STRING", "IN OUT",""); pList2.add(param4);
	 * OracleParameter param5 = new OracleParameter("IN4", "STRING", "IN","E");
	 * pList2.add(param5); OracleProcedureHandler prHandler = new
	 * OracleProcedureHandler(); oList2 = prHandler.execute(pList2,
	 * con,"P_GET_EXCHANGE_RATE"); } }catch(Exception ex){ex.printStackTrace();} }
	 */

	public void LD_SA_CURR_EXCHANGE_RATE1() {
		String M_POL_SA_CURR_CODE = "", M_POL_CUST_CURR_CODE = "";
		Date M_POL_ISSUE_DT = null, M_POL_START_DT = null;
		ResultSet rsBUY_SELL = null, rsCursor1 = null;

		String cursorC1 = "SELECT POL_ISSUE_DT, POL_CUST_CURR_CODE, POL_FC_CURR_SA, POL_LC_CURR_SA , "
				+ "POL_SYS_ID, POL_START_DT, POL_NO_YRS_PREM_PAID,POL_PREM_WAIVE_YN "
				+ "FROM PT_IL_POLICY WHERE  POL_NO = ?";
		Object[] cursorC1Values = { getPT_IL_LOAN_BEAN().getLOAN_POL_NO() };

		String cursor_BUY_SELL = "SELECT DS_CURR_RATE_BS FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '1' "
				+ "AND DS_CODE = ?";
		Object[] cursorBUY_SELLValues = { CommonUtils
				.getGlobalVariable("GLOBAL.M_PARA_1") };

		String cursorC2 = "SELECT FLOOR(ABS((MONTHS_BETWEEN(M_POL_START_DT,?)/ 12))) FROM   DUAL";
		Object[] cursorC2Values = { getPT_IL_LOAN_BEAN().getLOAN_DT() };

		try {
			rsBUY_SELL = getHandler().executeSelectStatement(cursor_BUY_SELL,
					CommonUtils.getConnection(), cursorBUY_SELLValues);
			while (rsBUY_SELL.next()) {
				getPT_IL_LOAN_BEAN().setUI_M_BUY_SELL(
						rsBUY_SELL.getString("DS_CURR_RATE_BS"));
			}
			System.out.println("LD_SA_CURR_EXCHANGE_RATE1 after rsBUY_SELL");
			rsCursor1 = getHandler().executeSelectStatement(cursorC1,
					CommonUtils.getConnection(), cursorC1Values);
			while (rsCursor1.next()) {
				getPT_IL_LOAN_BEAN().setUI_M_POL_ISSUE_DATE(
						rsCursor1.getDate("POL_ISSUE_DT"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_CUST_CURR_CODE(
						rsCursor1.getString("POL_CUST_CURR_CODE"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_FC_SUM_ASSURED(
						rsCursor1.getDouble("POL_FC_CURR_SA"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_LC_SUM_ASSURED(
						rsCursor1.getDouble("POL_LC_CURR_SA"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_SYS_ID(
						rsCursor1.getInt("POL_SYS_ID"));
				M_POL_START_DT = rsCursor1.getDate("POL_START_DT");
				getPT_IL_LOAN_BEAN().setUI_M_NO_YRS_PREM_PAID(
						rsCursor1.getDouble("POL_NO_YRS_PREM_PAID"));
				getPT_IL_LOAN_BEAN().setUI_M_POL_PREM_WAIVE_YN(
						rsCursor1.getString("POL_PREM_WAIVE_YN"));

				ArrayList<String> pValCurr1 = new DBProcedures()
						.helperP_VAL_CURR(getPT_IL_LOAN_BEAN()
								.getLOAN_CURR_CODE(), getPT_IL_LOAN_BEAN()
								.getUI_M_LOAN_CURR_1(), "S", "N", "");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_1(pValCurr1.get(0));

				ArrayList<String> pValCurr2 = new DBProcedures()
						.helperP_VAL_CURR(getPT_IL_LOAN_BEAN()
								.getUI_M_POL_CUST_CURR_CODE(),
								getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1(),
								"S", "N", "");
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_3(pValCurr2.get(0));

				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_2(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_4(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_5(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_6(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_3());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_7(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_8(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());
				getPT_IL_LOAN_BEAN().setUI_M_LOAN_CURR_9(
						getPT_IL_LOAN_BEAN().getUI_M_LOAN_CURR_1());

				/*
				 * if(getPT_IL_LOAN_BEAN().getUI_M_CUST_CURR_EXCHANGE_RATE() ==
				 * null){
				 * getPT_IL_LOAN_BEAN().setUI_M_CUST_CURR_EXCHANGE_RATE(null); }
				 */

				// System.out.println("4 param:
				// "+getPT_IL_LOAN_BEAN().getUI_M_CUST_CURR_EXCHANGE_RATE());
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getUI_M_POL_CUST_CURR_CODE());
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", getPT_IL_LOAN_BEAN().getUI_M_BUY_SELL());
				OracleParameter param3 = new OracleParameter("in3", "STRING",
						"IN", CommonUtils
								.dateToStringFormatter(getPT_IL_LOAN_BEAN()
										.getLOAN_DT()));
				OracleParameter param4 = new OracleParameter("inout1",
						"STRING", "IN OUT", "");
				OracleParameter param5 = new OracleParameter("in4", "STRING",
						"IN", "N");
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList listP_GET_EXCHANGE_RATE = procHandler.execute(
						paramList, CommonUtils.getConnection(),
						"P_GET_EXCHANGE_RATE");
				getPT_IL_LOAN_BEAN()
						.setUI_M_CUST_CURR_EXCHANGE_RATE(
								Double
										.parseDouble(((OracleParameter) listP_GET_EXCHANGE_RATE
												.get(0)).getValue()));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rsBUY_SELL);
				CommonUtils.closeCursor(rsCursor1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * ControlBean ctrlbean = getCtrlBean(); String M_PARA1 =
	 * CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
	 * System.out.println("PT_IL_LOAN_ACTION.LD_SA_CURR_EXCHANGE_RATE1()------------>" +
	 * M_PARA1);
	 * 
	 * 
	 * boolean found = false;
	 * 
	 * Connection conn = null; try{ conn= CommonUtils.getConnection();
	 * PreparedStatement psmt = conn.prepareStatement(cursor_BUY_SELL);
	 * psmt.setString(1, M_PARA1); ResultSet rs = psmt.executeQuery();
	 * while(rs.next()){ PILT004_DUMMY_BEAN.put("DUMMY.M_BUY_SELL",
	 * rs.getString("DS_CURR_RATE")); } rs.close();
	 * 
	 * PreparedStatement psmt2 = conn.prepareStatement(cursorC1);
	 * psmt2.setString(1, POL_NO); ResultSet rs2 = psmt2.executeQuery();
	 * while(rs2.next()){
	 * System.out.println(rs2.getString("POL_PREM_WAIVE_YN"));
	 * PILT004_DUMMY_BEAN.put("M_POL_ISSUE_DT", rs2.getString("POL_ISSUE_DT"));
	 * PILT004_DUMMY_BEAN.put("M_POL_CUST_CURR_CODE",
	 * rs2.getString("POL_CUST_CURR_CODE"));
	 * PILT004_DUMMY_BEAN.put("M_POL_FC_SUM_ASSURED",
	 * rs2.getString("POL_FC_CURR_SA"));
	 * PILT004_DUMMY_BEAN.put("M_POL_LC_SUM_ASSURED",
	 * rs2.getString("POL_LC_CURR_SA")); PILT004_DUMMY_BEAN.put("M_POL_SYS_ID",
	 * rs2.getString("POL_SYS_ID"));
	 * PILT004_DUMMY_BEAN.put("M_POL_PREM_WAIVE_YN",
	 * rs2.getString("POL_PREM_WAIVE_YN")==null?"N":rs2.getString("POL_PREM_WAIVE_YN"));
	 * found = true; } rs2.close(); if(found==false){
	 * if(M_POL_SA_CURR_CODE==null){M_POL_SA_CURR_CODE="";}
	 * P_VAL_CURR(:PT_IL_LOAN.LOAN_CURR_CODE,:DUMMY.M_LOAN_CURR_1,'S','N');
	 * 
	 * 
	 * ArrayList<OracleParameter> pList1 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList1 = new ArrayList<OracleParameter>();
	 * 
	 * 
	 * 
	 * OracleParameter p11 = new OracleParameter("IN1", "STRING",
	 * "IN",M_POL_SA_CURR_CODE); pList1.add(p11); OracleParameter p22 = new
	 * OracleParameter("IN2", "STRING", "IN OUT",""); pList1.add(p22);
	 * OracleParameter p33 = new OracleParameter("IN3", "STRING", "IN","S");
	 * pList1.add(p33); OracleParameter p44 = new OracleParameter("IN4",
	 * "STRING", "IN","N"); pList1.add(p44);
	 * 
	 * OracleProcedureHandler pHandler1 = new OracleProcedureHandler(); oList1 =
	 * pHandler1.execute(pList1, conn,"P_VAL_CURR");
	 * 
	 * //P_VAL_CURR(:DUMMY.M_POL_CUST_CURR_CODE,:DUMMY.M_LOAN_CURR_3,'S','N');
	 * 
	 * ArrayList<OracleParameter> pList11 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList11 = new ArrayList<OracleParameter>();
	 * 
	 * OracleParameter p1 = new OracleParameter("IN1", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_POL_CUST_CURR_CODE")); pList1.add(p1);
	 * OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN OUT","");
	 * pList1.add(p2); OracleParameter p3 = new OracleParameter("IN3", "STRING",
	 * "IN","S"); pList1.add(p3); OracleParameter p4 = new
	 * OracleParameter("IN4", "STRING", "IN","N"); pList1.add(p4);
	 * 
	 * OracleProcedureHandler pHandler11 = new OracleProcedureHandler(); oList1 =
	 * pHandler11.execute(pList1, conn,"P_VAL_CURR");
	 * 
	 * 
	 * :DUMMY.M_LOAN_CURR_2 := :DUMMY.M_LOAN_CURR_1; :DUMMY.M_LOAN_CURR_4 :=
	 * :DUMMY.M_LOAN_CURR_1; :DUMMY.M_LOAN_CURR_5 := :DUMMY.M_LOAN_CURR_1;
	 * :DUMMY.M_LOAN_CURR_6 := :DUMMY.M_LOAN_CURR_3 ; :DUMMY.M_LOAN_CURR_7 :=
	 * :DUMMY.M_LOAN_CURR_1; :DUMMY.M_LOAN_CURR_8 := :DUMMY.M_LOAN_CURR_1;
	 * :DUMMY.M_LOAN_CURR_9 := :DUMMY.M_LOAN_CURR_1;
	 * 
	 * 
	 * String BUY_SELL = PILT004_DUMMY_BEAN.get("DUMMY.M_BUY_SELL");
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy"); String date1 =
	 * sdf.format(PT_IL_LOAN_BEAN.getLOAN_DT());
	 * 
	 * 
	 * ArrayList<OracleParameter> pList = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList = new ArrayList<OracleParameter>();
	 * OracleParameter pa1 = new OracleParameter("IN1", "STRING",
	 * "IN",M_POL_SA_CURR_CODE); pList.add(pa1); OracleParameter pa2 = new
	 * OracleParameter("IN2", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_BUY_SELL")); pList.add(pa2);
	 * OracleParameter pa4 = new OracleParameter("IN4", "STRING", "IN",date1);
	 * pList.add(pa4); OracleParameter pa5 = new OracleParameter("IN3",
	 * "STRING", "IN OUT",""); pList.add(pa5); OracleParameter pa6 = new
	 * OracleParameter("IN4", "STRING", "IN","E"); pList.add(pa6);
	 * OracleProcedureHandler pHandler = new OracleProcedureHandler(); oList =
	 * pHandler.execute(pList, conn,"P_GET_EXCHANGE_RATE");
	 * 
	 * 
	 * 
	 * ArrayList<OracleParameter> pList2 = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> oList2 = new ArrayList<OracleParameter>();
	 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_POL_CUST_CURR_CODE")); pList2.add(param1);
	 * OracleParameter param2 = new OracleParameter("IN2", "STRING",
	 * "IN",PILT004_DUMMY_BEAN.get("M_BUY_SELL")); pList2.add(param2);
	 * OracleParameter param3 = new OracleParameter("IN4", "STRING",
	 * "IN",date1); pList2.add(param3); OracleParameter param4 = new
	 * OracleParameter("IN3", "STRING", "IN OUT",""); pList2.add(param4);
	 * OracleParameter param5 = new OracleParameter("IN4", "STRING", "IN","E");
	 * pList2.add(param5); OracleProcedureHandler prHandler = new
	 * OracleProcedureHandler(); oList2 = prHandler.execute(pList2,
	 * conn,"P_GET_EXCHANGE_RATE"); } }catch(Exception
	 * ex){ex.printStackTrace();} }
	 */

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public void ptIlLoanBlockDisabled(boolean disabled) {
		setCompLoanCodeDisabled(disabled);
		setCompLoanPolNoDisabled(disabled);
		setCompLoanDateDisabled(disabled);
		setCompLoanCurrCodeDisabled(disabled);
		setCompLoanExchRateDisabled(disabled);
		setCompLoanSurrPercDisabled(disabled);
		setCompLoanRefNoDisabled(disabled);
		setCompLoanFcAmountDisabled(disabled);
		setCompLoanLcAmountDisabled(disabled);
		setCompLoanRepayFreqDisabled(disabled);
		setCompLoanDueDtDisabled(disabled);
		setCompLoanIntRateDisabled(disabled);
		setCompLoanIntRatePerDisabled(disabled);
		setCompLoanFcInterestDisabled(disabled);
		setCompLoanLcInterestDisabled(disabled);
		setCompUiMLoanFcChargeDisabled(disabled);
		setCompUiMLoanLcChargeDisabled(disabled);
		setCompUiMLoanGrFcAmtDisabled(disabled);
		setCompUiMLoanGrLcAmtDisabled(disabled);
		setCompLoanFcUnpaidPremDisabled(disabled);
		setCompLoanLcUnpaidPremDisabled(disabled);
		setCompLoanUnpaidPremIntCodeDisabled(disabled);
		setCompLoanFcUnpaidPremIntDisabled(disabled);
		setCompLoanLcUnpaidPremIntDisabled(disabled);
		setCompLoanFcOsAmountDisabled(disabled);
		setCompLoanLcOsAmountDisabled(disabled);
		setCompLoanFcOsLoanIntDisabled(disabled);
		setCompLoanLcOsLoanIntDisabled(disabled);
		setCompLoanFcNetAmountDisabled(disabled);
		setCompLoanLcNetAmountDisabled(disabled);
		setCompLoanFcRepayAmtDisabled(disabled);
		setCompLoanLcRepayAmtDisabled(disabled);
		setCompLoanFcRepaidAmtDisabled(disabled);
		setCompLoanLcRepaidAmtDisabled(disabled);
		// setCompLoanStatusDisabled(disabled);
		// setCompLoanSysIdDisabled(disabled);
		// private boolean compUiMNoYrsPremPaidReadOnly;
		// setComLoanPolSysIdReadOnly(disabled);
		// setCompLoanCrDtDisabled(disabled);
		// setCompLoanCrUidDisabled(disabled);
		// setCompLoanUpdDtDisabled(disabled);
		// setCompLoanUpdUidDisabled(disabled);
		setCompLoanLcPermAmtDisabled(disabled);
		setCompLoanFcPermAmtDisabled(disabled);
		setCompUiMLoanCodeDescDisabled(disabled);
	}

	public boolean isCompUiMButRecalDisabled() {
		return compUiMButRecalDisabled;
	}

	public void setCompUiMButRecalDisabled(boolean compUiMButRecalDisabled) {
		this.compUiMButRecalDisabled = compUiMButRecalDisabled;
	}

	public boolean isCompUiMButRepaymentDisabled() {
		return compUiMButRepaymentDisabled;
	}

	public void setCompUiMButRepaymentDisabled(
			boolean compUiMButRepaymentDisabled) {
		this.compUiMButRepaymentDisabled = compUiMButRepaymentDisabled;
	}

	public boolean isBlockDeleteAllowed() {
		return blockDeleteAllowed;
	}

	public void setBlockDeleteAllowed(boolean blockDeleteAllowed) {
		this.blockDeleteAllowed = blockDeleteAllowed;
	}

	public boolean isCompLoanExchRateDisabled() {
		return compLoanExchRateDisabled;
	}

	public void setCompLoanExchRateDisabled(boolean compLoanExchRateDisabled) {
		this.compLoanExchRateDisabled = compLoanExchRateDisabled;
	}

	public boolean isCompApprStatusRendered() {
		return compApprStatusRendered;
	}

	public void setCompApprStatusRendered(boolean compApprStatusRendered) {
		this.compApprStatusRendered = compApprStatusRendered;
	}

	public HtmlOutputText getCOMP_LOAN_STATUS() {
		return COMP_LOAN_STATUS;
	}

	public void setCOMP_LOAN_STATUS(HtmlOutputText comp_loan_status) {
		COMP_LOAN_STATUS = comp_loan_status;
	}

	public boolean isCompLoanCodeDisabled() {
		return compLoanCodeDisabled;
	}

	public void setCompLoanCodeDisabled(boolean compLoanCodeDisabled) {
		this.compLoanCodeDisabled = compLoanCodeDisabled;
	}

	public boolean isCompLoanPolNoDisabled() {
		return compLoanPolNoDisabled;
	}

	public void setCompLoanPolNoDisabled(boolean compLoanPolNoDisabled) {
		this.compLoanPolNoDisabled = compLoanPolNoDisabled;
	}

	public boolean isCompLoanDateDisabled() {
		return compLoanDateDisabled;
	}

	public void setCompLoanDateDisabled(boolean compLoanDateDisabled) {
		this.compLoanDateDisabled = compLoanDateDisabled;
	}

	public boolean isCompLoanCurrCodeDisabled() {
		return compLoanCurrCodeDisabled;
	}

	public void setCompLoanCurrCodeDisabled(boolean compLoanCurrCodeDisabled) {
		this.compLoanCurrCodeDisabled = compLoanCurrCodeDisabled;
	}

	public boolean isCompLoanSurrPercDisabled() {
		return compLoanSurrPercDisabled;
	}

	public void setCompLoanSurrPercDisabled(boolean compLoanSurrPercDisabled) {
		this.compLoanSurrPercDisabled = compLoanSurrPercDisabled;
	}

	public boolean isCompLoanRefNoDisabled() {
		return compLoanRefNoDisabled;
	}

	public void setCompLoanRefNoDisabled(boolean compLoanRefNoDisabled) {
		this.compLoanRefNoDisabled = compLoanRefNoDisabled;
	}

	public boolean isCompLoanFcAmountDisabled() {
		return compLoanFcAmountDisabled;
	}

	public void setCompLoanFcAmountDisabled(boolean compLoanFcAmountDisabled) {
		this.compLoanFcAmountDisabled = compLoanFcAmountDisabled;
	}

	public boolean isCompLoanLcAmountDisabled() {
		return compLoanLcAmountDisabled;
	}

	public void setCompLoanLcAmountDisabled(boolean compLoanLcAmountDisabled) {
		this.compLoanLcAmountDisabled = compLoanLcAmountDisabled;
	}

	public boolean isCompLoanRepayFreqDisabled() {
		return compLoanRepayFreqDisabled;
	}

	public void setCompLoanRepayFreqDisabled(boolean compLoanRepayFreqDisabled) {
		this.compLoanRepayFreqDisabled = compLoanRepayFreqDisabled;
	}

	public boolean isCompLoanDueDtDisabled() {
		return compLoanDueDtDisabled;
	}

	public void setCompLoanDueDtDisabled(boolean compLoanDueDtDisabled) {
		this.compLoanDueDtDisabled = compLoanDueDtDisabled;
	}

	public boolean isCompLoanIntRateDisabled() {
		return compLoanIntRateDisabled;
	}

	public void setCompLoanIntRateDisabled(boolean compLoanIntRateDisabled) {
		this.compLoanIntRateDisabled = compLoanIntRateDisabled;
	}

	public boolean isCompLoanIntRatePerDisabled() {
		return compLoanIntRatePerDisabled;
	}

	public void setCompLoanIntRatePerDisabled(boolean compLoanIntRatePerDisabled) {
		this.compLoanIntRatePerDisabled = compLoanIntRatePerDisabled;
	}

	public boolean isCompLoanFcInterestDisabled() {
		return compLoanFcInterestDisabled;
	}

	public void setCompLoanFcInterestDisabled(boolean compLoanFcInterestDisabled) {
		this.compLoanFcInterestDisabled = compLoanFcInterestDisabled;
	}

	public boolean isCompLoanLcInterestDisabled() {
		return compLoanLcInterestDisabled;
	}

	public void setCompLoanLcInterestDisabled(boolean compLoanLcInterestDisabled) {
		this.compLoanLcInterestDisabled = compLoanLcInterestDisabled;
	}

	public boolean isCompUiMLoanFcChargeDisabled() {
		return compUiMLoanFcChargeDisabled;
	}

	public void setCompUiMLoanFcChargeDisabled(
			boolean compUiMLoanFcChargeDisabled) {
		this.compUiMLoanFcChargeDisabled = compUiMLoanFcChargeDisabled;
	}

	public boolean isCompUiMLoanLcChargeDisabled() {
		return compUiMLoanLcChargeDisabled;
	}

	public void setCompUiMLoanLcChargeDisabled(
			boolean compUiMLoanLcChargeDisabled) {
		this.compUiMLoanLcChargeDisabled = compUiMLoanLcChargeDisabled;
	}

	public boolean isCompUiMLoanGrFcAmtDisabled() {
		return compUiMLoanGrFcAmtDisabled;
	}

	public void setCompUiMLoanGrFcAmtDisabled(boolean compUiMLoanGrFcAmtDisabled) {
		this.compUiMLoanGrFcAmtDisabled = compUiMLoanGrFcAmtDisabled;
	}

	public boolean isCompUiMLoanGrLcAmtDisabled() {
		return compUiMLoanGrLcAmtDisabled;
	}

	public void setCompUiMLoanGrLcAmtDisabled(boolean compUiMLoanGrLcAmtDisabled) {
		this.compUiMLoanGrLcAmtDisabled = compUiMLoanGrLcAmtDisabled;
	}

	public boolean isCompLoanFcUnpaidPremDisabled() {
		return compLoanFcUnpaidPremDisabled;
	}

	public void setCompLoanFcUnpaidPremDisabled(
			boolean compLoanFcUnpaidPremDisabled) {
		this.compLoanFcUnpaidPremDisabled = compLoanFcUnpaidPremDisabled;
	}

	public boolean isCompLoanLcUnpaidPremDisabled() {
		return compLoanLcUnpaidPremDisabled;
	}

	public void setCompLoanLcUnpaidPremDisabled(
			boolean compLoanLcUnpaidPremDisabled) {
		this.compLoanLcUnpaidPremDisabled = compLoanLcUnpaidPremDisabled;
	}

	public boolean isCompLoanUnpaidPremIntCodeDisabled() {
		return compLoanUnpaidPremIntCodeDisabled;
	}

	public void setCompLoanUnpaidPremIntCodeDisabled(
			boolean compLoanUnpaidPremIntCodeDisabled) {
		this.compLoanUnpaidPremIntCodeDisabled = compLoanUnpaidPremIntCodeDisabled;
	}

	public boolean isCompLoanFcUnpaidPremIntDisabled() {
		return compLoanFcUnpaidPremIntDisabled;
	}

	public void setCompLoanFcUnpaidPremIntDisabled(
			boolean compLoanFcUnpaidPremIntDisabled) {
		this.compLoanFcUnpaidPremIntDisabled = compLoanFcUnpaidPremIntDisabled;
	}

	public boolean isCompLoanLcUnpaidPremIntDisabled() {
		return compLoanLcUnpaidPremIntDisabled;
	}

	public void setCompLoanLcUnpaidPremIntDisabled(
			boolean compLoanLcUnpaidPremIntDisabled) {
		this.compLoanLcUnpaidPremIntDisabled = compLoanLcUnpaidPremIntDisabled;
	}

	public boolean isCompLoanFcOsAmountDisabled() {
		return compLoanFcOsAmountDisabled;
	}

	public void setCompLoanFcOsAmountDisabled(boolean compLoanFcOsAmountDisabled) {
		this.compLoanFcOsAmountDisabled = compLoanFcOsAmountDisabled;
	}

	public boolean isCompLoanLcOsAmountDisabled() {
		return compLoanLcOsAmountDisabled;
	}

	public void setCompLoanLcOsAmountDisabled(boolean compLoanLcOsAmountDisabled) {
		this.compLoanLcOsAmountDisabled = compLoanLcOsAmountDisabled;
	}

	public boolean isCompLoanFcOsLoanIntDisabled() {
		return compLoanFcOsLoanIntDisabled;
	}

	public void setCompLoanFcOsLoanIntDisabled(
			boolean compLoanFcOsLoanIntDisabled) {
		this.compLoanFcOsLoanIntDisabled = compLoanFcOsLoanIntDisabled;
	}

	public boolean isCompLoanLcOsLoanIntDisabled() {
		return compLoanLcOsLoanIntDisabled;
	}

	public void setCompLoanLcOsLoanIntDisabled(
			boolean compLoanLcOsLoanIntDisabled) {
		this.compLoanLcOsLoanIntDisabled = compLoanLcOsLoanIntDisabled;
	}

	public boolean isCompLoanFcNetAmountDisabled() {
		return compLoanFcNetAmountDisabled;
	}

	public void setCompLoanFcNetAmountDisabled(
			boolean compLoanFcNetAmountDisabled) {
		this.compLoanFcNetAmountDisabled = compLoanFcNetAmountDisabled;
	}

	public boolean isCompLoanLcNetAmountDisabled() {
		return compLoanLcNetAmountDisabled;
	}

	public void setCompLoanLcNetAmountDisabled(
			boolean compLoanLcNetAmountDisabled) {
		this.compLoanLcNetAmountDisabled = compLoanLcNetAmountDisabled;
	}

	public boolean isCompLoanFcRepayAmtDisabled() {
		return compLoanFcRepayAmtDisabled;
	}

	public void setCompLoanFcRepayAmtDisabled(boolean compLoanFcRepayAmtDisabled) {
		this.compLoanFcRepayAmtDisabled = compLoanFcRepayAmtDisabled;
	}

	public boolean isCompLoanLcRepayAmtDisabled() {
		return compLoanLcRepayAmtDisabled;
	}

	public void setCompLoanLcRepayAmtDisabled(boolean compLoanLcRepayAmtDisabled) {
		this.compLoanLcRepayAmtDisabled = compLoanLcRepayAmtDisabled;
	}

	public boolean isCompLoanFcRepaidAmtDisabled() {
		return compLoanFcRepaidAmtDisabled;
	}

	public void setCompLoanFcRepaidAmtDisabled(
			boolean compLoanFcRepaidAmtDisabled) {
		this.compLoanFcRepaidAmtDisabled = compLoanFcRepaidAmtDisabled;
	}

	public boolean isCompLoanLcRepaidAmtDisabled() {
		return compLoanLcRepaidAmtDisabled;
	}

	public void setCompLoanLcRepaidAmtDisabled(
			boolean compLoanLcRepaidAmtDisabled) {
		this.compLoanLcRepaidAmtDisabled = compLoanLcRepaidAmtDisabled;
	}

	public boolean isCompLoanLcPermAmtDisabled() {
		return compLoanLcPermAmtDisabled;
	}

	public void setCompLoanLcPermAmtDisabled(boolean compLoanLcPermAmtDisabled) {
		this.compLoanLcPermAmtDisabled = compLoanLcPermAmtDisabled;
	}

	public boolean isCompLoanFcPermAmtDisabled() {
		return compLoanFcPermAmtDisabled;
	}

	public void setCompLoanFcPermAmtDisabled(boolean compLoanFcPermAmtDisabled) {
		this.compLoanFcPermAmtDisabled = compLoanFcPermAmtDisabled;
	}

	public boolean isCompUiMLoanCodeDescDisabled() {
		return compUiMLoanCodeDescDisabled;
	}

	public void setCompUiMLoanCodeDescDisabled(
			boolean compUiMLoanCodeDescDisabled) {
		this.compUiMLoanCodeDescDisabled = compUiMLoanCodeDescDisabled;
	}

	/**
	 * [ BugId:PREMIAGDC-0155 Mallika 17-Mar-09 On tab out from all FC amounts,
	 * LC amount should be defaulted
	 */
	public void LOAN_FC_NET_AMOUNT_Validator(FacesContext context,
			UIComponent component, Object valObject) {
		Double value = (Double) valObject;
		getPT_IL_LOAN_BEAN().setLOAN_FC_NET_AMOUNT(value);
		getPT_IL_LOAN_BEAN().setLOAN_LC_NET_AMOUNT(value);
		getCOMP_LOAN_LC_NET_AMOUNT().resetValue();

		/*
		 * if (getCOMP_LOAN_FC_NET_AMOUNT().getSubmittedValue() != null) {
		 * String fcNetAmount = (String)getCOMP_LOAN_FC_NET_AMOUNT()
		 * .getSubmittedValue(); if (!"".equals(fcNetAmount)) { } }
		 */
	}

	public void LOAN_GR_FC_AMT_Validator(FacesContext context,
			UIComponent component, Object valObject) throws Exception {

		try {
			Double value = (Double) valObject;
			getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(value);
			getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(value);
			getCOMP_LOAN_LC_NET_AMOUNT().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		/*
		 * if (getCOMP_UI_M_LOAN_GR_FC_AMT().getSubmittedValue() != null) {
		 * String fcGrossAmount = (String)getCOMP_UI_M_LOAN_GR_FC_AMT()
		 * .getSubmittedValue(); if (!"".equals(fcGrossAmount)) {
		 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_FC_AMT(
		 * Double.parseDouble(fcGrossAmount));
		 * getPT_IL_LOAN_BEAN().setUI_M_LOAN_GR_LC_AMT(
		 * Double.parseDouble(fcGrossAmount)); } }
		 */
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public void executeSelectStatement() throws Exception {

		String selectStatement = "SELECT ROWID, PT_IL_LOAN.* FROM PT_IL_LOAN WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { PT_IL_LOAN_BEAN
							.getROWID() });

			PT_IL_LOAN_BEAN = this.getPT_IL_LOAN_BEAN();
			while (resultSet.next()) {
				PT_IL_LOAN_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_LOAN_BEAN
						.setLOAN_SYS_ID(resultSet.getLong("LOAN_SYS_ID"));
				PT_IL_LOAN_BEAN.setLOAN_POL_NO(resultSet
						.getString("LOAN_POL_NO"));
				PT_IL_LOAN_BEAN.setLOAN_POL_SYS_ID(resultSet
						.getLong("LOAN_POL_SYS_ID"));
				PT_IL_LOAN_BEAN.setLOAN_DT(resultSet.getDate("LOAN_DT"));
				PT_IL_LOAN_BEAN.setLOAN_CURR_CODE(resultSet
						.getString("LOAN_CURR_CODE"));
				PT_IL_LOAN_BEAN.setLOAN_EXCH_RATE(resultSet
						.getDouble("LOAN_EXCH_RATE"));
				PT_IL_LOAN_BEAN.setLOAN_REF_NO(resultSet
						.getString("LOAN_REF_NO"));
				PT_IL_LOAN_BEAN.setLOAN_LC_AMOUNT(resultSet
						.getDouble("LOAN_LC_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_FC_AMOUNT(resultSet
						.getDouble("LOAN_FC_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_INT_RATE(resultSet
						.getDouble("LOAN_INT_RATE"));
				PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM(resultSet
						.getDouble("LOAN_FC_UNPAID_PREM"));
				PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM(resultSet
						.getDouble("LOAN_LC_UNPAID_PREM"));
				PT_IL_LOAN_BEAN.setLOAN_FC_INTEREST(resultSet
						.getDouble("LOAN_FC_INTEREST"));
				PT_IL_LOAN_BEAN.setLOAN_LC_INTEREST(resultSet
						.getDouble("LOAN_LC_INTEREST"));
				PT_IL_LOAN_BEAN.setLOAN_FC_OS_AMOUNT(resultSet
						.getDouble("LOAN_FC_OS_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_OS_AMOUNT(resultSet
						.getDouble("LOAN_LC_OS_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_FC_NET_AMOUNT(resultSet
						.getDouble("LOAN_FC_NET_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_NET_AMOUNT(resultSet
						.getDouble("LOAN_LC_NET_AMOUNT"));
				PT_IL_LOAN_BEAN.setLOAN_STATUS(resultSet
						.getString("LOAN_STATUS"));
				PT_IL_LOAN_BEAN.setLOAN_CR_DT(resultSet.getDate("LOAN_CR_DT"));
				PT_IL_LOAN_BEAN.setLOAN_CR_UID(resultSet
						.getString("LOAN_CR_UID"));
				PT_IL_LOAN_BEAN
						.setLOAN_UPD_DT(resultSet.getDate("LOAN_UPD_DT"));
				PT_IL_LOAN_BEAN.setLOAN_UPD_UID(resultSet
						.getString("LOAN_UPD_UID"));
				PT_IL_LOAN_BEAN.setLOAN_UNPAID_PREM_INT_CODE(resultSet
						.getString("LOAN_UNPAID_PREM_INT_CODE"));
				PT_IL_LOAN_BEAN.setLOAN_FC_UNPAID_PREM_INT(resultSet
						.getDouble("LOAN_FC_UNPAID_PREM_INT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_UNPAID_PREM_INT(resultSet
						.getDouble("LOAN_LC_UNPAID_PREM_INT"));
				PT_IL_LOAN_BEAN.setLOAN_FLAG(resultSet.getString("LOAN_FLAG"));
				PT_IL_LOAN_BEAN.setLOAN_FC_PERM_AMT(resultSet
						.getDouble("LOAN_FC_PERM_AMT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_PERM_AMT(resultSet
						.getDouble("LOAN_LC_PERM_AMT"));
				PT_IL_LOAN_BEAN.setLOAN_CODE(resultSet.getString("LOAN_CODE"));
				PT_IL_LOAN_BEAN.setLOAN_SURR_PERC(resultSet
						.getDouble("LOAN_SURR_PERC"));
				PT_IL_LOAN_BEAN.setLOAN_REPAY_FREQ(resultSet
						.getString("LOAN_REPAY_FREQ"));
				//added by saranya
				PT_IL_LOAN_BEAN.setLOAN_FREQ_TYPE(resultSet
						.getString("LOAN_FREQ_TYPE"));
				//end
				PT_IL_LOAN_BEAN.setLOAN_FC_REPAY_AMT(resultSet
						.getDouble("LOAN_FC_REPAY_AMT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_REPAY_AMT(resultSet
						.getDouble("LOAN_LC_REPAY_AMT"));
				PT_IL_LOAN_BEAN
						.setLOAN_DUE_DT(resultSet.getDate("LOAN_DUE_DT"));
				PT_IL_LOAN_BEAN.setLOAN_FC_OS_LOAN_INT(resultSet
						.getDouble("LOAN_FC_OS_LOAN_INT"));
				PT_IL_LOAN_BEAN.setLOAN_LC_OS_LOAN_INT(resultSet
						.getDouble("LOAN_LC_OS_LOAN_INT"));
				PT_IL_LOAN_BEAN.setLOAN_INT_RATE_PER(resultSet
						.getDouble("LOAN_INT_RATE_PER"));
				PT_IL_LOAN_BEAN.setLOAN_TERM(resultSet.getInt("LOAN_TERM"));
				PT_IL_LOAN_BEAN.setLOAN_FLEX_04(resultSet
						.getString("LOAN_FLEX_04"));
				PT_IL_LOAN_BEAN.setLOAN_FLEX_05(resultSet
						.getString("LOAN_FLEX_05"));
				PT_IL_LOAN_BEAN.setLOAN_FLEX_06(resultSet
						.getString("LOAN_FLEX_06"));
				
				/*Added by saritha on 11-01-2019 for KIC LoanTerm Type value reseting*/
				PT_IL_LOAN_BEAN.setLOAN_FLEX_17(resultSet.getString("LOAN_FLEX_17"));
				/*End*/
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	/**
	 * BugId:PREMIAGDC-0155 Mallika 17-Mar-09 ]
	 * 
	 * @throws Exception
	 */

	public void repaymentButtonClick() throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT PT_IL_LOAN.ROWID,LOAN_REF_NO FROM PT_IL_LOAN WHERE LOAN_REF_NO = ? ";
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_LOAN_BEAN.getLOAN_REF_NO() });
			if (resultSet.next()) {
				PT_IL_LOAN_BEAN.setROWID(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void validateLOAN_FLEX_04(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			getPT_IL_LOAN_BEAN().setLOAN_FLEX_04((String) value);

			if ("EFT".equalsIgnoreCase(PT_IL_LOAN_BEAN.getLOAN_FLEX_04())) {
				this.getCOMP_ACC_NO().setRequired(true);
				this.getCOMP_MICR_CODE().setRequired(true);
			} else {
				this.getCOMP_ACC_NO().setRequired(false);
				this.getCOMP_MICR_CODE().setRequired(false);
			}
			// COMP_TYPE.resetValue();
			COMP_MICR_CODE.resetValue();
			COMP_ACC_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();

			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_OCC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void chkMICRCode(String micrCode) throws Exception {
		String query = "SELECT 'X' FROM PM_BANK_DTLS WHERE PMD_MICR_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query,
					connection, new Object[] { micrCode });
			if (resultSet.next()) {
				// return x
			} else {
				throw new Exception("Invalid MICR Code.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}

	public void validateLOAN_FLEX_05(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			
			String value_1 = (String) value;
			PT_IL_LOAN_BEAN.setLOAN_FLEX_05((String) value);
			chkMICRCode(value_1);

			// COMP_MICR_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_OCC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateLOAN_FLEX_06(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			PT_IL_LOAN_BEAN.setLOAN_FLEX_06((String) value);

			// COMP_ACC_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_OCC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void fetchDetails() throws Exception {
		Connection con = null;
		String c1 = "SELECT POL_CONT_AD_ACC_NO,POL_MICR_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String M_ACC_NO = null;
		String M_MICR_CODE = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(c1, con,
					new Object[] { PT_IL_LOAN_BEAN.getLOAN_POL_SYS_ID() });
			while (rs.next()) {
				M_ACC_NO = rs.getString(1);
				M_MICR_CODE = rs.getString(2);
			}
			PT_IL_LOAN_BEAN.setLOAN_FLEX_06(M_ACC_NO);
			PT_IL_LOAN_BEAN.setLOAN_FLEX_05(M_MICR_CODE);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			CommonUtils.closeCursor(rs);
		}
	}

	public String COMP_BUT_OK_PRESS() {
		try {
			saveFormDetails();
			// CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PILT004_PT_IL_LOAN";
	}

	public HtmlOutputLabel getCOMP_LOAN_TERM_LABEL() {
		return COMP_LOAN_TERM_LABEL;
	}

	public void setCOMP_LOAN_TERM_LABEL(HtmlOutputLabel comp_loan_term_label) {
		COMP_LOAN_TERM_LABEL = comp_loan_term_label;
	}

	public HtmlInputText getCOMP_LOAN_TERM() {
		return COMP_LOAN_TERM;
	}

	public void setCOMP_LOAN_TERM(HtmlInputText comp_loan_term) {
		COMP_LOAN_TERM = comp_loan_term;
	}

	public HtmlSelectOneMenu getCOMP_TYPE() {
		return COMP_TYPE;
	}

	public void setCOMP_TYPE(HtmlSelectOneMenu comp_type) {
		COMP_TYPE = comp_type;
	}

	public HtmlInputText getCOMP_MICR_CODE() {
		return COMP_MICR_CODE;
	}

	public void setCOMP_MICR_CODE(HtmlInputText comp_micr_code) {
		COMP_MICR_CODE = comp_micr_code;
	}

	public HtmlInputText getCOMP_ACC_NO() {
		return COMP_ACC_NO;
	}

	public void setCOMP_ACC_NO(HtmlInputText comp_acc_no) {
		COMP_ACC_NO = comp_acc_no;
	}

	public HtmlOutputLabel getCOMP_TYPE_LABEL() {
		return COMP_TYPE_LABEL;
	}

	public void setCOMP_TYPE_LABEL(HtmlOutputLabel comp_type_label) {
		COMP_TYPE_LABEL = comp_type_label;
	}

	public HtmlOutputLabel getCOMP_MICR_CODE_LABEL() {
		return COMP_MICR_CODE_LABEL;
	}

	public void setCOMP_MICR_CODE_LABEL(HtmlOutputLabel comp_micr_code_label) {
		COMP_MICR_CODE_LABEL = comp_micr_code_label;
	}

	public HtmlOutputLabel getCOMP_ACC_NO_LABEL() {
		return COMP_ACC_NO_LABEL;
	}

	public void setCOMP_ACC_NO_LABEL(HtmlOutputLabel comp_acc_no_label) {
		COMP_ACC_NO_LABEL = comp_acc_no_label;
	}

	public List<SelectItem> getListLOAN_FLEX_04() {
		return listLOAN_FLEX_04;
	}

	public void setListLOAN_FLEX_04(List<SelectItem> listLOAN_FLEX_04) {
		this.listLOAN_FLEX_04 = listLOAN_FLEX_04;
	}

	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		List<SelectItem> listStandard = new ArrayList<SelectItem>();
		listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		listStandard.add(new SelectItem("EFT", "EFT"));
		setListLOAN_FLEX_04(listStandard);

		
		
		/*List<SelectItem> listStandard1 = new ArrayList<SelectItem>();
		/*listStandard1.add(new SelectItem("INTEREST", "INTEREST"));
		listStandard1.add(new SelectItem("EMI", "EMI"));
		setFrequencyComboList(listStandard1);*/
		/*setFrequencyComboList(ListItemUtil.getDropDownListValue(connection,
		        "PILT004", "PP_LIST_ITEM_VALUES",
		        "PP_LIST_ITEM_VALUES.LIV_CODE_DESC", "IL_REPM_TYP"));*/
		
		
		/* Added by saranya for frequency feild is harcoded before*/
		
		setFrequencyComboList(ListItemUtil.getDropDownListValue(connection,
		        "PILT004", "PT_IL_LOAN",
		        "PT_IL_LOAN.LOAN_FREQ_TYPE", "IL_REPM_TYP"));
		//End
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
  /*committted by Dhinesh for SSP call id FALCONQC-1714734*/
	public double select_surr_per()throws Exception
	{
	Connection connection = null;
	connection = CommonUtils.getConnection();
	ResultSet resultSet = null;
	CRUDHandler handler = new CRUDHandler();
	double surr_per_value=0.00;
	String pol_no=PT_IL_LOAN_BEAN.getLOAN_POL_NO();


	String query ="SELECT PLAN_LOAN_PER FROM PM_IL_PLAN, PT_IL_POLICY WHERE PLAN_CODE = POL_PLAN_CODE AND POL_NO='"+pol_no+"'";
	System.out.println("query---------->"+query);
	resultSet = new CRUDHandler().executeSelectStatement(query, connection);

	while (resultSet.next()) {
		surr_per_value=resultSet.getInt("PLAN_LOAN_PER");
		
	}
	PT_IL_LOAN_BEAN.setLOAN_SURR_PERC(surr_per_value);
	System.out.println("value of bean after query "+PT_IL_LOAN_BEAN.getLOAN_SURR_PERC());
	return surr_per_value ;
}
	/*End*/
	
	
	 /*Added By Janani on 3.01.2017 for DMS Integration*/
	
	
	
	 public void callReportModalPanel(ActionEvent event) {
		 String input = event.getComponent().getId();
		 runAction_DMS();
		 try {
		
				 String dmsUrl = new DMSUtil().getDmsUrl();
				 System.out.println("PT_IL_LOAN_ACTION.invokeDMS()" + dmsUrl);
				 setRedirectUrl(dmsUrl);
			
						

			 if (getRedirectUrl() != null) {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			 } else {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			 }

		 } catch (Exception e) {
			 e.printStackTrace();
		 }

	 }

	
	 public String runAction_DMS() {
		 System.out.println("PT_IL_LOAN_ACTION.invokeDMS()");
		 try {

		 } catch (Exception e) {
			
		 }
		 return "";

	 }
	 
	 /*End*/

		//Newly added below code on 19.2.2017 by Dhinesh


		private List<SelectItem> LOAN_FLEX_17ComboList = new ArrayList();
		
		private HtmlSelectOneMenu COMP_LOAN_FLEX_17;
		private HtmlOutputLabel COMP_LOAN_FLEX_17_LABEL;
		
		public HtmlSelectOneMenu getCOMP_LOAN_FLEX_17() {
			return COMP_LOAN_FLEX_17;
		}

		public void setCOMP_LOAN_FLEX_17(HtmlSelectOneMenu cOMP_LOAN_FLEX_17) {
			COMP_LOAN_FLEX_17 = cOMP_LOAN_FLEX_17;
		}

		public HtmlOutputLabel getCOMP_LOAN_FLEX_17_LABEL() {
			return COMP_LOAN_FLEX_17_LABEL;
		}

		public void setCOMP_LOAN_FLEX_17_LABEL(HtmlOutputLabel cOMP_LOAN_FLEX_17_LABEL) {
			COMP_LOAN_FLEX_17_LABEL = cOMP_LOAN_FLEX_17_LABEL;
		}

		public List<SelectItem> getLOAN_FLEX_17ComboList()
		  {
		    if (this.LOAN_FLEX_17ComboList.size() == 0) {
		      this.LOAN_FLEX_17ComboList.clear();
		      try {
		        Connection con = CommonUtils.getConnection();
		        this.LOAN_FLEX_17ComboList = ListItemUtil.getDropDownListValue(con, 
		          "PILT004", "PT_IL_LOAN", "PT_IL_LOAN.LOAN_FLEX_17", 
		          "IL_TERM_EDIT");
		      }
		      catch (Exception e)
		      {
		        System.out.println("PT_IL_LOAN_ACTION.getLOAN_FLEX_17ComboList()ERrror");

		        e.printStackTrace();
		        throw new ValidatorException(new FacesMessage(e.getMessage()));
		      }
		    }

		    return this.LOAN_FLEX_17ComboList;
		  }

		  public void setLOAN_FLEX_17ComboList(List<SelectItem> lOAN_FLEX_17ComboList) {
		    this.LOAN_FLEX_17ComboList = lOAN_FLEX_17ComboList;
		  }



		public void LOAN_FLEX_17_Validation(FacesContext context,
					UIComponent component, Object value) {
				
				try 
				{
					System.out.println("LOAN_FLEX_17_Validation   :  ");
					getPT_IL_LOAN_BEAN().setLOAN_FLEX_17((String) value);
					
					
					if(!PT_IL_LOAN_BEAN.getLOAN_FLEX_17().equalsIgnoreCase("R"))
					{
					COMP_LOAN_TERM.setDisabled(false);
					}
					else
					{
						int loan_Term = LoanTermCheck(); 
						System.out.println("loan_Term   : "+loan_Term);
						getPT_IL_LOAN_BEAN().setLOAN_TERM(loan_Term);
						COMP_LOAN_TERM.setDisabled(true);
					}
					
					COMP_LOAN_TERM.resetValue();
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
				}
				
			}
		
	// End 
		// Newly added  by Dhinesh on 19.2.2017 suggested by ajay

		public int LoanTermCheck() throws Exception {
				int loan_Term = 1;
				Connection connection = null;
				ResultSet resultSet = null;
				CRUDHandler handler = new CRUDHandler();
				try {
					connection = CommonUtils.getConnection();
					String C1 = "SELECT FUNC_LOAN_TERM(?) LOANTERM FROM DUAL";
					resultSet = handler.executeSelectStatement(C1, connection,new Object[] { PT_IL_LOAN_BEAN.getLOAN_SYS_ID() });
					if (resultSet.next()) {
						loan_Term = resultSet.getInt(1);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
				
				return loan_Term;
			}

		/*Added by saritha on 11-01-2019 for KIC LoanTerm Type &Rate Per values reseting*/

		public void validate_LOAN_TERM(FacesContext facesContext,
				UIComponent component, Object value) throws ValidatorException {
			CommonUtils.clearMaps(this);
			try {

				PT_IL_LOAN_BEAN.setLOAN_TERM((Integer) value);
				
			} catch (Exception exception) {
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception
						.getMessage()));
			} finally {
				try {
					ErrorHelpUtil.getWarningForProcedure(CommonUtils
							.getConnection(), "LOAN_TERM", getWarningMap());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	
		public void validate_LOAN_INT_RATE_PER(FacesContext facesContext,
				UIComponent component, Object value) throws ValidatorException {
			CommonUtils.clearMaps(this);
			try {

				PT_IL_LOAN_BEAN.setLOAN_INT_RATE_PER((Double) value);
				
			} catch (Exception exception) {
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception
						.getMessage()));
			} finally {
				try {
					ErrorHelpUtil.getWarningForProcedure(CommonUtils
							.getConnection(), "LOAN_INT_RATE_PER", getWarningMap());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	
		/*End*/

	
	

}
