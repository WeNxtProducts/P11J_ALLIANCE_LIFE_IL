package com.iii.pel.forms.PILM036_APAC;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_SUB_PLAN_ACTION extends CommonAction{

	private PM_IL_SUB_PLAN PM_IL_SUB_PLAN_BEAN;
	
	public PILM036_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_SUB_PLAN_HELPER helper;
	
	
	private HtmlOutputLabel COMP_SPLAN_CODE_LABEL;

	private HtmlInputText COMP_SPLAN_CODE;
	
	private HtmlOutputLabel COMP_SPLAN_DESC_LABEL;

	private HtmlInputText COMP_SPLAN_DESC;

	private HtmlOutputLabel COMP_SPLAN_GROUP_YN_LABEL;

	private HtmlSelectOneMenu COMP_SPLAN_GROUP_YN;
	
	private HtmlCommandButton COMP_UI_M_BUT_GRP_DTL;

	private List<PM_IL_SUB_PLAN> dataList_PM_IL_SUB_PLAN = new ArrayList<PM_IL_SUB_PLAN>();

	private UIData dataTable;
		
	private List<SelectItem> listSPLAN_GROUP_YN = new ArrayList<SelectItem>();
	
	
	/*public List<SelectItem> getListSPLAN_GROUP_YN() {
		return listSPLAN_GROUP_YN;
	}

	public List<SelectItem> setListSPLAN_GROUP_YN(List<SelectItem> listSPLAN_GROUP_YN) {
		if (listSPLAN_GROUP_YN.size() == 0) {
			listSPLAN_GROUP_YN.clear();
			try {
				listSPLAN_GROUP_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return listSPLAN_GROUP_YN;
	}*/

	public List<SelectItem> getListSPLAN_GROUP_YN() {
		
		if (listSPLAN_GROUP_YN.size() == 0) {
			listSPLAN_GROUP_YN.clear();
			try {
				listSPLAN_GROUP_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listSPLAN_GROUP_YN;
	}


	public void setListSPLAN_GROUP_YN(List<SelectItem> listSPLAN_GROUP_YN) {
		this.listSPLAN_GROUP_YN = listSPLAN_GROUP_YN;
	}


	
	public HtmlCommandButton getCOMP_UI_M_BUT_GRP_DTL() {
		return COMP_UI_M_BUT_GRP_DTL;
	}


	public void setCOMP_UI_M_BUT_GRP_DTL(HtmlCommandButton cOMP_UI_M_BUT_GRP_DTL) {
		COMP_UI_M_BUT_GRP_DTL = cOMP_UI_M_BUT_GRP_DTL;
	}


	public List<PM_IL_SUB_PLAN> getDataList_PM_IL_SUB_PLAN() {
		return dataList_PM_IL_SUB_PLAN;
	}


	public void setDataList_PM_IL_SUB_PLAN(
			List<PM_IL_SUB_PLAN> dataList_PM_IL_SUB_PLAN) {
		this.dataList_PM_IL_SUB_PLAN = dataList_PM_IL_SUB_PLAN;
	}


	public PM_IL_SUB_PLAN getPM_IL_SUB_PLAN_BEAN() {
		return PM_IL_SUB_PLAN_BEAN;
	}


	public void setPM_IL_SUB_PLAN_BEAN(PM_IL_SUB_PLAN pM_IL_SUB_PLAN_BEAN) {
		PM_IL_SUB_PLAN_BEAN = pM_IL_SUB_PLAN_BEAN;
	}


	public PILM036_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(PILM036_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PM_IL_SUB_PLAN_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PM_IL_SUB_PLAN_HELPER helper) {
		this.helper = helper;
	}


	public HtmlOutputLabel getCOMP_SPLAN_CODE_LABEL() {
		return COMP_SPLAN_CODE_LABEL;
	}


	public void setCOMP_SPLAN_CODE_LABEL(HtmlOutputLabel cOMP_SPLAN_CODE_LABEL) {
		COMP_SPLAN_CODE_LABEL = cOMP_SPLAN_CODE_LABEL;
	}


	public HtmlInputText getCOMP_SPLAN_CODE() {
		return COMP_SPLAN_CODE;
	}


	public void setCOMP_SPLAN_CODE(HtmlInputText cOMP_SPLAN_CODE) {
		COMP_SPLAN_CODE = cOMP_SPLAN_CODE;
	}


	public HtmlOutputLabel getCOMP_SPLAN_DESC_LABEL() {
		return COMP_SPLAN_DESC_LABEL;
	}


	public void setCOMP_SPLAN_DESC_LABEL(HtmlOutputLabel cOMP_SPLAN_DESC_LABEL) {
		COMP_SPLAN_DESC_LABEL = cOMP_SPLAN_DESC_LABEL;
	}


	public HtmlInputText getCOMP_SPLAN_DESC() {
		return COMP_SPLAN_DESC;
	}


	public void setCOMP_SPLAN_DESC(HtmlInputText cOMP_SPLAN_DESC) {
		COMP_SPLAN_DESC = cOMP_SPLAN_DESC;
	}


	public HtmlOutputLabel getCOMP_SPLAN_GROUP_YN_LABEL() {
		return COMP_SPLAN_GROUP_YN_LABEL;
	}


	public void setCOMP_SPLAN_GROUP_YN_LABEL(
			HtmlOutputLabel cOMP_SPLAN_GROUP_YN_LABEL) {
		COMP_SPLAN_GROUP_YN_LABEL = cOMP_SPLAN_GROUP_YN_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_SPLAN_GROUP_YN() {
		return COMP_SPLAN_GROUP_YN;
	}


	public void setCOMP_SPLAN_GROUP_YN(HtmlSelectOneMenu cOMP_SPLAN_GROUP_YN) {
		COMP_SPLAN_GROUP_YN = cOMP_SPLAN_GROUP_YN;
	}


	public PM_IL_SUB_PLAN_ACTION() {
		
		PM_IL_SUB_PLAN_BEAN = new PM_IL_SUB_PLAN();
		helper = new PM_IL_SUB_PLAN_HELPER();
		
		setListItemValues();
	}
	
	
	public void onLoad(PhaseEvent event) {
		
		try {

			if (isBlockFlag()) {

				helper.executeQuery(compositeAction);
				
				
				System.out.println("Size  : "+dataList_PM_IL_SUB_PLAN.size());
				if(PM_IL_SUB_PLAN_BEAN.getROWID() != null)
				{
					//helper.postInsert(compositeAction,PM_IL_SUB_PLAN_BEAN);
				}else
				{
					//helper.WHEN_CREATE_RECORD(PM_IL_SUB_PLAN_BEAN, compositeAction);
				}

				
				setBlockFlag(false);
			}
		
			if(("Y").equalsIgnoreCase(PM_IL_SUB_PLAN_BEAN.getSPLAN_GROUP_YN()))
			{
				COMP_UI_M_BUT_GRP_DTL.setDisabled(false);
			}else
			{
				COMP_UI_M_BUT_GRP_DTL.setDisabled(true);
			}
			
									
			
		} catch (Exception e) {
		    e.printStackTrace();		
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			setListSPLAN_GROUP_YN(ListItemUtil.getDropDownListValue(
					connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_JOINT_LIFE_YN", "YESNO"));
			
			
			
			System.out.println("getListSPLAN_GROUP_YN    : "+getListSPLAN_GROUP_YN().size());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_SUB_PLAN_BEAN = new PM_IL_SUB_PLAN();
								
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

				new CRUDHandler().executeDelete(PM_IL_SUB_PLAN_BEAN,
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
				dataList_PM_IL_SUB_PLAN
						.remove(PM_IL_SUB_PLAN_BEAN);
				if (dataList_PM_IL_SUB_PLAN.size() > 0) {

					PM_IL_SUB_PLAN_BEAN = dataList_PM_IL_SUB_PLAN
							.get(0);
				} else if (dataList_PM_IL_SUB_PLAN.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_SUB_PLAN_BEAN.setRowSelected(true);
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
			if (PM_IL_SUB_PLAN_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_SUB_PLAN_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				/*getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));*/
				dataList_PM_IL_SUB_PLAN.add(PM_IL_SUB_PLAN_BEAN);
			} else if (PM_IL_SUB_PLAN_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_SUB_PLAN_BEAN,
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

			/*Added by Janani on 19.05.2018 for records getting saved in table*/
			CommonUtils.getConnection().commit();
			
			PM_IL_SUB_PLAN_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
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
			PM_IL_SUB_PLAN_BEAN = (PM_IL_SUB_PLAN) dataTable
					.getRowData();
			PM_IL_SUB_PLAN_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_SUB_PLAN> PM_IL_SUB_PLAN_ITR = dataList_PM_IL_SUB_PLAN
				.iterator();
		while (PM_IL_SUB_PLAN_ITR.hasNext()) {
			PM_IL_SUB_PLAN_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_SPLAN_CODE.resetValue();
		COMP_SPLAN_DESC.resetValue();
		COMP_SPLAN_GROUP_YN.resetValue();
		
	}
	
	private void intiateAllComponents(){
		
		COMP_SPLAN_CODE_LABEL = new HtmlOutputLabel();
		COMP_SPLAN_CODE = new HtmlInputText();
		COMP_SPLAN_DESC_LABEL = new HtmlOutputLabel();
		COMP_SPLAN_DESC = new HtmlInputText();
		COMP_SPLAN_GROUP_YN_LABEL = new HtmlOutputLabel();
		COMP_SPLAN_GROUP_YN = new HtmlSelectOneMenu();
		COMP_UI_M_BUT_GRP_DTL = new HtmlCommandButton();
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
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void validateSPLAN_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_SUB_PLAN_BEAN().setSPLAN_CODE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	
	public void validateSPLAN_DESC(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_SUB_PLAN_BEAN().setSPLAN_DESC((String) value);
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public void validateSPLAN_GROUP_YN(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {

			getPM_IL_SUB_PLAN_BEAN().setSPLAN_GROUP_YN((String) value);
			
			if(("Y").equalsIgnoreCase(PM_IL_SUB_PLAN_BEAN.getSPLAN_GROUP_YN()))
			{
				COMP_UI_M_BUT_GRP_DTL.setDisabled(false);
			}else
			{
				COMP_UI_M_BUT_GRP_DTL.setDisabled(true);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
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

	public String backButton(){
		return "PILM036_APAC";
	}
	
	public String mainAction(){
		
		compositeAction.getPM_IL_SUB_PLAN_GROUP_ACTION_BEAN().setBlockFlag(true);
		return "PILM036_APAC_PM_IL_SUB_PLAN_GROUP";
	}
}
