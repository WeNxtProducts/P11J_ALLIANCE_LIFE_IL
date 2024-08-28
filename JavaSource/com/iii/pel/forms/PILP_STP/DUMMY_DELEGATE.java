package com.iii.pel.forms.PILP_STP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_DELEGATE {

	public List<DUMMY> getListForFM_TO_PROD_CODE(String filterString) {
		ResultSet result = null;
		Connection connection = null;
		List<DUMMY> lovList = new ArrayList<DUMMY>();
		StringBuffer queryString = new StringBuffer();
		CRUDHandler handler = new CRUDHandler();

		Object[] values = { 25 };
		queryString.append("SELECT PROD_CODE,PROD_DESC,PROD_BL_DESC FROM "
				+ "PM_IL_PRODUCT WHERE PROD_CODE IS NOT NULL AND ROWNUM <= ?");

		if (!filterString.equals("*")) {
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
			 * 
			 * queryString.append(" AND UPPER(PROD_CODE) LIKE" + "'"
					+ filterString.toUpperCase() + "%'");*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
			queryString.append(" AND UPPER(PROD_CODE) LIKE UPPER(" + "'"
					+ filterString.toUpperCase() + "%')");
			/*end*/
		}
		try {
			connection = CommonUtils.getConnection();
			result = handler.executeSelectStatement(queryString.toString(),
					connection, values);
			while (result.next()) {
				DUMMY tempBean = new DUMMY();
				tempBean.setUI_M_PROD_FM(result.getString("PROD_CODE"));
				tempBean.setUI_M_PROD_TO(result.getString("PROD_CODE"));
				tempBean.setUI_M_PROD_FM_DESC(result.getString("PROD_DESC"));
				tempBean.setUI_M_PROD_TO_DESC(result.getString("PROD_DESC"));
				lovList.add(tempBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lovList;
	}
	
	/**
    *
    * @param P_PROD_FM-IN
    * @param P_PROD_TO-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_APPRV_PROCESSING(
                    Object P_PROD_FM,
         Object P_PROD_TO,
         Object P_POL_FM_DT,
         Object P_POL_TO_DT) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_FM);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PROD_TO);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_DT);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_DT);
          parameterList.add(param4);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P11JILPK_STP_PROCESSING.P_APPRV_PROCESSING");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

}
