package com.iii.pel.forms.PILT005;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.apps.tahoe.appbuilder.guidesigner.Common;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_LOAN_REPAYMENT")
public class PT_IL_LOAN_REPAYMENT extends BaseValueBean{

	@Column(name="LR_PYMT_DT")
	private Date LR_PYMT_DT;
	
	@Column(name="LR_REPAY_PAID_DT")
	private Date LR_REPAY_PAID_DT;


	@Column(name="LR_LOAN_SYS_ID")
	private Double LR_LOAN_SYS_ID;
	
	@Column(name="LR_SYS_ID")
	private Long LR_SYS_ID;
	
	@Column(name="LR_FC_PYMT_AMT")
	private Double LR_FC_PYMT_AMT;

	@Column(name="LR_LC_PYMT_AMT")
	private Double LR_LC_PYMT_AMT;

	@Column(name="LR_FC_INT_AMT")
	private Double LR_FC_INT_AMT;

	@Column(name="LR_LC_INT_AMT")
	private Double LR_LC_INT_AMT;

	@Column(name="LR_FC_LOAN_AMT")
	private Double LR_FC_LOAN_AMT;

	@Column(name="LR_LC_LOAN_AMT")
	private Double LR_LC_LOAN_AMT;

	@Column(name="LR_PYMT_REF_NO")
	private String LR_PYMT_REF_NO;

	private String LOAN_STATUS;
	private String LOAN_DISBURSAL_STATUS;
	
	@Column(name="LR_FLAG")
	private String LR_FLAG;
	
	@Column(name="LR_STATUS")
	private String LR_STATUS;
	
	@Column(name="LR_CR_DT")
	private Date LR_CR_DT;
	
	@Column(name="LR_CR_UID")
	private String LR_CR_UID;
	
	
	@Id
	@Column(name="ROWID")
	private String ROWID;

	private boolean checkBoxValue;
	
	private boolean LR_PYMT_DT_DISABLE;
	private boolean LR_FC_PYMT_AMT_DISABLE;
	private boolean LR_LC_PYMT_AMT_DISABLE;
	private boolean LR_PYMT_REF_NO_DISABLE;
	private Date LR_UPD_DT;
	private String LR_DUE_DT;
	private String LR_REPAY_DT;
	private String LR_UPD_UID;
	
	private String UI_M_LOAN_STATUS;
	
	public String getUI_M_LOAN_STATUS() {
		return UI_M_LOAN_STATUS;
	}

	public void setUI_M_LOAN_STATUS(String ui_m_loan_status) {
		UI_M_LOAN_STATUS = ui_m_loan_status;
	}

	public boolean isLR_PYMT_DT_DISABLE() {
		return LR_PYMT_DT_DISABLE;
	}

	public void setLR_PYMT_DT_DISABLE(boolean lr_pymt_dt_disable) {
		LR_PYMT_DT_DISABLE = lr_pymt_dt_disable;
	}

	public boolean isLR_FC_PYMT_AMT_DISABLE() {
		return LR_FC_PYMT_AMT_DISABLE;
	}

	public void setLR_FC_PYMT_AMT_DISABLE(boolean lr_fc_pymt_amt_disable) {
		LR_FC_PYMT_AMT_DISABLE = lr_fc_pymt_amt_disable;
	}

	public boolean isLR_LC_PYMT_AMT_DISABLE() {
		return LR_LC_PYMT_AMT_DISABLE;
	}

	public void setLR_LC_PYMT_AMT_DISABLE(boolean lr_lc_pymt_amt_disable) {
		LR_LC_PYMT_AMT_DISABLE = lr_lc_pymt_amt_disable;
	}

	public boolean isLR_PYMT_REF_NO_DISABLE() {
		return LR_PYMT_REF_NO_DISABLE;
	}

	public void setLR_PYMT_REF_NO_DISABLE(boolean lr_pymt_ref_no_disable) {
		LR_PYMT_REF_NO_DISABLE = lr_pymt_ref_no_disable;
	}

	public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Date getLR_PYMT_DT() {
		 return LR_PYMT_DT;
	}

	public void setLR_PYMT_DT(Date LR_PYMT_DT) {
		setLR_DUE_DT(CommonUtils.dateToPELStringFormatter(LR_PYMT_DT));
		this.LR_PYMT_DT = LR_PYMT_DT;
	}

	public Double getLR_FC_PYMT_AMT() {
		return LR_FC_PYMT_AMT;
	}

	public void setLR_FC_PYMT_AMT(Double LR_FC_PYMT_AMT) {
		this.LR_FC_PYMT_AMT = LR_FC_PYMT_AMT;
	}

	public Double getLR_LC_PYMT_AMT() {
		return LR_LC_PYMT_AMT;
	}

