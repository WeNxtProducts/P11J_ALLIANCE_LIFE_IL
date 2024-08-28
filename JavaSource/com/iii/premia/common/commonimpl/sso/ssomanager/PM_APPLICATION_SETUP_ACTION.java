package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_APPLICATION_SETUP_ACTION extends CommonAction {
	private PM_APPLICATION_DTLS PM_APPLICATION_DTLS_BEAN ;
	private ArrayList<PM_APPLICATION_DTLS> PM_APPLICATION_DTLS_LIST;
	private IM_SYSTEM_SETUP IM_SYSTEM_SETUP_BEAN;
	
	// Component backing
	private UIData dataTable;
	// System Setup components
	private HtmlInputText COMP_PARA_CODE;
	private HtmlInputText COMP_PARA_NAME;
	private HtmlInputText COMP_PARA_BL_NAME;
	private HtmlInputText COMP_PARA_MODULE;
	private HtmlInputText COMP_PARA_VALUE;
	// Application details components
	private HtmlInputText COMP_PAD_APPL_DESC;
	private HtmlInputText COMP_PAD_APPL_URL;
	
	public PM_APPLICATION_SETUP_ACTION(){
		PM_APPLICATION_DTLS_BEAN = new PM_APPLICATION_DTLS();
		PM_APPLICATION_DTLS_LIST = new ArrayList<PM_APPLICATION_DTLS>();
		IM_SYSTEM_SETUP_BEAN = new IM_SYSTEM_SETUP();
	}
	
	public void beforePhaseListener(PhaseEvent event){
		PM_APPLICATION_SETUP_DELEGATE appSetupDelegate = new PM_APPLICATION_SETUP_DELEGATE();
		
		try {
			if(isBlockFlag()){
				PM_APPLICATION_DTLS_LIST = appSetupDelegate.executeQuery();
				if(PM_APPLICATION_DTLS_LIST.size() > 0){
					PM_APPLICATION_DTLS_BEAN = PM_APPLICATION_DTLS_LIST.get(0);
				}else{
					PM_APPLICATION_DTLS_BEAN = new PM_APPLICATION_DTLS();
				}
				PM_APPLICATION_DTLS_BEAN.setRowSelected(true);
				IM_SYSTEM_SETUP_BEAN = appSetupDelegate.postQuery(PM_APPLICATION_DTLS_BEAN);
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
		}
	}
	
	public void displayRecord(ActionEvent event){
		PM_APPLICATION_SETUP_DELEGATE appSetupDelegate = new PM_APPLICATION_SETUP_DELEGATE();
		
		try {
			PM_APPLICATION_DTLS_BEAN = (PM_APPLICATION_DTLS) dataTable.getRowData();
			IM_SYSTEM_SETUP_BEAN = appSetupDelegate.postQuery(PM_APPLICATION_DTLS_BEAN);

			resetAllComponents();
			resetRowSelection();
			PM_APPLICATION_DTLS_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("DISPLAY_RECORD", e.getMessage());
		}
	}
	
	public void createRecord(ActionEvent event){
		PM_APPLICATION_DTLS_BEAN = new PM_APPLICATION_DTLS();
		IM_SYSTEM_SETUP_BEAN = new IM_SYSTEM_SETUP();
		
		// Defaulting value in IM_SYSTEM_SETUP_BEAN
		IM_SYSTEM_SETUP_BEAN.setPARA_MODULE(Messages.getString("messageProperties_SSO", 
				"IM_SYSTEM_SETUP$PARA_MODULE"));
		
		resetAllComponents();
		resetRowSelection();
		PM_APPLICATION_DTLS_BEAN.setRowSelected(true);
	}
	
	public void deleteRecord(ActionEvent event){
		PM_APPLICATION_SETUP_DELEGATE appSetupDelegate = new PM_APPLICATION_SETUP_DELEGATE();
		String message = null;

		try {
			appSetupDelegate.deleteRecord(PM_APPLICATION_DTLS_BEAN);
			// Remove the bean from data table
			PM_APPLICATION_DTLS_LIST.remove(PM_APPLICATION_DTLS_BEAN);
			// Prepare to display the bean
			if(PM_APPLICATION_DTLS_LIST.size() > 0){
				resetRowSelection();
				// Display the first bean
				PM_APPLICATION_DTLS_BEAN = PM_APPLICATION_DTLS_LIST.get(0);
				IM_SYSTEM_SETUP_BEAN = appSetupDelegate.postQuery(PM_APPLICATION_DTLS_BEAN);
				PM_APPLICATION_DTLS_BEAN.setRowSelected(true);
			}else{
				// Create a new record if list is empty
				createRecord(null);
			}
			// Prepare message
			message = Messages.getString("messageProperties", "errorPanel$message$delete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("DELETE", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
	}
	
	public void postRecord(ActionEvent event){
		PM_APPLICATION_SETUP_DELEGATE appSetupDelegate = new PM_APPLICATION_SETUP_DELEGATE();
		String message = null;

		try {
			if(PM_APPLICATION_DTLS_BEAN.getROWID() == null){
				// Prepare to insert
				preInsert();
				// Save the record
				appSetupDelegate.postRecord(PM_APPLICATION_DTLS_BEAN, IM_SYSTEM_SETUP_BEAN);
				// Add new bean to the list
				PM_APPLICATION_DTLS_LIST.add(PM_APPLICATION_DTLS_BEAN);
				// Prepare save message
				message = Messages.getString("messageProperties", "errorPanel$message$insert");
			}else{
				// Prepare to update
				preUpdate();
				// Update the record
				appSetupDelegate.postRecord(PM_APPLICATION_DTLS_BEAN, IM_SYSTEM_SETUP_BEAN);
				// Prepare update message
				message = Messages.getString("messageProperties", "errorPanel$message$postupdate");
			}

			// Set the message to map
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("POST", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
	}
	
	public String saveRecord(){
		String outcome = null;
		String message = null;
		
		try {
			// Commit changes to database
			new CommonUtils().doComitt();
			// Prepare update message
			message = Messages.getString("messageProperties", "errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("SAVE", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		
		return outcome;
	}

	public void preInsert(){
		try {
			// Set pre-insert attributes of IM_SYSTEM_SETUP
			IM_SYSTEM_SETUP_BEAN.setPARA_CR_UID(CommonUtils.getGlobalVariable("GLOBAL:M_USER_ID"));
			IM_SYSTEM_SETUP_BEAN.setPARA_CR_DT(new CommonUtils().getCurrentDate());
			// Set pre-insert attributes of PM_APPLICATION_DTLS
			PM_APPLICATION_DTLS_BEAN.setPAD_APPL_CODE(IM_SYSTEM_SETUP_BEAN.getPARA_CODE());
		} catch (ParseException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("PRE_INSERT", e.getMessage());
		}
	}

	public void preUpdate(){
		try {
			// Set pre-update attributes of IM_SYSTEM_SETUP
			IM_SYSTEM_SETUP_BEAN.setPARA_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL:M_USER_ID"));
			IM_SYSTEM_SETUP_BEAN.setPARA_UPD_DT(new CommonUtils().getCurrentDate());
			// Set pre-update attributes of PM_APPLICATION_DTLS
			PM_APPLICATION_DTLS_BEAN.setPAD_APPL_CODE(IM_SYSTEM_SETUP_BEAN.getPARA_CODE());
		} catch (ParseException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("PRE_INSERT", e.getMessage());
		}
	}
	
	public void resetAllComponents(){
		// System Setup components
		COMP_PARA_CODE.resetValue();
		COMP_PARA_NAME.resetValue();
		COMP_PARA_BL_NAME.resetValue();
		COMP_PARA_MODULE.resetValue();
		COMP_PARA_VALUE.resetValue();
		// Application details components
		COMP_PAD_APPL_DESC.resetValue();
		COMP_PAD_APPL_URL.resetValue();
	}
	
	public void disableAllComponents(boolean disabled){
		// System Setup components
		COMP_PARA_CODE.setDisabled(disabled);
		COMP_PARA_NAME.setDisabled(disabled);
		COMP_PARA_BL_NAME.setDisabled(disabled);
		//COMP_PARA_MODULE.setDisabled(disabled);
		COMP_PARA_VALUE.setDisabled(disabled);
		// Application details components
		COMP_PAD_APPL_DESC.setDisabled(disabled);
		COMP_PAD_APPL_URL.setDisabled(disabled);
	}
	
	public void resetRowSelection(){
		Iterator<PM_APPLICATION_DTLS> iterator = PM_APPLICATION_DTLS_LIST.iterator();
		PM_APPLICATION_DTLS appDetailsBean = null;
		
		while(iterator.hasNext()){
			appDetailsBean = iterator.next();
			appDetailsBean.setRowSelected(false);
		}
	}
	
	// Action listener
	public void fireFieldValidation(ActionEvent event){
		CommonUtils.clearMaps(this);
		ErrorHelpUtil.validate((UIInput) event.getComponent().getParent(), getErrorMap());
	}
	// Validators
	public void validateAppCode(FacesContext context, UIComponent component, Object value){
		PM_APPLICATION_SETUP_DELEGATE delegate = new PM_APPLICATION_SETUP_DELEGATE();
		
		try {
			delegate.validateAppCode(IM_SYSTEM_SETUP_BEAN.getROWID(), (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateAppName(FacesContext context, UIComponent component, Object value){
		PM_APPLICATION_SETUP_DELEGATE delegate = new PM_APPLICATION_SETUP_DELEGATE();
		
		try {
			delegate.validateAppName(PM_APPLICATION_DTLS_BEAN.getROWID(), (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public PM_APPLICATION_DTLS getPM_APPLICATION_DTLS_BEAN() {
		return PM_APPLICATION_DTLS_BEAN;
	}

	public void setPM_APPLICATION_DTLS_BEAN(
			PM_APPLICATION_DTLS pm_application_dtls_bean) {
		PM_APPLICATION_DTLS_BEAN = pm_application_dtls_bean;
	}

	public ArrayList<PM_APPLICATION_DTLS> getPM_APPLICATION_DTLS_LIST() {
		return PM_APPLICATION_DTLS_LIST;
	}

	public void setPM_APPLICATION_DTLS_LIST(
			ArrayList<PM_APPLICATION_DTLS> pm_application_dtls_list) {
		PM_APPLICATION_DTLS_LIST = pm_application_dtls_list;
	}

	public IM_SYSTEM_SETUP getIM_SYSTEM_SETUP_BEAN() {
		return IM_SYSTEM_SETUP_BEAN;
	}

	public void setIM_SYSTEM_SETUP_BEAN(IM_SYSTEM_SETUP im_system_setup_bean) {
		IM_SYSTEM_SETUP_BEAN = im_system_setup_bean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_PARA_CODE() {
		return COMP_PARA_CODE;
	}

	public void setCOMP_PARA_CODE(HtmlInputText comp_para_code) {
		COMP_PARA_CODE = comp_para_code;
	}

	public HtmlInputText getCOMP_PARA_NAME() {
		return COMP_PARA_NAME;
	}

	public void setCOMP_PARA_NAME(HtmlInputText comp_para_name) {
		COMP_PARA_NAME = comp_para_name;
	}

	public HtmlInputText getCOMP_PARA_BL_NAME() {
		return COMP_PARA_BL_NAME;
	}

	public void setCOMP_PARA_BL_NAME(HtmlInputText comp_para_bl_name) {
		COMP_PARA_BL_NAME = comp_para_bl_name;
	}

	public HtmlInputText getCOMP_PARA_MODULE() {
		return COMP_PARA_MODULE;
	}

	public void setCOMP_PARA_MODULE(HtmlInputText comp_para_module) {
		COMP_PARA_MODULE = comp_para_module;
	}

	public HtmlInputText getCOMP_PARA_VALUE() {
		return COMP_PARA_VALUE;
	}

	public void setCOMP_PARA_VALUE(HtmlInputText comp_para_value) {
		COMP_PARA_VALUE = comp_para_value;
	}

	public HtmlInputText getCOMP_PAD_APPL_DESC() {
		return COMP_PAD_APPL_DESC;
	}

	public void setCOMP_PAD_APPL_DESC(HtmlInputText comp_pad_appl_desc) {
		COMP_PAD_APPL_DESC = comp_pad_appl_desc;
	}

	public HtmlInputText getCOMP_PAD_APPL_URL() {
		return COMP_PAD_APPL_URL;
	}

	public void setCOMP_PAD_APPL_URL(HtmlInputText comp_pad_appl_url) {
		COMP_PAD_APPL_URL = comp_pad_appl_url;
	}
}
