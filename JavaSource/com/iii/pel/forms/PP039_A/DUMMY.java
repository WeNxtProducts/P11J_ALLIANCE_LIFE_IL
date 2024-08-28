package com.iii.pel.forms.PP039_A;

import java.util.Date;

import com.iii.premia.common.constants.PELConstants;

public class DUMMY {
	String UI_M_POL_NO;
	Date UI_M_DRIPPING_DT;
	String GENERAL_INS;
	String LIFE_INS;
	String UI_M_ACCNT_GEN_YN;
	String UI_M_POLICY_TO;
	String UI_M_POLICY_FM;
	String UI_M_PROD_FM;
	String UI_M_PROD_TO;
	Date UI_M_FM_DT;
	Date UI_M_TO_DT;

	Double UI_M_PREM_IN_SI_CURR;
	Date UI_M_ISS_END_DT;
	Double UI_M_APPRV_DT_CHK;
	Date UI_M_APPRV_FM_DT;
	Date UI_M_APPRV_TO_DT;
	String UI_M_POST_BO;
	String UI_M_ACC_DOC_GEN_YN;
	String UI_M_SRC_BUS_CODE;
	Long UI_M_PC_SYS_ID;
	String UI_M_POL_PLAN_CODE;
	Boolean UI_M_ACCNT_GEN_YN_FLAG;
	Boolean LIFE_INS_FLAG;
	Boolean GENERAL_INS_FLAG;

	public boolean isCHECK_GENERAL_INS_FLAG() {
		if (PELConstants.CHECKBOX_CHECKED.equals(GENERAL_INS)) {
			GENERAL_INS_FLAG = true;
		} else {
			GENERAL_INS_FLAG = false;
		}
		return GENERAL_INS_FLAG;
	}

	public boolean isCHECK_UI_M_ACCNT_GEN_YN_FLAG() {
		if (PELConstants.CHECKBOX_CHECKED.equals(UI_M_ACCNT_GEN_YN)) {
			UI_M_ACCNT_GEN_YN_FLAG = true;
		} else {
			UI_M_ACCNT_GEN_YN_FLAG = false;
		}
		return UI_M_ACCNT_GEN_YN_FLAG;
	}

	public boolean isLIFE_INS_FLAG() {
		if (PELConstants.CHECKBOX_CHECKED.equals(LIFE_INS)) {
			LIFE_INS_FLAG = true;
		} else {
			LIFE_INS_FLAG = false;
		}
		return LIFE_INS_FLAG;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String ui_m_pol_no) {
		UI_M_POL_NO = ui_m_pol_no;
	}

	public Date getUI_M_DRIPPING_DT() {
		return UI_M_DRIPPING_DT;
	}

	public void setUI_M_DRIPPING_DT(Date ui_m_dripping_dt) {
		UI_M_DRIPPING_DT = ui_m_dripping_dt;
	}

	public String getUI_M_POLICY_TO() {
		return UI_M_POLICY_TO;
	}

	public void setUI_M_POLICY_TO(String ui_m_policy_to) {
		UI_M_POLICY_TO = ui_m_policy_to;
	}

	public String getUI_M_POLICY_FM() {
		return UI_M_POLICY_FM;
	}

	public void setUI_M_POLICY_FM(String ui_m_policy_fm) {
		UI_M_POLICY_FM = ui_m_policy_fm;
	}

	public String getUI_M_PROD_FM() {
		return UI_M_PROD_FM;
	}

	public void setUI_M_PROD_FM(String ui_m_prod_fm) {
		UI_M_PROD_FM = ui_m_prod_fm;
	}

	public String getUI_M_PROD_TO() {
		return UI_M_PROD_TO;
	}

	public void setUI_M_PROD_TO(String ui_m_prod_to) {
		UI_M_PROD_TO = ui_m_prod_to;
	}

	public Double getUI_M_PREM_IN_SI_CURR() {
		return UI_M_PREM_IN_SI_CURR;
	}

	public void setUI_M_PREM_IN_SI_CURR(Double ui_m_prem_in_si_curr) {
		UI_M_PREM_IN_SI_CURR = ui_m_prem_in_si_curr;
	}

	public Double getUI_M_APPRV_DT_CHK() {
		return UI_M_APPRV_DT_CHK;
	}

	public void setUI_M_APPRV_DT_CHK(Double ui_m_apprv_dt_chk) {
		UI_M_APPRV_DT_CHK = ui_m_apprv_dt_chk;
	}

