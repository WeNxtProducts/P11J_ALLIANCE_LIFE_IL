package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_TOPUP_PARAM")
public class PM_IL_PROD_TOPUP_PARAM extends BaseValueBean {

	@Column(name="PTP_PROD_CODE")
	private String PTP_PROD_CODE;

	@Column(name="PTP_MODE_OF_PYMT")
	private String PTP_MODE_OF_PYMT;

	@Column(name="PTP_LC_MIN_AMT")
	private Double PTP_LC_MIN_AMT;

	@Column(name="PTP_LC_MAX_AMT")
	private Double PTP_LC_MAX_AMT;

	@Column(name="PTP_CR_UID")
	private String PTP_CR_UID;

	@Column(name="PTP_CR_DT")
	private Date PTP_CR_DT;

	@Column(name="PTP_UPD_UID")
	private String PTP_UPD_UID;

	@Column(name="PTP_UPD_DT")
	private Date PTP_UPD_DT;



	public String getPTP_PROD_CODE() {
		 return PTP_PROD_CODE;
	}

	public void setPTP_PROD_CODE(String PTP_PROD_CODE) {
		this.PTP_PROD_CODE = PTP_PROD_CODE;
	}

	public String getPTP_MODE_OF_PYMT() {
		 return PTP_MODE_OF_PYMT;
	}

	public void setPTP_MODE_OF_PYMT(String PTP_MODE_OF_PYMT) {
		this.PTP_MODE_OF_PYMT = PTP_MODE_OF_PYMT;
	}

	public Double getPTP_LC_MIN_AMT() {
		 return PTP_LC_MIN_AMT;
	}

	public void setPTP_LC_MIN_AMT(Double PTP_LC_MIN_AMT) {
		this.PTP_LC_MIN_AMT = PTP_LC_MIN_AMT;
	}

	public Double getPTP_LC_MAX_AMT() {
		 return PTP_LC_MAX_AMT;
	}

	public void setPTP_LC_MAX_AMT(Double PTP_LC_MAX_AMT) {
		this.PTP_LC_MAX_AMT = PTP_LC_MAX_AMT;
	}

	public String getPTP_CR_UID() {
		 return PTP_CR_UID;
	}

	public void setPTP_CR_UID(String PTP_CR_UID) {
		this.PTP_CR_UID = PTP_CR_UID;
	}

	public Date getPTP_CR_DT() {
		 return PTP_CR_DT;
	}

	public void setPTP_CR_DT(Date PTP_CR_DT) {
		this.PTP_CR_DT = PTP_CR_DT;
	}

	public String getPTP_UPD_UID() {
		 return PTP_UPD_UID;
	}

	public void setPTP_UPD_UID(String PTP_UPD_UID) {
		this.PTP_UPD_UID = PTP_UPD_UID;
	}

	public Date getPTP_UPD_DT() {
		 return PTP_UPD_DT;
	}

	public void setPTP_UPD_DT(Date PTP_UPD_DT) {
		this.PTP_UPD_DT = PTP_UPD_DT;
	}
}
