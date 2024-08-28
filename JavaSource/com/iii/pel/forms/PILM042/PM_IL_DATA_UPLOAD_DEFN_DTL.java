package com.iii.pel.forms.PILM042;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DATA_UPLOAD_DEFN_DTL")
public class PM_IL_DATA_UPLOAD_DEFN_DTL extends BaseValueBean {

	@Id
	@Column(name = "ROWID")
	private String ROWID;
	
// Adding DUDD_DUDH_DEF_CODE to beaning for inserting Dummy Data actually it has to come from PM_IL_DATA_UPLOAD_DEFN_HDR form
	@Column(name ="DUDD_DUDH_DEF_CODE")
	private String DUDD_DUDH_DEF_CODE;

	@Column(name="DUDD_CR_DT")
	private Date DUDD_CR_DT;
	
	@Column(name="DUDD_CR_UID")
	private String DUDD_CR_UID;

	
	@Column(name="DUDD_UPD_DT")
	private Date DUDD_UPD_DT;
	
	@Column(name="DUDD_UPD_UID")
	private String DUDD_UPD_UID;
	
	@Column(name="DUDD_SERIAL_NO")
	private Integer DUDD_SERIAL_NO;

	@Column(name="DUDD_PARA_NAME")
	private String DUDD_PARA_NAME;

	@Column(name="DUDD_PARA_TYPE")
	private String DUDD_PARA_TYPE;

	@Column(name="DUDD_INPUT_DATA_TYPE")
	private String DUDD_INPUT_DATA_TYPE;

	@Column(name="DUDD_FORMAT")
	private String DUDD_FORMAT;

	@Column(name="DUDD_TABLE_NAME")
	private String DUDD_TABLE_NAME;

	@Column(name="DUDD_FIELD_NAME")
	private String DUDD_FIELD_NAME;

	@Column(name="DUDD_LINK_COLUMN")
	private String DUDD_LINK_COLUMN;

	@Column(name="DUDD_RET_PARA")
	private String DUDD_RET_PARA;

	@Column(name="DUDD_STORAGE_YN")
	private String DUDD_STORAGE_YN;

	@Column(name="DUDD_LINK_SERIAL_NO")
	private Integer DUDD_LINK_SERIAL_NO;



	
	/**
	 * @return the dUDD_SERIAL_NO
	 */
	public Integer getDUDD_SERIAL_NO() {
		return DUDD_SERIAL_NO;
	}

	/**
	 * @param dudd_serial_no the dUDD_SERIAL_NO to set
	 */
	public void setDUDD_SERIAL_NO(Integer dudd_serial_no) {
		DUDD_SERIAL_NO = dudd_serial_no;
	}

	public String getDUDD_PARA_NAME() {
		return DUDD_PARA_NAME;
	}

	public void setDUDD_PARA_NAME(String DUDD_PARA_NAME) {
		this.DUDD_PARA_NAME = DUDD_PARA_NAME;
	}

	public String getDUDD_PARA_TYPE() {
		return DUDD_PARA_TYPE;
	}

	public void setDUDD_PARA_TYPE(String DUDD_PARA_TYPE) {
		this.DUDD_PARA_TYPE = DUDD_PARA_TYPE;
	}

	public String getDUDD_INPUT_DATA_TYPE() {
		return DUDD_INPUT_DATA_TYPE;
	}

	public void setDUDD_INPUT_DATA_TYPE(String DUDD_INPUT_DATA_TYPE) {
		this.DUDD_INPUT_DATA_TYPE = DUDD_INPUT_DATA_TYPE;
	}

	public String getDUDD_FORMAT() {
		return DUDD_FORMAT;
	}

	public void setDUDD_FORMAT(String DUDD_FORMAT) {
		this.DUDD_FORMAT = DUDD_FORMAT;
	}

	public String getDUDD_TABLE_NAME() {
		return DUDD_TABLE_NAME;
	}

	public void setDUDD_TABLE_NAME(String DUDD_TABLE_NAME) {
		this.DUDD_TABLE_NAME = DUDD_TABLE_NAME;
	}

	public String getDUDD_FIELD_NAME() {
		return DUDD_FIELD_NAME;
	}

	public void setDUDD_FIELD_NAME(String DUDD_FIELD_NAME) {
		this.DUDD_FIELD_NAME = DUDD_FIELD_NAME;
	}

	public String getDUDD_LINK_COLUMN() {
		return DUDD_LINK_COLUMN;
	}

	public void setDUDD_LINK_COLUMN(String DUDD_LINK_COLUMN) {
		this.DUDD_LINK_COLUMN = DUDD_LINK_COLUMN;
	}

	public String getDUDD_RET_PARA() {
		return DUDD_RET_PARA;
	}

	public void setDUDD_RET_PARA(String DUDD_RET_PARA) {
		this.DUDD_RET_PARA = DUDD_RET_PARA;
	}

	public String getDUDD_STORAGE_YN() {
		return DUDD_STORAGE_YN;
	}

	public void setDUDD_STORAGE_YN(String DUDD_STORAGE_YN) {
		this.DUDD_STORAGE_YN = DUDD_STORAGE_YN;
	}


	/**
	 * @return the dUDD_LINK_SERIAL_NO
	 */
	public Integer getDUDD_LINK_SERIAL_NO() {
		return DUDD_LINK_SERIAL_NO;
	}

	/**
	 * @param dudd_link_serial_no the dUDD_LINK_SERIAL_NO to set
	 */
	public void setDUDD_LINK_SERIAL_NO(Integer dudd_link_serial_no) {
		DUDD_LINK_SERIAL_NO = dudd_link_serial_no;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getDUDD_DUDH_DEF_CODE() {
		return DUDD_DUDH_DEF_CODE;
	}

	public void setDUDD_DUDH_DEF_CODE(String dudd_dudh_def_code) {
		DUDD_DUDH_DEF_CODE = dudd_dudh_def_code;
	}

	public Date getDUDD_CR_DT() {
		return DUDD_CR_DT;
	}

	public void setDUDD_CR_DT(Date dudd_cr_dt) {
		DUDD_CR_DT = dudd_cr_dt;
	}

	public String getDUDD_CR_UID() {
		return DUDD_CR_UID;
	}

	public void setDUDD_CR_UID(String dudd_cr_uid) {
		DUDD_CR_UID = dudd_cr_uid;
	}

	public Date getDUDD_UPD_DT() {
		return DUDD_UPD_DT;
	}

	public void setDUDD_UPD_DT(Date dudd_upd_dt) {
		DUDD_UPD_DT = dudd_upd_dt;
	}

	public String getDUDD_UPD_UID() {
		return DUDD_UPD_UID;
	}

	public void setDUDD_UPD_UID(String dudd_upd_uid) {
		DUDD_UPD_UID = dudd_upd_uid;
	}
}
