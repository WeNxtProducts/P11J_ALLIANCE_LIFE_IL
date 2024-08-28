package com.iii.pel.forms.PILP078;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_ADJ_PROP_DEP")
public class PT_IL_ADJ_PROP_DEP extends BaseValueBean{
	
	@Column(name="APD_PROP_NO")
	private String APD_PROP_NO;
	
	@Column(name="APD_STATUS")
	private String APD_STATUS;
	
	@Column(name="APD_FC_AMOUNT")
	private Double APD_FC_AMOUNT;
	
	private Double UI_PROP_DEPOSIT;
	
	@Column(name = "APD_CR_UID")
	private String APD_CR_UID;

	@Column(name = "APD_CR_DT")
	private Date APD_CR_DT;
	
	@Column(name = "APD_UPD_UID")
	private String APD_UPD_UID;
	
	@Column(name = "APD_UPD_DT")
	private Date APD_UPD_DT;

	public String getAPD_CR_UID() {
		return APD_CR_UID;
	}

	public void setAPD_CR_UID(String aPD_CR_UID) {
		APD_CR_UID = aPD_CR_UID;
	}

	public Date getAPD_CR_DT() {
		return APD_CR_DT;
	}

	public void setAPD_CR_DT(Date aPD_CR_DT) {
		APD_CR_DT = aPD_CR_DT;
	}

	public String getAPD_UPD_UID() {
		return APD_UPD_UID;
	}

	public void setAPD_UPD_UID(String aPD_UPD_UID) {
		APD_UPD_UID = aPD_UPD_UID;
	}

	public Date getAPD_UPD_DT() {
		return APD_UPD_DT;
	}

	public void setAPD_UPD_DT(Date aPD_UPD_DT) {
		APD_UPD_DT = aPD_UPD_DT;
	}

	public Double getUI_PROP_DEPOSIT() {
		return UI_PROP_DEPOSIT;
	}

	public void setUI_PROP_DEPOSIT(Double uI_PROP_DEPOSIT) {
		UI_PROP_DEPOSIT = uI_PROP_DEPOSIT;
	}

	public String getAPD_PROP_NO() {
		return APD_PROP_NO;
	}

	public void setAPD_PROP_NO(String aPD_PROP_NO) {
		APD_PROP_NO = aPD_PROP_NO;
	}

	public String getAPD_STATUS() {
		return APD_STATUS;
	}

	public void setAPD_STATUS(String aPD_STATUS) {
		APD_STATUS = aPD_STATUS;
	}

	public Double getAPD_FC_AMOUNT() {
		return APD_FC_AMOUNT;
	}

	public void setAPD_FC_AMOUNT(Double aPD_FC_AMOUNT) {
		APD_FC_AMOUNT = aPD_FC_AMOUNT;
	}

}
