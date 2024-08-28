package com.iii.pel.forms.PILM015_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROP_TREATY_PERIOD")
public class PM_IL_PROP_TREATY_PERIOD extends BaseValueBean {

	@Column(name="PPTP_PT_TREATY_CODE")
	private String PPTP_PT_TREATY_CODE;

	@Column(name="PPTP_MON_FM")
	private Integer PPTP_MON_FM;

	@Column(name="PPTP_MON_TO")
	private Integer PPTP_MON_TO;

	@Column(name="PPTP_SUB_NO")
	private Integer PPTP_SUB_NO;
	
	private boolean selected;



	public String getPPTP_PT_TREATY_CODE() {
		return PPTP_PT_TREATY_CODE;
	}

	public void setPPTP_PT_TREATY_CODE(String PPTP_PT_TREATY_CODE) {
		this.PPTP_PT_TREATY_CODE = PPTP_PT_TREATY_CODE;
	}


	public Integer getPPTP_MON_FM() {
		return PPTP_MON_FM;
	}

	public void setPPTP_MON_FM(Integer pptp_mon_fm) {
		PPTP_MON_FM = pptp_mon_fm;
	}

	public Integer getPPTP_MON_TO() {
		return PPTP_MON_TO;
	}

	public void setPPTP_MON_TO(Integer pptp_mon_to) {
		PPTP_MON_TO = pptp_mon_to;
	}

	public Integer getPPTP_SUB_NO() {
		return PPTP_SUB_NO;
	}

	public void setPPTP_SUB_NO(Integer pptp_sub_no) {
		PPTP_SUB_NO = pptp_sub_no;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
