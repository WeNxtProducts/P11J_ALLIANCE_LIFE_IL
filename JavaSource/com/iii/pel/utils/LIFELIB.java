package com.iii.pel.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class LIFELIB {
	/**
	 * P_VAL_ROUND_AMT procedure of LIFELIB
	 * 
	 * @param P_CURR_CODE
	 *            IN
	 * @param P_AMT
	 *            IN OUT
	 * @param P_VAL_ROUND
	 *            IN
	 * @return
	 * @throws Exception
	 */
	public static Double P_VAL_ROUND_AMT(String P_CURR_CODE, Double P_AMT,
			String P_VAL_ROUND) throws Exception {
		String CURSOR_C1 = "SELECT CURR_DECIMAL FROM FM_CURRENCY WHERE  CURR_CODE = ?";
		Object[] values = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		int M_DECIMAL = 0;

		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { P_CURR_CODE };
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					values);
			if (resultSet.next()) {
				M_DECIMAL = resultSet.getInt("CURR_DECIMAL");
			} else {
				M_DECIMAL = 2;
			}

			if ("V".equals(P_VAL_ROUND)) {
				if (ROUND(P_AMT, M_DECIMAL) != P_AMT) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1039"));
				}
			}

			P_AMT = ROUND(P_AMT, M_DECIMAL);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception exc) {
			}
		}

		return P_AMT;
	}

	private static Double ROUND(Double P_AMT, int M_DECIMAL) {
		Double amount = null;
		DecimalFormat decimalFormat = null;

		decimalFormat = new DecimalFormat("#.##");
		amount = Double.valueOf(decimalFormat.format(P_AMT));

		return amount;
	}

	public static void main(String[] args) {
		System.out.println(ROUND(2.345d, 2) == 2.345d);
	}

	public static void L_PRINT_STATUS(String P_CLAIM_CLAIM_POL_SYS_ID,
			String P_CLAIM_CLAIM_SYS_ID, String P_GLOBAL_M_PARA_1,
			String P_CLAIM_STATUS_CS_STATUS_CODE, String P_CTRL_M_USER_ID,
			String P_DUMMY_M_PRINT_TYPE) throws Exception {
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();

			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					P_CLAIM_CLAIM_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					P_CLAIM_CLAIM_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					P_GLOBAL_M_PARA_1);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					P_CLAIM_STATUS_CS_STATUS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
					P_CTRL_M_USER_ID);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("in5", "STRING", "IN",
					P_DUMMY_M_PRINT_TYPE);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			procHandler.execute(parameterList, connection,
					"PKG_PILT006_APAC.L_PRINT_STATUS");
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Program Unit P_VAL_FC_LC_TOLERANCE
	 * 
	 * @param CE_FC_EST_AMT
	 *            IN
	 * @param CE_LC_EST_AMT
	 *            IN
	 * @param CLAIM_EXCH_RATE
	 *            IN
	 * @param P_ERR_FLAG
	 *            IN
	 * @return M_CODE_DESC M_CODE_DESC
	 * @throws Exception
	 */
	
	
	public static String P_VAL_FC_LC_TOLERANCE(Double P_FC_VAL, 
			Double P_LC_VAL, Double P_EXGE_RATE, String P_ERR_FLAG) throws Exception{
		String M_CODE_DESC = null;
		Double M_TOL_PERC = null;
		Double M_EXGE_RATE = null;
		ArrayList<String> outList = null;

		try {

			outList = DBProcedures
					.P_VAL_SYSTEM("ROUNDOFTOL", "ROUNDOFTOL", "E", M_CODE_DESC,CommonUtils.getProcedureValue(M_EXGE_RATE ));
			M_CODE_DESC = outList.get(0);
			M_TOL_PERC = Double.parseDouble(outList.get(1));

			if (CommonUtils.nvl(P_FC_VAL, 0.0d) == 0.0d
					|| CommonUtils.nvl(P_LC_VAL, 0.0d) == 0.0d
					|| CommonUtils.nvl(P_EXGE_RATE, 0.0d) == 0.0d) {
				return null;
			}

			M_EXGE_RATE = CommonUtils.nvl(P_LC_VAL, 0.0d)
					/ CommonUtils.nvl(P_FC_VAL, 0.0d);
			if (((Math.abs(M_EXGE_RATE - P_EXGE_RATE) / M_EXGE_RATE) * 100) > M_TOL_PERC) {
				if ("E".equals(P_ERR_FLAG) || "W".equals(P_ERR_FLAG)) {
					if ("E".equals(P_ERR_FLAG)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1038"));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return M_CODE_DESC;
	}
	   
	    /**
	    *
	    * @param P_DOC_TYPE-IN
	    * @param P_DOC_CODE-IN
	    * @param P_DIVN_CODE-IN
	    * @param P_CLASS_CODE-IN
	    * @param P_PLAN_CODE-IN
	    * @param P_PROD_CODE-IN
	    * @param P_UW_YEAR-IN
	    * @param P_DOC_NO_FN-IN
	    * @param P_BLOCK_NAME-IN
	    * @param P_DUMMY_YN-IN
	    * @param P_DATE-IN
	    * @param P_CLAIM_TYPE-IN
	    * @param P_REG_DATE-IN
	    * @param M_DISABLE_YN-OUT
	    * @param M_FS_CHAR-OUT
	    *
	    * @return ArrayList of type Oracle Parameter
	    * @throws Exception
	    */
	
	public static ArrayList<String> P_SET_DOC_NO_PROP(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
			String P_DOC_NO_FN, String P_BLOCK_NAME, String P_DUMMY_YN,
			String P_DATE, String P_CLAIM_TYPE, String P_REG_DATE,
			String M_DISABLE_YN, String M_FS_CHAR) throws ProcedureException {
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
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",
					P_DOC_NO_FN);
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
			OracleParameter param14 = new OracleParameter("OUT14", "STRING",
					"OUT", "");
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT15", "STRING",
					"OUT", "");
			parameterList.add(param15);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"LIFELIB.P_SET_DOC_NO_PROP");
			
			Iterator<OracleParameter> it = outputList.iterator();
			while(it.hasNext()){
				OracleParameter oracleParameter = it.next();
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return returnList;
	}
	  
	  /**
	    *
	    * @param P_CLASS_CODE-IN
	    * @param P_CLASS_NAME-IN OUT
	    * @param P_NAME_FLAG-IN
	    * @param P_ERR_FLAG-IN
	    *
	    * @return ArrayList of type Oracle Parameter
	    * @throws Exception
	    */
	  public ArrayList<OracleParameter> P_VAL_CLASS(
	                    String P_CLASS_CODE,
	         String P_CLASS_NAME,
	         String P_NAME_FLAG,
	         String P_ERR_FLAG) throws ProcedureException {
	       Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	          OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CLASS_CODE);
	          parameterList.add(param1);
	          OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_CLASS_NAME);
	          parameterList.add(param2);
	          OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
	          parameterList.add(param3);
	          OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	          parameterList.add(param4);

	         OracleProcedureHandler procHandler = new OracleProcedureHandler();
	          outputList = procHandler.execute(parameterList, connection,
	                 "LIFELIB.P_VAL_CLASS");
	       } catch(Exception e) {
	       	ErrorHelpUtil.getErrorForProcedure(connection);
	              throw new ProcedureException(e.getMessage());
	       }
	      return outputList;
	  }
	  
	  /**
	  *
	  * @param P_DOC_TYPE-IN
	  * @param P_DOC_CODE-IN
	  * @param P_DIVN_CODE-IN
	  * @param P_CLASS_CODE-IN
	  * @param P_PLAN_CODE-IN
	  * @param P_PROD_CODE-IN
	  * @param P_UW_YEAR-IN
	  * @param P_DOC_NO_FN-IN OUT
	  * @param P_BLOCK_NAME-IN
	  * @param P_DUMMY_YN-IN
	  * @param P_DATE-IN
	  * @param P_CLAIM_TYPE-IN
	  * @param P_REG_DATE-IN
	  *
	  * @return ArrayList of type Oracle Parameter
	  * @throws Exception
	  */
	public ArrayList<OracleParameter> P_GEN_DOC_NO(
	                  String P_DOC_TYPE,
	       String P_DOC_CODE,
	       String P_DIVN_CODE,
	       String P_CLASS_CODE,
	       String P_PLAN_CODE,
	       String P_PROD_CODE,
	       String P_UW_YEAR,
	       String P_DOC_NO_FN,
	       String P_BLOCK_NAME,
	       String P_DUMMY_YN,
	       String P_DATE,
	       String P_CLAIM_TYPE,
	       String P_REG_DATE,
	       /*Added by Janani on 05.05.2018 for Fidelity endorsement setup issue*/
	       String P_POL_NO
	       /*End*/
			) throws ProcedureException {
	     Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DOC_TYPE);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DOC_CODE);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_CODE);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLASS_CODE);
	        parameterList.add(param4);
	        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PLAN_CODE);
	        parameterList.add(param5);
	        OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_CODE);
	        parameterList.add(param6);
	        OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_UW_YEAR);
	        parameterList.add(param7);
	        OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_DOC_NO_FN);
	        parameterList.add(param8);
	        OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_BLOCK_NAME);
	        parameterList.add(param9);
	        OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_DUMMY_YN);
	        parameterList.add(param10);
	        OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_DATE);
	        parameterList.add(param11);
	        OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_CLAIM_TYPE);
	        parameterList.add(param12);
	        OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_REG_DATE);
	        parameterList.add(param13);

	        /*Added by Janani on 05.05.2018 for Fidelity endorsement setup issue*/
	        
	        OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_NO);
	        parameterList.add(param14);
	       	        
	        /*End*/
	        
	       OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.execute(parameterList, connection,
	               "LIFELIB.P_GEN_DOC_NO");
	     } catch(Exception e) {
	     	ErrorHelpUtil.getErrorForProcedure(connection);
	            throw new ProcedureException(e.getMessage());
	     }
	    return outputList;
	}

	/**
	*
	* @param P_DIVN_CODE-IN
	* @param P_DIVN_NAME-IN OUT
	* @param P_NAME_FLAG-IN
	* @param P_ERR_FLAG-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_VAL_DIVN(
	                String P_DIVN_CODE,
	     String P_DIVN_NAME,
	     String P_NAME_FLAG,
	     String P_ERR_FLAG) throws ProcedureException {
	   Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_CODE); 
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_DIVN_NAME);
	      parameterList.add(param2);
	      OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
	      parameterList.add(param3);
	      OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	      parameterList.add(param4);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.execute(parameterList, connection,
	             "LIFELIB.P_VAL_DIVN");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}

	/**
	*
	* @param P_DIVN_CODE-IN
	* @param P_DEPT_CODE-IN
	* @param P_DEPT_NAME-IN OUT
	* @param P_NAME_FLAG-IN
	* @param P_ERR_FLAG-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<OracleParameter> P_VAL_DEPT(
	                String P_DIVN_CODE,
	     String P_DEPT_CODE,
	     String P_DEPT_NAME,
	     String P_NAME_FLAG,
	     String P_ERR_FLAG) throws ProcedureException {
		
		System.out.println("LIFELIB ----- POST QUERY() ");
		System.out.println("POL_DIVN_CODE        : "+P_DIVN_CODE);		
		System.out.println("POL_DEPT_CODE        : "+P_DEPT_CODE);		
		System.out.println("UI_M_POL_DEPT_DESC   : "+P_DEPT_NAME);
		
	   Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	      OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_CODE); 
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEPT_CODE);
	      parameterList.add(param2);
	      OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_DEPT_NAME);
	      parameterList.add(param3);
	      OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
	      parameterList.add(param4);
	      OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
	      parameterList.add(param5);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.execute(parameterList, connection,
	             "LIFELIB.P_VAL_DEPT");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}

	/**
	*
	* @param P_CUST_CODE-IN
	* @param P_CUST_NAME-IN OUT
	* @param P_NAME_FLAG-IN
	* @param P_ERR_FLAG-IN
	* @param P_DIVN_CODE-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	public ArrayList<String> P_VAL_CUST(
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
	      OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CUST_CODE);
	      parameterList.add(param1);
	      OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_CUST_NAME);
	      parameterList.add(param2);
	      OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
	      parameterList.add(param3);
	      OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	      parameterList.add(param4);
	      OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_DIVN_CODE);
	      parameterList.add(param5);

	     OracleProcedureHandler procHandler = new OracleProcedureHandler();
	      outputList = procHandler.execute(parameterList, connection,
	             "LIFELIB.P_VAL_CUST");
	      Iterator<OracleParameter> it = outputList.iterator();
	      while(it.hasNext()){
	    	  OracleParameter oracleParameter = it.next();
	    	  returnList.add(oracleParameter.getValue());
	      }
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return returnList;
	}

	    
	    /**
	      *
	      * @param P_ORG_VALUE-IN
	      * @param P_PERC-IN
	      * @param P_VALUE-IN
	      * @param P_ERR_FLAG-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_VAL_PERC_VALUE_TOLERANCE(
	                      String P_ORG_VALUE,
	           String P_PERC,
	           String P_VALUE,
	           String P_ERR_FLAG) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ORG_VALUE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PERC);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_VALUE);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	            parameterList.add(param4);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.execute(parameterList, connection,
	                   "LIFELIB.P_VAL_PERC_VALUE_TOLERANCE");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    


	    /**
	    *
	    * @param P_CURR_CODE-IN
	    * @param P_BUY_SELL-IN
	    * @param P_EFF_DT-IN
	    * @param P_EXGE_RATE-IN OUT
	    * @param P_ERR_FLAG-IN
	    *
	    * @return ArrayList of type Oracle Parameter
	    * @throws Exception
	    */
	  public ArrayList<String> P_VAL_EXCHANGE_RATE(
	                    String P_CURR_CODE,
	         String P_BUY_SELL,
	         String P_EFF_DT,
	         String P_EXGE_RATE,
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
	          OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CURR_CODE);
	          parameterList.add(param1);
	          OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BUY_SELL);
	          parameterList.add(param2);
	          OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EFF_DT);
	          parameterList.add(param3);
	          OracleParameter param4 = new OracleParameter("IN OUT4", "STRING", "IN OUT",P_EXGE_RATE);
	          parameterList.add(param4);
	          OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
	          parameterList.add(param5);

	         OracleProcedureHandler procHandler = new OracleProcedureHandler();
	          outputList = procHandler.execute(parameterList, connection,
	                 "LIFELIB.P_VAL_EXCHANGE_RATE");
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
	      * @param P_FC_VAL-IN
	      * @param P_LC_VAL-IN
	      * @param P_EXGE_RATE-IN
	      * @param P_ERR_FLAG-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<String> P_VAL_FC_LC_TOLERANCE(
	                      String P_FC_VAL,
	           String P_LC_VAL,
	           String P_EXGE_RATE,
	           String P_ERR_FLAG) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 ArrayList<String> returnList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_FC_VAL);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_LC_VAL);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_EXGE_RATE);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	            parameterList.add(param4);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.execute(parameterList, connection,
	                   "LIFELIB.P_VAL_FC_LC_TOLERANCE");
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
	      * @param P_CUST_TYPE-IN
	      * @param P_CUST_CODE-IN
	      * @param P_CUST_NAME-IN OUT
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
				 returnList = new ArrayList<String>();
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
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
	                   "LIFELIB.P_VAL_CLASS_CUST");
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
	      * @param P_PLAN_DESC-IN OUT
	      * @param P_NAME_FLAG-IN
	      * @param P_ERR_FLAG-IN
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	    public ArrayList<OracleParameter> P_VAL_PLAN(
	                      Object P_PLAN_CODE,
	           Object P_PLAN_DESC,
	           Object P_NAME_FLAG,
	           Object P_ERR_FLAG) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CODE);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("IN OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN_OUT, P_PLAN_DESC);
	            parameterList.add(param2);
	            OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
	            parameterList.add(param3);
	            OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
	            parameterList.add(param4);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "LIFELIB.P_VAL_PLAN");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }

	    public ArrayList<String> callP_VAL_FC_LC_TOLERANCE(String P_FC_VAL,
				String P_LC_VAL, String P_EXGE_RATE, String P_ERR_FLAG) throws Exception, DBException {
			Connection connection = null;

			ArrayList<String> returnList = null;
			try {
				connection = CommonUtils.getConnection();
				ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
				ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
				returnList = new ArrayList<String>();
				OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
						P_FC_VAL);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
						P_LC_VAL);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
						P_EXGE_RATE);
				parameterList.add(param3);
				OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
						P_ERR_FLAG);
				parameterList.add(param4);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.execute(parameterList, connection,
				"LIFELIB.P_VAL_FC_LC_TOLERANCE");
				Iterator<OracleParameter> iterator = outputList.iterator();
				while (iterator.hasNext()) {
					OracleParameter oracleParameter = iterator.next();
					System.out.println("Output value:::"
							+ oracleParameter.getValue());
					if (oracleParameter.getValue() != null) {
						returnList.add(oracleParameter.getValue());
					}
				}
			} catch (DBException e) {
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			 
					ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
				 
			}

			return returnList;
		}
	    
	    /**
	      *
	      * @param P_END_NO_IDX-IN
	      * @param P_END_NO-OUT
	      *
	      * @return ArrayList of type Oracle Parameter
	      * @throws Exception
	      */
	   public ArrayList<OracleParameter> P_GEN_END_NO(
	                      Object P_END_NO_IDX,
	           Object P_END_NO) throws ProcedureException {
	         Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
	            OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_END_NO_IDX);
	            parameterList.add(param1);
	            OracleParameter param2 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
	            parameterList.add(param2);

	           OracleProcedureHandler procHandler = new OracleProcedureHandler();
	            outputList = procHandler.executeProc(parameterList, connection,
	                   "LIFELIB.P_GEN_END_NO");
	         } catch(Exception e) {
	         	ErrorHelpUtil.getErrorForProcedure(connection);
	                throw new ProcedureException(e.getMessage());
	         }
	        return outputList;
	    }
	    
	    
	    /*public ArrayList<OracleParameter> P_GEN_END_NO(
                Object P_POL_END_CODE,Object P_DIVN_CODE,Object P_CLASS_CODE,Object  P_PLAN_CODE,
                Object P_PROD_CODE,Object P_UW_YEAR,Object P_POL_NO,Object  P_DUMMY_YN,Object P_END_DT,Object P_END_NO_IDX,
     Object P_END_NO) throws ProcedureException {
   Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_END_CODE);
      parameterList.add(param1);
      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DIVN_CODE);
      parameterList.add(param2);
      OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLASS_CODE);
      parameterList.add(param3);
      OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CODE);
      parameterList.add(param4);
      OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
      parameterList.add(param5);
      OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_UW_YEAR);
      parameterList.add(param6);
      OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
      parameterList.add(param7);
      OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
      parameterList.add(param8);
      OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_END_DT);
      parameterList.add(param9);
      OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_END_NO_IDX);
      parameterList.add(param10);
      OracleParameter param11 = new OracleParameter("OUT11", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
      parameterList.add(param11);

     OracleProcedureHandler procHandler = new OracleProcedureHandler();
      outputList = procHandler.executeProc(parameterList, connection,
             "LIFELIB.P_GEN_END_NO");
   } catch(Exception e) {
   	ErrorHelpUtil.getErrorForProcedure(connection);
          throw new ProcedureException(e.getMessage());
   }
  return outputList;
}*/
	    
/*added by raja on 09-06-2017 for ZBILQC-1724894*/

	   public ArrayList<String> P_VAL_CUST_NAME(
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
     OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_CUST_CODE);
     parameterList.add(param1);
     OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_CUST_NAME);
     parameterList.add(param2);
     OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
     parameterList.add(param3);
     OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
     parameterList.add(param4);
     OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_DIVN_CODE);
     parameterList.add(param5);

    OracleProcedureHandler procHandler = new OracleProcedureHandler();
     outputList = procHandler.execute(parameterList, connection,
            "LIFELIB.P_VAL_CUST_NAME");
     Iterator<OracleParameter> it = outputList.iterator();
     while(it.hasNext()){
   	  OracleParameter oracleParameter = it.next();
   	  returnList.add(oracleParameter.getValue());
     }
  } catch(Exception e) {
  	ErrorHelpUtil.getErrorForProcedure(connection);
         throw new ProcedureException(e.getMessage());
  }
 return returnList;
}


}
