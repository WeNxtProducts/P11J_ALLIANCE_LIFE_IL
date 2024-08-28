package com.iii.pel.forms.PILP100_APAC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class DUMMY_HELPER {
	
	public void when_create_record(DUMMY DUMMY_BEAN)throws Exception{
		String M_TEMP = null;
		String C1 = " SELECT POL_NO" +
				"		 FROM PT_GL_POLICY" +
				"		 WHERE POL_SYS_ID= ?";
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		 try{
			 connection = CommonUtils.getConnection();
			 values = new Object[]{CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID")};
			 resultSet = handler.executeSelectStatement(C1, connection, values);
			 if(resultSet.next()){
				 M_TEMP = resultSet.getString(1);
			 }
			 if(M_TEMP != null){
			 DUMMY_BEAN.setUI_M_DOC_NO(M_TEMP);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	public void when_new_form_instance(DUMMY_ACTION dummyAction) throws Exception{
		String M_CALLING_FORM = null;
		Integer M_DUMMY_NO = 1;
		String M_PLSP_REPORT_NAME = null;
		String M_PLSP_REPORT_ID = null;
		int M_PLSP_SRNO = 0;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		String M_DUMMY_NO_STR = null;
		
		String C1 = " SELECT  PLSP_REPORT_NAME,PLSP_REPORT_ID,PLSP_SRNO " +
				"	     FROM  PP_LIFE_POL_SCH_PRN" +
				"	    WHERE  PLSP_MODULE_NAME  =  ? " +
				"	      AND  PLSP_PROD_CODE    = ?" +
				"	      AND  PLSP_DS_TYPE      = ?" +
				"	      AND  PLSP_DS_CODE      = ?" +
				"	      AND  EXISTS ( SELECT 'X'" +
				"	      FROM  PT_GL_POL_STATUS" +
				"    WHERE  PSTAT_POL_SYS_ID = ?" +
				"    AND  PSTAT_STATUS_CODE = NVL(PLSP_TYPE,'N'))" +
				"	      AND ? = 'P'" +
				"	      AND  PLSP_MODULE_ID    = 'GL'" +
				"	   UNION ALL " +
				" SELECT  PLSP_REPORT_NAME,PLSP_REPORT_ID,PLSP_SRNO " +
				"	     FROM  PP_LIFE_POL_SCH_PRN" +
				"	    WHERE  PLSP_MODULE_NAME  =  ?" +
				"	      AND  PLSP_PROD_CODE    = ?" +
				"	      AND  PLSP_DS_TYPE      = ?" +
				"	      AND  PLSP_DS_CODE      = ?" +
				"	      AND ?  = 'C'" +
				"	      AND  PLSP_MODULE_ID    = 'GL'" +
				" UNION ALL" +
				"	   SELECT  PLSP_REPORT_NAME,PLSP_REPORT_ID,PLSP_SRNO" +
				"	     FROM  PP_LIFE_POL_SCH_PRN" +
				"	    WHERE  PLSP_MODULE_NAME  =  ?" +
				"	      AND  PLSP_PROD_CODE    =  ?" +
				"	      AND  PLSP_DS_TYPE      =  ?" +
				"	      AND  PLSP_DS_CODE      =  ?" +
				"	      AND ?  =  'S'" +
				"	      AND  PLSP_MODULE_ID    =  'GL'" +
				" UNION ALL" +
				"	   SELECT  PLSP_REPORT_NAME,PLSP_REPORT_ID,PLSP_SRNO " +
				"	     FROM  PP_LIFE_POL_SCH_PRN" +
				"	    WHERE  PLSP_MODULE_NAME  =  ?" +
				"	      AND  PLSP_PROD_CODE    =  ?" +
				"	      AND  PLSP_DS_TYPE      =  ?" +
				"	      AND  PLSP_DS_CODE      =  ?" +
				"	      AND ?  =  'F'" +
				"	      AND  PLSP_MODULE_ID    =  'GL' " +
				" UNION ALL" +
				"  SELECT  PLSP_REPORT_NAME,PLSP_REPORT_ID,PLSP_SRNO " +
				"	     FROM  PP_LIFE_POL_SCH_PRN" +
				"	   WHERE  PLSP_MODULE_NAME  =  ?" +
				"	      AND  PLSP_PROD_CODE    =  ?" +
				"	      AND  PLSP_DS_TYPE      =  ?" +
				"	      AND  PLSP_DS_CODE      =  ?" +
				"	      AND ?  =  'W'" +
				"	      AND  PLSP_MODULE_ID    =  'GL' UNION ALL" +
				"	   SELECT  PLSP_REPORT_NAME,PLSP_REPORT_ID,PLSP_SRNO " +
				"     FROM  PP_LIFE_POL_SCH_PRN" +
				"	   WHERE  PLSP_MODULE_NAME  =  ?" +
				"	      AND  PLSP_PROD_CODE    =  ?" +
				"	      AND  PLSP_DS_TYPE      =  ?" +
				"	      AND  PLSP_DS_CODE      =  ?" +
				"	      AND ?  =  'M'" +
				"	      AND  PLSP_TYPE  =	?" +
				"	      AND  PLSP_MODULE_ID    =  'GL' ORDER BY 3";
		try {
			connection = CommonUtils.getConnection();
			M_CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
			values = new Object[]{M_CALLING_FORM,CommonUtils.getGlobalVariable("GLOBAL.G_PROD_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_TYPE"),CommonUtils.getGlobalVariable("GLOBAL.G_DS_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID"),
					CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"),
					M_CALLING_FORM,CommonUtils.getGlobalVariable("GLOBAL.G_PROD_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_TYPE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"),
					M_CALLING_FORM,CommonUtils.getGlobalVariable("GLOBAL.G_PROD_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_TYPE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"),
					M_CALLING_FORM,CommonUtils.getGlobalVariable("GLOBAL.G_PROD_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_TYPE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"),
					M_CALLING_FORM,CommonUtils.getGlobalVariable("GLOBAL.G_PROD_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_TYPE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"),
					M_CALLING_FORM,CommonUtils.getGlobalVariable("GLOBAL.G_PROD_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_TYPE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_DS_CODE"),
					CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"),
					CommonUtils.getGlobalVariable("GLOBAL.G_SURR_MAT")};
			resultSet = handler.executeSelectStatement(C1, connection, values);
			while(resultSet.next()){
				M_PLSP_REPORT_NAME = resultSet.getString("PLSP_REPORT_NAME");
				M_PLSP_REPORT_ID = resultSet.getString("PLSP_REPORT_ID");
				M_PLSP_SRNO = resultSet.getInt("PLSP_SRNO");
				
				M_DUMMY_NO_STR = CommonUtils.lpad(String.valueOf(M_DUMMY_NO), 2, "0");
				setValueToLabel(dummyAction, 
						"COMP_B_TEXT_"+M_DUMMY_NO_STR, 
						M_PLSP_REPORT_NAME);
				setValueToBean(dummyAction.getDUMMY_BEAN(), 
						"UI_M_PRINT_YN_"+M_DUMMY_NO_STR,
						"Y");
				setValueToBean(dummyAction.getDUMMY_BEAN(), 
						"UI_M_PREVIEW_YN_"+M_DUMMY_NO_STR,
						"N");
				setValueToBean(dummyAction.getDUMMY_BEAN(), 
						"UI_M_REPORT_"+M_DUMMY_NO_STR,
						M_PLSP_REPORT_ID);
				M_DUMMY_NO = M_DUMMY_NO + 1;
			}
			
			if(M_DUMMY_NO < 15){
				while(M_DUMMY_NO < 16){
					M_DUMMY_NO_STR = CommonUtils.lpad(String.valueOf(M_DUMMY_NO), 2, "0");
					setValueToLabel(dummyAction, 
							"COMP_B_TEXT_"+M_DUMMY_NO_STR, 
							null);
					setValueToBean(dummyAction.getDUMMY_BEAN(), 
							"UI_M_PRINT_YN_"+M_DUMMY_NO_STR,
							"N");
					setValueToBean(dummyAction.getDUMMY_BEAN(), 
							"UI_M_PREVIEW_YN_"+M_DUMMY_NO_STR,
							"N");
					setValueToBean(dummyAction.getDUMMY_BEAN(), 
							"UI_M_REPORT_"+M_DUMMY_NO_STR,
							null);
					
					setVisiblePropertyToLabel(dummyAction, 
							"COMP_B_TEXT_"+M_DUMMY_NO_STR, 
							false);
					setVisiblePropertyToSelectOneMenu(dummyAction, 
							"COMP_UI_M_PRINT_YN_"+M_DUMMY_NO_STR,            
							false);
					setVisiblePropertyToSelectOneMenu(dummyAction, 
							"COMP_UI_M_PREVIEW_YN_"+M_DUMMY_NO_STR,
							false);
					
					M_DUMMY_NO = M_DUMMY_NO + 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	private static String lpad(int number, int paddingLength){
		StringBuffer numberValue = new StringBuffer();
		int numberLength = String.valueOf(number).length();
		
		if(numberLength < paddingLength){
			for(int index=0, size=paddingLength-number; index<size; index++){
				numberValue.insert(0, "0");
			}
		}
		
		numberValue.append(number);
		
		return numberValue.toString();
	}
	
	private static void setValueToLabel(CommonAction action, String componentName, String value) 
			throws Exception{
		HtmlOutputLabel label = null;
		Method componentGetter = null;
		
		try {
			componentGetter = action.getClass().getMethod("get"+componentName);
			label = (HtmlOutputLabel) componentGetter.invoke(action);
			label.setValue(value);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private static void setVisiblePropertyToLabel(CommonAction action, String componentName, boolean value) 
			throws Exception{
		HtmlOutputLabel label = null;
		Method componentGetter = null;
		
		try {
			componentGetter = action.getClass().getMethod("get"+componentName);
			label = (HtmlOutputLabel) componentGetter.invoke(action);
			label.setRendered(value);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private static void setVisiblePropertyToSelectOneMenu(CommonAction action,
			String componentName, boolean value) throws Exception {
		HtmlSelectOneMenu selectOnemenu = null;
		Method componentGetter = null;

		try {
			componentGetter = action.getClass()
					.getMethod("get" + componentName);
			selectOnemenu = (HtmlSelectOneMenu) componentGetter.invoke(action);
			selectOnemenu.setRendered(value);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private static void setValueToBean(BaseValueBean bean, String fieldName, String value) 
			throws Exception{
		Method fieldSetter = null;
		
		try {
			fieldSetter = bean.getClass().getMethod("set"+fieldName, java.lang.String.class);
			fieldSetter.invoke(bean, value);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public String M_BUT_OK(DUMMY DUMMY_BEAN){
		 	Map<String,String> PL_ID =null;
			String M_REPORT_YN = null;
			String M_PRINT_YN = null;
			String M_PREVIEW_YN  = null;
			String M_REPORT_ID = null;
			
			try {
				//PL_ID := GET_PARAMETER_LIST('REP_PARAM');
				if(!PL_ID.isEmpty()){
				        PL_ID.clear();
				}
				 //PL_ID := CREATE_PARAMETER_LIST('REP_PARAM');
				 if(PL_ID.isEmpty()){
					 //TODO
					 //RAISE FORM_TRIGGER_FAILURE;
					 return null;
				 }
				 if("C".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"))){
				    PL_ID.put("P_CLAIM_SYS_ID",CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID"));
				 }
				 else if("P".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"))){
				    PL_ID.put("P_POL_SYS_ID",CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID"));
				 }
				 else if("F".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"))){
				     PL_ID.put("P_PC_SYS_ID", CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID"));   
				     PL_ID.put("P_POL_SYS_ID", CommonUtils.getGlobalVariable("GLOBAL.G_GLOBALDOC_SYS_ID"));
				 }
				 else if("W".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"))){
				       PL_ID.put("P_WD_SYS_ID",CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID"));
				        PL_ID.put("P_POL_SYS_ID",CommonUtils.getGlobalVariable("GLOBAL.G_DOC_SYS_ID"));
				 }
				 else if("M".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.G_REP_FOR"))){
				        PL_ID.put("P_SMV_SYS_ID" ,CommonUtils.getGlobalVariable("GLOBAL.G_SYS_ID"));
				       PL_ID.put("P_POL_SYS_ID",CommonUtils.getGlobalVariable("GLOBAL.G_DOC_SYS_ID"));    
				 }
				         
				 PL_ID.put("P_USER_ID",CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				 PL_ID.put("P_DIVN_CODE",DUMMY_BEAN.getUI_M_DIVN_CODE());
				 PL_ID.put("PARAMFORM","NO"); 

				for(int i=1;i<=15;i++){
				           // M_PRINT_YN    = DUMMY_BEAN.getUI_M_PRINT_YN_ NAME_IN('DUMMY.M_PRINT_YN_'||TO_CHAR(I,'FM09'));
				            //M_PREVIEW_YN  := NAME_IN('DUMMY.M_PREVIEW_YN_'||TO_CHAR(I,'FM09'));
				 		    if("Y".equals(CommonUtils.nvl(M_PRINT_YN,"N")) || 
				 		    		"Y".equals(CommonUtils.nvl(M_PREVIEW_YN,"N"))){
				                M_REPORT_ID = null;
				 		        //M_REPORT_ID = NAME_IN('DUMMY.M_REPORT_'||TO_CHAR(I,'FM09'));
				                if(M_REPORT_ID != null){ 
				 		         	      if("Y".equals(CommonUtils.nvl(M_PRINT_YN,"N"))){
							                 PL_ID.put("DESTYPE","PRINTER");
				 		         	      }
				 		         	      else{
				 		         	    	PL_ID.put("DESTYPE","PREVIEW");	       	
				 		         	      }
				                    //RUN_PRODUCT(REPORTS,M_REPORT_ID,SYNCHRONOUS,RUNTIME,FILESYSTEM,PL_ID,NULL);
				                    //DELETE_PARAMETER(PL_ID,'DESTYPE');
				                    PL_ID.remove("DESTYPE");
				                }
				 		    }
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	
}

