package com.iii.pel.forms.PILP042_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_FUND_TRAN_DTL")
public class PT_IL_FUND_TRAN_DTL_1 extends BaseValueBean {

	@Column(name = "FTD_FUND_CODE")
	private String FTD_FUND_CODE_1;

	private String UI_M_DENIED_STATUS;

	private String UI_M_FUND_DESC_1;

	private Double UI_M_PREM=0d;

	private Double UI_M_TOPUP=0d;

	@Column(name = "FTD_UNIT_TYPE")
	private String FTD_UNIT_TYPE_1;

	@Column(name = "FTD_SELECT_YN")
	private String FTD_SELECT_YN;

	@Column(name = "FTD_NO_OF_UNITS")
	private Double FTD_NO_OF_UNITS_1;

	@Column(name = "FTD_FUND_PERC")
	private Double FTD_FUND_PERC;

	@Column(name = "FTD_UNIT_SEL_PRICE")
	private Double FTD_UNIT_SEL_PRICE_1;

	@Column(name = "FTD_UNIT_LC_AMT")
	private Double FTD_UNIT_LC_AMT_1;

	@Column(name = "FTD_NO_SEL_UNITS")
	private Double FTD_NO_SEL_UNITS_1;

	@Column(name = "FTD_NO_ALLOC_LC_AMT")
	private Double FTD_NO_ALLOC_LC_AMT_1;

	private Double UI_M_SUM_ALLOC_LC_VALUE_P;

	private Double UI_M_SUM_ALLOC_LC_VALUE_T;

	private Double UI_M_SUM_ALLOC_LC_VALUE;

	@Column(name = "FTD_TRAN_TYPE")
	private String FTD_TRAN_TYPE;

	@Column(name = "FTD_TRAN_FLAG")
	private String FTD_TRAN_FLAG;
	
	@Column(name = "FTD_BEF_SWT_PERC")
	private Double FTD_BEF_SWT_PERC;
	
	private Date FTD_CR_DT;
	
	

	private boolean selected;
	
	public Date getFTD_CR_DT() {
		return FTD_CR_DT;
	}

	public void setFTD_CR_DT(Date ftd_cr_dt) {
		FTD_CR_DT = ftd_cr_dt;
	}

	public String getFTD_SELECT_YN() {
		return FTD_SELECT_YN;
	}

	public void setFTD_SELECT_YN(String FTD_SELECT_YN) {
		this.FTD_SELECT_YN = FTD_SELECT_YN;
	}

	public String getFTD_FUND_CODE_1() {
		return FTD_FUND_CODE_1;
	}

	public void setFTD_FUND_CODE_1(String ftd_fund_code_1) {
		FTD_FUND_CODE_1 = ftd_fund_code_1;
	}

	public String getUI_M_FUND_DESC_1() {
		return UI_M_FUND_DESC_1;
	}

	public void setUI_M_FUND_DESC_1(String ui_m_fund_desc_1) {
		UI_M_FUND_DESC_1 = ui_m_fund_desc_1;
	}

	public String getFTD_UNIT_TYPE_1() {
		return FTD_UNIT_TYPE_1;
	}

	public void setFTD_UNIT_TYPE_1(String ftd_unit_type_1) {
		FTD_UNIT_TYPE_1 = ftd_unit_type_1;
	}

	public Double getFTD_NO_OF_UNITS_1() {
		return FTD_NO_OF_UNITS_1;
	}

	public void setFTD_NO_OF_UNITS_1(Double ftd_no_of_units_1) {
		FTD_NO_OF_UNITS_1 = ftd_no_of_units_1;
	}

	public Double getFTD_FUND_PERC() {
		return FTD_FUND_PERC;
	}

	public void setFTD_FUND_PERC(Double FTD_FUND_PERC) {
		this.FTD_FUND_PERC = FTD_FUND_PERC;
	}

	public Double getFTD_UNIT_SEL_PRICE_1() {
		return FTD_UNIT_SEL_PRICE_1;
	}

	public void setFTD_UNIT_SEL_PRICE_1(Double ftd_unit_sel_price_1) {
		FTD_UNIT_SEL_PRICE_1 = ftd_unit_sel_price_1;
	}

