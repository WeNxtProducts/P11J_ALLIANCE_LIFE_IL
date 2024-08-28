package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_HTWT_DTL")
public class PM_IL_HTWT_DTL extends BaseValueBean {

	@Column(name = "HTWT_SYS_ID")
	private Double HTWT_SYS_ID;

	@Column(name = "HTWT_PT_SYS_ID")
	private Double HTWT_PT_SYS_ID;

	@Column(name = "HTWT_CR_DT")
	private Date HTWT_CR_DT;

	@Column(name = "HTWT_CR_UID")
	private String HTWT_CR_UID;

	@Column(name = "HTWT_UPD_DT")
	private Date HTWT_UPD_DT;

	@Column(name = "HTWT_UPD_UID")
	private String HTWT_UPD_UID;

	@Column(name = "HTWT_HEIGHT_FM")
	private Double HTWT_HEIGHT_FM;

	@Column(name = "HTWT_HEIGHT_TO")
	private Double HTWT_HEIGHT_TO;

	@Column(name = "HTWT_WEIGHT_FM")
	private Double HTWT_WEIGHT_FM;

	@Column(name = "HTWT_WEIGHT_TO")
	private Double HTWT_WEIGHT_TO;

	@Column(name = "HTWT_EFF_FM_DT")
	private Date HTWT_EFF_FM_DT;

	@Column(name = "HTWT_EFF_TO_DT")
	private Date HTWT_EFF_TO_DT;

	private int count;

	private boolean CHECK_BOX;

	public Double getHTWT_HEIGHT_FM() {
		return HTWT_HEIGHT_FM;
	}

	public void setHTWT_HEIGHT_FM(Double HTWT_HEIGHT_FM) {
		this.HTWT_HEIGHT_FM = HTWT_HEIGHT_FM;
	}

	public Double getHTWT_HEIGHT_TO() {
		return HTWT_HEIGHT_TO;
	}

	public void setHTWT_HEIGHT_TO(Double HTWT_HEIGHT_TO) {
		this.HTWT_HEIGHT_TO = HTWT_HEIGHT_TO;
	}

	public Double getHTWT_WEIGHT_FM() {
		return HTWT_WEIGHT_FM;
	}

	public void setHTWT_WEIGHT_FM(Double HTWT_WEIGHT_FM) {
		this.HTWT_WEIGHT_FM = HTWT_WEIGHT_FM;
	}

	public Double getHTWT_WEIGHT_TO() {
		return HTWT_WEIGHT_TO;
	}

	public void setHTWT_WEIGHT_TO(Double HTWT_WEIGHT_TO) {
		this.HTWT_WEIGHT_TO = HTWT_WEIGHT_TO;
	}

	public Date getHTWT_EFF_FM_DT() {
		return HTWT_EFF_FM_DT;
	}

	public void setHTWT_EFF_FM_DT(Date HTWT_EFF_FM_DT) {
		this.HTWT_EFF_FM_DT = HTWT_EFF_FM_DT;
	}

	public Date getHTWT_EFF_TO_DT() {
		return HTWT_EFF_TO_DT;
	}

	public void setHTWT_EFF_TO_DT(Date HTWT_EFF_TO_DT) {
		this.HTWT_EFF_TO_DT = HTWT_EFF_TO_DT;
	}

	public Double getHTWT_SYS_ID() {
		return HTWT_SYS_ID;
	}

	public void setHTWT_SYS_ID(Double htwt_sys_id) {
		HTWT_SYS_ID = htwt_sys_id;
	}

	public Double getHTWT_PT_SYS_ID() {
		return HTWT_PT_SYS_ID;
	}

	public void setHTWT_PT_SYS_ID(Double htwt_pt_sys_id) {
		HTWT_PT_SYS_ID = htwt_pt_sys_id;
	}

	public Date getHTWT_CR_DT() {
		return HTWT_CR_DT;
	}

	public void setHTWT_CR_DT(Date htwt_cr_dt) {
		HTWT_CR_DT = htwt_cr_dt;
	}

	public String getHTWT_CR_UID() {
		return HTWT_CR_UID;
	}

	public void setHTWT_CR_UID(String htwt_cr_uid) {
		HTWT_CR_UID = htwt_cr_uid;
	}

	public Date getHTWT_UPD_DT() {
		return HTWT_UPD_DT;
	}

	public void setHTWT_UPD_DT(Date htwt_upd_dt) {
		HTWT_UPD_DT = htwt_upd_dt;
	}

	public String getHTWT_UPD_UID() {
		return HTWT_UPD_UID;
	}

	public void setHTWT_UPD_UID(String htwt_upd_uid) {
		HTWT_UPD_UID = htwt_upd_uid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String toString() {
		return "Ht from<" + this.getHTWT_HEIGHT_FM() + ">sysid<"
				+ this.getHTWT_SYS_ID() + ">";
	}

}
