package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_STATUS_2;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PLAN_MEMBERS_ACTION extends CommonAction {
	
private HtmlOutputLabel COMP_PMEM_RELATION_TYPE_LABEL;

public HtmlOutputLabel getCOMP_PMEM_RELATION_TYPE_LABEL() {
	return COMP_PMEM_RELATION_TYPE_LABEL;
}

public void setCOMP_PMEM_RELATION_TYPE_LABEL(
		HtmlOutputLabel cOMP_PMEM_RELATION_TYPE_LABEL) {
	COMP_PMEM_RELATION_TYPE_LABEL = cOMP_PMEM_RELATION_TYPE_LABEL;
}
private HtmlSelectOneMenu COMP_PMEM_RELATION_TYPE;
public HtmlSelectOneMenu getCOMP_PMEM_RELATION_TYPE() {
	return COMP_PMEM_RELATION_TYPE;
}

public void setCOMP_PMEM_RELATION_TYPE(HtmlSelectOneMenu cOMP_PMEM_RELATION_TYPE) {
	COMP_PMEM_RELATION_TYPE = cOMP_PMEM_RELATION_TYPE;
}

private PM_IL_PLAN_MEMBERS_HELPER helper;



private PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN;

public PM_IL_PLAN_MEMBERS getPM_IL_PLAN_MEMBERS_BEAN() {
	return PM_IL_PLAN_MEMBERS_BEAN;
}

public void setPM_IL_PLAN_MEMBERS_BEAN(
		PM_IL_PLAN_MEMBERS pM_IL_PLAN_MEMBERS_BEAN) {
	PM_IL_PLAN_MEMBERS_BEAN = pM_IL_PLAN_MEMBERS_BEAN;
}

public PILM003_APAC_COMPOSITE_ACTION compositeAction;

public PM_IL_PLAN_MEMBERS_ACTION(){
	PM_IL_PLAN_MEMBERS_BEAN =new PM_IL_PLAN_MEMBERS();
	helper = new PM_IL_PLAN_MEMBERS_HELPER();
	prepareDropDownList();
	/*Added by sankaranarayanan on 21/04/2017 for Hospital cash plan */
	initializeallcomponent();
/*end*/
}
public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
}

private HtmlOutputLabel COMP_PMEM_NO_OF_LIFE_LABEL;

public HtmlOutputLabel getCOMP_PMEM_NO_OF_LIFE_LABEL() {
	return COMP_PMEM_NO_OF_LIFE_LABEL;
}

public void setCOMP_PMEM_NO_OF_LIFE_LABEL(
		HtmlOutputLabel cOMP_PMEM_NO_OF_LIFE_LABEL) {
	COMP_PMEM_NO_OF_LIFE_LABEL = cOMP_PMEM_NO_OF_LIFE_LABEL;
}

private HtmlInputText COMP_PMEM_NO_OF_LIFE;

public HtmlInputText getCOMP_PMEM_NO_OF_LIFE() {
	return COMP_PMEM_NO_OF_LIFE;
}

public void setCOMP_PMEM_NO_OF_LIFE(HtmlInputText cOMP_PMEM_NO_OF_LIFE) {
	COMP_PMEM_NO_OF_LIFE = cOMP_PMEM_NO_OF_LIFE;
}
private HtmlOutputLabel COMP_PMEM_MIN_SA_LABEL;

public HtmlOutputLabel getCOMP_PMEM_MIN_SA_LABEL() {
	return COMP_PMEM_MIN_SA_LABEL;
}

public void setCOMP_PMEM_MIN_SA_LABEL(HtmlOutputLabel cOMP_PMEM_MIN_SA_LABEL) {
	COMP_PMEM_MIN_SA_LABEL = cOMP_PMEM_MIN_SA_LABEL;
}
private HtmlInputText COMP_PMEM_MIN_SA;
public HtmlInputText getCOMP_PMEM_MIN_SA() {
	return COMP_PMEM_MIN_SA;
}

