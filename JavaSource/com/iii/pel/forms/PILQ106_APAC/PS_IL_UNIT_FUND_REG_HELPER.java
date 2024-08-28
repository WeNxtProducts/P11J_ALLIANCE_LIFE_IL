package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PS_IL_UNIT_FUND_REG_HELPER {

	public void executeQuery(PILQ106_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PS_IL_UNIT_FUND_REG_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PS_IL_UNIT_FUND_REG> dataList = compositeAction
				.getPS_IL_UNIT_FUND_REG_ACTION_BEAN()
				.getDataList_PS_IL_UNIT_FUND_REG();
		if (dataList != null && dataList.size() > 0) {
			compositeAction.getPS_IL_UNIT_FUND_REG_ACTION_BEAN()
					.setPS_IL_UNIT_FUND_REG_BEAN(dataList.get(0));
		}
		//postQuery(compositeAction.getPS_IL_UNIT_FUND_REG_ACTION_BEAN().getPS_IL_UNIT_FUND_REG_BEAN());
		compositeAction.getPS_IL_UNIT_FUND_REG_ACTION_BEAN().resetAllComponent();
		compositeAction.getPS_IL_UNIT_FUND_REG_ACTION_BEAN().calculateUnit();
	}
	
	/*Commented by Sivarajan on 17/11/2019 for sarwa IL*/
	//public void  postQuery(PS_IL_UNIT_FUND_REG PS_IL_UNIT_FUND_REG) throws Exception {
		public void  postQuery(PS_IL_UNIT_FUND_REG PS_IL_UNIT_FUND_REG,PILQ106_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	    
	    Double M_PT_IL_FUND_TRAN_DTL=null;
	    Double M_PT_IL_FUND_TOTAL_VALUE=null;
	    String CURSOR_C1 ="   SELECT FS_DESC   FROM   PM_IL_FUND_SETUP" +
	    		"   WHERE  FS_CODE = ? ";
	   
	    /*Modified function by saritha on 27-07-2017 for ssp call id ZBILQC-1733102*/
	    /*String function_GetUnitPrice = " SELECT P9ILPK_FUND_ALLOC.P_GET_UNIT_PRICE(?,?,?,?)  FROM DUAL  ";*/
	    String function_GetUnitPrice = " SELECT P9ILPK_FUND_ALLOC.P_GET_UNIT_PRICE_1(?,?,?,?)  FROM DUAL  ";
	   /* End*/
	    CRUDHandler handler = new CRUDHandler();
	    ResultSet resultSet_C1 = null,resultSet_Func=null;
	    Connection connection = null;
	    /*Added by Ameen on 29-06-2017 as per Anbarasi sugg. for ZBILQC-1726474*/
	    P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		/*End*/
		 try { 
		     connection = CommonUtils.getConnection();
		     resultSet_C1 = handler.executeSelectStatement(CURSOR_C1,
				    connection, new Object[]{ PS_IL_UNIT_FUND_REG.getUFR_FUND_CODE() } );
			    while (resultSet_C1.next()) {
				PS_IL_UNIT_FUND_REG.setUI_M_FUND_DESC(resultSet_C1.getString(1));
			    } 
			    
			    resultSet_Func = handler.executeSelectStatement(function_GetUnitPrice,
				    connection, new Object[]{  PS_IL_UNIT_FUND_REG.getUFR_FUND_CODE(), 
				    new CommonUtils().getCurrentDate(),"N","N" } );
			    while (resultSet_Func.next()) {
			    	PS_IL_UNIT_FUND_REG.setUNIT_PRICE(resultSet_Func.getDouble(1) );
			    } 
			 
			 M_PT_IL_FUND_TRAN_DTL = PS_IL_UNIT_FUND_REG.getUNIT_PRICE() *
			 CommonUtils.nvl(PS_IL_UNIT_FUND_REG.getUFR_NO_OF_UNITS(),0);
			 /*
			  * commented by Ameen on 29-06-2017 as per Anbarasi sugg. for ZBILQC-1726474
			  * M_PT_IL_FUND_TRAN_DTL = 
				 new DBProcedures().P_VAL_ROUND_AMT(CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR"),     
					 M_PT_IL_FUND_TRAN_DTL ,"R",null);
					 PS_IL_UNIT_FUND_REG.setUNIT_VALUE(CommonUtils.ROUND(M_PT_IL_FUND_TRAN_DTL,2));*/
			 
			 /*Added by Ameen on 29-06-2017 as per Anbarasi sugg. for ZBILQC-1726474*/
			 
			 list.clear();
			 list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR"), 
					 	CommonUtils.getProcedureValue(M_PT_IL_FUND_TRAN_DTL), PS_IL_UNIT_FUND_REG.getUFR_FUND_CODE(), "R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
			 System.out.println("check unit value after P_VAL_FUND_ROUND ::" + list.get(0).getValue());
			 PS_IL_UNIT_FUND_REG.setUNIT_VALUE(Double.parseDouble(list.get(0).getValue()));
			 /*End*/
			 
			 /*M_PT_IL_FUND_TOTAL_VALUE =  M_PT_IL_FUND_TOTAL_VALUE +M_PT_IL_FUND_TRAN_DTL;
			 
			PS_IL_UNIT_FUND_REG.setUI_M_TOT_UNIT_VALUE(M_PT_IL_FUND_TOTAL_VALUE );*/
		
	    } catch (Exception e) {
		// TODO: handle exception
	    	e.printStackTrace();
		    throw new Exception(e.getMessage());
	    }
	    finally{
		try {
		    CommonUtils.closeCursor(resultSet_C1);
		    CommonUtils.closeCursor(resultSet_Func);
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	
}
