package com.iii.pel.forms.PILP002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT017.PILT017_QUERY_CONSTANTS;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_DB_CLASS {


	public Object fetchPaymentDtls(String sysId, Object obj) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		PT_IL_PYMT_DTLS beanClass = (PT_IL_PYMT_DTLS) obj;
		try {
			String query = "SELECT PD_SR_NO,PD_PAY_MODE,PD_DPD_REF_ID,"
				+ " PD_FC_AMT, PD_LC_AMT,PD_PAID_FOR,PD_CHQ_NO,"
				+ "PD_CHQ_DT,PD_CC_TYPE,PD_CC_NO,PD_CC_NAME, PD_CC_APP_CODE,"
				+ "PD_TT_REF_NO,PD_TT_CURR_CODE,"
				+ "PD_REM_SLIP_GEN_YN,PD_PO_MO_NO,PD_PO_MO_DT,"
				+ "PD_REM_AMT,PD_BANK_REF_NO,PD_ATM_CARD_NO FROM PT_IL_PYMT_DTLS WHERE PD_SYS_ID='" + sysId + "'";
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				beanClass.setPD_SR_NO(resultSet.getInt(1));
				beanClass.setPD_PAY_MODE(resultSet.getString(2));
				beanClass.setPD_DPD_REF_ID(resultSet.getString(3));
				beanClass.setPD_FC_AMT(resultSet.getDouble(4));
				beanClass.setPD_LC_AMT(resultSet.getDouble(5));
				beanClass.setPD_CHQ_NO(resultSet.getString(6));
				beanClass.setPD_CHQ_DT(resultSet.getDate(7));
				beanClass.setPD_CC_TYPE(resultSet.getString(8));
				beanClass.setPD_CC_NO(resultSet.getString(9));
				beanClass.setPD_CC_NAME(resultSet.getString(10));
				beanClass.setPD_CC_APP_CODE(resultSet.getString(11));
				beanClass.setPD_DATE_OF_CREDIT(resultSet.getDate(12));
				beanClass.setPD_TT_REF_NO(resultSet.getString(13));
				beanClass.setPD_TT_CURR_CODE(resultSet.getString(14));
				beanClass.setPD_REM_SLIP_GEN_YN(resultSet.getString(15));
				beanClass.setPD_PO_MO_NO(resultSet.getString(16));
				beanClass.setPD_PO_MO_DT(resultSet.getDate(17));
				beanClass.setPD_REM_AMT(resultSet.getDouble(18));
				beanClass.setPD_BANK_REF_NO(resultSet.getString(19));
				beanClass.setPD_ATM_CARD_NO(resultSet.getString(20));

			}
			System.out.println("DB FetchPymtDtls   "+beanClass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanClass;
	}

	public ArrayList<PT_IL_PYMT_DTLS> fetchValues(String paymentTransactionType,String paymentTransactionSysid){
		ArrayList<PT_IL_PYMT_DTLS> detailList = null;
		PT_IL_PYMT_DTLS listBean = null;
		String bankDesc = "";
		String currencyDesc = "";
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_FETCH_QUERY;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				detailList = new ArrayList<PT_IL_PYMT_DTLS>(); 
				
				//newly added
				String sysId = CommonUtils.getGlobalVariable("GLOBAL.SYS_ID");
				Object[] values = { paymentTransactionType , paymentTransactionSysid };
				System.out.println("Query::"+selectQuery+"  "+paymentTransactionType+"  "+paymentTransactionSysid);
				rst = handler.executeSelectStatement(selectQuery, con, values);
				while(rst.next()){
					listBean = new PT_IL_PYMT_DTLS();
					
					listBean.setROWID(rst.getString(1));
					listBean.setPD_SYS_ID(rst.getLong("PD_SYS_ID"));                                           
					listBean.setPD_SR_NO(rst.getInt("PD_SR_NO"));                                             
					listBean.setPD_TXN_TYPE(rst.getString("PD_TXN_TYPE"));                                       
					listBean.setPD_TXN_SYS_ID(rst.getLong("PD_TXN_SYS_ID"));                                   
					listBean.setPD_PAY_MODE(rst.getString("PD_PAY_MODE"));                                       
					listBean.setPD_CURR_CODE(rst.getString("PD_CURR_CODE"));
							currencyDesc = getCurrencyDesc(rst.getString("PD_CURR_CODE"));
							listBean.setUI_M_PD_CURR_CODE_DESC(currencyDesc);
					listBean.setPD_FC_AMT(rst.getDouble("PD_FC_AMT"));                                           
					listBean.setPD_LC_AMT(rst.getDouble("PD_LC_AMT"));                                           
					listBean.setPD_CHQ_NO(rst.getString("PD_CHQ_NO"));                                           
					listBean.setPD_CHQ_DT(rst.getDate("PD_CHQ_DT"));                                             
					listBean.setPD_BANK_NAME(rst.getString("PD_BANK_NAME"));
							bankDesc = getBankDesc(rst.getString("PD_BANK_NAME"));
							listBean.setUI_M_BANK_NAME_DESC(bankDesc);
					listBean.setPD_BRANCH_NAME(rst.getString("PD_BRANCH_NAME"));                                 
					listBean.setPD_CC_NO(rst.getString("PD_CC_NO"));                                             
					listBean.setPD_CC_NAME(rst.getString("PD_CC_NAME"));                                         
					listBean.setPD_CC_EXP_DT(rst.getDate("PD_CC_EXP_DT"));                                       
					listBean.setPD_CC_TYPE(rst.getString("PD_CC_TYPE"));                                         
					listBean.setPD_CUST_NAME(rst.getString("PD_CUST_NAME"));                                     
					listBean.setPD_ADDR_01(rst.getString("PD_ADDR_01"));                                         
					listBean.setPD_ADDR_02(rst.getString("PD_ADDR_02"));                                         
					listBean.setPD_ADDR_03(rst.getString("PD_ADDR_03"));                                         
					listBean.setPD_REMARKS(rst.getString("PD_REMARKS"));                                         
					listBean.setPD_CR_UID(rst.getString("PD_CR_UID"));                                           
					listBean.setPD_CR_DT(rst.getDate("PD_CR_DT"));                                               
					listBean.setPD_UPD_UID(rst.getString("PD_UPD_UID"));                                         
					listBean.setPD_UPD_DT(rst.getDate("PD_UPD_DT"));                                             
					listBean.setPD_DPD_REF_ID(rst.getString("PD_DPD_REF_ID"));                                   
					listBean.setPD_REV_YN(rst.getString("PD_REV_YN"));                                           
					listBean.setPD_LC_CHARGE(rst.getDouble("PD_LC_CHARGE"));                                     
					listBean.setPD_FC_CHARGE(rst.getDouble("PD_FC_CHARGE"));                                     
					listBean.setPD_PAID_FOR(rst.getString("PD_PAID_FOR"));                                       
					listBean.setPD_CC_APP_CODE(rst.getString("PD_CC_APP_CODE"));                                 
					listBean.setPD_PAYIN_DATE(rst.getDate("PD_PAYIN_DATE"));                                     
					listBean.setPD_OUR_BANK_CODE(rst.getString("PD_OUR_BANK_CODE"));                             
					listBean.setPD_DATE_OF_CREDIT(rst.getDate("PD_DATE_OF_CREDIT"));                             
					listBean.setPD_TT_REF_NO(rst.getString("PD_TT_REF_NO"));                                     
					listBean.setPD_TT_CURR_CODE(rst.getString("PD_TT_CURR_CODE"));                               
					listBean.setPD_REM_SLIP_GEN_YN(rst.getString("PD_REM_SLIP_GEN_YN"));                         
					listBean.setPD_PO_MO_NO(rst.getString("PD_PO_MO_NO"));                                       
					listBean.setPD_PO_MO_DT(rst.getDate("PD_PO_MO_DT"));                                         
					listBean.setPD_REM_AMT(rst.getDouble("PD_REM_AMT"));                                         
					listBean.setPD_BANK_REF_NO(rst.getString("PD_BANK_REF_NO"));                                 
					listBean.setPD_CR_ADVICE_NO(rst.getString("PD_CR_ADVICE_NO"));                               
					listBean.setPD_ATM_CARD_NO(rst.getString("PD_ATM_CARD_NO"));
					
					detailList.add(listBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailList;
	}
	
	public ArrayList<PT_IL_PYMT_DTLS> fetchList(
			PT_IL_PYMT_DTLS_ACTION pymtDetail) {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		ArrayList<PT_IL_PYMT_DTLS> payModes = new ArrayList<PT_IL_PYMT_DTLS>();

		try {
			connection = CommonUtils.getConnection();

			String query = "SELECT  PD_SYS_ID, PD_PAY_MODE,PD_CUST_NAME ,ROWID FROM PT_IL_PYMT_DTLS";
			if (pymtDetail.getPayMode() != null
					&& pymtDetail.getPayMode().trim().length() > 0) {
				query = query + " WHERE UPPER(PD_PAY_MODE) LIKE " + "'"
				+ pymtDetail.getPayMode().toUpperCase() + "%'";
			}
			resultSet = handler.executeSelectStatement(query, connection);
			if (resultSet != null) {
				System.out.println("RESULT_SET     " + resultSet);
				while (resultSet.next()) {
					PT_IL_PYMT_DTLS beanClass = new PT_IL_PYMT_DTLS();
					beanClass.setPD_SYS_ID(resultSet.getLong(1));
					beanClass.setPD_PAY_MODE(resultSet.getString(2));
					beanClass.setPD_CUST_NAME(resultSet.getString(3));
					beanClass.setROWID(resultSet.getString(4));
					payModes.add(beanClass);
				}
				System.out.println("tHE VALYELJH" + payModes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return payModes;
	}


	public List currCodeLov(String currCode){

		CRUDHandler handler = new CRUDHandler();
		List list=null;
		ResultSet resultSet=null;
		String query=null;
		Connection connection = null;
		try 
		{
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			if("*".equalsIgnoreCase(currCode))
			{
				/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_CURRENCY to FM_CURRENCY. Added by : Mallika.S, 01-Apr-2009 */
				query = "SELECT CURR_CODE,CURR_NAME FROM FM_CURRENCY ";
			}
			else
			{
				query = "SELECT CURR_CODE, CURR_NAME FROM FM_CURRENCY WHERE CURR_CODE LIKE '"+currCode+"%'";
			}

			System.out.println("CURR_QUERY" + query);
			resultSet=handler.executeSelectStatement(query,connection);
			while(resultSet.next())
			{
				PT_IL_PYMT_DTLS dtlBean=new PT_IL_PYMT_DTLS();
				dtlBean.setPD_CURR_CODE(resultSet.getString(1));
				dtlBean.setUI_M_PD_CURR_CODE_DESC(resultSet.getString(2));
				list.add(dtlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	public String currDetails(String currCode, List lovCurrCodeList) {
		String currDesc = null;
		Iterator iterator= lovCurrCodeList.iterator();
		while(iterator.hasNext()){
			PT_IL_PYMT_DTLS pymtDtl=(PT_IL_PYMT_DTLS)iterator.next();
			if(pymtDtl.getPD_CURR_CODE().equalsIgnoreCase(currCode))
			{
				currDesc=pymtDtl.getUI_M_PD_CURR_CODE_DESC();
			}
		}

		return currDesc;
	}

	public String[] bankDetails(String refId,List bankNameList)
	{
		String bankDetails[] =new String[2];
		Iterator iterator=bankNameList.iterator();
		while(iterator.hasNext())
		{
			PT_IL_PYMT_DTLS pymtDtl=(PT_IL_PYMT_DTLS)iterator.next();

			if(pymtDtl.getPD_DPD_REF_ID().equalsIgnoreCase(refId))
			{
				bankDetails[0]=pymtDtl.getPD_BANK_NAME();
				bankDetails[1]=pymtDtl.getUI_M_BANK_NAME_DESC();
			}

		}
		return bankDetails;
	}
	public List bankNameLov(String refId){

		CRUDHandler handler = new CRUDHandler();
		List list=null;
		ResultSet resultSet=null;
		Connection connection = null;
		String query=null;
		try 
		{
			list = new ArrayList();
			connection = CommonUtils.getConnection();

			if("*".equalsIgnoreCase(refId))
			{
				query="SELECT DISTINCT(PD_DPD_REF_ID), PT_IL_PYMT_DTLS.PD_BANK_NAME,FM_BANK.BANK_NAME FROM PT_IL_PYMT_DTLS, FM_BANK ";
			}

			else{
				query = "SELECT DISTINCT(PD_DPD_REF_ID), " +
				"PT_IL_PYMT_DTLS.PD_BANK_NAME," +
				"FM_BANK.BANK_NAME " +
				"FROM PT_IL_PYMT_DTLS, FM_BANK WHERE PT_IL_PYMT_DTLS.PD_BANK_NAME = FM_BANK.BANK_CODE AND " +
				"PD_DPD_REF_ID LIKE '"+ refId.toUpperCase()+"%'";
			}
			resultSet=handler.executeSelectStatement(query,connection);
			while(resultSet.next())
			{
				PT_IL_PYMT_DTLS dtlBean=new PT_IL_PYMT_DTLS();
				dtlBean.setPD_DPD_REF_ID(resultSet.getString(1));
				dtlBean.setPD_BANK_NAME(resultSet.getString(2));
				dtlBean.setUI_M_BANK_NAME_DESC(resultSet.getString(3));
				list.add(dtlBean);
			}

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int updateData(PT_IL_PYMT_DTLS pymtDtlBean) throws Exception{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			System.out.println("ID:::::::::::"+pymtDtlBean.getPD_DPD_REF_ID());
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pymtDtlBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public Long saveData(PT_IL_PYMT_DTLS_ACTION pymtDtlAction)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_PYMT_DTLS> valueBeanList = null;
		Long sysId=null;
		try {
			connection = CommonUtils.getConnection();
			valueBeanList = pymtDtlAction.getDataTableList();
			  sysId=pymtDtlAction.pilt017_pt_il_pymt_dtls_pre_insert();
			for(int index = 0;index<valueBeanList.size(); index++)
			{

				PT_IL_PYMT_DTLS pymtValueBean = (PT_IL_PYMT_DTLS)valueBeanList.get(index);
				pymtValueBean.setPD_SYS_ID(sysId);
				handler.executeInsert(pymtValueBean, connection);
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return sysId;
	}


	public int deleteData(PT_IL_PYMT_DTLS pymtDtlBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pymtDtlBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	public ArrayList P_VAL_SYSTEM(String P_TYPE, String P_CODE, String FLAG)
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",P_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",P_CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT","1");
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", FLAG);
		OracleParameter param5 = new OracleParameter("inout2","INT","IN OUT","1");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			connection = CommonUtils.getConnection();

			outputList = procHandler.execute(parameterList, connection, "P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"+oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return returnList;
	}
	

	public int updatePaymentDetails(PT_IL_PYMT_DTLS paymentDetailBean) {
		int rowCount = 0;
		Connection con = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rowCount = handler.executeInsert(paymentDetailBean, con);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public List getLovForPdRefId(Object string) {
		String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_PD_DPD_REF_ID_LOV;
		ArrayList<PT_IL_PYMT_DTLS> lovConditionList = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		PT_IL_PYMT_DTLS lovBean = null;
		if ("*".equals(string)) {
			selectQuery = selectQuery.replace("{0}", "");
		}else{
			selectQuery = selectQuery.replace("{0}", " PD_DPD_REF_ID LIKE '"+string+"%' AND ");
		}
		try {
			con = CommonUtils.getConnection();
			lovConditionList = new ArrayList<PT_IL_PYMT_DTLS>();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
					lovBean = new PT_IL_PYMT_DTLS();
						lovBean.setPD_DPD_REF_ID(rst.getString("PD_DPD_REF_ID"));	
						lovBean.setPD_BANK_NAME(rst.getString("BANK_NAME"));
					lovConditionList.add(lovBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovConditionList;
	}
	
	public List getLovBankName(Object string) {
		String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_PD_BANK_NAME_LOV;
		ArrayList<PT_IL_PYMT_DTLS> lovConditionList = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		PT_IL_PYMT_DTLS lovBean = null;
		if ("*".equals(string)) {
			selectQuery = selectQuery.replace("{0}", "");
		}else{
			selectQuery = selectQuery.replace("{0}", " WHERE BANK_CODE LIKE '"+string+"%'");
		}
		try {
			con = CommonUtils.getConnection();
			lovConditionList = new ArrayList<PT_IL_PYMT_DTLS>();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
					lovBean = new PT_IL_PYMT_DTLS();
						lovBean.setPD_BANK_NAME(rst.getString("BANK_CODE"));	
						lovBean.setUI_M_BANK_NAME_DESC(rst.getString("BANK_NAME"));
					lovConditionList.add(lovBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
		return lovConditionList;
	}
	public List getLovBranchName(Object string,String currId) {
		String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_PD_BRANCH_NAME_LOV;
		ArrayList<PT_IL_PYMT_DTLS> lovConditionList = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		PT_IL_PYMT_DTLS lovBean = null;
		if ("*".equals(string)) {
			selectQuery = selectQuery.replace("?{0}", "'"+currId+"' ");
			System.out.println(selectQuery);
		}else{
			selectQuery = selectQuery.replace("?{0}", " '"+currId+"' AND DPD_BRANCH_NAME LIKE '"+string+"%'");
			System.out.println(selectQuery);
		}
		try {
			con = CommonUtils.getConnection();
			lovConditionList = new ArrayList<PT_IL_PYMT_DTLS>();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
					lovBean = new PT_IL_PYMT_DTLS();
						lovBean.setPD_BRANCH_NAME(rst.getString("DPD_BRANCH_NAME"));
						lovBean.setPD_BANK_NAME(rst.getString("DPD_BANK_NAME"));	
						lovBean.setPD_CURR_CODE(rst.getString("DPD_REF_ID"));
					lovConditionList.add(lovBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovConditionList;
	}
	public String getBankDesc(String bankCode){
		String assignDescValue="";
		String selectQuery=PILT017_QUERY_CONSTANTS.PILT017_FIND_BANK_DESC;
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = { bankCode };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					assignDescValue = rst.getString(1);
					if (assignDescValue == null) {
						assignDescValue = "";
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignDescValue;
	}
	public String getCurrencyDesc(String currencyCode){
		String assignCurrencyValue="";
		String selectQuery=PILT017_QUERY_CONSTANTS.PILT017_FIND_CURRENCY_DESC;
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = { currencyCode };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					assignCurrencyValue = rst.getString(1);
					if (assignCurrencyValue == null) {
						assignCurrencyValue = "";
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assignCurrencyValue;
	}
	
	public boolean isRecordCcheck(String paymentTransactionType, String paymentTransactionSysid){
		boolean isCheck = false;
		String selectQuery = PILT017_QUERY_CONSTANTS.PILT017_PT_IL_PYMT_DTLS_RECORD_CHECK;
		ResultSet rst = null;
		CRUDHandler handler = null;
		Connection con = null;
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		try {
			con = CommonUtils.getConnection();
			String sysId = CommonUtils.getGlobalVariable("GLOBAL.SYS_ID");
			System.out.println("SYS ID****************************************"+paymentTransactionSysid);
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values={  paymentTransactionType,paymentTransactionSysid };
				System.out.println("rECORD CHECK QUERY::::::::"+selectQuery+" "+paymentTransactionType+"  "+sysId);
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					isCheck = true;
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {	
				e.printStackTrace();
			}
		}
		return isCheck;
	}
	
}