	public Double getFTD_UNIT_LC_AMT_1() {
		return FTD_UNIT_LC_AMT_1;
	}

	public void setFTD_UNIT_LC_AMT_1(Double ftd_unit_lc_amt_1) {
		FTD_UNIT_LC_AMT_1 = ftd_unit_lc_amt_1;
	}

	public Double getFTD_NO_SEL_UNITS_1() {
		return FTD_NO_SEL_UNITS_1;
	}

	public void setFTD_NO_SEL_UNITS_1(Double ftd_no_sel_units_1) {
		FTD_NO_SEL_UNITS_1 = ftd_no_sel_units_1;
	}

	public Double getUI_M_SUM_ALLOC_LC_VALUE_P() {
		return UI_M_SUM_ALLOC_LC_VALUE_P;
	}

	public void setUI_M_SUM_ALLOC_LC_VALUE_P(Double UI_M_SUM_ALLOC_LC_VALUE_P) {
		this.UI_M_SUM_ALLOC_LC_VALUE_P = UI_M_SUM_ALLOC_LC_VALUE_P;
	}

	public Double getFTD_NO_ALLOC_LC_AMT_1() {
		return FTD_NO_ALLOC_LC_AMT_1;
	}

	public void setFTD_NO_ALLOC_LC_AMT_1(Double ftd_no_alloc_lc_amt_1) {
		FTD_NO_ALLOC_LC_AMT_1 = ftd_no_alloc_lc_amt_1;
	}

	public Double getUI_M_SUM_ALLOC_LC_VALUE_T() {
		return UI_M_SUM_ALLOC_LC_VALUE_T;
	}

	public void setUI_M_SUM_ALLOC_LC_VALUE_T(Double UI_M_SUM_ALLOC_LC_VALUE_T) {
		this.UI_M_SUM_ALLOC_LC_VALUE_T = UI_M_SUM_ALLOC_LC_VALUE_T;
	}

	public Double getUI_M_SUM_ALLOC_LC_VALUE() {
		return UI_M_SUM_ALLOC_LC_VALUE;
	}

	public void setUI_M_SUM_ALLOC_LC_VALUE(Double UI_M_SUM_ALLOC_LC_VALUE) {
		this.UI_M_SUM_ALLOC_LC_VALUE = UI_M_SUM_ALLOC_LC_VALUE;
	}

	public String getUI_M_DENIED_STATUS() {
		return UI_M_DENIED_STATUS;
	}

	public void setUI_M_DENIED_STATUS(String ui_m_denied_status) {
		UI_M_DENIED_STATUS = ui_m_denied_status;
	}

	public Double getUI_M_PREM() {
		return UI_M_PREM;
	}

	public void setUI_M_PREM(Double ui_m_prem) {
		UI_M_PREM = ui_m_prem;
	}

	public Double getUI_M_TOPUP() {
		return UI_M_TOPUP;
	}

	public void setUI_M_TOPUP(Double ui_m_topup) {
		UI_M_TOPUP = ui_m_topup;
	}

	public String getFTD_TRAN_TYPE() {
		return FTD_TRAN_TYPE;
	}

	public void setFTD_TRAN_TYPE(String ftd_tran_type) {
		FTD_TRAN_TYPE = ftd_tran_type;
	}

	public String getFTD_TRAN_FLAG() {
		return FTD_TRAN_FLAG;
	}

	public void setFTD_TRAN_FLAG(String ftd_tran_flag) {
		FTD_TRAN_FLAG = ftd_tran_flag;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getFTD_BEF_SWT_PERC() {
		return FTD_BEF_SWT_PERC;
	}

	public void setFTD_BEF_SWT_PERC(Double ftd_bef_swt_perc) {
		FTD_BEF_SWT_PERC = ftd_bef_swt_perc;
	}

	@Column(name = "FTD_SWITCH_BASED_ON")
	private String FTD_SWITCH_BASED_ON;

	public String getFTD_SWITCH_BASED_ON() {
		return FTD_SWITCH_BASED_ON;
	}

	public void setFTD_SWITCH_BASED_ON(String fTD_SWITCH_BASED_ON) {
		FTD_SWITCH_BASED_ON = fTD_SWITCH_BASED_ON;
	}
	
	
	


}
