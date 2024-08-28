package com.iii.pel.forms.PILT016A_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {
	 String UI_M_CALC_METHOD = null;
	 
	 String UI_M_PLAN_TYPE ;
	 
	 String UI_M_PROD_PREM_CALC_MTHD;
	 
	 String UI_BASE_CURR_CODE;
	 
	 String UI_PT_IL_DEPOSIT_CF;
	 String UI_PT_IL_PYMT_DTLS_CF;
	 String UI_M_DEL_FLAG;
	 
	 
	 PILT016A_APAC_COMPOSITE_ACTION compositeAction;

	public String getUI_M_CALC_METHOD() {
		return UI_M_CALC_METHOD;
	}

	public void setUI_M_CALC_METHOD(String ui_m_calc_method) {
		UI_M_CALC_METHOD = ui_m_calc_method;
	}
	
	public String getUI_M_PLAN_TYPE() {
		return UI_M_PLAN_TYPE;
	}

	public void setUI_M_PLAN_TYPE(String ui_m_plan_type) {
		UI_M_PLAN_TYPE = ui_m_plan_type;
	}

	public String getUI_M_PROD_PREM_CALC_MTHD() {
		return UI_M_PROD_PREM_CALC_MTHD;
	}

	public void setUI_M_PROD_PREM_CALC_MTHD(String ui_m_prod_prem_calc_mthd) {
		UI_M_PROD_PREM_CALC_MTHD = ui_m_prod_prem_calc_mthd;
	}

	/**
	 * @return the uI_BASE_CURR_CODE
	 */
	public String getUI_BASE_CURR_CODE() {
		return UI_BASE_CURR_CODE;
	}

	/**
	 * @param ui_base_curr_code the uI_BASE_CURR_CODE to set
	 */
	public void setUI_BASE_CURR_CODE(String ui_base_curr_code) {
		UI_BASE_CURR_CODE = ui_base_curr_code;
	}

	/**
	 * @return the uI_PT_IL_DEPOSIT_CF
	 */
	public String getUI_PT_IL_DEPOSIT_CF() {
		return UI_PT_IL_DEPOSIT_CF;
	}

	/**
	 * @param ui_pt_il_deposit_cf the uI_PT_IL_DEPOSIT_CF to set
	 */
	public void setUI_PT_IL_DEPOSIT_CF(String ui_pt_il_deposit_cf) {
		UI_PT_IL_DEPOSIT_CF = ui_pt_il_deposit_cf;
	}

	/**
	 * @return the uI_PT_IL_PYMT_DTLS_CF
	 */
	public String getUI_PT_IL_PYMT_DTLS_CF() {
		return UI_PT_IL_PYMT_DTLS_CF;
	}

	/**
	 * @param ui_pt_il_pymt_dtls_cf the uI_PT_IL_PYMT_DTLS_CF to set
	 */
	public void setUI_PT_IL_PYMT_DTLS_CF(String ui_pt_il_pymt_dtls_cf) {
		UI_PT_IL_PYMT_DTLS_CF = ui_pt_il_pymt_dtls_cf;
	}

	/**
	 * @return the uI_M_DEL_FLAG
	 */
	public String getUI_M_DEL_FLAG() {
		return UI_M_DEL_FLAG;
	}

	/**
	 * @param ui_m_del_flag the uI_M_DEL_FLAG to set
	 */
	public void setUI_M_DEL_FLAG(String ui_m_del_flag) {
		UI_M_DEL_FLAG = ui_m_del_flag;
	}


}
