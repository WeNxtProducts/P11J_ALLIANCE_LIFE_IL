package com.iii.pel.forms.PM092_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_CONTEST_DTL")
public class PM_AGENT_CONTEST_DTL extends BaseValueBean {

	@Column(name="ACD_ACH_CODE")
	private String  ACD_ACH_CODE;
	@Column(name="ACD_NO_OF_POL_FM")
	private Integer  ACD_NO_OF_POL_FM;
	@Column(name="ACD_NO_OF_POL_TO")
	private Integer  ACD_NO_OF_POL_TO;
	@Column(name="ACD_PROD_TYPE")
	private String  ACD_PROD_TYPE;
	@Column(name="ACD_LC_FYC_FM")
	private Double  ACD_LC_FYC_FM;
	@Column(name="ACD_LC_FYC_TO")
	private Double  ACD_LC_FYC_TO;
	@Column(name="ACD_CR_DT")
	private Date  ACD_CR_DT;
	@Column(name="ACD_CR_UID")
	private String  ACD_CR_UID;
	@Column(name="ACD_UPD_DT")
	private Date  ACD_UPD_DT;
	@Column(name="ACD_UPD_UID")
	private String  ACD_UPD_UID;
	@Column(name="ACD_FYC_TYPE")
	private String  ACD_FYC_TYPE;

	public PM_AGENT_CONTEST_DTL() {
	}


	public Integer getACD_NO_OF_POL_FM() {
		return ACD_NO_OF_POL_FM;
	}

	public void setACD_NO_OF_POL_FM(Integer ACD_NO_OF_POL_FM) {
		this.ACD_NO_OF_POL_FM = ACD_NO_OF_POL_FM;
	}

	public Integer getACD_NO_OF_POL_TO() {
		return ACD_NO_OF_POL_TO;
	}

	public void setACD_NO_OF_POL_TO(Integer ACD_NO_OF_POL_TO) {
		this.ACD_NO_OF_POL_TO = ACD_NO_OF_POL_TO;
	}

	public String getACD_PROD_TYPE() {
		return ACD_PROD_TYPE;
	}

	public void setACD_PROD_TYPE(String ACD_PROD_TYPE) {
		this.ACD_PROD_TYPE = ACD_PROD_TYPE;
	}

	public Double getACD_LC_FYC_FM() {
		return ACD_LC_FYC_FM;
	}

	public void setACD_LC_FYC_FM(Double ACD_LC_FYC_FM) {
		this.ACD_LC_FYC_FM = ACD_LC_FYC_FM;
	}

	public Double getACD_LC_FYC_TO() {
		return ACD_LC_FYC_TO;
	}

	public void setACD_LC_FYC_TO(Double ACD_LC_FYC_TO) {
		this.ACD_LC_FYC_TO = ACD_LC_FYC_TO;
	}

	public String getACD_FYC_TYPE() {
		return ACD_FYC_TYPE;
	}

	public void setACD_FYC_TYPE(String ACD_FYC_TYPE) {
		this.ACD_FYC_TYPE = ACD_FYC_TYPE;
	}

	public String getACD_ACH_CODE() {
		return ACD_ACH_CODE;
	}

	public void setACD_ACH_CODE(String acd_ach_code) {
		ACD_ACH_CODE = acd_ach_code;
	}

	public Date getACD_CR_DT() {
		return ACD_CR_DT;
	}

	public void setACD_CR_DT(Date acd_cr_dt) {
		ACD_CR_DT = acd_cr_dt;
	}

	public String getACD_CR_UID() {
		return ACD_CR_UID;
	}

	public void setACD_CR_UID(String acd_cr_uid) {
		ACD_CR_UID = acd_cr_uid;
	}

	public Date getACD_UPD_DT() {
		return ACD_UPD_DT;
	}

	public void setACD_UPD_DT(Date acd_upd_dt) {
		ACD_UPD_DT = acd_upd_dt;
	}

	public String getACD_UPD_UID() {
		return ACD_UPD_UID;
	}

	public void setACD_UPD_UID(String acd_upd_uid) {
		ACD_UPD_UID = acd_upd_uid;
	}


}
