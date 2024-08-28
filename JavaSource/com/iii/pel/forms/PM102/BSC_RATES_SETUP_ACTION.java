package com.iii.pel.forms.PM102;

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

public class BSC_RATES_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TSD_LEVEL_LABEL;

	private HtmlInputText COMP_TSD_LEVEL;

	private HtmlOutputLabel COMP_TSD_MODE_LABEL;

	private HtmlInputText COMP_TSD_MODE;

	private HtmlOutputLabel COMP_TSD_TARGET_LABEL;

	private HtmlInputText COMP_TSD_TARGET;

	private BSC_RATES_SETUP BSC_RATES_SETUP_BEAN;

	public PM102_COMPOSITE_ACTION compositeAction;

	private BSC_RATES_SETUP_HELPER helper;

	private List<BSC_RATES_SETUP> dataList_BSC_RATES_SETUP = 
				new ArrayList<BSC_RATES_SETUP>();

	private UIData dataTable;

	public BSC_RATES_SETUP_ACTION() {

		BSC_RATES_SETUP_BEAN = new BSC_RATES_SETUP();
		helper = new BSC_RATES_SETUP_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_TSD_LEVEL_LABEL() {
		return COMP_TSD_LEVEL_LABEL;
	}

	public HtmlInputText getCOMP_TSD_LEVEL() {
		return COMP_TSD_LEVEL;
	}

	public void setCOMP_TSD_LEVEL_LABEL(HtmlOutputLabel COMP_TSD_LEVEL_LABEL) {
		this.COMP_TSD_LEVEL_LABEL = COMP_TSD_LEVEL_LABEL;
	}

	public void setCOMP_TSD_LEVEL(HtmlInputText COMP_TSD_LEVEL) {
		this.COMP_TSD_LEVEL = COMP_TSD_LEVEL;
	}

	public HtmlOutputLabel getCOMP_TSD_MODE_LABEL() {
		return COMP_TSD_MODE_LABEL;
	}

	public HtmlInputText getCOMP_TSD_MODE() {
		return COMP_TSD_MODE;
	}

	public void setCOMP_TSD_MODE_LABEL(HtmlOutputLabel COMP_TSD_MODE_LABEL) {
		this.COMP_TSD_MODE_LABEL = COMP_TSD_MODE_LABEL;
	}

	public void setCOMP_TSD_MODE(HtmlInputText COMP_TSD_MODE) {
		this.COMP_TSD_MODE = COMP_TSD_MODE;
	}

	public HtmlOutputLabel getCOMP_TSD_TARGET_LABEL() {
		return COMP_TSD_TARGET_LABEL;
	}

	public void setCOMP_TSD_TARGET_LABEL(HtmlOutputLabel COMP_TSD_TARGET_LABEL) {
		this.COMP_TSD_TARGET_LABEL = COMP_TSD_TARGET_LABEL;
	}

	public BSC_RATES_SETUP getBSC_RATES_SETUP_BEAN() {
		return BSC_RATES_SETUP_BEAN;
	}

	public void setBSC_RATES_SETUP_BEAN(
			BSC_RATES_SETUP BSC_RATES_SETUP_BEAN) {
		this.BSC_RATES_SETUP_BEAN = BSC_RATES_SETUP_BEAN;
	}

	public List<BSC_RATES_SETUP> getDataList_BSC_RATES_SETUP() {
		return dataList_BSC_RATES_SETUP;
	}

	public void setDataListBSC_RATES_SETUP(
			List<BSC_RATES_SETUP> dataList_BSC_RATES_SETUP) {
		this.dataList_BSC_RATES_SETUP = dataList_BSC_RATES_SETUP;
	}

	public HtmlInputText getCOMP_TSD_TARGET() {
		return COMP_TSD_TARGET;
	}

	public void setCOMP_TSD_TARGET(HtmlInputText cOMP_TSD_TARGET) {
		COMP_TSD_TARGET = cOMP_TSD_TARGET;
	}

	public void postRecord() {
		CommonUtils.clearMaps(this);
		try {

			if (BSC_RATES_SETUP_BEAN.getROWID() == null) {

			} else if (BSC_RATES_SETUP_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					new CRUDHandler().executeUpdate(
							BSC_RATES_SETUP_BEAN,
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
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
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
			BSC_RATES_SETUP_BEAN = (BSC_RATES_SETUP) dataTable
					.getRowData();
			BSC_RATES_SETUP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<BSC_RATES_SETUP> BSC_RATES_SETUP_ITR = dataList_BSC_RATES_SETUP
				.iterator();
		while (BSC_RATES_SETUP_ITR.hasNext()) {
			BSC_RATES_SETUP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_TSD_LEVEL.resetValue();
		COMP_TSD_MODE.resetValue();
		COMP_TSD_TARGET.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
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
				if (BSC_RATES_SETUP_BEAN != null) {
					helper.executeQuery(compositeAction);
				} else {
				}
				COMP_TSD_MODE.resetValue();
				setBlockFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * Instantiates all components in BSC_RATES_SETUP_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_TSD_LEVEL = new HtmlInputText();
		COMP_TSD_MODE = new HtmlInputText();
		// Instantiating HtmlSelectOneMenu
		COMP_TSD_TARGET = new HtmlInputText();

	}

	/**
	 * Disables all components in BSC_RATES_SETUP_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_TSD_LEVEL.setDisabled(disabled);
		COMP_TSD_MODE.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_TSD_TARGET.setDisabled(disabled);

	}
	
	public String incTargetAction(){
		return "PM102";
	}

}
