package com.iii.pel.forms.PILQ004_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POLICY")
public class POLICY_DETAILS extends BaseValueBean  {

	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_TRAN_DT")
	private Date POL_TRAN_DT;

	@Column(name="POL_FC_SUM_ASSURED")
	private Double POL_FC_SUM_ASSURED;

	private String UI_M_POL_PLAN_DESC;

	@Column(name="POL_PLAN_CODE")
	private String POL_PLAN_CODE;

	@Column(name="POL_LC_SUM_ASSURED")
	private Double POL_LC_SUM_ASSURED;

	private Date NEXT_DUE_DATE;

	@Column(name="POL_FC_FIRST_PREM")
	private Double POL_FC_FIRST_PREM;

	@Column(name="POL_PERIOD")
	private Double POL_PERIOD;

	@Column(name="POL_PREM_PAY_YRS")
	private Double POL_PREM_PAY_YRS;

	@Column(name="POL_START_DT")
	private Date POL_START_DT;

	@Column(name="POL_EXPIRY_DT")
	private Date POL_EXPIRY_DT;

	@Column(name="POL_REMARKS")
	private String POL_REMARKS;

	@Column(name="POL_FC_BASIC_PREM")
	private Double POL_FC_BASIC_PREM;

	private String POL_MODE_OF_PYMT_DESC;

	@Column(name="POL_ADDL_STATUS")
	private String POL_ADDL_STATUS;

	@Column(name="POL_LC_FIRST_PREM")
	private Double POL_LC_FIRST_PREM;

	private Double UI_M_POAD_LC_THRESOLD_LMT;

	private String POL_STATUS_DESC;

	private String UI_M_TYPE;
	
	private Double UI_M_TOT_SA; 

	private Double UI_M_POAD_LC_THRESHOLD_LMT;
	
	private Double UI_M_POAD_TOT_THRESOLD_LMT;
	
	@Column(name="POL_SYS_ID")
	private Long POL_SYS_ID;
	
	@Column(name="POL_STATUS")
	private String POL_STATUS;
	
	@Column(name="POL_MODE_OF_PYMT")
	private String POL_MODE_OF_PYMT;
	
	@Column(name="POL_DS_TYPE")
	private String POL_DS_TYPE;
	
	



	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public Date getPOL_TRAN_DT() {
		 return POL_TRAN_DT;
	}

	public void setPOL_TRAN_DT(Date POL_TRAN_DT) {
		this.POL_TRAN_DT = POL_TRAN_DT;
	}

	public Double getPOL_FC_SUM_ASSURED() {
		return POL_FC_SUM_ASSURED;
	}

	public void setPOL_FC_SUM_ASSURED(Double POL_FC_SUM_ASSURED) {
		this.POL_FC_SUM_ASSURED = POL_FC_SUM_ASSURED;
	}

	public String getUI_M_POL_PLAN_DESC() {
		return UI_M_POL_PLAN_DESC;
	}

	public void setUI_M_POL_PLAN_DESC(String UI_M_POL_PLAN_DESC) {
		this.UI_M_POL_PLAN_DESC = UI_M_POL_PLAN_DESC;
	}

	public String getPOL_PLAN_CODE() {
		return POL_PLAN_CODE;
	}

	public void setPOL_PLAN_CODE(String POL_PLAN_CODE) {
		this.POL_PLAN_CODE = POL_PLAN_CODE;
	}

	public Double getPOL_LC_SUM_ASSURED() {
		return POL_LC_SUM_ASSURED;
	}

	public void setPOL_LC_SUM_ASSURED(Double POL_LC_SUM_ASSURED) {
		this.POL_LC_SUM_ASSURED = POL_LC_SUM_ASSURED;
	}

	public Date getNEXT_DUE_DATE() {
		 return NEXT_DUE_DATE;
	}

	public void setNEXT_DUE_DATE(Date NEXT_DUE_DATE) {
		this.NEXT_DUE_DATE = NEXT_DUE_DATE;
	}

	public Double getPOL_FC_FIRST_PREM() {
		return POL_FC_FIRST_PREM;
	}

	public void setPOL_FC_FIRST_PREM(Double POL_FC_FIRST_PREM) {
		this.POL_FC_FIRST_PREM = POL_FC_FIRST_PREM;
	}

	public Double getPOL_PERIOD() {
		return POL_PERIOD;
	}

	public void setPOL_PERIOD(Double POL_PERIOD) {
		this.POL_PERIOD = POL_PERIOD;
	}

	public Double getPOL_PREM_PAY_YRS() {
		return POL_PREM_PAY_YRS;
	}

	public void setPOL_PREM_PAY_YRS(Double POL_PREM_PAY_YRS) {
		this.POL_PREM_PAY_YRS = POL_PREM_PAY_YRS;
	}

