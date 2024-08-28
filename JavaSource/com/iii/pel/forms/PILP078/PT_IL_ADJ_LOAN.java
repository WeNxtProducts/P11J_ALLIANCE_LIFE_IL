package com.iii.pel.forms.PILP078;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.premia.common.bean.BaseValueBean;

public class PT_IL_ADJ_LOAN extends BaseValueBean {
	@Column(name="AL_POL_NO")
	private String AL_POL_NO;
	
	@Column(name="AL_REPAY_DT")
	private Date AL_REPAY_DT;
	
	@Column(name="AL_FC_LOAN_AMT")
	private Double AL_FC_LOAN_AMT;
	
	@Column(name="AL_FC_INT_AMT")
	private Double AL_FC_INT_AMT;
	
	@Column(name="AL_STATUS")
	private String AL_STATUS;
	
	private Double UI_POL_LOAN;
	
	@Column(name = "AL_CR_UID")
	private String AL_CR_UID;

	@Column(name = "AL_CR_DT")
	private Date AL_CR_DT;
	
	@Column(name = "AL_UPD_UID")
	private String AL_UPD_UID;
	
	@Column(name = "AL_UPD_DT")
	private Date AL_UPD_DT;

	public String getAL_CR_UID() {
		return AL_CR_UID;
	}

	public void setAL_CR_UID(String aL_CR_UID) {
		AL_CR_UID = aL_CR_UID;
	}

	public Date getAL_CR_DT() {
		return AL_CR_DT;
	}

	public void setAL_CR_DT(Date aL_CR_DT) {
		AL_CR_DT = aL_CR_DT;
	}

	public String getAL_UPD_UID() {
		return AL_UPD_UID;
	}

	public void setAL_UPD_UID(String aL_UPD_UID) {
		AL_UPD_UID = aL_UPD_UID;
	}

	public Date getAL_UPD_DT() {
		return AL_UPD_DT;
	}

	public void setAL_UPD_DT(Date aL_UPD_DT) {
		AL_UPD_DT = aL_UPD_DT;
	}

	public Double getUI_POL_LOAN() {
		return UI_POL_LOAN;
	}

	public void setUI_POL_LOAN(Double uI_POL_LOAN) {
		UI_POL_LOAN = uI_POL_LOAN;
	}

	public String getAL_POL_NO() {
		return AL_POL_NO;
	}

	public void setAL_POL_NO(String aL_POL_NO) {
		AL_POL_NO = aL_POL_NO;
	}

	public Date getAL_REPAY_DT() {
		return AL_REPAY_DT;
	}

	public void setAL_REPAY_DT(Date aL_REPAY_DT) {
		AL_REPAY_DT = aL_REPAY_DT;
	}

	public Double getAL_FC_LOAN_AMT() {
		return AL_FC_LOAN_AMT;
	}

	public void setAL_FC_LOAN_AMT(Double aL_FC_LOAN_AMT) {
		AL_FC_LOAN_AMT = aL_FC_LOAN_AMT;
	}

	public Double getAL_FC_INT_AMT() {
		return AL_FC_INT_AMT;
	}

	public void setAL_FC_INT_AMT(Double aL_FC_INT_AMT) {
		AL_FC_INT_AMT = aL_FC_INT_AMT;
	}

	public String getAL_STATUS() {
		return AL_STATUS;
	}

	public void setAL_STATUS(String aL_STATUS) {
		AL_STATUS = aL_STATUS;
	}
	

}
