package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.ConvertFunctions;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.iii.premia.runtime.functions.NumericFunctions;

public class PT_IL_PYMT_DTLS_ACTION1 extends CommonAction {

    Connection connection = null;
    HttpSession session = null;
    CRUDHandler handler = null;
    public UIDataTable uiDataTable;
    private ControlBean controlBean = null;

    private List<SelectItem> PD_PAY_MODE_LIST = new ArrayList<SelectItem>();

    private List<SelectItem> PD_PAID_FOR_LIST = new ArrayList<SelectItem>();
    public COMPOSITE_ACTION_BEAN compositeAction;

    private HtmlOutputLabel COMP_PD_SR_NO_LABEL;
    // private HtmlCommandButton COMP_UI_M_BUT_PREFORMBUTTON;

    private HtmlInputText COMP_PD_SR_NO;

    private HtmlOutputLabel COMP_PD_PAY_MODE_LABEL;

    private HtmlSelectOneMenu COMP_PD_PAY_MODE;

    private HtmlOutputLabel COMP_PD_FC_AMT_LABEL;

    private HtmlInputText COMP_PD_FC_AMT;

    private HtmlOutputLabel COMP_PD_LC_AMT_LABEL;

    private HtmlInputText COMP_PD_LC_AMT;

    private HtmlOutputLabel COMP_PD_PAID_FOR_LABEL;

    private HtmlSelectOneMenu COMP_PD_PAID_FOR;

    private HtmlOutputLabel COMP_PD_CHQ_NO_LABEL;

    private HtmlInputText COMP_PD_CHQ_NO;

    private HtmlOutputLabel COMP_PD_CHQ_DT_LABEL;

    private HtmlCalendar COMP_PD_CHQ_DT;

    private HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL;

    private HtmlInputText COMP_PD_DPD_REF_ID;

    private HtmlOutputLabel COMP_PD_CR_ADVICE_NO_LABEL;

    private HtmlInputText COMP_PD_CR_ADVICE_NO;

    private HtmlOutputLabel COMP_PD_PAYIN_DATE_LABEL;

    private HtmlCalendar COMP_PD_PAYIN_DATE;

    private HtmlOutputLabel COMP_PD_BANK_NAME_LABEL;

    private HtmlInputText COMP_PD_BANK_NAME;

    private HtmlOutputLabel COMP_UI_M_BANK_NAME_DESC_LABEL;

    private HtmlInputText COMP_UI_M_BANK_NAME_DESC;

    private HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL;

    private HtmlInputText COMP_PD_BRANCH_NAME;

    private HtmlOutputLabel COMP_PD_CUST_NAME_LABEL;

    private HtmlInputText COMP_PD_CUST_NAME;

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

    private HtmlCommandButton COMP_UI_M_BUT_PD_CUST_NAME;

    private HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_01;

    private HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_02;

    private HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_03;

    private HtmlCommandButton COMP_UI_M_BUT_PD_REMARKS;

    private HtmlCommandButton COMP_UI_M_BUT_PD_BANK_NAME;

    private HtmlCommandButton COMP_UI_M_BUT_PD_BRANCH_NAME;

    private HtmlCommandButton COMP_UI_M_BUT_MORE;

    private HtmlCommandButton COMP_UI_M_BUT_BANK_LOV;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_DPD_REF_ID;

    // public List list = new ArrayList();

    public ArrayList<PT_IL_PYMT_DTLS> paymentDetailList = new ArrayList<PT_IL_PYMT_DTLS>();

    private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;

