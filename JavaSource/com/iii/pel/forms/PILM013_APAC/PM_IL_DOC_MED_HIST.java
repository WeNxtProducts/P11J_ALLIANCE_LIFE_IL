package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_DOC_MED_HIST")
public class PM_IL_DOC_MED_HIST extends BaseValueBean {

	@Column(name = "DMH_DS_TYPE")
	private String DMH_DS_TYPE;

	@Column(name = "DMH_DS_CODE")
	private String DMH_DS_CODE;

	@Column(name = "DMH_SR_NO")
	private int DMH_SR_NO;

	@Column(name = "DMH_CAPTION")
	private String DMH_CAPTION;

	@Column(name = "DMH_BL_CAPTION")
	private String DMH_BL_CAPTION;

	@Column(name = "DMH_DATA_TYPE")
	private String DMH_DATA_TYPE;

	@Column(name = "DMH_MANDATORY_YN")
	private String DMH_MANDATORY_YN;

	@Column(name = "DMH_EFF_FM_DT")
	private Date DMH_EFF_FM_DT;

	@Column(name = "DMH_EFF_TO_DT")
	private Date DMH_EFF_TO_DT;

	@Column(name = "DMH_CR_DT")
	private Date DMH_CR_DT;

	@Column(name = "DMH_CR_UID")
	private String DMH_CR_UID;

	@Column(name = "DMH_UPD_DT")
	private Date DMH_UPD_DT;

	@Column(name = "DMH_UPD_UID")
	private String DMH_UPD_UID;

	@Column(name = "DMH_APPL_ON")
	private String DMH_APPL_ON;

	public PM_IL_DOC_MED_HIST(){
		this.setDMH_DATA_TYPE(PM_IL_DOC_MED_HIST_CONSTANTS.DEFAULT_DMH_DATATYPE);
		this.setDMH_MANDATORY_YN(PM_IL_DOC_MED_HIST_CONSTANTS.DEFAULT_DMH_MANDATORY_YN);
	}
	
	/* Added for grid */
	private boolean rendered;
	
	private boolean CHECK_BOX;
	
	public String getDMH_DS_TYPE() {
		return DMH_DS_TYPE;
	}

	public void setDMH_DS_TYPE(String dmh_ds_type) {
		DMH_DS_TYPE = dmh_ds_type;
	}

	public String getDMH_DS_CODE() {
		return DMH_DS_CODE;
	}

	public void setDMH_DS_CODE(String dmh_ds_code) {
		DMH_DS_CODE = dmh_ds_code;
	}

	

	public int getDMH_SR_NO() {
		return DMH_SR_NO;
	}

	public void setDMH_SR_NO(int dmh_sr_no) {
		DMH_SR_NO = dmh_sr_no;
	}

	public String getDMH_CAPTION() {
		return DMH_CAPTION;
	}

	public void setDMH_CAPTION(String dmh_caption) {
		DMH_CAPTION = dmh_caption;
	}

	public String getDMH_BL_CAPTION() {
		return DMH_BL_CAPTION;
	}

	public void setDMH_BL_CAPTION(String dmh_bl_caption) {
		DMH_BL_CAPTION = dmh_bl_caption;
	}

	public String getDMH_DATA_TYPE() {
		return DMH_DATA_TYPE;
	}

	public void setDMH_DATA_TYPE(String dmh_data_type) {
		DMH_DATA_TYPE = dmh_data_type;
	}

	public String getDMH_MANDATORY_YN() {
		return DMH_MANDATORY_YN;
	}

	public void setDMH_MANDATORY_YN(String dmh_mandatory_yn) {
		DMH_MANDATORY_YN = dmh_mandatory_yn;
	}

	public Date getDMH_EFF_FM_DT() {
		return DMH_EFF_FM_DT;
	}

	public void setDMH_EFF_FM_DT(Date dmh_eff_fm_dt) {
		DMH_EFF_FM_DT = dmh_eff_fm_dt;
	}

	public Date getDMH_EFF_TO_DT() {
		return DMH_EFF_TO_DT;
	}

	public void setDMH_EFF_TO_DT(Date dmh_eff_to_dt) {
		DMH_EFF_TO_DT = dmh_eff_to_dt;
	}

	public Date getDMH_CR_DT() {
		return DMH_CR_DT;
	}

	public void setDMH_CR_DT(Date dmh_cr_dt) {
		DMH_CR_DT = dmh_cr_dt;
	}

	public String getDMH_CR_UID() {
		return DMH_CR_UID;
	}

	public void setDMH_CR_UID(String dmh_cr_uid) {
		DMH_CR_UID = dmh_cr_uid;
	}

	public Date getDMH_UPD_DT() {
		return DMH_UPD_DT;
	}

	public void setDMH_UPD_DT(Date dmh_upd_dt) {
		DMH_UPD_DT = dmh_upd_dt;
	}

	public String getDMH_UPD_UID() {
		return DMH_UPD_UID;
	}

	public void setDMH_UPD_UID(String dmh_upd_uid) {
		DMH_UPD_UID = dmh_upd_uid;
	}

	public String getDMH_APPL_ON() {
		return DMH_APPL_ON;
	}

	public void setDMH_APPL_ON(String dmh_appl_on) {
		DMH_APPL_ON = dmh_appl_on;
	}

	
	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}



	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String toString() {
		return " ds type <" + this.getDMH_DS_TYPE() + "> ds code <"
				+ this.getDMH_DS_CODE() + "Srno<" + this.getDMH_SR_NO()
				+ "> caption<" + this.getDMH_CAPTION() + "> datatype <"
				+ this.getDMH_DATA_TYPE() + "> mandatory <"
				+ this.getDMH_MANDATORY_YN() + ">";
	}
}
