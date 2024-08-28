package com.iii.pel.forms.PM105_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CODES_ACCOUNT_SETUP")
public class PM_IL_CODES_ACCOUNT_SETUP extends BaseValueBean {

	@Column(name="CACS_FRZ_FLAG")
	private String CACS_FRZ_FLAG;
	
	//Property will represent checkbox at the front end
	private boolean CACS_FRZ_FLAG_UI;
	
	@Column(name="CACS_SRC_BUS_FM")
	private String CACS_SRC_BUS_FM;

	@Column(name="CACS_SRC_BUS_TO")
	private String CACS_SRC_BUS_TO;

	@Column(name="CACS_BUS_FM_CODE")
	private String CACS_BUS_FM_CODE;

	@Column(name="CACS_BUS_TO_CODE")
	private String CACS_BUS_TO_CODE;

	@Column(name="CACS_DIVN_FM_CODE")
	private String CACS_DIVN_FM_CODE;

	@Column(name="CACS_DIVN_TO_CODE")
	private String CACS_DIVN_TO_CODE;

	@Column(name="CACS_DEPT_FM_CODE")
	private String CACS_DEPT_FM_CODE;

	@Column(name="CACS_DEPT_TO_CODE")
	private String CACS_DEPT_TO_CODE;

	@Column(name="CACS_SETUP_TYPE")
	private String CACS_SETUP_TYPE;

	@Column(name="CACS_FORCE_DIVN_YN")
	private String CACS_FORCE_DIVN_YN;
	
	//Property will represent checkbox at the front end
	private boolean CACS_FORCE_DIVN_YN_UI;
	
	@Column(name="CACS_FORCE_DEPT_YN")
	private String CACS_FORCE_DEPT_YN;

	//Property will represent checkbox at the front end
	private boolean CACS_FORCE_DEPT_YN_UI;
	
	@Column(name="CACS_MAIN_ACNT_CODE")
	private String CACS_MAIN_ACNT_CODE;

	private String UI_M_MAIN_ACNT_NAME;

	@Column(name="CACS_SUB_ACNT_CODE")
	private String CACS_SUB_ACNT_CODE;

	private String UI_M_SUB_ACNT_NAME;

	@Column(name="CACS_DIVN_CODE")
	private String CACS_DIVN_CODE;

	private String UI_M_DIVN_NAME;

	@Column(name="CACS_DEPT_CODE")
	private String CACS_DEPT_CODE;

	private String UI_M_DEPT_NAME;

	@Column(name="CACS_ANLY_CODE_1")
	private String CACS_ANLY_CODE_1;

	private String UI_M_ANLY_NAME;

	@Column(name="CACS_ANLY_CODE_2")
	private String CACS_ANLY_CODE_2;

	private String UI_M_ANLY_NAME_1;

	@Column(name="CACS_ACTY_CODE_1")
	private String CACS_ACTY_CODE_1;

	private String UI_M_ACTY_NAME;

	@Column(name="CACS_ACTY_CODE_2")
	private String CACS_ACTY_CODE_2;

	private String UI_M_ACTY_NAME_1;

	@Column(name="CACS_CR_DT")
	private Date CACS_CR_DT;
	@Column(name="CACS_UPD_DT")
	private Date CACS_UPD_DT;
	@Column(name="CACS_CR_UID")
	private String CACS_CR_UID;
	@Column(name="CACS_UPD_UID")
	private String CACS_UPD_UID;

	public String getCACS_FRZ_FLAG() {
		return CACS_FRZ_FLAG;
	}

	public void setCACS_FRZ_FLAG(String CACS_FRZ_FLAG) {
		this.CACS_FRZ_FLAG = CACS_FRZ_FLAG;
		if(CACS_FRZ_FLAG != null && CACS_FRZ_FLAG.equals("Y")){
			this.CACS_FRZ_FLAG_UI=true;
		}else{
			this.CACS_FRZ_FLAG_UI=false;
		}
		
	}

	public String getCACS_SRC_BUS_FM() {
		return CACS_SRC_BUS_FM;
	}

	public void setCACS_SRC_BUS_FM(String CACS_SRC_BUS_FM) {
		this.CACS_SRC_BUS_FM = CACS_SRC_BUS_FM;
	}

	public String getCACS_SRC_BUS_TO() {
		return CACS_SRC_BUS_TO;
	}

	public void setCACS_SRC_BUS_TO(String CACS_SRC_BUS_TO) {
		this.CACS_SRC_BUS_TO = CACS_SRC_BUS_TO;
	}

	public String getCACS_BUS_FM_CODE() {
		return CACS_BUS_FM_CODE;
	}

	public void setCACS_BUS_FM_CODE(String CACS_BUS_FM_CODE) {
		this.CACS_BUS_FM_CODE = CACS_BUS_FM_CODE;
	}

	public String getCACS_BUS_TO_CODE() {
		return CACS_BUS_TO_CODE;
	}

