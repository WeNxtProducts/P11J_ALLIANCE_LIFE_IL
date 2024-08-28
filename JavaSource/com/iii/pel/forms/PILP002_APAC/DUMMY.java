package com.iii.pel.forms.PILP002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {
	
	private String UI_M_POL_NO;
	
	private String UI_M_POL_DIVN_CODE;
	
	private String UI_M_POL_CASH_YN;
	
	private String BASE_CURR_CODE;
	
	private String UI_M_PLAN_TYPE;
	
	private String UI_M_RE_UW_REQ_YN;
	
	private String UI_M_RE_UW_REQ_REASON;
	
	//private String UI_M_CUST_CURR_CODE;
	
	private Double UI_M_FC_FIRST_PREM;
	
	private Double UI_M_AVLB_BAL_LC_AMT;
	
	//private Double UI_M_AVLB_BAL_FC_AMT;
	
	private Double UI_M_LC_FIRST_PREM;
	
	private String UI_M_DEP_GROSS_NET_FLAG;
	
	private String PD_CUST_NAME;
	
	private String PD_ADDR_01;
	
	private String PD_ADDR_02;
	
	private String PD_ADDR_03;
	
	private String PD_REMARKS;
	
	private Double UI_M_AVLB_BAL_FC_AMT;
	
	private String M_PRINT_TYPE;
	
	private String UI_M_POL_PROP_NO;

	private Date UI_M_POL_ISSUE_DT;

	private Double UI_M_DUMMY_FC_AMOUNT;

	private Date UI_M_APPRV_DATE;

	private Date UI_M_TRAN_DATE;
	private String UI_M_PROCESS_TYPE;

	private String UI_M_CUST_CODE;

	private Double UI_M_FC_AMOUNT;

	private Double UI_M_LC_AMOUNT;

	@Column(name="UI_M_PREM_GEN_YN")
	private String UI_M_PREM_GEN_YN;

	@Column(name="UI_M_BROK_GEN_YN")
	private String UI_M_BROK_GEN_YN;
	private String UI_M_POL_PREM_WAIVE_YN;
	private Double UI_M_POL_PREM_WAIVE_INT_RATE;
	
	private String UI_M_POL_PREM_WAIVE_TYPE;
	
	private Double UI_M_POL_PREM_WAIVE_FIX_AMOUNT;

	private String UI_M_POL_CUST_DESC;
	
	private Double UI_M_DUMMY_LC_AMOUNT;
	private Long UI_M_POL_SYS_ID;
	private String UI_M_POL_END_NO_IDX;
	private Double UI_M_CUST_EXCH_RATE;
	
	private String UI_M_POL_END_TYPE; 
	 private String UI_M_ERR_IDX;
	    private String UI_M_STATUS;

	@Id
	@Column(name="ROWID")
	private String ROWID;



	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public Date getUI_M_APPRV_DATE() {
		 return UI_M_APPRV_DATE;
	}

	public void setUI_M_APPRV_DATE(Date UI_M_APPRV_DATE) {
		this.UI_M_APPRV_DATE = UI_M_APPRV_DATE;
	}

	public Date getUI_M_TRAN_DATE() {
		 return UI_M_TRAN_DATE;
	}

	public void setUI_M_TRAN_DATE(Date UI_M_TRAN_DATE) {
		this.UI_M_TRAN_DATE = UI_M_TRAN_DATE;
	}

	public String getUI_M_CUST_CODE() {
		return UI_M_CUST_CODE;
	}

	public void setUI_M_CUST_CODE(String UI_M_CUST_CODE) {
		this.UI_M_CUST_CODE = UI_M_CUST_CODE;
	}

	public Double getUI_M_FC_AMOUNT() {
		return UI_M_FC_AMOUNT;
	}

	public void setUI_M_FC_AMOUNT(Double UI_M_FC_AMOUNT) {
		this.UI_M_FC_AMOUNT = UI_M_FC_AMOUNT;
	}

	public Double getUI_M_LC_AMOUNT() {
		return UI_M_LC_AMOUNT;
	}

	public void setUI_M_LC_AMOUNT(Double UI_M_LC_AMOUNT) {
		this.UI_M_LC_AMOUNT = UI_M_LC_AMOUNT;
	}

	public String getUI_M_PREM_GEN_YN() {
		return UI_M_PREM_GEN_YN;
	}

	public void setUI_M_PREM_GEN_YN(String UI_M_PREM_GEN_YN) {
		this.UI_M_PREM_GEN_YN = UI_M_PREM_GEN_YN;
	}

	public String getUI_M_BROK_GEN_YN() {
		return UI_M_BROK_GEN_YN;
	}

	public void setUI_M_BROK_GEN_YN(String UI_M_BROK_GEN_YN) {
		this.UI_M_BROK_GEN_YN = UI_M_BROK_GEN_YN;
	}

	public String getUI_M_POL_CUST_DESC() {
		return UI_M_POL_CUST_DESC;
	}

	public void setUI_M_POL_CUST_DESC(String UI_M_POL_CUST_DESC) {
		this.UI_M_POL_CUST_DESC = UI_M_POL_CUST_DESC;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getUI_M_PROCESS_TYPE() {
		return UI_M_PROCESS_TYPE;
	}

	public void setUI_M_PROCESS_TYPE(String ui_m_process_type) {
		UI_M_PROCESS_TYPE = ui_m_process_type;
	}

	public String getUI_M_POL_DIVN_CODE() {
		return UI_M_POL_DIVN_CODE;
	}

	public void setUI_M_POL_DIVN_CODE(String ui_m_pol_divn_code) {
		UI_M_POL_DIVN_CODE = ui_m_pol_divn_code;
	}

	public String getBASE_CURR_CODE() {
		return BASE_CURR_CODE;
	}

	public void setBASE_CURR_CODE(String base_curr_code) {
		BASE_CURR_CODE = base_curr_code;
	}

	public String getUI_M_PLAN_TYPE() {
		return UI_M_PLAN_TYPE;
	}

	public void setUI_M_PLAN_TYPE(String ui_m_plan_type) {
		UI_M_PLAN_TYPE = ui_m_plan_type;
	}

	public Double getUI_M_FC_FIRST_PREM() {
		return UI_M_FC_FIRST_PREM;
	}

	public void setUI_M_FC_FIRST_PREM(Double ui_m_fc_first_prem) {
		UI_M_FC_FIRST_PREM = ui_m_fc_first_prem;
	}

	public Double getUI_M_AVLB_BAL_LC_AMT() {
		return UI_M_AVLB_BAL_LC_AMT;
	}

	public void setUI_M_AVLB_BAL_LC_AMT(Double ui_m_avlb_bal_lc_amt) {
		UI_M_AVLB_BAL_LC_AMT = ui_m_avlb_bal_lc_amt;
	}

	public Double getUI_M_LC_FIRST_PREM() {
		return UI_M_LC_FIRST_PREM;
	}

	public void setUI_M_LC_FIRST_PREM(Double ui_m_lc_first_prem) {
		UI_M_LC_FIRST_PREM = ui_m_lc_first_prem;
	}

	public String getUI_M_DEP_GROSS_NET_FLAG() {
		return UI_M_DEP_GROSS_NET_FLAG;
	}

	public void setUI_M_DEP_GROSS_NET_FLAG(String ui_m_dep_gross_net_flag) {
		UI_M_DEP_GROSS_NET_FLAG = ui_m_dep_gross_net_flag;
	}

	public String getPD_CUST_NAME() {
		return PD_CUST_NAME;
	}

	public void setPD_CUST_NAME(String pd_cust_name) {
		PD_CUST_NAME = pd_cust_name;
	}

	public String getPD_ADDR_01() {
		return PD_ADDR_01;
	}

	public void setPD_ADDR_01(String pd_addr_01) {
		PD_ADDR_01 = pd_addr_01;
	}

	public String getPD_ADDR_02() {
		return PD_ADDR_02;
	}

	public void setPD_ADDR_02(String pd_addr_02) {
		PD_ADDR_02 = pd_addr_02;
	}

	public String getPD_ADDR_03() {
		return PD_ADDR_03;
	}

	public void setPD_ADDR_03(String pd_addr_03) {
		PD_ADDR_03 = pd_addr_03;
	}

	public String getPD_REMARKS() {
		return PD_REMARKS;
	}

	public void setPD_REMARKS(String pd_remarks) {
		PD_REMARKS = pd_remarks;
	}

	public Double getUI_M_AVLB_BAL_FC_AMT() {
		return UI_M_AVLB_BAL_FC_AMT;
	}

	public void setUI_M_AVLB_BAL_FC_AMT(Double ui_m_avlb_bal_fc_amt) {
		UI_M_AVLB_BAL_FC_AMT = ui_m_avlb_bal_fc_amt;
	}

	public String getM_PRINT_TYPE() {
		return M_PRINT_TYPE;
	}

	public void setM_PRINT_TYPE(String m_print_type) {
		M_PRINT_TYPE = m_print_type;
	}

	public String getUI_M_POL_PROP_NO() {
		return UI_M_POL_PROP_NO;
	}

	public void setUI_M_POL_PROP_NO(String ui_m_pol_prop_no) {
		UI_M_POL_PROP_NO = ui_m_pol_prop_no;
	}

	public Date getUI_M_POL_ISSUE_DT() {
		return UI_M_POL_ISSUE_DT;
	}

	public void setUI_M_POL_ISSUE_DT(Date ui_m_pol_issue_dt) {
		UI_M_POL_ISSUE_DT = ui_m_pol_issue_dt;
	}

	public Double getUI_M_DUMMY_FC_AMOUNT() {
		return UI_M_DUMMY_FC_AMOUNT;
	}

	public void setUI_M_DUMMY_FC_AMOUNT(Double ui_m_dummy_fc_amount) {
		UI_M_DUMMY_FC_AMOUNT = ui_m_dummy_fc_amount;
	}

	public String getUI_M_RE_UW_REQ_YN() {
		return UI_M_RE_UW_REQ_YN;
	}

	public void setUI_M_RE_UW_REQ_YN(String ui_m_re_uw_req_yn) {
		UI_M_RE_UW_REQ_YN = ui_m_re_uw_req_yn;
	}

	public String getUI_M_RE_UW_REQ_REASON() {
		return UI_M_RE_UW_REQ_REASON;
	}

	public void setUI_M_RE_UW_REQ_REASON(String ui_m_re_uw_req_reason) {
		UI_M_RE_UW_REQ_REASON = ui_m_re_uw_req_reason;
	}

	public String getUI_M_POL_CASH_YN() {
		return UI_M_POL_CASH_YN;
	}

	public void setUI_M_POL_CASH_YN(String ui_m_pol_cash_yn) {
		UI_M_POL_CASH_YN = ui_m_pol_cash_yn;
	}

	public Double getUI_M_DUMMY_LC_AMOUNT() {
		return UI_M_DUMMY_LC_AMOUNT;
	}

	public void setUI_M_DUMMY_LC_AMOUNT(Double ui_m_dummy_lc_amount) {
		UI_M_DUMMY_LC_AMOUNT = ui_m_dummy_lc_amount;
	}

	public Long getUI_M_POL_SYS_ID() {
		return UI_M_POL_SYS_ID;
	}

	public void setUI_M_POL_SYS_ID(Long ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}

	public String getUI_M_POL_END_NO_IDX() {
		return UI_M_POL_END_NO_IDX;
	}

	public void setUI_M_POL_END_NO_IDX(String ui_m_pol_end_no_idx) {
		UI_M_POL_END_NO_IDX = ui_m_pol_end_no_idx;
	}

	public Double getUI_M_CUST_EXCH_RATE() {
		return UI_M_CUST_EXCH_RATE;
	}

	public void setUI_M_CUST_EXCH_RATE(Double ui_m_cust_exch_rate) {
		UI_M_CUST_EXCH_RATE = ui_m_cust_exch_rate;
	}

	public String getUI_M_POL_END_TYPE() {
		return UI_M_POL_END_TYPE;
	}

	public void setUI_M_POL_END_TYPE(String ui_m_pol_end_type) {
		UI_M_POL_END_TYPE = ui_m_pol_end_type;
	}

	public String getUI_M_ERR_IDX() {
	    return UI_M_ERR_IDX;
	}

	public void setUI_M_ERR_IDX(String ui_m_err_idx) {
	    UI_M_ERR_IDX = ui_m_err_idx;
	}

	public String getUI_M_STATUS() {
	    return UI_M_STATUS;
	}

	public void setUI_M_STATUS(String ui_m_status) {
	    UI_M_STATUS = ui_m_status;
	}

	public String getUI_M_POL_PREM_WAIVE_YN() {
		return UI_M_POL_PREM_WAIVE_YN;
	}

	public void setUI_M_POL_PREM_WAIVE_YN(String ui_m_pol_prem_waive_yn) {
		UI_M_POL_PREM_WAIVE_YN = ui_m_pol_prem_waive_yn;
	}

	public Double getUI_M_POL_PREM_WAIVE_INT_RATE() {
		return UI_M_POL_PREM_WAIVE_INT_RATE;
	}

	public void setUI_M_POL_PREM_WAIVE_INT_RATE(Double ui_m_pol_prem_waive_int_rate) {
		UI_M_POL_PREM_WAIVE_INT_RATE = ui_m_pol_prem_waive_int_rate;
	}

	public String getUI_M_POL_PREM_WAIVE_TYPE() {
		return UI_M_POL_PREM_WAIVE_TYPE;
	}

	public void setUI_M_POL_PREM_WAIVE_TYPE(String ui_m_pol_prem_waive_type) {
		UI_M_POL_PREM_WAIVE_TYPE = ui_m_pol_prem_waive_type;
	}

	public Double getUI_M_POL_PREM_WAIVE_FIX_AMOUNT() {
		return UI_M_POL_PREM_WAIVE_FIX_AMOUNT;
	}

	public void setUI_M_POL_PREM_WAIVE_FIX_AMOUNT(
			Double ui_m_pol_prem_waive_fix_amount) {
		UI_M_POL_PREM_WAIVE_FIX_AMOUNT = ui_m_pol_prem_waive_fix_amount;
	}
	
	
	private String UI_M_END_IDX_TYPE_NO;

	public String getUI_M_END_IDX_TYPE_NO() {
		return UI_M_END_IDX_TYPE_NO;
	}

	public void setUI_M_END_IDX_TYPE_NO(String uI_M_END_IDX_TYPE_NO) {
		UI_M_END_IDX_TYPE_NO = uI_M_END_IDX_TYPE_NO;
	}  
	
	
}
