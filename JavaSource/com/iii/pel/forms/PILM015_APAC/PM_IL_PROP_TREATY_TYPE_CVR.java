package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROP_TREATY_TYPE_COVER")
public class PM_IL_PROP_TREATY_TYPE_CVR extends BaseValueBean {

	@Column(name="PTTC_COVER_CODE")
	private String PTTC_COVER_CODE;

	private String UI_M_COVER_DESC;

	@Column(name="PTTC_PERC")
	private Double PTTC_PERC;
	
	private boolean CHECK_BOX;
	
	@Column(name="PTTC_CR_DT")
	private Date PTTC_CR_DT;
	
	@Column(name="PTTC_CR_UID")
	private String PTTC_CR_UID;
	
	@Column(name="PTTC_SYS_ID")
	private Double PTTC_SYS_ID;
	
	@Column(name="PTTC_PTT_SYS_ID")
	private Double PTTC_PTT_SYS_ID;

	@Column(name="PTTC_UPD_DT")
	private Date PTTC_UPD_DT;
	
	@Column(name="PTTC_UPD_UID")
	private String PTTC_UPD_UID;

	public String getPTTC_COVER_CODE() {
		return PTTC_COVER_CODE;
	}

	public void setPTTC_COVER_CODE(String PTTC_COVER_CODE) {
		this.PTTC_COVER_CODE = PTTC_COVER_CODE;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}

	public Double getPTTC_PERC() {
		return PTTC_PERC;
	}

	public void setPTTC_PERC(Double PTTC_PERC) {
		this.PTTC_PERC = PTTC_PERC;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Date getPTTC_CR_DT() {
		return PTTC_CR_DT;
	}

	public void setPTTC_CR_DT(Date pttc_cr_dt) {
		PTTC_CR_DT = pttc_cr_dt;
	}

	public String getPTTC_CR_UID() {
		return PTTC_CR_UID;
	}

	public void setPTTC_CR_UID(String pttc_cr_uid) {
		PTTC_CR_UID = pttc_cr_uid;
	}

	public Double getPTTC_SYS_ID() {
		return PTTC_SYS_ID;
	}

	public void setPTTC_SYS_ID(Double pttc_sys_id) {
		PTTC_SYS_ID = pttc_sys_id;
	}

	public Double getPTTC_PTT_SYS_ID() {
		return PTTC_PTT_SYS_ID;
	}

	public void setPTTC_PTT_SYS_ID(Double pttc_ptt_sys_id) {
		PTTC_PTT_SYS_ID = pttc_ptt_sys_id;
	}

	public Date getPTTC_UPD_DT() {
		return PTTC_UPD_DT;
	}

	public void setPTTC_UPD_DT(Date pttc_upd_dt) {
		PTTC_UPD_DT = pttc_upd_dt;
	}

	public String getPTTC_UPD_UID() {
		return PTTC_UPD_UID;
	}

	public void setPTTC_UPD_UID(String pttc_upd_uid) {
		PTTC_UPD_UID = pttc_upd_uid;
	}
}
