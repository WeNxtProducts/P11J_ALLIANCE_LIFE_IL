package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_SURR_DTL")
public class PM_IL_PROD_APPL_SURRENDER extends BaseValueBean {
	
	@Column(name="PSD_TERM_FM")
	private Integer PSD_TERM_FM;
	
	@Column(name="PSD_TERM_TO")
	private Integer PSD_TERM_TO;
	
	@Column(name="PSD_SURR_YRS")
	private Integer PSD_SURR_YRS;
	
	@Column(name="PSD_PROD_CODE")
	private String PSD_PROD_CODE;
	
	@Column(name = "PSD_CR_UID")
	private String PSD_CR_UID;

	@Column(name = "PSD_CR_DT")
	private Date PSD_CR_DT;
	
	@Column(name = "PSD_UPD_DT")
	private Date PSD_UPD_DT;

	public Date getPSD_UPD_DT() {
		return PSD_UPD_DT;
	}

	public void setPSD_UPD_DT(Date pSD_UPD_DT) {
		PSD_UPD_DT = pSD_UPD_DT;
	}

	@Column(name = "PSD_UPD_UID")
	private String PSD_UPD_UID;

	public String getPSD_UPD_UID() {
		return PSD_UPD_UID;
	}

	public void setPSD_UPD_UID(String pSD_UPD_UID) {
		PSD_UPD_UID = pSD_UPD_UID;
	}

	public String getPSD_CR_UID() {
		return PSD_CR_UID;
	}

	public void setPSD_CR_UID(String pSD_CR_UID) {
		PSD_CR_UID = pSD_CR_UID;
	}
	public Date getPSD_CR_DT() {
		return PSD_CR_DT;
	}

	public void setPSD_CR_DT(Date pSD_CR_DT) {
		PSD_CR_DT = pSD_CR_DT;
	}

	public String getPSD_PROD_CODE() {
		return PSD_PROD_CODE;
	}

	public void setPSD_PROD_CODE(String pSD_PROD_CODE) {
		PSD_PROD_CODE = pSD_PROD_CODE;
	}

	public Integer getPSD_TERM_FM() {
		return PSD_TERM_FM;
	}

	public void setPSD_TERM_FM(Integer pSD_TERM_FM) {
		PSD_TERM_FM = pSD_TERM_FM;
	}

	public Integer getPSD_TERM_TO() {
		return PSD_TERM_TO;
	}

	public void setPSD_TERM_TO(Integer pSD_TERM_TO) {
		PSD_TERM_TO = pSD_TERM_TO;
	}

	public Integer getPSD_SURR_YRS() {
		return PSD_SURR_YRS;
	}

	public void setPSD_SURR_YRS(Integer pSD_SURR_YRS) {
		PSD_SURR_YRS = pSD_SURR_YRS;
	}


}
