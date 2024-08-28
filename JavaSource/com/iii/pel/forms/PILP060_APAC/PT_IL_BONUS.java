package com.iii.pel.forms.PILP060_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_BONUS")
public class PT_IL_BONUS extends BaseValueBean {

//	private Double UI_M_BON_SR_NO;
//
//	@Column(name="BON_YEAR")
//	private Double BON_YEAR;
//
//	private String UI_M_BON_POL_NO;
//
//	@Column(name="BON_FC_BONUS_AMT")
//	private Double BON_FC_BONUS_AMT;
//
//	@Column(name="BON_LC_BONUS_AMT")
//	private Double BON_LC_BONUS_AMT;
//
//	@Column(name="BON_PAID_YN")
//	private String BON_PAID_YN;
//
//	@Column(name="BON_PAY_TO")
//	private String BON_PAY_TO;
	
	@Column(name="BON_SYS_ID")
	private Double  BON_SYS_ID;
	@Column(name="BON_POL_SYS_ID")
	private Double  BON_POL_SYS_ID;
	@Column(name="BON_REF_TYPE")
	private String  BON_REF_TYPE;
	@Column(name="BON_REF_SYS_ID")
	private Double  BON_REF_SYS_ID;
	@Column(name="BON_BONUS_CODE")
	private String  BON_BONUS_CODE;
	@Column(name="BON_FC_BONUS_AMT")
	private Double  BON_FC_BONUS_AMT;
	@Column(name="BON_LC_BONUS_AMT")
	private Double  BON_LC_BONUS_AMT;
	@Column(name="BON_CR_DT")
	private Date  BON_CR_DT;
	@Column(name="BON_CR_UID")
	private String  BON_CR_UID;
	@Column(name="BON_UPD_DT")
	private Date  BON_UPD_DT;
	@Column(name="BON_UPD_UID")
	private String  BON_UPD_UID;
	@Column(name="BON_PAID_YN")
	private String  BON_PAID_YN;
	@Column(name="BON_YEAR")
	private int  BON_YEAR;
	@Column(name="BON_POST_YN")
	private String  BON_POST_YN;
	@Column(name="BON_SR_NO")
	private int  BON_SR_NO;
	@Column(name="BON_TXN_CODE")
	private String  BON_TXN_CODE;
	@Column(name="BON_DOC_NO")
	private Double  BON_DOC_NO;
	@Column(name="BON_ACNT_YEAR")
	private Double  BON_ACNT_YEAR;
	@Column(name="BON_CN_YN")
	private String  BON_CN_YN;
	@Column(name="BON_PV_YN")
	private String  BON_PV_YN;
	@Column(name="BON_PAY_TO")
	private String  BON_PAY_TO;
	@Column(name="BON_PROD_CODE")
	private String  BON_PROD_CODE;
	
	private Double  UI_M_BON_SR_NO;
	
	private String  UI_M_BON_POL_NO;

	
	public Double getBON_SYS_ID() {
		return BON_SYS_ID;
	}

	public void setBON_SYS_ID(Double bon_sys_id) {
		BON_SYS_ID = bon_sys_id;
	}

	public Double getBON_POL_SYS_ID() {
		return BON_POL_SYS_ID;
	}

	public void setBON_POL_SYS_ID(Double bon_pol_sys_id) {
		BON_POL_SYS_ID = bon_pol_sys_id;
	}

	public String getBON_REF_TYPE() {
		return BON_REF_TYPE;
	}

	public void setBON_REF_TYPE(String bon_ref_type) {
		BON_REF_TYPE = bon_ref_type;
	}

	public Double getBON_REF_SYS_ID() {
		return BON_REF_SYS_ID;
	}

	public void setBON_REF_SYS_ID(Double bon_ref_sys_id) {
		BON_REF_SYS_ID = bon_ref_sys_id;
	}

	public String getBON_BONUS_CODE() {
		return BON_BONUS_CODE;
	}

	public void setBON_BONUS_CODE(String bon_bonus_code) {
		BON_BONUS_CODE = bon_bonus_code;
	}

	public Date getBON_CR_DT() {
		return BON_CR_DT;
	}

