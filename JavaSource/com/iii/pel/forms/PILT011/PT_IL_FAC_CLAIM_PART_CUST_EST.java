package com.iii.pel.forms.PILT011;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_CLAIM_PART_CUST_EST")
public class PT_IL_FAC_CLAIM_PART_CUST_EST extends BaseValueBean{

	@Column(name="FCPCE_CUST_CODE")
	private String FCPCE_CUST_CODE;

	@Column(name="FCPCE_FAC_PERC")
	private Double FCPCE_FAC_PERC;

	@Column(name="FCPCE_FC_CLM_EST")
	private Double FCPCE_FC_CLM_EST;

	@Column(name="FCPCE_RETRO_PERC")
	private Double FCPCE_RETRO_PERC;

	@Column(name="FCPCE_RETRO_FC_CLM_EST")
	private Double FCPCE_RETRO_FC_CLM_EST;

	@Column(name="FCPCE_LC_CLM_EST")
	private Double FCPCE_LC_CLM_EST;

	@Column(name="FCPCE_RETRO_LC_CLM_EST")
	private Double FCPCE_RETRO_LC_CLM_EST;
	
	private boolean CHECK_BOX;
	
	@Id
	@Column(name="ROWID") 
	private String ROWID;

	@Column (name="FCPCE_UPD_UID")
	private String FCPCE_UPD_UID;
	
	@Column (name="FCPCE_UPD_DT")
	private Date FCPCE_UPD_DT;
	
	@Column (name="FCPCE_CR_UID")
	private String FCPCE_CR_UID;
	
	@Column (name="FCPCE_CR_DT")
	private Date FCPCE_CR_DT;
	
	@Column (name="M_CUST_NAME_1")
	private String M_CUST_NAME_1;
	
	@Column(name="FCPCE_SYS_ID")
	private Double FCPCE_SYS_ID;
	
	@Column(name="FCPCE_FCE_SYS_ID")
	private Double FCPCE_FCE_SYS_ID;
	
	@Column(name="FCPCE_FPCU_SYS_ID")
	private Double FCPCE_FPCU_SYS_ID;

	public String getM_CUST_NAME_1() {
		return M_CUST_NAME_1;
	}

	public void setM_CUST_NAME_1(String m_cust_name_1) {
		M_CUST_NAME_1 = m_cust_name_1;
	}

	public String getFCPCE_CUST_CODE() {
		return FCPCE_CUST_CODE;
	}

	public void setFCPCE_CUST_CODE(String FCPCE_CUST_CODE) {
		this.FCPCE_CUST_CODE = FCPCE_CUST_CODE;
	}

	public Double getFCPCE_FAC_PERC() {
		return FCPCE_FAC_PERC;
	}

	public void setFCPCE_FAC_PERC(Double FCPCE_FAC_PERC) {
		this.FCPCE_FAC_PERC = FCPCE_FAC_PERC;
	}

	public Double getFCPCE_FC_CLM_EST() {
		return FCPCE_FC_CLM_EST;
	}

	public void setFCPCE_FC_CLM_EST(Double FCPCE_FC_CLM_EST) {
		this.FCPCE_FC_CLM_EST = FCPCE_FC_CLM_EST;
	}

	public Double getFCPCE_RETRO_PERC() {
		return FCPCE_RETRO_PERC;
	}

	public void setFCPCE_RETRO_PERC(Double FCPCE_RETRO_PERC) {
		this.FCPCE_RETRO_PERC = FCPCE_RETRO_PERC;
	}

	public Double getFCPCE_RETRO_FC_CLM_EST() {
		return FCPCE_RETRO_FC_CLM_EST;
	}

	public void setFCPCE_RETRO_FC_CLM_EST(Double FCPCE_RETRO_FC_CLM_EST) {
		this.FCPCE_RETRO_FC_CLM_EST = FCPCE_RETRO_FC_CLM_EST;
	}

	public Double getFCPCE_LC_CLM_EST() {
		return FCPCE_LC_CLM_EST;
	}

	public void setFCPCE_LC_CLM_EST(Double FCPCE_LC_CLM_EST) {
		this.FCPCE_LC_CLM_EST = FCPCE_LC_CLM_EST;
	}

	public Double getFCPCE_RETRO_LC_CLM_EST() {
		return FCPCE_RETRO_LC_CLM_EST;
	}

	public void setFCPCE_RETRO_LC_CLM_EST(Double FCPCE_RETRO_LC_CLM_EST) {
		this.FCPCE_RETRO_LC_CLM_EST = FCPCE_RETRO_LC_CLM_EST;
	}

	public String getFCPCE_UPD_UID() {
		return FCPCE_UPD_UID;
	}

	public void setFCPCE_UPD_UID(String fcpce_upd_uid) {
		FCPCE_UPD_UID = fcpce_upd_uid;
	}

	public Date getFCPCE_UPD_DT() {
		return FCPCE_UPD_DT;
	}

	public void setFCPCE_UPD_DT(Date fcpce_upd_dt) {
		FCPCE_UPD_DT = fcpce_upd_dt;
	}

	public String getFCPCE_CR_UID() {
		return FCPCE_CR_UID;
	}

	public void setFCPCE_CR_UID(String fcpce_cr_uid) {
		FCPCE_CR_UID = fcpce_cr_uid;
	}

	public Date getFCPCE_CR_DT() {
		return FCPCE_CR_DT;
	}

	public void setFCPCE_CR_DT(Date fcpce_cr_dt) {
		FCPCE_CR_DT = fcpce_cr_dt;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Double getFCPCE_SYS_ID() {
		return FCPCE_SYS_ID;
	}

	public void setFCPCE_SYS_ID(Double fcpce_sys_id) {
		FCPCE_SYS_ID = fcpce_sys_id;
	}

	public Double getFCPCE_FCE_SYS_ID() {
		return FCPCE_FCE_SYS_ID;
	}

	public void setFCPCE_FCE_SYS_ID(Double fcpce_fce_sys_id) {
		FCPCE_FCE_SYS_ID = fcpce_fce_sys_id;
	}

	public Double getFCPCE_FPCU_SYS_ID() {
		return FCPCE_FPCU_SYS_ID;
	}

	public void setFCPCE_FPCU_SYS_ID(Double fcpce_fpcu_sys_id) {
		FCPCE_FPCU_SYS_ID = fcpce_fpcu_sys_id;
	}
}