	public Date getPOL_START_DT() {
		 return POL_START_DT;
	}

	public void setPOL_START_DT(Date POL_START_DT) {
		this.POL_START_DT = POL_START_DT;
	}

	public Date getPOL_EXPIRY_DT() {
		 return POL_EXPIRY_DT;
	}

	public void setPOL_EXPIRY_DT(Date POL_EXPIRY_DT) {
		this.POL_EXPIRY_DT = POL_EXPIRY_DT;
	}

	public String getPOL_REMARKS() {
		return POL_REMARKS;
	}

	public void setPOL_REMARKS(String POL_REMARKS) {
		this.POL_REMARKS = POL_REMARKS;
	}

	public Double getPOL_FC_BASIC_PREM() {
		return POL_FC_BASIC_PREM;
	}

	public void setPOL_FC_BASIC_PREM(Double POL_FC_BASIC_PREM) {
		this.POL_FC_BASIC_PREM = POL_FC_BASIC_PREM;
	}

	public String getPOL_MODE_OF_PYMT_DESC() {
		return POL_MODE_OF_PYMT_DESC;
	}

	public void setPOL_MODE_OF_PYMT_DESC(String POL_MODE_OF_PYMT_DESC) {
		this.POL_MODE_OF_PYMT_DESC = POL_MODE_OF_PYMT_DESC;
	}

	public String getPOL_ADDL_STATUS() {
		return POL_ADDL_STATUS;
	}

	public void setPOL_ADDL_STATUS(String POL_ADDL_STATUS) {
		this.POL_ADDL_STATUS = POL_ADDL_STATUS;
	}

	public Double getPOL_LC_FIRST_PREM() {
		return POL_LC_FIRST_PREM;
	}

	public void setPOL_LC_FIRST_PREM(Double POL_LC_FIRST_PREM) {
		this.POL_LC_FIRST_PREM = POL_LC_FIRST_PREM;
	}

	public Double getUI_M_POAD_LC_THRESOLD_LMT() {
		return UI_M_POAD_LC_THRESOLD_LMT;
	}

	public void setUI_M_POAD_LC_THRESOLD_LMT(Double UI_M_POAD_LC_THRESOLD_LMT) {
		this.UI_M_POAD_LC_THRESOLD_LMT = UI_M_POAD_LC_THRESOLD_LMT;
	}

	public String getPOL_STATUS_DESC() {
		return POL_STATUS_DESC;
	}

	public void setPOL_STATUS_DESC(String POL_STATUS_DESC) {
		this.POL_STATUS_DESC = POL_STATUS_DESC;
	}

	public String getUI_M_TYPE() {
		return UI_M_TYPE;
	}

	public void setUI_M_TYPE(String UI_M_TYPE) {
		this.UI_M_TYPE = UI_M_TYPE;
	}

	public Double getUI_M_POAD_LC_THRESHOLD_LMT() {
		return UI_M_POAD_LC_THRESHOLD_LMT;
	}

	public void setUI_M_POAD_LC_THRESHOLD_LMT(Double UI_M_POAD_LC_THRESHOLD_LMT) {
		this.UI_M_POAD_LC_THRESHOLD_LMT = UI_M_POAD_LC_THRESHOLD_LMT;
	}

	public String getPOL_STATUS() {
		return POL_STATUS;
	}

	public void setPOL_STATUS(String pol_status) {
		POL_STATUS = pol_status;
	}

	public String getPOL_MODE_OF_PYMT() {
		return POL_MODE_OF_PYMT;
	}

	public void setPOL_MODE_OF_PYMT(String pol_mode_of_pymt) {
		POL_MODE_OF_PYMT = pol_mode_of_pymt;
	}

	public String getPOL_DS_TYPE() {
		return POL_DS_TYPE;
	}

	public void setPOL_DS_TYPE(String pol_ds_type) {
		POL_DS_TYPE = pol_ds_type;
	}


	/**
	 * @return the pOL_SYS_ID
	 */
	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	/**
	 * @param pol_sys_id the pOL_SYS_ID to set
	 */
	public void setPOL_SYS_ID(Long pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public Double getUI_M_TOT_SA() {
		return UI_M_TOT_SA;
	}

	public void setUI_M_TOT_SA(Double ui_m_tot_sa) {
		UI_M_TOT_SA = ui_m_tot_sa;
	}

	public Double getUI_M_POAD_TOT_THRESOLD_LMT() {
		return UI_M_POAD_TOT_THRESOLD_LMT;
	}

	public void setUI_M_POAD_TOT_THRESOLD_LMT(Double ui_m_poad_tot_thresold_lmt) {
		UI_M_POAD_TOT_THRESOLD_LMT = ui_m_poad_tot_thresold_lmt;
	}
}
