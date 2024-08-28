package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM054_APAC.DB_PROCEDURES;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_IF_ACCNT_SETUP_HDR_HELPER {

	public void preRecord() {
		// L_SET_TYPE_BL();
	}

	public void preBlock(CTRL CTRL_BEAN) {
		CTRL_BEAN.setUI_M_DELETE_MSG_FLAG("Y");
	}

	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void preInsert(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN)
			throws Exception {
		String C1 = "SELECT	P_PIFH_SYS_ID.NEXTVAL FROM	DUAL";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn);
			if (C1_REC.next()) {
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_SYS_ID(C1_REC.getLong(1));
			}

			PILM072_APAC_Procedure procedure = new PILM072_APAC_Procedure();
			procedure.L_UNIQUE_RANGE(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);//Duplicate Check
			
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());

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
	public void preUpdate(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN)
			throws Exception {
		PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		PILM072_APAC_Procedure procedure = new PILM072_APAC_Procedure();
		procedure.L_UNIQUE_RANGE(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);//Duplicate Check
	}
	
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @param DUMMY_BEAN
	 */
	public void postQuery(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN,DUMMY DUMMY_BEAN) throws Exception{
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
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE() != null) {
				mainAcctCodeDesc = DB_PROCEDURES.L_VAL_MAIN_ACNT(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE(), mainAcctCodeDesc, "N", "N");
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_MAIN_ACNT_NAME(mainAcctCodeDesc);
			}
				
				
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE() != null) {
				ArrayList<String> subAcntList = DB_PROCEDURES.P_VAL_SUB_ACNT(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE(), subAcctCodeDesc, "N", "N");
				if(subAcntList!=null && subAcntList.size()>0){
					subAcctCodeDesc = subAcntList.get(0);
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_SUB_ACNT_NAME(subAcctCodeDesc);
				}
			}	
				
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1() != null) {
				ArrayList<String> anly1List = DB_PROCEDURES.P_VAL_ANLY("1", PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1(), "N", "N");
				if(anly1List!=null && anly1List.size()>0){
					anlyCode1Desc = anly1List.get(0);
				}
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_ANLY_NAME(anlyCode1Desc);
			}
				
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2() != null) {
				ArrayList<String>  anly2List = DB_PROCEDURES.P_VAL_ANLY("2", PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2(), "N", "N");
				if(anly2List!=null && anly2List.size()>0){
					anlyCode2Desc = anly2List.get(0);
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_ANLY_NAME_1(anlyCode2Desc);
				}
			}
			
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_1() != null) {
				ArrayList<String> acty1List = DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_1(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1(), "N", "N");
				if(acty1List!=null && acty1List.size()>0){
					actyCode1Desc = acty1List.get(0);
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_ACTY_NAME(actyCode1Desc);
				}
			}

			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_2() != null) {
				ArrayList<String> acty2List = DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_2(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2(), "N", "N");
				if(acty2List!=null && acty2List.size()>0){
					actyCode2Desc = acty2List.get(0);
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_ACTY_NAME_1(actyCode2Desc);
				}
			}
				
			
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE() != null) {
				ArrayList<String> divnList = DB_PROCEDURES.F_VAL_DIVN(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(), "N", "N");
				if(divnList!=null && divnList.size()>0){
					divisionCodeDesc = divnList.get(0);
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_DIVN_NAME(divisionCodeDesc);
				}
				
			}

			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE() != null) {
				ArrayList<String> deptList = DB_PROCEDURES.F_VAL_DEPT(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE(), "N", "N");
				if(deptList!=null && deptList.size()>0){
					deptCodeDesc = deptList.get(0);
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setUI_M_DEPT_NAME(deptCodeDesc);
				}
				
			}
        }catch(Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
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

	
	public void whenCreateRecord(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN){
		PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_DRCR_FLAG("D");
	}
	
	
	public void whenNewRecordInstance(PM_IL_IF_ACCNT_SETUP_HDR_ACTION PM_IL_IF_ACCNT_SETUP_ACTION,
			DUMMY DUMMY_BEAN) throws Exception{
		String C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2  FROM   FM_MAIN_ACCOUNT   WHERE  MAIN_ACNT_CODE = ? ";
		String C2 = "SELECT ACTY_NAME  FROM   FM_ACTIVITY   WHERE  ACTY_CODE = ? ";
		String C3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY   WHERE  ACTY_CODE = ? ";
		PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN = PM_IL_IF_ACCNT_SETUP_ACTION.getPM_IL_IF_ACCNT_SETUP_HDR_BEAN();

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
			C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE()});
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
				PM_IL_IF_ACCNT_SETUP_ACTION.getCOMP_PIFH_ACTY_CODE_1_LABEL().setValue("Activity Code1");
			 }
			
			 if(DUMMY_BEAN.getUI_M_ACTY_2()!=null){
				 C3_REC = handler.executeSelectStatement(C3, conn, new Object[]{DUMMY_BEAN.getUI_M_ACTY_2()});
				 while(C3_REC.next()){
					 M_TEMP2 = C3_REC.getString(1);
					 PM_IL_IF_ACCNT_SETUP_ACTION.getCOMP_PIFH_ACTY_CODE_2_LABEL().setValue(CommonUtils.initCap(M_TEMP2));
				 }
			} else {
				PM_IL_IF_ACCNT_SETUP_ACTION.getCOMP_PIFH_ACTY_CODE_2_LABEL().setValue("Activity Code2");
			 }
			 
		

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
	public void preDelete(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
		String C1 = "DELETE FROM PM_IL_IF_ACCNT_SETUP_DTL P  WHERE P.PIFD_PIFH_SYS_ID = ? ";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			int deleteInt = handler.executeDeleteStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SYS_ID()});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
	public void onCheckDeleteMaster(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
		String Dummy_Define = null;
		String C1 = "SELECT 1 FROM PM_IL_IF_ACCNT_SETUP_DTL P  WHERE P.PIFD_PIFH_SYS_ID = ? ";
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SYS_ID()});
			if(C1_REC.next()){
				Dummy_Define = C1_REC.getString(1);
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "Cannot delete master record when matching detail records exist."));*/
				throw new Exception("Cannot delete master record when matching detail records exist.");
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
	public void whenValidateMainAcctCode(PM_IL_IF_ACCNT_SETUP_HDR_ACTION PM_IL_IF_ACCNT_SETUP_HDR_ACTION,DUMMY DUMMY_BEAN) throws Exception{
		String C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM   FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE = ? ";
		String C2 = "SELECT ACTY_NAME FROM   FM_ACTIVITY  WHERE  ACTY_CODE = ? ";
		String C3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY  WHERE  ACTY_CODE = ? ";
		String C4 = "SELECT MAIN_ACNT_CODE,MAIN_CTL_ACNT_FLAG   FROM   FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE = ?";
		
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		String M_FOUND = null;
		String FLAG = null;
		PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN =  PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getPM_IL_IF_ACCNT_SETUP_HDR_BEAN();
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE()!=null){
				C4_REC = handler.executeSelectStatement(C4, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE()});
				if(C4_REC.next()){
					M_TEMP1 = C4_REC.getString(1);
					FLAG = C4_REC.getString(2);
					if ("C".equals(FLAG)) {
						PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_SUB_ACNT_CODE().setDisabled(false);
						PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_SUB_ACNT_CODE().setRequired(true);
					}else if("M".equals(FLAG)){
						PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_SUB_ACNT_CODE().setDisabled(true);
						PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_SUB_ACNT_CODE().setRequired(false);
					}
				}else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80025"));
				}
					

				PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_ACTY_CODE_1().setDisabled(false);
				PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_ACTY_CODE_2().setDisabled(false);
				DB_PROCEDURES.L_VAL_MAIN_ACNT(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE(), null, "N", "E");
				
				
				
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE()});
				if(C1_REC.next()){
					DUMMY_BEAN.setUI_M_ACTY_1(C1_REC.getString(1));
					DUMMY_BEAN.setUI_M_ACTY_2(C1_REC.getString(2));
				}
				
				if(DUMMY_BEAN.getUI_M_ACTY_1()!=null){
					C2_REC = handler.executeSelectStatement(C2, conn,new Object[]{DUMMY_BEAN.getUI_M_ACTY_1()});
					if(C2_REC.next()){
						M_TEMP1 = C2_REC.getString(1);
						PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_ACTY_CODE_1().setDisabled(false);
					}
				}else{
					PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_ACTY_CODE_1().setDisabled(true);
				}
				
				if(DUMMY_BEAN.getUI_M_ACTY_2()!=null){
					C3_REC = handler.executeSelectStatement(C3, conn,new Object[]{DUMMY_BEAN.getUI_M_ACTY_2()});
					if(C2_REC.next()){
						M_TEMP2 = C3_REC.getString(1);
						PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_ACTY_CODE_2().setDisabled(false);
					}
				}else{
					PM_IL_IF_ACCNT_SETUP_HDR_ACTION.getCOMP_PIFH_ACTY_CODE_2().setDisabled(true);
				}

				
			}
			
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
			try {
				CommonUtils.closeCursor(C4_REC);
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
	public void whenValidateSubAcctCode(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
		String C1 = " SELECT MS_SUB_ACNT_CODE FROM   FM_MAIN_SUB WHERE  MS_SUB_ACNT_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1014"));
				}
				DB_PROCEDURES.P_VAL_SUB_ACNT(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE(), "N", "E");
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
	public void whenValidateDivisionCode(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
		String C1 = " SELECT DIVN_CODE FROM FM_DIVISION WHERE DIVN_CODE= ?";
		
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;
		
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE()!=null){
				C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE()});
				if(C1_REC.next()){
					M_FOUND = C1_REC.getString(1);
				}
				if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1002"));
				}
				DB_PROCEDURES.F_VAL_DIVN(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(), "N", "E");
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
		public void whenValidateDeptCode(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
			String C1 = " SELECT DEPT_CODE FROM FM_DEPARTMENT WHERE DEPT_DIVN_CODE= ?";
			
			Connection conn = null;
			CRUDHandler handler = null;
			ResultSet C1_REC = null;
			String M_FOUND = null;
			
			try {
				handler = new CRUDHandler();
				conn = CommonUtils.getConnection();
				if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE()!=null){
					C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE()});
					if(C1_REC.next()){
						M_FOUND = C1_REC.getString(1);
					}
					if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1351"));
					}
					DB_PROCEDURES.F_VAL_DEPT(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE(), "N", "E");
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
		public void whenValidateAnlyCode_1(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
			String C1 = " SELECT ANLY_CODE FROM FM_ANALYSIS WHERE ANLY_CODE= ?";
			
			Connection conn = null;
			CRUDHandler handler = null;
			ResultSet C1_REC = null;
			String M_FOUND = null;
			
			try {
				handler = new CRUDHandler();
				conn = CommonUtils.getConnection();
				if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1()!=null){
					C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1()});
					if(C1_REC.next()){
						M_FOUND = C1_REC.getString(1);
					}
					if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "OP_456"));
					}
					DB_PROCEDURES.P_VAL_ANLY("1", PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1(), "N", "E");
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
		public void whenValidateAnlyCode_2(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
			String C1 = " SELECT ANLY_CODE FROM FM_ANALYSIS WHERE ANLY_CODE= ?";
			
			Connection conn = null;
			CRUDHandler handler = null;
			ResultSet C1_REC = null;
			String M_FOUND = null;
			
			try {
				handler = new CRUDHandler();
				conn = CommonUtils.getConnection();
				if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2()!=null){
					C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2()});
					if(C1_REC.next()){
						M_FOUND = C1_REC.getString(1);
					}
					if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "OP_456"));
					}
					DB_PROCEDURES.P_VAL_ANLY("2", PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2(), "N", "E");
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
			public void whenValidateActyCode_1(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN,DUMMY DUMMY_BEAN) throws Exception{
				String C1 = " SELECT AVAL_CODE FROM FM_ACTY_VALUE WHERE AVAL_CODE= ?";
				
				Connection conn = null;
				CRUDHandler handler = null;
				ResultSet C1_REC = null;
				String M_FOUND = null;
				
				try {
					handler = new CRUDHandler();
					conn = CommonUtils.getConnection();
					if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_1()!=null){
						C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_1()});
						if(C1_REC.next()){
							M_FOUND = C1_REC.getString(1);
						}
						if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "1016"));
						}
						DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_1(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1(), "N", "E");
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
			public void whenValidateActyCode_2(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN,DUMMY DUMMY_BEAN) throws Exception{
				String C1 = " SELECT AVAL_CODE FROM FM_ACTY_VALUE WHERE AVAL_CODE= ?";
				
				Connection conn = null;
				CRUDHandler handler = null;
				ResultSet C1_REC = null;
				String M_FOUND = null;
				
				try {
					handler = new CRUDHandler();
					conn = CommonUtils.getConnection();
					if(PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_2()!=null){
						C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_2()});
						if(C1_REC.next()){
							M_FOUND = C1_REC.getString(1);
						}
						if(M_FOUND==null || "".equalsIgnoreCase(M_FOUND)){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "1016"));
						}
						//DB_PROCEDURES.P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_2(), PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2(), "N", "E");
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
					PM_IL_IF_ACCNT_SETUP_HDR_DELEGATE pm_il_if_accnt_setup_hdr_delegate = new PM_IL_IF_ACCNT_SETUP_HDR_DELEGATE();
					pm_il_if_accnt_setup_hdr_delegate.executeSelectStatement(compositeAction);
				}catch(Exception exception){
					throw exception;
				}
			}
}