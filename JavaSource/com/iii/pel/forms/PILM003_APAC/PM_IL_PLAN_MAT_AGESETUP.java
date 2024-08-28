package com.iii.pel.forms.PILM003_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PLAN_MAT_AGESETUP")
public class PM_IL_PLAN_MAT_AGESETUP extends BaseValueBean {

	@Column(name="PMA_PLAN_CODE")
	private String PMA_PLAN_CODE;

	@Column(name="PMA_AGE_BASIS")
	private String PMA_AGE_BASIS;

	@Column(name="PMA_MAT_PAYER_AGE")
	private Integer PMA_MAT_PAYER_AGE;

	@Column(name="PMA_MAT_PAYEE_AGE")
	private Integer PMA_MAT_PAYEE_AGE;

	@Column(name="PMA_MAT_MIN_PAYER_AGE")
	private Integer PMA_MAT_MIN_PAYER_AGE;

	@Column(name="PMA_MAT_MIN_PAYEE_AGE")
	private Integer PMA_MAT_MIN_PAYEE_AGE;

	public void setPMA_AGE_BASIS(String PMA_AGE_BASIS) {
		this.PMA_AGE_BASIS = PMA_AGE_BASIS;
	}
	public String getPMA_AGE_BASIS() {
		 return PMA_AGE_BASIS;
	}
	public void setPMA_MAT_MIN_PAYER_AGE(Integer PMA_MAT_MIN_PAYER_AGE) {
		this.PMA_MAT_MIN_PAYER_AGE = PMA_MAT_MIN_PAYER_AGE;
	}
	public Integer getPMA_MAT_MIN_PAYER_AGE() {
		 return PMA_MAT_MIN_PAYER_AGE;
	}
	public void setPMA_MAT_PAYER_AGE(Integer PMA_MAT_PAYER_AGE) {
		this.PMA_MAT_PAYER_AGE = PMA_MAT_PAYER_AGE;
	}
	public Integer getPMA_MAT_PAYER_AGE() {
		 return PMA_MAT_PAYER_AGE;
	}
	public void setPMA_PLAN_CODE(String PMA_PLAN_CODE) {
		this.PMA_PLAN_CODE = PMA_PLAN_CODE;
	}
	public String getPMA_PLAN_CODE() {
		 return PMA_PLAN_CODE;
	}
	public void setPMA_MAT_MIN_PAYEE_AGE(Integer PMA_MAT_MIN_PAYEE_AGE) {
		this.PMA_MAT_MIN_PAYEE_AGE = PMA_MAT_MIN_PAYEE_AGE;
	}
	public Integer getPMA_MAT_MIN_PAYEE_AGE() {
		 return PMA_MAT_MIN_PAYEE_AGE;
	}
	public void setPMA_MAT_PAYEE_AGE(Integer PMA_MAT_PAYEE_AGE) {
		this.PMA_MAT_PAYEE_AGE = PMA_MAT_PAYEE_AGE;
	}
	public Integer getPMA_MAT_PAYEE_AGE() {
		 return PMA_MAT_PAYEE_AGE;
	}

}
