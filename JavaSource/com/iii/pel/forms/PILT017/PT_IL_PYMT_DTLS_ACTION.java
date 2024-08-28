package com.iii.pel.forms.PILT017;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT003_APAC.PT_IL_PREM_COLL;
import com.iii.pel.forms.PILT016A_APAC.PILT016A_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT027.PILT027_COMPOSITE_ACTION;
import com.iii.pel.utils.P9ILPK_DEP_APPROVAL;
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

	public PILT027_COMPOSITE_ACTION pilt027_composite_action;

	private HtmlCommandButton COMP_UI_M_BUT_MORE;

	private HtmlAjaxCommandButton COMP_ADD_BUT;
	private HtmlAjaxCommandButton COMP_DEL_BUT;
	private HtmlAjaxCommandButton COMP_POST_BUT;

	private HtmlInputText COMP_PD_CUST_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

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
	private HtmlInputText COMP_PD_ADDR_01_DESC;
	private HtmlInputText COMP_PD_ADDR_02_DESC;
	private HtmlInputText COMP_PD_ADDR_03_DESC;

	private HtmlOutputLabel COMP_PD_CHQ_DT_LABEL;
	private HtmlCalendar COMP_PD_CHQ_DT;
	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;
	private PT_IL_PYMT_DTLS_HELPER helper;

	private HtmlCommandButton COMP_ADDROW_BUT;

	private HtmlCommandButton COMP_DELROW_BUT;

	private HtmlCommandButton COMP_POSTROW_BUT;
	
	private HtmlInputText COMP_PD_MICR_CODE;
	
	private HtmlOutputLabel COMP_PD_MICR_CODE_LABEL;
	

	
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
	
	String citycode=null;
	
	String bankcode=null;
	
	String branchcode=null;

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
			resetSelectedRow();
			PT_IL_PYMT_DTLS_BEAN = (PT_IL_PYMT_DTLS) dataTable.getRowData();
			PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
			
			resetAllComponent();
			if ("DP".equalsIgnoreCase(PT_IL_PYMT_DTLS_BEAN
					.getPD_PAY_MODE())) {
				disableAllComponent(true);
			}else{
				disableAllComponent(false);
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
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
			/*
			 * commented By Dhinesh on 06-10-2017 suggested by Gaurav
			 * 
			 * PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT017", "PT_IL_PYMT_DTLS",
					"PT_IL_PYMT_DTLS.PD_PAY_MODE", "IL_PAY_MODE");*/
			
			/*Commented by pidugu raj dt: 30-09-2018 as per sivaraman suggestion
			 * PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT017", "PT_IL_PYMT_DTLS",
					"PT_IL_PYMT_DTLS.PD_PAY_MODE", "IL_PAY_MODE1");*/
			
			PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_PYMT_TYPE", "IL_POL_PAY");

			PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE_LIST(PD_PAY_MODE_LIST);
			PD_PAID_FOR_LIST = ListItemUtil.getDropDownListValue(connection,
					"PILT017", "PT_IL_PYMT_DTLS",
					"PT_IL_PYMT_DTLS.PD_PAID_FOR", "IL_RCT_TYP");
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
			instantiateAllComponent();
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
		// this.searchResult();

	}

	public String goBack() {

		String calling_form = CommonUtils.getGlobalVariable("CALLING_FORM");

		if (calling_form != null
				&& "PILP002_APAC".equalsIgnoreCase(calling_form)) {
			outcome = "PILP002_APAC";
		} else if ("PILT016A_APAC".equalsIgnoreCase(calling_form)) {
			outcome = "PILT016A_APAC_PT_IL_DEPOSIT";
		}
		return outcome;
	}

	/**
	 * Action method to Map with source button
	 * 
	 * @return outcome as String which must be mapped in corresponding
	 *         faces-config.xml
	 */
	public String gotoPaymentDetails() {
		CommonUtils.setGlobalObject("CALLING_FORM", "PILT005");
		return "PILT017_PAYMENTDETAILS";
	}

	/**
	 * 
	 * @param sysId
	 */

	public void onLoad(PhaseEvent event) {
		try {
			String Form_name = (String) CommonUtils
					.getGlobalObject("CALLING_FORM");
			Boolean status = (Boolean) CommonUtils
					.getGlobalObject("APPROVAL_STATUS");
			String calling_form = CommonUtils.nvl(CommonUtils
					.getGlobalVariable("CALLING_FORM"), "");
			Connection connection = null;
			connection = CommonUtils.getConnection();
			if ("PILT003_APAC".equals(calling_form)) {

				/*Commentted &Modified by saritha on 24-10-2017 for Payment Mode Drop Down List*/
				/*PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(
						connection, "PILT017", "PT_IL_PYMT_DTLS",
						"PT_IL_PYMT_DTLS.PD_PAY_MODE1", "IL_PAY_MODE1");*/
				
				/*Commented by pidugu raj dt: 30-09-2018 as per sivaraman suggestion
				 * PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(
						connection, "PILT017", "PT_IL_PYMT_DTLS",
						"PT_IL_PYMT_DTLS.PD_PAY_MODE", "IL_PAY_MODE1");*/
				
				PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
						"PILT002_APAC", "PT_IL_POLICY",
						"PT_IL_POLICY.POL_PYMT_TYPE", "IL_POL_PAY");
				
				/*End*/
			} else {
				/*Commented by pidugu raj dt: 30-09-2018 as per sivaraman suggestion
				 * PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(
						connection, "PILT017", "PT_IL_PYMT_DTLS",
						"PT_IL_PYMT_DTLS.PD_PAY_MODE", "IL_PAY_MODE1");*/
				PD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
						"PILT002_APAC", "PT_IL_POLICY",
						"PT_IL_POLICY.POL_PYMT_TYPE", "IL_POL_PAY");
			}
			
		
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				calling_form = CommonUtils.getGlobalVariable("CALLING_FORM");
				executeQuery(compositeAction);
				compositeAction.getPW_PAYING_SLIP_DTLS_ACTION().executeQuery();
				if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null) {
					helper
							.pilp002_apac_pt_il_pymt_dtls_post_query(PT_IL_PYMT_DTLS_BEAN);
				} else {
					helper.pilt017_pt_il_pymt_dtls_when_create_record(
							PT_IL_PYMT_DTLS_BEAN, this, compositeAction
									.getDummyAction().getDUMMY_BEAN());
				}
				helper.pilt017_pt_il_pymt_dtls_when_new_record_instance(this);
				if ("PILP002_APAC".equals(calling_form)
						|| ("PILT016A_APAC".equals(Form_name) && status == true)) {
					this.setINSERT_ALLOWED(false);
					this.setUPDATE_ALLOWED(false);
					this.setDELETE_ALLOWED(false);
					COMP_PD_CURR_CODE.setRequired(false);
					COMP_ADD_BUT.setDisabled(true);
					COMP_DEL_BUT.setDisabled(true);
					COMP_POST_BUT.setDisabled(true);
					if ("PILP002_APAC".equals(calling_form)) {
						COMP_ADDROW_BUT.setDisabled(true);
						COMP_DELROW_BUT.setDisabled(true);
						COMP_POSTROW_BUT.setDisabled(true);
					}
					// searchResult1();
				} else {
					this.setINSERT_ALLOWED(true);
					this.setUPDATE_ALLOWED(true);
					this.setDELETE_ALLOWED(true);
					COMP_ADDROW_BUT.setDisabled(false);
					COMP_DELROW_BUT.setDisabled(false);
					COMP_POSTROW_BUT.setDisabled(false);
					// searchResult1();
				}
				/*if ("PILT027".equals(Form_name)) {
					if (pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
							.getPT_IL_TOP_UP_BEAN().getTU_TXN_CODE() == null
							&& pilt027_composite_action
									.getPT_IL_TOP_UP_ACTION_BEAN()
									.getPT_IL_TOP_UP_BEAN().getTU_DOC_NO() == null
							&& pilt027_composite_action
									.getPT_IL_TOP_UP_ACTION_BEAN()
									.getPT_IL_TOP_UP_BEAN().getTU_DOC_DT() == null) {
						this.setUPDATE_ALLOWED(true);
						this.setINSERT_ALLOWED(true);
					}
					else {
							this.setUPDATE_ALLOWED(false);
							this.setINSERT_ALLOWED(false);
						}
					}*/

				setBlockFlag(false);
			}
			if ("true".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("PAYMENT_DISABLE"))) {
				COMP_ADDROW_BUT.setDisabled(true);
				COMP_DELROW_BUT.setDisabled(true);
				COMP_POSTROW_BUT.setDisabled(true);
				this.disableAllComponent(true);
			} else {
				this.disableAllComponent(false);
			}

			getPT_IL_PYMT_DTLS_BEAN().setRowSelected(true);
			if ("PILT005".equalsIgnoreCase(Form_name)) {
				if ("A".equalsIgnoreCase((String) CommonUtils
						.getGlobalObject("LOAN_REPAYMENT_STATUS"))) {
					disableAllComponent(true);
				}

			}
			if ("PILT027".equalsIgnoreCase(Form_name)) {
				String M_APPRV_STATUS = CommonUtils
						.getGlobalVariable("PILT027_APP_STA");
				if (CommonUtils.nvl(M_APPRV_STATUS, "N").equalsIgnoreCase("Y")) {
					COMP_POSTROW_BUT.setDisabled(true);
					COMP_DELROW_BUT.setDisabled(true);
					COMP_ADDROW_BUT.setDisabled(true);
					disableAllComponent(true);
				} else {
					disableAllComponent(false);
				}
			}

			if (("L".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE()))
					|| ("C".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
							.getPD_PAY_MODE()))) {
				getCOMP_PD_CHQ_NO().setDisabled(false);
				/*Added by Sivarajan on 30-01-2019 for micr code not mandotaory for KIC*/
				if("C".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
						.getPD_PAY_MODE())){
					getCOMP_PD_MICR_CODE().setRequired(false);
				}else{
					getCOMP_PD_MICR_CODE().setRequired(true);
				}
				/*End*/
				
				getCOMP_PD_CHQ_DT().setDisabled(false);
				getCOMP_PD_MICR_CODE().setDisabled(false);
				/*Commented and modified by pidugu raj ac no, ac name for cheque dt: 23-10-2020 as suggested by Abhilash for Alliance IL*/
				/*getCOMP_CREDITCARD_TEXT().setDisabled(true);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);*/
				getCOMP_CREDITCARD_TEXT().setDisabled(false);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(false);
				/*End Commented and modified by pidugu raj ac no, ac name for cheque dt: 23-10-2020 as suggested by Abhilash for Alliance IL*/
				getCOMP_POL_CVV_NO().setDisabled(true);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(true);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(true);
			}else if("SC".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				getCOMP_PD_CHQ_NO().setDisabled(true);
				getCOMP_PD_MICR_CODE().setRequired(false);
				getCOMP_PD_CHQ_DT().setDisabled(true);
				getCOMP_PD_MICR_CODE().setDisabled(true);
				getCOMP_CREDITCARD_TEXT().setDisabled(false);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(false);
				getCOMP_POL_CVV_NO().setDisabled(false);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(false);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(false);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(false);
				
				if(getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_02() != null){
					String bankDesc = helper.doGetBankDesc(getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_02());
					if(bankDesc != null && !bankDesc.isEmpty()){
						getPT_IL_PYMT_DTLS_BEAN().setUI_M_BANK_CODE_DESC(bankDesc);
						getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(bankDesc);
					}
				}
					getCOMP_CREDITCARD_LABEL().setValue("Credit Card No:");
					getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Credit Card Merchant Bank");
					getCOMP_CREDIT_HOLDER_NAME().setValue("CREDIT HOLDER NAME");
					getCOMP_POL_CARD_EXP_DT_LABEL().setValue("Card Expiry Date");
					getCOMP_POL_CVV_NO_LABEL().setValue("CVV No.");
			}else if("B".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				getCOMP_PD_CHQ_NO().setDisabled(true);
				getCOMP_PD_MICR_CODE().setRequired(false);
				getCOMP_PD_CHQ_DT().setDisabled(true);
				getCOMP_PD_MICR_CODE().setDisabled(true);
				getCOMP_CREDITCARD_TEXT().setDisabled(false);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(false);
				getCOMP_POL_CVV_NO().setDisabled(false);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(false);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(false);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(false);
				if(getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_02() != null){
					String bankDesc = helper.doGetBankDesc(getPT_IL_PYMT_DTLS_BEAN().getPD_ADDR_02());
					if(bankDesc != null && !bankDesc.isEmpty()){
						getPT_IL_PYMT_DTLS_BEAN().setUI_M_BANK_CODE_DESC(bankDesc);
						getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(bankDesc);
					}
				}
					getCOMP_CREDITCARD_LABEL().setValue("Knet Card No.");
					getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Knet Card Merchant Bank");
					getCOMP_CREDIT_HOLDER_NAME().setValue("Knet Card Holder Name");
					getCOMP_POL_CARD_EXP_DT_LABEL().setValue("Card Expiry Date");
					getCOMP_POL_CVV_NO_LABEL().setValue("CVV No.");
			}else if("N".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				getCOMP_CREDITCARD_TEXT().setDisabled(true);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
				getCOMP_POL_CVV_NO().setDisabled(true);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(true);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(true);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly select valid method payment mode");
				getErrorMap().put("onLoad", "Kindly select valid method payment mode");
			}
			else if("P".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				getCOMP_PD_CHQ_NO().setDisabled(false);
				getCOMP_PD_MICR_CODE().setRequired(true);
				getCOMP_PD_CHQ_DT().setDisabled(false);
				getCOMP_PD_MICR_CODE().setDisabled(false);
				getCOMP_CREDITCARD_TEXT().setDisabled(true);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
				getCOMP_POL_CVV_NO().setDisabled(true);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(true);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(true);
				getCOMP_CREDITCARD_LABEL().setValue("Customer A/C No.");
				getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Bank Name");
				getCOMP_CREDIT_HOLDER_NAME().setValue("CREDIT HOLDER NAME");
				getCOMP_POL_CARD_EXP_DT_LABEL().setValue("Card Expiry Date");
				getCOMP_POL_CVV_NO_LABEL().setValue("CVV No.");
			}
			/*Newly added by pidugu raj dt:16-10-2018 as suggested by sivaraman if employee in  dropdown selected during receipt entry*/
			else if("E".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				getCOMP_PD_CHQ_NO().setDisabled(false);
				getCOMP_PD_MICR_CODE().setRequired(true);
				getCOMP_PD_CHQ_DT().setDisabled(false);
				getCOMP_PD_MICR_CODE().setDisabled(false);
				getCOMP_CREDITCARD_TEXT().setDisabled(true);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
				getCOMP_POL_CVV_NO().setDisabled(true);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(true);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(true);
				getCOMP_CREDITCARD_LABEL().setValue("Customer A/C No.");
				getCOMP_POL_CONT_AD_BANK_CODE_LABEL().setValue("Bank Name");
				getCOMP_CREDIT_HOLDER_NAME().setValue("CREDIT HOLDER NAME");
				getCOMP_POL_CARD_EXP_DT_LABEL().setValue("Card Expiry Date");
				getCOMP_POL_CVV_NO_LABEL().setValue("CVV No.");
			}
			/*End Newly added by pidugu raj dt:16-10-2018 as suggested by sivaraman if employee in  dropdown selected during receipt entry*/
			else if("BS".equalsIgnoreCase((String) getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				getCOMP_PD_CHQ_NO().setDisabled(false);
				getCOMP_PD_MICR_CODE().setRequired(true);
				getCOMP_PD_CHQ_DT().setDisabled(false);
				getCOMP_PD_MICR_CODE().setDisabled(false);
				getCOMP_CREDITCARD_TEXT().setDisabled(true);
				getCOMP_CREDIT_HOLDER_TEXT().setDisabled(true);
				getCOMP_POL_CVV_NO().setDisabled(true);
				getCOMP_CREDIT_MERCHANT_BANK().setDisabled(true);
				COMP_POL_CARD_EXP_DT_MM.setDisabled(true);
				COMP_POL_CARD_EXP_DT_YY.setDisabled(true);
			}
			
			
			else {
				getCOMP_PD_CHQ_NO().setDisabled(true);
				getCOMP_PD_MICR_CODE().setRequired(false);
				getCOMP_PD_CHQ_DT().setDisabled(true);
				getCOMP_PD_MICR_CODE().setDisabled(true);
				
			}
			disableDepblock();
			
			/*Enabled ResetallComponent Method */
			resetAllComponent();
			/*End*/
			
			//added to disable approved payment details 
			if ("PILT003_APAC".equals(calling_form)) {
				disableblock();
			}
			if("DP".equalsIgnoreCase(getPT_IL_PYMT_DTLS_BEAN()
					.getPD_PAY_MODE())){
				disableAllComponent(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void chkDetailForCheque(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN,
			String value) throws Exception {
		/*Commmented by Sivarajan for micr_code not a mandatory*/
		if ("L".equalsIgnoreCase(value) || "C".equalsIgnoreCase(value)) {
			if (PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_NO() == null
					|| PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_DT() == null /*|| PT_IL_PYMT_DTLS_BEAN.getPD_MICR_CODE() == null*/) {
				throw new Exception(
						"Please enter Cheque no and Cheque Date");

			}
		}
	}

	public void post()  {
		CommonUtils.clearMaps(this);
		try {

			//chkDepRefid(PT_IL_PYMT_DTLS_BEAN);
			chkDetailForCheque(PT_IL_PYMT_DTLS_BEAN, PT_IL_PYMT_DTLS_BEAN
					.getPD_PAY_MODE());
			
			if (PT_IL_PYMT_DTLS_BEAN.getROWID() == null) {
				if (isINSERT_ALLOWED()) {
					//helper.pd_chq_no_when_validate_item(PT_IL_PYMT_DTLS_BEAN);
					helper
							.pilt017_pt_il_pymt_dtls_pre_insert(PT_IL_PYMT_DTLS_BEAN);
					new CRUDHandler().executeInsert(PT_IL_PYMT_DTLS_BEAN,
							CommonUtils.getConnection());
					/*if (PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE().equals("L")) {
						compositeAction
								.getPW_PAYING_SLIP_DTLS_ACTION()
								.preInsert(
										compositeAction
												.getPW_PAYING_SLIP_DTLS_ACTION()
												.getPW_PAYING_SLIP_DTLS_BEAN());
						new CRUDHandler().executeInsert(compositeAction
								.getPW_PAYING_SLIP_DTLS_ACTION()
								.getPW_PAYING_SLIP_DTLS_BEAN(),
								new CommonUtils().getConnection());
					}*/
					helper
							.pilt017_pt_il_pymt_dtls_post_insert(PT_IL_PYMT_DTLS_BEAN);
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					dataTableList.add(PT_IL_PYMT_DTLS_BEAN);
				} else {
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			} else if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper
							.pilt017_pt_il_pymt_dtls_pre_update(PT_IL_PYMT_DTLS_BEAN);
					new CRUDHandler().executeUpdate(PT_IL_PYMT_DTLS_BEAN,
							CommonUtils.getConnection());
					//CommonUtils.getConnection().commit();
				/*	if (PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE().equals("L")) {
						new CRUDHandler().executeUpdate(compositeAction
								.getPW_PAYING_SLIP_DTLS_ACTION()
								.getPW_PAYING_SLIP_DTLS_BEAN(),
								new CommonUtils().getConnection());
					}*/

					helper
							.pilt017_pt_il_pymt_dtls_post_update(PT_IL_PYMT_DTLS_BEAN);
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			}

			PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("exc.getMessage()      "+exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			/*"Record not Inserted/Updated :: "*/exc.getMessage());
			getErrorMap().put("postRecord",
			/*"Record not Inserted/Updated :: "*/exc.getMessage());
			
			/*Commented by Ram on 25/11/2016 for throwing Exception
			 * 
			 * throw new Exception(exc.getMessage());*/
		}

	}

	public void postRecord() {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			getWarningMap().clear();
			getErrorMap().clear();
			if (PT_IL_PYMT_DTLS_BEAN.getROWID() == null) {
				// helper.pilt017_pt_il_pymt_dtls_when_new_record_instance(this);
				helper.pilt017_pt_il_pymt_dtls_pre_insert(PT_IL_PYMT_DTLS_BEAN);
				new CRUDHandler().executeInsert(PT_IL_PYMT_DTLS_BEAN,
						new CommonUtils().getConnection());

				// new
				// CRUDHandler().executeInsert(compositeAction.getPW_PAYING_SLIP_DTLS_ACTION().getPW_PAYING_SLIP_DTLS_BEAN(),new
				// CommonUtils().getConnection());
				if (PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE().equals("L")) {
					compositeAction.getPW_PAYING_SLIP_DTLS_ACTION().preInsert(
							compositeAction.getPW_PAYING_SLIP_DTLS_ACTION()
									.getPW_PAYING_SLIP_DTLS_BEAN());
					new CRUDHandler().executeInsert(compositeAction
							.getPW_PAYING_SLIP_DTLS_ACTION()
							.getPW_PAYING_SLIP_DTLS_BEAN(), new CommonUtils()
							.getConnection());
				}
				helper
						.pilt017_pt_il_pymt_dtls_post_insert(PT_IL_PYMT_DTLS_BEAN);
				dataTableList.add(PT_IL_PYMT_DTLS_BEAN);
				resetSelectedRow();
				PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");

			} else if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null) {
				helper.pilt017_pt_il_pymt_dtls_pre_update(PT_IL_PYMT_DTLS_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PYMT_DTLS_BEAN,
						new CommonUtils().getConnection());
				if (PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE().equals("L")) {
					new CRUDHandler().executeUpdate(compositeAction
							.getPW_PAYING_SLIP_DTLS_ACTION()
							.getPW_PAYING_SLIP_DTLS_BEAN(), new CommonUtils()
							.getConnection());
				}
				resetSelectedRow();
				PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
				helper
						.pilt017_pt_il_pymt_dtls_post_update(PT_IL_PYMT_DTLS_BEAN);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	public void executeQuery(COMPOSITE_ACTION_BEAN compositeAction)
			throws Exception {
		try {
			searchResult();
			if (dataTableList != null && !dataTableList.isEmpty()) {
				PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN_1 = dataTableList.get(0);
				PT_IL_PYMT_DTLS_BEAN_1.setRowSelected(true);
				
				resetAllComponent();
				setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS_BEAN_1);
			} else {
				PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN_1 = new PT_IL_PYMT_DTLS();
				setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS_BEAN_1);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}

	public void searchResult() throws Exception {
		// CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		String paymentTransactionType = null;
		Long PD_TXN_SYS_ID = null;
		if (dataTableList != null) {
			dataTableList.clear();
		}
		this.fetchDtlList = null;
		ArrayList<PT_IL_PYMT_DTLS> detailList = new ArrayList<PT_IL_PYMT_DTLS>();
		dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();

		if ("PILT003_APAC".equalsIgnoreCase((String) CommonUtils
				.getGlobalObject("CALLING_FORM"))) {
			paymentTransactionType = "PC";

			// CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",Long.parseLong("103561"));//TODO
			PD_TXN_SYS_ID = (Long) CommonUtils.getGlobalObject("G_PC_SYS_ID");
		} else {
			paymentTransactionType = CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE");

			// CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",Long.parseLong("103561"));//TODO
			PD_TXN_SYS_ID = (Long) CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID");
		}

		Long PC_SYS_ID = 0L;
		if (CommonUtils.getGlobalObject("PILT003_APAC_PC_SYS_ID") != null) {
			PC_SYS_ID = Long.parseLong(CommonUtils.getGlobalObject(
					"PILT003_APAC_PC_SYS_ID").toString());
		}
		String PC_PREM_TYPE = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_PREM_TYPE");
		String POL_NO = CommonUtils.getGlobalVariable("PILT003_APAC_POL_NO");
		boolean isRecordCheck = false;
		// String PD_TXN_SYS_ID = "";

		// POL_NO = "2202B11000004";//TODO
		// PD_TXN_SYS_ID = "103561";//TODO
		// PC_SYS_ID = Long.parseLong("103561");//TODO
		ResultSet rs = null;

		try {
			detailList = dbClass.fetchValues(paymentTransactionType,
					PD_TXN_SYS_ID);
			/*Newly added by pidugu raj dt: 24-10-2020 as suggested by abhilash*/
			String pol_Pymt_Type = dbClass.getProposalLevelPaymentType(PD_TXN_SYS_ID);
			if(detailList.isEmpty()){
				compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_PAY_MODE(pol_Pymt_Type);
			}else{
			/*End Newly added by pidugu raj dt: 24-10-2020 as suggested by abhilash*/
			for(PT_IL_PYMT_DTLS pymt_dtls:detailList){
				if(pymt_dtls.getPD_CC_EXP_DT() != null){
					compositeAction.getPT_IL_PYMT_DTLS_ACTION().getPT_IL_PYMT_DTLS_BEAN().setPD_CC_EXP_DT(pymt_dtls.getPD_CC_EXP_DT());
					if(pymt_dtls.getPD_CC_EXP_DT() != null){
				    	/*Newly added by pidugu raj dt: 04-10-2018 for expiry date as suggested by vaitheeswaran*/
						String expDt = (pymt_dtls.getPD_CC_EXP_DT().toString());
						pymt_dtls.setPOL_CARD_EXP_DT_MM(expDt.substring(5,7));
						pymt_dtls.setPOL_CARD_EXP_DT_YY(expDt.substring(2,4));
						/*Newly added by pidugu raj dt: 04-10-2018 for expiry date as suggested by vaitheeswaran*/
				    }
					if(pymt_dtls.getPD_ADDR_02() != null){
						String desc = helper.doGetBankDesc(pymt_dtls.getPD_ADDR_02());
						
						if(desc != null){
						getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(desc);
						COMP_PD_ADDR_02_DESC.resetValue();
						}
					}
				}
			}
			
			dataTableList = detailList;
			}
			/*
			 * if ("N".equals(PC_PREM_TYPE)) { rs =
			 * handler.executeSelectStatement(
			 * PILT017_QUERY_CONSTANTS.SELECTING_POL_SYS_ID_QUERY,
			 * CommonUtils.getConnection(), new Object[] { POL_NO }); if
			 * (rs.next()) { PD_TXN_SYS_ID = rs.getLong(1); detailList =
			 * dbClass.fetchValues(paymentTransactionType, PD_TXN_SYS_ID);
			 * dataTableList = detailList; } } else { detailList =
			 * dbClass.fetchValues(paymentTransactionType, PC_SYS_ID);
			 * dataTableList = detailList; }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void searchResult1() {
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		this.fetchDtlList = null;
		ArrayList<PT_IL_PYMT_DTLS> detailList = new ArrayList<PT_IL_PYMT_DTLS>();
		PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN = null;
		String TXN_TYPE = (String) CommonUtils
				.getGlobalObject("GLOBAL.TXN_TYPE");
		Long TXN_SYS_ID = (Long) CommonUtils
				.getGlobalObject("GLOBAL.TXN_SYS_ID");
		String FETCH_QUERY = "SELECT * FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ? AND PD_TXN_TYPE = ?  ";
		try {

			ResultSet resultSet = handler.executeSelectStatement(FETCH_QUERY,
					CommonUtils.getConnection(), new Object[] { TXN_SYS_ID,
							TXN_TYPE });

			while (resultSet.next()) {
				PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();

				PT_IL_PYMT_DTLS_BEAN.setPD_SYS_ID(resultSet
						.getLong("PD_SYS_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(resultSet.getInt("PD_SR_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TXN_TYPE(resultSet
						.getString("PD_TXN_TYPE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TXN_SYS_ID(resultSet
						.getLong("PD_TXN_SYS_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE(resultSet
						.getString("PD_PAY_MODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CURR_CODE(resultSet
						.getString("PD_CURR_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(resultSet
						.getDouble("PD_FC_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(resultSet
						.getDouble("PD_LC_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(resultSet
						.getString("PD_CHQ_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_DT(resultSet
						.getDate("PD_CHQ_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BANK_NAME(resultSet
						.getString("PD_BANK_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BRANCH_NAME(resultSet
						.getString("PD_BRANCH_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_NO(resultSet
						.getString("PD_CC_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_NAME(resultSet
						.getString("PD_CC_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_EXP_DT(resultSet
						.getDate("PD_CC_EXP_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_TYPE(resultSet
						.getString("PD_CC_TYPE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CUST_NAME(resultSet
						.getString("PD_CUST_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_01(resultSet
						.getString("PD_ADDR_01"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_02(resultSet
						.getString("PD_ADDR_02"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_03(resultSet
						.getString("PD_ADDR_03"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REMARKS(resultSet
						.getString("PD_REMARKS"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_UID(resultSet
						.getString("PD_CR_UID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_DT(resultSet.getDate("PD_CR_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_UPD_UID(resultSet
						.getString("PD_UPD_UID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_UPD_DT(resultSet
						.getDate("PD_UPD_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_DPD_REF_ID(resultSet
						.getString("PD_DPD_REF_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REV_YN(resultSet
						.getString("PD_REV_YN"));
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_CHARGE(resultSet
						.getDouble("PD_LC_CHARGE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_CHARGE(resultSet
						.getDouble("PD_FC_CHARGE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR(resultSet
						.getString("PD_PAID_FOR"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_APP_CODE(resultSet
						.getString("PD_CC_APP_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAYIN_DATE(resultSet
						.getDate("PD_PAYIN_DATE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(resultSet
						.getString("PD_OUR_BANK_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(resultSet
						.getDate("PD_DATE_OF_CREDIT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TT_REF_NO(resultSet
						.getString("PD_TT_REF_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TT_CURR_CODE(resultSet
						.getString("PD_TT_CURR_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REM_SLIP_GEN_YN(resultSet
						.getString("PD_REM_SLIP_GEN_YN"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PO_MO_NO(resultSet
						.getString("PD_PO_MO_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PO_MO_DT(resultSet
						.getDate("PD_PO_MO_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REM_AMT(resultSet
						.getDouble("PD_REM_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(resultSet
						.getString("PD_BANK_REF_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_ADVICE_NO(resultSet
						.getString("PD_CR_ADVICE_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ATM_CARD_NO(resultSet
						.getString("PD_ATM_CARD_NO"));
				dataTableList.add(PT_IL_PYMT_DTLS_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public String moreButtonAction() {
		String outcome = helper
				.M_BUT_MORE_WHEN_BUTTON_PRESSED(PT_IL_PYMT_DTLS_BEAN);
		return outcome;
	}

	public void getPD_BRANCH_NAME(ActionEvent event) {
		String PD_BRANCH_NAME = getCurrentValue(event);
		getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME(PD_BRANCH_NAME);
	}

	public void validatePD_PAY_MODE(FacesContext context,
			UIComponent component, Object value) {
		getErrorMap().clear();
		try {
			String currValue = (String) value;
			String beanValue = getPT_IL_PYMT_DTLS_BEAN().getPD_PAY_MODE();
			if (!(currValue.equalsIgnoreCase(beanValue))) {
				getPT_IL_PYMT_DTLS_BEAN().setPD_PAY_MODE((String) value);
				helper
						.pilt017_pt_il_pymt_dtls_pd_pay_mode_when_validate_item(this);
				
				
				/*helper.POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(getPT_IL_PYMT_DTLS_BEAN(),this);*/
				resetAllComponent();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PD_PAY_MODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePD_FC_AMT(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			Double currval = (Double)value;
			if(!(currval.equals(getPT_IL_PYMT_DTLS_BEAN().getPD_FC_AMT()))){
			getPT_IL_PYMT_DTLS_BEAN().setPD_FC_AMT((Double) value);
			
			/*Commented  and modified by Janani on 09.06.2018 for FSD_IL_FLA_019*/
			helper.pilt017pt_il_pymt_dtls_pd_fc_amt_when_validate_item(this);
			//getPT_IL_PYMT_DTLS_BEAN().setPD_LC_AMT((Double) value);
				
			
			/*End*/
			
			COMP_PD_LC_AMT.resetValue();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}

	public void validatePD_LC_AMT(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_LC_AMT((Double) value);
			helper.pilt017_pt_il_pymt_dtls_pd_lc_amt_when_validate_item(this,
					compositeAction.getDummyAction());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_PAID_FOR((String) value);
			helper.pilt017_pt_il_pymt_dtls_pd_paid_for_when_list_changed(this);

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setUI_M_CHQ_NO((String) value);
			helper.m_chq_no_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_TT_CURR_CODE((String) value);
			helper.pd_tt_curr_code_when_validate_item(this
					.getPT_IL_PYMT_DTLS_BEAN());

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

	public void validatePD_CHQ_NO(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			System.out.println("inside cheque no validator");
			getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_NO((String) value);
			helper.pd_chq_no_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN(),compositeAction);

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

	public void validatePD_CHQ_DT(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_DT((Date) value);
			helper.pd_chq_dt_when_validate_item(this.getPT_IL_PYMT_DTLS_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_DPD_REF_ID((String) value);
			helper.pd_dpd_ref_id_when_validate_item(this
					.getPT_IL_PYMT_DTLS_BEAN(), compositeAction
					.getDummyAction().getDUMMY_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CC_NO_1((String) value);
			helper.m_pd_cc_no_1_when_validate_item(this
					.getPT_IL_PYMT_DTLS_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CC_APP_CODE((String) value);
			helper.pd_cc_app_code_when_validate_item(this
					.getPT_IL_PYMT_DTLS_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setUI_M_EXP_DT((Date) value);
			helper.pd_cc_app_code_when_validate_item(this
					.getPT_IL_PYMT_DTLS_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CC_NO((String) value);
			helper
					.m_pd_cc_no_when_validate_item(this
							.getPT_IL_PYMT_DTLS_BEAN());

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setUI_M_PD_CC_APP_CODE((String) value);
			helper
					.m_pd_cc_no_when_validate_item(this
							.getPT_IL_PYMT_DTLS_BEAN());

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_PD_CC_APP_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// //PENDING

	public void validatePD_CC_EXP_DT(FacesContext context,
			UIComponent component, Object value) {
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CC_EXP_DT((Date) value);
			helper.pilt017_pt_il_pymt_dtls_m_exp_dt_when_validate_item(this);
			// COMP_PD_CC_EXP_DT.resetValue();
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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_PAYIN_DATE((Date) value);
			helper.whenValidatePD_PAYIN_DATE((Date) value);

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_BANK_NAME((String) value);
			helper
					.pilt017_pt_il_pymt_dtls_pd_bank_name_when_validate_item(this);

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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_BRANCH_NAME((String) value);
			helper
					.pilt017_pt_il_pymt_dtls_pd_bank_name_when_validate_item(this);

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

	public void validatePD_SR_NO(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO((Integer) value);
			helper.pilt017_pt_il_pymt_dtls_pd_sr_no_when_validate_item(this);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
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
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CUST_NAME((String) value);
			helper.whenValidatePD_CUST_NAME(compositeAction.getDummyAction()
					.getDUMMY_BEAN(), PT_IL_PYMT_DTLS_BEAN);

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

	public void validatePD_ADDR_01(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_01((String) value);
			helper.whenValidatePD_ADDR_01(compositeAction.getDummyAction()
					.getDUMMY_BEAN(), PT_IL_PYMT_DTLS_BEAN);

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

	public void validatePD_ADDR_02(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_02((String) value);
			helper.whenValidatePD_ADDR_02(compositeAction.getDummyAction()
					.getDUMMY_BEAN(), PT_IL_PYMT_DTLS_BEAN);

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

	public void validatePD_ADDR_03(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_03((String) value);
			helper.whenValidatePD_ADDR_03(compositeAction.getDummyAction()
					.getDUMMY_BEAN(), PT_IL_PYMT_DTLS_BEAN);

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

	public void validatePD_REMARKS(FacesContext context, UIComponent component,
			Object value) { // added validator to set the value into the bean by
		// SANTOSHI 24/1/13
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_REMARKS((String) value);
			helper.whenValidatePD_REMARKS(compositeAction.getDummyAction()
					.getDUMMY_BEAN(), PT_IL_PYMT_DTLS_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PD_REMARKS", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void getPD_PAYIN_DATE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		getPT_IL_PYMT_DTLS_BEAN().setPD_PAYIN_DATE((Date) value);
	}

	public void getPD_CHQ_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		Date date = (Date) value;
		getPT_IL_PYMT_DTLS_BEAN().setPD_CHQ_DT(date);

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PYMT_DTLS> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

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
		} catch (ValidatorException e) {
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addNew() {

		String curr_code = (String) CommonUtils
				.getGlobalObject("GLOBAL.M_BASE_CURR");
		Double fc_amount = (Double) CommonUtils
				.getGlobalObject("GLOBAL.FC_AMT");
		Double lc_amount = (Double) CommonUtils
				.getGlobalObject("GLOBAL.LC_AMT");

		if (dataTableList == null) {
			dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();
		}

		try {

			PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
			helper.pilt017_pt_il_pymt_dtls_when_create_record(
					PT_IL_PYMT_DTLS_BEAN, this, compositeAction
							.getDummyAction().getDUMMY_BEAN());
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
			PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(FCDifference);
			PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(LCDifference);
			int listSize = dataTableList.size();
			PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(++listSize);
			dataTableList.add(PT_IL_PYMT_DTLS_BEAN);
			String currencyDesc = dbClass.getCurrencyDesc(curr_code);
			PT_IL_PYMT_DTLS_BEAN.setPD_CURR_CODE(curr_code);
			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CURR_CODE_DESC(currencyDesc);
			if (PT_IL_PYMT_DTLS_BEAN.getPD_FC_CHARGE() == null) {
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_CHARGE(0.0);
			}
			if (PT_IL_PYMT_DTLS_BEAN.getPD_LC_CHARGE() == null) {
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_CHARGE(0.0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public String addNew(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();
		}
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
		dataTableList.add(PT_IL_PYMT_DTLS_BEAN);

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
					pymtDtlBean.setPD_CR_DT(commonUtils.getCurrentDate());
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

	// Adding Validation condition according to fmb which previous not existing
	// Dileshwar Patle 29/06/2011

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
		// P_CALL_LOV('PT_IL_PYMT_DTLS.PD_BANK_NAME');
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
					PT_IL_PYMT_DTLS_BEAN.setPD_BANK_NAME(PT_IL_PYMT_DTLS_BEAN
							.getPD_BANK_NAME());
					PT_IL_PYMT_DTLS_BEAN
							.setUI_M_BANK_NAME_DESC(PT_IL_PYMT_DTLS_BEAN
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

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		try {
			String message = null;
			/*if(this.getPT_IL_PYMT_DTLS_BEAN().getPD_DPD_REF_ID()==null){
				throw new Exception ("Please enter Dep Ref Id");
			}*/
			String calling_form = CommonUtils.nvl(CommonUtils
					.getGlobalVariable("CALLING_FORM"), "");

			if (isINSERT_ALLOWED()) {
				if ("PILT003_APAC".equals(calling_form)) {
					validatePaymentValidator(this);
				}
				CommonUtils.getConnection().commit();
				executeQuery(compositeAction);
				message = Messages.getString("messageProperties",
						"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("SAVE", message);
			} else {
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("UPDATE", message);
			}

			/*Added by Janani on 14.06.2018 for FSD_IL_FLA_019 */
			helper.PD_CURR_CODE_when_validate_item(this);
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public String saveAndCommit() {
		CommonUtils.clearMaps(this);
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		Long PD_TXN_SYS_ID = 0L;
		String PC_SYS_ID = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_SYS_ID");
		String POL_NO = CommonUtils.getGlobalVariable("PILT003_APAC_POL_NO");
		String PC_PREM_TYPE = CommonUtils
				.getGlobalVariable("PILT003_APAC_PC_PREM_TYPE");
		dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
		try {
			// int rowCount = getDataTable().getRowCount();
			String P_TXN_TYPE = (String) CommonUtils
					.getGlobalObject("GLOBAL.TXN_TYPE");
			PD_TXN_SYS_ID = (Long) CommonUtils
					.getGlobalObject("GLOBAL.TXN_SYS_ID");
			Long sysId = this.getPT_IL_PYMT_DTLS_BEAN().getPD_SYS_ID();
			String rowId = null;
			PT_IL_PYMT_DTLS listBean = null;
			ArrayList<PT_IL_PYMT_DTLS> detailList = new ArrayList<PT_IL_PYMT_DTLS>();
			rowId = this.getPT_IL_PYMT_DTLS_BEAN().getROWID();
			getWarningMap().clear();
			if (sysId == null) {
				DBProcedures procCall = new DBProcedures();
				procCall.helperP9ILPK_CHEQ_VALIDATION_UPD_REF_ID_PYMT_DTLS(
						CommonUtils.getProcedureValue(PD_TXN_SYS_ID),
						P_TXN_TYPE);
			}
			Double fc_sum = 0.0;
			Double lc_sum = 0.0;
			Double fc_amount = (Double) CommonUtils
					.getGlobalObject("GLOBAL.FC_AMT");
			Double lc_amount = (Double) CommonUtils
					.getGlobalObject("GLOBAL.LC_AMT");
			// for (int index = 0; index < rowCount; index++) {
			// PT_IL_PYMT_DTLS rowAmountCountBean = dataTableList.get(index);
			fc_sum = fc_sum + PT_IL_PYMT_DTLS_BEAN.getPD_FC_AMT();
			lc_sum = lc_sum + PT_IL_PYMT_DTLS_BEAN.getPD_LC_AMT();

			// }
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
				CommonUtils.doComitt();
				// PREMIAGDC-278143-VijayAnand-27-07-2009
				if (PC_PREM_TYPE == "N") {
					ResultSet rs = handler.executeSelectStatement(
							PILT017_QUERY_CONSTANTS.SELECTING_POL_SYS_ID_QUERY,
							CommonUtils.getConnection(),
							new Object[] { POL_NO });
					if (rs.next()) {
						PD_TXN_SYS_ID = rs.getLong(1);
						detailList = dbClass.fetchValues("PT", PD_TXN_SYS_ID);
					}
				} else {
					// detailList = dbClass.fetchValues("PC", PC_SYS_ID);
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
		COMP_PD_MICR_CODE.resetValue();
		// COMP_PD_ADDR_01.resetValue();
		// COMP_PD_ADDR_02.resetValue();
		// COMP_PD_ADDR_03.resetValue();
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
		
		/*Added by Janani for Fidelity on 09.06.2018 for FSD_IL_FLA_019 */
		COMP_PD_EXCH_RATE.resetValue();
		/*End*/
		
		/*Newly added by pidugu raj dt: 30-09-2018 for kic_qc as suggested by sivaraman*/
		COMP_CREDITCARD_TEXT.resetValue();
		COMP_POL_CONT_AD_BANK_CODE.resetValue();
		COMP_UI_M_BANK_CODE_DESC.resetValue();
		COMP_CREDIT_HOLDER_TEXT.resetValue();
		COMP_CREDIT_MERCHANT_BANK.resetValue();
		COMP_POL_CARD_EXP_DT_MM.resetValue();
		COMP_POL_CARD_EXP_DT_YY.resetValue();
		COMP_POL_CVV_NO.resetValue();
		COMP_POL_CARD_EXP_DT.resetValue();
		COMP_POL_CARD_EXP_DT_MM.resetValue();
		COMP_POL_CARD_EXP_DT_YY.resetValue();
		/*End Newly added by pidugu raj dt: 30-09-2018 for kic_qc as suggested by sivaraman*/
	}

	/*
	 * public void deleteRow() { String message=null; try {
	 * getErrorMap().clear(); getWarningMap().clear();
	 * 
	 * if (isDELETE_ALLOWED()) { if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null) { //
	 * executeDelete(PM_CUST_DIVN_BEAN); new
	 * CRUDHandler().executeDelete(PT_IL_PYMT_DTLS_BEAN,
	 * CommonUtils.getConnection());
	 * message=Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
	 * getWarningMap().put("deleteRow",message);
	 * 
	 * getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
	 * dataTableList.remove(PT_IL_PYMT_DTLS_BEAN);
	 *  }
	 * 
	 * if (dataTableList!=null && dataTableList.size() > 0) {
	 * setPT_IL_PYMT_DTLS_BEAN(dataTableList.get(0)); } else { addRow(); }
	 * message=Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
	 * getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
	 * getWarningMap().put("deleteRow",message); resetAllComponent();
	 *  } else { getErrorMap().clear(); getErrorMap().put(
	 * PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(
	 * PELConstants.pelMessagePropertiesPath,
	 * "errorPanel$message$deletenotallowed")); getErrorMap().put( "deleteRow",
	 * Messages.getString( PELConstants.pelMessagePropertiesPath,
	 * "errorPanel$message$deletenotallowed")); }
	 *  } catch (Exception e) { e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("deleteRow", e.getMessage()); } }
	 */

	public void deleteRow() {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_PYMT_DTLS_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataTableList.remove(PT_IL_PYMT_DTLS_BEAN);
				if (dataTableList.size() > 0) {

					PT_IL_PYMT_DTLS_BEAN = dataTableList.get(0);
				} else if (dataTableList.size() == 0) {

					addRow();
				}
				if (null != compositeAction.getPW_PAYING_SLIP_DTLS_ACTION()
						.getPW_PAYING_SLIP_DTLS_BEAN().getPSL_CHK_NO()) {
					deleteMicrCode();
				}
				resetAllComponent();
				compositeAction.getPW_PAYING_SLIP_DTLS_ACTION()
						.resetAllComponent();
				PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
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

			paymentDetailBean = new PT_IL_PYMT_DTLS();

			helper.pilt017_pt_il_pymt_dtls_when_create_record(
					paymentDetailBean, this, compositeAction.getDummyAction()
							.getDUMMY_BEAN());
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

	public void addRow() {
		CommonUtils.clearMaps(this);
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();

		PT_IL_PYMT_DTLS_HELPER helper = new PT_IL_PYMT_DTLS_HELPER();
		String curr_code = CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR");
		Double fc_amount = 0.0;
		Double lc_amount = 0.0;
		if (CommonUtils.getGlobalObject("GLOBAL.FC_AMT") != null) {
			fc_amount = (Double) CommonUtils.getGlobalObject("GLOBAL.FC_AMT");
		}
		if (CommonUtils.getGlobalObject("GLOBAL.LC_AMT") != null) {
			lc_amount = (Double) CommonUtils.getGlobalObject("GLOBAL.LC_AMT");
		}

		/*
		 * if (dataTableList == null) { dataTableList = new ArrayList<PT_IL_PYMT_DTLS>(); }
		 */
		String calling_form = CommonUtils.nvl(CommonUtils
				.getGlobalVariable("CALLING_FORM"), "");

		try {
			if ("PILT003_APAC".equals(calling_form)) {
				validatePayment(this);
			}
			helper.pilt017_pt_il_pymt_dtls_when_create_record(
					PT_IL_PYMT_DTLS_BEAN, this, compositeAction
							.getDummyAction().getDUMMY_BEAN());
			Double fc_sum = 0.0;
			Double lc_sum = 0.0;
			Double FCDifference = 0.0;
			Double LCDifference = 0.0;
			int listSize = 0;

			PT_IL_PYMT_DTLS beanValue = getPT_IL_PYMT_DTLS_BEAN();

			fc_sum = fc_sum + beanValue.getPD_FC_AMT();
			lc_sum = lc_sum + beanValue.getPD_LC_AMT();

			if (fc_sum < fc_amount) {
				FCDifference = fc_amount - fc_sum;
			}

			if (lc_sum < lc_amount) {
				LCDifference = lc_amount - lc_sum;
			}
			PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(FCDifference);
			PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(LCDifference);
			if (dataTableList != null) {
				listSize = dataTableList.size();
			}

			PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(++listSize);
			// dataTableList.add(PT_IL_PYMT_DTLS_BEAN);
			String currencyDesc = dbClass.getCurrencyDesc(curr_code);
			PT_IL_PYMT_DTLS_BEAN.setPD_CURR_CODE(curr_code);
			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CURR_CODE_DESC(currencyDesc);
			if (PT_IL_PYMT_DTLS_BEAN.getPD_FC_CHARGE() == null) {
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_CHARGE(0.0);
			}
			if (PT_IL_PYMT_DTLS_BEAN.getPD_LC_CHARGE() == null) {
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_CHARGE(0.0);
			}
			// Settings to navigate to last page
			populateDefaultValue(PT_IL_PYMT_DTLS_BEAN);
			PT_IL_PYMT_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPW_PAYING_SLIP_DTLS_ACTION()
					.getPW_PAYING_SLIP_DTLS_BEAN().setPSL_CHK_NO(null);
			compositeAction.getPW_PAYING_SLIP_DTLS_ACTION().resetAllComponent();
			resetAllComponent();
			COMP_PD_ADDR_01.resetValue();
			COMP_PD_ADDR_02.resetValue();
			COMP_PD_ADDR_03.resetValue();
			COMP_PD_CHQ_DT.resetValue();
			resetSelectedRow();
			// setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS_BEAN);

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
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

	/**
	 * Instantiates all components in PT_IL_PYMT_DTLS_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_PD_CUST_NAME = new HtmlInputText();
		COMP_UI_M_BANK_REF_NO = new HtmlInputText();
		COMP_UI_M_OUR_BANK_CODE_2 = new HtmlInputText();
		COMP_PD_OUR_BANK_CODE = new HtmlInputText();
		COMP_PD_PO_MO_NO = new HtmlInputText();
		COMP_UI_M_OUR_BANK_CODE = new HtmlInputText();
		COMP_UI_M_BANK_REF_NO_2 = new HtmlInputText();
		COMP_PD_SR_NO = new HtmlInputText();
		COMP_PD_CC_NO = new HtmlInputText();
		COMP_PD_ATM_CARD_NO = new HtmlInputText();
		COMP_PD_BANK_REF_NO = new HtmlInputText();
		COMP_UI_M_PD_CC_NO = new HtmlInputText();
		COMP_UI_M_PD_CC_NO_1 = new HtmlInputText();
		COMP_PD_CC_NAME = new HtmlInputText();
		COMP_PD_DPD_REF_ID = new HtmlInputText();
		COMP_UI_M_PD_CC_APP_CODE = new HtmlInputText();
		COMP_UI_M_CHQ_NO = new HtmlInputText();
		COMP_PD_TT_REF_NO = new HtmlInputText();
		COMP_PD_CR_ADVICE_NO = new HtmlInputText();
		COMP_PD_BANK_NAME = new HtmlInputText();
		COMP_PD_BRANCH_NAME = new HtmlInputText();
		COMP_PD_ADDR_01 = new HtmlInputText();
		COMP_PD_ADDR_02 = new HtmlInputText();
		COMP_PD_ADDR_03 = new HtmlInputText();
		COMP_PD_REMARKS = new HtmlInputText();
		COMP_PD_CURR_CODE = new HtmlInputText();
		COMP_UI_M_PD_CURR_CODE_DESC = new HtmlInputText();
		COMP_PD_LC_CHARGE = new HtmlInputText();
		COMP_PD_FC_CHARGE = new HtmlInputText();
		COMP_PD_FC_AMT = new HtmlInputText();
		COMP_PD_REM_AMT = new HtmlInputText();
		COMP_PD_CC_APP_CODE = new HtmlInputText();
		COMP_UI_M_BANK_REF_NO_1 = new HtmlInputText();
		COMP_PD_TT_CURR_CODE = new HtmlInputText();
		COMP_UI_M_BANK_NAME_DESC = new HtmlInputText();
		COMP_PD_LC_AMT = new HtmlInputText();
		COMP_UI_M_OUR_BANK_CODE_1 = new HtmlInputText();
		COMP_PD_CHQ_NO = new HtmlInputText();
		COMP_PD_MICR_CODE = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PD_CC_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PD_MICR_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BANK_REF_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_OUR_BANK_CODE_2_LABEL = new HtmlOutputLabel();
		COMP_PD_OUR_BANK_CODE_LABEL = new HtmlOutputLabel();
		COMP_PD_PO_MO_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_OUR_BANK_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BANK_REF_NO_2_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PD_CC_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PD_SR_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_CC_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_PAY_MODE_LABEL = new HtmlOutputLabel();
		COMP_PD_ATM_CARD_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_BANK_REF_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PD_CC_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_DATE_OF_CREDIT_LABEL = new HtmlOutputLabel();
		COMP_PD_PO_MO_DT_LABEL = new HtmlOutputLabel();
		COMP_PD_REM_SLIP_GEN_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_DATE_OF_CREDIT_1_LABEL = new HtmlOutputLabel();
		COMP_PD_CC_NAME_LABEL = new HtmlOutputLabel();
		COMP_PD_DPD_REF_ID_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PD_CC_APP_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_DATE_OF_CREDIT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CHQ_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_REM_SLIP_GEN_YN_LABEL = new HtmlOutputLabel();
		COMP_PD_TT_REF_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_CR_ADVICE_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_BANK_NAME_LABEL = new HtmlOutputLabel();
		COMP_PD_BRANCH_NAME_LABEL = new HtmlOutputLabel();
		COMP_PD_CUST_NAME_LABEL = new HtmlOutputLabel();
		COMP_PD_ADDR_01_LABEL = new HtmlOutputLabel();
		COMP_PD_ADDR_02_LABEL = new HtmlOutputLabel();
		COMP_PD_ADDR_03_LABEL = new HtmlOutputLabel();
		COMP_PD_REMARKS_LABEL = new HtmlOutputLabel();
		COMP_PD_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PD_CURR_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_PD_LC_CHARGE_LABEL = new HtmlOutputLabel();
		COMP_PD_FC_CHARGE_LABEL = new HtmlOutputLabel();
		COMP_PD_FC_AMT_LABEL = new HtmlOutputLabel();
		COMP_PD_REM_AMT_LABEL = new HtmlOutputLabel();
		COMP_PD_CC_APP_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BANK_REF_NO_1_LABEL = new HtmlOutputLabel();
		COMP_PD_TT_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BANK_NAME_DESC_LABEL = new HtmlOutputLabel();
		COMP_PD_LC_AMT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_OUR_BANK_CODE_1_LABEL = new HtmlOutputLabel();
		COMP_UI_M_EXP_DT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_DATE_OF_CREDIT_2_LABEL = new HtmlOutputLabel();
		COMP_PD_PAYIN_DATE_LABEL = new HtmlOutputLabel();
		COMP_PD_PAID_FOR_LABEL = new HtmlOutputLabel();
		COMP_PD_CHQ_NO_LABEL = new HtmlOutputLabel();
		COMP_PD_CHQ_DT_LABEL = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_PD_CC_TYPE = new HtmlSelectOneMenu();
		COMP_UI_M_PD_CC_TYPE = new HtmlSelectOneMenu();
		COMP_PD_PAY_MODE = new HtmlSelectOneMenu();
		COMP_PD_REM_SLIP_GEN_YN = new HtmlSelectOneMenu();
		COMP_UI_M_REM_SLIP_GEN_YN = new HtmlSelectOneMenu();
		COMP_PD_PAID_FOR = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_PD_DATE_OF_CREDIT = new HtmlCalendar();
		COMP_PD_PO_MO_DT = new HtmlCalendar();
		COMP_UI_M_DATE_OF_CREDIT_1 = new HtmlCalendar();
		COMP_UI_M_DATE_OF_CREDIT = new HtmlCalendar();
		COMP_UI_M_EXP_DT = new HtmlCalendar();
		COMP_UI_M_DATE_OF_CREDIT_2 = new HtmlCalendar();
		COMP_PD_PAYIN_DATE = new HtmlCalendar();
		COMP_PD_CHQ_DT = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_MORE = new HtmlCommandButton();
		COMP_ADD_BUT = new HtmlAjaxCommandButton();
		COMP_DEL_BUT = new HtmlAjaxCommandButton();
		COMP_POST_BUT = new HtmlAjaxCommandButton();

		
		/*Added by Janani for Fidelity on 09.06.2018 for FSD_IL_FLA_019 */
		COMP_PD_EXCH_RATE_LABEL = new HtmlOutputLabel();
		COMP_PD_EXCH_RATE = new HtmlInputText();
		/*End*/
		
		
		/*Newly added by pidugu raj dt: 30-09-2018 for kic_qc as suggested by sivaraman*/
		COMP_CREDITCARD_LABEL = new HtmlOutputLabel();
		COMP_CREDIT_MERCHANT_BANK = new HtmlInputText();
		COMP_CREDITCARD_TEXT = new HtmlInputText();
		COMP_POL_CONT_AD_BANK_CODE = new HtmlInputText();
		COMP_UI_M_BANK_CODE_DESC = new HtmlInputText();
		COMP_CREDIT_HOLDER_NAME = new HtmlOutputLabel();
		COMP_CREDIT_HOLDER_TEXT = new HtmlInputText();
		COMP_POL_CONT_AD_BANK_CODE_LABEL = new HtmlOutputLabel();
		COMP_POL_CARD_EXP_DT = new HtmlCalendar();
		COMP_POL_CARD_EXP_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_CARD_EXP_DT_MM = new HtmlInputText();
		COMP_POL_CARD_EXP_DT_YY = new HtmlInputText();
		COMP_POL_CVV_NO_LABEL = new HtmlOutputLabel();
		COMP_POL_CVV_NO = new HtmlInputText();
		/*End Newly added by pidugu raj dt: 30-09-2018 for kic_qc as suggested by sivaraman*/
		
	}

	public HtmlAjaxCommandButton getCOMP_ADD_BUT() {
		return COMP_ADD_BUT;
	}

	public void setCOMP_ADD_BUT(HtmlAjaxCommandButton comp_add_but) {
		COMP_ADD_BUT = comp_add_but;
	}

	public HtmlAjaxCommandButton getCOMP_DEL_BUT() {
		return COMP_DEL_BUT;
	}

	public void setCOMP_DEL_BUT(HtmlAjaxCommandButton comp_del_but) {
		COMP_DEL_BUT = comp_del_but;
	}

	public HtmlAjaxCommandButton getCOMP_POST_BUT() {
		return COMP_POST_BUT;
	}

	public void setCOMP_POST_BUT(HtmlAjaxCommandButton comp_post_but) {
		COMP_POST_BUT = comp_post_but;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	public String back() {
		String outcomeBack = null;
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		if ("PILT020".equalsIgnoreCase(callingForm)) {
			outcomeBack = "PILT020_DUMMY1_NAVIGATOR";
		}
		if ("PILT003_APAC".equalsIgnoreCase(callingForm)) {
			setBlockFlag(true);
			outcomeBack = "PILT003_APAC_PT_IL_PREM_COLL";
		}
		if ("PILT005".equalsIgnoreCase(callingForm)) {
			outcomeBack = "loanPage";
			setBlockFlag(true);
		}
		if ("PILT016A_APAC".equalsIgnoreCase(callingForm)) {
			outcomeBack = "PILT016A_APAC_PT_IL_DEPOSIT";
		}
		if ("PILP002_APAC".equalsIgnoreCase(callingForm)) {
			outcomeBack = "PILP002_APAC";
		}
		if ("PILT024".equalsIgnoreCase(callingForm)) {
			outcomeBack = "PILT024_PT_IL_POLICY";
		}
		if ("PILT027".equalsIgnoreCase(callingForm)) {
			outcomeBack = "GO_TO_PILT027_PT_IL_TOP_UP";
		}
		CommonUtils.setGlobalObject("G_PC_SYS_ID", null);
		CommonUtils.setGlobalObject("G_PC_NET_PREM_FC", null);
		setBlockFlag(true);

		this.getErrorMap().clear();
		this.getWarningMap().clear();
		return outcomeBack;
	}

	/**
	 * @return the cOMP_ADDROW_BUT
	 */
	public HtmlCommandButton getCOMP_ADDROW_BUT() {
		return COMP_ADDROW_BUT;
	}

	/**
	 * @param comp_addrow_but
	 *            the cOMP_ADDROW_BUT to set
	 */
	public void setCOMP_ADDROW_BUT(HtmlCommandButton comp_addrow_but) {
		COMP_ADDROW_BUT = comp_addrow_but;
	}

	/**
	 * @return the cOMP_DELROW_BUT
	 */
	public HtmlCommandButton getCOMP_DELROW_BUT() {
		return COMP_DELROW_BUT;
	}

	/**
	 * @param comp_delrow_but
	 *            the cOMP_DELROW_BUT to set
	 */
	public void setCOMP_DELROW_BUT(HtmlCommandButton comp_delrow_but) {
		COMP_DELROW_BUT = comp_delrow_but;
	}

	/**
	 * @return the cOMP_POSTROW_BUT
	 */
	public HtmlCommandButton getCOMP_POSTROW_BUT() {
		return COMP_POSTROW_BUT;
	}

	/**
	 * @param comp_postrow_but
	 *            the cOMP_POSTROW_BUT to set
	 */
	public void setCOMP_POSTROW_BUT(HtmlCommandButton comp_postrow_but) {
		COMP_POSTROW_BUT = comp_postrow_but;
	}

	/**
	 * Disables all components in PT_IL_PYMT_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_PD_CUST_NAME.setDisabled(disabled);
		COMP_UI_M_BANK_REF_NO.setDisabled(disabled);
		COMP_UI_M_OUR_BANK_CODE_2.setDisabled(disabled);
		COMP_PD_OUR_BANK_CODE.setDisabled(disabled);
		COMP_PD_PO_MO_NO.setDisabled(disabled);
		COMP_UI_M_OUR_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_BANK_REF_NO_2.setDisabled(disabled);
		COMP_PD_SR_NO.setDisabled(disabled);
		COMP_PD_CC_NO.setDisabled(disabled);
		COMP_PD_ATM_CARD_NO.setDisabled(disabled);
		COMP_PD_BANK_REF_NO.setDisabled(disabled);
		COMP_UI_M_PD_CC_NO.setDisabled(disabled);
		COMP_UI_M_PD_CC_NO_1.setDisabled(disabled);
		COMP_PD_CC_NAME.setDisabled(disabled);
		//COMP_PD_DPD_REF_ID.setDisabled(disabled);
		COMP_UI_M_PD_CC_APP_CODE.setDisabled(disabled);
		COMP_UI_M_CHQ_NO.setDisabled(disabled);
		COMP_PD_TT_REF_NO.setDisabled(disabled);
		COMP_PD_CR_ADVICE_NO.setDisabled(disabled);
		COMP_PD_BANK_NAME.setDisabled(disabled);
		COMP_PD_BRANCH_NAME.setDisabled(disabled);
		/*COMP_PD_ADDR_01.setDisabled(disabled);
		COMP_PD_ADDR_02.setDisabled(disabled);
		COMP_PD_ADDR_03.setDisabled(disabled);*/
		COMP_PD_REMARKS.setDisabled(disabled);
		COMP_PD_CURR_CODE.setDisabled(disabled);
		// COMP_UI_M_PD_CURR_CODE_DESC.setDisabled(disabled);
		COMP_PD_LC_CHARGE.setDisabled(disabled);
		COMP_PD_FC_CHARGE.setDisabled(disabled);
		//COMP_PD_FC_AMT.setDisabled(disabled);
		COMP_PD_REM_AMT.setDisabled(disabled);
		COMP_PD_CC_APP_CODE.setDisabled(disabled);
		COMP_UI_M_BANK_REF_NO_1.setDisabled(disabled);
		COMP_PD_TT_CURR_CODE.setDisabled(disabled);
		COMP_UI_M_BANK_NAME_DESC.setDisabled(disabled);
		//COMP_PD_LC_AMT.setDisabled(disabled);
		COMP_UI_M_OUR_BANK_CODE_1.setDisabled(disabled);
		//COMP_PD_CHQ_NO.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_PD_CC_TYPE.setDisabled(disabled);
		COMP_UI_M_PD_CC_TYPE.setDisabled(disabled);
		COMP_PD_PAY_MODE.setDisabled(disabled);
		COMP_PD_REM_SLIP_GEN_YN.setDisabled(disabled);
		COMP_UI_M_REM_SLIP_GEN_YN.setDisabled(disabled);
		COMP_PD_PAID_FOR.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_PD_DATE_OF_CREDIT.setDisabled(disabled);
		COMP_PD_PO_MO_DT.setDisabled(disabled);
		COMP_UI_M_DATE_OF_CREDIT_1.setDisabled(disabled);
		COMP_UI_M_DATE_OF_CREDIT.setDisabled(disabled);
		COMP_UI_M_EXP_DT.setDisabled(disabled);
		COMP_UI_M_DATE_OF_CREDIT_2.setDisabled(disabled);
		COMP_PD_PAYIN_DATE.setDisabled(disabled);
		//COMP_PD_CHQ_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_MORE.setDisabled(disabled);
		// COMP_UI_M_BUT_MAIN.setDisabled(disabled);
		/*
		 * COMP_ADDROW_BUT.setDisabled(disabled);
		 * COMP_DELROW_BUT.setDisabled(disabled);
		 * COMP_POSTROW_BUT.setDisabled(disabled);
		 */

		/*Added by Ram on 17/04/2017 for disable all components if it is approved*/
		COMP_PD_ADDR_02.setDisabled(disabled);
		COMP_PD_LC_AMT.setDisabled(disabled);
		COMP_PD_FC_AMT.setDisabled(disabled);
		setQueryMode(disabled);
		/*End*/
		
		
		/*Added by Janani for Fidelity on 09.06.2018 for FSD_IL_FLA_019 */
		COMP_PD_EXCH_RATE.setDisabled(disabled);
		/*End*/
		
		/*Newly added by pidugu raj dt: 30-09-2018 for kic*/
		COMP_CREDITCARD_TEXT.setDisabled(disabled);
		COMP_POL_CONT_AD_BANK_CODE.setDisabled(disabled);
		
		COMP_CREDIT_HOLDER_TEXT.setDisabled(disabled);
		COMP_POL_CARD_EXP_DT.setDisabled(disabled);
		COMP_POL_CARD_EXP_DT_MM.setDisabled(disabled);
		COMP_POL_CARD_EXP_DT_YY.setDisabled(disabled);
		COMP_POL_CVV_NO.setDisabled(disabled);
		COMP_CREDIT_MERCHANT_BANK.setDisabled(disabled);
		/*End Newly added by pidugu raj dt: 30-09-2018 for kic*/
		
	}

	public COMPOSITE_ACTION_BEAN getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(COMPOSITE_ACTION_BEAN compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlInputText getCOMP_PD_ADDR_01_DESC() {
		return COMP_PD_ADDR_01_DESC;
	}

	public void setCOMP_PD_ADDR_01_DESC(HtmlInputText comp_pd_addr_01_desc) {
		COMP_PD_ADDR_01_DESC = comp_pd_addr_01_desc;
	}

	public HtmlInputText getCOMP_PD_ADDR_02_DESC() {
		return COMP_PD_ADDR_02_DESC;
	}

	public void setCOMP_PD_ADDR_02_DESC(HtmlInputText comp_pd_addr_02_desc) {
		COMP_PD_ADDR_02_DESC = comp_pd_addr_02_desc;
	}

	public HtmlInputText getCOMP_PD_ADDR_03_DESC() {
		return COMP_PD_ADDR_03_DESC;
	}

	public void setCOMP_PD_ADDR_03_DESC(HtmlInputText comp_pd_addr_03_desc) {
		COMP_PD_ADDR_03_DESC = comp_pd_addr_03_desc;
	}

	public void chkDepRefid(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN)
			throws Exception {

		try {
			if (PT_IL_PYMT_DTLS_BEAN.getPD_DPD_REF_ID() != null) {

			} else {
				throw new Exception(
						"Dep Ref Id : Validation Error Value is required");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	private void deleteMicrCode() throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String updateQuery = "UPDATE PW_PAYING_SLIP_DTLS SET PSL_CHK_NO = ? ,WHERE PSL_HDR_SYS_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			handler.executeUpdateStatement(updateQuery, connection,
					new Object[] {
							null,
							compositeAction.getPW_PAYING_SLIP_DTLS_ACTION()
									.getPW_PAYING_SLIP_DTLS_BEAN()
									.getPSL_HDR_SYS_ID() });
			CommonUtils.getConnection().commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void disableblock() throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String PAID_FLAG = null;
		String Query = "SELECT PC_PAID_FLAG FROM PT_IL_PREM_COLL WHERE PC_SYS_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection,
					new Object[] { (Long) CommonUtils
							.getGlobalObject("G_PC_SYS_ID") });
			if (resultSet.next()) {
				PAID_FLAG = resultSet.getString(1);
			}
			if ("A".equalsIgnoreCase(PAID_FLAG)) {
				disableAllComponent(true);
				this.setINSERT_ALLOWED(false);
				this.setUPDATE_ALLOWED(false);
				this.setDELETE_ALLOWED(false);
				COMP_ADDROW_BUT.setDisabled(true);
				COMP_PD_CHQ_NO.setDisabled(true);
			} else {
				disableAllComponent(false);
				this.setINSERT_ALLOWED(true);
				this.setUPDATE_ALLOWED(true);
				this.setDELETE_ALLOWED(true);
				COMP_ADDROW_BUT.setDisabled(false);

			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void validatePayment(PT_IL_PYMT_DTLS_ACTION action) throws Exception {
		Double pymt = 0.0;
		PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN = action.getPT_IL_PYMT_DTLS_BEAN();

		try {
			for (PT_IL_PYMT_DTLS bean : action.getDataTableList()) {
				pymt = pymt + bean.getPD_FC_AMT();
			}

			if (pymt.equals((Double) CommonUtils
					.getGlobalObject("G_PC_NET_PREM_FC"))) {
				throw new Exception("Payment Amount and Net Amount are Equal");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validatePaymentValidator(PT_IL_PYMT_DTLS_ACTION action)
			throws Exception {
		Double pymt = 0.0;
		try {
			for (PT_IL_PYMT_DTLS bean : action.getDataTableList()) {
				pymt = pymt + bean.getPD_FC_AMT();
			}
			if (pymt > (Double) CommonUtils.getGlobalObject("G_PC_NET_PREM_FC")) {
				throw new Exception(
						"Payment Amount and Net Amount does not Tally");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PD_MICR_CODE_LABEL() {
		return COMP_PD_MICR_CODE_LABEL;
	}

	public void setCOMP_PD_MICR_CODE_LABEL(
			HtmlOutputLabel comp_pd_micr_code_label) {
		COMP_PD_MICR_CODE_LABEL = comp_pd_micr_code_label;
	}

	public HtmlInputText getCOMP_PD_MICR_CODE() {
		return COMP_PD_MICR_CODE;
	}

	public void setCOMP_PD_MICR_CODE(HtmlInputText comp_pd_micr_code) {
		COMP_PD_MICR_CODE = comp_pd_micr_code;
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
				//return x
			} else {
				throw new Exception("Invalid MICR Code.");
			}
		} /*catch (DBException e) {
			e.printStackTrace();
			this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			this.getErrorMap().put("micrCode", e.getMessage());
			///throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			this.getErrorMap().put("micrCode", e.getMessage());
			//throw e;
		}*/  catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
			/*this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			this.getErrorMap().put("micrCode", e.getMessage());*/
			///throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}

	public void validatePD_MICR_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			String value_1 = (String) value;
			if (!(value_1.equalsIgnoreCase(getPT_IL_PYMT_DTLS_BEAN()
					.getPD_MICR_CODE()))) {
				/*Commented by Ram on 25/11/2016 for block MICRCode validation
				 * 
				 * chkMICRCode(value_1);
				 * 
				 * End
				 * */
				getPT_IL_PYMT_DTLS_BEAN().setPD_MICR_CODE(value_1);
				String str = String.valueOf(getPT_IL_PYMT_DTLS_BEAN()
						.getPD_MICR_CODE());
				System.out.println("------>" + str.length());
				
				/*Commented by Ram on 25/11/2016 for block MICRCode validation 
				if (str.length() > 9 || str.length() < 9) {
					throw new Exception("Enter valid MICR No.");
				}
				
				
				citycode = str.substring(0, 3);
				bankcode = str.substring(3, 6);
				branchcode = str.substring(6, 9);
				System.out.println("" + citycode);
				System.out.println("" + bankcode);
				System.out.println("" + branchcode);
/*End*/
				getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_01(citycode);
				getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_02(bankcode);
				getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_03(branchcode);
				getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_01_DESC(getCityDesc(citycode));
				getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(getBankDesc(bankcode));
				getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_03_DESC(getBranchDesc(branchcode, bankcode, citycode));
				
			}

			COMP_PD_ADDR_01.resetValue();
			COMP_PD_ADDR_02.resetValue();
			COMP_PD_ADDR_03.resetValue();
			COMP_PD_ADDR_01_DESC.resetValue();
			COMP_PD_ADDR_02_DESC.resetValue();
			COMP_PD_ADDR_03_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			/*e.printStackTrace();
			 * throw new ValidatorException(new FacesMessage(e.getMessage()));
			this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			this.getErrorMap().put("micrCode", e.getMessage());*/
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateAddr01(FacesContext context ,UIComponent component ,Object value){
		String desc = null;
		try{
			getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_01((String)value);
			desc= getCityDesc((String)value);
			getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_01_DESC(desc);
			getCOMP_PD_ADDR_01_DESC().resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateAddr02(FacesContext context ,UIComponent component ,Object value){
		String desc = null;
		try{
			getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_02((String)value);
			desc= getBankDesc((String)value);
			getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_02_DESC(desc);
			COMP_PD_ADDR_02_DESC.resetValue();
			//getCOMP_PD_ADDR_02_DESC().resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateAddr03(FacesContext context ,UIComponent component ,Object value){
		String desc = null;
		try{
			getPT_IL_PYMT_DTLS_BEAN().setPD_ADDR_03((String)value);
			desc= getBranchDesc((String)value,bankcode,citycode);
			getPT_IL_PYMT_DTLS_BEAN().setUI_PD_ADDR_03_DESC(desc);
			getCOMP_PD_ADDR_03_DESC().resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String getCityDesc(String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_CITY_DESC  FROM PM_BANK_DTLS WHERE PMD_CITY_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}
	
	
	public String getBankDesc(String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_BANK_NAME  FROM PM_BANK_DTLS WHERE PMD_BANK_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}
	
	public String getBranchDesc(String branchCode ,String bank ,String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_BRANCH_NAME  FROM PM_BANK_DTLS WHERE PMD_BRANCH_CODE = ?  " +
					" AND PMD_BANK_CODE = ? AND PMD_CITY_CODE = ?  ";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{branchCode,bank,cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}
	
	public void disableDepblock() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String FLAG= null;
		String Query = "SELECT DEP_DOC_NO FROM PT_IL_DEPOSIT WHERE DEP_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection,
					new Object[] { (Long) CommonUtils
							.getGlobalObject("GLOBAL.TXN_SYS_ID") });
			if("PILT016A_APAC".equalsIgnoreCase(CommonUtils.nvl(CommonUtils
					.getGlobalVariable("CALLING_FORM"),""))){
			if (resultSet.next()) {
				FLAG = resultSet.getString(1);
			}
			
			if(FLAG!=null && !(FLAG.equalsIgnoreCase("0"))){
				getCOMP_PD_CHQ_NO().setDisabled(true);
				getCOMP_PD_CHQ_DT().setDisabled(true);
				getCOMP_PD_MICR_CODE().setDisabled(true);
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*Added by Ram on 02/12/2016 for Bank LOV handling*/
	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_BANK_DTLS(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.M_BUT_POL_ADDL_STATUS','IL_ADDL_STATUS',:PT_IL_POLICY.POL_DS_TYPE);

/* Modified by Ram on 31/01/2017 as per user suggestion 
			 * 
			 * suggestionList = listitemutil.prepareSuggestionList("SELECT PMD_BANK_CODE,PMD_BANK_NAME FROM PM_BANK_DTLS", new Object[]{});*/
			suggestionList = new ListItemUtil().P_CALL_LOV("PILT016A_APAC",
					"PT_IL_DEPOSIT", "DEP_BANKIN_CODE", null, null, null,
					null, null, (String) currValue);
			/*End*/
			System.out.println("suggestionList "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	/*End*/

	 /*Added by Janani for Fidelity on 09.06.2018 as suggested by Sivaram for FSD_IL_FLA_019 */

	
	public PILT016A_APAC_COMPOSITE_ACTION pilt016_apac_composite_action;
	
	private HtmlOutputLabel COMP_PD_EXCH_RATE_LABEL;

	private HtmlInputText COMP_PD_EXCH_RATE;

	public HtmlOutputLabel getCOMP_PD_EXCH_RATE_LABEL() {
		return COMP_PD_EXCH_RATE_LABEL;
	}

	public void setCOMP_PD_EXCH_RATE_LABEL(HtmlOutputLabel cOMP_PD_EXCH_RATE_LABEL) {
		COMP_PD_EXCH_RATE_LABEL = cOMP_PD_EXCH_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PD_EXCH_RATE() {
		return COMP_PD_EXCH_RATE;
	}

	public void setCOMP_PD_EXCH_RATE(HtmlInputText cOMP_PD_EXCH_RATE) {
		COMP_PD_EXCH_RATE = cOMP_PD_EXCH_RATE;
	}
	

	public void validatePD_EXCH_RATE(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			Double currval = (Double)value;
			
			getPT_IL_PYMT_DTLS_BEAN().setPD_EXCH_RATE((Double) value);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	
	public void validatePD_CURR_CODE(FacesContext context, UIComponent component,
			Object value) {
		getErrorMap().clear();
		try {
			String currval = (String)value;
			
			getPT_IL_PYMT_DTLS_BEAN().setPD_CURR_CODE((String) value);
			//helper.PD_CURR_CODE_when_validate_item(this,pilt016_apac_composite_action);
			helper.PD_CURR_CODE_when_validate_item(this);
			
			
			COMP_PD_EXCH_RATE.resetValue();
			COMP_PD_LC_AMT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	
	/*End*/
	
	/*Newly added by pidugu raj dt: 30-09-2018 for kic_qc as suggested by sivaraman*/
	
	private HtmlOutputLabel COMP_CREDITCARD_LABEL;
	private HtmlOutputLabel COMP_POL_CONT_AD_BANK_CODE_LABEL;
	private HtmlInputText COMP_CREDIT_MERCHANT_BANK;
	private HtmlInputText COMP_CREDITCARD_TEXT;
	private HtmlInputText COMP_POL_CONT_AD_BANK_CODE;
	private HtmlInputText COMP_UI_M_BANK_CODE_DESC;
	private HtmlOutputLabel COMP_CREDIT_HOLDER_NAME;
	private HtmlInputText COMP_CREDIT_HOLDER_TEXT;
	private HtmlCalendar COMP_POL_CARD_EXP_DT;
	private HtmlOutputLabel COMP_POL_CARD_EXP_DT_LABEL;
	private HtmlInputText COMP_POL_CARD_EXP_DT_MM;
	private HtmlInputText COMP_POL_CARD_EXP_DT_YY;
	private HtmlOutputLabel COMP_POL_CVV_NO_LABEL;
	private HtmlInputText COMP_POL_CVV_NO;
	
	public HtmlCalendar getCOMP_POL_CARD_EXP_DT() {
		return COMP_POL_CARD_EXP_DT;
	}

	public void setCOMP_POL_CARD_EXP_DT(HtmlCalendar cOMP_POL_CARD_EXP_DT) {
		COMP_POL_CARD_EXP_DT = cOMP_POL_CARD_EXP_DT;
	}

	public HtmlOutputLabel getCOMP_CREDIT_HOLDER_NAME() {
		return COMP_CREDIT_HOLDER_NAME;
	}

	public void setCOMP_CREDIT_HOLDER_NAME(HtmlOutputLabel cOMP_CREDIT_HOLDER_NAME) {
		COMP_CREDIT_HOLDER_NAME = cOMP_CREDIT_HOLDER_NAME;
	}

	public HtmlInputText getCOMP_CREDIT_HOLDER_TEXT() {
		return COMP_CREDIT_HOLDER_TEXT;
	}

	public void setCOMP_CREDIT_HOLDER_TEXT(HtmlInputText cOMP_CREDIT_HOLDER_TEXT) {
		COMP_CREDIT_HOLDER_TEXT = cOMP_CREDIT_HOLDER_TEXT;
	}

	public void validateCreditCardDetail(FacesContext context, UIComponent component,
			Object value){
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CC_NO((String) value);
			System.out.println("Credit card no: "+getPT_IL_PYMT_DTLS_BEAN().getPD_CC_NO());
			COMP_CREDITCARD_TEXT.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	
	
	public void doValidateCreditHolderName(FacesContext context, UIComponent component,
			Object value){
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CC_NAME((String) value);
			COMP_CREDIT_HOLDER_TEXT.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	
	public void doValidateCvvNo(FacesContext context, UIComponent component,
			Object value){
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPD_CVV_NO((int) value);
			COMP_POL_CVV_NO.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	public void doValidateExpiryDateMM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			
			System.out.println("inside doValidateExpiryDateMM");
			
			getPT_IL_PYMT_DTLS_BEAN().setPOL_CARD_EXP_DT_MM((String) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void doValidateExpiryDateYY(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			
			System.out.println("inside doValidateExpiryDateYY");
			
			getPT_IL_PYMT_DTLS_BEAN().setPOL_CARD_EXP_DT_YY((String) value);
			String stringFormDate = getPT_IL_PYMT_DTLS_BEAN().getPOL_CARD_EXP_DT_MM()+"/"+getPT_IL_PYMT_DTLS_BEAN().getPOL_CARD_EXP_DT_YY();
			stringFormDate = "01"+"/"+stringFormDate;
			Date date=new SimpleDateFormat("dd/MM/yyyy").parse(stringFormDate);
			System.out.println("Expiry date set in db is: "+date);
			Date PD_CC_EXP_DT = date;
			getPT_IL_PYMT_DTLS_BEAN().setPD_CC_EXP_DT(PD_CC_EXP_DT);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	
	public void doValidateMerchantBank(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			getPT_IL_PYMT_DTLS_BEAN().setMERCHANT_BANK((String) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	
	
	public void validateCreditHolderDetail(FacesContext context, UIComponent component,
			Object value){
		getErrorMap().clear();
		try {
			getPT_IL_PYMT_DTLS_BEAN().setPOL_CARD_HOLDER_NAME((String) value);
			COMP_CREDIT_HOLDER_TEXT.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}

	public HtmlOutputLabel getCOMP_CREDITCARD_LABEL() {
		return COMP_CREDITCARD_LABEL;
	}

	public void setCOMP_CREDITCARD_LABEL(HtmlOutputLabel cOMP_CREDITCARD_LABEL) {
		COMP_CREDITCARD_LABEL = cOMP_CREDITCARD_LABEL;
	}

	public HtmlInputText getCOMP_CREDITCARD_TEXT() {
		return COMP_CREDITCARD_TEXT;
	}

	public void setCOMP_CREDITCARD_TEXT(HtmlInputText cOMP_CREDITCARD_TEXT) {
		COMP_CREDITCARD_TEXT = cOMP_CREDITCARD_TEXT;
	}
	
	
	

	public HtmlOutputLabel getCOMP_POL_CONT_AD_BANK_CODE_LABEL() {
		return COMP_POL_CONT_AD_BANK_CODE_LABEL;
	}

	public void setCOMP_POL_CONT_AD_BANK_CODE_LABEL(
			HtmlOutputLabel cOMP_POL_CONT_AD_BANK_CODE_LABEL) {
		COMP_POL_CONT_AD_BANK_CODE_LABEL = cOMP_POL_CONT_AD_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CREDIT_MERCHANT_BANK() {
		return COMP_CREDIT_MERCHANT_BANK;
	}

	public void setCOMP_CREDIT_MERCHANT_BANK(HtmlInputText cOMP_CREDIT_MERCHANT_BANK) {
		COMP_CREDIT_MERCHANT_BANK = cOMP_CREDIT_MERCHANT_BANK;
	}

	public HtmlInputText getCOMP_POL_CONT_AD_BANK_CODE() {
		return COMP_POL_CONT_AD_BANK_CODE;
	}

	public void setCOMP_POL_CONT_AD_BANK_CODE(
			HtmlInputText cOMP_POL_CONT_AD_BANK_CODE) {
		COMP_POL_CONT_AD_BANK_CODE = cOMP_POL_CONT_AD_BANK_CODE;
	}

	public HtmlInputText getCOMP_UI_M_BANK_CODE_DESC() {
		return COMP_UI_M_BANK_CODE_DESC;
	}

	public void setCOMP_UI_M_BANK_CODE_DESC(HtmlInputText cOMP_UI_M_BANK_CODE_DESC) {
		COMP_UI_M_BANK_CODE_DESC = cOMP_UI_M_BANK_CODE_DESC;
	}
	
	/*End Newly added by pidugu raj dt: 30-09-2018 for kic_qc as suggested by sivaraman*/

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_CONT_AD_BANK_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_CONT_AD_BANK_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public HtmlOutputLabel getCOMP_POL_CARD_EXP_DT_LABEL() {
		return COMP_POL_CARD_EXP_DT_LABEL;
	}

	public void setCOMP_POL_CARD_EXP_DT_LABEL(HtmlOutputLabel cOMP_POL_CARD_EXP_DT_LABEL) {
		COMP_POL_CARD_EXP_DT_LABEL = cOMP_POL_CARD_EXP_DT_LABEL;
	}

	public HtmlInputText getCOMP_POL_CARD_EXP_DT_MM() {
		return COMP_POL_CARD_EXP_DT_MM;
	}

	public void setCOMP_POL_CARD_EXP_DT_MM(HtmlInputText cOMP_POL_CARD_EXP_DT_MM) {
		COMP_POL_CARD_EXP_DT_MM = cOMP_POL_CARD_EXP_DT_MM;
	}

	public HtmlInputText getCOMP_POL_CARD_EXP_DT_YY() {
		return COMP_POL_CARD_EXP_DT_YY;
	}

	public void setCOMP_POL_CARD_EXP_DT_YY(HtmlInputText cOMP_POL_CARD_EXP_DT_YY) {
		COMP_POL_CARD_EXP_DT_YY = cOMP_POL_CARD_EXP_DT_YY;
	}

	public HtmlOutputLabel getCOMP_POL_CVV_NO_LABEL() {
		return COMP_POL_CVV_NO_LABEL;
	}

	public void setCOMP_POL_CVV_NO_LABEL(HtmlOutputLabel cOMP_POL_CVV_NO_LABEL) {
		COMP_POL_CVV_NO_LABEL = cOMP_POL_CVV_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_CVV_NO() {
		return COMP_POL_CVV_NO;
	}

	public void setCOMP_POL_CVV_NO(HtmlInputText cOMP_POL_CVV_NO) {
		COMP_POL_CVV_NO = cOMP_POL_CVV_NO;
	}
	
	
}