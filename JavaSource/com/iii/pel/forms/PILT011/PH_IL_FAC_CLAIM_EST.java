package com.iii.pel.forms.PILT011;

import java.sql.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PH_IL_FAC_CLAIM_EST")
public class PH_IL_FAC_CLAIM_EST extends BaseValueBean {

	@Column(name="FCEH_CCD_RESERVE_NO")
	private Double FCEH_CCD_RESERVE_NO;

	@Column(name="FCEH_O_CCD_RESERVE_DT")
	private Date FCEH_O_CCD_RESERVE_DT;

	@Column(name="FCEH_CLAIM_CURR_CODE")
	private String FCEH_CLAIM_CURR_CODE;

	@Column(name="FCEH_CLAIM_SYS_ID")
	private Double FCEH_CLAIM_SYS_ID;

	@Column(name="FCEH_CCD_COVER_CODE")
	private String FCEH_CCD_COVER_CODE;
	
	public Double getFCEH_CCD_RESERVE_NO() {
		return FCEH_CCD_RESERVE_NO;
	}

	public void setFCEH_CCD_RESERVE_NO(Double FCEH_CCD_RESERVE_NO) {
		this.FCEH_CCD_RESERVE_NO = FCEH_CCD_RESERVE_NO;
	}

	public Date getFCEH_O_CCD_RESERVE_DT() {
		 return FCEH_O_CCD_RESERVE_DT;
	}

	public void setFCEH_O_CCD_RESERVE_DT(Date FCEH_O_CCD_RESERVE_DT) {
		this.FCEH_O_CCD_RESERVE_DT = FCEH_O_CCD_RESERVE_DT;
	}

	public String getFCEH_CLAIM_CURR_CODE() {
		return FCEH_CLAIM_CURR_CODE;
	}

	public void setFCEH_CLAIM_CURR_CODE(String FCEH_CLAIM_CURR_CODE) {
		this.FCEH_CLAIM_CURR_CODE = FCEH_CLAIM_CURR_CODE;
	}

	public Double getFCEH_CLAIM_SYS_ID() {
		return FCEH_CLAIM_SYS_ID;
	}

	public void setFCEH_CLAIM_SYS_ID(Double fceh_claim_sys_id) {
		FCEH_CLAIM_SYS_ID = fceh_claim_sys_id;
	}

	public String getFCEH_CCD_COVER_CODE() {
		return FCEH_CCD_COVER_CODE;
	}

	public void setFCEH_CCD_COVER_CODE(String fceh_ccd_cover_code) {
		FCEH_CCD_COVER_CODE = fceh_ccd_cover_code;
	}
}
