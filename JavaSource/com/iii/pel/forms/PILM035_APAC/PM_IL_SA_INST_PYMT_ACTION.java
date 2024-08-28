package com.iii.pel.forms.PILM035_APAC;

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

public class PM_IL_SA_INST_PYMT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_SIP_PERC_LABEL;

	private HtmlInputText COMP_SIP_PERC;

	private HtmlOutputLabel COMP_SIP_NUMR_PERIOD_LABEL;

	private HtmlInputText COMP_SIP_NUMR_PERIOD;

	private HtmlOutputLabel COMP_SIP_DEMR_PERIOD_LABEL;

	private HtmlInputText COMP_SIP_DEMR_PERIOD;

	private HtmlOutputLabel COMP_SIP_REMARKS_LABEL;

	private HtmlInputText COMP_SIP_REMARKS;

	private HtmlOutputLabel COMP_SIP_BL_REMARKS_LABEL;

	private HtmlInputText COMP_SIP_BL_REMARKS;

	private PM_IL_SA_INST_PYMT PM_IL_SA_INST_PYMT_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_SA_INST_PYMT_HELPER helper;

	private List<PM_IL_SA_INST_PYMT> dataList_PM_IL_SA_INST_PYMT = new ArrayList<PM_IL_SA_INST_PYMT>();

	private UIData dataTable;

	public PM_IL_SA_INST_PYMT_ACTION() {

		PM_IL_SA_INST_PYMT_BEAN = new PM_IL_SA_INST_PYMT();
		helper = new PM_IL_SA_INST_PYMT_HELPER();
	}

	public HtmlOutputLabel getCOMP_SIP_PERC_LABEL() {
		return COMP_SIP_PERC_LABEL;
	}

	public HtmlInputText getCOMP_SIP_PERC() {
		return COMP_SIP_PERC;
	}

	public void setCOMP_SIP_PERC_LABEL(HtmlOutputLabel COMP_SIP_PERC_LABEL) {
		this.COMP_SIP_PERC_LABEL = COMP_SIP_PERC_LABEL;
	}

	public void setCOMP_SIP_PERC(HtmlInputText COMP_SIP_PERC) {
		this.COMP_SIP_PERC = COMP_SIP_PERC;
	}

	public HtmlOutputLabel getCOMP_SIP_NUMR_PERIOD_LABEL() {
		return COMP_SIP_NUMR_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_SIP_NUMR_PERIOD() {
		return COMP_SIP_NUMR_PERIOD;
	}

	public void setCOMP_SIP_NUMR_PERIOD_LABEL(
			HtmlOutputLabel COMP_SIP_NUMR_PERIOD_LABEL) {
		this.COMP_SIP_NUMR_PERIOD_LABEL = COMP_SIP_NUMR_PERIOD_LABEL;
	}

	public void setCOMP_SIP_NUMR_PERIOD(HtmlInputText COMP_SIP_NUMR_PERIOD) {
		this.COMP_SIP_NUMR_PERIOD = COMP_SIP_NUMR_PERIOD;
	}

	public HtmlOutputLabel getCOMP_SIP_DEMR_PERIOD_LABEL() {
		return COMP_SIP_DEMR_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_SIP_DEMR_PERIOD() {
		return COMP_SIP_DEMR_PERIOD;
	}

	public void setCOMP_SIP_DEMR_PERIOD_LABEL(
			HtmlOutputLabel COMP_SIP_DEMR_PERIOD_LABEL) {
		this.COMP_SIP_DEMR_PERIOD_LABEL = COMP_SIP_DEMR_PERIOD_LABEL;
	}

	public void setCOMP_SIP_DEMR_PERIOD(HtmlInputText COMP_SIP_DEMR_PERIOD) {
		this.COMP_SIP_DEMR_PERIOD = COMP_SIP_DEMR_PERIOD;
	}

	public HtmlOutputLabel getCOMP_SIP_REMARKS_LABEL() {
		return COMP_SIP_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_SIP_REMARKS() {
		return COMP_SIP_REMARKS;
	}

	public void setCOMP_SIP_REMARKS_LABEL(HtmlOutputLabel COMP_SIP_REMARKS_LABEL) {
		this.COMP_SIP_REMARKS_LABEL = COMP_SIP_REMARKS_LABEL;
	}

	public void setCOMP_SIP_REMARKS(HtmlInputText COMP_SIP_REMARKS) {
		this.COMP_SIP_REMARKS = COMP_SIP_REMARKS;
	}

	public HtmlOutputLabel getCOMP_SIP_BL_REMARKS_LABEL() {
		return COMP_SIP_BL_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_SIP_BL_REMARKS() {
		return COMP_SIP_BL_REMARKS;
	}

	public void setCOMP_SIP_BL_REMARKS_LABEL(
			HtmlOutputLabel COMP_SIP_BL_REMARKS_LABEL) {
		this.COMP_SIP_BL_REMARKS_LABEL = COMP_SIP_BL_REMARKS_LABEL;
	}

	public void setCOMP_SIP_BL_REMARKS(HtmlInputText COMP_SIP_BL_REMARKS) {
		this.COMP_SIP_BL_REMARKS = COMP_SIP_BL_REMARKS;
	}

	public PM_IL_SA_INST_PYMT getPM_IL_SA_INST_PYMT_BEAN() {
		return PM_IL_SA_INST_PYMT_BEAN;
	}

	public void setPM_IL_SA_INST_PYMT_BEAN(
			PM_IL_SA_INST_PYMT PM_IL_SA_INST_PYMT_BEAN) {
		this.PM_IL_SA_INST_PYMT_BEAN = PM_IL_SA_INST_PYMT_BEAN;
	}

	public List<PM_IL_SA_INST_PYMT> getDataList_PM_IL_SA_INST_PYMT() {
		return dataList_PM_IL_SA_INST_PYMT;
	}

	public void setDataListPM_IL_SA_INST_PYMT(
			List<PM_IL_SA_INST_PYMT> dataList_PM_IL_SA_INST_PYMT) {
		this.dataList_PM_IL_SA_INST_PYMT = dataList_PM_IL_SA_INST_PYMT;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_SA_INST_PYMT_BEAN = new PM_IL_SA_INST_PYMT();
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

				new CRUDHandler().executeDelete(PM_IL_SA_INST_PYMT_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				dataList_PM_IL_SA_INST_PYMT.remove(PM_IL_SA_INST_PYMT_BEAN);
				if (dataList_PM_IL_SA_INST_PYMT.size() > 0) {

					PM_IL_SA_INST_PYMT_BEAN = dataList_PM_IL_SA_INST_PYMT
							.get(0);
				} else if (dataList_PM_IL_SA_INST_PYMT.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_SA_INST_PYMT_BEAN.setRowSelected(true);
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
			if (PM_IL_SA_INST_PYMT_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_SA_INST_PYMT_BEAN,
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
								"errorPanel$message$save"));
				dataList_PM_IL_SA_INST_PYMT.add(PM_IL_SA_INST_PYMT_BEAN);
			} else if (PM_IL_SA_INST_PYMT_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_SA_INST_PYMT_BEAN,
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

			PM_IL_SA_INST_PYMT_BEAN.setRowSelected(true);
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
			PM_IL_SA_INST_PYMT_BEAN = (PM_IL_SA_INST_PYMT) dataTable
					.getRowData();
			PM_IL_SA_INST_PYMT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_SA_INST_PYMT> PM_IL_SA_INST_PYMT_ITR = dataList_PM_IL_SA_INST_PYMT
				.iterator();
		while (PM_IL_SA_INST_PYMT_ITR.hasNext()) {
			PM_IL_SA_INST_PYMT_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_SIP_PERC.resetValue();
		COMP_SIP_NUMR_PERIOD.resetValue();
		COMP_SIP_DEMR_PERIOD.resetValue();
		COMP_SIP_REMARKS.resetValue();
		COMP_SIP_BL_REMARKS.resetValue();
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
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"CURRENT",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
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
				CommonUtils.clearMaps(this);
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
