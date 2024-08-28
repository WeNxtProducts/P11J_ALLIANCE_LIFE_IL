package com.iii.pel.forms.PILM030;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;

public class PM_IL_HTWT_DTL_COMPOSITE_ACTION {

	PM_IL_HTWT_DTL_ACTION PM_IL_HTWT_DTL_ACTION;

	public PM_IL_HTWT_DTL_COMPOSITE_ACTION() {

		PM_IL_HTWT_DTL_ACTION = new PM_IL_HTWT_DTL_ACTION();
		
		/*added by raja on 04-03-2017 for ssp call id- ZBILQC-1720494 */

		PM_IL_HTWT_DTL_ACTION.compositeAction=this;
		
		/*end*/
	}

	public PM_IL_HTWT_DTL_ACTION getPM_IL_HTWT_DTL_ACTION() {
		return PM_IL_HTWT_DTL_ACTION;
	}

	public void setPM_IL_HTWT_DTL_ACTION(
			PM_IL_HTWT_DTL_ACTION pm_il_htwt_dtl_action) {
		PM_IL_HTWT_DTL_ACTION = pm_il_htwt_dtl_action;
		
	}
	
	
	/*Added by Janani on 1.06.2017 for ZBILQC-1724655 */
	
	private UIWizard wizard =null;
	
	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public String navigationEnabled(){
		
		PM_IL_HTWT_DTL_ACTION.getErrorMap().clear();
		PM_IL_HTWT_DTL_ACTION.getWarningMap().clear();
		
		//getWizard().setImmediate("true");
		 return "";
		
	}
	
	/*End*/

	
}
