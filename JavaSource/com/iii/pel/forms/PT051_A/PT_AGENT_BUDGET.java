package com.iii.pel.forms.PT051_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_BUDGET")
public class PT_AGENT_BUDGET extends BaseValueBean {

	@Column(name="ABGT_AGENT_CODE")
	private String ABGT_AGENT_CODE;

	private String UI_M_ABGT_AGENT_NAME;

	private String UI_M_ABGT_AGENCY_CODE;

	private String UI_M_ABGT_AGENCY_NAME;

	@Column(name="ABGT_MODULE_ID")
	private String ABGT_MODULE_ID;

	@Column(name="ABGT_NO_OF_POL")
	private Long ABGT_NO_OF_POL;

	@Column(name="ABGT_LC_PREM")
	private Double ABGT_LC_PREM;

	@Column(name="ABGT_FM_DT")
	private Date ABGT_FM_DT;

	@Column(name="ABGT_TO_DT")
	private Date ABGT_TO_DT;

	@Column(name="ABGT_CR_DT")
	private Date ABGT_CR_DT;

	@Column(name="ABGT_CR_UID")
	private String ABGT_CR_UID;
	
	@Column(name="ABGT_SYS_ID")
	private Double ABGT_SYS_ID;
	
	@Column(name="ABGT_UPD_DT")
	private Date ABGT_UPD_DT;
	
	@Column(name="ABGT_UPD_UID")
	private String ABGT_UPD_UID;
	
	public String getABGT_AGENT_CODE() {
		return ABGT_AGENT_CODE;
	}

	public void setABGT_AGENT_CODE(String ABGT_AGENT_CODE) {
		this.ABGT_AGENT_CODE = ABGT_AGENT_CODE;
	}

	public String getUI_M_ABGT_AGENT_NAME() {
		return UI_M_ABGT_AGENT_NAME;
	}

	public void setUI_M_ABGT_AGENT_NAME(String UI_M_ABGT_AGENT_NAME) {
		this.UI_M_ABGT_AGENT_NAME = UI_M_ABGT_AGENT_NAME;
	}

	public String getUI_M_ABGT_AGENCY_CODE() {
		return UI_M_ABGT_AGENCY_CODE;
	}

	public void setUI_M_ABGT_AGENCY_CODE(String UI_M_ABGT_AGENCY_CODE) {
		this.UI_M_ABGT_AGENCY_CODE = UI_M_ABGT_AGENCY_CODE;
	}

	public String getUI_M_ABGT_AGENCY_NAME() {
		return UI_M_ABGT_AGENCY_NAME;
	}

	public void setUI_M_ABGT_AGENCY_NAME(String UI_M_ABGT_AGENCY_NAME) {
		this.UI_M_ABGT_AGENCY_NAME = UI_M_ABGT_AGENCY_NAME;
	}

	public String getABGT_MODULE_ID() {
		return ABGT_MODULE_ID;
	}

	public void setABGT_MODULE_ID(String ABGT_MODULE_ID) {
		this.ABGT_MODULE_ID = ABGT_MODULE_ID;
	}

	public Double getABGT_LC_PREM() {
		return ABGT_LC_PREM;
	}

	public void setABGT_LC_PREM(Double ABGT_LC_PREM) {
		this.ABGT_LC_PREM = ABGT_LC_PREM;
	}

	public Date getABGT_FM_DT() {
		 return ABGT_FM_DT;
	}

	public void setABGT_FM_DT(Date ABGT_FM_DT) {
		this.ABGT_FM_DT = ABGT_FM_DT;
	}

	public Date getABGT_TO_DT() {
		 return ABGT_TO_DT;
	}

	public void setABGT_TO_DT(Date ABGT_TO_DT) {
		this.ABGT_TO_DT = ABGT_TO_DT;
	}

	public Date getABGT_CR_DT() {
		return ABGT_CR_DT;
	}

	public void setABGT_CR_DT(Date abgt_cr_dt) {
		ABGT_CR_DT = abgt_cr_dt;
	}

	public String getABGT_CR_UID() {
		return ABGT_CR_UID;
	}

	public void setABGT_CR_UID(String abgt_cr_uid) {
		ABGT_CR_UID = abgt_cr_uid;
	}

	public Double getABGT_SYS_ID() {
		return ABGT_SYS_ID;
	}

	public void setABGT_SYS_ID(Double abgt_sys_id) {
		ABGT_SYS_ID = abgt_sys_id;
	}

	public Date getABGT_UPD_DT() {
		return ABGT_UPD_DT;
	}

	public void setABGT_UPD_DT(Date abgt_upd_dt) {
		ABGT_UPD_DT = abgt_upd_dt;
	}

	public String getABGT_UPD_UID() {
		return ABGT_UPD_UID;
	}

	public void setABGT_UPD_UID(String abgt_upd_uid) {
		ABGT_UPD_UID = abgt_upd_uid;
	}

	/**
	 * @return the aBGT_NO_OF_POL
	 */
	public Long getABGT_NO_OF_POL() {
		return ABGT_NO_OF_POL;
	}

	/**
	 * @param abgt_no_of_pol the aBGT_NO_OF_POL to set
	 */
	public void setABGT_NO_OF_POL(Long abgt_no_of_pol) {
		ABGT_NO_OF_POL = abgt_no_of_pol;
	}

	
	
}
