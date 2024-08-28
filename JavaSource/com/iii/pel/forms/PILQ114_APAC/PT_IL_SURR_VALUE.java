package com.iii.pel.forms.PILQ114_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_SURR_VALUE")
public class PT_IL_SURR_VALUE extends BaseValueBean {

	@Column(name = "PSV_SYS_ID")
	private Long PSV_SYS_ID;

	@Column(name = "PSV_POL_NO")
	private String PSV_POL_NO;

	@Column(name = "PSV_POL_SYS_ID")
	private Long PSV_POL_SYS_ID;

	@Column(name = "PSV_COVER_CODE")
	private String PSV_COVER_CODE;

	@Column(name = "PSV_COVER_LC_PREM")
	private Double PSV_COVER_LC_PREM;

	@Column(name = "PSV_COVER_FC_PREM")
	private Double PSV_COVER_FC_PREM;

	@Column(name = "PSV_POL_COMP_YEAR")
	private Double PSV_POL_COMP_YEAR;

	@Column(name = "PSV_ACNT_YEAR")
	private Double PSV_ACNT_YEAR;

	@Column(name = "PSV_SUR_RATE")
	private Double PSV_SUR_RATE;

	@Column(name = "PSV_SUR_RATE_PER")
	private Double PSV_SUR_RATE_PER;

	@Column(name = "PSV_SUR_LC_VALUE")
	private Double PSV_SUR_LC_VALUE;

	@Column(name = "PSV_SUR_FC_VALUE")
	private Double PSV_SUR_FC_VALUE;

	public void setPSV_COVER_FC_PREM(Double PSV_COVER_FC_PREM) {
		this.PSV_COVER_FC_PREM = PSV_COVER_FC_PREM;
	}

	public Double getPSV_COVER_FC_PREM() {
		return PSV_COVER_FC_PREM;
	}

	public void setPSV_SUR_LC_VALUE(Double PSV_SUR_LC_VALUE) {
		this.PSV_SUR_LC_VALUE = PSV_SUR_LC_VALUE;
	}

	public Double getPSV_SUR_LC_VALUE() {
		return PSV_SUR_LC_VALUE;
	}

	public void setPSV_COVER_CODE(String PSV_COVER_CODE) {
		this.PSV_COVER_CODE = PSV_COVER_CODE;
	}

	public String getPSV_COVER_CODE() {
		return PSV_COVER_CODE;
	}

	public void setPSV_SYS_ID(Long PSV_SYS_ID) {
		this.PSV_SYS_ID = PSV_SYS_ID;
	}

	public Long getPSV_SYS_ID() {
		return PSV_SYS_ID;
	}

	public void setPSV_COVER_LC_PREM(Double PSV_COVER_LC_PREM) {
		this.PSV_COVER_LC_PREM = PSV_COVER_LC_PREM;
	}

	public Double getPSV_COVER_LC_PREM() {
		return PSV_COVER_LC_PREM;
	}

	public void setPSV_SUR_FC_VALUE(Double PSV_SUR_FC_VALUE) {
		this.PSV_SUR_FC_VALUE = PSV_SUR_FC_VALUE;
	}

	public Double getPSV_SUR_FC_VALUE() {
		return PSV_SUR_FC_VALUE;
	}

	public void setPSV_SUR_RATE_PER(Double PSV_SUR_RATE_PER) {
		this.PSV_SUR_RATE_PER = PSV_SUR_RATE_PER;
	}

	public Double getPSV_SUR_RATE_PER() {
		return PSV_SUR_RATE_PER;
	}

	public void setPSV_SUR_RATE(Double PSV_SUR_RATE) {
		this.PSV_SUR_RATE = PSV_SUR_RATE;
	}

	public Double getPSV_SUR_RATE() {
		return PSV_SUR_RATE;
	}

	public void setPSV_POL_COMP_YEAR(Double PSV_POL_COMP_YEAR) {
		this.PSV_POL_COMP_YEAR = PSV_POL_COMP_YEAR;
	}

	public Double getPSV_POL_COMP_YEAR() {
		return PSV_POL_COMP_YEAR;
	}

	public void setPSV_POL_SYS_ID(Long PSV_POL_SYS_ID) {
		this.PSV_POL_SYS_ID = PSV_POL_SYS_ID;
	}

	public Long getPSV_POL_SYS_ID() {
		return PSV_POL_SYS_ID;
	}

	public void setPSV_POL_NO(String PSV_POL_NO) {
		this.PSV_POL_NO = PSV_POL_NO;
	}

	public String getPSV_POL_NO() {
		return PSV_POL_NO;
	}

	public void setPSV_ACNT_YEAR(Double PSV_ACNT_YEAR) {
		this.PSV_ACNT_YEAR = PSV_ACNT_YEAR;
	}

	public Double getPSV_ACNT_YEAR() {
		return PSV_ACNT_YEAR;
	}

}