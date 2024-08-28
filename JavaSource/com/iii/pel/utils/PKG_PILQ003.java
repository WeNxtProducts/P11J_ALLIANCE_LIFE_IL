package com.iii.pel.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILQ003.BP;
import com.iii.pel.forms.PILQ003.COPY_ACTION;
import com.iii.pel.forms.PILQ003.DUMMY;
import com.iii.pel.forms.PILQ003.DUMMY_ACTION;
import com.iii.pel.forms.PILQ003.PILQ003_COMPOSITE_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_DOC_TODO_LIST_STATUS_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POLICY;
import com.iii.pel.forms.PILQ003.PT_IL_POLICY_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ADDL_COVER;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ADDL_COVER_1_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ADDL_COVER_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSR_MED_HIST;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSR_MED_HIST_1;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSR_MED_HIST_1_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSR_MED_HIST_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSURED_DTLS;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSURED_DTLS_1;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSURED_DTLS_1_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_ASSURED_DTLS_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BENEFICIARY_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BROKER_DTL_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BROKER_HEAD_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_CHARGE_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_CONDITION_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_DISC_LOAD;
import com.iii.pel.forms.PILQ003.PT_IL_POL_DISC_LOAD_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_MED_EXAM_DTL_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_STATUS_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_SURR_MAT_VALUES;
import com.iii.pel.forms.PILQ003.PT_IL_SURR_MAT_VALUES_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_UNPAID_PREM_DTLS_ACTION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PKG_PILQ003 {

	
    /**
      *
      * @param P_CUST_CODE-OUT
      * @param P_POL_CONT_CODE-IN
      * @param P_POL_DIVN_CODE-IN
      * @param P_POL_LC_SUM_ASSURED-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> L_GET_CLINIC_CODE(
                      String P_CUST_CODE,
           String P_POL_CONT_CODE,
           String P_POL_DIVN_CODE,
           String P_POL_LC_SUM_ASSURED) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("OUT1", "STRING", "OUT","");
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_CONT_CODE);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_DIVN_CODE);
            parameterList.add(param3);
            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_LC_SUM_ASSURED);
            parameterList.add(param4);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
            	"PKG_PILT002_APAC.L_GET_CLINIC_CODE");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    
    
    
	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_START_DT-IN
	 * @param P_POL_END_DT-IN OUT
	 * @param P_POL_FC_CURR_SA-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_SA_CURR_EXCHANGE_RATE-IN
	 * @param P_BASE_CURR_CODE-IN
	 * @param P_FC_PROFIT-IN OUT
	 * @param P_LC_PROFIT-IN OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> IL_CALC_ISLM_ACC_PROFIT(
			String P_POL_SYS_ID,
			String P_POL_PLAN_CODE,
			String P_POL_START_DT,
			String P_POL_END_DT,
			String P_POL_FC_CURR_SA,
			String P_POL_SA_CURR_CODE,
			String P_SA_CURR_EXCHANGE_RATE,
			String P_BASE_CURR_CODE,
			String P_FC_PROFIT,
			String P_LC_PROFIT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_START_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_POL_END_DT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_FC_CURR_SA);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_SA_CURR_EXCHANGE_RATE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_BASE_CURR_CODE);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_FC_PROFIT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN OUT10", "STRING", "IN OUT",P_LC_PROFIT);
			parameterList.add(param10);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_CALC_ISLM_ACC_PROFIT");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_POL_NO_YRS_PREM_PAID-IN
	 * @param P_POL_FC_CURR_SA-IN
	 * @param P_POL_START_DT-IN
	 * @param P_POL_END_DT-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_BASE_CURR-IN
	 * @param P_SA_CURR_EXCHANGE_RATE-IN
	 * @param P_SURR_TYPE-IN
	 * @param P_FC_ACC_PROFIT-IN OUT
	 * @param P_LC_ACC_PROFIT-IN OUT
	 * @param P_FC_SP-IN OUT
	 * @param P_LC_SP-IN OUT
	 * @param P_FC_SV_AMOUNT-IN OUT
	 * @param P_LC_SV_AMOUNT-IN OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_CALC_SV_AMT(
			String P_POL_SYS_ID,
			String P_POL_PLAN_CODE,
			String P_POL_PERIOD,
			String P_POL_NO_YRS_PREM_PAID,
			String P_POL_FC_CURR_SA,
			String P_POL_START_DT,
			String P_POL_END_DT,
			String P_POL_SA_CURR_CODE,
			String P_BASE_CURR,
			String P_SA_CURR_EXCHANGE_RATE,
			String P_SURR_TYPE,
			String P_FC_ACC_PROFIT,
			String P_LC_ACC_PROFIT,
			String P_FC_SP,
			String P_LC_SP,
			String P_FC_SV_AMOUNT,
			String P_LC_SV_AMOUNT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_NO_YRS_PREM_PAID);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_FC_CURR_SA);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_START_DT);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_END_DT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_BASE_CURR);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_SA_CURR_EXCHANGE_RATE);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_SURR_TYPE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN OUT12", "STRING", "IN OUT",P_FC_ACC_PROFIT);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN OUT13", "STRING", "IN OUT",P_LC_ACC_PROFIT);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN OUT14", "STRING", "IN OUT",P_FC_SP);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN OUT15", "STRING", "IN OUT",P_LC_SP);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN OUT16", "STRING", "IN OUT",P_FC_SV_AMOUNT);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN OUT17", "STRING", "IN OUT",P_LC_SV_AMOUNT);
			parameterList.add(param17);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_CALC_SV_AMT");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	/**
	 *
	 * @param P_ASSRD_TYPE-IN
	 * @param P_PLAN_CODE-IN
	 * @param P_CATG_CODE-IN
	 * @param P_CATG_CODE_1-IN
	 * @param P_JOINT_LIFE_YN-IN
	 * @param P_AGE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_CALC_METHOD-IN
	 * @param P_PLAN_AGE_TERM_FLAG-IN
	 * @param P_GLOBAL_PAYER_FOUND-OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> IL_POAD_AGE_CHECK(
			String P_ASSRD_TYPE,
			String P_PLAN_CODE,
			String P_CATG_CODE,
			String P_CATG_CODE_1,
			String P_JOINT_LIFE_YN,
			String P_AGE,String P_AGE_1,
			String P_POL_PERIOD,
			String P_CALC_METHOD,
			String P_PLAN_AGE_TERM_FLAG,
			String P_GLOBAL_PAYER_FOUND) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ASSRD_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CATG_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CATG_CODE_1);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_JOINT_LIFE_YN);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_AGE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_AGE_1);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CALC_METHOD);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_PLAN_AGE_TERM_FLAG);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
			parameterList.add(param11);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_POAD_AGE_CHECK");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_PROD_CODE-IN
	 * @param P_UI_M_BASE_CURR-IN
	 * @param P_UI_M_POL_PLAN_TYPE-IN
	 * @param P_UI_M_PROD_PREM_CALC_MTHD-IN
	 * @param P_DS_TYPE-IN
	 * @param P_POL_APPRV_STATUS-IN
	 * @param P_POL_PREM_PAY_YRS-IN
	 * @param P_LC_BASIC_PREM-IN
	 * @param P_POL_LC_TOT_LOADING-IN
	 * @param P_POL_LC_TOT_DISCOUNT-IN
	 * @param P_POL_LC_ADDL_PREM-IN
	 * @param P_POL_MODE_OF_PYMT_RATE-IN
	 * @param P_POL_CUST_EXCH_RATE-IN
	 * @param P_POL_LC_FIRST_PREM-IN
	 * @param P_POL_LC_NETT_PREM-IN OUT
	 * @param P_POL_FC_NETT_PREM-IN OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> L_CALC_NET_PREMIUM(
			String P_POL_SYS_ID,
			String P_PROD_CODE,
			String P_UI_M_BASE_CURR,
			String P_UI_M_POL_PLAN_TYPE,
			String P_UI_M_PROD_PREM_CALC_MTHD,
			String P_DS_TYPE,
			String P_POL_APPRV_STATUS,
			String P_POL_PREM_PAY_YRS,
			String P_LC_BASIC_PREM,
			String P_POL_LC_TOT_LOADING,
			String P_POL_LC_TOT_DISCOUNT,
			String P_POL_LC_ADDL_PREM,
			String P_POL_MODE_OF_PYMT_RATE,
			String P_POL_CUST_EXCH_RATE,
			String P_POL_LC_FIRST_PREM,
			String P_POL_LC_NETT_PREM,
			String P_POL_FC_NETT_PREM) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_UI_M_BASE_CURR);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_UI_M_POL_PLAN_TYPE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_UI_M_PROD_PREM_CALC_MTHD);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_DS_TYPE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_APPRV_STATUS);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_PREM_PAY_YRS);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_BASIC_PREM);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_LC_TOT_LOADING);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_LC_TOT_DISCOUNT);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_LC_ADDL_PREM);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_MODE_OF_PYMT_RATE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_CUST_EXCH_RATE);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_LC_FIRST_PREM);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN OUT16", "STRING", "IN OUT",P_POL_LC_NETT_PREM);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN OUT17", "STRING", "IN OUT",P_POL_FC_NETT_PREM);
			parameterList.add(param17);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.L_CALC_NET_PREMIUM");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	public ArrayList<String> P_VAL_PRODUCT(String P_PROD_CODE,
			String P_POL_ISSUE_DT, String P_ERR_FLAG) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_PROD_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_POL_ISSUE_DT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "OUT", "");
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002_APAC.P_VAL_PRODUCT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			// if (oracleParameter.getValue() != null) {
			returnList.add(oracleParameter.getValue());
			// }
		}
		return returnList;
	}

	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_DEP_GROSS_NET_FLAG-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_FC_FIRST_PREM-OUT
	 * @param P_LC_FIRST_PREM-OUT
	 * @param M_LC_PCHARGES_BORNE_CUSTOMER-OUT
	 * @param M_LC_PCHARGES_BORNE_COMPANY-OUT
	 * @param M_FC_PCHARGES_BORNE_CUSTOMER-OUT
	 * @param M_FC_PCHARGES_BORNE_COMPANY-OUT
	 * @param M_LC_SCHARGES_BORNE_CUSTOMER-OUT
	 * @param M_LC_SCHARGES_BORNE_COMPANY-OUT
	 * @param M_FC_SCHARGES_BORNE_CUSTOMER-OUT
	 * @param M_FC_SCHARGES_BORNE_COMPANY-OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> L_GET_FIRST_PREM(
			String P_POL_SYS_ID,
			String P_DEP_GROSS_NET_FLAG,
			String P_POL_PROD_CODE,
			String P_FC_FIRST_PREM,
			String P_LC_FIRST_PREM,
			String M_LC_PCHARGES_BORNE_CUSTOMER,
			String M_LC_PCHARGES_BORNE_COMPANY,
			String M_FC_PCHARGES_BORNE_CUSTOMER,
			String M_FC_PCHARGES_BORNE_COMPANY,
			String M_LC_SCHARGES_BORNE_CUSTOMER,
			String M_LC_SCHARGES_BORNE_COMPANY,
			String M_FC_SCHARGES_BORNE_CUSTOMER,
			String M_FC_SCHARGES_BORNE_COMPANY) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEP_GROSS_NET_FLAG);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT","");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5", "STRING", "OUT","");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
			parameterList.add(param13);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.L_GET_FIRST_PREM");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	 /**
	      *
	      * @param P_POL_SYS_ID-IN
	      * @param P_POL_EXPIRY_DT-IN
	      * @param P_UI_M_POL_PLAN_TYPE-IN
	      * @param P_UI_M_PROD_TOPUP_YN-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> L_CHECK_FUND_PERC_TOTAL(
	                      Object P_POL_SYS_ID,
	           Object P_POL_EXPIRY_DT,
	           Object P_UI_M_POL_PLAN_TYPE,
	           Object P_UI_M_PROD_TOPUP_YN) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_EXPIRY_DT);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_UI_M_POL_PLAN_TYPE);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_UI_M_PROD_TOPUP_YN);
	            parameterList.add(param4);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "PKG_PILT002_APAC.L_CHECK_FUND_PERC_TOTAL");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	
	/**
	 *
	 * @param P_POL_SYS_ID-IN
	 * @param P_END_NO_IDX-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_PROD_PREM_TARIFF-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POAD_SYS_ID-IN
	 * @param P_COVER_SA_CALC-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_POL_FC_MODAL_PREM-IN OUT
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> IL_PREMIUM_VAL_CAL(
			String P_POL_SYS_ID,
			String P_END_NO_IDX,
			String P_POL_END_TYPE,
			String P_PROD_PREM_TARIFF,
			String P_POL_PLAN_CODE,
			String P_POAD_SYS_ID,
			String P_COVER_SA_CALC,
			String P_POL_SA_CURR_CODE,
			String P_POL_FC_MODAL_PREM) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_END_NO_IDX);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PROD_PREM_TARIFF);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAD_SYS_ID);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_COVER_SA_CALC);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_POL_FC_MODAL_PREM);
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_PREMIUM_VAL_CAL");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_END_NO_IDX-IN
	 * @param P_POL_END_CODE-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_POL_PREM_PAY_YRS-IN
	 * @param P_POL_ORG_NO_OF_INST-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_POL_SA_EXCH_RATE-IN
	 * @param P_POL_NO_OF_UNIT-IN
	 * @param P_POL_NO_OF_INST-IN
	 * @param P_POL_ORG_FC_SUM_ASSURED-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POAD_SYS_ID-IN
	 * @param P_POL_ORG_FC_MODAL_PREM-IN
	 * @param P_M_BASE_CURR-IN
	 * @param P_M_COVER_VAR_VALUE-IN
	 * @param P_RECORD_STATUS-IN
	 * @param P_M_PROD_SA_FACTOR-IN
	 * @param P_M_PROD_SA_TARIFF-IN
	 * @param P_M_COVER_SA_CALC-IN
	 * @param P_M_PS_CODE-IN
	 * @param P_M_POL_PLAN_TYPE-IN
	 * @param P_POL_START_DT-IN
	 * @param P_POAD_AGE-IN
	 * @param P_M_EXACT_AGE-IN
	 * @param P_POL_DEF_PERIOD_TO-IN
	 * @param P_M_TD_MIN_RATE-IN
	 *                OUT
	 * @param P_M_TD_MAX_RATE-IN
	 *                OUT
	 * @param P_POL_NEW_FC_SA-IN
	 *                OUT
	 * @param P_POL_FC_MODAL_PREM-IN
	 *                OUT
	 * @param P_POL_FC_BASIC_PREM-OUT
	 * @param P_POL_LC_BASIC_PREM-OUT
	 * @param P_POL_FC_SUM_ASSURED-OUT
	 * @param P_POL_LC_SUM_ASSURED-OUT
	 * @param P_POL_FC_CURR_SA-OUT
	 * @param P_POL_LC_CURR_SA-OUT
	 * @param P_POL_ORG_NEW_LC_SA-OUT
	 * @param P_POL_ORG_NEW_FC_SA-OUT
	 * @param P_POL_NEW_LC_SA-OUT
	 * @param P_POL_FC_MON_ANNU_AMT-OUT
	 * @param P_POL_LC_MON_ANNU_AMT-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_SUM_ASURED_CAL(
			String P_POL_SYS_ID,
			String P_END_NO_IDX,
			String P_POL_END_CODE,
			String P_POL_END_TYPE,
			String P_POL_PREM_PAY_YRS,
			String P_POL_ORG_NO_OF_INST,
			String P_POL_SA_CURR_CODE,
			String P_POL_SA_EXCH_RATE,
			String P_POL_NO_OF_UNIT,
			String P_POL_NO_OF_INST,
			String P_POL_ORG_FC_SUM_ASSURED,
			String P_POL_PLAN_CODE,
			String P_POAD_SYS_ID,
			String P_POL_ORG_FC_MODAL_PREM,
			String P_M_BASE_CURR,
			String P_M_COVER_VAR_VALUE,
			String P_RECORD_STATUS,
			String P_M_PROD_SA_FACTOR,
			String P_M_PROD_SA_TARIFF,
			String P_M_COVER_SA_CALC,
			String P_M_PS_CODE,
			String P_M_POL_PLAN_TYPE,
			String P_POL_START_DT,
			String P_POAD_AGE,
			String P_M_EXACT_AGE,
			String P_POL_DEF_PERIOD_TO,
			String P_M_TD_MIN_RATE,
			String P_M_TD_MAX_RATE,
			String P_POL_NEW_FC_SA,
			String P_POL_FC_MODAL_PREM,
			String P_POL_FC_BASIC_PREM,
			String P_POL_LC_BASIC_PREM,
			String P_POL_FC_SUM_ASSURED,
			String P_POL_LC_SUM_ASSURED,
			String P_POL_FC_CURR_SA,
			String P_POL_LC_CURR_SA,
			String P_POL_ORG_NEW_LC_SA,
			String P_POL_ORG_NEW_FC_SA,
			String P_POL_NEW_LC_SA,
			String P_POL_FC_MON_ANNU_AMT,
			String P_POL_LC_MON_ANNU_AMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_END_NO_IDX);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_PREM_PAY_YRS);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_ORG_NO_OF_INST);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_SA_EXCH_RATE);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_NO_OF_UNIT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_NO_OF_INST);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_ORG_FC_SUM_ASSURED);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POAD_SYS_ID);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_ORG_FC_MODAL_PREM);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_M_BASE_CURR);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_M_COVER_VAR_VALUE);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_RECORD_STATUS);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_M_PROD_SA_FACTOR);
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_M_PROD_SA_TARIFF);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_M_COVER_SA_CALC);
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_M_PS_CODE);
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("IN22", "STRING", "IN",P_M_POL_PLAN_TYPE);
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("IN23", "STRING", "IN",P_POL_START_DT);
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_POAD_AGE);
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("IN25", "STRING", "IN",P_M_EXACT_AGE);
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("IN26", "STRING", "IN",P_POL_DEF_PERIOD_TO);
			parameterList.add(param26);
			OracleParameter param27 = new OracleParameter("IN OUT27", "STRING", "IN OUT",P_M_TD_MIN_RATE);
			parameterList.add(param27);
			OracleParameter param28 = new OracleParameter("IN OUT28", "STRING", "IN OUT",P_M_TD_MAX_RATE);
			parameterList.add(param28);
			OracleParameter param29 = new OracleParameter("IN OUT29", "STRING", "IN OUT",P_POL_NEW_FC_SA);
			parameterList.add(param29);
			OracleParameter param30 = new OracleParameter("IN OUT30", "STRING", "IN OUT",P_POL_FC_MODAL_PREM);
			parameterList.add(param30);
			OracleParameter param31 = new OracleParameter("OUT31", "STRING", "OUT","");
			parameterList.add(param31);
			OracleParameter param32 = new OracleParameter("OUT32", "STRING", "OUT","");
			parameterList.add(param32);
			OracleParameter param33 = new OracleParameter("OUT33", "STRING", "OUT","");
			parameterList.add(param33);
			OracleParameter param34 = new OracleParameter("OUT34", "STRING", "OUT","");
			parameterList.add(param34);
			OracleParameter param35 = new OracleParameter("OUT35", "STRING", "OUT","");
			parameterList.add(param35);
			OracleParameter param36 = new OracleParameter("OUT36", "STRING", "OUT","");
			parameterList.add(param36);
			OracleParameter param37 = new OracleParameter("OUT37", "STRING", "OUT","");
			parameterList.add(param37);
			OracleParameter param38 = new OracleParameter("OUT38", "STRING", "OUT","");
			parameterList.add(param38);
			OracleParameter param39 = new OracleParameter("OUT39", "STRING", "OUT","");
			parameterList.add(param39);
			OracleParameter param40 = new OracleParameter("OUT40", "STRING", "OUT","");
			parameterList.add(param40);
			OracleParameter param41 = new OracleParameter("OUT41", "STRING", "OUT","");
			parameterList.add(param41);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_SUM_ASURED_CAL");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}



	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_END_NO_IDX-IN
	 * @param P_POL_DS_CODE-IN
	 * @param P_POL_DS_TYPE-IN
	 * @param P_CUST_CODE-IN
	 * @param P_CONT_CODE-IN
	 * @param P_PROD_CODE-IN
	 * @param P_MASTER_POL_NO-IN
	 * @param P_LC_TOT_SA-IN
	 * @param P_G_PARA7-IN
	 * @param P_G_POL_SYS_ID-OUT

	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> IL_FREE_CVR_LMT_CHK(
			String P_POL_SYS_ID,
			String P_END_NO_IDX,
			String P_POL_DS_CODE,
			String P_POL_DS_TYPE,
			String P_CUST_CODE,
			String P_CONT_CODE,
			String P_PROD_CODE,
			String P_MASTER_POL_NO,
			String P_LC_TOT_SA,
			String P_G_PARA7,
			String P_G_POL_SYS_ID ) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_END_NO_IDX);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_DS_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_DS_TYPE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CUST_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CONT_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_MASTER_POL_NO);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_LC_TOT_SA);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_G_PARA7);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
			parameterList.add(param11);


			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_FREE_CVR_LMT_CHK");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}



	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_POAD_SYS_ID-IN
	 * @param P_END_TYPE-IN
	 * @param P_PLAN_CODE-IN
	 * @param P_UI_M_PROD_SA_FACTOR-IN
	 * @param P_UI_M_COVER_SA_CALC-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_UI_M_PROD_SA_TARIFF-IN
	 * @param P_POL_FC_MODAL_PREM-IN
	 * @param P_POL_NO_OF_INST-IN
	 * @param P_POL_FC_SUM_ASSURED-IN
	 * @param P_POL_ORG_FC_SUM_ASSURED-IN
	 * @param P_POL_ORG_FC_MODAL_PREM-IN
	 * @param P_POL_ORG_NO_OF_INST-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_CALC_SA_VALID(
			String P_POL_SYS_ID,
			String P_POAD_SYS_ID,
			String P_END_TYPE,
			String P_PLAN_CODE,
			String P_UI_M_PROD_SA_FACTOR,
			String P_UI_M_COVER_SA_CALC,
			String P_POL_SA_CURR_CODE,
			String P_UI_M_PROD_SA_TARIFF,
			String P_POL_FC_MODAL_PREM,
			String P_POL_NO_OF_INST,
			String P_POL_FC_SUM_ASSURED,
			String P_POL_ORG_FC_SUM_ASSURED,
			String P_POL_ORG_FC_MODAL_PREM,
			String P_POL_ORG_NO_OF_INST) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POAD_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_END_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PLAN_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_UI_M_PROD_SA_FACTOR);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_UI_M_COVER_SA_CALC);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_UI_M_PROD_SA_TARIFF);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_FC_MODAL_PREM);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_NO_OF_INST);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_FC_SUM_ASSURED);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_ORG_FC_SUM_ASSURED);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_ORG_FC_MODAL_PREM);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_ORG_NO_OF_INST);
			parameterList.add(param14);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_CALC_SA_VALID");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}

	/**
	 * 
	 * @param P_ASSRD_TYPE-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_JOINT_LIFE_YN-IN
	 * @param P_POAD_CATG_CODE-IN
	 * @param P_POAD_CATG_CODE1-IN
	 * @param P_POAD_AGE-IN
	 * @param P_POAD_AGE1-IN
	 * @param P_M_PLAN_AGE_TERM_FLAG-IN
	 * @param P_G_M_PRIVILEGE-IN
	 * @param P_G_M_PAYER_FOUND-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_M_CALC_METHOD-IN
	 * @param P_ITEM_POAD_AGE_INSERT-OUT
	 * @param P_ITEM_POAD_AGE1_INSERT-OUT
	 * @param P_G_M_FOUND_PAYER-OUT
	 * @param P_SUCCESS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_POAD_AGE_CHECK_ENDT(
			String P_ASSRD_TYPE,
			String P_POL_PLAN_CODE,
			String P_POL_JOINT_LIFE_YN,
			String P_POAD_CATG_CODE,
			String P_POAD_CATG_CODE1,
			String P_POAD_AGE,
			String P_POAD_AGE1,
			String P_M_PLAN_AGE_TERM_FLAG,
			String P_G_M_PRIVILEGE,
			String P_G_M_PAYER_FOUND,
			String P_POL_PERIOD,
			String P_M_CALC_METHOD,
			String P_ITEM_POAD_AGE_INSERT,
			String P_ITEM_POAD_AGE1_INSERT,
			String P_G_M_FOUND_PAYER,
			String P_SUCCESS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;

		try {
			connection = CommonUtils.getConnection();
			returnList = new ArrayList<String>();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ASSRD_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_JOINT_LIFE_YN);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAD_CATG_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAD_CATG_CODE1);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAD_AGE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POAD_AGE1);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_M_PLAN_AGE_TERM_FLAG);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_G_M_PRIVILEGE);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_G_M_PAYER_FOUND);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_M_CALC_METHOD);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("OUT14", "STRING", "OUT","");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("OUT16", "STRING", "OUT","");
			parameterList.add(param16);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_POAD_AGE_CHECK_ENDT");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}


	/**
	 * 
	 * @param P_CODE_TYPE-IN
	 * @param P_CODE-IN
	 * @param P_CODE_DESC-IN
	 *                OUT
	 * @param P_NAME_FLAG-IN
	 * @param P_ERR_FLAG-IN
	 * @param P_CLASS_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_VAL_CODES(
			String P_CODE_TYPE,
			String P_CODE,
			String P_CODE_DESC,
			String P_NAME_FLAG,
			String P_ERR_FLAG,
			String P_CLASS_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CODE_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_CODE_DESC);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CLASS_CODE);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_CODES");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}

		return outputList;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_END_CODE-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_POL_START_DT-IN
	 * @param P_M_CALC_METHOD-IN
	 * @param P_POL_END_DT-IN
	 * @param P_POL_ISSUE_DT-IN
	 * @param P_POAD_DOB-IN
	 * @param P_M_PROD_AGE_CALC_FLAG-IN
	 * @param P_M_POL_PLAN_TYPE-IN
	 * @param P_G_M_PRIVILEGE-IN
	 * @param P_G_M_PAYER_FOUND-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_POL_EXPIRY_DT-IN
	 * @param P_POL_MODE_OF_PYMT-IN
	 * @param P_POL_JOINT_LIFE_YN-IN
	 * @param P_POAD_CATG_CODE-IN
	 * @param P_POAD_CATG_CODE1-IN
	 * @param P_M_PLAN_AGE_TERM_FLAG-IN
	 * @param P_POAD_AGE-IN
	 *                OUT
	 * @param P_POAD_AGE1-IN
	 *                OUT
	 * @param P_POL_END_EFF_FROM_DT-IN
	 * @param P_POL_END_EFF_TO_DT-IN
	 *                OUT
	 * @param P_ITEM_POAD_AGE_INSERT-OUT
	 * @param P_ITEM_POAD_AGE1_INSERT-OUT
	 * @param P_G_M_FOUND_PAYER-OUT
	 * @param P_M_SUCCESS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	/*public ArrayList<String> POL_END_EFF_FROM_DT_W_V_I(
			String P_POL_SYS_ID,
			String P_POL_PLAN_CODE,
			String P_POL_END_CODE,
			String P_POL_PROD_CODE,
			String P_POL_END_TYPE,
			String P_POL_START_DT,
			String P_M_CALC_METHOD,
			String P_POL_END_DT,
			String P_POL_ISSUE_DT,
			String P_POAD_DOB,
			String P_M_PROD_AGE_CALC_FLAG,
			String P_M_POL_PLAN_TYPE,
			String P_G_M_PRIVILEGE,
			String P_G_M_PAYER_FOUND,
			String P_POL_PERIOD,
			String P_POL_EXPIRY_DT,
			String P_POL_MODE_OF_PYMT,
			String P_POL_JOINT_LIFE_YN,
			String P_POAD_CATG_CODE,
			String P_POAD_CATG_CODE1,
			String P_M_PLAN_AGE_TERM_FLAG,
			String P_POAD_AGE,
			String P_POAD_AGE1,
			String P_POL_END_EFF_FROM_DT,
			String P_POL_END_EFF_TO_DT,
			String P_ITEM_POAD_AGE_INSERT,
			String P_ITEM_POAD_AGE1_INSERT,
			String P_G_M_FOUND_PAYER,
			String P_M_SUCCESS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_START_DT);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_M_CALC_METHOD);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_END_DT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_ISSUE_DT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POAD_DOB);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_M_PROD_AGE_CALC_FLAG);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_M_POL_PLAN_TYPE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_G_M_PRIVILEGE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_G_M_PAYER_FOUND);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_EXPIRY_DT);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",P_POL_MODE_OF_PYMT);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("IN18", "STRING", "IN",P_POL_JOINT_LIFE_YN);
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN19", "STRING", "IN",P_POAD_CATG_CODE);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("IN20", "STRING", "IN",P_POAD_CATG_CODE1);
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("IN21", "STRING", "IN",P_M_PLAN_AGE_TERM_FLAG);
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("IN OUT22", "STRING", "IN OUT",P_POAD_AGE);
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("IN OUT23", "STRING", "IN OUT",P_POAD_AGE1);
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("IN24", "STRING", "IN",P_POL_END_EFF_FROM_DT);
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("IN OUT25", "STRING", "IN OUT",P_POL_END_EFF_TO_DT);
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("OUT26", "STRING", "OUT","");
			parameterList.add(param26);
			OracleParameter param27 = new OracleParameter("OUT27", "STRING", "OUT","");
			parameterList.add(param27);
			OracleParameter param28 = new OracleParameter("OUT28", "STRING", "OUT","");
			parameterList.add(param28);
			OracleParameter param29 = new OracleParameter("OUT29", "STRING", "OUT","");
			parameterList.add(param29);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.POL_END_EFF_FROM_DT_W_V_I");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}
*/

	
	 /**
	      *
	      * @param P_POL_SYS_ID-IN
	      * @param P_POL_PLAN_CODE-IN
	      * @param P_POL_END_CODE-IN
	      * @param P_POL_PROD_CODE-IN
	      * @param P_POL_END_TYPE-IN
	      * @param P_POL_START_DT-IN
	      * @param P_M_CALC_METHOD-IN
	      * @param P_POL_END_DT-IN
	      * @param P_POL_ISSUE_DT-IN
	      * @param P_POAD_DOB-IN
	      * @param P_M_PROD_AGE_CALC_FLAG-IN
	      * @param P_M_POL_PLAN_TYPE-IN
	      * @param P_G_M_PRIVILEGE-IN
	      * @param P_G_M_PAYER_FOUND-IN
	      * @param P_POL_PERIOD-IN
	      * @param P_POL_EXPIRY_DT-IN
	      * @param P_POL_MODE_OF_PYMT-IN
	      * @param P_POL_JOINT_LIFE_YN-IN
	      * @param P_POAD_CATG_CODE-IN
	      * @param P_POAD_CATG_CODE1-IN
	      * @param P_M_PLAN_AGE_TERM_FLAG-IN
	      * @param P_POAD_AGE-IN OUT
	      * @param P_POAD_AGE1-IN OUT
	      * @param P_POL_END_EFF_FROM_DT-IN
	      * @param P_POL_END_EFF_TO_DT-IN OUT
	      * @param P_ITEM_POAD_AGE_INSERT-OUT
	      * @param P_ITEM_POAD_AGE1_INSERT-OUT
	      * @param P_G_M_FOUND_PAYER-OUT
	      * @param P_M_SUCCESS-OUT
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> POL_END_EFF_FROM_DT_W_V_I(
	                      Object P_POL_SYS_ID,
	           Object P_POL_PLAN_CODE,
	           Object P_POL_END_CODE,
	           Object P_POL_PROD_CODE,
	           Object P_POL_END_TYPE,
	           Object P_POL_START_DT,
	           Object P_M_CALC_METHOD,
	           Object P_POL_END_DT,
	           Object P_POL_ISSUE_DT,
	           Object P_POAD_DOB,
	           Object P_M_PROD_AGE_CALC_FLAG,
	           Object P_M_POL_PLAN_TYPE,
	           Object P_G_M_PRIVILEGE,
	           Object P_G_M_PAYER_FOUND,
	           Object P_POL_PERIOD,
	           Object P_POL_EXPIRY_DT,
	           Object P_POL_MODE_OF_PYMT,
	           Object P_POL_JOINT_LIFE_YN,
	           Object P_POAD_CATG_CODE,
	           Object P_POAD_CATG_CODE1,
	           Object P_M_PLAN_AGE_TERM_FLAG,
	           Object P_POAD_AGE,
	           Object P_POAD_AGE1,
	           Object P_POL_END_EFF_FROM_DT,
	           Object P_POL_END_EFF_TO_DT,
	           Object P_ITEM_POAD_AGE_INSERT,
	           Object P_ITEM_POAD_AGE1_INSERT,
	           Object P_G_M_FOUND_PAYER,
	           Object P_M_SUCCESS) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PLAN_CODE);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_CODE);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
	            parameterList.add(param4);
	            OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
	            parameterList.add(param5);
	            OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_START_DT);
	            parameterList.add(param6);
	            OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_M_CALC_METHOD);
	            parameterList.add(param7);
	            OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_DT);
	            parameterList.add(param8);
	            OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ISSUE_DT);
	            parameterList.add(param9);
	            OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_DOB);
	            parameterList.add(param10);
	            OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PROD_AGE_CALC_FLAG);
	            parameterList.add(param11);
	            OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_PLAN_TYPE);
	            parameterList.add(param12);
	            OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_G_M_PRIVILEGE);
	            parameterList.add(param13);
	            OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_G_M_PAYER_FOUND);
	            parameterList.add(param14);
	            OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_PERIOD);
	            parameterList.add(param15);
	            OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_EXPIRY_DT);
	            parameterList.add(param16);
	            OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_MODE_OF_PYMT);
	            parameterList.add(param17);
	            OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_JOINT_LIFE_YN);
	            parameterList.add(param18);
	            OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_CATG_CODE);
	            parameterList.add(param19);
	            OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_CATG_CODE1);
	            parameterList.add(param20);
	            OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_PLAN_AGE_TERM_FLAG);
	            parameterList.add(param21);
	            OracleParameter param22 = new OracleParameter("IN OUT22", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_AGE);
	            parameterList.add(param22);
	            OracleParameter param23 = new OracleParameter("IN OUT23", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_AGE1);
	            parameterList.add(param23);
	            OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_EFF_FROM_DT);
	            parameterList.add(param24);
	            OracleParameter param25 = new OracleParameter("IN OUT25", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POL_END_EFF_TO_DT);
	            parameterList.add(param25);
	            OracleParameter param26 = new OracleParameter("OUT26", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
	            parameterList.add(param26);
	            OracleParameter param27 = new OracleParameter("OUT27", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
	            parameterList.add(param27);
	            OracleParameter param28 = new OracleParameter("OUT28", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
	            parameterList.add(param28);
	            OracleParameter param29 = new OracleParameter("OUT29", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
	            parameterList.add(param29);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "PKG_PILT002_APAC.POL_END_EFF_FROM_DT_W_V_I");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }

	
	/**
	 * 
	 * @param P_IL_ASSRIND-IN
	 * @param P_POL_CUST_CODE-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_ASSRD_REF_ID1-IN
	 * @param P_POL_ASSRD_REF_ID2-IN
	 * @param P_CALC_METHOD-IN
	 * @param P_POL_CONT_CODE-IN
	 *                OUT
	 * @param P_POL_ASSURED_NAME-OUT
	 * @param P_POL_RES_ADDRESS_1-OUT
	 * @param P_POL_RES_ADDRESS_2-OUT
	 * @param P_POL_RES_ADDRESS_3-OUT
	 * @param P_POL_RES_PHONE_NO-OUT
	 * @param P_POL_FAX_NO-OUT
	 * @param P_POL_RES_AREA_CODE-OUT
	 * @param P_POL_FAX_AREA_CODE-OUT
	 * @param P_POL_CITY_CODE-OUT
	 * @param P_POL_STATE_CODE-OUT
	 * @param P_POL_COUNT_CODE-OUT
	 * @param P_POL_MOBILE_NO-OUT
	 * @param P_POL_CITY_NAME-OUT
	 * @param P_POL_STATE_NAME-OUT
	 * @param P_POL_COUNT_NAME-OUT
	 * @param P_CONT_REF_ID1-OUT
	 * @param P_CONT_REF_ID2-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_DISP_CONT_DETAILS_1(
			String P_IL_ASSRIND,
			String P_POL_CUST_CODE,
			String P_POL_PROD_CODE,
			String P_POL_ASSRD_REF_ID1,
			String P_POL_ASSRD_REF_ID2,
			String P_CALC_METHOD,
			String P_POL_CONT_CODE,
			String P_POL_ASSURED_NAME,
			String P_POL_RES_ADDRESS_1,
			String P_POL_RES_ADDRESS_2,
			String P_POL_RES_ADDRESS_3,
			String P_POL_RES_PHONE_NO,
			String P_POL_FAX_NO,
			String P_POL_RES_AREA_CODE,
			String P_POL_FAX_AREA_CODE,
			String P_POL_CITY_CODE,
			String P_POL_STATE_CODE,
			String P_POL_COUNT_CODE,
			String P_POL_MOBILE_NO,
			String P_POL_CITY_NAME,
			String P_POL_STATE_NAME,
			String P_POL_COUNT_NAME,
			String P_CONT_REF_ID1,
			String P_CONT_REF_ID2) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;

		try {
			connection = CommonUtils.getConnection();
			returnList = new ArrayList<String>();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_IL_ASSRIND);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_CUST_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_ASSRD_REF_ID1);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_ASSRD_REF_ID2);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CALC_METHOD);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_POL_CONT_CODE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("OUT14", "STRING", "OUT","");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("OUT16", "STRING", "OUT","");
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("OUT17", "STRING", "OUT","");
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("OUT18", "STRING", "OUT","");
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("OUT19", "STRING", "OUT","");
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("OUT20", "STRING", "OUT","");
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("OUT21", "STRING", "OUT","");
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("OUT22", "STRING", "OUT","");
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("OUT23", "STRING", "OUT","");
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("OUT24", "STRING", "OUT","");
			parameterList.add(param24);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_DISP_CONT_DETAILS_1");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/**
	 * 
	 * @param P_MODE_OF_PYMT-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> F_GET_MOP_VALUE(
			String P_MODE_OF_PYMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MODE_OF_PYMT);
			parameterList.add(param1);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.F_GET_MOP_VALUE");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	/**
	 * 
	 * @param P_IL_ASSRIND-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_CUST_CODE-IN
	 * @param P_POL_CONT_CODE-IN
	 *                OUT
	 * @param P_POL_MASTER_POL_NO-IN
	 *                OUT
	 * @param P_CALC_METHOD-IN
	 * @param P_POL_DIVN_CODE-IN
	 * @param P_POL_CUST_DESC-IN
	 *                OUT
	 * @param P_POL_CASH_YN-IN
	 *                OUT
	 * @param P_POL_ISSUE_DT-IN
	 * @param P_PARA_7-IN
	 * @param P_POL_ASSURED_NAME-OUT
	 * @param P_POL_RES_ADDRESS_1-OUT
	 * @param P_POL_RES_ADDRESS_2-OUT
	 * @param P_POL_RES_ADDRESS_3-OUT
	 * @param P_POL_RES_PHONE_NO-OUT
	 * @param P_POL_FAX_NO-OUT
	 * @param P_POL_RES_AREA_CODE-OUT
	 * @param P_POL_FAX_AREA_CODE-OUT
	 * @param P_POL_CITY_CODE-OUT
	 * @param P_POL_STATE_CODE-OUT
	 * @param P_POL_COUNT_CODE-OUT
	 * @param P_POL_MOBILE_NO-OUT
	 * @param P_POL_CITY_NAME-OUT
	 * @param P_POL_STATE_NAME-OUT
	 * @param P_POL_COUNT_NAME-OUT
	 * @param P_CONT_REF_ID1-OUT
	 * @param P_CONT_REF_ID2-OUT
	 * @param P_POL_SRC_OF_BUS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_DISP_CONT_DETAILS(
			String P_IL_ASSRIND,
			String P_POL_PROD_CODE,
			String P_POL_CUST_CODE,
			String P_POL_CONT_CODE,
			String P_POL_MASTER_POL_NO,
			String P_CALC_METHOD,
			String P_POL_DIVN_CODE,
			String P_POL_CUST_DESC,
			String P_POL_CASH_YN,
			String P_POL_ISSUE_DT,
			String P_PARA_7,
			String P_POL_ASSURED_NAME,
			String P_POL_RES_ADDRESS_1,
			String P_POL_RES_ADDRESS_2,
			String P_POL_RES_ADDRESS_3,
			String P_POL_RES_PHONE_NO,
			String P_POL_FAX_NO,
			String P_POL_RES_AREA_CODE,
			String P_POL_FAX_AREA_CODE,
			String P_POL_CITY_CODE,
			String P_POL_STATE_CODE,
			String P_POL_COUNT_CODE,
			String P_POL_MOBILE_NO,
			String P_POL_CITY_NAME,
			String P_POL_STATE_NAME,
			String P_POL_COUNT_NAME,
			String P_CONT_REF_ID1,
			String P_CONT_REF_ID2,
			String P_POL_SRC_OF_BUS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_IL_ASSRIND);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_CUST_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_POL_CONT_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_POL_MASTER_POL_NO);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CALC_METHOD);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_DIVN_CODE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_POL_CUST_DESC);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN OUT9", "STRING", "IN OUT",P_POL_CASH_YN);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_ISSUE_DT);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_PARA_7);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("OUT14", "STRING", "OUT","");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("OUT16", "STRING", "OUT","");
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("OUT17", "STRING", "OUT","");
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("OUT18", "STRING", "OUT","");
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("OUT19", "STRING", "OUT","");
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("OUT20", "STRING", "OUT","");
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("OUT21", "STRING", "OUT","");
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("OUT22", "STRING", "OUT","");
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("OUT23", "STRING", "OUT","");
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("OUT24", "STRING", "OUT","");
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("OUT25", "STRING", "OUT","");
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("OUT26", "STRING", "OUT","");
			parameterList.add(param26);
			OracleParameter param27 = new OracleParameter("OUT27", "STRING", "OUT","");
			parameterList.add(param27);
			OracleParameter param28 = new OracleParameter("OUT28", "STRING", "OUT","");
			parameterList.add(param28);
			OracleParameter param29 = new OracleParameter("OUT29", "STRING", "OUT","");
			parameterList.add(param29);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_DISP_CONT_DETAILS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_PROD_CODE-IN
	 * @param P_POL_FRZ_FLAG-IN
	 *                OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> IL_DISC_LOAD_UAS_CHK(
			String P_POL_SYS_ID,
			String P_PROD_CODE,
			String P_POL_FRZ_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_POL_FRZ_FLAG);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_DISC_LOAD_UAS_CHK");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}


	/**
    *
    * @param P_AS_OF_DATE-IN
    * @param P_DOB-IN
    * @param P_AGE_TYP-IN
    * @param P_ANB-IN OUT
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_CALC_ANB(
                    Object P_AS_OF_DATE,
                    Object P_DOB,
                    Object P_AGE_TYP,
                    Object P_ANB) throws ProcedureException {
       	 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_AS_OF_DATE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DOB);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AGE_TYP);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT, P_ANB);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
						"PKG_PILT002_APAC.P_CALC_ANB");
       } catch(Exception e) {
    	   	ErrorHelpUtil.getErrorForProcedure(connection);
    	   	throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }




	/**

	 * @param P_DOC_TYPE-IN
	 * @param P_DOC_CODE-IN
	 * @param P_DIVN_CODE-IN
	 * @param P_CLASS_CODE-IN
	 * @param P_PLAN_CODE-IN
	 * @param P_PROD_CODE-IN
	 * @param P_UW_YEAR-IN
	 * @param P_DOC_NO_FN-IN
	 *                OUT
	 * @param P_BLOCK_NAME-IN
	 * @param P_DUMMY_YN-IN
	 * @param P_DATE-IN
	 * @param P_CLAIM_TYPE-IN
	 * @param P_REG_DATE-IN
	 * @param P_ROWID-IN
	 * @param P_DISABLE_YN-OUT

	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_SET_DOC_NO_PROP(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
			String P_DOC_NO_FN, String P_BLOCK_NAME, String P_DUMMY_YN,
			String P_DATE, String P_CLAIM_TYPE, String P_REG_DATE,
			String P_ROWID, String P_DISABLE_YN) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DOC_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DOC_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_UW_YEAR);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN OUT8", "STRING",
					"IN OUT", P_DOC_NO_FN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_BLOCK_NAME);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_DATE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_CLAIM_TYPE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_REG_DATE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING",
					"IN", P_ROWID);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING",
					"OUT", "");
			parameterList.add(param15);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_SET_DOC_NO_PROP");

		} catch (Exception e) {
		    e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_DS_TYPE-IN
	 * @param P_POL_NO-IN
	 * @param P_PROP_NO-IN
	 * @param P_LC_DEATH_LOAD-OUT
	 * @param P_LC_TPD_LOAD-OUT
	 * @param P_FC_OCC_LOAD-OUT
	 * @param P_LC_OCC_LOAD-OUT
	 * @param P_FC_DEATH_LOAD-OUT
	 * @param P_FC_TPD_LOAD-OUT
	 * @param P_FC_MED_LOAD-OUT
	 * @param P_CUST_CURR_CODE-IN
	 * @param P_LC_MED_LOAD-OUT
	 * @param P_POL_INCORPORATED_YN-IN
	 * @param P_FC_GROSS_CONT-OUT
	 * @param P_LC_GROSS_CONT-OUT
	 * @param P_FC_CHARGE-OUT
	 * @param P_LC_CHARGE-OUT
	 * @param P_NET_PREM_YN-IN
	 * @param P_LC_BROK_COMM-OUT
	 * @param P_FC_BROK_COMM-OUT
	 * @param P_BASE_CURR-IN
	 * @param P_COMPY_FC_CHARGE-OUT
	 * @param P_COMPY_LC_CHARGE-OUT
	 * @param P_FC_INST_PREM-OUT
	 * @param P_LC_INST_PREM-OUT
	 * @param P_FC_CLIENT_ALLOC_AMT-OUT
	 * @param P_FC_SUM_ASSURED-IN
	 *                OUT
	 * @param P_LC_SUM_ASSURED-IN
	 *                OUT
	 * @param P_LC_CLIENT_ALLOC_AMT-OUT
	 * @param P_POL_PROD_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> L_CALC_TAKAFUL_PREM(
			String P_POL_SYS_ID,
			String P_DS_TYPE,
			String P_POL_NO,
			String P_PROP_NO,
			String P_LC_DEATH_LOAD,
			String P_LC_TPD_LOAD,
			String P_FC_OCC_LOAD,
			String P_LC_OCC_LOAD,
			String P_FC_DEATH_LOAD,
			String P_FC_TPD_LOAD,
			String P_FC_MED_LOAD, 
			String P_CUST_CURR_CODE,
			String P_LC_MED_LOAD,
			String P_POL_INCORPORATED_YN,
			String P_FC_GROSS_CONT,
			String P_LC_GROSS_CONT,
			String P_FC_CHARGE,
			String P_LC_CHARGE,
			String P_NET_PREM_YN,
			String P_LC_BROK_COMM,
			String P_FC_BROK_COMM,
			String P_BASE_CURR,
			String P_COMPY_FC_CHARGE, 
			String P_COMPY_LC_CHARGE,
			String P_FC_INST_PREM,
			String P_LC_INST_PREM,
			String P_FC_CLIENT_ALLOC_AMT,
			String P_FC_SUM_ASSURED,
			String P_LC_SUM_ASSURED, 
			String P_LC_CLIENT_ALLOC_AMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DS_TYPE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_POL_NO);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_PROP_NO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5", "STRING",
					"OUT", "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6", "STRING",
					"OUT", "");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("OUT7", "STRING",
					"OUT", "");
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING",
					"OUT", "");
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("OUT9", "STRING",
					"OUT", "");
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("OUT10", "STRING",
					"OUT", "");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11", "STRING",
					"OUT", "");
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_CUST_CURR_CODE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT13", "STRING",
					"OUT", "");
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING",
					"IN", P_POL_INCORPORATED_YN);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING",
					"OUT", "");
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("OUT16", "STRING",
					"OUT", "");
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("OUT17", "STRING",
					"OUT", "");
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("OUT18", "STRING",
					"OUT", "");
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN19", "STRING",
					"IN", P_NET_PREM_YN);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("OUT20", "STRING",
					"OUT", "");
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("OUT21", "STRING",
					"OUT", "");
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("IN22", "STRING",
					"IN", P_BASE_CURR);
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("OUT23", "STRING",
					"OUT", "");
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("OUT24", "STRING",
					"OUT", "");
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("OUT25", "STRING",
					"OUT", "");
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("OUT26", "STRING",
					"OUT", "");
			parameterList.add(param26);
			OracleParameter param27 = new OracleParameter("OUT27", "STRING",
					"OUT", "");
			parameterList.add(param27);
			OracleParameter param28 = new OracleParameter("IN OUT28", "STRING",
					"IN OUT", P_FC_SUM_ASSURED);
			parameterList.add(param28);
			OracleParameter param29 = new OracleParameter("IN OUT29", "STRING",
					"IN OUT", P_LC_SUM_ASSURED);
			parameterList.add(param29);
			OracleParameter param30 = new OracleParameter("OUT30", "STRING",
					"OUT", "");
			parameterList.add(param30);
			

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.L_CALC_TAKAFUL_PREM");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	/**
	 *
	 * @param P_TYPE-IN
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_LC_SUM_ASSURED-IN
	 * @param P_POL_ORG_LC_SUM_ASSURED-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> L_CHECK_MULTIPLE_SA(
			String P_TYPE,
			String P_POL_SYS_ID,
			String P_POL_PLAN_CODE,
			String P_POL_LC_SUM_ASSURED,
			String P_POL_ORG_LC_SUM_ASSURED) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_LC_SUM_ASSURED);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_ORG_LC_SUM_ASSURED);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.L_CHECK_MULTIPLE_SA");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 *
	 * @param P_CURR_CODE-IN
	 * @param P_AMT-IN OUT
	 * @param P_VAL_ROUND-IN
	 * @param P_POL_PROD_CODE-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_VAL_ROUND_AMT(
			String P_CURR_CODE,
			String P_AMT,
			String P_VAL_ROUND,
			String P_POL_PROD_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_AMT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_VAL_ROUND);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_ROUND_AMT");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public ArrayList<String> P_VAL_ROUND_AMT(String P_CURR_CODE, String P_AMT,
			String P_POL_PROD_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING","IN OUT", P_AMT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN4", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_ROUND_AMT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	public void L_CHECK_COVER_CALC(PT_IL_POL_ADDL_COVER_ACTION coverAction,
			PT_IL_POLICY policyBean) throws Exception {
		String CURSOR_C1 = "SELECT COVER_SA_CALC ,COVER_MIN_UNIT FROM PM_IL_COVER WHERE COVER_CODE= ? ";
		String M_COVER_SA_CALC = null;
		Double M_COVER_MIN_UNIT = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_ADDL_COVER coverBean = coverAction
		.getPT_IL_POL_ADDL_COVER_BEAN();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { coverBean.getPOAC_COVER_CODE() });
			if (resultSet.next()) {
				M_COVER_SA_CALC = resultSet.getString(1);
				M_COVER_MIN_UNIT = resultSet.getDouble(2);
			}
			CommonUtils.closeCursor(resultSet);
			if (!("U".equals(M_COVER_SA_CALC))) {
				coverAction.getCOMP_POAC_NO_OF_UNIT().setDisabled(true);
			} else {
				if ("Y".equals(CommonUtils.nvl(policyBean.getPOL_FRZ_FLAG(),"N"))) {
					coverAction.getCOMP_POAC_NO_OF_UNIT().setDisabled(true);
				}
			}
			if ("U".equals(M_COVER_SA_CALC)) {
				coverAction.getCOMP_POAC_FC_SA().setDisabled(false);
				coverAction.getCOMP_POAC_LC_SA().setDisabled(false);
				coverAction.getCOMP_POAC_NO_OF_UNIT().setDisabled(false);
				coverAction.getCOMP_POAC_NO_OF_UNIT().setRequired(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public ArrayList<String> IL_POAD_GET_ASSR_DTLS(String P_POAD_ASSR_CODE,
			String P_ERR_YN, String P_REF_ID1, String P_REF_ID2,
			String P_EXIST, String P_POAD_TYPE,
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		String M_POL_NO = null;
		String M_DESC = null;
		Integer M_PS_VALUE = 0;

		String CURSOR_C1 = "SELECT  POAD_ASSURED_NAME,POAD_BIRTH_PLACE,POAD_DOB,POAD_AGE,POAD_NATIONALITY,"
			+ "POAD_MAR_STATUS,POAD_OCC_CODE,POAD_NATURE_OF_WORK,POAD_HEALTH_CODE,POAD_REMARKS, POL_NO,POAD_CATG_CODE,"
			+ "POAD_HEIGHT,POAD_WEIGHT,NVL(POAD_AGE_PROOF_FLAG,'0'),POAD_AGE_PROOF_OTHERS,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,"
			+ "POAD_SMOKE_YN, POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS, PT_IL_POLICY WHERE POL_SYS_ID = POAD_POL_SYS_ID "
			+ "AND  POAD_ASSR_CODE = ?  AND   POL_NO <>  ? AND POL_SYS_ID <> ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC ";

		String CURSOR_C2 = "SELECT   POAD_ASSR_CODE,POAD_ASSURED_NAME,POAD_BIRTH_PLACE,POAD_DOB,POAD_AGE,POAD_NATIONALITY,"
			+ "POAD_MAR_STATUS,POAD_OCC_CODE,POAD_NATURE_OF_WORK,POAD_HEALTH_CODE,POAD_REMARKS, POL_NO,POAD_CATG_CODE,"
			+ "POAD_HEIGHT,POAD_WEIGHT,NVL(POAD_AGE_PROOF_FLAG,'0'),POAD_AGE_PROOF_OTHERS,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,"
			+ "POAD_BMI,POAD_REF_ID1,POAD_REF_ID2,POAD_OCC_CLASS,POAD_BMI, POAD_RACE,POAD_RELIGION_CODE, "
			+ "DECODE( ? ,'Y',POAD_TYPE,'R'),POAD_HEIGHT_UNIT, POAD_WEIGHT_UNIT,POAD_FC_SALARY,"
			+ " POAD_LC_SALARY,POAD_SMOKE_YN, POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS, PT_IL_POLICY WHERE POL_SYS_ID = POAD_POL_SYS_ID "
			+ "AND POAD_REF_ID1 = ?  AND  POL_NO <>  ? AND POL_SYS_ID <> ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC";

		String CURSOR_C3 = "SELECT   POAD_ASSR_CODE,POAD_ASSURED_NAME,POAD_BIRTH_PLACE,POAD_DOB,POAD_AGE,POAD_NATIONALITY,POAD_MAR_STATUS"
			+ ",POAD_OCC_CODE,POAD_NATURE_OF_WORK,POAD_HEALTH_CODE,POAD_REMARKS, POL_NO,POAD_CATG_CODE,POAD_HEIGHT,POAD_WEIGHT,NVL(POAD_AGE_PROOF_FLAG,'0')"
			+ ",POAD_AGE_PROOF_OTHERS,POAD_DISC_AGE,POAD_ADDL_RISK_CODE,POAD_BMI,POAD_REF_ID1,POAD_REF_ID2,POAD_OCC_CLASS,"
			+ "P0AD_BMI, POAD_RACE,POAD_RELIGION_CODE, DECODE( PT_IL_POLICY.POL_JOINT_LIFE_YN,'Y',POAD_TYPE,'R'),POAD_HEIGHT_UNIT,"
			+ "POAD_WEIGHT_UNIT,POAD_FC_SALARY, POAD_LC_SALARY,POAD_SMOKE_YN, POAD_NO_OF_CIGAR FROM PT_IL_POL_ASSURED_DTLS, "
			+ "PT_IL_POLICY WHERE    POL_SYS_ID = POAD_POL_SYS_ID  AND  POAD_REF_ID2 = ? AND POL_NO <> ? AND POL_SYS_ID <> ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC ";
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ArrayList<String> list = null;
		ArrayList<String> list1 = new ArrayList<String>();
		Connection connection = null;

		CRUDHandler handler = new CRUDHandler();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		DUMMY  DUMMY_OCC_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();
		try {
			connection = CommonUtils.getConnection();
			list = DBProcedures.P_VAL_SYSTEM("IL_CALC_MTHD", "IL_CALC_MTHD",
					M_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			M_DESC = list.get(0);
			M_PS_VALUE = Integer.parseInt(list.get(1));
			if (M_PS_VALUE == 2) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { P_POAD_ASSR_CODE,
						PT_IL_POLICY_BEAN.getPOL_NO(),
						PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if ("R".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet
								.getDate(3));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet
								.getInt(4));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(5));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(resultSet
								.getString(7));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REMARKS(resultSet
								.getString(10));
						M_POL_NO = resultSet.getString(11);
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE(resultSet
								.getString(12));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(13));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(15));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_OTHERS(resultSet
								.getString(16));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(resultSet
								.getInt(17));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(18));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN(resultSet
								.getString(19));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(20));

					}
				} else if ("E".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet
								.getDate(3));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet
								.getInt(4));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(5));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CODE(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REMARKS(resultSet
								.getString(10));
						M_POL_NO = resultSet.getString(11);
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_CATG_CODE(resultSet.getString(12));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(13));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(15));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_OTHERS(resultSet
								.getString(16));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_DISC_AGE(resultSet.getInt(17));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(18));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_SMOKE_YN(resultSet.getString(19));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(20));

					}
				}
				if (resultSet.next()) {
					P_EXIST = "Y";
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71203", new Object[] { M_POL_NO }));
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { P_REF_ID1,
						PT_IL_POLICY_BEAN.getPOL_NO(),
						PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
				if ("R".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {

						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ASSR_CODE(resultSet
								.getString(1));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(3));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet
								.getDate(4));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet
								.getInt(5));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(resultSet
								.getString(8));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(10));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REMARKS(resultSet
								.getString(11));
						M_POL_NO = resultSet.getString(12);
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE(resultSet
								.getString(13));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(15));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(16));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_AGE_PROOF_OTHERS(resultSet
								.getString(17));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DISC_AGE(resultSet
								.getInt(18));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(19));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(resultSet
								.getDouble(20));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID1(resultSet
								.getString(21));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_REF_ID2(resultSet
								.getString(22));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CLASS(resultSet
								.getString(23));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(resultSet
								.getDouble(24));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RACE(resultSet
								.getString(25));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_RELIGION_CODE(resultSet.getString(26));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE(resultSet
								.getString(27));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_HEIGHT_UNIT(resultSet.getString(28));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_WEIGHT_UNIT(resultSet.getString(29));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_FC_SALARY(resultSet
								.getDouble(30));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_LC_SALARY(resultSet
								.getDouble(31));
						PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_SMOKE_YN(resultSet
								.getString(32));
						PT_IL_POL_ASSURED_DTLS_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(33));
					}
				} else if ("E".equals(P_POAD_TYPE)) {
					if (resultSet.next()) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSR_CODE(resultSet.getString(1));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSURED_NAME(resultSet.getString(2));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_BIRTH_PLACE(resultSet.getString(3));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet
								.getDate(4));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet
								.getInt(5));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATIONALITY(resultSet.getString(6));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_MAR_STATUS(resultSet.getString(7));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CODE(resultSet.getString(8));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NATURE_OF_WORK(resultSet.getString(9));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEALTH_CODE(resultSet.getString(10));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REMARKS(resultSet
								.getString(11));
						M_POL_NO = (resultSet.getString(12));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_CATG_CODE(resultSet.getString(13));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT(resultSet
								.getDouble(14));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT(resultSet
								.getDouble(15));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_FLAG(resultSet.getString(16));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_AGE_PROOF_OTHERS(resultSet
								.getString(17));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_DISC_AGE(resultSet.getInt(18));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ADDL_RISK_CODE(resultSet.getString(19));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet
								.getDouble(20));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REF_ID1(resultSet
								.getString(21));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REF_ID2(resultSet
								.getString(22));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_OCC_CLASS(resultSet.getString(23));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet
								.getDouble(24));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RACE(resultSet
								.getString(25));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_RELIGION_CODE(resultSet.getString(26));
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE(resultSet
								.getString(27));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_HEIGHT_UNIT(resultSet.getString(28));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_WEIGHT_UNIT(resultSet.getString(29));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_FC_SALARY(resultSet.getDouble(30));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_LC_SALARY(resultSet.getDouble(31));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_SMOKE_YN(resultSet.getString(32));
						PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_NO_OF_CIGAR(resultSet.getInt(33));
					}
				}
				if (resultSet.next()) {
					P_EXIST = "Y";
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71203", new Object[] { M_POL_NO }));
				} else {
					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] { P_REF_ID2,
							PT_IL_POLICY_BEAN.getPOL_NO(),
							PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
					if ("R".equals(P_POAD_TYPE)) {
						if (resultSet.next()) {
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_ASSR_CODE(resultSet.getString(1));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_ASSURED_NAME(resultSet
									.getString(2));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_BIRTH_PLACE(resultSet.getString(3));
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_DOB(resultSet
									.getDate(4));
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE(resultSet
									.getInt(5));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_NATIONALITY(resultSet.getString(6));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_MAR_STATUS(resultSet.getString(7));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_OCC_CODE(resultSet.getString(8));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_NATURE_OF_WORK(resultSet
									.getString(9));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_HEALTH_CODE(resultSet
									.getString(10));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_REMARKS(resultSet.getString(11));
							M_POL_NO = resultSet.getString(12);
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_CATG_CODE(resultSet.getString(13));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_HEIGHT(resultSet.getDouble(14));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_WEIGHT(resultSet.getDouble(15));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_AGE_PROOF_FLAG(resultSet
									.getString(16));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_AGE_PROOF_OTHERS(resultSet
									.getString(17));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_DISC_AGE(resultSet.getInt(18));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_ADDL_RISK_CODE(resultSet
									.getString(19));
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(resultSet
									.getDouble(20));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_REF_ID1(resultSet.getString(21));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_REF_ID2(resultSet.getString(22));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_OCC_CLASS(resultSet.getString(23));
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BMI(resultSet
									.getDouble(24));
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_RACE(resultSet
									.getString(25));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_RELIGION_CODE(resultSet
									.getString(26));
							PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_TYPE(resultSet
									.getString(27));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_HEIGHT_UNIT(resultSet
									.getString(28));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_WEIGHT_UNIT(resultSet
									.getString(29));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_FC_SALARY(resultSet.getDouble(30));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_LC_SALARY(resultSet.getDouble(31));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_SMOKE_YN(resultSet.getString(32));
							PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_NO_OF_CIGAR(resultSet
									.getInt(33));
						}
					} else if ("E".equals(P_POAD_TYPE)) {
						if (resultSet.next()) {
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_ASSR_CODE(resultSet.getString(1));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_ASSURED_NAME(resultSet
									.getString(2));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_BIRTH_PLACE(resultSet.getString(3));
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet
									.getDate(4));
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet
									.getInt(5));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_NATIONALITY(resultSet.getString(6));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_MAR_STATUS(resultSet.getString(7));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_OCC_CODE(resultSet.getString(8));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_NATURE_OF_WORK(resultSet
									.getString(9));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_HEALTH_CODE(resultSet
									.getString(10));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_REMARKS(resultSet.getString(11));
							M_POL_NO = resultSet.getString(12);
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_CATG_CODE(resultSet.getString(13));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_HEIGHT(resultSet.getDouble(14));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_WEIGHT(resultSet.getDouble(15));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_AGE_PROOF_FLAG(resultSet
									.getString(16));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_AGE_PROOF_OTHERS(resultSet
									.getString(17));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_DISC_AGE(resultSet.getInt(18));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_ADDL_RISK_CODE(resultSet
									.getString(19));
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet
									.getDouble(20));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_REF_ID1(resultSet.getString(21));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_REF_ID2(resultSet.getString(22));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_OCC_CLASS(resultSet.getString(23));
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet
									.getDouble(24));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_RACE(resultSet.getString(25));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_RELIGION_CODE(resultSet
									.getString(26));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_TYPE(resultSet.getString(27));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_HEIGHT_UNIT(resultSet
									.getString(28));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_WEIGHT_UNIT(resultSet
									.getString(29));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_FC_SALARY(resultSet.getDouble(30));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_LC_SALARY(resultSet.getDouble(31));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_SMOKE_YN(resultSet.getString(32));
							PT_IL_POL_ASSURED_DTLS_1_BEAN
							.setPOAD_NO_OF_CIGAR(resultSet
									.getInt(33));
						}
					}
					if (resultSet.next()) {
						P_EXIST = "Y";
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
										"71203", new Object[] { M_POL_NO }));
					}
					CommonUtils.closeCursor(resultSet);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		list1.add(P_EXIST);
		return list1;
	}

	public Integer IL_DISC_AGE(Integer P_CURR_AGE, String P_CATG_CODE,
			String P_ADDL_RISK_CODE, java.util.Date P_START_DT,
			Integer P_DISC_AGE) throws Exception {

		int M_DA_UW_AGE;
		String M_COVER_DISC_AGE_YN = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		String POL_PLAN_CODE = new PILQ003_COMPOSITE_ACTION()
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
		.getPOL_PLAN_CODE();
		Object[] values = null;
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();

		String CURSER_C1 = "SELECT DA_UW_AGE FROM   PM_IL_DISC_AGE WHERE  DA_ADDL_RISK_CODE = ?"
			+ " AND    DA_CATG_CODE = ?  AND   P_EFF_DT  BETWEEN NVL(DA_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/YYYY'))"
			+ " AND NVL(DA_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/YYYY'))";
		String CURSER_C2 = "SELECT NVL(COVER_DISC_AGE_YN,'N') FROM   PM_IL_COVER"
			+ " WHERE  COVER_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSER_C2, connection,
					new Object[] { POL_PLAN_CODE });
			if (resultSet.next()) {
				M_COVER_DISC_AGE_YN = resultSet.getString(1);
			}

			if ("Y".equals(M_COVER_DISC_AGE_YN)) {
				resultSet1 = handler.executeSelectStatement(CURSER_C1,
						connection, new Object[] { P_ADDL_RISK_CODE,
						P_CATG_CODE });
				if (resultSet1.next()) {
					M_DA_UW_AGE = resultSet.getInt(1);
					P_DISC_AGE = CommonUtils.nvl(P_CURR_AGE, 0)
					- CommonUtils.nvl(M_DA_UW_AGE, 0);
				} else {
					P_DISC_AGE = CommonUtils.nvl(P_CURR_AGE, 0);
				}

			} else {
				P_DISC_AGE = CommonUtils.nvl(P_CURR_AGE, 0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
			try {CommonUtils.closeCursor(resultSet1);} catch (Exception e) {}
		}
		return P_DISC_AGE;
	}
	/**
	 * 
	 * @param P_CUST_DOB-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_JOINT_LIFE_YN-IN
	 * @param P_POAD_CATG_CODE-IN
	 * @param P_POAD_CATG_CODE1-IN
	 * @param P_POAD_AGE1-IN
	 * @param P_POL_START_DT-IN
	 * @param P_M_PROD_AGE_CALC_FLAG-IN
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_ISSUE_DT-IN
	 * @param RECORD_STATUS-IN
	 * @param P_M_PROD_PERIOD_MULTIPLE-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_M_CUST_AGE-OUT
	 * @param P_POL_PERIOD-OUT
	 * @param P_POL_PREM_PAY_YRS-IN
	 *                OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_CAL_PLAN_PERIOD(
			String P_CUST_DOB,
			String P_POL_PLAN_CODE,
			String P_POL_JOINT_LIFE_YN,
			String P_POAD_CATG_CODE,
			String P_POAD_CATG_CODE1,
			String P_POAD_AGE1,
			String P_POL_START_DT,
			String P_M_PROD_AGE_CALC_FLAG,
			String P_POL_SYS_ID,
			String P_POL_ISSUE_DT,
			String RECORD_STATUS,
			String P_M_PROD_PERIOD_MULTIPLE,
			String P_POL_END_TYPE,
			String P_M_CUST_AGE,
			String P_POL_PERIOD,
			String P_POL_PREM_PAY_YRS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CUST_DOB);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_JOINT_LIFE_YN);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POAD_CATG_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POAD_CATG_CODE1);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAD_AGE1);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_START_DT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_M_PROD_AGE_CALC_FLAG);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_ISSUE_DT);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",RECORD_STATUS);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_M_PROD_PERIOD_MULTIPLE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("OUT14", "STRING", "OUT","");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN OUT16", "STRING", "IN OUT",P_POL_PREM_PAY_YRS);
			parameterList.add(param16);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_CAL_PLAN_PERIOD");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	public void P_CAL_PLAN_PERIOD(Date date,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN) throws Exception {

		String M_DUM_VALUE = null;
		String M_DUM_DESC = null;
		Integer M_PLAN_MAX_AGE_ON_MAT = null;
		Integer P_POAD_AGE = null;

		Date M_CUST_DOB;
		String M_PLAN_AGE_TERM_FLAG = null;
		Integer M_PLAN_AGE_FROM = null;
		Integer M_PLAN_AGE_TO = null;
		String M_PAS_AGE_BASIS = null;
		Integer M_PAS_MIN_AGE = null;
		Integer M_PAS_MAX_AGE = null;
		Integer M_PAS_MIN_PERIOD = null;
		Integer M_PAS_MAX_PERIOD = null;
		Integer M_PAS_MAX_AGE_ON_MAT = null;
		String M_PAYER_PAYEE = null;
		Integer M_PLAN_PERIOD_FROM = null;
		Integer M_PLAN_PERIOD_TO = null;
		String M_PLAN_TYPE = null;
		String M_PMA_AGE_BASIS = null;
		Integer M_PMA_MAT_PAYER_AGE = null;
		Integer M_PMA_MAT_PAYEE_AGE = null;
		Integer M_PLAN_MIN_AGE_ON_MAT = null;
		Integer M_PMA_MAT_MIN_PAYER_AGE = null;
		Integer M_PMA_MAT_MIN_PAYEE_AGE = null;
		Long M_POAC_SYS_ID = null;
		Long M_POAC_POL_SYS_ID = null;
		String M_POAC_COVER_CODE;
		Integer M_POAC_PREM_PAY_YRS;
		Integer M_POAC_PERIOD;
		Integer M_ADDLCOVER_DIFF;
		String CURSOR_C1 = "SELECT PLAN_MAX_AGE_ON_MAT,PLAN_MIN_AGE_ON_MAT,PLAN_AGE_TERM_FLAG,"
			+ "PLAN_AGE_FROM,PLAN_AGE_TO,PLAN_PERIOD_FROM, PLAN_PERIOD_TO, PLAN_TYPE "
			+ "FROM PM_IL_PLAN WHERE  PLAN_CODE =  ?  AND PLAN_FRZ_FLAG = 'N'";
		String CURSOR_C2 = "SELECT PAS_MIN_AGE,PAS_MAX_AGE,PAS_MIN_PERIOD,PAS_MAX_PERIOD,"
			+ "PAS_MAX_AGE_ON_MAT FROM   PM_IL_PLAN_AGE_SETUP WHERE  PAS_PLAN_CODE = ?"
			+ "AND  PAS_JOINT_LIFE_YN = ? AND DECODE(M_PAYER_PAYEE,'R',?,?) BETWEEN PAS_CATG_FM_CODE "
			+ "AND PAS_CATG_TO_CODE AND  P_POAD_AGE  BETWEEN  PAS_ASSRD_AGE_FM  AND  PAS_ASSRD_AGE_TO "
			+ "AND  PAS_AGE_BASIS = ? ";
		String CURSOR_C3 = "SELECT PMA_AGE_BASIS,PMA_MAT_PAYER_AGE,PMA_MAT_PAYEE_AGE,PMA_MAT_MIN_PAYER_AGE,"
			+ "PMA_MAT_MIN_PAYEE_AGE FROM PM_IL_PLAN_MAT_AGESETUP WHERE PMA_PLAN_CODE = ? ";
		String CURSOR_C4 = "SELECT POAC_SYS_ID,POAC_POL_SYS_ID,POAC_COVER_CODE,POAC_PREM_PAY_YRS,POAC_PERIOD,(NVL(POAC_ORG_PERIOD,0)-NVL(POAC_ORG_PREM_PAY_YRS,0))"
			+ " FROM  PT_IL_POL_ASSURED_DTLS,PT_IL_POL_ADDL_COVER WHERE  POAD_SYS_ID =  POAC_POAD_SYS_ID AND POAD_POL_SYS_ID = ? ";
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		ArrayList<String> list = null;
		ArrayList<OracleParameter> list1 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (resultSet.next()) {
				M_PLAN_MAX_AGE_ON_MAT = resultSet.getInt(1);
				M_PLAN_MIN_AGE_ON_MAT = resultSet.getInt(2);
				M_PLAN_AGE_TERM_FLAG = resultSet.getString(3);
				M_PLAN_AGE_FROM = resultSet.getInt(4);
				M_PLAN_AGE_TO = resultSet.getInt(5);
				M_PLAN_PERIOD_FROM = resultSet.getInt(6);
				M_PLAN_PERIOD_TO = resultSet.getInt(7);
				M_PLAN_TYPE = resultSet.getString(8);
			}
			CommonUtils.closeCursor(resultSet);
			list = DBProcedures.P_VAL_SYSTEM("IL_AGE_CAL", "IL_AGE_CAL",
					M_DUM_DESC, "N", M_DUM_VALUE);
			M_DUM_DESC = list.get(0);
			M_DUM_VALUE = list.get(1);
			if ("1".equals(M_DUM_VALUE)) {
				list1 = localProcedure.P_CALC_ANB(
						PT_IL_POLICY_BEAN.getPOL_START_DT(),
						date, DUMMY_OCC_BEAN.getUI_M_PROD_AGE_CALC_FLAG(),
						P_POAD_AGE);
				P_POAD_AGE = (Integer)list1.get(0).getValueObject();
			} else {
				list1 = localProcedure.P_CALC_ANB(
						PT_IL_POLICY_BEAN.getPOL_START_DT(),
						date, DUMMY_OCC_BEAN.getUI_M_PROD_AGE_CALC_FLAG(),
						P_POAD_AGE);
				P_POAD_AGE = (Integer)list1.get(0).getValueObject();
			}
			DUMMY_OCC_BEAN.setUI_M_AGE(P_POAD_AGE);
			if ("H".equals(M_PLAN_AGE_TERM_FLAG)) {
				if (P_POAD_AGE != null) {
					if ((CommonUtils.nvl(M_PLAN_MAX_AGE_ON_MAT, 0))- (CommonUtils.nvl(P_POAD_AGE, 0)) >= 0) {
						if (("D".equals(M_PLAN_TYPE)) 
								&& ("013".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),"000")))) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer) (CommonUtils.nvl(M_PLAN_MAX_AGE_ON_MAT, 0) - CommonUtils.nvl(P_POAD_AGE, 0)));
						} else {
							if (CommonUtils.nvl(P_POAD_AGE, 0)+ CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0)> CommonUtils.nvl(M_PLAN_MAX_AGE_ON_MAT, 0)
											|| PT_IL_POL_ASSURED_DTLS_BEAN.getROWID() == null) {
								PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer) CommonUtils.nvl(M_PLAN_MAX_AGE_ON_MAT, 0)- CommonUtils.nvl(P_POAD_AGE, 0));
							}

						}
					}
					if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
						PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer)PT_IL_POLICY_BEAN.getPOL_PERIOD()
						- ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(),1).intValue())));
					}
					if (CommonUtils.nvl(P_POAD_AGE, 0)+ CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0) < CommonUtils.nvl(M_PLAN_MIN_AGE_ON_MAT, 0)) {
						PT_IL_POLICY_BEAN.setPOL_PERIOD((Integer) CommonUtils.nvl(M_PLAN_MIN_AGE_ON_MAT, 0)- CommonUtils.nvl(P_POAD_AGE, 0));
					}
					if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
						PT_IL_POLICY_BEAN.setPOL_PERIOD(PT_IL_POLICY_BEAN.getPOL_PERIOD()+ (DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE() - 
										(PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(),1))));
					}
					if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS(), 0) > CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0)) {
						PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(),0));
					}
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206",
						new Object[] {CommonUtils.nvl(M_PLAN_AGE_FROM,0),CommonUtils.nvl(M_PLAN_AGE_TO,0) }));
				}
			} else if ("S".equals(M_PLAN_AGE_TERM_FLAG)) {
				resultSet = handler.executeSelectStatement(CURSOR_C3,connection, 
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
				if (resultSet.next()) {
					M_PMA_AGE_BASIS = resultSet.getString(1);
					M_PMA_MAT_PAYER_AGE = resultSet.getInt(2);
					M_PMA_MAT_PAYEE_AGE = resultSet.getInt(2);
					M_PMA_MAT_MIN_PAYER_AGE = resultSet.getInt(2);
					M_PMA_MAT_MIN_PAYEE_AGE = resultSet.getInt(2);
				}
				CommonUtils.closeCursor(resultSet);
				if ("R".equals(M_PMA_AGE_BASIS)) {
					if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() != null) {
						P_POAD_AGE = PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE();
					}
					if (P_POAD_AGE != null) {
						if (P_POAD_AGE + PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYER_AGE) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(M_PMA_MAT_PAYER_AGE - P_POAD_AGE);
						}
						if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
								.nvl(DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD(PT_IL_POLICY_BEAN.getPOL_PERIOD()
							- (PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils.nvl(
									DUMMY_OCC_BEAN.getUI_M_PROD_PERIOD_MULTIPLE(),1)));
						}
						if (CommonUtils.nvl(P_POAD_AGE, 0)
								+ CommonUtils.nvl(PT_IL_POLICY_BEAN
										.getPOL_PERIOD(), 0) < CommonUtils.nvl(
												M_PMA_MAT_MIN_PAYER_AGE, 0)) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD( (CommonUtils.nvl(
									M_PMA_MAT_MIN_PAYER_AGE, 0) - CommonUtils
									.nvl(P_POAD_AGE, 0)));
						}
						if (PT_IL_POLICY_BEAN.getPOL_PERIOD()
								% CommonUtils.nvl(DUMMY_OCC_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1) > 0) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									+ (DUMMY_OCC_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE() - (PT_IL_POLICY_BEAN
													.getPOL_PERIOD() % CommonUtils
													.nvl(
															DUMMY_OCC_BEAN
															.getUI_M_PROD_PERIOD_MULTIPLE(),
															1))));
						}
					}
				} else if ("E".equals(M_PMA_AGE_BASIS)) {
					if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE() != null) {
						if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE()
								+ PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYEE_AGE) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD(M_PMA_MAT_PAYEE_AGE
									- PT_IL_POL_ASSURED_DTLS_1_BEAN
									.getPOAD_AGE());
						}
						if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
								.nvl(
										DUMMY_OCC_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									- (PT_IL_POLICY_BEAN
											.getPOL_PERIOD() % CommonUtils
											.nvl(
													DUMMY_OCC_BEAN
													.getUI_M_PROD_PERIOD_MULTIPLE(),
													1)));
						}
						if (CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN
								.getPOAD_AGE(), 0)
								+ CommonUtils.nvl(PT_IL_POLICY_BEAN
										.getPOL_PERIOD(), 0) < CommonUtils.nvl(
												M_PMA_MAT_MIN_PAYEE_AGE, 0)) {
							PT_IL_POLICY_BEAN.setPOL_PERIOD(CommonUtils.nvl(
									M_PMA_MAT_MIN_PAYEE_AGE, 0)
									- CommonUtils.nvl(
											PT_IL_POL_ASSURED_DTLS_1_BEAN
											.getPOAD_AGE(), 0));
						}
						if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
								.nvl(
										DUMMY_OCC_BEAN
										.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
							PT_IL_POLICY_BEAN
							.setPOL_PERIOD(PT_IL_POLICY_BEAN
									.getPOL_PERIOD()
									+ (DUMMY_OCC_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE() - (PT_IL_POLICY_BEAN
													.getPOL_PERIOD() % CommonUtils
													.nvl(
															DUMMY_OCC_BEAN
															.getUI_M_PROD_PERIOD_MULTIPLE(),
															1))));
						}
					}
				} else if ("M".equals(M_PMA_AGE_BASIS)) {
					if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() != null
							&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE() != null) {
						if (M_PMA_MAT_PAYER_AGE
								- PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE() < (M_PMA_MAT_PAYEE_AGE - PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE())) {
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYER_AGE
									- PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_PAYER_AGE
										- PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_AGE());
							}
							if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
									.nvl(DUMMY_OCC_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(PT_IL_POLICY_BEAN
										.getPOL_PERIOD()
										- (PT_IL_POLICY_BEAN
												.getPOL_PERIOD() % CommonUtils
												.nvl(
														DUMMY_OCC_BEAN
														.getUI_M_PROD_PERIOD_MULTIPLE(),
														1)));
							}
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() < (M_PMA_MAT_MIN_PAYER_AGE - PT_IL_POL_ASSURED_DTLS_BEAN
									.getPOAD_AGE())) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_MIN_PAYER_AGE
										- PT_IL_POL_ASSURED_DTLS_BEAN
										.getPOAD_AGE());
							}
						} else if ((M_PMA_MAT_PAYER_AGE - PT_IL_POL_ASSURED_DTLS_BEAN
								.getPOAD_AGE()) > (M_PMA_MAT_PAYEE_AGE - PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE())) {
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() > M_PMA_MAT_PAYEE_AGE
									- PT_IL_POL_ASSURED_DTLS_1_BEAN
									.getPOAD_AGE()) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_PAYEE_AGE
										- PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE());
							}
							if ((PT_IL_POLICY_BEAN.getPOL_PERIOD() % CommonUtils
									.nvl(DUMMY_OCC_BEAN
											.getUI_M_PROD_PERIOD_MULTIPLE(), 1)) > 0) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(PT_IL_POLICY_BEAN
										.getPOL_PERIOD()
										- (PT_IL_POLICY_BEAN
												.getPOL_PERIOD() % CommonUtils
												.nvl(
														DUMMY_OCC_BEAN
														.getUI_M_PROD_PERIOD_MULTIPLE(),
														1)));
							}
							if (PT_IL_POLICY_BEAN.getPOL_PERIOD() < (M_PMA_MAT_MIN_PAYEE_AGE - PT_IL_POL_ASSURED_DTLS_1_BEAN
									.getPOAD_AGE())) {
								PT_IL_POLICY_BEAN
								.setPOL_PERIOD(M_PMA_MAT_MIN_PAYEE_AGE
										- PT_IL_POL_ASSURED_DTLS_1_BEAN
										.getPOAD_AGE());
							}
						}
					}
				}
				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS(), 0) > CommonUtils
						.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0)) {
					PT_IL_POLICY_BEAN.setPOL_PREM_PAY_YRS(CommonUtils.nvl(
							PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0));
				}
				if ("013".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
					resultSet = handler.executeSelectStatement(CURSOR_C4,
							connection, new Object[] {});
					while (resultSet.next()) {
						M_POAC_SYS_ID = resultSet.getLong(1);
						M_POAC_POL_SYS_ID = resultSet.getLong(2);
						M_POAC_COVER_CODE = resultSet.getString(3);
						M_POAC_PREM_PAY_YRS = resultSet.getInt(4);
						M_POAC_PERIOD = resultSet.getInt(5);
						M_ADDLCOVER_DIFF = resultSet.getInt(6);

						if (M_POAC_PERIOD > PT_IL_POLICY_BEAN.getPOL_PERIOD()) {

							String UPDATE_QUERY = "UPDATE PT_IL_POL_ADDL_COVER SET  POAC_PERIOD = ? "
								+ ",POAC_PREM_PAY_YRS =LEAST((?  - M_ADDLCOVER_DIFF ),?) WHERE  POAC_SYS_ID = ?  AND POAC_POL_SYS_ID = ? ";
							int returnValue = handler.executeUpdateStatement(
									UPDATE_QUERY, connection, new Object[] {
											PT_IL_POLICY_BEAN.getPOL_PERIOD(),
											PT_IL_POLICY_BEAN.getPOL_PERIOD(),
											PT_IL_POLICY_BEAN
											.getPOL_PREM_PAY_YRS(),
											M_POAC_SYS_ID, M_POAC_POL_SYS_ID });
						}
					}
					CommonUtils.closeCursor(resultSet);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}



	// Added By Dileshwar Patle Date :- 04/08/2011
	public void L_LOAD_MEDICAL_HISTORY(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSR_MED_HIST_ACTION medHistAction , com.iii.pel.forms.PILQ003.BP bpBean) throws Exception {
		int M_COUNT;
		String M_DMH_CAPTION = null;
		String M_DMH_BL_CAPTION = null;
		String M_DMH_DATA_TYPE = null;
		String M_DMH_MANDATORY_YN = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String langcode = CommonUtils
		.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
		PT_IL_POL_ASSR_MED_HIST medHistBean = medHistAction.getPT_IL_POL_ASSR_MED_HIST_BEAN();
		String paddedString = null;
		String fieldName = null;
		Method method = null;
		UIInput uiInput = null;
		M_COUNT = 1;
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();

		String CURSOR_C1 = "SELECT  DMH_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N')"
			+ "FROM  PM_IL_DOC_MED_HIST  WHERE  DMH_DS_TYPE = ?  AND DMH_DS_CODE = ? "
			+ "AND  DMH_APPL_ON IN ('R', 'B') AND     ROWNUM  <= 20 ";

		String CURSOR_C2 = "SELECT  DMH_BL_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N') "
			+ "FROM  PM_IL_DOC_MED_HIST  WHERE DMH_DS_TYPE = ?  AND DMH_DS_CODE =  ?  "
			+ "AND DMH_APPL_ON IN ('R','B') AND     ROWNUM  <=20";

		try {
			connection = CommonUtils.getConnection();
			if ("1".equals(CommonUtils.SUBSTR(langcode,5, 6))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
						PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					paddedString = M_COUNT < 10 ? "0" + M_COUNT : String
							.valueOf(M_COUNT);
					M_DMH_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);

					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
					.getMethod("set" + fieldName, String.class);
					method.invoke(bpBean, M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistAction);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						uiInput.setRequired(true);
					} else {
						uiInput.setRequired(false);
					}

					M_COUNT++;
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
						PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					paddedString = M_COUNT < 10 ? "0" + M_COUNT : String
							.valueOf(M_COUNT);
					M_DMH_BL_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
					.getMethod("set" + fieldName, String.class);
					method.invoke(bpBean, M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistAction);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						uiInput.setRequired(true);
					} else {
						uiInput.setRequired(false);
					}

					M_COUNT++;
				}
			}
			
				for (int i = (int) M_COUNT; i <= 20; i++) {
					paddedString = i < 10 ? "0" + i : String.valueOf(i);
					//M_DMH_BL_CAPTION = resultSet.getString(1);
					//M_DMH_DATA_TYPE = resultSet.getString(2);
					//M_DMH_MANDATORY_YN = resultSet.getString(3);
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
					.getMethod("set" + fieldName, String.class);
					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST.class.getMethod("set"
							+ fieldName, String.class);
					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistAction);
					uiInput.setRendered(false);
				}
				CommonUtils.closeCursor(resultSet);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_BLOCK_POL_ENABLED(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_ASD_CHAR_VALUE = null;
		String M_CHAR_CODE = null;
		String CURSOR_C1 = "SELECT  ASD_CHAR_VALUE FROM " +
				"   PM_IL_APPR_SETUP_DET WHERE   ASD_USER_ID = ? "
			+ "AND  ASD_CODE = ? AND  ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0')" +
					" AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}
			M_CHAR_CODE = "MOD_COMM_YN";
			resultSet = handler
			.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {
					compositeAction.getCTRL_ACTION_BEAN()
					.getCTRL_BEAN().getUSER_ID(),
					M_CHAR_CODE,
					compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN()
					.getPOL_PROD_CODE() });
			if (resultSet.next()) {
				M_ASD_CHAR_VALUE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("Y".equals(M_ASD_CHAR_VALUE)) {
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
					.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
					.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
					.setDELETE_ALLOWED(true);
				}
			} else {
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
				.setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
				.setUPDATE_ALLOWED(false);
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
				.setDELETE_ALLOWED(false);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.setDELETE_ALLOWED(true);
			}

			if ("N".equals(compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN().getUI_M_NOTIONAL())) {
				compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
				.setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
				.setUPDATE_ALLOWED(false);
				compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
				.setDELETE_ALLOWED(false);
			} else if ("0".equals(compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN().getUI_M_NOTIONAL())) {
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
					.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
					.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
					.setDELETE_ALLOWED(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void IL_BLOCK_POL_DISABLED(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
		.setDELETE_ALLOWED(false);


		compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
		.setDELETE_ALLOWED(false);


		compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setDELETE_ALLOWED(false);

		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		if ("S".equals(CommonUtils.nvl(compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_STATUS(), "N"))) {
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
		} else {
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.setINSERT_ALLOWED(false);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.setUPDATE_ALLOWED(false);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.setDELETE_ALLOWED(false);
		}

		compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);
	}
	/**
	 * 
	 * @param P_CURR_CODE-IN
	 * @param P_BUY_SELL-IN
	 * @param P_EFF_DT-IN
	 * @param P_EXHG_RATE-IN
	 *                OUT
	 * @param P_WAR_ERR-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_GET_EXCHANGE_RATE(
			String P_CURR_CODE,
			String P_BUY_SELL,
			String P_EFF_DT,
			String P_EXHG_RATE,
			String P_WAR_ERR) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BUY_SELL);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_EXHG_RATE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_WAR_ERR);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_GET_EXCHANGE_RATE");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			String value=oracleParameter.getValue();
			System.out.println("Output value:::" + value);
			returnList.add(value);
		}
		return returnList;
	}

	// Added By Dileshwar Patle Date :- 04/08/2011
	public void L_LOAD_MEDICAL_HISTORY_1(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSR_MED_HIST_1_ACTION medHistActBean, com.iii.pel.forms.PILQ003.BP bpBean) throws Exception {
		int M_COUNT;
		String M_DMH_CAPTION = null;
		String M_DMH_BL_CAPTION = null;
		String M_DMH_DATA_TYPE = null;
		String M_DMH_MANDATORY_YN = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String langcode = CommonUtils
		.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");

		String paddedString = null;
		String fieldName = null;
		Method method = null;
		UIInput uiInput = null;
		M_COUNT = 1;
		PT_IL_POL_ASSR_MED_HIST_1 medHistBean = medHistActBean.getPT_IL_POL_ASSR_MED_HIST_1_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();

		String CURSOR_C1 = "SELECT  DMH_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N')"
			+ "FROM  PM_IL_DOC_MED_HIST  WHERE  DMH_DS_TYPE = ?  AND DMH_DS_CODE = ? "
			+ "AND  DMH_APPL_ON IN ('E', 'B') AND     ROWNUM  <= 20 ";

		String CURSOR_C2 = "SELECT  DMH_BL_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N') "
			+ "FROM  PM_IL_DOC_MED_HIST  WHERE DMH_DS_TYPE = ?  AND DMH_DS_CODE =  ?  "
			+ "AND DMH_APPL_ON IN ('E','B') AND     ROWNUM  <=20";

		try { connection = CommonUtils.getConnection();
			if ("1".equals(CommonUtils.SUBSTR(langcode,5, 6))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
						PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					paddedString = M_COUNT < 10 ? "0" + M_COUNT : String
							.valueOf(M_COUNT);
					M_DMH_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);

					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
					.getMethod("set" + fieldName, String.class);
					method.invoke(bpBean, M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistBean);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						uiInput.setRequired(true);
					} else {
						uiInput.setRequired(false);
					}

					M_COUNT++;
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
						PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
						PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					paddedString = M_COUNT < 10 ? "0" + M_COUNT : String
							.valueOf(M_COUNT);
					M_DMH_BL_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
					.getMethod("set" + fieldName, String.class);
					method.invoke(bpBean, M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistBean);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						uiInput.setRequired(true);
					} else {
						uiInput.setRequired(false);
					}

					M_COUNT++;
				}
			}
				CommonUtils.closeCursor(resultSet);
				for (int i = M_COUNT; i <= 20; i++) {
					paddedString = i < 10 ? "0" + i : String.valueOf(i);
					/*M_DMH_BL_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);*/
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
					.getMethod("set" + fieldName, String.class);
					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1.class.getMethod("set"
							+ fieldName, String.class);
					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1_ACTION.class.getMethod("get"
							+ fieldName);
					uiInput = (UIInput) method.invoke(medHistActBean);
					uiInput.setRendered(false);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 *
	 * @param P_M_IL_ASSRIND-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_JOINT_LIFE_YN-IN
	 * @param P_POL_CUST_CODE-IN
	 * @param P_POAD_CATG_CODE-IN
	 * @param P_POAD_CATG_CODE1-IN
	 * @param P_POAD_AGE1-IN
	 * @param P_POL_START_DT-IN
	 * @param P_M_PROD_AGE_CALC_FLAG-IN
	 * @param P_POL_ISSUE_DT-IN
	 * @param P_POL_ASSRD_REF_ID1-IN
	 * @param P_POL_ASSRD_REF_ID2-IN
	 * @param P_M_POL_PLAN_TYPE-IN
	 * @param P_M_PROD_PERIOD_MULTIPLE-IN
	 * @param P_POL_END_TYPE-IN
	 * @param RECORD_STATUS-IN
	 * @param P_POL_CONT_CODE-IN OUT
	 * @param P_POL_PREM_PAY_YRS-IN OUT
	 * @param P_POL_ASSURED_NAME-OUT
	 * @param P_POL_RES_ADDRESS_1-OUT
	 * @param P_POL_RES_ADDRESS_2-OUT
	 * @param P_POL_RES_ADDRESS_3-OUT
	 * @param POL_RES_AREA_CODE-OUT
	 * @param P_POL_RES_PHONE_NO-OUT
	 * @param P_POL_FAX_NO-OUT
	 * @param P_POL_RES_AREA_CODE-OUT
	 * @param P_POL_FAX_AREA_CODE-OUT
	 * @param P_POL_CITY_CODE-OUT
	 * @param P_POL_STATE_CODE-OUT
	 * @param P_POL_COUNT_CODE-OUT
	 * @param P_M_POL_COUNT_NAME-OUT
	 * @param P_M_POL_CITY_NAME-OUT
	 * @param P_M_POL_STATE_NAME-OUT
	 * @param P_POL_MOBILE_NO-OUT
	 * @param P_M_CONT_REF_ID1-OUT
	 * @param P_M_CONT_REF_ID2-OUT
	 * @param P_M_CUST_AGE-OUT
	 * @param P_POL_PERIOD- IN OUT
	 * @param P_M_CALC_METHOD-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */

	public ArrayList<String> POL_CONT_CODE_W_V_I(
			String P_M_IL_ASSRIND,
			String P_POL_PLAN_CODE,
			String P_POL_SYS_ID,
			String P_POL_JOINT_LIFE_YN,
			String P_POL_CUST_CODE,
			String P_POAD_CATG_CODE,
			String P_POAD_CATG_CODE1,
			String P_POAD_AGE1,
			String P_POL_START_DT,
			String P_M_PROD_AGE_CALC_FLAG,
			String P_POL_ISSUE_DT,
			String P_POL_ASSRD_REF_ID1,
			String P_POL_ASSRD_REF_ID2,
			String P_M_POL_PLAN_TYPE,
			String P_M_PROD_PERIOD_MULTIPLE,
			String P_POL_END_TYPE,
			String RECORD_STATUS,
			String P_POL_CONT_CODE,
			String P_POL_PREM_PAY_YRS,
			String P_POL_ASSURED_NAME,
			String P_POL_RES_ADDRESS_1,
			String P_POL_RES_ADDRESS_2,
			String P_POL_RES_ADDRESS_3,
			String POL_RES_AREA_CODE,
			String P_POL_RES_PHONE_NO,
			String P_POL_FAX_NO,
			String P_POL_RES_AREA_CODE,
			String P_POL_FAX_AREA_CODE,
			String P_POL_CITY_CODE,
			String P_POL_STATE_CODE,
			String P_POL_COUNT_CODE,
			String P_M_POL_COUNT_NAME,
			String P_M_POL_CITY_NAME,
			String P_M_POL_STATE_NAME,
			String P_POL_MOBILE_NO,
			String P_M_CONT_REF_ID1,
			String P_M_CONT_REF_ID2,
			String P_M_CUST_AGE,
			String P_POL_PERIOD,
			String P_M_CALC_METHOD) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_M_IL_ASSRIND);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_JOINT_LIFE_YN);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_CUST_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAD_CATG_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POAD_CATG_CODE1);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POAD_AGE1);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_START_DT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_M_PROD_AGE_CALC_FLAG);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_POL_ISSUE_DT);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_ASSRD_REF_ID1);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_ASSRD_REF_ID2);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_M_POL_PLAN_TYPE);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_M_PROD_PERIOD_MULTIPLE);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN17", "STRING", "IN",RECORD_STATUS);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("IN OUT18", "STRING", "IN OUT",P_POL_CONT_CODE);
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("IN OUT19", "STRING", "IN OUT",P_POL_PREM_PAY_YRS);
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("OUT20", "STRING", "OUT","");
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("OUT21", "STRING", "OUT","");
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("OUT22", "STRING", "OUT","");
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("OUT23", "STRING", "OUT","");
			parameterList.add(param23);
			OracleParameter param24 = new OracleParameter("OUT24", "STRING", "OUT","");
			parameterList.add(param24);
			OracleParameter param25 = new OracleParameter("OUT25", "STRING", "OUT","");
			parameterList.add(param25);
			OracleParameter param26 = new OracleParameter("OUT26", "STRING", "OUT","");
			parameterList.add(param26);
			OracleParameter param27 = new OracleParameter("OUT27", "STRING", "OUT","");
			parameterList.add(param27);
			OracleParameter param28 = new OracleParameter("OUT28", "STRING", "OUT","");
			parameterList.add(param28);
			OracleParameter param29 = new OracleParameter("OUT29", "STRING", "OUT","");
			parameterList.add(param29);
			OracleParameter param30 = new OracleParameter("OUT30", "STRING", "OUT","");
			parameterList.add(param30);
			OracleParameter param31 = new OracleParameter("OUT31", "STRING", "OUT","");
			parameterList.add(param31);
			OracleParameter param32 = new OracleParameter("OUT32", "STRING", "OUT","");
			parameterList.add(param32);
			OracleParameter param33 = new OracleParameter("OUT33", "STRING", "OUT","");
			parameterList.add(param33);
			OracleParameter param34 = new OracleParameter("OUT34", "STRING", "OUT","");
			parameterList.add(param34);
			OracleParameter param35 = new OracleParameter("OUT35", "STRING", "OUT","");
			parameterList.add(param35);
			OracleParameter param36 = new OracleParameter("OUT36", "STRING", "OUT","");
			parameterList.add(param36);
			OracleParameter param37 = new OracleParameter("OUT37", "STRING", "OUT","");
			parameterList.add(param37);
			OracleParameter param38 = new OracleParameter("OUT38", "STRING", "OUT","");
			parameterList.add(param38);
			OracleParameter param39 = new OracleParameter("OUT39", "STRING", "IN OUT",P_POL_PERIOD );
			parameterList.add(param39);
			OracleParameter param40 = new OracleParameter("IN40", "STRING", "IN",P_M_CALC_METHOD);
			parameterList.add(param40);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.POL_CONT_CODE_W_V_I");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_END_TYPE-IN
	 * @param RECORD_STATUS-IN
	 * @param P_M_PROD_SA_TARIFF-IN
	 * @param P_POAD_SYS_ID-IN
	 * @param P_POL_FC_MODAL_PREM-IN
	 * @param P_POL_ORG_FC_MODAL_PREM-IN
	 * @param P_POL_ORG_NO_OF_INST-IN
	 * @param P_POL_ORG_NO_OF_UNIT-IN
	 * @param P_M_PLAN_CALC_TYPE-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_POL_NO_OF_INST-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_ORG_FC_SUM_ASSURED-IN
	 * @param P_POL_SA_EXCH_RATE-IN
	 * @param P_POL_NO_OF_UNIT-IN
	 *                OUT
	 * @param P_POL_NEW_FC_SA-OUT
	 * @param P_POL_NEW_LC_SA-OUT
	 * @param P_POL_ORG_NEW_FC_SA-OUT
	 * @param P_POL_ORG_NEW_LC_SA-OUT
	 * @param P_POL_FC_SUM_ASSURED-OUT
	 * @param P_POL_LC_SUM_ASSURED-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_CALC_SA_FACT_VALID(
			String P_POL_SYS_ID,
			String P_POL_PLAN_CODE,
			String P_POL_END_TYPE,
			String RECORD_STATUS,
			String P_M_PROD_SA_TARIFF,
			String P_POAD_SYS_ID,
			String P_POL_FC_MODAL_PREM,
			String P_POL_ORG_FC_MODAL_PREM,
			String P_POL_ORG_NO_OF_INST,
			String P_POL_ORG_NO_OF_UNIT,
			String P_M_PLAN_CALC_TYPE,
			String P_POL_SA_CURR_CODE,
			String P_POL_NO_OF_INST,
			String P_POL_PROD_CODE,
			String P_POL_ORG_FC_SUM_ASSURED,
			String P_POL_SA_EXCH_RATE,
			String P_POL_NO_OF_UNIT,
			String P_POL_NEW_FC_SA,
			String P_POL_NEW_LC_SA,
			String P_POL_ORG_NEW_FC_SA,
			String P_POL_ORG_NEW_LC_SA,
			String P_POL_FC_SUM_ASSURED,
			String P_POL_LC_SUM_ASSURED) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",RECORD_STATUS);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_M_PROD_SA_TARIFF);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POAD_SYS_ID);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_FC_MODAL_PREM);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_ORG_FC_MODAL_PREM);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_ORG_NO_OF_INST);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_POL_ORG_NO_OF_UNIT);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_M_PLAN_CALC_TYPE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_POL_NO_OF_INST);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("IN15", "STRING", "IN",P_POL_ORG_FC_SUM_ASSURED);
			parameterList.add(param15);
			OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_POL_SA_EXCH_RATE);
			parameterList.add(param16);
			OracleParameter param17 = new OracleParameter("IN OUT17", "STRING", "IN OUT",P_POL_NO_OF_UNIT);
			parameterList.add(param17);
			OracleParameter param18 = new OracleParameter("OUT18", "STRING", "OUT","");
			parameterList.add(param18);
			OracleParameter param19 = new OracleParameter("OUT19", "STRING", "OUT","");
			parameterList.add(param19);
			OracleParameter param20 = new OracleParameter("OUT20", "STRING", "OUT","");
			parameterList.add(param20);
			OracleParameter param21 = new OracleParameter("OUT21", "STRING", "OUT","");
			parameterList.add(param21);
			OracleParameter param22 = new OracleParameter("OUT22", "STRING", "OUT","");
			parameterList.add(param22);
			OracleParameter param23 = new OracleParameter("OUT23", "STRING", "OUT","");
			parameterList.add(param23);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_CALC_SA_FACT_VALID");
		} catch(Exception e) {
		    	e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_POL_END_TYPE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_POL_ORG_FC_MON_ANNU_AMT-IN
	 * @param P_M_BASE_CURR-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_FC_MON_ANNU_AMT-IN
	 * @param P_POL_ORG_FC_SUM_ASSURED-IN
	 * @param P_POL_SA_EXCH_RATE-IN
	 * @param P_POL_FC_SUM_ASSURED-OUT
	 * @param P_POL_LC_SUM_ASSURED-OUT
	 * @param P_POL_FC_CURR_SA-OUT
	 * @param P_POL_LC_CURR_SA-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_CALC_ANNUITY_SA(
			String P_POL_END_TYPE,
			String P_POL_PERIOD,
			String P_POL_SA_CURR_CODE,
			String P_POL_ORG_FC_MON_ANNU_AMT,
			String P_M_BASE_CURR,
			String P_POL_PROD_CODE,
			String P_POL_FC_MON_ANNU_AMT,
			String P_POL_ORG_FC_SUM_ASSURED,
			String P_POL_SA_EXCH_RATE,
			String P_POL_FC_SUM_ASSURED,
			String P_POL_LC_SUM_ASSURED,
			String P_POL_FC_CURR_SA,
			String P_POL_LC_CURR_SA) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SA_CURR_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_ORG_FC_MON_ANNU_AMT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_M_BASE_CURR);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_FC_MON_ANNU_AMT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_ORG_FC_SUM_ASSURED);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_POL_SA_EXCH_RATE);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
			parameterList.add(param13);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_CALC_ANNUITY_SA");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}


	 /**
     * 
     * @param P_POL_JOINT_LIFE_YN-IN
     * @param P_POAD_AGE-IN
     * @param P_POAD_AGE1-IN
     * @param P_M_POL_PERIOD-IN
     * @param P_M_PLAN_AGE_TERM_FLAG-IN
     * @param P_POAD_DOB-IN
     * @param P_M_PROD_AGE_CALC_FLAG-IN
     * @param RECORD_STATUS-IN
     * @param P_M_POL_PLAN_TYPE-IN
     * @param P_M_COVER_SA_CALC-IN
     * @param P_POL_PROP_END_TYPE-IN
     * @param P_M_BASE_CURR-IN
     * @param P_POL_NO-IN
     * @param P_POL_ISSUE_DT-IN
     * @param P_POAD_CATG_CODE-IN
     * @param P_POAD_CATG_CODE1-IN
     * @param P_POL_PLAN_CODE-IN
     * @param P_POL_SYS_ID-IN
     * @param P_POL_PROD_CODE-IN
     * @param P_POL_END_NO_IDX-IN
     * @param P_M_PROD_PERIOD_MULTIPLE-IN
     * @param P_POL_END_TYPE-IN
     * @param P_M_PROD_MATU_DT-IN
     * @param P_POL_MODE_OF_PYMT-IN
     * @param P_POL_SA_CURR_CODE-IN
     * @param P_POL_FC_MON_ANNU_AMT-IN
     * @param P_POL_ORG_FC_SUM_ASSURED-IN
     * @param P_POL_ORG_FC_MON_ANNU_AMT-IN
     * @param P_POL_SA_EXCH_RATE-IN
     * @param P_POL_PREM_PAY_YRS-IN
     *                OUT
     * @param P_POL_FIRST_INST_DT-IN
     *                OUT
     * @param P_POL_START_DT-IN
     *                OUT
     * @param P_POL_EXPIRY_DT-OUT
     * @param P_POL_LAST_INST_DT-OUT
     * @param G_M_AGENT_RATE-OUT
     * @param P_M_CUST_AGE-OUT
     * @param P_POL_PERIOD-IN
     *                OUT
     * @param P_POL_FC_SUM_ASSURED-OUT
     * @param P_POL_LC_SUM_ASSURED-OUT
     * @param P_POL_FC_CURR_SA-OUT
     * @param P_POL_LC_CURR_SA-OUT
     * 
     * @return ArrayList of type Oracle Parameter
     * @throws Exception
     */
  public ArrayList<OracleParameter> POL_PERIOD_W_V_I(
                    Object P_POL_JOINT_LIFE_YN,
                    Object P_POAD_AGE,
                    Object P_POAD_AGE1,
                    Object P_M_POL_PERIOD,
                    Object P_M_PLAN_AGE_TERM_FLAG,
                    Object P_POAD_DOB,
                    Object P_M_PROD_AGE_CALC_FLAG,
                    Object RECORD_STATUS,
                    Object P_M_POL_PLAN_TYPE,
                    Object P_M_COVER_SA_CALC,
                    Object P_POL_PROP_END_TYPE,
                    Object P_M_BASE_CURR,
                    Object P_POL_NO,
                    Object P_POL_ISSUE_DT,
                    Object P_POAD_CATG_CODE,
                    Object P_POAD_CATG_CODE1,
                    Object P_POL_PLAN_CODE,
                    Object P_POL_SYS_ID,
                    Object P_POL_PROD_CODE,
                    Object P_POL_END_NO_IDX,
                    Object P_M_PROD_PERIOD_MULTIPLE,
                    Object P_POL_END_TYPE,
                    Object P_M_PROD_MATU_DT,
                    Object P_POL_MODE_OF_PYMT,
                    Object P_POL_SA_CURR_CODE,
                    Object P_POL_FC_MON_ANNU_AMT,
                    Object P_POL_ORG_FC_SUM_ASSURED,
                    Object P_POL_ORG_FC_MON_ANNU_AMT,
                    Object P_POL_SA_EXCH_RATE,
                    Object P_POL_PREM_PAY_YRS,
                    Object P_POL_FIRST_INST_DT,
                    Object P_POL_START_DT,
                    Object P_POL_EXPIRY_DT,
                    Object P_POL_LAST_INST_DT,
                    Object G_M_AGENT_RATE,
                    Object P_M_CUST_AGE,
                    Object P_POL_PERIOD,
                    Object P_POL_FC_SUM_ASSURED,
                    Object P_POL_LC_SUM_ASSURED,
                    Object P_POL_FC_CURR_SA,
                    Object P_POL_LC_CURR_SA) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 ArrayList<OracleParameter> returnList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<OracleParameter>();
					       	 
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_JOINT_LIFE_YN);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN,P_POAD_AGE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN,P_POAD_AGE1);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN,P_M_POL_PERIOD);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_M_PLAN_AGE_TERM_FLAG);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN,P_POAD_DOB);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_M_PROD_AGE_CALC_FLAG);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,RECORD_STATUS);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_M_POL_PLAN_TYPE);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_M_COVER_SA_CALC);
          parameterList.add(param10);
          OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_PROP_END_TYPE);
          parameterList.add(param11);
          OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_M_BASE_CURR);
          parameterList.add(param12);
          OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_NO);
          parameterList.add(param13);
          OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN,P_POL_ISSUE_DT);
          parameterList.add(param14);
          OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POAD_CATG_CODE);
          parameterList.add(param15);
          OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POAD_CATG_CODE1);
          parameterList.add(param16);
          OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_PLAN_CODE);
          parameterList.add(param17);
          OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,P_POL_SYS_ID);
          parameterList.add(param18);
          OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_PROD_CODE);
          parameterList.add(param19);
          OracleParameter param20 = new OracleParameter("IN20", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_POL_END_NO_IDX);
          parameterList.add(param20);
          OracleParameter param21 = new OracleParameter("IN21", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN,P_M_PROD_PERIOD_MULTIPLE);
          parameterList.add(param21);
          OracleParameter param22 = new OracleParameter("IN22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_END_TYPE);
          parameterList.add(param22);
          OracleParameter param23 = new OracleParameter("IN23", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_M_PROD_MATU_DT);
          parameterList.add(param23);
          OracleParameter param24 = new OracleParameter("IN24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_MODE_OF_PYMT);
          parameterList.add(param24);
          OracleParameter param25 = new OracleParameter("IN25", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,P_POL_SA_CURR_CODE);
          parameterList.add(param25);
          OracleParameter param26 = new OracleParameter("IN26", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_POL_FC_MON_ANNU_AMT);
          parameterList.add(param26);
          OracleParameter param27 = new OracleParameter("IN27", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_POL_ORG_FC_SUM_ASSURED);
          parameterList.add(param27);
          OracleParameter param28 = new OracleParameter("IN28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_POL_ORG_FC_MON_ANNU_AMT);
          parameterList.add(param28);
          OracleParameter param29 = new OracleParameter("IN29", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN,P_POL_SA_EXCH_RATE);
          parameterList.add(param29);
          OracleParameter param30 = new OracleParameter("IN OUT30", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT,P_POL_PREM_PAY_YRS);
          parameterList.add(param30);
          OracleParameter param31 = new OracleParameter("IN OUT31", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_POL_FIRST_INST_DT);
          parameterList.add(param31);
          OracleParameter param32 = new OracleParameter("IN OUT32", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN_OUT,P_POL_START_DT);
          parameterList.add(param32);
          OracleParameter param33 = new OracleParameter("OUT33", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param33);
          OracleParameter param34 = new OracleParameter("OUT34", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param34);
          OracleParameter param35 = new OracleParameter("OUT35", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param35);
          OracleParameter param36 = new OracleParameter("OUT36", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param36);
          OracleParameter param37 = new OracleParameter("IN OUT37", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN_OUT,P_POL_PERIOD);
          parameterList.add(param37);
          OracleParameter param38 = new OracleParameter("OUT38", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param38);
          OracleParameter param39 = new OracleParameter("OUT39", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param39);
          OracleParameter param40 = new OracleParameter("OUT40", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param40);
          OracleParameter param41 = new OracleParameter("OUT41", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,"");
          parameterList.add(param41);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "PKG_PILT002_APAC.POL_PERIOD_W_V_I");
       } catch(Exception e) {
	   e.printStackTrace();
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
     /*  Iterator<OracleParameter> iterator = outputList.iterator();
	while (iterator.hasNext()) {
	    OracleParameter oracleParameter = iterator.next();
	    System.out.println("Output value:::" + oracleParameter.getValue());
	    returnList.add(oracleParameter.getValue());
	}*/
	return outputList;
  }


	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_POL_PREM_PAY_YRS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_ADDL_COVRS_FOR_012(
			String P_POL_SYS_ID,
			String P_POL_PROD_CODE,
			String P_POL_PLAN_CODE,
			String P_POL_END_TYPE,
			String P_POL_PERIOD,
			String P_POL_PREM_PAY_YRS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_ADDL_COVRS_FOR_012");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}



	/**
	 * 
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_POL_PREM_PAY_YRS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_DFLT_PREM_PAY_YRS(
			String P_POL_PROD_CODE,
			String P_POL_PERIOD,
			String P_POL_PREM_PAY_YRS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT","");
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_DFLT_PREM_PAY_YRS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}


	/**
	 * 
	 * @param P_PLAN_CODE-IN
	 * @param P_PROD_CODE-IN
	 * @param P_CATG_CODE-IN
	 * @param P_CATG_CODE_1-IN
	 * @param P_JOINT_LIFE_YN-IN
	 * @param P_AGE-IN
	 * @param P_AGE_1-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_PLAN_AGE_TERM_FLAG-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_POL_PERIOD_CHECK(
			String P_PLAN_CODE,
			String P_PROD_CODE,
			String P_CATG_CODE,
			String P_CATG_CODE_1,
			String P_JOINT_LIFE_YN,
			String P_AGE,
			String P_AGE_1,
			String P_POL_PERIOD,
			String P_PLAN_AGE_TERM_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PLAN_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_CATG_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CATG_CODE_1);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_JOINT_LIFE_YN);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_AGE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_AGE_1);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_PLAN_AGE_TERM_FLAG);
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_POL_PERIOD_CHECK");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}



	/**
	 * 
	 * @param P_POL_NO-IN
	 * @param P_POL_END_NO-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_UNIQUE_END_NO(
			String P_POL_NO,
			String P_POL_END_NO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;

		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_END_NO);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_UNIQUE_END_NO");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_PROD_CODE-IN
	 * @param P_POAD_SYS_ID-IN
	 * @param P_END_TYPE-IN
	 * @param P_POL_END_CODE-IN
	 * @param P_SA_CURR_CODE-IN
	 * @param P_POL_FRZ_FLAG-IN
	 *                OUT
	 * @param P_ERR_MSG-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_ADD_CVR_PREMIUM_VAL_CAL(
			String P_POL_SYS_ID,
			String P_PROD_CODE,
			String P_POAD_SYS_ID,
			String P_END_TYPE,
			String P_POL_END_CODE,
			String P_SA_CURR_CODE,
			String P_POL_FRZ_FLAG,
			String P_ERR_MSG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POAD_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_END_TYPE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_SA_CURR_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN OUT7", "STRING", "IN OUT",P_POL_FRZ_FLAG);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
			parameterList.add(param8);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_ADD_CVR_PREMIUM_VAL_CAL");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}




	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_PROD_CODE-IN
	 * @param P_FRZ_FLAG-IN
	 *                OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_BROK_UAS_CHK(
			String P_POL_SYS_ID,
			String P_PROD_CODE,
			String P_FRZ_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_FRZ_FLAG);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_BROK_UAS_CHK");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_POL_EMPLOYER_CODE-IN
	 * @param P_CONT_NAME-OUT
	 * @param P_ERR_FLAG-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_VAL_CONT_CODE(
			String P_POL_EMPLOYER_CODE,
			String P_CONT_NAME,
			String P_ERR_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_EMPLOYER_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_CONT_CODE");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_POL_STAFF_CCLASS_CODE-IN
	 * @param P_CCLAS_CLASS_DESC-OUT
	 * @param P_ERR_FLAG-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_VAL_STAFF_CLASS_CODE(
			String P_POL_STAFF_CCLASS_CODE,
			String P_CCLAS_CLASS_DESC,
			String P_ERR_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_STAFF_CCLASS_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("OUT2", "STRING", "OUT","");
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_STAFF_CLASS_CODE");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_POL_CUST_CODE-IN
	 * @param P_M_POL_CONT_AD_ACC_NO-IN
	 * @param P_POL_PYMT_TYPE-IN
	 * @param P_POL_END_NO_IDX-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_M_POL_CONT_AD_ACC_NO_1-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_M_POL_CONT_AD_ACC_NO_W_VAL_I(
			String P_POL_CUST_CODE,
			String P_M_POL_CONT_AD_ACC_NO,
			String P_POL_PYMT_TYPE,
			String P_POL_END_NO_IDX,
			String P_POL_END_TYPE,
			String P_M_POL_CONT_AD_ACC_NO_1) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_CUST_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_M_POL_CONT_AD_ACC_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PYMT_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_END_NO_IDX);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6", "STRING", "OUT","");
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_M_POL_CONT_AD_ACC_NO_W_VAL_I");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;

	}

	//added by Dileshwar Patle 23/Sept/2011
	 public ArrayList<OracleParameter> P_M_POL_CONT_AD_ACC_NO_W_VAL_I(
             Object P_POL_CUST_CODE,
  Object P_M_POL_CONT_AD_ACC_NO,
  Object P_POL_PYMT_TYPE,
  Object P_POL_END_NO_IDX,
  Object P_POL_END_TYPE,
  Object P_M_POL_CONT_AD_ACC_NO_1) throws ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
   OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_CUST_CODE);
   parameterList.add(param1);
   OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_CONT_AD_ACC_NO);
   parameterList.add(param2);
   OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_PYMT_TYPE);
   parameterList.add(param3);
   OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_NO_IDX);
   parameterList.add(param4);
   OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_TYPE);
   parameterList.add(param5);
   OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
   parameterList.add(param6);

  OracleProcedureHandler procHandler = new OracleProcedureHandler();
   outputList = procHandler.executeProc(parameterList, connection,
          "PKG_PILT002_APAC.P_M_POL_CONT_AD_ACC_NO_W_VAL_I");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
       throw new ProcedureException(e.getMessage());
}
return outputList;
}



	/**
	 * 
	 * @param P_CUST_CODE-IN
	 * @param P_CUST_CURR_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> IL_CUST_CURR_EXIST(
			String P_CUST_CODE,
			String P_CUST_CURR_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CUST_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CUST_CURR_CODE);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.IL_CUST_CURR_EXIST");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::"
					+ oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	public ArrayList<String> IL_UNIQUE_ADDL_COVER_CODE(
														String P_UNQ_ADDL_COVER_YN,
														String P_APPL_ALL, 
														String POAD_TYPE,
														Long P_POAD_SYS_ID,
														Long POL_SYS_ID, 
														String P_COVER_CODE,
														String P_ROW_ID,
														Long P_PAPP_SYS_ID,
														Long P_PCG_SYS_ID) throws Exception {

		String CURSOR_C1 = "SELECT POAC_APPL_ALL FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID =  ? " +
				"AND    POAC_COVER_CODE  = ? AND POAC_POL_SYS_ID = ? AND POAC_PAPP_SYS_ID =  ? AND POAC_PCG_SYS_ID  = ?"; 

		String CURSOR_C1A = "SELECT POAC_APPL_ALL FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID =  ? " +
				" AND  POAC_COVER_CODE  =  ?  AND  POAC_POL_SYS_ID  =  ?  AND  POAC_PAPP_SYS_ID =  ?  AND  POAC_PCG_SYS_ID = ? ";

		String CURSOR_C2 = "SELECT POAC_APPL_ALL FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID =  ? AND    POAC_COVER_CODE  = ?" +
				" AND  POAC_POL_SYS_ID  = ? AND POAC_PAPP_SYS_ID = ?  AND  ROWID !=  ?   AND  POAC_PCG_SYS_ID  = ? ";

		String CURSOR_C2A = "SELECT POAC_APPL_ALL  FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID = ? " +
				"AND POAC_COVER_CODE  = ?  AND  POAC_POL_SYS_ID  = ? AND POAC_PAPP_SYS_ID =  ?  AND  ROWID !=  ? AND    POAC_PCG_SYS_ID  = ? "; 
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<String> list = new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (P_ROW_ID == null) {
				if ("R".equals(POAD_TYPE)) {
					resultSet = handler.executeSelectStatement(CURSOR_C1,connection, 
							new Object[] { P_POAD_SYS_ID,P_COVER_CODE, POL_SYS_ID ,P_PAPP_SYS_ID,P_PCG_SYS_ID});
					if (resultSet.next()) {
						P_APPL_ALL = resultSet.getString(1);
						P_UNQ_ADDL_COVER_YN = "N";
					} else {
						P_UNQ_ADDL_COVER_YN = "Y";
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C1A,connection, 
							new Object[] { P_POAD_SYS_ID,P_COVER_CODE, POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID });
					if (resultSet.next()) {
						P_APPL_ALL = resultSet.getString(1);
						P_UNQ_ADDL_COVER_YN = "N";
					} else {
						P_UNQ_ADDL_COVER_YN = "Y";
					}
					CommonUtils.closeCursor(resultSet);
				}
			} else {
				if ("R".equals(POAD_TYPE)) {
					resultSet = handler.executeSelectStatement(CURSOR_C2,connection, 
							new Object[] { P_POAD_SYS_ID,P_COVER_CODE, POL_SYS_ID,P_PAPP_SYS_ID,P_ROW_ID,P_PCG_SYS_ID });
					if (resultSet.next()) {
						P_APPL_ALL = resultSet.getString(1);
						P_UNQ_ADDL_COVER_YN = "N";
					} else {
						P_UNQ_ADDL_COVER_YN = "Y";
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C2A,connection,
							new Object[] { P_POAD_SYS_ID,P_COVER_CODE, POL_SYS_ID,P_PAPP_SYS_ID,P_ROW_ID,P_PCG_SYS_ID });
					if (resultSet.next()) {
						P_APPL_ALL = resultSet.getString(1);
						P_UNQ_ADDL_COVER_YN = "N";
					} else {
						P_UNQ_ADDL_COVER_YN = "Y";
					}
					CommonUtils.closeCursor(resultSet);
				}
			}
			list.add(P_UNQ_ADDL_COVER_YN);
			list.add(P_APPL_ALL);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
		return list;
	}


	/**
	 * 
	 * @param P_CURR_CODE-IN
	 * @param P_CURR_NAME-IN
	 *                OUT
	 * @param P_NAME_FLAG-IN
	 * @param P_ERR_FLAG-IN
	 * @param P_CUST_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_VAL_CURR(
			String P_CURR_CODE,
			String P_CURR_NAME,
			String P_NAME_FLAG,
			String P_ERR_FLAG,
			String P_CUST_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_CURR_NAME);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CUST_CODE);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_CURR");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::"
					+ oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}



	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_PROD_CODE-IN
	 * @param P_POL_PLAN_CODE-IN
	 * @param P_POL_NO-IN
	 * @param P_POL_END_NO_IDX-IN
	 * @param P_POL_END_TYPE-IN
	 * @param P_POL_PERIOD-IN
	 * @param P_POL_PREM_PAY_YRS-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> L_CHECK_PAYING_YEARS(
			String P_POL_SYS_ID,
			String P_POL_PROD_CODE,
			String P_POL_PLAN_CODE,
			String P_POL_NO,
			String P_POL_END_NO_IDX,
			String P_POL_END_TYPE,
			String P_POL_PERIOD,
			String P_POL_PREM_PAY_YRS) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_PLAN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_NO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_END_NO_IDX);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_POL_END_TYPE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_POL_PERIOD);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
			parameterList.add(param8);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.L_CHECK_PAYING_YEARS");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::"
					+ oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_CUST_TYPE-IN
	 * @param P_CUST_CODE-IN
	 * @param P_CUST_NAME-IN
	 *                OUT
	 * @param P_NAME_FLAG-IN
	 * @param P_ERR_FLAG-IN
	 * @param P_DIVN_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_VAL_CLASS_CUST(
			String P_CUST_TYPE,
			String P_CUST_CODE,
			String P_CUST_NAME,
			String P_NAME_FLAG,
			String P_ERR_FLAG,
			String P_DIVN_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CUST_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CUST_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_CUST_NAME);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_DIVN_CODE);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_CLASS_CUST");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::"
					+ oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}


	/**
	 * 
	 * @param P_USER_ID-IN
	 * @param P_CODE-IN
	 * @param P_PROD_CODE-IN
	 * @param P_FLAG-IN
	 * @param P_VALUE-IN
	 *                OUT
	 * @param P_END_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> P_VAL_ENDT_APPROVAL(
			String P_USER_ID,
			String P_CODE,
			String P_PROD_CODE,
			String P_FLAG,
			String P_VALUE,
			String P_END_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_USER_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_PROD_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN OUT5", "STRING", "IN OUT",P_VALUE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_END_CODE);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.P_VAL_ENDT_APPROVAL");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}



	public ArrayList<String> IL_POAC_GET_TARIFF_RATE(String POAC_COVER_CODE,
			int POAD_AGE, String M_POL_PLAN_TYPE, java.util.Date P_EFF_DT,
			Double POAC_RATE, String POAC_ASSR_CODE, Long POL_SYS_ID,
			int POL_PERIOD, String POL_PLAN_CODE) throws Exception {
		int M_POAD_AGE = 0;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<String> list = new ArrayList<String>();

		CRUDHandler handler = new CRUDHandler();

		String CURSOR_C1 = "SELECT 	NVL(TAR_RATE,0) FROM PM_IL_TARIFF WHERE TAR_PLAN_CODE =  ? "
			+ "AND  ?  BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO AND  ?  BETWEEN TAR_AGE_FROM   AND TAR_AGE_TO AND  TAR_FRZ_FLAG = 'N' ";

		String CURSOR_C2 = "SELECT POAD_AGE FROM PT_IL_POL_ASSURED_DTLS  WHERE  POAD_POL_SYS_ID = ? AND POAD_ASSR_CODE = ? ";

		M_POAD_AGE = POAD_AGE;
		try {
			connection = CommonUtils.getConnection();
			if ("J".equals(M_POL_PLAN_TYPE)) {
				POAD_AGE = IL_PREM_CAL_JL_AGE(POAD_AGE, P_EFF_DT,
						POL_PLAN_CODE, POL_SYS_ID);
			}
			if ("A".equals(M_POL_PLAN_TYPE) || "S".equals(M_POL_PLAN_TYPE)) {
				resultSet = handler
				.executeSelectStatement(CURSOR_C2, connection,
						new Object[] { POL_SYS_ID, POAC_ASSR_CODE });
				if (resultSet.next()) {
					M_POAD_AGE = resultSet.getInt(1);
				}
				CommonUtils.closeCursor(resultSet);

			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { POAC_COVER_CODE, POL_PERIOD, M_POAD_AGE });
			if (resultSet.next()) {

				POAC_RATE = resultSet.getDouble(1);
			}
			list.add(String.valueOf(M_POAD_AGE));
			list.add(String.valueOf(POAC_RATE));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {	}
		}
		return list;
	}

	public int IL_PREM_CAL_JL_AGE(int P_POAD_AGE,
			java.util.Date P_EFF_DT, String POL_PLAN_CODE, Long POL_SYS_ID)
	throws Exception {

		int M_POAD_AGE_1 = 0;
		int M_POAD_AGE_2 = 0;
		int M_ABS_AGE_DIFF = 0;
		int M_MIN_ASS_AGE = 0;
		int M_MAX_ASS_AGE = 0;
		int M_JL_AGE_FTR = 0;
		String M_CODE_DESC = null;
		int M_IL_JL_AGE = 0;
		int M_IL_JLAGEFCTR = 0;
		String M_COVER_DISC_AGE_YN = null;
		String CURSOR_C0 = "SELECT COVER_DISC_AGE_YN FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		String CURSOR_C1 = "SELECT  DECODE(NVL(M_COVER_DISC_AGE_YN,'N'),'Y',NVL(POAD_DISC_AGE,0),NVL(POAD_AGE,0)) "
			+ "PROD_AGE FROM PT_IL_POL_ASSURED_DTLS WHERE   POAD_POL_SYS_ID = ? ";
		String CURSOR_JL_AGE_FTR = "SELECT  NVL(JAF_AGE_FACTOR,0) FROM    PM_IL_JL_AGE_FACTOR "
			+ "WHERE   ?  BETWEEN JAF_DIFF_AGE_FROM AND JAF_DIFF_AGE_TO ";
		String CURSOR_C2 = "SELECT JAM_JL_AGE  FROM   PM_IL_JL_AGE_MATRIX WHERE ? BETWEEN JAM_AGE_1_FROM AND JAM_AGE_1_TO "
			+ "AND   ? BETWEEN JAM_AGE_2_FROM AND JAM_AGE_2_TO AND   ?  BETWEEN NVL(JAM_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/YYYY'))"
			+ "AND NVL(JAM_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/YYYY'))";
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C0, connection,
					new Object[] { POL_PLAN_CODE });
			if (resultSet.next()) {
				M_COVER_DISC_AGE_YN = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { POL_SYS_ID });
			if (resultSet.next()) {
				M_POAD_AGE_1 = resultSet.getInt(1);
				M_POAD_AGE_2 = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			list1 = DBProcedures.P_VAL_SYSTEM("IL_JL_AGE", "IL_JL_AGE",
					M_CODE_DESC, "E", CommonUtils.getProcedureValue(M_IL_JL_AGE));
			M_CODE_DESC = list.get(1);
			M_IL_JL_AGE = Integer.parseInt(list.get(1));

			if (M_IL_JL_AGE > 1) {
				if ((M_POAD_AGE_1 - M_POAD_AGE_2) < 0) {
					M_ABS_AGE_DIFF = M_POAD_AGE_1 - M_POAD_AGE_2;
					M_MIN_ASS_AGE = M_POAD_AGE_1;
					M_MAX_ASS_AGE = M_POAD_AGE_2;
				} else {
					M_ABS_AGE_DIFF = M_POAD_AGE_1 - M_POAD_AGE_2;
					M_MIN_ASS_AGE = M_POAD_AGE_1;
					M_MAX_ASS_AGE = M_POAD_AGE_2;
				}
				resultSet = handler.executeSelectStatement(CURSOR_JL_AGE_FTR,
						connection, new Object[] { M_ABS_AGE_DIFF });
				if (resultSet.next()) {
					M_JL_AGE_FTR = resultSet.getInt(1);
				}
				CommonUtils.closeCursor(resultSet);
				list = DBProcedures.P_VAL_SYSTEM("IL_JLAGEFCTR",
						"IL_JLAGEFCTR", M_CODE_DESC, "E", CommonUtils.getProcedureValue(M_IL_JLAGEFCTR));
				M_CODE_DESC = list.get(0);
				M_IL_JLAGEFCTR = Integer.parseInt(list.get(1));
				if (M_IL_JLAGEFCTR == 1) {
					P_POAD_AGE = CommonUtils.nvl(M_JL_AGE_FTR, 0)
					+ M_MIN_ASS_AGE;
				} else if (M_IL_JLAGEFCTR == 2) {
					P_POAD_AGE = CommonUtils.nvl(M_JL_AGE_FTR, 0)
					+ M_MAX_ASS_AGE;
				}
			} else if (M_IL_JL_AGE == 2) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { M_POAD_AGE_1, M_POAD_AGE_2,
						P_EFF_DT });
				if (resultSet.next()) {
					P_POAD_AGE = resultSet.getInt(1);
				}
				CommonUtils.closeCursor(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
		return P_POAD_AGE;
	}
	public void IL_ENDT_001_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();

		ResultSet rs = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = {};

		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		String query1 = "   SELECT  ASD_CHAR_VALUE   FROM    PM_IL_APPR_SETUP_DET "
			+ "   WHERE   ASD_USER_ID = :CTRL.M_USER_ID       AND     "
			+ " ASD_CODE    = 'MOD_COMM_YN'   AND    ? "
			+ " BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";

		String M_ASD_CHAR_VALUE = null;
		try {
			connection = CommonUtils.getConnection();
			if (pt_il_policy_bean.getPOL_END_NO() == null) { // --
				// ADDED
				// BY
				// ABHINAV FOR
				// STM
				// -- TO MAKE APPRV BUTTON DISABLED IN GENERAL
				// ENDT
				// SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVAL',ENABLED,PROPERTY_FALSE);
				dummy_action.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
			}
			// --
			// pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true)
			// ; commented on29/9/2003 suggessted by Subbu

			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			// --pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			// --
			// pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);

			/*
			 * --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled(true);
			 * --pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(true);
			 */

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(true);
			}

			pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_TYPE().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);
			// --
			// pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS().setDisabled(
			// true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);
			// --added for QIIC on 25/10/01
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);
			/*
			 * --upto this -- BY Rajavel on 7/9/2003 impact 43
			 */
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);

			// --Added By Anamika
			pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(true);
			}
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_TYPE().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CODE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);
			// --end

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

			if (!"001".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {// -----ADDED
				// BY
				// VANITHA----GEN END----

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 1))) {
					pt_il_pol_charge_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
					pt_il_pol_charge_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(3, 1))) {
					pt_il_pol_charge_action.setDELETE_ALLOWED(true);
				}

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 1))) {
					pt_il_pol_broker_head_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
					pt_il_pol_broker_head_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(3, 1))) {
					pt_il_pol_broker_head_action.setDELETE_ALLOWED(true);
				}

			} else {

				pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

				pt_il_pol_charge_action.setINSERT_ALLOWED(false);
				pt_il_pol_charge_action.setUPDATE_ALLOWED(false);
				pt_il_pol_charge_action.setDELETE_ALLOWED(false);

			}
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };

			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_ASD_CHAR_VALUE = rs.getString(1);
			}

			if ("Y".equals(M_ASD_CHAR_VALUE)
					&& "001".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) { // ---ADDED
				// BY
				// VANITHA---GEN
				// END---

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 1))) {
					pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
					pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(3, 1))) {
					pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(true);
				}
			} else {
				pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			}

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_status_action.setINSERT_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);
			pt_il_pol_status_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_illness_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_illness_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_illness_dtls_action.setDELETE_ALLOWED(false);

			// --BY Rajavel on 10/2/2003
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);
			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --
			 * pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);
			 */
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);

			// --
			// pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);

			pt_il_doc_todo_list_status_action.getCOMP_DTLS_SR_NO().setDisabled(
					true);

			if ("Y".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_INCORPORATED_YN(), "N"))) {
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
			}

			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --BY Gopal.S on
			 * 6-MAY-2003 for Issue Id KEN-IL-023 --commented by
			 * dhamodharan for stm issue id is STMB-190004
			 */
			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_BENEFICIARY',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_BENEFICIARY().setDisabled(true);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_BENEFICIARY',DELETE_ALLOWED,PROPERTY_FALSE);
			 */
			// --- ended by dhamodharan for stm issue id is
			// STMB-190004
			// --Added by Paul Joseph on 13/12/2003 as per
			// Impact(003-TISB3)
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 1))) {

				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID1()
				.setDisabled(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID2()
				.setDisabled(false);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {

				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID1()
				.setDisabled(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID2()
				.setDisabled(false);
			}
			// --Added by Paul Joseph on 13/12/2003 as per
			// Impact(003-TISB3)

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);

			if ("Y".equals(pt_il_policy_bean.getPOL_JOINT_LIFE_YN())) {

				pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(true);
			}

			/*
			 * --ADDED FOR PRFM-FSD-008-STM ON 06/11/2007 BY AMAN --
			 * FOR MEDICAL FEES RECOVERY AT THE TIME OF POLICY
			 * CANCELLATION
			 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL().setDisabled(
			 * false);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',DELETE_ALLOWED,PROPERTY_TRUE);
			 * ----END HERE-------
			 */
			String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();

			if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)
					|| "AD".equals(POL_PYMT_TYPE)) {

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
				.setDisabled(false); // ----Changed
				// by
				// Piyush
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
				.setDisabled(false);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
				.setDisabled(false);// ----Changed
				// by Piyush
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
				.setDisabled(false);

				if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
						|| "C1".equals(POL_PYMT_TYPE)
						|| "C2".equals(POL_PYMT_TYPE)
						|| "C3".equals(POL_PYMT_TYPE)
						|| "C4".equals(POL_PYMT_TYPE)
						|| "C5".equals(POL_PYMT_TYPE)
						|| "C6".equals(POL_PYMT_TYPE)) {

					if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
						.setDisabled(false);
					}
				}

				if ("AD".equals(POL_PYMT_TYPE)) {
					if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
						.setDisabled(false);
					}
				}
			}

			pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN().setDisabled(
					true);// ---------ADDED BY
			// VANITHA----GEN END
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SUB_PLAN_CODE().setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_FM_DT()
			.setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_TO_DT()
			.setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_PERIOD().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PERIOD().setDisabled(
					true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FC_SA().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_LC_SA().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_002_PROPS(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		try {

			if (!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| !"S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				if ("P".equals(dummy_bean.getUI_M_COVER_SA_CALC())
						|| "V".equals(dummy_bean.getUI_M_COVER_SA_CALC())
						|| "A".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
					pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED()
					.setDisabled(true);// ',
					// UPDATEABLE
					// ,PROPERTY_FALSE);
					pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED()
					.setDisabled(true);// ',
					// UPDATEABLE
					// ,PROPERTY_FALSE);
				} else {

					if ("Y".equals(CommonUtils.getGlobalVariable(
					"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
						if (pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED()
								.isRendered() == true) {
							pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED()
							.setDisabled(false); // ',
							// UPDATEABLE
							// ,PROPERTY_TRUE);
						}
						if (pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED()
								.isRendered() == true) {
							pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED()
							.setDisabled(false);// ',
							// UPDATEABLE
							// ,PROPERTY_TRUE);
						}
					}
				}
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);

				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);
			} else if ("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true);// ', UPDATEABLE
				// ,PROPERTY_FALSE);
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true); // ', UPDATEABLE
				// ,PROPERTY_FALSE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 1))) {

					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
					.setDisabled(false);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(false);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(false);
				}
			}

			if ("PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))
					&& "C".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARA_18"))) {

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);
			}

			// -- pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT',
			// UPDATEABLE
			// ,PROPERTY_TRUE);
			// --
			// pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE',
			// UPDATEABLE
			// ,PROPERTY_TRUE);
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {
				pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(false);
			}
			// -- pt_il_policy_action.getCOMP_POL_OCC_RATE',
			// UPDATEABLE
			// ,PROPERTY_TRUE);
			// -- pt_il_policy_action.getCOMP_POL_HEALTH_RATE',
			// UPDATEABLE
			// ,PROPERTY_TRUE);

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true); // -----changed by piyush

			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_002_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();

		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = {};

		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		String query1 = "  SELECT PS_CODE   FROM   PP_SYSTEM    WHERE PS_TYPE ='IL_SUBPLAN' ";
		String query2 = "  SELECT PROD_SA_BY_PLAN_BASIS_YN  FROM PM_IL_PRODUCT"
			+ "  WHERE PROD_CODE= ? ";
		String query3 = "  SELECT PS_CODE   FROM   PP_SYSTEM    WHERE PS_TYPE ='IL_ADD_RIDER' ";
		String query4 = "  SELECT PS_CODE   FROM   PP_SYSTEM    WHERE PS_TYPE ='IL_DEL_RIDER' ";

		String M_FC_VALUE = null;
		String M_LC_VALUE = null;
		String M_PS_CODE = null;
		String M_PS_CODE_1 = null;
		String M_PS_CODE_2 = null;
		String M_PROD_SA_BY_PLAN_BASIS_YN = null;
		try {
			if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {// -----ADDED
				// BY
				// VANITHA----GEN END----
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
				.setDisabled(true);
			}

			rs1 = handler.executeSelectStatement(query1, connection);
			if (rs1.next()) {
				M_PS_CODE = rs1.getString(1);
			}
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };

			rs2 = handler.executeSelectStatement(query2, connection, values);
			if (rs2.next()) {
				M_PROD_SA_BY_PLAN_BASIS_YN = rs2.getString(1);
			}
			if ("Y".equals(CommonUtils.nvl(M_PROD_SA_BY_PLAN_BASIS_YN, "N"))) {

				if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))
						&& M_PS_CODE
						.equals(pt_il_policy_bean.getPOL_END_TYPE())) { // ---ADDED
					// BY
					// VANITHA---GEN
					// END---

					// --pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(
					// true);
					// --pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
					// true);
					pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_ISSUE_DT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
					pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
					pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_STAFF_YN()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
					pt_il_policy_action.getCOMP_POL_CQS_PERC()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_START_DT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_FIRST_INST_DT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(
							true);
					// --
					// pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(
					// true);
					pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
					pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
					pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

					pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
					pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
					pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

					pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
					pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
					pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

					pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
					pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(false);
					pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

					pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
					pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
					pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

					pt_il_pol_condition_action.setINSERT_ALLOWED(false);
					pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
					pt_il_pol_condition_action.setDELETE_ALLOWED(false);
				}
			}

			/*
			 * --ADDES BY AMANA ON 13/08/2008 -- Reason : Additional
			 * covers are not able to delete during INCSA
			 */
			rs3 = handler.executeSelectStatement(query3, connection);
			if (rs3.next()) {
				M_PS_CODE_1 = rs3.getString(1);
			}
			rs4 = handler.executeSelectStatement(query4, connection);
			if (rs4.next()) {
				M_PS_CODE_2 = rs4.getString(1);
			}

			if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					&& M_PS_CODE_1.equals(pt_il_policy_bean.getPOL_END_CODE())) {
				// --pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(
				// true);
				// --pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LAST_INST_DT()
				.setDisabled(true);
				// --pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(
						true);

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true); // ',ENABLED,PROPERTY_FALSE);
				// -- ADDED BY
				// ABHINAV TO RESTRICT DURING ADDRIDER
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true);// ',ENABLED,PROPERTY_FALSE);
				// --

				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(true);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

				pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
				pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
				pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

				pt_il_pol_condition_action.setINSERT_ALLOWED(false);
				pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
				pt_il_pol_condition_action.setDELETE_ALLOWED(false);

				pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);

				pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(true);
			} else if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					&& M_PS_CODE_2.equals(pt_il_policy_bean.getPOL_END_CODE())) {
				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(true);

				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(true);
			} else if (!"013".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {

				// --pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(
				// true);
				// --pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LAST_INST_DT()
				.setDisabled(true);
				// --pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(
						true);

				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

				pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
				pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
				pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

				pt_il_pol_condition_action.setINSERT_ALLOWED(false);
				pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
				pt_il_pol_condition_action.setDELETE_ALLOWED(false);

			}

			if ("M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
			"X"))
			&& CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),
			"000").equals(
					CommonUtils.nvl(dummy_bean.getUI_M_IL_RED_SA_END(),
					"000"))) {
				pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
			} else {
				if (!"PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) { // --ADDED
					// BY
					// SARVINDER FOR
					// POLICY
					// CORRECTION
					if ("Y".equals(CommonUtils.getGlobalVariable(
					"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
						pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
								false);
					} else {
						pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
								true);
					}
				}

				pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
				.setDisabled(true);
				// --pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(
				// true); ---commented by sivaram for FSD-25
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);

				dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD()
				.setDisabled(true);

				pt_il_pol_assured_dtls_action.getCOMP_POAD_DISC_AGE()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
				.setDisabled(true);
				// --added by anamika
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DISC_AGE()
				.setDisabled(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
				.setDisabled(true);

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 1))) {
					pt_il_pol_beneficiary_action.setINSERT_ALLOWED(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
					pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(3, 1))) {
					pt_il_pol_beneficiary_action.setDELETE_ALLOWED(false);
				}

				/*
				 * IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) =
				 * 'Y' THEN
				 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
				 * END IF; IF
				 * SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) =
				 * 'Y' THEN
				 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS().setDisabled(
				 * true); END IF; IF
				 * SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) =
				 * 'Y' THEN
				 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
				 * END IF;
				 */

				// --COMMENTED AND ADDED BY DHAMODHARAN
				/*
				 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',INSERT_ALLOWED,PROPERTY_FALSE);
				 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL().setDisabled(
				 * true);
				 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',DELETE_ALLOWED,PROPERTY_FALSE);
				 */

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 1))) {
					pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
					pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(3, 1))) {
					pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(true);
				}
				pt_il_pol_condition_action.setINSERT_ALLOWED(false);
				pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
				pt_il_pol_condition_action.setDELETE_ALLOWED(false);

				if ("013".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {

					// --Added by Indra on 26/08/2008
					pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID1()
					.setDisabled(false);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_ASSURED_NAME()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE_PROOF_FLAG()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_NO_OF_CIGAR()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_NATIONALITY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_RELIGION_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_BIRTH_PLACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_RACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_NATURE_OF_WORK()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_REMARKS()
					.setDisabled(true);

					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_REF_ID1()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ASSURED_NAME()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_AGE_PROOF_FLAG().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_NO_OF_CIGAR()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_NATIONALITY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_MAR_STATUS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_RELIGION_CODE().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_BIRTH_PLACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_RACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_NATURE_OF_WORK().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_REMARKS()
					.setDisabled(true);
					// --Added by end Indra on 26/08/2008

					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_FC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_LC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_FC_AMAN_LOAD_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_LC_AMAN_LOAD_PREM().setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
					.setDisabled(true);

					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_AMAN_LOAD_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_AMAN_LOAD_PREM().setDisabled(true);

					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT()
					.setDisabled(true);

					pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_INCORPORATED_YN()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG()
					.setDisabled(true);

					pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(
							true);

					pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB()
					.setDisabled(false);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
					.setDisabled(false);
				} else {
					pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
					.setDisabled(true);
				}

				// --Added by Rajavel.s on 8/9/2003 IMPACT 43

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
				.setDisabled(true); // -----changed
				// by piyush
				// ---
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);
				/**
				 * * Added for PRFM-FSD3-004-STM requirement 2
				 * ****
				 */

				if ("D".equals(CommonUtils.nvl(dummy_bean
						.getUI_M_POL_PLAN_TYPE(), "X"))
						&& "G".equals(CommonUtils.nvl(dummy_bean
								.getUI_M_COVER_SA_CALC(), "X"))
								&& "002".equals(CommonUtils.nvl(pt_il_policy_bean
										.getPOL_END_TYPE(), "000"))) {
					if (!M_PS_CODE_1
							.equals(pt_il_policy_bean.getPOL_END_CODE())
							|| !M_PS_CODE_2.equals(pt_il_policy_bean
									.getPOL_END_CODE()))
						pt_il_policy_action.getCOMP_POL_FC_MON_ANNU_AMT()
						.setDisabled(false);
				} else if (M_PS_CODE_1.equals(pt_il_policy_bean
						.getPOL_END_CODE())
						|| M_PS_CODE_2.equals(pt_il_policy_bean
								.getPOL_END_CODE())) {

					pt_il_policy_action.getCOMP_POL_FC_MON_ANNU_AMT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_LC_MON_ANNU_AMT()
					.setDisabled(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_015_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();

		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		try {

			if ("M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
			"X"))
			&& CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),
			"000").equals(
					CommonUtils.nvl(dummy_bean.getUI_M_IL_RED_SA_END(),
					"000"))) {
				pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
			} else {
				if (!"PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) { // --ADDED
					// BY
					// SARVINDER
					if ("Y".equals(CommonUtils.getGlobalVariable(
					"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
						pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
								false);
					}
				} else {
					pt_il_policy_action.getCOMP_POL_FRZ_FLAG()
					.setDisabled(true);
				}
			}

			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);
			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --
			 * pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(
			 * true);
			 */
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);

			// --
			// pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(
			// true);

			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);

			if ("Y".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_INCORPORATED_YN(), "N"))) {// =
				// 'Y'
				// THEN
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
			}
			dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD().setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_DISC_AGE().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			// --added by anamika
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DISC_AGE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			/*
			 * --end --
			 * pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT',
			 * UPDATEABLE ,PROPERTY_TRUE);
			 * 
			 * --added for QIIC on 25/10/01
			 */
			/*
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_FC_AMAN_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_LC_AMAN_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_FC_SENABEL_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_LC_SENABEL_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_FC_AMAN_LOAD_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_LC_AMAN_LOAD_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 */
			// --upto this
			pt_il_pol_beneficiary_action.setINSERT_ALLOWED(false);
			pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(false);
			pt_il_pol_beneficiary_action.setDELETE_ALLOWED(false);

			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS().setDisabled(
			 * true);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
			 */

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_condition_action.setINSERT_ALLOWED(false);
			pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
			pt_il_pol_condition_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {
				pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE()
				.setDisabled(false);
			}
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE_PROOF_FLAG()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE_PROOF_OTHERS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE_PROOF_FLAG()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE_PROOF_OTHERS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_NO_OF_CIGAR()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_NO_OF_CIGAR()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_RELIGION_CODE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_RELIGION_CODE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SALARY().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SALARY()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SALARY().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SALARY()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_BIRTH_PLACE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_BIRTH_PLACE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_RACE().setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_RACE().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_REMARKS().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_REMARKS().setDisabled(
					true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CODE()
				.setDisabled(false);
			}
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE().setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
			.setDisabled(true);

			// --Added by Rajavel.s on 8/9/2003 IMPACT 43

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true); // ----Changed by piyush
			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);

			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_011_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		try {

			pt_il_policy_action.setINSERT_ALLOWED(false);
			pt_il_policy_action.setUPDATE_ALLOWED(false);
			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 1))) {
				pt_il_pol_charge_action.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {
				pt_il_pol_charge_action.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(3, 1))) {
				pt_il_pol_charge_action.setDELETE_ALLOWED(true);
			}

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_status_action.setINSERT_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);
			pt_il_pol_status_action.setDELETE_ALLOWED(false);

			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS().setDisabled(
			 * true);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
			 */

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 1))) {
				pt_il_pol_beneficiary_action.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 1))) {
				pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(3, 1))) {
				pt_il_pol_beneficiary_action.setDELETE_ALLOWED(true);
			}

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true);// ---------Changed by piyush

			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);

			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 
	 * /**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_CUST_CURR_CODE-IN
	 * @param P_BASE_CURR-IN
	 * @param P_FC_GROSS_CONT-IN
	 *                OUT
	 * @param P_LC_GROSS_CONT-IN
	 *                OUT
	 * @param P_FC_BROK_COMM-IN
	 *                OUT
	 * @param P_LC_BROK_COMM-IN
	 *                OUT
	 * @param P_BROK_PER-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<String> L_CAL_BROKER_RATE(String P_POL_SYS_ID,
			String P_POL_CUST_CURR_CODE, String P_BASE_CURR,
			String P_FC_GROSS_CONT, String P_LC_GROSS_CONT,
			String P_FC_BROK_COMM, String P_LC_BROK_COMM, String P_BROK_PER)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = new ArrayList<String>();
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_CUST_CURR_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_BASE_CURR);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4", "STRING",
					"IN OUT", P_FC_GROSS_CONT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN OUT5", "STRING",
					"IN OUT", P_LC_GROSS_CONT);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN OUT6", "STRING",
					"IN OUT", P_FC_BROK_COMM);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN OUT7", "STRING",
					"IN OUT", P_LC_BROK_COMM);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("OUT8", "STRING",
					"OUT", "");
			parameterList.add(param8);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
			"PKG_PILT002_APAC.L_CAL_BROKER_RATE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public void IL_ENDT_003_004_BLK_DISABLE(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		try {
			if (!"PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))) {

				pt_il_policy_action.setUPDATE_ALLOWED(false);
				pt_il_policy_action.setDELETE_ALLOWED(false);

				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

				pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

				pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

				pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
				pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
				pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_005_BLK_DISABLE(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();

		try {

			pt_il_policy_action.setUPDATE_ALLOWED(false);
			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_charge_action.setINSERT_ALLOWED(false);
			pt_il_pol_charge_action.setUPDATE_ALLOWED(false);
			pt_il_pol_charge_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
			pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
			pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_016_BLK_DISABLE(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();

		try {
			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);

			pt_il_pol_assr_med_hist_action.getCOMP_PAMH_FIELD_01().setDisabled(
					true);
			pt_il_pol_assr_med_hist_action.getCOMP_PAMH_FIELD_01().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);
			// --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled(
			// true);
			pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			// --pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
			// true);
			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ASSURED_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_UNIT().setDisabled(true);

			// --
			// SET_BLOCK_PROPERTY('PT_IL_POLICY',UPDATE_ALLOWED,PROPERTY_FALSE);
			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

			pt_il_pol_charge_action.setINSERT_ALLOWED(false);
			pt_il_pol_charge_action.setUPDATE_ALLOWED(false);
			pt_il_pol_charge_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
			pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
			pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_FM_DT()
			.setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_TO_DT()
			.setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_PERIOD().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PERIOD().setDisabled(
					true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FC_SA().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_LC_SA().setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);
			// --
			// pt_il_pol_addl_cover_action.getCOMP_POAC_FC_SA().setDisabled(
			// true);
			// --
			// pt_il_pol_addl_cover_action.getCOMP_POAC_LC_SA().setDisabled(
			// true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_RATE().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_RATE_PER().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_WOP_FLAG().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_MED_DAYS().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_LC_MED_AMT().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void L_IL_END_007_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_UNPAID_PREM_DTLS_ACTION pt_il_unpaid_prem_dtls_action = compositeAction
		.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();

		try {
			pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			// --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled(
			// true);
			// --pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(
			// true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			// --
			// SET_BLOCK_PROPERTY('PT_IL_POLICY',UPDATE_ALLOWED,PROPERTY_FALSE);

			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
			pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
			pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);

			pt_il_unpaid_prem_dtls_action.setINSERT_ALLOWED(false);
			pt_il_unpaid_prem_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_unpaid_prem_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void IL_ENDT_QUOT_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		COPY_ACTION copy_action = new COPY_ACTION();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();

		try {
			if ("Q".equals(pt_il_policy_bean.getPOL_PROP_QUOT_FLAG())) {
				dummy_action.getCOMP_UI_M_BUT_APPROVAL().setRendered(false);
				copy_action.getCOMP_UI_M_BUT_COPY().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_ENDT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_SURR_MAT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_PRMDTLS().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_UPI().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_UDDATE_STAT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD().setRendered(
						false);
				dummy_action.getCOMP_UI_M_BUT_POL_AMDT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_HOLD().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CONVERT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_UPLOAD().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CLAIM().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CONTRACTOR().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CUSTOMER().setRendered(false);
				pt_il_pol_broker_head_action.getCOMP_UI_M_BUT_SHOW_AGENT()
				.setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_REPLACE_POLICY().setRendered(
						false);
				dummy_action.getCOMP_UI_M_BUT_ASSR_MORE_INFO().setRendered(
						false);
				dummy_bean.setUI_M_ADDL_STATUS_DESC(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public ArrayList<String> L_CHECK_MED_AMT(Long POAC_SYS_ID, Long POL_SYS_ID,
			String POL_PROD_CODE, String POAC_COVER_CODE,
			Double P_POAC_MED_AMT, Double POAC_LC_SA) throws Exception {

		Double M_MIN_SA = null;
		Double M_MAX_SA = null;
		Double M_MED_AMT = null;
		Double M_POAC_ORG_LC_MED_AMT = null;
		Double M_POAC_LC_MED_AMT = null;
		String CURSOR_C1 = "SELECT NVL(POAC_ORG_LC_MED_AMT,0) FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID= ? AND POAC_SYS_ID =  ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = new ArrayList<String>();
		P9ILPK_POLICY ILProcedure = new P9ILPK_POLICY();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { POL_SYS_ID, POAC_SYS_ID });
			if (resultSet.next()) {
				M_POAC_ORG_LC_MED_AMT = resultSet.getDouble(1);
			}
			M_MED_AMT = P_POAC_MED_AMT
			+ CommonUtils.nvl(M_POAC_ORG_LC_MED_AMT, 0);
			list = ILProcedure.P_CALC_MIN_MAX_CVR_SA(POL_SYS_ID.toString(),
					POL_PROD_CODE, POAC_COVER_CODE, M_MIN_SA.toString(),
					M_MAX_SA.toString(), POAC_LC_SA.toString());
			M_MIN_SA = Double.parseDouble(list.get(0).getValue());
			M_MAX_SA = Double.parseDouble(list.get(1).getValue());
			if (M_MIN_SA != null && M_MAX_SA != null) {
				if (CommonUtils.nvl(M_MED_AMT, 0) < CommonUtils
						.nvl(M_MIN_SA, 0)) {
					M_MED_AMT = CommonUtils.nvl(M_MIN_SA, 0);
				} else if (CommonUtils.nvl(M_MED_AMT, 0) > CommonUtils.nvl(
						M_MAX_SA, 0)) {
					M_MED_AMT = CommonUtils.nvl(M_MAX_SA, 0);
				}
			}
			M_POAC_LC_MED_AMT = M_MED_AMT
			- CommonUtils.nvl(M_POAC_ORG_LC_MED_AMT, 0);
			list1.add(String.valueOf(M_POAC_LC_MED_AMT));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return list1;
	}

	public void IL_UNIQUE_CHARGE_CODE(String POC_CHRG_CODE,
			Long POC_POL_SYS_ID, String ROW_ID) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM PT_IL_POL_CHARGE WHERE  POC_CHRG_CODE =  ? " +
				"AND  POC_POL_SYS_ID =  ? ";
		String CURSOR_C2 = "SELECT 'X' FROM PT_IL_POL_CHARGE WHERE  POC_CHRG_CODE = ? " +
				"AND  POC_POL_SYS_ID =  ? AND  ROWID <> ? ";
		String M_CHARGE_CODE = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (ROW_ID == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { POC_CHRG_CODE,
						POC_POL_SYS_ID });
				if (resultSet.next()) {
					M_CHARGE_CODE = resultSet.getString(1);
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath,
							"91002")));
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { POC_CHRG_CODE,
						POC_POL_SYS_ID, ROW_ID });
				if (resultSet.next()) {
					M_CHARGE_CODE = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91002"));
				}
				CommonUtils.closeCursor(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void IL_GET_BENEF_DTL_ID(String P_CONT_REF_ID1,
			String P_CONT_REF_ID2, PT_IL_POL_BENEFICIARY beneficiaryBean)
	throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_BENEFICIARY WHERE  PBEN_REF_ID1 =  ? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_BENEFICIARY WHERE  PBEN_REF_ID2 =  ? ";
		String CURSOR_C3 = "SELECT 'X' FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_REF_ID1 = ? ";
		String CURSOR_C4 = "SELECT 'X' FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_REF_ID2 =  ? ";
		String CURSOR_C5 = "SELECT 'X' FROM   PM_IL_CONTRACTOR WHERE  CONT_REF_ID1 =  ? ";
		String CURSOR_C6 = "SELECT 'X' FROM   PM_IL_CONTRACTOR WHERE  CONT_REF_ID2 =  ? ";
		String CURSOR_C7 = "SELECT 'X' FROM   PM_CUSTOMER WHERE  CUST_REF_ID1 = ? ";
		String CURSOR_C8 = "SELECT 'X' FROM   PM_CUSTOMER WHERE  CUST_REF_ID1 =  ? ";
		String CURSOR_C9 = "SELECT PBEN_BNF_TYPE,PBEN_BNF_NAME,PBEN_RELATION_CODE, PBEN_ADDRESS_1,"
			+ "PBEN_ADDRESS_2,PBEN_ADDRESS_3,PBEN_ADDRESS_4,PBEN_ADDRESS_5,PBEN_CATG_CODE,"
			+ "PBEN_AGE,PBEN_GUARDIAN_NAME,  PBEN_REF_ID2 FROM    PT_IL_POL_BENEFICIARY "
			+ "WHERE   PBEN_REF_ID1 =  ? ORDER BY NVL(PBEN_UPD_DT,PBEN_CR_DT) DESC ";
		String CURSOR_C9A = "SELECT PBEN_BNF_TYPE,PBEN_BNF_NAME,PBEN_RELATION_CODE, PBEN_ADDRESS_1,"
			+ "PBEN_ADDRESS_2,PBEN_ADDRESS_3,PBEN_ADDRESS_4,PBEN_ADDRESS_5,PBEN_CATG_CODE,"
			+ "PBEN_AGE,PBEN_GUARDIAN_NAME,  PBEN_REF_ID2 FROM    PT_IL_POL_BENEFICIARY "
			+ "WHERE   PBEN_REF_ID2 =  ? ORDER BY NVL(PBEN_UPD_DT,PBEN_CR_DT) DESC ";
		String CURSOR_C10 = "SELECT  POAD_ASSURED_NAME,POAD_AGE,POAD_REF_ID2 FROM "
			+ "PT_IL_POL_ASSURED_DTLS WHERE   POAD_REF_ID1= ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC ";
		String CURSOR_C10A = "SELECT  POAD_ASSURED_NAME,POAD_AGE,POAD_REF_ID2 FROM "
			+ "PT_IL_POL_ASSURED_DTLS WHERE   POAD_REF_ID2= ? ORDER BY NVL(POAD_UPD_DT,POAD_CR_DT) DESC ";
		String CURSOR_C11 = "SELECT   CONT_NAME, CONT_ADDR1, CONT_ADDR2, CONT_ADDR3, CONT_REF_ID2 "
			+ "FROM PM_IL_CONTRACTOR  WHERE  CONT_REF_ID1 = ? ORDER BY NVL(CONT_UPD_DT,CONT_CR_DT) DESC ";
		String CURSOR_C11A = "SELECT   CONT_NAME, CONT_ADDR1, CONT_ADDR2, CONT_ADDR3, CONT_REF_ID1 "
			+ "FROM PM_IL_CONTRACTOR WHERE CONT_REF_ID2 =  ? ORDER BY NVL(CONT_UPD_DT,CONT_CR_DT) DESC ";
		String CURSOR_C12 = "SELECT  CUST_NAME, CUST_ADDR1, CUST_ADDR2, CUST_ADDR3,CUST_REF_ID2 "
			+ "FROM    PM_CUSTOMER WHERE   CUST_REF_ID1  = ?  ORDER BY NVL(CUST_UPD_DT,CUST_CR_DT) DESC ";
		String CURSOR_C12A = "SELECT  CUST_NAME, CUST_ADDR1, CUST_ADDR2, CUST_ADDR3,CUST_REF_ID1 "
			+ "FROM    PM_CUSTOMER  WHERE   CUST_REF_ID2  = ?  ORDER BY NVL(CUST_UPD_DT,CUST_CR_DT) DESC";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_CHAR = null;
		try {
			connection = CommonUtils.getConnection();
			if (P_CONT_REF_ID1 != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C7,
						connection, new Object[] { P_CONT_REF_ID1 });
				if (resultSet.next()) {
					M_CHAR = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
					resultSet = handler.executeSelectStatement(CURSOR_C12,
							connection, new Object[] { P_CONT_REF_ID1 });
					if (resultSet.next()) {
						beneficiaryBean
						.setPBEN_BNF_NAME(resultSet.getString(1));
						beneficiaryBean.setPBEN_ADDRESS_1(resultSet
								.getString(2));
						beneficiaryBean.setPBEN_ADDRESS_2(resultSet
								.getString(3));
						beneficiaryBean.setPBEN_ADDRESS_3(resultSet
								.getString(4));
						beneficiaryBean.setPBEN_REF_ID2(resultSet.getString(5));
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C5,
							connection, new Object[] { P_CONT_REF_ID1 });
					if (resultSet.next()) {
						M_CHAR = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);
					if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
						resultSet = handler.executeSelectStatement(CURSOR_C11,
								connection, new Object[] { P_CONT_REF_ID1 });
						if (resultSet.next()) {
							beneficiaryBean.setPBEN_BNF_NAME(resultSet
									.getString(1));
							beneficiaryBean.setPBEN_ADDRESS_1(resultSet
									.getString(2));
							beneficiaryBean.setPBEN_ADDRESS_2(resultSet
									.getString(3));
							beneficiaryBean.setPBEN_ADDRESS_3(resultSet
									.getString(4));
							beneficiaryBean.setPBEN_REF_ID2(resultSet
									.getString(5));
						}
						CommonUtils.closeCursor(resultSet);
					} else {
						resultSet = handler.executeSelectStatement(CURSOR_C3,
								connection, new Object[] { P_CONT_REF_ID1 });
						if (resultSet.next()) {
							M_CHAR = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
							resultSet = handler.executeSelectStatement(
									CURSOR_C10, connection,
									new Object[] { P_CONT_REF_ID1 });
							if (resultSet.next()) {
								beneficiaryBean.setPBEN_BNF_NAME(resultSet
										.getString(1));
								beneficiaryBean.setPBEN_AGE(resultSet
										.getInt(2));
								beneficiaryBean.setPBEN_REF_ID2(resultSet
										.getString(5));
							}
							CommonUtils.closeCursor(resultSet);
						} else {
							resultSet = handler.executeSelectStatement(
									CURSOR_C1, connection,
									new Object[] { P_CONT_REF_ID1 });
							if (resultSet.next()) {
								M_CHAR = resultSet.getString(1);
							}
							CommonUtils.closeCursor(resultSet);
							if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
								resultSet = handler.executeSelectStatement(
										CURSOR_C9, connection,
										new Object[] { P_CONT_REF_ID1 });
								if (resultSet.next()) {
									beneficiaryBean.setPBEN_BNF_TYPE(resultSet
											.getString(1));
									beneficiaryBean.setPBEN_BNF_NAME(resultSet
											.getString(2));
									beneficiaryBean
									.setPBEN_RELATION_CODE(resultSet
											.getString(3));
									beneficiaryBean.setPBEN_ADDRESS_1(resultSet
											.getString(4));
									beneficiaryBean.setPBEN_ADDRESS_2(resultSet
											.getString(5));
									beneficiaryBean.setPBEN_ADDRESS_3(resultSet
											.getString(6));
									beneficiaryBean.setPBEN_ADDRESS_4(resultSet
											.getString(7));
									beneficiaryBean.setPBEN_ADDRESS_5(resultSet
											.getString(8));
									beneficiaryBean.setPBEN_CATG_CODE(resultSet
											.getString(9));
									beneficiaryBean.setPBEN_AGE(resultSet
											.getInt(10));
									beneficiaryBean
									.setPBEN_GUARDIAN_NAME(resultSet
											.getString(11));
									beneficiaryBean.setPBEN_REF_ID2(resultSet
											.getString(12));
								}
								CommonUtils.closeCursor(resultSet);
							}
						}
					}
				}
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C8,
						connection, new Object[] { P_CONT_REF_ID2 });
				if (resultSet.next()) {
					M_CHAR = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
					resultSet = handler.executeSelectStatement(CURSOR_C12A,
							connection, new Object[] { P_CONT_REF_ID2 });
					if (resultSet.next()) {
						beneficiaryBean
						.setPBEN_BNF_NAME(resultSet.getString(1));
						beneficiaryBean.setPBEN_ADDRESS_1(resultSet
								.getString(2));
						beneficiaryBean.setPBEN_ADDRESS_2(resultSet
								.getString(3));
						beneficiaryBean.setPBEN_ADDRESS_3(resultSet
								.getString(4));
						beneficiaryBean.setPBEN_REF_ID2(resultSet.getString(5));
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C6,
							connection, new Object[] { P_CONT_REF_ID2 });
					if (resultSet.next()) {
						M_CHAR = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);
					if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
						resultSet = handler.executeSelectStatement(CURSOR_C11A,
								connection, new Object[] { P_CONT_REF_ID2 });
						if (resultSet.next()) {
							beneficiaryBean.setPBEN_BNF_NAME(resultSet
									.getString(1));
							beneficiaryBean.setPBEN_ADDRESS_1(resultSet
									.getString(2));
							beneficiaryBean.setPBEN_ADDRESS_2(resultSet
									.getString(3));
							beneficiaryBean.setPBEN_ADDRESS_3(resultSet
									.getString(4));
							beneficiaryBean.setPBEN_REF_ID2(resultSet
									.getString(5));
						}
						CommonUtils.closeCursor(resultSet);
					} else {
						resultSet = handler.executeSelectStatement(CURSOR_C4,
								connection, new Object[] { P_CONT_REF_ID2 });
						if (resultSet.next()) {
							M_CHAR = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
							resultSet = handler.executeSelectStatement(
									CURSOR_C10A, connection,
									new Object[] { P_CONT_REF_ID2 });
							if (resultSet.next()) {
								beneficiaryBean.setPBEN_BNF_NAME(resultSet
										.getString(1));
								beneficiaryBean.setPBEN_AGE(resultSet
										.getInt(2));
								beneficiaryBean.setPBEN_REF_ID2(resultSet
										.getString(5));
							}
							CommonUtils.closeCursor(resultSet);
						} else {
							resultSet = handler.executeSelectStatement(
									CURSOR_C2, connection,
									new Object[] { P_CONT_REF_ID2 });
							if (resultSet.next()) {
								M_CHAR = resultSet.getString(1);
							}
							CommonUtils.closeCursor(resultSet);
							if ("X".equals(CommonUtils.nvl(M_CHAR, "Y"))) {
								resultSet = handler.executeSelectStatement(
										CURSOR_C9A, connection,
										new Object[] { P_CONT_REF_ID2 });
								if (resultSet.next()) {
									beneficiaryBean.setPBEN_BNF_TYPE(resultSet
											.getString(1));
									beneficiaryBean.setPBEN_BNF_NAME(resultSet
											.getString(2));
									beneficiaryBean
									.setPBEN_RELATION_CODE(resultSet
											.getString(3));
									beneficiaryBean.setPBEN_ADDRESS_1(resultSet
											.getString(4));
									beneficiaryBean.setPBEN_ADDRESS_2(resultSet
											.getString(5));
									beneficiaryBean.setPBEN_ADDRESS_3(resultSet
											.getString(6));
									beneficiaryBean.setPBEN_ADDRESS_4(resultSet
											.getString(7));
									beneficiaryBean.setPBEN_ADDRESS_5(resultSet
											.getString(8));
									beneficiaryBean.setPBEN_CATG_CODE(resultSet
											.getString(9));
									beneficiaryBean.setPBEN_AGE(resultSet
											.getInt(10));									
											beneficiaryBean.setPBEN_GUARDIAN_NAME(resultSet
											.getString(11));
									beneficiaryBean.setPBEN_REF_ID2(resultSet
											.getString(12));
								}
								CommonUtils.closeCursor(resultSet);
							}
						}
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
	}

	public void IL_UNIQUE_BROKER_SRNO(PT_IL_POL_BROKER_HEAD brokerBean)
	throws Exception {
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_SRNO =  ? AND POBH_POL_SYS_ID  =  ? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_SRNO =  ? AND POBH_POL_SYS_ID  = ? AND ROWID != ? ";
		String M_BROCKER_SRNO = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (brokerBean.getROWID() == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { brokerBean.getPOBH_SRNO(),
						brokerBean.getPOBH_POL_SYS_ID() });
				if (resultSet.next()) {
					M_BROCKER_SRNO = resultSet.getString(1);
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"90015",
									new Object[] { "Broker Serial No." })));
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { brokerBean.getPOBH_SRNO(),
						brokerBean.getPOBH_POL_SYS_ID(),
						brokerBean.getROWID() });
				if (resultSet.next()) {
					M_BROCKER_SRNO = resultSet.getString(1);
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"90015",
									new Object[] { "Broker Serial No." })));
				}
				CommonUtils.closeCursor(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void IL_UNIQUE_BROKER_COVER_CODE(PT_IL_POL_BROKER_HEAD brokerBean,
			PT_IL_POLICY policyBean) throws Exception {
		String M_BROKER_CODE = null;
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_BROKER_CODE  =  ? "
			+ "AND  POBH_COVER_CODE = ? AND  POBH_POL_SYS_ID =  ?  AND  NVL(POBH_DEL_FLAG,'N') <> 'Y' ";

		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_BROKER_CODE  =  ?  "
			+ "AND POBH_COVER_CODE =  ? AND POBH_POL_SYS_ID =  ? AND NVL(POBH_DEL_FLAG,'N') <> 'Y' AND ROWID != ? ";

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (brokerBean.getROWID() == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
						brokerBean.getPOBH_BROKER_CODE(),
						brokerBean.getPOBH_COVER_CODE(),
						policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_BROKER_CODE = resultSet.getString(1);
					throw new ValidatorException(
							new FacesMessage(
									Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"90015",
											new Object[] { "Combination Broker and Cover Code" })));
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
						brokerBean.getPOBH_BROKER_CODE(),
						brokerBean.getPOBH_COVER_CODE(),
						policyBean.getPOL_SYS_ID(),
						brokerBean.getROWID() });
				if (resultSet.next()) {
					M_BROKER_CODE = resultSet.getString(1);
					throw new ValidatorException(
							new FacesMessage(
									Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"90015",
											new Object[] { "Combination Broker and Cover Code" })));
				}
				CommonUtils.closeCursor(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void IL_UNIQUE_DISCLOAD_SRNO(PT_IL_POL_DISC_LOAD loadBean)
	throws Exception {
		String M_DISCLOAD_SRNO = null;
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_DISC_LOAD WHERE  PDL_SRNO =  ?  AND  PDL_POL_SYS_ID  =  ?";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_DISC_LOAD WHERE  PDL_SRNO =  ? AND    PDL_POL_SYS_ID  = ?  AND ROWID <>  ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (loadBean.getROWID() == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { loadBean.getPDL_SRNO(),
						loadBean.getPDL_POL_SYS_ID() });
				if (resultSet.next()) {
					M_DISCLOAD_SRNO = resultSet.getString(1);
					throw new ValidatorException(
							new FacesMessage(
									Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"90015",
											new Object[] { "Discount / Loading Serial No" })));
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { loadBean.getPDL_SRNO(),
						loadBean.getPDL_POL_SYS_ID(),
						loadBean.getROWID() });
				if (resultSet.next()) {
					M_DISCLOAD_SRNO = resultSet.getString(1);
					throw new ValidatorException(
							new FacesMessage(
									Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"90015",
											new Object[] { "Discount / Loading Serial No" })));
				}
				CommonUtils.closeCursor(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void IL_UNIQUE_DISC_LOAD_CODE(String P_COVER_CODE,
			PT_IL_POL_DISC_LOAD loadBean, PT_IL_POLICY policyBean)
	throws Exception {
		String M_DISC_LOAD_CODE = null;
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_DISC_LOAD WHERE  PDL_DISC_LOAD_CODE  =  ? "
			+ "AND PDL_DISC_LOAD_TYPE  = ?  AND PDL_POL_SYS_ID = ?  AND PDL_COVER_CODE	= ? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_DISC_LOAD WHERE  PDL_DISC_LOAD_CODE  = ?"
			+ "AND PDL_DISC_LOAD_TYPE  = ? AND PDL_POL_SYS_ID = ? AND PDL_COVER_CODE =  ? AND ROWID <> ? ";
		String CURSOR_C3 = "SELECT 'X' FROM   PT_IL_POL_DISC_LOAD WHERE  PDL_DISC_LOAD_CODE  = ? "
			+ "AND   PDL_DISC_LOAD_TYPE  =  ? AND  PDL_POL_SYS_ID =  ? AND PDL_COVER_CODE	IS NULL ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (loadBean.getROWID() == null) {
				if (P_COVER_CODE == null) {
					resultSet = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] {
							loadBean.getPDL_DISC_LOAD_CODE(),
							loadBean.getPDL_DISC_LOAD_TYPE(),
							policyBean.getPOL_SYS_ID() });
					if (resultSet.next()) {
						M_DISC_LOAD_CODE = resultSet.getString(1);

						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90015",
												new Object[] { "Discount / Loading Code" }));
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C1,
							connection, new Object[] {
							loadBean.getPDL_DISC_LOAD_CODE(),
							loadBean.getPDL_DISC_LOAD_TYPE(),
							policyBean.getPOL_SYS_ID(), P_COVER_CODE });
					if (resultSet.next()) {
						M_DISC_LOAD_CODE = resultSet.getString(1);
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90015",
								new Object[] { "Discount / Loading Code" }));
					}
					CommonUtils.closeCursor(resultSet);
				}
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
						loadBean.getPDL_DISC_LOAD_CODE(),
						loadBean.getPDL_DISC_LOAD_TYPE(),
						policyBean.getPOL_SYS_ID(), P_COVER_CODE,
						loadBean.getROWID() });
				if (resultSet.next()) {
					M_DISC_LOAD_CODE = resultSet.getString(1);

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90015",
							new Object[] { "Discount / Loading Code" }));
				}
				CommonUtils.closeCursor(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void L_INS_DMS_AGNT(PT_IL_POLICY policyBean,
			PT_IL_POL_BROKER_HEAD brokerBean, DUMMY dummyBean)
	throws Exception {

		Integer M_VALUE = null;
		String M_PS_CODE_DESC = null;
		Integer M_AGENT_LEVEL = null;
		String M_CUST_AGENT_RANK_CODE = null;
		String M_LOWEST_RANK_CODE = null;
		String M_DUMMY = null;
		Long M_POBH_SYS_ID = null;
		String M_POBH_BROKER_CODE = null;
		String M_POBH_COMM_CODE = null;
		String M_POBH_COVER_CODE = null;
		String M_TYPE1 = null;
		String M_TYPE2 = null;
		String M_TYPE3 = null;
		String M_TYPE4 = null;
		String M_TYPE5 = null;
		String M_TYPE6 = null;
		String M_TYPE7 = null;
		String M_TYPE = null;
		String M_BROKER_EXISTS = null;
		String M_EXCL_FLAG = null;
		String CURSOR_C1 = "SELECT PC_CODE FROM PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND  PC_VALUE = (SELECT MAX(PC_VALUE) "
			+ "FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK')";
		String CURSOR_C2 = "SELECT CUST_AGENT_RANK_CODE FROM   PM_CUSTOMER WHERE  CUST_CODE =  ? ";
		String CURSOR_C3 = "SELECT PC_VALUE FROM   PM_CODES WHERE  PC_TYPE = 'AGNRANK' AND  PC_CODE = ? ";
		String CURSOR_C4 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ? ";
		String CURSOR_C5 = "SELECT POBH_SYS_ID FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? ";
		String CURSOR_C6 = "SELECT POBH_BROKER_CODE,POBH_COVER_CODE,POBH_COMM_CODE FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID =  ? AND POBH_SYS_ID =  ? ";
		String CURSOR_C7 = "SELECT SUBSTR(PS_CODE_DESC, 1,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) - 1)),"
			+ "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,"
			+ "INSTR(PS_CODE_DESC,',',1,2) - 1 - INSTR(PS_CODE_DESC,',',1,1))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,"
			+ "INSTR(PS_CODE_DESC,',',1,2) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) - 1 - "
			+ "INSTR(PS_CODE_DESC,',',1,2))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) - 1 -INSTR(PS_CODE_DESC,',',1,3))),SUBSTR(PS_CODE_DESC,"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,"
			+ "INSTR(PS_CODE_DESC,',',1,5) - 1 -INSTR(PS_CODE_DESC,',',1,4))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,"
			+ "INSTR(PS_CODE_DESC,',',1,5) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) - 1 -"
			+ "INSTR(PS_CODE_DESC,',',1,5))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) + 1),"
			+ "DECODE(INSTR(PS_CODE_DESC, ',', 1, 7), 0, 999,INSTR(PS_CODE_DESC,',',1,7) - 1 - INSTR(PS_CODE_DESC,',',1,6)))"
			+ "FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_EXCL_HIER'";
		String CURSOR_C8 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? AND POBH_BROKER_CODE IN  "
			+ " (SELECT CAA_AGENT_CODE FROM   PM_CUST_APPL_AGENT WHERE  NVL(CAA_DFLT_YN,'N') = 'Y' CONNECT BY PRIOR "
			+ "CAA_AGENT_CODE = CAA_CUST_CODE cSTART WITH   CAA_CUST_CODE = M_POBH_BROKER_CODE AND NVL(CAA_DFLT_YN,'N') = 'Y')";
		String CURSOR_C9 = "SELECT 'X' FROM   PT_IL_POL_BROKER_DTL WHERE  POBD_POBH_SYS_ID = ?";
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		P9ILPK_POLICY policyProcedure = new P9ILPK_POLICY();
		PKG_PILQ003 localprocedure = new PKG_PILQ003();
		DBProcedures procedures = new DBProcedures();
		P9ILPK_AGENCY_MGMT p9ilpk_agency_mgmt = new P9ILPK_AGENCY_MGMT();
		ArrayList<String> list2 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if ("N".equals(policyBean.getPOL_STAFF_YN())
					&& CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 1) {
				policyProcedure.L_INS_BROK_DTL(
						CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(brokerBean.getPOBH_SYS_ID()),
						brokerBean.getPOBH_BROKER_CODE(),
						brokerBean.getPOBH_COVER_CODE(),
						brokerBean.getPOBH_COMM_CODE(),
						CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()), 
						CommonUtils.getProcedureValue(policyBean.getPOL_LC_SUM_ASSURED()),
						CommonUtils.getProcedureValue(policyBean.getPOL_START_DT()));
				list = DBProcedures.P_VAL_SYSTEM(
						"IL_COMM_HIER", 
						brokerBean.getPOBH_COMM_CODE(),
						CommonUtils.getProcedureValue(M_PS_CODE_DESC), 
						"N", 
						CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list1.isEmpty()) {
					if (list.get(0) != null)  {
						M_PS_CODE_DESC = list.get(0);
					}if (list.get(1) != null)  {
						M_VALUE = Integer.parseInt(list.get(1));
					}
						
						
				}
				
				if (M_VALUE == 1) {
					policyProcedure.P_INS_BROK_HEAD(
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
							CommonUtils.getProcedureValue(brokerBean.getPOBH_SYS_ID()),
							CommonUtils.getProcedureValue(policyBean.getPOL_START_DT()));
				}

			}
			if (CommonUtils.nvl(dummyBean.getUI_M_IL_BROK_CALC(), 1) == 2) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection);
				if (resultSet.next()) {
					M_LOWEST_RANK_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C7,connection);
				if (resultSet.next()) {
					M_TYPE1 = resultSet.getString(1);
					M_TYPE2 = resultSet.getString(2);
					M_TYPE3 = resultSet.getString(3);
					M_TYPE4 = resultSet.getString(4);
					M_TYPE5 = resultSet.getString(5);
					M_TYPE6 = resultSet.getString(6);
					M_TYPE7 = resultSet.getString(7);
				}
				CommonUtils.closeCursor(resultSet);

		M_TYPE1 = CommonUtils.nvl((M_TYPE1.replace(" ", null)).trim(),"***");
		M_TYPE2 = CommonUtils.nvl((M_TYPE2.replace(" ", null)).trim(),"***");
		M_TYPE3 = CommonUtils.nvl((M_TYPE3.replace(" ", null)).trim(),"***");
		M_TYPE4 = CommonUtils.nvl((M_TYPE4.replace(" ", null)).trim(),"***");
		M_TYPE5 = CommonUtils.nvl((M_TYPE5.replace(" ", null)).trim(),"***");
		M_TYPE6 = CommonUtils.nvl((M_TYPE6.replace(" ", null)).trim(),"***");
		M_TYPE7 = CommonUtils.nvl((M_TYPE7.replace(" ", null)).trim(),"***");

				resultSet = handler.executeSelectStatement(CURSOR_C4, connection,
						new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
					resultSet = handler.executeSelectStatement(CURSOR_C5,connection, new Object[] {});
					while (true) {
						if (resultSet.next()) {
							M_POBH_SYS_ID = resultSet.getLong(1);
						} else {
							break;
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C6,connection, new Object[] {
								policyBean.getPOL_SYS_ID(),M_POBH_SYS_ID });
						if (resultSet.next()) {
							M_POBH_BROKER_CODE = resultSet.getString(1);
							M_POBH_COVER_CODE = resultSet.getString(2);
							M_POBH_COMM_CODE = resultSet.getString(3);
						}
						CommonUtils.closeCursor(resultSet);
						M_BROKER_EXISTS = " ";
						M_EXCL_FLAG = " ";
						resultSet = handler.executeSelectStatement(CURSOR_C2, connection,new Object[] { M_POBH_BROKER_CODE });
						if (resultSet.next()) {
							M_CUST_AGENT_RANK_CODE = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C3,connection,
								new Object[] { M_CUST_AGENT_RANK_CODE });
						if (resultSet.next()) {
							M_AGENT_LEVEL = resultSet.getInt(1);
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C8,connection,
								new Object[] {policyBean.getPOL_SYS_ID(),M_POBH_BROKER_CODE });
						if (resultSet.next()) {
							M_BROKER_EXISTS = resultSet.getString(1);
						} else {
							M_BROKER_EXISTS = " ";
						}
						CommonUtils.closeCursor(resultSet);
						resultSet = handler.executeSelectStatement(CURSOR_C9,connection,
								new Object[] { M_POBH_SYS_ID });
						if (resultSet.next()) {
							M_EXCL_FLAG = resultSet.getString(1);
						} else {
							M_EXCL_FLAG = " ";
						}
						CommonUtils.closeCursor(resultSet);

						if (M_BROKER_EXISTS == null
								&& M_POBH_COMM_CODE != M_TYPE1
								|| M_POBH_COMM_CODE != M_TYPE2
								|| M_POBH_COMM_CODE != M_TYPE3
								|| M_POBH_COMM_CODE != M_TYPE4
								|| M_POBH_COMM_CODE != M_TYPE5
								|| M_POBH_COMM_CODE != M_TYPE6
								|| M_POBH_COMM_CODE != M_TYPE7) {
							p9ilpk_agency_mgmt.INS_AGENT_DTL(
									CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
									CommonUtils.getProcedureValue(M_POBH_SYS_ID), 
									M_POBH_BROKER_CODE,
									M_POBH_COVER_CODE,
									M_POBH_COMM_CODE,
									CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()),
									CommonUtils.getProcedureValue(policyBean.getPOL_LC_SUM_ASSURED()), 
									CommonUtils.getProcedureValue(M_AGENT_LEVEL), 
									M_LOWEST_RANK_CODE);
							p9ilpk_agency_mgmt.INS_AGENT_HIERARCHY(
									CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
									CommonUtils.getProcedureValue(M_POBH_SYS_ID),
									CommonUtils.getProcedureValue(policyBean.getPOL_START_DT()));
						}

					}
					CommonUtils.closeCursor(resultSet);

					if (M_EXCL_FLAG == null && M_POBH_COMM_CODE == M_TYPE1
							|| M_POBH_COMM_CODE == M_TYPE2
							|| M_POBH_COMM_CODE == M_TYPE3
							|| M_POBH_COMM_CODE == M_TYPE4
							|| M_POBH_COMM_CODE == M_TYPE5
							|| M_POBH_COMM_CODE == M_TYPE6
							|| M_POBH_COMM_CODE == M_TYPE7) {
						p9ilpk_agency_mgmt.INS_AGENT_DTL(
								CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()),
								CommonUtils.getProcedureValue(M_POBH_SYS_ID),
								M_POBH_BROKER_CODE,
								M_POBH_COVER_CODE, 
								M_POBH_COMM_CODE, 
								CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()),
								CommonUtils.getProcedureValue(policyBean.getPOL_LC_SUM_ASSURED()),
								CommonUtils.getProcedureValue(M_AGENT_LEVEL), 
								M_LOWEST_RANK_CODE);

					}

				}
			}

		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}


	public void IL_ENDT_003_004_FINAL_NET_VAL(
			PT_IL_SURR_MAT_VALUES matvaluesBean, PT_IL_POLICY policyBean) {

		matvaluesBean.setUI_M_LC_NET_VALUE(CommonUtils.nvl(matvaluesBean
				.getSMV_LC_GROSS_VALUE(), 0)
				- CommonUtils.nvl(matvaluesBean.getSMV_LC_UNPAID_PREM(), 0)
				- CommonUtils.nvl(matvaluesBean.getSMV_LC_LOAN_INT(), 0)
				- CommonUtils.nvl(matvaluesBean.getSMV_LC_BAL_LOAN(), 0)
				- CommonUtils.nvl(matvaluesBean.getUI_M_LC_TOT_CHARGE(), 0));

		matvaluesBean.setUI_M_FC_NET_VALUE(CommonUtils.nvl(matvaluesBean
				.getUI_M_LC_NET_VALUE(), 0)
				/ policyBean.getPOL_SA_EXCH_RATE());
		if (matvaluesBean.getUI_M_FC_NET_VALUE() < 0) {
			matvaluesBean.setUI_M_FC_NET_VALUE(0.00);
			matvaluesBean.setUI_M_LC_NET_VALUE(0.00);
		}
	}
	public Double IL_GET_ASSR_NOS(Double P_NO_ASSR, Long POL_SYS_ID)
	throws Exception {

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String CURSOR_C1 = "SELECT   COUNT(POAD_SYS_ID) FROM  PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { POL_SYS_ID });
			if (resultSet.next()) {
				P_NO_ASSR = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);
			P_NO_ASSR = CommonUtils.nvl(P_NO_ASSR, 0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
		return P_NO_ASSR;

	}
	// Dileshwar B. Patle Date:- 9 Aug 2011
	public String IL_POAC_WOP_CVR_VALIDATE(String P_COVER_CODE,
			String P_WOP_FLAG, String P_POAD_TYPE) throws Exception {
		String M_COVER_CLASS = null;
		String M_DUMMY1 = null;
		String CURSOR_C1 = "SELECT COVER_CLASS FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PM_IL_APPL_WOP_COVER WHERE  AWCVR_COVER_CODE = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { P_COVER_CODE });
			if (resultSet.next()) {
				M_COVER_CLASS = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("W".equals(M_COVER_CLASS) && "Y".equals(P_WOP_FLAG)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91406"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { P_COVER_CODE });
			if (resultSet.next()) {
				M_DUMMY1 = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if (!("X".equals(CommonUtils.nvl(M_DUMMY1, "N")))) {
				if ("R".equals(P_POAD_TYPE)) {
					P_WOP_FLAG = "N";
				} else if ("E".equals(P_POAD_TYPE)) {
					P_WOP_FLAG = "N";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
		return P_WOP_FLAG;
	}

	public void IL_UNIQUE_ADDL_COVER_ASSR_CODE(String POAD_TYPE,
			String P_POAD_SYS_ID, String POL_SYS_ID, String P_COVER_CODE,
			String P_ROW_ID, String P_ASSR_CODE) throws Exception {

		String M_ADDL_COVER_CODE = null;
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID =  ? "
			+ "AND    POAC_COVER_CODE = ? AND  POAC_ASSR_CODE  = ? AND  POAC_POL_SYS_ID = ? ";
		String CURSOR_C1A = "SELECT 'X' FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID = ? "
			+ "AND POAC_COVER_CODE = ? AND  POAC_ASSR_CODE = ?	AND  POAC_POL_SYS_ID  = ? ";
		String CURSOR_C2 = "SELECT 'X' FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID = ? "
			+ "AND    POAC_COVER_CODE = ? AND POAC_ASSR_CODE = ? AND POAC_POL_SYS_ID  = ? AND  ROWID != ? ";
		String CURSOR_C2A = "SELECT 'X' FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID =  ? "
			+ "AND POAC_COVER_CODE  = ? AND POAC_ASSR_CODE   = ? AND POAC_POL_SYS_ID  = ? AND ROWID != ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {

			connection = CommonUtils.getConnection();
			if (P_ROW_ID == null) {
				if ("R".equals(POAD_TYPE)) {
					resultSet = handler.executeSelectStatement(CURSOR_C1,
							connection, new Object[] { P_POAD_SYS_ID,
							P_COVER_CODE, P_ASSR_CODE, POL_SYS_ID });
					if (resultSet.next()) {
						M_ADDL_COVER_CODE = resultSet.getString(1);
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
								"71039"));
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C1A,
							connection, new Object[] { P_POAD_SYS_ID,
							P_COVER_CODE, P_ASSR_CODE, POL_SYS_ID });
					if (resultSet.next()) {
						M_ADDL_COVER_CODE = resultSet.getString(1);
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
								"71039"));
					}
					CommonUtils.closeCursor(resultSet);
				}
			} else {
				if ("R".equals(POAD_TYPE)) {
					resultSet = handler.executeSelectStatement(CURSOR_C2,
							connection, new Object[] { P_POAD_SYS_ID,
							P_COVER_CODE, P_ASSR_CODE, POL_SYS_ID,
							P_ROW_ID });
					if (resultSet.next()) {
						M_ADDL_COVER_CODE = resultSet.getString(1);
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,
								"71039"));
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					resultSet = handler.executeSelectStatement(CURSOR_C2A,
							connection, new Object[] { P_POAD_SYS_ID,
							P_COVER_CODE, P_ASSR_CODE, POL_SYS_ID,
							P_ROW_ID });
					if (resultSet.next()) {
						M_ADDL_COVER_CODE = resultSet.getString(1);
						throw new Exception(Messages
								.getString(PELConstants.pelErrorMessagePath,"71039"));
					}
					CommonUtils.closeCursor(resultSet);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}
	public ArrayList<String> P_DISP_OCCU_CODE_AND_CLASS(String POAD_TYPE,
			String POAD_OCC_CODE,
			String POL_PROD_CODE,
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_PC_CODE = null;
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedure = new DBProcedures();
		PKG_PILQ003 pilt002Procedures = new PKG_PILQ003();
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = new ArrayList<String>();
		String P_POAD_OCC_DESC = null;
		String P_POAD_OCC_CLASS_DESC = null;
		String P_POAD_OCC_CLASS = null;
 
		String CURSOR_C1 = "SELECT PC_CODE FROM   PM_CODES WHERE  PC_TYPE='IL_OCCU' AND "
			+ "(SUBSTR(PC_REMARKS,INSTR(PC_REMARKS,? ),LENGTH(  ?)) = ?  OR  PC_REMARKS = '1')";
		String CURSOR_C2 = "SELECT PC_CODE FROM   PM_CODES WHERE  PC_TYPE='IL_OCCU' AND "
			+ "(SUBSTR(PC_BL_LONG_DESC,INSTR(PC_BL_LONG_DESC,? ),LENGTH( ? )) = ?  OR  PC_BL_LONG_DESC ='1')";
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			connection = CommonUtils.getConnection();
			if ("R".equals(CommonUtils.nvl(POAD_TYPE, "N"))) {
				values = new Object[] { POL_PROD_CODE,POL_PROD_CODE,POL_PROD_CODE };
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection, values);
				if (resultSet.next()) {
					M_PC_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
			
				list = pilt002Procedures.P_DISP_OCCU_CLASS("R",M_PC_CODE, P_POAD_OCC_DESC, P_POAD_OCC_CLASS, P_POAD_OCC_CLASS_DESC);
				if (list != null && !list.isEmpty()) {
					if (list.get(0).getValueObject() != null) {
						list1.add((String)list.get(0).getValueObject());
					}
					if (list.get(1).getValueObject() != null) {
						list1.add((String)list.get(1).getValueObject());
					}
					if (list.get(2).getValueObject() != null) {
						list1.add((String)list.get(2).getValueObject());
					}
					if (list.get(3).getValueObject() != null) {
						list1.add((String)list.get(3).getValueObject());
					}
					
				}
						
				
			} else if ("E".equals(CommonUtils.nvl(POAD_TYPE, "N"))) {
				values = new Object[] {POL_PROD_CODE,POL_PROD_CODE,POL_PROD_CODE};
				resultSet = handler.executeSelectStatement(CURSOR_C2,connection, values);
				if (resultSet.next()) {
					M_PC_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_OCC_CODE(M_PC_CODE);
				list = pilt002Procedures.P_DISP_OCCU_CLASS("R",M_PC_CODE, P_POAD_OCC_DESC, P_POAD_OCC_CLASS, P_POAD_OCC_CLASS_DESC);
						
				// PROCEDURE_P_DISP_OCCU_CLASS("E",compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
		return list1;
	}
	 /**
    *
    * @param P_COVER_CODE-IN
    * @param P_COVER_DESC-IN OUT
    * @param P_PROD_CODE-IN
    * @param P_NAME_FLAG-IN
    * @param P_ERR_FLAG-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_VAL_PROD_COVER(
                    Object P_COVER_CODE,
         Object P_COVER_DESC,
         Object P_PROD_CODE,
         Object P_NAME_FLAG,
         Object P_ERR_FLAG) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_COVER_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_COVER_DESC);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
          parameterList.add(param5);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "PKG_PILT002_APAC.P_VAL_PROD_COVER");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  // Added by Dileshwar :Date 22 sept 2011
  
  public ArrayList<OracleParameter> IL_POAD_AGE_CHECK(
          Object P_ASSRD_TYPE,
Object P_PLAN_CODE,
Object P_CATG_CODE,
Object P_CATG_CODE_1,
Object P_JOINT_LIFE_YN,
Object P_AGE,Object P_AGE_1,
Object P_POL_PERIOD,
Object P_CALC_METHOD,
Object P_PLAN_AGE_TERM_FLAG,
Object P_GLOBAL_PAYER_FOUND) throws ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
parameterList = new ArrayList<OracleParameter>();
outputList = new ArrayList<OracleParameter>();
OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ASSRD_TYPE);
parameterList.add(param1);
OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CODE);
parameterList.add(param2);
OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CATG_CODE);
parameterList.add(param3);
OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CATG_CODE_1);
parameterList.add(param4);
OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_JOINT_LIFE_YN);
parameterList.add(param5);
OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_AGE);
parameterList.add(param6);
OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_AGE_1);
parameterList.add(param7);
OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POL_PERIOD);
parameterList.add(param8);
OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CALC_METHOD);
parameterList.add(param9);
OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_AGE_TERM_FLAG);
parameterList.add(param10);
OracleParameter param11 = new OracleParameter("OUT11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
parameterList.add(param10);

OracleProcedureHandler procHandler = new OracleProcedureHandler();
outputList = procHandler.executeProc(parameterList, connection,
       "PKG_PILT002_APAC.IL_POAD_AGE_CHECK");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
    throw new ProcedureException(e.getMessage());
}
return outputList;
}


  /**
  *
  * @param P_POL_NO-IN
  * @param P_PROD_CODE-IN
  * @param P_CONT_CODE-IN
  * @param P_PROP_NO-IN
  * @param P_PLAN_CODE-IN
  * @param P_POL_SYS_ID-IN
  * @param P_END_NO_IDX-IN
  * @param P_POL_ISSUE_DT-IN
  * @param P_PS_REASON_CODE-IN
  * @param P_PS_REMARKS-IN
  * @param P_GLOBAL_PARA_13-IN
  * @param P_GLOBAL_PARA_11-IN
  * @param P_CALC_METHOD-IN
  * @param P_PROD_PREM_CALC_MTHD-IN
  * @param P_PLAN_TYPE-IN
  * @param P_LC_FIRST_PREM-IN
  * @param P_MODE_OF_PYMT-IN
  * @param P_FC_FIRST_PREM-IN
  * @param P_ADDL_STATUS-IN
  * @param P_DUMMY_POL_NO-IN OUT
  * @param P_FLAG-OUT
  * @param GLOBAL_POL_NO-OUT
  * @param GLOBAL_POL_SYS_ID-OUT
  * @param P_CALL_FORM-OUT
  * @param M_LC_PCHARGES_BORNE_CUSTOMER-OUT
  * @param M_LC_PCHARGES_BORNE_COMPANY-OUT
  * @param M_FC_PCHARGES_BORNE_CUSTOMER-OUT
  * @param M_FC_PCHARGES_BORNE_COMPANY-OUT
  * @param M_LC_SCHARGES_BORNE_CUSTOMER-OUT
  * @param M_LC_SCHARGES_BORNE_COMPANY-OUT
  * @param M_FC_SCHARGES_BORNE_CUSTOMER-OUT
  * @param M_FC_SCHARGES_BORNE_COMPANY-OUT
  *
  * @return ArrayList of type Oracle Parameter
  * @throws Exception
  */
