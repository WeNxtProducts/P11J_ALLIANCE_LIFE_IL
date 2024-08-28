package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_PART_CHRG")
public class PT_IL_FAC_PART_CHRG extends BaseValueBean {
	
	@Column(name="FPC_SYS_ID")
	private Double FPC_SYS_ID;
	
	@Column(name="FPC_FPCUD_SYS_ID")
	private Double FPC_FPCUD_SYS_ID;
	
	@Column(name="FPC_SRNO")
	private Double FPC_SRNO;

	@Column(name="FPC_CHRG_TYPE")
	private String FPC_CHRG_TYPE;

	@Column(name="FPC_CHRG_CODE")
	private String FPC_CHRG_CODE;

	@Column(name="FPC_RATE")
	private Double FPC_RATE;

	@Column(name="FPC_RATE_PER")
	private Double FPC_RATE_PER;

	@Column(name="FPC_APPLY_PERIOD")
	private String FPC_APPLY_PERIOD;

	@Column(name="FPC_CUST_SHARE_PERC")
	private Double FPC_CUST_SHARE_PERC;

	@Column(name="FPC_FC_VALUE")
	private Double FPC_FC_VALUE;

	@Column(name="FPC_LC_VALUE")
	private Double FPC_LC_VALUE;
	
	@Column(name="FPC_CR_DT")
	private Date FPC_CR_DT;
	
	@Column(name="FPC_CR_UID")
	private String FPC_CR_UID;
	
	@Column(name="FPC_UPD_DT")
	private Date FPC_UPD_DT;
	
	@Column(name="FPC_UPD_UID")
	private String FPC_UPD_UID;
	
	private String UI_M_FPC_CHRG_CODE_DESC;



	public Double getFPC_SRNO() {
		return FPC_SRNO;
	}

	public void setFPC_SRNO(Double FPC_SRNO) {
		this.FPC_SRNO = FPC_SRNO;
	}

	public String getFPC_CHRG_TYPE() {
		return FPC_CHRG_TYPE;
	}

	public void setFPC_CHRG_TYPE(String FPC_CHRG_TYPE) {
		this.FPC_CHRG_TYPE = FPC_CHRG_TYPE;
	}

	public String getFPC_CHRG_CODE() {
		return FPC_CHRG_CODE;
	}

	public void setFPC_CHRG_CODE(String FPC_CHRG_CODE) {
		this.FPC_CHRG_CODE = FPC_CHRG_CODE;
	}

	public Double getFPC_RATE() {
		return FPC_RATE;
	}

	public void setFPC_RATE(Double FPC_RATE) {
		this.FPC_RATE = FPC_RATE;
	}

	public Double getFPC_RATE_PER() {
		return FPC_RATE_PER;
	}

	public void setFPC_RATE_PER(Double FPC_RATE_PER) {
		this.FPC_RATE_PER = FPC_RATE_PER;
	}

	public String getFPC_APPLY_PERIOD() {
		return FPC_APPLY_PERIOD;
	}

	public void setFPC_APPLY_PERIOD(String FPC_APPLY_PERIOD) {
		this.FPC_APPLY_PERIOD = FPC_APPLY_PERIOD;
	}

	public Double getFPC_CUST_SHARE_PERC() {
		return FPC_CUST_SHARE_PERC;
	}

	public void setFPC_CUST_SHARE_PERC(Double FPC_CUST_SHARE_PERC) {
		this.FPC_CUST_SHARE_PERC = FPC_CUST_SHARE_PERC;
	}

	public Double getFPC_FC_VALUE() {
		return FPC_FC_VALUE;
	}

	public void setFPC_FC_VALUE(Double FPC_FC_VALUE) {
		this.FPC_FC_VALUE = FPC_FC_VALUE;
	}

	public Double getFPC_LC_VALUE() {
		return FPC_LC_VALUE;
	}

	public void setFPC_LC_VALUE(Double FPC_LC_VALUE) {
		this.FPC_LC_VALUE = FPC_LC_VALUE;
	}

	public String getUI_M_FPC_CHRG_CODE_DESC() {
		return UI_M_FPC_CHRG_CODE_DESC;
	}

	public void setUI_M_FPC_CHRG_CODE_DESC(String UI_M_FPC_CHRG_CODE_DESC) {
		this.UI_M_FPC_CHRG_CODE_DESC = UI_M_FPC_CHRG_CODE_DESC;
	}

	public Double getFPC_SYS_ID() {
		return FPC_SYS_ID;
	}

	public void setFPC_SYS_ID(Double fpc_sys_id) {
		FPC_SYS_ID = fpc_sys_id;
	}

	public Double getFPC_FPCUD_SYS_ID() {
		return FPC_FPCUD_SYS_ID;
	}

	public void setFPC_FPCUD_SYS_ID(Double fpc_fpcud_sys_id) {
		FPC_FPCUD_SYS_ID = fpc_fpcud_sys_id;
	}

	public Date getFPC_CR_DT() {
		return FPC_CR_DT;
	}

	public void setFPC_CR_DT(Date fpc_cr_dt) {
		FPC_CR_DT = fpc_cr_dt;
	}

	public String getFPC_CR_UID() {
		return FPC_CR_UID;
	}

	public void setFPC_CR_UID(String fpc_cr_uid) {
		FPC_CR_UID = fpc_cr_uid;
	}

	public Date getFPC_UPD_DT() {
		return FPC_UPD_DT;
	}

	public void setFPC_UPD_DT(Date fpc_upd_dt) {
		FPC_UPD_DT = fpc_upd_dt;
	}

	public String getFPC_UPD_UID() {
		return FPC_UPD_UID;
	}

	public void setFPC_UPD_UID(String fpc_upd_uid) {
		FPC_UPD_UID = fpc_upd_uid;
	}
}
