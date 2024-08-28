package com.iii.pel.forms.PILQ137;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name = "PW_IL_AAA_PROCESS_DTLS")
public class PW_IL_AAA_PROCESS_DTLS extends BaseValueBean {
	
	@Column(name="APRD_SYS_ID")
	private Long APRD_SYS_ID;
	
	@Column(name="APRD_POL_NO")
	private String APRD_POL_NO;

	@Column(name="APRD_DUE_DT")
	private Date APRD_DUE_DT;
	
	@Column(name="APRD_PAID_DT")
	private Date APRD_PAID_DT;
	
	@Column(name="APRD_FC_AMT")
	private Double APRD_FC_AMT;
	
	@Column(name="APRD_LC_AMT")
	private Double APRD_LC_AMT;
	
	@Column(name="APRD_DOC_DT")
	private Date APRD_DOC_DT;
	
	@Column(name="APRD_DOC_NO")
	private Integer APRD_DOC_NO;
	
	@Column(name="APRD_CR_DT")
	private Date APRD_CR_DT;

	@Column(name="APRD_CR_UID")
	private String APRD_CR_UID;

	@Column(name="APRD_UPD_DT")
	private Date APRD_UPD_DT;

	@Column(name="APRD_UPD_UID")
	private String APRD_UPD_UID;
	
	
	
	private String UI_M_APRD_POL_NO_DESC;
	

	public String getUI_M_APRD_POL_NO_DESC() {
		return UI_M_APRD_POL_NO_DESC;
	}

	public void setUI_M_APRD_POL_NO_DESC(String uI_M_APRD_POL_NO_DESC) {
		UI_M_APRD_POL_NO_DESC = uI_M_APRD_POL_NO_DESC;
	}

	public Long getAPRD_SYS_ID() {
		return APRD_SYS_ID;
	}

	public void setAPRD_SYS_ID(Long aPRD_SYS_ID) {
		APRD_SYS_ID = aPRD_SYS_ID;
	}

	public String getAPRD_POL_NO() {
		return APRD_POL_NO;
	}

	public void setAPRD_POL_NO(String aPRD_POL_NO) {
		APRD_POL_NO = aPRD_POL_NO;
	}

	public Date getAPRD_DUE_DT() {
		return APRD_DUE_DT;
	}

	public void setAPRD_DUE_DT(Date aPRD_DUE_DT) {
		APRD_DUE_DT = aPRD_DUE_DT;
	}

	public Date getAPRD_PAID_DT() {
		return APRD_PAID_DT;
	}

	public void setAPRD_PAID_DT(Date aPRD_PAID_DT) {
		APRD_PAID_DT = aPRD_PAID_DT;
	}

	
	public Double getAPRD_FC_AMT() {
		return APRD_FC_AMT;
	}

	public void setAPRD_FC_AMT(Double aPRD_FC_AMT) {
		APRD_FC_AMT = aPRD_FC_AMT;
	}

	public Double getAPRD_LC_AMT() {
		return APRD_LC_AMT;
	}

	public void setAPRD_LC_AMT(Double aPRD_LC_AMT) {
		APRD_LC_AMT = aPRD_LC_AMT;
	}

	public Date getAPRD_DOC_DT() {
		return APRD_DOC_DT;
	}

	public void setAPRD_DOC_DT(Date aPRD_DOC_DT) {
		APRD_DOC_DT = aPRD_DOC_DT;
	}

	public Integer getAPRD_DOC_NO() {
		return APRD_DOC_NO;
	}

	public void setAPRD_DOC_NO(Integer aPRD_DOC_NO) {
		APRD_DOC_NO = aPRD_DOC_NO;
	}

	public Date getAPRD_CR_DT() {
		return APRD_CR_DT;
	}

	public void setAPRD_CR_DT(Date aPRD_CR_DT) {
		APRD_CR_DT = aPRD_CR_DT;
	}

	public String getAPRD_CR_UID() {
		return APRD_CR_UID;
	}

	public void setAPRD_CR_UID(String aPRD_CR_UID) {
		APRD_CR_UID = aPRD_CR_UID;
	}

	public Date getAPRD_UPD_DT() {
		return APRD_UPD_DT;
	}

	public void setAPRD_UPD_DT(Date aPRD_UPD_DT) {
		APRD_UPD_DT = aPRD_UPD_DT;
	}

	public String getAPRD_UPD_UID() {
		return APRD_UPD_UID;
	}

	public void setAPRD_UPD_UID(String aPRD_UPD_UID) {
		APRD_UPD_UID = aPRD_UPD_UID;
	}
	
	
	/*Added by saranya on 21-04-2017*/
	@Column(name="APRD_TXN_CODE")
	private String APRD_TXN_CODE;
	
	public String getAPRD_TXN_CODE() {
		return APRD_TXN_CODE;
	}

	public void setAPRD_TXN_CODE(String aPRD_TXN_CODE) {
		APRD_TXN_CODE = aPRD_TXN_CODE;
	}
	/*End*/
}
