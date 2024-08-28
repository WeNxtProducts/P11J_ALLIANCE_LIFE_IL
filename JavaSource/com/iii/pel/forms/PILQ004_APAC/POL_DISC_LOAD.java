package com.iii.pel.forms.PILQ004_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_DISC_LOAD")
public class POL_DISC_LOAD extends BaseValueBean {

	@Column(name="PDL_DISC_LOAD_CODE")
	private String PDL_DISC_LOAD_CODE;

	@Column(name="PDL_RATE")
	private Double PDL_RATE;

	@Column(name="PDL_RATE_PER")
	private Double PDL_RATE_PER;

	@Column(name="PDL_LC_DISC_LOAD_VALUE")
	private Double PDL_LC_DISC_LOAD_VALUE;

	private String UI_M_DISCLOAD_DESC;

	@Column(name="PDL_POL_SYS_ID")
	private Double PDL_POL_SYS_ID;

	@Column(name="PDL_DISC_LOAD_TYPE")
	private String PDL_DISC_LOAD_TYPE;



	public String getPDL_DISC_LOAD_CODE() {
		return PDL_DISC_LOAD_CODE;
	}

	public void setPDL_DISC_LOAD_CODE(String PDL_DISC_LOAD_CODE) {
		this.PDL_DISC_LOAD_CODE = PDL_DISC_LOAD_CODE;
	}

	public Double getPDL_RATE() {
		return PDL_RATE;
	}

	public void setPDL_RATE(Double PDL_RATE) {
		this.PDL_RATE = PDL_RATE;
	}

	public Double getPDL_RATE_PER() {
		return PDL_RATE_PER;
	}

	public void setPDL_RATE_PER(Double PDL_RATE_PER) {
		this.PDL_RATE_PER = PDL_RATE_PER;
	}

	public Double getPDL_LC_DISC_LOAD_VALUE() {
		return PDL_LC_DISC_LOAD_VALUE;
	}

	public void setPDL_LC_DISC_LOAD_VALUE(Double PDL_LC_DISC_LOAD_VALUE) {
		this.PDL_LC_DISC_LOAD_VALUE = PDL_LC_DISC_LOAD_VALUE;
	}

	public String getUI_M_DISCLOAD_DESC() {
		return UI_M_DISCLOAD_DESC;
	}

	public void setUI_M_DISCLOAD_DESC(String UI_M_DISCLOAD_DESC) {
		this.UI_M_DISCLOAD_DESC = UI_M_DISCLOAD_DESC;
	}

	public String getPDL_DISC_LOAD_TYPE() {
		return PDL_DISC_LOAD_TYPE;
	}

	public void setPDL_DISC_LOAD_TYPE(String PDL_DISC_LOAD_TYPE) {
		this.PDL_DISC_LOAD_TYPE = PDL_DISC_LOAD_TYPE;
	}

	public Double getPDL_POL_SYS_ID() {
		return PDL_POL_SYS_ID;
	}

	public void setPDL_POL_SYS_ID(Double pdl_pol_sys_id) {
		PDL_POL_SYS_ID = pdl_pol_sys_id;
	}
}
