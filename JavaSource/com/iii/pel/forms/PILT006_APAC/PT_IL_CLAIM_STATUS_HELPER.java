package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_LOCAL_PROCEDURES;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_STATUS_HELPER {

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_CLAIM_STATUS_DELEGATE()
				.executeSelectStatement(compositeAction);
	}
	
	public void preInsert(PT_IL_CLAIM_STATUS statusBean) throws Exception{
		try {
			statusBean.setCS_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			statusBean.setCS_CR_DT(new CommonUtils().getCurrentDate());
			statusBean.setCS_TYPE("S");
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**	 * Rerender required UI_M_CS_STATUS_CODE_DESC
	 * @param claimBean
	 * @param dummyBean
	 * @param ctrlBean
	 * @param statusBean
	 * @throws Exception 
	 */
	public void validateCS_STATUS_CODE(PT_IL_CLAIM claimBean, DUMMY dummyBean, 
			CTRL ctrlBean, PT_IL_CLAIM_STATUS statusBean) throws Exception{
		String M_CHECK = null;
		String M_UWQ = null;
		Long M_CS_SYS_ID = null;
		String M_CS_STATUS_CODE = null;
		String M_VALUE = null;
		String M_ASD_CHAR_VALUE = null;
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Object[] values = null;
		String CS_STATUS_CODE_WWI_CURSOR_C1 = "SELECT MAX(CS_SYS_ID) "
			+ "FROM   PT_IL_CLAIM_STATUS "
			+ "WHERE  CS_CLM_SYS_ID = ?";
		String CS_STATUS_CODE_WWI_CURSOR_C2 = "SELECT CS_STATUS_CODE "
			+ "FROM   PT_IL_CLAIM_STATUS "
			+ "WHERE  CS_CLM_SYS_ID = ? "
			+ "AND    CS_SYS_ID = ? ";
		String CS_STATUS_CODE_WWI_CURSOR_C3 = "SELECT ASD_CHAR_VALUE "
			+ "FROM   PM_IL_APPR_SETUP_DET " 
			+ "WHERE  ASD_CODE = 'CHG_CLM_STAT' "   
			+ "AND    ASD_USER_ID = ? "
			+ "AND    ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> resultList = null;
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{claimBean.getCLAIM_SYS_ID()};
			resultSet1 = handler.executeSelectStatement(CS_STATUS_CODE_WWI_CURSOR_C1, 
					connection, values);
			if(resultSet1.next()){
				M_CS_SYS_ID = resultSet1.getLong(1);
			}
			
			values = new Object[]{claimBean.getCLAIM_SYS_ID(), M_CS_SYS_ID};
			resultSet2 = handler.executeSelectStatement(CS_STATUS_CODE_WWI_CURSOR_C2, 
					connection, values);
			if(resultSet2.next()){
				M_CS_STATUS_CODE = resultSet2.getString(1);
			}
			
			if("P".equals(statusBean.getCS_STATUS_CODE())){
				if(!"C".equals(M_CS_STATUS_CODE)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91101"));
				}
			}
			
			values = new Object[]{ctrlBean.getUSER_ID(), dummyBean.getM_POL_PROD_CODE(), };
			resultSet3 = handler.executeSelectStatement(CS_STATUS_CODE_WWI_CURSOR_C3, 
					connection, values);
			if(resultSet3.next()){
				M_ASD_CHAR_VALUE = resultSet3.getString(1);
				if("N".equals(CommonUtils.nvl(M_ASD_CHAR_VALUE, "N"))){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91158"));
				}
			}
			
			if(statusBean.getCS_STATUS_CODE() != null){
				resultList = DBProcedures.P_VAL_SYSTEM("IL_ADDL_STAT", 
						statusBean.getCS_STATUS_CODE(),statusBean.getUI_M_CS_STATUS_CODE_DESC(),"E",
						M_VALUE);
				if(resultList.size() > 0){
					statusBean.setUI_M_CS_STATUS_CODE_DESC(resultList.get(0));
					M_VALUE = resultList.get(1);
				}
			}
			
			resultList = (ArrayList<String>) new PILT006_APAC_PROCEDURE().L_VALIDATE_CHECKLIST(claimBean);
			if(resultList.size() > 0){
				M_CHECK = resultList.get(0);
				M_UWQ = resultList.get(1);
			}
			if(!"Y".equals(M_CHECK) || !"Y".equals(M_UWQ)){
				if("CL05".equals(statusBean.getCS_STATUS_CODE())){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206"));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet1);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet2);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet3);}catch(Exception exc){}
		}
	}
	
	/**
	 * Rerender UI_M_REASON_CODE_DESC
	 * @param statusBean
	 * @throws Exception 
	 */
	public void validateCS_REASON_CODE(PT_IL_CLAIM_STATUS statusBean) throws Exception{
		String reasonDesc = null;
		Connection connection = null;
		
		try { 
			connection = CommonUtils.getConnection();
			if(statusBean.getCS_REASON_CODE() != null){
				reasonDesc = DBProcedures.P_VAL_CODES(connection, "IL_REASON", 
						statusBean.getCS_REASON_CODE(), "N", "E");
				statusBean.setUI_M_REASON_CODE_DESC(reasonDesc);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String WBP_UI_M_BUT_OK(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_CHECK = null;
		String M_UWQ = null;
		Long M_CS_SYS_ID = null;
		String M_CS_STATUS_CODE = null;
		String M_DUMMY = null;
		String M_DS_TYPE = null;
		String M_ASD_CHAR_VALUE = null;
		String M_PLAN_TYPE = null;
		String outcome = null;
		Object[] values = null;
		Connection connection = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		ResultSet resultSet8 = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> resultList = null;
		ResultSet resultSet = null;
		String product_code=null;
		String message = "";
		PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(); 
		PT_IL_CLAIM_STATUS statusBean = compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN(); 
		CTRL ctrlBean = compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(); 
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	
		String CURSOR_C2 = "SELECT MAX(CS_SYS_ID) "
			+ "FROM   PT_IL_CLAIM_STATUS "
			+ "WHERE  CS_CLM_SYS_ID = ?";
		String CURSOR_C3 = "SELECT CS_STATUS_CODE "
			+ "FROM   PT_IL_CLAIM_STATUS "
			+ "WHERE  CS_CLM_SYS_ID = ? "
			+ "AND    CS_SYS_ID = ?";
		String CURSOR_C4 = "SELECT LIV_CODE_DESC "
			+ "FROM   PP_LIST_ITEM_VALUES "
			+ "WHERE  LIV_SYS_PARAM = 'IL_CLM_STS' "
			+ "AND    LIV_CODE = ?";
		String CURSOR_C5 = "SELECT CS_STATUS_CODE "
			+ "FROM   PT_IL_CLAIM_STATUS " 
			+ "WHERE  CS_SYS_ID = (SELECT MAX(CS_SYS_ID) " 
                          + "FROM   PT_IL_CLAIM_STATUS "
                          + "WHERE  CS_CLM_SYS_ID = ?)";
		String CURSOR_C6 = "SELECT DS_TYPE " 
			+ "FROM   PM_IL_DOC_SETUP " 
			+ "WHERE  DS_CODE = ?"
			+ "AND    DS_TYPE = '4'";
		String CURSOR_C7 = "SELECT ASD_CHAR_VALUE "
			+ "FROM   PM_IL_APPR_SETUP_DET " 
			+ "WHERE  ASD_CODE = 'CHG_CLM_STAT' "   
			+ "AND    ASD_USER_ID = ? "
			+ "AND    ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		String CURSOR_C8 = "SELECT PLAN_TYPE "
			+ "FROM   PM_IL_PLAN "
			+ "WHERE  PLAN_CODE = ( SELECT POL_PLAN_CODE "
                          + "FROM   PT_IL_POLICY "
                          + "WHERE  POL_NO = ?)";
		
		try {
			connection = CommonUtils.getConnection();
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			
			if(dummyBean.getM_CALC_METHOD() == 1 || dummyBean.getM_CALC_METHOD() == 2){
				values = new Object[]{claimBean.getCLAIM_SYS_ID()};
				resultSet5 = handler.executeSelectStatement(CURSOR_C5, connection, values);
				if(resultSet5.next()){
					M_DUMMY = resultSet5.getString("CS_STATUS_CODE");
					//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
					String beanvalue=statusBean.getCS_STATUS_CODE();
					if(beanvalue.equals(M_DUMMY)){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91156"));
					}
				}
			}
			
			resultList = (ArrayList<String>) new PILT006_APAC_PROCEDURE().L_VALIDATE_CHECKLIST(claimBean);
			if(resultList.size() > 0){
				M_CHECK = resultList.get(0);
				M_UWQ = resultList.get(1);
			}
			
			if(!"Y".equals(M_CHECK) || !"Y".equals(M_UWQ)){
				if("CL05".equals(statusBean.getCS_STATUS_CODE())){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206"));
				}
			}
			
			if(statusBean.getCS_STATUS_CODE() != null){
				new P9ILPK_CLAIM().P_INSERT_CLAIM_STATUS(
						CommonUtils.getProcedureValue(claimBean.getCLAIM_SYS_ID()), 
						statusBean.getCS_STATUS_CODE(), 
						CommonUtils.getProcedureValue(statusBean.getCS_STATUS_DT()), 
						statusBean.getCS_REASON_CODE(), 
						statusBean.getCS_REMARKS());
			
				new CommonUtils().doComitt();
				
				// TODO HIDE_WINDOW('PT_IL_CLAIM_STATUS');
				outcome = "claimsEntry";
				CommonUtils.setGlobalObject("GLOBAL.M_CLM_SYS_ID",claimBean.getCLAIM_SYS_ID());
				
				// Preparing to requery
				//PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
				//CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION", compositeAction);
				//compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_SYS_ID(
						//claimBean.getCLAIM_SYS_ID());
				PT_IL_CLAIM_HELPER claimHelper = new PT_IL_CLAIM_HELPER();
				claimHelper.executeQuery(compositeAction.getPT_IL_CLAIM_ACTION_BEAN());
				claimHelper.postQuery(compositeAction);
				//TODO need to uncomment claimHelper.onPopulateDetails();
				PT_IL_CLAIM_STATUS_1_HELPER status1Helper = new PT_IL_CLAIM_STATUS_1_HELPER();
				PT_IL_CLAIM_STATUS_1_DELEGATE status1Delegate = new PT_IL_CLAIM_STATUS_1_DELEGATE();
				status1Helper.executeQuery(compositeAction);
				status1Delegate.postQuery(compositeAction.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN());
				statusBean = compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN();
				values = new Object[]{claimBean.getCLAIM_POL_NO()};
				resultSet8 = handler.executeSelectStatement(CURSOR_C8, connection, values);
				if(resultSet8.next()){
					M_DUMMY = resultSet8.getString(1);
				}
				
				// GO_ITEM('PT_IL_CLAIM.CLAIM_POL_NO');
				values = new Object[]{claimBean.getCLAIM_SYS_ID()};
				resultSet2 = handler.executeSelectStatement(CURSOR_C2, connection, values);
				if(resultSet2.next()){
					M_CS_SYS_ID = resultSet2.getLong(1);
				}
				
				values = new Object[]{claimBean.getCLAIM_SYS_ID(), M_CS_SYS_ID};
				resultSet3 = handler.executeSelectStatement(CURSOR_C3, connection, values);
				if(resultSet3.next()){
					M_CS_STATUS_CODE = resultSet3.getString(1);
				}
				//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
				if(M_CS_STATUS_CODE!=null && !M_CS_STATUS_CODE.equalsIgnoreCase("D05")){
					System.out.println("******************ENTER INTO M_CS_STATUS_CODE******");
					compositeAction.getWizard().enableWizardItem("claimCoverDetails");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
					  compositeAction.getWizard().enableWizardItem("toDoGroup");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
					  compositeAction.getWizard().enableWizardItem("reminders");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
					  compositeAction.getWizard().enableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
					  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
					  compositeAction.getWizard().enableWizardItem("claimCharge");
					 /* end*/
					 }else{
						
						  compositeAction.getWizard().disableWizardItem("claimCoverDetails");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_ESTIMATE");
						  compositeAction.getWizard().disableWizardItem("toDoGroup");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS");
						  compositeAction.getWizard().disableWizardItem("reminders");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_CLAIM_STATUS_3");
						  compositeAction.getWizard().disableWizardItem("PILT006_APAC_PT_IL_FUND_TRAN_DTL");
						  /*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017*/
						  compositeAction.getWizard().disableWizardItem("claimCharge");
						 /* end*/
						  
					}
				String Status_code=compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().getCS_STATUS_CODE();
				if(Status_code!=null && Status_code.equalsIgnoreCase("CL05")){
					System.out.println("******************ENTER INTO M_CS_STATUS_CODE******");
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISABLITY().setDisabled(true);
				}else{
						 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_DISABLITY().setDisabled(false); 
						
					 }
				//END
				
				
				//COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
				
				/*if(2 == dummyBean.getM_CALC_METHOD()){
					values = new Object[]{M_CS_STATUS_CODE};
					resultSet4 = handler.executeSelectStatement(CURSOR_C4, connection, values);
					if(resultSet4.next()){
						dummyBean.setM_CLAIM_STATUS(resultSet4.getString(1));
					}else{
						dummyBean.setM_CLAIM_STATUS(Messages.getString("messageProperties_PILT006_APAC", 
								"PILT006_APAC$DUMMY$M_CLAIM_STATUS$VALUE$REGISTERED"));
					}
				}
				*/
				values = new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1 ")};
				resultSet6 = handler.executeSelectStatement(CURSOR_C6, connection, values);
				if(resultSet6.next()){
					M_DS_TYPE = resultSet6.getString(1);
				}
				
				values = new Object[]{ctrlBean.getUI_M_USER_ID(), dummyBean.getM_POL_PROD_CODE()};
				resultSet7 = handler.executeSelectStatement(CURSOR_C7, connection, values);
				if(resultSet7.next()){
					M_ASD_CHAR_VALUE = resultSet7.getString(1);
					if("N".equals(CommonUtils.nvl(M_ASD_CHAR_VALUE, "N"))){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
								"91158"));
					}
				}
				
				if(1 == dummyBean.getM_CALC_METHOD()){
					if("4".equals(M_DS_TYPE)){
						dummyBean.setM_PRINT_TYPE("B");
						LIFELIB.L_PRINT_STATUS(
								CommonUtils.getProcedureValue(claimBean.getCLAIM_POL_SYS_ID()), 
								CommonUtils.getProcedureValue(claimBean.getCLAIM_SYS_ID()), 
								CommonUtils.getGlobalVariable("GLOBAL:M_PARA_1"), 
								statusBean.getCS_STATUS_CODE(), 
								ctrlBean.getUI_M_USER_ID(), 
								dummyBean.getM_PRINT_TYPE());
					}
				}
			}
			
			
			/*Added by saritha on 06-Mar-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
			 email should be sent to finance user.
			 *
			 */
			String status_code=compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().getCS_STATUS_CODE();
			System.out.println("status code    "+status_code);

			if((status_code.equalsIgnoreCase("CL05"))){
				
				/*added by raja to discuee with siva sir on 19-06-2017*/
				if(M_DUMMY!=null && (M_DUMMY.equalsIgnoreCase("L") || M_DUMMY.equalsIgnoreCase("H")))
				{
				
				P_CALC_PREMIUM_FUNERAL(claimBean.getCLAIM_POL_SYS_ID().toString(),claimBean.getCLAIM_SYS_ID().toString(),claimBean.getCLAIM_MEMB_CODE());
				}
				
				/*end*/

			 	System.out.println("pol no::::"+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO());
			 	String pol_no=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO();
				String C1 ="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO=?";
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {pol_no});
				while(resultSet.next()) {
					product_code =resultSet.getString("POL_PROD_CODE");
					System.out.println("product code::::"+product_code);
				}

				long pol_sys_id = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
				System.out.println("pol_sys_id--------------"+pol_sys_id);

				/*added by raja on 30-05-2017 for ZBILQC-1726955 */
				String P_CUST_TYPE=" ";
				
				
				/*Added by Janani on 20.06.2017 for ZBILQC-1721256*/
				
				long claim_sys_id = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
				
				System.out.println("claim_sys_id in claim email                  "+claim_sys_id);
				
				
				//String emailStatusMessage1 = Email_Procedure_Call.emailStatusMsg(product_code,"CLM",String.valueOf(pol_sys_id),"U","");
				
				String emailStatusMessage1 = Email_Procedure_Call.claim_emailStatusMsg(product_code,"CLM",String.valueOf(pol_sys_id),"U","",String.valueOf(claim_sys_id));
				
				/*End*/
				
				message = message + emailStatusMessage1;
				/*end*/
				
				
				/*commented one extra parameter by raja on 15-05-2017*/
				String emailStatusMessage = emailStatusMsg(product_code,"RIER",String.valueOf(pol_sys_id),"RE","",
						compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID().toString());
				message = message + emailStatusMessage;
				/*end*/
				//Added by ganesh on 21-06-2017
				System.out.println("Mail information mgs-->"+message);

			}
			 
			/*emailTriggerProcCall();*/
			
			/*End*/	
			
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet2);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet3);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet4);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet5);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet6);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet7);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet8);}catch(Exception exc){}
		}
		
		return outcome;
	}
	
	/*Added by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturtiy and partial withdrwal) 
	 email should be sent to finance user.
	 *
	 */
	
	/*public String emailTriggerProcCall() throws Exception{
		   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'CLM'";
		   	String tomail="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_GROUP_ID='FINUSER'";
		   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
		   	String out="N";
		   	ResultSet rs2=null;
		   	ResultSet rs3=null;
		   
		   	int seqno = 0;
		   	String productcode = null;
		   	String sub = null;
		   	String body = null;
		   	String mailid = null;
		   	Connection con=CommonUtils.getConnection();
		   	System.out.println("Connection :"+con);

		   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
		   	rs3=new CRUDHandler().executeSelectStatement(tomail, con);
		  
		   	if(rs2.next()){
		   		productcode=rs2.getString("PMT_PROD_CODE");
		   		sub=rs2.getString("PMT_MAIL_SUB");
		   		body=rs2.getString("PMT_MAIL_TEXT");
		   	}
		   	while(rs3.next()){
		   		mailid=rs3.getString("USER_EMAIL_ID");
		   		if(mailid!=null){
		   			Object[] values1 = {"CLM",mailid,sub,body,"N" };
				   	new CRUDHandler().executeInsertStatement(insert, con, values1);
				   	con.commit();
		   			
		   		out="Y";
		   		}
		   	}
		   	System.out.println("seqno  :"+seqno);
		   	System.out.println("mailid  :"+mailid);
			System.out.println("sub  :"+sub);
			System.out.println("body  :"+body);
		   	
			return out;
		}*/
	/*End*/
		 
		
	 /*Added by saritha on 05-Mar-2017 for ssp call id ZBILQC-1719135*/
	 public void PRE_UPDATE(PILT006_APAC_COMPOSITE_ACTION compositeAction)
				throws Exception {
		 
		 System.out.println("enter into PRE_UPDATE");
		 
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, Object> session = fc.getExternalContext().getSessionMap();
		
			PT_IL_CLAIM_STATUS_1 pt_il_claim_status_1_bean = compositeAction
					.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN().getPT_IL_CLAIM_STATUS_1_BEAN();
			
			try {
				
				pt_il_claim_status_1_bean.setCS_STATUS_DT(new CommonUtils().getCurrentDate());
				/*pt_il_claim_status_1_bean.setCS_STATUS_UID(CommonUtils.getControlBean()
						.getM_USER_ID());*/
				pt_il_claim_status_1_bean.setCS_STATUS_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				
				System.out.println("CS_STATUS_DT               :"+pt_il_claim_status_1_bean.getCS_STATUS_DT());
				System.out.println("CS_STATUS_UID               :"+pt_il_claim_status_1_bean.getCS_STATUS_UID());
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				try {
				
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
	 
	 /*End*/
	 
	 
	 /*ADDED BY RAJA ON 5-05-2017*/
	 public static String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,String P_CLAIM_SYS_ID, Connection con) throws Exception{
			
			/*Connection con=CommonUtils.getConnection();*/
			System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
			String out="";
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
			  parameterList.add(param1); 
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
			  parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
			  parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
			  parameterList.add(param4);
			  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
			  parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
		    parameterList.add(param6);
		    OracleParameter param7 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_SYS_ID);
			  parameterList.add(param7);
		    OracleProcedureHandler procHandler = new OracleProcedureHandler();
		    outputList = procHandler.execute(parameterList, con,
		            "P_MAIL_TEMP");
		    /*con.commit() Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		    /* CommonUtils.doComitt();*/
		    con.commit();
		   /* End*/
		    Iterator<OracleParameter> iterator = outputList.iterator();
		    while (iterator.hasNext()) {
		        OracleParameter oracleParameter = iterator.next();
		        System.out.println("Output value:::" + oracleParameter.getValue());
				out=(String)oracleParameter.getValue();
		    }
			return out;
			}
	    public static String emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH, String CLAIM_SYS_ID) throws Exception
	    {
	    	StringBuilder statusMessge =  new StringBuilder(" - ");
	    	/*Modified by Saranya RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 27-12-2016*/
	    	//String mailFlag = emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CLAIM_SYS_ID, CommonUtils.getConnection());
	    	String mailFlag = CommonUtils.nvl(emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CLAIM_SYS_ID, CommonUtils.getConnection()),"N");
	    	/*End*/
	    	System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");
	    	
	    	if((P_CUST_TYPE.equalsIgnoreCase("B"))){
	    		
	    		if(mailFlag.equals("YY")){
	    			
	    			statusMessge.append("Mail sent sucessfully");
	    			
	    		}else if(mailFlag.equals("T")){
	    			
	    			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));
	    		    			
	    		}else if(mailFlag.equalsIgnoreCase("NN")){
	    			
	    			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
	    				
	    		}else if(mailFlag.equalsIgnoreCase("NY")){
	    			
	    			statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
	    				
	    		}else if(mailFlag.equalsIgnoreCase("YN")){
	    			
	    			statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
	    				
	    		}
	    		
	    	}else{
	    		
	    		if(mailFlag.equals("Y")){
	    			
	    			statusMessge.append("Mail sent sucessfully");
	    			
	    		}else if(mailFlag.equals("T")){
	    			
	    			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));
	    		    			
	    		}else {
	    			
	    			if(P_CUST_TYPE.equalsIgnoreCase("C")){
	    				statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
	    			}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
	    				statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
	    			}
	    			
	    		}
	  		
	    		
	    	}
	    	
	    	
	    	return statusMessge.toString();   
	    	
	    	
	    	
	    }
	    
	    private static String templateDescription(String templateCode){
	    	
	    	String selectTemplateDescQuery = "SELECT initcap(LIV_CODE_DESC) FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ?";
	    	StringBuilder selectTemplateDesc = null;
	    	CRUDHandler handler =  new CRUDHandler();
	    	Connection con = null;
	    			
	    	try {
	    		con = CommonUtils.getConnection();
	    		selectTemplateDesc = new StringBuilder(""); 
				ResultSet rs1=handler.executeSelectStatement(selectTemplateDescQuery, con, new Object[]{templateCode});
				if(rs1.next()){
					selectTemplateDesc.append("for ").append(rs1.getString(1));
					
				}
				System.out.println("Template Description --->["+selectTemplateDesc+"]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return selectTemplateDesc.toString();
	    }

	 /*END*/
	    
	    
	    
	    /*added by raja to discuee with siva sir on 19-06-2017*/
	    
	    public ArrayList<OracleParameter> P_CALC_PREMIUM_FUNERAL(
                String P_CLAIM_POL_SYS_ID,    
     String P_CLAIM_SYS_ID,
     String P_MEMBER_CODE) throws ProcedureException {
   Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
      OracleParameter param1 = new OracleParameter("IN1", "LONG", "IN",P_CLAIM_POL_SYS_ID);
      parameterList.add(param1);
      OracleParameter param2 = new OracleParameter("IN2", "LONG", "IN",P_CLAIM_SYS_ID);
      parameterList.add(param2);
      OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_MEMBER_CODE);
      parameterList.add(param3);
     
     OracleProcedureHandler procHandler = new OracleProcedureHandler();
      outputList = procHandler.execute(parameterList, connection,
             "P9ILPK_F_POLICY.P_UPD_FUNERAL_MOP_PREM");
   } catch(Exception e) {
	  e.printStackTrace();
   	ErrorHelpUtil.getErrorForProcedure(connection);
          throw new ProcedureException(e.getMessage());
   }
  return outputList;
}

	
	    /*end*/
	    
}
