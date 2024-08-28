package com.iii.pel.forms.PILQ108_APAC;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class POLICY_DETAILS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POAD_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_POAD_ASSRD_REF_ID1;

	private HtmlOutputLabel COMP_POAD_ASSRD_REF_ID2_LABEL;

	private HtmlInputText COMP_POAD_ASSRD_REF_ID2;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_PROP_NO_LABEL;

	private HtmlInputText COMP_POL_PROP_NO;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_POL_STATUS_DESC_LABEL;

	private HtmlInputText COMP_POL_STATUS_DESC;

	private HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL;

	private HtmlInputText COMP_POL_ADDL_STATUS;

	private HtmlOutputLabel COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private HtmlCommandButton COMP_UI_M_BUT_POL_NO;

	private HtmlCommandButton COMP_PUSH_BUTTON195;

	private HtmlCommandButton COMP_PUSH_BUTTON189;

	private POLICY_DETAILS POLICY_DETAILS_BEAN;

	public PILQ108_APAC_COMPOSITE_ACTION compositeAction;

	private POLICY_DETAILS_HELPER helper;

	private List<POLICY_DETAILS> dataList_POLICY_DETAILS = new ArrayList<POLICY_DETAILS>();

	private UIData dataTable;

	public POLICY_DETAILS_ACTION() {

		POLICY_DETAILS_BEAN = new POLICY_DETAILS();
		helper = new POLICY_DETAILS_HELPER();
	}

	public HtmlOutputLabel getCOMP_POAD_ASSRD_REF_ID1_LABEL() {
		return COMP_POAD_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_POAD_ASSRD_REF_ID1() {
		return COMP_POAD_ASSRD_REF_ID1;
	}

	public void setCOMP_POAD_ASSRD_REF_ID1_LABEL(
			HtmlOutputLabel COMP_POAD_ASSRD_REF_ID1_LABEL) {
		this.COMP_POAD_ASSRD_REF_ID1_LABEL = COMP_POAD_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_POAD_ASSRD_REF_ID1(HtmlInputText COMP_POAD_ASSRD_REF_ID1) {
		this.COMP_POAD_ASSRD_REF_ID1 = COMP_POAD_ASSRD_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_POAD_ASSRD_REF_ID2_LABEL() {
		return COMP_POAD_ASSRD_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_POAD_ASSRD_REF_ID2() {
		return COMP_POAD_ASSRD_REF_ID2;
	}

	public void setCOMP_POAD_ASSRD_REF_ID2_LABEL(
			HtmlOutputLabel COMP_POAD_ASSRD_REF_ID2_LABEL) {
		this.COMP_POAD_ASSRD_REF_ID2_LABEL = COMP_POAD_ASSRD_REF_ID2_LABEL;
	}

	public void setCOMP_POAD_ASSRD_REF_ID2(HtmlInputText COMP_POAD_ASSRD_REF_ID2) {
		this.COMP_POAD_ASSRD_REF_ID2 = COMP_POAD_ASSRD_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_PROP_NO_LABEL() {
		return COMP_POL_PROP_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROP_NO() {
		return COMP_POL_PROP_NO;
	}

	public void setCOMP_POL_PROP_NO_LABEL(HtmlOutputLabel COMP_POL_PROP_NO_LABEL) {
		this.COMP_POL_PROP_NO_LABEL = COMP_POL_PROP_NO_LABEL;
	}

	public void setCOMP_POL_PROP_NO(HtmlInputText COMP_POL_PROP_NO) {
		this.COMP_POL_PROP_NO = COMP_POL_PROP_NO;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(
			HtmlOutputLabel COMP_POL_START_DT_LABEL) {
		this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
	}

	public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
		this.COMP_POL_START_DT = COMP_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(
			HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_POL_STATUS_DESC_LABEL() {
		return COMP_POL_STATUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_POL_STATUS_DESC() {
		return COMP_POL_STATUS_DESC;
	}

	public void setCOMP_POL_STATUS_DESC_LABEL(
			HtmlOutputLabel COMP_POL_STATUS_DESC_LABEL) {
		this.COMP_POL_STATUS_DESC_LABEL = COMP_POL_STATUS_DESC_LABEL;
	}

	public void setCOMP_POL_STATUS_DESC(HtmlInputText COMP_POL_STATUS_DESC) {
		this.COMP_POL_STATUS_DESC = COMP_POL_STATUS_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_ADDL_STATUS_LABEL() {
		return COMP_POL_ADDL_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_POL_ADDL_STATUS() {
		return COMP_POL_ADDL_STATUS;
	}

	public void setCOMP_POL_ADDL_STATUS_LABEL(
			HtmlOutputLabel COMP_POL_ADDL_STATUS_LABEL) {
		this.COMP_POL_ADDL_STATUS_LABEL = COMP_POL_ADDL_STATUS_LABEL;
	}

	public void setCOMP_POL_ADDL_STATUS(HtmlInputText COMP_POL_ADDL_STATUS) {
		this.COMP_POL_ADDL_STATUS = COMP_POL_ADDL_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_ADDL_STATUS_DESC_LABEL() {
		return COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_ADDL_STATUS_DESC() {
		return COMP_UI_M_POL_ADDL_STATUS_DESC;
	}

	public void setCOMP_UI_M_POL_ADDL_STATUS_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL) {
		this.COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL = COMP_UI_M_POL_ADDL_STATUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_ADDL_STATUS_DESC(
			HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC) {
		this.COMP_UI_M_POL_ADDL_STATUS_DESC = COMP_UI_M_POL_ADDL_STATUS_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID1() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID1(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1 = COMP_UI_M_BUT_LOV_POAD_ASSR_REFID1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID2() {
		return COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;
	}

	public void setCOMP_UI_M_BUT_LOV_POAD_ASSR_REFID2(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2) {
		this.COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2 = COMP_UI_M_BUT_LOV_POAD_ASSR_REFID2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_NO() {
		return COMP_UI_M_BUT_POL_NO;
	}

	public void setCOMP_UI_M_BUT_POL_NO(HtmlCommandButton COMP_UI_M_BUT_POL_NO) {
		this.COMP_UI_M_BUT_POL_NO = COMP_UI_M_BUT_POL_NO;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON195() {
		return COMP_PUSH_BUTTON195;
	}

	public void setCOMP_PUSH_BUTTON195(HtmlCommandButton COMP_PUSH_BUTTON195) {
		this.COMP_PUSH_BUTTON195 = COMP_PUSH_BUTTON195;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON189() {
		return COMP_PUSH_BUTTON189;
	}

	public void setCOMP_PUSH_BUTTON189(HtmlCommandButton COMP_PUSH_BUTTON189) {
		this.COMP_PUSH_BUTTON189 = COMP_PUSH_BUTTON189;
	}

	public POLICY_DETAILS getPOLICY_DETAILS_BEAN() {
		return POLICY_DETAILS_BEAN;
	}

	public void setPOLICY_DETAILS_BEAN(POLICY_DETAILS POLICY_DETAILS_BEAN) {
		this.POLICY_DETAILS_BEAN = POLICY_DETAILS_BEAN;
	}

	public List<POLICY_DETAILS> getDataList_POLICY_DETAILS() {
		return dataList_POLICY_DETAILS;
	}

	public void setDataListPOLICY_DETAILS(
			List<POLICY_DETAILS> dataList_POLICY_DETAILS) {
		this.dataList_POLICY_DETAILS = dataList_POLICY_DETAILS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				POLICY_DETAILS_BEAN = new POLICY_DETAILS();
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

				new CRUDHandler().executeDelete(POLICY_DETAILS_BEAN,
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
				dataList_POLICY_DETAILS.remove(POLICY_DETAILS_BEAN);
				if (dataList_POLICY_DETAILS.size() > 0) {

					POLICY_DETAILS_BEAN = dataList_POLICY_DETAILS.get(0);
				} else if (dataList_POLICY_DETAILS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				POLICY_DETAILS_BEAN.setRowSelected(true);
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
			if (POLICY_DETAILS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(POLICY_DETAILS_BEAN,
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
				dataList_POLICY_DETAILS.add(POLICY_DETAILS_BEAN);
			} else if (POLICY_DETAILS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(POLICY_DETAILS_BEAN,
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

			POLICY_DETAILS_BEAN.setRowSelected(true);
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
			POLICY_DETAILS_BEAN = (POLICY_DETAILS) dataTable.getRowData();
			POLICY_DETAILS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<POLICY_DETAILS> POLICY_DETAILS_ITR = dataList_POLICY_DETAILS
				.iterator();
		while (POLICY_DETAILS_ITR.hasNext()) {
			POLICY_DETAILS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POAD_ASSRD_REF_ID1.resetValue();
		COMP_POAD_ASSRD_REF_ID2.resetValue();
		COMP_POL_NO.resetValue();
		COMP_POL_PROP_NO.resetValue();
		COMP_POL_START_DT.resetValue();
		COMP_POL_EXPIRY_DT.resetValue();
		COMP_POL_STATUS_DESC.resetValue();
		COMP_POL_ADDL_STATUS.resetValue();
		COMP_UI_M_POL_ADDL_STATUS_DESC.resetValue();
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

}
