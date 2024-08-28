package com.iii.pel.forms.PILT021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_WITHDRAWAL_UNIT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_WDU_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_WDU_POL_NO;

	private HtmlOutputLabel COMP_WDU_COVER_CODE_LABEL;

	private HtmlInputText COMP_WDU_COVER_CODE;

	private HtmlOutputLabel COMP_WDU_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WDU_TYPE;

	private HtmlOutputLabel COMP_WDU_AVBL_UNIT_LABEL;

	private HtmlInputText COMP_WDU_AVBL_UNIT;

	private HtmlOutputLabel COMP_WDU_AVBL_FC_AMT_LABEL;

	private HtmlInputText COMP_WDU_AVBL_FC_AMT;

	private HtmlOutputLabel COMP_WDU_AVBL_LC_AMT_LABEL;

	private HtmlInputText COMP_WDU_AVBL_LC_AMT;

	private HtmlOutputLabel COMP_WDU_WD_UNIT_LABEL;

	private HtmlInputText COMP_WDU_WD_UNIT;

	private HtmlOutputLabel COMP_WDU_WD_FC_AMT_LABEL;

	private HtmlInputText COMP_WDU_WD_FC_AMT;

	private HtmlOutputLabel COMP_WDU_WD_LC_AMT_LABEL;

	private HtmlInputText COMP_WDU_WD_LC_AMT;

	private PT_IL_WITHDRAWAL_UNIT PT_IL_WITHDRAWAL_UNIT_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private PT_IL_WITHDRAWAL_UNIT_HELPER helper;

	private List<PT_IL_WITHDRAWAL_UNIT> dataList_PT_IL_WITHDRAWAL_UNIT = new ArrayList<PT_IL_WITHDRAWAL_UNIT>();

	private UIData dataTable;

	private List<SelectItem> listWDU_TYPE = new ArrayList<SelectItem>();



	public PT_IL_WITHDRAWAL_UNIT_ACTION(){


		PT_IL_WITHDRAWAL_UNIT_BEAN = new PT_IL_WITHDRAWAL_UNIT();
		helper = new PT_IL_WITHDRAWAL_UNIT_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_WDU_POL_NO_LABEL() {
		return COMP_UI_M_WDU_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_WDU_POL_NO() {
		return COMP_UI_M_WDU_POL_NO;
	}

	public void setCOMP_UI_M_WDU_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_WDU_POL_NO_LABEL) {
		this.COMP_UI_M_WDU_POL_NO_LABEL = COMP_UI_M_WDU_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_WDU_POL_NO(HtmlInputText COMP_UI_M_WDU_POL_NO) {
		this.COMP_UI_M_WDU_POL_NO = COMP_UI_M_WDU_POL_NO;
	}

	public HtmlOutputLabel getCOMP_WDU_COVER_CODE_LABEL() {
		return COMP_WDU_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WDU_COVER_CODE() {
		return COMP_WDU_COVER_CODE;
	}

	public void setCOMP_WDU_COVER_CODE_LABEL(HtmlOutputLabel COMP_WDU_COVER_CODE_LABEL) {
		this.COMP_WDU_COVER_CODE_LABEL = COMP_WDU_COVER_CODE_LABEL;
	}

	public void setCOMP_WDU_COVER_CODE(HtmlInputText COMP_WDU_COVER_CODE) {
		this.COMP_WDU_COVER_CODE = COMP_WDU_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_WDU_TYPE_LABEL() {
		return COMP_WDU_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WDU_TYPE() {
		return COMP_WDU_TYPE;
	}

	public void setCOMP_WDU_TYPE_LABEL(HtmlOutputLabel COMP_WDU_TYPE_LABEL) {
		this.COMP_WDU_TYPE_LABEL = COMP_WDU_TYPE_LABEL;
	}

	public void setCOMP_WDU_TYPE(HtmlSelectOneMenu COMP_WDU_TYPE) {
		this.COMP_WDU_TYPE = COMP_WDU_TYPE;
	}

	public HtmlOutputLabel getCOMP_WDU_AVBL_UNIT_LABEL() {
		return COMP_WDU_AVBL_UNIT_LABEL;
	}

	public HtmlInputText getCOMP_WDU_AVBL_UNIT() {
		return COMP_WDU_AVBL_UNIT;
	}

	public void setCOMP_WDU_AVBL_UNIT_LABEL(HtmlOutputLabel COMP_WDU_AVBL_UNIT_LABEL) {
		this.COMP_WDU_AVBL_UNIT_LABEL = COMP_WDU_AVBL_UNIT_LABEL;
	}

	public void setCOMP_WDU_AVBL_UNIT(HtmlInputText COMP_WDU_AVBL_UNIT) {
		this.COMP_WDU_AVBL_UNIT = COMP_WDU_AVBL_UNIT;
	}

	public HtmlOutputLabel getCOMP_WDU_AVBL_FC_AMT_LABEL() {
		return COMP_WDU_AVBL_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WDU_AVBL_FC_AMT() {
		return COMP_WDU_AVBL_FC_AMT;
	}

	public void setCOMP_WDU_AVBL_FC_AMT_LABEL(HtmlOutputLabel COMP_WDU_AVBL_FC_AMT_LABEL) {
		this.COMP_WDU_AVBL_FC_AMT_LABEL = COMP_WDU_AVBL_FC_AMT_LABEL;
	}

	public void setCOMP_WDU_AVBL_FC_AMT(HtmlInputText COMP_WDU_AVBL_FC_AMT) {
		this.COMP_WDU_AVBL_FC_AMT = COMP_WDU_AVBL_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_WDU_AVBL_LC_AMT_LABEL() {
		return COMP_WDU_AVBL_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WDU_AVBL_LC_AMT() {
		return COMP_WDU_AVBL_LC_AMT;
	}

	public void setCOMP_WDU_AVBL_LC_AMT_LABEL(HtmlOutputLabel COMP_WDU_AVBL_LC_AMT_LABEL) {
		this.COMP_WDU_AVBL_LC_AMT_LABEL = COMP_WDU_AVBL_LC_AMT_LABEL;
	}

	public void setCOMP_WDU_AVBL_LC_AMT(HtmlInputText COMP_WDU_AVBL_LC_AMT) {
		this.COMP_WDU_AVBL_LC_AMT = COMP_WDU_AVBL_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_WDU_WD_UNIT_LABEL() {
		return COMP_WDU_WD_UNIT_LABEL;
	}

	public HtmlInputText getCOMP_WDU_WD_UNIT() {
		return COMP_WDU_WD_UNIT;
	}

	public void setCOMP_WDU_WD_UNIT_LABEL(HtmlOutputLabel COMP_WDU_WD_UNIT_LABEL) {
		this.COMP_WDU_WD_UNIT_LABEL = COMP_WDU_WD_UNIT_LABEL;
	}

	public void setCOMP_WDU_WD_UNIT(HtmlInputText COMP_WDU_WD_UNIT) {
		this.COMP_WDU_WD_UNIT = COMP_WDU_WD_UNIT;
	}

	public HtmlOutputLabel getCOMP_WDU_WD_FC_AMT_LABEL() {
		return COMP_WDU_WD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WDU_WD_FC_AMT() {
		return COMP_WDU_WD_FC_AMT;
	}

	public void setCOMP_WDU_WD_FC_AMT_LABEL(HtmlOutputLabel COMP_WDU_WD_FC_AMT_LABEL) {
		this.COMP_WDU_WD_FC_AMT_LABEL = COMP_WDU_WD_FC_AMT_LABEL;
	}

	public void setCOMP_WDU_WD_FC_AMT(HtmlInputText COMP_WDU_WD_FC_AMT) {
		this.COMP_WDU_WD_FC_AMT = COMP_WDU_WD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_WDU_WD_LC_AMT_LABEL() {
		return COMP_WDU_WD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WDU_WD_LC_AMT() {
		return COMP_WDU_WD_LC_AMT;
	}

	public void setCOMP_WDU_WD_LC_AMT_LABEL(HtmlOutputLabel COMP_WDU_WD_LC_AMT_LABEL) {
		this.COMP_WDU_WD_LC_AMT_LABEL = COMP_WDU_WD_LC_AMT_LABEL;
	}

	public void setCOMP_WDU_WD_LC_AMT(HtmlInputText COMP_WDU_WD_LC_AMT) {
		this.COMP_WDU_WD_LC_AMT = COMP_WDU_WD_LC_AMT;
	}

	public PT_IL_WITHDRAWAL_UNIT getPT_IL_WITHDRAWAL_UNIT_BEAN() {
		return PT_IL_WITHDRAWAL_UNIT_BEAN;
	}

	public void setPT_IL_WITHDRAWAL_UNIT_BEAN(PT_IL_WITHDRAWAL_UNIT PT_IL_WITHDRAWAL_UNIT_BEAN) {
		this.PT_IL_WITHDRAWAL_UNIT_BEAN = PT_IL_WITHDRAWAL_UNIT_BEAN;
	}

	public List<PT_IL_WITHDRAWAL_UNIT> getDataList_PT_IL_WITHDRAWAL_UNIT() {
		return dataList_PT_IL_WITHDRAWAL_UNIT;
	}

	public void setDataListPT_IL_WITHDRAWAL_UNIT(List<PT_IL_WITHDRAWAL_UNIT> dataList_PT_IL_WITHDRAWAL_UNIT) {
		this.dataList_PT_IL_WITHDRAWAL_UNIT = dataList_PT_IL_WITHDRAWAL_UNIT;
	}

	public void addRow(ActionEvent event){
		try{
			if (isINSERT_ALLOWED()){

				PT_IL_WITHDRAWAL_UNIT_BEAN = new PT_IL_WITHDRAWAL_UNIT();
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

				new CRUDHandler().executeDelete(PT_IL_WITHDRAWAL_UNIT_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				dataList_PT_IL_WITHDRAWAL_UNIT.remove(PT_IL_WITHDRAWAL_UNIT_BEAN);
				if(dataList_PT_IL_WITHDRAWAL_UNIT.size()>0){

					PT_IL_WITHDRAWAL_UNIT_BEAN=dataList_PT_IL_WITHDRAWAL_UNIT.get(0);
				}else if(dataList_PT_IL_WITHDRAWAL_UNIT.size()==0){

					addRow(null);
				}

				resetAllComponent();
				PT_IL_WITHDRAWAL_UNIT_BEAN.setRowSelected(true);
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
		CommonUtils.clearMaps(this);
		try{
			if(PT_IL_WITHDRAWAL_UNIT_BEAN.getROWID()==null && isINSERT_ALLOWED()){

				helper.preInsert(PT_IL_WITHDRAWAL_UNIT_BEAN,compositeAction);
				new CRUDHandler().executeInsert(PT_IL_WITHDRAWAL_UNIT_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				dataList_PT_IL_WITHDRAWAL_UNIT.add(PT_IL_WITHDRAWAL_UNIT_BEAN);
			}else if(PT_IL_WITHDRAWAL_UNIT_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){

				new CRUDHandler().executeUpdate(PT_IL_WITHDRAWAL_UNIT_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			}

			PT_IL_WITHDRAWAL_UNIT_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}

	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);try{
			resetSelectedRow();
			PT_IL_WITHDRAWAL_UNIT_BEAN = (PT_IL_WITHDRAWAL_UNIT)dataTable.getRowData();
			PT_IL_WITHDRAWAL_UNIT_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}

	}

	private void resetSelectedRow(){
		Iterator<PT_IL_WITHDRAWAL_UNIT> PT_IL_WITHDRAWAL_UNIT_ITR = dataList_PT_IL_WITHDRAWAL_UNIT.iterator();while (PT_IL_WITHDRAWAL_UNIT_ITR.hasNext()) {
			PT_IL_WITHDRAWAL_UNIT_ITR.next().setRowSelected(false);}
	}

	private void resetAllComponent(){
		COMP_UI_M_WDU_POL_NO.resetValue();
		COMP_WDU_COVER_CODE.resetValue();
		COMP_WDU_TYPE.resetValue();
		COMP_WDU_AVBL_UNIT.resetValue();
		COMP_WDU_AVBL_FC_AMT.resetValue();
		COMP_WDU_AVBL_LC_AMT.resetValue();
		COMP_WDU_WD_UNIT.resetValue();
		COMP_WDU_WD_FC_AMT.resetValue();
		COMP_WDU_WD_LC_AMT.resetValue();
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


	public List<SelectItem> getListWDU_TYPE() {
		if (listWDU_TYPE.size() == 0) {
			listWDU_TYPE.clear();
			try {
				listWDU_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listWDU_TYPE;
	}

	public void setListWDU_TYPE(List<SelectItem> listWDU_TYPE) {
		this.listWDU_TYPE = listWDU_TYPE;
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
	public void validateWDU_WD_FC_AMT(FacesContext context, UIComponent component, Object value) {
		DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		try {
			helper.WHEN_VALIDATE_WDU_WD_FC_AMT(PT_IL_WITHDRAWAL_UNIT_BEAN, 
					dummy.getUI_M_POL_CUST_EXCH_RATE(), (Double)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("FC_AMT",e.getMessage());
		}
	}
	public void validateWDU_WD_UNIT(FacesContext context, UIComponent component, Object value) {
		DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		try {
			PT_IL_WITHDRAWAL_UNIT_BEAN.setWDU_WD_UNIT((Double)value);
			helper.WHEN_VALIDATE_WDU_WD_UNIT(PT_IL_WITHDRAWAL_UNIT_BEAN, 
					dummy.getUI_M_POL_CUST_EXCH_RATE(), (Double)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("FC_AMT",e.getMessage());
		}
	}
}
