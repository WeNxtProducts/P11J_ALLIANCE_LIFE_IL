package com.iii.pel.forms.PILP008;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {

	private String UI_M_M_POL_NO;
	
	private Date UI_M_M_APPRV_DATE = new java.util.Date();
	
	@Column(name="UI_M_M_CLAIM_GEN_YN")
	private String UI_M_M_CLAIM_GEN_YN;
	
	@Column(name="UI_M_M_BROK_GEN_YN")
	private String UI_M_M_BROK_GEN_YN;
	
	private String UI_M_CLAIM_CLOSE_YN;
	
	private String UI_M_BASE_CURR_CODE;

	public String getUI_M_BASE_CURR_CODE() {
		return UI_M_BASE_CURR_CODE;
	}

	public void setUI_M_BASE_CURR_CODE(String ui_m_base_curr_code) {
		UI_M_BASE_CURR_CODE = ui_m_base_curr_code;
	}

	public String getUI_M_M_POL_NO() {
		return UI_M_M_POL_NO;
	}

	public void setUI_M_M_POL_NO(String UI_M_M_POL_NO) {
		this.UI_M_M_POL_NO = UI_M_M_POL_NO;
	}

	public String getUI_M_M_CLAIM_GEN_YN() {
		return UI_M_M_CLAIM_GEN_YN;
	}

	public void setUI_M_M_CLAIM_GEN_YN(String UI_M_M_CLAIM_GEN_YN) {
		this.UI_M_M_CLAIM_GEN_YN = UI_M_M_CLAIM_GEN_YN;
	}

	public String getUI_M_M_BROK_GEN_YN() {
		return UI_M_M_BROK_GEN_YN;
	}

	public void setUI_M_M_BROK_GEN_YN(String UI_M_M_BROK_GEN_YN) {
		this.UI_M_M_BROK_GEN_YN = UI_M_M_BROK_GEN_YN;
	}

	public Date getUI_M_M_APPRV_DATE() {
		return UI_M_M_APPRV_DATE;
	}

	public void setUI_M_M_APPRV_DATE(Date ui_m_m_apprv_date) {
		UI_M_M_APPRV_DATE = ui_m_m_apprv_date;
	}

	public String getUI_M_CLAIM_CLOSE_YN() {
		return UI_M_CLAIM_CLOSE_YN;
	}

	public void setUI_M_CLAIM_CLOSE_YN(String ui_m_claim_close_yn) {
		UI_M_CLAIM_CLOSE_YN = ui_m_claim_close_yn;
	}
	
}
