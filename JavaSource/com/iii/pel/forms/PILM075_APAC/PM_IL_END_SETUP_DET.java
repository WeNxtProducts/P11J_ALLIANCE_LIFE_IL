package com.iii.pel.forms.PILM075_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_END_SETUP_DET")
public class PM_IL_END_SETUP_DET extends BaseValueBean {

	@Column(name="ESD_CODE")
	private String ESD_CODE;

	@Column(name="ESD_UPD_UID")
	private String ESD_UPD_UID;
	
	@Column(name="ESD_UPD_DT")
	private Date ESD_UPD_DT;
	
	private String UI_M_ESD_CODE_DESC;

	@Column(name="ESD_NUM_VALUE")
	private Double ESD_NUM_VALUE;

	private boolean CHECKBOX;

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getESD_CODE() {
		return ESD_CODE;
	}

	public void setESD_CODE(String ESD_CODE) {
		this.ESD_CODE = ESD_CODE;
	}

	public String getUI_M_ESD_CODE_DESC() {
		return UI_M_ESD_CODE_DESC;
	}

	public void setUI_M_ESD_CODE_DESC(String UI_M_ESD_CODE_DESC) {
		this.UI_M_ESD_CODE_DESC = UI_M_ESD_CODE_DESC;
	}

	public Double getESD_NUM_VALUE() {
		return ESD_NUM_VALUE;
	}

	public void setESD_NUM_VALUE(Double ESD_NUM_VALUE) {
		this.ESD_NUM_VALUE = ESD_NUM_VALUE;
	}

	public String getESD_UPD_UID() {
		return ESD_UPD_UID;
	}

	public void setESD_UPD_UID(String esd_upd_uid) {
		ESD_UPD_UID = esd_upd_uid;
	}

	public Date getESD_UPD_DT() {
		return ESD_UPD_DT;
	}

	public void setESD_UPD_DT(Date esd_upd_dt) {
		ESD_UPD_DT = esd_upd_dt;
	}
}
