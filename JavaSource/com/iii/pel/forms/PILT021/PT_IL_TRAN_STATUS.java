package com.iii.pel.forms.PILT021;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_TRAN_STATUS")
public class PT_IL_TRAN_STATUS extends BaseValueBean {

	@Column(name="TS_POL_SYS_ID")
	private Long TS_POL_SYS_ID;

	@Column(name="TS_TRAN_SYS_ID")
	private Long TS_TRAN_SYS_ID;

	@Column(name="TS_TRAN_TYPE")
	private String TS_TRAN_TYPE;

	@Column(name="TS_END_NO_IDX")
	private Double TS_END_NO_IDX;

	@Column(name="TS_STATUS_DT")
	private Date TS_STATUS_DT;

	@Column(name="TS_STATUS_CODE")
	private String TS_STATUS_CODE;

	@Column(name="TS_REASON_CODE")
	private String TS_REASON_CODE;

	@Column(name="TS_REMARKS")
	private String TS_REMARKS;

	@Column(name="TS_STATUS_UID")
	private String TS_STATUS_UID;

	@Column(name="TS_STATUS_TYPE")
	private String TS_STATUS_TYPE;

	@Column(name="TS_CR_UID")
	private String TS_CR_UID;

	@Column(name="TS_CR_DT")
	private Date TS_CR_DT;

	private Date UI_M_WD_STATUS_DT;
	private String UI_M_WD_STATUS_CODE;
	private String UI_M_WD_STATUS_CODE_DESC;
	private String UI_M_WD_REASON_CODE;
	private String UI_M_WD_REASON_CODE_DESC;
	private String UI_M_WD_REMARKS;
	private String UI_M_TS_REASON_CODE_DESC;
	public void setTS_POL_SYS_ID(Long TS_POL_SYS_ID) {
		this.TS_POL_SYS_ID = TS_POL_SYS_ID;
	}
	public Long getTS_POL_SYS_ID() {
		 return TS_POL_SYS_ID;
	}
	public void setTS_REASON_CODE(String TS_REASON_CODE) {
		this.TS_REASON_CODE = TS_REASON_CODE;
	}
	public String getTS_REASON_CODE() {
		 return TS_REASON_CODE;
	}
	public void setUI_M_WD_STATUS_CODE_DESC(String UI_M_WD_STATUS_CODE_DESC) {
		this.UI_M_WD_STATUS_CODE_DESC = UI_M_WD_STATUS_CODE_DESC;
	}
	public String getUI_M_WD_STATUS_CODE_DESC() {
		 return UI_M_WD_STATUS_CODE_DESC;
	}
	public void setTS_END_NO_IDX(Double TS_END_NO_IDX) {
		this.TS_END_NO_IDX = TS_END_NO_IDX;
	}
	public Double getTS_END_NO_IDX() {
		 return TS_END_NO_IDX;
	}
	public void setUI_M_WD_STATUS_DT(Date UI_M_WD_STATUS_DT) {
		this.UI_M_WD_STATUS_DT = UI_M_WD_STATUS_DT;
	}
	public Date getUI_M_WD_STATUS_DT() {
		 return UI_M_WD_STATUS_DT;
	}
	public void setTS_STATUS_CODE(String TS_STATUS_CODE) {
		this.TS_STATUS_CODE = TS_STATUS_CODE;
	}
	public String getTS_STATUS_CODE() {
		 return TS_STATUS_CODE;
	}
	public void setTS_CR_DT(Date TS_CR_DT) {
		this.TS_CR_DT = TS_CR_DT;
	}
	public Date getTS_CR_DT() {
		 return TS_CR_DT;
	}
	public void setTS_TRAN_SYS_ID(Long TS_TRAN_SYS_ID) {
		this.TS_TRAN_SYS_ID = TS_TRAN_SYS_ID;
	}
	public Long getTS_TRAN_SYS_ID() {
		 return TS_TRAN_SYS_ID;
	}
	public void setTS_STATUS_DT(Date TS_STATUS_DT) {
		this.TS_STATUS_DT = TS_STATUS_DT;
	}
	public Date getTS_STATUS_DT() {
		 return TS_STATUS_DT;
	}
	public void setUI_M_WD_STATUS_CODE(String UI_M_WD_STATUS_CODE) {
		this.UI_M_WD_STATUS_CODE = UI_M_WD_STATUS_CODE;
	}
	public String getUI_M_WD_STATUS_CODE() {
		 return UI_M_WD_STATUS_CODE;
	}
	public void setTS_REMARKS(String TS_REMARKS) {
		this.TS_REMARKS = TS_REMARKS;
	}
	public String getTS_REMARKS() {
		 return TS_REMARKS;
	}
	public void setTS_STATUS_TYPE(String TS_STATUS_TYPE) {
		this.TS_STATUS_TYPE = TS_STATUS_TYPE;
	}
	public String getTS_STATUS_TYPE() {
		 return TS_STATUS_TYPE;
	}
	public void setUI_M_TS_REASON_CODE_DESC(String UI_M_TS_REASON_CODE_DESC) {
		this.UI_M_TS_REASON_CODE_DESC = UI_M_TS_REASON_CODE_DESC;
	}
	public String getUI_M_TS_REASON_CODE_DESC() {
		 return UI_M_TS_REASON_CODE_DESC;
	}
	public void setUI_M_WD_REASON_CODE(String UI_M_WD_REASON_CODE) {
		this.UI_M_WD_REASON_CODE = UI_M_WD_REASON_CODE;
	}
	public String getUI_M_WD_REASON_CODE() {
		 return UI_M_WD_REASON_CODE;
	}
	public void setUI_M_WD_REASON_CODE_DESC(String UI_M_WD_REASON_CODE_DESC) {
		this.UI_M_WD_REASON_CODE_DESC = UI_M_WD_REASON_CODE_DESC;
	}
	public String getUI_M_WD_REASON_CODE_DESC() {
		 return UI_M_WD_REASON_CODE_DESC;
	}
	public void setTS_STATUS_UID(String TS_STATUS_UID) {
		this.TS_STATUS_UID = TS_STATUS_UID;
	}
	public String getTS_STATUS_UID() {
		 return TS_STATUS_UID;
	}
	public void setUI_M_WD_REMARKS(String UI_M_WD_REMARKS) {
		this.UI_M_WD_REMARKS = UI_M_WD_REMARKS;
	}
	public String getUI_M_WD_REMARKS() {
		 return UI_M_WD_REMARKS;
	}
	public void setTS_CR_UID(String TS_CR_UID) {
		this.TS_CR_UID = TS_CR_UID;
	}
	public String getTS_CR_UID() {
		 return TS_CR_UID;
	}
	public void setTS_TRAN_TYPE(String TS_TRAN_TYPE) {
		this.TS_TRAN_TYPE = TS_TRAN_TYPE;
	}
	public String getTS_TRAN_TYPE() {
		 return TS_TRAN_TYPE;
	}

}
