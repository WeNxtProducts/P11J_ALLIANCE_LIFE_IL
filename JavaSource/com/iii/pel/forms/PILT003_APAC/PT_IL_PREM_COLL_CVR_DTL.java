package com.iii.pel.forms.PILT003_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_IL_PREM_COLL_CVR_DTL")
public class PT_IL_PREM_COLL_CVR_DTL extends BaseValueBean {

	@Column(name="PCCD_POL_SYS_ID")
	private Long PCCD_POL_SYS_ID;

	@Column(name="PCCD_PC_SYS_ID")
	private Long PCCD_PC_SYS_ID;

	@Column(name="PCCD_COVER_CODE")
	private String PCCD_COVER_CODE;

	@Column(name="PCCD_FC_RISK_PREM_AMT")
	private Double PCCD_FC_RISK_PREM_AMT;

	@Column(name="PCCD_LC_RISK_PREM_AMT")
	private Double PCCD_LC_RISK_PREM_AMT;

	@Column(name="PCCD_FC_INV_PREM_AMT")
	private Double PCCD_FC_INV_PREM_AMT;

	@Column(name="PCCD_LC_INV_PREM_AMT")
	private Double PCCD_LC_INV_PREM_AMT;

	@Column(name="PCCD_FC_RISK_LOAD_AMT")
	private Double PCCD_FC_RISK_LOAD_AMT;

	@Column(name="PCCD_LC_RISK_LOAD_AMT")
	private Double PCCD_LC_RISK_LOAD_AMT;

	@Column(name="PCCD_FC_INV_LOAD_AMT")
	private Double PCCD_FC_INV_LOAD_AMT;

	@Column(name="PCCD_LC_INV_LOAD_AMT")
	private Double PCCD_LC_INV_LOAD_AMT;

	@Column(name="PCCD_FC_RISK_DISC_AMT")
	private Double PCCD_FC_RISK_DISC_AMT;

	@Column(name="PCCD_LC_RISK_DISC_AMT")
	private Double PCCD_LC_RISK_DISC_AMT;

	@Column(name="PCCD_FC_INV_DISC_AMT")
	private Double PCCD_FC_INV_DISC_AMT;

	@Column(name="PCCD_LC_INV_DISC_AMT")
	private Double PCCD_LC_INV_DISC_AMT;

	@Column(name="PCCD_CR_DT")
	private Date PCCD_CR_DT;

	@Column(name="PCCD_CR_UID")
	private String PCCD_CR_UID;

	@Column(name="PCCD_PROD_CODE")
	private String PCCD_PROD_CODE;

