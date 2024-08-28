package com.iii.pel.forms.PILP091_APAC;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PS_IL_CONT_PAID_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CPH_POL_NO_LABEL;

	private HtmlInputText COMP_CPH_POL_NO;

	private HtmlOutputLabel COMP_CPH_PA_PROFIT_LABEL;

	private HtmlInputText COMP_CPH_PA_PROFIT;

	private HtmlOutputLabel COMP_CPH_GFTA_PROFIT_LABEL;

	private HtmlInputText COMP_CPH_GFTA_PROFIT;

	private HtmlOutputLabel COMP_CPH_SUSP_PROFIT_LABEL;

	private HtmlInputText COMP_CPH_SUSP_PROFIT;

	private HtmlOutputLabel COMP_CPH_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_CPH_ACNT_YEAR;

	private HtmlOutputLabel COMP_CPH_FREEZE_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CPH_FREEZE_FLAG;

	private HtmlOutputLabel COMP_CPH_CONFIRM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_CPH_CONFIRM_FLAG;

	private PS_IL_CONT_PAID_HDR PS_IL_CONT_PAID_HDR_BEAN;

	public PILP091_APAC_COMPOSITE_ACTION compositeAction;

	private PS_IL_CONT_PAID_HDR_HELPER helper;

	private List<PS_IL_CONT_PAID_HDR> dataList_PS_IL_CONT_PAID_HDR = new ArrayList<PS_IL_CONT_PAID_HDR>();

	private UIData dataTable;

	private List<SelectItem> listCPH_FREEZE_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listCPH_CONFIRM_FLAG = new ArrayList<SelectItem>();

	private String DEFAULT_WHERE;

	public PS_IL_CONT_PAID_HDR_ACTION() {

		PS_IL_CONT_PAID_HDR_BEAN = new PS_IL_CONT_PAID_HDR();
		helper = new PS_IL_CONT_PAID_HDR_HELPER();
		prepareDropDownList();
	}

	public HtmlOutputLabel getCOMP_CPH_POL_NO_LABEL() {
		return COMP_CPH_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_CPH_POL_NO() {
		return COMP_CPH_POL_NO;
	}

	public void setCOMP_CPH_POL_NO_LABEL(HtmlOutputLabel COMP_CPH_POL_NO_LABEL) {
		this.COMP_CPH_POL_NO_LABEL = COMP_CPH_POL_NO_LABEL;
	}

	public void setCOMP_CPH_POL_NO(HtmlInputText COMP_CPH_POL_NO) {
		this.COMP_CPH_POL_NO = COMP_CPH_POL_NO;
	}

	public HtmlOutputLabel getCOMP_CPH_PA_PROFIT_LABEL() {
		return COMP_CPH_PA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPH_PA_PROFIT() {
		return COMP_CPH_PA_PROFIT;
	}

	public void setCOMP_CPH_PA_PROFIT_LABEL(
			HtmlOutputLabel COMP_CPH_PA_PROFIT_LABEL) {
		this.COMP_CPH_PA_PROFIT_LABEL = COMP_CPH_PA_PROFIT_LABEL;
	}

	public void setCOMP_CPH_PA_PROFIT(HtmlInputText COMP_CPH_PA_PROFIT) {
		this.COMP_CPH_PA_PROFIT = COMP_CPH_PA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPH_GFTA_PROFIT_LABEL() {
		return COMP_CPH_GFTA_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPH_GFTA_PROFIT() {
		return COMP_CPH_GFTA_PROFIT;
	}

	public void setCOMP_CPH_GFTA_PROFIT_LABEL(
			HtmlOutputLabel COMP_CPH_GFTA_PROFIT_LABEL) {
		this.COMP_CPH_GFTA_PROFIT_LABEL = COMP_CPH_GFTA_PROFIT_LABEL;
	}

	public void setCOMP_CPH_GFTA_PROFIT(HtmlInputText COMP_CPH_GFTA_PROFIT) {
		this.COMP_CPH_GFTA_PROFIT = COMP_CPH_GFTA_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPH_SUSP_PROFIT_LABEL() {
		return COMP_CPH_SUSP_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_CPH_SUSP_PROFIT() {
		return COMP_CPH_SUSP_PROFIT;
	}

	public void setCOMP_CPH_SUSP_PROFIT_LABEL(
			HtmlOutputLabel COMP_CPH_SUSP_PROFIT_LABEL) {
		this.COMP_CPH_SUSP_PROFIT_LABEL = COMP_CPH_SUSP_PROFIT_LABEL;
	}

	public void setCOMP_CPH_SUSP_PROFIT(HtmlInputText COMP_CPH_SUSP_PROFIT) {
		this.COMP_CPH_SUSP_PROFIT = COMP_CPH_SUSP_PROFIT;
	}

	public HtmlOutputLabel getCOMP_CPH_ACNT_YEAR_LABEL() {
		return COMP_CPH_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_CPH_ACNT_YEAR() {
		return COMP_CPH_ACNT_YEAR;
	}

	public void setCOMP_CPH_ACNT_YEAR_LABEL(
			HtmlOutputLabel COMP_CPH_ACNT_YEAR_LABEL) {
		this.COMP_CPH_ACNT_YEAR_LABEL = COMP_CPH_ACNT_YEAR_LABEL;
	}

	public void setCOMP_CPH_ACNT_YEAR(HtmlInputText COMP_CPH_ACNT_YEAR) {
		this.COMP_CPH_ACNT_YEAR = COMP_CPH_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_CPH_FREEZE_FLAG_LABEL() {
		return COMP_CPH_FREEZE_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CPH_FREEZE_FLAG() {
		return COMP_CPH_FREEZE_FLAG;
	}

	public void setCOMP_CPH_FREEZE_FLAG_LABEL(
			HtmlOutputLabel COMP_CPH_FREEZE_FLAG_LABEL) {
		this.COMP_CPH_FREEZE_FLAG_LABEL = COMP_CPH_FREEZE_FLAG_LABEL;
	}

	public void setCOMP_CPH_FREEZE_FLAG(HtmlSelectOneMenu COMP_CPH_FREEZE_FLAG) {
		this.COMP_CPH_FREEZE_FLAG = COMP_CPH_FREEZE_FLAG;
	}

	public HtmlOutputLabel getCOMP_CPH_CONFIRM_FLAG_LABEL() {
		return COMP_CPH_CONFIRM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CPH_CONFIRM_FLAG() {
		return COMP_CPH_CONFIRM_FLAG;
	}

	public void setCOMP_CPH_CONFIRM_FLAG_LABEL(
			HtmlOutputLabel COMP_CPH_CONFIRM_FLAG_LABEL) {
		this.COMP_CPH_CONFIRM_FLAG_LABEL = COMP_CPH_CONFIRM_FLAG_LABEL;
	}

	public void setCOMP_CPH_CONFIRM_FLAG(HtmlSelectOneMenu COMP_CPH_CONFIRM_FLAG) {
		this.COMP_CPH_CONFIRM_FLAG = COMP_CPH_CONFIRM_FLAG;
	}

	public PS_IL_CONT_PAID_HDR getPS_IL_CONT_PAID_HDR_BEAN() {
		return PS_IL_CONT_PAID_HDR_BEAN;
	}

	public void setPS_IL_CONT_PAID_HDR_BEAN(
			PS_IL_CONT_PAID_HDR PS_IL_CONT_PAID_HDR_BEAN) {
		this.PS_IL_CONT_PAID_HDR_BEAN = PS_IL_CONT_PAID_HDR_BEAN;
	}

	public List<PS_IL_CONT_PAID_HDR> getDataList_PS_IL_CONT_PAID_HDR() {
		return dataList_PS_IL_CONT_PAID_HDR;
	}

	public void setDataListPS_IL_CONT_PAID_HDR(
			List<PS_IL_CONT_PAID_HDR> dataList_PS_IL_CONT_PAID_HDR) {
		this.dataList_PS_IL_CONT_PAID_HDR = dataList_PS_IL_CONT_PAID_HDR;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PS_IL_CONT_PAID_HDR_BEAN = new PS_IL_CONT_PAID_HDR();
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

				new CRUDHandler().executeDelete(PS_IL_CONT_PAID_HDR_BEAN,
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
				dataList_PS_IL_CONT_PAID_HDR.remove(PS_IL_CONT_PAID_HDR_BEAN);
				if (dataList_PS_IL_CONT_PAID_HDR.size() > 0) {

					PS_IL_CONT_PAID_HDR_BEAN = dataList_PS_IL_CONT_PAID_HDR
							.get(0);
				} else if (dataList_PS_IL_CONT_PAID_HDR.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PS_IL_CONT_PAID_HDR_BEAN.setRowSelected(true);
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
			if (PS_IL_CONT_PAID_HDR_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PS_IL_CONT_PAID_HDR_BEAN,
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
				dataList_PS_IL_CONT_PAID_HDR.add(PS_IL_CONT_PAID_HDR_BEAN);
				}
				else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PS_IL_CONT_PAID_HDR_BEAN.getROWID() != null){
			   if(isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PS_IL_CONT_PAID_HDR_BEAN,
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
			   else{
				   throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
			   }

			PS_IL_CONT_PAID_HDR_BEAN.setRowSelected(true);
		} 
		}catch (Exception exc) {
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
			PS_IL_CONT_PAID_HDR_BEAN = (PS_IL_CONT_PAID_HDR) dataTable
					.getRowData();
			PS_IL_CONT_PAID_HDR_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PS_IL_CONT_PAID_HDR> PS_IL_CONT_PAID_HDR_ITR = dataList_PS_IL_CONT_PAID_HDR
				.iterator();
		while (PS_IL_CONT_PAID_HDR_ITR.hasNext()) {
			PS_IL_CONT_PAID_HDR_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CPH_POL_NO.resetValue();
		COMP_CPH_PA_PROFIT.resetValue();
		COMP_CPH_GFTA_PROFIT.resetValue();
		COMP_CPH_SUSP_PROFIT.resetValue();
		COMP_CPH_ACNT_YEAR.resetValue();
		COMP_CPH_FREEZE_FLAG.resetValue();
		COMP_CPH_CONFIRM_FLAG.resetValue();
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
			Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListCPH_FREEZE_FLAG() {
		if (listCPH_FREEZE_FLAG.size() == 0) {
			listCPH_FREEZE_FLAG.clear();
			try {
				listCPH_FREEZE_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCPH_FREEZE_FLAG;
	}

	public void setListCPH_FREEZE_FLAG(List<SelectItem> listCPH_FREEZE_FLAG) {
		this.listCPH_FREEZE_FLAG = listCPH_FREEZE_FLAG;
	}

	public List<SelectItem> getListCPH_CONFIRM_FLAG() {
		if (listCPH_CONFIRM_FLAG.size() == 0) {
			listCPH_CONFIRM_FLAG.clear();
			try {
				listCPH_CONFIRM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCPH_CONFIRM_FLAG;
	}

	public void setListCPH_CONFIRM_FLAG(List<SelectItem> listCPH_CONFIRM_FLAG) {
		this.listCPH_CONFIRM_FLAG = listCPH_CONFIRM_FLAG;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	private void prepareDropDownList() {

		try {
			setListCPH_CONFIRM_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP091_APAC",
					"PS_IL_CONT_PAID_HDR",
					"PS_IL_CONT_PAID_HDR.CPH_CONFIRM_FLAG", "YESNO"));
			setListCPH_FREEZE_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP091_APAC",
					"PS_IL_CONT_PAID_HDR",
					"PS_IL_CONT_PAID_HDR.CPH_CONFIRM_FLAG", "YESNO"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.WHEN_NEW_FORM_INSTANCE(compositeAction);
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				//helper.executeQuery(compositeAction);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_SELECT_ALL().setValue("Select All");
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

}
