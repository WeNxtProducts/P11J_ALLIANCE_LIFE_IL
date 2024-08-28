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

public class PM_IL_CLM_WAIT_PERIOD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CWP_FM_DAYS_LABEL;

	private HtmlInputText COMP_CWP_FM_DAYS;

	private HtmlOutputLabel COMP_CWP_TO_DAYS_LABEL;

	private HtmlInputText COMP_CWP_TO_DAYS;

	private HtmlOutputLabel COMP_CWP_RATE_LABEL;

	private HtmlInputText COMP_CWP_RATE;

	private HtmlOutputLabel COMP_CWP_RATE_PER_LABEL;

	private HtmlInputText COMP_CWP_RATE_PER;

	private HtmlOutputLabel COMP_CWP_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_CWP_APPLIED_ON;

	private HtmlCommandButton COMP_UI_M_BUT_WAIT_PERIOD_MAIN;

	private PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN;

	public PILM007_COMPOSITE_ACTION compositeAction;

	private PM_IL_CLM_WAIT_PERIOD_HELPER helper;

	private List<PM_IL_CLM_WAIT_PERIOD> dataList_PM_IL_CLM_WAIT_PERIOD = new ArrayList<PM_IL_CLM_WAIT_PERIOD>();

	private UIData dataTable;

	private List<SelectItem> listCWP_APPLIED_ON;

	public PM_IL_CLM_WAIT_PERIOD_ACTION() {

		PM_IL_CLM_WAIT_PERIOD_BEAN = new PM_IL_CLM_WAIT_PERIOD();
		helper = new PM_IL_CLM_WAIT_PERIOD_HELPER();
		prepareListItemValues();
	}

	public HtmlOutputLabel getCOMP_CWP_FM_DAYS_LABEL() {
		return COMP_CWP_FM_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_CWP_FM_DAYS() {
		return COMP_CWP_FM_DAYS;
	}

	public void setCOMP_CWP_FM_DAYS_LABEL(HtmlOutputLabel COMP_CWP_FM_DAYS_LABEL) {
		this.COMP_CWP_FM_DAYS_LABEL = COMP_CWP_FM_DAYS_LABEL;
	}

	public void setCOMP_CWP_FM_DAYS(HtmlInputText COMP_CWP_FM_DAYS) {
		this.COMP_CWP_FM_DAYS = COMP_CWP_FM_DAYS;
	}

	public HtmlOutputLabel getCOMP_CWP_TO_DAYS_LABEL() {
		return COMP_CWP_TO_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_CWP_TO_DAYS() {
		return COMP_CWP_TO_DAYS;
	}

	public void setCOMP_CWP_TO_DAYS_LABEL(HtmlOutputLabel COMP_CWP_TO_DAYS_LABEL) {
		this.COMP_CWP_TO_DAYS_LABEL = COMP_CWP_TO_DAYS_LABEL;
	}

	public void setCOMP_CWP_TO_DAYS(HtmlInputText COMP_CWP_TO_DAYS) {
		this.COMP_CWP_TO_DAYS = COMP_CWP_TO_DAYS;
	}

	public HtmlOutputLabel getCOMP_CWP_RATE_LABEL() {
		return COMP_CWP_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CWP_RATE() {
		return COMP_CWP_RATE;
	}

	public void setCOMP_CWP_RATE_LABEL(HtmlOutputLabel COMP_CWP_RATE_LABEL) {
		this.COMP_CWP_RATE_LABEL = COMP_CWP_RATE_LABEL;
	}

	public void setCOMP_CWP_RATE(HtmlInputText COMP_CWP_RATE) {
		this.COMP_CWP_RATE = COMP_CWP_RATE;
	}

	public HtmlOutputLabel getCOMP_CWP_RATE_PER_LABEL() {
		return COMP_CWP_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_CWP_RATE_PER() {
		return COMP_CWP_RATE_PER;
	}

	public void setCOMP_CWP_RATE_PER_LABEL(
			HtmlOutputLabel COMP_CWP_RATE_PER_LABEL) {
		this.COMP_CWP_RATE_PER_LABEL = COMP_CWP_RATE_PER_LABEL;
	}

	public void setCOMP_CWP_RATE_PER(HtmlInputText COMP_CWP_RATE_PER) {
		this.COMP_CWP_RATE_PER = COMP_CWP_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_CWP_APPLIED_ON_LABEL() {
		return COMP_CWP_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CWP_APPLIED_ON() {
		
		return COMP_CWP_APPLIED_ON;
	}

	public void setCOMP_CWP_APPLIED_ON_LABEL(
			HtmlOutputLabel COMP_CWP_APPLIED_ON_LABEL) {
		this.COMP_CWP_APPLIED_ON_LABEL = COMP_CWP_APPLIED_ON_LABEL;
	}

	public void setCOMP_CWP_APPLIED_ON(HtmlSelectOneMenu COMP_CWP_APPLIED_ON) {
		this.COMP_CWP_APPLIED_ON = COMP_CWP_APPLIED_ON;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_WAIT_PERIOD_MAIN() {
		return COMP_UI_M_BUT_WAIT_PERIOD_MAIN;
	}

	public void setCOMP_UI_M_BUT_WAIT_PERIOD_MAIN(
			HtmlCommandButton COMP_UI_M_BUT_WAIT_PERIOD_MAIN) {
		this.COMP_UI_M_BUT_WAIT_PERIOD_MAIN = COMP_UI_M_BUT_WAIT_PERIOD_MAIN;
	}

	public PM_IL_CLM_WAIT_PERIOD getPM_IL_CLM_WAIT_PERIOD_BEAN() {
		return PM_IL_CLM_WAIT_PERIOD_BEAN;
	}

	public void setPM_IL_CLM_WAIT_PERIOD_BEAN(
			PM_IL_CLM_WAIT_PERIOD PM_IL_CLM_WAIT_PERIOD_BEAN) {
		this.PM_IL_CLM_WAIT_PERIOD_BEAN = PM_IL_CLM_WAIT_PERIOD_BEAN;
	}

	public List<PM_IL_CLM_WAIT_PERIOD> getDataList_PM_IL_CLM_WAIT_PERIOD() {
		return dataList_PM_IL_CLM_WAIT_PERIOD;
	}

	public void setDataListPM_IL_CLM_WAIT_PERIOD(
			List<PM_IL_CLM_WAIT_PERIOD> dataList_PM_IL_CLM_WAIT_PERIOD) {
		this.dataList_PM_IL_CLM_WAIT_PERIOD = dataList_PM_IL_CLM_WAIT_PERIOD;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_CLM_WAIT_PERIOD_BEAN = new PM_IL_CLM_WAIT_PERIOD();
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

				new CRUDHandler().executeDelete(PM_IL_CLM_WAIT_PERIOD_BEAN,
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
				dataList_PM_IL_CLM_WAIT_PERIOD
						.remove(PM_IL_CLM_WAIT_PERIOD_BEAN);
				if (dataList_PM_IL_CLM_WAIT_PERIOD.size() > 0) {

					PM_IL_CLM_WAIT_PERIOD_BEAN = dataList_PM_IL_CLM_WAIT_PERIOD
							.get(0);
				} else if (dataList_PM_IL_CLM_WAIT_PERIOD.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_CLM_WAIT_PERIOD_BEAN.setRowSelected(true);
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
			if (PM_IL_CLM_WAIT_PERIOD_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
					helper.PRE_INSERT(PM_IL_CLM_WAIT_PERIOD_BEAN,this.compositeAction);
					helper.checkDuplicateRangeInsert(compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN(),
							PM_IL_CLM_WAIT_PERIOD_BEAN);
					new CRUDHandler().executeInsert(PM_IL_CLM_WAIT_PERIOD_BEAN,
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
					dataList_PM_IL_CLM_WAIT_PERIOD.add(PM_IL_CLM_WAIT_PERIOD_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_IL_CLM_WAIT_PERIOD_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()){
					helper.PRE_UPDATE(PM_IL_CLM_WAIT_PERIOD_BEAN,this.compositeAction);
					helper.checkDuplicateRangeUpdate(compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN(),
							PM_IL_CLM_WAIT_PERIOD_BEAN);
					new CRUDHandler().executeUpdate(PM_IL_CLM_WAIT_PERIOD_BEAN,
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
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}

			PM_IL_CLM_WAIT_PERIOD_BEAN.setRowSelected(true);
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
			PM_IL_CLM_WAIT_PERIOD_BEAN = (PM_IL_CLM_WAIT_PERIOD) dataTable
					.getRowData();
			PM_IL_CLM_WAIT_PERIOD_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_CLM_WAIT_PERIOD> PM_IL_CLM_WAIT_PERIOD_ITR = dataList_PM_IL_CLM_WAIT_PERIOD
				.iterator();
		while (PM_IL_CLM_WAIT_PERIOD_ITR.hasNext()) {
			PM_IL_CLM_WAIT_PERIOD_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CWP_FM_DAYS.resetValue();
		COMP_CWP_TO_DAYS.resetValue();
		COMP_CWP_RATE.resetValue();
		COMP_CWP_RATE_PER.resetValue();
		COMP_CWP_APPLIED_ON.resetValue();
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
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListCWP_APPLIED_ON() {
		if (listCWP_APPLIED_ON.size() == 0) {
			listCWP_APPLIED_ON.clear();
			try {
				listCWP_APPLIED_ON = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCWP_APPLIED_ON;
	}

	public void setListCWP_APPLIED_ON(List<SelectItem> listCWP_APPLIED_ON) {
		this.listCWP_APPLIED_ON = listCWP_APPLIED_ON;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if(compositeAction.getPM_IL_CLM_WAIT_PERIOD_ACTION_BEAN().getPM_IL_CLM_WAIT_PERIOD_BEAN().getROWID()==null)
				helper.WHEN_CREATE_RECORD(compositeAction);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	private void prepareListItemValues() {
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			listCWP_APPLIED_ON = ListItemUtil.getDropDownListValue(connection,
					"PILM007", "PM_IL_CLM_WAIT_PERIOD",
					"PM_IL_CLM_WAIT_PERIOD.CWP_APPLIED_ON","IL_CWP_APPL");
		} catch (DBException e) {

			e.printStackTrace();
		}

	}
	public String callPM_IL_CLM_REPAY() {
		setBlockFlag(true);
		return "PILM007_PM_IL_CLM_REPAY";

	}
	
	
	public void CWP_FM_DAYS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CWP_FM_DAYS_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_WAIT_PERIOD_BEAN().setCWP_FM_DAYS((Integer)value);
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
	
	public void CWP_TO_DAYS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CWP_TO_DAYS_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_WAIT_PERIOD_BEAN().setCWP_TO_DAYS((Integer)value);
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
	
	public void CWP_RATE_PER_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CWP_RATE_PER_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_WAIT_PERIOD_BEAN().setCWP_RATE_PER((Double)value);
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


}
