package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_FUND_TRAN_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FTD_FUND_CODE_LABEL;

	private HtmlInputText COMP_FTD_FUND_CODE;

	private HtmlOutputLabel COMP_FTD_NO_OF_UNITS_LABEL;

	private HtmlInputText COMP_FTD_NO_OF_UNITS;

	private HtmlOutputLabel COMP_FTD_PREM_UNITS_LABEL;

	private HtmlInputText COMP_FTD_PREM_UNITS;

	private HtmlOutputLabel COMP_FTD_TOP_UP_UNITS_LABEL;

	private HtmlInputText COMP_FTD_TOP_UP_UNITS;

	private HtmlOutputLabel COMP_FTD_SELECT_YN_LABEL;

	private HtmlSelectOneMenu COMP_FTD_SELECT_YN;

	private HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_LABEL;

	private HtmlInputText COMP_FTD_UNIT_SEL_PRICE;

	private HtmlOutputLabel COMP_FTD_FUND_PERC_LABEL;

	private HtmlInputText COMP_FTD_FUND_PERC;

	private HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_LABEL;

	private HtmlInputText COMP_FTD_UNIT_LC_AMT;

	private HtmlOutputLabel COMP_FTD_PREM_SEL_UNITS_LABEL;

	private HtmlInputText COMP_FTD_PREM_SEL_UNITS;

	private HtmlOutputLabel COMP_FTD_TOP_UP_SEL_UNITS_LABEL;

	private HtmlInputText COMP_FTD_TOP_UP_SEL_UNITS;

	private HtmlOutputLabel COMP_FTD_NO_SEL_UNITS_LABEL;

	private HtmlInputText COMP_FTD_NO_SEL_UNITS;

	private HtmlOutputLabel COMP_FTD_NO_ALLOC_LC_AMT_LABEL;

	private HtmlInputText COMP_FTD_NO_ALLOC_LC_AMT;

	private HtmlOutputLabel COMP_FTD_WITHDRAWAL_BY_LABEL;

	private HtmlSelectOneMenu COMP_FTD_WITHDRAWAL_BY;

	private HtmlOutputLabel COMP_UI_M_FTD_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FTD_FUND_DESC;

	private PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private PT_IL_FUND_TRAN_DTL_HELPER helper;
	
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_DEL_ROW;
	private HtmlAjaxCommandButton COMP_POST_ROW;

	private List<PT_IL_FUND_TRAN_DTL> dataList_PT_IL_FUND_TRAN_DTL = new ArrayList<PT_IL_FUND_TRAN_DTL>();

	private UIData dataTable;

	private List<SelectItem> listFTD_SELECT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listFTD_WITHDRAWAL_BY = new ArrayList<SelectItem>();

	Connection connection = null;

	PT_IL_WITHDRAWAL pt_il_withdrawal;

	DUMMY dummy;

	private String DEFAULT_WHERE;

	public PT_IL_FUND_TRAN_DTL_ACTION() {
		PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
		helper = new PT_IL_FUND_TRAN_DTL_HELPER();
		populateDropDowns();
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

	public HtmlOutputLabel getCOMP_FTD_SELECT_YN_LABEL() {
		return COMP_FTD_SELECT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FTD_SELECT_YN() {
		return COMP_FTD_SELECT_YN;
	}

	public void setCOMP_FTD_SELECT_YN_LABEL(
			HtmlOutputLabel COMP_FTD_SELECT_YN_LABEL) {
		this.COMP_FTD_SELECT_YN_LABEL = COMP_FTD_SELECT_YN_LABEL;
	}

	public void setCOMP_FTD_SELECT_YN(HtmlSelectOneMenu COMP_FTD_SELECT_YN) {
		this.COMP_FTD_SELECT_YN = COMP_FTD_SELECT_YN;
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

	public HtmlOutputLabel getCOMP_FTD_FUND_PERC_LABEL() {
		return COMP_FTD_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FTD_FUND_PERC() {
		return COMP_FTD_FUND_PERC;
	}

	public void setCOMP_FTD_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_FTD_FUND_PERC_LABEL) {
		this.COMP_FTD_FUND_PERC_LABEL = COMP_FTD_FUND_PERC_LABEL;
	}

	public void setCOMP_FTD_FUND_PERC(HtmlInputText COMP_FTD_FUND_PERC) {
		this.COMP_FTD_FUND_PERC = COMP_FTD_FUND_PERC;
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

	public HtmlOutputLabel getCOMP_FTD_PREM_SEL_UNITS_LABEL() {
		return COMP_FTD_PREM_SEL_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_PREM_SEL_UNITS() {
		return COMP_FTD_PREM_SEL_UNITS;
	}

	public void setCOMP_FTD_PREM_SEL_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_PREM_SEL_UNITS_LABEL) {
		this.COMP_FTD_PREM_SEL_UNITS_LABEL = COMP_FTD_PREM_SEL_UNITS_LABEL;
	}

	public void setCOMP_FTD_PREM_SEL_UNITS(HtmlInputText COMP_FTD_PREM_SEL_UNITS) {
		this.COMP_FTD_PREM_SEL_UNITS = COMP_FTD_PREM_SEL_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_TOP_UP_SEL_UNITS_LABEL() {
		return COMP_FTD_TOP_UP_SEL_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_TOP_UP_SEL_UNITS() {
		return COMP_FTD_TOP_UP_SEL_UNITS;
	}

	public void setCOMP_FTD_TOP_UP_SEL_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_TOP_UP_SEL_UNITS_LABEL) {
		this.COMP_FTD_TOP_UP_SEL_UNITS_LABEL = COMP_FTD_TOP_UP_SEL_UNITS_LABEL;
	}

	public void setCOMP_FTD_TOP_UP_SEL_UNITS(
			HtmlInputText COMP_FTD_TOP_UP_SEL_UNITS) {
		this.COMP_FTD_TOP_UP_SEL_UNITS = COMP_FTD_TOP_UP_SEL_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_SEL_UNITS_LABEL() {
		return COMP_FTD_NO_SEL_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_NO_SEL_UNITS() {
		return COMP_FTD_NO_SEL_UNITS;
	}

	public void setCOMP_FTD_NO_SEL_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_NO_SEL_UNITS_LABEL) {
		this.COMP_FTD_NO_SEL_UNITS_LABEL = COMP_FTD_NO_SEL_UNITS_LABEL;
	}

	public void setCOMP_FTD_NO_SEL_UNITS(HtmlInputText COMP_FTD_NO_SEL_UNITS) {
		this.COMP_FTD_NO_SEL_UNITS = COMP_FTD_NO_SEL_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_ALLOC_LC_AMT_LABEL() {
		return COMP_FTD_NO_ALLOC_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FTD_NO_ALLOC_LC_AMT() {
		return COMP_FTD_NO_ALLOC_LC_AMT;
	}

	public void setCOMP_FTD_NO_ALLOC_LC_AMT_LABEL(
			HtmlOutputLabel COMP_FTD_NO_ALLOC_LC_AMT_LABEL) {
		this.COMP_FTD_NO_ALLOC_LC_AMT_LABEL = COMP_FTD_NO_ALLOC_LC_AMT_LABEL;
	}

	public void setCOMP_FTD_NO_ALLOC_LC_AMT(
			HtmlInputText COMP_FTD_NO_ALLOC_LC_AMT) {
		this.COMP_FTD_NO_ALLOC_LC_AMT = COMP_FTD_NO_ALLOC_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_FTD_WITHDRAWAL_BY_LABEL() {
		return COMP_FTD_WITHDRAWAL_BY_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FTD_WITHDRAWAL_BY() {
		return COMP_FTD_WITHDRAWAL_BY;
	}

	public void setCOMP_FTD_WITHDRAWAL_BY_LABEL(
			HtmlOutputLabel COMP_FTD_WITHDRAWAL_BY_LABEL) {
		this.COMP_FTD_WITHDRAWAL_BY_LABEL = COMP_FTD_WITHDRAWAL_BY_LABEL;
	}

	public void setCOMP_FTD_WITHDRAWAL_BY(
			HtmlSelectOneMenu COMP_FTD_WITHDRAWAL_BY) {
		this.COMP_FTD_WITHDRAWAL_BY = COMP_FTD_WITHDRAWAL_BY;
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
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(PT_IL_FUND_TRAN_DTL_BEAN);
				PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
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
		CommonUtils.clearMaps(this);
		try {
			if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
               
				helper.preInsert(PT_IL_FUND_TRAN_DTL_BEAN,compositeAction);
				
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				dataList_PT_IL_FUND_TRAN_DTL.add(PT_IL_FUND_TRAN_DTL_BEAN);
			} else if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

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
			PT_IL_FUND_TRAN_DTL_BEAN = (PT_IL_FUND_TRAN_DTL)dataTable.getRowData();
			/*helper.postQuery(this, pt_il_withdrawal.getWD_TYPE(),
					pt_il_withdrawal.getWD_AMOUNT_YN());*/
			//helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
			resetAllComponent();
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
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
		COMP_FTD_NO_OF_UNITS.resetValue();
		COMP_FTD_PREM_UNITS.resetValue();
		COMP_FTD_TOP_UP_UNITS.resetValue();
		COMP_FTD_SELECT_YN.resetValue();
		COMP_FTD_UNIT_SEL_PRICE.resetValue();
		COMP_FTD_FUND_PERC.resetValue();
		COMP_FTD_UNIT_LC_AMT.resetValue();
		COMP_FTD_PREM_SEL_UNITS.resetValue();
		COMP_FTD_TOP_UP_SEL_UNITS.resetValue();
		COMP_FTD_NO_SEL_UNITS.resetValue();
		COMP_FTD_NO_ALLOC_LC_AMT.resetValue();
		COMP_FTD_WITHDRAWAL_BY.resetValue();
		COMP_UI_M_FTD_FUND_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			PT_IL_WITHDRAWAL_HELPER withdrawlhelper = new PT_IL_WITHDRAWAL_HELPER();
			CommonUtils.clearMaps(this);
			//withdrawlhelper.key_Commit(compositeAction);
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	private void populateDropDowns() {
		try {
			connection = CommonUtils.getConnection();

			listFTD_SELECT_YN = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_FUND_TRAN_DTL", "PT_IL_FUND_TRAN_DTL.FTD_SELECT_YN",
			"YESNO");
			listFTD_WITHDRAWAL_BY = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_FUND_TRAN_DTL",
					"PT_IL_FUND_TRAN_DTL.FTD_WITHDRAWAL_BY", "IL_WD_BY");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getListFTD_SELECT_YN() {
		if (listFTD_SELECT_YN.size() == 0) {
			listFTD_SELECT_YN.clear();
			try {
				listFTD_SELECT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listFTD_SELECT_YN;
	}

	public void setListFTD_SELECT_YN(List<SelectItem> listFTD_SELECT_YN) {
		this.listFTD_SELECT_YN = listFTD_SELECT_YN;
	}

	public List<SelectItem> getListFTD_WITHDRAWAL_BY() {
		if (listFTD_WITHDRAWAL_BY.size() == 0) {
			listFTD_WITHDRAWAL_BY.clear();
			try {
				listFTD_WITHDRAWAL_BY = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listFTD_WITHDRAWAL_BY;
	}

	public void setListFTD_WITHDRAWAL_BY(List<SelectItem> listFTD_WITHDRAWAL_BY) {
		this.listFTD_WITHDRAWAL_BY = listFTD_WITHDRAWAL_BY;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*Added by Janani on 16.08.2017 for ZBILQC-1727639*/
	PILT021_PROCEDURES pilt021_procedures = new PILT021_PROCEDURES();
	/*End*/
	
	public void onLoad(PhaseEvent event) {
		try {
			PT_IL_WITHDRAWAL pt_il_withdrawal = compositeAction
			.getPT_IL_WITHDRAWAL_ACTION_BEAN()
			.getPT_IL_WITHDRAWAL_BEAN();
			DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			if (isBlockFlag()) {
				//[ADDED BY AKASH TO SET BASE CURRENCY INTO DUMMY BEAN DATED 07-MAY-2013.
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().
					setUI_M_BASE_CURR(CommonUtils.getControlBean().getM_BASE_CURR());
				//helper.WHEN_NEW_BLOCK_INSTANCE(pt_il_withdrawal, dummy.getUI_M_POL_SYS_ID(), this);
				helper.preQuery(this, pt_il_withdrawal);
				helper.executeQuery(compositeAction);
				if(PT_IL_FUND_TRAN_DTL_BEAN.getROWID() != null){
					helper.postQuery(this, pt_il_withdrawal.getWD_TYPE(),
							pt_il_withdrawal.getWD_AMOUNT_YN());
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				
				/*Added by Janani on 16.08.2017 for ZBILQC-1727639*/
				pilt021_procedures.L_ENABLE_DISABLE_ITEM(this);
				/*End*/
				
				
				setBlockFlag(false);
			}
			if("A".equals(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS())){
				disableAllComponent(true);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void onFTD_SELECT_YNChange(ActionEvent event){
		UIInput input=(UIInput)event.getComponent().getParent();
		try {
			helper.WHEN_FTD_SELECT_YN_LIST_CHANGED(this, 
					compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN(), compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onFTD_SELECT_YNChange", e.getMessage());
		}
		ErrorHelpUtil.validate(input,getErrorMap());
	}

	public void onFTD_WITHDRAWAL_BY(ActionEvent event){
		UIInput input=(UIInput)event.getComponent().getParent();
		/*try {
			helper.WHEN_FTD_WITHDRAWL_BY_LIST_CHANGED(this);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onFTD_WITHDRAWAL_BY", e.getMessage());
		}*/
		ErrorHelpUtil.validate(input,getErrorMap());
	}
	public void validateFTD_WITHDRAWL_BY(FacesContext context, UIComponent component, Object value) {
		try{
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_WITHDRAWAL_BY((String) value);
			helper.WHEN_VALIDATE_FTD_WITHDRAWL_BY(this);
		}catch (Exception e) {
			e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateFTD_FUND_PERC(FacesContext context, UIComponent component, Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_FUND_PERC((Double) value);
			pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_FTD_FUND_PERC(this, (Double) value, pt_il_withdrawal, dummy);
			COMP_FTD_PREM_SEL_UNITS.resetValue();
			COMP_FTD_TOP_UP_SEL_UNITS.resetValue();
			COMP_FTD_NO_SEL_UNITS.resetValue();
			COMP_FTD_NO_ALLOC_LC_AMT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateFTD_PREM_SEL_UNITS(FacesContext context, UIComponent component, Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_PREM_SEL_UNITS((Double) value);
			pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_FTD_PREM_SEL_UNITS(this, (Double) value, pt_il_withdrawal, dummy);
			COMP_FTD_NO_ALLOC_LC_AMT.resetValue();
			COMP_FTD_FUND_PERC.resetValue();
			COMP_FTD_NO_SEL_UNITS.resetValue();
			
			/*Added by Janani on 17.08.2017 for ZBILQC-1727639*/
			COMP_FTD_PREM_SEL_UNITS.resetValue();
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateFTD_SELECT_YN(FacesContext context, UIComponent component, Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_SELECT_YN((String) value);
			pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_FTD_SELECT_YN((String) value, this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateFTD_TOP_UP_SEL_UNITS(FacesContext context, UIComponent component, Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TOP_UP_SEL_UNITS((Double) value);
			pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_FTD_TOP_UP_SEL_UNITS(this, (Double) value, pt_il_withdrawal, dummy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateFTD_NO_ALLOC_LC_AMT(FacesContext context, UIComponent component, Object value) {
		try {
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_NO_ALLOC_LC_AMT((Double) value);
			pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_FTD_NO_ALLOC_LC_AMT((Double) value, pt_il_withdrawal, this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}
	
	private void  disableAllComponent(boolean disabled){
		COMP_FTD_FUND_CODE.setDisabled(disabled);
		COMP_FTD_NO_OF_UNITS.setDisabled(disabled);
		COMP_FTD_WITHDRAWAL_BY.setDisabled(disabled);
		COMP_FTD_PREM_UNITS.setDisabled(disabled);
		COMP_FTD_TOP_UP_UNITS.setDisabled(disabled);
		COMP_FTD_SELECT_YN.setDisabled(disabled);
		COMP_FTD_UNIT_SEL_PRICE.setDisabled(disabled);
		COMP_FTD_FUND_PERC.setDisabled(disabled);
		COMP_FTD_UNIT_LC_AMT.setDisabled(disabled);
		COMP_FTD_PREM_SEL_UNITS.setDisabled(disabled);
		COMP_FTD_TOP_UP_SEL_UNITS.setDisabled(disabled);
		COMP_FTD_NO_SEL_UNITS.setDisabled(disabled);
		COMP_FTD_NO_ALLOC_LC_AMT.setDisabled(disabled);
		COMP_UI_M_FTD_FUND_DESC.setDisabled(disabled);
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
		
		/*Added by ganesh for hands on feedback on 11-05-2017 */
		COMP_FTD_FUND_SAVE.setDisabled(disabled);
		COMP_FTD_FUND_SAVE_DOWN.setDisabled(disabled);
		/*end*/
	}

	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}

	public HtmlAjaxCommandButton getCOMP_DEL_ROW() {
		return COMP_DEL_ROW;
	}

	public void setCOMP_DEL_ROW(HtmlAjaxCommandButton comp_del_row) {
		COMP_DEL_ROW = comp_del_row;
	}

	public HtmlAjaxCommandButton getCOMP_POST_ROW() {
		return COMP_POST_ROW;
	}

	public void setCOMP_POST_ROW(HtmlAjaxCommandButton comp_post_row) {
		COMP_POST_ROW = comp_post_row;
	}

	/* Added by ganesh on 11-05-2017 for hands on feedback*/
	private HtmlCommandLink COMP_FTD_FUND_SAVE;

	public HtmlCommandLink getCOMP_FTD_FUND_SAVE() {
		return COMP_FTD_FUND_SAVE;
	}

	public void setCOMP_FTD_FUND_SAVE(HtmlCommandLink cOMP_FTD_FUND_SAVE) {
		COMP_FTD_FUND_SAVE = cOMP_FTD_FUND_SAVE;
	}
	
	private HtmlCommandLink COMP_FTD_FUND_SAVE_DOWN;

	public HtmlCommandLink getCOMP_FTD_FUND_SAVE_DOWN() {
		return COMP_FTD_FUND_SAVE_DOWN;
	}

	public void setCOMP_FTD_FUND_SAVE_DOWN(HtmlCommandLink cOMP_FTD_FUND_SAVE_DOWN) {
		COMP_FTD_FUND_SAVE_DOWN = cOMP_FTD_FUND_SAVE_DOWN;
	}
	
	
	/*end*/
}
