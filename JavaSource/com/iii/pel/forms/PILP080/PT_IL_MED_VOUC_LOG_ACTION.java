package com.iii.pel.forms.PILP080;

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

public class PT_IL_MED_VOUC_LOG_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMV_CLINIC_CODE_LABEL;

	private HtmlInputText COMP_PMV_CLINIC_CODE;

	private HtmlOutputLabel COMP_PMV_ERR_DESC_LABEL;

	private HtmlInputText COMP_PMV_ERR_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_BACK;

	private PT_IL_MED_VOUC_LOG PT_IL_MED_VOUC_LOG_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private PT_IL_MED_VOUC_LOG_HELPER helper;

	private List<PT_IL_MED_VOUC_LOG> dataList_PT_IL_MED_VOUC_LOG = new ArrayList<PT_IL_MED_VOUC_LOG>();

	 private UIData dataTable;



public PT_IL_MED_VOUC_LOG_ACTION(){


PT_IL_MED_VOUC_LOG_BEAN = new PT_IL_MED_VOUC_LOG();
helper = new PT_IL_MED_VOUC_LOG_HELPER();
}

	public HtmlOutputLabel getCOMP_PMV_CLINIC_CODE_LABEL() {
		return COMP_PMV_CLINIC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PMV_CLINIC_CODE() {
		return COMP_PMV_CLINIC_CODE;
	}

	public void setCOMP_PMV_CLINIC_CODE_LABEL(HtmlOutputLabel COMP_PMV_CLINIC_CODE_LABEL) {
		this.COMP_PMV_CLINIC_CODE_LABEL = COMP_PMV_CLINIC_CODE_LABEL;
	}

	public void setCOMP_PMV_CLINIC_CODE(HtmlInputText COMP_PMV_CLINIC_CODE) {
		this.COMP_PMV_CLINIC_CODE = COMP_PMV_CLINIC_CODE;
	}

	public HtmlOutputLabel getCOMP_PMV_ERR_DESC_LABEL() {
		return COMP_PMV_ERR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PMV_ERR_DESC() {
		return COMP_PMV_ERR_DESC;
	}

	public void setCOMP_PMV_ERR_DESC_LABEL(HtmlOutputLabel COMP_PMV_ERR_DESC_LABEL) {
		this.COMP_PMV_ERR_DESC_LABEL = COMP_PMV_ERR_DESC_LABEL;
	}

	public void setCOMP_PMV_ERR_DESC(HtmlInputText COMP_PMV_ERR_DESC) {
		this.COMP_PMV_ERR_DESC = COMP_PMV_ERR_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BACK() {
		return COMP_UI_M_BUT_BACK;
	}

	public void setCOMP_UI_M_BUT_BACK(HtmlCommandButton COMP_UI_M_BUT_BACK) {
		this.COMP_UI_M_BUT_BACK = COMP_UI_M_BUT_BACK;
	}

	public PT_IL_MED_VOUC_LOG getPT_IL_MED_VOUC_LOG_BEAN() {
		return PT_IL_MED_VOUC_LOG_BEAN;
	}

	public void setPT_IL_MED_VOUC_LOG_BEAN(PT_IL_MED_VOUC_LOG PT_IL_MED_VOUC_LOG_BEAN) {
		this.PT_IL_MED_VOUC_LOG_BEAN = PT_IL_MED_VOUC_LOG_BEAN;
	}

	public List<PT_IL_MED_VOUC_LOG> getDataList_PT_IL_MED_VOUC_LOG() {
		return dataList_PT_IL_MED_VOUC_LOG;
	}

	public void setDataListPT_IL_MED_VOUC_LOG(List<PT_IL_MED_VOUC_LOG> dataList_PT_IL_MED_VOUC_LOG) {
		this.dataList_PT_IL_MED_VOUC_LOG = dataList_PT_IL_MED_VOUC_LOG;
	}

public void addRow(ActionEvent event){
try{
if (isINSERT_ALLOWED()){

PT_IL_MED_VOUC_LOG_BEAN = new PT_IL_MED_VOUC_LOG();
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

new CRUDHandler().executeDelete(PT_IL_MED_VOUC_LOG_BEAN,CommonUtils.getConnection());
getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
dataList_PT_IL_MED_VOUC_LOG.remove(PT_IL_MED_VOUC_LOG_BEAN);
if(dataList_PT_IL_MED_VOUC_LOG.size()>0){

PT_IL_MED_VOUC_LOG_BEAN=dataList_PT_IL_MED_VOUC_LOG.get(0);
}else if(dataList_PT_IL_MED_VOUC_LOG.size()==0){

addRow(null);
}

resetAllComponent();
PT_IL_MED_VOUC_LOG_BEAN.setRowSelected(true);
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
if(PT_IL_MED_VOUC_LOG_BEAN.getROWID()==null && isINSERT_ALLOWED()){

new CRUDHandler().executeInsert(PT_IL_MED_VOUC_LOG_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
dataList_PT_IL_MED_VOUC_LOG.add(PT_IL_MED_VOUC_LOG_BEAN);
}else if(PT_IL_MED_VOUC_LOG_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){

new CRUDHandler().executeUpdate(PT_IL_MED_VOUC_LOG_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
}

PT_IL_MED_VOUC_LOG_BEAN.setRowSelected(true);
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
}

}

public void displayRecords(){
CommonUtils.clearMaps(this);try{
resetSelectedRow();
PT_IL_MED_VOUC_LOG_BEAN = (PT_IL_MED_VOUC_LOG)dataTable.getRowData();
PT_IL_MED_VOUC_LOG_BEAN.setRowSelected(true);
resetAllComponent();
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("displayRecords",exc.getMessage());
}

}

private void resetSelectedRow(){
Iterator<PT_IL_MED_VOUC_LOG> PT_IL_MED_VOUC_LOG_ITR = dataList_PT_IL_MED_VOUC_LOG.iterator();while (PT_IL_MED_VOUC_LOG_ITR.hasNext()) {
PT_IL_MED_VOUC_LOG_ITR.next().setRowSelected(false);}
}

private void resetAllComponent(){
COMP_PMV_CLINIC_CODE.resetValue();
COMP_PMV_ERR_DESC.resetValue();
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
 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
 getErrorMap().put("onLoad",e.getMessage());
 }
 }

}