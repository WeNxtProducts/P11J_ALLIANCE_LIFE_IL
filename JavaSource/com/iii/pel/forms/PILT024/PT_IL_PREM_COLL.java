package com.iii.pel.forms.PILT024;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL extends BaseValueBean {

	@Column(name = "PC_SYS_ID")
	private Long PC_SYS_ID;

	@Column(name = "PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;

	@Column(name = "PC_WAIVE_PREM_YN")
	private String PC_WAIVE_PREM_YN;

	@Column(name = "PC_WAIVE_LOAN_YN")
	private String PC_WAIVE_LOAN_YN;

	@Column(name = "PC_FC_BASIC_PREM")
	private Double PC_FC_BASIC_PREM;

	@Column(name = "PC_LC_BASIC_PREM")
	private Double PC_LC_BASIC_PREM;

	@Column(name = "PC_FC_ADDL_PREM")
	private Double PC_FC_ADDL_PREM;

	@Column(name = "PC_LC_ADDL_PREM")
	private Double PC_LC_ADDL_PREM;

	@Column(name = "PC_FC_LOAD_AMT")
	private Double PC_FC_LOAD_AMT;

	@Column(name = "PC_LC_LOAD_AMT")
	private Double PC_LC_LOAD_AMT;

	private Double UI_M_PC_FC_PAID_LOAD;

	private Double UI_M_PC_LC_PAID_LOAD;

	private Double UI_M_PC_FC_BAL_LOAD_AMT;

	private Double UI_M_PC_LC_BAL_LOAD_AMT;

	@Column(name = "PC_FC_DISCOUNT")
	private Double PC_FC_DISCOUNT;

	@Column(name = "PC_LC_DISCOUNT")
	private Double PC_LC_DISCOUNT;

	private Double UI_M_PC_FC_PAID_DISC;

	private Double UI_M_PC_LC_PAID_DISC;

	private Double UI_M_PC_FC_BAL_DISC;

	@Column(name = "PC_FC_BAL_DISC")
	private Double PC_FC_BAL_DISC;

	private Double UI_M_PC_LC_BAL_DISC;

	@Column(name = "PC_RI_ALLOC_YN")
	private String PC_RI_ALLOC_YN;

	@Column(name = "PC_DOC_NO")
	private String PC_DOC_NO;

	@Column(name = "PC_LC_BAL_GROSS_PREM")
	private Double PC_LC_BAL_GROSS_PREM;

	@Column(name = "PC_FC_CHARGE")
	private Double PC_FC_CHARGE;

	@Column(name = "PC_LC_CHARGE")
	private Double PC_LC_CHARGE;

	private Double UI_M_PC_FC_PAID_CUST_CHRG;

	private Double UI_M_PC_LC_PAID_CUST_CHRG;

	private Double UI_M_PC_FC_BAL_CUST_CHRG;

	private Double UI_M_PC_LC_BAL_CUST_CHRG;

	@Column(name = "PC_FC_DUE_CONTR")
	private Double PC_FC_DUE_CONTR;

	@Column(name = "PC_LC_DUE_CONTR")
	private Double PC_LC_DUE_CONTR;

	@Column(name = "PC_FC_PAID_AMT")
	private Double PC_FC_PAID_AMT;

	@Column(name = "PC_LC_PAID_AMT")
	private Double PC_LC_PAID_AMT;

	@Column(name = "PC_POL_SYS_ID")
	private Long PC_POL_SYS_ID;

	@Column(name = "PC_FC_AVLB_BAL_AMT")
	private Double PC_FC_AVLB_BAL_AMT;

	@Column(name = "PC_PAID_FLAG")
	private String PC_PAID_FLAG;

	@Column(name = "PC_FC_GROSS_PREM")
	private Double PC_FC_GROSS_PREM;

	@Column(name = "PC_FC_INV_DUE_CHRG")
	private Double PC_FC_INV_DUE_CHRG;

	@Column(name = "PC_LC_INV_DUE_CHRG")
	private Double PC_LC_INV_DUE_CHRG;

	private Double UI_M_PC_FC_INV_PAID_CHRG;

	private Double UI_M_PC_LC_INV_PAID_CHRG;

	private Double UI_M_PC_FC_INV_BAL_CHRG;

	private Double UI_M_PC_LC_INV_BAL_CHRG;

	private Double UI_M_PC_FC_PAID_BASIC_PREM;

	private Double UI_M_PC_LC_PAID_BASIC_PREM;

	private Double UI_M_PC_FC_BAL_BASIC_PREM;

	private Double UI_M_PC_LC_BAL_BASIC_PREM;

	private Double UI_M_PC_FC_PAID_ADDL_PREM;

	private Double UI_M_PC_LC_PAID_ADDL_PREM;

	private Double UI_M_PC_FC_BAL_ADDL_PREM;

	private Double UI_M_PC_LC_BAL_ADDL_PREM;

	private Double UI_M_PC_FC_PAID_CONTR;

	private Double UI_M_PC_LC_PAID_CONTR;

	private Double UI_M_PC_FC_BAL_CONTR;

	private Double UI_M_PC_LC_BAL_CONTR;

	private Double UI_M_TOPUP_DUE_FC_AMT;

	private Double UI_M_TOPUP_DUE_LC_AMT;

	private Double UI_M_TOPUP_PAID_FC_AMT;

	private Double UI_M_TOPUP_PAID_LC_AMT;

	private Double UI_M_TOPUP_BAL_LC_AMT;

	private Double UI_M_TOPUP_BAL_FC_AMT;

	@Column(name = "PC_LC_BAL_BASIC_PREM")
	private Double PC_LC_BAL_BASIC_PREM;

	@Column(name = "PC_FC_BAL_BASIC_PREM")
	private Double PC_FC_BAL_BASIC_PREM;

	private Date UI_M_PREV_INST_DUE_DT;

	private Date UI_M_PREV_PAY_DT;

	private Date UI_M_CURR_INV_DUE_DT;

	@Column(name = "PC_PAID_DT")
	private Date PC_PAID_DT;

	@Column(name = "PC_PREM_TYPE")
	private String PC_PREM_TYPE;

	@Column(name = "PC_FAC_CLOSE_FLAG")
	private String PC_FAC_CLOSE_FLAG;

	@Column(name = "PC_RI_CLOSE_FLAG")
	private String PC_RI_CLOSE_FLAG;

	@Column(name = "PC_FC_INV_BAL_CHRG")
	private Double PC_FC_INV_BAL_CHRG;

	@Column(name = "PC_LC_INV_BAL_CHRG")
	private Double PC_LC_INV_BAL_CHRG;

	@Column(name = "PC_END_NO_IDX")
	private Integer PC_END_NO_IDX;

	@Column(name = "PC_FACIN_YN")
	private String PC_FACIN_YN;

	@Column(name = "PC_LC_GROSS_PREM")
	private Double PC_LC_GROSS_PREM;

	@Column(name = "PC_UNPAID_PREM")
	private Double PC_UNPAID_PREM;

	@Column(name = "PC_APPRV_DT")
	private Date PC_APPRV_DT;

	@Column(name = "PC_CR_DT")
	private Date PC_CR_DT;

	@Column(name = "PC_CR_UID")
	private String PC_CR_UID;

	@Column(name = "PC_UNPAID_PREM_INT_CODE")
	private String PC_UNPAID_PREM_INT_CODE;

	@Column(name = "PC_FC_UNPAID_PREM_INT")
	private Double PC_FC_UNPAID_PREM_INT;

	@Column(name = "PC_LC_UNPAID_PREM_INT")
	private Double PC_LC_UNPAID_PREM_INT;

	@Column(name = "PC_REF_NO")
	private String PC_REF_NO;

	@Column(name = "PC_CONT_CODE")
	private String PC_CONT_CODE;

	@Column(name = "PC_FC_CHARGE_AMT")
	private Double PC_FC_CHARGE_AMT;

	@Column(name = "PC_LC_CHARGE_AMT")
	private Double PC_LC_CHARGE_AMT;

	@Column(name = "PC_EXC_INT_PERC")
	private Double PC_EXC_INT_PERC;

	@Column(name = "PC_FC_EXC_INT_AMT")
	private Double PC_FC_EXC_INT_AMT;

	@Column(name = "PC_LC_EXC_INT_AMT")
	private Double PC_LC_EXC_INT_AMT;

	@Column(name = "PC_LC_AVLB_BAL_AMT")
	private Double PC_LC_AVLB_BAL_AMT;

	@Column(name = "PC_DRIP_YN")
	private String PC_DRIP_YN;

	@Column(name = "PC_TEMP_RCPT_NO")
	private String PC_TEMP_RCPT_NO;

	@Column(name = "PC_DRCR_ACNT_YEAR")
	private Integer PC_DRCR_ACNT_YEAR;

	@Column(name = "PC_DRCR_TXN_CODE")
	private String PC_DRCR_TXN_CODE;

	@Column(name = "PC_DRCR_DOC_NO")
	private Integer PC_DRCR_DOC_NO;

	@Column(name = "PC_DRCR_DOC_DT")
	private Date PC_DRCR_DOC_DT;

	@Column(name = "PC_COLL_TYPE")
	private String PC_COLL_TYPE;

	@Column(name = "PC_DU_REF_ID")
	private String PC_DU_REF_ID;

	@Column(name = "PC_UNIT_YN")
	private String PC_UNIT_YN;

	@Column(name = "PC_PREM_HOLIDAY_YN")
	private String PC_PREM_HOLIDAY_YN;

	@Column(name = "PC_LC_PAID_CONTR")
	private Double PC_LC_PAID_CONTR;

	@Column(name = "PC_FC_PAID_CONTR")
	private Double PC_FC_PAID_CONTR;

	@Column(name = "PC_FC_PAID_BASIC_PREM")
	private Double PC_FC_PAID_BASIC_PREM;

	@Column(name = "PC_LC_PAID_BASIC_PREM")
	private Double PC_LC_PAID_BASIC_PREM;

	@Column(name = "PC_FC_PAID_ADDL_PREM")
	private Double PC_FC_PAID_ADDL_PREM;

	@Column(name = "PC_LC_PAID_ADDL_PREM")
	private Double PC_LC_PAID_ADDL_PREM;

	@Column(name = "PC_FC_PAID_LOAD")
	private Double PC_FC_PAID_LOAD;

	@Column(name = "PC_LC_PAID_LOAD")
	private Double PC_LC_PAID_LOAD;

	@Column(name = "PC_LC_PAID_DISC")
	private Double PC_LC_PAID_DISC;

	@Column(name = "PC_FC_PAID_DISC")
	private Double PC_FC_PAID_DISC;

	@Column(name = "PC_FC_PAID_CUST_CHRG")
	private Double PC_FC_PAID_CUST_CHRG;

	@Column(name = "PC_LC_PAID_CUST_CHRG")
	private Double PC_LC_PAID_CUST_CHRG;

	@Column(name = "PC_FC_PAID_GROSS_PREM")
	private Double PC_FC_PAID_GROSS_PREM;

	@Column(name = "PC_LC_PAID_GROSS_PREM")
	private Double PC_LC_PAID_GROSS_PREM;

	@Column(name = "PC_FC_BAL_CONTR")
	private Double PC_FC_BAL_CONTR;

	@Column(name = "PC_LC_BAL_CONTR")
	private Double PC_LC_BAL_CONTR;

	@Column(name = "PC_FC_BAL_CUST_CHRG")
	private Double PC_FC_BAL_CUST_CHRG;

	@Column(name = "PC_LC_BAL_CUST_CHRG")
	private Double PC_LC_BAL_CUST_CHRG;

	@Column(name = "PC_LC_BAL_DISC")
	private Double PC_LC_BAL_DISC;

	@Column(name = "PC_FC_BAL_LOAD_AMT")
	private Double PC_FC_BAL_LOAD_AMT;

	@Column(name = "PC_LC_BAL_LOAD_AMT")
	private Double PC_LC_BAL_LOAD_AMT;

	@Column(name = "PC_FC_BAL_ADDL_PREM")
	private Double PC_FC_BAL_ADDL_PREM;

	@Column(name = "PC_LC_BAL_ADDL_PREM")
	private Double PC_LC_BAL_ADDL_PREM;

	

	@Column(name = "PC_UPD_DT")
	private Date PC_UPD_DT;

	public Double getPC_LC_GROSS_PREM() {
		return PC_LC_GROSS_PREM;
	}

	public void setPC_LC_GROSS_PREM(Double pc_lc_gross_prem) {
		PC_LC_GROSS_PREM = pc_lc_gross_prem;
	}

	public Double getPC_UNPAID_PREM() {
		return PC_UNPAID_PREM;
	}

	public void setPC_UNPAID_PREM(Double pc_unpaid_prem) {
		PC_UNPAID_PREM = pc_unpaid_prem;
	}

	public String getPC_FACIN_YN() {
		return PC_FACIN_YN;
	}

	public void setPC_FACIN_YN(String pc_facin_yn) {
		PC_FACIN_YN = pc_facin_yn;
	}

	public Integer getPC_END_NO_IDX() {
		return PC_END_NO_IDX;
	}

	public void setPC_END_NO_IDX(Integer pc_end_no_idx) {
		PC_END_NO_IDX = pc_end_no_idx;
	}

	public Double getPC_LC_INV_BAL_CHRG() {
		return PC_LC_INV_BAL_CHRG;
	}

	public void setPC_LC_INV_BAL_CHRG(Double pc_lc_inv_bal_chrg) {
		PC_LC_INV_BAL_CHRG = pc_lc_inv_bal_chrg;
	}

	public Double getPC_FC_INV_BAL_CHRG() {
		return PC_FC_INV_BAL_CHRG;
	}

	public void setPC_FC_INV_BAL_CHRG(Double pc_fc_inv_bal_chrg) {
		PC_FC_INV_BAL_CHRG = pc_fc_inv_bal_chrg;
	}

	public String getPC_RI_CLOSE_FLAG() {
		return PC_RI_CLOSE_FLAG;
	}

	public void setPC_RI_CLOSE_FLAG(String pc_ri_close_flag) {
		PC_RI_CLOSE_FLAG = pc_ri_close_flag;
	}

	public String getPC_FAC_CLOSE_FLAG() {
		return PC_FAC_CLOSE_FLAG;
	}

	public void setPC_FAC_CLOSE_FLAG(String pc_fac_close_flag) {
		PC_FAC_CLOSE_FLAG = pc_fac_close_flag;
	}

	public String getPC_PREM_TYPE() {
		return PC_PREM_TYPE;
	}

	public void setPC_PREM_TYPE(String pc_prem_type) {
		PC_PREM_TYPE = pc_prem_type;
	}

	public Date getPC_PAID_DT() {
		return PC_PAID_DT;
	}

	public void setPC_PAID_DT(Date pc_paid_dt) {
		PC_PAID_DT = pc_paid_dt;
	}

	public Date getPC_SCHD_PYMT_DT() {
		return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
	}

	public String getPC_WAIVE_PREM_YN() {
		return PC_WAIVE_PREM_YN;
	}

	public void setPC_WAIVE_PREM_YN(String PC_WAIVE_PREM_YN) {
		this.PC_WAIVE_PREM_YN = PC_WAIVE_PREM_YN;
	}

	public String getPC_WAIVE_LOAN_YN() {
		return PC_WAIVE_LOAN_YN;
	}

	public void setPC_WAIVE_LOAN_YN(String PC_WAIVE_LOAN_YN) {
		this.PC_WAIVE_LOAN_YN = PC_WAIVE_LOAN_YN;
	}

	public Double getPC_FC_BASIC_PREM() {
		return PC_FC_BASIC_PREM;
	}

	public void setPC_FC_BASIC_PREM(Double PC_FC_BASIC_PREM) {
		this.PC_FC_BASIC_PREM = PC_FC_BASIC_PREM;
	}

	public Double getPC_LC_BASIC_PREM() {
		return PC_LC_BASIC_PREM;
	}

	public void setPC_LC_BASIC_PREM(Double PC_LC_BASIC_PREM) {
		this.PC_LC_BASIC_PREM = PC_LC_BASIC_PREM;
	}

	public Double getUI_M_PC_FC_PAID_BASIC_PREM() {
		return UI_M_PC_FC_PAID_BASIC_PREM;
	}

	public void setUI_M_PC_FC_PAID_BASIC_PREM(Double UI_M_PC_FC_PAID_BASIC_PREM) {
		this.UI_M_PC_FC_PAID_BASIC_PREM = UI_M_PC_FC_PAID_BASIC_PREM;
	}

	public Double getUI_M_PC_LC_PAID_BASIC_PREM() {
		return UI_M_PC_LC_PAID_BASIC_PREM;
	}

	public void setUI_M_PC_LC_PAID_BASIC_PREM(Double UI_M_PC_LC_PAID_BASIC_PREM) {
		this.UI_M_PC_LC_PAID_BASIC_PREM = UI_M_PC_LC_PAID_BASIC_PREM;
	}

	public Double getUI_M_PC_FC_BAL_BASIC_PREM() {
		return UI_M_PC_FC_BAL_BASIC_PREM;
	}

	public void setUI_M_PC_FC_BAL_BASIC_PREM(Double UI_M_PC_FC_BAL_BASIC_PREM) {
		this.UI_M_PC_FC_BAL_BASIC_PREM = UI_M_PC_FC_BAL_BASIC_PREM;
	}

	public Double getUI_M_PC_LC_BAL_BASIC_PREM() {
		return UI_M_PC_LC_BAL_BASIC_PREM;
	}

	public void setUI_M_PC_LC_BAL_BASIC_PREM(Double UI_M_PC_LC_BAL_BASIC_PREM) {
		this.UI_M_PC_LC_BAL_BASIC_PREM = UI_M_PC_LC_BAL_BASIC_PREM;
	}

	public Double getPC_FC_ADDL_PREM() {
		return PC_FC_ADDL_PREM;
	}

	public void setPC_FC_ADDL_PREM(Double PC_FC_ADDL_PREM) {
		this.PC_FC_ADDL_PREM = PC_FC_ADDL_PREM;
	}

	public Double getPC_LC_ADDL_PREM() {
		return PC_LC_ADDL_PREM;
	}

	public void setPC_LC_ADDL_PREM(Double PC_LC_ADDL_PREM) {
		this.PC_LC_ADDL_PREM = PC_LC_ADDL_PREM;
	}

	public Double getUI_M_PC_FC_PAID_ADDL_PREM() {
		return UI_M_PC_FC_PAID_ADDL_PREM;
	}

	public void setUI_M_PC_FC_PAID_ADDL_PREM(Double UI_M_PC_FC_PAID_ADDL_PREM) {
		this.UI_M_PC_FC_PAID_ADDL_PREM = UI_M_PC_FC_PAID_ADDL_PREM;
	}

	public Double getUI_M_PC_LC_PAID_ADDL_PREM() {
		return UI_M_PC_LC_PAID_ADDL_PREM;
	}

	public void setUI_M_PC_LC_PAID_ADDL_PREM(Double UI_M_PC_LC_PAID_ADDL_PREM) {
		this.UI_M_PC_LC_PAID_ADDL_PREM = UI_M_PC_LC_PAID_ADDL_PREM;
	}

	public Double getUI_M_PC_FC_BAL_ADDL_PREM() {
		return UI_M_PC_FC_BAL_ADDL_PREM;
	}

	public void setUI_M_PC_FC_BAL_ADDL_PREM(Double UI_M_PC_FC_BAL_ADDL_PREM) {
		this.UI_M_PC_FC_BAL_ADDL_PREM = UI_M_PC_FC_BAL_ADDL_PREM;
	}

	public Double getUI_M_PC_LC_BAL_ADDL_PREM() {
		return UI_M_PC_LC_BAL_ADDL_PREM;
	}

	public void setUI_M_PC_LC_BAL_ADDL_PREM(Double UI_M_PC_LC_BAL_ADDL_PREM) {
		this.UI_M_PC_LC_BAL_ADDL_PREM = UI_M_PC_LC_BAL_ADDL_PREM;
	}

	public Double getPC_FC_LOAD_AMT() {
		return PC_FC_LOAD_AMT;
	}

	public void setPC_FC_LOAD_AMT(Double PC_FC_LOAD_AMT) {
		this.PC_FC_LOAD_AMT = PC_FC_LOAD_AMT;
	}

	public Double getPC_LC_LOAD_AMT() {
		return PC_LC_LOAD_AMT;
	}

	public void setPC_LC_LOAD_AMT(Double PC_LC_LOAD_AMT) {
		this.PC_LC_LOAD_AMT = PC_LC_LOAD_AMT;
	}

	public Double getUI_M_PC_FC_PAID_LOAD() {
		return UI_M_PC_FC_PAID_LOAD;
	}

	public void setUI_M_PC_FC_PAID_LOAD(Double UI_M_PC_FC_PAID_LOAD) {
		this.UI_M_PC_FC_PAID_LOAD = UI_M_PC_FC_PAID_LOAD;
	}

	public Double getUI_M_PC_LC_PAID_LOAD() {
		return UI_M_PC_LC_PAID_LOAD;
	}

	public void setUI_M_PC_LC_PAID_LOAD(Double UI_M_PC_LC_PAID_LOAD) {
		this.UI_M_PC_LC_PAID_LOAD = UI_M_PC_LC_PAID_LOAD;
	}

	public Double getUI_M_PC_FC_BAL_LOAD_AMT() {
		return UI_M_PC_FC_BAL_LOAD_AMT;
	}

	public void setUI_M_PC_FC_BAL_LOAD_AMT(Double UI_M_PC_FC_BAL_LOAD_AMT) {
		this.UI_M_PC_FC_BAL_LOAD_AMT = UI_M_PC_FC_BAL_LOAD_AMT;
	}

	public Double getUI_M_PC_LC_BAL_LOAD_AMT() {
		return UI_M_PC_LC_BAL_LOAD_AMT;
	}

	public void setUI_M_PC_LC_BAL_LOAD_AMT(Double UI_M_PC_LC_BAL_LOAD_AMT) {
		this.UI_M_PC_LC_BAL_LOAD_AMT = UI_M_PC_LC_BAL_LOAD_AMT;
	}

	public Double getPC_FC_DISCOUNT() {
		return PC_FC_DISCOUNT;
	}

	public void setPC_FC_DISCOUNT(Double PC_FC_DISCOUNT) {
		this.PC_FC_DISCOUNT = PC_FC_DISCOUNT;
	}

	public Double getPC_LC_DISCOUNT() {
		return PC_LC_DISCOUNT;
	}

	public void setPC_LC_DISCOUNT(Double PC_LC_DISCOUNT) {
		this.PC_LC_DISCOUNT = PC_LC_DISCOUNT;
	}

	public Double getUI_M_PC_FC_PAID_DISC() {
		return UI_M_PC_FC_PAID_DISC;
	}

	public void setUI_M_PC_FC_PAID_DISC(Double UI_M_PC_FC_PAID_DISC) {
		this.UI_M_PC_FC_PAID_DISC = UI_M_PC_FC_PAID_DISC;
	}

	public Double getUI_M_PC_LC_PAID_DISC() {
		return UI_M_PC_LC_PAID_DISC;
	}

	public void setUI_M_PC_LC_PAID_DISC(Double UI_M_PC_LC_PAID_DISC) {
		this.UI_M_PC_LC_PAID_DISC = UI_M_PC_LC_PAID_DISC;
	}

	public Double getUI_M_PC_FC_BAL_DISC() {
		return UI_M_PC_FC_BAL_DISC;
	}

	public void setUI_M_PC_FC_BAL_DISC(Double UI_M_PC_FC_BAL_DISC) {
		this.UI_M_PC_FC_BAL_DISC = UI_M_PC_FC_BAL_DISC;
	}

	public Double getUI_M_PC_LC_BAL_DISC() {
		return UI_M_PC_LC_BAL_DISC;
	}

	public void setUI_M_PC_LC_BAL_DISC(Double UI_M_PC_LC_BAL_DISC) {
		this.UI_M_PC_LC_BAL_DISC = UI_M_PC_LC_BAL_DISC;
	}

	public Double getPC_FC_CHARGE() {
		return PC_FC_CHARGE;
	}

	public void setPC_FC_CHARGE(Double PC_FC_CHARGE) {
		this.PC_FC_CHARGE = PC_FC_CHARGE;
	}

	public Double getPC_LC_CHARGE() {
		return PC_LC_CHARGE;
	}

	public void setPC_LC_CHARGE(Double PC_LC_CHARGE) {
		this.PC_LC_CHARGE = PC_LC_CHARGE;
	}

	public Double getUI_M_PC_FC_PAID_CUST_CHRG() {
		return UI_M_PC_FC_PAID_CUST_CHRG;
	}

	public void setUI_M_PC_FC_PAID_CUST_CHRG(Double UI_M_PC_FC_PAID_CUST_CHRG) {
		this.UI_M_PC_FC_PAID_CUST_CHRG = UI_M_PC_FC_PAID_CUST_CHRG;
	}

	public Double getUI_M_PC_LC_PAID_CUST_CHRG() {
		return UI_M_PC_LC_PAID_CUST_CHRG;
	}

	public void setUI_M_PC_LC_PAID_CUST_CHRG(Double UI_M_PC_LC_PAID_CUST_CHRG) {
		this.UI_M_PC_LC_PAID_CUST_CHRG = UI_M_PC_LC_PAID_CUST_CHRG;
	}

	public Double getUI_M_PC_FC_BAL_CUST_CHRG() {
		return UI_M_PC_FC_BAL_CUST_CHRG;
	}

	public void setUI_M_PC_FC_BAL_CUST_CHRG(Double UI_M_PC_FC_BAL_CUST_CHRG) {
		this.UI_M_PC_FC_BAL_CUST_CHRG = UI_M_PC_FC_BAL_CUST_CHRG;
	}

	public Double getUI_M_PC_LC_BAL_CUST_CHRG() {
		return UI_M_PC_LC_BAL_CUST_CHRG;
	}

	public void setUI_M_PC_LC_BAL_CUST_CHRG(Double UI_M_PC_LC_BAL_CUST_CHRG) {
		this.UI_M_PC_LC_BAL_CUST_CHRG = UI_M_PC_LC_BAL_CUST_CHRG;
	}

	public Double getPC_FC_DUE_CONTR() {
		return PC_FC_DUE_CONTR;
	}

	public void setPC_FC_DUE_CONTR(Double PC_FC_DUE_CONTR) {
		this.PC_FC_DUE_CONTR = PC_FC_DUE_CONTR;
	}

	public Double getPC_LC_DUE_CONTR() {
		return PC_LC_DUE_CONTR;
	}

	public void setPC_LC_DUE_CONTR(Double PC_LC_DUE_CONTR) {
		this.PC_LC_DUE_CONTR = PC_LC_DUE_CONTR;
	}

	public Double getUI_M_PC_FC_PAID_CONTR() {
		return UI_M_PC_FC_PAID_CONTR;
	}

	public void setUI_M_PC_FC_PAID_CONTR(Double UI_M_PC_FC_PAID_CONTR) {
		this.UI_M_PC_FC_PAID_CONTR = UI_M_PC_FC_PAID_CONTR;
	}

	public Double getUI_M_PC_LC_PAID_CONTR() {
		return UI_M_PC_LC_PAID_CONTR;
	}

	public void setUI_M_PC_LC_PAID_CONTR(Double UI_M_PC_LC_PAID_CONTR) {
		this.UI_M_PC_LC_PAID_CONTR = UI_M_PC_LC_PAID_CONTR;
	}

	public Double getUI_M_PC_FC_BAL_CONTR() {
		return UI_M_PC_FC_BAL_CONTR;
	}

	public void setUI_M_PC_FC_BAL_CONTR(Double UI_M_PC_FC_BAL_CONTR) {
		this.UI_M_PC_FC_BAL_CONTR = UI_M_PC_FC_BAL_CONTR;
	}

	public Double getUI_M_PC_LC_BAL_CONTR() {
		return UI_M_PC_LC_BAL_CONTR;
	}

	public void setUI_M_PC_LC_BAL_CONTR(Double UI_M_PC_LC_BAL_CONTR) {
		this.UI_M_PC_LC_BAL_CONTR = UI_M_PC_LC_BAL_CONTR;
	}

	public Double getUI_M_TOPUP_DUE_FC_AMT() {
		return UI_M_TOPUP_DUE_FC_AMT;
	}

	public void setUI_M_TOPUP_DUE_FC_AMT(Double UI_M_TOPUP_DUE_FC_AMT) {
		this.UI_M_TOPUP_DUE_FC_AMT = UI_M_TOPUP_DUE_FC_AMT;
	}

	public Double getUI_M_TOPUP_DUE_LC_AMT() {
		return UI_M_TOPUP_DUE_LC_AMT;
	}

	public void setUI_M_TOPUP_DUE_LC_AMT(Double UI_M_TOPUP_DUE_LC_AMT) {
		this.UI_M_TOPUP_DUE_LC_AMT = UI_M_TOPUP_DUE_LC_AMT;
	}

	public Double getUI_M_TOPUP_PAID_FC_AMT() {
		return UI_M_TOPUP_PAID_FC_AMT;
	}

	public void setUI_M_TOPUP_PAID_FC_AMT(Double UI_M_TOPUP_PAID_FC_AMT) {
		this.UI_M_TOPUP_PAID_FC_AMT = UI_M_TOPUP_PAID_FC_AMT;
	}

	public Double getUI_M_TOPUP_PAID_LC_AMT() {
		return UI_M_TOPUP_PAID_LC_AMT;
	}

	public void setUI_M_TOPUP_PAID_LC_AMT(Double UI_M_TOPUP_PAID_LC_AMT) {
		this.UI_M_TOPUP_PAID_LC_AMT = UI_M_TOPUP_PAID_LC_AMT;
	}

	public Double getUI_M_TOPUP_BAL_LC_AMT() {
		return UI_M_TOPUP_BAL_LC_AMT;
	}

	public void setUI_M_TOPUP_BAL_LC_AMT(Double UI_M_TOPUP_BAL_LC_AMT) {
		this.UI_M_TOPUP_BAL_LC_AMT = UI_M_TOPUP_BAL_LC_AMT;
	}

	public Double getUI_M_TOPUP_BAL_FC_AMT() {
		return UI_M_TOPUP_BAL_FC_AMT;
	}

	public void setUI_M_TOPUP_BAL_FC_AMT(Double UI_M_TOPUP_BAL_FC_AMT) {
		this.UI_M_TOPUP_BAL_FC_AMT = UI_M_TOPUP_BAL_FC_AMT;
	}

	public Double getPC_FC_INV_DUE_CHRG() {
		return PC_FC_INV_DUE_CHRG;
	}

	public void setPC_FC_INV_DUE_CHRG(Double PC_FC_INV_DUE_CHRG) {
		this.PC_FC_INV_DUE_CHRG = PC_FC_INV_DUE_CHRG;
	}

	public Double getPC_LC_INV_DUE_CHRG() {
		return PC_LC_INV_DUE_CHRG;
	}

	public void setPC_LC_INV_DUE_CHRG(Double PC_LC_INV_DUE_CHRG) {
		this.PC_LC_INV_DUE_CHRG = PC_LC_INV_DUE_CHRG;
	}

	public Double getUI_M_PC_FC_INV_PAID_CHRG() {
		return UI_M_PC_FC_INV_PAID_CHRG;
	}

	public void setUI_M_PC_FC_INV_PAID_CHRG(Double UI_M_PC_FC_INV_PAID_CHRG) {
		this.UI_M_PC_FC_INV_PAID_CHRG = UI_M_PC_FC_INV_PAID_CHRG;
	}

	public Double getUI_M_PC_LC_INV_PAID_CHRG() {
		return UI_M_PC_LC_INV_PAID_CHRG;
	}

	public void setUI_M_PC_LC_INV_PAID_CHRG(Double UI_M_PC_LC_INV_PAID_CHRG) {
		this.UI_M_PC_LC_INV_PAID_CHRG = UI_M_PC_LC_INV_PAID_CHRG;
	}

	public Double getUI_M_PC_FC_INV_BAL_CHRG() {
		return UI_M_PC_FC_INV_BAL_CHRG;
	}

	public void setUI_M_PC_FC_INV_BAL_CHRG(Double UI_M_PC_FC_INV_BAL_CHRG) {
		this.UI_M_PC_FC_INV_BAL_CHRG = UI_M_PC_FC_INV_BAL_CHRG;
	}

	public Double getUI_M_PC_LC_INV_BAL_CHRG() {
		return UI_M_PC_LC_INV_BAL_CHRG;
	}

	public void setUI_M_PC_LC_INV_BAL_CHRG(Double UI_M_PC_LC_INV_BAL_CHRG) {
		this.UI_M_PC_LC_INV_BAL_CHRG = UI_M_PC_LC_INV_BAL_CHRG;
	}

	public Date getUI_M_PREV_INST_DUE_DT() {
		return UI_M_PREV_INST_DUE_DT;
	}

	public void setUI_M_PREV_INST_DUE_DT(Date UI_M_PREV_INST_DUE_DT) {
		this.UI_M_PREV_INST_DUE_DT = UI_M_PREV_INST_DUE_DT;
	}

	public Date getUI_M_PREV_PAY_DT() {
		return UI_M_PREV_PAY_DT;
	}

	public void setUI_M_PREV_PAY_DT(Date UI_M_PREV_PAY_DT) {
		this.UI_M_PREV_PAY_DT = UI_M_PREV_PAY_DT;
	}

	public Date getUI_M_CURR_INV_DUE_DT() {
		return UI_M_CURR_INV_DUE_DT;
	}

	public void setUI_M_CURR_INV_DUE_DT(Date UI_M_CURR_INV_DUE_DT) {
		this.UI_M_CURR_INV_DUE_DT = UI_M_CURR_INV_DUE_DT;
	}

	public Long getPC_SYS_ID() {
		return PC_SYS_ID;
	}

	public void setPC_SYS_ID(Long pc_sys_id) {
		PC_SYS_ID = pc_sys_id;
	}

	public Double getPC_FC_PAID_AMT() {
		return PC_FC_PAID_AMT;
	}

	public void setPC_FC_PAID_AMT(Double pc_fc_paid_amt) {
		PC_FC_PAID_AMT = pc_fc_paid_amt;
	}

	public Double getPC_LC_PAID_AMT() {
		return PC_LC_PAID_AMT;
	}

	public void setPC_LC_PAID_AMT(Double pc_lc_paid_amt) {
		PC_LC_PAID_AMT = pc_lc_paid_amt;
	}

	public Long getPC_POL_SYS_ID() {
		return PC_POL_SYS_ID;
	}

	public void setPC_POL_SYS_ID(Long pc_pol_sys_id) {
		PC_POL_SYS_ID = pc_pol_sys_id;
	}

	public Double getPC_FC_AVLB_BAL_AMT() {
		return PC_FC_AVLB_BAL_AMT;
	}

	public void setPC_FC_AVLB_BAL_AMT(Double pc_fc_avlb_bal_amt) {
		PC_FC_AVLB_BAL_AMT = pc_fc_avlb_bal_amt;
	}

	public String getPC_PAID_FLAG() {
		return PC_PAID_FLAG;
	}

	public void setPC_PAID_FLAG(String pc_paid_flag) {
		PC_PAID_FLAG = pc_paid_flag;
	}

	public Double getPC_FC_GROSS_PREM() {
		return PC_FC_GROSS_PREM;
	}

	public void setPC_FC_GROSS_PREM(Double pc_fc_gross_prem) {
		PC_FC_GROSS_PREM = pc_fc_gross_prem;
	}

	public Date getPC_APPRV_DT() {
		return PC_APPRV_DT;
	}

	public void setPC_APPRV_DT(Date pc_apprv_dt) {
		PC_APPRV_DT = pc_apprv_dt;
	}

	public Date getPC_CR_DT() {
		return PC_CR_DT;
	}

	public void setPC_CR_DT(Date pc_cr_dt) {
		PC_CR_DT = pc_cr_dt;
	}

	public String getPC_CR_UID() {
		return PC_CR_UID;
	}

	public void setPC_CR_UID(String pc_cr_uid) {
		PC_CR_UID = pc_cr_uid;
	}

	public String getPC_UNPAID_PREM_INT_CODE() {
		return PC_UNPAID_PREM_INT_CODE;
	}

	public void setPC_UNPAID_PREM_INT_CODE(String pc_unpaid_prem_int_code) {
		PC_UNPAID_PREM_INT_CODE = pc_unpaid_prem_int_code;
	}

	public Double getPC_FC_UNPAID_PREM_INT() {
		return PC_FC_UNPAID_PREM_INT;
	}

	public void setPC_FC_UNPAID_PREM_INT(Double pc_fc_unpaid_prem_int) {
		PC_FC_UNPAID_PREM_INT = pc_fc_unpaid_prem_int;
	}

	public Double getPC_LC_UNPAID_PREM_INT() {
		return PC_LC_UNPAID_PREM_INT;
	}

	public void setPC_LC_UNPAID_PREM_INT(Double pc_lc_unpaid_prem_int) {
		PC_LC_UNPAID_PREM_INT = pc_lc_unpaid_prem_int;
	}

	public String getPC_REF_NO() {
		return PC_REF_NO;
	}

	public void setPC_REF_NO(String pc_ref_no) {
		PC_REF_NO = pc_ref_no;
	}

	public String getPC_CONT_CODE() {
		return PC_CONT_CODE;
	}

	public void setPC_CONT_CODE(String pc_cont_code) {
		PC_CONT_CODE = pc_cont_code;
	}

	public Double getPC_FC_CHARGE_AMT() {
		return PC_FC_CHARGE_AMT;
	}

	public void setPC_FC_CHARGE_AMT(Double pc_fc_charge_amt) {
		PC_FC_CHARGE_AMT = pc_fc_charge_amt;
	}

	public Double getPC_LC_CHARGE_AMT() {
		return PC_LC_CHARGE_AMT;
	}

	public void setPC_LC_CHARGE_AMT(Double pc_lc_charge_amt) {
		PC_LC_CHARGE_AMT = pc_lc_charge_amt;
	}

	public Double getPC_EXC_INT_PERC() {
		return PC_EXC_INT_PERC;
	}

	public void setPC_EXC_INT_PERC(Double pc_exc_int_perc) {
		PC_EXC_INT_PERC = pc_exc_int_perc;
	}

	public Double getPC_FC_EXC_INT_AMT() {
		return PC_FC_EXC_INT_AMT;
	}

	public void setPC_FC_EXC_INT_AMT(Double pc_fc_exc_int_amt) {
		PC_FC_EXC_INT_AMT = pc_fc_exc_int_amt;
	}

	public Double getPC_LC_EXC_INT_AMT() {
		return PC_LC_EXC_INT_AMT;
	}

	public void setPC_LC_EXC_INT_AMT(Double pc_lc_exc_int_amt) {
		PC_LC_EXC_INT_AMT = pc_lc_exc_int_amt;
	}

	public Double getPC_LC_AVLB_BAL_AMT() {
		return PC_LC_AVLB_BAL_AMT;
	}

	public void setPC_LC_AVLB_BAL_AMT(Double pc_lc_avlb_bal_amt) {
		PC_LC_AVLB_BAL_AMT = pc_lc_avlb_bal_amt;
	}

	public String getPC_DRIP_YN() {
		return PC_DRIP_YN;
	}

	public void setPC_DRIP_YN(String pc_drip_yn) {
		PC_DRIP_YN = pc_drip_yn;
	}

	public String getPC_TEMP_RCPT_NO() {
		return PC_TEMP_RCPT_NO;
	}

	public void setPC_TEMP_RCPT_NO(String pc_temp_rcpt_no) {
		PC_TEMP_RCPT_NO = pc_temp_rcpt_no;
	}

	public Integer getPC_DRCR_ACNT_YEAR() {
		return PC_DRCR_ACNT_YEAR;
	}

	public void setPC_DRCR_ACNT_YEAR(Integer pc_drcr_acnt_year) {
		PC_DRCR_ACNT_YEAR = pc_drcr_acnt_year;
	}

	public String getPC_DRCR_TXN_CODE() {
		return PC_DRCR_TXN_CODE;
	}

	public void setPC_DRCR_TXN_CODE(String pc_drcr_txn_code) {
		PC_DRCR_TXN_CODE = pc_drcr_txn_code;
	}

	public Integer getPC_DRCR_DOC_NO() {
		return PC_DRCR_DOC_NO;
	}

	public void setPC_DRCR_DOC_NO(Integer pc_drcr_doc_no) {
		PC_DRCR_DOC_NO = pc_drcr_doc_no;
	}

	public Date getPC_DRCR_DOC_DT() {
		return PC_DRCR_DOC_DT;
	}

	public void setPC_DRCR_DOC_DT(Date pc_drcr_doc_dt) {
		PC_DRCR_DOC_DT = pc_drcr_doc_dt;
	}

	public String getPC_COLL_TYPE() {
		return PC_COLL_TYPE;
	}

	public void setPC_COLL_TYPE(String pc_coll_type) {
		PC_COLL_TYPE = pc_coll_type;
	}

	public String getPC_DU_REF_ID() {
		return PC_DU_REF_ID;
	}

	public void setPC_DU_REF_ID(String pc_du_ref_id) {
		PC_DU_REF_ID = pc_du_ref_id;
	}

	public String getPC_UNIT_YN() {
		return PC_UNIT_YN;
	}

	public void setPC_UNIT_YN(String pc_unit_yn) {
		PC_UNIT_YN = pc_unit_yn;
	}

	public String getPC_PREM_HOLIDAY_YN() {
		return PC_PREM_HOLIDAY_YN;
	}

	public void setPC_PREM_HOLIDAY_YN(String pc_prem_holiday_yn) {
		PC_PREM_HOLIDAY_YN = pc_prem_holiday_yn;
	}

	public Double getPC_LC_PAID_CONTR() {
		return PC_LC_PAID_CONTR;
	}

	public void setPC_LC_PAID_CONTR(Double pc_lc_paid_contr) {
		PC_LC_PAID_CONTR = pc_lc_paid_contr;
	}

	public Double getPC_FC_PAID_CONTR() {
		return PC_FC_PAID_CONTR;
	}

	public void setPC_FC_PAID_CONTR(Double pc_fc_paid_contr) {
		PC_FC_PAID_CONTR = pc_fc_paid_contr;
	}

	public Double getPC_FC_PAID_BASIC_PREM() {
		return PC_FC_PAID_BASIC_PREM;
	}

	public void setPC_FC_PAID_BASIC_PREM(Double pc_fc_paid_basic_prem) {
		PC_FC_PAID_BASIC_PREM = pc_fc_paid_basic_prem;
	}

	public Double getPC_LC_PAID_BASIC_PREM() {
		return PC_LC_PAID_BASIC_PREM;
	}

	public void setPC_LC_PAID_BASIC_PREM(Double pc_lc_paid_basic_prem) {
		PC_LC_PAID_BASIC_PREM = pc_lc_paid_basic_prem;
	}

	public Double getPC_FC_PAID_ADDL_PREM() {
		return PC_FC_PAID_ADDL_PREM;
	}

	public void setPC_FC_PAID_ADDL_PREM(Double pc_fc_paid_addl_prem) {
		PC_FC_PAID_ADDL_PREM = pc_fc_paid_addl_prem;
	}

	public Double getPC_LC_PAID_ADDL_PREM() {
		return PC_LC_PAID_ADDL_PREM;
	}

	public void setPC_LC_PAID_ADDL_PREM(Double pc_lc_paid_addl_prem) {
		PC_LC_PAID_ADDL_PREM = pc_lc_paid_addl_prem;
	}

	public Double getPC_FC_PAID_LOAD() {
		return PC_FC_PAID_LOAD;
	}

	public void setPC_FC_PAID_LOAD(Double pc_fc_paid_load) {
		PC_FC_PAID_LOAD = pc_fc_paid_load;
	}

	public Double getPC_LC_PAID_LOAD() {
		return PC_LC_PAID_LOAD;
	}

	public void setPC_LC_PAID_LOAD(Double pc_lc_paid_load) {
		PC_LC_PAID_LOAD = pc_lc_paid_load;
	}

	public Double getPC_LC_PAID_DISC() {
		return PC_LC_PAID_DISC;
	}

	public void setPC_LC_PAID_DISC(Double pc_lc_paid_disc) {
		PC_LC_PAID_DISC = pc_lc_paid_disc;
	}

	public Double getPC_FC_PAID_DISC() {
		return PC_FC_PAID_DISC;
	}

	public void setPC_FC_PAID_DISC(Double pc_fc_paid_disc) {
		PC_FC_PAID_DISC = pc_fc_paid_disc;
	}

	public Double getPC_FC_PAID_CUST_CHRG() {
		return PC_FC_PAID_CUST_CHRG;
	}

	public void setPC_FC_PAID_CUST_CHRG(Double pc_fc_paid_cust_chrg) {
		PC_FC_PAID_CUST_CHRG = pc_fc_paid_cust_chrg;
	}

	public Double getPC_LC_PAID_CUST_CHRG() {
		return PC_LC_PAID_CUST_CHRG;
	}

	public void setPC_LC_PAID_CUST_CHRG(Double pc_lc_paid_cust_chrg) {
		PC_LC_PAID_CUST_CHRG = pc_lc_paid_cust_chrg;
	}

	public Double getPC_FC_PAID_GROSS_PREM() {
		return PC_FC_PAID_GROSS_PREM;
	}

	public void setPC_FC_PAID_GROSS_PREM(Double pc_fc_paid_gross_prem) {
		PC_FC_PAID_GROSS_PREM = pc_fc_paid_gross_prem;
	}

	public Double getPC_LC_PAID_GROSS_PREM() {
		return PC_LC_PAID_GROSS_PREM;
	}

	public void setPC_LC_PAID_GROSS_PREM(Double pc_lc_paid_gross_prem) {
		PC_LC_PAID_GROSS_PREM = pc_lc_paid_gross_prem;
	}

	public Double getPC_FC_BAL_CONTR() {
		return PC_FC_BAL_CONTR;
	}

	public void setPC_FC_BAL_CONTR(Double pc_fc_bal_contr) {
		PC_FC_BAL_CONTR = pc_fc_bal_contr;
	}

	public Double getPC_LC_BAL_CONTR() {
		return PC_LC_BAL_CONTR;
	}

	public void setPC_LC_BAL_CONTR(Double pc_lc_bal_contr) {
		PC_LC_BAL_CONTR = pc_lc_bal_contr;
	}

	public Double getPC_FC_BAL_CUST_CHRG() {
		return PC_FC_BAL_CUST_CHRG;
	}

	public void setPC_FC_BAL_CUST_CHRG(Double pc_fc_bal_cust_chrg) {
		PC_FC_BAL_CUST_CHRG = pc_fc_bal_cust_chrg;
	}

	public Double getPC_LC_BAL_CUST_CHRG() {
		return PC_LC_BAL_CUST_CHRG;
	}

	public void setPC_LC_BAL_CUST_CHRG(Double pc_lc_bal_cust_chrg) {
		PC_LC_BAL_CUST_CHRG = pc_lc_bal_cust_chrg;
	}

	public Double getPC_LC_BAL_DISC() {
		return PC_LC_BAL_DISC;
	}

	public void setPC_LC_BAL_DISC(Double pc_lc_bal_disc) {
		PC_LC_BAL_DISC = pc_lc_bal_disc;
	}

	public Double getPC_FC_BAL_LOAD_AMT() {
		return PC_FC_BAL_LOAD_AMT;
	}

	public void setPC_FC_BAL_LOAD_AMT(Double pc_fc_bal_load_amt) {
		PC_FC_BAL_LOAD_AMT = pc_fc_bal_load_amt;
	}

	public Double getPC_LC_BAL_LOAD_AMT() {
		return PC_LC_BAL_LOAD_AMT;
	}

	public void setPC_LC_BAL_LOAD_AMT(Double pc_lc_bal_load_amt) {
		PC_LC_BAL_LOAD_AMT = pc_lc_bal_load_amt;
	}

	public Double getPC_FC_BAL_ADDL_PREM() {
		return PC_FC_BAL_ADDL_PREM;
	}

	public void setPC_FC_BAL_ADDL_PREM(Double pc_fc_bal_addl_prem) {
		PC_FC_BAL_ADDL_PREM = pc_fc_bal_addl_prem;
	}

	public Double getPC_LC_BAL_ADDL_PREM() {
		return PC_LC_BAL_ADDL_PREM;
	}

	public void setPC_LC_BAL_ADDL_PREM(Double pc_lc_bal_addl_prem) {
		PC_LC_BAL_ADDL_PREM = pc_lc_bal_addl_prem;
	}

	

	public Date getPC_UPD_DT() {
		return PC_UPD_DT;
	}

	public void setPC_UPD_DT(Date pc_upd_dt) {
		PC_UPD_DT = pc_upd_dt;
	}

	public String getPC_RI_ALLOC_YN() {
		return PC_RI_ALLOC_YN;
	}

	public void setPC_RI_ALLOC_YN(String pc_ri_alloc_yn) {
		PC_RI_ALLOC_YN = pc_ri_alloc_yn;
	}

	public String getPC_DOC_NO() {
		return PC_DOC_NO;
	}

	public void setPC_DOC_NO(String pc_doc_no) {
		PC_DOC_NO = pc_doc_no;
	}

	public Double getPC_LC_BAL_GROSS_PREM() {
		return PC_LC_BAL_GROSS_PREM;
	}

	public void setPC_LC_BAL_GROSS_PREM(Double pc_lc_bal_gross_prem) {
		PC_LC_BAL_GROSS_PREM = pc_lc_bal_gross_prem;
	}

	public Double getPC_FC_BAL_DISC() {
		return PC_FC_BAL_DISC;
	}

	public void setPC_FC_BAL_DISC(Double pc_fc_bal_disc) {
		PC_FC_BAL_DISC = pc_fc_bal_disc;
	}

	public Double getPC_LC_BAL_BASIC_PREM() {
		return PC_LC_BAL_BASIC_PREM;
	}

	public void setPC_LC_BAL_BASIC_PREM(Double pc_lc_bal_basic_prem) {
		PC_LC_BAL_BASIC_PREM = pc_lc_bal_basic_prem;
	}

	public Double getPC_FC_BAL_BASIC_PREM() {
		return PC_FC_BAL_BASIC_PREM;
	}

	public void setPC_FC_BAL_BASIC_PREM(Double pc_fc_bal_basic_prem) {
		PC_FC_BAL_BASIC_PREM = pc_fc_bal_basic_prem;
	}
}