package com.iii.pel.forms.WORKFLOW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PGIM_WF_WORKSTEP_MAPPING_ACTION extends CommonAction{

	public WORKFLOW_COMPOSITE_ACTION compositeAction;
	
	private PGIM_WF_WORKSTEP_MAPPING_HELPER helper;
	
	private PGIM_WF_WORKSTEP_MAPPING_DELEGATE delegate;
	
	private PGIM_WF_WORKSTEP_MAPPING PGIM_WF_WORKSTEP_MAPPING_BEAN;
	
	private HtmlInputText COMP_PWWM_PROCESS_ID;
	private HtmlInputText COMP_PWWM_WORKSTEP_ID;
	private HtmlInputText COMP_PWWM_RULE_ID;   
	private HtmlInputText COMP_PWWM_RULE_PARAM_ID;
	private HtmlInputText COMP_PWWM_SQL_STMT; 
	private HtmlInputText COMP_PWWM_TABLE_NAME;
	private HtmlInputText COMP_PWWM_WHR_CLS1_FLD;
	private HtmlInputText COMP_PWWM_WHR_CLS2_FLD;
	private HtmlInputText COMP_PWWM_WHR_CLS3_FLD;
	private HtmlInputText COMP_PWWM_WHR_CLS4_FLD;
	private HtmlInputText COMP_PWWM_WHR_CLS5_FLD;
	private HtmlInputText COMP_PWWM_SQL_RETURN_TYPE;
	private HtmlInputText COMP_PWWM_PWB_CODE;
	
	

	public PGIM_WF_WORKSTEP_MAPPING_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PGIM_WF_WORKSTEP_MAPPING_HELPER helper) {
		this.helper = helper;
	}

	public HtmlInputText getCOMP_PWWM_PROCESS_ID() {
		return COMP_PWWM_PROCESS_ID;
	}

	public void setCOMP_PWWM_PROCESS_ID(HtmlInputText cOMP_PWWM_PROCESS_ID) {
		COMP_PWWM_PROCESS_ID = cOMP_PWWM_PROCESS_ID;
	}

	public HtmlInputText getCOMP_PWWM_WORKSTEP_ID() {
		return COMP_PWWM_WORKSTEP_ID;
	}

	public void setCOMP_PWWM_WORKSTEP_ID(HtmlInputText cOMP_PWWM_WORKSTEP_ID) {
		COMP_PWWM_WORKSTEP_ID = cOMP_PWWM_WORKSTEP_ID;
	}

	public HtmlInputText getCOMP_PWWM_RULE_ID() {
		return COMP_PWWM_RULE_ID;
	}

	public void setCOMP_PWWM_RULE_ID(HtmlInputText cOMP_PWWM_RULE_ID) {
		COMP_PWWM_RULE_ID = cOMP_PWWM_RULE_ID;
	}

	public HtmlInputText getCOMP_PWWM_RULE_PARAM_ID() {
		return COMP_PWWM_RULE_PARAM_ID;
	}

	public void setCOMP_PWWM_RULE_PARAM_ID(HtmlInputText cOMP_PWWM_RULE_PARAM_ID) {
		COMP_PWWM_RULE_PARAM_ID = cOMP_PWWM_RULE_PARAM_ID;
	}

	public HtmlInputText getCOMP_PWWM_SQL_STMT() {
		return COMP_PWWM_SQL_STMT;
	}

	public void setCOMP_PWWM_SQL_STMT(HtmlInputText cOMP_PWWM_SQL_STMT) {
		COMP_PWWM_SQL_STMT = cOMP_PWWM_SQL_STMT;
	}

	public HtmlInputText getCOMP_PWWM_TABLE_NAME() {
		return COMP_PWWM_TABLE_NAME;
	}

	public void setCOMP_PWWM_TABLE_NAME(HtmlInputText cOMP_PWWM_TABLE_NAME) {
		COMP_PWWM_TABLE_NAME = cOMP_PWWM_TABLE_NAME;
	}

	public HtmlInputText getCOMP_PWWM_WHR_CLS1_FLD() {
		return COMP_PWWM_WHR_CLS1_FLD;
	}

	public void setCOMP_PWWM_WHR_CLS1_FLD(HtmlInputText cOMP_PWWM_WHR_CLS1_FLD) {
		COMP_PWWM_WHR_CLS1_FLD = cOMP_PWWM_WHR_CLS1_FLD;
	}

	public HtmlInputText getCOMP_PWWM_WHR_CLS2_FLD() {
		return COMP_PWWM_WHR_CLS2_FLD;
	}

	public void setCOMP_PWWM_WHR_CLS2_FLD(HtmlInputText cOMP_PWWM_WHR_CLS2_FLD) {
		COMP_PWWM_WHR_CLS2_FLD = cOMP_PWWM_WHR_CLS2_FLD;
	}

	public HtmlInputText getCOMP_PWWM_WHR_CLS3_FLD() {
		return COMP_PWWM_WHR_CLS3_FLD;
	}

	public void setCOMP_PWWM_WHR_CLS3_FLD(HtmlInputText cOMP_PWWM_WHR_CLS3_FLD) {
		COMP_PWWM_WHR_CLS3_FLD = cOMP_PWWM_WHR_CLS3_FLD;
	}

	public HtmlInputText getCOMP_PWWM_WHR_CLS4_FLD() {
		return COMP_PWWM_WHR_CLS4_FLD;
	}

	public void setCOMP_PWWM_WHR_CLS4_FLD(HtmlInputText cOMP_PWWM_WHR_CLS4_FLD) {
		COMP_PWWM_WHR_CLS4_FLD = cOMP_PWWM_WHR_CLS4_FLD;
	}

	public HtmlInputText getCOMP_PWWM_WHR_CLS5_FLD() {
		return COMP_PWWM_WHR_CLS5_FLD;
	}

	public void setCOMP_PWWM_WHR_CLS5_FLD(HtmlInputText cOMP_PWWM_WHR_CLS5_FLD) {
		COMP_PWWM_WHR_CLS5_FLD = cOMP_PWWM_WHR_CLS5_FLD;
	}

	public HtmlInputText getCOMP_PWWM_SQL_RETURN_TYPE() {
		return COMP_PWWM_SQL_RETURN_TYPE;
	}

	public void setCOMP_PWWM_SQL_RETURN_TYPE(HtmlInputText cOMP_PWWM_SQL_RETURN_TYPE) {
		COMP_PWWM_SQL_RETURN_TYPE = cOMP_PWWM_SQL_RETURN_TYPE;
	}

	public HtmlInputText getCOMP_PWWM_PWB_CODE() {
		return COMP_PWWM_PWB_CODE;
	}

	public void setCOMP_PWWM_PWB_CODE(HtmlInputText cOMP_PWWM_PWB_CODE) {
		COMP_PWWM_PWB_CODE = cOMP_PWWM_PWB_CODE;
	}

	public PGIM_WF_WORKSTEP_MAPPING_ACTION()
	{
		PGIM_WF_WORKSTEP_MAPPING_BEAN=new PGIM_WF_WORKSTEP_MAPPING();
		helper = new PGIM_WF_WORKSTEP_MAPPING_HELPER();
		delegate = new PGIM_WF_WORKSTEP_MAPPING_DELEGATE();
		initializeAllComponents();
	}
	
	public PGIM_WF_WORKSTEP_MAPPING_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PGIM_WF_WORKSTEP_MAPPING_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag())
			{
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				if(PGIM_WF_WORKSTEP_MAPPING_BEAN.getROWID()==null){
					helper.whenNewCreateInstance(compositeAction);
				}
				setBlockFlag(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	private List<PGIM_WF_WORKSTEP_MAPPING> dataTableList = new ArrayList<PGIM_WF_WORKSTEP_MAPPING>();

	private UIData dataTable;

	

		
	public List<PGIM_WF_WORKSTEP_MAPPING> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PGIM_WF_WORKSTEP_MAPPING> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PGIM_WF_WORKSTEP_MAPPING getPGIM_WF_WORKSTEP_MAPPING_BEAN() {
		return PGIM_WF_WORKSTEP_MAPPING_BEAN;
	}

	public void setPGIM_WF_WORKSTEP_MAPPING_BEAN(PGIM_WF_WORKSTEP_MAPPING pGIM_WF_WORKSTEP_MAPPING_BEAN) {
		PGIM_WF_WORKSTEP_MAPPING_BEAN = pGIM_WF_WORKSTEP_MAPPING_BEAN;
	}

	
	
	public void resetAllComponent()
	{
		COMP_PWWM_PROCESS_ID.resetValue();
		COMP_PWWM_WORKSTEP_ID.resetValue();
		COMP_PWWM_RULE_ID.resetValue();   
		COMP_PWWM_RULE_PARAM_ID.resetValue();
		COMP_PWWM_SQL_STMT.resetValue(); 
		COMP_PWWM_TABLE_NAME.resetValue();
		COMP_PWWM_WHR_CLS1_FLD.resetValue();
		COMP_PWWM_WHR_CLS2_FLD.resetValue();
		COMP_PWWM_WHR_CLS3_FLD.resetValue();
		COMP_PWWM_WHR_CLS4_FLD.resetValue();
		COMP_PWWM_WHR_CLS5_FLD.resetValue();
		COMP_PWWM_SQL_RETURN_TYPE.resetValue();
		COMP_PWWM_PWB_CODE.resetValue();
	}
	
	public void initializeAllComponents()
	{
		COMP_PWWM_PROCESS_ID = new HtmlInputText(); 
		COMP_PWWM_WORKSTEP_ID = new HtmlInputText(); 
		COMP_PWWM_RULE_ID = new HtmlInputText();    
		COMP_PWWM_RULE_PARAM_ID = new HtmlInputText(); 
		COMP_PWWM_SQL_STMT = new HtmlInputText();  
		COMP_PWWM_TABLE_NAME = new HtmlInputText(); 
		COMP_PWWM_WHR_CLS1_FLD = new HtmlInputText(); 
		COMP_PWWM_WHR_CLS2_FLD = new HtmlInputText(); 
		COMP_PWWM_WHR_CLS3_FLD = new HtmlInputText(); 
		COMP_PWWM_WHR_CLS4_FLD = new HtmlInputText(); 
		COMP_PWWM_WHR_CLS5_FLD = new HtmlInputText(); 
		COMP_PWWM_SQL_RETURN_TYPE = new HtmlInputText(); 
		COMP_PWWM_PWB_CODE = new HtmlInputText(); 
	}
	
	
	private void resetSelectedRow() {
		Iterator<PGIM_WF_WORKSTEP_MAPPING> PGIM_WF_WORKSTEP_MAPPING_ITR = dataTableList.iterator();
		while (PGIM_WF_WORKSTEP_MAPPING_ITR.hasNext()) {
			PGIM_WF_WORKSTEP_MAPPING_ITR.next().setRowSelected(false);
		}
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PGIM_WF_WORKSTEP_MAPPING_BEAN = (PGIM_WF_WORKSTEP_MAPPING) dataTable.getRowData();		
			PGIM_WF_WORKSTEP_MAPPING_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	
	public void addRow(ActionEvent event) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PGIM_WF_WORKSTEP_MAPPING_BEAN = new PGIM_WF_WORKSTEP_MAPPING();
				/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
				helper.whenNewCreateInstance(compositeAction);
				/*end*/
				disableAllComponents(false);
				resetAllComponent();
				resetSelectedRow();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"); 
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
			exc.printStackTrace();
		}

	}
	
	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
		
				new CRUDHandler().executeDelete(PGIM_WF_WORKSTEP_MAPPING_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				dataTableList.remove(PGIM_WF_WORKSTEP_MAPPING_BEAN);
				if (dataTableList.size() > 0) {
					PGIM_WF_WORKSTEP_MAPPING_BEAN = dataTableList.get(0);
				} 
				/* commented by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				else if (dataTableList.size() == 0) {
				addRow(null);
			}
				/*end*/
				resetAllComponent();
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setRowSelected(true);
				CommonUtils.getConnection().commit();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
			}

			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	public void saveRecords(ActionEvent event) {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			if (PGIM_WF_WORKSTEP_MAPPING_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.preinsert(this,PGIM_WF_WORKSTEP_MAPPING_BEAN);
				new CRUDHandler().executeInsert(PGIM_WF_WORKSTEP_MAPPING_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataTableList.add(PGIM_WF_WORKSTEP_MAPPING_BEAN);

			} else if (PGIM_WF_WORKSTEP_MAPPING_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				
				new CRUDHandler().executeUpdate(PGIM_WF_WORKSTEP_MAPPING_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			}
						
			PGIM_WF_WORKSTEP_MAPPING_BEAN.setRowSelected(true);
	
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	
	public void validatorPWWM_PWB_CODE(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_PWB_CODE((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWWM_PROCESS_ID(FacesContext context,
			UIComponent component, Object value){

		try {
			
			CommonUtils.clearMaps(this);
			PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_PROCESS_ID((String) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
	private HtmlInputText COMP_BANK_CONTACT_PERSON;
	private HtmlInputText COMP_BANK_MOBILE;
	private HtmlInputText COMP_BANK_SORT_CODE;
	private HtmlInputText COMP_BANK_LEAD_TIME;


	public HtmlInputText getCOMP_BANK_CONTACT_PERSON() {
		return COMP_BANK_CONTACT_PERSON;
	}

	public void setCOMP_BANK_CONTACT_PERSON(HtmlInputText cOMP_BANK_CONTACT_PERSON) {
		COMP_BANK_CONTACT_PERSON = cOMP_BANK_CONTACT_PERSON;
	}

	public HtmlInputText getCOMP_BANK_MOBILE() {
		return COMP_BANK_MOBILE;
	}

	public void setCOMP_BANK_MOBILE(HtmlInputText cOMP_BANK_MOBILE) {
		COMP_BANK_MOBILE = cOMP_BANK_MOBILE;
	}

	public HtmlInputText getCOMP_BANK_SORT_CODE() {
		return COMP_BANK_SORT_CODE;
	}

	public void setCOMP_BANK_SORT_CODE(HtmlInputText cOMP_BANK_SORT_CODE) {
		COMP_BANK_SORT_CODE = cOMP_BANK_SORT_CODE;
	}

	public HtmlInputText getCOMP_BANK_LEAD_TIME() {
		return COMP_BANK_LEAD_TIME;
	}

	public void setCOMP_BANK_LEAD_TIME(HtmlInputText cOMP_BANK_LEAD_TIME) {
		COMP_BANK_LEAD_TIME = cOMP_BANK_LEAD_TIME;
	} 
	/*end*/
	
	
	public String redirectWorkstepMap(){
		
		//compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().setBlockFlag(true);
		return "WORKFLOW_PGIM_WF_WORKSTEP_MAPPING";
		
	}
	
	


	



	
	public void disableAllComponents(boolean disabled)
	{
		
		COMP_PWWM_RULE_ID.setDisabled(disabled);
		COMP_PWWM_RULE_PARAM_ID.setDisabled(disabled);
		COMP_PWWM_SQL_STMT.setDisabled(disabled); 
		COMP_PWWM_TABLE_NAME.setDisabled(disabled);
		COMP_PWWM_WHR_CLS1_FLD.setDisabled(disabled);
		COMP_PWWM_WHR_CLS2_FLD.setDisabled(disabled);
		COMP_PWWM_WHR_CLS3_FLD.setDisabled(disabled);
		COMP_PWWM_WHR_CLS4_FLD.setDisabled(disabled);
		COMP_PWWM_WHR_CLS5_FLD.setDisabled(disabled);
		COMP_PWWM_SQL_RETURN_TYPE.setDisabled(disabled);
		
	}
	
	List<SelectItem> itemListPWB_ENABLE_YN = null;
	List<SelectItem> itemListPWB_MAIL_ONLY_YN = null;
	List<SelectItem> itemListPWB_SMS_YN = null;
	
	
	
	public List<SelectItem> getItemListPWB_ENABLE_YN() {
		return itemListPWB_ENABLE_YN;
	}

	public void setItemListPWB_ENABLE_YN(List<SelectItem> itemListPWB_ENABLE_YN) {
		this.itemListPWB_ENABLE_YN = itemListPWB_ENABLE_YN;
	}

	public List<SelectItem> getItemListPWB_MAIL_ONLY_YN() {
		return itemListPWB_MAIL_ONLY_YN;
	}

	public void setItemListPWB_MAIL_ONLY_YN(
			List<SelectItem> itemListPWB_MAIL_ONLY_YN) {
		this.itemListPWB_MAIL_ONLY_YN = itemListPWB_MAIL_ONLY_YN;
	}

	public List<SelectItem> getItemListPWB_SMS_YN() {
		return itemListPWB_SMS_YN;
	}

	public void setItemListPWB_SMS_YN(List<SelectItem> itemListPWB_SMS_YN) {
		this.itemListPWB_SMS_YN = itemListPWB_SMS_YN;
	}

	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), formName, blockName, blockFieldName,filedName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return listValues;
	}
	
	
	public String redirectWorkflowBckt(){
		
		return "WORKFLOW_PGIM_WORKFLOW_BUCKET";
	}
	
	
}


