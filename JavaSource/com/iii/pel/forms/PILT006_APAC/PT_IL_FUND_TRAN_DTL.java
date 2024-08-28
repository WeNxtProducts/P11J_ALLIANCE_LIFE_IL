package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FUND_TRAN_DTL")
public class PT_IL_FUND_TRAN_DTL extends BaseValueBean {

	private String FTD_FUND_CODE_DESC;

	@Column(name="FTD_SYS_ID")
	private Long FTD_SYS_ID;                                                                                                                                                                                    
	@Column(name="FTD_TRAN_SYS_ID")
	private Long FTD_TRAN_SYS_ID;                                                                                                                                                                                    
	@Column(name="FTD_POL_SYS_ID")
	private Long FTD_POL_SYS_ID;                                                                                                                                                                                    
	@Column(name="FTD_TRAN_TYPE")
	private String FTD_TRAN_TYPE;                                                                                                                                                                                   
	@Column(name="FTD_TRAN_FLAG")
	private String FTD_TRAN_FLAG;                                                                                                                                                                                   
	@Column(name="FTD_FUND_CODE")
	private String FTD_FUND_CODE;                                                                                                                                                                                  
	@Column(name="FTD_FUND_PERC")
	private Double FTD_FUND_PERC;                                                                                                                                                                                   
	@Column(name="FTD_NO_OF_UNITS")
	private Double FTD_NO_OF_UNITS;                                                                                                                                                                                  
	@Column(name="FTD_UNIT_PUR_PRICE")
	private Double FTD_UNIT_PUR_PRICE;                                                                                                                                                                                  
	@Column(name="FTD_UNIT_SEL_PRICE")
	private Double FTD_UNIT_SEL_PRICE;                                                                                                                                                                                  
	@Column(name="FTD_UNIT_LC_AMT")
	private Double FTD_UNIT_LC_AMT;                                                                                                                                                                                  
	@Column(name="FTD_SELECT_YN")
	private String FTD_SELECT_YN;                                                                                                                                                                                   
	@Column(name="FTD_NO_SEL_UNITS")
	private Double FTD_NO_SEL_UNITS;                                                                                                                                                                                  
	@Column(name="FTD_NO_ALLOC_LC_AMT")
	private Double FTD_NO_ALLOC_LC_AMT;                                                                                                                                                                                  
	@Column(name="FTD_CR_UID")
	private String FTD_CR_UID;                                                                                                                                                                                  
	@Column(name="FTD_CR_DT")
	private Date FTD_CR_DT;                                                                                                                                                                                          
	@Column(name="FTD_UPD_UID")
	private String FTD_UPD_UID;                                                                                                                                                                                  
	@Column(name="FTD_UPD_DT")
	private Date FTD_UPD_DT;                                                                                                                                                                                          
	@Column(name="FTD_TOP_UP_UNITS")
	private Double FTD_TOP_UP_UNITS;                                                                                                                                                                                  
	@Column(name="FTD_PREM_UNITS")
	private Double FTD_PREM_UNITS;                                                                                                                                                                                  
	@Column(name="FTD_TOP_UP_SEL_UNITS")
	private Double FTD_TOP_UP_SEL_UNITS;                                                                                                                                                                                  
	@Column(name="FTD_PREM_SEL_UNITS")
	private Double FTD_PREM_SEL_UNITS;                                                                                                                                                                                  
	@Column(name="FTD_UNIT_TYPE")
	private String FTD_UNIT_TYPE;
	@Column(name="FTD_BEF_SWT_PERC")
	private Double FTD_BEF_SWT_PERC;
	@Column(name="FTD_WITHDRAWAL_BY")
	private String FTD_WITHDRAWAL_BY;
	
