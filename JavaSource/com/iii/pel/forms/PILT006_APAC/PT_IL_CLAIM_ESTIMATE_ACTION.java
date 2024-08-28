package com.iii.pel.forms.PILT006_APAC;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_ESTIMATE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CE_FC_PREM_OS_LABEL;

	private HtmlInputText COMP_CE_FC_PREM_OS;

	private HtmlOutputLabel COMP_CE_LC_PREM_OS_LABEL;

	private HtmlInputText COMP_CE_LC_PREM_OS;

	private HtmlOutputLabel COMP_CE_FC_PREM_OS_INT_LABEL;

	private HtmlInputText COMP_CE_FC_PREM_OS_INT;

	private HtmlOutputLabel COMP_CE_LC_PREM_OS_INT_LABEL;

	private HtmlInputText COMP_CE_LC_PREM_OS_INT;

	private HtmlOutputLabel COMP_CE_FC_LOAN_OS_LABEL;

	private HtmlInputText COMP_CE_FC_LOAN_OS;

	private HtmlOutputLabel COMP_CE_LC_LOAN_OS_LABEL;

	private HtmlInputText COMP_CE_LC_LOAN_OS;

	private HtmlOutputLabel COMP_CE_FC_LOAN_INT_LABEL;

	private HtmlInputText COMP_CE_FC_LOAN_INT;

	private HtmlOutputLabel COMP_CE_LC_LOAN_INT_LABEL;

	private HtmlInputText COMP_CE_LC_LOAN_INT;

	private HtmlOutputLabel COMP_CE_FC_DEDB_AMT_LABEL;

	private HtmlInputText COMP_CE_FC_DEDB_AMT;

	private HtmlOutputLabel COMP_CE_LC_DEDB_AMT_LABEL;

	private HtmlInputText COMP_CE_LC_DEDB_AMT;

	private HtmlOutputLabel COMP_CE_FC_EST_AMT_LABEL;

	private HtmlInputText COMP_CE_FC_EST_AMT;

	private HtmlOutputLabel COMP_CE_LC_EST_AMT_LABEL;

	private HtmlInputText COMP_CE_LC_EST_AMT;

	private HtmlOutputLabel COMP_UI_M_CE_FC_EST_TOT_DED_LABEL;

	private HtmlInputText COMP_UI_M_CE_FC_EST_TOT_DED;

	private HtmlOutputLabel COMP_UI_M_CE_LC_EST_TOT_DED_LABEL;

	private HtmlInputText COMP_UI_M_CE_LC_EST_TOT_DED;

	private HtmlOutputLabel COMP_CE_FC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_CE_FC_ACC_PROFIT;

	private HtmlOutputLabel COMP_CE_LC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_CE_LC_ACC_PROFIT;

	private HtmlOutputLabel COMP_CE_FC_NET_EST_AMT_LABEL;

	private HtmlInputText COMP_CE_FC_NET_EST_AMT;

	private HtmlOutputLabel COMP_CE_LC_NET_EST_AMT_LABEL;

	private HtmlInputText COMP_CE_LC_NET_EST_AMT;

	private HtmlOutputLabel COMP_CE_REMARKS_LABEL;

	private HtmlInputText COMP_CE_REMARKS;

	private HtmlOutputLabel COMP_CE_UNIT_LC_AMT_LABEL;

	private HtmlInputText COMP_CE_UNIT_LC_AMT;

	private HtmlOutputLabel COMP_CE_UNIT_FC_AMT_LABEL;

	private HtmlInputText COMP_CE_UNIT_FC_AMT;

	private HtmlOutputLabel COMP_CE_REF_NO_LABEL;

	private HtmlInputText COMP_CE_REF_NO;

	private HtmlOutputLabel COMP_CE_SETL_START_DT_LABEL;

	private HtmlCalendar COMP_CE_SETL_START_DT;

	private PT_IL_CLAIM_ESTIMATE PT_IL_CLAIM_ESTIMATE_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_ESTIMATE_HELPER helper;
	
	
	
	/*Added by sankara narayanan for adding the binding cor save button on 08/03/2017*/
	
	private HtmlCommandLink COMP_SAVE_COMMAND_LINK;

	private HtmlCommandButton COMP_SAVE_BUTTON;
	
	
	
	public HtmlCommandLink getCOMP_SAVE_COMMAND_LINK() {
		return COMP_SAVE_COMMAND_LINK;
	}

	public void setCOMP_SAVE_COMMAND_LINK(HtmlCommandLink cOMP_SAVE_COMMAND_LINK) {
		COMP_SAVE_COMMAND_LINK = cOMP_SAVE_COMMAND_LINK;
	}

	public HtmlCommandButton getCOMP_SAVE_BUTTON() {
		return COMP_SAVE_BUTTON;
	}

	public void setCOMP_SAVE_BUTTON(HtmlCommandButton cOMP_SAVE_BUTTON) {
		COMP_SAVE_BUTTON = cOMP_SAVE_BUTTON;
	}

	
	/*end*/
	public PT_IL_CLAIM_ESTIMATE_ACTION() {
		PT_IL_CLAIM_ESTIMATE_BEAN = new PT_IL_CLAIM_ESTIMATE();
		helper = new PT_IL_CLAIM_ESTIMATE_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_CE_FC_PREM_OS_LABEL() {
		return COMP_CE_FC_PREM_OS_LABEL;
	}

	public void setCOMP_CE_FC_PREM_OS_LABEL(HtmlOutputLabel comp_ce_fc_prem_os_label) {
		COMP_CE_FC_PREM_OS_LABEL = comp_ce_fc_prem_os_label;
	}

	public HtmlInputText getCOMP_CE_FC_PREM_OS() {
		return COMP_CE_FC_PREM_OS;
	}

	public void setCOMP_CE_FC_PREM_OS(HtmlInputText comp_ce_fc_prem_os) {
		COMP_CE_FC_PREM_OS = comp_ce_fc_prem_os;
	}

	public HtmlOutputLabel getCOMP_CE_LC_PREM_OS_LABEL() {
		return COMP_CE_LC_PREM_OS_LABEL;
	}

	public void setCOMP_CE_LC_PREM_OS_LABEL(HtmlOutputLabel comp_ce_lc_prem_os_label) {
		COMP_CE_LC_PREM_OS_LABEL = comp_ce_lc_prem_os_label;
	}

	public HtmlInputText getCOMP_CE_LC_PREM_OS() {
		return COMP_CE_LC_PREM_OS;
	}

	public void setCOMP_CE_LC_PREM_OS(HtmlInputText comp_ce_lc_prem_os) {
		COMP_CE_LC_PREM_OS = comp_ce_lc_prem_os;
	}

	public HtmlOutputLabel getCOMP_CE_FC_PREM_OS_INT_LABEL() {
		return COMP_CE_FC_PREM_OS_INT_LABEL;
	}

	public void setCOMP_CE_FC_PREM_OS_INT_LABEL(
			HtmlOutputLabel comp_ce_fc_prem_os_int_label) {
		COMP_CE_FC_PREM_OS_INT_LABEL = comp_ce_fc_prem_os_int_label;
	}

	public HtmlInputText getCOMP_CE_FC_PREM_OS_INT() {
		return COMP_CE_FC_PREM_OS_INT;
	}

	public void setCOMP_CE_FC_PREM_OS_INT(HtmlInputText comp_ce_fc_prem_os_int) {
		COMP_CE_FC_PREM_OS_INT = comp_ce_fc_prem_os_int;
	}

	public HtmlOutputLabel getCOMP_CE_LC_PREM_OS_INT_LABEL() {
		return COMP_CE_LC_PREM_OS_INT_LABEL;
	}

	public void setCOMP_CE_LC_PREM_OS_INT_LABEL(
			HtmlOutputLabel comp_ce_lc_prem_os_int_label) {
		COMP_CE_LC_PREM_OS_INT_LABEL = comp_ce_lc_prem_os_int_label;
	}

	public HtmlInputText getCOMP_CE_LC_PREM_OS_INT() {
		return COMP_CE_LC_PREM_OS_INT;
	}

	public void setCOMP_CE_LC_PREM_OS_INT(HtmlInputText comp_ce_lc_prem_os_int) {
		COMP_CE_LC_PREM_OS_INT = comp_ce_lc_prem_os_int;
	}

	public HtmlOutputLabel getCOMP_CE_FC_LOAN_OS_LABEL() {
		return COMP_CE_FC_LOAN_OS_LABEL;
	}

	public void setCOMP_CE_FC_LOAN_OS_LABEL(HtmlOutputLabel comp_ce_fc_loan_os_label) {
		COMP_CE_FC_LOAN_OS_LABEL = comp_ce_fc_loan_os_label;
	}

	public HtmlInputText getCOMP_CE_FC_LOAN_OS() {
		return COMP_CE_FC_LOAN_OS;
	}

	public void setCOMP_CE_FC_LOAN_OS(HtmlInputText comp_ce_fc_loan_os) {
		COMP_CE_FC_LOAN_OS = comp_ce_fc_loan_os;
	}

	public HtmlOutputLabel getCOMP_CE_LC_LOAN_OS_LABEL() {
		return COMP_CE_LC_LOAN_OS_LABEL;
	}

	public void setCOMP_CE_LC_LOAN_OS_LABEL(HtmlOutputLabel comp_ce_lc_loan_os_label) {
		COMP_CE_LC_LOAN_OS_LABEL = comp_ce_lc_loan_os_label;
	}

	public HtmlInputText getCOMP_CE_LC_LOAN_OS() {
		return COMP_CE_LC_LOAN_OS;
	}

	public void setCOMP_CE_LC_LOAN_OS(HtmlInputText comp_ce_lc_loan_os) {
		COMP_CE_LC_LOAN_OS = comp_ce_lc_loan_os;
	}

	public HtmlOutputLabel getCOMP_CE_FC_LOAN_INT_LABEL() {
		return COMP_CE_FC_LOAN_INT_LABEL;
	}

	public void setCOMP_CE_FC_LOAN_INT_LABEL(
			HtmlOutputLabel comp_ce_fc_loan_int_label) {
		COMP_CE_FC_LOAN_INT_LABEL = comp_ce_fc_loan_int_label;
	}

	public HtmlInputText getCOMP_CE_FC_LOAN_INT() {
		return COMP_CE_FC_LOAN_INT;
	}

	public void setCOMP_CE_FC_LOAN_INT(HtmlInputText comp_ce_fc_loan_int) {
		COMP_CE_FC_LOAN_INT = comp_ce_fc_loan_int;
	}

	public HtmlOutputLabel getCOMP_CE_LC_LOAN_INT_LABEL() {
		return COMP_CE_LC_LOAN_INT_LABEL;
	}

	public void setCOMP_CE_LC_LOAN_INT_LABEL(
			HtmlOutputLabel comp_ce_lc_loan_int_label) {
		COMP_CE_LC_LOAN_INT_LABEL = comp_ce_lc_loan_int_label;
	}

	public HtmlInputText getCOMP_CE_LC_LOAN_INT() {
		return COMP_CE_LC_LOAN_INT;
	}

	public void setCOMP_CE_LC_LOAN_INT(HtmlInputText comp_ce_lc_loan_int) {
		COMP_CE_LC_LOAN_INT = comp_ce_lc_loan_int;
	}

	public HtmlOutputLabel getCOMP_CE_FC_DEDB_AMT_LABEL() {
		return COMP_CE_FC_DEDB_AMT_LABEL;
	}

	public void setCOMP_CE_FC_DEDB_AMT_LABEL(
			HtmlOutputLabel comp_ce_fc_dedb_amt_label) {
		COMP_CE_FC_DEDB_AMT_LABEL = comp_ce_fc_dedb_amt_label;
	}

	public HtmlInputText getCOMP_CE_FC_DEDB_AMT() {
		return COMP_CE_FC_DEDB_AMT;
	}

	public void setCOMP_CE_FC_DEDB_AMT(HtmlInputText comp_ce_fc_dedb_amt) {
		COMP_CE_FC_DEDB_AMT = comp_ce_fc_dedb_amt;
	}

	public HtmlOutputLabel getCOMP_CE_LC_DEDB_AMT_LABEL() {
		return COMP_CE_LC_DEDB_AMT_LABEL;
	}

	public void setCOMP_CE_LC_DEDB_AMT_LABEL(
			HtmlOutputLabel comp_ce_lc_dedb_amt_label) {
		COMP_CE_LC_DEDB_AMT_LABEL = comp_ce_lc_dedb_amt_label;
	}

	public HtmlInputText getCOMP_CE_LC_DEDB_AMT() {
		return COMP_CE_LC_DEDB_AMT;
	}

	public void setCOMP_CE_LC_DEDB_AMT(HtmlInputText comp_ce_lc_dedb_amt) {
		COMP_CE_LC_DEDB_AMT = comp_ce_lc_dedb_amt;
	}

	public HtmlOutputLabel getCOMP_CE_FC_EST_AMT_LABEL() {
		return COMP_CE_FC_EST_AMT_LABEL;
	}

	public void setCOMP_CE_FC_EST_AMT_LABEL(HtmlOutputLabel comp_ce_fc_est_amt_label) {
		COMP_CE_FC_EST_AMT_LABEL = comp_ce_fc_est_amt_label;
	}

	public HtmlInputText getCOMP_CE_FC_EST_AMT() {
		return COMP_CE_FC_EST_AMT;
	}

	public void setCOMP_CE_FC_EST_AMT(HtmlInputText comp_ce_fc_est_amt) {
		COMP_CE_FC_EST_AMT = comp_ce_fc_est_amt;
	}

	public HtmlOutputLabel getCOMP_CE_LC_EST_AMT_LABEL() {
		return COMP_CE_LC_EST_AMT_LABEL;
	}

	public void setCOMP_CE_LC_EST_AMT_LABEL(HtmlOutputLabel comp_ce_lc_est_amt_label) {
		COMP_CE_LC_EST_AMT_LABEL = comp_ce_lc_est_amt_label;
	}

	public HtmlInputText getCOMP_CE_LC_EST_AMT() {
		return COMP_CE_LC_EST_AMT;
	}

	public void setCOMP_CE_LC_EST_AMT(HtmlInputText comp_ce_lc_est_amt) {
		COMP_CE_LC_EST_AMT = comp_ce_lc_est_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_CE_FC_EST_TOT_DED_LABEL() {
		return COMP_UI_M_CE_FC_EST_TOT_DED_LABEL;
	}

	public void setCOMP_UI_M_CE_FC_EST_TOT_DED_LABEL(
			HtmlOutputLabel comp_ui_m_ce_fc_est_tot_ded_label) {
		COMP_UI_M_CE_FC_EST_TOT_DED_LABEL = comp_ui_m_ce_fc_est_tot_ded_label;
	}

	public HtmlInputText getCOMP_UI_M_CE_FC_EST_TOT_DED() {
		return COMP_UI_M_CE_FC_EST_TOT_DED;
	}

	public void setCOMP_UI_M_CE_FC_EST_TOT_DED(
			HtmlInputText comp_ui_m_ce_fc_est_tot_ded) {
		COMP_UI_M_CE_FC_EST_TOT_DED = comp_ui_m_ce_fc_est_tot_ded;
	}

	public HtmlOutputLabel getCOMP_UI_M_CE_LC_EST_TOT_DED_LABEL() {
		return COMP_UI_M_CE_LC_EST_TOT_DED_LABEL;
	}

	public void setCOMP_UI_M_CE_LC_EST_TOT_DED_LABEL(
			HtmlOutputLabel comp_ui_m_ce_lc_est_tot_ded_label) {
		COMP_UI_M_CE_LC_EST_TOT_DED_LABEL = comp_ui_m_ce_lc_est_tot_ded_label;
	}

	public HtmlInputText getCOMP_UI_M_CE_LC_EST_TOT_DED() {
		return COMP_UI_M_CE_LC_EST_TOT_DED;
	}

	public void setCOMP_UI_M_CE_LC_EST_TOT_DED(
			HtmlInputText comp_ui_m_ce_lc_est_tot_ded) {
		COMP_UI_M_CE_LC_EST_TOT_DED = comp_ui_m_ce_lc_est_tot_ded;
	}

	public HtmlOutputLabel getCOMP_CE_FC_ACC_PROFIT_LABEL() {
		return COMP_CE_FC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_CE_FC_ACC_PROFIT_LABEL(
			HtmlOutputLabel comp_ce_fc_acc_profit_label) {
		COMP_CE_FC_ACC_PROFIT_LABEL = comp_ce_fc_acc_profit_label;
	}

	public HtmlInputText getCOMP_CE_FC_ACC_PROFIT() {
		return COMP_CE_FC_ACC_PROFIT;
	}

	public void setCOMP_CE_FC_ACC_PROFIT(HtmlInputText comp_ce_fc_acc_profit) {
		COMP_CE_FC_ACC_PROFIT = comp_ce_fc_acc_profit;
	}

	public HtmlOutputLabel getCOMP_CE_LC_ACC_PROFIT_LABEL() {
		return COMP_CE_LC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_CE_LC_ACC_PROFIT_LABEL(
			HtmlOutputLabel comp_ce_lc_acc_profit_label) {
		COMP_CE_LC_ACC_PROFIT_LABEL = comp_ce_lc_acc_profit_label;
	}

	public HtmlInputText getCOMP_CE_LC_ACC_PROFIT() {
		return COMP_CE_LC_ACC_PROFIT;
	}

	public void setCOMP_CE_LC_ACC_PROFIT(HtmlInputText comp_ce_lc_acc_profit) {
		COMP_CE_LC_ACC_PROFIT = comp_ce_lc_acc_profit;
	}

	public HtmlOutputLabel getCOMP_CE_FC_NET_EST_AMT_LABEL() {
		return COMP_CE_FC_NET_EST_AMT_LABEL;
	}

	public void setCOMP_CE_FC_NET_EST_AMT_LABEL(
			HtmlOutputLabel comp_ce_fc_net_est_amt_label) {
		COMP_CE_FC_NET_EST_AMT_LABEL = comp_ce_fc_net_est_amt_label;
	}

	public HtmlInputText getCOMP_CE_FC_NET_EST_AMT() {
		return COMP_CE_FC_NET_EST_AMT;
	}

	public void setCOMP_CE_FC_NET_EST_AMT(HtmlInputText comp_ce_fc_net_est_amt) {
		COMP_CE_FC_NET_EST_AMT = comp_ce_fc_net_est_amt;
	}

	public HtmlOutputLabel getCOMP_CE_LC_NET_EST_AMT_LABEL() {
		return COMP_CE_LC_NET_EST_AMT_LABEL;
	}

	public void setCOMP_CE_LC_NET_EST_AMT_LABEL(
			HtmlOutputLabel comp_ce_lc_net_est_amt_label) {
		COMP_CE_LC_NET_EST_AMT_LABEL = comp_ce_lc_net_est_amt_label;
	}

	public HtmlInputText getCOMP_CE_LC_NET_EST_AMT() {
		return COMP_CE_LC_NET_EST_AMT;
	}

	public void setCOMP_CE_LC_NET_EST_AMT(HtmlInputText comp_ce_lc_net_est_amt) {
		COMP_CE_LC_NET_EST_AMT = comp_ce_lc_net_est_amt;
	}

	public HtmlOutputLabel getCOMP_CE_REMARKS_LABEL() {
		return COMP_CE_REMARKS_LABEL;
	}

	public void setCOMP_CE_REMARKS_LABEL(HtmlOutputLabel comp_ce_remarks_label) {
		COMP_CE_REMARKS_LABEL = comp_ce_remarks_label;
	}

	public HtmlInputText getCOMP_CE_REMARKS() {
		return COMP_CE_REMARKS;
	}

	public void setCOMP_CE_REMARKS(HtmlInputText comp_ce_remarks) {
		COMP_CE_REMARKS = comp_ce_remarks;
	}

	public HtmlOutputLabel getCOMP_CE_UNIT_LC_AMT_LABEL() {
		return COMP_CE_UNIT_LC_AMT_LABEL;
	}

	public void setCOMP_CE_UNIT_LC_AMT_LABEL(
			HtmlOutputLabel comp_ce_unit_lc_amt_label) {
		COMP_CE_UNIT_LC_AMT_LABEL = comp_ce_unit_lc_amt_label;
	}

	public HtmlInputText getCOMP_CE_UNIT_LC_AMT() {
		return COMP_CE_UNIT_LC_AMT;
	}

	public void setCOMP_CE_UNIT_LC_AMT(HtmlInputText comp_ce_unit_lc_amt) {
		COMP_CE_UNIT_LC_AMT = comp_ce_unit_lc_amt;
	}

	public HtmlOutputLabel getCOMP_CE_UNIT_FC_AMT_LABEL() {
		return COMP_CE_UNIT_FC_AMT_LABEL;
	}

	public void setCOMP_CE_UNIT_FC_AMT_LABEL(
			HtmlOutputLabel comp_ce_unit_fc_amt_label) {
		COMP_CE_UNIT_FC_AMT_LABEL = comp_ce_unit_fc_amt_label;
	}

	public HtmlInputText getCOMP_CE_UNIT_FC_AMT() {
		return COMP_CE_UNIT_FC_AMT;
	}

	public void setCOMP_CE_UNIT_FC_AMT(HtmlInputText comp_ce_unit_fc_amt) {
		COMP_CE_UNIT_FC_AMT = comp_ce_unit_fc_amt;
	}

	public HtmlOutputLabel getCOMP_CE_REF_NO_LABEL() {
		return COMP_CE_REF_NO_LABEL;
	}

	public void setCOMP_CE_REF_NO_LABEL(HtmlOutputLabel comp_ce_ref_no_label) {
		COMP_CE_REF_NO_LABEL = comp_ce_ref_no_label;
	}

	public HtmlInputText getCOMP_CE_REF_NO() {
		return COMP_CE_REF_NO;
	}

	public void setCOMP_CE_REF_NO(HtmlInputText comp_ce_ref_no) {
		COMP_CE_REF_NO = comp_ce_ref_no;
	}

	public HtmlOutputLabel getCOMP_CE_SETL_START_DT_LABEL() {
		return COMP_CE_SETL_START_DT_LABEL;
	}

	public void setCOMP_CE_SETL_START_DT_LABEL(
			HtmlOutputLabel comp_ce_setl_start_dt_label) {
		COMP_CE_SETL_START_DT_LABEL = comp_ce_setl_start_dt_label;
	}

	public HtmlCalendar getCOMP_CE_SETL_START_DT() {
		return COMP_CE_SETL_START_DT;
	}

	public void setCOMP_CE_SETL_START_DT(HtmlCalendar comp_ce_setl_start_dt) {
		COMP_CE_SETL_START_DT = comp_ce_setl_start_dt;
	}

	public PT_IL_CLAIM_ESTIMATE getPT_IL_CLAIM_ESTIMATE_BEAN() {
		return PT_IL_CLAIM_ESTIMATE_BEAN;
	}

	public void setPT_IL_CLAIM_ESTIMATE_BEAN(
			PT_IL_CLAIM_ESTIMATE pt_il_claim_estimate_bean) {
		PT_IL_CLAIM_ESTIMATE_BEAN = pt_il_claim_estimate_bean;
	}

	/*Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017 
	private HtmlOutputLabel COMP_CE_FC_FEE_PAID_HOSP_LABEL;
	
	public HtmlOutputLabel getCOMP_CE_FC_FEE_PAID_HOSP_LABEL() {
		return COMP_CE_FC_FEE_PAID_HOSP_LABEL;
	}

	public void setCOMP_CE_FC_FEE_PAID_HOSP_LABEL(
			HtmlOutputLabel cOMP_CE_FC_FEE_PAID_HOSP_LABEL) {
		COMP_CE_FC_FEE_PAID_HOSP_LABEL = cOMP_CE_FC_FEE_PAID_HOSP_LABEL;
	}
	private HtmlInputText COMP_CE_FC_FEE_PAID_HOSP;
	
	public HtmlInputText getCOMP_CE_FC_FEE_PAID_HOSP() {
		return COMP_CE_FC_FEE_PAID_HOSP;
	}

	public void setCOMP_CE_FC_FEE_PAID_HOSP(HtmlInputText cOMP_CE_FC_FEE_PAID_HOSP) {
		COMP_CE_FC_FEE_PAID_HOSP = cOMP_CE_FC_FEE_PAID_HOSP;
	}
	
	private HtmlOutputLabel COMP_CE_LC_FEE_PAID_HOSP_LABEL;
	
	public HtmlOutputLabel getCOMP_CE_LC_FEE_PAID_HOSP_LABEL() {
		return COMP_CE_LC_FEE_PAID_HOSP_LABEL;
	}

	public void setCOMP_CE_LC_FEE_PAID_HOSP_LABEL(
			HtmlOutputLabel cOMP_CE_LC_FEE_PAID_HOSP_LABEL) {
		COMP_CE_LC_FEE_PAID_HOSP_LABEL = cOMP_CE_LC_FEE_PAID_HOSP_LABEL;
	}
	private HtmlInputText COMP_CE_LC_FEE_PAID_HOSP;
	
	public HtmlInputText getCOMP_CE_LC_FEE_PAID_HOSP() {
		return COMP_CE_LC_FEE_PAID_HOSP;
	}

	public void setCOMP_CE_LC_FEE_PAID_HOSP(HtmlInputText cOMP_CE_LC_FEE_PAID_HOSP) {
		COMP_CE_LC_FEE_PAID_HOSP = cOMP_CE_LC_FEE_PAID_HOSP;
	}
	end
	*/
	/*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/ 
	private HtmlOutputLabel COMP_CE_TOTAL_CHRG_AMT_LABEL;
	
	
	public HtmlOutputLabel getCOMP_CE_TOTAL_CHRG_AMT_LABEL() {
		return COMP_CE_TOTAL_CHRG_AMT_LABEL;
	}

	public void setCOMP_CE_TOTAL_CHRG_AMT_LABEL(
			HtmlOutputLabel cOMP_CE_TOTAL_CHRG_AMT_LABEL) {
		COMP_CE_TOTAL_CHRG_AMT_LABEL = cOMP_CE_TOTAL_CHRG_AMT_LABEL;
	}
	private HtmlInputText COMP_CE_TOTAL_CHRG_AMT;
	
	
	public HtmlInputText getCOMP_CE_TOTAL_CHRG_AMT() {
		return COMP_CE_TOTAL_CHRG_AMT;
	}

	public void setCOMP_CE_TOTAL_CHRG_AMT(HtmlInputText cOMP_CE_TOTAL_CHRG_AMT) {
		COMP_CE_TOTAL_CHRG_AMT = cOMP_CE_TOTAL_CHRG_AMT;
	}

	/*END*/
	public String saveRecord() {
		String message = null;
		
		try {
			if (getPT_IL_CLAIM_ESTIMATE_BEAN().getROWID() != null) {
				if(isUPDATE_ALLOWED()){
					helper.preUpdate(PT_IL_CLAIM_ESTIMATE_BEAN, 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
					new CRUDHandler().executeInsert(getPT_IL_CLAIM_ESTIMATE_BEAN(),
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messaggeProperties", "errorPanel$message$update");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put("UPDATE", message);
				}else{
					message = Messages.getString("messaggeProperties", "errorPanel$message$updatenotallowed");
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getErrorMap().put("UPDATE", message);
				}
			} else {
				if(isINSERT_ALLOWED()){
					helper.preInsert(PT_IL_CLAIM_ESTIMATE_BEAN, 
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(),
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
					new CRUDHandler().executeInsert(getPT_IL_CLAIM_ESTIMATE_BEAN(),
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					
					message = Messages.getString("messaggeProperties", "errorPanel$message$save");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put("SAVE", message);
				}else{
					message = Messages.getString("messaggeProperties", "errorPanel$message$insertnotallowed");
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getErrorMap().put("SAVE", message);
				}
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		
		return null;
	}
	
	

	public String deleteRecord(){
		String message = null;
		
		try {
			if(isDELETE_ALLOWED()){
				if(PT_IL_CLAIM_ESTIMATE_BEAN.getROWID() != null){
					helper.preDelete(PT_IL_CLAIM_ESTIMATE_BEAN);
					new CRUDHandler().executeDelete(getPT_IL_CLAIM_ESTIMATE_BEAN(),
							CommonUtils.getConnection());
				}
				
				
				PT_IL_CLAIM_ESTIMATE_BEAN = new PT_IL_CLAIM_ESTIMATE();
				message = Messages.getString("messaggeProperties", "errorPanel$message$delete");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getWarningMap().put("DELETE", message);
			}else{
				message = Messages.getString("messaggeProperties", "errorPanel$message$deletenotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getErrorMap().put("DELETE", message);
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		
		return null;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		ResultSet rs=null;
		String query="SELECT NVL((CONT_LC_POL_DEP_AMT - CONT_LC_POL_UTIL_AMT ),0) EXCESS_AMOUNT "
				+ "FROM PM_IL_CONTRACTOR,PT_IL_CLAIM WHERE CONT_CODE = CLAIM_ASSR_CODE "
				+ "AND CLAIM_POL_SYS_ID = ?";
		
		/*Added by saranya for Additional field Advance Premium on 26/07/2016*/
		ResultSet rs1=null;
		String query2="SELECT SUM(PC_LC_GROSS_PREM + PC_LC_CHARGE)FROM PT_IL_PREM_COLL, PT_IL_CLAIM "
				+ "WHERE PC_POL_SYS_ID = CLAIM_POL_SYS_ID AND CLAIM_SYS_ID =? "
				+ "AND PC_SCHD_PYMT_DT > CLAIM_LOSS_DT AND PC_PAID_DT IS NOT NULL AND PC_PAID_FLAG = 'A'";
		/*end*/
		try {
			if (isBlockFlag()) {
				helper.preBlock(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				helper.whenNewBlockInstance(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
						this, 
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				helper.executeQuery(compositeAction);
				
				/* Added by Janani on 07.08.2017 for ZBILQC-1734156*/
				//helper.postQuery(PT_IL_CLAIM_ESTIMATE_BEAN);
				
				helper.postQuery(PT_IL_CLAIM_ESTIMATE_BEAN,compositeAction);
				
				/*End*/
				
				//newly added query to fetch value for excess amount field as per siva sir sugg. 17-8-16
				Long CLAIM_POL_SYS_ID = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
				System.out.println("CLAIM_POL_SYS_ID ==>>"+CLAIM_POL_SYS_ID);
				rs=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{CLAIM_POL_SYS_ID});
				while(rs.next())
				{
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setUI_M_EXCESS_AMOUNT(rs.getDouble(1));
				}
				/*Added by saranya for Additional field Advance Premium on 26/07/2016*/
			  
				rs1=new CRUDHandler().executeSelectStatement(query2, CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
				while(rs1.next())
				{
					compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setUI_M_ADVANCE_PREMIUM(rs1.getDouble(1));
				}
				/*end*/
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	// Validators
	public void validateCE_SETL_START_DT(FacesContext context, UIComponent component, Object value){
		
		try {
			PT_IL_CLAIM_ESTIMATE_BEAN.setCE_SETL_START_DT((Date) value);
			helper.validateCE_SETL_START_DT(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
					PT_IL_CLAIM_ESTIMATE_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateCE_FC_EST_AMT(FacesContext context, UIComponent component, Object value){
		
		try {
			PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_EST_AMT((Double) value);
			helper.validateCE_FC_EST_AMT(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
					PT_IL_CLAIM_ESTIMATE_BEAN,
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateCE_LC_EST_AMT(FacesContext context, UIComponent component, Object value){
		
		try {
			PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_EST_AMT((Double) value);
			helper.validateCE_LC_EST_AMT(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
					PT_IL_CLAIM_ESTIMATE_BEAN,
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	// Common action listener validateCE_LC_EST_AMT
	public void fierFieldValidation(ActionEvent actionEvent){
		ErrorHelpUtil.validate((UIInput) actionEvent.getComponent().getParent(), getErrorMap());
	}
	public void whenCheckBoxChangedCE_FRZ_FLAG(ActionEvent actionEvent){
		String submittedValue = (String)((UIInput)actionEvent.getComponent().getParent()).getSubmittedValue();
		PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FRZ_FLAG(
				CommonUtils.booleanToStriingConvertor(Boolean.parseBoolean(submittedValue)));
		helper.whenCheckBoxChangedCE_FRZ_FLAG(this,compositeAction);
	}

	/**
	 * Disables all components in PT_IL_CLAIM_ESTIMATE_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_CE_FC_PREM_OS.setDisabled(disabled);
		COMP_CE_LC_PREM_OS.setDisabled(disabled);
		COMP_CE_FC_PREM_OS_INT.setDisabled(disabled);
		COMP_CE_LC_PREM_OS_INT.setDisabled(disabled);
		COMP_CE_FC_LOAN_OS.setDisabled(disabled);
		COMP_CE_LC_LOAN_OS.setDisabled(disabled);
		COMP_CE_FC_LOAN_INT.setDisabled(disabled);
		COMP_CE_LC_LOAN_INT.setDisabled(disabled);
		COMP_CE_FC_EST_AMT.setDisabled(disabled);
		COMP_CE_LC_EST_AMT.setDisabled(disabled);
		COMP_UI_M_CE_FC_EST_TOT_DED.setDisabled(disabled);
		COMP_UI_M_CE_LC_EST_TOT_DED.setDisabled(disabled);
		COMP_CE_FC_ACC_PROFIT.setDisabled(disabled);
		COMP_CE_LC_ACC_PROFIT.setDisabled(disabled);
		COMP_CE_FC_NET_EST_AMT.setDisabled(disabled);
		COMP_CE_LC_NET_EST_AMT.setDisabled(disabled);
		COMP_CE_REMARKS.setDisabled(disabled);
		COMP_CE_UNIT_LC_AMT.setDisabled(disabled);
		COMP_CE_UNIT_FC_AMT.setDisabled(disabled);
		COMP_CE_REF_NO.setDisabled(disabled);
		
		/*aDDED BY SANARA NARAYANAN FOR DISABLING THE SAVE BUTTON IF THE CLAIME STATUS WAS CLO5 ON 08/03/2017*/
		if("CL05".equalsIgnoreCase(compositeAction
				.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
				.getCLAIM_ADDL_STATUS())) {
			COMP_SAVE_COMMAND_LINK.setDisabled(true);
			COMP_SAVE_BUTTON.setDisabled(true);
		}else{
			COMP_SAVE_COMMAND_LINK.setDisabled(false);
			COMP_SAVE_BUTTON.setDisabled(false);
		} //END 

		// Disabling HtmlCalendar
		COMP_CE_SETL_START_DT.setDisabled(disabled);
		/*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/ 
		COMP_CE_TOTAL_CHRG_AMT.setDisabled(disabled);
		//end
	}

	/**
	 * Instantiates all components in PT_IL_CLAIM_ESTIMATE_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_CE_FC_PREM_OS = new HtmlInputText();
		COMP_CE_LC_PREM_OS = new HtmlInputText();
		COMP_CE_FC_PREM_OS_INT = new HtmlInputText();
		COMP_CE_LC_PREM_OS_INT = new HtmlInputText();
		COMP_CE_FC_LOAN_OS = new HtmlInputText();
		COMP_CE_LC_LOAN_OS = new HtmlInputText();
		COMP_CE_FC_LOAN_INT = new HtmlInputText();
		COMP_CE_LC_LOAN_INT = new HtmlInputText();
		COMP_CE_FC_EST_AMT = new HtmlInputText();
		COMP_CE_LC_EST_AMT = new HtmlInputText();
		COMP_UI_M_CE_FC_EST_TOT_DED = new HtmlInputText();
		COMP_UI_M_CE_LC_EST_TOT_DED = new HtmlInputText();
		COMP_CE_FC_ACC_PROFIT = new HtmlInputText();
		COMP_CE_LC_ACC_PROFIT = new HtmlInputText();
		COMP_CE_FC_NET_EST_AMT = new HtmlInputText();
		COMP_CE_LC_NET_EST_AMT = new HtmlInputText();
		COMP_CE_REMARKS = new HtmlInputText();
		COMP_CE_UNIT_LC_AMT = new HtmlInputText();
		COMP_CE_UNIT_FC_AMT = new HtmlInputText();
		COMP_CE_REF_NO = new HtmlInputText();
		/*added by sankara narayanan on 08/03/2017*/
		COMP_SAVE_COMMAND_LINK= new HtmlCommandLink();
		COMP_SAVE_BUTTON= new HtmlCommandButton();
		//end
		
		/*Added by saranya for Additional field Advance Premium on 26/07/2016*/
		COMP_ADVANCE_PREMIUM=new HtmlInputText();
		COMP_EXCESS_AMOUNT=new HtmlInputText();
		/*end*/
		
		// Instantiating HtmlCalendar
		COMP_CE_SETL_START_DT = new HtmlCalendar();
		/*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/ 
		COMP_CE_TOTAL_CHRG_AMT = new HtmlInputText();
		//end

	}
	
	//EXCESS AMOUNT FIELDS AS PER SIVA SUGG. ADDED BY AMEEN ON 17/08/2016
	
	private HtmlOutputLabel COMP_EXCESS_AMOUNT_LABEL;

	private HtmlInputText COMP_EXCESS_AMOUNT;

	public HtmlOutputLabel getCOMP_EXCESS_AMOUNT_LABEL() {
		return COMP_EXCESS_AMOUNT_LABEL;
	}

	public void setCOMP_EXCESS_AMOUNT_LABEL(HtmlOutputLabel cOMP_EXCESS_AMOUNT_LABEL) {
		COMP_EXCESS_AMOUNT_LABEL = cOMP_EXCESS_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_EXCESS_AMOUNT() {
		return COMP_EXCESS_AMOUNT;
	}

	public void setCOMP_EXCESS_AMOUNT(HtmlInputText cOMP_EXCESS_AMOUNT) {
		COMP_EXCESS_AMOUNT = cOMP_EXCESS_AMOUNT;
	}
	//ADVANCE_PREMIUM FIELDS  ADDED BY SARANYA ON 26/08/2016
	
	private HtmlOutputLabel COMP_ADVANCE_PREMIUM_LABEL;

	private HtmlInputText COMP_ADVANCE_PREMIUM;

	public HtmlOutputLabel getCOMP_ADVANCE_PREMIUM_LABEL() {
		return COMP_ADVANCE_PREMIUM_LABEL;
	}

	public void setCOMP_ADVANCE_PREMIUM_LABEL(
			HtmlOutputLabel cOMP_ADVANCE_PREMIUM_LABEL) {
		COMP_ADVANCE_PREMIUM_LABEL = cOMP_ADVANCE_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_ADVANCE_PREMIUM() {
		return COMP_ADVANCE_PREMIUM;
	}

	public void setCOMP_ADVANCE_PREMIUM(HtmlInputText cOMP_ADVANCE_PREMIUM) {
		COMP_ADVANCE_PREMIUM = cOMP_ADVANCE_PREMIUM;
	}
/*end*/
/*	Added by saranya for Hands on point num 23 on 14/02/2017
	
	private HtmlOutputLabel COMP_CE_FC_CLM_PROC_FEE_LABEL;

	private HtmlInputText COMP_CE_FC_CLM_PROC_FEE;
	
	private HtmlOutputLabel COMP_CE_LC_CLM_PROC_FEE_LABEL;
	
	private HtmlInputText COMP_CE_LC_CLM_PROC_FEE;

	public HtmlOutputLabel getCOMP_CE_FC_CLM_PROC_FEE_LABEL() {
		return COMP_CE_FC_CLM_PROC_FEE_LABEL;
	}

	public void setCOMP_CE_FC_CLM_PROC_FEE_LABEL(
			HtmlOutputLabel cOMP_CE_FC_CLM_PROC_FEE_LABEL) {
		COMP_CE_FC_CLM_PROC_FEE_LABEL = cOMP_CE_FC_CLM_PROC_FEE_LABEL;
	}

	public HtmlInputText getCOMP_CE_FC_CLM_PROC_FEE() {
		return COMP_CE_FC_CLM_PROC_FEE;
	}

	public void setCOMP_CE_FC_CLM_PROC_FEE(HtmlInputText cOMP_CE_FC_CLM_PROC_FEE) {
		COMP_CE_FC_CLM_PROC_FEE = cOMP_CE_FC_CLM_PROC_FEE;
	}

	public HtmlOutputLabel getCOMP_CE_LC_CLM_PROC_FEE_LABEL() {
		return COMP_CE_LC_CLM_PROC_FEE_LABEL;
	}

	public void setCOMP_CE_LC_CLM_PROC_FEE_LABEL(
			HtmlOutputLabel cOMP_CE_LC_CLM_PROC_FEE_LABEL) {
		COMP_CE_LC_CLM_PROC_FEE_LABEL = cOMP_CE_LC_CLM_PROC_FEE_LABEL;
	}

	public HtmlInputText getCOMP_CE_LC_CLM_PROC_FEE() {
		return COMP_CE_LC_CLM_PROC_FEE;
	}

	public void setCOMP_CE_LC_CLM_PROC_FEE(HtmlInputText cOMP_CE_LC_CLM_PROC_FEE) {
		COMP_CE_LC_CLM_PROC_FEE = cOMP_CE_LC_CLM_PROC_FEE;
	}

	End*/
}
