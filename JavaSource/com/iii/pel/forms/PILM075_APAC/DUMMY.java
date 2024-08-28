package com.iii.pel.forms.PILM075_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String PM_IL_APPR_SETUP_CF;
	private String PM_IL_APPR_DEPT_SETUP_CF;
	public String getPM_IL_APPR_SETUP_CF() {
		return PM_IL_APPR_SETUP_CF;
	}
	public void setPM_IL_APPR_SETUP_CF(String pm_il_appr_setup_cf) {
		PM_IL_APPR_SETUP_CF = pm_il_appr_setup_cf;
	}
	public String getPM_IL_APPR_DEPT_SETUP_CF() {
		return PM_IL_APPR_DEPT_SETUP_CF;
	}
	public void setPM_IL_APPR_DEPT_SETUP_CF(String pm_il_appr_dept_setup_cf) {
		PM_IL_APPR_DEPT_SETUP_CF = pm_il_appr_dept_setup_cf;
	} 

}
