package com.iii.pel.forms.PILT018;

import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_BROK_ADV_HDR")
public class PT_IL_BROK_ADV_HDR extends BaseValueBean{
	

	@Column(name="ROWID")
	private String ROWID;
	@Column(name="BAH_SYS_ID")
	private Long BAH_SYS_ID;
	
	@Column(name="BAH_CR_UID")
	private String BAH_CR_UID;
	
	@Column(name="BAH_CR_DT")
	private Date BAH_CR_DT;
	
	
	@Column(name="BAH_PYMT_DT")
	private Date BAH_PYMT_DT;
	
	@Column(name="BAH_UPD_UID")
	private String BAH_UPD_UID;
	
	@Column(name="BAH_UPD_DT")
	private Date BAH_UPD_DT;
	

	@Column(name="BAH_CUST_CODE")
	private String BAH_CUST_CODE;
	
/*	@Column(name="BAH_CUST_CODE_DESC")
	private  String BAH_CUST_CODE_DESC;
	
	@Column(name="BAH_CURR_CODE_DESC")
	private  String BAH_CURR_CODE_DESC;*/

	@Column(name="BAH_REF_NO")
	private String BAH_REF_NO;

	@Column(name="BAH_PYMT_TYPE")
	private String BAH_PYMT_TYPE;

	@Column(name="BAH_CURR_CODE")
	private String BAH_CURR_CODE;

	@Column(name="BAH_CURR_RATE_TYPE")
	private String BAH_CURR_RATE_TYPE;

	
	@Column(name="BAH_FC_AMT")
	private Double BAH_FC_AMT;

	@Column(name="BAH_REPAY_TYPE")
	private String BAH_REPAY_TYPE;

	@Column(name="BAH_CONFIRM_FLAG")
	private String BAH_CONFIRM_FLAG;

	@Column(name="BAH_PAYMENT_YN")
	private String BAH_PAYMENT_YN;

	@Column(name="BAH_TXN_CODE")
	private String BAH_TXN_CODE;

	private String UI_M_BAH_CUST_DESC;

	private String UI_M_BAH_CURR_NAME;

	@Column(name="BAH_REPAYMENT_YN")
	private String BAH_REPAYMENT_YN;

	@Column(name="BAH_DOC_NO")
	private Double BAH_DOC_NO;

	@Column(name="BAH_INST_FM_DT")
	private Date BAH_INST_FM_DT;

	@Column(name="BAH_REMARKS")
	private String BAH_REMARKS;

	@Column(name="BAH_EXCH_RATE")
	private Double BAH_EXCH_RATE;

	@Column(name="BAH_LC_AMT")
	private Double BAH_LC_AMT;

	@Column(name="BAH_NO_OF_INST")
	private Integer BAH_NO_OF_INST;

	@Column(name="BAH_STATUS")
	private String BAH_STATUS;

	@Column(name="BAH_PAY_PRIORITY")
	private Double BAH_PAY_PRIORITY;

	@Column(name="BAH_DOC_DT")
	private Date BAH_DOC_DT;
	
//	[BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09 For handling enabling & disabling of approve buttons 
//	 in Header and Detail Block and their respective actions.
	@Column(name="BAH_PAID_FLAG")
	private String BAH_PAID_FLAG; 
//  BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09]
	
	private String UI_M_BASE_CURR_CODE;
	
	private Double UI_M_BROK_CAL_METHOD;
	
//  Added By Amit Gupta for displaying the approval status	
	private String UI_M_APPROVAL_STATUS;
	
	private List<String>  BAH_PYMT_TYPE_LIST;
	
	private List<String>  BAH_CURR_RATE_TYPE_LIST;
	
	private List<String>BAH_REPAY_TYPE_LIST;
	
	private List<String>BAH_STATUS_LIST;
	
	private List<String>BAH_CONFIRM_FLAG_LIST;
	
	
	private List<String>BAH_PAYMENT_YN_LIST;
	
	private List<String>BAH_REPAYMENT_YN_LIST;
	
	private String LOV_CURR_CODE;
	private String LOV_CURR_CODE_DESC;
	
    private String LOV_CUST_CODE;
	
	private String LOV_CUST_CODE_DESC;
	
