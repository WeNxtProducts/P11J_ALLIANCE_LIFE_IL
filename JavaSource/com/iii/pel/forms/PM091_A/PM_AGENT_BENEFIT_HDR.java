package com.iii.pel.forms.PM091_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BENEFIT_HDR")
public class PM_AGENT_BENEFIT_HDR extends BaseValueBean {

	@Column(name="ABH_BNF_CODE")
	private String ABH_BNF_CODE;

	@Column(name="ABH_DESC")
	private String ABH_DESC;

	@Column(name="ABH_SHORT_DESC")
	private String ABH_SHORT_DESC;

	@Column(name="ABH_LONG_DESC")
	private String ABH_LONG_DESC;

	@Column(name="ABH_BNF_TYPE")
	private String ABH_BNF_TYPE;

	@Column(name="ABH_EFF_FM_DT")
	private Date ABH_EFF_FM_DT;

	@Column(name="ABH_EFF_TO_DT")
	private Date ABH_EFF_TO_DT;

	@Column(name="ABH_TAXABLE_YN")
	private String ABH_TAXABLE_YN;

	@Column(name="ABH_BL_DESC")
	private String ABH_BL_DESC;

	@Column(name="ABH_BL_SHORT_DESC")
	private String ABH_BL_SHORT_DESC;

	@Column(name="ABH_CR_DT")
	private Date ABH_CR_DT;
	
	@Column(name="ABH_CR_UID")
	private String ABH_CR_UID;

	@Column(name="ABH_UPD_DT")
	private Date ABH_UPD_DT;
	
	@Column(name="ABH_UPD_UID")
	private String ABH_UPD_UID;
	
	@Column(name="ABH_BL_LONG_DESC")
	private String ABH_BL_LONG_DESC;
	
	
	private boolean selected;



	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getABH_BNF_CODE() {
		return ABH_BNF_CODE;
	}

	public void setABH_BNF_CODE(String ABH_BNF_CODE) {
		this.ABH_BNF_CODE = ABH_BNF_CODE;
	}

	public String getABH_DESC() {
		return ABH_DESC;
	}

	public void setABH_DESC(String ABH_DESC) {
		this.ABH_DESC = ABH_DESC;
	}

	public String getABH_SHORT_DESC() {
		return ABH_SHORT_DESC;
	}

	public void setABH_SHORT_DESC(String ABH_SHORT_DESC) {
		this.ABH_SHORT_DESC = ABH_SHORT_DESC;
	}

	public String getABH_LONG_DESC() {
		return ABH_LONG_DESC;
	}

	public void setABH_LONG_DESC(String ABH_LONG_DESC) {
		this.ABH_LONG_DESC = ABH_LONG_DESC;
	}

	public String getABH_BNF_TYPE() {
		return ABH_BNF_TYPE;
	}

	public void setABH_BNF_TYPE(String ABH_BNF_TYPE) {
		this.ABH_BNF_TYPE = ABH_BNF_TYPE;
	}

	public Date getABH_EFF_FM_DT() {
		 return ABH_EFF_FM_DT;
	}

	public void setABH_EFF_FM_DT(Date ABH_EFF_FM_DT) {
		this.ABH_EFF_FM_DT = ABH_EFF_FM_DT;
	}

	public Date getABH_EFF_TO_DT() {
		 return ABH_EFF_TO_DT;
	}

	public void setABH_EFF_TO_DT(Date ABH_EFF_TO_DT) {
		this.ABH_EFF_TO_DT = ABH_EFF_TO_DT;
	}

	public String getABH_TAXABLE_YN() {
		return ABH_TAXABLE_YN;
	}

	public void setABH_TAXABLE_YN(String ABH_TAXABLE_YN) {
		this.ABH_TAXABLE_YN = ABH_TAXABLE_YN;
	}

	public String getABH_BL_DESC() {
		return ABH_BL_DESC;
	}

	public void setABH_BL_DESC(String ABH_BL_DESC) {
		this.ABH_BL_DESC = ABH_BL_DESC;
	}

	public String getABH_BL_SHORT_DESC() {
		return ABH_BL_SHORT_DESC;
	}

	public void setABH_BL_SHORT_DESC(String ABH_BL_SHORT_DESC) {
		this.ABH_BL_SHORT_DESC = ABH_BL_SHORT_DESC;
	}

	public String getABH_BL_LONG_DESC() {
		return ABH_BL_LONG_DESC;
	}

	public void setABH_BL_LONG_DESC(String ABH_BL_LONG_DESC) {
		this.ABH_BL_LONG_DESC = ABH_BL_LONG_DESC;
	}

	public Date getABH_CR_DT() {
		return ABH_CR_DT;
	}

	public void setABH_CR_DT(Date abh_cr_dt) {
		ABH_CR_DT = abh_cr_dt;
	}

	public String getABH_CR_UID() {
		return ABH_CR_UID;
	}

	public void setABH_CR_UID(String abh_cr_uid) {
		ABH_CR_UID = abh_cr_uid;
	}

	public Date getABH_UPD_DT() {
		return ABH_UPD_DT;
	}

	public void setABH_UPD_DT(Date abh_upd_dt) {
		ABH_UPD_DT = abh_upd_dt;
	}

	public String getABH_UPD_UID() {
		return ABH_UPD_UID;
	}

	public void setABH_UPD_UID(String abh_upd_uid) {
		ABH_UPD_UID = abh_upd_uid;
	}
}
