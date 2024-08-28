package com.iii.pel.forms.PILM086_APAC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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











import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PILM086_APP_USRS_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_BRAUG_UG_ID_LABEL;
	
	private HtmlInputText COMP_BRAUG_UG_ID;
	
	private HtmlInputText COMP_BRAUG_UG_DESC;
	
	private HtmlOutputLabel COMP_BRAU_USER_ID_LABEL;
	
	private HtmlInputText COMP_BRAU_USER_ID;
	
	private HtmlInputText COMP_BRAU_USER_DESC;
	
	public PILM086_APAC_COMPOSITE_ACTION compositeAction;
	
	public PILM086_APP_USRS_BEAN USRS_BEAN;
	
	public PILM086_APP_USRS_HELPER USRS_HELPER;
	
	public PILM086_APP_USRS_ID_BEAN USRS_ID_BEAN;
	
	private List<LovBean> lovList = new ArrayList<LovBean>();
	
	
	
	private UIData dataTable;
	
	private List<PILM086_APP_USRS_ID_BEAN> dataList_PILM086_APP_USRS_ID_BEAN = new ArrayList<PILM086_APP_USRS_ID_BEAN>();

	
	public HtmlOutputLabel getCOMP_BRAU_USER_ID_LABEL() {
		return COMP_BRAU_USER_ID_LABEL;
	}

	public void setCOMP_BRAU_USER_ID_LABEL(HtmlOutputLabel cOMP_BRAU_USER_ID_LABEL) {
		COMP_BRAU_USER_ID_LABEL = cOMP_BRAU_USER_ID_LABEL;
	}

	public HtmlInputText getCOMP_BRAU_USER_ID() {
		return COMP_BRAU_USER_ID;
	}

	public void setCOMP_BRAU_USER_ID(HtmlInputText cOMP_BRAU_USER_ID) {
		COMP_BRAU_USER_ID = cOMP_BRAU_USER_ID;
	}

	public HtmlInputText getCOMP_BRAU_USER_DESC() {
		return COMP_BRAU_USER_DESC;
	}

	public void setCOMP_BRAU_USER_DESC(HtmlInputText cOMP_BRAU_USER_DESC) {
		COMP_BRAU_USER_DESC = cOMP_BRAU_USER_DESC;
	}

	public List<LovBean> getLovList() {
		return lovList;
	}

	public void setLovList(List<LovBean> lovList) {
		this.lovList = lovList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PILM086_APP_USRS_ID_BEAN> getDataList_PILM086_APP_USRS_ID_BEAN() {
		return dataList_PILM086_APP_USRS_ID_BEAN;
	}

	public void setDataList_PILM086_APP_USRS_ID_BEAN(
			List<PILM086_APP_USRS_ID_BEAN> dataList_PILM086_APP_USRS_ID_BEAN) {
		this.dataList_PILM086_APP_USRS_ID_BEAN = dataList_PILM086_APP_USRS_ID_BEAN;
	}

	public PILM086_APP_USRS_BEAN getUSRS_BEAN() {
		return USRS_BEAN;
	}

	public void setUSRS_BEAN(PILM086_APP_USRS_BEAN uSRS_BEAN) {
		USRS_BEAN = uSRS_BEAN;
	}

	public PILM086_APP_USRS_HELPER getUSRS_HELPER() {
		return USRS_HELPER;
	}

	public void setUSRS_HELPER(PILM086_APP_USRS_HELPER uSRS_HELPER) {
		USRS_HELPER = uSRS_HELPER;
	}

	public PILM086_APP_USRS_ID_BEAN getUSRS_ID_BEAN() {
		return USRS_ID_BEAN;
	}

	public void setUSRS_ID_BEAN(PILM086_APP_USRS_ID_BEAN uSRS_ID_BEAN) {
		USRS_ID_BEAN = uSRS_ID_BEAN;
	}

	public HtmlOutputLabel getCOMP_BRAUG_UG_ID_LABEL() {
		return COMP_BRAUG_UG_ID_LABEL;
	}

	public void setCOMP_BRAUG_UG_ID_LABEL(HtmlOutputLabel cOMP_BRAUG_UG_ID_LABEL) {
		COMP_BRAUG_UG_ID_LABEL = cOMP_BRAUG_UG_ID_LABEL;
	}

	public HtmlInputText getCOMP_BRAUG_UG_ID() {
		return COMP_BRAUG_UG_ID;
	}

	public void setCOMP_BRAUG_UG_ID(HtmlInputText cOMP_BRAUG_UG_ID) {
		COMP_BRAUG_UG_ID = cOMP_BRAUG_UG_ID;
	}



	public HtmlInputText getCOMP_BRAUG_UG_DESC() {
		return COMP_BRAUG_UG_DESC;
	}

	public void setCOMP_BRAUG_UG_DESC(HtmlInputText cOMP_BRAUG_UG_DESC) {
		COMP_BRAUG_UG_DESC = cOMP_BRAUG_UG_DESC;
	}

	public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PILM086_APP_USRS_ACTION(){
		USRS_BEAN=new PILM086_APP_USRS_BEAN();
		USRS_HELPER=new PILM086_APP_USRS_HELPER();
		USRS_ID_BEAN=new PILM086_APP_USRS_ID_BEAN();
		
	}

	public void onLoad(PhaseEvent event) {
		try {
			System.out.println("ONLOAD CALLED");
			if (isBlockFlag()) {
				System.out.println("ONLOAD CALLED");
				PILM086_APAC_DELEGATE D=new PILM086_APAC_DELEGATE();
				/*System.out.println("value :"+D.sysid);
				String incoming=D.sysid;
				System.out.println("incomming"+incoming);*/
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	 public void fireFieldValidation(ActionEvent actionEvent) {
		 UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	 
	 
	 public void validateBRAUG_UG_DESC(FacesContext context,
				UIComponent component, Object value){
			try{
				String BRAUG_UG_DESC = (String)value;
				
				USRS_BEAN.setBRAUG_UG_DESC(BRAUG_UG_DESC);
				System.out.println(USRS_BEAN.getBRAUG_UG_DESC());
			}catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} 
	public void validateBRAUG_UG_ID(FacesContext context,
			UIComponent component, Object value){
		try{
			String BRAUG_UG_ID = (String)value;
			
			USRS_BEAN.setBRAUG_UG_ID(BRAUG_UG_ID);
			System.out.println(USRS_BEAN.getBRAUG_UG_ID());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	} 
	public void validateBRAU_USER_DESC(FacesContext context,
			UIComponent component, Object value){
		try{
			String BRAU_USER_DESC = (String)value;
			
			USRS_ID_BEAN.setBRAU_USER_DESC(BRAU_USER_DESC);
			System.out.println(USRS_ID_BEAN.getBRAU_USER_DESC());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	} 
public void validateBRAU_USER_ID(FacesContext context,
		UIComponent component, Object value){
	try{
		String BRAU_USER_ID = (String)value;
		
		USRS_ID_BEAN.setBRAU_USER_ID(BRAU_USER_ID);
		System.out.println(USRS_ID_BEAN.getBRAU_USER_ID());
	}catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}


public boolean select(String usergrou) throws DBException, SQLException{
	boolean flg=false;
	String val=null;
	String selectStatement = "SELECT BRAU_UG_ID FROM PM_BUS_RULE_APPL_USER WHERE BRAU_UG_ID = ?";
	System.out.println("QUERY"+selectStatement);
	Connection connection = null;
	ResultSet resultSet = null;
	connection=CommonUtils.getConnection();
	resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, new Object[]{usergrou});
	while (resultSet.next()) {
		val=resultSet.getString(1);
	}
	if(val!=null){
		System.out.println("hai");
		flg=true;
	}
	return flg;
}

public void display(ActionEvent event) {
		getErrorMap().clear();
		getWarningMap().clear();
	try {
		long sysid=compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID();
		String Sys=Long.toString(sysid);
		System.out.println(Sys);
		String usergrou=USRS_BEAN.getBRAUG_UG_ID();
		System.out.println(usergrou);
		
		boolean flg=select(usergrou);
		System.out.println(flg);
		if(!flg){
		callErrorProcedure(Sys,usergrou);
		}
		USRS_HELPER.executeQuery(compositeAction);
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
			
		
	}
	catch (Exception exc) {
		String temp=extractDBErrorMessage(exc.getMessage());
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + temp);
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + temp);
	}
	}
	public List<LovBean> prepareBRAUG_UG_ID(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_APPL_USER_GROUP",
					"BRAUG_UG_ID", "USER_GRP", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("GROUP_ID_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	public List<LovBean> prepareBRAU_USER_ID(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM086_APAC", "PM_BUS_RULE_APPL_USER",
					"BRAU_USER_ID", null, null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("GROUP_ID_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	private void callErrorProcedure(String current,String dflt ) throws Exception {
		Connection con=CommonUtils.getConnection();
		System.out.println("CURRENT"+current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);*/
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",dflt);
		OracleParameter param2 = new OracleParameter("IN2", "INT", "IN",current);
	    parameterList.add(param1);
	    parameterList.add(param2);
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,
	            "P_BUS_RULE_INS_USER");
	    Iterator<OracleParameter> iterator = outputList.iterator();
	    while (iterator.hasNext()) {
	        OracleParameter oracleParameter = iterator.next();
	        System.out.println("Output value:::" + oracleParameter.getValue());
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
