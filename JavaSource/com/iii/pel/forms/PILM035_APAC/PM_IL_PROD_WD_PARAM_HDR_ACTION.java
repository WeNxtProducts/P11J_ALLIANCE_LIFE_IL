package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_WD_PARAM_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PWPH_WITHDRAW_MIN_YRS_LABEL;

	private HtmlInputText COMP_PWPH_WITHDRAW_MIN_YRS;

	private HtmlOutputLabel COMP_PWPH_WITHDRAW_INTERVAL_LABEL;

	private HtmlInputText COMP_PWPH_WITHDRAW_INTERVAL;

	private HtmlOutputLabel COMP_PWPH_MAX_NO_WITHDRAW_LABEL;

	private HtmlInputText COMP_PWPH_MAX_NO_WITHDRAW;

	private HtmlOutputLabel COMP_PWPH_TOPUP_MIN_YRS_LABEL;

	private HtmlInputText COMP_PWPH_TOPUP_MIN_YRS;

	private PM_IL_PROD_WD_PARAM_HDR PM_IL_PROD_WD_PARAM_HDR_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;
	
	private HtmlCommandButton COMP_UI_M_BUT_MAIN2;

	private PM_IL_PROD_WD_PARAM_HDR_HELPER helper;

	private PM_IL_PROD_WD_PARAM_DTL_HELPER detailhelper = null;
	
	private UIData dataTable;
	
	private List<PM_IL_PROD_WD_PARAM_HDR> dataList_PM_IL_PROD_WD_PARAM_HDR = new ArrayList<PM_IL_PROD_WD_PARAM_HDR>();

	public PM_IL_PROD_WD_PARAM_HDR_ACTION() {

		PM_IL_PROD_WD_PARAM_HDR_BEAN = new PM_IL_PROD_WD_PARAM_HDR();
		helper = new PM_IL_PROD_WD_PARAM_HDR_HELPER();
		detailhelper = new PM_IL_PROD_WD_PARAM_DTL_HELPER();
	}

	public HtmlOutputLabel getCOMP_PWPH_WITHDRAW_MIN_YRS_LABEL() {
		return COMP_PWPH_WITHDRAW_MIN_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PWPH_WITHDRAW_MIN_YRS() {
		return COMP_PWPH_WITHDRAW_MIN_YRS;
	}

	public void setCOMP_PWPH_WITHDRAW_MIN_YRS_LABEL(
			HtmlOutputLabel COMP_PWPH_WITHDRAW_MIN_YRS_LABEL) {
		this.COMP_PWPH_WITHDRAW_MIN_YRS_LABEL = COMP_PWPH_WITHDRAW_MIN_YRS_LABEL;
	}

	public void setCOMP_PWPH_WITHDRAW_MIN_YRS(
			HtmlInputText COMP_PWPH_WITHDRAW_MIN_YRS) {
		this.COMP_PWPH_WITHDRAW_MIN_YRS = COMP_PWPH_WITHDRAW_MIN_YRS;
	}

	public HtmlOutputLabel getCOMP_PWPH_WITHDRAW_INTERVAL_LABEL() {
		return COMP_PWPH_WITHDRAW_INTERVAL_LABEL;
	}

	public HtmlInputText getCOMP_PWPH_WITHDRAW_INTERVAL() {
		return COMP_PWPH_WITHDRAW_INTERVAL;
	}

	public void setCOMP_PWPH_WITHDRAW_INTERVAL_LABEL(
			HtmlOutputLabel COMP_PWPH_WITHDRAW_INTERVAL_LABEL) {
		this.COMP_PWPH_WITHDRAW_INTERVAL_LABEL = COMP_PWPH_WITHDRAW_INTERVAL_LABEL;
	}

	public void setCOMP_PWPH_WITHDRAW_INTERVAL(
			HtmlInputText COMP_PWPH_WITHDRAW_INTERVAL) {
		this.COMP_PWPH_WITHDRAW_INTERVAL = COMP_PWPH_WITHDRAW_INTERVAL;
	}

	public HtmlOutputLabel getCOMP_PWPH_MAX_NO_WITHDRAW_LABEL() {
		return COMP_PWPH_MAX_NO_WITHDRAW_LABEL;
	}

	public HtmlInputText getCOMP_PWPH_MAX_NO_WITHDRAW() {
		return COMP_PWPH_MAX_NO_WITHDRAW;
	}

	public void setCOMP_PWPH_MAX_NO_WITHDRAW_LABEL(
			HtmlOutputLabel COMP_PWPH_MAX_NO_WITHDRAW_LABEL) {
		this.COMP_PWPH_MAX_NO_WITHDRAW_LABEL = COMP_PWPH_MAX_NO_WITHDRAW_LABEL;
	}

	public void setCOMP_PWPH_MAX_NO_WITHDRAW(
			HtmlInputText COMP_PWPH_MAX_NO_WITHDRAW) {
		this.COMP_PWPH_MAX_NO_WITHDRAW = COMP_PWPH_MAX_NO_WITHDRAW;
	}

	public HtmlOutputLabel getCOMP_PWPH_TOPUP_MIN_YRS_LABEL() {
		return COMP_PWPH_TOPUP_MIN_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PWPH_TOPUP_MIN_YRS() {
		return COMP_PWPH_TOPUP_MIN_YRS;
	}

	public void setCOMP_PWPH_TOPUP_MIN_YRS_LABEL(
			HtmlOutputLabel COMP_PWPH_TOPUP_MIN_YRS_LABEL) {
		this.COMP_PWPH_TOPUP_MIN_YRS_LABEL = COMP_PWPH_TOPUP_MIN_YRS_LABEL;
	}

	public void setCOMP_PWPH_TOPUP_MIN_YRS(HtmlInputText COMP_PWPH_TOPUP_MIN_YRS) {
		this.COMP_PWPH_TOPUP_MIN_YRS = COMP_PWPH_TOPUP_MIN_YRS;
	}

	public PM_IL_PROD_WD_PARAM_HDR getPM_IL_PROD_WD_PARAM_HDR_BEAN() {
		return PM_IL_PROD_WD_PARAM_HDR_BEAN;
	}

	public void setPM_IL_PROD_WD_PARAM_HDR_BEAN(
			PM_IL_PROD_WD_PARAM_HDR PM_IL_PROD_WD_PARAM_HDR_BEAN) {
		this.PM_IL_PROD_WD_PARAM_HDR_BEAN = PM_IL_PROD_WD_PARAM_HDR_BEAN;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		try {
			if (getPM_IL_PROD_WD_PARAM_HDR_BEAN().getROWID() == null) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(
						getPM_IL_PROD_WD_PARAM_HDR_BEAN(), CommonUtils
								.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
						"errorPanel$message$save"));
			} else {
				new CRUDHandler().executeUpdate(
						getPM_IL_PROD_WD_PARAM_HDR_BEAN(), CommonUtils
								.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				getWarningMap().put(
						"update",
						Messages.getString("messageProperties",
						"errorPanel$message$update"));
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				detailhelper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void PWPH_WITHDRAW_MIN_YRS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATE_ITEM_PWPH_WITHDRAW_MIN_YRS(compositeAction,
					value);
			getPM_IL_PROD_WD_PARAM_HDR_BEAN().setPWPH_WITHDRAW_MIN_YRS(
					(Integer) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public String mainAction(){
		return "PILM035_APAC_PM_IL_PRODUCT";
	}

	public void PWPH_TOPUP_MIN_YRS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper
					.WHEN_VALIDATE_ITEM_PWPH_TOPUP_MIN_YRS(compositeAction,
							value);
			getPM_IL_PROD_WD_PARAM_HDR_BEAN().setPWPH_TOPUP_MIN_YRS(
					(Integer) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN2() {
		return COMP_UI_M_BUT_MAIN2;
	}

	public void setCOMP_UI_M_BUT_MAIN2(HtmlCommandButton comp_ui_m_but_main2) {
		COMP_UI_M_BUT_MAIN2 = comp_ui_m_but_main2;
	}
	
	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PROD_WD_PARAM_HDR_BEAN = new PM_IL_PROD_WD_PARAM_HDR();
				//resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_WD_PARAM_HDR_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PM_IL_PROD_WD_PARAM_HDR
						.remove(PM_IL_PROD_WD_PARAM_HDR_BEAN);
				if (dataList_PM_IL_PROD_WD_PARAM_HDR.size() > 0) {

					PM_IL_PROD_WD_PARAM_HDR_BEAN = dataList_PM_IL_PROD_WD_PARAM_HDR
							.get(0);
				} else if (dataList_PM_IL_PROD_WD_PARAM_HDR.size() == 0) {

					addRow(null);
				}

				//resetAllComponent();
				PM_IL_PROD_WD_PARAM_HDR_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PM_IL_PROD_WD_PARAM_HDR_BEAN.getROWID() == null){
				if( isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_WD_PARAM_HDR_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_IL_PROD_WD_PARAM_HDR
						.add(PM_IL_PROD_WD_PARAM_HDR_BEAN);
			}
			else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insertnotallowed"));
			}
			}
			else if (PM_IL_PROD_WD_PARAM_HDR_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_WD_PARAM_HDR_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}
			else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$updatenotallowed"));
			}
			}
			PM_IL_PROD_WD_PARAM_HDR_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	
	
	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_WD_PARAM_HDR> PM_IL_PROD_WD_PARAM_HDR_ITR = dataList_PM_IL_PROD_WD_PARAM_HDR
				.iterator();
		while (PM_IL_PROD_WD_PARAM_HDR_ITR.hasNext()) {
			PM_IL_PROD_WD_PARAM_HDR_ITR.next().setRowSelected(false);
		}
	}

	public List<PM_IL_PROD_WD_PARAM_HDR> getDataList_PM_IL_PROD_WD_PARAM_HDR() {
		return dataList_PM_IL_PROD_WD_PARAM_HDR;
	}

	public void setDataList_PM_IL_PROD_WD_PARAM_HDR(
			List<PM_IL_PROD_WD_PARAM_HDR> dataList_PM_IL_PROD_WD_PARAM_HDR) {
		this.dataList_PM_IL_PROD_WD_PARAM_HDR = dataList_PM_IL_PROD_WD_PARAM_HDR;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	
	/*added by raja on 12-07-2017 for ZBILQC-1731237*/
	private HtmlOutputLabel COMP_PWPH_FULL_WD_MIN_AGE_LABEL;
	private HtmlInputText COMP_PWPH_FULL_WD_MIN_AGE;

	private HtmlOutputLabel COMP_PWPH_FULL_WD_PERIOD_LABEL;
	private HtmlInputText COMP_PWPH_FULL_WD_PERIOD;

	public HtmlOutputLabel getCOMP_PWPH_FULL_WD_MIN_AGE_LABEL() {
		return COMP_PWPH_FULL_WD_MIN_AGE_LABEL;
	}

	public void setCOMP_PWPH_FULL_WD_MIN_AGE_LABEL(
			HtmlOutputLabel cOMP_PWPH_FULL_WD_MIN_AGE_LABEL) {
		COMP_PWPH_FULL_WD_MIN_AGE_LABEL = cOMP_PWPH_FULL_WD_MIN_AGE_LABEL;
	}

	
	public HtmlOutputLabel getCOMP_PWPH_FULL_WD_PERIOD_LABEL() {
		return COMP_PWPH_FULL_WD_PERIOD_LABEL;
	}

	public void setCOMP_PWPH_FULL_WD_PERIOD_LABEL(
			HtmlOutputLabel cOMP_PWPH_FULL_WD_PERIOD_LABEL) {
		COMP_PWPH_FULL_WD_PERIOD_LABEL = cOMP_PWPH_FULL_WD_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_PWPH_FULL_WD_MIN_AGE() {
		return COMP_PWPH_FULL_WD_MIN_AGE;
	}

	public void setCOMP_PWPH_FULL_WD_MIN_AGE(HtmlInputText cOMP_PWPH_FULL_WD_MIN_AGE) {
		COMP_PWPH_FULL_WD_MIN_AGE = cOMP_PWPH_FULL_WD_MIN_AGE;
	}

	public HtmlInputText getCOMP_PWPH_FULL_WD_PERIOD() {
		return COMP_PWPH_FULL_WD_PERIOD;
	}

	public void setCOMP_PWPH_FULL_WD_PERIOD(HtmlInputText cOMP_PWPH_FULL_WD_PERIOD) {
		COMP_PWPH_FULL_WD_PERIOD = cOMP_PWPH_FULL_WD_PERIOD;
	}

	
	/*end*/
	
	/*added by raja on 02-08-2017 for ZBILQC-1732436*/
	
	private HtmlOutputLabel COMP_PWPH_FULL_NO_OF_PREM_LABEL;
	private HtmlInputText COMP_PWPH_FULL_NO_OF_PREM;

	public HtmlOutputLabel getCOMP_PWPH_FULL_NO_OF_PREM_LABEL() {
		return COMP_PWPH_FULL_NO_OF_PREM_LABEL;
	}

	public void setCOMP_PWPH_FULL_NO_OF_PREM_LABEL(
			HtmlOutputLabel cOMP_PWPH_FULL_NO_OF_PREM_LABEL) {
		COMP_PWPH_FULL_NO_OF_PREM_LABEL = cOMP_PWPH_FULL_NO_OF_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PWPH_FULL_NO_OF_PREM() {
		return COMP_PWPH_FULL_NO_OF_PREM;
	}

	public void setCOMP_PWPH_FULL_NO_OF_PREM(HtmlInputText cOMP_PWPH_FULL_NO_OF_PREM) {
		COMP_PWPH_FULL_NO_OF_PREM = cOMP_PWPH_FULL_NO_OF_PREM;
	}

	
	
	/*end*/
	
}
