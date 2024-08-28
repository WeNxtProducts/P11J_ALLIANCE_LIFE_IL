package com.iii.pel.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PILPK_POLICY_APPROVAL {

  
	  /**
    *
    * @param P_POL_SYS_ID-IN
    * @param P_FC_AMOUNT-IN
    * @param P_LC_AMOUNT-IN
    * @param P_AVLB_BAL_FC_AMT-IN
    * @param P_AVLB_BAL_LC_AMT-IN
    * @param P_POL_ISSUE_DT-IN
    * @param P_POL_PROP_NO-IN
    * @param P_POL_NO-IN
    * @param P_PLAN_TYPE-IN
    * @param P_CUST_CODE-IN
    * @param P_BROK_GEN_YN-IN OUT
    * @param P_PREM_GEN_YN-IN OUT
    * @param P_TRAN_DATE_OUT-OUT
    * @param P_AMAN_SHARE_OUT-OUT
    * @param P_SENABEL_SHARE_OUT-OUT
    * @param P_TXN_TYPE_OUT-OUT
    * @param P_SUCCESS_OUT-OUT
    * @param P_SUCC_OUT-OUT
    * @param P_PRINT_TYPE_OUT-OUT
    * @param P_ERR_IDX_OUT-OUT
    * @param P_STATUS_OUT-OUT
    * @param P_CALL_FORM_OUT-OUT
    * @param P_M_APPRV_DATE-IN
    * @param P_M_TRAN_DATE-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> PR_PILP002_APAC(
                    Object P_POL_SYS_ID,
         Object P_FC_AMOUNT,
         Object P_LC_AMOUNT,
         Object P_AVLB_BAL_FC_AMT,
         Object P_AVLB_BAL_LC_AMT,
         Object P_POL_ISSUE_DT,
         Object P_POL_PROP_NO,
         Object P_POL_NO,
         Object P_PLAN_TYPE,
         Object P_CUST_CODE,
         Object P_BROK_GEN_YN,
         Object P_PREM_GEN_YN,
         Object P_TRAN_DATE_OUT,
         Object P_AMAN_SHARE_OUT,
         Object P_SENABEL_SHARE_OUT,
         Object P_TXN_TYPE_OUT,
         Object P_SUCCESS_OUT,
         Object P_SUCC_OUT,
         Object P_PRINT_TYPE_OUT,
         Object P_ERR_IDX_OUT,
         Object P_STATUS_OUT,
         Object P_CALL_FORM_OUT,
         Object P_M_APPRV_DATE,
         Object P_M_TRAN_DATE,
         Object P_M_POL_PREM_WAIVE_YN,
         Object P_M_POL_PREM_WAIVE_INT_RATE,
         Object P_M_POL_PREM_WAIVE_TYPE,
         Object P_M_POL_PREM_WAIVE_FIX_AMOUNT
  ) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_AMOUNT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_AMOUNT);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_AVLB_BAL_FC_AMT);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_AVLB_BAL_LC_AMT);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ISSUE_DT);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROP_NO);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_TYPE);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CUST_CODE);
          parameterList.add(param10);
          OracleParameter param11 = new OracleParameter("IN OUT11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_BROK_GEN_YN);
          parameterList.add(param11);
          OracleParameter param12 = new OracleParameter("IN OUT12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PREM_GEN_YN);
          parameterList.add(param12);
          OracleParameter param13 = new OracleParameter("OUT13", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param13);
          OracleParameter param14 = new OracleParameter("OUT14", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param14);
          OracleParameter param15 = new OracleParameter("OUT15", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param15);
          OracleParameter param16 = new OracleParameter("OUT16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param16);
          OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param17);
          OracleParameter param18 = new OracleParameter("OUT18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param18);
          OracleParameter param19 = new OracleParameter("OUT19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param19);
          OracleParameter param20 = new OracleParameter("OUT20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param20);
          OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param21);
          OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param22);
          OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_M_APPRV_DATE);
          parameterList.add(param23);
          OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_M_TRAN_DATE);
          parameterList.add(param24);
          OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_PREM_WAIVE_YN);
          parameterList.add(param25);
          OracleParameter param26 = new OracleParameter("IN26", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_PREM_WAIVE_INT_RATE);
          parameterList.add(param26);
          OracleParameter param27 = new OracleParameter("IN27", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_PREM_WAIVE_TYPE);
          parameterList.add(param27);
          OracleParameter param28 = new OracleParameter("IN28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_PREM_WAIVE_FIX_AMOUNT);
          parameterList.add(param28);
          

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "PILPK_POLICY_APPROVAL.PR_PILP002_APAC");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

	
    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_APPRV_DATE-IN
      * @param P_PROP_NO-IN
      * @param P_MED_FEE_RECOVER_YN-IN
      * @param P_PROP_STATUS-IN
      * @param P_DEPPREM_REFUND_YN-IN
      * @param P_PS_REASON_CODE-IN
      * @param P_PS_REMARKS-IN
      * @param P_PROP_CONVERT-IN
      * @param P_POLICY_NO-IN OUT
      * @param P_POL_NO-IN
      * @param P_GEN_POL_NO-IN
      * @param P_BLOCK_ROWID-IN
      * @param P_PRINT_TYPE-OUT
      * @param P_FLAG_OUT-OUT
      * @param P_POL_NO_OUT-OUT
      * @param P_PROP_SYS_ID_OUT-OUT
      * @param P_CLM_SYS_ID_OUT-OUT
      * @param P_POL_SYS_ID_OUT-OUT
      * @param P_DOCUMENT_OUT-OUT
      * @param P_REP_NAME_OUT-OUT
      * @param P_ERR_IDX_OUT-OUT
      * @param P_STATUS_OUT-OUT
      * @param P_CALL_FORM_OUT-OUT
      *
      * @return ArrayList of type Oracle Parameter
     * @throws SQLException 
      * @throws Exception
      */
    public ArrayList<OracleParameter> PR_PILP001_APAC(
                      Object P_POL_SYS_ID,
           Object P_APPRV_DATE,
           Object P_PROP_NO,
           Object P_MED_FEE_RECOVER_YN,
           Object P_PROP_STATUS,
           Object P_DEPPREM_REFUND_YN,
           Object P_PS_REASON_CODE,
           Object P_PS_REMARKS,
           Object P_PROP_CONVERT,
           Object P_POLICY_NO,
           Object P_POL_NO,
           Object P_GEN_POL_NO,
           Object P_BLOCK_ROWID,
           Object P_PRINT_TYPE,
           Object P_FLAG_OUT,
           Object P_POL_NO_OUT,
           Object P_PROP_SYS_ID_OUT,
           Object P_CLM_SYS_ID_OUT,
           Object P_POL_SYS_ID_OUT,
           Object P_DOCUMENT_OUT,
           Object P_REP_NAME_OUT,
           Object P_ERR_IDX_OUT,
           Object P_STATUS_OUT,
           Object P_CALL_FORM_OUT) throws ProcedureException, SQLException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
		 	
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DATE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROP_NO);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MED_FEE_RECOVER_YN);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROP_STATUS);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DEPPREM_REFUND_YN);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_REASON_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_REMARKS);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROP_CONVERT);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN OUT10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POLICY_NO);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_GEN_POL_NO);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BLOCK_ROWID);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("OUT14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("OUT15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("OUT16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("OUT17", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("OUT18", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("OUT19", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("OUT20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("OUT23", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("OUT24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param24);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_POLICY_APPROVAL.PR_PILP001_APAC");
            
            connection.commit();
         } catch(Exception e) {
             e.printStackTrace();
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
         
        return outputList;
    }
    
    /* Newly added by Dhinesh on 29.3.2017 */ 
    public ArrayList<OracleParameter> PR_PRODUCT_WISE_BROKER(String P_AGENT_CODE, Date P_APPRV_DATE) throws ProcedureException, SQLException
        {

        	Connection connection = null;
        	ArrayList<OracleParameter> parameterList = null;
        	ArrayList<OracleParameter> outputList = null;
        	
        	try {
        		connection = CommonUtils.getConnection();

        		parameterList = new ArrayList<OracleParameter>();
        		outputList = new ArrayList<OracleParameter>();

                OracleProcedureHandler procHandler = new OracleProcedureHandler();
                
                OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AGENT_CODE);
                parameterList.add(param1);
                OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AGENT_CODE);
                parameterList.add(param2);
                OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DATE);
                parameterList.add(param3);
                OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_APPRV_DATE);
                parameterList.add(param4);
                OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
                parameterList.add(param5);
                 outputList = procHandler.executeProc(parameterList, connection,"PRO_AGENT_MONTH_PRODUCTION");
        	System.out.println("outputList   : "+outputList.size());
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		ErrorHelpUtil.getErrorForProcedure(connection);
        		throw new ProcedureException(e.getMessage());
        	}
        	return outputList;
        }
    	
    	
    	/* End */
/*    added by gopi for toi on 17/06/18*/

	public ArrayList<OracleParameter> P_POLICY_DIRECT_APPROVAL(Object P_POL_SYS_ID)
			throws ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1",
			OracleParameter.DATA_TYPE.LONG,
			OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	parameterList.add(param1);

	OracleProcedureHandler procHandler = new OracleProcedureHandler();
	outputList = procHandler.executeProc(parameterList, connection,
			"PILPK_POLICY_APPROVAL.P_POLICY_DIRECT_APPROVAL");
} catch (Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
	throw new ProcedureException(e.getMessage());
}
return outputList;
}



    //end

}
