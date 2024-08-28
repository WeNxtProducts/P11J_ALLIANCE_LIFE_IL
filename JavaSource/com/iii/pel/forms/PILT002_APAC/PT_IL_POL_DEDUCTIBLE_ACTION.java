package com.iii.pel.forms.PILT002_APAC;

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

public class PT_IL_POL_DEDUCTIBLE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PD_BNF_CODE_LABEL;

	private HtmlInputText COMP_PD_BNF_CODE;

	private HtmlOutputLabel COMP_PD_CODE_LABEL;

	private HtmlInputText COMP_PD_CODE;

	private HtmlOutputLabel COMP_PD_NO_OF_DAYS_LABEL;

	private HtmlInputText COMP_PD_NO_OF_DAYS;

	private HtmlOutputLabel COMP_PD_PERC_LABEL;

	private HtmlInputText COMP_PD_PERC;

	private HtmlOutputLabel COMP_PD_MIN_LC_VAL_LABEL;

	private HtmlInputText COMP_PD_MIN_LC_VAL;

	private HtmlOutputLabel COMP_UI_M_PD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1;

	private HtmlCommandButton COMP_PB_BNF_CODE_LOV_BTN;

	private PT_IL_POL_DEDUCTIBLE PT_IL_POL_DEDUCTIBLE_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_DEDUCTIBLE_HELPER helper;

	private List<PT_IL_POL_DEDUCTIBLE> dataList_PT_IL_POL_DEDUCTIBLE = new ArrayList<PT_IL_POL_DEDUCTIBLE>();

	 private UIData dataTable;

        
        
        public PT_IL_POL_DEDUCTIBLE_ACTION(){
        
        
        PT_IL_POL_DEDUCTIBLE_BEAN = new PT_IL_POL_DEDUCTIBLE();
        helper = new PT_IL_POL_DEDUCTIBLE_HELPER();
        instantiateAllComponent();
        }

	public HtmlOutputLabel getCOMP_PD_BNF_CODE_LABEL() {
		return COMP_PD_BNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PD_BNF_CODE() {
		return COMP_PD_BNF_CODE;
	}

	public void setCOMP_PD_BNF_CODE_LABEL(HtmlOutputLabel COMP_PD_BNF_CODE_LABEL) {
		this.COMP_PD_BNF_CODE_LABEL = COMP_PD_BNF_CODE_LABEL;
	}

	public void setCOMP_PD_BNF_CODE(HtmlInputText COMP_PD_BNF_CODE) {
		this.COMP_PD_BNF_CODE = COMP_PD_BNF_CODE;
	}

	public HtmlOutputLabel getCOMP_PD_CODE_LABEL() {
		return COMP_PD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PD_CODE() {
		return COMP_PD_CODE;
	}

	public void setCOMP_PD_CODE_LABEL(HtmlOutputLabel COMP_PD_CODE_LABEL) {
		this.COMP_PD_CODE_LABEL = COMP_PD_CODE_LABEL;
	}

	public void setCOMP_PD_CODE(HtmlInputText COMP_PD_CODE) {
		this.COMP_PD_CODE = COMP_PD_CODE;
	}

	public HtmlOutputLabel getCOMP_PD_NO_OF_DAYS_LABEL() {
		return COMP_PD_NO_OF_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PD_NO_OF_DAYS() {
		return COMP_PD_NO_OF_DAYS;
	}

	public void setCOMP_PD_NO_OF_DAYS_LABEL(HtmlOutputLabel COMP_PD_NO_OF_DAYS_LABEL) {
		this.COMP_PD_NO_OF_DAYS_LABEL = COMP_PD_NO_OF_DAYS_LABEL;
	}

	public void setCOMP_PD_NO_OF_DAYS(HtmlInputText COMP_PD_NO_OF_DAYS) {
		this.COMP_PD_NO_OF_DAYS = COMP_PD_NO_OF_DAYS;
	}

	public HtmlOutputLabel getCOMP_PD_PERC_LABEL() {
		return COMP_PD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PD_PERC() {
		return COMP_PD_PERC;
	}

	public void setCOMP_PD_PERC_LABEL(HtmlOutputLabel COMP_PD_PERC_LABEL) {
		this.COMP_PD_PERC_LABEL = COMP_PD_PERC_LABEL;
	}

	public void setCOMP_PD_PERC(HtmlInputText COMP_PD_PERC) {
		this.COMP_PD_PERC = COMP_PD_PERC;
	}

	public HtmlOutputLabel getCOMP_PD_MIN_LC_VAL_LABEL() {
		return COMP_PD_MIN_LC_VAL_LABEL;
	}

	public HtmlInputText getCOMP_PD_MIN_LC_VAL() {
		return COMP_PD_MIN_LC_VAL;
	}

	public void setCOMP_PD_MIN_LC_VAL_LABEL(HtmlOutputLabel COMP_PD_MIN_LC_VAL_LABEL) {
		this.COMP_PD_MIN_LC_VAL_LABEL = COMP_PD_MIN_LC_VAL_LABEL;
	}

	public void setCOMP_PD_MIN_LC_VAL(HtmlInputText COMP_PD_MIN_LC_VAL) {
		this.COMP_PD_MIN_LC_VAL = COMP_PD_MIN_LC_VAL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CODE_DESC_LABEL() {
		return COMP_UI_M_PD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_CODE_DESC() {
		return COMP_UI_M_PD_CODE_DESC;
	}

	public void setCOMP_UI_M_PD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PD_CODE_DESC_LABEL) {
		this.COMP_UI_M_PD_CODE_DESC_LABEL = COMP_UI_M_PD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_CODE_DESC(HtmlInputText COMP_UI_M_PD_CODE_DESC) {
		this.COMP_UI_M_PD_CODE_DESC = COMP_UI_M_PD_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1() {
		return COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1;
	}

	public void setCOMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1(HtmlCommandButton COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1) {
		this.COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1 = COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1;
	}

	public HtmlCommandButton getCOMP_PB_BNF_CODE_LOV_BTN() {
		return COMP_PB_BNF_CODE_LOV_BTN;
	}

	public void setCOMP_PB_BNF_CODE_LOV_BTN(HtmlCommandButton COMP_PB_BNF_CODE_LOV_BTN) {
		this.COMP_PB_BNF_CODE_LOV_BTN = COMP_PB_BNF_CODE_LOV_BTN;
	}

	public PT_IL_POL_DEDUCTIBLE getPT_IL_POL_DEDUCTIBLE_BEAN() {
		return PT_IL_POL_DEDUCTIBLE_BEAN;
	}

	public void setPT_IL_POL_DEDUCTIBLE_BEAN(PT_IL_POL_DEDUCTIBLE PT_IL_POL_DEDUCTIBLE_BEAN) {
		this.PT_IL_POL_DEDUCTIBLE_BEAN = PT_IL_POL_DEDUCTIBLE_BEAN;
	}

	public List<PT_IL_POL_DEDUCTIBLE> getDataList_PT_IL_POL_DEDUCTIBLE() {
		return dataList_PT_IL_POL_DEDUCTIBLE;
	}

	public void setDataListPT_IL_POL_DEDUCTIBLE(List<PT_IL_POL_DEDUCTIBLE> dataList_PT_IL_POL_DEDUCTIBLE) {
		this.dataList_PT_IL_POL_DEDUCTIBLE = dataList_PT_IL_POL_DEDUCTIBLE;
	}

public void addRow(ActionEvent event){
try{
if (isINSERT_ALLOWED()){

PT_IL_POL_DEDUCTIBLE_BEAN = new PT_IL_POL_DEDUCTIBLE();
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
try{
if (isDELETE_ALLOWED()){

new CRUDHandler().executeDelete(PT_IL_POL_DEDUCTIBLE_BEAN,CommonUtils.getConnection());
getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
dataList_PT_IL_POL_DEDUCTIBLE.remove(PT_IL_POL_DEDUCTIBLE_BEAN);
if(dataList_PT_IL_POL_DEDUCTIBLE.size()>0){

PT_IL_POL_DEDUCTIBLE_BEAN=dataList_PT_IL_POL_DEDUCTIBLE.get(0);
}else if(dataList_PT_IL_POL_DEDUCTIBLE.size()==0){

addRow(null);
}

resetAllComponent();
PT_IL_POL_DEDUCTIBLE_BEAN.setRowSelected(true);
}else{

getErrorMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"));
}

}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("deleteRow",exc.getMessage());
}

}

public void postRecord(ActionEvent event){
try{
if(PT_IL_POL_DEDUCTIBLE_BEAN.getROWID()==null && isINSERT_ALLOWED()){

new CRUDHandler().executeInsert(PT_IL_POL_DEDUCTIBLE_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
dataList_PT_IL_POL_DEDUCTIBLE.add(PT_IL_POL_DEDUCTIBLE_BEAN);
}else if(PT_IL_POL_DEDUCTIBLE_BEAN.getROWID()!=null && isUPDATE_ALLOWED()){

new CRUDHandler().executeUpdate(PT_IL_POL_DEDUCTIBLE_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
}

PT_IL_POL_DEDUCTIBLE_BEAN.setRowSelected(true);
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
}

}

public void displayRecords(){
CommonUtils.clearMaps(this);try{
resetSelectedRow();
PT_IL_POL_DEDUCTIBLE_BEAN = (PT_IL_POL_DEDUCTIBLE)dataTable.getRowData();
PT_IL_POL_DEDUCTIBLE_BEAN.setRowSelected(true);
resetAllComponent();
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("displayRecords",exc.getMessage());
}

}

private void resetSelectedRow(){
Iterator<PT_IL_POL_DEDUCTIBLE> PT_IL_POL_DEDUCTIBLE_ITR = dataList_PT_IL_POL_DEDUCTIBLE.iterator();while (PT_IL_POL_DEDUCTIBLE_ITR.hasNext()) {
PT_IL_POL_DEDUCTIBLE_ITR.next().setRowSelected(false);}
}

private void resetAllComponent(){
COMP_PD_BNF_CODE.resetValue();
COMP_PD_CODE.resetValue();
COMP_PD_NO_OF_DAYS.resetValue();
COMP_PD_PERC.resetValue();
COMP_PD_MIN_LC_VAL.resetValue();
COMP_UI_M_PD_CODE_DESC.resetValue();
}

	public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
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
	 * Disables all components in PT_IL_POL_DEDUCTIBLE_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PD_BNF_CODE.setDisabled(disabled);
		COMP_PD_CODE.setDisabled(disabled);
		COMP_PD_NO_OF_DAYS.setDisabled(disabled);
		COMP_PD_PERC.setDisabled(disabled);
		COMP_PD_MIN_LC_VAL.setDisabled(disabled);
		COMP_UI_M_PD_CODE_DESC.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1.setDisabled(disabled);
		COMP_PB_BNF_CODE_LOV_BTN.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_DEDUCTIBLE_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PD_BNF_CODE				 = new HtmlInputText();
		COMP_PD_CODE					 = new HtmlInputText();
		COMP_PD_NO_OF_DAYS				 = new HtmlInputText();
		COMP_PD_PERC					 = new HtmlInputText();
		COMP_PD_MIN_LC_VAL				 = new HtmlInputText();
		COMP_UI_M_PD_CODE_DESC				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PD_BNF_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_PD_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_PD_NO_OF_DAYS_LABEL			 = new HtmlOutputLabel();
		COMP_PD_PERC_LABEL				 = new HtmlOutputLabel();
		COMP_PD_MIN_LC_VAL_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PD_CODE_DESC_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BTN_MAIN_BENEFIT_DTLS_1		 = new HtmlCommandButton();
		COMP_PB_BNF_CODE_LOV_BTN			 = new HtmlCommandButton();

	}



}
