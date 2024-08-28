package com.iii.pel.forms.PILP036;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CHEQ_REALISE_DTL")
public class PT_IL_CHEQ_REALISE_DTL extends BaseValueBean {

	@Column(name="CHRD_DEP_REF_NO")
	private String CHRD_DEP_REF_NO;

	@Column(name="CHRD_DEP_TXN_CODE")
	private String CHRD_DEP_TXN_CODE;

	@Column(name="CHRD_DEP_DOC_NO")
	private Double CHRD_DEP_DOC_NO;

	@Column(name="CHRD_DEP_DOC_DT")
	private Date CHRD_DEP_DOC_DT;

	@Column(name="CHRD_PD_CHQ_NO")
	private String CHRD_PD_CHQ_NO;

	@Column(name="CHRD_PD_CHQ_DT")
	private Date CHRD_PD_CHQ_DT;

	@Column(name="CHRD_DEP_LC_TOTAL_AMT")
	private Double CHRD_DEP_LC_TOTAL_AMT;

	@Column(name="CHRD_ASSIGN_FLAG")
	private String CHRD_ASSIGN_FLAG;

	private String UI_M_FM_BANK;
	
	private String UI_M_FM_BANK_DESC;
	
	private String UI_M_TO_BANK;
	
	private String UI_M_TO_BANK_DESC;
	
	private Date UI_M_TO_DATE;

	public Date getUI_M_TO_DATE() {
		return UI_M_TO_DATE;
	}

	public void setUI_M_TO_DATE(Date ui_m_to_date) {
		UI_M_TO_DATE = ui_m_to_date;
	}

	public String getCHRD_DEP_REF_NO() {
		return CHRD_DEP_REF_NO;
	}

	public void setCHRD_DEP_REF_NO(String CHRD_DEP_REF_NO) {
		this.CHRD_DEP_REF_NO = CHRD_DEP_REF_NO;
	}

	public String getCHRD_DEP_TXN_CODE() {
		return CHRD_DEP_TXN_CODE;
	}

	public void setCHRD_DEP_TXN_CODE(String CHRD_DEP_TXN_CODE) {
		this.CHRD_DEP_TXN_CODE = CHRD_DEP_TXN_CODE;
	}

	public Double getCHRD_DEP_DOC_NO() {
		return CHRD_DEP_DOC_NO;
	}

	public void setCHRD_DEP_DOC_NO(Double CHRD_DEP_DOC_NO) {
		this.CHRD_DEP_DOC_NO = CHRD_DEP_DOC_NO;
	}

	public Date getCHRD_DEP_DOC_DT() {
		 return CHRD_DEP_DOC_DT;
	}

	public void setCHRD_DEP_DOC_DT(Date CHRD_DEP_DOC_DT) {
		this.CHRD_DEP_DOC_DT = CHRD_DEP_DOC_DT;
	}

	public String getCHRD_PD_CHQ_NO() {
		return CHRD_PD_CHQ_NO;
	}

	public void setCHRD_PD_CHQ_NO(String CHRD_PD_CHQ_NO) {
		this.CHRD_PD_CHQ_NO = CHRD_PD_CHQ_NO;
	}

	public Date getCHRD_PD_CHQ_DT() {
		 return CHRD_PD_CHQ_DT;
	}

	public void setCHRD_PD_CHQ_DT(Date CHRD_PD_CHQ_DT) {
		this.CHRD_PD_CHQ_DT = CHRD_PD_CHQ_DT;
	}

	public Double getCHRD_DEP_LC_TOTAL_AMT() {
		return CHRD_DEP_LC_TOTAL_AMT;
	}

	public void setCHRD_DEP_LC_TOTAL_AMT(Double CHRD_DEP_LC_TOTAL_AMT) {
		this.CHRD_DEP_LC_TOTAL_AMT = CHRD_DEP_LC_TOTAL_AMT;
	}

	public String getCHRD_ASSIGN_FLAG() {
		return CHRD_ASSIGN_FLAG;
	}

	public void setCHRD_ASSIGN_FLAG(String CHRD_ASSIGN_FLAG) {
		this.CHRD_ASSIGN_FLAG = CHRD_ASSIGN_FLAG;
	}

	public String getUI_M_FM_BANK() {
		return UI_M_FM_BANK;
	}

	public void setUI_M_FM_BANK(String ui_m_fm_bank) {
		UI_M_FM_BANK = ui_m_fm_bank;
	}

	public String getUI_M_FM_BANK_DESC() {
		return UI_M_FM_BANK_DESC;
	}

	public void setUI_M_FM_BANK_DESC(String ui_m_fm_bank_desc) {
		UI_M_FM_BANK_DESC = ui_m_fm_bank_desc;
	}

	public String getUI_M_TO_BANK() {
		return UI_M_TO_BANK;
	}

	public void setUI_M_TO_BANK(String ui_m_to_bank) {
		UI_M_TO_BANK = ui_m_to_bank;
	}

	public String getUI_M_TO_BANK_DESC() {
		return UI_M_TO_BANK_DESC;
	}

	public void setUI_M_TO_BANK_DESC(String ui_m_to_bank_desc) {
		UI_M_TO_BANK_DESC = ui_m_to_bank_desc;
	}
}
