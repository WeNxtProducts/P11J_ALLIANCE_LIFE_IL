package com.iii.pel.forms.PT044_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_POL_DTLS")
public class PT_AGENT_POL_DTLS extends BaseValueBean {

	private static final long serialVersionUID = 1L;

	@Column(name="APD_POL_DS_TYPE")
	private String APD_POL_DS_TYPE;

	@Column(name="APD_POBH_COMM_CODE")
	private String APD_POBH_COMM_CODE;

	@Column(name="APD_POL_END_NO")
	private String APD_POL_END_NO;

	@Column(name="APD_FLAG")
	private String APD_FLAG;

	@Column(name="APD_SYS_ID")
	private int APD_SYS_ID;

	@Column(name="APD_ATH_SYS_ID")
	private int APD_ATH_SYS_ID;

	@Column(name="APD_POL_SYS_ID")
	private int APD_POL_SYS_ID;

	@Column(name="APD_NUM_GEN_FLAG")
	private String APD_NUM_GEN_FLAG;

	@Column(name="APD_POBH_SYS_ID")
	private int APD_POBH_SYS_ID;

	@Column(name="APD_POL_END_NO_IDX")
	private int APD_POL_END_NO_IDX;

	@Column(name="APD_POL_END_CODE")
	private String APD_POL_END_CODE;

	@Column(name="APD_CR_UID")
	private String APD_CR_UID;

	@Column(name="APD_CR_DT")
	private Date APD_CR_DT;

	@Column(name="APD_UPD_UID")
	private String APD_UPD_UID;

	@Column(name="APD_UPD_DT")
	private Date APD_UPD_DT; 
	
	private String UI_M_POL_NO;
	
	private Date UI_M_POL_START_DT;

	private String UI_M_APD_CODE_DESC;

	private String UI_M_POL_CONT_CODE;

	private String UI_M_POL_ASSURED_NAME;

	private boolean CHECK_BOX;
	
	/*added by nadhiya on 30.3.2016*/
	
	private String APD_PRINT_YN;
	 
	public String getAPD_PRINT_YN() {
		return APD_PRINT_YN;
	}

	public void setAPD_PRINT_YN(String aPD_PRINT_YN) {
		APD_PRINT_YN = aPD_PRINT_YN;
		System.out.println("vALUE   IN setAPD_PRINT_YN       "            +aPD_PRINT_YN);
		if(APD_PRINT_YN != null && APD_PRINT_YN.equals("Y")){
			System.out.println("FALG IS TRUE");
			freezeFlag = true;
		}else{
			System.out.println("FALG IS FALSE");
			freezeFlag = false;
		}
	}
	private boolean freezeFlag;

	public boolean isFreezeFlag() {
		return freezeFlag;
	}

	public void setFreezeFlag(boolean freezeFlag) {
		this.freezeFlag = freezeFlag;
	}

	
	/*end*/
	

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getAPD_POL_DS_TYPE() {
		return APD_POL_DS_TYPE;
	}

	public void setAPD_POL_DS_TYPE(String APD_POL_DS_TYPE) {
		this.APD_POL_DS_TYPE = APD_POL_DS_TYPE;
	}

	public String getAPD_POBH_COMM_CODE() {
		return APD_POBH_COMM_CODE;
	}

	public void setAPD_POBH_COMM_CODE(String APD_POBH_COMM_CODE) {
		this.APD_POBH_COMM_CODE = APD_POBH_COMM_CODE;
	}

	public String getAPD_POL_END_NO() {
		return APD_POL_END_NO;
	}

	public void setAPD_POL_END_NO(String APD_POL_END_NO) {
		this.APD_POL_END_NO = APD_POL_END_NO;
	}

	public String getAPD_FLAG() {
		return APD_FLAG;
	}

	public void setAPD_FLAG(String APD_FLAG) {
		this.APD_FLAG = APD_FLAG;
	}

	public Date getUI_M_POL_START_DT() {
		 return UI_M_POL_START_DT;
	}

	public void setUI_M_POL_START_DT(Date UI_M_POL_START_DT) {
		this.UI_M_POL_START_DT = UI_M_POL_START_DT;
	}

	public String getUI_M_APD_CODE_DESC() {
		return UI_M_APD_CODE_DESC;
	}

	public void setUI_M_APD_CODE_DESC(String UI_M_APD_CODE_DESC) {
		this.UI_M_APD_CODE_DESC = UI_M_APD_CODE_DESC;
	}

	public String getUI_M_POL_CONT_CODE() {
		return UI_M_POL_CONT_CODE;
	}

	public void setUI_M_POL_CONT_CODE(String UI_M_POL_CONT_CODE) {
		this.UI_M_POL_CONT_CODE = UI_M_POL_CONT_CODE;
	}

	public String getUI_M_POL_ASSURED_NAME() {
		return UI_M_POL_ASSURED_NAME;
	}

	public void setUI_M_POL_ASSURED_NAME(String UI_M_POL_ASSURED_NAME) {
		this.UI_M_POL_ASSURED_NAME = UI_M_POL_ASSURED_NAME;
	}

	public int getAPD_SYS_ID() {
		return APD_SYS_ID;
	}

	public void setAPD_SYS_ID(int apd_sys_id) {
		APD_SYS_ID = apd_sys_id;
	}

	public int getAPD_ATH_SYS_ID() {
		return APD_ATH_SYS_ID;
	}

	public void setAPD_ATH_SYS_ID(int apd_ath_sys_id) {
		APD_ATH_SYS_ID = apd_ath_sys_id;
	}

	public int getAPD_POL_SYS_ID() {
		return APD_POL_SYS_ID;
	}

	public void setAPD_POL_SYS_ID(int apd_pol_sys_id) {
		APD_POL_SYS_ID = apd_pol_sys_id;
	}

	public String getAPD_NUM_GEN_FLAG() {
		return APD_NUM_GEN_FLAG;
	}

	public void setAPD_NUM_GEN_FLAG(String apd_num_gen_flag) {
		APD_NUM_GEN_FLAG = apd_num_gen_flag;
	}

	public int getAPD_POBH_SYS_ID() {
		return APD_POBH_SYS_ID;
	}

	public void setAPD_POBH_SYS_ID(int apd_pobh_sys_id) {
		APD_POBH_SYS_ID = apd_pobh_sys_id;
	}

	public int getAPD_POL_END_NO_IDX() {
		return APD_POL_END_NO_IDX;
	}

	public void setAPD_POL_END_NO_IDX(int apd_pol_end_no_idx) {
		APD_POL_END_NO_IDX = apd_pol_end_no_idx;
	}

	public String getAPD_POL_END_CODE() {
		return APD_POL_END_CODE;
	}

	public void setAPD_POL_END_CODE(String apd_pol_end_code) {
		APD_POL_END_CODE = apd_pol_end_code;
	}

	public String getAPD_CR_UID() {
		return APD_CR_UID;
	}

	public void setAPD_CR_UID(String apd_cr_uid) {
		APD_CR_UID = apd_cr_uid;
	}

	public Date getAPD_CR_DT() {
		return APD_CR_DT;
	}

	public void setAPD_CR_DT(Date apd_cr_dt) {
		APD_CR_DT = apd_cr_dt;
	}

	public String getAPD_UPD_UID() {
		return APD_UPD_UID;
	}

	public void setAPD_UPD_UID(String apd_upd_uid) {
		APD_UPD_UID = apd_upd_uid;
	}

	public Date getAPD_UPD_DT() {
		return APD_UPD_DT;
	}

	public void setAPD_UPD_DT(Date apd_upd_dt) {
		APD_UPD_DT = apd_upd_dt;
	}
}