	public void setLR_LC_PYMT_AMT(Double LR_LC_PYMT_AMT) {
		this.LR_LC_PYMT_AMT = LR_LC_PYMT_AMT;
	}

	public Double getLR_FC_INT_AMT() {
		return LR_FC_INT_AMT;
	}

	public void setLR_FC_INT_AMT(Double LR_FC_INT_AMT) {
		this.LR_FC_INT_AMT = LR_FC_INT_AMT;
	}

	public Double getLR_LC_INT_AMT() {
		return LR_LC_INT_AMT;
	}

	public void setLR_LC_INT_AMT(Double LR_LC_INT_AMT) {
		this.LR_LC_INT_AMT = LR_LC_INT_AMT;
	}

	public Double getLR_FC_LOAN_AMT() {
		return LR_FC_LOAN_AMT;
	}

	public void setLR_FC_LOAN_AMT(Double LR_FC_LOAN_AMT) {
		this.LR_FC_LOAN_AMT = LR_FC_LOAN_AMT;
	}

	public Double getLR_LC_LOAN_AMT() {
		return LR_LC_LOAN_AMT;
	}

	public void setLR_LC_LOAN_AMT(Double LR_LC_LOAN_AMT) {
		this.LR_LC_LOAN_AMT = LR_LC_LOAN_AMT;
	}

	public String getLR_PYMT_REF_NO() {
		return LR_PYMT_REF_NO;
	}

	public void setLR_PYMT_REF_NO(String LR_PYMT_REF_NO) {
		this.LR_PYMT_REF_NO = LR_PYMT_REF_NO;
	}


	public String getLOAN_STATUS() {
		return LOAN_STATUS;
	}

	public void setLOAN_STATUS(String loan_status) {
		LOAN_STATUS = loan_status;
	}

	public Double getLR_LOAN_SYS_ID() {
		return LR_LOAN_SYS_ID;
	}

	public void setLR_LOAN_SYS_ID(Double lr_loan_sys_id) {
		LR_LOAN_SYS_ID = lr_loan_sys_id;
	}

	
	public Long getLR_SYS_ID() {
		return LR_SYS_ID;
	}

	public void setLR_SYS_ID(Long lr_sys_id) {
		LR_SYS_ID = lr_sys_id;
	}

	public String getLR_FLAG() {
		return LR_FLAG;
	}

	public void setLR_FLAG(String lr_flag) {
		LR_FLAG = lr_flag;
	}

	public String getLR_STATUS() {
		return LR_STATUS;
	}

	public void setLR_STATUS(String lr_status) {
		LR_STATUS = lr_status;
	}

	public String getLOAN_DISBURSAL_STATUS() {
		return LOAN_DISBURSAL_STATUS;
	}

	public void setLOAN_DISBURSAL_STATUS(String loan_disbursal_status) {
		LOAN_DISBURSAL_STATUS = loan_disbursal_status;
	}

	/**
	 * @return the lR_CR_DT
	 */
	public Date getLR_CR_DT() {
		return LR_CR_DT;
	}

	/**
	 * @param lr_cr_dt the lR_CR_DT to set
	 */
	public void setLR_CR_DT(Date lr_cr_dt) {
		LR_CR_DT = lr_cr_dt;
	}

	/**
	 * @return the lR_CR_UID
	 */
	public String getLR_CR_UID() {
		return LR_CR_UID;
	}

	/**
	 * @param lr_cr_uid the lR_CR_UID to set
	 */
	public void setLR_CR_UID(String lr_cr_uid) {
		LR_CR_UID = lr_cr_uid;
	}

	public Date getLR_UPD_DT() {
		return LR_UPD_DT;
	}

	public void setLR_UPD_DT(Date lr_upd_dt) {
		LR_UPD_DT = lr_upd_dt;
	}

	public String getLR_UPD_UID() {
		return LR_UPD_UID;
	}

	public void setLR_UPD_UID(String lr_upd_uid) {
		LR_UPD_UID = lr_upd_uid;
	}

	public Date getLR_REPAY_PAID_DT() {
		return LR_REPAY_PAID_DT;
	}

	public void setLR_REPAY_PAID_DT(Date lr_repay_paid_dt) {
		setLR_REPAY_DT(CommonUtils.dateToPELStringFormatter(lr_repay_paid_dt));
		LR_REPAY_PAID_DT = lr_repay_paid_dt;
	}

	public String getLR_DUE_DT() {
		return LR_DUE_DT;
	}

	public void setLR_DUE_DT(String lr_due_dt) {
		LR_DUE_DT = lr_due_dt;
	}

	public String getLR_REPAY_DT() {
		return LR_REPAY_DT;
	}

	public void setLR_REPAY_DT(String lr_repay_dt) {
		LR_REPAY_DT = lr_repay_dt;
	}


	
	

	
}
