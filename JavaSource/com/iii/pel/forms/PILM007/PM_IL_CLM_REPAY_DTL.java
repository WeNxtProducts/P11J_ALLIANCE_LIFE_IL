package com.iii.pel.forms.PILM007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CLM_REPAY_DTL")
public class PM_IL_CLM_REPAY_DTL extends BaseValueBean {
	@Column(name="CRD_COVER_CODE")
	private String CRD_COVER_CODE;

	@Column(name="CRD_LOSS_TYPE")
	private String CRD_LOSS_TYPE;

	@Column(name="CRD_DISABLE_TYPE")
	private String CRD_DISABLE_TYPE;

	@Column(name="CRD_CR_COVER_CODE")
	private String CRD_CR_COVER_CODE;

	@Column(name="CRD_CR_LOSS_TYPE")
	private String CRD_CR_LOSS_TYPE;

	@Column(name="CRD_CR_DISABLE_TYPE")
	private String CRD_CR_DISABLE_TYPE;

	@Column(name="CRD_COVER_CR_DT")
	private Date CRD_COVER_CR_DT;

	@Column(name="CRD_COVER_CR_UID")
	private String CRD_COVER_CR_UID;

	@Column(name="CRD_COVER_UPD_DT")
	private Date CRD_COVER_UPD_DT;

	@Column(name="CRD_COVER_UPD_UID")
	private String CRD_COVER_UPD_UID;
	
	private String UI_M_COVER_DESC_1;
	private String UI_M_DISABLE_DESC_1;
	private String UI_M_LOSS_DESC_1;



	public String getCRD_COVER_CODE() {
		 return CRD_COVER_CODE;
	}

	public void setCRD_COVER_CODE(String CRD_COVER_CODE) {
		this.CRD_COVER_CODE = CRD_COVER_CODE;
	}

	public String getCRD_LOSS_TYPE() {
		 return CRD_LOSS_TYPE;
	}

	public void setCRD_LOSS_TYPE(String CRD_LOSS_TYPE) {
		this.CRD_LOSS_TYPE = CRD_LOSS_TYPE;
	}

	public String getCRD_DISABLE_TYPE() {
		 return CRD_DISABLE_TYPE;
	}

	public void setCRD_DISABLE_TYPE(String CRD_DISABLE_TYPE) {
		this.CRD_DISABLE_TYPE = CRD_DISABLE_TYPE;
	}

	public String getCRD_CR_COVER_CODE() {
		 return CRD_CR_COVER_CODE;
	}

	public void setCRD_CR_COVER_CODE(String CRD_CR_COVER_CODE) {
		this.CRD_CR_COVER_CODE = CRD_CR_COVER_CODE;
	}

	public String getCRD_CR_LOSS_TYPE() {
		 return CRD_CR_LOSS_TYPE;
	}

	public void setCRD_CR_LOSS_TYPE(String CRD_CR_LOSS_TYPE) {
		this.CRD_CR_LOSS_TYPE = CRD_CR_LOSS_TYPE;
	}

	public String getCRD_CR_DISABLE_TYPE() {
		 return CRD_CR_DISABLE_TYPE;
	}

	public void setCRD_CR_DISABLE_TYPE(String CRD_CR_DISABLE_TYPE) {
		this.CRD_CR_DISABLE_TYPE = CRD_CR_DISABLE_TYPE;
	}

	public Date getCRD_COVER_CR_DT() {
		 return CRD_COVER_CR_DT;
	}

	public void setCRD_COVER_CR_DT(Date CRD_COVER_CR_DT) {
		this.CRD_COVER_CR_DT = CRD_COVER_CR_DT;
	}

	public String getCRD_COVER_CR_UID() {
		 return CRD_COVER_CR_UID;
	}

	public void setCRD_COVER_CR_UID(String CRD_COVER_CR_UID) {
		this.CRD_COVER_CR_UID = CRD_COVER_CR_UID;
	}

	public Date getCRD_COVER_UPD_DT() {
		 return CRD_COVER_UPD_DT;
	}

	public void setCRD_COVER_UPD_DT(Date CRD_COVER_UPD_DT) {
		this.CRD_COVER_UPD_DT = CRD_COVER_UPD_DT;
	}

	public String getCRD_COVER_UPD_UID() {
		 return CRD_COVER_UPD_UID;
	}

	public void setCRD_COVER_UPD_UID(String CRD_COVER_UPD_UID) {
		this.CRD_COVER_UPD_UID = CRD_COVER_UPD_UID;
	}

	public String getUI_M_COVER_DESC_1() {
		return UI_M_COVER_DESC_1;
	}

	public void setUI_M_COVER_DESC_1(String ui_m_cover_desc_1) {
		UI_M_COVER_DESC_1 = ui_m_cover_desc_1;
	}

	public String getUI_M_DISABLE_DESC_1() {
		return UI_M_DISABLE_DESC_1;
	}

	public void setUI_M_DISABLE_DESC_1(String ui_m_disable_desc_1) {
		UI_M_DISABLE_DESC_1 = ui_m_disable_desc_1;
	}

	public String getUI_M_LOSS_DESC_1() {
		return UI_M_LOSS_DESC_1;
	}

	public void setUI_M_LOSS_DESC_1(String ui_m_loss_desc_1) {
		UI_M_LOSS_DESC_1 = ui_m_loss_desc_1;
	}

}