	public Date getUI_M_APPRV_FM_DT() {
		return UI_M_APPRV_FM_DT;
	}

	public void setUI_M_APPRV_FM_DT(Date ui_m_apprv_fm_dt) {
		UI_M_APPRV_FM_DT = ui_m_apprv_fm_dt;
	}

	public Date getUI_M_APPRV_TO_DT() {
		return UI_M_APPRV_TO_DT;
	}

	public void setUI_M_APPRV_TO_DT(Date ui_m_apprv_to_dt) {
		UI_M_APPRV_TO_DT = ui_m_apprv_to_dt;
	}

	public String getUI_M_POST_BO() {
		return UI_M_POST_BO;
	}

	public void setUI_M_POST_BO(String ui_m_post_bo) {
		UI_M_POST_BO = ui_m_post_bo;
	}

	public String getUI_M_ACC_DOC_GEN_YN() {
		return UI_M_ACC_DOC_GEN_YN;
	}

	public void setUI_M_ACC_DOC_GEN_YN(String ui_m_acc_doc_gen_yn) {
		UI_M_ACC_DOC_GEN_YN = ui_m_acc_doc_gen_yn;
	}

	public String getUI_M_SRC_BUS_CODE() {
		return UI_M_SRC_BUS_CODE;
	}

	public void setUI_M_SRC_BUS_CODE(String ui_m_src_bus_code) {
		UI_M_SRC_BUS_CODE = ui_m_src_bus_code;
	}

	public Long getUI_M_PC_SYS_ID() {
		return UI_M_PC_SYS_ID;
	}

	public void setUI_M_PC_SYS_ID(Long ui_m_pc_sys_id) {
		UI_M_PC_SYS_ID = ui_m_pc_sys_id;
	}

	public String getUI_M_POL_PLAN_CODE() {
		return UI_M_POL_PLAN_CODE;
	}

	public void setUI_M_POL_PLAN_CODE(String ui_m_pol_plan_code) {
		UI_M_POL_PLAN_CODE = ui_m_pol_plan_code;
	}

	public String getGENERAL_INS() {
		return GENERAL_INS;
	}

	public void setGENERAL_INS(String general_ins) {
		GENERAL_INS = general_ins;
	}

	public Boolean getGENERAL_INS_FLAG() {
		return GENERAL_INS_FLAG;
	}

	public void setGENERAL_INS_FLAG(Boolean general_ins_flag) {
		GENERAL_INS_FLAG = general_ins_flag;
	}

	public Date getUI_M_FM_DT() {
		return UI_M_FM_DT;
	}

	public void setUI_M_FM_DT(Date ui_m_fm_dt) {
		UI_M_FM_DT = ui_m_fm_dt;
	}

	public Date getUI_M_TO_DT() {
		return UI_M_TO_DT;
	}

	public void setUI_M_TO_DT(Date ui_m_to_dt) {
		UI_M_TO_DT = ui_m_to_dt;
	}

	public Date getUI_M_ISS_END_DT() {
		return UI_M_ISS_END_DT;
	}

	public void setUI_M_ISS_END_DT(Date ui_m_iss_end_dt) {
		UI_M_ISS_END_DT = ui_m_iss_end_dt;
	}

	public Boolean getLIFE_INS_FLAG() {
		return LIFE_INS_FLAG;
	}

	public void setLIFE_INS_FLAG(Boolean life_ins_flag) {
		LIFE_INS_FLAG = life_ins_flag;
	}

	public Boolean getUI_M_ACCNT_GEN_YN_FLAG() {
		return UI_M_ACCNT_GEN_YN_FLAG;
	}

	public void setUI_M_ACCNT_GEN_YN_FLAG(Boolean ui_m_accnt_gen_yn_flag) {
		UI_M_ACCNT_GEN_YN_FLAG = ui_m_accnt_gen_yn_flag;
	}

	public void setLIFE_INS(String life_ins) {
		LIFE_INS = life_ins;
	}

	public void setUI_M_ACCNT_GEN_YN(String ui_m_accnt_gen_yn) {
		UI_M_ACCNT_GEN_YN = ui_m_accnt_gen_yn;
	}

	public String getLIFE_INS() {
		return LIFE_INS;
	}

	public String getUI_M_ACCNT_GEN_YN() {
		return UI_M_ACCNT_GEN_YN;
	}

}
