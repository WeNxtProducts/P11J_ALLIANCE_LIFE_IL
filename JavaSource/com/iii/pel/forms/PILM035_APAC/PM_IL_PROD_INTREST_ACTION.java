package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
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
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.ConvertFunctions;

import org.richfaces.component.html.HtmlCalendar;

public class PM_IL_PROD_INTREST_ACTION extends CommonAction {

	private PM_IL_PROD_INTREST PM_IL_PROD_INTREST_BEAN;
	private PM_IL_PROD_INTREST_HELPER helper; 
	private HtmlOutputLabel COMP_PRI_PROD_CODE_LABLE;	
	private HtmlOutputLabel COMP_PRI_RATE_LABLE;	
	private HtmlOutputLabel COMP_PRI_RATE_PER_LABLE;			
	private HtmlOutputLabel COMP_PRI_EFF_FM_DT_LABLE;	
	private HtmlOutputLabel COMP_PRI_EFF_TO_DT_LABLE;		
	private HtmlInputText COMP_PRI_PROD_CODE;	
	private HtmlInputText COMP_PRI_RATE;	
	private HtmlInputText COMP_PRI_RATE_PER;			
	private HtmlCalendar COMP_PRI_EFF_FM_DT;	
	private HtmlCalendar COMP_PRI_EFF_TO_DT;
	public PILM035_APAC_COMPOSITE_ACTION compositeAction;
	private List<PM_IL_PROD_INTREST> dataList_PM_IL_PROD_INTREST = new ArrayList<PM_IL_PROD_INTREST>();
	private UIData dataTable;
	
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public List<PM_IL_PROD_INTREST> getDataList_PM_IL_PROD_INTREST() {
		return dataList_PM_IL_PROD_INTREST;
	}
	public void setDataList_PM_IL_PROD_INTREST(
			List<PM_IL_PROD_INTREST> dataList_PM_IL_PROD_INTREST) {
		this.dataList_PM_IL_PROD_INTREST = dataList_PM_IL_PROD_INTREST;
	}
	public PM_IL_PROD_INTREST getPM_IL_PROD_INTREST_BEAN() {
		return PM_IL_PROD_INTREST_BEAN;
	}
	public void setPM_IL_PROD_INTREST_BEAN(
			PM_IL_PROD_INTREST pM_IL_PROD_INTREST_BEAN) {
		PM_IL_PROD_INTREST_BEAN = pM_IL_PROD_INTREST_BEAN;
	}
	public HtmlOutputLabel getCOMP_PRI_PROD_CODE_LABLE() {
		return COMP_PRI_PROD_CODE_LABLE;
	}
	public void setCOMP_PRI_PROD_CODE_LABLE(HtmlOutputLabel cOMP_PRI_PROD_CODE_LABLE) {
		COMP_PRI_PROD_CODE_LABLE = cOMP_PRI_PROD_CODE_LABLE;
	}
	public HtmlOutputLabel getCOMP_PRI_RATE_LABLE() {
		return COMP_PRI_RATE_LABLE;
	}
	public void setCOMP_PRI_RATE_LABLE(HtmlOutputLabel cOMP_PRI_RATE_LABLE) {
		COMP_PRI_RATE_LABLE = cOMP_PRI_RATE_LABLE;
	}
	public HtmlOutputLabel getCOMP_PRI_RATE_PER_LABLE() {
		return COMP_PRI_RATE_PER_LABLE;
	}
	public void setCOMP_PRI_RATE_PER_LABLE(HtmlOutputLabel cOMP_PRI_RATE_PER_LABLE) {
		COMP_PRI_RATE_PER_LABLE = cOMP_PRI_RATE_PER_LABLE;
	}
	public HtmlOutputLabel getCOMP_PRI_EFF_FM_DT_LABLE() {
		return COMP_PRI_EFF_FM_DT_LABLE;
	}
	public void setCOMP_PRI_EFF_FM_DT_LABLE(HtmlOutputLabel cOMP_PRI_EFF_FM_DT_LABLE) {
		COMP_PRI_EFF_FM_DT_LABLE = cOMP_PRI_EFF_FM_DT_LABLE;
	}
	public HtmlOutputLabel getCOMP_PRI_EFF_TO_DT_LABLE() {
		return COMP_PRI_EFF_TO_DT_LABLE;
	}
	public void setCOMP_PRI_EFF_TO_DT_LABLE(HtmlOutputLabel cOMP_PRI_EFF_TO_DT_LABLE) {
		COMP_PRI_EFF_TO_DT_LABLE = cOMP_PRI_EFF_TO_DT_LABLE;
	}
	public HtmlInputText getCOMP_PRI_PROD_CODE() {
		return COMP_PRI_PROD_CODE;
	}
	public void setCOMP_PRI_PROD_CODE(HtmlInputText cOMP_PRI_PROD_CODE) {
		COMP_PRI_PROD_CODE = cOMP_PRI_PROD_CODE;
	}
	public HtmlInputText getCOMP_PRI_RATE() {
		return COMP_PRI_RATE;
	}
	public void setCOMP_PRI_RATE(HtmlInputText cOMP_PRI_RATE) {
		COMP_PRI_RATE = cOMP_PRI_RATE;
	}
	public HtmlInputText getCOMP_PRI_RATE_PER() {
		return COMP_PRI_RATE_PER;
	}
	public void setCOMP_PRI_RATE_PER(HtmlInputText cOMP_PRI_RATE_PER) {
		COMP_PRI_RATE_PER = cOMP_PRI_RATE_PER;
	}
	public HtmlCalendar getCOMP_PRI_EFF_FM_DT() {
		return COMP_PRI_EFF_FM_DT;
	}
	public void setCOMP_PRI_EFF_FM_DT(HtmlCalendar cOMP_PRI_EFF_FM_DT) {
		COMP_PRI_EFF_FM_DT = cOMP_PRI_EFF_FM_DT;
	}
	public HtmlCalendar getCOMP_PRI_EFF_TO_DT() {
		return COMP_PRI_EFF_TO_DT;
	}
	public void setCOMP_PRI_EFF_TO_DT(HtmlCalendar cOMP_PRI_EFF_TO_DT) {
		COMP_PRI_EFF_TO_DT = cOMP_PRI_EFF_TO_DT;
	}
	public PM_IL_PROD_INTREST_ACTION() {

		PM_IL_PROD_INTREST_BEAN = new PM_IL_PROD_INTREST();
		helper = new PM_IL_PROD_INTREST_HELPER();
		initializeallcomponent();
	}

