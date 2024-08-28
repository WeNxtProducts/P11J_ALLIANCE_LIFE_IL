package com.iii.pel.forms.PILM086_APAC;


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
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_VAL_RNG_DTLS_ACTION extends CommonAction{
	
	
	private HtmlOutputLabel COMP_BRD3_DTL_SNO_LABEL;
	
	private HtmlInputText COMP_BRD3_DTL_SNO;
	
	private HtmlOutputLabel COMP_BRD3_VALUE_FM_LABEL;
	
	private HtmlInputText COMP_BRD3_VALUE_FM;
	
	private HtmlOutputLabel COMP_BRD3_VALUE_TO_LABEL;
	
	private HtmlInputText COMP_BRD3_VALUE_TO;
	
	private HtmlCalendar COMP_BRD3_DATE_FM;
	
	private HtmlOutputLabel COMP_BRD3_DATE_FM_LABEL;
	
	private HtmlOutputLabel COMP_BRD3_DATE_TO_LABEL;
	
	private HtmlCalendar COMP_BRD3_DATE_TO;
	
	PILM086_VAL_RNG_DTLS_BEAN VAL_BEAN ;
	
	PILM086_VAL_RNG_DTLS_HELPER VAL_HELPER;
	
	private UIData dataTable;

	public PILM086_APAC_COMPOSITE_ACTION compositeAction;

	private List<PILM086_VAL_RNG_DTLS_BEAN> dataList_PILM086_VAL_RNG_DTLS_BEAN = new ArrayList<PILM086_VAL_RNG_DTLS_BEAN>();
	
	
	public PILM086_VAL_RNG_DTLS_HELPER getVAL_HELPER() {
		return VAL_HELPER;
	}
	public void setVAL_HELPER(PILM086_VAL_RNG_DTLS_HELPER vAL_HELPER) {
		VAL_HELPER = vAL_HELPER;
	}
	public List<PILM086_VAL_RNG_DTLS_BEAN> getDataList_PILM086_VAL_RNG_DTLS_BEAN() {
		return dataList_PILM086_VAL_RNG_DTLS_BEAN;
	}
	public void setDataList_PILM086_VAL_RNG_DTLS_BEAN(
			List<PILM086_VAL_RNG_DTLS_BEAN> dataList_PILM086_VAL_RNG_DTLS_BEAN) {
		this.dataList_PILM086_VAL_RNG_DTLS_BEAN = dataList_PILM086_VAL_RNG_DTLS_BEAN;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public HtmlInputText getCOMP_BRD3_DTL_SNO() {
		return COMP_BRD3_DTL_SNO;
	}
	public void setCOMP_BRD3_DTL_SNO(HtmlInputText cOMP_BRD3_DTL_SNO) {
		COMP_BRD3_DTL_SNO = cOMP_BRD3_DTL_SNO;
	}
	public HtmlOutputLabel getCOMP_BRD3_DTL_SNO_LABEL() {
		return COMP_BRD3_DTL_SNO_LABEL;
	}
	public void setCOMP_BRD3_DTL_SNO_LABEL(HtmlOutputLabel cOMP_BRD3_DTL_SNO_LABEL) {
		COMP_BRD3_DTL_SNO_LABEL = cOMP_BRD3_DTL_SNO_LABEL;
	}
	
	public HtmlOutputLabel getCOMP_BRD3_VALUE_FM_LABEL() {
		return COMP_BRD3_VALUE_FM_LABEL;
	}
	public void setCOMP_BRD3_VALUE_FM_LABEL(HtmlOutputLabel cOMP_BRD3_VALUE_FM_LABEL) {
		COMP_BRD3_VALUE_FM_LABEL = cOMP_BRD3_VALUE_FM_LABEL;
	}
	public HtmlInputText getCOMP_BRD3_VALUE_FM() {
		return COMP_BRD3_VALUE_FM;
	}
	public void setCOMP_BRD3_VALUE_FM(HtmlInputText cOMP_BRD3_VALUE_FM) {
		COMP_BRD3_VALUE_FM = cOMP_BRD3_VALUE_FM;
	}
	public HtmlOutputLabel getCOMP_BRD3_VALUE_TO_LABEL() {
		return COMP_BRD3_VALUE_TO_LABEL;
	}
	public void setCOMP_BRD3_VALUE_TO_LABEL(HtmlOutputLabel cOMP_BRD3_VALUE_TO_LABEL) {
		COMP_BRD3_VALUE_TO_LABEL = cOMP_BRD3_VALUE_TO_LABEL;
	}
	public HtmlInputText getCOMP_BRD3_VALUE_TO() {
		return COMP_BRD3_VALUE_TO;
	}
	public void setCOMP_BRD3_VALUE_TO(HtmlInputText cOMP_BRD3_VALUE_TO) {
		COMP_BRD3_VALUE_TO = cOMP_BRD3_VALUE_TO;
	}
	public HtmlCalendar getCOMP_BRD3_DATE_FM() {
		return COMP_BRD3_DATE_FM;
	}
	public void setCOMP_BRD3_DATE_FM(HtmlCalendar cOMP_BRD3_DATE_FM) {
		COMP_BRD3_DATE_FM = cOMP_BRD3_DATE_FM;
	}
	public HtmlOutputLabel getCOMP_BRD3_DATE_FM_LABEL() {
		return COMP_BRD3_DATE_FM_LABEL;
	}
	public void setCOMP_BRD3_DATE_FM_LABEL(HtmlOutputLabel cOMP_BRD3_DATE_FM_LABEL) {
		COMP_BRD3_DATE_FM_LABEL = cOMP_BRD3_DATE_FM_LABEL;
	}
	public HtmlOutputLabel getCOMP_BRD3_DATE_TO_LABEL() {
		return COMP_BRD3_DATE_TO_LABEL;
	}
	public void setCOMP_BRD3_DATE_TO_LABEL(HtmlOutputLabel cOMP_BRD3_DATE_TO_LABEL) {
		COMP_BRD3_DATE_TO_LABEL = cOMP_BRD3_DATE_TO_LABEL;
	}
	public HtmlCalendar getCOMP_BRD3_DATE_TO() {
		return COMP_BRD3_DATE_TO;
	}
	public void setCOMP_BRD3_DATE_TO(HtmlCalendar cOMP_BRD3_DATE_TO) {
		COMP_BRD3_DATE_TO = cOMP_BRD3_DATE_TO;
	}
	public PILM086_VAL_RNG_DTLS_BEAN getVAL_BEAN() {
		return VAL_BEAN;
	}
	public void setVAL_BEAN(PILM086_VAL_RNG_DTLS_BEAN vAL_BEAN) {
		VAL_BEAN = vAL_BEAN;
	}
	public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PILM086_VAL_RNG_DTLS_ACTION(){
		VAL_BEAN=new PILM086_VAL_RNG_DTLS_BEAN();
		VAL_HELPER=new PILM086_VAL_RNG_DTLS_HELPER();
		
	}
	public void onLoad(PhaseEvent event) {
			try {
				System.out.println("VALUE ONLOAD CALLED");
				if (isBlockFlag()) {
					VAL_HELPER.executeQuery(compositeAction);
					resetAllComponent();
					setBlockFlag(false);
				}
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
	}
	
	public void validateBRD3_DTL_SNO(FacesContext context,
			UIComponent component, Object value){
		try{
			int BRD3_DTL_SNO = (Integer)value;
			
			VAL_BEAN.setBRD3_DTL_SNO(BRD3_DTL_SNO);
			System.out.println(VAL_BEAN.getBRD3_DTL_SNO());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	} 
	public void validateBRD3_VALUE_FM(FacesContext context,
			UIComponent component, Object value){
		System.out.println("Raja"+(String)value);
		try{
			String s=(String)value;
			VAL_BEAN.setBRD3_VALUE_FM(s);
			
			
			
			
			System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateEmptyBRD3_VALUE_FM(ActionEvent event) throws ValidatorException{
		System.out.println("2Raja["+VAL_BEAN.getBRD3_VALUE_FM()+"]");

		if("".equals(((String)getCOMP_BRD3_VALUE_FM().getSubmittedValue()).trim()) || getCOMP_BRD3_VALUE_FM().getSubmittedValue() == null){
			getCOMP_BRD3_VALUE_FM().setSubmittedValue("0");
			getCOMP_BRD3_VALUE_FM().updateModel(FacesContext.getCurrentInstance());
			
		}
		UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
		
			//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
		
	}
	
	
	
	public void validateEmptyBRD3_VALUE_TO(ActionEvent event) throws ValidatorException{
		System.out.println("2Raja["+VAL_BEAN.getBRD3_VALUE_FM()+"]");

		if("".equals(((String)getCOMP_BRD3_VALUE_TO().getSubmittedValue()).trim()) || getCOMP_BRD3_VALUE_TO().getSubmittedValue() == null){
			getCOMP_BRD3_VALUE_TO().setSubmittedValue("ZZZZZ");
			getCOMP_BRD3_VALUE_TO().updateModel(FacesContext.getCurrentInstance());
			
		}
		UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf
		ErrorHelpUtil.validate(input, getErrorMap());
		
			//System.out.println(VAL_BEAN.getBRD3_VALUE_FM());
		
	}
	
	
	public void validateBRD3_VALUE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			
			String BRD3_VALUE_TO = (String)value;
			
			
				VAL_BEAN.setBRD3_VALUE_TO(BRD3_VALUE_TO);
			
			
			System.out.println(VAL_BEAN.getBRD3_VALUE_TO());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateBRD3_DATE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			Date BRD3_DATE_FM = (Date)value;
			
			VAL_BEAN.setBRD3_DATE_FM(BRD3_DATE_FM);
			System.out.println(VAL_BEAN.getBRD3_DATE_FM());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateBRD3_DATE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			Date BRD3_DATE_FM = (Date)value;
			
			if (BRD3_DATE_FM != null) {

				if (VAL_BEAN.getBRD3_DATE_FM() != null
						&& BRD3_DATE_FM.before(VAL_BEAN.getBRD3_DATE_FM())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71195",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					
				}
			}
			
			
			
			VAL_BEAN.setBRD3_DATE_TO(BRD3_DATE_FM);
			System.out.println(VAL_BEAN.getBRD3_DATE_TO());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	/* public void saveRecord() {
		 String message = null;
			try {
				
				
			
				CommonUtils.getConnection().commit();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}
		 
	 }*/
	
	public void saveRecord() {

		System.out.println("INSIDE saveRecord");


		String message = null;
		CommonUtils.clearMaps(this);
		//PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");

		try {
			if (getVAL_BEAN().getROWID() == null && this.isINSERT_ALLOWED() == true) {

				System.out.println("NOT isUPDATE_ALLOWED");

				//	helper.preInsert(compositeAction);
				/*String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
				ResultSet rs = null;
				if (getErrorMap().size() == 0) {
					rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
					if (rs.next()) {
						VAL_BEAN.setBRD3_SYS_ID(Long.parseLong(rs.getString(1)));
					}
				}
				
				
				VAL_BEAN.setBRD3_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				
				System.out.println("M_USER_ID"+CommonUtils.getControlBean().getM_USER_ID());
				VAL_BEAN.setBRD3_CR_DT(new CommonUtils().getCurrentDate());
				System.out.println("BRD3_CR_DT"+new CommonUtils().getCurrentDate());
				VAL_BEAN.setBRD3_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				System.out.println("BRD3_UPD_UID"+CommonUtils.getControlBean().getM_USER_ID());
				VAL_BEAN.setBRD3_UPD_DT(new CommonUtils().getCurrentDate());
				System.out.println("new CommonUtils().getCurrentDate()");*/

				System.out.println("");
				
				
				new CRUDHandler().executeInsert(VAL_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));	


			}else
			{

				System.out.println("ROW ID !=NULL");

				System.out.println("isUPDATE_ALLOWED");
				//	helper.PRE_UPDATE(compositeAction);


			/*	VAL_BEAN.setBRD3_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				
				System.out.println("M_USER_ID"+CommonUtils.getControlBean().getM_USER_ID());
				VAL_BEAN.setBRD3_CR_DT(new CommonUtils().getCurrentDate());
				System.out.println("BRD3_CR_DT"+new CommonUtils().getCurrentDate());
				VAL_BEAN.setBRD3_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				System.out.println("BRD3_UPD_UID"+CommonUtils.getControlBean().getM_USER_ID());
				VAL_BEAN.setBRD3_UPD_DT(new CommonUtils().getCurrentDate());
				System.out.println("new CommonUtils().getCurrentDate()");*/

				new CRUDHandler().executeUpdate(VAL_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				getWarningMap().put(
						"update",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
			}

		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	 
	}

	 private void resetSelectedRow() {
			System.out.println("indide of resetSelectedRow++++++++++++++");
			
			Iterator<PILM086_VAL_RNG_DTLS_BEAN> PM_IL_COM_LINK_ITR = dataList_PILM086_VAL_RNG_DTLS_BEAN.iterator();
			while (PM_IL_COM_LINK_ITR.hasNext()) {
				PM_IL_COM_LINK_ITR.next().setRowSelected(false);
			}
		}
	 
	 
		public void addRow(ActionEvent event) {
			try {
				System.out.println("ADD CALLED");
				if (isINSERT_ALLOWED()) {
					System.out.println("INSERT");
					VAL_BEAN=new PILM086_VAL_RNG_DTLS_BEAN();
					
					resetAllComponent();
					resetSelectedRow();
					
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
		public void resetAllComponent(){
			COMP_BRD3_DATE_FM.resetValue();
			COMP_BRD3_DATE_TO.resetValue();
			COMP_BRD3_DTL_SNO.resetValue();
			COMP_BRD3_VALUE_FM.resetValue();
			COMP_BRD3_VALUE_TO.resetValue();
			
		}
		public void displayRecords() {
			CommonUtils.clearMaps(this);
			try {
				
				System.out.println("DISPLAY CALLED");
				resetSelectedRow();
				VAL_BEAN = (PILM086_VAL_RNG_DTLS_BEAN) dataTable.getRowData();
				VAL_BEAN.setRowSelected(true);
				resetAllComponent();
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				getErrorMap().put("displayRecords", exc.getMessage());
			}

		}
		public void deleteRow(ActionEvent event) {
			try {
				System.out.println("insert delete rew");
				
				if (isDELETE_ALLOWED()) {
					System.out.println("HAI");
					new CRUDHandler().executeDelete(VAL_BEAN,
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
					dataList_PILM086_VAL_RNG_DTLS_BEAN.remove(VAL_BEAN);
					if (dataList_PILM086_VAL_RNG_DTLS_BEAN.size() > 0) {

						VAL_BEAN = dataList_PILM086_VAL_RNG_DTLS_BEAN.get(0);
					} else if (dataList_PILM086_VAL_RNG_DTLS_BEAN.size() == 0) {

						addRow(null);
					}

					resetAllComponent();
					VAL_BEAN.setRowSelected(true);
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
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				getErrorMap().put("deleteRow", exc.getMessage());
			}

		}

		
		
		public void postRecord(ActionEvent event) {
	    	getErrorMap().clear();
			getWarningMap().clear();
		try {
			if (VAL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
				
				//added by raja
				
				String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
				ResultSet rs = null;
				if (getErrorMap().size() == 0) {
					rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
					if (rs.next()) {
						VAL_BEAN.setBRD3_SYS_ID(Long.parseLong(rs.getString(1)));
						
					}
				}
				
				VAL_BEAN.setBRD3_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
				
				
				VAL_BEAN.setBRD3_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				
				System.out.println("M_USER_ID"+CommonUtils.getControlBean().getM_USER_ID());
				VAL_BEAN.setBRD3_CR_DT(new CommonUtils().getCurrentDate());
				System.out.println("BRD3_CR_DT"+new CommonUtils().getCurrentDate());
				/*Date dat=VAL_BEAN.getBRD3_DATE_FM();*/
				/*String datst=CommonUtils.dateToStringFormat(dat);
				System.out.println("date to format :"+datst);
				Date da=CommonUtils.stringToPelUtilDate(datst);
				System.out.println(CommonUtils.dateToStringFormatter(dat));
				System.out.println();
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				String date = new SimpleDateFormat("yyyy-MM-dd").format(dat);
				System.out.println("String Date"+date);
				Date pardat=CommonUtils.newStringToDate(date);
				System.out.println(pardat);
				System.out.println(CommonUtils.DBStringToDate(date));
				System.out.println(CommonUtils.DBStringToUtilDate(date));
				System.out.println(CommonUtils.stringToDate(date));
				System.out.println(CommonUtils.stringToPelUtilDate(date));
				System.out.println(CommonUtils.stringToUtilDate(date));
				VAL_BEAN.setBRD3_DATE_FM(pardat);
				System.out.println("VAL_BEAN.getBRD3_DATE_FM()"+VAL_BEAN.getBRD3_DATE_FM());*/
				
				//added by raja
				
				new CRUDHandler().executeInsert(VAL_BEAN,
						CommonUtils.getConnection());
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
				dataList_PILM086_VAL_RNG_DTLS_BEAN.add(VAL_BEAN);
			} else if (VAL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				//helper.preUpdate(compositeAction);
				
				/*Added by Raja on 26-4-2016 for TUSB POC*/
				
				VAL_BEAN.setBRD3_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
				/*End*/
				
				VAL_BEAN.setBRD3_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				System.out.println("BRD3_UPD_UID"+CommonUtils.getControlBean().getM_USER_ID());
				VAL_BEAN.setBRD3_UPD_DT(new CommonUtils().getCurrentDate());
				System.out.println("new CommonUtils().getCurrentDate()");
				
				new CRUDHandler().executeUpdate(VAL_BEAN,
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
			}

			VAL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			String temp=extractDBErrorMessage(exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + temp);
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + temp);
		}
	}
		public static String extractDBErrorMessage(String dbErrorMessage){
			if ((dbErrorMessage != null) ){
				if ((dbErrorMessage.indexOf(":")!=-1) && (dbErrorMessage.indexOf("ORA")!=-1)){
					int index = dbErrorMessage.indexOf(":");
					dbErrorMessage = dbErrorMessage.substring(index+1);
					dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
					return dbErrorMessage;
				}else{
					dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
					return dbErrorMessage;
				}
			}
			return dbErrorMessage;
		}
		
		

}
