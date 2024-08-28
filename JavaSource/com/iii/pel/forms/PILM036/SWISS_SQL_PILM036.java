package com.iii.pel.forms.PILM036;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.StringFunctions;

public class SWISS_SQL_PILM036 {
	
	public void PRE_FORM(FacesContext facesContext){
		 /*final dbms_output dbms_output1=new dbms_output();
        String M_FILE=null;
        String M_TITLE=null;
        SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);
        if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM)== null)
        {
            :GLOBAL.M_PRIVILEGE="YYY";
            :GLOBAL.M_FAILURE="FALSE";
            :GLOBAL.M_USER_ID="PREMIA";
            :GLOBAL.M_NAME="COMPANY NAME..................PROGRAM NAME";
            :GLOBAL.M_LANG_CODE="ENG";
            :GLOBAL.M_PARA_1=" ";
            :GLOBAL.M_FOR_LANG_CODE="ARBR1";
            :GLOBAL.M_MODULE_NAME=GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME);
        }
        STD_PRE_FORM.STD_PRE_FORM();
        if(StringFunctions.substr(:GLOBAL.M_FOR_LANG_CODE,5,1)=="1")
        {
        }
        M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
        SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
        :DUMMY.PM_IL_BONUS_CF="N";*/
		
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		//session.setAttribute("GLOBAL.M_PRIVILEGE", Constants.M_PRIVILEGE);
		//session.setAttribute("GLOBAL.M_FAILURE", Constants.M_FAILURE);
		//session.setAttribute("GLOBAL.M_USER_ID", Constants.M_USER_ID);
		//session.setAttribute("GLOBAL.M_NAME", Constants.M_NAME);
		//session.setAttribute("GLOBAL.M_LANG_CODE", Constants.M_LANG_CODE);
		//session.setAttribute("GLOBAL.M_PARA_1", Constants.M_PARA_1);
		//session.setAttribute("GLOBAL.M_FOR_LANG_CODE", Constants.M_FOR_LANG_CODE);
		//session.setAttribute("GLOBAL.M_MODULE_NAME", "PILM036");
		
		STD_PRE_FORM();
		if(StringFunctions.substr(Constants.M_FOR_LANG_CODE,5,1)=="1"){
       }
		
		/*ControlBean control = (ControlBean) session.getAttribute("ctrl");
		String title = control.getM_USER_ID()+"		"+control.getM_SCR_NAME()+"		"+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
		*/
		/*DUMMY_ACTION dummyAction = (DUMMY_ACTION) session.getAttribute("PILM036_DUMMY_ACTION");
       dummyAction.getDUMMY_BEAN().setPM_IL_BONUS_CF("N");*/
       
       
       //To be deleted just for connection use
		// [BugId:Fix122 MMuthu 31-Dec-08 Getting connection from CommonUtils class getConnection()		
	       Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	       String clientId = Constants.M_USER_ID+Calendar.getInstance().getTimeInMillis();
//	       session.setAttribute("CLIENT_ID", clientId);
//	       session.setAttribute(clientId, connection);
	// BugId:Fix122 MMuthu 31-Dec-08 Getting connection from CommonUtils class getConnection() ]    
       List<String> bonusTypeList = ListItemUtil.getComboSuggestionValues(connection, "PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP");
		PM_IL_BONUS_ACTION queryAction = (PM_IL_BONUS_ACTION) facesContext.getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_ACTION");
		queryAction.getPM_IL_BONUS_BEAN().setBONUS_TYPE_DESC_LIST(bonusTypeList);
		queryAction.getErrorMap().clear();
	}
	
	public void STD_PRE_FORM(){
		
	}
	
	public boolean lDupCheck(FacesContext facesContext){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            String sql_C1="SELECT 'X' FROM  PM_IL_BONUS  WHERE  BONUS_CODE  = :PM_IL_BONUS.BONUS_CODE ";
            ResultSet vembu_C1=null;
            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String M_TEMP=null;
            vembu_C1=stmt_C1.executeQuery(sql_C1);
            if(vembu_C1.next())
            {
                M_TEMP=vembu_C1.getString(1);
            }
            if(!vembu_C1.isLast())
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71026,:CTRL.M_LANG_CODE);
                vembu_C1.close();
                throw new FORM_TRIGGER_FAILURE();
            }
            vembu_C1.close();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		boolean isDup = false;
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_ACTION");
		String bonusCode = (String) bonusAction.getCOMP_BONUS_CODE().getSubmittedValue();
		if(bonusCode==null){
			bonusCode = bonusAction.getPM_IL_BONUS_BEAN().getBONUS_CODE();
		}
		String selectQuery = "SELECT * FROM  PM_IL_BONUS  WHERE  BONUS_CODE  = ?";
		Object[] values = {bonusCode};
		System.out.println(bonusCode);
