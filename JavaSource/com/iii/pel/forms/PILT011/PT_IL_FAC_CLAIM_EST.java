package com.iii.pel.forms.PILT011;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_CLAIM_EST")
public class PT_IL_FAC_CLAIM_EST extends BaseValueBean {

	private String UI_M_POL_NO_1;

	private String UI_M_CLM_NO_1;

	@Column(name="FCE_CCD_COVER_CODE")
	private String FCE_CCD_COVER_CODE;

	private String UI_M_COVER_DESC_1;

	private String UI_M_CURR_DESC_1;
	
	@Column(name="FCE_CLAIM_CURR_CODE")
	private String FCE_CLAIM_CURR_CODE;
	
	@Column(name="FCE_CLAIM_SYS_ID")
	private Double FCE_CLAIM_SYS_ID;
	
	@Column(name="FCE_CCD_SYS_ID")
	private String FCE_CCD_SYS_ID;
	
	@Column(name="FCE_CLAIM_LOSS_DT")
	private Date FCE_CLAIM_LOSS_DT;
	
	@Column(name="FCE_FAC_FC_CLM_EST")
	private Double FCE_FAC_FC_CLM_EST;
	
	@Column(name="FCE_FAC_LC_CLM_EST")
	private Double FCE_FAC_LC_CLM_EST;
	
	@Column(name="FCE_RETRO_FC_CLM_EST")
	private Double FCE_RETRO_FC_CLM_EST;
	
	@Column(name="FCE_RETRO_LC_CLM_EST")
	private Double FCE_RETRO_LC_CLM_EST;
	
	@Column(name="FCE_CLAIM_CLOSE_FLAG")
	private String FCE_CLAIM_CLOSE_FLAG;
	
	@Column(name="FCE_ASSR_CODE")
	private String FCE_ASSR_CODE;
	
	@Column(name="FCE_CCD_RESERVE_DT")
	private Date FCE_CCD_RESERVE_DT;
	
	//Muthu Included...
	//PRE_FORM > DUMMY.M_POL_SYS_ID & DUMMY.M_CLM_SYS_ID
	
	private String M_POL_SYS_ID;
	private String M_CLM_SYS_ID;
	private String PT_IL_FAC_CLAIM_EST_CF;
	private String PT_IL_FAC_CLAIM_PAID_CF;
	private String PT_IL_FAC_CLAIM_PART_CUST_ES;
	private String PT_IL_FAC_CLAIM_PART_CUST_PA;
	private String M_COVER_CODE;
	private String M_POL_NO_2;
	private String M_CLM_NO_2;
	private String M_POL_NO_1;
	private String M_CLM_NO_1;
	private String M_CP_SYS_ID;
	
	private String FCE_CR_UID;
	private Date FCE_CR_DT;
	private Long FCE_SYS_ID;
	
	private String UI_M_FAC_REC;
	private String UI_M_RI_REC;

	public String getUI_M_RI_REC() {
		return UI_M_RI_REC;
	}

	public void setUI_M_RI_REC(String ui_m_ri_rec) {
		UI_M_RI_REC = ui_m_ri_rec;
	}

	public String getUI_M_FAC_REC() {
		return UI_M_FAC_REC;
	}

	public void setUI_M_FAC_REC(String ui_m_fac_rec) {
		UI_M_FAC_REC = ui_m_fac_rec;
	}

	public String getFCE_CR_UID() {
		return FCE_CR_UID;
	}

	public void setFCE_CR_UID(String fce_cr_uid) {
		FCE_CR_UID = fce_cr_uid;
	}

	

	public Long getFCE_SYS_ID() {
		return FCE_SYS_ID;
	}

	public void setFCE_SYS_ID(Long fce_sys_id) {
		FCE_SYS_ID = fce_sys_id;
	}

	public Date getFCE_CR_DT() {
		return FCE_CR_DT;
	}

	public void setFCE_CR_DT(Date fce_cr_dt) {
		FCE_CR_DT = fce_cr_dt;
	}

	public String getM_CP_SYS_ID() {
		return M_CP_SYS_ID;
	}

