package com.iii.pel.forms.PILM035_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class DUMMY extends BaseValueBean {

	private String UI_M_PROD_SA_INST_PYMT_TYPE;
	private Integer UI_M_DUMMY;
	private Integer UI_M_DUMMY1;
	private Integer UI_M_PROD_PERIOD;
	private Integer UI_M_PROD_PERIOD_MULTIPLE;
	private Integer UI_M_PLAN_PERIOD_FROM;
	private Integer UI_M_PLAN_PERIOD_TO;
	private Integer UI_M_PLAN_MAX_AGE_ON_MAT;
	private Integer UI_M_PS_VALUE;
	
	private String PM_IL_PRODUCT_CF;
	private String PM_IL_PROD_APPL_COVER_CF;
	private String PM_IL_PROD_APPL_COND_CF;
	private String PM_IL_SA_INST_PYMT_CF;
	private String PM_IL_SA_INST_PYMT1_CF;
	private String PM_IL_PROD_APPL_BONUS_CF;
	private String PM_IL_PROD_APPL_LOAD_TARIFF_CF;
	private String PM_IL_PROD_PREM_LIMIT_CF;
	
	private String UI_M_PAC_SA_FACTOR;	
	private String UI_M_PAC_SA_TARIFF;
	private String UI_M_PAC_PREM_TARIFF;
	private String UI_M_PAC_SA_ADD_FACTOR;
	
	
	
	private String UI_M_SRC_PROD_CODE;
	private String UI_M_SRC_PROD_CODE_DESC;
	private String UI_M_DEST_PROD_CODE;
	private String UI_M_DEST_PROD_CODE_DESC;
	
	private String UI_OLD_CVR_CODE;
	private String UI_NEW_CVR_CODE;
	private Boolean UI_CVR_CHECK;
	private Boolean UI_PLAN_CHECK;
	private Boolean UI_TRF_CHECK;
	private String cvrCheck;
	private String planCheck;
	private String trfCheck;
	

	public String getUI_NEW_CVR_CODE() {
		return UI_NEW_CVR_CODE;
	}

	public void setUI_NEW_CVR_CODE(String ui_new_cvr_code) {
		UI_NEW_CVR_CODE = ui_new_cvr_code;
	}

	public String getUI_OLD_CVR_CODE() {
		return UI_OLD_CVR_CODE;
	}

	public void setUI_OLD_CVR_CODE(String ui_old_cvr_code) {
		UI_OLD_CVR_CODE = ui_old_cvr_code;
	}

	

	public Boolean getUI_CVR_CHECK() {
		return UI_CVR_CHECK;
	}

	public void setUI_CVR_CHECK(Boolean ui_cvr_check) {
		UI_CVR_CHECK = ui_cvr_check;
	}

	public Boolean getUI_PLAN_CHECK() {
		return UI_PLAN_CHECK;
	}

	public void setUI_PLAN_CHECK(Boolean ui_plan_check) {
		UI_PLAN_CHECK = ui_plan_check;
	}

	public Boolean getUI_TRF_CHECK() {
		return UI_TRF_CHECK;
	}

	public void setUI_TRF_CHECK(Boolean ui_trf_check) {
		UI_TRF_CHECK = ui_trf_check;
	}

	public String getCvrCheck() {
		return cvrCheck;
	}

	public void setCvrCheck(String cvrCheck) {
		this.cvrCheck = cvrCheck;
	}

	public String getPlanCheck() {
		return planCheck;
	}

	public void setPlanCheck(String planCheck) {
		this.planCheck = planCheck;
	}

	public String getTrfCheck() {
		return trfCheck;
	}

	public void setTrfCheck(String trfCheck) {
		this.trfCheck = trfCheck;
	}

	public String getUI_M_DEST_PROD_CODE_DESC() {
		return UI_M_DEST_PROD_CODE_DESC;
	}

	public void setUI_M_DEST_PROD_CODE_DESC(String ui_m_dest_prod_code_desc) {
		UI_M_DEST_PROD_CODE_DESC = ui_m_dest_prod_code_desc;
	}

	public String getUI_M_SRC_PROD_CODE_DESC() {
		return UI_M_SRC_PROD_CODE_DESC;
	}

	public void setUI_M_SRC_PROD_CODE_DESC(String ui_m_src_prod_code_desc) {
		UI_M_SRC_PROD_CODE_DESC = ui_m_src_prod_code_desc;
	}

	public String getUI_M_SRC_PROD_CODE() {
		return UI_M_SRC_PROD_CODE;
	}

	public void setUI_M_SRC_PROD_CODE(String ui_m_src_prod_code) {
		UI_M_SRC_PROD_CODE = ui_m_src_prod_code;
	}

	public String getUI_M_DEST_PROD_CODE() {
		return UI_M_DEST_PROD_CODE;
	}

	public void setUI_M_DEST_PROD_CODE(String ui_m_dest_prod_code) {
		UI_M_DEST_PROD_CODE = ui_m_dest_prod_code;
	}

	public String getUI_M_PAC_SA_FACTOR() {
		return UI_M_PAC_SA_FACTOR;
	}

	public void setUI_M_PAC_SA_FACTOR(String ui_m_pac_sa_factor) {
		UI_M_PAC_SA_FACTOR = ui_m_pac_sa_factor;
	}

	public String getUI_M_PAC_SA_TARIFF() {
		return UI_M_PAC_SA_TARIFF;
	}

	public void setUI_M_PAC_SA_TARIFF(String ui_m_pac_sa_tariff) {
		UI_M_PAC_SA_TARIFF = ui_m_pac_sa_tariff;
	}

	

	public String getUI_M_PAC_PREM_TARIFF() {
		return UI_M_PAC_PREM_TARIFF;
	}

	public void setUI_M_PAC_PREM_TARIFF(String ui_m_pac_prem_tariff) {
		UI_M_PAC_PREM_TARIFF = ui_m_pac_prem_tariff;
	}

	public String getPM_IL_PRODUCT_CF() {
		return PM_IL_PRODUCT_CF;
	}

	public void setPM_IL_PRODUCT_CF(String pm_il_product_cf) {
		PM_IL_PRODUCT_CF = pm_il_product_cf;
	}

	public String getPM_IL_PROD_APPL_COVER_CF() {
		return PM_IL_PROD_APPL_COVER_CF;
	}

	public void setPM_IL_PROD_APPL_COVER_CF(String pm_il_prod_appl_cover_cf) {
		PM_IL_PROD_APPL_COVER_CF = pm_il_prod_appl_cover_cf;
	}

	public String getPM_IL_PROD_APPL_COND_CF() {
		return PM_IL_PROD_APPL_COND_CF;
	}

	public void setPM_IL_PROD_APPL_COND_CF(String pm_il_prod_appl_cond_cf) {
		PM_IL_PROD_APPL_COND_CF = pm_il_prod_appl_cond_cf;
	}

	public String getPM_IL_SA_INST_PYMT_CF() {
		return PM_IL_SA_INST_PYMT_CF;
	}

	public void setPM_IL_SA_INST_PYMT_CF(String pm_il_sa_inst_pymt_cf) {
		PM_IL_SA_INST_PYMT_CF = pm_il_sa_inst_pymt_cf;
	}

	public String getPM_IL_SA_INST_PYMT1_CF() {
		return PM_IL_SA_INST_PYMT1_CF;
	}

	public void setPM_IL_SA_INST_PYMT1_CF(String pm_il_sa_inst_pymt1_cf) {
		PM_IL_SA_INST_PYMT1_CF = pm_il_sa_inst_pymt1_cf;
	}

	public String getPM_IL_PROD_APPL_BONUS_CF() {
		return PM_IL_PROD_APPL_BONUS_CF;
	}

	public void setPM_IL_PROD_APPL_BONUS_CF(String pm_il_prod_appl_bonus_cf) {
		PM_IL_PROD_APPL_BONUS_CF = pm_il_prod_appl_bonus_cf;
	}

	public String getPM_IL_PROD_APPL_LOAD_TARIFF_CF() {
		return PM_IL_PROD_APPL_LOAD_TARIFF_CF;
	}

	public void setPM_IL_PROD_APPL_LOAD_TARIFF_CF(
			String pm_il_prod_appl_load_tariff_cf) {
		PM_IL_PROD_APPL_LOAD_TARIFF_CF = pm_il_prod_appl_load_tariff_cf;
	}

	public String getPM_IL_PROD_PREM_LIMIT_CF() {
		return PM_IL_PROD_PREM_LIMIT_CF;
	}

	public void setPM_IL_PROD_PREM_LIMIT_CF(String pm_il_prod_prem_limit_cf) {
		PM_IL_PROD_PREM_LIMIT_CF = pm_il_prod_prem_limit_cf;
	}

	public Integer getUI_M_PS_VALUE() {
		return UI_M_PS_VALUE;
	}

	public void setUI_M_PS_VALUE(Integer ui_m_ps_value) {
		UI_M_PS_VALUE = ui_m_ps_value;
	}

	public Integer getUI_M_PROD_PERIOD() {
		return UI_M_PROD_PERIOD;
	}

	public void setUI_M_PROD_PERIOD(Integer ui_m_prod_period) {
		UI_M_PROD_PERIOD = ui_m_prod_period;
	}

	public Integer getUI_M_DUMMY() {
		return UI_M_DUMMY;
	}

	public void setUI_M_DUMMY(Integer ui_m_dummy) {
		UI_M_DUMMY = ui_m_dummy;
	}

	public String getUI_M_PROD_SA_INST_PYMT_TYPE() {
		return UI_M_PROD_SA_INST_PYMT_TYPE;
	}

	public void setUI_M_PROD_SA_INST_PYMT_TYPE(
			String ui_m_prod_sa_inst_pymt_type) {
		UI_M_PROD_SA_INST_PYMT_TYPE = ui_m_prod_sa_inst_pymt_type;
	}

	public Integer getUI_M_PROD_PERIOD_MULTIPLE() {
		return UI_M_PROD_PERIOD_MULTIPLE;
	}

	public void setUI_M_PROD_PERIOD_MULTIPLE(Integer ui_m_prod_period_multiple) {
		UI_M_PROD_PERIOD_MULTIPLE = ui_m_prod_period_multiple;
	}

	public Integer getUI_M_DUMMY1() {
		return UI_M_DUMMY1;
	}

	public void setUI_M_DUMMY1(Integer ui_m_dummy1) {
		UI_M_DUMMY1 = ui_m_dummy1;
	}

	public Integer getUI_M_PLAN_PERIOD_FROM() {
		return UI_M_PLAN_PERIOD_FROM;
	}

	public void setUI_M_PLAN_PERIOD_FROM(Integer ui_m_plan_period_from) {
		UI_M_PLAN_PERIOD_FROM = ui_m_plan_period_from;
	}

	public Integer getUI_M_PLAN_PERIOD_TO() {
		return UI_M_PLAN_PERIOD_TO;
	}

	public void setUI_M_PLAN_PERIOD_TO(Integer ui_m_plan_period_to) {
		UI_M_PLAN_PERIOD_TO = ui_m_plan_period_to;
	}

	public Integer getUI_M_PLAN_MAX_AGE_ON_MAT() {
		return UI_M_PLAN_MAX_AGE_ON_MAT;
	}

	public void setUI_M_PLAN_MAX_AGE_ON_MAT(Integer ui_m_plan_max_age_on_mat) {
		UI_M_PLAN_MAX_AGE_ON_MAT = ui_m_plan_max_age_on_mat;
	}

	public String getUI_M_PAC_SA_ADD_FACTOR() {
		return UI_M_PAC_SA_ADD_FACTOR;
	}

	public void setUI_M_PAC_SA_ADD_FACTOR(String ui_m_pac_sa_add_factor) {
		UI_M_PAC_SA_ADD_FACTOR = ui_m_pac_sa_add_factor;
	}

	
	
}
