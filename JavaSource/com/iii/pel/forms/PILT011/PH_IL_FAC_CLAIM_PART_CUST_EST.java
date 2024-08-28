package com.iii.pel.forms.PILT011;

import java.sql.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PH_IL_FAC_CLAIM_PART_CUST_EST")
public class PH_IL_FAC_CLAIM_PART_CUST_EST extends BaseValueBean {

	@Column(name="FCPCEH_CUST_CODE")
	private String FCPCEH_CUST_CODE;

	@Column(name="FCPCEH_O_FAC_PERC")
	private Double FCPCEH_O_FAC_PERC;

	@Column(name="FCPCEH_O_FC_CLM_EST")
	private Double FCPCEH_O_FC_CLM_EST;

	@Column(name="FCPCEH_O_RETRO_PERC")
	private Double FCPCEH_O_RETRO_PERC;

	@Column(name="FCPCEH_O_RETRO_FC_CLM_EST")
	private Double FCPCEH_O_RETRO_FC_CLM_EST;

	@Column(name="FCPCEH_O_LC_CLM_EST")
	private Double FCPCEH_O_LC_CLM_EST;
	
	@Column(name="FCPCEH_SYS_ID")
	private Long FCPCEH_SYS_ID;
	
	@Column(name="FCPCEH_FPCU_SYS_ID")
	private Long FCPCEH_FPCU_SYS_ID;
	
	@Column(name="FCPCEH_N_FAC_PERC")
	private Double FCPCEH_N_FAC_PERC;
	
	@Column(name="FCPCEH_N_FC_CLM_EST")
	private Double FCPCEH_N_FC_CLM_EST;
	
	@Column(name="FCPCEH_N_RETRO_PERC")
	private Double FCPCEH_N_RETRO_PERC;
	
	@Column(name="FCPCEH_N_RETRO_FC_CLM_EST")
	private Double FCPCEH_N_RETRO_FC_CLM_EST;
	
	@Column(name="FCPCEH_N_RETRO_LC_CLM_EST")
	private Double FCPCEH_N_RETRO_LC_CLM_EST;
	
	@Column(name="FCPCEH_N_LC_CLM_EST")
	private Double FCPCEH_N_LC_CLM_EST;
	
	@Column(name="FCPCEH_CR_UID")
	private String FCPCEH_CR_UID;
	
	@Column(name="FCPCEH_CR_DT")
	private Date FCPCEH_CR_DT;
	
	@Column(name="FCPCEH_CCD_RESERVE_NO")
	private Integer FCPCEH_CCD_RESERVE_NO;

	private String UI_M_CUST_NAME;

	@Column(name="FCPCEH_O_RETRO_LC_CLM_EST")
	private Double FCPCEH_O_RETRO_LC_CLM_EST;

	private String UI_M_CURR_CODE_DESC;
	
	@Column(name="FCPCEH_FCE_SYS_ID")
	private Long FCPCEH_FCE_SYS_ID;
	
	private String FCPCP_CUST_CODE;
	
	private boolean CHECK_BOX;
	
	private Double FCEH_CCD_RESERVE_NO;
	
	private String FCEH_CLAIM_CURR_CODE;
	
	private Date FCEH_O_CCD_RESERVE_DT;
	
	public Double getFCEH_CCD_RESERVE_NO() {
		return FCEH_CCD_RESERVE_NO;
	}

	public void setFCEH_CCD_RESERVE_NO(Double fceh_ccd_reserve_no) {
		FCEH_CCD_RESERVE_NO = fceh_ccd_reserve_no;
	}

	public String getFCEH_CLAIM_CURR_CODE() {
		return FCEH_CLAIM_CURR_CODE;
	}

	public void setFCEH_CLAIM_CURR_CODE(String fceh_claim_curr_code) {
		FCEH_CLAIM_CURR_CODE = fceh_claim_curr_code;
	}

	public Date getFCEH_O_CCD_RESERVE_DT() {
		return FCEH_O_CCD_RESERVE_DT;
	}

