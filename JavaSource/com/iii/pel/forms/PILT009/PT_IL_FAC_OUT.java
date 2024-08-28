package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_OUT")
public class PT_IL_FAC_OUT extends BaseValueBean {

	private String UI_M_COVER_CODE;

	private String UI_M_FDL_COVER_DESC;

	private String UI_M_POL_NO;

	private String UI_M_DOC_NO;

	@Column(name="FO_SYS_ID")
	private Double FO_SYS_ID;
	
	@Column(name="FO_POL_SYS_ID")
	private Double FO_POL_SYS_ID;
	
	@Column(name="FO_COVER_SYS_ID")
	private Double FO_COVER_SYS_ID;
	
	@Column(name="FO_COVER_CODE")
	private String FO_COVER_CODE;

	@Column(name="FO_COVER_TYPE")
	private String FO_COVER_TYPE;
	
	@Column(name="FO_SA_CURR_CODE")
	private String FO_SA_CURR_CODE;

	@Column(name="FO_FAC_PERC")
	private Double FO_FAC_PERC;

	@Column(name="FO_FC_FAC_SI")
	private Double FO_FC_FAC_SI;

	@Column(name="FO_LC_FAC_SI")
	private Double FO_LC_FAC_SI;
	
	@Column(name="FO_DEL_FLAG")
	private String FO_DEL_FLAG;
	
	@Column(name="FO_CR_DT")
	private Date FO_CR_DT;
	
	@Column(name="FO_CR_UID")
	private String FO_CR_UID;
	
	@Column(name="FO_UPD_DT")
	private Date FO_UPD_DT;
	
	@Column(name="FO_UPD_UID")
	private String FO_UPD_UID;
	
	@Column(name="FO_ASSR_CODE")
	private String FO_ASSR_CODE;
	
	@Column(name="FO_PC_SYS_ID")
	private Double FO_PC_SYS_ID;
	
	@Column(name="FO_AC_CLOSE_YN")
	private String FO_AC_CLOSE_YN;

	private String UI_M_ASSR_NAME;

	private String UI_M_COVER_DESC;

	private String UI_M_SI_CURR_DESC;

	private String UI_M_FPC_COVER_CODE;

	private String UI_M_FPC_COVER_CODE_DESC;

	private String UI_M_FPCUD_COVER_CODE;

	private String UI_M_FPCUD_COVER_DESC;

	private String UI_M_FCRD_COVER_CODE;

	private String UI_M_FCRD_COVER_DESC;

	private String UI_M_FPCU_COVER_CODE;

	private String UI_M_FPCU_COVER_DESC;

	private String UI_M_FCR_COVER_DESC;

	private String UI_M_FCR_COVER_CODE;

	private String UI_M_FO_SI_CURR_CODE_DESC;
	
	private String UI_M_POL_CUST_CURR_CODE;
	
	private String UI_M_POL_CUST_CURR_DESC;
	
	private Double UI_M_FO_CQS_SI;
	
	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getUI_M_FO_CQS_SI() {
		return UI_M_FO_CQS_SI;
	}

	public void setUI_M_FO_CQS_SI(Double ui_m_fo_cqs_si) {
		UI_M_FO_CQS_SI = ui_m_fo_cqs_si;
	}

	public String getUI_M_POL_CUST_CURR_DESC() {
		return UI_M_POL_CUST_CURR_DESC;
	}

	public void setUI_M_POL_CUST_CURR_DESC(String ui_m_pol_cust_curr_desc) {
		UI_M_POL_CUST_CURR_DESC = ui_m_pol_cust_curr_desc;
	}

	public String getUI_M_FO_SI_CURR_CODE_DESC() {
		return UI_M_FO_SI_CURR_CODE_DESC;
	}

	public void setUI_M_FO_SI_CURR_CODE_DESC(String ui_m_fo_si_curr_code_desc) {
		UI_M_FO_SI_CURR_CODE_DESC = ui_m_fo_si_curr_code_desc;
	}

	public String getUI_M_COVER_CODE() {
		return UI_M_COVER_CODE;
	}

	public void setUI_M_COVER_CODE(String UI_M_COVER_CODE) {
		this.UI_M_COVER_CODE = UI_M_COVER_CODE;
	}

	public String getUI_M_FDL_COVER_DESC() {
		return UI_M_FDL_COVER_DESC;
	}