public ArrayList<OracleParameter> M_BUT_OK(
                  Object P_POL_NO,
       Object P_PROD_CODE,
       Object P_CONT_CODE,
       Object P_PROP_NO,
       Object P_PLAN_CODE,
       Object P_POL_SYS_ID,
       Object P_END_NO_IDX,
       Object P_POL_ISSUE_DT,
       Object P_PS_REASON_CODE,
       Object P_PS_REMARKS,
       Object P_GLOBAL_PARA_13,
       Object P_GLOBAL_PARA_11,
       Object P_CALC_METHOD,
       Object P_PROD_PREM_CALC_MTHD,
       Object P_PLAN_TYPE,
       Object P_LC_FIRST_PREM,
       Object P_MODE_OF_PYMT,
       Object P_FC_FIRST_PREM,
       Object P_ADDL_STATUS,
       Object P_DUMMY_POL_NO,
       Object P_FLAG,
       Object GLOBAL_POL_NO,
       Object GLOBAL_POL_SYS_ID,
       Object P_CALL_FORM,
       Object M_LC_PCHARGES_BORNE_CUSTOMER,
       Object M_LC_PCHARGES_BORNE_COMPANY,
       Object M_FC_PCHARGES_BORNE_CUSTOMER,
       Object M_FC_PCHARGES_BORNE_COMPANY,
       Object M_LC_SCHARGES_BORNE_CUSTOMER,
       Object M_LC_SCHARGES_BORNE_COMPANY,
       Object M_FC_SCHARGES_BORNE_CUSTOMER,
       Object M_FC_SCHARGES_BORNE_COMPANY) throws ProcedureException {
     Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
        OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
        parameterList.add(param1);
        OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
        parameterList.add(param2);
        OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CONT_CODE);
        parameterList.add(param3);
        OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROP_NO);
        parameterList.add(param4);
        OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CODE);
        parameterList.add(param5);
        OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
        parameterList.add(param6);
        OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_END_NO_IDX);
        parameterList.add(param7);
        OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_ISSUE_DT);
        parameterList.add(param8);
        OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_REASON_CODE);
        parameterList.add(param9);
        OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PS_REMARKS);
        parameterList.add(param10);
        OracleParameter param11 = new OracleParameter("IN11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_GLOBAL_PARA_13);
        parameterList.add(param11);
        OracleParameter param12 = new OracleParameter("IN12", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_GLOBAL_PARA_11);
        parameterList.add(param12);
        OracleParameter param13 = new OracleParameter("IN13", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_CALC_METHOD);
        parameterList.add(param13);
        OracleParameter param14 = new OracleParameter("IN14", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_PREM_CALC_MTHD);
        parameterList.add(param14);
        OracleParameter param15 = new OracleParameter("IN15", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_TYPE);
        parameterList.add(param15);
        OracleParameter param16 = new OracleParameter("IN16", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_LC_FIRST_PREM);
        parameterList.add(param16);
        OracleParameter param17 = new OracleParameter("IN17", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MODE_OF_PYMT);
        parameterList.add(param17);
        OracleParameter param18 = new OracleParameter("IN18", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_FC_FIRST_PREM);
        parameterList.add(param18);
        OracleParameter param19 = new OracleParameter("IN19", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ADDL_STATUS);
        parameterList.add(param19);
        OracleParameter param20 = new OracleParameter("IN OUT20", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DUMMY_POL_NO);
        parameterList.add(param20);
        OracleParameter param21 = new OracleParameter("OUT21", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param21);
        OracleParameter param22 = new OracleParameter("OUT22", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param22);
        OracleParameter param23 = new OracleParameter("OUT23", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param23);
        OracleParameter param24 = new OracleParameter("OUT24", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param24);
        OracleParameter param25 = new OracleParameter("OUT25", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param25);
        OracleParameter param26 = new OracleParameter("OUT26", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param26);
        OracleParameter param27 = new OracleParameter("OUT27", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param27);
        OracleParameter param28 = new OracleParameter("OUT28", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param28);
        OracleParameter param29 = new OracleParameter("OUT29", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param29);
        OracleParameter param30 = new OracleParameter("OUT30", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param30);
        OracleParameter param31 = new OracleParameter("OUT31", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param31);
        OracleParameter param32 = new OracleParameter("OUT32", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
        parameterList.add(param32);

       OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.executeProc(parameterList, connection,
               "PKG_PILT002_APAC.M_BUT_OK");
     } catch(Exception e) {
     	ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
     }
    return outputList;
}

  

