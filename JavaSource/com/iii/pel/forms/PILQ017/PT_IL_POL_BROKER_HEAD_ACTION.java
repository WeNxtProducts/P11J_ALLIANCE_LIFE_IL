package com.iii.pel.forms.PILQ017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_HEAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POBH_SRNO_LABEL;

	private HtmlInputText COMP_POBH_SRNO;

	private HtmlOutputLabel COMP_POBH_BROKER_CODE_LABEL;

	private HtmlInputText COMP_POBH_BROKER_CODE;

	private HtmlOutputLabel COMP_POBH_COMM_CODE_LABEL;

	private HtmlInputText COMP_POBH_COMM_CODE;

	private HtmlOutputLabel COMP_POBH_COVER_CODE_LABEL;

	private HtmlInputText COMP_POBH_COVER_CODE;

	private HtmlOutputLabel COMP_POBH_APPLY_ON_SRNO_LABEL;

	private HtmlInputText COMP_POBH_APPLY_ON_SRNO;

	private HtmlOutputLabel COMP_POBH_BROKER_CURR_CODE_LABEL;

	private HtmlInputText COMP_POBH_BROKER_CURR_CODE;

	private HtmlOutputLabel COMP_POBH_ACTING_AGENT_YN_LABEL;

	private HtmlSelectOneMenu COMP_POBH_ACTING_AGENT_YN;

	private HtmlOutputLabel COMP_POBH_REMARKS_LABEL;

	private HtmlInputText COMP_POBH_REMARKS;

	private HtmlOutputLabel COMP_UI_M_POBH_BROKER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_BROKER_DESC;

	private HtmlOutputLabel COMP_UI_M_POBH_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_POBH_CURR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_CURR_DESC;

	private HtmlOutputLabel COMP_UI_M_PS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PS_DESC;

	private PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BROKER_HEAD_HELPER helper;

	private List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD = new ArrayList<PT_IL_POL_BROKER_HEAD>();

	 private UIData dataTable;

	private List<SelectItem> listPOBH_ACTING_AGENT_YN = new ArrayList<SelectItem>();



