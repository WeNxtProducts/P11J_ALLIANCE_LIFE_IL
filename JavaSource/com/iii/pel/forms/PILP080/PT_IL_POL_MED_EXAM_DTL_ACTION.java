package com.iii.pel.forms.PILP080;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_MED_EXAM_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMED_EXAM_CODE_LABEL;

	private HtmlInputText COMP_PMED_EXAM_CODE;

	private HtmlOutputLabel COMP_PMED_EXAM_DT_LABEL;

	private HtmlCalendar COMP_PMED_EXAM_DT;

	private HtmlOutputLabel COMP_PMED_INVOICE_NO_LABEL;

	private HtmlInputText COMP_PMED_INVOICE_NO;

	private HtmlOutputLabel COMP_PMED_FLEX_03_LABEL;

	private HtmlInputText COMP_PMED_FLEX_03;

	private HtmlOutputLabel COMP_PMED_MEDICAL_FEES_LABEL;

	private HtmlInputText COMP_PMED_MEDICAL_FEES;

	private HtmlOutputLabel COMP_PMED_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_PMED_STATUS;

	private HtmlOutputLabel COMP_UI_M_TOT_TDS_FEES_LABEL;

	private HtmlInputText COMP_UI_M_TOT_TDS_FEES;

	private HtmlOutputLabel COMP_UI_M_TOT_MEDICAL_FEES_LABEL;

	private HtmlInputText COMP_UI_M_TOT_MEDICAL_FEES;

	private PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_MED_EXAM_DTL_HELPER helper;

	private List<PT_IL_POL_MED_EXAM_DTL> dataList_PT_IL_POL_MED_EXAM_DTL = new ArrayList<PT_IL_POL_MED_EXAM_DTL>();

	private UIData dataTable;

	private List<SelectItem> listPMED_STATUS = new ArrayList<SelectItem>();

	public PT_IL_POL_MED_EXAM_DTL_ACTION() {

		PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
		helper = new PT_IL_POL_MED_EXAM_DTL_HELPER();
		preparDropDownList();
	}

	public HtmlOutputLabel getCOMP_PMED_EXAM_CODE_LABEL() {
		return COMP_PMED_EXAM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PMED_EXAM_CODE() {
		return COMP_PMED_EXAM_CODE;
	}

	public void setCOMP_PMED_EXAM_CODE_LABEL(
			HtmlOutputLabel COMP_PMED_EXAM_CODE_LABEL) {
		this.COMP_PMED_EXAM_CODE_LABEL = COMP_PMED_EXAM_CODE_LABEL;
	}

	public void setCOMP_PMED_EXAM_CODE(HtmlInputText COMP_PMED_EXAM_CODE) {
		this.COMP_PMED_EXAM_CODE = COMP_PMED_EXAM_CODE;
	}

	public HtmlOutputLabel getCOMP_PMED_EXAM_DT_LABEL() {
		return COMP_PMED_EXAM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMED_EXAM_DT() {
		return COMP_PMED_EXAM_DT;
	}

	public void setCOMP_PMED_EXAM_DT_LABEL(
			HtmlOutputLabel COMP_PMED_EXAM_DT_LABEL) {
		this.COMP_PMED_EXAM_DT_LABEL = COMP_PMED_EXAM_DT_LABEL;
	}

	public void setCOMP_PMED_EXAM_DT(HtmlCalendar COMP_PMED_EXAM_DT) {
		this.COMP_PMED_EXAM_DT = COMP_PMED_EXAM_DT;
	}

	public HtmlOutputLabel getCOMP_PMED_INVOICE_NO_LABEL() {
		return COMP_PMED_INVOICE_NO_LABEL;
	}

	public HtmlInputText getCOMP_PMED_INVOICE_NO() {
		return COMP_PMED_INVOICE_NO;
	}

	public void setCOMP_PMED_INVOICE_NO_LABEL(
			HtmlOutputLabel COMP_PMED_INVOICE_NO_LABEL) {
		this.COMP_PMED_INVOICE_NO_LABEL = COMP_PMED_INVOICE_NO_LABEL;
	}

	public void setCOMP_PMED_INVOICE_NO(HtmlInputText COMP_PMED_INVOICE_NO) {
		this.COMP_PMED_INVOICE_NO = COMP_PMED_INVOICE_NO;
	}

	public HtmlOutputLabel getCOMP_PMED_FLEX_03_LABEL() {
		return COMP_PMED_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_PMED_FLEX_03() {
		return COMP_PMED_FLEX_03;
	}

	public void setCOMP_PMED_FLEX_03_LABEL(
			HtmlOutputLabel COMP_PMED_FLEX_03_LABEL) {
		this.COMP_PMED_FLEX_03_LABEL = COMP_PMED_FLEX_03_LABEL;
	}

	public void setCOMP_PMED_FLEX_03(HtmlInputText COMP_PMED_FLEX_03) {
		this.COMP_PMED_FLEX_03 = COMP_PMED_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PMED_MEDICAL_FEES_LABEL() {
		return COMP_PMED_MEDICAL_FEES_LABEL;
	}

	public HtmlInputText getCOMP_PMED_MEDICAL_FEES() {
		return COMP_PMED_MEDICAL_FEES;
	}

	public void setCOMP_PMED_MEDICAL_FEES_LABEL(
			HtmlOutputLabel COMP_PMED_MEDICAL_FEES_LABEL) {
		this.COMP_PMED_MEDICAL_FEES_LABEL = COMP_PMED_MEDICAL_FEES_LABEL;
	}

	public void setCOMP_PMED_MEDICAL_FEES(HtmlInputText COMP_PMED_MEDICAL_FEES) {
		this.COMP_PMED_MEDICAL_FEES = COMP_PMED_MEDICAL_FEES;
	}

	public HtmlOutputLabel getCOMP_PMED_STATUS_LABEL() {
		return COMP_PMED_STATUS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PMED_STATUS() {
		return COMP_PMED_STATUS;
	}

	public void setCOMP_PMED_STATUS_LABEL(HtmlOutputLabel COMP_PMED_STATUS_LABEL) {
		this.COMP_PMED_STATUS_LABEL = COMP_PMED_STATUS_LABEL;
	}

	public void setCOMP_PMED_STATUS(HtmlSelectOneMenu COMP_PMED_STATUS) {
		this.COMP_PMED_STATUS = COMP_PMED_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_TDS_FEES_LABEL() {
		return COMP_UI_M_TOT_TDS_FEES_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_TDS_FEES() {
		return COMP_UI_M_TOT_TDS_FEES;
	}

	public void setCOMP_UI_M_TOT_TDS_FEES_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_TDS_FEES_LABEL) {
		this.COMP_UI_M_TOT_TDS_FEES_LABEL = COMP_UI_M_TOT_TDS_FEES_LABEL;
	}

	public void setCOMP_UI_M_TOT_TDS_FEES(HtmlInputText COMP_UI_M_TOT_TDS_FEES) {
		this.COMP_UI_M_TOT_TDS_FEES = COMP_UI_M_TOT_TDS_FEES;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_MEDICAL_FEES_LABEL() {
		return COMP_UI_M_TOT_MEDICAL_FEES_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_MEDICAL_FEES() {
		return COMP_UI_M_TOT_MEDICAL_FEES;
	}

	public void setCOMP_UI_M_TOT_MEDICAL_FEES_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_MEDICAL_FEES_LABEL) {
		this.COMP_UI_M_TOT_MEDICAL_FEES_LABEL = COMP_UI_M_TOT_MEDICAL_FEES_LABEL;
	}

	public void setCOMP_UI_M_TOT_MEDICAL_FEES(
			HtmlInputText COMP_UI_M_TOT_MEDICAL_FEES) {
		this.COMP_UI_M_TOT_MEDICAL_FEES = COMP_UI_M_TOT_MEDICAL_FEES;
	}

	public PT_IL_POL_MED_EXAM_DTL getPT_IL_POL_MED_EXAM_DTL_BEAN() {
		return PT_IL_POL_MED_EXAM_DTL_BEAN;
	}

	public void setPT_IL_POL_MED_EXAM_DTL_BEAN(
			PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN) {
		this.PT_IL_POL_MED_EXAM_DTL_BEAN = PT_IL_POL_MED_EXAM_DTL_BEAN;
	}

	public List<PT_IL_POL_MED_EXAM_DTL> getDataList_PT_IL_POL_MED_EXAM_DTL() {
		return dataList_PT_IL_POL_MED_EXAM_DTL;
	}

	public void setDataListPT_IL_POL_MED_EXAM_DTL(
			List<PT_IL_POL_MED_EXAM_DTL> dataList_PT_IL_POL_MED_EXAM_DTL) {
		this.dataList_PT_IL_POL_MED_EXAM_DTL = dataList_PT_IL_POL_MED_EXAM_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
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

				new CRUDHandler().executeDelete(PT_IL_POL_MED_EXAM_DTL_BEAN,
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
				dataList_PT_IL_POL_MED_EXAM_DTL
						.remove(PT_IL_POL_MED_EXAM_DTL_BEAN);
				if (dataList_PT_IL_POL_MED_EXAM_DTL.size() > 0) {

					PT_IL_POL_MED_EXAM_DTL_BEAN = dataList_PT_IL_POL_MED_EXAM_DTL
							.get(0);
				} else if (dataList_PT_IL_POL_MED_EXAM_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
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
			if (PT_IL_POL_MED_EXAM_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_POL_MED_EXAM_DTL_BEAN,
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
				dataList_PT_IL_POL_MED_EXAM_DTL
						.add(PT_IL_POL_MED_EXAM_DTL_BEAN);
			} else if (PT_IL_POL_MED_EXAM_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_POL_MED_EXAM_DTL_BEAN,
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

			PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
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
			PT_IL_POL_MED_EXAM_DTL_BEAN = (PT_IL_POL_MED_EXAM_DTL) dataTable
					.getRowData();
			PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_MED_EXAM_DTL> PT_IL_POL_MED_EXAM_DTL_ITR = dataList_PT_IL_POL_MED_EXAM_DTL
				.iterator();
		while (PT_IL_POL_MED_EXAM_DTL_ITR.hasNext()) {
			PT_IL_POL_MED_EXAM_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PMED_EXAM_CODE.resetValue();
		COMP_PMED_EXAM_DT.resetValue();
		COMP_PMED_INVOICE_NO.resetValue();
		COMP_PMED_FLEX_03.resetValue();
		COMP_PMED_MEDICAL_FEES.resetValue();
		COMP_PMED_STATUS.resetValue();
		COMP_UI_M_TOT_TDS_FEES.resetValue();
		COMP_UI_M_TOT_MEDICAL_FEES.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_POL_MED_EXAM_DTL_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					//helper.PRE_UPDATE(compositeAction);
				}
				new CRUDHandler().executeUpdate(getPT_IL_POL_MED_EXAM_DTL_BEAN(), CommonUtils.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
				String message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update");
			} else {
				//helper.pre_insert(compositeAction);
				new CRUDHandler().executeInsert(getPT_IL_POL_MED_EXAM_DTL_BEAN(), CommonUtils.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				String message = Messages.getString("messageProperties",
				"errorPanel$message$save");
			}
			CommonUtils.getConnection().commit();
		
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPMED_STATUS() {
		if (listPMED_STATUS.size() == 0) {
			listPMED_STATUS.clear();
			try {
				listPMED_STATUS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPMED_STATUS;
	}

	public void setListPMED_STATUS(List<SelectItem> listPMED_STATUS) {
		this.listPMED_STATUS = listPMED_STATUS;
	}

	public void preparDropDownList() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			listPMED_STATUS = ListItemUtil.getDropDownListValue(connection,
					"PILP080", "PT_IL_POL_MED_EXAM_DTL",
					"PT_IL_POL_MED_EXAM_DTL.PMED_STATUS", "YESNO");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}

	}

	public String back(){
		return "PILP080_PT_IL_PV_MED_HDR";
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