package com.iii.pel.forms.WORKFLOW;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PGIM_WORKFLOW_BUCKET_ACTION extends CommonAction{

	public WORKFLOW_COMPOSITE_ACTION compositeAction;
	
	private PGIM_WORKFLOW_BUCKET_HELPER helper;
	
	private PGIM_WORKFLOW_BUCKET_DELEGATE delegate;
	
	private PGIM_WORKFLOW_BUCKET PGIM_WORKFLOW_BUCKET_BEAN;
	
	private HtmlInputText COMP_PWB_CODE;
	private HtmlInputText COMP_PWB_MAIN_BUKT;
	private HtmlInputText COMP_PWB_WORKSTEP_ID;
	private HtmlInputText COMP_PWB_DESC;
	private HtmlInputText COMP_PWB_SR_NO;
	private HtmlSelectOneMenu COMP_PWB_ENABLE_YN;
	private HtmlInputText COMP_PWB_CR_UID;
	private HtmlInputText COMP_PWB_CR_DT;     
	private HtmlSelectOneMenu COMP_PWB_MAIL_ONLY_YN;
	private HtmlSelectOneMenu COMP_PWB_SMS_YN;
	private HtmlInputText COMP_PWB_OUTCOME_DET;
	private HtmlInputText COMP_PWB_LIMIT_FROM;
	private HtmlInputText COMP_PWB_LIMIT_TO;
	
	private HtmlInputText COMP_PWB_TOBE_OUTCOME;
	
	public HtmlInputText getCOMP_PWB_CODE() {
		return COMP_PWB_CODE;
	}

	public void setCOMP_PWB_CODE(HtmlInputText cOMP_PWB_CODE) {
		COMP_PWB_CODE = cOMP_PWB_CODE;
	}

	public HtmlInputText getCOMP_PWB_MAIN_BUKT() {
		return COMP_PWB_MAIN_BUKT;
	}

	public void setCOMP_PWB_MAIN_BUKT(HtmlInputText cOMP_PWB_MAIN_BUKT) {
		COMP_PWB_MAIN_BUKT = cOMP_PWB_MAIN_BUKT;
	}

	public HtmlInputText getCOMP_PWB_WORKSTEP_ID() {
		return COMP_PWB_WORKSTEP_ID;
	}

	public void setCOMP_PWB_WORKSTEP_ID(HtmlInputText cOMP_PWB_WORKSTEP_ID) {
		COMP_PWB_WORKSTEP_ID = cOMP_PWB_WORKSTEP_ID;
	}

	public HtmlInputText getCOMP_PWB_DESC() {
		return COMP_PWB_DESC;
	}

	public void setCOMP_PWB_DESC(HtmlInputText cOMP_PWB_DESC) {
		COMP_PWB_DESC = cOMP_PWB_DESC;
	}

	public HtmlInputText getCOMP_PWB_SR_NO() {
		return COMP_PWB_SR_NO;
	}

	public void setCOMP_PWB_SR_NO(HtmlInputText cOMP_PWB_SR_NO) {
		COMP_PWB_SR_NO = cOMP_PWB_SR_NO;
	}

	public HtmlSelectOneMenu getCOMP_PWB_ENABLE_YN() {
		return COMP_PWB_ENABLE_YN;
	}

	public void setCOMP_PWB_ENABLE_YN(HtmlSelectOneMenu cOMP_PWB_ENABLE_YN) {
		COMP_PWB_ENABLE_YN = cOMP_PWB_ENABLE_YN;
	}

	public HtmlInputText getCOMP_PWB_CR_UID() {
		return COMP_PWB_CR_UID;
	}

	public void setCOMP_PWB_CR_UID(HtmlInputText cOMP_PWB_CR_UID) {
		COMP_PWB_CR_UID = cOMP_PWB_CR_UID;
	}

	public HtmlInputText getCOMP_PWB_CR_DT() {
		return COMP_PWB_CR_DT;
	}

	public void setCOMP_PWB_CR_DT(HtmlInputText cOMP_PWB_CR_DT) {
		COMP_PWB_CR_DT = cOMP_PWB_CR_DT;
	}

	public HtmlSelectOneMenu getCOMP_PWB_MAIL_ONLY_YN() {
		return COMP_PWB_MAIL_ONLY_YN;
	}

	public void setCOMP_PWB_MAIL_ONLY_YN(HtmlSelectOneMenu cOMP_PWB_MAIL_ONLY_YN) {
		COMP_PWB_MAIL_ONLY_YN = cOMP_PWB_MAIL_ONLY_YN;
	}

	public HtmlSelectOneMenu getCOMP_PWB_SMS_YN() {
		return COMP_PWB_SMS_YN;
	}

	public void setCOMP_PWB_SMS_YN(HtmlSelectOneMenu cOMP_PWB_SMS_YN) {
		COMP_PWB_SMS_YN = cOMP_PWB_SMS_YN;
	}

	public HtmlInputText getCOMP_PWB_OUTCOME_DET() {
		return COMP_PWB_OUTCOME_DET;
	}

	public void setCOMP_PWB_OUTCOME_DET(HtmlInputText cOMP_PWB_OUTCOME_DET) {
		COMP_PWB_OUTCOME_DET = cOMP_PWB_OUTCOME_DET;
	}

	public HtmlInputText getCOMP_PWB_LIMIT_FROM() {
		return COMP_PWB_LIMIT_FROM;
	}

	public void setCOMP_PWB_LIMIT_FROM(HtmlInputText cOMP_PWB_LIMIT_FROM) {
		COMP_PWB_LIMIT_FROM = cOMP_PWB_LIMIT_FROM;
	}

	public HtmlInputText getCOMP_PWB_LIMIT_TO() {
		return COMP_PWB_LIMIT_TO;
	}

	public void setCOMP_PWB_LIMIT_TO(HtmlInputText cOMP_PWB_LIMIT_TO) {
		COMP_PWB_LIMIT_TO = cOMP_PWB_LIMIT_TO;
	}

	public PGIM_WORKFLOW_BUCKET_ACTION()
	{
		PGIM_WORKFLOW_BUCKET_BEAN=new PGIM_WORKFLOW_BUCKET();
		helper = new PGIM_WORKFLOW_BUCKET_HELPER();
		delegate = new PGIM_WORKFLOW_BUCKET_DELEGATE();
		initializeAllComponents();
		
		/*itemListName = getDropDownListValue(
				"PILM107", "PM_BANK", "PM_BANK.BANK_FLEX_10",
				"TITLE");*/
		/*end*/
		
		itemListPWB_ENABLE_YN = getDropDownListValue(
				"WORKFLOW", "PGIM_WORKFLOW_BUCKET", "PGIM_WORKFLOW_BUCKET.PWB_ENABLE_YN",
				"WORK_FLOW");
		itemListPWB_MAIL_ONLY_YN = getDropDownListValue(
				"WORKFLOW", "PGIM_WORKFLOW_BUCKET", "PGIM_WORKFLOW_BUCKET.PWB_MAIL_ONLY_YN",
				"WORK_FLOW");
		itemListPWB_SMS_YN = getDropDownListValue(
				"WORKFLOW", "PGIM_WORKFLOW_BUCKET", "PGIM_WORKFLOW_BUCKET.PWB_SMS_YN",
				"WORK_FLOW");
	}
	
	public PGIM_WORKFLOW_BUCKET_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PGIM_WORKFLOW_BUCKET_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag())
			{
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);	
				/* Modified by kavitha for RoadMap*/
				/*if(PGIM_WORKFLOW_BUCKET_BEAN.getROWID()==null){
					helper.whenNewCreateInstance(compositeAction);
				}*/				
				setBlockFlag(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/* Added by kavitha for RoadMap*/
	 public void reload() throws IOException {
		   setBlockFlag(true);
		   ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		   ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		}
	/*End*/
	
	
	private List<PGIM_WORKFLOW_BUCKET> dataTableList = new ArrayList<PGIM_WORKFLOW_BUCKET>();

	private UIData dataTable;

	

		
	public List<PGIM_WORKFLOW_BUCKET> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PGIM_WORKFLOW_BUCKET> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PGIM_WORKFLOW_BUCKET getPGIM_WORKFLOW_BUCKET_BEAN() {
		return PGIM_WORKFLOW_BUCKET_BEAN;
	}

	public void setPGIM_WORKFLOW_BUCKET_BEAN(PGIM_WORKFLOW_BUCKET pGIM_WORKFLOW_BUCKET_BEAN) {
		PGIM_WORKFLOW_BUCKET_BEAN = pGIM_WORKFLOW_BUCKET_BEAN;
	}

	
	
	public void resetAllComponent()
	{
		COMP_PWB_CODE.resetValue(); 
		COMP_PWB_MAIN_BUKT.resetValue();
		COMP_PWB_WORKSTEP_ID.resetValue();
		COMP_PWB_DESC.resetValue();
		COMP_PWB_SR_NO.resetValue();
		COMP_PWB_ENABLE_YN.resetValue();
		COMP_PWB_CR_UID.resetValue();
		COMP_PWB_CR_DT.resetValue();
		COMP_PWB_MAIL_ONLY_YN.resetValue();
		COMP_PWB_SMS_YN.resetValue();
		COMP_PWB_OUTCOME_DET.resetValue();
		COMP_PWB_LIMIT_FROM.resetValue();
		COMP_PWB_LIMIT_TO.resetValue();
		//Added by kavitha on 01.11.2019 for Roadmap
		COMP_PWB_TOBE_OUTCOME.resetValue();
		//Added by kavitha on 21.11.2019 for Roadmap
		COMP_PWB_STATUS_CODE.resetValue();
		COMP_UI_M_PWB_STATUS_CODE_DESC.resetValue();
	}
	
	public void initializeAllComponents()
	{
		COMP_PWB_CODE = new HtmlInputText(); 
		COMP_PWB_MAIN_BUKT = new HtmlInputText();
		COMP_PWB_WORKSTEP_ID = new HtmlInputText();
		COMP_PWB_DESC = new HtmlInputText();
		COMP_PWB_SR_NO = new HtmlInputText();
		COMP_PWB_ENABLE_YN = new HtmlSelectOneMenu();
		COMP_PWB_CR_UID = new HtmlInputText();
		COMP_PWB_CR_DT = new HtmlInputText();
		COMP_PWB_MAIL_ONLY_YN = new HtmlSelectOneMenu();
		COMP_PWB_SMS_YN = new HtmlSelectOneMenu();
		COMP_PWB_OUTCOME_DET = new HtmlInputText();
		COMP_PWB_LIMIT_FROM = new HtmlInputText();
		COMP_PWB_LIMIT_TO = new HtmlInputText();
		//Added by kavitha on 01.11.2019 for Roadmap
		COMP_PWB_TOBE_OUTCOME= new HtmlInputText();
		//Added by kavitha on 21.11.2019 for Roadmap
		COMP_PWB_STATUS_CODE= new HtmlInputText();
		COMP_UI_M_PWB_STATUS_CODE_DESC= new HtmlInputText();
	}
	
	
	private void resetSelectedRow() {
		Iterator<PGIM_WORKFLOW_BUCKET> PGIM_WORKFLOW_BUCKET_ITR = dataTableList.iterator();
		while (PGIM_WORKFLOW_BUCKET_ITR.hasNext()) {
			PGIM_WORKFLOW_BUCKET_ITR.next().setRowSelected(false);
		}
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PGIM_WORKFLOW_BUCKET_BEAN = (PGIM_WORKFLOW_BUCKET) dataTable.getRowData();		
			PGIM_WORKFLOW_BUCKET_BEAN.setRowSelected(true);
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
				PGIM_WORKFLOW_BUCKET_BEAN = new PGIM_WORKFLOW_BUCKET();
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
	/* Modified by kavitha for RoadMap*/
	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
                if (isDELETE_ALLOWED()) {
				
				new CRUDHandler().executeDelete(PGIM_WORKFLOW_BUCKET_BEAN,
						CommonUtils.getConnection());
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
				dataTableList.remove(PGIM_WORKFLOW_BUCKET_BEAN);
				if (dataTableList.size() > 0) {

					PGIM_WORKFLOW_BUCKET_BEAN = dataTableList
							.get(0);
				} else if (dataTableList.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PGIM_WORKFLOW_BUCKET_BEAN.setRowSelected(true);
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

             CommonUtils.getConnection().commit();     
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	public void saveRecords(ActionEvent event) {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
 			if (PGIM_WORKFLOW_BUCKET_BEAN.getROWID() == null
  					&& isINSERT_ALLOWED()) {
 				Connection connection = null;
				ResultSet resultSet = null;
				String M_PWB_CODE = null;
				String CURSOR_C1 = "SELECT 'X' FROM  PGIM_WORKFLOW_BUCKET WHERE  PWB_CODE = ? ";
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1,
										connection, new Object[] {PGIM_WORKFLOW_BUCKET_BEAN.getPWB_CODE()});
								if (resultSet.next()) {
									M_PWB_CODE = resultSet.getString(1);
									throw new ValidatorException(
											new FacesMessage(
													Messages
													.getString(
															PELConstants.pelErrorMessagePath,
															"90015",
														new Object[] { "Code" })));
								}else{

									new CRUDHandler().executeInsert(PGIM_WORKFLOW_BUCKET_BEAN,
											CommonUtils.getConnection());
								}
			
				
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataTableList.add(PGIM_WORKFLOW_BUCKET_BEAN);
				
				
				
			} else if (PGIM_WORKFLOW_BUCKET_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
			/*	Connection connection = null;
				ResultSet resultSet = null;
				String M_PWB_CODE = null;
				String CURSOR_C1 = "SELECT 'X' FROM  PGIM_WORKFLOW_BUCKET WHERE  PWB_CODE = ? ";
				connection = CommonUtils.getConnection();
				
				resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1,
						connection, new Object[] {PGIM_WORKFLOW_BUCKET_BEAN.getPWB_CODE()});
						
			
				
				if (resultSet.next()) {
						M_PWB_CODE = resultSet.getString(1);
							throw new ValidatorException(
									new FacesMessage(
											Messages
											.getString(
													PELConstants.pelErrorMessagePath,
													"90015",
												new Object[] { "Code" })));
						}else{*/
					
								new CRUDHandler().executeUpdate(PGIM_WORKFLOW_BUCKET_BEAN,
										CommonUtils.getConnection());
					/*	}*/
						
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
			}
			CommonUtils.getConnection().commit();
			PGIM_WORKFLOW_BUCKET_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	
	/*End*/
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	
	public void validatorPWB_CODE(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WORKFLOW_BUCKET_BEAN.setPWB_CODE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWB_MAIN_BUKT(FacesContext context,
			UIComponent component, Object value){

		try {
			
			CommonUtils.clearMaps(this);
			PGIM_WORKFLOW_BUCKET_BEAN.setPWB_MAIN_BUKT((String) value);
			
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
		
		compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().setBlockFlag(true);
		return "WORKFLOW_PGIM_WF_WORKSTEP_MAPPING";
		
	}
	
	public void disableAllComponents(boolean disabled)
	{
		COMP_PWB_CODE.setDisabled(disabled);
		COMP_PWB_MAIN_BUKT.setDisabled(disabled);
		COMP_PWB_WORKSTEP_ID.setDisabled(disabled);
		COMP_PWB_DESC.setDisabled(disabled);
		COMP_PWB_SR_NO.setDisabled(disabled);
		COMP_PWB_ENABLE_YN.setDisabled(disabled);
		COMP_PWB_CR_UID.setDisabled(disabled);
		COMP_PWB_CR_DT.setDisabled(disabled);
		COMP_PWB_MAIL_ONLY_YN.setDisabled(disabled);
		COMP_PWB_SMS_YN.setDisabled(disabled);
		COMP_PWB_OUTCOME_DET.setDisabled(disabled);
		COMP_PWB_LIMIT_FROM.setDisabled(disabled);
		COMP_PWB_LIMIT_TO.setDisabled(disabled);
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
	
	
	public void validatorPWB_ENABLE_YN(FacesContext context,
			UIComponent component, Object value){

		try {
			
			CommonUtils.clearMaps(this);
			PGIM_WORKFLOW_BUCKET_BEAN.setPWB_ENABLE_YN((String) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWB_SMS_YN(FacesContext context,
			UIComponent component, Object value){

		try {
			
			CommonUtils.clearMaps(this);
			PGIM_WORKFLOW_BUCKET_BEAN.setPWB_SMS_YN((String) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorPWB_MAIL_ONLY_YN(FacesContext context,
			UIComponent component, Object value){

		try {
			
			CommonUtils.clearMaps(this);
			PGIM_WORKFLOW_BUCKET_BEAN.setPWB_MAIL_ONLY_YN((String) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String redirectMailUserGroupMap(){
		
		compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().setBlockFlag(true);
		return "WORKFLOW_PGIM_WF_MAIL_USGRP";
		
	}

	public HtmlInputText getCOMP_PWB_TOBE_OUTCOME() {
		return COMP_PWB_TOBE_OUTCOME;
	}

	public void setCOMP_PWB_TOBE_OUTCOME(HtmlInputText cOMP_PWB_TOBE_OUTCOME) {
		COMP_PWB_TOBE_OUTCOME = cOMP_PWB_TOBE_OUTCOME;
	}
	//Added by kavitha on 21.11.2019 for Roadmap
	private HtmlOutputLabel COMP_PWB_STATUS_CODE_LABEL;
	private HtmlInputText COMP_PWB_STATUS_CODE;
	private HtmlInputText COMP_UI_M_PWB_STATUS_CODE_DESC;
	public ArrayList<LovBean> lovPWB_STATUS_CODE(Object object) {
		 ArrayList<LovBean> suggestionList = null;
	    	String query1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM1 WHERE PS_TYPE='IL_ADDL_STAT' AND "
	    			+ "(UPPER(PS_CODE) LIKE UPPER(?) OR UPPER(PS_CODE_DESC) LIKE UPPER(?) ) AND ROWNUM < ? ORDER BY 1";
			try {
				String currentValue = (String) object;
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
	
				suggestionList = ListItemUtil.prepareSuggestionList(query1,
						new Object[] { currentValue, currentValue,
						PELConstants.suggetionRecordSize });
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return suggestionList;
	    }
	
	
	public void validatePWB_STATUS_CODE(FacesContext context,
			UIComponent component, Object value) {
		
		try {
			PGIM_WORKFLOW_BUCKET_BEAN.setPWB_STATUS_CODE((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public HtmlOutputLabel getCOMP_PWB_STATUS_CODE_LABEL() {
		return COMP_PWB_STATUS_CODE_LABEL;
	}

	public void setCOMP_PWB_STATUS_CODE_LABEL(
			HtmlOutputLabel cOMP_PWB_STATUS_CODE_LABEL) {
		COMP_PWB_STATUS_CODE_LABEL = cOMP_PWB_STATUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PWB_STATUS_CODE() {
		return COMP_PWB_STATUS_CODE;
	}

	public void setCOMP_PWB_STATUS_CODE(HtmlInputText cOMP_PWB_STATUS_CODE) {
		COMP_PWB_STATUS_CODE = cOMP_PWB_STATUS_CODE;
	}

	public HtmlInputText getCOMP_UI_M_PWB_STATUS_CODE_DESC() {
		return COMP_UI_M_PWB_STATUS_CODE_DESC;
	}

	public void setCOMP_UI_M_PWB_STATUS_CODE_DESC(
			HtmlInputText cOMP_UI_M_PWB_STATUS_CODE_DESC) {
		COMP_UI_M_PWB_STATUS_CODE_DESC = cOMP_UI_M_PWB_STATUS_CODE_DESC;
	}
	
	
	
	
}


