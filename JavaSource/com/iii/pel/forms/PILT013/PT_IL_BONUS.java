package com.iii.pel.forms.PILT013;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_BONUS")
public class PT_IL_BONUS extends BaseValueBean {

	@Column(name = "BON_SYS_ID")
	private Long BON_SYS_ID;

	@Column(name = "BON_POL_SYS_ID")
	private Long BON_POL_SYS_ID;

	@Column(name = "BON_REF_TYPE")
	private String BON_REF_TYPE;

	@Column(name = "BON_REF_SYS_ID")
	private Long BON_REF_SYS_ID;

	@Column(name = "BON_BONUS_CODE")
	private String BON_BONUS_CODE;

	@Column(name = "BON_FC_BONUS_AMT")
	private Double BON_FC_BONUS_AMT;

	@Column(name = "BON_LC_BONUS_AMT")
	private Double BON_LC_BONUS_AMT;

	@Column(name = "BON_CR_DT")
	private Date BON_CR_DT;

	@Column(name = "BON_CR_UID")
	private String BON_CR_UID;

	@Column(name = "BON_UPD_DT")
	private Date BON_UPD_DT;

	@Column(name = "BON_UPD_UID")
	private String BON_UPD_UID;

	@Column(name = "BON_PAID_YN")
	private String BON_PAID_YN;

	@Column(name = "BON_YEAR")
	private Double BON_YEAR;

	@Column(name = "BON_POST_YN")
	private String BON_POST_YN;

	@Column(name = "BON_TXN_CODE")
	private String BON_TXN_CODE;

	@Column(name = "BON_DOC_NO")
	private Double BON_DOC_NO;

	@Column(name = "BON_ACNT_YEAR")
	private Double BON_ACNT_YEAR;

	@Column(name = "BON_CN_YN")
	private String BON_CN_YN;

	@Column(name = "BON_PV_YN")
	private String BON_PV_YN;

	@Column(name = "BON_PAY_TO")
	private String BON_PAY_TO;
	
	
	
	/*******************   Newly added by dhinesh on 2.3.2017 ***********************/
	
	private String UI_BON_BONUS_DESC;
	
	public String getUI_BON_BONUS_DESC() {
		return UI_BON_BONUS_DESC;
	}

	public void setUI_BON_BONUS_DESC(String uI_BON_BONUS_DESC) {
		UI_BON_BONUS_DESC = uI_BON_BONUS_DESC;
	}

	/************************* End *********************************/
	
	
	
	/*Added By Jagadeesh for the ssp Call ID: FALCONQC-1715538*/
	
	private String UI_BON_FC_BONUS_AMT;
	
	private String UI_BON_LC_BONUS_AMT;	


	public String getUI_BON_FC_BONUS_AMT() {
		return UI_BON_FC_BONUS_AMT;
	}

	public void setUI_BON_FC_BONUS_AMT(String uI_BON_FC_BONUS_AMT) {
		UI_BON_FC_BONUS_AMT = uI_BON_FC_BONUS_AMT;
	}

	public String getUI_BON_LC_BONUS_AMT() {
		return UI_BON_LC_BONUS_AMT;
	}

	public void setUI_BON_LC_BONUS_AMT(String uI_BON_LC_BONUS_AMT) {
		UI_BON_LC_BONUS_AMT = uI_BON_LC_BONUS_AMT;
	}

	/*End*/
	
	public void setBON_BONUS_CODE(String BON_BONUS_CODE) {
		this.BON_BONUS_CODE = BON_BONUS_CODE;
	}

	public String getBON_BONUS_CODE() {
		return BON_BONUS_CODE;
	}

	public void setBON_ACNT_YEAR(Double BON_ACNT_YEAR) {
		this.BON_ACNT_YEAR = BON_ACNT_YEAR;
	}

	public Double getBON_ACNT_YEAR() {
		return BON_ACNT_YEAR;
	}

	public void setBON_LC_BONUS_AMT(Double BON_LC_BONUS_AMT) {
		this.BON_LC_BONUS_AMT = BON_LC_BONUS_AMT;
	}