public void setCOMP_PMEM_MIN_SA(HtmlInputText cOMP_PMEM_MIN_SA) {
	COMP_PMEM_MIN_SA = cOMP_PMEM_MIN_SA;
}
private HtmlOutputLabel COMP_PMEM_MAX_SA_LABEL;

public HtmlOutputLabel getCOMP_PMEM_MAX_SA_LABEL() {
	return COMP_PMEM_MAX_SA_LABEL;
}

public void setCOMP_PMEM_MAX_SA_LABEL(HtmlOutputLabel cOMP_PMEM_MAX_SA_LABEL) {
	COMP_PMEM_MAX_SA_LABEL = cOMP_PMEM_MAX_SA_LABEL;
}
private HtmlInputText COMP_PMEM_MAX_SA;

public HtmlInputText getCOMP_PMEM_MAX_SA() {
	return COMP_PMEM_MAX_SA;
}

public void setCOMP_PMEM_MAX_SA(HtmlInputText cOMP_PMEM_MAX_SA) {
	COMP_PMEM_MAX_SA = cOMP_PMEM_MAX_SA;
}
private HtmlOutputLabel COMP_PMEM_MAX_AGE_ENTRY_LABEL;

public HtmlOutputLabel getCOMP_PMEM_MAX_AGE_ENTRY_LABEL() {
	return COMP_PMEM_MAX_AGE_ENTRY_LABEL;
}

public void setCOMP_PMEM_MAX_AGE_ENTRY_LABEL(
		HtmlOutputLabel cOMP_PMEM_MAX_AGE_ENTRY_LABEL) {
	COMP_PMEM_MAX_AGE_ENTRY_LABEL = cOMP_PMEM_MAX_AGE_ENTRY_LABEL;
}
public HtmlInputText getCOMP_PMEM_MAX_AGE_ENTRY() {
	return COMP_PMEM_MAX_AGE_ENTRY;
}

public void setCOMP_PMEM_MAX_AGE_ENTRY(HtmlInputText cOMP_PMEM_MAX_AGE_ENTRY) {
	COMP_PMEM_MAX_AGE_ENTRY = cOMP_PMEM_MAX_AGE_ENTRY;
}
private HtmlInputText COMP_PMEM_MAX_AGE_ENTRY;

public void saveRecord() {
	String message = null;
	try {
		if (dataList_PM_IL_PLAN_MEMBERS.size() == 0) {
			PM_IL_PLAN_MEMBERS_BEAN=new PM_IL_PLAN_MEMBERS();	
			resetAllComponent();
		}
		CommonUtils.getConnection().commit();
		message = Messages.getString("messageProperties",
				"errorPanel$message$save");
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				message);
		getWarningMap().put("SAVE_RECORD", message);
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("current", e.getMessage());
		getErrorMap().put("SAVE", e.getMessage());

	}
}
public void displayRecords() {
	CommonUtils.clearMaps(this);
	try {
		resetSelectedRow();
		PM_IL_PLAN_MEMBERS_BEAN = (PM_IL_PLAN_MEMBERS) dataTable.getRowData();
		PM_IL_PLAN_MEMBERS_BEAN.setRowSelected(true);
		resetAllComponent();
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				exc.getMessage());
		getErrorMap().put("displayRecords", exc.getMessage());
	}

}  
private void resetSelectedRow() {
	Iterator<PM_IL_PLAN_MEMBERS> dataList_PM_IL_PLAN_MEMBERS_ITR = dataList_PM_IL_PLAN_MEMBERS.iterator();
	while (dataList_PM_IL_PLAN_MEMBERS_ITR.hasNext()) {
		dataList_PM_IL_PLAN_MEMBERS_ITR.next().setRowSelected(false);
	}
}
private UIData dataTable;

public UIData getDataTable() {
	return dataTable;
}

public void setDataTable(UIData dataTable) {
	this.dataTable = dataTable;
}
private List<PM_IL_PLAN_MEMBERS> dataList_PM_IL_PLAN_MEMBERS = new ArrayList<PM_IL_PLAN_MEMBERS>();

