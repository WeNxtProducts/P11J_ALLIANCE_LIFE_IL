package com.iii.pel.forms.WORKFLOW;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
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

    public class PGIM_WF_MAIL_USGRP_ACTION extends CommonAction {
	
    public WORKFLOW_COMPOSITE_ACTION compositeAction;
	
	private PGIM_WF_MAIL_USGRP_HELPER helper;
	
	private PGIM_WF_MAIL_USGRP_DELEGATE delegate;
	
	private PGIM_WF_MAIL_USGRP PGIM_WF_MAIL_USGRP_BEAN;
	
	
	public WORKFLOW_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(WORKFLOW_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PGIM_WF_MAIL_USGRP_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PGIM_WF_MAIL_USGRP_HELPER helper) {
		this.helper = helper;
	}


	public PGIM_WF_MAIL_USGRP_DELEGATE getDelegate() {
		return delegate;
	}


	public void setDelegate(PGIM_WF_MAIL_USGRP_DELEGATE delegate) {
		this.delegate = delegate;
	}


	public PGIM_WF_MAIL_USGRP getPGIM_WF_MAIL_USGRP_BEAN() {
		return PGIM_WF_MAIL_USGRP_BEAN;
	}


	public void setPGIM_WF_MAIL_USGRP_BEAN(
			PGIM_WF_MAIL_USGRP pGIM_WF_MAIL_USGRP_BEAN) {
		PGIM_WF_MAIL_USGRP_BEAN = pGIM_WF_MAIL_USGRP_BEAN;
	}

	private List<PGIM_WF_MAIL_USGRP> dataTableList = new ArrayList<PGIM_WF_MAIL_USGRP>();
	private UIData dataTable;

	public List<PGIM_WF_MAIL_USGRP> getDataTableList() {
		return dataTableList;
	}


	public void setDataTableList(List<PGIM_WF_MAIL_USGRP> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public PGIM_WF_MAIL_USGRP_ACTION()
	{
		PGIM_WF_MAIL_USGRP_BEAN=new PGIM_WF_MAIL_USGRP();
		helper = new PGIM_WF_MAIL_USGRP_HELPER();
		delegate = new PGIM_WF_MAIL_USGRP_DELEGATE();
		initializeAllComponents();
		setListItemValues();
		
	}

	 
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag())
			{
				
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
					
				if(PGIM_WF_MAIL_USGRP_BEAN.getROWID()==null){
					helper.whenNewCreateInstance(compositeAction);
				}
				System.out.println("Row id"+PGIM_WF_MAIL_USGRP_BEAN.getROWID());
				setBlockFlag(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void resetAllComponent()
	{
		COMP_PWMU_APPR_STS.resetValue(); 
		COMP_PWMU_POL_WF_STS.resetValue();
		COMP_PWMU_MAIL_USGRP.resetValue();
		COMP_PWMU_USGRP_TO_MODIFY.resetValue();
		COMP_PWMU_ESC_USGRP_1.resetValue();
		COMP_PWMU_ESC_USGRP_2.resetValue();
		COMP_PWMU_PWB_BUKT_CODE.resetValue();
		COMP_PWMU_MAIL_MESSAGE.resetValue();
		COMP_PWMU_MAIL_SUBJECT.resetValue();
		COMP_PWMU_LIMIT_FROM.resetValue();
		COMP_PWMU_LIMIT_TO.resetValue();
		/* Added by kavitha for RoadMap on 20.11.2018*/
		COMP_PWMU_ESC_DAYS.resetValue();
		COMP_PWMU_ESC_MESSAGE.resetValue();
		COMP_PWMU_ESC_LIMIT_TYP.resetValue();
		/*End*/
	}
	
	
	public void initializeAllComponents()

	{

		//OutputLabel

		COMP_PWMU_APPR_STS_LABEL = new HtmlOutputLabel();
		COMP_PWMU_POL_WF_STS_LABEL = new HtmlOutputLabel();
		COMP_PWMU_MAIL_USGRP_LABEL = new HtmlOutputLabel();
		COMP_PWMU_USGRP_TO_MODIFY_LABEL = new HtmlOutputLabel();
		COMP_PWMU_ESC_USGRP_1_LABEL = new HtmlOutputLabel();
		COMP_PWMU_ESC_USGRP_2_LABEL = new HtmlOutputLabel();

		//InputText

		COMP_PWMU_APPR_STS = new HtmlInputText(); 
		COMP_PWMU_POL_WF_STS = new HtmlInputText();
		COMP_PWMU_MAIL_USGRP = new HtmlInputText();
		COMP_PWMU_USGRP_TO_MODIFY = new HtmlInputText();
		COMP_PWMU_ESC_USGRP_1 = new HtmlInputText();
		COMP_PWMU_ESC_USGRP_2 = new HtmlInputText();
		COMP_PWMU_PWB_BUKT_CODE = new HtmlInputText();
		
		COMP_PWMU_MAIL_MESSAGE = new HtmlInputText(); 
		COMP_PWMU_MAIL_SUBJECT = new HtmlInputText(); 
		COMP_PWMU_LIMIT_FROM = new HtmlInputText(); 
		COMP_PWMU_LIMIT_TO = new HtmlInputText(); 
		/* Added by kavitha for RoadMap on 20.11.2018*/
		COMP_PWMU_ESC_DAYS = new HtmlInputText(); 
		COMP_PWMU_ESC_MESSAGE = new HtmlInputTextarea(); 
		COMP_PWMU_ESC_DAYS_LABEL = new HtmlOutputLabel();
		COMP_PWMU_ESC_MESSAGE_LABEL = new HtmlOutputLabel();
		COMP_PWMU_ESC_LIMIT_TYP = new HtmlSelectOneMenu();
		/*End*/
	}
	
	
	private void resetSelectedRow() {
		Iterator<PGIM_WF_MAIL_USGRP> WF_MAIL_USGRP = dataTableList.iterator();
		while (WF_MAIL_USGRP.hasNext()) {
			WF_MAIL_USGRP.next().setRowSelected(false);
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PGIM_WF_MAIL_USGRP_BEAN = (PGIM_WF_MAIL_USGRP) dataTable.getRowData();		
			PGIM_WF_MAIL_USGRP_BEAN.setRowSelected(true);
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
				PGIM_WF_MAIL_USGRP_BEAN = new PGIM_WF_MAIL_USGRP();
				helper.whenNewCreateInstance(compositeAction);

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

				new CRUDHandler().executeDelete(PGIM_WF_MAIL_USGRP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				dataTableList.remove(PGIM_WF_MAIL_USGRP_BEAN);
				if (dataTableList.size() > 0) {
					PGIM_WF_MAIL_USGRP_BEAN = dataTableList.get(0);
				} 
				else if (dataTableList.size() == 0) {
					addRow(null);
				}

				resetAllComponent();
				PGIM_WF_MAIL_USGRP_BEAN.setRowSelected(true);
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
			if (PGIM_WF_MAIL_USGRP_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PGIM_WF_MAIL_USGRP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataTableList.add(PGIM_WF_MAIL_USGRP_BEAN);

			} else if (PGIM_WF_MAIL_USGRP_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PGIM_WF_MAIL_USGRP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			}

			PGIM_WF_MAIL_USGRP_BEAN.setRowSelected(true);

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
	
	public void disableAllComponents(boolean disabled)
	{
		COMP_PWMU_APPR_STS.setDisabled(disabled);
		COMP_PWMU_POL_WF_STS.setDisabled(disabled);
		COMP_PWMU_MAIL_USGRP.setDisabled(disabled);
		COMP_PWMU_USGRP_TO_MODIFY.setDisabled(disabled);
		COMP_PWMU_ESC_USGRP_1.setDisabled(disabled);
		COMP_PWMU_ESC_USGRP_2.setDisabled(disabled);
		COMP_PWMU_MAIL_MESSAGE.setDisabled(disabled);
		COMP_PWMU_MAIL_SUBJECT.setDisabled(disabled);
		COMP_PWMU_LIMIT_FROM.setDisabled(disabled);
		COMP_PWMU_LIMIT_TO.setDisabled(disabled);
		
	}
	
	
	private HtmlOutputLabel COMP_PWMU_APPR_STS_LABEL;
	private HtmlInputText COMP_PWMU_APPR_STS;
	private HtmlOutputLabel COMP_PWMU_POL_WF_STS_LABEL;
	private HtmlInputText COMP_PWMU_POL_WF_STS;
	private HtmlOutputLabel COMP_PWMU_MAIL_USGRP_LABEL;
	private HtmlInputText COMP_PWMU_MAIL_USGRP;
	private HtmlOutputLabel COMP_PWMU_USGRP_TO_MODIFY_LABEL;
	private HtmlInputText COMP_PWMU_USGRP_TO_MODIFY;
	private HtmlOutputLabel COMP_PWMU_ESC_USGRP_1_LABEL;
	private HtmlInputText COMP_PWMU_ESC_USGRP_1;
	private HtmlOutputLabel COMP_PWMU_ESC_USGRP_2_LABEL;
	private HtmlInputText COMP_PWMU_ESC_USGRP_2;
	private HtmlInputText COMP_PWMU_PWB_BUKT_CODE;
	
	private HtmlInputText COMP_PWMU_MAIL_MESSAGE;
	private HtmlInputText COMP_PWMU_MAIL_SUBJECT;
	private HtmlInputText COMP_PWMU_LIMIT_FROM;
	private HtmlInputText COMP_PWMU_LIMIT_TO;
	public HtmlInputText getCOMP_PWMU_MAIL_MESSAGE() {
		return COMP_PWMU_MAIL_MESSAGE;
	}


	public void setCOMP_PWMU_MAIL_MESSAGE(HtmlInputText cOMP_PWMU_MAIL_MESSAGE) {
		COMP_PWMU_MAIL_MESSAGE = cOMP_PWMU_MAIL_MESSAGE;
	}


	public HtmlInputText getCOMP_PWMU_MAIL_SUBJECT() {
		return COMP_PWMU_MAIL_SUBJECT;
	}


	public void setCOMP_PWMU_MAIL_SUBJECT(HtmlInputText cOMP_PWMU_MAIL_SUBJECT) {
		COMP_PWMU_MAIL_SUBJECT = cOMP_PWMU_MAIL_SUBJECT;
	}


	public HtmlInputText getCOMP_PWMU_LIMIT_FROM() {
		return COMP_PWMU_LIMIT_FROM;
	}


	public void setCOMP_PWMU_LIMIT_FROM(HtmlInputText cOMP_PWMU_LIMIT_FROM) {
		COMP_PWMU_LIMIT_FROM = cOMP_PWMU_LIMIT_FROM;
	}


	public HtmlInputText getCOMP_PWMU_LIMIT_TO() {
		return COMP_PWMU_LIMIT_TO;
	}


	public void setCOMP_PWMU_LIMIT_TO(HtmlInputText cOMP_PWMU_LIMIT_TO) {
		COMP_PWMU_LIMIT_TO = cOMP_PWMU_LIMIT_TO;
	}

	
	
	
	public HtmlInputText getCOMP_PWMU_PWB_BUKT_CODE() {
		return COMP_PWMU_PWB_BUKT_CODE;
	}


	public void setCOMP_PWMU_PWB_BUKT_CODE(HtmlInputText cOMP_PWMU_PWB_BUKT_CODE) {
		COMP_PWMU_PWB_BUKT_CODE = cOMP_PWMU_PWB_BUKT_CODE;
	}


	public HtmlOutputLabel getCOMP_PWMU_APPR_STS_LABEL() {
		return COMP_PWMU_APPR_STS_LABEL;
	}


	public void setCOMP_PWMU_APPR_STS_LABEL(HtmlOutputLabel cOMP_PWMU_APPR_STS_LABEL) {
		COMP_PWMU_APPR_STS_LABEL = cOMP_PWMU_APPR_STS_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_APPR_STS() {
		return COMP_PWMU_APPR_STS;
	}


	public void setCOMP_PWMU_APPR_STS(HtmlInputText cOMP_PWMU_APPR_STS) {
		COMP_PWMU_APPR_STS = cOMP_PWMU_APPR_STS;
	}


	public HtmlOutputLabel getCOMP_PWMU_POL_WF_STS_LABEL() {
		return COMP_PWMU_POL_WF_STS_LABEL;
	}


	public void setCOMP_PWMU_POL_WF_STS_LABEL(
			HtmlOutputLabel cOMP_PWMU_POL_WF_STS_LABEL) {
		COMP_PWMU_POL_WF_STS_LABEL = cOMP_PWMU_POL_WF_STS_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_POL_WF_STS() {
		return COMP_PWMU_POL_WF_STS;
	}


	public void setCOMP_PWMU_POL_WF_STS(HtmlInputText cOMP_PWMU_POL_WF_STS) {
		COMP_PWMU_POL_WF_STS = cOMP_PWMU_POL_WF_STS;
	}


	public HtmlOutputLabel getCOMP_PWMU_MAIL_USGRP_LABEL() {
		return COMP_PWMU_MAIL_USGRP_LABEL;
	}


	public void setCOMP_PWMU_MAIL_USGRP_LABEL(
			HtmlOutputLabel cOMP_PWMU_MAIL_USGRP_LABEL) {
		COMP_PWMU_MAIL_USGRP_LABEL = cOMP_PWMU_MAIL_USGRP_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_MAIL_USGRP() {
		return COMP_PWMU_MAIL_USGRP;
	}


	public void setCOMP_PWMU_MAIL_USGRP(HtmlInputText cOMP_PWMU_MAIL_USGRP) {
		COMP_PWMU_MAIL_USGRP = cOMP_PWMU_MAIL_USGRP;
	}


	public HtmlOutputLabel getCOMP_PWMU_USGRP_TO_MODIFY_LABEL() {
		return COMP_PWMU_USGRP_TO_MODIFY_LABEL;
	}


	public void setCOMP_PWMU_USGRP_TO_MODIFY_LABEL(
			HtmlOutputLabel cOMP_PWMU_USGRP_TO_MODIFY_LABEL) {
		COMP_PWMU_USGRP_TO_MODIFY_LABEL = cOMP_PWMU_USGRP_TO_MODIFY_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_USGRP_TO_MODIFY() {
		return COMP_PWMU_USGRP_TO_MODIFY;
	}


	public void setCOMP_PWMU_USGRP_TO_MODIFY(HtmlInputText cOMP_PWMU_USGRP_TO_MODIFY) {
		COMP_PWMU_USGRP_TO_MODIFY = cOMP_PWMU_USGRP_TO_MODIFY;
	}


	public HtmlOutputLabel getCOMP_PWMU_ESC_USGRP_1_LABEL() {
		return COMP_PWMU_ESC_USGRP_1_LABEL;
	}


	public void setCOMP_PWMU_ESC_USGRP_1_LABEL(
			HtmlOutputLabel cOMP_PWMU_ESC_USGRP_1_LABEL) {
		COMP_PWMU_ESC_USGRP_1_LABEL = cOMP_PWMU_ESC_USGRP_1_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_ESC_USGRP_1() {
		return COMP_PWMU_ESC_USGRP_1;
	}


	public void setCOMP_PWMU_ESC_USGRP_1(HtmlInputText cOMP_PWMU_ESC_USGRP_1) {
		COMP_PWMU_ESC_USGRP_1 = cOMP_PWMU_ESC_USGRP_1;
	}


	public HtmlOutputLabel getCOMP_PWMU_ESC_USGRP_2_LABEL() {
		return COMP_PWMU_ESC_USGRP_2_LABEL;
	}


	public void setCOMP_PWMU_ESC_USGRP_2_LABEL(
			HtmlOutputLabel cOMP_PWMU_ESC_USGRP_2_LABEL) {
		COMP_PWMU_ESC_USGRP_2_LABEL = cOMP_PWMU_ESC_USGRP_2_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_ESC_USGRP_2() {
		return COMP_PWMU_ESC_USGRP_2;
	}


	public void setCOMP_PWMU_ESC_USGRP_2(HtmlInputText cOMP_PWMU_ESC_USGRP_2) {
		COMP_PWMU_ESC_USGRP_2 = cOMP_PWMU_ESC_USGRP_2;
	}


	public void validatorPWMU_APPR_STS(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_APPR_STS((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorPWMU_POL_WF_STS(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_POL_WF_STS((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorPWMU_MAIL_USGRP(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_USGRP((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorPWMU_USGRP_TO_MODIFY(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_USGRP_TO_MODIFY((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorPWMU_ESC_USGRP_1(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_USGRP_1((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorPWMU_ESC_USGRP_2(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_USGRP_2((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
		
	public String redirectWorkflowBckt(){
		
		return "WORKFLOW_PGIM_WORKFLOW_BUCKET";
	}

	public void validatorPWMU_MAIL_MESSAGE(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_MESSAGE((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWMU_MAIL_SUBJECT(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_SUBJECT((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWMU_LIMIT_FROM(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_LIMIT_FROM((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWMU_LIMIT_TO(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_LIMIT_TO((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
  /* Added by kavitha for RoadMap on 20.11.2018*/
	private HtmlOutputLabel COMP_PWMU_ESC_DAYS_LABEL;
	private HtmlOutputLabel COMP_PWMU_ESC_MESSAGE_LABEL;
	private HtmlInputText COMP_PWMU_ESC_DAYS;
	private HtmlInputTextarea COMP_PWMU_ESC_MESSAGE;
	private HtmlInputText COMP_PWMU_ESC_MAIL_SUBJECT;

	public HtmlOutputLabel getCOMP_PWMU_ESC_DAYS_LABEL() {
		return COMP_PWMU_ESC_DAYS_LABEL;
	}


	public void setCOMP_PWMU_ESC_DAYS_LABEL(HtmlOutputLabel cOMP_PWMU_ESC_DAYS_LABEL) {
		COMP_PWMU_ESC_DAYS_LABEL = cOMP_PWMU_ESC_DAYS_LABEL;
	}


	public HtmlOutputLabel getCOMP_PWMU_ESC_MESSAGE_LABEL() {
		return COMP_PWMU_ESC_MESSAGE_LABEL;
	}


	public void setCOMP_PWMU_ESC_MESSAGE_LABEL(
			HtmlOutputLabel cOMP_PWMU_ESC_MESSAGE_LABEL) {
		COMP_PWMU_ESC_MESSAGE_LABEL = cOMP_PWMU_ESC_MESSAGE_LABEL;
	}


	public HtmlInputText getCOMP_PWMU_ESC_DAYS() {
		return COMP_PWMU_ESC_DAYS;
	}


	public void setCOMP_PWMU_ESC_DAYS(HtmlInputText cOMP_PWMU_ESC_DAYS) {
		COMP_PWMU_ESC_DAYS = cOMP_PWMU_ESC_DAYS;
	}


	public HtmlInputTextarea getCOMP_PWMU_ESC_MESSAGE() {
		return COMP_PWMU_ESC_MESSAGE;
	}


	public void setCOMP_PWMU_ESC_MESSAGE(HtmlInputTextarea cOMP_PWMU_ESC_MESSAGE) {
		COMP_PWMU_ESC_MESSAGE = cOMP_PWMU_ESC_MESSAGE;
	}
	
	public void validatorPWMU_ESC_DAYS(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_LIMIT((int) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWMU_ESC_MESSAGE(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_ESC_MESSAGE((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorPWMU_ESC_MAIL_SUBJECT(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_MAIL_ESC_SUBJECT((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public HtmlInputText getCOMP_PWMU_ESC_MAIL_SUBJECT() {
		return COMP_PWMU_ESC_MAIL_SUBJECT;
	}


	public void setCOMP_PWMU_ESC_MAIL_SUBJECT(
			HtmlInputText cOMP_PWMU_ESC_MAIL_SUBJECT) {
		COMP_PWMU_ESC_MAIL_SUBJECT = cOMP_PWMU_ESC_MAIL_SUBJECT;
	}
	
	
	public HtmlSelectOneMenu getCOMP_PWMU_ESC_LIMIT_TYP() {
		return COMP_PWMU_ESC_LIMIT_TYP;
	}


	public void setCOMP_PWMU_ESC_LIMIT_TYP(HtmlSelectOneMenu cOMP_PWMU_ESC_LIMIT_TYP) {
		COMP_PWMU_ESC_LIMIT_TYP = cOMP_PWMU_ESC_LIMIT_TYP;
	}

	private HtmlSelectOneMenu COMP_PWMU_ESC_LIMIT_TYP;
	private List<SelectItem> itemListPWMU_ESC_LIMIT_TYP = new ArrayList<SelectItem>();
	
	
	public void validatorPWMU_ESC_LIMIT_TYP(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PGIM_WF_MAIL_USGRP_BEAN.setPWMU_ESC_LMT_TYP((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public List<SelectItem> getItemListPWMU_ESC_LIMIT_TYP() {
		if (itemListPWMU_ESC_LIMIT_TYP.size() == 0) {
			itemListPWMU_ESC_LIMIT_TYP.clear();
			try {
				itemListPWMU_ESC_LIMIT_TYP = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemListPWMU_ESC_LIMIT_TYP;
	}


	public void setItemListPWMU_ESC_LIMIT_TYP(
			List<SelectItem> itemListPWMU_ESC_LIMIT_TYP) {
		this.itemListPWMU_ESC_LIMIT_TYP = itemListPWMU_ESC_LIMIT_TYP;
	}

	 public void setListItemValues() {
			Connection connection = null;
			try {
			    connection = CommonUtils.getConnection();
			    setItemListPWMU_ESC_LIMIT_TYP(ListItemUtil.getDropDownListValue(
					    connection, "WORKFLOW", "PGIM_WF_MAIL_USGRP",
					    "PGIM_WF_MAIL_USGRP.PWMU_ESC_LMT_TYP", "ESC_TYPE"));
			    
			} catch (Exception e) {
			    e.printStackTrace();
			}
	  }
	
	/*End*/


	
	
}
