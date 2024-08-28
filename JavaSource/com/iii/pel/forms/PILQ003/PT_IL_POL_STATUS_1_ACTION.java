package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_STATUS_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PS_STATUS_DT_LABEL;

	private HtmlCalendar COMP_PS_STATUS_DT;

	private HtmlOutputLabel COMP_PS_REMIN_NO_LABEL;

	private HtmlInputText COMP_PS_REMIN_NO;

	private HtmlInputText COMP_PS_STATUS_CODE;

	private HtmlOutputLabel COMP_PS_STATUS_CODE_LABEL;

	private HtmlOutputLabel COMP_UI_M_PS_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PS_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_PS_STATUS_UID_LABEL;

	private HtmlInputText COMP_PS_STATUS_UID;

	private PT_IL_POL_STATUS_1 PT_IL_POL_STATUS_1_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_STATUS_1_HELPER helper;

	private List<PT_IL_POL_STATUS_1> dataList_PT_IL_POL_STATUS_1 = new ArrayList<PT_IL_POL_STATUS_1>();

	 private UIData dataTable;

        
        
        public PT_IL_POL_STATUS_1_ACTION(){
        
        PT_IL_POL_STATUS_1_BEAN = new PT_IL_POL_STATUS_1();
        helper = new PT_IL_POL_STATUS_1_HELPER();
        instantiateAllComponent();
        }
         

	 

	public HtmlOutputLabel getCOMP_PS_STATUS_DT_LABEL() {
    return COMP_PS_STATUS_DT_LABEL;
}




public void setCOMP_PS_STATUS_DT_LABEL(HtmlOutputLabel comp_PS_status_dt_label) {
    COMP_PS_STATUS_DT_LABEL = comp_PS_status_dt_label;
}




public HtmlCalendar getCOMP_PS_STATUS_DT() {
    return COMP_PS_STATUS_DT;
}




public void setCOMP_PS_STATUS_DT(HtmlCalendar comp_PS_status_dt) {
    COMP_PS_STATUS_DT = comp_PS_status_dt;
}




public HtmlOutputLabel getCOMP_PS_REMIN_NO_LABEL() {
    return COMP_PS_REMIN_NO_LABEL;
}




public void setCOMP_PS_REMIN_NO_LABEL(HtmlOutputLabel comp_PS_remin_no_label) {
    COMP_PS_REMIN_NO_LABEL = comp_PS_remin_no_label;
}




public HtmlInputText getCOMP_PS_REMIN_NO() {
    return COMP_PS_REMIN_NO;
}




public void setCOMP_PS_REMIN_NO(HtmlInputText comp_PS_remin_no) {
    COMP_PS_REMIN_NO = comp_PS_remin_no;
}




public HtmlInputText getCOMP_PS_STATUS_CODE() {
    return COMP_PS_STATUS_CODE;
}




public void setCOMP_PS_STATUS_CODE(HtmlInputText comp_PS_status_code) {
    COMP_PS_STATUS_CODE = comp_PS_status_code;
}




public HtmlOutputLabel getCOMP_PS_STATUS_CODE_LABEL() {
    return COMP_PS_STATUS_CODE_LABEL;
}




public void setCOMP_PS_STATUS_CODE_LABEL(
	HtmlOutputLabel comp_PS_status_code_label) {
    COMP_PS_STATUS_CODE_LABEL = comp_PS_status_code_label;
}




public HtmlOutputLabel getCOMP_UI_M_PS_STATUS_CODE_DESC_LABEL() {
    return COMP_UI_M_PS_STATUS_CODE_DESC_LABEL;
}




public void setCOMP_UI_M_PS_STATUS_CODE_DESC_LABEL(
	HtmlOutputLabel comp_ui_m_PS_status_code_desc_label) {
    COMP_UI_M_PS_STATUS_CODE_DESC_LABEL = comp_ui_m_PS_status_code_desc_label;
}




public HtmlInputText getCOMP_UI_M_PS_STATUS_CODE_DESC() {
    return COMP_UI_M_PS_STATUS_CODE_DESC;
}




public void setCOMP_UI_M_PS_STATUS_CODE_DESC(
	HtmlInputText comp_ui_m_PS_status_code_desc) {
    COMP_UI_M_PS_STATUS_CODE_DESC = comp_ui_m_PS_status_code_desc;
}




public HtmlOutputLabel getCOMP_PS_STATUS_UID_LABEL() {
    return COMP_PS_STATUS_UID_LABEL;
}




public void setCOMP_PS_STATUS_UID_LABEL(
	HtmlOutputLabel comp_PS_status_uid_label) {
    COMP_PS_STATUS_UID_LABEL = comp_PS_status_uid_label;
}




public HtmlInputText getCOMP_PS_STATUS_UID() {
    return COMP_PS_STATUS_UID;
}




public void setCOMP_PS_STATUS_UID(HtmlInputText comp_PS_status_uid) {
    COMP_PS_STATUS_UID = comp_PS_status_uid;
}




public PT_IL_POL_STATUS_1_HELPER getHelper() {
    return helper;
}




public void setHelper(PT_IL_POL_STATUS_1_HELPER helper) {
    this.helper = helper;
}




