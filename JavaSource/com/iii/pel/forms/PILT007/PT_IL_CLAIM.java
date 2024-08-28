package com.iii.pel.forms.PILT007;

import java.io.Serializable;
import java.sql.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM")
public class PT_IL_CLAIM extends BaseValueBean implements Serializable, Cloneable {
	
	@Column(name="CLAIM_NO")
	private String CLAIM_NO;

	@Column(name="CLAIM_POL_NO")
	private String CLAIM_POL_NO;
	
	@Column(name="CLAIM_ASSR_CODE")
	private String CLAIM_ASSURED_CODE;

	private String UI_M_CLAIM_ASSURED_NAME;
	
	@Column(name="CLAIM_SYS_ID")
	private Long CLAIM_SYS_ID;
	
	@Column(name="CLAIM_POL_SYS_ID")
	private Long CLAIM_POL_SYS_ID;
	
	@Column(name="CLAIM_FRZ_FLAG")
	private String CLAIM_FRZ_FLAG;
	
	@Column(name="CLAIM_DS_CODE")
	private String CLAIM_DS_CODE;
	
	@Column(name="CLAIM_POAD_SERIAL_NO")
	private Double CLAIM_POAD_SERIAL_NO;
	
	@Column(name="CLAIM_CURR_CODE")
	private String CLAIM_CURR_CODE;
	
	@Column(name="CLAIM_EXCH_RATE")
	private Double CLAIM_EXCH_RATE;
	
	@Column(name="CLAIM_CR_UID")
	private String CLAIM_CR_UID;
	
	@Column(name="CLAIM_CR_DT")
	private Date CLAIM_CR_DT;
	
	@Column(name="CLAIM_LOSS_DT")
	private Date CLAIM_LOSS_DT;
	
	@Column(name="CLAIM_UPD_UID")
	private String CLAIM_UPD_UID;
	
	@Column(name="CLAIM_UPD_DT")
	private Date CLAIM_UPD_DT;
	
	@Column(name="CLAIM_CUST_CODE")
	private String CLAIM_CUST_CODE;
	
	@Column(name="CLAIM_PAY_TO")
	private String CLAIM_PAY_TO;
	
	@Column(name="CLAIM_CLOSE_FLAG")
	private String CLAIM_CLOSE_FLAG;
	
	@Column(name="CLAIM_STATUS")
	private String CLAIM_STATUS;
	
	@Column(name="CLAIM_ADDL_STATUS")
	private String CLAIM_ADDL_STATUS;
	
	
	
	
	private String UI_M_POL_PROD_CODE;
	
	private String UI_M_POL_SA_CURR_CODE;
	
	private String UI_M_BASE_CURR;
	
	private String UI_M_BUY_SELL;
	
	private String UI_M_PS_VALUE;
	
	private Double UI_M_IL_BEN_VALUE;
	
	private String UI_M_CALC_METHOD;
	
	private String UI_M_PT_IL_CLAIM_PAID_CF;
	
	private String UI_M_PT_IL_CLAIM_BENEFICIARY_CF;
	
	private boolean selected = false;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCLAIM_NO() {
		return CLAIM_NO;
	}

	public void setCLAIM_NO(String CLAIM_NO) {
		this.CLAIM_NO = CLAIM_NO;
	}

	public String getCLAIM_POL_NO() {
		return CLAIM_POL_NO;
	}

	public void setCLAIM_POL_NO(String CLAIM_POL_NO) {
		this.CLAIM_POL_NO = CLAIM_POL_NO;
	}

	public String getUI_M_CLAIM_ASSURED_NAME() {
		return UI_M_CLAIM_ASSURED_NAME;
	}

	public void setUI_M_CLAIM_ASSURED_NAME(String UI_M_CLAIM_ASSURED_NAME) {
		this.UI_M_CLAIM_ASSURED_NAME = UI_M_CLAIM_ASSURED_NAME;
	}

	public String getCLAIM_ASSURED_CODE() {
		return CLAIM_ASSURED_CODE;
	}

	public void setCLAIM_ASSURED_CODE(String claim_assured_code) {
		CLAIM_ASSURED_CODE = claim_assured_code;
	}

	public Long getCLAIM_SYS_ID() {
		return CLAIM_SYS_ID;
	}

	public void setCLAIM_SYS_ID(Long claim_sys_id) {
		CLAIM_SYS_ID = claim_sys_id;
	}

	public Long getCLAIM_POL_SYS_ID() {
		return CLAIM_POL_SYS_ID;
	}

	public void setCLAIM_POL_SYS_ID(Long claim_pol_sys_id) {
		CLAIM_POL_SYS_ID = claim_pol_sys_id;
	}

	public String getCLAIM_FRZ_FLAG() {
		return CLAIM_FRZ_FLAG;
	}

	public void setCLAIM_FRZ_FLAG(String claim_frz_flag) {
		CLAIM_FRZ_FLAG = claim_frz_flag;
	}

	public String getCLAIM_DS_CODE() {
		return CLAIM_DS_CODE;
	}

	public void setCLAIM_DS_CODE(String claim_ds_code) {
		CLAIM_DS_CODE = claim_ds_code;
	}

	public Double getCLAIM_POAD_SERIAL_NO() {
		return CLAIM_POAD_SERIAL_NO;
	}

	public void setCLAIM_POAD_SERIAL_NO(Double claim_poad_serial_no) {
		CLAIM_POAD_SERIAL_NO = claim_poad_serial_no;
	}

