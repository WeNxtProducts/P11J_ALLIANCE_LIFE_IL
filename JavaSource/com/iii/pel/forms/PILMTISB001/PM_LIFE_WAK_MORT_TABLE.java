package com.iii.pel.forms.PILMTISB001;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_LIFE_WAK_MORT_TABLE")
public class PM_LIFE_WAK_MORT_TABLE extends BaseValueBean {

	@Column(name = "WAKM_COVER_CODE")
	private String WAKM_COVER_CODE;

	@Column(name = "WAKM_MORT_CODE")
	private String WAKM_MORT_CODE;

	@Column(name = "WAKM_ASSUR_TYPE")
	private String WAKM_ASSUR_TYPE;

	@Column(name = "WAKM_ANLY_CODE_1")
	private String WAKM_ANLY_CODE_1;

	@Column(name = "WAKM_ANLY_CODE_2")
	private String WAKM_ANLY_CODE_2;

	@Column(name = "WAKM_SA_TYPE")
	private String WAKM_SA_TYPE;

	@Column(name = "WAKM_EFF_FM_DT")
	private Date WAKM_EFF_FM_DT;

	@Column(name = "WAKM_EFF_TO_DT")
	private Date WAKM_EFF_TO_DT;

	@Column(name = "WAKM_CR_UID")
	private String WAKM_CR_UID;

	@Column(name = "WAKM_CR_DATE")
	private Date WAKM_CR_DATE;

	@Column(name = "WAKM_UPD_UID")
	private String WAKM_UPD_UID;

	@Column(name = "WAKM_UPD_DATE")
	private Date WAKM_UPD_DATE;

	@Column(name = "WAKM_SELECT_RATE")
	private Double WAKM_SELECT_RATE;

	@Column(name = "WAKM_EXP_CODE")
	private String WAKM_EXP_CODE;

	@Column(name = "WAKM_SURPRO_PER")
	private Double WAKM_SURPRO_PER;

	@Column(name = "WAKM_PROD_CODE")
	private String WAKM_PROD_CODE;

	@Column(name = "WAKM_COVER_PERC")
	private Double WAKM_COVER_PERC;
	
	@Column(name = "WAKM_SUBSEQ_YN")
	private String WAKM_SUBSEQ_YN;
	
	@Column(name = "WAKM_SA_RISK_TYPE")
	private String WAKM_SA_RISK_TYPE;
	
	@Column(name = "WAKM_WAK_CALC_TYPE")
	private String WAKM_WAK_CALC_TYPE;
	
	@Column(name = "WAKM_MWA_CODE")
	private String WAKM_MWA_CODE;

	private String UI_M_WAKM_PROD_DESC;
	private String UI_M_COVER_DESC;
	private String UI_M_MORT_CODE_DESC;
	private String UI_M_WAKM_ANLY_CODE_1_DESC;
	private String UI_M_WAKM_ANLY_CODE_2_DESC;
	private String UI_M_EXP_CODE_DESC;

	public void setWAKM_PROD_CODE(String WAKM_PROD_CODE) {
		this.WAKM_PROD_CODE = WAKM_PROD_CODE;
	}

	public String getWAKM_PROD_CODE() {
		return WAKM_PROD_CODE;
	}

	public void setUI_M_WAKM_ANLY_CODE_1_DESC(String UI_M_WAKM_ANLY_CODE_1_DESC) {
		this.UI_M_WAKM_ANLY_CODE_1_DESC = UI_M_WAKM_ANLY_CODE_1_DESC;
	}

	public String getUI_M_WAKM_ANLY_CODE_1_DESC() {
		return UI_M_WAKM_ANLY_CODE_1_DESC;
	}

	public void setWAKM_CR_DATE(Date WAKM_CR_DATE) {
		this.WAKM_CR_DATE = WAKM_CR_DATE;
	}

	public Date getWAKM_CR_DATE() {
		return WAKM_CR_DATE;
	}

	public void setWAKM_SELECT_RATE(Double WAKM_SELECT_RATE) {
		this.WAKM_SELECT_RATE = WAKM_SELECT_RATE;
	}

	public Double getWAKM_SELECT_RATE() {
		return WAKM_SELECT_RATE;
	}

	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setWAKM_EFF_TO_DT(Date WAKM_EFF_TO_DT) {
		this.WAKM_EFF_TO_DT = WAKM_EFF_TO_DT;
	}

	public Date getWAKM_EFF_TO_DT() {
		return WAKM_EFF_TO_DT;
	}

	public void setWAKM_COVER_CODE(String WAKM_COVER_CODE) {
		this.WAKM_COVER_CODE = WAKM_COVER_CODE;
	}

	public String getWAKM_COVER_CODE() {
		return WAKM_COVER_CODE;
	}

	public void setWAKM_ASSUR_TYPE(String WAKM_ASSUR_TYPE) {
		this.WAKM_ASSUR_TYPE = WAKM_ASSUR_TYPE;
	}

	public String getWAKM_ASSUR_TYPE() {
		return WAKM_ASSUR_TYPE;
	}

	public void setWAKM_UPD_DATE(Date WAKM_UPD_DATE) {
		this.WAKM_UPD_DATE = WAKM_UPD_DATE;
	}

	public Date getWAKM_UPD_DATE() {
		return WAKM_UPD_DATE;
	}

