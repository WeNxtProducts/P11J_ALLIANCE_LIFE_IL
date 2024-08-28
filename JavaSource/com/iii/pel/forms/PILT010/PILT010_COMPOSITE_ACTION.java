package com.iii.pel.forms.PILT010;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;


public class PILT010_COMPOSITE_ACTION {
	
	private PT_IL_RI_DETL_1_ACTION PILT010_PT_IL_RI_DETL_1_ACTION;
	private PT_IL_RI_DETL_ACTION PILT010_PT_IL_RI_DETL_ACTION;
	private PT_IL_RI_DISC_LOAD_ACTION PILT010_PT_IL_RI_DISC_LOAD_ACTION;
	private PT_IL_RI_PREM_ALLOC_1_ACTION PILT010_PT_IL_RI_PREM_ALLOC_1_ACTION;
	private PT_IL_RI_PREM_ALLOC_ACTION PILT010_PT_IL_RI_PREM_ALLOC_ACTION;
	private PV_IL_POL_RI_DETL_ACTION PILT010_PV_IL_POL_RI_DETL_ACTION;
	private ERROR_HELP_ACTION PILT010_ERROR_HELP_ACTION;
	private DUMMY_ACTION PILT010_DUMMY_ACTION;
	private CTRL1_ACTION PILT010_CTRL1_ACTION;
	private CTRL_ACTION PILT010_CTRL_ACTION;
	private BUTTON_PALETTE_ACTION PILT010_BUTTON_PALETTE_ACTION;
	private BP_ACTION PILT010_BP_ACTION;
	private UIWizard wizard;

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public PILT010_COMPOSITE_ACTION() {
		wizard = new UIWizard();
		PILT010_PT_IL_RI_DETL_1_ACTION = new PT_IL_RI_DETL_1_ACTION();
		PILT010_PT_IL_RI_DETL_ACTION = new PT_IL_RI_DETL_ACTION();
		PILT010_PT_IL_RI_DISC_LOAD_ACTION = new PT_IL_RI_DISC_LOAD_ACTION();
		PILT010_PT_IL_RI_PREM_ALLOC_1_ACTION = new PT_IL_RI_PREM_ALLOC_1_ACTION();
		PILT010_PT_IL_RI_PREM_ALLOC_ACTION = new PT_IL_RI_PREM_ALLOC_ACTION();
		PILT010_PV_IL_POL_RI_DETL_ACTION = new PV_IL_POL_RI_DETL_ACTION();
		PILT010_ERROR_HELP_ACTION = new ERROR_HELP_ACTION();
		PILT010_DUMMY_ACTION = new DUMMY_ACTION();
		PILT010_CTRL1_ACTION = new CTRL1_ACTION();
		PILT010_CTRL_ACTION = new CTRL_ACTION();
		PILT010_PT_IL_RI_DETL_ACTION.compositeAction=this;
		PILT010_PT_IL_RI_DETL_1_ACTION.compositeAction=this;
		PILT010_PT_IL_RI_PREM_ALLOC_ACTION.compositeAction=this;
		PILT010_PV_IL_POL_RI_DETL_ACTION.compositeAction = this;
		PILT010_PT_IL_RI_PREM_ALLOC_1_ACTION.compositeAction = this;
		PILT010_BUTTON_PALETTE_ACTION = new BUTTON_PALETTE_ACTION();
		PILT010_BP_ACTION = new BP_ACTION();
		PILT010_DUMMY_ACTION.compositeAction = this;
	}

	public PT_IL_RI_DETL_1_ACTION getPILT010_PT_IL_RI_DETL_1_ACTION() {
		return PILT010_PT_IL_RI_DETL_1_ACTION;
	}

	public void setPILT010_PT_IL_RI_DETL_1_ACTION(
			PT_IL_RI_DETL_1_ACTION pilt010_pt_il_ri_detl_1_action) {
		PILT010_PT_IL_RI_DETL_1_ACTION = pilt010_pt_il_ri_detl_1_action;
	}

	public PT_IL_RI_DETL_ACTION getPILT010_PT_IL_RI_DETL_ACTION() {
		return PILT010_PT_IL_RI_DETL_ACTION;
	}

	public void setPILT010_PT_IL_RI_DETL_ACTION(
			PT_IL_RI_DETL_ACTION pilt010_pt_il_ri_detl_action) {
		PILT010_PT_IL_RI_DETL_ACTION = pilt010_pt_il_ri_detl_action;
	}

