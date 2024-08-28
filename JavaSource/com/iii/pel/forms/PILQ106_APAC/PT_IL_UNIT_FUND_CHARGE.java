package com.iii.pel.forms.PILQ106_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_UNIT_FUND_CHARGE")
public class PT_IL_UNIT_FUND_CHARGE extends BaseValueBean {

	@Column(name="UNFC_POL_SYS_ID")
	private Long UNFC_POL_SYS_ID;
	
	@Column(name="UNFC_CHRG_DES")
	private String UNFC_CHRG_DES;
	
	@Column(name="UNFC_CHRG_VAL")
	private String  UNFC_CHRG_VAL;
	

	public Long getUNFC_POL_SYS_ID() {
		return UNFC_POL_SYS_ID;
	}

	public void setUNFC_POL_SYS_ID(Long uNFC_POL_SYS_ID) {
		UNFC_POL_SYS_ID = uNFC_POL_SYS_ID;
	}

	public String getUNFC_CHRG_DES() {
		return UNFC_CHRG_DES;
	}

	public void setUNFC_CHRG_DES(String uNFC_CHRG_DES) {
		UNFC_CHRG_DES = uNFC_CHRG_DES;
	}

	public String getUNFC_CHRG_VAL() {
		return UNFC_CHRG_VAL;
	}

	public void setUNFC_CHRG_VAL(String uNFC_CHRG_VAL) {
		UNFC_CHRG_VAL = uNFC_CHRG_VAL;
	}
	
}