	public String getCLAIM_CURR_CODE() {
		return CLAIM_CURR_CODE;
	}

	public void setCLAIM_CURR_CODE(String claim_curr_code) {
		CLAIM_CURR_CODE = claim_curr_code;
	}

	public Double getCLAIM_EXCH_RATE() {
		return CLAIM_EXCH_RATE;
	}

	public void setCLAIM_EXCH_RATE(Double claim_exch_rate) {
		CLAIM_EXCH_RATE = claim_exch_rate;
	}

	public String getCLAIM_CR_UID() {
		return CLAIM_CR_UID;
	}

	public void setCLAIM_CR_UID(String claim_cr_uid) {
		CLAIM_CR_UID = claim_cr_uid;
	}

	public Date getCLAIM_CR_DT() {
		return CLAIM_CR_DT;
	}

	public void setCLAIM_CR_DT(Date claim_cr_dt) {
		CLAIM_CR_DT = claim_cr_dt;
	}

	public String getCLAIM_UPD_UID() {
		return CLAIM_UPD_UID;
	}

	public void setCLAIM_UPD_UID(String claim_upd_uid) {
		CLAIM_UPD_UID = claim_upd_uid;
	}

	public Date getCLAIM_UPD_DT() {
		return CLAIM_UPD_DT;
	}

	public void setCLAIM_UPD_DT(Date claim_upd_dt) {
		CLAIM_UPD_DT = claim_upd_dt;
	}

	public String getCLAIM_CUST_CODE() {
		return CLAIM_CUST_CODE;
	}

	public void setCLAIM_CUST_CODE(String claim_cust_code) {
		CLAIM_CUST_CODE = claim_cust_code;
	}

	public String getUI_M_POL_PROD_CODE() {
		return UI_M_POL_PROD_CODE;
	}

	public void setUI_M_POL_PROD_CODE(String ui_m_pol_prod_code) {
		UI_M_POL_PROD_CODE = ui_m_pol_prod_code;
	}

	public String getUI_M_POL_SA_CURR_CODE() {
		return UI_M_POL_SA_CURR_CODE;
	}

	public void setUI_M_POL_SA_CURR_CODE(String ui_m_pol_sa_curr_code) {
		UI_M_POL_SA_CURR_CODE = ui_m_pol_sa_curr_code;
	}

	public Date getCLAIM_LOSS_DT() {
		return CLAIM_LOSS_DT;
	}

	public void setCLAIM_LOSS_DT(Date claim_loss_dt) {
		CLAIM_LOSS_DT = claim_loss_dt;
	}

	public String getCLAIM_PAY_TO() {
		return CLAIM_PAY_TO;
	}

	public void setCLAIM_PAY_TO(String claim_pay_to) {
		CLAIM_PAY_TO = claim_pay_to;
	}

	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}

	public String getUI_M_BUY_SELL() {
		return UI_M_BUY_SELL;
	}

	public void setUI_M_BUY_SELL(String ui_m_buy_sell) {
		UI_M_BUY_SELL = ui_m_buy_sell;
	}

	public String getUI_M_PT_IL_CLAIM_PAID_CF() {
		return UI_M_PT_IL_CLAIM_PAID_CF;
	}

	public void setUI_M_PT_IL_CLAIM_PAID_CF(String ui_m_pt_il_claim_paid_cf) {
		UI_M_PT_IL_CLAIM_PAID_CF = ui_m_pt_il_claim_paid_cf;
	}

	public String getUI_M_PT_IL_CLAIM_BENEFICIARY_CF() {
		return UI_M_PT_IL_CLAIM_BENEFICIARY_CF;
	}

	public void setUI_M_PT_IL_CLAIM_BENEFICIARY_CF(
			String ui_m_pt_il_claim_beneficiary_cf) {
		UI_M_PT_IL_CLAIM_BENEFICIARY_CF = ui_m_pt_il_claim_beneficiary_cf;
	}


	public String getUI_M_PS_VALUE() {
		return UI_M_PS_VALUE;
	}

	public void setUI_M_PS_VALUE(String ui_m_ps_value) {
		UI_M_PS_VALUE = ui_m_ps_value;
	}

	public Double getUI_M_IL_BEN_VALUE() {
		return UI_M_IL_BEN_VALUE;
	}

	public void setUI_M_IL_BEN_VALUE(Double ui_m_il_ben_value) {
		UI_M_IL_BEN_VALUE = ui_m_il_ben_value;
	}

	public String getUI_M_CALC_METHOD() {
		return UI_M_CALC_METHOD;
	}

	public void setUI_M_CALC_METHOD(String ui_m_calc_method) {
		UI_M_CALC_METHOD = ui_m_calc_method;
	}

	public String getCLAIM_CLOSE_FLAG() {
		return CLAIM_CLOSE_FLAG;
	}

	public void setCLAIM_CLOSE_FLAG(String claim_close_flag) {
		CLAIM_CLOSE_FLAG = claim_close_flag;
	}

	public String getCLAIM_STATUS() {
		return CLAIM_STATUS;
	}

	public void setCLAIM_STATUS(String claim_status) {
		CLAIM_STATUS = claim_status;
	}

	public String getCLAIM_ADDL_STATUS() {
		return CLAIM_ADDL_STATUS;
	}

	public void setCLAIM_ADDL_STATUS(String claim_addl_status) {
		CLAIM_ADDL_STATUS = claim_addl_status;
	}
}