    public PT_IL_PYMT_DTLS_ACTION1() {
	PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
	controlBean = (ControlBean) CommonUtils.getControlBean().clone();
	try {
	    connection = CommonUtils.getConnection();
	    List<SelectItem> itemListPayMode = ListItemUtil
		    .getDropDownListValue(connection, "PILP002_APAC",
			    "PT_IL_PYMT_DTLS", "PT_IL_PYMT_DTLS.PD_PAY_MODE",
			    "IL_PAY_MODE");
	    setPD_PAY_MODE_LIST(itemListPayMode);

	    List<SelectItem> itemListPaidFor = ListItemUtil
		    .getDropDownListValue(connection, "PILP002_APAC",
			    "PT_IL_PYMT_DTLS", "PT_IL_PYMT_DTLS.PD_PAID_FOR",
			    "IL_RCT_TYP");
	    setPD_PAID_FOR_LIST(itemListPaidFor);
	    preForm();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public HtmlOutputLabel getCOMP_PD_SR_NO_LABEL() {
	return COMP_PD_SR_NO_LABEL;
    }

    public HtmlInputText getCOMP_PD_SR_NO() {
	return COMP_PD_SR_NO;
    }

    public void setCOMP_PD_SR_NO_LABEL(HtmlOutputLabel COMP_PD_SR_NO_LABEL) {
	this.COMP_PD_SR_NO_LABEL = COMP_PD_SR_NO_LABEL;
    }

    public void setCOMP_PD_SR_NO(HtmlInputText COMP_PD_SR_NO) {
	this.COMP_PD_SR_NO = COMP_PD_SR_NO;
    }

    public HtmlOutputLabel getCOMP_PD_PAY_MODE_LABEL() {
	return COMP_PD_PAY_MODE_LABEL;
    }

    public void setCOMP_PD_PAY_MODE_LABEL(HtmlOutputLabel COMP_PD_PAY_MODE_LABEL) {
	this.COMP_PD_PAY_MODE_LABEL = COMP_PD_PAY_MODE_LABEL;
    }

    public HtmlOutputLabel getCOMP_PD_FC_AMT_LABEL() {
	return COMP_PD_FC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_PD_FC_AMT() {
	return COMP_PD_FC_AMT;
    }

    public void setCOMP_PD_FC_AMT_LABEL(HtmlOutputLabel COMP_PD_FC_AMT_LABEL) {
	this.COMP_PD_FC_AMT_LABEL = COMP_PD_FC_AMT_LABEL;
    }

    public void setCOMP_PD_FC_AMT(HtmlInputText COMP_PD_FC_AMT) {
	this.COMP_PD_FC_AMT = COMP_PD_FC_AMT;
    }

    public HtmlOutputLabel getCOMP_PD_LC_AMT_LABEL() {
	return COMP_PD_LC_AMT_LABEL;
    }

    public HtmlInputText getCOMP_PD_LC_AMT() {
	return COMP_PD_LC_AMT;
    }

    public void setCOMP_PD_LC_AMT_LABEL(HtmlOutputLabel COMP_PD_LC_AMT_LABEL) {
	this.COMP_PD_LC_AMT_LABEL = COMP_PD_LC_AMT_LABEL;
    }

    public void setCOMP_PD_LC_AMT(HtmlInputText COMP_PD_LC_AMT) {
	this.COMP_PD_LC_AMT = COMP_PD_LC_AMT;
    }

    public HtmlOutputLabel getCOMP_PD_PAID_FOR_LABEL() {
	return COMP_PD_PAID_FOR_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_PD_PAY_MODE() {
	return COMP_PD_PAY_MODE;
    }

    public void setCOMP_PD_PAY_MODE(HtmlSelectOneMenu comp_pd_pay_mode) {
	COMP_PD_PAY_MODE = comp_pd_pay_mode;
    }

    public HtmlSelectOneMenu getCOMP_PD_PAID_FOR() {
	return COMP_PD_PAID_FOR;
    }

    public void setCOMP_PD_PAID_FOR(HtmlSelectOneMenu comp_pd_paid_for) {
	COMP_PD_PAID_FOR = comp_pd_paid_for;
    }

    public void setCOMP_PD_PAID_FOR_LABEL(HtmlOutputLabel COMP_PD_PAID_FOR_LABEL) {
	this.COMP_PD_PAID_FOR_LABEL = COMP_PD_PAID_FOR_LABEL;
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

    public HtmlCalendar getCOMP_PD_CHQ_DT() {
	return COMP_PD_CHQ_DT;
    }

    public void setCOMP_PD_CHQ_DT_LABEL(HtmlOutputLabel COMP_PD_CHQ_DT_LABEL) {
	this.COMP_PD_CHQ_DT_LABEL = COMP_PD_CHQ_DT_LABEL;
    }

    public void setCOMP_PD_CHQ_DT(HtmlCalendar COMP_PD_CHQ_DT) {
	this.COMP_PD_CHQ_DT = COMP_PD_CHQ_DT;
    }

    public HtmlOutputLabel getCOMP_PD_DPD_REF_ID_LABEL() {
	return COMP_PD_DPD_REF_ID_LABEL;
    }

    public HtmlInputText getCOMP_PD_DPD_REF_ID() {
	return COMP_PD_DPD_REF_ID;
    }

    public void setCOMP_PD_DPD_REF_ID_LABEL(
	    HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL) {
	this.COMP_PD_DPD_REF_ID_LABEL = COMP_PD_DPD_REF_ID_LABEL;
    }

    public void setCOMP_PD_DPD_REF_ID(HtmlInputText COMP_PD_DPD_REF_ID) {
	this.COMP_PD_DPD_REF_ID = COMP_PD_DPD_REF_ID;
    }

    public HtmlOutputLabel getCOMP_PD_CR_ADVICE_NO_LABEL() {
	return COMP_PD_CR_ADVICE_NO_LABEL;
    }

    public HtmlInputText getCOMP_PD_CR_ADVICE_NO() {
	return COMP_PD_CR_ADVICE_NO;
    }

    public void setCOMP_PD_CR_ADVICE_NO_LABEL(
	    HtmlOutputLabel COMP_PD_CR_ADVICE_NO_LABEL) {
	this.COMP_PD_CR_ADVICE_NO_LABEL = COMP_PD_CR_ADVICE_NO_LABEL;
    }

    public void setCOMP_PD_CR_ADVICE_NO(HtmlInputText COMP_PD_CR_ADVICE_NO) {
	this.COMP_PD_CR_ADVICE_NO = COMP_PD_CR_ADVICE_NO;
    }

    public HtmlOutputLabel getCOMP_PD_PAYIN_DATE_LABEL() {
	return COMP_PD_PAYIN_DATE_LABEL;
    }

    public HtmlCalendar getCOMP_PD_PAYIN_DATE() {
	return COMP_PD_PAYIN_DATE;
    }

    public void setCOMP_PD_PAYIN_DATE_LABEL(
	    HtmlOutputLabel COMP_PD_PAYIN_DATE_LABEL) {
	this.COMP_PD_PAYIN_DATE_LABEL = COMP_PD_PAYIN_DATE_LABEL;
    }

    public void setCOMP_PD_PAYIN_DATE(HtmlCalendar COMP_PD_PAYIN_DATE) {
	this.COMP_PD_PAYIN_DATE = COMP_PD_PAYIN_DATE;
    }

    public HtmlOutputLabel getCOMP_PD_BANK_NAME_LABEL() {
	return COMP_PD_BANK_NAME_LABEL;
    }

    public HtmlInputText getCOMP_PD_BANK_NAME() {
	return COMP_PD_BANK_NAME;
    }

    public void setCOMP_PD_BANK_NAME_LABEL(
	    HtmlOutputLabel COMP_PD_BANK_NAME_LABEL) {
	this.COMP_PD_BANK_NAME_LABEL = COMP_PD_BANK_NAME_LABEL;
    }

    public void setCOMP_PD_BANK_NAME(HtmlInputText COMP_PD_BANK_NAME) {
	this.COMP_PD_BANK_NAME = COMP_PD_BANK_NAME;
    }

    public HtmlInputText getCOMP_UI_M_BANK_NAME_DESC() {
	return COMP_UI_M_BANK_NAME_DESC;
    }

    public void setCOMP_UI_M_BANK_NAME_DESC(
	    HtmlInputText COMP_UI_M_BANK_NAME_DESC) {
	this.COMP_UI_M_BANK_NAME_DESC = COMP_UI_M_BANK_NAME_DESC;
    }

    public HtmlOutputLabel getCOMP_PD_BRANCH_NAME_LABEL() {
	return COMP_PD_BRANCH_NAME_LABEL;
    }

    public HtmlInputText getCOMP_PD_BRANCH_NAME() {
	return COMP_PD_BRANCH_NAME;
    }

    public void setCOMP_PD_BRANCH_NAME_LABEL(
	    HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL) {
	this.COMP_PD_BRANCH_NAME_LABEL = COMP_PD_BRANCH_NAME_LABEL;
    }

    public void setCOMP_PD_BRANCH_NAME(HtmlInputText COMP_PD_BRANCH_NAME) {
	this.COMP_PD_BRANCH_NAME = COMP_PD_BRANCH_NAME;
    }

    public HtmlOutputLabel getCOMP_PD_CUST_NAME_LABEL() {
	return COMP_PD_CUST_NAME_LABEL;
    }

    public HtmlInputText getCOMP_PD_CUST_NAME() {
	return COMP_PD_CUST_NAME;
    }

    public void setCOMP_PD_CUST_NAME_LABEL(
	    HtmlOutputLabel COMP_PD_CUST_NAME_LABEL) {
	this.COMP_PD_CUST_NAME_LABEL = COMP_PD_CUST_NAME_LABEL;
    }

    public void setCOMP_PD_CUST_NAME(HtmlInputText COMP_PD_CUST_NAME) {
	this.COMP_PD_CUST_NAME = COMP_PD_CUST_NAME;
    }

    public HtmlOutputLabel getCOMP_PD_ADDR_01_LABEL() {
	return COMP_PD_ADDR_01_LABEL;
    }

    public HtmlInputText getCOMP_PD_ADDR_01() {
	return COMP_PD_ADDR_01;
    }

    public void setCOMP_PD_ADDR_01_LABEL(HtmlOutputLabel COMP_PD_ADDR_01_LABEL) {
	this.COMP_PD_ADDR_01_LABEL = COMP_PD_ADDR_01_LABEL;
    }

    public void setCOMP_PD_ADDR_01(HtmlInputText COMP_PD_ADDR_01) {
	this.COMP_PD_ADDR_01 = COMP_PD_ADDR_01;
    }

    public HtmlOutputLabel getCOMP_PD_ADDR_02_LABEL() {
	return COMP_PD_ADDR_02_LABEL;
    }

    public HtmlInputText getCOMP_PD_ADDR_02() {
	return COMP_PD_ADDR_02;
    }

    public void setCOMP_PD_ADDR_02_LABEL(HtmlOutputLabel COMP_PD_ADDR_02_LABEL) {
	this.COMP_PD_ADDR_02_LABEL = COMP_PD_ADDR_02_LABEL;
    }

    public void setCOMP_PD_ADDR_02(HtmlInputText COMP_PD_ADDR_02) {
	this.COMP_PD_ADDR_02 = COMP_PD_ADDR_02;
    }

    public HtmlOutputLabel getCOMP_PD_ADDR_03_LABEL() {
	return COMP_PD_ADDR_03_LABEL;
    }

    public HtmlInputText getCOMP_PD_ADDR_03() {
	return COMP_PD_ADDR_03;
    }

    public void setCOMP_PD_ADDR_03_LABEL(HtmlOutputLabel COMP_PD_ADDR_03_LABEL) {
	this.COMP_PD_ADDR_03_LABEL = COMP_PD_ADDR_03_LABEL;
    }

    public void setCOMP_PD_ADDR_03(HtmlInputText COMP_PD_ADDR_03) {
	this.COMP_PD_ADDR_03 = COMP_PD_ADDR_03;
    }

    public HtmlOutputLabel getCOMP_PD_REMARKS_LABEL() {
	return COMP_PD_REMARKS_LABEL;
    }

    public HtmlInputText getCOMP_PD_REMARKS() {
	return COMP_PD_REMARKS;
    }

    public void setCOMP_PD_REMARKS_LABEL(HtmlOutputLabel COMP_PD_REMARKS_LABEL) {
	this.COMP_PD_REMARKS_LABEL = COMP_PD_REMARKS_LABEL;
    }

    public void setCOMP_PD_REMARKS(HtmlInputText COMP_PD_REMARKS) {
	this.COMP_PD_REMARKS = COMP_PD_REMARKS;
    }

    public HtmlOutputLabel getCOMP_PD_CURR_CODE_LABEL() {
	return COMP_PD_CURR_CODE_LABEL;
    }

    public HtmlInputText getCOMP_PD_CURR_CODE() {
	return COMP_PD_CURR_CODE;
    }

    public void setCOMP_PD_CURR_CODE_LABEL(
	    HtmlOutputLabel COMP_PD_CURR_CODE_LABEL) {
	this.COMP_PD_CURR_CODE_LABEL = COMP_PD_CURR_CODE_LABEL;
    }

    public void setCOMP_PD_CURR_CODE(HtmlInputText COMP_PD_CURR_CODE) {
	this.COMP_PD_CURR_CODE = COMP_PD_CURR_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PD_CURR_CODE_DESC_LABEL() {
	return COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PD_CURR_CODE_DESC() {
	return COMP_UI_M_PD_CURR_CODE_DESC;
    }

    public void setCOMP_UI_M_PD_CURR_CODE_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL) {
	this.COMP_UI_M_PD_CURR_CODE_DESC_LABEL = COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
    }

    public void setCOMP_UI_M_PD_CURR_CODE_DESC(
	    HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC) {
	this.COMP_UI_M_PD_CURR_CODE_DESC = COMP_UI_M_PD_CURR_CODE_DESC;
    }

    public HtmlOutputLabel getCOMP_PD_LC_CHARGE_LABEL() {
	return COMP_PD_LC_CHARGE_LABEL;
    }

    public HtmlInputText getCOMP_PD_LC_CHARGE() {
	return COMP_PD_LC_CHARGE;
    }

    public void setCOMP_PD_LC_CHARGE_LABEL(
	    HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL) {
	this.COMP_PD_LC_CHARGE_LABEL = COMP_PD_LC_CHARGE_LABEL;
    }

    public void setCOMP_PD_LC_CHARGE(HtmlInputText COMP_PD_LC_CHARGE) {
	this.COMP_PD_LC_CHARGE = COMP_PD_LC_CHARGE;
    }

    public HtmlOutputLabel getCOMP_PD_FC_CHARGE_LABEL() {
	return COMP_PD_FC_CHARGE_LABEL;
    }

    public HtmlInputText getCOMP_PD_FC_CHARGE() {
	return COMP_PD_FC_CHARGE;
    }

    public void setCOMP_PD_FC_CHARGE_LABEL(
	    HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL) {
	this.COMP_PD_FC_CHARGE_LABEL = COMP_PD_FC_CHARGE_LABEL;
    }

    public void setCOMP_PD_FC_CHARGE(HtmlInputText COMP_PD_FC_CHARGE) {
	this.COMP_PD_FC_CHARGE = COMP_PD_FC_CHARGE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_CUST_NAME() {
	return COMP_UI_M_BUT_PD_CUST_NAME;
    }

    public void setCOMP_UI_M_BUT_PD_CUST_NAME(
	    HtmlCommandButton COMP_UI_M_BUT_PD_CUST_NAME) {
	this.COMP_UI_M_BUT_PD_CUST_NAME = COMP_UI_M_BUT_PD_CUST_NAME;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_ADDR_01() {
	return COMP_UI_M_BUT_PD_ADDR_01;
    }

    public void setCOMP_UI_M_BUT_PD_ADDR_01(
	    HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_01) {
	this.COMP_UI_M_BUT_PD_ADDR_01 = COMP_UI_M_BUT_PD_ADDR_01;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_ADDR_02() {
	return COMP_UI_M_BUT_PD_ADDR_02;
    }

    public void setCOMP_UI_M_BUT_PD_ADDR_02(
	    HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_02) {
	this.COMP_UI_M_BUT_PD_ADDR_02 = COMP_UI_M_BUT_PD_ADDR_02;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_ADDR_03() {
	return COMP_UI_M_BUT_PD_ADDR_03;
    }

    public void setCOMP_UI_M_BUT_PD_ADDR_03(
	    HtmlCommandButton COMP_UI_M_BUT_PD_ADDR_03) {
	this.COMP_UI_M_BUT_PD_ADDR_03 = COMP_UI_M_BUT_PD_ADDR_03;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_REMARKS() {
	return COMP_UI_M_BUT_PD_REMARKS;
    }

    public void setCOMP_UI_M_BUT_PD_REMARKS(
	    HtmlCommandButton COMP_UI_M_BUT_PD_REMARKS) {
	this.COMP_UI_M_BUT_PD_REMARKS = COMP_UI_M_BUT_PD_REMARKS;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_BANK_NAME() {
	return COMP_UI_M_BUT_PD_BANK_NAME;
    }

    public void setCOMP_UI_M_BUT_PD_BANK_NAME(
	    HtmlCommandButton COMP_UI_M_BUT_PD_BANK_NAME) {
	this.COMP_UI_M_BUT_PD_BANK_NAME = COMP_UI_M_BUT_PD_BANK_NAME;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PD_BRANCH_NAME() {
	return COMP_UI_M_BUT_PD_BRANCH_NAME;
    }

    public void setCOMP_UI_M_BUT_PD_BRANCH_NAME(
	    HtmlCommandButton COMP_UI_M_BUT_PD_BRANCH_NAME) {
	this.COMP_UI_M_BUT_PD_BRANCH_NAME = COMP_UI_M_BUT_PD_BRANCH_NAME;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_MORE() {
	return COMP_UI_M_BUT_MORE;
    }

    public void setCOMP_UI_M_BUT_MORE(HtmlCommandButton COMP_UI_M_BUT_MORE) {
	this.COMP_UI_M_BUT_MORE = COMP_UI_M_BUT_MORE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_BANK_LOV() {
	return COMP_UI_M_BUT_BANK_LOV;
    }

    public void setCOMP_UI_M_BUT_BANK_LOV(
	    HtmlCommandButton COMP_UI_M_BUT_BANK_LOV) {
	this.COMP_UI_M_BUT_BANK_LOV = COMP_UI_M_BUT_BANK_LOV;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DPD_REF_ID() {
	return COMP_UI_M_BUT_LOV_DPD_REF_ID;
    }

    public void setCOMP_UI_M_BUT_LOV_DPD_REF_ID(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_DPD_REF_ID) {
	this.COMP_UI_M_BUT_LOV_DPD_REF_ID = COMP_UI_M_BUT_LOV_DPD_REF_ID;
    }

    public PT_IL_PYMT_DTLS getPT_IL_PYMT_DTLS_BEAN() {
	return PT_IL_PYMT_DTLS_BEAN;
    }

    public void setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
	this.PT_IL_PYMT_DTLS_BEAN = PT_IL_PYMT_DTLS_BEAN;
    }

    public String preForm() {

	System.out.println("PreForm called..........");
	try {

	    String pol_sys_id = CommonUtils
		    .getGlobalVariable("GLOBAL.M_POL_SYS_ID");
	    System.out.println("pol_sys_id: " + pol_sys_id);
	    connection = CommonUtils.getConnection();
	    ArrayList<PT_IL_PYMT_DTLS> paymentDtlList = fetchPaymentDetails();
	    // PT_IL_PYMT_DTLS_ACTION paymentDtlsAction = new
	    // PT_IL_PYMT_DTLS_ACTION();
	    setPaymentDetailList(paymentDtlList);
	    /*
	     * HtmlCommandButton commandButton =
	     * getCOMP_UI_M_BUT_PREFORMBUTTON();
	     * commandButton.setDisabled(true);
	     * paymentDtlsAction.setCOMP_UI_M_BUT_PREFORMBUTTON(commandButton);
	     */
	    // session.setAttribute("PILP002_APAC_PT_IL_PYMT_DTLS_ACTION",
	    // paymentDtlsAction);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public ArrayList<PT_IL_PYMT_DTLS> fetchPaymentDetails() {
	String sisId = CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
	ResultSet rst = null;

	try {
	    connection = CommonUtils.getConnection();

	    handler = new CRUDHandler();

	    ArrayList<PT_IL_PYMT_DTLS> paymentDetailList = null;
	    PT_IL_PYMT_DTLS valueBean = null;
	    String query = PILP002_APAC_SQLConstants.pymtDetailsQuery;
	    Object[] values = { sisId };
	    rst = handler.executeSelectStatement(query, connection, values);
	    paymentDetailList = new ArrayList<PT_IL_PYMT_DTLS>();
	    while (rst.next()) {
		valueBean = new PT_IL_PYMT_DTLS();
		/*
		 * double srno = rst.getDouble(1); System.out.println("srno: "+
		 * srno); String paymode = rst.getString(2);
		 * System.out.println("paymode :"+ paymode); String refId =
		 * rst.getString(3); System.out.println("refId: "+ refId);
		 */

		valueBean.setPD_SR_NO(rst.getInt("PD_SR_NO"));
		valueBean.setPD_PAY_MODE(rst.getString("PD_PAY_MODE"));
		valueBean.setPD_DPD_REF_ID(rst.getString("PD_DPD_REF_ID"));
		valueBean.setPD_FC_AMT(rst.getDouble("PD_FC_AMT"));
		valueBean.setPD_LC_AMT(rst.getDouble("PD_LC_AMT"));
		valueBean.setPD_PAID_FOR(rst.getString("PD_PAID_FOR"));
		valueBean.setPD_CHQ_NO(rst.getString("PD_CHQ_NO"));
		valueBean.setPD_CHQ_DT(rst.getDate("PD_CHQ_DT"));
		valueBean.setPD_CR_ADVICE_NO(rst.getString("PD_CR_ADVICE_NO"));
		valueBean.setPD_PAYIN_DATE(rst.getDate("PD_PAYIN_DATE"));
		valueBean.setPD_BANK_NAME(rst.getString("PD_BANK_NAME"));
		valueBean.setPD_BRANCH_NAME(rst.getString("PD_BRANCH_NAME"));
		valueBean.setPD_CUST_NAME(rst.getString("PD_CUST_NAME"));
		valueBean.setPD_ADDR_01(rst.getString("PD_ADDR_01"));
		valueBean.setPD_ADDR_02(rst.getString("PD_ADDR_02"));
		valueBean.setPD_ADDR_03(rst.getString("PD_ADDR_03"));
		valueBean.setPD_REMARKS(rst.getString("PD_REMARKS"));
		valueBean.setPD_CURR_CODE(rst.getString("PD_CURR_CODE"));
		valueBean.setPD_LC_CHARGE(rst.getDouble("PD_LC_CHARGE"));
		valueBean.setPD_FC_CHARGE(rst.getDouble("PD_FC_CHARGE"));

		paymentDetailList.add(valueBean);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (Exception e1) {
	    e1.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(rst);
	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	}
	return paymentDetailList;
    }

    public UIDataTable getUiDataTable() {
	return uiDataTable;
    }

    public void setUiDataTable(UIDataTable uiDataTable) {
	this.uiDataTable = uiDataTable;
    }

    /*
     * Code for PRE_UPDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pre_update() {
	try {
	    L_DUP_SERIAL_NO();
	    PT_IL_PYMT_DTLS_BEAN.setPD_UPD_DT(new java.sql.Date(Calendar
		    .getInstance().getTimeInMillis()));
	    PT_IL_PYMT_DTLS_BEAN.setPD_UPD_UID(getControlBean().getM_USER_ID());
	    /*
	     * :PT_IL_PYMT_DTLS.PD_UPD_DT=new
	     * java.sql.Date(Calendar.getInstance().getTimeInMillis());
	     * :PT_IL_PYMT_DTLS.PD_UPD_UID=:CTRL.M_USER_ID;
	     */
	    if ("BC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_OUR_BANK_CODE());
		PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_CHQ_NO());
	    }
	    if ("PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_OUR_BANK_CODE_1());
		PT_IL_PYMT_DTLS_BEAN.setPD_REM_SLIP_GEN_YN(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_REM_SLIP_GEN_YN());
	    }
	    if ("EF".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_OUR_BANK_CODE_2());
		PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_DATE_OF_CREDIT());
	    }
	    if ("AD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_BANK_REF_NO());
		PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_DATE_OF_CREDIT_1());
	    }
	    if ("SC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_CC_TYPE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_PD_CC_TYPE());
		PT_IL_PYMT_DTLS_BEAN.setPD_CC_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_PD_CC_NO());
		PT_IL_PYMT_DTLS_BEAN.setPD_CC_APP_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_PD_CC_APP_CODE());
		PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_BANK_REF_NO_1());
		PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_DATE_OF_CREDIT_2());
	    }
	    if ("A".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_BANK_REF_NO_2());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /*
     * Procedure L_DUP_SERIAL_NO
     */

    public void L_DUP_SERIAL_NO() {
	handler = new CRUDHandler();
	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C2 = null;
	String RECORD_STATUS = "INSERT";
	try {
	    connection = CommonUtils.getConnection();
	    // if(:SYSTEM.RECORD_STATUS=="INSERT")
	    if (RECORD_STATUS == "INSERT") {
		String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.L_DUP_SERIAL_NO_SQL_C1;
		Object[] objectsql_C1 = { PT_IL_PYMT_DTLS_BEAN.getPD_SR_NO(),
			PT_IL_PYMT_DTLS_BEAN.getPD_TXN_TYPE(),
			PT_IL_PYMT_DTLS_BEAN.getPD_TXN_SYS_ID() };
		resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
			connection, objectsql_C1);

		while ((resultSetsql_C1.next())) {
		    // C1 IREC=new C1();
		    if (resultSetsql_C1.next()) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91000"));
		    }
		}
	    }
	    // else if(:SYSTEM.RECORD_STATUS=="CHANGED")
	    else if (RECORD_STATUS == "CHANGED") {
		String sql_C2 = PT_IL_PYMT_DTLS_SQL_CONSTS.L_DUP_SERIAL_NO_SQL_C2;
		Object[] objectsql_C2 = { PT_IL_PYMT_DTLS_BEAN.getPD_SR_NO(),
			PT_IL_PYMT_DTLS_BEAN.getPD_TXN_TYPE(),
			PT_IL_PYMT_DTLS_BEAN.getPD_TXN_SYS_ID(),
			PT_IL_PYMT_DTLS_BEAN.getROWID() };
		resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
			connection, objectsql_C2);

		while ((resultSetsql_C2.next())) {
		    // C2 UREC=new C2();
		    if (!resultSetsql_C2.isLast()) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91000"));
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(resultSetsql_C1);
		CommonUtils.closeCursor(resultSetsql_C2);
	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	}
    }

    /*
     * Code For PRE_INSERT
     */

    public void pilp002_apac_pt_il_pymt_dtls_pre_insert() {
	ResultSet resultSetsql_C1 = null;
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    L_DUP_SERIAL_NO();
	    String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.PT_IL_PYMT_DTLS_PRE_INSERT_SQLC1;
	    Object[] objectsql_C1 = {};
	    // TODO to be checked where this resultset is getting used
	    // resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
	    // connection, objectsql_C1);

	    PT_IL_PYMT_DTLS_BEAN.setPD_CR_DT(new java.sql.Date(Calendar
		    .getInstance().getTimeInMillis()));
	    PT_IL_PYMT_DTLS_BEAN.setPD_CR_UID(getControlBean().getM_USER_ID());
	    if ("BC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_OUR_BANK_CODE());
		PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_CHQ_NO());
	    }
	    if ("PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_OUR_BANK_CODE_1());
		PT_IL_PYMT_DTLS_BEAN.setPD_REM_SLIP_GEN_YN(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_REM_SLIP_GEN_YN());
	    }
	    if ("EF".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_OUR_BANK_CODE_2());
		PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_DATE_OF_CREDIT());
	    }
	    if ("AD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_BANK_REF_NO());
		PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_DATE_OF_CREDIT_1());
	    }
	    if ("SC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_CC_TYPE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_PD_CC_TYPE());
		PT_IL_PYMT_DTLS_BEAN.setPD_CC_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_PD_CC_NO());
		PT_IL_PYMT_DTLS_BEAN.setPD_CC_APP_CODE(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_PD_CC_APP_CODE());
		PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_BANK_REF_NO_1());
		PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_DATE_OF_CREDIT_2());
	    }
	    if ("A".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN
			.getUI_M_BANK_REF_NO_2());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(resultSetsql_C1);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    /*
     * POST_QUERY Code
     */

    public void pilp002_apac_pt_il_pymt_dtls_post_query(){
	    
	    String C1 ="	SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')  FROM MENU_USER" +
		" WHERE USER_ID = ? ";
String queryEncrypt = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";
Connection connection = null;
ResultSet  resultSet = null;
String M_CREDIT_CARD_UPD_YN = null;
Object[] values = {};

		try
		{
			if(PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE() != null)
			{
				ArrayList<String> list = P_VAL_CURR.callP_VAL_CURR(connection, PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE(),"N","W","");
				if(list!=null & list.size()> 0){
					PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CURR_CODE_DESC(list.get(0));
					// COMP_UI_M_PD_CURR_CODE_DESC.setSubmittedValue(list.get(0));
				}
				// P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);
			}
			if("D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN.getPD_LC_AMT());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
			}
			else
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN.getPD_LC_AMT());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
			}
			if("I".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) || "CC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())|| "C1".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())|| "C2".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) || "C3".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())|| "C4".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) || "C5".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) || "C6".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
			    PT_IL_PYMT_DTLS_BEAN.setUI_M_EXP_DT( PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT());
				/*
				 * PT_IL_PYMT_DTLS_BEAN.setUI_M_EXP_DT(ConvertFunctions.to_char(
				 * PT_IL_PYMT_DTLS_BEAN.getPD_CC_EXP_DT()
				 * ,"MM/YY")); //chk
				 * PT_IL_PYMT_DTLS_BEAN.setUI_M_EXP_DT(StringFunctions.substr(PT_IL_PYMT_DTLS_BEAN.getUI_M_EXP_DT(),1,2)+
				 * CommonUtils.SUBSTR(
				 * PT_IL_PYMT_DTLS_BEAN.getUI_M_EXP_DT(),4,5));
				 */
			}
			if("BC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_OUR_BANK_CODE(PT_IL_PYMT_DTLS_BEAN.getPD_OUR_BANK_CODE());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_CHQ_NO(PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_NO());
			}
			if("PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_OUR_BANK_CODE_1(PT_IL_PYMT_DTLS_BEAN.getPD_OUR_BANK_CODE());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_REM_SLIP_GEN_YN(PT_IL_PYMT_DTLS_BEAN.getPD_REM_SLIP_GEN_YN());
			}
			if("EF".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_OUR_BANK_CODE_2(PT_IL_PYMT_DTLS_BEAN.getPD_OUR_BANK_CODE());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_DATE_OF_CREDIT(PT_IL_PYMT_DTLS_BEAN.getPD_DATE_OF_CREDIT());
			}
			if("AD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_REF_NO(PT_IL_PYMT_DTLS_BEAN.getPD_BANK_REF_NO());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_DATE_OF_CREDIT_1(PT_IL_PYMT_DTLS_BEAN.getPD_DATE_OF_CREDIT());
			}
			if("SC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_TYPE(PT_IL_PYMT_DTLS_BEAN.getPD_CC_TYPE());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_APP_CODE(PT_IL_PYMT_DTLS_BEAN.getPD_CC_APP_CODE());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_REF_NO_1(PT_IL_PYMT_DTLS_BEAN.getPD_BANK_REF_NO());
				PT_IL_PYMT_DTLS_BEAN.setUI_M_DATE_OF_CREDIT_2(PT_IL_PYMT_DTLS_BEAN.getPD_DATE_OF_CREDIT());
			}
		
		  values = new Object[] { CommonUtils.getControlBean().getM_USER_ID()};
		  resultSet = new CRUDHandler().executeSelectStatement(C1,
				connection, values);
		  while (resultSet.next()) {
		      M_CREDIT_CARD_UPD_YN =  resultSet.getString(1);
     			}    
		       
		   if( PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO() !=null ){  
		       
		      if("Y".equals( M_CREDIT_CARD_UPD_YN) && 
			       PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO() !=null ){
		       values = new Object[] {
		        	   "X",
		        	   PT_IL_PYMT_DTLS_BEAN.getPD_SYS_ID(), "D",
		        	   PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() };
			 resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
					connection, values);
       			while (resultSet.next()) {
       			    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO( resultSet.getString(1));
       			}    
		        // :PT_IL_PYMT_DTLS.M_PD_CC_NO:=
			// F_CC_ENCRYPT('X',:PT_IL_PYMT_DTLS.PD_SYS_ID,'D',:PT_IL_PYMT_DTLS.PD_PAY_MODE);
		              
		      }else if("N".equals( M_CREDIT_CARD_UPD_YN ) &&
       				PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO() !=null ){
		       values = new Object[] {
			       "X",
			       PT_IL_PYMT_DTLS_BEAN.getPD_SYS_ID(), "D",
			       PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() };
			 resultSet = new CRUDHandler().executeSelectStatement(queryEncrypt,
					connection, values);
       			while (resultSet.next()) {
       			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(resultSet.getString(1));
       			}    
       			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO(CommonUtils.lpad(CommonUtils.SUBSTR(PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_CC_NO(),13,16),16,"X") );
		       	//   :PT_IL_PYMT_DTLS.M_PD_CC_NO:=  F_CC_ENCRYPT('X',:PT_IL_PYMT_DTLS.PD_SYS_ID,'D',:PT_IL_PYMT_DTLS.PD_PAY_MODE); 
		       	//    :PT_IL_PYMT_DTLS.M_PD_CC_NO:= LPAD(SUBSTR(:PT_IL_PYMT_DTLS.M_PD_CC_NO,13,16),16,'X');
		           
       			}
		      }
		  
			if("I".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
				PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CC_NO_1(PT_IL_PYMT_DTLS_BEAN.getPD_CC_NO());
			}
			if("A".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()))
			{
			    PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_REF_NO_2(PT_IL_PYMT_DTLS_BEAN.getPD_BANK_REF_NO());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    /*
     * WHEN-NEW-RECORD-INSTANCE Code
     */

    public void pilp002_apac_pt_il_pymt_dtls_when_new_record_instance() {
	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C2 = null;

	String M_DUMMY = null;
	String M_PS_VALUE = null;
	String M_CODE_DESC = null;
	String M_BCSH_CUST_SHARE_PERC_1 = null;
	String RECORD_STATUS = "QUERY";

	try {

	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();

	    if (RECORD_STATUS != "QUERY") {
		// if(:SYSTEM.TRIGGER_RECORD>1)
		// {
		// :SYSTEM.MESSAGE_LEVEL=10;
		getControlBean().setM_COMM_DEL("P");
		// :CTRL.M_COMM_DEL="P";
		// POST.POST();
		getControlBean().setM_COMM_DEL(null);
		// :SYSTEM.MESSAGE_LEVEL=0;
		ArrayList<String> list = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
			"IL_MUL_PAY", "IL_MUL_PAY", "E");
		if (list != null && list.size() > 0) {
		    M_CODE_DESC = list.get(0);
		    M_PS_VALUE = list.get(1);

		}

		if (M_PS_VALUE == "2") {
		    String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.WHEN_NEW_RECORD_INSTANCE_SQLC1;
		    Object[] objectsql_C1 = { PT_IL_PYMT_DTLS_BEAN
			    .getPD_TXN_SYS_ID() };
		    resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
			    connection, objectsql_C1);

		    if (resultSetsql_C1.next()) {
			M_DUMMY = resultSetsql_C1.getString(1);
		    }
		    if (M_DUMMY != PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) {
			PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE(M_DUMMY);
		    }
		}
		// }
	    }
	    String sql_C2 = PT_IL_PYMT_DTLS_SQL_CONSTS.WHEN_NEW_RECORD_INSTANCE_SQLC2;
	    Object[] objectsql_C2 = { PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() };
	    resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
		    connection, objectsql_C2);
	    if (resultSetsql_C2.next()) {
		M_BCSH_CUST_SHARE_PERC_1 = resultSetsql_C2.getString(1);
	    }

