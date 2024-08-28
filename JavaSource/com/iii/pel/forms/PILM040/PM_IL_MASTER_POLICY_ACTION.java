package com.iii.pel.forms.PILM040;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_COMPOSITE_ACTION;
import com.iii.premia.application.ConnectionAgentServlet;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.ConvertFunctions;

public class PM_IL_MASTER_POLICY_ACTION extends CommonAction
{

	private HtmlOutputLabel COMP_MP_CUST_CODE_LABEL;
	
	private HtmlCommandButton preFormButton;

	private HtmlInputText COMP_MP_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_MP_CUST_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MP_CUST_CODE_DESC;

	private HtmlOutputLabel COMP_MP_PROD_CODE_LABEL;

	private HtmlInputText COMP_MP_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_MP_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MP_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_MP_POL_NO_LABEL;

	private HtmlInputText COMP_MP_POL_NO;

	private HtmlOutputLabel COMP_MP_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_MP_ISSUE_DT;

	private HtmlOutputLabel COMP_MP_POL_FM_DT_LABEL;

	private HtmlCalendar COMP_MP_POL_FM_DT;

	private HtmlOutputLabel COMP_MP_LC_MAX_TPD_BNF_LABEL;

	private HtmlInputText COMP_MP_LC_MAX_TPD_BNF;

	private HtmlOutputLabel COMP_MP_PRE_TPD_BNF_MONTHS_LABEL;

	private HtmlInputText COMP_MP_PRE_TPD_BNF_MONTHS;

	private HtmlOutputLabel COMP_MP_LC_FUNERAL_EXP_LMT_LABEL;

	private HtmlInputText COMP_MP_LC_FUNERAL_EXP_LMT;

	private HtmlOutputLabel COMP_MP_LC_FUNERAL_EXP_AMT_LABEL;

	private HtmlInputText COMP_MP_LC_FUNERAL_EXP_AMT;

	private HtmlOutputLabel COMP_MP_CLM_INTM_DAYS_LABEL;

	private HtmlInputText COMP_MP_CLM_INTM_DAYS;

	private HtmlOutputLabel COMP_MP_NOTICE_PRD_LABEL;

	private HtmlInputText COMP_MP_NOTICE_PRD;

	private HtmlOutputLabel COMP_MP_LC_FCL_LABEL;

	private HtmlInputText COMP_MP_LC_FCL;

	private HtmlCommandButton COMP_UI_M_BUT_PROD_CODE;

	private PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN;
	
	
	
	private String lov_Desc ;
	
	Map<String, String> keyValue = new HashMap<String, String>();
	
	private List suggestionList = new ArrayList();
	
	private int rowIndex ;

	private UIData dataTable;
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PM_IL_MASTER_POLICY_ACTION() {
		PM_IL_MASTER_POLICY_BEAN = new PM_IL_MASTER_POLICY();
		PM_IL_MASTER_POLICY_HELPER helper=new PM_IL_MASTER_POLICY_HELPER();
		PM_IL_MASTER_POLICY_DELEGATE delegate = new PM_IL_MASTER_POLICY_DELEGATE();
		//pre-form not to be called
		//helper.pm_il_master_policy_when_new_form_instance(PM_IL_MASTER_POLICY_BEAN);
		
	}

