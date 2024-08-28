package com.iii.pel.forms.PILM023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_IL_CODES_ACCOUNT_SETUP_HELPER {
	
	public void pilm023_pm_il_codes_account_setup_cacs_src_bus_fm_when_validate_item(){
	}
       
       
	
	public  void pilm023_pm_il_codes_account_setup_cacs_src_bus_to_when_validate_item(){
	}
        
        
	 public void validateCACS_SETUP(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws Exception{
	       
		 	ResultSet resultSet=null;
		 	CRUDHandler handler=new CRUDHandler();
		 	DBProcedures procedures=new DBProcedures();
		 	Connection connection=CommonUtils.getConnection();
		 	PM_IL_CODES_ACCOUNT_SETUP accountSetup=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
		 	String cacsSetupType=accountSetup.getCACS_SETUP_TYPE();

		 	String   M_CODE_DESC=null;
		 	String   M_VALUE=null;
		 	String   M_DESC=null;

		 	try{
		 		if(cacsSetupType!=null){
		 			String sql_C1= "SELECT PS_CODE_DESC FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_MISC_SET'  AND PS_CODE  = ? "; 
		 			Object[] objects={cacsSetupType};
		 			resultSet=handler.executeSelectStatement(sql_C1, connection, objects);
			
		 			ArrayList<String> valSystemList=DBProcedures.P_VAL_SYSTEM("IL_MISC_SET",cacsSetupType, null,"E", null);
			            
		 			if(valSystemList!=null && valSystemList.size()!=0){
		 				M_CODE_DESC=valSystemList.get(0);
		 				M_VALUE=valSystemList.get(1);
		 			}

		 			if(Integer.parseInt(M_VALUE)==1){
		 			    	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE().setDisabled(false);
			            	accountSetupAction.getCOMP_CACS_TYPE_TO_CODE().setDisabled(false);
		 			}else{
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE().setDisabled(true);
		 				accountSetupAction.getCOMP_CACS_TYPE_TO_CODE().setDisabled(true);
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE().setSubmittedValue(null);
		 				accountSetupAction.getCOMP_CACS_TYPE_TO_CODE().setSubmittedValue(null);
		 			}
			        
		 			if(resultSet.next()){
		 				M_DESC=resultSet.getString(1);
		 			}
		 			
		 			accountSetupAction.getCOMP_CACS_YRS_FM_LABEL().setValue(M_DESC+" "+"Years Fm");

		 			if(cacsSetupType.equals("D")){
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Discount Range");
		 			}else if(cacsSetupType.equals("C")){
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Charges Range");
		 			}else if(cacsSetupType.equals("B")){
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Commision Range");
		 			}else if(cacsSetupType.equals("T")){
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Tax Range");
		 			}else if(cacsSetupType.equals("AB")){
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Bonus Code Range");
		 			}else{
		 				accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Setup Type Range");
		 			}
			            
		 			if(cacsSetupType.equals("C")){
		 				accountSetupAction.getCOMP_CACS_SETUP_FOR().setDisabled(false);
		 			}else{
		 				accountSetupAction.getCOMP_CACS_SETUP_FOR().setDisabled(true);
		 			}
		 		}
		 	}catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
		 	
	    }
	 	
	 	/**
	 	 * Rerenders  CACS_SUB_ACNT_CODE,UI_M_SUB_ACNT_NAME,CACS_ACTY_CODE_1,
	    	  	UI_M_ACTY_NAME,CACS_ACTY_CODE_2,UI_M_ACTY_NAME_1,CACS_ACTY_CODE_1_LABEL,CACS_ACTY_CODE_2_LABEL
	 	 * @param accountSetupAction
	 	 * @throws SQLException
	 	 * @throws DBException
	 	 * @throws Exception
	 	 */
	 	public void validateCACS_MAIN_ACNT_CODE(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws Exception{
	 		ResultSet resultSet1=null;
	 		ResultSet resultSet2=null;
	 		ResultSet resultSet3=null;
	 		DBProcedures procedures=new DBProcedures();
	 		CommonUtils commonUtils=new CommonUtils();
	 		CRUDHandler crudHandler=new CRUDHandler();
	 		PM_IL_CODES_ACCOUNT_SETUP_LOCAL_PROCEDURES localProcedures=new PM_IL_CODES_ACCOUNT_SETUP_LOCAL_PROCEDURES();
	 		PM_IL_CODES_ACCOUNT_SETUP accountSetup=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	        try{
	        	Connection connection=CommonUtils.getConnection();
	            String mainAcntcode=accountSetup.getCACS_MAIN_ACNT_CODE();
	            String mActy1= null;
	            String mActy2= null ;
	            String sql_C1= "SELECT MAIN_ACTY_CODE_1, MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
	            Object[] object1={mainAcntcode};
	            String sql_C2= "SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
	            Object[] objects2={mActy1};
	            
	            String sql_C3= "SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ?  ";
	            Object[] objects3={mActy2};
	            String M_TEMP1=null;
	            String M_TEMP2=null;
	            localProcedures.L_VAL_MAIN_ACTIVITY(accountSetupAction);
	          
	            if(mainAcntcode!=null){
	            	ArrayList<String>valMainAcntNameList=procedures.P_VAL_MAIN_ACNT(mainAcntcode,"N","E");
	            	if(valMainAcntNameList!=null && valMainAcntNameList.size()!=0){
	            		accountSetup.setUI_M_MAIN_ACNT_NAME(valMainAcntNameList.get(0));
	            	}
	            	resultSet1=crudHandler.executeSelectStatement(sql_C1, connection, object1);
	            	if(resultSet1.next()){
	            		mActy1 = resultSet1.getString(1);
	            		mActy2 = resultSet1.getString(2);
	            	}
	            }
	            if(mActy1 != null){
	              resultSet2=crudHandler.executeSelectStatement(sql_C2, connection, new Object[]{mActy1});
	                if(resultSet2.next()){
	                    M_TEMP1=resultSet2.getString(1);
	                }
	                accountSetupAction.getCOMP_CACS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
	            }
	            
	            if(mActy2 != null) {
	            	resultSet3=crudHandler.executeSelectStatement(sql_C3, connection, new Object[]{mActy2});
	            	if(resultSet3.next()){
	                    M_TEMP2=resultSet3.getString(1);
	                }
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
	            }
	           
	        }catch(Exception e){
	        	e.printStackTrace();
	        	throw new Exception(e.getMessage());
	        	
	        } 
	        finally{try {CommonUtils.closeCursor(resultSet1);CommonUtils.closeCursor(resultSet2);
	        				CommonUtils.closeCursor(resultSet3);} catch (Exception e) {}}
	    }
	 	
	 	/**
	 	 * Rerenders UI_M_SUB_ACNT_NAME
	 	 * @param accountSetupAction
	 	 * @throws SQLException
	 	 * @throws Exception
	 	 */
	 	public void validateCACS_SUB_ACNT_CODE(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws  Exception{
	 			DBProcedures procedures=new DBProcedures();
	 			PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	 			accountSetupAction.getCOMP_UI_M_SUB_ACNT_NAME().setSubmittedValue(null);
	 			String subAcntCode=accountSetupValueBean.getCACS_SUB_ACNT_CODE(); 
	 			String mainAcntCode=accountSetupValueBean.getCACS_MAIN_ACNT_CODE();
	 			try {
	 				if(subAcntCode != null && mainAcntCode!=null){
	 					ArrayList<String> subAcntNameList=procedures.P_VAL_SUB_ACNT(mainAcntCode, subAcntCode,"N","E");
	 					if(subAcntNameList!=null && subAcntNameList.size()!=0){
	 						accountSetupValueBean.setUI_M_SUB_ACNT_NAME(subAcntNameList.get(0));
	 					}
	 				}
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
	 	}
	 	
	 	/**
	 	 * Rerenders UI_M_DIVN_NAME,CACS_DIVN_CODE,CACS_DEPT_CODE,UI_M_DEPT_NAME
	 	 * @param accountSetupAction
	 	 * @throws SQLException
	 	 * @throws Exception
	 	 */
	 	public void validateCACS_DIVN_CODE(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws Exception{
	 			DBProcedures procedures=new DBProcedures();
	 			PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	 			String cacsDivnCode=accountSetupValueBean.getCACS_DIVN_CODE();
	 			String cacsForceDivnYN=accountSetupValueBean.getCACS_FORCE_DIVN_YN();
	 			String cacsDeptCode=accountSetupValueBean.getCACS_DEPT_CODE();
	 			CommonUtils commonUtils=new CommonUtils();
	            try {
	            	
	            	if(MigratingFunctions.nvl(cacsForceDivnYN,"N").equals("N")){
	            		accountSetupAction.getCOMP_CACS_DIVN_CODE().setRequired(true);
	            	}
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
	 	}
	 	
	 	
	 	
	 	  public void validateCACS_ANLY_CODE_1(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws SQLException, Exception{
 		  			PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
 		  			DBProcedures procedures=new DBProcedures();
 		  			String cacsAnlyCode1=accountSetupValueBean.getCACS_ANLY_CODE_1();
 		  			try {
 		  				if(cacsAnlyCode1 != null){
 		  					ArrayList<String> anlyNameList=procedures.P_VAL_ANLY1("1",cacsAnlyCode1,"N","E");
 		  					if(anlyNameList!=null && anlyNameList.size()!=0){
 		  						accountSetupValueBean.setUI_M_ANLY_NAME(anlyNameList.get(0));
 		  					}
 		  				}
 		  				if(cacsAnlyCode1!=null){
 		  					accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setDisabled(false);
 		  				}else{
 		  					accountSetupAction.getCOMP_CACS_ACTY_CODE_2().setDisabled(true);
 		  				}
						
					} catch (Exception e) {
						e.printStackTrace();
						throw new Exception(e.getMessage());
					}
	 	  }
	 	            
	 	           
	 	  
	 	 public void validateCACS_ANLY_CODE_2(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws SQLException, Exception{
	 		 	PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	 			DBProcedures procedures=new DBProcedures();
	 			accountSetupValueBean.setUI_M_ANLY_NAME_1(null);
	 			String cacsAnlyCode2=accountSetupValueBean.getCACS_ANLY_CODE_2();
	 			try {
	 				if(cacsAnlyCode2 != null){
	 					ArrayList<String> anlyName1DescList=procedures.P_VAL_ANLY1("2",cacsAnlyCode2, "N","E");
	 					if(anlyName1DescList!=null && anlyName1DescList.size()!=0){
	 						accountSetupValueBean.setUI_M_ANLY_NAME_1(anlyName1DescList.get(0));
	 					}
	 				}
	 				
	 				String cacsAnlyCode1=accountSetupValueBean.getCACS_ACTY_CODE_1();
	 				if(cacsAnlyCode1!=null){
	 					accountSetupAction.getCOMP_CACS_ANLY_CODE_2().setReadonly(false);
	 				}else{
	 					accountSetupAction.getCOMP_CACS_ANLY_CODE_2().setReadonly(true);
	 				}
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
	     }
	 	 
	 	public void validateCACS_ACTY_CODE_1(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws SQLException, Exception{
	 		PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	 		DBProcedures procedures=new DBProcedures();
	 		String cacsActyCode1=accountSetupValueBean.getCACS_ACTY_CODE_1();
	 		String anlyHeadNo=accountSetupValueBean.getUI_M_ACTY_1();
	 		try {
	 			if(cacsActyCode1!= null){ // anlyHeadNo!=null){
	 				ArrayList<String> actyNameList=procedures.P_VAL_ACTY("TIC",cacsActyCode1, "N","E");
	 				if(actyNameList!=null && actyNameList.size()!=0){
	 					accountSetupValueBean.setUI_M_ACTY_NAME(actyNameList.get(0));
	 				}
	 			}
	 				
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 			throw new Exception(e.getMessage());
	 		}
	 	}

	            		
	        
	 	
	 	public void Validatecacs_acty_code_2(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws Exception{
				PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
				DBProcedures procedures=new DBProcedures();
				String cacsActyCode2=accountSetupValueBean.getCACS_ACTY_CODE_2();
				String anlyHeadNo=accountSetupValueBean.getUI_M_ACTY_2();
				try{
				if(cacsActyCode2!= null && anlyHeadNo!=null){
					ArrayList<String> actyNameList=procedures.P_VAL_ACTY(anlyHeadNo,cacsActyCode2, "N","E");
					if(actyNameList!=null && actyNameList.size()!=0){
						accountSetupValueBean.setUI_M_ACTY_NAME_1(actyNameList.get(0));
					}
				}
				}catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
	 	}
				
	private void checkDuplicate(PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			Connection connection = CommonUtils.getConnection();
			String sql_C1 = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_DUPLICATE_CHECK;

			String CACS_BUS_FM_CODE = accountSetupValueBean
					.getCACS_BUS_FM_CODE();
			String CACS_BUS_TO_CODE = accountSetupValueBean
					.getCACS_BUS_TO_CODE();
			String CACS_DIVN_FM_CODE = accountSetupValueBean
					.getCACS_DIVN_FM_CODE();
			String CACS_DIVN_TO_CODE = accountSetupValueBean
					.getCACS_DIVN_TO_CODE();
			String CACS_DEPT_FM_CODE = accountSetupValueBean
					.getCACS_DEPT_FM_CODE();
			String CACS_DEPT_TO_CODE = accountSetupValueBean
					.getCACS_DEPT_TO_CODE();
			String CACS_DOC_FM_TYPE = accountSetupValueBean
					.getCACS_DOC_FM_TYPE();
			String CACS_DOC_TO_TYPE = accountSetupValueBean
					.getCACS_DOC_TO_TYPE();
			String CACS_SETUP_TYPE = accountSetupValueBean.getCACS_SETUP_TYPE();
			String CACS_SETUP_FOR = accountSetupValueBean.getCACS_SETUP_FOR();
			String CACS_TYPE_FM_CODE = accountSetupValueBean
					.getCACS_TYPE_FM_CODE();
			String CACS_TYPE_TO_CODE = accountSetupValueBean
					.getCACS_TYPE_TO_CODE();
			Integer CACS_YRS_FM = accountSetupValueBean.getCACS_YRS_FM();
			Integer CACS_YRS_TO = accountSetupValueBean.getCACS_YRS_TO();
			String CACS_SRC_BUS_FM = accountSetupValueBean.getCACS_SRC_BUS_FM();
			String CACS_SRC_BUS_TO = accountSetupValueBean.getCACS_SRC_BUS_TO();
			String CACS_CUST_CLS_FM_CODE = accountSetupValueBean
					.getCACS_CUST_CLS_FM_CODE();
			String CACS_CUST_CLS_TO_CODE = accountSetupValueBean
					.getCACS_CUST_CLS_TO_CODE();
			String CACS_PROD_CODE_FM = accountSetupValueBean
					.getCACS_PROD_CODE_FM();
			String CACS_PROD_CODE_TO = accountSetupValueBean
					.getCACS_PROD_CODE_TO();
			String CACS_COVER_CODE_FM = accountSetupValueBean
					.getCACS_COVER_CODE_FM();
			String CACS_COVER_CODE_TO = accountSetupValueBean
					.getCACS_COVER_CODE_TO();
			String CACS_ASSURED_TYPE = accountSetupValueBean
					.getCACS_ASSURED_TYPE();
			String CACS_FIRST_PREM_YN = accountSetupValueBean
					.getCACS_FIRST_PREM_YN();

			Object[] objects = { CACS_BUS_FM_CODE, CACS_BUS_TO_CODE,
					CACS_BUS_FM_CODE, CACS_BUS_TO_CODE, CACS_BUS_FM_CODE,
					CACS_BUS_TO_CODE, CACS_DIVN_FM_CODE, CACS_DIVN_TO_CODE,
					CACS_DIVN_FM_CODE, CACS_DIVN_TO_CODE, CACS_DIVN_FM_CODE,
					CACS_DIVN_TO_CODE, CACS_DEPT_FM_CODE, CACS_DEPT_TO_CODE,
					CACS_DEPT_FM_CODE, CACS_DEPT_TO_CODE, CACS_DEPT_FM_CODE,
					CACS_DEPT_TO_CODE, CACS_DOC_FM_TYPE, CACS_DOC_TO_TYPE,
					CACS_DOC_FM_TYPE, CACS_DOC_TO_TYPE, CACS_DOC_FM_TYPE,
					CACS_DOC_TO_TYPE, CACS_SETUP_TYPE, CACS_SETUP_FOR,
					CACS_TYPE_FM_CODE, CACS_TYPE_TO_CODE, CACS_TYPE_FM_CODE,
					CACS_TYPE_TO_CODE, CACS_TYPE_FM_CODE, CACS_TYPE_TO_CODE,
					CACS_YRS_FM, CACS_YRS_TO, CACS_YRS_FM, CACS_YRS_TO,
					CACS_YRS_FM, CACS_YRS_TO, CACS_SRC_BUS_FM, CACS_SRC_BUS_TO,
					CACS_SRC_BUS_FM, CACS_SRC_BUS_TO, CACS_SRC_BUS_FM,
					CACS_SRC_BUS_TO, CACS_CUST_CLS_FM_CODE,
					CACS_CUST_CLS_TO_CODE, CACS_CUST_CLS_FM_CODE,
					CACS_CUST_CLS_TO_CODE, CACS_CUST_CLS_FM_CODE,
					CACS_CUST_CLS_TO_CODE, CACS_PROD_CODE_FM,
					CACS_PROD_CODE_TO, CACS_PROD_CODE_FM, CACS_PROD_CODE_TO,
					CACS_PROD_CODE_FM, CACS_PROD_CODE_TO, CACS_COVER_CODE_FM,
					CACS_COVER_CODE_TO, CACS_COVER_CODE_FM, CACS_COVER_CODE_TO,
					CACS_COVER_CODE_FM, CACS_COVER_CODE_TO, CACS_ASSURED_TYPE,
					CACS_FIRST_PREM_YN };
			String M_DUMMY = null;
			resultSet = handler.executeSelectStatement(sql_C1, connection,
					objects);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);
				if (CommonUtils.isDuplicate(accountSetupValueBean.getROWID(),
						M_DUMMY)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80031"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}
	 	
	public void pilm023_pm_il_codes_account_setup_pre_insert(
			PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction)
			throws Exception {
		PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean = accountSetupAction
				.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();

		try {
			checkDuplicate(accountSetupValueBean);
			accountSetupValueBean.setCACS_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			accountSetupValueBean.setCACS_CR_DT(new CommonUtils()
					.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	 	            
	 	            
	 	 
	 public void pilm023_pm_il_codes_account_setup_pre_update(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws Exception{
		PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();

		try {
			checkDuplicate(accountSetupValueBean);
			accountSetupValueBean.setCACS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			accountSetupValueBean.setCACS_UPD_DT(new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
 	}	
	 	
	 	
	 	
	 	 public void pilm023_pm_il_codes_account_setup_when_create_record(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws SQLException,Exception{
	 		PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	        
	 		accountSetupValueBean.setCACS_SETUP_TYPE("C");
	 		accountSetupValueBean.setCACS_FORCE_DIVN_YN("N");
	 		accountSetupValueBean.setCACS_FORCE_DIVN_YN("N");
	 		accountSetupValueBean.setCACS_SETUP_FOR("M");
	 		accountSetupValueBean.setCACS_ASSURED_TYPE("R");
	 		accountSetupValueBean.setCACS_FIRST_PREM_YN("N");
	 		accountSetupAction.getCOMP_CACS_DIVN_CODE().setRequired(true);
	 		accountSetupAction.getCOMP_CACS_DEPT_CODE().setRequired(true);
	 		accountSetupAction.getCOMP_CACS_FORCE_DEPT_YN().setDisabled(true);
	 	 }
	         
	         
	 	 
	 	public void WHEN_NEW_RECORD_INSTANCE(PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction) throws Exception{
	 		PM_IL_CODES_ACCOUNT_SETUP accountSetupValueBean=accountSetupAction.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
	        ResultSet resultSet1=null;
	        ResultSet resultSet2=null;
	        ResultSet resultSet3=null;
	        ResultSet resultSet4=null;
	        String   M_TEMP1=null;
	        String   M_TEMP2=null;
	        String   M_DESC=null;
	        int   M_VALUE=-1;
	        CRUDHandler handler=new CRUDHandler();
	        CommonUtils commonUtils=new CommonUtils();
	        String sqlQuery1="SELECT    MAIN_ACTY_CODE_1,    MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
	        String sqlQuery2="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
	        String sqlQuery3="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
	        String sqlQuery4="SELECT    PS_CODE_DESC,    PS_VALUE FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_MISC_SET'   AND PS_CODE  = ? ";
	        try{
	        	Connection connection=CommonUtils.getConnection();
	        	String mainAcntCode=accountSetupValueBean.getCACS_MAIN_ACNT_CODE();
	        	String setupType=accountSetupValueBean.getCACS_SETUP_TYPE();
	        	String uiMActy1=accountSetupValueBean.getUI_M_ACTY_1();
	        	String uiMActy2=accountSetupValueBean.getUI_M_ACTY_2();

	        	Object[] objects1={mainAcntCode};
	        	Object[] objects2={uiMActy1};
	        	Object[] objects3={uiMActy2};
	        	Object[] objects4={setupType};
	        	
	        	if(setupType!=null){
	            	if(setupType.equals("C")){
	            		accountSetupAction.getCOMP_CACS_SETUP_FOR().setDisabled(false);
	            	}else{
	            		accountSetupAction.getCOMP_CACS_SETUP_FOR().setDisabled(true);
	            	}
	        	}
	            		

	            if(accountSetupValueBean.getCACS_SETUP_TYPE().equals("D") ){
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Discount range");
	            }else if(accountSetupValueBean.getCACS_SETUP_TYPE().equals("C")){
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Charges range");
	            }else if(accountSetupValueBean.getCACS_SETUP_TYPE().equals("B")){
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Commission range");
	            }else if(accountSetupValueBean.getCACS_SETUP_TYPE().equals("T")){
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Tax range");
	            }else if(accountSetupValueBean.getCACS_SETUP_TYPE().equals("AB")){
	        	   accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Bonus Code Range");
	            }else{
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE_LABEL().setValue("Setup type range");
	            }


	            if(mainAcntCode!=null){
	            	resultSet1=handler.executeSelectStatement(sqlQuery1, connection, objects1);
	            	if(resultSet1.next()){
	            		uiMActy1 = resultSet1.getString(1);
	            		uiMActy2 = resultSet1.getString(2);
	            	}
	            }
	            
	            
	            if(uiMActy1 != null){
	            	resultSet2=handler.executeSelectStatement(sqlQuery2, connection, objects2);
	            	if(resultSet2.next()){
	            		M_TEMP1=resultSet2.getString(1);
	            	}
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
	            }else{
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_1_LABEL().setValue("Activity code1");
	            }
	           
	            
	            if(uiMActy2 != null){
	            	resultSet3=handler.executeSelectStatement(sqlQuery3, connection, objects3);
	            	if(resultSet3.next()){
	            		M_TEMP2=resultSet3.getString(1);
	            	}
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
	            }else{
	            	accountSetupAction.getCOMP_CACS_ACTY_CODE_2_LABEL().setValue("Activity Code2");
	            }
	            
	            if(setupType!=null){
	            	resultSet4=handler.executeSelectStatement(sqlQuery4, connection, objects4);
	            	if(resultSet4.next()){
	            		M_DESC=resultSet4.getString(1);
	            		M_VALUE=resultSet4.getInt(2);
	            	}
	            	accountSetupAction.getCOMP_CACS_YRS_FM_LABEL().setValue(M_DESC+" "+"Years Fm");
	            }
	          	            
	            if(M_VALUE==1){
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE().setDisabled(false);
	            	accountSetupAction.getCOMP_CACS_TYPE_TO_CODE().setDisabled(false);
	            }else{
	            	accountSetupAction.getCOMP_CACS_TYPE_FM_CODE().setDisabled(true);
	            	accountSetupAction.getCOMP_CACS_TYPE_TO_CODE().setDisabled(true);
	            }
	               
	           
	            accountSetupAction.getCOMP_CACS_FORCE_DEPT_YN().setDisabled(true);
	            String cacsForceDeptYN=accountSetupValueBean.getCACS_FORCE_DEPT_YN();
	            String cacsForceDivnYN=accountSetupValueBean.getCACS_FORCE_DIVN_YN();

	            
	            if(MigratingFunctions.nvl(cacsForceDivnYN,"N").equals("Y")){
	            	accountSetupAction.getCOMP_CACS_DIVN_CODE().setDisabled(true);
	            	accountSetupAction.getCOMP_CACS_DIVN_CODE().setRequired(false);
	            }
	               

	            if(MigratingFunctions.nvl(cacsForceDivnYN,"N").equals("N")){
	            	accountSetupAction.getCOMP_CACS_DIVN_CODE().setDisabled(false);
	            	accountSetupAction.getCOMP_CACS_DIVN_CODE().setRequired(true);
	            }
	                

	            if(MigratingFunctions.nvl(cacsForceDeptYN,"N").equals("Y")){
	            	accountSetupAction.getCOMP_CACS_DEPT_CODE().setDisabled(true);
	            	accountSetupAction.getCOMP_CACS_DEPT_CODE().setRequired(false);
	            }
	            
	            if(MigratingFunctions.nvl(cacsForceDeptYN,"N").equals("N")){
	            	accountSetupAction.getCOMP_CACS_DEPT_CODE().setDisabled(false);
	            	accountSetupAction.getCOMP_CACS_DEPT_CODE().setRequired(true);
	            }
	            
	        }catch(SQLException exception){
	        	exception.printStackTrace();
	        	throw new Exception(exception.getMessage());
	        }catch(DBException exception){
	        	exception.printStackTrace();
	        	throw new Exception(exception.getMessage());
	        }
	        finally{try {CommonUtils.closeCursor(resultSet1);CommonUtils.closeCursor(resultSet2);
					CommonUtils.closeCursor(resultSet3);CommonUtils.closeCursor(resultSet4);} catch (Exception e) {}
	        }
	    }
}
