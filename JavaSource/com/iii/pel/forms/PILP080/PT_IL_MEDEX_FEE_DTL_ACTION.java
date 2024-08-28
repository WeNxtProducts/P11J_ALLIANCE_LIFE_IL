package com.iii.pel.forms.PILP080;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_MEDEX_FEE_DTL_ACTION extends CommonAction {

	private PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private PT_IL_MEDEX_FEE_DTL_HELPER helper;

	private List<PT_IL_MEDEX_FEE_DTL> dataList_PT_IL_MEDEX_FEE_DTL = new ArrayList<PT_IL_MEDEX_FEE_DTL>();

	private UIData dataTable;

	public PT_IL_MEDEX_FEE_DTL_ACTION() {

		PT_IL_MEDEX_FEE_DTL_BEAN = new PT_IL_MEDEX_FEE_DTL();
		helper = new PT_IL_MEDEX_FEE_DTL_HELPER();
	}

	public PT_IL_MEDEX_FEE_DTL getPT_IL_MEDEX_FEE_DTL_BEAN() {
		return PT_IL_MEDEX_FEE_DTL_BEAN;
	}

	public void setPT_IL_MEDEX_FEE_DTL_BEAN(
			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN) {
		this.PT_IL_MEDEX_FEE_DTL_BEAN = PT_IL_MEDEX_FEE_DTL_BEAN;
	}

	public List<PT_IL_MEDEX_FEE_DTL> getDataList_PT_IL_MEDEX_FEE_DTL() {
		return dataList_PT_IL_MEDEX_FEE_DTL;
	}

	public void setDataListPT_IL_MEDEX_FEE_DTL(
			List<PT_IL_MEDEX_FEE_DTL> dataList_PT_IL_MEDEX_FEE_DTL) {
		this.dataList_PT_IL_MEDEX_FEE_DTL = dataList_PT_IL_MEDEX_FEE_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_MEDEX_FEE_DTL_BEAN = new PT_IL_MEDEX_FEE_DTL();
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

				new CRUDHandler().executeDelete(PT_IL_MEDEX_FEE_DTL_BEAN,
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
				dataList_PT_IL_MEDEX_FEE_DTL.remove(PT_IL_MEDEX_FEE_DTL_BEAN);
				if (dataList_PT_IL_MEDEX_FEE_DTL.size() > 0) {

					PT_IL_MEDEX_FEE_DTL_BEAN = dataList_PT_IL_MEDEX_FEE_DTL
							.get(0);
				} else if (dataList_PT_IL_MEDEX_FEE_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
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
			if (PT_IL_MEDEX_FEE_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_MEDEX_FEE_DTL_BEAN,
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
				dataList_PT_IL_MEDEX_FEE_DTL.add(PT_IL_MEDEX_FEE_DTL_BEAN);
			} else if (PT_IL_MEDEX_FEE_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_MEDEX_FEE_DTL_BEAN,
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

			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
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
			PT_IL_MEDEX_FEE_DTL_BEAN = (PT_IL_MEDEX_FEE_DTL) dataTable
					.getRowData();
			PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_MEDEX_FEE_DTL> PT_IL_MEDEX_FEE_DTL_ITR = dataList_PT_IL_MEDEX_FEE_DTL
				.iterator();
		while (PT_IL_MEDEX_FEE_DTL_ITR.hasNext()) {
			PT_IL_MEDEX_FEE_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
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