	public void setFCEH_O_CCD_RESERVE_DT(Date fceh_o_ccd_reserve_dt) {
		FCEH_O_CCD_RESERVE_DT = fceh_o_ccd_reserve_dt;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getFCPCEH_CUST_CODE() {
		return FCPCEH_CUST_CODE;
	}

	public void setFCPCEH_CUST_CODE(String FCPCEH_CUST_CODE) {
		this.FCPCEH_CUST_CODE = FCPCEH_CUST_CODE;
	}

	public Double getFCPCEH_O_FAC_PERC() {
		return FCPCEH_O_FAC_PERC;
	}

	public void setFCPCEH_O_FAC_PERC(Double FCPCEH_O_FAC_PERC) {
		this.FCPCEH_O_FAC_PERC = FCPCEH_O_FAC_PERC;
	}

	public Double getFCPCEH_O_FC_CLM_EST() {
		return FCPCEH_O_FC_CLM_EST;
	}

	public void setFCPCEH_O_FC_CLM_EST(Double FCPCEH_O_FC_CLM_EST) {
		this.FCPCEH_O_FC_CLM_EST = FCPCEH_O_FC_CLM_EST;
	}

	public Double getFCPCEH_O_RETRO_PERC() {
		return FCPCEH_O_RETRO_PERC;
	}

	public void setFCPCEH_O_RETRO_PERC(Double FCPCEH_O_RETRO_PERC) {
		this.FCPCEH_O_RETRO_PERC = FCPCEH_O_RETRO_PERC;
	}

	public Double getFCPCEH_O_RETRO_FC_CLM_EST() {
		return FCPCEH_O_RETRO_FC_CLM_EST;
	}

	public void setFCPCEH_O_RETRO_FC_CLM_EST(Double FCPCEH_O_RETRO_FC_CLM_EST) {
		this.FCPCEH_O_RETRO_FC_CLM_EST = FCPCEH_O_RETRO_FC_CLM_EST;
	}

	public Double getFCPCEH_O_LC_CLM_EST() {
		return FCPCEH_O_LC_CLM_EST;
	}

	public void setFCPCEH_O_LC_CLM_EST(Double FCPCEH_O_LC_CLM_EST) {
		this.FCPCEH_O_LC_CLM_EST = FCPCEH_O_LC_CLM_EST;
	}

	public String getUI_M_CUST_NAME() {
		return UI_M_CUST_NAME;
	}

	public void setUI_M_CUST_NAME(String UI_M_CUST_NAME) {
		this.UI_M_CUST_NAME = UI_M_CUST_NAME;
	}

	public Double getFCPCEH_O_RETRO_LC_CLM_EST() {
		return FCPCEH_O_RETRO_LC_CLM_EST;
	}

	public void setFCPCEH_O_RETRO_LC_CLM_EST(Double FCPCEH_O_RETRO_LC_CLM_EST) {
		this.FCPCEH_O_RETRO_LC_CLM_EST = FCPCEH_O_RETRO_LC_CLM_EST;
	}

	public String getUI_M_CURR_CODE_DESC() {
		return UI_M_CURR_CODE_DESC;
	}

	public void setUI_M_CURR_CODE_DESC(String UI_M_CURR_CODE_DESC) {
		this.UI_M_CURR_CODE_DESC = UI_M_CURR_CODE_DESC;
	}


	public Long getFCPCEH_FCE_SYS_ID() {
		return FCPCEH_FCE_SYS_ID;
	}

	public void setFCPCEH_FCE_SYS_ID(Long fcpceh_fce_sys_id) {
		FCPCEH_FCE_SYS_ID = fcpceh_fce_sys_id;
	}

	public String getFCPCP_CUST_CODE() {
		return FCPCP_CUST_CODE;
	}

	public void setFCPCP_CUST_CODE(String fcpcp_cust_code) {
		FCPCP_CUST_CODE = fcpcp_cust_code;
	}

	public Long getFCPCEH_SYS_ID() {
		return FCPCEH_SYS_ID;
	}

	public void setFCPCEH_SYS_ID(Long fcpceh_sys_id) {
		FCPCEH_SYS_ID = fcpceh_sys_id;
	}

	public Long getFCPCEH_FPCU_SYS_ID() {
		return FCPCEH_FPCU_SYS_ID;
	}

	public void setFCPCEH_FPCU_SYS_ID(Long fcpceh_fpcu_sys_id) {
		FCPCEH_FPCU_SYS_ID = fcpceh_fpcu_sys_id;
	}

	public Double getFCPCEH_N_FAC_PERC() {
		return FCPCEH_N_FAC_PERC;
	}

	public void setFCPCEH_N_FAC_PERC(Double fcpceh_n_fac_perc) {
		FCPCEH_N_FAC_PERC = fcpceh_n_fac_perc;
	}

	public Double getFCPCEH_N_FC_CLM_EST() {
		return FCPCEH_N_FC_CLM_EST;
	}

	public void setFCPCEH_N_FC_CLM_EST(Double fcpceh_n_fc_clm_est) {
		FCPCEH_N_FC_CLM_EST = fcpceh_n_fc_clm_est;
	}

	public Double getFCPCEH_N_RETRO_PERC() {
		return FCPCEH_N_RETRO_PERC;
	}

	public void setFCPCEH_N_RETRO_PERC(Double fcpceh_n_retro_perc) {
		FCPCEH_N_RETRO_PERC = fcpceh_n_retro_perc;
	}

	public Double getFCPCEH_N_RETRO_FC_CLM_EST() {
		return FCPCEH_N_RETRO_FC_CLM_EST;
	}

	public void setFCPCEH_N_RETRO_FC_CLM_EST(Double fcpceh_n_retro_fc_clm_est) {
		FCPCEH_N_RETRO_FC_CLM_EST = fcpceh_n_retro_fc_clm_est;
	}

	public Double getFCPCEH_N_RETRO_LC_CLM_EST() {
		return FCPCEH_N_RETRO_LC_CLM_EST;
	}

	public void setFCPCEH_N_RETRO_LC_CLM_EST(Double fcpceh_n_retro_lc_clm_est) {
		FCPCEH_N_RETRO_LC_CLM_EST = fcpceh_n_retro_lc_clm_est;
	}

	public String getFCPCEH_CR_UID() {
		return FCPCEH_CR_UID;
	}

	public void setFCPCEH_CR_UID(String fcpceh_cr_uid) {
		FCPCEH_CR_UID = fcpceh_cr_uid;
	}

	public Date getFCPCEH_CR_DT() {
		return FCPCEH_CR_DT;
	}

	public void setFCPCEH_CR_DT(Date fcpceh_cr_dt) {
		FCPCEH_CR_DT = fcpceh_cr_dt;
	}


	public Integer getFCPCEH_CCD_RESERVE_NO() {
		return FCPCEH_CCD_RESERVE_NO;
	}

	public void setFCPCEH_CCD_RESERVE_NO(Integer fcpceh_ccd_reserve_no) {
		FCPCEH_CCD_RESERVE_NO = fcpceh_ccd_reserve_no;
	}

	public Double getFCPCEH_N_LC_CLM_EST() {
		return FCPCEH_N_LC_CLM_EST;
	}

	public void setFCPCEH_N_LC_CLM_EST(Double fcpceh_n_lc_clm_est) {
		FCPCEH_N_LC_CLM_EST = fcpceh_n_lc_clm_est;
	}
}
