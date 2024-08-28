package com.iii.pel.forms.PILT005;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_LOAN_REPAYMENT_DTL")
public class PT_IL_LOAN_REPAYMENT_DTL extends BaseValueBean {

	@Column(name="LRD_PROD_CODE")
	private String LRD_PROD_CODE;

	@Column(name="LRD_FC_PYMT_AMT")
	private Double LRD_FC_PYMT_AMT;

	@Column(name="LRD_LC_PYMT_AMT")
	private Double LRD_LC_PYMT_AMT;

	private String UI_M_REPAY_PROD_DESC;
	
	public Double LRD_LOAN_SYS_ID;
	
	public Double LRD_LR_SYS_ID;



	public String getLRD_PROD_CODE() {
		return LRD_PROD_CODE;
	}

	public void setLRD_PROD_CODE(String LRD_PROD_CODE) {
		this.LRD_PROD_CODE = LRD_PROD_CODE;
	}

	public Double getLRD_FC_PYMT_AMT() {
		return LRD_FC_PYMT_AMT;
	}

	public void setLRD_FC_PYMT_AMT(Double LRD_FC_PYMT_AMT) {
		this.LRD_FC_PYMT_AMT = LRD_FC_PYMT_AMT;
	}

	public Double getLRD_LC_PYMT_AMT() {
		return LRD_LC_PYMT_AMT;
	}

	public void setLRD_LC_PYMT_AMT(Double LRD_LC_PYMT_AMT) {
		this.LRD_LC_PYMT_AMT = LRD_LC_PYMT_AMT;
	}

	public String getUI_M_REPAY_PROD_DESC() {
		return UI_M_REPAY_PROD_DESC;
	}

	public void setUI_M_REPAY_PROD_DESC(String UI_M_REPAY_PROD_DESC) {
		this.UI_M_REPAY_PROD_DESC = UI_M_REPAY_PROD_DESC;
	}

	public Double getLRD_LOAN_SYS_ID() {
		return LRD_LOAN_SYS_ID;
	}

	public void setLRD_LOAN_SYS_ID(Double lrd_loan_sys_id) {
		LRD_LOAN_SYS_ID = lrd_loan_sys_id;
	}

	public Double getLRD_LR_SYS_ID() {
		return LRD_LR_SYS_ID;
	}

	public void setLRD_LR_SYS_ID(Double lrd_lr_sys_id) {
		LRD_LR_SYS_ID = lrd_lr_sys_id;
	}
}
