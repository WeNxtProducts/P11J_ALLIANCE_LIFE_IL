package com.iii.pel.forms.PILT027;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT016A_APAC.PT_IL_DEPOSIT;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_TOP_UP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_UI_M_REVERSE_STATUS;

	private HtmlOutputLabel COMP_TU_CUST_REF_ID1_LABEL;

	private HtmlInputText COMP_TU_CUST_REF_ID1;

	private HtmlOutputLabel COMP_TU_CUST_REF_ID2_LABEL;

	private HtmlInputText COMP_TU_CUST_REF_ID2;

	private HtmlOutputLabel COMP_TU_CUST_CODE_LABEL;

	private HtmlInputText COMP_TU_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_TU_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TU_CUST_NAME;

	private HtmlOutputLabel COMP_TU_POL_NO_LABEL;

	private HtmlInputText COMP_TU_POL_NO;

	private HtmlOutputLabel COMP_TU_CONTROL_NO_LABEL;

	private HtmlInputText COMP_TU_CONTROL_NO;

	private HtmlOutputLabel COMP_TU_TXN_CODE_LABEL;

	private HtmlInputText COMP_TU_TXN_CODE;

	private HtmlOutputLabel COMP_TU_LC_TOPUP_DEP_AMT_LABEL;

	private HtmlInputText COMP_TU_LC_TOPUP_DEP_AMT;

	private HtmlOutputLabel COMP_TU_DOC_NO_LABEL;

	private HtmlInputText COMP_TU_DOC_NO;

	private HtmlOutputLabel COMP_TU_DATE_LABEL;

	private HtmlCalendar COMP_TU_DATE;

	private HtmlOutputLabel COMP_TU_DOC_DT_LABEL;

	private HtmlCalendar COMP_TU_DOC_DT;

	private HtmlOutputLabel COMP_TU_LC_TOPUP_CHRG_AMT_LABEL;

	private HtmlInputText COMP_TU_LC_TOPUP_CHRG_AMT;

	private HtmlOutputLabel COMP_TU_LC_TOPUP_NET_AMT_LABEL;

	private HtmlInputText COMP_TU_LC_TOPUP_NET_AMT;

	private HtmlOutputLabel COMP_TU_BANK_CODE_LABEL;

	private HtmlInputText COMP_TU_BANK_CODE;

	private HtmlOutputLabel COMP_UI_M_TU_BANK_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TU_BANK_NAME;

	private HtmlOutputLabel COMP_TU_REASON_CODE_LABEL;

	private HtmlInputText COMP_TU_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_DESC;

	private HtmlOutputLabel COMP_TU_REMARKS_LABEL;

	private HtmlInputText COMP_TU_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_REF_ID1_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_REF_ID2_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_TU_CUST_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_TU_POL_NO_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_TU_BANK_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_REMARKS_BUT;

	private HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVAL;

	private HtmlCommandButton COMP_UI_M_BUT_REVERSE;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_FUND_DTLS;

	private HtmlOutputLabel COMP_TU_WAK_FEE_LABEL;

	private HtmlInputText COMP_TU_WAK_FEE;
	
	private HtmlCommandLink COMP_UI_M_BUT_DELETE;
	
	private HtmlCommandLink COMP_UI_M_BUT_SAVE;

	private PT_IL_TOP_UP PT_IL_TOP_UP_BEAN;

	private PT_IL_TOP_UP_HELPER helper;

	public PILT027_COMPOSITE_ACTION pilt027_composite_action;
	
	P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();

	P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();
	
	public PT_IL_TOP_UP_ACTION() {
		PT_IL_TOP_UP_BEAN = new PT_IL_TOP_UP();
		
		helper = new PT_IL_TOP_UP_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_REVERSE_STATUS() {
		return COMP_UI_M_REVERSE_STATUS;
	}

	public void setCOMP_UI_M_REVERSE_STATUS(
			HtmlOutputLabel COMP_UI_M_REVERSE_STATUS) {
		this.COMP_UI_M_REVERSE_STATUS = COMP_UI_M_REVERSE_STATUS;
	}

	public HtmlOutputLabel getCOMP_TU_CUST_REF_ID1_LABEL() {
		return COMP_TU_CUST_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_TU_CUST_REF_ID1() {
		return COMP_TU_CUST_REF_ID1;
	}

	public void setCOMP_TU_CUST_REF_ID1_LABEL(
			HtmlOutputLabel COMP_TU_CUST_REF_ID1_LABEL) {
		this.COMP_TU_CUST_REF_ID1_LABEL = COMP_TU_CUST_REF_ID1_LABEL;
	}

	public void setCOMP_TU_CUST_REF_ID1(HtmlInputText COMP_TU_CUST_REF_ID1) {
		this.COMP_TU_CUST_REF_ID1 = COMP_TU_CUST_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_TU_CUST_REF_ID2_LABEL() {
		return COMP_TU_CUST_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_TU_CUST_REF_ID2() {
		return COMP_TU_CUST_REF_ID2;
	}

	public void setCOMP_TU_CUST_REF_ID2_LABEL(
			HtmlOutputLabel COMP_TU_CUST_REF_ID2_LABEL) {
		this.COMP_TU_CUST_REF_ID2_LABEL = COMP_TU_CUST_REF_ID2_LABEL;
	}

	public void setCOMP_TU_CUST_REF_ID2(HtmlInputText COMP_TU_CUST_REF_ID2) {
		this.COMP_TU_CUST_REF_ID2 = COMP_TU_CUST_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_TU_CUST_CODE_LABEL() {
		return COMP_TU_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TU_CUST_CODE() {
		return COMP_TU_CUST_CODE;
	}

	public void setCOMP_TU_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_TU_CUST_CODE_LABEL) {
		this.COMP_TU_CUST_CODE_LABEL = COMP_TU_CUST_CODE_LABEL;
	}

	public void setCOMP_TU_CUST_CODE(HtmlInputText COMP_TU_CUST_CODE) {
		this.COMP_TU_CUST_CODE = COMP_TU_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TU_CUST_NAME_LABEL() {
		return COMP_UI_M_TU_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TU_CUST_NAME() {
		return COMP_UI_M_TU_CUST_NAME;
	}

	public void setCOMP_UI_M_TU_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TU_CUST_NAME_LABEL) {
		this.COMP_UI_M_TU_CUST_NAME_LABEL = COMP_UI_M_TU_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_TU_CUST_NAME(HtmlInputText COMP_UI_M_TU_CUST_NAME) {
		this.COMP_UI_M_TU_CUST_NAME = COMP_UI_M_TU_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_TU_POL_NO_LABEL() {
		return COMP_TU_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_TU_POL_NO() {
		return COMP_TU_POL_NO;
	}

	public void setCOMP_TU_POL_NO_LABEL(HtmlOutputLabel COMP_TU_POL_NO_LABEL) {
		this.COMP_TU_POL_NO_LABEL = COMP_TU_POL_NO_LABEL;
	}

	public void setCOMP_TU_POL_NO(HtmlInputText COMP_TU_POL_NO) {
		this.COMP_TU_POL_NO = COMP_TU_POL_NO;
	}

	public HtmlOutputLabel getCOMP_TU_CONTROL_NO_LABEL() {
		return COMP_TU_CONTROL_NO_LABEL;
	}

	public HtmlInputText getCOMP_TU_CONTROL_NO() {
		return COMP_TU_CONTROL_NO;
	}

	public void setCOMP_TU_CONTROL_NO_LABEL(
			HtmlOutputLabel COMP_TU_CONTROL_NO_LABEL) {
		this.COMP_TU_CONTROL_NO_LABEL = COMP_TU_CONTROL_NO_LABEL;
	}

	public void setCOMP_TU_CONTROL_NO(HtmlInputText COMP_TU_CONTROL_NO) {
		this.COMP_TU_CONTROL_NO = COMP_TU_CONTROL_NO;
	}

	public HtmlOutputLabel getCOMP_TU_TXN_CODE_LABEL() {
		return COMP_TU_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TU_TXN_CODE() {
		return COMP_TU_TXN_CODE;
	}

	public void setCOMP_TU_TXN_CODE_LABEL(HtmlOutputLabel COMP_TU_TXN_CODE_LABEL) {
		this.COMP_TU_TXN_CODE_LABEL = COMP_TU_TXN_CODE_LABEL;
	}

	public void setCOMP_TU_TXN_CODE(HtmlInputText COMP_TU_TXN_CODE) {
		this.COMP_TU_TXN_CODE = COMP_TU_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_TU_LC_TOPUP_DEP_AMT_LABEL() {
		return COMP_TU_LC_TOPUP_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_TU_LC_TOPUP_DEP_AMT() {
		return COMP_TU_LC_TOPUP_DEP_AMT;
	}

	public void setCOMP_TU_LC_TOPUP_DEP_AMT_LABEL(
			HtmlOutputLabel COMP_TU_LC_TOPUP_DEP_AMT_LABEL) {
		this.COMP_TU_LC_TOPUP_DEP_AMT_LABEL = COMP_TU_LC_TOPUP_DEP_AMT_LABEL;
	}

	public void setCOMP_TU_LC_TOPUP_DEP_AMT(
			HtmlInputText COMP_TU_LC_TOPUP_DEP_AMT) {
		this.COMP_TU_LC_TOPUP_DEP_AMT = COMP_TU_LC_TOPUP_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_TU_DOC_NO_LABEL() {
		return COMP_TU_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_TU_DOC_NO() {
		return COMP_TU_DOC_NO;
	}

	public void setCOMP_TU_DOC_NO_LABEL(HtmlOutputLabel COMP_TU_DOC_NO_LABEL) {
		this.COMP_TU_DOC_NO_LABEL = COMP_TU_DOC_NO_LABEL;
	}

	public void setCOMP_TU_DOC_NO(HtmlInputText COMP_TU_DOC_NO) {
		this.COMP_TU_DOC_NO = COMP_TU_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_TU_DATE_LABEL() {
		return COMP_TU_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_TU_DATE() {
		return COMP_TU_DATE;
	}

	public void setCOMP_TU_DATE_LABEL(HtmlOutputLabel COMP_TU_DATE_LABEL) {
		this.COMP_TU_DATE_LABEL = COMP_TU_DATE_LABEL;
	}

	public void setCOMP_TU_DATE(HtmlCalendar COMP_TU_DATE) {
		this.COMP_TU_DATE = COMP_TU_DATE;
	}

	public HtmlOutputLabel getCOMP_TU_DOC_DT_LABEL() {
		return COMP_TU_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TU_DOC_DT() {
		return COMP_TU_DOC_DT;
	}

	public void setCOMP_TU_DOC_DT_LABEL(HtmlOutputLabel COMP_TU_DOC_DT_LABEL) {
		this.COMP_TU_DOC_DT_LABEL = COMP_TU_DOC_DT_LABEL;
	}

	public void setCOMP_TU_DOC_DT(HtmlCalendar COMP_TU_DOC_DT) {
		this.COMP_TU_DOC_DT = COMP_TU_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_TU_LC_TOPUP_CHRG_AMT_LABEL() {
		return COMP_TU_LC_TOPUP_CHRG_AMT_LABEL;
	}

	public HtmlInputText getCOMP_TU_LC_TOPUP_CHRG_AMT() {
		return COMP_TU_LC_TOPUP_CHRG_AMT;
	}

	public void setCOMP_TU_LC_TOPUP_CHRG_AMT_LABEL(
			HtmlOutputLabel COMP_TU_LC_TOPUP_CHRG_AMT_LABEL) {
		this.COMP_TU_LC_TOPUP_CHRG_AMT_LABEL = COMP_TU_LC_TOPUP_CHRG_AMT_LABEL;
	}

	public void setCOMP_TU_LC_TOPUP_CHRG_AMT(
			HtmlInputText COMP_TU_LC_TOPUP_CHRG_AMT) {
		this.COMP_TU_LC_TOPUP_CHRG_AMT = COMP_TU_LC_TOPUP_CHRG_AMT;
	}

	public HtmlOutputLabel getCOMP_TU_LC_TOPUP_NET_AMT_LABEL() {
		return COMP_TU_LC_TOPUP_NET_AMT_LABEL;
	}

	public HtmlInputText getCOMP_TU_LC_TOPUP_NET_AMT() {
		return COMP_TU_LC_TOPUP_NET_AMT;
	}

	public void setCOMP_TU_LC_TOPUP_NET_AMT_LABEL(
			HtmlOutputLabel COMP_TU_LC_TOPUP_NET_AMT_LABEL) {
		this.COMP_TU_LC_TOPUP_NET_AMT_LABEL = COMP_TU_LC_TOPUP_NET_AMT_LABEL;
	}

	public void setCOMP_TU_LC_TOPUP_NET_AMT(
			HtmlInputText COMP_TU_LC_TOPUP_NET_AMT) {
		this.COMP_TU_LC_TOPUP_NET_AMT = COMP_TU_LC_TOPUP_NET_AMT;
	}

	public HtmlOutputLabel getCOMP_TU_BANK_CODE_LABEL() {
		return COMP_TU_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TU_BANK_CODE() {
		return COMP_TU_BANK_CODE;
	}

	public void setCOMP_TU_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_TU_BANK_CODE_LABEL) {
		this.COMP_TU_BANK_CODE_LABEL = COMP_TU_BANK_CODE_LABEL;
	}

	public void setCOMP_TU_BANK_CODE(HtmlInputText COMP_TU_BANK_CODE) {
		this.COMP_TU_BANK_CODE = COMP_TU_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TU_BANK_NAME_LABEL() {
		return COMP_UI_M_TU_BANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TU_BANK_NAME() {
		return COMP_UI_M_TU_BANK_NAME;
	}

	public void setCOMP_UI_M_TU_BANK_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TU_BANK_NAME_LABEL) {
		this.COMP_UI_M_TU_BANK_NAME_LABEL = COMP_UI_M_TU_BANK_NAME_LABEL;
	}

	public void setCOMP_UI_M_TU_BANK_NAME(HtmlInputText COMP_UI_M_TU_BANK_NAME) {
		this.COMP_UI_M_TU_BANK_NAME = COMP_UI_M_TU_BANK_NAME;
	}

	public HtmlOutputLabel getCOMP_TU_REASON_CODE_LABEL() {
		return COMP_TU_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TU_REASON_CODE() {
		return COMP_TU_REASON_CODE;
	}

	public void setCOMP_TU_REASON_CODE_LABEL(
			HtmlOutputLabel COMP_TU_REASON_CODE_LABEL) {
		this.COMP_TU_REASON_CODE_LABEL = COMP_TU_REASON_CODE_LABEL;
	}

	public void setCOMP_TU_REASON_CODE(HtmlInputText COMP_TU_REASON_CODE) {
		this.COMP_TU_REASON_CODE = COMP_TU_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_DESC_LABEL() {
		return COMP_UI_M_REASON_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_DESC() {
		return COMP_UI_M_REASON_DESC;
	}

	public void setCOMP_UI_M_REASON_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL) {
		this.COMP_UI_M_REASON_DESC_LABEL = COMP_UI_M_REASON_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_DESC(HtmlInputText COMP_UI_M_REASON_DESC) {
		this.COMP_UI_M_REASON_DESC = COMP_UI_M_REASON_DESC;
	}

	public HtmlOutputLabel getCOMP_TU_REMARKS_LABEL() {
		return COMP_TU_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_TU_REMARKS() {
		return COMP_TU_REMARKS;
	}

	public void setCOMP_TU_REMARKS_LABEL(HtmlOutputLabel COMP_TU_REMARKS_LABEL) {
		this.COMP_TU_REMARKS_LABEL = COMP_TU_REMARKS_LABEL;
	}

	public void setCOMP_TU_REMARKS(HtmlInputText COMP_TU_REMARKS) {
		this.COMP_TU_REMARKS = COMP_TU_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_REF_ID1_LOV() {
		return COMP_UI_M_BUT_CUST_REF_ID1_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_REF_ID1_LOV(
			HtmlCommandButton COMP_UI_M_BUT_CUST_REF_ID1_LOV) {
		this.COMP_UI_M_BUT_CUST_REF_ID1_LOV = COMP_UI_M_BUT_CUST_REF_ID1_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_REF_ID2_LOV() {
		return COMP_UI_M_BUT_CUST_REF_ID2_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_REF_ID2_LOV(
			HtmlCommandButton COMP_UI_M_BUT_CUST_REF_ID2_LOV) {
		this.COMP_UI_M_BUT_CUST_REF_ID2_LOV = COMP_UI_M_BUT_CUST_REF_ID2_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TU_CUST_CODE_LOV() {
		return COMP_UI_M_BUT_TU_CUST_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_TU_CUST_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_TU_CUST_CODE_LOV) {
		this.COMP_UI_M_BUT_TU_CUST_CODE_LOV = COMP_UI_M_BUT_TU_CUST_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TU_POL_NO_LOV() {
		return COMP_UI_M_BUT_TU_POL_NO_LOV;
	}

	public void setCOMP_UI_M_BUT_TU_POL_NO_LOV(
			HtmlCommandButton COMP_UI_M_BUT_TU_POL_NO_LOV) {
		this.COMP_UI_M_BUT_TU_POL_NO_LOV = COMP_UI_M_BUT_TU_POL_NO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TU_BANK_CODE_LOV() {
		return COMP_UI_M_BUT_TU_BANK_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_TU_BANK_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_TU_BANK_CODE_LOV) {
		this.COMP_UI_M_BUT_TU_BANK_CODE_LOV = COMP_UI_M_BUT_TU_BANK_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_REMARKS_BUT() {
		return COMP_UI_M_REMARKS_BUT;
	}

	public void setCOMP_UI_M_REMARKS_BUT(HtmlCommandButton COMP_UI_M_REMARKS_BUT) {
		this.COMP_UI_M_REMARKS_BUT = COMP_UI_M_REMARKS_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BROKER_DTLS() {
		return COMP_UI_M_BUT_BROKER_DTLS;
	}

	public void setCOMP_UI_M_BUT_BROKER_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS) {
		this.COMP_UI_M_BUT_BROKER_DTLS = COMP_UI_M_BUT_BROKER_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(
			HtmlCommandButton COMP_UI_M_BUT_APPROVAL) {
		this.COMP_UI_M_BUT_APPROVAL = COMP_UI_M_BUT_APPROVAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REVERSE() {
		return COMP_UI_M_BUT_REVERSE;
	}

	public void setCOMP_UI_M_BUT_REVERSE(HtmlCommandButton COMP_UI_M_BUT_REVERSE) {
		this.COMP_UI_M_BUT_REVERSE = COMP_UI_M_BUT_REVERSE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS) {
		this.COMP_UI_M_BUT_PYMT_DTLS = COMP_UI_M_BUT_PYMT_DTLS;
	}

	public PT_IL_TOP_UP getPT_IL_TOP_UP_BEAN() {
		return PT_IL_TOP_UP_BEAN;
	}

	public void setPT_IL_TOP_UP_BEAN(PT_IL_TOP_UP PT_IL_TOP_UP_BEAN) {
		this.PT_IL_TOP_UP_BEAN = PT_IL_TOP_UP_BEAN;
	}

	public String nextPageButtonClickAction() {
		String returnString = "GO_TO_PILT027_PT_IL_DEPOSIT_CHARGE";
		return returnString;
	}

	public String saveNextButtonClickAction() {
		String returnString = "GO_TO_PILT027_PT_IL_DEPOSIT_CHARGE";
		return returnString;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_DTLS() {
		return COMP_UI_M_BUT_FUND_DTLS;
	}

	public void setCOMP_UI_M_BUT_FUND_DTLS(
			HtmlCommandButton comp_ui_m_but_fund_dtls) {
		COMP_UI_M_BUT_FUND_DTLS = comp_ui_m_but_fund_dtls;
	}

	public HtmlOutputLabel getCOMP_TU_WAK_FEE_LABEL() {
		return COMP_TU_WAK_FEE_LABEL;
	}

	public void setCOMP_TU_WAK_FEE_LABEL(HtmlOutputLabel comp_tu_wak_fee_label) {
		COMP_TU_WAK_FEE_LABEL = comp_tu_wak_fee_label;
	}

	public HtmlInputText getCOMP_TU_WAK_FEE() {
		return COMP_TU_WAK_FEE;
	}

	public void setCOMP_TU_WAK_FEE(HtmlInputText comp_tu_wak_fee) {
		COMP_TU_WAK_FEE = comp_tu_wak_fee;
	}

	public List<LovBean> lovNew_IC_NO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_TOP_UP",
					"TU_CUST_REF_ID1", null, null, null, null, null,
					(String) currValue);

			for (LovBean lovBean : suggestionList) {

				System.out.println("....." + lovBean.getCode());
				System.out.println("....." + lovBean.getLovCode());

			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CS_COVER_CODE_KEY_LISTVAL", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> lovTU_CUST_REF_ID2(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_TOP_UP",
					"TU_CUST_REF_ID2", null, null, null, null, null,
					(String) currValue);

			for (LovBean lovBean : suggestionList) {

				System.out.println("....." + lovBean.getCode());
				System.out.println("....." + lovBean.getLovCode());

			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CS_COVER_CODE_KEY_LISTVAL", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> lovTU_CUST_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_TOP_UP",
					"TU_CUST_CODE", null, null, null, null, null,
					(String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CS_COVER_CODE_KEY_LISTVAL", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> lovTU_POL_NO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			if (PT_IL_TOP_UP_BEAN.getTU_CUST_CODE() != null) {

				suggestionList = listitemutil.P_CALL_LOV("PILT027",
						"PT_IL_TOP_UP", "TU_POL_NO", PT_IL_TOP_UP_BEAN
								.getTU_CUST_CODE(), null, null, null, null,
						(String) currValue);
			} else {
				suggestionList = listitemutil.P_CALL_LOV("PILT027",
						"PT_IL_TOP_UP", "TU_POL_NO", null, null, null, null,
						null, (String) currValue);
			}
			for (LovBean lovBean : suggestionList) {

				System.out.println("....." + lovBean.getCode());
				System.out.println("....." + lovBean.getLovCode());

			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CS_COVER_CODE_KEY_LISTVAL", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> lovTU_BANK_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_TOP_UP",
					"TU_BANK_CODE", null, null, null, null, null,
					(String) currValue);

			for (LovBean lovBean : suggestionList) {

				System.out.println("....." + lovBean.getCode());
				System.out.println("....." + lovBean.getLovCode());

			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CS_COVER_CODE_KEY_LISTVAL", e.getMessage());
		}
		return suggestionList;
	}

	public void saveButtonClick() {
		System.out.println("FM_CURRENCY_ACTION.Save_Record()");
		int status = 0;
		CommonUtils.clearMaps(this);
		String mappedBeanName = "PILT027_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT027_COMPOSITE_ACTION actionBean = (PILT027_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String message = null;
		actionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN();

		PT_IL_TOP_UP_DELEGATE delegate = new PT_IL_TOP_UP_DELEGATE();
		/*Added by Ameen 16-05-2017 as per Gaurav sugg.*/
		String planTypeQuery = "SELECT PLAN_TYPE FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE AND POL_NO = ?";
		ResultSet planTypeRs = null;
		String plan_type = null;
		/*End*/
		try {
			if (PT_IL_TOP_UP_BEAN.getROWID() == null) {
				delegate.preInsert(this.PT_IL_TOP_UP_BEAN);
				status = delegate.executeInsert(PT_IL_TOP_UP_BEAN);
				helper.postInsert(pilt027_composite_action);
				new PT_IL_TOP_UP_DELEGATE().executeSelectStatement(pilt027_composite_action);
				/*Added by Ameen 16-05-2017 as per Gaurav sugg.*/
				planTypeRs = new CRUDHandler().executeSelectStatement(planTypeQuery, CommonUtils.getConnection(),
						new Object[]{PT_IL_TOP_UP_BEAN.getTU_POL_NO()});
				if(planTypeRs.next()){
					plan_type = planTypeRs.getString("PLAN_TYPE");
				}
				System.out.println("plan_type ===========>>>>>" + plan_type);
				if(!"H".equalsIgnoreCase(plan_type)){
					/*Modified by saritha on 29-07-2017 for ssp call id ZBILQC-1733101 as per gaurav sugg*/
					/*p9ilpk_policy.INS_TOP_UP_FUNDS(PT_IL_TOP_UP_BEAN.getTU_SYS_ID(),PT_IL_TOP_UP_BEAN.getTU_POL_NO());*/
				    INS_TOP_UP_FUNDS(PT_IL_TOP_UP_BEAN.getTU_SYS_ID(),PT_IL_TOP_UP_BEAN.getTU_POL_NO());
					/*End*/
				}
				/*End*/
				
				/*Added by Janani on 12.09.2017 for ZBILQC-1733099*/
			
				calP_INS_PYMT_DTLS();
				
				
				/*End of ZBILQC-1733099*/
				
				
				if (status >= 1) {
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE_RECORD", message);

				}

			} else {
				status = delegate.executeUpdate(PT_IL_TOP_UP_BEAN);
				if (status >= 0) {
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");

					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"UPDATE_MESSAGE"));
				}
			}
			//p9ilpk_fund_alloc.GET_TOPUP_RATE(pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_SYS_ID(),pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_SYS_ID(),pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_NET_AMT());
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			/*Added by ganesh on 09-06-2017 ,ZBILQC-1727637 UL - TopUp Collection*/
			/*throw new ValidatorException(new FacesMessage(e.getMessage()));*/
			getErrorMap().put("current", e.getMessage());
			/*end*/
		}
	}

	/*
	 * public String saveButtonClick() { String returnString = ""; String
	 * message = null; PT_IL_TOP_UP_DELEGATE delegate = new
	 * PT_IL_TOP_UP_DELEGATE(); if (PT_IL_TOP_UP_BEAN.getROWID() == null) {
	 * delegate.preInsert(this.PT_IL_TOP_UP_BEAN); message =
	 * Messages.getString("messageProperties", "errorPanel$message$save"); }
	 * else { message = Messages.getString("messageProperties",
	 * "errorPanel$message$update"); }
	 * 
	 * delegate.saveRecord(this.PT_IL_TOP_UP_BEAN, true); if (message != null) {
	 * getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message); }
	 * return returnString; }
	 */

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if (PT_IL_TOP_UP_BEAN.getROWID() != null) {
					new PT_IL_TOP_UP_DELEGATE()
							.executeSelectStatement(pilt027_composite_action);
					fetchPlanProdDetails(PT_IL_TOP_UP_BEAN.getTU_POL_NO());					
					if("H".equalsIgnoreCase(getPlanType()) && "Y".equalsIgnoreCase(getProdIntrSavingYN())){
						COMP_UI_M_BUT_FUND_DTLS.setDisabled(true);
					}
					
					
				} else {
					helper.whenCreateReacord(PT_IL_TOP_UP_BEAN);
				}
				setBlockFlag(false);
				/*Added by saritha on 11-08-2017 for ssp call id ZBILQC-1733097*/
				topup_sys_param();
				/*End*/
				
			}
			helper.freeze(pilt027_composite_action);
			helper.isFundAllocationCompleted(pilt027_composite_action);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void Delete_Record() {
		try {
			if (isDELETE_ALLOWED() && PT_IL_TOP_UP_BEAN.getROWID() != null) {
				int status = 0;
				status = new PT_IL_TOP_UP_DELEGATE()
						.executeDelete(PT_IL_TOP_UP_BEAN);
				getWarningMap().put(
						"somekey",
						status
								+ " "
								+ Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$delete"));
				getWarningMap().put(
						"current",
						status
								+ " "
								+ Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$delete"));
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}

		PT_IL_TOP_UP_BEAN = new PT_IL_TOP_UP();

	}

	public void setErrorMessagesInMap(ActionEvent event) {
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
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

	public void validateTU_CUST_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			String currValue = (String) value;
			String beanValue = PT_IL_TOP_UP_BEAN.getTU_CUST_CODE();
			if(!currValue.equalsIgnoreCase(beanValue)){
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_CUST_CODE(value.toString());
				helper.when_validate_tu_cust_code();
			}
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateTU_LC_TOPUP_DEP_AMT(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			if (null != value) {
				Double tu_lc_topup_dep_amt = Double.parseDouble(value
						.toString());
				PT_IL_TOP_UP_BEAN.setTU_LC_TOPUP_DEP_AMT(tu_lc_topup_dep_amt);
				helper.whenValidateTopupDepositAmount(PT_IL_TOP_UP_BEAN);
				// helper.when_validatetu_lc_topup_dep_amt();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_BANK_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_BANK_CODE(value.toString());
				helper.when_validate_tu_bank_code();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_CUST_REF_ID1(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_CUST_REF_ID1(value.toString());
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateTU_CUST_REF_ID2(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_CUST_REF_ID2(value.toString());
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_CONTROL_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_CONTROL_NO(value.toString());
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_TXN_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_TXN_CODE(value.toString());
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_DOC_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_DOC_NO((Integer) value);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_DATE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		Date tempDate = null;

		try {
			if (null != value) {
				tempDate = (Date) value;
				PT_IL_TOP_UP_BEAN.setTU_DATE(tempDate);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_DOC_DT(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		Date tempDate = null;

		try {
			if (null != value) {
				tempDate = (Date) value;
				PT_IL_TOP_UP_BEAN.setTU_DOC_DT(tempDate);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_LC_TOPUP_CHRG_AMT(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		Double tempVal = null;

		try {
			if (null != value) {
				tempVal = (Double) value;
				PT_IL_TOP_UP_BEAN.setTU_LC_TOPUP_CHRG_AMT(tempVal);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_LC_TOPUP_NET_AMT(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		Double tempVal = null;
		try {
			if (null != value) {
				tempVal = (Double) value;
				PT_IL_TOP_UP_BEAN.setTU_LC_TOPUP_NET_AMT(tempVal);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateTU_WAK_FEE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		Integer tempVal = null;

		try {
			if (null != value) {
				tempVal = (Integer) value;
				PT_IL_TOP_UP_BEAN.setTU_WAK_FEE(tempVal);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_REMARKS(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		String tempVal = null;

		try {
			if (null != value) {
				tempVal = (String) value;
				PT_IL_TOP_UP_BEAN.setTU_REMARKS(tempVal);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTU_POL_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		/*Modified query by ganesh on 12-01-2018 as suggested by Gaurav*/
			/*Added by Ameen 16-05-2017 as per Gaurav sugg.*/
			//String planTypeQuery = "SELECT PLAN_TYPE FROM PT_IL_POLICY,PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE AND POL_NO = ?";
			String planTypeQuery = "SELECT PLAN_TYPE,PROD_INTR_SAVINGS_YN FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
			ResultSet planTypeRs = null;
			String plan_type = null,prodIntrSavingsYN = null;			
			/*End*/
		try {
			if (null != value) {
				PT_IL_TOP_UP_BEAN.setTU_POL_NO(value.toString());
				/*Added by Ameen 16-05-2017 as per Gaurav sugg.*/
				planTypeRs = new CRUDHandler().executeSelectStatement(planTypeQuery, CommonUtils.getConnection(),
						new Object[]{PT_IL_TOP_UP_BEAN.getTU_POL_NO()});
				if(planTypeRs.next()){
					plan_type = planTypeRs.getString("PLAN_TYPE");
					/*added by ganesh on 12-01-2018 as suggested by Gaurav*/
					prodIntrSavingsYN = planTypeRs.getString("PROD_INTR_SAVINGS_YN");
				}
				System.out.println("plan_type ===========>>>>>" + plan_type);
				if("H".equalsIgnoreCase(plan_type) && "Y".equalsIgnoreCase(prodIntrSavingsYN)){
					COMP_UI_M_BUT_FUND_DTLS.setDisabled(true);
				}
				/*End*/
				helper.when_validate_tu_pol_no(pilt027_composite_action);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePolNo(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		PT_IL_TOP_UP_BEAN.setTU_POL_NO(value);
		try {
			defaultOnPolicy(PT_IL_TOP_UP_BEAN);
			COMP_TU_CUST_CODE.resetValue();
			COMP_TU_CUST_REF_ID1.resetValue();
			COMP_TU_CUST_REF_ID2.resetValue();
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CURR", e.getMessage());
		}
	}

	public void defaultOnPolicy(PT_IL_TOP_UP topUpBean) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String queryPol = " SELECT POL_SYS_ID,POL_CUST_CODE,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2 "
				+ " FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(queryPol, connection,
					new Object[] { topUpBean.getTU_POL_NO() });
			if (resultSet.next()) {
				topUpBean.setTU_POL_SYS_ID(resultSet.getInt(1));
				topUpBean.setTU_CUST_CODE(resultSet.getString(2));
				topUpBean.setTU_CUST_REF_ID1(resultSet.getString(3));
				topUpBean.setTU_CUST_REF_ID2(resultSet.getString(4));
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

	/**
	 * Disables all components in PT_IL_TOP_UP_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_TU_CUST_REF_ID1.setDisabled(disabled);
		COMP_TU_CUST_REF_ID2.setDisabled(disabled);
		COMP_TU_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_TU_CUST_NAME.setDisabled(disabled);
		COMP_TU_POL_NO.setDisabled(disabled);
		COMP_TU_CONTROL_NO.setDisabled(disabled);
		COMP_TU_TXN_CODE.setDisabled(disabled);
		COMP_TU_LC_TOPUP_DEP_AMT.setDisabled(disabled);
		COMP_TU_DOC_NO.setDisabled(disabled);
		COMP_TU_LC_TOPUP_CHRG_AMT.setDisabled(disabled);
		COMP_TU_LC_TOPUP_NET_AMT.setDisabled(disabled);
		COMP_TU_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_TU_BANK_NAME.setDisabled(disabled);
		COMP_TU_REASON_CODE.setDisabled(disabled);
		COMP_UI_M_REASON_DESC.setDisabled(disabled);
		COMP_TU_REMARKS.setDisabled(disabled);
		COMP_TU_WAK_FEE.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_TU_DATE.setDisabled(disabled);
		COMP_TU_DOC_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_CUST_REF_ID1_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_CUST_REF_ID2_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_TU_CUST_CODE_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_TU_POL_NO_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_TU_BANK_CODE_LOV.setDisabled(disabled);
		COMP_UI_M_REMARKS_BUT.setDisabled(disabled);
		COMP_UI_M_BUT_BROKER_DTLS.setDisabled(disabled);
		// COMP_UI_M_BUT_APPROVAL.setDisabled(disabled);
		COMP_UI_M_BUT_REVERSE.setDisabled(disabled);
		// COMP_UI_M_BUT_PYMT_DTLS.setDisabled(disabled);
		// COMP_UI_M_BUT_FUND_DTLS.setDisabled(disabled);

	}

	/**
	 * Instantiates all components in PT_IL_TOP_UP_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_TU_CUST_REF_ID1 = new HtmlInputText();
		COMP_TU_CUST_REF_ID2 = new HtmlInputText();
		COMP_TU_CUST_CODE = new HtmlInputText();
		COMP_UI_M_TU_CUST_NAME = new HtmlInputText();
		COMP_TU_POL_NO = new HtmlInputText();
		COMP_TU_CONTROL_NO = new HtmlInputText();
		COMP_TU_TXN_CODE = new HtmlInputText();
		COMP_TU_LC_TOPUP_DEP_AMT = new HtmlInputText();
		COMP_TU_DOC_NO = new HtmlInputText();
		COMP_TU_LC_TOPUP_CHRG_AMT = new HtmlInputText();
		COMP_TU_LC_TOPUP_NET_AMT = new HtmlInputText();
		COMP_TU_BANK_CODE = new HtmlInputText();
		COMP_UI_M_TU_BANK_NAME = new HtmlInputText();
		COMP_TU_REASON_CODE = new HtmlInputText();
		COMP_UI_M_REASON_DESC = new HtmlInputText();
		COMP_TU_REMARKS = new HtmlInputText();
		COMP_TU_WAK_FEE = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_TU_DATE = new HtmlCalendar();
		COMP_TU_DOC_DT = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_CUST_REF_ID1_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_CUST_REF_ID2_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_TU_CUST_CODE_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_TU_POL_NO_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_TU_BANK_CODE_LOV = new HtmlCommandButton();
		COMP_UI_M_REMARKS_BUT = new HtmlCommandButton();
		COMP_UI_M_BUT_BROKER_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL = new HtmlCommandButton();
		COMP_UI_M_BUT_REVERSE = new HtmlCommandButton();
		COMP_UI_M_BUT_PYMT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_DTLS = new HtmlCommandButton();

	}

	/*
	 * private List<PT_IL_DEPOSIT_CHARGE> fetchList = new ArrayList<PT_IL_DEPOSIT_CHARGE>();
	 * 
	 * public void calcHeaderNetAmount(){ Double netAmt = 0.0; Double
	 * sumLcChargeAmt = 0.0; try{ Double depAmt =
	 * getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT();
	 * pilt027_composite_action.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().populateBlockDEPOSIT_CHARGE();
	 * for(PT_IL_DEPOSIT_CHARGE chargeBean : fetchList){ sumLcChargeAmt =
	 * sumLcChargeAmt +
	 * CommonUtils.nvl(chargeBean.getUI_M_DCHRG_TOTAL_LC_AMT(),0);
	 * System.out.println("lc amount
	 * ----->"+chargeBean.getUI_M_DCHRG_TOTAL_LC_AMT()); } netAmt = depAmt -
	 * sumLcChargeAmt; System.out.println("lc amount ----->"+netAmt);
	 * getPT_IL_TOP_UP_BEAN().setTU_LC_TOPUP_CHRG_AMT(sumLcChargeAmt);
	 * getPT_IL_TOP_UP_BEAN().setTU_LC_TOPUP_NET_AMT(netAmt);
	 * System.out.println("Total Sum ----->"+sumLcChargeAmt); }catch (Exception
	 * e) { e.printStackTrace();
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("CURRENT", e.getMessage()); } }
	 */

	public void approveAction() {
		try {
			helper.WHEN_BUTTON_PRESS_M_BUT_APPRV(pilt027_composite_action);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Approved");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					"Approved");

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("APPROVE_OK", e.getMessage());
		}

	}

	public String paymentDetails() {
		try {
			helper.WHEN_BUTTON_PRESSED_PYMT_DTLS(pilt027_composite_action);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("paymentDetails", e.getMessage());
		}
		return "PILT017_PAYMENTDETAILS";

	}

	
	/*public ArrayList<com.iii.premia.common.bean.LovBean> lovM_UI_M_PS_REASON_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('DUMMY.M_PS_REASON_CODE','IL_REASON');

			suggestionList = listitemutil.P_CALL_LOV("PILT027", "PT_IL_TOP_UP",
					"TU_REASON_CODE", "IL_REASON", null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	*/
	public List<LovBean> lovM_UI_M_PS_REASON_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE " +
					"PC_TYPE LIKE 'IL_REASON' AND ROWNUM <= ? ";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE  " +
					"(PC_CODE LIKE ? ) AND PC_TYPE LIKE 'IL_REASON' AND ROWNUM <= ? " ;
					
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("REASON_CODE", e.getMessage());
		}
		return suggestionList;
	}
	
	
	
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateTU_REASON_CODE(FacesContext context,UIComponent component ,Object value){
		try{
			String reasonCode=(String)value;
			PT_IL_TOP_UP_BEAN.setTU_REASON_CODE(reasonCode);
			helper.whenValidateReasonCode(reasonCode,PT_IL_TOP_UP_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*
	 * if(compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().getUI_M_DCHRG_TOTAL_LC_AMT()!=null) {
	 * pt_il_topup_bean.setTU_LC_TOPUP_CHRG_AMT(CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().getUI_M_DCHRG_TOTAL_LC_AMT(),0));
	 * pt_il_topup_bean.setTU_LC_TOPUP_NET_AMT((CommonUtils.nvl(pt_il_topup_bean.getTU_LC_TOPUP_DEP_AMT(),0))-
	 * (CommonUtils.nvl(pt_il_topup_bean.getTU_LC_TOPUP_CHRG_AMT(),0));
	 * 
	 * if((CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().getUI_M_DCHRG_TOTAL_LC_AMT(),0))>(CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().getTU_LC_TOPUP_DEP_AMT(),0)) { //
	 * DISP_ALERT('Charge Amount Cannot Be Grater Than Deposited amount '); //
	 * RAISE FORM_TRIGGER_FAILURE;
	 *  } else { compositeAction.getpt_il
	 * SET_BLOCK_PROPERTY('PT_IL_PYMT_DTLS',UPDATE_ALLOWED,PROPERTY_FALSE);
	 * SET_BLOCK_PROPERTY('PT_IL_PYMT_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
	 * 
	 * SET_BLOCK_PROPERTY('PT_IL_TOP_UP',UPDATE_ALLOWED,PROPERTY_FALSE); }
	 */

	public HtmlCommandLink getCOMP_UI_M_BUT_DELETE() {
		return COMP_UI_M_BUT_DELETE;
	}

	public void setCOMP_UI_M_BUT_DELETE(HtmlCommandLink comp_ui_m_but_delete) {
		COMP_UI_M_BUT_DELETE = comp_ui_m_but_delete;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_SAVE() {
		return COMP_UI_M_BUT_SAVE;
	}

	public void setCOMP_UI_M_BUT_SAVE(HtmlCommandLink comp_ui_m_but_save) {
		COMP_UI_M_BUT_SAVE = comp_ui_m_but_save;
	}
	
	/*Added by saritha on 29-07-2017 for ssp call id ZBILQC-1733101*/
	 public ArrayList<OracleParameter> INS_TOP_UP_FUNDS(
	          Object P_TU_SYS_ID,Object P_TU_POL_NO) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_TU_SYS_ID);
			parameterList.add(param1);
			
			OracleParameter param2 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TU_POL_NO);
			parameterList.add(param2);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
			       "INS_TOP_UP_FUNDS");
			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
			    throw new ProcedureException(e.getMessage());
			}
			return outputList;
			}
	 
	 		/*End*/
	 
	 /*Added by saritha on 11-08-2017 for ssp call id ZBILQC-1733097*/
	 private HtmlGraphicImage COMP_UI_M_GRAPC_IMG;

		public HtmlGraphicImage getCOMP_UI_M_GRAPC_IMG() {
			return COMP_UI_M_GRAPC_IMG;
		}

		public void setCOMP_UI_M_GRAPC_IMG(HtmlGraphicImage cOMP_UI_M_GRAPC_IMG) {
			COMP_UI_M_GRAPC_IMG = cOMP_UI_M_GRAPC_IMG;
		}
	 
		
		public String topup_sys_param() {
			Connection connection = null;
			ResultSet rs = null;
			String M_PS_VALUE = null;
			String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE ='IL_CALC_MTHD'";
			try {
				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query, connection,
						new Object[] {});
				if(rs.next()) {
					M_PS_VALUE = rs.getString(1);
					System.out.println("M_PS_VALUE  :"+M_PS_VALUE);
				}

				if("1".equalsIgnoreCase(M_PS_VALUE)){
					COMP_TU_WAK_FEE.setRendered(true);
					COMP_TU_WAK_FEE_LABEL.setRendered(true);
					COMP_UI_M_GRAPC_IMG.setRendered(true);
					COMP_TU_REASON_CODE_LABEL.setRendered(true);
					COMP_TU_REASON_CODE.setRendered(true);
					COMP_UI_M_REASON_DESC.setRendered(true);


				}

				if("2".equalsIgnoreCase(M_PS_VALUE)){
					COMP_TU_WAK_FEE.setRendered(false);
					COMP_TU_WAK_FEE_LABEL.setRendered(false);
					COMP_UI_M_GRAPC_IMG.setRendered(false);
					COMP_TU_REASON_CODE_LABEL.setRendered(false);
					COMP_TU_REASON_CODE.setRendered(false);
					COMP_UI_M_REASON_DESC.setRendered(false);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} 
			return M_PS_VALUE;
		}
	/*End */
		
		/*Added by Janani on 12.09.2017 for ZBILQC-1733099*/
		
		public void calP_INS_PYMT_DTLS() {
			PT_IL_TOP_UP bean = getPT_IL_TOP_UP_BEAN();
			
			FacesContext context = FacesContext.getCurrentInstance();
			Map sessionMap = context.getExternalContext().getSessionMap();
			
			ArrayList<OracleParameter> list1;
			try {
				list1 = P_INS_PYMT_DTLS("TP", bean.getTU_SYS_ID(), sessionMap
						.get("GLOBAL.CURR_CODE"), bean.getTU_LC_TOPUP_DEP_AMT(), bean
						.getTU_LC_TOPUP_DEP_AMT(), (String) sessionMap
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
	 
	/*End of ZBILQC-1733099*/
		
		/*Added by ganesh on 12-01-2018 as suggested by Gaurav*/
		private String planType;
		private String prodIntrSavingYN;
		
		
		public String getProdIntrSavingYN() {
			return prodIntrSavingYN;
		}

		public void setProdIntrSavingYN(String prodIntrSavingYN) {
			this.prodIntrSavingYN = prodIntrSavingYN;
		}

		public String getPlanType() {
			return planType;
		}

		public void setPlanType(String planType) {
			this.planType = planType;
		}

	public void fetchPlanProdDetails(String policyNumber) {

		String planTypeQuery = "SELECT PLAN_TYPE,PROD_INTR_SAVINGS_YN FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
		ResultSet rsPlanType = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			rsPlanType = new CRUDHandler().executeSelectStatement(
					planTypeQuery, connection, new Object[] { policyNumber });
			if(rsPlanType.next()){
				setPlanType(rsPlanType.getString(1));
				setProdIntrSavingYN(rsPlanType.getString(2));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				CommonUtils.closeCursor(rsPlanType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
		/*end*/
}
