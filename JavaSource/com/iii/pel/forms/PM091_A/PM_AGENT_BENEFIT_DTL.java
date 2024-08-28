package com.iii.pel.forms.PM091_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BENEFIT_DTL")
public class PM_AGENT_BENEFIT_DTL extends BaseValueBean {
	@Column(name="ABD_ABH_BNF_CODE")
	private String ABD_ABH_BNF_CODE;
	
	@Column(name="ABD_RATE")
	private Double ABD_RATE;

	@Column(name="ABD_RATE_PER")
	private Double ABD_RATE_PER;

	@Column(name="ABD_LC_MIN_AMT")
	private Double ABD_LC_MIN_AMT;

	@Column(name="ABD_LC_MAX_AMT")
	private Double ABD_LC_MAX_AMT;

	@Column(name="ABD_LC_FYC_FM")
	private Double ABD_LC_FYC_FM;

	@Column(name="ABD_LC_FYC_TO")
	private Double ABD_LC_FYC_TO;

	@Column(name="ABD_NO_OF_POL_FM")
	private Integer ABD_NO_OF_POL_FM;

	@Column(name="ABD_NO_OF_POL_TO")
	private Integer ABD_NO_OF_POL_TO;

	@Column(name="ABD_BNF_FREQ")
	private String ABD_BNF_FREQ;

	@Column(name="ABD_PROD_TYPE")
	private String ABD_PROD_TYPE;

	@Column(name="ABD_TYPE")
	private String ABD_TYPE;
	

	@Column(name="ABD_CR_DT")
	private Date ABD_CR_DT;

	@Column(name="ABD_CR_UID")
	private String ABD_CR_UID;
	
	@Column(name="ABD_UPD_DT")
	private Date ABD_UPD_DT;

	@Column(name="ABD_UPD_UID")
	private String ABD_UPD_UID;
	
	public PM_AGENT_BENEFIT_DTL(){
		
	}
	
	private boolean selected;
	private boolean rateDisabled = false;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getABD_RATE() {
		return ABD_RATE;
	}

	public void setABD_RATE(Double ABD_RATE) {
		this.ABD_RATE = ABD_RATE;
	}

	public Double getABD_RATE_PER() {
		return ABD_RATE_PER;
	}

	public void setABD_RATE_PER(Double ABD_RATE_PER) {
		this.ABD_RATE_PER = ABD_RATE_PER;
	}

	public Double getABD_LC_MIN_AMT() {
		return ABD_LC_MIN_AMT;
	}

	public void setABD_LC_MIN_AMT(Double ABD_LC_MIN_AMT) {
		this.ABD_LC_MIN_AMT = ABD_LC_MIN_AMT;
	}

	public Double getABD_LC_MAX_AMT() {
		return ABD_LC_MAX_AMT;
	}

	public void setABD_LC_MAX_AMT(Double ABD_LC_MAX_AMT) {
		this.ABD_LC_MAX_AMT = ABD_LC_MAX_AMT;
	}

	

	public Double getABD_LC_FYC_FM() {
		return ABD_LC_FYC_FM;
	}

	public void setABD_LC_FYC_FM(Double abd_lc_fyc_fm) {
		ABD_LC_FYC_FM = abd_lc_fyc_fm;
	}

	public Double getABD_LC_FYC_TO() {
		return ABD_LC_FYC_TO;
	}

	public void setABD_LC_FYC_TO(Double abd_lc_fyc_to) {
		ABD_LC_FYC_TO = abd_lc_fyc_to;
	}

	public Integer getABD_NO_OF_POL_FM() {
		return ABD_NO_OF_POL_FM;
	}

	public void setABD_NO_OF_POL_FM(Integer abd_no_of_pol_fm) {
		ABD_NO_OF_POL_FM = abd_no_of_pol_fm;
	}

	public Integer getABD_NO_OF_POL_TO() {
		return ABD_NO_OF_POL_TO;
	}

	public void setABD_NO_OF_POL_TO(Integer abd_no_of_pol_to) {
		ABD_NO_OF_POL_TO = abd_no_of_pol_to;
	}

	public String getABD_BNF_FREQ() {
		return ABD_BNF_FREQ;
	}

	public void setABD_BNF_FREQ(String ABD_BNF_FREQ) {
		this.ABD_BNF_FREQ = ABD_BNF_FREQ;
	}

	public String getABD_PROD_TYPE() {
		return ABD_PROD_TYPE;
	}

	public void setABD_PROD_TYPE(String ABD_PROD_TYPE) {
		this.ABD_PROD_TYPE = ABD_PROD_TYPE;
	}

	public String getABD_TYPE() {
		return ABD_TYPE;
	}

	public void setABD_TYPE(String ABD_TYPE) {
		if("F".equals(ABD_TYPE)){
			rateDisabled = true;
		}else{
			rateDisabled = false;
		}
		this.ABD_TYPE = ABD_TYPE;
	}

	public String getABD_ABH_BNF_CODE() {
		return ABD_ABH_BNF_CODE;
	}

	public void setABD_ABH_BNF_CODE(String abd_abh_bnf_code) {
		ABD_ABH_BNF_CODE = abd_abh_bnf_code;
	}

	

	public Date getABD_CR_DT() {
		return ABD_CR_DT;
	}

	public void setABD_CR_DT(Date abd_cr_dt) {
		ABD_CR_DT = abd_cr_dt;
	}

	public String getABD_CR_UID() {
		return ABD_CR_UID;
	}

	public void setABD_CR_UID(String abd_cr_uid) {
		ABD_CR_UID = abd_cr_uid;
	}

	public boolean isRateDisabled() {
		return rateDisabled;
	}

	public void setRateDisabled(boolean rateDisabled) {
		this.rateDisabled = rateDisabled;
	}

	public Date getABD_UPD_DT() {
		return ABD_UPD_DT;
	}

	public void setABD_UPD_DT(Date abd_upd_dt) {
		ABD_UPD_DT = abd_upd_dt;
	}

	public String getABD_UPD_UID() {
		return ABD_UPD_UID;
	}

	public void setABD_UPD_UID(String abd_upd_uid) {
		ABD_UPD_UID = abd_upd_uid;
	}
}
