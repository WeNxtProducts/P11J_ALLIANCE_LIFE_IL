package com.iii.pel.forms.PILM048_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BANK_CHARGE_SETUP_DTL")
public class PM_BANK_CHARGE_SETUP_DTL extends BaseValueBean{
	
	
	@Column(name="BCSD_AMT_LC_FM")
	private Double BCSD_AMT_LC_FM;

	@Column(name="BCSD_AMT_LC_TO")
	private Double BCSD_AMT_LC_TO;

	@Column(name="BCSD_RATE")
	private Double BCSD_RATE;

	@Column(name="BCSD_RATE_PER")
	private Double BCSD_RATE_PER;

	@Column(name="BCSD_MIN_CHG_LC")
	private Double BCSD_MIN_CHG_LC;

	@Column(name="BCSD_MAX_CHG_LC")
	private Double BCSD_MAX_CHG_LC;

	@Column(name="BCSD_EFF_FM_DT")
	private Date BCSD_EFF_FM_DT;
	
	@Column(name="BCSD_EFF_TO_DT")
	private Date BCSD_EFF_TO_DT;
	
	@Column(name="BCSD_SYS_ID")
	private Double BCSD_SYS_ID;
	
	@Column(name="BCSD_BCSH_SYS_ID")
	private Double BCSD_BCSH_SYS_ID;
	
	@Column(name="BCSD_CR_DT")
	private Date BCSD_CR_DT;
	
	@Column(name="BCSD_CR_UID")
	private String BCSD_CR_UID;
	
	@Column(name="BCSD_UPD_DT")
	private Date BCSD_UPD_DT;
	
	@Column(name="BCSD_UPD_UID")
	private String BCSD_UPD_UID;
	
	private boolean CHECK_BOX;
	
	public PM_BANK_CHARGE_SETUP_DTL(Double BCSD_AMT_LC_FM,Double BCSD_AMT_LC_TO,Double BCSD_RATE,Double BCSD_RATE_PER,
			Double BCSD_MIN_CHG_LC,Double BCSD_MAX_CHG_LC,Date BCSD_EFF_FM_DT,Date BCSD_EFF_TO_DT){
		this.BCSD_AMT_LC_FM = BCSD_AMT_LC_FM;
		this.BCSD_AMT_LC_TO = BCSD_AMT_LC_TO;
		this.BCSD_RATE = BCSD_RATE;
		this.BCSD_RATE_PER = BCSD_RATE_PER;
		this.BCSD_MIN_CHG_LC = BCSD_MIN_CHG_LC;
		this.BCSD_MAX_CHG_LC = BCSD_MAX_CHG_LC;
		this.BCSD_EFF_FM_DT = BCSD_EFF_FM_DT;
		this.BCSD_EFF_TO_DT = BCSD_EFF_TO_DT;
	}


	public PM_BANK_CHARGE_SETUP_DTL() {
		// TODO Auto-generated constructor stub
	}


	public Date getBCSD_EFF_FM_DT() {
		return BCSD_EFF_FM_DT;
	}

	public void setBCSD_EFF_FM_DT(Date bcsd_eff_fm_dt) {
		BCSD_EFF_FM_DT = bcsd_eff_fm_dt;
	}

	public Date getBCSD_EFF_TO_DT() {
		return BCSD_EFF_TO_DT;
	}

	public void setBCSD_EFF_TO_DT(Date bcsd_eff_to_dt) {
		BCSD_EFF_TO_DT = bcsd_eff_to_dt;
	}

	public Double getBCSD_AMT_LC_FM() {
		return BCSD_AMT_LC_FM;
	}

	public void setBCSD_AMT_LC_FM(Double BCSD_AMT_LC_FM) {
		this.BCSD_AMT_LC_FM = BCSD_AMT_LC_FM;
	}

	public Double getBCSD_AMT_LC_TO() {
		return BCSD_AMT_LC_TO;
	}

	public void setBCSD_AMT_LC_TO(Double BCSD_AMT_LC_TO) {
		this.BCSD_AMT_LC_TO = BCSD_AMT_LC_TO;
	}

	public Double getBCSD_RATE() {
		return BCSD_RATE;
	}

	public void setBCSD_RATE(Double BCSD_RATE) {
		this.BCSD_RATE = BCSD_RATE;
	}

	public Double getBCSD_RATE_PER() {
		return BCSD_RATE_PER;
	}

	public void setBCSD_RATE_PER(Double BCSD_RATE_PER) {
		this.BCSD_RATE_PER = BCSD_RATE_PER;
	}

	public Double getBCSD_MIN_CHG_LC() {
		return BCSD_MIN_CHG_LC;
	}

	public void setBCSD_MIN_CHG_LC(Double BCSD_MIN_CHG_LC) {
		this.BCSD_MIN_CHG_LC = BCSD_MIN_CHG_LC;
	}

	public Double getBCSD_MAX_CHG_LC() {
		return BCSD_MAX_CHG_LC;
	}

	public void setBCSD_MAX_CHG_LC(Double BCSD_MAX_CHG_LC) {
		this.BCSD_MAX_CHG_LC = BCSD_MAX_CHG_LC;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}


	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}


	public Double getBCSD_SYS_ID() {
		return BCSD_SYS_ID;
	}


	public void setBCSD_SYS_ID(Double bcsd_sys_id) {
		BCSD_SYS_ID = bcsd_sys_id;
	}


	public Double getBCSD_BCSH_SYS_ID() {
		return BCSD_BCSH_SYS_ID;
	}


	public void setBCSD_BCSH_SYS_ID(Double bcsd_bcsh_sys_id) {
		BCSD_BCSH_SYS_ID = bcsd_bcsh_sys_id;
	}


	/**
	 * @return the bCSD_CR_DT
	 */
	public Date getBCSD_CR_DT() {
		return BCSD_CR_DT;
	}


	/**
	 * @param bcsd_cr_dt the bCSD_CR_DT to set
	 */
	public void setBCSD_CR_DT(Date bcsd_cr_dt) {
		BCSD_CR_DT = bcsd_cr_dt;
	}


	/**
	 * @return the bCSD_CR_UID
	 */
	public String getBCSD_CR_UID() {
		return BCSD_CR_UID;
	}


	/**
	 * @param bcsd_cr_uid the bCSD_CR_UID to set
	 */
	public void setBCSD_CR_UID(String bcsd_cr_uid) {
		BCSD_CR_UID = bcsd_cr_uid;
	}


	/**
	 * @return the bCSD_UPD_DT
	 */
	public Date getBCSD_UPD_DT() {
		return BCSD_UPD_DT;
	}


	/**
	 * @param bcsd_upd_dt the bCSD_UPD_DT to set
	 */
	public void setBCSD_UPD_DT(Date bcsd_upd_dt) {
		BCSD_UPD_DT = bcsd_upd_dt;
	}


	/**
	 * @return the bCSD_UPD_UID
	 */
	public String getBCSD_UPD_UID() {
		return BCSD_UPD_UID;
	}


	/**
	 * @param bcsd_upd_uid the bCSD_UPD_UID to set
	 */
	public void setBCSD_UPD_UID(String bcsd_upd_uid) {
		BCSD_UPD_UID = bcsd_upd_uid;
	}


	
}
