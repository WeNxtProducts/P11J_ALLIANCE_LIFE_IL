package com.iii.pel.forms.PILT027;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_DEPOSIT_CHARGE")
public class PT_IL_DEPOSIT_CHARGE extends BaseValueBean {

	@Column(name="DCHRG_CODE")
	private String DCHRG_CODE;

	private String UI_M_CHARGE_DESC;

	@Column(name="DCHRG_RATE")
	private Double DCHRG_RATE;
	
	@Column(name="DCHRG_RATE_PER")
	private Double DCHRG_RATE_PER;

	private Double UI_M_DCHRG_TOTAL_FC_AMT;
	private Double UI_M_DCHRG_TOTAL_LC_AMT;
	
	@Column(name="DCHRG_DEP_SYS_ID")
	private Long DCHRG_DEP_SYS_ID;

	@Column(name="DCHRG_CR_UID")
	private String DCHRG_CR_UID; 
	
	@Column(name="DCHRG_TYPE")
	private String DCHRG_TYPE; 
	
	@Column(name="DCHRG_CR_DT")
	private Date DCHRG_CR_DT;   
	
	@Column(name="DCHRG_FC_AMT")
	private Double DCHRG_FC_AMT;
	
	@Column(name="DCHRG_LC_AMT")
	private Double DCHRG_LC_AMT;
	
	@Column(name="DCHRG_FLEX_01")
	private String DCHRG_FLEX_01;
	
	@Column(name="DCHRG_FLEX_02")
	private String DCHRG_FLEX_02;

	public String getDCHRG_CR_UID() {
		return DCHRG_CR_UID;
	}

	public void setDCHRG_CR_UID(String dchrg_cr_uid) {
		DCHRG_CR_UID = dchrg_cr_uid;
	}

	public Date getDCHRG_CR_DT() {
		return DCHRG_CR_DT;
	}

	public void setDCHRG_CR_DT(Date dchrg_cr_dt) {
		DCHRG_CR_DT = dchrg_cr_dt;
	}

	public String getDCHRG_CODE() {
		return DCHRG_CODE;
	}

	public void setDCHRG_CODE(String DCHRG_CODE) {
		this.DCHRG_CODE = DCHRG_CODE;
	}

	public String getUI_M_CHARGE_DESC() {
		return UI_M_CHARGE_DESC;
	}

	public void setUI_M_CHARGE_DESC(String UI_M_CHARGE_DESC) {
		this.UI_M_CHARGE_DESC = UI_M_CHARGE_DESC;
	}

	public Double getDCHRG_RATE() {
		return DCHRG_RATE;
	}

	public void setDCHRG_RATE(Double DCHRG_RATE) {
		this.DCHRG_RATE = DCHRG_RATE;
	}

	public Double getUI_M_DCHRG_TOTAL_LC_AMT() {
		return UI_M_DCHRG_TOTAL_LC_AMT;
	}

	public void setUI_M_DCHRG_TOTAL_LC_AMT(Double UI_M_DCHRG_TOTAL_LC_AMT) {
		this.UI_M_DCHRG_TOTAL_LC_AMT = UI_M_DCHRG_TOTAL_LC_AMT;
	}

	

	public Long getDCHRG_DEP_SYS_ID() {
		return DCHRG_DEP_SYS_ID;
	}

	public void setDCHRG_DEP_SYS_ID(Long dchrg_dep_sys_id) {
		DCHRG_DEP_SYS_ID = dchrg_dep_sys_id;
	}

	public Double getDCHRG_RATE_PER() {
		return DCHRG_RATE_PER;
	}

	public void setDCHRG_RATE_PER(Double dchrg_rate_per) {
		DCHRG_RATE_PER = dchrg_rate_per;
	}

	public String getDCHRG_FLEX_01() {
		return DCHRG_FLEX_01;
	}

	public void setDCHRG_FLEX_01(String dchrg_flex_01) {
		DCHRG_FLEX_01 = dchrg_flex_01;
	}

	public String getDCHRG_FLEX_02() {
		return DCHRG_FLEX_02;
	}

	public void setDCHRG_FLEX_02(String dchrg_flex_02) {
		DCHRG_FLEX_02 = dchrg_flex_02;
	}

	public Double getDCHRG_FC_AMT() {
		return DCHRG_FC_AMT;
	}

	public void setDCHRG_FC_AMT(Double dchrg_fc_amt) {
		DCHRG_FC_AMT = dchrg_fc_amt;
	}

	public Double getDCHRG_LC_AMT() {
		return DCHRG_LC_AMT;
	}

	public void setDCHRG_LC_AMT(Double dchrg_lc_amt) {
		DCHRG_LC_AMT = dchrg_lc_amt;
	}

	public Double getUI_M_DCHRG_TOTAL_FC_AMT() {
		return UI_M_DCHRG_TOTAL_FC_AMT;
	}

	public void setUI_M_DCHRG_TOTAL_FC_AMT(Double ui_m_dchrg_total_fc_amt) {
		UI_M_DCHRG_TOTAL_FC_AMT = ui_m_dchrg_total_fc_amt;
	}

	public String getDCHRG_TYPE() {
		return DCHRG_TYPE;
	}

	public void setDCHRG_TYPE(String dchrg_type) {
		DCHRG_TYPE = dchrg_type;
	}
}