	private boolean CHECK_BOX;


	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public List<String> getBAH_REPAYMENT_YN_LIST() {
		return BAH_REPAYMENT_YN_LIST;
	}

	public void setBAH_REPAYMENT_YN_LIST(List<String> bah_repayment_yn_list) {
		BAH_REPAYMENT_YN_LIST = bah_repayment_yn_list;
	}

	public List<String> getBAH_PAYMENT_YN_LIST() {
		return BAH_PAYMENT_YN_LIST;
	}

	public void setBAH_PAYMENT_YN_LIST(List<String> bah_payment_yn_list) {
		BAH_PAYMENT_YN_LIST = bah_payment_yn_list;
	}

	public List<String> getBAH_CONFIRM_FLAG_LIST() {
		return BAH_CONFIRM_FLAG_LIST;
	}

	public void setBAH_CONFIRM_FLAG_LIST(List<String> bah_confirm_flag_list) {
		BAH_CONFIRM_FLAG_LIST = bah_confirm_flag_list;
	}

	public List<String> getBAH_STATUS_LIST() {
		return BAH_STATUS_LIST;
	}

	public void setBAH_STATUS_LIST(List<String> bah_status_list) {
		BAH_STATUS_LIST = bah_status_list;
	}

	public List<String> getBAH_REPAY_TYPE_LIST() {
		return BAH_REPAY_TYPE_LIST;
	}

	public void setBAH_REPAY_TYPE_LIST(List<String> bah_repay_type_list) {
		BAH_REPAY_TYPE_LIST = bah_repay_type_list;
	}

	public List<String> getBAH_CURR_RATE_TYPE_LIST() {
		return BAH_CURR_RATE_TYPE_LIST;
	}

	public void setBAH_CURR_RATE_TYPE_LIST(List<String> bah_curr_rate_type_list) {
		BAH_CURR_RATE_TYPE_LIST = bah_curr_rate_type_list;
	}

	public Date getBAH_PYMT_DT() {
		 return BAH_PYMT_DT;
	}

	public void setBAH_PYMT_DT(Date BAH_PYMT_DT) {
		this.BAH_PYMT_DT = BAH_PYMT_DT;
	}

	public String getBAH_CUST_CODE() {
		return BAH_CUST_CODE;
	}

	public void setBAH_CUST_CODE(String BAH_CUST_CODE) {
		this.BAH_CUST_CODE = BAH_CUST_CODE;
	}

	public String getBAH_REF_NO() {
		return BAH_REF_NO;
	}

	public void setBAH_REF_NO(String BAH_REF_NO) {
		this.BAH_REF_NO = BAH_REF_NO;
	}

	public String getBAH_PYMT_TYPE() {
		return BAH_PYMT_TYPE;
	}

	public void setBAH_PYMT_TYPE(String BAH_PYMT_TYPE) {
		this.BAH_PYMT_TYPE = BAH_PYMT_TYPE;
	}

	public String getBAH_CURR_CODE() {
		return BAH_CURR_CODE;
	}

	public void setBAH_CURR_CODE(String BAH_CURR_CODE) {
		this.BAH_CURR_CODE = BAH_CURR_CODE;
	}

	public String getBAH_CURR_RATE_TYPE() {
		return BAH_CURR_RATE_TYPE;
	}

	public void setBAH_CURR_RATE_TYPE(String BAH_CURR_RATE_TYPE) {
		this.BAH_CURR_RATE_TYPE = BAH_CURR_RATE_TYPE;
	}

	public Double getBAH_FC_AMT() {
		return BAH_FC_AMT;
	}

	public void setBAH_FC_AMT(Double BAH_FC_AMT) {
		this.BAH_FC_AMT = BAH_FC_AMT;
	}

	public String getBAH_REPAY_TYPE() {
		return BAH_REPAY_TYPE;
	}

	public void setBAH_REPAY_TYPE(String BAH_REPAY_TYPE) {
		this.BAH_REPAY_TYPE = BAH_REPAY_TYPE;
	}

	public String getBAH_CONFIRM_FLAG() {
		return BAH_CONFIRM_FLAG;
	}

	public void setBAH_CONFIRM_FLAG(String BAH_CONFIRM_FLAG) {
		this.BAH_CONFIRM_FLAG = BAH_CONFIRM_FLAG;
	}

