package com.iii.pel.forms.PILP060_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PROCESS")
public class PT_IL_PROCESS extends BaseValueBean {

	private String UI_M_POL_NO;

	@Column(name="PR_ERROR_DESC")
	private String PR_ERROR_DESC;

	@Column(name="PR_PROCESS_TYPE")
	private String  PR_PROCESS_TYPE;
	@Column(name="PR_POL_SYS_ID")
	private Double  PR_POL_SYS_ID;
	@Column(name="PR_DATE")
	private Date  PR_DATE;

	@Column(name="PR_CR_DT")
	private Date  PR_CR_DT;
	@Column(name="PR_CR_UID")
	private String  PR_CR_UID;


	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getPR_ERROR_DESC() {
		return PR_ERROR_DESC;
	}

	public void setPR_ERROR_DESC(String PR_ERROR_DESC) {
		this.PR_ERROR_DESC = PR_ERROR_DESC;
	}

	public String getPR_PROCESS_TYPE() {
		return PR_PROCESS_TYPE;
	}

	public void setPR_PROCESS_TYPE(String pr_process_type) {
		PR_PROCESS_TYPE = pr_process_type;
	}

	public Double getPR_POL_SYS_ID() {
		return PR_POL_SYS_ID;
	}

	public void setPR_POL_SYS_ID(Double pr_pol_sys_id) {
		PR_POL_SYS_ID = pr_pol_sys_id;
	}

	public Date getPR_DATE() {
		return PR_DATE;
	}

	public void setPR_DATE(Date pr_date) {
		PR_DATE = pr_date;
	}

	public Date getPR_CR_DT() {
		return PR_CR_DT;
	}

	public void setPR_CR_DT(Date pr_cr_dt) {
		PR_CR_DT = pr_cr_dt;
	}

	public String getPR_CR_UID() {
		return PR_CR_UID;
	}

	public void setPR_CR_UID(String pr_cr_uid) {
		PR_CR_UID = pr_cr_uid;
	}
}
