package com.iii.pel.forms.PT044_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_AGENT_TRAN_HDR")
public class PT_AGENT_TRAN_HDR extends BaseValueBean {

	private static final long serialVersionUID = 1L;

	@Column(name = "ATH_AGENT_CODE")
	private String ATH_AGENT_CODE;

	@Column(name = "ATH_PARENT_CODE")
	private String ATH_PARENT_CODE;

	private String UI_M_ATH_PARENT_NAME;

	@Column(name = "ATH_DATE")
	private Date ATH_DATE;

	@Column(name = "ATH_EFF_FM_DT")
	private Date ATH_EFF_FM_DT;

	@Column(name = "ATH_TERMINATION_TYPE")
	private String ATH_TERMINATION_TYPE;

	private String UI_M_ATH_TERMINATION_DESC;

	@Column(name = "ATH_AGENT_NEW_RANK_CODE")
	private String ATH_AGENT_NEW_RANK_CODE;

	@Column(name = "ATH_REVIEW1_DT")
	private Date ATH_REVIEW1_DT;

	@Column(name = "ATH_REVIEW2_DT")
	private Date ATH_REVIEW2_DT;

	@Column(name = "ATH_REVIEW3_DT")
	private Date ATH_REVIEW3_DT;

	@Column(name = "ATH_REVIEW4_DT")
	private Date ATH_REVIEW4_DT;

	@Column(name = "ATH_NEW_AGENT_CODE")
	private String ATH_NEW_AGENT_CODE;

	private String UI_M_ATH_NEW_AGENT_NAME;

	@Column(name = "ATH_PRODN_TRANSFER_YN")
	private String ATH_PRODN_TRANSFER_YN;

	@Column(name = "ATH_SYS_ID")
	private int ATH_SYS_ID;

	@Column(name = "ATH_AGENT_RANK_CODE")
	private String ATH_AGENT_RANK_CODE;

	@Column(name = "ATH_APPRV_FLAG")
	private String ATH_APPRV_FLAG;

	@Column(name = "ATH_TYPE")
	private String ATH_TYPE;

	@Column(name = "ATH_CR_DT")
	private Date ATH_CR_DT;

	@Column(name = "ATH_CR_UID")
	private String ATH_CR_UID;

	@Column(name = "ATH_UPD_DT")
	private Date ATH_UPD_DT;

	@Column(name = "ATH_UPD_UID")
	private String ATH_UPD_UID;

	@Column(name = "ATH_POL_SYS_ID")
	private int ATH_POL_SYS_ID;

	@Column(name = "ATH_FLEX_01")
	private String ATH_FLEX_01;

	@Column(name = "ATH_FLEX_02")
	private String ATH_FLEX_02;

	@Column(name = "ATH_FLEX_03")
	private String ATH_FLEX_03;

	@Column(name = "ATH_FLEX_04")
	private String ATH_FLEX_04;

	@Column(name = "ATH_FLEX_05")
	private String ATH_FLEX_05;
	
	private String UI_M_ATH_AGENT_NAME;
	private String UI_M_AGENT_NEW_RANK_DESC;
	
	private String UI_M_APPRV_STATUS; 
	
	/*Added bY jAGADEESH*/
	
