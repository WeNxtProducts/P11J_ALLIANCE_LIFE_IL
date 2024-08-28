package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_PART_CUST")
public class PT_IL_FAC_PART_CUST extends BaseValueBean {

	@Column(name="FPCU_SYS_ID")
	private Double FPCU_SYS_ID;
	
	@Column(name="FPCU_FO_SYS_ID")
	private Double FPCU_FO_SYS_ID;
	
	@Column(name="FPCU_CUST_CODE")
	private String FPCU_CUST_CODE;

	@Column(name="FPCU_SHARE_PERC")
	private Double FPCU_SHARE_PERC;

	@Column(name="FPCU_COMM_FIRST_YR")
	private Double FPCU_COMM_FIRST_YR;

	@Column(name="FPCU_COMM_SUB_YRS")
	private Double FPCU_COMM_SUB_YRS;

	@Column(name="FPCU_TAX_FIRST_YR")
	private Double FPCU_TAX_FIRST_YR;

	@Column(name="FPCU_TAX_SUB_YRS")
	private Double FPCU_TAX_SUB_YRS;

	@Column(name="FPCU_RETRO_YN")
	private String FPCU_RETRO_YN;
	
	@Column(name="FPCU_RETRO_SHARE_PERC")
	private Double FPCU_RETRO_SHARE_PERC;
	
	@Column(name="FPCU_RETRO_COMM_FIRST_YR")
	private Double FPCU_RETRO_COMM_FIRST_YR;
	
	@Column(name="FPCU_RETRO_COMM_SUB_YRS")
	private Double FPCU_RETRO_COMM_SUB_YRS;
	
	@Column(name="FPCU_RETRO_TAX_FIRST_YR")
	private Double FPCU_RETRO_TAX_FIRST_YR;
	
	@Column(name="FPCU_RETRO_TAX_SUB_YRS")
	private Double FPCU_RETRO_TAX_SUB_YRS;
	
	@Column(name="FPCU_DEL_FLAG")
	private String FPCU_DEL_FLAG;
	
	@Column(name="FPCU_CR_DT")
	private Date FPCU_CR_DT;
	
	@Column(name="FPCU_CR_UID")
	private String FPCU_CR_UID;
	
	@Column(name="FPCU_UPD_DT")
	private Date FPCU_UPD_DT;
	
	@Column(name="FPCU_UPD_UID")
	private String FPCU_UPD_UID;
	
	@Column(name="FPCU_PC_SYS_ID")
	private Double FPCU_PC_SYS_ID;
	
	private String UI_M_FPCU_CUST_DESC;
	
	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getFPCU_SYS_ID() {
		return FPCU_SYS_ID;
	}

	public void setFPCU_SYS_ID(Double fpcu_sys_id) {
		FPCU_SYS_ID = fpcu_sys_id;
	}

	public Double getFPCU_FO_SYS_ID() {
		return FPCU_FO_SYS_ID;
	}

	public void setFPCU_FO_SYS_ID(Double fpcu_fo_sys_id) {
		FPCU_FO_SYS_ID = fpcu_fo_sys_id;
	}

	public String getFPCU_CUST_CODE() {
		return FPCU_CUST_CODE;
	}

	public void setFPCU_CUST_CODE(String fpcu_cust_code) {
		FPCU_CUST_CODE = fpcu_cust_code;
	}

	public Double getFPCU_SHARE_PERC() {
		return FPCU_SHARE_PERC;
	}

	public void setFPCU_SHARE_PERC(Double fpcu_share_perc) {
		FPCU_SHARE_PERC = fpcu_share_perc;
	}

	public Double getFPCU_COMM_FIRST_YR() {
		return FPCU_COMM_FIRST_YR;
	}

	public void setFPCU_COMM_FIRST_YR(Double fpcu_comm_first_yr) {
		FPCU_COMM_FIRST_YR = fpcu_comm_first_yr;
	}

	public Double getFPCU_COMM_SUB_YRS() {
		return FPCU_COMM_SUB_YRS;
	}

	public void setFPCU_COMM_SUB_YRS(Double fpcu_comm_sub_yrs) {
		FPCU_COMM_SUB_YRS = fpcu_comm_sub_yrs;
	}

	public Double getFPCU_TAX_FIRST_YR() {
		return FPCU_TAX_FIRST_YR;
	}

