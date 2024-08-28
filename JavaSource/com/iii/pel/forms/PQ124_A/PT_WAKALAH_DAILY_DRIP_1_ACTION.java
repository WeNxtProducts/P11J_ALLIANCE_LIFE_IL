package com.iii.pel.forms.PQ124_A;

import java.sql.SQLException;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_WAKALAH_DAILY_DRIP_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PA_PROFIT_LABEL;

	private HtmlInputText COMP_UI_M_PA_PROFIT;

	private HtmlOutputLabel COMP_UI_M_ACC_PSA_PROFIT_LABEL;

	private HtmlInputText COMP_UI_M_ACC_PSA_PROFIT;

	private HtmlOutputLabel COMP_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_CODE;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_END_NO_LABEL;

	private HtmlInputText COMP_POL_END_NO;

	private HtmlOutputLabel COMP_UI_M_GFTA_SURP_LABEL;

	private HtmlInputText COMP_UI_M_GFTA_SURP;

	private HtmlOutputLabel COMP_UI_M_WAK_DA_MODULE_LABEL;

	private HtmlInputText COMP_UI_M_WAK_DA_MODULE;

	private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_POL_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_GFTA_SURP_TR_LABEL;

	private HtmlInputText COMP_UI_M_GFTA_SURP_TR;

	private HtmlOutputLabel COMP_POL_DIVN_CODE_LABEL;

	private HtmlInputText COMP_POL_DIVN_CODE;

	private HtmlOutputLabel COMP_POL_DEPT_CODE_LABEL;

	private HtmlInputText COMP_POL_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_PA_BAL_LABEL;

	private HtmlInputText COMP_UI_M_PA_BAL;

	private HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL;

	private HtmlInputText COMP_POL_CLASS_CODE;

	private HtmlOutputLabel COMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WAK_DA_POL_PDS_CODE;

	private HtmlOutputLabel COMP_UI_M_CONT_LC_BALANCE_LABEL;

	private HtmlInputText COMP_UI_M_CONT_LC_BALANCE;

	private HtmlOutputLabel COMP_POL_SRC_OF_BUS_LABEL;

	private HtmlInputText COMP_POL_SRC_OF_BUS;

	private HtmlOutputLabel COMP_UI_M_PSA_YR_LABEL;

	private HtmlInputText COMP_UI_M_PSA_YR;

	private HtmlOutputLabel COMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL;

	private HtmlInputText COMP_UI_M_WAK_DA_POL_ANALYSIS_1;

	private PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN;

	private HtmlCommandButton UI_BUT_QUERY;

	public PQ124_A_COMPOSITE_ACTION compositeAction;

	private PT_WAKALAH_DAILY_DRIP_1_HELPER helper;
	
	
	public PT_WAKALAH_DAILY_DRIP_1_ACTION() {
		PT_WAKALAH_DAILY_DRIP_1_BEAN = new PT_WAKALAH_DAILY_DRIP_1();
		helper = new PT_WAKALAH_DAILY_DRIP_1_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_PA_PROFIT_LABEL() {
		return COMP_UI_M_PA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PA_PROFIT() {
		return COMP_UI_M_PA_PROFIT;
	}

	public void setCOMP_UI_M_PA_PROFIT_LABEL(
			HtmlOutputLabel COMP_UI_M_PA_PROFIT_LABEL) {
		this.COMP_UI_M_PA_PROFIT_LABEL = COMP_UI_M_PA_PROFIT_LABEL;
	}

	public void setCOMP_UI_M_PA_PROFIT(HtmlInputText COMP_UI_M_PA_PROFIT) {
		this.COMP_UI_M_PA_PROFIT = COMP_UI_M_PA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACC_PSA_PROFIT_LABEL() {
		return COMP_UI_M_ACC_PSA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACC_PSA_PROFIT() {
		return COMP_UI_M_ACC_PSA_PROFIT;
	}

	public void setCOMP_UI_M_ACC_PSA_PROFIT_LABEL(
			HtmlOutputLabel COMP_UI_M_ACC_PSA_PROFIT_LABEL) {
		this.COMP_UI_M_ACC_PSA_PROFIT_LABEL = COMP_UI_M_ACC_PSA_PROFIT_LABEL;
	}

	public void setCOMP_UI_M_ACC_PSA_PROFIT(
			HtmlInputText COMP_UI_M_ACC_PSA_PROFIT) {
		this.COMP_UI_M_ACC_PSA_PROFIT = COMP_UI_M_ACC_PSA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CODE_LABEL() {
		return COMP_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CODE() {
		return COMP_POL_CUST_CODE;
	}

	public void setCOMP_POL_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
		this.COMP_POL_CUST_CODE_LABEL = COMP_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_POL_CUST_CODE(HtmlInputText COMP_POL_CUST_CODE) {
		this.COMP_POL_CUST_CODE = COMP_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_END_NO_LABEL() {
		return COMP_POL_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_END_NO() {
		return COMP_POL_END_NO;
	}

	public void setCOMP_POL_END_NO_LABEL(HtmlOutputLabel COMP_POL_END_NO_LABEL) {
		this.COMP_POL_END_NO_LABEL = COMP_POL_END_NO_LABEL;
	}

	public void setCOMP_POL_END_NO(HtmlInputText COMP_POL_END_NO) {
		this.COMP_POL_END_NO = COMP_POL_END_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_GFTA_SURP_LABEL() {
		return COMP_UI_M_GFTA_SURP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_GFTA_SURP() {
		return COMP_UI_M_GFTA_SURP;
	}

	public void setCOMP_UI_M_GFTA_SURP_LABEL(
			HtmlOutputLabel COMP_UI_M_GFTA_SURP_LABEL) {
		this.COMP_UI_M_GFTA_SURP_LABEL = COMP_UI_M_GFTA_SURP_LABEL;
	}

	public void setCOMP_UI_M_GFTA_SURP(HtmlInputText COMP_UI_M_GFTA_SURP) {
		this.COMP_UI_M_GFTA_SURP = COMP_UI_M_GFTA_SURP;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAK_DA_MODULE_LABEL() {
		return COMP_UI_M_WAK_DA_MODULE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAK_DA_MODULE() {
		return COMP_UI_M_WAK_DA_MODULE;
	}

	public void setCOMP_UI_M_WAK_DA_MODULE_LABEL(
			HtmlOutputLabel COMP_UI_M_WAK_DA_MODULE_LABEL) {
		this.COMP_UI_M_WAK_DA_MODULE_LABEL = COMP_UI_M_WAK_DA_MODULE_LABEL;
	}

	public void setCOMP_UI_M_WAK_DA_MODULE(HtmlInputText COMP_UI_M_WAK_DA_MODULE) {
		this.COMP_UI_M_WAK_DA_MODULE = COMP_UI_M_WAK_DA_MODULE;
	}

	public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
		return COMP_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROD_CODE() {
		return COMP_POL_PROD_CODE;
	}

	public void setCOMP_POL_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
		this.COMP_POL_PROD_CODE_LABEL = COMP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_POL_PROD_CODE(HtmlInputText COMP_POL_PROD_CODE) {
		this.COMP_POL_PROD_CODE = COMP_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_GFTA_SURP_TR_LABEL() {
		return COMP_UI_M_GFTA_SURP_TR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_GFTA_SURP_TR() {
		return COMP_UI_M_GFTA_SURP_TR;
	}

	public void setCOMP_UI_M_GFTA_SURP_TR_LABEL(
			HtmlOutputLabel COMP_UI_M_GFTA_SURP_TR_LABEL) {
		this.COMP_UI_M_GFTA_SURP_TR_LABEL = COMP_UI_M_GFTA_SURP_TR_LABEL;
	}

	public void setCOMP_UI_M_GFTA_SURP_TR(HtmlInputText COMP_UI_M_GFTA_SURP_TR) {
		this.COMP_UI_M_GFTA_SURP_TR = COMP_UI_M_GFTA_SURP_TR;
	}

	public HtmlOutputLabel getCOMP_POL_DIVN_CODE_LABEL() {
		return COMP_POL_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_DIVN_CODE() {
		return COMP_POL_DIVN_CODE;
	}

	public void setCOMP_POL_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_POL_DIVN_CODE_LABEL) {
		this.COMP_POL_DIVN_CODE_LABEL = COMP_POL_DIVN_CODE_LABEL;
	}

	public void setCOMP_POL_DIVN_CODE(HtmlInputText COMP_POL_DIVN_CODE) {
		this.COMP_POL_DIVN_CODE = COMP_POL_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_DEPT_CODE_LABEL() {
		return COMP_POL_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_DEPT_CODE() {
		return COMP_POL_DEPT_CODE;
	}

	public void setCOMP_POL_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_POL_DEPT_CODE_LABEL) {
		this.COMP_POL_DEPT_CODE_LABEL = COMP_POL_DEPT_CODE_LABEL;
	}

	public void setCOMP_POL_DEPT_CODE(HtmlInputText COMP_POL_DEPT_CODE) {
		this.COMP_POL_DEPT_CODE = COMP_POL_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PA_BAL_LABEL() {
		return COMP_UI_M_PA_BAL_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PA_BAL() {
		return COMP_UI_M_PA_BAL;
	}

	public void setCOMP_UI_M_PA_BAL_LABEL(HtmlOutputLabel COMP_UI_M_PA_BAL_LABEL) {
		this.COMP_UI_M_PA_BAL_LABEL = COMP_UI_M_PA_BAL_LABEL;
	}

	public void setCOMP_UI_M_PA_BAL(HtmlInputText COMP_UI_M_PA_BAL) {
		this.COMP_UI_M_PA_BAL = COMP_UI_M_PA_BAL;
	}

	public HtmlOutputLabel getCOMP_POL_CLASS_CODE_LABEL() {
		return COMP_POL_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CLASS_CODE() {
		return COMP_POL_CLASS_CODE;
	}

	public void setCOMP_POL_CLASS_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL) {
		this.COMP_POL_CLASS_CODE_LABEL = COMP_POL_CLASS_CODE_LABEL;
	}

	public void setCOMP_POL_CLASS_CODE(HtmlInputText COMP_POL_CLASS_CODE) {
		this.COMP_POL_CLASS_CODE = COMP_POL_CLASS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL() {
		return COMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAK_DA_POL_PDS_CODE() {
		return COMP_UI_M_WAK_DA_POL_PDS_CODE;
	}

	public void setCOMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL) {
		this.COMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL = COMP_UI_M_WAK_DA_POL_PDS_CODE_LABEL;
	}

	public void setCOMP_UI_M_WAK_DA_POL_PDS_CODE(
			HtmlInputText COMP_UI_M_WAK_DA_POL_PDS_CODE) {
		this.COMP_UI_M_WAK_DA_POL_PDS_CODE = COMP_UI_M_WAK_DA_POL_PDS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_LC_BALANCE_LABEL() {
		return COMP_UI_M_CONT_LC_BALANCE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_LC_BALANCE() {
		return COMP_UI_M_CONT_LC_BALANCE;
	}

	public void setCOMP_UI_M_CONT_LC_BALANCE_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_LC_BALANCE_LABEL) {
		this.COMP_UI_M_CONT_LC_BALANCE_LABEL = COMP_UI_M_CONT_LC_BALANCE_LABEL;
	}

	public void setCOMP_UI_M_CONT_LC_BALANCE(
			HtmlInputText COMP_UI_M_CONT_LC_BALANCE) {
		this.COMP_UI_M_CONT_LC_BALANCE = COMP_UI_M_CONT_LC_BALANCE;
	}

	public HtmlOutputLabel getCOMP_POL_SRC_OF_BUS_LABEL() {
		return COMP_POL_SRC_OF_BUS_LABEL;
	}

	public HtmlInputText getCOMP_POL_SRC_OF_BUS() {
		return COMP_POL_SRC_OF_BUS;
	}

	public void setCOMP_POL_SRC_OF_BUS_LABEL(
			HtmlOutputLabel COMP_POL_SRC_OF_BUS_LABEL) {
		this.COMP_POL_SRC_OF_BUS_LABEL = COMP_POL_SRC_OF_BUS_LABEL;
	}

	public void setCOMP_POL_SRC_OF_BUS(HtmlInputText COMP_POL_SRC_OF_BUS) {
		this.COMP_POL_SRC_OF_BUS = COMP_POL_SRC_OF_BUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_PSA_YR_LABEL() {
		return COMP_UI_M_PSA_YR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PSA_YR() {
		return COMP_UI_M_PSA_YR;
	}

	public void setCOMP_UI_M_PSA_YR_LABEL(HtmlOutputLabel COMP_UI_M_PSA_YR_LABEL) {
		this.COMP_UI_M_PSA_YR_LABEL = COMP_UI_M_PSA_YR_LABEL;
	}

	public void setCOMP_UI_M_PSA_YR(HtmlInputText COMP_UI_M_PSA_YR) {
		this.COMP_UI_M_PSA_YR = COMP_UI_M_PSA_YR;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL() {
		return COMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WAK_DA_POL_ANALYSIS_1() {
		return COMP_UI_M_WAK_DA_POL_ANALYSIS_1;
	}

	public void setCOMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL(
			HtmlOutputLabel COMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL) {
		this.COMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL = COMP_UI_M_WAK_DA_POL_ANALYSIS_1_LABEL;
	}

	public void setCOMP_UI_M_WAK_DA_POL_ANALYSIS_1(
			HtmlInputText COMP_UI_M_WAK_DA_POL_ANALYSIS_1) {
		this.COMP_UI_M_WAK_DA_POL_ANALYSIS_1 = COMP_UI_M_WAK_DA_POL_ANALYSIS_1;
	}

	public PT_WAKALAH_DAILY_DRIP_1 getPT_WAKALAH_DAILY_DRIP_1_BEAN() {
		return PT_WAKALAH_DAILY_DRIP_1_BEAN;
	}

	public void setPT_WAKALAH_DAILY_DRIP_1_BEAN(
			PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN) {
		this.PT_WAKALAH_DAILY_DRIP_1_BEAN = PT_WAKALAH_DAILY_DRIP_1_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_WAKALAH_DAILY_DRIP_1_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(
						getPT_WAKALAH_DAILY_DRIP_1_BEAN(), CommonUtils
						.getConnection());
			} else {
				new CRUDHandler().executeInsert(
						getPT_WAKALAH_DAILY_DRIP_1_BEAN(), CommonUtils
						.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.preForm(compositeAction);
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				if(PT_WAKALAH_DAILY_DRIP_1_BEAN.getROWID()!=null){
					helper.executeQuery(compositeAction);
					helper.postQuery(compositeAction);
					helper.onPopulateDetails(compositeAction);
					
					//add for to calculate sum value in datalist for every field. 
					compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().calculateSum();
				}
				setBlockFlag(false);
				resetAllComponent();
			}
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		}
	}

	/**
	 * @return the uI_BUT_QUERY
	 */
	public HtmlCommandButton getUI_BUT_QUERY() {
		return UI_BUT_QUERY;
	}

	/**
	 * @param ui_but_query the uI_BUT_QUERY to set
	 */
	public void setUI_BUT_QUERY(HtmlCommandButton ui_but_query) {
		UI_BUT_QUERY = ui_but_query;
	}

	/**
	 * @return the compositeAction
	 */
	public PQ124_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PQ124_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PT_WAKALAH_DAILY_DRIP_1_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PT_WAKALAH_DAILY_DRIP_1_HELPER helper) {
		this.helper = helper;
	}
	/**
	 * 
	 */
	public void queryData(){
		onLoad(null);
	}

	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_PA_PROFIT.resetValue();
		COMP_UI_M_ACC_PSA_PROFIT.resetValue();
		COMP_POL_CUST_CODE.resetValue();
		COMP_POL_NO.resetValue();
		COMP_POL_END_NO.resetValue();
		COMP_UI_M_GFTA_SURP.resetValue();
		COMP_UI_M_WAK_DA_MODULE.resetValue();
		COMP_POL_PROD_CODE.resetValue();
		COMP_UI_M_GFTA_SURP_TR.resetValue();
		COMP_POL_DIVN_CODE.resetValue();
		COMP_POL_DEPT_CODE.resetValue();
		COMP_UI_M_PA_BAL.resetValue();
		COMP_POL_CLASS_CODE.resetValue();
		COMP_UI_M_WAK_DA_POL_PDS_CODE.resetValue();
		COMP_UI_M_CONT_LC_BALANCE.resetValue();
		COMP_POL_SRC_OF_BUS.resetValue();
		COMP_UI_M_PSA_YR.resetValue();
		COMP_UI_M_WAK_DA_POL_ANALYSIS_1.resetValue();
	}


	/**
	 * Instantiates all components in PT_WAKALAH_DAILY_DRIP_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_PA_PROFIT				 = new HtmlInputText();
		COMP_UI_M_ACC_PSA_PROFIT			 = new HtmlInputText();
		COMP_POL_CUST_CODE				 = new HtmlInputText();
		COMP_POL_NO					 = new HtmlInputText();
		COMP_POL_END_NO					 = new HtmlInputText();
		COMP_UI_M_GFTA_SURP				 = new HtmlInputText();
		COMP_UI_M_WAK_DA_MODULE				 = new HtmlInputText();
		COMP_POL_PROD_CODE				 = new HtmlInputText();
		COMP_UI_M_GFTA_SURP_TR				 = new HtmlInputText();
		COMP_POL_DIVN_CODE				 = new HtmlInputText();
		COMP_POL_DEPT_CODE				 = new HtmlInputText();
		COMP_UI_M_PA_BAL				 = new HtmlInputText();
		COMP_POL_CLASS_CODE				 = new HtmlInputText();
		COMP_UI_M_WAK_DA_POL_PDS_CODE			 = new HtmlInputText();
		COMP_UI_M_CONT_LC_BALANCE			 = new HtmlInputText();
		COMP_POL_SRC_OF_BUS				 = new HtmlInputText();
		COMP_UI_M_PSA_YR				 = new HtmlInputText();
		COMP_UI_M_WAK_DA_POL_ANALYSIS_1			 = new HtmlInputText();

		// Instantiating HtmlCommandButton
		UI_BUT_QUERY					 = new HtmlCommandButton();

	}

	


}
