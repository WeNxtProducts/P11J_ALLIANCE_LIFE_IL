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
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlInputTextarea;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POL_APPROVAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_DISPATCH_DTLS_ACTION extends CommonAction {
	


    private HtmlOutputLabel COMP_PDD_DATE_LABEL;
    
    private HtmlCalendar COMP_PDD_DATE;
    
    private HtmlOutputLabel COMP_PDD_STATUS_LABEL;

    private HtmlInputText COMP_PDD_STATUS;
    
    private HtmlInputText COMP_UI_M_PDD_STATUS_DESC;
    
    private HtmlOutputLabel COMP_PDD_REMARKS_LABEL;

    private HtmlInputTextarea COMP_PDD_REMARKS;
    
    private HtmlAjaxCommandButton COMP_ADD_ROW;
	
	private HtmlAjaxCommandButton COMP_DEL_ROW;
	
	private HtmlAjaxCommandButton COMP_POST_ROW;
    

    private PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN;

    public PILT002_APAC_COMPOSITE_ACTION compositeAction;

    private PT_IL_POL_DISPATCH_DTLS_HELPER helper;

    private List<PT_IL_POL_DISPATCH_DTLS> dataList_PT_IL_POL_DISPATCH_DTLS = new ArrayList<PT_IL_POL_DISPATCH_DTLS>();

    private UIData dataTable;

    ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();

    PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
    

	public ArrayList<LovBean> getSuggestionList() {
		return suggestionList;
	}


	public void setSuggestionList(ArrayList<LovBean> suggestionList) {
		this.suggestionList = suggestionList;
	}


	public HtmlOutputLabel getCOMP_PDD_DATE_LABEL() {
		return COMP_PDD_DATE_LABEL;
	}


	public void setCOMP_PDD_DATE_LABEL(HtmlOutputLabel cOMP_PDD_DATE_LABEL) {
		COMP_PDD_DATE_LABEL = cOMP_PDD_DATE_LABEL;
	}


	public HtmlCalendar getCOMP_PDD_DATE() {
		return COMP_PDD_DATE;
	}


	public void setCOMP_PDD_DATE(HtmlCalendar cOMP_PDD_DATE) {
		COMP_PDD_DATE = cOMP_PDD_DATE;
	}


	public HtmlOutputLabel getCOMP_PDD_STATUS_LABEL() {
		return COMP_PDD_STATUS_LABEL;
	}


	public void setCOMP_PDD_STATUS_LABEL(HtmlOutputLabel cOMP_PDD_STATUS_LABEL) {
		COMP_PDD_STATUS_LABEL = cOMP_PDD_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_PDD_STATUS() {
		return COMP_PDD_STATUS;
	}


	public void setCOMP_PDD_STATUS(HtmlInputText cOMP_PDD_STATUS) {
		COMP_PDD_STATUS = cOMP_PDD_STATUS;
	}


	public HtmlInputText getCOMP_UI_M_PDD_STATUS_DESC() {
		return COMP_UI_M_PDD_STATUS_DESC;
	}


	public void setCOMP_UI_M_PDD_STATUS_DESC(HtmlInputText cOMP_UI_M_PDD_STATUS_DESC) {
		COMP_UI_M_PDD_STATUS_DESC = cOMP_UI_M_PDD_STATUS_DESC;
	}


	public HtmlOutputLabel getCOMP_PDD_REMARKS_LABEL() {
		return COMP_PDD_REMARKS_LABEL;
	}


	public void setCOMP_PDD_REMARKS_LABEL(HtmlOutputLabel cOMP_PDD_REMARKS_LABEL) {
		COMP_PDD_REMARKS_LABEL = cOMP_PDD_REMARKS_LABEL;
	}


	public HtmlInputTextarea getCOMP_PDD_REMARKS() {
		return COMP_PDD_REMARKS;
	}


	public void setCOMP_PDD_REMARKS(HtmlInputTextarea cOMP_PDD_REMARKS) {
		COMP_PDD_REMARKS = cOMP_PDD_REMARKS;
	}


	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}


	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton cOMP_ADD_ROW) {
		COMP_ADD_ROW = cOMP_ADD_ROW;
	}


	public HtmlAjaxCommandButton getCOMP_DEL_ROW() {
		return COMP_DEL_ROW;
	}


	public void setCOMP_DEL_ROW(HtmlAjaxCommandButton cOMP_DEL_ROW) {
		COMP_DEL_ROW = cOMP_DEL_ROW;
	}


	public HtmlAjaxCommandButton getCOMP_POST_ROW() {
		return COMP_POST_ROW;
	}


	public void setCOMP_POST_ROW(HtmlAjaxCommandButton cOMP_POST_ROW) {
		COMP_POST_ROW = cOMP_POST_ROW;
	}


	public PT_IL_POL_DISPATCH_DTLS getPT_IL_POL_DISPATCH_DTLS_BEAN() {
		return PT_IL_POL_DISPATCH_DTLS_BEAN;
	}


	public void setPT_IL_POL_DISPATCH_DTLS_BEAN(
			PT_IL_POL_DISPATCH_DTLS pT_IL_POL_DISPATCH_DTLS_BEAN) {
		PT_IL_POL_DISPATCH_DTLS_BEAN = pT_IL_POL_DISPATCH_DTLS_BEAN;
	}


	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PT_IL_POL_DISPATCH_DTLS_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PT_IL_POL_DISPATCH_DTLS_HELPER helper) {
		this.helper = helper;
	}


	public void setDataList_PT_IL_POL_DISPATCH_DTLS(
			List<PT_IL_POL_DISPATCH_DTLS> dataList_PT_IL_POL_DISPATCH_DTLS) {
		this.dataList_PT_IL_POL_DISPATCH_DTLS = dataList_PT_IL_POL_DISPATCH_DTLS;
	}

	

    public List<PT_IL_POL_DISPATCH_DTLS> getDataList_PT_IL_POL_DISPATCH_DTLS() {
	return dataList_PT_IL_POL_DISPATCH_DTLS;
    }

    public void setDataListPT_IL_POL_DISPATCH_DTLS(
	    List<PT_IL_POL_DISPATCH_DTLS> dataList_PT_IL_POL_DISPATCH_DTLS) {
	this.dataList_PT_IL_POL_DISPATCH_DTLS = dataList_PT_IL_POL_DISPATCH_DTLS;
    }
	

	public PT_IL_POL_DISPATCH_DTLS_ACTION() {

	PT_IL_POL_DISPATCH_DTLS_BEAN = new PT_IL_POL_DISPATCH_DTLS();
	helper = new PT_IL_POL_DISPATCH_DTLS_HELPER();
	instantiateAllComponent();
    }
    

	/**
	 * Instantiates all components in PT_IL_POL_DISPATCH_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		
		COMP_PDD_REMARKS				 = new HtmlInputTextarea();
		COMP_PDD_DATE_LABEL				 = new HtmlOutputLabel();
		COMP_PDD_STATUS_LABEL			 = new HtmlOutputLabel();
		COMP_PDD_REMARKS_LABEL			 = new HtmlOutputLabel();
		COMP_PDD_STATUS			 = new HtmlInputText();
		COMP_PDD_DATE				 = new HtmlCalendar();
		COMP_ADD_ROW			 = new HtmlAjaxCommandButton();
		COMP_DEL_ROW			 = new HtmlAjaxCommandButton();
		COMP_POST_ROW			 = new HtmlAjaxCommandButton();
		COMP_UI_M_PDD_STATUS_DESC = new HtmlInputText();
		

	}

    private void resetAllComponent() {
    	
    	COMP_PDD_REMARKS.resetValue();
		COMP_PDD_STATUS.resetValue();
		COMP_PDD_DATE.resetValue();
		COMP_UI_M_PDD_STATUS_DESC.resetValue();
	
    }
    
    public String back(){
    	return "PILT002_APAC_PT_IL_POLICY";
    }

    public void setDataTable(UIData dataTable) {
	this.dataTable = dataTable;
    }

    public UIData getDataTable() {
	return dataTable;
    }

  
    
    public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_DISPATCH_DTLS_BEAN = (PT_IL_POL_DISPATCH_DTLS) dataTable
			.getRowData();
			
			System.out.println("GetTime is       "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE()+"      "+PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()
					+"            "+new Date(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE())+"               "+new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()));

			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_DATE(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()));
			
			
			System.out.println("After GetTime is       "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE()+"      "+PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()
					+"            "+new Date(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE())+"               "+new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()));

			
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
    
    public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

    public void onLoad(PhaseEvent event) {
		try {

			if (isBlockFlag()) {

				helper.executeQuery(compositeAction);
				if(PT_IL_POL_DISPATCH_DTLS_BEAN.getROWID() != null)
				{
					helper.postInsert(compositeAction,PT_IL_POL_DISPATCH_DTLS_BEAN);
				}else
				{
					helper.WHEN_CREATE_RECORD(PT_IL_POL_DISPATCH_DTLS_BEAN, compositeAction);
				}

				COMP_PDD_STATUS.resetValue();
				COMP_UI_M_PDD_STATUS_DESC.resetValue();
				setBlockFlag(false);
			}
						
			
			
			
			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("Y")) ||
					CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS(),"N").equalsIgnoreCase("y"))
			{
				disableAllComponent(true);
				
			}
			else
			{
				disableAllComponent(false);	
			}
		
			
			System.out.println("getUI_M_PDD_DATE in ONLOAD   "+PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE());
			
			System.out.println("getPDD_DATE in ONLOAD   "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void createRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();


			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(PT_IL_POL_DISPATCH_DTLS_BEAN,compositeAction);
				PT_IL_POL_DISPATCH_DTLS_BEAN = new PT_IL_POL_DISPATCH_DTLS();
				resetAllComponent();
				resetSelectedRow();

			} else {
				getErrorMap().put("addRow",
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
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}


	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {


				new CRUDHandler().executeDelete(PT_IL_POL_DISPATCH_DTLS_BEAN,
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
				dataList_PT_IL_POL_DISPATCH_DTLS
				.remove(PT_IL_POL_DISPATCH_DTLS_BEAN);
				if (dataList_PT_IL_POL_DISPATCH_DTLS.size() > 0) {

					PT_IL_POL_DISPATCH_DTLS_BEAN = dataList_PT_IL_POL_DISPATCH_DTLS
					.get(0);
				} else if (dataList_PT_IL_POL_DISPATCH_DTLS.size() == 0) {

					createRow(null);
				}

				resetAllComponent();
				PT_IL_POL_DISPATCH_DTLS_BEAN.setRowSelected(true);
			

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
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	/*
	 * 
	 * public String saveRecord(ActionEvent event) {*/
	public String saveRecord() {		
		String message = null;
		String exst_chk_query = null;
		Object[] params = null;
		CRUDHandler handler;
		ResultSet resultSet = null;
		
		try {
			if (PT_IL_POL_DISPATCH_DTLS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(compositeAction,PT_IL_POL_DISPATCH_DTLS_BEAN);
			
				exst_chk_query = "SELECT 'X' FROM  PT_IL_POL_DISPATCH_DTLS WHERE PDD_STATUS = ? AND PDD_POL_SYS_ID = ?";
				params = new Object[]{PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_STATUS(),compositeAction.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN().
						getPT_IL_POL_DISPATCH_DTLS_BEAN().getPDD_POL_SYS_ID()};

				handler = new CRUDHandler();
				Connection connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
				if(resultSet.next()){

					throw new Exception("Code already exists.");
				}else
				{
				
				
				new CRUDHandler().executeInsert(PT_IL_POL_DISPATCH_DTLS_BEAN,
						CommonUtils.getConnection());
				/*ADDED BY GOPI FOR Once policy document is printed, additional status to be changed as Pending Deliver ON 09/05/2018*/
				String pdd_status=PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_STATUS();
				int updateStatus=0;
				if(pdd_status!=null && pdd_status.equalsIgnoreCase("DP01"))
				{
			updateStatus=	new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '005' WHERE POL_SYS_ID = ?", 
										CommonUtils.getConnection(),new Object[]{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				}else if(pdd_status!=null && pdd_status.equalsIgnoreCase("DP04") || pdd_status.equalsIgnoreCase("DP05")){
					int value = 0;
					value = helper.doGetValue(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
					CommonUtils utils = new CommonUtils();
					/*Newly added and commented(as suggested by siva and bala) by pidugu raj dt: 10-10-2018 as suggested by vaitheeswaran for kic*/
						/*helper.PROCESS_PROP_CANCEL(utils.getCurrentDate(),
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO(),
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO(),
                                "Y",
                                value);*/
						/*End Newly added by pidugu raj dt: 10-10-2018 as suggested by vaitheeswaran for kic*/
				}
				
				
			/*	Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() != null){
				if(pdd_status!=null && pdd_status.equalsIgnoreCase("DP03")){
					String pol_Sys_id = String.valueOf(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
					String flag = "P";
					new P9ILPK_POL_APPROVAL().PROC_POL_APPROVAL_DIRECT(pol_Sys_id,pdd_status,flag);
				}
				}
				End Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion
				*/
				if(updateStatus>0){
					CommonUtils.getConnection().commit();
					System.out.println("POL_ADDL_STATUS UPDATED SUCCESSFULLY in assured medical >>>>>>>>>>>>>>>");
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().onLoad(null);
				}
			//END
				
				
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
				
				dataList_PT_IL_POL_DISPATCH_DTLS
				.add(PT_IL_POL_DISPATCH_DTLS_BEAN);
				/*Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion*/
				PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_DATE(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE()));
				
				System.out.println("UI_M_PDD_DATE is    "+PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE());
				
				CommonUtils.getConnection().commit();
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() != null){
				if(pdd_status!=null && pdd_status.equalsIgnoreCase("DP03")){
					String pol_Sys_id = String.valueOf(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
					String flag = "P";
					new P9ILPK_POL_APPROVAL().PROC_POL_APPROVAL_DIRECT(pol_Sys_id,pdd_status,flag);
				}
				}
				/*End Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion*/
				
				}
			}
			else if (PT_IL_POL_DISPATCH_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.preUpdate(PT_IL_POL_DISPATCH_DTLS_BEAN);
				
				exst_chk_query = "SELECT 'X' FROM  PT_IL_POL_DISPATCH_DTLS WHERE PDD_STATUS = ? AND PDD_POL_SYS_ID = ? AND ROWID <>  ?";
				params = new Object[]{PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_STATUS(),compositeAction.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN().
						getPT_IL_POL_DISPATCH_DTLS_BEAN().getPDD_POL_SYS_ID(),
						compositeAction.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN().
						getPT_IL_POL_DISPATCH_DTLS_BEAN().getROWID()};

				handler = new CRUDHandler();
				Connection connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
				if(resultSet.next()){

					throw new Exception("Code already exists.");
				}else
				{
				
				
				new CRUDHandler().executeUpdate(PT_IL_POL_DISPATCH_DTLS_BEAN,
						CommonUtils.getConnection());
			
				getWarningMap().put("SAVE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			}
			}
			System.out.println("EntryDate is    "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE());
			
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_DATE(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_DATE()));
			
			System.out.println("UI_M_PDD_DATE is    "+PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE());
			
			CommonUtils.getConnection().commit();
			
			/*Added by Janani on 05.04.2018 for KIC dispatch screen changing addl status to cancelled*/

			System.out.println("addl status before               "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ADDL_STATUS());
			
			pilt002Procedures.P_DISP_STATUS(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		
			System.out.println("addl status               "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ADDL_STATUS());
			/*End*/
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setRowSelected(true);

		} catch (Exception exc) {
			exc.printStackTrace(); 
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";

	}


	private void resetSelectedRow() {
		Iterator<PT_IL_POL_DISPATCH_DTLS> PT_IL_POL_DISPATCH_DTLS_ITR = dataList_PT_IL_POL_DISPATCH_DTLS.iterator();
		while (PT_IL_POL_DISPATCH_DTLS_ITR.hasNext()) {
			PT_IL_POL_DISPATCH_DTLS_ITR.next().setRowSelected(false);
		}
	}
	
   
  
	/**
	 * Disables all components in PT_IL_POL_DISPATCH_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		
		COMP_PDD_REMARKS.setDisabled(disabled);
		COMP_PDD_STATUS.setDisabled(disabled);
		COMP_PDD_DATE.setDisabled(disabled);
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
		
	}

	public void PDD_STATUS_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_DISPATCH_DTLS_BEAN().setPDD_STATUS((String) value);
			
			System.out.println("getPAFD_STATUS              "+getPT_IL_POL_DISPATCH_DTLS_BEAN().getPDD_DATE());
			
			 helper.PDD_STATUS_WHEN_VALIDATE_ITEM(compositeAction,
					 (String) value);
			
			COMP_UI_M_PDD_STATUS_DESC.resetValue();
			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	CommonUtils commonUtils = new CommonUtils();
	
	public void PDD_DATE_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			
			//getPT_IL_POL_DISPATCH_DTLS_BEAN().setPDD_DATE((Date) value);
			
			getPT_IL_POL_DISPATCH_DTLS_BEAN().setPDD_DATE(commonUtils.getCurrentDateAndTimeNew());
			
			
			System.out.println("getPAFD_STATUS              "+getPT_IL_POL_DISPATCH_DTLS_BEAN().getPDD_DATE());
			
			
			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	
	public void PDD_REMARKS_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			
			getPT_IL_POL_DISPATCH_DTLS_BEAN().setPDD_REMARKS((String) value);
			
			System.out.println("getPAFD_STATUS              "+getPT_IL_POL_DISPATCH_DTLS_BEAN().getPDD_DATE());
			
			
			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> prepareSuggestionList_PDD_STATUS(
			Object currValue) {
		
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_DISPATCH_DTLS", "PDD_STATUS", "IL_DISP_STS", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public String getCatgDescforCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN = (PT_IL_POL_DISPATCH_DTLS) iterator
					.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (catgCode.equalsIgnoreCase(PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_STATUS())) {
				catgDesc = PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_STATUS_DESC();
			}
		}
		return catgDesc;
	}
	
	public void getCatgCodeDesc(ActionEvent event) {
		if (COMP_PDD_STATUS.getSubmittedValue() != null) {
			String catgCode = (String) COMP_PDD_STATUS.getSubmittedValue();
			String catgCodeDesc = getCatgDescforCode(catgCode, suggestionList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_STATUS_DESC(catgCodeDesc);
			COMP_UI_M_PDD_STATUS_DESC.setSubmittedValue(catgCodeDesc);
		}
	}

}
