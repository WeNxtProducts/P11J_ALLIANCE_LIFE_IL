package com.iii.pel.forms.PILP078;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_ADJ_PREM_COLL")

public class PT_IL_ADJ_PREM_COLL extends BaseValueBean {
	
	@Column(name="APC_POL_NO")
	private String APC_POL_NO;
	
	@Column(name="APC_STATUS")
	private String APC_STATUS;
	
	@Column(name="APC_FC_PREM")
	private Double APC_FC_PREM;
	
	@Column(name="APC_FC_INT")
	private Double APC_FC_INT;
	
	@Column(name="APC_SCHD_PYMT_DT")
	private Date APC_SCHD_PYMT_DT;
	
	private Double UI_POL_PREM;
	
	@Column(name = "APC_CR_UID")
	private String APC_CR_UID;

	@Column(name = "APC_CR_DT")
	private Date APC_CR_DT;
	
	@Column(name = "APC_UPD_UID")
	private String APC_UPD_UID;
	
	@Column(name = "APC_UPD_DT")
	private Date APC_UPD_DT;
	
	public String getAPC_UPD_UID() {
		return APC_UPD_UID;
	}

	public void setAPC_UPD_UID(String aPC_UPD_UID) {
		APC_UPD_UID = aPC_UPD_UID;
	}

	public Date getAPC_UPD_DT() {
		return APC_UPD_DT;
	}

	public void setAPC_UPD_DT(Date aPC_UPD_DT) {
		APC_UPD_DT = aPC_UPD_DT;
	}

	public String getAPC_CR_UID() {
		return APC_CR_UID;
	}

	public void setAPC_CR_UID(String aPC_CR_UID) {
		APC_CR_UID = aPC_CR_UID;
	}

	public Date getAPC_CR_DT() {
		return APC_CR_DT;
	}

	public void setAPC_CR_DT(Date aPC_CR_DT) {
		APC_CR_DT = aPC_CR_DT;
	}

	public Double getUI_POL_PREM() {
		return UI_POL_PREM;
	}

	public void setUI_POL_PREM(Double uI_POL_PREM) {
		UI_POL_PREM = uI_POL_PREM;
	}

	public String getAPC_POL_NO() {
		return APC_POL_NO;
	}

	public void setAPC_POL_NO(String aPC_POL_NO) {
		APC_POL_NO = aPC_POL_NO;
	}

	public String getAPC_STATUS() {
		return APC_STATUS;
	}

	public void setAPC_STATUS(String aPC_STATUS) {
		APC_STATUS = aPC_STATUS;
	}

	public Double getAPC_FC_PREM() {
		return APC_FC_PREM;
	}

	public void setAPC_FC_PREM(Double aPC_FC_PREM) {
		APC_FC_PREM = aPC_FC_PREM;
	}

	public Double getAPC_FC_INT() {
		return APC_FC_INT;
	}

	public void setAPC_FC_INT(Double aPC_FC_INT) {
		APC_FC_INT = aPC_FC_INT;
	}

	public Date getAPC_SCHD_PYMT_DT() {
		return APC_SCHD_PYMT_DT;
	}

	public void setAPC_SCHD_PYMT_DT(Date aPC_SCHD_PYMT_DT) {
		APC_SCHD_PYMT_DT = aPC_SCHD_PYMT_DT;
	}



}
