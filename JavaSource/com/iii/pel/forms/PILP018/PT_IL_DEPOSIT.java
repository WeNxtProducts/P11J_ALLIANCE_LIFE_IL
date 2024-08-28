package com.iii.pel.forms.PILP018;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_DEPOSIT")
public class PT_IL_DEPOSIT extends BaseValueBean {

	private String UI_M_DPD_REF_ID;

	private Double UI_M_DEP_FC_DEP_AMT;
		
	private boolean CHECK_BOX;

	@Column(name="DEP_LC_DEP_AMT")
	private Double DEP_LC_DEP_AMT;

	private String M_WHERE;

	public String getM_WHERE() {
	    return M_WHERE;
	}

	public void setM_WHERE(String m_where) {
	    M_WHERE = m_where;
	}

	public String getUI_M_DPD_REF_ID() {
		return UI_M_DPD_REF_ID;
	}

	public void setUI_M_DPD_REF_ID(String UI_M_DPD_REF_ID) {
		this.UI_M_DPD_REF_ID = UI_M_DPD_REF_ID;
	}

	public Double getUI_M_DEP_FC_DEP_AMT() {
		return UI_M_DEP_FC_DEP_AMT;
	}

	public void setUI_M_DEP_FC_DEP_AMT(Double UI_M_DEP_FC_DEP_AMT) {
		this.UI_M_DEP_FC_DEP_AMT = UI_M_DEP_FC_DEP_AMT;
	}

	public Double getDEP_LC_DEP_AMT() {
		return DEP_LC_DEP_AMT;
	}

	public void setDEP_LC_DEP_AMT(Double DEP_LC_DEP_AMT) {
		this.DEP_LC_DEP_AMT = DEP_LC_DEP_AMT;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	
	
}
