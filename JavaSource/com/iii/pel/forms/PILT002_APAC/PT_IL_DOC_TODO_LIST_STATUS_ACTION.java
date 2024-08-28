package com.iii.pel.forms.PILT002_APAC;

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
import com.iii.pel.fileupload.FileUploadAction;
import com.iii.pel.fileupload.PM_IL_IMAGES;
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

    public PILT002_APAC_COMPOSITE_ACTION compositeAction;

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
	PT_IL_POL_ASSURED_DTLS_ACTION_BEAN=new PT_IL_POL_ASSURED_DTLS_ACTION();
	helperBean=new PT_IL_POL_ASSURED_DTLS_HELPER();
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

    //added by saranya on 31-03-16 for BMI
    public PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN;


    private PT_IL_POL_ASSURED_DTLS_HELPER helperBean;

    public PT_IL_POL_ASSURED_DTLS_ACTION getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN() {
		return PT_IL_POL_ASSURED_DTLS_ACTION_BEAN;
	}

	public void setPT_IL_POL_ASSURED_DTLS_ACTION_BEAN(
			PT_IL_POL_ASSURED_DTLS_ACTION pT_IL_POL_ASSURED_DTLS_ACTION_BEAN) {
		PT_IL_POL_ASSURED_DTLS_ACTION_BEAN = pT_IL_POL_ASSURED_DTLS_ACTION_BEAN;
	}

	public PT_IL_POL_ASSURED_DTLS_HELPER getHelperBean() {
		return helperBean;
	}

	public void setHelperBean(PT_IL_POL_ASSURED_DTLS_HELPER helperBean) {
		this.helperBean = helperBean;
	}
    
    
    
    
    
   //end
    
    
    
    
    public void addRow(ActionEvent event) {
    	String message =  null;
	try {
		getErrorMap().clear();
		getWarningMap().clear();
	    if (isINSERT_ALLOWED()) {
	    	COMP_DTLS_SR_NO.setDisabled(false);
	    	COMP_DTLS_TODO_LIST_ITEM.setDisabled(false);
	    	COMP_DTLS_DOC_REC_DT.setDisabled(false);
	    	COMP_DTLS_REMARKS.setDisabled(false);
	    	COMP_DTLS_MANDATORY_YN.setDisabled(false);
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
		helper.whenCreateRecord(compositeAction);
		/*Modiifed by Ram on 01/01/2017 for Clear component values
		 * 
		 * resetSelectedRow();*/
		resetRowAtCreate();
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
		/*End*/
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

    /*public void postRecord(ActionEvent event) {*/
    public void postRecord() {
    	String message = null; 
	try {
	    if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
		    helper.preInsert(compositeAction);
		    COMP_DTLS_SR_NO.setDisabled(true);
	    	COMP_DTLS_TODO_LIST_ITEM.setDisabled(true);
	    	COMP_DTLS_DOC_REC_DT.setDisabled(true);
	    	COMP_DTLS_REMARKS.setDisabled(true);
	    	COMP_DTLS_MANDATORY_YN.setDisabled(true);
			new CRUDHandler().executeInsert(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
			dataList_PT_IL_DOC_TODO_LIST_STATUS.add(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"); 
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			
	    } else if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
	    	
	    	
	    	/*Added by Ram on 31/03/2017 for Update All Functionality*/
			if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.isUPDATE_ALL())
			{
				CommonUtils.updateAllRecords(dataList_PT_IL_DOC_TODO_LIST_STATUS, PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(), dataList_PT_IL_DOC_TODO_LIST_STATUS.size());
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setUPDATE_ALL(false);
				/*Added by Ram on 17/04/2017*/
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				/*End*/
			}
			else
			{
			/*End*/
		    helper.preUpdate(compositeAction);
			new CRUDHandler().executeUpdate(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			
			}
			
			/*added by Ameen on 13-02-2018 for KIC*/
			/*if("KIC".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"))){*/
			/*String autoUW = "N";
			ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
												new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			if(rs.next()){
				autoUW = rs.getString("PROD_AUTO_UW");
			}
			if("Y".equalsIgnoreCase(autoUW)){
				
				String mandCheckQry="SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_APPR_STS = 'N' "
						+ "AND DTLS_MANDATORY_YN = 'Y' AND DTLS_POL_SYS_ID = ?";
				int updateStatus;
				ResultSet checkMandRS= new CRUDHandler().executeSelectStatement(mandCheckQry, CommonUtils.getConnection(), 
											new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				if(checkMandRS.next()){
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '004' WHERE POL_SYS_ID = ? ", 
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
			
			String autoUW = "N";
			ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
												new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			if(rs.next()){
				autoUW = rs.getString("PROD_AUTO_UW");
			}
			if("Y".equalsIgnoreCase(autoUW)){
				
				/*String medQry = "SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ?  AND PMED_STATUS = 'N'";
				String medStatus="";
				
				ResultSet medRS= new CRUDHandler().executeSelectStatement(medQry, CommonUtils.getConnection(), 
						new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					if(medRS.next()){
						medStatus = medRS.getString("X");
					}
				
				String mandCheckQry="SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_APPR_STS = 'N' "
						+ "AND DTLS_MANDATORY_YN = 'Y' AND DTLS_POL_SYS_ID = ?";
					
				String mandCheckQry="SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS  WHERE DTLS_POL_SYS_ID = ? AND DTLS_MANDATORY_YN = 'Y'  AND DTLS_APPR_STS = 'N'";
				String mandCheckStatus="";
				int updateStatus=0;
				ResultSet checkMandRS= new CRUDHandler().executeSelectStatement(mandCheckQry, CommonUtils.getConnection(), 
											new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				if(checkMandRS.next()){
					mandCheckStatus = checkMandRS.getString("X");
				}*/
				
				String mergeQry = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_POL_SYS_ID = ? AND DTLS_MANDATORY_YN = 'Y' AND DTLS_APPR_STS = 'N' "
									+ "UNION SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND PMED_STATUS = 'N'";
				
				int updateStatus=0;
				ResultSet mergeRS = new CRUDHandler().executeSelectStatement(mergeQry, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
										compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				
				/*if("X".equalsIgnoreCase(medStatus) && "X".equalsIgnoreCase(mandCheckStatus)){
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY  SET POL_ADDL_STATUS = '004' WHERE POL_SYS_ID = ?", 
							CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
						
				}else */if(mergeRS.next()){
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
				
			}
			
			/*End*/
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	    }
	    
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
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
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN = (PT_IL_DOC_TODO_LIST_STATUS) dataTable.getRowData();
	    PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
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
		if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected() != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected()+" "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
			{
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
			}
			else
			{
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
			}
		}
	}
	/*End*/

    private void resetSelectedRow() {
	Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
		.iterator();
	while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
	   /* Modified by Ram on 16/12/2016 for Policy Freeze scenario
	     * 
	     * PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);*/
		
		PT_IL_DOC_TODO_LIST_STATUS_BEAN = PT_IL_DOC_TODO_LIST_STATUS_ITR.next();
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(false);
		/*End*/
	}
    }
    
   /* private void resetSelectedRow() {
    	Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
    			.iterator();
    		while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
    			PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);
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
		resetAllComponent();
		if (isBlockFlag()) {
	    helper.whenNewBlockInstance(compositeAction);
		helper.preQuery(compositeAction);
		helper.executeQuery(compositeAction);
		if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() ==null){
		 helper.whenCreateRecord(compositeAction);   
		}
		resetAllComponent();
		
		
		
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
    		if("CHKLST".equalsIgnoreCase(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
    				.getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_TYPE()) &&
    				"Y".equalsIgnoreCase((String)value)){
    			if(!helper.isAllowed(PT_IL_DOC_TODO_LIST_STATUS_BEAN)){
    				throw new Exception("Kindly Upload Corresponding Document ");
    			}
    		}
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS((String)value);
    		System.out.println("Apprv Sts  :"+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_APPR_STS());
    		helper.DTLS_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
    		
    		/*Added by saranya on 11-04-2017*/
			COMP_DTLS_APPR_STS.resetValue();
		/*End*/
			
			
    	}catch(Exception e){
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
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
	 * Instantiates all components in PT_IL_DOC_TODO_LIST_STATUS_ACTION
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
	    	try{
	    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT((Date)value);
	    		if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT().after(new CommonUtils().getCurrentDate())){
	    			throw new Exception("Date should be lessthan or equal to system date");
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
		try
		{
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		/*PT_IL_DOC_TODO_LIST_STATUS_BEAN=(PT_IL_DOC_TODO_LIST_STATUS)dataList_PT_IL_DOC_TODO_LIST_STATUS.get(currentIndex);*/
		/*Added by Sivarajan on 04-12-2020 for ALLAINCE IL*/
		if("CHKLST".equalsIgnoreCase(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_TYPE()) 
				&& "Y".equalsIgnoreCase(status)){
			if(!helper.isAllowed(PT_IL_DOC_TODO_LIST_STATUS_BEAN)){
				throw new Exception("Kindly Upload Corresponding Document ");
			}
		}
		/*End*/
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(status);
		
		System.out.println("status      "+status);
		
		
		
		if(status != null && status.equalsIgnoreCase("Y"))
		{
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
			COMP_DTLS_DOC_REC_DT.setDisabled(false);
		}
		else
		{
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(null);
			COMP_DTLS_DOC_REC_DT.setDisabled(true);
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
		PT_IL_DOC_TODO_LIST_STATUS_BEAN=(PT_IL_DOC_TODO_LIST_STATUS)dataList_PT_IL_DOC_TODO_LIST_STATUS.get(currentIndex);
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_REMARKS(remarks);
		
		/*Added by saranya on 11-04-2017*/
		helper.DTLS_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
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
			System.out.println("Welcome to updateRecord     "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_REMARKS()+"      "+
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_APPR_STS());
			 
			helper.DTLS_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction);
		    helper.preUpdate(compositeAction);
			new CRUDHandler().executeUpdate(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
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
    	Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
    			.iterator();
		while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
			PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);;
			
		}
	}
    /*End*/

    /*Added by Ram on 31/03/2017 for Update All Functionality*/
	public void fireFieldValidationChk(ActionEvent actionEvent) {
		try {
			
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("N"))
			{
				
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			
			

			System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
			 boolean chkFlag = false;
			 chkFlag = (boolean)input.getSubmittedValue();
			 String defChk = "N";
			 boolean fieldDisable = false;
			 if(chkFlag)
			 {
				 defChk = "Y";
				 
				 PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS1 = null;
				 if("CHKLST".equals(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_TYPE())){
					 for(int i=0; i<dataList_PT_IL_DOC_TODO_LIST_STATUS.size();i++){
						 PT_IL_DOC_TODO_LIST_STATUS1 = dataList_PT_IL_DOC_TODO_LIST_STATUS.get(i);
						 if(!helper.isAllowed(PT_IL_DOC_TODO_LIST_STATUS1)){
								throw new Exception("Kindly Upload Corresponding Document ");
						 }
					 } 
				 }
				 
				 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
				 fieldDisable = false;
			 }
			 else
			 {
				 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
				 fieldDisable = true;
			 }
			 PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(defChk);
			 COMP_DTLS_APPR_STS.resetValue();
			 /*Modified by Janani on 02.08.2017 for ZBILQC-1733695*/
			 /*System.out.println("defChk        "+defChk+"       "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getCOMP_DT_SCROLLER()+"      "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDataTable()+"    "
					 +PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT());*/
			 
			 System.out.println("defChk        "+defChk+"       "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getCOMP_DT_SCROLLER()+"      "+dataTable.getRows()+"    "
					 +PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT());
			 
			 /*End*/
			 
			 
			 if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDataTable() == null)
			 {
				 PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDataTable(new UIData());
						 
			 }
			 
			 System.out.println("Second      "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDataTable());
			 
			 /*Modified by Janani on 02.08.2017 for ZBILQC-1733695*/
			 
			/* CommonUtils.setPageIndexing(PT_IL_DOC_TODO_LIST_STATUS_BEAN,PT_IL_DOC_TODO_LIST_STATUS_BEAN.getCOMP_DT_SCROLLER(),PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDataTable());*/
			 
			 CommonUtils.setPageIndexing(PT_IL_DOC_TODO_LIST_STATUS_BEAN,PT_IL_DOC_TODO_LIST_STATUS_BEAN.getCOMP_DT_SCROLLER(),dataTable);
			 
			 /*End*/
			 
			 System.out.println("page Start from "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex()+"    Ended to    "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getEndindex());
			 
			 setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_APPR_STS", defChk,
						 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(),dataList_PT_IL_DOC_TODO_LIST_STATUS.size()-1));
			 
			 setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_DOC_REC_DT", 
					 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT(),PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(),dataList_PT_IL_DOC_TODO_LIST_STATUS.size()-1));
			     
			 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_APPR_STS(defChk);
			 
			 COMP_DTLS_APPR_STS.resetValue();
			 COMP_DTLS_DOC_REC_DT.setDisabled(fieldDisable);
			 COMP_DTLS_DOC_REC_DT.resetValue();
			 
			 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setUPDATE_ALL(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  
		
		
	}
	/*End*/
	
	/*Added by Sivarajan on 04/02/2020 for Aliance IL*/
	public String redirectUpload() {
		 String outcome = null;
		 if (PT_IL_DOC_TODO_LIST_STATUS_BEAN != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SMV_SYS_ID() != null
				 && !(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SMV_SYS_ID().toString().trim().isEmpty())) {

			 FileUploadAction uploadAction = new FileUploadAction(
					 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SYS_ID().toString(), PELConstants.pelPolicyTrans,
					 "PILT002_APAC_PM_IL_DOC_TODO_GROUP", this.getErrorMap());
			 outcome = uploadAction.gotoFileUpload();
			
		 } else {
			 getErrorMap().clear();
			 String fileUploadErrorMessage = Messages.getString(
					 "messageProperties_fileUpload",
					 "fileupload$polreference$error$message");
			 getErrorMap().put("key", fileUploadErrorMessage);
			 getErrorMap().put("current", fileUploadErrorMessage);
		 }
		 return outcome;
		
	}
	/*End*/
	
	//
	
}