	public void setUI_M_FDL_COVER_DESC(String UI_M_FDL_COVER_DESC) {
		this.UI_M_FDL_COVER_DESC = UI_M_FDL_COVER_DESC;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getUI_M_DOC_NO() {
		return UI_M_DOC_NO;
	}

	public void setUI_M_DOC_NO(String UI_M_DOC_NO) {
		this.UI_M_DOC_NO = UI_M_DOC_NO;
	}

	public String getFO_COVER_CODE() {
		return FO_COVER_CODE;
	}

	public void setFO_COVER_CODE(String FO_COVER_CODE) {
		this.FO_COVER_CODE = FO_COVER_CODE;
	}

	public String getFO_ASSR_CODE() {
		return FO_ASSR_CODE;
	}

	public void setFO_ASSR_CODE(String FO_ASSR_CODE) {
		this.FO_ASSR_CODE = FO_ASSR_CODE;
	}

	public String getFO_SA_CURR_CODE() {
		return FO_SA_CURR_CODE;
	}

	public void setFO_SA_CURR_CODE(String FO_SA_CURR_CODE) {
		this.FO_SA_CURR_CODE = FO_SA_CURR_CODE;
	}

	public Double getFO_FC_FAC_SI() {
		return FO_FC_FAC_SI;
	}

	public void setFO_FC_FAC_SI(Double FO_FC_FAC_SI) {
		this.FO_FC_FAC_SI = FO_FC_FAC_SI;
	}

	public Double getFO_LC_FAC_SI() {
		return FO_LC_FAC_SI;
	}

	public void setFO_LC_FAC_SI(Double FO_LC_FAC_SI) {
		this.FO_LC_FAC_SI = FO_LC_FAC_SI;
	}

	public Double getFO_FAC_PERC() {
		return FO_FAC_PERC;
	}

	public void setFO_FAC_PERC(Double FO_FAC_PERC) {
		this.FO_FAC_PERC = FO_FAC_PERC;
	}

	public String getUI_M_ASSR_NAME() {
		return UI_M_ASSR_NAME;
	}

	public void setUI_M_ASSR_NAME(String UI_M_ASSR_NAME) {
		this.UI_M_ASSR_NAME = UI_M_ASSR_NAME;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}

	public String getUI_M_SI_CURR_DESC() {
		return UI_M_SI_CURR_DESC;
	}

	public void setUI_M_SI_CURR_DESC(String UI_M_SI_CURR_DESC) {
		this.UI_M_SI_CURR_DESC = UI_M_SI_CURR_DESC;
	}

	public String getUI_M_FPC_COVER_CODE() {
		return UI_M_FPC_COVER_CODE;
	}

	public void setUI_M_FPC_COVER_CODE(String UI_M_FPC_COVER_CODE) {
		this.UI_M_FPC_COVER_CODE = UI_M_FPC_COVER_CODE;
	}

	public String getUI_M_FPC_COVER_CODE_DESC() {
		return UI_M_FPC_COVER_CODE_DESC;
	}

	public void setUI_M_FPC_COVER_CODE_DESC(String UI_M_FPC_COVER_CODE_DESC) {
		this.UI_M_FPC_COVER_CODE_DESC = UI_M_FPC_COVER_CODE_DESC;
	}

	public String getUI_M_FPCUD_COVER_CODE() {
		return UI_M_FPCUD_COVER_CODE;
	}

	public void setUI_M_FPCUD_COVER_CODE(String UI_M_FPCUD_COVER_CODE) {
		this.UI_M_FPCUD_COVER_CODE = UI_M_FPCUD_COVER_CODE;
	}

	public String getUI_M_FPCUD_COVER_DESC() {
		return UI_M_FPCUD_COVER_DESC;
	}

	public void setUI_M_FPCUD_COVER_DESC(String UI_M_FPCUD_COVER_DESC) {
		this.UI_M_FPCUD_COVER_DESC = UI_M_FPCUD_COVER_DESC;
	}

	public String getUI_M_FCRD_COVER_CODE() {
		return UI_M_FCRD_COVER_CODE;
	}

	public void setUI_M_FCRD_COVER_CODE(String UI_M_FCRD_COVER_CODE) {
		this.UI_M_FCRD_COVER_CODE = UI_M_FCRD_COVER_CODE;
	}

	public String getUI_M_FCRD_COVER_DESC() {
		return UI_M_FCRD_COVER_DESC;
	}

	public void setUI_M_FCRD_COVER_DESC(String UI_M_FCRD_COVER_DESC) {
		this.UI_M_FCRD_COVER_DESC = UI_M_FCRD_COVER_DESC;
	}

	public String getUI_M_FPCU_COVER_CODE() {
		return UI_M_FPCU_COVER_CODE;
	}

	public void setUI_M_FPCU_COVER_CODE(String UI_M_FPCU_COVER_CODE) {
		this.UI_M_FPCU_COVER_CODE = UI_M_FPCU_COVER_CODE;
	}

	public String getUI_M_FPCU_COVER_DESC() {
		return UI_M_FPCU_COVER_DESC;
	}

	public void setUI_M_FPCU_COVER_DESC(String UI_M_FPCU_COVER_DESC) {
		this.UI_M_FPCU_COVER_DESC = UI_M_FPCU_COVER_DESC;
	}

	public String getUI_M_FCR_COVER_DESC() {
		return UI_M_FCR_COVER_DESC;
	}

	public void setUI_M_FCR_COVER_DESC(String UI_M_FCR_COVER_DESC) {
		this.UI_M_FCR_COVER_DESC = UI_M_FCR_COVER_DESC;
	}

	public String getUI_M_FCR_COVER_CODE() {
		return UI_M_FCR_COVER_CODE;
	}

	public void setUI_M_FCR_COVER_CODE(String UI_M_FCR_COVER_CODE) {
		this.UI_M_FCR_COVER_CODE = UI_M_FCR_COVER_CODE;
	}

	public Double getFO_SYS_ID() {
		return FO_SYS_ID;
	}

	public void setFO_SYS_ID(Double fo_sys_id) {
		FO_SYS_ID = fo_sys_id;
	}

	public Double getFO_POL_SYS_ID() {
		return FO_POL_SYS_ID;
	}

	public void setFO_POL_SYS_ID(Double fo_pol_sys_id) {
		FO_POL_SYS_ID = fo_pol_sys_id;
	}

	public Double getFO_COVER_SYS_ID() {
		return FO_COVER_SYS_ID;
	}

	public void setFO_COVER_SYS_ID(Double fo_cover_sys_id) {
		FO_COVER_SYS_ID = fo_cover_sys_id;
	}

	public String getFO_COVER_TYPE() {
		return FO_COVER_TYPE;
	}

	public void setFO_COVER_TYPE(String fo_cover_type) {
		FO_COVER_TYPE = fo_cover_type;
	}

	public String getFO_DEL_FLAG() {
		return FO_DEL_FLAG;
	}

	public void setFO_DEL_FLAG(String fo_del_flag) {
		FO_DEL_FLAG = fo_del_flag;
	}

	public Date getFO_CR_DT() {
		return FO_CR_DT;
	}

	public void setFO_CR_DT(Date fo_cr_dt) {
		FO_CR_DT = fo_cr_dt;
	}

	public String getFO_CR_UID() {
		return FO_CR_UID;
	}

	public void setFO_CR_UID(String fo_cr_uid) {
		FO_CR_UID = fo_cr_uid;
	}

	public Date getFO_UPD_DT() {
		return FO_UPD_DT;
	}

	public void setFO_UPD_DT(Date fo_upd_dt) {
		FO_UPD_DT = fo_upd_dt;
	}

	public String getFO_UPD_UID() {
		return FO_UPD_UID;
	}

	public void setFO_UPD_UID(String fo_upd_uid) {
		FO_UPD_UID = fo_upd_uid;
	}

	public Double getFO_PC_SYS_ID() {
		return FO_PC_SYS_ID;
	}

	public void setFO_PC_SYS_ID(Double fo_pc_sys_id) {
		FO_PC_SYS_ID = fo_pc_sys_id;
	}

	public String getFO_AC_CLOSE_YN() {
		return FO_AC_CLOSE_YN;
	}

	public void setFO_AC_CLOSE_YN(String fo_ac_close_yn) {
		FO_AC_CLOSE_YN = fo_ac_close_yn;
	}

	public String getUI_M_POL_CUST_CURR_CODE() {
		return UI_M_POL_CUST_CURR_CODE;
	}

	public void setUI_M_POL_CUST_CURR_CODE(String ui_m_pol_cust_curr_code) {
		UI_M_POL_CUST_CURR_CODE = ui_m_pol_cust_curr_code;
	}
}