//		String clientId = (String) sessionMap.get("CLIENT_ID");
//		Connection connection = (Connection) sessionMap.get(clientId);
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			System.out.println("BONUS CONNECTION : "+connection.getCatalog());
			ResultSet rst = handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next()){
				isDup = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isDup;
	}
	
	public void preInsert(FacesContext facesContext){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            :PM_IL_BONUS.BONUS_CR_DT=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            :PM_IL_BONUS.BONUS_CR_UID=:GLOBAL.M_USER_ID;
            L_DUP_CHECK.L_DUP_CHECK();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_ACTION");
		bonusAction.getPM_IL_BONUS_BEAN().setBONUS_CR_DT(new Date(Calendar.getInstance().getTimeInMillis()));
		bonusAction.getPM_IL_BONUS_BEAN().setBONUS_CR_UID(userId);
		lDupCheck(facesContext);
	}
	
	public void whenCreateRecord(FacesContext facesContext){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            :PM_IL_BONUS.BONUS_TYPE="S";
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		String clientId = (String) sessionMap.get("CLIENT_ID");
		//Connection connection = (Connection) sessionMap.get(clientId);
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String bonusType = ListItemUtil.getListItemDescription(connection, "PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP","S");
			PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_ACTION");
			bonusAction.getPM_IL_BONUS_BEAN().setBONUS_TYPE(bonusType);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean keyDeleteRecord(FacesContext context, PM_IL_BONUS bonusBean){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            String sql_C1="SELECT 'X' FROM  PM_IL_BONUS_SETUP  WHERE  BSET_BONUS_CODE  = :PM_IL_BONUS.BONUS_CODE ";
            ResultSet vembu_C1=null;
            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String M_TEMP=null;
            vembu_C1=stmt_C1.executeQuery(sql_C1);
            if(vembu_C1.next())
            {
                M_TEMP=vembu_C1.getString(1);
            }
            if(!vembu_C1.isLast())
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91050,:CTRL.M_LANG_CODE);
                vembu_C1.close();
                throw new FORM_TRIGGER_FAILURE();
            }
            else
            {
                KEY_DELREC.KEY_DELREC();
            }
            vembu_C1.close();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		
		String selectQuery = "SELECT * FROM  PM_IL_BONUS_SETUP WHERE BSET_BONUS_CODE=?";
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		String clientId = (String) sessionMap.get("CLIENT_ID");
//		Connection connection = (Connection) sessionMap.get(clientId);
		CRUDHandler handler = new CRUDHandler();
