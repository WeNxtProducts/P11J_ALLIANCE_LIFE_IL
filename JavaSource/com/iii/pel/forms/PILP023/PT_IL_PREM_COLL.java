package com.iii.pel.forms.PILP023;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL extends BaseValueBean {

	@Column(name="PC_FC_GROSS_PREM")
	private Double PC_FC_GROSS_PREM;

	@Column(name="PC_LC_GROSS_PREM")
	private Double PC_LC_GROSS_PREM;

	@Column(name="PC_PAID_DT")
	private Date PC_PAID_DT;

	@Column(name="PC_FC_PAID_AMT")
	private Double PC_FC_PAID_AMT;

	@Column(name="PC_LC_PAID_AMT")
	private Double PC_LC_PAID_AMT;

	@Column(name="PC_FC_AVLB_BAL_AMT")
	private Double PC_FC_AVLB_BAL_AMT;

	@Column(name="PC_LC_AVLB_BAL_AMT")
	private Double PC_LC_AVLB_BAL_AMT;

	@Column(name="PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;

	@Column(name="ROWID")
	private String ROWID;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
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

	public Date getPC_PAID_DT() {
		 return PC_PAID_DT;
	}

	public void setPC_PAID_DT(Date PC_PAID_DT) {
		this.PC_PAID_DT = PC_PAID_DT;
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

	public Double getPC_FC_AVLB_BAL_AMT() {
		return PC_FC_AVLB_BAL_AMT;
	}

	public void setPC_FC_AVLB_BAL_AMT(Double PC_FC_AVLB_BAL_AMT) {
		this.PC_FC_AVLB_BAL_AMT = PC_FC_AVLB_BAL_AMT;
	}

	public Double getPC_LC_AVLB_BAL_AMT() {
		return PC_LC_AVLB_BAL_AMT;
	}

	public void setPC_LC_AVLB_BAL_AMT(Double PC_LC_AVLB_BAL_AMT) {
		this.PC_LC_AVLB_BAL_AMT = PC_LC_AVLB_BAL_AMT;
	}

	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
	}
}
