package com.iii.pel.forms.PM094_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BONUS_APPL_RANKS")
public class PM_AGENT_BONUS_APPL_RANKS extends BaseValueBean {

	

	@Column(name="ABAR_RANK_CODE")
	private String ABAR_RANK_CODE;

	private String UI_M_ABS_AGENT_RANK_DESC;

	private boolean selected;

	@Column(name="ABAR_CR_DT")	
	private Date ABAR_CR_DT;
	
	@Column(name="ABAR_UPD_DT")
	private Date ABAR_UPD_DT;
	
	@Column(name="ABAR_UPD_UID")
	private String ABAR_UPD_UID;
	
	@Column(name="ABAR_CR_UID")
	private String ABAR_CR_UID;
	
	@Column(name="ABAR_ABS_CODE")
	private String ABAR_ABS_CODE;
	
	
	/*Newly added by pidugu raj dt: 08-11-2018 as per ajoy suggestion for KIC BONUS SETUP*/
	@Column(name="ABAR_CLASS_FM")
	private String ABAR_CLASS_FM;
	
	@Column(name="ABAR_CLASS_TO")
	private String ABAR_CLASS_TO;
	
	private String UI_M_ABAR_CLASS_FM_DESC;
	private String UI_M_ABAR_CLASS_TO_DESC;
	
	
	
	public String getUI_M_ABAR_CLASS_TO_DESC() {
		return UI_M_ABAR_CLASS_TO_DESC;
	}

	public void setUI_M_ABAR_CLASS_TO_DESC(String uI_M_ABAR_CLASS_TO_DESC) {
		UI_M_ABAR_CLASS_TO_DESC = uI_M_ABAR_CLASS_TO_DESC;
	}

	public String getUI_M_ABAR_CLASS_FM_DESC() {
		return UI_M_ABAR_CLASS_FM_DESC;
	}

	public void setUI_M_ABAR_CLASS_FM_DESC(String uI_M_ABAR_CLASS_FM_DESC) {
		UI_M_ABAR_CLASS_FM_DESC = uI_M_ABAR_CLASS_FM_DESC;
	}

	public String getABAR_CLASS_FM() {
		return ABAR_CLASS_FM;
	}

	public void setABAR_CLASS_FM(String aBAR_CLASS_FM) {
		ABAR_CLASS_FM = aBAR_CLASS_FM;
	}

	public String getABAR_CLASS_TO() {
		return ABAR_CLASS_TO;
	}

	public void setABAR_CLASS_TO(String aBAR_CLASS_TO) {
		ABAR_CLASS_TO = aBAR_CLASS_TO;
	}
	
	/*End Newly added by pidugu raj dt: 08-11-2018 as per ajoy suggestion for KIC BONUS SETUP*/
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public String getABAR_RANK_CODE() {
		return ABAR_RANK_CODE;
	}

	public void setABAR_RANK_CODE(String ABAR_RANK_CODE) {
		this.ABAR_RANK_CODE = ABAR_RANK_CODE;
	}

	public String getUI_M_ABS_AGENT_RANK_DESC() {
		return UI_M_ABS_AGENT_RANK_DESC;
	}

	public void setUI_M_ABS_AGENT_RANK_DESC(String UI_M_ABS_AGENT_RANK_DESC) {
		this.UI_M_ABS_AGENT_RANK_DESC = UI_M_ABS_AGENT_RANK_DESC;
	}

	

	public String getABAR_UPD_UID() {
		return ABAR_UPD_UID;
	}

	public void setABAR_UPD_UID(String abar_upd_uid) {
		ABAR_UPD_UID = abar_upd_uid;
	}

	public String getABAR_CR_UID() {
		return ABAR_CR_UID;
	}

	public void setABAR_CR_UID(String abar_cr_uid) {
		ABAR_CR_UID = abar_cr_uid;
	}

	public String getABAR_ABS_CODE() {
		return ABAR_ABS_CODE;
	}

	public void setABAR_ABS_CODE(String abar_abs_code) {
		ABAR_ABS_CODE = abar_abs_code;
	}

	public Date getABAR_CR_DT() {
		return ABAR_CR_DT;
	}

	public void setABAR_CR_DT(Date abar_cr_dt) {
		ABAR_CR_DT = abar_cr_dt;
	}

	public Date getABAR_UPD_DT() {
		return ABAR_UPD_DT;
	}

	public void setABAR_UPD_DT(Date abar_upd_dt) {
		ABAR_UPD_DT = abar_upd_dt;
	}
	
	/*Added by Ameen on 02-08-2018 for KICLIFEQC-1760174 as per Ajay*/
	@Column(name="ABAR_AGENT_NEW")
	private String ABAR_AGENT_NEW;
	
	private boolean UI_M_ABAR_AGENT_NEW;

	public String getABAR_AGENT_NEW() {
		return ABAR_AGENT_NEW;
	}

	public void setABAR_AGENT_NEW(String aBAR_AGENT_NEW) {
		ABAR_AGENT_NEW = aBAR_AGENT_NEW;
	}

	public boolean isUI_M_ABAR_AGENT_NEW() {
		return UI_M_ABAR_AGENT_NEW;
	}

	public void setUI_M_ABAR_AGENT_NEW(boolean uI_M_ABAR_AGENT_NEW) {
		UI_M_ABAR_AGENT_NEW = uI_M_ABAR_AGENT_NEW;
	}
	
	/*End*/
}