public void  P_DEL_APPL_PROD(Long P_PAPP_POL_SYS_ID ,
							Long P_PAPP_POAD_SYS_ID ,
  			 	        	 Long P_PAPP_SYS_ID,
  			                 String P_PAPP_PROD_CODE,
  				        	 String P_TYPE ,
  				        	 Long P_PCG_SYS_ID,
  				        	 Long P_POAC_SYS_ID ,
  				        	 Long PB_SYS_ID) throws Exception{
	
CRUDHandler handler = new CRUDHandler();
Connection connection;
try {
	connection = CommonUtils.getConnection();

	if ("1".equals(P_TYPE)) {
		P_DEL_COVER_GROUP(P_PAPP_POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID,null,"1", P_POAC_SYS_ID,PB_SYS_ID );
		String DELETE_QUERY = "DELETE FROM PT_IL_POL_APPL_PROD WHERE PAPP_POL_SYS_ID = ? AND PAPP_POAD_SYS_ID = ? AND PAPP_PROD_CODE = NVL(? , PAPP_PROD_CODE)";
		handler.executeDeleteStatement(DELETE_QUERY, connection,new Object[]{P_PAPP_POL_SYS_ID,P_PAPP_POAD_SYS_ID,P_PAPP_PROD_CODE});
	} else if ("2".equals(P_TYPE)) {
		P_DEL_COVER_GROUP(P_PAPP_POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID,null,"2",P_POAC_SYS_ID,PB_SYS_ID);
		String UPDATE_QUERY = "UPDATE PT_IL_POL_APPL_PROD SET PAPP_FC_SA = 0,PAPP_LC_SA = 0,PAPP_FC_BASIC_PREM = 0," +
				"PAPP_LC_BASIC_PREM = 0,PAPP_FC_ADDL_PREM = 0,PAPP_LC_ADDL_PREM = 0,PPAP_DEL_FLAG = 'Y'" +
				"WHERE  PAPP_POL_SYS_ID = ? AND    PAPP_POAD_SYS_ID = ? AND    PAPP_PROD_CODE = NVL(?, PAPP_PROD_CODE)";
		handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_PAPP_POL_SYS_ID,P_PAPP_POAD_SYS_ID,P_PAPP_PROD_CODE});
	}else if ("3".equals(P_TYPE)) {
		P_DEL_COVER_GROUP(P_PAPP_POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID,null,"3",P_POAC_SYS_ID,PB_SYS_ID);
		String UPDATE_QUERY = "UPDATE PT_IL_POL_APPL_PROD SET  PAPP_FC_SA = (PAPP_ORG_FC_SA * -1), PAPP_LC_SA = (PAPP_ORG_LC_SA * -1), " +
				"PAPP_FC_BASIC_PREM = (PAPP_ORG_FC_BASIC_PREM * -1),PAPP_LC_BASIC_PREM = (PAPP_ORG_LC_BASIC_PREM * -1),PAPP_FC_ADDL_PREM = (PAPP_ORG_FC_ADDL_PREM * -1)," +
				"PAPP_LC_ADDL_PREM = (PAPP_ORG_LC_ADDL_PREM * -1),PPAP_DEL_FLAG = 'Y' WHERE  PAPP_POL_SYS_ID = ? AND    PAPP_POAD_SYS_ID = ? " +
				"AND PAPP_PROD_CODE = NVL( ? , PAPP_PROD_CODE)";
		handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_PAPP_POL_SYS_ID,P_PAPP_POAD_SYS_ID,P_PAPP_PROD_CODE});
	}
	
} catch (DBException e) {
	e.printStackTrace();
	throw new Exception(e.getMessage());
} catch (SQLException e) {
	e.printStackTrace();
	throw new Exception(e.getMessage());
}   
	
  		
     
}

