package com.iii.pel.forms.PILP018;

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

	@Column(name="PC_SYS_ID")
	private int PC_SYS_ID;
	
	@Column(name="PC_POL_SYS_ID")
	private int PC_POL_SYS_ID;
	
	@Column(name="PC_END_NO_IDX")
	private int PC_END_NO_IDX;
	
	
	@Column(name="PC_FACIN_YN")
	private String PC_FACIN_YN;
	
	private String M_WHERE;
	
	private boolean CHECK_BOX;
    
   	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
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

	
	/**
	 * @return the pC_SYS_ID
	 */
	public int getPC_SYS_ID() {
		return PC_SYS_ID;
	}

	/**
	 * @param pc_sys_id the pC_SYS_ID to set
	 */
	public void setPC_SYS_ID(int pc_sys_id) {
		PC_SYS_ID = pc_sys_id;
	}

	/**
	 * @return the pC_POL_SYS_ID
	 */
	public int getPC_POL_SYS_ID() {
		return PC_POL_SYS_ID;
	}

	/**
	 * @param pc_pol_sys_id the pC_POL_SYS_ID to set
	 */
	public void setPC_POL_SYS_ID(int pc_pol_sys_id) {
		PC_POL_SYS_ID = pc_pol_sys_id;
	}

	/**
	 * @return the pC_END_NO_IDX
	 */
	public int getPC_END_NO_IDX() {
		return PC_END_NO_IDX;
	}

	/**
	 * @param pc_end_no_idx the pC_END_NO_IDX to set
	 */
	public void setPC_END_NO_IDX(int pc_end_no_idx) {
		PC_END_NO_IDX = pc_end_no_idx;
	}

	/**
	 * @return the pC_FACIN_YN
	 */
	public String getPC_FACIN_YN() {
		return PC_FACIN_YN;
	}

	/**
	 * @param pc_facin_yn the pC_FACIN_YN to set
	 */
	public void setPC_FACIN_YN(String pc_facin_yn) {
		PC_FACIN_YN = pc_facin_yn;
	}

	public String getM_WHERE() {
	    return M_WHERE;
	}

	public void setM_WHERE(String m_where) {
	    M_WHERE = m_where;
	}

	
}