	public String getBAH_PAYMENT_YN() {
		return BAH_PAYMENT_YN;
	}

	public void setBAH_PAYMENT_YN(String BAH_PAYMENT_YN) {
		this.BAH_PAYMENT_YN = BAH_PAYMENT_YN;
	}

	public String getBAH_TXN_CODE() {
		return BAH_TXN_CODE;
	}

	public void setBAH_TXN_CODE(String BAH_TXN_CODE) {
		this.BAH_TXN_CODE = BAH_TXN_CODE;
	}

	public String getUI_M_BAH_CUST_DESC() {
		return UI_M_BAH_CUST_DESC;
	}

	public void setUI_M_BAH_CUST_DESC(String UI_M_BAH_CUST_DESC) {
		this.UI_M_BAH_CUST_DESC = UI_M_BAH_CUST_DESC;
	}

	public String getUI_M_BAH_CURR_NAME() {
		return UI_M_BAH_CURR_NAME;
	}

	public void setUI_M_BAH_CURR_NAME(String UI_M_BAH_CURR_NAME) {
		this.UI_M_BAH_CURR_NAME = UI_M_BAH_CURR_NAME;
	}

	public String getBAH_REPAYMENT_YN() {
		return BAH_REPAYMENT_YN;
	}

	public void setBAH_REPAYMENT_YN(String BAH_REPAYMENT_YN) {
		this.BAH_REPAYMENT_YN = BAH_REPAYMENT_YN;
	}

	public Double getBAH_DOC_NO() {
		return BAH_DOC_NO;
	}

	public void setBAH_DOC_NO(Double BAH_DOC_NO) {
		this.BAH_DOC_NO = BAH_DOC_NO;
	}

	public Date getBAH_INST_FM_DT() {
		 return BAH_INST_FM_DT;
	}

	public void setBAH_INST_FM_DT(Date BAH_INST_FM_DT) {
		this.BAH_INST_FM_DT = BAH_INST_FM_DT;
	}

	public String getBAH_REMARKS() {
		return BAH_REMARKS;
	}

	public void setBAH_REMARKS(String BAH_REMARKS) {
		this.BAH_REMARKS = BAH_REMARKS;
	}

	public Double getBAH_EXCH_RATE() {
		return BAH_EXCH_RATE;
	}

	public void setBAH_EXCH_RATE(Double BAH_EXCH_RATE) {
		this.BAH_EXCH_RATE = BAH_EXCH_RATE;
	}

	public Double getBAH_LC_AMT() {
		return BAH_LC_AMT;
	}

	public void setBAH_LC_AMT(Double BAH_LC_AMT) {
		this.BAH_LC_AMT = BAH_LC_AMT;
	}

	

	/**
	 * @return the bAH_NO_OF_INST
	 */
	public Integer getBAH_NO_OF_INST() {
		return BAH_NO_OF_INST;
	}

	/**
	 * @param bah_no_of_inst the bAH_NO_OF_INST to set
	 */
	public void setBAH_NO_OF_INST(Integer bah_no_of_inst) {
		BAH_NO_OF_INST = bah_no_of_inst;
	}

	public String getBAH_STATUS() {
		return BAH_STATUS;
	}

	public void setBAH_STATUS(String BAH_STATUS) {
		this.BAH_STATUS = BAH_STATUS;
	}

	public Double getBAH_PAY_PRIORITY() {
		return BAH_PAY_PRIORITY;
	}

	public void setBAH_PAY_PRIORITY(Double BAH_PAY_PRIORITY) {
		this.BAH_PAY_PRIORITY = BAH_PAY_PRIORITY;
	}

	public Date getBAH_DOC_DT() {
		 return BAH_DOC_DT;
	}

	public void setBAH_DOC_DT(Date BAH_DOC_DT) {
		this.BAH_DOC_DT = BAH_DOC_DT;
	}

	public List<String> getBAH_PYMT_TYPE_LIST() {
		return BAH_PYMT_TYPE_LIST;
	}

