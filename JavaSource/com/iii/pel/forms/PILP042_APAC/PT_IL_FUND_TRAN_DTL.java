package com.iii.pel.forms.PILP042_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_FUND_TRAN_DTL")
public class PT_IL_FUND_TRAN_DTL extends BaseValueBean {

	@Column(name = "FTD_FUND_CODE")
	private String FTD_FUND_CODE;

	private String UI_M_PFTD_FUND_DESC;

	@Column(name = "FTD_UNIT_TYPE")
	private String FTD_UNIT_TYPE="P";

	@Column(name = "FTD_FUND_PERC")
	private Double FTD_FUND_PERC ;

	@Column(name = "FTD_UNIT_PUR_PRICE")
	private Double FTD_UNIT_PUR_PRICE ;

	@Column(name = "FTD_NO_OF_UNITS")
	private Double FTD_NO_OF_UNITS ;

	@Column(name = "FTD_UNIT_SEL_PRICE")
	private Double FTD_UNIT_SEL_PRICE ;

	@Column(name = "FTD_UNIT_LC_AMT")
	private Double FTD_UNIT_LC_AMT ;

	@Column(name = "FTD_SYS_ID")
	private Long FTD_SYS_ID ;

	@Column(name = "FTD_TRAN_SYS_ID")
	private Long FTD_TRAN_SYS_ID;

	@Column(name = "FTD_CR_DT")
	private Date FTD_CR_DT;

	@Column(name = "FTD_CR_UID")
	private String FTD_CR_UID;

	@Column(name = "FTD_TRAN_FLAG")
	private String FTD_TRAN_FLAG;

	@Column(name = "FTD_TRAN_TYPE")
	private String FTD_TRAN_TYPE;

	@Column(name = "FTD_UPD_DT")
	private Date FTD_UPD_DT;

	@Column(name = "FTD_UPD_UID")
	private String FTD_UPD_UID;

	@Column(name = "FTD_POL_SYS_ID")
    private Long FTD_POL_SYS_ID;
	
	private Double UI_M_FUND_PERC_P ;


	private Double UI_M_TOT_FUND_PERC_P ;


	private Double UI_M_FUND_PERC_T ;


	private Double UI_M_TOT_FUND_PERC_T ;

	private boolean selected;
	
	private boolean fundAllocated;
	
	
	public String getFTD_FUND_CODE() {
		return FTD_FUND_CODE;
	}

	public void setFTD_FUND_CODE(String FTD_FUND_CODE) {
		this.FTD_FUND_CODE = FTD_FUND_CODE;
	}

	public String getUI_M_PFTD_FUND_DESC() {
		return UI_M_PFTD_FUND_DESC;
	}

	public void setUI_M_PFTD_FUND_DESC(String UI_M_PFTD_FUND_DESC) {
		this.UI_M_PFTD_FUND_DESC = UI_M_PFTD_FUND_DESC;
	}

	public String getFTD_UNIT_TYPE() {
		return FTD_UNIT_TYPE;
	}

	public void setFTD_UNIT_TYPE(String FTD_UNIT_TYPE) {
		this.FTD_UNIT_TYPE = FTD_UNIT_TYPE;
	}

	public Double getFTD_FUND_PERC() {
		return FTD_FUND_PERC;
	}

	public void setFTD_FUND_PERC(Double FTD_FUND_PERC) {
		this.FTD_FUND_PERC = FTD_FUND_PERC;
	}

	public Double getFTD_UNIT_PUR_PRICE() {
		return FTD_UNIT_PUR_PRICE;
	}

	public void setFTD_UNIT_PUR_PRICE(Double FTD_UNIT_PUR_PRICE) {
		this.FTD_UNIT_PUR_PRICE = FTD_UNIT_PUR_PRICE;
	}

	public Double getFTD_NO_OF_UNITS() {
		return FTD_NO_OF_UNITS;
	}

	public void setFTD_NO_OF_UNITS(Double FTD_NO_OF_UNITS) {
		this.FTD_NO_OF_UNITS = FTD_NO_OF_UNITS;
	}

	public Double getFTD_UNIT_SEL_PRICE() {
		return FTD_UNIT_SEL_PRICE;
	}