	public void setM_CP_SYS_ID(String m_cp_sys_id) {
		M_CP_SYS_ID = m_cp_sys_id;
	}

	public String getM_POL_NO_1() {
		return M_POL_NO_1;
	}

	public void setM_POL_NO_1(String m_pol_no_1) {
		M_POL_NO_1 = m_pol_no_1;
	}

	public String getM_CLM_NO_1() {
		return M_CLM_NO_1;
	}

	public void setM_CLM_NO_1(String m_clm_no_1) {
		M_CLM_NO_1 = m_clm_no_1;
	}

	public String getPT_IL_FAC_CLAIM_EST_CF() {
		return PT_IL_FAC_CLAIM_EST_CF;
	}

	public void setPT_IL_FAC_CLAIM_EST_CF(String pt_il_fac_claim_est_cf) {
		PT_IL_FAC_CLAIM_EST_CF = pt_il_fac_claim_est_cf;
	}

	public String getPT_IL_FAC_CLAIM_PAID_CF() {
		return PT_IL_FAC_CLAIM_PAID_CF;
	}

	public void setPT_IL_FAC_CLAIM_PAID_CF(String pt_il_fac_claim_paid_cf) {
		PT_IL_FAC_CLAIM_PAID_CF = pt_il_fac_claim_paid_cf;
	}

	public String getPT_IL_FAC_CLAIM_PART_CUST_ES() {
		return PT_IL_FAC_CLAIM_PART_CUST_ES;
	}

	public void setPT_IL_FAC_CLAIM_PART_CUST_ES(String pt_il_fac_claim_part_cust_es) {
		PT_IL_FAC_CLAIM_PART_CUST_ES = pt_il_fac_claim_part_cust_es;
	}

	public String getPT_IL_FAC_CLAIM_PART_CUST_PA() {
		return PT_IL_FAC_CLAIM_PART_CUST_PA;
	}

	public void setPT_IL_FAC_CLAIM_PART_CUST_PA(String pt_il_fac_claim_part_cust_pa) {
		PT_IL_FAC_CLAIM_PART_CUST_PA = pt_il_fac_claim_part_cust_pa;
	}

	public String getM_COVER_CODE() {
		return M_COVER_CODE;
	}

	public void setM_COVER_CODE(String m_cover_code) {
		M_COVER_CODE = m_cover_code;
	}

	public String getM_POL_NO_2() {
		return M_POL_NO_2;
	}

	public void setM_POL_NO_2(String m_pol_no_2) {
		M_POL_NO_2 = m_pol_no_2;
	}

	public String getM_CLM_NO_2() {
		return M_CLM_NO_2;
	}

	public void setM_CLM_NO_2(String m_clm_no_2) {
		M_CLM_NO_2 = m_clm_no_2;
	}

	public String getUI_M_POL_NO_1() {
		System.out.println("INSIDE UI POL NO");
		return UI_M_POL_NO_1;
	}

	public void setUI_M_POL_NO_1(String UI_M_POL_NO_1) {
		this.UI_M_POL_NO_1 = UI_M_POL_NO_1;
	}

	public String getUI_M_CLM_NO_1() {
		return UI_M_CLM_NO_1;
	}

	public void setUI_M_CLM_NO_1(String UI_M_CLM_NO_1) {
		this.UI_M_CLM_NO_1 = UI_M_CLM_NO_1;
	}

	public String getFCE_CCD_COVER_CODE() {
		return FCE_CCD_COVER_CODE;
	}

	public void setFCE_CCD_COVER_CODE(String FCE_CCD_COVER_CODE) {
		this.FCE_CCD_COVER_CODE = FCE_CCD_COVER_CODE;
	}

	public String getUI_M_COVER_DESC_1() {
		return UI_M_COVER_DESC_1;
	}

	public void setUI_M_COVER_DESC_1(String UI_M_COVER_DESC_1) {
		this.UI_M_COVER_DESC_1 = UI_M_COVER_DESC_1;
	}

	public String getUI_M_CURR_DESC_1() {
		return UI_M_CURR_DESC_1;
	}

