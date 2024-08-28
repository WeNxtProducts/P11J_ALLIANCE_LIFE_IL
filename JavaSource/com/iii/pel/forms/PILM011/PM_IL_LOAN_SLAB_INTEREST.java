package com.iii.pel.forms.PILM011;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_LOAN_SLAB_INTEREST")
public class PM_IL_LOAN_SLAB_INTEREST extends BaseValueBean {

	@Column(name="LSI_LOAN_AMT_FROM")
	private Double LSI_LOAN_AMT_FROM;

	@Column(name="LSI_LOAN_AMT_TO")
	private Double LSI_LOAN_AMT_TO;

	@Column(name="LSI_INT_RATE")
	private Double LSI_INT_RATE;

	@Column(name="LSI_INT_RATE_PER")
	private Integer LSI_INT_RATE_PER;

	@Column(name="LSI_EFF_FM_DT")
	private Date LSI_EFF_FM_DT;

	@Column(name="LSI_EFF_TO_DT")
	private Date LSI_EFF_TO_DT;
	
	@Column(name="LSI_LOAN_CODE")
	private String LSI_LOAN_CODE;
	
	@Column(name="LSI_CR_DT")
	private Date LSI_CR_DT;
	
	@Column(name="LSI_CR_UID")
	private String LSI_CR_UID;
	
	@Column(name="LSI_UPD_DT")
	private Date LSI_UPD_DT;
	
	@Column(name="LSI_UPD_UID")
	private String LSI_UPD_UID;	
	
	private boolean CHECK_BOX;
	
	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getLSI_LOAN_AMT_FROM() {
		return LSI_LOAN_AMT_FROM;
	}

	public void setLSI_LOAN_AMT_FROM(Double LSI_LOAN_AMT_FROM) {
		this.LSI_LOAN_AMT_FROM = LSI_LOAN_AMT_FROM;
	}

	public Double getLSI_LOAN_AMT_TO() {
		return LSI_LOAN_AMT_TO;
	}

	public void setLSI_LOAN_AMT_TO(Double LSI_LOAN_AMT_TO) {
		this.LSI_LOAN_AMT_TO = LSI_LOAN_AMT_TO;
	}

	public Double getLSI_INT_RATE() {
		return LSI_INT_RATE;
	}

	public void setLSI_INT_RATE(Double LSI_INT_RATE) {
		this.LSI_INT_RATE = LSI_INT_RATE;
	}

	public Integer getLSI_INT_RATE_PER() {
		return LSI_INT_RATE_PER;
	}

	public void setLSI_INT_RATE_PER(Integer LSI_INT_RATE_PER) {
		this.LSI_INT_RATE_PER = LSI_INT_RATE_PER;
	}

	public Date getLSI_EFF_FM_DT() {
		 return LSI_EFF_FM_DT;
	}

	public void setLSI_EFF_FM_DT(Date LSI_EFF_FM_DT) {
		this.LSI_EFF_FM_DT = LSI_EFF_FM_DT;
	}

	public Date getLSI_EFF_TO_DT() {
		 return LSI_EFF_TO_DT;
	}

	public void setLSI_EFF_TO_DT(Date LSI_EFF_TO_DT) {
		this.LSI_EFF_TO_DT = LSI_EFF_TO_DT;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getLSI_LOAN_CODE() {
		return LSI_LOAN_CODE;
	}

	public void setLSI_LOAN_CODE(String lsi_loan_code) {
		LSI_LOAN_CODE = lsi_loan_code;
	}

	public Date getLSI_CR_DT() {
		return LSI_CR_DT;
	}

	public void setLSI_CR_DT(Date lsi_cr_dt) {
		LSI_CR_DT = lsi_cr_dt;
	}

	public String getLSI_CR_UID() {
		return LSI_CR_UID;
	}

	public void setLSI_CR_UID(String lsi_cr_uid) {
		LSI_CR_UID = lsi_cr_uid;
	}

	public Date getLSI_UPD_DT() {
		return LSI_UPD_DT;
	}

	public void setLSI_UPD_DT(Date lsi_upd_dt) {
		LSI_UPD_DT = lsi_upd_dt;
	}

	public String getLSI_UPD_UID() {
		return LSI_UPD_UID;
	}

	public void setLSI_UPD_UID(String lsi_upd_uid) {
		LSI_UPD_UID = lsi_upd_uid;
	}
}
