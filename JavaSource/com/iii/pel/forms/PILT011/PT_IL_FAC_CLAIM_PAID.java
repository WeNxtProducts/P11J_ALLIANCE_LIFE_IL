package com.iii.pel.forms.PILT011;

import java.sql.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_CLAIM_PAID")
public class PT_IL_FAC_CLAIM_PAID extends BaseValueBean {

	private String UI_M_POL_NO_2;

	private String UI_M_CLM_NO_2;

	private String UI_M_COVER_CODE;

	private String UI_M_COVER_DESC_2;

	@Column(name="FCP_CP_PAID_DT")
	private Date FCP_CP_PAID_DT;

	private String UI_M_CUST_NAME_2;

	private String UI_M_CURR_CODE;

	private String UI_M_CURR_DESC_2;

	private String FCP_CR_UID;
	private Date FCP_CR_DT;
	private String FCP_SYS_ID;
	private Long FCP_FCE_SYS_ID;
	private String M_COVER_CODE;
	private String M_CURR_CODE;
	private String M_COVER_DESC_2;
	private String M_CURR_DESC_2;
	
	public String getM_COVER_DESC_2() {
		return M_COVER_DESC_2;
	}

	public void setM_COVER_DESC_2(String m_cover_desc_2) {
		M_COVER_DESC_2 = m_cover_desc_2;
	}

	public String getM_CURR_DESC_2() {
		return M_CURR_DESC_2;
	}

	public void setM_CURR_DESC_2(String m_curr_desc_2) {
		M_CURR_DESC_2 = m_curr_desc_2;
	}

	public Long getFCP_FCE_SYS_ID() {
		return FCP_FCE_SYS_ID;
	}

	public void setFCP_FCE_SYS_ID(Long fcp_fce_sys_id) {
		FCP_FCE_SYS_ID = fcp_fce_sys_id;
	}

	public String getFCP_CR_UID() {
		return FCP_CR_UID;
	}

	public void setFCP_CR_UID(String fcp_cr_uid) {
		FCP_CR_UID = fcp_cr_uid;
	}

	public Date getFCP_CR_DT() {
		return FCP_CR_DT;
	}

	public void setFCP_CR_DT(Date fcp_cr_dt) {
		FCP_CR_DT = fcp_cr_dt;
	}

	public String getUI_M_POL_NO_2() {
		return UI_M_POL_NO_2;
	}

	public void setUI_M_POL_NO_2(String UI_M_POL_NO_2) {
		this.UI_M_POL_NO_2 = UI_M_POL_NO_2;
	}

	public String getUI_M_CLM_NO_2() {
		return UI_M_CLM_NO_2;
	}

	public void setUI_M_CLM_NO_2(String UI_M_CLM_NO_2) {
		this.UI_M_CLM_NO_2 = UI_M_CLM_NO_2;
	}

	public String getUI_M_COVER_CODE() {
		return UI_M_COVER_CODE;
	}

	public void setUI_M_COVER_CODE(String UI_M_COVER_CODE) {
		this.UI_M_COVER_CODE = UI_M_COVER_CODE;
	}

	public String getUI_M_COVER_DESC_2() {
		return UI_M_COVER_DESC_2;
	}

	public void setUI_M_COVER_DESC_2(String UI_M_COVER_DESC_2) {
		this.UI_M_COVER_DESC_2 = UI_M_COVER_DESC_2;
	}

	public Date getFCP_CP_PAID_DT() {
		 return FCP_CP_PAID_DT;
	}

	public void setFCP_CP_PAID_DT(Date FCP_CP_PAID_DT) {
		this.FCP_CP_PAID_DT = FCP_CP_PAID_DT;
	}

	public String getUI_M_CUST_NAME_2() {
		return UI_M_CUST_NAME_2;
	}

	public void setUI_M_CUST_NAME_2(String UI_M_CUST_NAME_2) {
		this.UI_M_CUST_NAME_2 = UI_M_CUST_NAME_2;
	}

	public String getUI_M_CURR_CODE() {
		return UI_M_CURR_CODE;
	}

	public void setUI_M_CURR_CODE(String UI_M_CURR_CODE) {
		this.UI_M_CURR_CODE = UI_M_CURR_CODE;
	}

	public String getUI_M_CURR_DESC_2() {
		return UI_M_CURR_DESC_2;
	}

	public void setUI_M_CURR_DESC_2(String UI_M_CURR_DESC_2) {
		this.UI_M_CURR_DESC_2 = UI_M_CURR_DESC_2;
	}

	public String getM_COVER_CODE() {
		return M_COVER_CODE;
	}

	public void setM_COVER_CODE(String m_cover_code) {
		M_COVER_CODE = m_cover_code;
	}

	public String getM_CURR_CODE() {
		return M_CURR_CODE;
	}

	public void setM_CURR_CODE(String m_curr_code) {
		M_CURR_CODE = m_curr_code;
	}

	public String getFCP_SYS_ID() {
		return FCP_SYS_ID;
	}

	public void setFCP_SYS_ID(String fcp_sys_id) {
		FCP_SYS_ID = fcp_sys_id;
	}
}
