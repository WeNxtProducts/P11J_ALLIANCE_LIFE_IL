package com.iii.pel.forms.PILQ003;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_SURR_MAT_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_SMV_DATE_LABEL;

	private HtmlCalendar COMP_SMV_DATE;

	private HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_FC_RED_SA;

	private HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_LC_RED_SA;

	private HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_FC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_LC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_FC_GROSS_VALUE;

	private HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_LC_GROSS_VALUE;

	private HtmlOutputLabel COMP_SMV_FC_UNPAID_PREM_LABEL;

	private HtmlInputText COMP_SMV_FC_UNPAID_PREM;

	private HtmlOutputLabel COMP_SMV_LC_UNPAID_PREM_LABEL;

	private HtmlInputText COMP_SMV_LC_UNPAID_PREM;

	private HtmlOutputLabel COMP_SMV_FC_BAL_LOAN_LABEL;

	private HtmlInputText COMP_SMV_FC_BAL_LOAN;

	private HtmlOutputLabel COMP_SMV_LC_BAL_LOAN_LABEL;

	private HtmlInputText COMP_SMV_LC_BAL_LOAN;

	private HtmlOutputLabel COMP_SMV_FC_LOAN_INT_LABEL;

	private HtmlInputText COMP_SMV_FC_LOAN_INT;

	private HtmlOutputLabel COMP_SMV_LC_LOAN_INT_LABEL;

	private HtmlInputText COMP_SMV_LC_LOAN_INT;

	private HtmlOutputLabel COMP_UI_M_FC_TOT_CHARGE_LABEL;

	private HtmlInputText COMP_UI_M_FC_TOT_CHARGE;

	private HtmlOutputLabel COMP_UI_M_LC_TOT_CHARGE_LABEL;

	private HtmlInputText COMP_UI_M_LC_TOT_CHARGE;

	private HtmlOutputLabel COMP_UI_M_FC_NET_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_FC_NET_VALUE;

	private HtmlOutputLabel COMP_UI_M_LC_NET_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_LC_NET_VALUE;

	private PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_SURR_MAT_VALUES_HELPER helper;

	private String DEFAULT_WHERE;

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	public PT_IL_SURR_MAT_VALUES_ACTION() {

		PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
		helper = new PT_IL_SURR_MAT_VALUES_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_SMV_LC_LOAN_INT_LABEL() {
		return COMP_SMV_LC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_LOAN_INT() {
		return COMP_SMV_LC_LOAN_INT;
	}

	public void setCOMP_SMV_LC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_LOAN_INT_LABEL) {
		this.COMP_SMV_LC_LOAN_INT_LABEL = COMP_SMV_LC_LOAN_INT_LABEL;
	}

	public void setCOMP_SMV_LC_LOAN_INT(HtmlInputText COMP_SMV_LC_LOAN_INT) {
		this.COMP_SMV_LC_LOAN_INT = COMP_SMV_LC_LOAN_INT;
	}

	public PT_IL_SURR_MAT_VALUES getPT_IL_SURR_MAT_VALUES_BEAN() {
		return PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_BEAN(
			PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN) {
		this.PT_IL_SURR_MAT_VALUES_BEAN = PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_SURR_MAT_VALUES_BEAN().getROWID() != null) {
				helper.preUpdate(getPT_IL_SURR_MAT_VALUES_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(
						getPT_IL_SURR_MAT_VALUES_BEAN(), CommonUtils
								.getConnection());
			} else {
				
				helper.preInsert(getPT_IL_SURR_MAT_VALUES_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),compositeAction
													.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				new CRUDHandler().executeInsert(
						getPT_IL_SURR_MAT_VALUES_BEAN(), CommonUtils
								.getConnection());
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.preQuery(compositeAction);
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				if (PT_IL_SURR_MAT_VALUES_BEAN.getROWID() != null) {
					helper.postQuery(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(),
							getPT_IL_SURR_MAT_VALUES_BEAN());
				}

				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_SMV_DATE_LABEL() {
		return COMP_SMV_DATE_LABEL;
	}

	public void setCOMP_SMV_DATE_LABEL(HtmlOutputLabel comp_smv_date_label) {
		COMP_SMV_DATE_LABEL = comp_smv_date_label;
	}

	public HtmlCalendar getCOMP_SMV_DATE() {
		return COMP_SMV_DATE;
	}

	public void setCOMP_SMV_DATE(HtmlCalendar comp_smv_date) {
		COMP_SMV_DATE = comp_smv_date;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_RED_SA_LABEL() {
		return COMP_SMV_FC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_FC_RED_SA_LABEL(
			HtmlOutputLabel comp_smv_fc_red_sa_label) {
		COMP_SMV_FC_RED_SA_LABEL = comp_smv_fc_red_sa_label;
	}

	public HtmlInputText getCOMP_SMV_FC_RED_SA() {
		return COMP_SMV_FC_RED_SA;
	}

	public void setCOMP_SMV_FC_RED_SA(HtmlInputText comp_smv_fc_red_sa) {
		COMP_SMV_FC_RED_SA = comp_smv_fc_red_sa;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_RED_SA_LABEL() {
		return COMP_SMV_LC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_LC_RED_SA_LABEL(
			HtmlOutputLabel comp_smv_lc_red_sa_label) {
		COMP_SMV_LC_RED_SA_LABEL = comp_smv_lc_red_sa_label;
	}

	public HtmlInputText getCOMP_SMV_LC_RED_SA() {
		return COMP_SMV_LC_RED_SA;
	}

	public void setCOMP_SMV_LC_RED_SA(HtmlInputText comp_smv_lc_red_sa) {
		COMP_SMV_LC_RED_SA = comp_smv_lc_red_sa;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_ACC_PROFIT_LABEL() {
		return COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT_LABEL(
			HtmlOutputLabel comp_smv_fc_acc_profit_label) {
		COMP_SMV_FC_ACC_PROFIT_LABEL = comp_smv_fc_acc_profit_label;
	}

	public HtmlInputText getCOMP_SMV_FC_ACC_PROFIT() {
		return COMP_SMV_FC_ACC_PROFIT;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT(HtmlInputText comp_smv_fc_acc_profit) {
		COMP_SMV_FC_ACC_PROFIT = comp_smv_fc_acc_profit;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_ACC_PROFIT_LABEL() {
		return COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT_LABEL(
			HtmlOutputLabel comp_smv_lc_acc_profit_label) {
		COMP_SMV_LC_ACC_PROFIT_LABEL = comp_smv_lc_acc_profit_label;
	}

	public HtmlInputText getCOMP_SMV_LC_ACC_PROFIT() {
		return COMP_SMV_LC_ACC_PROFIT;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT(HtmlInputText comp_smv_lc_acc_profit) {
		COMP_SMV_LC_ACC_PROFIT = comp_smv_lc_acc_profit;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_GROSS_VALUE_LABEL() {
		return COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE_LABEL(
			HtmlOutputLabel comp_smv_fc_gross_value_label) {
		COMP_SMV_FC_GROSS_VALUE_LABEL = comp_smv_fc_gross_value_label;
	}

	public HtmlInputText getCOMP_SMV_FC_GROSS_VALUE() {
		return COMP_SMV_FC_GROSS_VALUE;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE(HtmlInputText comp_smv_fc_gross_value) {
		COMP_SMV_FC_GROSS_VALUE = comp_smv_fc_gross_value;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_GROSS_VALUE_LABEL() {
		return COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE_LABEL(
			HtmlOutputLabel comp_smv_lc_gross_value_label) {
		COMP_SMV_LC_GROSS_VALUE_LABEL = comp_smv_lc_gross_value_label;
	}

	public HtmlInputText getCOMP_SMV_LC_GROSS_VALUE() {
		return COMP_SMV_LC_GROSS_VALUE;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE(HtmlInputText comp_smv_lc_gross_value) {
		COMP_SMV_LC_GROSS_VALUE = comp_smv_lc_gross_value;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_UNPAID_PREM_LABEL() {
		return COMP_SMV_FC_UNPAID_PREM_LABEL;
	}

	public void setCOMP_SMV_FC_UNPAID_PREM_LABEL(
			HtmlOutputLabel comp_smv_fc_unpaid_prem_label) {
		COMP_SMV_FC_UNPAID_PREM_LABEL = comp_smv_fc_unpaid_prem_label;
	}

	public HtmlInputText getCOMP_SMV_FC_UNPAID_PREM() {
		return COMP_SMV_FC_UNPAID_PREM;
	}

	public void setCOMP_SMV_FC_UNPAID_PREM(HtmlInputText comp_smv_fc_unpaid_prem) {
		COMP_SMV_FC_UNPAID_PREM = comp_smv_fc_unpaid_prem;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_UNPAID_PREM_LABEL() {
		return COMP_SMV_LC_UNPAID_PREM_LABEL;
	}

	public void setCOMP_SMV_LC_UNPAID_PREM_LABEL(
			HtmlOutputLabel comp_smv_lc_unpaid_prem_label) {
		COMP_SMV_LC_UNPAID_PREM_LABEL = comp_smv_lc_unpaid_prem_label;
	}

	public HtmlInputText getCOMP_SMV_LC_UNPAID_PREM() {
		return COMP_SMV_LC_UNPAID_PREM;
	}

	public void setCOMP_SMV_LC_UNPAID_PREM(HtmlInputText comp_smv_lc_unpaid_prem) {
		COMP_SMV_LC_UNPAID_PREM = comp_smv_lc_unpaid_prem;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_BAL_LOAN_LABEL() {
		return COMP_SMV_FC_BAL_LOAN_LABEL;
	}

	public void setCOMP_SMV_FC_BAL_LOAN_LABEL(
			HtmlOutputLabel comp_smv_fc_bal_loan_label) {
		COMP_SMV_FC_BAL_LOAN_LABEL = comp_smv_fc_bal_loan_label;
	}

	public HtmlInputText getCOMP_SMV_FC_BAL_LOAN() {
		return COMP_SMV_FC_BAL_LOAN;
	}

	public void setCOMP_SMV_FC_BAL_LOAN(HtmlInputText comp_smv_fc_bal_loan) {
		COMP_SMV_FC_BAL_LOAN = comp_smv_fc_bal_loan;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_BAL_LOAN_LABEL() {
		return COMP_SMV_LC_BAL_LOAN_LABEL;
	}

	public void setCOMP_SMV_LC_BAL_LOAN_LABEL(
			HtmlOutputLabel comp_smv_lc_bal_loan_label) {
		COMP_SMV_LC_BAL_LOAN_LABEL = comp_smv_lc_bal_loan_label;
	}

	public HtmlInputText getCOMP_SMV_LC_BAL_LOAN() {
		return COMP_SMV_LC_BAL_LOAN;
	}

	public void setCOMP_SMV_LC_BAL_LOAN(HtmlInputText comp_smv_lc_bal_loan) {
		COMP_SMV_LC_BAL_LOAN = comp_smv_lc_bal_loan;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_LOAN_INT_LABEL() {
		return COMP_SMV_FC_LOAN_INT_LABEL;
	}

	public void setCOMP_SMV_FC_LOAN_INT_LABEL(
			HtmlOutputLabel comp_smv_fc_loan_int_label) {
		COMP_SMV_FC_LOAN_INT_LABEL = comp_smv_fc_loan_int_label;
	}

	public HtmlInputText getCOMP_SMV_FC_LOAN_INT() {
		return COMP_SMV_FC_LOAN_INT;
	}

	public void setCOMP_SMV_FC_LOAN_INT(HtmlInputText comp_smv_fc_loan_int) {
		COMP_SMV_FC_LOAN_INT = comp_smv_fc_loan_int;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_TOT_CHARGE_LABEL() {
		return COMP_UI_M_FC_TOT_CHARGE_LABEL;
	}

	public void setCOMP_UI_M_FC_TOT_CHARGE_LABEL(
			HtmlOutputLabel comp_ui_m_fc_tot_charge_label) {
		COMP_UI_M_FC_TOT_CHARGE_LABEL = comp_ui_m_fc_tot_charge_label;
	}

	public HtmlInputText getCOMP_UI_M_FC_TOT_CHARGE() {
		return COMP_UI_M_FC_TOT_CHARGE;
	}

	public void setCOMP_UI_M_FC_TOT_CHARGE(HtmlInputText comp_ui_m_fc_tot_charge) {
		COMP_UI_M_FC_TOT_CHARGE = comp_ui_m_fc_tot_charge;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_TOT_CHARGE_LABEL() {
		return COMP_UI_M_LC_TOT_CHARGE_LABEL;
	}

	public void setCOMP_UI_M_LC_TOT_CHARGE_LABEL(
			HtmlOutputLabel comp_ui_m_lc_tot_charge_label) {
		COMP_UI_M_LC_TOT_CHARGE_LABEL = comp_ui_m_lc_tot_charge_label;
	}

	public HtmlInputText getCOMP_UI_M_LC_TOT_CHARGE() {
		return COMP_UI_M_LC_TOT_CHARGE;
	}

	public void setCOMP_UI_M_LC_TOT_CHARGE(HtmlInputText comp_ui_m_lc_tot_charge) {
		COMP_UI_M_LC_TOT_CHARGE = comp_ui_m_lc_tot_charge;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_NET_VALUE_LABEL() {
		return COMP_UI_M_FC_NET_VALUE_LABEL;
	}

	public void setCOMP_UI_M_FC_NET_VALUE_LABEL(
			HtmlOutputLabel comp_ui_m_fc_net_value_label) {
		COMP_UI_M_FC_NET_VALUE_LABEL = comp_ui_m_fc_net_value_label;
	}

	public HtmlInputText getCOMP_UI_M_FC_NET_VALUE() {
		return COMP_UI_M_FC_NET_VALUE;
	}

	public void setCOMP_UI_M_FC_NET_VALUE(HtmlInputText comp_ui_m_fc_net_value) {
		COMP_UI_M_FC_NET_VALUE = comp_ui_m_fc_net_value;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_NET_VALUE_LABEL() {
		return COMP_UI_M_LC_NET_VALUE_LABEL;
	}

	public void setCOMP_UI_M_LC_NET_VALUE_LABEL(
			HtmlOutputLabel comp_ui_m_lc_net_value_label) {
		COMP_UI_M_LC_NET_VALUE_LABEL = comp_ui_m_lc_net_value_label;
	}

	public HtmlInputText getCOMP_UI_M_LC_NET_VALUE() {
		return COMP_UI_M_LC_NET_VALUE;
	}

	public void setCOMP_UI_M_LC_NET_VALUE(HtmlInputText comp_ui_m_lc_net_value) {
		COMP_UI_M_LC_NET_VALUE = comp_ui_m_lc_net_value;
	}

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_SURR_MAT_VALUES_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_SURR_MAT_VALUES_HELPER helper) {
		this.helper = helper;
	}

	public void SMV_FC_RED_SA_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_FC_RED_SA((Double) value);
			helper.SMV_FC_RED_SA_WHEN_VALIDATE_ITEM(
					getPT_IL_SURR_MAT_VALUES_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getCOMP_SMV_FC_RED_SA().resetValue();
			getCOMP_SMV_LC_RED_SA().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void SMV_LC_RED_SA_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_LC_RED_SA((Double) value);
			helper.SMV_LC_RED_SA_WHEN_VALIDATE_ITEM(
					getPT_IL_SURR_MAT_VALUES_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getCOMP_SMV_LC_RED_SA().resetValue();
			getCOMP_SMV_FC_GROSS_VALUE().resetValue();
			getCOMP_SMV_LC_GROSS_VALUE().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void SMV_FC_ACC_PROFIT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_MAT_VALUES_BEAN()
					.setSMV_FC_ACC_PROFIT((Double) value);
			helper.SMV_FC_ACC_PROFIT_WHEN_VALIDATE_ITEM(
					getPT_IL_SURR_MAT_VALUES_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getCOMP_SMV_FC_ACC_PROFIT().resetValue();
			getCOMP_SMV_LC_ACC_PROFIT().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void SMV_LC_ACC_PROFIT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_MAT_VALUES_BEAN()
					.setSMV_LC_ACC_PROFIT((Double) value);
			helper.SMV_LC_ACC_PROFIT_WHEN_VALIDATE_ITEM(
					getPT_IL_SURR_MAT_VALUES_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getCOMP_SMV_LC_ACC_PROFIT().resetValue();
			getCOMP_SMV_FC_GROSS_VALUE().resetValue();
			getCOMP_SMV_LC_GROSS_VALUE().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void SMV_FC_UNPAID_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_FC_UNPAID_PREM(
					(Double) value);
			helper.SMV_FC_UNPAID_PREM_WHEN_VALIDATE_ITEM(
					getPT_IL_SURR_MAT_VALUES_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getCOMP_SMV_FC_UNPAID_PREM().resetValue();
			getCOMP_SMV_LC_UNPAID_PREM().resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void SMV_LC_UNPAID_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_LC_UNPAID_PREM(
					(Double) value);
			helper.SMV_LC_UNPAID_PREM_WHEN_VALIDATE_ITEM(
					getPT_IL_SURR_MAT_VALUES_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getCOMP_SMV_LC_UNPAID_PREM().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	/**
	 * Disables all components in PT_IL_SURR_MAT_VALUES_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_SMV_FC_RED_SA.setDisabled(disabled);
		COMP_SMV_LC_RED_SA.setDisabled(disabled);
		COMP_SMV_FC_ACC_PROFIT.setDisabled(disabled);
		COMP_SMV_LC_ACC_PROFIT.setDisabled(disabled);
		COMP_SMV_FC_GROSS_VALUE.setDisabled(disabled);
		COMP_SMV_LC_GROSS_VALUE.setDisabled(disabled);
		COMP_SMV_FC_UNPAID_PREM.setDisabled(disabled);
		COMP_SMV_LC_UNPAID_PREM.setDisabled(disabled);
		COMP_SMV_FC_BAL_LOAN.setDisabled(disabled);
		COMP_SMV_LC_BAL_LOAN.setDisabled(disabled);
		COMP_SMV_FC_LOAN_INT.setDisabled(disabled);
		COMP_SMV_LC_LOAN_INT.setDisabled(disabled);
		COMP_UI_M_FC_TOT_CHARGE.setDisabled(disabled);
		COMP_UI_M_LC_TOT_CHARGE.setDisabled(disabled);
		COMP_UI_M_FC_NET_VALUE.setDisabled(disabled);
		COMP_UI_M_LC_NET_VALUE.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_SMV_DATE.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_SURR_MAT_VALUES_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_SMV_FC_RED_SA				 = new HtmlInputText();
		COMP_SMV_LC_RED_SA				 = new HtmlInputText();
		COMP_SMV_FC_ACC_PROFIT				 = new HtmlInputText();
		COMP_SMV_LC_ACC_PROFIT				 = new HtmlInputText();
		COMP_SMV_FC_GROSS_VALUE				 = new HtmlInputText();
		COMP_SMV_LC_GROSS_VALUE				 = new HtmlInputText();
		COMP_SMV_FC_UNPAID_PREM				 = new HtmlInputText();
		COMP_SMV_LC_UNPAID_PREM				 = new HtmlInputText();
		COMP_SMV_FC_BAL_LOAN				 = new HtmlInputText();
		COMP_SMV_LC_BAL_LOAN				 = new HtmlInputText();
		COMP_SMV_FC_LOAN_INT				 = new HtmlInputText();
		COMP_SMV_LC_LOAN_INT				 = new HtmlInputText();
		COMP_UI_M_FC_TOT_CHARGE				 = new HtmlInputText();
		COMP_UI_M_LC_TOT_CHARGE				 = new HtmlInputText();
		COMP_UI_M_FC_NET_VALUE				 = new HtmlInputText();
		COMP_UI_M_LC_NET_VALUE				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_SMV_DATE_LABEL				 = new HtmlOutputLabel();
		COMP_SMV_FC_RED_SA_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_LC_RED_SA_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_FC_ACC_PROFIT_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_LC_ACC_PROFIT_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_FC_GROSS_VALUE_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_LC_GROSS_VALUE_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_FC_UNPAID_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_LC_UNPAID_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_FC_BAL_LOAN_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_LC_BAL_LOAN_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_FC_LOAN_INT_LABEL			 = new HtmlOutputLabel();
		COMP_SMV_LC_LOAN_INT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_TOT_CHARGE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_TOT_CHARGE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FC_NET_VALUE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_LC_NET_VALUE_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCalendar
		COMP_SMV_DATE					 = new HtmlCalendar();

	}


}
