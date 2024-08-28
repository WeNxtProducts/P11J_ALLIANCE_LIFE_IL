package com.iii.pel.forms.PILT013;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BONUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BON_BONUS_CODE_LABEL;

	private HtmlInputText COMP_BON_BONUS_CODE;

	private HtmlOutputLabel COMP_BON_FC_BONUS_AMT_LABEL;

	private HtmlInputText COMP_BON_FC_BONUS_AMT;

	private HtmlOutputLabel COMP_BON_LC_BONUS_AMT_LABEL;

	private HtmlInputText COMP_BON_LC_BONUS_AMT;

/*******************   Newly added by dhinesh on 2.3.2017 ***********************/
	
	private HtmlInputText COMP_BON_BONUS_DESC;
	
	public HtmlInputText getCOMP_BON_BONUS_DESC() {
		return COMP_BON_BONUS_DESC;
	}

	public void setCOMP_BON_BONUS_DESC(HtmlInputText cOMP_BON_BONUS_DESC) {
		COMP_BON_BONUS_DESC = cOMP_BON_BONUS_DESC;
	}

	/************************* End *********************************/
	
	
	private HtmlCommandButton COMP_UI_M_BUT_BONUS_MAIN;

	private PT_IL_BONUS PT_IL_BONUS_BEAN;

	public PILT013_COMPOSITE_ACTION compositeAction;

	private PT_IL_BONUS_HELPER helper;

	private List<PT_IL_BONUS> dataList_PT_IL_BONUS = new ArrayList<PT_IL_BONUS>();

	private UIData dataTable;

	public PT_IL_BONUS_ACTION() {

		PT_IL_BONUS_BEAN = new PT_IL_BONUS();
		helper = new PT_IL_BONUS_HELPER();
	}

	public HtmlOutputLabel getCOMP_BON_BONUS_CODE_LABEL() {
		return COMP_BON_BONUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BON_BONUS_CODE() {
		return COMP_BON_BONUS_CODE;
	}

	public void setCOMP_BON_BONUS_CODE_LABEL(
			HtmlOutputLabel COMP_BON_BONUS_CODE_LABEL) {
		this.COMP_BON_BONUS_CODE_LABEL = COMP_BON_BONUS_CODE_LABEL;
	}

	public void setCOMP_BON_BONUS_CODE(HtmlInputText COMP_BON_BONUS_CODE) {
		this.COMP_BON_BONUS_CODE = COMP_BON_BONUS_CODE;
	}

	public HtmlOutputLabel getCOMP_BON_FC_BONUS_AMT_LABEL() {
		return COMP_BON_FC_BONUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BON_FC_BONUS_AMT() {
		return COMP_BON_FC_BONUS_AMT;
	}

	public void setCOMP_BON_FC_BONUS_AMT_LABEL(
			HtmlOutputLabel COMP_BON_FC_BONUS_AMT_LABEL) {
		this.COMP_BON_FC_BONUS_AMT_LABEL = COMP_BON_FC_BONUS_AMT_LABEL;
	}

	public void setCOMP_BON_FC_BONUS_AMT(HtmlInputText COMP_BON_FC_BONUS_AMT) {
		this.COMP_BON_FC_BONUS_AMT = COMP_BON_FC_BONUS_AMT;
	}

	public HtmlOutputLabel getCOMP_BON_LC_BONUS_AMT_LABEL() {
		return COMP_BON_LC_BONUS_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BON_LC_BONUS_AMT() {
		return COMP_BON_LC_BONUS_AMT;
	}

	public void setCOMP_BON_LC_BONUS_AMT_LABEL(
			HtmlOutputLabel COMP_BON_LC_BONUS_AMT_LABEL) {
		this.COMP_BON_LC_BONUS_AMT_LABEL = COMP_BON_LC_BONUS_AMT_LABEL;
	}

	public void setCOMP_BON_LC_BONUS_AMT(HtmlInputText COMP_BON_LC_BONUS_AMT) {
		this.COMP_BON_LC_BONUS_AMT = COMP_BON_LC_BONUS_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BONUS_MAIN() {
		return COMP_UI_M_BUT_BONUS_MAIN;
	}

	public void setCOMP_UI_M_BUT_BONUS_MAIN(
			HtmlCommandButton COMP_UI_M_BUT_BONUS_MAIN) {
		this.COMP_UI_M_BUT_BONUS_MAIN = COMP_UI_M_BUT_BONUS_MAIN;
	}

	public PT_IL_BONUS getPT_IL_BONUS_BEAN() {
		return PT_IL_BONUS_BEAN;
	}

	public void setPT_IL_BONUS_BEAN(PT_IL_BONUS PT_IL_BONUS_BEAN) {
		this.PT_IL_BONUS_BEAN = PT_IL_BONUS_BEAN;
	}

	public List<PT_IL_BONUS> getDataList_PT_IL_BONUS() {
		return dataList_PT_IL_BONUS;
	}

	public void setDataListPT_IL_BONUS(List<PT_IL_BONUS> dataList_PT_IL_BONUS) {
		this.dataList_PT_IL_BONUS = dataList_PT_IL_BONUS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_BONUS_BEAN = new PT_IL_BONUS();
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

				new CRUDHandler().executeDelete(PT_IL_BONUS_BEAN, CommonUtils
						.getConnection());
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
				dataList_PT_IL_BONUS.remove(PT_IL_BONUS_BEAN);
				if (dataList_PT_IL_BONUS.size() > 0) {

					PT_IL_BONUS_BEAN = dataList_PT_IL_BONUS.get(0);
				} else if (dataList_PT_IL_BONUS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_BONUS_BEAN.setRowSelected(true);
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
			if (PT_IL_BONUS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_BONUS_BEAN, CommonUtils
						.getConnection());
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
				dataList_PT_IL_BONUS.add(PT_IL_BONUS_BEAN);
			} else if (PT_IL_BONUS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_BONUS_BEAN, CommonUtils
						.getConnection());
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

			PT_IL_BONUS_BEAN.setRowSelected(true);
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
			PT_IL_BONUS_BEAN = (PT_IL_BONUS) dataTable.getRowData();
			PT_IL_BONUS_BEAN.setRowSelected(true);
			resetAllComponent();
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_BONUS> PT_IL_BONUS_ITR = dataList_PT_IL_BONUS.iterator();
		while (PT_IL_BONUS_ITR.hasNext()) {
			PT_IL_BONUS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_BON_BONUS_CODE.resetValue();
		COMP_BON_FC_BONUS_AMT.resetValue();
		COMP_BON_LC_BONUS_AMT.resetValue();
		COMP_BON_BONUS_DESC.resetValue();
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
			//if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				resetAllComponent();
				//setBlockFlag(false);
			//}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

}
