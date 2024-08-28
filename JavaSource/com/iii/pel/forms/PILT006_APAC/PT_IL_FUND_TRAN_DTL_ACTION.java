package com.iii.pel.forms.PILT006_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FTD_FUND_CODE_LABEL;

	private HtmlInputText COMP_FTD_FUND_CODE;

	private HtmlOutputLabel COMP_FTD_PREM_UNITS_LABEL;

	private HtmlInputText COMP_FTD_PREM_UNITS;

	private HtmlOutputLabel COMP_FTD_TOP_UP_UNITS_LABEL;

	private HtmlInputText COMP_FTD_TOP_UP_UNITS;

	private HtmlOutputLabel COMP_FTD_NO_OF_UNITS_LABEL;

	private HtmlInputText COMP_FTD_NO_OF_UNITS;

	private HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_LABEL;

	private HtmlInputText COMP_FTD_UNIT_SEL_PRICE;

	private HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_LABEL;

	private HtmlInputText COMP_FTD_UNIT_LC_AMT;

	private HtmlOutputLabel COMP_FTD_FUND_CODE_DESC_LABEL;

	private HtmlInputText COMP_FTD_FUND_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_TOTAL_LC_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_TOTAL_LC_VALUE;

	private PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_FUND_TRAN_DTL_HELPER helper;

	private List<PT_IL_FUND_TRAN_DTL> dataList_PT_IL_FUND_TRAN_DTL = new ArrayList<PT_IL_FUND_TRAN_DTL>();
	
	private String DEFAULT_WHERE = null;
	private UIData dataTable;
	private Double UI_M_TOTAL_LC_VALUE;

	public PT_IL_FUND_TRAN_DTL_ACTION() {

		PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
		helper = new PT_IL_FUND_TRAN_DTL_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_FTD_FUND_CODE_LABEL() {
		return COMP_FTD_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FTD_FUND_CODE() {
		return COMP_FTD_FUND_CODE;
	}

	public void setCOMP_FTD_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_FTD_FUND_CODE_LABEL) {
		this.COMP_FTD_FUND_CODE_LABEL = COMP_FTD_FUND_CODE_LABEL;
	}

	public void setCOMP_FTD_FUND_CODE(HtmlInputText COMP_FTD_FUND_CODE) {
		this.COMP_FTD_FUND_CODE = COMP_FTD_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_FTD_PREM_UNITS_LABEL() {
		return COMP_FTD_PREM_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_PREM_UNITS() {
		return COMP_FTD_PREM_UNITS;
	}

	public void setCOMP_FTD_PREM_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_PREM_UNITS_LABEL) {
		this.COMP_FTD_PREM_UNITS_LABEL = COMP_FTD_PREM_UNITS_LABEL;
	}

	public void setCOMP_FTD_PREM_UNITS(HtmlInputText COMP_FTD_PREM_UNITS) {
		this.COMP_FTD_PREM_UNITS = COMP_FTD_PREM_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_TOP_UP_UNITS_LABEL() {
		return COMP_FTD_TOP_UP_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_TOP_UP_UNITS() {
		return COMP_FTD_TOP_UP_UNITS;
	}

	public void setCOMP_FTD_TOP_UP_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_TOP_UP_UNITS_LABEL) {
		this.COMP_FTD_TOP_UP_UNITS_LABEL = COMP_FTD_TOP_UP_UNITS_LABEL;
	}

	public void setCOMP_FTD_TOP_UP_UNITS(HtmlInputText COMP_FTD_TOP_UP_UNITS) {
		this.COMP_FTD_TOP_UP_UNITS = COMP_FTD_TOP_UP_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_OF_UNITS_LABEL() {
		return COMP_FTD_NO_OF_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_NO_OF_UNITS() {
		return COMP_FTD_NO_OF_UNITS;
	}

	public void setCOMP_FTD_NO_OF_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_NO_OF_UNITS_LABEL) {
		this.COMP_FTD_NO_OF_UNITS_LABEL = COMP_FTD_NO_OF_UNITS_LABEL;
	}

	public void setCOMP_FTD_NO_OF_UNITS(HtmlInputText COMP_FTD_NO_OF_UNITS) {
		this.COMP_FTD_NO_OF_UNITS = COMP_FTD_NO_OF_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_SEL_PRICE_LABEL() {
		return COMP_FTD_UNIT_SEL_PRICE_LABEL;
	}

	public HtmlInputText getCOMP_FTD_UNIT_SEL_PRICE() {
		return COMP_FTD_UNIT_SEL_PRICE;
	}

	public void setCOMP_FTD_UNIT_SEL_PRICE_LABEL(
			HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_LABEL) {
		this.COMP_FTD_UNIT_SEL_PRICE_LABEL = COMP_FTD_UNIT_SEL_PRICE_LABEL;
	}

	public void setCOMP_FTD_UNIT_SEL_PRICE(HtmlInputText COMP_FTD_UNIT_SEL_PRICE) {
		this.COMP_FTD_UNIT_SEL_PRICE = COMP_FTD_UNIT_SEL_PRICE;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_LC_AMT_LABEL() {
		return COMP_FTD_UNIT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FTD_UNIT_LC_AMT() {
		return COMP_FTD_UNIT_LC_AMT;
	}

	public void setCOMP_FTD_UNIT_LC_AMT_LABEL(
			HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_LABEL) {
		this.COMP_FTD_UNIT_LC_AMT_LABEL = COMP_FTD_UNIT_LC_AMT_LABEL;
	}

	public void setCOMP_FTD_UNIT_LC_AMT(HtmlInputText COMP_FTD_UNIT_LC_AMT) {
		this.COMP_FTD_UNIT_LC_AMT = COMP_FTD_UNIT_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_FTD_FUND_CODE_DESC_LABEL() {
		return COMP_FTD_FUND_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FTD_FUND_CODE_DESC() {
		return COMP_FTD_FUND_CODE_DESC;
	}

	public void setCOMP_FTD_FUND_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_FTD_FUND_CODE_DESC_LABEL) {
		this.COMP_FTD_FUND_CODE_DESC_LABEL = COMP_FTD_FUND_CODE_DESC_LABEL;
	}

	public void setCOMP_FTD_FUND_CODE_DESC(HtmlInputText COMP_FTD_FUND_CODE_DESC) {
		this.COMP_FTD_FUND_CODE_DESC = COMP_FTD_FUND_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOTAL_LC_VALUE_LABEL() {
		return COMP_UI_M_TOTAL_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOTAL_LC_VALUE() {
		return COMP_UI_M_TOTAL_LC_VALUE;
	}

	public void setCOMP_UI_M_TOTAL_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_UI_M_TOTAL_LC_VALUE_LABEL) {
		this.COMP_UI_M_TOTAL_LC_VALUE_LABEL = COMP_UI_M_TOTAL_LC_VALUE_LABEL;
	}

	public void setCOMP_UI_M_TOTAL_LC_VALUE(
			HtmlInputText COMP_UI_M_TOTAL_LC_VALUE) {
		this.COMP_UI_M_TOTAL_LC_VALUE = COMP_UI_M_TOTAL_LC_VALUE;
	}

	public PT_IL_FUND_TRAN_DTL getPT_IL_FUND_TRAN_DTL_BEAN() {
		return PT_IL_FUND_TRAN_DTL_BEAN;
	}

	public void setPT_IL_FUND_TRAN_DTL_BEAN(
			PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN) {
		this.PT_IL_FUND_TRAN_DTL_BEAN = PT_IL_FUND_TRAN_DTL_BEAN;
	}

	public List<PT_IL_FUND_TRAN_DTL> getDataList_PT_IL_FUND_TRAN_DTL() {
		return dataList_PT_IL_FUND_TRAN_DTL;
	}

	public void setDataListPT_IL_FUND_TRAN_DTL(
			List<PT_IL_FUND_TRAN_DTL> dataList_PT_IL_FUND_TRAN_DTL) {
		this.dataList_PT_IL_FUND_TRAN_DTL = dataList_PT_IL_FUND_TRAN_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
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

				//new PT_IL_FUND_TRAN_DTL_HELPER().preDelete();
				new CRUDHandler().executeDelete(PT_IL_FUND_TRAN_DTL_BEAN,
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
				dataList_PT_IL_FUND_TRAN_DTL.remove(PT_IL_FUND_TRAN_DTL_BEAN);
				if (dataList_PT_IL_FUND_TRAN_DTL.size() > 0) {

					PT_IL_FUND_TRAN_DTL_BEAN = dataList_PT_IL_FUND_TRAN_DTL
							.get(0);
				} else if (dataList_PT_IL_FUND_TRAN_DTL.size() == 0) {

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
			if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				/*new PT_IL_FUND_TRAN_DTL_HELPER()
						.preInsert(PT_IL_FUND_TRAN_DTL_BEAN);*/
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_DTL_BEAN,
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
				dataList_PT_IL_FUND_TRAN_DTL.add(PT_IL_FUND_TRAN_DTL_BEAN);
			} else if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				/*new PT_IL_FUND_TRAN_DTL_HELPER()
						.preUpdate(PT_IL_FUND_TRAN_DTL_BEAN);*/
				new CRUDHandler().executeUpdate(PT_IL_FUND_TRAN_DTL_BEAN,
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
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_FUND_TRAN_DTL_BEAN = (PT_IL_FUND_TRAN_DTL) dataTable
					.getRowData();
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	
	
	
	
	private void resetAllComponent() {
		COMP_FTD_FUND_CODE.resetValue();
		COMP_FTD_PREM_UNITS.resetValue();
		COMP_FTD_TOP_UP_UNITS.resetValue();
		COMP_FTD_NO_OF_UNITS.resetValue();
		COMP_FTD_UNIT_SEL_PRICE.resetValue();
		COMP_FTD_UNIT_LC_AMT.resetValue();
		COMP_FTD_FUND_CODE_DESC.resetValue();
		COMP_UI_M_TOTAL_LC_VALUE.resetValue();
	}

	/**
	 * Disables all components in PT_IL_FUND_TRAN_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_FTD_FUND_CODE.setDisabled(disabled);
		COMP_FTD_PREM_UNITS.setDisabled(disabled);
		COMP_FTD_TOP_UP_UNITS.setDisabled(disabled);
		COMP_FTD_NO_OF_UNITS.setDisabled(disabled);
		COMP_FTD_UNIT_SEL_PRICE.setDisabled(disabled);
		COMP_FTD_UNIT_LC_AMT.setDisabled(disabled);
		COMP_FTD_FUND_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_TOTAL_LC_VALUE.setDisabled(disabled);

	}
	

	/**
	 * Instantiates all components in PT_IL_FUND_TRAN_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_FTD_FUND_CODE				 = new HtmlInputText();
		COMP_FTD_PREM_UNITS				 = new HtmlInputText();
		COMP_FTD_TOP_UP_UNITS				 = new HtmlInputText();
		COMP_FTD_NO_OF_UNITS				 = new HtmlInputText();
		COMP_FTD_UNIT_SEL_PRICE				 = new HtmlInputText();
		COMP_FTD_UNIT_LC_AMT				 = new HtmlInputText();
		COMP_FTD_FUND_CODE_DESC				 = new HtmlInputText();
		COMP_UI_M_TOTAL_LC_VALUE			 = new HtmlInputText();

	}


	private void resetSelectedRow() {
		Iterator<PT_IL_FUND_TRAN_DTL> PT_IL_FUND_TRAN_DTL_ITR = dataList_PT_IL_FUND_TRAN_DTL
				.iterator();
		while (PT_IL_FUND_TRAN_DTL_ITR.hasNext()) {
			PT_IL_FUND_TRAN_DTL_ITR.next().setRowSelected(false);
		}
	}

	
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag()){
				helper.whenNewBlockInstance(
						compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
						this);
				helper.executeQuery(this);
				if(getDataList_PT_IL_FUND_TRAN_DTL().size() > 0){
					PT_IL_FUND_TRAN_DTL_BEAN = getDataList_PT_IL_FUND_TRAN_DTL().get(0);
					helper.postQuery(PT_IL_FUND_TRAN_DTL_BEAN);
				}else{
					PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("LOAD", e.getMessage());
		}
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	public void setDataList_PT_IL_FUND_TRAN_DTL(
			List<PT_IL_FUND_TRAN_DTL> dataList_PT_IL_FUND_TRAN_DTL) {
		this.dataList_PT_IL_FUND_TRAN_DTL = dataList_PT_IL_FUND_TRAN_DTL;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public Double getUI_M_TOTAL_LC_VALUE() {
		return UI_M_TOTAL_LC_VALUE;
	}

	public void setUI_M_TOTAL_LC_VALUE(Double ui_m_total_lc_value) {
		UI_M_TOTAL_LC_VALUE = ui_m_total_lc_value;
	}
}