	public void setFTD_UNIT_SEL_PRICE(Double FTD_UNIT_SEL_PRICE) {
		this.FTD_UNIT_SEL_PRICE = FTD_UNIT_SEL_PRICE;
	}

	public Double getFTD_UNIT_LC_AMT() {
		return FTD_UNIT_LC_AMT;
	}

	public void setFTD_UNIT_LC_AMT(Double FTD_UNIT_LC_AMT) {
		this.FTD_UNIT_LC_AMT = FTD_UNIT_LC_AMT;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Long getFTD_SYS_ID() {
		return FTD_SYS_ID;
	}

	public void setFTD_SYS_ID(Long ftd_sys_id) {
		FTD_SYS_ID = ftd_sys_id;
	}

	public Long getFTD_TRAN_SYS_ID() {
		return FTD_TRAN_SYS_ID;
	}

	public void setFTD_TRAN_SYS_ID(Long ftd_tran_sys_id) {
		FTD_TRAN_SYS_ID = ftd_tran_sys_id;
	}

	public Date getFTD_CR_DT() {
		return FTD_CR_DT;
	}

	public void setFTD_CR_DT(Date ftd_cr_dt) {
		FTD_CR_DT = ftd_cr_dt;
	}

	public String getFTD_CR_UID() {
		return FTD_CR_UID;
	}

	public void setFTD_CR_UID(String ftd_cr_uid) {
		FTD_CR_UID = ftd_cr_uid;
	}

	public String getFTD_TRAN_FLAG() {
		return FTD_TRAN_FLAG;
	}

	public void setFTD_TRAN_FLAG(String ftd_tran_flag) {
		FTD_TRAN_FLAG = ftd_tran_flag;
	}

	public String getFTD_TRAN_TYPE() {
		return FTD_TRAN_TYPE;
	}

	public void setFTD_TRAN_TYPE(String ftd_tran_type) {
		FTD_TRAN_TYPE = ftd_tran_type;
	}

	public Date getFTD_UPD_DT() {
		return FTD_UPD_DT;
	}

	public void setFTD_UPD_DT(Date ftd_upd_dt) {
		FTD_UPD_DT = ftd_upd_dt;
	}

	public String getFTD_UPD_UID() {
		return FTD_UPD_UID;
	}

	public void setFTD_UPD_UID(String ftd_upd_uid) {
		FTD_UPD_UID = ftd_upd_uid;
	}

	public Double getUI_M_FUND_PERC_P() {
		return UI_M_FUND_PERC_P;
	}

	public void setUI_M_FUND_PERC_P(Double ui_m_fund_perc_p) {
		UI_M_FUND_PERC_P = ui_m_fund_perc_p;
	}

	public Double getUI_M_TOT_FUND_PERC_P() {
		return UI_M_TOT_FUND_PERC_P;
	}

	public void setUI_M_TOT_FUND_PERC_P(Double ui_m_tot_fund_perc_p) {
		UI_M_TOT_FUND_PERC_P = ui_m_tot_fund_perc_p;
	}

	public Double getUI_M_FUND_PERC_T() {
		return UI_M_FUND_PERC_T;
	}

	public void setUI_M_FUND_PERC_T(Double ui_m_fund_perc_t) {
		UI_M_FUND_PERC_T = ui_m_fund_perc_t;
	}

	public Double getUI_M_TOT_FUND_PERC_T() {
		return UI_M_TOT_FUND_PERC_T;
	}

	public void setUI_M_TOT_FUND_PERC_T(Double ui_m_tot_fund_perc_t) {
		UI_M_TOT_FUND_PERC_T = ui_m_tot_fund_perc_t;
	}

	public Long getFTD_POL_SYS_ID() {
		return FTD_POL_SYS_ID;
	}

	public void setFTD_POL_SYS_ID(Long ftd_pol_sys_id) {
		FTD_POL_SYS_ID = ftd_pol_sys_id;
	}

	public boolean isFundAllocated() {
		return fundAllocated;
	}

	public void setFundAllocated(boolean fundAllocated) {
		this.fundAllocated = fundAllocated;
	}
}
