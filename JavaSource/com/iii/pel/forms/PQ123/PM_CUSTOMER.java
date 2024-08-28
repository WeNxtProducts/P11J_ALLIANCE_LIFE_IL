package com.iii.pel.forms.PQ123;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_CUSTOMER")
public class PM_CUSTOMER extends BaseValueBean {

	@Column(name="CUST_CLASS")
	private String CUST_CLASS;

	@Column(name="CUST_CODE")
	private String CUST_CODE;
	
	@Column(name="CUST_NAME")
	private String CUST_NAME;

	@Column(name="CUST_ADDR1")
	private String CUST_ADDR1;

	@Column(name="CUST_PHONE")
	private Double CUST_PHONE;

	@Column(name="CUST_ADDR2")
	private String CUST_ADDR2;

	@Column(name="CUST_FAX")
	private Double CUST_FAX;

	@Column(name="CUST_ADDR3")
	private String CUST_ADDR3;

	private Double TOTAL_LC_SI;

	private Double TOTAL_CLAIM_EST;

	private Double TOTAL_LC_PREM;

	private Double TOTAL_CLAIM_PAID;

	private String LOSS_RATIO;



	public String getCUST_CLASS() {
		return CUST_CLASS;
	}

	public void setCUST_CLASS(String CUST_CLASS) {
		this.CUST_CLASS = CUST_CLASS;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String CUST_NAME) {
		this.CUST_NAME = CUST_NAME;
	}

	public String getCUST_ADDR1() {
		return CUST_ADDR1;
	}

	public void setCUST_ADDR1(String CUST_ADDR1) {
		this.CUST_ADDR1 = CUST_ADDR1;
	}

	public Double getCUST_PHONE() {
		return CUST_PHONE;
	}

	public void setCUST_PHONE(Double CUST_PHONE) {
		this.CUST_PHONE = CUST_PHONE;
	}

	public String getCUST_ADDR2() {
		return CUST_ADDR2;
	}

	public void setCUST_ADDR2(String CUST_ADDR2) {
		this.CUST_ADDR2 = CUST_ADDR2;
	}

	public Double getCUST_FAX() {
		return CUST_FAX;
	}

	public void setCUST_FAX(Double CUST_FAX) {
		this.CUST_FAX = CUST_FAX;
	}

	public String getCUST_ADDR3() {
		return CUST_ADDR3;
	}

	public void setCUST_ADDR3(String CUST_ADDR3) {
		this.CUST_ADDR3 = CUST_ADDR3;
	}

	public Double getTOTAL_LC_SI() {
		return TOTAL_LC_SI;
	}

	public void setTOTAL_LC_SI(Double TOTAL_LC_SI) {
		this.TOTAL_LC_SI = TOTAL_LC_SI;
	}

	public Double getTOTAL_CLAIM_EST() {
		return TOTAL_CLAIM_EST;
	}

	public void setTOTAL_CLAIM_EST(Double TOTAL_CLAIM_EST) {
		this.TOTAL_CLAIM_EST = TOTAL_CLAIM_EST;
	}

	public Double getTOTAL_LC_PREM() {
		return TOTAL_LC_PREM;
	}

	public void setTOTAL_LC_PREM(Double TOTAL_LC_PREM) {
		this.TOTAL_LC_PREM = TOTAL_LC_PREM;
	}

	public Double getTOTAL_CLAIM_PAID() {
		return TOTAL_CLAIM_PAID;
	}

	public void setTOTAL_CLAIM_PAID(Double TOTAL_CLAIM_PAID) {
		this.TOTAL_CLAIM_PAID = TOTAL_CLAIM_PAID;
	}

	public String getLOSS_RATIO() {
		return LOSS_RATIO;
	}

	public void setLOSS_RATIO(String LOSS_RATIO) {
		this.LOSS_RATIO = LOSS_RATIO;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}
}
