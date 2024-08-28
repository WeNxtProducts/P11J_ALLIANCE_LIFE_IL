package com.iii.pel.forms.PILT006_APAC;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_STATUS_3_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CS_STATUS_DT_LABEL;

	private HtmlCalendar COMP_CS_STATUS_DT;

	private HtmlOutputLabel COMP_CS_STATUS_UID_LABEL;

	private HtmlInputText COMP_CS_STATUS_UID;

	private HtmlOutputLabel COMP_CS_REMARKS_LABEL;

	/*Commented by ganesh on 18-05-2017, ZBILQC-1724476 */
	//private HtmlInputText COMP_CS_REMARKS;

	private HtmlOutputLabel COMP_UI_M_CS_UID_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CS_UID_NAME;

	private PT_IL_CLAIM_STATUS_3 PT_IL_CLAIM_STATUS_3_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_STATUS_3_HELPER helper;

	private List<PT_IL_CLAIM_STATUS_3> dataList_PT_IL_CLAIM_STATUS_3 = new ArrayList<PT_IL_CLAIM_STATUS_3>();

	private UIData dataTable;

	public PT_IL_CLAIM_STATUS_3_ACTION() {

		PT_IL_CLAIM_STATUS_3_BEAN = new PT_IL_CLAIM_STATUS_3();
		helper = new PT_IL_CLAIM_STATUS_3_HELPER();
		instantiateAllComponent();
		// As per fmb
		setUPDATE_ALLOWED(false);
	}

	public PT_IL_CLAIM_STATUS_3 getPT_IL_CLAIM_STATUS_3_BEAN() {
		return PT_IL_CLAIM_STATUS_3_BEAN;
	}

	public void setPT_IL_CLAIM_STATUS_3_BEAN(
			PT_IL_CLAIM_STATUS_3 PT_IL_CLAIM_STATUS_3_BEAN) {
		this.PT_IL_CLAIM_STATUS_3_BEAN = PT_IL_CLAIM_STATUS_3_BEAN;
	}

	public List<PT_IL_CLAIM_STATUS_3> getDataList_PT_IL_CLAIM_STATUS_3() {
		return dataList_PT_IL_CLAIM_STATUS_3;
	}

	public void setDataListPT_IL_CLAIM_STATUS_3(
			List<PT_IL_CLAIM_STATUS_3> dataList_PT_IL_CLAIM_STATUS_3) {
		this.dataList_PT_IL_CLAIM_STATUS_3 = dataList_PT_IL_CLAIM_STATUS_3;
	}

	public void addRow(ActionEvent event) {
		String message = null;
		PT_IL_CLAIM_STATUS_3_DELEGATE delegate = new PT_IL_CLAIM_STATUS_3_DELEGATE();
		
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PT_IL_CLAIM_STATUS_3_BEAN = new PT_IL_CLAIM_STATUS_3();
				delegate.whenCreateRecord(PT_IL_CLAIM_STATUS_3_BEAN, 
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				COMP_CS_REMARKS.setDisabled(false);
				resetAllComponent();
				resetSelectedRow();
				
				PT_IL_CLAIM_STATUS_3_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getErrorMap().put("CREATE", message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}
	

	 


	public void deleteRow(ActionEvent event) {
		String message = null;
		
		try {
			CommonUtils.clearMaps(this);
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PT_IL_CLAIM_STATUS_3_BEAN,
						CommonUtils.getConnection());
				dataList_PT_IL_CLAIM_STATUS_3.remove(PT_IL_CLAIM_STATUS_3_BEAN);
				if (dataList_PT_IL_CLAIM_STATUS_3.size() > 0) {
					PT_IL_CLAIM_STATUS_3_BEAN = dataList_PT_IL_CLAIM_STATUS_3.get(0);
				} else if (dataList_PT_IL_CLAIM_STATUS_3.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_CLAIM_STATUS_3_BEAN.setRowSelected(true);
				/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
				CommonUtils.getConnection().commit();
				/*End*/
				
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}
			
			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		PT_IL_CLAIM_STATUS_3_DELEGATE delegate = new PT_IL_CLAIM_STATUS_3_DELEGATE();
		
		try {
			CommonUtils.clearMaps(this);
			if (PT_IL_CLAIM_STATUS_3_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
					delegate.preInsert(
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(),
							PT_IL_CLAIM_STATUS_3_BEAN, 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
					new CRUDHandler().executeInsert(PT_IL_CLAIM_STATUS_3_BEAN,
							CommonUtils.getConnection());
					COMP_CS_REMARKS.setDisabled(true);

					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
					
					
					dataList_PT_IL_CLAIM_STATUS_3.add(PT_IL_CLAIM_STATUS_3_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else{
				if(isUPDATE_ALLOWED()){
					delegate.preUpdate(PT_IL_CLAIM_STATUS_3_BEAN, 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
					new CRUDHandler().executeUpdate(PT_IL_CLAIM_STATUS_3_BEAN,
							CommonUtils.getConnection());
					
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}
			
		
			
			/*Added by Janani on 14.06.2017 for ZBILQC-1724476*/
			
			System.out.println("EntryDate is    "+PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT());
			/*PT_IL_CLAIM_STATUS_3_BEAN.setUI_CS_STATUS_DT(uI_CS_STATUS_DT);*/
			
			PT_IL_CLAIM_STATUS_3_BEAN.setUI_CS_STATUS_DT(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT()));
			
			System.out.println("UI_CS_STATUS_DT is    "+PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT());
			
			/*End*/
			
			
			
			PT_IL_CLAIM_STATUS_3_BEAN.setRowSelected(true);
			/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
			CommonUtils.getConnection().commit();
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		/*End*/

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		PT_IL_CLAIM_STATUS_3_DELEGATE delegate = new PT_IL_CLAIM_STATUS_3_DELEGATE();
		
		try {
			CommonUtils.clearMaps(this);
			resetSelectedRow();
			PT_IL_CLAIM_STATUS_3_BEAN = (PT_IL_CLAIM_STATUS_3) dataTable
					.getRowData();
	
			/*Added by Janani on 14.06.2017 for ZBILQC-1724476*/
			
			System.out.println("GetTime is       "+PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT()+"      "+PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()
					+"            "+new Date(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT())+"               "+new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()));

			PT_IL_CLAIM_STATUS_3_BEAN.setCS_STATUS_DT(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()));
			//PT_IL_CLAIM_STATUS_3_BEAN.setCS_STATUS_DT(new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()));
			
			System.out.println("After GetTime is       "+PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT()+"      "+PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()
					+"            "+new Date(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT())+"               "+new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT()));

			
			/*End*/
			
			delegate.postQuery(PT_IL_CLAIM_STATUS_3_BEAN, 
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			COMP_CS_REMARKS.setDisabled(true);
			
			PT_IL_CLAIM_STATUS_3_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_STATUS_3> PT_IL_CLAIM_STATUS_3_ITR = dataList_PT_IL_CLAIM_STATUS_3
				.iterator();
		while (PT_IL_CLAIM_STATUS_3_ITR.hasNext()) {
			PT_IL_CLAIM_STATUS_3_ITR.next().setRowSelected(false);
		}
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
			String message ="";
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
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
		PT_IL_CLAIM_STATUS_3_DELEGATE delegate = new PT_IL_CLAIM_STATUS_3_DELEGATE();
		try {
			if (isBlockFlag()) {
				System.out.println("Welcome to Onload in Claim Comments screen");
				delegate.whenNewBlockInstance(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
						PT_IL_CLAIM_STATUS_3_BEAN);
				helper.executeQuery(compositeAction);
				if(PT_IL_CLAIM_STATUS_3_BEAN.getROWID() != null){
					delegate.postQuery(PT_IL_CLAIM_STATUS_3_BEAN, 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				}else{
					delegate.whenCreateRecord(PT_IL_CLAIM_STATUS_3_BEAN, 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				}
				/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
				if("CL05".equalsIgnoreCase(compositeAction
						.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
						.getCLAIM_ADDL_STATUS())) {
				
				disableAllComponent(true);
			}//END
				
				System.out.println("UI_CS_STATUS_DT is ONLOAD   "+PT_IL_CLAIM_STATUS_3_BEAN.getUI_CS_STATUS_DT());
					
				System.out.println("CS_STATUS_DT is ONLOAD   "+PT_IL_CLAIM_STATUS_3_BEAN.getCS_STATUS_DT());
		
			
				
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * Instantiates all components in PT_IL_CLAIM_STATUS_3_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CS_STATUS_UID				 = new HtmlInputText();
		/*
		 * Commented by Ganesh on 18-05-2017, ZBILQC-1724476 
		 * COMP_CS_REMARKS					 = new HtmlInputText();*/
		COMP_UI_M_CS_UID_NAME				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_CS_STATUS_DT				 = new HtmlCalendar();
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		UI_M_BUT_DEL= new HtmlAjaxCommandButton();
		UI_M_BUT_POST= new HtmlAjaxCommandButton();
		UI_M_BUT_ADD= new HtmlAjaxCommandButton();
	//END
		//Added by Ganesh on 18-05-2017, ZBILQC-1724476
		COMP_CS_REMARKS = new HtmlInputTextarea();
	}

	/**
	 * Resets all components in PT_IL_CLAIM_STATUS_3_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_CS_STATUS_UID.resetValue();
		COMP_CS_REMARKS.resetValue();
		COMP_UI_M_CS_UID_NAME.resetValue();

		// Reseting HtmlCalendar
		COMP_CS_STATUS_DT.resetValue();

	}

	/**
	 * Disables all components in PT_IL_CLAIM_STATUS_3_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CS_STATUS_UID.setDisabled(disabled);
		COMP_CS_REMARKS.setDisabled(disabled);
		COMP_UI_M_CS_UID_NAME.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CS_STATUS_DT.setDisabled(disabled);
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		UI_M_BUT_DEL.setDisabled(disabled);
		UI_M_BUT_POST.setDisabled(disabled);
		UI_M_BUT_ADD.setDisabled(disabled);
//END
	}

	public HtmlOutputLabel getCOMP_CS_STATUS_DT_LABEL() {
		return COMP_CS_STATUS_DT_LABEL;
	}

	public void setCOMP_CS_STATUS_DT_LABEL(HtmlOutputLabel comp_cs_status_dt_label) {
		COMP_CS_STATUS_DT_LABEL = comp_cs_status_dt_label;
	}

	public HtmlCalendar getCOMP_CS_STATUS_DT() {
		return COMP_CS_STATUS_DT;
	}

	public void setCOMP_CS_STATUS_DT(HtmlCalendar comp_cs_status_dt) {
		COMP_CS_STATUS_DT = comp_cs_status_dt;
	}

	public HtmlOutputLabel getCOMP_CS_STATUS_UID_LABEL() {
		return COMP_CS_STATUS_UID_LABEL;
	}

	public void setCOMP_CS_STATUS_UID_LABEL(HtmlOutputLabel comp_cs_status_uid_label) {
		COMP_CS_STATUS_UID_LABEL = comp_cs_status_uid_label;
	}

	public HtmlInputText getCOMP_CS_STATUS_UID() {
		return COMP_CS_STATUS_UID;
	}

	public void setCOMP_CS_STATUS_UID(HtmlInputText comp_cs_status_uid) {
		COMP_CS_STATUS_UID = comp_cs_status_uid;
	}

	public HtmlOutputLabel getCOMP_CS_REMARKS_LABEL() {
		return COMP_CS_REMARKS_LABEL;
	}

	public void setCOMP_CS_REMARKS_LABEL(HtmlOutputLabel comp_cs_remarks_label) {
		COMP_CS_REMARKS_LABEL = comp_cs_remarks_label;
	}

	/*Commented by ganesh on 18-05-2017, ZBILQC-1724476 
	 * 
	 * public HtmlInputText getCOMP_CS_REMARKS() {
		return COMP_CS_REMARKS;
	}

	public void setCOMP_CS_REMARKS(HtmlInputText comp_cs_remarks) {
		COMP_CS_REMARKS = comp_cs_remarks;
	}*/

	public HtmlOutputLabel getCOMP_UI_M_CS_UID_NAME_LABEL() {
		return COMP_UI_M_CS_UID_NAME_LABEL;
	}

	public void setCOMP_UI_M_CS_UID_NAME_LABEL(
			HtmlOutputLabel comp_ui_m_cs_uid_name_label) {
		COMP_UI_M_CS_UID_NAME_LABEL = comp_ui_m_cs_uid_name_label;
	}

	public HtmlInputText getCOMP_UI_M_CS_UID_NAME() {
		return COMP_UI_M_CS_UID_NAME;
	}

	public void setCOMP_UI_M_CS_UID_NAME(HtmlInputText comp_ui_m_cs_uid_name) {
		COMP_UI_M_CS_UID_NAME = comp_ui_m_cs_uid_name;
	}

	public void setDataList_PT_IL_CLAIM_STATUS_3(
			List<PT_IL_CLAIM_STATUS_3> dataList_PT_IL_CLAIM_STATUS_3) {
		this.dataList_PT_IL_CLAIM_STATUS_3 = dataList_PT_IL_CLAIM_STATUS_3;
	}
	/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton uI_M_BUT_DEL) {
		UI_M_BUT_DEL = uI_M_BUT_DEL;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton uI_M_BUT_POST) {
		UI_M_BUT_POST = uI_M_BUT_POST;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton uI_M_BUT_ADD) {
		UI_M_BUT_ADD = uI_M_BUT_ADD;
	}
	
	//END
	/*Added by Ganesh on 18-05-2017, ZBILQC-1724476 */
	private HtmlInputTextarea COMP_CS_REMARKS;

	public HtmlInputTextarea getCOMP_CS_REMARKS() {
		return COMP_CS_REMARKS;
	}

	public void setCOMP_CS_REMARKS(HtmlInputTextarea cOMP_CS_REMARKS) {
		COMP_CS_REMARKS = cOMP_CS_REMARKS;
	}
	/*end*/

}

