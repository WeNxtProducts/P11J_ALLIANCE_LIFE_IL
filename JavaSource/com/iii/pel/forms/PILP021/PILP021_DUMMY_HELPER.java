package com.iii.pel.forms.PILP021;



import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILP021_DUMMY_HELPER {
	
	public String ValidateUI_M_PROD(String PROD_CODE) throws Exception {
		try {
			return L_VAL_PROD(PROD_CODE);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public String  L_VAL_PROD(String  PROD_CODE) throws Exception {
		String CURSOR_C1 = "SELECT PROD_DESC FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ? " ;
		String PROD_DESC = null;
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection() , new Object[] {PROD_CODE});
			if (resultSet.next()) {
				PROD_DESC = resultSet.getString(1);
			}else {
				throw new Exception("Product Code does not Exists!Please Re-enter");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {CommonUtils.closeCursor(resultSet);}
		
		return PROD_DESC;
	}	

	
	
	
	
	public void validateUI_M_PROP_NO(String POL_NO) throws Exception {
		try {
			V_VAL_POL_CHECK(POL_NO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void V_VAL_POL_CHECK(String POL_NO) throws Exception {
		ResultSet resultSet = null;
		String Query = "SELECT POL_NO  FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			resultSet = new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection() , new Object[] {POL_NO});
			if (resultSet.next()) {
				POL_NO = resultSet.getString(1);
			}else {
				throw new Exception("Invalid Policy/Proposal!Please Re-enter");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
	public void validateUI_M_TO_DT(DUMMY dummy) throws Exception{
		try {
			if (dummy.getUI_M_TO_DT().before(dummy.getUI_M_FM_DT())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2181"));
			}
			if (dummy.getUI_M_TO_DT() != null) {
				if (dummy.getUI_M_TO_DT().after(new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1050"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void whenCreateRecord(DUMMY dummy) throws Exception {
		try {
			dummy.setUI_M_FM_DT(new CommonUtils().getCurrentDate());
			dummy.setUI_M_TO_DT(new CommonUtils().getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void validateUI_M_FM_DT(DUMMY dummy) throws Exception{
		try {
			if (dummy.getUI_M_TO_DT() != null) {
				if (dummy.getUI_M_TO_DT().before(dummy.getUI_M_FM_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1050"));
				}
			}
			if (dummy.getUI_M_FM_DT().after(new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2181"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
    /**
    *
    * @param P_FM_PROD_CODE-IN
    * @param P_TO_PROD_CODE-IN
    * @param P_FM_PROP_NO-IN
    * @param P_TO_PROP_NO-IN
    * @param P_FM_DT-IN
    * @param P_TO_DT-IN
    * @param P_EFF_DT-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> BATCH_APPROVAL(
                    Object P_FM_PROD_CODE,
         Object P_TO_PROD_CODE,
         Object P_FM_PROP_NO,
         Object P_TO_PROP_NO,
         Object P_FM_DT,
         Object P_TO_DT,
         Object P_EFF_DT) throws ProcedureException {
       	Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FM_PROD_CODE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TO_PROD_CODE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FM_PROP_NO);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TO_PROP_NO);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
          parameterList.add(param7);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_AUTO_APPROVAL.BATCH_APPROVAL");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

	
}
