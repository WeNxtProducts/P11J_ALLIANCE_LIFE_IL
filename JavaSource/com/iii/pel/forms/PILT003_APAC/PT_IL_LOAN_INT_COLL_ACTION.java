package com.iii.pel.forms.PILT003_APAC;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_INT_COLL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_LOAN_FC_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_FC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_LOAN_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_LC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_FC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FC_REPAID_AMT;

	private HtmlOutputLabel COMP_UI_M_LC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LC_REPAID_AMT;

	private HtmlOutputLabel COMP_UI_M_FC_BAL_LOAN_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FC_BAL_LOAN_AMT;

	private HtmlOutputLabel COMP_UI_M_LC_BAL_LOAN_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LC_BAL_LOAN_AMT;

	private HtmlOutputLabel COMP_LIC_INT_RATE_LABEL;

	private HtmlInputText COMP_LIC_INT_RATE;

	private HtmlOutputLabel COMP_LIC_FC_INT_AMT_LABEL;

	private HtmlInputText COMP_LIC_FC_INT_AMT;

	private HtmlOutputLabel COMP_LIC_LC_INT_AMT_LABEL;

	private HtmlInputText COMP_LIC_LC_INT_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_LOAN_INT_COLL_HELPER helper;
	
	private List<PT_IL_LOAN_INT_COLL> dataList_PT_IL_LOAN_INT_COLL = new ArrayList<PT_IL_LOAN_INT_COLL>();



	public PT_IL_LOAN_INT_COLL_ACTION() {

		PT_IL_LOAN_INT_COLL_BEAN = new PT_IL_LOAN_INT_COLL();
		helper = new PT_IL_LOAN_INT_COLL_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_FC_AMOUNT_LABEL() {
		return COMP_UI_M_LOAN_FC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_FC_AMOUNT() {
		return COMP_UI_M_LOAN_FC_AMOUNT;
	}

	public void setCOMP_UI_M_LOAN_FC_AMOUNT_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_FC_AMOUNT_LABEL) {
		this.COMP_UI_M_LOAN_FC_AMOUNT_LABEL = COMP_UI_M_LOAN_FC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_FC_AMOUNT(HtmlInputText COMP_UI_M_LOAN_FC_AMOUNT) {
		this.COMP_UI_M_LOAN_FC_AMOUNT = COMP_UI_M_LOAN_FC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_LC_AMOUNT_LABEL() {
		return COMP_UI_M_LOAN_LC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_LC_AMOUNT() {
		return COMP_UI_M_LOAN_LC_AMOUNT;
	}

	public void setCOMP_UI_M_LOAN_LC_AMOUNT_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_LC_AMOUNT_LABEL) {
		this.COMP_UI_M_LOAN_LC_AMOUNT_LABEL = COMP_UI_M_LOAN_LC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_LC_AMOUNT(HtmlInputText COMP_UI_M_LOAN_LC_AMOUNT) {
		this.COMP_UI_M_LOAN_LC_AMOUNT = COMP_UI_M_LOAN_LC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_REPAID_AMT_LABEL() {
		return COMP_UI_M_FC_REPAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_REPAID_AMT() {
		return COMP_UI_M_FC_REPAID_AMT;
	}

	public void setCOMP_UI_M_FC_REPAID_AMT_LABEL(HtmlOutputLabel COMP_UI_M_FC_REPAID_AMT_LABEL) {
		this.COMP_UI_M_FC_REPAID_AMT_LABEL = COMP_UI_M_FC_REPAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_FC_REPAID_AMT(HtmlInputText COMP_UI_M_FC_REPAID_AMT) {
		this.COMP_UI_M_FC_REPAID_AMT = COMP_UI_M_FC_REPAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_REPAID_AMT_LABEL() {
		return COMP_UI_M_LC_REPAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_REPAID_AMT() {
		return COMP_UI_M_LC_REPAID_AMT;
	}

	public void setCOMP_UI_M_LC_REPAID_AMT_LABEL(HtmlOutputLabel COMP_UI_M_LC_REPAID_AMT_LABEL) {
		this.COMP_UI_M_LC_REPAID_AMT_LABEL = COMP_UI_M_LC_REPAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_LC_REPAID_AMT(HtmlInputText COMP_UI_M_LC_REPAID_AMT) {
		this.COMP_UI_M_LC_REPAID_AMT = COMP_UI_M_LC_REPAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_BAL_LOAN_AMT_LABEL() {
		return COMP_UI_M_FC_BAL_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_BAL_LOAN_AMT() {
		return COMP_UI_M_FC_BAL_LOAN_AMT;
	}

	public void setCOMP_UI_M_FC_BAL_LOAN_AMT_LABEL(HtmlOutputLabel COMP_UI_M_FC_BAL_LOAN_AMT_LABEL) {
		this.COMP_UI_M_FC_BAL_LOAN_AMT_LABEL = COMP_UI_M_FC_BAL_LOAN_AMT_LABEL;
	}

	public void setCOMP_UI_M_FC_BAL_LOAN_AMT(HtmlInputText COMP_UI_M_FC_BAL_LOAN_AMT) {
		this.COMP_UI_M_FC_BAL_LOAN_AMT = COMP_UI_M_FC_BAL_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_BAL_LOAN_AMT_LABEL() {
		return COMP_UI_M_LC_BAL_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_BAL_LOAN_AMT() {
		return COMP_UI_M_LC_BAL_LOAN_AMT;
	}

	public void setCOMP_UI_M_LC_BAL_LOAN_AMT_LABEL(HtmlOutputLabel COMP_UI_M_LC_BAL_LOAN_AMT_LABEL) {
		this.COMP_UI_M_LC_BAL_LOAN_AMT_LABEL = COMP_UI_M_LC_BAL_LOAN_AMT_LABEL;
	}

	public void setCOMP_UI_M_LC_BAL_LOAN_AMT(HtmlInputText COMP_UI_M_LC_BAL_LOAN_AMT) {
		this.COMP_UI_M_LC_BAL_LOAN_AMT = COMP_UI_M_LC_BAL_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LIC_INT_RATE_LABEL() {
		return COMP_LIC_INT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_LIC_INT_RATE() {
		return COMP_LIC_INT_RATE;
	}

	public void setCOMP_LIC_INT_RATE_LABEL(HtmlOutputLabel COMP_LIC_INT_RATE_LABEL) {
		this.COMP_LIC_INT_RATE_LABEL = COMP_LIC_INT_RATE_LABEL;
	}

	public void setCOMP_LIC_INT_RATE(HtmlInputText COMP_LIC_INT_RATE) {
		this.COMP_LIC_INT_RATE = COMP_LIC_INT_RATE;
	}

	public HtmlOutputLabel getCOMP_LIC_FC_INT_AMT_LABEL() {
		return COMP_LIC_FC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LIC_FC_INT_AMT() {
		return COMP_LIC_FC_INT_AMT;
	}

	public void setCOMP_LIC_FC_INT_AMT_LABEL(HtmlOutputLabel COMP_LIC_FC_INT_AMT_LABEL) {
		this.COMP_LIC_FC_INT_AMT_LABEL = COMP_LIC_FC_INT_AMT_LABEL;
	}

	public void setCOMP_LIC_FC_INT_AMT(HtmlInputText COMP_LIC_FC_INT_AMT) {
		this.COMP_LIC_FC_INT_AMT = COMP_LIC_FC_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_LIC_LC_INT_AMT_LABEL() {
		return COMP_LIC_LC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LIC_LC_INT_AMT() {
		return COMP_LIC_LC_INT_AMT;
	}

	public void setCOMP_LIC_LC_INT_AMT_LABEL(HtmlOutputLabel COMP_LIC_LC_INT_AMT_LABEL) {
		this.COMP_LIC_LC_INT_AMT_LABEL = COMP_LIC_LC_INT_AMT_LABEL;
	}

	public void setCOMP_LIC_LC_INT_AMT(HtmlInputText COMP_LIC_LC_INT_AMT) {
		this.COMP_LIC_LC_INT_AMT = COMP_LIC_LC_INT_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public PT_IL_LOAN_INT_COLL getPT_IL_LOAN_INT_COLL_BEAN() {
		return PT_IL_LOAN_INT_COLL_BEAN;
	}

	public void setPT_IL_LOAN_INT_COLL_BEAN(PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN) {
		this.PT_IL_LOAN_INT_COLL_BEAN = PT_IL_LOAN_INT_COLL_BEAN;
	}
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String mainAction(){
		return "PILT003_APAC_PT_IL_PREM_COLL";
	}
	public void onLoad(PhaseEvent event){
		 try {
				if (isBlockFlag()) {
					if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getROWID() != null){
						helper.executeQuery(compositeAction);
						helper.POST_QUERY(PT_IL_LOAN_INT_COLL_BEAN);
					}
					}
					setBlockFlag(false);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			} 
	 }


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List<PT_IL_LOAN_INT_COLL> getDataList_PT_IL_LOAN_INT_COLL() {
		return dataList_PT_IL_LOAN_INT_COLL;
	}

	public void setDataList_PT_IL_LOAN_INT_COLL(
			List<PT_IL_LOAN_INT_COLL> dataList_PT_IL_LOAN_INT_COLL) {
		this.dataList_PT_IL_LOAN_INT_COLL = dataList_PT_IL_LOAN_INT_COLL;
	}
}