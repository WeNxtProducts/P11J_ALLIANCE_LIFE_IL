package com.iii.pel.forms.PILP045_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_IL_DRCR")
public class PS_IL_DRCR extends BaseValueBean{

	@Column(name="DRCR_CHQ_NO")
	private String DRCR_CHQ_NO;

	@Column(name="DRCR_CHQ_DT")
	private Date DRCR_CHQ_DT;

	@Column(name="DRCR_BANK_NAME")
	private String DRCR_BANK_NAME;
	
	@Column(name="DRCR_POL_SYS_ID")	
	private float DRCR_POL_SYS_ID;
	
	@Column(name="DRCR_END_NO_IDX")
	private float DRCR_END_NO_IDX;



	public String getDRCR_CHQ_NO() {
		return DRCR_CHQ_NO;
	}

	public void setDRCR_CHQ_NO(String DRCR_CHQ_NO) {
		this.DRCR_CHQ_NO = DRCR_CHQ_NO;
	}

	public Date getDRCR_CHQ_DT() {
		 return DRCR_CHQ_DT;
	}

	public void setDRCR_CHQ_DT(Date DRCR_CHQ_DT) {
		this.DRCR_CHQ_DT = DRCR_CHQ_DT;
	}

	public String getDRCR_BANK_NAME() {
		return DRCR_BANK_NAME;
	}

	public void setDRCR_BANK_NAME(String DRCR_BANK_NAME) {
		this.DRCR_BANK_NAME = DRCR_BANK_NAME;
	}

	public float getDRCR_POL_SYS_ID() {
		return DRCR_POL_SYS_ID;
	}

	public void setDRCR_POL_SYS_ID(float drcr_pol_sys_id) {
		DRCR_POL_SYS_ID = drcr_pol_sys_id;
	}

	public float getDRCR_END_NO_IDX() {
		return DRCR_END_NO_IDX;
	}

	public void setDRCR_END_NO_IDX(float drcr_end_no_idx) {
		DRCR_END_NO_IDX = drcr_end_no_idx;
	}
}
