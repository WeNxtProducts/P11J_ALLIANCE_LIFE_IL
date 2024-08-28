package com.iii.pel.forms.PILT011;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class BUTTON_PALETTE extends BaseValueBean {

	private String M_RUN_DATE;
	private String M_COMP_NAME;
	public String getM_RUN_DATE() {
		return M_RUN_DATE;
	}
	public void setM_RUN_DATE(String m_run_date) {
		M_RUN_DATE = m_run_date;
	}
	public String getM_COMP_NAME() {
		return M_COMP_NAME;
	}
	public void setM_COMP_NAME(String m_comp_name) {
		M_COMP_NAME = m_comp_name;
	}
}
