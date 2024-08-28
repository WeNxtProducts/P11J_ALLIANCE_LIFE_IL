package com.iii.pel.forms.PM078_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_LIFE_WAKALAH_SETUP")
public class PM_LIFE_WAKALAH_SETUP extends BaseValueBean {

	@Column(name="WAKS_MODULE")
	private String WAKS_MODULE;

	@Column(name="WAKS_PRODUCT_CODE")
	private String WAKS_PRODUCT_CODE;

	@Column(name="WAKS_COVER_CODE")
	private String WAKS_COVER_CODE;

	@Column(name="WAKS_EXPENSE_PERC")
	private Double WAKS_EXPENSE_PERC;

	@Column(name="WAKS_SPL_FUND")
	private Double WAKS_SPL_FUND;

	@Column(name="WAKS_PRO_ON_INVEST")
	private Double WAKS_PRO_ON_INVEST;

	@Column(name="WAKS_PAR_SHARE_OF_SUR")
	private Double WAKS_PAR_SHARE_OF_SUR;

	@Column(name="WAKS_ADMIN_CHARGES")
	private Double WAKS_ADMIN_CHARGES;

	@Column(name="WAKS_INV_PROFIT_SHARE")
	private Double WAKS_INV_PROFIT_SHARE;

	@Column(name="WAKS_CHARGE_MODE")
	private String WAKS_CHARGE_MODE;

	@Column(name="WAKS_FRZ_FLAG")
	private String WAKS_FRZ_FLAG;

	@Column(name="WAKS_CR_DT")
	private Date WAKS_CR_DT;

	@Column(name="WAKS_CR_UID")
	private String WAKS_CR_UID;

	@Column(name="WAKS_UPD_DT")
	private Date WAKS_UPD_DT;

	@Column(name="WAKS_UPD_UID")
	private String WAKS_UPD_UID;

	@Column(name="WAKS_EFF_FM_DT")
	private Date WAKS_EFF_FM_DT;

	@Column(name="WAKS_EFF_TO_DT")
	private Date WAKS_EFF_TO_DT;

	@Column(name="WAKS_SPLFUND_MODE")
	private String WAKS_SPLFUND_MODE;

	@Column(name="WAKS_EXPNS_MODE")
	private String WAKS_EXPNS_MODE;

	@Column(name="WAKS_ADMIN_RATE_PER")
	private Double WAKS_ADMIN_RATE_PER;

	@Column(name="WAKS_ALLOC_TARIFF")
	private String WAKS_ALLOC_TARIFF;

	@Column(name="WAKS_ADMIN_TARIFF")
	private String WAKS_ADMIN_TARIFF;

	@Column(name="WAKS_ZERO_PREM_YN")
	private String WAKS_ZERO_PREM_YN;

	@Column(name="WAKS_FIXED_EXPNS")
	private Double WAKS_FIXED_EXPNS;

	@Column(name="WAKS_RISK_CALC_MTHD")
	private String WAKS_RISK_CALC_MTHD;

	@Column(name="WAKS_EXP_CALC_MTHD")
	private String WAKS_EXP_CALC_MTHD;

	@Column(name="WAKS_RISK_LOAD_YN")
	private String WAKS_RISK_LOAD_YN;

	private String UI_M_WAKS_COVER_CODE;
	
	private String UI_WAKS_EFF_FM_DT;
	private String UI_WAKS_EFF_TO_DT;
	
	/*added by janani on 10.2.2016*/
	
	@Column(name="WAKS_FIXED_AMT")
	private Double WAKS_FIXED_AMT;
	
	
	public Double getWAKS_FIXED_AMT() {
		return WAKS_FIXED_AMT;
	}
	public void setWAKS_FIXED_AMT(Double wAKS_FIXED_AMT) {
		WAKS_FIXED_AMT = wAKS_FIXED_AMT;
	}
	
	
	/*End*/
	
