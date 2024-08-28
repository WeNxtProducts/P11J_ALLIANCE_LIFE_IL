package com.iii.pel.forms.PILP001_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {
	
	/*private List UI_M_PROCESS_TYPE_LIST;

	private List UI_M_PROP_TYPE_LIST;*/
	
	private String UI_M_PROP_NO;
	
	private String UI_M_RE_UW_REQ_YN;
	
	private String UI_M_RE_UW_REQ_REASON;
	
	private String M_BASE_CURR_CODE;
	
	private String M_GEN_POL_NO;
	
	private String M_FLAG;	
	
	private Long M_POL_SYS_ID;
	
	private Date UI_M_APPRV_DATE;

	@Column(name="UI_M_PROP_STATUS")
	private String UI_M_PROP_STATUS;

	@Column(name="UI_M_PROP_CONVERT")
	private String UI_M_PROP_CONVERT;

	private String UI_M_POL_DOCCODE;

	private String UI_M_DS_DESC;

	private String UI_M_POLICY_NO;
	
	@Column(name="UI_M_DEPPREM_REFUND_YN")
	private String UI_M_DEPPREM_REFUND_YN;

	@Column(name="UI_M_MED_FEE_RECOVER_YN")
	private String UI_M_MED_FEE_RECOVER_YN;

	private String UI_M_PS_REASON_CODE;

	private String UI_M_REASON_DESC;

	private String UI_M_PS_REMARKS;
	
	
	
	// Out Parameters
	private String  UI_M_PRINT_TYPE;
	private String UI_M_FLAG; 
    private String UI_M_POL_NO; 
    private Long UI_M_PROP_SYS_ID;
    private Long UI_M_CLM_SYS_ID; 
    private Long UI_M_POL_SYS_ID;
    private String UI_M_DOCUMENT; 
    private String UI_M_REP_NAME;
    private String UI_M_ERR_IDX;
    private String UI_M_STATUS;

	 

	public String getUI_M_PRINT_TYPE() {
		return UI_M_PRINT_TYPE;
	}

	public void setUI_M_PRINT_TYPE(String ui_m_print_type) {
		UI_M_PRINT_TYPE = ui_m_print_type;
	}

	public String getUI_M_FLAG() {
		return UI_M_FLAG;
	}

	public void setUI_M_FLAG(String ui_m_flag) {
		UI_M_FLAG = ui_m_flag;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String ui_m_pol_no) {
		UI_M_POL_NO = ui_m_pol_no;
	}

	public Long getUI_M_PROP_SYS_ID() {
		return UI_M_PROP_SYS_ID;
	}

	public void setUI_M_PROP_SYS_ID(Long ui_m_prop_sys_id) {
		UI_M_PROP_SYS_ID = ui_m_prop_sys_id;
	}

	public Long getUI_M_CLM_SYS_ID() {
		return UI_M_CLM_SYS_ID;
	}

	public void setUI_M_CLM_SYS_ID(Long ui_m_clm_sys_id) {
		UI_M_CLM_SYS_ID = ui_m_clm_sys_id;
	}

	public Long getUI_M_POL_SYS_ID() {
		return UI_M_POL_SYS_ID;
	}

	public void setUI_M_POL_SYS_ID(Long ui_m_pol_sys_id) {
		UI_M_POL_SYS_ID = ui_m_pol_sys_id;
	}

	public String getUI_M_DOCUMENT() {
		return UI_M_DOCUMENT;
	}

	public void setUI_M_DOCUMENT(String ui_m_document) {
		UI_M_DOCUMENT = ui_m_document;
	}

	public String getUI_M_REP_NAME() {
		return UI_M_REP_NAME;
	}

	public void setUI_M_REP_NAME(String ui_m_rep_name) {
		UI_M_REP_NAME = ui_m_rep_name;
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

	public String getUI_M_PROP_NO() {
		return UI_M_PROP_NO;
	}

	public void setUI_M_PROP_NO(String UI_M_PROP_NO) {
		this.UI_M_PROP_NO = UI_M_PROP_NO;
	}

	public Date getUI_M_APPRV_DATE() {
		 return UI_M_APPRV_DATE;
	}

	public void setUI_M_APPRV_DATE(Date UI_M_APPRV_DATE) {
		this.UI_M_APPRV_DATE = UI_M_APPRV_DATE;
	}

	public String getUI_M_PROP_STATUS() {
		return UI_M_PROP_STATUS;
	}

	public void setUI_M_PROP_STATUS(String UI_M_PROP_STATUS) {
		this.UI_M_PROP_STATUS = UI_M_PROP_STATUS;
	}

	public String getUI_M_PROP_CONVERT() {
		return UI_M_PROP_CONVERT;
	}

	public void setUI_M_PROP_CONVERT(String UI_M_PROP_CONVERT) {
		this.UI_M_PROP_CONVERT = UI_M_PROP_CONVERT;
	}

	public String getUI_M_POL_DOCCODE() {
		return UI_M_POL_DOCCODE;
	}

	public void setUI_M_POL_DOCCODE(String UI_M_POL_DOCCODE) {
		this.UI_M_POL_DOCCODE = UI_M_POL_DOCCODE;
	}

	public String getUI_M_DS_DESC() {
		return UI_M_DS_DESC;
	}

	public void setUI_M_DS_DESC(String UI_M_DS_DESC) {
		this.UI_M_DS_DESC = UI_M_DS_DESC;
	}

	public String getUI_M_POLICY_NO() {
		return UI_M_POLICY_NO;
	}

	public void setUI_M_POLICY_NO(String UI_M_POLICY_NO) {
		this.UI_M_POLICY_NO = UI_M_POLICY_NO;
	}

	public String getUI_M_DEPPREM_REFUND_YN() {
		return UI_M_DEPPREM_REFUND_YN;
	}

	public void setUI_M_DEPPREM_REFUND_YN(String UI_M_DEPPREM_REFUND_YN) {
		this.UI_M_DEPPREM_REFUND_YN = UI_M_DEPPREM_REFUND_YN;
	}

	public String getUI_M_MED_FEE_RECOVER_YN() {
		return UI_M_MED_FEE_RECOVER_YN;
	}

	public void setUI_M_MED_FEE_RECOVER_YN(String UI_M_MED_FEE_RECOVER_YN) {
		this.UI_M_MED_FEE_RECOVER_YN = UI_M_MED_FEE_RECOVER_YN;
	}

	public String getUI_M_PS_REASON_CODE() {
		return UI_M_PS_REASON_CODE;
	}

	public void setUI_M_PS_REASON_CODE(String UI_M_PS_REASON_CODE) {
		this.UI_M_PS_REASON_CODE = UI_M_PS_REASON_CODE;
	}

	public String getUI_M_REASON_DESC() {
		return UI_M_REASON_DESC;
	}

	public void setUI_M_REASON_DESC(String UI_M_REASON_DESC) {
		this.UI_M_REASON_DESC = UI_M_REASON_DESC;
	}

	public String getUI_M_PS_REMARKS() {
		return UI_M_PS_REMARKS;
	}

	public void setUI_M_PS_REMARKS(String UI_M_PS_REMARKS) {
		this.UI_M_PS_REMARKS = UI_M_PS_REMARKS;
	}

	public Long getM_POL_SYS_ID() {
		return M_POL_SYS_ID;
	}

	public void setM_POL_SYS_ID(Long m_pol_sys_id) {
		M_POL_SYS_ID = m_pol_sys_id;
	}

	public String getM_BASE_CURR_CODE() {
		return M_BASE_CURR_CODE;
	}

	public void setM_BASE_CURR_CODE(String m_base_curr_code) {
		M_BASE_CURR_CODE = m_base_curr_code;
	}

	public String getM_GEN_POL_NO() {
		return M_GEN_POL_NO;
	}

	public void setM_GEN_POL_NO(String m_gen_pol_no) {
		M_GEN_POL_NO = m_gen_pol_no;
	}

	/*public List getUI_M_PROCESS_TYPE_LIST() {
		return UI_M_PROCESS_TYPE_LIST;
	}

	public void setUI_M_PROCESS_TYPE_LIST(List ui_m_process_type_list) {
		UI_M_PROCESS_TYPE_LIST = ui_m_process_type_list;
	}

	public List getUI_M_PROP_TYPE_LIST() {
		return UI_M_PROP_TYPE_LIST;
	}

	public void setUI_M_PROP_TYPE_LIST(List ui_m_prop_type_list) {
		UI_M_PROP_TYPE_LIST = ui_m_prop_type_list;
	}*/

	public String getM_FLAG() {
		return M_FLAG;
	}

	public void setM_FLAG(String m_flag) {
		M_FLAG = m_flag;
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

}
