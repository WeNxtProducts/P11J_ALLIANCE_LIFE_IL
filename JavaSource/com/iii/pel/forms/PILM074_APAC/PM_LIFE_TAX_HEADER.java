package com.iii.pel.forms.PILM074_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_LIFE_TAX_HEADER")
public class PM_LIFE_TAX_HEADER extends BaseValueBean {

	@Column(name="TH_TAX_TYPE")
	private String TH_TAX_TYPE;

	@Column(name="TH_TAX_DESC")
	private String TH_TAX_DESC;

	@Column(name="TH_TAX_LONG_DESC")
	private String TH_TAX_LONG_DESC;

	@Column(name="TH_TAX_SHORT_DESC")
	private String TH_TAX_SHORT_DESC;

	@Column(name="TH_TAX_CALC_TYPE")
	private String TH_TAX_CALC_TYPE;

	@Column(name="TH_EFF_FM_DT")
	private Date TH_EFF_FM_DT;

	@Column(name="TH_EFF_TO_DT")
	private Date TH_EFF_TO_DT;
	
	//Added by kavitha on 07.10.2019 for orient
	@Column(name="TH_LOCATION")
	private String TH_LOCATION;
	
	@Column(name="TH_VAT_YN")
	private String TH_VAT_YN;
	
	@Column(name="TH_VAT_PERC")
	private Integer TH_VAT_PERC;
	
	@Column(name="TH_VAT_TRTMT")
	private String TH_VAT_TRTMT;
	
	@Column(name="TH_SELF_INVOICE_YN")
	private String TH_SELF_INVOICE_YN;

	public String getTH_LOCATION() {
		return TH_LOCATION;
	}

	public void setTH_LOCATION(String tH_LOCATION) {
		TH_LOCATION = tH_LOCATION;
	}

	public String getTH_VAT_YN() {
		return TH_VAT_YN;
	}

	public void setTH_VAT_YN(String tH_VAT_YN) {
		TH_VAT_YN = tH_VAT_YN;
	}

	public Integer getTH_VAT_PERC() {
		return TH_VAT_PERC;
	}

	public void setTH_VAT_PERC(Integer tH_VAT_PERC) {
		TH_VAT_PERC = tH_VAT_PERC;
	}

	public String getTH_VAT_TRTMT() {
		return TH_VAT_TRTMT;
	}

	public void setTH_VAT_TRTMT(String tH_VAT_TRTMT) {
		TH_VAT_TRTMT = tH_VAT_TRTMT;
	}

	public String getTH_SELF_INVOICE_YN() {
		return TH_SELF_INVOICE_YN;
	}

	public void setTH_SELF_INVOICE_YN(String tH_SELF_INVOICE_YN) {
		TH_SELF_INVOICE_YN = tH_SELF_INVOICE_YN;
	}

	//End
	public String getTH_TAX_TYPE() {
		return TH_TAX_TYPE;
	}

	public void setTH_TAX_TYPE(String TH_TAX_TYPE) {
		this.TH_TAX_TYPE = TH_TAX_TYPE;
	}

	public String getTH_TAX_DESC() {
		return TH_TAX_DESC;
	}

	public void setTH_TAX_DESC(String TH_TAX_DESC) {
		this.TH_TAX_DESC = TH_TAX_DESC;
	}

	public String getTH_TAX_LONG_DESC() {
		return TH_TAX_LONG_DESC;
	}

	public void setTH_TAX_LONG_DESC(String TH_TAX_LONG_DESC) {
		this.TH_TAX_LONG_DESC = TH_TAX_LONG_DESC;
	}

	public String getTH_TAX_SHORT_DESC() {
		return TH_TAX_SHORT_DESC;
	}

	public void setTH_TAX_SHORT_DESC(String TH_TAX_SHORT_DESC) {
		this.TH_TAX_SHORT_DESC = TH_TAX_SHORT_DESC;
	}

	public String getTH_TAX_CALC_TYPE() {
		return TH_TAX_CALC_TYPE;
	}

	public void setTH_TAX_CALC_TYPE(String TH_TAX_CALC_TYPE) {
		this.TH_TAX_CALC_TYPE = TH_TAX_CALC_TYPE;
	}

	public Date getTH_EFF_FM_DT() {
		 return TH_EFF_FM_DT;
	}

	public void setTH_EFF_FM_DT(Date TH_EFF_FM_DT) {
		this.TH_EFF_FM_DT = TH_EFF_FM_DT;
	}

	public Date getTH_EFF_TO_DT() {
		 return TH_EFF_TO_DT;
	}

	public void setTH_EFF_TO_DT(Date TH_EFF_TO_DT) {
		this.TH_EFF_TO_DT = TH_EFF_TO_DT;
	}
	/*Added by senthilnathan for orient*/
	@Column(name="TH_VAT_RECOVER_YN")
	private String TH_VAT_RECOVER_YN;

	public String getTH_VAT_RECOVER_YN() {
		return TH_VAT_RECOVER_YN;
	}

	public void setTH_VAT_RECOVER_YN(String tH_VAT_RECOVER_YN) {
		TH_VAT_RECOVER_YN = tH_VAT_RECOVER_YN;
	}	
	
	/*End*/
}
