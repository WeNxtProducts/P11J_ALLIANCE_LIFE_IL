package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY_DELEGATE;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_PROP_TREATY_HELPER {

	
	/**
	 * Prepares Class Code List
	 * 
	 * @param classCode
	 * @param classCodeList
	 * @return					classCodeList
	 * @throws Exception 
	 */
	 public List prepareClassCodeList(String classCode, List classCodeList) throws Exception {
	
		String query = null;
		String displayrow=PM_IL_PROP_TREATY_CONSTANTS.PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN;
		try{
			if (PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SUGGESTION_BOX_GET_ALL.equalsIgnoreCase(classCode)) {
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SELECT_CLASS_CODE;
					Object[] object={displayrow};
					classCodeList = classLOV(query,object);
	
			} else {
					classCode=classCode+PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] object={classCode,displayrow};
					System.out.println("class Code :"+classCode);
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SELECT_CLASS_CODE_LIKE;
					classCodeList = classLOV(query,object);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return classCodeList;
	}
	
	/**
	 * Returns Class Description for Code and codeList
	 * 
	 * @param classCode
	 * @param classCodeList
	 * @return					classDesc 
	 */
	 public String getClassDescforCode(String classCode,List classCodeList)
	 {
		Iterator iterator = classCodeList.iterator();
		String classDesc = null;
	 	while(iterator.hasNext()){
	 		PM_IL_PROP_TREATY pm_il_prop_treaty=(PM_IL_PROP_TREATY)iterator.next();
	 		if(classCode.equalsIgnoreCase(pm_il_prop_treaty.getPT_CLASS_CODE())){
	 			classDesc = pm_il_prop_treaty.getUI_M_CLASS_CODE_DESC();
			}
		}
		return classDesc;
	}
	 
	 
	 /**
		 * List returning Class Lov containing code and its description
		 * 
		 * @param query
		 * @return				List<PM_IL_PROP_TREATY>
	 * @throws Exception 
		 */
	 public List<PM_IL_PROP_TREATY> classLOV(String query,Object[] object) 
	 	throws Exception{
		List<PM_IL_PROP_TREATY> classCodeList = new ArrayList<PM_IL_PROP_TREATY>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection=null;
		try{
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next()){
				PM_IL_PROP_TREATY pm_il_prop_treaty = new PM_IL_PROP_TREATY();
				pm_il_prop_treaty.setPT_CLASS_CODE(resultSet.getString(1));
				pm_il_prop_treaty.setUI_M_CLASS_CODE_DESC(resultSet.getString(2));
				classCodeList.add(pm_il_prop_treaty);
			}
		  }catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return classCodeList;
	}
	 
	 
	 /**
		 * Prepares Treaty Code List
		 * 
		 * @param treatyCode
		 * @param treatyCodeList
		 * @return					treatyCodeList
	 * @throws Exception 
		 */
	 public List prepareTreatyCodeList(String treatyCode, List treatyCodeList) throws Exception {
		String query = null;
		String displayrow=PM_IL_PROP_TREATY_CONSTANTS.
							PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN;
		try{
			if (PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SUGGESTION_BOX_GET_ALL.
									equalsIgnoreCase(treatyCode)) {
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.
								PILM015_APAC_TREATY_MASTER_SELECT_TREATY_CODE;
					Object[] object={displayrow};
					treatyCodeList = treatyLOV(query,object);
			} else {
					treatyCode=treatyCode+PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] object={treatyCode,displayrow};
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SELECT_TREATY_CODE_LIKE;
					treatyCodeList = treatyLOV(query,object);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return treatyCodeList;
	}
	
		/**
		 * Returns Treaty Description for Code and codeList
		 * 
		 * @param treatyCode
		 * @param treatyCodeList
		 * @return
		 */
	 public String getTreatyDescforCode(String treatyCode,List treatyCodeList)
	 {
		Iterator iterator = treatyCodeList.iterator();
		String treatyDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_PROP_TREATY pm_il_prop_treaty=(PM_IL_PROP_TREATY)iterator.next();
	 		if(treatyCode.equalsIgnoreCase(pm_il_prop_treaty.getPT_TREATY_CODE()))
	 		{
	 			treatyDesc = pm_il_prop_treaty.getPT_TREATY_DESC();
			}
		}
		return treatyDesc;
	}
	 
		 
		 	/**
			 * List returning Treaty Lov containing code and its description
			 * 
			 * @param query			String Query
			 * @return				List<PM_IL_PROP_TREATY>
		 	 * @throws Exception 
			 */
	 public List<PM_IL_PROP_TREATY> treatyLOV(String query,Object[] object) throws Exception
		{
		List<PM_IL_PROP_TREATY> catgCodeList = new ArrayList<PM_IL_PROP_TREATY>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection=null;
		try
			{
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_PROP_TREATY pm_il_prop_treaty = new PM_IL_PROP_TREATY();
				pm_il_prop_treaty.setPT_TREATY_CODE(resultSet.getString(1));
				pm_il_prop_treaty.setPT_TREATY_DESC(resultSet.getString(2));
				catgCodeList.add(pm_il_prop_treaty);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return catgCodeList;
	}
		 
			 
	
			 /**
				 * Prepares Currency Code List
				 * 
				 * @param currCode			String currCode
				 * @param currCodeList		List	currCodeList
				 * @return					currCodeList
			 * @throws Exception 
				 */
	 public List prepareCurrCodeList(String currCode, List currCodeList) throws Exception {
		try{
			String query = null;
			String displayrow=PM_IL_PROP_TREATY_CONSTANTS.PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN;
			if (PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_SUGGESTION_BOX_GET_ALL.equalsIgnoreCase(currCode)) {
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PIL015_APAC_PM_IL_PROP_TREATY_PT_CURR_CODE;
					Object[] object={displayrow};
					currCodeList = currLOV(query,object);

			} else {
					currCode=currCode+PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] object={currCode,displayrow};
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PIL015_APAC_PM_IL_PROP_TREATY_PT_CURR_CODE_LIKE;
					currCodeList = currLOV(query,object);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return currCodeList;
	}

				/**
				 * Returns Currency Description for Code and codeList
				 * 
				 * @param currCode			String currCode
				 * @param currCodeList		List currCodeList
				 * @return					String currDesc
				 */
	 public String getCurrDescforCode(String currCode,List currCodeList){
		Iterator iterator = currCodeList.iterator();
		String currDesc = null;
	 	while(iterator.hasNext()){
	 		PM_IL_PROP_TREATY pm_il_prop_treaty=(PM_IL_PROP_TREATY)iterator.next();
	 		if(currCode.equalsIgnoreCase(pm_il_prop_treaty.getPT_CURR_CODE())){
	 			currDesc = pm_il_prop_treaty.getUI_M_CURR_DESC();
			}
		}
		return currDesc;
	}
				 
				 
				 /**
					 * List returning Currency Lov containing code and its description
					 * 
					 * @param query				String Query
					 * @return					List<PM_IL_PROP_TREATY>
				 * @throws Exception 
					 */
	 public List<PM_IL_PROP_TREATY> currLOV(String query,Object[] object) throws Exception{
		List<PM_IL_PROP_TREATY> currCodeList = new ArrayList<PM_IL_PROP_TREATY>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection=null;
		try
			{
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_PROP_TREATY pm_il_prop_treaty = new PM_IL_PROP_TREATY();
				pm_il_prop_treaty.setPT_CURR_CODE(resultSet.getString(1));
				pm_il_prop_treaty.setUI_M_CURR_DESC(resultSet.getString(2));
				currCodeList.add(pm_il_prop_treaty);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return currCodeList;
	}
					 
		 /**
		  * PRE-INSERT for PM_IL_PROP_TREATY
		 * @throws Exception 
		  * @throws SQLException
		  * @throws Exception
		  */	
	 public  int  pilm015_apac_pm_il_prop_treaty_pre_insert() throws Exception{
        int sysId=-1;
        ResultSet resultSet=null;
        Connection connection=null;
        try{
        	connection=CommonUtils.getConnection();
            String sysIdQuery="SELECT PIL_PT_SYS_ID.NEXTVAL FROM  DUAL  ";
            Object[] object={};
            CRUDHandler handler=new CRUDHandler();
            resultSet=handler.executeSelectStatement(sysIdQuery, connection, object);
            if(resultSet.next()){
            	sysId=resultSet.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        return sysId;
    }	
		 
	 
	 public Date getTodaysDate() throws ParseException{
		 	Date date = new Date();
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			String s = df.format(date);
			Date today = df.parse(s);
			return today;
	 }
	 
		/**
		 * Pre-Insert for  PM_IL_PROP_TREATY_TYPE_CVR
		 * @return			returns PTTC_SYS_ID Double value
		 * @throws Exception 
		 * @throws SQLException
		 * @throws Exception
		 */
	 public Double pilm015_apac_pm_il_prop_treaty_type_cvr_pre_insert() throws Exception {
	       Connection connection=null;
	       CRUDHandler handler=new CRUDHandler();
	       ResultSet resultSet1=null;
	       Double PTTC_SYS_ID=null;
	        try{
	        	connection=CommonUtils.getConnection();
	            String sql_C1="SELECT PIL_PTTC_SYS_ID.NEXTVAL FROM  DUAL  ";
	            Object[] object1={};
	            resultSet1=handler.executeSelectStatement(sql_C1,connection,object1) ;
	            if(resultSet1.next()){
	            	PTTC_SYS_ID=resultSet1.getDouble(1);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	            throw new Exception(e.getMessage());
	        }
	        finally{
				try {
					CommonUtils.closeCursor(resultSet1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	        return PTTC_SYS_ID;
	    }
		 
		 /**
		  * Gets Sys Id for Treaty Type
		  * @return			PIL_PTT_SYS_ID Double value
		  * @throws SQLException
		  * @throws Exception
		  */
	 public Double getSysIdForTreatyType() throws SQLException, Exception {
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		Double sysId = null;
		ResultSet resultSet = null;
		try {
			String query = "SELECT PIL_PTT_SYS_ID.NEXTVAL FROM  DUAL ";
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getDouble(1);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;
	}
	 
		 
		 /**
			 * Prepares Cover Code List
			 * 
			 * @param coverCode
			 * @param coverCodeList
			 * @return		Lsit of List<PM_IL_PROP_TREATY_TYPE_CVR>
		 * @throws Exception 
			 */
	 public List prepareCoverCodeList(String coverCode, List coverCodeList) throws Exception {

		String query = null;
		try{
			if ("*".equalsIgnoreCase(coverCode)) {
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TTY_CVR_PTTC_COVER_CODE;
					Object[] object={PM_IL_PROP_TREATY_CONSTANTS.
							PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN};
					coverCodeList = coverLOV(query,object);
	
			} else {
					coverCode=coverCode+PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] object={coverCode,PM_IL_PROP_TREATY_CONSTANTS.
							PILM_015_APAC_TREATY_MASTER_SUGGESTION_BOX_DISPLAY_RECORDS_LESS_THEN};
					query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_TTY_CVR_PTTC_COVER_CODE_LIKE;
					coverCodeList = coverLOV(query,object);
			}
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		return coverCodeList;
	}
	
			/**
			 * Returns Cover Description for Code and codeList
			 * 
			 * @param coverCode String
			 * @param coverCodeList String
			 * @return			String Desc
			 */
		 public String getCoverDescforCode(String coverCode,List coverCodeList)
		 {
			Iterator iterator = coverCodeList.iterator();
			String coverDesc = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_PROP_TREATY_TYPE_CVR pm_il_prop_treaty_type_cvr=(PM_IL_PROP_TREATY_TYPE_CVR)iterator.next();
		 		if(coverCode.equalsIgnoreCase(pm_il_prop_treaty_type_cvr.getPTTC_COVER_CODE())){
		 			coverDesc = pm_il_prop_treaty_type_cvr.getUI_M_COVER_DESC();
				}
			}
			return coverDesc;
		}
	
			/**
			 * List returning Cover Lov containing code and its description
			 * 
			 * @param query			String 
			 * @return				List<PM_IL_PROP_TREATY_TYPE_CVR>
			 * @throws Exception 
			 */
		 public List<PM_IL_PROP_TREATY_TYPE_CVR> coverLOV(String query,Object[] object) 
		 	throws Exception {
			List<PM_IL_PROP_TREATY_TYPE_CVR> coverCodeList = new ArrayList<PM_IL_PROP_TREATY_TYPE_CVR>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection=null;
			try{
				connection=CommonUtils.getConnection();	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next()){
					PM_IL_PROP_TREATY_TYPE_CVR pm_il_prop_treaty_type_cvr = new PM_IL_PROP_TREATY_TYPE_CVR();
					pm_il_prop_treaty_type_cvr.setPTTC_COVER_CODE (resultSet.getString(1));
					pm_il_prop_treaty_type_cvr.setUI_M_COVER_DESC(resultSet.getString(2));
					coverCodeList.add(pm_il_prop_treaty_type_cvr);
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage()); 
		}
			return coverCodeList;
	}
			 /**
			  * Pre-Insert For PM_IL_PROP_TREATY_PART_CUST
			  * @return				PIL_PTPC_SYS_ID Double Value
			 * @throws Exception 
			  * @throws SQLException
			  * @throws Exception
			  */
	 public Double pilm015_apac_pm_il_prop_treaty_part_cust_pre_insert() throws Exception {
		 	ResultSet resultSet=null;
		 	Connection connection=null;
		 	CRUDHandler handler=new CRUDHandler();
		 	Double sysId = null;
	        try{
	        	connection=CommonUtils.getConnection();				            
	            String sqlQuery="SELECT PIL_PTPC_SYS_ID.NEXTVAL FROM  DUAL  ";
	            System.out.println("Sequence ID-->"+sqlQuery);
	            Object[] objects={};
	            resultSet=handler.executeSelectStatement(sqlQuery,connection,objects);
	            if(resultSet!=null){
	            	while(resultSet.next()){
	            		sysId=resultSet.getDouble(1);
	            	}
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	            throw new Exception(e.getMessage());
	        }finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {}
			}
	        return sysId;
	    }	
		 
			 
			 /**
				 * Prepares Customer Code List
				 * 
				 * @param custCode
				 * @param custCodeList
				 * @return			custCodeList
			 * @throws Exception 
				 */
	 public List prepareCustCodeList(String custCode, List custCodeList) throws Exception {
		String query = null;
		try{
			if ("*".equalsIgnoreCase(custCode)) {
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_CUST_PTPC_CUST_CODE;
				Object[] object={CommonUtils.getControlBean().getM_DIVN_CODE()};
				custCodeList = custLOV(query,object);
			} else {
				custCode=custCode+PM_IL_PROP_TREATY_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={CommonUtils.getControlBean().getM_DIVN_CODE(), custCode};
				query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_PL_IL_PROP_TREATY_TYPE_CUST_PTPC_CUST_CODE_LIKE;
				custCodeList = custLOV(query,object);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return custCodeList;
	}
	
				/**
				 * Returns Customer Description for Code and codeList
				 * 
				 * @param custCode
				 * @param custCodeList
				 * @return
				 */
	 public String getCustDescforCode(String custCode,List custCodeList){
		Iterator iterator = custCodeList.iterator();
		String custDesc = null;
	 	while(iterator.hasNext()){
	 		PM_IL_PROP_TREATY_PART_CUST  pm_il_prop_treaty_part_cust=(PM_IL_PROP_TREATY_PART_CUST)iterator.next();
	 		if(custCode.equalsIgnoreCase(pm_il_prop_treaty_part_cust.getPTPC_CUST_CODE())){
				custDesc = pm_il_prop_treaty_part_cust.getUI_M_COMP_DESC();
			}
		}
		return custDesc;
	}

				/**
				 * List returning customer Lov containing code and its description
				 * 
				 * @param connection
				 * @param query
				 * @return
				 * @throws Exception 
				 */
	 public List<PM_IL_PROP_TREATY_PART_CUST> custLOV(String query,Object[] object) throws Exception{
		List<PM_IL_PROP_TREATY_PART_CUST> custCodeList = new ArrayList<PM_IL_PROP_TREATY_PART_CUST>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection=null;
		try{
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next()){
				PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust = new PM_IL_PROP_TREATY_PART_CUST();
				pm_il_prop_treaty_part_cust.setPTPC_CUST_CODE(resultSet.getString(1));
				pm_il_prop_treaty_part_cust.setUI_M_COMP_DESC(resultSet.getString(2));
				custCodeList.add(pm_il_prop_treaty_part_cust);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return custCodeList;
	}
				 /**
				  * 
				  * @param Code
				  * @param codeList
				  * @return
				  *//*
				 public String getCodeDesc(String Code, List codeList) {
						Iterator iterator = codeList.iterator();
						String codedesc = null;
						while (iterator.hasNext()) {
							PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = (PM_IL_MED_EXAM_DTL) iterator
									.next();
							if (Code.equalsIgnoreCase(pm_il_med_exam_dtl.getMED_EXAM_CODE())) {
								codedesc = pm_il_med_exam_dtl.getUI_M_MED_EXAM_CODE_DESC();
							}
						}
						return codedesc;
					}*/
	 
	 /*added by raja on 04-07-2017*/
	 public void getRateDetails(PM_IL_PROP_TREATY_PART_CUST_ACTION Action)
				throws Exception {
			new PM_IL_PROP_TREATY_DELEGATE()
			.executeSelectStatement(Action);

			List<PM_IL_PROP_TREATY_CUST_COMM> dataList = Action.getDataList_PM_IL_PROP_TREATY_CUST_COMM();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROP_TREATY_CUST_COMM PM_IL_PROP_TREATY_CUST_COMM_BEAN = dataList.get(0);
				PM_IL_PROP_TREATY_CUST_COMM_BEAN.setRowSelected(true);
				Action.setPM_IL_PROP_TREATY_CUST_COMM_BEAN(PM_IL_PROP_TREATY_CUST_COMM_BEAN);
			}
			else
			{
				Action.setPM_IL_PROP_TREATY_CUST_COMM_BEAN(new PM_IL_PROP_TREATY_CUST_COMM());
			}
		}
	 
	 /*end*/
}
