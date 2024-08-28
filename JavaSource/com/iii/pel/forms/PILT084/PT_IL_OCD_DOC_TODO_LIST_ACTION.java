package com.iii.pel.forms.PILT084;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.fileupload.PM_IL_IMAGES;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_OCD_DOC_TODO_LIST_ACTION extends CommonAction {

   // private static final Log log=LogFactory.getLog( PT_IL_OCD_DOC_TODO_LIST_ACTION.class); 
    
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

    //private PT_IL_OCD_DOC_TODO_LIST PT_IL_OCD_DOC_TODO_LIST_BEAN;
    
    private PT_IL_OCD_DOC_TODO_LIST PT_IL_OCD_DOC_TODO_LIST_BEAN;

    public PILT084_COMPOSITE_ACTION_BEAN compositeAction;

    private PT_IL_OCD_DOC_TODO_LIST_HELPER helper;

    private List<PT_IL_OCD_DOC_TODO_LIST> dataList_PT_IL_OCD_DOC_TODO_LIST = new ArrayList<PT_IL_OCD_DOC_TODO_LIST>();

    private UIData dataTable;

    private List<SelectItem> listDTLS_MANDATORY_YN = new ArrayList<SelectItem>();

    private List<SelectItem> listDTLS_APPR_STS = new ArrayList<SelectItem>();

    public PT_IL_OCD_DOC_TODO_LIST_ACTION() {

	PT_IL_OCD_DOC_TODO_LIST_BEAN = new PT_IL_OCD_DOC_TODO_LIST();
	helper = new PT_IL_OCD_DOC_TODO_LIST_HELPER();
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

    /*Changed by Ram on 10/11/2016 for Editable Datagrid*/
    public HtmlInputText getCOMP_DTLS_REMARKS() {
	return COMP_DTLS_REMARKS;
    }

    public void setCOMP_DTLS_REMARKS(HtmlInputText comp_dtls_remarks) {
	COMP_DTLS_REMARKS = comp_dtls_remarks;
    }
/*End*/
    public void setDataList_PT_IL_OCD_DOC_TODO_LIST(
	    List<PT_IL_OCD_DOC_TODO_LIST> dataList_PT_IL_OCD_DOC_TODO_LIST) {
	this.dataList_PT_IL_OCD_DOC_TODO_LIST = dataList_PT_IL_OCD_DOC_TODO_LIST;
    }

    public PT_IL_OCD_DOC_TODO_LIST getPT_IL_OCD_DOC_TODO_LIST_BEAN() {
	return PT_IL_OCD_DOC_TODO_LIST_BEAN;
    }

    public void setPT_IL_OCD_DOC_TODO_LIST_BEAN(
	    PT_IL_OCD_DOC_TODO_LIST PT_IL_OCD_DOC_TODO_LIST_BEAN) {
	this.PT_IL_OCD_DOC_TODO_LIST_BEAN = PT_IL_OCD_DOC_TODO_LIST_BEAN;
    }

    public List<PT_IL_OCD_DOC_TODO_LIST> getDataList_PT_IL_OCD_DOC_TODO_LIST() {
	return dataList_PT_IL_OCD_DOC_TODO_LIST;
    }

    public void setDataListPT_IL_OCD_DOC_TODO_LIST(
	    List<PT_IL_OCD_DOC_TODO_LIST> dataList_PT_IL_OCD_DOC_TODO_LIST) {
	this.dataList_PT_IL_OCD_DOC_TODO_LIST = dataList_PT_IL_OCD_DOC_TODO_LIST;
    }
    
   //end
    
    
    
    
    public void addRow(ActionEvent event) {
    	String message =  null;
	try {
		getErrorMap().clear();
		getWarningMap().clear();
		resetAllComponent();
	    if (isINSERT_ALLOWED()) {
	    	COMP_DTLS_SR_NO.setDisabled(false);
	    	COMP_DTLS_TODO_LIST_ITEM.setDisabled(false);
	    	COMP_DTLS_DOC_REC_DT.setDisabled(false);
	    	COMP_DTLS_REMARKS.setDisabled(false);
	    	COMP_DTLS_MANDATORY_YN.setDisabled(false);
	    PT_IL_OCD_DOC_TODO_LIST_BEAN = new PT_IL_OCD_DOC_TODO_LIST();
		helper.whenCreateRecord(compositeAction);
		resetRowAtCreate();
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
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
			    	helper.keyDelrec(compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN().getPT_IL_OCD_DOC_TODO_LIST_BEAN());
			    	new CRUDHandler().executeDelete(PT_IL_OCD_DOC_TODO_LIST_BEAN, CommonUtils.getConnection());
			    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
			    	getWarningMap().put("deleteRow",message);
			    	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			    	dataList_PT_IL_OCD_DOC_TODO_LIST.remove(PT_IL_OCD_DOC_TODO_LIST_BEAN);
			    	if (dataList_PT_IL_OCD_DOC_TODO_LIST.size() > 0) {
			    			PT_IL_OCD_DOC_TODO_LIST_BEAN = dataList_PT_IL_OCD_DOC_TODO_LIST.get(0);
			    	} else if (dataList_PT_IL_OCD_DOC_TODO_LIST.size() == 0) {
			    			addRow(null);
			    	}
			    	resetAllComponent();
			    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setRowSelected(true);
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

    public void postRecord() {
    	String message = null; 
	try {
	    if (PT_IL_OCD_DOC_TODO_LIST_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
		    helper.preInsert(compositeAction);
		    COMP_DTLS_SR_NO.setDisabled(true);
	    	COMP_DTLS_TODO_LIST_ITEM.setDisabled(true);
	    	COMP_DTLS_DOC_REC_DT.setDisabled(true);
	    	COMP_DTLS_REMARKS.setDisabled(true);
	    	COMP_DTLS_MANDATORY_YN.setDisabled(true);
			new CRUDHandler().executeInsert(PT_IL_OCD_DOC_TODO_LIST_BEAN, CommonUtils.getConnection());
			dataList_PT_IL_OCD_DOC_TODO_LIST.add(PT_IL_OCD_DOC_TODO_LIST_BEAN);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"); 
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			
	    } else if (PT_IL_OCD_DOC_TODO_LIST_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
	    	
	    	
	    	/*Added by Ram on 31/03/2017 for Update All Functionality*/
			if(PT_IL_OCD_DOC_TODO_LIST_BEAN.isUPDATE_ALL())
			{
				//Comment and Modified by rakesh on 03-04-2020 for multiple page records not saved issue
				/*CommonUtils.updateAllRecords(dataList_PT_IL_OCD_DOC_TODO_LIST, PT_IL_OCD_DOC_TODO_LIST_BEAN.getStartIndex(), PT_IL_OCD_DOC_TODO_LIST_BEAN.getEndindex());*/
				CommonUtils.updateAllRecords(dataList_PT_IL_OCD_DOC_TODO_LIST, PT_IL_OCD_DOC_TODO_LIST_BEAN.getStartIndex(), dataList_PT_IL_OCD_DOC_TODO_LIST.size());
				//END
				
				/*Added by Ram on 17/04/2017*/
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				/*End*/
			}
			else
			{
			/*End*/
		    helper.preUpdate(compositeAction);
			new CRUDHandler().executeUpdate(PT_IL_OCD_DOC_TODO_LIST_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			
			}
			
			/*String autoUW = "N";
			ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
												new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			if(rs.next()){
				autoUW = rs.getString("PROD_AUTO_UW");
			}
			if("Y".equalsIgnoreCase(autoUW)){
				
				
				
				String mergeQry = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_POL_SYS_ID = ? AND DTLS_MANDATORY_YN = 'Y' AND DTLS_APPR_STS = 'N' "
									+ "UNION SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND PMED_STATUS = 'N'";
				
				int updateStatus=0;
				ResultSet mergeRS = new CRUDHandler().executeSelectStatement(mergeQry, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
										compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				
				if(mergeRS.next()){
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY  SET POL_ADDL_STATUS = '004' WHERE POL_SYS_ID = ?", 
							CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					
				}else{
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '001' WHERE POL_SYS_ID = ? ", 
							CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				}
				
				if(updateStatus>0){
					CommonUtils.getConnection().commit();
					System.out.println("POL_ADDL_STATUS UPDATED SUCCESSFULLY >>>>>>>>>>>>>>>");
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().onLoad(null);
				}
				
			}*/
			
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	    }
	    
	    PT_IL_OCD_DOC_TODO_LIST_BEAN.setRowSelected(true);
	    CommonUtils.getConnection().commit();
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
	    PT_IL_OCD_DOC_TODO_LIST_BEAN = (PT_IL_OCD_DOC_TODO_LIST) dataTable.getRowData();
	    PT_IL_OCD_DOC_TODO_LIST_BEAN.setRowSelected(true);
	    COMP_DTLS_DOC_REC_DT.setDisabled(true);
	    
	    /*Added by Ram on 16/12/2016 for Policy freeze fields scenario*/
		enableFields();
		/*End*/
		
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}
    }

    /*Added by Ram on 16/12/2016 for Policy freeze fields scenario*/
	private void enableFields()
	{
		if(PT_IL_OCD_DOC_TODO_LIST_BEAN.getRowSelected() != null && PT_IL_OCD_DOC_TODO_LIST_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			if((compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN().getPP_PAYOUT_STATUS() != null && 
					compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN().getPP_PAYOUT_STATUS().equals("S")))
			{
				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
			}
			else
			{
				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
			}
		}
	}
	/*End*/

    private void resetSelectedRow() {
	Iterator<PT_IL_OCD_DOC_TODO_LIST> PT_IL_OCD_DOC_TODO_LIST_ITR = dataList_PT_IL_OCD_DOC_TODO_LIST
		.iterator();
	while (PT_IL_OCD_DOC_TODO_LIST_ITR.hasNext()) {
		
		PT_IL_OCD_DOC_TODO_LIST_BEAN = PT_IL_OCD_DOC_TODO_LIST_ITR.next();
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setRowSelected(false);
	}
    }
    
   /* private void resetSelectedRow() {
    	Iterator<PT_IL_OCD_DOC_TODO_LIST> PT_IL_OCD_DOC_TODO_LIST_ITR = dataList_PT_IL_OCD_DOC_TODO_LIST
    			.iterator();
    		while (PT_IL_OCD_DOC_TODO_LIST_ITR.hasNext()) {
    			PT_IL_OCD_DOC_TODO_LIST_ITR.next().setRowSelected(false);
		}
	}
*/
    public void resetAllComponent() {
    	COMP_DTLS_MANDATORY_YN.resetValue();
    	COMP_DTLS_APPR_STS.resetValue();
    	COMP_DTLS_DOC_REC_DT.resetValue();
    	COMP_DTLS_REMARKS.resetValue();
	COMP_DTLS_SR_NO.resetValue();
	COMP_DTLS_TODO_LIST_ITEM.resetValue();
	
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
    			    connection, "PILT084", "PT_IL_OCD_DOC_TODO_LIST",
    			    "PT_IL_OCD_DOC_TODO_LIST.OCD_DTLS_MANDATORY_YN", "YESNO");
    	 listDTLS_APPR_STS = ListItemUtil.getDropDownListValue(
 			    connection, "PILT084", "PT_IL_OCD_DOC_TODO_LIST",
			    "PT_IL_OCD_DOC_TODO_LIST.OCD_DTLS_APPR_STS", "CHKLST_STS");
    			    
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
		resetAllComponent();
		if (isBlockFlag()) {
	    helper.whenNewBlockInstance(compositeAction);
		helper.preQuery(compositeAction);
		helper.executeQuery(compositeAction);
		if(PT_IL_OCD_DOC_TODO_LIST_BEAN.getROWID() ==null){
		 helper.whenCreateRecord(compositeAction);   
		}
		resetAllComponent();
		
		setBlockFlag(false);
		}	
	} catch (Exception e) {
		e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }

    public void validateDTLS_SR_NO_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component,Object value){
    	try{
    		PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SR_NO((Double)value);
    		helper.DTL_SR_NO_WHEN_VALIDATE_ITEM(compositeAction);
    	}catch(Exception e){
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }
    
    public void validateDTLS_APPR_STS_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component,Object value){
    	try{
    		PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_APPR_STS((String)value);
    		System.out.println("Apprv Sts  :"+PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_APPR_STS());
    		helper.DTL_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
    		
    		/*Added by saranya on 11-04-2017*/
			COMP_DTLS_APPR_STS.resetValue();
			//COMP_DTLS_DOC_REC_DT.resetValue();
		/*End*/
			
    	}catch(Exception e){
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }

	
	public PT_IL_OCD_DOC_TODO_LIST_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_OCD_DOC_TODO_LIST_HELPER helper) {
		this.helper = helper;
	}

	/*public static Log getLog() {
		return log;
	}
	*/

	/**
	 * Disables all components in PT_IL_OCD_DOC_TODO_LIST_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		/*// Disabling HtmlInputText
		COMP_DTLS_SR_NO.setDisabled(disabled);
		COMP_DTLS_TODO_LIST_ITEM.setDisabled(disabled);
		COMP_DTLS_REMARKS.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_DTLS_MANDATORY_YN.setDisabled(disabled);
		COMP_DTLS_APPR_STS.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_DTLS_DOC_REC_DT.setDisabled(disabled);*/
		
		//ADDED by saritha for checklist default selection
		/*Modified by saranya on 11-04-2017
		 * 
		 * COMP_DTLS_SR_NO.setDisabled(true);
		COMP_DTLS_TODO_LIST_ITEM.setDisabled(true);
		COMP_DTLS_REMARKS.setDisabled(true);
		COMP_DTLS_MANDATORY_YN.setDisabled(false);*/
		// Disabling HtmlSelectOneMenu
		COMP_DTLS_MANDATORY_YN.setDisabled(disabled);
		COMP_DTLS_SR_NO.setDisabled(disabled);
		COMP_DTLS_TODO_LIST_ITEM.setDisabled(disabled);
		COMP_DTLS_REMARKS.setDisabled(disabled);
		COMP_DTLS_APPR_STS.setDisabled(disabled);

		/*added by raja on 16-03-2017 for Query screen issue*/
		// Disabling HtmlCalendar
		
		COMP_DTLS_DOC_REC_DT.setDisabled(disabled);

		//end
		
	}

	/**
	 * Instantiates all components in PT_IL_OCD_DOC_TODO_LIST_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DTLS_SR_NO					 = new HtmlInputText();
		COMP_DTLS_TODO_LIST_ITEM			 = new HtmlInputText();
		
		/*Changed by Ram on 10/11/2016 for Editable datagrid*/
		COMP_DTLS_REMARKS				 = new HtmlInputText();
/*End*/
		
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
	
	  public void validateDTLS_DOC_REC_DT(FacesContext context,UIComponent component,Object value){
		 //Added by kavitha on 08.08.2019 for orient
		  Connection con = null;
	  		ResultSet rs1 = null;
	  		CRUDHandler handler = new CRUDHandler();
	  		Date DEF_DATE = null;
		  try{
	    		PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_DOC_REC_DT((Date)value);
	    		if("D".equals(PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_APPR_STS())){
			    		String C1 = "SELECT TRUNC(SYSDATE + NVL(DTL_DEFERRED_DAYS,0)) RECV_DT "
								+ " FROM PT_IL_OCD_DOC_TODO_LIST, PM_IL_DOC_TODO_LIST "
								+ " WHERE DTL_TODO_LIST_ITEM = OCD_DTLS_TODO_LIST_ITEM(+) "
								+ " AND DTL_DS_CODE = 'OCD' "
		                        + " AND OCD_DTLS_POL_SYS_ID = ? ";
						con = CommonUtils.getConnection();
						rs1 = handler.executeSelectStatement(C1, con,
								new Object[] {PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_POL_SYS_ID()});
						while (rs1.next()) {
							DEF_DATE = rs1.getDate("RECV_DT");
						}
						
				    		if(PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_DOC_REC_DT().after(DEF_DATE)){
				    			throw new Exception("Date should be lessthan or equal to Deffered date");
				    		}
				}	 
	    	}catch(Exception e){
	    		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    	}
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
	
	/*Added by Ram on 10/11/2016 for Editable datagrid*/
	public void setDTLS_APPR_STS_Editable(ActionEvent event) {
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Date DEF_DATE = null;
		
		try
		{
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		/*PT_IL_OCD_DOC_TODO_LIST_BEAN=(PT_IL_OCD_DOC_TODO_LIST)dataList_PT_IL_OCD_DOC_TODO_LIST.get(currentIndex);*/
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_APPR_STS(status);
		
		String C1 = "SELECT TRUNC(SYSDATE + NVL(DTL_DEFERRED_DAYS,0)) RECV_DT "
				+ " FROM PT_IL_OCD_DOC_TODO_LIST, PM_IL_DOC_TODO_LIST "
				+ " WHERE DTL_TODO_LIST_ITEM = OCD_DTL_TODO_LIST_ITEM(+) "
				+ "AND DTL_DS_CODE = 'OCD' "
                + " AND OCD_DTL_POL_SYS_ID = ? ";
		con = CommonUtils.getConnection();
		rs1 = handler.executeSelectStatement(C1, con,
				new Object[] {PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_POL_SYS_ID()});
		while (rs1.next()) {
			DEF_DATE = rs1.getDate("RECV_DT");
		}
		System.out.println("status      "+status);
		if(status != null && status.equalsIgnoreCase("Y"))
		{
			PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_DOC_REC_DT(new CommonUtils().getCurrentDate());
			COMP_DTLS_DOC_REC_DT.setDisabled(false);
			COMP_DTLS_DOC_REC_DT_LABEL.setValue(Messages.getString(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
					"PILT002_APAC$PT_IL_OCD_DOC_TODO_LIST$DTLS_DOC_REC_DT$caption"));
		}
		else if(status != null && status.equalsIgnoreCase("D")){
			PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_DOC_REC_DT(DEF_DATE);
			COMP_DTLS_DOC_REC_DT.setDisabled(false);
			COMP_DTLS_DOC_REC_DT_LABEL.setValue(Messages.getString(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
					"PILT002_APAC$PT_IL_OCD_DOC_TODO_LIST$DTLS_DOC_DEF_TILL$caption"));
		}
		else{
			PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_DOC_REC_DT(null);
			COMP_DTLS_DOC_REC_DT.setDisabled(true);
			COMP_DTLS_DOC_REC_DT_LABEL.setValue(Messages.getString(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
					"PILT002_APAC$PT_IL_OCD_DOC_TODO_LIST$DTLS_DOC_REC_DT$caption"));
		}
		COMP_DTLS_DOC_REC_DT.resetValue();
		COMP_DTLS_APPR_STS.resetValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	
	public void setDTLS_REMARKS_Editable(ActionEvent event) {
		CommonUtils.clearMaps(this);
		
		try
		{
		String remarks=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		PT_IL_OCD_DOC_TODO_LIST_BEAN=(PT_IL_OCD_DOC_TODO_LIST)dataList_PT_IL_OCD_DOC_TODO_LIST.get(currentIndex);
		PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_REMARKS(remarks);
		
		/*Added by saranya on 11-04-2017*/
		helper.DTL_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
		/*End*/
		
		COMP_DTLS_APPR_STS.resetValue();
		}
		catch(Exception e)
		{

			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		
		}
	}
	
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();
System.out.println("rowIndex      "+rowIndex);
		try{
			if(rowIndex > -1){
				// Calling last Column listener
				updateRecord();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	
	public void updateRecord(){
		String message = null;
		String str = null;
		try { 
			System.out.println("Welcome to updateRecord     "+PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_REMARKS()+"      "+
					PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_APPR_STS());
			 
			helper.DTL_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
		    helper.preUpdate(compositeAction);
			new CRUDHandler().executeUpdate(PT_IL_OCD_DOC_TODO_LIST_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	    
			
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			 
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	/*End*/
	/*Added by Ram on 01/01/2017 for Clear component values*/
    private void resetRowAtCreate() {
    	Iterator<PT_IL_OCD_DOC_TODO_LIST> PT_IL_OCD_DOC_TODO_LIST_ITR = dataList_PT_IL_OCD_DOC_TODO_LIST
    			.iterator();
		while (PT_IL_OCD_DOC_TODO_LIST_ITR.hasNext()) {
			PT_IL_OCD_DOC_TODO_LIST_ITR.next().setRowSelected(false);;
			
		}
	}
    /*End*/

    /*Added by Ram on 31/03/2017 for Update All Functionality*/
	public void fireFieldValidationChk(ActionEvent actionEvent) {
		try {
			
			/*if(compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN().getPP_PAYOUT_STATUS() != null 
					&& compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN().getPP_PAYOUT_STATUS().equalsIgnoreCase("Approved by Operations"))
			{*/
				
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			
			

			System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
			 boolean chkFlag = false;
			 chkFlag = (boolean)input.getSubmittedValue();
			 String defChk = "N";
			 boolean fieldDisable = false;
			 if(chkFlag)
			 {
				 defChk = "Y";
				 getPT_IL_OCD_DOC_TODO_LIST_BEAN().setOCD_DTL_DOC_REC_DT(new CommonUtils().getCurrentDate());
				 fieldDisable = false;
			 }
			 else
			 {
				 getPT_IL_OCD_DOC_TODO_LIST_BEAN().setOCD_DTL_DOC_REC_DT(null);
				 fieldDisable = true;
			 }
			 
			 if(getPT_IL_OCD_DOC_TODO_LIST_BEAN().getDataTable() == null)
			 {
				 getPT_IL_OCD_DOC_TODO_LIST_BEAN().setDataTable(new UIData());
						 
			 }
			 
			 System.out.println("Second      "+getPT_IL_OCD_DOC_TODO_LIST_BEAN().getDataTable());
			 
			 /*Modified by Janani on 02.08.2017 for ZBILQC-1733695*/
			 
			/* CommonUtils.setPageIndexing(PT_IL_OCD_DOC_TODO_LIST_BEAN,PT_IL_OCD_DOC_TODO_LIST_BEAN.getCOMP_DT_SCROLLER(),PT_IL_OCD_DOC_TODO_LIST_BEAN.getDataTable());*/
			 
			 CommonUtils.setPageIndexing(getPT_IL_OCD_DOC_TODO_LIST_BEAN(),getPT_IL_OCD_DOC_TODO_LIST_BEAN().getCOMP_DT_SCROLLER(),dataTable);
			 
			 /*End*/
			 
			 System.out.println("page Start from "+getPT_IL_OCD_DOC_TODO_LIST_BEAN().getStartIndex()+"    Ended to    "+getPT_IL_OCD_DOC_TODO_LIST_BEAN().getEndindex());
			 
			 setDataList_PT_IL_OCD_DOC_TODO_LIST(CommonUtils.returnCheckedList(getDataList_PT_IL_OCD_DOC_TODO_LIST(), "OCD_DTL_APPR_STS", defChk,
					 getPT_IL_OCD_DOC_TODO_LIST_BEAN().getStartIndex(),getDataList_PT_IL_OCD_DOC_TODO_LIST().size()));
			 
			 setDataList_PT_IL_OCD_DOC_TODO_LIST(CommonUtils.returnCheckedList(getDataList_PT_IL_OCD_DOC_TODO_LIST(), "OCD_DTL_DOC_REC_DT", 
					 getPT_IL_OCD_DOC_TODO_LIST_BEAN().getOCD_DTL_DOC_REC_DT(),getPT_IL_OCD_DOC_TODO_LIST_BEAN().getStartIndex(),getDataList_PT_IL_OCD_DOC_TODO_LIST().size()));
			     
			 getPT_IL_OCD_DOC_TODO_LIST_BEAN().setOCD_DTL_APPR_STS(defChk);
			 
			 COMP_DTLS_APPR_STS.resetValue();
			 COMP_DTLS_DOC_REC_DT.setDisabled(fieldDisable);
			 COMP_DTLS_DOC_REC_DT.resetValue();
			 
			 getPT_IL_OCD_DOC_TODO_LIST_BEAN().setUPDATE_ALL(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  
		
		
	}
	/*End*/
}
