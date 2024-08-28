package com.iii.pel.forms.PILM035_APAC;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_APPL_SUB_PLAN")
public class PM_IL_PROD_APPL_SUB_PLAN extends BaseValueBean {

	@Column(name="PAP_SR_NO")
	private Integer PAP_SR_NO;

	@Column(name="PAP_SUB_PLAN_CODE")
	private String PAP_SUB_PLAN_CODE;

	@Column(name="PAP_PROD_CODE")
	private String PAP_PROD_CODE;
	
	private String UI_M_PAP_PROD_CODE_DESC; 
	
	private String UI_M_PAP_SUB_PLAN_CODE_DESC;
	
	public String getUI_M_PAP_SUB_PLAN_CODE_DESC() {
		return UI_M_PAP_SUB_PLAN_CODE_DESC;
	}

	public void setUI_M_PAP_SUB_PLAN_CODE_DESC(String ui_m_pap_sub_plan_code_desc) {
		UI_M_PAP_SUB_PLAN_CODE_DESC = ui_m_pap_sub_plan_code_desc;
	}

	public Integer getPAP_SR_NO() {
		return PAP_SR_NO;
	}

	public void setPAP_SR_NO(Integer pap_sr_no) {
		PAP_SR_NO = pap_sr_no;
	}

	public String getPAP_SUB_PLAN_CODE() {
		 return PAP_SUB_PLAN_CODE;
	}

	public void setPAP_SUB_PLAN_CODE(String PAP_SUB_PLAN_CODE) {
		this.PAP_SUB_PLAN_CODE = PAP_SUB_PLAN_CODE;
	}

	public String getPAP_PROD_CODE() {
		 return PAP_PROD_CODE;
	}

	public void setPAP_PROD_CODE(String PAP_PROD_CODE) {
		this.PAP_PROD_CODE = PAP_PROD_CODE;
	}
	
	private String UI_M_PAP_SUB_PLAN_CODE;



	public String getUI_M_PAP_SUB_PLAN_CODE() {
		return UI_M_PAP_SUB_PLAN_CODE;
	}

	public void setUI_M_PAP_SUB_PLAN_CODE(String ui_m_pap_sub_plan_code) {
		UI_M_PAP_SUB_PLAN_CODE = ui_m_pap_sub_plan_code;
	}

	public String getUI_M_PAP_PROD_CODE_DESC() {
		return UI_M_PAP_PROD_CODE_DESC;
	}

	public void setUI_M_PAP_PROD_CODE_DESC(String ui_m_pap_prod_code_desc) {
		UI_M_PAP_PROD_CODE_DESC = ui_m_pap_prod_code_desc;
	}
	
	
}
