package com.iii.pel.forms.PILP004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
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
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PROCESS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_PR_ERROR_DESC_LABEL;

	private HtmlInputText COMP_PR_ERROR_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_EM_OK;

	private HtmlCommandButton COMP_UI_M_BUT_EDIT;

	private PT_IL_PROCESS PT_IL_PROCESS_BEAN;

	public PILP004_COMPOSITE_ACTION compositeAction;

	private PT_IL_PROCESS_HELPER helper;

	private List<PT_IL_PROCESS> dataList_PT_IL_PROCESS = new ArrayList<PT_IL_PROCESS>();

	private UIData dataTable;

	public PT_IL_PROCESS_ACTION() {

		PT_IL_PROCESS_BEAN = new PT_IL_PROCESS();
		helper = new PT_IL_PROCESS_HELPER();
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

	public HtmlOutputLabel getCOMP_PR_ERROR_DESC_LABEL() {
		return COMP_PR_ERROR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PR_ERROR_DESC() {
		return COMP_PR_ERROR_DESC;
	}

	public void setCOMP_PR_ERROR_DESC_LABEL(
			HtmlOutputLabel COMP_PR_ERROR_DESC_LABEL) {
		this.COMP_PR_ERROR_DESC_LABEL = COMP_PR_ERROR_DESC_LABEL;
	}

	public void setCOMP_PR_ERROR_DESC(HtmlInputText COMP_PR_ERROR_DESC) {
		this.COMP_PR_ERROR_DESC = COMP_PR_ERROR_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EM_OK() {
		return COMP_UI_M_BUT_EM_OK;
	}

	public void setCOMP_UI_M_BUT_EM_OK(HtmlCommandButton COMP_UI_M_BUT_EM_OK) {
		this.COMP_UI_M_BUT_EM_OK = COMP_UI_M_BUT_EM_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDIT() {
		return COMP_UI_M_BUT_EDIT;
	}

	public void setCOMP_UI_M_BUT_EDIT(HtmlCommandButton COMP_UI_M_BUT_EDIT) {
		this.COMP_UI_M_BUT_EDIT = COMP_UI_M_BUT_EDIT;
	}

	public PT_IL_PROCESS getPT_IL_PROCESS_BEAN() {
		return PT_IL_PROCESS_BEAN;
	}

	public void setPT_IL_PROCESS_BEAN(PT_IL_PROCESS PT_IL_PROCESS_BEAN) {
		this.PT_IL_PROCESS_BEAN = PT_IL_PROCESS_BEAN;
	}

	public List<PT_IL_PROCESS> getDataList_PT_IL_PROCESS() {
		return dataList_PT_IL_PROCESS;
	}

	public void setDataListPT_IL_PROCESS(
			List<PT_IL_PROCESS> dataList_PT_IL_PROCESS) {
		this.dataList_PT_IL_PROCESS = dataList_PT_IL_PROCESS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PROCESS_BEAN = new PT_IL_PROCESS();
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

				new CRUDHandler().executeDelete(PT_IL_PROCESS_BEAN, CommonUtils
						.getConnection());
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
				dataList_PT_IL_PROCESS.remove(PT_IL_PROCESS_BEAN);
				if (dataList_PT_IL_PROCESS.size() > 0) {

					PT_IL_PROCESS_BEAN = dataList_PT_IL_PROCESS.get(0);
				} else if (dataList_PT_IL_PROCESS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_PROCESS_BEAN.setRowSelected(true);
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
			if (PT_IL_PROCESS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_PROCESS_BEAN, CommonUtils
						.getConnection());
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
				dataList_PT_IL_PROCESS.add(PT_IL_PROCESS_BEAN);
			} else if (PT_IL_PROCESS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_PROCESS_BEAN, CommonUtils
						.getConnection());
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
			resetAllComponent();
			resetSelectedRow();
			PT_IL_PROCESS_BEAN.setRowSelected(true);
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
			PT_IL_PROCESS_BEAN = (PT_IL_PROCESS) dataTable.getRowData();
			PT_IL_PROCESS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PROCESS> PT_IL_PROCESS_ITR = dataList_PT_IL_PROCESS
				.iterator();
		while (PT_IL_PROCESS_ITR.hasNext()) {
			PT_IL_PROCESS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_UI_M_POL_NO.resetValue();
		COMP_PR_ERROR_DESC.resetValue();
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
			getErrorMap().put(
					"SAVE RECORD",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (PT_IL_PROCESS_BEAN.getROWID() != null) {
					helper.postQuery(PT_IL_PROCESS_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String back(){
		return "PILP004_MATURITY";
	}

}
