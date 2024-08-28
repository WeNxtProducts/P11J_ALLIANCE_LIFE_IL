package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_PART_CUST_DETL")
public class PT_IL_FAC_PART_CUST_DETL extends BaseValueBean {

	@Column(name="FPCUD_SYS_ID")
	private Double FPCUD_SYS_ID;
	
	@Column(name="FPCUD_FO_SYS_ID")
	private Double FPCUD_FO_SYS_ID;
	
	@Column(name="FPCUD_FPCU_SYS_ID")
	private Double FPCUD_FPCU_SYS_ID;
	
	@Column(name="FPCUD_FD_SYS_ID")
	private Double FPCUD_FD_SYS_ID;
	
	@Column(name="FPCUD_SA_CURR_CODE")
	private String FPCUD_SA_CURR_CODE;
	
	@Column(name="FPCUD_FC_SUM_ASSURED")
	private Double FPCUD_FC_SUM_ASSURED;

	@Column(name="FPCUD_LC_SUM_ASSURED")
	private Double FPCUD_LC_SUM_ASSURED;
	
	@Column(name="FPCUD_FC_PREM")
	private Double FPCUD_FC_PREM;

	@Column(name="FPCUD_LC_PREM")
	private Double FPCUD_LC_PREM;

	@Column(name="FPCUD_FC_COMM")
	private Double FPCUD_FC_COMM;

	@Column(name="FPCUD_LC_COMM")
	private Double FPCUD_LC_COMM;
	
	@Column(name="FPCUD_FC_TAX")
	private Double FPCUD_FC_TAX;

	@Column(name="FPCUD_LC_TAX")
	private Double FPCUD_LC_TAX;
	
	@Column(name="FPCUD_FC_RETRO_SUM_ASSURED")
	private Double FPCUD_FC_RETRO_SUM_ASSURED;
	
	@Column(name="FPCUD_LC_RETRO_SUM_ASSURED")
	private Double FPCUD_LC_RETRO_SUM_ASSURED;
	
	@Column(name="FPCUD_FC_RETRO_PREM")
	private Double FPCUD_FC_RETRO_PREM;

	@Column(name="FPCUD_LC_RETRO_PREM")
	private Double FPCUD_LC_RETRO_PREM;

	@Column(name="FPCUD_FC_RETRO_COMM")
	private Double FPCUD_FC_RETRO_COMM;

	@Column(name="FPCUD_LC_RETRO_COMM")
	private Double FPCUD_LC_RETRO_COMM;
	
	@Column(name="FPCUD_FC_RETRO_TAX")
	private Double FPCUD_FC_RETRO_TAX;

	@Column(name="FPCUD_LC_RETRO_TAX")
	private Double FPCUD_LC_RETRO_TAX;
	
	@Column(name="FPCUD_SCHD_DT")
	private Date FPCUD_SCHD_DT;
	
	@Column(name="FPCUD_FAC_CLOSE_YN")
	private String FPCUD_FAC_CLOSE_YN;
	
	@Column(name="FPCUD_DEL_FLAG")
	private String FPCUD_DEL_FLAG;
	 
	@Column(name="FPCUD_CR_DT")
	private Date FPCUD_CR_DT;
	
	@Column(name="FPCUD_CR_UID")
	private String FPCUD_CR_UID;
	
	@Column(name="FPCUD_UPD_DT")
	private Date FPCUD_UPD_DT;
	
	@Column(name="FPCUD_UPD_UID")
	private String FPCUD_UPD_UID;

	private boolean CHECK_BOX;

	public Double getFPCUD_FC_SUM_ASSURED() {
		return FPCUD_FC_SUM_ASSURED;
	}

	public void setFPCUD_FC_SUM_ASSURED(Double FPCUD_FC_SUM_ASSURED) {
		this.FPCUD_FC_SUM_ASSURED = FPCUD_FC_SUM_ASSURED;
	}

	public Double getFPCUD_FC_PREM() {
		return FPCUD_FC_PREM;
	}

