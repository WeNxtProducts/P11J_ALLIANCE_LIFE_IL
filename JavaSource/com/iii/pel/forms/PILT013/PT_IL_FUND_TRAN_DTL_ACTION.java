package com.iii.pel.forms.PILT013;

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

public class PT_IL_FUND_TRAN_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FTD_FUND_CODE_LABEL;

	private HtmlInputText COMP_FTD_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_FTD_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FTD_FUND_DESC;

	private HtmlOutputLabel COMP_FTD_NO_OF_UNITS_LABEL;

	private HtmlInputText COMP_FTD_NO_OF_UNITS;

	private HtmlOutputLabel COMP_FTD_TOP_UP_UNITS_LABEL;

	private HtmlInputText COMP_FTD_TOP_UP_UNITS;

	private HtmlOutputLabel COMP_FTD_PREM_UNITS_LABEL;

	private HtmlInputText COMP_FTD_PREM_UNITS;

	private HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_LABEL;

	private HtmlInputText COMP_FTD_UNIT_SEL_PRICE;

	private HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_LABEL;

	private HtmlInputText COMP_FTD_UNIT_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_FTD_UNIT_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FTD_UNIT_LC_AMT;

	private PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN;

	public PILT013_COMPOSITE_ACTION compositeAction;

	private PT_IL_FUND_TRAN_DTL_HELPER helper;

	private List<PT_IL_FUND_TRAN_DTL> dataList_PT_IL_FUND_TRAN_DTL = new ArrayList<PT_IL_FUND_TRAN_DTL>();

	private UIData dataTable;

	public PT_IL_FUND_TRAN_DTL_ACTION() {

		PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
		helper = new PT_IL_FUND_TRAN_DTL_HELPER();
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

	public HtmlOutputLabel getCOMP_UI_M_FTD_FUND_DESC_LABEL() {
		return COMP_UI_M_FTD_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FTD_FUND_DESC() {
		return COMP_UI_M_FTD_FUND_DESC;
	}

	public void setCOMP_UI_M_FTD_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FTD_FUND_DESC_LABEL) {
		this.COMP_UI_M_FTD_FUND_DESC_LABEL = COMP_UI_M_FTD_FUND_DESC_LABEL;
	}

	public void setCOMP_UI_M_FTD_FUND_DESC(HtmlInputText COMP_UI_M_FTD_FUND_DESC) {
		this.COMP_UI_M_FTD_FUND_DESC = COMP_UI_M_FTD_FUND_DESC;
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

	public HtmlOutputLabel getCOMP_UI_M_FTD_UNIT_LC_AMT_LABEL() {
		return COMP_UI_M_FTD_UNIT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FTD_UNIT_LC_AMT() {
		return COMP_UI_M_FTD_UNIT_LC_AMT;
	}

	public void setCOMP_UI_M_FTD_UNIT_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_FTD_UNIT_LC_AMT_LABEL) {
		this.COMP_UI_M_FTD_UNIT_LC_AMT_LABEL = COMP_UI_M_FTD_UNIT_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_FTD_UNIT_LC_AMT(
			HtmlInputText COMP_UI_M_FTD_UNIT_LC_AMT) {
		this.COMP_UI_M_FTD_UNIT_LC_AMT = COMP_UI_M_FTD_UNIT_LC_AMT;
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
				resetSelectedRow();
			} else {
				throw new Exception(Messages.getString(
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
				PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
			} else {
				throw new Exception(Messages.getString(
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
			if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
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
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}

			} else if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()){
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
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}

			}

			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
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
			helper.POST_QUERY(compositeAction);
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_FUND_TRAN_DTL> PT_IL_FUND_TRAN_DTL_ITR = dataList_PT_IL_FUND_TRAN_DTL
				.iterator();
		while (PT_IL_FUND_TRAN_DTL_ITR.hasNext()) {
			PT_IL_FUND_TRAN_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_FTD_FUND_CODE.resetValue();
		COMP_UI_M_FTD_FUND_DESC.resetValue();
		COMP_FTD_NO_OF_UNITS.resetValue();
		COMP_FTD_TOP_UP_UNITS.resetValue();
		COMP_FTD_PREM_UNITS.resetValue();
		COMP_FTD_UNIT_SEL_PRICE.resetValue();
		COMP_FTD_UNIT_LC_AMT.resetValue();
		COMP_UI_M_FTD_UNIT_LC_AMT.resetValue();
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
			String message ="";
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
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
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.executeQuery(compositeAction);
				if(compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_BEAN().getROWID()!=null)
				helper.POST_QUERY(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

}
