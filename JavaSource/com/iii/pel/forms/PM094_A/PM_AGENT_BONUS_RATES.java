package com.iii.pel.forms.PM094_A;


import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BONUS_RATES")
public class PM_AGENT_BONUS_RATES extends BaseValueBean {

	@Column(name="ABR_YTD_FYC_FM")
	private Double ABR_YTD_FYC_FM;

	@Column(name="ABR_YTD_FYC_TO")
	private Double ABR_YTD_FYC_TO;

	@Column(name="ABR_NO_OF_POL_FM")
	private Integer ABR_NO_OF_POL_FM;

	@Column(name="ABR_NO_OF_POL_TO")
	private Integer ABR_NO_OF_POL_TO;
	

	@Column(name="ABR_PERIOD")
	private String ABR_PERIOD;

	@Column(name="ABR_RATE")
	private Double ABR_RATE;

	@Column(name="ABR_RATE_PER")
	private Double ABR_RATE_PER;

	@Column(name="ABR_EFF_FM_DT")
	private Date ABR_EFF_FM_DT;

	@Column(name="ABR_EFF_TO_DT")
	private Date ABR_EFF_TO_DT;
/*
	private Date ABAR_CR_DATE;
	
	private Date ABAR_UPD_DATE;*/
	
	@Column(name="ABR_UPD_UID")
	private String ABR_UPD_UID;
	
	@Column(name="ABR_CR_UID")
	private String ABR_CR_UID;
	

	private String UI_M_ABR_RANK_CODE;
	
	
	private String UI_M_ABR_RANK_CODE_DESC;
	
	@Column(name="ABR_ABS_CODE")
	private String ABR_ABS_CODE;
	
	@Column(name="ABR_RANK_CODE")
	private String ABR_RANK_CODE;
	
	@Column(name="ABR_CR_DT")
	private Date ABR_CR_DT;
	
	@Column(name="ABR_UPD_DT")
	private Date ABR_UPD_DT;

	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getABR_YTD_FYC_FM() {
		return ABR_YTD_FYC_FM;
	}

	public void setABR_YTD_FYC_FM(Double ABR_YTD_FYC_FM) {
		this.ABR_YTD_FYC_FM = ABR_YTD_FYC_FM;
	}

	public Double getABR_YTD_FYC_TO() {
		return ABR_YTD_FYC_TO;
	}

	public void setABR_YTD_FYC_TO(Double ABR_YTD_FYC_TO) {
		this.ABR_YTD_FYC_TO = ABR_YTD_FYC_TO;
	}

	public Integer getABR_NO_OF_POL_FM() {
		return ABR_NO_OF_POL_FM;
	}

	public void setABR_NO_OF_POL_FM(Integer abr_no_of_pol_fm) {
		ABR_NO_OF_POL_FM = abr_no_of_pol_fm;
	}

	public Integer getABR_NO_OF_POL_TO() {
		return ABR_NO_OF_POL_TO;
	}

	public void setABR_NO_OF_POL_TO(Integer abr_no_of_pol_to) {
		ABR_NO_OF_POL_TO = abr_no_of_pol_to;
	}

	public String getABR_PERIOD() {
		return ABR_PERIOD;
	}

	public void setABR_PERIOD(String ABR_PERIOD) {
		this.ABR_PERIOD = ABR_PERIOD;
	}

	public Double getABR_RATE() {
		return ABR_RATE;
	}

	public void setABR_RATE(Double ABR_RATE) {
		this.ABR_RATE = ABR_RATE;
	}

	public Double getABR_RATE_PER() {
		return ABR_RATE_PER;
	}

	public void setABR_RATE_PER(Double ABR_RATE_PER) {
		this.ABR_RATE_PER = ABR_RATE_PER;
	}

	public Date getABR_EFF_FM_DT() {
		 return ABR_EFF_FM_DT;
	}

	public void setABR_EFF_FM_DT(Date ABR_EFF_FM_DT) {
		this.ABR_EFF_FM_DT = ABR_EFF_FM_DT;
	}

	public Date getABR_EFF_TO_DT() {
		 return ABR_EFF_TO_DT;
	}

	public void setABR_EFF_TO_DT(Date ABR_EFF_TO_DT) {
		this.ABR_EFF_TO_DT = ABR_EFF_TO_DT;
	}

	public String getUI_M_ABR_RANK_CODE() {
		return UI_M_ABR_RANK_CODE;
	}

	public void setUI_M_ABR_RANK_CODE(String ui_m_abr_rank_code) {
		UI_M_ABR_RANK_CODE = ui_m_abr_rank_code;
	}