	public void onLoad(PhaseEvent event) {
		try {


			if (isBlockFlag()) {
				getErrorMap().clear();
				getWarningMap().clear();
				helper.executeQuery(compositeAction);
				
				if (PM_IL_PROD_INTREST_BEAN.getROWID() == null) {
					helper.WHEN_CREATE_RECORD(compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	void initializeallcomponent(){
		COMP_PRI_PROD_CODE_LABLE= new HtmlOutputLabel();	
		COMP_PRI_RATE_LABLE = new HtmlOutputLabel();	
		COMP_PRI_RATE_PER_LABLE= new HtmlOutputLabel();			
		COMP_PRI_EFF_FM_DT_LABLE= new HtmlOutputLabel();	
		COMP_PRI_EFF_TO_DT_LABLE= new HtmlOutputLabel();		
		COMP_PRI_PROD_CODE= new HtmlInputText();	
		COMP_PRI_RATE= new HtmlInputText();	
		COMP_PRI_RATE_PER= new HtmlInputText();			
		COMP_PRI_EFF_FM_DT= new HtmlCalendar();	
		COMP_PRI_EFF_TO_DT= new HtmlCalendar();
	}


	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_INTREST_BEAN = (PM_IL_PROD_INTREST) dataTable.getRowData();
			PM_IL_PROD_INTREST_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetAllComponent() {
		COMP_PRI_PROD_CODE.resetValue();	
		COMP_PRI_RATE.resetValue();	
		COMP_PRI_RATE_PER.resetValue();	
		COMP_PRI_EFF_FM_DT.resetValue();
		COMP_PRI_EFF_TO_DT.resetValue();
		
	}
	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_INTREST> PM_IL_PROD_INTREST_BEAN_ITR = dataList_PM_IL_PROD_INTREST
				.iterator();
		while (PM_IL_PROD_INTREST_BEAN_ITR.hasNext()) {
			PM_IL_PROD_INTREST_BEAN_ITR.next().setRowSelected(false);
		}
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PROD_INTREST_BEAN = new PM_IL_PROD_INTREST();
				//helper.whenCreateRecord(PM_IL_PLAN_MOP_BEAN);
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

				new CRUDHandler().executeDelete(PM_IL_PROD_INTREST_BEAN,
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
				dataList_PM_IL_PROD_INTREST.remove(PM_IL_PROD_INTREST_BEAN);
				if (dataList_PM_IL_PROD_INTREST.size() > 0) {

					PM_IL_PROD_INTREST_BEAN = dataList_PM_IL_PROD_INTREST.get(0);
				} else if (dataList_PM_IL_PROD_INTREST.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_INTREST_BEAN.setRowSelected(true);
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
    	getErrorMap().clear();
		getWarningMap().clear();
	try {
		if (PM_IL_PROD_INTREST_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			helper.preInsert(PM_IL_PROD_INTREST_BEAN, compositeAction);
			new CRUDHandler().executeInsert(PM_IL_PROD_INTREST_BEAN,
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
			dataList_PM_IL_PROD_INTREST.add(PM_IL_PROD_INTREST_BEAN);
		} else if (PM_IL_PROD_INTREST_BEAN.getROWID() != null
				&& isUPDATE_ALLOWED()) {
			helper.preUpdate(PM_IL_PROD_INTREST_BEAN, compositeAction);
			new CRUDHandler().executeUpdate(PM_IL_PROD_INTREST_BEAN,
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
		CommonUtils.getConnection().commit();
		PM_IL_PROD_INTREST_BEAN.setRowSelected(true);
	} catch (Exception exc) {
	
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + exc.getMessage());
	}
}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validatePRI_RATE(FacesContext context,
			UIComponent component, Object value){
		try{
			int Value = (Integer)value;
			PM_IL_PROD_INTREST_BEAN.setPRI_RATE(Value);
			COMP_PRI_RATE.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatePRI_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			
			Date Value = (Date)value;
	    	Date EFF_TO_DT = PM_IL_PROD_INTREST_BEAN.getPRI_EFF_TO_DT();
	    	
	    		if(EFF_TO_DT!=null && EFF_TO_DT.before(Value)){
	    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
	    		}
	    		if(Value!=null && Value.before(ConvertFunctions.to_date("01/01/1900", PELConstants.dbDateFormat))){
	    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
	    		}
	    	
				
			PM_IL_PROD_INTREST_BEAN.setPRI_EFF_FM_DT(Value);
			COMP_PRI_EFF_FM_DT.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePRI_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date Value = (Date)value;
			Date EFF_FM_DT = PM_IL_PROD_INTREST_BEAN.getPRI_EFF_FM_DT();
    		if(EFF_FM_DT !=null){
    			
    		if(Value!=null && Value.before(EFF_FM_DT)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
    		}
    		if(Value!=null && Value.after(ConvertFunctions.to_date("31/12/2999", PELConstants.dbDateFormat))){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
    		}
    		}
		
			PM_IL_PROD_INTREST_BEAN.setPRI_EFF_TO_DT(Value);
			COMP_PRI_EFF_TO_DT.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void validatePRI_RATE_PER(FacesContext context,
			UIComponent component, Object value){
		try{
			int Value = (Integer)value;
			if(Value>0){
			PM_IL_PROD_INTREST_BEAN.setPRI_RATE_PER(Value);
			}else{
				throw new Exception("Rateper Should be Greater then Zero");
			}
			COMP_PRI_RATE_PER.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
