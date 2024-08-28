package com.iii.pel.forms.PILM043;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_RI_POOL_SETUP")
public class PM_IL_RI_POOL_SETUP extends BaseValueBean{
	
	@Column(name="RPS_CODE")
	private String RPS_CODE;
	
	@Column(name = "RPS_DESC" )
	private String RPS_DESC;
	
	@Column(name = "RPS_SHORT_DESC")
	private String RPS_SHORT_DESC;
	
	@Column(name = "RPS_LONG_DESC")
	private String RPS_LONG_DESC;
	
	@Column(name = "RPS_BL_DESC")
	private String RPS_BL_DESC;
	
	@Column(name = "RPS_BL_SHORT_DESC")
	private String RPS_BL_SHORT_DESC;
	
	@Column(name = "RPS_BL_LONG_DESC")
	private String RPS_BL_LONG_DESC;
	
	@Column(name = "RPS_CR_UID")
	private String RPS_CR_UID;
	
	@Column(name = "RPS_UPD_UID")
	private String RPS_UPD_UID;
	
	@Column(name = "RPS_EFF_FM_DT")
	private Date RPS_EFF_FM_DT; 
	
	@Column(name = "RPS_EFF_TO_DT")
	private Date RPS_EFF_TO_DT;
	
	@Column(name = "RPS_CR_DT")
	private Date RPS_CR_DT;
	
	@Column(name = "RPS_UPD_DT")
	private Date RPS_UPD_DT;

	public String getRPS_CODE() {
		return RPS_CODE;
	}

	public void setRPS_CODE(String rps_code) {
		RPS_CODE = rps_code;
	}

	public String getRPS_DESC() {
		return RPS_DESC;
	}

	public void setRPS_DESC(String rps_desc) {
		RPS_DESC = rps_desc;
	}

	public String getRPS_SHORT_DESC() {
		return RPS_SHORT_DESC;
	}

	public void setRPS_SHORT_DESC(String rps_short_desc) {
		RPS_SHORT_DESC = rps_short_desc;
	}

	public String getRPS_LONG_DESC() {
		return RPS_LONG_DESC;
	}

	public void setRPS_LONG_DESC(String rps_long_desc) {
		RPS_LONG_DESC = rps_long_desc;
	}

	public String getRPS_BL_DESC() {
		return RPS_BL_DESC;
	}

	public void setRPS_BL_DESC(String rps_bl_desc) {
		RPS_BL_DESC = rps_bl_desc;
	}

	public String getRPS_BL_SHORT_DESC() {
		return RPS_BL_SHORT_DESC;
	}

	public void setRPS_BL_SHORT_DESC(String rps_bl_short_desc) {
		RPS_BL_SHORT_DESC = rps_bl_short_desc;
	}

	public String getRPS_BL_LONG_DESC() {
		return RPS_BL_LONG_DESC;
	}

	public void setRPS_BL_LONG_DESC(String rps_bl_long_desc) {
		RPS_BL_LONG_DESC = rps_bl_long_desc;
	}

	public String getRPS_CR_UID() {
		return RPS_CR_UID;
	}

	public void setRPS_CR_UID(String rps_cr_uid) {
		RPS_CR_UID = rps_cr_uid;
	}

	public String getRPS_UPD_UID() {
		return RPS_UPD_UID;
	}

	public void setRPS_UPD_UID(String rps_upd_uid) {
		RPS_UPD_UID = rps_upd_uid;
	}

	public Date getRPS_EFF_FM_DT() {
		return RPS_EFF_FM_DT;
	}

	public void setRPS_EFF_FM_DT(Date rps_eff_fm_dt) {
		RPS_EFF_FM_DT = rps_eff_fm_dt;
	}

	public Date getRPS_EFF_TO_DT() {
		return RPS_EFF_TO_DT;
	}

	public void setRPS_EFF_TO_DT(Date rps_eff_to_dt) {
		RPS_EFF_TO_DT = rps_eff_to_dt;
	}

	public Date getRPS_CR_DT() {
		return RPS_CR_DT;
	}

	public void setRPS_CR_DT(Date rps_cr_dt) {
		RPS_CR_DT = rps_cr_dt;
	}

	public Date getRPS_UPD_DT() {
		return RPS_UPD_DT;
	}

	public void setRPS_UPD_DT(Date rps_upd_dt) {
		RPS_UPD_DT = rps_upd_dt;
	} 

}
