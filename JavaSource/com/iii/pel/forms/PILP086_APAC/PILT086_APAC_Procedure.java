/**
 * 
 */
package com.iii.pel.forms.PILP086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class PILT086_APAC_Procedure {
	
	/**
	 * 
	 */
	private static final Log log =  LogFactory.getLog(PILT086_APAC_Procedure.class);
	private static PILT086_APAC_Procedure procedure = new PILT086_APAC_Procedure();
	
	/**
	 * 
	 */
	private PILT086_APAC_Procedure(){
		
	}
	
	public static PILT086_APAC_Procedure getInstance(){
		return procedure; 
	}
	
	/**
	 * 
	 */
	public void L_INS_POL_HIBAH_PRCSS(DUMMY1 DUMMY1_BEAN) throws Exception{
		
		String M_DEATH = null;
		Double M_CL_RATE = 0.0;//             PM_IL_CLM_LIEN.CL_RATE%TYPE;
		Double M_CL_RATE_PER  = 0.0;//        PM_IL_CLM_LIEN.CL_RATE_PER%TYPE;
		Double M_CP_LC_PAID_AMT  = 0.0;//      PT_IL_CLAIM_PAID.CP_LC_PAID_AMT%TYPE;
		int M_AMT  =0;//                  NUMBER;
		Double M_HFP_HIBAH_FEE_AMT  = 0.0;//       PT_IL_HIBAH_FEE_PRCSS.HFP_HIBAH_FEE_AMT%TYPE;
		Double M_POL_SYS_ID     = 0.0;//           PT_IL_POLICY.POL_SYS_ID%TYPE;
		String M_POL_PLAN_CODE   = null;//          PT_IL_POLICY.POL_PLAN_CODE%TYPE;
		String M_POL_NO = null;
		Date M_IL_CLM_BNF_DOB =null; // DATE;
		int M_IL_CLM_BNF_AGE =0; //  NUMBER;
		int M_IL_CLM_BNF_AGE_1 =0;//   NUMBER;
		String M_DUMMY =null;// 					 VARCHAR2(1);
		int M_PS_VALUE = 0;
		
		String C1 = "SELECT POL_NO,POL_SYS_ID,POL_PLAN_CODE "
				+ "FROM   PT_IL_POLICY  "
				+ "WHERE  POL_ADDL_STATUS='H' "
				+ "AND    POL_APPRV_STATUS = 'A' "
				+ "AND    POL_NO BETWEEN ? AND ? ";
		
		String C10 = "SELECT TO_DATE(SUBSTR(CBEN_REF_ID1,1,6),'RRMMDD') "
				+ "FROM PT_IL_CLAIM_BENEFICIARY WHERE EXISTS (SELECT 1 "
				+ "FROM   PT_IL_CLAIM "
				+ "WHERE  CLAIM_POL_SYS_ID = ? "
				+ "AND    CBEN_CLAIM_SYS_ID = CLAIM_SYS_ID "
				+ "AND    CLAIM_ADDL_STATUS='H')";

		//String C11 = "SELECT MONTHS_BETWEEN(?,?) FROM DUAL";
		String C11 = "SELECT MONTHS_BETWEEN(TO_DATE(?,'dd/MM/yyyy'),TO_DATE(?,'dd/MM/yyyy')) FROM DUAL";

		
		String C8 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_DEATH'";
		
		String C9 = "SELECT CL_RATE,CL_RATE_PER FROM   PM_IL_CLM_LIEN "
				+ "WHERE  CL_COVER_CODE= ? "
				+ "AND    CL_LOSS_CODE = ? "
				+ "AND    M_IL_CLM_BNF_AGE BETWEEN CL_FM_AGE AND CL_TO_AGE "
				+ "AND    CL_BASIS = 'H'";
		
		String C10A = "SELECT SUM(CP_LC_PAID_AMT) "
				+ "FROM    PT_IL_CLAIM_PAID WHERE   EXISTS (SELECT 1 "
				+ "FROM   PT_IL_CLAIM "
				+ "WHERE  CLAIM_POL_SYS_ID = M_POL_SYS_ID "
				+ "AND    CP_CLAIM_SYS_ID = CLAIM_SYS_ID ) "
				+ "AND     CP_CLM_PAID_STATUS='A'";
		
		String C2 = "SELECT CR_HIBAH_FEE_AMT FROM   PM_IL_CLM_REPAY WHERE  CR_COVER_CODE=M_POL_PLAN_CODE";
		
		String C12 = "SELECT 'X' FROM PT_IL_HIBAH_FEE_PRCSS WHERE HFP_POL_NO = ? AND HFP_AGE = ?";
		
		String C13 = "SELECT PS_VALUE FROM   PP_SYSTEM WHERE  PS_TYPE = 'HIBAH_AGE' AND PS_CODE = 'HIBAH_AGE'";
		
		String deleteQuery = "DELETE FROM PT_IL_HIBAH_FEE_PRCSS " +
							"WHERE  " +
							"HFP_POL_NO BETWEEN ? AND ? AND NVL(HFP_ACNT_YN,'N') ='N'  "+
							"AND HFP_AGE > ? ";
		
		String insertQuery = "INSERT INTO PT_IL_HIBAH_FEE_PRCSS(HFP_SYS_ID,HFP_POL_NO,HFP_ACNT_YEAR,HFP_HFH_SYS_ID,HFP_PRCSS_YN,HFP_AGE,HFP_ACNT_YN)"+
                               "VALUES(?,?,?,?,?,?,?)";
		
		String SYSID = "SELECT P9IL_HFP_SYS_ID.NEXTVAL FROM DUAL";
		
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		ResultSet C10_REC = null;
		ResultSet C11_REC = null;
		ResultSet C8_REC = null;
		ResultSet C9_REC = null;
		ResultSet C10A_REC = null;
		ResultSet C2_REC = null;
		ResultSet C12_REC = null;
		ResultSet C13_REC = null;
		ResultSet SYSID_REC = null;
		
		try{
			Connection con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			Object [] c1_obj = new Object[]{DUMMY1_BEAN.getHFH_POL_NO_FM(),DUMMY1_BEAN.getHFH_POL_NO_TO()};
			log.info("C1 Values====>"+c1_obj.toString());
			
			C1_REC = handler.executeSelectStatement(C1, con,c1_obj);
			while(C1_REC.next()){
				M_POL_SYS_ID = C1_REC.getDouble("POL_SYS_ID");
				M_POL_PLAN_CODE = C1_REC.getString("POL_PLAN_CODE");
				M_POL_NO = C1_REC.getString("POL_NO");
				log.info("==========>M_POL_SYS_ID=======>"+M_POL_SYS_ID);
				
				C10_REC = handler.executeSelectStatement(C10, con,new Object[]{M_POL_SYS_ID});
				if(C10_REC.next()){
					M_IL_CLM_BNF_DOB = C10_REC.getTimestamp(1);
				}
				
				if(CommonUtils.getYearFromDate(M_IL_CLM_BNF_DOB) > CommonUtils.getYearFromDate(new CommonUtils().getCurrentDate())){
					M_IL_CLM_BNF_DOB = CommonUtils.addMonthsToDate(M_IL_CLM_BNF_DOB, -1200);
				}else{
					//M_IL_CLM_BNF_DOB = CommonUtils.stringToUtilDate(String.valueOf(M_IL_CLM_BNF_DOB));
				}
				
				Object [] c11_obj = new Object[]{DUMMY1_BEAN.getHFH_DATE_FM(),M_IL_CLM_BNF_DOB};
				
				C11_REC = handler.executeSelectStatement(C11, con,c11_obj);
				if(C11_REC.next()){
					M_IL_CLM_BNF_AGE = C11_REC.getInt(1);
				}
				
				C13_REC = handler.executeSelectStatement(C13, con);
				if(C13_REC.next()){
					M_PS_VALUE = C13_REC.getInt(1);
				}
				
				Object [] delObj = new Object[]{DUMMY1_BEAN.getHFH_POL_NO_FM(),DUMMY1_BEAN.getHFH_POL_NO_TO(),M_IL_CLM_BNF_AGE};
				int deleteInt = handler.executeDeleteStatement(deleteQuery, con, delObj);
				CommonUtils.getConnection().commit();
				log.info("========>Delete Value=======>"+deleteInt);
				
				if(M_IL_CLM_BNF_AGE >= M_PS_VALUE){
					for(int j = M_PS_VALUE ;j<M_IL_CLM_BNF_AGE ; j++){
						M_IL_CLM_BNF_AGE_1 = j;
						M_DUMMY = null;
						
						Object [] c12_obj = new Object[]{M_POL_NO,M_IL_CLM_BNF_AGE_1};
						
						C12_REC = handler.executeSelectStatement(C12, con,c12_obj);
						if(C12_REC.next()){
							M_DUMMY = C12_REC.getString(1);
						}
						
						if("Y".equals(CommonUtils.nvl(M_DUMMY, "Y"))){
							Long sysId = null;
							SYSID_REC = handler.executeSelectStatement(SYSID, con);
							if(SYSID_REC.next()){
								sysId = SYSID_REC.getLong(1);
							}
							
							Object  [] ins_obj = new Object[]{
													sysId,
													M_POL_NO,
													0,
													DUMMY1_BEAN.getHFH_SYS_ID(),
													"Y",
													M_IL_CLM_BNF_AGE_1,
													"N"};
							int insertValue = handler.executeInsertStatement(insertQuery, con, ins_obj);
							CommonUtils.getConnection().commit();
							log.info("Insert Value=====>"+insertValue);
						}
						
					}
				}
					
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C10_REC);
			CommonUtils.closeCursor(C11_REC);
			CommonUtils.closeCursor(C8_REC);
			CommonUtils.closeCursor(C9_REC);
			CommonUtils.closeCursor(C10A_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C12_REC);
			CommonUtils.closeCursor(C13_REC);
			CommonUtils.closeCursor(SYSID_REC);
		}
	}

}
