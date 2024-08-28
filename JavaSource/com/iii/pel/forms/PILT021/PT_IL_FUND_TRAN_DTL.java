package com.iii.pel.forms.PILT021;

import java.text.DecimalFormat;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FUND_TRAN_DTL")
public class PT_IL_FUND_TRAN_DTL extends BaseValueBean {

	@Column(name="FTD_SYS_ID")
	private Long FTD_SYS_ID;

	@Column(name="FTD_TRAN_SYS_ID")
	private Long FTD_TRAN_SYS_ID;

	@Column(name="FTD_POL_SYS_ID")
	private Long FTD_POL_SYS_ID;

	@Column(name="FTD_TRAN_TYPE")
	private String FTD_TRAN_TYPE;

	@Column(name="FTD_TRAN_FLAG")
	private String FTD_TRAN_FLAG;

	@Column(name="FTD_FUND_CODE")
	private String FTD_FUND_CODE;

	@Column(name="FTD_FUND_PERC")
	private Double FTD_FUND_PERC;

	@Column(name="FTD_NO_OF_UNITS")
	private Double FTD_NO_OF_UNITS;

	@Column(name="FTD_UNIT_PUR_PRICE")
	private Double FTD_UNIT_PUR_PRICE;

	@Column(name="FTD_UNIT_SEL_PRICE")
	private Double FTD_UNIT_SEL_PRICE;

	@Column(name="FTD_UNIT_LC_AMT")
	private Double FTD_UNIT_LC_AMT;

	@Column(name="FTD_SELECT_YN")
	private String FTD_SELECT_YN;

	@Column(name="FTD_NO_SEL_UNITS")
	private Double FTD_NO_SEL_UNITS;

	@Column(name="FTD_NO_ALLOC_LC_AMT")
	private Double FTD_NO_ALLOC_LC_AMT;

	@Column(name="FTD_CR_UID")
	private String FTD_CR_UID;

	@Column(name="FTD_CR_DT")
	private Date FTD_CR_DT;

	@Column(name="FTD_UPD_UID")
	private String FTD_UPD_UID;

	@Column(name="FTD_UPD_DT")
	private Date FTD_UPD_DT;

	@Column(name="FTD_TOP_UP_UNITS")
	private Double FTD_TOP_UP_UNITS;

	@Column(name="FTD_PREM_UNITS")
	private Double FTD_PREM_UNITS;

	@Column(name="FTD_TOP_UP_SEL_UNITS")
	private Double FTD_TOP_UP_SEL_UNITS;

	@Column(name="FTD_PREM_SEL_UNITS")
	private Double FTD_PREM_SEL_UNITS;

	@Column(name="FTD_UNIT_TYPE")
	private String FTD_UNIT_TYPE;

	@Column(name="FTD_BEF_SWT_PERC")
	private Double FTD_BEF_SWT_PERC;

