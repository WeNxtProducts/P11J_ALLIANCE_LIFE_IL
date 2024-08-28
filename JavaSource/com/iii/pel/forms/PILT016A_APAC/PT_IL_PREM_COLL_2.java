package com.iii.pel.forms.PILT016A_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL_2 extends BaseValueBean {

	@Column(name="PC_LC_BASIC_PREM")
	private Double PC_LC_BASIC_PREM;

	@Column(name="PC_LC_ADDL_PREM")
	private Double PC_LC_ADDL_PREM;

	@Column(name="PC_LC_LOAD_AMT")
	private Double PC_LC_LOAD_AMT;

	@Column(name="PC_LC_DISCOUNT")
	private Double PC_LC_DISCOUNT;

	@Column(name="PC_LC_CHARGE")
	private Double PC_LC_CHARGE;

	@Column(name="PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;

	@Column(name="PC_LC_AVLB_BAL_AMT")
	private Double PC_LC_AVLB_BAL_AMT;

	private Double UI_M_LC_NET_PREM;

	@Column(name="PC_LC_PAID_AMT")
	private Double PC_LC_PAID_AMT;

	@Column(name="PC_DRCR_DOC_NO")
	private Integer PC_DRCR_DOC_NO;

	@Column(name="PC_DRCR_DOC_DT")
	private Date PC_DRCR_DOC_DT;

	@Column(name="PC_PAID_FLAG")
	private String PC_PAID_FLAG;

	@Column(name="PC_PREM_HOLIDAY_YN")
	private String PC_PREM_HOLIDAY_YN;



	public Double getPC_LC_BASIC_PREM() {
		return PC_LC_BASIC_PREM;
	}

	public void setPC_LC_BASIC_PREM(Double PC_LC_BASIC_PREM) {
		this.PC_LC_BASIC_PREM = PC_LC_BASIC_PREM;
	}

	public Double getPC_LC_ADDL_PREM() {
		return PC_LC_ADDL_PREM;
	}

	public void setPC_LC_ADDL_PREM(Double PC_LC_ADDL_PREM) {
		this.PC_LC_ADDL_PREM = PC_LC_ADDL_PREM;
	}

	public Double getPC_LC_LOAD_AMT() {
		return PC_LC_LOAD_AMT;
	}

	public void setPC_LC_LOAD_AMT(Double PC_LC_LOAD_AMT) {
		this.PC_LC_LOAD_AMT = PC_LC_LOAD_AMT;
	}

	public Double getPC_LC_DISCOUNT() {
		return PC_LC_DISCOUNT;
	}

	public void setPC_LC_DISCOUNT(Double PC_LC_DISCOUNT) {
		this.PC_LC_DISCOUNT = PC_LC_DISCOUNT;
	}

	public Double getPC_LC_CHARGE() {
		return PC_LC_CHARGE;
	}

	public void setPC_LC_CHARGE(Double PC_LC_CHARGE) {
		this.PC_LC_CHARGE = PC_LC_CHARGE;
	}

	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
	}

	public Double getPC_LC_AVLB_BAL_AMT() {
		return PC_LC_AVLB_BAL_AMT;
	}

	public void setPC_LC_AVLB_BAL_AMT(Double PC_LC_AVLB_BAL_AMT) {
		this.PC_LC_AVLB_BAL_AMT = PC_LC_AVLB_BAL_AMT;
	}

	public Double getUI_M_LC_NET_PREM() {
		return UI_M_LC_NET_PREM;
	}

	public void setUI_M_LC_NET_PREM(Double UI_M_LC_NET_PREM) {
		this.UI_M_LC_NET_PREM = UI_M_LC_NET_PREM;
	}

	public Double getPC_LC_PAID_AMT() {
		return PC_LC_PAID_AMT;
	}

	public void setPC_LC_PAID_AMT(Double PC_LC_PAID_AMT) {
		this.PC_LC_PAID_AMT = PC_LC_PAID_AMT;
	}

	public Date getPC_DRCR_DOC_DT() {
		 return PC_DRCR_DOC_DT;
	}

	public void setPC_DRCR_DOC_DT(Date PC_DRCR_DOC_DT) {
		this.PC_DRCR_DOC_DT = PC_DRCR_DOC_DT;
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

	public void setPC_DRCR_DOC_NO(Integer pc_drcr_doc_no) {
		PC_DRCR_DOC_NO = pc_drcr_doc_no;
	}

	public Integer getPC_DRCR_DOC_NO() {
		return PC_DRCR_DOC_NO;
	}
}
