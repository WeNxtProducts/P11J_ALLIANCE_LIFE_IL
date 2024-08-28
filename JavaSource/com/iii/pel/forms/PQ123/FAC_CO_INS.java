package com.iii.pel.forms.PQ123;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class FAC_CO_INS extends BaseValueBean {

	private Double RISK_ID;

	private Double TOTAL_LC_SI;

	private Double TOTAL_LC_PREM;

	private Double TOTAL_FAC_PER;

	@Column(name="CUST_CODE")
	private String CUST_CODE;

	@Column(name="CUST_NAME")
	private String CUST_NAME;

	@Column(name="SHAREPER")
	private Double SHAREPER;

	@Column(name="RETRO")
	private Double RETRO;

	@Column(name="RETRO_LC_SI")
	private Double RETRO_LC_SI;



	public Double getRISK_ID() {
		return RISK_ID;
	}

	public void setRISK_ID(Double RISK_ID) {
		this.RISK_ID = RISK_ID;
	}



	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String CUST_CODE) {
		this.CUST_CODE = CUST_CODE;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String CUST_NAME) {
		this.CUST_NAME = CUST_NAME;
	}

	

	/**
	 * @return the rETRO
	 */
	public Double getRETRO() {
		return RETRO;
	}

	/**
	 * @param retro the rETRO to set
	 */
	public void setRETRO(Double retro) {
		RETRO = retro;
	}

	/**
	 * @return the tOTAL_LC_SI
	 */
	public Double getTOTAL_LC_SI() {
		return TOTAL_LC_SI;
	}

	/**
	 * @param total_lc_si the tOTAL_LC_SI to set
	 */
	public void setTOTAL_LC_SI(Double total_lc_si) {
		TOTAL_LC_SI = total_lc_si;
	}

	/**
	 * @return the tOTAL_LC_PREM
	 */
	public Double getTOTAL_LC_PREM() {
		return TOTAL_LC_PREM;
	}

	/**
	 * @param total_lc_prem the tOTAL_LC_PREM to set
	 */
	public void setTOTAL_LC_PREM(Double total_lc_prem) {
		TOTAL_LC_PREM = total_lc_prem;
	}

	/**
	 * @return the tOTAL_FAC_PER
	 */
	public Double getTOTAL_FAC_PER() {
		return TOTAL_FAC_PER;
	}

	/**
	 * @param total_fac_per the tOTAL_FAC_PER to set
	 */
	public void setTOTAL_FAC_PER(Double total_fac_per) {
		TOTAL_FAC_PER = total_fac_per;
	}

	/**
	 * @return the sHAREPER
	 */
	public Double getSHAREPER() {
		return SHAREPER;
	}

	/**
	 * @param shareper the sHAREPER to set
	 */
	public void setSHAREPER(Double shareper) {
		SHAREPER = shareper;
	}

	/**
	 * @return the rETRO_LC_SI
	 */
	public Double getRETRO_LC_SI() {
		return RETRO_LC_SI;
	}

	/**
	 * @param retro_lc_si the rETRO_LC_SI to set
	 */
	public void setRETRO_LC_SI(Double retro_lc_si) {
		RETRO_LC_SI = retro_lc_si;
	}


}
