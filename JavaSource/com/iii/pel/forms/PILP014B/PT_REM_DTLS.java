package com.iii.pel.forms.PILP014B;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name = "PT_REM_DTLS")
public class PT_REM_DTLS extends BaseValueBean {

	@Column(name = "RLD_SYS_ID")
	private Long RLD_SYS_ID;

	@Column(name = "RLD_POL_SYS_ID")
	private Long RLD_POL_SYS_ID;

	@Column(name = "RLD_END_NO_IDX")
	private Integer RLD_END_NO_IDX;

	@Column(name = "RLD_POL_NO")
	private String RLD_POL_NO;

	@Column(name = "RLD_ASSURED_NAME")
	private String RLD_ASSURED_NAME;

	@Column(name = "RLD_FC_SUM_ASSURED")
	private Double RLD_FC_SUM_ASSURED;

	@Column(name = "RLD_MODE_OF_PYMT")
	private String RLD_MODE_OF_PYMT;

	@Column(name = "RLD_ISSUE_DT")
	private Date RLD_ISSUE_DT;

	@Column(name = "RLD_PREM_FC")
	private Double RLD_PREM_FC;

	@Column(name = "RLD_REM_NO")
	private String RLD_REM_NO;

	@Column(name = "RLD_REM_TYPE")
	private String RLD_REM_TYPE;

	@Column(name = "RLD_REM_ID")
	private Integer RLD_REM_ID;

	@Column(name = "RLD_PROCESS_DT")
	private Date RLD_PROCESS_DT;

	@Column(name = "RLD_REM_YN")
	private String RLD_REM_YN="N";
	
	private boolean UI_M_SELECT;

	public boolean isUI_M_SELECT() {
		return UI_M_SELECT;
	}

	public void setUI_M_SELECT(boolean ui_m_select) {
		UI_M_SELECT = ui_m_select;
	}

	public Long getRLD_SYS_ID() {
		return RLD_SYS_ID;
	}

	public void setRLD_SYS_ID(Long rld_sys_id) {
		RLD_SYS_ID = rld_sys_id;
	}

	public Long getRLD_POL_SYS_ID() {
		return RLD_POL_SYS_ID;
	}

	public void setRLD_POL_SYS_ID(Long rld_pol_sys_id) {
		RLD_POL_SYS_ID = rld_pol_sys_id;
	}

	public Integer getRLD_END_NO_IDX() {
		return RLD_END_NO_IDX;
	}

	public void setRLD_END_NO_IDX(Integer rld_end_no_idx) {
		RLD_END_NO_IDX = rld_end_no_idx;
	}

	public String getRLD_POL_NO() {
		return RLD_POL_NO;
	}

	public void setRLD_POL_NO(String rld_pol_no) {
		RLD_POL_NO = rld_pol_no;
	}

	public String getRLD_ASSURED_NAME() {
		return RLD_ASSURED_NAME;
	}

	public void setRLD_ASSURED_NAME(String rld_assured_name) {
		RLD_ASSURED_NAME = rld_assured_name;
	}

	public Double getRLD_FC_SUM_ASSURED() {
		return RLD_FC_SUM_ASSURED;
	}

	public void setRLD_FC_SUM_ASSURED(Double rld_fc_sum_assured) {
		RLD_FC_SUM_ASSURED = rld_fc_sum_assured;
	}

	public String getRLD_MODE_OF_PYMT() {
		return RLD_MODE_OF_PYMT;
	}

	public void setRLD_MODE_OF_PYMT(String rld_mode_of_pymt) {
		RLD_MODE_OF_PYMT = rld_mode_of_pymt;
	}

	public Date getRLD_ISSUE_DT() {
		return RLD_ISSUE_DT;
	}

	public void setRLD_ISSUE_DT(Date rld_issue_dt) {
		RLD_ISSUE_DT = rld_issue_dt;
	}

	public Double getRLD_PREM_FC() {
		return RLD_PREM_FC;
	}

	public void setRLD_PREM_FC(Double rld_prem_fc) {
		RLD_PREM_FC = rld_prem_fc;
	}

	public String getRLD_REM_NO() {
		return RLD_REM_NO;
	}

	public void setRLD_REM_NO(String rld_rem_no) {
		RLD_REM_NO = rld_rem_no;
	}

	public String getRLD_REM_TYPE() {
		return RLD_REM_TYPE;
	}

	public void setRLD_REM_TYPE(String rld_rem_type) {
		RLD_REM_TYPE = rld_rem_type;
	}

	public Integer getRLD_REM_ID() {
		return RLD_REM_ID;
	}

	public void setRLD_REM_ID(Integer rld_rem_id) {
		RLD_REM_ID = rld_rem_id;
	}

	public Date getRLD_PROCESS_DT() {
		return RLD_PROCESS_DT;
	}

	public void setRLD_PROCESS_DT(Date rld_process_dt) {
		RLD_PROCESS_DT = rld_process_dt;
	}

	public String getRLD_REM_YN() {
		return RLD_REM_YN;
	}

	public void setRLD_REM_YN(String rld_rem_yn) {
		RLD_REM_YN = rld_rem_yn;
	}

}
