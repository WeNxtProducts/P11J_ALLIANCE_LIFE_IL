package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM054_APAC.DB_PROCEDURES;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;



public class PM_IL_IF_ACCNT_SETUP_DTL_HELPER {
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void preInsert(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN,PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN)
			throws Exception {
		String C1 = "SELECT	P_PIFD_SYS_ID.NEXTVAL FROM	DUAL";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn);
			if (C1_REC.next()) {
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_SYS_ID(C1_REC.getLong(1));
			}

			PILM072_APAC_Procedure procedure = new PILM072_APAC_Procedure();
			procedure.L_UNIQUE_RANGE_DTL(PM_IL_IF_ACCNT_SETUP_DTL_BEAN, PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
			
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());

			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_PIFH_SYS_ID(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SYS_ID());
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
	
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_ACTION
	 * @param DUMMY_BEAN
	 * @throws Exception
	 */
	public void whenNewRecordInstance(PM_IL_IF_ACCNT_SETUP_DTL_ACTION PM_IL_IF_ACCNT_SETUP_DTL_ACTION,
			DUMMY DUMMY_BEAN) throws Exception{
		String C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2  FROM   FM_MAIN_ACCOUNT   WHERE  MAIN_ACNT_CODE = ? ";
		String C2 = "SELECT ACTY_NAME  FROM   FM_ACTIVITY   WHERE  ACTY_CODE = ? ";
		String C3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY   WHERE  ACTY_CODE = ? ";
		PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN = PM_IL_IF_ACCNT_SETUP_DTL_ACTION.getPM_IL_IF_ACCNT_SETUP_DTL_BEAN();

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE()});
			if (C1_REC.next()) {
				DUMMY_BEAN.setUI_M_ACTY_1(C1_REC.getString(1));
				DUMMY_BEAN.setUI_M_ACTY_2(C1_REC.getString(2));
			}

			 if(DUMMY_BEAN.getUI_M_ACTY_1()!=null){
				 C2_REC = handler.executeSelectStatement(C2, conn, new Object[]{DUMMY_BEAN.getUI_M_ACTY_1()});
				 while(C2_REC.next()){
					 M_TEMP1 = C2_REC.getString(1);
				 }
			} else {
				PM_IL_IF_ACCNT_SETUP_DTL_ACTION.getCOMP_PIFD_ACTY_CODE_1_LABEL().setValue("Activity Code1");
			 }
			
			 if(DUMMY_BEAN.getUI_M_ACTY_2()!=null){
				 C3_REC = handler.executeSelectStatement(C3, conn, new Object[]{DUMMY_BEAN.getUI_M_ACTY_2()});
				 while(C3_REC.next()){
					 M_TEMP2 = C3_REC.getString(1);
					 PM_IL_IF_ACCNT_SETUP_DTL_ACTION.getCOMP_PIFD_ACTY_CODE_2_LABEL().setValue(CommonUtils.initCap(M_TEMP2));
				 }
			} else {
				PM_IL_IF_ACCNT_SETUP_DTL_ACTION.getCOMP_PIFD_ACTY_CODE_2_LABEL().setValue("Activity Code2");
			 }
			 
			 /*IF :SYSTEM.CURSOR_ITEM IN ('PM_IL_IF_ACCNT_SETUP_HDR.PIFH_DIVN_CODE','PM_IL_IF_ACCNT_SETUP_HDR.PIFH_DEPT_CODE',
						'PM_IL_IF_ACCNT_SETUP_HDR.PIFH_ACTY_CODE_1','PM_IL_IF_ACCNT_SETUP_HDR.PIFH_ACTY_CODE_2') THEN
GO_ITEM('PM_IL_IF_ACCNT_SETUP_HDR.PIFH_MAIN_ACNT_CODE');
END IF;*/

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			try {
				CommonUtils.closeCursor(C2_REC);
			} catch (Exception exception2) {
			}
			try {
				CommonUtils.closeCursor(C3_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void preUpdate(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN,PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN)
			throws Exception {
			try {
			PILM072_APAC_Procedure procedure = new PILM072_APAC_Procedure();
			procedure.L_UNIQUE_RANGE_DTL(PM_IL_IF_ACCNT_SETUP_DTL_BEAN, PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
			
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} 
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @param DUMMY_BEAN
	 */
	public void postQuery(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN,DUMMY DUMMY_BEAN) throws Exception{
		String mainAcctCodeDesc = null;
		String subAcctCodeDesc = null;
		String anlyCode1Desc = null;
		String anlyCode2Desc = null;
		String actyCode1Desc = null;
		String actyCode2Desc = null;
		String divisionCodeDesc = null;
		String deptCodeDesc = null;
		String subAcctQuery = "SELECT MS_SUB_ACNT_NAME FROM FM_MAIN_SUB WHERE MS_SUB_ACNT_CODE = ?";
		String activityDescQuery = "SELECT AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_CODE = ?";

		
		try {
			mainAcctCodeDesc = DB_PROCEDURES.L_VAL_MAIN_ACNT(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE(), mainAcctCodeDesc, "N", "N");

			ArrayList<String> subAcntList = DB_PROCEDURES.P_VAL_SUB_ACNT(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE(), subAcctCodeDesc, "N", "N");
			if(subAcntList!=null && subAcntList.size()>0){
				subAcctCodeDesc = subAcntList.get(0);
			}
			//DB_PROCEDURES.L_GET_ACTY_DETAILS();
			
			ArrayList<String> anly1List = DB_PROCEDURES.P_VAL_ANLY("1", PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1(), "N", "N");
			if(anly1List!=null && anly1List.size()>0){
				anlyCode1Desc = anly1List.get(0);
			}
			ArrayList<String>  anly2List = DB_PROCEDURES.P_VAL_ANLY("2", PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2(), "N", "N");
			if(anly2List!=null && anly2List.size()>0){
				anlyCode2Desc = anly2List.get(0);
			}
			ArrayList<String> acty1List = DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_1(), PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1(), "N", "N");
			if(acty1List!=null && acty1List.size()>0){
				actyCode1Desc = acty1List.get(0);
			}
			ArrayList<String> acty2List = DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_2(), PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2(), "N", "N");
			if(acty2List!=null && acty2List.size()>0){
				actyCode2Desc = acty2List.get(0);
			}
			
			ArrayList<String> divnList = DB_PROCEDURES.F_VAL_DIVN(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(), "N", "N");
			if(divnList!=null && divnList.size()>0){
				divisionCodeDesc = divnList.get(0);
			}
			//
			ArrayList<String> deptList = DB_PROCEDURES.F_VAL_DEPT(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(), PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DEPT_CODE(), "N", "N");
			if(deptList!=null && deptList.size()>0){
				deptCodeDesc = deptList.get(0);
			}
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_MAIN_ACNT_CODE_DESC(mainAcctCodeDesc);
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_SUB_ACNT_CODE_DESC(subAcctCodeDesc!=null ? subAcctCodeDesc : getDescFromCode(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE(), subAcctQuery));
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_PIFD_ANLY_CODE_1_DESC(anlyCode1Desc);
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_PIFD_ANLY_CODE_2_DESC(anlyCode2Desc);
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_PIFD_ACTY_CODE_1_DESC(actyCode1Desc!=null ? actyCode1Desc : getDescFromCode(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_1(), activityDescQuery));
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_PIFD_ACTY_CODE_2_DESC(actyCode2Desc!=null ? actyCode2Desc : getDescFromCode(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_2(), activityDescQuery));
			/*PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_DIVN_NAME(divisionCodeDesc);
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setUI_M_DEPT_NAME(deptCodeDesc);*/
			
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
	}
	
	/**
	 * Generic method to get the desc from code.
	 * @param code
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public String getDescFromCode(String code,String query) throws Exception{
		String desc = null;
		Connection connection = null;
		ResultSet set = null;
		CRUDHandler handler = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			set = handler.executeSelectStatement(query, connection,new Object[]{code});
			if(set.next()){
				desc = set.getString(1);
			}
		}catch(Exception exception){
			throw exception;
		}
		return desc;
	}
	
	/**
	 * 
	 * @param pm_il_if_accnt_setup_dtl
	 */
	public void whenCreateRecord(PM_IL_IF_ACCNT_SETUP_DTL pm_il_if_accnt_setup_dtl){
		pm_il_if_accnt_setup_dtl.setPIFD_DRCR_FLAG("D");
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_ACTION
	 * @param DUMMY_BEAN
	 * @throws Exception
	 */
	public void whenValidateMainAcctCode(PM_IL_IF_ACCNT_SETUP_DTL_ACTION PM_IL_IF_ACCNT_SETUP_DTL_ACTION,DUMMY DUMMY_BEAN) throws Exception{
		String C1 = "SELECT MAIN_ACNT_CODE FROM   FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE = ? ";
				
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		String M_FOUND = null;
		PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN =  PM_IL_IF_ACCNT_SETUP_DTL_ACTION.getPM_IL_IF_ACCNT_SETUP_DTL_BEAN();
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80025",
							new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
				}
				
				DB_PROCEDURES.L_VAL_MAIN_ACNT(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE(), null, "N", "N");
			
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
			
		}
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_ACTION
	 * @param DUMMY_BEAN
	 * @throws Exception
	 */
	public void whenValidateSubAcctCode(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN) throws Exception{
		String C1 = " SELECT MS_SUB_ACNT_CODE FROM   FM_MAIN_SUB WHERE  MS_SUB_ACNT_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1014"));
				}
				DB_PROCEDURES.P_VAL_SUB_ACNT(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE(), null, "N", "N");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void whenValidateDivisionCode(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN) throws Exception{
		String C1 = " SELECT DIVN_CODE FROM FM_DIVISION WHERE DIVN_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1002"));
				}
				DB_PROCEDURES.F_VAL_DIVN(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(), "N", "E");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void whenValidateDeptCode(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN) throws Exception{
		String C1 = " SELECT DEPT_CODE FROM FM_DEPARTMENT WHERE DEPT_DIVN_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DEPT_CODE()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1351"));
				}
				DB_PROCEDURES.F_VAL_DEPT(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(), PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DEPT_CODE(), "N", "E");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_DTL_BEAN
	 * @throws Exception
	 */
	public void whenValidateAnlyCode_1(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN) throws Exception{
		String C1 = " SELECT ANLY_CODE FROM FM_ANALYSIS WHERE ANLY_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "OP_456"));
				}
				DB_PROCEDURES.P_VAL_ANLY("1", PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1(), "N", "E");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_DTL_BEAN
	 * @throws Exception
	 */
	public void whenValidateAnlyCode_2(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN) throws Exception{
		String C1 = " SELECT ANLY_CODE FROM FM_ANALYSIS WHERE ANLY_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "OP_456"));
				}
				DB_PROCEDURES.P_VAL_ANLY("2", PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2(), "N", "E");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
		/**
		 * 
		 * @param PM_IL_IF_ACCNT_SETUP_DTL_BEAN
		 * @throws Exception
		 */
		public void whenValidateActyCode_1(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN,DUMMY DUMMY_BEAN) throws Exception{
			String C1 = " SELECT AVAL_CODE FROM FM_ACTY_VALUE WHERE AVAL_CODE= ?";
			
			Connection conn = null;
			CRUDHandler handler = null;
			ResultSet C1_REC = null;
			String M_FOUND = null;
			
			try {
				handler = new CRUDHandler();
				conn = CommonUtils.getConnection();
				if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_1()!=null){
					C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_1()});
					if(C1_REC.next()){
						M_FOUND = C1_REC.getString(1);
					}
					if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1016"));
					}
					//DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_1(), PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1(), "N", "E");
				}
				
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			} finally {
				try {
					CommonUtils.closeCursor(C1_REC);
				} catch (Exception exception2) {
				}
				
			}
}	
		
		/**
		 * 
		 * @param PM_IL_IF_ACCNT_SETUP_DTL_BEAN
		 * @throws Exception
		 */
		public void whenValidateActyCode_2(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN,DUMMY DUMMY_BEAN) throws Exception{
			String C1 = " SELECT AVAL_CODE FROM FM_ACTY_VALUE WHERE AVAL_CODE= ?";
			
			Connection conn = null;
			CRUDHandler handler = null;
			ResultSet C1_REC = null;
			String M_FOUND = null;
			
			try {
				handler = new CRUDHandler();
				conn = CommonUtils.getConnection();
				if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_2()!=null){
					C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_2()});
					if(C1_REC.next()){
						M_FOUND = C1_REC.getString(1);
					}
					if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1016"));
					}
					//DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_2(), PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2(), "N", "E");
				}
				
			} catch (Exception exception) {
				exception.printStackTrace();
				throw exception;
			} finally {
				try {
					CommonUtils.closeCursor(C1_REC);
				} catch (Exception exception2) {
				}
				
			}
}
		
		/**
		 * 
		 * @param compositeAction
		 * @throws Exception
		 */
		public void executeQuery(PILM072_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
			try{
				PM_IL_IF_ACCNT_SETUP_DTL_DELEGATE delegate = new PM_IL_IF_ACCNT_SETUP_DTL_DELEGATE();
				delegate.executeSelectStatement(compositeAction);
			}catch(Exception exception){
				throw exception;
			}
		}
}