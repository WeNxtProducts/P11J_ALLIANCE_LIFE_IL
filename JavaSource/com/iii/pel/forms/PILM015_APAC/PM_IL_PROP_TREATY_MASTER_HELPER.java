package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
public class PM_IL_PROP_TREATY_MASTER_HELPER {
	
	/**
	 * When-Validate-Item For PT_TREATY_CODE
	 * @param compositeAction
	 * @throws Exception 
	 * @throws Exception
	 */
	public void pilm015_apac_pm_il_prop_treaty_pt_treaty_code_when_validate_item(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
        PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
        									getPM_IL_PROP_TREATY_BEAN();
        try{
        	String description = new PM_IL_PROP_TREATY_MASTER_DELEGATE().getTreatyCodeDesc(compositeAction.getPM_IL_PROP_TREATY_ACTION().getCOMP_PT_TREATY_CODE().getSubmittedValue().toString());
        	compositeAction.getPM_IL_PROP_TREATY_ACTION().getCOMP_PT_TREATY_DESC().setSubmittedValue(description);
        	
        }catch(Exception e){
        	e.printStackTrace();
        	throw new Exception(e.getMessage());
        }
    }
	
	 /**
	  * When-Validate-Item for PT_UW_YEAR
	  * @param compositeAction
	 * @throws Exception 
	  * @throws Exception
	  */
	public void pilm015_apac_pm_il_prop_treaty_pt_uw_year_when_validate_item
	 		(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		
		 	PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
		 													getPM_IL_PROP_TREATY_BEAN();
		 	PM_IL_PROP_TREATY_ACTION treatyActionBean=compositeAction.
		 											getPM_IL_PROP_TREATY_ACTION();
	      	DBProcedures procedures=new DBProcedures();
	      	CommonUtils commonUtils=new CommonUtils();
	        	int uwYear=treatyValueBean.getPT_UW_YEAR();
	        	try{
	        		procedures.callP_VAL_UWYEAR(uwYear+"");
	        	}catch(SQLException e){
	        		e.printStackTrace();
	        		throw new Exception(commonUtils.getErrorMessageForException(e));
	        	} catch (Exception e) {
	        		e.printStackTrace();
	        		throw new Exception(e.getMessage());
				}
	    }
	/**
	 * WHEN-VALIDATE-ITEM FOR PT_START_DT
	 * @param compositeAction
	 * @throws Exception 
	 * @throws ParseException 
	 * @throws Exception
	 */
	 public void pilm015_apac_pm_il_prop_treaty_pt_start_dt_when_validate_item
	 			(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		 try{
			PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
														getPM_IL_PROP_TREATY_BEAN();
			PM_IL_PROP_TREATY_ACTION treatyActionBean=compositeAction.
				getPM_IL_PROP_TREATY_ACTION();
			Date ptStartDt=  treatyValueBean.getPT_START_DT() ;
			Calendar cal=Calendar.getInstance();
			cal.setTime(ptStartDt);
			double year=cal.get(Calendar.YEAR);
			double ptuwYear=Double.parseDouble(treatyActionBean.getCOMP_PT_UW_YEAR()
													.getValue().toString());
		    if(year!=ptuwYear)
		    {
		    	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71137"));
		    }
		    cal.add(Calendar.MONTH, 12);
		    cal.add(Calendar.DAY_OF_YEAR, -1);
		    Date ptEndDt=cal.getTime();
		    treatyActionBean.getCOMP_PT_END_DT().setSubmittedValue(ptEndDt) ;        
		    treatyValueBean.setPT_END_DT(ptEndDt);
		    if(ptStartDt != null)
		    {
		    	if(ptStartDt.after(ptEndDt)){
		    		throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", new Object[]{"START DATE","<=","END DATE"}));
		    	}
		    }
		 }catch(Exception e){
			 e.printStackTrace();
			 throw new Exception(e.getMessage());
		 }
   
	    }
	 
