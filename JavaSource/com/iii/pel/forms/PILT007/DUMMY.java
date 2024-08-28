package com.iii.pel.forms.PILT007;

import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {
	private String M_PS_VALUE;
	
	private Double M_IL_BEN_VALUE;
	
	private String M_BASE_CURR;

	public String getM_BASE_CURR() {
		return M_BASE_CURR;
	}

	public void setM_BASE_CURR(String m_base_curr) {
		M_BASE_CURR = m_base_curr;
	}

	public Double getM_IL_BEN_VALUE() {
		return M_IL_BEN_VALUE;
	}

	public void setM_IL_BEN_VALUE(Double m_il_ben_value) {
		M_IL_BEN_VALUE = m_il_ben_value;
	}

	public String getM_PS_VALUE() {
		return M_PS_VALUE;
	}

	public void setM_PS_VALUE(String m_ps_value) {
		M_PS_VALUE = m_ps_value;
	}

}
