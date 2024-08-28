package com.iii.pel.forms.PILP086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PT_IL_HIBAH_FEE_PRCSS_HELPER {

	private static final Log log = LogFactory.getLog(PT_IL_HIBAH_FEE_PRCSS_HELPER.class);

	public void executeQuery(PILP086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_HIBAH_FEE_PRCSS_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PT_IL_HIBAH_FEE_PRCSS> dataList = compositeAction.
	getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN().getDataList_PT_IL_HIBAH_FEE_PRCSS();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN = dataList.get(0);
		PT_IL_HIBAH_FEE_PRCSS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN()
		.setPT_IL_HIBAH_FEE_PRCSS_BEAN(PT_IL_HIBAH_FEE_PRCSS_BEAN);
	}
	}
	
	/**
	 * 
	 */
	public void whenNewFormInstance(){
		//null;
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void preForm(PILP086_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_FILE =null;
		String M_TITLE =null;
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		if(CALLING_FORM==null || "".equalsIgnoreCase(CALLING_FORM)){
			CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE", "YYY");
			CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
			
			
			CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES", "00101    01");
		}
		STD_PRE_FORM(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
		/* IF SUBSTR(:GLOBAL.M_FOR_LANG_CODE,5,1) = '1' THEN
	      NULL ;
	   END IF ;*/
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", null);
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", null);
		M_TITLE = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID() + compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUI_M_SCR_NAME() + new CommonUtils().getCurrentDate();
		
		DBProcedures.PCOPK_SYS_VARS(CommonUtils.getConnection());
	}
	/*
	 * 
	 */
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
	 * @param PT_IL_HIBAH_FEE_PRCSS_BEAN
	 */
	public void whenCreateRecord(PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN){
		PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_PRCSS_YN("N");
	}
	
	/**
	 * 
	 * @param PT_IL_HIBAH_FEE_PRCSS_BEAN
	 * @param CTRL_BEAN
	 * @throws Exception
	 */
	public void preInsert(PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN,CTRL CTRL_BEAN) throws Exception{
		String C1 = "SELECT P9IL_HFP_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		try{
			Connection connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection);
			if(C1_REC.next()){
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_SYS_ID(C1_REC.getLong(1));
			}
			
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_CR_UID(CTRL_BEAN.getUI_M_USER_ID());
			PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_CR_DT(new CommonUtils().getCurrentDate());
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void whenNewBlockInstance(PILP086_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PILT086_APAC_Procedure.getInstance().L_INS_POL_HIBAH_PRCSS(compositeAction.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN());
/*		L_INS_POL_HIBAH_PRCSS;
		EXECUTE_QUERY;
		:SYSTEM.MESSAGE_LEVEL := '0';   */
	}
	
	/**
	 * 
	 * @param CTRL_BEAN
	 */
	public void preBlock(CTRL CTRL_BEAN){
		CTRL_BEAN.setUI_M_COMM_DEL("Y");
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public boolean processButtonPressed(PILP086_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String C1 = "SELECT HFP_POL_NO,HFP_SYS_ID FROM PT_IL_HIBAH_FEE_PRCSS "
				+ "WHERE HFP_PRCSS_YN='Y' AND NVL(HFP_ACNT_YN,'N') = 'N' AND "
				+ "HFP_POL_NO BETWEEN ? AND ? ";
		
		String C2 = "SELECT 1 FROM   PT_IL_HIBAH_FEE_PRCSS "
				+ "WHERE  HFP_POL_NO=? AND    HFP_PRCSS_YN='Y' "
				+ "AND    HFP_SYS_ID<> ? ";
		boolean valid = false;
		DUMMY1 DUMMY1_BEAN = compositeAction.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN(); 
		
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		try{
			Connection connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY1_BEAN.getHFH_POL_NO_FM(),DUMMY1_BEAN.getHFH_POL_NO_TO()});
			while(C1_REC.next()){
				String HFP_POL_NO = C1_REC.getString("HFP_POL_NO");
				Long HFP_SYS_ID = C1_REC.getLong("HFP_SYS_ID");
				Date HFH_DATE_FM = DUMMY1_BEAN.getHFH_DATE_FM();
				
				log.info("==========>Policy Number=======>"+HFP_POL_NO);
				log.info("==========>HFP_SYS_ID=======>"+HFP_SYS_ID);
				log.info("==========>HFH_DATE_FM=======>"+HFH_DATE_FM);
				
				new P9ILPK_CLAIM().P_HIBAH_FEE_PRCSS(HFP_POL_NO, 
														CommonUtils.getProcedureValue(HFP_SYS_ID), 
														CommonUtils.getProcedureValue(HFH_DATE_FM), 
														"C");
				valid = true;
				}
			log.info("===============>Hibah Process Done Successfully============>");
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
		return valid;
	}
}