	    String condition = " P C D L H I CC E SD TT BC PM EF AD SC A C1 C2 C3 C4 C5 C6";
	    String payerMode = PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE();
	    if (condition.contains(" " + payerMode + " ")) {
		COMP_PD_DPD_REF_ID.setDisabled(true);
		COMP_PD_DPD_REF_ID.setRequired(false);

	    } else {
		COMP_PD_DPD_REF_ID.setDisabled(false);
		COMP_PD_DPD_REF_ID.setRequired(true);

		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",REQUIRED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.M_BUT_LOV_DPD_REF_ID",ENABLED,PROPERTY_TRUE);
		 */
	    }
	    /*
	     * if ("P".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "C".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "L".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "H".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "I".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "CC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "E".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "SD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "TT".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "BC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "EF".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * "AD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())||
	     * "SC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE()) ||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("A")||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("C1") ||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("C2")||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("C3") ||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("C4")||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("C5") ||
	     * PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() == ("C6")) {
	     * 
	     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",ENABLED,PROPERTY_FALSE);
	     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",REQUIRED,PROPERTY_FALSE);
	     * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.M_BUT_LOV_DPD_REF_ID",ENABLED,PROPERTY_FALSE); }
	     */
	    if ("P".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_BANK_NAME.setRequired(false);
		COMP_PD_BRANCH_NAME.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_CR_ADVICE_NO.setDisabled(true);
		COMP_PD_CR_ADVICE_NO.setRequired(false);

	    } else if ("C".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "L".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "H".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "O".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "SD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(false);
		COMP_PD_CHQ_DT.setDisabled(false);
		COMP_PD_BANK_NAME.setDisabled(false);
		COMP_PD_BRANCH_NAME.setDisabled(false);
		COMP_PD_CHQ_NO.setDisabled(false);
		COMP_PD_CHQ_DT.setDisabled(false);
		COMP_PD_BANK_NAME.setDisabled(false);
		COMP_PD_BRANCH_NAME.setDisabled(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_CR_ADVICE_NO.setDisabled(true);
		COMP_PD_CR_ADVICE_NO.setRequired(false);
	    } else if ("I".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "CC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C1".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C2".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C3".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C4".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C5".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "C6".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		/*
		 * if(M_BCSH_CUST_SHARE_PERC_1!=0) {
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_CC_APP_CODE",REQUIRED,PROPERTY_FALSE); }
		 * else {
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_CC_APP_CODE",REQUIRED,PROPERTY_TRUE); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_CR_ADVICE_NO.setDisabled(true);
		COMP_PD_CR_ADVICE_NO.setRequired(false);

	    } else if ("TT".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_BANK_NAME.setRequired(false);
		COMP_PD_BRANCH_NAME.setRequired(false);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_CR_ADVICE_NO.setDisabled(true);
		COMP_PD_CR_ADVICE_NO.setRequired(false);

	    } else if ("BC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);

		COMP_PD_BANK_NAME.setDisabled(false);
		COMP_PD_BRANCH_NAME.setDisabled(false);
		COMP_PD_BANK_NAME.setRequired(true);
		COMP_PD_BRANCH_NAME.setRequired(true);
		COMP_PD_BANK_NAME.setReadonly(false);
		COMP_PD_BRANCH_NAME.setRequired(true);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_CR_ADVICE_NO.setDisabled(true);
		COMP_PD_CR_ADVICE_NO.setRequired(false);

	    } else if ("PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_BANK_NAME.setRequired(false);
		COMP_PD_BRANCH_NAME.setRequired(false);

	    } else if ("EF".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */
		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_BANK_NAME.setRequired(true);
		COMP_PD_BRANCH_NAME.setRequired(true);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_BANK_NAME.setReadonly(false);
		COMP_PD_BRANCH_NAME.setReadonly(false);

	    } else if ("AD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_BANK_NAME.setDisabled(false);
		COMP_PD_BRANCH_NAME.setDisabled(false);
		COMP_PD_BANK_NAME.setRequired(true);
		COMP_PD_BRANCH_NAME.setRequired(false);
		COMP_PD_BANK_NAME.setReadonly(false);
		COMP_PD_BRANCH_NAME.setReadonly(false);

	    } else if ("SC".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_BANK_NAME.setRequired(false);
		COMP_PD_BRANCH_NAME.setRequired(false);

	    } else if ("A".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_CHQ_NO.setRequired(false);
		COMP_PD_CHQ_DT.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);
		COMP_PD_BANK_NAME.setDisabled(false);
		COMP_PD_BRANCH_NAME.setDisabled(false);
		COMP_PD_BANK_NAME.setRequired(false);
		COMP_PD_BRANCH_NAME.setRequired(false);
		COMP_PD_BANK_NAME.setReadonly(false);
		COMP_PD_BRANCH_NAME.setReadonly(false);

	    } else if ("E".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		/*
		 * if(GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CHQ_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BRANCH_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_NAME") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_EXP_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_TT_CURR_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_CHQ_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PO_MO_DT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_REM_SLIP_GEN_YN") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_REM_AMT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_OUR_BANK_CODE_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_PAYIN_DATE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_CR_ADVICE_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_TYPE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_NO") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_PD_CC_APP_CODE") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_1") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_DATE_OF_CREDIT_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("M_BANK_REF_NO_2") ||
		 * GET_ITEM_PROPERTY.GET_ITEM_PROPERTY(:SYSTEM.CURSOR_ITEM,ITEM_NAME) ==
		 * ("PD_ATM_CARD_NO")) {
		 * GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_SR_NO"); }
		 */

		COMP_PD_PAYIN_DATE.setDisabled(false);
		COMP_PD_PAYIN_DATE.setRequired(true);
		COMP_PD_CR_ADVICE_NO.setDisabled(false);
		COMP_PD_CR_ADVICE_NO.setRequired(true);
		COMP_PD_BANK_NAME.setDisabled(false);
		COMP_PD_BRANCH_NAME.setDisabled(false);
		COMP_PD_BANK_NAME.setRequired(true);
		COMP_PD_BRANCH_NAME.setRequired(false);
		COMP_PD_BANK_NAME.setReadonly(false);
		COMP_PD_BRANCH_NAME.setReadonly(false);

	    } else if ("DP".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		COMP_PD_CHQ_NO.setDisabled(true);
		COMP_PD_CHQ_DT.setDisabled(true);
		COMP_PD_BANK_NAME.setDisabled(true);
		COMP_PD_BRANCH_NAME.setDisabled(true);
		COMP_PD_BANK_NAME.setRequired(false);
		COMP_PD_BRANCH_NAME.setRequired(false);
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);

	    }
	    if (PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE() != "E") {
		COMP_PD_PAYIN_DATE.setDisabled(true);
		COMP_PD_PAYIN_DATE.setRequired(false);

		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_PAYIN_DATE",ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_PAYIN_DATE",REQUIRED,PROPERTY_FALSE);
		 */
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(resultSetsql_C1);
		CommonUtils.closeCursor(resultSetsql_C2);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    /*
     * When_Create_Record Code
     */

    public void pilp002_apac_pt_il_pymt_dtls_when_create_record() {
	handler = new CRUDHandler();
	String M_PD_FC_AMT = null;
	String M_PD_LC_AMT = null;
	String M_PS_VALUE = null;
	String M_CODE_DESC = null;
	String M_DUMMY = null;

	ResultSet resultSetsql_C1 = null;
	try {
	    connection = CommonUtils.getConnection();
	    String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.WHEN_CREATE_RECORD_SQLC1;
	    Object[] objectsql_C1 = { PT_IL_PYMT_DTLS_BEAN.getPD_TXN_SYS_ID() };
	    resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
		    connection, objectsql_C1);

	    PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR("D");
	    PT_IL_PYMT_DTLS_BEAN.setPD_TXN_TYPE(CommonUtils
		    .getGlobalVariable("GLOBAL.TXN_TYPE"));
	    PT_IL_PYMT_DTLS_BEAN.setPD_TXN_SYS_ID(Long.parseLong(CommonUtils
		    .getGlobalVariable("GLOBAL.TXN_SYS_ID")));
	    PT_IL_PYMT_DTLS_BEAN.setPD_CURR_CODE(CommonUtils
		    .getGlobalVariable("GLOBAL.CURR_CODE"));
	    M_PD_FC_AMT = CommonUtils.getGlobalVariable("GLOBAL.FC_AMT");
	    M_PD_LC_AMT = CommonUtils.getGlobalVariable("GLOBAL.LC_AMT");

	    /*
	     * :PT_IL_PYMT_DTLS.PD_PAID_FOR="D";
	     * :PT_IL_PYMT_DTLS.PD_TXN_TYPE=:GLOBAL.TXN_TYPE;
	     * :PT_IL_PYMT_DTLS.PD_TXN_SYS_ID=:GLOBAL.TXN_SYS_ID;
	     * :PT_IL_PYMT_DTLS.PD_CURR_CODE=:GLOBAL.CURR_CODE;
	     * M_PD_FC_AMT=java.lang.Math.abs(:GLOBAL.FC_AMT);
	     * M_PD_LC_AMT=java.lang.Math.abs(:GLOBAL.LC_AMT);
	     */
	    if ("D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR())) {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
			.getPD_LC_AMT());
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN
			.getPD_LC_AMT());
		PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
	    }
	    if ("QD".equals(CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE"))
		    || "PD".equals(CommonUtils
			    .getGlobalVariable("GLOBAL.TXN_TYPE"))) {
		COMP_PD_DPD_REF_ID.setDisabled(true);

		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.M_BUT_LOV_DPD_REF_ID",ENABLED,PROPERTY_FALSE);
		 */
	    } else {
		COMP_PD_DPD_REF_ID.setDisabled(false);
		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_DPD_REF_ID",ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.M_BUT_LOV_DPD_REF_ID",ENABLED,PROPERTY_TRUE);
		 */
	    }
	    if ("DR".equals(CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE"))) {
		PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE("DP");
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE("P");
	    }
	    if (PT_IL_PYMT_DTLS_BEAN.getPD_PAYIN_DATE() == null) {
		PT_IL_PYMT_DTLS_BEAN.setPD_PAYIN_DATE(new java.sql.Date(
			Calendar.getInstance().getTimeInMillis()));
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setPD_PAYIN_DATE(PT_IL_PYMT_DTLS_BEAN
			.getPD_PAYIN_DATE());
		COMP_PD_PAYIN_DATE.setDisabled(false);

		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_PAYIN_DATE",ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PYMT_DTLS.PD_PAYIN_DATE",UPDATE_ALLOWED,PROPERTY_TRUE);
		 */
	    }
	    DUMMY dummy = new DUMMY();
	    PT_IL_PYMT_DTLS_BEAN.setPD_CC_TYPE("O");
	    PT_IL_PYMT_DTLS_BEAN.setPD_CUST_NAME(dummy.getPD_CUST_NAME());
	    PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_01(dummy.getPD_ADDR_01());
	    PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_02(dummy.getPD_ADDR_02());
	    PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_03(dummy.getPD_ADDR_03());
	    PT_IL_PYMT_DTLS_BEAN.setPD_REMARKS(dummy.getPD_REMARKS());

	    /*
	     * :PT_IL_PYMT_DTLS.PD_CC_TYPE="O";
	     * :PT_IL_PYMT_DTLS.PD_CUST_NAME=:DUMMY.PD_CUST_NAME;
	     * :PT_IL_PYMT_DTLS.PD_ADDR_01=:DUMMY.PD_ADDR_01;
	     * :PT_IL_PYMT_DTLS.PD_ADDR_02=:DUMMY.PD_ADDR_02;
	     * :PT_IL_PYMT_DTLS.PD_ADDR_03=:DUMMY.PD_ADDR_03;
	     * :PT_IL_PYMT_DTLS.PD_REMARKS=:DUMMY.PD_REMARKS;
	     */
	    if (PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE() != null) {
		ArrayList<String> list = P_VAL_CURR.callP_VAL_CURR(connection,
			PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE(), "N", "E", "");
		if (list != null && list.size() > 0) {

		    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_CURR_CODE_DESC(list.get(0));
		    // P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);
		}
	    }
	    if (PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_TOTAL_AMT() != null) {
		if (PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_TOTAL_AMT() == Double
			.parseDouble(M_PD_FC_AMT)) {
		}
	    }
	    if (PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_TOTAL_AMT() != null) {
		PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double
			.parseDouble(M_PD_FC_AMT)
			- PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_TOTAL_AMT());
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double
			.parseDouble(M_PD_FC_AMT));
	    }
	    // TODO Commented to avoid compilation error
	    ArrayList<String> list = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE(),"V","","");
	    if (list != null && list.size() > 0) {
		PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double.parseDouble(list
			.get(0)));
	    }

	    // :PT_IL_PYMT_DTLS.PD_LC_AMT=:PT_IL_PYMT_DTLS.PD_FC_AMT*:GLOBAL.EXCH_RATE;
	    PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_FC_AMT()
		    * Double.parseDouble((String) session
			    .getAttribute("GLOBAL.EXCH_RATE")));

	    // TODO Commented to avoid compilation error
	    ArrayList<String> list1 = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,dummy.getBASE_CURR_CODE(),"R","","");
	    if (list != null && list1.size() > 0) {
		PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(Double.parseDouble(list1
			.get(0)));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {

	    try {
		CommonUtils.closeCursor(resultSetsql_C1);
	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	}
    }

    /*
     * WHEN-NEW-BLOCK-INSTANCE Code
     */

    public void pilp002_apac_pt_il_pymt_dtls_when_new_block_instance() {
	try {
	    String FORM_STATUS = "CHANGED";
	    /*
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_1");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_2");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_3");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_4");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_5");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_6");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_7");
	     * HIDE_VIEW.HIDE_VIEW("PT_IL_PYMT_DTLS_8");
	     */
	    /*
	     * :SYSTEM.MESSAGE_LEVEL=10; EXECUTE_QUERY.EXECUTE_QUERY();
	     * :SYSTEM.MESSAGE_LEVEL=0;
	     */
	    if (FORM_STATUS == "CHANGED") {
		// :SYSTEM.MESSAGE_LEVEL=10;
		getControlBean().setM_COMM_DEL("P");
		// POST.POST();
		getControlBean().setM_COMM_DEL(null);
		// :SYSTEM.MESSAGE_LEVEL=0;
		PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(PT_IL_PYMT_DTLS_BEAN
			.getPD_SR_NO());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /*
     * SR_NO When_Validate_Item
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_sr_no_when_validate_item()
	    throws ValidatorException, Exception {
	if (COMP_PD_SR_NO.getSubmittedValue() != null) {
	    if (Integer.parseInt((String) COMP_PD_SR_NO.getSubmittedValue()) < 1) {
		throw new ValidatorException(Messages.getMessage(
			"PELErrorMessages", "91003"));
	    }
	}
	if (PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR() == "D") {

	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
	} else {
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
	}
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_SR_NO
     * 
     * @param e
     */
    public void COMP_PD_SR_NO_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_SR_NO
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_SR_NO(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_sr_no_when_validate_item();
    }

    // public HtmlCommandButton getCOMP_UI_M_BUT_PREFORMBUTTON() {
    // return COMP_UI_M_BUT_PREFORMBUTTON;
    // }

    // public void setCOMP_UI_M_BUT_PREFORMBUTTON(
    // HtmlCommandButton comp_ui_m_but_preformbutton) {
    // COMP_UI_M_BUT_PREFORMBUTTON = comp_ui_m_but_preformbutton;
    // }

    public ArrayList<PT_IL_PYMT_DTLS> getPaymentDetailList() {
	return paymentDetailList;
    }

    public void setPaymentDetailList(
	    ArrayList<PT_IL_PYMT_DTLS> paymentDetailList) {
	this.paymentDetailList = paymentDetailList;
    }

    public HtmlOutputLabel getCOMP_UI_M_BANK_NAME_DESC_LABEL() {
	return COMP_UI_M_BANK_NAME_DESC_LABEL;
    }

    public void setCOMP_UI_M_BANK_NAME_DESC_LABEL(
	    HtmlOutputLabel comp_ui_m_bank_name_desc_label) {
	COMP_UI_M_BANK_NAME_DESC_LABEL = comp_ui_m_bank_name_desc_label;
    }

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

    public void pilp002_apac_pt_il_pymt_dtls_pd_payin_date_when_validate_item()
	    throws ValidatorException, Exception {
	Date date = new Date();
	// if(COMP_PD_PAYIN_DATE.getSubmittedValue() > date)
	if (((Date) COMP_PD_PAYIN_DATE.getSubmittedValue()).after(date))
	// if(PT_IL_PYMT_DTLS_BEAN.getPD_PAYIN_DATE()> date)
	{
	    throw new ValidatorException(new FacesMessage(
		    "PAY IN DATE CANNOT BE GREATER THAN SYSDATE"));
	}
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_PAYIN_DATE
     * 
     * @param e
     */
    public void COMP_PD_PAYIN_DATE_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_PAYIN_DATE
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_PAYIN_DATE(FacesContext context,
	    UIComponent component, Object value) throws ValidatorException,
	    Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_payin_date_when_validate_item();
    }

    /*
     * REF_ID WHEN_VALIDATE_ITEM
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_dpd_ref_id_when_validate_item() {
	String M_BANK_NAME = null;
	String M_DPD_REF_ID = null;
	String M_CONT_CODE = null;

	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C2 = null;
	ResultSet resultSetsql_C3 = null;

	try {
	    connection = CommonUtils.getConnection();
	    handler = new CRUDHandler();
	    if ("LR".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.REF_ID_WHEN_VALIDATE_SQLC1;
		Object[] objectsql_C1 = { PT_IL_PYMT_DTLS_BEAN
			.getPD_DPD_REF_ID() };
		resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
			connection, objectsql_C1);

		if (resultSetsql_C1.next()) {
		}
		// TODO Commented to avoid compilation error
		ArrayList<String> list = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE(),"V","","");
		if (list != null && list.size() > 0) {
		    PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double.parseDouble(list
			    .get(0)));
		}
		PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(PT_IL_PYMT_DTLS_BEAN
			.getPD_LC_AMT()
			/ Double.parseDouble(CommonUtils
				.getGlobalVariable("GLOBAL.EXCH_RATE")));
		DUMMY dummy = new DUMMY();
		// TODO Commented to avoid compilation error
		ArrayList<String> list1 = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,dummy.getBASE_CURR_CODE(),"R","","");
		if (list1 != null && list1.size() > 0) {
		    PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double.parseDouble(list
			    .get(0)));
		}
		if (resultSetsql_C1.next()) {
		    /*
		     * DISP_ALERT.DISP_ALERT("DEPOSIT PYMT DTLS NOT FOUND FOR
		     * "+:PT_IL_PYMT_DTLS.PD_DPD_REF_ID);
		     * resultSetsql_C1.close(); throw new
		     * FORM_TRIGGER_FAILURE();
		     */
		}
		// resultSetsql_C1.close();
		if (PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME() != null) {
		    M_BANK_NAME = PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME();

		    String sql_C2 = PT_IL_PYMT_DTLS_SQL_CONSTS.REF_ID_WHEN_VALIDATE_SQLC2;
		    Object[] objectsql_C2 = {
			    getControlBean().getM_LANG_CODE(), M_BANK_NAME };
		    resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
			    connection, objectsql_C2);
		    if (resultSetsql_C2.next()) {
		    }
		    if (resultSetsql_C2.next()) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"3206"));
		    }
		}
		if (PT_IL_PYMT_DTLS_BEAN.getPD_LC_AMT() > 0) {
		    M_DPD_REF_ID = PT_IL_PYMT_DTLS_BEAN.getPD_DPD_REF_ID();

		    String sql_C3 = PT_IL_PYMT_DTLS_SQL_CONSTS.REF_ID_WHEN_VALIDATE_SQLC3;
		    Object[] objectsql_C3 = { M_DPD_REF_ID };
		    resultSetsql_C3 = handler.executeSelectStatement(sql_C3,
			    connection, objectsql_C3);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(resultSetsql_C1);
		CommonUtils.closeCursor(resultSetsql_C2);
		CommonUtils.closeCursor(resultSetsql_C3);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

    }

    /*
     * PD_FC_AMT WHEN_VALIDATE_ITEM
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_fc_amt_when_validate_item()
	    throws ValidatorException, Exception {
	if (COMP_PD_FC_AMT.getSubmittedValue() != null) {
	    if (Integer.parseInt((String) COMP_PD_FC_AMT.getSubmittedValue()) < 0) {
		throw new ValidatorException(Messages.getMessage(
			"com.iii.premia.common.errorUtil.PELErrorMessages", "91052"));
	    }
	}
	if (PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_TOTAL_AMT() != null) {
	    if (PT_IL_PYMT_DTLS_BEAN.getUI_M_PD_TOTAL_AMT() > Double
		    .parseDouble(CommonUtils.getGlobalVariable("GLOBAL.FC_AMT"))) {
		throw new ValidatorException(Messages.getMessage(
			"com.iii.premia.common.errorUtil.PELErrorMessages", "91070"));
	    }
	}

	// TODO Commented to avoid compilation error
	ArrayList<String> list = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,PT_IL_PYMT_DTLS_BEAN.getPD_CURR_CODE(),"V","","");
	if (list != null && list.size() > 0) {
	    PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double.parseDouble(list.get(0)));
	}

	// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(:PT_IL_PYMT_DTLS.PD_CURR_CODE,:PT_IL_PYMT_DTLS.PD_FC_AMT,"V");
	PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(PT_IL_PYMT_DTLS_BEAN.getPD_FC_AMT()
		* Double.parseDouble(CommonUtils
			.getGlobalVariable("GLOBAL.EXCH_RATE")));
	if ("PM".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
	    PT_IL_PYMT_DTLS_BEAN.setPD_REM_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	} else {
	    PT_IL_PYMT_DTLS_BEAN.setPD_REM_AMT(null);
	}

	DUMMY dummy = new DUMMY();
	// TODO Commented to avoid compilation error
	ArrayList<String> list1 = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,dummy.getBASE_CURR_CODE(),"R","","");
	if (list1 != null && list1.size() > 0) {
	    PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double.parseDouble(list1.get(0)));
	}

	// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(:DUMMY.BASE_CURR_CODE,:PT_IL_PYMT_DTLS.PD_LC_AMT,"R");
	if ("D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR())) {
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
	} else {
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
	}

    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_FC_AMT
     * 
     * @param e
     */
    public void COMP_PD_FC_AMT_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_FC_AMT
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_FC_AMT(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_fc_amt_when_validate_item();
    }

    /*
     * PD_LC_AMT_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_lc_amt_when_validate_item()
	    throws ValidatorException, Exception {
	if (COMP_PD_LC_AMT.getSubmittedValue() != null) {
	    if (Integer.parseInt((String) COMP_PD_LC_AMT.getSubmittedValue()) < 0) {
		throw new ValidatorException(Messages.getMessage(
			"com.iii.premia.common.errorUtil.PELErrorMessages", "91052"));
		/*
		 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91052,:CTRL.M_LANG_CODE);
		 * throw new FORM_TRIGGER_FAILURE();
		 */
	    }
	}

	DUMMY dummy = new DUMMY();
	// TODO Commented to avoid compilation error
	ArrayList<String> list1 = null;// P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection,dummy.getBASE_CURR_CODE(),"R","","");
	if (list1 != null && list1.size() > 0) {
	    PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(Double.parseDouble(list1.get(0)));
	}

	// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(:DUMMY.BASE_CURR_CODE,:PT_IL_PYMT_DTLS.PD_LC_AMT,"R");
	P_VAL_FC_LC_TOLERANCE.callP_VAL_FC_LC_TOLERANCE(PT_IL_PYMT_DTLS_BEAN
		.getPD_FC_AMT().toString(), PT_IL_PYMT_DTLS_BEAN.getPD_LC_AMT()
		.toString(), CommonUtils.getGlobalVariable("GLOBAL.EXCH_RATE"),
		"E");
	if ("D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR())) {
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
	} else {
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN
		    .getPD_LC_AMT());
	    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
	}
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_LC_AMT
     * 
     * @param e
     */
    public void COMP_PD_LC_AMT_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_LC_AMT
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_LC_AMT(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_lc_amt_when_validate_item();
    }

    /*
     * PD_PAID_FOR_WHEN_LIST_CHANGED
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_paid_for_when_list_changed()
	    throws ValidatorException, Exception {
	connection = CommonUtils.getConnection();
	handler = new CRUDHandler();

	String M_PROD_TOPUP_YN = null;
	String M_POL_NO_YRS_PREM_PAID = null;
	double M_TEMP = -1;
	double M_TEMP_1 = -1;
	String M_TEMP3 = null;

	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C2 = null;
	ResultSet resultSetsql_C3 = null;
	String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.PD_PAID_FOR_WHEN_LIST_CHANGED_SQLC1;
	Object[] objectsql_C1 = { CommonUtils
		.getGlobalVariable("GLOBAL.G_DEP_REF_NO") };

	try {
	    resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
		    connection, objectsql_C1);

	    if (CommonUtils.getGlobalVariable("GLOBAL.G_DEP_REF_NO") != null) {
		if (MigratingFunctions.nvl(CommonUtils
			.getGlobalVariable("GLOBAL.TXN_TYPE"), "Q") == "Q") {
		    PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR("D");
		}
		if (MigratingFunctions.nvl(PT_IL_PYMT_DTLS_BEAN
			.getPD_PAID_FOR(), "X") == "T") {
		    /*
		     * if(resultSetsql_C2!=null) { resultSetsql_C2.close(); }
		     */

		    String sql_C2 = PT_IL_PYMT_DTLS_SQL_CONSTS.PD_PAID_FOR_WHEN_LIST_CHANGED_SQLC2;
		    Object[] objectsql_C2 = { CommonUtils
			    .getGlobalVariable("GLOBAL.G_DEP_REF_NO") };
		    resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
			    connection, objectsql_C2);

		    if (resultSetsql_C2.next()) {
			M_PROD_TOPUP_YN = resultSetsql_C2.getString(1);
		    }
		    if (MigratingFunctions.nvl(M_PROD_TOPUP_YN, "N") != "Y") {
			PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR("D");
			PT_IL_PYMT_DTLS_BEAN
				.setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
					.getPD_LC_AMT());
			PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"3206"));

			/*
			 * :PT_IL_PYMT_DTLS.PD_PAID_FOR="D";
			 * :PT_IL_PYMT_DTLS.M_PD_DEP_AMT=:PT_IL_PYMT_DTLS.PD_LC_AMT;
			 * :PT_IL_PYMT_DTLS.M_PD_OTH_AMT=0; throw new
			 * FORM_TRIGGER_FAILURE();
			 */
		    }

		    String sql_C3 = PT_IL_PYMT_DTLS_SQL_CONSTS.PD_PAID_FOR_WHEN_LIST_CHANGED_SQLC3;
		    Object[] objectsql_C3 = { CommonUtils
			    .getGlobalVariable("GLOBAL.G_DEP_REF_NO") };
		    resultSetsql_C3 = handler.executeSelectStatement(sql_C3,
			    connection, objectsql_C3);

		    if (resultSetsql_C3.next()) {
			M_POL_NO_YRS_PREM_PAID = resultSetsql_C3.getString(1);
		    }
		}
		if ("D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAID_FOR())) {
		    PT_IL_PYMT_DTLS_BEAN
			    .setUI_M_PD_DEP_AMT(PT_IL_PYMT_DTLS_BEAN
				    .getPD_LC_AMT());
		    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_OTH_AMT(0.0);
		} else {
		    PT_IL_PYMT_DTLS_BEAN
			    .setUI_M_PD_OTH_AMT(PT_IL_PYMT_DTLS_BEAN
				    .getPD_LC_AMT());
		    PT_IL_PYMT_DTLS_BEAN.setUI_M_PD_DEP_AMT(0.0);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    CommonUtils.closeCursor(resultSetsql_C1);
	    CommonUtils.closeCursor(resultSetsql_C2);
	    CommonUtils.closeCursor(resultSetsql_C3);
	}
    }

    /*
     * PD_CHQ_DT_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_chq_dt_when_validate_item()
	    throws ValidatorException, Exception {
	connection = CommonUtils.getConnection();
	handler = new CRUDHandler();

	String M_CODE_DESCRIPTION = null;
	int M_TEMP_VAL = -1;

	if (COMP_PD_CHQ_DT.getSubmittedValue() != null) {
	    if (((Date) COMP_PD_CHQ_DT.getSubmittedValue())
		    .after(ConvertFunctions.to_date("31/12/2999", "dd/mm/yyyy"))) {
		throw new ValidatorException(Messages.getMessage(
			"com.iii.premia.common.errorUtil.PELErrorMessages", "91063"));
	    }
	    NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_DT()
		    .getTime());

	    if (NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_DT()
		    .getTime()) > NumericFunctions
		    .trunc(
			    new java.sql.Date(Calendar.getInstance()
				    .getTimeInMillis())).getTime()) // tochk
	    {
		ArrayList<String> list = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
			"IL_PDC_DAYS", "IL_PDC_DAYS", "N");
		if (list != null && list.size() > 0) {
		    M_CODE_DESCRIPTION = list.get(0);
		    M_TEMP_VAL = Integer.parseInt(list.get(1));

		}
		if (NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_DT()
			.getTime())
			- NumericFunctions.trunc(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()).getTime()) > MigratingFunctions
			.nvl(M_TEMP_VAL, 0)) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "91385"));
		}

		ArrayList<String> list1 = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
			"PDC_ALT_DAYS", "PDC_ALT_DAYS", "N");
		if (list1 != null && list1.size() > 0) {
		    M_CODE_DESCRIPTION = list1.get(0);
		    M_TEMP_VAL = Integer.parseInt(list1.get(1));

		}

		// P_VAL_SYSTEM.P_VAL_SYSTEM("PDC_ALT_DAYS","PDC_ALT_DAYS",M_CODE_DESCRIPTION,"N",M_TEMP_VAL);
		if (NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN.getPD_CHQ_DT()
			.getTime())
			- NumericFunctions.trunc(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()).getTime()) > MigratingFunctions
			.nvl(M_TEMP_VAL, 0)) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "91385"));
		}
		CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "Y");
	    } else if (NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN
		    .getPD_CHQ_DT().getTime()) < NumericFunctions
		    .trunc(
			    new java.sql.Date(Calendar.getInstance()
				    .getTimeInMillis())).getTime()) {

		ArrayList<String> list2 = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
			"IL_PRC_DAYS", "IL_PRC_DAYS", "N");
		if (list2 != null && list2.size() > 0) {
		    M_CODE_DESCRIPTION = list2.get(0);
		    M_TEMP_VAL = Integer.parseInt(list2.get(1));

		}

		// P_VAL_SYSTEM.P_VAL_SYSTEM("IL_PRC_DAYS","IL_PRC_DAYS",M_CODE_DESCRIPTION,"N",M_TEMP_VAL);
		if (NumericFunctions.trunc(new java.sql.Date(Calendar
			.getInstance().getTimeInMillis()).getTime())
			- NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN
				.getPD_CHQ_DT().getTime()) > MigratingFunctions
			.nvl(M_TEMP_VAL, 0)) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "91386"));
		}

		ArrayList<String> list3 = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
			"PRC_ALT_DAYS", "PRC_ALT_DAYS", "N");
		if (list3 != null && list3.size() > 0) {
		    M_CODE_DESCRIPTION = list3.get(0);
		    M_TEMP_VAL = Integer.parseInt(list3.get(1));

		}

		// P_VAL_SYSTEM.P_VAL_SYSTEM("PRC_ALT_DAYS","PRC_ALT_DAYS",M_CODE_DESCRIPTION,"N",M_TEMP_VAL);
		if (NumericFunctions.trunc(new java.sql.Date(Calendar
			.getInstance().getTimeInMillis()).getTime())
			- NumericFunctions.trunc(PT_IL_PYMT_DTLS_BEAN
				.getPD_CHQ_DT().getTime()) > MigratingFunctions
			.nvl(M_TEMP_VAL, 0)) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "91386"));
		}
		CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
	    } else {
		CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
	    }
	} else {
	    CommonUtils.setGlobalVariable("GLOBAL.DEP_PDC_FLAG", "N");
	}
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_CHQ_DT
     * 
     * @param e
     */
    public void COMP_PD_CHQ_DT_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_LC_AMT
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_CHQ_DT(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_chq_dt_when_validate_item();
    }

    /*
     * PD_BANK_NAME_KEY_NEXT_ITEM
     */
    public void pilp002_apac_pt_il_pymt_dtls_pd_bank_name_key_next_item() {
	try {
	    if ("C".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "L".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "H".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "O".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "SD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		L_DUP_CHQ_NO();
	    }
	    // GO_ITEM.GO_ITEM("PT_IL_PYMT_DTLS.PD_BRANCH_NAME");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /*
     * L_DUP_CHQ_NO
     */
    public void L_DUP_CHQ_NO() throws ValidatorException, Exception {
	connection = CommonUtils.getConnection();
	handler = new CRUDHandler();
	String RECORD_STATUS = "INSERT";

	ResultSet resultSetsql_C1 = null;
	ResultSet resultSetsql_C2 = null;

	try {
	    if ("INSERT".equals(RECORD_STATUS)) {
		String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.L_DUP_CHQ_NO_SQLC1;
		Object[] objectsql_C1 = { PT_IL_PYMT_DTLS_BEAN
			.getPD_BANK_NAME() };
		resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
			connection, objectsql_C1);
		while ((resultSetsql_C1.next())) {
		    // C1 IREC=new C1();
		    if (!resultSetsql_C1.next()) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91399"));
		    }
		}
	    } else if ("CHANGED".equals(RECORD_STATUS)) {
		String sql_C2 = PT_IL_PYMT_DTLS_SQL_CONSTS.L_DUP_CHQ_NO_SQLC2;
		Object[] objectsql_C2 = {
			PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME(),
			PT_IL_PYMT_DTLS_BEAN.getROWID() };
		resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
			connection, objectsql_C2);
		while ((resultSetsql_C2.next())) {
		    // C2 UREC=new C2();
		    if (!resultSetsql_C2.isLast()) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91399"));
		    }
		}
	    }

	} finally {
	    try {
		CommonUtils.closeCursor(resultSetsql_C1);
		CommonUtils.closeCursor(resultSetsql_C2);
	    } catch (Exception exc) {
		exc.printStackTrace();
	    }
	}
    }

    /*
     * PD_BANK_NAME_WHEN_VALIDATE_ITEM
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_bank_name_when_validate_item()
	    throws ValidatorException, Exception {
	connection = CommonUtils.getConnection();
	handler = new CRUDHandler();

	ResultSet resultSetsqlC1 = null;

	try {
	    if (PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME() != null) {

		String sql_C1 = PT_IL_PYMT_DTLS_SQL_CONSTS.PD_BANK_NAME_WHEN_VALIDATE_SQLC1;
		Object[] objectsql_C1 = { getControlBean().getM_LANG_CODE(),
			PT_IL_PYMT_DTLS_BEAN.getPD_BANK_NAME() };
		resultSetsqlC1 = handler.executeSelectStatement(sql_C1,
			connection, objectsql_C1);

		if (resultSetsqlC1.next()) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "3206"));
		}
	    } else {
		PT_IL_PYMT_DTLS_BEAN.setUI_M_BANK_NAME_DESC(null);
	    }
	    if ("C".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "D".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "L".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "H".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "O".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())
		    || "SD".equals(PT_IL_PYMT_DTLS_BEAN.getPD_PAY_MODE())) {
		L_DUP_CHQ_NO();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    CommonUtils.closeCursor(resultSetsqlC1);
	}
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_BANK_NAME
     * 
     * @param e
     */
    public void COMP_PD_BANK_NAME_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_BANK_NAME
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_BANK_NAME(FacesContext context,
	    UIComponent component, Object value) throws ValidatorException,
	    Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_bank_name_when_validate_item();
    }

    /*
     * PD_CUST_NAME_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_cust_name_when_validate_item()
	    throws SQLException, Exception {
	DUMMY dummy = new DUMMY();
	if (PT_IL_PYMT_DTLS_BEAN.getPD_CUST_NAME() != null) {
	    dummy.setPD_CUST_NAME(PT_IL_PYMT_DTLS_BEAN.getPD_CUST_NAME());
	}
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_CUST_NAME
     * 
     * @param e
     */
    public void COMP_PD_CUST_NAME_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_CUST_NAME
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_CUST_NAME(FacesContext context,
	    UIComponent component, Object value) throws ValidatorException,
	    Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_cust_name_when_validate_item();
    }

    /*
     * PD_ADDR_01_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_addr_01_when_validate_item()
	    throws ValidatorException, Exception {
	DUMMY dummy = new DUMMY();
	dummy.setPD_ADDR_01(PT_IL_PYMT_DTLS_BEAN.getPD_ADDR_01());
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_ADDR_01
     * 
     * @param e
     */
    public void COMP_PD_ADDR_01_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_ADDR_01
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_ADDR_01(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_addr_01_when_validate_item();
    }

    /*
     * PD_ADDR_02_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_addr_02_when_validate_item()
	    throws ValidatorException, Exception {
	DUMMY dummy = new DUMMY();
	dummy.setPD_ADDR_02(PT_IL_PYMT_DTLS_BEAN.getPD_ADDR_02());
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_ADDR_02
     * 
     * @param e
     */
    public void COMP_PD_ADDR_02_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_ADDR_02
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_ADDR_02(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_addr_02_when_validate_item();
    }

    /*
     * PD_ADDR_03_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_addr_03_when_validate_item()
	    throws ValidatorException, Exception {
	DUMMY dummy = new DUMMY();
	dummy.setPD_ADDR_03(PT_IL_PYMT_DTLS_BEAN.getPD_ADDR_03());
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_ADDR_03
     * 
     * @param e
     */
    public void COMP_PD_ADDR_03_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_ADDR_03
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_ADDR_03(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_addr_03_when_validate_item();
    }

    /*
     * PD_REMARKS_WHEN_VALIDATE
     */

    public void pilp002_apac_pt_il_pymt_dtls_pd_remarks_when_validate_item()
	    throws ValidatorException, Exception {
	DUMMY dummy = new DUMMY();
	dummy.setPD_REMARKS(PT_IL_PYMT_DTLS_BEAN.getPD_REMARKS());
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR COMP_PD_REMARKS
     * 
     * @param e
     */
    public void COMP_PD_REMARKS_WHEN_VALIDATE_ITEM(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
     * METHOD CALLED ON VALIDATOR FOR PD_REMARKS
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validatePD_REMARKS(FacesContext context, UIComponent component,
	    Object value) throws ValidatorException, Exception {
	pilp002_apac_pt_il_pymt_dtls_pd_remarks_when_validate_item();
    }

    public String navigateToApprovalScreen() {

	return "approve";
    }

    public ControlBean getControlBean() {
	return controlBean;
    }

    public void setControlBean(ControlBean controlBean) {
	this.controlBean = controlBean;
    }
}
