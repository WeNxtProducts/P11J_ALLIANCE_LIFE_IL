package com.iii.pel.forms.PILT006_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_STATUS_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CS_STATUS_CODE_LABEL;

	private HtmlInputText COMP_CS_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_CS_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CS_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_CS_REASON_CODE_LABEL;

	private HtmlInputText COMP_CS_REASON_CODE;

	private HtmlOutputLabel COMP_CS_STATUS_DT_LABEL;

	private HtmlCalendar COMP_CS_STATUS_DT;

	private HtmlOutputLabel COMP_CS_STATUS_UID_LABEL;

	private HtmlInputText COMP_CS_STATUS_UID;

	private HtmlOutputLabel COMP_CS_REMARKS_LABEL;

	private HtmlInputText COMP_CS_REMARKS;

	private PT_IL_CLAIM_STATUS_1 PT_IL_CLAIM_STATUS_1_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_STATUS_1_HELPER helper;

	private List<PT_IL_CLAIM_STATUS_1> dataList_PT_IL_CLAIM_STATUS_1 = new ArrayList<PT_IL_CLAIM_STATUS_1>();

	private UIData dataTable;

	public PT_IL_CLAIM_STATUS_1_ACTION() {

		PT_IL_CLAIM_STATUS_1_BEAN = new PT_IL_CLAIM_STATUS_1();
		helper = new PT_IL_CLAIM_STATUS_1_HELPER();
		instantiateAllComponent();
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_CLAIM_STATUS_1_BEAN = new PT_IL_CLAIM_STATUS_1();
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

				new CRUDHandler().executeDelete(PT_IL_CLAIM_STATUS_1_BEAN,
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
				dataList_PT_IL_CLAIM_STATUS_1.remove(PT_IL_CLAIM_STATUS_1_BEAN);
				if (dataList_PT_IL_CLAIM_STATUS_1.size() > 0) {

					PT_IL_CLAIM_STATUS_1_BEAN = dataList_PT_IL_CLAIM_STATUS_1
							.get(0);
				} else if (dataList_PT_IL_CLAIM_STATUS_1.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_CLAIM_STATUS_1_BEAN.setRowSelected(true);
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
			if (PT_IL_CLAIM_STATUS_1_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_CLAIM_STATUS_1_BEAN,
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
				dataList_PT_IL_CLAIM_STATUS_1.add(PT_IL_CLAIM_STATUS_1_BEAN);
			} else if (PT_IL_CLAIM_STATUS_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_CLAIM_STATUS_1_BEAN,
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

			PT_IL_CLAIM_STATUS_1_BEAN.setRowSelected(true);
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
			PT_IL_CLAIM_STATUS_1_BEAN = (PT_IL_CLAIM_STATUS_1) dataTable.getRowData();
			PT_IL_CLAIM_STATUS_1_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_STATUS_1> PT_IL_CLAIM_STATUS_1_ITR = dataList_PT_IL_CLAIM_STATUS_1
				.iterator();
		while (PT_IL_CLAIM_STATUS_1_ITR.hasNext()) {
			PT_IL_CLAIM_STATUS_1_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CS_STATUS_CODE.resetValue();
		COMP_UI_M_CS_STATUS_CODE_DESC.resetValue();
		COMP_CS_REASON_CODE.resetValue();
		COMP_CS_STATUS_DT.resetValue();
		COMP_CS_STATUS_UID.resetValue();
		COMP_CS_REMARKS.resetValue();
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
		PT_IL_CLAIM_STATUS_1_DELEGATE delegate = new PT_IL_CLAIM_STATUS_1_DELEGATE();
		
		try {
			if (isBlockFlag()) {
				delegate.whenNewBlockInstance(this);
				delegate.preQuery(this);
				helper.executeQuery(compositeAction);
				delegate.postQuery(this);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	

	/**
	 * Disables all components in PT_IL_CLAIM_STATUS_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CS_STATUS_CODE.setDisabled(disabled);
		COMP_UI_M_CS_STATUS_CODE_DESC.setDisabled(disabled);
		COMP_CS_REASON_CODE.setDisabled(disabled);
		COMP_CS_STATUS_UID.setDisabled(disabled);
		COMP_CS_REMARKS.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CS_STATUS_DT.setDisabled(disabled);

	}
	

	/**
	 * Instantiates all components in PT_IL_CLAIM_STATUS_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CS_STATUS_CODE				 = new HtmlInputText();
		COMP_UI_M_CS_STATUS_CODE_DESC			 = new HtmlInputText();
		COMP_CS_REASON_CODE				 = new HtmlInputText();
		COMP_CS_STATUS_UID				 = new HtmlInputText();
		COMP_CS_REMARKS					 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_CS_STATUS_DT				 = new HtmlCalendar();

	}





	public HtmlOutputLabel getCOMP_CS_STATUS_CODE_LABEL() {
		return COMP_CS_STATUS_CODE_LABEL;
	}

	public void setCOMP_CS_STATUS_CODE_LABEL(
			HtmlOutputLabel comp_cs_status_code_label) {
		COMP_CS_STATUS_CODE_LABEL = comp_cs_status_code_label;
	}

	public HtmlInputText getCOMP_CS_STATUS_CODE() {
		return COMP_CS_STATUS_CODE;
	}

	public void setCOMP_CS_STATUS_CODE(HtmlInputText comp_cs_status_code) {
		COMP_CS_STATUS_CODE = comp_cs_status_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CS_STATUS_CODE_DESC_LABEL() {
		return COMP_UI_M_CS_STATUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CS_STATUS_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cs_status_code_desc_label) {
		COMP_UI_M_CS_STATUS_CODE_DESC_LABEL = comp_ui_m_cs_status_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CS_STATUS_CODE_DESC() {
		return COMP_UI_M_CS_STATUS_CODE_DESC;
	}

	public void setCOMP_UI_M_CS_STATUS_CODE_DESC(
			HtmlInputText comp_ui_m_cs_status_code_desc) {
		COMP_UI_M_CS_STATUS_CODE_DESC = comp_ui_m_cs_status_code_desc;
	}

	public HtmlOutputLabel getCOMP_CS_REASON_CODE_LABEL() {
		return COMP_CS_REASON_CODE_LABEL;
	}

	public void setCOMP_CS_REASON_CODE_LABEL(
			HtmlOutputLabel comp_cs_reason_code_label) {
		COMP_CS_REASON_CODE_LABEL = comp_cs_reason_code_label;
	}

	public HtmlInputText getCOMP_CS_REASON_CODE() {
		return COMP_CS_REASON_CODE;
	}

	public void setCOMP_CS_REASON_CODE(HtmlInputText comp_cs_reason_code) {
		COMP_CS_REASON_CODE = comp_cs_reason_code;
	}

	public HtmlOutputLabel getCOMP_CS_STATUS_DT_LABEL() {
		return COMP_CS_STATUS_DT_LABEL;
	}

	public void setCOMP_CS_STATUS_DT_LABEL(HtmlOutputLabel comp_cs_status_dt_label) {
		COMP_CS_STATUS_DT_LABEL = comp_cs_status_dt_label;
	}

	public HtmlCalendar getCOMP_CS_STATUS_DT() {
		return COMP_CS_STATUS_DT;
	}

	public void setCOMP_CS_STATUS_DT(HtmlCalendar comp_cs_status_dt) {
		COMP_CS_STATUS_DT = comp_cs_status_dt;
	}

	public HtmlOutputLabel getCOMP_CS_STATUS_UID_LABEL() {
		return COMP_CS_STATUS_UID_LABEL;
	}

	public void setCOMP_CS_STATUS_UID_LABEL(HtmlOutputLabel comp_cs_status_uid_label) {
		COMP_CS_STATUS_UID_LABEL = comp_cs_status_uid_label;
	}

	public HtmlInputText getCOMP_CS_STATUS_UID() {
		return COMP_CS_STATUS_UID;
	}

	public void setCOMP_CS_STATUS_UID(HtmlInputText comp_cs_status_uid) {
		COMP_CS_STATUS_UID = comp_cs_status_uid;
	}

	public HtmlOutputLabel getCOMP_CS_REMARKS_LABEL() {
		return COMP_CS_REMARKS_LABEL;
	}

	public void setCOMP_CS_REMARKS_LABEL(HtmlOutputLabel comp_cs_remarks_label) {
		COMP_CS_REMARKS_LABEL = comp_cs_remarks_label;
	}

	public HtmlInputText getCOMP_CS_REMARKS() {
		return COMP_CS_REMARKS;
	}

	public void setCOMP_CS_REMARKS(HtmlInputText comp_cs_remarks) {
		COMP_CS_REMARKS = comp_cs_remarks;
	}

	public PT_IL_CLAIM_STATUS_1 getPT_IL_CLAIM_STATUS_1_BEAN() {
		return PT_IL_CLAIM_STATUS_1_BEAN;
	}

	public void setPT_IL_CLAIM_STATUS_1_BEAN(
			PT_IL_CLAIM_STATUS_1 pt_il_claim_status_1_bean) {
		PT_IL_CLAIM_STATUS_1_BEAN = pt_il_claim_status_1_bean;
	}

	public List<PT_IL_CLAIM_STATUS_1> getDataList_PT_IL_CLAIM_STATUS_1() {
		return dataList_PT_IL_CLAIM_STATUS_1;
	}

	public void setDataList_PT_IL_CLAIM_STATUS_1(
			List<PT_IL_CLAIM_STATUS_1> dataList_PT_IL_CLAIM_STATUS_1) {
		this.dataList_PT_IL_CLAIM_STATUS_1 = dataList_PT_IL_CLAIM_STATUS_1;
	}
	
	

}
