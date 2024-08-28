package com.iii.pel.forms.PILM036;


import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BONUS")
public class PM_IL_BONUS extends BaseValueBean{

	@Column(name="BONUS_BL_DESC")
	private String BONUS_BL_DESC;

	@Column(name="BONUS_BL_SHORT_DESC")
	private String BONUS_BL_SHORT_DESC;

	@Column(name="BONUS_CODE")
	private String BONUS_CODE;

	@Column(name="BONUS_DESC")
	private String BONUS_DESC;

	@Column(name="BONUS_SHORT_DESC")
	private String BONUS_SHORT_DESC;

	@Column(name="BONUS_YRS")
	private Integer BONUS_YRS;

	@Column(name="BONUS_TYPE")
	private String BONUS_TYPE;
	
	private String BONUS_TYPE_DESC;
	
	@Column(name="BONUS_CR_DT")
	private Date BONUS_CR_DT;
	
	@Column(name="BONUS_CR_UID")
	private String BONUS_CR_UID;
	
	@Column(name="BONUS_UPD_DT")
	private Date BONUS_UPD_DT;
	
	@Column(name="BONUS_UPD_UID")
	private String BONUS_UPD_UID;
	
	@Column(name="ROWID")
	private String ROWID;
	
	private boolean selected;
	
	private List<String> BONUS_TYPE_DESC_LIST;
	private List<SelectItem> BONUS_TYPE_LIST;

	public List<SelectItem> getBONUS_TYPE_LIST() {
		return BONUS_TYPE_LIST;
	}

	public void setBONUS_TYPE_LIST(List<SelectItem> bonus_type_list) {
		BONUS_TYPE_LIST = bonus_type_list;
	}

	public List<String> getBONUS_TYPE_DESC_LIST() {
		return BONUS_TYPE_DESC_LIST;
	}

	public void setBONUS_TYPE_DESC_LIST(List<String> bonus_type_list) {
		BONUS_TYPE_DESC_LIST = bonus_type_list;
	}

	public String getBONUS_BL_DESC() {
		return BONUS_BL_DESC;
	}

	public void setBONUS_BL_DESC(String BONUS_BL_DESC) {
		this.BONUS_BL_DESC = BONUS_BL_DESC;
	}

	public String getBONUS_BL_SHORT_DESC() {
		return BONUS_BL_SHORT_DESC;
	}

	public void setBONUS_BL_SHORT_DESC(String BONUS_BL_SHORT_DESC) {
		this.BONUS_BL_SHORT_DESC = BONUS_BL_SHORT_DESC;
	}

	public String getBONUS_CODE() {
		return BONUS_CODE;
	}

	public void setBONUS_CODE(String BONUS_CODE) {
		this.BONUS_CODE = BONUS_CODE;
	}

	public String getBONUS_DESC() {
		return BONUS_DESC;
	}

	public void setBONUS_DESC(String BONUS_DESC) {
		this.BONUS_DESC = BONUS_DESC;
	}

	public String getBONUS_SHORT_DESC() {
		return BONUS_SHORT_DESC;
	}

	public void setBONUS_SHORT_DESC(String BONUS_SHORT_DESC) {
		this.BONUS_SHORT_DESC = BONUS_SHORT_DESC;
	}


	public Integer getBONUS_YRS() {
		return BONUS_YRS;
	}

	public void setBONUS_YRS(Integer bonus_yrs) {
		BONUS_YRS = bonus_yrs;
	}

	public String getBONUS_TYPE() {
		return BONUS_TYPE;
	}

	public void setBONUS_TYPE(String BONUS_TYPE) {
		this.BONUS_TYPE = BONUS_TYPE;
	}

	public Date getBONUS_CR_DT() {
		return BONUS_CR_DT;
	}

	public void setBONUS_CR_DT(Date bonus_cr_dt) {
		BONUS_CR_DT = bonus_cr_dt;
	}

	public String getBONUS_CR_UID() {
		return BONUS_CR_UID;
	}

	public void setBONUS_CR_UID(String bonus_cr_uid) {
		BONUS_CR_UID = bonus_cr_uid;
	}

	public Date getBONUS_UPD_DT() {
		return BONUS_UPD_DT;
	}

	public void setBONUS_UPD_DT(Date bonus_upd_dt) {
		BONUS_UPD_DT = bonus_upd_dt;
	}

	public String getBONUS_UPD_UID() {
		return BONUS_UPD_UID;
	}

	public void setBONUS_UPD_UID(String bonus_upd_uid) {
		BONUS_UPD_UID = bonus_upd_uid;
	}

	public String getBONUS_TYPE_DESC() {
		return BONUS_TYPE_DESC;
	}

	public void setBONUS_TYPE_DESC(String bonus_type_desc) {
		BONUS_TYPE_DESC = bonus_type_desc;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
