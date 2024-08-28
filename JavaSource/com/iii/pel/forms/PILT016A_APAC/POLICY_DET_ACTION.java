package com.iii.pel.forms.PILT016A_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class POLICY_DET_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_MODE_OF_PYMT_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_MODE_OF_PYMT;

	private HtmlOutputLabel COMP_UI_M_PAY_DUE_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PAY_DUE_DT;

	private HtmlOutputLabel COMP_UI_M_AGENT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_NAME;

	private HtmlOutputLabel COMP_UI_M_MODAL_PREM_LABEL;

	private HtmlInputText COMP_UI_M_MODAL_PREM;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_POLICY_DET;

	private POLICY_DET POLICY_DET_BEAN;
	
	private List<SelectItem> modeOfPaymentList = new ArrayList<SelectItem>();

	public POLICY_DET_ACTION() {
		POLICY_DET_BEAN = new POLICY_DET();
		try {
			setModeOfPaymentList(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT016A_APAC", "POLICY_DET", "POLICY_DET.M_MODE_OF_PYMT","PAYMODE"));
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_MODE_OF_PYMT_LABEL() {
		return COMP_UI_M_MODE_OF_PYMT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_MODE_OF_PYMT() {
		return COMP_UI_M_MODE_OF_PYMT;
	}

	public void setCOMP_UI_M_MODE_OF_PYMT_LABEL(HtmlOutputLabel COMP_UI_M_MODE_OF_PYMT_LABEL) {
		this.COMP_UI_M_MODE_OF_PYMT_LABEL = COMP_UI_M_MODE_OF_PYMT_LABEL;
	}

	public void setCOMP_UI_M_MODE_OF_PYMT(HtmlSelectOneMenu COMP_UI_M_MODE_OF_PYMT) {
		this.COMP_UI_M_MODE_OF_PYMT = COMP_UI_M_MODE_OF_PYMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAY_DUE_DT_LABEL() {
		return COMP_UI_M_PAY_DUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PAY_DUE_DT() {
		return COMP_UI_M_PAY_DUE_DT;
	}

	public void setCOMP_UI_M_PAY_DUE_DT_LABEL(HtmlOutputLabel COMP_UI_M_PAY_DUE_DT_LABEL) {
		this.COMP_UI_M_PAY_DUE_DT_LABEL = COMP_UI_M_PAY_DUE_DT_LABEL;
	}

	public void setCOMP_UI_M_PAY_DUE_DT(HtmlCalendar COMP_UI_M_PAY_DUE_DT) {
		this.COMP_UI_M_PAY_DUE_DT = COMP_UI_M_PAY_DUE_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_CODE_LABEL() {
		return COMP_UI_M_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_CODE() {
		return COMP_UI_M_AGENT_CODE;
	}

	public void setCOMP_UI_M_AGENT_CODE_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_CODE_LABEL) {
		this.COMP_UI_M_AGENT_CODE_LABEL = COMP_UI_M_AGENT_CODE_LABEL;
	}

	public void setCOMP_UI_M_AGENT_CODE(HtmlInputText COMP_UI_M_AGENT_CODE) {
		this.COMP_UI_M_AGENT_CODE = COMP_UI_M_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_NAME_LABEL() {
		return COMP_UI_M_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_NAME() {
		return COMP_UI_M_AGENT_NAME;
	}

	public void setCOMP_UI_M_AGENT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_NAME_LABEL) {
		this.COMP_UI_M_AGENT_NAME_LABEL = COMP_UI_M_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_AGENT_NAME(HtmlInputText COMP_UI_M_AGENT_NAME) {
		this.COMP_UI_M_AGENT_NAME = COMP_UI_M_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_MODAL_PREM_LABEL() {
		return COMP_UI_M_MODAL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MODAL_PREM() {
		return COMP_UI_M_MODAL_PREM;
	}

	public void setCOMP_UI_M_MODAL_PREM_LABEL(HtmlOutputLabel COMP_UI_M_MODAL_PREM_LABEL) {
		this.COMP_UI_M_MODAL_PREM_LABEL = COMP_UI_M_MODAL_PREM_LABEL;
	}

	public void setCOMP_UI_M_MODAL_PREM(HtmlInputText COMP_UI_M_MODAL_PREM) {
		this.COMP_UI_M_MODAL_PREM = COMP_UI_M_MODAL_PREM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_POLICY_DET() {
		return COMP_UI_M_BUT_MAIN_POLICY_DET;
	}

	public void setCOMP_UI_M_BUT_MAIN_POLICY_DET(HtmlCommandButton COMP_UI_M_BUT_MAIN_POLICY_DET) {
		this.COMP_UI_M_BUT_MAIN_POLICY_DET = COMP_UI_M_BUT_MAIN_POLICY_DET;
	}

	public POLICY_DET getPOLICY_DET_BEAN() {
		return POLICY_DET_BEAN;
	}

	public void setPOLICY_DET_BEAN(POLICY_DET POLICY_DET_BEAN) {
		this.POLICY_DET_BEAN = POLICY_DET_BEAN;
	}

	/**
	 * @return the modeOfPaymentList
	 */
	public List<SelectItem> getModeOfPaymentList() {
		return modeOfPaymentList;
	}

	/**
	 * @param modeOfPaymentList the modeOfPaymentList to set
	 */
	public void setModeOfPaymentList(List<SelectItem> modeOfPaymentList) {
		this.modeOfPaymentList = modeOfPaymentList;
	}
}
