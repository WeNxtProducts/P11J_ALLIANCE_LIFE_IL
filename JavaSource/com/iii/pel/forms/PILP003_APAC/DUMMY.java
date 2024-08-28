package com.iii.pel.forms.PILP003_APAC;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {

	private String UI_M_POL_NO;
	private Double UI_M_POL_SYS_ID;
	
	private String CALLING_FORM;
	
	private String UI_M_BASE_CURR_CODE;
	
	private String UI_M_POL_DIVN_CODE;
	
	private String UI_M_POL_CASH_YN;

	private Date UI_M_APPRV_DATE;
	
	private Date UI_M_TRAN_DATE;
	

	private String UI_M_ACNT_CUST_CODE;

	@Column(name="UI_M_PREM_GEN_YN")
	private String UI_M_PREM_GEN_YN;

	@Column(name="UI_M_BROK_GEN_YN")
	private String UI_M_BROK_GEN_YN;

	private String UI_M_POL_CUST_DESC;
	
	private List<SelectItem> PREM_GEN_YN_LIST;



	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public Date getUI_M_APPRV_DATE() {
		 return UI_M_APPRV_DATE;
	}

	public void setUI_M_APPRV_DATE(Date UI_M_APPRV_DATE) {
		this.UI_M_APPRV_DATE = UI_M_APPRV_DATE;
	}

	public String getUI_M_ACNT_CUST_CODE() {
		return UI_M_ACNT_CUST_CODE;
	}

	public void setUI_M_ACNT_CUST_CODE(String UI_M_ACNT_CUST_CODE) {
		this.UI_M_ACNT_CUST_CODE = UI_M_ACNT_CUST_CODE;
	}

	public String getUI_M_PREM_GEN_YN() {
		return UI_M_PREM_GEN_YN;
	}

	public void setUI_M_PREM_GEN_YN(String UI_M_PREM_GEN_YN) {
		this.UI_M_PREM_GEN_YN = UI_M_PREM_GEN_YN;
	}

	public String getUI_M_BROK_GEN_YN() {
		return UI_M_BROK_GEN_YN;
	}

	public void setUI_M_BROK_GEN_YN(String UI_M_BROK_GEN_YN) {
		this.UI_M_BROK_GEN_YN = UI_M_BROK_GEN_YN;
	}

	public String getUI_M_POL_CUST_DESC() {
		return UI_M_POL_CUST_DESC;
	}

	public void setUI_M_POL_CUST_DESC(String UI_M_POL_CUST_DESC) {
		this.UI_M_POL_CUST_DESC = UI_M_POL_CUST_DESC;
	}

	public List<SelectItem> getPREM_GEN_YN_LIST() {
		return PREM_GEN_YN_LIST;
	}

	public void setPREM_GEN_YN_LIST(List<SelectItem> prem_gen_yn_list) {
		PREM_GEN_YN_LIST = prem_gen_yn_list;
	}

	public Date getUI_M_TRAN_DATE() {
		return UI_M_TRAN_DATE;
	}

	public void setUI_M_TRAN_DATE(Date ui_m_tran_date) {
		UI_M_TRAN_DATE = ui_m_tran_date;
	}


	public double getUI_M_POL_SYS_ID() {
		return UI_M_POL_SYS_ID;
	}

	public void setUI_M_POL_SYS_ID(double ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}

	public String getCALLING_FORM() {
		return CALLING_FORM;
	}

	public void setCALLING_FORM(String calling_form) {
		CALLING_FORM = calling_form;
	}

	public String getUI_M_POL_CASH_YN() {
		return UI_M_POL_CASH_YN;
	}

	public void setUI_M_POL_CASH_YN(String ui_m_pol_cash_yn) {
		UI_M_POL_CASH_YN = ui_m_pol_cash_yn;
	}

	public String getUI_M_BASE_CURR_CODE() {
		return UI_M_BASE_CURR_CODE;
	}

	public void setUI_M_BASE_CURR_CODE(String ui_m_base_curr_code) {
		UI_M_BASE_CURR_CODE = ui_m_base_curr_code;
	}

	public void setUI_M_POL_SYS_ID(Double ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}

	public String getUI_M_POL_DIVN_CODE() {
		return UI_M_POL_DIVN_CODE;
	}

	public void setUI_M_POL_DIVN_CODE(String ui_m_pol_divn_code) {
		UI_M_POL_DIVN_CODE = ui_m_pol_divn_code;
	}

	
}
