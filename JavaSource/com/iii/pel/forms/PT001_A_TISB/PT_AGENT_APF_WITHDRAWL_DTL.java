package com.iii.pel.forms.PT001_A_TISB;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_APF_WITHDRAWL_DTL")
public class PT_AGENT_APF_WITHDRAWL_DTL extends BaseValueBean {

	@Column(name="APWD_ACC_TYPE")
	private String APWD_ACC_TYPE;

	@Column(name="APWD_LC_COMM_AMT")
	private Double APWD_LC_COMM_AMT;

	@Column(name="APWD_FC_COMM_AMT")
	private Double APWD_FC_COMM_AMT;

	@Column(name="APWD_LC_COMM_INT_AMT")
	private Double APWD_LC_COMM_INT_AMT;

	@Column(name="APWD_FC_COMM_INT_AMT")
	private Double APWD_FC_COMM_INT_AMT;

	@Column(name="APWD_LC_BENF_AMT")
	private Double APWD_LC_BENF_AMT;

	@Column(name="APWD_FC_BENF_AMT")
	private Double APWD_FC_BENF_AMT;

	@Column(name="APWD_LC_BENF_INT_AMT")
	private Double APWD_LC_BENF_INT_AMT;

	@Column(name="APWD_FC_BENF_INT_AMT")
	private Double APWD_FC_BENF_INT_AMT;



	public String getAPWD_ACC_TYPE() {
		return APWD_ACC_TYPE;
	}

	public void setAPWD_ACC_TYPE(String APWD_ACC_TYPE) {
		this.APWD_ACC_TYPE = APWD_ACC_TYPE;
	}

	public Double getAPWD_LC_COMM_AMT() {
		return APWD_LC_COMM_AMT;
	}

	public void setAPWD_LC_COMM_AMT(Double APWD_LC_COMM_AMT) {
		this.APWD_LC_COMM_AMT = APWD_LC_COMM_AMT;
	}

	public Double getAPWD_FC_COMM_AMT() {
		return APWD_FC_COMM_AMT;
	}

	public void setAPWD_FC_COMM_AMT(Double APWD_FC_COMM_AMT) {
		this.APWD_FC_COMM_AMT = APWD_FC_COMM_AMT;
	}

	public Double getAPWD_LC_COMM_INT_AMT() {
		return APWD_LC_COMM_INT_AMT;
	}

	public void setAPWD_LC_COMM_INT_AMT(Double APWD_LC_COMM_INT_AMT) {
		this.APWD_LC_COMM_INT_AMT = APWD_LC_COMM_INT_AMT;
	}

	public Double getAPWD_FC_COMM_INT_AMT() {
		return APWD_FC_COMM_INT_AMT;
	}

	public void setAPWD_FC_COMM_INT_AMT(Double APWD_FC_COMM_INT_AMT) {
		this.APWD_FC_COMM_INT_AMT = APWD_FC_COMM_INT_AMT;
	}

	public Double getAPWD_LC_BENF_AMT() {
		return APWD_LC_BENF_AMT;
	}

	public void setAPWD_LC_BENF_AMT(Double APWD_LC_BENF_AMT) {
		this.APWD_LC_BENF_AMT = APWD_LC_BENF_AMT;
	}

	public Double getAPWD_FC_BENF_AMT() {
		return APWD_FC_BENF_AMT;
	}

	public void setAPWD_FC_BENF_AMT(Double APWD_FC_BENF_AMT) {
		this.APWD_FC_BENF_AMT = APWD_FC_BENF_AMT;
	}

	public Double getAPWD_LC_BENF_INT_AMT() {
		return APWD_LC_BENF_INT_AMT;
	}

	public void setAPWD_LC_BENF_INT_AMT(Double APWD_LC_BENF_INT_AMT) {
		this.APWD_LC_BENF_INT_AMT = APWD_LC_BENF_INT_AMT;
	}

	public Double getAPWD_FC_BENF_INT_AMT() {
		return APWD_FC_BENF_INT_AMT;
	}

	public void setAPWD_FC_BENF_INT_AMT(Double APWD_FC_BENF_INT_AMT) {
		this.APWD_FC_BENF_INT_AMT = APWD_FC_BENF_INT_AMT;
	}
}
