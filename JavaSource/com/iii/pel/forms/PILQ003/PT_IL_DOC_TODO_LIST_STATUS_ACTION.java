package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_DOC_TODO_LIST_STATUS_ACTION extends CommonAction {

   // private static final Log log=LogFactory.getLog( PT_IL_DOC_TODO_LIST_STATUS_ACTION.class); 
    
    private HtmlOutputLabel COMP_DTLS_SR_NO_LABEL;

    private HtmlInputText COMP_DTLS_SR_NO;

    private HtmlOutputLabel COMP_DTLS_TODO_LIST_ITEM_LABEL;

    private HtmlInputText COMP_DTLS_TODO_LIST_ITEM;

    private HtmlOutputLabel COMP_DTLS_MANDATORY_YN_LABEL;

    private HtmlSelectOneMenu COMP_DTLS_MANDATORY_YN;

    private HtmlOutputLabel COMP_DTLS_APPR_STS_LABEL;

    private HtmlSelectOneMenu COMP_DTLS_APPR_STS;

    private HtmlOutputLabel COMP_DTLS_DOC_REC_DT_LABEL;

    private HtmlCalendar COMP_DTLS_DOC_REC_DT;

    private HtmlOutputLabel COMP_DTLS_REMARKS_LABEL;

    private HtmlInputText COMP_DTLS_REMARKS;
    
    private HtmlCommandButton COMP_UI_M_BUT_CHK_LIST;

    private PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN;

    public PILQ003_COMPOSITE_ACTION compositeAction;

    private PT_IL_DOC_TODO_LIST_STATUS_HELPER helper;

    private List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS = new ArrayList<PT_IL_DOC_TODO_LIST_STATUS>();

    private UIData dataTable;

    private List<SelectItem> listDTLS_MANDATORY_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listDTLS_APPR_STS = new ArrayList<SelectItem>();

    public PT_IL_DOC_TODO_LIST_STATUS_ACTION() {

	PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
	helper = new PT_IL_DOC_TODO_LIST_STATUS_HELPER();
	instantiateAllComponent();
	preparDropDownList();
    }

    public HtmlOutputLabel getCOMP_DTLS_SR_NO_LABEL() {
	return COMP_DTLS_SR_NO_LABEL;
    }

    public void setCOMP_DTLS_SR_NO_LABEL(HtmlOutputLabel comp_dtls_sr_no_label) {
	COMP_DTLS_SR_NO_LABEL = comp_dtls_sr_no_label;
    }

    public HtmlInputText getCOMP_DTLS_SR_NO() {
	return COMP_DTLS_SR_NO;
    }

    public void setCOMP_DTLS_SR_NO(HtmlInputText comp_dtls_sr_no) {
	COMP_DTLS_SR_NO = comp_dtls_sr_no;
    }

    public HtmlOutputLabel getCOMP_DTLS_TODO_LIST_ITEM_LABEL() {
	return COMP_DTLS_TODO_LIST_ITEM_LABEL;
    }

    public void setCOMP_DTLS_TODO_LIST_ITEM_LABEL(
	    HtmlOutputLabel comp_dtls_todo_list_item_label) {
	COMP_DTLS_TODO_LIST_ITEM_LABEL = comp_dtls_todo_list_item_label;
    }

    public HtmlInputText getCOMP_DTLS_TODO_LIST_ITEM() {
	return COMP_DTLS_TODO_LIST_ITEM;
    }

    public void setCOMP_DTLS_TODO_LIST_ITEM(
	    HtmlInputText comp_dtls_todo_list_item) {
	COMP_DTLS_TODO_LIST_ITEM = comp_dtls_todo_list_item;
    }

    public HtmlOutputLabel getCOMP_DTLS_MANDATORY_YN_LABEL() {
	return COMP_DTLS_MANDATORY_YN_LABEL;
    }

    public void setCOMP_DTLS_MANDATORY_YN_LABEL(
	    HtmlOutputLabel comp_dtls_mandatory_yn_label) {
	COMP_DTLS_MANDATORY_YN_LABEL = comp_dtls_mandatory_yn_label;
    }

    public HtmlSelectOneMenu getCOMP_DTLS_MANDATORY_YN() {
	return COMP_DTLS_MANDATORY_YN;
    }

    public void setCOMP_DTLS_MANDATORY_YN(
	    HtmlSelectOneMenu comp_dtls_mandatory_yn) {
	COMP_DTLS_MANDATORY_YN = comp_dtls_mandatory_yn;
    }

    public HtmlOutputLabel getCOMP_DTLS_APPR_STS_LABEL() {
	return COMP_DTLS_APPR_STS_LABEL;
    }

    public void setCOMP_DTLS_APPR_STS_LABEL(
	    HtmlOutputLabel comp_dtls_appr_sts_label) {
	COMP_DTLS_APPR_STS_LABEL = comp_dtls_appr_sts_label;
    }

    public HtmlSelectOneMenu getCOMP_DTLS_APPR_STS() {
	return COMP_DTLS_APPR_STS;
    }

    public void setCOMP_DTLS_APPR_STS(HtmlSelectOneMenu comp_dtls_appr_sts) {
	COMP_DTLS_APPR_STS = comp_dtls_appr_sts;
    }

    public HtmlOutputLabel getCOMP_DTLS_DOC_REC_DT_LABEL() {
	return COMP_DTLS_DOC_REC_DT_LABEL;
    }

    public void setCOMP_DTLS_DOC_REC_DT_LABEL(
	    HtmlOutputLabel comp_dtls_doc_rec_dt_label) {
	COMP_DTLS_DOC_REC_DT_LABEL = comp_dtls_doc_rec_dt_label;
    }

    public HtmlCalendar getCOMP_DTLS_DOC_REC_DT() {
	return COMP_DTLS_DOC_REC_DT;
    }

    public void setCOMP_DTLS_DOC_REC_DT(HtmlCalendar comp_dtls_doc_rec_dt) {
	COMP_DTLS_DOC_REC_DT = comp_dtls_doc_rec_dt;
    }

    public HtmlOutputLabel getCOMP_DTLS_REMARKS_LABEL() {
	return COMP_DTLS_REMARKS_LABEL;
    }

    public void setCOMP_DTLS_REMARKS_LABEL(
	    HtmlOutputLabel comp_dtls_remarks_label) {
	COMP_DTLS_REMARKS_LABEL = comp_dtls_remarks_label;
    }

    public HtmlInputText getCOMP_DTLS_REMARKS() {
	return COMP_DTLS_REMARKS;
    }

    public void setCOMP_DTLS_REMARKS(HtmlInputText comp_dtls_remarks) {
	COMP_DTLS_REMARKS = comp_dtls_remarks;
    }

    public void setDataList_PT_IL_DOC_TODO_LIST_STATUS(
	    List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS) {
	this.dataList_PT_IL_DOC_TODO_LIST_STATUS = dataList_PT_IL_DOC_TODO_LIST_STATUS;
    }

    public PT_IL_DOC_TODO_LIST_STATUS getPT_IL_DOC_TODO_LIST_STATUS_BEAN() {
	return PT_IL_DOC_TODO_LIST_STATUS_BEAN;
    }

    public void setPT_IL_DOC_TODO_LIST_STATUS_BEAN(
	    PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN) {
	this.PT_IL_DOC_TODO_LIST_STATUS_BEAN = PT_IL_DOC_TODO_LIST_STATUS_BEAN;
    }

    public List<PT_IL_DOC_TODO_LIST_STATUS> getDataList_PT_IL_DOC_TODO_LIST_STATUS() {
	return dataList_PT_IL_DOC_TODO_LIST_STATUS;
    }

    public void setDataListPT_IL_DOC_TODO_LIST_STATUS(
	    List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS) {
	this.dataList_PT_IL_DOC_TODO_LIST_STATUS = dataList_PT_IL_DOC_TODO_LIST_STATUS;
    }

    public void addRow(ActionEvent event) {
    	String message =  null;
	try {
		getErrorMap().clear();
		getWarningMap().clear();
	    if (isINSERT_ALLOWED()) {
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
		helper.whenCreateRecord(compositeAction);
		resetAllComponent();
		resetSelectedRow();
	    } else {
	    message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"); 
		getErrorMap().put("addRow",message);
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
	    }
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
	    getErrorMap().put("addRow", exc.getMessage());
	}

    }

    public void deleteRow(ActionEvent event) {
	String message  = null;
    	
    	try {
	    if (isDELETE_ALLOWED()) {
			    	helper.keyDelrec(compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN());
			    	new CRUDHandler().executeDelete(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
			    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
			    	getWarningMap().put("deleteRow",message);
			    	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			    	dataList_PT_IL_DOC_TODO_LIST_STATUS.remove(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			    	if (dataList_PT_IL_DOC_TODO_LIST_STATUS.size() > 0) {
			    			PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList_PT_IL_DOC_TODO_LIST_STATUS.get(0);
			    	} else if (dataList_PT_IL_DOC_TODO_LIST_STATUS.size() == 0) {
			    			addRow(null);
			    	}
			    	resetAllComponent();
			    	PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
	    } else {
				    message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
				    getErrorMap().put("deleteRow",message);
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
	    }

	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
	    getErrorMap().put("deleteRow", exc.getMessage());
	}

    }

    public void postRecord(ActionEvent event) {
    	String message = null; 
	try {
	    if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
		    helper.preInsert(compositeAction);
			new CRUDHandler().executeInsert(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"); 
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			dataList_PT_IL_DOC_TODO_LIST_STATUS.add(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
	    } else if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
		    helper.preUpdate(compositeAction);
			new CRUDHandler().executeUpdate(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	    }

	    PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    "Record not Inserted/Updated :: " + exc.getMessage());
	    getErrorMap().put("postRecord",
		    "Record not Inserted/Updated :: " + exc.getMessage());
	}

    }

    public void displayRecords() {
	CommonUtils.clearMaps(this);
	try {
	    resetSelectedRow();
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN = (PT_IL_DOC_TODO_LIST_STATUS) dataTable.getRowData();
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}

    }

    private void resetSelectedRow() {
	Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
		.iterator();
	while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
	    PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);
	}
    }

    private void resetAllComponent() {
	COMP_DTLS_SR_NO.resetValue();
	COMP_DTLS_SR_NO.resetValue();
	COMP_DTLS_TODO_LIST_ITEM.resetValue();
	COMP_DTLS_TODO_LIST_ITEM.resetValue();
	COMP_DTLS_MANDATORY_YN.resetValue();
	COMP_DTLS_MANDATORY_YN.resetValue();
	COMP_DTLS_APPR_STS.resetValue();
	COMP_DTLS_APPR_STS.resetValue();
	COMP_DTLS_DOC_REC_DT.resetValue();
	COMP_DTLS_DOC_REC_DT.resetValue();
	COMP_DTLS_REMARKS.resetValue();
	COMP_DTLS_REMARKS.resetValue();
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
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
    }

    public List<SelectItem> getListDTLS_MANDATORY_YN() {
	if (listDTLS_MANDATORY_YN.size() == 0) {
	    listDTLS_MANDATORY_YN.clear();
	    try {
		listDTLS_MANDATORY_YN = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listDTLS_MANDATORY_YN;
    }

    public void setListDTLS_MANDATORY_YN(List<SelectItem> listDTLS_MANDATORY_YN) {
	this.listDTLS_MANDATORY_YN = listDTLS_MANDATORY_YN;
    }

    public List<SelectItem> getListDTLS_APPR_STS() {
	if (listDTLS_APPR_STS.size() == 0) {
	    listDTLS_APPR_STS.clear();
	    try {
		listDTLS_APPR_STS = new ArrayList<SelectItem>();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return listDTLS_APPR_STS;
    }

    public void setListDTLS_APPR_STS(List<SelectItem> listDTLS_APPR_STS) {
	this.listDTLS_APPR_STS = listDTLS_APPR_STS;
    }
     public void preparDropDownList(){
    	 Connection connection = null;
    	 try{
    	 connection = CommonUtils.getConnection();
    	 listDTLS_MANDATORY_YN = ListItemUtil.getDropDownListValue(
    			    connection, "PILT002_APAC", "PT_IL_DOC_TODO_LIST_STATUS",
    			    "PT_IL_DOC_TODO_LIST_STATUS.DTLS_MANDATORY_YN", "YESNO");
    	 listDTLS_APPR_STS = ListItemUtil.getDropDownListValue(
 			    connection, "PILT002_APAC", "PT_IL_DOC_TODO_LIST_STATUS",
			    "PT_IL_DOC_TODO_LIST_STATUS.DTLS_APPR_STS", "CHKLST_STS");
    			    
    	 }catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
    	 
     }

    public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }

    public void onLoad(PhaseEvent event) {
	try {
	    if (isBlockFlag()) {
	    helper.whenNewBlockInstance(compositeAction);
		helper.preQuery(compositeAction);
		helper.executeQuery(compositeAction);
		if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() ==null){
		 helper.whenCreateRecord(compositeAction);   
		}
		setBlockFlag(false);
	    }
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public void validateDTLS_SR_NO_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component,Object value){
    	try{
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SR_NO((Double)value);
    		helper.DTLS_SR_NO_WHEN_VALIDATE_ITEM(compositeAction);
    	}catch(Exception e){
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }
    
    public void validateDTLS_APPR_STS_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component,Object value){
    	try{
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS((String)value);
    		helper.DTLS_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
    	}catch(Exception e){
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_DOC_TODO_LIST_STATUS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_DOC_TODO_LIST_STATUS_HELPER helper) {
		this.helper = helper;
	}

	/*public static Log getLog() {
		return log;
	}
	*/

	/**
	 * Disables all components in PT_IL_DOC_TODO_LIST_STATUS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_DTLS_SR_NO.setDisabled(disabled);
		COMP_DTLS_TODO_LIST_ITEM.setDisabled(disabled);
		COMP_DTLS_REMARKS.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_DTLS_MANDATORY_YN.setDisabled(disabled);
		COMP_DTLS_APPR_STS.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_DTLS_DOC_REC_DT.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_DOC_TODO_LIST_STATUS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DTLS_SR_NO					 = new HtmlInputText();
		COMP_DTLS_TODO_LIST_ITEM			 = new HtmlInputText();
		COMP_DTLS_REMARKS				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_DTLS_SR_NO_LABEL				 = new HtmlOutputLabel();
		COMP_DTLS_TODO_LIST_ITEM_LABEL			 = new HtmlOutputLabel();
		COMP_DTLS_MANDATORY_YN_LABEL			 = new HtmlOutputLabel();
		COMP_DTLS_APPR_STS_LABEL			 = new HtmlOutputLabel();
		COMP_DTLS_DOC_REC_DT_LABEL			 = new HtmlOutputLabel();
		COMP_DTLS_REMARKS_LABEL				 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_DTLS_MANDATORY_YN				 = new HtmlSelectOneMenu();
		COMP_DTLS_APPR_STS				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_DTLS_DOC_REC_DT				 = new HtmlCalendar();

	}


	public String goToChkList() {
	    
	    return "PILT002_APAC_PM_IL_DOC_TODO_GROUP";
	    
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHK_LIST() {
	    return COMP_UI_M_BUT_CHK_LIST;
	}

	public void setCOMP_UI_M_BUT_CHK_LIST(HtmlCommandButton comp_ui_m_but_chk_list) {
	    COMP_UI_M_BUT_CHK_LIST = comp_ui_m_but_chk_list;
	}
}
