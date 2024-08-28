package com.iii.pel.forms.PILT003_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_IL_PREM_COLL_CHARGE")
public class PT_IL_PREM_COLL_CHARGE extends BaseValueBean {

	@Column(name="PCC_SYS_ID")
	private Long PCC_SYS_ID;

	@Column(name="PCC_PC_SYS_ID")
	private Long PCC_PC_SYS_ID;

	@Column(name="PCC_CHARGE_CODE")
	private String PCC_CHARGE_CODE;

	@Column(name="PCC_FC_CHARGE_AMT")
	private Double PCC_FC_CHARGE_AMT;

	@Column(name="PCC_LC_CHARGE_AMT")
	private Double PCC_LC_CHARGE_AMT;

	@Column(name="PCC_CUST_SHARE_PERC")
	private Double PCC_CUST_SHARE_PERC;

	@Column(name="PCC_APPLY_PERIOD")
	private String PCC_APPLY_PERIOD;

	@Column(name="PCC_CR_DT")
	private Date PCC_CR_DT;

	@Column(name="PCC_CR_UID")
	private String PCC_CR_UID;

	@Column(name="PCC_UPD_DT")
	private Date PCC_UPD_DT;

	@Column(name="PCC_UPD_UID")
	private String PCC_UPD_UID;

	@Column(name="PCC_FC_INS_CHARGE_AMT")
	private Double PCC_FC_INS_CHARGE_AMT;

	@Column(name="PCC_LC_INS_CHARGE_AMT")
	private Double PCC_LC_INS_CHARGE_AMT;

	@Column(name="PCC_DRCR_ACNT_YEAR")
	private Double PCC_DRCR_ACNT_YEAR;

	@Column(name="PCC_DRCR_TXN_CODE")
	private String PCC_DRCR_TXN_CODE;

	@Column(name="PCC_DRCR_DOC_NO")
	private Double PCC_DRCR_DOC_NO;

	@Column(name="PCC_DRCR_DOC_DT")
	private Date PCC_DRCR_DOC_DT;

	@Column(name="PCC_TYPE")
	private String PCC_TYPE;

	private String UI_M_CHARGE_DESC;
	public void setPCC_CR_DT(Date PCC_CR_DT) {
		this.PCC_CR_DT = PCC_CR_DT;
	}
	public Date getPCC_CR_DT() {
		 return PCC_CR_DT;
	}
	public void setPCC_DRCR_DOC_NO(Double PCC_DRCR_DOC_NO) {
		this.PCC_DRCR_DOC_NO = PCC_DRCR_DOC_NO;
	}
	public Double getPCC_DRCR_DOC_NO() {
		 return PCC_DRCR_DOC_NO;
	}
	public void setPCC_UPD_DT(Date PCC_UPD_DT) {
		this.PCC_UPD_DT = PCC_UPD_DT;
	}
	public Date getPCC_UPD_DT() {
		 return PCC_UPD_DT;
	}
	public void setPCC_UPD_UID(String PCC_UPD_UID) {
		this.PCC_UPD_UID = PCC_UPD_UID;
	}
	public String getPCC_UPD_UID() {
		 return PCC_UPD_UID;
	}
	public void setPCC_TYPE(String PCC_TYPE) {
		this.PCC_TYPE = PCC_TYPE;
	}
	public String getPCC_TYPE() {
		 return PCC_TYPE;
	}
	public void setPCC_DRCR_DOC_DT(Date PCC_DRCR_DOC_DT) {
		this.PCC_DRCR_DOC_DT = PCC_DRCR_DOC_DT;
	}
	public Date getPCC_DRCR_DOC_DT() {
		 return PCC_DRCR_DOC_DT;
	}
	public void setPCC_CHARGE_CODE(String PCC_CHARGE_CODE) {
		this.PCC_CHARGE_CODE = PCC_CHARGE_CODE;
	}
	public String getPCC_CHARGE_CODE() {
		 return PCC_CHARGE_CODE;
	}
	public void setPCC_CUST_SHARE_PERC(Double PCC_CUST_SHARE_PERC) {
		this.PCC_CUST_SHARE_PERC = PCC_CUST_SHARE_PERC;
	}
	public Double getPCC_CUST_SHARE_PERC() {
		 return PCC_CUST_SHARE_PERC;
	}
	public void setPCC_CR_UID(String PCC_CR_UID) {
		this.PCC_CR_UID = PCC_CR_UID;
	}
	public String getPCC_CR_UID() {
		 return PCC_CR_UID;
	}
	public void setPCC_FC_INS_CHARGE_AMT(Double PCC_FC_INS_CHARGE_AMT) {
		this.PCC_FC_INS_CHARGE_AMT = PCC_FC_INS_CHARGE_AMT;
	}
	public Double getPCC_FC_INS_CHARGE_AMT() {
		 return PCC_FC_INS_CHARGE_AMT;
	}
	public void setPCC_DRCR_TXN_CODE(String PCC_DRCR_TXN_CODE) {
		this.PCC_DRCR_TXN_CODE = PCC_DRCR_TXN_CODE;
	}
	public String getPCC_DRCR_TXN_CODE() {
		 return PCC_DRCR_TXN_CODE;
	}
	public void setPCC_APPLY_PERIOD(String PCC_APPLY_PERIOD) {
		this.PCC_APPLY_PERIOD = PCC_APPLY_PERIOD;
	}
	public String getPCC_APPLY_PERIOD() {
		 return PCC_APPLY_PERIOD;
	}
	public void setPCC_SYS_ID(Long PCC_SYS_ID) {
		this.PCC_SYS_ID = PCC_SYS_ID;
	}
	public Long getPCC_SYS_ID() {
		 return PCC_SYS_ID;
	}
	public void setPCC_FC_CHARGE_AMT(Double PCC_FC_CHARGE_AMT) {
		this.PCC_FC_CHARGE_AMT = PCC_FC_CHARGE_AMT;
	}
	public Double getPCC_FC_CHARGE_AMT() {
		 return PCC_FC_CHARGE_AMT;
	}
	public void setPCC_DRCR_ACNT_YEAR(Double PCC_DRCR_ACNT_YEAR) {
		this.PCC_DRCR_ACNT_YEAR = PCC_DRCR_ACNT_YEAR;
	}
	public Double getPCC_DRCR_ACNT_YEAR() {
		 return PCC_DRCR_ACNT_YEAR;
	}
	public void setPCC_PC_SYS_ID(Long PCC_PC_SYS_ID) {
		this.PCC_PC_SYS_ID = PCC_PC_SYS_ID;
	}
	public Long getPCC_PC_SYS_ID() {
		 return PCC_PC_SYS_ID;
	}
	public void setPCC_LC_CHARGE_AMT(Double PCC_LC_CHARGE_AMT) {
		this.PCC_LC_CHARGE_AMT = PCC_LC_CHARGE_AMT;
	}
	public Double getPCC_LC_CHARGE_AMT() {
		 return PCC_LC_CHARGE_AMT;
	}
	public void setUI_M_CHARGE_DESC(String UI_M_CHARGE_DESC) {
		this.UI_M_CHARGE_DESC = UI_M_CHARGE_DESC;
	}
	public String getUI_M_CHARGE_DESC() {
		 return UI_M_CHARGE_DESC;
	}
	public void setPCC_LC_INS_CHARGE_AMT(Double PCC_LC_INS_CHARGE_AMT) {
		this.PCC_LC_INS_CHARGE_AMT = PCC_LC_INS_CHARGE_AMT;
	}
	public Double getPCC_LC_INS_CHARGE_AMT() {
		 return PCC_LC_INS_CHARGE_AMT;
	}

}