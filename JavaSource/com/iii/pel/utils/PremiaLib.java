package com.iii.pel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PremiaLib {
	Connection conn= null;

	public String callProc()
	{
		ArrayList<OracleParameter> list =null;
		OracleParameter orcValue=null;
	
		try{		
			 conn = getConnection();			
		}
		catch(Exception exp){
			exp.printStackTrace();
		}
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			list = procHandler.execute(prepareOracleParam(), conn, "P_VAL_SYSTEM");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Iterator<OracleParameter> it = list.iterator();
		String[] out = new String[list.size()];
		int i =0;
		while(it.hasNext()){
			 orcValue=it.next();
			 out[i] = orcValue.getValue();
			i++;
			
		}
		System.out.println("JSTDLib.callProc()-----------["+out[1]+"]");
		return (String)out[1];
	}



	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection connection = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.44.0.131:1521:iorcl", "P9STM_LIFE", "P9STM_LIFE");
		return connection;
	}
	


	public ArrayList<OracleParameter> prepareOracleParam(){
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","ROUNDOFTOL");
		OracleParameter param2 = new OracleParameter("in2","STRING","IN","ROUNDOFTOL");
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", "E");
		OracleParameter param5 = new OracleParameter("inout2","STRING","IN OUT","");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		return paramList;
		
	}





	
	/*
	**P_VAL_FC_LC_VALUE-This procedure is used to validate the FC and LC 
	**values based on the Curr code.
	*
	*/	
	public void P_VAL_FC_LC_VALUE(int P_FC_VALUE          ,
            int P_LC_VALUE , String P_CURR_CODE, String P_BASE_CURR_CODE,
           int  P_EXCH_RATE){
		
		if(P_CURR_CODE.equals(P_BASE_CURR_CODE)&& P_FC_VALUE!=P_LC_VALUE){
									
			  /*error handling
			   * 
			   * STD_MESSAGE_ROUTINE(80314, NAME_IN('GLOBAL.M_LANG_CODE'));
		       * RAISE FORM_TRIGGER_FAILURE;
		       */
		}else{
			P_VAL_FC_LC_TOLERANCE(P_FC_VALUE,P_LC_VALUE,P_EXCH_RATE,"E");
		}
	}
	
	
	
	
		/*
	    **P_VAL_FC_LC_TOLERANCE-This procedure is to check for the tolerence 
		**limit of the exchange rate.
	    *
		*/
	
	public void P_VAL_FC_LC_TOLERANCE(int P_FC_VAL,
           int P_LC_VAL,
            int P_EXGE_RATE,
            String P_ERR_FLAG){
		
		int M_EXGE_RATE ;
		System.out.println("JSTDLib.P_VAL_FC_LC_TOLERANCE()----["+Integer.parseInt(callProc())+"]");
		int M_TOL_PERC =Integer.parseInt(callProc())		;
		
		
		if((P_FC_VAL == 0) && (P_LC_VAL != 0)){
			/*error handling
			 * 
			 * STD_MESSAGE_ROUTINE(1051, NAME_IN('GLOBAL.M_LANG_CODE'));
		      RAISE FORM_TRIGGER_FAILURE;*/
			
		}
		
		else if(P_FC_VAL == 0){
			return;
								
		}
		
		
		else if(P_EXGE_RATE==0){
			/*error handling
			 * 
			 * STD_MESSAGE_ROUTINE(1052, NAME_IN('GLOBAL.M_LANG_CODE'));
		      RAISE FORM_TRIGGER_FAILURE;
		      */
						
		}
		
		
			M_EXGE_RATE = P_LC_VAL/P_FC_VAL ;
		
		
		int temp = (Math.abs(M_EXGE_RATE - P_EXGE_RATE))/P_EXGE_RATE;
		int percTemp = temp*100;
		
		if(percTemp> M_TOL_PERC){
			/*
			 * error handling
			 * 
			 * IF P_ERR_FLAG IN ('E', 'W') THEN
	         * STD_MESSAGE_ROUTINE(1038, NAME_IN('GLOBAL.M_LANG_CODE'), TO_CHAR(M_TOL_PERC) );
	         *IF P_ERR_FLAG = 'E' THEN
	           *RAISE FORM_TRIGGER_FAILURE ;
	            */
			
		}
				
	}
	
	
	/*added by raja on 13-04-2017 for nationality default*/
	public static String nationalityDisc(String code)
	{
		String Description=null;
		try{
			
			String Query="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'NATLITY' AND PC_CODE=?";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{code});
			while(resultset.next())
			{
				Description=resultset.getString("PC_DESC");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Description;
		
	}
	/*End*/
	
}
