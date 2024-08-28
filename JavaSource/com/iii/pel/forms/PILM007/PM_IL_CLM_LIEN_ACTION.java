package com.iii.pel.forms.PILM007;

import java.sql.Connection;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CLM_LIEN_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CL_FM_AGE_LABEL;

	private HtmlInputText COMP_CL_FM_AGE;

	private HtmlOutputLabel COMP_CL_TO_AGE_LABEL;

	private HtmlInputText COMP_CL_TO_AGE;

	private HtmlOutputLabel COMP_CL_RATE_LABEL;

	private HtmlInputText COMP_CL_RATE;

	private HtmlOutputLabel COMP_CL_RATE_PER_LABEL;

	private HtmlInputText COMP_CL_RATE_PER;

	private HtmlOutputLabel COMP_CL_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_CL_APPLIED_ON;

	private HtmlCommandButton COMP_UI_M_BUT_LIEN_MAIN;

	private PM_IL_CLM_LIEN PM_IL_CLM_LIEN_BEAN;

	public PILM007_COMPOSITE_ACTION compositeAction;

	private PM_IL_CLM_LIEN_HELPER helper;

	private List<PM_IL_CLM_LIEN> dataList_PM_IL_CLM_LIEN = new ArrayList<PM_IL_CLM_LIEN>();

	private UIData dataTable;

	private List<SelectItem> listCL_APPLIED_ON;

	public PM_IL_CLM_LIEN_ACTION() {

		PM_IL_CLM_LIEN_BEAN = new PM_IL_CLM_LIEN();
		helper = new PM_IL_CLM_LIEN_HELPER();
		prepareListItemValues();
	}

	public HtmlOutputLabel getCOMP_CL_FM_AGE_LABEL() {
		return COMP_CL_FM_AGE_LABEL;
	}

	public HtmlInputText getCOMP_CL_FM_AGE() {
		return COMP_CL_FM_AGE;
	}

	public void setCOMP_CL_FM_AGE_LABEL(HtmlOutputLabel COMP_CL_FM_AGE_LABEL) {
		this.COMP_CL_FM_AGE_LABEL = COMP_CL_FM_AGE_LABEL;
	}

	public void setCOMP_CL_FM_AGE(HtmlInputText COMP_CL_FM_AGE) {
		this.COMP_CL_FM_AGE = COMP_CL_FM_AGE;
	}

	public HtmlOutputLabel getCOMP_CL_TO_AGE_LABEL() {
		return COMP_CL_TO_AGE_LABEL;
	}

	public HtmlInputText getCOMP_CL_TO_AGE() {
		return COMP_CL_TO_AGE;
	}

	public void setCOMP_CL_TO_AGE_LABEL(HtmlOutputLabel COMP_CL_TO_AGE_LABEL) {
		this.COMP_CL_TO_AGE_LABEL = COMP_CL_TO_AGE_LABEL;
	}

	public void setCOMP_CL_TO_AGE(HtmlInputText COMP_CL_TO_AGE) {
		this.COMP_CL_TO_AGE = COMP_CL_TO_AGE;
	}

	public HtmlOutputLabel getCOMP_CL_RATE_LABEL() {
		return COMP_CL_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CL_RATE() {
		return COMP_CL_RATE;
	}

	public void setCOMP_CL_RATE_LABEL(HtmlOutputLabel COMP_CL_RATE_LABEL) {
		this.COMP_CL_RATE_LABEL = COMP_CL_RATE_LABEL;
	}

	public void setCOMP_CL_RATE(HtmlInputText COMP_CL_RATE) {
		this.COMP_CL_RATE = COMP_CL_RATE;
	}

	public HtmlOutputLabel getCOMP_CL_RATE_PER_LABEL() {
		return COMP_CL_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_CL_RATE_PER() {
		return COMP_CL_RATE_PER;
	}

	public void setCOMP_CL_RATE_PER_LABEL(HtmlOutputLabel COMP_CL_RATE_PER_LABEL) {
		this.COMP_CL_RATE_PER_LABEL = COMP_CL_RATE_PER_LABEL;
	}

	public void setCOMP_CL_RATE_PER(HtmlInputText COMP_CL_RATE_PER) {
		this.COMP_CL_RATE_PER = COMP_CL_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_CL_APPLIED_ON_LABEL() {
		return COMP_CL_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CL_APPLIED_ON() {
		return COMP_CL_APPLIED_ON;
	}

	public void setCOMP_CL_APPLIED_ON_LABEL(
			HtmlOutputLabel COMP_CL_APPLIED_ON_LABEL) {
		this.COMP_CL_APPLIED_ON_LABEL = COMP_CL_APPLIED_ON_LABEL;
	}

	public void setCOMP_CL_APPLIED_ON(HtmlSelectOneMenu COMP_CL_APPLIED_ON) {
		this.COMP_CL_APPLIED_ON = COMP_CL_APPLIED_ON;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LIEN_MAIN() {
		return COMP_UI_M_BUT_LIEN_MAIN;
	}

	public void setCOMP_UI_M_BUT_LIEN_MAIN(
			HtmlCommandButton COMP_UI_M_BUT_LIEN_MAIN) {
		this.COMP_UI_M_BUT_LIEN_MAIN = COMP_UI_M_BUT_LIEN_MAIN;
	}

	public PM_IL_CLM_LIEN getPM_IL_CLM_LIEN_BEAN() {
		return PM_IL_CLM_LIEN_BEAN;
	}

	public void setPM_IL_CLM_LIEN_BEAN(PM_IL_CLM_LIEN PM_IL_CLM_LIEN_BEAN) {
		this.PM_IL_CLM_LIEN_BEAN = PM_IL_CLM_LIEN_BEAN;
	}

	public List<PM_IL_CLM_LIEN> getDataList_PM_IL_CLM_LIEN() {
		return dataList_PM_IL_CLM_LIEN;
	}

	public void setDataListPM_IL_CLM_LIEN(
			List<PM_IL_CLM_LIEN> dataList_PM_IL_CLM_LIEN) {
		this.dataList_PM_IL_CLM_LIEN = dataList_PM_IL_CLM_LIEN;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_CLM_LIEN_BEAN = new PM_IL_CLM_LIEN();
				resetAllComponent();
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

				new CRUDHandler().executeDelete(PM_IL_CLM_LIEN_BEAN,
						CommonUtils.getConnection());
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
				dataList_PM_IL_CLM_LIEN.remove(PM_IL_CLM_LIEN_BEAN);
				if (dataList_PM_IL_CLM_LIEN.size() > 0) {

					PM_IL_CLM_LIEN_BEAN = dataList_PM_IL_CLM_LIEN.get(0);
				} else if (dataList_PM_IL_CLM_LIEN.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_CLM_LIEN_BEAN.setRowSelected(true);
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
			if (PM_IL_CLM_LIEN_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				helper.checkDuplicateRangeInsert(compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN(),
						PM_IL_CLM_LIEN_BEAN);
				new CRUDHandler().executeInsert(PM_IL_CLM_LIEN_BEAN,
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
				dataList_PM_IL_CLM_LIEN.add(PM_IL_CLM_LIEN_BEAN);
			} else if (PM_IL_CLM_LIEN_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				helper.checkDuplicateRangeUpdate(compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN(),
						PM_IL_CLM_LIEN_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_CLM_LIEN_BEAN,
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

			PM_IL_CLM_LIEN_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_CLM_LIEN_BEAN = (PM_IL_CLM_LIEN) dataTable.getRowData();
			PM_IL_CLM_LIEN_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_CLM_LIEN> PM_IL_CLM_LIEN_ITR = dataList_PM_IL_CLM_LIEN
				.iterator();
		while (PM_IL_CLM_LIEN_ITR.hasNext()) {
			PM_IL_CLM_LIEN_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CL_FM_AGE.resetValue();
		COMP_CL_TO_AGE.resetValue();
		COMP_CL_RATE.resetValue();
		COMP_CL_RATE_PER.resetValue();
		COMP_CL_APPLIED_ON.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			String message ="";
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListCL_APPLIED_ON() {
		if (listCL_APPLIED_ON.size() == 0) {
			listCL_APPLIED_ON.clear();
			try {
				listCL_APPLIED_ON = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCL_APPLIED_ON;
	}

	public void setListCL_APPLIED_ON(List<SelectItem> listCL_APPLIED_ON) {
		this.listCL_APPLIED_ON = listCL_APPLIED_ON;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void CL_FM_AGE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_CLM_LIEN_BEAN().setCL_FM_AGE((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CL_RATE_Validator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			getPM_IL_CLM_LIEN_BEAN().setCL_RATE((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CL_TO_AGE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CL_TO_AGE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LIEN_BEAN().setCL_TO_AGE((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CL_RATE_PER_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CL_RATE_PER_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LIEN_BEAN().setCL_RATE_PER((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				if (compositeAction.getPM_IL_CLM_LIEN_ACTION_BEAN()
						.getPM_IL_CLM_LIEN_BEAN().getROWID() == null) {
					helper.WHEN_CREATE_RECORD(compositeAction);
				}
				helper.preQuery(compositeAction);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String callPM_IL_CLM_REPAY() {
		setBlockFlag(true);
		return "PILM007_PM_IL_CLM_REPAY";

	}

	private void prepareListItemValues() {
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			listCL_APPLIED_ON = ListItemUtil.getDropDownListValue(connection,
					"PILM007", "PM_IL_CLM_LIEN",
					"PM_IL_CLM_LIEN.CL_APPLIED_ON", "IL_CL_APPL");
		} catch (DBException e) {

			e.printStackTrace();
		}

	}

}
