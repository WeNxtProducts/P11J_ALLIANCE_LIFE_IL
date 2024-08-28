package com.iii.pel.forms.PILT036_APAC;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class PT_IL_POL_RED_SA_HELPER {
	public void postQuery(PT_IL_POL_RED_SA_ACTION reducedSumAssuredAction) throws Exception {
		String CURSOR_C1 = "SELECT COVER_DESC FROM  PM_IL_COVER WHERE COVER_CODE= ? ";
		ResultSet resultSet = null;
		PT_IL_POL_RED_SA  reducedSumAssuredBean =reducedSumAssuredAction.getPT_IL_POL_RED_SA_BEAN();
		try {
			if (reducedSumAssuredBean.getPRS_COVER_CODE() != null) {
				resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection() , 
																	new Object[] {reducedSumAssuredBean.
																		getPRS_COVER_CODE()});	
				
				if (resultSet.next()) {
					reducedSumAssuredBean.setUI_M_PRS_COVER_CODE_DESC(resultSet.getString(1));
				}else {
					reducedSumAssuredBean.setUI_M_PRS_COVER_CODE_DESC(null);
				}
				reducedSumAssuredAction.setUPDATE_ALLOWED(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		

	public void preQuery(PT_IL_POL_RED_SA  reducedSumAssuredBean) {
		reducedSumAssuredBean.setPRS_POL_SYS_ID((Long)CommonUtils.getGlobalObject("GLOBAL.M_RSA_POL_SYS_ID")) ;
		reducedSumAssuredBean.setPRS_END_NO_IDX((Integer)CommonUtils.getGlobalObject("GLOBAL.M_RSA_END_NO_IDX")); 	 
	}
	
	public void executeQuery(PT_IL_POL_RED_SA_ACTION reducedSumAssuredAction) throws Exception {
		ResultSet resultSet = null,resultSet1=null;
		String month_lab=null;
		/*Commentted & Modified by saritha on 24-08-2017 for ssp call id ZBILQC-1736021*/ 
		/*String QUERY = "SELECT PT_IL_POL_RED_SA.*,PT_IL_POL_RED_SA.ROWID FROM PT_IL_POL_RED_SA WHERE PRS_POL_SYS_ID = ? AND PT_IL_POL_RED_SA.PRS_MONTH > 0 ORDER BY PRS_MONTH ASC";*/
		String QUERY = "SELECT PT_IL_POL_RED_SA.*,PT_IL_POL_RED_SA.ROWID FROM PT_IL_POL_RED_SA WHERE PRS_POL_SYS_ID = ? AND PT_IL_POL_RED_SA.PRS_MONTH >= 0 ORDER BY PRS_MONTH ASC";
		System.out.println("Dhinesh321");
		reducedSumAssuredAction.getDataList_PT_IL_POL_RED_SA().clear();
		/*End*/
		//added by gopi for Rsa
		String QUERY_Lable="SELECT PROD_DEF_PERIOD_FLAG FROM PM_IL_PRODUCT, PT_IL_POLICY WHERE POL_PROD_CODE = PROD_CODE  AND POL_SYS_ID= ?";
		
		try {
			resultSet1 = new CRUDHandler().executeSelectStatement(QUERY_Lable, CommonUtils.getConnection(), 
					new Object[]{reducedSumAssuredAction.
					getPT_IL_POL_RED_SA_BEAN().
					getPRS_POL_SYS_ID()});
			while(resultSet1.next()) {
				 month_lab=resultSet1.getString("PROD_DEF_PERIOD_FLAG");
			}
			if("M".equalsIgnoreCase(month_lab))
			{
				reducedSumAssuredAction.
				getCOMP_PRS_MONTH_LABEL().setValue("Monthly");
			}else if("Y".equalsIgnoreCase(month_lab)){
				reducedSumAssuredAction.
				getCOMP_PRS_MONTH_LABEL().setValue("Yearly");
			}
			
			resultSet = new CRUDHandler().executeSelectStatement(QUERY, CommonUtils.getConnection(), 
																new Object[]{reducedSumAssuredAction.
																getPT_IL_POL_RED_SA_BEAN().
																getPRS_POL_SYS_ID()});
			while(resultSet.next()) {
			PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN = new PT_IL_POL_RED_SA();
			PT_IL_POL_RED_SA_BEAN.setROWID(resultSet.getString("ROWID"));
			PT_IL_POL_RED_SA_BEAN.setPRS_SYS_ID(resultSet.getLong("PRS_SYS_ID"));
			PT_IL_POL_RED_SA_BEAN.setPRS_POL_SYS_ID(resultSet.getLong("PRS_POL_SYS_ID"));
			PT_IL_POL_RED_SA_BEAN.setPRS_END_NO_IDX(resultSet.getInt("PRS_END_NO_IDX"));
			PT_IL_POL_RED_SA_BEAN.setPRS_MONTH(resultSet.getInt("PRS_MONTH"));
			PT_IL_POL_RED_SA_BEAN.setPRS_FC_SA(resultSet.getDouble("PRS_FC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_LC_SA(resultSet.getDouble("PRS_LC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_INCOR_FC_SA(resultSet.getDouble("PRS_INCOR_FC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_INCOR_LC_SA(resultSet.getDouble("PRS_INCOR_LC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_ORG_FC_SA(resultSet.getDouble("PRS_ORG_FC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_ORG_LC_SA(resultSet.getDouble("PRS_ORG_LC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_ORG_INCOR_FC_SA(resultSet.getDouble("PRS_ORG_INCOR_FC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_ORG_INCOR_LC_SA(resultSet.getDouble("PRS_ORG_INCOR_LC_SA"));
			PT_IL_POL_RED_SA_BEAN.setPRS_CR_DT(resultSet.getDate("PRS_CR_DT"));
			PT_IL_POL_RED_SA_BEAN.setPRS_CR_UID(resultSet.getString("PRS_CR_UID"));
			PT_IL_POL_RED_SA_BEAN.setPRS_UPD_DT(resultSet.getDate("PRS_UPD_DT"));
			PT_IL_POL_RED_SA_BEAN.setPRS_UPD_UID(resultSet.getString("PRS_UPD_UID"));
			PT_IL_POL_RED_SA_BEAN.setPRS_COVER_CODE(resultSet.getString("PRS_COVER_CODE"));
			PT_IL_POL_RED_SA_BEAN.setPRS_LC_SURR_AMT(resultSet.getDouble("PRS_LC_SURR_AMT"));
			PT_IL_POL_RED_SA_BEAN.setPRS_FC_SURR_AMT(resultSet.getDouble("PRS_FC_SURR_AMT"));
			
			
			/*Added By Dhinesh 2.7.2016*/
			
			PT_IL_POL_RED_SA_BEAN.setPRS_FC_SA_UI(CommonUtils.Decimal_Convert(resultSet
					.getString("PRS_FC_SA")));
				PT_IL_POL_RED_SA_BEAN.setPRS_LC_SA_UI(CommonUtils.Decimal_Convert(resultSet
					.getString("PRS_LC_SA")));
				PT_IL_POL_RED_SA_BEAN.setPRS_INCOR_FC_SA_UI(CommonUtils.Decimal_Convert(resultSet
					.getString("PRS_INCOR_FC_SA")));
				PT_IL_POL_RED_SA_BEAN.setPRS_INCOR_LC_SA_UI(CommonUtils.Decimal_Convert(resultSet
					.getString("PRS_INCOR_LC_SA")));
			
			/*End*/
			
			reducedSumAssuredAction.getDataList_PT_IL_POL_RED_SA().add(PT_IL_POL_RED_SA_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void helperexecuteQuery(PT_IL_POL_RED_SA_ACTION reducedSumAssuredAction) throws Exception{
		executeQuery(reducedSumAssuredAction);
	List<PT_IL_POL_RED_SA> dataList = reducedSumAssuredAction.
			getDataList_PT_IL_POL_RED_SA();
	if(dataList!=null && dataList.size() > 0){
		PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN = dataList.get(0);
	PT_IL_POL_RED_SA_BEAN.setRowSelected(true);
		dataList.get(0).setRowSelected(true);
		reducedSumAssuredAction
		.setPT_IL_POL_RED_SA_BEAN(PT_IL_POL_RED_SA_BEAN);
	}
	reducedSumAssuredAction.resetAllComponent();
	
	}
	 public String Decimal_Convert(String Value)
	    {
	    	if(Value != null)
	    	{
	    	int decimalPlaces=0;
	    	System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
	    	 decimalPlaces=(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
	    	System.out.println("decimalPlaces   : "+decimalPlaces);
	    	
	    	
	    	BigDecimal bd = new BigDecimal(Value);
	        bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	        
	        return bd.toString();
	    	}
	    	else
	    	{
	    		return "0.000";
	    	}
	    }

}

