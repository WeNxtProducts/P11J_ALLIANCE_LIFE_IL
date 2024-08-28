package com.iii.pel.forms.PM104_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_WITH_DRAWL_SETUP")
public class PM_AGENT_WITH_DRAWL_SETUP extends BaseValueBean {
	
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="AWDS_TYPE")
	private String AWDS_TYPE;

	@Column(name="AWDS_JOIN_AGE_FM")
	private Integer AWDS_JOIN_AGE_FM;

	@Column(name="AWDS_JOIN_AGE_TO")
	private Integer AWDS_JOIN_AGE_TO;

	@Column(name="AWDS_CURR_AGE_FM")
	private Integer AWDS_CURR_AGE_FM;

	@Column(name="AWDS_CURR_AGE_TO")
	private Integer AWDS_CURR_AGE_TO;

	@Column(name="AWDS_NO_YRS_EXP_FM")
	private Integer AWDS_NO_YRS_EXP_FM;

	@Column(name="AWDS_NO_YRS_EXP_TO")
	private Integer AWDS_NO_YRS_EXP_TO;

	@Column(name="AWDS_PAY_RATE")
	private Double AWDS_PAY_RATE;

	@Column(name="AWDS_PAY_RATE_PER")
	private Integer AWDS_PAY_RATE_PER;

	@Column(name="AWDS_PAY_SHARE_TYPE")
	private String AWDS_PAY_SHARE_TYPE;

	@Column(name="AWDS_LC_FUND_BAL")
	private Double AWDS_LC_FUND_BAL;

	@Column(name="AWDS_CR_UID")
	private String AWDS_CR_UID;
	
	@Column(name="AWDS_CR_DT")
	private Date AWDS_CR_DT;
	
	@Column(name="AWDS_UPD_DT")
	private Date AWDS_UPD_DT;
	
	@Column(name="AWDS_UPD_UID")
	private String AWDS_UPD_UID;
	
	private String UI_M_AWDS_TYPE_DESC;


	public String getAWDS_TYPE() {
		return AWDS_TYPE;
	}

	public void setAWDS_TYPE(String AWDS_TYPE) {
		this.AWDS_TYPE = AWDS_TYPE;
	}

	

	public Double getAWDS_PAY_RATE() {
		return AWDS_PAY_RATE;
	}

	public void setAWDS_PAY_RATE(Double AWDS_PAY_RATE) {
		this.AWDS_PAY_RATE = AWDS_PAY_RATE;
	}

	
	public String getAWDS_PAY_SHARE_TYPE() {
		return AWDS_PAY_SHARE_TYPE;
	}

	public void setAWDS_PAY_SHARE_TYPE(String AWDS_PAY_SHARE_TYPE) {
		this.AWDS_PAY_SHARE_TYPE = AWDS_PAY_SHARE_TYPE;
	}

	public Double getAWDS_LC_FUND_BAL() {
		return AWDS_LC_FUND_BAL;
	}

	public void setAWDS_LC_FUND_BAL(Double AWDS_LC_FUND_BAL) {
		this.AWDS_LC_FUND_BAL = AWDS_LC_FUND_BAL;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getAWDS_CR_UID() {
		return AWDS_CR_UID;
	}

	public void setAWDS_CR_UID(String awds_cr_uid) {
		AWDS_CR_UID = awds_cr_uid;
	}

	public Date getAWDS_CR_DT() {
		return AWDS_CR_DT;
	}

	public void setAWDS_CR_DT(Date awds_cr_dt) {
		AWDS_CR_DT = awds_cr_dt;
	}

	public Date getAWDS_UPD_DT() {
		return AWDS_UPD_DT;
	}

	public void setAWDS_UPD_DT(Date awds_upd_dt) {
		AWDS_UPD_DT = awds_upd_dt;
	}

	public String getAWDS_UPD_UID() {
		return AWDS_UPD_UID;
	}

	public void setAWDS_UPD_UID(String awds_upd_uid) {
		AWDS_UPD_UID = awds_upd_uid;
	}

	public String getUI_M_AWDS_TYPE_DESC() {
		return UI_M_AWDS_TYPE_DESC;
	}

	public void setUI_M_AWDS_TYPE_DESC(String ui_m_awds_type_desc) {
		UI_M_AWDS_TYPE_DESC = ui_m_awds_type_desc;
	}

	public Integer getAWDS_JOIN_AGE_FM() {
		return AWDS_JOIN_AGE_FM;
	}

	public void setAWDS_JOIN_AGE_FM(Integer awds_join_age_fm) {
		AWDS_JOIN_AGE_FM = awds_join_age_fm;
	}

	public Integer getAWDS_JOIN_AGE_TO() {
		return AWDS_JOIN_AGE_TO;
	}

	public void setAWDS_JOIN_AGE_TO(Integer awds_join_age_to) {
		AWDS_JOIN_AGE_TO = awds_join_age_to;
	}

	public Integer getAWDS_CURR_AGE_FM() {
		return AWDS_CURR_AGE_FM;
	}

	public void setAWDS_CURR_AGE_FM(Integer awds_curr_age_fm) {
		AWDS_CURR_AGE_FM = awds_curr_age_fm;
	}

	public Integer getAWDS_CURR_AGE_TO() {
		return AWDS_CURR_AGE_TO;
	}

	public void setAWDS_CURR_AGE_TO(Integer awds_curr_age_to) {
		AWDS_CURR_AGE_TO = awds_curr_age_to;
	}

	public Integer getAWDS_NO_YRS_EXP_FM() {
		return AWDS_NO_YRS_EXP_FM;
	}

	public void setAWDS_NO_YRS_EXP_FM(Integer awds_no_yrs_exp_fm) {
		AWDS_NO_YRS_EXP_FM = awds_no_yrs_exp_fm;
	}

	public Integer getAWDS_NO_YRS_EXP_TO() {
		return AWDS_NO_YRS_EXP_TO;
	}

	public void setAWDS_NO_YRS_EXP_TO(Integer awds_no_yrs_exp_to) {
		AWDS_NO_YRS_EXP_TO = awds_no_yrs_exp_to;
	}

	public Integer getAWDS_PAY_RATE_PER() {
		return AWDS_PAY_RATE_PER;
	}

	public void setAWDS_PAY_RATE_PER(Integer awds_pay_rate_per) {
		AWDS_PAY_RATE_PER = awds_pay_rate_per;
	}
	
	
}
