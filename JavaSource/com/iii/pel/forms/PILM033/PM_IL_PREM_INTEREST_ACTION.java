package com.iii.pel.forms.PILM033;

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
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PREM_INTEREST_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PI_MOP_LABEL;

	private HtmlSelectOneMenu COMP_PI_MOP;

	private HtmlOutputLabel COMP_PI_UPTO_MNTH_LABEL;

	private HtmlInputText COMP_PI_UPTO_MNTH;

	private HtmlOutputLabel COMP_PI_UPTO_DAYS_LABEL;

	private HtmlInputText COMP_PI_UPTO_DAYS;

	private HtmlOutputLabel COMP_PI_RATE_LABEL;

	private HtmlInputText COMP_PI_RATE;

	private HtmlOutputLabel COMP_PI_RATE_PER_LABEL;

	private HtmlInputText COMP_PI_RATE_PER;

	private HtmlOutputLabel COMP_PI_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_PI_EFF_FM_DT;

	private HtmlOutputLabel COMP_PI_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_PI_EFF_TO_DT;

	private PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN;

	public PILM033_COMPOSITE_ACTION compositeAction;

	private PM_IL_PREM_INTEREST_HELPER helper;

	private List<PM_IL_PREM_INTEREST> dataList_PM_IL_PREM_INTEREST = new ArrayList<PM_IL_PREM_INTEREST>();

	private List<SelectItem> listPI_MOP = new ArrayList<SelectItem>();
	
	private UIData dataTable;

	public PM_IL_PREM_INTEREST_ACTION() {

		PM_IL_PREM_INTEREST_BEAN = new PM_IL_PREM_INTEREST();
		
		helper = new PM_IL_PREM_INTEREST_HELPER();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			setListPI_MOP(ListItemUtil.getDropDownListValue(
					connection, "PILM033", "PM_IL_PREM_INTEREST",
					"PM_IL_PREM_INTEREST.PI_MOP", "PYMT_MODE"));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_PI_MOP_LABEL() {
		return COMP_PI_MOP_LABEL;
	}

	 
	public void setCOMP_PI_MOP_LABEL(HtmlOutputLabel COMP_PI_MOP_LABEL) {
		this.COMP_PI_MOP_LABEL = COMP_PI_MOP_LABEL;
	}
 
	public HtmlOutputLabel getCOMP_PI_UPTO_MNTH_LABEL() {
		return COMP_PI_UPTO_MNTH_LABEL;
	}

	public HtmlInputText getCOMP_PI_UPTO_MNTH() {
		return COMP_PI_UPTO_MNTH;
	}

	public void setCOMP_PI_UPTO_MNTH_LABEL(
			HtmlOutputLabel COMP_PI_UPTO_MNTH_LABEL) {
		this.COMP_PI_UPTO_MNTH_LABEL = COMP_PI_UPTO_MNTH_LABEL;
	}

	public void setCOMP_PI_UPTO_MNTH(HtmlInputText COMP_PI_UPTO_MNTH) {
		this.COMP_PI_UPTO_MNTH = COMP_PI_UPTO_MNTH;
	}

	public HtmlOutputLabel getCOMP_PI_UPTO_DAYS_LABEL() {
		return COMP_PI_UPTO_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PI_UPTO_DAYS() {
		return COMP_PI_UPTO_DAYS;
	}

	public void setCOMP_PI_UPTO_DAYS_LABEL(
			HtmlOutputLabel COMP_PI_UPTO_DAYS_LABEL) {
		this.COMP_PI_UPTO_DAYS_LABEL = COMP_PI_UPTO_DAYS_LABEL;
	}

	public void setCOMP_PI_UPTO_DAYS(HtmlInputText COMP_PI_UPTO_DAYS) {
		this.COMP_PI_UPTO_DAYS = COMP_PI_UPTO_DAYS;
	}

	public HtmlOutputLabel getCOMP_PI_RATE_LABEL() {
		return COMP_PI_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PI_RATE() {
		return COMP_PI_RATE;
	}

	public void setCOMP_PI_RATE_LABEL(HtmlOutputLabel COMP_PI_RATE_LABEL) {
		this.COMP_PI_RATE_LABEL = COMP_PI_RATE_LABEL;
	}

	public void setCOMP_PI_RATE(HtmlInputText COMP_PI_RATE) {
		this.COMP_PI_RATE = COMP_PI_RATE;
	}

	public HtmlOutputLabel getCOMP_PI_RATE_PER_LABEL() {
		return COMP_PI_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PI_RATE_PER() {
		return COMP_PI_RATE_PER;
	}

	public void setCOMP_PI_RATE_PER_LABEL(HtmlOutputLabel COMP_PI_RATE_PER_LABEL) {
		this.COMP_PI_RATE_PER_LABEL = COMP_PI_RATE_PER_LABEL;
	}

	public void setCOMP_PI_RATE_PER(HtmlInputText COMP_PI_RATE_PER) {
		this.COMP_PI_RATE_PER = COMP_PI_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PI_EFF_FM_DT_LABEL() {
		return COMP_PI_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PI_EFF_FM_DT() {
		return COMP_PI_EFF_FM_DT;
	}

	public void setCOMP_PI_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_PI_EFF_FM_DT_LABEL) {
		this.COMP_PI_EFF_FM_DT_LABEL = COMP_PI_EFF_FM_DT_LABEL;
	}

	public void setCOMP_PI_EFF_FM_DT(HtmlCalendar COMP_PI_EFF_FM_DT) {
		this.COMP_PI_EFF_FM_DT = COMP_PI_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_PI_EFF_TO_DT_LABEL() {
		return COMP_PI_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PI_EFF_TO_DT() {
		return COMP_PI_EFF_TO_DT;
	}

	public void setCOMP_PI_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_PI_EFF_TO_DT_LABEL) {
		this.COMP_PI_EFF_TO_DT_LABEL = COMP_PI_EFF_TO_DT_LABEL;
	}

	public void setCOMP_PI_EFF_TO_DT(HtmlCalendar COMP_PI_EFF_TO_DT) {
		this.COMP_PI_EFF_TO_DT = COMP_PI_EFF_TO_DT;
	}

	public PM_IL_PREM_INTEREST getPM_IL_PREM_INTEREST_BEAN() {
		return PM_IL_PREM_INTEREST_BEAN;
	}

	public void setPM_IL_PREM_INTEREST_BEAN(
			PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN) {
		this.PM_IL_PREM_INTEREST_BEAN = PM_IL_PREM_INTEREST_BEAN;
	}

	public List<PM_IL_PREM_INTEREST> getDataList_PM_IL_PREM_INTEREST() {
		return dataList_PM_IL_PREM_INTEREST;
	}

	public void setDataListPM_IL_PREM_INTEREST(
			List<PM_IL_PREM_INTEREST> dataList_PM_IL_PREM_INTEREST) {
		this.dataList_PM_IL_PREM_INTEREST = dataList_PM_IL_PREM_INTEREST;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_PREM_INTEREST_BEAN = new PM_IL_PREM_INTEREST();
				helper.whenCreateRecord(PM_IL_PREM_INTEREST_BEAN);
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

				new CRUDHandler().executeDelete(PM_IL_PREM_INTEREST_BEAN,
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
				dataList_PM_IL_PREM_INTEREST.remove(PM_IL_PREM_INTEREST_BEAN);
				if (dataList_PM_IL_PREM_INTEREST.size() > 0) {

					PM_IL_PREM_INTEREST_BEAN = dataList_PM_IL_PREM_INTEREST
							.get(0);
				} else if (dataList_PM_IL_PREM_INTEREST.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PREM_INTEREST_BEAN.setRowSelected(true);
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
			if (PM_IL_PREM_INTEREST_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PM_IL_PREM_INTEREST_BEAN);
				new CRUDHandler().executeInsert(PM_IL_PREM_INTEREST_BEAN,
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
				dataList_PM_IL_PREM_INTEREST.add(PM_IL_PREM_INTEREST_BEAN);
			} else if (PM_IL_PREM_INTEREST_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_PREM_INTEREST_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_PREM_INTEREST_BEAN,
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

			PM_IL_PREM_INTEREST_BEAN.setRowSelected(true);
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
			PM_IL_PREM_INTEREST_BEAN = (PM_IL_PREM_INTEREST) dataTable
					.getRowData();
			PM_IL_PREM_INTEREST_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PREM_INTEREST> PM_IL_PREM_INTEREST_ITR = dataList_PM_IL_PREM_INTEREST
				.iterator();
		while (PM_IL_PREM_INTEREST_ITR.hasNext()) {
			PM_IL_PREM_INTEREST_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PI_MOP.resetValue();
		COMP_PI_UPTO_MNTH.resetValue();
		COMP_PI_UPTO_DAYS.resetValue();
		COMP_PI_RATE.resetValue();
		COMP_PI_RATE_PER.resetValue();
		COMP_PI_EFF_FM_DT.resetValue();
		COMP_PI_EFF_TO_DT.resetValue();
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
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public List<SelectItem> getListPI_MOP() {
		if (listPI_MOP.size() == 0) {
			listPI_MOP.clear();
			try {
				listPI_MOP = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listPI_MOP;
	}

	public void setListPI_MOP(List<SelectItem> listPI_MOP) {
		this.listPI_MOP = listPI_MOP;
	}

	public void setCOMP_PI_MOP(HtmlSelectOneMenu comp_pi_mop) {
		COMP_PI_MOP = comp_pi_mop;
	}

	public HtmlSelectOneMenu getCOMP_PI_MOP() {
		return COMP_PI_MOP;
	}

}