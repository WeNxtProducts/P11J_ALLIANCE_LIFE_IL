package com.iii.pel.forms.PT099_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_TRAN_HDR")
public class PT_AGENT_TRAN_HDR extends BaseValueBean {

	private String UI_M_ATH_POL_NO;
	
	@Column(name="ATH_POL_SYS_ID")
	private double ATH_POL_SYS_ID;
	
	private boolean selected;
		
	@Column(name="ATH_AGENT_RANK_CODE")
	private String ATH_AGENT_RANK_CODE;		
	
	@Column(name="ATH_SYS_ID")
	private Double ATH_SYS_ID;

	@Column(name="ATH_CR_DT")
	private Date ATH_CR_DT ;
	
	@Column(name="ATH_UPD_UID")
	private String ATH_UPD_UID;
	
	@Column(name="ATH_UPD_DT")
	private Date ATH_UPD_DT ;
	
	@Column(name="ATH_CR_UID")
	private String ATH_CR_UID;
	
	@Column(name="ATH_AGENT_CODE")
	private String ATH_AGENT_CODE;

	private String UI_M_ATH_AGENT_NAME;

	@Column(name="ATH_DATE")
	private Date ATH_DATE;

	@Column(name="ATH_EFF_FM_DT")
	private Date ATH_EFF_FM_DT;

	@Column(name="ATH_NEW_AGENT_CODE")
	private String ATH_NEW_AGENT_CODE;
	
	@Column(name="ATH_AGENT_NEW_RANK_CODE")
	private String ATH_AGENT_NEW_RANK_CODE;

	@Column(name="ATH_TYPE")
	private String ATH_TYPE;

	private String ATH_N_AGENT_DESC;
	
	private String UI_M_ATH_NEW_AGENT_NAME;