	public String getFTD_FUND_CODE_DESC() {
		return FTD_FUND_CODE_DESC;
	}
	public void setFTD_FUND_CODE_DESC(String ftd_fund_code_desc) {
		FTD_FUND_CODE_DESC = ftd_fund_code_desc;
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
	public Long getFTD_POL_SYS_ID() {
		return FTD_POL_SYS_ID;
	}
	public void setFTD_POL_SYS_ID(Long ftd_pol_sys_id) {
		FTD_POL_SYS_ID = ftd_pol_sys_id;
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
	public String getFTD_FUND_CODE() {
		return FTD_FUND_CODE;
	}
	public void setFTD_FUND_CODE(String ftd_fund_code) {
		FTD_FUND_CODE = ftd_fund_code;
	}
	public Double getFTD_FUND_PERC() {
		return FTD_FUND_PERC;
	}
	public void setFTD_FUND_PERC(Double ftd_fund_perc) {
		FTD_FUND_PERC = ftd_fund_perc;
	}
	public Double getFTD_NO_OF_UNITS() {
		return FTD_NO_OF_UNITS;
	}
	public void setFTD_NO_OF_UNITS(Double ftd_no_of_units) {
		FTD_NO_OF_UNITS = ftd_no_of_units;
	}
	public Double getFTD_UNIT_PUR_PRICE() {
		return FTD_UNIT_PUR_PRICE;
	}
	public void setFTD_UNIT_PUR_PRICE(Double ftd_unit_pur_price) {
		FTD_UNIT_PUR_PRICE = ftd_unit_pur_price;
	}
	public Double getFTD_UNIT_SEL_PRICE() {
		return FTD_UNIT_SEL_PRICE;
	}
	public void setFTD_UNIT_SEL_PRICE(Double ftd_unit_sel_price) {
		FTD_UNIT_SEL_PRICE = ftd_unit_sel_price;
	}
	public Double getFTD_UNIT_LC_AMT() {
		return FTD_UNIT_LC_AMT;
	}
	public void setFTD_UNIT_LC_AMT(Double ftd_unit_lc_amt) {
		FTD_UNIT_LC_AMT = ftd_unit_lc_amt;
	}
	public String getFTD_SELECT_YN() {
		return FTD_SELECT_YN;
	}
	public void setFTD_SELECT_YN(String ftd_select_yn) {
		FTD_SELECT_YN = ftd_select_yn;
	}
	public Double getFTD_NO_SEL_UNITS() {
		return FTD_NO_SEL_UNITS;
	}
	public void setFTD_NO_SEL_UNITS(Double ftd_no_sel_units) {
		FTD_NO_SEL_UNITS = ftd_no_sel_units;
	}
	public Double getFTD_NO_ALLOC_LC_AMT() {
		return FTD_NO_ALLOC_LC_AMT;
	}
	public void setFTD_NO_ALLOC_LC_AMT(Double ftd_no_alloc_lc_amt) {
		FTD_NO_ALLOC_LC_AMT = ftd_no_alloc_lc_amt;
	}
	public String getFTD_CR_UID() {
		return FTD_CR_UID;
	}
	public void setFTD_CR_UID(String ftd_cr_uid) {
		FTD_CR_UID = ftd_cr_uid;
	}
	public Date getFTD_CR_DT() {
		return FTD_CR_DT;
	}
	public void setFTD_CR_DT(Date ftd_cr_dt) {
		FTD_CR_DT = ftd_cr_dt;
	}
	public String getFTD_UPD_UID() {
		return FTD_UPD_UID;
	}
	public void setFTD_UPD_UID(String ftd_upd_uid) {
		FTD_UPD_UID = ftd_upd_uid;
	}
	public Date getFTD_UPD_DT() {
		return FTD_UPD_DT;
	}
	public void setFTD_UPD_DT(Date ftd_upd_dt) {
		FTD_UPD_DT = ftd_upd_dt;
	}
	public Double getFTD_TOP_UP_UNITS() {
		return FTD_TOP_UP_UNITS;
	}
	public void setFTD_TOP_UP_UNITS(Double ftd_top_up_units) {
		FTD_TOP_UP_UNITS = ftd_top_up_units;
	}
	public Double getFTD_PREM_UNITS() {
		return FTD_PREM_UNITS;
	}
	public void setFTD_PREM_UNITS(Double ftd_prem_units) {
		FTD_PREM_UNITS = ftd_prem_units;
	}
	public Double getFTD_TOP_UP_SEL_UNITS() {
		return FTD_TOP_UP_SEL_UNITS;
	}
	public void setFTD_TOP_UP_SEL_UNITS(Double ftd_top_up_sel_units) {
		FTD_TOP_UP_SEL_UNITS = ftd_top_up_sel_units;
	}
	public Double getFTD_PREM_SEL_UNITS() {
		return FTD_PREM_SEL_UNITS;
	}
	public void setFTD_PREM_SEL_UNITS(Double ftd_prem_sel_units) {
		FTD_PREM_SEL_UNITS = ftd_prem_sel_units;
	}
	public String getFTD_UNIT_TYPE() {
		return FTD_UNIT_TYPE;
	}
	public void setFTD_UNIT_TYPE(String ftd_unit_type) {
		FTD_UNIT_TYPE = ftd_unit_type;
	}
	public Double getFTD_BEF_SWT_PERC() {
		return FTD_BEF_SWT_PERC;
	}
	public void setFTD_BEF_SWT_PERC(Double ftd_bef_swt_perc) {
		FTD_BEF_SWT_PERC = ftd_bef_swt_perc;
	}
	public String getFTD_WITHDRAWAL_BY() {
		return FTD_WITHDRAWAL_BY;
	}
	public void setFTD_WITHDRAWAL_BY(String ftd_withdrawal_by) {
		FTD_WITHDRAWAL_BY = ftd_withdrawal_by;
	}
}
