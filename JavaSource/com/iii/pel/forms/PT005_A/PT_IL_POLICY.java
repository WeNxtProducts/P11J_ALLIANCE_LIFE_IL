package com.iii.pel.forms.PT005_A;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {

	@Column(name="POL_CUST_CODE")
	private String POL_CUST_CODE;

	private String CUST_NAME;

	@Column(name="POL_NO")
	private String POL_NO;
	
	@Column(name="POL_END_NO")
	private String POL_END_NO;

	@Column(name="POL_QUOT_NO")
	private String POL_QUOT_NO;
	
	@Column(name="POL_SYS_ID")
	private String POL_SYS_ID;

	private Double UI_M_DRCR_TOT_DR;
	private Double UI_M_DRCR_TOT_CR;
	
	public Double getUI_M_DRCR_TOT_DR() {
		return UI_M_DRCR_TOT_DR;
	}

	public void setUI_M_DRCR_TOT_DR(Double ui_m_drcr_tot_dr) {
		UI_M_DRCR_TOT_DR = ui_m_drcr_tot_dr;
	}

	public Double getUI_M_DRCR_TOT_CR() {
		return UI_M_DRCR_TOT_CR;
	}

	public void setUI_M_DRCR_TOT_CR(Double ui_m_drcr_tot_cr) {
		UI_M_DRCR_TOT_CR = ui_m_drcr_tot_cr;
	}

	public String getPOL_CUST_CODE() {
		return POL_CUST_CODE;
	}

	public void setPOL_CUST_CODE(String POL_CUST_CODE) {
		this.POL_CUST_CODE = POL_CUST_CODE;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String CUST_NAME) {
		this.CUST_NAME = CUST_NAME;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public String getPOL_QUOT_NO() {
		return POL_QUOT_NO;
	}

	public void setPOL_QUOT_NO(String POL_QUOT_NO) {
		this.POL_QUOT_NO = POL_QUOT_NO;
	}

	public String getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(String pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public String getPOL_END_NO() {
		return POL_END_NO;
	}

	public void setPOL_END_NO(String pol_end_no) {
		POL_END_NO = pol_end_no;
	}
}