	public PT_IL_RI_DISC_LOAD_ACTION getPILT010_PT_IL_RI_DISC_LOAD_ACTION() {
		return PILT010_PT_IL_RI_DISC_LOAD_ACTION;
	}

	public void setPILT010_PT_IL_RI_DISC_LOAD_ACTION(
			PT_IL_RI_DISC_LOAD_ACTION pilt010_pt_il_ri_disc_load_action) {
		PILT010_PT_IL_RI_DISC_LOAD_ACTION = pilt010_pt_il_ri_disc_load_action;
	}

	public PT_IL_RI_PREM_ALLOC_1_ACTION getPILT010_PT_IL_RI_PREM_ALLOC_1_ACTION() {
		return PILT010_PT_IL_RI_PREM_ALLOC_1_ACTION;
	}

	public void setPILT010_PT_IL_RI_PREM_ALLOC_1_ACTION(
			PT_IL_RI_PREM_ALLOC_1_ACTION pilt010_pt_il_ri_prem_alloc_1_action) {
		PILT010_PT_IL_RI_PREM_ALLOC_1_ACTION = pilt010_pt_il_ri_prem_alloc_1_action;
	}

	public PT_IL_RI_PREM_ALLOC_ACTION getPILT010_PT_IL_RI_PREM_ALLOC_ACTION() {
		return PILT010_PT_IL_RI_PREM_ALLOC_ACTION;
	}

	public void setPILT010_PT_IL_RI_PREM_ALLOC_ACTION(
			PT_IL_RI_PREM_ALLOC_ACTION pilt010_pt_il_ri_prem_alloc_action) {
		PILT010_PT_IL_RI_PREM_ALLOC_ACTION = pilt010_pt_il_ri_prem_alloc_action;
	}

	public PV_IL_POL_RI_DETL_ACTION getPILT010_PV_IL_POL_RI_DETL_ACTION() {
		return PILT010_PV_IL_POL_RI_DETL_ACTION;
	}

	public void setPILT010_PV_IL_POL_RI_DETL_ACTION(
			PV_IL_POL_RI_DETL_ACTION pilt010_pv_il_pol_ri_detl_action) {
		PILT010_PV_IL_POL_RI_DETL_ACTION = pilt010_pv_il_pol_ri_detl_action;
	}

	public ERROR_HELP_ACTION getPILT010_ERROR_HELP_ACTION() {
		return PILT010_ERROR_HELP_ACTION;
	}

	public void setPILT010_ERROR_HELP_ACTION(
			ERROR_HELP_ACTION pilt010_error_help_action) {
		PILT010_ERROR_HELP_ACTION = pilt010_error_help_action;
	}

	public DUMMY_ACTION getPILT010_DUMMY_ACTION() {
		return PILT010_DUMMY_ACTION;
	}

	public void setPILT010_DUMMY_ACTION(DUMMY_ACTION pilt010_dummy_action) {
		PILT010_DUMMY_ACTION = pilt010_dummy_action;
	}

	public CTRL1_ACTION getPILT010_CTRL1_ACTION() {
		return PILT010_CTRL1_ACTION;
	}

	public void setPILT010_CTRL1_ACTION(CTRL1_ACTION pilt010_ctrl1_action) {
		PILT010_CTRL1_ACTION = pilt010_ctrl1_action;
	}

	public CTRL_ACTION getPILT010_CTRL_ACTION() {
		return PILT010_CTRL_ACTION;
	}

	public void setPILT010_CTRL_ACTION(CTRL_ACTION pilt010_ctrl_action) {
		PILT010_CTRL_ACTION = pilt010_ctrl_action;
	}

	public BUTTON_PALETTE_ACTION getPILT010_BUTTON_PALETTE_ACTION() {
		return PILT010_BUTTON_PALETTE_ACTION;
	}

	public void setPILT010_BUTTON_PALETTE_ACTION(
			BUTTON_PALETTE_ACTION pilt010_button_palette_action) {
		PILT010_BUTTON_PALETTE_ACTION = pilt010_button_palette_action;
	}

	public BP_ACTION getPILT010_BP_ACTION() {
		return PILT010_BP_ACTION;
	}

	public void setPILT010_BP_ACTION(BP_ACTION pilt010_bp_action) {
		PILT010_BP_ACTION = pilt010_bp_action;
	}

	public String reInsurancePremiumAllocation(){
		return null;
	}
	
	public String reInsuranceDetails(){
		return null;
	}
	
	public String premiumAllocation(){
		return null;
	}

}