public void  P_DEL_COVER_GROUP ( Long P_PCG_POL_SYS_ID,
			 	        		 Long P_PCG_PAPP_SYS_ID ,
			 	        		 Long P_PCG_SYS_ID,
			                   	 String P_PCG_CODE 	,
				        		 String P_TYPE,
				        		 Long P_POAC_SYS_ID,
				        		 Long PB_SYS_ID) throws Exception{ 

CRUDHandler handler = new CRUDHandler();
Connection connection;
String P_COVER_CODE = null;
try {
	connection = CommonUtils.getConnection();
if ("1".equals(P_TYPE)) {
	P_DEL_MAST_DETL( P_COVER_CODE,P_PCG_CODE,P_PCG_PAPP_SYS_ID,P_PCG_SYS_ID,P_PCG_POL_SYS_ID,P_POAC_SYS_ID,"1" ,PB_SYS_ID);
	String DELETE_QUERY = "DELETE FROM PT_IL_POL_COVER_GROUP WHERE PCG_POL_SYS_ID = ? AND PCG_PAPP_SYS_ID = ? AND PCG_CODE = NVL(? ,PCG_CODE)";
	handler.executeDeleteStatement(DELETE_QUERY, connection,new Object[]{P_PCG_POL_SYS_ID,P_PCG_PAPP_SYS_ID,P_PCG_CODE});

} else if ("2".equals(P_TYPE)) {
	P_DEL_MAST_DETL( P_COVER_CODE,P_PCG_CODE,P_PCG_PAPP_SYS_ID,P_PCG_SYS_ID,P_PCG_POL_SYS_ID,P_POAC_SYS_ID,"2",PB_SYS_ID );
	String UPDATE_QUERY = "UPDATE   PT_IL_POL_COVER_GROUP SET PCG_FC_PREM = 0, PCG_LC_PREM = 0, PCG_ORG_FC_PREM = 0," +
			"PCG_ORG_LC_PREM = 0,PCG_DEL_FLAG = 'Y' WHERE PCG_POL_SYS_ID = ? AND PCG_PAPP_SYS_ID = ? AND PCG_CODE = NVL( ? , PCG_CODE)";
	handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_PCG_POL_SYS_ID,P_PCG_PAPP_SYS_ID,P_PCG_CODE});

} else if ("3".equals(P_TYPE)) {
	P_DEL_MAST_DETL( P_COVER_CODE,P_PCG_CODE,P_PCG_PAPP_SYS_ID,P_PCG_SYS_ID,P_PCG_POL_SYS_ID,P_POAC_SYS_ID,"3" ,PB_SYS_ID);
	String UPDATE_QUERY = "UPDATE   PT_IL_POL_COVER_GROUP SET PCG_FC_PREM = (PCG_ORG_FC_PREM  * -1)," +
			"PCG_LC_PREM = (PCG_ORG_LC_PREM  * -1), PCG_DEL_FLAG = 'Y' WHERE PCG_POL_SYS_ID = ? AND PCG_PAPP_SYS_ID = ?  AND PCG_CODE = NVL( ? , PCG_CODE)";
	handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_PCG_POL_SYS_ID,P_PCG_PAPP_SYS_ID,P_PCG_CODE});

}
} catch (DBException e) {
	e.printStackTrace();
	throw new Exception(e.getMessage());
} catch (SQLException e) {
	e.printStackTrace();
	throw new Exception(e.getMessage());
}



}
  