public List<PM_IL_PLAN_MEMBERS> getDataList_PM_IL_PLAN_MEMBERS() {
	return dataList_PM_IL_PLAN_MEMBERS;
}

public void setDataList_PM_IL_PLAN_MEMBERS(
		List<PM_IL_PLAN_MEMBERS> dataList_PM_IL_PLAN_MEMBERS) {
	this.dataList_PM_IL_PLAN_MEMBERS = dataList_PM_IL_PLAN_MEMBERS;
}
private List<SelectItem> listPMEM_RELATION_TYPE = new ArrayList<SelectItem>();

public List<SelectItem> getListPMEM_RELATION_TYPE() {
	if (listPMEM_RELATION_TYPE.size() == 0) {
		listPMEM_RELATION_TYPE.clear();
		try {
			listPMEM_RELATION_TYPE = new ArrayList<SelectItem>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return listPMEM_RELATION_TYPE;
}

public void setListPMEM_RELATION_TYPE(List<SelectItem> listPMEM_RELATION_TYPE) {
	this.listPMEM_RELATION_TYPE = listPMEM_RELATION_TYPE;
}
public void prepareDropDownList(){
	Connection connection;
	try{
		connection = CommonUtils.getConnection();
		listPMEM_RELATION_TYPE = ListItemUtil.getDropDownListValue(
				connection, "PILM003_APAC", "PM_IL_PLAN_MEMB",
				"PM_IL_PLAN_MEMB.PMEM_RELATION_TYPE","IL_PAR_MEMB");
		
	}catch (DBException e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("prepareDropDownList", e.getMessage());
	}
}
public void addRow(ActionEvent event) {
	try {
		getWarningMap().clear();
		getErrorMap().clear();
		if (isINSERT_ALLOWED()) {
			PM_IL_PLAN_MEMBERS_BEAN = new PM_IL_PLAN_MEMBERS();
			helper.WHEN_CREATE_RECORD(PM_IL_PLAN_MEMBERS_BEAN, compositeAction);
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
private void resetAllComponent() {
	COMP_PMEM_RELATION_TYPE.resetValue();
	COMP_PMEM_NO_OF_LIFE.resetValue();
	COMP_PMEM_MIN_SA.resetValue();
	COMP_PMEM_MAX_SA.resetValue();
	COMP_PMEM_MAX_AGE_ENTRY.resetValue();
	/*Added by sankara narayanan on 22/04/2017*/
	COMP_PMEN_NO_OF_DAYS.resetValue();
	/*end*/
	/*Added by Ameen on 11-07-2017 for ZBILQC-1731204*/
	COMP_PMEM_DEP_TYPE.resetValue();
	COMP_PMEM_DEP_TYPE_DESC.resetValue();
	/*end*/
	/*added by raja on 18-07-2017 for ZBILQC-1731514*/
	COMP_PMEM_MIN_COVER_AGE.resetValue();
	/*end*/
	/*added by raja on 24-07-2017 for  ZBILQC-1732855*/
	COMP_PMEM_MIN_AGE_ENTRY.resetValue();
	/*end*/
}
public void postRecord(ActionEvent event) {
	try {
		getWarningMap().clear();
		getErrorMap().clear();
		if (PM_IL_PLAN_MEMBERS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			helper.PRE_INSERT(PM_IL_PLAN_MEMBERS_BEAN,compositeAction);
			//validate_min_max();
			String PMEM_RELATION_TYPE_two=PM_IL_PLAN_MEMBERS_BEAN.getPMEM_RELATION_TYPE();
			String PLAN_CODE=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE();
			/*Added 'PMEM_DEP_TYPE' by Ameen on 11-07-2017 for ZBILQC-1731204*/
			String relation_flag = helper.check_duplicate("PM_IL_PLAN_MEMB","PMEM_RELATION_TYPE",PMEM_RELATION_TYPE_two,"PMEM_PLAN_CODE",PLAN_CODE,PM_IL_PLAN_MEMBERS_BEAN.getPMEM_DEP_TYPE());
			if(CommonUtils.nvl(relation_flag,"E").equals("T")){
				throw new Exception("Relation already selected");
			}
			new CRUDHandler().executeInsert(PM_IL_PLAN_MEMBERS_BEAN, CommonUtils
					.getConnection());
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
			getWarningMap().put("postRecord",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
			dataList_PM_IL_PLAN_MEMBERS.add(PM_IL_PLAN_MEMBERS_BEAN);
		} else if (PM_IL_PLAN_MEMBERS_BEAN.getROWID() != null
				&& isUPDATE_ALLOWED()) {
			helper.PRE_UPDATE(PM_IL_PLAN_MEMBERS_BEAN,compositeAction);
			//validate_min_max();
			String PMEM_RELATION_TYPE_two=PM_IL_PLAN_MEMBERS_BEAN.getPMEM_RELATION_TYPE();
			String PLAN_CODE=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE();
			/*Commented by saranya for not allowing for updaterecord  on 10-03-2017*/
		/*	String relation_flag = helper.check_duplicate("PM_IL_PLAN_MEMB","PMEM_RELATION_TYPE",PMEM_RELATION_TYPE_two,"PMEM_PLAN_CODE",PLAN_CODE);
			if(CommonUtils.nvl(relation_flag,"E").equals("T")){
				throw new Exception("Relation already selected");
			}*/
			new CRUDHandler().executeUpdate(PM_IL_PLAN_MEMBERS_BEAN, CommonUtils
					.getConnection());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
			getWarningMap().put("postRecord",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
		}

		PM_IL_PLAN_MEMBERS_BEAN.setRowSelected(true);
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + exc.getMessage());
		exc.printStackTrace();
	}

}
public void onLoad(PhaseEvent event) {
	try {
		if (isBlockFlag()) {
			getErrorMap().clear();
			getWarningMap().clear();
			//helper.WHEN_NEW_BLOCK_INSTANCE(PM_IL_PLAN_MEMBERS_BEAN,compositeAction);
			helper.executeQuery(compositeAction);
			if(PM_IL_PLAN_MEMBERS_BEAN.getROWID() == null){
				helper.WHEN_CREATE_RECORD(PM_IL_PLAN_MEMBERS_BEAN, compositeAction);
			}
			
		
			setBlockFlag(false);
		}
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("onLoad", e.getMessage());
	}
}
public void validatePMEM_RELATION_TYPE(FacesContext context,
		UIComponent component, Object value){
	try{
		String PMEM_RELATION_TYPE_two = (String)value;
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_RELATION_TYPE(PMEM_RELATION_TYPE_two);
		/*String PLAN_CODE=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE();
		String relation_flag = helper.check_duplicate("PM_IL_PLAN_MEMB","PMEM_RELATION_TYPE",PMEM_RELATION_TYPE_two,"PMEM_PLAN_CODE",PLAN_CODE);
		if(CommonUtils.nvl(relation_flag,"E").equals("T")){
			throw new Exception("Relation already selected");
		}*/
		COMP_PMEM_RELATION_TYPE.resetValue();
	}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		
	}
}
public void deleteRow(ActionEvent event) {
	String message = null;
	try {
		if (isDELETE_ALLOWED()) {
			
			new CRUDHandler().executeDelete(PM_IL_PLAN_MEMBERS_BEAN,CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
			dataList_PM_IL_PLAN_MEMBERS.remove(PM_IL_PLAN_MEMBERS_BEAN);
			if (dataList_PM_IL_PLAN_MEMBERS.size() > 0) {
				PM_IL_PLAN_MEMBERS_BEAN = dataList_PM_IL_PLAN_MEMBERS.get(0);
			} 
			 
			else if (dataList_PM_IL_PLAN_MEMBERS.size() == 0) {
			addRow(null);
		}
			resetAllComponent();
			PM_IL_PLAN_MEMBERS_BEAN.setRowSelected(true);
		} else {
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
		}

		getWarningMap().put("deleteRow",message);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
		getErrorMap().put("deleteRow", exc.getMessage());
	}

}

public void validatePMEM_NO_OF_LIFE(FacesContext context,
		UIComponent component, Object value){
	try{
		Integer PMEM_NO_OF_LIFE = (Integer)value;
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_NO_OF_LIFE(PMEM_NO_OF_LIFE);
		String get_relation_type=PM_IL_PLAN_MEMBERS_BEAN.getPMEM_RELATION_TYPE();
		if(get_relation_type!=null){
		if(get_relation_type.equalsIgnoreCase("01") && PMEM_NO_OF_LIFE>1){
			throw new Exception("No. of Life's should not be more than 1 for Assured");
		}
		}
		COMP_PMEM_NO_OF_LIFE.resetValue();
	}catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

public void validatePMEM_MIN_SA(FacesContext context,
		UIComponent component, Object value){
	try{
		Double PMEM_MIN_SA = (Double)value;
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MIN_SA(PMEM_MIN_SA);
		Double Get_PLAN_MIN_SA=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_MIN_SA();
		Double PMEM_MAX_SA=PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MAX_SA();
	/*	Modified by Raja on 07/04/2017
	 * 
	 * if(PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MIN_SA()>0){*/
		if(PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MIN_SA()>0 && PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MAX_SA()>0){
		if(PMEM_MIN_SA<Get_PLAN_MIN_SA){
			throw new Exception("Min SA of member cannot be less than Min SA of plan");
		}
		
		if(PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MAX_SA()!=null){
		if(PMEM_MIN_SA>PMEM_MAX_SA){
			throw new Exception("Min SA of member cannot be greater than Max SA of member");
		}
		}
		}
		COMP_PMEM_MIN_SA.resetValue();
	}catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}
public void validatePMEM_MAX_SA(FacesContext context,
		UIComponent component, Object value){
	try{
		Double PMEM_MAX_SA = (Double)value;
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MAX_SA(PMEM_MAX_SA);
		Double Get_PLAN_MAX_SA=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_MAX_SA();
		Double Get_PLAN_MIN_SA=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_MIN_SA();
		Double PMEM_MIN_SA=PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MIN_SA();
		if(PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MAX_SA()>0)
		{
		if(PMEM_MAX_SA>Get_PLAN_MAX_SA){ 
			throw new Exception("Max SA of member cannot be greater than Max SA of plan");
			
		}
		
		if(PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MIN_SA()!=null){
		if(PMEM_MAX_SA<Get_PLAN_MIN_SA){
			throw new Exception("Max SA of member cannot be less than Min SA of plan");
		}
		}
		}
		COMP_PMEM_MAX_SA.resetValue();
	}catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}


/*public String check_duplicate(String PM_IL_PLAN_MEMB,String PMEM_RELATION_TYPE,String PMEM_RELATION_TYPE_VALUE,String PMEM_PLAN_CODE,String PMEM_PLAN_CODE_VALUE) throws Exception {
	
	String CURSOR_C1 = "select PCOPK_GENERAL.CHK_DUPLICATE(?,?,?,?,?) from dual";
	ResultSet resultSet = null;
	Connection connection = null;
	String CHK_DUPLICATE=null;
	CRUDHandler handler = new CRUDHandler();
	try {
		connection = CommonUtils.getConnection();
		resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
				new Object[] {PM_IL_PLAN_MEMB,PMEM_RELATION_TYPE,PMEM_RELATION_TYPE_VALUE,PMEM_PLAN_CODE,PMEM_PLAN_CODE_VALUE});
		if (resultSet.next()) {
			CHK_DUPLICATE= resultSet.getString(1);
			
		}
		} catch (DBException e) {
		throw new Exception(e.getMessage());
	}
	return CHK_DUPLICATE;  
	}*/
/*public void validate_min_max() throws Exception{
	Double PMEM_MIN_SA=PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MIN_SA();
	Double PMEM_MAX_SA = PM_IL_PLAN_MEMBERS_BEAN.getPMEM_MAX_SA();
	Double Get_PLAN_MIN_SA=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_MIN_SA();
	Double Get_PLAN_MAX_SA=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_MAX_SA();
		if(PMEM_MIN_SA<Get_PLAN_MIN_SA){
		throw new Exception("Min SA of member cannot be less than Min SA of plan");
	}
	if(PMEM_MIN_SA>PMEM_MAX_SA){
		throw new Exception("Min SA of member cannot be greater than Max SA of member");
	}
	
	if(PMEM_MAX_SA<Get_PLAN_MAX_SA){
		throw new Exception("Max SA of member cannot be less than Max SA of plan");
	}
	if(PMEM_MAX_SA<PMEM_MIN_SA){
		throw new Exception("Max SA of member cannot be less than Min SA of member");
	}
	
	}*/
/*Added by sankaranarayanan on 21/04/2017 for Hospital cash plan */
private HtmlOutputLabel COMP_PMEN_NO_OF_DAYS_LABEL;
private HtmlInputText COMP_PMEN_NO_OF_DAYS;

public HtmlOutputLabel getCOMP_PMEN_NO_OF_DAYS_LABEL() {
	return COMP_PMEN_NO_OF_DAYS_LABEL;
}

public void setCOMP_PMEN_NO_OF_DAYS_LABEL(
		HtmlOutputLabel cOMP_PMEN_NO_OF_DAYS_LABEL) {
	COMP_PMEN_NO_OF_DAYS_LABEL = cOMP_PMEN_NO_OF_DAYS_LABEL;
}

public HtmlInputText getCOMP_PMEN_NO_OF_DAYS() {
	return COMP_PMEN_NO_OF_DAYS;
}

public void setCOMP_PMEN_NO_OF_DAYS(HtmlInputText cOMP_PMEN_NO_OF_DAYS) {
	COMP_PMEN_NO_OF_DAYS = cOMP_PMEN_NO_OF_DAYS;
}
void initializeallcomponent(){
	COMP_PMEN_NO_OF_DAYS_LABEL = new HtmlOutputLabel();
    COMP_PMEN_NO_OF_DAYS = new HtmlInputText();
    COMP_PMEM_NO_OF_LIFE_LABEL = new HtmlOutputLabel();
    COMP_PMEM_NO_OF_LIFE= new HtmlInputText();
    COMP_PMEM_MAX_AGE_ENTRY_LABEL= new HtmlOutputLabel();
    COMP_PMEM_MAX_AGE_ENTRY = new HtmlInputText();
    COMP_PMEM_MIN_SA = new HtmlInputText();
    COMP_PMEM_MIN_SA_LABEL= new HtmlOutputLabel();
    COMP_PMEM_MAX_SA_LABEL=new HtmlOutputLabel();
    COMP_PMEM_MAX_SA= new HtmlInputText();
    COMP_PMEM_RELATION_TYPE= new HtmlSelectOneMenu();
    COMP_PMEM_RELATION_TYPE_LABEL= new HtmlOutputLabel();
    /*added by raja on 18-07-2017 for ZBILQC-1731514*/
    COMP_PMEM_MIN_COVER_AGE=new HtmlInputText();
    /*end*/
    /*added by raja on 24-07-2017 for  ZBILQC-1732855*/
    COMP_PMEM_MIN_AGE_ENTRY=new HtmlInputText();
    /*end*/
}

public void validatePMEN_NO_OF_DAYS(FacesContext context,
		UIComponent component, Object value){
	try{
		int no_of_days = (Integer)value;;
		PM_IL_PLAN_MEMBERS_BEAN.setPMEN_NO_OF_DAYS(no_of_days);
		COMP_PMEN_NO_OF_DAYS.resetValue();
	}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		
	}
}
/*end*/

	/*added by Ameen on 10-07-2017 for ZBILQC-1731204*/
	private HtmlOutputLabel COMP_PMEM_DEP_TYPE_LABEL;
	
	private HtmlInputText COMP_PMEM_DEP_TYPE;
	
	private HtmlInputText COMP_PMEM_DEP_TYPE_DESC;

	public HtmlOutputLabel getCOMP_PMEM_DEP_TYPE_LABEL() {
		return COMP_PMEM_DEP_TYPE_LABEL;
	}

	public void setCOMP_PMEM_DEP_TYPE_LABEL(HtmlOutputLabel cOMP_PMEM_DEP_TYPE_LABEL) {
		COMP_PMEM_DEP_TYPE_LABEL = cOMP_PMEM_DEP_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PMEM_DEP_TYPE() {
		return COMP_PMEM_DEP_TYPE;
	}

	public void setCOMP_PMEM_DEP_TYPE(HtmlInputText cOMP_PMEM_DEP_TYPE) {
		COMP_PMEM_DEP_TYPE = cOMP_PMEM_DEP_TYPE;
	}

	public HtmlInputText getCOMP_PMEM_DEP_TYPE_DESC() {
		return COMP_PMEM_DEP_TYPE_DESC;
	}

	public void setCOMP_PMEM_DEP_TYPE_DESC(HtmlInputText cOMP_PMEM_DEP_TYPE_DESC) {
		COMP_PMEM_DEP_TYPE_DESC = cOMP_PMEM_DEP_TYPE_DESC;
	}
	
	public ArrayList<LovBean> lovPmemDepType(
			Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM003_APAC",
					"PM_IL_PLAN_MEMB", "PMEM_DEP_TYPE", "IL_DEP_TYP", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	/*end*/
	
	/*added by raja on 18-07-2017 for ZBILQC-1731514*/
	
private HtmlOutputLabel COMP_PMEM_MIN_COVER_AGE_LABEL;
	
	private HtmlInputText COMP_PMEM_MIN_COVER_AGE;

	public HtmlOutputLabel getCOMP_PMEM_MIN_COVER_AGE_LABEL() {
		return COMP_PMEM_MIN_COVER_AGE_LABEL;
	}

	public void setCOMP_PMEM_MIN_COVER_AGE_LABEL(
			HtmlOutputLabel cOMP_PMEM_MIN_COVER_AGE_LABEL) {
		COMP_PMEM_MIN_COVER_AGE_LABEL = cOMP_PMEM_MIN_COVER_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PMEM_MIN_COVER_AGE() {
		return COMP_PMEM_MIN_COVER_AGE;
	}

	public void setCOMP_PMEM_MIN_COVER_AGE(HtmlInputText cOMP_PMEM_MIN_COVER_AGE) {
		COMP_PMEM_MIN_COVER_AGE = cOMP_PMEM_MIN_COVER_AGE;
	}
	/*end*/
	
	/*added by raja on 24-07-2017 for  ZBILQC-1732855*/
	private HtmlOutputLabel COMP_PMEM_MIN_AGE_ENTRY_LABEL;
	private HtmlInputText COMP_PMEM_MIN_AGE_ENTRY;

	public HtmlOutputLabel getCOMP_PMEM_MIN_AGE_ENTRY_LABEL() {
		return COMP_PMEM_MIN_AGE_ENTRY_LABEL;
	}

	public void setCOMP_PMEM_MIN_AGE_ENTRY_LABEL(
			HtmlOutputLabel cOMP_PMEM_MIN_AGE_ENTRY_LABEL) {
		COMP_PMEM_MIN_AGE_ENTRY_LABEL = cOMP_PMEM_MIN_AGE_ENTRY_LABEL;
	}
/*end*/
	public HtmlInputText getCOMP_PMEM_MIN_AGE_ENTRY() {
		return COMP_PMEM_MIN_AGE_ENTRY;
	}

	public void setCOMP_PMEM_MIN_AGE_ENTRY(HtmlInputText cOMP_PMEM_MIN_AGE_ENTRY) {
		COMP_PMEM_MIN_AGE_ENTRY = cOMP_PMEM_MIN_AGE_ENTRY;
	}
	
	
	/*end*/
	
}
