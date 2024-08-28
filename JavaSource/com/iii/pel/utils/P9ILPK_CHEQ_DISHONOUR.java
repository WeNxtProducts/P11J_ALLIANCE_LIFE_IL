package com.iii.pel.utils;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class P9ILPK_CHEQ_DISHONOUR {

    /**
      *
      * @param P_DPD_REF_ID-IN
      * @param P_CHQ_NO-IN
      * @param P_BANK_CODE-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_AFFECTED_TRANS_DTLS(
                      Object P_DPD_REF_ID,
           Object P_CHQ_NO,
           Object P_BANK_CODE) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DPD_REF_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CHQ_NO);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BANK_CODE);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHEQ_DISHONOUR.INS_AFFECTED_TRANS_DTLS");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_TXN_SYS_ID-IN
      * @param P_TXN_TYPE-IN
      * @param P_PD_SYS_ID-IN
      * @param P_DPD_REF_ID-IN
      * @param P_CONT_CODE-IN
      * @param P_PC_SYS_ID-IN
      * @param P_REASON_CODE-IN
      * @param P_REMARKS-IN
      * @param P_CBH_BANK_CODE-IN
      * @param P_CBH_CHQ_NO-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> UPD_UNIT_LINK_TAB_CHQ(
                      Object P_TXN_SYS_ID,
           Object P_TXN_TYPE,
           Object P_PD_SYS_ID,
           Object P_DPD_REF_ID,
           Object P_CONT_CODE,
           Object P_PC_SYS_ID,
           Object P_REASON_CODE,
           Object P_REMARKS,
           Object P_CBH_BANK_CODE,
           Object P_CBH_CHQ_NO) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_TXN_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TXN_TYPE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DPD_REF_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CONT_CODE);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_REASON_CODE);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_REMARKS);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_BANK_CODE);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CBH_CHQ_NO);
            parameterList.add(param10);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHEQ_DISHONOUR.UPD_UNIT_LINK_TAB_CHQ");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    /**
      *
      * @param P_CBH_SYS_ID-IN
      * @param P_CBH_LR_SYS_ID-IN
      * @param P_CBH_PD_SYS_ID-IN
      * @param P_CBH_DEP_SYS_ID-IN
      * @param P_CBH_PC_SYS_ID-IN
      * @param P_CBH_POL_SYS_ID-IN
      * @param P_CBH_TXN_SYS_ID-IN
      * @param P_CBH_TXN_TYPE-IN
      * @param P_CBH_POL_NO-IN
      * @param P_CBH_POL_CONT_NAME-IN
      * @param P_CBH_POL_ISSUE_DT-IN
      * @param P_CBH_POL_START_DT-IN
      * @param P_CBH_POL_EXPIRY_DT-IN
      * @param P_CBH_POL_PROD_CODE-IN
      * @param P_CBH_PC_SCHD_PYMT_DT-IN
      * @param P_CBH_PC_FC_AVLB_BAL_AMT-IN
      * @param P_CBH_PC_LC_AVLB_BAL_AMT-IN
      * @param P_CBH_PC_FC_PAID_AMT-IN
      * @param P_CBH_PC_LC_PAID_AMT-IN
      * @param P_CBH_FC_NET_PREM-IN
      * @param P_CBH_LC_NET_PREM-IN
      * @param P_CBH_LOAN_REF_NO-IN
      * @param P_CBH_LOAN_DT-IN
      * @param P_CBH_LR_PYMT_DT-IN
      * @param P_CBH_LR_FC_PYMT_AMT-IN
      * @param P_CBH_LR_LC_PYMT_AMT-IN
      * @param P_CBH_LR_LC_LOAN_AMT-IN
      * @param P_CBH_LR_FC_LOAN_AMT-IN
      * @param P_CBH_LR_LC_INT_AMT-IN
      * @param P_CBH_LR_FC_INT_AMT-IN
      * @param P_CBH_DEP_REF_ID-IN
      * @param P_CBH_DEP_FC_AMT-IN
      * @param P_CBH_DEP_LC_AMT-IN
      * @param P_CBH_CHQ_NO-IN
      * @param P_CBH_BANK_CODE-IN
      * @param P_CBH_REASON_CODE-IN
      * @param P_CBH_REMARKS-IN
      * @param P_CBH_DRCR_ACNT_YEAR-IN
      * @param P_CBH_DRCR_TXN_CODE-IN
      * @param P_CBH_DRCR_DOC_NO-IN
      * @param P_CBH_DRCR_DOC_DT-IN
      * @param P_CBH_REVERSE_YN-IN
      * @param P_CBH_CR_DT-IN
      * @param P_CBH_CR_UID-IN
      * @param P_CBH_UPD_DT-IN
      * @param P_CBH_UPD_UID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> INS_CBH(
                      Object P_CBH_SYS_ID,
           Object P_CBH_LR_SYS_ID,
           Object P_CBH_PD_SYS_ID,
           Object P_CBH_DEP_SYS_ID,
           Object P_CBH_PC_SYS_ID,
           Object P_CBH_POL_SYS_ID,
           Object P_CBH_TXN_SYS_ID,
           Object P_CBH_TXN_TYPE,
           Object P_CBH_POL_NO,
           Object P_CBH_POL_CONT_NAME,
           Object P_CBH_POL_ISSUE_DT,
           Object P_CBH_POL_START_DT,
           Object P_CBH_POL_EXPIRY_DT,
           Object P_CBH_POL_PROD_CODE,
           Object P_CBH_PC_SCHD_PYMT_DT,
           Object P_CBH_PC_FC_AVLB_BAL_AMT,
           Object P_CBH_PC_LC_AVLB_BAL_AMT,
           Object P_CBH_PC_FC_PAID_AMT,
           Object P_CBH_PC_LC_PAID_AMT,
           Object P_CBH_FC_NET_PREM,
           Object P_CBH_LC_NET_PREM,
           Object P_CBH_LOAN_REF_NO,
           Object P_CBH_LOAN_DT,
           Object P_CBH_LR_PYMT_DT,
           Object P_CBH_LR_FC_PYMT_AMT,
           Object P_CBH_LR_LC_PYMT_AMT,
           Object P_CBH_LR_LC_LOAN_AMT,
           Object P_CBH_LR_FC_LOAN_AMT,
           Object P_CBH_LR_LC_INT_AMT,
           Object P_CBH_LR_FC_INT_AMT,
           Object P_CBH_DEP_REF_ID,
           Object P_CBH_DEP_FC_AMT,
           Object P_CBH_DEP_LC_AMT,
           Object P_CBH_CHQ_NO,
           Object P_CBH_BANK_CODE,
           Object P_CBH_REASON_CODE,
           Object P_CBH_REMARKS,
           Object P_CBH_DRCR_ACNT_YEAR,
           Object P_CBH_DRCR_TXN_CODE,
           Object P_CBH_DRCR_DOC_NO,
           Object P_CBH_DRCR_DOC_DT,
           Object P_CBH_REVERSE_YN,
           Object P_CBH_CR_DT,
           Object P_CBH_CR_UID,
           Object P_CBH_UPD_DT,
           Object P_CBH_UPD_UID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PD_SYS_ID);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DEP_SYS_ID);
            parameterList.add(param4);
            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PC_SYS_ID);
            parameterList.add(param5);
            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_SYS_ID);
            parameterList.add(param6);
            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CBH_TXN_SYS_ID);
            parameterList.add(param7);
            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_TXN_TYPE);
            parameterList.add(param8);
            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_NO);
            parameterList.add(param9);
            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_CONT_NAME);
            parameterList.add(param10);
            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_ISSUE_DT);
            parameterList.add(param11);
            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_START_DT);
            parameterList.add(param12);
            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_EXPIRY_DT);
            parameterList.add(param13);
            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_POL_PROD_CODE);
            parameterList.add(param14);
            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PC_SCHD_PYMT_DT);
            parameterList.add(param15);
            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PC_FC_AVLB_BAL_AMT);
            parameterList.add(param16);
            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PC_LC_AVLB_BAL_AMT);
            parameterList.add(param17);
            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PC_FC_PAID_AMT);
            parameterList.add(param18);
            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_PC_LC_PAID_AMT);
            parameterList.add(param19);
            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_FC_NET_PREM);
            parameterList.add(param20);
            OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LC_NET_PREM);
            parameterList.add(param21);
            OracleParameter param22 = new OracleParameter("IN22", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LOAN_REF_NO);
            parameterList.add(param22);
            OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LOAN_DT);
            parameterList.add(param23);
            OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_PYMT_DT);
            parameterList.add(param24);
            OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_FC_PYMT_AMT);
            parameterList.add(param25);
            OracleParameter param26 = new OracleParameter("IN26", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_LC_PYMT_AMT);
            parameterList.add(param26);
            OracleParameter param27 = new OracleParameter("IN27", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_LC_LOAN_AMT);
            parameterList.add(param27);
            OracleParameter param28 = new OracleParameter("IN28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_FC_LOAN_AMT);
            parameterList.add(param28);
            OracleParameter param29 = new OracleParameter("IN29", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_LC_INT_AMT);
            parameterList.add(param29);
            OracleParameter param30 = new OracleParameter("IN30", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_LR_FC_INT_AMT);
            parameterList.add(param30);
            OracleParameter param31 = new OracleParameter("IN31", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DEP_REF_ID);
            parameterList.add(param31);
            OracleParameter param32 = new OracleParameter("IN32", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DEP_FC_AMT);
            parameterList.add(param32);
            OracleParameter param33 = new OracleParameter("IN33", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DEP_LC_AMT);
            parameterList.add(param33);
            OracleParameter param34 = new OracleParameter("IN34", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CBH_CHQ_NO);
            parameterList.add(param34);
            OracleParameter param35 = new OracleParameter("IN35", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_BANK_CODE);
            parameterList.add(param35);
            OracleParameter param36 = new OracleParameter("IN36", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_REASON_CODE);
            parameterList.add(param36);
            OracleParameter param37 = new OracleParameter("IN37", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_REMARKS);
            parameterList.add(param37);
            OracleParameter param38 = new OracleParameter("IN38", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DRCR_ACNT_YEAR);
            parameterList.add(param38);
            OracleParameter param39 = new OracleParameter("IN39", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DRCR_TXN_CODE);
            parameterList.add(param39);
            OracleParameter param40 = new OracleParameter("IN40", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DRCR_DOC_NO);
            parameterList.add(param40);
            OracleParameter param41 = new OracleParameter("IN41", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_DRCR_DOC_DT);
            parameterList.add(param41);
            OracleParameter param42 = new OracleParameter("IN42", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_REVERSE_YN);
            parameterList.add(param42);
            OracleParameter param43 = new OracleParameter("IN43", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_CR_DT);
            parameterList.add(param43);
            OracleParameter param44 = new OracleParameter("IN44", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_CR_UID);
            parameterList.add(param44);
            OracleParameter param45 = new OracleParameter("IN45", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_CBH_UPD_DT);
            parameterList.add(param45);
            OracleParameter param46 = new OracleParameter("IN46", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CBH_UPD_UID);
            parameterList.add(param46);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CHEQ_DISHONOUR.INS_CBH");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
}
    