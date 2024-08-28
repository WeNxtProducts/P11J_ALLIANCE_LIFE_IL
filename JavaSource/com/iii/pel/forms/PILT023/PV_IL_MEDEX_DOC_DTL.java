package com.iii.pel.forms.PILT023;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_IL_MEDEX_DOC_DTL")
public class PV_IL_MEDEX_DOC_DTL extends BaseValueBean {
	
	@Column(name="MFD_ACNT_TXN_CODE")
	private String MFD_ACNT_TXN_CODE;

	@Column(name="MFD_ACNT_DOC_NO")
	private String MFD_ACNT_DOC_NO;

	@Column(name="MFD_ACNT_DOC_DT")
	private Date MFD_ACNT_DOC_DT;

	//@Column(name="M_MFD_LC_CR_VALUE")
	private int WM_MFD_LC_CR_VALUE;

	//@Column(name="M_MFD_LC_PAID_VALUE")
	private int WM_MFD_LC_PAID_VALUE;

	public String getMFD_ACNT_TXN_CODE() {
		return MFD_ACNT_TXN_CODE;
	}

	public void setMFD_ACNT_TXN_CODE(String mFD_ACNT_TXN_CODE) {
		MFD_ACNT_TXN_CODE = mFD_ACNT_TXN_CODE;
	}

	public String getMFD_ACNT_DOC_NO() {
		return MFD_ACNT_DOC_NO;
	}

	public void setMFD_ACNT_DOC_NO(String mFD_ACNT_DOC_NO) {
		MFD_ACNT_DOC_NO = mFD_ACNT_DOC_NO;
	}

	public Date getMFD_ACNT_DOC_DT() {
		return MFD_ACNT_DOC_DT;
	}

	public void setMFD_ACNT_DOC_DT(Date mFD_ACNT_DOC_DT) {
		MFD_ACNT_DOC_DT = mFD_ACNT_DOC_DT;
	}

	public int getWM_MFD_LC_CR_VALUE() {
		return WM_MFD_LC_CR_VALUE;
	}

	public void setWM_MFD_LC_CR_VALUE(int wM_MFD_LC_CR_VALUE) {
		WM_MFD_LC_CR_VALUE = wM_MFD_LC_CR_VALUE;
	}

	public int getWM_MFD_LC_PAID_VALUE() {
		return WM_MFD_LC_PAID_VALUE;
	}

	public void setWM_MFD_LC_PAID_VALUE(int wM_MFD_LC_PAID_VALUE) {
		WM_MFD_LC_PAID_VALUE = wM_MFD_LC_PAID_VALUE;
	}


}