public void P_DEL_MAST_DETL (	String P_COVER_CODE,
								String P_PCG_CODE ,
								Long P_PAPP_SYS_ID ,
								Long P_PCG_SYS_ID, 
								Long P_POL_SYS_ID  ,
								Long P_POAC_SYS_ID  ,
								String P_TYPE ,
								Long PB_SYS_ID) throws Exception {

	CRUDHandler handler = new CRUDHandler();
	Connection connection;
	try {
		connection = CommonUtils.getConnection();
	
if ("1".equals(P_TYPE)) {
	P_DEL_POL_BENEFIT(P_POL_SYS_ID,P_POAC_SYS_ID,null,PB_SYS_ID,"1");
	String DELETE_QUERY = "DELETE FROM PT_IL_POL_ADDL_COVER WHERE  POAC_POL_SYS_ID = ? AND POAC_PAPP_SYS_ID = NVL(?,POAC_PAPP_SYS_ID)" +
			"AND POAC_PCG_SYS_ID = ? AND POAC_COVER_CODE = NVL( ? ,POAC_COVER_CODE) ";
	handler.executeDeleteStatement(DELETE_QUERY, connection,new Object[]{P_POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID,P_COVER_CODE});
	
}else if ("2".equals(P_TYPE)) {

	String UPDATE_QUERY = "UPDATE PT_IL_POL_ADDL_COVER SET  POAC_FC_SA= 0 ,POAC_LC_SA = 0 ,POAC_FC_PREM = 0 ,POAC_LC_PREM = 0 ," +
			"POAC_DEL_FLAG = 'Y' WHERE  POAC_POL_SYS_ID = ? AND    POAC_PAPP_SYS_ID = NVL(? ,POAC_PAPP_SYS_ID) " +
			"AND     POAC_PCG_SYS_ID = ? AND    POAC_COVER_CODE = NVL( ? ,POAC_COVER_CODE)";
	handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID,P_COVER_CODE});
	
}else if ("3".equals(P_TYPE)) {

	String UPDATE_QUERY = "UPDATE PT_IL_POL_ADDL_COVER  SET  POAC_FC_SA =(POAC_ORG_FC_SA * -1 )," +
			"POAC_LC_SA   = (POAC_ORG_LC_SA * -1 ),POAC_FC_PREM = (POAC_ORG_FC_PREM * -1) ,POAC_LC_PREM = (POAC_ORG_LC_PREM * -1) ," +
			"POAC_DEL_FLAG = 'Y' WHERE  POAC_POL_SYS_ID = ? AND    POAC_PAPP_SYS_ID = NVL( ? ,POAC_PAPP_SYS_ID) " +
			"AND     POAC_PCG_SYS_ID = ?  AND    POAC_COVER_CODE = NVL( ? ,POAC_COVER_CODE)";
	handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_POL_SYS_ID,P_PAPP_SYS_ID,P_PCG_SYS_ID,P_COVER_CODE});
	
}	 
	
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}

}

