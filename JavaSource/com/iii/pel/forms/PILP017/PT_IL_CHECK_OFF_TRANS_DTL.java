package com.iii.pel.forms.PILP017;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PT_IL_CHECK_OFF_TRANS_DTL")
public class PT_IL_CHECK_OFF_TRANS_DTL extends BaseValueBean{
	
	@Column(name="COTD_EMPLOYER_CODE")
	private String COTD_EMPLOYER_CODE ;

	@Column(name="COTD_POLICY_NO")
	private String COTD_POLICY_NO;

	@Column(name="COTD_MSG_TYPE")
	private String COTD_MSG_TYPE;

	@Column(name="COTD_DUE_DATE")
	private Date COTD_DUE_DATE;
	
	
	@Column(name="COTD_PAID_DATE")
	private Date COTD_PAID_DATE;

	@Column(name="COTD_ERROR_CODE")
	private Integer COTD_ERROR_CODE;

	@Column(name="COTD_PAID_FC_AMT")
	private Double COTD_PAID_FC_AMT;

	@Column(name="COTD_PAID_LC_AMT")
	private Double COTD_PAID_LC_AMT;
	
	@Column(name="COTD_FIELD2")
	private String COTD_FIELD2;
	
	private String UI_M_ERR_CODE_DESC;

	public String getUI_M_ERR_CODE_DESC() {
		return UI_M_ERR_CODE_DESC;
	}

	public void setUI_M_ERR_CODE_DESC(String ui_m_err_code_desc) {
		UI_M_ERR_CODE_DESC = ui_m_err_code_desc;
	}

	public String getCOTD_EMPLOYER_CODE() {
		return COTD_EMPLOYER_CODE;
	}

	public void setCOTD_EMPLOYER_CODE(String cotd_employer_code) {
		COTD_EMPLOYER_CODE = cotd_employer_code;
	}

	public String getCOTD_POLICY_NO() {
		return COTD_POLICY_NO;
	}

	public void setCOTD_POLICY_NO(String cotd_policy_no) {
		COTD_POLICY_NO = cotd_policy_no;
	}

	public String getCOTD_MSG_TYPE() {
		return COTD_MSG_TYPE;
	}

	public void setCOTD_MSG_TYPE(String cotd_msg_type) {
		COTD_MSG_TYPE = cotd_msg_type;
	}

	public Date getCOTD_DUE_DATE() {
		return COTD_DUE_DATE;
	}

	public void setCOTD_DUE_DATE(Date cotd_due_date) {
		COTD_DUE_DATE = cotd_due_date;
	}

	public Date getCOTD_PAID_DATE() {
		return COTD_PAID_DATE;
	}

	public void setCOTD_PAID_DATE(Date cotd_paid_date) {
		COTD_PAID_DATE = cotd_paid_date;
	}

	public Integer getCOTD_ERROR_CODE() {
		return COTD_ERROR_CODE;
	}

	public void setCOTD_ERROR_CODE(Integer cotd_error_code) {
		COTD_ERROR_CODE = cotd_error_code;
	}

	public Double getCOTD_PAID_FC_AMT() {
		return COTD_PAID_FC_AMT;
	}

	public void setCOTD_PAID_FC_AMT(Double cotd_paid_fc_amt) {
		COTD_PAID_FC_AMT = cotd_paid_fc_amt;
	}

	public Double getCOTD_PAID_LC_AMT() {
		return COTD_PAID_LC_AMT;
	}

	public void setCOTD_PAID_LC_AMT(Double cotd_paid_lc_amt) {
		COTD_PAID_LC_AMT = cotd_paid_lc_amt;
	}

	public String getCOTD_FIELD2() {
		return COTD_FIELD2;
	}

	public void setCOTD_FIELD2(String cotd_field2) {
		COTD_FIELD2 = cotd_field2;
	}
	
	

}