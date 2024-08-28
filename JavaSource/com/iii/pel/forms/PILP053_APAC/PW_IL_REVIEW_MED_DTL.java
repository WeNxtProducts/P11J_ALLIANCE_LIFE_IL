package com.iii.pel.forms.PILP053_APAC;

//import com.iii.apps.persistence.Column;
import com.iii.premia.common.bean.BaseValueBean;

//@Table(name = "PW_IL_REVIEW_MED_DTL")
public class PW_IL_REVIEW_MED_DTL extends BaseValueBean {

	//@Column(name = "RMD_YEAR")
	private Double RMD_YEAR;

	//@Column(name = "RMD_COVER_CODE")
	private String RMD_COVER_CODE;

	//@Column(name = "RMD_SUM_ASSURED")
	private Double RMD_SUM_ASSURED;

	//@Column(name = "RMD_PREMIUM")
	private Double RMD_PREMIUM;

	//@Column(name = "RMD_AGE")
	private Double RMD_AGE;

	//@Column(name = "RMD_UNEARN_CONT_AMT")
	private Double RMD_UNEARN_CONT_AMT;

	//@Column(name = "RMD_LOAD_FLAG")
	private String RMD_LOAD_FLAG;

	//@Column(name = "RMD_RATE")
	private Double RMD_RATE;

	//@Column(name = "RMD_LOAD")
	private Double RMD_LOAD;

	//@Column(name = "RMD_DISC")
	private Double RMD_DISC;

	//@Column(name = "RMD_NET_PREM")
	private Double RMD_NET_PREM;

	private String UI_M_RMD_COVER_CODE_DESC;

	public void setRMD_PREMIUM(Double RMD_PREMIUM) {
		this.RMD_PREMIUM = RMD_PREMIUM;
	}

	public Double getRMD_PREMIUM() {
		return RMD_PREMIUM;
	}

	public void setRMD_AGE(Double RMD_AGE) {
		this.RMD_AGE = RMD_AGE;
	}

	public Double getRMD_AGE() {
		return RMD_AGE;
	}

	public void setRMD_LOAD(Double RMD_LOAD) {
		this.RMD_LOAD = RMD_LOAD;
	}

	public Double getRMD_LOAD() {
		return RMD_LOAD;
	}

	public void setRMD_RATE(Double RMD_RATE) {
		this.RMD_RATE = RMD_RATE;
	}

	public Double getRMD_RATE() {
		return RMD_RATE;
	}

	public void setRMD_COVER_CODE(String RMD_COVER_CODE) {
		this.RMD_COVER_CODE = RMD_COVER_CODE;
	}

	public String getRMD_COVER_CODE() {
		return RMD_COVER_CODE;
	}

	public void setRMD_SUM_ASSURED(Double RMD_SUM_ASSURED) {
		this.RMD_SUM_ASSURED = RMD_SUM_ASSURED;
	}

	public Double getRMD_SUM_ASSURED() {
		return RMD_SUM_ASSURED;
	}

	public void setUI_M_RMD_COVER_CODE_DESC(String UI_M_RMD_COVER_CODE_DESC) {
		this.UI_M_RMD_COVER_CODE_DESC = UI_M_RMD_COVER_CODE_DESC;
	}

	public String getUI_M_RMD_COVER_CODE_DESC() {
		return UI_M_RMD_COVER_CODE_DESC;
	}

	public void setRMD_LOAD_FLAG(String RMD_LOAD_FLAG) {
		this.RMD_LOAD_FLAG = RMD_LOAD_FLAG;
	}

	public String getRMD_LOAD_FLAG() {
		return RMD_LOAD_FLAG;
	}

	public void setRMD_YEAR(Double RMD_YEAR) {
		this.RMD_YEAR = RMD_YEAR;
	}

	public Double getRMD_YEAR() {
		return RMD_YEAR;
	}

	public void setRMD_UNEARN_CONT_AMT(Double RMD_UNEARN_CONT_AMT) {
		this.RMD_UNEARN_CONT_AMT = RMD_UNEARN_CONT_AMT;
	}

	public Double getRMD_UNEARN_CONT_AMT() {
		return RMD_UNEARN_CONT_AMT;
	}

	public void setRMD_NET_PREM(Double RMD_NET_PREM) {
		this.RMD_NET_PREM = RMD_NET_PREM;
	}

	public Double getRMD_NET_PREM() {
		return RMD_NET_PREM;
	}

	public void setRMD_DISC(Double RMD_DISC) {
		this.RMD_DISC = RMD_DISC;
	}

	public Double getRMD_DISC() {
		return RMD_DISC;
	}

}
