package com.iii.pel.forms.PM103_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_PF_INT_SETUP")
public class PM_AGENT_PF_INT_SETUP extends BaseValueBean {

	
	@Id
	@Column(name="ROWID")
	private String ROWID;

	
	@Column(name="APIS_CR_UID")
	private String APIS_CR_UID;
	
	@Column(name="APIS_CR_DT")
	private Date APIS_CR_DT;
	
	@Column(name="APIS_UPD_UID")
	private String APIS_UPD_UID;
	
	@Column(name="APIS_UPD_DT")
	private Date APIS_UPD_DT;
	
	
	@Column(name="APIS_RATE")
	private Double APIS_RATE;

	@Column(name="APIS_RATE_PER")
	private Double APIS_RATE_PER;

	@Column(name="APIS_EFF_FM_DT")
	private Date APIS_EFF_FM_DT;

	@Column(name="APIS_EFF_TO_DT")
	private Date APIS_EFF_TO_DT;
	
	
	
	
	
   
	private boolean CHECK_BOX;


	/*public Double getUI_M_APIS_RATE() {
		return UI_M_APIS_RATE;
	}

	public void setUI_M_APIS_RATE(Double UI_M_APIS_RATE) {
		this.UI_M_APIS_RATE = UI_M_APIS_RATE;
	}

	public Double getUI_M_APIS_RATE_PER() {
		return UI_M_APIS_RATE_PER;
	}

	public void setUI_M_APIS_RATE_PER(Double UI_M_APIS_RATE_PER) {
		this.UI_M_APIS_RATE_PER = UI_M_APIS_RATE_PER;
	}

	public Date getUI_M_APIS_EFF_FM_DT() {
		 return UI_M_APIS_EFF_FM_DT;
	}

	public void setUI_M_APIS_EFF_FM_DT(Date UI_M_APIS_EFF_FM_DT) {
		this.UI_M_APIS_EFF_FM_DT = UI_M_APIS_EFF_FM_DT;
	}

	public Date getUI_M_APIS_EFF_TO_DT() {
		 return UI_M_APIS_EFF_TO_DT;
	}

	public void setUI_M_APIS_EFF_TO_DT(Date UI_M_APIS_EFF_TO_DT) {
		this.UI_M_APIS_EFF_TO_DT = UI_M_APIS_EFF_TO_DT;
	}*/
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getAPIS_CR_UID() {
		return APIS_CR_UID;
	}

	public void setAPIS_CR_UID(String apis_cr_uid) {
		APIS_CR_UID = apis_cr_uid;
	}

	public Date getAPIS_CR_DT() {
		return APIS_CR_DT;
	}

	public void setAPIS_CR_DT(Date apis_cr_dt) {
		APIS_CR_DT = apis_cr_dt;
	}

	public String getAPIS_UPD_UID() {
		return APIS_UPD_UID;
	}

	public void setAPIS_UPD_UID(String apis_upd_uid) {
		APIS_UPD_UID = apis_upd_uid;
	}

	public Date getAPIS_UPD_DT() {
		return APIS_UPD_DT;
	}

	public void setAPIS_UPD_DT(Date apis_upd_dt) {
		APIS_UPD_DT = apis_upd_dt;
	}

	public Double getAPIS_RATE() {
		return APIS_RATE;
	}

	public void setAPIS_RATE(Double apis_rate) {
		APIS_RATE = apis_rate;
	}

	public Double getAPIS_RATE_PER() {
		return APIS_RATE_PER;
	}

	public void setAPIS_RATE_PER(Double apis_rate_per) {
		APIS_RATE_PER = apis_rate_per;
	}

	public Date getAPIS_EFF_FM_DT() {
		return APIS_EFF_FM_DT;
	}

	public void setAPIS_EFF_FM_DT(Date apis_eff_fm_dt) {
		APIS_EFF_FM_DT = apis_eff_fm_dt;
	}

	public Date getAPIS_EFF_TO_DT() {
		return APIS_EFF_TO_DT;
	}

	public void setAPIS_EFF_TO_DT(Date apis_eff_to_dt) {
		APIS_EFF_TO_DT = apis_eff_to_dt;
	}
}
