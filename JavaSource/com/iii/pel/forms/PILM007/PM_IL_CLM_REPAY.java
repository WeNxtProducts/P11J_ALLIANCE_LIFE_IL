package com.iii.pel.forms.PILM007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CLM_REPAY")
public class PM_IL_CLM_REPAY extends BaseValueBean {

	@Column(name="CR_COVER_CODE")
	private String CR_COVER_CODE;

	@Column(name="CR_LOSS_TYPE")
	private String CR_LOSS_TYPE;

	@Column(name="CR_DISABLE_TYPE")
	private String CR_DISABLE_TYPE;

	@Column(name="CR_PERIOD_UNIT")
	private String CR_PERIOD_UNIT;

	@Column(name="CR_PERIOD_FROM")
	private Integer CR_PERIOD_FROM;

	@Column(name="CR_PERIOD_TO")
	private Integer CR_PERIOD_TO;

	@Column(name="CR_PAY_MODE")
	private String CR_PAY_MODE;

	@Column(name="CR_POLICY_VALID_YN")
	private String CR_POLICY_VALID_YN;

	@Column(name="CR_PREM_PAYABLE_YN")
	private String CR_PREM_PAYABLE_YN;

	@Column(name="CR_CR_DT")
	private Date CR_CR_DT;

	@Column(name="CR_CR_UID")
	private String CR_CR_UID;

	@Column(name="CR_UPD_DT")
	private Date CR_UPD_DT;

	@Column(name="CR_UPD_UID")
	private String CR_UPD_UID;

	@Column(name="CR_MIN_TYPE")
	private String CR_MIN_TYPE;

	@Column(name="CR_MIN_VALUE")
	private Double CR_MIN_VALUE;

	@Column(name="CR_MAX_TYPE")
	private String CR_MAX_TYPE;

	@Column(name="CR_MAX_VALUE")
	private Double CR_MAX_VALUE;

	@Column(name="CR_RATE")
	private Double CR_RATE;

	@Column(name="CR_RATE_PER")
	private Double CR_RATE_PER;

	@Column(name="CR_EFF_FM_DT")
	private Date CR_EFF_FM_DT;

	@Column(name="CR_EFF_TO_DT")
	private Date CR_EFF_TO_DT;

	@Column(name="CR_APPLIED_ON")
	private String CR_APPLIED_ON;

	@Column(name="CR_LATE_FEE_YN")
	private String CR_LATE_FEE_YN;

	@Column(name="CR_LATE_FEE_TYPE")
	private String CR_LATE_FEE_TYPE;

	@Column(name="CR_RESERVE_TYPE")
	private String CR_RESERVE_TYPE;

	@Column(name="CR_RESERVE_OPTIONS")
	private String CR_RESERVE_OPTIONS;

	@Column(name="CR_NO_OF_YEARS")
	private Integer CR_NO_OF_YEARS;

	@Column(name="CR_RESERVE_CR_BASIS")
	private String CR_RESERVE_CR_BASIS;

	@Column(name="CR_PAY_TO")
	private String CR_PAY_TO;

	@Column(name="CR_WAITING_YN")
	private String CR_WAITING_YN;

	@Column(name="CR_LIEN_YN")
	private String CR_LIEN_YN;

	@Column(name="CR_UNIT_PRICE")
	private String CR_UNIT_PRICE;

	@Column(name="CR_PREM_DED")
	private String CR_PREM_DED;

	@Column(name="CR_HIBAH_FEE_AMT")
	private Double CR_HIBAH_FEE_AMT;

	@Column(name="CR_HIBAH_YN")
	private String CR_HIBAH_YN;
	
	@Column(name="CR_FM_CODE")
	private String CR_FM_CODE;
	
	private String CR_FORMULA_DESC;
	
/*	@Column(name="CR_PROD_CODE")
	private String CR_PROD_CODE;*/
	
	private String UI_M_LOSS_DESC;

	private String UI_M_COVER_DESC;
	
	private String UI_M_DISABLE_DESC;
	
	@Column(name="CR_FLEX_01")
	private String CR_ALLOWANCE;
	
	@Column(name="CR_FLEX_02")
	private int CR_ALLOWANCE_PER_DAY;


	/**
	 * @return the cR_ALLOWANCE
	 */
	public String getCR_ALLOWANCE() {
		return CR_ALLOWANCE;
	}

