package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_CASHBACK_ACTION extends CommonAction {
	
	private HtmlOutputLabel COMP_PROD_CBK_BASIC_PREM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_CBK_PERC_PREM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_CBK_YRS_LABEL;

	private HtmlSelectOneMenu COMP_PROD_CBK_BASIC_PREM;
	/*
	private HtmlInputText COMP_PROD_CBK_BASIC_PREM;
	
	public HtmlInputText getCOMP_PROD_CBK_BASIC_PREM() {
		return COMP_PROD_CBK_BASIC_PREM;
	}
	public void setCOMP_PROD_CBK_BASIC_PREM(HtmlInputText cOMP_PROD_CBK_BASIC_PREM) {
		COMP_PROD_CBK_BASIC_PREM = cOMP_PROD_CBK_BASIC_PREM;
	}*/

	private HtmlInputText COMP_PROD_CBK_PERC_PREM;
	
	private HtmlInputText COMP_PROD_CBK_YRS;
	
	public PILM035_APAC_COMPOSITE_ACTION compositeAction;
	
	private PM_IL_PROD_CASHBACK_ACTION PM_IL_PROD_CASHBACK_ACTION_BEAN;
	
	private PM_IL_PROD_CASHBACK PM_IL_PROD_CASHBACK_BEAN;
	
	private PM_IL_PROD_CASHBACK_HELPER helper;
	
	private List<PM_IL_PROD_CASHBACK> dataList_PM_IL_PROD_CASHBACK = new ArrayList<PM_IL_PROD_CASHBACK>();
	
	private List<SelectItem> listPROD_CBK_BASIC_PREM = new ArrayList<SelectItem>();

	public List<SelectItem> getListPROD_CBK_BASIC_PREM() {
		if (listPROD_CBK_BASIC_PREM.size() == 0) {
			listPROD_CBK_BASIC_PREM.clear();
			try {
				listPROD_CBK_BASIC_PREM = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPROD_CBK_BASIC_PREM;
	}
	public void setListPROD_CBK_BASIC_PREM(List<SelectItem> listPROD_CBK_BASIC_PREM) {
		this.listPROD_CBK_BASIC_PREM = listPROD_CBK_BASIC_PREM;
	}

	private UIData dataTable;
	
	public PM_IL_PROD_CASHBACK_ACTION(){
		
		PM_IL_PROD_CASHBACK_BEAN=new PM_IL_PROD_CASHBACK();
		helper =new PM_IL_PROD_CASHBACK_HELPER();
		prepareDropDowns();
		//compositeAction=new PILM035_APAC_COMPOSITE_ACTION();
	}
	public void onLoad(PhaseEvent event) {
		try {
		/*	if (PM_IL_PROD_CASHBACK_BEAN.getROWID() == null)
			{
				PM_IL_PROD_CASHBACK_BEAN.setPSD_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
			}*/
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
	
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
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
	
	public HtmlOutputLabel getCOMP_PROD_CBK_BASIC_PREM_LABEL() {
		return COMP_PROD_CBK_BASIC_PREM_LABEL;
	}

	public void setCOMP_PROD_CBK_BASIC_PREM_LABEL(
			HtmlOutputLabel cOMP_PROD_CBK_BASIC_PREM_LABEL) {
		COMP_PROD_CBK_BASIC_PREM_LABEL = cOMP_PROD_CBK_BASIC_PREM_LABEL;
	}

	public HtmlOutputLabel getCOMP_PROD_CBK_PERC_PREM_LABEL() {
		return COMP_PROD_CBK_PERC_PREM_LABEL;
	}

	public void setCOMP_PROD_CBK_PERC_PREM_LABEL(
			HtmlOutputLabel cOMP_PROD_CBK_PERC_PREM_LABEL) {
		COMP_PROD_CBK_PERC_PREM_LABEL = cOMP_PROD_CBK_PERC_PREM_LABEL;
	}

	public HtmlOutputLabel getCOMP_PROD_CBK_YRS_LABEL() {
		return COMP_PROD_CBK_YRS_LABEL;
	}

	public void setCOMP_PROD_CBK_YRS_LABEL(HtmlOutputLabel cOMP_PROD_CBK_YRS_LABEL) {
		COMP_PROD_CBK_YRS_LABEL = cOMP_PROD_CBK_YRS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PROD_CBK_BASIC_PREM() {
		return COMP_PROD_CBK_BASIC_PREM;
	}

	public void setCOMP_PROD_CBK_BASIC_PREM(
			HtmlSelectOneMenu cOMP_PROD_CBK_BASIC_PREM) {
		COMP_PROD_CBK_BASIC_PREM = cOMP_PROD_CBK_BASIC_PREM;
	}

	public HtmlInputText getCOMP_PROD_CBK_PERC_PREM() {
		return COMP_PROD_CBK_PERC_PREM;
	}

	public void setCOMP_PROD_CBK_PERC_PREM(HtmlInputText cOMP_PROD_CBK_PERC_PREM) {
		COMP_PROD_CBK_PERC_PREM = cOMP_PROD_CBK_PERC_PREM;
	}

	public HtmlInputText getCOMP_PROD_CBK_YRS() {
		return COMP_PROD_CBK_YRS;
	}

	public void setCOMP_PROD_CBK_YRS(HtmlInputText cOMP_PROD_CBK_YRS) {
		COMP_PROD_CBK_YRS = cOMP_PROD_CBK_YRS;
	}

	public PM_IL_PROD_CASHBACK_ACTION getPM_IL_PROD_CASHBACK_ACTION_BEAN() {
		return PM_IL_PROD_CASHBACK_ACTION_BEAN;
	}

	public void setPM_IL_PROD_CASHBACK_ACTION_BEAN(
			PM_IL_PROD_CASHBACK_ACTION pM_IL_PROD_CASHBACK_ACTION_BEAN) {
		PM_IL_PROD_CASHBACK_ACTION_BEAN = pM_IL_PROD_CASHBACK_ACTION_BEAN;
	}

	public PM_IL_PROD_CASHBACK getPM_IL_PROD_CASHBACK_BEAN() {
		return PM_IL_PROD_CASHBACK_BEAN;
	}

	public void setPM_IL_PROD_CASHBACK_BEAN(
			PM_IL_PROD_CASHBACK pM_IL_PROD_CASHBACK_BEAN) {
		PM_IL_PROD_CASHBACK_BEAN = pM_IL_PROD_CASHBACK_BEAN;
	}

	public PM_IL_PROD_CASHBACK_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_PROD_CASHBACK_HELPER helper) {
		this.helper = helper;
	}

	public List<PM_IL_PROD_CASHBACK> getDataList_PM_IL_PROD_CASHBACK() {
		return dataList_PM_IL_PROD_CASHBACK;
	}

	public void setDataList_PM_IL_PROD_CASHBACK(
			List<PM_IL_PROD_CASHBACK> dataList_PM_IL_PROD_CASHBACK) {
		this.dataList_PM_IL_PROD_CASHBACK = dataList_PM_IL_PROD_CASHBACK;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	

	public void PROD_CBK_BASIC_PREM_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_CASHBACK_BEAN().setPCB_APPL_ON((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PROD_CBK_PERC_PREM_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			/* Modified PCB_PERC MAX LENGTH from Integer to Double by pidugu raj dt: 22-10-2020 as suggested by sivarajan for Alliance IL*/
			/*getPM_IL_PROD_CASHBACK_BEAN().setPCB_PERC((Integer)value);*/
			getPM_IL_PROD_CASHBACK_BEAN().setPCB_PERC((Double)value);
			/* End Modified PCB_PERC MAX LENGTH from Integer to Double by pidugu raj dt: 22-10-2020 as suggested by sivarajan for Alliance IL*/
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PROD_CBK_YRS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_CASHBACK_BEAN().setPCB_COMP_YRS((Integer)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_CASHBACK_BEAN = (PM_IL_PROD_CASHBACK) dataTable
					.getRowData();
			PM_IL_PROD_CASHBACK_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	public void addRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isINSERT_ALLOWED()) {
				//helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_CASHBACK_BEAN=new PM_IL_PROD_CASHBACK();
				PM_IL_PROD_CASHBACK_BEAN.setPCB_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
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
		CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_CASHBACK_BEAN,
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
				dataList_PM_IL_PROD_CASHBACK
						.remove(PM_IL_PROD_CASHBACK_BEAN);
				if (dataList_PM_IL_PROD_CASHBACK.size() > 0) {

					PM_IL_PROD_CASHBACK_BEAN = dataList_PM_IL_PROD_CASHBACK
							.get(0);
				} else if (dataList_PM_IL_PROD_CASHBACK.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_CASHBACK_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_CASHBACK_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_CASHBACK_BEAN,
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
				dataList_PM_IL_PROD_CASHBACK.add(PM_IL_PROD_CASHBACK_BEAN);
			} else if (PM_IL_PROD_CASHBACK_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_CASHBACK_BEAN,
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

			PM_IL_PROD_CASHBACK_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());*/
					
					
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 exc.getMessage());
			getErrorMap().put("postRecord",
					 exc.getMessage());
		
					
					
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_CASHBACK> PM_IL_PROD_CASHBACK = dataList_PM_IL_PROD_CASHBACK.iterator();
		while (PM_IL_PROD_CASHBACK.hasNext()) {
			PM_IL_PROD_CASHBACK.next().setRowSelected(false);
		}
	}
	
	private void resetAllComponent() {
		COMP_PROD_CBK_BASIC_PREM.resetValue();
		COMP_PROD_CBK_PERC_PREM.resetValue();
		COMP_PROD_CBK_YRS.resetValue();
	}
	private void prepareDropDowns() {
		try {
			setListPROD_CBK_BASIC_PREM(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CASHBACK",
					"PM_IL_PROD_CASHBACK.PCB_APPL_ON", "IL_CABK_APPL"));
		/*	setListPPL_CHECK_BASIS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_PREM_LIMIT",
					"PM_IL_PROD_PREM_LIMIT.PPL_CHECK_BASIS", "CHECKBASIS"));*/
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	


 
}
