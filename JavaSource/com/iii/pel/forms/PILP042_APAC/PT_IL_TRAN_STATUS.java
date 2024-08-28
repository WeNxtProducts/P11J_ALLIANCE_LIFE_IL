package com.iii.pel.forms.PILP042_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_TRAN_STATUS")
public class PT_IL_TRAN_STATUS extends BaseValueBean {

	private Date UI_M_WD_STATUS_DT;

	private String UI_M_WD_STATUS_CODE;

	private String UI_M_WD_STATUS_CODE_DESC;

	private String UI_M_WD_REASON_CODE;

	private String UI_M_WD_REASON_CODE_DESC;

	private String UI_M_WD_REMARKS;

	@Column(name = "TS_STATUS_DT")
	private Date TS_STATUS_DT;

	@Column(name = "TS_STATUS_CODE")
	private String TS_STATUS_CODE;

	private String UI_M_STATUS_CODE_DESC;

	@Column(name = "TS_REASON_CODE")
	private String TS_REASON_CODE;

	private String UI_M_REASON_CODE_DESC;

	@Column(name = "TS_STATUS_UID")
	private String TS_STATUS_UID;

	@Column(name = "TS_REMARKS")
	private String TS_REMARKS;

	public PT_IL_TRAN_STATUS() {
		UI_M_WD_STATUS_DT = new Date();
	}

	public Date getUI_M_WD_STATUS_DT() {
		return UI_M_WD_STATUS_DT;
	}

	public void setUI_M_WD_STATUS_DT(Date UI_M_WD_STATUS_DT) {
		this.UI_M_WD_STATUS_DT = UI_M_WD_STATUS_DT;
	}

	public String getUI_M_WD_STATUS_CODE() {
		return UI_M_WD_STATUS_CODE;
	}

	public void setUI_M_WD_STATUS_CODE(String UI_M_WD_STATUS_CODE) {
		this.UI_M_WD_STATUS_CODE = UI_M_WD_STATUS_CODE;
	}

	public String getUI_M_WD_STATUS_CODE_DESC() {
		return UI_M_WD_STATUS_CODE_DESC;
	}

	public void setUI_M_WD_STATUS_CODE_DESC(String UI_M_WD_STATUS_CODE_DESC) {
		this.UI_M_WD_STATUS_CODE_DESC = UI_M_WD_STATUS_CODE_DESC;
	}

	public String getUI_M_WD_REASON_CODE() {
		return UI_M_WD_REASON_CODE;
	}

	public void setUI_M_WD_REASON_CODE(String UI_M_WD_REASON_CODE) {
		this.UI_M_WD_REASON_CODE = UI_M_WD_REASON_CODE;
	}

	public String getUI_M_WD_REASON_CODE_DESC() {
		return UI_M_WD_REASON_CODE_DESC;
	}

	public void setUI_M_WD_REASON_CODE_DESC(String UI_M_WD_REASON_CODE_DESC) {
		this.UI_M_WD_REASON_CODE_DESC = UI_M_WD_REASON_CODE_DESC;
	}

	public String getUI_M_WD_REMARKS() {
		return UI_M_WD_REMARKS;
	}

	public void setUI_M_WD_REMARKS(String UI_M_WD_REMARKS) {
		this.UI_M_WD_REMARKS = UI_M_WD_REMARKS;
	}

	public Date getTS_STATUS_DT() {
		return TS_STATUS_DT;
	}

	public void setTS_STATUS_DT(Date TS_STATUS_DT) {
		this.TS_STATUS_DT = TS_STATUS_DT;
	}

	public String getTS_STATUS_CODE() {
		return TS_STATUS_CODE;
	}

	public void setTS_STATUS_CODE(String TS_STATUS_CODE) {
		this.TS_STATUS_CODE = TS_STATUS_CODE;
	}

	public String getUI_M_STATUS_CODE_DESC() {
		return UI_M_STATUS_CODE_DESC;
	}

	public void setUI_M_STATUS_CODE_DESC(String UI_M_STATUS_CODE_DESC) {
		this.UI_M_STATUS_CODE_DESC = UI_M_STATUS_CODE_DESC;
	}

	public String getTS_REASON_CODE() {
		return TS_REASON_CODE;
	}

	public void setTS_REASON_CODE(String TS_REASON_CODE) {
		this.TS_REASON_CODE = TS_REASON_CODE;
	}

	public String getUI_M_REASON_CODE_DESC() {
		return UI_M_REASON_CODE_DESC;
	}

	public void setUI_M_REASON_CODE_DESC(String UI_M_REASON_CODE_DESC) {
		this.UI_M_REASON_CODE_DESC = UI_M_REASON_CODE_DESC;
	}

	public String getTS_STATUS_UID() {
		return TS_STATUS_UID;
	}

	public void setTS_STATUS_UID(String TS_STATUS_UID) {
		this.TS_STATUS_UID = TS_STATUS_UID;
	}

	public String getTS_REMARKS() {
		return TS_REMARKS;
	}

	public void setTS_REMARKS(String TS_REMARKS) {
		this.TS_REMARKS = TS_REMARKS;
	}
}