public void setDataList_PT_IL_POL_STATUS_1(
	List<PT_IL_POL_STATUS_1> dataList_PT_IL_POL_STATUS_1) {
    this.dataList_PT_IL_POL_STATUS_1 = dataList_PT_IL_POL_STATUS_1;
}




	public PT_IL_POL_STATUS_1 getPT_IL_POL_STATUS_1_BEAN() {
		return PT_IL_POL_STATUS_1_BEAN;
	}

	public void setPT_IL_POL_STATUS_1_BEAN(PT_IL_POL_STATUS_1 PT_IL_POL_STATUS_1_BEAN) {
		this.PT_IL_POL_STATUS_1_BEAN = PT_IL_POL_STATUS_1_BEAN;
	}

	public List<PT_IL_POL_STATUS_1> getDataList_PT_IL_POL_STATUS_1() {
		return dataList_PT_IL_POL_STATUS_1;
	}

	public void setDataListPT_IL_POL_STATUS_1(List<PT_IL_POL_STATUS_1> dataList_PT_IL_POL_STATUS_1) {
		this.dataList_PT_IL_POL_STATUS_1 = dataList_PT_IL_POL_STATUS_1;
	}

public void addRow(ActionEvent event){
try{
if (isINSERT_ALLOWED()){

PT_IL_POL_STATUS_1_BEAN = new PT_IL_POL_STATUS_1();
resetAllComponent();
resetSelectedRow();
}else{

getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
}

}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("addRow",exc.getMessage());
}

}

public void deleteRow(ActionEvent event){
String message = null;
	try{
if (isDELETE_ALLOWED()){
new CRUDHandler().executeDelete(PT_IL_POL_STATUS_1_BEAN,CommonUtils.getConnection());
message = Messages.getString(PELConstants.pelErrorMessagePath,"errorPanel$message$delete");
dataList_PT_IL_POL_STATUS_1.remove(PT_IL_POL_STATUS_1_BEAN);
if(dataList_PT_IL_POL_STATUS_1.size()>0){

PT_IL_POL_STATUS_1_BEAN=dataList_PT_IL_POL_STATUS_1.get(0);
}else if(dataList_PT_IL_POL_STATUS_1.size()==0){

addRow(null);
}

resetAllComponent();
PT_IL_POL_STATUS_1_BEAN.setRowSelected(true);
}else{
message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed");
}
getErrorMap().put("deleteRow",message);
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("deleteRow",exc.getMessage());
}

}

public void postRecord(ActionEvent event){
String message = null;
	try{
if(PT_IL_POL_STATUS_1_BEAN.getROWID()==null && isINSERT_ALLOWED()){
		helper.preInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
				compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),
				getPT_IL_POL_STATUS_1_BEAN());
		new CRUDHandler().executeInsert(PT_IL_POL_STATUS_1_BEAN,CommonUtils.getConnection());
		message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
		dataList_PT_IL_POL_STATUS_1.add(PT_IL_POL_STATUS_1_BEAN);
}else if(PT_IL_POL_STATUS_1_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){
	new CRUDHandler().executeUpdate(PT_IL_POL_STATUS_1_BEAN,CommonUtils.getConnection());
	message = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update");
}
	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
	getWarningMap().put("postRecord", message);
	PT_IL_POL_STATUS_1_BEAN.setRowSelected(true);
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
}

}

public void displayRecords(){
CommonUtils.clearMaps(this);try{
resetSelectedRow();
PT_IL_POL_STATUS_1_BEAN = (PT_IL_POL_STATUS_1)dataTable.getRowData();
PT_IL_POL_STATUS_1_BEAN.setRowSelected(true);
resetAllComponent();
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("displayRecords",exc.getMessage());
}

}

private void resetSelectedRow(){
Iterator<PT_IL_POL_STATUS_1> PT_IL_POL_STATUS_1_ITR = dataList_PT_IL_POL_STATUS_1.iterator();while (PT_IL_POL_STATUS_1_ITR.hasNext()) {
PT_IL_POL_STATUS_1_ITR.next().setRowSelected(false);}
}

private void resetAllComponent(){
COMP_PS_STATUS_DT.resetValue();
COMP_PS_STATUS_DT.resetValue();
COMP_PS_REMIN_NO.resetValue();
COMP_PS_REMIN_NO.resetValue();
COMP_PS_STATUS_CODE.resetValue();
COMP_PS_STATUS_CODE.resetValue();
COMP_UI_M_PS_STATUS_CODE_DESC.resetValue();
COMP_UI_M_PS_STATUS_CODE_DESC.resetValue();
COMP_PS_STATUS_UID.resetValue();
COMP_PS_STATUS_UID.resetValue();
}

	public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void saveRecord() {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			message =Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
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
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

	/**
	 * Disables all components in PT_IL_POL_STATUS_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PS_REMIN_NO.setDisabled(disabled);
		COMP_PS_STATUS_CODE.setDisabled(disabled);
		COMP_UI_M_PS_STATUS_CODE_DESC.setDisabled(disabled);
		COMP_PS_STATUS_UID.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_PS_STATUS_DT.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_STATUS_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PS_REMIN_NO				 = new HtmlInputText();
		COMP_PS_STATUS_CODE				 = new HtmlInputText();
		COMP_UI_M_PS_STATUS_CODE_DESC			 = new HtmlInputText();
		COMP_PS_STATUS_UID				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PS_STATUS_DT_LABEL				 = new HtmlOutputLabel();
		COMP_PS_REMIN_NO_LABEL				 = new HtmlOutputLabel();
		COMP_PS_STATUS_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PS_STATUS_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_PS_STATUS_UID_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCalendar
		COMP_PS_STATUS_DT				 = new HtmlCalendar();

	}



}
