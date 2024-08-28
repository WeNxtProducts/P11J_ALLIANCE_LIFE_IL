package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROP_TREATY_CTRL_1_HELPER {
	
	
	
	
	/**
	 * Prepares Treaty Code List
	 * 
	 * @param treatyCode
	 * @param treatyCodeList
	 * @return					treatyCodeList
	 */
	 public List prepareTreatyCodeList(String treatyCode, List treatyCodeList) {

		String query = null;
		String displayrow=PM_IL_PROP_TREATY_CONSTANTS.
							PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN;
		if (PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SUGGESTION_BOX_GET_ALL.
								equalsIgnoreCase(treatyCode)) {
			
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.
							PILM015_APAC_TREATY_MASTER_SELECT_TREATY_CODE;
				Object[] object={displayrow};
				treatyCodeList = treatyLOV(query,object);

		} else {
				treatyCode=treatyCode+PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={treatyCode,displayrow};
				System.out.println("Treaty Code :"+treatyCode);
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SELECT_TREATY_CODE_LIKE;
				treatyCodeList = treatyLOV(query,object);
		}
		return treatyCodeList;
	}
	 
	 /**
		 * List returning Treaty Lov containing code and its description
		 * 
		 * @param query			String Query
		 * @return				List<PM_IL_PROP_TREATY>
		 */
		 public List<CTRL_1> treatyLOV(String query,Object[] object)
			{
			List<CTRL_1> treatyCodeList = new ArrayList<CTRL_1>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection=null;
			try
				{
				connection=CommonUtils.getConnection();
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					CTRL_1 ctrl_1_bean = new CTRL_1();
					ctrl_1_bean.setUI_M_CP_TREATY_CODE(resultSet.getString(1));
					ctrl_1_bean.setUI_M_CP_TREATY_DESC(resultSet.getString(2));
					
					treatyCodeList.add(ctrl_1_bean);
				}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return treatyCodeList;
		}
		 
		 
		 /**
			 * Returns Treaty Description for Code and codeList
			 * 
			 * @param treatyCode
			 * @param treatyCodeList
			 * @return
			 */
			 public String getTreatyDescforCode(String treatyCode,List treatyCodeList)
			 {
				Iterator iterator = treatyCodeList.iterator();
				String treatyDesc = null;
				System.out.println("Treaty COde "+treatyCode);
				System.out.println("Treaty Code List :"+treatyCodeList);
			 	while(iterator.hasNext())
			 	{
			 		CTRL_1 CTRL_1_BEAN=(CTRL_1)iterator.next();
					System.out.println("IN DESCRIPTION METHOD");
					System.out.println(CTRL_1_BEAN.getUI_M_CP_TREATY_CODE().trim());
			 		if(treatyCode.equalsIgnoreCase(CTRL_1_BEAN.getUI_M_CP_TREATY_CODE()))
			 		{
			 			treatyDesc = CTRL_1_BEAN.getUI_M_CP_TREATY_DESC();
			 			System.out.println("Treaty Description :"+treatyDesc);
					}
				}
			 	
			 	System.out.println("DEscription : "+treatyDesc);
				return treatyDesc;
			}

		public void whenValidateTreatyCode(CTRL_1 ctrl_1_bean)throws ValidatorException {
			
			//L_P_VAL_PT
			
			String ptcode=ctrl_1_bean.getUI_M_CP_TREATY_CODE();
			String P_ERR_FLAG="E";
			ResultSet resultSet1=null;
			ResultSet resultSet2=null;
			CRUDHandler handler=new CRUDHandler();
			
		    try{    
		       
					Connection connection=CommonUtils.getConnection();
		        	if(ptcode!=null){
		        		
			            String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
			            		PILM015_APAC_CTRL1_UI_M_CP_TREATY_CODE_SELECT_TREATY_DESC;
			            Object[] objects={ptcode};
			            String   M_NAME=null;
			            resultSet1=handler.executeSelectStatement(sql_C1, connection, objects);
			            if(resultSet1.next())
			            {
			                M_NAME=resultSet1.getString(1);
			                System.out.println("Description :"+M_NAME);
			                ctrl_1_bean.setUI_M_CP_TREATY_DESC(M_NAME);
			            }
			            if(resultSet1.next())
			            {
			                if(P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals ("E"))
			                {
			                    
			                	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "1009"));
			                    /*if(P_ERR_FLAG.equals(""+"E"))
			                    {
			                        throw new FORM_TRIGGER_FAILURE();
			                    }*/
			                }
			            }
			            
			            //L_VAL_CP_TREATY_YEAR
			            String sql_c2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
			            		PILM015_APAC_CTRL1_UI_M_CP_TREATY_CODE_SELECT_UW_YEAR;
			            resultSet2=handler.executeSelectStatement(sql_c2, connection, objects);
			            if(resultSet2.next()){
			            	ctrl_1_bean.setUI_M_CP_UW_YEAR(resultSet2.getInt(1));
			            	System.out.println("UW Year :"+ctrl_1_bean.getUI_M_CP_UW_YEAR());
			            }
			            if(resultSet2.next()){
			            	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71138"));
			            }
			       }
		    }catch(SQLException exception){
		    	throw new ValidatorException(new FacesMessage(exception.getMessage()));
		    } catch (DBException e) {
		    	throw new ValidatorException(new FacesMessage(e.getMessage()));
			}finally{
				try {
					CommonUtils.closeCursor(resultSet1);
					CommonUtils.closeCursor(resultSet2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}

		public void whenValidateUWYear(CTRL_1 ctrl_1_bean)throws ValidatorException {
			//L_VAL_SOURCE
			String treatyCode=ctrl_1_bean.getUI_M_CP_TREATY_CODE();
			int uwYear=ctrl_1_bean.getUI_M_CP_UW_YEAR();
			String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_CTRL1_M_CP_UW_YEAR_SELECT_FOR_TREATY_CODE_AND_YEAR;
            ResultSet resultSet=null;
			CRUDHandler handler=new CRUDHandler();
			try{
					Object[] objects={treatyCode,uwYear};
					Connection connection=CommonUtils.getConnection();
		            double M_TEMP=-1;
		            resultSet=handler.executeSelectStatement(sql_C1, connection , objects);
		            if(resultSet.next())
		            {
		                M_TEMP=resultSet.getDouble(1);
		            }else	            
		            {
		               /* STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE("71138",:CTRL.M_LANG_CODE);
		                throw new FORM_TRIGGER_FAILURE();*/
		            	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71138"));
		            }
			}catch(SQLException sqlException){
				throw new ValidatorException(new FacesMessage(sqlException.getMessage()));
			} catch (DBException e) {
				
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}

		public void whenValidateDestUWYear(CTRL_1 ctrl_1_bean,PM_IL_PROP_TREATY treatyValueBean) throws SQLException, Exception {
			
			DBProcedures procedures=new DBProcedures();
			int uwyear=ctrl_1_bean.getUI_M_CP_DEST_UW_YEAR();
			if(uwyear!=0 && uwyear>0){
				
				procedures.callP_VAL_UWYEAR(uwyear+"");
				L_CP_CODE_UNIQUE(ctrl_1_bean,treatyValueBean);
			}
			
		}
		
		public void L_CP_CODE_UNIQUE(CTRL_1 ctrl_1_bean,PM_IL_PROP_TREATY treatyValueBean) 
	    {
			ResultSet resultSet=null;
			CRUDHandler handler=new CRUDHandler();
			System.out.println(" in L_CP_CODE_UNIQUE");
	        try
	        {
	            Connection connection=CommonUtils.getConnection();
	            String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            		PILM015_APAC_CTRL1_M_CP_DEST_UW_YEAR_SELECT_1_FOR_TREATY_CODE_YEAR_CQSYN_CLASS_CODE;
	            String treatyCode=ctrl_1_bean.getUI_M_CP_DEST_TREATY_CODE();
	            int uwYear=ctrl_1_bean.getUI_M_CP_DEST_UW_YEAR();
	            String cqsYn=treatyValueBean.getPT_CQS_YN();
	            String classCode=treatyValueBean.getPT_CLASS_CODE();
	            
	            Object[] objetcs={treatyCode,uwYear,cqsYn,classCode};
	            /*"SELECT 1 FROM  PM_IL_PROP_TREATY  WHERE  PT_TREATY_CODE" +
            		"  = :CTRL_1.M_CP_DEST_TREATY_CODE  AND PT_UW_YEAR  = :CTRL_1.M_CP_DEST_UW_YEAR " +
            		" AND PT_CQS_YN  = :PM_IL_PROP_TREATY.PT_CQS_YN  AND PT_CLASS_CODE  =" +
            		" :PM_IL_PROP_TREATY.PT_CLASS_CODE ";*/
	            
	            double M_TREATY_DESC=-1;
	            resultSet=handler.executeSelectStatement(sql_C1, connection, objetcs);
	            if(resultSet.next())
	            {
	                M_TREATY_DESC=resultSet.getDouble(1);
	                System.out.println("M_TREATY_DESC :"+M_TREATY_DESC);
	            }
	            if(resultSet.next())
	            {
	               /* STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE("71134",:CTRL.M_LANG_CODE);
	                vembu_C1.close();
	                throw new FORM_TRIGGER_FAILURE();*/
	            	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71134"));
	            }
	            
	        }catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	            throw new ValidatorException(new FacesMessage(sqle.getMessage()));
	        } catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	        finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    }
		
		
		public String pilm015_apac_ctrl_1_m_but_ok_when_button_pressed
				(CTRL_1 ctrl_1_bean, PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) 
	    {
	        	/*ResultSet resultSet=null;
	            String M_TREATY_CODE=null;*/
	            String destTreatyCode=ctrl_1_bean.getUI_M_CP_DEST_TREATY_CODE();
	            PM_IL_PROP_TREATY treatyValueBean=compositeAction.
	            									getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
	           /* CommonUtils commonUtils=new CommonUtils();
	            CRUDHandler handler=new CRUDHandler();
	            Connection connection=CommonUtils.getConnection();*/
	            int destUWYear=ctrl_1_bean.getUI_M_CP_DEST_UW_YEAR();
	            if(destTreatyCode== null || destUWYear== 0)
	            {
	                //STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,"TREATY CODE AND UW YEAR","ENTERED");
	                
	            	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91014", new Object[]{"TREATY CODE AND UW YEAR","ENTERED"}));
	            	
	            }
	           
	            DBProcedures procedure=new DBProcedures();
	            String pClassCode=treatyValueBean.getPT_CLASS_CODE();
	            String cpTreatyCode=ctrl_1_bean.getUI_M_CP_TREATY_CODE();
	            int cpUWYear=ctrl_1_bean.getUI_M_CP_UW_YEAR();
	            String cqsYN=treatyValueBean.getPT_CQS_YN();
	            
	            String treatycode=L_COPY_TREATY_DTLS(compositeAction);
	            
	            /*ArrayList<String> copyList=procedure.helperPR_COPY_TREATY_DTLS(pClassCode, cpTreatyCode, cpUWYear+"", cqsYN);
	            if(copyList!=null && copyList.size()!=0){
	            	CommonUtils.setGlobalVariable("M_CLASS_CODE", copyList.get(0));
	                
	            	String selectPtTreatyCode="SELECT PT_TREATY_CODE FROM PM_IL_PROP_TREATY WHERE PT_SYS_ID=? ";
	            	Object[] objects={copyList.get(1)};
	            	resultSet=handler.executeSelectStatement(selectPtTreatyCode, connection, objects);
	            	if(resultSet.next()){
	            		System.out.println(" Treaty code :"+resultSet.getString(1));
	            		new SearchValueBean().prepareTreatyMasterDetails(resultSet.getString(1));
	            	}
	            	
	            	System.out.println(" Sys Id :"+copyList.get(1));
	            }*/
	            
	        return treatycode;
	        
	    }
		
		
		public String L_COPY_TREATY_DTLS
		(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws ValidatorException
		{




			String M_PT_SYS_ID=null;
			String M_PTT_SYS_ID=null;
			String M_PTR_SYS_ID=null;
			String M_PTC_SYS_ID=null;
			String M_PTPC_SYS_ID=null;
			Double M_TEMP_PTT_SID=null;
			String M_TEMP_PTC_SID=null;
			String M_PTTC_SYS_ID=null;
			String M_PTTC_COVER_CODE=null;
			String M_PTTC_PERC=null;
			String M_PTG_SYS_ID=null;
			String returnTreatycode=null;

			ResultSet resultSet1=null;
			ResultSet resultSet2=null;
			ResultSet resultSet3=null;
			ResultSet resultSet4=null;
			ResultSet resultSet5=null;
			ResultSet resultSet6=null;
			ResultSet resultSet7=null;
			ResultSet resultSet8=null;
			ResultSet resultSet9=null;
			ResultSet resultSet10=null;
			ResultSet resultSet11=null;
			ResultSet resultSet12=null;
			ResultSet resultSet13=null;
			CommonUtils commonUtils=new CommonUtils();
			CRUDHandler handler=new CRUDHandler();

			PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN();
			CTRL_1 ctrl_1_bean=compositeAction.getCTRL_1_ACTION().getCTRL_1_BEAN();

			String cpTreatyCode=ctrl_1_bean.getUI_M_CP_TREATY_CODE();
			int uwYear=ctrl_1_bean.getUI_M_CP_UW_YEAR();
			String cqsYn=treatyValueBean.getPT_CQS_YN();
			String ptClassCode=treatyValueBean.getPT_CLASS_CODE();


			try
			{
				Connection connection=CommonUtils.getConnection(); 
				String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_SYSID_FOR_DETAILS;
				Object[] object1={cpTreatyCode,uwYear,cqsYn,ptClassCode};
				/*"SELECT PT_SYS_ID FROM  PM_IL_PROP_TREATY  WHERE  " +
		            		"PT_TREATY_CODE  = :CTRL_1.M_CP_TREATY_CODE  AND PT_UW_YEAR  " +
		            		"= :CTRL_1.M_CP_UW_YEAR  AND PT_CQS_YN  = :PM_IL_PROP_TREATY.PT_CQS_YN  " +
		            		"AND PT_CLASS_CODE  = :PM_IL_PROP_TREATY.PT_CLASS_CODE ";*/

				String sql_C2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FOR_SYSID;
				/*"SELECT    PTT_SYS_ID,PTT_PT_SYS_ID,PTT_SRNO,PTT_TREATY_TYPE,PTT_PROFIT_COMM," +
		            	" PTT_REINS_TAX_PERC,PTT_PREM_PF_ENT_PERC,PTT_PREM_PF_WD_PERC,PTT_LOSS_PF_ENT_PERC," +
		            	" PTT_LOSS_PF_WD_PERC,PTT_LOSS_CF_YEARS,PTT_DEPOSIT_PREM,PTT_PREM_RES_RATIO,PTT_INT_ON_RES_REL," +
		            	" PTT_OS_CLM_RES_RATIO PTT_DFLT_RETN_RATIO,PTT_EXCLUSION,PTT_NOTICE_CANCEL_DAYS,PTT_ACCOUNTS_SUBMIT_PERIOD," +
		            	" PTT_FRZ_FLAG,PTT_CR_DT,PTT_CR_UID,PTT_UPD_DT,PTT_UPD_UID FROM  PM_IL_PROP_TREATY_TYPE" +
		            	"  WHERE  PTT_PT_SYS_ID  = :CTRL_1.M_PT_SYS_ID ";*/

				String sql_C3=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FOR_TREATY_COVER_FOR_SYSID;
				/*"SELECT    PTC_SYS_ID,PTC_COVER_CODE,PTC_STD_TREATY_LIMIT,PTC_SUB_STD_TREATY_LIMIT," +
		            		"    PTC_STD_MAX_RETN,PTC_SSTD_MAX_RETN,PTC_COMM_PERC_1ST_YR,PTC_COMM_PERC_SUB_YRS,PTC_SSTD_COMM_PERC_1ST_YR," +
		            		"    PTC_SSTD_COMM_PERC_SUB_YRS,PTC_SUB_STD_TARIFF,PTC_GROUP_COVER_YN,PTC_CVR_GRP_CODE FROM " +
		            		"	 PM_IL_PROP_TREATY_COVER  WHERE  PTC_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/


				double M_PTG_PTC_SYS_ID=-1;
				String sql_C3A=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FOR_TTY_COV_GRP_FOR_SYSID;
				/*"SELECT    PTG_PTC_CVR_GRP_CODE,PTG_COVER_CODE,PTG_SR_NO FROM" +
		            		"  PM_IL_PROP_TTYCOV_GRP  WHERE  " +
		            		"  PTG_PTC_SYS_ID  = "+M_PTG_PTC_SYS_ID+"  AND PTG_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/


				String sql_C4=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FOR_TREAY_TYPE_COVER_FOR_SYSID;
				/*"SELECT    PTTC_COVER_CODE,PTTC_PERC FROM" +
		            		"  PM_IL_PROP_TREATY_TYPE_COVER  WHERE  PTTC_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/


				String sql_C5=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FOR_TREATY_PART_CUST_FOR_SYSID;
				/*"SELECT    PTPC_SYS_ID,PTPC_PTT_SYS_ID,PTPC_CUST_CODE,PTPC_SHARE_PERC,PTPC_LEADER_YN," +
		            				"    PTPC_CR_DT,PTPC_CR_UID,PTPC_UPD_DT,PTPC_UPD_UID FROM  " +
		            				" PM_IL_PROP_TREATY_PART_CUST  WHERE  PTPC_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/


				String sql_C6=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_PIL_PT_SYS_ID;


				String sql_C7=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_PIL_PTT_SYS_ID;


				String sql_C8=PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_CTRL1_OK_BUTTON_PIL_PTTC_SYS_ID;



				String sql_C9=PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_CTRL1_OK_BUTTON_PIL_PTC_SYS_ID;


				String sql_C10=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_P9IL_PTG_SYS_ID;


				String sql_C11=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_PIL_PTPC_SYS_ID;


				CommonUtils.setGlobalVariable("M_CLASS_CODE", treatyValueBean.getPT_CLASS_CODE());
				resultSet1=handler.executeSelectStatement(sql_C1, connection, object1);
				if(resultSet1.next())
				{

					ctrl_1_bean.setM_PT_SYS_ID(resultSet1.getInt(1));
				}
				else
				{
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71138"));
				}

				resultSet2=handler.executeSelectStatement(sql_C6, connection,new Object[]{});
				if(resultSet2.next())
				{
					M_PT_SYS_ID=resultSet2.getString(1);
				}

				String sql_vembu1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_INSERT_INTO_PM_IL_PROP_TREATY;
				System.out.println("M_USER_ID :"+CommonUtils.getControlBean().getM_USER_ID());
				Object[] objects2={M_PT_SYS_ID,ctrl_1_bean.getUI_M_CP_DEST_TREATY_CODE(),ctrl_1_bean.getUI_M_CP_DEST_UW_YEAR(),
						CommonUtils.getControlBean().getM_USER_ID(),ctrl_1_bean.getM_PT_SYS_ID()};
				/*"INSERT INTO  PM_IL_PROP_TREATY      ( PT_SYS_ID ,PT_TREATY_CODE ,PT_TREATY_DESC ,PT_CLASS_CODE ,PT_UW_YEAR ,PT_UW_YEAR_DESC ," +
	        		"			PT_START_DT ,PT_END_DT ,PT_CURR_CODE ,PT_CURR_RATE ,PT_FRZ_FLAG ,PT_CR_DT ,PT_CR_UID ,PT_CQS_YN ,PT_CQS_PERC ," +
	        		"    PT_RIDER_RI_BASIS ,PT_UW_BASIS ,PT_CORIDOR_LC_LIMIT ,PT_SURR_CLAIM_YN ) " +
	        		"  SELECT    '"+M_PT_SYS_ID+"',:CTRL_1.M_CP_DEST_TREATY_CODE,PT_TREATY_DESC,PT_CLASS_CODE," +
	        		"    :CTRL_1.M_CP_DEST_UW_YEAR,PT_UW_YEAR_DESC,PT_START_DT,PT_END_DT,PT_CURR_CODE,PT_CURR_RATE," +
	        		"    'N',SYSDATE,:CTRL.M_USER_ID,NVL(PT_CQS_YN, 'N'),PT_CQS_PERC, NVL(PT_RIDER_RI_BASIS, 'N')," +
	        		"    PT_UW_BASIS,PT_CORIDOR_LC_LIMIT,NVL(PT_SURR_CLAIM_YN, 'N') FROM  PM_IL_PROP_TREATY  WHERE " +
	        		" PT_SYS_ID  = :CTRL_1.M_PT_SYS_ID ";*/
				int insertedData=handler.executeInsertStatement(sql_vembu1, connection,objects2);
				System.out.println(" Inserted Records :"+insertedData);

				String queryTreatyCode="SELECT PT_TREATY_CODE FROM PM_IL_PROP_TREATY WHERE PT_SYS_ID=? ";
				Object[] objects={M_PT_SYS_ID};
				resultSet13=handler.executeSelectStatement(queryTreatyCode, connection, objects);
				if(resultSet13.next()){
					returnTreatycode=resultSet13.getString(1);
					System.out.println("returnTreatycode :"+returnTreatycode);
				}

				String sqlQuery=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
						PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FOR_TREATY_TYPE_SYSID;
				Object[] object3={ctrl_1_bean.getM_PT_SYS_ID()};
				/*	"SELECT    PTT_SYS_ID,PTT_PT_SYS_ID,PTT_SRNO,PTT_TREATY_TYPE,PTT_PROFIT_COMM,PTT_REINS_TAX_PERC," +
	            			" 	 PTT_PREM_PF_ENT_PERC,PTT_PREM_PF_WD_PERC,PTT_LOSS_PF_ENT_PERC,PTT_LOSS_PF_WD_PERC,PTT_LOSS_CF_YEARS," +
		            		"    PTT_DEPOSIT_PREM,PTT_PREM_RES_RATIO,PTT_INT_ON_RES_REL,PTT_OS_CLM_RES_RATIO PTT_DFLT_RETN_RATIO," +
		            		"    PTT_EXCLUSION,PTT_NOTICE_CANCEL_DAYS,PTT_ACCOUNTS_SUBMIT_PERIOD,PTT_FRZ_FLAG,PTT_CR_DT,PTT_CR_UID," +
		            		"    PTT_UPD_DT, PTT_UPD_UID FROM  PM_IL_PROP_TREATY_TYPE  WHERE  PTT_PT_SYS_ID  = :CTRL_1.M_PT_SYS_ID ";*/
				resultSet3=handler.executeSelectStatement(sqlQuery, connection, object3);

				while((resultSet3.next()))
				{
					PM_IL_PROP_TREATY_TYPE treatyTypeBean=new PM_IL_PROP_TREATY_TYPE();
					treatyTypeBean.setROWID(resultSet3.getString("ROWID"));
					treatyTypeBean.setPTT_SYS_ID(resultSet3.getDouble("PTT_SYS_ID"));
					treatyTypeBean.setPTT_PT_SYS_ID(resultSet3.getDouble("PTT_PT_SYS_ID"));
					treatyTypeBean.setPTT_SRNO(resultSet3.getDouble("PTT_SRNO"));
					treatyTypeBean.setPTT_TREATY_TYPE(resultSet3.getString("PTT_TREATY_TYPE"));
					treatyTypeBean.setPTT_LINK_TREATY_CODE(resultSet3.getString("PTT_LINK_TREATY_CODE"));
					treatyTypeBean.setPTT_MGT_EXP_RATIO(resultSet3.getDouble("PTT_MGT_EXP_RATIO"));
					treatyTypeBean.setPTT_PROFIT_COMM(resultSet3.getDouble("PTT_PROFIT_COMM"));
					treatyTypeBean.setPTT_REINS_TAX_PERC(resultSet3.getDouble("PTT_REINS_TAX_PERC"));
					treatyTypeBean.setPTT_PREM_PF_ENT_PERC(resultSet3.getDouble("PTT_PREM_PF_ENT_PERC"));
					treatyTypeBean.setPTT_PREM_PF_WD_PERC(resultSet3.getDouble("PTT_PREM_PF_WD_PERC"));
					treatyTypeBean.setPTT_LOSS_PF_ENT_PERC(resultSet3.getDouble("PTT_LOSS_PF_ENT_PERC"));
					treatyTypeBean.setPTT_LOSS_PF_WD_PERC(resultSet3.getDouble("PTT_LOSS_PF_WD_PERC"));
					treatyTypeBean.setPTT_LOSS_CF_YEARS(resultSet3.getDouble("PTT_LOSS_CF_YEARS"));
					treatyTypeBean.setPTT_DEPOSIT_PREM(resultSet3.getDouble("PTT_DEPOSIT_PREM"));
					treatyTypeBean.setPTT_PREM_RES_RATIO(resultSet3.getDouble("PTT_PREM_RES_RATIO"));
					treatyTypeBean.setPTT_INT_ON_RES_REL(resultSet3.getDouble("PTT_INT_ON_RES_REL"));
					treatyTypeBean.setPTT_OS_CLM_RES_RATIO(resultSet3.getDouble("PTT_OS_CLM_RES_RATIO"));
					treatyTypeBean.setPTT_EXCLUSION(resultSet3.getString("PTT_EXCLUSION"));
					treatyTypeBean.setPTT_NOTICE_CANCEL_DAYS(resultSet3.getDouble("PTT_NOTICE_CANCEL_DAYS"));
					treatyTypeBean.setPTT_ACCOUNTS_SUBMIT_PERIOD(resultSet3.getString("PTT_ACCOUNTS_SUBMIT_PERIOD"));
					treatyTypeBean.setPTT_FRZ_FLAG(resultSet3.getString("PTT_FRZ_FLAG"));
					treatyTypeBean.setPTT_CR_DT(resultSet3.getDate("PTT_CR_DT"));
					treatyTypeBean.setPTT_CR_UID(resultSet3.getString("PTT_CR_UID"));
					treatyTypeBean.setPTT_UPD_DT(resultSet3.getDate("PTT_UPD_DT"));
					treatyTypeBean.setPTT_UPD_UID(resultSet3.getString("PTT_UPD_UID"));
					treatyTypeBean.setPTT_NET_SURPLUS_AMT(resultSet3.getDouble("PTT_NET_SURPLUS_AMT"));
					treatyTypeBean.setPTT_ACCOUNTS_CLOSE_PERIOD(resultSet3.getString("PTT_ACCOUNTS_CLOSE_PERIOD"));

					resultSet4=handler.executeSelectStatement(sql_C7, connection, new Object[]{});
					if(resultSet4.next())
					{
						M_PTT_SYS_ID=resultSet4.getString(1);
					}

					M_TEMP_PTT_SID=treatyTypeBean.getPTT_SYS_ID();

					String sql_vembu2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
							PILM015_APAC_CTRL1_OK_BUTTON_INSERT_INTO_TREATY_TYPE;
					Object[] object4={M_PTT_SYS_ID,M_PT_SYS_ID,treatyTypeBean.getPTT_SRNO(),treatyTypeBean.getPTT_TREATY_TYPE(),
							treatyTypeBean.getPTT_LINK_TREATY_CODE(),treatyTypeBean.getPTT_MGT_EXP_RATIO(),treatyTypeBean.getPTT_PROFIT_COMM(),
							treatyTypeBean.getPTT_REINS_TAX_PERC(),treatyTypeBean.getPTT_PREM_PF_ENT_PERC(),treatyTypeBean.getPTT_PREM_PF_WD_PERC(),
							treatyTypeBean.getPTT_LOSS_PF_ENT_PERC(),treatyTypeBean.getPTT_LOSS_PF_WD_PERC(),treatyTypeBean.getPTT_LOSS_CF_YEARS(),
							treatyTypeBean.getPTT_DEPOSIT_PREM(),treatyTypeBean.getPTT_PREM_RES_RATIO(),treatyTypeBean.getPTT_INT_ON_RES_REL(),
							treatyTypeBean.getPTT_OS_CLM_RES_RATIO(),treatyTypeBean.getPTT_EXCLUSION(),treatyTypeBean.getPTT_NOTICE_CANCEL_DAYS(),
							treatyTypeBean.getPTT_ACCOUNTS_SUBMIT_PERIOD(),CommonUtils.getControlBean().getM_USER_ID()};

					/*"INSERT INTO  PM_IL_PROP_TREATY_TYPE( PTT_SYS_ID ,PTT_PT_SYS_ID ," +
	                		" PTT_SRNO ,PTT_TREATY_TYPE ,PTT_LINK_TREATY_CODE ,PTT_MGT_EXP_RATIO ,PTT_PROFIT_COMM ," +
	                		" PTT_REINS_TAX_PERC ,PTT_PREM_PF_ENT_PERC ,PTT_PREM_PF_WD_PERC ,PTT_LOSS_PF_ENT_PERC ,PTT_LOSS_PF_WD_PERC ," +
	                		" PTT_LOSS_CF_YEARS ,PTT_DEPOSIT_PREM ,PTT_PREM_RES_RATIO ,PTT_INT_ON_RES_REL ,PTT_OS_CLM_RES_RATIO ,PTT_EXCLUSION ," +
	                		" PTT_NOTICE_CANCEL_DAYS ,PTT_ACCOUNTS_SUBMIT_PERIOD ,PTT_FRZ_FLAG ,PTT_CR_DT ,PTT_CR_UID ) " +
	                		"   VALUES   ( '"+M_PTT_SYS_ID+"' ,    '"+M_PT_SYS_ID+"' ,C2_REC.PTT_SRNO , C2_REC.PTT_TREATY_TYPE ,C2_REC.PTT_LINK_TREATY_CODE ," +
	                		"    C2_REC.PTT_MGT_EXP_RATIO ,C2_REC.PTT_PROFIT_COMM ,C2_REC.PTT_REINS_TAX_PERC ,C2_REC.PTT_PREM_PF_ENT_PERC ,C2_REC.PTT_PREM_PF_WD_PERC ," +
	                		"    C2_REC.PTT_LOSS_PF_ENT_PERC ,C2_REC.PTT_LOSS_PF_WD_PERC , C2_REC.PTT_LOSS_CF_YEARS , C2_REC.PTT_DEPOSIT_PREM ,C2_REC.PTT_PREM_RES_RATIO ," +
	                		"    C2_REC.PTT_INT_ON_RES_REL , C2_REC.PTT_DFLT_RETN_RATIO , C2_REC.PTT_EXCLUSION , C2_REC.PTT_NOTICE_CANCEL_DAYS ,C2_REC.PTT_ACCOUNTS_SUBMIT_PERIOD ," +
	                		"    'N' ,    SYSDATE ,    :CTRL.M_USER_ID )   ";*/
					int insertTreatyType=handler.executeInsertStatement(sql_vembu2, connection,object4);
					System.out.println("insertTreatyType :"+insertTreatyType);
					Object[] objects4={M_TEMP_PTT_SID};
					resultSet5=handler.executeSelectStatement(sql_C4, connection,objects4);
					while(resultSet5.next())
					{
						//	                    if(resultSet5.next())
						//	                    {
						M_PTTC_COVER_CODE=resultSet5.getString(1);
						M_PTTC_PERC=resultSet5.getString(2);
						//	                    }
						//	                    if(resultSet5.next())
						//	                    break;
						resultSet6=handler.executeSelectStatement(sql_C8, connection, new Object[]{});

						if(resultSet6.next())
						{
							M_PTTC_SYS_ID=resultSet6.getString(1);
						}

						String sql_vembu3=PM_IL_PROP_TREATY_QUERY_CONSTANTS
								.PILM015_APAC_CTRL1_OK_BUTTON_INSERT_INTO_TREATY_TYPE_COVER;
						/*	"INSERT INTO  PM_IL_PROP_TREATY_TYPE_COVER( PTTC_SYS_ID ,PTTC_PTT_SYS_ID ," +
		                    		"    PTTC_COVER_CODE ,PTTC_PERC ,PTTC_CR_DT ,PTTC_CR_UID ) VALUES  " +
		                    		"( '"+M_PTTC_SYS_ID+"' ,'"+M_PTT_SYS_ID+"' ,"+M_PTTC_COVER_CODE+" ,"+M_PTTC_PERC+" , SYSDATE ," +
		                    		"    :CTRL.M_USER_ID )   ";*/
						Object[] objects5={M_PTTC_SYS_ID,M_PTT_SYS_ID,M_PTTC_COVER_CODE,M_PTTC_PERC,CommonUtils.getControlBean().getM_USER_ID()};
						int updateTreatyTypeCover=handler.executeInsertStatement(sql_vembu3, connection, objects5);
						System.out.println(" updateTreatyTypeCover :"+updateTreatyTypeCover);
					}

					String sqlC3=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
							PILM015_APAC_CTRL1_OK_BUTTON_SELECT_DETAILS_FROM_TREATY_COVER;
					Object[] objects6={M_TEMP_PTT_SID};
					/*"SELECT    PTC_SYS_ID,PTC_COVER_CODE,PTC_STD_TREATY_LIMIT,PTC_SUB_STD_TREATY_LIMIT,PTC_STD_MAX_RETN,PTC_SSTD_MAX_RETN," +
	                		"    PTC_COMM_PERC_1ST_YR,PTC_COMM_PERC_SUB_YRS,PTC_SSTD_COMM_PERC_1ST_YR,PTC_SSTD_COMM_PERC_SUB_YRS,PTC_SUB_STD_TARIFF,PTC_GROUP_COVER_YN," +
	                		"    PTC_CVR_GRP_CODE FROM  PM_IL_PROP_TREATY_COVER  WHERE  PTC_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/
					//vembu_C3=stmt_C3.executeQuery(sql_C3);
					resultSet7=handler.executeSelectStatement(sqlC3, connection, objects6);
					while((resultSet7.next()))
					{
						PM_IL_PROP_TREATY_COVER treatyCoverValueBean=new PM_IL_PROP_TREATY_COVER();
						treatyCoverValueBean.setPTC_COVER_CODE(resultSet7.getString("PTC_COVER_CODE"));
						treatyCoverValueBean.setPTC_SSTD_MAX_RETN(resultSet7.getDouble("PTC_SSTD_MAX_RETN"));
						treatyCoverValueBean.setPTC_COMM_PERC_SUB_YRS(resultSet7.getDouble("PTC_COMM_PERC_SUB_YRS"));
						treatyCoverValueBean.setPTC_CVR_GRP_CODE(resultSet7.getString("PTC_CVR_GRP_CODE"));
						treatyCoverValueBean.setPTC_STD_TREATY_LIMIT(resultSet7.getDouble("PTC_STD_TREATY_LIMIT"));
						treatyCoverValueBean.setPTC_SSTD_COMM_PERC_SUB_YRS(resultSet7.getDouble("PTC_SSTD_COMM_PERC_SUB_YRS"));
						treatyCoverValueBean.setPTC_STD_MAX_RETN(resultSet7.getDouble("PTC_STD_MAX_RETN"));
						treatyCoverValueBean.setPTC_SUB_STD_TARIFF(resultSet7.getString("PTC_SUB_STD_TARIFF"));
						treatyCoverValueBean.setPTC_SUB_STD_TREATY_LIMIT(resultSet7.getDouble("PTC_SUB_STD_TREATY_LIMIT"));
						treatyCoverValueBean.setPTC_GROUP_COVER_YN(resultSet7.getString("PTC_GROUP_COVER_YN"));
						treatyCoverValueBean.setPTC_SSTD_COMM_PERC_1ST_YR(resultSet7.getDouble("PTC_SSTD_COMM_PERC_1ST_YR"));
						treatyCoverValueBean.setPTC_COMM_PERC_1ST_YR(resultSet7.getDouble("PTC_COMM_PERC_1ST_YR"));
						treatyCoverValueBean.setPTC_SYS_ID(resultSet7.getDouble("PTC_SYS_ID"));

						resultSet8=handler.executeSelectStatement(sql_C9, connection, new Object[]{});

						if(resultSet8.next())
						{
							M_PTC_SYS_ID=resultSet8.getString(1);
						}

						String sql_vembu4=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
								PILM015_APAC_CTRL1_OK_BUTTON_INSERT_INTO_TREATY_COVER;
						/*"INSERT INTO  PM_IL_PROP_TREATY_COVER( PTC_SYS_ID ,PTC_PTT_SYS_ID ,PTC_COVER_CODE ," +
	                		"    PTC_STD_TREATY_LIMIT ,PTC_SUB_STD_TREATY_LIMIT ,PTC_STD_MAX_RETN ,PTC_SSTD_MAX_RETN ,PTC_COMM_PERC_1ST_YR ," +
	                		"    PTC_COMM_PERC_SUB_YRS ,PTC_SSTD_COMM_PERC_1ST_YR ,PTC_SSTD_COMM_PERC_SUB_YRS ,PTC_SUB_STD_TARIFF ," +
	                		"    PTC_GROUP_COVER_YN ,PTC_CVR_GRP_CODE ) VALUES ( '"+M_PTC_SYS_ID+"' ,    '"+M_PTT_SYS_ID+"' ," +
	        				"    C3_REC.PTC_COVER_CODE , C3_REC.PTC_STD_TREATY_LIMIT ,C3_REC.PTC_SUB_STD_TREATY_LIMIT ,C3_REC.PTC_STD_MAX_RETN ," +
	        				"    C3_REC.PTC_SSTD_MAX_RETN ,C3_REC.PTC_COMM_PERC_1ST_YR ,C3_REC.PTC_COMM_PERC_SUB_YRS ,C3_REC.PTC_SSTD_COMM_PERC_1ST_YR ," +
	        				"    C3_REC.PTC_SSTD_COMM_PERC_SUB_YRS ,C3_REC.PTC_SUB_STD_TARIFF ,C3_REC.PTC_GROUP_COVER_YN ,C3_REC.PTC_CVR_GRP_CODE )   ";*/
						Object[] objects7={M_PTC_SYS_ID,M_PTT_SYS_ID,treatyCoverValueBean.getPTC_COVER_CODE(),treatyCoverValueBean.getPTC_STD_TREATY_LIMIT(),
								treatyCoverValueBean.getPTC_SUB_STD_TREATY_LIMIT(),treatyCoverValueBean.getPTC_STD_MAX_RETN(),treatyCoverValueBean.getPTC_SSTD_MAX_RETN(),
								treatyCoverValueBean.getPTC_COMM_PERC_1ST_YR(),treatyCoverValueBean.getPTC_COMM_PERC_SUB_YRS(),
								treatyCoverValueBean.getPTC_SSTD_COMM_PERC_1ST_YR(),treatyCoverValueBean.getPTC_SSTD_COMM_PERC_SUB_YRS(),treatyCoverValueBean.getPTC_SUB_STD_TARIFF(),
								treatyCoverValueBean.getPTC_GROUP_COVER_YN(),treatyCoverValueBean.getPTC_CVR_GRP_CODE()};
						int treatyCoverData=handler.executeInsertStatement(sql_vembu4, connection, objects7);
						System.out.println("treatyCoverData :"+treatyCoverData);

						M_PTG_PTC_SYS_ID = treatyCoverValueBean.getPTC_SYS_ID();
						sql_C3A=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
								PILM015_APAC_CTRL1_OK_BUTTON_SELECT_FROM_TTYCOV_GRP;
						Object[] objects8={M_PTG_PTC_SYS_ID,M_TEMP_PTT_SID};
						/*"SELECT    PTG_PTC_CVR_GRP_CODE,PTG_COVER_CODE,PTG_SR_NO " +
	                    		" FROM  PM_IL_PROP_TTYCOV_GRP  WHERE  PTG_PTC_SYS_ID  = "+M_PTG_PTC_SYS_ID+" " +
	                    		" AND PTG_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/
						resultSet9=handler.executeSelectStatement(sql_C3A , connection, objects8);

						while((resultSet9.next()))
						{
							PM_IL_PROP_TTYCOV_GRP ttyCovGrpValueBean=new PM_IL_PROP_TTYCOV_GRP();
							ttyCovGrpValueBean.setPTG_SR_NO(resultSet9.getDouble("PTG_SR_NO"));
							ttyCovGrpValueBean.setPTG_PTC_CVR_GRP_CODE(resultSet9.getString("PTG_PTC_CVR_GRP_CODE"));
							ttyCovGrpValueBean.setPTG_COVER_CODE(resultSet9.getString("PTG_COVER_CODE"));
							resultSet10=handler.executeSelectStatement(sql_C10, connection, new Object[]{});

							if(resultSet10.next())
							{
								M_PTG_SYS_ID=resultSet10.getString(1);
							}

							String sql_vembu5=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
									PILM015_APAC_CTRL1_OK_BUTTON_INSERT_INTO_TTYCOV_GRP;

							/*
							 * commented by Dhinesh on 02-03-2018 for treat coping issue 
							 * 
							 * Object[] objects9={M_PTG_SYS_ID,M_PTC_SYS_ID,ttyCovGrpValueBean.getPTG_PTC_CVR_GRP_CODE(),
		                        					ttyCovGrpValueBean.getPTG_COVER_CODE(),ttyCovGrpValueBean.getPTG_SR_NO(),CommonUtils.getControlBean().getM_USER_ID()};*/

							/*Newly added M_PTT_SYS_ID only in object array by Dhinesh on 02-03-2018 for number of parameter mismatching*/

							Object[] objects9={M_PTG_SYS_ID,M_PTC_SYS_ID,M_PTT_SYS_ID,ttyCovGrpValueBean.getPTG_PTC_CVR_GRP_CODE(),
									ttyCovGrpValueBean.getPTG_COVER_CODE(),ttyCovGrpValueBean.getPTG_SR_NO(),CommonUtils.getControlBean().getM_USER_ID()};

							/* End */

							/* "INSERT INTO  PM_IL_PROP_TTYCOV_GRP( PTG_SYS_ID ,PTG_PTC_SYS_ID ,PTG_PTT_SYS_ID ,PTG_PTC_CVR_GRP_CODE ,PTG_COVER_CODE ,PTG_SR_NO ,PTG_CR_UID ,PTG_CR_DT )" +
		                        		"    VALUES   ( "+M_PTG_SYS_ID+" ,    '"+M_PTC_SYS_ID+"' ,    '"+M_PTT_SYS_ID+"' , C3A_REC.PTG_PTC_CVR_GRP_CODE ," +
	                    				"    C3A_REC.PTG_COVER_CODE , C3A_REC.PTG_SR_NO ,:CTRL.M_USER_ID , SYSDATE )";*/
							int insertTtyCovGrpData=handler.executeInsertStatement(sql_vembu5, connection, objects9);
							System.out.println("insertTtyCovGrpData :"+insertTtyCovGrpData);
						}
					}
					sql_C5=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
							PILM015_APAC_CTRL1_OK_BUTTON_SELECT_TREATY_PART_CUST_DETAILS;
					/*	"SELECT    PTPC_SYS_ID,PTPC_PTT_SYS_ID, PTPC_CUST_CODE,PTPC_SHARE_PERC,PTPC_LEADER_YN,PTPC_CR_DT,PTPC_CR_UID,PTPC_UPD_DT," +
	                		" PTPC_UPD_UID FROM  PM_IL_PROP_TREATY_PART_CUST  WHERE  PTPC_PTT_SYS_ID  = '"+M_TEMP_PTT_SID+"' ";*/
					Object[] objects10={M_TEMP_PTT_SID};
					resultSet11=handler.executeSelectStatement(sql_C5, connection, objects10);

					while((resultSet11.next()))
					{
						PM_IL_PROP_TREATY_PART_CUST treatyPartCustValueBean=new PM_IL_PROP_TREATY_PART_CUST();
						treatyPartCustValueBean.setPTPC_UPD_DT(resultSet11.getDate("PTPC_UPD_DT"));
						treatyPartCustValueBean.setPTPC_CR_DT(resultSet11.getDate("PTPC_CR_DT"));
						treatyPartCustValueBean.setPTPC_CUST_CODE(resultSet11.getString("PTPC_CUST_CODE"));
						treatyPartCustValueBean.setPTPC_CR_UID(resultSet11.getString("PTPC_CR_UID"));
						treatyPartCustValueBean.setPTPC_LEADER_YN(resultSet11.getString("PTPC_LEADER_YN"));
						treatyPartCustValueBean.setPTPC_SHARE_PERC(resultSet11.getDouble("PTPC_SHARE_PERC"));
						treatyPartCustValueBean.setPTPC_UPD_UID(resultSet11.getString("PTPC_UPD_UID"));
						treatyPartCustValueBean.setPTPC_SYS_ID(resultSet11.getDouble("PTPC_SYS_ID"));
						treatyPartCustValueBean.setPTPC_PTT_SYS_ID(resultSet11.getDouble("PTPC_PTT_SYS_ID"));

						resultSet12=handler.executeSelectStatement(sql_C11, connection,new Object[]{}); 

						if(resultSet12.next())
						{
							M_PTPC_SYS_ID=resultSet12.getString(1);
						}


						String sql_vembu6=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
								PILM015_APAC_CTRL1_OK_BUTTON_INSERT_INTO_TREATY_PART_CUST;
						Object[] objects11={M_PTPC_SYS_ID,M_PTT_SYS_ID,treatyPartCustValueBean.getPTPC_CUST_CODE(),
								treatyPartCustValueBean.getPTPC_SHARE_PERC(),treatyPartCustValueBean.getPTPC_LEADER_YN(),
								new CommonUtils().getCurrentDate(),treatyPartCustValueBean.getPTPC_CR_UID()
						};

						/*	"INSERT INTO  PM_IL_PROP_TREATY_PART_CUST  ( PTPC_SYS_ID ,PTPC_PTT_SYS_ID ,PTPC_CUST_CODE ,PTPC_SHARE_PERC ," +
	    					"    PTPC_LEADER_YN ,PTPC_CR_DT ,PTPC_CR_UID ) VALUES ( '"+M_PTPC_SYS_ID+"' ,    '"+M_PTT_SYS_ID+"' ," +
							"    C5_REC.PTPC_CUST_CODE ,C5_REC.PTPC_SHARE_PERC ,C5_REC.PTPC_LEADER_YN , SYSDATE , :CTRL.M_USER_ID )";*/
						int insertTreatyPartCustData=handler.executeInsertStatement(sql_vembu6, connection,objects11);
						System.out.println("insertTreatyPartCustData :"+insertTreatyPartCustData);
					}
				}
				// [BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied	            
				copyProdTreatyPeriod(ctrl_1_bean);
				// BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied ]	            
			}catch(SQLException e)
			{
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} catch (DBException e) {

				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					CommonUtils.closeCursor(resultSet1);
					CommonUtils.closeCursor(resultSet2);
					CommonUtils.closeCursor(resultSet3);
					CommonUtils.closeCursor(resultSet4);
					CommonUtils.closeCursor(resultSet5);
					CommonUtils.closeCursor(resultSet6);
					CommonUtils.closeCursor(resultSet7);
					CommonUtils.closeCursor(resultSet8);
					CommonUtils.closeCursor(resultSet9);
					CommonUtils.closeCursor(resultSet10);
					CommonUtils.closeCursor(resultSet11);
					CommonUtils.closeCursor(resultSet12);
					CommonUtils.closeCursor(resultSet13);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return returnTreatycode;
		}
		// [BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied		
		public void copyProdTreatyPeriod(CTRL_1 ctrl_1_bean){
			String sql_c12 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PIL015_APAC_PM_IL_PROP_TREATY_PERIOD;
			String sql_c13 = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PIL015_APAC_PM_IL_PROP_TREATY_PERIOD_SELECT;
			CRUDHandler handler = new CRUDHandler();
			ResultSet rsc13 = null;
			String tCode =ctrl_1_bean.getUI_M_CP_TREATY_CODE();
			String targetTCode = ctrl_1_bean.getUI_M_CP_DEST_TREATY_CODE();
			Object[] value ={tCode};

			try {
				rsc13 = handler.executeSelectStatement(sql_c13, CommonUtils.getConnection(), value);
				while(rsc13.next()){
					PM_IL_PROP_TREATY_PERIOD treatyPeriod = new PM_IL_PROP_TREATY_PERIOD();
					treatyPeriod.setPPTP_PT_TREATY_CODE(targetTCode);
					treatyPeriod.setPPTP_MON_FM(rsc13.getInt("PPTP_MON_FM"));
					treatyPeriod.setPPTP_MON_TO(rsc13.getInt("PPTP_MON_TO"));
					treatyPeriod.setPPTP_SUB_NO(rsc13.getInt("PPTP_SUB_NO"));
					handler.executeInsert(treatyPeriod, CommonUtils.getConnection());
				}
				rsc13.close();
//				CommonUtils.getConnection().commit();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
// BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied ]		
}
