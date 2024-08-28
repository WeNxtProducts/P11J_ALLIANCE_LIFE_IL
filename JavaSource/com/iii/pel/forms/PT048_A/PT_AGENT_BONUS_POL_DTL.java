package com.iii.pel.forms.PT048_A;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_AGENT_BONUS_POL_DTL")
public class PT_AGENT_BONUS_POL_DTL extends BaseValueBean {

	@Column(name = "ABPD_POL_NO")
	private String ABPD_POL_NO;

	@Column(name = "ABPD_PREM_TYPE")
	private String ABPD_PREM_TYPE;

	@Column(name = "ABPD_PROD_CODE")
	private String ABPD_PROD_CODE;

	@Column(name = "ABPD_SHARE_PERC")
	private String ABPD_SHARE_PERC;

	@Column(name = "ABPD_LC_INV_PREM")
	private String ABPD_LC_INV_PREM;

	public String getABPD_POL_NO() {
		return ABPD_POL_NO;
	}

	public void setABPD_POL_NO(String aBPD_POL_NO) {
		ABPD_POL_NO = aBPD_POL_NO;
	}

	public String getABPD_PREM_TYPE() {
		return ABPD_PREM_TYPE;
	}

	public void setABPD_PREM_TYPE(String aBPD_PREM_TYPE) {
		ABPD_PREM_TYPE = aBPD_PREM_TYPE;
	}

	public String getABPD_PROD_CODE() {
		return ABPD_PROD_CODE;
	}

	public void setABPD_PROD_CODE(String aBPD_PROD_CODE) {
		ABPD_PROD_CODE = aBPD_PROD_CODE;
	}

	public String getABPD_SHARE_PERC() {
		return ABPD_SHARE_PERC;
	}

	public void setABPD_SHARE_PERC(String aBPD_SHARE_PERC) {
		ABPD_SHARE_PERC = aBPD_SHARE_PERC;
	}

	public String getABPD_LC_INV_PREM() {
		return ABPD_LC_INV_PREM;
	}

	public void setABPD_LC_INV_PREM(String aBPD_LC_INV_PREM) {
		ABPD_LC_INV_PREM = aBPD_LC_INV_PREM;
	}

}
