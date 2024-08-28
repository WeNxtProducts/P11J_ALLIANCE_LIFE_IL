package com.iii.pel.forms.PM094_A;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PM_AGENT_BONUS_PERC_RANGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABPR_PERC_FM_LABEL;
	
	private HtmlInputText COMP_ABPR_PERC_FM;
	
	private HtmlOutputLabel COMP_ABPR_PERC_TO_LABEL;
	
	private HtmlInputText COMP_ABPR_PERC_TO;
	
	private HtmlOutputLabel COMP_ABPR_VALUE_LABEL;
	
	private HtmlInputText COMP_ABPR_VALUE;
	
	public PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction;
	
	private UIData dataTable;
	
	private List<PM_AGENT_BONUS_PERC_RANGE> dataList_PM_AGENT_BONUS_PERC_RANGE = new ArrayList<PM_AGENT_BONUS_PERC_RANGE>();
	
	private PM_AGENT_BONUS_PERC_RANGE PM_AGENT_BONUS_PERC_RANGE_BEAN;
	
	private PM_AGENT_BONUS_PERC_RANGE_HELPER bonus_perc_range_helper;
	
	public PM_AGENT_BONUS_PERC_RANGE_ACTION() {
		PM_AGENT_BONUS_PERC_RANGE_BEAN = new PM_AGENT_BONUS_PERC_RANGE();
		bonus_perc_range_helper = new PM_AGENT_BONUS_PERC_RANGE_HELPER();
	}

	public HtmlOutputLabel getCOMP_ABPR_PERC_FM_LABEL() {
		return COMP_ABPR_PERC_FM_LABEL;
	}

	public void setCOMP_ABPR_PERC_FM_LABEL(HtmlOutputLabel cOMP_ABPR_PERC_FM_LABEL) {
		COMP_ABPR_PERC_FM_LABEL = cOMP_ABPR_PERC_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABPR_PERC_FM() {
		return COMP_ABPR_PERC_FM;
	}

	public void setCOMP_ABPR_PERC_FM(HtmlInputText cOMP_ABPR_PERC_FM) {
		COMP_ABPR_PERC_FM = cOMP_ABPR_PERC_FM;
	}

	public HtmlOutputLabel getCOMP_ABPR_PERC_TO_LABEL() {
		return COMP_ABPR_PERC_TO_LABEL;
	}

	public void setCOMP_ABPR_PERC_TO_LABEL(HtmlOutputLabel cOMP_ABPR_PERC_TO_LABEL) {
		COMP_ABPR_PERC_TO_LABEL = cOMP_ABPR_PERC_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABPR_PERC_TO() {
		return COMP_ABPR_PERC_TO;
	}

	public void setCOMP_ABPR_PERC_TO(HtmlInputText cOMP_ABPR_PERC_TO) {
		COMP_ABPR_PERC_TO = cOMP_ABPR_PERC_TO;
	}

	public HtmlOutputLabel getCOMP_ABPR_VALUE_LABEL() {
		return COMP_ABPR_VALUE_LABEL;
	}

	public void setCOMP_ABPR_VALUE_LABEL(HtmlOutputLabel cOMP_ABPR_VALUE_LABEL) {
		COMP_ABPR_VALUE_LABEL = cOMP_ABPR_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_ABPR_VALUE() {
		return COMP_ABPR_VALUE;
	}

	public void setCOMP_ABPR_VALUE(HtmlInputText cOMP_ABPR_VALUE) {
		COMP_ABPR_VALUE = cOMP_ABPR_VALUE;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PM_AGENT_BONUS_PERC_RANGE> getDataList_PM_AGENT_BONUS_PERC_RANGE() {
		return dataList_PM_AGENT_BONUS_PERC_RANGE;
	}

	public void setDataList_PM_AGENT_BONUS_PERC_RANGE(
			List<PM_AGENT_BONUS_PERC_RANGE> dataList_PM_AGENT_BONUS_PERC_RANGE) {
		this.dataList_PM_AGENT_BONUS_PERC_RANGE = dataList_PM_AGENT_BONUS_PERC_RANGE;
	}

	public PM_AGENT_BONUS_PERC_RANGE getPM_AGENT_BONUS_PERC_RANGE_BEAN() {
		return PM_AGENT_BONUS_PERC_RANGE_BEAN;
	}

	public void setPM_AGENT_BONUS_PERC_RANGE_BEAN(
			PM_AGENT_BONUS_PERC_RANGE pM_AGENT_BONUS_PERC_RANGE_BEAN) {
		PM_AGENT_BONUS_PERC_RANGE_BEAN = pM_AGENT_BONUS_PERC_RANGE_BEAN;
	}
	
	public void resetAllComponent(){
		COMP_ABPR_PERC_FM.resetValue();
		COMP_ABPR_PERC_TO.resetValue();
		COMP_ABPR_VALUE.resetValue();
	}
	
	public void validatorABPR_PERC_FM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		try{
			if (value != null) {
				Integer code = (Integer) value;
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setABPR_PERC_FM(code);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void validatorABPR_PERC_TO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		try{
			if (value != null) {
				Integer code = (Integer) value;
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setABPR_PERC_TO(code);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void validatorABPR_VALUE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		try{
			if (value != null) {
				Integer code = (Integer) value;
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setABPR_VALUE(code);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_AGENT_BONUS_PERC_RANGE_BEAN = new PM_AGENT_BONUS_PERC_RANGE();
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
				new CRUDHandler().executeDelete(PM_AGENT_BONUS_PERC_RANGE_BEAN,
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
				dataList_PM_AGENT_BONUS_PERC_RANGE.remove(PM_AGENT_BONUS_PERC_RANGE_BEAN);
				if (dataList_PM_AGENT_BONUS_PERC_RANGE.size() > 0) {

					PM_AGENT_BONUS_PERC_RANGE_BEAN = dataList_PM_AGENT_BONUS_PERC_RANGE
							.get(0);
				} else if (dataList_PM_AGENT_BONUS_PERC_RANGE.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_AGENT_BONUS_PERC_RANGE_BEAN.setRowSelected(true);
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
			if (PM_AGENT_BONUS_PERC_RANGE_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PM_AGENT_BONUS_PERC_RANGE_BEAN,
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
				dataList_PM_AGENT_BONUS_PERC_RANGE.add(PM_AGENT_BONUS_PERC_RANGE_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_AGENT_BONUS_PERC_RANGE_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PM_AGENT_BONUS_PERC_RANGE_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
			}
			}
			PM_AGENT_BONUS_PERC_RANGE_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	
	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
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
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_AGENT_BONUS_PERC_RANGE_BEAN = (PM_AGENT_BONUS_PERC_RANGE) dataTable
					.getRowData();
			PM_AGENT_BONUS_PERC_RANGE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BONUS_PERC_RANGE> PM_AGENT_BONUS_PERC_RANGE_ITR = dataList_PM_AGENT_BONUS_PERC_RANGE
				.iterator();
		while (PM_AGENT_BONUS_PERC_RANGE_ITR.hasNext()) {
			PM_AGENT_BONUS_PERC_RANGE_ITR.next().setRowSelected(false);
		}
	}
	
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag()){
				bonus_perc_range_helper.executeStatement(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
}
