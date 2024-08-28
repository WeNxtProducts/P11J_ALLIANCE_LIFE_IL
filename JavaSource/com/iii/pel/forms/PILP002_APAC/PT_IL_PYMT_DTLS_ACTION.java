package com.iii.pel.forms.PILP002_APAC;

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
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UICalendar;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT003_APAC.PT_IL_PREM_COLL;
import com.iii.pel.forms.PILT017.PILT017_QUERY_CONSTANTS;
import com.iii.pel.forms.PILT017.SqlConstants;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PYMT_DTLS_ACTION extends CommonAction {

	private boolean queryMode;

	private UIData dataTable;
	
	public COMPOSITE_ACTION_BEAN compositeAction;
	private HtmlCommandButton COMP_UI_M_BUT_MORE;

	private HtmlInputText COMP_PD_CUST_NAME;

	private HtmlOutputLabel COMP_PD_CC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PD_CC_TYPE;

	private HtmlOutputLabel COMP_UI_M_BANK_REF_NO_LABEL;

	private HtmlInputText COMP_UI_M_BANK_REF_NO;

	private HtmlOutputLabel COMP_UI_M_OUR_BANK_CODE_2_LABEL;

	private HtmlInputText COMP_UI_M_OUR_BANK_CODE_2;

	private HtmlOutputLabel COMP_PD_OUR_BANK_CODE_LABEL;

	private HtmlInputText COMP_PD_OUR_BANK_CODE;

	private HtmlOutputLabel COMP_PD_PO_MO_NO_LABEL;

	private HtmlInputText COMP_PD_PO_MO_NO;

	private HtmlOutputLabel COMP_UI_M_OUR_BANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_OUR_BANK_CODE;

	private HtmlOutputLabel COMP_UI_M_BANK_REF_NO_2_LABEL;
	
	private HtmlInputText COMP_UI_M_BANK_REF_NO_2;

	private HtmlOutputLabel COMP_UI_M_PD_CC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PD_CC_TYPE;

	private HtmlOutputLabel COMP_PD_SR_NO_LABEL;

	private HtmlInputText COMP_PD_SR_NO;

	private HtmlOutputLabel COMP_PD_CC_NO_LABEL;

	private HtmlInputText COMP_PD_CC_NO;

	private HtmlOutputLabel COMP_PD_PAY_MODE_LABEL;

	private HtmlSelectOneMenu COMP_PD_PAY_MODE;

	private HtmlOutputLabel COMP_PD_ATM_CARD_NO_LABEL;

	private HtmlInputText COMP_PD_ATM_CARD_NO;

	private HtmlOutputLabel COMP_PD_BANK_REF_NO_LABEL;

	private HtmlInputText COMP_PD_BANK_REF_NO;

	private HtmlOutputLabel COMP_UI_M_PD_CC_NO_LABEL;

	private HtmlInputText COMP_UI_M_PD_CC_NO;
	private HtmlInputText COMP_UI_M_PD_CC_NO_1;

	private HtmlOutputLabel COMP_PD_DATE_OF_CREDIT_LABEL;

	private HtmlCalendar COMP_PD_DATE_OF_CREDIT;

	private HtmlOutputLabel COMP_PD_PO_MO_DT_LABEL;

	private HtmlCalendar COMP_PD_PO_MO_DT;

	private HtmlOutputLabel COMP_PD_REM_SLIP_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_PD_REM_SLIP_GEN_YN;

	private HtmlOutputLabel COMP_UI_M_DATE_OF_CREDIT_1_LABEL;

	private HtmlCalendar COMP_UI_M_DATE_OF_CREDIT_1;

	private HtmlOutputLabel COMP_PD_CC_NAME_LABEL;

	private HtmlInputText COMP_PD_CC_NAME;

	private HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL;

	private HtmlInputText COMP_PD_DPD_REF_ID;

	private HtmlOutputLabel COMP_UI_M_PD_CC_APP_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PD_CC_APP_CODE;

	private HtmlOutputLabel COMP_UI_M_DATE_OF_CREDIT_LABEL;

	private HtmlCalendar COMP_UI_M_DATE_OF_CREDIT;

	private HtmlOutputLabel COMP_UI_M_CHQ_NO_LABEL;

	private HtmlInputText COMP_UI_M_CHQ_NO;

	private HtmlOutputLabel COMP_UI_M_REM_SLIP_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_REM_SLIP_GEN_YN;

	private HtmlOutputLabel COMP_PD_TT_REF_NO_LABEL;

	private HtmlInputText COMP_PD_TT_REF_NO;

	private HtmlOutputLabel COMP_PD_CR_ADVICE_NO_LABEL;

	private HtmlInputText COMP_PD_CR_ADVICE_NO;

	private HtmlOutputLabel COMP_PD_BANK_NAME_LABEL;

	private HtmlInputText COMP_PD_BANK_NAME;

	private HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL;

	private HtmlInputText COMP_PD_BRANCH_NAME;

	private HtmlOutputLabel COMP_PD_CUST_NAME_LABEL;

	private HtmlOutputLabel COMP_PD_ADDR_01_LABEL;

	private HtmlInputText COMP_PD_ADDR_01;

	private HtmlOutputLabel COMP_PD_ADDR_02_LABEL;

	private HtmlInputText COMP_PD_ADDR_02;

	private HtmlOutputLabel COMP_PD_ADDR_03_LABEL;

	private HtmlInputText COMP_PD_ADDR_03;

	private HtmlOutputLabel COMP_PD_REMARKS_LABEL;

	private HtmlInputText COMP_PD_REMARKS;

	private HtmlOutputLabel COMP_PD_CURR_CODE_LABEL;

	private HtmlInputText COMP_PD_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PD_LC_CHARGE;

	private HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PD_FC_CHARGE;

	private HtmlOutputLabel COMP_PD_FC_AMT_LABEL;

	private HtmlInputText COMP_PD_FC_AMT;

	private HtmlOutputLabel COMP_PD_REM_AMT_LABEL;

	private HtmlInputText COMP_PD_REM_AMT;

	private HtmlOutputLabel COMP_PD_CC_APP_CODE_LABEL;

	private HtmlInputText COMP_PD_CC_APP_CODE;

	private HtmlOutputLabel COMP_UI_M_BANK_REF_NO_1_LABEL;

	private HtmlInputText COMP_UI_M_BANK_REF_NO_1;

	private HtmlOutputLabel COMP_PD_TT_CURR_CODE_LABEL;

	private HtmlInputText COMP_PD_TT_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_BANK_NAME_DESC_LABEL;
	private HtmlInputText COMP_UI_M_BANK_NAME_DESC;
	private HtmlOutputLabel COMP_PD_LC_AMT_LABEL;
	private HtmlInputText COMP_PD_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_OUR_BANK_CODE_1_LABEL;
	private HtmlInputText COMP_UI_M_OUR_BANK_CODE_1;
	private HtmlOutputLabel COMP_UI_M_EXP_DT_LABEL;
	private HtmlCalendar COMP_UI_M_EXP_DT;
	private HtmlOutputLabel COMP_UI_M_DATE_OF_CREDIT_2_LABEL;
	private HtmlCalendar COMP_UI_M_DATE_OF_CREDIT_2;
	private HtmlOutputLabel COMP_PD_PAYIN_DATE_LABEL;
	private HtmlCalendar COMP_PD_PAYIN_DATE;

	private HtmlOutputLabel COMP_PD_PAID_FOR_LABEL;

	private HtmlSelectOneMenu COMP_PD_PAID_FOR;

	private HtmlOutputLabel COMP_PD_CHQ_NO_LABEL;

	private HtmlInputText COMP_PD_CHQ_NO;

	private HtmlOutputLabel COMP_PD_CHQ_DT_LABEL;
	private HtmlCalendar COMP_PD_CHQ_DT;
	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;
	private PT_IL_PYMT_DTLS_HELPER helper;

	private PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();

	String errorMessage = Messages.getString("messageProperties-PM006_A_APAC",
			"PILT017$PT_IL_PYMT_DTLS$PD_LC_CHARGE$ERROR$CAPTION");

	private int currPage;

	private int recordsPerPage = 5;

	ArrayList deletedIndexList = new ArrayList();

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private List lovCurrCodeList = new ArrayList();

	private List lovBankNameList = new ArrayList();

	private List<PT_IL_PYMT_DTLS> dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();

	private List<SelectItem> PD_PAY_MODE_LIST;

	private List<SelectItem> PD_PAID_FOR_LIST;

	private List<SelectItem> PD_CC_TYPE_LIST;

	private List<SelectItem> M_PD_CC_TYPE_LIST;

	private List<SelectItem> PD_REM_SLIP_GEN_LIST;

	private List<SelectItem> M_PD_REM_SLIP_GEN_LIST;

	private String outcome;

	static int serialno = 0;

	private List<PT_IL_PYMT_DTLS> locConditionList = null;

	public List<SelectItem> getPD_PAY_MODE_LIST() {
		return PD_PAY_MODE_LIST;

	}

	public void setPD_PAY_MODE_LIST(List<SelectItem> pd_pay_mode_list) {
		PD_PAY_MODE_LIST = pd_pay_mode_list;
	}

	public List<SelectItem> getPD_PAID_FOR_LIST() {
		return PD_PAID_FOR_LIST;
	}

	public void setPD_PAID_FOR_LIST(List<SelectItem> pd_paid_for_list) {
		PD_PAID_FOR_LIST = pd_paid_for_list;
	}

	public List getLovCurrCodeList() {
		return lovCurrCodeList;
	}

	public void setLovCurrCodeList(List lovCurrCodeList) {
		this.lovCurrCodeList = lovCurrCodeList;
	}

	public List getLovBankNameList() {
		return lovBankNameList;
	}

	public void setLovBankNameList(List lovBankNameList) {
		this.lovBankNameList = lovBankNameList;
	}

	public HtmlOutputLabel getCOMP_PD_CC_TYPE_LABEL() {
		return COMP_PD_CC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PD_CC_TYPE() {
		return COMP_PD_CC_TYPE;
	}

	public void setCOMP_PD_CC_TYPE_LABEL(HtmlOutputLabel COMP_PD_CC_TYPE_LABEL) {
		this.COMP_PD_CC_TYPE_LABEL = COMP_PD_CC_TYPE_LABEL;
	}

	public void setCOMP_PD_CC_TYPE(HtmlSelectOneMenu COMP_PD_CC_TYPE) {
		this.COMP_PD_CC_TYPE = COMP_PD_CC_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_REF_NO_LABEL() {
		return COMP_UI_M_BANK_REF_NO_LABEL;
	}

	public void setCOMP_UI_M_BANK_REF_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_BANK_REF_NO_LABEL) {
		this.COMP_UI_M_BANK_REF_NO_LABEL = COMP_UI_M_BANK_REF_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_OUR_BANK_CODE_2_LABEL() {
		return COMP_UI_M_OUR_BANK_CODE_2_LABEL;
	}

	public void setCOMP_UI_M_OUR_BANK_CODE_2_LABEL(
			HtmlOutputLabel COMP_UI_M_OUR_BANK_CODE_2_LABEL) {
		this.COMP_UI_M_OUR_BANK_CODE_2_LABEL = COMP_UI_M_OUR_BANK_CODE_2_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_OUR_BANK_CODE_LABEL() {
		return COMP_PD_OUR_BANK_CODE_LABEL;
	}

	public void setCOMP_PD_OUR_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_PD_OUR_BANK_CODE_LABEL) {
		this.COMP_PD_OUR_BANK_CODE_LABEL = COMP_PD_OUR_BANK_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_PO_MO_NO_LABEL() {
		return COMP_PD_PO_MO_NO_LABEL;
	}

	public void setCOMP_PD_PO_MO_NO_LABEL(HtmlOutputLabel COMP_PD_PO_MO_NO_LABEL) {
		this.COMP_PD_PO_MO_NO_LABEL = COMP_PD_PO_MO_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_OUR_BANK_CODE_LABEL() {
		return COMP_UI_M_OUR_BANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_OUR_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_OUR_BANK_CODE_LABEL) {
		this.COMP_UI_M_OUR_BANK_CODE_LABEL = COMP_UI_M_OUR_BANK_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_REF_NO_2_LABEL() {
		return COMP_UI_M_BANK_REF_NO_2_LABEL;
	}

	public void setCOMP_UI_M_BANK_REF_NO_2_LABEL(
			HtmlOutputLabel COMP_UI_M_BANK_REF_NO_2_LABEL) {
		this.COMP_UI_M_BANK_REF_NO_2_LABEL = COMP_UI_M_BANK_REF_NO_2_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CC_TYPE_LABEL() {
		return COMP_UI_M_PD_CC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PD_CC_TYPE() {
		return COMP_UI_M_PD_CC_TYPE;
	}

	public void setCOMP_UI_M_PD_CC_TYPE_LABEL(
			HtmlOutputLabel COMP_UI_M_PD_CC_TYPE_LABEL) {
		this.COMP_UI_M_PD_CC_TYPE_LABEL = COMP_UI_M_PD_CC_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PD_CC_TYPE(HtmlSelectOneMenu COMP_UI_M_PD_CC_TYPE) {
		this.COMP_UI_M_PD_CC_TYPE = COMP_UI_M_PD_CC_TYPE;
	}

	public HtmlOutputLabel getCOMP_PD_SR_NO_LABEL() {
		return COMP_PD_SR_NO_LABEL;
	}

	public void setCOMP_PD_SR_NO_LABEL(HtmlOutputLabel COMP_PD_SR_NO_LABEL) {
		this.COMP_PD_SR_NO_LABEL = COMP_PD_SR_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_CC_NO_LABEL() {
		return COMP_PD_CC_NO_LABEL;
	}

	public void setCOMP_PD_CC_NO_LABEL(HtmlOutputLabel COMP_PD_CC_NO_LABEL) {
		this.COMP_PD_CC_NO_LABEL = COMP_PD_CC_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_PAY_MODE_LABEL() {
		return COMP_PD_PAY_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PD_PAY_MODE() {
		return COMP_PD_PAY_MODE;
	}

	public void setCOMP_PD_PAY_MODE_LABEL(HtmlOutputLabel COMP_PD_PAY_MODE_LABEL) {
		this.COMP_PD_PAY_MODE_LABEL = COMP_PD_PAY_MODE_LABEL;
	}

	public void setCOMP_PD_PAY_MODE(HtmlSelectOneMenu COMP_PD_PAY_MODE) {
		this.COMP_PD_PAY_MODE = COMP_PD_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_PD_ATM_CARD_NO_LABEL() {
		return COMP_PD_ATM_CARD_NO_LABEL;
	}

	public void setCOMP_PD_ATM_CARD_NO_LABEL(
			HtmlOutputLabel COMP_PD_ATM_CARD_NO_LABEL) {
		this.COMP_PD_ATM_CARD_NO_LABEL = COMP_PD_ATM_CARD_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_BANK_REF_NO_LABEL() {
		return COMP_PD_BANK_REF_NO_LABEL;
	}

	public void setCOMP_PD_BANK_REF_NO_LABEL(
			HtmlOutputLabel COMP_PD_BANK_REF_NO_LABEL) {
		this.COMP_PD_BANK_REF_NO_LABEL = COMP_PD_BANK_REF_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CC_NO_LABEL() {
		return COMP_UI_M_PD_CC_NO_LABEL;
	}

	public void setCOMP_UI_M_PD_CC_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_PD_CC_NO_LABEL) {
		this.COMP_UI_M_PD_CC_NO_LABEL = COMP_UI_M_PD_CC_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_DATE_OF_CREDIT_LABEL() {
		return COMP_PD_DATE_OF_CREDIT_LABEL;
	}

	public void setCOMP_PD_DATE_OF_CREDIT_LABEL(
			HtmlOutputLabel COMP_PD_DATE_OF_CREDIT_LABEL) {
		this.COMP_PD_DATE_OF_CREDIT_LABEL = COMP_PD_DATE_OF_CREDIT_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_PO_MO_DT_LABEL() {
		return COMP_PD_PO_MO_DT_LABEL;
	}

	public void setCOMP_PD_PO_MO_DT_LABEL(HtmlOutputLabel COMP_PD_PO_MO_DT_LABEL) {
		this.COMP_PD_PO_MO_DT_LABEL = COMP_PD_PO_MO_DT_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_REM_SLIP_GEN_YN_LABEL() {
		return COMP_PD_REM_SLIP_GEN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PD_REM_SLIP_GEN_YN() {
		return COMP_PD_REM_SLIP_GEN_YN;
	}

	public void setCOMP_PD_REM_SLIP_GEN_YN_LABEL(
			HtmlOutputLabel COMP_PD_REM_SLIP_GEN_YN_LABEL) {
		this.COMP_PD_REM_SLIP_GEN_YN_LABEL = COMP_PD_REM_SLIP_GEN_YN_LABEL;
	}

	public void setCOMP_PD_REM_SLIP_GEN_YN(
			HtmlSelectOneMenu COMP_PD_REM_SLIP_GEN_YN) {
		this.COMP_PD_REM_SLIP_GEN_YN = COMP_PD_REM_SLIP_GEN_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_DATE_OF_CREDIT_1_LABEL() {
		return COMP_UI_M_DATE_OF_CREDIT_1_LABEL;
	}

	public void setCOMP_UI_M_DATE_OF_CREDIT_1_LABEL(
			HtmlOutputLabel COMP_UI_M_DATE_OF_CREDIT_1_LABEL) {
		this.COMP_UI_M_DATE_OF_CREDIT_1_LABEL = COMP_UI_M_DATE_OF_CREDIT_1_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_CC_NAME_LABEL() {
		return COMP_PD_CC_NAME_LABEL;
	}

	public void setCOMP_PD_CC_NAME_LABEL(HtmlOutputLabel COMP_PD_CC_NAME_LABEL) {
		this.COMP_PD_CC_NAME_LABEL = COMP_PD_CC_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_DPD_REF_ID_LABEL() {
		return COMP_PD_DPD_REF_ID_LABEL;
	}

	public void setCOMP_PD_DPD_REF_ID_LABEL(
			HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL) {
		this.COMP_PD_DPD_REF_ID_LABEL = COMP_PD_DPD_REF_ID_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CC_APP_CODE_LABEL() {
		return COMP_UI_M_PD_CC_APP_CODE_LABEL;
	}

	public void setCOMP_UI_M_PD_CC_APP_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_PD_CC_APP_CODE_LABEL) {
		this.COMP_UI_M_PD_CC_APP_CODE_LABEL = COMP_UI_M_PD_CC_APP_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_DATE_OF_CREDIT_LABEL() {
		return COMP_UI_M_DATE_OF_CREDIT_LABEL;
	}

	public void setCOMP_UI_M_DATE_OF_CREDIT_LABEL(
			HtmlOutputLabel COMP_UI_M_DATE_OF_CREDIT_LABEL) {
		this.COMP_UI_M_DATE_OF_CREDIT_LABEL = COMP_UI_M_DATE_OF_CREDIT_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHQ_NO_LABEL() {
		return COMP_UI_M_CHQ_NO_LABEL;
	}

	public void setCOMP_UI_M_CHQ_NO_LABEL(HtmlOutputLabel COMP_UI_M_CHQ_NO_LABEL) {
		this.COMP_UI_M_CHQ_NO_LABEL = COMP_UI_M_CHQ_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_REM_SLIP_GEN_YN_LABEL() {
		return COMP_UI_M_REM_SLIP_GEN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_REM_SLIP_GEN_YN() {
		return COMP_UI_M_REM_SLIP_GEN_YN;
	}

	public void setCOMP_UI_M_REM_SLIP_GEN_YN_LABEL(
			HtmlOutputLabel COMP_UI_M_REM_SLIP_GEN_YN_LABEL) {
		this.COMP_UI_M_REM_SLIP_GEN_YN_LABEL = COMP_UI_M_REM_SLIP_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_REM_SLIP_GEN_YN(
			HtmlSelectOneMenu COMP_UI_M_REM_SLIP_GEN_YN) {
		this.COMP_UI_M_REM_SLIP_GEN_YN = COMP_UI_M_REM_SLIP_GEN_YN;
	}

	public HtmlOutputLabel getCOMP_PD_TT_REF_NO_LABEL() {
		return COMP_PD_TT_REF_NO_LABEL;
	}

	public void setCOMP_PD_TT_REF_NO_LABEL(
			HtmlOutputLabel COMP_PD_TT_REF_NO_LABEL) {
		this.COMP_PD_TT_REF_NO_LABEL = COMP_PD_TT_REF_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_CR_ADVICE_NO_LABEL() {
		return COMP_PD_CR_ADVICE_NO_LABEL;
	}

	public void setCOMP_PD_CR_ADVICE_NO_LABEL(
			HtmlOutputLabel COMP_PD_CR_ADVICE_NO_LABEL) {
		this.COMP_PD_CR_ADVICE_NO_LABEL = COMP_PD_CR_ADVICE_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_BANK_NAME_LABEL() {
		return COMP_PD_BANK_NAME_LABEL;
	}

	public void setCOMP_PD_BANK_NAME_LABEL(
			HtmlOutputLabel COMP_PD_BANK_NAME_LABEL) {
		this.COMP_PD_BANK_NAME_LABEL = COMP_PD_BANK_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_BRANCH_NAME_LABEL() {
		return COMP_PD_BRANCH_NAME_LABEL;
	}

	public void setCOMP_PD_BRANCH_NAME_LABEL(
			HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL) {
		this.COMP_PD_BRANCH_NAME_LABEL = COMP_PD_BRANCH_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_CUST_NAME_LABEL() {
		return COMP_PD_CUST_NAME_LABEL;
	}

	public void setCOMP_PD_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_PD_CUST_NAME_LABEL) {
		this.COMP_PD_CUST_NAME_LABEL = COMP_PD_CUST_NAME_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_01_LABEL() {
		return COMP_PD_ADDR_01_LABEL;
	}

	public void setCOMP_PD_ADDR_01_LABEL(HtmlOutputLabel COMP_PD_ADDR_01_LABEL) {
		this.COMP_PD_ADDR_01_LABEL = COMP_PD_ADDR_01_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_02_LABEL() {
		return COMP_PD_ADDR_02_LABEL;
	}

	public void setCOMP_PD_ADDR_02_LABEL(HtmlOutputLabel COMP_PD_ADDR_02_LABEL) {
		this.COMP_PD_ADDR_02_LABEL = COMP_PD_ADDR_02_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_03_LABEL() {
		return COMP_PD_ADDR_03_LABEL;
	}

	public void setCOMP_PD_ADDR_03_LABEL(HtmlOutputLabel COMP_PD_ADDR_03_LABEL) {
		this.COMP_PD_ADDR_03_LABEL = COMP_PD_ADDR_03_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_REMARKS_LABEL() {
		return COMP_PD_REMARKS_LABEL;
	}

	public void setCOMP_PD_REMARKS_LABEL(HtmlOutputLabel COMP_PD_REMARKS_LABEL) {
		this.COMP_PD_REMARKS_LABEL = COMP_PD_REMARKS_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_CURR_CODE_LABEL() {
		return COMP_PD_CURR_CODE_LABEL;
	}

	public void setCOMP_PD_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_PD_CURR_CODE_LABEL) {
		this.COMP_PD_CURR_CODE_LABEL = COMP_PD_CURR_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_PD_CURR_CODE_DESC_LABEL = COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_LC_CHARGE_LABEL() {
		return COMP_PD_LC_CHARGE_LABEL;
	}

	public void setCOMP_PD_LC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL) {
		this.COMP_PD_LC_CHARGE_LABEL = COMP_PD_LC_CHARGE_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_FC_CHARGE_LABEL() {
		return COMP_PD_FC_CHARGE_LABEL;
	}

	public void setCOMP_PD_FC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL) {
		this.COMP_PD_FC_CHARGE_LABEL = COMP_PD_FC_CHARGE_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_FC_AMT_LABEL() {
		return COMP_PD_FC_AMT_LABEL;
	}

	public void setCOMP_PD_FC_AMT_LABEL(HtmlOutputLabel COMP_PD_FC_AMT_LABEL) {
		this.COMP_PD_FC_AMT_LABEL = COMP_PD_FC_AMT_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_REM_AMT_LABEL() {
		return COMP_PD_REM_AMT_LABEL;
	}

	public void setCOMP_PD_REM_AMT_LABEL(HtmlOutputLabel COMP_PD_REM_AMT_LABEL) {
		this.COMP_PD_REM_AMT_LABEL = COMP_PD_REM_AMT_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_CC_APP_CODE_LABEL() {
		return COMP_PD_CC_APP_CODE_LABEL;
	}

	public void setCOMP_PD_CC_APP_CODE_LABEL(
			HtmlOutputLabel COMP_PD_CC_APP_CODE_LABEL) {
		this.COMP_PD_CC_APP_CODE_LABEL = COMP_PD_CC_APP_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_REF_NO_1_LABEL() {
		return COMP_UI_M_BANK_REF_NO_1_LABEL;
	}

	public void setCOMP_UI_M_BANK_REF_NO_1_LABEL(
			HtmlOutputLabel COMP_UI_M_BANK_REF_NO_1_LABEL) {
		this.COMP_UI_M_BANK_REF_NO_1_LABEL = COMP_UI_M_BANK_REF_NO_1_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_TT_CURR_CODE_LABEL() {
		return COMP_PD_TT_CURR_CODE_LABEL;
	}

	public void setCOMP_PD_TT_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_PD_TT_CURR_CODE_LABEL) {
		this.COMP_PD_TT_CURR_CODE_LABEL = COMP_PD_TT_CURR_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_NAME_DESC_LABEL() {
		return COMP_UI_M_BANK_NAME_DESC_LABEL;
	}

	public void setCOMP_UI_M_BANK_NAME_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_BANK_NAME_DESC_LABEL) {
		this.COMP_UI_M_BANK_NAME_DESC_LABEL = COMP_UI_M_BANK_NAME_DESC_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_LC_AMT_LABEL() {
		return COMP_PD_LC_AMT_LABEL;
	}

	public void setCOMP_PD_LC_AMT_LABEL(HtmlOutputLabel COMP_PD_LC_AMT_LABEL) {
		this.COMP_PD_LC_AMT_LABEL = COMP_PD_LC_AMT_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_OUR_BANK_CODE_1_LABEL() {
		return COMP_UI_M_OUR_BANK_CODE_1_LABEL;
	}

	public void setCOMP_UI_M_OUR_BANK_CODE_1_LABEL(
			HtmlOutputLabel COMP_UI_M_OUR_BANK_CODE_1_LABEL) {
		this.COMP_UI_M_OUR_BANK_CODE_1_LABEL = COMP_UI_M_OUR_BANK_CODE_1_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_EXP_DT_LABEL() {
		return COMP_UI_M_EXP_DT_LABEL;
	}

	public void setCOMP_UI_M_EXP_DT_LABEL(HtmlOutputLabel COMP_UI_M_EXP_DT_LABEL) {
		this.COMP_UI_M_EXP_DT_LABEL = COMP_UI_M_EXP_DT_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_DATE_OF_CREDIT_2_LABEL() {
		return COMP_UI_M_DATE_OF_CREDIT_2_LABEL;
	}

	public void setCOMP_UI_M_DATE_OF_CREDIT_2_LABEL(
			HtmlOutputLabel COMP_UI_M_DATE_OF_CREDIT_2_LABEL) {
		this.COMP_UI_M_DATE_OF_CREDIT_2_LABEL = COMP_UI_M_DATE_OF_CREDIT_2_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_PAYIN_DATE_LABEL() {
		return COMP_PD_PAYIN_DATE_LABEL;
	}

	public void setCOMP_PD_PAYIN_DATE_LABEL(
			HtmlOutputLabel COMP_PD_PAYIN_DATE_LABEL) {
		this.COMP_PD_PAYIN_DATE_LABEL = COMP_PD_PAYIN_DATE_LABEL;
	}

	public HtmlOutputLabel getCOMP_PD_PAID_FOR_LABEL() {
		return COMP_PD_PAID_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PD_PAID_FOR() {
		return COMP_PD_PAID_FOR;
	}

	public void setCOMP_PD_PAID_FOR_LABEL(HtmlOutputLabel COMP_PD_PAID_FOR_LABEL) {
		this.COMP_PD_PAID_FOR_LABEL = COMP_PD_PAID_FOR_LABEL;
	}

	public void setCOMP_PD_PAID_FOR(HtmlSelectOneMenu COMP_PD_PAID_FOR) {
		this.COMP_PD_PAID_FOR = COMP_PD_PAID_FOR;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_NO_LABEL() {
		return COMP_PD_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_CHQ_NO() {
		return COMP_PD_CHQ_NO;
	}

	public void setCOMP_PD_CHQ_NO_LABEL(HtmlOutputLabel COMP_PD_CHQ_NO_LABEL) {
		this.COMP_PD_CHQ_NO_LABEL = COMP_PD_CHQ_NO_LABEL;
	}

	public void setCOMP_PD_CHQ_NO(HtmlInputText COMP_PD_CHQ_NO) {
		this.COMP_PD_CHQ_NO = COMP_PD_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_DT_LABEL() {
		return COMP_PD_CHQ_DT_LABEL;
	}

	public void setCOMP_PD_CHQ_DT_LABEL(HtmlOutputLabel COMP_PD_CHQ_DT_LABEL) {
		this.COMP_PD_CHQ_DT_LABEL = COMP_PD_CHQ_DT_LABEL;
	}

	public PT_IL_PYMT_DTLS getPT_IL_PYMT_DTLS_BEAN() {
		return PT_IL_PYMT_DTLS_BEAN;
	}

	public PT_IL_PYMT_DTLS_DB_CLASS getDbClass() {
		return dbClass;
	}

	public void setDbClass(PT_IL_PYMT_DTLS_DB_CLASS dbClass) {
		this.dbClass = dbClass;
	}

	public List<SelectItem> getPD_CC_TYPE_LIST() {
		return PD_CC_TYPE_LIST;
	}

	public void setPD_CC_TYPE_LIST(List<SelectItem> pd_cc_type_list) {
		PD_CC_TYPE_LIST = pd_cc_type_list;
	}

	public List<SelectItem> getM_PD_CC_TYPE_LIST() {
		return M_PD_CC_TYPE_LIST;
	}

	public void setM_PD_CC_TYPE_LIST(List<SelectItem> m_pd_cc_type_list) {
		M_PD_CC_TYPE_LIST = m_pd_cc_type_list;
	}

	public List<SelectItem> getPD_REM_SLIP_GEN_LIST() {
		return PD_REM_SLIP_GEN_LIST;
	}

	public void setPD_REM_SLIP_GEN_LIST(List<SelectItem> pd_rem_slip_gen_list) {
		PD_REM_SLIP_GEN_LIST = pd_rem_slip_gen_list;
	}

	public List<SelectItem> getM_PD_REM_SLIP_GEN_LIST() {
		return M_PD_REM_SLIP_GEN_LIST;
	}

	public void setM_PD_REM_SLIP_GEN_LIST(
			List<SelectItem> m_pd_rem_slip_gen_list) {
		M_PD_REM_SLIP_GEN_LIST = m_pd_rem_slip_gen_list;
	}

	public List<PT_IL_PYMT_DTLS> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PT_IL_PYMT_DTLS> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public void setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
		this.PT_IL_PYMT_DTLS_BEAN = PT_IL_PYMT_DTLS_BEAN;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public boolean isQueryMode() {
		return queryMode;
	}

	public void setQueryMode(boolean queryMode) {
		this.queryMode = queryMode;
	}

	public List fetchCurrCodeList(Object obj) {
		String currCode = (String) obj;
		locConditionList = dbClass.currCodeLov(currCode);
		return locConditionList;
	}

	public void getPD_CURR_CODE(ActionEvent event) {
		PT_IL_PYMT_DTLS bean = getPT_IL_PYMT_DTLS_BEAN();

		boolean keepLooking = true;
		String PD_CURR_CODE = null;
		String inputtext = getCurrentValue(event);
		PD_CURR_CODE = inputtext;
		if (PD_CURR_CODE != null && !PD_CURR_CODE.trim().isEmpty()) {
			bean.getPD_CURR_CODE();

			keepLooking = false;
		}
	}

	public void currDetails(ActionEvent event) {

		PT_IL_PYMT_DTLS bean = getPT_IL_PYMT_DTLS_BEAN();

		boolean keepLooking = true;
		String PD_CURR_CODE = null;
		UIInput inputtext = (UIInput) event.getComponent().getParent()
				.getParent();
		PD_CURR_CODE = (String) inputtext.getSubmittedValue();
		if (PD_CURR_CODE != null && !PD_CURR_CODE.trim().isEmpty()) {

			{
				bean.getPD_CURR_CODE();
				bean.getUI_M_PD_CURR_CODE_DESC();
				keepLooking = false;
			}
		}
	}

	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PYMT_DTLS_BEAN = (PT_IL_PYMT_DTLS) dataTable.getRowData();

			resetAllComponent();

			// Reset selection for other beans
			resetSelectedRow();
			PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public List fetchBankNameList(Object obj) {
		String refId = (String) obj;
		lovBankNameList = dbClass.getLovBankName(refId);
		return lovBankNameList;
	}

	public PT_IL_PYMT_DTLS_ACTION() {
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
		helper = new PT_IL_PYMT_DTLS_HELPER();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT017", "PT_IL_PYMT_DTLS",
					"PT_IL_PYMT_DTLS.PD_PAY_MODE", "IL_PAY_MODE");
			PD_PAID_FOR_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT017", "PT_IL_PYMT_DTLS",
					"PT_IL_PYMT_DTLS.PD_PAID_FOR", "IL_RCT_TYP");

			PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE_LIST(PD_PAY_MODE_LIST);
			PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR_LIST(PD_PAID_FOR_LIST);
			PD_CC_TYPE_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT017", "PT_IL_PYMT_DTLS", "PT_IL_PYMT_DTLS.PD_CC_TYPE",
					"IL_CC_TYPE");
			PT_IL_PYMT_DTLS_BEAN.setM_PD_CC_TYPE_LIST(PD_CC_TYPE_LIST);
			PD_REM_SLIP_GEN_LIST = ListItemUtil.getDropDownListValue(
					connection, "PILT017", "PT_IL_PYMT_DTLS",
					"PT_IL_PYMT_DTLS.PD_REM_SLIP_GEN_YN", "YESNO");
			PT_IL_PYMT_DTLS_BEAN
					.setM_PD_REM_SLIP_GEN_LIST(PD_REM_SLIP_GEN_LIST);
			dataTable = new HtmlDataTable();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public PT_IL_PYMT_DTLS_ACTION(String outcome, PT_IL_PYMT_DTLS defaultBean,
			boolean queryMode) {
		this();
		this.outcome = outcome;
		CommonUtils.setGlobalObject("PT_IL_PYMT_DTLS_ACTION", this);
		this.setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS_BEAN);
		this.queryMode = queryMode;
		this.searchResult();
		
	}

	public String goBack() {
		return outcome;
	}

	/**
	 * Action method to Map with source button
	 * 
	 * @return outcome as String which must be mapped in corresponding
	 *         faces-config.xml
	 */
	public String gotoPaymentDetails() {
		return "goToPymtDtls";
	}

	/**
	 * 
	 * @param sysId
	 */

	public void onLoad(PhaseEvent event) {
		
		try{
		    if (isFormFlag()) {
			
			
		    }
		    if (isBlockFlag()) {
			
			helper.pilt017_pt_il_pymt_dtls_when_new_record_instance(this);
			
			helper.pilt017_pt_il_pymt_dtls_when_create_record(PT_IL_PYMT_DTLS_BEAN, this);
			
		    }
		    getPT_IL_PYMT_DTLS_BEAN().setRowSelected(true);
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	
	}

	public void post(ActionEvent ae) {
		 
		 
		String message = null;

		try {
			getWarningMap().clear();
			if (PT_IL_PYMT_DTLS_BEAN.getROWID() == null) {
				helper.pilt017_pt_il_pymt_dtls_when_new_record_instance(this);
				helper.pilt017_pt_il_pymt_dtls_pre_insert(PT_IL_PYMT_DTLS_BEAN);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				new CRUDHandler().executeInsert(PT_IL_PYMT_DTLS_BEAN,
						new CommonUtils().getConnection());
				dataTableList.add(PT_IL_PYMT_DTLS_BEAN);
				resetSelectedRow();
				PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
				helper.pilt017_pt_il_pymt_dtls_post_insert(PT_IL_PYMT_DTLS_BEAN);
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("postRecord", message);
			} else if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null) {
				helper.pilt017_pt_il_pymt_dtls_pre_update(PT_IL_PYMT_DTLS_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PYMT_DTLS_BEAN,
						new CommonUtils().getConnection());
				resetSelectedRow();
				PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
				helper.pilt017_pt_il_pymt_dtls_post_update(PT_IL_PYMT_DTLS_BEAN);
				message = Messages.getString("PELErrorMessage",
						"UPDATE_MESSAGE");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getErrorMap().put("UPDATE_MESSAGE", message);
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	public void searchResult() {
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		this.fetchDtlList = null;
		ArrayList<PT_IL_PYMT_DTLS> detailList = new ArrayList<PT_IL_PYMT_DTLS>();
		dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
		String paymentTransactionType = CommonUtils
				.getGlobalVariable("GLOBAL.TXN_TYPE");
		String paymentTransactionSysid = CommonUtils
				.getGlobalVariable("GLOBAL.TXN_SYS_ID");
		String PC_SYS_ID = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_SYS_ID");
		String PC_PREM_TYPE = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_PREM_TYPE");
		String POL_NO = CommonUtils.getGlobalVariable("PILT003_APAC_POL_NO");
		// [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 -Commented Below Code as
		// its not Used Any Where
		/*
		 * Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
		 * .getExternalContext().getSessionMap(); PILT_003_COMPOSITE_BEAN
		 * compAction = (PILT_003_COMPOSITE_BEAN) sessionMap
		 * .get("PILT_003_COMPOSITE_BEAN"); PT_IL_POLICY_ACTION policyAction =
		 * compAction.getPT_IL_POLICY_ACTION(); String policyNumber =
		 * policyAction.getPT_IL_POLICY_BEAN().getPOL_NO();
		 */
		// PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 -Commented Below Code as
		// its not Used Any Where]
		boolean isRecordCheck = false;
		try {
			// PREMIAGDC-278143-VijayAnand-27-07-2009
			if ("N".equals(PC_PREM_TYPE)) {
				String PD_TXN_SYS_ID = "";
				ResultSet rs = handler.executeSelectStatement(
						PILT017_QUERY_CONSTANTS.SELECTING_POL_SYS_ID_QUERY,
						CommonUtils.getConnection(), new Object[] { POL_NO });
				if (rs.next()) {
					PD_TXN_SYS_ID = rs.getString(1);
					detailList = dbClass.fetchValues("PT", PD_TXN_SYS_ID);
					dataTableList = detailList;
				}
			} else {
				detailList = dbClass.fetchValues("PC", PC_SYS_ID);
				dataTableList = detailList;
			}
			// PREMIAGDC-278143-VijayAnand-27-07-2009
			// isRecordCheck = dbClass.isRecordCcheck(paymentTransactionType,
			// paymentTransactionSysid);
			// System.out.println("PT_IL_PYMT_DTLS_ACTION.searchResult()-isRecordCheck"+isRecordCheck);
			/*
			 * if(isRecordCheck){
			 * detailList=dbClass.fetchValues(paymentTransactionType,
			 * paymentTransactionSysid); dataTableList = detailList; }else{
			 * addNew(); listBean = dataTableList.get(0);
			 * populateDefaultValue(listBean); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			Iterator<PT_IL_PYMT_DTLS> iterator = dataTableList.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
		}
	}

	private ArrayList fetchDtlList;
	private String payMode;
	private String storedPayMode;

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getStoredPayMode() {
		return storedPayMode;
	}

	public void setStoredPayMode(String storedPayMode) {
		this.storedPayMode = storedPayMode;
	}

	public ArrayList getFetchDtlList() {
		return fetchDtlList;
	}

	public void setFetchDtlList(ArrayList fetchDtlList) {
		this.fetchDtlList = fetchDtlList;
	}

	public String fetchList() {
		PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
		this.fetchDtlList = dbClass.fetchList(this);
		return null;
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

	// /validations//

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void payModeValidation(ActionEvent event) {
		HtmlSelectOneMenu input = (HtmlSelectOneMenu) event.getComponent()
				.getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentSelectedValue(ActionEvent event) {
		String value = null;
		UISelectOne input = null;
		if (event != null) {
			input = (UISelectOne) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public void getPD_BRANCH_NAME(ActionEvent event) {
		String PD_BRANCH_NAME = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME(PD_BRANCH_NAME);
	}

	public void validatePD_PAY_MODE(FacesContext context,
			UIComponent component, Object value) {

		PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_PAY_MODE((String) value);
			helper.pilt017_pt_il_pymt_dtls_pd_pay_mode_when_validate_item(this);
			COMP_PD_PAY_MODE.resetValue();
		} catch (Exception e) {
		    e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
		    try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
				.getConnection(), "PD_PAY_MODE", getWarningMap());
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	}
	
	public void validatePD_FC_AMT(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_FC_AMT((Double) value);
		helper.pilt017pt_il_pymt_dtls_pd_fc_amt_when_validate_item(this); 
		COMP_PD_FC_AMT.resetValue();
	    } catch (Exception exception) {
		    exception.printStackTrace();
		    throw new ValidatorException(new FacesMessage(exception
			    .getMessage()));
		} finally {
		    try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
				.getConnection(), "PD_FC_AMT", getWarningMap());
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    }
	
	 
	 
	public void validatePD_LC_AMT(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_LC_AMT((Double) value);
		helper.pilt017_pt_il_pymt_dtls_pd_lc_amt_when_validate_item(this, compositeAction.getDummyAction()); 
		COMP_PD_LC_AMT.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try { 
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_LC_AMT", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
	
	public void validatePD_PAID_FOR(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_PAID_FOR((String) value);
		helper.pilt017_pt_il_pymt_dtls_pd_paid_for_when_list_changed(  this); 
		COMP_PD_PAID_FOR.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_PAID_FOR", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validateUI_M_CHQ_NO(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setUI_M_CHQ_NO((String) value);
		helper.m_chq_no_when_validate_item( this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_UI_M_CHQ_NO.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "UI_M_CHQ_NO", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
	public void validatePD_TT_CURR_CODE(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_TT_CURR_CODE((String) value);
		helper.pd_tt_curr_code_when_validate_item( this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_PD_TT_CURR_CODE.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_TT_CURR_CODE", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
	public void validatePD_CHQ_NO(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_NO((String) value);
		helper.pd_chq_no_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_PD_CHQ_NO.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_CHQ_NO", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_CHQ_DT(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_DT((Date) value);
		helper.pd_chq_dt_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_PD_CHQ_DT.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_CHQ_DT", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_DPD_REF_ID(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_DPD_REF_ID((String) value);
		helper.pd_dpd_ref_id_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN(), compositeAction.getDummyAction().getDUMMY_BEAN() ); 
		COMP_PD_DPD_REF_ID.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_DPD_REF_ID", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validateUI_M_PD_CC_NO_1(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CC_NO_1((String) value);
		helper.m_pd_cc_no_1_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_UI_M_PD_CC_NO_1.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "UI_M_PD_CC_NO_1", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_CC_APP_CODE(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_CC_APP_CODE((String) value);
		helper.pd_cc_app_code_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_PD_CC_APP_CODE.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_CC_APP_CODE", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validateUI_M_EXP_DT(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setUI_M_EXP_DT((Date) value);
		helper.pd_cc_app_code_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_UI_M_EXP_DT.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "UI_M_EXP_DT", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
	
	public void validateUI_M_PD_CC_NO(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CC_NO((String) value);
		helper.m_pd_cc_no_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_UI_M_PD_CC_NO.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "UI_M_PD_CC_NO", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validateUI_M_PD_CC_APP_CODE(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CC_APP_CODE((String) value);
		helper.m_pd_cc_no_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN()); 
		COMP_UI_M_PD_CC_APP_CODE.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "UI_M_PD_CC_APP_CODE", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	////PENDING
	
	public void validatePD_CC_EXP_DT(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_CC_APP_CODE((String) value);
		helper.pilt017_pt_il_pymt_dtls_m_exp_dt_when_validate_item(this); 
		//COMP_PD_CC_EXP_DT.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_CC_EXP_DT", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_PAYIN_DATE(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_PAYIN_DATE((Date) value);
		helper.whenValidatePD_PAYIN_DATE( (Date) value); 
		COMP_PD_PAYIN_DATE.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_PAYIN_DATE", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_BANK_NAME(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_BANK_NAME((String) value);
		helper.pilt017_pt_il_pymt_dtls_pd_bank_name_when_validate_item(this); 
		COMP_PD_BANK_NAME.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_BANK_NAME", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_BRANCH_NAME(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME((String) value);
		helper.pilt017_pt_il_pymt_dtls_pd_bank_name_when_validate_item(this); 
		COMP_PD_BRANCH_NAME.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_BRANCH_NAME", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
	public void validatePD_SR_NO(FacesContext context,
		UIComponent component, Object value){
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		try{
		    PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO((Integer)value);
		helper.pilt017_pt_il_pymt_dtls_pd_sr_no_when_validate_item(this);
		COMP_PD_SR_NO.resetValue();
		}
		catch(Exception e){
		    e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
			    ErrorHelpUtil.getWarningForProcedure(CommonUtils
				    .getConnection(), "PD_SR_NO", getWarningMap());
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }
	}
	
	
	public void validatePD_CUST_NAME(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME((String) value);
		helper.whenValidatePD_CUST_NAME(compositeAction.getDummyAction().getDUMMY_BEAN(),PT_IL_PYMT_DTLS_BEAN); 
		COMP_PD_CUST_NAME.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_CUST_NAME", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_ADDR_01(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME((String) value);
		helper.whenValidatePD_ADDR_01(compositeAction.getDummyAction().getDUMMY_BEAN(),PT_IL_PYMT_DTLS_BEAN); 
		COMP_PD_ADDR_01.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_ADDR_01", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_ADDR_02(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME((String) value);
		helper.whenValidatePD_ADDR_02(compositeAction.getDummyAction().getDUMMY_BEAN(),PT_IL_PYMT_DTLS_BEAN); 
		COMP_PD_ADDR_02.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_ADDR_02", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	public void validatePD_ADDR_03(FacesContext context,
		UIComponent component, Object value) {
	    
	    PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
	    try {
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME((String) value);
		helper.whenValidatePD_ADDR_03(compositeAction.getDummyAction().getDUMMY_BEAN(),PT_IL_PYMT_DTLS_BEAN); 
		COMP_PD_ADDR_03.resetValue();
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "PD_ADDR_03", getWarningMap());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}

	public void depRefIdValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		UIInput input = (UIInput) event.getComponent().getParent();
		inputValue = getCurrentValue(event);

		getPT_IL_PYMT_DTLS_BEAN().setPD_DPD_REF_ID(inputValue);
	}

	public void bankNameValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_BANK_NAME(inputValue);

	}

	public void bankDescValidation(ActionEvent event) {
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setUI_M_BANK_NAME_DESC(inputValue);
	}

	public void currCodeValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_CURR_CODE(inputValue);

	}

	public void currDescValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		UIInput input = (UIInput) event.getComponent().getParent();
		inputValue = getCurrentValue(event);

		getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CURR_CODE_DESC(inputValue);

	}

	public void amtInFCValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		Double inputValue = null;
		try {
			getErrorMap().clear();
			inputValue = Double.parseDouble(getCurrentValue(event));

			PT_IL_PYMT_DTLS bean = getPT_IL_PYMT_DTLS_BEAN();
			bean.setPD_FC_AMT(inputValue);
			bean.setPD_LC_AMT(inputValue);
			// newly added
			if (inputValue != null) {
				if (inputValue < 0) {
					getErrorMap().put(
							"current",
							Messages.getString(
									PELConstants.pelErrorMessagePath, "91052"));
					getErrorMap().put(
							"somekey",
							Messages.getString(
									PELConstants.pelErrorMessagePath, "91052"));
				}
			}
			// TODO
			double totalAmount = Double.parseDouble(CommonUtils
					.getGlobalVariable("GLOBAL.FC_AMT"));
			if (inputValue > totalAmount) {
				getErrorMap().put(
						"current",
						Messages.getString(PELConstants.pelErrorMessagePath,
								"91070"));
				getErrorMap().put(
						"somekey",
						Messages.getString(PELConstants.pelErrorMessagePath,
								"91070"));
			}

			if ("M".equalsIgnoreCase(bean.getPD_PAY_MODE())) {
				bean.setPD_REM_AMT(bean.getPD_LC_AMT());
			} else {
				bean.setPD_REM_AMT(0.0);
			}

			if ("D".equalsIgnoreCase(bean.getPD_PAID_FOR())) {
				bean.setUI_M_PD_DEP_AMT(bean.getPD_LC_AMT());
				bean.setUI_M_PD_OTH_AMT(0.0);
			} else {
				bean.setUI_M_PD_OTH_AMT(bean.getPD_LC_AMT());
				bean.setUI_M_PD_DEP_AMT(0.0);
			}
		} catch (NumberFormatException e) {
			getErrorMap().put("somekey", errorMessage);
			getErrorMap().put("current", errorMessage);
		}
	}

	public void amtInLCValidation(ActionEvent event) throws ValidatorException {
		CommonUtils.clearMaps(this);
		Double inputValue = null;
		try {
			inputValue = Double.parseDouble(getCurrentValue(event));
			getPT_IL_PYMT_DTLS_BEAN().setPD_LC_AMT(inputValue);
		} catch (NumberFormatException e) {
			getErrorMap().put("somekey", errorMessage);
			getErrorMap().put("current", errorMessage);
		}
	}

	public void paidForValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_PAID_FOR(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_CHQ_NO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String PD_CHQ_NO = null;
		PD_CHQ_NO = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_NO(PD_CHQ_NO);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void getPD_PAYIN_DATE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		UICalendar input = (UICalendar) component;
		Date PD_PAYIN_DATE = (Date) input.getSubmittedValue();
		getPT_IL_PYMT_DTLS_BEAN().setPD_PAYIN_DATE(PD_PAYIN_DATE);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_CHQ_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		UICalendar input = (UICalendar) component;
		Date PD_CHQ_DT_DATE = (Date) input.getSubmittedValue();
		getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_DT(PD_CHQ_DT_DATE);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_CR_ADVICE_NO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String PD_CR_ADVICE_NO = null;
		PD_CR_ADVICE_NO = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_CR_ADVICE_NO(PD_CR_ADVICE_NO);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PYMT_DTLS> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void custNameValidation(ActionEvent event) {
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_CUST_NAME(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void cardTypeValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);

		getPT_IL_PYMT_DTLS_BEAN().setPD_CC_TYPE(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_ADDR_01(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_01(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_ADDR_02(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_02(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_ADDR_03(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_03(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_REMARKS(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_REMARKS(inputValue);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public void getPD_LC_CHARGE(ActionEvent event) {
		CommonUtils.clearMaps(this);
		Double inputValue = null;

		try {
			inputValue = Double.parseDouble(getCurrentValue(event));
			if (getCurrentValue(event) == null
					|| getCurrentValue(event).trim().isEmpty()) {
				getPT_IL_PYMT_DTLS_BEAN().setPD_LC_CHARGE(0.0);
			} else {
				getPT_IL_PYMT_DTLS_BEAN().setPD_LC_CHARGE(inputValue);
			}
			// [ [Commented for grid implementation change, Added by: Varun
			// Dayal Mathur, Dated: 16-Feb-2009
			// gridtabListener();
			// Commented for grid implementation change, Added by: Varun Dayal
			// Mathur, Dated: 16-Feb-2009 ]
		} catch (NumberFormatException e) {
			getErrorMap().put("somekey", errorMessage);
			getErrorMap().put("current", errorMessage);
		}
	}

	public void getPD_FC_CHARGE(ActionEvent event) {
		CommonUtils.clearMaps(this);
		Double inputValue = null;

		try {
			inputValue = Double.parseDouble(getCurrentValue(event));
			if (getCurrentValue(event) == null
					|| getCurrentValue(event).trim().isEmpty()) {
				getPT_IL_PYMT_DTLS_BEAN().setPD_FC_CHARGE(0.0);
			} else {
				getPT_IL_PYMT_DTLS_BEAN().setPD_FC_CHARGE(inputValue);
			}
			// [Commented for grid implementation change, Added by: Varun Dayal
			// Mathur, Dated: 16-Feb-2009
			// lastColumnListener();
			// Commented for grid implementation change, Added by: Varun Dayal
			// Mathur, Dated: 16-Feb-2009 ]
		} catch (NumberFormatException e) {
			getErrorMap().put("somekey", errorMessage);
			getErrorMap().put("current", errorMessage);
		}

	}
	 
	
	
	
	public void atmCardNoValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String inputValue = null;
		inputValue = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_ATM_CARD_NO(inputValue);
		// [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// lastColumnListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	// validation ends//
	// [ [Commented for grid implementation change, Added by: Varun Dayal
	// Mathur, Dated: 16-Feb-2009
	/*
	 * public void gridtabListener(){ int currRowIndex =
	 * getDataTable().getRowIndex(); int rowUpdated = 0; PT_IL_PYMT_DTLS
	 * pymtDtlbean =null; PT_IL_PYMT_DTLS_HELPER helper = new
	 * PT_IL_PYMT_DTLS_HELPER(); String rowId = null; try { pymtDtlbean= new
	 * PT_IL_PYMT_DTLS(); if(lastUpdatedRowIndex!=-1){
	 * if(lastUpdatedRowIndex!=prevRowIndex){ if(currRowIndex != prevRowIndex){ //
	 * Get the bean based on row index rowId = pymtDtlbean.getROWID();
	 * pymtDtlbean = (PT_IL_PYMT_DTLS)dataTableList.get(prevRowIndex);
	 * if(pymtDtlbean.getPD_SYS_ID()==null){
	 * helper.pilt017_pt_il_pymt_dtls_when_new_record_instance(this);
	 * helper.pilt017_pt_il_pymt_dtls_pre_insert(pymtDtlbean); }else{
	 * helper.pilt017_pt_il_pymt_dtls_pre_update(pymtDtlbean); } // Update the
	 * record to database rowUpdated = dbClass.updateData(pymtDtlbean);
	 * if(rowUpdated>0) { getErrorMap().put("current", "Please save the
	 * record(s)"); getErrorMap().put("somekey", "Please save the record(s)"); }
	 * if (rowId == null) { getErrorMap().put("somekey", "1 record inserted.");
	 * getErrorMap().put("current", "1 record inserted."); }else{
	 * getErrorMap().put("somekey", "1. record updated.");
	 * getErrorMap().put("current", "1. record updated."); } prevRowIndex =
	 * currRowIndex; } } } } catch (Exception e1) { e1.printStackTrace(); }
	 * 
	 * return ; }
	 */

	// Commented for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 16-Feb-2009 ]
	public void lastColumnListener() {
		int rowUpdated = 0;
		PT_IL_PYMT_DTLS paymentDetailBean = null;
		PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		paymentDetailBean = getPT_IL_PYMT_DTLS_BEAN();
		String def_code = null;
		String rowId = null;
		try {
			getWarningMap().clear();
			rowId = paymentDetailBean.getROWID();
			if (paymentDetailBean.getPD_SYS_ID() == null) {
				helper.pilt017_pt_il_pymt_dtls_when_new_record_instance(this);
				helper.pilt017_pt_il_pymt_dtls_pre_insert(paymentDetailBean);
			} else {
				helper.pilt017_pt_il_pymt_dtls_pre_update(paymentDetailBean);
			}
			CommonUtils.objectSysout(paymentDetailBean);
			rowUpdated = dbClass.updatePaymentDetails(paymentDetailBean);
			if (rowUpdated > 0) {
				getWarningMap().put("current", "Please save the record(s)");
				getWarningMap().put("somekey", "Please save the record(s)");
			}
			/*
			 * if (rowId == null) { getErrorMap().put("somekey", rowUpdated+"
			 * record inserted."); getErrorMap().put("current", rowUpdated+"
			 * record inserted."); }else{ getErrorMap().put("somekey",
			 * rowUpdated+" record updated."); getErrorMap().put("current",
			 * rowUpdated+" record updated."); }
			 */

			/*
			 * if (rowId == null) { getErrorMap().put("somekey", "1 record
			 * inserted."); getErrorMap().put("current", "1 record inserted.");
			 * }else{ getErrorMap().put("somekey", "1. record updated.");
			 * getErrorMap().put("current", "1. record updated."); }
			 */
		} catch (ValidatorException e) {
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addNew() {
		PT_IL_PYMT_DTLS paymentDetailBean = null;
		PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		String curr_code = CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR");
		Double fc_amount = Double.parseDouble(CommonUtils
				.getGlobalVariable("GLOBAL.FC_AMT"));
		Double lc_amount = Double.parseDouble(CommonUtils
				.getGlobalVariable("GLOBAL.LC_AMT"));
		if (dataTableList == null) {
			dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();
		}
		paymentDetailBean = new PT_IL_PYMT_DTLS();
		try {
			helper.pilt017_pt_il_pymt_dtls_when_create_record(paymentDetailBean,
					this);
			paymentDetailBean = new PT_IL_PYMT_DTLS();
			helper.pilt017_pt_il_pymt_dtls_when_create_record(paymentDetailBean,
					this);
		Double fc_sum = 0.0;
		Double lc_sum = 0.0;
		Double FCDifference = 0.0;
		Double LCDifference = 0.0;

		PT_IL_PYMT_DTLS beanValue = getPT_IL_PYMT_DTLS_BEAN();

		fc_sum = fc_sum + beanValue.getPD_FC_AMT();
		lc_sum = lc_sum + beanValue.getPD_LC_AMT();

		if (fc_sum < fc_amount) {
			FCDifference = fc_amount - fc_sum;
		}

		if (lc_sum < lc_amount) {
			LCDifference = lc_amount - lc_sum;
		}
		paymentDetailBean.setPD_FC_AMT(FCDifference);
		paymentDetailBean.setPD_LC_AMT(LCDifference);
		int listSize = dataTableList.size();
		paymentDetailBean.setPD_SR_NO(++listSize);
		dataTableList.add(paymentDetailBean);
		String currencyDesc = dbClass.getCurrencyDesc(curr_code);
		paymentDetailBean.setPD_CURR_CODE(curr_code);
		paymentDetailBean.setUI_M_PD_CURR_CODE_DESC(currencyDesc);
		if (paymentDetailBean.getPD_FC_CHARGE() == null) {
			paymentDetailBean.setPD_FC_CHARGE(0.0);
		}
		if (paymentDetailBean.getPD_LC_CHARGE() == null) {
			paymentDetailBean.setPD_LC_CHARGE(0.0);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Settings to navigate to last page

		return "";
	}

	public String addNew(PT_IL_PYMT_DTLS paymentDetailBean) {
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();
		}
		paymentDetailBean = new PT_IL_PYMT_DTLS();
		dataTableList.add(paymentDetailBean);

		// Settings to navigate to last page
		return "";
	}

	public Long pilt017_pt_il_pymt_dtls_pre_insert() throws SQLException,
			Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_PYMT_DTLS pymtDtlBean = new PT_IL_PYMT_DTLS();
		Long sysId = null;
		ResultSet resultSet = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			connection = CommonUtils.getConnection();

			String getSysIdQry = SqlConstants.GET_SYS_ID;
			if (connection != null) {
				Object[] obj = {};
				resultSet = handler.executeSelectStatement(getSysIdQry,
						connection, obj);
				if (resultSet.next()) {
					sysId = resultSet.getLong(1);
					pymtDtlBean.setPD_CR_DT(commonUtils.getCurrentSQLDate());
					pymtDtlBean.setPD_CR_UID(pymtDtlBean.getUI_M_USER_ID());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sysId;

	}
  //Adding Validation condition according to fmb which previous not existing
	//Dileshwar Patle 29/06/2011
	
	
	
	

	public void getPD_SR_NO(FacesContext facesContext, UIComponent uIComponent,
			Object value) {
		int srValue;
		 
		// srValue = (String) event.getSubmittedValue();
		srValue = (Integer) value;
		int PD_SR_NO = srValue;
		String PD_PAID_FOR = null;
		PT_IL_PYMT_DTLS detailBean = getPT_IL_PYMT_DTLS_BEAN();
		try {
			if (PD_SR_NO == 0) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91003"));
			} else {
				detailBean.setPD_SR_NO(PD_SR_NO);
				PD_PAID_FOR = detailBean.getPD_PAID_FOR();
				if ("D".equals(PD_PAID_FOR)) {
					detailBean.setUI_M_PD_DEP_AMT(detailBean.getPD_LC_AMT());
					detailBean.setUI_M_PD_OTH_AMT(0.0);
				} else {
					detailBean.setUI_M_PD_OTH_AMT(detailBean.getPD_LC_AMT());
					detailBean.setUI_M_PD_DEP_AMT(0.0);
				}
			}
		} catch (ValidatorException e) {
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}

	public List<PT_IL_PYMT_DTLS> getLovForPdRefId(Object string) {
		PT_IL_PYMT_DTLS_DB_CLASS delegate = new PT_IL_PYMT_DTLS_DB_CLASS();
		locConditionList = (List) delegate.getLovForPdRefId(string);
		return locConditionList;
	}

	public void renderForPdRefId(ActionEvent event) {

		PT_IL_PYMT_DTLS bean = getPT_IL_PYMT_DTLS_BEAN();
		String forPdRefId = null;
		UIInput inputtext = (UIInput) event.getComponent().getParent()
				.getParent();
		forPdRefId = (String) inputtext.getSubmittedValue();

		bean.getPD_DPD_REF_ID();
		// [ [Commented for grid implementation change, Added
		// by: Varun Dayal Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by:
		// Varun Dayal Mathur, Dated: 16-Feb-2009 ]

	}

	public void getPD_DPD_REF_ID1(ActionEvent event) {
		String PD_DPD_REF_ID = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_DPD_REF_ID(PD_DPD_REF_ID);
		// [ [Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009
		// gridtabListener();
		// Commented for grid implementation change, Added by: Varun Dayal
		// Mathur, Dated: 16-Feb-2009 ]
	}

	public List<PT_IL_PYMT_DTLS> getLovBankName(Object string) {
		PT_IL_PYMT_DTLS_DB_CLASS delegate = new PT_IL_PYMT_DTLS_DB_CLASS();
		locConditionList = (List) delegate.getLovBankName(string);
		return locConditionList;
	}

	public ArrayList<LovBean> getPD_BANK_NAME(Object currValue) {
	    ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		//P_CALL_LOV('PT_IL_PYMT_DTLS.PD_BANK_NAME');
		    try {
			    suggestionList = listitemutil.P_CALL_LOV("PILT017",
				    "PT_IL_PYMT_DTLS", "PD_BANK_NAME", null, null, null, null,
				    null, (String) currValue);
 			} catch (Exception e) {
			    e.printStackTrace();
			}
			return suggestionList;
		 
	}

	public void renderForBankName(ActionEvent event) {
		// Iterator<PT_IL_PYMT_DTLS> iterator = null;
		// int rowIndex = getDataTable().getRowIndex();
		 
		boolean keepLooking = true;
		String forPdRefId = null;
		UIInput inputtext = (UIInput) event.getComponent().getParent()
				.getParent();
		forPdRefId = (String) inputtext.getSubmittedValue();
		if (forPdRefId != null && !forPdRefId.trim().isEmpty()) {
			if (locConditionList != null) {
				// iterator = locConditionList.iterator();
				// while (iterator.hasNext() && keepLooking) {
				// bean = iterator.next();
				if (forPdRefId.equals(PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME())) {
				    PT_IL_PYMT_DTLS_BEAN.setPD_BANK_NAME(PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME());
				    PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_NAME_DESC(PT_IL_PYMT_DTLS_BEAN
							.getUI_M_BANK_NAME_DESC());
					// [ [Commented for grid implementation change, Added
					// by: Varun Dayal Mathur, Dated: 16-Feb-2009
					// gridtabListener();
					// Commented for grid implementation change, Added by:
					// Varun Dayal Mathur, Dated: 16-Feb-2009 ]
					keepLooking = false;
				}
			}
		}
	}

	// }

	public List<PT_IL_PYMT_DTLS> getLovBranchName(Object string) {
		PT_IL_PYMT_DTLS_DB_CLASS delegate = new PT_IL_PYMT_DTLS_DB_CLASS();
		// int rowIndex = getDataTable().getRowIndex();
		String currId = PT_IL_PYMT_DTLS_BEAN.getPD_DPD_REF_ID();
		locConditionList = (List) delegate.getLovBranchName(string, currId);
		return locConditionList;
	}

	public void renderForBranchName(ActionEvent event) {
		// Iterator<PT_IL_PYMT_DTLS> iterator = null;
		// int rowIndex = getDataTable().getRowIndex();
		PT_IL_PYMT_DTLS bean = null;
		PT_IL_PYMT_DTLS listBean = null;
		listBean = getPT_IL_PYMT_DTLS_BEAN();
		boolean keepLooking = true;
		String forPdRefId = null;
		UIInput inputtext = (UIInput) event.getComponent().getParent()
				.getParent();
		forPdRefId = (String) inputtext.getSubmittedValue();
		if (forPdRefId != null && !forPdRefId.trim().isEmpty()) {
			if (locConditionList != null) {
				// iterator = locConditionList.iterator();
				// while (iterator.hasNext() && keepLooking) {
				// bean = iterator.next();
				if (forPdRefId.equals(bean.getPD_BRANCH_NAME())) {
					listBean.setPD_BRANCH_NAME(bean.getPD_BRANCH_NAME());
					// [ [Commented for grid implementation change, Added
					// by: Varun Dayal Mathur, Dated: 16-Feb-2009
					// gridtabListener();
					// Commented for grid implementation change, Added by:
					// Varun Dayal Mathur, Dated: 16-Feb-2009 ]
					keepLooking = false;
				}
			}
		}
	}

	// }

	public String saveAndCommit() {
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		String PD_TXN_SYS_ID = "";
		String PC_SYS_ID = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_SYS_ID");
		String POL_NO = CommonUtils.getGlobalVariable("PILT003_APAC_POL_NO");
		String PC_PREM_TYPE = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_PREM_TYPE");
		dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
		try {
			//int rowCount = getDataTable().getRowCount();
			String P_TXN_TYPE = CommonUtils
					.getGlobalVariable("GLOBAL.TXN_TYPE");
			String P_PD_TXN_SYS_ID = CommonUtils
					.getGlobalVariable("GLOBAL.TXN_SYS_ID");
			Long sysId = this.getPT_IL_PYMT_DTLS_BEAN().getPD_SYS_ID();
			String rowId = null;
			PT_IL_PYMT_DTLS listBean = null;
			ArrayList<PT_IL_PYMT_DTLS> detailList = new ArrayList<PT_IL_PYMT_DTLS>();
			rowId = this.getPT_IL_PYMT_DTLS_BEAN().getROWID();
			getWarningMap().clear();
			if (sysId == null) {
				DBProcedures procCall = new DBProcedures();
				procCall.helperP9ILPK_CHEQ_VALIDATION_UPD_REF_ID_PYMT_DTLS(
						P_PD_TXN_SYS_ID, P_TXN_TYPE);
			}
			Double fc_sum = 0.0;
			Double lc_sum = 0.0;
			Double fc_amount = Double.parseDouble(CommonUtils
					.getGlobalVariable("GLOBAL.FC_AMT"));
			Double lc_amount = Double.parseDouble(CommonUtils
					.getGlobalVariable("GLOBAL.LC_AMT"));
			//for (int index = 0; index < rowCount; index++) {
				//PT_IL_PYMT_DTLS rowAmountCountBean = dataTableList.get(index);
				fc_sum = fc_sum + PT_IL_PYMT_DTLS_BEAN.getPD_FC_AMT();
				lc_sum = lc_sum + PT_IL_PYMT_DTLS_BEAN.getPD_LC_AMT();

			//}
			if (fc_sum > fc_amount) {
				String errprMessage = Messages.getString(
						PELConstants.pelErrorMessagePath, "71125");
				getErrorMap().put("somekey", errprMessage);
				getErrorMap().put("current", errprMessage);
				throw new ValidatorException(new FacesMessage(errprMessage));
			}
			if (lc_sum > lc_amount) {
				String errprMessage = Messages.getString(
						PELConstants.pelErrorMessagePath, "2143");
				getErrorMap().put("somekey", errprMessage);
				getErrorMap().put("current", errprMessage);
				throw new ValidatorException(new FacesMessage(errprMessage));
			}
			// 2143
			else {
				commonUtils.doComitt();
				// PREMIAGDC-278143-VijayAnand-27-07-2009
				if (PC_PREM_TYPE == "N") {
					ResultSet rs = handler.executeSelectStatement(
							PILT017_QUERY_CONSTANTS.SELECTING_POL_SYS_ID_QUERY,
							CommonUtils.getConnection(),
							new Object[] { POL_NO });
					if (rs.next()) {
						PD_TXN_SYS_ID = rs.getString(1);
						detailList = dbClass.fetchValues("PT", PD_TXN_SYS_ID);
					}
				} else {
					detailList = dbClass.fetchValues("PC", PC_SYS_ID);
				}
				// PREMIAGDC-278143-VijayAnand-27-07-2009
				if (detailList == null || detailList.size() == 0) {
					dataTableList.clear();
					addNew();
					listBean = dataTableList.get(0);
					populateDefaultValue(listBean);
				} else {
					dataTableList = detailList;
				}

				/* Added for functionality of PILT003_APAC - PREMIA-GDC-1153441 */
				Map sessionMap = sessionMap();
				PT_IL_PREM_COLL premColl = (PT_IL_PREM_COLL) sessionMap
						.get("PT_IL_PREM_COLL_SELECTED");
				if (premColl != null) {
					if ("Y".equals(premColl.getPC_PAID_FLAG())) {
						sessionMap.put("PILT003_APAC-PT_IL_PREM_COLL-APPROVE",
								"ENABLE");
					}
				}
				/* Added for functionality of PILT003_APAC - PREMIA-GDC-1153441 */

				getWarningMap().put(
						"current",
						Messages.getString(PELConstants.pelErrorMessagePath,
								"SAVE_UPDATE_MESSAGE"));
				getWarningMap().put(
						"somekey",
						Messages.getString(PELConstants.pelErrorMessagePath,
								"SAVE_UPDATE_MESSAGE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private void populateDefaultValue(PT_IL_PYMT_DTLS copyValue) {
		PT_IL_PYMT_DTLS defaultValue = null;
		defaultValue = this.getPT_IL_PYMT_DTLS_BEAN();
		if (copyValue != null && defaultValue != null) {
			PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
			String curr_code = CommonUtils
					.getGlobalVariable("GLOBAL.M_BASE_CURR");
			String currencyDesc = dbClass.getCurrencyDesc(curr_code);
			copyValue.setPD_TXN_TYPE(defaultValue.getPD_TXN_TYPE());
			copyValue.setPD_TXN_SYS_ID(defaultValue.getPD_TXN_SYS_ID());
			copyValue.setPD_CURR_CODE(curr_code);
			copyValue.setPD_FC_AMT(defaultValue.getPD_FC_AMT());
			copyValue.setPD_LC_AMT(defaultValue.getPD_LC_AMT());
			copyValue.setUI_M_PD_CURR_CODE_DESC(currencyDesc);

			if (defaultValue.getPD_FC_CHARGE() == null) {
				copyValue.setPD_FC_CHARGE(0.0);
			} else {
				copyValue.setPD_FC_CHARGE(defaultValue.getPD_FC_CHARGE());
			}
			if (defaultValue.getPD_LC_CHARGE() == null) {
				copyValue.setPD_LC_CHARGE(0.0);
			} else {
				copyValue.setPD_LC_CHARGE(defaultValue.getPD_LC_CHARGE());
			}
		}
	}

	private Map sessionMap() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = context.getExternalContext()
				.getSessionMap();
		return sessionMap;
	}

	public String commitChanges() {
		try {
			new CommonUtils().doComitt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getWarningMap().put(
				"current",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		getWarningMap().put(
				"somekey",
				Messages.getString(PELConstants.pelErrorMessagePath,
						"SAVE_UPDATE_MESSAGE"));
		return "";
	}

	// [ Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		// int rowIndex = dataTable.getRowIndex();

		try {
			// if (rowIndex > -1) {
			// Calling last Column listener
			lastColumnListener();
			/*
			 * }else { getErrorMap().put(
			 * PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(
			 * PELConstants.pelMessagePropertiesPath,
			 * "IL_GRID$INVALID_ROW_INDEX$message")); }
			 */
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}

	// Added for grid implementation change, Added by: Varun Dayal Mathur,
	// Dated: 16-Feb-2009 ]

	public HtmlInputText getCOMP_UI_M_BANK_REF_NO() {
		return COMP_UI_M_BANK_REF_NO;
	}

	public void setCOMP_UI_M_BANK_REF_NO(HtmlInputText comp_ui_m_bank_ref_no) {
		COMP_UI_M_BANK_REF_NO = comp_ui_m_bank_ref_no;
	}

	public HtmlInputText getCOMP_UI_M_OUR_BANK_CODE_2() {
		return COMP_UI_M_OUR_BANK_CODE_2;
	}

	public void setCOMP_UI_M_OUR_BANK_CODE_2(
			HtmlInputText comp_ui_m_our_bank_code_2) {
		COMP_UI_M_OUR_BANK_CODE_2 = comp_ui_m_our_bank_code_2;
	}

	public HtmlInputText getCOMP_PD_OUR_BANK_CODE() {
		return COMP_PD_OUR_BANK_CODE;
	}

	public void setCOMP_PD_OUR_BANK_CODE(HtmlInputText comp_pd_our_bank_code) {
		COMP_PD_OUR_BANK_CODE = comp_pd_our_bank_code;
	}

	public HtmlInputText getCOMP_PD_PO_MO_NO() {
		return COMP_PD_PO_MO_NO;
	}

	public void setCOMP_PD_PO_MO_NO(HtmlInputText comp_pd_po_mo_no) {
		COMP_PD_PO_MO_NO = comp_pd_po_mo_no;
	}

	public HtmlCalendar getCOMP_PD_DATE_OF_CREDIT() {
		return COMP_PD_DATE_OF_CREDIT;
	}

	public void setCOMP_PD_DATE_OF_CREDIT(HtmlCalendar comp_pd_date_of_credit) {
		COMP_PD_DATE_OF_CREDIT = comp_pd_date_of_credit;
	}

	public HtmlInputText getCOMP_PD_CUST_NAME() {
		return COMP_PD_CUST_NAME;
	}

	public void setCOMP_PD_CUST_NAME(HtmlInputText comp_pd_cust_name) {
		COMP_PD_CUST_NAME = comp_pd_cust_name;
	}

	public HtmlCalendar getCOMP_PD_PO_MO_DT() {
		return COMP_PD_PO_MO_DT;
	}

	public void setCOMP_PD_PO_MO_DT(HtmlCalendar comp_pd_po_mo_dt) {
		COMP_PD_PO_MO_DT = comp_pd_po_mo_dt;
	}

	public HtmlCalendar getCOMP_UI_M_DATE_OF_CREDIT_1() {
		return COMP_UI_M_DATE_OF_CREDIT_1;
	}

	public void setCOMP_UI_M_DATE_OF_CREDIT_1(
			HtmlCalendar comp_ui_m_date_of_credit_1) {
		COMP_UI_M_DATE_OF_CREDIT_1 = comp_ui_m_date_of_credit_1;
	}

	public HtmlInputText getCOMP_PD_CC_NAME() {
		return COMP_PD_CC_NAME;
	}

	public void setCOMP_PD_CC_NAME(HtmlInputText comp_pd_cc_name) {
		COMP_PD_CC_NAME = comp_pd_cc_name;
	}

	public HtmlInputText getCOMP_PD_DPD_REF_ID() {
		return COMP_PD_DPD_REF_ID;
	}

	public void setCOMP_PD_DPD_REF_ID(HtmlInputText comp_pd_dpd_ref_id) {
		COMP_PD_DPD_REF_ID = comp_pd_dpd_ref_id;
	}

	public HtmlInputText getCOMP_UI_M_PD_CC_APP_CODE() {
		return COMP_UI_M_PD_CC_APP_CODE;
	}

	public void setCOMP_UI_M_PD_CC_APP_CODE(
			HtmlInputText comp_ui_m_pd_cc_app_code) {
		COMP_UI_M_PD_CC_APP_CODE = comp_ui_m_pd_cc_app_code;
	}

	public HtmlCalendar getCOMP_UI_M_DATE_OF_CREDIT() {
		return COMP_UI_M_DATE_OF_CREDIT;
	}

	public void setCOMP_UI_M_DATE_OF_CREDIT(
			HtmlCalendar comp_ui_m_date_of_credit) {
		COMP_UI_M_DATE_OF_CREDIT = comp_ui_m_date_of_credit;
	}

	public HtmlInputText getCOMP_UI_M_CHQ_NO() {
		return COMP_UI_M_CHQ_NO;
	}

	public void setCOMP_UI_M_CHQ_NO(HtmlInputText comp_ui_m_chq_no) {
		COMP_UI_M_CHQ_NO = comp_ui_m_chq_no;
	}

	public HtmlInputText getCOMP_PD_TT_REF_NO() {
		return COMP_PD_TT_REF_NO;
	}

	public void setCOMP_PD_TT_REF_NO(HtmlInputText comp_pd_tt_ref_no) {
		COMP_PD_TT_REF_NO = comp_pd_tt_ref_no;
	}

	public HtmlInputText getCOMP_PD_CR_ADVICE_NO() {
		return COMP_PD_CR_ADVICE_NO;
	}

	public void setCOMP_PD_CR_ADVICE_NO(HtmlInputText comp_pd_cr_advice_no) {
		COMP_PD_CR_ADVICE_NO = comp_pd_cr_advice_no;
	}

	public HtmlInputText getCOMP_PD_BANK_NAME() {
		return COMP_PD_BANK_NAME;
	}

	public void setCOMP_PD_BANK_NAME(HtmlInputText comp_pd_bank_name) {
		COMP_PD_BANK_NAME = comp_pd_bank_name;
	}

	public HtmlInputText getCOMP_PD_BRANCH_NAME() {
		return COMP_PD_BRANCH_NAME;
	}

	public void setCOMP_PD_BRANCH_NAME(HtmlInputText comp_pd_branch_name) {
		COMP_PD_BRANCH_NAME = comp_pd_branch_name;
	}

	public HtmlInputText getCOMP_PD_ADDR_01() {
		return COMP_PD_ADDR_01;
	}

	public void setCOMP_PD_ADDR_01(HtmlInputText comp_pd_addr_01) {
		COMP_PD_ADDR_01 = comp_pd_addr_01;
	}

	public HtmlInputText getCOMP_PD_ADDR_02() {
		return COMP_PD_ADDR_02;
	}

	public void setCOMP_PD_ADDR_02(HtmlInputText comp_pd_addr_02) {
		COMP_PD_ADDR_02 = comp_pd_addr_02;
	}

	public HtmlInputText getCOMP_PD_ADDR_03() {
		return COMP_PD_ADDR_03;
	}

	public void setCOMP_PD_ADDR_03(HtmlInputText comp_pd_addr_03) {
		COMP_PD_ADDR_03 = comp_pd_addr_03;
	}

	public HtmlInputText getCOMP_PD_REMARKS() {
		return COMP_PD_REMARKS;
	}

	public void setCOMP_PD_REMARKS(HtmlInputText comp_pd_remarks) {
		COMP_PD_REMARKS = comp_pd_remarks;
	}

	public HtmlInputText getCOMP_PD_CURR_CODE() {
		return COMP_PD_CURR_CODE;
	}

	public void setCOMP_PD_CURR_CODE(HtmlInputText comp_pd_curr_code) {
		COMP_PD_CURR_CODE = comp_pd_curr_code;
	}

	public HtmlInputText getCOMP_UI_M_OUR_BANK_CODE() {
		return COMP_UI_M_OUR_BANK_CODE;
	}

	public void setCOMP_UI_M_OUR_BANK_CODE(HtmlInputText comp_ui_m_our_bank_code) {
		COMP_UI_M_OUR_BANK_CODE = comp_ui_m_our_bank_code;
	}

	public HtmlInputText getCOMP_PD_SR_NO() {
		return COMP_PD_SR_NO;
	}

	public void setCOMP_PD_SR_NO(HtmlInputText comp_pd_sr_no) {
		COMP_PD_SR_NO = comp_pd_sr_no;
	}

	public HtmlInputText getCOMP_PD_CC_NO() {
		return COMP_PD_CC_NO;
	}

	public void setCOMP_PD_CC_NO(HtmlInputText comp_pd_cc_no) {
		COMP_PD_CC_NO = comp_pd_cc_no;
	}

	public HtmlInputText getCOMP_PD_ATM_CARD_NO() {
		return COMP_PD_ATM_CARD_NO;
	}

	public void setCOMP_PD_ATM_CARD_NO(HtmlInputText comp_pd_atm_card_no) {
		COMP_PD_ATM_CARD_NO = comp_pd_atm_card_no;
	}

	public HtmlInputText getCOMP_PD_BANK_REF_NO() {
		return COMP_PD_BANK_REF_NO;
	}

	public void setCOMP_PD_BANK_REF_NO(HtmlInputText comp_pd_bank_ref_no) {
		COMP_PD_BANK_REF_NO = comp_pd_bank_ref_no;
	}

	public HtmlInputText getCOMP_UI_M_PD_CC_NO() {
		return COMP_UI_M_PD_CC_NO;
	}

	public void setCOMP_UI_M_PD_CC_NO(HtmlInputText comp_ui_m_pd_cc_no) {
		COMP_UI_M_PD_CC_NO = comp_ui_m_pd_cc_no;
	}

	public HtmlInputText getCOMP_UI_M_PD_CURR_CODE_DESC() {
		return COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC(
			HtmlInputText comp_ui_m_pd_curr_code_desc) {
		COMP_UI_M_PD_CURR_CODE_DESC = comp_ui_m_pd_curr_code_desc;
	}

	public HtmlInputText getCOMP_PD_LC_CHARGE() {
		return COMP_PD_LC_CHARGE;
	}

	public void setCOMP_PD_LC_CHARGE(HtmlInputText comp_pd_lc_charge) {
		COMP_PD_LC_CHARGE = comp_pd_lc_charge;
	}

	public HtmlInputText getCOMP_PD_FC_CHARGE() {
		return COMP_PD_FC_CHARGE;
	}

	public void setCOMP_PD_FC_CHARGE(HtmlInputText comp_pd_fc_charge) {
		COMP_PD_FC_CHARGE = comp_pd_fc_charge;
	}

	public HtmlInputText getCOMP_PD_FC_AMT() {
		return COMP_PD_FC_AMT;
	}

	public void setCOMP_PD_FC_AMT(HtmlInputText comp_pd_fc_amt) {
		COMP_PD_FC_AMT = comp_pd_fc_amt;
	}

	public HtmlInputText getCOMP_PD_REM_AMT() {
		return COMP_PD_REM_AMT;
	}

	public void setCOMP_PD_REM_AMT(HtmlInputText comp_pd_rem_amt) {
		COMP_PD_REM_AMT = comp_pd_rem_amt;
	}

	public HtmlInputText getCOMP_PD_CC_APP_CODE() {
		return COMP_PD_CC_APP_CODE;
	}

	public void setCOMP_PD_CC_APP_CODE(HtmlInputText comp_pd_cc_app_code) {
		COMP_PD_CC_APP_CODE = comp_pd_cc_app_code;
	}

	public HtmlInputText getCOMP_UI_M_BANK_REF_NO_1() {
		return COMP_UI_M_BANK_REF_NO_1;
	}

	public void setCOMP_UI_M_BANK_REF_NO_1(HtmlInputText comp_ui_m_bank_ref_no_1) {
		COMP_UI_M_BANK_REF_NO_1 = comp_ui_m_bank_ref_no_1;
	}

	public HtmlInputText getCOMP_PD_TT_CURR_CODE() {
		return COMP_PD_TT_CURR_CODE;
	}

	public void setCOMP_PD_TT_CURR_CODE(HtmlInputText comp_pd_tt_curr_code) {
		COMP_PD_TT_CURR_CODE = comp_pd_tt_curr_code;
	}

	public HtmlInputText getCOMP_UI_M_BANK_NAME_DESC() {
		return COMP_UI_M_BANK_NAME_DESC;
	}

	public void setCOMP_UI_M_BANK_NAME_DESC(
			HtmlInputText comp_ui_m_bank_name_desc) {
		COMP_UI_M_BANK_NAME_DESC = comp_ui_m_bank_name_desc;
	}

	public HtmlInputText getCOMP_PD_LC_AMT() {
		return COMP_PD_LC_AMT;
	}

	public void setCOMP_PD_LC_AMT(HtmlInputText comp_pd_lc_amt) {
		COMP_PD_LC_AMT = comp_pd_lc_amt;
	}

	public HtmlInputText getCOMP_UI_M_OUR_BANK_CODE_1() {
		return COMP_UI_M_OUR_BANK_CODE_1;
	}

	public void setCOMP_UI_M_OUR_BANK_CODE_1(
			HtmlInputText comp_ui_m_our_bank_code_1) {
		COMP_UI_M_OUR_BANK_CODE_1 = comp_ui_m_our_bank_code_1;
	}

	public HtmlCalendar getCOMP_UI_M_EXP_DT() {
		return COMP_UI_M_EXP_DT;
	}

	public void setCOMP_UI_M_EXP_DT(HtmlCalendar comp_ui_m_exp_dt) {
		COMP_UI_M_EXP_DT = comp_ui_m_exp_dt;
	}

	public HtmlCalendar getCOMP_UI_M_DATE_OF_CREDIT_2() {
		return COMP_UI_M_DATE_OF_CREDIT_2;
	}

	public void setCOMP_UI_M_DATE_OF_CREDIT_2(
			HtmlCalendar comp_ui_m_date_of_credit_2) {
		COMP_UI_M_DATE_OF_CREDIT_2 = comp_ui_m_date_of_credit_2;
	}

	public HtmlCalendar getCOMP_PD_PAYIN_DATE() {
		return COMP_PD_PAYIN_DATE;
	}

	public void setCOMP_PD_PAYIN_DATE(HtmlCalendar comp_pd_payin_date) {
		COMP_PD_PAYIN_DATE = comp_pd_payin_date;
	}

	public HtmlCalendar getCOMP_PD_CHQ_DT() {
		return COMP_PD_CHQ_DT;
	}

	public void setCOMP_PD_CHQ_DT(HtmlCalendar comp_pd_chq_dt) {
		COMP_PD_CHQ_DT = comp_pd_chq_dt;
	}

	public HtmlInputText getCOMP_UI_M_BANK_REF_NO_2() {
		return COMP_UI_M_BANK_REF_NO_2;
	}

	public void setCOMP_UI_M_BANK_REF_NO_2(HtmlInputText comp_ui_m_bank_ref_no_2) {
		COMP_UI_M_BANK_REF_NO_2 = comp_ui_m_bank_ref_no_2;
	}

	public void resetAllComponent() {
		COMP_PD_CUST_NAME.resetValue();
		COMP_PD_CC_TYPE.resetValue();
		COMP_UI_M_BANK_REF_NO.resetValue();
		COMP_UI_M_OUR_BANK_CODE_2.resetValue();
		COMP_PD_OUR_BANK_CODE.resetValue();
		COMP_PD_PO_MO_NO.resetValue();
		COMP_UI_M_OUR_BANK_CODE.resetValue();
		COMP_UI_M_BANK_REF_NO_2.resetValue();
		COMP_UI_M_PD_CC_TYPE.resetValue();
		COMP_PD_SR_NO.resetValue();
		COMP_PD_CC_NO.resetValue();
		COMP_PD_PAY_MODE.resetValue();
		COMP_PD_ATM_CARD_NO.resetValue();
		COMP_PD_BANK_REF_NO.resetValue();
		COMP_UI_M_PD_CC_NO.resetValue();
		COMP_PD_DATE_OF_CREDIT.resetValue();
		COMP_PD_PO_MO_DT.resetValue();
		COMP_PD_REM_SLIP_GEN_YN.resetValue();
		COMP_UI_M_DATE_OF_CREDIT_1.resetValue();
		COMP_PD_CC_NAME.resetValue();
		COMP_PD_DPD_REF_ID.resetValue();
		COMP_UI_M_PD_CC_APP_CODE.resetValue();
		COMP_UI_M_DATE_OF_CREDIT.resetValue();
		COMP_UI_M_CHQ_NO.resetValue();
		COMP_UI_M_REM_SLIP_GEN_YN.resetValue();
		COMP_PD_TT_REF_NO.resetValue();
		COMP_PD_CR_ADVICE_NO.resetValue();
		COMP_PD_BANK_NAME.resetValue();
		COMP_PD_BRANCH_NAME.resetValue();
		COMP_PD_ADDR_01.resetValue();
		COMP_PD_ADDR_02.resetValue();
		COMP_PD_ADDR_03.resetValue();
		COMP_PD_REMARKS.resetValue();
		COMP_PD_CURR_CODE.resetValue();
		COMP_UI_M_PD_CURR_CODE_DESC.resetValue();
		COMP_PD_LC_CHARGE.resetValue();
		COMP_PD_FC_CHARGE.resetValue();
		COMP_PD_FC_AMT.resetValue();
		COMP_PD_REM_AMT.resetValue();
		COMP_PD_CC_APP_CODE.resetValue();
		COMP_UI_M_BANK_REF_NO_1.resetValue();
		COMP_PD_TT_CURR_CODE.resetValue();
		COMP_UI_M_BANK_NAME_DESC.resetValue();
		COMP_PD_LC_AMT.resetValue();
		COMP_UI_M_OUR_BANK_CODE_1.resetValue();
		COMP_UI_M_EXP_DT.resetValue();
		COMP_UI_M_DATE_OF_CREDIT_2.resetValue();
		COMP_PD_PAYIN_DATE.resetValue();
		COMP_PD_PAID_FOR.resetValue();
		COMP_PD_CHQ_NO.resetValue();
		COMP_PD_CHQ_DT.resetValue();

	}

	public void deleteRow(ActionEvent ae) {
        String message=null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PYMT_DTLS_BEAN,
							CommonUtils.getConnection());
					message=Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
					getWarningMap().put("deleteRow",message);
							
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
					dataTableList.remove(PT_IL_PYMT_DTLS_BEAN);
					
				}

				if (dataTableList.size() > 0) {
					setPT_IL_PYMT_DTLS_BEAN(dataTableList.get(0));
				} else {
					AddRow(ae);
				}
                message=Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("deleteRow",message);
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	public void AddRow(ActionEvent event) {

		PT_IL_PYMT_DTLS paymentDetailBean = null;
		PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		String curr_code = CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR");
		Double fc_amount = Double.parseDouble(CommonUtils
				.getGlobalVariable("GLOBAL.FC_AMT"));
		Double lc_amount = Double.parseDouble(CommonUtils
				.getGlobalVariable("GLOBAL.LC_AMT"));
		if (dataTableList == null) {
			dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();
		}
		paymentDetailBean = new PT_IL_PYMT_DTLS();
		try {
			helper.pilt017_pt_il_pymt_dtls_when_create_record(paymentDetailBean,this);
					paymentDetailBean = new PT_IL_PYMT_DTLS();
			
			helper.pilt017_pt_il_pymt_dtls_when_create_record(paymentDetailBean,
					this);
		Double fc_sum = 0.0;
		Double lc_sum = 0.0;
		Double FCDifference = 0.0;
		Double LCDifference = 0.0;

		PT_IL_PYMT_DTLS beanValue = getPT_IL_PYMT_DTLS_BEAN();

		fc_sum = fc_sum + beanValue.getPD_FC_AMT();
		lc_sum = lc_sum + beanValue.getPD_LC_AMT();

		if (fc_sum < fc_amount) {
			FCDifference = fc_amount - fc_sum;
		}

		if (lc_sum < lc_amount) {
			LCDifference = lc_amount - lc_sum;
		}
		paymentDetailBean.setPD_FC_AMT(FCDifference);
		paymentDetailBean.setPD_LC_AMT(LCDifference);
		int listSize = dataTableList.size();
		paymentDetailBean.setPD_SR_NO(++listSize);
		dataTableList.add(paymentDetailBean);
		String currencyDesc = dbClass.getCurrencyDesc(curr_code);
		paymentDetailBean.setPD_CURR_CODE(curr_code);
		paymentDetailBean.setUI_M_PD_CURR_CODE_DESC(currencyDesc);
		if (paymentDetailBean.getPD_FC_CHARGE() == null) {
			paymentDetailBean.setPD_FC_CHARGE(0.0);
		}
		if (paymentDetailBean.getPD_LC_CHARGE() == null) {
			paymentDetailBean.setPD_LC_CHARGE(0.0);
		}
		// Settings to navigate to last page
		resetAllComponent();
		resetSelectedRow();
		
		populateDefaultValue(paymentDetailBean);
		paymentDetailBean.setRowSelected(true);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public HtmlInputText getCOMP_UI_M_PD_CC_NO_1() {
	    return COMP_UI_M_PD_CC_NO_1;
	}

	public void setCOMP_UI_M_PD_CC_NO_1(HtmlInputText comp_ui_m_pd_cc_no_1) {
	    COMP_UI_M_PD_CC_NO_1 = comp_ui_m_pd_cc_no_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE() {
	    return COMP_UI_M_BUT_MORE;
	}

	public void setCOMP_UI_M_BUT_MORE(HtmlCommandButton comp_ui_m_but_more) {
	    COMP_UI_M_BUT_MORE = comp_ui_m_but_more;
	}
}
