package com.iii.pel.forms.PILT020;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL extends BaseValueBean {

	@Column(name="PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;

	@Column(name="PC_PAID_DT")
	private Date PC_PAID_DT;
	

	@Column(name="PC_FAC_CLOSE_FLAG")
	private String PC_FAC_CLOSE_FLAG;
	
	@Column(name="PC_RI_CLOSE_FLAG")
	private String PC_RI_CLOSE_FLAG;
	
	@Column(name="PC_UPD_DT")
	private Date PC_UPD_DT;
	
	@Column(name="PC_UPD_UID")
	private String PC_UPD_UID;
	
	private Double UI_M_FC_NET_PREM;

	@Column(name="PC_FC_AVLB_BAL_AMT")
	private Double PC_FC_AVLB_BAL_AMT;

	@Column(name="PC_FC_PAID_AMT")
	private Double PC_FC_PAID_AMT;

	@Column(name="PC_LC_PAID_AMT")
	private Double PC_LC_PAID_AMT;

	@Column(name="PC_PAID_FLAG")
	private String PC_PAID_FLAG;

	@Column(name="PC_REF_NO")
	private String PC_REF_NO;

	private String UI_M_POL_CUST_EXCH_RATE;

	private String UI_M_POL_CUST_CURR_CODE;

	@Column(name="PC_FC_BASIC_PREM")
	private Double PC_FC_BASIC_PREM;

	@Column(name="PC_LC_BASIC_PREM")
	private Double PC_LC_BASIC_PREM;

	@Column(name="PC_FC_CHARGE_AMT")
	private Double PC_FC_CHARGE_AMT;

	@Column(name="PC_LC_CHARGE_AMT")
	private Double PC_LC_CHARGE_AMT;

	@Column(name="PC_FC_ADDL_PREM")
	private Double PC_FC_ADDL_PREM;
	
	private int LIC_LOAN_SYS_ID;


	@Column(name="PC_LC_ADDL_PREM")
	private Double PC_LC_ADDL_PREM;

	@Column(name="PC_FC_CHARGE")
	private Double PC_FC_CHARGE;

	@Column(name="PC_LC_CHARGE")
	private Double PC_LC_CHARGE;

	@Column(name="PC_FC_LOAD_AMT")
	private Double PC_FC_LOAD_AMT;

	@Column(name="PC_LC_LOAD_AMT")
	private Double PC_LC_LOAD_AMT;

	@Column(name="PC_FC_DISCOUNT")
	private Double PC_FC_DISCOUNT;

	@Column(name="PC_LC_DISCOUNT")
	private Double PC_LC_DISCOUNT;

	@Column(name="PC_FC_GROSS_PREM")
	private Double PC_FC_GROSS_PREM;

	@Column(name="PC_LC_GROSS_PREM")
	private Double PC_LC_GROSS_PREM;

	private Double UI_M_FC_LOAN_INT;

	private Double UI_M_LC_LOAN_INT;

	@Column(name="PC_FC_UNPAID_PREM_INT")
	private Double PC_FC_UNPAID_PREM_INT;

	@Column(name="PC_LC_UNPAID_PREM_INT")
	private Double PC_LC_UNPAID_PREM_INT;

	private Double UI_M_LC_NET_PREM;

	@Column(name="PC_LC_AVLB_BAL_AMT")
	private Double PC_LC_AVLB_BAL_AMT;

	private String UI_M_PC_POL_NO;

	@Column(name="PC_SYS_ID")
	private Integer PC_SYS_ID;
	
	@Column(name="PC_POL_SYS_ID")
	private Double PC_POL_SYS_ID;
	
	@Column(name="PC_PREM_TYPE")
	private String PC_PREM_TYPE;
	 
	private boolean checked;
	
	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
	}

	public Date getPC_PAID_DT() {
		 return PC_PAID_DT;
	}

	public void setPC_PAID_DT(Date PC_PAID_DT) {
		this.PC_PAID_DT = PC_PAID_DT;
	}

	public Double getUI_M_FC_NET_PREM() {
		return UI_M_FC_NET_PREM;
	}

	public void setUI_M_FC_NET_PREM(Double UI_M_FC_NET_PREM) {
		this.UI_M_FC_NET_PREM = UI_M_FC_NET_PREM;
	}

	public Double getPC_FC_AVLB_BAL_AMT() {
		return PC_FC_AVLB_BAL_AMT;
	}

	public void setPC_FC_AVLB_BAL_AMT(Double PC_FC_AVLB_BAL_AMT) {
		this.PC_FC_AVLB_BAL_AMT = PC_FC_AVLB_BAL_AMT;
	}

	public Double getPC_FC_PAID_AMT() {
		return PC_FC_PAID_AMT;
	}

	public void setPC_FC_PAID_AMT(Double PC_FC_PAID_AMT) {
		this.PC_FC_PAID_AMT = PC_FC_PAID_AMT;
	}

	public Double getPC_LC_PAID_AMT() {
		return PC_LC_PAID_AMT;
	}

	public void setPC_LC_PAID_AMT(Double PC_LC_PAID_AMT) {
		this.PC_LC_PAID_AMT = PC_LC_PAID_AMT;
	}

	public String getPC_PAID_FLAG() {
		return PC_PAID_FLAG;
	}

	public void setPC_PAID_FLAG(String PC_PAID_FLAG) {
		this.PC_PAID_FLAG = PC_PAID_FLAG;
	}

	public String getPC_REF_NO() {
		return PC_REF_NO;
	}

	public void setPC_REF_NO(String PC_REF_NO) {
		this.PC_REF_NO = PC_REF_NO;
	}

	public String getUI_M_POL_CUST_EXCH_RATE() {
		return UI_M_POL_CUST_EXCH_RATE;
	}

	public void setUI_M_POL_CUST_EXCH_RATE(String UI_M_POL_CUST_EXCH_RATE) {
		this.UI_M_POL_CUST_EXCH_RATE = UI_M_POL_CUST_EXCH_RATE;
	}

	public String getUI_M_POL_CUST_CURR_CODE() {
		return UI_M_POL_CUST_CURR_CODE;
	}

	public void setUI_M_POL_CUST_CURR_CODE(String UI_M_POL_CUST_CURR_CODE) {
		this.UI_M_POL_CUST_CURR_CODE = UI_M_POL_CUST_CURR_CODE;
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

	public Double getPC_FC_CHARGE_AMT() {
		return PC_FC_CHARGE_AMT;
	}

	public void setPC_FC_CHARGE_AMT(Double PC_FC_CHARGE_AMT) {
		this.PC_FC_CHARGE_AMT = PC_FC_CHARGE_AMT;
	}

	public Double getPC_LC_CHARGE_AMT() {
		return PC_LC_CHARGE_AMT;
	}

	public void setPC_LC_CHARGE_AMT(Double PC_LC_CHARGE_AMT) {
		this.PC_LC_CHARGE_AMT = PC_LC_CHARGE_AMT;
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

	public Double getPC_FC_GROSS_PREM() {
		return PC_FC_GROSS_PREM;
	}

	public void setPC_FC_GROSS_PREM(Double PC_FC_GROSS_PREM) {
		this.PC_FC_GROSS_PREM = PC_FC_GROSS_PREM;
	}

	public Double getPC_LC_GROSS_PREM() {
		return PC_LC_GROSS_PREM;
	}

	public void setPC_LC_GROSS_PREM(Double PC_LC_GROSS_PREM) {
		this.PC_LC_GROSS_PREM = PC_LC_GROSS_PREM;
	}

	public Double getUI_M_FC_LOAN_INT() {
		return UI_M_FC_LOAN_INT;
	}

	public void setUI_M_FC_LOAN_INT(Double UI_M_FC_LOAN_INT) {
		this.UI_M_FC_LOAN_INT = UI_M_FC_LOAN_INT;
	}

	public Double getUI_M_LC_LOAN_INT() {
		return UI_M_LC_LOAN_INT;
	}

	public void setUI_M_LC_LOAN_INT(Double UI_M_LC_LOAN_INT) {
		this.UI_M_LC_LOAN_INT = UI_M_LC_LOAN_INT;
	}

	public Double getPC_FC_UNPAID_PREM_INT() {
		return PC_FC_UNPAID_PREM_INT;
	}

	public void setPC_FC_UNPAID_PREM_INT(Double PC_FC_UNPAID_PREM_INT) {
		this.PC_FC_UNPAID_PREM_INT = PC_FC_UNPAID_PREM_INT;
	}

	public Double getPC_LC_UNPAID_PREM_INT() {
		return PC_LC_UNPAID_PREM_INT;
	}

	public void setPC_LC_UNPAID_PREM_INT(Double PC_LC_UNPAID_PREM_INT) {
		this.PC_LC_UNPAID_PREM_INT = PC_LC_UNPAID_PREM_INT;
	}

	public Double getUI_M_LC_NET_PREM() {
		return UI_M_LC_NET_PREM;
	}

	public void setUI_M_LC_NET_PREM(Double UI_M_LC_NET_PREM) {
		this.UI_M_LC_NET_PREM = UI_M_LC_NET_PREM;
	}

	public Double getPC_LC_AVLB_BAL_AMT() {
		return PC_LC_AVLB_BAL_AMT;
	}

	public void setPC_LC_AVLB_BAL_AMT(Double PC_LC_AVLB_BAL_AMT) {
		this.PC_LC_AVLB_BAL_AMT = PC_LC_AVLB_BAL_AMT;
	}

	public String getUI_M_PC_POL_NO() {
		return UI_M_PC_POL_NO;
	}

	public void setUI_M_PC_POL_NO(String UI_M_PC_POL_NO) {
		this.UI_M_PC_POL_NO = UI_M_PC_POL_NO;
	}

	public Double getPC_POL_SYS_ID() {
		return PC_POL_SYS_ID;
	}

	public void setPC_POL_SYS_ID(Double pc_pol_sys_id) {
		PC_POL_SYS_ID = pc_pol_sys_id;
	}

	public String getPC_PREM_TYPE() {
		return PC_PREM_TYPE;
	}

	public void setPC_PREM_TYPE(String pc_prem_type) {
		PC_PREM_TYPE = pc_prem_type;
	}

	public Date getPC_UPD_DT() {
		return PC_UPD_DT;
	}

	public void setPC_UPD_DT(Date pc_upd_dt) {
		PC_UPD_DT = pc_upd_dt;
	}

	public String getPC_UPD_UID() {
		return PC_UPD_UID;
	}

	public void setPC_UPD_UID(String pc_upd_uid) {
		PC_UPD_UID = pc_upd_uid;
	}

	public Integer getPC_SYS_ID() {
		return PC_SYS_ID;
	}

	public void setPC_SYS_ID(Integer pc_sys_id) {
		PC_SYS_ID = pc_sys_id;
	}

	public int getLIC_LOAN_SYS_ID() {
		return LIC_LOAN_SYS_ID;
	}

	public void setLIC_LOAN_SYS_ID(int lic_loan_sys_id) {
		LIC_LOAN_SYS_ID = lic_loan_sys_id;
	}

	public String getPC_FAC_CLOSE_FLAG() {
		return PC_FAC_CLOSE_FLAG;
	}

	public void setPC_FAC_CLOSE_FLAG(String pc_fac_close_flag) {
		PC_FAC_CLOSE_FLAG = pc_fac_close_flag;
	}

	public String getPC_RI_CLOSE_FLAG() {
		return PC_RI_CLOSE_FLAG;
	}

	public void setPC_RI_CLOSE_FLAG(String pc_ri_close_flag) {
		PC_RI_CLOSE_FLAG = pc_ri_close_flag;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
