package com.iii.pel.forms.PILP203;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILQ106_APAC.PS_IL_UNIT_FUND_REG;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_QUERY_CONSTANTS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

	/*Added by saritha on 20-02-2017 for RM018T - DEV_IL_ZB Life_027-Replacement Policy*/	
	public class PT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION extends CommonAction {
		
	public PILP203_COMPOSITE_ACTION compositeAction;
	private PT_IL_POL_BROKER_HEAD_ORIGINAL PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN;
	private PT_IL_POL_BROKER_HEAD_ORIGINAL_DELEGATE delegate;
	private PT_IL_POL_BROKER_HEAD_ORIGINAL_HELPER helper;
	
	private UIData dataTable;
	private List<PT_IL_POL_BROKER_HEAD_ORIGINAL> dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL = new ArrayList<PT_IL_POL_BROKER_HEAD_ORIGINAL>();
	
	public PILP203_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILP203_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PT_IL_POL_BROKER_HEAD_ORIGINAL getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN() {
		return PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN;
	}
	public void setPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN(
			PT_IL_POL_BROKER_HEAD_ORIGINAL pT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN) {
		PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = pT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN;
	}
	public PT_IL_POL_BROKER_HEAD_ORIGINAL_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(PT_IL_POL_BROKER_HEAD_ORIGINAL_DELEGATE delegate) {
		this.delegate = delegate;
	}
	public PT_IL_POL_BROKER_HEAD_ORIGINAL_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PT_IL_POL_BROKER_HEAD_ORIGINAL_HELPER helper) {
		this.helper = helper;
	}
	
	public List<PT_IL_POL_BROKER_HEAD_ORIGINAL> getDataList_PT_IL_POL_BROKER_HEAD_ORIGINAL() {
		return dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL;
	}
	public void setDataList_PT_IL_POL_BROKER_HEAD_ORIGINAL(
			List<PT_IL_POL_BROKER_HEAD_ORIGINAL> dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL) {
		this.dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL = dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	private HtmlInputText COMP_POBH_ORI_POL_NO;
	private HtmlAjaxCommandButton COMP_REPL_POL_PROCESS;
	private HtmlAjaxCommandButton COMP_REPL_POL_ADD;
	private HtmlAjaxCommandButton COMP_REPL_POL_DELETE;
	private HtmlAjaxCommandButton COMP_REPL_POL_POST;
	private HtmlOutputLabel COMP_POBH_ORI_AGENT_CODE_LABEL;
	private HtmlInputText COMP_POBH_ORI_AGENT_CODE;
	private HtmlInputText COMP_POBH_ORI_AGENT_DESC;
	private HtmlOutputLabel COMP_POBH_ORI_SHARE_PERC_LABEL;
	private HtmlInputText COMP_POBH_ORI_SHARE_PERC;
	private HtmlOutputLabel COMP_POBH_ORI_COMMISSION_LABEL;
	private HtmlInputText COMP_POBH_ORI_COMMISSION;
	private HtmlOutputLabel COMP_POBH_ORI_POL_NO_LABEL;
	private HtmlOutputLabel COMP_POBH_ORI_DATE_LABEL;
	private HtmlCalendar COMP_POBH_ORI_DATE;
	
	public HtmlCalendar getCOMP_POBH_ORI_DATE() {
		return COMP_POBH_ORI_DATE;
	}
	public void setCOMP_POBH_ORI_DATE(HtmlCalendar cOMP_POBH_ORI_DATE) {
		COMP_POBH_ORI_DATE = cOMP_POBH_ORI_DATE;
	}
	public HtmlOutputLabel getCOMP_POBH_ORI_DATE_LABEL() {
		return COMP_POBH_ORI_DATE_LABEL;
	}
	public void setCOMP_POBH_ORI_DATE_LABEL(HtmlOutputLabel cOMP_POBH_ORI_DATE_LABEL) {
		COMP_POBH_ORI_DATE_LABEL = cOMP_POBH_ORI_DATE_LABEL;
	}
	public HtmlOutputLabel getCOMP_POBH_ORI_POL_NO_LABEL() {
		return COMP_POBH_ORI_POL_NO_LABEL;
	}
	public void setCOMP_POBH_ORI_POL_NO_LABEL(
			HtmlOutputLabel cOMP_POBH_ORI_POL_NO_LABEL) {
		COMP_POBH_ORI_POL_NO_LABEL = cOMP_POBH_ORI_POL_NO_LABEL;
	}
	public HtmlInputText getCOMP_POBH_ORI_POL_NO() {
		return COMP_POBH_ORI_POL_NO;
	}
	public void setCOMP_POBH_ORI_POL_NO(HtmlInputText cOMP_POBH_ORI_POL_NO) {
		COMP_POBH_ORI_POL_NO = cOMP_POBH_ORI_POL_NO;
	}
	
	public HtmlAjaxCommandButton getCOMP_REPL_POL_PROCESS() {
		return COMP_REPL_POL_PROCESS;
	}
	public void setCOMP_REPL_POL_PROCESS(HtmlAjaxCommandButton cOMP_REPL_POL_PROCESS) {
		COMP_REPL_POL_PROCESS = cOMP_REPL_POL_PROCESS;
	}
	
	public HtmlAjaxCommandButton getCOMP_REPL_POL_ADD() {
		return COMP_REPL_POL_ADD;
	}
	public void setCOMP_REPL_POL_ADD(HtmlAjaxCommandButton cOMP_REPL_POL_ADD) {
		COMP_REPL_POL_ADD = cOMP_REPL_POL_ADD;
	}
	public HtmlAjaxCommandButton getCOMP_REPL_POL_DELETE() {
		return COMP_REPL_POL_DELETE;
	}
	public void setCOMP_REPL_POL_DELETE(HtmlAjaxCommandButton cOMP_REPL_POL_DELETE) {
		COMP_REPL_POL_DELETE = cOMP_REPL_POL_DELETE;
	}
	public HtmlAjaxCommandButton getCOMP_REPL_POL_POST() {
		return COMP_REPL_POL_POST;
	}
	public void setCOMP_REPL_POL_POST(HtmlAjaxCommandButton cOMP_REPL_POL_POST) {
		COMP_REPL_POL_POST = cOMP_REPL_POL_POST;
	}
	
	public HtmlOutputLabel getCOMP_POBH_ORI_AGENT_CODE_LABEL() {
		return COMP_POBH_ORI_AGENT_CODE_LABEL;
	}
	public void setCOMP_POBH_ORI_AGENT_CODE_LABEL(
			HtmlOutputLabel cOMP_POBH_ORI_AGENT_CODE_LABEL) {
		COMP_POBH_ORI_AGENT_CODE_LABEL = cOMP_POBH_ORI_AGENT_CODE_LABEL;
	}
	public HtmlInputText getCOMP_POBH_ORI_AGENT_CODE() {
		return COMP_POBH_ORI_AGENT_CODE;
	}
	public void setCOMP_POBH_ORI_AGENT_CODE(HtmlInputText cOMP_POBH_ORI_AGENT_CODE) {
		COMP_POBH_ORI_AGENT_CODE = cOMP_POBH_ORI_AGENT_CODE;
	}
	public HtmlInputText getCOMP_POBH_ORI_AGENT_DESC() {
		return COMP_POBH_ORI_AGENT_DESC;
	}
	public void setCOMP_POBH_ORI_AGENT_DESC(HtmlInputText cOMP_POBH_ORI_AGENT_DESC) {
		COMP_POBH_ORI_AGENT_DESC = cOMP_POBH_ORI_AGENT_DESC;
	}
	
	public HtmlOutputLabel getCOMP_POBH_ORI_SHARE_PERC_LABEL() {
		return COMP_POBH_ORI_SHARE_PERC_LABEL;
	}
	public void setCOMP_POBH_ORI_SHARE_PERC_LABEL(
			HtmlOutputLabel cOMP_POBH_ORI_SHARE_PERC_LABEL) {
		COMP_POBH_ORI_SHARE_PERC_LABEL = cOMP_POBH_ORI_SHARE_PERC_LABEL;
	}
	public HtmlInputText getCOMP_POBH_ORI_SHARE_PERC() {
		return COMP_POBH_ORI_SHARE_PERC;
	}
	public void setCOMP_POBH_ORI_SHARE_PERC(HtmlInputText cOMP_POBH_ORI_SHARE_PERC) {
		COMP_POBH_ORI_SHARE_PERC = cOMP_POBH_ORI_SHARE_PERC;
	}
	public HtmlOutputLabel getCOMP_POBH_ORI_COMMISSION_LABEL() {
		return COMP_POBH_ORI_COMMISSION_LABEL;
	}
	public void setCOMP_POBH_ORI_COMMISSION_LABEL(
			HtmlOutputLabel cOMP_POBH_ORI_COMMISSION_LABEL) {
		COMP_POBH_ORI_COMMISSION_LABEL = cOMP_POBH_ORI_COMMISSION_LABEL;
	}
	public HtmlInputText getCOMP_POBH_ORI_COMMISSION() {
		return COMP_POBH_ORI_COMMISSION;
	}
	public void setCOMP_POBH_ORI_COMMISSION(HtmlInputText cOMP_POBH_ORI_COMMISSION) {
		COMP_POBH_ORI_COMMISSION = cOMP_POBH_ORI_COMMISSION;
	}
	
	public PT_IL_POL_BROKER_HEAD_ORIGINAL_ACTION(){
		PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN=new PT_IL_POL_BROKER_HEAD_ORIGINAL();
		delegate=new PT_IL_POL_BROKER_HEAD_ORIGINAL_DELEGATE();
		helper=new PT_IL_POL_BROKER_HEAD_ORIGINAL_HELPER();
		instantiateAllComponent();
		resetAllComponents();
	}
	
	public void instantiateAllComponent() {
		COMP_POBH_ORI_POL_NO_LABEL= new HtmlOutputLabel();
		COMP_POBH_ORI_AGENT_CODE_LABEL=new HtmlOutputLabel();
		COMP_POBH_ORI_SHARE_PERC_LABEL=new HtmlOutputLabel();
		COMP_POBH_ORI_COMMISSION_LABEL=new HtmlOutputLabel();
		COMP_POBH_ORI_DATE_LABEL      = new HtmlOutputLabel();
		
		COMP_POBH_ORI_POL_NO=new HtmlInputText();
		COMP_POBH_ORI_AGENT_CODE=new HtmlInputText();
		COMP_POBH_ORI_AGENT_DESC=new HtmlInputText();
		COMP_POBH_ORI_SHARE_PERC=new HtmlInputText();
		COMP_POBH_ORI_COMMISSION=new HtmlInputText();
		COMP_REPL_POL_PROCESS=new HtmlAjaxCommandButton();
		COMP_REPL_POL_ADD=new HtmlAjaxCommandButton();
		COMP_REPL_POL_DELETE=new HtmlAjaxCommandButton();
		COMP_REPL_POL_POST=new HtmlAjaxCommandButton();
		COMP_POBH_ORI_DATE=new HtmlCalendar();
		}
		
	public void disableAllComponent(boolean disabled) {
		COMP_POBH_ORI_POL_NO.setDisabled(disabled);
		COMP_POBH_ORI_AGENT_CODE.setDisabled(disabled);
		COMP_POBH_ORI_AGENT_DESC.setDisabled(disabled);
		COMP_POBH_ORI_SHARE_PERC.setDisabled(disabled);
		COMP_POBH_ORI_COMMISSION.setDisabled(disabled);
		COMP_REPL_POL_PROCESS.setDisabled(disabled);
		COMP_POBH_ORI_DATE.setDisabled(disabled);
	}
		
	public void resetAllComponents(){
		COMP_POBH_ORI_POL_NO.resetValue();
		COMP_POBH_ORI_AGENT_CODE.resetValue();
		COMP_POBH_ORI_SHARE_PERC.resetValue();
		COMP_POBH_ORI_COMMISSION.resetValue();
		COMP_POBH_ORI_DATE.resetValue();

	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BROKER_HEAD_ORIGINAL> PT_IL_POL_BROKER_HEAD_ORIGINAL = dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL.iterator();
		while (PT_IL_POL_BROKER_HEAD_ORIGINAL.hasNext()) {
			PT_IL_POL_BROKER_HEAD_ORIGINAL.next().setRowSelected(false);
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = (PT_IL_POL_BROKER_HEAD_ORIGINAL) dataTable.getRowData();
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setRowSelected(true);
			resetAllComponents();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				resetAllComponents();
				//helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
		
	}
		
	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				//Policy number storing temporarily to get after initialized bean.
				String tmpPolicyNumber = PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO();
				Date tmpDate = PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_DATE();
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = new PT_IL_POL_BROKER_HEAD_ORIGINAL();
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_POL_NO(tmpPolicyNumber);
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_DATE(tmpDate);
				resetAllComponents();
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
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN,
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
				dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL.remove(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN);
				if (dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL.size() > 0) {

					PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN = dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL
							.get(0);
				} else if (dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL.size() == 0) {

					addRow(null);
				}

				resetAllComponents();
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setRowSelected(true);
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
	
	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			
			System.out.println("Policy No POST"+PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO());
			
			
			if (PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_POL_SYS_ID(polsysid());
				new CRUDHandler().executeInsert(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL.add(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN);

			} else if (PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				
				new CRUDHandler().executeUpdate(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			resetAllComponents();
			resetSelectedRow();
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setRowSelected(true);
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
		
	public void saveRecord() {
		String message ="";
		try {
			
			if (dataList_PT_IL_POL_BROKER_HEAD_ORIGINAL.size() == 0) {
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN=new PT_IL_POL_BROKER_HEAD_ORIGINAL();	
				resetAllComponents();
				
			}
			COMP_REPL_POL_PROCESS.setDisabled(false);
			CommonUtils.getConnection().commit();
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void ValidatePOBH_ORI_POL_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		String POBH_ORI_POL_NO = (String) value;
		try {
			System.out.println("validator is called");
			getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().setPOBH_ORI_POL_NO(POBH_ORI_POL_NO);
			COMP_POBH_ORI_POL_NO.resetValue();
			System.out.println("Policy No"+PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}

	public void POBH_ORI_AGENT_CODE_WHEN_VALIDATE_ITEM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		String POBH_ORI_AGENT_CODE = (String) value;
		try {
			/* added by rja on 25-07-2017 for ZBILQC-1725024 */
			getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().setPOBH_ORI_AGENT_CODE(POBH_ORI_AGENT_CODE);
			System.out.println("Agent Code"+PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_AGENT_CODE());
			if(PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_COMMISSION()<=0)
			{
				
			/*Commentted & Modified by saritha on 24-08-2017 for ZBILQC-1725024*/	
			/*PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_COMMISSION(defaultCommission());*/
			PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.setPOBH_ORI_COMMISSION(fun_Original_Commission());
			/*End*/
			COMP_POBH_ORI_COMMISSION.resetValue();
			}
			/*end*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validatePOBH_ORI_SHARE_PERC(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		double POBH_ORI_SHARE_PERC = (double) value;
		try {
			
			getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().setPOBH_ORI_SHARE_PERC(POBH_ORI_SHARE_PERC);
			System.out.println("Share %"+PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_SHARE_PERC());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validatePOBH_ORI_COMMISSION(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		double POBH_ORI_COMMISSION = (double) value;
		try {
			
			/* added by rja on 25-07-2017 for ZBILQC-1725024 */
			/*Commentted & Modified by saritha on 24-08-2017 for ZBILQC-1725024*/
			/*if(POBH_ORI_COMMISSION<=defaultCommission())*/
			if(POBH_ORI_COMMISSION<=fun_Original_Commission())
			/*End*/
			{
			getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().setPOBH_ORI_COMMISSION(POBH_ORI_COMMISSION);
			}
			else
			{
				throw new Exception("Commission value should not greater than policy basic Commission value");
			}
			System.out.println("Commission"+PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_COMMISSION());
			
			/*end*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void ValidatePOBH_ORI_DATE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try
		{
			getPT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN().setPOBH_ORI_DATE((Date) value);
			System.out.println("Date"+PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_DATE());
			COMP_POBH_ORI_DATE.resetValue();
			
		}
		catch (Exception exe) {
			getErrorMap().put("current",
					exe.getMessage());
			throw new ValidatorException(new FacesMessage(exe.getMessage()));
		}
	}

	public ArrayList<LovBean> lovPOBH_ORI_POL_NO(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			System.out.println("inside query execute");
			query = PT_IL_POLICY_QUERY_CONSTANTS.POBH_ORI_POL_NO_QUERY;
			if ("*".equals(code)) {
				query = PT_IL_POLICY_QUERY_CONSTANTS.POBH_ORI_POL_NO_QUERY;
				object = new Object[] { PELConstants.suggetionRecordSize };
				
			} else {
				query = PT_IL_POLICY_QUERY_CONSTANTS.POBH_ORI_POL_NO_QUERY_LIKE;
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public long polsysid() throws DBException 
	{
		
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		long pol_sys_id=0;
		CRUDHandler handler = new CRUDHandler();
		try
		{
		String C1="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO()});
		while (resultSet.next()) {
			pol_sys_id = resultSet.getLong("POL_SYS_ID");
			System.out.println("pol_sys_id:::::::"+pol_sys_id);	
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pol_sys_id;
	
		}
		
	public ArrayList<LovBean> prepareSuggestionList_AGENT_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			System.out.println("inside execute query");
			query = PT_IL_POLICY_QUERY_CONSTANTS.POBH_ORI_AGENT_CODE_QUERY;
			if ("*".equals(code)) {
				query = PT_IL_POLICY_QUERY_CONSTANTS.POBH_ORI_AGENT_CODE_QUERY;
				object = new Object[] { PELConstants.suggetionRecordSize };
				
			} else {
				query = PT_IL_POLICY_QUERY_CONSTANTS.POBH_ORI_AGENT_CODE_QUERY_LIKE;
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public void whenButtonPressedprocess(ActionEvent event) throws Exception
	{
		
		Connection connection = null;
		ResultSet resultSet = null;
		String POL_REPL_POLICY_YN=null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		try {
			P_REPLACEMENT_POLICY(
					 PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO(),
					 PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_DATE());
			
			String C1="SELECT POL_REPL_POLICY_YN FROM PT_IL_POLICY WHERE POL_NO=?";
			resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO()});
			while (resultSet.next()) {
				POL_REPL_POLICY_YN = resultSet.getString("POL_REPL_POLICY_YN");
				System.out.println("flag Y/N::::::::"+POL_REPL_POLICY_YN);
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Processing Completed Successfully");
					getWarningMap().put("PROCESS",
					"Processing Completed Successfully");
							
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("REPL_POL_PROCESS", e.getMessage());
		}
	
	}

	public ArrayList<OracleParameter> P_REPLACEMENT_POLICY(
			Object P_POL_NO,
			Object P_DATE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param2);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_REPLACEMENT_POLICY.P_REPLACEMENT_POLICY");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	

	/*End*/
	
	/*Commentted & Modified by saritha on 24-08-2017 for ZBILQC-1725024*/
	
	/*public Double defaultCommission() throws Exception
	{
		Double commission=null;
		try{
			
			String Query="SELECT SUM(NVL(ACV_FC_VALUE, 0))FROM PT_AGENT_COMM_VALUES, PT_IL_POLICY, "
					+ "PT_IL_PREM_COLL WHERE ACV_POL_SYS_ID = POL_SYS_ID AND PC_POL_SYS_ID = POL_SYS_ID "
					+ " AND PC_POL_SYS_ID = ACV_POL_SYS_ID AND ACV_PC_SYS_ID = PC_SYS_ID AND "
					+ "ACV_COMM_TYPE = 'B' AND POL_NO = ? AND ACV_PC_SYS_ID "
					+ "IN (SELECT MIN(ACV_PC_SYS_ID) FROM PT_AGENT_COMM_VALUES WHERE ACV_POL_SYS_ID = POL_SYS_ID "
					+ "AND POL_NO = ? AND ACV_COMM_TYPE = 'B')";
			
			ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), 
					new Object[]{PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO(),
				PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO()});
			
			while(rs.next())
			{
				commission=rs.getDouble(1);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return commission;
	}*/
	
	public Double fun_Original_Commission() throws Exception {

		String function_Ori_Commission = "SELECT P9ILPK_REPLACEMENT_POLICY.F_ORI_COMM(?)  FROM DUAL  ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet_C1 = null;
		Double commission=null;

		try { 
			connection = CommonUtils.getConnection();
			resultSet_C1 = handler.executeSelectStatement(function_Ori_Commission,
					connection, new Object[]{ PT_IL_POL_BROKER_HEAD_ORIGINAL_BEAN.getPOBH_ORI_POL_NO()} );
			while (resultSet_C1.next()) {
				commission = resultSet_C1.getDouble(1);
				System.out.println("Original Commission:::"+commission);

			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet_C1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return commission;
	}
			
	/*End*/	
	
	}

	
