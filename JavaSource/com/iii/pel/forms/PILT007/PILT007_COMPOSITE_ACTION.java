package com.iii.pel.forms.PILT007;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.pel.commonimpl.summaryimpl.UISummary;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.pel.forms.PILT011.PILT011_COMPOSITE_ACTION;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class PILT007_COMPOSITE_ACTION {

	private DUMMY_ACTION PILT007_DUMMY_ACTION = null;
	private PT_IL_CLAIM_ACTION PILT007_PT_IL_CLAIM_ACTION = null;
	private PT_IL_CLAIM_BENEFICIARY_ACTION PILT007_PT_IL_CLAIM_BENEFICIARY_ACTION = null;
	private PT_IL_CLAIM_PAID_ACTION PILT007_PT_IL_CLAIM_PAID_ACTION = null;
	private PT_IL_CLAIM_PAID_1_ACTION PILT007_PT_IL_CLAIM_PAID_1_ACTION = null;
	private String returnString = null;
	private UIWizard wizard = null;
	private UISummary comp=null;
	
	public UISummary getComp() {
		return comp;
	}

	public void setComp(UISummary comp) {
		this.comp = comp;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public PILT007_COMPOSITE_ACTION() {
		try {
			PILT007_PT_IL_CLAIM_ACTION = new PT_IL_CLAIM_ACTION();
			PILT007_PT_IL_CLAIM_PAID_ACTION = new PT_IL_CLAIM_PAID_ACTION();
			PILT007_PT_IL_CLAIM_PAID_1_ACTION = new PT_IL_CLAIM_PAID_1_ACTION();
			PILT007_PT_IL_CLAIM_BENEFICIARY_ACTION = new PT_IL_CLAIM_BENEFICIARY_ACTION();
			PILT007_DUMMY_ACTION = new DUMMY_ACTION();
			/*	added by gopi for Death Claim Settlement Letter on 11/04/17*/
			PILT007_PRINT_ACTION_BEAN =new PILT007_PRINT_ACTION();
			//end
			
			/*Added by saritha on 16-02-2018 for RI Recovery tab should be in enabled status and show details before and after of Claim Settlement.
			 * Now the TAB is getting disabled on Approval.That is the issue,as per thiag &siva sir sugg.*/ 
			
			PILT007_PT_IL_CLAIM_PAID_1_ACTION.PILT011compositeAction=new PILT011_COMPOSITE_ACTION();
			
			/*End*/
			
			PILT007_PT_IL_CLAIM_ACTION.compositeAction = this;
			PILT007_PT_IL_CLAIM_PAID_ACTION.compositeAction = this;
			PILT007_PT_IL_CLAIM_PAID_1_ACTION.compositeAction = this;
			PILT007_PT_IL_CLAIM_BENEFICIARY_ACTION.compositeAction = this;
			PILT007_DUMMY_ACTION.compositeAction = this;
			
			/*	added by gopi for Death Claim Settlement Letter on 11/04/17*/
			PILT007_PRINT_ACTION_BEAN.compositeAction=this;
			//end
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getReturnString() {
		return returnString;
	}

	public void setReturnString(String returnString) {
		this.returnString = returnString;
	}

	public DUMMY_ACTION getPILT007_DUMMY_ACTION() {
		return PILT007_DUMMY_ACTION;
	}

	public void setPILT007_DUMMY_ACTION(DUMMY_ACTION pilt007_dummy_action) {
		PILT007_DUMMY_ACTION = pilt007_dummy_action;
	}

	public PT_IL_CLAIM_ACTION getPILT007_PT_IL_CLAIM_ACTION() {
		return PILT007_PT_IL_CLAIM_ACTION;
	}

	public void setPILT007_PT_IL_CLAIM_ACTION(
			PT_IL_CLAIM_ACTION pilt007_pt_il_claim_action) {
		PILT007_PT_IL_CLAIM_ACTION = pilt007_pt_il_claim_action;
	}

	public PT_IL_CLAIM_BENEFICIARY_ACTION getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION() {
		return PILT007_PT_IL_CLAIM_BENEFICIARY_ACTION;
	}

	public void setPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION(
			PT_IL_CLAIM_BENEFICIARY_ACTION pilt007_pt_il_claim_beneficiary_action) {
		PILT007_PT_IL_CLAIM_BENEFICIARY_ACTION = pilt007_pt_il_claim_beneficiary_action;
	}

	public PT_IL_CLAIM_PAID_ACTION getPILT007_PT_IL_CLAIM_PAID_ACTION() {
		return PILT007_PT_IL_CLAIM_PAID_ACTION;
	}

	public void setPILT007_PT_IL_CLAIM_PAID_ACTION(
			PT_IL_CLAIM_PAID_ACTION pilt007_pt_il_claim_paid_action) {
		PILT007_PT_IL_CLAIM_PAID_ACTION = pilt007_pt_il_claim_paid_action;
	}

	public PT_IL_CLAIM_PAID_1_ACTION getPILT007_PT_IL_CLAIM_PAID_1_ACTION() {
		return PILT007_PT_IL_CLAIM_PAID_1_ACTION;
	}

	public void setPILT007_PT_IL_CLAIM_PAID_1_ACTION(
			PT_IL_CLAIM_PAID_1_ACTION pilt007_pt_il_claim_paid_1_action) {
		PILT007_PT_IL_CLAIM_PAID_1_ACTION = pilt007_pt_il_claim_paid_1_action;
	}

	public String claimsSettlement() {
		return claimPaidAction();

	}

	public String claimPaid1Action() {
		String outcome = null;
		getPILT007_PT_IL_CLAIM_PAID_1_ACTION().setBlockFlag(true);
		CommonUtils.getGlobalVariable("CALLING_FORM_OUTCOME");
		if (outcome == null) {
			outcome = "claimPaid";
		} else {
			CommonUtils.setGlobalVariable("CALLING_FORM_OUTCOME", null);
			CommonUtils.setGlobalVariable("CALLING_FORM", null);
		}

		return outcome;
	}

	public String claimPaidAction() {
		PILT007_PT_IL_CLAIM_PAID_ACTION.setBlockFlag(true);
		return "claimToBePaid";
	}

	public String claimAction() {
		/*Added by saritha on 26-May-2017 for Settlement screen wizard link claim details screen not displayed.*/
		/*return "claimInsert";*/
		return "GO_TO_PT_IL_CLAIM";
		/*End*/
	}

	public String beneficiaryDetails() {
		//getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().validateBeneficiaryPerc();
		getPILT007_PT_IL_CLAIM_PAID_ACTION().setBlockFlag(false);
		getPILT007_PT_IL_CLAIM_PAID_1_ACTION().setBlockFlag(false);
		getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().setBlockFlag(true);
		try {
			CommonUtils.getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		CommonUtils.clearMaps(getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION());
		return returnString;
	}

	public String claimsSearch() {
		getPILT007_PT_IL_CLAIM_ACTION().setPT_IL_CLAIM_BEAN(new PT_IL_CLAIM());
		getPILT007_PT_IL_CLAIM_PAID_ACTION().setPT_IL_CLAIM_PAID_BEAN(
				new PT_IL_CLAIM_PAID());
		getPILT007_PT_IL_CLAIM_PAID_ACTION()
				.setPT_IL_CLAIM_PAID_BEAN_LIST(null);
		getPILT007_PT_IL_CLAIM_PAID_1_ACTION().setPT_IL_CLAIM_PAID_1_BEAN(
				new PT_IL_CLAIM_PAID_1());
		getPILT007_PT_IL_CLAIM_PAID_1_ACTION().setPT_IL_CLAIM_PAID_1_BEAN_LIST(
				null);
		return "claimSearch";
	}

	public String facDetails() {
		try {
			getPT_IL_CLAIM_PAIDSelectedAction();
			CommonUtils.setGlobalObject("GLOBAL.M_CP_SYS_ID",
					PILT007_PT_IL_CLAIM_PAID_ACTION.getPT_IL_CLAIM_PAID_BEAN()
							.getCP_SYS_ID());
			CommonUtils.setGlobalObject("GLOBAL.POL_SYS_ID",
					PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN()
							.getCLAIM_POL_SYS_ID());
			CommonUtils.setGlobalObject("GLOBAL.CLM_SYS_ID",
					PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN()
							.getCLAIM_SYS_ID());
			//CommonUtils.setGlobalVariable("GLOBAL.COVER_CODE",PILT007_PT_IL_CLAIM_PAID_ACTION.);
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT007");

		} catch (Exception e) {
			e.printStackTrace();
			PILT007_PT_IL_CLAIM_ACTION.getErrorMap().put("current",
					e.getMessage());
			PILT007_PT_IL_CLAIM_ACTION.setErrorMessages(e.getMessage());
			return null;
		}
		return "PILT011";
	}

	public String facDetails1() {
		try {
			getPT_IL_CLAIM_PAID1SelectedAction();
			Long CP_SYS_ID = PILT007_PT_IL_CLAIM_PAID_1_ACTION
					.getPT_IL_CLAIM_PAID_1_BEAN().getCP_SYS_ID();
			Long CLAIM_POL_SYS_ID = PILT007_PT_IL_CLAIM_ACTION
					.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
			Long CLAIM_SYS_ID = PILT007_PT_IL_CLAIM_ACTION
					.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
			
			String cpcoverCOde = PILT007_PT_IL_CLAIM_PAID_1_ACTION
			.getPT_IL_CLAIM_PAID_1_BEAN().getUI_M_CCD_COVER_CODE_1();

			CommonUtils.setGlobalObject("GLOBAL.M_CP_SYS_ID", CP_SYS_ID);
			CommonUtils.setGlobalObject("GLOBAL.POL_SYS_ID", CLAIM_POL_SYS_ID);
			CommonUtils.setGlobalObject("GLOBAL.CLM_SYS_ID", CLAIM_SYS_ID);
			CommonUtils.setGlobalVariable("GLOBAL.CLM_COVER_CODE", cpcoverCOde);
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT007");
			CommonUtils.setGlobalVariable("PILT011_CALLING_FORM", "PILT007");
		} catch (Exception e) {
			PILT007_PT_IL_CLAIM_PAID_ACTION.getErrorMap().put("current",
					e.getMessage());
			PILT007_PT_IL_CLAIM_PAID_ACTION.setErrorMessages(e.getMessage());
			return null;
		}
		return "PILT011";
	}

	public void getPT_IL_CLAIM_PAIDSelectedAction() throws Exception {
		List<PT_IL_CLAIM_PAID> claimPaidList = PILT007_PT_IL_CLAIM_PAID_ACTION
				.getPT_IL_CLAIM_PAID_BEAN_LIST();
		int rowCount = 0;
		int rowSelected = 0;
		for (int i = 0; i < claimPaidList.size(); i++) {
			PT_IL_CLAIM_PAID claimPaidBean = claimPaidList.get(i);

			if ("dataTableSelectedRow".equalsIgnoreCase(claimPaidBean
					.getRowSelected())) {

				rowCount++;
				rowSelected = i;
			}
		}
		if (rowCount > 1) {
			throw new ValidatorException(new FacesMessage(
					"Only one row can be selected"));
		} else if (rowCount < 1) {
			throw new ValidatorException(new FacesMessage(
					"Alteast one row should be selected"));
		} else {
			PT_IL_CLAIM_PAID claimPaidBean = claimPaidList.get(rowSelected);
			PILT007_PT_IL_CLAIM_PAID_ACTION
					.setPT_IL_CLAIM_PAID_BEAN(claimPaidBean);
		}
	}

	public void getPT_IL_CLAIM_PAID1SelectedAction() throws Exception {
		List<PT_IL_CLAIM_PAID_1> claimPaidList = PILT007_PT_IL_CLAIM_PAID_1_ACTION
				.getPT_IL_CLAIM_PAID_1_BEAN_LIST();
		int rowCount = 0;
		int rowSelected = 0;
		for (int i = 0; i < claimPaidList.size(); i++) {
			PT_IL_CLAIM_PAID_1 claimPaidBean = claimPaidList.get(i);

			if ("dataTableSelectedRow".equalsIgnoreCase(claimPaidBean
					.getRowSelected())) {
				rowCount++;
				rowSelected = i;
			}
		}
		if (rowCount > 1) {
			throw new ValidatorException(new FacesMessage(
					"Only one row can be selected"));
		} else if (rowCount < 1) {
			throw new ValidatorException(new FacesMessage(
					"Alteast one row should be selected"));
		} else {
			PT_IL_CLAIM_PAID_1 claimPaidBean = claimPaidList.get(rowSelected);
			PILT007_PT_IL_CLAIM_PAID_1_ACTION
					.setPT_IL_CLAIM_PAID_1_BEAN(claimPaidBean);
		}
	}

	public String RIClose() {
		String CLAIM_POL_NO = PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_NO();
		String CLAIM_NO = PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN()
				.getCLAIM_NO();
		CommonUtils.setGlobalVariable("GLOBAL.POLICY_NO", CLAIM_POL_NO);
		CommonUtils.setGlobalVariable("GLOBAL.CLM_NO", CLAIM_NO);
		CommonUtils.setGlobalObject("GLOBAL.CLAIM_SYS_ID",
				getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN()
						.getCLAIM_SYS_ID());
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT007");
		CommonUtils.setGlobalObject("PILT007_COMPOSITE_ACTION", this);
		return "PILP006";
	}

	public String paymentVoucher() {
		String CLAIM_NO = PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN()
				.getCLAIM_NO();
		String CLAIM_POL_NO = PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_NO();

		CommonUtils.setGlobalVariable("GLOBAL.M_CLAIM_NO", CLAIM_NO);
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", CLAIM_POL_NO);
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT007");
		CommonUtils.setGlobalVariable("DUMMY.CALLING_FORM_PILT007", "PILT007");
		CommonUtils.setGlobalVariable("DUMMY.M_PAH_TYPE", "CL");
		return "PILT007_PAYMENT_VOUCHER";
	}

	public String goBack() {
		DUMMY_HELPER helper = new DUMMY_HELPER();
		return "claimSearch";
	}

	public String navigationEnabled() {
		getWizard().setImmediate("true");
		return "";

	}
	/*	added by gopi for Death Claim Settlement Letter on 11/04/17*/
	private PILT007_PRINT_ACTION PILT007_PRINT_ACTION_BEAN;
	
	public PILT007_PRINT_ACTION getPILT007_PRINT_ACTION_BEAN() {
		return PILT007_PRINT_ACTION_BEAN;
	}

	public void setPILT007_PRINT_ACTION_BEAN(
			PILT007_PRINT_ACTION pILT007_PRINT_ACTION_BEAN) {
		PILT007_PRINT_ACTION_BEAN = pILT007_PRINT_ACTION_BEAN;
	}

	/*	end*/
	
	/*Commentted &Modified by saritha on 16-02-2018 for RI Recovery tab should be in enabled status and show details before and after of Claim Settlement.
	 * Now the TAB is getting disabled on Approval.That is the issue,as per thiag &siva sir sugg.*/
	
	public String RIDetails() {

		Long CLAIM_POL_SYS_ID = PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		Long CLAIM_SYS_ID     = PILT007_PT_IL_CLAIM_ACTION.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		String CCD_COVER_CODE = PILT007_PT_IL_CLAIM_PAID_1_ACTION.getPT_IL_CLAIM_PAID_1_BEAN().getUI_M_CCD_COVER_CODE_1();

		CommonUtils.setGlobalObject("GLOBAL.POL_SYS_ID", CLAIM_POL_SYS_ID);
		CommonUtils.setGlobalObject("GLOBAL.CLM_SYS_ID", CLAIM_SYS_ID);
		CommonUtils.setGlobalVariable("GLOBAL.COVER_CODE",CCD_COVER_CODE);
		CommonUtils.setGlobalVariable("GLOBAL.FAC_RI_BUT", "R");
		PILT007_PT_IL_CLAIM_PAID_1_ACTION.PILT011compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().setBlockFlag(true);
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT007");

		return "Claim_RIdetail";
	}
	
	/*End*/

}
