package com.iii.pel.forms.PILM204;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_FORMULA_DTL")
public class PM_IL_FORMULA_DTL extends BaseValueBean {

	@Column(name = "FMD_COMP_TYPE")
	private String FMD_COMP_TYPE;

	@Column(name = "FMD_COMPONENT")
	private String FMD_COMPONENT;

	private String UI_M_FORMULA_DESC;

	@Column(name = "FMD_SR_NO")
	private Integer FMD_SR_NO;

	@Column(name = "FMD_FM_CODE")
	private String FMD_FM_CODE;
	
	@Column(name = "FMD_CR_UID")
	private String FMD_CR_UID;
	
	@Column(name = "FMD_CR_DATE")
	private Date FMD_CR_DATE;
	
	@Column(name = "FMD_UPD_ID")
	private String FMD_UPD_ID;
	
	@Column(name = "FMD_UPD_DATE")
	private Date FMD_UPD_DATE;

	
	
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getFMD_COMP_TYPE() {
		return FMD_COMP_TYPE;
	}

	public void setFMD_COMP_TYPE(String FMD_COMP_TYPE) {
		this.FMD_COMP_TYPE = FMD_COMP_TYPE;
	}

	public String getFMD_COMPONENT() {
		return FMD_COMPONENT;
	}

	public void setFMD_COMPONENT(String FMD_COMPONENT) {
		this.FMD_COMPONENT = FMD_COMPONENT;
	}

	public String getUI_M_FORMULA_DESC() {
		return UI_M_FORMULA_DESC;
	}

	public void setUI_M_FORMULA_DESC(String UI_M_FORMULA_DESC) {
		this.UI_M_FORMULA_DESC = UI_M_FORMULA_DESC;
	}

	 

	public Integer getFMD_SR_NO() {
		return FMD_SR_NO;
	}

	public void setFMD_SR_NO(Integer fmd_sr_no) {
		FMD_SR_NO = fmd_sr_no;
	}

	public String getFMD_FM_CODE() {
		return FMD_FM_CODE;
	}

	public void setFMD_FM_CODE(String fmd_fm_code) {
		FMD_FM_CODE = fmd_fm_code;
	}

	public String getFMD_CR_UID() {
		return FMD_CR_UID;
	}

	public void setFMD_CR_UID(String fmd_cr_uid) {
		FMD_CR_UID = fmd_cr_uid;
	}

	public Date getFMD_CR_DATE() {
		return FMD_CR_DATE;
	}

	public void setFMD_CR_DATE(Date fmd_cr_date) {
		FMD_CR_DATE = fmd_cr_date;
	}

	public String getFMD_UPD_ID() {
		return FMD_UPD_ID;
	}

	public void setFMD_UPD_ID(String fmd_upd_id) {
		FMD_UPD_ID = fmd_upd_id;
	}

	public Date getFMD_UPD_DATE() {
		return FMD_UPD_DATE;
	}

	public void setFMD_UPD_DATE(Date fmd_upd_date) {
		FMD_UPD_DATE = fmd_upd_date;
	}
}