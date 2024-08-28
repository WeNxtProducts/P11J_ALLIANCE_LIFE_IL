package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;
	
	private HtmlCommandButton COMP_SYS_CALC;
	
	private HtmlCommandButton COMP_USR_CALC;
	
	public PILT010_COMPOSITE_ACTION compositeAction;

	public PILT010_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT010_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	public void nextRecordWhenButtonPressed() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			helper.nextRecordButton();
		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
	}
	
	public String policyWhenButtonPressed() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			helper.policyButton();
		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
		return "PILT010_POLICY";
	}
	
	public void systemCalcWhenButtonPressed() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			helper.sysCalcButton();
		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
	}
	
	public void userCalcWhenButtonPressed() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			helper.userCalcButton();
		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
	}
	
	public String historyWhenButtonPressed() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			helper.historyButton();
			new PT_IL_RI_DETL_1_HELPER().postQuery(compositeAction);
		} catch (Exception e) {
			//pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			//pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
		return "PILT010_HISTORY";
	}
	
	
	
	

	public String policyIlRIDetails() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		
		try {
			/*added by raja on 18-07-2017 for ZBILQC-1730094*/
			compositeAction.getPILT010_PT_IL_RI_DETL_ACTION().setBlockFlag(true);
			/*end*/
			/*
			helper.executeRiTransDetails();
			ptRiDetlAction.resetSelectedRow();
			if(ptRiDetlAction.getDataList_PT_IL_RI_DETL().size()>0){
				ptRiDetlAction.setPT_IL_RI_DETL_BEAN(ptRiDetlAction.getDataList_PT_IL_RI_DETL().get(0));
				ptRiDetlAction.getPT_IL_RI_DETL_BEAN().setRowSelected(true);
			}*/
			
		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
		
		return "PILT010_PT_IL_RI_DETL";
	}
	public String policyIlRIPremAllocDetails() {
		/*added by raja on 18-07-2017 for ZBILQC-1730094*/
		compositeAction.getPILT010_PT_IL_RI_PREM_ALLOC_ACTION().setBlockFlag(true);
		/*end*/
		return "PILT010_PT_IL_RI_PREM_ALLOC";
	}
	
	

	public String facWhenButtonPressed() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			helper.facButton();
		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
		return "PILT010_FAC";
	}
	
	public void saveRecord(ActionEvent event){
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
			PT_IL_RI_DETL_HELPER ptRiDetlHelper = new PT_IL_RI_DETL_HELPER();
			ptRiDetlHelper.executeQuery();
			/*new DUMMY_HELPER().keyCommit();
			pvPolRiDetlAction.getWarningMap().put("current", "Record Saved.");
		
			pvPolRiDetlAction.setWarningMessages("Record Saved.");*/
			ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().setRowSelected(true);

		} catch (Exception e) {
			pvPolRiDetlAction.getErrorMap().put("current", e.getMessage());
			pvPolRiDetlAction.setErrorMessages(e.getMessage());
		}
	}
	
	public String backButton(){
		return "PILT002_APAC_PT_IL_POLICY";
	}
	
	public String mainButton(){
		return "PILT010";
	}

	public HtmlCommandButton getCOMP_SYS_CALC() {
		return COMP_SYS_CALC;
	}

	public void setCOMP_SYS_CALC(HtmlCommandButton comp_sys_calc) {
		COMP_SYS_CALC = comp_sys_calc;
	}

	public HtmlCommandButton getCOMP_USR_CALC() {
		return COMP_USR_CALC;
	}

	public void setCOMP_USR_CALC(HtmlCommandButton comp_usr_calc) {
		COMP_USR_CALC = comp_usr_calc;
	}
	
	public void ri_closeWhenButtonPressed(){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		try{
			helper.WHEN_M_BUT_RI_CLOSE();
		}
		catch (Exception e) {
			e.printStackTrace();
			pvPolRiDetlAction.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			pvPolRiDetlAction.getErrorMap().put("CURRENT", e.getMessage());
			
		}
		
		
	}
	
	
	
	
	
	
}