	public void setBAH_PYMT_TYPE_LIST(List<String> bah_pymt_type_list) {
		BAH_PYMT_TYPE_LIST = bah_pymt_type_list;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getLOV_CUST_CODE() {
		return LOV_CUST_CODE;
	}

	public void setLOV_CUST_CODE(String lov_cust_code) {
		LOV_CUST_CODE = lov_cust_code;
	}

	public String getLOV_CUST_CODE_DESC() {
		return LOV_CUST_CODE_DESC;
	}

	public void setLOV_CUST_CODE_DESC(String lov_cust_code_desc) {
		LOV_CUST_CODE_DESC = lov_cust_code_desc;
	}

	public String getLOV_CURR_CODE() {
		return LOV_CURR_CODE;
	}

	public void setLOV_CURR_CODE(String lov_curr_code) {
		LOV_CURR_CODE = lov_curr_code;
	}

	public String getLOV_CURR_CODE_DESC() {
		return LOV_CURR_CODE_DESC;
	}

	public void setLOV_CURR_CODE_DESC(String lov_curr_code_desc) {
		LOV_CURR_CODE_DESC = lov_curr_code_desc;
	}

	public String getBAH_CR_UID() {
		return BAH_CR_UID;
	}

	public void setBAH_CR_UID(String bah_cr_uid) {
		BAH_CR_UID = bah_cr_uid;
	}

	public Date getBAH_CR_DT() {
		return BAH_CR_DT;
	}

	public void setBAH_CR_DT(Date bah_cr_dt) {
		BAH_CR_DT = bah_cr_dt;
	}

	

	/**
	 * @return the bAH_SYS_ID
	 */
	public Long getBAH_SYS_ID() {
		return BAH_SYS_ID;
	}

	/**
	 * @param bah_sys_id the bAH_SYS_ID to set
	 */
	public void setBAH_SYS_ID(Long bah_sys_id) {
		BAH_SYS_ID = bah_sys_id;
	}

	public String getUI_M_BASE_CURR_CODE() {
		return UI_M_BASE_CURR_CODE;
	}

	public void setUI_M_BASE_CURR_CODE(String ui_m_base_curr_code) {
		UI_M_BASE_CURR_CODE = ui_m_base_curr_code;
	}

	public Double getUI_M_BROK_CAL_METHOD() {
		return UI_M_BROK_CAL_METHOD;
	}

	public void setUI_M_BROK_CAL_METHOD(Double ui_m_brok_cal_method) {
		UI_M_BROK_CAL_METHOD = ui_m_brok_cal_method;
	}

//	[BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09 For handling enabling & disabling of approve buttons 
//	 in Header and Detail Block and their respective actions.
	public String getBAH_PAID_FLAG() {
		return BAH_PAID_FLAG;
	}

	public void setBAH_PAID_FLAG(String bah_paid_flag) {
		BAH_PAID_FLAG = bah_paid_flag;
	}
// BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09]

	public String getUI_M_APPROVAL_STATUS() {
		return UI_M_APPROVAL_STATUS;
	}

	public void setUI_M_APPROVAL_STATUS(String ui_m_approval_status) {
		UI_M_APPROVAL_STATUS = ui_m_approval_status;
	}

	/**
	 * @return the bAH_UPD_UID
	 */
	public String getBAH_UPD_UID() {
		return BAH_UPD_UID;
	}

	/**
	 * @param bah_upd_uid the bAH_UPD_UID to set
	 */
	public void setBAH_UPD_UID(String bah_upd_uid) {
		BAH_UPD_UID = bah_upd_uid;
	}

	/**
	 * @return the bAH_UPD_DT
	 */
	public Date getBAH_UPD_DT() {
		return BAH_UPD_DT;
	}

	/**
	 * @param bah_upd_dt the bAH_UPD_DT to set
	 */
	public void setBAH_UPD_DT(Date bah_upd_dt) {
		BAH_UPD_DT = bah_upd_dt;
	}
	
	/*public String getBAH_CUST_CODE_DESC() {
		return BAH_CUST_CODE_DESC;
	}

	public void setBAH_CUST_CODE_DESC(String bah_cust_code_desc) {
		BAH_CUST_CODE_DESC = bah_cust_code_desc;
	}

	public String getBAH_CURR_CODE_DESC() {
		return BAH_CURR_CODE_DESC;
	}

	public void setBAH_CURR_CODE_DESC(String bah_curr_code_desc) {
		BAH_CURR_CODE_DESC = bah_curr_code_desc;
	}*/
}
