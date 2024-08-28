package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PW_IL_QQUOT_ASSURED_DTLS")
public class PW_IL_QQUOT_ASSURED_DTLS extends BaseValueBean {

	
	@Column(name="QQAD_SYS_ID")
	private Long QQAD_SYS_ID;
	
	@Column(name="QQAD_QUOT_SYS_ID")
	private Long QQAD_QUOT_SYS_ID;
	
	@Column(name="QQAD_TYPE")
	private String QQAD_TYPE;
	
	@Column(name="QQAD_ASSR_CODE")
	private String QQAD_ASSR_CODE;
	
	@Column(name="QQAD_ASSR_REF_ID1")
	private String QQAD_ASSR_REF_ID1;
	
	@Column(name="QQAD_ASSR_REF_ID2")
	private String QQAD_ASSR_REF_ID2;
	
	@Column(name="QQAD_ASSR_DOB")
	private Date QQAD_ASSR_DOB;
	
	@Column(name="QQAD_ASSR_OCC_CODE")
	private String QQAD_ASSR_OCC_CODE;
	
	@Column(name="QQAD_CR_UID")
	private String QQAD_CR_UID;
	 
	@Column(name="QQAD_CR_DT")
	private Date QQAD_CR_DT;
	
	
	@Column(name="QQAD_UPD_UID")
	private String QQAD_UPD_UID;
	
	@Column(name="QQAD_UPD_DT")
	private Date QQAD_UPD_DT;
	
	@Column(name="QQAD_HEIGHT")
	private Double QQAD_HEIGHT;
	
	@Column(name="QQAD_WEIGHT")
	private Double QQAD_WEIGHT;
	
	
	@Column(name="QQAD_AGE")
	private int QQAD_AGE;
	
	
	@Column(name="QQAD_ASSURED_NAME")
	private String QQAD_ASSURED_NAME;
	
	@Column(name="QQAD_CATG_CODE")
	private String QQAD_CATG_CODE;
	
	@Column(name="QQAD_ADDRESSS")
	private String QQAD_ADDRESSS;
	
	@Column(name="QQAD_AGNT_RATE")
	private String QQAD_AGNT_RATE;
	
	@Column(name="QQAD_AGNT_VAL")
	private String QQAD_AGNT_VAL;
	
	
	
	public String getQQAD_AGNT_RATE() {
		return QQAD_AGNT_RATE;
	}

	public void setQQAD_AGNT_RATE(String qQAD_AGNT_RATE) {
		QQAD_AGNT_RATE = qQAD_AGNT_RATE;
	}

	public String getQQAD_AGNT_VAL() {
		return QQAD_AGNT_VAL;
	}

	public void setQQAD_AGNT_VAL(String qQAD_AGNT_VAL) {
		QQAD_AGNT_VAL = qQAD_AGNT_VAL;
	}

	public String getQQAD_CATG_CODE() {
		return QQAD_CATG_CODE;
	}

	public void setQQAD_CATG_CODE(String qQAD_CATG_CODE) {
		QQAD_CATG_CODE = qQAD_CATG_CODE;
	}
	@Column(name="QQAD_BMI")
	private Double QQAD_BMI;
	
	public Double getQQAD_BMI() {
		return QQAD_BMI;
	}

	public void setQQAD_BMI(Double qQAD_BMI) {
		QQAD_BMI = qQAD_BMI;
	}


	
	
	public String getQQAD_ADDRESSS() {
		return QQAD_ADDRESSS;
	}

	public void setQQAD_ADDRESSS(String qQAD_ADDRESSS) {
		QQAD_ADDRESSS = qQAD_ADDRESSS;
	}

	public String getQQAD_ASSURED_NAME() {
		return QQAD_ASSURED_NAME;
	}

	public void setQQAD_ASSURED_NAME(String qQAD_ASSURED_NAME) {
		QQAD_ASSURED_NAME = qQAD_ASSURED_NAME;
	}

	public int getQQAD_AGE() {
		return QQAD_AGE;
	}

	public void setQQAD_AGE(int qQAD_AGE) {
		QQAD_AGE = qQAD_AGE;
	}

	public Double getQQAD_HEIGHT() {
		return QQAD_HEIGHT;
	}

	public void setQQAD_HEIGHT(Double qQAD_HEIGHT) {
		QQAD_HEIGHT = qQAD_HEIGHT;
	}