	@Column(name="ATH_PRODN_TRANSFER_YN")
	private String ATH_PRODN_TRANSFER_YN;

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 1
	@Column(name="ATH_APPRV_FLAG")
	private String ATH_APPRV_FLAG;
	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 1 ]
	
	@Column(name="ATH_PARENT_CODE")
	private String ATH_PARENT_CODE;
	@Column(name="ATH_TERMINATION_TYPE")
	private String ATH_TERMINATION_TYPE;
	@Column(name="ATH_REVIEW1_DT")
	private Date ATH_REVIEW1_DT;
	@Column(name="ATH_REVIEW2_DT")
	private Date ATH_REVIEW2_DT;
	@Column(name="ATH_REVIEW3_DT")
	private Date ATH_REVIEW3_DT;
	@Column(name="ATH_REVIEW4_DT")
	private Date ATH_REVIEW4_DT;
	@Column(name="ATH_FLEX_01")
	private String ATH_FLEX_01;
	@Column(name="ATH_FLEX_02")
	private String ATH_FLEX_02;
	@Column(name="ATH_FLEX_03")
	private String ATH_FLEX_03;
	@Column(name="ATH_FLEX_04")
	private String ATH_FLEX_04;
	@Column(name="ATH_FLEX_05")
	private String ATH_FLEX_05;

	private String LOV_POLY_CODE;
	private String LOV_AGENT_CODE;
	private String LOV_AGENT_DESC;
	
	public PT_AGENT_TRAN_HDR(){
		ATH_PRODN_TRANSFER_YN = "N";
	}
	
	
	public String getLOV_AGENT_DESC() {
		return LOV_AGENT_DESC;
	}

	public void setLOV_AGENT_DESC(String lov_agent_desc) {
		LOV_AGENT_DESC = lov_agent_desc;
	}

	public String getLOV_AGENT_CODE() {
		return LOV_AGENT_CODE;
	}

	public void setLOV_AGENT_CODE(String lov_agent_code) {
		LOV_AGENT_CODE = lov_agent_code;
	}

	public String getUI_M_ATH_POL_NO() {
		return UI_M_ATH_POL_NO;
	}

	public void setUI_M_ATH_POL_NO(String UI_M_ATH_POL_NO) {
		this.UI_M_ATH_POL_NO = UI_M_ATH_POL_NO;
	}

	public String getATH_AGENT_CODE() {
		return ATH_AGENT_CODE;
	}

	public void setATH_AGENT_CODE(String ATH_AGENT_CODE) {
		this.ATH_AGENT_CODE = ATH_AGENT_CODE;
	}

	public String getUI_M_ATH_AGENT_NAME() {
		return UI_M_ATH_AGENT_NAME;
	}

	public void setUI_M_ATH_AGENT_NAME(String UI_M_ATH_AGENT_NAME) {
		this.UI_M_ATH_AGENT_NAME = UI_M_ATH_AGENT_NAME;
	}

	public Date getATH_DATE() {
		 return ATH_DATE;
	}

	public void setATH_DATE(Date ATH_DATE) {
		this.ATH_DATE = ATH_DATE;
	}

	public Date getATH_EFF_FM_DT() {
		 return ATH_EFF_FM_DT;
	}

	public void setATH_EFF_FM_DT(Date ATH_EFF_FM_DT) {
		this.ATH_EFF_FM_DT = ATH_EFF_FM_DT;
	}

	public String getATH_NEW_AGENT_CODE() {
		return ATH_NEW_AGENT_CODE;
	}

	public void setATH_NEW_AGENT_CODE(String ATH_N_AGENT) {
		this.ATH_NEW_AGENT_CODE = ATH_N_AGENT;
	}

	public String getUI_M_ATH_NEW_AGENT_NAME() {
		return UI_M_ATH_NEW_AGENT_NAME;
	}

	public void setUI_M_ATH_NEW_AGENT_NAME(String UI_M_ATH_NEW_AGENT_NAME) {
		this.UI_M_ATH_NEW_AGENT_NAME = UI_M_ATH_NEW_AGENT_NAME;
	}

	public String getATH_PRODN_TRANSFER_YN() {
		return ATH_PRODN_TRANSFER_YN;
	}

	public void setATH_PRODN_TRANSFER_YN(String ATH_PRODN_TRANSFER_YN) {
		this.ATH_PRODN_TRANSFER_YN = ATH_PRODN_TRANSFER_YN;
	}

	/*public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}*/

	public Double getATH_SYS_ID() {
		return ATH_SYS_ID;
	}

	public void setATH_SYS_ID(Double tath_sys_idh_sys_id) {
		ATH_SYS_ID = tath_sys_idh_sys_id;
	}

	public Date getATH_CR_DT() {
		return ATH_CR_DT;
	}

	public void setATH_CR_DT(Date ath_cr_dt) {
		ATH_CR_DT = ath_cr_dt;
	}

	public String getATH_CR_UID() {
		return ATH_CR_UID;
	}

	public void setATH_CR_UID(String ath_cr_uid) {
		ATH_CR_UID = ath_cr_uid;
	}

	public String getLOV_POLY_CODE() {
		return LOV_POLY_CODE;
	}

	public void setLOV_POLY_CODE(String lov_poly_code) {
		LOV_POLY_CODE = lov_poly_code;
	}

	public String getATH_N_AGENT_DESC() {
		return ATH_N_AGENT_DESC;
	}

	public void setATH_N_AGENT_DESC(String ath_n_agent_desc) {
		ATH_N_AGENT_DESC = ath_n_agent_desc;
	}

	public double getATH_POL_SYS_ID() {
		return ATH_POL_SYS_ID;
	}

	public void setATH_POL_SYS_ID(double ath_pol_sys_id) {
		ATH_POL_SYS_ID = ath_pol_sys_id;
	}

	public String getATH_TYPE() {
		return ATH_TYPE;
	}

	public void setATH_TYPE(String ath_type) {
		ATH_TYPE = ath_type;
	}

	public String getATH_UPD_UID() {
		return ATH_UPD_UID;
	}

	public void setATH_UPD_UID(String ath_upd_uid) {
		ATH_UPD_UID = ath_upd_uid;
	}

	public Date getATH_UPD_DT() {
		return ATH_UPD_DT;
	}

	public void setATH_UPD_DT(Date ath_upd_dt) {
		ATH_UPD_DT = ath_upd_dt;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getATH_AGENT_RANK_CODE() {
		return ATH_AGENT_RANK_CODE;
	}

	public void setATH_AGENT_RANK_CODE(String ath_agent_rank_code) {
		ATH_AGENT_RANK_CODE = ath_agent_rank_code;
	}

	public String getATH_AGENT_NEW_RANK_CODE() {
		return ATH_AGENT_NEW_RANK_CODE;
	}

	public void setATH_AGENT_NEW_RANK_CODE(String ath_agent_new_rank_code) {
		ATH_AGENT_NEW_RANK_CODE = ath_agent_new_rank_code;
	}

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 2
	public String getATH_APPRV_FLAG() {
		return ATH_APPRV_FLAG;
	}


	public void setATH_APPRV_FLAG(String ath_apprv_flag) {
		ATH_APPRV_FLAG = ath_apprv_flag;
	}
	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 2 ]


	public String getATH_PARENT_CODE() {
		return ATH_PARENT_CODE;
	}


	public void setATH_PARENT_CODE(String ath_parent_code) {
		ATH_PARENT_CODE = ath_parent_code;
	}


	public String getATH_TERMINATION_TYPE() {
		return ATH_TERMINATION_TYPE;
	}


	public void setATH_TERMINATION_TYPE(String ath_termination_type) {
		ATH_TERMINATION_TYPE = ath_termination_type;
	}


	public Date getATH_REVIEW1_DT() {
		return ATH_REVIEW1_DT;
	}


	public void setATH_REVIEW1_DT(Date ath_review1_dt) {
		ATH_REVIEW1_DT = ath_review1_dt;
	}


	public Date getATH_REVIEW2_DT() {
		return ATH_REVIEW2_DT;
	}


	public void setATH_REVIEW2_DT(Date ath_review2_dt) {
		ATH_REVIEW2_DT = ath_review2_dt;
	}


	public Date getATH_REVIEW3_DT() {
		return ATH_REVIEW3_DT;
	}


	public void setATH_REVIEW3_DT(Date ath_review3_dt) {
		ATH_REVIEW3_DT = ath_review3_dt;
	}


	public Date getATH_REVIEW4_DT() {
		return ATH_REVIEW4_DT;
	}


	public void setATH_REVIEW4_DT(Date ath_review4_dt) {
		ATH_REVIEW4_DT = ath_review4_dt;
	}


	public String getATH_FLEX_01() {
		return ATH_FLEX_01;
	}


	public void setATH_FLEX_01(String ath_flex_01) {
		ATH_FLEX_01 = ath_flex_01;
	}


	public String getATH_FLEX_02() {
		return ATH_FLEX_02;
	}


	public void setATH_FLEX_02(String ath_flex_02) {
		ATH_FLEX_02 = ath_flex_02;
	}


	public String getATH_FLEX_03() {
		return ATH_FLEX_03;
	}


	public void setATH_FLEX_03(String ath_flex_03) {
		ATH_FLEX_03 = ath_flex_03;
	}


	public String getATH_FLEX_04() {
		return ATH_FLEX_04;
	}


	public void setATH_FLEX_04(String ath_flex_04) {
		ATH_FLEX_04 = ath_flex_04;
	}


	public String getATH_FLEX_05() {
		return ATH_FLEX_05;
	}


	public void setATH_FLEX_05(String ath_flex_05) {
		ATH_FLEX_05 = ath_flex_05;
	}
	

	
}