	public void setFPCU_TAX_FIRST_YR(Double fpcu_tax_first_yr) {
		FPCU_TAX_FIRST_YR = fpcu_tax_first_yr;
	}

	public Double getFPCU_TAX_SUB_YRS() {
		return FPCU_TAX_SUB_YRS;
	}

	public void setFPCU_TAX_SUB_YRS(Double fpcu_tax_sub_yrs) {
		FPCU_TAX_SUB_YRS = fpcu_tax_sub_yrs;
	}

	public String getFPCU_RETRO_YN() {
		return FPCU_RETRO_YN;
	}

	public void setFPCU_RETRO_YN(String fpcu_retro_yn) {
		FPCU_RETRO_YN = fpcu_retro_yn;
	}

	public Double getFPCU_RETRO_SHARE_PERC() {
		return FPCU_RETRO_SHARE_PERC;
	}

	public void setFPCU_RETRO_SHARE_PERC(Double fpcu_retro_share_perc) {
		FPCU_RETRO_SHARE_PERC = fpcu_retro_share_perc;
	}

	public Double getFPCU_RETRO_COMM_FIRST_YR() {
		return FPCU_RETRO_COMM_FIRST_YR;
	}

	public void setFPCU_RETRO_COMM_FIRST_YR(Double fpcu_retro_comm_first_yr) {
		FPCU_RETRO_COMM_FIRST_YR = fpcu_retro_comm_first_yr;
	}

	public Double getFPCU_RETRO_COMM_SUB_YRS() {
		return FPCU_RETRO_COMM_SUB_YRS;
	}

	public void setFPCU_RETRO_COMM_SUB_YRS(Double fpcu_retro_comm_sub_yrs) {
		FPCU_RETRO_COMM_SUB_YRS = fpcu_retro_comm_sub_yrs;
	}

	public Double getFPCU_RETRO_TAX_FIRST_YR() {
		return FPCU_RETRO_TAX_FIRST_YR;
	}

	public void setFPCU_RETRO_TAX_FIRST_YR(Double fpcu_retro_tax_first_yr) {
		FPCU_RETRO_TAX_FIRST_YR = fpcu_retro_tax_first_yr;
	}

	public Double getFPCU_RETRO_TAX_SUB_YRS() {
		return FPCU_RETRO_TAX_SUB_YRS;
	}

	public void setFPCU_RETRO_TAX_SUB_YRS(Double fpcu_retro_tax_sub_yrs) {
		FPCU_RETRO_TAX_SUB_YRS = fpcu_retro_tax_sub_yrs;
	}

	public String getFPCU_DEL_FLAG() {
		return FPCU_DEL_FLAG;
	}

	public void setFPCU_DEL_FLAG(String fpcu_del_flag) {
		FPCU_DEL_FLAG = fpcu_del_flag;
	}

	public Date getFPCU_CR_DT() {
		return FPCU_CR_DT;
	}

	public void setFPCU_CR_DT(Date fpcu_cr_dt) {
		FPCU_CR_DT = fpcu_cr_dt;
	}

	public String getFPCU_CR_UID() {
		return FPCU_CR_UID;
	}

	public void setFPCU_CR_UID(String fpcu_cr_uid) {
		FPCU_CR_UID = fpcu_cr_uid;
	}

	public Date getFPCU_UPD_DT() {
		return FPCU_UPD_DT;
	}

	public void setFPCU_UPD_DT(Date fpcu_upd_dt) {
		FPCU_UPD_DT = fpcu_upd_dt;
	}

	public String getFPCU_UPD_UID() {
		return FPCU_UPD_UID;
	}

	public void setFPCU_UPD_UID(String fpcu_upd_uid) {
		FPCU_UPD_UID = fpcu_upd_uid;
	}

	public Double getFPCU_PC_SYS_ID() {
		return FPCU_PC_SYS_ID;
	}

	public void setFPCU_PC_SYS_ID(Double fpcu_pc_sys_id) {
		FPCU_PC_SYS_ID = fpcu_pc_sys_id;
	}

	public String getUI_M_FPCU_CUST_DESC() {
		return UI_M_FPCU_CUST_DESC;
	}

	public void setUI_M_FPCU_CUST_DESC(String ui_m_fpcu_cust_desc) {
		UI_M_FPCU_CUST_DESC = ui_m_fpcu_cust_desc;
	}
}
