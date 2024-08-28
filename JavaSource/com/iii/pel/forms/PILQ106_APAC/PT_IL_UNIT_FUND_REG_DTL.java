package com.iii.pel.forms.PILQ106_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_UNIT_FUND_REG_DTL")
public class PT_IL_UNIT_FUND_REG_DTL extends BaseValueBean {

	@Column(name = "UFRD_SYS_ID")
	private Long UFRD_SYS_ID;

	@Column(name = "UFRD_UFRH_SYS_ID")
	private Long UFRD_UFRH_SYS_ID;

	@Column(name = "UFRD_FUND_CODE")
	private String UFRD_FUND_CODE;

	@Column(name = "UFRD_FUND_PERC")
	private Double UFRD_FUND_PERC;

	@Column(name = "UFRD_NO_OF_UNITS")
	private Double UFRD_NO_OF_UNITS;

	@Column(name = "UFRD_UNIT_PUR_LC_AMT")
	private Double UFRD_UNIT_PUR_LC_AMT;

	@Column(name = "UFRD_UNIT_SEL_LC_AMT")
	private Double UFRD_UNIT_SEL_LC_AMT;

	@Column(name = "UFRD_UNIT_TOT_LC_VALUE")
	private Double UFRD_UNIT_TOT_LC_VALUE;

	@Column(name = "UFRD_CR_UID")
	private String UFRD_CR_UID;

	@Column(name = "UFRD_CR_DT")
	private Date UFRD_CR_DT;

	@Column(name = "UFRD_UPD_UID")
	private String UFRD_UPD_UID;

	@Column(name = "UFRD_UPD_DT")
	private Date UFRD_UPD_DT;

	@Column(name = "UFRD_UNIT_DATE")
	private Date UFRD_UNIT_DATE;

	@Column(name = "UFRD_TOP_UP_UNITS")
	private Double UFRD_TOP_UP_UNITS;

	@Column(name = "UFRD_PREM_UNITS")
	private Double UFRD_PREM_UNITS;

	@Column(name = "UFRD_START_UNITS")
	private Double UFRD_START_UNITS;

	@Column(name = "UFRD_START_UNIT_VALUE")
	private Double UFRD_START_UNIT_VALUE;

	private Double UI_M_END_UNIT;
	private Double UI_M_END_UNIT_VALUE;
	private Double UI_M_UNIT_PRICE;
	private String UFRD_FUND_DESC;
	private String M_WHERE;

	public void setUFRD_UPD_DT(Date UFRD_UPD_DT) {
		this.UFRD_UPD_DT = UFRD_UPD_DT;
	}

	public Date getUFRD_UPD_DT() {
		return UFRD_UPD_DT;
	}

	public void setUFRD_UNIT_SEL_LC_AMT(Double UFRD_UNIT_SEL_LC_AMT) {
		this.UFRD_UNIT_SEL_LC_AMT = UFRD_UNIT_SEL_LC_AMT;
	}

	public Double getUFRD_UNIT_SEL_LC_AMT() {
		return UFRD_UNIT_SEL_LC_AMT;
	}

	public void setUFRD_UFRH_SYS_ID(Long UFRD_UFRH_SYS_ID) {
		this.UFRD_UFRH_SYS_ID = UFRD_UFRH_SYS_ID;
	}

	public Long getUFRD_UFRH_SYS_ID() {
		return UFRD_UFRH_SYS_ID;
	}

	public void setUFRD_START_UNIT_VALUE(Double UFRD_START_UNIT_VALUE) {
		this.UFRD_START_UNIT_VALUE = UFRD_START_UNIT_VALUE;
	}

	public Double getUFRD_START_UNIT_VALUE() {
		return UFRD_START_UNIT_VALUE;
	}

	public void setUFRD_FUND_PERC(Double UFRD_FUND_PERC) {
		this.UFRD_FUND_PERC = UFRD_FUND_PERC;
	}

	public Double getUFRD_FUND_PERC() {
		return UFRD_FUND_PERC;
	}

	public void setUFRD_NO_OF_UNITS(Double UFRD_NO_OF_UNITS) {
		this.UFRD_NO_OF_UNITS = UFRD_NO_OF_UNITS;
	}

	public Double getUFRD_NO_OF_UNITS() {
		return UFRD_NO_OF_UNITS;
	}

	public void setUFRD_UNIT_DATE(Date UFRD_UNIT_DATE) {
		this.UFRD_UNIT_DATE = UFRD_UNIT_DATE;
	}

	public Date getUFRD_UNIT_DATE() {
		return UFRD_UNIT_DATE;
	}