//		PM_IL_BONUS_QUERY_ACTION queryAction = (PM_IL_BONUS_QUERY_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_QUERY_ACTION");
		String bonusCode = bonusBean.getBONUS_CODE();
		Object[] values = {bonusCode};
		boolean isUsed = false;
		try {
			Connection connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next()){
				isUsed = true;
			}
			rst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return !isUsed;
	}
	
	public void preBlock(FacesContext facesContext){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            if(FORM_FAILURE)
            {
                :GLOBAL.M_FAILURE="TRUE";
            }
            :CTRL.M_DELETE_MSG_FLAG="Y";
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		sessionMap.put("GLOBAL.M_FAILURE", "TRUE");
		ControlBean controlBean = (ControlBean) sessionMap.get("ctrl");
		controlBean.setM_DELETE_MSG_FLAG("Y");
	}
	
	public void preUpdate(FacesContext facesContext){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            :PM_IL_BONUS.BONUS_UPD_DT=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            :PM_IL_BONUS.BONUS_UPD_UID=:GLOBAL.M_USER_ID;
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_ACTION");
		bonusAction.getPM_IL_BONUS_BEAN().setBONUS_UPD_DT(new Date(Calendar.getInstance().getTimeInMillis()));
		String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
		bonusAction.getPM_IL_BONUS_BEAN().setBONUS_UPD_UID(userId);
	}
	
	public void bonusDescWhenValidateItem(FacesContext facesContext){
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_ACTION");
		String bonusDesc = (String) bonusAction.getCOMP_BONUS_DESC().getSubmittedValue();
		if(bonusDesc!=null){
			String bonusShortDesc = null;
			if(bonusDesc.length()>30){
				bonusShortDesc = bonusDesc.substring(1, 30);			
			}else{
				bonusShortDesc = bonusDesc;
			}
			bonusAction.getCOMP_BONUS_SHORT_DESC().setSubmittedValue(bonusShortDesc);
			bonusAction.getPM_IL_BONUS_BEAN().setBONUS_SHORT_DESC(bonusShortDesc);
		}
	}
	
	public void bonusCodeWhenValidateItem(FacesContext facesContext){
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            if(:PM_IL_BONUS.BONUS_CODE != null)
            {
                L_DUP_CHECK.L_DUP_CHECK();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) facesContext.getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_ACTION");
		String bonusCode = (String) bonusAction.getCOMP_BONUS_CODE().getSubmittedValue();
//		FacesMessage message = null;
		bonusAction.getErrorMap().remove("current");
		if(bonusCode!=null){
			if(bonusCode.length()>0){
				boolean isExist = lDupCheck(facesContext);
				if(isExist){
//					message = new FacesMessage("Bonus code already exists");
					bonusAction.getErrorMap().put("current", "Bonus Code already exist");
//					bonusAction.getErrorMap().put(bonusAction.getCOMP_BONUS_CODE().getId(), message.getSummary());
				}
			}
			else{
//				message = new FacesMessage("Bonus Code cannot be empty");
				bonusAction.getErrorMap().put("current", "Bonus Code cannot be empty");
//				bonusAction.getErrorMap().put(bonusAction.getCOMP_BONUS_CODE().getId(), message.getSummary());
			}
		}
	}
	
	public void bonusYrsWhenValidateItem(FacesContext facesContext) throws ValidatorException {
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            if(:PM_IL_BONUS.BONUS_YRS<=0)
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,"BONUS YEARS",">","0");
                throw new FORM_TRIGGER_FAILURE();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		PM_IL_BONUS_ACTION bonusAction = null;
		try {
			bonusAction = (PM_IL_BONUS_ACTION) facesContext.getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_ACTION");
			Double bonusTerm= new Double((String) bonusAction.getCOMP_BONUS_YRS().getSubmittedValue());
			
			/** [ BugId:PREMIAGDC-0120 Mallika 11-Mar-09 Bonus years should be greater than zero*/
			if(bonusTerm <= 0.0 || bonusTerm > 100.0){
				throw new ValidatorException(Messages.getMessage("messageProperties_PILM036", "PILM036$PM_IL_BONUS$BONUS_TYPE$error"));
			}
			/**  BugId:PREMIAGDC-0120 Mallika 11-Mar-09 bean Changed ]*/
		}
		catch (ValidatorException ve) {
			throw ve;
		}
		catch (ClassCastException e) {
//			bonusAction.getErrorMap().put("current", "Should be a number greater than zero");
			throw new ValidatorException(new FacesMessage("Should be a number greater than zero"));
		} catch (NumberFormatException nfe){
//			bonusAction.getErrorMap().put("current", "Should be a number greater than zero");
			throw new ValidatorException(new FacesMessage("Should be a number greater than zero"));
		}
	}
	public void type(FacesContext context)
	{
		PM_IL_BONUS_ACTION bonusAction = null;
		
		bonusAction = (PM_IL_BONUS_ACTION)context.getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_ACTION");
		String bonusType = (String) bonusAction.getCOMP_BONUS_TYPE().getSubmittedValue();
		System.out.println("BONUS_TYPE:::"+bonusType);
		bonusAction.getPM_IL_BONUS_BEAN().setBONUS_TYPE(bonusType);
	}
	
	public void postDatabaseCommit(FacesContext facesContext){
		 /*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
	        try
	        {
	            final dbms_output dbms_output1=new dbms_output();
	            :GLOBAL.M_FAILURE="FALSE";
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	        finally
	        {
	            if(vembu_conn != null)
	            {
	                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
	            }
	        }*/
		
		facesContext.getExternalContext().getSessionMap().put("GLOBAL.M_FAILURE", "FALSE");
	}
}