	public void setCACS_BUS_TO_CODE(String CACS_BUS_TO_CODE) {
		this.CACS_BUS_TO_CODE = CACS_BUS_TO_CODE;
	}

	public String getCACS_DIVN_FM_CODE() {
		return CACS_DIVN_FM_CODE;
	}

	public void setCACS_DIVN_FM_CODE(String CACS_DIVN_FM_CODE) {
		this.CACS_DIVN_FM_CODE = CACS_DIVN_FM_CODE;
	}

	public String getCACS_DIVN_TO_CODE() {
		return CACS_DIVN_TO_CODE;
	}

	public void setCACS_DIVN_TO_CODE(String CACS_DIVN_TO_CODE) {
		this.CACS_DIVN_TO_CODE = CACS_DIVN_TO_CODE;
	}

	public String getCACS_DEPT_FM_CODE() {
		return CACS_DEPT_FM_CODE;
	}

	public void setCACS_DEPT_FM_CODE(String CACS_DEPT_FM_CODE) {
		this.CACS_DEPT_FM_CODE = CACS_DEPT_FM_CODE;
	}

	public String getCACS_DEPT_TO_CODE() {
		return CACS_DEPT_TO_CODE;
	}

	public void setCACS_DEPT_TO_CODE(String CACS_DEPT_TO_CODE) {
		this.CACS_DEPT_TO_CODE = CACS_DEPT_TO_CODE;
	}

	public String getCACS_SETUP_TYPE() {
		return CACS_SETUP_TYPE;
	}

	public void setCACS_SETUP_TYPE(String CACS_SETUP_TYPE) {
		this.CACS_SETUP_TYPE = CACS_SETUP_TYPE;
	}

	public String getCACS_FORCE_DIVN_YN() {
		return CACS_FORCE_DIVN_YN;
	}

	public void setCACS_FORCE_DIVN_YN(String CACS_FORCE_DIVN_YN) {
		this.CACS_FORCE_DIVN_YN = CACS_FORCE_DIVN_YN;
		if(CACS_FORCE_DIVN_YN != null && CACS_FORCE_DIVN_YN.equals("Y")){
			this.CACS_FORCE_DIVN_YN_UI=true;
		}else{
			this.CACS_FORCE_DIVN_YN_UI=false;
		}
	}

	public String getCACS_FORCE_DEPT_YN() {
		return CACS_FORCE_DEPT_YN;
	}

	public void setCACS_FORCE_DEPT_YN(String CACS_FORCE_DEPT_YN) {
		this.CACS_FORCE_DEPT_YN = CACS_FORCE_DEPT_YN;
		if(CACS_FORCE_DEPT_YN != null && CACS_FORCE_DEPT_YN.equals("Y")){
			this.CACS_FORCE_DEPT_YN_UI=true;
		}else{
			this.CACS_FORCE_DEPT_YN_UI=false;
		}
	}

	public String getCACS_MAIN_ACNT_CODE() {
		return CACS_MAIN_ACNT_CODE;
	}

	public void setCACS_MAIN_ACNT_CODE(String CACS_MAIN_ACNT_CODE) {
		this.CACS_MAIN_ACNT_CODE = CACS_MAIN_ACNT_CODE;
	}

	public String getUI_M_MAIN_ACNT_NAME() {
		return UI_M_MAIN_ACNT_NAME;
	}

	public void setUI_M_MAIN_ACNT_NAME(String UI_M_MAIN_ACNT_NAME) {
		this.UI_M_MAIN_ACNT_NAME = UI_M_MAIN_ACNT_NAME;
	}

	public String getCACS_SUB_ACNT_CODE() {
		return CACS_SUB_ACNT_CODE;
	}

	public void setCACS_SUB_ACNT_CODE(String CACS_SUB_ACNT_CODE) {
		this.CACS_SUB_ACNT_CODE = CACS_SUB_ACNT_CODE;
	}

	public String getUI_M_SUB_ACNT_NAME() {
		return UI_M_SUB_ACNT_NAME;
	}

	public void setUI_M_SUB_ACNT_NAME(String UI_M_SUB_ACNT_NAME) {
		this.UI_M_SUB_ACNT_NAME = UI_M_SUB_ACNT_NAME;
	}

	public String getCACS_DIVN_CODE() {
		return CACS_DIVN_CODE;
	}

	public void setCACS_DIVN_CODE(String CACS_DIVN_CODE) {
		this.CACS_DIVN_CODE = CACS_DIVN_CODE;
	}

	public String getUI_M_DIVN_NAME() {
		return UI_M_DIVN_NAME;
	}

	public void setUI_M_DIVN_NAME(String UI_M_DIVN_NAME) {
		this.UI_M_DIVN_NAME = UI_M_DIVN_NAME;
	}

	public String getCACS_DEPT_CODE() {
		return CACS_DEPT_CODE;
	}

	public void setCACS_DEPT_CODE(String CACS_DEPT_CODE) {
		this.CACS_DEPT_CODE = CACS_DEPT_CODE;
	}

	public String getUI_M_DEPT_NAME() {
		return UI_M_DEPT_NAME;
	}