	 /**
	  * WHEN-VALIDATE-ITEM FOR PT_CLASS_CODE
	  * @param compositeAction
	 * @throws Exception 
	  * @throws SQLException
	  * @throws Exception
	  */
	 public void whenValidateTriggerPTCLASSCODE
	 			(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception  {
		 
		 PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
												getPM_IL_PROP_TREATY_BEAN();
		 PM_IL_PROP_TREATY_ACTION treatyActionBean=compositeAction.getPM_IL_PROP_TREATY_ACTION();
		 String ptClassCode=treatyValueBean.getPT_CLASS_CODE();
		 DBProcedures procedures=new DBProcedures();
		 ArrayList<OracleParameter> ptClassCodeDescList=null;
		 Connection connection = null;
		 try{
			 connection = CommonUtils.getConnection();
			 ptClassCodeDescList=new LIFELIB().P_VAL_CLASS(ptClassCode, null,
					 PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_P_NAME_FLAG,
					 PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_P_ERR_FLAG);
			 if(ptClassCodeDescList!=null && ptClassCodeDescList.size()!=0){
				 treatyValueBean.setUI_M_CLASS_CODE_DESC(ptClassCodeDescList.get(0).getValue());
				 compositeAction.getPM_IL_PROP_TREATY_ACTION().getCOMP_UI_M_CLASS_CODE_DESC().setSubmittedValue(ptClassCodeDescList.get(0).getValue());
			 }
			} catch (Exception e) {
				ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PT_CLASS_CODE", treatyActionBean.getErrorMap(), treatyActionBean.getWarningMap());
				String errorMessage = treatyActionBean.getErrorMap().get("current");
				if(errorMessage!=null){
					throw new Exception(errorMessage);
				}else{
					throw new Exception(e.getMessage());
				}
			}
	 }
	 
	 
	 /**
	  * WHEN-VALIDATE-ITEM FOR PT_END_DT
	  * @param compositeAction
	  * @throws SQLException
	  * @throws Exception
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_end_dt_when_validate_item
	 				(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws ValidatorException,Exception
	    {
		 
	    }
	 /**
	  * WHEN-VALIDATE-ITEM FOR PT_CURR_CODE
	 * @throws Exception 
	 * @throws Exception 
	 * @throws SQLException 
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_curr_code_when_validate_item
	 				(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		 try{
	 		PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
													getPM_IL_PROP_TREATY_BEAN();
	 		PM_IL_PROP_TREATY_ACTION treatyActionBean=compositeAction.getPM_IL_PROP_TREATY_ACTION();
	 		String pCurrCode=treatyValueBean.getPT_CURR_CODE();
            DBProcedures procedures=new DBProcedures();
            treatyActionBean.getCOMP_PT_CURR_RATE().setSubmittedValue("");
        	String description = new PM_IL_PROP_TREATY_MASTER_DELEGATE().getCurrencyCodeDesc(compositeAction.getPM_IL_PROP_TREATY_ACTION().getCOMP_PT_CURR_CODE().getSubmittedValue().toString());
        	compositeAction.getPM_IL_PROP_TREATY_ACTION().getCOMP_UI_M_CURR_DESC().setSubmittedValue(description);
        	ArrayList<String> currDescList=procedures.L_P_VAL_CURR(pCurrCode,
        			PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_P_ERR_FLAG);
            	if(currDescList!=null && currDescList.size()!=0){
            		if(currDescList.size()!=0 && currDescList!=null){
	            		treatyValueBean.setUI_M_CURR_DESC(currDescList.get(0));
	            		if(currDescList.get(1)!=null){
	            			treatyValueBean.setPT_CURR_RATE(Double.parseDouble(currDescList.get(1)));
	            			treatyActionBean.getCOMP_PT_CURR_RATE().setSubmittedValue(currDescList.get(1));
	            		}else{
	            			treatyValueBean.setPT_CURR_RATE(null);	
	            			treatyActionBean.getCOMP_PT_CURR_RATE().setSubmittedValue("");
	            		}
	            		//treatyValueBean.setPT_CURR_CODE(currDescList.get(1));
            		}	
            	}
		 	}catch(Exception e){
		 		e.printStackTrace();
		 		throw new Exception(e.getMessage());
		 	}
	  }
	 
	 /**
	  * WHEN-VALIDATE-ITEM FOR PT_CASH_CALL_LC_LIMIT
	  * @param compositeAction
	 * @throws Exception 
	  * @throws SQLException
	  * @throws Exception
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_cash_call_lc_limit_when_validate_item
	 				(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception  {
		 try{	
		 	PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
	 																getPM_IL_PROP_TREATY_BEAN();
	 		PM_IL_PROP_TREATY_ACTION treatyActionBean=
	 							compositeAction.getPM_IL_PROP_TREATY_ACTION();
	 		
	 		if(treatyValueBean.getPT_CURR_RATE()!=null){
	 			double ptCurrRate=treatyValueBean.getPT_CURR_RATE();
	 			double ptCashCallLcLimit=Double.parseDouble(treatyActionBean.
	 					getCOMP_PT_CASH_CALL_LC_LIMIT().getSubmittedValue().toString());
	 			if(ptCurrRate!=0){
	 				if(ptCashCallLcLimit>=0){
	 				Double ptCashFCimit=ptCashCallLcLimit/ptCurrRate;
	 				treatyValueBean.setPT_CASH_CALL_FC_LIMIT(ptCashFCimit);
	 				treatyActionBean.getCOMP_PT_CASH_CALL_FC_LIMIT().setSubmittedValue(ptCashFCimit.toString());
	 			} 
	 			else{
                      throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "NEGETIVECHECK"));
		 			}
 				}
	 			
	 		}else{
	 			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "EXCH_RATE_VALIDATE_1001"));
	 		}
 		}catch (Exception e) {
 			e.printStackTrace();
 			throw new Exception(e.getMessage());
 		}
	       
	    }
	 
	 public void chechForNegative(double d) throws Exception{
		 
		 if(d<0){
			 
			  throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "NEGETIVECHECK"));
		 }
	 }
	 
	 
	 /**
	  * WHEN-LIST-CHANGED FOR PT_CQS_YN
	  * @param compositeAction
	 * @throws Exception 
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_cqs_yn_when_list_changed
	 						(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception 
	    {
		 try{
			 PM_IL_PROP_TREATY_ACTION treatyActionBean=compositeAction.getPM_IL_PROP_TREATY_ACTION();
			 PM_IL_PROP_TREATY treatyValueBean=treatyActionBean.getPM_IL_PROP_TREATY_BEAN();
			 String ptCqsYN=treatyValueBean.getPT_CQS_YN();
			 if(CommonUtils.nvl(ptCqsYN,PM_IL_PROP_TREATY_CONSTANTS.
	   				 PILM015_APAC_PM_IL_PROP_TREATY_PT_CQS_YN_N).equals(PM_IL_PROP_TREATY_CONSTANTS.
							 	PILM015_APAC_PM_IL_PROP_TREATY_PT_CQS_YN_Y)){
	            	treatyActionBean.getCOMP_PT_CQS_PERC().setReadonly(false);
	            }else{
	            	treatyValueBean.setPT_CQS_PERC(null);
	            	treatyActionBean.getCOMP_PT_CQS_PERC().setReadonly(true);
	            }
		 	}catch (Exception e) {
		 		e.printStackTrace();
		 		throw new Exception(e.getMessage());
		 	}
	    }
	 
	 
	 /**
	  * WHEN-VALIDATE-ITEM FOR PT_CQS_YN
	  * @param compositeAction
	 * @throws Exception 
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_cqs_yn_when_validate_item
	 				(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		 try{
			 PM_IL_PROP_TREATY_ACTION treatyActionBean = compositeAction.getPM_IL_PROP_TREATY_ACTION();
		 	 String ptCqsYN = (String)treatyActionBean.getCOMP_PT_CQS_YN().getSubmittedValue();
	            if(ptCqsYN.equals(PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PT_CQS_YN_Y)) {
	            	treatyActionBean.getCOMP_PT_CQS_PERC().setReadonly(false);
	            }else{
	            	treatyActionBean.getCOMP_PT_CQS_PERC().setSubmittedValue("");
	            	treatyActionBean.getCOMP_PT_CQS_PERC().setReadonly(true);
	            }
	    }catch (Exception e) {
	    	e.printStackTrace();
	    	throw new Exception(e.getMessage());
		}
	 }
	 
	 /**
	  * WHEN-VALIDATE-ITEM FOR PT_CQS_PERC
	  * @param compositeAction
	 * @throws Exception 
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_cqs_perc_when_validate_item(double ptCqsPerc) throws Exception{
		 try{	
            if(ptCqsPerc<0 || ptCqsPerc>100){
            	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath , "91014",
            			new Object[]{"COMPULSORY QUTO SHARE",">=0","AND <=100"}));
            	
            }
		 }catch (Exception e) {
			 e.printStackTrace();
			 throw new Exception(e.getMessage()); 
		}  
	 }
	 
	 /**
	  * WHEN-LIST-CHANGED FOR PT_RIDER_RI_BASIS
	  * COMMENTED AS THERE IS NO EQUIVALENT OF
	  * SET_TAB_PAGE_PROPERTY IN PEL
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pt_rider_ri_basis_when_list_changed(){
	    	        
	            
		/* if(:PM_IL_PROP_TREATY.PT_RIDER_RI_BASIS=="S")
     	      {
                SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("PM_IL_PROP_TREATY_TYPE_CVR",ENABLED,PROPERTY_FALSE);
            }
        else
        {
            SET_TAB_PAGE_PROPERTY.SET_TAB_PAGE_PROPERTY("PM_IL_PROP_TREATY_TYPE_CVR",ENABLED,PROPERTY_TRUE);
        }*/
	        
	 }	
	 
