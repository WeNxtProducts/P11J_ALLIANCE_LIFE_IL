package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PLAN_MOP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMOP_TOLL_TYP_LABEL;

	private HtmlSelectOneMenu COMP_PMOP_TOLL_TYP;

	private HtmlOutputLabel COMP_PMOP_EXCESS_RATE_LABEL;

	private HtmlInputText COMP_PMOP_EXCESS_RATE;

	private HtmlOutputLabel COMP_PMOP_EXCESS_RATE_PER_LABEL;

	private HtmlInputText COMP_PMOP_EXCESS_RATE_PER;

	private HtmlOutputLabel COMP_PMOP_EX_TOLL_TYP_LABEL;

	private HtmlSelectOneMenu COMP_PMOP_EX_TOLL_TYP;

	private HtmlOutputLabel COMP_PMOP_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_PMOP_EFF_TO_DT;

	private HtmlOutputLabel COMP_PMOP_RATE_LABEL;

	private HtmlInputText COMP_PMOP_RATE;

	private HtmlOutputLabel COMP_PMOP_RATE_PER_LABEL;

	private HtmlInputText COMP_PMOP_RATE_PER;

	private HtmlOutputLabel COMP_PMOP_SHORT_RATE_LABEL;

	private HtmlInputText COMP_PMOP_SHORT_RATE;

	private HtmlOutputLabel COMP_PMOP_SHORT_RATE_PER_LABEL;

	private HtmlInputText COMP_PMOP_SHORT_RATE_PER;

	private HtmlOutputLabel COMP_PMOP_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_PMOP_EFF_FM_DT;

	private HtmlOutputLabel COMP_PMOP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PMOP_TYPE;

	private HtmlOutputLabel COMP_PMOP_FIXED_PREM_VAL_LABEL;

	private HtmlInputText COMP_PMOP_FIXED_PREM_VAL;

	private PM_IL_PLAN_MOP PM_IL_PLAN_MOP_BEAN;

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PLAN_MOP_HELPER helper;

	private List<PM_IL_PLAN_MOP> dataList_PM_IL_PLAN_MOP = new ArrayList<PM_IL_PLAN_MOP>();

	private UIData dataTable;

	private List<SelectItem> listPMOP_TOLL_TYP = new ArrayList<SelectItem>();

	private List<SelectItem> listPMOP_EX_TOLL_TYP = new ArrayList<SelectItem>();

	private List<SelectItem> listPMOP_TYPE = new ArrayList<SelectItem>();

	public PM_IL_PLAN_MOP_ACTION() {

		PM_IL_PLAN_MOP_BEAN = new PM_IL_PLAN_MOP();
		helper = new PM_IL_PLAN_MOP_HELPER();
		prepareDropDownList();
	}
	
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			listPMOP_TOLL_TYP = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN_MOP",
					"PM_IL_PLAN_MOP.PMOP_TOLL_TYP", "MOP_TOLL_TYP");
			
			listPMOP_EX_TOLL_TYP = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN_MOP",
					"PM_IL_PLAN_MOP.PMOP_EX_TOLL_TYP", "MOP_TOLL_TYP");
			
			listPMOP_TYPE = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN_MOP",
					"PM_IL_PLAN_MOP.PMOP_TYPE", "MOP");
			
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PMOP_TOLL_TYP_LABEL() {
		return COMP_PMOP_TOLL_TYP_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PMOP_TOLL_TYP() {
		return COMP_PMOP_TOLL_TYP;
	}

	public void setCOMP_PMOP_TOLL_TYP_LABEL(
			HtmlOutputLabel COMP_PMOP_TOLL_TYP_LABEL) {
		this.COMP_PMOP_TOLL_TYP_LABEL = COMP_PMOP_TOLL_TYP_LABEL;
	}

	public void setCOMP_PMOP_TOLL_TYP(HtmlSelectOneMenu COMP_PMOP_TOLL_TYP) {
		this.COMP_PMOP_TOLL_TYP = COMP_PMOP_TOLL_TYP;
	}

	public HtmlOutputLabel getCOMP_PMOP_EXCESS_RATE_LABEL() {
		return COMP_PMOP_EXCESS_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_EXCESS_RATE() {
		return COMP_PMOP_EXCESS_RATE;
	}

	public void setCOMP_PMOP_EXCESS_RATE_LABEL(
			HtmlOutputLabel COMP_PMOP_EXCESS_RATE_LABEL) {
		this.COMP_PMOP_EXCESS_RATE_LABEL = COMP_PMOP_EXCESS_RATE_LABEL;
	}

	public void setCOMP_PMOP_EXCESS_RATE(HtmlInputText COMP_PMOP_EXCESS_RATE) {
		this.COMP_PMOP_EXCESS_RATE = COMP_PMOP_EXCESS_RATE;
	}

	public HtmlOutputLabel getCOMP_PMOP_EXCESS_RATE_PER_LABEL() {
		return COMP_PMOP_EXCESS_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_EXCESS_RATE_PER() {
		return COMP_PMOP_EXCESS_RATE_PER;
	}

	public void setCOMP_PMOP_EXCESS_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PMOP_EXCESS_RATE_PER_LABEL) {
		this.COMP_PMOP_EXCESS_RATE_PER_LABEL = COMP_PMOP_EXCESS_RATE_PER_LABEL;
	}

	public void setCOMP_PMOP_EXCESS_RATE_PER(
			HtmlInputText COMP_PMOP_EXCESS_RATE_PER) {
		this.COMP_PMOP_EXCESS_RATE_PER = COMP_PMOP_EXCESS_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PMOP_EX_TOLL_TYP_LABEL() {
		return COMP_PMOP_EX_TOLL_TYP_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PMOP_EX_TOLL_TYP() {
		return COMP_PMOP_EX_TOLL_TYP;
	}

	public void setCOMP_PMOP_EX_TOLL_TYP_LABEL(
			HtmlOutputLabel COMP_PMOP_EX_TOLL_TYP_LABEL) {
		this.COMP_PMOP_EX_TOLL_TYP_LABEL = COMP_PMOP_EX_TOLL_TYP_LABEL;
	}

	public void setCOMP_PMOP_EX_TOLL_TYP(HtmlSelectOneMenu COMP_PMOP_EX_TOLL_TYP) {
		this.COMP_PMOP_EX_TOLL_TYP = COMP_PMOP_EX_TOLL_TYP;
	}

	public HtmlOutputLabel getCOMP_PMOP_EFF_TO_DT_LABEL() {
		return COMP_PMOP_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMOP_EFF_TO_DT() {
		return COMP_PMOP_EFF_TO_DT;
	}

	public void setCOMP_PMOP_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_PMOP_EFF_TO_DT_LABEL) {
		this.COMP_PMOP_EFF_TO_DT_LABEL = COMP_PMOP_EFF_TO_DT_LABEL;
	}

	public void setCOMP_PMOP_EFF_TO_DT(HtmlCalendar COMP_PMOP_EFF_TO_DT) {
		this.COMP_PMOP_EFF_TO_DT = COMP_PMOP_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_PMOP_RATE_LABEL() {
		return COMP_PMOP_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_RATE() {
		return COMP_PMOP_RATE;
	}

	public void setCOMP_PMOP_RATE_LABEL(HtmlOutputLabel COMP_PMOP_RATE_LABEL) {
		this.COMP_PMOP_RATE_LABEL = COMP_PMOP_RATE_LABEL;
	}

	public void setCOMP_PMOP_RATE(HtmlInputText COMP_PMOP_RATE) {
		this.COMP_PMOP_RATE = COMP_PMOP_RATE;
	}

	public HtmlOutputLabel getCOMP_PMOP_RATE_PER_LABEL() {
		return COMP_PMOP_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_RATE_PER() {
		return COMP_PMOP_RATE_PER;
	}

	public void setCOMP_PMOP_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PMOP_RATE_PER_LABEL) {
		this.COMP_PMOP_RATE_PER_LABEL = COMP_PMOP_RATE_PER_LABEL;
	}

	public void setCOMP_PMOP_RATE_PER(HtmlInputText COMP_PMOP_RATE_PER) {
		this.COMP_PMOP_RATE_PER = COMP_PMOP_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PMOP_SHORT_RATE_LABEL() {
		return COMP_PMOP_SHORT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_SHORT_RATE() {
		return COMP_PMOP_SHORT_RATE;
	}

	public void setCOMP_PMOP_SHORT_RATE_LABEL(
			HtmlOutputLabel COMP_PMOP_SHORT_RATE_LABEL) {
		this.COMP_PMOP_SHORT_RATE_LABEL = COMP_PMOP_SHORT_RATE_LABEL;
	}

	public void setCOMP_PMOP_SHORT_RATE(HtmlInputText COMP_PMOP_SHORT_RATE) {
		this.COMP_PMOP_SHORT_RATE = COMP_PMOP_SHORT_RATE;
	}

	public HtmlOutputLabel getCOMP_PMOP_SHORT_RATE_PER_LABEL() {
		return COMP_PMOP_SHORT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_SHORT_RATE_PER() {
		return COMP_PMOP_SHORT_RATE_PER;
	}

	public void setCOMP_PMOP_SHORT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PMOP_SHORT_RATE_PER_LABEL) {
		this.COMP_PMOP_SHORT_RATE_PER_LABEL = COMP_PMOP_SHORT_RATE_PER_LABEL;
	}

	public void setCOMP_PMOP_SHORT_RATE_PER(
			HtmlInputText COMP_PMOP_SHORT_RATE_PER) {
		this.COMP_PMOP_SHORT_RATE_PER = COMP_PMOP_SHORT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PMOP_EFF_FM_DT_LABEL() {
		return COMP_PMOP_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMOP_EFF_FM_DT() {
		return COMP_PMOP_EFF_FM_DT;
	}

	public void setCOMP_PMOP_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_PMOP_EFF_FM_DT_LABEL) {
		this.COMP_PMOP_EFF_FM_DT_LABEL = COMP_PMOP_EFF_FM_DT_LABEL;
	}

	public void setCOMP_PMOP_EFF_FM_DT(HtmlCalendar COMP_PMOP_EFF_FM_DT) {
		this.COMP_PMOP_EFF_FM_DT = COMP_PMOP_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_PMOP_TYPE_LABEL() {
		return COMP_PMOP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PMOP_TYPE() {
		return COMP_PMOP_TYPE;
	}

	public void setCOMP_PMOP_TYPE_LABEL(HtmlOutputLabel COMP_PMOP_TYPE_LABEL) {
		this.COMP_PMOP_TYPE_LABEL = COMP_PMOP_TYPE_LABEL;
	}

	public void setCOMP_PMOP_TYPE(HtmlSelectOneMenu COMP_PMOP_TYPE) {
		this.COMP_PMOP_TYPE = COMP_PMOP_TYPE;
	}

	public HtmlOutputLabel getCOMP_PMOP_FIXED_PREM_VAL_LABEL() {
		return COMP_PMOP_FIXED_PREM_VAL_LABEL;
	}

	public HtmlInputText getCOMP_PMOP_FIXED_PREM_VAL() {
		return COMP_PMOP_FIXED_PREM_VAL;
	}

	public void setCOMP_PMOP_FIXED_PREM_VAL_LABEL(
			HtmlOutputLabel COMP_PMOP_FIXED_PREM_VAL_LABEL) {
		this.COMP_PMOP_FIXED_PREM_VAL_LABEL = COMP_PMOP_FIXED_PREM_VAL_LABEL;
	}

	public void setCOMP_PMOP_FIXED_PREM_VAL(
			HtmlInputText COMP_PMOP_FIXED_PREM_VAL) {
		this.COMP_PMOP_FIXED_PREM_VAL = COMP_PMOP_FIXED_PREM_VAL;
	}

	public PM_IL_PLAN_MOP getPM_IL_PLAN_MOP_BEAN() {
		return PM_IL_PLAN_MOP_BEAN;
	}

	public void setPM_IL_PLAN_MOP_BEAN(PM_IL_PLAN_MOP PM_IL_PLAN_MOP_BEAN) {
		this.PM_IL_PLAN_MOP_BEAN = PM_IL_PLAN_MOP_BEAN;
	}

	public List<PM_IL_PLAN_MOP> getDataList_PM_IL_PLAN_MOP() {
		return dataList_PM_IL_PLAN_MOP;
	}

	public void setDataListPM_IL_PLAN_MOP(
			List<PM_IL_PLAN_MOP> dataList_PM_IL_PLAN_MOP) {
		this.dataList_PM_IL_PLAN_MOP = dataList_PM_IL_PLAN_MOP;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PLAN_MOP_BEAN = new PM_IL_PLAN_MOP();
				helper.whenCreateRecord(PM_IL_PLAN_MOP_BEAN);
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

				new CRUDHandler().executeDelete(PM_IL_PLAN_MOP_BEAN,
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
				dataList_PM_IL_PLAN_MOP.remove(PM_IL_PLAN_MOP_BEAN);
				if (dataList_PM_IL_PLAN_MOP.size() > 0) {

					PM_IL_PLAN_MOP_BEAN = dataList_PM_IL_PLAN_MOP.get(0);
				} else if (dataList_PM_IL_PLAN_MOP.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PLAN_MOP_BEAN.setRowSelected(true);
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
			if (PM_IL_PLAN_MOP_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInsert(PM_IL_PLAN_MOP_BEAN, compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PLAN_MOP_BEAN,
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
				dataList_PM_IL_PLAN_MOP.add(PM_IL_PLAN_MOP_BEAN);
			} else if (PM_IL_PLAN_MOP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PLAN_MOP_BEAN,
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

			PM_IL_PLAN_MOP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			String temp=extractDBErrorMessage(exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + temp);
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + temp);
		}
	}
	
	public static String extractDBErrorMessage(String dbErrorMessage){
		if ((dbErrorMessage != null) ){
			if ((dbErrorMessage.indexOf(":")!=-1) && (dbErrorMessage.indexOf("ORA")!=-1)){
				int index = dbErrorMessage.indexOf(":");
				dbErrorMessage = dbErrorMessage.substring(index+1);
				dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
				return dbErrorMessage;
			}else{
				dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
				return dbErrorMessage;
			}
		}
		return dbErrorMessage;
	}
	

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PLAN_MOP_BEAN = (PM_IL_PLAN_MOP) dataTable.getRowData();
			PM_IL_PLAN_MOP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PLAN_MOP> PM_IL_PLAN_MOP_ITR = dataList_PM_IL_PLAN_MOP
				.iterator();
		while (PM_IL_PLAN_MOP_ITR.hasNext()) {
			PM_IL_PLAN_MOP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PMOP_TOLL_TYP.resetValue();
		COMP_PMOP_EXCESS_RATE.resetValue();
		COMP_PMOP_EXCESS_RATE_PER.resetValue();
		COMP_PMOP_EX_TOLL_TYP.resetValue();
		COMP_PMOP_EFF_TO_DT.resetValue();
		COMP_PMOP_RATE.resetValue();
		COMP_PMOP_RATE_PER.resetValue();
		COMP_PMOP_SHORT_RATE.resetValue();
		COMP_PMOP_SHORT_RATE_PER.resetValue();
		COMP_PMOP_EFF_FM_DT.resetValue();
		COMP_PMOP_TYPE.resetValue();
		COMP_PMOP_FIXED_PREM_VAL.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPMOP_TOLL_TYP() {
		if (listPMOP_TOLL_TYP.size() == 0) {
			listPMOP_TOLL_TYP.clear();
			try {
				listPMOP_TOLL_TYP = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPMOP_TOLL_TYP;
	}

	public void setListPMOP_TOLL_TYP(List<SelectItem> listPMOP_TOLL_TYP) {
		this.listPMOP_TOLL_TYP = listPMOP_TOLL_TYP;
	}

	public List<SelectItem> getListPMOP_EX_TOLL_TYP() {
		if (listPMOP_EX_TOLL_TYP.size() == 0) {
			listPMOP_EX_TOLL_TYP.clear();
			try {
				listPMOP_EX_TOLL_TYP = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPMOP_EX_TOLL_TYP;
	}

	public void setListPMOP_EX_TOLL_TYP(List<SelectItem> listPMOP_EX_TOLL_TYP) {
		this.listPMOP_EX_TOLL_TYP = listPMOP_EX_TOLL_TYP;
	}

	public List<SelectItem> getListPMOP_TYPE() {
		if (listPMOP_TYPE.size() == 0) {
			listPMOP_TYPE.clear();
			try {
				listPMOP_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPMOP_TYPE;
	}

	public void setListPMOP_TYPE(List<SelectItem> listPMOP_TYPE) {
		this.listPMOP_TYPE = listPMOP_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(PM_IL_PLAN_MOP_BEAN.getROWID() == null){
					helper.whenCreateRecord(PM_IL_PLAN_MOP_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void validatePMOP_TYPE(FacesContext context,
			UIComponent component, Object value){
		try{
			String PMOP_TYPE = (String)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_TYPE(PMOP_TYPE);
			helper.whenValidate_PMOP_TYPE(PM_IL_PLAN_MOP_BEAN, PMOP_TYPE);
			COMP_PMOP_RATE.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validatePMOP_TOLL_TYP(FacesContext context,
			UIComponent component, Object value){
		try{
			String PMOP_TOLL_TYPE = (String)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_TOLL_TYP(PMOP_TOLL_TYPE);
			if("F".equalsIgnoreCase(PM_IL_PLAN_MOP_BEAN.getPMOP_TOLL_TYP())){
				PM_IL_PLAN_MOP_BEAN.setPMOP_SHORT_RATE_PER(1.0);
				COMP_PMOP_SHORT_RATE_PER.setDisabled(true);
			}else{
				COMP_PMOP_SHORT_RATE_PER.setDisabled(false);
			}
			COMP_PMOP_SHORT_RATE_PER.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validatePMOP_EX_TOLL_TYP(FacesContext context,
			UIComponent component, Object value){
		try{
			String PMOP_EX_TOLL_TYPE = (String)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_TOLL_TYP(PMOP_EX_TOLL_TYPE);
			if("F".equalsIgnoreCase(PM_IL_PLAN_MOP_BEAN.getPMOP_TOLL_TYP())){
				PM_IL_PLAN_MOP_BEAN.setPMOP_EXCESS_RATE_PER(1.0);
				COMP_PMOP_EXCESS_RATE_PER.setDisabled(true);
			}else{
				COMP_PMOP_EXCESS_RATE_PER.setDisabled(false);
			}
			COMP_PMOP_EXCESS_RATE_PER.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMOP_RATE(FacesContext context,
			UIComponent component, Object value){
		try{
			Double PMOP_RATE = (Double)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_RATE(PMOP_RATE);
			helper.whenValidate_PMOP_RATE(PMOP_RATE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMOP_RATE_PER(FacesContext context,
			UIComponent component, Object value){
		try{
			Double PMOP_RATE_PER = (Double)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_RATE_PER(PMOP_RATE_PER);
			helper.whenValidate_PMOP_RATE_PER(PMOP_RATE_PER);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMOP_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date PMOP_EFF_FM_DT = (Date)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_EFF_FM_DT(PMOP_EFF_FM_DT);
			helper.whenValidate_PMOP_EFF_FM_DT(PM_IL_PLAN_MOP_BEAN, PMOP_EFF_FM_DT);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMOP_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date PMOP_EFF_TO_DT = (Date)value;
			PM_IL_PLAN_MOP_BEAN.setPMOP_EFF_TO_DT(PMOP_EFF_TO_DT);
			helper.whenValidate_PMOP_EFF_TO_DT(PM_IL_PLAN_MOP_BEAN, PMOP_EFF_TO_DT);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
