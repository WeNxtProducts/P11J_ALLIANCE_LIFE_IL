package com.iii.pel.forms.PILQ002;

import java.util.Date;


import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PS_IL_ANIVR_PROCESS")
public class PV_IL_BONUS extends BaseValueBean{
	
	@Column(name="AVR_POL_SYS_ID")
	private int AVR_POL_SYS_ID;
	
	@Column (name="AVR_LOAN_DT")
	private Date PV_BONUS_YEAR;

	@Column (name="AVR_LOAN_AMT")
	private int PV_BONUS;
	
	@Column (name="AVR_LOAN_INT")
	private int PV_BONUS_INT;

	/**
	 * @return the aVR_POL_SYS_ID
	 */
	public int getAVR_POL_SYS_ID() {
		return AVR_POL_SYS_ID;
	}

	/**
	 * @param avr_pol_sys_id the aVR_POL_SYS_ID to set
	 */
	public void setAVR_POL_SYS_ID(int avr_pol_sys_id) {
		AVR_POL_SYS_ID = avr_pol_sys_id;
	}

	/**
	 * @return the pV_BONUS_YEAR
	 */
	public Date getPV_BONUS_YEAR() {
		return PV_BONUS_YEAR;
	}

	/**
	 * @param pv_bonus_year the pV_BONUS_YEAR to set
	 */
	public void setPV_BONUS_YEAR(Date pv_bonus_year) {
		PV_BONUS_YEAR = pv_bonus_year;
	}

	/**
	 * @return the pV_BONUS
	 */
	public int getPV_BONUS() {
		return PV_BONUS;
	}

	/**
	 * @param pv_bonus the pV_BONUS to set
	 */
	public void setPV_BONUS(int pv_bonus) {
		PV_BONUS = pv_bonus;
	}

	/**
	 * @return the pV_BONUS_INT
	 */
	public int getPV_BONUS_INT() {
		return PV_BONUS_INT;
	}

	/**
	 * @param pv_bonus_int the pV_BONUS_INT to set
	 */
	public void setPV_BONUS_INT(int pv_bonus_int) {
		PV_BONUS_INT = pv_bonus_int;
	}

	

}
