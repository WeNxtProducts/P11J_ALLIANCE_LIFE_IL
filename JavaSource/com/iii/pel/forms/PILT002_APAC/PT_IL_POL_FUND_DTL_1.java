package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_FUND_DTL")
public class PT_IL_POL_FUND_DTL_1 extends BaseValueBean {

	@Column(name="POFD_POL_SYS_ID")
	private Long POFD_POL_SYS_ID;

	@Column(name="POFD_FUND_CODE")
	private String POFD_FUND_CODE;

	@Column(name="POFD_FUND_PERC")
	private Double POFD_FUND_PERC;

	@Column(name="POFD_CR_DT")
	private Date POFD_CR_DT;

	@Column(name="POFD_CR_UID")
	private String POFD_CR_UID;

	@Column(name="POFD_UPD_DT")
	private Date POFD_UPD_DT;

	@Column(name="POFD_UPD_UID")
	private String POFD_UPD_UID;

	@Column(name="POFD_SYS_ID")
	private Long POFD_SYS_ID;

	@Column(name="POFD_FUND_DIR_TYPE")
	private String POFD_FUND_DIR_TYPE;

	@Column(name="POFD_EFF_FM_DT")
	private Date POFD_EFF_FM_DT;

	@Column(name="POFD_EFF_TO_DT")
	private Date POFD_EFF_TO_DT;

	@Column(name="POFD_DEL_FLAG")
	private String POFD_DEL_FLAG;

	private String UI_M_FUND_DESC;
	public void setPOFD_FUND_DIR_TYPE(String POFD_FUND_DIR_TYPE) {
		this.POFD_FUND_DIR_TYPE = POFD_FUND_DIR_TYPE;
	}
	public String getPOFD_FUND_DIR_TYPE() {
		 return POFD_FUND_DIR_TYPE;
	}
	public void setPOFD_FUND_PERC(Double POFD_FUND_PERC) {
		this.POFD_FUND_PERC = POFD_FUND_PERC;
	}
	public Double getPOFD_FUND_PERC() {
		 return POFD_FUND_PERC;
	}
	public void setUI_M_FUND_DESC(String UI_M_FUND_DESC) {
		this.UI_M_FUND_DESC = UI_M_FUND_DESC;
	}
	public String getUI_M_FUND_DESC() {
		 return UI_M_FUND_DESC;
	}
	public void setPOFD_FUND_CODE(String POFD_FUND_CODE) {
		this.POFD_FUND_CODE = POFD_FUND_CODE;
	}
	public String getPOFD_FUND_CODE() {
		 return POFD_FUND_CODE;
	}
	public void setPOFD_UPD_DT(Date POFD_UPD_DT) {
		this.POFD_UPD_DT = POFD_UPD_DT;
	}
	public Date getPOFD_UPD_DT() {
		 return POFD_UPD_DT;
	}
	public void setPOFD_EFF_FM_DT(Date POFD_EFF_FM_DT) {
		this.POFD_EFF_FM_DT = POFD_EFF_FM_DT;
	}
	public Date getPOFD_EFF_FM_DT() {
		 return POFD_EFF_FM_DT;
	}
	public void setPOFD_EFF_TO_DT(Date POFD_EFF_TO_DT) {
		this.POFD_EFF_TO_DT = POFD_EFF_TO_DT;
	}
	public Date getPOFD_EFF_TO_DT() {
		 return POFD_EFF_TO_DT;
	}
	public void setPOFD_SYS_ID(Long POFD_SYS_ID) {
		this.POFD_SYS_ID = POFD_SYS_ID;
	}
	public Long getPOFD_SYS_ID() {
		 return POFD_SYS_ID;
	}
	public void setPOFD_CR_UID(String POFD_CR_UID) {
		this.POFD_CR_UID = POFD_CR_UID;
	}
	public String getPOFD_CR_UID() {
		 return POFD_CR_UID;
	}
	public void setPOFD_CR_DT(Date POFD_CR_DT) {
		this.POFD_CR_DT = POFD_CR_DT;
	}
	public Date getPOFD_CR_DT() {
		 return POFD_CR_DT;
	}
	public void setPOFD_DEL_FLAG(String POFD_DEL_FLAG) {
		this.POFD_DEL_FLAG = POFD_DEL_FLAG;
	}
	public String getPOFD_DEL_FLAG() {
		 return POFD_DEL_FLAG;
	}
	public void setPOFD_POL_SYS_ID(Long POFD_POL_SYS_ID) {
		this.POFD_POL_SYS_ID = POFD_POL_SYS_ID;
	}
	public Long getPOFD_POL_SYS_ID() {
		 return POFD_POL_SYS_ID;
	}
	public void setPOFD_UPD_UID(String POFD_UPD_UID) {
		this.POFD_UPD_UID = POFD_UPD_UID;
	}
	public String getPOFD_UPD_UID() {
		 return POFD_UPD_UID;
	}

}
