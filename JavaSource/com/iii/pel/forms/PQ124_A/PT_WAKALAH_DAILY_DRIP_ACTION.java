package com.iii.pel.forms.PQ124_A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_WAKALAH_DAILY_DRIP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_TOT_PRIA_LABEL;

	private HtmlInputText COMP_UI_M_TOT_PRIA;

	private HtmlOutputLabel COMP_WAK_DA_POL_COVER_CODE_LABEL;

	//new 
	private HtmlInputText COMP_WAK_DA_RISK_FC_AMT;

	private HtmlOutputLabel COMP_WAK_DA_RISK_FC_AMT_LABEL;
	
	private HtmlInputText COMP_WAK_DA_RISK_LC_AMT;

	private HtmlOutputLabel COMP_WAK_DA_RISK_LC_AMT_LABEL;
	
	private HtmlInputText COMP_WAK_DA_CHARGE_FC_AMT;

	private HtmlOutputLabel COMP_WAK_DA_CHARGE_FC_AMT_LABEL;
	
	private HtmlInputText COMP_WAK_DA_CHARGE_LC_AMT;

	private HtmlOutputLabel COMP_WAK_DA_CHARGE_LC_AMT_LABEL;
	
	private HtmlInputText COMP_WAK_DA_PREM_CONTRI_FC_AMT;

	private HtmlOutputLabel COMP_WAK_DA_PREM_CONTRI_FC_AMT_LABEL;
	
	private HtmlInputText COMP_WAK_DA_PREM_CONTRI_LC_AMT;

	private HtmlOutputLabel COMP_WAK_DA_PREM_CONTRI_LC_AMT_LABEL;
	
	//end
	private HtmlInputText COMP_WAK_DA_POL_COVER_CODE;

	private HtmlOutputLabel COMP_WAK_DA_YEAR_LABEL;

	private HtmlInputText COMP_WAK_DA_YEAR;

	private HtmlOutputLabel COMP_WAK_DA_POL_NET_PREMIUM_LABEL;

	private HtmlInputText COMP_WAK_DA_POL_NET_PREMIUM;

	private HtmlOutputLabel COMP_WAK_DA_LOAD_AMT_LABEL;

	private HtmlInputText COMP_WAK_DA_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_ROW_TOTAL_LABEL;

	private HtmlInputText COMP_UI_M_ROW_TOTAL;

	private HtmlOutputLabel COMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL;

	private HtmlInputText COMP_UI_M_WAK_DA_POL_NET_PREMIUM;

	private HtmlOutputLabel COMP_WAK_DA_POL_TOT_COMM_LABEL;

	private HtmlInputText COMP_WAK_DA_POL_TOT_COMM;

	private HtmlOutputLabel COMP_WAK_DA_COMMISSION_LABEL;

	private HtmlInputText COMP_WAK_DA_COMMISSION;

	private HtmlOutputLabel COMP_WAK_DA_EXPENSE_LABEL;

	private HtmlInputText COMP_WAK_DA_EXPENSE;

	private HtmlOutputLabel COMP_WAK_DA_RISK_FUND_LABEL;

	private HtmlInputText COMP_WAK_DA_RISK_FUND;

	private HtmlOutputLabel COMP_WAK_DA_ACCOUNT_YN_LABEL;

	private HtmlInputText COMP_WAK_DA_ACCOUNT_YN;

	private HtmlOutputLabel COMP_UI_M_SUM_GROSS_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_SUM_GROSS_CONTR;

	private HtmlOutputLabel COMP_UI_M_SUM_LOAD_AMT_LABEL;

	private HtmlInputText COMP_UI_M_SUM_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_SUM_ROW_TOTAL_LABEL;

	private HtmlInputText COMP_UI_M_SUM_ROW_TOTAL;

	private HtmlOutputLabel COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL;

	private HtmlInputText COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM;

	private HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL;

	private HtmlInputText COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM;

	private HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL;

	private HtmlInputText COMP_UI_M_TOT_WAK_DA_COMMISSION;

	private HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL;

	private HtmlInputText COMP_UI_M_TOT_WAK_DA_EXPENSE;

	private HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL;

	private HtmlInputText COMP_UI_M_TOT_WAK_DA_RISK_FUND;

	private HtmlOutputLabel COMP_WAK_DA_LC_SUM_RISK_LABEL;

	private HtmlInputText COMP_WAK_DA_LC_SUM_RISK;

	private HtmlOutputLabel COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_WAK_DA_PC_APPRV_DT_LABEL;

	private HtmlCalendar COMP_WAK_DA_PC_APPRV_DT;

	private HtmlOutputLabel COMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_WAK_DA_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_WAK_DA_LC_RISK_LABEL;

	private HtmlInputText COMP_WAK_DA_LC_RISK;

	private HtmlOutputLabel COMP_UI_M_CUR_RISK_DT_LABEL;

	private HtmlCalendar COMP_UI_M_CUR_RISK_DT;

	private HtmlOutputLabel COMP_WAK_DA_DUE_DATE_LABEL;

	private HtmlCalendar COMP_WAK_DA_DUE_DATE;

	private HtmlOutputLabel COMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_WAK_DA_DUE_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_WAK_DA_DRIP_DT_LABEL;

	private HtmlCalendar COMP_WAK_DA_DRIP_DT;

	private HtmlOutputLabel COMP_UI_M_DRIP_STATUS_LABEL;

	private HtmlInputText COMP_UI_M_DRIP_STATUS;

	private HtmlCommandButton COMP_PA_PROFIT;

	private PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN;

	public PQ124_A_COMPOSITE_ACTION compositeAction;

	private PT_WAKALAH_DAILY_DRIP_HELPER helper;

	private List<PT_WAKALAH_DAILY_DRIP> dataList_PT_WAKALAH_DAILY_DRIP = new ArrayList<PT_WAKALAH_DAILY_DRIP>();

	private UIData dataTable;
	
	private Double TOT_WAK_DA_POL_NET_PREMIUM = 0.0;
	private Double TOT_WAK_DA_LOAD_AMT = 0.0;
	private Double TOT_WAK_DA_POL_TOT_COMM = 0.0;
	private Double TOT_WAK_DA_COMMISSION = 0.0;
	private Double TOT_WAK_DA_EXPENSE = 0.0;
	private Double TOT_UI_M_ROW_TOTAL = 0.0;
	private Double TOT_UI_M_WAK_DA_POL_NET_PREMIUM = 0.0;


	public PQ124_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PQ124_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_WAKALAH_DAILY_DRIP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_WAKALAH_DAILY_DRIP_HELPER helper) {
		this.helper = helper;
	}

	public Double getTOT_WAK_DA_POL_NET_PREMIUM() {
		return TOT_WAK_DA_POL_NET_PREMIUM;
	}

	public void setTOT_WAK_DA_POL_NET_PREMIUM(Double tot_wak_da_pol_net_premium) {
		TOT_WAK_DA_POL_NET_PREMIUM = tot_wak_da_pol_net_premium;
	}

	public Double getTOT_WAK_DA_LOAD_AMT() {
		return TOT_WAK_DA_LOAD_AMT;
	}

	public void setTOT_WAK_DA_LOAD_AMT(Double tot_wak_da_load_amt) {
		TOT_WAK_DA_LOAD_AMT = tot_wak_da_load_amt;
	}

	public Double getTOT_WAK_DA_POL_TOT_COMM() {
		return TOT_WAK_DA_POL_TOT_COMM;
	}

	public void setTOT_WAK_DA_POL_TOT_COMM(Double tot_wak_da_pol_tot_comm) {
		TOT_WAK_DA_POL_TOT_COMM = tot_wak_da_pol_tot_comm;
	}

	public Double getTOT_WAK_DA_COMMISSION() {
		return TOT_WAK_DA_COMMISSION;
	}

	public void setTOT_WAK_DA_COMMISSION(Double tot_wak_da_commission) {
		TOT_WAK_DA_COMMISSION = tot_wak_da_commission;
	}

	public Double getTOT_WAK_DA_EXPENSE() {
		return TOT_WAK_DA_EXPENSE;
	}

	public void setTOT_WAK_DA_EXPENSE(Double tot_wak_da_expense) {
		TOT_WAK_DA_EXPENSE = tot_wak_da_expense;
	}

	public Double getTOT_UI_M_ROW_TOTAL() {
		return TOT_UI_M_ROW_TOTAL;
	}

	public void setTOT_UI_M_ROW_TOTAL(Double tot_ui_m_row_total) {
		TOT_UI_M_ROW_TOTAL = tot_ui_m_row_total;
	}

	public Double getTOT_UI_M_WAK_DA_POL_NET_PREMIUM() {
		return TOT_UI_M_WAK_DA_POL_NET_PREMIUM;
	}

	public void setTOT_UI_M_WAK_DA_POL_NET_PREMIUM(
			Double tot_ui_m_wak_da_pol_net_premium) {
		TOT_UI_M_WAK_DA_POL_NET_PREMIUM = tot_ui_m_wak_da_pol_net_premium;
	}

	public void setDataList_PT_WAKALAH_DAILY_DRIP(
			List<PT_WAKALAH_DAILY_DRIP> dataList_PT_WAKALAH_DAILY_DRIP) {
		this.dataList_PT_WAKALAH_DAILY_DRIP = dataList_PT_WAKALAH_DAILY_DRIP;
	}

	public PT_WAKALAH_DAILY_DRIP_ACTION() {

		PT_WAKALAH_DAILY_DRIP_BEAN = new PT_WAKALAH_DAILY_DRIP();
		helper = new PT_WAKALAH_DAILY_DRIP_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_PRIA_LABEL() {
		return COMP_UI_M_TOT_PRIA_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_PRIA() {
		return COMP_UI_M_TOT_PRIA;
	}

	public void setCOMP_UI_M_TOT_PRIA_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_PRIA_LABEL) {
		this.COMP_UI_M_TOT_PRIA_LABEL = COMP_UI_M_TOT_PRIA_LABEL;
	}

	public void setCOMP_UI_M_TOT_PRIA(HtmlInputText COMP_UI_M_TOT_PRIA) {
		this.COMP_UI_M_TOT_PRIA = COMP_UI_M_TOT_PRIA;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_POL_COVER_CODE_LABEL() {
		return COMP_WAK_DA_POL_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_POL_COVER_CODE() {
		return COMP_WAK_DA_POL_COVER_CODE;
	}

	public void setCOMP_WAK_DA_POL_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_WAK_DA_POL_COVER_CODE_LABEL) {
		this.COMP_WAK_DA_POL_COVER_CODE_LABEL = COMP_WAK_DA_POL_COVER_CODE_LABEL;
	}

	public void setCOMP_WAK_DA_POL_COVER_CODE(
			HtmlInputText COMP_WAK_DA_POL_COVER_CODE) {
		this.COMP_WAK_DA_POL_COVER_CODE = COMP_WAK_DA_POL_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_YEAR_LABEL() {
		return COMP_WAK_DA_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_YEAR() {
		return COMP_WAK_DA_YEAR;
	}

	public void setCOMP_WAK_DA_YEAR_LABEL(HtmlOutputLabel COMP_WAK_DA_YEAR_LABEL) {
		this.COMP_WAK_DA_YEAR_LABEL = COMP_WAK_DA_YEAR_LABEL;
	}

	public void setCOMP_WAK_DA_YEAR(HtmlInputText COMP_WAK_DA_YEAR) {
		this.COMP_WAK_DA_YEAR = COMP_WAK_DA_YEAR;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_POL_NET_PREMIUM_LABEL() {
		return COMP_WAK_DA_POL_NET_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_POL_NET_PREMIUM() {
		return COMP_WAK_DA_POL_NET_PREMIUM;
	}

	public void setCOMP_WAK_DA_POL_NET_PREMIUM_LABEL(
			HtmlOutputLabel COMP_WAK_DA_POL_NET_PREMIUM_LABEL) {
		this.COMP_WAK_DA_POL_NET_PREMIUM_LABEL = COMP_WAK_DA_POL_NET_PREMIUM_LABEL;
	}

	public void setCOMP_WAK_DA_POL_NET_PREMIUM(
			HtmlInputText COMP_WAK_DA_POL_NET_PREMIUM) {
		this.COMP_WAK_DA_POL_NET_PREMIUM = COMP_WAK_DA_POL_NET_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_LOAD_AMT_LABEL() {
		return COMP_WAK_DA_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_LOAD_AMT() {
		return COMP_WAK_DA_LOAD_AMT;
	}

	public void setCOMP_WAK_DA_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_WAK_DA_LOAD_AMT_LABEL) {
		this.COMP_WAK_DA_LOAD_AMT_LABEL = COMP_WAK_DA_LOAD_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_LOAD_AMT(HtmlInputText COMP_WAK_DA_LOAD_AMT) {
		this.COMP_WAK_DA_LOAD_AMT = COMP_WAK_DA_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ROW_TOTAL_LABEL() {
		return COMP_UI_M_ROW_TOTAL_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ROW_TOTAL() {
		return COMP_UI_M_ROW_TOTAL;
	}

	public void setCOMP_UI_M_ROW_TOTAL_LABEL(
			HtmlOutputLabel COMP_UI_M_ROW_TOTAL_LABEL) {
		this.COMP_UI_M_ROW_TOTAL_LABEL = COMP_UI_M_ROW_TOTAL_LABEL;
	}

	public void setCOMP_UI_M_ROW_TOTAL(HtmlInputText COMP_UI_M_ROW_TOTAL) {
		this.COMP_UI_M_ROW_TOTAL = COMP_UI_M_ROW_TOTAL;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL() {
		return COMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAK_DA_POL_NET_PREMIUM() {
		return COMP_UI_M_WAK_DA_POL_NET_PREMIUM;
	}

	public void setCOMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL(
			HtmlOutputLabel COMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL) {
		this.COMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL = COMP_UI_M_WAK_DA_POL_NET_PREMIUM_LABEL;
	}

	public void setCOMP_UI_M_WAK_DA_POL_NET_PREMIUM(
			HtmlInputText COMP_UI_M_WAK_DA_POL_NET_PREMIUM) {
		this.COMP_UI_M_WAK_DA_POL_NET_PREMIUM = COMP_UI_M_WAK_DA_POL_NET_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_POL_TOT_COMM_LABEL() {
		return COMP_WAK_DA_POL_TOT_COMM_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_POL_TOT_COMM() {
		return COMP_WAK_DA_POL_TOT_COMM;
	}

	public void setCOMP_WAK_DA_POL_TOT_COMM_LABEL(
			HtmlOutputLabel COMP_WAK_DA_POL_TOT_COMM_LABEL) {
		this.COMP_WAK_DA_POL_TOT_COMM_LABEL = COMP_WAK_DA_POL_TOT_COMM_LABEL;
	}

	public void setCOMP_WAK_DA_POL_TOT_COMM(
			HtmlInputText COMP_WAK_DA_POL_TOT_COMM) {
		this.COMP_WAK_DA_POL_TOT_COMM = COMP_WAK_DA_POL_TOT_COMM;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_COMMISSION_LABEL() {
		return COMP_WAK_DA_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_COMMISSION() {
		return COMP_WAK_DA_COMMISSION;
	}

	public void setCOMP_WAK_DA_COMMISSION_LABEL(
			HtmlOutputLabel COMP_WAK_DA_COMMISSION_LABEL) {
		this.COMP_WAK_DA_COMMISSION_LABEL = COMP_WAK_DA_COMMISSION_LABEL;
	}

	public void setCOMP_WAK_DA_COMMISSION(HtmlInputText COMP_WAK_DA_COMMISSION) {
		this.COMP_WAK_DA_COMMISSION = COMP_WAK_DA_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_EXPENSE_LABEL() {
		return COMP_WAK_DA_EXPENSE_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_EXPENSE() {
		return COMP_WAK_DA_EXPENSE;
	}

	public void setCOMP_WAK_DA_EXPENSE_LABEL(
			HtmlOutputLabel COMP_WAK_DA_EXPENSE_LABEL) {
		this.COMP_WAK_DA_EXPENSE_LABEL = COMP_WAK_DA_EXPENSE_LABEL;
	}

	public void setCOMP_WAK_DA_EXPENSE(HtmlInputText COMP_WAK_DA_EXPENSE) {
		this.COMP_WAK_DA_EXPENSE = COMP_WAK_DA_EXPENSE;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_RISK_FUND_LABEL() {
		return COMP_WAK_DA_RISK_FUND_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_RISK_FUND() {
		return COMP_WAK_DA_RISK_FUND;
	}

	public void setCOMP_WAK_DA_RISK_FUND_LABEL(
			HtmlOutputLabel COMP_WAK_DA_RISK_FUND_LABEL) {
		this.COMP_WAK_DA_RISK_FUND_LABEL = COMP_WAK_DA_RISK_FUND_LABEL;
	}

	public void setCOMP_WAK_DA_RISK_FUND(HtmlInputText COMP_WAK_DA_RISK_FUND) {
		this.COMP_WAK_DA_RISK_FUND = COMP_WAK_DA_RISK_FUND;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_ACCOUNT_YN_LABEL() {
		return COMP_WAK_DA_ACCOUNT_YN_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_ACCOUNT_YN() {
		return COMP_WAK_DA_ACCOUNT_YN;
	}

	public void setCOMP_WAK_DA_ACCOUNT_YN_LABEL(
			HtmlOutputLabel COMP_WAK_DA_ACCOUNT_YN_LABEL) {
		this.COMP_WAK_DA_ACCOUNT_YN_LABEL = COMP_WAK_DA_ACCOUNT_YN_LABEL;
	}

	public void setCOMP_WAK_DA_ACCOUNT_YN(HtmlInputText COMP_WAK_DA_ACCOUNT_YN) {
		this.COMP_WAK_DA_ACCOUNT_YN = COMP_WAK_DA_ACCOUNT_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_GROSS_CONTR_LABEL() {
		return COMP_UI_M_SUM_GROSS_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_GROSS_CONTR() {
		return COMP_UI_M_SUM_GROSS_CONTR;
	}

	public void setCOMP_UI_M_SUM_GROSS_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_GROSS_CONTR_LABEL) {
		this.COMP_UI_M_SUM_GROSS_CONTR_LABEL = COMP_UI_M_SUM_GROSS_CONTR_LABEL;
	}

	public void setCOMP_UI_M_SUM_GROSS_CONTR(
			HtmlInputText COMP_UI_M_SUM_GROSS_CONTR) {
		this.COMP_UI_M_SUM_GROSS_CONTR = COMP_UI_M_SUM_GROSS_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_LOAD_AMT_LABEL() {
		return COMP_UI_M_SUM_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_LOAD_AMT() {
		return COMP_UI_M_SUM_LOAD_AMT;
	}

	public void setCOMP_UI_M_SUM_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_LOAD_AMT_LABEL) {
		this.COMP_UI_M_SUM_LOAD_AMT_LABEL = COMP_UI_M_SUM_LOAD_AMT_LABEL;
	}

	public void setCOMP_UI_M_SUM_LOAD_AMT(HtmlInputText COMP_UI_M_SUM_LOAD_AMT) {
		this.COMP_UI_M_SUM_LOAD_AMT = COMP_UI_M_SUM_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_ROW_TOTAL_LABEL() {
		return COMP_UI_M_SUM_ROW_TOTAL_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_ROW_TOTAL() {
		return COMP_UI_M_SUM_ROW_TOTAL;
	}

	public void setCOMP_UI_M_SUM_ROW_TOTAL_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_ROW_TOTAL_LABEL) {
		this.COMP_UI_M_SUM_ROW_TOTAL_LABEL = COMP_UI_M_SUM_ROW_TOTAL_LABEL;
	}

	public void setCOMP_UI_M_SUM_ROW_TOTAL(HtmlInputText COMP_UI_M_SUM_ROW_TOTAL) {
		this.COMP_UI_M_SUM_ROW_TOTAL = COMP_UI_M_SUM_ROW_TOTAL;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL() {
		return COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM() {
		return COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM;
	}

	public void setCOMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL(
			HtmlOutputLabel COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL) {
		this.COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL = COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM_LABEL;
	}

	public void setCOMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM(
			HtmlInputText COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM) {
		this.COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM = COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL() {
		return COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_WAK_DA_POL_TOT_COMM() {
		return COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL) {
		this.COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL = COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM_LABEL;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_POL_TOT_COMM(
			HtmlInputText COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM) {
		this.COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM = COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL() {
		return COMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_WAK_DA_COMMISSION() {
		return COMP_UI_M_TOT_WAK_DA_COMMISSION;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL) {
		this.COMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL = COMP_UI_M_TOT_WAK_DA_COMMISSION_LABEL;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_COMMISSION(
			HtmlInputText COMP_UI_M_TOT_WAK_DA_COMMISSION) {
		this.COMP_UI_M_TOT_WAK_DA_COMMISSION = COMP_UI_M_TOT_WAK_DA_COMMISSION;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL() {
		return COMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_WAK_DA_EXPENSE() {
		return COMP_UI_M_TOT_WAK_DA_EXPENSE;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL) {
		this.COMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL = COMP_UI_M_TOT_WAK_DA_EXPENSE_LABEL;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_EXPENSE(
			HtmlInputText COMP_UI_M_TOT_WAK_DA_EXPENSE) {
		this.COMP_UI_M_TOT_WAK_DA_EXPENSE = COMP_UI_M_TOT_WAK_DA_EXPENSE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL() {
		return COMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_WAK_DA_RISK_FUND() {
		return COMP_UI_M_TOT_WAK_DA_RISK_FUND;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL) {
		this.COMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL = COMP_UI_M_TOT_WAK_DA_RISK_FUND_LABEL;
	}

	public void setCOMP_UI_M_TOT_WAK_DA_RISK_FUND(
			HtmlInputText COMP_UI_M_TOT_WAK_DA_RISK_FUND) {
		this.COMP_UI_M_TOT_WAK_DA_RISK_FUND = COMP_UI_M_TOT_WAK_DA_RISK_FUND;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_LC_SUM_RISK_LABEL() {
		return COMP_WAK_DA_LC_SUM_RISK_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_LC_SUM_RISK() {
		return COMP_WAK_DA_LC_SUM_RISK;
	}

	public void setCOMP_WAK_DA_LC_SUM_RISK_LABEL(
			HtmlOutputLabel COMP_WAK_DA_LC_SUM_RISK_LABEL) {
		this.COMP_WAK_DA_LC_SUM_RISK_LABEL = COMP_WAK_DA_LC_SUM_RISK_LABEL;
	}

	public void setCOMP_WAK_DA_LC_SUM_RISK(HtmlInputText COMP_WAK_DA_LC_SUM_RISK) {
		this.COMP_WAK_DA_LC_SUM_RISK = COMP_WAK_DA_LC_SUM_RISK;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAK_DA_POL_COVER_CODE_DESC() {
		return COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL = COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_WAK_DA_POL_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC) {
		this.COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC = COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_PC_APPRV_DT_LABEL() {
		return COMP_WAK_DA_PC_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WAK_DA_PC_APPRV_DT() {
		return COMP_WAK_DA_PC_APPRV_DT;
	}

	public void setCOMP_WAK_DA_PC_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_WAK_DA_PC_APPRV_DT_LABEL) {
		this.COMP_WAK_DA_PC_APPRV_DT_LABEL = COMP_WAK_DA_PC_APPRV_DT_LABEL;
	}

	public void setCOMP_WAK_DA_PC_APPRV_DT(HtmlCalendar COMP_WAK_DA_PC_APPRV_DT) {
		this.COMP_WAK_DA_PC_APPRV_DT = COMP_WAK_DA_PC_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WAK_DA_PC_SCHD_PYMT_DT() {
		return COMP_WAK_DA_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL = COMP_WAK_DA_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_WAK_DA_PC_SCHD_PYMT_DT(
			HtmlCalendar COMP_WAK_DA_PC_SCHD_PYMT_DT) {
		this.COMP_WAK_DA_PC_SCHD_PYMT_DT = COMP_WAK_DA_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_LC_RISK_LABEL() {
		return COMP_WAK_DA_LC_RISK_LABEL;
	}

	public HtmlInputText getCOMP_WAK_DA_LC_RISK() {
		return COMP_WAK_DA_LC_RISK;
	}

	public void setCOMP_WAK_DA_LC_RISK_LABEL(
			HtmlOutputLabel COMP_WAK_DA_LC_RISK_LABEL) {
		this.COMP_WAK_DA_LC_RISK_LABEL = COMP_WAK_DA_LC_RISK_LABEL;
	}

	public void setCOMP_WAK_DA_LC_RISK(HtmlInputText COMP_WAK_DA_LC_RISK) {
		this.COMP_WAK_DA_LC_RISK = COMP_WAK_DA_LC_RISK;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUR_RISK_DT_LABEL() {
		return COMP_UI_M_CUR_RISK_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_CUR_RISK_DT() {
		return COMP_UI_M_CUR_RISK_DT;
	}

	public void setCOMP_UI_M_CUR_RISK_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_CUR_RISK_DT_LABEL) {
		this.COMP_UI_M_CUR_RISK_DT_LABEL = COMP_UI_M_CUR_RISK_DT_LABEL;
	}

	public void setCOMP_UI_M_CUR_RISK_DT(HtmlCalendar COMP_UI_M_CUR_RISK_DT) {
		this.COMP_UI_M_CUR_RISK_DT = COMP_UI_M_CUR_RISK_DT;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_DUE_DATE_LABEL() {
		return COMP_WAK_DA_DUE_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_WAK_DA_DUE_DATE() {
		return COMP_WAK_DA_DUE_DATE;
	}

	public void setCOMP_WAK_DA_DUE_DATE_LABEL(
			HtmlOutputLabel COMP_WAK_DA_DUE_DATE_LABEL) {
		this.COMP_WAK_DA_DUE_DATE_LABEL = COMP_WAK_DA_DUE_DATE_LABEL;
	}

	public void setCOMP_WAK_DA_DUE_DATE(HtmlCalendar COMP_WAK_DA_DUE_DATE) {
		this.COMP_WAK_DA_DUE_DATE = COMP_WAK_DA_DUE_DATE;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL() {
		return COMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WAK_DA_DUE_SCHD_PYMT_DT() {
		return COMP_WAK_DA_DUE_SCHD_PYMT_DT;
	}

	public void setCOMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL) {
		this.COMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL = COMP_WAK_DA_DUE_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_WAK_DA_DUE_SCHD_PYMT_DT(
			HtmlCalendar COMP_WAK_DA_DUE_SCHD_PYMT_DT) {
		this.COMP_WAK_DA_DUE_SCHD_PYMT_DT = COMP_WAK_DA_DUE_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_DRIP_DT_LABEL() {
		return COMP_WAK_DA_DRIP_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WAK_DA_DRIP_DT() {
		return COMP_WAK_DA_DRIP_DT;
	}

	public void setCOMP_WAK_DA_DRIP_DT_LABEL(
			HtmlOutputLabel COMP_WAK_DA_DRIP_DT_LABEL) {
		this.COMP_WAK_DA_DRIP_DT_LABEL = COMP_WAK_DA_DRIP_DT_LABEL;
	}

	public void setCOMP_WAK_DA_DRIP_DT(HtmlCalendar COMP_WAK_DA_DRIP_DT) {
		this.COMP_WAK_DA_DRIP_DT = COMP_WAK_DA_DRIP_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRIP_STATUS_LABEL() {
		return COMP_UI_M_DRIP_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRIP_STATUS() {
		return COMP_UI_M_DRIP_STATUS;
	}

	public void setCOMP_UI_M_DRIP_STATUS_LABEL(
			HtmlOutputLabel COMP_UI_M_DRIP_STATUS_LABEL) {
		this.COMP_UI_M_DRIP_STATUS_LABEL = COMP_UI_M_DRIP_STATUS_LABEL;
	}

	public void setCOMP_UI_M_DRIP_STATUS(HtmlInputText COMP_UI_M_DRIP_STATUS) {
		this.COMP_UI_M_DRIP_STATUS = COMP_UI_M_DRIP_STATUS;
	}

	public HtmlCommandButton getCOMP_PA_PROFIT() {
		return COMP_PA_PROFIT;
	}

	public void setCOMP_PA_PROFIT(HtmlCommandButton COMP_PA_PROFIT) {
		this.COMP_PA_PROFIT = COMP_PA_PROFIT;
	}

	public PT_WAKALAH_DAILY_DRIP getPT_WAKALAH_DAILY_DRIP_BEAN() {
		return PT_WAKALAH_DAILY_DRIP_BEAN;
	}

	public void setPT_WAKALAH_DAILY_DRIP_BEAN(
			PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN) {
		this.PT_WAKALAH_DAILY_DRIP_BEAN = PT_WAKALAH_DAILY_DRIP_BEAN;
	}

	public List<PT_WAKALAH_DAILY_DRIP> getDataList_PT_WAKALAH_DAILY_DRIP() {
		return dataList_PT_WAKALAH_DAILY_DRIP;
	}

	public void setDataListPT_WAKALAH_DAILY_DRIP(
			List<PT_WAKALAH_DAILY_DRIP> dataList_PT_WAKALAH_DAILY_DRIP) {
		this.dataList_PT_WAKALAH_DAILY_DRIP = dataList_PT_WAKALAH_DAILY_DRIP;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_WAKALAH_DAILY_DRIP_BEAN = new PT_WAKALAH_DAILY_DRIP();
				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_WAKALAH_DAILY_DRIP_BEAN,
						CommonUtils.getConnection());
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
				dataList_PT_WAKALAH_DAILY_DRIP
						.remove(PT_WAKALAH_DAILY_DRIP_BEAN);
				if (dataList_PT_WAKALAH_DAILY_DRIP.size() > 0) {

					PT_WAKALAH_DAILY_DRIP_BEAN = dataList_PT_WAKALAH_DAILY_DRIP
							.get(0);
				} else if (dataList_PT_WAKALAH_DAILY_DRIP.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_WAKALAH_DAILY_DRIP_BEAN.setRowSelected(true);
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

	public void postRecord(ActionEvent event) {
		try {
			if (PT_WAKALAH_DAILY_DRIP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_WAKALAH_DAILY_DRIP_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PT_WAKALAH_DAILY_DRIP.add(PT_WAKALAH_DAILY_DRIP_BEAN);
			} else if (PT_WAKALAH_DAILY_DRIP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_WAKALAH_DAILY_DRIP_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PT_WAKALAH_DAILY_DRIP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_WAKALAH_DAILY_DRIP_BEAN = (PT_WAKALAH_DAILY_DRIP) dataTable
					.getRowData();
			PT_WAKALAH_DAILY_DRIP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_WAKALAH_DAILY_DRIP> PT_WAKALAH_DAILY_DRIP_ITR = dataList_PT_WAKALAH_DAILY_DRIP
				.iterator();
		while (PT_WAKALAH_DAILY_DRIP_ITR.hasNext()) {
			PT_WAKALAH_DAILY_DRIP_ITR.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_TOT_PRIA.resetValue();
		COMP_WAK_DA_POL_COVER_CODE.resetValue();
		COMP_WAK_DA_YEAR.resetValue();
		COMP_WAK_DA_POL_NET_PREMIUM.resetValue();
		COMP_WAK_DA_LOAD_AMT.resetValue();
		COMP_UI_M_ROW_TOTAL.resetValue();
		COMP_UI_M_WAK_DA_POL_NET_PREMIUM.resetValue();
		COMP_WAK_DA_POL_TOT_COMM.resetValue();
		COMP_WAK_DA_COMMISSION.resetValue();
		COMP_WAK_DA_EXPENSE.resetValue();
		COMP_WAK_DA_RISK_FUND.resetValue();
		COMP_WAK_DA_ACCOUNT_YN.resetValue();
		COMP_UI_M_SUM_GROSS_CONTR.resetValue();
		COMP_UI_M_SUM_LOAD_AMT.resetValue();
		COMP_UI_M_SUM_ROW_TOTAL.resetValue();
		COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM.resetValue();
		COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM.resetValue();
		COMP_UI_M_TOT_WAK_DA_COMMISSION.resetValue();
		COMP_UI_M_TOT_WAK_DA_EXPENSE.resetValue();
		COMP_UI_M_TOT_WAK_DA_RISK_FUND.resetValue();
		COMP_WAK_DA_LC_SUM_RISK.resetValue();
		COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC.resetValue();
		COMP_WAK_DA_PC_APPRV_DT.resetValue();
		COMP_WAK_DA_PC_SCHD_PYMT_DT.resetValue();
		COMP_WAK_DA_LC_RISK.resetValue();
		COMP_UI_M_CUR_RISK_DT.resetValue();
		COMP_WAK_DA_DUE_DATE.resetValue();
		COMP_WAK_DA_DUE_SCHD_PYMT_DT.resetValue();
		COMP_WAK_DA_DRIP_DT.resetValue();
		COMP_UI_M_DRIP_STATUS.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				helper.postQuery(compositeAction);
				helper.whenNewRecordInstance(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	/**
	 * Instantiates all components in PT_WAKALAH_DAILY_DRIP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_TOT_PRIA				 = new HtmlInputText();
		COMP_WAK_DA_POL_COVER_CODE			 = new HtmlInputText();
		COMP_WAK_DA_YEAR				 = new HtmlInputText();
		COMP_WAK_DA_POL_NET_PREMIUM			 = new HtmlInputText();
		COMP_WAK_DA_LOAD_AMT				 = new HtmlInputText();
		COMP_UI_M_ROW_TOTAL				 = new HtmlInputText();
		COMP_UI_M_WAK_DA_POL_NET_PREMIUM		 = new HtmlInputText();
		COMP_WAK_DA_POL_TOT_COMM			 = new HtmlInputText();
		COMP_WAK_DA_COMMISSION				 = new HtmlInputText();
		COMP_WAK_DA_EXPENSE				 = new HtmlInputText();
		COMP_WAK_DA_RISK_FUND				 = new HtmlInputText();
		COMP_WAK_DA_ACCOUNT_YN				 = new HtmlInputText();
		COMP_UI_M_SUM_GROSS_CONTR			 = new HtmlInputText();
		COMP_UI_M_SUM_LOAD_AMT				 = new HtmlInputText();
		COMP_UI_M_SUM_ROW_TOTAL				 = new HtmlInputText();
		COMP_UI_M_SUM_WAK_DA_POL_NET_PREMIUM		 = new HtmlInputText();
		COMP_UI_M_TOT_WAK_DA_POL_TOT_COMM		 = new HtmlInputText();
		COMP_UI_M_TOT_WAK_DA_COMMISSION			 = new HtmlInputText();
		COMP_UI_M_TOT_WAK_DA_EXPENSE			 = new HtmlInputText();
		COMP_UI_M_TOT_WAK_DA_RISK_FUND			 = new HtmlInputText();
		COMP_WAK_DA_LC_SUM_RISK				 = new HtmlInputText();
		COMP_UI_M_WAK_DA_POL_COVER_CODE_DESC		 = new HtmlInputText();
		COMP_WAK_DA_LC_RISK				 = new HtmlInputText();
		COMP_UI_M_DRIP_STATUS				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_WAK_DA_PC_APPRV_DT				 = new HtmlCalendar();
		COMP_WAK_DA_PC_SCHD_PYMT_DT			 = new HtmlCalendar();
		COMP_UI_M_CUR_RISK_DT				 = new HtmlCalendar();
		COMP_WAK_DA_DUE_DATE				 = new HtmlCalendar();
		COMP_WAK_DA_DUE_SCHD_PYMT_DT			 = new HtmlCalendar();
		COMP_WAK_DA_DRIP_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_PA_PROFIT					 = new HtmlCommandButton();

	}
	
	/**
	 * 
	 */
	public String buttonPAProfit(){
		compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().onLoad(null);
		return "PA_PROFIT";
	}
	
	
	public void calculateSum(){
		TOT_UI_M_ROW_TOTAL = 0.0;
		TOT_UI_M_WAK_DA_POL_NET_PREMIUM = 0.0;
		TOT_WAK_DA_COMMISSION = 0.0;
		TOT_WAK_DA_EXPENSE = 0.0;
		TOT_WAK_DA_LOAD_AMT = 0.0;
		TOT_WAK_DA_POL_NET_PREMIUM = 0.0;
		TOT_WAK_DA_POL_TOT_COMM = 0.0;
		for(PT_WAKALAH_DAILY_DRIP dripBean : dataList_PT_WAKALAH_DAILY_DRIP){
			if(dripBean.getUI_M_ROW_TOTAL() != null){
				TOT_UI_M_ROW_TOTAL = TOT_UI_M_ROW_TOTAL+dripBean.getUI_M_ROW_TOTAL();
			}
			if(dripBean.getUI_M_WAK_DA_POL_NET_PREMIUM() != null){
				TOT_UI_M_WAK_DA_POL_NET_PREMIUM = TOT_UI_M_WAK_DA_POL_NET_PREMIUM+ dripBean.getUI_M_WAK_DA_POL_NET_PREMIUM();
			}
			if(dripBean.getWAK_DA_COMMISSION() != null){
				TOT_WAK_DA_COMMISSION = TOT_WAK_DA_COMMISSION + dripBean.getWAK_DA_COMMISSION();
			}
			if(dripBean.getWAK_DA_EXPENSE() != null){
				TOT_WAK_DA_EXPENSE = TOT_WAK_DA_EXPENSE+ dripBean.getWAK_DA_EXPENSE();
			}
			if(dripBean.getWAK_DA_LOAD_AMT() != null){
				TOT_WAK_DA_LOAD_AMT = TOT_WAK_DA_LOAD_AMT+dripBean.getWAK_DA_LOAD_AMT();
			}
			if(dripBean.getWAK_DA_POL_NET_PREMIUM()!= null){
				TOT_WAK_DA_POL_NET_PREMIUM = TOT_WAK_DA_POL_NET_PREMIUM+ dripBean.getWAK_DA_POL_NET_PREMIUM();
			}
			if(dripBean.getWAK_DA_POL_TOT_COMM() != null){
				TOT_WAK_DA_POL_TOT_COMM = TOT_WAK_DA_POL_TOT_COMM+dripBean.getWAK_DA_POL_TOT_COMM();
			}
		}
	}

	public HtmlInputText getCOMP_WAK_DA_RISK_FC_AMT() {
		return COMP_WAK_DA_RISK_FC_AMT;
	}

	public void setCOMP_WAK_DA_RISK_FC_AMT(HtmlInputText comp_wak_da_risk_fc_amt) {
		COMP_WAK_DA_RISK_FC_AMT = comp_wak_da_risk_fc_amt;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_RISK_FC_AMT_LABEL() {
		return COMP_WAK_DA_RISK_FC_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_RISK_FC_AMT_LABEL(
			HtmlOutputLabel comp_wak_da_risk_fc_amt_label) {
		COMP_WAK_DA_RISK_FC_AMT_LABEL = comp_wak_da_risk_fc_amt_label;
	}

	public HtmlInputText getCOMP_WAK_DA_RISK_LC_AMT() {
		return COMP_WAK_DA_RISK_LC_AMT;
	}

	public void setCOMP_WAK_DA_RISK_LC_AMT(HtmlInputText comp_wak_da_risk_lc_amt) {
		COMP_WAK_DA_RISK_LC_AMT = comp_wak_da_risk_lc_amt;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_RISK_LC_AMT_LABEL() {
		return COMP_WAK_DA_RISK_LC_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_RISK_LC_AMT_LABEL(
			HtmlOutputLabel comp_wak_da_risk_lc_amt_label) {
		COMP_WAK_DA_RISK_LC_AMT_LABEL = comp_wak_da_risk_lc_amt_label;
	}

	public HtmlInputText getCOMP_WAK_DA_CHARGE_FC_AMT() {
		return COMP_WAK_DA_CHARGE_FC_AMT;
	}

	public void setCOMP_WAK_DA_CHARGE_FC_AMT(HtmlInputText comp_wak_da_charge_fc_amt) {
		COMP_WAK_DA_CHARGE_FC_AMT = comp_wak_da_charge_fc_amt;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_CHARGE_FC_AMT_LABEL() {
		return COMP_WAK_DA_CHARGE_FC_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_CHARGE_FC_AMT_LABEL(
			HtmlOutputLabel comp_wak_da_charge_fc_amt_label) {
		COMP_WAK_DA_CHARGE_FC_AMT_LABEL = comp_wak_da_charge_fc_amt_label;
	}

	public HtmlInputText getCOMP_WAK_DA_CHARGE_LC_AMT() {
		return COMP_WAK_DA_CHARGE_LC_AMT;
	}

	public void setCOMP_WAK_DA_CHARGE_LC_AMT(HtmlInputText comp_wak_da_charge_lc_amt) {
		COMP_WAK_DA_CHARGE_LC_AMT = comp_wak_da_charge_lc_amt;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_CHARGE_LC_AMT_LABEL() {
		return COMP_WAK_DA_CHARGE_LC_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_CHARGE_LC_AMT_LABEL(
			HtmlOutputLabel comp_wak_da_charge_lc_amt_label) {
		COMP_WAK_DA_CHARGE_LC_AMT_LABEL = comp_wak_da_charge_lc_amt_label;
	}

	public HtmlInputText getCOMP_WAK_DA_PREM_CONTRI_FC_AMT() {
		return COMP_WAK_DA_PREM_CONTRI_FC_AMT;
	}

	public void setCOMP_WAK_DA_PREM_CONTRI_FC_AMT(
			HtmlInputText comp_wak_da_prem_contri_fc_amt) {
		COMP_WAK_DA_PREM_CONTRI_FC_AMT = comp_wak_da_prem_contri_fc_amt;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_PREM_CONTRI_FC_AMT_LABEL() {
		return COMP_WAK_DA_PREM_CONTRI_FC_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_PREM_CONTRI_FC_AMT_LABEL(
			HtmlOutputLabel comp_wak_da_prem_contri_fc_amt_label) {
		COMP_WAK_DA_PREM_CONTRI_FC_AMT_LABEL = comp_wak_da_prem_contri_fc_amt_label;
	}

	public HtmlInputText getCOMP_WAK_DA_PREM_CONTRI_LC_AMT() {
		return COMP_WAK_DA_PREM_CONTRI_LC_AMT;
	}

	public void setCOMP_WAK_DA_PREM_CONTRI_LC_AMT(
			HtmlInputText comp_wak_da_prem_contri_lc_amt) {
		COMP_WAK_DA_PREM_CONTRI_LC_AMT = comp_wak_da_prem_contri_lc_amt;
	}

	public HtmlOutputLabel getCOMP_WAK_DA_PREM_CONTRI_LC_AMT_LABEL() {
		return COMP_WAK_DA_PREM_CONTRI_LC_AMT_LABEL;
	}

	public void setCOMP_WAK_DA_PREM_CONTRI_LC_AMT_LABEL(
			HtmlOutputLabel comp_wak_da_prem_contri_lc_amt_label) {
		COMP_WAK_DA_PREM_CONTRI_LC_AMT_LABEL = comp_wak_da_prem_contri_lc_amt_label;
	}
	
}
