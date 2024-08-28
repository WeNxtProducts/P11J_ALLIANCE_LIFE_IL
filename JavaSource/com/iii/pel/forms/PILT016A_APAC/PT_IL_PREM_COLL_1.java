package com.iii.pel.forms.PILT016A_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL_1 extends BaseValueBean {

	@Column(name="PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;

	private Double UI_M_LC_NET_PREM;

	@Column(name="PC_LC_AVLB_BAL_AMT")
	private Double PC_LC_AVLB_BAL_AMT;
	
	@Column(name="PC_LC_GROSS_PREM")
	private Double PC_LC_GROSS_PREM;
	
	@Column(name="PC_LC_CHARGE")
	private Double PC_LC_CHARGE;
	
	@Column(name="PC_LC_UNPAID_PREM_INT")
	private Double PC_LC_UNPAID_PREM_INT;
	
	@Column(name="PC_LC_BASIC_PREM")
	private Double PC_LC_BASIC_PREM;
	
	@Column(name="PC_LC_ADDL_PREM")
	private Double PC_LC_ADDL_PREM;
	
	@Column(name="PC_LC_LOAD_AMT")
	private Double PC_LC_LOAD_AMT;
	
	@Column(name="PC_LC_DISCOUNT")
	private Double PC_LC_DISCOUNT;
	
	@Column(name="PC_SYS_ID")
	private Long PC_SYS_ID;
	
	@Column(name="PC_POL_SYS_ID")
	private Long PC_POL_SYS_ID;
	

	@Column(name="PC_PAID_FLAG")
	private String PC_PAID_FLAG;

	@Column(name="PC_PREM_HOLIDAY_YN")
	private String PC_PREM_HOLIDAY_YN;

	private Double UI_M_TOT_OUT_LC_AMT;

	private Double UI_M_PROP_AVLB;
	private Double UI_M_POL_AVLB;


	private String UI_M_PC_SCHD_PYMT_DT;

	public Double getUI_M_POL_AVLB() {
		return UI_M_POL_AVLB;
	}

	public void setUI_M_POL_AVLB(Double ui_m_pol_avlb) {
		UI_M_POL_AVLB = ui_m_pol_avlb;
	}

	public Double getUI_M_PROP_AVLB() {
		return UI_M_PROP_AVLB;
	}

	public void setUI_M_PROP_AVLB(Double ui_m_prop_avlb) {
		UI_M_PROP_AVLB = ui_m_prop_avlb;
	}

	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
		setUI_M_PC_SCHD_PYMT_DT(CommonUtils.dateToPELStringFormatter(PC_SCHD_PYMT_DT));
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

	public String getPC_PAID_FLAG() {
		return PC_PAID_FLAG;
	}

	public void setPC_PAID_FLAG(String PC_PAID_FLAG) {
		this.PC_PAID_FLAG = PC_PAID_FLAG;
	}

	public String getPC_PREM_HOLIDAY_YN() {
		return PC_PREM_HOLIDAY_YN;
	}

	public void setPC_PREM_HOLIDAY_YN(String PC_PREM_HOLIDAY_YN) {
		this.PC_PREM_HOLIDAY_YN = PC_PREM_HOLIDAY_YN;
	}

	public Double getUI_M_TOT_OUT_LC_AMT() {
		return UI_M_TOT_OUT_LC_AMT;
	}

	public void setUI_M_TOT_OUT_LC_AMT(Double UI_M_TOT_OUT_LC_AMT) {
		this.UI_M_TOT_OUT_LC_AMT = UI_M_TOT_OUT_LC_AMT;
	}

	public Double getPC_LC_GROSS_PREM() {
		return PC_LC_GROSS_PREM;
	}

	public void setPC_LC_GROSS_PREM(Double pc_lc_gross_prem) {
		PC_LC_GROSS_PREM = pc_lc_gross_prem;
	}

	public Double getPC_LC_CHARGE() {
		return PC_LC_CHARGE;
	}

	public void setPC_LC_CHARGE(Double pc_lc_charge) {
		PC_LC_CHARGE = pc_lc_charge;
	}

	public Double getPC_LC_UNPAID_PREM_INT() {
		return PC_LC_UNPAID_PREM_INT;
	}

	public void setPC_LC_UNPAID_PREM_INT(Double pc_lc_unpaid_prem_int) {
		PC_LC_UNPAID_PREM_INT = pc_lc_unpaid_prem_int;
	}

	public Double getPC_LC_BASIC_PREM() {
		return PC_LC_BASIC_PREM;
	}

	public void setPC_LC_BASIC_PREM(Double pc_lc_basic_prem) {
		PC_LC_BASIC_PREM = pc_lc_basic_prem;
	}

	public Double getPC_LC_ADDL_PREM() {
		return PC_LC_ADDL_PREM;
	}

	public void setPC_LC_ADDL_PREM(Double pc_lc_addl_prem) {
		PC_LC_ADDL_PREM = pc_lc_addl_prem;
	}

	public Double getPC_LC_LOAD_AMT() {
		return PC_LC_LOAD_AMT;
	}

	public void setPC_LC_LOAD_AMT(Double pc_lc_load_amt) {
		PC_LC_LOAD_AMT = pc_lc_load_amt;
	}

	public Double getPC_LC_DISCOUNT() {
		return PC_LC_DISCOUNT;
	}

	public void setPC_LC_DISCOUNT(Double pc_lc_discount) {
		PC_LC_DISCOUNT = pc_lc_discount;
	}

	/**
	 * @return the pC_SYS_ID
	 */
	public Long getPC_SYS_ID() {
		return PC_SYS_ID;
	}

	/**
	 * @param pc_sys_id the pC_SYS_ID to set
	 */
	public void setPC_SYS_ID(Long pc_sys_id) {
		PC_SYS_ID = pc_sys_id;
	}

	/**
	 * @return the pC_POL_SYS_ID
	 */
	public Long getPC_POL_SYS_ID() {
		return PC_POL_SYS_ID;
	}

	/**
	 * @param pc_pol_sys_id the pC_POL_SYS_ID to set
	 */
	public void setPC_POL_SYS_ID(Long pc_pol_sys_id) {
		PC_POL_SYS_ID = pc_pol_sys_id;
	}

	public String getUI_M_PC_SCHD_PYMT_DT() {
		return UI_M_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_PC_SCHD_PYMT_DT(String ui_m_pc_schd_pymt_dt) {
		UI_M_PC_SCHD_PYMT_DT = ui_m_pc_schd_pymt_dt;
	}
}
