package com.iii.pel.forms.PILT021;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TRAN_STATUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_WD_STATUS_DT;

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WD_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WD_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_LABEL;

	private HtmlInputText COMP_UI_M_WD_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_WD_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_WD_REMARKS_LABEL;

	private HtmlInputText COMP_UI_M_WD_REMARKS;

	private HtmlOutputLabel COMP_TS_STATUS_DT_LABEL;

	private HtmlCalendar COMP_TS_STATUS_DT;

	private HtmlOutputLabel COMP_TS_STATUS_CODE_LABEL;

	private HtmlInputText COMP_TS_STATUS_CODE;

	private HtmlOutputLabel COMP_TS_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_TS_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_TS_REASON_CODE_LABEL;

	private HtmlInputText COMP_TS_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_TS_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TS_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_TS_STATUS_UID_LABEL;

	private HtmlInputText COMP_TS_STATUS_UID;

	private HtmlOutputLabel COMP_TS_REMARKS_LABEL;

	private HtmlInputText COMP_TS_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_STATUS_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_REASON_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_EDI;

	private PT_IL_TRAN_STATUS PT_IL_TRAN_STATUS_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private PT_IL_TRAN_STATUS_HELPER helper;

	private List<PT_IL_TRAN_STATUS> dataList_PT_IL_TRAN_STATUS = new ArrayList<PT_IL_TRAN_STATUS>();

	private UIData dataTable;



	public PT_IL_TRAN_STATUS_ACTION(){


		PT_IL_TRAN_STATUS_BEAN = new PT_IL_TRAN_STATUS();
		helper = new PT_IL_TRAN_STATUS_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_DT_LABEL() {
		return COMP_UI_M_WD_STATUS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_WD_STATUS_DT() {
		return COMP_UI_M_WD_STATUS_DT;
	}

	public void setCOMP_UI_M_WD_STATUS_DT_LABEL(HtmlOutputLabel COMP_UI_M_WD_STATUS_DT_LABEL) {
		this.COMP_UI_M_WD_STATUS_DT_LABEL = COMP_UI_M_WD_STATUS_DT_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_DT(HtmlCalendar COMP_UI_M_WD_STATUS_DT) {
		this.COMP_UI_M_WD_STATUS_DT = COMP_UI_M_WD_STATUS_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_CODE_LABEL() {
		return COMP_UI_M_WD_STATUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_STATUS_CODE() {
		return COMP_UI_M_WD_STATUS_CODE;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_LABEL(HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_LABEL) {
		this.COMP_UI_M_WD_STATUS_CODE_LABEL = COMP_UI_M_WD_STATUS_CODE_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE(HtmlInputText COMP_UI_M_WD_STATUS_CODE) {
		this.COMP_UI_M_WD_STATUS_CODE = COMP_UI_M_WD_STATUS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_CODE_DESC_LABEL() {
		return COMP_UI_M_WD_STATUS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_STATUS_CODE_DESC() {
		return COMP_UI_M_WD_STATUS_CODE_DESC;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_DESC_LABEL) {
		this.COMP_UI_M_WD_STATUS_CODE_DESC_LABEL = COMP_UI_M_WD_STATUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_DESC(HtmlInputText COMP_UI_M_WD_STATUS_CODE_DESC) {
		this.COMP_UI_M_WD_STATUS_CODE_DESC = COMP_UI_M_WD_STATUS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_REASON_CODE_LABEL() {
		return COMP_UI_M_WD_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_REASON_CODE() {
		return COMP_UI_M_WD_REASON_CODE;
	}

	public void setCOMP_UI_M_WD_REASON_CODE_LABEL(HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_LABEL) {
		this.COMP_UI_M_WD_REASON_CODE_LABEL = COMP_UI_M_WD_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_WD_REASON_CODE(HtmlInputText COMP_UI_M_WD_REASON_CODE) {
		this.COMP_UI_M_WD_REASON_CODE = COMP_UI_M_WD_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_WD_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_REASON_CODE_DESC() {
		return COMP_UI_M_WD_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_WD_REASON_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_WD_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_WD_REASON_CODE_DESC_LABEL = COMP_UI_M_WD_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_WD_REASON_CODE_DESC(HtmlInputText COMP_UI_M_WD_REASON_CODE_DESC) {
		this.COMP_UI_M_WD_REASON_CODE_DESC = COMP_UI_M_WD_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_REMARKS_LABEL() {
		return COMP_UI_M_WD_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WD_REMARKS() {
		return COMP_UI_M_WD_REMARKS;
	}

	public void setCOMP_UI_M_WD_REMARKS_LABEL(HtmlOutputLabel COMP_UI_M_WD_REMARKS_LABEL) {
		this.COMP_UI_M_WD_REMARKS_LABEL = COMP_UI_M_WD_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_WD_REMARKS(HtmlInputText COMP_UI_M_WD_REMARKS) {
		this.COMP_UI_M_WD_REMARKS = COMP_UI_M_WD_REMARKS;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_DT_LABEL() {
		return COMP_TS_STATUS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TS_STATUS_DT() {
		return COMP_TS_STATUS_DT;
	}

	public void setCOMP_TS_STATUS_DT_LABEL(HtmlOutputLabel COMP_TS_STATUS_DT_LABEL) {
		this.COMP_TS_STATUS_DT_LABEL = COMP_TS_STATUS_DT_LABEL;
	}

	public void setCOMP_TS_STATUS_DT(HtmlCalendar COMP_TS_STATUS_DT) {
		this.COMP_TS_STATUS_DT = COMP_TS_STATUS_DT;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_CODE_LABEL() {
		return COMP_TS_STATUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TS_STATUS_CODE() {
		return COMP_TS_STATUS_CODE;
	}

	public void setCOMP_TS_STATUS_CODE_LABEL(HtmlOutputLabel COMP_TS_STATUS_CODE_LABEL) {
		this.COMP_TS_STATUS_CODE_LABEL = COMP_TS_STATUS_CODE_LABEL;
	}

	public void setCOMP_TS_STATUS_CODE(HtmlInputText COMP_TS_STATUS_CODE) {
		this.COMP_TS_STATUS_CODE = COMP_TS_STATUS_CODE;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_CODE_DESC_LABEL() {
		return COMP_TS_STATUS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_TS_STATUS_CODE_DESC() {
		return COMP_TS_STATUS_CODE_DESC;
	}

	public void setCOMP_TS_STATUS_CODE_DESC_LABEL(HtmlOutputLabel COMP_TS_STATUS_CODE_DESC_LABEL) {
		this.COMP_TS_STATUS_CODE_DESC_LABEL = COMP_TS_STATUS_CODE_DESC_LABEL;
	}

	public void setCOMP_TS_STATUS_CODE_DESC(HtmlInputText COMP_TS_STATUS_CODE_DESC) {
		this.COMP_TS_STATUS_CODE_DESC = COMP_TS_STATUS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_TS_REASON_CODE_LABEL() {
		return COMP_TS_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TS_REASON_CODE() {
		return COMP_TS_REASON_CODE;
	}

	public void setCOMP_TS_REASON_CODE_LABEL(HtmlOutputLabel COMP_TS_REASON_CODE_LABEL) {
		this.COMP_TS_REASON_CODE_LABEL = COMP_TS_REASON_CODE_LABEL;
	}

	public void setCOMP_TS_REASON_CODE(HtmlInputText COMP_TS_REASON_CODE) {
		this.COMP_TS_REASON_CODE = COMP_TS_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TS_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_TS_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TS_REASON_CODE_DESC() {
		return COMP_UI_M_TS_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_TS_REASON_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TS_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_TS_REASON_CODE_DESC_LABEL = COMP_UI_M_TS_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_TS_REASON_CODE_DESC(HtmlInputText COMP_UI_M_TS_REASON_CODE_DESC) {
		this.COMP_UI_M_TS_REASON_CODE_DESC = COMP_UI_M_TS_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_TS_STATUS_UID_LABEL() {
		return COMP_TS_STATUS_UID_LABEL;
	}

	public HtmlInputText getCOMP_TS_STATUS_UID() {
		return COMP_TS_STATUS_UID;
	}

	public void setCOMP_TS_STATUS_UID_LABEL(HtmlOutputLabel COMP_TS_STATUS_UID_LABEL) {
		this.COMP_TS_STATUS_UID_LABEL = COMP_TS_STATUS_UID_LABEL;
	}

	public void setCOMP_TS_STATUS_UID(HtmlInputText COMP_TS_STATUS_UID) {
		this.COMP_TS_STATUS_UID = COMP_TS_STATUS_UID;
	}

	public HtmlOutputLabel getCOMP_TS_REMARKS_LABEL() {
		return COMP_TS_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_TS_REMARKS() {
		return COMP_TS_REMARKS;
	}

	public void setCOMP_TS_REMARKS_LABEL(HtmlOutputLabel COMP_TS_REMARKS_LABEL) {
		this.COMP_TS_REMARKS_LABEL = COMP_TS_REMARKS_LABEL;
	}

	public void setCOMP_TS_REMARKS(HtmlInputText COMP_TS_REMARKS) {
		this.COMP_TS_REMARKS = COMP_TS_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_STATUS_LOV() {
		return COMP_UI_M_BUT_STATUS_LOV;
	}

	public void setCOMP_UI_M_BUT_STATUS_LOV(HtmlCommandButton COMP_UI_M_BUT_STATUS_LOV) {
		this.COMP_UI_M_BUT_STATUS_LOV = COMP_UI_M_BUT_STATUS_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REASON_LOV() {
		return COMP_UI_M_BUT_REASON_LOV;
	}

	public void setCOMP_UI_M_BUT_REASON_LOV(HtmlCommandButton COMP_UI_M_BUT_REASON_LOV) {
		this.COMP_UI_M_BUT_REASON_LOV = COMP_UI_M_BUT_REASON_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDI() {
		return COMP_UI_M_BUT_EDI;
	}

	public void setCOMP_UI_M_BUT_EDI(HtmlCommandButton COMP_UI_M_BUT_EDI) {
		this.COMP_UI_M_BUT_EDI = COMP_UI_M_BUT_EDI;
	}

	public PT_IL_TRAN_STATUS getPT_IL_TRAN_STATUS_BEAN() {
		return PT_IL_TRAN_STATUS_BEAN;
	}

	public void setPT_IL_TRAN_STATUS_BEAN(PT_IL_TRAN_STATUS PT_IL_TRAN_STATUS_BEAN) {
		this.PT_IL_TRAN_STATUS_BEAN = PT_IL_TRAN_STATUS_BEAN;
	}

	public List<PT_IL_TRAN_STATUS> getDataList_PT_IL_TRAN_STATUS() {
		return dataList_PT_IL_TRAN_STATUS;
	}

	public void setDataListPT_IL_TRAN_STATUS(List<PT_IL_TRAN_STATUS> dataList_PT_IL_TRAN_STATUS) {
		this.dataList_PT_IL_TRAN_STATUS = dataList_PT_IL_TRAN_STATUS;
	}

	public void addRow(ActionEvent event){
		try{
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()){

				PT_IL_TRAN_STATUS_BEAN = new PT_IL_TRAN_STATUS();
				resetAllComponent();
				resetSelectedRow();
			}else{

				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, 
				"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$insertnotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow",exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event){
		try{
			if (isDELETE_ALLOWED()){

				new CRUDHandler().executeDelete(PT_IL_TRAN_STATUS_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$delete"));
				dataList_PT_IL_TRAN_STATUS.remove(PT_IL_TRAN_STATUS_BEAN);
				if(dataList_PT_IL_TRAN_STATUS.size()>0){

					PT_IL_TRAN_STATUS_BEAN=dataList_PT_IL_TRAN_STATUS.get(0);
				}else if(dataList_PT_IL_TRAN_STATUS.size()==0){

					addRow(null);
				}

				resetAllComponent();
				PT_IL_TRAN_STATUS_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$deletenotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event){
		CommonUtils.clearMaps(this);
		try{
			if(PT_IL_TRAN_STATUS_BEAN.getROWID()==null && isINSERT_ALLOWED()){

				helper.preInsert(PT_IL_TRAN_STATUS_BEAN, 
						compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN());
				
				
				new CRUDHandler().executeInsert(PT_IL_TRAN_STATUS_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				dataList_PT_IL_TRAN_STATUS.add(PT_IL_TRAN_STATUS_BEAN);
			}else if(PT_IL_TRAN_STATUS_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){

				new CRUDHandler().executeUpdate(PT_IL_TRAN_STATUS_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
			}

			PT_IL_TRAN_STATUS_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}

	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);try{
			resetSelectedRow();
			PT_IL_TRAN_STATUS_BEAN = (PT_IL_TRAN_STATUS)dataTable.getRowData();
			helper.postQuery(PT_IL_TRAN_STATUS_BEAN);
			PT_IL_TRAN_STATUS_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}

	}

	private void resetSelectedRow(){
		Iterator<PT_IL_TRAN_STATUS> PT_IL_TRAN_STATUS_ITR = dataList_PT_IL_TRAN_STATUS.iterator();
		while (PT_IL_TRAN_STATUS_ITR.hasNext()) {
			PT_IL_TRAN_STATUS_ITR.next().setRowSelected(false);}
	}

	private void resetAllComponent(){
		COMP_UI_M_WD_STATUS_DT.resetValue();
		COMP_UI_M_WD_STATUS_CODE.resetValue();
		COMP_UI_M_WD_STATUS_CODE_DESC.resetValue();
		COMP_UI_M_WD_REASON_CODE.resetValue();
		COMP_UI_M_WD_REASON_CODE_DESC.resetValue();
		COMP_UI_M_WD_REMARKS.resetValue();
		COMP_TS_STATUS_DT.resetValue();
		COMP_TS_STATUS_CODE.resetValue();
		COMP_TS_STATUS_CODE_DESC.resetValue();
		COMP_TS_REASON_CODE.resetValue();
		COMP_UI_M_TS_REASON_CODE_DESC.resetValue();
		COMP_TS_STATUS_UID.resetValue();
		COMP_TS_REMARKS.resetValue();
	}

	public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
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
				helper.preQuery(PT_IL_TRAN_STATUS_BEAN, 
						compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN());
				helper.executeQuery(compositeAction);
				if(PT_IL_TRAN_STATUS_BEAN.getROWID() != null){
					helper.postQuery(PT_IL_TRAN_STATUS_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}

}
