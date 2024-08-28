package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PM_IL_PROD_APPL_CVR_GRP")
public class PM_IL_PROD_APPL_CVR_GRP extends BaseValueBean {

	@Column(name="PACG_PROD_CODE")
	private String PACG_PROD_CODE;

	@Column(name="PACG_CVR_GROUP_CODE")
	private String PACG_CVR_GROUP_CODE;

	@Column(name="PACG_MANDATORY_YN")
	private String PACG_MANDATORY_YN;

	@Column(name="PACG_DEFAULT_YN")
	private String PACG_DEFAULT_YN;

	@Column(name="PACG_FRZ_FLAG")
	private String PACG_FRZ_FLAG;

	@Column(name="PACG_CR_DT")
	private Date PACG_CR_DT;

	@Column(name="PACG_CR_UID")
	private String PACG_CR_UID;

	@Column(name="PACG_UPD_DT")
	private Date PACG_UPD_DT;

	@Column(name="PACG_UPD_UID")
	private String PACG_UPD_UID;

	private String UI_M_CVR_GROUP_DESC;
	public void setPACG_CVR_GROUP_CODE(String PACG_CVR_GROUP_CODE) {
		this.PACG_CVR_GROUP_CODE = PACG_CVR_GROUP_CODE;
	}
	public String getPACG_CVR_GROUP_CODE() {
		 return PACG_CVR_GROUP_CODE;
	}
	public void setPACG_MANDATORY_YN(String PACG_MANDATORY_YN) {
		this.PACG_MANDATORY_YN = PACG_MANDATORY_YN;
	}
	public String getPACG_MANDATORY_YN() {
		 return PACG_MANDATORY_YN;
	}
	public void setUI_M_CVR_GROUP_DESC(String UI_M_CVR_GROUP_DESC) {
		this.UI_M_CVR_GROUP_DESC = UI_M_CVR_GROUP_DESC;
	}
	public String getUI_M_CVR_GROUP_DESC() {
		 return UI_M_CVR_GROUP_DESC;
	}
	public void setPACG_UPD_DT(Date PACG_UPD_DT) {
		this.PACG_UPD_DT = PACG_UPD_DT;
	}
	public Date getPACG_UPD_DT() {
		 return PACG_UPD_DT;
	}
	public void setPACG_FRZ_FLAG(String PACG_FRZ_FLAG) {
		this.PACG_FRZ_FLAG = PACG_FRZ_FLAG;
	}
	public String getPACG_FRZ_FLAG() {
		 return PACG_FRZ_FLAG;
	}
	public void setPACG_PROD_CODE(String PACG_PROD_CODE) {
		this.PACG_PROD_CODE = PACG_PROD_CODE;
	}
	public String getPACG_PROD_CODE() {
		 return PACG_PROD_CODE;
	}
	public void setPACG_CR_DT(Date PACG_CR_DT) {
		this.PACG_CR_DT = PACG_CR_DT;
	}
	public Date getPACG_CR_DT() {
		 return PACG_CR_DT;
	}
	public void setPACG_UPD_UID(String PACG_UPD_UID) {
		this.PACG_UPD_UID = PACG_UPD_UID;
	}
	public String getPACG_UPD_UID() {
		 return PACG_UPD_UID;
	}
	public void setPACG_DEFAULT_YN(String PACG_DEFAULT_YN) {
		this.PACG_DEFAULT_YN = PACG_DEFAULT_YN;
	}
	public String getPACG_DEFAULT_YN() {
		 return PACG_DEFAULT_YN;
	}
	public void setPACG_CR_UID(String PACG_CR_UID) {
		this.PACG_CR_UID = PACG_CR_UID;
	}
	public String getPACG_CR_UID() {
		 return PACG_CR_UID;
	}

}
