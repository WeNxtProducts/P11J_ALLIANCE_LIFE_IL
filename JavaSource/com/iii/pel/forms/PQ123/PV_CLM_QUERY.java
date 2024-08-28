package com.iii.pel.forms.PQ123;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_CLM_QUERY")
public class PV_CLM_QUERY extends BaseValueBean {

	@Column(name="CLM_EST_AMT")
	private Double CLM_EST_AMT;

	@Column(name="CLM_PAID_AMT")
	private Double CLM_PAID_AMT;

	@Column(name="CLM_OS_AMT")
	private Double CLM_OS_AMT;

	@Column(name="CLM_NO")
	private String CLM_NO;



	public String getCLM_NO() {
		return CLM_NO;
	}

	public void setCLM_NO(String clm_no) {
		CLM_NO = clm_no;
	}

	public Double getCLM_EST_AMT() {
		return CLM_EST_AMT;
	}

	public void setCLM_EST_AMT(Double CLM_EST_AMT) {
		this.CLM_EST_AMT = CLM_EST_AMT;
	}

	public Double getCLM_PAID_AMT() {
		return CLM_PAID_AMT;
	}

	public void setCLM_PAID_AMT(Double CLM_PAID_AMT) {
		this.CLM_PAID_AMT = CLM_PAID_AMT;
	}

	public Double getCLM_OS_AMT() {
		return CLM_OS_AMT;
	}

	public void setCLM_OS_AMT(Double CLM_OS_AMT) {
		this.CLM_OS_AMT = CLM_OS_AMT;
	}


}