	/**
	 * @param cr_allowance the cR_ALLOWANCE to set
	 */
	public void setCR_ALLOWANCE(String cr_allowance) {
		CR_ALLOWANCE = cr_allowance;
	}

	

	/**
	 * @return the cR_ALLOWANCE_PER_DAY
	 */
	public int getCR_ALLOWANCE_PER_DAY() {
		return CR_ALLOWANCE_PER_DAY;
	}

	/**
	 * @param cr_allowance_per_day the cR_ALLOWANCE_PER_DAY to set
	 */
	public void setCR_ALLOWANCE_PER_DAY(int cr_allowance_per_day) {
		CR_ALLOWANCE_PER_DAY = cr_allowance_per_day;
	}

	public String getCR_COVER_CODE() {
		 return CR_COVER_CODE;
	}

	public void setCR_COVER_CODE(String CR_COVER_CODE) {
		this.CR_COVER_CODE = CR_COVER_CODE;
	}

	public String getCR_LOSS_TYPE() {
		 return CR_LOSS_TYPE;
	}

	public void setCR_LOSS_TYPE(String CR_LOSS_TYPE) {
		this.CR_LOSS_TYPE = CR_LOSS_TYPE;
	}

	public String getCR_DISABLE_TYPE() {
		 return CR_DISABLE_TYPE;
	}

	public void setCR_DISABLE_TYPE(String CR_DISABLE_TYPE) {
		this.CR_DISABLE_TYPE = CR_DISABLE_TYPE;
	}

	public String getCR_PERIOD_UNIT() {
		 return CR_PERIOD_UNIT;
	}

	public void setCR_PERIOD_UNIT(String CR_PERIOD_UNIT) {
		this.CR_PERIOD_UNIT = CR_PERIOD_UNIT;
	}

	public Integer getCR_PERIOD_FROM() {
		 return CR_PERIOD_FROM;
	}

	public void setCR_PERIOD_FROM(Integer CR_PERIOD_FROM) {
		this.CR_PERIOD_FROM = CR_PERIOD_FROM;
	}

	public Integer getCR_PERIOD_TO() {
		 return CR_PERIOD_TO;
	}

	public void setCR_PERIOD_TO(Integer CR_PERIOD_TO) {
		this.CR_PERIOD_TO = CR_PERIOD_TO;
	}

	public String getCR_PAY_MODE() {
		 return CR_PAY_MODE;
	}

	public void setCR_PAY_MODE(String CR_PAY_MODE) {
		this.CR_PAY_MODE = CR_PAY_MODE;
	}

	public String getCR_POLICY_VALID_YN() {
		 return CR_POLICY_VALID_YN;
	}

	public void setCR_POLICY_VALID_YN(String CR_POLICY_VALID_YN) {
		this.CR_POLICY_VALID_YN = CR_POLICY_VALID_YN;
	}

	public String getCR_PREM_PAYABLE_YN() {
		 return CR_PREM_PAYABLE_YN;
	}

	public void setCR_PREM_PAYABLE_YN(String CR_PREM_PAYABLE_YN) {
		this.CR_PREM_PAYABLE_YN = CR_PREM_PAYABLE_YN;
	}

	public Date getCR_CR_DT() {
		 return CR_CR_DT;
	}

	public void setCR_CR_DT(Date CR_CR_DT) {
		this.CR_CR_DT = CR_CR_DT;
	}

	public String getCR_CR_UID() {
		 return CR_CR_UID;
	}

	public void setCR_CR_UID(String CR_CR_UID) {
		this.CR_CR_UID = CR_CR_UID;
	}

	public Date getCR_UPD_DT() {
		 return CR_UPD_DT;
	}

	public void setCR_UPD_DT(Date CR_UPD_DT) {
		this.CR_UPD_DT = CR_UPD_DT;
	}

	public String getCR_UPD_UID() {
		 return CR_UPD_UID;
	}

	public void setCR_UPD_UID(String CR_UPD_UID) {
		this.CR_UPD_UID = CR_UPD_UID;
	}

	public String getCR_MIN_TYPE() {
		 return CR_MIN_TYPE;
	}

	public void setCR_MIN_TYPE(String CR_MIN_TYPE) {
		this.CR_MIN_TYPE = CR_MIN_TYPE;
	}