	public String getUI_M_ABR_RANK_CODE_DESC() {
		return UI_M_ABR_RANK_CODE_DESC;
	}

	public void setUI_M_ABR_RANK_CODE_DESC(String ui_m_abr_rank_code_desc) {
		UI_M_ABR_RANK_CODE_DESC = ui_m_abr_rank_code_desc;
	}

	/*public Date getABAR_CR_DATE() {
		return ABAR_CR_DATE;
	}

	public void setABAR_CR_DATE(Date abar_cr_date) {
		ABAR_CR_DATE = abar_cr_date;
	}

	public Date getABAR_UPD_DATE() {
		return ABAR_UPD_DATE;
	}

	public void setABAR_UPD_DATE(Date abar_upd_date) {
		ABAR_UPD_DATE = abar_upd_date;
	}*/

	public String getABR_UPD_UID() {
		return ABR_UPD_UID;
	}

	public void setABR_UPD_UID(String abar_upd_uid) {
		ABR_UPD_UID = abar_upd_uid;
	}

	public String getABR_CR_UID() {
		return ABR_CR_UID;
	}

	public void setABR_CR_UID(String abar_cr_uid) {
		ABR_CR_UID = abar_cr_uid;
	}

	public String getABR_ABS_CODE() {
		return ABR_ABS_CODE;
	}

	public void setABR_ABS_CODE(String abr_abs_code) {
		ABR_ABS_CODE = abr_abs_code;
	}

	public String getABR_RANK_CODE() {
		return ABR_RANK_CODE;
	}

	public void setABR_RANK_CODE(String abr_rank_code) {
		ABR_RANK_CODE = abr_rank_code;
	}

	public Date getABR_CR_DT() {
		return ABR_CR_DT;
	}

	public void setABR_CR_DT(Date abr_cr_dt) {
		ABR_CR_DT = abr_cr_dt;
	}

	public Date getABR_UPD_DT() {
		return ABR_UPD_DT;
	}

	public void setABR_UPD_DT(Date abr_upd_dt) {
		ABR_UPD_DT = abr_upd_dt;
	}
	
	/*Added by ganesh on 02-06-2018 as suggested by sivaram*/
	@Column(name="ABR_APPLIED_ON")
	private String ABR_APPLIED_ON;
	
	@Column(name="ABR_FORMULA_CODE")
	private String ABR_FORMULA_CODE;
	
	@Column(name="ABR_MAX_LIMIT")
	private Long ABR_MAX_LIMIT;

	public String getABR_APPLIED_ON() {
		return ABR_APPLIED_ON;
	}

	public void setABR_APPLIED_ON(String aBR_APPLIED_ON) {
		ABR_APPLIED_ON = aBR_APPLIED_ON;
	}

	public String getABR_FORMULA_CODE() {
		return ABR_FORMULA_CODE;
	}

	public void setABR_FORMULA_CODE(String aBR_FORMULA_CODE) {
		ABR_FORMULA_CODE = aBR_FORMULA_CODE;
	}

	public Long getABR_MAX_LIMIT() {
		return ABR_MAX_LIMIT;
	}

	public void setABR_MAX_LIMIT(Long aBR_MAX_LIMIT) {
		ABR_MAX_LIMIT = aBR_MAX_LIMIT;
	}
	
	public String UI_M_ABR_FORMULA_CODE_DESC;
	

	public String getUI_M_ABR_FORMULA_CODE_DESC() {
		return UI_M_ABR_FORMULA_CODE_DESC;
	}

	public void setUI_M_ABR_FORMULA_CODE_DESC(String uI_M_ABR_FORMULA_CODE_DESC) {
		UI_M_ABR_FORMULA_CODE_DESC = uI_M_ABR_FORMULA_CODE_DESC;
	}
	/*end*/
	
	/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
	@Column(name="ABR_NO_OF_MON_FM")
	private Integer ABR_NO_OF_MON_FM;
	
	@Column(name="ABR_NO_OF_MON_TO")
	private Integer ABR_NO_OF_MON_TO;

	public Integer getABR_NO_OF_MON_FM() {
		return ABR_NO_OF_MON_FM;
	}

	public void setABR_NO_OF_MON_FM(Integer aBR_NO_OF_MON_FM) {
		ABR_NO_OF_MON_FM = aBR_NO_OF_MON_FM;
	}

	public Integer getABR_NO_OF_MON_TO() {
		return ABR_NO_OF_MON_TO;
	}

	public void setABR_NO_OF_MON_TO(Integer aBR_NO_OF_MON_TO) {
		ABR_NO_OF_MON_TO = aBR_NO_OF_MON_TO;
	}

	/*end*/
}
