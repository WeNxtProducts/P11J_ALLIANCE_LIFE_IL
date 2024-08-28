package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_CUST_RETRO_DETL")
public class PT_IL_FAC_CUST_RETRO_DETL extends BaseValueBean {
	
	@Column(name="FCRD_SYS_ID")
	private Double FCRD_SYS_ID;
	
	@Column(name="FCRD_FCR_SYS_ID")
	private Double FCRD_FCR_SYS_ID;
	
	@Column(name="FCRD_FD_SYS_ID")
	private Double FCRD_FD_SYS_ID;
	
	@Column(name="FCRD_SA_CURR_CODE")
	private String FCRD_SA_CURR_CODE;
	
	@Column(name="FCRD_FC_RETRO_SUM_ASSURED")
	private Double FCRD_FC_RETRO_SUM_ASSURED;

	@Column(name="FCRD_LC_RETRO_SUM_ASSURED")
	private Double FCRD_LC_RETRO_SUM_ASSURED;
	
	@Column(name="FCRD_FC_RETRO_PREM")
	private Double FCRD_FC_RETRO_PREM;

	@Column(name="FCRD_LC_RETRO_PREM")
	private Double FCRD_LC_RETRO_PREM;
	
	@Column(name="FCRD_FC_RETRO_COMM")
	private Double FCRD_FC_RETRO_COMM;

	@Column(name="FCRD_LC_RETRO_COMM")
	private Double FCRD_LC_RETRO_COMM;

	@Column(name="FCRD_FC_RETRO_TAX")
	private Double FCRD_FC_RETRO_TAX;
	
	@Column(name="FCRD_LC_RETRO_TAX")
	private Double FCRD_LC_RETRO_TAX;

	@Column(name="FCRD_SCHD_DT")
	private Date FCRD_SCHD_DT;
	
	@Column(name="FCRD_RETRO_CLOSE_YN")
	private String FCRD_RETRO_CLOSE_YN;
	
	@Column(name="FCRD_DEL_FLAG")
	private String FCRD_DEL_FLAG;
	
	@Column(name="FCRD_CR_DT")
	private Date FCRD_CR_DT;
	
	@Column(name="FCRD_CR_UID")
	private String FCRD_CR_UID;
	
	@Column(name="FCRD_UPD_DT")
	private Date FCRD_UPD_DT;
	
	@Column(name="FCRD_UPD_UID")
	private String FCRD_UPD_UID;


	public Double getFCRD_FC_RETRO_SUM_ASSURED() {
		return FCRD_FC_RETRO_SUM_ASSURED;
	}

	public void setFCRD_FC_RETRO_SUM_ASSURED(Double FCRD_FC_RETRO_SUM_ASSURED) {
		this.FCRD_FC_RETRO_SUM_ASSURED = FCRD_FC_RETRO_SUM_ASSURED;
	}

	public Double getFCRD_FC_RETRO_PREM() {
		return FCRD_FC_RETRO_PREM;
	}

	public void setFCRD_FC_RETRO_PREM(Double FCRD_FC_RETRO_PREM) {
		this.FCRD_FC_RETRO_PREM = FCRD_FC_RETRO_PREM;
	}

	public Double getFCRD_FC_RETRO_COMM() {
		return FCRD_FC_RETRO_COMM;
	}

	public void setFCRD_FC_RETRO_COMM(Double FCRD_FC_RETRO_COMM) {
		this.FCRD_FC_RETRO_COMM = FCRD_FC_RETRO_COMM;
	}

	public Double getFCRD_FC_RETRO_TAX() {
		return FCRD_FC_RETRO_TAX;
	}

	public void setFCRD_FC_RETRO_TAX(Double FCRD_FC_RETRO_TAX) {
		this.FCRD_FC_RETRO_TAX = FCRD_FC_RETRO_TAX;
	}

	public Date getFCRD_SCHD_DT() {
		 return FCRD_SCHD_DT;
	}

	public void setFCRD_SCHD_DT(Date FCRD_SCHD_DT) {
		this.FCRD_SCHD_DT = FCRD_SCHD_DT;
	}

