package com.iii.pel.forms.PILQ106_APAC;

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
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNIT_FUND_REG_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UFRD_START_UNITS_LABEL;

	private HtmlInputText COMP_UFRD_START_UNITS;

	private HtmlOutputLabel COMP_UFRD_START_UNIT_VALUE_LABEL;

	private HtmlInputText COMP_UFRD_START_UNIT_VALUE;

	private HtmlOutputLabel COMP_UI_M_END_UNIT_LABEL;

	private HtmlInputText COMP_UI_M_END_UNIT;

	private HtmlOutputLabel COMP_UI_M_END_UNIT_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_END_UNIT_VALUE;

	private HtmlOutputLabel COMP_UFRD_FUND_CODE_LABEL;

	private HtmlInputText COMP_UFRD_FUND_CODE;

	private HtmlOutputLabel COMP_UFRD_FUND_DESC_LABEL;

	private HtmlInputText COMP_UFRD_FUND_DESC;

	private HtmlOutputLabel COMP_UFRD_FUND_PERC_LABEL;

	private HtmlInputText COMP_UFRD_FUND_PERC;

	private HtmlOutputLabel COMP_UFRD_NO_OF_UNITS_LABEL;

	private HtmlInputText COMP_UFRD_NO_OF_UNITS;

	private HtmlOutputLabel COMP_UFRD_UNIT_DATE_LABEL;

	private HtmlCalendar COMP_UFRD_UNIT_DATE;

	private HtmlOutputLabel COMP_UI_M_UNIT_PRICE_LABEL;

	private HtmlInputText COMP_UI_M_UNIT_PRICE;

	private HtmlOutputLabel COMP_UFRD_UNIT_TOT_LC_VALUE_LABEL;

	private HtmlInputText COMP_UFRD_UNIT_TOT_LC_VALUE;

	private PT_IL_UNIT_FUND_REG_DTL PT_IL_UNIT_FUND_REG_DTL_BEAN;

	public PILQ106_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_UNIT_FUND_REG_DTL_HELPER helper;

	private List<PT_IL_UNIT_FUND_REG_DTL> dataList_PT_IL_UNIT_FUND_REG_DTL = new ArrayList<PT_IL_UNIT_FUND_REG_DTL>();

	private UIData dataTable;

	public PT_IL_UNIT_FUND_REG_DTL_ACTION() {

		PT_IL_UNIT_FUND_REG_DTL_BEAN = new PT_IL_UNIT_FUND_REG_DTL();
		helper = new PT_IL_UNIT_FUND_REG_DTL_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UFRD_START_UNITS_LABEL() {
		return COMP_UFRD_START_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_START_UNITS() {
		return COMP_UFRD_START_UNITS;
	}

	public void setCOMP_UFRD_START_UNITS_LABEL(
			HtmlOutputLabel COMP_UFRD_START_UNITS_LABEL) {
		this.COMP_UFRD_START_UNITS_LABEL = COMP_UFRD_START_UNITS_LABEL;
	}

	public void setCOMP_UFRD_START_UNITS(HtmlInputText COMP_UFRD_START_UNITS) {
		this.COMP_UFRD_START_UNITS = COMP_UFRD_START_UNITS;
	}

	public HtmlOutputLabel getCOMP_UFRD_START_UNIT_VALUE_LABEL() {
		return COMP_UFRD_START_UNIT_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_START_UNIT_VALUE() {
		return COMP_UFRD_START_UNIT_VALUE;
	}

	public void setCOMP_UFRD_START_UNIT_VALUE_LABEL(
			HtmlOutputLabel COMP_UFRD_START_UNIT_VALUE_LABEL) {
		this.COMP_UFRD_START_UNIT_VALUE_LABEL = COMP_UFRD_START_UNIT_VALUE_LABEL;
	}

	public void setCOMP_UFRD_START_UNIT_VALUE(
			HtmlInputText COMP_UFRD_START_UNIT_VALUE) {
		this.COMP_UFRD_START_UNIT_VALUE = COMP_UFRD_START_UNIT_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_END_UNIT_LABEL() {
		return COMP_UI_M_END_UNIT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_END_UNIT() {
		return COMP_UI_M_END_UNIT;
	}

	public void setCOMP_UI_M_END_UNIT_LABEL(
			HtmlOutputLabel COMP_UI_M_END_UNIT_LABEL) {
		this.COMP_UI_M_END_UNIT_LABEL = COMP_UI_M_END_UNIT_LABEL;
	}

	public void setCOMP_UI_M_END_UNIT(HtmlInputText COMP_UI_M_END_UNIT) {
		this.COMP_UI_M_END_UNIT = COMP_UI_M_END_UNIT;
	}

	public HtmlOutputLabel getCOMP_UI_M_END_UNIT_VALUE_LABEL() {
		return COMP_UI_M_END_UNIT_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_END_UNIT_VALUE() {
		return COMP_UI_M_END_UNIT_VALUE;
	}

	public void setCOMP_UI_M_END_UNIT_VALUE_LABEL(
			HtmlOutputLabel COMP_UI_M_END_UNIT_VALUE_LABEL) {
		this.COMP_UI_M_END_UNIT_VALUE_LABEL = COMP_UI_M_END_UNIT_VALUE_LABEL;
	}

	public void setCOMP_UI_M_END_UNIT_VALUE(
			HtmlInputText COMP_UI_M_END_UNIT_VALUE) {
		this.COMP_UI_M_END_UNIT_VALUE = COMP_UI_M_END_UNIT_VALUE;
	}

	public HtmlOutputLabel getCOMP_UFRD_FUND_CODE_LABEL() {
		return COMP_UFRD_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_FUND_CODE() {
		return COMP_UFRD_FUND_CODE;
	}

	public void setCOMP_UFRD_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_UFRD_FUND_CODE_LABEL) {
		this.COMP_UFRD_FUND_CODE_LABEL = COMP_UFRD_FUND_CODE_LABEL;
	}

	public void setCOMP_UFRD_FUND_CODE(HtmlInputText COMP_UFRD_FUND_CODE) {
		this.COMP_UFRD_FUND_CODE = COMP_UFRD_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_UFRD_FUND_DESC_LABEL() {
		return COMP_UFRD_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_FUND_DESC() {
		return COMP_UFRD_FUND_DESC;
	}

	public void setCOMP_UFRD_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UFRD_FUND_DESC_LABEL) {
		this.COMP_UFRD_FUND_DESC_LABEL = COMP_UFRD_FUND_DESC_LABEL;
	}

	public void setCOMP_UFRD_FUND_DESC(HtmlInputText COMP_UFRD_FUND_DESC) {
		this.COMP_UFRD_FUND_DESC = COMP_UFRD_FUND_DESC;
	}

	public HtmlOutputLabel getCOMP_UFRD_FUND_PERC_LABEL() {
		return COMP_UFRD_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_FUND_PERC() {
		return COMP_UFRD_FUND_PERC;
	}

	public void setCOMP_UFRD_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_UFRD_FUND_PERC_LABEL) {
		this.COMP_UFRD_FUND_PERC_LABEL = COMP_UFRD_FUND_PERC_LABEL;
	}

	public void setCOMP_UFRD_FUND_PERC(HtmlInputText COMP_UFRD_FUND_PERC) {
		this.COMP_UFRD_FUND_PERC = COMP_UFRD_FUND_PERC;
	}

	public HtmlOutputLabel getCOMP_UFRD_NO_OF_UNITS_LABEL() {
		return COMP_UFRD_NO_OF_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_NO_OF_UNITS() {
		return COMP_UFRD_NO_OF_UNITS;
	}

	public void setCOMP_UFRD_NO_OF_UNITS_LABEL(
			HtmlOutputLabel COMP_UFRD_NO_OF_UNITS_LABEL) {
		this.COMP_UFRD_NO_OF_UNITS_LABEL = COMP_UFRD_NO_OF_UNITS_LABEL;
	}

	public void setCOMP_UFRD_NO_OF_UNITS(HtmlInputText COMP_UFRD_NO_OF_UNITS) {
		this.COMP_UFRD_NO_OF_UNITS = COMP_UFRD_NO_OF_UNITS;
	}

	public HtmlOutputLabel getCOMP_UFRD_UNIT_DATE_LABEL() {
		return COMP_UFRD_UNIT_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UFRD_UNIT_DATE() {
		return COMP_UFRD_UNIT_DATE;
	}

	public void setCOMP_UFRD_UNIT_DATE_LABEL(
			HtmlOutputLabel COMP_UFRD_UNIT_DATE_LABEL) {
		this.COMP_UFRD_UNIT_DATE_LABEL = COMP_UFRD_UNIT_DATE_LABEL;
	}

	public void setCOMP_UFRD_UNIT_DATE(HtmlCalendar COMP_UFRD_UNIT_DATE) {
		this.COMP_UFRD_UNIT_DATE = COMP_UFRD_UNIT_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_UNIT_PRICE_LABEL() {
		return COMP_UI_M_UNIT_PRICE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_UNIT_PRICE() {
		return COMP_UI_M_UNIT_PRICE;
	}

	public void setCOMP_UI_M_UNIT_PRICE_LABEL(
			HtmlOutputLabel COMP_UI_M_UNIT_PRICE_LABEL) {
		this.COMP_UI_M_UNIT_PRICE_LABEL = COMP_UI_M_UNIT_PRICE_LABEL;
	}

	public void setCOMP_UI_M_UNIT_PRICE(HtmlInputText COMP_UI_M_UNIT_PRICE) {
		this.COMP_UI_M_UNIT_PRICE = COMP_UI_M_UNIT_PRICE;
	}

	public HtmlOutputLabel getCOMP_UFRD_UNIT_TOT_LC_VALUE_LABEL() {
		return COMP_UFRD_UNIT_TOT_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UFRD_UNIT_TOT_LC_VALUE() {
		return COMP_UFRD_UNIT_TOT_LC_VALUE;
	}

	public void setCOMP_UFRD_UNIT_TOT_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_UFRD_UNIT_TOT_LC_VALUE_LABEL) {
		this.COMP_UFRD_UNIT_TOT_LC_VALUE_LABEL = COMP_UFRD_UNIT_TOT_LC_VALUE_LABEL;
	}

	public void setCOMP_UFRD_UNIT_TOT_LC_VALUE(
			HtmlInputText COMP_UFRD_UNIT_TOT_LC_VALUE) {
		this.COMP_UFRD_UNIT_TOT_LC_VALUE = COMP_UFRD_UNIT_TOT_LC_VALUE;
	}

	public PT_IL_UNIT_FUND_REG_DTL getPT_IL_UNIT_FUND_REG_DTL_BEAN() {
		return PT_IL_UNIT_FUND_REG_DTL_BEAN;
	}

	public void setPT_IL_UNIT_FUND_REG_DTL_BEAN(
			PT_IL_UNIT_FUND_REG_DTL PT_IL_UNIT_FUND_REG_DTL_BEAN) {
		this.PT_IL_UNIT_FUND_REG_DTL_BEAN = PT_IL_UNIT_FUND_REG_DTL_BEAN;
	}

	public List<PT_IL_UNIT_FUND_REG_DTL> getDataList_PT_IL_UNIT_FUND_REG_DTL() {
		return dataList_PT_IL_UNIT_FUND_REG_DTL;
	}

	public void setDataListPT_IL_UNIT_FUND_REG_DTL(
			List<PT_IL_UNIT_FUND_REG_DTL> dataList_PT_IL_UNIT_FUND_REG_DTL) {
		this.dataList_PT_IL_UNIT_FUND_REG_DTL = dataList_PT_IL_UNIT_FUND_REG_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_UNIT_FUND_REG_DTL_BEAN = new PT_IL_UNIT_FUND_REG_DTL();
				resetAllComponent();
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

				new CRUDHandler().executeDelete(PT_IL_UNIT_FUND_REG_DTL_BEAN,
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
				dataList_PT_IL_UNIT_FUND_REG_DTL
						.remove(PT_IL_UNIT_FUND_REG_DTL_BEAN);
				if (dataList_PT_IL_UNIT_FUND_REG_DTL.size() > 0) {

					PT_IL_UNIT_FUND_REG_DTL_BEAN = dataList_PT_IL_UNIT_FUND_REG_DTL
							.get(0);
				} else if (dataList_PT_IL_UNIT_FUND_REG_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
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
			if (PT_IL_UNIT_FUND_REG_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_UNIT_FUND_REG_DTL_BEAN,
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
				dataList_PT_IL_UNIT_FUND_REG_DTL
						.add(PT_IL_UNIT_FUND_REG_DTL_BEAN);
			} else if (PT_IL_UNIT_FUND_REG_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_UNIT_FUND_REG_DTL_BEAN,
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

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_UNIT_FUND_REG_DTL> PT_IL_UNIT_FUND_REG_DTL_BEAN_ITR = dataList_PT_IL_UNIT_FUND_REG_DTL.iterator();
		while (PT_IL_UNIT_FUND_REG_DTL_BEAN_ITR.hasNext()) {
		    PT_IL_UNIT_FUND_REG_DTL_BEAN_ITR.next().setRowSelected(false);
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		 	try {
				resetSelectedRow();
				PT_IL_UNIT_FUND_REG_DTL_BEAN = (PT_IL_UNIT_FUND_REG_DTL) dataTable.getRowData();
				//helper.postQuery();
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setRowSelected(true);
				resetAllComponent();
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("displayRecords", exc.getMessage());
			}
	}

	public void resetAllComponent() {
		COMP_UFRD_START_UNITS.resetValue();
		COMP_UFRD_START_UNIT_VALUE.resetValue();
		COMP_UI_M_END_UNIT.resetValue();
		COMP_UI_M_END_UNIT_VALUE.resetValue();
		COMP_UFRD_FUND_CODE.resetValue();
		COMP_UFRD_FUND_DESC.resetValue();
		COMP_UFRD_FUND_PERC.resetValue();
		COMP_UFRD_NO_OF_UNITS.resetValue();
		COMP_UFRD_UNIT_DATE.resetValue();
		COMP_UI_M_UNIT_PRICE.resetValue();
		COMP_UFRD_UNIT_TOT_LC_VALUE.resetValue();
	}

	/**
	 * Instantiates all components in PT_IL_UNIT_FUND_REG_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UFRD_START_UNITS				 = new HtmlInputText();
		COMP_UFRD_START_UNIT_VALUE			 = new HtmlInputText();
		COMP_UI_M_END_UNIT				 = new HtmlInputText();
		COMP_UI_M_END_UNIT_VALUE			 = new HtmlInputText();
		COMP_UFRD_FUND_CODE				 = new HtmlInputText();
		COMP_UFRD_FUND_DESC				 = new HtmlInputText();
		COMP_UFRD_FUND_PERC				 = new HtmlInputText();
		COMP_UFRD_NO_OF_UNITS				 = new HtmlInputText();
		COMP_UI_M_UNIT_PRICE				 = new HtmlInputText();
		COMP_UFRD_UNIT_TOT_LC_VALUE			 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_UFRD_UNIT_DATE				 = new HtmlCalendar();

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

	public void onLoad( ) {
		try {
			if (isBlockFlag()) {
			    	helper.preQuery(compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_HDR_BEAN(),PT_IL_UNIT_FUND_REG_DTL_BEAN);
				helper.executeQuery(compositeAction);
				helper.postQuery(compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_HDR_BEAN(), PT_IL_UNIT_FUND_REG_DTL_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

}
