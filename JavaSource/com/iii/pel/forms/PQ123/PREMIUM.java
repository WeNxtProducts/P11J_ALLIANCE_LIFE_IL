package com.iii.pel.forms.PQ123;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class PREMIUM extends BaseValueBean {

	private Double TOT_PREM;

	private Double TOT_DISCOUNT;

	private Double TOT_LOADING;

	private Double SUB_TOT_PREM;

	private Double TOT_CHARGES;

	private Double NET_PREM;



	public Double getTOT_PREM() {
		return TOT_PREM;
	}

	public void setTOT_PREM(Double TOT_PREM) {
		this.TOT_PREM = TOT_PREM;
	}

	public Double getTOT_DISCOUNT() {
		return TOT_DISCOUNT;
	}

	public void setTOT_DISCOUNT(Double TOT_DISCOUNT) {
		this.TOT_DISCOUNT = TOT_DISCOUNT;
	}

	public Double getTOT_LOADING() {
		return TOT_LOADING;
	}

	public void setTOT_LOADING(Double TOT_LOADING) {
		this.TOT_LOADING = TOT_LOADING;
	}

	public Double getSUB_TOT_PREM() {
		return SUB_TOT_PREM;
	}

	public void setSUB_TOT_PREM(Double SUB_TOT_PREM) {
		this.SUB_TOT_PREM = SUB_TOT_PREM;
	}

	public Double getTOT_CHARGES() {
		return TOT_CHARGES;
	}

	public void setTOT_CHARGES(Double TOT_CHARGES) {
		this.TOT_CHARGES = TOT_CHARGES;
	}

	public Double getNET_PREM() {
		return NET_PREM;
	}

	public void setNET_PREM(Double NET_PREM) {
		this.NET_PREM = NET_PREM;
	}
}