	 /**
	  * PRE-INSERT for PM_IL_PROP_TREATY
	 * @throws Exception 
	 * @throws SQLException 
	  * @throws SQLException
	 * @throws DBException 
	  * @throws Exception
	  */	
	 public  Double  pilm015_apac_pm_il_prop_treaty_pre_insert(
			 	PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		 	Double sysId=null;
	        ResultSet resultSet=null;
	        Connection connection=null;
	        Object[] object={};
	        CRUDHandler handler=new CRUDHandler();
	        PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
				getPM_IL_PROP_TREATY_BEAN();
	       try{
	        	connection=CommonUtils.getConnection();
	            String sysIdQuery=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            						PILM015_APAC_PM_PM_IL_PROP_TREATY_PIL_PT_SYS_ID;
	            resultSet=handler.executeSelectStatement(sysIdQuery, connection, object);
	            if(resultSet.next()){
	            	sysId=resultSet.getDouble(1);
	            }
	            L_TREATY_CODE_UNIQUE_1(treatyValueBean);
	            L_CHK_TREATY_DFN(treatyValueBean);
	       }catch(Exception ex){
	    	   throw new Exception(ex.getMessage());
	       }finally{
	    	   try {
	    	   CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
	       }	
	        return sysId;
	    }
	 
	 /**
	  * L_TREATY_CODE_UNIQUE_1 
	  * Checks whether ant duplicate Treaty Code with classCode and CQS YN exists 
	  * or not
	  * @param treatyValueBean
	 * @throws Exception 
	  * @throws DBException
	  * @throws SQLException
	  */
	 public void L_TREATY_CODE_UNIQUE_1(PM_IL_PROP_TREATY treatyValueBean) throws Exception{
	        String ptTreatyCode=treatyValueBean.getPT_TREATY_CODE();
	        String ptClassCode=treatyValueBean.getPT_CLASS_CODE();
	        String ptCqsYN=treatyValueBean.getPT_CQS_YN();
	        CRUDHandler handler=new CRUDHandler();
	        Connection connection=null;
            String sqlQuery=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            						PILM015_APAC_PM_PM_IL_PROP_TREATY_SELECT_1_FOR_TREATY_CODE;
	         ResultSet resultSet=null;
	         Object[]objects={ptTreatyCode,ptClassCode,ptCqsYN};
	       try{     
	            connection=CommonUtils.getConnection();
	            resultSet=handler.executeSelectStatement(sqlQuery, connection, objects);
	            if(resultSet.next()){
	            	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71134"));
	            }
	       }catch(SQLException sqlException){
	    	   throw new Exception(sqlException.getMessage());
	       }catch(DBException dbException){
	    	   throw new Exception(dbException.getMessage());
	       }catch(Exception ex){
	    	   throw new Exception(ex.getMessage());
	       }finally{
	    	   try {
		    	   CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
		   }
	    }
	 
	 /**
	  * L_CHK_TREATY_DFN
	  * @param treatyValueBean
	 * @throws Exception 
	  * @throws SQLException
	  * @throws DBException
	  */
	 public void L_CHK_TREATY_DFN(PM_IL_PROP_TREATY treatyValueBean) throws Exception{
        String ptClassCode=treatyValueBean.getPT_CLASS_CODE();
        Date ptStartDate=treatyValueBean.getPT_START_DT();
        Date ptEndDate=treatyValueBean.getPT_END_DT();
        Integer PT_UW_YEAR = treatyValueBean.getPT_UW_YEAR();
        String ptCqsYN=treatyValueBean.getPT_CQS_YN();
        String rowId=treatyValueBean.getROWID();
        DateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
        String ptStartDateString=format.format(ptStartDate);
        String ptEndDateString=format.format(ptEndDate);
        CRUDHandler handler=new CRUDHandler();
        ResultSet resultSet1=null;
        ResultSet resultSet2=null;
       try{ 
        	Connection connection=CommonUtils.getConnection();
            String M_DUMMY=null;
            String sqlQuery1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
            				PILM015_APAC_PM_IL_PROP_TREATY_SELECT_X_FOR_TREATY_CLASS_CODE;
            String query = "SELECT 'X' " +
            		"FROM   PM_IL_PROP_TREATY " +
            		"WHERE  PT_CLASS_CODE = ? " +
            		"AND    PT_UW_YEAR = ? " +
            		"AND    (PT_START_DT BETWEEN ? AND ? " +
            		"OR  PT_END_DT BETWEEN ? AND ? " +
            		"OR ? BETWEEN PT_START_DT AND PT_END_DT " +
            		"OR ? BETWEEN PT_START_DT AND PT_END_DT) " +
            		"AND NVL(PT_CQS_YN, 'N')  = NVL(?, 'N') ";
            Object[] objects1={ptClassCode,
            		PT_UW_YEAR,
            		ptStartDateString,ptEndDateString,
            		ptStartDateString,ptEndDateString,
            		ptStartDateString,ptEndDateString,
            		ptCqsYN};
            
            String sqlQuery2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
            		PILM015_APAC_PM_IL_PROP_TREATY_SELECT_X_FOR_TREATY_CLASS_CODE_ROW_ID;
            Object[] objects2={ptClassCode,
            			PT_UW_YEAR,
            			ptStartDateString,ptEndDateString,
            			ptStartDateString,ptEndDateString,
            			ptStartDateString,ptEndDateString,
            			ptCqsYN,rowId};
            if(treatyValueBean.getROWID()==null) {
            	resultSet1=handler.executeSelectStatement(sqlQuery1, connection, objects1);
            	if(resultSet1.next()) {
                    M_DUMMY=resultSet1.getString(1);
                    throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
                    		"91117",new Object[]{CommonUtils.getControlBean().getM_LANG_CODE(),
                    		ptClassCode,ptStartDate,ptEndDate,"CQS Y/N IS "+ptCqsYN}));
                }                
            } else {
            	resultSet2=handler.executeSelectStatement(sqlQuery2, connection, objects2);
                if(resultSet2.next()){
                    M_DUMMY=resultSet2.getString(1);
                    throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91117",
                    		new Object[]{CommonUtils.getControlBean().getM_LANG_CODE(),ptClassCode,
                    		ptStartDate,ptEndDate,"CQS Y/N IS "+ptCqsYN}));
                }
                
            }
       }catch(Exception dbException){
    	   throw new Exception(dbException.getMessage());
       }finally{
    	   try {
	    	   CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
			}try {
		    	   CommonUtils.closeCursor(resultSet2);
				} catch (Exception e) {
					e.printStackTrace();
				}
	  }
   }
	 
	 /**
	  * PRE-UPDATE FOR PM_IL_PROP_TREATY
	  * @param compositeAction
	 * @throws Exception 
	  * @throws SQLException
	  * @throws DBException
	  */
	 public void pilm015_apac_pm_il_prop_treaty_pre_update
	 					(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		 	PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
		 												getPM_IL_PROP_TREATY_BEAN();
        	try {
				L_CHK_TREATY_DFN(treatyValueBean);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	       
	    }
	 
	 /**
	  * PRE-QUERY PM_IL_PROP_TREATY
	  * @param compositeAction
	  */public  void pilm015_apac_pm_il_prop_treaty_pre_query
	 			(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction){
		 PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
											getPM_IL_PROP_TREATY_BEAN();
      		String mClassCode=CommonUtils.getGlobalVariable("M_CLASS_CODE");
      		if(treatyValueBean.getUI_M_CP_DEST_TREATY_CODE()!=null){
      			treatyValueBean.setPT_TREATY_CODE
      						(treatyValueBean.getUI_M_CP_DEST_TREATY_CODE());
      			treatyValueBean.setPT_UW_YEAR(treatyValueBean.getUI_M_CP_DEST_UW_YEAR());
      			treatyValueBean.setUI_M_CP_DEST_TREATY_CODE(null);
      			CommonUtils.setGlobalVariable("M_CLASS_CODE", null);
        }
    }
	  
	  /**
	   * PRE-BLOCK FOR PM_IL_PROP_TREATY
	   * COMMENTED AS fORM FAILURE IS NOT HANDLED IN PEL
	   */
	  /*public static void pilm015_apac-pm_il_prop_treaty--pre-block() throws SQLException,Exception
	    {
	        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
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
	        }
	    }*/
	 
	 /**
	  * POST-QUERY FOR PM_IL-PROP_TREATY
	  * SETS INSERT
	  */
	  public void pilm015_apac_pm_il_prop_treaty_post_query
	  		(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws SQLException,Exception
	    {
	        
		  PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
												getPM_IL_PROP_TREATY_BEAN();
		  PM_IL_PROP_TREATY_ACTION treatyActionBean=compositeAction.
		  									getPM_IL_PROP_TREATY_ACTION();
		  PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeActionBean=compositeAction.
		  									getPM_IL_PROP_TREATY_TYPE_ACTION();
		  PM_IL_PROP_TREATY_TYPE_CVR_ACTION treatyTypeCvrAction=compositeAction.
		  									getPM_IL_PROP_TREATY_TYPE_CVR_ACTION();
		  PM_IL_PROP_TREATY_COVER_ACTION treatyCoverAction=compositeAction.
		  									getPM_IL_PROP_TREATY_COVER_ACTION();
		  PM_IL_PROP_TREATY_PART_CUST_ACTION treatyPartCustAcion=compositeAction.
		  									getPM_IL_PROP_TREATY_PART_CUST_ACTION();
		  PM_IL_HTWT_DTL_ACTION htWtDtlAction=compositeAction.
	  										getPM_IL_HTWT_DTL_ACTION();
		  PM_IL_MED_EXAM_HDR_ACTION medExamHdrAction=compositeAction.
		  									getPM_IL_MED_EXAM_HDR_ACTION();
		  PM_IL_MED_EXAM_DTL_ACTION medExamDtlAction=compositeAction.
		  									getPM_IL_MED_EXAM_DTL_ACTION();
		  DBProcedures procedures=new DBProcedures();
		  CRUDHandler handler=new CRUDHandler();
		  Connection connection=CommonUtils.getConnection();
		  int ptUwYear=treatyValueBean.getPT_UW_YEAR();
		  String ptClassCode=treatyValueBean.getPT_CLASS_CODE();
		  ResultSet resultSet=null;
	      try{
	            String 	M_DUMMY=null;
	            int   M_PS_VALUE=-1;
	            String   M_CODE_DESC=null;
	            String sqlQuery=PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_POST_QUERY;
	            Object[] objects={ptUwYear,ptClassCode};
	            ArrayList<String> mCodeDescList=DBProcedures.P_VAL_SYSTEM(
	            		PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_POST_QUERY_P_TYPE_FOR_CODE_DESC,
	            		PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_POST_QUERY_P_CODE_FOR_CODE_DESC,
	            		PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_POST_QUERY_P_CODE_FOR_CODE_DESC,
	            		PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_E_FLAG,
	            		String.valueOf(M_PS_VALUE));
	            if(mCodeDescList!=null && mCodeDescList.size()!=0){
	            	M_PS_VALUE=Integer.parseInt(mCodeDescList.get(1));
	            }
	            resultSet=handler.executeSelectStatement(sqlQuery, connection, objects);
	            if(resultSet.next())
	            {
	                M_DUMMY=resultSet.getString(1);
	            }
	            if(M_PS_VALUE==2)
	            {
	                if(resultSet.next())
	                {
	                	treatyActionBean.setINSERT_ALLOWED(false);
	                	treatyActionBean.setUPDATE_ALLOWED(false);
	                	treatyActionBean.setDELETE_ALLOWED(false);
	                	treatyTypeActionBean.setINSERT_ALLOWED(false);
	                	treatyTypeActionBean.setUPDATE_ALLOWED(false);
	                	treatyTypeActionBean.setDELETE_ALLOWED(false);
	                	treatyTypeCvrAction.setINSERT_ALLOWED(false);
	                	treatyTypeCvrAction.setUPDATE_ALLOWED(false);
	                	treatyTypeCvrAction.setDELETE_ALLOWED(false);
	                	treatyCoverAction.setINSERT_ALLOWED(false);
	                	treatyCoverAction.setUPDATE_ALLOWED(false);
	                	treatyCoverAction.setDELETE_ALLOWED(false);
	                	treatyPartCustAcion.setINSERT_ALLOWED(false);
	                	treatyPartCustAcion.setUPDATE_ALLOWED(false);
	                	treatyPartCustAcion.setDELETE_ALLOWED(false);
	                	htWtDtlAction.setINSERT_ALLOWED(false);
	                	htWtDtlAction.setUPDATE_ALLOWED(false);
	                	htWtDtlAction.setDELETE_ALLOWED(false);
	                	medExamHdrAction.setINSERT_ALLOWED(false);
	                	medExamHdrAction.setUPDATE_ALLOWED(false);
	                	medExamHdrAction.setDELETE_ALLOWED(false);
	                	medExamDtlAction.setINSERT_ALLOWED(false);
	                	medExamDtlAction.setUPDATE_ALLOWED(false);
	                	medExamDtlAction.setDELETE_ALLOWED(false);
	                }else{
	                	treatyActionBean.setINSERT_ALLOWED(true);
	                	treatyActionBean.setUPDATE_ALLOWED(true);
	                	treatyActionBean.setDELETE_ALLOWED(true);
	                	treatyTypeActionBean.setINSERT_ALLOWED(true);
	                	treatyTypeActionBean.setUPDATE_ALLOWED(true);
	                	treatyTypeActionBean.setDELETE_ALLOWED(true);
	                	treatyTypeCvrAction.setINSERT_ALLOWED(true);
	                	treatyTypeCvrAction.setUPDATE_ALLOWED(true);
	                	treatyTypeCvrAction.setDELETE_ALLOWED(true);
	                	treatyCoverAction.setINSERT_ALLOWED(true);
	                	treatyCoverAction.setUPDATE_ALLOWED(true);
	                	treatyCoverAction.setDELETE_ALLOWED(true);
	                	treatyPartCustAcion.setINSERT_ALLOWED(true);
	                	treatyPartCustAcion.setUPDATE_ALLOWED(true);
	                	treatyPartCustAcion.setDELETE_ALLOWED(true);
	                	htWtDtlAction.setINSERT_ALLOWED(true);
	                	htWtDtlAction.setUPDATE_ALLOWED(true);
	                	htWtDtlAction.setDELETE_ALLOWED(true);
	                	medExamHdrAction.setINSERT_ALLOWED(true);
	                	medExamHdrAction.setUPDATE_ALLOWED(true);
	                	medExamHdrAction.setDELETE_ALLOWED(true);
	                	medExamDtlAction.setINSERT_ALLOWED(true);
	                	medExamDtlAction.setUPDATE_ALLOWED(true);
	                	medExamDtlAction.setDELETE_ALLOWED(true);
	                }
	            }
	            ArrayList<OracleParameter>classCodeDesc=new LIFELIB().P_VAL_CLASS(ptClassCode,null,
	            		PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
	            		PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG);
	            if(classCodeDesc!=null && classCodeDesc.size()!=0){
				            treatyValueBean.setUI_M_CLASS_CODE_DESC(classCodeDesc.get(0).getValue());
	            }
	            ArrayList<String> currCodeDesc=procedures.P_VAL_CURR
							            (treatyValueBean.getPT_CURR_CODE(),
							             PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							             PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_N_FLAG,
							             null);
	            if(currCodeDesc!=null && currCodeDesc.size()!=0){
	            	treatyValueBean.setUI_M_CURR_DESC(currCodeDesc.get(0));
	            }	
	            HtmlCommandButton COMP_BUTTON_TYPE_TTY_COVER_DETIALS = new HtmlCommandButton();
	            if("S".equals(treatyActionBean.getPM_IL_PROP_TREATY_BEAN().getPT_RIDER_RI_BASIS())) {
	            	COMP_BUTTON_TYPE_TTY_COVER_DETIALS.setDisabled(true);
	            	treatyTypeActionBean.setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(COMP_BUTTON_TYPE_TTY_COVER_DETIALS);
	   			} else {
	   				COMP_BUTTON_TYPE_TTY_COVER_DETIALS.setDisabled(false);
	   				treatyTypeActionBean.setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(COMP_BUTTON_TYPE_TTY_COVER_DETIALS);
	   			}
	        }catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
		    	   try {
			    	   CommonUtils.closeCursor(resultSet);
					} catch (Exception e) {	}
			}
	    }
	  
	  
	  /**
	   * WHEN-CREATE-RECORD TRIGGER FOR PM_IL_PROP_TREATY
	   * @param compositeAction
	 * @throws Exception 
	   * @throws SQLException
	   * @throws Exception
	   */
	  public void pilm015_apac_pm_il_prop_treaty_when_create_record
	  			(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		  try{
	  		PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION().
													getPM_IL_PROP_TREATY_BEAN();
	  		treatyValueBean.setPT_CQS_YN(
	  				PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_PT_CQS_YN_Y);
	  		treatyValueBean.setPT_RIDER_RI_BASIS(PM_IL_PROP_TREATY_CONSTANTS.
	  				PILM015_APAC_PM_IL_PROP_TREATY_PT_RIDER_RI_BASIS_S);
	  		
	  		treatyValueBean.setPT_SURR_CLAIM_YN(PM_IL_PROP_TREATY_CONSTANTS.
	  				PILM015_APAC_PM_IL_PROP_TREATY_PT_SURR_CLAIM_YN_N);
	  		treatyValueBean.setPT_REALLC_ENDT_YN(PM_IL_PROP_TREATY_CONSTANTS.
	  				PILM015_APAC_PM_IL_PROP_TREATY_PT_REALLC_ENDT_YN_Y);
    }catch(Exception e){
    	e.printStackTrace();
    	throw new Exception(e.getMessage());
    	}
	 }
	  
	  public void POST_QUERY(PM_IL_PROP_TREATY pm_il_prop_treaty)
		{
			DBProcedures procedures = new DBProcedures();
			try {
				ArrayList<String> classCodeDescriptionList = procedures.P_VAL_CLASS(pm_il_prop_treaty.getPT_CLASS_CODE(), "N", "N");
				if(!classCodeDescriptionList.isEmpty() && classCodeDescriptionList.size() > 0){
				pm_il_prop_treaty.setUI_M_CLASS_CODE_DESC(classCodeDescriptionList.get(0));
				}
				ArrayList<String> currencyCodeList = procedures.P_VAL_CURR(pm_il_prop_treaty.getPT_CURR_CODE(), "N", "N",null);
				if(!currencyCodeList.isEmpty() && currencyCodeList.size() > 0){
				pm_il_prop_treaty.setUI_M_CURR_DESC(currencyCodeList.get(0));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
