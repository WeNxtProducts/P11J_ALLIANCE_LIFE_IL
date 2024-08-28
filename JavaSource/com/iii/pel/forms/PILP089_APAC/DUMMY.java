package com.iii.pel.forms.PILP089_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	@Column(name="UI_M_DECL_NO")
	private String UI_M_DECL_NO;

	private String UI_M_PROD_CODE_FM;

	private String UI_M_PROD_CODE_TO;
	
	private String UI_M_POLICY_FM;
	
	private String UI_M_POLICY_TO;
	
	private Integer UI_M_ACNT_YEAR_FM;
	
	private Integer UI_M_ACNT_YEAR_TO;
	
	private Date UI_M_ACNT_FM_DATE_1;
	
	private Date UI_M_ACNT_TO_DATE_1;
	
	private Date UI_M_ACNT_FM_DATE_2;
	
	private Date UI_M_ACNT_TO_DATE_2;
	
	private Date UI_M_PROCESS_DT;
	
	public String getUI_M_DECL_NO() {
		return UI_M_DECL_NO;
	}

	public void setUI_M_DECL_NO(String UI_M_DECL_NO) {
		this.UI_M_DECL_NO = UI_M_DECL_NO;
	}

	/**
	 * @return the uI_M_PROD_CODE_FM
	 */
	public String getUI_M_PROD_CODE_FM() {
		return UI_M_PROD_CODE_FM;
	}

	/**
	 * @param ui_m_prod_code_fm the uI_M_PROD_CODE_FM to set
	 */
	public void setUI_M_PROD_CODE_FM(String ui_m_prod_code_fm) {
		UI_M_PROD_CODE_FM = ui_m_prod_code_fm;
	}

	/**
	 * @return the uI_M_PROD_CODE_TO
	 */
	public String getUI_M_PROD_CODE_TO() {
		return UI_M_PROD_CODE_TO;
	}

	/**
	 * @param ui_m_prod_code_to the uI_M_PROD_CODE_TO to set
	 */
	public void setUI_M_PROD_CODE_TO(String ui_m_prod_code_to) {
		UI_M_PROD_CODE_TO = ui_m_prod_code_to;
	}

	/**
	 * @return the uI_M_POLICY_FM
	 */
	public String getUI_M_POLICY_FM() {
		return UI_M_POLICY_FM;
	}

	/**
	 * @param ui_m_policy_fm the uI_M_POLICY_FM to set
	 */
	public void setUI_M_POLICY_FM(String ui_m_policy_fm) {
		UI_M_POLICY_FM = ui_m_policy_fm;
	}

	/**
	 * @return the uI_M_POLICY_TO
	 */
	public String getUI_M_POLICY_TO() {
		return UI_M_POLICY_TO;
	}

	/**
	 * @param ui_m_policy_to the uI_M_POLICY_TO to set
	 */
	public void setUI_M_POLICY_TO(String ui_m_policy_to) {
		UI_M_POLICY_TO = ui_m_policy_to;
	}

	/**
	 * @return the uI_M_ACNT_YEAR_FM
	 */
	public Integer getUI_M_ACNT_YEAR_FM() {
		return UI_M_ACNT_YEAR_FM;
	}

	/**
	 * @param ui_m_acnt_year_fm the uI_M_ACNT_YEAR_FM to set
	 */
	public void setUI_M_ACNT_YEAR_FM(Integer ui_m_acnt_year_fm) {
		UI_M_ACNT_YEAR_FM = ui_m_acnt_year_fm;
	}

	/**
	 * @return the uI_M_ACNT_YEAR_TO
	 */
	public Integer getUI_M_ACNT_YEAR_TO() {
		return UI_M_ACNT_YEAR_TO;
	}

	/**
	 * @param ui_m_acnt_year_to the uI_M_ACNT_YEAR_TO to set
	 */
	public void setUI_M_ACNT_YEAR_TO(Integer ui_m_acnt_year_to) {
		UI_M_ACNT_YEAR_TO = ui_m_acnt_year_to;
	}

	
	public Date getUI_M_ACNT_FM_DATE_1() {
		return UI_M_ACNT_FM_DATE_1;
	}

	public void setUI_M_ACNT_FM_DATE_1(Date ui_m_acnt_fm_date_1) {
		UI_M_ACNT_FM_DATE_1 = ui_m_acnt_fm_date_1;
	}

	public Date getUI_M_ACNT_TO_DATE_1() {
		return UI_M_ACNT_TO_DATE_1;
	}

	public void setUI_M_ACNT_TO_DATE_1(Date ui_m_acnt_to_date_1) {
		UI_M_ACNT_TO_DATE_1 = ui_m_acnt_to_date_1;
	}

	public Date getUI_M_ACNT_FM_DATE_2() {
		return UI_M_ACNT_FM_DATE_2;
	}

	public void setUI_M_ACNT_FM_DATE_2(Date ui_m_acnt_fm_date_2) {
		UI_M_ACNT_FM_DATE_2 = ui_m_acnt_fm_date_2;
	}

	public Date getUI_M_ACNT_TO_DATE_2() {
		return UI_M_ACNT_TO_DATE_2;
	}

	public void setUI_M_ACNT_TO_DATE_2(Date ui_m_acnt_to_date_2) {
		UI_M_ACNT_TO_DATE_2 = ui_m_acnt_to_date_2;
	}

	/**
	 * @return the uI_M_PROCESS_DT
	 */
	public Date getUI_M_PROCESS_DT() {
		return UI_M_PROCESS_DT;
	}

	/**
	 * @param ui_m_process_dt the uI_M_PROCESS_DT to set
	 */
	public void setUI_M_PROCESS_DT(Date ui_m_process_dt) {
		UI_M_PROCESS_DT = ui_m_process_dt;
	}
}