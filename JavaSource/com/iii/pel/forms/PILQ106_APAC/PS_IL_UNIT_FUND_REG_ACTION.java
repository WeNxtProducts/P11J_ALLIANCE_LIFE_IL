package com.iii.pel.forms.PILQ106_APAC;

import java.util.ArrayList;
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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_UNIT_FUND_REG_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_CUST_CODE_LABEL;

	private HtmlInputText COMP_CUST_CODE;

	private HtmlOutputLabel COMP_CUST_NAME_LABEL;

	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_PROD_CODE_LABEL;

	private HtmlInputText COMP_PROD_CODE;

	private HtmlOutputLabel COMP_PROD_DESC_LABEL;

	private HtmlInputText COMP_PROD_DESC;

	private HtmlOutputLabel COMP_UFR_POL_NO_LABEL;

	private HtmlInputText COMP_UFR_POL_NO;

	private HtmlOutputLabel COMP_UFR_FUND_CODE_LABEL;

	private HtmlInputText COMP_UFR_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FUND_DESC;

	private HtmlOutputLabel COMP_UFR_PREM_UNITS_LABEL;

	private HtmlInputText COMP_UFR_PREM_UNITS;

	private HtmlOutputLabel COMP_UFR_TOP_UP_UNITS_LABEL;

	private HtmlInputText COMP_UFR_TOP_UP_UNITS;

	private HtmlOutputLabel COMP_UFR_NO_OF_UNITS_LABEL;

	private HtmlInputText COMP_UFR_NO_OF_UNITS;

	private HtmlOutputLabel COMP_UNIT_PRICE_LABEL;

	private HtmlInputText COMP_UNIT_PRICE;

	private HtmlOutputLabel COMP_UNIT_VALUE_LABEL;

	private HtmlInputText COMP_UNIT_VALUE;

	private HtmlOutputLabel COMP_UI_M_TOT_UNIT_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_TOT_UNIT_VALUE;

	private HtmlCommandButton COMP_UI_M_BUT_POL_LOV;

	private HtmlCommandButton COMP_PUSH_BUTTON81;

	private PS_IL_UNIT_FUND_REG PS_IL_UNIT_FUND_REG_BEAN;

	public PILQ106_APAC_COMPOSITE_ACTION compositeAction;

	private PS_IL_UNIT_FUND_REG_HELPER helper;

	private List<PS_IL_UNIT_FUND_REG> dataList_PS_IL_UNIT_FUND_REG = new ArrayList<PS_IL_UNIT_FUND_REG>();

	private UIData dataTable;

	public PS_IL_UNIT_FUND_REG_ACTION() {
		PS_IL_UNIT_FUND_REG_BEAN = new PS_IL_UNIT_FUND_REG();
		helper = new PS_IL_UNIT_FUND_REG_HELPER();
		instantiateAllComponent();
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

	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel COMP_CUST_CODE_LABEL) {
		this.COMP_CUST_CODE_LABEL = COMP_CUST_CODE_LABEL;
	}

	public void setCOMP_CUST_CODE(HtmlInputText COMP_CUST_CODE) {
		this.COMP_CUST_CODE = COMP_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel COMP_CUST_NAME_LABEL) {
		this.COMP_CUST_NAME_LABEL = COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME(HtmlInputText COMP_CUST_NAME) {
		this.COMP_CUST_NAME = COMP_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_PROD_CODE_LABEL() {
		return COMP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PROD_CODE() {
		return COMP_PROD_CODE;
	}

	public void setCOMP_PROD_CODE_LABEL(HtmlOutputLabel COMP_PROD_CODE_LABEL) {
		this.COMP_PROD_CODE_LABEL = COMP_PROD_CODE_LABEL;
	}

	public void setCOMP_PROD_CODE(HtmlInputText COMP_PROD_CODE) {
		this.COMP_PROD_CODE = COMP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_PROD_DESC_LABEL() {
		return COMP_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PROD_DESC() {
		return COMP_PROD_DESC;
	}

	public void setCOMP_PROD_DESC_LABEL(HtmlOutputLabel COMP_PROD_DESC_LABEL) {
		this.COMP_PROD_DESC_LABEL = COMP_PROD_DESC_LABEL;
	}

	public void setCOMP_PROD_DESC(HtmlInputText COMP_PROD_DESC) {
		this.COMP_PROD_DESC = COMP_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_UFR_POL_NO_LABEL() {
		return COMP_UFR_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UFR_POL_NO() {
		return COMP_UFR_POL_NO;
	}

	public void setCOMP_UFR_POL_NO_LABEL(HtmlOutputLabel COMP_UFR_POL_NO_LABEL) {
		this.COMP_UFR_POL_NO_LABEL = COMP_UFR_POL_NO_LABEL;
	}

	public void setCOMP_UFR_POL_NO(HtmlInputText COMP_UFR_POL_NO) {
		this.COMP_UFR_POL_NO = COMP_UFR_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UFR_FUND_CODE_LABEL() {
		return COMP_UFR_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UFR_FUND_CODE() {
		return COMP_UFR_FUND_CODE;
	}

	public void setCOMP_UFR_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_UFR_FUND_CODE_LABEL) {
		this.COMP_UFR_FUND_CODE_LABEL = COMP_UFR_FUND_CODE_LABEL;
	}

	public void setCOMP_UFR_FUND_CODE(HtmlInputText COMP_UFR_FUND_CODE) {
		this.COMP_UFR_FUND_CODE = COMP_UFR_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FUND_DESC_LABEL() {
		return COMP_UI_M_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FUND_DESC() {
		return COMP_UI_M_FUND_DESC;
	}

	public void setCOMP_UI_M_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL) {
		this.COMP_UI_M_FUND_DESC_LABEL = COMP_UI_M_FUND_DESC_LABEL;
	}

	public void setCOMP_UI_M_FUND_DESC(HtmlInputText COMP_UI_M_FUND_DESC) {
		this.COMP_UI_M_FUND_DESC = COMP_UI_M_FUND_DESC;
	}

	public HtmlOutputLabel getCOMP_UFR_PREM_UNITS_LABEL() {
		return COMP_UFR_PREM_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_UFR_PREM_UNITS() {
		return COMP_UFR_PREM_UNITS;
	}

	public void setCOMP_UFR_PREM_UNITS_LABEL(
			HtmlOutputLabel COMP_UFR_PREM_UNITS_LABEL) {
		this.COMP_UFR_PREM_UNITS_LABEL = COMP_UFR_PREM_UNITS_LABEL;
	}

	public void setCOMP_UFR_PREM_UNITS(HtmlInputText COMP_UFR_PREM_UNITS) {
		this.COMP_UFR_PREM_UNITS = COMP_UFR_PREM_UNITS;
	}

	public HtmlOutputLabel getCOMP_UFR_TOP_UP_UNITS_LABEL() {
		return COMP_UFR_TOP_UP_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_UFR_TOP_UP_UNITS() {
		return COMP_UFR_TOP_UP_UNITS;
	}

	public void setCOMP_UFR_TOP_UP_UNITS_LABEL(
			HtmlOutputLabel COMP_UFR_TOP_UP_UNITS_LABEL) {
		this.COMP_UFR_TOP_UP_UNITS_LABEL = COMP_UFR_TOP_UP_UNITS_LABEL;
	}

	public void setCOMP_UFR_TOP_UP_UNITS(HtmlInputText COMP_UFR_TOP_UP_UNITS) {
		this.COMP_UFR_TOP_UP_UNITS = COMP_UFR_TOP_UP_UNITS;
	}

	public HtmlOutputLabel getCOMP_UFR_NO_OF_UNITS_LABEL() {
		return COMP_UFR_NO_OF_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_UFR_NO_OF_UNITS() {
		return COMP_UFR_NO_OF_UNITS;
	}

	public void setCOMP_UFR_NO_OF_UNITS_LABEL(
			HtmlOutputLabel COMP_UFR_NO_OF_UNITS_LABEL) {
		this.COMP_UFR_NO_OF_UNITS_LABEL = COMP_UFR_NO_OF_UNITS_LABEL;
	}

	public void setCOMP_UFR_NO_OF_UNITS(HtmlInputText COMP_UFR_NO_OF_UNITS) {
		this.COMP_UFR_NO_OF_UNITS = COMP_UFR_NO_OF_UNITS;
	}

	public HtmlOutputLabel getCOMP_UNIT_PRICE_LABEL() {
		return COMP_UNIT_PRICE_LABEL;
	}

	public HtmlInputText getCOMP_UNIT_PRICE() {
		return COMP_UNIT_PRICE;
	}

	public void setCOMP_UNIT_PRICE_LABEL(HtmlOutputLabel COMP_UNIT_PRICE_LABEL) {
		this.COMP_UNIT_PRICE_LABEL = COMP_UNIT_PRICE_LABEL;
	}

	public void setCOMP_UNIT_PRICE(HtmlInputText COMP_UNIT_PRICE) {
		this.COMP_UNIT_PRICE = COMP_UNIT_PRICE;
	}

	public HtmlOutputLabel getCOMP_UNIT_VALUE_LABEL() {
		return COMP_UNIT_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UNIT_VALUE() {
		return COMP_UNIT_VALUE;
	}

	public void setCOMP_UNIT_VALUE_LABEL(HtmlOutputLabel COMP_UNIT_VALUE_LABEL) {
		this.COMP_UNIT_VALUE_LABEL = COMP_UNIT_VALUE_LABEL;
	}

	public void setCOMP_UNIT_VALUE(HtmlInputText COMP_UNIT_VALUE) {
		this.COMP_UNIT_VALUE = COMP_UNIT_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_UNIT_VALUE_LABEL() {
		return COMP_UI_M_TOT_UNIT_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_UNIT_VALUE() {
		return COMP_UI_M_TOT_UNIT_VALUE;
	}

	public void setCOMP_UI_M_TOT_UNIT_VALUE_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_UNIT_VALUE_LABEL) {
		this.COMP_UI_M_TOT_UNIT_VALUE_LABEL = COMP_UI_M_TOT_UNIT_VALUE_LABEL;
	}

	public void setCOMP_UI_M_TOT_UNIT_VALUE(
			HtmlInputText COMP_UI_M_TOT_UNIT_VALUE) {
		this.COMP_UI_M_TOT_UNIT_VALUE = COMP_UI_M_TOT_UNIT_VALUE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_LOV() {
		return COMP_UI_M_BUT_POL_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_LOV(HtmlCommandButton COMP_UI_M_BUT_POL_LOV) {
		this.COMP_UI_M_BUT_POL_LOV = COMP_UI_M_BUT_POL_LOV;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON81() {
		return COMP_PUSH_BUTTON81;
	}

	public void setCOMP_PUSH_BUTTON81(HtmlCommandButton COMP_PUSH_BUTTON81) {
		this.COMP_PUSH_BUTTON81 = COMP_PUSH_BUTTON81;
	}

	public PS_IL_UNIT_FUND_REG getPS_IL_UNIT_FUND_REG_BEAN() {
		return PS_IL_UNIT_FUND_REG_BEAN;
	}

	public void setPS_IL_UNIT_FUND_REG_BEAN(
			PS_IL_UNIT_FUND_REG PS_IL_UNIT_FUND_REG_BEAN) {
		this.PS_IL_UNIT_FUND_REG_BEAN = PS_IL_UNIT_FUND_REG_BEAN;
	}

	public List<PS_IL_UNIT_FUND_REG> getDataList_PS_IL_UNIT_FUND_REG() {
		return dataList_PS_IL_UNIT_FUND_REG;
	}

	public void setDataListPS_IL_UNIT_FUND_REG(
			List<PS_IL_UNIT_FUND_REG> dataList_PS_IL_UNIT_FUND_REG) {
		this.dataList_PS_IL_UNIT_FUND_REG = dataList_PS_IL_UNIT_FUND_REG;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PS_IL_UNIT_FUND_REG_BEAN = new PS_IL_UNIT_FUND_REG();
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

				new CRUDHandler().executeDelete(PS_IL_UNIT_FUND_REG_BEAN,
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
				dataList_PS_IL_UNIT_FUND_REG.remove(PS_IL_UNIT_FUND_REG_BEAN);
				if (dataList_PS_IL_UNIT_FUND_REG.size() > 0) {

					PS_IL_UNIT_FUND_REG_BEAN = dataList_PS_IL_UNIT_FUND_REG
							.get(0);
				} else if (dataList_PS_IL_UNIT_FUND_REG.size() == 0) {

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
			if (PS_IL_UNIT_FUND_REG_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PS_IL_UNIT_FUND_REG_BEAN,
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
				dataList_PS_IL_UNIT_FUND_REG.add(PS_IL_UNIT_FUND_REG_BEAN);
			} else if (PS_IL_UNIT_FUND_REG_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PS_IL_UNIT_FUND_REG_BEAN,
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
			PS_IL_UNIT_FUND_REG_BEAN = (PS_IL_UNIT_FUND_REG) dataTable
					.getRowData();
			resetAllComponent();
			calculateUnit();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public void resetAllComponent() {
		COMP_UI_M_POL_NO.resetValue();
		COMP_CUST_CODE.resetValue();
		COMP_CUST_NAME.resetValue();
		COMP_PROD_CODE.resetValue();
		COMP_PROD_DESC.resetValue();
		COMP_UFR_POL_NO.resetValue();
		COMP_UFR_FUND_CODE.resetValue();
		COMP_UI_M_FUND_DESC.resetValue();
		COMP_UFR_PREM_UNITS.resetValue();
		COMP_UFR_TOP_UP_UNITS.resetValue();
		COMP_UFR_NO_OF_UNITS.resetValue();
		COMP_UNIT_PRICE.resetValue();
		COMP_UNIT_VALUE.resetValue();
		COMP_UI_M_TOT_UNIT_VALUE.resetValue();
	}

	/**
	 * Instantiates all components in PS_IL_UNIT_FUND_REG_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_POL_NO				 = new HtmlInputText();
		COMP_CUST_CODE					 = new HtmlInputText();
		COMP_CUST_NAME					 = new HtmlInputText();
		COMP_PROD_CODE					 = new HtmlInputText();
		COMP_PROD_DESC					 = new HtmlInputText();
		COMP_UFR_POL_NO					 = new HtmlInputText();
		COMP_UFR_FUND_CODE				 = new HtmlInputText();
		COMP_UI_M_FUND_DESC				 = new HtmlInputText();
		COMP_UFR_PREM_UNITS				 = new HtmlInputText();
		COMP_UFR_TOP_UP_UNITS				 = new HtmlInputText();
		COMP_UFR_NO_OF_UNITS				 = new HtmlInputText();
		COMP_UNIT_PRICE					 = new HtmlInputText();
		COMP_UNIT_VALUE					 = new HtmlInputText();
		COMP_UI_M_TOT_UNIT_VALUE			 = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_POL_LOV				 = new HtmlCommandButton();
		COMP_PUSH_BUTTON81				 = new HtmlCommandButton();

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

	public void onLoad( ) throws Exception {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				helper.postQuery(PS_IL_UNIT_FUND_REG_BEAN,compositeAction);
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void calculateUnit()
	{
		
		Double sum = 0.0;
		
		for( PS_IL_UNIT_FUND_REG unitfundReg : dataList_PS_IL_UNIT_FUND_REG)
		{
			sum = sum + unitfundReg.getUNIT_VALUE();
		}
		PS_IL_UNIT_FUND_REG_BEAN.setUI_M_TOT_UNIT_VALUE(sum);
	}

}