	public void setFPCUD_FC_PREM(Double FPCUD_FC_PREM) {
		this.FPCUD_FC_PREM = FPCUD_FC_PREM;
	}

	public Double getFPCUD_FC_COMM() {
		return FPCUD_FC_COMM;
	}

	public void setFPCUD_FC_COMM(Double FPCUD_FC_COMM) {
		this.FPCUD_FC_COMM = FPCUD_FC_COMM;
	}

	public Double getFPCUD_FC_TAX() {
		return FPCUD_FC_TAX;
	}

	public void setFPCUD_FC_TAX(Double FPCUD_FC_TAX) {
		this.FPCUD_FC_TAX = FPCUD_FC_TAX;
	}

	public Date getFPCUD_SCHD_DT() {
		 return FPCUD_SCHD_DT;
	}

	public void setFPCUD_SCHD_DT(Date FPCUD_SCHD_DT) {
		this.FPCUD_SCHD_DT = FPCUD_SCHD_DT;
	}

	public Double getFPCUD_LC_SUM_ASSURED() {
		return FPCUD_LC_SUM_ASSURED;
	}

	public void setFPCUD_LC_SUM_ASSURED(Double FPCUD_LC_SUM_ASSURED) {
		this.FPCUD_LC_SUM_ASSURED = FPCUD_LC_SUM_ASSURED;
	}

	public Double getFPCUD_LC_COMM() {
		return FPCUD_LC_COMM;
	}

	public void setFPCUD_LC_COMM(Double FPCUD_LC_COMM) {
		this.FPCUD_LC_COMM = FPCUD_LC_COMM;
	}

	public Double getFPCUD_LC_PREM() {
		return FPCUD_LC_PREM;
	}

	public void setFPCUD_LC_PREM(Double FPCUD_LC_PREM) {
		this.FPCUD_LC_PREM = FPCUD_LC_PREM;
	}

	public Double getFPCUD_LC_TAX() {
		return FPCUD_LC_TAX;
	}

