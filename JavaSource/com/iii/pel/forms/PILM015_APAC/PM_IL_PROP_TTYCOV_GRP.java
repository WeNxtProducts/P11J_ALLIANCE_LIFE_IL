package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROP_TTYCOV_GRP")
public class PM_IL_PROP_TTYCOV_GRP extends BaseValueBean {

	@Column(name = "PTG_PTC_CVR_GRP_CODE")
	private String PTG_PTC_CVR_GRP_CODE;

	@Column(name = "PTG_COVER_CODE")
	private String PTG_COVER_CODE;

	private String UI_M_PTG_COVER_CODE_DESC;

	@Column(name = "PTG_SR_NO")
	private Double PTG_SR_NO;

	@Column(name = "PTG_SYS_ID")
	private Double PTG_SYS_ID;

	@Column(name = "PTG_PTC_SYS_ID")
	private Double PTG_PTC_SYS_ID;

	@Column(name = "PTG_PTT_SYS_ID")
	private Double PTG_PTT_SYS_ID;

	@Column(name = "PTG_CR_UID")
	private String PTG_CR_UID;

	@Column(name = "PTG_CR_DT")
	private Date PTG_CR_DT;

	@Column(name = "PTG_UPD_UID")
	private String PTG_UPD_UID;

	@Column(name = "PTG_UPD_DT")
	private Date PTG_UPD_DT;

	private boolean selected;

	public String getPTG_PTC_CVR_GRP_CODE() {
		return PTG_PTC_CVR_GRP_CODE;
	}

	public void setPTG_PTC_CVR_GRP_CODE(String PTG_PTC_CVR_GRP_CODE) {
		this.PTG_PTC_CVR_GRP_CODE = PTG_PTC_CVR_GRP_CODE;
	}

	public String getPTG_COVER_CODE() {
		return PTG_COVER_CODE;
	}

	public void setPTG_COVER_CODE(String PTG_COVER_CODE) {
		this.PTG_COVER_CODE = PTG_COVER_CODE;
	}

	public String getUI_M_PTG_COVER_CODE_DESC() {
		return UI_M_PTG_COVER_CODE_DESC;
	}

	public void setUI_M_PTG_COVER_CODE_DESC(String UI_M_PTG_COVER_CODE_DESC) {
		this.UI_M_PTG_COVER_CODE_DESC = UI_M_PTG_COVER_CODE_DESC;
	}

	public Double getPTG_SR_NO() {
		return PTG_SR_NO;
	}

	public void setPTG_SR_NO(Double PTG_SR_NO) {
		this.PTG_SR_NO = PTG_SR_NO;
	}

	public String getPTG_CR_UID() {
		return PTG_CR_UID;
	}

	public void setPTG_CR_UID(String ptg_cr_uid) {
		PTG_CR_UID = ptg_cr_uid;
	}

	public Date getPTG_CR_DT() {
		return PTG_CR_DT;
	}

	public void setPTG_CR_DT(Date ptg_cr_dt) {
		PTG_CR_DT = ptg_cr_dt;
	}

	public String getPTG_UPD_UID() {
		return PTG_UPD_UID;
	}

	public void setPTG_UPD_UID(String ptg_upd_uid) {
		PTG_UPD_UID = ptg_upd_uid;
	}

	public Date getPTG_UPD_DT() {
		return PTG_UPD_DT;
	}

	public void setPTG_UPD_DT(Date ptg_upd_dt) {
		PTG_UPD_DT = ptg_upd_dt;
	}

	public Double getPTG_SYS_ID() {
		return PTG_SYS_ID;
	}

	public void setPTG_SYS_ID(Double ptg_sys_id) {
		PTG_SYS_ID = ptg_sys_id;
	}

	public Double getPTG_PTC_SYS_ID() {
		return PTG_PTC_SYS_ID;
	}

	public void setPTG_PTC_SYS_ID(Double ptg_ptc_sys_id) {
		PTG_PTC_SYS_ID = ptg_ptc_sys_id;
	}

	public Double getPTG_PTT_SYS_ID() {
		return PTG_PTT_SYS_ID;
	}

	public void setPTG_PTT_SYS_ID(Double ptg_ptt_sys_id) {
		PTG_PTT_SYS_ID = ptg_ptt_sys_id;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
}
