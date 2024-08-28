package com.iii.pel.forms.PT099_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_PYMT_REVERSAL_DTLS")
public class PT_AGENT_PYMT_REVERSAL_DTLS extends BaseValueBean {

	private Date PC_SCHD_PYMT_DT;

	private Date PC_PAID_DT;

	private Double PC_FC_GROSS_PREM;

	private Double UI_M_PC_ACV_FC_VALUE;

	private boolean CHECK_BOX;
	
	@Column(name="APRD_SYS_ID")
	private Double APRD_SYS_ID;
	
	@Column(name="APRD_ATH_SYS_ID")
	private Double APRD_ATH_SYS_ID;
	
	@Column(name="APRD_POL_SYS_ID")
	private Double APRD_POL_SYS_ID;
	
	@Column(name="APRD_PC_SYS_ID")
	private Double APRD_PC_SYS_ID;
	
	
	@Column(name="APRD_CR_DT")
	private Date APRD_CR_DT ;
		
	@Column(name="APRD_UPD_DT")
	private Date APRD_UPD_DT;
	
	
	@Column(name="APRD_DT")
	private Date APRD_DT;

	@Column(name="APRD_GEN_FLAG")
	private String APRD_GEN_FLAG;

	@Column(name="APRD_CR_UID")
	private String APRD_CR_UID;
	
	@Column(name="APRD_UPD_UID")
	private String APRD_UPD_UID;
	
	@Column(name="APRD_APPRV_FLAG")
	private String APRD_APPRV_FLAG;
	

	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
	}

	public Date getPC_PAID_DT() {
		 return PC_PAID_DT;
	}

	public void setPC_PAID_DT(Date PC_PAID_DT) {
		this.PC_PAID_DT = PC_PAID_DT;
	}

	public Double getPC_FC_GROSS_PREM() {
		return PC_FC_GROSS_PREM;
	}

	public void setPC_FC_GROSS_PREM(Double PC_FC_GROSS_PREM) {
		this.PC_FC_GROSS_PREM = PC_FC_GROSS_PREM;
	}

	public Double getUI_M_PC_ACV_FC_VALUE() {
		return UI_M_PC_ACV_FC_VALUE;
	}

	public void setUI_M_PC_ACV_FC_VALUE(Double UI_M_PC_ACV_FC_VALUE) {
		this.UI_M_PC_ACV_FC_VALUE = UI_M_PC_ACV_FC_VALUE;
	}

	public Date getAPRD_DT() {
		 return APRD_DT;
	}

	public void setAPRD_DT(Date APRD_DT) {
		this.APRD_DT = APRD_DT;
	}

	public String getAPRD_GEN_FLAG() {
		return APRD_GEN_FLAG;
	}

	public void setAPRD_GEN_FLAG(String APRD_GEN_FLAG) {
		this.APRD_GEN_FLAG = APRD_GEN_FLAG;
	}

	/*public Double getPC_LC_GROSS_PREM() {
		return PC_LC_GROSS_PREM;
	}

	public void setPC_LC_GROSS_PREM(Double PC_LC_GROSS_PREM) {
		this.PC_LC_GROSS_PREM = PC_LC_GROSS_PREM;
	}

	public Double getUI_M_ACV_LC_VALUE() {
		return UI_M_ACV_LC_VALUE;
	}

	public void setUI_M_ACV_LC_VALUE(Double UI_M_ACV_LC_VALUE) {
		this.UI_M_ACV_LC_VALUE = UI_M_ACV_LC_VALUE;
	}*/

	public Double getAPRD_SYS_ID() {
		return APRD_SYS_ID;
	}

	public void setAPRD_SYS_ID(Double aprd_sys_id) {
		APRD_SYS_ID = aprd_sys_id;
	}

	public Date getAPRD_CR_DT() {
		return APRD_CR_DT;
	}

	public void setAPRD_CR_DT(Date aprd_cr_dt) {
		APRD_CR_DT = aprd_cr_dt;
	}

	
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getAPRD_ATH_SYS_ID() {
		return APRD_ATH_SYS_ID;
	}

	public void setAPRD_ATH_SYS_ID(Double aprd_ath_sys_id) {
		APRD_ATH_SYS_ID = aprd_ath_sys_id;
	}

	public Double getAPRD_POL_SYS_ID() {
		return APRD_POL_SYS_ID;
	}

	public void setAPRD_POL_SYS_ID(Double aprd_pol_sys_id) {
		APRD_POL_SYS_ID = aprd_pol_sys_id;
	}

	public Double getAPRD_PC_SYS_ID() {
		return APRD_PC_SYS_ID;
	}

	public void setAPRD_PC_SYS_ID(Double aprd_pc_sys_id) {
		APRD_PC_SYS_ID = aprd_pc_sys_id;
	}

	
	public Date getAPRD_UPD_DT() {
		return APRD_UPD_DT;
	}

	public void setAPRD_UPD_DT(Date aprd_upd_dt) {
		APRD_UPD_DT = aprd_upd_dt;
	}

	public String getAPRD_CR_UID() {
		return APRD_CR_UID;
	}

	public void setAPRD_CR_UID(String aprd_cr_uid) {
		APRD_CR_UID = aprd_cr_uid;
	}

	public String getAPRD_UPD_UID() {
		return APRD_UPD_UID;
	}

	public void setAPRD_UPD_UID(String aprd_upd_uid) {
		APRD_UPD_UID = aprd_upd_uid;
	}

	public String getAPRD_APPRV_FLAG() {
		return APRD_APPRV_FLAG;
	}

	public void setAPRD_APPRV_FLAG(String aprd_apprv_flag) {
		APRD_APPRV_FLAG = aprd_apprv_flag;
	}
}
