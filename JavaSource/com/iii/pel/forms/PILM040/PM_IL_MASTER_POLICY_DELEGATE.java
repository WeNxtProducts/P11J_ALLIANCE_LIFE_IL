package com.iii.pel.forms.PILM040;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_MASTER_POLICY_DELEGATE {
	
	
	public List<PM_IL_MASTER_POLICY> productCodeLov(Object object,List suggesionList) throws DBException, SQLException{
		
		System.out.println("The Value Entered is "+object.toString());
		List productCodeLov = new ArrayList();
		//CommonUtils commonUtils=new CommonUtils();
		Connection connection =CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		//ResultSet resultSet = null;
		String lovQuery = null;
		String productCode=object.toString();
		String productDesc=null;
		
		if("*".equals(productCode)){
			Object[] pdtCode={};
			lovQuery = PM_IL_MASTER_SQLQUERY_CONSTANTS.PM_IL_MASTER_LOV_QUERY;
			productCodeLov=productCodeSuggestion(lovQuery,connection,pdtCode);	
		}else{
			productCode=productCode.trim().toUpperCase()+"%";
			lovQuery=PM_IL_MASTER_SQLQUERY_CONSTANTS.PM_IL_MASTER_LOV_QUERY_LIKE;
			Object[] pdtCode={productCode};
			productCodeLov=productCodeSuggestion(lovQuery,connection,pdtCode);
			
		}
		/*resultSet = handler.executeSelectStatement(lovQuery, connection);
		//LOVResultSet.setFetchSize(25);
		PM_IL_MASTER_POLICY pm_il_master_policy = null;
		while(resultSet.next()){
			pm_il_master_policy =new PM_IL_MASTER_POLICY() ;
			pm_il_master_policy.setMP_PROD_CODE(resultSet.getString("PROD_CODE"));
			pm_il_master_policy.setUI_M_MP_PROD_CODE_DESC(resultSet.getString("PROD_DESC"));
			productDesc =  pm_il_master_policy.getUI_M_MP_PROD_CODE_DESC();
			productCodeLov.add(pm_il_master_policy);
			System.out.println("MAP \t"+ productDesc);*/
		//	keyValue.put(newPM_IL_MASTER_POLICY.getMP_PROD_CODE(), newPM_IL_MASTER_POLICY.getUI_M_MP_PROD_CODE_DESC());
			
//			newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_01_DESC(LOVResultSet.getString(1));
//			newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_02_DESC(LOVResultSet.getString(2));
//			suggesionList.add(newPP_LIFE_POL_SCH_PRN1);
		
		return productCodeLov;
	}
	
	public List<PM_IL_MASTER_POLICY>  productCodeSuggestion(String lovQuery,Connection connection,Object[] pdtCode) 
	{
		List<PM_IL_MASTER_POLICY> list=new ArrayList<PM_IL_MASTER_POLICY>();
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		PM_IL_MASTER_POLICY pm_il_master_policy = null;
		try{
			resultSet=handler.executeSelectStatement(lovQuery,connection,pdtCode);
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					pm_il_master_policy =new PM_IL_MASTER_POLICY() ;
					pm_il_master_policy.setMP_PROD_CODE(resultSet.getString("PROD_CODE"));
					pm_il_master_policy.setUI_M_MP_PROD_CODE_DESC(resultSet.getString("PROD_DESC"));
					list.add(pm_il_master_policy);
					//productDesc =  pm_il_master_policy.getUI_M_MP_PROD_CODE_DESC();
				}
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String getProductCodeDesc(String productCode, List productCodeLov)
	 {
		Iterator iterator = productCodeLov.iterator();
		String pdtCodeDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_MASTER_POLICY pm_il_master_policy=(PM_IL_MASTER_POLICY)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(productCode.equalsIgnoreCase(pm_il_master_policy.getMP_PROD_CODE()))
	 		{
	 			pdtCodeDesc = pm_il_master_policy.getUI_M_MP_PROD_CODE_DESC();
			}
		}
		return pdtCodeDesc;
	}
	
	public void executeSelectStatement(PM_IL_MASTER_POLICY_ACTION pm_il_master_policy_action)throws Exception{
		CRUDHandler handler=new CRUDHandler();
		 ResultSet resultSet1=null;
		 String globalCustCode=CommonUtils.getGlobalVariable("GLOBAL.M_MP_CUST_CODE");
		 Connection connection = null;
		 Object[] values = null;
		 String C1 = "SELECT ROWID,PM_IL_MASTER_POLICY.* FROM PM_IL_MASTER_POLICY WHERE MP_CUST_CODE =?";
		 try{
			connection = CommonUtils.getConnection();
			values = new Object[]{globalCustCode};
			resultSet1 = handler.executeSelectStatement(C1, connection,values);
			PM_IL_MASTER_POLICY PM_IL_MASTER_POLICY_BEAN = new PM_IL_MASTER_POLICY();
			while(resultSet1.next()){
				PM_IL_MASTER_POLICY_BEAN.setROWID(resultSet1.getString("ROWID"));
				PM_IL_MASTER_POLICY_BEAN.setMP_CUST_CODE(resultSet1.getString("MP_CUST_CODE"));
				PM_IL_MASTER_POLICY_BEAN.setMP_PROD_CODE(resultSet1.getString("MP_PROD_CODE"));
				PM_IL_MASTER_POLICY_BEAN.setMP_POL_NO(resultSet1.getString("MP_POL_NO"));
				PM_IL_MASTER_POLICY_BEAN.setMP_ISSUE_DT(resultSet1.getDate("MP_ISSUE_DT"));
				PM_IL_MASTER_POLICY_BEAN.setMP_POL_FM_DT(resultSet1.getDate("MP_POL_FM_DT"));
				PM_IL_MASTER_POLICY_BEAN.setMP_LC_MAX_TPD_BNF(resultSet1.getDouble("MP_LC_MAX_TPD_BNF"));
				PM_IL_MASTER_POLICY_BEAN.setMP_PRE_TPD_BNF_MONTHS(resultSet1.getInt("MP_PRE_TPD_BNF_MONTHS"));
				PM_IL_MASTER_POLICY_BEAN.setMP_LC_FUNERAL_EXP_LMT(resultSet1.getDouble("MP_LC_FUNERAL_EXP_LMT"));
				PM_IL_MASTER_POLICY_BEAN.setMP_LC_FUNERAL_EXP_AMT(resultSet1.getDouble("MP_LC_FUNERAL_EXP_AMT"));
				PM_IL_MASTER_POLICY_BEAN.setMP_CLM_INTM_DAYS(resultSet1.getInt("MP_CLM_INTM_DAYS"));
				PM_IL_MASTER_POLICY_BEAN.setMP_NOTICE_PRD(resultSet1.getInt("MP_NOTICE_PRD"));
				PM_IL_MASTER_POLICY_BEAN.setMP_LC_FCL(resultSet1.getDouble("MP_LC_FCL"));
				PM_IL_MASTER_POLICY_BEAN.setMP_CR_DT(resultSet1.getDate("MP_CR_DT"));
				PM_IL_MASTER_POLICY_BEAN.setMP_CR_UID(resultSet1.getString("MP_CR_UID"));
				PM_IL_MASTER_POLICY_BEAN.setMP_UPD_DT(resultSet1.getDate("MP_UPD_DT"));
				PM_IL_MASTER_POLICY_BEAN.setMP_UPD_UID(resultSet1.getString("MP_UPD_UID"));
			}
			pm_il_master_policy_action.setPM_IL_MASTER_POLICY_BEAN(PM_IL_MASTER_POLICY_BEAN);
		}catch(Exception exception){
            exception.printStackTrace();
            throw new Exception(exception.getMessage());
        }
        finally { 
        CommonUtils.closeCursor(resultSet1);
       } 
	}
}
