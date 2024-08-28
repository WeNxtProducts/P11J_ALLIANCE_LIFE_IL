package com.iii.pel.forms.PILP007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_SURR_MAT_VALUES")
public class PT_IL_SURR_MAT_VALUES extends BaseValueBean {

	private String UI_M_POL_NO;

	@Column(name = "SMV_FC_RED_SA")
	private Double SMV_FC_RED_SA;

	@Column(name = "SMV_TYPE")
	private String SMV_TYPE;

	@Column(name = "SMV_UPD_DT")
	private Date SMV_UPD_DT;

	@Column(name = "SMV_FC_ACC_PROFIT")
	private Double SMV_FC_ACC_PROFIT;

	@Column(name = "SMV_FC_GROSS_VALUE")
	private Double SMV_FC_GROSS_VALUE;

	private String UI_M_STATUS;

	@Column(name = "SMV_LC_RED_SA")
	private Double SMV_LC_RED_SA;

	@Column(name = "SMV_LC_ACC_PROFIT")
	private Double SMV_LC_ACC_PROFIT;

	@Column(name = "SMV_POL_SYS_ID")
	private Double SMV_POL_SYS_ID;

	@Column(name = "SMV_LC_GROSS_VALUE")
	private Double SMV_LC_GROSS_VALUE;

	@Column(name = "SMV_UPD_UID")
	private String SMV_UPD_UID;

	private boolean selected;
	private Double UI_M_POL_SA_EXCH_RATE;

	private String UI_M_POL_SA_CURR_CODE;

	@Column(name = "SMV_SYS_ID")
	private Double SMV_SYS_ID;
	
	
	/*Added By Dhinesh 3.7.2016*/
	private String UI_SMV_FC_GROSS_VALUE;
	private String UI_SMV_FC_ACC_PROFIT;
	private String UI_SMV_LC_RED_SA;
	private String UI_SMV_FC_RED_SA;
	
	public String getUI_SMV_FC_GROSS_VALUE() {
		return UI_SMV_FC_GROSS_VALUE;
	}

	public void setUI_SMV_FC_GROSS_VALUE(String uI_SMV_FC_GROSS_VALUE) {
		UI_SMV_FC_GROSS_VALUE = uI_SMV_FC_GROSS_VALUE;
	}

	public String getUI_SMV_FC_ACC_PROFIT() {
		return UI_SMV_FC_ACC_PROFIT;
	}

	public void setUI_SMV_FC_ACC_PROFIT(String uI_SMV_FC_ACC_PROFIT) {
		UI_SMV_FC_ACC_PROFIT = uI_SMV_FC_ACC_PROFIT;
	}

	public String getUI_SMV_LC_RED_SA() {
		return UI_SMV_LC_RED_SA;
	}

	public void setUI_SMV_LC_RED_SA(String uI_SMV_LC_RED_SA) {
		UI_SMV_LC_RED_SA = uI_SMV_LC_RED_SA;
	}

	public String getUI_SMV_FC_RED_SA() {
		return UI_SMV_FC_RED_SA;
	}

	public void setUI_SMV_FC_RED_SA(String uI_SMV_FC_RED_SA) {
		UI_SMV_FC_RED_SA = uI_SMV_FC_RED_SA;
	}	
	
	/*End*/
	
	
	
	
	
	
	

	

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public Double getSMV_FC_RED_SA() {
		return SMV_FC_RED_SA;
	}

	public void setSMV_FC_RED_SA(Double SMV_FC_RED_SA) {
		this.SMV_FC_RED_SA = SMV_FC_RED_SA;
	}

	public Double getSMV_FC_ACC_PROFIT() {
		return SMV_FC_ACC_PROFIT;
	}

	public void setSMV_FC_ACC_PROFIT(Double SMV_FC_ACC_PROFIT) {
		this.SMV_FC_ACC_PROFIT = SMV_FC_ACC_PROFIT;
	}

	public Double getSMV_FC_GROSS_VALUE() {
		return SMV_FC_GROSS_VALUE;
	}

	public void setSMV_FC_GROSS_VALUE(Double SMV_FC_GROSS_VALUE) {
		this.SMV_FC_GROSS_VALUE = SMV_FC_GROSS_VALUE;
	}

	public String getUI_M_STATUS() {
		return UI_M_STATUS;
	}

	public void setUI_M_STATUS(String UI_M_STATUS) {
		this.UI_M_STATUS = UI_M_STATUS;
	}

	public Double getSMV_LC_RED_SA() {
		return SMV_LC_RED_SA;
	}

	public void setSMV_LC_RED_SA(Double SMV_LC_RED_SA) {
		this.SMV_LC_RED_SA = SMV_LC_RED_SA;
	}

	public Double getSMV_LC_ACC_PROFIT() {
		return SMV_LC_ACC_PROFIT;
	}

	public void setSMV_LC_ACC_PROFIT(Double SMV_LC_ACC_PROFIT) {
		this.SMV_LC_ACC_PROFIT = SMV_LC_ACC_PROFIT;
	}

	public Double getSMV_LC_GROSS_VALUE() {
		return SMV_LC_GROSS_VALUE;
	}

	public void setSMV_LC_GROSS_VALUE(Double SMV_LC_GROSS_VALUE) {
		this.SMV_LC_GROSS_VALUE = SMV_LC_GROSS_VALUE;
	}

	public Double getSMV_POL_SYS_ID() {
		return SMV_POL_SYS_ID;
	}

	public void setSMV_POL_SYS_ID(Double smv_pol_sys_id) {
		SMV_POL_SYS_ID = smv_pol_sys_id;
	}

	public String getUI_M_POL_SA_CURR_CODE() {
		return UI_M_POL_SA_CURR_CODE;
	}

	public void setUI_M_POL_SA_CURR_CODE(String ui_m_pol_sa_curr_code) {
		UI_M_POL_SA_CURR_CODE = ui_m_pol_sa_curr_code;
	}

	public Double getSMV_SYS_ID() {
		return SMV_SYS_ID;
	}

	public void setSMV_SYS_ID(Double smv_sys_id) {
		SMV_SYS_ID = smv_sys_id;
	}

	public String getSMV_UPD_UID() {
		return SMV_UPD_UID;
	}

	public void setSMV_UPD_UID(String smv_upd_uid) {
		SMV_UPD_UID = smv_upd_uid;
	}

	public String getSMV_TYPE() {
		return SMV_TYPE;
	}

	public void setSMV_TYPE(String smv_type) {
		SMV_TYPE = smv_type;
	}

	public Date getSMV_UPD_DT() {
		return SMV_UPD_DT;
	}

	public void setSMV_UPD_DT(Date smv_upd_dt) {
		SMV_UPD_DT = smv_upd_dt;
	}

	public Double getUI_M_POL_SA_EXCH_RATE() {
		return UI_M_POL_SA_EXCH_RATE;
	}

	public void setUI_M_POL_SA_EXCH_RATE(Double ui_m_pol_sa_exch_rate) {
		UI_M_POL_SA_EXCH_RATE = ui_m_pol_sa_exch_rate;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
