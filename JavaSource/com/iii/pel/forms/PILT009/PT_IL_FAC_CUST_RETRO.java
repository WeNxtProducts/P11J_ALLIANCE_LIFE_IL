package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_CUST_RETRO")
public class PT_IL_FAC_CUST_RETRO extends BaseValueBean {

	@Column(name="FCR_SYS_ID")
	private Double FCR_SYS_ID;
	
	@Column(name="FCR_FPCU_SYS_ID")
	private Double FCR_FPCU_SYS_ID;
	
	@Column(name="FCR_FO_SYS_ID")
	private Double FCR_FO_SYS_ID;
	
	@Column(name="FCR_REF_NO")
	private String FCR_REF_NO;
	
	@Column(name="FCR_SHARE_PERC")
	private Double FCR_SHARE_PERC;

	@Column(name="FCR_RETRO_COMM_FIRST_YR")
	private Double FCR_RETRO_COMM_FIRST_YR;

	@Column(name="FCR_RETRO_COMM_SUB_YRS")
	private Double FCR_RETRO_COMM_SUB_YRS;

	@Column(name="FCR_RETRO_TAX_FIRST_YR")
	private Double FCR_RETRO_TAX_FIRST_YR;

	@Column(name="FCR_RETRO_TAX_SUB_YRS")
	private Double FCR_RETRO_TAX_SUB_YRS;
	
	@Column(name="FCR_DEL_FLAG")
	private String FCR_DEL_FLAG;
	
	@Column(name="FCR_CR_DT")
	private Date FCR_CR_DT;
	
	@Column(name="FCR_CR_UID")
	private String FCR_CR_UID;
	
	@Column(name="FCR_UPD_DT")
	private Date FCR_UPD_DT;
	
	@Column(name="FCR_UPD_UID")
	private String FCR_UPD_UID;
	
	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getFCR_SYS_ID() {
		return FCR_SYS_ID;
	}

	public void setFCR_SYS_ID(Double fcr_sys_id) {
		FCR_SYS_ID = fcr_sys_id;
	}

	public Double getFCR_FPCU_SYS_ID() {
		return FCR_FPCU_SYS_ID;
	}

	public void setFCR_FPCU_SYS_ID(Double fcr_fpcu_sys_id) {
		FCR_FPCU_SYS_ID = fcr_fpcu_sys_id;
	}

	public Double getFCR_FO_SYS_ID() {
		return FCR_FO_SYS_ID;
	}

	public void setFCR_FO_SYS_ID(Double fcr_fo_sys_id) {
		FCR_FO_SYS_ID = fcr_fo_sys_id;
	}

	public String getFCR_REF_NO() {
		return FCR_REF_NO;
	}

	public void setFCR_REF_NO(String fcr_ref_no) {
		FCR_REF_NO = fcr_ref_no;
	}

	public Double getFCR_SHARE_PERC() {
		return FCR_SHARE_PERC;
	}

	public void setFCR_SHARE_PERC(Double fcr_share_perc) {
		FCR_SHARE_PERC = fcr_share_perc;
	}

	public Double getFCR_RETRO_COMM_FIRST_YR() {
		return FCR_RETRO_COMM_FIRST_YR;
	}

	public void setFCR_RETRO_COMM_FIRST_YR(Double fcr_retro_comm_first_yr) {
		FCR_RETRO_COMM_FIRST_YR = fcr_retro_comm_first_yr;
	}

	public Double getFCR_RETRO_COMM_SUB_YRS() {
		return FCR_RETRO_COMM_SUB_YRS;
	}

	public void setFCR_RETRO_COMM_SUB_YRS(Double fcr_retro_comm_sub_yrs) {
		FCR_RETRO_COMM_SUB_YRS = fcr_retro_comm_sub_yrs;
	}

	public Double getFCR_RETRO_TAX_FIRST_YR() {
		return FCR_RETRO_TAX_FIRST_YR;
	}

	public void setFCR_RETRO_TAX_FIRST_YR(Double fcr_retro_tax_first_yr) {
		FCR_RETRO_TAX_FIRST_YR = fcr_retro_tax_first_yr;
	}

	public Double getFCR_RETRO_TAX_SUB_YRS() {
		return FCR_RETRO_TAX_SUB_YRS;
	}

	public void setFCR_RETRO_TAX_SUB_YRS(Double fcr_retro_tax_sub_yrs) {
		FCR_RETRO_TAX_SUB_YRS = fcr_retro_tax_sub_yrs;
	}

	public String getFCR_DEL_FLAG() {
		return FCR_DEL_FLAG;
	}

	public void setFCR_DEL_FLAG(String fcr_del_flag) {
		FCR_DEL_FLAG = fcr_del_flag;
	}

	public Date getFCR_CR_DT() {
		return FCR_CR_DT;
	}

	public void setFCR_CR_DT(Date fcr_cr_dt) {
		FCR_CR_DT = fcr_cr_dt;
	}

	public String getFCR_CR_UID() {
		return FCR_CR_UID;
	}

	public void setFCR_CR_UID(String fcr_cr_uid) {
		FCR_CR_UID = fcr_cr_uid;
	}

	public Date getFCR_UPD_DT() {
		return FCR_UPD_DT;
	}

	public void setFCR_UPD_DT(Date fcr_upd_dt) {
		FCR_UPD_DT = fcr_upd_dt;
	}

	public String getFCR_UPD_UID() {
		return FCR_UPD_UID;
	}

	public void setFCR_UPD_UID(String fcr_upd_uid) {
		FCR_UPD_UID = fcr_upd_uid;
	}
}
