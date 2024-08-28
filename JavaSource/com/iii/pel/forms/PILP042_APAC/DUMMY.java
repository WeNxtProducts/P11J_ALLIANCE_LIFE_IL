package com.iii.pel.forms.PILP042_APAC;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {
	
	private String UI_M_BASE_CURR;
	
	private String POL_CUST_EXCH_RATE;
	
	private String UI_M_APPRV_STATUS;
	
	private Date UI_M_APPRV_DT;
	
	private String UI_M_FTH_APPRV_USER_ID;
	
	private Date M_WD_STATUS_DT;
	
	private String M_WD_STATUS_CODE;
	
	private String M_WD_REASON_CODE;
	
	private String M_WD_REMARKS;
	
	private String M_WD_STATUS_CODE_DESC;
	
	private String M_WD_REASON_CODE_DESC;

	

	public Date getM_WD_STATUS_DT() {
		return M_WD_STATUS_DT;
	}

	public void setM_WD_STATUS_DT(Date m_wd_status_dt) {
		M_WD_STATUS_DT = m_wd_status_dt;
	}

	public String getM_WD_STATUS_CODE() {
		return M_WD_STATUS_CODE;
	}

	public void setM_WD_STATUS_CODE(String m_wd_status_code) {
		M_WD_STATUS_CODE = m_wd_status_code;
	}

	public String getM_WD_REASON_CODE() {
		return M_WD_REASON_CODE;
	}

	public void setM_WD_REASON_CODE(String m_wd_reason_code) {
		M_WD_REASON_CODE = m_wd_reason_code;
	}

	public String getM_WD_REMARKS() {
		return M_WD_REMARKS;
	}

	public void setM_WD_REMARKS(String m_wd_remarks) {
		M_WD_REMARKS = m_wd_remarks;
	}

	public String getM_WD_STATUS_CODE_DESC() {
		return M_WD_STATUS_CODE_DESC;
	}

	public void setM_WD_STATUS_CODE_DESC(String m_wd_status_code_desc) {
		M_WD_STATUS_CODE_DESC = m_wd_status_code_desc;
	}

	public String getM_WD_REASON_CODE_DESC() {
		return M_WD_REASON_CODE_DESC;
	}

	public void setM_WD_REASON_CODE_DESC(String m_wd_reason_code_desc) {
		M_WD_REASON_CODE_DESC = m_wd_reason_code_desc;
	}

	public String getUI_M_FTH_APPRV_USER_ID() {
		return UI_M_FTH_APPRV_USER_ID;
	}

	public void setUI_M_FTH_APPRV_USER_ID(String ui_m_fth_apprv_user_id) {
		UI_M_FTH_APPRV_USER_ID = ui_m_fth_apprv_user_id;
	}

	public Date getUI_M_APPRV_DT() {
		return UI_M_APPRV_DT;
	}

	public void setUI_M_APPRV_DT(Date ui_m_apprv_dt) {
		UI_M_APPRV_DT = ui_m_apprv_dt;
	}

	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}

	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}

	public String getPOL_CUST_EXCH_RATE() {
		return POL_CUST_EXCH_RATE;
	}

	public void setPOL_CUST_EXCH_RATE(String pol_cust_exch_rate) {
		POL_CUST_EXCH_RATE = pol_cust_exch_rate;
	}


}
