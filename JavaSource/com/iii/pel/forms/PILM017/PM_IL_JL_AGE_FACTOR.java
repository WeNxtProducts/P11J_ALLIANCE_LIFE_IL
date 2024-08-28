package com.iii.pel.forms.PILM017;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_JL_AGE_FACTOR")
public class PM_IL_JL_AGE_FACTOR extends BaseValueBean {
	
	
	@Column(name="ROWID")
	private String ROWID;
	
	private boolean CHECK_BOX;
	
	@Column(name="JAF_DIFF_AGE_FROM")
	private Integer JAF_DIFF_AGE_FROM;

	@Column(name="JAF_DIFF_AGE_TO")
	private Integer JAF_DIFF_AGE_TO;

	@Column(name="JAF_AGE_FACTOR")
	private Double JAF_AGE_FACTOR;

	@Column(name="JAF_EFF_FM_DT")
	private Date JAF_EFF_FM_DT;

	@Column(name="JAF_EFF_TO_DT")
	private Date JAF_EFF_TO_DT;

	@Column(name="JAF_CR_DT")
	private Date JAF_CR_DT;                                                                                                                                                                                         
	
	@Column(name="JAF_CR_UID")
	private String JAF_CR_UID;
	
	@Column(name="JAF_UPD_DT")
	private Date JAF_UPD_DT;
	
	@Column(name="JAF_UPD_UID")
	private String JAF_UPD_UID;
	
	private String UI_JAF_EFF_FM_DT;
	
	private String UI_JAF_EFF_To_DT;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String ROWID) {
		this.ROWID = ROWID;
	}
	
	
	public Integer getJAF_DIFF_AGE_FROM() {
		return JAF_DIFF_AGE_FROM;
	}

	public void setJAF_DIFF_AGE_FROM(Integer JAF_DIFF_AGE_FROM) {
		this.JAF_DIFF_AGE_FROM = JAF_DIFF_AGE_FROM;
	}

	public Integer getJAF_DIFF_AGE_TO() {
		return JAF_DIFF_AGE_TO;
	}

	public void setJAF_DIFF_AGE_TO(Integer JAF_DIFF_AGE_TO) {
		this.JAF_DIFF_AGE_TO = JAF_DIFF_AGE_TO;
	}

	public Double getJAF_AGE_FACTOR() {
		return JAF_AGE_FACTOR;
	}

	public void setJAF_AGE_FACTOR(Double JAF_AGE_FACTOR) {
		this.JAF_AGE_FACTOR = JAF_AGE_FACTOR;
	}

	public Date getJAF_EFF_FM_DT() {
		 return JAF_EFF_FM_DT;
	}

	public void setJAF_EFF_FM_DT(Date JAF_EFF_FM_DT) {
		this.JAF_EFF_FM_DT = JAF_EFF_FM_DT;
	}

	public Date getJAF_EFF_TO_DT() {
		 return JAF_EFF_TO_DT;
	}

	public void setJAF_EFF_TO_DT(Date JAF_EFF_TO_DT) {
		this.JAF_EFF_TO_DT = JAF_EFF_TO_DT;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Date getJAF_CR_DT() {
		return JAF_CR_DT;
	}

	public void setJAF_CR_DT(Date jaf_cr_dt) {
		JAF_CR_DT = jaf_cr_dt;
	}

	public String getJAF_CR_UID() {
		return JAF_CR_UID;
	}

	public void setJAF_CR_UID(String jaf_cr_uid) {
		JAF_CR_UID = jaf_cr_uid;
	}

	public Date getJAF_UPD_DT() {
		return JAF_UPD_DT;
	}

	public void setJAF_UPD_DT(Date jaf_upd_dt) {
		JAF_UPD_DT = jaf_upd_dt;
	}

	public String getJAF_UPD_UID() {
		return JAF_UPD_UID;
	}

	public void setJAF_UPD_UID(String jaf_upd_uid) {
		JAF_UPD_UID = jaf_upd_uid;
	}

	public String getUI_JAF_EFF_FM_DT() {
		return UI_JAF_EFF_FM_DT;
	}

	public void setUI_JAF_EFF_FM_DT(String ui_jaf_eff_fm_dt) {
		UI_JAF_EFF_FM_DT = ui_jaf_eff_fm_dt;
	}

	public String getUI_JAF_EFF_To_DT() {
		return UI_JAF_EFF_To_DT;
	}

	public void setUI_JAF_EFF_To_DT(String to_DT) {
		UI_JAF_EFF_To_DT = to_DT;
	}
}
