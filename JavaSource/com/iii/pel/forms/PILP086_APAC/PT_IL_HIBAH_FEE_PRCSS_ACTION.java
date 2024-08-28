package com.iii.pel.forms.PILP086_APAC;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_HIBAH_FEE_PRCSS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_HFP_POL_NO_LABEL;

	private HtmlInputText COMP_HFP_POL_NO;

	private HtmlOutputLabel COMP_HFP_AGE_LABEL;

	private HtmlInputText COMP_HFP_AGE;

	private HtmlOutputLabel COMP_HFP_PRCSS_YN_LABEL;

	private HtmlSelectOneMenu COMP_HFP_PRCSS_YN;

	private PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN;

	public PILP086_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_HIBAH_FEE_PRCSS_HELPER helper;

	private List<PT_IL_HIBAH_FEE_PRCSS> dataList_PT_IL_HIBAH_FEE_PRCSS = new ArrayList<PT_IL_HIBAH_FEE_PRCSS>();

	private UIData dataTable;

	private List<SelectItem> listHFP_PRCSS_YN = new ArrayList<SelectItem>();

	public PT_IL_HIBAH_FEE_PRCSS_ACTION() {

		PT_IL_HIBAH_FEE_PRCSS_BEAN = new PT_IL_HIBAH_FEE_PRCSS();
		helper = new PT_IL_HIBAH_FEE_PRCSS_HELPER();
		setListHFP_PRCSS_YN(ListItemUtil.getDropDownListValue(getConnection(), "PILP086_APAC", "PT_IL_HIBAH_FEE_PRCSS", "PT_IL_HIBAH_FEE_PRCSS.HFP_PRCSS_YN", "YESNO"));
	}

	public HtmlOutputLabel getCOMP_HFP_POL_NO_LABEL() {
		return COMP_HFP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_HFP_POL_NO() {
		return COMP_HFP_POL_NO;
	}

	public void setCOMP_HFP_POL_NO_LABEL(HtmlOutputLabel COMP_HFP_POL_NO_LABEL) {
		this.COMP_HFP_POL_NO_LABEL = COMP_HFP_POL_NO_LABEL;
	}

	public void setCOMP_HFP_POL_NO(HtmlInputText COMP_HFP_POL_NO) {
		this.COMP_HFP_POL_NO = COMP_HFP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_HFP_AGE_LABEL() {
		return COMP_HFP_AGE_LABEL;
	}

	public HtmlInputText getCOMP_HFP_AGE() {
		return COMP_HFP_AGE;
	}

	public void setCOMP_HFP_AGE_LABEL(HtmlOutputLabel COMP_HFP_AGE_LABEL) {
		this.COMP_HFP_AGE_LABEL = COMP_HFP_AGE_LABEL;
	}

	public void setCOMP_HFP_AGE(HtmlInputText COMP_HFP_AGE) {
		this.COMP_HFP_AGE = COMP_HFP_AGE;
	}

	public HtmlOutputLabel getCOMP_HFP_PRCSS_YN_LABEL() {
		return COMP_HFP_PRCSS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_HFP_PRCSS_YN() {
		return COMP_HFP_PRCSS_YN;
	}

	public void setCOMP_HFP_PRCSS_YN_LABEL(
			HtmlOutputLabel COMP_HFP_PRCSS_YN_LABEL) {
		this.COMP_HFP_PRCSS_YN_LABEL = COMP_HFP_PRCSS_YN_LABEL;
	}

	public void setCOMP_HFP_PRCSS_YN(HtmlSelectOneMenu COMP_HFP_PRCSS_YN) {
		this.COMP_HFP_PRCSS_YN = COMP_HFP_PRCSS_YN;
	}

	public PT_IL_HIBAH_FEE_PRCSS getPT_IL_HIBAH_FEE_PRCSS_BEAN() {
		return PT_IL_HIBAH_FEE_PRCSS_BEAN;
	}

	public void setPT_IL_HIBAH_FEE_PRCSS_BEAN(
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN) {
		this.PT_IL_HIBAH_FEE_PRCSS_BEAN = PT_IL_HIBAH_FEE_PRCSS_BEAN;
	}

	public List<PT_IL_HIBAH_FEE_PRCSS> getDataList_PT_IL_HIBAH_FEE_PRCSS() {
		return dataList_PT_IL_HIBAH_FEE_PRCSS;
	}

	public void setDataListPT_IL_HIBAH_FEE_PRCSS(
			List<PT_IL_HIBAH_FEE_PRCSS> dataList_PT_IL_HIBAH_FEE_PRCSS) {
		this.dataList_PT_IL_HIBAH_FEE_PRCSS = dataList_PT_IL_HIBAH_FEE_PRCSS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_HIBAH_FEE_PRCSS_BEAN = new PT_IL_HIBAH_FEE_PRCSS();
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

				int i = new CRUDHandler().executeDelete(PT_IL_HIBAH_FEE_PRCSS_BEAN,
						CommonUtils.getConnection());
				if(i==1){
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
					dataList_PT_IL_HIBAH_FEE_PRCSS
					.remove(PT_IL_HIBAH_FEE_PRCSS_BEAN);
					if (dataList_PT_IL_HIBAH_FEE_PRCSS.size() > 0) {
						
						PT_IL_HIBAH_FEE_PRCSS_BEAN = dataList_PT_IL_HIBAH_FEE_PRCSS
						.get(0);
					} else if (dataList_PT_IL_HIBAH_FEE_PRCSS.size() == 0) {
						
						addRow(null);
					}
					
					resetAllComponent();
					PT_IL_HIBAH_FEE_PRCSS_BEAN.setRowSelected(true);
				}
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
			if (isINSERT_ALLOWED()) {

			/*	int i = new CRUDHandler().executeInsert(PT_IL_HIBAH_FEE_PRCSS_BEAN,
						CommonUtils.getConnection());
				if(i==1){
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
				
					dataList_PT_IL_HIBAH_FEE_PRCSS.add(PT_IL_HIBAH_FEE_PRCSS_BEAN);
				}*/
			} else if (isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_HIBAH_FEE_PRCSS_BEAN,
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

			PT_IL_HIBAH_FEE_PRCSS_BEAN.setRowSelected(true);
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
			PT_IL_HIBAH_FEE_PRCSS_BEAN = (PT_IL_HIBAH_FEE_PRCSS) dataTable
					.getRowData();
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_HIBAH_FEE_PRCSS> PT_IL_HIBAH_FEE_PRCSS_ITR = dataList_PT_IL_HIBAH_FEE_PRCSS
				.iterator();
		while (PT_IL_HIBAH_FEE_PRCSS_ITR.hasNext()) {
			PT_IL_HIBAH_FEE_PRCSS_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_HFP_POL_NO.resetValue();
		COMP_HFP_AGE.resetValue();
		COMP_HFP_PRCSS_YN.resetValue();
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

	public List<SelectItem> getListHFP_PRCSS_YN() {
		if (listHFP_PRCSS_YN.size() == 0) {
			listHFP_PRCSS_YN.clear();
			try {
				listHFP_PRCSS_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listHFP_PRCSS_YN;
	}

	public void setListHFP_PRCSS_YN(List<SelectItem> listHFP_PRCSS_YN) {
		this.listHFP_PRCSS_YN = listHFP_PRCSS_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if(isFormFlag()){
				helper.preForm(compositeAction);
				helper.whenNewFormInstance();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.preBlock(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				helper.whenNewBlockInstance(compositeAction);
				helper.whenCreateRecord(PT_IL_HIBAH_FEE_PRCSS_BEAN);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void processButton(){
		try {
			getWarningMap().clear();
			boolean valid = helper.processButtonPressed(compositeAction);
			if(valid){
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Hibah Process Done Successfully");
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}

}
