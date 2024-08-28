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
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_TOPUP_PARAM_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PTP_MODE_OF_PYMT_LABEL;

	private HtmlSelectOneMenu COMP_PTP_MODE_OF_PYMT;

	private HtmlOutputLabel COMP_PTP_LC_MIN_AMT_LABEL;

	private HtmlInputText COMP_PTP_LC_MIN_AMT;

	private HtmlOutputLabel COMP_PTP_LC_MAX_AMT_LABEL;

	private HtmlInputText COMP_PTP_LC_MAX_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN2;

	private PM_IL_PROD_TOPUP_PARAM PM_IL_PROD_TOPUP_PARAM_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_TOPUP_PARAM_HELPER helper;

	private List<PM_IL_PROD_TOPUP_PARAM> dataList_PM_IL_PROD_TOPUP_PARAM = new ArrayList<PM_IL_PROD_TOPUP_PARAM>();

	private UIData dataTable;

	private List<SelectItem> listPTP_MODE_OF_PYMT = new ArrayList<SelectItem>();

	public PM_IL_PROD_TOPUP_PARAM_ACTION() {

		PM_IL_PROD_TOPUP_PARAM_BEAN = new PM_IL_PROD_TOPUP_PARAM();
		helper = new PM_IL_PROD_TOPUP_PARAM_HELPER();
		prepareDropDownList();
	}

	public HtmlOutputLabel getCOMP_PTP_MODE_OF_PYMT_LABEL() {
		return COMP_PTP_MODE_OF_PYMT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PTP_MODE_OF_PYMT() {
		return COMP_PTP_MODE_OF_PYMT;
	}

	public void setCOMP_PTP_MODE_OF_PYMT_LABEL(
			HtmlOutputLabel COMP_PTP_MODE_OF_PYMT_LABEL) {
		this.COMP_PTP_MODE_OF_PYMT_LABEL = COMP_PTP_MODE_OF_PYMT_LABEL;
	}

	public void setCOMP_PTP_MODE_OF_PYMT(HtmlSelectOneMenu COMP_PTP_MODE_OF_PYMT) {
		this.COMP_PTP_MODE_OF_PYMT = COMP_PTP_MODE_OF_PYMT;
	}

	public HtmlOutputLabel getCOMP_PTP_LC_MIN_AMT_LABEL() {
		return COMP_PTP_LC_MIN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PTP_LC_MIN_AMT() {
		return COMP_PTP_LC_MIN_AMT;
	}

	public void setCOMP_PTP_LC_MIN_AMT_LABEL(
			HtmlOutputLabel COMP_PTP_LC_MIN_AMT_LABEL) {
		this.COMP_PTP_LC_MIN_AMT_LABEL = COMP_PTP_LC_MIN_AMT_LABEL;
	}

	public void setCOMP_PTP_LC_MIN_AMT(HtmlInputText COMP_PTP_LC_MIN_AMT) {
		this.COMP_PTP_LC_MIN_AMT = COMP_PTP_LC_MIN_AMT;
	}

	public HtmlOutputLabel getCOMP_PTP_LC_MAX_AMT_LABEL() {
		return COMP_PTP_LC_MAX_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PTP_LC_MAX_AMT() {
		return COMP_PTP_LC_MAX_AMT;
	}

	public void setCOMP_PTP_LC_MAX_AMT_LABEL(
			HtmlOutputLabel COMP_PTP_LC_MAX_AMT_LABEL) {
		this.COMP_PTP_LC_MAX_AMT_LABEL = COMP_PTP_LC_MAX_AMT_LABEL;
	}

	public void setCOMP_PTP_LC_MAX_AMT(HtmlInputText COMP_PTP_LC_MAX_AMT) {
		this.COMP_PTP_LC_MAX_AMT = COMP_PTP_LC_MAX_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN2() {
		return COMP_UI_M_BUT_MAIN2;
	}

	public void setCOMP_UI_M_BUT_MAIN2(HtmlCommandButton COMP_UI_M_BUT_MAIN2) {
		this.COMP_UI_M_BUT_MAIN2 = COMP_UI_M_BUT_MAIN2;
	}

	public PM_IL_PROD_TOPUP_PARAM getPM_IL_PROD_TOPUP_PARAM_BEAN() {
		return PM_IL_PROD_TOPUP_PARAM_BEAN;
	}

	public void setPM_IL_PROD_TOPUP_PARAM_BEAN(
			PM_IL_PROD_TOPUP_PARAM PM_IL_PROD_TOPUP_PARAM_BEAN) {
		this.PM_IL_PROD_TOPUP_PARAM_BEAN = PM_IL_PROD_TOPUP_PARAM_BEAN;
	}

	public List<PM_IL_PROD_TOPUP_PARAM> getDataList_PM_IL_PROD_TOPUP_PARAM() {
		return dataList_PM_IL_PROD_TOPUP_PARAM;
	}

	public void setDataListPM_IL_PROD_TOPUP_PARAM(
			List<PM_IL_PROD_TOPUP_PARAM> dataList_PM_IL_PROD_TOPUP_PARAM) {
		this.dataList_PM_IL_PROD_TOPUP_PARAM = dataList_PM_IL_PROD_TOPUP_PARAM;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_TOPUP_PARAM_BEAN = new PM_IL_PROD_TOPUP_PARAM();
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

	public String mainAction() {

		return "PILM035_APAC_PM_IL_PRODUCT";

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_TOPUP_PARAM_BEAN,
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
				dataList_PM_IL_PROD_TOPUP_PARAM
						.remove(PM_IL_PROD_TOPUP_PARAM_BEAN);
				if (dataList_PM_IL_PROD_TOPUP_PARAM.size() > 0) {

					PM_IL_PROD_TOPUP_PARAM_BEAN = dataList_PM_IL_PROD_TOPUP_PARAM
							.get(0);
				} else if (dataList_PM_IL_PROD_TOPUP_PARAM.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_TOPUP_PARAM_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_TOPUP_PARAM_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_TOPUP_PARAM_BEAN,
						CommonUtils.getConnection());
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
				dataList_PM_IL_PROD_TOPUP_PARAM
						.add(PM_IL_PROD_TOPUP_PARAM_BEAN);
			} else if (PM_IL_PROD_TOPUP_PARAM_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_TOPUP_PARAM_BEAN,
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

			PM_IL_PROD_TOPUP_PARAM_BEAN.setRowSelected(true);
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
			PM_IL_PROD_TOPUP_PARAM_BEAN = (PM_IL_PROD_TOPUP_PARAM) dataTable
					.getRowData();
			PM_IL_PROD_TOPUP_PARAM_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_TOPUP_PARAM> PM_IL_PROD_TOPUP_PARAM_ITR = dataList_PM_IL_PROD_TOPUP_PARAM
				.iterator();
		while (PM_IL_PROD_TOPUP_PARAM_ITR.hasNext()) {
			PM_IL_PROD_TOPUP_PARAM_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PTP_MODE_OF_PYMT.resetValue();
		COMP_PTP_LC_MIN_AMT.resetValue();
		COMP_PTP_LC_MAX_AMT.resetValue();
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

	public List<SelectItem> getListPTP_MODE_OF_PYMT() {
		if (listPTP_MODE_OF_PYMT.size() == 0) {
			listPTP_MODE_OF_PYMT.clear();
			try {
				listPTP_MODE_OF_PYMT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPTP_MODE_OF_PYMT;
	}

	public void setListPTP_MODE_OF_PYMT(List<SelectItem> listPTP_MODE_OF_PYMT) {
		this.listPTP_MODE_OF_PYMT = listPTP_MODE_OF_PYMT;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void prepareDropDownList() {
		try {
			setListPTP_MODE_OF_PYMT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_TOPUP_PARAM",
					"PM_IL_PROD_TOPUP_PARAM.PTP_MODE_OF_PYMT", "PAYMODE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PTP_LC_MIN_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_TOPUP_PARAM_BEAN().setPTP_LC_MIN_AMT((Double) value);
			helper.PTP_LC_MIN_AMT_WHEN_VALIDATE_ITEM(compositeAction);
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

	public void PTP_LC_MAX_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_TOPUP_PARAM_BEAN().setPTP_LC_MAX_AMT((Double) value);
			helper.PTP_LC_MAX_AMT_WHEN_VALIDATE_ITEM(compositeAction);
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

}
