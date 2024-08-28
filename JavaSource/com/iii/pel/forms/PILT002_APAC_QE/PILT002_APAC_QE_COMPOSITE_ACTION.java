package com.iii.pel.forms.PILT002_APAC_QE;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizardPanel;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER_ACTION;


public class PILT002_APAC_QE_COMPOSITE_ACTION {
	
	private PW_IL_QQUOT_APPL_COVER_ACTION PW_IL_QQUOT_APPL_COVER_ACTION_BEAN;
	private PW_IL_QUICK_QUOTE_ACTION PW_IL_QUICK_QUOTE_ACTION_BEAN;
	private PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN;
	//private PM006_QE_CUSTOMER_ACTION PM006_QE_CUSTOMER_ACTION_BEAN;
	//private PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN;
/*	addeed by krithika*/
	private PRINT_ACTION PRINT_ACTION_BEAN ;
	public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}
	
	private UIWizard wizard=null;
	private UIWizardPanel wizardPanel = null;
	
	public PILT002_APAC_QE_COMPOSITE_ACTION(){
		PW_IL_QQUOT_APPL_COVER_ACTION_BEAN = new PW_IL_QQUOT_APPL_COVER_ACTION();
		// PM006_QE_CUSTOMER_ACTION_BEAN = new PM006_QE_CUSTOMER_ACTION();
		try {
			//PILT002_APAC_COMPOSITE_ACTION_BEAN = new PILT002_APAC_COMPOSITE_ACTION();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//PW_IL_QQUOT_ASSURED_DTLS_ACTION_BEAN = new PT_IL_QUICK_POL_ASSURED_DTLS_ACTION();
		PW_IL_QUICK_QUOTE_ACTION_BEAN = new PW_IL_QUICK_QUOTE_ACTION();
		try {
			PRINT_ACTION_BEAN = new PRINT_ACTION();
			PRINT_ACTION_BEAN.compositeAction=this;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wizard = new UIWizard();
		wizardPanel = new UIWizardPanel();
		
		PW_IL_QQUOT_APPL_COVER_ACTION_BEAN.compositeAction=this;
		PW_IL_QUICK_QUOTE_ACTION_BEAN.compositeAction=this;
	//	PW_IL_QQUOT_ASSURED_DTLS_ACTION_BEAN.compositeAction=this;
		//PRINT_ACTION_BEAN.compositeAction=this;
	}

/*	public PM006_QE_CUSTOMER_ACTION getPM006_QE_CUSTOMER_ACTION_BEAN() {
		return PM006_QE_CUSTOMER_ACTION_BEAN;
	}

	public void setPM006_QE_CUSTOMER_ACTION_BEAN(
			PM006_QE_CUSTOMER_ACTION pM006_QE_CUSTOMER_ACTION_BEAN) {
		PM006_QE_CUSTOMER_ACTION_BEAN = pM006_QE_CUSTOMER_ACTION_BEAN;
	}
*/
	public PW_IL_QUICK_QUOTE getPW_IL_QUICK_QUOTE_BEAN() {
		return PW_IL_QUICK_QUOTE_BEAN;
	}

	public void setPW_IL_QUICK_QUOTE_BEAN(PW_IL_QUICK_QUOTE pW_IL_QUICK_QUOTE_BEAN) {
		PW_IL_QUICK_QUOTE_BEAN = pW_IL_QUICK_QUOTE_BEAN;
	}

	public PW_IL_QQUOT_APPL_COVER_ACTION getPW_IL_QQUOT_APPL_COVER_ACTION_BEAN() {
		return PW_IL_QQUOT_APPL_COVER_ACTION_BEAN;
	}

	public void setPW_IL_QQUOT_APPL_COVER_ACTION_BEAN(
			PW_IL_QQUOT_APPL_COVER_ACTION pw_il_qquot_appl_cover_action_bean) {
		PW_IL_QQUOT_APPL_COVER_ACTION_BEAN = pw_il_qquot_appl_cover_action_bean;
	}

	
	public PW_IL_QUICK_QUOTE_ACTION getPW_IL_QUICK_QUOTE_ACTION_BEAN() {
		return PW_IL_QUICK_QUOTE_ACTION_BEAN;
	}

	public void setPW_IL_QUICK_QUOTE_ACTION_BEAN(
			PW_IL_QUICK_QUOTE_ACTION pw_il_quick_quote_action_bean) {
		PW_IL_QUICK_QUOTE_ACTION_BEAN = pw_il_quick_quote_action_bean;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public UIWizardPanel getWizardPanel() {
		return wizardPanel;
	}

	public void setWizardPanel(UIWizardPanel wizardPanel) {
		this.wizardPanel = wizardPanel;
	}

	
	/*added by soundarya*/
	
	public String navigation() {
		//setImmediate(true);
		getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().clear();
		getWizard().setImmediate("true");
		return "";

	}

/*end*/
	
	
	/*public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}
*/
}
