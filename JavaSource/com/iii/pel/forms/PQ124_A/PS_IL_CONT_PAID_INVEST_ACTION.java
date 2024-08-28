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

public class PS_IL_CONT_PAID_INVEST_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CPI_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_CPI_ACNT_YEAR;

	private HtmlOutputLabel COMP_UI_M_YR_END_DT_LABEL;

	private HtmlCalendar COMP_UI_M_YR_END_DT;

	private HtmlOutputLabel COMP_UI_M_ACC_PA_END_BAL_LABEL;

	private HtmlInputText COMP_UI_M_ACC_PA_END_BAL;

	private HtmlOutputLabel COMP_CPI_TXN_DT_LABEL;

	private HtmlCalendar COMP_CPI_TXN_DT;

	private HtmlOutputLabel COMP_CPI_RCPT_AMT_LABEL;

	private HtmlInputText COMP_CPI_RCPT_AMT;

	private HtmlOutputLabel COMP_CPI_MATCHED_AMT_LABEL;

	private HtmlInputText COMP_CPI_MATCHED_AMT;

	private HtmlOutputLabel COMP_CPI_PROFIT_LABEL;

	private HtmlInputText COMP_CPI_PROFIT;

	private HtmlOutputLabel COMP_CPI_DAY_EXP_LABEL;

	private HtmlInputText COMP_CPI_DAY_EXP;

	private HtmlOutputLabel COMP_CPI_PA_BAL_LABEL;

	private HtmlInputText COMP_CPI_PA_BAL;

	private HtmlOutputLabel COMP_CPI_RATE_LABEL;

	private HtmlInputText COMP_CPI_RATE;

	private HtmlOutputLabel COMP_CPI_PA_PROFIT_LABEL;

	private HtmlInputText COMP_CPI_PA_PROFIT;

	private HtmlOutputLabel COMP_CPI_GFTA_PROFIT_LABEL;

	private HtmlInputText COMP_CPI_GFTA_PROFIT;

	private HtmlOutputLabel COMP_CPI_COVER_CODE_LABEL;

	private HtmlInputText COMP_CPI_COVER_CODE;

	private HtmlOutputLabel COMP_CPI_PSA_PROFIT_LABEL;

	private HtmlInputText COMP_CPI_PSA_PROFIT;

	private HtmlOutputLabel COMP_CPI_GFTA_RATE_LABEL;

	private HtmlInputText COMP_CPI_GFTA_RATE;

	private HtmlOutputLabel COMP_CPI_PSA_RATE_LABEL;

	private HtmlInputText COMP_CPI_PSA_RATE;

	private HtmlOutputLabel COMP_CPI_SUSPENSE_RATE_LABEL;

	private HtmlInputText COMP_CPI_SUSPENSE_RATE;

	private HtmlOutputLabel COMP_CPI_RISK_FUND_LABEL;

	private HtmlInputText COMP_CPI_RISK_FUND;

	private HtmlOutputLabel COMP_UI_M_PA_PROFIT_COVERWISE_LABEL;

	private HtmlInputText COMP_UI_M_PA_PROFIT_COVERWISE;

	private HtmlOutputLabel COMP_CPI_WD_AMT_LABEL;

	private HtmlInputText COMP_CPI_WD_AMT;

	private HtmlOutputLabel COMP_CPI_MAT_AMT_LABEL;

	private HtmlInputText COMP_CPI_MAT_AMT;

	private HtmlOutputLabel COMP_UI_M_RISK_FUND_LABEL;

	private HtmlInputText COMP_UI_M_RISK_FUND;

	private HtmlOutputLabel COMP_UI_M_PA_PROFIT_LABEL;

	private HtmlInputText COMP_UI_M_PA_PROFIT;

	private HtmlOutputLabel COMP_CPI_WAK_DUE_DATE_LABEL;

	private HtmlCalendar COMP_CPI_WAK_DUE_DATE;

	private HtmlOutputLabel COMP_UI_M_ACC_PA_PRFT_LABEL;

	private HtmlInputText COMP_UI_M_ACC_PA_PRFT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_1;

	private PS_IL_CONT_PAID_INVEST PS_IL_CONT_PAID_INVEST_BEAN;

	public PQ124_A_COMPOSITE_ACTION compositeAction;

	private PS_IL_CONT_PAID_INVEST_HELPER helper;

	private List<PS_IL_CONT_PAID_INVEST> dataList_PS_IL_CONT_PAID_INVEST = new ArrayList<PS_IL_CONT_PAID_INVEST>();

	private UIData dataTable;
	
	private String filterByCPI_COVER_CODE;
	private String filterByCPI_GFTA_RATE;
	private String filterByCPI_PSA_PROFIT;
	private String filterByCPI_RCPT_AMT;

	/**
	 * @return the compositeAction
	 */
	public PQ124_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PQ124_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PS_IL_CONT_PAID_INVEST_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PS_IL_CONT_PAID_INVEST_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the filterByCPI_COVER_CODE
	 */
	public String getFilterByCPI_COVER_CODE() {
		return filterByCPI_COVER_CODE;
	}

	/**
	 * @param filterByCPI_COVER_CODE the filterByCPI_COVER_CODE to set
	 */
	public void setFilterByCPI_COVER_CODE(String filterByCPI_COVER_CODE) {
		this.filterByCPI_COVER_CODE = filterByCPI_COVER_CODE;
	}

	/**
	 * @return the filterByCPI_GFTA_RATE
	 */
	public String getFilterByCPI_GFTA_RATE() {
		return filterByCPI_GFTA_RATE;
	}

	/**
	 * @param filterByCPI_GFTA_RATE the filterByCPI_GFTA_RATE to set
	 */
	public void setFilterByCPI_GFTA_RATE(String filterByCPI_GFTA_RATE) {
		this.filterByCPI_GFTA_RATE = filterByCPI_GFTA_RATE;
	}

	/**
	 * @return the filterByCPI_PSA_PROFIT
	 */
	public String getFilterByCPI_PSA_PROFIT() {
		return filterByCPI_PSA_PROFIT;
	}

	/**
	 * @param filterByCPI_PSA_PROFIT the filterByCPI_PSA_PROFIT to set
	 */
	public void setFilterByCPI_PSA_PROFIT(String filterByCPI_PSA_PROFIT) {
		this.filterByCPI_PSA_PROFIT = filterByCPI_PSA_PROFIT;
	}

	/**
	 * @return the filterByCPI_RCPT_AMT
	 */
	public String getFilterByCPI_RCPT_AMT() {
		return filterByCPI_RCPT_AMT;
	}

	/**
	 * @param filterByCPI_RCPT_AMT the filterByCPI_RCPT_AMT to set
	 */
	public void setFilterByCPI_RCPT_AMT(String filterByCPI_RCPT_AMT) {
		this.filterByCPI_RCPT_AMT = filterByCPI_RCPT_AMT;
	}

	/**
	 * @param dataList_PS_IL_CONT_PAID_INVEST the dataList_PS_IL_CONT_PAID_INVEST to set
	 */
	public void setDataList_PS_IL_CONT_PAID_INVEST(
			List<PS_IL_CONT_PAID_INVEST> dataList_PS_IL_CONT_PAID_INVEST) {
		this.dataList_PS_IL_CONT_PAID_INVEST = dataList_PS_IL_CONT_PAID_INVEST;
	}

	public PS_IL_CONT_PAID_INVEST_ACTION() {
		PS_IL_CONT_PAID_INVEST_BEAN = new PS_IL_CONT_PAID_INVEST();
		helper = new PS_IL_CONT_PAID_INVEST_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_CPI_ACNT_YEAR_LABEL() {
		return COMP_CPI_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_CPI_ACNT_YEAR() {
		return COMP_CPI_ACNT_YEAR;
	}

	public void setCOMP_CPI_ACNT_YEAR_LABEL(
			HtmlOutputLabel COMP_CPI_ACNT_YEAR_LABEL) {
		this.COMP_CPI_ACNT_YEAR_LABEL = COMP_CPI_ACNT_YEAR_LABEL;
	}

	public void setCOMP_CPI_ACNT_YEAR(HtmlInputText COMP_CPI_ACNT_YEAR) {
		this.COMP_CPI_ACNT_YEAR = COMP_CPI_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_YR_END_DT_LABEL() {
		return COMP_UI_M_YR_END_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_YR_END_DT() {
		return COMP_UI_M_YR_END_DT;
	}

	public void setCOMP_UI_M_YR_END_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_YR_END_DT_LABEL) {
		this.COMP_UI_M_YR_END_DT_LABEL = COMP_UI_M_YR_END_DT_LABEL;
	}

	public void setCOMP_UI_M_YR_END_DT(HtmlCalendar COMP_UI_M_YR_END_DT) {
		this.COMP_UI_M_YR_END_DT = COMP_UI_M_YR_END_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACC_PA_END_BAL_LABEL() {
		return COMP_UI_M_ACC_PA_END_BAL_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACC_PA_END_BAL() {
		return COMP_UI_M_ACC_PA_END_BAL;
	}

	public void setCOMP_UI_M_ACC_PA_END_BAL_LABEL(
			HtmlOutputLabel COMP_UI_M_ACC_PA_END_BAL_LABEL) {
		this.COMP_UI_M_ACC_PA_END_BAL_LABEL = COMP_UI_M_ACC_PA_END_BAL_LABEL;
	}

	public void setCOMP_UI_M_ACC_PA_END_BAL(
			HtmlInputText COMP_UI_M_ACC_PA_END_BAL) {
		this.COMP_UI_M_ACC_PA_END_BAL = COMP_UI_M_ACC_PA_END_BAL;
	}

	public HtmlOutputLabel getCOMP_CPI_TXN_DT_LABEL() {
		return COMP_CPI_TXN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CPI_TXN_DT() {
		return COMP_CPI_TXN_DT;
	}

	public void setCOMP_CPI_TXN_DT_LABEL(HtmlOutputLabel COMP_CPI_TXN_DT_LABEL) {
		this.COMP_CPI_TXN_DT_LABEL = COMP_CPI_TXN_DT_LABEL;
	}

	public void setCOMP_CPI_TXN_DT(HtmlCalendar COMP_CPI_TXN_DT) {
		this.COMP_CPI_TXN_DT = COMP_CPI_TXN_DT;
	}

	public HtmlOutputLabel getCOMP_CPI_RCPT_AMT_LABEL() {
		return COMP_CPI_RCPT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_RCPT_AMT() {
		return COMP_CPI_RCPT_AMT;
	}

	public void setCOMP_CPI_RCPT_AMT_LABEL(
			HtmlOutputLabel COMP_CPI_RCPT_AMT_LABEL) {
		this.COMP_CPI_RCPT_AMT_LABEL = COMP_CPI_RCPT_AMT_LABEL;
	}

	public void setCOMP_CPI_RCPT_AMT(HtmlInputText COMP_CPI_RCPT_AMT) {
		this.COMP_CPI_RCPT_AMT = COMP_CPI_RCPT_AMT;
	}

	public HtmlOutputLabel getCOMP_CPI_MATCHED_AMT_LABEL() {
		return COMP_CPI_MATCHED_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_MATCHED_AMT() {
		return COMP_CPI_MATCHED_AMT;
	}

	public void setCOMP_CPI_MATCHED_AMT_LABEL(
			HtmlOutputLabel COMP_CPI_MATCHED_AMT_LABEL) {
		this.COMP_CPI_MATCHED_AMT_LABEL = COMP_CPI_MATCHED_AMT_LABEL;
	}

	public void setCOMP_CPI_MATCHED_AMT(HtmlInputText COMP_CPI_MATCHED_AMT) {
		this.COMP_CPI_MATCHED_AMT = COMP_CPI_MATCHED_AMT;
	}

	public HtmlOutputLabel getCOMP_CPI_PROFIT_LABEL() {
		return COMP_CPI_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_PROFIT() {
		return COMP_CPI_PROFIT;
	}

	public void setCOMP_CPI_PROFIT_LABEL(HtmlOutputLabel COMP_CPI_PROFIT_LABEL) {
		this.COMP_CPI_PROFIT_LABEL = COMP_CPI_PROFIT_LABEL;
	}

	public void setCOMP_CPI_PROFIT(HtmlInputText COMP_CPI_PROFIT) {
		this.COMP_CPI_PROFIT = COMP_CPI_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPI_DAY_EXP_LABEL() {
		return COMP_CPI_DAY_EXP_LABEL;
	}

	public HtmlInputText getCOMP_CPI_DAY_EXP() {
		return COMP_CPI_DAY_EXP;
	}

	public void setCOMP_CPI_DAY_EXP_LABEL(HtmlOutputLabel COMP_CPI_DAY_EXP_LABEL) {
		this.COMP_CPI_DAY_EXP_LABEL = COMP_CPI_DAY_EXP_LABEL;
	}

	public void setCOMP_CPI_DAY_EXP(HtmlInputText COMP_CPI_DAY_EXP) {
		this.COMP_CPI_DAY_EXP = COMP_CPI_DAY_EXP;
	}

	public HtmlOutputLabel getCOMP_CPI_PA_BAL_LABEL() {
		return COMP_CPI_PA_BAL_LABEL;
	}

	public HtmlInputText getCOMP_CPI_PA_BAL() {
		return COMP_CPI_PA_BAL;
	}

	public void setCOMP_CPI_PA_BAL_LABEL(HtmlOutputLabel COMP_CPI_PA_BAL_LABEL) {
		this.COMP_CPI_PA_BAL_LABEL = COMP_CPI_PA_BAL_LABEL;
	}

	public void setCOMP_CPI_PA_BAL(HtmlInputText COMP_CPI_PA_BAL) {
		this.COMP_CPI_PA_BAL = COMP_CPI_PA_BAL;
	}

	public HtmlOutputLabel getCOMP_CPI_RATE_LABEL() {
		return COMP_CPI_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CPI_RATE() {
		return COMP_CPI_RATE;
	}

	public void setCOMP_CPI_RATE_LABEL(HtmlOutputLabel COMP_CPI_RATE_LABEL) {
		this.COMP_CPI_RATE_LABEL = COMP_CPI_RATE_LABEL;
	}

	public void setCOMP_CPI_RATE(HtmlInputText COMP_CPI_RATE) {
		this.COMP_CPI_RATE = COMP_CPI_RATE;
	}

	public HtmlOutputLabel getCOMP_CPI_PA_PROFIT_LABEL() {
		return COMP_CPI_PA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_PA_PROFIT() {
		return COMP_CPI_PA_PROFIT;
	}

	public void setCOMP_CPI_PA_PROFIT_LABEL(
			HtmlOutputLabel COMP_CPI_PA_PROFIT_LABEL) {
		this.COMP_CPI_PA_PROFIT_LABEL = COMP_CPI_PA_PROFIT_LABEL;
	}

	public void setCOMP_CPI_PA_PROFIT(HtmlInputText COMP_CPI_PA_PROFIT) {
		this.COMP_CPI_PA_PROFIT = COMP_CPI_PA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPI_GFTA_PROFIT_LABEL() {
		return COMP_CPI_GFTA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_GFTA_PROFIT() {
		return COMP_CPI_GFTA_PROFIT;
	}

	public void setCOMP_CPI_GFTA_PROFIT_LABEL(
			HtmlOutputLabel COMP_CPI_GFTA_PROFIT_LABEL) {
		this.COMP_CPI_GFTA_PROFIT_LABEL = COMP_CPI_GFTA_PROFIT_LABEL;
	}

	public void setCOMP_CPI_GFTA_PROFIT(HtmlInputText COMP_CPI_GFTA_PROFIT) {
		this.COMP_CPI_GFTA_PROFIT = COMP_CPI_GFTA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPI_COVER_CODE_LABEL() {
		return COMP_CPI_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CPI_COVER_CODE() {
		return COMP_CPI_COVER_CODE;
	}

	public void setCOMP_CPI_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_CPI_COVER_CODE_LABEL) {
		this.COMP_CPI_COVER_CODE_LABEL = COMP_CPI_COVER_CODE_LABEL;
	}

	public void setCOMP_CPI_COVER_CODE(HtmlInputText COMP_CPI_COVER_CODE) {
		this.COMP_CPI_COVER_CODE = COMP_CPI_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_CPI_PSA_PROFIT_LABEL() {
		return COMP_CPI_PSA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_PSA_PROFIT() {
		return COMP_CPI_PSA_PROFIT;
	}

	public void setCOMP_CPI_PSA_PROFIT_LABEL(
			HtmlOutputLabel COMP_CPI_PSA_PROFIT_LABEL) {
		this.COMP_CPI_PSA_PROFIT_LABEL = COMP_CPI_PSA_PROFIT_LABEL;
	}

	public void setCOMP_CPI_PSA_PROFIT(HtmlInputText COMP_CPI_PSA_PROFIT) {
		this.COMP_CPI_PSA_PROFIT = COMP_CPI_PSA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPI_GFTA_RATE_LABEL() {
		return COMP_CPI_GFTA_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CPI_GFTA_RATE() {
		return COMP_CPI_GFTA_RATE;
	}

	public void setCOMP_CPI_GFTA_RATE_LABEL(
			HtmlOutputLabel COMP_CPI_GFTA_RATE_LABEL) {
		this.COMP_CPI_GFTA_RATE_LABEL = COMP_CPI_GFTA_RATE_LABEL;
	}

	public void setCOMP_CPI_GFTA_RATE(HtmlInputText COMP_CPI_GFTA_RATE) {
		this.COMP_CPI_GFTA_RATE = COMP_CPI_GFTA_RATE;
	}

	public HtmlOutputLabel getCOMP_CPI_PSA_RATE_LABEL() {
		return COMP_CPI_PSA_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CPI_PSA_RATE() {
		return COMP_CPI_PSA_RATE;
	}

	public void setCOMP_CPI_PSA_RATE_LABEL(
			HtmlOutputLabel COMP_CPI_PSA_RATE_LABEL) {
		this.COMP_CPI_PSA_RATE_LABEL = COMP_CPI_PSA_RATE_LABEL;
	}

	public void setCOMP_CPI_PSA_RATE(HtmlInputText COMP_CPI_PSA_RATE) {
		this.COMP_CPI_PSA_RATE = COMP_CPI_PSA_RATE;
	}

	public HtmlOutputLabel getCOMP_CPI_SUSPENSE_RATE_LABEL() {
		return COMP_CPI_SUSPENSE_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CPI_SUSPENSE_RATE() {
		return COMP_CPI_SUSPENSE_RATE;
	}

	public void setCOMP_CPI_SUSPENSE_RATE_LABEL(
			HtmlOutputLabel COMP_CPI_SUSPENSE_RATE_LABEL) {
		this.COMP_CPI_SUSPENSE_RATE_LABEL = COMP_CPI_SUSPENSE_RATE_LABEL;
	}

	public void setCOMP_CPI_SUSPENSE_RATE(HtmlInputText COMP_CPI_SUSPENSE_RATE) {
		this.COMP_CPI_SUSPENSE_RATE = COMP_CPI_SUSPENSE_RATE;
	}

	public HtmlOutputLabel getCOMP_CPI_RISK_FUND_LABEL() {
		return COMP_CPI_RISK_FUND_LABEL;
	}

	public HtmlInputText getCOMP_CPI_RISK_FUND() {
		return COMP_CPI_RISK_FUND;
	}

	public void setCOMP_CPI_RISK_FUND_LABEL(
			HtmlOutputLabel COMP_CPI_RISK_FUND_LABEL) {
		this.COMP_CPI_RISK_FUND_LABEL = COMP_CPI_RISK_FUND_LABEL;
	}

	public void setCOMP_CPI_RISK_FUND(HtmlInputText COMP_CPI_RISK_FUND) {
		this.COMP_CPI_RISK_FUND = COMP_CPI_RISK_FUND;
	}

	public HtmlOutputLabel getCOMP_UI_M_PA_PROFIT_COVERWISE_LABEL() {
		return COMP_UI_M_PA_PROFIT_COVERWISE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PA_PROFIT_COVERWISE() {
		return COMP_UI_M_PA_PROFIT_COVERWISE;
	}

	public void setCOMP_UI_M_PA_PROFIT_COVERWISE_LABEL(
			HtmlOutputLabel COMP_UI_M_PA_PROFIT_COVERWISE_LABEL) {
		this.COMP_UI_M_PA_PROFIT_COVERWISE_LABEL = COMP_UI_M_PA_PROFIT_COVERWISE_LABEL;
	}

	public void setCOMP_UI_M_PA_PROFIT_COVERWISE(
			HtmlInputText COMP_UI_M_PA_PROFIT_COVERWISE) {
		this.COMP_UI_M_PA_PROFIT_COVERWISE = COMP_UI_M_PA_PROFIT_COVERWISE;
	}

	public HtmlOutputLabel getCOMP_CPI_WD_AMT_LABEL() {
		return COMP_CPI_WD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_WD_AMT() {
		return COMP_CPI_WD_AMT;
	}

	public void setCOMP_CPI_WD_AMT_LABEL(HtmlOutputLabel COMP_CPI_WD_AMT_LABEL) {
		this.COMP_CPI_WD_AMT_LABEL = COMP_CPI_WD_AMT_LABEL;
	}

	public void setCOMP_CPI_WD_AMT(HtmlInputText COMP_CPI_WD_AMT) {
		this.COMP_CPI_WD_AMT = COMP_CPI_WD_AMT;
	}

	public HtmlOutputLabel getCOMP_CPI_MAT_AMT_LABEL() {
		return COMP_CPI_MAT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CPI_MAT_AMT() {
		return COMP_CPI_MAT_AMT;
	}

	public void setCOMP_CPI_MAT_AMT_LABEL(HtmlOutputLabel COMP_CPI_MAT_AMT_LABEL) {
		this.COMP_CPI_MAT_AMT_LABEL = COMP_CPI_MAT_AMT_LABEL;
	}

	public void setCOMP_CPI_MAT_AMT(HtmlInputText COMP_CPI_MAT_AMT) {
		this.COMP_CPI_MAT_AMT = COMP_CPI_MAT_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_RISK_FUND_LABEL() {
		return COMP_UI_M_RISK_FUND_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RISK_FUND() {
		return COMP_UI_M_RISK_FUND;
	}

	public void setCOMP_UI_M_RISK_FUND_LABEL(
			HtmlOutputLabel COMP_UI_M_RISK_FUND_LABEL) {
		this.COMP_UI_M_RISK_FUND_LABEL = COMP_UI_M_RISK_FUND_LABEL;
	}

	public void setCOMP_UI_M_RISK_FUND(HtmlInputText COMP_UI_M_RISK_FUND) {
		this.COMP_UI_M_RISK_FUND = COMP_UI_M_RISK_FUND;
	}

	public HtmlOutputLabel getCOMP_UI_M_PA_PROFIT_LABEL() {
		return COMP_UI_M_PA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PA_PROFIT() {
		return COMP_UI_M_PA_PROFIT;
	}

	public void setCOMP_UI_M_PA_PROFIT_LABEL(
			HtmlOutputLabel COMP_UI_M_PA_PROFIT_LABEL) {
		this.COMP_UI_M_PA_PROFIT_LABEL = COMP_UI_M_PA_PROFIT_LABEL;
	}

	public void setCOMP_UI_M_PA_PROFIT(HtmlInputText COMP_UI_M_PA_PROFIT) {
		this.COMP_UI_M_PA_PROFIT = COMP_UI_M_PA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPI_WAK_DUE_DATE_LABEL() {
		return COMP_CPI_WAK_DUE_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_CPI_WAK_DUE_DATE() {
		return COMP_CPI_WAK_DUE_DATE;
	}

	public void setCOMP_CPI_WAK_DUE_DATE_LABEL(
			HtmlOutputLabel COMP_CPI_WAK_DUE_DATE_LABEL) {
		this.COMP_CPI_WAK_DUE_DATE_LABEL = COMP_CPI_WAK_DUE_DATE_LABEL;
	}

	public void setCOMP_CPI_WAK_DUE_DATE(HtmlCalendar COMP_CPI_WAK_DUE_DATE) {
		this.COMP_CPI_WAK_DUE_DATE = COMP_CPI_WAK_DUE_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACC_PA_PRFT_LABEL() {
		return COMP_UI_M_ACC_PA_PRFT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACC_PA_PRFT() {
		return COMP_UI_M_ACC_PA_PRFT;
	}

	public void setCOMP_UI_M_ACC_PA_PRFT_LABEL(
			HtmlOutputLabel COMP_UI_M_ACC_PA_PRFT_LABEL) {
		this.COMP_UI_M_ACC_PA_PRFT_LABEL = COMP_UI_M_ACC_PA_PRFT_LABEL;
	}

	public void setCOMP_UI_M_ACC_PA_PRFT(HtmlInputText COMP_UI_M_ACC_PA_PRFT) {
		this.COMP_UI_M_ACC_PA_PRFT = COMP_UI_M_ACC_PA_PRFT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_1() {
		return COMP_UI_M_BUT_MAIN_1;
	}

	public void setCOMP_UI_M_BUT_MAIN_1(HtmlCommandButton COMP_UI_M_BUT_MAIN_1) {
		this.COMP_UI_M_BUT_MAIN_1 = COMP_UI_M_BUT_MAIN_1;
	}

	public PS_IL_CONT_PAID_INVEST getPS_IL_CONT_PAID_INVEST_BEAN() {
		return PS_IL_CONT_PAID_INVEST_BEAN;
	}

	public void setPS_IL_CONT_PAID_INVEST_BEAN(
			PS_IL_CONT_PAID_INVEST PS_IL_CONT_PAID_INVEST_BEAN) {
		this.PS_IL_CONT_PAID_INVEST_BEAN = PS_IL_CONT_PAID_INVEST_BEAN;
	}

	public List<PS_IL_CONT_PAID_INVEST> getDataList_PS_IL_CONT_PAID_INVEST() {
		return dataList_PS_IL_CONT_PAID_INVEST;
	}

	public void setDataListPS_IL_CONT_PAID_INVEST(
			List<PS_IL_CONT_PAID_INVEST> dataList_PS_IL_CONT_PAID_INVEST) {
		this.dataList_PS_IL_CONT_PAID_INVEST = dataList_PS_IL_CONT_PAID_INVEST;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PS_IL_CONT_PAID_INVEST_BEAN = new PS_IL_CONT_PAID_INVEST();
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

				new CRUDHandler().executeDelete(PS_IL_CONT_PAID_INVEST_BEAN,
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
				dataList_PS_IL_CONT_PAID_INVEST
						.remove(PS_IL_CONT_PAID_INVEST_BEAN);
				if (dataList_PS_IL_CONT_PAID_INVEST.size() > 0) {

					PS_IL_CONT_PAID_INVEST_BEAN = dataList_PS_IL_CONT_PAID_INVEST
							.get(0);
				} else if (dataList_PS_IL_CONT_PAID_INVEST.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PS_IL_CONT_PAID_INVEST_BEAN.setRowSelected(true);
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
			if (PS_IL_CONT_PAID_INVEST_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PS_IL_CONT_PAID_INVEST_BEAN,
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
				dataList_PS_IL_CONT_PAID_INVEST
						.add(PS_IL_CONT_PAID_INVEST_BEAN);
			} else if (PS_IL_CONT_PAID_INVEST_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PS_IL_CONT_PAID_INVEST_BEAN,
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

			PS_IL_CONT_PAID_INVEST_BEAN.setRowSelected(true);
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
			PS_IL_CONT_PAID_INVEST_BEAN = (PS_IL_CONT_PAID_INVEST) dataTable
					.getRowData();
			PS_IL_CONT_PAID_INVEST_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PS_IL_CONT_PAID_INVEST> PS_IL_CONT_PAID_INVEST_ITR = dataList_PS_IL_CONT_PAID_INVEST
				.iterator();
		while (PS_IL_CONT_PAID_INVEST_ITR.hasNext()) {
			PS_IL_CONT_PAID_INVEST_ITR.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_CPI_ACNT_YEAR.resetValue();
		//COMP_UI_M_YR_END_DT.resetValue();
		COMP_UI_M_ACC_PA_END_BAL.resetValue();
		COMP_CPI_TXN_DT.resetValue();
		COMP_CPI_RCPT_AMT.resetValue();
		COMP_CPI_MATCHED_AMT.resetValue();
		COMP_CPI_PROFIT.resetValue();
		COMP_CPI_DAY_EXP.resetValue();
		COMP_CPI_PA_BAL.resetValue();
		COMP_CPI_RATE.resetValue();
		COMP_CPI_PA_PROFIT.resetValue();
		COMP_CPI_GFTA_PROFIT.resetValue();
		COMP_CPI_COVER_CODE.resetValue();
		COMP_CPI_PSA_PROFIT.resetValue();
		COMP_CPI_GFTA_RATE.resetValue();
		COMP_CPI_PSA_RATE.resetValue();
		COMP_CPI_SUSPENSE_RATE.resetValue();
		COMP_CPI_RISK_FUND.resetValue();
		COMP_UI_M_PA_PROFIT_COVERWISE.resetValue();
		COMP_CPI_WD_AMT.resetValue();
		COMP_CPI_MAT_AMT.resetValue();
		COMP_UI_M_RISK_FUND.resetValue();
		COMP_UI_M_PA_PROFIT.resetValue();
		COMP_CPI_WAK_DUE_DATE.resetValue();
		COMP_UI_M_ACC_PA_PRFT.resetValue();
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
			//if (isBlockFlag()) {
				helper.whenNewBlockInstance();
				helper.executeQuery(compositeAction);
				helper.postQuery(compositeAction);
				//setBlockFlag(false);
			//}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	/**
	 * 
	 * @return
	 */
	public String mainButtonPress(){
		return "PQ124_A_PT_WAKALAH_DAILY_DRIP_1";
	}
	

	/**
	 * Instantiates all components in PS_IL_CONT_PAID_INVEST_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CPI_ACNT_YEAR				 = new HtmlInputText();
		COMP_UI_M_ACC_PA_END_BAL			 = new HtmlInputText();
		COMP_CPI_RCPT_AMT				 = new HtmlInputText();
		COMP_CPI_MATCHED_AMT				 = new HtmlInputText();
		COMP_CPI_PROFIT					 = new HtmlInputText();
		COMP_CPI_DAY_EXP				 = new HtmlInputText();
		COMP_CPI_PA_BAL					 = new HtmlInputText();
		COMP_CPI_RATE					 = new HtmlInputText();
		COMP_CPI_PA_PROFIT				 = new HtmlInputText();
		COMP_CPI_GFTA_PROFIT				 = new HtmlInputText();
		COMP_CPI_COVER_CODE				 = new HtmlInputText();
		COMP_CPI_PSA_PROFIT				 = new HtmlInputText();
		COMP_CPI_GFTA_RATE				 = new HtmlInputText();
		COMP_CPI_PSA_RATE				 = new HtmlInputText();
		COMP_CPI_SUSPENSE_RATE				 = new HtmlInputText();
		COMP_CPI_RISK_FUND				 = new HtmlInputText();
		COMP_UI_M_PA_PROFIT_COVERWISE			 = new HtmlInputText();
		COMP_CPI_WD_AMT					 = new HtmlInputText();
		COMP_CPI_MAT_AMT				 = new HtmlInputText();
		COMP_UI_M_RISK_FUND				 = new HtmlInputText();
		COMP_UI_M_PA_PROFIT				 = new HtmlInputText();
		COMP_UI_M_ACC_PA_PRFT				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_UI_M_YR_END_DT				 = new HtmlCalendar();
		COMP_CPI_TXN_DT					 = new HtmlCalendar();
		COMP_CPI_WAK_DUE_DATE				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_MAIN_1				 = new HtmlCommandButton();

	}


}
