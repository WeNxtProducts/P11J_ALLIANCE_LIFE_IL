package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILM086_APP_CUST_HELPER {
	
	
	/*
	public void when_validate_item_BRAC_CUST_CLASS(PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_CUS_BEAN_OBJ)throws Exception{
		try {
			PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_BRAC_CUST_CLASS_DESC(p_val_product
						(PILM086_APAC_APP_CUS_BEAN_OBJ.getBRAC_CUST_CLASS(),"N"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}*/
	
	
	
	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(
			PILM086_APAC_APP_CUS_BEAN Bean) throws Exception {

		String CURSOR_C1 = "SELECT CCLAS_CODE,CCLAS_CLASS_DESC FROM PM_CUST_CLASS";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			while (resultSet.next()) {
				if (Bean.getBRAC_CUST_CLASS().equals(
						resultSet.getString(1))) {
					Bean.setBRAC_CUST_CLASS_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& Bean.getBRAC_CUST_CLASS() != "S") {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	

	
	
	/*public String p_val_product(String BRAC_CUST_CLASS,String P_ERR_FLAG)throws Exception{
		String C1 = " SELECT BRAC_CUST_CLASS_DESC,BRAC_CUST_CLASS" +
				"      FROM   PM_BUS_RULE_APPL_CUST" +
				"      WHERE  BRAC_CUST_CLASS = ?";
		String BRAC_CUST_CLASS_DESC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{BRAC_CUST_CLASS});
			if(resultSet.next()){
				BRAC_CUST_CLASS_DESC = resultSet.getString(1);
			}else{
				 if(CommonUtils.isIN("E","W")){
		         throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91074"));
				 }
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
			}
		}
		return BRAC_CUST_CLASS_DESC;
	}
	*/
	
	
	
	public void post_query(PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_CUS_BEAN_OBJ){
		String M_VALUE = null;
		String C1 = " SELECT  DS_DESC " +
				" FROM  PM_LIFE_DOC_SETUP" +
				"  WHERE  DS_TYPE = ?" +
				" AND  DS_CODE = ?";
		ArrayList<String> pList = new ArrayList<String>();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try{
			connection = CommonUtils.getConnection();
			/*pList = DBProcedures.P_VAL_SYSTEM("LIMODCODES", 
					PILM086_APAC_APP_CUS_BEAN_OBJ.getUI_M_PLSP_MODULE_ID(),
											 "N");
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_MODULE_ID_DESC(pList.get(0));
			}*/
			pList.clear();
			/*pList = DBProcedures.P_VAL_SYSTEM("IL_DOC_TYP", 
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_DS_TYPE(),
										 "N");*/
			/*if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_DS_TYPE_DESC(pList.get(0));
			}
			PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_PROD_CODE_DESC(p_val_product
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_PROD_CODE(), 
										 "N"));
										 
										 
			values = new Object[]{PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_DS_TYPE(),
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_DS_CODE()};
			resultSet = handler.executeSelectStatement(C1, connection,values);*/
			if(resultSet.next()){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setBRAC_CUST_CLASS_DESC(resultSet.getString(1));
			}
			pList.clear();
			/*pList = DBProcedures.P_VAL_SYSTEM ("LIMODCODES" ,
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_MODULE_ID(),
									"E");
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_MODULE_ID_DESC(pList.get(0));
			}*/
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
			}
		}
	}
	
	
	public void when_new_form_instance(PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_CUS_BEAN_OBJ){
		//PILM086_APAC_APP_CUS_BEAN_OBJ.setPLSP_MODULE_ID(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		ArrayList<String> pList = new ArrayList<String>();
		try {
			pList.clear();
			pList = DBProcedures.P_VAL_SYSTEM (null ,
					PILM086_APAC_APP_CUS_BEAN_OBJ.getBRAC_CUST_CLASS(),
									"E");
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setBRAC_CUST_CLASS_DESC(pList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//sql
	

	public void post_query1(PILM086_APAC_SQL_BEAN PILM086_APAC_SQL_BEAN_OBJ){
		String M_VALUE = null;
		String C1 = " SELECT  DS_DESC " +
				" FROM  PM_LIFE_DOC_SETUP" +
				"  WHERE  DS_TYPE = ?" +
				" AND  DS_CODE = ?";
		ArrayList<String> pList = new ArrayList<String>();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try{
			connection = CommonUtils.getConnection();
			/*pList = DBProcedures.P_VAL_SYSTEM("LIMODCODES", 
					PILM086_APAC_APP_CUS_BEAN_OBJ.getUI_M_PLSP_MODULE_ID(),
											 "N");
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_MODULE_ID_DESC(pList.get(0));
			}*/
			pList.clear();
			/*pList = DBProcedures.P_VAL_SYSTEM("IL_DOC_TYP", 
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_DS_TYPE(),
										 "N");*/
			/*if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_DS_TYPE_DESC(pList.get(0));
			}
			PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_PROD_CODE_DESC(p_val_product
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_PROD_CODE(), 
										 "N"));
										 
										 
			values = new Object[]{PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_DS_TYPE(),
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_DS_CODE()};
			resultSet = handler.executeSelectStatement(C1, connection,values);*/
			
			if(resultSet.next()){
				PILM086_APAC_SQL_BEAN_OBJ.setBRH_WHERE_CLAUSE(resultSet.getString(1));
			}
			pList.clear();
			
			/*pList = DBProcedures.P_VAL_SYSTEM ("LIMODCODES" ,
					PILM086_APAC_APP_CUS_BEAN_OBJ.getPLSP_MODULE_ID(),
									"E");
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_CUS_BEAN_OBJ.setUI_M_PLSP_MODULE_ID_DESC(pList.get(0));
			}*/
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
			}
		}
	}
	
	public void when_new_form_instance1( PILM086_APAC_SQL_BEAN PILM086_APAC_SQL_BEAN_OBJ){
		//PILM086_APAC_APP_CUS_BEAN_OBJ.setPLSP_MODULE_ID(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		ArrayList<String> pList = new ArrayList<String>();
		try {
			pList.clear();
			pList = DBProcedures.P_VAL_SYSTEM (null ,
					PILM086_APAC_SQL_BEAN_OBJ.getBRH_WHERE_CLAUSE(),
									"E");
			/*if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_SQL_BEAN_OBJ.setUI_M_BRAC_CUST_CLASS_DESC(pList.get(0));
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//first xhtml
	
	public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		System.out.println("inside executeQuery  =============");
		new PILM086_APP_CUST_DELIGATE().executeSelectStatement(compositeAction);

		
		try{
 	 List<PILM086_APAC_APP_CUS_BEAN> dataList = compositeAction.getPILM086_APP_ACTION_BEAN().getDataList_PP_LIFE_POL_SCH_PRN();
	
	 if(dataList!=null && dataList.size() > 0){
		 PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_BEAN = dataList.get(0);
		 //PILM086_APAC_APP_BEAN.setRowSelected(true);
				compositeAction.getPILM086_APP_ACTION_BEAN().setPILM086_APAC_APP_BEAN(PILM086_APAC_APP_BEAN);
	 }
		}
	 catch (Exception e) {
		e.printStackTrace();
	}
	 
	}

	

	/*public void executeQuery(PILM086_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		List<PILM086_APAC_APP_CUS_BEAN> dataList = null;
		try {
			dataList = compositeAction
			.getPILM086_APP_ACTION_BEAN()
			.getDataList_PP_LIFE_POL_SCH_PRN();
			if(dataList != null && dataList.size()>0){
				dataList.clear();
			}
			new PILM086_APAC_DELIGATE()
					.executeSelectStatement(compositeAction);
				dataList = compositeAction
					.getPILM086_APP_ACTION_BEAN()
					.getDataList_PP_LIFE_POL_SCH_PRN();
			if (dataList != null && dataList.size() > 0) {
				PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_BEAN = dataList.get(0);
				//PILM086_APAC_APP_BEAN.setRowSelected(true);
				compositeAction.getPILM086_APP_ACTION_BEAN()
						.setPILM086_APAC_APP_BEAN(PILM086_APAC_APP_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	*/
	//sql

	/*public void executeQuery1(PILM086_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		List<PILM086_APAC_SQL_BEAN> dataList1 = null;
		try {
			dataList1 = compositeAction
			.getPILM086_APP_ACTION_BEAN()
			.getDataList_PILM086_APAC_SQL_BEAN();
			if(dataList1 != null && dataList1.size()>0){
				dataList1.clear();
			}
			new PILM086_APAC_DELIGATE()
					.executeSelectStatement1(compositeAction);
				dataList1 = compositeAction
					.getPILM086_APP_ACTION_BEAN()
					.getDataList_PILM086_APAC_SQL_BEAN();
			if (dataList1 != null && dataList1.size() > 0) {
				PILM086_APAC_SQL_BEAN PILM086_APAC_SQL_BEAN_OBJ = dataList1.get(0);
				//PILM086_APAC_APP_BEAN.setRowSelected(true);
				compositeAction.getPILM086_APP_ACTION_BEAN()
						.setPILM086_APAC_SQL_BEAN_OBJ(PILM086_APAC_SQL_BEAN_OBJ);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	*/
	
	//end
	
	
	public void when_created_record(PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_BEAN){
		PILM086_APAC_APP_BEAN.setBRAC_CUST_CLASS(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		ArrayList<String> pList = new ArrayList<String>();
		try {
			pList.clear();
			/*pList = DBProcedures.P_VAL_SYSTEM ("LIMODCODES" ,
									PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_MODULE_ID(),
									"E");*/
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_APAC_APP_BEAN.setBRAC_CUST_CLASS_DESC(pList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//sql
	public void when_created_record1(PILM086_APAC_SQL_BEAN PILM086_SQL_BEAN){
		PILM086_SQL_BEAN.setBRH_WHERE_CLAUSE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		ArrayList<String> pList = new ArrayList<String>();
		try {
			pList.clear();
			/*pList = DBProcedures.P_VAL_SYSTEM ("LIMODCODES" ,
									PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_MODULE_ID(),
									"E");*/
			if(!pList.isEmpty() && pList.size() != 0){
				PILM086_SQL_BEAN.setBRH_WHERE_CLAUSE(pList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*public void pre_insert(PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_CUS_BEAN_OBJ)throws Exception{
		 try {
			 PILM086_APAC_APP_CUS_BEAN_OBJ.setPLSP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			 PILM086_APAC_APP_CUS_BEAN_OBJ.setPLSP_CR_DT(new CommonUtils().getCurrentDate());
			// PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID(PP_LIFE_POL_SCH_PRN_BEAN.getUI_M_PLSP_MODULE_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}*/
	
	
}
