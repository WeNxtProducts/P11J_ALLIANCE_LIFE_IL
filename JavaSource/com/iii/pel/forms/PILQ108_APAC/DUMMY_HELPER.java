/**
 * 
 */
package com.iii.pel.forms.PILQ108_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class DUMMY_HELPER {

	
	public void preForm(PILQ108_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_FILE =null;
		String M_TITLE =null;
		String C1 = "SELECT POL_START_DT FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ? ";
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		
		
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		if(CALLING_FORM==null || "".equalsIgnoreCase(CALLING_FORM)){
		     /* :GLOBAL.M_PRIVILEGE := 'YYY' ;
		      :GLOBAL.M_FAILURE   := 'FALSE';
		      :GLOBAL.M_USER_ID   := 'PREMIA';
		      :GLOBAL.M_NAME      := 'COMPANY NAME..................PROGRAM NAME';
		      :GLOBAL.M_LANG_CODE := 'ENG' ;
		      :GLOBAL.M_PARA_1    := ' ' ;
		      :GLOBAL.M_COMP_NAME :=' ';
		      :GLOBAL.M_SCR_NAME  :=' ';
		      :GLOBAL.M_FOR_LANG_CODE  := 'ARBR1';
		      :GLOBAL.M_MODULE_NAME    := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
							CURRENT_FORM_NAME),FORM_NAME) */
							
			CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE", "YYY");
	        CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
	        
	        
	        
	        CommonUtils.setGlobalVariable("GLOBAL.M_PARA_1", "");
	        
	        CommonUtils.setGlobalVariable("GLOBAL.M_SCR_NAME", "");
	        
	        CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME", "");
		}
		
		STD_PRE_FORM();
		
		 /* IF SUBSTR(:GLOBAL.M_FOR_LANG_CODE,5,1) = '1' THEN
	      NULL ;
	      *//** Set Bilingual Items 

	      SET_ITEM_PROPERTY('DUMMY.BILINGUAL', ENABLED, PROPERTY_FALSE) ;
	      SET_ITEM_PROPERTY('DUMMY.DEPT_BILINGUAL', ENABLED, PROPERTY_FALSE) ;
	      SET_ITEM_PROPERTY('PM_DIVISION.DIVN_BL_SHORT_NAME',ENABLED,PROPERTY_FALSE);
	      SET_ITEM_PROPERTY('PM_DIVISION.DIVN_BL_ADDR1',ENABLED,PROPERTY_FALSE);
	      SET_ITEM_PROPERTY('PM_DIVISION.DIVN_BL_ADDR2',ENABLED,PROPERTY_FALSE);
	**//*
	   END IF ;*/
		 /*M_TITLE:= :CTRL.M_USER_ID ||'                 '||:CTRL.M_SCR_NAME||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
		   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);*/
		if(CALLING_FORM!=null && CALLING_FORM.startsWith("PILT002%")){
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setPOAD_ASSRD_REF_ID1(CommonUtils.getGlobalVariable("GLOBAL.M_POAD_REF_ID1"));
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setPOAD_ASSRD_REF_ID2(CommonUtils.getGlobalVariable("GLOBAL.M_POAD_REF_ID2"));
			compositeAction.getDUMMY_ACTION_BEAN().disableAllComponent(true);
			
			String double1 = CommonUtils.getGlobalVariable("GLOBAL.M_POAD_POL_SYS_ID");
			Double double2 = Double.parseDouble(double1);
			try{
				handler = new CRUDHandler();
				connection = CommonUtils.getConnection();
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{double2});
				if(C1_REC.next()){
					Date dat = C1_REC.getDate(1);
					if(dat!=null){
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_START_DT(dat);
					}
				}
			}catch(Exception exception){
				throw new Exception(exception.getMessage());
			}
		}else if(CALLING_FORM!=null && CALLING_FORM.startsWith("GNMNF001_A%")){
			compositeAction.getDUMMY_ACTION_BEAN().disableAllComponent(false);
			Date date = new CommonUtils().getCurrentDate();
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_START_DT(date);
		}else{
			compositeAction.getDUMMY_ACTION_BEAN().disableAllComponent(true);
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setPOAD_ASSRD_REF_ID1(CommonUtils.getGlobalVariable("GLOBAL.M_POAD_REF_ID1"));
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setPOAD_ASSRD_REF_ID2(CommonUtils.getGlobalVariable("GLOBAL.M_POAD_REF_ID2"));
			Date s = (Date)CommonUtils.getGlobalObject("GLOBAL.M_POL_START_DATE");
			if(s!=null){
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_START_DT(s);
			}else{
				Date date = new CommonUtils().getCurrentDate();
			    compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_START_DT(date);
			}
				
		}
	}
	
	
	public void STD_PRE_FORM(){
		
	}

	


}
