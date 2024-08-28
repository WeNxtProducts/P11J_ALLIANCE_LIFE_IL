package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;



@Table(name="PT_IL_POL_ASSR_OCCU_DTLS")
public class PT_IL_POL_ASSR_OCCU_DTLS extends BaseValueBean {

	@Column(name="PAOD_SYS_ID")
	private Long PAOD_SYS_ID;

	@Column(name="PAOD_POL_SYS_ID")
	private Long PAOD_POL_SYS_ID;

	@Column(name="PAOD_POAD_SYS_ID")
	private Long PAOD_POAD_SYS_ID;

	@Column(name="PAOD_COMP_NAME")
	private String PAOD_COMP_NAME;

	@Column(name="PAOD_JOB")
	private String PAOD_JOB;

	@Column(name="PAOD_PERIOD")
	private String PAOD_PERIOD;

	@Column(name="PAOD_CR_DT")
	private Date PAOD_CR_DT;

	@Column(name="PAOD_CR_UID")
	private String PAOD_CR_UID;

	@Column(name="PAOD_UPD_UID")
	private String PAOD_UPD_UID;

	@Column(name="PAOD_UPD_DT")
	private Date PAOD_UPD_DT;

	public Long getPAOD_SYS_ID() {
		return PAOD_SYS_ID;
	}

	public void setPAOD_SYS_ID(Long pAOD_SYS_ID) {
		PAOD_SYS_ID = pAOD_SYS_ID;
	}

	public Long getPAOD_POL_SYS_ID() {
		return PAOD_POL_SYS_ID;
	}

	public void setPAOD_POL_SYS_ID(Long pAOD_POL_SYS_ID) {
		PAOD_POL_SYS_ID = pAOD_POL_SYS_ID;
	}


	public Long getPAOD_POAD_SYS_ID() {
		return PAOD_POAD_SYS_ID;
	}

	public void setPAOD_POAD_SYS_ID(Long pAOD_POAD_SYS_ID) {
		PAOD_POAD_SYS_ID = pAOD_POAD_SYS_ID;
	}

	public String getPAOD_COMP_NAME() {
		return PAOD_COMP_NAME;
	}

	public void setPAOD_COMP_NAME(String pAOD_COMP_NAME) {
		PAOD_COMP_NAME = pAOD_COMP_NAME;
	}

	public String getPAOD_JOB() {
		return PAOD_JOB;
	}

	public void setPAOD_JOB(String pAOD_JOB) {
		PAOD_JOB = pAOD_JOB;
	}

	public String getPAOD_PERIOD() {
		return PAOD_PERIOD;
	}

	public void setPAOD_PERIOD(String pAOD_PERIOD) {
		PAOD_PERIOD = pAOD_PERIOD;
	}

	public Date getPAOD_CR_DT() {
		return PAOD_CR_DT;
	}

	public void setPAOD_CR_DT(Date pAOD_CR_DT) {
		PAOD_CR_DT = pAOD_CR_DT;
	}

	public String getPAOD_CR_UID() {
		return PAOD_CR_UID;
	}

	public void setPAOD_CR_UID(String pAOD_CR_UID) {
		PAOD_CR_UID = pAOD_CR_UID;
	}

	public String getPAOD_UPD_UID() {
		return PAOD_UPD_UID;
	}

	public void setPAOD_UPD_UID(String pAOD_UPD_UID) {
		PAOD_UPD_UID = pAOD_UPD_UID;
	}

	public Date getPAOD_UPD_DT() {
		return PAOD_UPD_DT;
	}

	public void setPAOD_UPD_DT(Date pAOD_UPD_DT) {
		PAOD_UPD_DT = pAOD_UPD_DT;
	}

	/*Added by Janani on 06.05.2018 for FSD_IL_FLA_008*/

	@Column(name="PAOD_PERIOD_FM")
	private Date PAOD_PERIOD_FM;

	@Column(name="PAOD_PERIOD_TO")
	private Date PAOD_PERIOD_TO;

	String status_date = null;
 	
	String status_date_to = null;
			
	public String getStatus_date_to() {
		return status_date_to;
	}

	public void setStatus_date_to(String status_date_to) {
		this.status_date_to = status_date_to;
	}

	public String getStatus_date() {
		return status_date;
	}

	public void setStatus_date(String status_date) {
		this.status_date = status_date;
	}

	public Date getPAOD_PERIOD_FM() {
		return PAOD_PERIOD_FM;
	}

	public void setPAOD_PERIOD_FM(Date pAOD_PERIOD_FM) {
		status_date = CommonUtils.dateToPELStringFormatter(pAOD_PERIOD_FM);
		PAOD_PERIOD_FM = pAOD_PERIOD_FM;
	}

	public Date getPAOD_PERIOD_TO() {
		return PAOD_PERIOD_TO;
	}

	public void setPAOD_PERIOD_TO(Date pAOD_PERIOD_TO) {
		status_date_to = CommonUtils.dateToPELStringFormatter(pAOD_PERIOD_TO);
		PAOD_PERIOD_TO = pAOD_PERIOD_TO;
	}
	
	

	/*eND*/
	
}