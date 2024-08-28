package com.iii.pel.forms.PILP023;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@SuppressWarnings("serial")
@Table(name="PT_IL_DEPOSIT")
public class PT_IL_DEPOSIT extends BaseValueBean {

	private String UI_M_DPD_REF_ID;

	private Double UI_M_DEP_FC_DEP_AMT;

	@Column(name="DEP_LC_DEP_AMT")
	private Double DEP_LC_DEP_AMT;
	
	@Column(name="DEP_SYS_ID")
	private Double DEP_SYS_ID;

	public Double getDEP_SYS_ID() {
		return DEP_SYS_ID;
	}

	public void setDEP_SYS_ID(Double dep_sys_id) {
		DEP_SYS_ID = dep_sys_id;
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
	
	/*Added by Ameen on 20-06-2017 for ZBILQC-1720414 */
	@Column(name="DEP_FLEX_01")
	private String DEP_FLEX_01;

	@Column(name="DEP_FLEX_02")
	private String DEP_FLEX_02;
	
	@Column(name="DEP_FLEX_03")
	private String DEP_FLEX_03;
	
	@Column(name="DEP_FLEX_04")
	private String DEP_FLEX_04;

	public String getDEP_FLEX_01() {
		return DEP_FLEX_01;
	}

	public void setDEP_FLEX_01(String dEP_FLEX_01) {
		DEP_FLEX_01 = dEP_FLEX_01;
	}

	public String getDEP_FLEX_02() {
		return DEP_FLEX_02;
	}

	public void setDEP_FLEX_02(String dEP_FLEX_02) {
		DEP_FLEX_02 = dEP_FLEX_02;
	}

	public String getDEP_FLEX_03() {
		return DEP_FLEX_03;
	}

	public void setDEP_FLEX_03(String dEP_FLEX_03) {
		DEP_FLEX_03 = dEP_FLEX_03;
	}

	public String getDEP_FLEX_04() {
		return DEP_FLEX_04;
	}

	public void setDEP_FLEX_04(String dEP_FLEX_04) {
		DEP_FLEX_04 = dEP_FLEX_04;
	}
	
	/*end*/
}
