package com.iii.pel.forms.PILT003_APAC;

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
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BROKER_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BV_BROKER_CODE_LABEL;

	private HtmlInputText COMP_BV_BROKER_CODE;

	private HtmlOutputLabel COMP_BV_COVER_CODE_LABEL;

	private HtmlInputText COMP_BV_COVER_CODE;

	private HtmlOutputLabel COMP_BV_COMM_CODE_LABEL;

	private HtmlInputText COMP_BV_COMM_CODE;

	private HtmlOutputLabel COMP_BV_YEAR_LABEL;

	private HtmlInputText COMP_BV_YEAR;

	private HtmlOutputLabel COMP_BV_RATE_LABEL;

	private HtmlInputText COMP_BV_RATE;

	private HtmlOutputLabel COMP_BV_RATE_PER_LABEL;

	private HtmlInputText COMP_BV_RATE_PER;

	private HtmlOutputLabel COMP_BV_FC_VALUE_LABEL;

	private HtmlInputText COMP_BV_FC_VALUE;

	private HtmlOutputLabel COMP_UI_M_BROKER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BROKER_DESC;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_BV_LC_VALUE_LABEL;

	private HtmlInputText COMP_BV_LC_VALUE;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_COLL;

	private PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_BROKER_VALUES_HELPER helper;

	private List<PT_IL_BROKER_VALUES> dataList_PT_IL_BROKER_VALUES = new ArrayList<PT_IL_BROKER_VALUES>();

	private UIData dataTable;

	public PT_IL_BROKER_VALUES_ACTION() {

		PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
		helper = new PT_IL_BROKER_VALUES_HELPER();
	}

	public HtmlOutputLabel getCOMP_BV_BROKER_CODE_LABEL() {
		return COMP_BV_BROKER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_BROKER_CODE() {
		return COMP_BV_BROKER_CODE;
	}

	public void setCOMP_BV_BROKER_CODE_LABEL(
			HtmlOutputLabel COMP_BV_BROKER_CODE_LABEL) {
		this.COMP_BV_BROKER_CODE_LABEL = COMP_BV_BROKER_CODE_LABEL;
	}

	public void setCOMP_BV_BROKER_CODE(HtmlInputText COMP_BV_BROKER_CODE) {
		this.COMP_BV_BROKER_CODE = COMP_BV_BROKER_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_COVER_CODE_LABEL() {
		return COMP_BV_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_COVER_CODE() {
		return COMP_BV_COVER_CODE;
	}

	public void setCOMP_BV_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_BV_COVER_CODE_LABEL) {
		this.COMP_BV_COVER_CODE_LABEL = COMP_BV_COVER_CODE_LABEL;
	}

	public void setCOMP_BV_COVER_CODE(HtmlInputText COMP_BV_COVER_CODE) {
		this.COMP_BV_COVER_CODE = COMP_BV_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_COMM_CODE_LABEL() {
		return COMP_BV_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_COMM_CODE() {
		return COMP_BV_COMM_CODE;
	}

	public void setCOMP_BV_COMM_CODE_LABEL(
			HtmlOutputLabel COMP_BV_COMM_CODE_LABEL) {
		this.COMP_BV_COMM_CODE_LABEL = COMP_BV_COMM_CODE_LABEL;
	}

	public void setCOMP_BV_COMM_CODE(HtmlInputText COMP_BV_COMM_CODE) {
		this.COMP_BV_COMM_CODE = COMP_BV_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_YEAR_LABEL() {
		return COMP_BV_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_BV_YEAR() {
		return COMP_BV_YEAR;
	}

	public void setCOMP_BV_YEAR_LABEL(HtmlOutputLabel COMP_BV_YEAR_LABEL) {
		this.COMP_BV_YEAR_LABEL = COMP_BV_YEAR_LABEL;
	}

	public void setCOMP_BV_YEAR(HtmlInputText COMP_BV_YEAR) {
		this.COMP_BV_YEAR = COMP_BV_YEAR;
	}

	public HtmlOutputLabel getCOMP_BV_RATE_LABEL() {
		return COMP_BV_RATE_LABEL;
	}

	public HtmlInputText getCOMP_BV_RATE() {
		return COMP_BV_RATE;
	}

	public void setCOMP_BV_RATE_LABEL(HtmlOutputLabel COMP_BV_RATE_LABEL) {
		this.COMP_BV_RATE_LABEL = COMP_BV_RATE_LABEL;
	}

	public void setCOMP_BV_RATE(HtmlInputText COMP_BV_RATE) {
		this.COMP_BV_RATE = COMP_BV_RATE;
	}

	public HtmlOutputLabel getCOMP_BV_RATE_PER_LABEL() {
		return COMP_BV_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_BV_RATE_PER() {
		return COMP_BV_RATE_PER;
	}

	public void setCOMP_BV_RATE_PER_LABEL(HtmlOutputLabel COMP_BV_RATE_PER_LABEL) {
		this.COMP_BV_RATE_PER_LABEL = COMP_BV_RATE_PER_LABEL;
	}

	public void setCOMP_BV_RATE_PER(HtmlInputText COMP_BV_RATE_PER) {
		this.COMP_BV_RATE_PER = COMP_BV_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_BV_FC_VALUE_LABEL() {
		return COMP_BV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_FC_VALUE() {
		return COMP_BV_FC_VALUE;
	}

	public void setCOMP_BV_FC_VALUE_LABEL(HtmlOutputLabel COMP_BV_FC_VALUE_LABEL) {
		this.COMP_BV_FC_VALUE_LABEL = COMP_BV_FC_VALUE_LABEL;
	}

	public void setCOMP_BV_FC_VALUE(HtmlInputText COMP_BV_FC_VALUE) {
		this.COMP_BV_FC_VALUE = COMP_BV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BROKER_DESC_LABEL() {
		return COMP_UI_M_BROKER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BROKER_DESC() {
		return COMP_UI_M_BROKER_DESC;
	}

	public void setCOMP_UI_M_BROKER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_BROKER_DESC_LABEL) {
		this.COMP_UI_M_BROKER_DESC_LABEL = COMP_UI_M_BROKER_DESC_LABEL;
	}

	public void setCOMP_UI_M_BROKER_DESC(HtmlInputText COMP_UI_M_BROKER_DESC) {
		this.COMP_UI_M_BROKER_DESC = COMP_UI_M_BROKER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_BV_LC_VALUE_LABEL() {
		return COMP_BV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_LC_VALUE() {
		return COMP_BV_LC_VALUE;
	}

	public void setCOMP_BV_LC_VALUE_LABEL(HtmlOutputLabel COMP_BV_LC_VALUE_LABEL) {
		this.COMP_BV_LC_VALUE_LABEL = COMP_BV_LC_VALUE_LABEL;
	}

	public void setCOMP_BV_LC_VALUE(HtmlInputText COMP_BV_LC_VALUE) {
		this.COMP_BV_LC_VALUE = COMP_BV_LC_VALUE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_COLL() {
		return COMP_UI_M_BUT_PREM_COLL;
	}

	public void setCOMP_UI_M_BUT_PREM_COLL(
			HtmlCommandButton COMP_UI_M_BUT_PREM_COLL) {
		this.COMP_UI_M_BUT_PREM_COLL = COMP_UI_M_BUT_PREM_COLL;
	}

	public PT_IL_BROKER_VALUES getPT_IL_BROKER_VALUES_BEAN() {
		return PT_IL_BROKER_VALUES_BEAN;
	}

	public void setPT_IL_BROKER_VALUES_BEAN(
			PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN) {
		this.PT_IL_BROKER_VALUES_BEAN = PT_IL_BROKER_VALUES_BEAN;
	}

	public List<PT_IL_BROKER_VALUES> getDataList_PT_IL_BROKER_VALUES() {
		return dataList_PT_IL_BROKER_VALUES;
	}

	public void setDataListPT_IL_BROKER_VALUES(
			List<PT_IL_BROKER_VALUES> dataList_PT_IL_BROKER_VALUES) {
		this.dataList_PT_IL_BROKER_VALUES = dataList_PT_IL_BROKER_VALUES;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
				resetAllComponent();
				resetSelectedRow();
				PT_IL_BROKER_VALUES_BEAN.setRowSelected(true);
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

				new CRUDHandler().executeDelete(PT_IL_BROKER_VALUES_BEAN,
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
				dataList_PT_IL_BROKER_VALUES.remove(PT_IL_BROKER_VALUES_BEAN);
				if (dataList_PT_IL_BROKER_VALUES.size() > 0) {

					PT_IL_BROKER_VALUES_BEAN = dataList_PT_IL_BROKER_VALUES
							.get(0);
				} else if (dataList_PT_IL_BROKER_VALUES.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_BROKER_VALUES_BEAN.setRowSelected(true);
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

	private void resetSelectedRow() {
		Iterator<PT_IL_BROKER_VALUES> PT_IL_BROKER_VALUES_ITR = dataList_PT_IL_BROKER_VALUES
				.iterator();
		while (PT_IL_BROKER_VALUES_ITR.hasNext()) {
			PT_IL_BROKER_VALUES_ITR.next().setRowSelected(false);
		}
	}

	/**
	 * Resets all components in PT_IL_BROKER_VALUES_ACTION
	 */
	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_BV_BROKER_CODE.resetValue();
		COMP_BV_COVER_CODE.resetValue();
		COMP_BV_COMM_CODE.resetValue();
		COMP_BV_YEAR.resetValue();
		COMP_BV_RATE.resetValue();
		COMP_BV_RATE_PER.resetValue();
		COMP_BV_FC_VALUE.resetValue();
		COMP_UI_M_BROKER_DESC.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_BV_LC_VALUE.resetValue();

	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if (compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getROWID() != null) {
					helper.executeQuery(compositeAction);
					helper.POST_QUERY(PT_IL_BROKER_VALUES_BEAN);
				}
			}
			setBlockFlag(false);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
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

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_BROKER_VALUES_BEAN = (PT_IL_BROKER_VALUES) dataTable
					.getRowData();
			PT_IL_BROKER_VALUES_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	public String mainButAction(){
		return "PILT003_APAC_PT_IL_PREM_COLL";
	}
}