package com.iii.pel.forms.PILM039;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_APPR_SETUP_DET")
public class PM_IL_APPR_SETUP_DET1 extends BaseValueBean{

	@Column(name = "ASD_CODE")
	private String ASD_CODE;

	private String UI_M_ASD_CODE_DESC;

	@Column(name = "ASD_NUM_VALUE")
	private Double ASD_NUM_VALUE;
	@Id
	@Column(name = "ROWID")
	private String ROWID;

	private boolean CHECK_BOX;

	@Column(name = "ASD_USER_ID")
	private String ASD_USER_ID;

	@Column(name = "ASD_CHAR_VALUE")
	private String ASD_CHAR_VALUE;

	@Column(name = "ASD_FLAG")
	private String ASD_FLAG;

	@Column(name = "ASD_CR_DT")
	private Date ASD_CR_DT;

	@Column(name = "ASD_CR_UID")
	private String ASD_CR_UID;

	@Column(name = "ASD_UPD_DT")
	private Date ASD_UPD_DT;

	@Column(name = "ASD_FM_PROD_CODE")
	private String ASD_FM_PROD_CODE;

	@Column(name = "ASD_TO_PROD_CODE")
	private String ASD_TO_PROD_CODE;
	
	@Column(name="ASD_UPD_UID")
	private String ASD_UPD_UID;
// PREMIAGDC-0130 Added for new field , Added by: Shankar Bodduluri, Dated: 13-Mar-2009 -->
	@Column(name="ASD_APPR_GRP")
	private String ASD_APPR_GRP="ALL";
	
	public String getASD_APPR_GRP() {
		return ASD_APPR_GRP;
	}

	public void setASD_APPR_GRP(String asd_appr_grp) {
		ASD_APPR_GRP = asd_appr_grp;
	}

	public String getASD_CODE() {
		return ASD_CODE;
	}

	public void setASD_CODE(String ASD_CODE) {
		this.ASD_CODE = ASD_CODE;
	}

	public String getUI_M_ASD_CODE_DESC() {
		return UI_M_ASD_CODE_DESC;
	}

	public void setUI_M_ASD_CODE_DESC(String UI_M_ASD_CODE_DESC) {
		this.UI_M_ASD_CODE_DESC = UI_M_ASD_CODE_DESC;
	}

	/**
	 * @return the rOWID
	 */
	public String getROWID() {
		return ROWID;
	}

	/**
	 * @param rowid
	 *            the rOWID to set
	 */
	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getASD_USER_ID() {
		return ASD_USER_ID;
	}

	public void setASD_USER_ID(String asd_user_id) {
		ASD_USER_ID = asd_user_id;
	}

	public String getASD_FLAG() {
		return ASD_FLAG;
	}

	public void setASD_FLAG(String asd_flag) {
		ASD_FLAG = asd_flag;
	}

	public String getASD_CR_UID() {
		return ASD_CR_UID;
	}

	public void setASD_CR_UID(String asd_cr_uid) {
		ASD_CR_UID = asd_cr_uid;
	}


	public String getASD_FM_PROD_CODE() {
		return ASD_FM_PROD_CODE;
	}

	public void setASD_FM_PROD_CODE(String asd_fm_prod_code) {
		ASD_FM_PROD_CODE = asd_fm_prod_code;
	}

	public String getASD_TO_PROD_CODE() {
		return ASD_TO_PROD_CODE;
	}

	public void setASD_TO_PROD_CODE(String asd_to_prod_code) {
		ASD_TO_PROD_CODE = asd_to_prod_code;
	}

	public Date getASD_CR_DT() {
		return ASD_CR_DT;
	}

	public void setASD_CR_DT(Date asd_cr_dt) {
		ASD_CR_DT = asd_cr_dt;
	}

	public String getASD_UPD_UID() {
		return ASD_UPD_UID;
	}

	public void setASD_UPD_UID(String asd_upd_uid) {
		ASD_UPD_UID = asd_upd_uid;
	}

	public Date getASD_UPD_DT() {
		return ASD_UPD_DT;
	}

	public void setASD_UPD_DT(Date asd_upd_dt) {
		ASD_UPD_DT = asd_upd_dt;
	}

	public Double getASD_NUM_VALUE() {
		return ASD_NUM_VALUE;
	}

	public void setASD_NUM_VALUE(Double asd_num_value) {
		ASD_NUM_VALUE = asd_num_value;
	}

	public String getASD_CHAR_VALUE() {
		return ASD_CHAR_VALUE;
	}

	public void setASD_CHAR_VALUE(String asd_char_value) {
		ASD_CHAR_VALUE = asd_char_value;
	}

}
