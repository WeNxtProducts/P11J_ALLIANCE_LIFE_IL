package com.iii.pel.forms.PILM204;

public class PM_IL_FORMULA_COMPOSITEBEAN {

	
	private PM_IL_FORMULA_ACTION PM_IL_FORMULA_ACTION;
	private PM_IL_FORMULA_DTL_ACTION PM_IL_FORMULA_DTL_ACTION;
	private PM_IL_FORMULA_PARAM_ACTION PM_IL_FORMULA_PARAM_ACTION_BEAN; 
	
	public PM_IL_FORMULA_COMPOSITEBEAN() {
		// TODO Auto-generated constructor stub
		PM_IL_FORMULA_DTL_ACTION = new PM_IL_FORMULA_DTL_ACTION();
		PM_IL_FORMULA_ACTION = new PM_IL_FORMULA_ACTION();
		PM_IL_FORMULA_PARAM_ACTION_BEAN = new PM_IL_FORMULA_PARAM_ACTION();
		PM_IL_FORMULA_PARAM_ACTION_BEAN.compositeAction = this;
		PM_IL_FORMULA_ACTION.compositeAction=this;
		PM_IL_FORMULA_DTL_ACTION.compositeAction=this;
	}

	public PM_IL_FORMULA_ACTION getPM_IL_FORMULA_ACTION() {
		return PM_IL_FORMULA_ACTION;
	}

	public PM_IL_FORMULA_PARAM_ACTION getPM_IL_FORMULA_PARAM_ACTION_BEAN() {
		return PM_IL_FORMULA_PARAM_ACTION_BEAN;
	}

	public void setPM_IL_FORMULA_PARAM_ACTION_BEAN(
			PM_IL_FORMULA_PARAM_ACTION pm_il_formula_param_action_bean) {
		PM_IL_FORMULA_PARAM_ACTION_BEAN = pm_il_formula_param_action_bean;
	}

	public void setPM_IL_FORMULA_ACTION(PM_IL_FORMULA_ACTION pm_il_formula_action) {
		PM_IL_FORMULA_ACTION = pm_il_formula_action;
	}

	public PM_IL_FORMULA_DTL_ACTION getPM_IL_FORMULA_DTL_ACTION() {
		return PM_IL_FORMULA_DTL_ACTION;
	}

	public void setPM_IL_FORMULA_DTL_ACTION(
			PM_IL_FORMULA_DTL_ACTION pm_il_formula_dtl_action) {
		PM_IL_FORMULA_DTL_ACTION = pm_il_formula_dtl_action;
	}
	
	public String goFormula(){
		return "PILM204_PM_IL_FORMULA_PARAM";
	}
	
}
