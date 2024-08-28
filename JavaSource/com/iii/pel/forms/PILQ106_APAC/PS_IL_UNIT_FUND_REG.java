package com.iii.pel.forms.PILQ106_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PS_IL_UNIT_FUND_REG")
public class PS_IL_UNIT_FUND_REG extends BaseValueBean {

	@Column(name = "UFR_POL_NO")
	private String UFR_POL_NO;

	@Column(name = "UFR_POL_SYS_ID")
	private Long UFR_POL_SYS_ID;

	@Column(name = "UFR_FUND_CODE")
	private String UFR_FUND_CODE;

	@Column(name = "UFR_NO_OF_UNITS")
	private Double UFR_NO_OF_UNITS;

	@Column(name = "UFR_UPD_TRAN")
	private String UFR_UPD_TRAN;

	@Column(name = "UFR_CR_UID")
	private String UFR_CR_UID;

	@Column(name = "UFR_CR_DT")
	private Date UFR_CR_DT;

	@Column(name = "UFR_UPD_UID")
	private String UFR_UPD_UID;

	@Column(name = "UFR_UPD_DT")
	private Date UFR_UPD_DT;

	@Column(name = "UFR_TOP_UP_UNITS")
	private Double UFR_TOP_UP_UNITS;

	@Column(name = "UFR_PREM_UNITS")
	private Double UFR_PREM_UNITS;

	private String UI_M_POL_NO;
	private String UI_M_FUND_DESC;
	private Double UI_M_TOT_UNIT_VALUE;
	private Double  UNIT_PRICE;
	private Double  UNIT_VALUE;

	public void setUFR_FUND_CODE(String UFR_FUND_CODE) {
		this.UFR_FUND_CODE = UFR_FUND_CODE;
	}

	public String getUFR_FUND_CODE() {
		return UFR_FUND_CODE;
	}

	public void setUI_M_FUND_DESC(String UI_M_FUND_DESC) {
		this.UI_M_FUND_DESC = UI_M_FUND_DESC;
	}

	public String getUI_M_FUND_DESC() {
		return UI_M_FUND_DESC;
	}

	public void setUI_M_TOT_UNIT_VALUE(Double UI_M_TOT_UNIT_VALUE) {
		this.UI_M_TOT_UNIT_VALUE = UI_M_TOT_UNIT_VALUE;
	}

	public Double getUI_M_TOT_UNIT_VALUE() {
		return UI_M_TOT_UNIT_VALUE;
	}

	public void setUFR_TOP_UP_UNITS(Double UFR_TOP_UP_UNITS) {
		this.UFR_TOP_UP_UNITS = UFR_TOP_UP_UNITS;
	}

	public Double getUFR_TOP_UP_UNITS() {
		return UFR_TOP_UP_UNITS;
	}

	public void setUFR_UPD_DT(Date UFR_UPD_DT) {
		this.UFR_UPD_DT = UFR_UPD_DT;
	}

	public Date getUFR_UPD_DT() {
		return UFR_UPD_DT;
	}

	public void setUFR_PREM_UNITS(Double UFR_PREM_UNITS) {
		this.UFR_PREM_UNITS = UFR_PREM_UNITS;
	}

	public Double getUFR_PREM_UNITS() {
		return UFR_PREM_UNITS;
	}

	public void setUFR_CR_UID(String UFR_CR_UID) {
		this.UFR_CR_UID = UFR_CR_UID;
	}

	public String getUFR_CR_UID() {
		return UFR_CR_UID;
	}

	public void setUFR_CR_DT(Date UFR_CR_DT) {
		this.UFR_CR_DT = UFR_CR_DT;
	}

	public Date getUFR_CR_DT() {
		return UFR_CR_DT;
	}

	public void setUFR_UPD_UID(String UFR_UPD_UID) {
		this.UFR_UPD_UID = UFR_UPD_UID;
	}

	public String getUFR_UPD_UID() {
		return UFR_UPD_UID;
	}

	public void setUFR_NO_OF_UNITS(Double UFR_NO_OF_UNITS) {
		this.UFR_NO_OF_UNITS = UFR_NO_OF_UNITS;
	}

	public Double getUFR_NO_OF_UNITS() {
		return UFR_NO_OF_UNITS;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUFR_UPD_TRAN(String UFR_UPD_TRAN) {
		this.UFR_UPD_TRAN = UFR_UPD_TRAN;
	}

	public String getUFR_UPD_TRAN() {
		return UFR_UPD_TRAN;
	}

	public void setUFR_POL_NO(String UFR_POL_NO) {
		this.UFR_POL_NO = UFR_POL_NO;
	}

	public String getUFR_POL_NO() {
		return UFR_POL_NO;
	}

	public void setUFR_POL_SYS_ID(Long UFR_POL_SYS_ID) {
		this.UFR_POL_SYS_ID = UFR_POL_SYS_ID;
	}

	public Long getUFR_POL_SYS_ID() {
		return UFR_POL_SYS_ID;
	}

	public Double getUNIT_PRICE() {
	    return UNIT_PRICE;
	}

	public void setUNIT_PRICE(Double unit_price) {
	    UNIT_PRICE = unit_price;
	}

	public Double getUNIT_VALUE() {
	    return UNIT_VALUE;
	}

	public void setUNIT_VALUE(Double unit_value) {
	    UNIT_VALUE = unit_value;
	}

}
