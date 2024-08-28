package com.iii.pel.forms.PILT004;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_LOAN_DTL")
public class PT_IL_LOAN_DTL extends BaseValueBean {

	@Column(name="LOAND_PROD_CODE")
	private String LOAND_PROD_CODE;

	@Column(name="LOAND_FC_PERM_AMT")
	private Double LOAND_FC_PERM_AMT;

	@Column(name="LOAND_LC_PERM_AMT")
	private Double LOAND_LC_PERM_AMT;

	@Column(name="LOAND_FC_AMOUNT")
	private Double LOAND_FC_AMOUNT;

	@Column(name="LOAND_LC_AMOUNT")
	private Double LOAND_LC_AMOUNT;

	private String UI_M_LOAND_PROD_DESC;
	
	@Column(name="LOAND_SYS_ID")
	private Double LOAND_SYS_ID;

	@Column(name="LOAND_LOAN_SYS_ID")
	private Double LOAND_LOAN_SYS_ID;
	
	@Column(name="LOAND_POL_SYS_ID")
	private Double LOAND_POL_SYS_ID; 


	public Double getLOAND_SYS_ID() {
		return LOAND_SYS_ID;
	}

	public void setLOAND_SYS_ID(Double loand_sys_id) {
		LOAND_SYS_ID = loand_sys_id;
	}

	public String getLOAND_PROD_CODE() {
		return LOAND_PROD_CODE;
	}

	public void setLOAND_PROD_CODE(String LOAND_PROD_CODE) {
		this.LOAND_PROD_CODE = LOAND_PROD_CODE;
	}

	public Double getLOAND_FC_PERM_AMT() {
		return LOAND_FC_PERM_AMT;
	}

	public void setLOAND_FC_PERM_AMT(Double LOAND_FC_PERM_AMT) {
		this.LOAND_FC_PERM_AMT = LOAND_FC_PERM_AMT;
	}

	public Double getLOAND_LC_PERM_AMT() {
		return LOAND_LC_PERM_AMT;
	}

	public void setLOAND_LC_PERM_AMT(Double LOAND_LC_PERM_AMT) {
		this.LOAND_LC_PERM_AMT = LOAND_LC_PERM_AMT;
	}

	public Double getLOAND_FC_AMOUNT() {
		return LOAND_FC_AMOUNT;
	}

	public void setLOAND_FC_AMOUNT(Double LOAND_FC_AMOUNT) {
		this.LOAND_FC_AMOUNT = LOAND_FC_AMOUNT;
	}

	public Double getLOAND_LC_AMOUNT() {
		return LOAND_LC_AMOUNT;
	}

	public void setLOAND_LC_AMOUNT(Double LOAND_LC_AMOUNT) {
		this.LOAND_LC_AMOUNT = LOAND_LC_AMOUNT;
	}

	public String getUI_M_LOAND_PROD_DESC() {
		return UI_M_LOAND_PROD_DESC;
	}

	public void setUI_M_LOAND_PROD_DESC(String UI_M_LOAND_PROD_DESC) {
		this.UI_M_LOAND_PROD_DESC = UI_M_LOAND_PROD_DESC;
	}

	public Double getLOAND_LOAN_SYS_ID() {
		return LOAND_LOAN_SYS_ID;
	}

	public void setLOAND_LOAN_SYS_ID(Double loand_loan_sys_id) {
		LOAND_LOAN_SYS_ID = loand_loan_sys_id;
	}

	public Double getLOAND_POL_SYS_ID() {
		return LOAND_POL_SYS_ID;
	}

	public void setLOAND_POL_SYS_ID(Double loand_pol_sys_id) {
		LOAND_POL_SYS_ID = loand_pol_sys_id;
	}
}
