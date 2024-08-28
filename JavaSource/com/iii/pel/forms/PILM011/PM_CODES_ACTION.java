package com.iii.pel.forms.PILM011;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_CODES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_CODE_LABEL;

	private HtmlInputText COMP_PC_CODE;

	private HtmlOutputLabel COMP_PC_DESC_LABEL;

	private HtmlInputText COMP_PC_DESC;

	private PM_CODES PM_CODES_BEAN;
	
	private PM_IL_LOAN_SLAB_INTEREST PM_IL_LOAN_SLAB_INTEREST_BEAN;

	private UIData interestTable;

	private List<PM_IL_LOAN_SLAB_INTEREST> interestDetailList;

	public DataGridDelegate dataGridDelegate;
	
	private String PC_CODE;
	
	private String PC_DESC;
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private int currPage;
	
	private int recordsPerPage = 5;
	
	private int previousRow = -1; 
	
	private Hashtable<String , String> errors = new Hashtable<String, String>();
	
	//filters
	private String filterByLOAN_AMT_FROM;

	private String filterByLOAN_AMT_TO;
	
	private boolean update = false;
	
	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public PM_CODES_ACTION() {
		PM_CODES_BEAN = new PM_CODES();
		PM_IL_LOAN_SLAB_INTEREST_BEAN = new PM_IL_LOAN_SLAB_INTEREST();
		interestDetailList = new ArrayList<PM_IL_LOAN_SLAB_INTEREST>();
		dataGridDelegate = new DataGridDelegate();
////		System.out.println("PM_CODES_ACTION.PM_CODES_ACTION() >>>>   "+ResourceBundle.getBundle("messageProperties_PILM203.properties").getObject("PILM011$PM_CODES$PC_CODE$caption"));
//		DateFormat dateFormat = new SimpleDateFormat(getDateAndTimePattern());
//
//		try {
//			System.out.println("PM_CODES_ACTION.PM_CODES_ACTION() Date and Time: "+dateFormat.parse("2008/11/04"));
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		/*
		try {
			loadValues();
			if(interestDetailList.size() > 0){
				setPM_IL_LOAN_SLAB_INTEREST_BEAN(interestDetailList.get(0));
				PM_IL_LOAN_SLAB_INTEREST_BEAN.setRowSelected(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
	
	public Hashtable<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Hashtable<String, String> errors) {
		this.errors = errors;
	}
	
	public HtmlOutputLabel getCOMP_PC_CODE_LABEL() {
		return COMP_PC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PC_CODE() {
		return COMP_PC_CODE;
	}

	public void setCOMP_PC_CODE_LABEL(HtmlOutputLabel COMP_PC_CODE_LABEL) {
		this.COMP_PC_CODE_LABEL = COMP_PC_CODE_LABEL;
	}

	public void setCOMP_PC_CODE(HtmlInputText COMP_PC_CODE) {
		this.COMP_PC_CODE = COMP_PC_CODE;
	}

	public HtmlOutputLabel getCOMP_PC_DESC_LABEL() {
		return COMP_PC_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PC_DESC() {
		return COMP_PC_DESC;
	}

	public void setCOMP_PC_DESC_LABEL(HtmlOutputLabel COMP_PC_DESC_LABEL) {
		this.COMP_PC_DESC_LABEL = COMP_PC_DESC_LABEL;
	}

	public void setCOMP_PC_DESC(HtmlInputText COMP_PC_DESC) {
		this.COMP_PC_DESC = COMP_PC_DESC;
	}

	public PM_CODES getPM_CODES_BEAN() {
		return PM_CODES_BEAN;
	}

	public void setPM_CODES_BEAN(PM_CODES PM_CODES_BEAN) {
		this.PM_CODES_BEAN = PM_CODES_BEAN;
	}

	public void loadValues() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, Exception {
		FacesContext ctx = FacesContext.getCurrentInstance();	
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PC_CODE = req.getParameter("PC_CODE");		
	/*	if(req.getParameter("PC_CODE") == null) {
			return;
		}*/
		//getPM_CODES_BEAN().setPC_CODE(PC_CODE);
		//getPC_CODE_DESC(PC_CODE);
		executeQueryPM_IL_LOAN_SLAB_INTEREST();
	}
	
	public String getAllErrors() {
		String messageList = "    ";
		if(getErrors().size() > 0 ) {
			for(Enumeration<String> keys = getErrors().keys() ; keys.hasMoreElements() ; ) {
				String compId = keys.nextElement();
				String compError = getErrors().get(compId);
				messageList = messageList+compId+"-"+compError+" ; ";
			}
//			messageList = messageList ;
		} 
		return messageList;
	}

	
	public String addNew(){
		System.out.println("PM_CODES_ACTION.addNew()....");		
		int rowCount = 0;
		
		if(interestDetailList == null){
			interestDetailList = new ArrayList<PM_IL_LOAN_SLAB_INTEREST>();
		}
		
		
		// Settings to navigate to last page
		rowCount = getInterestTable().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
		return "";
	}
	
	public PM_IL_LOAN_SLAB_INTEREST whenCreateRecordPM_IL_LOAN_SLAB_INTEREST() {
		PM_IL_LOAN_SLAB_INTEREST bean = new PM_IL_LOAN_SLAB_INTEREST();
		bean.setLSI_INT_RATE_PER(100);
//		:PM_IL_LOAN_SLAB_INTEREST.LSI_INT_RATE_PER := 100;
		return bean;
	}
	 
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_INT_RATE_PER(100);
			if (isINSERT_ALLOWED()){
				PM_IL_LOAN_SLAB_INTEREST_BEAN = new PM_IL_LOAN_SLAB_INTEREST();
				resetAllComponent();
				resetSelectedRow();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	/*public String deleteRow(ActionEvent ae) {

		try{
		
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_LOAN_SLAB_INTEREST bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		
		if (interestDetailList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < interestDetailList.size();) {
				bean = interestDetailList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					interestDetailList.remove(bean);
					deletedRecordIndex = dataGridDelegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}
			if(interestDetailList.size() > 0) {
					setPM_IL_LOAN_SLAB_INTEREST_BEAN(interestDetailList.get(0));
					PM_IL_LOAN_SLAB_INTEREST_BEAN.setRowSelected(true);
			} else {
				AddRow(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$Grid$delete"));
				

			}
			lastUpdatedRowIndex = -1;

		}
		resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}*/
	public void deleteRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_LOAN_SLAB_INTEREST_BEAN,
						CommonUtils.getConnection());
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
				interestDetailList.remove(PM_IL_LOAN_SLAB_INTEREST_BEAN);
				if (interestDetailList.size() > 0) {
					PM_IL_LOAN_SLAB_INTEREST_BEAN = interestDetailList.get(0);
				} else if (interestDetailList.size() == 0) {

					AddRow(null);
				}

				resetAllComponent();
				PM_IL_LOAN_SLAB_INTEREST_BEAN.setRowSelected(true);
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
	
	public void post(ActionEvent ae) {
		DataGridDelegate delegate = new DataGridDelegate();
	    CommonUtils.clearMaps(this);
		try{
			if(PM_IL_LOAN_SLAB_INTEREST_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {

					preUpdatePM_IL_LOAN_SLAB_INTEREST(this.PM_IL_LOAN_SLAB_INTEREST_BEAN);
					new CRUDHandler().executeUpdate(PM_IL_LOAN_SLAB_INTEREST_BEAN, commonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if(isINSERT_ALLOWED()) {
					preInsertPM_IL_LOAN_SLAB_INTEREST(this.PM_IL_LOAN_SLAB_INTEREST_BEAN);
					new CRUDHandler().executeInsert(PM_IL_LOAN_SLAB_INTEREST_BEAN, commonUtils.getConnection());					
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					interestDetailList.add(0,PM_IL_LOAN_SLAB_INTEREST_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_LOAN_SLAB_INTEREST_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	
	public String  deleteRecords(){
		CRUDHandler handler=new CRUDHandler();
		Connection connection = null;
		
		
		try {
		if(isDELETE_ALLOWED()){
	
			connection = CommonUtils.getConnection();
		 handler.executeDelete(PM_CODES_BEAN, connection);
			connection.commit();
		PM_CODES_ACTION compositeAction = new PM_CODES_ACTION();
			
		CommonUtils.setGlobalObject("PM_CODES_ACTION", compositeAction);

			// Assigning message to new action class
			this.getWarningMap().put(
					"deleteRow",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$delete"));
		this.getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$delete"));
		}	else {

			getErrorMap().put("deleteRow", Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
		}
		
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		getErrorMap().put("deleteRow", exc.getMessage());
	}
	return null;
}

		

		
		
	
	
	public void checkBoxValidation(ActionEvent event) {
//		gridtabListener();
		CommonUtils.clearMaps(this);
	}
	
	public String searchPage() {
		return "PILM011searchPage";
	} 
	
	public void checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput component = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) component.getSubmittedValue();
		System.out.println("PM_CODES_ACTION.checkBoxStatus() value: "+value);		
		int currentIndex = getInterestTable().getRowIndex();
		PM_IL_LOAN_SLAB_INTEREST bean = getInterestDetailList().get(currentIndex);
		
		if("true".equals(value)) {
			bean.setCHECK_BOX(true);
		} else {
			bean.setCHECK_BOX(false);
		}
	}

	public void getPC_CODE_DESC(String PC_CODE) throws Exception {
//		P_VAL_CODES.P_VAL_CODES("IL_LOAN_CODE",:PM_CODES.PC_CODE,:PM_CODES.PC_DESC,"N","E",null);

		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","IL_LOAN_CODE");
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",PC_CODE);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT","");
		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
		OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");

		if(list.size() > 0) {
			if(list.get(0).getValue() ==null) {
				System.out.println("PM_CODES_ACTION.whenValidatePC_CODE() Description is NULL ");
			}
			getPM_CODES_BEAN().setPC_DESC(list.get(0).getValue());
		}
		//executeQueryPM_IL_LOAN_SLAB_INTEREST();
	}
	
	
	public void whenValidateLSI_INT_RATE_PER(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(getInterestTable().getRowIndex());
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), input);
		if(!"".equals(value)) {
			Integer loanAmountRatePer = Integer.valueOf(value);
			if(loanAmountRatePer < 0) {
				throwErrorMessage(componentCaption, Messages.getString("messageProperties", "fieldRange"));
				return;
			} else {
				//gridBean.setLSI_INT_RATE_PER(loanAmountRatePer);
				this.PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_INT_RATE_PER(loanAmountRatePer);
				removeErrorMessage(componentCaption);			}
			if(loanAmountRatePer != null && loanAmountRatePer == 0) {
				throwErrorMessage(componentCaption,Messages.getMessage(PELConstants.pelErrorMessagePath,"60111").getSummary());
			} else {
				removeErrorMessage(componentCaption);
			}
		} else {
			throwErrorMessage(componentCaption, Messages.getString("messageProperties", "fieldEntered"));
			
		}
		//gridtabListener();
	}
	
	
	public void whenValidateLSI_EFF_FM_DT(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(getInterestTable().getRowIndex());
		UIInput input = (UIInput) event.getComponent().getParent();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), input);
		String value = (String) input.getSubmittedValue();
		if(!"".equals(value)) {
			DateFormat dateFormat = new SimpleDateFormat(getDatePattern());
			try {
				Date fromDate = dateFormat.parse(value);
				//gridBean.setLSI_EFF_FM_DT(fromDate);
				this.PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_EFF_FM_DT(fromDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		/*System.out.println("PM_CODES_ACTION.whenValidateLSI_EFF_FM_DT()");
		int rowIndex = getInterestTable().getRowIndex();
		Date fromDate = interestDetailList.get(rowIndex).getLSI_EFF_FM_DT();
		Date toDate = interestDetailList.get(rowIndex).getLSI_EFF_TO_DT();
		
		if(fromDate != null && toDate != null ) {
			if(!fromDate.before(toDate)) {
				errorMap.put("current", "From Date Cannot be greater than the To Date !");
			}
		}*/
		
//		IF :PM_IL_LOAN_SLAB_INTEREST.LSI_EFF_FM_DT IS NOT NULL AND :PM_IL_LOAN_SLAB_INTEREST.LSI_EFF_TO_DT IS NOT NULL THEN
//		   IF :PM_IL_LOAN_SLAB_INTEREST.LSI_EFF_FM_DT > :PM_IL_LOAN_SLAB_INTEREST.LSI_EFF_TO_DT THEN
//			    STD_MESSAGE_ROUTINE('71145',:CTRL.M_LANG_CODE);
//		      RAISE FORM_TRIGGER_FAILURE;
//		      END IF;
//		END IF; 
		//gridtabListener();
	}
	
	public void whenValidateLSI_LOAN_AMT_FROM(ActionEvent event) {
		CommonUtils.clearMaps(this);
	//	PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(getInterestTable().getRowIndex());
		UIInput component = (UIInput) event.getComponent().getParent();
		String value = (String) component.getSubmittedValue();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), component);
		if(!"".equals(value) ) {
			try{
				Double fromAmount = Double.valueOf(value);
				if(fromAmount < 0) {
					throwErrorMessage(componentCaption, Messages.getString("messageProperties", "fieldRange"));
				} else {
					//gridBean.setLSI_LOAN_AMT_FROM(fromAmount);
					this.PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_LOAN_AMT_FROM(fromAmount);
					removeErrorMessage(componentCaption);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throwErrorMessage(componentCaption, Messages.getString("messageProperties", "fieldEntered") );
		}
		//gridtabListener();
	}
	

	private void removeErrorMessage(String id) {
		getErrorMap().remove("current");
		getErrorMap().remove(id);
		getErrors().remove(id);
	}

	private void throwMessage(String message) {
		getErrorMap().put("current",message);
	}
	
	private void throwWarningMessage(String id,String string) {
		getWarningMap().put("current",string);
//		getWarningMap().put(id,id+" : "+string);
	}

	
	
	private void throwErrorMessage(String id , String string) {
		getErrorMap().put("current",string);
		getErrorMap().put(id,id+" : "+string);
		getErrors().put(id,string);
		getWarningMap().clear();
	}

	public void whenValidateLSI_EFF_TO_DT(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(getInterestTable().getRowIndex());
		String stringFromDate = (String)getCOMP_LSI_EFF_FM_DT().getSubmittedValue();

		UIInput component = (UIInput) event.getComponent().getParent();
		String stringToDate = (String) component.getSubmittedValue();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), component);
		
		System.out.println("PM_CODES_ACTION.whenValidateLSI_EFF_TO_DT() stringFromDate: "+stringFromDate);		

		if(!"".equals(stringFromDate) && !"".equals(stringToDate)) {
			Date fromDate = new Date(stringFromDate);
			Date dateToDate = new Date(stringToDate);
			//gridBean.setLSI_EFF_TO_DT(dateToDate);
			this.PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_EFF_TO_DT(dateToDate);
			if(fromDate!=null && dateToDate!=null) {
				if(fromDate.equals(dateToDate)) {
					removeErrorMessage(componentCaption);
				} else {
					if(!fromDate.before(dateToDate)) {
						throwErrorMessage(componentCaption, Messages.getMessage(PELConstants.pelErrorMessagePath,"71145").getSummary());
					} else {
						removeErrorMessage(componentCaption);
					}
				}
			} 
		} else {
			removeErrorMessage(componentCaption);
		}
		//lastColumnListener();
	}
	
	public void beforePhase(PhaseEvent event){
		PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_INT_RATE_PER(100);
		try {
			if(isBlockFlag()){
				if(PM_CODES_BEAN.getROWID() != null){
					executeSelectStatement(PM_CODES_BEAN.getROWID());
					executeQuery();
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	public void executeSelectStatement(String rowId) throws Exception{
	//	String codeValue = (String) getCOMP_PC_CODE().getSubmittedValue();
		//String descValue = (String) getCOMP_PC_DESC().getSubmittedValue();
		String selectQuery = "SELECT ROWID,PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_LOAN_CODE' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND ROWID = '"+rowId+"'";
		//String selectQuery = "SELECT ROWID,PM_CODES.* FROM PM_CODES WHERE ROWID='"+rowId+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_CODES> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM011.PM_CODES", 
					con);
		    setPM_CODES_BEAN(list.get(0));
			setUpdate(true);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void LSI_LOAN_AMT_FROM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_IL_LOAN_SLAB_INTEREST_BEAN().setLSI_LOAN_AMT_FROM((Double)value);
			whenValidateLSI_LOAN_AMT_VALIDATION(PM_IL_LOAN_SLAB_INTEREST_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void LSI_LOAN_AMT_TO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_IL_LOAN_SLAB_INTEREST_BEAN().setLSI_LOAN_AMT_TO((Double)value);
			whenValidateLSI_LOAN_AMT_VALIDATION(PM_IL_LOAN_SLAB_INTEREST_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void LSI_INT_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_IL_LOAN_SLAB_INTEREST_BEAN().setLSI_INT_RATE_PER((Integer)value);
			whenValidateLSI_INT_RATE_PER_VALIDATION(PM_IL_LOAN_SLAB_INTEREST_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void PC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_CODES_BEAN().setPC_CODE((String)value);
			whenValidatePC_CODE(PM_CODES_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	private void whenValidatePC_CODE(PM_CODES PM_CODES_BEAN) throws Exception{
		CommonUtils.clearMaps(this);
		try{
			ArrayList<String> outList = new DBProcedures().P_VAL_CODES("IL_LOAN_CODE", PM_CODES_BEAN.getPC_CODE(), "", "N", "E");
			if(outList.size()>0)
				PM_CODES_BEAN.setPC_DESC(outList.get(0));
					
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidateLSI_LOAN_AMT_VALIDATION(PM_IL_LOAN_SLAB_INTEREST PM_IL_LOAN_SLAB_INTEREST_BEAN) throws Exception{
		CommonUtils.clearMaps(this);
		try{
			if(PM_IL_LOAN_SLAB_INTEREST_BEAN.getLSI_LOAN_AMT_TO()!=null)
			if(CommonUtils.nvl(PM_IL_LOAN_SLAB_INTEREST_BEAN.getLSI_LOAN_AMT_TO(),0) <= CommonUtils.nvl(PM_IL_LOAN_SLAB_INTEREST_BEAN.getLSI_LOAN_AMT_FROM(),0))
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71027"));

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void whenValidateLSI_INT_RATE_PER_VALIDATION(PM_IL_LOAN_SLAB_INTEREST PM_IL_LOAN_SLAB_INTEREST_BEAN) throws Exception{
		CommonUtils.clearMaps(this);
		try{
			
			if(PM_IL_LOAN_SLAB_INTEREST_BEAN.getLSI_INT_RATE_PER()!=null &&
					PM_IL_LOAN_SLAB_INTEREST_BEAN.getLSI_INT_RATE_PER()== 0)
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


	
	/*public void whenValidateLSI_INT_RATE(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//int currRowIndex = getInterestTable().getRowIndex();
		//PM_IL_LOAN_SLAB_INTEREST gridBean = getInterestDetailList().get(currRowIndex);
		UIInput component = (UIInput)event.getComponent().getParent();
		String LSI_INT_RATE = (String) component.getSubmittedValue();
		String componentCaption = ErrorHelpUtil.findFieldName(FacesContext.getCurrentInstance(), component);
		
		if(!"".equals(LSI_INT_RATE) && LSI_INT_RATE != null ) {
			Double doubleLSI_INT_RATE = Double.valueOf(LSI_INT_RATE);
			
			if(doubleLSI_INT_RATE < 0) {
				throwErrorMessage(componentCaption, Messages.getString("messageProperties", "fieldRange"));
				return;
			} else {
				//gridBean.setLSI_INT_RATE(doubleLSI_INT_RATE);
				this.PM_IL_LOAN_SLAB_INTEREST_BEAN.setLSI_INT_RATE(doubleLSI_INT_RATE);
				removeErrorMessage(componentCaption);
				return;
			}
		} else {
			throwErrorMessage(componentCaption, Messages.getString("messageProperties", "fieldEntered") );
		}
		//gridtabListener();
	}*/
	
	public List displayLov(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		ResultSet rs = null;
		if(obj.toString().equals("*")){
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_LOAN_CODE' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND  rownum < 25";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE='"+obj+"' AND PC_TYPE='IL_LOAN_CODE' AND NVL(PC_FRZ_FLAG,'N') = 'N' and rownum < 25";
		}
		try{
		rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			AssuredCodeLovBean bean = new AssuredCodeLovBean();
			bean.setCode(rs.getString("PC_CODE"));
			bean.setName(rs.getString("PC_DESC"));
			suggesionList.add(bean);
		}
		}catch(Exception e){
			getWarningMap().put("displayLov", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
			rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return suggesionList;
	}

	public Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public UIData getInterestTable() {
		return interestTable;
	}

	public void setInterestTable(UIData interestTable) {
		this.interestTable = interestTable;
	}

	public List<PM_IL_LOAN_SLAB_INTEREST> getInterestDetailList() {
//		int size = interestDetailList.size();
//		if(size == 0) {
//			for(int i=0 ; i < 5;i++) {
//				PM_IL_LOAN_SLAB_INTEREST bean = new PM_IL_LOAN_SLAB_INTEREST();
//				interestDetailList.add(bean);
//			}
//		}
		return interestDetailList;
	}


	public void setInterestDetailList(
			List<PM_IL_LOAN_SLAB_INTEREST> interestDetailList) {
		this.interestDetailList = interestDetailList;
	}

	public PM_IL_LOAN_SLAB_INTEREST getPM_IL_LOAN_SLAB_INTEREST_BEAN() {
		return PM_IL_LOAN_SLAB_INTEREST_BEAN;
	}

	public void setPM_IL_LOAN_SLAB_INTEREST_BEAN(
			PM_IL_LOAN_SLAB_INTEREST pm_il_loan_slab_interest_bean) {
		PM_IL_LOAN_SLAB_INTEREST_BEAN = pm_il_loan_slab_interest_bean;
	}

	public String combinedSave() {
		dataGridDelegate.saveData(this);
		getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		return null;
	}
	public void save() {
		CommonUtils.clearMaps(this);
		try {
			if (getPM_IL_LOAN_SLAB_INTEREST_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPM_IL_LOAN_SLAB_INTEREST_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeUpdate(getPM_IL_LOAN_SLAB_INTEREST_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
			String message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE",
					message);
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

   
	public void preBlock() {
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		IF FORM_FAILURE THEN
//		:GLOBAL.M_FAILURE := 'TRUE';
//		END IF;
//		:CTRL.M_DELETE_MSG_FLAG := 'N';
	}

	@SuppressWarnings("unchecked")
	public void executeQueryPM_IL_LOAN_SLAB_INTEREST() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, Exception {
		//String PC_CODEValue = (String) getCOMP_PC_CODE().getSubmittedValue();
		/*if(PC_CODE == null || "".equals(PC_CODE)) {
			throw new RuntimeException("PC_CODE is empty................");
		}*/
		String exeQuery = " SELECT PM_IL_LOAN_SLAB_INTEREST.ROWID, PM_IL_LOAN_SLAB_INTEREST.* FROM " +
				" PM_IL_LOAN_SLAB_INTEREST,PM_CODES WHERE " +
				" PM_CODES.PC_CODE = PM_IL_LOAN_SLAB_INTEREST.LSI_LOAN_CODE AND" +
				" PM_IL_LOAN_SLAB_INTEREST.LSI_LOAN_CODE=(SELECT PC_CODE FROM PM_CODES WHERE ROWID='"+PM_CODES_BEAN.getROWID()+"')";
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_LOAN_SLAB_INTEREST> interestList = handler.fetch(exeQuery, "com.iii.pel.forms.PILM011.PM_IL_LOAN_SLAB_INTEREST", getConnection());
		interestDetailList = postQuery(interestList, PM_CODES_BEAN.getPC_CODE(), PM_CODES_BEAN.getPC_DESC());
		
		PM_IL_LOAN_SLAB_INTEREST PM_IL_LOAN_SLAB_INTEREST_BEAN = null;
		
		Iterator<PM_IL_LOAN_SLAB_INTEREST> iterator = interestList.iterator();
		while(iterator.hasNext()){
			PM_IL_LOAN_SLAB_INTEREST_BEAN = iterator.next();
			PM_IL_LOAN_SLAB_INTEREST_BEAN.setRowSelected(false);
		}
		
		this.setInterestDetailList(interestList);
		if (interestList.size() !=0){					
			setPM_IL_LOAN_SLAB_INTEREST_BEAN(interestList.get(0));
			getPM_IL_LOAN_SLAB_INTEREST_BEAN().setRowSelected(true);
		}
	}

	public List<PM_IL_LOAN_SLAB_INTEREST> postQuery(List<PM_IL_LOAN_SLAB_INTEREST> interestList, String PC_CODE, String PC_DESC) throws Exception {
//		P_VAL_CODES('IL_LOAN_CODE',:PM_CODES.PC_CODE,:PM_CODES.PC_DESC,'N','N',NULL);

		List<PM_IL_LOAN_SLAB_INTEREST> postQueryList = new ArrayList<PM_IL_LOAN_SLAB_INTEREST>();

		for(Iterator<PM_IL_LOAN_SLAB_INTEREST> iterator = interestList.iterator() ; iterator.hasNext() ; ) {

			PM_IL_LOAN_SLAB_INTEREST interestBean = iterator.next();

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN","IL_LOAN_CODE");
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",PC_CODE);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",PC_DESC);
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'N'");
			OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			paramList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");

			postQueryList.add(interestBean);
		}
		return postQueryList;
	}


//	public void toDateValidation(ActionEvent actionEvent)
//	{
//		getCurrentValue(actionEvent);
//		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
//		String value = (String) inputText.getSubmittedValue();
//		System.out.println("Last column value:"+value);
//		if(value == null || value.trim().isEmpty()) {
//			System.out.println("value should not be null");
//		}
//		else {
//			int rowIndex = getInterestTable().getRowIndex();
//			interestDetailList.get(rowIndex).setRSA_RATE_PER(Double.parseDouble(value));
//			lastColumnListener();
//		}
//	}

	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;

		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public String executeQuery() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, Exception{
		loadValues();
		return "mainPage";
	}
	
	boolean areAllMandatoryFieldsFilled(PM_IL_LOAN_SLAB_INTEREST bean) {
		if(isValueAvailable(bean.getLSI_LOAN_AMT_FROM()) && 
				isValueAvailable(bean.getLSI_LOAN_AMT_TO()) &&
				isValueAvailable(bean.getLSI_INT_RATE_PER()) &&
				isValueAvailable(bean.getLSI_INT_RATE()) ) {
			return true;
		}
		return false;
	}
	
	boolean isValueAvailable(Object obj) {
		if(!"".equals(obj) && obj != null ) {
			return true;
		}
		return false;
	}
	
	public void lastColumnListener() {
		System.out.println("PM_CODES_ACTION.lastColumnListener()....");		
		int currRowIndex = getInterestTable().getRowIndex();
		PM_IL_LOAN_SLAB_INTEREST gridValueBean = (PM_IL_LOAN_SLAB_INTEREST)interestDetailList.get(currRowIndex);
		if(getErrors().size() == 0 && areAllMandatoryFieldsFilled(gridValueBean)) {
			saveRecord(gridValueBean);
		} else {
			throwMessage(getAllErrors());
		}
	}
	
	private int saveRecord(PM_IL_LOAN_SLAB_INTEREST gridValueBean) {
		int currRowIndex = getInterestTable().getRowIndex();
		int rowUpdated = 0;
		try {
			gridValueBean.setLSI_LOAN_CODE(PM_CODES_BEAN.getPC_CODE());
			System.out.println("PM_CODES_ACTION.lastColumnListener() getErrors(): "+getErrors());
			
			String fromDateString = null;
			String toDateString = null;
			
			DateFormat format = new SimpleDateFormat(getDatePattern());
			if(gridValueBean.getLSI_EFF_FM_DT() != null && gridValueBean.getLSI_EFF_TO_DT() != null) {
				fromDateString = "'"+format.format(gridValueBean.getLSI_EFF_FM_DT()).toUpperCase()+"'";
				toDateString = "'"+format.format(gridValueBean.getLSI_EFF_FM_DT()).toUpperCase()+"'";
			}
			
			if(gridValueBean.getROWID()!=null) {
				String updateQuery = "SELECT 'X' FROM PM_IL_LOAN_SLAB_INTEREST " +
				"WHERE LSI_LOAN_CODE = '"+gridValueBean.getLSI_LOAN_CODE()+"' " +
				"AND ((("+gridValueBean.getLSI_LOAN_AMT_FROM()+" BETWEEN LSI_LOAN_AMT_FROM AND LSI_LOAN_AMT_TO) OR ("+gridValueBean.getLSI_LOAN_AMT_TO()+" BETWEEN LSI_LOAN_AMT_FROM AND LSI_LOAN_AMT_TO)) " +
				"OR ((LSI_LOAN_AMT_FROM BETWEEN "+gridValueBean.getLSI_LOAN_AMT_FROM()+" AND "+gridValueBean.getLSI_LOAN_AMT_TO()+") OR (LSI_LOAN_AMT_TO   BETWEEN "+gridValueBean.getLSI_LOAN_AMT_FROM()+" AND "+gridValueBean.getLSI_LOAN_AMT_TO()+"))) " +
				"AND (((NVL("+fromDateString+",TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(LSI_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(LSI_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR (NVL("+toDateString+",TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(LSI_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(LSI_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))) " +
				"OR ((NVL(LSI_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL("+fromDateString+",TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL("+toDateString+",TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR (NVL(LSI_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL("+fromDateString+",TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL("+toDateString+",TO_DATE('31/12/2999','DD/MM/RRRR'))))) " +
				"AND ROWID  != '"+gridValueBean.getROWID()+"' " ;
				boolean exists = L_VALIDATE_RANGE(gridValueBean,updateQuery);
				if(!exists) {
					System.out.println("PM_CODES_ACTION Record Saving...............");					
					preUpdatePM_IL_LOAN_SLAB_INTEREST(gridValueBean);
					rowUpdated = dataGridDelegate.updateData(gridValueBean);
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					//throwWarningMessage("Record",rowUpdated+" record updated.");
					getErrors().clear();
				} else {
					throwMessage(Messages.getMessage(PELConstants.pelErrorMessagePath,"71015").getSummary());
				}
			} else {
				String insertQuery = "SELECT 'X' FROM PM_IL_LOAN_SLAB_INTEREST " +
				"WHERE LSI_LOAN_CODE = '"+gridValueBean.getLSI_LOAN_CODE()+"' " +
				"AND ((("+gridValueBean.getLSI_LOAN_AMT_FROM()+" BETWEEN LSI_LOAN_AMT_FROM AND LSI_LOAN_AMT_TO) OR ("+gridValueBean.getLSI_LOAN_AMT_TO()+" BETWEEN LSI_LOAN_AMT_FROM AND LSI_LOAN_AMT_TO)) " +
				"OR ((LSI_LOAN_AMT_FROM BETWEEN "+gridValueBean.getLSI_LOAN_AMT_FROM()+" AND "+gridValueBean.getLSI_LOAN_AMT_TO()+") OR (LSI_LOAN_AMT_TO BETWEEN "+gridValueBean.getLSI_LOAN_AMT_FROM()+" AND "+gridValueBean.getLSI_LOAN_AMT_TO()+"))) " +
				"AND (((NVL("+fromDateString+",TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(LSI_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(LSI_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR (NVL("+toDateString+",TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(LSI_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(LSI_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))) " +
				"OR ((NVL(LSI_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL("+fromDateString+",TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL("+toDateString+",TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR (NVL(LSI_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL("+fromDateString+",TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL("+toDateString+",TO_DATE('31/12/2999','DD/MM/RRRR'))))) ";
				
				boolean exists = L_VALIDATE_RANGE(gridValueBean,insertQuery);
				
				if(!exists) {
					System.out.println("PM_CODES_ACTION Record Updating...............");					
					preInsertPM_IL_LOAN_SLAB_INTEREST(gridValueBean);
					rowUpdated = dataGridDelegate.updateData(gridValueBean);
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					//throwWarningMessage("Record",rowUpdated+" record inserted.");
					getErrors().clear();
				} else {
					throwMessage(Messages.getMessage(PELConstants.pelErrorMessagePath,"71015").getSummary());
				}
			}

			lastUpdatedRowIndex = currRowIndex ;
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		return rowUpdated;
	} 
	
	private boolean L_VALIDATE_RANGE(PM_IL_LOAN_SLAB_INTEREST gridValueBean,String query) {
		try{
			System.out.println("PM_CODES_ACTION.L_VALIDATE_RANGE() query: "+query);
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;			
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private void preUpdatePM_IL_LOAN_SLAB_INTEREST(PM_IL_LOAN_SLAB_INTEREST gridValueBean) {
//		P_VAL_CODES('IL_LOAN_CODE',:PM_CODES.PC_CODE,:PM_CODES.PC_DESC,'N','E',NULL);
//		L_VALIDATE_RANGE;
//		:PM_IL_LOAN_SLAB_INTEREST.LSI_UPD_DT  := SYSDATE;
//		:PM_IL_LOAN_SLAB_INTEREST.LSI_UPD_UID := :CTRL.M_USER_ID;
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String userName = (String) sessionMap.get("GLOBAL.M_USER_ID");
		gridValueBean.setLSI_UPD_DT(new Date());
		gridValueBean.setLSI_UPD_UID(userName);		
		
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","IL_LOAN_CODE");
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",PM_CODES_BEAN.getPC_CODE());
		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",PM_CODES_BEAN.getPC_DESC());
		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
		OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");
			PM_CODES_BEAN.setPC_DESC(list.get(0).getValue());
		} catch (Exception e) {
			e.printStackTrace();
//			ErrorHelpUtil.getErrorsforProcedure(getConnection(), FacesContext.getCurrentInstance(),(UIInput)getCOMP_POAD_ASSRD_REF_ID2(), ((UIInput)getCOMP_POAD_ASSRD_REF_ID2()).getId());
		}
		
	}
	
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}

	private void preInsertPM_IL_LOAN_SLAB_INTEREST(PM_IL_LOAN_SLAB_INTEREST gridValueBean) {
//		P_VAL_CODES('IL_LOAN_CODE',:PM_CODES.PC_CODE,:PM_CODES.PC_DESC,'N','E',NULL);
//		L_VALIDATE_RANGE;
//		:PM_IL_LOAN_SLAB_INTEREST.LSI_CR_DT    := SYSDATE;
//		:PM_IL_LOAN_SLAB_INTEREST.LSI_CR_UID   :=  :CTRL.M_USER_ID;
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String userName = (String) sessionMap.get("GLOBAL.M_USER_ID");
		gridValueBean.setLSI_CR_UID(userName);
		gridValueBean.setLSI_CR_DT(new Date());

		
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","IL_LOAN_CODE");
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",PM_CODES_BEAN.getPC_CODE());
		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",PM_CODES_BEAN.getPC_DESC());
		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
		OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");
			PM_CODES_BEAN.setPC_DESC(list.get(0).getValue());
			gridValueBean.setLSI_LOAN_CODE(PM_CODES_BEAN.getPC_CODE());
			
		} catch (Exception e) {
			e.printStackTrace();
//			ErrorHelpUtil.getErrorsforProcedure(getConnection(), FacesContext.getCurrentInstance(),(UIInput)getCOMP_POAD_ASSRD_REF_ID2(), ((UIInput)getCOMP_POAD_ASSRD_REF_ID2()).getId());
		}
	}
	
//	public void fieldFocusListener(ActionEvent event) {
//		if(true) {
//			return;
//		}
//		int currentRow = getInterestTable().getRowIndex();
//		if( currentRow != previousRow && previousRow != -1) {
//			if(getErrors().size() == 0) {
//				saveRecord(previousRow);
//				previousRow = currentRow;
//			}
//			previousRow = currentRow;	
//		} else {
//			previousRow = currentRow;
//		}
//	}

	
	/*public void gridtabListener(){
		int currRowIndex = getInterestTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_LOAN_SLAB_INTEREST gridValueBean = null;
		System.out.println(lastUpdatedRowIndex+"   "+currRowIndex+"  "+prevRowIndex);
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_IL_LOAN_SLAB_INTEREST)interestDetailList.get(prevRowIndex);

						System.out.println("PM_CODES_ACTION.gridtabListener() Size: "+getErrorMap().size());
						
							// Update the record to database
							if(gridValueBean.getROWID()!=null)
							{
								rowUpdated = dataGridDelegate.updateData(gridValueBean);
								throwWarningMessage("Record",rowUpdated+" record updated.");
								throwMessage(rowUpdated+" record updated.");
							}else {
//								gridValueBean.setRSA_PLAN_CODE("dee");
								rowUpdated = dataGridDelegate.updateData(gridValueBean);
								throwWarningMessage("Record",rowUpdated+" record inserted.");
							}
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		
		return ;
	}
*/
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = interestTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
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
	
	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			if (interestDetailList.size() != 0) {				
				PM_IL_LOAN_SLAB_INTEREST_BEAN = (PM_IL_LOAN_SLAB_INTEREST) interestTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_LOAN_SLAB_INTEREST_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_LSI_LOAN_AMT_FROM.resetValue();
		COMP_LSI_LOAN_AMT_TO.resetValue();
		COMP_LSI_INT_RATE.resetValue();
		COMP_LSI_EFF_FM_DT.resetValue();
		COMP_LSI_EFF_TO_DT.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_LOAN_SLAB_INTEREST> iterator = interestDetailList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	
	private HtmlOutputLabel COMP_LSI_LOAN_AMT_FROM_LABEL;

	private HtmlInputText COMP_LSI_LOAN_AMT_FROM;

	private HtmlOutputLabel COMP_LSI_LOAN_AMT_TO_LABEL;

	private HtmlInputText COMP_LSI_LOAN_AMT_TO;

	private HtmlOutputLabel COMP_LSI_INT_RATE_LABEL;

	private HtmlInputText COMP_LSI_INT_RATE;

	private HtmlOutputLabel COMP_LSI_INT_RATE_PER_LABEL;

	private HtmlInputText COMP_LSI_INT_RATE_PER;

	private HtmlOutputLabel COMP_LSI_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_LSI_EFF_FM_DT;

	private HtmlOutputLabel COMP_LSI_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_LSI_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_LOV;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public HtmlOutputLabel getCOMP_LSI_LOAN_AMT_FROM_LABEL() {
		return COMP_LSI_LOAN_AMT_FROM_LABEL;
	}

	public HtmlInputText getCOMP_LSI_LOAN_AMT_FROM() {
		return COMP_LSI_LOAN_AMT_FROM;
	}

	public void setCOMP_LSI_LOAN_AMT_FROM_LABEL(HtmlOutputLabel COMP_LSI_LOAN_AMT_FROM_LABEL) {
		this.COMP_LSI_LOAN_AMT_FROM_LABEL = COMP_LSI_LOAN_AMT_FROM_LABEL;
	}

	public void setCOMP_LSI_LOAN_AMT_FROM(HtmlInputText COMP_LSI_LOAN_AMT_FROM) {
		this.COMP_LSI_LOAN_AMT_FROM = COMP_LSI_LOAN_AMT_FROM;
	}

	public HtmlOutputLabel getCOMP_LSI_LOAN_AMT_TO_LABEL() {
		return COMP_LSI_LOAN_AMT_TO_LABEL;
	}

	public HtmlInputText getCOMP_LSI_LOAN_AMT_TO() {
		return COMP_LSI_LOAN_AMT_TO;
	}

	public void setCOMP_LSI_LOAN_AMT_TO_LABEL(HtmlOutputLabel COMP_LSI_LOAN_AMT_TO_LABEL) {
		this.COMP_LSI_LOAN_AMT_TO_LABEL = COMP_LSI_LOAN_AMT_TO_LABEL;
	}

	public void setCOMP_LSI_LOAN_AMT_TO(HtmlInputText COMP_LSI_LOAN_AMT_TO) {
		this.COMP_LSI_LOAN_AMT_TO = COMP_LSI_LOAN_AMT_TO;
	}

	public HtmlOutputLabel getCOMP_LSI_INT_RATE_LABEL() {
		return COMP_LSI_INT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_LSI_INT_RATE() {
		return COMP_LSI_INT_RATE;
	}

	public void setCOMP_LSI_INT_RATE_LABEL(HtmlOutputLabel COMP_LSI_INT_RATE_LABEL) {
		this.COMP_LSI_INT_RATE_LABEL = COMP_LSI_INT_RATE_LABEL;
	}

	public void setCOMP_LSI_INT_RATE(HtmlInputText COMP_LSI_INT_RATE) {
		this.COMP_LSI_INT_RATE = COMP_LSI_INT_RATE;
	}

	public HtmlOutputLabel getCOMP_LSI_INT_RATE_PER_LABEL() {
		return COMP_LSI_INT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_LSI_INT_RATE_PER() {
		return COMP_LSI_INT_RATE_PER;
	}

	public void setCOMP_LSI_INT_RATE_PER_LABEL(HtmlOutputLabel COMP_LSI_INT_RATE_PER_LABEL) {
		this.COMP_LSI_INT_RATE_PER_LABEL = COMP_LSI_INT_RATE_PER_LABEL;
	}

	public void setCOMP_LSI_INT_RATE_PER(HtmlInputText COMP_LSI_INT_RATE_PER) {
		this.COMP_LSI_INT_RATE_PER = COMP_LSI_INT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_LSI_EFF_FM_DT_LABEL() {
		return COMP_LSI_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LSI_EFF_FM_DT() {
		return COMP_LSI_EFF_FM_DT;
	}

	public void setCOMP_LSI_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_LSI_EFF_FM_DT_LABEL) {
		this.COMP_LSI_EFF_FM_DT_LABEL = COMP_LSI_EFF_FM_DT_LABEL;
	}

	public void setCOMP_LSI_EFF_FM_DT(HtmlCalendar COMP_LSI_EFF_FM_DT) {
		this.COMP_LSI_EFF_FM_DT = COMP_LSI_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_LSI_EFF_TO_DT_LABEL() {
		return COMP_LSI_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LSI_EFF_TO_DT() {
		return COMP_LSI_EFF_TO_DT;
	}

	public void setCOMP_LSI_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_LSI_EFF_TO_DT_LABEL) {
		this.COMP_LSI_EFF_TO_DT_LABEL = COMP_LSI_EFF_TO_DT_LABEL;
	}

	public void setCOMP_LSI_EFF_TO_DT(HtmlCalendar COMP_LSI_EFF_TO_DT) {
		this.COMP_LSI_EFF_TO_DT = COMP_LSI_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_LOV() {
		return COMP_UI_M_BUT_LOAN_LOV;
	}

	public void setCOMP_UI_M_BUT_LOAN_LOV(HtmlCommandButton COMP_UI_M_BUT_LOAN_LOV) {
		this.COMP_UI_M_BUT_LOAN_LOV = COMP_UI_M_BUT_LOAN_LOV;
	}

	public String getFilterByLOAN_AMT_FROM() {
		return filterByLOAN_AMT_FROM;
	}

	public void setFilterByLOAN_AMT_FROM(String filterByLOAN_AMT_FROM) {
		this.filterByLOAN_AMT_FROM = filterByLOAN_AMT_FROM;
	}

	public String getFilterByLOAN_AMT_TO() {
		return filterByLOAN_AMT_TO;
	}

	public void setFilterByLOAN_AMT_TO(String filterByLOAN_AMT_TO) {
		this.filterByLOAN_AMT_TO = filterByLOAN_AMT_TO;
	}

	public String getPC_CODE() {
		return PC_CODE;
	}

	public void setPC_CODE(String pc_code) {
		PC_CODE = pc_code;
	}

	public String getPC_DESC() {
		return PC_DESC;
	}

	public void setPC_DESC(String pc_desc) {
		PC_DESC = pc_desc;
	}
}