	public void setUFRD_CR_UID(String UFRD_CR_UID) {
		this.UFRD_CR_UID = UFRD_CR_UID;
	}

	public String getUFRD_CR_UID() {
		return UFRD_CR_UID;
	}

	public void setUFRD_UNIT_TOT_LC_VALUE(Double UFRD_UNIT_TOT_LC_VALUE) {
		this.UFRD_UNIT_TOT_LC_VALUE = UFRD_UNIT_TOT_LC_VALUE;
	}

	public Double getUFRD_UNIT_TOT_LC_VALUE() {
		return UFRD_UNIT_TOT_LC_VALUE;
	}

	public void setUFRD_FUND_CODE(String UFRD_FUND_CODE) {
		this.UFRD_FUND_CODE = UFRD_FUND_CODE;
	}

	public String getUFRD_FUND_CODE() {
		return UFRD_FUND_CODE;
	}

	public void setUI_M_UNIT_PRICE(Double UI_M_UNIT_PRICE) {
		this.UI_M_UNIT_PRICE = UI_M_UNIT_PRICE;
	}

	public Double getUI_M_UNIT_PRICE() {
		return UI_M_UNIT_PRICE;
	}

	public void setUFRD_UNIT_PUR_LC_AMT(Double UFRD_UNIT_PUR_LC_AMT) {
		this.UFRD_UNIT_PUR_LC_AMT = UFRD_UNIT_PUR_LC_AMT;
	}

	public Double getUFRD_UNIT_PUR_LC_AMT() {
		return UFRD_UNIT_PUR_LC_AMT;
	}

	public void setUFRD_TOP_UP_UNITS(Double UFRD_TOP_UP_UNITS) {
		this.UFRD_TOP_UP_UNITS = UFRD_TOP_UP_UNITS;
	}

	public Double getUFRD_TOP_UP_UNITS() {
		return UFRD_TOP_UP_UNITS;
	}

	public void setUFRD_CR_DT(Date UFRD_CR_DT) {
		this.UFRD_CR_DT = UFRD_CR_DT;
	}

	public Date getUFRD_CR_DT() {
		return UFRD_CR_DT;
	}

	public void setUI_M_END_UNIT(Double UI_M_END_UNIT) {
		this.UI_M_END_UNIT = UI_M_END_UNIT;
	}

	public Double getUI_M_END_UNIT() {
		return UI_M_END_UNIT;
	}

	public void setUI_M_END_UNIT_VALUE(Double UI_M_END_UNIT_VALUE) {
		this.UI_M_END_UNIT_VALUE = UI_M_END_UNIT_VALUE;
	}

	public Double getUI_M_END_UNIT_VALUE() {
		return UI_M_END_UNIT_VALUE;
	}

	public void setUFRD_SYS_ID(Long UFRD_SYS_ID) {
		this.UFRD_SYS_ID = UFRD_SYS_ID;
	}

	public Long getUFRD_SYS_ID() {
		return UFRD_SYS_ID;
	}

	public void setUFRD_PREM_UNITS(Double UFRD_PREM_UNITS) {
		this.UFRD_PREM_UNITS = UFRD_PREM_UNITS;
	}

	public Double getUFRD_PREM_UNITS() {
		return UFRD_PREM_UNITS;
	}

	public void setUFRD_START_UNITS(Double UFRD_START_UNITS) {
		this.UFRD_START_UNITS = UFRD_START_UNITS;
	}

	public Double getUFRD_START_UNITS() {
		return UFRD_START_UNITS;
	}

	public void setUFRD_UPD_UID(String UFRD_UPD_UID) {
		this.UFRD_UPD_UID = UFRD_UPD_UID;
	}

	public String getUFRD_UPD_UID() {
		return UFRD_UPD_UID;
	}

	public String getUFRD_FUND_DESC() {
	    return UFRD_FUND_DESC;
	}

	public void setUFRD_FUND_DESC(String ufrd_fund_desc) {
	    UFRD_FUND_DESC = ufrd_fund_desc;
	}

	public String getM_WHERE() {
	    return M_WHERE;
	}

	public void setM_WHERE(String m_where) {
	    M_WHERE = m_where;
	}
	
	
	/*ADDED  BY AMEEN ON 19-06-2017 FOR ZBILQC-1727874*/
	private String UI_M_UFRD_UNIT_DATE;

	public String getUI_M_UFRD_UNIT_DATE() {
		return UI_M_UFRD_UNIT_DATE;
	}

	public void setUI_M_UFRD_UNIT_DATE(String uI_M_UFRD_UNIT_DATE) {
		UI_M_UFRD_UNIT_DATE = uI_M_UFRD_UNIT_DATE;
	}
	/*END*/
}
