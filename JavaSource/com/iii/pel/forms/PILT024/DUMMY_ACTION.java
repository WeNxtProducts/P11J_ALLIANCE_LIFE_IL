package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.taglib.html.jsp.AjaxCommandButton;
import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_CHEQ_VALIDATION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlCommandLink COMP_UI_M_BUT_APPROVE;
	private HtmlCommandLink COMP_UI_M_BUT_BROKER_DTLS;
	private HtmlCommandLink COMP_UI_M_BUT_PYMT_DTLS;
	private HtmlCommandLink COMP_UI_M_BUT_CHG_DTL;
	private HtmlCommandLink COMP_UI_M_BUT_CVR_DTL;
	private HtmlCommandLink COMP_UI_M_BUT_FAC;
	private HtmlCommandLink COMP_UI_M_BUT_INVEST_DETAILS;
	private HtmlCommandLink COMP_UI_M_BUT_RNEW_PREM_COLL;
	private AjaxCommandButton COMP_UI_M_BUT_ALLOCATE;
	private HtmlCommandLink COMP_UI_M_BUT_PREM_DTLS;
	private HtmlCommandLink COMP_UI_M_BUT_PREM_SUB_DTL;

	private HtmlOutputLabel COMP_UI_M_FC_UNPAID_PREM_INT_LABEL;
	private HtmlOutputLabel COMP_UI_M_FC_DUE_AMOUNT_LABEL;
	private HtmlOutputLabel COMP_UI_M_FC_PAID_AMOUNT_LABEL;
	private HtmlOutputLabel COMP_UI_M_FC_AVLB_BAL_AMT_LABEL;
	private HtmlOutputLabel COMP_UI_M_FC_OP_BAL_LABEL;
	private HtmlOutputLabel COMP_UI_M_FC_TOBE_PAID_AMOUNT_LABEL;
	private HtmlOutputLabel COMP_UI_M_INV_FC_CHARGES_LABEL;
	private HtmlOutputLabel COMP_UI_M_NET_PYMT_FC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FC_UNPAID_PREM_INT;
	private HtmlInputText COMP_UI_M_LC_UNPAID_PREM_INT;
	private HtmlInputText COMP_UI_M_FC_DUE_AMOUNT;
	private HtmlInputText COMP_UI_M_LC_DUE_AMOUNT;
	private HtmlInputText COMP_UI_M_FC_PAID_AMOUNT;
	private HtmlInputText COMP_UI_M_LC_PAID_AMOUNT;
	private HtmlInputText COMP_UI_M_FC_AVLB_BAL_AMT;
	private HtmlInputText COMP_UI_M_LC_AVLB_BAL_AMT;
	private HtmlInputText COMP_UI_M_FC_OP_BAL;
	private HtmlInputText COMP_UI_M_LC_OP_BAL;
	private HtmlInputText COMP_UI_M_FC_TOBE_PAID_AMOUNT;
	private HtmlInputText COMP_UI_M_LC_TOBE_PAID_AMOUNT;
	private HtmlInputText COMP_UI_M_INV_FC_CHARGES;
	private HtmlInputText COMP_UI_M_INV_LC_CHARGES;
	private HtmlInputText COMP_UI_M_NET_PYMT_FC_AMT;
	private HtmlInputText COMP_UI_M_NET_PYMT_LC_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_NEXT;

	private AjaxCommandButton COMP_UI_M_BUT_GET_DETAILS;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private DUMMY DUMMY_BEAN;

	private DUMMY_HELPER helper;

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
	}

	public HtmlInputText getCOMP_UI_M_FC_TOBE_PAID_AMOUNT() {
		return COMP_UI_M_FC_TOBE_PAID_AMOUNT;
	}

	public void setCOMP_UI_M_FC_TOBE_PAID_AMOUNT(
			HtmlInputText comp_ui_m_fc_tobe_paid_amount) {
		COMP_UI_M_FC_TOBE_PAID_AMOUNT = comp_ui_m_fc_tobe_paid_amount;
	}

	public HtmlInputText getCOMP_UI_M_LC_TOBE_PAID_AMOUNT() {
		return COMP_UI_M_LC_TOBE_PAID_AMOUNT;
	}

	public void setCOMP_UI_M_LC_TOBE_PAID_AMOUNT(
			HtmlInputText comp_ui_m_lc_tobe_paid_amount) {
		COMP_UI_M_LC_TOBE_PAID_AMOUNT = comp_ui_m_lc_tobe_paid_amount;
	}

	public String approveButtonAction() {
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		String outCome = null;
		boolean disabled = false;
		try {
			/*Modified by Ameen on 18-05-2017 as per Gaurav sugg.*/
			outCome = helper.whenButtonPreeApprove(compositeAction);
			if(outCome == null){
				throw new Exception("Unable to Approve");
			}else{
				disabled = true;
			}
			//disableAllComponent(disabled);
			//compositeAction.getPT_IL_POLICY_ACTION_BEAN().disablefieldcomponents(disabled);
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("addRow", e.getMessage());
		}
		/*
		 * commented by Ameen on 18-05-2017 as per Gaurav sugg.
		 * outCome = "PILT024_PT_IL_POLICY";*/
		return outCome;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandLink comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_BROKER_DTLS() {
		return COMP_UI_M_BUT_BROKER_DTLS;
	}

	public void setCOMP_UI_M_BUT_BROKER_DTLS(
			HtmlCommandLink comp_ui_m_but_broker_dtls) {
		COMP_UI_M_BUT_BROKER_DTLS = comp_ui_m_but_broker_dtls;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandLink comp_ui_m_but_pymt_dtls) {
		COMP_UI_M_BUT_PYMT_DTLS = comp_ui_m_but_pymt_dtls;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_CHG_DTL() {
		return COMP_UI_M_BUT_CHG_DTL;
	}

	public void setCOMP_UI_M_BUT_CHG_DTL(HtmlCommandLink comp_ui_m_but_chg_dtl) {
		COMP_UI_M_BUT_CHG_DTL = comp_ui_m_but_chg_dtl;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_CVR_DTL() {
		return COMP_UI_M_BUT_CVR_DTL;
	}

	public void setCOMP_UI_M_BUT_CVR_DTL(HtmlCommandLink comp_ui_m_but_cvr_dtl) {
		COMP_UI_M_BUT_CVR_DTL = comp_ui_m_but_cvr_dtl;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandLink comp_ui_m_but_fac) {
		COMP_UI_M_BUT_FAC = comp_ui_m_but_fac;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_INVEST_DETAILS() {
		return COMP_UI_M_BUT_INVEST_DETAILS;
	}

	public void setCOMP_UI_M_BUT_INVEST_DETAILS(
			HtmlCommandLink comp_ui_m_but_invest_details) {
		COMP_UI_M_BUT_INVEST_DETAILS = comp_ui_m_but_invest_details;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_RNEW_PREM_COLL() {
		return COMP_UI_M_BUT_RNEW_PREM_COLL;
	}

	public void setCOMP_UI_M_BUT_RNEW_PREM_COLL(
			HtmlCommandLink comp_ui_m_but_rnew_prem_coll) {
		COMP_UI_M_BUT_RNEW_PREM_COLL = comp_ui_m_but_rnew_prem_coll;
	}

	public AjaxCommandButton getCOMP_UI_M_BUT_ALLOCATE() {
		return COMP_UI_M_BUT_ALLOCATE;
	}

	public void setCOMP_UI_M_BUT_ALLOCATE(
			AjaxCommandButton comp_ui_m_but_allocate) {
		COMP_UI_M_BUT_ALLOCATE = comp_ui_m_but_allocate;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_PREM_DTLS() {
		return COMP_UI_M_BUT_PREM_DTLS;
	}

	public void setCOMP_UI_M_BUT_PREM_DTLS(
			HtmlCommandLink comp_ui_m_but_prem_dtls) {
		COMP_UI_M_BUT_PREM_DTLS = comp_ui_m_but_prem_dtls;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_PREM_SUB_DTL() {
		return COMP_UI_M_BUT_PREM_SUB_DTL;
	}

	public void setCOMP_UI_M_BUT_PREM_SUB_DTL(
			HtmlCommandLink comp_ui_m_but_prem_sub_dtl) {
		COMP_UI_M_BUT_PREM_SUB_DTL = comp_ui_m_but_prem_sub_dtl;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_NEXT() {
		return COMP_UI_M_BUT_NEXT;
	}

	public void setCOMP_UI_M_BUT_NEXT(HtmlCommandButton comp_ui_m_but_next) {
		COMP_UI_M_BUT_NEXT = comp_ui_m_but_next;
	}

	public HtmlInputText getCOMP_UI_M_FC_UNPAID_PREM_INT() {
		return COMP_UI_M_FC_UNPAID_PREM_INT;
	}

	public void setCOMP_UI_M_FC_UNPAID_PREM_INT(
			HtmlInputText comp_ui_m_fc_unpaid_prem_int) {
		COMP_UI_M_FC_UNPAID_PREM_INT = comp_ui_m_fc_unpaid_prem_int;
	}

	public HtmlInputText getCOMP_UI_M_LC_UNPAID_PREM_INT() {
		return COMP_UI_M_LC_UNPAID_PREM_INT;
	}

	public void setCOMP_UI_M_LC_UNPAID_PREM_INT(
			HtmlInputText comp_ui_m_lc_unpaid_prem_int) {
		COMP_UI_M_LC_UNPAID_PREM_INT = comp_ui_m_lc_unpaid_prem_int;
	}

	public HtmlInputText getCOMP_UI_M_FC_DUE_AMOUNT() {
		return COMP_UI_M_FC_DUE_AMOUNT;
	}

	public void setCOMP_UI_M_FC_DUE_AMOUNT(HtmlInputText comp_ui_m_fc_due_amount) {
		COMP_UI_M_FC_DUE_AMOUNT = comp_ui_m_fc_due_amount;
	}

	public HtmlInputText getCOMP_UI_M_LC_DUE_AMOUNT() {
		return COMP_UI_M_LC_DUE_AMOUNT;
	}

	public void setCOMP_UI_M_LC_DUE_AMOUNT(HtmlInputText comp_ui_m_lc_due_amount) {
		COMP_UI_M_LC_DUE_AMOUNT = comp_ui_m_lc_due_amount;
	}

	public HtmlInputText getCOMP_UI_M_FC_PAID_AMOUNT() {
		return COMP_UI_M_FC_PAID_AMOUNT;
	}

	public void setCOMP_UI_M_FC_PAID_AMOUNT(
			HtmlInputText comp_ui_m_fc_paid_amount) {
		COMP_UI_M_FC_PAID_AMOUNT = comp_ui_m_fc_paid_amount;
	}

	public HtmlInputText getCOMP_UI_M_LC_PAID_AMOUNT() {
		return COMP_UI_M_LC_PAID_AMOUNT;
	}

	public void setCOMP_UI_M_LC_PAID_AMOUNT(
			HtmlInputText comp_ui_m_lc_paid_amount) {
		COMP_UI_M_LC_PAID_AMOUNT = comp_ui_m_lc_paid_amount;
	}

	public HtmlInputText getCOMP_UI_M_FC_AVLB_BAL_AMT() {
		return COMP_UI_M_FC_AVLB_BAL_AMT;
	}

	public void setCOMP_UI_M_FC_AVLB_BAL_AMT(
			HtmlInputText comp_ui_m_fc_avlb_bal_amt) {
		COMP_UI_M_FC_AVLB_BAL_AMT = comp_ui_m_fc_avlb_bal_amt;
	}

	public HtmlInputText getCOMP_UI_M_LC_AVLB_BAL_AMT() {
		return COMP_UI_M_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_UI_M_LC_AVLB_BAL_AMT(
			HtmlInputText comp_ui_m_lc_avlb_bal_amt) {
		COMP_UI_M_LC_AVLB_BAL_AMT = comp_ui_m_lc_avlb_bal_amt;
	}

	public HtmlInputText getCOMP_UI_M_FC_OP_BAL() {
		return COMP_UI_M_FC_OP_BAL;
	}

	public void setCOMP_UI_M_FC_OP_BAL(HtmlInputText comp_ui_m_fc_op_bal) {
		COMP_UI_M_FC_OP_BAL = comp_ui_m_fc_op_bal;
	}

	public HtmlInputText getCOMP_UI_M_LC_OP_BAL() {
		return COMP_UI_M_LC_OP_BAL;
	}

	public void setCOMP_UI_M_LC_OP_BAL(HtmlInputText comp_ui_m_lc_op_bal) {
		COMP_UI_M_LC_OP_BAL = comp_ui_m_lc_op_bal;
	}

	public HtmlInputText getCOMP_UI_M_INV_FC_CHARGES() {
		return COMP_UI_M_INV_FC_CHARGES;
	}

	public void setCOMP_UI_M_INV_FC_CHARGES(
			HtmlInputText comp_ui_m_inv_fc_charges) {
		COMP_UI_M_INV_FC_CHARGES = comp_ui_m_inv_fc_charges;
	}

	public HtmlInputText getCOMP_UI_M_INV_LC_CHARGES() {
		return COMP_UI_M_INV_LC_CHARGES;
	}

	public void setCOMP_UI_M_INV_LC_CHARGES(
			HtmlInputText comp_ui_m_inv_lc_charges) {
		COMP_UI_M_INV_LC_CHARGES = comp_ui_m_inv_lc_charges;
	}

	public HtmlInputText getCOMP_UI_M_NET_PYMT_FC_AMT() {
		return COMP_UI_M_NET_PYMT_FC_AMT;
	}

	public void setCOMP_UI_M_NET_PYMT_FC_AMT(
			HtmlInputText comp_ui_m_net_pymt_fc_amt) {
		COMP_UI_M_NET_PYMT_FC_AMT = comp_ui_m_net_pymt_fc_amt;
	}

	public HtmlInputText getCOMP_UI_M_NET_PYMT_LC_AMT() {
		return COMP_UI_M_NET_PYMT_LC_AMT;
	}

	public void setCOMP_UI_M_NET_PYMT_LC_AMT(
			HtmlInputText comp_ui_m_net_pymt_lc_amt) {
		COMP_UI_M_NET_PYMT_LC_AMT = comp_ui_m_net_pymt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_UNPAID_PREM_INT_LABEL() {
		return COMP_UI_M_FC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_UI_M_FC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel comp_ui_m_fc_unpaid_prem_int_label) {
		COMP_UI_M_FC_UNPAID_PREM_INT_LABEL = comp_ui_m_fc_unpaid_prem_int_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_DUE_AMOUNT_LABEL() {
		return COMP_UI_M_FC_DUE_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_FC_DUE_AMOUNT_LABEL(
			HtmlOutputLabel comp_ui_m_fc_due_amount_label) {
		COMP_UI_M_FC_DUE_AMOUNT_LABEL = comp_ui_m_fc_due_amount_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_PAID_AMOUNT_LABEL() {
		return COMP_UI_M_FC_PAID_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_FC_PAID_AMOUNT_LABEL(
			HtmlOutputLabel comp_ui_m_fc_paid_amount_label) {
		COMP_UI_M_FC_PAID_AMOUNT_LABEL = comp_ui_m_fc_paid_amount_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_AVLB_BAL_AMT_LABEL() {
		return COMP_UI_M_FC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_UI_M_FC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_fc_avlb_bal_amt_label) {
		COMP_UI_M_FC_AVLB_BAL_AMT_LABEL = comp_ui_m_fc_avlb_bal_amt_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_OP_BAL_LABEL() {
		return COMP_UI_M_FC_OP_BAL_LABEL;
	}

	public void setCOMP_UI_M_FC_OP_BAL_LABEL(
			HtmlOutputLabel comp_ui_m_fc_op_bal_label) {
		COMP_UI_M_FC_OP_BAL_LABEL = comp_ui_m_fc_op_bal_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_TOBE_PAID_AMOUNT_LABEL() {
		return COMP_UI_M_FC_TOBE_PAID_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_FC_TOBE_PAID_AMOUNT_LABEL(
			HtmlOutputLabel comp_ui_m_fc_tobe_paid_amount_label) {
		COMP_UI_M_FC_TOBE_PAID_AMOUNT_LABEL = comp_ui_m_fc_tobe_paid_amount_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_INV_FC_CHARGES_LABEL() {
		return COMP_UI_M_INV_FC_CHARGES_LABEL;
	}

	public void setCOMP_UI_M_INV_FC_CHARGES_LABEL(
			HtmlOutputLabel comp_ui_m_inv_fc_charges_label) {
		COMP_UI_M_INV_FC_CHARGES_LABEL = comp_ui_m_inv_fc_charges_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_NET_PYMT_FC_AMT_LABEL() {
		return COMP_UI_M_NET_PYMT_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_NET_PYMT_FC_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_net_pymt_fc_amt_label) {
		COMP_UI_M_NET_PYMT_FC_AMT_LABEL = comp_ui_m_net_pymt_fc_amt_label;
	}

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_NEXT = new HtmlCommandButton();
		COMP_UI_M_BUT_GET_DETAILS = new AjaxCommandButton();

		// Instantiating HtmlCommandLink
		COMP_UI_M_BUT_APPROVE = new HtmlCommandLink();
		COMP_UI_M_BUT_BROKER_DTLS = new HtmlCommandLink();
		COMP_UI_M_BUT_PYMT_DTLS = new HtmlCommandLink();
		COMP_UI_M_BUT_CHG_DTL = new HtmlCommandLink();
		COMP_UI_M_BUT_CVR_DTL = new HtmlCommandLink();
		COMP_UI_M_BUT_FAC = new HtmlCommandLink();
		COMP_UI_M_BUT_INVEST_DETAILS = new HtmlCommandLink();
		COMP_UI_M_BUT_RNEW_PREM_COLL = new HtmlCommandLink();
		COMP_UI_M_BUT_ALLOCATE = new AjaxCommandButton();
		COMP_UI_M_BUT_PREM_DTLS = new HtmlCommandLink();
		COMP_UI_M_BUT_PREM_SUB_DTL = new HtmlCommandLink();
		COMP_ALLOCATE_BTN = new HtmlAjaxCommandButton();

	}

	/**
	 * Resets all components in DUMMY_ACTION
	 */

	/**
	 * Disables all components in DUMMY_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_NEXT.setDisabled(disabled);
		// COMP_UI_M_BUT_GET_DETAILS.setDisabled(disabled);

		// Disabling HtmlCommandLink
		COMP_UI_M_BUT_APPROVE.setDisabled(disabled);
		COMP_UI_M_BUT_BROKER_DTLS.setDisabled(disabled);
		COMP_UI_M_BUT_PYMT_DTLS.setDisabled(disabled);
		COMP_UI_M_BUT_CHG_DTL.setDisabled(disabled);
		COMP_UI_M_BUT_CVR_DTL.setDisabled(disabled);
		COMP_UI_M_BUT_FAC.setDisabled(disabled);
		COMP_UI_M_BUT_INVEST_DETAILS.setDisabled(disabled);
		COMP_UI_M_BUT_RNEW_PREM_COLL.setDisabled(disabled);
		// COMP_UI_M_BUT_ALLOCATE.setDisabled(disabled);
		//COMP_UI_M_BUT_PREM_DTLS.setDisabled(disabled);
		//COMP_UI_M_BUT_PREM_SUB_DTL.setDisabled(disabled);
		COMP_ALLOCATE_BTN.setDisabled(disabled);
		
		//textfields
		COMP_UI_M_FC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_UI_M_LC_UNPAID_PREM_INT.setDisabled(disabled);
		COMP_UI_M_FC_DUE_AMOUNT.setDisabled(disabled);
		COMP_UI_M_LC_DUE_AMOUNT.setDisabled(disabled);
		COMP_UI_M_FC_PAID_AMOUNT.setDisabled(disabled);
		COMP_UI_M_LC_PAID_AMOUNT.setDisabled(disabled);
		COMP_UI_M_FC_AVLB_BAL_AMT.setDisabled(disabled);
		COMP_UI_M_LC_AVLB_BAL_AMT.setDisabled(disabled);
		COMP_UI_M_FC_OP_BAL.setDisabled(disabled);
		COMP_UI_M_LC_OP_BAL.setDisabled(disabled);
		COMP_UI_M_FC_TOBE_PAID_AMOUNT.setDisabled(disabled);
		COMP_UI_M_LC_TOBE_PAID_AMOUNT.setDisabled(disabled);
		COMP_UI_M_INV_FC_CHARGES.setDisabled(disabled);
		COMP_UI_M_INV_LC_CHARGES.setDisabled(disabled);
		COMP_UI_M_NET_PYMT_FC_AMT.setDisabled(disabled);
		COMP_UI_M_NET_PYMT_LC_AMT.setDisabled(disabled);

	}

	/*
	 * public void whenButtonPressM_BUT_NEXT() { Double M_PC_LC_BAL_GROSS_PREM =
	 * null; Double M_PC_FC_BAL_GROSS_PREM = null; Double M_PC_FC_BAL_BASIC_PREM =
	 * null; Double M_PC_LC_BAL_BASIC_PREM = null; Double M_PC_FC_BAL_ADDL_PREM =
	 * null; Double M_PC_LC_BAL_ADDL_PREM = null; Double M_PC_FC_BAL_LOAD_AMT =
	 * null; Double M_PC_LC_BAL_LOAD_AMT = null; Double M_PC_LC_BAL_DISC = null;
	 * Double M_PC_FC_BAL_DISC = null; Double M_PC_LC_BAL_COMP_CHRG = null;
	 * Double M_PC_FC_BAL_COMP_CHRG = null; Double M_PC_FC_BAL_CUST_CHRG = null;
	 * Double M_PC_LC_BAL_CUST_CHRG = null; Double M_PC_FC_BAL_CONTR = null;
	 * Double M_PC_LC_BAL_CONTR = null; Long M_PC_SYS_ID = null; String
	 * M_PC_PREM_TYPE = null; Long polsysId = null; Long pcSysId = null;
	 * Connection connection = null; ResultSet resultSet = null, resultSet2 =
	 * null, resultSet3 = null, resultSet4 = null, resultSet5 = null;
	 * CRUDHandler handler = new CRUDHandler(); String CURSOR_1 = " SELECT
	 * MIN(PC_SYS_ID) FROM PT_IL_PREM_COLL " + " WHERE PC_POL_SYS_ID = ? AND
	 * PC_PAID_FLAG != 'A' ";
	 * 
	 * String CURSOR_2 = "SELECT NVL(PC_LC_BAL_GROSS_PREM,0),
	 * NVL(PC_FC_BAL_GROSS_PREM,0), NVL(PC_FC_BAL_BASIC_PREM,0)," + "
	 * NVL(PC_LC_BAL_BASIC_PREM,0), NVL(PC_FC_BAL_ADDL_PREM,0),
	 * NVL(PC_LC_BAL_ADDL_PREM,0), " + " NVL(PC_FC_BAL_LOAD_AMT,0),
	 * NVL(PC_LC_BAL_LOAD_AMT,0), NVL(PC_LC_BAL_DISC,0), " + "
	 * NVL(PC_FC_BAL_DISC,0), NVL(PC_LC_BAL_COMP_CHRG,0),
	 * NVL(PC_FC_BAL_COMP_CHRG,0), " + " NVL(PC_FC_BAL_CUST_CHRG,0),
	 * NVL(PC_LC_BAL_CUST_CHRG,0), NVL(PC_FC_BAL_CONTR,0), " + "
	 * NVL(PC_LC_BAL_CONTR,0) FROM PT_IL_PREM_COLL" + " WHERE PC_POL_SYS_ID = ?
	 * AND PC_SYS_ID= ? ";
	 * 
	 * String CURSOR_3 = " SELECT MAX(PC_SYS_ID) FROM PT_IL_PREM_COLL WHERE
	 * PC_SYS_ID < ( " + " SELECT MIN(PC_SYS_ID) FROM PT_IL_PREM_COLL " + "
	 * WHERE PC_POL_SYS_ID = ? AND PC_PAID_FLAG != 'A')";
	 * 
	 * String CURSOR_4 = " SELECT MIN(PC_SYS_ID) FROM PT_IL_PREM_COLL WHERE " + "
	 * PC_POL_SYS_ID = ? " + " AND PC_PAID_FLAG = 'A' " + " AND
	 * (PC_LC_BAL_GROSS_PREM != 0" + " OR PC_FC_BAL_GROSS_PREM != 0" + " OR
	 * PC_FC_BAL_BASIC_PREM != 0 " + " OR PC_LC_BAL_BASIC_PREM != 0 " + " OR
	 * PC_FC_BAL_ADDL_PREM != 0 " + " OR PC_LC_BAL_ADDL_PREM != 0 " + " OR
	 * PC_FC_BAL_LOAD_AMT != 0 " + " OR PC_LC_BAL_LOAD_AMT != 0 " + " OR
	 * PC_LC_BAL_DISC != 0 " + " OR PC_FC_BAL_DISC != 0 " + " OR
	 * PC_LC_BAL_COMP_CHRG != 0 " + " OR PC_FC_BAL_COMP_CHRG != 0 " + " OR
	 * PC_FC_BAL_CUST_CHRG != 0 " + " OR PC_LC_BAL_CUST_CHRG != 0 " + " OR
	 * PC_FC_BAL_CONTR != 0 " + " OR PC_LC_BAL_CONTR != 0) ";
	 * 
	 * String CURSOR_5 = " SELECT PC_PREM_TYPE FROM PT_IL_PREM_COLL " + " WHERE
	 * PC_POL_SYS_ID = ? " + " AND PC_SYS_ID = ? ";
	 * 
	 * try { connection = CommonUtils.getConnection(); polsysId =
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getPOL_SYS_ID(); pcSysId =
	 * compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
	 * .getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID(); if
	 * (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT() == null) { throw new
	 * Exception(Messages.getString( PELConstants.pelErrorMessagePath,
	 * "80264")); }
	 * 
	 * resultSet2 = handler.executeSelectStatement(CURSOR_2, connection, new
	 * Object[] { polsysId, pcSysId }); if (resultSet2.next()) {
	 * M_PC_LC_BAL_GROSS_PREM = resultSet2.getDouble(1); M_PC_FC_BAL_GROSS_PREM =
	 * resultSet2.getDouble(2); M_PC_FC_BAL_BASIC_PREM =
	 * resultSet2.getDouble(3); M_PC_LC_BAL_BASIC_PREM =
	 * resultSet2.getDouble(4); M_PC_FC_BAL_ADDL_PREM = resultSet2.getDouble(5);
	 * M_PC_LC_BAL_ADDL_PREM = resultSet2.getDouble(6); M_PC_FC_BAL_LOAD_AMT =
	 * resultSet2.getDouble(7); M_PC_LC_BAL_LOAD_AMT = resultSet2.getDouble(8);
	 * M_PC_LC_BAL_DISC = resultSet2.getDouble(9); M_PC_FC_BAL_DISC =
	 * resultSet2.getDouble(10); M_PC_LC_BAL_COMP_CHRG =
	 * resultSet2.getDouble(11); M_PC_FC_BAL_COMP_CHRG =
	 * resultSet2.getDouble(12); M_PC_FC_BAL_CUST_CHRG =
	 * resultSet2.getDouble(13); M_PC_LC_BAL_CUST_CHRG =
	 * resultSet2.getDouble(14); M_PC_FC_BAL_CONTR = resultSet2.getDouble(15);
	 * M_PC_LC_BAL_CONTR = resultSet2.getDouble(16); }
	 * 
	 * if (M_PC_LC_BAL_GROSS_PREM == 0 && M_PC_FC_BAL_GROSS_PREM == 0 &&
	 * M_PC_FC_BAL_BASIC_PREM == 0 && M_PC_LC_BAL_BASIC_PREM == 0 &&
	 * M_PC_FC_BAL_ADDL_PREM == 0 && M_PC_LC_BAL_ADDL_PREM == 0 &&
	 * M_PC_FC_BAL_LOAD_AMT == 0 && M_PC_LC_BAL_LOAD_AMT == 0 &&
	 * M_PC_LC_BAL_DISC == 0 && M_PC_FC_BAL_DISC == 0 && M_PC_LC_BAL_COMP_CHRG ==
	 * 0 && M_PC_FC_BAL_COMP_CHRG == 0 && M_PC_FC_BAL_CUST_CHRG == 0 &&
	 * M_PC_LC_BAL_CUST_CHRG == 0 && M_PC_FC_BAL_CONTR == 0 && M_PC_LC_BAL_CONTR ==
	 * 0) { resultSet4 = handler.executeSelectStatement(CURSOR_4, connection,
	 * new Object[] { polsysId }); if (resultSet4.next()) { M_PC_SYS_ID =
	 * resultSet4.getLong(1); } if (M_PC_SYS_ID != null) {
	 * DUMMY_BEAN.setUI_M_PC_SYS_ID(M_PC_SYS_ID); } else { resultSet =
	 * handler.executeSelectStatement(CURSOR_1, connection, new Object[] {
	 * polsysId }); if (resultSet.next()) { M_PC_SYS_ID = resultSet.getLong(1);
	 * DUMMY_BEAN.setUI_M_PC_SYS_ID(M_PC_SYS_ID); } }
	 * 
	 * resultSet5 = handler.executeSelectStatement(CURSOR_5, connection, new
	 * Object[] { polsysId, DUMMY_BEAN.getUI_M_PC_SYS_ID() }); if
	 * (resultSet5.next()) { M_PC_PREM_TYPE = resultSet5.getString(1); } if
	 * ("R".equals(M_PC_PREM_TYPE)) { throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "93259")); } // TODO //
	 * P10ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(polsysId,DUMMY_BEAN.getUI_M_PC_SYS_ID());
	 * CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
	 * .getUI_M_PC_SYS_ID());
	 * 
	 * TODO
	 * P10ILPK_INVEST_PREM_COLL.CALC_DUE_AMOUNTS(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT()); // TODO POST; // TODO
	 * EXECUTE_QUERY;
	 * 
	 * compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_PAID_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT()); } else { resultSet3 =
	 * handler.executeSelectStatement(CURSOR_3, connection, new Object[] {
	 * polsysId }); if (resultSet3.next()) {
	 * DUMMY_BEAN.setUI_M_PC_SYS_ID(resultSet3.getLong(1)); } resultSet5 =
	 * handler.executeSelectStatement(CURSOR_5, connection, new Object[] {
	 * polsysId, DUMMY_BEAN.getUI_M_PC_SYS_ID() }); if (resultSet5.next()) {
	 * M_PC_PREM_TYPE = resultSet5.getString(1); } if
	 * ("R".equals(M_PC_PREM_TYPE)) { throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "93259")); }
	 * 
	 * 
	 * P10ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(polsysId,
	 * DUMMY_BEAN.getUI_M_PC_SYS_ID() );
	 * 
	 * CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
	 * .getUI_M_PC_SYS_ID()); // POST; // EXECUTE_QUERY;
	 * 
	 * compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_PAID_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT()); } } catch (DBException e) {
	 * e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
	 * finally { try { CommonUtils.closeCursor(resultSet); } catch (Exception e) { }
	 * try { CommonUtils.closeCursor(resultSet2); } catch (Exception e) { } try {
	 * CommonUtils.closeCursor(resultSet3); } catch (Exception e) { } try {
	 * CommonUtils.closeCursor(resultSet4); } catch (Exception e) { } try {
	 * CommonUtils.closeCursor(resultSet5); } catch (Exception e) { } } }
	 */

	/*
	 * public void whenButtonPressM_BUT_ALLOCATE() { Connection connection =
	 * null; ResultSet resultSet = null, resultSet3 = null, resultSet4 = null,
	 * resultSet5 = null, resultSet6 = null, resultSet7 = null; Double
	 * M_TOT_AMT_PAYABLE = null; String M_PROD_BROK_CALC_MTHD = null; String
	 * M_INCL_YN = null; String M_PROD_TOPUP_YN = null; Integer
	 * M_PROD_TOPUP_MIN_YRS = null; Double M_PROD_TOPUP_LC_MIN_AMT = null;
	 * Double M_PROD_TOPUP_LC_MAX_AMT = null; Date M_APPL_DT = null; Double
	 * M_PMPC_FC_PAID_AMT = null; Double M_TOTAL_PMPC_PAID_AMT = null; String
	 * M_POL_MODE_OF_PYMT = null;
	 * 
	 * String CURSOR_1 = "SELECT PROD_BROK_CALC_MTHD FROM PM_IL_PRODUCT " + "
	 * WHERE PROD_CODE = (SELECT POL_PROD_CODE " + " FROM PT_IL_POLICY WHERE
	 * POL_SYS_ID = :PT_IL_PREM_COLL.PC_POL_SYS_ID) ";
	 * 
	 * String CURSOR_3 = " SELECT
	 * SUM(NVL(PCC_FC_CHARGE_AMT,0)),SUM(NVL(PCC_LC_CHARGE_AMT,0))" + " FROM
	 * PT_IL_PREM_COLL_CHARGE " + " WHERE PCC_PMPC_SYS_ID = :DUMMY.M_PMPC_SYS_ID " + "
	 * AND PCC_RISK_CONTR_FLAG = 'I' ";
	 * 
	 * String CURSOR_4 = "SELECT PMPC_FC_PAID_AMT, PMPC_LC_PAID_AMT FROM
	 * PT_IL_MULTI_PREM_COLL " + " WHERE PMPC_SYS_ID = :DUMMY.M_PMPC_SYS_ID " + "
	 * AND PMPC_PAID_FLAG = 'Y' ";
	 * 
	 * String CURSOR_5 = " SELECT
	 * PROD_TOPUP_YN,PROD_TOPUP_MIN_YRS,PROD_TOPUP_LC_MIN_AMT,PROD_TOPUP_LC_MAX_AMT" + "
	 * FROM PM_IL_PRODUCT WHERE PROD_CODE = :PT_IL_POLICY.POL_PROD_CODE ";
	 * 
	 * String CURSOR_6 = " SELECT
	 * ADD_MONTHS(:PT_IL_POLICY.POL_ISSUE_DT,M_PROD_TOPUP_MIN_YRS) FROM DUAL ";
	 * 
	 * String CURSOR_7 = "SELECT POL_MODE_OF_PYMT FROM PT_IL_POLICY WHERE
	 * POL_SYS_ID= :PT_IL_PREM_COLL.PC_POL_SYS_ID ";
	 * 
	 * try { connection = CommonUtils.getConnection(); } catch (DBException e) {
	 * e.printStackTrace(); } }
	 */

	// added by akash
	public void whenButtonPressM_BUT_NEXT() {
		Double M_PC_LC_BAL_GROSS_PREM = null;
		Double M_PC_FC_BAL_GROSS_PREM = null;
		Double M_PC_FC_BAL_BASIC_PREM = null;
		Double M_PC_LC_BAL_BASIC_PREM = null;
		Double M_PC_FC_BAL_ADDL_PREM = null;
		Double M_PC_LC_BAL_ADDL_PREM = null;
		Double M_PC_FC_BAL_LOAD_AMT = null;
		Double M_PC_LC_BAL_LOAD_AMT = null;
		Double M_PC_LC_BAL_DISC = null;
		Double M_PC_FC_BAL_DISC = null;
		Double M_PC_LC_BAL_COMP_CHRG = null;
		Double M_PC_FC_BAL_COMP_CHRG = null;
		Double M_PC_FC_BAL_CUST_CHRG = null;
		Double M_PC_LC_BAL_CUST_CHRG = null;
		Double M_PC_FC_BAL_CONTR = null;
		Double M_PC_LC_BAL_CONTR = null;
		Long M_PC_SYS_ID = null;
		String M_PC_PREM_TYPE = null;
		Long polsysId = null;
		Long pcSysId = null;
		Connection connection = null;
		ResultSet resultSet = null, resultSet2 = null, resultSet3 = null, resultSet4 = null, resultSet5 = null;
		CRUDHandler handler = new CRUDHandler();
		String CURSOR_1 = "	 SELECT MIN(PC_SYS_ID) 	 FROM   PT_IL_PREM_COLL "
				+ "	 WHERE  PC_POL_SYS_ID = ?	 AND	  PC_PAID_FLAG != 'A' ";

		String CURSOR_2 = "SELECT NVL(PC_LC_BAL_GROSS_PREM,0), NVL(PC_FC_BAL_GROSS_PREM,0), NVL(PC_FC_BAL_BASIC_PREM,0),"
				+ "	NVL(PC_LC_BAL_BASIC_PREM,0), NVL(PC_FC_BAL_ADDL_PREM,0), NVL(PC_LC_BAL_ADDL_PREM,0), "
				+ "	NVL(PC_FC_BAL_LOAD_AMT,0), NVL(PC_LC_BAL_LOAD_AMT,0), NVL(PC_LC_BAL_DISC,0), "
				+ " NVL(PC_FC_BAL_DISC,0), NVL(PC_LC_BAL_COMP_CHRG,0), NVL(PC_FC_BAL_COMP_CHRG,0), "
				+ " NVL(PC_FC_BAL_CUST_CHRG,0), NVL(PC_LC_BAL_CUST_CHRG,0), NVL(PC_FC_BAL_CONTR,0), "
				+ " NVL(PC_LC_BAL_CONTR,0) FROM   PT_IL_PREM_COLL"
				+ " WHERE  PC_POL_SYS_ID = ?  AND	PC_SYS_ID= ? ";

		String CURSOR_3 = " SELECT MAX(PC_SYS_ID) 	 FROM   PT_IL_PREM_COLL WHERE  PC_SYS_ID < ( "
				+ " SELECT MIN(PC_SYS_ID)  FROM   PT_IL_PREM_COLL  "
				+ " WHERE  PC_POL_SYS_ID = ?	 AND	  PC_PAID_FLAG != 'A')";

		String CURSOR_4 = " SELECT MIN(PC_SYS_ID)  FROM   PT_IL_PREM_COLL  WHERE  "
				+ " PC_POL_SYS_ID = ? "
				+ "	 AND		PC_PAID_FLAG 		  = 'A' "
				+ "	 AND	 	(PC_LC_BAL_GROSS_PREM != 0"
				+ "	 OR			PC_FC_BAL_GROSS_PREM != 0"
				+ " 	 OR 		PC_FC_BAL_BASIC_PREM != 0 "
				+ "	 OR			PC_LC_BAL_BASIC_PREM != 0 "
				+ "	 OR			PC_FC_BAL_ADDL_PREM	 != 0 "
				+ "	 OR			PC_LC_BAL_ADDL_PREM	 != 0 "
				+ "	 OR			PC_FC_BAL_LOAD_AMT	 != 0 "
				+ "	 OR			PC_LC_BAL_LOAD_AMT	 != 0 "
				+ "	 OR			PC_LC_BAL_DISC		 != 0 "
				+ "	 OR			PC_FC_BAL_DISC		 != 0 "
				+ "	 OR			PC_LC_BAL_COMP_CHRG	 != 0 "
				+ "	 OR			PC_FC_BAL_COMP_CHRG	 != 0 "
				+ "	 OR			PC_FC_BAL_CUST_CHRG	 != 0 "
				+ "	 OR			PC_LC_BAL_CUST_CHRG	 != 0 "
				+ "	 OR			PC_FC_BAL_CONTR		 != 0 "
				+ "	 OR			PC_LC_BAL_CONTR 	 != 0) ";

		String CURSOR_5 = "  SELECT PC_PREM_TYPE  FROM PT_IL_PREM_COLL  "
				+ " WHERE	PC_POL_SYS_ID = ?  " + "   AND		PC_SYS_ID = ? ";

		try {
			connection = CommonUtils.getConnection();
			polsysId = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
			pcSysId = compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
					.getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID();
			if (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getUI_M_PAID_DT() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80264"));
			}

			resultSet2 = handler.executeSelectStatement(CURSOR_2, connection,
					new Object[] { polsysId, pcSysId });
			if (resultSet2.next()) {
				M_PC_LC_BAL_GROSS_PREM = resultSet2.getDouble(1);
				M_PC_FC_BAL_GROSS_PREM = resultSet2.getDouble(2);
				M_PC_FC_BAL_BASIC_PREM = resultSet2.getDouble(3);
				M_PC_LC_BAL_BASIC_PREM = resultSet2.getDouble(4);
				M_PC_FC_BAL_ADDL_PREM = resultSet2.getDouble(5);
				M_PC_LC_BAL_ADDL_PREM = resultSet2.getDouble(6);
				M_PC_FC_BAL_LOAD_AMT = resultSet2.getDouble(7);
				M_PC_LC_BAL_LOAD_AMT = resultSet2.getDouble(8);
				M_PC_LC_BAL_DISC = resultSet2.getDouble(9);
				M_PC_FC_BAL_DISC = resultSet2.getDouble(10);
				M_PC_LC_BAL_COMP_CHRG = resultSet2.getDouble(11);
				M_PC_FC_BAL_COMP_CHRG = resultSet2.getDouble(12);
				M_PC_FC_BAL_CUST_CHRG = resultSet2.getDouble(13);
				M_PC_LC_BAL_CUST_CHRG = resultSet2.getDouble(14);
				M_PC_FC_BAL_CONTR = resultSet2.getDouble(15);
				M_PC_LC_BAL_CONTR = resultSet2.getDouble(16);
			}

			if (M_PC_LC_BAL_GROSS_PREM == 0 && M_PC_FC_BAL_GROSS_PREM == 0
					&& M_PC_FC_BAL_BASIC_PREM == 0
					&& M_PC_LC_BAL_BASIC_PREM == 0
					&& M_PC_FC_BAL_ADDL_PREM == 0 && M_PC_LC_BAL_ADDL_PREM == 0
					&& M_PC_FC_BAL_LOAD_AMT == 0 && M_PC_LC_BAL_LOAD_AMT == 0
					&& M_PC_LC_BAL_DISC == 0 && M_PC_FC_BAL_DISC == 0
					&& M_PC_LC_BAL_COMP_CHRG == 0 && M_PC_FC_BAL_COMP_CHRG == 0
					&& M_PC_FC_BAL_CUST_CHRG == 0 && M_PC_LC_BAL_CUST_CHRG == 0
					&& M_PC_FC_BAL_CONTR == 0 && M_PC_LC_BAL_CONTR == 0) {
				resultSet4 = handler.executeSelectStatement(CURSOR_4,
						connection, new Object[] { polsysId });
				if (resultSet4.next()) {
					M_PC_SYS_ID = resultSet4.getLong(1);
				}
				if (M_PC_SYS_ID != null) {
					DUMMY_BEAN.setUI_M_PC_SYS_ID(M_PC_SYS_ID);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_1,
							connection, new Object[] { polsysId });
					if (resultSet.next()) {
						M_PC_SYS_ID = resultSet.getLong(1);
						DUMMY_BEAN.setUI_M_PC_SYS_ID(M_PC_SYS_ID);
					}
				}

				resultSet5 = handler.executeSelectStatement(CURSOR_5,
						connection, new Object[] { polsysId,
								DUMMY_BEAN.getUI_M_PC_SYS_ID() });
				if (resultSet5.next()) {
					M_PC_PREM_TYPE = resultSet5.getString(1);
				}
				if ("R".equals(M_PC_PREM_TYPE)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "93259"));
				}
				// P10ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(polsysId,DUMMY_BEAN.getUI_M_PC_SYS_ID());
				CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
						.getUI_M_PC_SYS_ID());
				// TODO
				// P10ILPK_INVEST_PREM_COLL.CALC_DUE_AMOUNTS(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				// .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT());
				// POST;
				// EXECUTE_QUERY;
				/*
				 * compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_PAID_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				 * .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT());
				 */
			} else {
				resultSet3 = handler.executeSelectStatement(CURSOR_3,
						connection, new Object[] { polsysId });
				if (resultSet3.next()) {
					DUMMY_BEAN.setUI_M_PC_SYS_ID(resultSet3.getLong(1));
				}
				resultSet5 = handler.executeSelectStatement(CURSOR_5,
						connection, new Object[] { polsysId,
								DUMMY_BEAN.getUI_M_PC_SYS_ID() });
				if (resultSet5.next()) {
					M_PC_PREM_TYPE = resultSet5.getString(1);
				}
				if ("R".equals(M_PC_PREM_TYPE)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "93259"));
				}

				// P10ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(polsysId,
				// DUMMY_BEAN.getUI_M_PC_SYS_ID() );
				CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN
						.getUI_M_PC_SYS_ID());
				// POST;
				// EXECUTE_QUERY;
				/*
				 * TODO
				 * compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_PAID_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				 * .getPT_IL_POLICY_BEAN().getUI_M_PAID_DT());
				 */
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet5);
			} catch (Exception e) {
			}
		}
	}

	

	public AjaxCommandButton getCOMP_UI_M_BUT_GET_DETAILS() {
		return COMP_UI_M_BUT_GET_DETAILS;
	}

	public void setCOMP_UI_M_BUT_GET_DETAILS(
			AjaxCommandButton comp_ui_m_but_get_details) {
		COMP_UI_M_BUT_GET_DETAILS = comp_ui_m_but_get_details;
	}

	public void but_get_details_action(ActionEvent event) {
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().clear();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().clear();
		try {
			helper.whenButPressedGetDetails(compositeAction);
			getCOMP_UI_M_FC_TOBE_PAID_AMOUNT().setSubmittedValue(
					String.valueOf(DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT()));
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
					.getCOMP_PC_SCHD_PYMT_DT().setSubmittedValue(
							(Date) compositeAction
									.getPT_IL_PREM_COLL_ACTION_BEAN()
									.getPT_IL_PREM_COLL_BEAN()
									.getPC_SCHD_PYMT_DT());
			getCOMP_UI_M_INV_FC_CHARGES().resetValue();
			getCOMP_UI_M_INV_LC_CHARGES().resetValue();
			getCOMP_UI_M_NET_PYMT_FC_AMT().resetValue();
			getCOMP_UI_M_NET_PYMT_LC_AMT().resetValue();
			
			/*Added by Ameen on 16-05-2017 as per Gaurav sugg.*/
			COMP_UI_M_FC_DUE_AMOUNT.resetValue();
			COMP_UI_M_FC_PAID_AMOUNT.resetValue();
			COMP_UI_M_LC_PAID_AMOUNT.resetValue();
			COMP_UI_M_LC_TOBE_PAID_AMOUNT.resetValue();
			COMP_UI_M_FC_DUE_AMOUNT.resetValue();
			COMP_UI_M_LC_DUE_AMOUNT.resetValue();
			COMP_UI_M_BUT_INVEST_DETAILS.setDisabled(false);
			
			
			// getCOMP_UI_M_FC_TOBE_PAID_AMOUNT().resetValue();
			// getCOMP_UI_M_LC_TOBE_PAID_AMOUNT().resetValue();
			/*Added by Ameen on 17-05-2017*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Details get Successfully");
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, 
					"Details get Successfully");
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			/*Added by Ameen on 17-05-2017*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("addRow", e.getMessage());
			/*End*/
		}
	}

	public void but_allocate_action(ActionEvent event) {
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().clear();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().clear();
		try {
			System.out.println("--haneef-allocate");
			helper.whenButtonPressM_BUT_ALLOCATE(compositeAction);
			new PT_IL_PREM_COLL_DELEGATE().executeSelectStatement(compositeAction);
			new PT_IL_MULTI_PREM_COLL_DELEGATE().executeSelectStatement(compositeAction);
			new PT_IL_PREM_COLL_BREAKUP_DELEGATE().executeSelectStatement(compositeAction);
			/*Added by Ameen on 17-05-2017*/
			COMP_UI_M_BUT_PYMT_DTLS.setDisabled(false);
			COMP_UI_M_BUT_RNEW_PREM_COLL.setDisabled(false);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().setAllocateFlag(true);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_PAID_DT().setDisabled(true);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_SCHD_PYMT_DT().setDisabled(true);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_WAIVE_PREM_YN().setDisabled(true);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_WAIVE_LOAN_YN().setDisabled(true);
			
			COMP_GET_DETAILS_BTN.setDisabled(true);
			COMP_UI_M_FC_TOBE_PAID_AMOUNT.setDisabled(true);
			COMP_UI_M_LC_TOBE_PAID_AMOUNT.setDisabled(true);
			
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Allocate Done Successfully");
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, 
					"Allocate Done Successfully");
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("addRow", e.getMessage());
		}
	}
	
	private HtmlAjaxCommandButton COMP_ALLOCATE_BTN;
	private HtmlAjaxCommandButton COMP_GET_DETAILS_BTN;
	
	public HtmlAjaxCommandButton getCOMP_ALLOCATE_BTN() {
		return COMP_ALLOCATE_BTN;
	}

	public void setCOMP_ALLOCATE_BTN(HtmlAjaxCommandButton cOMP_ALLOCATE_BTN) {
		COMP_ALLOCATE_BTN = cOMP_ALLOCATE_BTN;
	}

	public HtmlAjaxCommandButton getCOMP_GET_DETAILS_BTN() {
		return COMP_GET_DETAILS_BTN;
	}

	public void setCOMP_GET_DETAILS_BTN(HtmlAjaxCommandButton cOMP_GET_DETAILS_BTN) {
		COMP_GET_DETAILS_BTN = cOMP_GET_DETAILS_BTN;
	}

	public void validatorUI_M_FC_TOBE_PAID_AMOUNT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		try {
			DUMMY_BEAN.setUI_M_FC_TOBE_PAID_AMOUNT((Double) value);
			/*Added by Ameen on 26-05-2017 as per gaurav sugg.*/
			DUMMY_BEAN.setUI_M_LC_TOBE_PAID_AMOUNT(DUMMY_BEAN.getUI_M_FC_TOBE_PAID_AMOUNT());
			COMP_UI_M_LC_TOBE_PAID_AMOUNT.resetValue();
			COMP_UI_M_LC_TOBE_PAID_AMOUNT.setDisabled(true);
			/*End*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validatorUI_M_LC_TOBE_PAID_AMOUNT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		try {
			DUMMY_BEAN.setUI_M_LC_TOBE_PAID_AMOUNT((Double) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	/*Added by Ameen on 30-05-2017 as per gaurav sugg.*/
	public void validatorUI_M_FC_UNPAID_PREM_INT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		try {
			DUMMY_BEAN.setUI_M_FC_UNPAID_PREM_INT((Double) value);
			DUMMY_BEAN.setUI_M_LC_UNPAID_PREM_INT(DUMMY_BEAN.getUI_M_FC_UNPAID_PREM_INT());
			COMP_UI_M_LC_UNPAID_PREM_INT.resetValue();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	/*End*/
}
