package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_DISC_LOAD")
public class PT_IL_FAC_DISC_LOAD extends BaseValueBean {

	@Column(name="FDL_SYS_ID")
	private Double FDL_SYS_ID;
	
	@Column(name="FDL_FD_SYS_ID")
	private Double FDL_FD_SYS_ID;
	
	@Column(name="FDL_SRNO")
	private Double FDL_SRNO;

	@Column(name="FDL_DISC_LOAD_TYPE")
	private String FDL_DISC_LOAD_TYPE;

	@Column(name="FDL_DISC_LOAD_CODE")
	private String FDL_DISC_LOAD_CODE;
	
	@Column(name="FDL_RATE")
	private Double FDL_RATE;
	
	@Column(name="FDL_RATE_PER")
	private Double FDL_RATE_PER;

	@Column(name="FDL_APPL_PERC")
	private Double FDL_APPL_PERC;

	@Column(name="FDL_FC_DISC_LOAD_VALUE")
	private Double FDL_FC_DISC_LOAD_VALUE;

	@Column(name="FDL_LC_DISC_LOAD_VALUE")
	private Double FDL_LC_DISC_LOAD_VALUE;
	  
	@Column(name="FDL_CR_DT")
	private Date FDL_CR_DT;
	
	@Column(name="FDL_CR_UID")
	private String FDL_CR_UID;
	
	@Column(name="FDL_UPD_DT")
	private Date FDL_UPD_DT;
	
	@Column(name="FDL_UPD_UID")
	private String FDL_UPD_UID;
	
	private String UI_M_DISCLOAD_DESC;
	
	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getFDL_SRNO() {
		return FDL_SRNO;
	}

	public void setFDL_SRNO(Double FDL_SRNO) {
		this.FDL_SRNO = FDL_SRNO;
	}

	public String getFDL_DISC_LOAD_TYPE() {
		return FDL_DISC_LOAD_TYPE;
	}

	public void setFDL_DISC_LOAD_TYPE(String FDL_DISC_LOAD_TYPE) {
		this.FDL_DISC_LOAD_TYPE = FDL_DISC_LOAD_TYPE;
	}

	public String getFDL_DISC_LOAD_CODE() {
		return FDL_DISC_LOAD_CODE;
	}

	public void setFDL_DISC_LOAD_CODE(String FDL_DISC_LOAD_CODE) {
		this.FDL_DISC_LOAD_CODE = FDL_DISC_LOAD_CODE;
	}

	public Double getFDL_APPL_PERC() {
		return FDL_APPL_PERC;
	}

	public void setFDL_APPL_PERC(Double FDL_APPL_PERC) {
		this.FDL_APPL_PERC = FDL_APPL_PERC;
	}

	public Double getFDL_RATE() {
		return FDL_RATE;
	}

	public void setFDL_RATE(Double FDL_RATE) {
		this.FDL_RATE = FDL_RATE;
	}

	public Double getFDL_RATE_PER() {
		return FDL_RATE_PER;
	}

	public void setFDL_RATE_PER(Double FDL_RATE_PER) {
		this.FDL_RATE_PER = FDL_RATE_PER;
	}

	public Double getFDL_FC_DISC_LOAD_VALUE() {
		return FDL_FC_DISC_LOAD_VALUE;
	}

	public void setFDL_FC_DISC_LOAD_VALUE(Double FDL_FC_DISC_LOAD_VALUE) {
		this.FDL_FC_DISC_LOAD_VALUE = FDL_FC_DISC_LOAD_VALUE;
	}

	public Double getFDL_LC_DISC_LOAD_VALUE() {
		return FDL_LC_DISC_LOAD_VALUE;
	}

	public void setFDL_LC_DISC_LOAD_VALUE(Double FDL_LC_DISC_LOAD_VALUE) {
		this.FDL_LC_DISC_LOAD_VALUE = FDL_LC_DISC_LOAD_VALUE;
	}

	public String getUI_M_DISCLOAD_DESC() {
		return UI_M_DISCLOAD_DESC;
	}

	public void setUI_M_DISCLOAD_DESC(String UI_M_DISCLOAD_DESC) {
		this.UI_M_DISCLOAD_DESC = UI_M_DISCLOAD_DESC;
	}

	public Double getFDL_SYS_ID() {
		return FDL_SYS_ID;
	}

	public void setFDL_SYS_ID(Double fdl_sys_id) {
		FDL_SYS_ID = fdl_sys_id;
	}

	public Double getFDL_FD_SYS_ID() {
		return FDL_FD_SYS_ID;
	}

	public void setFDL_FD_SYS_ID(Double fdl_fd_sys_id) {
		FDL_FD_SYS_ID = fdl_fd_sys_id;
	}

	public Date getFDL_CR_DT() {
		return FDL_CR_DT;
	}

	public void setFDL_CR_DT(Date fdl_cr_dt) {
		FDL_CR_DT = fdl_cr_dt;
	}

	public String getFDL_CR_UID() {
		return FDL_CR_UID;
	}

	public void setFDL_CR_UID(String fdl_cr_uid) {
		FDL_CR_UID = fdl_cr_uid;
	}

	public Date getFDL_UPD_DT() {
		return FDL_UPD_DT;
	}

	public void setFDL_UPD_DT(Date fdl_upd_dt) {
		FDL_UPD_DT = fdl_upd_dt;
	}

	public String getFDL_UPD_UID() {
		return FDL_UPD_UID;
	}

	public void setFDL_UPD_UID(String fdl_upd_uid) {
		FDL_UPD_UID = fdl_upd_uid;
	}
}
