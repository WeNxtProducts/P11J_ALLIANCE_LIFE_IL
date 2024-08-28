package com.iii.pel.forms.PILM073_APAC;

import org.omg.PortableInterceptor.INACTIVE;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "FM_BANK_IN_SLIP_SETUP")
public class FM_BANK_IN_SLIP_SETUP extends BaseValueBean {

	@Column(name = "BISS_BANK_ACNT_CODE")
	private String BISS_BANK_ACNT_CODE;

	@Column(name = "BISS_PYMT_MODE")
	private String BISS_PYMT_MODE;

	@Column(name = "BISS_REF_NO_YN")
	private String BISS_REF_NO_YN;

	@Column(name = "BISS_AUTO_GEN_YN")
	private String BISS_AUTO_GEN_YN;

	@Column(name = "BISS_BY_RECEIPT")
	private String BISS_BY_RECEIPT;

	@Column(name = "BISS_BY_PAY_MODE")
	private String BISS_BY_PAY_MODE;

	@Column(name = "BISS_FIN_YR")
	private Integer BISS_FIN_YR;

	@Column(name = "BISS_PREFIX")
	private String BISS_PREFIX;

	@Column(name = "BISS_SEQ_START_NO")
	private Long BISS_SEQ_START_NO;

	@Column(name = "BISS_SEQ_END_NO")
	private Long BISS_SEQ_END_NO;

	@Column(name = "BISS_SUFFIX")
	private String BISS_SUFFIX;

	@Column(name = "BISS_PAD_YN")
	private String BISS_PAD_YN;

	@Column(name = "BISS_NO_DIG_PADDED")
	private Integer BISS_NO_DIG_PADDED;

	@Column(name = "BISS_CURR_NO")
	private Integer BISS_CURR_NO;

	@Column(name = "BISS_MODULE_TYPE")
	private String BISS_MODULE_TYPE;

	private String UI_M_ACNT_DESC;

	public void setBISS_REF_NO_YN(String BISS_REF_NO_YN) {
		this.BISS_REF_NO_YN = BISS_REF_NO_YN;
	}

	public String getBISS_REF_NO_YN() {
		return BISS_REF_NO_YN;
	}

	public void setBISS_BY_RECEIPT(String BISS_BY_RECEIPT) {
		this.BISS_BY_RECEIPT = BISS_BY_RECEIPT;
	}

	public String getBISS_BY_RECEIPT() {
		return BISS_BY_RECEIPT;
	}

	public void setBISS_MODULE_TYPE(String BISS_MODULE_TYPE) {
		this.BISS_MODULE_TYPE = BISS_MODULE_TYPE;
	}

	public String getBISS_MODULE_TYPE() {
		return BISS_MODULE_TYPE;
	}

	public void setBISS_SUFFIX(String BISS_SUFFIX) {
		this.BISS_SUFFIX = BISS_SUFFIX;
	}

	public String getBISS_SUFFIX() {
		return BISS_SUFFIX;
	}

	public void setBISS_NO_DIG_PADDED(Integer BISS_NO_DIG_PADDED) {
		this.BISS_NO_DIG_PADDED = BISS_NO_DIG_PADDED;
	}

	public Integer getBISS_NO_DIG_PADDED() {
		return BISS_NO_DIG_PADDED;
	}

	public void setBISS_BY_PAY_MODE(String BISS_BY_PAY_MODE) {
		this.BISS_BY_PAY_MODE = BISS_BY_PAY_MODE;
	}

	public String getBISS_BY_PAY_MODE() {
		return BISS_BY_PAY_MODE;
	}

	public void setBISS_CURR_NO(Integer BISS_CURR_NO) {
		this.BISS_CURR_NO = BISS_CURR_NO;
	}

	public Integer getBISS_CURR_NO() {
		return BISS_CURR_NO;
	}

	public void setBISS_PREFIX(String BISS_PREFIX) {
		this.BISS_PREFIX = BISS_PREFIX;
	}

	public String getBISS_PREFIX() {
		return BISS_PREFIX;
	}

	public void setBISS_SEQ_END_NO(Long BISS_SEQ_END_NO) {
		this.BISS_SEQ_END_NO = BISS_SEQ_END_NO;
	}

	public Long getBISS_SEQ_END_NO() {
		return BISS_SEQ_END_NO;
	}

	public void setBISS_BANK_ACNT_CODE(String BISS_BANK_ACNT_CODE) {
		this.BISS_BANK_ACNT_CODE = BISS_BANK_ACNT_CODE;
	}

	public String getBISS_BANK_ACNT_CODE() {
		return BISS_BANK_ACNT_CODE;
	}

	public void setBISS_SEQ_START_NO(Long BISS_SEQ_START_NO) {
		this.BISS_SEQ_START_NO = BISS_SEQ_START_NO;
	}

	public Long getBISS_SEQ_START_NO() {
		return BISS_SEQ_START_NO;
	}

	public void setUI_M_ACNT_DESC(String UI_M_ACNT_DESC) {
		this.UI_M_ACNT_DESC = UI_M_ACNT_DESC;
	}

	public String getUI_M_ACNT_DESC() {
		return UI_M_ACNT_DESC;
	}

	public void setBISS_PYMT_MODE(String BISS_PYMT_MODE) {
		this.BISS_PYMT_MODE = BISS_PYMT_MODE;
	}

	public String getBISS_PYMT_MODE() {
		return BISS_PYMT_MODE;
	}

	public void setBISS_FIN_YR(Integer BISS_FIN_YR) {
		this.BISS_FIN_YR = BISS_FIN_YR;
	}

	public Integer getBISS_FIN_YR() {
		return BISS_FIN_YR;
	}

	public void setBISS_AUTO_GEN_YN(String BISS_AUTO_GEN_YN) {
		this.BISS_AUTO_GEN_YN = BISS_AUTO_GEN_YN;
	}

	public String getBISS_AUTO_GEN_YN() {
		return BISS_AUTO_GEN_YN;
	}

	public void setBISS_PAD_YN(String BISS_PAD_YN) {
		this.BISS_PAD_YN = BISS_PAD_YN;
	}

	public String getBISS_PAD_YN() {
		return BISS_PAD_YN;
	}

}