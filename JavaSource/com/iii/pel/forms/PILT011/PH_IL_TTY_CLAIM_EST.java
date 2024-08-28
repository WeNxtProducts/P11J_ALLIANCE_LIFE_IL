package com.iii.pel.forms.PILT011;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PH_IL_TTY_CLAIM_EST")
public class PH_IL_TTY_CLAIM_EST extends BaseValueBean {

	@Column(name="TCEH_CCD_RESERVE_NO")
	private Double TCEH_CCD_RESERVE_NO;

	@Column(name="TCEH_TREATY_CODE")
	private String TCEH_TREATY_CODE;

	@Column(name="TCEH_UW_YEAR")
	private Double TCEH_UW_YEAR;

	@Column(name="TCEH_CLAIM_LOSS_DT")
	private Date TCEH_CLAIM_LOSS_DT;

	@Column(name="TCEH_O_RETN_LC_CLM_EST")
	private Double TCEH_O_RETN_LC_CLM_EST;

	@Column(name="TCEH_O_QS_LC_CLM_EST")
	private Double TCEH_O_QS_LC_CLM_EST;

	@Column(name="TCEH_O_1S_LC_CLM_EST")
	private Double TCEH_O_1S_LC_CLM_EST;

	@Column(name="TCEH_O_2S_LC_CLM_EST")
	private Double TCEH_O_2S_LC_CLM_EST;

	@Column(name="TCEH_O_3S_LC_CLM_EST")
	private Double TCEH_O_3S_LC_CLM_EST;

	@Column(name="TECH_O_CCD_RESERVE_DT")
	private Date TECH_O_CCD_RESERVE_DT;
	
	@Column(name="TCEH_CLAIM_SYS_ID")
	private Double TCEH_CLAIM_SYS_ID;
	
	@Column(name="TCEH_CCD_SYS_ID")
	private Double TCEH_CCD_SYS_ID;
	
	@Column(name="TCEH_CCD_COVER_CODE")
	private String TCEH_CCD_COVER_CODE;
	
	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getTCEH_CLAIM_SYS_ID() {
		return TCEH_CLAIM_SYS_ID;
	}

	public void setTCEH_CLAIM_SYS_ID(Double tceh_claim_sys_id) {
		TCEH_CLAIM_SYS_ID = tceh_claim_sys_id;
	}

	public Double getTCEH_CCD_SYS_ID() {
		return TCEH_CCD_SYS_ID;
	}

	public void setTCEH_CCD_SYS_ID(Double tceh_ccd_sys_id) {
		TCEH_CCD_SYS_ID = tceh_ccd_sys_id;
	}

	public String getTCEH_CCD_COVER_CODE() {
		return TCEH_CCD_COVER_CODE;
	}

	public void setTCEH_CCD_COVER_CODE(String tceh_ccd_cover_code) {
		TCEH_CCD_COVER_CODE = tceh_ccd_cover_code;
	}

	public Double getTCEH_CCD_RESERVE_NO() {
		return TCEH_CCD_RESERVE_NO;
	}

	public void setTCEH_CCD_RESERVE_NO(Double TCEH_CCD_RESERVE_NO) {
		this.TCEH_CCD_RESERVE_NO = TCEH_CCD_RESERVE_NO;
	}

	public String getTCEH_TREATY_CODE() {
		return TCEH_TREATY_CODE;
	}

	public void setTCEH_TREATY_CODE(String TCEH_TREATY_CODE) {
		this.TCEH_TREATY_CODE = TCEH_TREATY_CODE;
	}

	public Double getTCEH_UW_YEAR() {
		return TCEH_UW_YEAR;
	}

	public void setTCEH_UW_YEAR(Double TCEH_UW_YEAR) {
		this.TCEH_UW_YEAR = TCEH_UW_YEAR;
	}

	public Date getTCEH_CLAIM_LOSS_DT() {
		 return TCEH_CLAIM_LOSS_DT;
	}

	public void setTCEH_CLAIM_LOSS_DT(Date TCEH_CLAIM_LOSS_DT) {
		this.TCEH_CLAIM_LOSS_DT = TCEH_CLAIM_LOSS_DT;
	}

	public Double getTCEH_O_RETN_LC_CLM_EST() {
		return TCEH_O_RETN_LC_CLM_EST;
	}

	public void setTCEH_O_RETN_LC_CLM_EST(Double TCEH_O_RETN_LC_CLM_EST) {
		this.TCEH_O_RETN_LC_CLM_EST = TCEH_O_RETN_LC_CLM_EST;
	}

	public Double getTCEH_O_QS_LC_CLM_EST() {
		return TCEH_O_QS_LC_CLM_EST;
	}

	public void setTCEH_O_QS_LC_CLM_EST(Double TCEH_O_QS_LC_CLM_EST) {
		this.TCEH_O_QS_LC_CLM_EST = TCEH_O_QS_LC_CLM_EST;
	}

	public Double getTCEH_O_1S_LC_CLM_EST() {
		return TCEH_O_1S_LC_CLM_EST;
	}

	public void setTCEH_O_1S_LC_CLM_EST(Double TCEH_O_1S_LC_CLM_EST) {
		this.TCEH_O_1S_LC_CLM_EST = TCEH_O_1S_LC_CLM_EST;
	}

	public Double getTCEH_O_2S_LC_CLM_EST() {
		return TCEH_O_2S_LC_CLM_EST;
	}

	public void setTCEH_O_2S_LC_CLM_EST(Double TCEH_O_2S_LC_CLM_EST) {
		this.TCEH_O_2S_LC_CLM_EST = TCEH_O_2S_LC_CLM_EST;
	}

	public Double getTCEH_O_3S_LC_CLM_EST() {
		return TCEH_O_3S_LC_CLM_EST;
	}

	public void setTCEH_O_3S_LC_CLM_EST(Double TCEH_O_3S_LC_CLM_EST) {
		this.TCEH_O_3S_LC_CLM_EST = TCEH_O_3S_LC_CLM_EST;
	}

	public Date getTECH_O_CCD_RESERVE_DT() {
		 return TECH_O_CCD_RESERVE_DT;
	}

	public void setTECH_O_CCD_RESERVE_DT(Date TECH_O_CCD_RESERVE_DT) {
		this.TECH_O_CCD_RESERVE_DT = TECH_O_CCD_RESERVE_DT;
	}
}
