package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PILPK_PILT002_STATUS_OK {

    /**
      *
      * @param P_POL_SYS_ID-IN
      * @param P_PROD_CODE-IN
      * @param P_END_NO_IDX-IN
      * @param P_DS_TYPE-IN
      * @param P_DS_CODE-IN
      * @param P_CONT_CODE-IN
      * @param P_PROP_NO-IN
      * @param P_END_CODE-IN
      * @param P_MEDICAL_FLAG-IN
      * @param P_CALC_METHOD-IN
      * @param P_POSTPONE_DAYS-IN
      * @param P_CUST_CURR_CODE-IN
      * @param P_FC_FIRST_PREM-IN
      * @param P_LC_FIRST_PREM-IN
      * @param P_ISSUE_DT-IN
      * @param P_STD_RISK_YN-IN
      * @param P_LC_SUM_ASSURED-IN
      * @param P_LC_DEPOSIT_AMOUNT-IN
      * @param P_POL_NO-IN
      * @param P_END_TYPE-IN
      * @param P_PRIVILEGE-IN
      * @param P_USER_IP-IN
      * @param P_COMM_CODE-IN
      * @param P_FRZ_FLAG-IN
      * @param P_END_DT-IN
      * @param POL_ISSUE_DT-IN
      * @param P_JOINT_LIFE_YN-IN
      * @param P_PS_STATUS_DT-IN
      * @param D_M_POL_PLAN_TYPE-IN
      * @param P_POL_APPRV_STATUS-IN OUT
      * @param P_ADDL_STATUS-IN OUT
      * @param P_HOLD_YN-IN OUT
      * @param P_POL_STATUS-IN OUT
      * @param P_PS_STATUS-IN OUT
      * @param P_APPRV_DT-OUT
      * @param P_REASON_CODE-IN OUT
      * @param P_REMARKS-IN OUT
      * @param P_REASON_DESC-IN OUT
      * @param P_POL_CUST_CODE-IN
      * @param P_COMM_DEL-OUT
      * @param P_POL_POSTPONE_EXPIRY_DT-OUT
      * @param P_POL_POSTPONE_DAYS-OUT
      * @param P_M_PS_STATUS_REQ-OUT
      * @param D_M_PS_REASON_CODE_REQ-OUT
      * @param D_M_PS_STATUS_DT_REQ-OUT
      * @param D_M_PRINT_TYPE-OUT
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> STATUS_OK_BUT_PRESSED(
                      Object P_POL_SYS_ID,
           Object P_PROD_CODE,
           Object P_END_NO_IDX,
           Object P_DS_TYPE,
           Object P_DS_CODE,
           Object P_CONT_CODE,
           Object P_PROP_NO,
           Object P_END_CODE,
           Object P_MEDICAL_FLAG,
           Object P_CALC_METHOD,
           Object P_POSTPONE_DAYS,
           Object P_CUST_CURR_CODE,
           Object P_FC_FIRST_PREM,
           Object P_LC_FIRST_PREM,
           Object P_ISSUE_DT,
           Object P_STD_RISK_YN,
           Object P_LC_SUM_ASSURED,
           Object P_LC_DEPOSIT_AMOUNT,
           Object P_POL_NO,
           Object P_END_TYPE,
           Object P_PRIVILEGE,
           Object P_USER_IP,
           Object P_COMM_CODE,
           Object P_FRZ_FLAG,
           Object P_END_DT,
           Object POL_ISSUE_DT,
           Object P_JOINT_LIFE_YN,
           Object P_PS_STATUS_DT,
           Object D_M_POL_PLAN_TYPE,
           Object P_POL_APPRV_STATUS,
           Object P_ADDL_STATUS,
           Object P_HOLD_YN,
           Object P_POL_STATUS,
           Object P_PS_STATUS,
           Object P_APPRV_DT,
           Object P_REASON_CODE,
           Object P_REMARKS,
           Object P_REASON_DESC,
           Object P_POL_CUST_CODE,
           Object P_COMM_DEL,
           Object P_POL_POSTPONE_EXPIRY_DT,
           Object P_POL_POSTPONE_DAYS,
           Object P_M_PS_STATUS_REQ,
           Object D_M_PS_REASON_CODE_REQ,
           Object D_M_PS_STATUS_DT_REQ,
           Object D_M_PRINT_TYPE,
           /*added by raja on 02-08-2017 for ZBILQC-1731915 */
           Object P_PS_RI_CODE) throws ProcedureException {
    	/*end*/
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_END_NO_IDX);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DS_TYPE);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DS_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CONT_CODE);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROP_NO);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_END_CODE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MEDICAL_FLAG);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CALC_METHOD);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POSTPONE_DAYS);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CUST_CURR_CODE);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_FIRST_PREM);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_FIRST_PREM);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_ISSUE_DT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_STD_RISK_YN);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_SUM_ASSURED);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_DEPOSIT_AMOUNT);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_END_TYPE);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PRIVILEGE);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_USER_IP);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COMM_CODE);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FRZ_FLAG);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_END_DT);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, POL_ISSUE_DT);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_JOINT_LIFE_YN);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PS_STATUS_DT);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, D_M_POL_PLAN_TYPE);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN OUT30", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_APPRV_STATUS);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN OUT31", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_ADDL_STATUS);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN OUT32", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_HOLD_YN);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN OUT33", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_STATUS);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("IN OUT34", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PS_STATUS);
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("OUT35", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("IN OUT36", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_REASON_CODE);
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("IN OUT37", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_REMARKS);
            parameterList.add(param37);
            OracleParameter param38 = new OracleParameter("IN OUT38", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_REASON_DESC);
            parameterList.add(param38);
            OracleParameter param39 = new OracleParameter("IN39", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_CODE);
            parameterList.add(param39);
            OracleParameter param40 = new OracleParameter("OUT40", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param40);
            OracleParameter param41 = new OracleParameter("OUT41", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param41);
            OracleParameter param42 = new OracleParameter("OUT42", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param42);
            OracleParameter param43 = new OracleParameter("OUT43", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param43);
            OracleParameter param44 = new OracleParameter("OUT44", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param44);
            OracleParameter param45 = new OracleParameter("OUT45", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param45);
            OracleParameter param46 = new OracleParameter("OUT46", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
            parameterList.add(param46);
            OracleParameter param47 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_RI_CODE);
            parameterList.add(param47);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "PILPK_PILT002_STATUS_OK.STATUS_OK_BUT_PRESSED");
         } catch(Exception e) {
        	 e.printStackTrace();
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
}