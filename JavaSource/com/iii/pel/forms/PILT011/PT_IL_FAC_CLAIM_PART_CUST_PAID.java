package com.iii.pel.forms.PILT011;


import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_CLAIM_PART_CUST_PAID")
public class PT_IL_FAC_CLAIM_PART_CUST_PAID extends BaseValueBean {

	@Column(name="FCPCP_CUST_CODE")
	private String FCPCP_CUST_CODE;

	private Double UI_M_SHARE_PERC;

	@Column(name="FCPCP_FC_CLM_PAID")
	private Double FCPCP_FC_CLM_PAID;

	private Double UI_M_RETRO_PERC;

	@Column(name="FCPCP_RETRO_FC_CLM_PAID")
	private Double FCPCP_RETRO_FC_CLM_PAID;

	@Column(name="FCPCP_LC_CLM_PAID")
	private Double FCPCP_LC_CLM_PAID;

	@Column(name="FCPCP_RETRO_LC_CLM_PAID")
	private Double FCPCP_RETRO_LC_CLM_PAID;
	
	private boolean CHECK_BOX;
	
	
	private String P_CUST_NAME;
	
	private String FCP_SYS_ID;
	
	private String FCPCP_CR_UID;
	
	private Date FCPCP_CR_DT;
	
	@Column(name="FCPCP_FCPCE_SYS_ID")
	private Long FCPCP_FCPCE_SYS_ID;
	
	
	@Column(name="FCPCP_SYS_ID")
	private Long FCPCP_SYS_ID;
	
	
	@Column(name="FCPCP_FCP_SYS_ID")
	private Long FCPCP_FCP_SYS_ID;
	
	
	@Column(name="FCPCP_CP_REF_SYS_ID")
	private Long FCPCP_CP_REF_SYS_ID;
	
	private String M_SHARE_PERC;
	private String M_RETRO_PERC;
	
	public String getM_SHARE_PERC() {
		return M_SHARE_PERC;
	}

	public void setM_SHARE_PERC(String m_share_perc) {
		M_SHARE_PERC = m_share_perc;
	}

	public String getM_RETRO_PERC() {
		return M_RETRO_PERC;
	}

	public void setM_RETRO_PERC(String m_retro_perc) {
		M_RETRO_PERC = m_retro_perc;
	}


	public Long getFCPCP_FCPCE_SYS_ID() {
		return FCPCP_FCPCE_SYS_ID;
	}

	public void setFCPCP_FCPCE_SYS_ID(Long fcpcp_fcpce_sys_id) {
		FCPCP_FCPCE_SYS_ID = fcpcp_fcpce_sys_id;
	}

	public String getFCP_SYS_ID() {
		return FCP_SYS_ID;
	}

	public void setFCP_SYS_ID(String fcp_sys_id) {
		FCP_SYS_ID = fcp_sys_id;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}


	public String getFCPCP_CUST_CODE() {
		return FCPCP_CUST_CODE;
	}

	public void setFCPCP_CUST_CODE(String FCPCP_CUST_CODE) {
		this.FCPCP_CUST_CODE = FCPCP_CUST_CODE;
	}

	public Double getUI_M_SHARE_PERC() {
		return UI_M_SHARE_PERC;
	}

	public void setUI_M_SHARE_PERC(Double UI_M_SHARE_PERC) {
		this.UI_M_SHARE_PERC = UI_M_SHARE_PERC;
	}

	public Double getFCPCP_FC_CLM_PAID() {
		return FCPCP_FC_CLM_PAID;
	}

	public void setFCPCP_FC_CLM_PAID(Double FCPCP_FC_CLM_PAID) {
		this.FCPCP_FC_CLM_PAID = FCPCP_FC_CLM_PAID;
	}

	public Double getUI_M_RETRO_PERC() {
		return UI_M_RETRO_PERC;
	}

	public void setUI_M_RETRO_PERC(Double UI_M_RETRO_PERC) {
		this.UI_M_RETRO_PERC = UI_M_RETRO_PERC;
	}

	public Double getFCPCP_RETRO_FC_CLM_PAID() {
		return FCPCP_RETRO_FC_CLM_PAID;
	}

	public void setFCPCP_RETRO_FC_CLM_PAID(Double FCPCP_RETRO_FC_CLM_PAID) {
		this.FCPCP_RETRO_FC_CLM_PAID = FCPCP_RETRO_FC_CLM_PAID;
	}

	public Double getFCPCP_LC_CLM_PAID() {
		return FCPCP_LC_CLM_PAID;
	}

	public void setFCPCP_LC_CLM_PAID(Double FCPCP_LC_CLM_PAID) {
		this.FCPCP_LC_CLM_PAID = FCPCP_LC_CLM_PAID;
	}

	public Double getFCPCP_RETRO_LC_CLM_PAID() {
		return FCPCP_RETRO_LC_CLM_PAID;
	}

	public void setFCPCP_RETRO_LC_CLM_PAID(Double FCPCP_RETRO_LC_CLM_PAID) {
		this.FCPCP_RETRO_LC_CLM_PAID = FCPCP_RETRO_LC_CLM_PAID;
	}

	public String getFCPCP_CR_UID() {
		return FCPCP_CR_UID;
	}

	public void setFCPCP_CR_UID(String fcpcp_cr_uid) {
		FCPCP_CR_UID = fcpcp_cr_uid;
	}

	public Date getFCPCP_CR_DT() {
		return FCPCP_CR_DT;
	}

	public void setFCPCP_CR_DT(Date fcpcp_cr_dt) {
		FCPCP_CR_DT = fcpcp_cr_dt;
	}

	public String getP_CUST_NAME() {
		return P_CUST_NAME;
	}

	public void setP_CUST_NAME(String p_cust_name) {
		P_CUST_NAME = p_cust_name;
	}

	public Long getFCPCP_SYS_ID() {
		return FCPCP_SYS_ID;
	}

	public void setFCPCP_SYS_ID(Long fcpcp_sys_id) {
		FCPCP_SYS_ID = fcpcp_sys_id;
	}

	public Long getFCPCP_FCP_SYS_ID() {
		return FCPCP_FCP_SYS_ID;
	}

	public void setFCPCP_FCP_SYS_ID(Long fcpcp_fcp_sys_id) {
		FCPCP_FCP_SYS_ID = fcpcp_fcp_sys_id;
	}

	public Long getFCPCP_CP_REF_SYS_ID() {
		return FCPCP_CP_REF_SYS_ID;
	}

	public void setFCPCP_CP_REF_SYS_ID(Long fcpcp_cp_ref_sys_id) {
		FCPCP_CP_REF_SYS_ID = fcpcp_cp_ref_sys_id;
	}
}
