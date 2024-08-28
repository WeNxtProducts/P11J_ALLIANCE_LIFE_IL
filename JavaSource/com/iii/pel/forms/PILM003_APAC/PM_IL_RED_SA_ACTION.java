package com.iii.pel.forms.PILM003_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
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

public class PM_IL_RED_SA_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RSA_YEAR_FROM_LABEL;

	private HtmlInputText COMP_RSA_YEAR_FROM;

	private HtmlOutputLabel COMP_RSA_YEAR_TO_LABEL;

	private HtmlInputText COMP_RSA_YEAR_TO;

	private HtmlOutputLabel COMP_RSA_PERIOD_FROM_LABEL;

	private HtmlInputText COMP_RSA_PERIOD_FROM;

	private HtmlOutputLabel COMP_RSA_PERIOD_TO_LABEL;

	private HtmlInputText COMP_RSA_PERIOD_TO;

	private HtmlOutputLabel COMP_RSA_RI_RATE_LABEL;

	private HtmlInputText COMP_RSA_RI_RATE;

	private HtmlOutputLabel COMP_RSA_CQS_RATE_LABEL;

	private HtmlInputText COMP_RSA_CQS_RATE;

	private HtmlOutputLabel COMP_RSA_RATE_PER_LABEL;

	private HtmlInputText COMP_RSA_RATE_PER;

	private PM_IL_RED_SA PM_IL_RED_SA_BEAN;

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_RED_SA_HELPER helper;

	private List<PM_IL_RED_SA> dataList_PM_IL_RED_SA = new ArrayList<PM_IL_RED_SA>();

	private UIData dataTable;

	public PM_IL_RED_SA_ACTION() {

		PM_IL_RED_SA_BEAN = new PM_IL_RED_SA();
		helper = new PM_IL_RED_SA_HELPER();
	}

	public HtmlOutputLabel getCOMP_RSA_YEAR_FROM_LABEL() {
		return COMP_RSA_YEAR_FROM_LABEL;
	}

	public HtmlInputText getCOMP_RSA_YEAR_FROM() {
		return COMP_RSA_YEAR_FROM;
	}

	public void setCOMP_RSA_YEAR_FROM_LABEL(
			HtmlOutputLabel COMP_RSA_YEAR_FROM_LABEL) {
		this.COMP_RSA_YEAR_FROM_LABEL = COMP_RSA_YEAR_FROM_LABEL;
	}

	public void setCOMP_RSA_YEAR_FROM(HtmlInputText COMP_RSA_YEAR_FROM) {
		this.COMP_RSA_YEAR_FROM = COMP_RSA_YEAR_FROM;
	}

	public HtmlOutputLabel getCOMP_RSA_YEAR_TO_LABEL() {
		return COMP_RSA_YEAR_TO_LABEL;
	}

	public HtmlInputText getCOMP_RSA_YEAR_TO() {
		return COMP_RSA_YEAR_TO;
	}

	public void setCOMP_RSA_YEAR_TO_LABEL(HtmlOutputLabel COMP_RSA_YEAR_TO_LABEL) {
		this.COMP_RSA_YEAR_TO_LABEL = COMP_RSA_YEAR_TO_LABEL;
	}

	public void setCOMP_RSA_YEAR_TO(HtmlInputText COMP_RSA_YEAR_TO) {
		this.COMP_RSA_YEAR_TO = COMP_RSA_YEAR_TO;
	}

	public HtmlOutputLabel getCOMP_RSA_PERIOD_FROM_LABEL() {
		return COMP_RSA_PERIOD_FROM_LABEL;
	}

	public HtmlInputText getCOMP_RSA_PERIOD_FROM() {
		return COMP_RSA_PERIOD_FROM;
	}

	public void setCOMP_RSA_PERIOD_FROM_LABEL(
			HtmlOutputLabel COMP_RSA_PERIOD_FROM_LABEL) {
		this.COMP_RSA_PERIOD_FROM_LABEL = COMP_RSA_PERIOD_FROM_LABEL;
	}

	public void setCOMP_RSA_PERIOD_FROM(HtmlInputText COMP_RSA_PERIOD_FROM) {
		this.COMP_RSA_PERIOD_FROM = COMP_RSA_PERIOD_FROM;
	}

	public HtmlOutputLabel getCOMP_RSA_PERIOD_TO_LABEL() {
		return COMP_RSA_PERIOD_TO_LABEL;
	}

	public HtmlInputText getCOMP_RSA_PERIOD_TO() {
		return COMP_RSA_PERIOD_TO;
	}

	public void setCOMP_RSA_PERIOD_TO_LABEL(
			HtmlOutputLabel COMP_RSA_PERIOD_TO_LABEL) {
		this.COMP_RSA_PERIOD_TO_LABEL = COMP_RSA_PERIOD_TO_LABEL;
	}

	public void setCOMP_RSA_PERIOD_TO(HtmlInputText COMP_RSA_PERIOD_TO) {
		this.COMP_RSA_PERIOD_TO = COMP_RSA_PERIOD_TO;
	}

	public HtmlOutputLabel getCOMP_RSA_RI_RATE_LABEL() {
		return COMP_RSA_RI_RATE_LABEL;
	}

	public HtmlInputText getCOMP_RSA_RI_RATE() {
		return COMP_RSA_RI_RATE;
	}

	public void setCOMP_RSA_RI_RATE_LABEL(HtmlOutputLabel COMP_RSA_RI_RATE_LABEL) {
		this.COMP_RSA_RI_RATE_LABEL = COMP_RSA_RI_RATE_LABEL;
	}

	public void setCOMP_RSA_RI_RATE(HtmlInputText COMP_RSA_RI_RATE) {
		this.COMP_RSA_RI_RATE = COMP_RSA_RI_RATE;
	}

	public HtmlOutputLabel getCOMP_RSA_CQS_RATE_LABEL() {
		return COMP_RSA_CQS_RATE_LABEL;
	}

	public HtmlInputText getCOMP_RSA_CQS_RATE() {
		return COMP_RSA_CQS_RATE;
	}

	public void setCOMP_RSA_CQS_RATE_LABEL(
			HtmlOutputLabel COMP_RSA_CQS_RATE_LABEL) {
		this.COMP_RSA_CQS_RATE_LABEL = COMP_RSA_CQS_RATE_LABEL;
	}

	public void setCOMP_RSA_CQS_RATE(HtmlInputText COMP_RSA_CQS_RATE) {
		this.COMP_RSA_CQS_RATE = COMP_RSA_CQS_RATE;
	}

	public HtmlOutputLabel getCOMP_RSA_RATE_PER_LABEL() {
		return COMP_RSA_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_RSA_RATE_PER() {
		return COMP_RSA_RATE_PER;
	}

	public void setCOMP_RSA_RATE_PER_LABEL(
			HtmlOutputLabel COMP_RSA_RATE_PER_LABEL) {
		this.COMP_RSA_RATE_PER_LABEL = COMP_RSA_RATE_PER_LABEL;
	}

	public void setCOMP_RSA_RATE_PER(HtmlInputText COMP_RSA_RATE_PER) {
		this.COMP_RSA_RATE_PER = COMP_RSA_RATE_PER;
	}

	public PM_IL_RED_SA getPM_IL_RED_SA_BEAN() {
		return PM_IL_RED_SA_BEAN;
	}

	public void setPM_IL_RED_SA_BEAN(PM_IL_RED_SA PM_IL_RED_SA_BEAN) {
		this.PM_IL_RED_SA_BEAN = PM_IL_RED_SA_BEAN;
	}

	public List<PM_IL_RED_SA> getDataList_PM_IL_RED_SA() {
		return dataList_PM_IL_RED_SA;
	}

	public void setDataListPM_IL_RED_SA(List<PM_IL_RED_SA> dataList_PM_IL_RED_SA) {
		this.dataList_PM_IL_RED_SA = dataList_PM_IL_RED_SA;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_RED_SA_BEAN = new PM_IL_RED_SA();
				helper.WHEN_CREATE_RECORD(PM_IL_RED_SA_BEAN, compositeAction);
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
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

				new CRUDHandler().executeDelete(PM_IL_RED_SA_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				dataList_PM_IL_RED_SA.remove(PM_IL_RED_SA_BEAN);
				if (dataList_PM_IL_RED_SA.size() > 0) {

					PM_IL_RED_SA_BEAN = dataList_PM_IL_RED_SA.get(0);
				} else if (dataList_PM_IL_RED_SA.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_RED_SA_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
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
			if (PM_IL_RED_SA_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.PRE_INSERT(PM_IL_RED_SA_BEAN.getRSA_PLAN_CODE(),
						PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM(), 
						PM_IL_RED_SA_BEAN.getRSA_PERIOD_TO(), 
						PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM(), 
						PM_IL_RED_SA_BEAN.getRSA_YEAR_TO(), PM_IL_RED_SA_BEAN);
				helper.WHEN_VALIDATE_RECORD(PM_IL_RED_SA_BEAN.getRSA_PLAN_CODE(),
						PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM(), 
						PM_IL_RED_SA_BEAN.getRSA_YEAR_TO(), PM_IL_RED_SA_BEAN.getROWID(),
						PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM(), PM_IL_RED_SA_BEAN.getRSA_PERIOD_TO());
				new CRUDHandler().executeInsert(PM_IL_RED_SA_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
				dataList_PM_IL_RED_SA.add(PM_IL_RED_SA_BEAN);
			} else if (PM_IL_RED_SA_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(PM_IL_RED_SA_BEAN.getRSA_PLAN_CODE(),
						PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM()
						, PM_IL_RED_SA_BEAN.getRSA_PERIOD_TO(), 
						PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM(), 
						PM_IL_RED_SA_BEAN.getRSA_YEAR_TO(), PM_IL_RED_SA_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_RED_SA_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_RED_SA_BEAN.setRowSelected(true);
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
			PM_IL_RED_SA_BEAN = (PM_IL_RED_SA) dataTable.getRowData();
			
			PM_IL_RED_SA_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_RED_SA> PM_IL_RED_SA_ITR = dataList_PM_IL_RED_SA
				.iterator();
		while (PM_IL_RED_SA_ITR.hasNext()) {
			PM_IL_RED_SA_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_RSA_YEAR_FROM.resetValue();
		COMP_RSA_YEAR_TO.resetValue();
		COMP_RSA_PERIOD_FROM.resetValue();
		COMP_RSA_PERIOD_TO.resetValue();
		COMP_RSA_RI_RATE.resetValue();
		COMP_RSA_CQS_RATE.resetValue();
		COMP_RSA_RATE_PER.resetValue();
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
				helper.WHEN_NEW_BLOCK_INSTANCE(PM_IL_RED_SA_BEAN,compositeAction);
				helper.executeQuery(compositeAction);
				if(PM_IL_RED_SA_BEAN.getROWID() == null){
					helper.WHEN_CREATE_RECORD(PM_IL_RED_SA_BEAN, compositeAction);
				}
				helper.WHEN_NEW_RECORD_INSTANCE();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void validateRSA_YEAR_FROM(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_YEAR_FROM((Integer) value);
			helper.WHEN_VALIDATE_RSA_YEAR_FROM((Integer) value, PM_IL_RED_SA_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateRSA_YEAR_TO(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_YEAR_TO((Integer) value);
			helper.WHEN_VALIDATE_RSA_YEAR_TO((Integer)value, PM_IL_RED_SA_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateRSA_PERIOD_FROM(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_PERIOD_FROM((Integer) value);
			helper.WHEN_VALIDATE_RSA_PERIOD_FROM((Integer)value,
				PM_IL_RED_SA_BEAN, 
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN()
					.getPLAN_PERIOD_FROM());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateRSA_PERIOD_TO(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_PERIOD_TO((Integer) value);
			helper.WHEN_VALIDATE_RSA_PERIOD_TO(
					(Integer) value, 
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN()
					.getPLAN_PERIOD_FROM(), PM_IL_RED_SA_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateRSA_RI_RATE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_RI_RATE((Double) value);
			helper.WHEN_VALIDATE_RSA_RI_RATE((Double) value,
				PM_IL_RED_SA_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateRSA_CQS_RATE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_CQS_RATE((Double) value);
			helper.WHEN_VALIDATE_RSA_CQS_RATE((Double) value,
				PM_IL_RED_SA_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateRSA_RATE_PER(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_RED_SA_BEAN.setRSA_RATE_PER((Integer) value);
			helper.WHEN_VALIDATE_RSA_RATE_PER(PM_IL_RED_SA_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
