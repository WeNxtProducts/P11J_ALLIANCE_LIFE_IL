package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_CONDITION_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PLCOND_CODE_LABEL;

	private HtmlInputText COMP_PLCOND_CODE;

	private HtmlOutputLabel COMP_PLCOND_DESC_LABEL;

	private HtmlInputTextarea COMP_PLCOND_DESC;

	private PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_CONDITION_HELPER helper;

	private List<PT_IL_POL_CONDITION> dataList_PT_IL_POL_CONDITION = new ArrayList<PT_IL_POL_CONDITION>();

	private UIData dataTable;

	public PT_IL_POL_CONDITION_ACTION() {

		PT_IL_POL_CONDITION_BEAN = new PT_IL_POL_CONDITION();
		helper = new PT_IL_POL_CONDITION_HELPER();
		instantiateAllComponent();
	}

	public PT_IL_POL_CONDITION getPT_IL_POL_CONDITION_BEAN() {
		return PT_IL_POL_CONDITION_BEAN;
	}

	public void setPT_IL_POL_CONDITION_BEAN(
			PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN) {
		this.PT_IL_POL_CONDITION_BEAN = PT_IL_POL_CONDITION_BEAN;
	}

	public List<PT_IL_POL_CONDITION> getDataList_PT_IL_POL_CONDITION() {
		return dataList_PT_IL_POL_CONDITION;
	}

	public void setDataListPT_IL_POL_CONDITION(
			List<PT_IL_POL_CONDITION> dataList_PT_IL_POL_CONDITION) {
		this.dataList_PT_IL_POL_CONDITION = dataList_PT_IL_POL_CONDITION;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_CONDITION_BEAN = new PT_IL_POL_CONDITION();
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_POL_CONDITION_BEAN,
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
				dataList_PT_IL_POL_CONDITION.remove(PT_IL_POL_CONDITION_BEAN);
				if (dataList_PT_IL_POL_CONDITION.size() > 0) {

					PT_IL_POL_CONDITION_BEAN = dataList_PT_IL_POL_CONDITION
					.get(0);
				} else if (dataList_PT_IL_POL_CONDITION.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_CONDITION_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put("deleteRow", Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
			}
			/*Added by Ameen on 08-06-2017 for ssp call id ZBILQC-1720056*/
			CommonUtils.getConnection().commit();
			/*End*/
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	}

	public void postRecord(ActionEvent event) {
		try {
			/*setINSERT_ALLOWED(true);
			setUPDATE_ALLOWED(true);
			setDELETE_ALLOWED(true);*/
			System.out.println("Enter into PostRecord      "+PT_IL_POL_CONDITION_BEAN.getPLCOND_COND_TYP()+"     "+isUPDATE_ALLOWED()+"     "
			+PT_IL_POL_CONDITION_BEAN.getROWID());
			if (PT_IL_POL_CONDITION_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PT_IL_POL_CONDITION_BEAN, 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				new CRUDHandler().executeInsert(PT_IL_POL_CONDITION_BEAN,
						CommonUtils.getConnection());
				
				
				/*Modified by Janani on 04.07.2017 for ZBILQC-1720056*/
				
				/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));*/
				
				getWarningMap().put("SaveRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				
				/*End*/
				
				dataList_PT_IL_POL_CONDITION.add(PT_IL_POL_CONDITION_BEAN);
			} else if (PT_IL_POL_CONDITION_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				System.out.println("conditionType in update     "+PT_IL_POL_CONDITION_BEAN.getPLCOND_COND_TYP());
				
				helper.preUpdate(PT_IL_POL_CONDITION_BEAN, 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				new CRUDHandler().executeUpdate(PT_IL_POL_CONDITION_BEAN,
						CommonUtils.getConnection());
				
				/*Modified by Janani on 04.07.2017 for ZBILQC-1720056*/
				
				/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));*/
				
				
				getWarningMap().put("SaveRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				/*End*/
				
				
			}
			PT_IL_POL_CONDITION_BEAN.setRowSelected(true);
			
			CommonUtils.getConnection().commit();
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
			PT_IL_POL_CONDITION_BEAN = (PT_IL_POL_CONDITION) dataTable
			.getRowData();
			PT_IL_POL_CONDITION_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_CONDITION> PT_IL_POL_CONDITION_ITR = dataList_PT_IL_POL_CONDITION
		.iterator();
		while (PT_IL_POL_CONDITION_ITR.hasNext()) {
			PT_IL_POL_CONDITION_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PLCOND_CODE.resetValue();
		COMP_PLCOND_CODE.resetValue();
		COMP_PLCOND_DESC.resetValue();
		COMP_PLCOND_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			getWarningMap().put("deleteRow",Messages.getString(
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

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				
				setList_CONDITION(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_CONDITION",
						"PT_IL_POL_CONDITION.PLCOND_COND_TYP", "IL_COND_TYP"));
				
				if(PT_IL_POL_CONDITION_BEAN.getROWID() != null){
					helper.postQuery(PT_IL_POL_CONDITION_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void validatePLCOND_CODE(FacesContext context, UIComponent component, Object value) {
		try {
			PT_IL_POL_CONDITION_BEAN.setPLCOND_CODE((String) value);
			/*//helper.WHEN_VALIDATE_PLCOND_CODE(PT_IL_POL_CONDITION_BEAN, 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			//COMP_PLCOND_DESC.resetValue();
			 
*/		
			} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> preparePLCOND_CODELOV(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_CONDITION";
		String fieldName = "PLCOND_CODE";
		Object param1 = "IL_COND";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1,
					null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	public HtmlOutputLabel getCOMP_PLCOND_CODE_LABEL() {
		return COMP_PLCOND_CODE_LABEL;
	}

	public void setCOMP_PLCOND_CODE_LABEL(HtmlOutputLabel comp_plcond_code_label) {
		COMP_PLCOND_CODE_LABEL = comp_plcond_code_label;
	}

	public HtmlInputText getCOMP_PLCOND_CODE() {
		return COMP_PLCOND_CODE;
	}

	public void setCOMP_PLCOND_CODE(HtmlInputText comp_plcond_code) {
		COMP_PLCOND_CODE = comp_plcond_code;
	}

	public HtmlOutputLabel getCOMP_PLCOND_DESC_LABEL() {
		return COMP_PLCOND_DESC_LABEL;
	}

	public void setCOMP_PLCOND_DESC_LABEL(HtmlOutputLabel comp_plcond_desc_label) {
		COMP_PLCOND_DESC_LABEL = comp_plcond_desc_label;
	}

	
	public HtmlInputTextarea getCOMP_PLCOND_DESC() {
		return COMP_PLCOND_DESC;
	}

	public void setCOMP_PLCOND_DESC(HtmlInputTextarea cOMP_PLCOND_DESC) {
		COMP_PLCOND_DESC = cOMP_PLCOND_DESC;
	}

	/**
	 * Disables all components in PT_IL_POL_CONDITION_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PLCOND_CODE.setDisabled(disabled);
		COMP_PLCOND_DESC.setDisabled(disabled);
		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_PLCOND_CONDITION.setDisabled(disabled);
		/*end*/
	}


	/**
	 * Instantiates all components in PT_IL_POL_CONDITION_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PLCOND_CODE				 = new HtmlInputText();
		COMP_PLCOND_DESC				 = new HtmlInputTextarea();

		// Instantiating HtmlOutputLabel
		COMP_PLCOND_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_PLCOND_DESC_LABEL				 = new HtmlOutputLabel();
		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_PLCOND_CONDITION=new HtmlSelectOneMenu();
/*end*/
	}

private List<SelectItem> list_CONDITION = new ArrayList<SelectItem>();

public List<SelectItem> getList_CONDITION() {
	return list_CONDITION;
}

public void setList_CONDITION(List<SelectItem> list_CONDITION) {
	this.list_CONDITION = list_CONDITION;
}

private HtmlOutputLabel COMP_PLCOND_CONDITION_LABEL;

public HtmlOutputLabel getCOMP_PLCOND_CONDITION_LABEL() {
	return COMP_PLCOND_CONDITION_LABEL;
}

public void setCOMP_PLCOND_CONDITION_LABEL(
		HtmlOutputLabel cOMP_PLCOND_CONDITION_LABEL) {
	COMP_PLCOND_CONDITION_LABEL = cOMP_PLCOND_CONDITION_LABEL;
}

private HtmlSelectOneMenu COMP_PLCOND_CONDITION;

public HtmlSelectOneMenu getCOMP_PLCOND_CONDITION() {
	return COMP_PLCOND_CONDITION;
}

public void setCOMP_PLCOND_CONDITION(HtmlSelectOneMenu cOMP_PLCOND_CONDITION) {
	COMP_PLCOND_CONDITION = cOMP_PLCOND_CONDITION;
}


public void PMED_COND_TYPE_WHEN_VALIDATE_ITEM(FacesContext context, UIComponent component, Object value) {
	try {
		PT_IL_POL_CONDITION_BEAN.setPLCOND_COND_TYP((String) value); 
		} catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

public void changeConditiontype(ActionEvent event) {
	String str = null;
	try
	{
	CommonUtils.clearMaps(this);
	String conditionType=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
	int currentIndex=this.dataTable.getRowIndex();
	


	PT_IL_POL_CONDITION_BEAN=(PT_IL_POL_CONDITION)dataList_PT_IL_POL_CONDITION.get(currentIndex);
	PT_IL_POL_CONDITION_BEAN.setPLCOND_COND_TYP(conditionType);
	
	COMP_PLCOND_CONDITION.resetValue();
	
	System.out.println("conditionType      "+conditionType+"        "+PT_IL_POL_CONDITION_BEAN.getPLCOND_COND_TYP());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
