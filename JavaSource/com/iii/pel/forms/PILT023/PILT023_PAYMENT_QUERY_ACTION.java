package com.iii.pel.forms.PILT023;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;

public class PILT023_PAYMENT_QUERY_ACTION extends CommonAction {
	
	public PILT023_COMPOSITE_ACTION compositeAction;
	
	private PV_IL_MEDEX_DOC_DTL PV_IL_MEDEX_DOC_DTL_BEAN;
	
	private HtmlOutputLabel COMP_MFD_ACNT_TXN_CODE_LABEL;
	
	private HtmlInputText  COMP_MFD_ACNT_TXN_CODE;
	
	private HtmlOutputLabel COMP_MFD_ACNT_DOC_NO_LABEL;
	
	private HtmlInputText COMP_MFD_ACNT_DOC_NO;
	
	private HtmlOutputLabel COMP_MFD_ACNT_DOC_DT_LABEL;
	
	private HtmlCalendar COMP_MFD_ACNT_DOC_DT;
	
	private HtmlOutputLabel COMP_M_MFD_LC_CR_VALUE_LABEL;
	
	private HtmlInputText COMP_M_MFD_LC_CR_VALUE;
	
	private HtmlOutputLabel COMP_M_MFD_LC_PAID_VALUE_LABEL;
	
	private HtmlInputText COMP_M_MFD_LC_PAID_VALUE;
	
	
	public PV_IL_MEDEX_DOC_DTL getPV_IL_MEDEX_DOC_DTL_BEAN() {
		return PV_IL_MEDEX_DOC_DTL_BEAN;
	}

	public void setPV_IL_MEDEX_DOC_DTL_BEAN(
			PV_IL_MEDEX_DOC_DTL pV_IL_MEDEX_DOC_DTL_BEAN) {
		PV_IL_MEDEX_DOC_DTL_BEAN = pV_IL_MEDEX_DOC_DTL_BEAN;
	}

	public HtmlOutputLabel getCOMP_MFD_ACNT_TXN_CODE_LABEL() {
		return COMP_MFD_ACNT_TXN_CODE_LABEL;
	}

	public void setCOMP_MFD_ACNT_TXN_CODE_LABEL(
			HtmlOutputLabel cOMP_MFD_ACNT_TXN_CODE_LABEL) {
		COMP_MFD_ACNT_TXN_CODE_LABEL = cOMP_MFD_ACNT_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MFD_ACNT_TXN_CODE() {
		return COMP_MFD_ACNT_TXN_CODE;
	}

	public void setCOMP_MFD_ACNT_TXN_CODE(HtmlInputText cOMP_MFD_ACNT_TXN_CODE) {
		COMP_MFD_ACNT_TXN_CODE = cOMP_MFD_ACNT_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_MFD_ACNT_DOC_NO_LABEL() {
		return COMP_MFD_ACNT_DOC_NO_LABEL;
	}

	public void setCOMP_MFD_ACNT_DOC_NO_LABEL(
			HtmlOutputLabel cOMP_MFD_ACNT_DOC_NO_LABEL) {
		COMP_MFD_ACNT_DOC_NO_LABEL = cOMP_MFD_ACNT_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_MFD_ACNT_DOC_NO() {
		return COMP_MFD_ACNT_DOC_NO;
	}

	public void setCOMP_MFD_ACNT_DOC_NO(HtmlInputText cOMP_MFD_ACNT_DOC_NO) {
		COMP_MFD_ACNT_DOC_NO = cOMP_MFD_ACNT_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_MFD_ACNT_DOC_DT_LABEL() {
		return COMP_MFD_ACNT_DOC_DT_LABEL;
	}

	public void setCOMP_MFD_ACNT_DOC_DT_LABEL(
			HtmlOutputLabel cOMP_MFD_ACNT_DOC_DT_LABEL) {
		COMP_MFD_ACNT_DOC_DT_LABEL = cOMP_MFD_ACNT_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_MFD_ACNT_DOC_DT() {
		return COMP_MFD_ACNT_DOC_DT;
	}

	public void setCOMP_MFD_ACNT_DOC_DT(HtmlCalendar cOMP_MFD_ACNT_DOC_DT) {
		COMP_MFD_ACNT_DOC_DT = cOMP_MFD_ACNT_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_M_MFD_LC_CR_VALUE_LABEL() {
		return COMP_M_MFD_LC_CR_VALUE_LABEL;
	}

	public void setCOMP_M_MFD_LC_CR_VALUE_LABEL(
			HtmlOutputLabel cOMP_M_MFD_LC_CR_VALUE_LABEL) {
		COMP_M_MFD_LC_CR_VALUE_LABEL = cOMP_M_MFD_LC_CR_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_M_MFD_LC_CR_VALUE() {
		return COMP_M_MFD_LC_CR_VALUE;
	}

	public void setCOMP_M_MFD_LC_CR_VALUE(HtmlInputText cOMP_M_MFD_LC_CR_VALUE) {
		COMP_M_MFD_LC_CR_VALUE = cOMP_M_MFD_LC_CR_VALUE;
	}

	public HtmlOutputLabel getCOMP_M_MFD_LC_PAID_VALUE_LABEL() {
		return COMP_M_MFD_LC_PAID_VALUE_LABEL;
	}

	public void setCOMP_M_MFD_LC_PAID_VALUE_LABEL(
			HtmlOutputLabel cOMP_M_MFD_LC_PAID_VALUE_LABEL) {
		COMP_M_MFD_LC_PAID_VALUE_LABEL = cOMP_M_MFD_LC_PAID_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_M_MFD_LC_PAID_VALUE() {
		return COMP_M_MFD_LC_PAID_VALUE;
	}

	public void setCOMP_M_MFD_LC_PAID_VALUE(HtmlInputText cOMP_M_MFD_LC_PAID_VALUE) {
		COMP_M_MFD_LC_PAID_VALUE = cOMP_M_MFD_LC_PAID_VALUE;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public PILT023_PAYMENT_QUERY_ACTION() {
		// TODO Auto-generated constructor stub
		PV_IL_MEDEX_DOC_DTL_BEAN = new PV_IL_MEDEX_DOC_DTL();
	}
	
	public String mainWind(){
		
		return "medPayments";
	}
	
	public void onload(PhaseEvent event){
		System.out.println("PILT023_PAYMENT_QUERY_ACTION onload");
		try {
			System.out.println("PILT023 onload");
			System.out.println("isBlockFlag() ------------------->>>>"+isBlockFlag());
			if (isBlockFlag()) {
				System.out.println("isBlockFlag() =====================>> ==========>>"+isBlockFlag());
				System.out.println("query ONLOAD CALLED");
				new PILT023_MEDICAL_CLINIC_PAYMENTS_HELPER().executePaymentQuery(compositeAction);
				setBlockFlag(false);
			}
			System.out.println("isBlockFlag() =====================>> ==========>>22 ::::"+isBlockFlag());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

}