	public void setUI_M_CURR_DESC_1(String UI_M_CURR_DESC_1) {
		this.UI_M_CURR_DESC_1 = UI_M_CURR_DESC_1;
	}

	public String getFCE_CLAIM_CURR_CODE() {
		return FCE_CLAIM_CURR_CODE;
	}

	public void setFCE_CLAIM_CURR_CODE(String FCE_CLAIM_CURR_CODE) {
		this.FCE_CLAIM_CURR_CODE = FCE_CLAIM_CURR_CODE;
	}

	public String getM_POL_SYS_ID() {
		return M_POL_SYS_ID;
	}

	public void setM_POL_SYS_ID(String m_pol_sys_id) {
		M_POL_SYS_ID = m_pol_sys_id;
	}

	public String getM_CLM_SYS_ID() {
		return M_CLM_SYS_ID;
	}

	public void setM_CLM_SYS_ID(String m_clm_sys_id) {
		M_CLM_SYS_ID = m_clm_sys_id;
	}

	public Double getFCE_CLAIM_SYS_ID() {
		return FCE_CLAIM_SYS_ID;
	}

	public void setFCE_CLAIM_SYS_ID(Double fce_claim_sys_id) {
		FCE_CLAIM_SYS_ID = fce_claim_sys_id;
	}

	public String getFCE_CCD_SYS_ID() {
		return FCE_CCD_SYS_ID;
	}

	public void setFCE_CCD_SYS_ID(String fce_ccd_sys_id) {
		FCE_CCD_SYS_ID = fce_ccd_sys_id;
	}

	public Date getFCE_CLAIM_LOSS_DT() {
		return FCE_CLAIM_LOSS_DT;
	}

	public void setFCE_CLAIM_LOSS_DT(Date fce_claim_loss_dt) {
		FCE_CLAIM_LOSS_DT = fce_claim_loss_dt;
	}

	public Double getFCE_FAC_FC_CLM_EST() {
		return FCE_FAC_FC_CLM_EST;
	}

	public void setFCE_FAC_FC_CLM_EST(Double fce_fac_fc_clm_est) {
		FCE_FAC_FC_CLM_EST = fce_fac_fc_clm_est;
	}

	public Double getFCE_FAC_LC_CLM_EST() {
		return FCE_FAC_LC_CLM_EST;
	}

	public void setFCE_FAC_LC_CLM_EST(Double fce_fac_lc_clm_est) {
		FCE_FAC_LC_CLM_EST = fce_fac_lc_clm_est;
	}

	public Double getFCE_RETRO_FC_CLM_EST() {
		return FCE_RETRO_FC_CLM_EST;
	}

	public void setFCE_RETRO_FC_CLM_EST(Double fce_retro_fc_clm_est) {
		FCE_RETRO_FC_CLM_EST = fce_retro_fc_clm_est;
	}

	public Double getFCE_RETRO_LC_CLM_EST() {
		return FCE_RETRO_LC_CLM_EST;
	}

	public void setFCE_RETRO_LC_CLM_EST(Double fce_retro_lc_clm_est) {
		FCE_RETRO_LC_CLM_EST = fce_retro_lc_clm_est;
	}

	public String getFCE_CLAIM_CLOSE_FLAG() {
		return FCE_CLAIM_CLOSE_FLAG;
	}

	public void setFCE_CLAIM_CLOSE_FLAG(String fce_claim_close_flag) {
		FCE_CLAIM_CLOSE_FLAG = fce_claim_close_flag;
	}

	public String getFCE_ASSR_CODE() {
		return FCE_ASSR_CODE;
	}

	public void setFCE_ASSR_CODE(String fce_assr_code) {
		FCE_ASSR_CODE = fce_assr_code;
	}

	public Date getFCE_CCD_RESERVE_DT() {
		return FCE_CCD_RESERVE_DT;
	}

	public void setFCE_CCD_RESERVE_DT(Date fce_ccd_reserve_dt) {
		FCE_CCD_RESERVE_DT = fce_ccd_reserve_dt;
	}

}
