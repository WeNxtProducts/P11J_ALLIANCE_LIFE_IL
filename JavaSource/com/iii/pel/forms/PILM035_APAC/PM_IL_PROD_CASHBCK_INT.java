package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_CASHBCK_INT")
public class PM_IL_PROD_CASHBCK_INT extends BaseValueBean {

	@Column(name="CASHBCK_PROD_CODE")
	private String CASHBCK_PROD_CODE;

	@Column(name="CASHBCK_NO_FM_DAYS")
	private Integer CASHBCK_NO_FM_DAYS;

	@Column(name="CASHBCK_NO_TO_DAYS")
	private Integer CASHBCK_NO_TO_DAYS;

	@Column(name="CASHBCK_RATE")
	private Double CASHBCK_RATE;

	@Column(name="CASHBCK_RATE_PER")
	private Double CASHBCK_RATE_PER;

	@Column(name="CASHBCK_MIN_LC_AMT")
	private Double CASHBCK_MIN_LC_AMT;

	@Column(name="CASHBCK_MAX_LC_AMT")
	private Double CASHBCK_MAX_LC_AMT;

	@Column(name="CASHBCK_EFF_FM_DT")
	private Date CASHBCK_EFF_FM_DT;

	@Column(name="CASHBCK_EFF_TO_DT")
	private Date CASHBCK_EFF_TO_DT;

	@Column(name="CASHBCK_CR_UID")
	private String CASHBCK_CR_UID;

	@Column(name="CASHBCK_CR_DT")
	private Date CASHBCK_CR_DT;

	@Column(name="CASHBCK_UPD_UID")
	private String CASHBCK_UPD_UID;

	@Column(name="CASHBCK_UPD_DT")
	private Date CASHBCK_UPD_DT;

	@Column(name="CASHBCK_INT_TYPE")
	private String CASHBCK_INT_TYPE;

	public String getCASHBCK_PROD_CODE() {
		return CASHBCK_PROD_CODE;
	}

	public void setCASHBCK_PROD_CODE(String cASHBCK_PROD_CODE) {
		CASHBCK_PROD_CODE = cASHBCK_PROD_CODE;
	}

	public Integer getCASHBCK_NO_FM_DAYS() {
		return CASHBCK_NO_FM_DAYS;
	}

	public void setCASHBCK_NO_FM_DAYS(Integer cASHBCK_NO_FM_DAYS) {
		CASHBCK_NO_FM_DAYS = cASHBCK_NO_FM_DAYS;
	}

	public Integer getCASHBCK_NO_TO_DAYS() {
		return CASHBCK_NO_TO_DAYS;
	}

	public void setCASHBCK_NO_TO_DAYS(Integer cASHBCK_NO_TO_DAYS) {
		CASHBCK_NO_TO_DAYS = cASHBCK_NO_TO_DAYS;
	}

	public Double getCASHBCK_RATE() {
		return CASHBCK_RATE;
	}

	public void setCASHBCK_RATE(Double cASHBCK_RATE) {
		CASHBCK_RATE = cASHBCK_RATE;
	}

	public Double getCASHBCK_RATE_PER() {
		return CASHBCK_RATE_PER;
	}

	public void setCASHBCK_RATE_PER(Double cASHBCK_RATE_PER) {
		CASHBCK_RATE_PER = cASHBCK_RATE_PER;
	}

	public Double getCASHBCK_MIN_LC_AMT() {
		return CASHBCK_MIN_LC_AMT;
	}

	public void setCASHBCK_MIN_LC_AMT(Double cASHBCK_MIN_LC_AMT) {
		CASHBCK_MIN_LC_AMT = cASHBCK_MIN_LC_AMT;
	}

	public Double getCASHBCK_MAX_LC_AMT() {
		return CASHBCK_MAX_LC_AMT;
	}

	public void setCASHBCK_MAX_LC_AMT(Double cASHBCK_MAX_LC_AMT) {
		CASHBCK_MAX_LC_AMT = cASHBCK_MAX_LC_AMT;
	}

	public Date getCASHBCK_EFF_FM_DT() {
		return CASHBCK_EFF_FM_DT;
	}

	public void setCASHBCK_EFF_FM_DT(Date cASHBCK_EFF_FM_DT) {
		CASHBCK_EFF_FM_DT = cASHBCK_EFF_FM_DT;
	}

	public Date getCASHBCK_EFF_TO_DT() {
		return CASHBCK_EFF_TO_DT;
	}

	public void setCASHBCK_EFF_TO_DT(Date cASHBCK_EFF_TO_DT) {
		CASHBCK_EFF_TO_DT = cASHBCK_EFF_TO_DT;
	}

	public String getCASHBCK_CR_UID() {
		return CASHBCK_CR_UID;
	}

	public void setCASHBCK_CR_UID(String cASHBCK_CR_UID) {
		CASHBCK_CR_UID = cASHBCK_CR_UID;
	}

	public Date getCASHBCK_CR_DT() {
		return CASHBCK_CR_DT;
	}

	public void setCASHBCK_CR_DT(Date cASHBCK_CR_DT) {
		CASHBCK_CR_DT = cASHBCK_CR_DT;
	}

	public String getCASHBCK_UPD_UID() {
		return CASHBCK_UPD_UID;
	}

	public void setCASHBCK_UPD_UID(String cASHBCK_UPD_UID) {
		CASHBCK_UPD_UID = cASHBCK_UPD_UID;
	}

	public Date getCASHBCK_UPD_DT() {
		return CASHBCK_UPD_DT;
	}

	public void setCASHBCK_UPD_DT(Date cASHBCK_UPD_DT) {
		CASHBCK_UPD_DT = cASHBCK_UPD_DT;
	}

	public String getCASHBCK_INT_TYPE() {
		return CASHBCK_INT_TYPE;
	}

	public void setCASHBCK_INT_TYPE(String cASHBCK_INT_TYPE) {
		CASHBCK_INT_TYPE = cASHBCK_INT_TYPE;
	}
	


	
	
	
}