	public void setUI_M_DEPT_NAME(String UI_M_DEPT_NAME) {
		this.UI_M_DEPT_NAME = UI_M_DEPT_NAME;
	}

	public String getCACS_ANLY_CODE_1() {
		return CACS_ANLY_CODE_1;
	}

	public void setCACS_ANLY_CODE_1(String CACS_ANLY_CODE_1) {
		this.CACS_ANLY_CODE_1 = CACS_ANLY_CODE_1;
	}

	public String getUI_M_ANLY_NAME() {
		return UI_M_ANLY_NAME;
	}

	public void setUI_M_ANLY_NAME(String UI_M_ANLY_NAME) {
		this.UI_M_ANLY_NAME = UI_M_ANLY_NAME;
	}

	public String getCACS_ANLY_CODE_2() {
		return CACS_ANLY_CODE_2;
	}

	public void setCACS_ANLY_CODE_2(String CACS_ANLY_CODE_2) {
		this.CACS_ANLY_CODE_2 = CACS_ANLY_CODE_2;
	}

	public String getUI_M_ANLY_NAME_1() {
		return UI_M_ANLY_NAME_1;
	}

	public void setUI_M_ANLY_NAME_1(String UI_M_ANLY_NAME_1) {
		this.UI_M_ANLY_NAME_1 = UI_M_ANLY_NAME_1;
	}

	public String getCACS_ACTY_CODE_1() {
		return CACS_ACTY_CODE_1;
	}

	public void setCACS_ACTY_CODE_1(String CACS_ACTY_CODE_1) {
		this.CACS_ACTY_CODE_1 = CACS_ACTY_CODE_1;
	}

	public String getUI_M_ACTY_NAME() {
		return UI_M_ACTY_NAME;
	}

	public void setUI_M_ACTY_NAME(String UI_M_ACTY_NAME) {
		this.UI_M_ACTY_NAME = UI_M_ACTY_NAME;
	}

	public String getCACS_ACTY_CODE_2() {
		return CACS_ACTY_CODE_2;
	}

	public void setCACS_ACTY_CODE_2(String CACS_ACTY_CODE_2) {
		this.CACS_ACTY_CODE_2 = CACS_ACTY_CODE_2;
	}

	public String getUI_M_ACTY_NAME_1() {
		return UI_M_ACTY_NAME_1;
	}

	public void setUI_M_ACTY_NAME_1(String UI_M_ACTY_NAME_1) {
		this.UI_M_ACTY_NAME_1 = UI_M_ACTY_NAME_1;
	}

	public boolean isCACS_FRZ_FLAG_UI() {
		return CACS_FRZ_FLAG_UI;
	}

	public void setCACS_FRZ_FLAG_UI(boolean cacs_frz_flag_ui) {
		CACS_FRZ_FLAG_UI = cacs_frz_flag_ui;
		if (cacs_frz_flag_ui){
			this.CACS_FRZ_FLAG="Y";
		}else{
			this.CACS_FRZ_FLAG="N";
		}
		
	}

	public boolean isCACS_FORCE_DIVN_YN_UI() {
		return CACS_FORCE_DIVN_YN_UI;
	}

	public void setCACS_FORCE_DIVN_YN_UI(boolean cacs_force_divn_yn_ui) {
		CACS_FORCE_DIVN_YN_UI = cacs_force_divn_yn_ui;
		if (cacs_force_divn_yn_ui){
			this.CACS_FORCE_DIVN_YN="Y";
		}else{
			this.CACS_FORCE_DIVN_YN="N";
		}
	}

	public boolean isCACS_FORCE_DEPT_YN_UI() {
		return CACS_FORCE_DEPT_YN_UI;
	}

	public void setCACS_FORCE_DEPT_YN_UI(boolean cacs_force_dept_yn_ui) {
		CACS_FORCE_DEPT_YN_UI = cacs_force_dept_yn_ui;
		if (cacs_force_dept_yn_ui){
			this.CACS_FORCE_DEPT_YN="Y";
		}else{
			this.CACS_FORCE_DEPT_YN="N";
		}
	}

	public Date getCACS_CR_DT() {
		return CACS_CR_DT;
	}

	public void setCACS_CR_DT(Date cacs_cr_dt) {
		CACS_CR_DT = cacs_cr_dt;
	}

	public Date getCACS_UPD_DT() {
		return CACS_UPD_DT;
	}

	public void setCACS_UPD_DT(Date cacs_upd_dt) {
		CACS_UPD_DT = cacs_upd_dt;
	}

	public String getCACS_CR_UID() {
		return CACS_CR_UID;
	}

	public void setCACS_CR_UID(String cacs_cr_uid) {
		CACS_CR_UID = cacs_cr_uid;
	}

	public String getCACS_UPD_UID() {
		return CACS_UPD_UID;
	}

	public void setCACS_UPD_UID(String cacs_upd_uid) {
		CACS_UPD_UID = cacs_upd_uid;
	}
}
