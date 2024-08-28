package com.iii.pel.forms.PILM016_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CONTRACTOR_ACTION_VALIDATION {

	/**
	 * Check whether the Code exists or not
	 * 
	 * @param connection1
	 * @param submittedValue
	 * @return
	 * @throws Exception 
	 */
	public void uniqueCode( PM_IL_CONTRACTOR contractorBean) throws Exception {
		boolean flag = false;
		ResultSet resultSet = null;
		try {
			
			Connection connection = CommonUtils.getConnection();
			CRUDHandler dbHandler = new CRUDHandler();
			String selectQuery = "SELECT 'X',ROWID FROM  PM_IL_CONTRACTOR  WHERE  CONT_CODE  =  ? ";
			resultSet = dbHandler.executeSelectStatement(selectQuery, connection , new Object[]{contractorBean.getCONT_CODE()});
			if (resultSet.next()) {
				if (contractorBean.getROWID() == null) {
					if (resultSet.getString("ROWID") != null) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71026"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
						
			
				
		

	}

	public boolean nullValue(String bankName, String accountNo) {
		boolean flag = false;
		if (bankName != null) {
			if (accountNo == null || accountNo == "") {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean dateValidator(Date fromDate, Date toDate) {
		boolean flag = false;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			System.out
					.println("PM_IL_CONTRACTOR_ACTION_VALIDATION.dateValidator()"
							+ fromDate);
			System.out
					.println("PM_IL_CONTRACTOR_ACTION_VALIDATION.dateValidator()"
							+ toDate);
           // if(!fromDate.equals(""))
           // {
			//Date from_Date = formatter.parse(fromDate);
         
			
			
			if (fromDate.before(toDate))
			{
				flag = true;
				System.out.println("ENTERED IF ");
			} else {
				flag = false;
				System.out.println("ENTERED ELSE ");
			}
            //}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public List isExist(Connection connection, String ICNumber) {

		boolean flag = false;
		List list = new ArrayList();
		try {
			CRUDHandler dbHandler = new CRUDHandler();
			String selectQuery = "SELECT 'X',CONT_NAME, CONT_ADDR1, CONT_ADDR2, CONT_ADDR3, CONT_CONTACT,"
					+ " CONT_PHONE, CONT_FAX,CONT_REMARKS, CONT_DFLT_YN, CONT_CUST_CODE, CONT_FRZ_FLAG, CONT_BL_NAME,"
					+ " CONT_BL_ADDR1,CONT_BL_ADDR2, CONT_BL_ADDR3, CONT_BL_CONTACT,CONT_EMPLOYER_YN,CONT_EFF_FM_DT,"
					+ " CONT_EFF_TO_DT,CONT_REF_NO, CONT_REF_ID1, CONT_REF_ID2,CONT_TEL_AREA_CODE, CONT_MOBILE_NO,"
					+ " CONT_FAX_AREA_CODE,CONT_PREFERRED_LANG, CONT_EMAIL_ID, CONT_POSTAL_CODE,CONT_CITY, "
					+ "CONT_STATE_CODE, CONT_DOB, CONT_BIRTH_CERT_NO,CONT_CATG_CODE, CONT_MAR_STATUS, "
					+ "CONT_NATIONALITY_CODE,CONT_RACE, CONT_RELIGION, CONT_AREA, CONT_REGION,CONT_AD_BANK_CODE,"
					+ "CONT_AD_ACC_NO,CONT_CITY_CODE,CONT_COUNT_CODE,CONT_COUNTRY FROM PM_IL_CONTRACTOR WHERE "
					+ "CONT_REF_ID1  = '" + ICNumber + "'";
			list = dbHandler.fetch(selectQuery,
					"com.iii.pel.forms.PILM016_APAC.PM_IL_CONTRACTOR",
					connection);
			/*
			 * if(!list.isEmpty()) { flag = true;
			 *  }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getNationalityCode(Connection connection) {
		String code = null;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = null;
			resultSet = statement
					.executeQuery("SELECT PC_CODE FROM  PM_CODES  WHERE  PC_TYPE  = 'NATLITY'  AND PC_VALUE  = 1");
			if (resultSet.next()) {
				code = resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;

	}

	public String loadBankName(Connection connection, String bankCode) {
		String bankName = null;
		try {

			Statement statement = connection.createStatement();
			ResultSet resultSet = null;
			resultSet = statement
					.executeQuery("SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE ='"
							+ bankCode + "'");
			if (resultSet.next()) {
				bankName = resultSet.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankName;
	}

	public String P_VAL_CODES(Connection connection, String CODE_TYPE,
			String CODE) {
		ArrayList parameterList = new ArrayList();
		ArrayList outputList = new ArrayList();
		String output = null;
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				CODE_TYPE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				CODE);
		OracleParameter param3 = new OracleParameter("inout1", "STRING",
				"IN OUT", "1");
		OracleParameter param4 = new OracleParameter("in3", "STRING", "IN", "N");
		OracleParameter param5 = new OracleParameter("in4", "STRING", "IN", "N");
		OracleParameter param6 = new OracleParameter("in5", "STRING", "IN",
				null);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out
						.println("Output value:" + oracleParameter.getValue());
				output = oracleParameter.getValue();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return output;
	}

	public ArrayList P_VAL_SYSTEM(Connection connection, String P_TYPE,
			String P_CODE, String FLAG) {
		ArrayList parameterList = new ArrayList();
		ArrayList outputList = new ArrayList();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_TYPE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_CODE);
		OracleParameter param3 = new OracleParameter("inout1", "STRING",
				"IN OUT", "1");
		OracleParameter param4 = new OracleParameter("in3", "STRING", "IN", "N");
		OracleParameter param5 = new OracleParameter("inout2", "INT", "IN OUT",
				"1");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_SYSTEM");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				if (oracleParameter.getValue() != null) {
					returnList.add(oracleParameter.getValue());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return returnList;
	}

	/**
	 * Migrating function for NVL
	 */
	

	/**
	 * Procedure P9ILPR_GEN_CHECK_DIGIT
	 * 
	 * @param connection
	 * @param P_CUST_CODE
	 * @param m_seq_chk
	 * @return
	 */
	public ArrayList P9ILPR_GEN_CHECK_DIGIT(Connection connection,
			String P_CUST_CODE, double m_seq_chk) {
		ArrayList procedureParameterList = new ArrayList();
		ArrayList outputList = new ArrayList();
		ArrayList returnList = new ArrayList();
		OracleParameter param1 = new OracleParameter("inPCustCode", "String",
				"IN", P_CUST_CODE);
		OracleParameter param2 = new OracleParameter("inMSeqChk", "String",
				"OUT", m_seq_chk + "");
		procedureParameterList.add(param1);
		procedureParameterList.add(param2);
		OracleProcedureHandler procedureHandler = new OracleProcedureHandler();
		try {

			outputList = procedureHandler.execute(procedureParameterList,
					connection, "P9ILPR_GEN_CHECK_DIGIT");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				if (oracleParameter.getValue() != null) {
					returnList.add(oracleParameter.getValue());
					System.out.println("Parameter M_SEQ_CHK :"
							+ returnList.get(1).toString());
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return returnList;

	}

	/**
	 * Prepares Martial Status Code List
	 * 
	 * @param connection
	 * @param marStatusCode
	 * @param marStatusCodeList
	 * @return
	 */
	 public List prepareMarStatusCodeList(Connection connection,String marStatusCode, List marStatusCodeList) {

		String query = null;
			
		if ("*".equalsIgnoreCase(marStatusCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_MART_STAT_CODE_LIST;
				Object[] object={};
				marStatusCodeList = marSatusLOV(connection, query,object);
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_MART_STAT_CODE_LIST_LIKE;
				marStatusCode=marStatusCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={marStatusCode,marStatusCode};
				marStatusCodeList = marSatusLOV(connection, query,object);

		}
		return marStatusCodeList;
	}

	/**
	 * Returns MartialStatus Description for Code and codeList
	 * 
	 * @param marStatusCode
	 * @param marStatusCodeList
	 * @return
	 */
	 public String getMarStatusDescforCode(String marStatusCode,List marStatusCodeList){
		Iterator iterator = marStatusCodeList.iterator();
				String marStatusDesc = null;
	 	while(iterator.hasNext()){
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
	 		if(marStatusCode.equalsIgnoreCase(pm_il_contractor.getCONT_MAR_STATUS())){
				marStatusDesc = pm_il_contractor.getUI_M_CONT_MAR_STATUS_DESC();
			}
		}
		return marStatusDesc;
	}

	/**
	 * 
	 * List returning Martial Status Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> marSatusLOV(Connection connection,String query,Object[] object){
		List<PM_IL_CONTRACTOR> marStatusCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next()){
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_MAR_STATUS(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_MAR_STATUS_DESC(resultSet.getString(2));
				marStatusCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return marStatusCodeList;
	}

	/**
	 * Prepares Category Code List
	 * 
	 * @param connection
	 * @param catgCode
	 * @param catgCodeList
	 * @return
	 */
	 public List prepareCatgCodeList(Connection connection,String catgCode, List catgCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(catgCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_CATG_CODE_LIST;
				Object[] object={};
				catgCodeList = catgLOV(connection, query,object);

		} else {
				catgCode=catgCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={catgCode,catgCode};
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_CATG_CODE_LIST_LIKE;
				catgCodeList = catgLOV(connection, query,object);
		}
		return catgCodeList;
	}

	/**
	 * Returns Category Description for Code and codeList
	 * 
	 * @param catgCode
	 * @param catgCodeList
	 * @return
	 */
	 public String getCatgDescforCode(String catgCode,List catgCodeList)
	 {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(catgCode.equalsIgnoreCase(pm_il_contractor.getCONT_CATG_CODE()))
	 		{
				catgDesc = pm_il_contractor.getUI_M_CONT_CATG_CODE_DESC();
			}
		}
		return catgDesc;
	}

	/**
	 * List returning Category Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> catgLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> catgCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_CATG_CODE(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_CATG_CODE_DESC(resultSet.getString(2));
				catgCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return catgCodeList;
	}

	/**
	 * Prepares State Code List
	 * 
	 * @param connection
	 * @param stateCode
	 * @param stateCodeList
	 * @return
	 */
	 public List prepareStateCodeList(Connection connection,String stateCode, List stateCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(stateCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_STATE_CODE_LIST;
				Object[] object={};
				stateCodeList = stateLOV(connection, query,object);
				
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_STATE_CODE_LIST_LIKE;
				stateCode=stateCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={stateCode,stateCode};
				stateCodeList = stateLOV(connection, query,object);
		}
		return stateCodeList;
	}

	/**
	 * Returns State Description for Code and codeList
	 * 
	 * @param stateCode
	 * @param stateCodeList
	 * @return
	 */
	 public String getStateDescforCode(String stateCode,List stateCodeList)
	 {
		Iterator iterator = stateCodeList.iterator();
		String cityDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(stateCode.equalsIgnoreCase(pm_il_contractor.getCONT_STATE_CODE()))
	 		{
				cityDesc = pm_il_contractor.getCONT_STATE();
			}
		}
		return cityDesc;
	}

	/**
	 * List returning State Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> stateLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> stateCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_STATE_CODE(resultSet.getString(1));
				pm_il_contractor.setCONT_STATE(resultSet.getString(2));
				stateCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return stateCodeList;
	}

	/**
	 * Prepares City Code List
	 * 
	 * @param connection
	 * @param cityCode
	 * @param cityCodeList
	 * @return
	 */
	 public List prepareCityCodeList(Connection connection,String cityCode, List cityCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(cityCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_CITY_CODE_LIST;
				Object[] object={};
				cityCodeList = cityLOV(connection, query,object);
				
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_CITY_CODE_LIST_LIKE;
				cityCode=cityCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={cityCode,cityCode};
				cityCodeList = cityLOV(connection, query,object);
		}
		return cityCodeList;
	}

	/**
	 * Returns City Description for Code and codeList
	 * 
	 * @param cityCode
	 * @param cityCodeList
	 * @return
	 */
	 public String getCityDescforCode(String cityCode,List cityCodeList){
		Iterator iterator = cityCodeList.iterator();
		String cityDesc = null;
	 	while(iterator.hasNext()){
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
	 		if(cityCode.equalsIgnoreCase(pm_il_contractor.getCONT_CITY_CODE())){
	 			cityDesc = pm_il_contractor.getCONT_CITY();
	 		}
	 	}
	 	
			
		return cityDesc;
	}

	/**
	 * List returning City Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> cityLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> cityCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_CITY_CODE(resultSet.getString(1));
				pm_il_contractor.setCONT_CITY(resultSet.getString(2));
				cityCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return cityCodeList;
	}
	 

	/**
	 * Prepares Religion Code List
	 * 
	 * @param connection
	 * @param relegionCode
	 * @param relegionCodeList
	 * @return
	 */
	 public List prepareRelegionCodeList(Connection connection,String relegionCode, List relegionCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(relegionCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_RELEGION_CODE_LIST;
				Object[] object={};
				relegionCodeList = relegionLOV(connection, query,object);
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_RELEGION_CODE_LIST_LIKE;
				relegionCode=relegionCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={relegionCode,relegionCode};
				relegionCodeList = relegionLOV(connection, query,object);
		}
		return relegionCodeList;
	}

	/**
	 * Returns Relegion Description for Code and codeList
	 * 
	 * @param relegionCode
	 * @param relegionCodeList
	 * @return
	 */
	 public String getRelegionDescforCode(String relegionCode,List relegionCodeList)
	 {
		Iterator iterator = relegionCodeList.iterator();
		String relegionDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(relegionCode.equalsIgnoreCase(pm_il_contractor.getCONT_RELIGION()))
	 		{
				relegionDesc = pm_il_contractor.getUI_M_CONT_RELIGION_DESC();
			}
		}
		return relegionDesc;
	}

	/**
	 * List returning Relegion Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> relegionLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> relegionCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_RELIGION(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_RELIGION_DESC(resultSet.getString(2));
				relegionCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return relegionCodeList;
	}

	/**
	 * Prepare Race code List
	 * 
	 * @param connection
	 * @param raceCode
	 * @param raceCodeList
	 * @return
	 */
	 public List prepareRaceCodeList(Connection connection,String raceCode, List raceCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(raceCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_RACE_CODE_LIST;
				Object[] object={};
				raceCodeList = raceLOV(connection, query,object);
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_RACE_CODE_LIST_LIKE;
				raceCode=raceCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={raceCode,raceCode};
				raceCodeList = raceLOV(connection, query,object);
		}
		return raceCodeList;
	}

	/**
	 * Returns Race Description for Code and codeList
	 * 
	 * @param raceCode
	 * @param raceCodeList
	 * @return
	 */
	 public String getRaceDescforCode(String raceCode,List raceCodeList)
	 {
		Iterator iterator = raceCodeList.iterator();
		String raceDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(raceCode.equalsIgnoreCase(pm_il_contractor.getCONT_RACE()))
	 		{
				raceDesc = pm_il_contractor.getUI_M_CONT_RACE_DESC();
			}
		}
		return raceDesc;
	}

	/**
	 * List returning Race Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> raceLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> raceCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_RACE(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_RACE_DESC(resultSet.getString(2));
				raceCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return raceCodeList;
	}

	/**
	 * Prepares Country Code List
	 * 
	 * @param connection
	 * @param countryCode
	 * @param countryCodeList
	 * @return
	 */
	 public List prepareCountryCodeList(Connection connection,String countryCode, List countryCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(countryCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_COUNTRY_CODE_LIST;
				Object[] object={};
				countryCodeList = countryLOV(connection, query,object);
				
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_COUNTRY_CODE_LIST_LIKE;
				countryCode=countryCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={countryCode,countryCode};
				countryCodeList = countryLOV(connection, query,object);
		}
		return countryCodeList;
	}

	/**
	 * Returns Country Description for Code and codeList
	 * 
	 * @param countryCode
	 * @param countryCodeList
	 * @return
	 */
	 public String getCountryDescforCode(String countryCode,List countryCodeList)
	 {
		Iterator iterator = countryCodeList.iterator();
		String countryDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(countryCode.equalsIgnoreCase(pm_il_contractor.getCONT_COUNT_CODE()))
	 		{
				countryDesc = pm_il_contractor.getCONT_COUNTRY();
			}
		}
		return countryDesc;
	}

	/**
	 * List returning Country Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> countryLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> countryCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_COUNT_CODE(resultSet.getString(1));
				pm_il_contractor.setCONT_COUNTRY(resultSet.getString(2));
				countryCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return countryCodeList;
	}

	/**
	 * Prepares Receipt Bank Code List
	 * 
	 * @param connection
	 * @param receiptBankCode
	 * @param receiptBankCodeList
	 * @return
	 */
	 public List prepareReceiptBankCodeList(Connection connection,String receiptBankCode, List receiptBankCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(receiptBankCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_BANK_CODE_LIST;
				Object[] object={};
				receiptBankCodeList = receiptBankLOV(connection, query,object);
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_BANK_CODE_LIST_LIKE;
				receiptBankCode=receiptBankCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={receiptBankCode,receiptBankCode};
				receiptBankCodeList = receiptBankLOV(connection, query,object);
		}
		return receiptBankCodeList;
	}

	/**
	 * Returns Receipt Bank Description for Code and codeList
	 * 
	 * @param receiptBankCode
	 * @param receiptBankCodeList
	 * @return
	 */
	 public String getReceiptBankDescforCode(String receiptBankCode,List receiptBankCodeList)
	 {
		Iterator iterator = receiptBankCodeList.iterator();
		String receiptBankDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(receiptBankCode.equalsIgnoreCase(pm_il_contractor.getCONT_AD_BANK_CODE()))
	 		{
				receiptBankDesc = pm_il_contractor.getUI_M_CONT_AD_BANK_NAME();
			}
		}
		return receiptBankDesc;
	}

	/**
	 * List returning Receipt Bank Lov containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> receiptBankLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> receiptBankCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_AD_BANK_CODE(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_AD_BANK_NAME(resultSet.getString(2));
				receiptBankCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return receiptBankCodeList;
	}

	/**
	 * Prepares Receipt Nationality Code List
	 * 
	 * @param connection
	 * @param nationalityCode
	 * @param nationalityCodeList
	 * @return
	 */
	 public List prepareNationalityCodeList(Connection connection,String nationalityCode, List nationalityCodeList) {

		String query = null;
		if ("*".equalsIgnoreCase(nationalityCode)) {
			query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_NATIONALITY_CODE_LIST;
				Object[] object={};
				nationalityCodeList = nationalityLOV(connection, query,object);
		} else {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_PREPARE_NATIONALITY_CODE_LIST_LIKE;
				nationalityCode=nationalityCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={nationalityCode,nationalityCode};
				nationalityCodeList = nationalityLOV(connection, query,object);			
		}
		return nationalityCodeList;
	}

	/**
	 * Returns Receipt Nationality Description for Code and codeList
	 * 
	 * @param nationalityCode
	 * @param nationalityCodeList
	 * @return
	 */
	 public String getNationalityDescforCode(String nationalityCode,List nationalityCodeList)
	 {
		Iterator iterator = nationalityCodeList.iterator();
		String nationalityDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_IL_CONTRACTOR pm_il_contractor=(PM_IL_CONTRACTOR)iterator.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
	 		if(nationalityCode.equalsIgnoreCase(pm_il_contractor.getCONT_NATIONALITY_CODE()))
	 		{
	 			nationalityDesc=pm_il_contractor.getUI_M_CONT_NATIONALITY_CODE_DESC();
			}
		}
		return nationalityDesc;
	}

	/**
	 * List returning Receipt Nationality Lov containing code and its
	 * description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	 public List<PM_IL_CONTRACTOR> nationalityLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR> nationalityCodeList = new ArrayList<PM_IL_CONTRACTOR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR pm_il_contractor = new PM_IL_CONTRACTOR();
				pm_il_contractor.setCONT_NATIONALITY_CODE(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_NATIONALITY_CODE_DESC(resultSet.getString(2));
				nationalityCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return nationalityCodeList;
	}
	 
}
