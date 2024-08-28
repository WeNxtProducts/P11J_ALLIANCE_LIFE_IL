package com.iii.pel.forms.PM102_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_PF_ACNT_TYPE")
public class PM_AGENT_PF_ACNT_TYPE extends BaseValueBean {

	@Column(name="APAT_CODE")
	private String APAT_CODE;

	@Column(name="APAT_RATE")
	private Double APAT_RATE;

	@Column(name="APAT_AGE")
	private Integer APAT_AGE;
	
	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	private String APAT_CODE_DESC;
	private String filterByAPAT_CODE;
	private String filterByAPAT_RATE;
	private String filterByAPAT_CODE_DESC;
	
	
	
	@Column(name="APAT_CR_UID")
	private String APAT_CR_UID;
	
	@Column(name="APAT_CR_DT")
	private Date APAT_CR_DT;
	
	@Column(name="APAT_UPD_UID")
	private String APAT_UPD_UID;
	
	@Column(name="APAT_UPD_DT")
	private Date APAT_UPD_DT;
	
	private boolean CHECK_BOX;
	



	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	/*public Double getAPAT_SYS_ID() {
		return APAT_SYS_ID;
	}

	public void setAPAT_SYS_ID(Double apat_sys_id) {
		APAT_SYS_ID = apat_sys_id;
	}*/

	public String getAPAT_CR_UID() {
		return APAT_CR_UID;
	}

	public void setAPAT_CR_UID(String apat_cr_uid) {
		APAT_CR_UID = apat_cr_uid;
	}

	public Date getAPAT_CR_DT() {
		return APAT_CR_DT;
	}

	public void setAPAT_CR_DT(Date apat_cr_dt) {
		APAT_CR_DT = apat_cr_dt;
	}

	public String getAPAT_CODE() {
		return APAT_CODE;
	}

	public void setAPAT_CODE(String APAT_CODE) {
		this.APAT_CODE = APAT_CODE;
	}

	public Double getAPAT_RATE() {
		return APAT_RATE;
	}

	public void setAPAT_RATE(Double APAT_RATE) {
		this.APAT_RATE = APAT_RATE;
	}

	public Integer getAPAT_AGE() {
		return APAT_AGE;
	}

	public void setAPAT_AGE(Integer APAT_AGE) {
		this.APAT_AGE = APAT_AGE;
	}

	public String getAPAT_UPD_UID() {
		return APAT_UPD_UID;
	}

	public void setAPAT_UPD_UID(String apat_upd_uid) {
		APAT_UPD_UID = apat_upd_uid;
	}

	public Date getAPAT_UPD_DT() {
		return APAT_UPD_DT;
	}

	public void setAPAT_UPD_DT(Date apat_upd_dt) {
		APAT_UPD_DT = apat_upd_dt;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	
	public String getFilterByAPAT_CODE() {
		return filterByAPAT_CODE;
	}

	public void setFilterByAPAT_CODE(String filterByAPAT_CODE) {
		this.filterByAPAT_CODE = filterByAPAT_CODE;
	}

	public String getFilterByAPAT_RATE() {
		return filterByAPAT_RATE;
	}

	public void setFilterByAPAT_RATE(String filterByAPAT_RATE) {
		this.filterByAPAT_RATE = filterByAPAT_RATE;
	}

	public String getFilterByAPAT_CODE_DESC() {
		return filterByAPAT_CODE_DESC;
	}

	public void setFilterByAPAT_CODE_DESC(String filterByAPAT_CODE_DESC) {
		this.filterByAPAT_CODE_DESC = filterByAPAT_CODE_DESC;
	}

	public String getAPAT_CODE_DESC() {
		return APAT_CODE_DESC;
	}

	public void setAPAT_CODE_DESC(String apat_code_desc) {
		APAT_CODE_DESC = apat_code_desc;
	}
}
