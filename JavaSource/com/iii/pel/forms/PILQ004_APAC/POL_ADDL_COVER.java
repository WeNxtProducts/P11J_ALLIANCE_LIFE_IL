package com.iii.pel.forms.PILQ004_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_ADDL_COVER")
public class POL_ADDL_COVER extends BaseValueBean {

	@Column(name="POAC_COVER_CODE")
	private String POAC_COVER_CODE;

	@Column(name="POAC_LC_SA")
	private Double POAC_LC_SA;

	private Double UI_M_POAC_TOTAL_LC_SUM;

	@Column(name="POAC_PERIOD")
	private Double POAC_PERIOD;

	@Column(name="POAC_PREM_PAY_YRS")
	private Double POAC_PREM_PAY_YRS;

	private Double UI_M_TOT_LC_SA;

	@Column(name="POAC_FM_DT")
	private Date POAC_FM_DT;

	@Column(name="POAC_LC_PREM")
	private Double POAC_LC_PREM;

	private String UI_M_POAC_COVER_DESC;
	
	@Column(name="POAC_POL_SYS_ID")
	private Double POAC_POL_SYS_ID;


	public String getPOAC_COVER_CODE() {
		return POAC_COVER_CODE;
	}

	public void setPOAC_COVER_CODE(String POAC_COVER_CODE) {
		this.POAC_COVER_CODE = POAC_COVER_CODE;
	}

	public Double getPOAC_LC_SA() {
		return POAC_LC_SA;
	}

	public void setPOAC_LC_SA(Double POAC_LC_SA) {
		this.POAC_LC_SA = POAC_LC_SA;
	}

	public Date getPOAC_FM_DT() {
		 return POAC_FM_DT;
	}

	public void setPOAC_FM_DT(Date POAC_FM_DT) {
		this.POAC_FM_DT = POAC_FM_DT;
	}

	public String getUI_M_POAC_COVER_DESC() {
		return UI_M_POAC_COVER_DESC;
	}

	public void setUI_M_POAC_COVER_DESC(String UI_M_POAC_COVER_DESC) {
		this.UI_M_POAC_COVER_DESC = UI_M_POAC_COVER_DESC;
	}

	public Double getPOAC_LC_PREM() {
		return POAC_LC_PREM;
	}

	public void setPOAC_LC_PREM(Double poac_lc_prem) {
		POAC_LC_PREM = poac_lc_prem;
	}

	public Double getPOAC_PERIOD() {
		return POAC_PERIOD;
	}

	public void setPOAC_PERIOD(Double poac_period) {
		POAC_PERIOD = poac_period;
	}

	public Double getPOAC_PREM_PAY_YRS() {
		return POAC_PREM_PAY_YRS;
	}

	public void setPOAC_PREM_PAY_YRS(Double poac_prem_pay_yrs) {
		POAC_PREM_PAY_YRS = poac_prem_pay_yrs;
	}

	public Double getPOAC_POL_SYS_ID() {
		return POAC_POL_SYS_ID;
	}

	public void setPOAC_POL_SYS_ID(Double poac_pol_sys_id) {
		POAC_POL_SYS_ID = poac_pol_sys_id;
	}

	

	public Double getUI_M_POAC_TOTAL_LC_SUM() {
		return UI_M_POAC_TOTAL_LC_SUM;
	}

	public void setUI_M_POAC_TOTAL_LC_SUM(Double ui_m_poac_total_lc_sum) {
		UI_M_POAC_TOTAL_LC_SUM = ui_m_poac_total_lc_sum;
	}

	/**
	 * @return the uI_M_TOT_LC_SA
	 */
	public Double getUI_M_TOT_LC_SA() {
		return UI_M_TOT_LC_SA;
	}

	/**
	 * @param ui_m_tot_lc_sa the uI_M_TOT_LC_SA to set
	 */
	public void setUI_M_TOT_LC_SA(Double ui_m_tot_lc_sa) {
		UI_M_TOT_LC_SA = ui_m_tot_lc_sa;
	}
}