public void  P_DEL_POL_BENEFIT(Long P_PB_POL_SYS_ID ,
							   Long P_PB_POAC_SYS_ID ,
							   String P_BNF_CODE ,
							   Long PB_SYS_ID,
							   String P_TYPE ) throws Exception{

	CRUDHandler handler = new CRUDHandler();
	Connection connection;
	try {
		connection = CommonUtils.getConnection();
	
	
	if ("1".equals(P_TYPE)) {
		P_DEL_POL_SUB_BENEFIT(P_PB_POL_SYS_ID,PB_SYS_ID,P_BNF_CODE,null,"1");
		P_DEL_POL_DEDUCTIBLE(P_PB_POL_SYS_ID,PB_SYS_ID,P_BNF_CODE,null,"1");
		String DELETE_QUERY = "DELETE FROM PT_IL_POL_BENEFIT WHERE PB_POL_SYS_ID = ? AND PB_POAC_SYS_ID = ? AND PB_BNF_CODE = NVL( ? , PB_BNF_CODE)";
		handler.executeDeleteStatement(DELETE_QUERY, connection,new Object[]{P_PB_POL_SYS_ID,P_PB_POAC_SYS_ID,P_BNF_CODE});

	}else 	if ("2".equals(P_TYPE)) {
		P_DEL_POL_SUB_BENEFIT(P_PB_POL_SYS_ID,PB_SYS_ID,P_BNF_CODE,null,"2");
		P_DEL_POL_DEDUCTIBLE(P_PB_POL_SYS_ID,PB_SYS_ID,P_BNF_CODE,null,"2");
		String UPDATE_QUERY = "UPDATE   PT_IL_POL_BENEFIT SET PB_PER_DAY_LC_AMT = 0, PB_LIMIT_DAYS = 0, " +
				"PB_LC_LIMIT = 0,PB_ORG_LC_LIMIT = 0,PB_DEL_FLAG = 'Y' WHERE PB_POL_SYS_ID = ? AND PB_POAC_SYS_ID =  ? AND PB_BNF_CODE = NVL( ? , PB_BNF_CODE)";
		handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_PB_POL_SYS_ID,P_PB_POAC_SYS_ID,P_BNF_CODE});

	}else 	if ("3".equals(P_TYPE)) {
		P_DEL_POL_SUB_BENEFIT(P_PB_POL_SYS_ID,PB_SYS_ID,P_BNF_CODE,null,"3");
		P_DEL_POL_DEDUCTIBLE(P_PB_POL_SYS_ID,PB_SYS_ID,P_BNF_CODE,null,"3");
		String UPDATE_QUERY = "UPDATE  PT_IL_POL_BENEFIT SET   PB_LC_LIMIT  = (PB_ORG_LC_LIMIT  * -1), PB_DEL_FLAG = 'Y'" +
				"WHERE PB_POL_SYS_ID =  ? AND PB_POAC_SYS_ID =  ? AND PB_BNF_CODE = NVL( ? , PB_BNF_CODE)";
		handler.executeUpdateStatement(UPDATE_QUERY, connection,new Object[]{P_PB_POL_SYS_ID,P_PB_POAC_SYS_ID,P_BNF_CODE});

	}
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
		
	}
}
	



