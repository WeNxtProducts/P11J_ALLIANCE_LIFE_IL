package com.iii.pel.forms.PILP026;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;



public class PT_IL_POLICY_HELPER {


	public void executeQuery(PILP026_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POLICY_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void endrosementDeletion(PILP026_COMPOSITE_ACTION compositeAction)throws Exception{
		String query=" SELECT  POL_SYS_ID  FROM  PT_IL_POLICY  WHERE  POL_NO LIKE ? ";
		Connection connection=null;
		ResultSet resultSet=null;
		long sys_id = 0;
		CRUDHandler handler=new CRUDHandler();
		try {

			 connection = CommonUtils.getConnection();
			 resultSet = handler.executeSelectStatement(query, connection,
					new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO() });
			if(resultSet.next()) {
				 sys_id=resultSet.getLong(1);
			}
		 
		
	         if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()!=null){
	        	 
	        P9ILPK_ENDORSE_DELETE_DEL_PROCESS(CommonUtils.getProcedureValue(sys_id),CommonUtils.getProcedureValue(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()-1));
	        
	        
	        
	        
	         }
		}catch(Exception e){
			throw e;
			
		}
		
		
	}
	public void when_validate_Polno(String pol_no,PT_IL_POLICY PT_IL_POLICY_BEAN)throws Exception{
		
		String query=" SELECT POL_ASSURED_NAME,POL_LC_SUM_ASSURED,POL_FC_BASIC_PREM,POL_LC_BASIC_PREM,POL_FC_ADDL_PREM,POL_LC_ADDL_PREM,POL_END_NO_IDX,POL_END_NO,POL_APPRV_STATUS,POL_STATUS FROM  PT_IL_POLICY  WHERE  POL_NO LIKE ? ";
			Connection connection=null;
			ResultSet resultSet=null;
			CRUDHandler handler=new CRUDHandler();
			double endX=0.0;
			String polStatus=null;
			String pol_add_Status=null;
			try {

				 connection = CommonUtils.getConnection();
				 resultSet = handler.executeSelectStatement(query, connection,
						new Object[] {pol_no });
				if(resultSet.next()) {
					endX=resultSet.getDouble(7);
					pol_add_Status=resultSet.getString(9);
					polStatus=resultSet.getString(10);
						if(endX > 0 && !"A".equalsIgnoreCase(pol_add_Status)&& "E".equalsIgnoreCase(polStatus)){
								
								PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(resultSet.getString(1));
								PT_IL_POLICY_BEAN.setPOL_LC_SUM_ASSURED(resultSet.getDouble(2));
								PT_IL_POLICY_BEAN.setPOL_FC_BASIC_PREM(resultSet.getDouble(3));
								PT_IL_POLICY_BEAN.setPOL_LC_BASIC_PREM(resultSet.getDouble(4));
								PT_IL_POLICY_BEAN.setPOL_FC_ADDL_PREM(resultSet.getDouble(5));
								PT_IL_POLICY_BEAN.setPOL_LC_ADDL_PREM(resultSet.getDouble(6));
								PT_IL_POLICY_BEAN.setPOL_END_NO_IDX(resultSet.getDouble(7));
								PT_IL_POLICY_BEAN.setPOL_END_NO(resultSet.getString(8));
							
						}else{
							throw new ValidatorException(new FacesMessage("Enter Valid policy No."));
						}
				}
				}catch(Exception e){
					throw e;
					
			}
	
		
	}
	
	  public ArrayList<OracleParameter> P9ILPK_ENDORSE_DELETE_DEL_PROCESS(String P_POL_SYS_ID,
              String P_END_NO_IDX
   ) throws ProcedureException {
 Connection connection = null;
 ArrayList<OracleParameter> parameterList = null;
 ArrayList<OracleParameter> outputList = null;
 try {
 	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
    OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN", P_POL_SYS_ID);
    parameterList.add(param1);
    OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN", P_END_NO_IDX);
    parameterList.add(param2);

   OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, connection,
           "P9ILPK_ENDORSE_DELETE.DEL_PROCESS");
 } catch(Exception e) {
 	ErrorHelpUtil.getErrorForProcedure(connection);
        throw new ProcedureException(e.getMessage());
 }
return outputList;
}
	
	
	
}