package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
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
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.fileupload.FileUploadAction;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_DOC_TODO_LIST_STATUS_ACTION extends CommonAction {
	
	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog(PT_IL_DOC_TODO_LIST_STATUS_ACTION.class);
	
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

	private PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_DOC_TODO_LIST_STATUS_HELPER helper;

	private List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS = new ArrayList<PT_IL_DOC_TODO_LIST_STATUS>();

	private UIData dataTable;
	
	private List<LovBean> suggestionLOV = null;

	private List<SelectItem> listDTLS_MANDATORY_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listDTLS_APPR_STS = new ArrayList<SelectItem>();
	
	private String filterByDTLS_SR_NO;
	
	private String filterByDTLS_APPR_STS;
	
	private String filterByDTLS_MANDATORY_YN;
	
	private String filterByDTLS_TODO_LIST_ITEM;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlAjaxCommandButton UI_M_BUT_MAIN;
	
	private HtmlCommandButton UI_BUT_MAIN;
	
	/**
	 * @return the uI_BUT_MAIN
	 */
	public HtmlCommandButton getUI_BUT_MAIN() {
		return UI_BUT_MAIN;
	}

	/**
	 * @param ui_but_main the uI_BUT_MAIN to set
	 */
	public void setUI_BUT_MAIN(HtmlCommandButton ui_but_main) {
		UI_BUT_MAIN = ui_but_main;
	}

	/**
	 * @return the filterByDTLS_SR_NO
	 */
	public String getFilterByDTLS_SR_NO() {
		return filterByDTLS_SR_NO;
	}

	/**
	 * @param filterByDTLS_SR_NO the filterByDTLS_SR_NO to set
	 */
	public void setFilterByDTLS_SR_NO(String filterByDTLS_SR_NO) {
		this.filterByDTLS_SR_NO = filterByDTLS_SR_NO;
	}

	/**
	 * @return the filterByDTLS_APPR_STS
	 */
	public String getFilterByDTLS_APPR_STS() {
		return filterByDTLS_APPR_STS;
	}

	/**
	 * @param filterByDTLS_APPR_STS the filterByDTLS_APPR_STS to set
	 */
	public void setFilterByDTLS_APPR_STS(String filterByDTLS_APPR_STS) {
		this.filterByDTLS_APPR_STS = filterByDTLS_APPR_STS;
	}

	/**
	 * @return the filterByDTLS_TODO_LIST_ITEM
	 */
	public String getFilterByDTLS_TODO_LIST_ITEM() {
		return filterByDTLS_TODO_LIST_ITEM;
	}

	/**
	 * @param filterByDTLS_TODO_LIST_ITEM the filterByDTLS_TODO_LIST_ITEM to set
	 */
	public void setFilterByDTLS_TODO_LIST_ITEM(String filterByDTLS_TODO_LIST_ITEM) {
		this.filterByDTLS_TODO_LIST_ITEM = filterByDTLS_TODO_LIST_ITEM;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public PT_IL_DOC_TODO_LIST_STATUS_ACTION() {
		
		/*setListDTLS_APPR_STS(listDTLS_APPR_STS)
		setListDTLS_MANDATORY_YN(listDTLS_MANDATORY_YN);*/
		
		setListDTLS_APPR_STS(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_DOC_TODO_LIST_STATUS", "PT_IL_DOC_TODO_LIST_STATUS.DTLS_MANDATORY_YN", "YESNO"));
		setListDTLS_MANDATORY_YN(ListItemUtil.getDropDownListValue(getConnection(), 
				"PILT006_APAC","PT_IL_DOC_TODO_LIST_STATUS", "PT_IL_DOC_TODO_LIST_STATUS.DTLS_MANDATORY_YN", "YESNO"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
		helper = new PT_IL_DOC_TODO_LIST_STATUS_HELPER();
		instantiateAllComponent();
	}

	public PT_IL_DOC_TODO_LIST_STATUS getPT_IL_DOC_TODO_LIST_STATUS_BEAN() {
		return PT_IL_DOC_TODO_LIST_STATUS_BEAN;
	}

	public void setPT_IL_DOC_TODO_LIST_STATUS_BEAN(
			PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN) {
		this.PT_IL_DOC_TODO_LIST_STATUS_BEAN = PT_IL_DOC_TODO_LIST_STATUS_BEAN;
	}

	public void addRow(ActionEvent event) {
		try {
			
			/*Added by Janani on 22.05.2017*/
			getErrorMap().clear();
			getWarningMap().clear();

			/*End*/
			
			
			if (isINSERT_ALLOWED()) {
				PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
				resetAllComponent();
				/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017
				 * 
				 * resetSelectedRow();*/
				resetRowAtCreate();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
				/*End*/
				
				/*Added by Janani on 21.08.2017 for ZBILQC-1732254*/
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_SR_NO().setDisabled(false);
				/*End*/
				
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				helper.keyDelRec(PT_IL_DOC_TODO_LIST_STATUS_BEAN, compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				
				new CRUDHandler().executeDelete(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
								.getConnection());
				
				CommonUtils.getConnection().commit();
				
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_DOC_TODO_LIST_STATUS
						.remove(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
				if (dataList_PT_IL_DOC_TODO_LIST_STATUS.size() > 0) {

					PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList_PT_IL_DOC_TODO_LIST_STATUS
							.get(0);
				} else if (dataList_PT_IL_DOC_TODO_LIST_STATUS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) throws Exception{
		
/*Added by Janani on 23.05.2017 for ZB Factory testing feed-back point*/
		
		String message = null; 
		
		/*End*/
		
		
		
		try {
			if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
				helper.preInsert(PT_IL_DOC_TODO_LIST_STATUS_BEAN, compositeAction);
				/*End*/
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_GROUP_CODE(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE());
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
				
				new CRUDHandler().executeInsert(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
								.getConnection());
				
				
				/*
				 * Commented by Janani on 23.05.2017 for ZB Factory testing feed-back point
				 * 
				 * getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));*/
				
				
				/*Added by Janani on 23.05.2017 for ZB Factory testing feed-back point*/				

				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);

				/*End*/
				
				
				dataList_PT_IL_DOC_TODO_LIST_STATUS
						.add(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
				
				if(dataList_PT_IL_DOC_TODO_LIST_STATUS!=null){
					Iterator<PT_IL_DOC_TODO_LIST_STATUS > iterator = dataList_PT_IL_DOC_TODO_LIST_STATUS.iterator();
					while(iterator.hasNext()){
						PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status = iterator.next();
						pt_il_doc_todo_list_status.setRowSelected(false);
					}
				}
				//PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
				setPT_IL_DOC_TODO_LIST_STATUS_BEAN(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			} else if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				/*
				 * Commented by Janani on 23.05.2017 for ZB Factory testing feed-back point
				 * 
				 * new CRUDHandler().executeUpdate(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
								.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));*/
				
				
				/*Added by Janani on 23.05.2017 for ZB Factory testing feed-back point*/	
				if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.isUPDATE_ALL())
				{
					CommonUtils.updateAllRecords(dataList_PT_IL_DOC_TODO_LIST_STATUS, PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(), PT_IL_DOC_TODO_LIST_STATUS_BEAN.getEndindex());

					
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
					
				}
				else
				{
					
					helper.preUpdate(PT_IL_DOC_TODO_LIST_STATUS_BEAN,compositeAction);
					new CRUDHandler().executeUpdate(PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils.getConnection());
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 

				}
							
				
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getWarningMap().put("current",message);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getWarningMap().put("postRecord",message);
				
				/*End*/
				
				
				
			}

			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			.getErrorMap().put("SAVE", e.getMessage());
		}
		/*catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
*/
	}

	public void displayRecords() {
		CommonUtils.clearMaps(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN());
		try {
			resetSelectedRow();
			PT_IL_DOC_TODO_LIST_STATUS_BEAN = (PT_IL_DOC_TODO_LIST_STATUS) dataTable
					.getRowData();
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
			
			/*Added by Janani on 23.05.2017 for ZB Factory testing feed-back point(checklist)*/	
			enableFields();
			/*End*/
			
			
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
				.iterator();
		/*
		 * MODIFIED BY AMEEN ON 25-07-2017 FOR ZBILQC-1732254 
		 * while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
			PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);
		}*/
    	while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN = PT_IL_DOC_TODO_LIST_STATUS_ITR.next();
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(false);
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



	public void setListDTLS_APPR_STS(List<SelectItem> listDTLS_APPR_STS) {
		this.listDTLS_APPR_STS = listDTLS_APPR_STS;
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

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			
			/*Added by Janani on 23.05.2017 for ZB Factory testing feed-back point(checklist)*/	
			resetAllComponent();
			
			/*End*/
			
			
			if (isBlockFlag()) {
				//if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID()!=null){
					helper.preBlock(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(), null);
					helper.whenNewBlockInstance(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
							compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(), 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
					helper.postQuery();
					helper.executeQuery(compositeAction);
				//}
					
					
					
					/*Added by Janani on 23.05.2017 for ZB Factory testing feed-back point(checklist)*/	
					resetAllComponent();
					/*eND*/		
					
				setBlockFlag(false);
			}
			String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
			/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
			if(callingForm.equalsIgnoreCase("PILT002_APAC")	|| ("CL05".equalsIgnoreCase(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
					.getCLAIM_ADDL_STATUS()))		) {
				disableAllComponent(true);
			}//END
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


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
		
		UI_M_BUT_ADD.setDisabled(disabled);
		UI_M_BUT_DEL.setDisabled(disabled);
		UI_M_BUT_POST.setDisabled(disabled);
		
	}


	/**
	 * Instantiates all components in PT_IL_DOC_TODO_LIST_STATUS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DTLS_SR_NO					 = new HtmlInputText();
		COMP_DTLS_TODO_LIST_ITEM			 = new HtmlInputText();
		COMP_DTLS_REMARKS				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_DTLS_MANDATORY_YN				 = new HtmlSelectOneMenu();
		COMP_DTLS_APPR_STS				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_DTLS_DOC_REC_DT				 = new HtmlCalendar();
		
		UI_M_BUT_ADD =new 	HtmlAjaxCommandButton ();
		UI_M_BUT_DEL =new 	HtmlAjaxCommandButton ();	
		UI_M_BUT_POST =new 	HtmlAjaxCommandButton ();	

	}

	/**
	 * @return the cOMP_DTLS_SR_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTLS_SR_NO_LABEL() {
		return COMP_DTLS_SR_NO_LABEL;
	}

	/**
	 * @param comp_dtls_sr_no_label the cOMP_DTLS_SR_NO_LABEL to set
	 */
	public void setCOMP_DTLS_SR_NO_LABEL(HtmlOutputLabel comp_dtls_sr_no_label) {
		COMP_DTLS_SR_NO_LABEL = comp_dtls_sr_no_label;
	}

	/**
	 * @return the cOMP_DTLS_SR_NO
	 */
	public HtmlInputText getCOMP_DTLS_SR_NO() {
		return COMP_DTLS_SR_NO;
	}

	/**
	 * @param comp_dtls_sr_no the cOMP_DTLS_SR_NO to set
	 */
	public void setCOMP_DTLS_SR_NO(HtmlInputText comp_dtls_sr_no) {
		COMP_DTLS_SR_NO = comp_dtls_sr_no;
	}

	/**
	 * @return the cOMP_DTLS_TODO_LIST_ITEM_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTLS_TODO_LIST_ITEM_LABEL() {
		return COMP_DTLS_TODO_LIST_ITEM_LABEL;
	}

	/**
	 * @param comp_dtls_todo_list_item_label the cOMP_DTLS_TODO_LIST_ITEM_LABEL to set
	 */
	public void setCOMP_DTLS_TODO_LIST_ITEM_LABEL(
			HtmlOutputLabel comp_dtls_todo_list_item_label) {
		COMP_DTLS_TODO_LIST_ITEM_LABEL = comp_dtls_todo_list_item_label;
	}

	/**
	 * @return the cOMP_DTLS_TODO_LIST_ITEM
	 */
	public HtmlInputText getCOMP_DTLS_TODO_LIST_ITEM() {
		return COMP_DTLS_TODO_LIST_ITEM;
	}

	/**
	 * @param comp_dtls_todo_list_item the cOMP_DTLS_TODO_LIST_ITEM to set
	 */
	public void setCOMP_DTLS_TODO_LIST_ITEM(HtmlInputText comp_dtls_todo_list_item) {
		COMP_DTLS_TODO_LIST_ITEM = comp_dtls_todo_list_item;
	}

	/**
	 * @return the cOMP_DTLS_MANDATORY_YN_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTLS_MANDATORY_YN_LABEL() {
		return COMP_DTLS_MANDATORY_YN_LABEL;
	}

	/**
	 * @param comp_dtls_mandatory_yn_label the cOMP_DTLS_MANDATORY_YN_LABEL to set
	 */
	public void setCOMP_DTLS_MANDATORY_YN_LABEL(
			HtmlOutputLabel comp_dtls_mandatory_yn_label) {
		COMP_DTLS_MANDATORY_YN_LABEL = comp_dtls_mandatory_yn_label;
	}

	/**
	 * @return the cOMP_DTLS_MANDATORY_YN
	 */
	public HtmlSelectOneMenu getCOMP_DTLS_MANDATORY_YN() {
		return COMP_DTLS_MANDATORY_YN;
	}

	/**
	 * @param comp_dtls_mandatory_yn the cOMP_DTLS_MANDATORY_YN to set
	 */
	public void setCOMP_DTLS_MANDATORY_YN(HtmlSelectOneMenu comp_dtls_mandatory_yn) {
		COMP_DTLS_MANDATORY_YN = comp_dtls_mandatory_yn;
	}

	/**
	 * @return the cOMP_DTLS_APPR_STS_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTLS_APPR_STS_LABEL() {
		return COMP_DTLS_APPR_STS_LABEL;
	}

	/**
	 * @param comp_dtls_appr_sts_label the cOMP_DTLS_APPR_STS_LABEL to set
	 */
	public void setCOMP_DTLS_APPR_STS_LABEL(HtmlOutputLabel comp_dtls_appr_sts_label) {
		COMP_DTLS_APPR_STS_LABEL = comp_dtls_appr_sts_label;
	}

	/**
	 * @return the cOMP_DTLS_APPR_STS
	 */
	public HtmlSelectOneMenu getCOMP_DTLS_APPR_STS() {
		return COMP_DTLS_APPR_STS;
	}

	/**
	 * @param comp_dtls_appr_sts the cOMP_DTLS_APPR_STS to set
	 */
	public void setCOMP_DTLS_APPR_STS(HtmlSelectOneMenu comp_dtls_appr_sts) {
		COMP_DTLS_APPR_STS = comp_dtls_appr_sts;
	}

	/**
	 * @return the cOMP_DTLS_DOC_REC_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTLS_DOC_REC_DT_LABEL() {
		return COMP_DTLS_DOC_REC_DT_LABEL;
	}

	/**
	 * @param comp_dtls_doc_rec_dt_label the cOMP_DTLS_DOC_REC_DT_LABEL to set
	 */
	public void setCOMP_DTLS_DOC_REC_DT_LABEL(
			HtmlOutputLabel comp_dtls_doc_rec_dt_label) {
		COMP_DTLS_DOC_REC_DT_LABEL = comp_dtls_doc_rec_dt_label;
	}

	/**
	 * @return the cOMP_DTLS_DOC_REC_DT
	 */
	public HtmlCalendar getCOMP_DTLS_DOC_REC_DT() {
		return COMP_DTLS_DOC_REC_DT;
	}

	/**
	 * @param comp_dtls_doc_rec_dt the cOMP_DTLS_DOC_REC_DT to set
	 */
	public void setCOMP_DTLS_DOC_REC_DT(HtmlCalendar comp_dtls_doc_rec_dt) {
		COMP_DTLS_DOC_REC_DT = comp_dtls_doc_rec_dt;
	}

	/**
	 * @return the cOMP_DTLS_REMARKS_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTLS_REMARKS_LABEL() {
		return COMP_DTLS_REMARKS_LABEL;
	}

	/**
	 * @param comp_dtls_remarks_label the cOMP_DTLS_REMARKS_LABEL to set
	 */
	public void setCOMP_DTLS_REMARKS_LABEL(HtmlOutputLabel comp_dtls_remarks_label) {
		COMP_DTLS_REMARKS_LABEL = comp_dtls_remarks_label;
	}

	/**
	 * @return the cOMP_DTLS_REMARKS
	 */
	public HtmlInputText getCOMP_DTLS_REMARKS() {
		return COMP_DTLS_REMARKS;
	}

	/**
	 * @param comp_dtls_remarks the cOMP_DTLS_REMARKS to set
	 */
	public void setCOMP_DTLS_REMARKS(HtmlInputText comp_dtls_remarks) {
		COMP_DTLS_REMARKS = comp_dtls_remarks;
	}

	/**
	 * @return the compositeAction
	 */
	public PILT006_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILT006_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PT_IL_DOC_TODO_LIST_STATUS_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PT_IL_DOC_TODO_LIST_STATUS_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the dataList_PT_IL_DOC_TODO_LIST_STATUS
	 */
	public List<PT_IL_DOC_TODO_LIST_STATUS> getDataList_PT_IL_DOC_TODO_LIST_STATUS() {
		return dataList_PT_IL_DOC_TODO_LIST_STATUS;
	}

	/**
	 * @param dataList_PT_IL_DOC_TODO_LIST_STATUS the dataList_PT_IL_DOC_TODO_LIST_STATUS to set
	 */
	public void setDataList_PT_IL_DOC_TODO_LIST_STATUS(
			List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS) {
		this.dataList_PT_IL_DOC_TODO_LIST_STATUS = dataList_PT_IL_DOC_TODO_LIST_STATUS;
	}

	/**
	 * @return the suggestionLOV
	 */
	public List<LovBean> getSuggestionLOV() {
		return suggestionLOV;
	}

	/**
	 * @param suggestionLOV the suggestionLOV to set
	 */
	public void setSuggestionLOV(List<LovBean> suggestionLOV) {
		this.suggestionLOV = suggestionLOV;
	}

	/**
	 * @return the log
	 */
	public static Log getLog() {
		return log;
	}

	/**
	 * @param listDTLS_MANDATORY_YN the listDTLS_MANDATORY_YN to set
	 */
	public void setListDTLS_MANDATORY_YN(List<SelectItem> listDTLS_MANDATORY_YN) {
		this.listDTLS_MANDATORY_YN = listDTLS_MANDATORY_YN;
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> srNoSuggestionLOV(Object event){
		try {
			log.info("=========DS_TYPE=====>"+compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_TYPE());
			log.info("=========DS_CODE=====>"+compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_CODE());
			log.info("=========GROUP_CODE=====>"+compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE());
			
			suggestionLOV = helper.lovSlNo(FacesContext.getCurrentInstance(), 
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_TYPE(), 
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_CODE(), 
					compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_CODE(), 
					(String)event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		
		return suggestionLOV;
	}
	/**
	 * 
	 * @param event
	 */
	public void validateDTLS_SR_NO(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 */
	public void validatorSR_NO(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				helper.whenValidateSR_NO(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			}
			/*Added by Ameen on 26-07-2017 for ZBILQC-1732254*/
			/*List<PT_IL_DOC_TODO_LIST_STATUS> dataListing = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
			System.out.println("dataListing :: size ::" + dataListing.size());
			if(dataListing.size() > 0){
			for(int i = 0 ; i < dataListing.size() ; i++ ){
				if(!dataListing.get(i).equals(PT_IL_DOC_TODO_LIST_STATUS_BEAN)){
					if(dataListing.get(i).getDTLS_SR_NO() == PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SR_NO()){
						throw new Exception("Serial No. Duplicated");
						}
					}
				}
			}*/
			/*End*/
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	
	public void validateDTLS_DOC_REC_DT(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			
			System.out.println("enters into validateDTLS_DOC_REC_DT                "+value);
			if(value!=null){
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT((Date) value);
				
				System.out.println("getDTLS_DOC_REC_DT             "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT());
				
				if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT().after(new CommonUtils().getCurrentDate())){
					throw new Exception("Date should be less than system date");
				}
			}
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 */
	public void validatorSR(ActionEvent event) throws Exception{
		try{
				helper.whenValidateSR_NO(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
						compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN(), 
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	public void validateDTLS_APPR_STS(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatorAPPR_STS(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS((String) value);
				helper.whenValidatorApprSTS(compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(),
						compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
				COMP_DTLS_DOC_REC_DT.resetValue();
			}
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void whenListChangedApprStatus(ActionEvent event) throws Exception{
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			helper.whenListChangedApprSTS(compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(),
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
			COMP_DTLS_DOC_REC_DT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @return the uI_M_BUT_MAIN
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_MAIN() {
		return UI_M_BUT_MAIN;
	}

	/**
	 * @param ui_m_but_main the uI_M_BUT_MAIN to set
	 */
	public void setUI_M_BUT_MAIN(HtmlAjaxCommandButton ui_m_but_main) {
		UI_M_BUT_MAIN = ui_m_but_main;
	}
	/**
	 * 
	 * @param event
	 * @return
	 */
	public String goToMain(){
		return "toDoGroup";
	}

	public String getFilterByDTLS_MANDATORY_YN() {
		return filterByDTLS_MANDATORY_YN;
	}

	public void setFilterByDTLS_MANDATORY_YN(String filterByDTLS_MANDATORY_YN) {
		this.filterByDTLS_MANDATORY_YN = filterByDTLS_MANDATORY_YN;
	}
	/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
    private void resetRowAtCreate() {
    	Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
    			.iterator();
		while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
			PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);;
			
		}
	}
    /*End*/
    
    
    
    /* Added by Janani on 19/05/2017 for hands-on-feedback point(checklist)*/ 

	public void fireFieldValidationChk(ActionEvent actionEvent) {
		try {

			System.out.println("Enters into fireFieldValidationChk          "+compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG());


			if((compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG().equals("N")))
			{

				UIInput input = (UIInput) actionEvent.getComponent().getParent();


				System.out.println("Welcome to CLAIM fireFieldValidationChk");

				boolean chkFlag = false;
				chkFlag = (boolean)input.getSubmittedValue();
				String defChk = "N";
				boolean fieldDisable = false;
				if(chkFlag)
				{
					defChk = "Y";
					getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
					fieldDisable = false;
				}
				else
				{
					getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
					fieldDisable = true;
				}
				/*
				 * Modified by Janani on 02.08.2017 for ZBILQC-1733695
				 * System.out.println("defChk        "+defChk+"       "+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getCOMP_DT_SCROLLER().getPage()+"      "+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDataTable().getRows()+"    "
						+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT());*/
				
				System.out.println("defChk        "+defChk+"       "+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getCOMP_DT_SCROLLER().getPage()+"      "+dataTable.getRows()+"    "
						+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT());

				if(getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDataTable() == null)
				{
					getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDataTable(new UIData());

				}

				System.out.println("Second1      "+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDataTable());

				/*Modified by Janani on 02.08.2017 for ZBILQC-1733695*/
				/* CommonUtils.setPageIndexing(getPT_IL_DOC_TODO_LIST_STATUS_BEAN(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getCOMP_DT_SCROLLER(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDataTable());*/
				
				CommonUtils.setPageIndexing(getPT_IL_DOC_TODO_LIST_STATUS_BEAN(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getCOMP_DT_SCROLLER(),dataTable);

				System.out.println("page Start from "+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getStartIndex()+"    Ended to    "+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getEndindex());

				/*
				 * Modified by Janani on 02.08.2017 for ZBILQC-1733695
				 * setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_APPR_STS", defChk,
						getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getStartIndex(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getEndindex()));


				setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_DOC_REC_DT", 
						getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_DOC_REC_DT(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getStartIndex(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getEndindex()));*/
				
				setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_APPR_STS", defChk,
						getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getStartIndex(),getDataList_PT_IL_DOC_TODO_LIST_STATUS().size()));


				setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_DOC_REC_DT", 
						getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_DOC_REC_DT(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getStartIndex(),getDataList_PT_IL_DOC_TODO_LIST_STATUS().size()));

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



	public void setDTLS_APPR_STS_Editable(ActionEvent event) {
		try
		{
			CommonUtils.clearMaps(this);
			String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			int currentIndex=this.dataTable.getRowIndex();
			/*PT_IL_DOC_TODO_LIST_STATUS_BEAN=(PT_IL_DOC_TODO_LIST_STATUS)dataList_PT_IL_DOC_TODO_LIST_STATUS.get(currentIndex);*/
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

	private void enableFields()
	{
		if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected() != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected()+" "+
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG());
			/*	if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))*/

			if((compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG().equals("Y")))
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
	
	/*Added by Sivarajan on 04/02/2020 for Aliance IL*/
	public String redirectUpload() {
		 String outcome = null;
		 if (PT_IL_DOC_TODO_LIST_STATUS_BEAN != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SMV_SYS_ID() != null
				 && !(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SMV_SYS_ID().toString().trim().isEmpty())) {

			 FileUploadAction uploadAction = new FileUploadAction(
					 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SYS_ID().toString(), PELConstants.pelPolicyTrans,
					 "toDoGroup", this.getErrorMap());
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
    

}
