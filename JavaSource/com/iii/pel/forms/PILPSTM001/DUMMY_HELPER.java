package com.iii.pel.forms.PILPSTM001;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {

	/**
	 * 
	 */
	public void preForm(PILPSTM001_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_FILE =null;
		String M_TITLE =null;
		String M_VALUE=null;
		String M_DESC =null;
		ResultSet C1_REC=null;
		ResultSet C2_REC=null;
		CRUDHandler handler = null;
		Connection connection=null;
		String M_SCREEN_RES = null;
		String C1 = "SELECT NVL(PS_VALUE, 1) FROM   PP_SYSTEM WHERE  PS_TYPE = 'PR_SI_CURR'";
		String C2 = "SELECT NVL(PS_VALUE,1) FROM   PP_SYSTEM WHERE  PS_TYPE = 'SCREEN_RES'";
		
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			
			String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
			if(CALLING_FORM==null || "".equalsIgnoreCase(CALLING_FORM)){
				
				CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE", "YYY");
				CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
				
				
				
				CommonUtils.setGlobalVariable("GLOBAL.M_PARA_1", "");
				
				CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES", "00101    01    ");
				
			}
			
			STD_PRE_FORM(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			CommonUtils.setGlobalVariable("GLOBAL.M_COMP_CODE", "001");
			M_TITLE = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID() + compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUI_M_SCR_NAME() + new CommonUtils().getCurrentDate();
			
			
			C2_REC =  handler.executeSelectStatement(C2, connection);
			if(C2_REC.next()){
				M_SCREEN_RES = C2_REC.getString(1);
			}else{
				M_SCREEN_RES = "1";
			}
			   /*IF NVL(GET_APPLICATION_PROPERTY(CALLING_FORM),'*') NOT LIKE 'PT001%' THEN
			      IF M_SCREEN_RES = 1 THEN
			         SET_WINDOW_PROPERTY('PT_APPRV',POSITION,0,0);
			      ELSE
			         SET_WINDOW_PROPERTY('PT_APPRV', POSITION,0,0);
			      END IF;
			   ELSE
			      IF M_SCREEN_RES = 1 THEN
			         SET_WINDOW_PROPERTY('PT_APPRV',POSITION,195,0);
			      ELSE
			         SET_WINDOW_PROPERTY('PT_APPRV', POSITION, 316, 0);
			      END IF;
			   END IF;*/
			
			C1_REC =  handler.executeSelectStatement(C1, connection);
			if(C1_REC.next()){
				M_VALUE = C1_REC.getString(1);
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1207",
						new Object[] { "PR_SI_CURR" }));
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
		}
	}
	
	private void STD_PRE_FORM(CTRL CTRL_BEAN){
		
		String M_PARA_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String M_USER_ID = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
		String M_SCR_NAME = CommonUtils.getGlobalVariable("GLOBAL.M_NAME");
		String LANG_CODE = CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE");
		String M_DFLT_VALUES = CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES");
		String M_MODULE_NAME =  CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_NAME");
		String M_COMP_CODE = null;
		String M_DIVN_CODE =null;
		String M_DEPT_CODE = null;
		
		if(M_DFLT_VALUES==null || "".equalsIgnoreCase(M_DFLT_VALUES)){
			M_COMP_CODE = "001";//M_DFLT_VALUES.substring(1, 3);
			M_DIVN_CODE = "HO";//M_DFLT_VALUES.substring(4, 6);
			M_DEPT_CODE = "001";//M_DFLT_VALUES.substring(10, 6);
		}
		
		CTRL_BEAN.setUI_M_PARA_1(M_PARA_1);
		CTRL_BEAN.setUI_M_USER_ID(M_USER_ID);
		CTRL_BEAN.setUI_M_LANG_CODE(LANG_CODE);
		CTRL_BEAN.setUI_M_COMP_CODE(M_COMP_CODE);
		CTRL_BEAN.setUI_M_DIVN_CODE(M_DIVN_CODE);
		CTRL_BEAN.setUI_M_DEPT_CODE(M_DEPT_CODE);
		CTRL_BEAN.setUI_M_SCR_NAME(M_SCR_NAME);
		CTRL_BEAN.setUI_M_MODULE_NAME(M_MODULE_NAME);
		CTRL_BEAN.setUI_M_FAILURE("false");
		CTRL_BEAN.setUI_M_GOFLD_NAME(null);
		
		  /* COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
		   COPY(NAME_IN('GLOBAL.M_PARA_1'),'CTRL.M_PARA_1');
		   COPY(NAME_IN('GLOBAL.M_USER_ID'),'CTRL.M_USER_ID');
		   COPY(GET_APPLICATION_PROPERTY(CURRENT_FORM),'CTRL.M_PROG_NAME');
		   COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		   COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),31,30), 'CTRL.M_SCR_NAME') ;
		   COPY('10','SYSTEM.MESSAGE_LEVEL');
		   COPY('FALSE','GLOBAL.M_FAILURE') ;
		   COPY(NULL,'CTRL.M_GOFLD_NAME') ;
		   COPY(NAME_IN('GLOBAL.M_LANG_CODE'), 'CTRL.M_LANG_CODE') ;
		   COPY(SUBSTR(NAME_IN('GLOBAL.M_DFLT_VALUES'),1,3),'CTRL.M_COMP_CODE');
		   COPY(SUBSTR(NAME_IN('GLOBAL.M_DFLT_VALUES'),4,6),'CTRL.M_DIVN_CODE');
		   COPY(SUBSTR(NAME_IN('GLOBAL.M_DFLT_VALUES'),10,6),'CTRL.M_DEPT_CODE');*/
		
		/* LOOP
	      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
	         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
	            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
	         ELSE
	            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE) ;
	         END IF ;
	      END IF;
	      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
	         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
	            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
	         ELSE
	            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE) ;
	         END IF ;
	      END IF;
	      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
	         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
	            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
	         ELSE
	            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_FALSE) ;
	         END IF ;
	      END IF;
	      M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ;
	      IF M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN
	         EXIT ;
	      END IF ;
	   END LOOP ;

	   RG_ID	:= FIND_GROUP('RG_HINT') ;
	   IF ID_NULL(RG_ID) THEN
	      NULL ;
	   ELSE
	      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
	   END IF ;
	   RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
	   IF ID_NULL(RG_ID) THEN
	      NULL ;
	   ELSE
	      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
	   END IF ;
	   LOAD_BP;
	   ENABLE_BUTTONS ;
	   IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
	      LOAD_BALOON_LABEL;
	   END IF;*/
		
	}

	/**
	 * 
	 * @param CTRL_BEAN
	 * @throws Exception
	 */
	public void whenNewRecordInstance(CTRL CTRL_BEAN) throws Exception{
		CRUDHandler handler = null;
		String C1 = "	SELECT NVL(AS_MOD_ACC_FLAG_YN,'N') FROM PM_APPR_SETUP WHERE AS_USER_ID = ? ";
		ResultSet C1_REC = null;
		try{
			handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{CTRL_BEAN.getUI_M_USER_ID()});
			if(C1_REC.next()){
				String M_FLAG = C1_REC.getString(1);
			}
		}catch(Exception exception){
			exception.getMessage();
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	/**
	 * 
	 * @param DUMMY1_BEAN
	 */
	public void whenCreateRecord(PILPSTM001_COMPOSITE_ACTION compositeAction){
		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PRO_FOR("W");
		//compositeAction.getDUMMY_ACTION_BEAN().getUI_PROC_FOR().setDisabled(true);
	}
	/**
	 * 
	 * @param DUMMY1_BEAN
	 * @throws Exception
	 */
	public void whenValidatePolicyFrom(DUMMY DUMMY1_BEAN) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 1 FROM PT_IL_POLICY WHERE  POL_NO = ? AND POL_DS_TYPE ='2' "
				+ "AND EXISTS (SELECT 1  FROM   PM_IL_PLAN WHERE PLAN_TYPE ='U') " ;
						//"PLAN_CODE =POL_PLAN_CODE "
				//+ "AND    PLAN_TYPE ='U')";
		ResultSet C1_REC = null;
		String M_EXISTS = null;
		try{
			if(!"0".equals(CommonUtils.nvl(DUMMY1_BEAN.getUI_M_POLICY_FM(), "0"))){
				Connection connection = CommonUtils.getConnection();
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY1_BEAN.getUI_M_POLICY_FM()});
				if(C1_REC.next()){
					M_EXISTS = C1_REC.getString(1);
				}else{
					throw new ValidatorException(new FacesMessage("Invalid Policy No."));
				}
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	/**
	 * 
	 * @param DUMMY1_BEAN
	 * @throws Exception
	 */
	public void whenValidatePolicyTO(DUMMY DUMMY_BEAN) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 1 FROM PT_IL_POLICY WHERE  POL_NO = ? AND POL_DS_TYPE ='2' "
				+ "AND EXISTS (SELECT 1  FROM   PM_IL_PLAN WHERE PLAN_TYPE ='U') " ;
						//"PLAN_CODE =POL_PLAN_CODE "
				//+ "AND    PLAN_TYPE ='U')";
		ResultSet C1_REC = null;
		String M_EXISTS = null;
		try{
			if("0".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_POLICY_TO(), "0"))){
				Connection connection = CommonUtils.getConnection();
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY_BEAN.getUI_M_POLICY_TO()});
				if(C1_REC.next()){
					M_EXISTS = C1_REC.getString(1);
				}else{
					throw new ValidatorException(new FacesMessage("Invalid Policy No."));
				}
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	/**
	 * 
	 * @param DUMMY1_BEAN
	 * @throws Exception
	 */
	public void whenValidateDate(DUMMY DUMMY_BEAN) throws Exception{
		if(DUMMY_BEAN.getUI_M_TO_DT()!=null && DUMMY_BEAN.getUI_M_TO_DT().after(new CommonUtils().getCurrentDate())){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "2181"));
		}
	}

}