	public void setWAKS_RISK_CALC_MTHD(String WAKS_RISK_CALC_MTHD) {
		this.WAKS_RISK_CALC_MTHD = WAKS_RISK_CALC_MTHD;
	}
	public String getWAKS_RISK_CALC_MTHD() {
		 return WAKS_RISK_CALC_MTHD;
	}
	public void setWAKS_PRODUCT_CODE(String WAKS_PRODUCT_CODE) {
		this.WAKS_PRODUCT_CODE = WAKS_PRODUCT_CODE;
	}
	public String getWAKS_PRODUCT_CODE() {
		 return WAKS_PRODUCT_CODE;
	}
	public void setWAKS_EFF_TO_DT(Date WAKS_EFF_TO_DT) {
		this.WAKS_EFF_TO_DT = WAKS_EFF_TO_DT;
	}
	public Date getWAKS_EFF_TO_DT() {
		 return WAKS_EFF_TO_DT;
	}
	public void setWAKS_ZERO_PREM_YN(String WAKS_ZERO_PREM_YN) {
		this.WAKS_ZERO_PREM_YN = WAKS_ZERO_PREM_YN;
	}
	public String getWAKS_ZERO_PREM_YN() {
		 return WAKS_ZERO_PREM_YN;
	}
	public void setWAKS_INV_PROFIT_SHARE(Double WAKS_INV_PROFIT_SHARE) {
		this.WAKS_INV_PROFIT_SHARE = WAKS_INV_PROFIT_SHARE;
	}
	public Double getWAKS_INV_PROFIT_SHARE() {
		 return WAKS_INV_PROFIT_SHARE;
	}
	public void setWAKS_UPD_UID(String WAKS_UPD_UID) {
		this.WAKS_UPD_UID = WAKS_UPD_UID;
	}
	public String getWAKS_UPD_UID() {
		 return WAKS_UPD_UID;
	}
	public void setWAKS_SPLFUND_MODE(String WAKS_SPLFUND_MODE) {
		this.WAKS_SPLFUND_MODE = WAKS_SPLFUND_MODE;
	}
	public String getWAKS_SPLFUND_MODE() {
		 return WAKS_SPLFUND_MODE;
	}
	public void setWAKS_PAR_SHARE_OF_SUR(Double WAKS_PAR_SHARE_OF_SUR) {
		this.WAKS_PAR_SHARE_OF_SUR = WAKS_PAR_SHARE_OF_SUR;
	}
	public Double getWAKS_PAR_SHARE_OF_SUR() {
		 return WAKS_PAR_SHARE_OF_SUR;
	}
	public void setWAKS_FRZ_FLAG(String WAKS_FRZ_FLAG) {
		this.WAKS_FRZ_FLAG = WAKS_FRZ_FLAG;
	}
	public String getWAKS_FRZ_FLAG() {
		 return WAKS_FRZ_FLAG;
	}
	public void setWAKS_CHARGE_MODE(String WAKS_CHARGE_MODE) {
		this.WAKS_CHARGE_MODE = WAKS_CHARGE_MODE;
	}
	public String getWAKS_CHARGE_MODE() {
		 return WAKS_CHARGE_MODE;
	}
	public void setWAKS_CR_UID(String WAKS_CR_UID) {
		this.WAKS_CR_UID = WAKS_CR_UID;
	}
	public String getWAKS_CR_UID() {
		 return WAKS_CR_UID;
	}
	public void setUI_M_WAKS_COVER_CODE(String UI_M_WAKS_COVER_CODE) {
		this.UI_M_WAKS_COVER_CODE = UI_M_WAKS_COVER_CODE;
	}
	public String getUI_M_WAKS_COVER_CODE() {
		 return UI_M_WAKS_COVER_CODE;
	}
	public void setWAKS_EFF_FM_DT(Date WAKS_EFF_FM_DT) {
		this.WAKS_EFF_FM_DT = WAKS_EFF_FM_DT;
	}
	public Date getWAKS_EFF_FM_DT() {
		 return WAKS_EFF_FM_DT;
	}
	public void setWAKS_FIXED_EXPNS(Double WAKS_FIXED_EXPNS) {
		this.WAKS_FIXED_EXPNS = WAKS_FIXED_EXPNS;
	}
	public Double getWAKS_FIXED_EXPNS() {
		 return WAKS_FIXED_EXPNS;
	}
	public void setWAKS_ADMIN_RATE_PER(Double WAKS_ADMIN_RATE_PER) {
		this.WAKS_ADMIN_RATE_PER = WAKS_ADMIN_RATE_PER;
	}
	public Double getWAKS_ADMIN_RATE_PER() {
		 return WAKS_ADMIN_RATE_PER;
	}
	public void setWAKS_PRO_ON_INVEST(Double WAKS_PRO_ON_INVEST) {
		this.WAKS_PRO_ON_INVEST = WAKS_PRO_ON_INVEST;
	}
	public Double getWAKS_PRO_ON_INVEST() {
		 return WAKS_PRO_ON_INVEST;
	}
	public void setWAKS_RISK_LOAD_YN(String WAKS_RISK_LOAD_YN) {
		this.WAKS_RISK_LOAD_YN = WAKS_RISK_LOAD_YN;
	}
	public String getWAKS_RISK_LOAD_YN() {
		 return WAKS_RISK_LOAD_YN;
	}
	public void setWAKS_EXPENSE_PERC(Double WAKS_EXPENSE_PERC) {
		this.WAKS_EXPENSE_PERC = WAKS_EXPENSE_PERC;
	}
	public Double getWAKS_EXPENSE_PERC() {
		 return WAKS_EXPENSE_PERC;
	}
	public void setWAKS_CR_DT(Date WAKS_CR_DT) {
		this.WAKS_CR_DT = WAKS_CR_DT;
	}
	public Date getWAKS_CR_DT() {
		 return WAKS_CR_DT;
	}
	public void setWAKS_COVER_CODE(String WAKS_COVER_CODE) {
		this.WAKS_COVER_CODE = WAKS_COVER_CODE;
	}
	public String getWAKS_COVER_CODE() {
		 return WAKS_COVER_CODE;
	}
	public void setWAKS_EXPNS_MODE(String WAKS_EXPNS_MODE) {
		this.WAKS_EXPNS_MODE = WAKS_EXPNS_MODE;
	}
	public String getWAKS_EXPNS_MODE() {
		 return WAKS_EXPNS_MODE;
	}
	public void setWAKS_ADMIN_CHARGES(Double WAKS_ADMIN_CHARGES) {
		this.WAKS_ADMIN_CHARGES = WAKS_ADMIN_CHARGES;
	}
	public Double getWAKS_ADMIN_CHARGES() {
		 return WAKS_ADMIN_CHARGES;
	}
	public void setWAKS_ADMIN_TARIFF(String WAKS_ADMIN_TARIFF) {
		this.WAKS_ADMIN_TARIFF = WAKS_ADMIN_TARIFF;
	}
	public String getWAKS_ADMIN_TARIFF() {
		 return WAKS_ADMIN_TARIFF;
	}
	public void setWAKS_SPL_FUND(Double WAKS_SPL_FUND) {
		this.WAKS_SPL_FUND = WAKS_SPL_FUND;
	}
	public Double getWAKS_SPL_FUND() {
		 return WAKS_SPL_FUND;
	}
	public void setWAKS_MODULE(String WAKS_MODULE) {
		this.WAKS_MODULE = WAKS_MODULE;
	}
	public String getWAKS_MODULE() {
		 return WAKS_MODULE;
	}
	public void setWAKS_UPD_DT(Date WAKS_UPD_DT) {
		this.WAKS_UPD_DT = WAKS_UPD_DT;
	}
	public Date getWAKS_UPD_DT() {
		 return WAKS_UPD_DT;
	}
	public void setWAKS_EXP_CALC_MTHD(String WAKS_EXP_CALC_MTHD) {
		this.WAKS_EXP_CALC_MTHD = WAKS_EXP_CALC_MTHD;
	}
	public String getWAKS_EXP_CALC_MTHD() {
		 return WAKS_EXP_CALC_MTHD;
	}
	public void setWAKS_ALLOC_TARIFF(String WAKS_ALLOC_TARIFF) {
		this.WAKS_ALLOC_TARIFF = WAKS_ALLOC_TARIFF;
	}
	public String getWAKS_ALLOC_TARIFF() {
		 return WAKS_ALLOC_TARIFF;
	}
	public String getUI_WAKS_EFF_FM_DT() {
		return UI_WAKS_EFF_FM_DT;
	}
	public void setUI_WAKS_EFF_FM_DT(String ui_waks_eff_fm_dt) {
		UI_WAKS_EFF_FM_DT = ui_waks_eff_fm_dt;
	}
	public String getUI_WAKS_EFF_TO_DT() {
		return UI_WAKS_EFF_TO_DT;
	}
	public void setUI_WAKS_EFF_TO_DT(String ui_waks_eff_to_dt) {
		UI_WAKS_EFF_TO_DT = ui_waks_eff_to_dt;
	}

}