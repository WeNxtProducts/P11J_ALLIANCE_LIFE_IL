package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT007_PROCEDURE {

	public ArrayList<OracleParameter> P_VAL_CUST(Connection connection,
			String in1, String inout1, String in2, String in3, String in4)
			throws SQLException, Exception {
		ArrayList<OracleParameter> outputList = null;
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					in1);
			OracleParameter param2 = new OracleParameter("inout1", "STRING",
					"IN OUT", inout1);
			OracleParameter param3 = new OracleParameter("in2", "STRING", "IN",
					in2);
			OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
					in3);
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					in4);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler handler = new OracleProcedureHandler();
			outputList = null;
			outputList = handler.execute(parameterList, connection,
					"P_VAL_CUST");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputList;
	}

	public String P_VAL_CLASS_CUST(Connection connection, String in1,
			String in2, String inout1, String in3, String in4)
			throws SQLException, Exception {
		String desc;
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					in1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					in2);
			OracleParameter param3 = new OracleParameter("inout1", "STRING",
					"IN OUT", inout1);
			OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
					in3);
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					in4);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler handler = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList = null;
			outputList = handler.execute(parameterList, connection,
					"P_VAL_CLASS_CUST");
			OracleParameter paramOutput = outputList.get(0);
			desc = paramOutput.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return desc;
	}

	public ArrayList<OracleParameter> P_SET_DOC_NO_PROP(Connection connection,
			String in1, String in2, String in3, String in4, String in5,
			String in6, String in7, String in8, String in9, String in10)
			throws SQLException, Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList;
		try {
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",in1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",in2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",in3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",in4);
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
					in5);
			OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
					in6);
			OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
					in7);
			OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
					in8);
			OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
					in9);
			OracleParameter param10 = new OracleParameter("in10", "STRING",
					"IN", in10);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			parameterList.add(param6);
			parameterList.add(param7);
			parameterList.add(param8);
			parameterList.add(param9);
			parameterList.add(param10);
			OracleProcedureHandler handler = new OracleProcedureHandler();
			outputList = null;
			outputList = handler.execute(parameterList, connection,
					"P_SET_DOC_NO_PROP");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outputList;
	}

	public ArrayList<OracleParameter> P_VAL_CURR(Connection connection,
			String currCode, String currName, String nameFlag, String errFlag,
			String custCode) throws SQLException, Exception {
		ArrayList<OracleParameter> outputList;
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					currCode);
			OracleParameter param2 = new OracleParameter("inout1", "STRING",
					"IN OUT", currName);
			OracleParameter param3 = new OracleParameter("in2", "STRING", "IN",
					nameFlag);
			OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
					errFlag);
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					custCode);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler handler = new OracleProcedureHandler();
			outputList = null;
			outputList = handler.execute(parameterList, connection,
					"P_VAL_CURR");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outputList;
	}

	public String P_VAL_SYSTEM(Connection connection, String P_TYPE,
			String P_CODE, String FLAG, String P_VALUE) throws SQLException,
			Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		String returnList;
		try {
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = null;
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					P_TYPE);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					P_CODE);
			OracleParameter param3 = new OracleParameter("inout1", "STRING",
					"IN OUT", "1");
			OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
					FLAG);
			OracleParameter param5 = new OracleParameter("inout2", "INT",
					"IN OUT", P_VALUE);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				if (oracleParameter.getValue() != null) {
					returnList = oracleParameter.getValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return returnList;
	}

	 /**
    *
    * @param P_CURR_CODE-IN
    * @param P_BUY_SELL-IN
    * @param P_EFF_DT-IN
    * @param P_EXHG_RATE-IN OUT
    * @param P_WAR_ERR-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_GET_EXCHANGE_RATE(
                    Object P_CURR_CODE,
         Object P_BUY_SELL,
         Object P_EFF_DT,
         Object P_EXHG_RATE,
         Object P_WAR_ERR) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BUY_SELL);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN OUT4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN_OUT, P_EXHG_RATE);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_WAR_ERR);
          parameterList.add(param5);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P_GET_EXCHANGE_RATE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }


	public String P_VAL_CODES(Connection connection, String CODE_TYPE,
			String CODE, String CODE_DESC, String flag1, String flag2,
			String flag3) throws SQLException, Exception {
		String output;
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			output = null;
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					CODE_TYPE);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					CODE);
			OracleParameter param3 = new OracleParameter("inout1", "STRING",
					"IN OUT", CODE_DESC);
			OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
					flag1);
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					flag2);
			OracleParameter param6 = new OracleParameter("in5", "STRING", "IN",
					flag3);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			parameterList.add(param6);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out
						.println("Output value:" + oracleParameter.getValue());
				output = oracleParameter.getValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return output;
	}

	@Deprecated
	public void P9ILPK_FUND_ALLOC_INS_PT_IL_FUND_TRAN_DTL(
			Connection connection, Double P_POL_SYS_ID, Double P_REF_SYS_ID,
			String P_TRAN_TYPE, String P_TRAN_FLAG, Date P_TRAN_DATE)
			throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_POL_SYS_ID.toString());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_REF_SYS_ID.toString());
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_TRAN_TYPE);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_TRAN_FLAG);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_TRAN_DATE.toString());
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection,
					"P9ILPK_FUND_ALLOC.INS_PT_IL_FUND_TRAN_DTL");
		} catch (Exception e) {
			throw e;
		}
	}

	@Deprecated
	public void P9ILPK_CLAIM_P_INS_CLM_CVR_DTLS(Connection connection,
			String P_CLAIM_TYPE, String P_CLAIM_LOSS_DT, Double P_POL_SYS_ID,
			Double P_CLAIM_SYS_ID, String P_POL_SA_CURR_CODE,
			String P_CLAIM_CURR_CODE, Double P_CLAIM_EXCH_RATE,
			Double P_FC_CIC_AMT, Double P_LC_CIC_AMT, String P_CLAIM_ASSR_CODE)
			throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_CLAIM_TYPE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CLAIM_LOSS_DT);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_POL_SYS_ID.toString());
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_CLAIM_SYS_ID.toString());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_POL_SA_CURR_CODE);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_CLAIM_CURR_CODE);
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				P_CLAIM_EXCH_RATE.toString());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				P_FC_CIC_AMT.toString());
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				P_LC_CIC_AMT.toString());
		OracleParameter param10 = new OracleParameter("in10", "STRING", "IN",
				P_CLAIM_ASSR_CODE);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		parameterList.add(param10);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection,
					"P9ILPK_CLAIM.P_INS_CLM_CVR_DTLS");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Deprecated
	public void P9ILPK_CLAIM_INS_CLM_CVR_RSA(Connection connection,
			String P_CLAIM_TYPE, Date P_CLAIM_LOSS_DT, Double P_POL_SYS_ID,
			Double P_CLAIM_SYS_ID, String P_POL_SA_CURR_CODE,
			String P_CLAIM_CURR_CODE, Double P_CLAIM_EXCH_RATE,
			Double P_FC_CIC_AMT, Double P_LC_CIC_AMT, String P_CLAIM_ASSR_CODE,
			String P_POL_INCORPORATED_YN) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_CLAIM_TYPE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CLAIM_LOSS_DT.toString());
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_POL_SYS_ID.toString());
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_CLAIM_SYS_ID.toString());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_POL_SA_CURR_CODE);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_CLAIM_CURR_CODE);
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				P_CLAIM_EXCH_RATE.toString());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				P_FC_CIC_AMT.toString());
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				P_LC_CIC_AMT.toString());
		OracleParameter param10 = new OracleParameter("in10", "STRING", "IN",
				P_CLAIM_ASSR_CODE);
		OracleParameter param11 = new OracleParameter("in11", "STRING", "IN",
				P_POL_INCORPORATED_YN);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		parameterList.add(param10);
		parameterList.add(param11);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection,
					"P9ILPK_CLAIM.INS_CLM_CVR_RSA");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Double> P9ILPK_CLAIM_P_CALC_CIC_COVER(Connection connection,
			Double POL_SYS_ID) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		System.out.println(POL_SYS_ID);
		List<Double> outputParamList;
		try {
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					(POL_SYS_ID == null ? null : POL_SYS_ID).toString());
			OracleParameter param2 = new OracleParameter("out1", "STRING",
					"OUT", "");
			OracleParameter param3 = new OracleParameter("out1", "STRING",
					"OUT", "");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			OracleProcedureHandler handler = new OracleProcedureHandler();
			ArrayList<OracleParameter> outputList = null;
			try {
				outputList = handler.execute(parameterList, connection,
						"P9ILPK_CLAIM.P_CALC_CIC_COVER");
			} catch (Exception e) {
				e.printStackTrace();
			}
			Iterator<OracleParameter> outputItr = outputList.iterator();
			outputParamList = new ArrayList<Double>();
			while (outputItr.hasNext()) {
				OracleParameter parameter = outputItr.next();
				outputParamList.add(new Double(parameter.getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outputParamList;
	}

	

	public void whenNewFormInstance(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_HELPER claimHelper = new PT_IL_CLAIM_HELPER();
		try {
			claimHelper.executeQuery(compositeAction
					.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	

	@Deprecated
	public void P9ILPK_CLAIM_P_INSERT_FAC_CLM_EST(Connection connection,
			Double P_POL_SYS_ID, Double P_CLM_SYS_ID, String P_CLM_CURR_CODE,
			String P_CLM_LOSS_DT, String P_CCD_COVER_CODE, Double P_CCD_SYS_ID,
			Double P_CCD_FC_EST_AMT, Double P_CCD_LC_EST_AMT, String P_ASSR_CODE)
			throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_POL_SYS_ID.toString());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CLM_SYS_ID.toString());
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_CLM_CURR_CODE);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_CLM_LOSS_DT);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_CCD_COVER_CODE);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_CCD_SYS_ID.toString());
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				P_CCD_FC_EST_AMT.toString());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				P_CCD_LC_EST_AMT.toString());
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				P_ASSR_CODE);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection,
					"P9ILPK_CLAIM.P_INSERT_FAC_CLM_EST");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Deprecated
	public void P9ILPK_CLAIM_INS_TREATY_ESTIMATE(Connection connection,
			Double P_CLAIM_POL_SYS_ID, Double P_CLAIM_SYS_ID,
			String P_CLAIM_CURR_CODE, String P_CLAIM_LOSS_DT,
			String P_CCD_COVER_CODE, Double P_CCD_SYS_ID,
			Double P_CCD_FC_EST_AMT, Double P_CCD_LC_EST_AMT,
			String P_CLAIM_ASSR_CODE) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_CLAIM_POL_SYS_ID.toString());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CLAIM_SYS_ID.toString());
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_CLAIM_CURR_CODE);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_CLAIM_LOSS_DT);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_CCD_COVER_CODE);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				P_CCD_SYS_ID.toString());
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				P_CCD_FC_EST_AMT.toString());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				P_CCD_LC_EST_AMT.toString());
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				P_CLAIM_ASSR_CODE);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection,
					"P9ILPK_CLAIM.INS_TREATY_ESTIMATE");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public ArrayList<String> callP_VAL_ROUND_AMT(Connection connection,
			String P_CURR_CODE, Double P_AMT, String P_VAL_ROUND)
			throws SQLException, Exception {
		if (P_AMT == null) {
			P_AMT = 0.0;
		}
		ArrayList<String> returnList;
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("inout1", "STRING",
					"IN OUT", P_AMT.toString());
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in2", "STRING", "IN",
					P_VAL_ROUND);
			parameterList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_ROUND_AMT");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				if (oracleParameter.getValue() != null) {
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return returnList;
	}

	public ArrayList<String> callP_VAL_FC_LC_TOLERANCE(Connection connection,
			Double P_FC_VAL, Double P_LC_VAL, Double P_EXGE_RATE,
			String P_ERR_FLAG) throws SQLException, Exception {
		ArrayList<String> returnList;
		try {
			if (P_EXGE_RATE == null) {
				P_EXGE_RATE = 1.0;
			}
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					P_FC_VAL.toString());
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					P_LC_VAL.toString());
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					P_EXGE_RATE.toString());
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param4);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_FC_LC_TOLERANCE");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				if (oracleParameter.getValue() != null) {
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return returnList;
	}

	public String P_VAL_COVER(Connection connection, String in1, String in2,
			String in3, String in4, String inout1) throws SQLException,
			Exception {
		String output;
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			output = null;
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					in1);
			OracleParameter param2 = new OracleParameter("inout1", "STRING",
					"IN OUT", inout1);
			OracleParameter param3 = new OracleParameter("in2", "STRING", "IN",
					in2);
			OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
					in3);
			OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
					in4);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			parameterList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_COVER");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out
						.println("Output value:" + oracleParameter.getValue());
				output = oracleParameter.getValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return output;
	}

	public void L_VALID_CLAIM_NO(PILT007_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception {
		try {
			String query = PILT007_SQL_QUERY_CONSTANTS.L_VALID_CLAIM_NO_QUERY;
			Connection connection = CommonUtils.getConnection();
			PT_IL_CLAIM_ACTION claimAction = compositeAction
					.getPILT007_PT_IL_CLAIM_ACTION();
			String CLAIM_NO = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_NO();
			CRUDHandler handler = new CRUDHandler();
			String M_CLAIM_NO = null;
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { CLAIM_NO });
			while (rst.next()) {
				M_CLAIM_NO = rst.getString(1);
			}
			if (rst != null) {
				CommonUtils.closeCursor(rst);
			}
			if (M_CLAIM_NO == null) {
				compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION()
						.getErrorMap().put("current", "Not a valid claim no");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean newSettlement(Long P_CLAIM_SYS_ID) throws SQLException,
			Exception {
		boolean isNew;
		try {
			isNew = false;
			String query = PILT007_SQL_QUERY_CONSTANTS.NEW_SETTLEMENT_QUERY;
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String M_TEMP = null;
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { P_CLAIM_SYS_ID });
			while (rst.next()) {
				M_TEMP = rst.getString(1);
			}
			if (rst != null) {
				CommonUtils.closeCursor(rst);
			}
			if (M_TEMP != null && M_TEMP.equals("X"))
				isNew = false;
			else if (M_TEMP == null)
				isNew = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return isNew;
	}

	public void L_CHECK_BENF_PAID(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception{
		try {
			PT_IL_CLAIM_ACTION claimAction = compositeAction
					.getPILT007_PT_IL_CLAIM_ACTION();
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Long M_CP_SYS_ID = null;// claimPaidAction.ge9tPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();
			Long M_CP_CCD_SYS_ID = null;// claimPaidAction.getPT_IL_CLAIM_PAID_BEAN().getCP_CCD_SYS_ID();
			String M_CCD_COVER_CODE = null;
			Long M_CBEN_PBEN_SYS_ID = null;
			String M_TEMP = null;
			String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_BENF_PAID_QUERY1;
			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_BENF_PAID_QUERY2;
			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_BENF_PAID_QUERY3;
			String sql_C4 = "SELECT COVER_MEDICAL_YN " + "FROM   PM_IL_COVER "
					+ "WHERE  COVER_CODE  = ?";
			ResultSet rst_C4 = null;
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID();
			List<PT_IL_CLAIM_PAID> paidList = new ArrayList<PT_IL_CLAIM_PAID>();
			ResultSet rst1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CLAIM_SYS_ID });
			while (rst1.next()) {
				PT_IL_CLAIM_PAID claimPaidBean = new PT_IL_CLAIM_PAID();
				claimPaidBean.setCP_SYS_ID(rst1.getLong(1));
				claimPaidBean.setCP_CCD_SYS_ID(rst1.getLong(2));
				paidList.add(claimPaidBean);
			}
			if (rst1 != null) {
				CommonUtils.closeCursor(rst1);
			}
			if (paidList.size() > 0) {
				for (int i = 0; i < paidList.size(); i++) {
					PT_IL_CLAIM_PAID claimPaid = paidList.get(i);
					M_CP_SYS_ID = claimPaid.getCP_SYS_ID();
					//M_CBEN_PBEN_SYS_ID = compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_PBEN_SYS_ID();
					M_CP_CCD_SYS_ID = claimPaid.getCP_CCD_SYS_ID();
					String M_COVER_MEDICAL_YN = "N";
					System.out.println(M_CP_SYS_ID + "     " + M_CP_CCD_SYS_ID);
					ResultSet rst3 = handler.executeSelectStatement(sql_C3,
							connection, new Object[] { M_CP_CCD_SYS_ID,
									CLAIM_SYS_ID });
					while (rst3.next()) {
						M_CCD_COVER_CODE = rst3.getString(1);
					}
					if (rst3 != null) {
						CommonUtils.closeCursor(rst3);
					}
					System.out.println("M_CCD_COVER_CODE:::::"
							+ M_CCD_COVER_CODE);

					rst_C4 = handler.executeSelectStatement(sql_C4, connection,
							new Object[] { M_CCD_COVER_CODE });
					if (rst_C4.next()) {
						M_COVER_MEDICAL_YN = rst_C4.getString(1);
					}

					if ((M_COVER_MEDICAL_YN == null ? "N" : M_COVER_MEDICAL_YN)
							.equals("N")) {
						ResultSet rst2 = handler.executeSelectStatement(sql_C2,
								connection, new Object[] { CLAIM_SYS_ID/*,
										M_CP_SYS_ID */});
						while (rst2.next()) {
							M_TEMP = rst2.getString(1);
						}
						if (rst2 != null) {
							CommonUtils.closeCursor(rst2);
						}
						System.out.println("M_TEMP:::" + M_TEMP);
						if (M_TEMP == null) {
							throw new Exception(
									Messages.getString(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"91593"));
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void L_CHECK_BENEFICIARY(PILT007_COMPOSITE_ACTION compositeAction)
			throws SQLException, Exception{
		String C1_REC = null;
		Double M_CLAIM_LC_RLA_AMOUNT = null;
		Double M_CBEN_LC_PAID_AMT = null;
		Double M_CBEN_FC_PAID_AMT = null;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_BENEFICIARY_QUERY1;
			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_BENEFICIARY_QUERY2;
			String sql_C3 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_BENEFICIARY_QUERY3;
			Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID();
			ResultSet rst3 = handler.executeSelectStatement(sql_C3, connection,
					new Object[] { CLAIM_SYS_ID });
			while (rst3.next()) {
				M_CLAIM_LC_RLA_AMOUNT = rst3.getDouble(1);
			}
			if (rst3 != null) {
				CommonUtils.closeCursor(rst3);
			}
			if (M_CLAIM_LC_RLA_AMOUNT != null) {
				Double M_BEN_PERC=null;
				Double M_CP_SYS_ID = null;
				Double M_CP_LC_PAID_AMT = null;
				Double M_CP_FC_PAID_AMT = null;
				ResultSet rst1 = handler.executeSelectStatement(sql_C1,
						connection, new Object[] { CLAIM_SYS_ID });
				while (rst1.next()) {
					//M_CP_SYS_ID = rst1.getDouble(1);
					M_CP_LC_PAID_AMT = rst1.getDouble(1);
					M_CP_FC_PAID_AMT = rst1.getDouble(2);
				}
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}

				ResultSet rst2 = handler.executeSelectStatement(sql_C2,
						connection, new Object[] { CLAIM_SYS_ID,CLAIM_SYS_ID/*, M_CP_SYS_ID*/ });
				while (rst2.next()) {
					M_CBEN_LC_PAID_AMT = rst2.getDouble(1);
					M_CBEN_FC_PAID_AMT = rst2.getDouble(2);
				}
				if (rst2 != null) {
					CommonUtils.closeCursor(rst2);
				}
				
				/*Commentted &Modified by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
				
				/*changed by raja 24-06-2017 for hands on points*/
				
				//String Query="SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CLAIM_SYS_ID=?";
				
				String Query="SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID=?";

				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, connection, new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID()});
				
				/*End*/
				
				while(rs.next())
				{
					M_BEN_PERC=rs.getDouble(1);
				}
				if(M_BEN_PERC!=100)
				{
					throw new Exception("Total Beneficiary share percentage should be equal to 100");
				}

				/*end*/
				
				if ((M_CP_LC_PAID_AMT == null ? 0.0 : M_CP_LC_PAID_AMT) < (M_CBEN_LC_PAID_AMT == null ? 0.0
						: M_CBEN_LC_PAID_AMT)) {
					System.out.println("Exception in L_CHECK_BENEFICIARY");
					throw new Exception("Settlement Amt Cannot be less than the amount paid to the beneficiary");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void L_CHECK_ESTAMT_PAIDAMT(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		CRUDHandler handler = new CRUDHandler();
		Double M_SUM_CP_FC_PAID_AMT = null;
		Double M_SUM_CP_LC_PAID_AMT = null;
		String M_PLAN_TYPE = null;
		String CLAIM_NO = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_NO();
		String CLAIM_POL_NO = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_NO();
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_ESTAMT_PAIDAMT_QUERY1;
		String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.L_CHECK_ESTAMT_PAIDAMT_QUERY2;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CLAIM_NO });
			while (rst1.next()) {
				M_SUM_CP_FC_PAID_AMT = rst1.getDouble(1);
				M_SUM_CP_LC_PAID_AMT = rst1.getDouble(2);
			}
			
			if (rst1 != null) {
				CommonUtils.closeCursor(rst1);
			}
			ResultSet rst2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] { CLAIM_POL_NO });
			while (rst2.next()) {
				M_PLAN_TYPE = rst2.getString(1);
			}
			if (rst2 != null) {
				CommonUtils.closeCursor(rst2);
			}
		} catch (Exception e) {
			throw new Exception(Messages
					.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71125"));
		}
		Double M_CP_FC_TOT_EST = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
				.getUI_M_CP_FC_TOT_EST();
		Double M_CP_LC_TOT_EST = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
				.getUI_M_CP_LC_TOT_EST();
		if (M_SUM_CP_FC_PAID_AMT > M_CP_FC_TOT_EST
				&& M_SUM_CP_LC_PAID_AMT > M_CP_LC_TOT_EST) {
			throw new Exception(Messages
					.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71125"));
		}
	}



    /**
      *
      * @param P_CLAIM_SYS_ID-IN
      * @param P_CLAIM_POL_SYS_ID-IN
      *
      * @return ArrayList of type Oracle Parameter
      * @throws Exception
      */
    public ArrayList<OracleParameter> P_BENF_SETTL(
                      Object P_CLAIM_SYS_ID,
           Object P_CLAIM_POL_SYS_ID,Object P_CP_SYS_ID) throws ProcedureException {
         Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_POL_SYS_ID);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CP_SYS_ID);
            parameterList.add(param3);

           OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.executeProc(parameterList, connection,
                   "P9ILPK_CLAIM.P_BENF_SETTL");
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        return outputList;
    }
    

	public Double P9ILPK_CLAIM_F_GET_CLAIM_YEAR(Connection connection,
			Long POL_SYS_ID, Date CLAIM_LOSS_DT) throws Exception {
		String query = PILT007_SQL_QUERY_CONSTANTS.P9ILPK_CLAIM_F_GET_CLAIM_YEAR_QUERY;
		CRUDHandler handler = new CRUDHandler();
		Double yearNo = null;
		try {
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { POL_SYS_ID, CLAIM_LOSS_DT });
			while (rst.next()) {
				yearNo = rst.getDouble(1);
			}
			if (rst != null) {
				CommonUtils.closeCursor(rst);
			}
			rst.getStatement().close();
		} catch (Exception e) {
			throw e;
		}
		return yearNo;
	}
	
	/*Added by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
	
	public ArrayList<OracleParameter> P_CLM_BEN_STLMT(
			Object P_CP_CLAIM_SYS_ID,
			Object P_CP_SYS_ID ) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CP_CLAIM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CP_SYS_ID);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_CLM_BEN_STLMT");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	 
	 /*End*/

	/*Added by janani on 09.02.2018 for updating claim fee record claim pay to ,as per Sivaram's sugg*/
	
	public ArrayList<OracleParameter> P_UPD_CLM_BENEFICIARY(
			Object P_CLAIM_SYS_ID,
			Object P_CP_CE_SYS_ID,
			Object P_CP_SYS_ID,
			Object P_CLAIM_PAID_TO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CP_CE_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CP_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_PAID_TO);
			parameterList.add(param4);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_UPD_CLM_BENEFICIARY");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/*End*/
	
}