public PT_IL_POL_BROKER_HEAD_ACTION(){


PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
helper = new PT_IL_POL_BROKER_HEAD_HELPER();
}

	public HtmlOutputLabel getCOMP_POBH_SRNO_LABEL() {
		return COMP_POBH_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_POBH_SRNO() {
		return COMP_POBH_SRNO;
	}

	public void setCOMP_POBH_SRNO_LABEL(HtmlOutputLabel COMP_POBH_SRNO_LABEL) {
		this.COMP_POBH_SRNO_LABEL = COMP_POBH_SRNO_LABEL;
	}

	public void setCOMP_POBH_SRNO(HtmlInputText COMP_POBH_SRNO) {
		this.COMP_POBH_SRNO = COMP_POBH_SRNO;
	}

	public HtmlOutputLabel getCOMP_POBH_BROKER_CODE_LABEL() {
		return COMP_POBH_BROKER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POBH_BROKER_CODE() {
		return COMP_POBH_BROKER_CODE;
	}

	public void setCOMP_POBH_BROKER_CODE_LABEL(HtmlOutputLabel COMP_POBH_BROKER_CODE_LABEL) {
		this.COMP_POBH_BROKER_CODE_LABEL = COMP_POBH_BROKER_CODE_LABEL;
	}

	public void setCOMP_POBH_BROKER_CODE(HtmlInputText COMP_POBH_BROKER_CODE) {
		this.COMP_POBH_BROKER_CODE = COMP_POBH_BROKER_CODE;
	}

	public HtmlOutputLabel getCOMP_POBH_COMM_CODE_LABEL() {
		return COMP_POBH_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POBH_COMM_CODE() {
		return COMP_POBH_COMM_CODE;
	}

	public void setCOMP_POBH_COMM_CODE_LABEL(HtmlOutputLabel COMP_POBH_COMM_CODE_LABEL) {
		this.COMP_POBH_COMM_CODE_LABEL = COMP_POBH_COMM_CODE_LABEL;
	}

	public void setCOMP_POBH_COMM_CODE(HtmlInputText COMP_POBH_COMM_CODE) {
		this.COMP_POBH_COMM_CODE = COMP_POBH_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_POBH_COVER_CODE_LABEL() {
		return COMP_POBH_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POBH_COVER_CODE() {
		return COMP_POBH_COVER_CODE;
	}

	public void setCOMP_POBH_COVER_CODE_LABEL(HtmlOutputLabel COMP_POBH_COVER_CODE_LABEL) {
		this.COMP_POBH_COVER_CODE_LABEL = COMP_POBH_COVER_CODE_LABEL;
	}

	public void setCOMP_POBH_COVER_CODE(HtmlInputText COMP_POBH_COVER_CODE) {
		this.COMP_POBH_COVER_CODE = COMP_POBH_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_POBH_APPLY_ON_SRNO_LABEL() {
		return COMP_POBH_APPLY_ON_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_POBH_APPLY_ON_SRNO() {
		return COMP_POBH_APPLY_ON_SRNO;
	}

	public void setCOMP_POBH_APPLY_ON_SRNO_LABEL(HtmlOutputLabel COMP_POBH_APPLY_ON_SRNO_LABEL) {
		this.COMP_POBH_APPLY_ON_SRNO_LABEL = COMP_POBH_APPLY_ON_SRNO_LABEL;
	}

	public void setCOMP_POBH_APPLY_ON_SRNO(HtmlInputText COMP_POBH_APPLY_ON_SRNO) {
		this.COMP_POBH_APPLY_ON_SRNO = COMP_POBH_APPLY_ON_SRNO;
	}

	public HtmlOutputLabel getCOMP_POBH_BROKER_CURR_CODE_LABEL() {
		return COMP_POBH_BROKER_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POBH_BROKER_CURR_CODE() {
		return COMP_POBH_BROKER_CURR_CODE;
	}

	public void setCOMP_POBH_BROKER_CURR_CODE_LABEL(HtmlOutputLabel COMP_POBH_BROKER_CURR_CODE_LABEL) {
		this.COMP_POBH_BROKER_CURR_CODE_LABEL = COMP_POBH_BROKER_CURR_CODE_LABEL;
	}

	public void setCOMP_POBH_BROKER_CURR_CODE(HtmlInputText COMP_POBH_BROKER_CURR_CODE) {
		this.COMP_POBH_BROKER_CURR_CODE = COMP_POBH_BROKER_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_POBH_ACTING_AGENT_YN_LABEL() {
		return COMP_POBH_ACTING_AGENT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POBH_ACTING_AGENT_YN() {
		return COMP_POBH_ACTING_AGENT_YN;
	}

	public void setCOMP_POBH_ACTING_AGENT_YN_LABEL(HtmlOutputLabel COMP_POBH_ACTING_AGENT_YN_LABEL) {
		this.COMP_POBH_ACTING_AGENT_YN_LABEL = COMP_POBH_ACTING_AGENT_YN_LABEL;
	}

	public void setCOMP_POBH_ACTING_AGENT_YN(HtmlSelectOneMenu COMP_POBH_ACTING_AGENT_YN) {
		this.COMP_POBH_ACTING_AGENT_YN = COMP_POBH_ACTING_AGENT_YN;
	}

	public HtmlOutputLabel getCOMP_POBH_REMARKS_LABEL() {
		return COMP_POBH_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_POBH_REMARKS() {
		return COMP_POBH_REMARKS;
	}

	public void setCOMP_POBH_REMARKS_LABEL(HtmlOutputLabel COMP_POBH_REMARKS_LABEL) {
		this.COMP_POBH_REMARKS_LABEL = COMP_POBH_REMARKS_LABEL;
	}

	public void setCOMP_POBH_REMARKS(HtmlInputText COMP_POBH_REMARKS) {
		this.COMP_POBH_REMARKS = COMP_POBH_REMARKS;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_BROKER_DESC_LABEL() {
		return COMP_UI_M_POBH_BROKER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POBH_BROKER_DESC() {
		return COMP_UI_M_POBH_BROKER_DESC;
	}

	public void setCOMP_UI_M_POBH_BROKER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POBH_BROKER_DESC_LABEL) {
		this.COMP_UI_M_POBH_BROKER_DESC_LABEL = COMP_UI_M_POBH_BROKER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_BROKER_DESC(HtmlInputText COMP_UI_M_POBH_BROKER_DESC) {
		this.COMP_UI_M_POBH_BROKER_DESC = COMP_UI_M_POBH_BROKER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_COVER_DESC_LABEL() {
		return COMP_UI_M_POBH_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POBH_COVER_DESC() {
		return COMP_UI_M_POBH_COVER_DESC;
	}

	public void setCOMP_UI_M_POBH_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POBH_COVER_DESC_LABEL) {
		this.COMP_UI_M_POBH_COVER_DESC_LABEL = COMP_UI_M_POBH_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_COVER_DESC(HtmlInputText COMP_UI_M_POBH_COVER_DESC) {
		this.COMP_UI_M_POBH_COVER_DESC = COMP_UI_M_POBH_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_CURR_DESC_LABEL() {
		return COMP_UI_M_POBH_CURR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POBH_CURR_DESC() {
		return COMP_UI_M_POBH_CURR_DESC;
	}

	public void setCOMP_UI_M_POBH_CURR_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POBH_CURR_DESC_LABEL) {
		this.COMP_UI_M_POBH_CURR_DESC_LABEL = COMP_UI_M_POBH_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_CURR_DESC(HtmlInputText COMP_UI_M_POBH_CURR_DESC) {
		this.COMP_UI_M_POBH_CURR_DESC = COMP_UI_M_POBH_CURR_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_DESC_LABEL() {
		return COMP_UI_M_PS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PS_DESC() {
		return COMP_UI_M_PS_DESC;
	}

	public void setCOMP_UI_M_PS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PS_DESC_LABEL) {
		this.COMP_UI_M_PS_DESC_LABEL = COMP_UI_M_PS_DESC_LABEL;
	}

	public void setCOMP_UI_M_PS_DESC(HtmlInputText COMP_UI_M_PS_DESC) {
		this.COMP_UI_M_PS_DESC = COMP_UI_M_PS_DESC;
	}

	public PT_IL_POL_BROKER_HEAD getPT_IL_POL_BROKER_HEAD_BEAN() {
		return PT_IL_POL_BROKER_HEAD_BEAN;
	}

	public void setPT_IL_POL_BROKER_HEAD_BEAN(PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN) {
		this.PT_IL_POL_BROKER_HEAD_BEAN = PT_IL_POL_BROKER_HEAD_BEAN;
	}

	public List<PT_IL_POL_BROKER_HEAD> getDataList_PT_IL_POL_BROKER_HEAD() {
		return dataList_PT_IL_POL_BROKER_HEAD;
	}

	public void setDataListPT_IL_POL_BROKER_HEAD(List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD) {
		this.dataList_PT_IL_POL_BROKER_HEAD = dataList_PT_IL_POL_BROKER_HEAD;
	}

public void addRow(ActionEvent event){
try{
if (isINSERT_ALLOWED()){

PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
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

new CRUDHandler().executeDelete(PT_IL_POL_BROKER_HEAD_BEAN,CommonUtils.getConnection());
getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
dataList_PT_IL_POL_BROKER_HEAD.remove(PT_IL_POL_BROKER_HEAD_BEAN);
if(dataList_PT_IL_POL_BROKER_HEAD.size()>0){

PT_IL_POL_BROKER_HEAD_BEAN=dataList_PT_IL_POL_BROKER_HEAD.get(0);
}else if(dataList_PT_IL_POL_BROKER_HEAD.size()==0){

addRow(null);
}

resetAllComponent();
PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
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
if(PT_IL_POL_BROKER_HEAD_BEAN.getROWID()==null && isINSERT_ALLOWED()){

new CRUDHandler().executeInsert(PT_IL_POL_BROKER_HEAD_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
dataList_PT_IL_POL_BROKER_HEAD.add(PT_IL_POL_BROKER_HEAD_BEAN);
}else if(PT_IL_POL_BROKER_HEAD_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){

new CRUDHandler().executeUpdate(PT_IL_POL_BROKER_HEAD_BEAN,CommonUtils.getConnection());
getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
}

PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
}

}

public void displayRecords(){
CommonUtils.clearMaps(this);try{
resetSelectedRow();
PT_IL_POL_BROKER_HEAD_BEAN = (PT_IL_POL_BROKER_HEAD)dataTable.getRowData();
PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
resetAllComponent();
}catch(Exception exc){
getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
getErrorMap().put("displayRecords",exc.getMessage());
}

}

private void resetSelectedRow(){
Iterator<PT_IL_POL_BROKER_HEAD> PT_IL_POL_BROKER_HEAD_ITR = dataList_PT_IL_POL_BROKER_HEAD.iterator();while (PT_IL_POL_BROKER_HEAD_ITR.hasNext()) {
PT_IL_POL_BROKER_HEAD_ITR.next().setRowSelected(false);}
}

private void resetAllComponent(){
COMP_POBH_SRNO.resetValue();
COMP_POBH_BROKER_CODE.resetValue();
COMP_POBH_COMM_CODE.resetValue();
COMP_POBH_COVER_CODE.resetValue();
COMP_POBH_APPLY_ON_SRNO.resetValue();
COMP_POBH_BROKER_CURR_CODE.resetValue();
COMP_POBH_ACTING_AGENT_YN.resetValue();
COMP_POBH_REMARKS.resetValue();
COMP_UI_M_POBH_BROKER_DESC.resetValue();
COMP_UI_M_POBH_COVER_DESC.resetValue();
COMP_UI_M_POBH_CURR_DESC.resetValue();
COMP_UI_M_PS_DESC.resetValue();
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


	public List<SelectItem> getListPOBH_ACTING_AGENT_YN() {
		if (listPOBH_ACTING_AGENT_YN.size() == 0) {
			listPOBH_ACTING_AGENT_YN.clear();
			try {
				listPOBH_ACTING_AGENT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOBH_ACTING_AGENT_YN;
	}

	public void setListPOBH_ACTING_AGENT_YN(List<SelectItem> listPOBH_ACTING_AGENT_YN) {
		this.listPOBH_ACTING_AGENT_YN = listPOBH_ACTING_AGENT_YN;
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
