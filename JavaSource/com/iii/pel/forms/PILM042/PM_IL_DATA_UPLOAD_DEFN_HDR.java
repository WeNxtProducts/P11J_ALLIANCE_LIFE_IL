package com.iii.pel.forms.PILM042;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DATA_UPLOAD_DEFN_HDR")
public class PM_IL_DATA_UPLOAD_DEFN_HDR extends BaseValueBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="DUDH_CR_DT")
	private Date DUDH_CR_DT;
	
	@Column(name="DUDH_CR_UID")
	private String DUDH_CR_UID;
	
	@Column(name="DUDH_DEF_CODE")
	private String DUDH_DEF_CODE;

	@Column(name="DUDH_DESC")
	private String DUDH_DESC;

	@Column(name="DUDH_SHORT_DESC")
	private String DUDH_SHORT_DESC;

	@Column(name="DUDH_LONG_DESC")
	private String DUDH_LONG_DESC;

	@Column(name="DUDH_BL_DESC")
	private String DUDH_BL_DESC;
	
	@Column(name="DUDH_BL_SHORT_DESC")
	private String DUDH_BL_SHORT_DESC;
	
	@Column(name="DUDH_BL_LONG_DESC")
	private String DUDH_BL_LONG_DESC;
	
	@Column(name="DUDH_EFF_FM_DT")
	private Date DUDH_EFF_FM_DT;

	@Column(name="DUDH_EFF_TO_DT")
	private Date DUDH_EFF_TO_DT;

	@Column(name="DUDH_UPD_DT")
	private Date DUDH_UPD_DT;
	
	@Column(name="DUDH_UPD_UID")
	private String DUDH_UPD_UID;
	
	



	public String getDUDH_DEF_CODE() {
		return DUDH_DEF_CODE;
	}

	public void setDUDH_DEF_CODE(String DUDH_DEF_CODE) {
		this.DUDH_DEF_CODE = DUDH_DEF_CODE;
	}

	public String getDUDH_DESC() {
		return DUDH_DESC;
	}

	public void setDUDH_DESC(String DUDH_DESC) {
		this.DUDH_DESC = DUDH_DESC;
	}

	public String getDUDH_SHORT_DESC() {
		return DUDH_SHORT_DESC;
	}

	public void setDUDH_SHORT_DESC(String DUDH_SHORT_DESC) {
		this.DUDH_SHORT_DESC = DUDH_SHORT_DESC;
	}

	public String getDUDH_LONG_DESC() {
		return DUDH_LONG_DESC;
	}

	public void setDUDH_LONG_DESC(String DUDH_LONG_DESC) {
		this.DUDH_LONG_DESC = DUDH_LONG_DESC;
	}

	public Date getDUDH_EFF_FM_DT() {
		 return DUDH_EFF_FM_DT;
	}

	public void setDUDH_EFF_FM_DT(Date DUDH_EFF_FM_DT) {
		this.DUDH_EFF_FM_DT = DUDH_EFF_FM_DT;
	}

	public Date getDUDH_EFF_TO_DT() {
		 return DUDH_EFF_TO_DT;
	}

	public void setDUDH_EFF_TO_DT(Date DUDH_EFF_TO_DT) {
		this.DUDH_EFF_TO_DT = DUDH_EFF_TO_DT;
	}

	public String getDUDH_BL_DESC() {
		return DUDH_BL_DESC;
	}

	public void setDUDH_BL_DESC(String DUDH_BL_DESC) {
		this.DUDH_BL_DESC = DUDH_BL_DESC;
	}

	public String getDUDH_BL_SHORT_DESC() {
		return DUDH_BL_SHORT_DESC;
	}

	public void setDUDH_BL_SHORT_DESC(String DUDH_BL_SHORT_DESC) {
		this.DUDH_BL_SHORT_DESC = DUDH_BL_SHORT_DESC;
	}

	public String getDUDH_BL_LONG_DESC() {
		return DUDH_BL_LONG_DESC;
	}

	public void setDUDH_BL_LONG_DESC(String DUDH_BL_LONG_DESC) {
		this.DUDH_BL_LONG_DESC = DUDH_BL_LONG_DESC;
	}

//	public String getROWID() {
//		return ROWID;
//	}
//
//	public void setROWID(String rowid) {
//		ROWID = rowid;
//	}

	

	public String getDUDH_CR_UID() {
		return DUDH_CR_UID;
	}

	public void setDUDH_CR_UID(String dudh_cr_uid) {
		DUDH_CR_UID = dudh_cr_uid;
	}

	public Date getDUDH_CR_DT() {
		return DUDH_CR_DT;
	}

	public void setDUDH_CR_DT(Date dudh_cr_dt) {
		DUDH_CR_DT = dudh_cr_dt;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Date getDUDH_UPD_DT() {
		return DUDH_UPD_DT;
	}

	public void setDUDH_UPD_DT(Date dudh_upd_dt) {
		DUDH_UPD_DT = dudh_upd_dt;
	}

	public String getDUDH_UPD_UID() {
		return DUDH_UPD_UID;
	}

	public void setDUDH_UPD_UID(String dudh_upd_uid) {
		DUDH_UPD_UID = dudh_upd_uid;
	}
}