	private Double UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK;
	private Double UI_M_PCCD_TOTAL_FC_CVR_PREM_INV;
	private Double UI_M_PCCD_TOTAL_LC_CR_PREM_RISK;
	private Double UI_M_PCCD_TOTAL_LC_CVR_PREM_INV;
	private String UI_M_PCCD_COVER_DESC;
	public void setPCCD_LC_RISK_PREM_AMT(Double PCCD_LC_RISK_PREM_AMT) {
		this.PCCD_LC_RISK_PREM_AMT = PCCD_LC_RISK_PREM_AMT;
	}
	public Double getPCCD_LC_RISK_PREM_AMT() {
		 return PCCD_LC_RISK_PREM_AMT;
	}
	public void setPCCD_CR_UID(String PCCD_CR_UID) {
		this.PCCD_CR_UID = PCCD_CR_UID;
	}
	public String getPCCD_CR_UID() {
		 return PCCD_CR_UID;
	}
	public void setPCCD_FC_INV_PREM_AMT(Double PCCD_FC_INV_PREM_AMT) {
		this.PCCD_FC_INV_PREM_AMT = PCCD_FC_INV_PREM_AMT;
	}
	public Double getPCCD_FC_INV_PREM_AMT() {
		 return PCCD_FC_INV_PREM_AMT;
	}
	public void setPCCD_FC_RISK_LOAD_AMT(Double PCCD_FC_RISK_LOAD_AMT) {
		this.PCCD_FC_RISK_LOAD_AMT = PCCD_FC_RISK_LOAD_AMT;
	}
	public Double getPCCD_FC_RISK_LOAD_AMT() {
		 return PCCD_FC_RISK_LOAD_AMT;
	}
	public void setPCCD_FC_RISK_DISC_AMT(Double PCCD_FC_RISK_DISC_AMT) {
		this.PCCD_FC_RISK_DISC_AMT = PCCD_FC_RISK_DISC_AMT;
	}
	public Double getPCCD_FC_RISK_DISC_AMT() {
		 return PCCD_FC_RISK_DISC_AMT;
	}
	public void setUI_M_PCCD_COVER_DESC(String UI_M_PCCD_COVER_DESC) {
		this.UI_M_PCCD_COVER_DESC = UI_M_PCCD_COVER_DESC;
	}
	public String getUI_M_PCCD_COVER_DESC() {
		 return UI_M_PCCD_COVER_DESC;
	}
	public void setUI_M_PCCD_TOTAL_FC_CVR_PREM_INV(Double UI_M_PCCD_TOTAL_FC_CVR_PREM_INV) {
		this.UI_M_PCCD_TOTAL_FC_CVR_PREM_INV = UI_M_PCCD_TOTAL_FC_CVR_PREM_INV;
	}
	public Double getUI_M_PCCD_TOTAL_FC_CVR_PREM_INV() {
		 return UI_M_PCCD_TOTAL_FC_CVR_PREM_INV;
	}
	public void setPCCD_LC_INV_LOAD_AMT(Double PCCD_LC_INV_LOAD_AMT) {
		this.PCCD_LC_INV_LOAD_AMT = PCCD_LC_INV_LOAD_AMT;
	}
	public Double getPCCD_LC_INV_LOAD_AMT() {
		 return PCCD_LC_INV_LOAD_AMT;
	}
	public void setUI_M_PCCD_TOTAL_LC_CVR_PREM_INV(Double UI_M_PCCD_TOTAL_LC_CVR_PREM_INV) {
		this.UI_M_PCCD_TOTAL_LC_CVR_PREM_INV = UI_M_PCCD_TOTAL_LC_CVR_PREM_INV;
	}
	public Double getUI_M_PCCD_TOTAL_LC_CVR_PREM_INV() {
		 return UI_M_PCCD_TOTAL_LC_CVR_PREM_INV;
	}
	public void setPCCD_LC_INV_DISC_AMT(Double PCCD_LC_INV_DISC_AMT) {
		this.PCCD_LC_INV_DISC_AMT = PCCD_LC_INV_DISC_AMT;
	}
	public Double getPCCD_LC_INV_DISC_AMT() {
		 return PCCD_LC_INV_DISC_AMT;
	}
	public void setPCCD_LC_RISK_LOAD_AMT(Double PCCD_LC_RISK_LOAD_AMT) {
		this.PCCD_LC_RISK_LOAD_AMT = PCCD_LC_RISK_LOAD_AMT;
	}
	public Double getPCCD_LC_RISK_LOAD_AMT() {
		 return PCCD_LC_RISK_LOAD_AMT;
	}
	public void setPCCD_LC_RISK_DISC_AMT(Double PCCD_LC_RISK_DISC_AMT) {
		this.PCCD_LC_RISK_DISC_AMT = PCCD_LC_RISK_DISC_AMT;
	}
	public Double getPCCD_LC_RISK_DISC_AMT() {
		 return PCCD_LC_RISK_DISC_AMT;
	}
	public void setPCCD_FC_RISK_PREM_AMT(Double PCCD_FC_RISK_PREM_AMT) {
		this.PCCD_FC_RISK_PREM_AMT = PCCD_FC_RISK_PREM_AMT;
	}
	public Double getPCCD_FC_RISK_PREM_AMT() {
		 return PCCD_FC_RISK_PREM_AMT;
	}
	public void setPCCD_FC_INV_LOAD_AMT(Double PCCD_FC_INV_LOAD_AMT) {
		this.PCCD_FC_INV_LOAD_AMT = PCCD_FC_INV_LOAD_AMT;
	}
	public Double getPCCD_FC_INV_LOAD_AMT() {
		 return PCCD_FC_INV_LOAD_AMT;
	}
	public void setPCCD_PC_SYS_ID(Long PCCD_PC_SYS_ID) {
		this.PCCD_PC_SYS_ID = PCCD_PC_SYS_ID;
	}
	public Long getPCCD_PC_SYS_ID() {
		 return PCCD_PC_SYS_ID;
	}
	public void setPCCD_CR_DT(Date PCCD_CR_DT) {
		this.PCCD_CR_DT = PCCD_CR_DT;
	}
	public Date getPCCD_CR_DT() {
		 return PCCD_CR_DT;
	}
	public void setPCCD_PROD_CODE(String PCCD_PROD_CODE) {
		this.PCCD_PROD_CODE = PCCD_PROD_CODE;
	}
	public String getPCCD_PROD_CODE() {
		 return PCCD_PROD_CODE;
	}
	public void setPCCD_FC_INV_DISC_AMT(Double PCCD_FC_INV_DISC_AMT) {
		this.PCCD_FC_INV_DISC_AMT = PCCD_FC_INV_DISC_AMT;
	}
	public Double getPCCD_FC_INV_DISC_AMT() {
		 return PCCD_FC_INV_DISC_AMT;
	}
	public void setPCCD_COVER_CODE(String PCCD_COVER_CODE) {
		this.PCCD_COVER_CODE = PCCD_COVER_CODE;
	}
	public String getPCCD_COVER_CODE() {
		 return PCCD_COVER_CODE;
	}
	public void setPCCD_LC_INV_PREM_AMT(Double PCCD_LC_INV_PREM_AMT) {
		this.PCCD_LC_INV_PREM_AMT = PCCD_LC_INV_PREM_AMT;
	}
	public Double getPCCD_LC_INV_PREM_AMT() {
		 return PCCD_LC_INV_PREM_AMT;
	}
	public void setUI_M_PCCD_TOTAL_FC_CVR_PREM_RISK(Double UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK) {
		this.UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK = UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK;
	}
	public Double getUI_M_PCCD_TOTAL_FC_CVR_PREM_RISK() {
		 return UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK;
	}
	public void setUI_M_PCCD_TOTAL_LC_CR_PREM_RISK(Double UI_M_PCCD_TOTAL_LC_CR_PREM_RISK) {
		this.UI_M_PCCD_TOTAL_LC_CR_PREM_RISK = UI_M_PCCD_TOTAL_LC_CR_PREM_RISK;
	}
	public Double getUI_M_PCCD_TOTAL_LC_CR_PREM_RISK() {
		 return UI_M_PCCD_TOTAL_LC_CR_PREM_RISK;
	}
	public void setPCCD_POL_SYS_ID(Long PCCD_POL_SYS_ID) {
		this.PCCD_POL_SYS_ID = PCCD_POL_SYS_ID;
	}
	public Long getPCCD_POL_SYS_ID() {
		 return PCCD_POL_SYS_ID;
	}

}