	public HtmlOutputLabel getCOMP_MP_CUST_CODE_LABEL() {
		return COMP_MP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MP_CUST_CODE() {
		return COMP_MP_CUST_CODE;
	}

	public void setCOMP_MP_CUST_CODE_LABEL(HtmlOutputLabel COMP_MP_CUST_CODE_LABEL) {
		this.COMP_MP_CUST_CODE_LABEL = COMP_MP_CUST_CODE_LABEL;
	}

	public void setCOMP_MP_CUST_CODE(HtmlInputText COMP_MP_CUST_CODE) {
		this.COMP_MP_CUST_CODE = COMP_MP_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MP_CUST_CODE_DESC_LABEL() {
		return COMP_UI_M_MP_CUST_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MP_CUST_CODE_DESC() {
		return COMP_UI_M_MP_CUST_CODE_DESC;
	}

	public void setCOMP_UI_M_MP_CUST_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_MP_CUST_CODE_DESC_LABEL) {
		this.COMP_UI_M_MP_CUST_CODE_DESC_LABEL = COMP_UI_M_MP_CUST_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MP_CUST_CODE_DESC(HtmlInputText COMP_UI_M_MP_CUST_CODE_DESC) {
		this.COMP_UI_M_MP_CUST_CODE_DESC = COMP_UI_M_MP_CUST_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_MP_PROD_CODE_LABEL() {
		return COMP_MP_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MP_PROD_CODE() {
		return COMP_MP_PROD_CODE;
	}

	public void setCOMP_MP_PROD_CODE_LABEL(HtmlOutputLabel COMP_MP_PROD_CODE_LABEL) {
		this.COMP_MP_PROD_CODE_LABEL = COMP_MP_PROD_CODE_LABEL;
	}

	public void setCOMP_MP_PROD_CODE(HtmlInputText COMP_MP_PROD_CODE) {
		this.COMP_MP_PROD_CODE = COMP_MP_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MP_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_MP_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MP_PROD_CODE_DESC() {
		return COMP_UI_M_MP_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_MP_PROD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_MP_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_MP_PROD_CODE_DESC_LABEL = COMP_UI_M_MP_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MP_PROD_CODE_DESC(HtmlInputText COMP_UI_M_MP_PROD_CODE_DESC) {
		this.COMP_UI_M_MP_PROD_CODE_DESC = COMP_UI_M_MP_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_MP_POL_NO_LABEL() {
		return COMP_MP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_MP_POL_NO() {
		return COMP_MP_POL_NO;
	}

	public void setCOMP_MP_POL_NO_LABEL(HtmlOutputLabel COMP_MP_POL_NO_LABEL) {
		this.COMP_MP_POL_NO_LABEL = COMP_MP_POL_NO_LABEL;
	}

	public void setCOMP_MP_POL_NO(HtmlInputText COMP_MP_POL_NO) {
		this.COMP_MP_POL_NO = COMP_MP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_MP_ISSUE_DT_LABEL() {
		return COMP_MP_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_MP_ISSUE_DT() {
		return COMP_MP_ISSUE_DT;
	}

	public void setCOMP_MP_ISSUE_DT_LABEL(HtmlOutputLabel COMP_MP_ISSUE_DT_LABEL) {
		this.COMP_MP_ISSUE_DT_LABEL = COMP_MP_ISSUE_DT_LABEL;
	}

	public void setCOMP_MP_ISSUE_DT(HtmlCalendar COMP_MP_ISSUE_DT) {
		this.COMP_MP_ISSUE_DT = COMP_MP_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_MP_POL_FM_DT_LABEL() {
		return COMP_MP_POL_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_MP_POL_FM_DT() {
		return COMP_MP_POL_FM_DT;
	}

	public void setCOMP_MP_POL_FM_DT_LABEL(HtmlOutputLabel COMP_MP_POL_FM_DT_LABEL) {
		this.COMP_MP_POL_FM_DT_LABEL = COMP_MP_POL_FM_DT_LABEL;
	}

	public void setCOMP_MP_POL_FM_DT(HtmlCalendar COMP_MP_POL_FM_DT) {
		this.COMP_MP_POL_FM_DT = COMP_MP_POL_FM_DT;
	}

	public HtmlOutputLabel getCOMP_MP_LC_MAX_TPD_BNF_LABEL() {
		return COMP_MP_LC_MAX_TPD_BNF_LABEL;
	}

	public HtmlInputText getCOMP_MP_LC_MAX_TPD_BNF() {
		return COMP_MP_LC_MAX_TPD_BNF;
	}

	public void setCOMP_MP_LC_MAX_TPD_BNF_LABEL(HtmlOutputLabel COMP_MP_LC_MAX_TPD_BNF_LABEL) {
		this.COMP_MP_LC_MAX_TPD_BNF_LABEL = COMP_MP_LC_MAX_TPD_BNF_LABEL;
	}

	public void setCOMP_MP_LC_MAX_TPD_BNF(HtmlInputText COMP_MP_LC_MAX_TPD_BNF) {
		this.COMP_MP_LC_MAX_TPD_BNF = COMP_MP_LC_MAX_TPD_BNF;
	}

	public HtmlOutputLabel getCOMP_MP_PRE_TPD_BNF_MONTHS_LABEL() {
		return COMP_MP_PRE_TPD_BNF_MONTHS_LABEL;
	}

	public HtmlInputText getCOMP_MP_PRE_TPD_BNF_MONTHS() {
		return COMP_MP_PRE_TPD_BNF_MONTHS;
	}

	public void setCOMP_MP_PRE_TPD_BNF_MONTHS_LABEL(HtmlOutputLabel COMP_MP_PRE_TPD_BNF_MONTHS_LABEL) {
		this.COMP_MP_PRE_TPD_BNF_MONTHS_LABEL = COMP_MP_PRE_TPD_BNF_MONTHS_LABEL;
	}

	public void setCOMP_MP_PRE_TPD_BNF_MONTHS(HtmlInputText COMP_MP_PRE_TPD_BNF_MONTHS) {
		this.COMP_MP_PRE_TPD_BNF_MONTHS = COMP_MP_PRE_TPD_BNF_MONTHS;
	}

	public HtmlOutputLabel getCOMP_MP_LC_FUNERAL_EXP_LMT_LABEL() {
		return COMP_MP_LC_FUNERAL_EXP_LMT_LABEL;
	}

	public HtmlInputText getCOMP_MP_LC_FUNERAL_EXP_LMT() {
		return COMP_MP_LC_FUNERAL_EXP_LMT;
	}

	public void setCOMP_MP_LC_FUNERAL_EXP_LMT_LABEL(HtmlOutputLabel COMP_MP_LC_FUNERAL_EXP_LMT_LABEL) {
		this.COMP_MP_LC_FUNERAL_EXP_LMT_LABEL = COMP_MP_LC_FUNERAL_EXP_LMT_LABEL;
	}

	public void setCOMP_MP_LC_FUNERAL_EXP_LMT(HtmlInputText COMP_MP_LC_FUNERAL_EXP_LMT) {
		this.COMP_MP_LC_FUNERAL_EXP_LMT = COMP_MP_LC_FUNERAL_EXP_LMT;
	}

	public HtmlOutputLabel getCOMP_MP_LC_FUNERAL_EXP_AMT_LABEL() {
		return COMP_MP_LC_FUNERAL_EXP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_MP_LC_FUNERAL_EXP_AMT() {
		return COMP_MP_LC_FUNERAL_EXP_AMT;
	}

	public void setCOMP_MP_LC_FUNERAL_EXP_AMT_LABEL(HtmlOutputLabel COMP_MP_LC_FUNERAL_EXP_AMT_LABEL) {
		this.COMP_MP_LC_FUNERAL_EXP_AMT_LABEL = COMP_MP_LC_FUNERAL_EXP_AMT_LABEL;
	}

	public void setCOMP_MP_LC_FUNERAL_EXP_AMT(HtmlInputText COMP_MP_LC_FUNERAL_EXP_AMT) {
		this.COMP_MP_LC_FUNERAL_EXP_AMT = COMP_MP_LC_FUNERAL_EXP_AMT;
	}

	public HtmlOutputLabel getCOMP_MP_CLM_INTM_DAYS_LABEL() {
		return COMP_MP_CLM_INTM_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_MP_CLM_INTM_DAYS() {
		return COMP_MP_CLM_INTM_DAYS;
	}

	public void setCOMP_MP_CLM_INTM_DAYS_LABEL(HtmlOutputLabel COMP_MP_CLM_INTM_DAYS_LABEL) {
		this.COMP_MP_CLM_INTM_DAYS_LABEL = COMP_MP_CLM_INTM_DAYS_LABEL;
	}

	public void setCOMP_MP_CLM_INTM_DAYS(HtmlInputText COMP_MP_CLM_INTM_DAYS) {
		this.COMP_MP_CLM_INTM_DAYS = COMP_MP_CLM_INTM_DAYS;
	}

	public HtmlOutputLabel getCOMP_MP_NOTICE_PRD_LABEL() {
		return COMP_MP_NOTICE_PRD_LABEL;
	}

	public HtmlInputText getCOMP_MP_NOTICE_PRD() {
		return COMP_MP_NOTICE_PRD;
	}

	public void setCOMP_MP_NOTICE_PRD_LABEL(HtmlOutputLabel COMP_MP_NOTICE_PRD_LABEL) {
		this.COMP_MP_NOTICE_PRD_LABEL = COMP_MP_NOTICE_PRD_LABEL;
	}

	public void setCOMP_MP_NOTICE_PRD(HtmlInputText COMP_MP_NOTICE_PRD) {
		this.COMP_MP_NOTICE_PRD = COMP_MP_NOTICE_PRD;
	}

	public HtmlOutputLabel getCOMP_MP_LC_FCL_LABEL() {
		return COMP_MP_LC_FCL_LABEL;
	}

	public HtmlInputText getCOMP_MP_LC_FCL() {
		return COMP_MP_LC_FCL;
	}

	public void setCOMP_MP_LC_FCL_LABEL(HtmlOutputLabel COMP_MP_LC_FCL_LABEL) {
		this.COMP_MP_LC_FCL_LABEL = COMP_MP_LC_FCL_LABEL;
	}

	public void setCOMP_MP_LC_FCL(HtmlInputText COMP_MP_LC_FCL) {
		this.COMP_MP_LC_FCL = COMP_MP_LC_FCL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROD_CODE() {
		return COMP_UI_M_BUT_PROD_CODE;
	}

	public void setCOMP_UI_M_BUT_PROD_CODE(HtmlCommandButton COMP_UI_M_BUT_PROD_CODE) {
		this.COMP_UI_M_BUT_PROD_CODE = COMP_UI_M_BUT_PROD_CODE;
	}

	public PM_IL_MASTER_POLICY getPM_IL_MASTER_POLICY_BEAN() {
		return PM_IL_MASTER_POLICY_BEAN;
	}

	public void setPM_IL_MASTER_POLICY_BEAN(PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN) {
		this.PM_IL_MASTER_POLICY_BEAN = PM_IL_MASTER_POLICY_BEAN;
	}
	
	public void save() throws ValidatorException,Exception{
			System.out.println("Inside the Save Data to DB ::::");
			CRUDHandler handler = new CRUDHandler();
			CommonUtils commonUtils=new CommonUtils();
			
			PM_IL_MASTER_POLICY_HELPER pm_il_master_policy_helper=new PM_IL_MASTER_POLICY_HELPER();
			String policyNumber=PM_IL_MASTER_POLICY_BEAN.getMP_POL_NO();
					
			if(PM_IL_MASTER_POLICY_BEAN.getROWID()==null)
			{
				if(policyNumber!=null)
				{
					pm_il_master_policy_helper.pre_insert(PM_IL_MASTER_POLICY_BEAN);
				}
				commonUtils.objectSysout(PM_IL_MASTER_POLICY_BEAN);
				Connection connection=CommonUtils.getConnection();	
				handler.executeInsert(PM_IL_MASTER_POLICY_BEAN, connection);
				connection.commit();
			}
			else
			{
				pm_il_master_policy_helper.pre_update(PM_IL_MASTER_POLICY_BEAN);
				commonUtils.objectSysout(PM_IL_MASTER_POLICY_BEAN);
			    Connection connection=CommonUtils.getConnection();	
				handler.executeInsert(PM_IL_MASTER_POLICY_BEAN, connection);
				connection.commit();
			}
	}
	

	public void fetch(){
		//PM_AGENT_WITH_DRAWL_SETUP bean = new PM_AGENT_WITH_DRAWL_SETUP();
		System.out.println("In fetch record");
		ResultSet result=null;
		ConnectionAgentServlet agent=new ConnectionAgentServlet();
		CRUDHandler handler=new CRUDHandler();
		
		String selectQuery="Select ROWID,PM_IL_MASTER_POLICY.* from PM_IL_MASTER_POLICY"; //where  ROWID='AAASdCAAGAAAAxFAAA'";
		
		System.out.println("Query \n"+ selectQuery+"\n");
		//System.exit(1);
		try {
			Connection connection=CommonUtils.getConnection();
			result=handler.executeSelectStatement(selectQuery,connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == null){
			System.out.println("Unable to fetch record");
		}else{
			try{
				if(result.next()){
				
					PM_IL_MASTER_POLICY_BEAN.setROWID(result.getString(1));
					PM_IL_MASTER_POLICY_BEAN.setMP_CUST_CODE(result.getString("MP_CUST_CODE"));
					PM_IL_MASTER_POLICY_BEAN.setMP_PROD_CODE(result.getString("MP_PROD_CODE"));
					PM_IL_MASTER_POLICY_BEAN.setMP_POL_NO(result.getString("MP_POL_NO"));
					PM_IL_MASTER_POLICY_BEAN.setMP_ISSUE_DT(result.getDate("MP_ISSUE_DT"));
					PM_IL_MASTER_POLICY_BEAN.setMP_POL_FM_DT(result.getDate("MP_POL_FM_DT"));
					PM_IL_MASTER_POLICY_BEAN.setMP_LC_MAX_TPD_BNF(result.getDouble("MP_LC_MAX_TPD_BNF"));
					PM_IL_MASTER_POLICY_BEAN.setMP_PRE_TPD_BNF_MONTHS(result.getInt("MP_PRE_TPD_BNF_MONTHS"));
					PM_IL_MASTER_POLICY_BEAN.setMP_LC_FUNERAL_EXP_LMT(result.getDouble("MP_LC_FUNERAL_EXP_LMT"));
					PM_IL_MASTER_POLICY_BEAN.setMP_LC_FUNERAL_EXP_AMT(result.getDouble("MP_LC_FUNERAL_EXP_AMT"));
					PM_IL_MASTER_POLICY_BEAN.setMP_CLM_INTM_DAYS(result.getInt("MP_CLM_INTM_DAYS"));
					PM_IL_MASTER_POLICY_BEAN.setMP_NOTICE_PRD(result.getInt("MP_NOTICE_PRD"));
					PM_IL_MASTER_POLICY_BEAN.setMP_LC_FCL(result.getDouble("MP_LC_FCL"));
					//Hard Coded Date Value
					//PM_IL_MASTER_POLICY_BEAN.setMP_CR_DT(result.getDate("10-OCT-08"));
					System.out.println("CURRENT DATE OF MP_CR_DT>>>>>>>>>"+PM_IL_MASTER_POLICY_BEAN.getMP_CR_DT());
					PM_IL_MASTER_POLICY_BEAN.setMP_CR_UID(result.getString("ENG"));
			//					
				}								
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
//Written to Fetch data
	public String Update(){
		System.out.println("Inside the Save ");
		CRUDHandler handler = new CRUDHandler();
		try {
			Connection connection=CommonUtils.getConnection();
			handler.executeInsert(PM_IL_MASTER_POLICY_BEAN, connection);
			connection.commit();
			
		} 
		catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		PM_IL_MASTER_POLICY_BEAN = new PM_IL_MASTER_POLICY();
		return "";
	}

	public List getLovForProductCode(Object object) throws DBException, SQLException{
		System.out.println("The Value Entered is "+object.toString());
		PM_IL_MASTER_POLICY_DELEGATE pm_il_master_policy_delegate=new PM_IL_MASTER_POLICY_DELEGATE();
		suggestionList=pm_il_master_policy_delegate.productCodeLov(object,suggestionList);
		
		
		/*List suggesionList = new ArrayList();
		Connection connection = getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet LOVResultSet = null;
		String LOVQuery = null;
		
		try{
		if(object.equals("*")){
			LOVQuery = "SELECT PROD_CODE, PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE IS NOT NULL ";
		}else{
			LOVQuery = "SELECT PROD_CODE, PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE IS NOT NULL LIKE '"+object.toString()+"%' AND ROWNUM  <25";
		}
		LOVResultSet = handler.executeSelectStatement(LOVQuery, connection);
		LOVResultSet.setFetchSize(25);
		PM_IL_MASTER_POLICY newPM_IL_MASTER_POLICY = null;
		while(LOVResultSet.next()){
			newPM_IL_MASTER_POLICY =new PM_IL_MASTER_POLICY() ;
			newPM_IL_MASTER_POLICY.setMP_PROD_CODE(LOVResultSet.getString(1));
			newPM_IL_MASTER_POLICY.setUI_M_MP_PROD_CODE_DESC(LOVResultSet.getString(2));
			lov_Desc =  newPM_IL_MASTER_POLICY.getUI_M_MP_PROD_CODE_DESC();
			suggesionList.add(newPM_IL_MASTER_POLICY);
			System.out.println("MAP \t"+ lov_Desc);
			keyValue.put(newPM_IL_MASTER_POLICY.getMP_PROD_CODE(), newPM_IL_MASTER_POLICY.getUI_M_MP_PROD_CODE_DESC());
			
//			newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_01_DESC(LOVResultSet.getString(1));
//			newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_02_DESC(LOVResultSet.getString(2));
//			suggesionList.add(newPP_LIFE_POL_SCH_PRN1);
		}
		LOVResultSet.close();
		connection.close();
		
	}catch(Exception er){
		er.printStackTrace();
	}*/
		return suggestionList;
	}
	
	public void getProductCodeDesc(ActionEvent event)
	{
		if(COMP_MP_PROD_CODE.getSubmittedValue()!=null)
		{
			String productCode=COMP_MP_PROD_CODE.getSubmittedValue().toString().trim().toUpperCase();
			System.out.println("PRDT CODE ;"+productCode);
			PM_IL_MASTER_POLICY_DELEGATE pm_il_master_policy_delegate=new PM_IL_MASTER_POLICY_DELEGATE();
			String pdtCodeDesc=pm_il_master_policy_delegate.getProductCodeDesc(productCode, suggestionList);
			System.out.println("DESC :"+pdtCodeDesc);
			COMP_UI_M_MP_PROD_CODE_DESC.setSubmittedValue(pdtCodeDesc);
		}
	}
	

	  public void MP_PROD_CODE_EVENT(ActionEvent event)
	  {
		  if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");

			}
		  System.out.println("Value is Required");
		  UIInput input = (UIInput) event.getComponent().getParent();
	      ErrorHelpUtil.validate(input, getErrorMap());
	  }
	
	  public void validateMP_PRODUCT_CODE(FacesContext context,
				UIComponent component, Object value) throws ValidatorException,Exception 
	 {
		  UIInput input = (UIInput) component;
	     String inputData = input.getSubmittedValue().toString();
	     String MP_PRODUCT_CODE_DESC = null;
	    PM_IL_MASTER_POLICY_HELPER pm_il_master_policy_helper=new PM_IL_MASTER_POLICY_HELPER();
	    if(inputData != null && inputData.length()>1)
	    {
	    	MP_PRODUCT_CODE_DESC = pm_il_master_policy_helper.pilm040_pm_il_master_policy_mp_prod_code_when_validate_item(inputData);
	    	/*try {
			} catch (ValidatorException e) {
				getErrorMap().put("somekey", e.getMessage());
				getErrorMap().put("current", e.getMessage());
			}*/
	    	PM_IL_MASTER_POLICY_BEAN.setUI_M_MP_PROD_CODE_DESC(MP_PRODUCT_CODE_DESC);
	    	COMP_UI_M_MP_PROD_CODE_DESC.resetValue();
	    }
	  }
	  
	  public void validateMP_MP_POL_NO(FacesContext context,
				UIComponent component, Object value) throws ValidatorException,Exception 
	 {
		  UIInput input = (UIInput) component;
	     String inputData = input.getSubmittedValue().toString();
	     System.out.println("INPUTDATA"+inputData);
	    PM_IL_MASTER_POLICY_HELPER pm_il_master_policy_helper=new PM_IL_MASTER_POLICY_HELPER();
	    if(inputData!=null&&inputData.length()>1)
	    {
	    	PM_IL_MASTER_POLICY_BEAN.setMP_POL_NO(inputData);
	    	pm_il_master_policy_helper.pilm040_pm_il_master_policy_mp_policy_no_when_validate_item(PM_IL_MASTER_POLICY_BEAN);
	    	
	    }
	  }
	  
	  
	  public void validateMP_ISSUE_DATE(FacesContext context,
				UIComponent component, Object value) throws ValidatorException, ParseException
		
		{
			HtmlCalendar htmlCalendar = (HtmlCalendar) component;
			Date issueDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
			PM_IL_MASTER_POLICY_BEAN.setMP_ISSUE_DT(issueDate);
			Date check=COMP_MP_POL_FM_DT.getAsDate(COMP_MP_POL_FM_DT.getValue());
			System.out.println("Checking purpose :"+check);
	 	   Date fromDate = PM_IL_MASTER_POLICY_BEAN.getMP_POL_FM_DT();
		   System.out.println("MP_ISSUE_DATE ****" + fromDate+"Issue Date :"+issueDate);
		   CommonUtils  commonUtils=new CommonUtils();
		   Date sysDate=commonUtils.getCurrentDate();
		   System.out.println("SYS DATE :"+sysDate);
			if (fromDate != null && issueDate != null) {
				if (fromDate.before(issueDate)||issueDate.before(sysDate)) {
					System.out.println("To Date is Valid ");
				} else {
					//ConvertFunctions.to_char(sysDate.getDate(), "DD/MM/YYYY");
				/*	SimpleDateFormat dateFormat=new SimpleDateFormat("DD/MM/YYYY");
					String formattedSysDate=dateFormat.format(sysDate);
					System.out.println("From DATE IS GREATER Than To Date "+formattedSysDate);*/
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",new Object[]{issueDate,"<=",sysDate}));

				}
			}
		 }
	  
	  public void validateMP_POL_FROM_DATE(FacesContext context,
				UIComponent component, Object value) throws ValidatorException, ParseException
	      {
			HtmlCalendar htmlCalendar = (HtmlCalendar) component;
			
			System.out.println("SUBMITTED VALUE:"+value);
			Date fromDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue()); 
			System.out.println("FROM DATE ::::::::::"+fromDate);
			CommonUtils  commonUtils=new CommonUtils();
			Date sysDate=commonUtils.getCurrentDate();
			
			DateFormat dateFormat=new SimpleDateFormat("dd/MMM/yyyy");
			String formattedSysDate=dateFormat.format(sysDate);
			System.out.println("Fromatted Sys Date :"+formattedSysDate);
			
			PM_IL_MASTER_POLICY_BEAN.setMP_POL_FM_DT(fromDate);
			Date issueDate=PM_IL_MASTER_POLICY_BEAN.getMP_ISSUE_DT();
			String formattedIssueDate=dateFormat.format(issueDate);
			System.out.println("SYS DATE :"+sysDate+"<From Date : "+fromDate+">"+"***** :"+issueDate);
			if(fromDate!=null)
			{
				if(fromDate.after(sysDate))
				{
					//Object[] object={"Policy From Date","<=",formattedSysDate};
					Object[] object={"Policy From Date","<=",sysDate};
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
				}
				if(fromDate.before(issueDate))
				{				
					Object[] object={"Policy From Date",">=","Issue Date",issueDate};
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
				}
			}
	     }
	  
	  public void validateMP_LC_MAX_TPD_BNF(FacesContext context,
				UIComponent component, Object value) throws ValidatorException
	       {
		            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            double double1=ConvertFunctions.to_number(inputData);
		            System.out.println("Enter MaxTPD Benefit:"+inputData+"$$$$$ :"+double1);
		            if(double1<=0.0)
		            {
		            	System.out.println("Condition Satisfied for MP_LC_MAX_TPD_BNF");
		            	Object[] object={"Maximum TPD Benefit",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	       }
	  public void validateMP_PRE_TPD_BNF_MONTHS(FacesContext context,
				UIComponent component, Object value) throws ValidatorException
	        {
		            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            System.out.println("Enter MaxTPD Months:"+inputData);
		            double double1=ConvertFunctions.to_number(inputData);
		            if(double1<=0.0)
		            {System.out.println("Condition Satisfied for MP_PRE_TPD_BNF_MONTHS");
		            	Object[] object={"Pre TPD Benefit Months",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	         } 
	  
	  public void validateMP_LC_FUNERAL_EXP_LMT(FacesContext context,
				UIComponent component, Object value) throws Exception
				{	            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            System.out.println("Enter MP_LC_FUNERAL_EXP_LMT:"+inputData);
		            double double1=ConvertFunctions.to_number(inputData);
		            if(double1<=0.0)
		            {System.out.println("Condition Satisfied for MP_LC_FUNERAL_EXP_LMT");
		            	Object[] object={"Funeral Expense Cover Limit",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	          } 
	  public void validateMP_LC_FUNERAL_EXP_AMT(FacesContext context,
				UIComponent component, Object value) throws Exception
				{	            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            System.out.println("Enter MP_LC_FUNERAL_EXP_AMT:"+inputData);
		            double double1=ConvertFunctions.to_number(inputData);
		            if(double1<=0.0)
		            {System.out.println("Condition Satisfied for MP_LC_FUNERAL_EXP_AMT");
		            	Object[] object={"Funeral Expense Benefit Amount",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	          } 
	  public void validateMP_CLM_INTM_DAYS(FacesContext context,
				UIComponent component, Object value) throws Exception
				{	            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            System.out.println("Enter MP_CLM_INTM_DAYS:"+inputData);
		            double double1=ConvertFunctions.to_number(inputData);
		            if(double1<=0.0)
		            {System.out.println("Condition Satisfied for MP_CLM_INTM_DAYS");
		            	Object[] object={"Claim Intimation Days",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	          } 
	  public void validateMP_NOTICE_PRD (FacesContext context,
				UIComponent component, Object value) throws Exception
	       {
		            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            System.out.println("Enter MP_NOTICE_PRD :"+inputData);
		            double double1=ConvertFunctions.to_number(inputData);
		            if(double1<=0.0)
		            {System.out.println("Condition Satisfied for MP_NOTICE_PRD ");
		            	Object[] object={"Notice Period",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	        } 
	  public void validateMP_LC_FCL (FacesContext context,
				UIComponent component, Object value) throws Exception
	       {
		            UIInput input=(UIInput)component;
		            String inputData=input.getSubmittedValue().toString();
		            System.out.println("Enter MP_LC_FCL :"+inputData);
		            double double1=ConvertFunctions.to_number(inputData);
		            if(double1<=0.0)
		            {System.out.println("Condition Satisfied for MP_LC_FCL ");
		            	Object[] object={"Free Cover Limit",">=","0"};
		             throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
		            }
	        } 
	  

	public String Delete(){
		System.out.println("Inside the Delete ");
		CRUDHandler handler = new CRUDHandler();
		
 
		int rowDeleted = 0;
		try {
			System.out.println("The Second Value is .........."+PM_IL_MASTER_POLICY_BEAN.getMP_POL_NO());
			System.out.println("The ROWID IS .........."+PM_IL_MASTER_POLICY_BEAN.getROWID());
			Connection connection=CommonUtils.getConnection();
		rowDeleted = handler.executeDelete(PM_IL_MASTER_POLICY_BEAN,connection);
		connection.commit();
		}
		catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();					
		}	
		PM_IL_MASTER_POLICY_BEAN = new PM_IL_MASTER_POLICY();	
	return "";	
	}
	
	public Date getSystemDate(){
		CRUDHandler handler = new CRUDHandler();
		java.sql.Date sysDate = null;
		ResultSet resultSet = null;
		try {
			Connection connection=CommonUtils.getConnection();
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query,connection);
			while(resultSet.next()){
				System.out.println("Result is "+resultSet.getDate(1));
				sysDate = resultSet.getDate(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The SYS Date == "+sysDate);
		return sysDate;
	}
	
	public void callPreForm() throws Exception
	{
		preFormButton.setDisabled(true);
		PM_IL_MASTER_POLICY_HELPER pm_il_master_policy_helper=new PM_IL_MASTER_POLICY_HELPER();
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_MASTER_POLICY_ACTION pm_il_master_policy_action = (PM_IL_MASTER_POLICY_ACTION) commonUtils
				.getMappedBeanFromSession("PILM040_PM_IL_MASTER_POLICY_ACTION");
		pm_il_master_policy_helper.pilm040_pre_form(pm_il_master_policy_action);
	}
	    
	public void onLoad(PhaseEvent event){
		PM_IL_MASTER_POLICY_DELEGATE pm_il_master_policy_delegate = new PM_IL_MASTER_POLICY_DELEGATE();
		PM_IL_MASTER_POLICY_HELPER pm_il_master_policy_helper=new PM_IL_MASTER_POLICY_HELPER();
		try{
			if(isFormFlag()){
				pm_il_master_policy_delegate.executeSelectStatement(this);
				setFormFlag(false);
			}
			if(isBlockFlag()){
				pm_il_master_policy_delegate.executeSelectStatement(this);
				if(PM_IL_MASTER_POLICY_BEAN.getROWID() != null){
					pm_il_master_policy_helper.pilm040_pm_il_master_policy_post_query(PM_IL_MASTER_POLICY_BEAN);
				}else{
					pm_il_master_policy_helper.pilm040_pm_il_master_policy_when_create_record(this);
				}
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public List getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List suggestionList) {
		this.suggestionList = suggestionList;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public HtmlCommandButton getPreFormButton() {
		return preFormButton;
	}

	public void setPreFormButton(HtmlCommandButton preFormButton) {
		this.preFormButton = preFormButton;
	}

	public String back() {
		String callingForm = null;
		String outcome = null;
		CommonUtils.getSession().removeAttribute("PILM040_PM_IL_MASTER_POLICY_ACTION");
		callingForm = (String) CommonUtils.getGlobalObject("CALLING_FORM");
		outcome = (String) CommonUtils.getGlobalObject("CALLING_FORM_OUTCOME");
		if ("PM075_A".equals(callingForm)) {
			CommonUtils.clearMaps(this);
			return outcome;
		} else {
			PM006_A_APAC_COMPOSITE_ACTION compositeAction = new PM006_A_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PM006_A_APAC_COMPOSITE_ACTION",
					compositeAction);
			// PM006_A_APAC_COMPOSITE_ACTION compositeAction =
			// (PM006_A_APAC_COMPOSITE_ACTION) new
			// CommonUtils().getMappedBeanFromSession("PM006_A_APAC_COMPOSITE_ACTION");
			compositeAction.getPM_CUSTOMER_ACTION_BEAN().getErrorMap().clear();
			compositeAction.getPM_CUSTOMER_ACTION_BEAN().getWarningMap()
					.clear();
			compositeAction.getPM_CUSTOMER_ACTION_BEAN().setErrorMessages("");
			getErrorMap().clear();
			getWarningMap().clear();
			setErrorMessages("");
			Iterator<FacesMessage> errorMessages = FacesContext
					.getCurrentInstance().getMessages();
			while (errorMessages.hasNext()) {
				System.out.println(errorMessages.next());
				errorMessages.remove();
			}
			return "loadCustomerMaster";
		}
	}
}