	public Double getCR_MIN_VALUE() {
		 return CR_MIN_VALUE;
	}

	public void setCR_MIN_VALUE(Double CR_MIN_VALUE) {
		this.CR_MIN_VALUE = CR_MIN_VALUE;
	}

	public String getCR_MAX_TYPE() {
		 return CR_MAX_TYPE;
	}

	public void setCR_MAX_TYPE(String CR_MAX_TYPE) {
		this.CR_MAX_TYPE = CR_MAX_TYPE;
	}

	public Double getCR_MAX_VALUE() {
		 return CR_MAX_VALUE;
	}

	public void setCR_MAX_VALUE(Double CR_MAX_VALUE) {
		this.CR_MAX_VALUE = CR_MAX_VALUE;
	}

	public Double getCR_RATE() {
		 return CR_RATE;
	}

	public void setCR_RATE(Double CR_RATE) {
		this.CR_RATE = CR_RATE;
	}

	public Double getCR_RATE_PER() {
		 return CR_RATE_PER;
	}

	public void setCR_RATE_PER(Double CR_RATE_PER) {
		this.CR_RATE_PER = CR_RATE_PER;
	}

	public Date getCR_EFF_FM_DT() {
		 return CR_EFF_FM_DT;
	}

	public void setCR_EFF_FM_DT(Date CR_EFF_FM_DT) {
		this.CR_EFF_FM_DT = CR_EFF_FM_DT;
	}

	public Date getCR_EFF_TO_DT() {
		 return CR_EFF_TO_DT;
	}

	public void setCR_EFF_TO_DT(Date CR_EFF_TO_DT) {
		this.CR_EFF_TO_DT = CR_EFF_TO_DT;
	}

	public String getCR_APPLIED_ON() {
		 return CR_APPLIED_ON;
	}

	public void setCR_APPLIED_ON(String CR_APPLIED_ON) {
		this.CR_APPLIED_ON = CR_APPLIED_ON;
	}

	public String getCR_LATE_FEE_YN() {
		 return CR_LATE_FEE_YN;
	}

	public void setCR_LATE_FEE_YN(String CR_LATE_FEE_YN) {
		this.CR_LATE_FEE_YN = CR_LATE_FEE_YN;
	}

	public String getCR_LATE_FEE_TYPE() {
		 return CR_LATE_FEE_TYPE;
	}

	public void setCR_LATE_FEE_TYPE(String CR_LATE_FEE_TYPE) {
		this.CR_LATE_FEE_TYPE = CR_LATE_FEE_TYPE;
	}

	public String getCR_RESERVE_TYPE() {
		 return CR_RESERVE_TYPE;
	}

	public void setCR_RESERVE_TYPE(String CR_RESERVE_TYPE) {
		this.CR_RESERVE_TYPE = CR_RESERVE_TYPE;
	}

	public String getCR_RESERVE_OPTIONS() {
		 return CR_RESERVE_OPTIONS;
	}

	public void setCR_RESERVE_OPTIONS(String CR_RESERVE_OPTIONS) {
		this.CR_RESERVE_OPTIONS = CR_RESERVE_OPTIONS;
	}

	public Integer getCR_NO_OF_YEARS() {
		 return CR_NO_OF_YEARS;
	}

	public void setCR_NO_OF_YEARS(Integer CR_NO_OF_YEARS) {
		this.CR_NO_OF_YEARS = CR_NO_OF_YEARS;
	}

	public String getCR_RESERVE_CR_BASIS() {
		 return CR_RESERVE_CR_BASIS;
	}

	public void setCR_RESERVE_CR_BASIS(String CR_RESERVE_CR_BASIS) {
		this.CR_RESERVE_CR_BASIS = CR_RESERVE_CR_BASIS;
	}

	public String getCR_PAY_TO() {
		 return CR_PAY_TO;
	}

	public void setCR_PAY_TO(String CR_PAY_TO) {
		this.CR_PAY_TO = CR_PAY_TO;
	}

	public String getCR_WAITING_YN() {
		 return CR_WAITING_YN;
	}

	public void setCR_WAITING_YN(String CR_WAITING_YN) {
		this.CR_WAITING_YN = CR_WAITING_YN;
	}

	public String getCR_LIEN_YN() {
		 return CR_LIEN_YN;
	}