	private String AM_INC_CONT_BNF1; 
	@Override
	public String toString() {
		return "PT_AGENT_TRAN_HDR [ATH_AGENT_CODE=" + ATH_AGENT_CODE
				+ ", ATH_PARENT_CODE=" + ATH_PARENT_CODE
				+ ", UI_M_ATH_PARENT_NAME=" + UI_M_ATH_PARENT_NAME
				+ ", ATH_DATE=" + ATH_DATE + ", ATH_EFF_FM_DT=" + ATH_EFF_FM_DT
				+ ", ATH_TERMINATION_TYPE=" + ATH_TERMINATION_TYPE
				+ ", UI_M_ATH_TERMINATION_DESC=" + UI_M_ATH_TERMINATION_DESC
				+ ", ATH_AGENT_NEW_RANK_CODE=" + ATH_AGENT_NEW_RANK_CODE
				+ ", ATH_REVIEW1_DT=" + ATH_REVIEW1_DT + ", ATH_REVIEW2_DT="
				+ ATH_REVIEW2_DT + ", ATH_REVIEW3_DT=" + ATH_REVIEW3_DT
				+ ", ATH_REVIEW4_DT=" + ATH_REVIEW4_DT
				+ ", ATH_NEW_AGENT_CODE=" + ATH_NEW_AGENT_CODE
				+ ", UI_M_ATH_NEW_AGENT_NAME=" + UI_M_ATH_NEW_AGENT_NAME
				+ ", ATH_PRODN_TRANSFER_YN=" + ATH_PRODN_TRANSFER_YN
				+ ", ATH_SYS_ID=" + ATH_SYS_ID + ", ATH_AGENT_RANK_CODE="
				+ ATH_AGENT_RANK_CODE + ", ATH_APPRV_FLAG=" + ATH_APPRV_FLAG
				+ ", ATH_TYPE=" + ATH_TYPE + ", ATH_CR_DT=" + ATH_CR_DT
				+ ", ATH_CR_UID=" + ATH_CR_UID + ", ATH_UPD_DT=" + ATH_UPD_DT
				+ ", ATH_UPD_UID=" + ATH_UPD_UID + ", ATH_POL_SYS_ID="
				+ ATH_POL_SYS_ID + ", ATH_FLEX_01=" + ATH_FLEX_01
				+ ", ATH_FLEX_02=" + ATH_FLEX_02 + ", ATH_FLEX_03="
				+ ATH_FLEX_03 + ", ATH_FLEX_04=" + ATH_FLEX_04
				+ ", ATH_FLEX_05=" + ATH_FLEX_05 + ", UI_M_ATH_AGENT_NAME="
				+ UI_M_ATH_AGENT_NAME + ", UI_M_AGENT_NEW_RANK_DESC="
				+ UI_M_AGENT_NEW_RANK_DESC + ", UI_M_APPRV_STATUS="
				+ UI_M_APPRV_STATUS + ", AM_INC_CONT_BNF1=" + AM_INC_CONT_BNF1
				+ ", AM_INC_CONT_BNF2=" + AM_INC_CONT_BNF2
				+ ", AM_INC_CONT_BNF3=" + AM_INC_CONT_BNF3
				+ ", AM_INC_CONT_BNF4=" + AM_INC_CONT_BNF4
				+ ", AM_INC_CONT_BNF5=" + AM_INC_CONT_BNF5
				+ ", AM_INC_CONT_BNF6=" + AM_INC_CONT_BNF6
				+ ", AM_INC_CONT_BNF7=" + AM_INC_CONT_BNF7
				+ ", AM_INC_BNF_EXISTS=" + AM_INC_BNF_EXISTS + ", PC_VALUE="
				+ PC_VALUE + ", getAM_INC_CONT_BNF1()=" + getAM_INC_CONT_BNF1()
				+ ", getAM_INC_CONT_BNF2()=" + getAM_INC_CONT_BNF2()
				+ ", getAM_INC_CONT_BNF3()=" + getAM_INC_CONT_BNF3()
				+ ", getAM_INC_CONT_BNF4()=" + getAM_INC_CONT_BNF4()
				+ ", getAM_INC_CONT_BNF5()=" + getAM_INC_CONT_BNF5()
				+ ", getAM_INC_CONT_BNF6()=" + getAM_INC_CONT_BNF6()
				+ ", getAM_INC_CONT_BNF7()=" + getAM_INC_CONT_BNF7()
				+ ", getAM_INC_BNF_EXISTS()=" + getAM_INC_BNF_EXISTS()
				+ ", getPC_VALUE()=" + getPC_VALUE() + ", getATH_AGENT_CODE()="
				+ getATH_AGENT_CODE() + ", getUI_M_ATH_AGENT_NAME()="
				+ getUI_M_ATH_AGENT_NAME() + ", getATH_PARENT_CODE()="
				+ getATH_PARENT_CODE() + ", getUI_M_ATH_PARENT_NAME()="
				+ getUI_M_ATH_PARENT_NAME() + ", getATH_DATE()="
				+ getATH_DATE() + ", getATH_EFF_FM_DT()=" + getATH_EFF_FM_DT()
				+ ", getATH_TERMINATION_TYPE()=" + getATH_TERMINATION_TYPE()
				+ ", getUI_M_ATH_TERMINATION_DESC()="
				+ getUI_M_ATH_TERMINATION_DESC()
				+ ", getATH_AGENT_NEW_RANK_CODE()="
				+ getATH_AGENT_NEW_RANK_CODE()
				+ ", getUI_M_AGENT_NEW_RANK_DESC()="
				+ getUI_M_AGENT_NEW_RANK_DESC() + ", getATH_REVIEW1_DT()="
				+ getATH_REVIEW1_DT() + ", getATH_REVIEW2_DT()="
				+ getATH_REVIEW2_DT() + ", getATH_REVIEW3_DT()="
				+ getATH_REVIEW3_DT() + ", getATH_REVIEW4_DT()="
				+ getATH_REVIEW4_DT() + ", getATH_NEW_AGENT_CODE()="
				+ getATH_NEW_AGENT_CODE() + ", getUI_M_ATH_NEW_AGENT_NAME()="
				+ getUI_M_ATH_NEW_AGENT_NAME()
				+ ", getATH_PRODN_TRANSFER_YN()=" + getATH_PRODN_TRANSFER_YN()
				+ ", getATH_SYS_ID()=" + getATH_SYS_ID()
				+ ", getATH_AGENT_RANK_CODE()=" + getATH_AGENT_RANK_CODE()
				+ ", getATH_APPRV_FLAG()=" + getATH_APPRV_FLAG()
				+ ", getATH_TYPE()=" + getATH_TYPE() + ", getATH_CR_DT()="
				+ getATH_CR_DT() + ", getATH_CR_UID()=" + getATH_CR_UID()
				+ ", getATH_UPD_DT()=" + getATH_UPD_DT()
				+ ", getATH_UPD_UID()=" + getATH_UPD_UID()
				+ ", getATH_POL_SYS_ID()=" + getATH_POL_SYS_ID()
				+ ", getATH_FLEX_01()=" + getATH_FLEX_01()
				+ ", getATH_FLEX_02()=" + getATH_FLEX_02()
				+ ", getATH_FLEX_03()=" + getATH_FLEX_03()
				+ ", getATH_FLEX_04()=" + getATH_FLEX_04()
				+ ", getATH_FLEX_05()=" + getATH_FLEX_05()
				+ ", getUI_M_APPRV_STATUS()=" + getUI_M_APPRV_STATUS()
				+ ", getOLD_UPD_DT()=" + getOLD_UPD_DT() + ", getUSER_ID()="
				+ getUSER_ID() + ", getRowSelected()=" + getRowSelected()
				+ ", getROWID()=" + getROWID() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private String AM_INC_CONT_BNF2; 
	private String AM_INC_CONT_BNF3; 
	private String AM_INC_CONT_BNF4; 
	private String AM_INC_CONT_BNF5; 
	private String AM_INC_CONT_BNF6; 
	private String AM_INC_CONT_BNF7; 
	
	private String AM_INC_BNF_EXISTS;
	
	private double PC_VALUE; 
	
	
	public String getAM_INC_CONT_BNF1() {
		return AM_INC_CONT_BNF1;
	}

	public void setAM_INC_CONT_BNF1(String aM_INC_CONT_BNF1) {
		AM_INC_CONT_BNF1 = aM_INC_CONT_BNF1;
	}

	public String getAM_INC_CONT_BNF2() {
		return AM_INC_CONT_BNF2;
	}

	public void setAM_INC_CONT_BNF2(String aM_INC_CONT_BNF2) {
		AM_INC_CONT_BNF2 = aM_INC_CONT_BNF2;
	}

	public String getAM_INC_CONT_BNF3() {
		return AM_INC_CONT_BNF3;
	}

	public void setAM_INC_CONT_BNF3(String aM_INC_CONT_BNF3) {
		AM_INC_CONT_BNF3 = aM_INC_CONT_BNF3;
	}

	public String getAM_INC_CONT_BNF4() {
		return AM_INC_CONT_BNF4;
	}

	public void setAM_INC_CONT_BNF4(String aM_INC_CONT_BNF4) {
		AM_INC_CONT_BNF4 = aM_INC_CONT_BNF4;
	}

	public String getAM_INC_CONT_BNF5() {
		return AM_INC_CONT_BNF5;
	}

	public void setAM_INC_CONT_BNF5(String aM_INC_CONT_BNF5) {
		AM_INC_CONT_BNF5 = aM_INC_CONT_BNF5;
	}

	public String getAM_INC_CONT_BNF6() {
		return AM_INC_CONT_BNF6;
	}

	public void setAM_INC_CONT_BNF6(String aM_INC_CONT_BNF6) {
		AM_INC_CONT_BNF6 = aM_INC_CONT_BNF6;
	}

	public String getAM_INC_CONT_BNF7() {
		return AM_INC_CONT_BNF7;
	}

	public void setAM_INC_CONT_BNF7(String aM_INC_CONT_BNF7) {
		AM_INC_CONT_BNF7 = aM_INC_CONT_BNF7;
	}

	public String getAM_INC_BNF_EXISTS() {
		return AM_INC_BNF_EXISTS;
	}

	public void setAM_INC_BNF_EXISTS(String aM_INC_BNF_EXISTS) {
		AM_INC_BNF_EXISTS = aM_INC_BNF_EXISTS;
	}

	public double getPC_VALUE() {
		return PC_VALUE;
	}

	public void setPC_VALUE(double pC_VALUE) {
		PC_VALUE = pC_VALUE;
	}
	
	
	/*End*/

	

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

	public String getATH_PARENT_CODE() {
		return ATH_PARENT_CODE;
	}

	public void setATH_PARENT_CODE(String ATH_PARENT_CODE) {
		this.ATH_PARENT_CODE = ATH_PARENT_CODE;
	}

	public String getUI_M_ATH_PARENT_NAME() {
		return UI_M_ATH_PARENT_NAME;
	}

	public void setUI_M_ATH_PARENT_NAME(String UI_M_ATH_PARENT_NAME) {
		this.UI_M_ATH_PARENT_NAME = UI_M_ATH_PARENT_NAME;
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

	public String getATH_TERMINATION_TYPE() {
		return ATH_TERMINATION_TYPE;
	}

	public void setATH_TERMINATION_TYPE(String ATH_TERMINATION_TYPE) {
		this.ATH_TERMINATION_TYPE = ATH_TERMINATION_TYPE;
	}

	public String getUI_M_ATH_TERMINATION_DESC() {
		return UI_M_ATH_TERMINATION_DESC;
	}

	public void setUI_M_ATH_TERMINATION_DESC(String UI_M_ATH_TERMINATION_DESC) {
		this.UI_M_ATH_TERMINATION_DESC = UI_M_ATH_TERMINATION_DESC;
	}

	public String getATH_AGENT_NEW_RANK_CODE() {
		return ATH_AGENT_NEW_RANK_CODE;
	}

	public void setATH_AGENT_NEW_RANK_CODE(String ATH_AGENT_NEW_RANK_CODE) {
		this.ATH_AGENT_NEW_RANK_CODE = ATH_AGENT_NEW_RANK_CODE;
	}

	public String getUI_M_AGENT_NEW_RANK_DESC() {
		return UI_M_AGENT_NEW_RANK_DESC;
	}

	public void setUI_M_AGENT_NEW_RANK_DESC(String UI_M_AGENT_NEW_RANK_DESC) {
		this.UI_M_AGENT_NEW_RANK_DESC = UI_M_AGENT_NEW_RANK_DESC;
	}

	public Date getATH_REVIEW1_DT() {
		return ATH_REVIEW1_DT;
	}

	public void setATH_REVIEW1_DT(Date ATH_REVIEW1_DT) {
		this.ATH_REVIEW1_DT = ATH_REVIEW1_DT;
	}

	public Date getATH_REVIEW2_DT() {
		return ATH_REVIEW2_DT;
	}

	public void setATH_REVIEW2_DT(Date ATH_REVIEW2_DT) {
		this.ATH_REVIEW2_DT = ATH_REVIEW2_DT;
	}

	public Date getATH_REVIEW3_DT() {
		return ATH_REVIEW3_DT;
	}

	public void setATH_REVIEW3_DT(Date ATH_REVIEW3_DT) {
		this.ATH_REVIEW3_DT = ATH_REVIEW3_DT;
	}

	public Date getATH_REVIEW4_DT() {
		return ATH_REVIEW4_DT;
	}

	public void setATH_REVIEW4_DT(Date ATH_REVIEW4_DT) {
		this.ATH_REVIEW4_DT = ATH_REVIEW4_DT;
	}

	public String getATH_NEW_AGENT_CODE() {
		return ATH_NEW_AGENT_CODE;
	}

	public void setATH_NEW_AGENT_CODE(String ATH_NEW_AGENT_CODE) {
		this.ATH_NEW_AGENT_CODE = ATH_NEW_AGENT_CODE;
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

	public int getATH_SYS_ID() {
		return ATH_SYS_ID;
	}

	public void setATH_SYS_ID(int ath_sys_id) {
		ATH_SYS_ID = ath_sys_id;
	}

	public String getATH_AGENT_RANK_CODE() {
		return ATH_AGENT_RANK_CODE;
	}

	public void setATH_AGENT_RANK_CODE(String ath_agent_rank_code) {
		ATH_AGENT_RANK_CODE = ath_agent_rank_code;
	}

	public String getATH_APPRV_FLAG() {
		return ATH_APPRV_FLAG;
	}

	public void setATH_APPRV_FLAG(String ath_apprv_flag) {
		ATH_APPRV_FLAG = ath_apprv_flag;
	}

	public String getATH_TYPE() {
		return ATH_TYPE;
	}

	public void setATH_TYPE(String ath_type) {
		ATH_TYPE = ath_type;
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

	public Date getATH_UPD_DT() {
		return ATH_UPD_DT;
	}

	public void setATH_UPD_DT(Date ath_upd_dt) {
		ATH_UPD_DT = ath_upd_dt;
	}

	public String getATH_UPD_UID() {
		return ATH_UPD_UID;
	}

	public void setATH_UPD_UID(String ath_upd_uid) {
		ATH_UPD_UID = ath_upd_uid;
	}

	public int getATH_POL_SYS_ID() {
		return ATH_POL_SYS_ID;
	}

	public void setATH_POL_SYS_ID(int ath_pol_sys_id) {
		ATH_POL_SYS_ID = ath_pol_sys_id;
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

	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}
	
	
	/*added by raja on 08-02-2017 for ssp id - ZBILQC-1719676 */
	
	@Column(name = "ATH_AGENT_NEW_CLASS_CODE")
	private String ATH_AGENT_NEW_CLASS_CODE;
	
	private String ATH_AGENT_NEW_CLASS_CODE_DESC;
	public String getATH_AGENT_NEW_CLASS_CODE() {
		return ATH_AGENT_NEW_CLASS_CODE;
	}

	public void setATH_AGENT_NEW_CLASS_CODE(String aTH_AGENT_NEW_CLASS_CODE) {
		ATH_AGENT_NEW_CLASS_CODE = aTH_AGENT_NEW_CLASS_CODE;
	}

	public String getATH_AGENT_NEW_CLASS_CODE_DESC() {
		return ATH_AGENT_NEW_CLASS_CODE_DESC;
	}

	public void setATH_AGENT_NEW_CLASS_CODE_DESC(
			String aTH_AGENT_NEW_CLASS_CODE_DESC) {
		ATH_AGENT_NEW_CLASS_CODE_DESC = aTH_AGENT_NEW_CLASS_CODE_DESC;
	}
	
	/*end*/
	
}
