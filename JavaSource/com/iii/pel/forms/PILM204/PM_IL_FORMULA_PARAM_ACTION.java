package com.iii.pel.forms.PILM204;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_FORMULA_PARAM_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FP_SRNO_LABEL;

	private HtmlInputText COMP_FP_SRNO;

	private HtmlOutputLabel COMP_FP_CAPTION_LABEL;

	private HtmlInputText COMP_FP_CAPTION;

	private HtmlOutputLabel COMP_FP_BL_CAPTION_LABEL;

	private HtmlInputText COMP_FP_BL_CAPTION;

	private HtmlOutputLabel COMP_FP_DATA_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_FP_DATA_TYPE;

	private HtmlOutputLabel COMP_FP_TABLE_NAME_LABEL;

	private HtmlInputText COMP_FP_TABLE_NAME;

	private HtmlOutputLabel COMP_FP_COL_NAME_LABEL;

	private HtmlInputText COMP_FP_COL_NAME;

	private HtmlOutputLabel COMP_FP_WHERE_CLAUSE_LABEL;

	private HtmlInputText COMP_FP_WHERE_CLAUSE;

	private HtmlCommandButton COMP_UI_M_BUT_TRF_HEAD;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_TBNAME;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_COLNAME;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_WHRCLAUSE;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_CAP;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_BL_CAP;

	private PM_IL_FORMULA_PARAM PM_IL_FORMULA_PARAM_BEAN;

	public PM_IL_FORMULA_COMPOSITEBEAN compositeAction;

	private PM_IL_FORMULA_PARAM_HELPER helper;

	private PM_IL_FORMULA_PARAM_DELEGATE delegate;

	private List<PM_IL_FORMULA_PARAM> dataList_PM_IL_FORMULA_PARAM = new ArrayList<PM_IL_FORMULA_PARAM>();

	private UIData dataTable;

	private List<SelectItem> listFP_DATA_TYPE = new ArrayList<SelectItem>();


	public PM_IL_FORMULA_PARAM_ACTION(){

		PM_IL_FORMULA_PARAM_BEAN = new PM_IL_FORMULA_PARAM();
		helper = new PM_IL_FORMULA_PARAM_HELPER();
		delegate = new PM_IL_FORMULA_PARAM_DELEGATE();
		prepareDropDowns();
	}
	
	
	
	private void prepareDropDowns() {
		try {
			setListFP_DATA_TYPE(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), 
					 "PILM204","PM_IL_FORMULA_PARAM", 
					 "PM_IL_FORMULA_PARAM.FP_DATA_TYPE",
						"IL_DAT_TYP"));
			
		
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_FP_SRNO_LABEL() {
		return COMP_FP_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_FP_SRNO() {
		return COMP_FP_SRNO;
	}

	public void setCOMP_FP_SRNO_LABEL(HtmlOutputLabel COMP_FP_SRNO_LABEL) {
		this.COMP_FP_SRNO_LABEL = COMP_FP_SRNO_LABEL;
	}

	public void setCOMP_FP_SRNO(HtmlInputText COMP_FP_SRNO) {
		this.COMP_FP_SRNO = COMP_FP_SRNO;
	}

	public HtmlOutputLabel getCOMP_FP_CAPTION_LABEL() {
		return COMP_FP_CAPTION_LABEL;
	}

	public HtmlInputText getCOMP_FP_CAPTION() {
		return COMP_FP_CAPTION;
	}

	public void setCOMP_FP_CAPTION_LABEL(HtmlOutputLabel COMP_FP_CAPTION_LABEL) {
		this.COMP_FP_CAPTION_LABEL = COMP_FP_CAPTION_LABEL;
	}

	public void setCOMP_FP_CAPTION(HtmlInputText COMP_FP_CAPTION) {
		this.COMP_FP_CAPTION = COMP_FP_CAPTION;
	}

	public HtmlOutputLabel getCOMP_FP_BL_CAPTION_LABEL() {
		return COMP_FP_BL_CAPTION_LABEL;
	}

	public HtmlInputText getCOMP_FP_BL_CAPTION() {
		return COMP_FP_BL_CAPTION;
	}

	public void setCOMP_FP_BL_CAPTION_LABEL(HtmlOutputLabel COMP_FP_BL_CAPTION_LABEL) {
		this.COMP_FP_BL_CAPTION_LABEL = COMP_FP_BL_CAPTION_LABEL;
	}

	public void setCOMP_FP_BL_CAPTION(HtmlInputText COMP_FP_BL_CAPTION) {
		this.COMP_FP_BL_CAPTION = COMP_FP_BL_CAPTION;
	}

	public HtmlOutputLabel getCOMP_FP_DATA_TYPE_LABEL() {
		return COMP_FP_DATA_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FP_DATA_TYPE() {
		return COMP_FP_DATA_TYPE;
	}

	public void setCOMP_FP_DATA_TYPE_LABEL(HtmlOutputLabel COMP_FP_DATA_TYPE_LABEL) {
		this.COMP_FP_DATA_TYPE_LABEL = COMP_FP_DATA_TYPE_LABEL;
	}

	public void setCOMP_FP_DATA_TYPE(HtmlSelectOneMenu COMP_FP_DATA_TYPE) {
		this.COMP_FP_DATA_TYPE = COMP_FP_DATA_TYPE;
	}

	public HtmlOutputLabel getCOMP_FP_TABLE_NAME_LABEL() {
		return COMP_FP_TABLE_NAME_LABEL;
	}

	public HtmlInputText getCOMP_FP_TABLE_NAME() {
		return COMP_FP_TABLE_NAME;
	}

	public void setCOMP_FP_TABLE_NAME_LABEL(HtmlOutputLabel COMP_FP_TABLE_NAME_LABEL) {
		this.COMP_FP_TABLE_NAME_LABEL = COMP_FP_TABLE_NAME_LABEL;
	}

	public void setCOMP_FP_TABLE_NAME(HtmlInputText COMP_FP_TABLE_NAME) {
		this.COMP_FP_TABLE_NAME = COMP_FP_TABLE_NAME;
	}

	public HtmlOutputLabel getCOMP_FP_COL_NAME_LABEL() {
		return COMP_FP_COL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_FP_COL_NAME() {
		return COMP_FP_COL_NAME;
	}

	public void setCOMP_FP_COL_NAME_LABEL(HtmlOutputLabel COMP_FP_COL_NAME_LABEL) {
		this.COMP_FP_COL_NAME_LABEL = COMP_FP_COL_NAME_LABEL;
	}

	public void setCOMP_FP_COL_NAME(HtmlInputText COMP_FP_COL_NAME) {
		this.COMP_FP_COL_NAME = COMP_FP_COL_NAME;
	}

	public HtmlOutputLabel getCOMP_FP_WHERE_CLAUSE_LABEL() {
		return COMP_FP_WHERE_CLAUSE_LABEL;
	}

	public HtmlInputText getCOMP_FP_WHERE_CLAUSE() {
		return COMP_FP_WHERE_CLAUSE;
	}

	public void setCOMP_FP_WHERE_CLAUSE_LABEL(HtmlOutputLabel COMP_FP_WHERE_CLAUSE_LABEL) {
		this.COMP_FP_WHERE_CLAUSE_LABEL = COMP_FP_WHERE_CLAUSE_LABEL;
	}

	public void setCOMP_FP_WHERE_CLAUSE(HtmlInputText COMP_FP_WHERE_CLAUSE) {
		this.COMP_FP_WHERE_CLAUSE = COMP_FP_WHERE_CLAUSE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TRF_HEAD() {
		return COMP_UI_M_BUT_TRF_HEAD;
	}

	public void setCOMP_UI_M_BUT_TRF_HEAD(HtmlCommandButton COMP_UI_M_BUT_TRF_HEAD) {
		this.COMP_UI_M_BUT_TRF_HEAD = COMP_UI_M_BUT_TRF_HEAD;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_TBNAME() {
		return COMP_UI_M_BUT_EDITOR_TBNAME;
	}

	public void setCOMP_UI_M_BUT_EDITOR_TBNAME(HtmlCommandButton COMP_UI_M_BUT_EDITOR_TBNAME) {
		this.COMP_UI_M_BUT_EDITOR_TBNAME = COMP_UI_M_BUT_EDITOR_TBNAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_COLNAME() {
		return COMP_UI_M_BUT_EDITOR_COLNAME;
	}

	public void setCOMP_UI_M_BUT_EDITOR_COLNAME(HtmlCommandButton COMP_UI_M_BUT_EDITOR_COLNAME) {
		this.COMP_UI_M_BUT_EDITOR_COLNAME = COMP_UI_M_BUT_EDITOR_COLNAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_WHRCLAUSE() {
		return COMP_UI_M_BUT_EDITOR_WHRCLAUSE;
	}

	public void setCOMP_UI_M_BUT_EDITOR_WHRCLAUSE(HtmlCommandButton COMP_UI_M_BUT_EDITOR_WHRCLAUSE) {
		this.COMP_UI_M_BUT_EDITOR_WHRCLAUSE = COMP_UI_M_BUT_EDITOR_WHRCLAUSE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_CAP() {
		return COMP_UI_M_BUT_EDITOR_CAP;
	}

	public void setCOMP_UI_M_BUT_EDITOR_CAP(HtmlCommandButton COMP_UI_M_BUT_EDITOR_CAP) {
		this.COMP_UI_M_BUT_EDITOR_CAP = COMP_UI_M_BUT_EDITOR_CAP;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_BL_CAP() {
		return COMP_UI_M_BUT_EDITOR_BL_CAP;
	}

	public void setCOMP_UI_M_BUT_EDITOR_BL_CAP(HtmlCommandButton COMP_UI_M_BUT_EDITOR_BL_CAP) {
		this.COMP_UI_M_BUT_EDITOR_BL_CAP = COMP_UI_M_BUT_EDITOR_BL_CAP;
	}

	public PM_IL_FORMULA_PARAM getPM_IL_FORMULA_PARAM_BEAN() {
		return PM_IL_FORMULA_PARAM_BEAN;
	}

	public void setPM_IL_FORMULA_PARAM_BEAN(PM_IL_FORMULA_PARAM PM_IL_FORMULA_PARAM_BEAN) {
		this.PM_IL_FORMULA_PARAM_BEAN = PM_IL_FORMULA_PARAM_BEAN;
	}

	public List<PM_IL_FORMULA_PARAM> getDataList_PM_IL_FORMULA_PARAM() {
		return dataList_PM_IL_FORMULA_PARAM;
	}

	public void setDataListPM_IL_FORMULA_PARAM(List<PM_IL_FORMULA_PARAM> dataList_PM_IL_FORMULA_PARAM) {
		this.dataList_PM_IL_FORMULA_PARAM = dataList_PM_IL_FORMULA_PARAM;
	}

	public void addRow(ActionEvent event){
		try{
			int srno = 0;
			if (isINSERT_ALLOWED()){
				srno = delegate.fetchSRNO();
				PM_IL_FORMULA_PARAM_BEAN = new PM_IL_FORMULA_PARAM();
				helper.WHEN_CREATE_RECORD(PM_IL_FORMULA_PARAM_BEAN);
				PM_IL_FORMULA_PARAM_BEAN.setFP_SRNO(++srno);
				resetAllComponent();
				resetSelectedRow();
			}else{
				getErrorMap().put("addRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
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
				helper.key_delrec(PM_IL_FORMULA_PARAM_BEAN);
				new CRUDHandler().executeDelete(PM_IL_FORMULA_PARAM_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				dataList_PM_IL_FORMULA_PARAM.remove(PM_IL_FORMULA_PARAM_BEAN);
				CommonUtils.getConnection().commit();
				if(dataList_PM_IL_FORMULA_PARAM.size()>0){

					PM_IL_FORMULA_PARAM_BEAN=dataList_PM_IL_FORMULA_PARAM.get(0);
				}else if(dataList_PM_IL_FORMULA_PARAM.size()==0){
					addRow(event);
				}
				resetAllComponent();
				PM_IL_FORMULA_PARAM_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
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
		try{
			if(PM_IL_FORMULA_PARAM_BEAN.getROWID()==null && isINSERT_ALLOWED()){
				helper.preInsert(PM_IL_FORMULA_PARAM_BEAN);
				new CRUDHandler().executeInsert(PM_IL_FORMULA_PARAM_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.
						pelMessagePropertiesPath,"errorPanel$message$insert"));
				dataList_PM_IL_FORMULA_PARAM.add(PM_IL_FORMULA_PARAM_BEAN);
			}else if(PM_IL_FORMULA_PARAM_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){
				helper.preUpdate(PM_IL_FORMULA_PARAM_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_FORMULA_PARAM_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.
						pelMessagePropertiesPath,"errorPanel$message$update"));
			}
			PM_IL_FORMULA_PARAM_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}
	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);
		try{
			resetSelectedRow();
			PM_IL_FORMULA_PARAM_BEAN = (PM_IL_FORMULA_PARAM)dataTable.getRowData();
			PM_IL_FORMULA_PARAM_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}
	}

	private void resetSelectedRow(){
		Iterator<PM_IL_FORMULA_PARAM> PM_IL_FORMULA_PARAM_ITR = dataList_PM_IL_FORMULA_PARAM.iterator();
		while (PM_IL_FORMULA_PARAM_ITR.hasNext()) {
			PM_IL_FORMULA_PARAM_ITR.next().setRowSelected(false);}
	}

	private void resetAllComponent(){
		COMP_FP_SRNO.resetValue();
		COMP_FP_CAPTION.resetValue();
		COMP_FP_BL_CAPTION.resetValue();
		COMP_FP_DATA_TYPE.resetValue();
		COMP_FP_TABLE_NAME.resetValue();
		COMP_FP_COL_NAME.resetValue();
		COMP_FP_WHERE_CLAUSE.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}


	
	public PM_IL_FORMULA_COMPOSITEBEAN getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PM_IL_FORMULA_COMPOSITEBEAN compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_FORMULA_PARAM_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_FORMULA_PARAM_HELPER helper) {
		this.helper = helper;
	}

	public PM_IL_FORMULA_PARAM_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PM_IL_FORMULA_PARAM_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public List<SelectItem> getListFP_DATA_TYPE() {
		return listFP_DATA_TYPE;
	}

	public void setListFP_DATA_TYPE(List<SelectItem> listFP_DATA_TYPE) {
		this.listFP_DATA_TYPE = listFP_DATA_TYPE;
	}

	public void setDataList_PM_IL_FORMULA_PARAM(
			List<PM_IL_FORMULA_PARAM> dataList_PM_IL_FORMULA_PARAM) {
		this.dataList_PM_IL_FORMULA_PARAM = dataList_PM_IL_FORMULA_PARAM;
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

	public void whenValidateTP_SRNO(ActionEvent e){
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput)e.getComponent().getParent();
		String value = (String)input.getSubmittedValue(); 
		PM_IL_FORMULA_PARAM_BEAN.setFP_SRNO(CommonUtils.parseToInt(value));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateTP_SRNO(FacesContext context, UIComponent component,Object value) throws Exception{
		if((Integer)value<=0){
			throw new ValidatorException(Messages.getMessage(
					PELConstants .pelErrorMessagePath, "91003"));
		}
	}
	
	public String goMain(){
		return "PILM204_PM_IL_FORMULA_NEW";
	}
}