	public void setCR_LIEN_YN(String CR_LIEN_YN) {
		this.CR_LIEN_YN = CR_LIEN_YN;
	}

	public String getCR_UNIT_PRICE() {
		 return CR_UNIT_PRICE;
	}

	public void setCR_UNIT_PRICE(String CR_UNIT_PRICE) {
		this.CR_UNIT_PRICE = CR_UNIT_PRICE;
	}

	public String getCR_PREM_DED() {
		 return CR_PREM_DED;
	}

	public void setCR_PREM_DED(String CR_PREM_DED) {
		this.CR_PREM_DED = CR_PREM_DED;
	}

	public Double getCR_HIBAH_FEE_AMT() {
		 return CR_HIBAH_FEE_AMT;
	}

	public void setCR_HIBAH_FEE_AMT(Double CR_HIBAH_FEE_AMT) {
		this.CR_HIBAH_FEE_AMT = CR_HIBAH_FEE_AMT;
	}

	public String getCR_HIBAH_YN() {
		 return CR_HIBAH_YN;
	}

	public void setCR_HIBAH_YN(String CR_HIBAH_YN) {
		this.CR_HIBAH_YN = CR_HIBAH_YN;
	}

	public String getUI_M_LOSS_DESC() {
		return UI_M_LOSS_DESC;
	}

	public void setUI_M_LOSS_DESC(String ui_m_loss_desc) {
		UI_M_LOSS_DESC = ui_m_loss_desc;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String m_cover_desc) {
		UI_M_COVER_DESC = m_cover_desc;
	}

	public String getUI_M_DISABLE_DESC() {
		return UI_M_DISABLE_DESC;
	}

	public void setUI_M_DISABLE_DESC(String ui_m_disable_desc) {
		UI_M_DISABLE_DESC = ui_m_disable_desc;
	}



	/**
	 * @return the cR_FORMULA_DESC
	 */
	public String getCR_FORMULA_DESC() {
		return CR_FORMULA_DESC;
	}

	/**
	 * @param cr_formula_desc the cR_FORMULA_DESC to set
	 */
	public void setCR_FORMULA_DESC(String cr_formula_desc) {
		CR_FORMULA_DESC = cr_formula_desc;
	}

	public String getCR_FM_CODE() {
		return CR_FM_CODE;
	}

	public void setCR_FM_CODE(String cr_fm_code) {
		CR_FM_CODE = cr_fm_code;
	}
	
	/*Added by sankara narayanan for Hospital Cash plan on 26/04/2017*/
	@Column(name="CR_PRE_CLM_YN")
	private String CR_PRE_CLM_YN;
	
	@Column(name="CR_PRE_WAIT_MNTHS ")
	private Integer CR_PRE_WAIT_MNTHS ;


	public String getCR_PRE_CLM_YN() {
		return CR_PRE_CLM_YN;
	}

	public void setCR_PRE_CLM_YN(String cR_PRE_CLM_YN) {
		CR_PRE_CLM_YN = cR_PRE_CLM_YN;
	}

	public Integer getCR_PRE_WAIT_MNTHS() {
		return CR_PRE_WAIT_MNTHS;
	}

	public void setCR_PRE_WAIT_MNTHS(Integer cR_PRE_WAIT_MNTHS) {
		CR_PRE_WAIT_MNTHS = cR_PRE_WAIT_MNTHS;
	}
	
	
	/*end*/
	
	
	/*Added by raja  for Hospital Cash plan on 28/04/2017*/
	
	@Column(name="CR_MAX_VISITS")
	private int CR_MAX_VISITS;


	public int getCR_MAX_VISITS() {
		return CR_MAX_VISITS;
	}

	public void setCR_MAX_VISITS(int cR_MAX_VISITS) {
		CR_MAX_VISITS = cR_MAX_VISITS;
	}
	
	/*end*/
	
	/*Added by raja  for Hospital Cash plan on 05/05/2017*/
	
	@Column(name="CR_WAIT_HRS")
	private int CR_WAIT_HRS;


	public int getCR_WAIT_HRS() {
		return CR_WAIT_HRS;
	}

	public void setCR_WAIT_HRS(int cR_WAIT_HRS) {
		CR_WAIT_HRS = cR_WAIT_HRS;
	}
	
	
	/*end*/
}

