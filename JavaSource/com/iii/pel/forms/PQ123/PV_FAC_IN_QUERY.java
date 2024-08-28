package com.iii.pel.forms.PQ123;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_FAC_IN_QUERY")
public class PV_FAC_IN_QUERY extends BaseValueBean {

	@Column(name="ORGI_LC_SI")
	private Double ORGI_LC_SI;

	@Column(name="ORGI_FC_SI")
	private Double ORGI_FC_SI;

	@Column(name="ORGI_LC_PREMIUM")
	private Double ORGI_LC_PREMIUM;

	@Column(name="ORGI_FC_PREMIUM")
	private Double ORGI_FC_PREMIUM;

	@Column(name="OUR_SHARE_PER")
	private Double OUR_SHARE_PER;

	@Column(name="OUR_SHARE_LC_SI")
	private Double OUR_SHARE_LC_SI;

	@Column(name="OUR_SHARE_FC_SI")
	private Double OUR_SHARE_FC_SI;

	@Column(name="OUR_SHARE_PREM_LC")
	private Double OUR_SHARE_PREM_LC;

	@Column(name="OUR_SHARE_PREM_FC")
	private Double OUR_SHARE_PREM_FC;

	@Column(name="COMMISSION_PAID_LC")
	private Double COMMISSION_PAID_LC;

	@Column(name="COMMISSION_PAID_FC")
	private Double COMMISSION_PAID_FC;

	@Column(name="TAX_PAID_LC")
	private Double TAX_PAID_LC;

	@Column(name="TAX_PAID_FC")
	private Double TAX_PAID_FC;



	public Double getORGI_LC_SI() {
		return ORGI_LC_SI;
	}

	public void setORGI_LC_SI(Double ORGI_LC_SI) {
		this.ORGI_LC_SI = ORGI_LC_SI;
	}

	public Double getORGI_FC_SI() {
		return ORGI_FC_SI;
	}

	public void setORGI_FC_SI(Double ORGI_FC_SI) {
		this.ORGI_FC_SI = ORGI_FC_SI;
	}

	public Double getORGI_LC_PREMIUM() {
		return ORGI_LC_PREMIUM;
	}

	public void setORGI_LC_PREMIUM(Double ORGI_LC_PREMIUM) {
		this.ORGI_LC_PREMIUM = ORGI_LC_PREMIUM;
	}

	public Double getORGI_FC_PREMIUM() {
		return ORGI_FC_PREMIUM;
	}

	public void setORGI_FC_PREMIUM(Double ORGI_FC_PREMIUM) {
		this.ORGI_FC_PREMIUM = ORGI_FC_PREMIUM;
	}

	public Double getOUR_SHARE_PER() {
		return OUR_SHARE_PER;
	}

	public void setOUR_SHARE_PER(Double OUR_SHARE_PER) {
		this.OUR_SHARE_PER = OUR_SHARE_PER;
	}

	public Double getOUR_SHARE_LC_SI() {
		return OUR_SHARE_LC_SI;
	}

	public void setOUR_SHARE_LC_SI(Double OUR_SHARE_LC_SI) {
		this.OUR_SHARE_LC_SI = OUR_SHARE_LC_SI;
	}

	public Double getOUR_SHARE_FC_SI() {
		return OUR_SHARE_FC_SI;
	}

	public void setOUR_SHARE_FC_SI(Double OUR_SHARE_FC_SI) {
		this.OUR_SHARE_FC_SI = OUR_SHARE_FC_SI;
	}

	public Double getOUR_SHARE_PREM_LC() {
		return OUR_SHARE_PREM_LC;
	}

	public void setOUR_SHARE_PREM_LC(Double OUR_SHARE_PREM_LC) {
		this.OUR_SHARE_PREM_LC = OUR_SHARE_PREM_LC;
	}

	public Double getOUR_SHARE_PREM_FC() {
		return OUR_SHARE_PREM_FC;
	}

	public void setOUR_SHARE_PREM_FC(Double OUR_SHARE_PREM_FC) {
		this.OUR_SHARE_PREM_FC = OUR_SHARE_PREM_FC;
	}

	public Double getCOMMISSION_PAID_LC() {
		return COMMISSION_PAID_LC;
	}

	public void setCOMMISSION_PAID_LC(Double COMMISSION_PAID_LC) {
		this.COMMISSION_PAID_LC = COMMISSION_PAID_LC;
	}

	public Double getCOMMISSION_PAID_FC() {
		return COMMISSION_PAID_FC;
	}

	public void setCOMMISSION_PAID_FC(Double COMMISSION_PAID_FC) {
		this.COMMISSION_PAID_FC = COMMISSION_PAID_FC;
	}

	public Double getTAX_PAID_LC() {
		return TAX_PAID_LC;
	}

	public void setTAX_PAID_LC(Double TAX_PAID_LC) {
		this.TAX_PAID_LC = TAX_PAID_LC;
	}

	public Double getTAX_PAID_FC() {
		return TAX_PAID_FC;
	}

	public void setTAX_PAID_FC(Double TAX_PAID_FC) {
		this.TAX_PAID_FC = TAX_PAID_FC;
	}
}
