package com.iii.pel.forms.PILT021;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_WITHDRAWAL_UNIT")
public class PT_IL_WITHDRAWAL_UNIT extends BaseValueBean {

	@Column(name="WDU_SYS_ID")
	private Long WDU_SYS_ID;

	@Column(name="WDU_WD_SYS_ID")
	private Long WDU_WD_SYS_ID;

	@Column(name="WDU_POL_SYS_ID")
	private Long WDU_POL_SYS_ID;

	@Column(name="WDU_COVER_CODE")
	private String WDU_COVER_CODE;

	@Column(name="WDU_TYPE")
	private String WDU_TYPE;

	@Column(name="WDU_APPRV_STATUS")
	private String WDU_APPRV_STATUS;

	@Column(name="WDU_AVBL_UNIT")
	private Double WDU_AVBL_UNIT;

	@Column(name="WDU_WD_UNIT")
	private Double WDU_WD_UNIT;

	@Column(name="WDU_AVBL_FC_AMT")
	private Double WDU_AVBL_FC_AMT;

	@Column(name="WDU_AVBL_LC_AMT")
	private Double WDU_AVBL_LC_AMT;

	@Column(name="WDU_WD_FC_AMT")
	private Double WDU_WD_FC_AMT;

	@Column(name="WDU_WD_LC_AMT")
	private Double WDU_WD_LC_AMT;

	@Column(name="WDU_CR_UID")
	private String WDU_CR_UID;

	@Column(name="WDU_CR_DT")
	private Date WDU_CR_DT;

	@Column(name="WDU_UPD_UID")
	private String WDU_UPD_UID;

	@Column(name="WDU_UPD_DT")
	private Date WDU_UPD_DT;

	private String UI_M_WDU_POL_NO;
	public void setWDU_AVBL_FC_AMT(Double WDU_AVBL_FC_AMT) {
		this.WDU_AVBL_FC_AMT = WDU_AVBL_FC_AMT;
	}
	public Double getWDU_AVBL_FC_AMT() {
		 return WDU_AVBL_FC_AMT;
	}
	public void setWDU_SYS_ID(Long WDU_SYS_ID) {
		this.WDU_SYS_ID = WDU_SYS_ID;
	}
	public Long getWDU_SYS_ID() {
		 return WDU_SYS_ID;
	}
	public void setWDU_WD_LC_AMT(Double WDU_WD_LC_AMT) {
		this.WDU_WD_LC_AMT = WDU_WD_LC_AMT;
	}
	public Double getWDU_WD_LC_AMT() {
		 return WDU_WD_LC_AMT;
	}
	public void setWDU_CR_DT(Date WDU_CR_DT) {
		this.WDU_CR_DT = WDU_CR_DT;
	}
	public Date getWDU_CR_DT() {
		 return WDU_CR_DT;
	}
	public void setUI_M_WDU_POL_NO(String UI_M_WDU_POL_NO) {
		this.UI_M_WDU_POL_NO = UI_M_WDU_POL_NO;
	}
	public String getUI_M_WDU_POL_NO() {
		 return UI_M_WDU_POL_NO;
	}
	public void setWDU_WD_UNIT(Double WDU_WD_UNIT) {
		this.WDU_WD_UNIT = WDU_WD_UNIT;
	}
	public Double getWDU_WD_UNIT() {
		 return WDU_WD_UNIT;
	}
	public void setWDU_POL_SYS_ID(Long WDU_POL_SYS_ID) {
		this.WDU_POL_SYS_ID = WDU_POL_SYS_ID;
	}
	public Long getWDU_POL_SYS_ID() {
		 return WDU_POL_SYS_ID;
	}
	public void setWDU_WD_SYS_ID(Long WDU_WD_SYS_ID) {
		this.WDU_WD_SYS_ID = WDU_WD_SYS_ID;
	}
	public Long getWDU_WD_SYS_ID() {
		 return WDU_WD_SYS_ID;
	}
	public void setWDU_APPRV_STATUS(String WDU_APPRV_STATUS) {
		this.WDU_APPRV_STATUS = WDU_APPRV_STATUS;
	}
	public String getWDU_APPRV_STATUS() {
		 return WDU_APPRV_STATUS;
	}
	public void setWDU_UPD_DT(Date WDU_UPD_DT) {
		this.WDU_UPD_DT = WDU_UPD_DT;
	}
	public Date getWDU_UPD_DT() {
		 return WDU_UPD_DT;
	}
	public void setWDU_WD_FC_AMT(Double WDU_WD_FC_AMT) {
		this.WDU_WD_FC_AMT = WDU_WD_FC_AMT;
	}
	public Double getWDU_WD_FC_AMT() {
		 return WDU_WD_FC_AMT;
	}
	public void setWDU_COVER_CODE(String WDU_COVER_CODE) {
		this.WDU_COVER_CODE = WDU_COVER_CODE;
	}
	public String getWDU_COVER_CODE() {
		 return WDU_COVER_CODE;
	}
	public void setWDU_AVBL_UNIT(Double WDU_AVBL_UNIT) {
		this.WDU_AVBL_UNIT = WDU_AVBL_UNIT;
	}
	public Double getWDU_AVBL_UNIT() {
		 return WDU_AVBL_UNIT;
	}
	public void setWDU_UPD_UID(String WDU_UPD_UID) {
		this.WDU_UPD_UID = WDU_UPD_UID;
	}
	public String getWDU_UPD_UID() {
		 return WDU_UPD_UID;
	}
	public void setWDU_AVBL_LC_AMT(Double WDU_AVBL_LC_AMT) {
		this.WDU_AVBL_LC_AMT = WDU_AVBL_LC_AMT;
	}
	public Double getWDU_AVBL_LC_AMT() {
		 return WDU_AVBL_LC_AMT;
	}
	public void setWDU_TYPE(String WDU_TYPE) {
		this.WDU_TYPE = WDU_TYPE;
	}
	public String getWDU_TYPE() {
		 return WDU_TYPE;
	}
	public void setWDU_CR_UID(String WDU_CR_UID) {
		this.WDU_CR_UID = WDU_CR_UID;
	}
	public String getWDU_CR_UID() {
		 return WDU_CR_UID;
	}

}
