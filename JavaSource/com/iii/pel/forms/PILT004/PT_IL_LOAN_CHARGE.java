package com.iii.pel.forms.PILT004;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_LOAN_CHARGE")
public class PT_IL_LOAN_CHARGE extends BaseValueBean {

	@Column(name="LC_CHRG_CODE")
	private String LC_CHRG_CODE;
	
	@Column(name="LC_SYS_ID")
	private Long LC_SYS_ID;
	
	@Column(name="LC_LOAN_SYS_ID")
	private Long LC_LOAN_SYS_ID;

	@Column(name="LC_PERC")
	private Double LC_PERC;

	private String UI_M_LC_CHARGE_DESC;

	@Column(name="LC_FC_VALUE")
	private Double LC_FC_VALUE;

	@Column(name="LC_LC_VALUE")
	private Double LC_LC_VALUE;
	
	@Column(name="LC_CR_UID")
	private String LC_CR_UID;
	
	@Column(name="LC_CR_DT")
	private Date LC_CR_DT; 
	
	
	private boolean selected = false; 

	public Date getLC_CR_DT() {
		return LC_CR_DT;
	}

	public void setLC_CR_DT(Date lc_cr_dt) {
		LC_CR_DT = lc_cr_dt;
	}

	

	

	public String getLC_CR_UID() {
		return LC_CR_UID;
	}

	public void setLC_CR_UID(String lc_cr_uid) {
		LC_CR_UID = lc_cr_uid;
	}

	public PT_IL_LOAN_CHARGE(Long LC_SYS_ID){
		this.LC_SYS_ID=LC_SYS_ID;
		this.LC_LOAN_SYS_ID=LC_SYS_ID;		
	}
	
	public PT_IL_LOAN_CHARGE(){
		
		
	}

	public String getLC_CHRG_CODE() {
		return LC_CHRG_CODE;
	}

	public void setLC_CHRG_CODE(String LC_CHRG_CODE) {
		this.LC_CHRG_CODE = LC_CHRG_CODE;
	}

	public Double getLC_PERC() {
		return LC_PERC;
	}

	public void setLC_PERC(Double LC_PERC) {
		this.LC_PERC = LC_PERC;
	}

	public String getUI_M_LC_CHARGE_DESC() {
		return UI_M_LC_CHARGE_DESC;
	}

	public void setUI_M_LC_CHARGE_DESC(String UI_M_LC_CHARGE_DESC) {
		this.UI_M_LC_CHARGE_DESC = UI_M_LC_CHARGE_DESC;
	}

	public Double getLC_FC_VALUE() {
		return LC_FC_VALUE;
	}

	public void setLC_FC_VALUE(Double LC_FC_VALUE) {
		this.LC_FC_VALUE = LC_FC_VALUE;
	}

	public Double getLC_LC_VALUE() {
		return LC_LC_VALUE;
	}

	public void setLC_LC_VALUE(Double LC_LC_VALUE) {
		this.LC_LC_VALUE = LC_LC_VALUE;
	}

	public Long getLC_SYS_ID() {
		return LC_SYS_ID;
	}

	public void setLC_SYS_ID(Long lc_sys_id) {
		LC_SYS_ID = lc_sys_id;
	}

	public Long getLC_LOAN_SYS_ID() {
		return LC_LOAN_SYS_ID;
	}

	public void setLC_LOAN_SYS_ID(Long lc_loan_sys_id) {
		LC_LOAN_SYS_ID = lc_loan_sys_id;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	

	
}
