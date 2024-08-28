package com.iii.pel.forms.PILM074_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_LIFE_TAX_APPL_CUST")
public class PM_LIFE_TAX_APPL_CUST extends BaseValueBean {

	@Column(name="TAC_CUST_CLASS")
	private String TAC_CUST_CLASS;

	private String TAC_CUST_CLASS_DESC;

	@Column(name="TAC_EFF_FM_DT")
	private Date TAC_EFF_FM_DT;

	@Column(name="TAC_EFF_TO_DT")
	private Date TAC_EFF_TO_DT;

	@Column(name="TAC_TH_TAX_TYPE")
	private String TAC_TH_TAX_TYPE;
	
	@Column(name="TAC_CR_DT")
	private Date TAC_CR_DT;
	
	@Column(name="TAC_CR_UID")
	private String TAC_CR_UID;
	
	@Column(name="TAC_UPD_DT")
	private Date TAC_UPD_DT;
	
	@Column(name="TAC_UPD_UID")
	private String TAC_UPD_UID;
	
	private boolean checkBoxValue;
	
	
	@Column(name="TAC_CUST_CLASS_TO")
	private String TAC_CUST_CLASS_TO;
	
	private String TAC_CUST_CLASS_TO_DESC;

	public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public String getTAC_CUST_CLASS() {
		return TAC_CUST_CLASS;
	}

	public void setTAC_CUST_CLASS(String TAC_CUST_CLASS) {
		this.TAC_CUST_CLASS = TAC_CUST_CLASS;
	}

	public String getTAC_CUST_CLASS_DESC() {
		return TAC_CUST_CLASS_DESC;
	}

	public void setTAC_CUST_CLASS_DESC(String TAC_CUST_CLASS_DESC) {
		this.TAC_CUST_CLASS_DESC = TAC_CUST_CLASS_DESC;
	}

	public Date getTAC_EFF_FM_DT() {
		 return TAC_EFF_FM_DT;
	}

	public void setTAC_EFF_FM_DT(Date TAC_EFF_FM_DT) {
		this.TAC_EFF_FM_DT = TAC_EFF_FM_DT;
	}

	public Date getTAC_EFF_TO_DT() {
		 return TAC_EFF_TO_DT;
	}

	public void setTAC_EFF_TO_DT(Date TAC_EFF_TO_DT) {
		this.TAC_EFF_TO_DT = TAC_EFF_TO_DT;
	}

	public String getTAC_TH_TAX_TYPE() {
		return TAC_TH_TAX_TYPE;
	}

	public void setTAC_TH_TAX_TYPE(String tac_th_tax_type) {
		TAC_TH_TAX_TYPE = tac_th_tax_type;
	}

	public Date getTAC_CR_DT() {
		return TAC_CR_DT;
	}

	public void setTAC_CR_DT(Date tac_cr_dt) {
		TAC_CR_DT = tac_cr_dt;
	}

	public String getTAC_CR_UID() {
		return TAC_CR_UID;
	}

	public void setTAC_CR_UID(String tac_cr_uid) {
		TAC_CR_UID = tac_cr_uid;
	}

	public Date getTAC_UPD_DT() {
		return TAC_UPD_DT;
	}

	public void setTAC_UPD_DT(Date tac_upd_dt) {
		TAC_UPD_DT = tac_upd_dt;
	}

	public String getTAC_UPD_UID() {
		return TAC_UPD_UID;
	}

	public void setTAC_UPD_UID(String tac_upd_uid) {
		TAC_UPD_UID = tac_upd_uid;
	}

	public String getTAC_CUST_CLASS_TO() {
		return TAC_CUST_CLASS_TO;
	}

	public void setTAC_CUST_CLASS_TO(String tAC_CUST_CLASS_TO) {
		TAC_CUST_CLASS_TO = tAC_CUST_CLASS_TO;
	}

	public String getTAC_CUST_CLASS_TO_DESC() {
		return TAC_CUST_CLASS_TO_DESC;
	}

	public void setTAC_CUST_CLASS_TO_DESC(String tAC_CUST_CLASS_TO_DESC) {
		TAC_CUST_CLASS_TO_DESC = tAC_CUST_CLASS_TO_DESC;
	}
	
	
}
