package com.iii.pel.forms.PILM003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PLAN_AGE_SETUP")
public class PM_IL_PLAN_AGE_SETUP extends BaseValueBean {

	@Column(name = "PAS_PLAN_CODE")
	private String PAS_PLAN_CODE;

	@Column(name = "PAS_JOINT_LIFE_YN")
	private String PAS_JOINT_LIFE_YN;

	@Column(name = "PAS_AGE_BASIS")
	private String PAS_AGE_BASIS;

	@Column(name = "PAS_CATG_FM_CODE")
	private String PAS_CATG_FM_CODE;

	@Column(name = "PAS_CATG_TO_CODE")
	private String PAS_CATG_TO_CODE;

	@Column(name = "PAS_ASSRD_AGE_FM")
	private Integer PAS_ASSRD_AGE_FM;

	@Column(name = "PAS_ASSRD_AGE_TO")
	private Integer PAS_ASSRD_AGE_TO;

	@Column(name = "PAS_MIN_AGE")
	private Integer PAS_MIN_AGE;

	@Column(name = "PAS_MAX_AGE")
	private Integer PAS_MAX_AGE;

	@Column(name = "PAS_MIN_PERIOD")
	private Integer PAS_MIN_PERIOD;

	@Column(name = "PAS_MAX_PERIOD")
	private Integer PAS_MAX_PERIOD;

	@Column(name = "PAS_MAX_AGE_ON_MAT")
	private Integer PAS_MAX_AGE_ON_MAT;

	@Column(name = "PAS_CR_UID")
	private String PAS_CR_UID;

	@Column(name = "PAS_CR_DT")
	private Date PAS_CR_DT;

	@Column(name = "PAS_UPD_UID")
	private String PAS_UPD_UID;

	@Column(name = "PAS_UPD_DT")
	private Date PAS_UPD_DT;

	@Column(name = "PAS_MIN_AGE_ON_MAT")
	private Integer PAS_MIN_AGE_ON_MAT;
	
	private String UI_M_PAS_CATG_FM_CODE_DESC;
	
	private String UI_M_PAS_CATG_TO_CODE_DESC;

	public String getUI_M_PAS_CATG_TO_CODE_DESC() {
		return UI_M_PAS_CATG_TO_CODE_DESC;
	}

	public void setUI_M_PAS_CATG_TO_CODE_DESC(String ui_m_pas_catg_to_code_desc) {
		UI_M_PAS_CATG_TO_CODE_DESC = ui_m_pas_catg_to_code_desc;
	}

	public String getUI_M_PAS_CATG_FM_CODE_DESC() {
		return UI_M_PAS_CATG_FM_CODE_DESC;
	}

	public void setUI_M_PAS_CATG_FM_CODE_DESC(String ui_m_pas_catg_fm_code_desc) {
		UI_M_PAS_CATG_FM_CODE_DESC = ui_m_pas_catg_fm_code_desc;
	}

	public String getPAS_PLAN_CODE() {
		return PAS_PLAN_CODE;
	}

	public void setPAS_PLAN_CODE(String pas_plan_code) {
		PAS_PLAN_CODE = pas_plan_code;
	}

	public String getPAS_JOINT_LIFE_YN() {
		return PAS_JOINT_LIFE_YN;
	}

	public void setPAS_JOINT_LIFE_YN(String pas_joint_life_yn) {
		PAS_JOINT_LIFE_YN = pas_joint_life_yn;
	}

	public String getPAS_AGE_BASIS() {
		return PAS_AGE_BASIS;
	}

	public void setPAS_AGE_BASIS(String pas_age_basis) {
		PAS_AGE_BASIS = pas_age_basis;
	}

	public String getPAS_CATG_FM_CODE() {
		return PAS_CATG_FM_CODE;
	}

	public void setPAS_CATG_FM_CODE(String pas_catg_fm_code) {
		PAS_CATG_FM_CODE = pas_catg_fm_code;
	}

	public String getPAS_CATG_TO_CODE() {
		return PAS_CATG_TO_CODE;
	}

	public void setPAS_CATG_TO_CODE(String pas_catg_to_code) {
		PAS_CATG_TO_CODE = pas_catg_to_code;
	}

	public Integer getPAS_ASSRD_AGE_FM() {
		return PAS_ASSRD_AGE_FM;
	}

	public void setPAS_ASSRD_AGE_FM(Integer pas_assrd_age_fm) {
		PAS_ASSRD_AGE_FM = pas_assrd_age_fm;
	}

	public Integer getPAS_ASSRD_AGE_TO() {
		return PAS_ASSRD_AGE_TO;
	}

	public void setPAS_ASSRD_AGE_TO(Integer pas_assrd_age_to) {
		PAS_ASSRD_AGE_TO = pas_assrd_age_to;
	}

	public Integer getPAS_MIN_AGE() {
		return PAS_MIN_AGE;
	}

	public void setPAS_MIN_AGE(Integer pas_min_age) {
		PAS_MIN_AGE = pas_min_age;
	}

	public Integer getPAS_MAX_AGE() {
		return PAS_MAX_AGE;
	}

	public void setPAS_MAX_AGE(Integer pas_max_age) {
		PAS_MAX_AGE = pas_max_age;
	}

	public Integer getPAS_MIN_PERIOD() {
		return PAS_MIN_PERIOD;
	}

	public void setPAS_MIN_PERIOD(Integer pas_min_period) {
		PAS_MIN_PERIOD = pas_min_period;
	}

	public Integer getPAS_MAX_PERIOD() {
		return PAS_MAX_PERIOD;
	}

	public void setPAS_MAX_PERIOD(Integer pas_max_period) {
		PAS_MAX_PERIOD = pas_max_period;
	}

	public Integer getPAS_MAX_AGE_ON_MAT() {
		return PAS_MAX_AGE_ON_MAT;
	}

	public void setPAS_MAX_AGE_ON_MAT(Integer pas_max_age_on_mat) {
		PAS_MAX_AGE_ON_MAT = pas_max_age_on_mat;
	}

	public String getPAS_CR_UID() {
		return PAS_CR_UID;
	}

	public void setPAS_CR_UID(String pas_cr_uid) {
		PAS_CR_UID = pas_cr_uid;
	}

	public Date getPAS_CR_DT() {
		return PAS_CR_DT;
	}

	public void setPAS_CR_DT(Date pas_cr_dt) {
		PAS_CR_DT = pas_cr_dt;
	}

	public String getPAS_UPD_UID() {
		return PAS_UPD_UID;
	}

	public void setPAS_UPD_UID(String pas_upd_uid) {
		PAS_UPD_UID = pas_upd_uid;
	}

	public Date getPAS_UPD_DT() {
		return PAS_UPD_DT;
	}

	public void setPAS_UPD_DT(Date pas_upd_dt) {
		PAS_UPD_DT = pas_upd_dt;
	}

	public Integer getPAS_MIN_AGE_ON_MAT() {
		return PAS_MIN_AGE_ON_MAT;
	}

	public void setPAS_MIN_AGE_ON_MAT(Integer pas_min_age_on_mat) {
		PAS_MIN_AGE_ON_MAT = pas_min_age_on_mat;
	}

	

}
