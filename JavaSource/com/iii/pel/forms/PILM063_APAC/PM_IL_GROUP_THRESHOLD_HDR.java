package com.iii.pel.forms.PILM063_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="pm_il_group_threshold_hdr")
public class PM_IL_GROUP_THRESHOLD_HDR extends BaseValueBean {

	@Column(name="GTH_GROUP_CODE")
	private String GTH_GROUP_CODE;

	@Column(name="GTH_GROUP_DESC")
	private String GTH_GROUP_DESC;

	@Column(name="GTH_GROUP_SHORT_DESC")
	private String GTH_GROUP_SHORT_DESC;

	@Column(name="GTH_GROUP_LONG_DESC")
	private String GTH_GROUP_LONG_DESC;

	@Column(name="GTH_VALIDATION_CODE")
	private String GTH_VALIDATION_CODE;

	private String UI_M_GTH_VALIDATION_CODE_DESC;

	/** These variables are added. */
	
	private String GTH_CR_UID;
	private Date GTH_CR_DT;
	private String GTH_TYPE;
	private String GTH_UPD_UID;
	private Date GTH_UPD_DT;
	private String ROWID;
	
	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	/** These variables are added. */
	
	public String getGTH_CR_UID() {
		return GTH_CR_UID;
	}

	public void setGTH_CR_UID(String gth_cr_uid) {
		GTH_CR_UID = gth_cr_uid;
	}

	public Date getGTH_CR_DT() {
		return GTH_CR_DT;
	}

	public void setGTH_CR_DT(Date gth_cr_dt) {
		GTH_CR_DT = gth_cr_dt;
	}

	public String getGTH_TYPE() {
		return GTH_TYPE;
	}

	public void setGTH_TYPE(String gth_type) {
		GTH_TYPE = gth_type;
	}

	public String getGTH_UPD_UID() {
		return GTH_UPD_UID;
	}

	public void setGTH_UPD_UID(String gth_upd_uid) {
		GTH_UPD_UID = gth_upd_uid;
	}

	public Date getGTH_UPD_DT() {
		return GTH_UPD_DT;
	}

	public void setGTH_UPD_DT(Date gth_upd_dt) {
		GTH_UPD_DT = gth_upd_dt;
	}

	

	public String getGTH_GROUP_CODE() {
		return GTH_GROUP_CODE;
	}

	public void setGTH_GROUP_CODE(String GTH_GROUP_CODE) {
		this.GTH_GROUP_CODE = GTH_GROUP_CODE;
	}

	public String getGTH_GROUP_DESC() {
		return GTH_GROUP_DESC;
	}

	public void setGTH_GROUP_DESC(String GTH_GROUP_DESC) {
		this.GTH_GROUP_DESC = GTH_GROUP_DESC;
	}

	public String getGTH_GROUP_SHORT_DESC() {
		return GTH_GROUP_SHORT_DESC;
	}

	public void setGTH_GROUP_SHORT_DESC(String GTH_GROUP_SHORT_DESC) {
		this.GTH_GROUP_SHORT_DESC = GTH_GROUP_SHORT_DESC;
	}

	public String getGTH_GROUP_LONG_DESC() {
		return GTH_GROUP_LONG_DESC;
	}

	public void setGTH_GROUP_LONG_DESC(String GTH_GROUP_LONG_DESC) {
		this.GTH_GROUP_LONG_DESC = GTH_GROUP_LONG_DESC;
	}

	public String getGTH_VALIDATION_CODE() {
		return GTH_VALIDATION_CODE;
	}

	public void setGTH_VALIDATION_CODE(String GTH_VALIDATION_CODE) {
		this.GTH_VALIDATION_CODE = GTH_VALIDATION_CODE;
	}

	public String getUI_M_GTH_VALIDATION_CODE_DESC() {
		return UI_M_GTH_VALIDATION_CODE_DESC;
	}

	public void setUI_M_GTH_VALIDATION_CODE_DESC(String UI_M_GTH_VALIDATION_CODE_DESC) {
		this.UI_M_GTH_VALIDATION_CODE_DESC = UI_M_GTH_VALIDATION_CODE_DESC;
	}
}