	public void setBON_CR_DT(Date bon_cr_dt) {
		BON_CR_DT = bon_cr_dt;
	}

	public String getBON_CR_UID() {
		return BON_CR_UID;
	}

	public void setBON_CR_UID(String bon_cr_uid) {
		BON_CR_UID = bon_cr_uid;
	}

	public Date getBON_UPD_DT() {
		return BON_UPD_DT;
	}

	public void setBON_UPD_DT(Date bon_upd_dt) {
		BON_UPD_DT = bon_upd_dt;
	}

	public String getBON_UPD_UID() {
		return BON_UPD_UID;
	}

	public void setBON_UPD_UID(String bon_upd_uid) {
		BON_UPD_UID = bon_upd_uid;
	}

	public String getBON_POST_YN() {
		return BON_POST_YN;
	}

	public void setBON_POST_YN(String bon_post_yn) {
		BON_POST_YN = bon_post_yn;
	}

	public int getBON_SR_NO() {
		return BON_SR_NO;
	}

	public void setBON_SR_NO(int bon_sr_no) {
		BON_SR_NO = bon_sr_no;
	}

	public String getBON_TXN_CODE() {
		return BON_TXN_CODE;
	}

	public void setBON_TXN_CODE(String bon_txn_code) {
		BON_TXN_CODE = bon_txn_code;
	}

	public Double getBON_DOC_NO() {
		return BON_DOC_NO;
	}

	public void setBON_DOC_NO(Double bon_doc_no) {
		BON_DOC_NO = bon_doc_no;
	}

	public Double getBON_ACNT_YEAR() {
		return BON_ACNT_YEAR;
	}

	public void setBON_ACNT_YEAR(Double bon_acnt_year) {
		BON_ACNT_YEAR = bon_acnt_year;
	}

	public String getBON_CN_YN() {
		return BON_CN_YN;
	}

	public void setBON_CN_YN(String bon_cn_yn) {
		BON_CN_YN = bon_cn_yn;
	}

	public String getBON_PV_YN() {
		return BON_PV_YN;
	}

	public void setBON_PV_YN(String bon_pv_yn) {
		BON_PV_YN = bon_pv_yn;
	}

	public String getBON_PROD_CODE() {
		return BON_PROD_CODE;
	}

	public void setBON_PROD_CODE(String bon_prod_code) {
		BON_PROD_CODE = bon_prod_code;
	}

	public Double getUI_M_BON_SR_NO() {
		return UI_M_BON_SR_NO;
	}

	public void setUI_M_BON_SR_NO(Double UI_M_BON_SR_NO) {
		this.UI_M_BON_SR_NO = UI_M_BON_SR_NO;
	}

	public int getBON_YEAR() {
		return BON_YEAR;
	}

	public void setBON_YEAR(int BON_YEAR) {
		this.BON_YEAR = BON_YEAR;
	}

	public String getUI_M_BON_POL_NO() {
		return UI_M_BON_POL_NO;
	}

	public void setUI_M_BON_POL_NO(String UI_M_BON_POL_NO) {
		this.UI_M_BON_POL_NO = UI_M_BON_POL_NO;
	}

	public Double getBON_FC_BONUS_AMT() {
		return BON_FC_BONUS_AMT;
	}

	public void setBON_FC_BONUS_AMT(Double BON_FC_BONUS_AMT) {
		this.BON_FC_BONUS_AMT = BON_FC_BONUS_AMT;
	}

	public Double getBON_LC_BONUS_AMT() {
		return BON_LC_BONUS_AMT;
	}

	public void setBON_LC_BONUS_AMT(Double BON_LC_BONUS_AMT) {
		this.BON_LC_BONUS_AMT = BON_LC_BONUS_AMT;
	}

	public String getBON_PAID_YN() {
		return BON_PAID_YN;
	}

	public void setBON_PAID_YN(String BON_PAID_YN) {
		this.BON_PAID_YN = BON_PAID_YN;
	}

	public String getBON_PAY_TO() {
		return BON_PAY_TO;
	}

	public void setBON_PAY_TO(String BON_PAY_TO) {
		this.BON_PAY_TO = BON_PAY_TO;
	}
}