	public void setWAKM_EFF_FM_DT(Date WAKM_EFF_FM_DT) {
		this.WAKM_EFF_FM_DT = WAKM_EFF_FM_DT;
	}

	public Date getWAKM_EFF_FM_DT() {
		return WAKM_EFF_FM_DT;
	}

	public void setWAKM_SURPRO_PER(Double WAKM_SURPRO_PER) {
		this.WAKM_SURPRO_PER = WAKM_SURPRO_PER;
	}

	public Double getWAKM_SURPRO_PER() {
		return WAKM_SURPRO_PER;
	}

	public void setWAKM_COVER_PERC(Double WAKM_COVER_PERC) {
		this.WAKM_COVER_PERC = WAKM_COVER_PERC;
	}

	public Double getWAKM_COVER_PERC() {
		return WAKM_COVER_PERC;
	}

	public void setWAKM_MORT_CODE(String WAKM_MORT_CODE) {
		this.WAKM_MORT_CODE = WAKM_MORT_CODE;
	}

	public String getWAKM_MORT_CODE() {
		return WAKM_MORT_CODE;
	}

	public void setWAKM_ANLY_CODE_2(String WAKM_ANLY_CODE_2) {
		this.WAKM_ANLY_CODE_2 = WAKM_ANLY_CODE_2;
	}

	public String getWAKM_ANLY_CODE_2() {
		return WAKM_ANLY_CODE_2;
	}

	public void setWAKM_EXP_CODE(String WAKM_EXP_CODE) {
		this.WAKM_EXP_CODE = WAKM_EXP_CODE;
	}

	public String getWAKM_EXP_CODE() {
		return WAKM_EXP_CODE;
	}

	public void setWAKM_ANLY_CODE_1(String WAKM_ANLY_CODE_1) {
		this.WAKM_ANLY_CODE_1 = WAKM_ANLY_CODE_1;
	}

	public String getWAKM_ANLY_CODE_1() {
		return WAKM_ANLY_CODE_1;
	}

	public void setWAKM_SA_TYPE(String WAKM_SA_TYPE) {
		this.WAKM_SA_TYPE = WAKM_SA_TYPE;
	}

	public String getWAKM_SA_TYPE() {
		return WAKM_SA_TYPE;
	}

	public void setUI_M_MORT_CODE_DESC(String UI_M_MORT_CODE_DESC) {
		this.UI_M_MORT_CODE_DESC = UI_M_MORT_CODE_DESC;
	}

	public String getUI_M_MORT_CODE_DESC() {
		return UI_M_MORT_CODE_DESC;
	}

	public void setUI_M_EXP_CODE_DESC(String UI_M_EXP_CODE_DESC) {
		this.UI_M_EXP_CODE_DESC = UI_M_EXP_CODE_DESC;
	}

	public String getUI_M_EXP_CODE_DESC() {
		return UI_M_EXP_CODE_DESC;
	}

	public void setUI_M_WAKM_PROD_DESC(String UI_M_WAKM_PROD_DESC) {
		this.UI_M_WAKM_PROD_DESC = UI_M_WAKM_PROD_DESC;
	}

	public String getUI_M_WAKM_PROD_DESC() {
		return UI_M_WAKM_PROD_DESC;
	}

	public void setUI_M_WAKM_ANLY_CODE_2_DESC(String UI_M_WAKM_ANLY_CODE_2_DESC) {
		this.UI_M_WAKM_ANLY_CODE_2_DESC = UI_M_WAKM_ANLY_CODE_2_DESC;
	}

	public String getUI_M_WAKM_ANLY_CODE_2_DESC() {
		return UI_M_WAKM_ANLY_CODE_2_DESC;
	}

	public void setWAKM_CR_UID(String WAKM_CR_UID) {
		this.WAKM_CR_UID = WAKM_CR_UID;
	}

	public String getWAKM_CR_UID() {
		return WAKM_CR_UID;
	}

	public void setWAKM_UPD_UID(String WAKM_UPD_UID) {
		this.WAKM_UPD_UID = WAKM_UPD_UID;
	}

	public String getWAKM_UPD_UID() {
		return WAKM_UPD_UID;
	}

	public String getWAKM_SUBSEQ_YN() {
		return WAKM_SUBSEQ_YN;
	}

	public void setWAKM_SUBSEQ_YN(String wakm_subseq_yn) {
		WAKM_SUBSEQ_YN = wakm_subseq_yn;
	}

	public String getWAKM_SA_RISK_TYPE() {
		return WAKM_SA_RISK_TYPE;
	}

	public void setWAKM_SA_RISK_TYPE(String wakm_sa_risk_type) {
		WAKM_SA_RISK_TYPE = wakm_sa_risk_type;
	}

	public String getWAKM_WAK_CALC_TYPE() {
		return WAKM_WAK_CALC_TYPE;
	}

	public void setWAKM_WAK_CALC_TYPE(String wakm_wak_calc_type) {
		WAKM_WAK_CALC_TYPE = wakm_wak_calc_type;
	}

	public String getWAKM_MWA_CODE() {
		return WAKM_MWA_CODE;
	}

	public void setWAKM_MWA_CODE(String wakm_mwa_code) {
		WAKM_MWA_CODE = wakm_mwa_code;
	}

}
