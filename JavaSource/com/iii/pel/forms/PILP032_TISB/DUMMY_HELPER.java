package com.iii.pel.forms.PILP032_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.ConvertFunctions;
import com.vembu.plsql.runtime.functions.DateFunctions;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class DUMMY_HELPER 
{
	String errorBundle = PELConstants.pelErrorMessagePath;
	
	public void pilp032_tisb_dummy_m_process_when_button_pressed() throws Exception 
    {
		System.out.println("HELPER BUTTON PRESSED");
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		DUMMY_ACTION action = (DUMMY_ACTION)sessionMap.get("PILP032_TISB_DUMMY_ACTION");
		DUMMY dummyBean = action.getDUMMY_BEAN();

		Connection connection  = null;
		CRUDHandler handler = new CRUDHandler();
		PROCEDURES procedure = null;
        try
        {
        	procedure = new PROCEDURES();
        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        	String M_FM_DATE = dateFormat.format(dummyBean.getUI_M_FM_DATE());
        	String M_TO_DATE = dateFormat.format(dummyBean.getUI_M_TO_DATE());
        	String M_PROCESS_DATE = dateFormat.format(dummyBean.getUI_M_PROCESS_DATE());
        	connection = CommonUtils.getConnection();
            String M_DUMMY_X=null;
            String sql_C1="SELECT 'X' FROM  FM_COMP_ACNT_YEAR" +
            				 " WHERE ?  BETWEEN CAY_FRM_DT  AND  CAY_TO_DT" +
            					" AND ?  BETWEEN CAY_FRM_DT  AND  CAY_TO_DT ";
            ResultSet rs_C1=null;
            
            if("C".equalsIgnoreCase(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARAM_1"),"X")))
            {
              
               		procedure.INS_AGENT_PF_COMM(dummyBean.getUI_M_FM_AGENT_CODE(), dummyBean.getUI_M_TO_AGENT_CODE(), M_FM_DATE, M_TO_DATE, M_PROCESS_DATE);
              
            }
            else if("I".equalsIgnoreCase(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARAM_1"),"X")))
            {
                
                	procedure.INS_AGENT_PF_INTEREST(dummyBean.getUI_M_FM_AGENT_CODE(),
                													dummyBean.getUI_M_TO_AGENT_CODE(),
                												M_FM_DATE,M_TO_DATE);
               
            }
            else if("B".equalsIgnoreCase(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARAM_1"),"X")))
            {
                if(rs_C1!=null)
                {
                	rs_C1.close();
                }
                rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{dummyBean.getUI_M_FM_DATE(), dummyBean.getUI_M_TO_DATE()});
                if(rs_C1.next())
                {
                    M_DUMMY_X=rs_C1.getString(1);
                }
                if(M_DUMMY_X!=null)
                {
                   
                   	procedure.INS_AGENT_COMP_BENEF(dummyBean.getUI_M_FM_AGENT_CODE(), dummyBean.getUI_M_TO_AGENT_CODE(), M_FM_DATE, M_TO_DATE);
                  
                }
                else
                {
                	Object[] value = {Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$UI_M_PROCESS_BUT$prompt")};
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",value));
                }
            }
            else if("Y".equalsIgnoreCase(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARAM_1"),"X")))
            {
                if(rs_C1!=null)
                {
                	rs_C1.close();
                }
                rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{dummyBean.getUI_M_FM_DATE(), dummyBean.getUI_M_TO_DATE()});
                if(rs_C1.next())
                {
                    M_DUMMY_X=rs_C1.getString(1);
                }
                if(M_DUMMY_X!=null)
                {
                   	procedure.INS_AGENT_COMP_BENEF(dummyBean.getUI_M_FM_AGENT_CODE(), dummyBean.getUI_M_TO_AGENT_CODE(), M_FM_DATE, M_TO_DATE);
                   	procedure.INS_COMP_BENEF_YEAR_END(dummyBean.getUI_M_FM_AGENT_CODE(), dummyBean.getUI_M_TO_AGENT_CODE(), M_FM_DATE, M_TO_DATE);
                 
                }
                else
                {
                	Object[] value = {Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$UI_M_PROCESS_BUT$prompt")};
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",value));
                }
            }
            action.getWarningMap().clear();
            action.getErrorMap().clear();
            action.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(errorBundle, "3083"));
            action.getWarningMap().put("CURRENT", Messages.getString(errorBundle, "3083"));
					
        }
        catch(Exception e){
        	e.printStackTrace();
        	throw new Exception(e.getMessage());
        }
        
    }
	public void pilp032_tisb_pre_form(FacesContext context) throws SQLException,Exception
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		Connection connection = null;
		
        try
        {
//            final dbms_output dbms_output1=new dbms_output();
        	connection = CommonUtils.getConnection();
            String M_FILE=null;
            String M_TITLE=null;
            
            sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
            sessionMap.put("GLOBAL.M_PARA_1", " ");
            
            /*SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);
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
                :GLOBAL.M_DFLT_VALUES=" ";
            }
            STD_PRE_FORM.STD_PRE_FORM();
            if(StringFunctions.substr(:GLOBAL.M_FOR_LANG_CODE,5,1)=="1")
            {
            }
            pcopk_sys_vars.pcopk_sys_vars.p_set_para_values(:GLOBAL.M_LANG_CODE,:GLOBAL.M_FOR_LANG_CODE,:GLOBAL.M_USER_ID,:CTRL.M_COMP_CODE,:CTRL.M_DIVN_CODE,:CTRL.M_DEPT_CODE,null,null,"ILIFE");
            STD_PRE_FORM.STD_PRE_FORM();
            if(StringFunctions.substr(:GLOBAL.M_FOR_LANG_CODE,5,1)=="1")
            {
            }
            M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
            SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);*/
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        
    }
	public ArrayList<DUMMY> m_fm_agent_code_key_listval(FacesContext context, String value) throws DBException
	{
		System.out.println(">>>>>>>>>>>>>>"+value);
		if(value != null)
		{
			if(value.equals("*"))
				value="%";
			else
				value = value+"%";
		}
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		DUMMY dummyBean = null;
		
		String query = "SELECT CUST_CODE, CUST_NAME" +
				" FROM PM_CUSTOMER" +
				" WHERE CUST_CLASS IN" +
				" (SELECT CCLAS_CODE" +
				" FROM PM_CUST_CLASS" +
				" WHERE CCLAS_TYPE IN ('002'))" +
				" AND CUST_FRZ_FLAG = 'N' AND CUST_CODE LIKE NVL(?, CUST_CODE) AND ROWNUM<20 ORDER BY CUST_CODE ";
		ArrayList<DUMMY> list = new ArrayList<DUMMY>();
		try {
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{value});
			while(rst.next())
			{
				dummyBean = new DUMMY();
				dummyBean.setUI_M_FM_AGENT_CODE(rst.getString(1));
				dummyBean.setUI_M_TO_AGENT_CODE(dummyBean.getUI_M_FM_AGENT_CODE());
				dummyBean.setUI_M_FM_AGENT_DESC(rst.getString(2));
				dummyBean.setUI_M_TO_AGENT_DESC(dummyBean.getUI_M_FM_AGENT_DESC());
				list.add(dummyBean);
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	public void pilp032_tisb_dummy_m_fm_agent_code_when_validate_item(String value) 
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		DUMMY_ACTION action = (DUMMY_ACTION)sessionMap.get("PILP032_TISB_DUMMY_ACTION");
		String M_FM_AGENT_CODE = (String) action.getCOMP_UI_M_FM_AGENT_CODE().getSubmittedValue();
		DUMMY dummyBean = null;
        try
        {
        	
	        	connection = CommonUtils.getConnection();
	        	dummyBean = action.getDUMMY_BEAN();
	//            final dbms_output dbms_output1=new dbms_output();
	            String sql_C1="SELECT CUST_NAME FROM  PM_CUSTOMER" +
	            		" WHERE  CUST_CODE  = ? ";
	            ResultSet rs_C1=null;
	//            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            if(rs_C1!=null)
	            {
	            	rs_C1.close();
	            }
	//            vembu_C1=stmt_C1.executeQuery(sql_C1);
	            dummyBean.setUI_M_FM_AGENT_CODE(M_FM_AGENT_CODE);
	            rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{dummyBean.getUI_M_FM_AGENT_CODE()});
	            if(rs_C1.next())
	            {
	            	dummyBean.setUI_M_FM_AGENT_DESC(rs_C1.getString(1));
	            	action.getCOMP_UI_M_FM_AGENT_DESC().setSubmittedValue(rs_C1.getString(1));
	            }
	            if(rs_C1.isAfterLast() || rs_C1.isBeforeFirst())
	            {
	//            	:DUMMY.M_FM_AGENT_CODE!="0"
	                if(!"0".equals(dummyBean.getUI_M_FM_AGENT_CODE()))
	                {
	                    /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1007,NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"));
	                    throw new FORM_TRIGGER_FAILURE();*/
	                	throw new ValidatorException(Messages.getMessage(errorBundle, "1007"));
	                }
	            }
	            if("0".equals(dummyBean.getUI_M_FM_AGENT_CODE()))
	            {
	//                :DUMMY.M_FM_AGENT_DESC=" ";
	            	dummyBean.setUI_M_FM_AGENT_DESC(" ");
	            }
	            rs_C1.close();
	//            :DUMMY.M_TO_AGENT_CODE=:DUMMY.M_FM_AGENT_CODE;
	            dummyBean.setUI_M_TO_AGENT_CODE(dummyBean.getUI_M_FM_AGENT_CODE());
	//            P_SET_FIRST_FIELD.P_SET_FIRST_FIELD("DUMMY.M_FM_AGENT_CODE","DUMMY.M_TO_AGENT_CODE");
        	
        }
        catch (ValidatorException ve)
        {
        	throw ve;
		}
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
	public void pilp032_tisb_dummy_m_fm_date_when_validate_item() throws SQLException,Exception
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		DUMMY_ACTION action = (DUMMY_ACTION)sessionMap.get("PILP032_TISB_DUMMY_ACTION");
		DUMMY dummyBean = null;
        try
        {
//            final dbms_output dbms_output1=new dbms_output();
        	dummyBean = action.getDUMMY_BEAN();
        	connection = CommonUtils.getConnection();
            String sql_C1="SELECT CAY_FRM_DT, CAY_TO_DT FROM FM_COMP_ACNT_YEAR" +
            		" WHERE  ?  BETWEEN CAY_FRM_DT  AND  CAY_TO_DT ";
            ResultSet rs_C1=null;
//            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql_C2="SELECT TO_CHAR(TO_DATE(?, 'DD/MM/RRRR'), 'MM') FROM  DUAL  ";
            ResultSet rs_C2=null;
//            Statement stmt_C2=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql_C3="SELECT TO_CHAR(TO_DATE(?, 'DD/MM/RRRR'), 'RRRR') FROM  DUAL  ";
            ResultSet rs_C3=null;
//            Statement stmt_C3=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            java.sql.Date P_ST_DT=null;
            double P_MON=0;
            double P_YEAR=-1;
            java.sql.Date P_FM_DATE=null;
            java.sql.Date P_TO_DATE=null;
//            :GLOBAL.M_PARA_1
            if(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARA_1"),"X")=="B")
            {
                if(rs_C2!=null)
                {
                	rs_C2.close();
                }
//                vembu_C2=stmt_C2.executeQuery(sql_C2);
                rs_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{dummyBean.getUI_M_FM_DATE()});
                if(rs_C2.next())
                {
                    P_MON=rs_C2.getDouble(1);
                }
                rs_C2.close();
                if(rs_C3!=null)
                {
                	rs_C3.close();
                }
//                vembu_C3=stmt_C3.executeQuery(sql_C3);
                rs_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{dummyBean.getUI_M_FM_DATE()});
                if(rs_C3.next())
                {
                    P_YEAR=rs_C3.getDouble(1);
                }
                rs_C3.close();
                P_ST_DT=ConvertFunctions.to_date("01"+"/"+P_MON+"/"+P_YEAR,"DD/MM/RRRR");
//                :DUMMY.M_FM_DATE!=P_ST_DT
                if(dummyBean.getUI_M_FM_DATE()!=P_ST_DT)
                {
                	Object[] value = {Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$UI_M_FM_DATE$WHEN_VAL$error")};
                	throw new ValidatorException(Messages.getMessage(errorBundle, "3206", value));
                    /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"DATE SHOULD START FROM THE FIRST DAY OF A MONTH");
                    throw new FORM_TRIGGER_FAILURE();*/
                }
            }
            if(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARA_1"),"X")=="Y")
            {
                if(rs_C1!=null)
                {
                	rs_C1.close();
                }
//                vembu_C1=stmt_C1.executeQuery(sql_C1);
                rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{dummyBean.getUI_M_FM_DATE()});
                if(rs_C1.next())
                {
                    P_FM_DATE=new java.sql.Date(rs_C1.getTimestamp(1).getTime());
                    P_TO_DATE=new java.sql.Date(rs_C1.getTimestamp(2).getTime());
                }
//                :DUMMY.M_FM_DATE!=P_FM_DATE
                if(dummyBean.getUI_M_FM_DATE()!=P_FM_DATE)
                {
                	Object[] value = {Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$UI_M_FM_DATE$WHEN_VAL$error2")};
                	throw new ValidatorException(Messages.getMessage(errorBundle, "3206", value));
                    /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,"FROM DATE SHOULD BE THE START OF THE FINANCIAL YEAR");
                    throw new FORM_TRIGGER_FAILURE();*/
                }
                rs_C1.close();
            }
//            :DUMMY.M_FM_DATE>:DUMMY.M_TO_DATE
            if(dummyBean.getUI_M_FM_DATE().after(dummyBean.getUI_M_TO_DATE()))
            {
                /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71145,:CTRL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();*/
            	throw new ValidatorException(Messages.getMessage(errorBundle, "71145"));
            }
//            :DUMMY.M_FM_DATE>new java.sql.Date(Calendar.getInstance().getTimeInMillis())
            else if(dummyBean.getUI_M_FM_DATE().after(new java.sql.Date(Calendar.getInstance().getTimeInMillis())))
            {
                /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(60021,:CTRL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();*/
            	throw new ValidatorException(Messages.getMessage(errorBundle, "60021"));
            }
        }
        catch (ValidatorException ve) 
        {
        	throw ve;
		}
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
	public void pilp032_tisb_dummy_m_process_date_when_validate_item(Date processDate) throws Exception
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		@SuppressWarnings("unused")
		Connection connection =null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		DUMMY_ACTION action = (DUMMY_ACTION)sessionMap.get("PILP032_TISB_DUMMY_ACTION");
		Date M_PROCESS_DATE = processDate;
		DUMMY dummyBean = null;
        try
        {
//            final dbms_output dbms_output1=new dbms_output();
        	dummyBean = action.getDUMMY_BEAN();
        	connection = CommonUtils.getConnection();
        	dummyBean.setUI_M_PROCESS_DATE(M_PROCESS_DATE);
        	System.out.println("dummyBean.getUI_M_PROCESS_DATE():::"+dummyBean.getUI_M_PROCESS_DATE());
//        	:DUMMY.M_PROCESS_DATE>new java.sql.Date(Calendar.getInstance().getTimeInMillis())
            if(dummyBean.getUI_M_PROCESS_DATE().after(new java.sql.Date(Calendar.getInstance().getTimeInMillis())))
            {
            	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "60021"));
            }
        }
        catch(Exception e) {
        	throw new Exception(e.getMessage());
        }
        
    }
	public void pilp032_tisb_dummy_m_to_agent_code_when_validate_item() throws Exception 
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		DUMMY_ACTION action = (DUMMY_ACTION)sessionMap.get("PILP032_TISB_DUMMY_ACTION");
		String M_TO_AGENT_CODE = (String)action.getCOMP_UI_M_TO_AGENT_CODE().getSubmittedValue();
		DUMMY dummyBean = null;
        try
        {
//            final dbms_output dbms_output1=new dbms_output();
        	dummyBean = action.getDUMMY_BEAN();
        	connection = CommonUtils.getConnection();
            String sql_C1="SELECT CUST_NAME FROM  PM_CUSTOMER" +
            		" WHERE  CUST_CODE  = ? ";
            ResultSet rs_C1=null;
            if(rs_C1!=null)
            {
            	rs_C1.close();
            }
            dummyBean.setUI_M_TO_AGENT_CODE(M_TO_AGENT_CODE);
            rs_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{dummyBean.getUI_M_TO_AGENT_CODE()});
            if(rs_C1.next())
            {
            	dummyBean.setUI_M_TO_AGENT_CODE(rs_C1.getString(1));
            	action.getCOMP_UI_M_TO_AGENT_DESC().setSubmittedValue(rs_C1.getString(1));
            }
            if(rs_C1.isAfterLast() || rs_C1.isBeforeFirst())
            {
                if(dummyBean.getUI_M_TO_AGENT_CODE().indexOf("Z")== -1)
                {
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1007"));
                }
            }
            if(dummyBean.getUI_M_TO_AGENT_CODE().indexOf("Z")!= -1)
            {
            	dummyBean.setUI_M_TO_AGENT_DESC("");
            }
            rs_C1.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
    }
	public void pilp032_tisb_dummy_m_to_date_when_validate_item() throws Exception 
    {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DUMMY_ACTION action = (DUMMY_ACTION)sessionMap.get("PILP032_TISB_DUMMY_ACTION");
		DUMMY dummyBean = null;
        try
        {
        	dummyBean = action.getDUMMY_BEAN();
        	connection = CommonUtils.getConnection();
            String sql_C1="SELECT CAY_FRM_DT, CAY_TO_DT FROM FM_COMP_ACNT_YEAR" +
            		" WHERE ? BETWEEN CAY_FRM_DT AND CAY_TO_DT ";
            ResultSet rs_C1=null;
            String sql_C2="SELECT TO_CHAR(TO_DATE(?, 'DD/MM/RRRR'), 'MM') FROM  DUAL  ";
            ResultSet rs_C2=null;
            String sql_C3="SELECT TO_CHAR(TO_DATE(?, 'DD/MM/RRRR'), 'RRRR') FROM  DUAL  ";
            ResultSet rs_C3=null;
            java.sql.Date P_ST_DT=null;
            double P_MON=0;
            double P_YEAR=-1;
            java.sql.Date P_FM_DATE=null;
            java.sql.Date P_TO_DATE=null;
            if(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARA_1"),"X")=="B")
            {
                if(rs_C2!=null)
                {
                	rs_C2.close();
                }
                rs_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{dummyBean.getUI_M_TO_DATE()});
                if(rs_C2.next())
                {
                    P_MON=rs_C2.getDouble(1);
                }
                rs_C2.close();
                if(rs_C3!=null)
                {
                	rs_C3.close();
                }
                rs_C3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{dummyBean.getUI_M_TO_DATE()});
                if(rs_C3.next())
                {
                    P_YEAR=rs_C3.getDouble(1);
                }
                rs_C3.close();
                P_ST_DT=DateFunctions.last_day(ConvertFunctions.to_date("01"+"/"+P_MON+"/"+P_YEAR,"DD/MM/RRRR"));
                if(dummyBean.getUI_M_TO_DATE()!=P_ST_DT)
                {
                	Object[] value = {Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$UI_M_TO_DATE$WHEN_VAL$lastday")};
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",value));
                }
            }
            if(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARA_1"),"X")=="Y")
            {
                if(rs_C1!=null)
                {
                    rs_C1.close();
                }
                rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{dummyBean.getUI_M_TO_DATE()});
                if(rs_C1.next())
                {
                    P_FM_DATE=new java.sql.Date(rs_C1.getTimestamp(1).getTime());
                    P_TO_DATE=new java.sql.Date(rs_C1.getTimestamp(2).getTime());
                }
                if(dummyBean.getUI_M_TO_DATE()!=P_TO_DATE)
                {
                	Object[] value = {Messages.getString("messageProperties_PILP032_TISB", "PILP032_TISB$DUMMY$UI_M_TO_DATE$WHEN_VAL$todate")};
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",value));
                 }
                rs_C1.close();
            }
           
            if(dummyBean.getUI_M_FM_DATE()!=null&& dummyBean.getUI_M_TO_DATE()!=null)
            	
            {
            if(dummyBean.getUI_M_TO_DATE().before(dummyBean.getUI_M_FM_DATE()))
            {
            	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "21602"));
						
            }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
    }
	public static void pilp032_tisb_dummy_when_create_record() throws SQLException,Exception
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DUMMY dummyBean = null;
        try
        {
//            final dbms_output dbms_output1=new dbms_output();
        	dummyBean = new DUMMY();
        	connection = CommonUtils.getConnection();
            String sql_C1="SELECT TO_CHAR(TO_DATE(SYSDATE, 'DD/MM/RRRR'), 'MM') FROM  DUAL  ";
            ResultSet rs_C1=null;
//            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql_C2="SELECT TO_CHAR(TO_DATE(SYSDATE, 'DD/MM/RRRR'), 'RRRR') FROM  DUAL  ";
            ResultSet rs_C2=null;
//            Statement stmt_C2=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql_C3="SELECT  CAY_FRM_DT,  CAY_TO_DT FROM  FM_COMP_ACNT_YEAR" +
            		"  WHERE SYSDATE BETWEEN CAY_FRM_DT AND CAY_TO_DT AND SYSDATE" +
            		"  BETWEEN CAY_FRM_DT AND CAY_TO_DT ";
            ResultSet rs_C3=null;
//            Statement stmt_C3=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            double P_MON=-1;
            double P_YEAR=-1;
            if(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARA_1"),"X")=="B")
            {
                if(rs_C1!=null)
                {
                	rs_C1.close();
                }
//                vembu_C1=stmt_C1.executeQuery(sql_C1);
                rs_C1 = handler.executeSelectStatement(sql_C1, connection);
                if(rs_C1.next())
                {
                    P_MON=rs_C1.getDouble(1);
                }
                rs_C1.close();
                if(rs_C2!=null)
                {
                	rs_C2.close();
                }
//                vembu_C2=stmt_C2.executeQuery(sql_C2);
                rs_C2 = handler.executeSelectStatement(sql_C2, connection);
                if(rs_C2.next())
                {
                    P_YEAR=rs_C2.getDouble(1);
                }
                rs_C2.close();
                /*:DUMMY.M_FM_DATE=ConvertFunctions.to_date("01"+"/"+P_MON+"/"+P_YEAR,"DD/MM/RRRR");
                :DUMMY.M_TO_DATE=DateFunctions.last_day(ConvertFunctions.to_date("01"+"/"+P_MON+"/"+P_YEAR,"DD/MM/RRRR"));
                :DUMMY.M_PROCESS_DATE=new java.sql.Date(Calendar.getInstance().getTimeInMillis());*/
                dummyBean.setUI_M_FM_DATE(ConvertFunctions.to_date("01"+"/"+P_MON+"/"+P_YEAR,"DD/MM/RRRR"));
                dummyBean.setUI_M_TO_DATE(DateFunctions.last_day(ConvertFunctions.to_date("01"+"/"+P_MON+"/"+P_YEAR,"DD/MM/RRRR")));
                dummyBean.setUI_M_PROCESS_DATE(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            }
            if(MigratingFunctions.nvl((String)sessionMap.get("GLOBAL.M_PARA_1"),"X")=="Y")
            {
                if(rs_C3!=null)
                {
                	rs_C3.close();
                }
//                vembu_C3=stmt_C3.executeQuery(sql_C3);
                rs_C3 = handler.executeSelectStatement(sql_C3, connection);
                if(rs_C3.next())
                {
                }
                rs_C3.close();
//                :DUMMY.M_PROCESS_DATE=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
                dummyBean.setUI_M_PROCESS_DATE(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

}
