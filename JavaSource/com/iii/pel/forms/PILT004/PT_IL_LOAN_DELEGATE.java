package com.iii.pel.forms.PILT004;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_DELEGATE {
	
	public ArrayList fetchMasterBlock(PT_IL_LOAN_SEARCH searchAction) {
		ArrayList<PT_IL_LOAN> masterList = new ArrayList<PT_IL_LOAN>();
		PT_IL_LOAN searchBean = searchAction.getSearchBean();
		String LOAN_REF_NO = searchBean.getLOAN_REF_NO();
		String LOAN_POL_NO = searchBean.getLOAN_POL_NO();
		
		String query = null;
		ResultSet rs = null;
		
	/*	if(LOAN_REF_NO == null || "".equals(LOAN_REF_NO)){
			query = "SELECT * FROM PT_IL_LOAN";
		}else if(LOAN_REF_NO!= null || !"".equals(LOAN_REF_NO)){
			query = "SELECT * PT_IL_LOAN WHERE LOAN_POL_NO LIKE '%"+LOAN_POL_NO+"%'";
		}
		*/
		
		query = "SELECT LOAN_REF_NO,ROWID,LOAN_POL_NO from PT_IL_LOAN where LOAN_POL_NO LIKE '%"+LOAN_POL_NO+"%'";
		
		
		try{
			Connection con = CommonUtils.getConnection();
			rs = getHandler().executeSelectStatement(query, con);
			while(rs.next()){
				PT_IL_LOAN secondSearchBean = new PT_IL_LOAN();
				secondSearchBean.setLOAN_REF_NO(rs.getString("LOAN_REF_NO"));
				secondSearchBean.setLOAN_POL_NO(rs.getString("LOAN_POL_NO"));
				masterList.add(secondSearchBean);
			}
		}catch(Exception er){
			er.printStackTrace();
		}
		return masterList;
		
	}
	
	/**
    *
    * @param P_DOC_TYPE-IN
    * @param P_DOC_CODE-IN
    * @param P_DIVN_CODE-IN
    * @param P_CLASS_CODE-IN
    * @param P_PLAN_CODE-IN
    * @param P_UW_YEAR-IN
    * @param P_DOC_NO_FN-IN
    * @param P_BLOCK_NAME-IN
    * @param P_DUMMY_YN-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_GEN_DOC_NO(
                    Object P_DOC_TYPE,
         Object P_DOC_CODE,
         Object P_DIVN_CODE,
         Object P_CLASS_CODE,
         Object P_PLAN_CODE,
         Object P_UW_YEAR,
         Object P_DOC_NO_FN,
         Object P_BLOCK_NAME,
         Object P_DUMMY_YN,
         Object P_DOC_NO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DOC_TYPE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DOC_CODE);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DIVN_CODE);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLASS_CODE);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PLAN_CODE);
          parameterList.add(param5);
          OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_UW_YEAR);
          parameterList.add(param6);
          OracleParameter param7 = new OracleParameter("IN7", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DOC_NO_FN);
          parameterList.add(param7);
          OracleParameter param8 = new OracleParameter("IN8", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_BLOCK_NAME);
          parameterList.add(param8);
          OracleParameter param9 = new OracleParameter("IN9", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DUMMY_YN);
          parameterList.add(param9);
          OracleParameter param10 = new OracleParameter("IN10", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, P_DOC_NO);
          parameterList.add(param10);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_LOAN.P_GEN_DOC_NO");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
	
	
	
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

}
