package com.iii.pel.forms.PILQ002;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY_1 extends BaseValueBean{

	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="POL_NO")
	private String POL_NO;
	
	@Column(name="POL_PROD_CODE")
	private String POL_PROD_CODE;
	
	@Column(name="POL_PERIOD")
	private Integer POL_PERIOD;
	
	@Column(name="POL_LC_SUM_ASSURED")
	private Double POL_LC_SUM_ASSURED;
	
	@Column(name="POL_STATUS")
	private String POL_STATUS;
	
	private String UI_POL_REC_STATUS_DESC;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	public void setPOL_PROD_CODE(String pol_prod_code) {
		POL_PROD_CODE = pol_prod_code;
	}

	public Integer getPOL_PERIOD() {
		return POL_PERIOD;
	}

	public void setPOL_PERIOD(Integer pol_period) {
		POL_PERIOD = pol_period;
	}

	public Double getPOL_LC_SUM_ASSURED() {
		return POL_LC_SUM_ASSURED;
	}

	public void setPOL_LC_SUM_ASSURED(Double pol_lc_sum_assured) {
		POL_LC_SUM_ASSURED = pol_lc_sum_assured;
	}

	public String getPOL_STATUS() {
		return POL_STATUS;
	}

	public void setPOL_STATUS(String pol_status) {
		POL_STATUS = pol_status;
	}

	public String getUI_POL_REC_STATUS_DESC() {
		return UI_POL_REC_STATUS_DESC;
	}

	public void setUI_POL_REC_STATUS_DESC(String ui_pol_rec_status_desc) {
		UI_POL_REC_STATUS_DESC = ui_pol_rec_status_desc;
	}
	
}