public void P_DEL_POL_SUB_BENEFIT( Long P_PSB_POL_SYS_ID,
								   Long	P_PSB_PB_SYS_ID,
								   String	P_PSB_BNF_CODE,
								   String  P_PSB_CODE ,
								   String P_TYPE ) throws Exception{

	CRUDHandler handler = new CRUDHandler();
	Connection connection;
	try {
		connection = CommonUtils.getConnection();
	
	if ("1".equals(P_TYPE)) {
		String DELETE_QUERY  = "DELETE FROM PT_IL_POL_SUB_BENEFIT WHERE PSB_POL_SYS_ID = ? AND PSB_PB_SYS_ID = ? AND PSB_BNF_CODE = ? AND PSB_CODE = NVL( ? , PSB_CODE)";
		handler.executeDeleteStatement(DELETE_QUERY, connection,new Object[]{P_PSB_POL_SYS_ID,P_PSB_PB_SYS_ID,P_PSB_BNF_CODE,P_PSB_CODE});
	}else if ("2".equals(P_TYPE)) {
		String UPDATE_QUERY  = "UPDATE   PT_IL_POL_SUB_BENEFIT SET PSB_PER_DAY_LC_AMT = 0,PSB_LIMIT_DAYS = 0," +
				"PSB_LC_LIMIT = 0,PSB_ORG_LC_LIMIT = 0,PSB_DEL_FLAG = 'Y' WHERE PSB_POL_SYS_ID = ?  AND PSB_PB_SYS_ID = ?" +
				" AND PSB_BNF_CODE = ? AND PSB_CODE = NVL( ? , PSB_CODE)";
		handler.executeDeleteStatement(UPDATE_QUERY, connection,new Object[]{P_PSB_POL_SYS_ID,P_PSB_PB_SYS_ID,P_PSB_BNF_CODE,P_PSB_CODE});
	}else if ("3".equals(P_TYPE)) {
		String UPDATE_QUERY  = " UPDATE   PT_IL_POL_SUB_BENEFIT SET   PSB_LC_LIMIT = (PSB_ORG_LC_LIMIT * -1), PSB_DEL_FLAG = 'Y'" +
				" WHERE PSB_POL_SYS_ID = ? AND PSB_PB_SYS_ID = ? AND PSB_BNF_CODE = ? AND PSB_CODE = NVL( ? , PSB_CODE)";
		handler.executeDeleteStatement(UPDATE_QUERY, connection,new Object[]{P_PSB_POL_SYS_ID,P_PSB_PB_SYS_ID,P_PSB_BNF_CODE,P_PSB_CODE});
	}
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
		
}





public void P_DEL_POL_DEDUCTIBLE( Long P_PSB_POL_SYS_ID,
								  Long	  P_PSB_PB_SYS_ID,
								  String  P_PSB_BNF_CODE,
								  String  P_PD_CODE ,
								  String P_TYPE) throws Exception {

		CRUDHandler handler = new CRUDHandler();
		Connection connection;
		try {
			connection = CommonUtils.getConnection();

			if ("1".equals(P_TYPE)) {
				String DELETE_QUERY = "DELETE FROM PT_IL_POL_DEDUCTIBLE WHERE PD_POL_SYS_ID = ? AND PD_PB_SYS_ID = ? AND PD_BNF_CODE = ?  AND PD_CODE = NVL( ? ,PD_CODE)";
				handler.executeDeleteStatement(DELETE_QUERY, connection,
						new Object[] { P_PSB_POL_SYS_ID, P_PSB_PB_SYS_ID,
								P_PSB_BNF_CODE, P_PD_CODE });
			} else if ("2".equals(P_TYPE)) {
				String UPDATE_QUERY = " UPDATE PT_IL_POL_DEDUCTIBLE SET PD_NO_OF_DAYS = 0,PD_PERC = 0, PD_MIN_LC_VAL = 0, PD_DEL_FLAG = 'Y'"
						+ " WHERE PD_POL_SYS_ID = ? AND PD_PB_SYS_ID = ? AND PD_BNF_CODE = ? AND PD_CODE = NVL( ? ,PD_CODE)";
				handler.executeDeleteStatement(UPDATE_QUERY, connection,
						new Object[] { P_PSB_POL_SYS_ID, P_PSB_PB_SYS_ID,
								P_PSB_BNF_CODE, P_PD_CODE });
			} else if ("3".equals(P_TYPE)) {
				String UPDATE_QUERY = " UPDATE PT_IL_POL_DEDUCTIBLE SET PD_DEL_FLAG = 'Y' WHERE PD_POL_SYS_ID = ? "
						+ " AND PD_PB_SYS_ID = ? AND PD_BNF_CODE =  ?  AND PD_CODE = NVL( ? ,PD_CODE)";
				handler.executeDeleteStatement(UPDATE_QUERY, connection,
						new Object[] { P_PSB_POL_SYS_ID, P_PSB_PB_SYS_ID,
								P_PSB_BNF_CODE, P_PD_CODE });
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/**
	*
	* @param P_POAD_TYPE-IN
	* @param P_POAD_OCC_CODE-IN OUT
	* @param P_POAD_OCC_DESC-IN OUT
	* @param P_POAD_OCC_CLASS-IN OUT
	* @param P_POAD_OCC_CLASS_DESC-IN OUT
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_DISP_OCCU_CLASS(
	                Object P_POAD_TYPE,
	     Object P_POAD_OCC_CODE,
	     Object P_POAD_OCC_DESC,
	     Object P_POAD_OCC_CLASS,
	     Object P_POAD_OCC_CLASS_DESC) throws ProcedureException {
	   Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_TYPE);
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_OCC_CODE);
	      parameterList.add(param2);
	      OracleParameter param3 = new OracleParameter("IN OUT3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_OCC_DESC);
	      parameterList.add(param3);
	      OracleParameter param4 = new OracleParameter("IN OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_OCC_CLASS);
	      parameterList.add(param4);
	      OracleParameter param5 = new OracleParameter("IN OUT5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_POAD_OCC_CLASS_DESC);
	      parameterList.add(param5);
	
	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.executeProc(parameterList, connection,
	             "PKG_PILT002_APAC.P_DISP_OCCU_CLASS");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}

	public ArrayList<String> P_DEL_MAST_DETL(
			String P_COVER_CODE,
			String M_POL_PROD_CODE,
			String M_POAD_SYS_ID,
			String M_POL_SYS_ID,
			String P_TYPE)throws SQLException, Exception {

		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_COVER_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_POL_PROD_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_POAD_SYS_ID);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",M_POL_SYS_ID);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_TYPE);
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002.P_DEL_MAST_DETL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}
	
	public ArrayList<String> PKG_PILT002_IL_POAD_AGE_CHECK(
			String P_ASSRD_TYPE,
			String P_PLAN_CODE,//
			String P_CATG_CODE, String P_CATG_CODE_1, String P_JOINT_LIFE_YN,
			String P_AGE,String P_AGE_1, String P_POL_PERIOD, String P_CALC_METHOD,
			String P_PLAN_AGE_TERM_FLAG) throws SQLException, Exception {
		
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_ASSRD_TYPE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_PLAN_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_CATG_CODE);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_CATG_CODE_1);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_JOINT_LIFE_YN);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_AGE);
		parameterList.add(param6);
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				P_AGE_1);
		parameterList.add(param7);
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				P_POL_PERIOD);
		parameterList.add(param8);
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				P_CALC_METHOD);
		parameterList.add(param9);
		OracleParameter param10 = new OracleParameter("in10", "STRING", "IN",
				P_PLAN_AGE_TERM_FLAG);
		parameterList.add(param10);
		OracleParameter param11 = new OracleParameter("out1", "STRING", "OUT",
		"");
		parameterList.add(param11);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002_APAC.IL_POAD_AGE_CHECK");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}
	
	/**
    *
    * @param P_POAD_HEIGHT-IN
    * @param P_POAD_WEIGHT-IN
    * @param P_POAD_HEIGHT_UNIT-IN
    * @param P_POAD_WEIGHT_UNIT-IN
    * @param P_POAD_BMI-OUT
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> L_BMI_CALC(
                    Object P_POAD_HEIGHT,
         Object P_POAD_WEIGHT,
         Object P_POAD_HEIGHT_UNIT,
         Object P_POAD_WEIGHT_UNIT,
         Object P_POAD_BMI) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_HEIGHT);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_POAD_WEIGHT);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_HEIGHT_UNIT);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POAD_WEIGHT_UNIT);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, "");
          parameterList.add(param5);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "PKG_PILT002_APAC.L_BMI_CALC");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  public ArrayList<String> P_VAL_ENDT_APPROVAL(
			String P_USER_ID, String P_CODE, String P_PROD_CODE, String P_FLAG,
			String P_POL_END_CODE) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_USER_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_PROD_CODE);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_FLAG);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN OUT",
		"");
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_POL_END_CODE);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002.P_VAL_ENDT_APPROVAL");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}
  
	public ArrayList<String> PILT002_APAC_P_VAL_PRODUCT(String P_PROD_CODE,
			String P_POL_ISSUE_DT, String P_ERR_FLAG) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_PROD_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_POL_ISSUE_DT);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "OUT", "");
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002_APAC.P_VAL_PRODUCT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			// if (oracleParameter.getValue() != null) {
			returnList.add(oracleParameter.getValue());
			// }
		}
		return returnList;
	}
	
	// For com.iii.pel.forms.PILQ003.PT_IL_POLICY_HELPER
	public ArrayList<String> PILT002_IL_AMEND_IDX(String P_POL_SYS_ID,
			String P_POL_NO, String P_DS_TYPE) throws SQLException, Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_POL_SYS_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_POL_NO);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_DS_TYPE);
		parameterList.add(param3);
		
		OracleParameter param4 = new OracleParameter("OUT4", "STRING", "OUT",
				null);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002.IL_AMEND_IDX");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}

	public ArrayList<String> PILT002_P_VAL_CLASS_CUST(
			String P_CUST_TYPE, String P_CUST_CODE, String P_NAME_FLAG,
			String P_ERR_FLAG, String P_DIVN_CODE) throws SQLException,
			Exception {
		Connection connection = null;

		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_CUST_TYPE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CUST_CODE);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN OUT",
		"");
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_NAME_FLAG);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_DIVN_CODE);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"PKG_PILT002.P_VAL_CLASS_CUST");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}
	
	// For com.iii.pel.forms.PILT016A_APAC.PT_IL_DEPOSIT_HELPER
	// added by dileshwar 20th oct 2011
	 /**
   *
   * @param P_CURR_CODE-IN
   * @param P_AMT-IN OUT
   * @param P_VAL_ROUND-IN
   * @param P_POL_PROD_CODE-IN
   *
   * @return ArrayList of type Oracle Parameter
   * @throws Exception
   */
	 public ArrayList<OracleParameter> P_VAL_ROUND_AMT(
	                   Object P_CURR_CODE,
	        Object P_AMT,
	        Object P_VAL_ROUND,
	        Object P_POL_PROD_CODE)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT, P_AMT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_VAL_ROUND);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_PROD_CODE);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PKG_PILT002_APAC.P_VAL_ROUND_AMT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
}