	public Double getQQAD_WEIGHT() {
		return QQAD_WEIGHT;
	}

	public void setQQAD_WEIGHT(Double qQAD_WEIGHT) {
		QQAD_WEIGHT = qQAD_WEIGHT;
	}

	private String UI_QQAD_ASSR_NAME;

	public Long getQQAD_SYS_ID() {
		return QQAD_SYS_ID;
	}

	public void setQQAD_SYS_ID(Long qqad_sys_id) {
		QQAD_SYS_ID = qqad_sys_id;
	}

	public Long getQQAD_QUOT_SYS_ID() {
		return QQAD_QUOT_SYS_ID;
	}

	public void setQQAD_QUOT_SYS_ID(Long qqad_quot_sys_id) {
		QQAD_QUOT_SYS_ID = qqad_quot_sys_id;
	}

	public String getQQAD_TYPE() {
		return QQAD_TYPE;
	}

	public void setQQAD_TYPE(String qqad_type) {
		QQAD_TYPE = qqad_type;
	}

	public String getQQAD_ASSR_CODE() {
		return QQAD_ASSR_CODE;
	}

	public void setQQAD_ASSR_CODE(String qqad_assr_code) {
		QQAD_ASSR_CODE = qqad_assr_code;
	}

	public String getQQAD_ASSR_REF_ID1() {
		return QQAD_ASSR_REF_ID1;
	}

	public void setQQAD_ASSR_REF_ID1(String qqad_assr_ref_id1) {
		QQAD_ASSR_REF_ID1 = qqad_assr_ref_id1;
	}

	public String getQQAD_ASSR_REF_ID2() {
		return QQAD_ASSR_REF_ID2;
	}

	public void setQQAD_ASSR_REF_ID2(String qqad_assr_ref_id2) {
		QQAD_ASSR_REF_ID2 = qqad_assr_ref_id2;
	}

	public Date getQQAD_ASSR_DOB() {
		return QQAD_ASSR_DOB;
	}

	public void setQQAD_ASSR_DOB(Date qqad_assr_dob) {
		QQAD_ASSR_DOB = qqad_assr_dob;
	}

	public String getQQAD_ASSR_OCC_CODE() {
		return QQAD_ASSR_OCC_CODE;
	}

	public void setQQAD_ASSR_OCC_CODE(String qqad_assr_occ_code) {
		QQAD_ASSR_OCC_CODE = qqad_assr_occ_code;
	}

	public String getQQAD_CR_UID() {
		return QQAD_CR_UID;
	}

	public void setQQAD_CR_UID(String qqad_cr_uid) {
		QQAD_CR_UID = qqad_cr_uid;
	}

	public Date getQQAD_CR_DT() {
		return QQAD_CR_DT;
	}

	public void setQQAD_CR_DT(Date qqad_cr_dt) {
		QQAD_CR_DT = qqad_cr_dt;
	}

	public String getQQAD_UPD_UID() {
		return QQAD_UPD_UID;
	}

	public void setQQAD_UPD_UID(String qqad_upd_uid) {
		QQAD_UPD_UID = qqad_upd_uid;
	}

	public Date getQQAD_UPD_DT() {
		return QQAD_UPD_DT;
	}

	public void setQQAD_UPD_DT(Date qqad_upd_dt) {
		QQAD_UPD_DT = qqad_upd_dt;
	}

	public String getUI_QQAD_ASSR_NAME() {
		return UI_QQAD_ASSR_NAME;
	}

	public void setUI_QQAD_ASSR_NAME(String ui_qqad_assr_name) {
		UI_QQAD_ASSR_NAME = ui_qqad_assr_name;
	}
	/*added by janani for cusor issue for ssp call id FALCONLIFE-1349309 on 18-10-16*/
	private int sample_value;

	public int getSample_value() {
		return sample_value;
	}

	public void setSample_value(int sample_value) {
		this.sample_value = sample_value;
	}	
	/*end*/
	/*Added by Ram on 21/01/2017 for Praganacy field addition*/
	@Column(name = "QUOT_PRAGANENT_YN")
	private String QUOT_PRAGANENT_YN;



	public String getQUOT_PRAGANENT_YN() {
		return QUOT_PRAGANENT_YN;
	}

	public void setQUOT_PRAGANENT_YN(String qUOT_PRAGANENT_YN) {
		QUOT_PRAGANENT_YN = qUOT_PRAGANENT_YN;
	}
	/*End*/

}
