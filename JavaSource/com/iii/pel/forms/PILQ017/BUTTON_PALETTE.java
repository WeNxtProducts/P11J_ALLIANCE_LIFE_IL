package com.iii.pel.forms.PILQ017;

import java.sql.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class BUTTON_PALETTE extends BaseValueBean {
	private String M_COMP_NAME;
	private Date M_RUN_DATE;
	public String getM_COMP_NAME() {
		return M_COMP_NAME;
	}
	public void setM_COMP_NAME(String m_comp_name) {
		M_COMP_NAME = m_comp_name;
	}
	public Date getM_RUN_DATE() {
		return M_RUN_DATE;
	}
	public void setM_RUN_DATE(Date m_run_date) {
		M_RUN_DATE = m_run_date;
	}

}
