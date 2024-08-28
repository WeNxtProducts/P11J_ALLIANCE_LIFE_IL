package com.iii.pel.forms.PILT002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BENEFIT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PB_BNF_CODE_LABEL;

	private HtmlInputText COMP_PB_BNF_CODE;

	private HtmlOutputLabel COMP_PB_LIMIT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PB_LIMIT_TYPE;

	private HtmlOutputLabel COMP_PB_PER_DAY_LC_AMT_LABEL;

	private HtmlInputText COMP_PB_PER_DAY_LC_AMT;

	private HtmlOutputLabel COMP_PB_LIMIT_DAYS_LABEL;

	private HtmlInputText COMP_PB_LIMIT_DAYS;

	private HtmlOutputLabel COMP_PB_LC_LIMIT_LABEL;

	private HtmlInputText COMP_PB_LC_LIMIT;

	private HtmlOutputLabel COMP_UI_M_PB_BNF_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PB_BNF_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BTN_DEDUCTIBLE;

	private HtmlCommandButton COMP_UI_M_BTN_MAIN_COVER_DTLS;

	private HtmlCommandButton COMP_UI_M_BTN_SUB_BENEFIT_DTLS;

	private PT_IL_POL_BENEFIT PT_IL_POL_BENEFIT_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BENEFIT_HELPER helper;

	private List<PT_IL_POL_BENEFIT> dataList_PT_IL_POL_BENEFIT = new ArrayList<PT_IL_POL_BENEFIT>();

	 private UIData dataTable;

	private List<SelectItem> listPB_LIMIT_TYPE = new ArrayList<SelectItem>();



	public PT_IL_POL_BENEFIT_ACTION() {

    	PT_IL_POL_BENEFIT_BEAN = new PT_IL_POL_BENEFIT();
    	helper = new PT_IL_POL_BENEFIT_HELPER();
    	instantiateAllComponent();
    	}

	public HtmlOutputLabel getCOMP_PB_BNF_CODE_LABEL() {
		return COMP_PB_BNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PB_BNF_CODE() {
		return COMP_PB_BNF_CODE;
	}

	public void setCOMP_PB_BNF_CODE_LABEL(HtmlOutputLabel COMP_PB_BNF_CODE_LABEL) {
		this.COMP_PB_BNF_CODE_LABEL = COMP_PB_BNF_CODE_LABEL;
	}

	public void setCOMP_PB_BNF_CODE(HtmlInputText COMP_PB_BNF_CODE) {
		this.COMP_PB_BNF_CODE = COMP_PB_BNF_CODE;
	}

	public HtmlOutputLabel getCOMP_PB_LIMIT_TYPE_LABEL() {
		return COMP_PB_LIMIT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PB_LIMIT_TYPE() {
		return COMP_PB_LIMIT_TYPE;
	}

	public void setCOMP_PB_LIMIT_TYPE_LABEL(HtmlOutputLabel COMP_PB_LIMIT_TYPE_LABEL) {
		this.COMP_PB_LIMIT_TYPE_LABEL = COMP_PB_LIMIT_TYPE_LABEL;
	}

	public void setCOMP_PB_LIMIT_TYPE(HtmlSelectOneMenu COMP_PB_LIMIT_TYPE) {
		this.COMP_PB_LIMIT_TYPE = COMP_PB_LIMIT_TYPE;
	}

	public HtmlOutputLabel getCOMP_PB_PER_DAY_LC_AMT_LABEL() {
		return COMP_PB_PER_DAY_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PB_PER_DAY_LC_AMT() {
		return COMP_PB_PER_DAY_LC_AMT;
	}

	public void setCOMP_PB_PER_DAY_LC_AMT_LABEL(HtmlOutputLabel COMP_PB_PER_DAY_LC_AMT_LABEL) {
		this.COMP_PB_PER_DAY_LC_AMT_LABEL = COMP_PB_PER_DAY_LC_AMT_LABEL;
	}

	public void setCOMP_PB_PER_DAY_LC_AMT(HtmlInputText COMP_PB_PER_DAY_LC_AMT) {
		this.COMP_PB_PER_DAY_LC_AMT = COMP_PB_PER_DAY_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PB_LIMIT_DAYS_LABEL() {
		return COMP_PB_LIMIT_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PB_LIMIT_DAYS() {
		return COMP_PB_LIMIT_DAYS;
	}

	public void setCOMP_PB_LIMIT_DAYS_LABEL(HtmlOutputLabel COMP_PB_LIMIT_DAYS_LABEL) {
		this.COMP_PB_LIMIT_DAYS_LABEL = COMP_PB_LIMIT_DAYS_LABEL;
	}

	public void setCOMP_PB_LIMIT_DAYS(HtmlInputText COMP_PB_LIMIT_DAYS) {
		this.COMP_PB_LIMIT_DAYS = COMP_PB_LIMIT_DAYS;
	}

	public HtmlOutputLabel getCOMP_PB_LC_LIMIT_LABEL() {
		return COMP_PB_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_PB_LC_LIMIT() {
		return COMP_PB_LC_LIMIT;
	}

	public void setCOMP_PB_LC_LIMIT_LABEL(HtmlOutputLabel COMP_PB_LC_LIMIT_LABEL) {
		this.COMP_PB_LC_LIMIT_LABEL = COMP_PB_LC_LIMIT_LABEL;
	}

	public void setCOMP_PB_LC_LIMIT(HtmlInputText COMP_PB_LC_LIMIT) {
		this.COMP_PB_LC_LIMIT = COMP_PB_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PB_BNF_CODE_DESC_LABEL() {
		return COMP_UI_M_PB_BNF_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PB_BNF_CODE_DESC() {
		return COMP_UI_M_PB_BNF_CODE_DESC;
	}

	public void setCOMP_UI_M_PB_BNF_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PB_BNF_CODE_DESC_LABEL) {
		this.COMP_UI_M_PB_BNF_CODE_DESC_LABEL = COMP_UI_M_PB_BNF_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PB_BNF_CODE_DESC(HtmlInputText COMP_UI_M_PB_BNF_CODE_DESC) {
		this.COMP_UI_M_PB_BNF_CODE_DESC = COMP_UI_M_PB_BNF_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_DEDUCTIBLE() {
		return COMP_UI_M_BTN_DEDUCTIBLE;
	}

	public void setCOMP_UI_M_BTN_DEDUCTIBLE(HtmlCommandButton COMP_UI_M_BTN_DEDUCTIBLE) {
		this.COMP_UI_M_BTN_DEDUCTIBLE = COMP_UI_M_BTN_DEDUCTIBLE;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_MAIN_COVER_DTLS() {
		return COMP_UI_M_BTN_MAIN_COVER_DTLS;
	}

	public void setCOMP_UI_M_BTN_MAIN_COVER_DTLS(HtmlCommandButton COMP_UI_M_BTN_MAIN_COVER_DTLS) {
		this.COMP_UI_M_BTN_MAIN_COVER_DTLS = COMP_UI_M_BTN_MAIN_COVER_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_SUB_BENEFIT_DTLS() {
		return COMP_UI_M_BTN_SUB_BENEFIT_DTLS;
	}

	public void setCOMP_UI_M_BTN_SUB_BENEFIT_DTLS(HtmlCommandButton COMP_UI_M_BTN_SUB_BENEFIT_DTLS) {
		this.COMP_UI_M_BTN_SUB_BENEFIT_DTLS = COMP_UI_M_BTN_SUB_BENEFIT_DTLS;
	}

	public PT_IL_POL_BENEFIT getPT_IL_POL_BENEFIT_BEAN() {
		return PT_IL_POL_BENEFIT_BEAN;
	}

	public void setPT_IL_POL_BENEFIT_BEAN(PT_IL_POL_BENEFIT PT_IL_POL_BENEFIT_BEAN) {
		this.PT_IL_POL_BENEFIT_BEAN = PT_IL_POL_BENEFIT_BEAN;
	}

	public List<PT_IL_POL_BENEFIT> getDataList_PT_IL_POL_BENEFIT() {
		return dataList_PT_IL_POL_BENEFIT;
	}

	public void setDataListPT_IL_POL_BENEFIT(List<PT_IL_POL_BENEFIT> dataList_PT_IL_POL_BENEFIT) {
		this.dataList_PT_IL_POL_BENEFIT = dataList_PT_IL_POL_BENEFIT;
	}

public void addRow(ActionEvent event){
try{
if (isINSERT_ALLOWED()){

PT_IL_POL_BENEFIT_BEAN = new PT_IL_POL_BENEFIT();
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

new CRUDHandler().executeDelete(PT_IL_POL_BENEFIT_BEAN,CommonUtils.getConnection());
getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
dataList_PT_IL_POL_BENEFIT.remove(PT_IL_POL_BENEFIT_BEAN);
if(dataList_PT_IL_POL_BENEFIT.size()>0){

PT_IL_POL_BENEFIT_BEAN=dataList_PT_IL_POL_BENEFIT.get(0);
}else if(dataList_PT_IL_POL_BENEFIT.size()==0){

addRow(null);
}

resetAllComponent();
PT_IL_POL_BENEFIT_BEAN.setRowSelected(true);
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
if(PT_IL_POL_BENEFIT_BEAN.getROWID()==null && isINSERT_ALLOWED()){

new CRUDHandler().executeInsert(PT_IL_POL_BENEFIT_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
dataList_PT_IL_POL_BENEFIT.add(PT_IL_POL_BENEFIT_BEAN);
}else if(PT_IL_POL_BENEFIT_BEAN.getROWID()!=null && isUPDATE_ALLOWED()){

new CRUDHandler().executeUpdate(PT_IL_POL_BENEFIT_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
}

PT_IL_POL_BENEFIT_BEAN.setRowSelected(true);
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
}

}

public void displayRecords(){
CommonUtils.clearMaps(this);try{
resetSelectedRow();
PT_IL_POL_BENEFIT_BEAN = (PT_IL_POL_BENEFIT)dataTable.getRowData();
PT_IL_POL_BENEFIT_BEAN.setRowSelected(true);
resetAllComponent();
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("displayRecords",exc.getMessage());
}

}

private void resetSelectedRow(){
Iterator<PT_IL_POL_BENEFIT> PT_IL_POL_BENEFIT_ITR = dataList_PT_IL_POL_BENEFIT.iterator();while (PT_IL_POL_BENEFIT_ITR.hasNext()) {
PT_IL_POL_BENEFIT_ITR.next().setRowSelected(false);}
}

private void resetAllComponent(){
COMP_PB_BNF_CODE.resetValue();
COMP_PB_LIMIT_TYPE.resetValue();
COMP_PB_PER_DAY_LC_AMT.resetValue();
COMP_PB_LIMIT_DAYS.resetValue();
COMP_PB_LC_LIMIT.resetValue();
COMP_UI_M_PB_BNF_CODE_DESC.resetValue();
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


	public List<SelectItem> getListPB_LIMIT_TYPE() {
		if (listPB_LIMIT_TYPE.size() == 0) {
			listPB_LIMIT_TYPE.clear();
			try {
				listPB_LIMIT_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPB_LIMIT_TYPE;
	}

	public void setListPB_LIMIT_TYPE(List<SelectItem> listPB_LIMIT_TYPE) {
		this.listPB_LIMIT_TYPE = listPB_LIMIT_TYPE;
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
	 * Disables all components in PT_IL_POL_BENEFIT_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PB_BNF_CODE.setDisabled(disabled);
		COMP_PB_PER_DAY_LC_AMT.setDisabled(disabled);
		COMP_PB_LIMIT_DAYS.setDisabled(disabled);
		COMP_PB_LC_LIMIT.setDisabled(disabled);
		COMP_UI_M_PB_BNF_CODE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_PB_LIMIT_TYPE.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BTN_DEDUCTIBLE.setDisabled(disabled);
		COMP_UI_M_BTN_MAIN_COVER_DTLS.setDisabled(disabled);
		COMP_UI_M_BTN_SUB_BENEFIT_DTLS.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_BENEFIT_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PB_BNF_CODE				 = new HtmlInputText();
		COMP_PB_PER_DAY_LC_AMT				 = new HtmlInputText();
		COMP_PB_LIMIT_DAYS				 = new HtmlInputText();
		COMP_PB_LC_LIMIT				 = new HtmlInputText();
		COMP_UI_M_PB_BNF_CODE_DESC			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PB_BNF_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_PB_LIMIT_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_PB_PER_DAY_LC_AMT_LABEL			 = new HtmlOutputLabel();
		COMP_PB_LIMIT_DAYS_LABEL			 = new HtmlOutputLabel();
		COMP_PB_LC_LIMIT_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_PB_BNF_CODE_DESC_LABEL		 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_PB_LIMIT_TYPE				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BTN_DEDUCTIBLE			 = new HtmlCommandButton();
		COMP_UI_M_BTN_MAIN_COVER_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_BTN_SUB_BENEFIT_DTLS			 = new HtmlCommandButton();

	}



}
