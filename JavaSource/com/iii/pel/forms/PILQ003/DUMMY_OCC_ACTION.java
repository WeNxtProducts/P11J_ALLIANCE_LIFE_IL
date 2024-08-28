package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
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

public class DUMMY_OCC_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_OCC_CLASS_LABEL;

	private HtmlInputText COMP_OCC_CLASS;

	

	private HtmlOutputLabel COMP_OCC_CODE_LABEL;

	private HtmlInputText COMP_OCC_CODE;

	
	private HtmlOutputLabel COMP_OCC_COV_RATE_LABEL;

	private HtmlInputText COMP_OCC_COV_RATE;

	

	private HtmlOutputLabel COMP_OCC_CHAR_RATE_LABEL;

	private HtmlInputText COMP_OCC_CHAR_RATE;
	

	

	private DUMMY_OCC DUMMY_OCC_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private DUMMY_OCC_HELPER helper;

	private List<DUMMY_OCC> dataList_DUMMY_OCC = new ArrayList<DUMMY_OCC>();

	private UIData dataTable;

	public DUMMY_OCC_ACTION() {

		DUMMY_OCC_BEAN = new DUMMY_OCC();
		helper = new DUMMY_OCC_HELPER();
	}

	
	public DUMMY_OCC getDUMMY_OCC_BEAN() {
		return DUMMY_OCC_BEAN;
	}

	public void setDUMMY_OCC_BEAN(DUMMY_OCC DUMMY_OCC_BEAN) {
		this.DUMMY_OCC_BEAN = DUMMY_OCC_BEAN;
	}

	public List<DUMMY_OCC> getDataList_DUMMY_OCC() {
		return dataList_DUMMY_OCC;
	}

	public void setDataListDUMMY_OCC(List<DUMMY_OCC> dataList_DUMMY_OCC) {
		this.dataList_DUMMY_OCC = dataList_DUMMY_OCC;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				DUMMY_OCC_BEAN = new DUMMY_OCC();
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

				new CRUDHandler().executeDelete(DUMMY_OCC_BEAN, CommonUtils
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
				dataList_DUMMY_OCC.remove(DUMMY_OCC_BEAN);
				if (dataList_DUMMY_OCC.size() > 0) {

					DUMMY_OCC_BEAN = dataList_DUMMY_OCC.get(0);
				} else if (dataList_DUMMY_OCC.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				DUMMY_OCC_BEAN.setRowSelected(true);
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
			if (DUMMY_OCC_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(DUMMY_OCC_BEAN, CommonUtils
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
				dataList_DUMMY_OCC.add(DUMMY_OCC_BEAN);
			} else if (DUMMY_OCC_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(DUMMY_OCC_BEAN, CommonUtils
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

			DUMMY_OCC_BEAN.setRowSelected(true);
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
			DUMMY_OCC_BEAN = (DUMMY_OCC) dataTable.getRowData();
			DUMMY_OCC_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<DUMMY_OCC> DUMMY_OCC_ITR = dataList_DUMMY_OCC.iterator();
		while (DUMMY_OCC_ITR.hasNext()) {
			DUMMY_OCC_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_OCC_CLASS.resetValue();
		COMP_OCC_CLASS.resetValue();
		COMP_OCC_CODE.resetValue();
		COMP_OCC_CODE.resetValue();
		COMP_OCC_COV_RATE.resetValue();
		COMP_OCC_COV_RATE.resetValue();
		COMP_OCC_CHAR_RATE.resetValue();
		COMP_OCC_CHAR_RATE.resetValue();
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
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	public HtmlOutputLabel getCOMP_OCC_CLASS_LABEL() {
		return COMP_OCC_CLASS_LABEL;
	}


	public void setCOMP_OCC_CLASS_LABEL(HtmlOutputLabel comp_occ_class_label) {
		COMP_OCC_CLASS_LABEL = comp_occ_class_label;
	}


	public HtmlInputText getCOMP_OCC_CLASS() {
		return COMP_OCC_CLASS;
	}


	public void setCOMP_OCC_CLASS(HtmlInputText comp_occ_class) {
		COMP_OCC_CLASS = comp_occ_class;
	}


	public HtmlOutputLabel getCOMP_OCC_CODE_LABEL() {
		return COMP_OCC_CODE_LABEL;
	}


	public void setCOMP_OCC_CODE_LABEL(HtmlOutputLabel comp_occ_code_label) {
		COMP_OCC_CODE_LABEL = comp_occ_code_label;
	}


	public HtmlInputText getCOMP_OCC_CODE() {
		return COMP_OCC_CODE;
	}


	public void setCOMP_OCC_CODE(HtmlInputText comp_occ_code) {
		COMP_OCC_CODE = comp_occ_code;
	}


	public HtmlOutputLabel getCOMP_OCC_COV_RATE_LABEL() {
		return COMP_OCC_COV_RATE_LABEL;
	}


	public void setCOMP_OCC_COV_RATE_LABEL(HtmlOutputLabel comp_occ_cov_rate_label) {
		COMP_OCC_COV_RATE_LABEL = comp_occ_cov_rate_label;
	}


	public HtmlInputText getCOMP_OCC_COV_RATE() {
		return COMP_OCC_COV_RATE;
	}


	public void setCOMP_OCC_COV_RATE(HtmlInputText comp_occ_cov_rate) {
		COMP_OCC_COV_RATE = comp_occ_cov_rate;
	}


	public HtmlOutputLabel getCOMP_OCC_CHAR_RATE_LABEL() {
		return COMP_OCC_CHAR_RATE_LABEL;
	}


	public void setCOMP_OCC_CHAR_RATE_LABEL(HtmlOutputLabel comp_occ_char_rate_label) {
		COMP_OCC_CHAR_RATE_LABEL = comp_occ_char_rate_label;
	}


	public HtmlInputText getCOMP_OCC_CHAR_RATE() {
		return COMP_OCC_CHAR_RATE;
	}


	public void setCOMP_OCC_CHAR_RATE(HtmlInputText comp_occ_char_rate) {
		COMP_OCC_CHAR_RATE = comp_occ_char_rate;
	}


	public void setDataList_DUMMY_OCC(List<DUMMY_OCC> dataList_DUMMY_OCC) {
		this.dataList_DUMMY_OCC = dataList_DUMMY_OCC;
	}




}
