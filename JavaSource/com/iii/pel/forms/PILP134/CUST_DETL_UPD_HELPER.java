package com.iii.pel.forms.PILP134;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_ASSURED_DTLS_ACTION;
import com.iii.pel.forms.PM006_QE.PM006_QE_CUSTOMER;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class CUST_DETL_UPD_HELPER {
	
	public void callP_CUST_UPD_PROCESSING(CUST_DETL_UPD_ACTION actionBean) throws Exception
	{
		 
    Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		
      OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, actionBean.getCUST_DTL_UPD_BEAN().getCDU_SYS_ID());
       parameterList.add(param1);
      
      OracleProcedureHandler procHandler = new OracleProcedureHandler();
      procHandler.executeProc(parameterList, connection,
              "P_CUST_UPD_PROCESSING");
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    
}

	}
/*ADDED BY GOPI */
	public void CDU_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(CUST_DETL_UPD_ACTION CUST_DETL_UPD_ACTION_BEAN) {

		if ("0".equalsIgnoreCase(CUST_DETL_UPD_ACTION_BEAN.getCUST_DTL_UPD_BEAN().getCDU_AGE_PROOF_FLAG())) {
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_AGE_PROOF_OTHERS().setDisabled(false);
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_AGE_PROOF_OTHERS().setRequired(true);

			System.out.println("Hello ------>"+"---->akash");

		} else {
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_AGE_PROOF_OTHERS().setValue("");
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_AGE_PROOF_OTHERS().setSubmittedValue("");
			CUST_DETL_UPD_ACTION_BEAN.getCUST_DTL_UPD_BEAN().setCDU_AGE_PROOF_OTHERS("");
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_AGE_PROOF_OTHERS().setDisabled(true);
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_AGE_PROOF_OTHERS().setRequired(false);
		}
	}
	
	/*public void CDU_BUS_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(CUST_DETL_UPD_ACTION CUST_DETL_UPD_ACTION_BEAN) {

		if ("0".equalsIgnoreCase(CUST_DETL_UPD_ACTION_BEAN.getCUST_DTL_UPD_BEAN().getCDU_BUS_AGE_PROOF_FLAG())) {
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_BUS_AGE_PROOF_OTHERS().setDisabled(false);
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_BUS_AGE_PROOF_OTHERS().setRequired(true);

			System.out.println("Hello ------>"+"---->akash");

		} else {
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_BUS_AGE_PROOF_OTHERS().setValue("");
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_BUS_AGE_PROOF_OTHERS().setSubmittedValue("");
			CUST_DETL_UPD_ACTION_BEAN.getCUST_DTL_UPD_BEAN().setCDU_BUS_AGE_PROOF_OTHERS("");
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_BUS_AGE_PROOF_OTHERS().setDisabled(true);
			CUST_DETL_UPD_ACTION_BEAN.getCOMP_CDU_BUS_AGE_PROOF_OTHERS().setRequired(false);
		}
	}*/
//END	
	
	/*Added by kavitha on 27.07.2018 for KICLIFEQC-1759654*/
	public void when_validate_item_cust_catg_code(CUST_DTL_UPD_BEAN CUST_DTL_UPD_BEAN)throws Exception{
		ArrayList<String> pList = new ArrayList<String>();
		try{
			if(CUST_DTL_UPD_BEAN.getCDU_CATG_CODE() != null){
				pList = DBProcedures.P_VAL_SYSTEM("CATG",
						CUST_DTL_UPD_BEAN.getCDU_CATG_CODE(),
						CUST_DTL_UPD_BEAN.getUI_M_CDU_CATG_CODE_DESC(),
		    		 "E",
		    		 null);
				if(!pList.isEmpty() && pList.size() != 0){
					CUST_DTL_UPD_BEAN.setUI_M_CDU_CATG_CODE_DESC(pList.get(0));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void when_validate_item_CDU_TITLE(CUST_DTL_UPD_BEAN CUST_DTL_UPD_BEAN)
			throws Exception {
		ArrayList<String> pList = new ArrayList<String>();
		try {
			
			if (CUST_DTL_UPD_BEAN.getCDU_TITLE() != null) {
				
		if(CUST_DTL_UPD_BEAN.getCDU_TITLE().equalsIgnoreCase("8"))
		{
			if(CUST_DTL_UPD_BEAN.getCUST_TYPE().equalsIgnoreCase("I"))
			{
				throw new Exception("Not a valid Salutation for the current Customer Type");
			}
		}
		
		if( CUST_DTL_UPD_BEAN.getCUST_TYPE()!=null && CUST_DTL_UPD_BEAN.getCUST_TYPE().equalsIgnoreCase("I"))
		{
			if(CUST_DTL_UPD_BEAN.getCDU_TITLE().equalsIgnoreCase("8"))
			{
				throw new Exception("Not a valid Salutation for the current Customer Type");
			}
		}
			}
			
			
			if (CUST_DTL_UPD_BEAN.getCDU_TITLE() != null) {
				if(CommonUtils.isIN(CUST_DTL_UPD_BEAN.getCDU_TITLE(), "1")){

					CUST_DTL_UPD_BEAN.setCDU_CATG_CODE("1");

				}else if(CommonUtils.isIN(CUST_DTL_UPD_BEAN.getCDU_TITLE(), "5","6","7","27"))
				{
					CUST_DTL_UPD_BEAN.setCDU_CATG_CODE("2");
				}
				else 
				{
					CUST_DTL_UPD_BEAN.setCDU_CATG_CODE(CUST_DTL_UPD_BEAN.getCDU_CATG_CODE());
					CUST_DTL_UPD_BEAN.setUI_M_CDU_CATG_CODE_DESC(CUST_DTL_UPD_BEAN.getUI_M_CDU_CATG_CODE_DESC());
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