	public Double getBON_LC_BONUS_AMT() {
		return BON_LC_BONUS_AMT;
	}

	public void setBON_FC_BONUS_AMT(Double BON_FC_BONUS_AMT) {
		this.BON_FC_BONUS_AMT = BON_FC_BONUS_AMT;
	}

	public Double getBON_FC_BONUS_AMT() {
		return BON_FC_BONUS_AMT;
	}

	public void setBON_UPD_UID(String BON_UPD_UID) {
		this.BON_UPD_UID = BON_UPD_UID;
	}

	public String getBON_UPD_UID() {
		return BON_UPD_UID;
	}

	public void setBON_UPD_DT(Date BON_UPD_DT) {
		this.BON_UPD_DT = BON_UPD_DT;
	}

	public Date getBON_UPD_DT() {
		return BON_UPD_DT;
	}

	public void setBON_CN_YN(String BON_CN_YN) {
		this.BON_CN_YN = BON_CN_YN;
	}

	public String getBON_CN_YN() {
		return BON_CN_YN;
	}

	public void setBON_DOC_NO(Double BON_DOC_NO) {
		this.BON_DOC_NO = BON_DOC_NO;
	}

	public Double getBON_DOC_NO() {
		return BON_DOC_NO;
	}

	public void setBON_POST_YN(String BON_POST_YN) {
		this.BON_POST_YN = BON_POST_YN;
	}

	public String getBON_POST_YN() {
		return BON_POST_YN;
	}

	public void setBON_PAID_YN(String BON_PAID_YN) {
		this.BON_PAID_YN = BON_PAID_YN;
	}

	public String getBON_PAID_YN() {
		return BON_PAID_YN;
	}

	public void setBON_PAY_TO(String BON_PAY_TO) {
		this.BON_PAY_TO = BON_PAY_TO;
	}

	public String getBON_PAY_TO() {
		return BON_PAY_TO;
	}

	public void setBON_YEAR(Double BON_YEAR) {
		this.BON_YEAR = BON_YEAR;
	}

	public Double getBON_YEAR() {
		return BON_YEAR;
	}

	public void setBON_PV_YN(String BON_PV_YN) {
		this.BON_PV_YN = BON_PV_YN;
	}

	public String getBON_PV_YN() {
		return BON_PV_YN;
	}

	public void setBON_POL_SYS_ID(Long BON_POL_SYS_ID) {
		this.BON_POL_SYS_ID = BON_POL_SYS_ID;
	}

	public Long getBON_POL_SYS_ID() {
		return BON_POL_SYS_ID;
	}

	public void setBON_REF_TYPE(String BON_REF_TYPE) {
		this.BON_REF_TYPE = BON_REF_TYPE;
	}

	public String getBON_REF_TYPE() {
		return BON_REF_TYPE;
	}

	public void setBON_SYS_ID(Long BON_SYS_ID) {
		this.BON_SYS_ID = BON_SYS_ID;
	}

	public Long getBON_SYS_ID() {
		return BON_SYS_ID;
	}

	public void setBON_REF_SYS_ID(Long BON_REF_SYS_ID) {
		this.BON_REF_SYS_ID = BON_REF_SYS_ID;
	}

	public Long getBON_REF_SYS_ID() {
		return BON_REF_SYS_ID;
	}

	public void setBON_TXN_CODE(String BON_TXN_CODE) {
		this.BON_TXN_CODE = BON_TXN_CODE;
	}

	public String getBON_TXN_CODE() {
		return BON_TXN_CODE;
	}

	public void setBON_CR_UID(String BON_CR_UID) {
		this.BON_CR_UID = BON_CR_UID;
	}

	public String getBON_CR_UID() {
		return BON_CR_UID;
	}

	public void setBON_CR_DT(Date BON_CR_DT) {
		this.BON_CR_DT = BON_CR_DT;
	}

	public Date getBON_CR_DT() {
		return BON_CR_DT;
	}

}
