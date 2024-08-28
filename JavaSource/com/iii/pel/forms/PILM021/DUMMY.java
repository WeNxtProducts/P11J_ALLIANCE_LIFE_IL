package com.iii.pel.forms.PILM021;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {
private String M_ACTY_HEAD_1;
	
	private String M_ACTY_HEAD_2;
	
	private String M_ACTY_1;
	
	private String M_ACTY_2;

	public String getM_ACTY_2() {
		return M_ACTY_2;
	}

	public void setM_ACTY_2(String m_acty_2) {
		M_ACTY_2 = m_acty_2;
	}

	public String getM_ACTY_1() {
		return M_ACTY_1;
	}

	public void setM_ACTY_1(String m_acty_1) {
		M_ACTY_1 = m_acty_1;
	}

	public String getM_ACTY_HEAD_1() {
		return M_ACTY_HEAD_1;
	}

	public void setM_ACTY_HEAD_1(String m_acty_head_1) {
		M_ACTY_HEAD_1 = m_acty_head_1;
	}

	public String getM_ACTY_HEAD_2() {
		return M_ACTY_HEAD_2;
	}

	public void setM_ACTY_HEAD_2(String m_acty_head_2) {
		M_ACTY_HEAD_2 = m_acty_head_2;
	}

}