	@Column(name="FTD_WITHDRAWAL_BY")
	private String FTD_WITHDRAWAL_BY;
	
	
	private Double UI_M_FTD_NO_SEL_UNITS;
	private Double UI_M_FTD_NO_OF_UNITS;
	private String UI_M_FTD_FUND_DESC;
	public void setFTD_NO_OF_UNITS(Double FTD_NO_OF_UNITS) {
		this.FTD_NO_OF_UNITS = FTD_NO_OF_UNITS;
	}
	public Double getFTD_NO_OF_UNITS() {
		 return FTD_NO_OF_UNITS;
	}
	public void setFTD_NO_SEL_UNITS(Double FTD_NO_SEL_UNITS) {
		this.FTD_NO_SEL_UNITS = FTD_NO_SEL_UNITS;
	}
	public Double getFTD_NO_SEL_UNITS() {
		 return FTD_NO_SEL_UNITS;
	}
	public void setFTD_UNIT_PUR_PRICE(Double FTD_UNIT_PUR_PRICE) {
		this.FTD_UNIT_PUR_PRICE = FTD_UNIT_PUR_PRICE;
	}
	public Double getFTD_UNIT_PUR_PRICE() {
		 return FTD_UNIT_PUR_PRICE;
	}
	public void setFTD_CR_DT(Date FTD_CR_DT) {
		this.FTD_CR_DT = FTD_CR_DT;
	}
	public Date getFTD_CR_DT() {
		 return FTD_CR_DT;
	}
	public void setFTD_TOP_UP_SEL_UNITS(Double FTD_TOP_UP_SEL_UNITS) {
		this.FTD_TOP_UP_SEL_UNITS = FTD_TOP_UP_SEL_UNITS;
	}
	public Double getFTD_TOP_UP_SEL_UNITS() {
		 return FTD_TOP_UP_SEL_UNITS;
	}
	public void setFTD_TOP_UP_UNITS(Double FTD_TOP_UP_UNITS) {
		this.FTD_TOP_UP_UNITS = FTD_TOP_UP_UNITS;
	}
	public Double getFTD_TOP_UP_UNITS() {
		 return FTD_TOP_UP_UNITS;
	}
	public void setFTD_PREM_UNITS(Double FTD_PREM_UNITS) {
		this.FTD_PREM_UNITS = FTD_PREM_UNITS;
	}
	public Double getFTD_PREM_UNITS() {
		 return FTD_PREM_UNITS;
	}
	public void setFTD_CR_UID(String FTD_CR_UID) {
		this.FTD_CR_UID = FTD_CR_UID;
	}
	public String getFTD_CR_UID() {
		 return FTD_CR_UID;
	}
	public void setFTD_NO_ALLOC_LC_AMT(Double FTD_NO_ALLOC_LC_AMT) {
		this.FTD_NO_ALLOC_LC_AMT = FTD_NO_ALLOC_LC_AMT;
	}
	public Double getFTD_NO_ALLOC_LC_AMT() {
		 return FTD_NO_ALLOC_LC_AMT;
	}
	public void setFTD_UPD_UID(String FTD_UPD_UID) {
		this.FTD_UPD_UID = FTD_UPD_UID;
	}
	public String getFTD_UPD_UID() {
		 return FTD_UPD_UID;
	}
	public void setFTD_TRAN_TYPE(String FTD_TRAN_TYPE) {
		this.FTD_TRAN_TYPE = FTD_TRAN_TYPE;
	}
	public String getFTD_TRAN_TYPE() {
		 return FTD_TRAN_TYPE;
	}
	public void setUI_M_FTD_FUND_DESC(String UI_M_FTD_FUND_DESC) {
		this.UI_M_FTD_FUND_DESC = UI_M_FTD_FUND_DESC;
	}
	public String getUI_M_FTD_FUND_DESC() {
		 return UI_M_FTD_FUND_DESC;
	}
	public void setFTD_SELECT_YN(String FTD_SELECT_YN) {
		this.FTD_SELECT_YN = FTD_SELECT_YN;
	}
	public String getFTD_SELECT_YN() {
		 return FTD_SELECT_YN;
	}
	public void setFTD_TRAN_FLAG(String FTD_TRAN_FLAG) {
		this.FTD_TRAN_FLAG = FTD_TRAN_FLAG;
	}
	public String getFTD_TRAN_FLAG() {
		 return FTD_TRAN_FLAG;
	}
	public void setFTD_UPD_DT(Date FTD_UPD_DT) {
		this.FTD_UPD_DT = FTD_UPD_DT;
	}
	public Date getFTD_UPD_DT() {
		 return FTD_UPD_DT;
	}
	public void setFTD_TRAN_SYS_ID(Long FTD_TRAN_SYS_ID) {
		this.FTD_TRAN_SYS_ID = FTD_TRAN_SYS_ID;
	}
	public Long getFTD_TRAN_SYS_ID() {
		 return FTD_TRAN_SYS_ID;
	}
	public void setFTD_FUND_PERC(Double FTD_FUND_PERC) {
		Double value = null;
		DecimalFormat df = new DecimalFormat("#.##");
		if(FTD_FUND_PERC != null){
		  value = Double.valueOf(df.format(FTD_FUND_PERC));
		}else{
			value = FTD_FUND_PERC;
		}
		this.FTD_FUND_PERC = value;
	}
	public Double getFTD_FUND_PERC() {
		 return FTD_FUND_PERC;
	}
	public void setFTD_PREM_SEL_UNITS(Double FTD_PREM_SEL_UNITS) {
		this.FTD_PREM_SEL_UNITS = FTD_PREM_SEL_UNITS;
	}
	public Double getFTD_PREM_SEL_UNITS() {
		 return FTD_PREM_SEL_UNITS;
	}
	public void setFTD_SYS_ID(Long FTD_SYS_ID) {
		this.FTD_SYS_ID = FTD_SYS_ID;
	}
	public Long getFTD_SYS_ID() {
		 return FTD_SYS_ID;
	}
	public void setFTD_UNIT_TYPE(String FTD_UNIT_TYPE) {
		this.FTD_UNIT_TYPE = FTD_UNIT_TYPE;
	}
	public String getFTD_UNIT_TYPE() {
		 return FTD_UNIT_TYPE;
	}
	public void setFTD_FUND_CODE(String FTD_FUND_CODE) {
		this.FTD_FUND_CODE = FTD_FUND_CODE;
	}
	public String getFTD_FUND_CODE() {
		 return FTD_FUND_CODE;
	}
	public void setFTD_UNIT_SEL_PRICE(Double FTD_UNIT_SEL_PRICE) {
		this.FTD_UNIT_SEL_PRICE = FTD_UNIT_SEL_PRICE;
	}
	public Double getFTD_UNIT_SEL_PRICE() {
		 return FTD_UNIT_SEL_PRICE;
	}
	public void setFTD_BEF_SWT_PERC(Double FTD_BEF_SWT_PERC) {
		this.FTD_BEF_SWT_PERC = FTD_BEF_SWT_PERC;
	}
	public Double getFTD_BEF_SWT_PERC() {
		 return FTD_BEF_SWT_PERC;
	}
	public void setFTD_WITHDRAWAL_BY(String FTD_WITHDRAWAL_BY) {
		this.FTD_WITHDRAWAL_BY = FTD_WITHDRAWAL_BY;
	}
	public String getFTD_WITHDRAWAL_BY() {
		 return FTD_WITHDRAWAL_BY;
	}
	public void setFTD_POL_SYS_ID(Long FTD_POL_SYS_ID) {
		this.FTD_POL_SYS_ID = FTD_POL_SYS_ID;
	}
	public Long getFTD_POL_SYS_ID() {
		 return FTD_POL_SYS_ID;
	}
	public void setFTD_UNIT_LC_AMT(Double FTD_UNIT_LC_AMT) {
		this.FTD_UNIT_LC_AMT = FTD_UNIT_LC_AMT;
	}
	public Double getFTD_UNIT_LC_AMT() {
		 return FTD_UNIT_LC_AMT;
	}
	public Double getUI_M_FTD_NO_SEL_UNITS() {
		return UI_M_FTD_NO_SEL_UNITS;
	}
	public void setUI_M_FTD_NO_SEL_UNITS(Double ui_m_ftd_no_sel_units) {
		UI_M_FTD_NO_SEL_UNITS = ui_m_ftd_no_sel_units;
	}
	public Double getUI_M_FTD_NO_OF_UNITS() {
		return UI_M_FTD_NO_OF_UNITS;
	}
	public void setUI_M_FTD_NO_OF_UNITS(Double ui_m_ftd_no_of_units) {
		UI_M_FTD_NO_OF_UNITS = ui_m_ftd_no_of_units;
	}

}