	public Double getFCRD_LC_RETRO_SUM_ASSURED() {
		return FCRD_LC_RETRO_SUM_ASSURED;
	}

	public void setFCRD_LC_RETRO_SUM_ASSURED(Double FCRD_LC_RETRO_SUM_ASSURED) {
		this.FCRD_LC_RETRO_SUM_ASSURED = FCRD_LC_RETRO_SUM_ASSURED;
	}

	public Double getFCRD_LC_RETRO_COMM() {
		return FCRD_LC_RETRO_COMM;
	}

	public void setFCRD_LC_RETRO_COMM(Double FCRD_LC_RETRO_COMM) {
		this.FCRD_LC_RETRO_COMM = FCRD_LC_RETRO_COMM;
	}

	public Double getFCRD_LC_RETRO_PREM() {
		return FCRD_LC_RETRO_PREM;
	}

	public void setFCRD_LC_RETRO_PREM(Double FCRD_LC_RETRO_PREM) {
		this.FCRD_LC_RETRO_PREM = FCRD_LC_RETRO_PREM;
	}

	public Double getFCRD_LC_RETRO_TAX() {
		return FCRD_LC_RETRO_TAX;
	}

	public void setFCRD_LC_RETRO_TAX(Double FCRD_LC_RETRO_TAX) {
		this.FCRD_LC_RETRO_TAX = FCRD_LC_RETRO_TAX;
	}

	public Double getFCRD_SYS_ID() {
		return FCRD_SYS_ID;
	}

	public void setFCRD_SYS_ID(Double fcrd_sys_id) {
		FCRD_SYS_ID = fcrd_sys_id;
	}

	public Double getFCRD_FCR_SYS_ID() {
		return FCRD_FCR_SYS_ID;
	}

	public void setFCRD_FCR_SYS_ID(Double fcrd_fcr_sys_id) {
		FCRD_FCR_SYS_ID = fcrd_fcr_sys_id;
	}

	public Double getFCRD_FD_SYS_ID() {
		return FCRD_FD_SYS_ID;
	}

	public void setFCRD_FD_SYS_ID(Double fcrd_fd_sys_id) {
		FCRD_FD_SYS_ID = fcrd_fd_sys_id;
	}

	public String getFCRD_SA_CURR_CODE() {
		return FCRD_SA_CURR_CODE;
	}

	public void setFCRD_SA_CURR_CODE(String fcrd_sa_curr_code) {
		FCRD_SA_CURR_CODE = fcrd_sa_curr_code;
	}

	public String getFCRD_RETRO_CLOSE_YN() {
		return FCRD_RETRO_CLOSE_YN;
	}

	public void setFCRD_RETRO_CLOSE_YN(String fcrd_retro_close_yn) {
		FCRD_RETRO_CLOSE_YN = fcrd_retro_close_yn;
	}

	public String getFCRD_DEL_FLAG() {
		return FCRD_DEL_FLAG;
	}

	public void setFCRD_DEL_FLAG(String fcrd_del_flag) {
		FCRD_DEL_FLAG = fcrd_del_flag;
	}

	public Date getFCRD_CR_DT() {
		return FCRD_CR_DT;
	}

	public void setFCRD_CR_DT(Date fcrd_cr_dt) {
		FCRD_CR_DT = fcrd_cr_dt;
	}

	public String getFCRD_CR_UID() {
		return FCRD_CR_UID;
	}

	public void setFCRD_CR_UID(String fcrd_cr_uid) {
		FCRD_CR_UID = fcrd_cr_uid;
	}

	public Date getFCRD_UPD_DT() {
		return FCRD_UPD_DT;
	}

	public void setFCRD_UPD_DT(Date fcrd_upd_dt) {
		FCRD_UPD_DT = fcrd_upd_dt;
	}

	public String getFCRD_UPD_UID() {
		return FCRD_UPD_UID;
	}

	public void setFCRD_UPD_UID(String fcrd_upd_uid) {
		FCRD_UPD_UID = fcrd_upd_uid;
	}
}