	public void setFPCUD_LC_TAX(Double FPCUD_LC_TAX) {
		this.FPCUD_LC_TAX = FPCUD_LC_TAX;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getFPCUD_SYS_ID() {
		return FPCUD_SYS_ID;
	}

	public void setFPCUD_SYS_ID(Double fpcud_sys_id) {
		FPCUD_SYS_ID = fpcud_sys_id;
	}

	public Double getFPCUD_FO_SYS_ID() {
		return FPCUD_FO_SYS_ID;
	}

	public void setFPCUD_FO_SYS_ID(Double fpcud_fo_sys_id) {
		FPCUD_FO_SYS_ID = fpcud_fo_sys_id;
	}

	public Double getFPCUD_FPCU_SYS_ID() {
		return FPCUD_FPCU_SYS_ID;
	}

	public void setFPCUD_FPCU_SYS_ID(Double fpcud_fpcu_sys_id) {
		FPCUD_FPCU_SYS_ID = fpcud_fpcu_sys_id;
	}

	public Double getFPCUD_FD_SYS_ID() {
		return FPCUD_FD_SYS_ID;
	}

	public void setFPCUD_FD_SYS_ID(Double fpcud_fd_sys_id) {
		FPCUD_FD_SYS_ID = fpcud_fd_sys_id;
	}

	public String getFPCUD_SA_CURR_CODE() {
		return FPCUD_SA_CURR_CODE;
	}

	public void setFPCUD_SA_CURR_CODE(String fpcud_sa_curr_code) {
		FPCUD_SA_CURR_CODE = fpcud_sa_curr_code;
	}

	public Double getFPCUD_FC_RETRO_SUM_ASSURED() {
		return FPCUD_FC_RETRO_SUM_ASSURED;
	}

	public void setFPCUD_FC_RETRO_SUM_ASSURED(Double fpcud_fc_retro_sum_assured) {
		FPCUD_FC_RETRO_SUM_ASSURED = fpcud_fc_retro_sum_assured;
	}

	public Double getFPCUD_LC_RETRO_SUM_ASSURED() {
		return FPCUD_LC_RETRO_SUM_ASSURED;
	}

	public void setFPCUD_LC_RETRO_SUM_ASSURED(Double fpcud_lc_retro_sum_assured) {
		FPCUD_LC_RETRO_SUM_ASSURED = fpcud_lc_retro_sum_assured;
	}

	public Double getFPCUD_FC_RETRO_PREM() {
		return FPCUD_FC_RETRO_PREM;
	}

	public void setFPCUD_FC_RETRO_PREM(Double fpcud_fc_retro_prem) {
		FPCUD_FC_RETRO_PREM = fpcud_fc_retro_prem;
	}

	public Double getFPCUD_LC_RETRO_PREM() {
		return FPCUD_LC_RETRO_PREM;
	}

	public void setFPCUD_LC_RETRO_PREM(Double fpcud_lc_retro_prem) {
		FPCUD_LC_RETRO_PREM = fpcud_lc_retro_prem;
	}

	public Double getFPCUD_FC_RETRO_COMM() {
		return FPCUD_FC_RETRO_COMM;
	}

	public void setFPCUD_FC_RETRO_COMM(Double fpcud_fc_retro_comm) {
		FPCUD_FC_RETRO_COMM = fpcud_fc_retro_comm;
	}

	public Double getFPCUD_LC_RETRO_COMM() {
		return FPCUD_LC_RETRO_COMM;
	}

	public void setFPCUD_LC_RETRO_COMM(Double fpcud_lc_retro_comm) {
		FPCUD_LC_RETRO_COMM = fpcud_lc_retro_comm;
	}

	public Double getFPCUD_FC_RETRO_TAX() {
		return FPCUD_FC_RETRO_TAX;
	}

	public void setFPCUD_FC_RETRO_TAX(Double fpcud_fc_retro_tax) {
		FPCUD_FC_RETRO_TAX = fpcud_fc_retro_tax;
	}

	public Double getFPCUD_LC_RETRO_TAX() {
		return FPCUD_LC_RETRO_TAX;
	}

	public void setFPCUD_LC_RETRO_TAX(Double fpcud_lc_retro_tax) {
		FPCUD_LC_RETRO_TAX = fpcud_lc_retro_tax;
	}

	public String getFPCUD_FAC_CLOSE_YN() {
		return FPCUD_FAC_CLOSE_YN;
	}

	public void setFPCUD_FAC_CLOSE_YN(String fpcud_fac_close_yn) {
		FPCUD_FAC_CLOSE_YN = fpcud_fac_close_yn;
	}

	public String getFPCUD_DEL_FLAG() {
		return FPCUD_DEL_FLAG;
	}

	public void setFPCUD_DEL_FLAG(String fpcud_del_flag) {
		FPCUD_DEL_FLAG = fpcud_del_flag;
	}

	public Date getFPCUD_CR_DT() {
		return FPCUD_CR_DT;
	}

	public void setFPCUD_CR_DT(Date fpcud_cr_dt) {
		FPCUD_CR_DT = fpcud_cr_dt;
	}

	public String getFPCUD_CR_UID() {
		return FPCUD_CR_UID;
	}

	public void setFPCUD_CR_UID(String fpcud_cr_uid) {
		FPCUD_CR_UID = fpcud_cr_uid;
	}

	public Date getFPCUD_UPD_DT() {
		return FPCUD_UPD_DT;
	}

	public void setFPCUD_UPD_DT(Date fpcud_upd_dt) {
		FPCUD_UPD_DT = fpcud_upd_dt;
	}

	public String getFPCUD_UPD_UID() {
		return FPCUD_UPD_UID;
	}

	public void setFPCUD_UPD_UID(String fpcud_upd_uid) {
		FPCUD_UPD_UID = fpcud_upd_uid;
	}
}
