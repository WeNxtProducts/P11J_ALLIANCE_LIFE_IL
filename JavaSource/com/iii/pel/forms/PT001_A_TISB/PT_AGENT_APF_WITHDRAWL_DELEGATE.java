package com.iii.pel.forms.PT001_A_TISB;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_APF_WITHDRAWL_DELEGATE {

	
	
	public ArrayList<SelectItem> selectValueForComboBox(String param) {
		
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			queryString = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = '"+param+"' ORDER BY 1";
			resultSet = handler.executeSelectStatement(queryString, connection);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}
	
	
	
	
	public List suggestionActionAgentCode(String agentCode, List agentCodeList) {
		String query = null;
		if ("*".equalsIgnoreCase(agentCode)) {
			Object[] params = {"002","005","009"};
			query = PT_AGENT_APF_WITHDRAWL_CONSTANTS.PT_AGENT_APF_WITHDRAWL_DELEGATE$AGENT_CODE$LOV$QUERY1;
			agentCodeList = agentCodeLOV(query,agentCodeList,params);
		} else {
			agentCode = agentCode + "%";
			Object[] params = {"002","005","009",agentCode};
			query = PT_AGENT_APF_WITHDRAWL_CONSTANTS.PT_AGENT_APF_WITHDRAWL_DELEGATE$AGENT_CODE$LOV$QUERY2;
			agentCodeList = agentCodeLOV(query,agentCodeList,params);
		}
		
		return agentCodeList;
	}

	
	public List agentCodeLOV(String query,List agentCodeList,Object[] params) {
		agentCodeList = new ArrayList();
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		try {
			handler = new CRUDHandler();
			Connection	connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query,connection,params);
			while (resultSet.next()) {
				PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl = new PT_AGENT_APF_WITHDRAWL();
				pt_agent_apf_withdrawl.setAPW_AGENT_CODE(resultSet.getString(1));
				pt_agent_apf_withdrawl.setUI_M_AGENT_DESC(resultSet.getString(2));
				agentCodeList.add(pt_agent_apf_withdrawl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return agentCodeList;
	}
	
	
	

	public List suggestionActionReasonCode(String reasonCode, List reasonCodeList) {
		String query = null;
		if ("*".equalsIgnoreCase(reasonCode)) {
			Object[] params = {"WITHDREASON"};
			query = PT_AGENT_APF_WITHDRAWL_CONSTANTS.PT_AGENT_APF_WITHDRAWL_DELEGATE$REASON_CODE$LOV$QUERY1;
			reasonCodeList = reasonCodeLOV(query,reasonCodeList,params);
		} else {
			reasonCode = reasonCode + "%";
			Object[] params = {"WITHDREASON",reasonCode};
			query = PT_AGENT_APF_WITHDRAWL_CONSTANTS.PT_AGENT_APF_WITHDRAWL_DELEGATE$REASON_CODE$LOV$QUERY2;
			reasonCodeList = reasonCodeLOV(query,reasonCodeList,params);
		}
		
		return reasonCodeList;
	}

	
	public List reasonCodeLOV(String query,List reasonCodeList,Object[] params) {
		reasonCodeList = new ArrayList();
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		try {
			handler = new CRUDHandler();
			Connection	connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query,connection,params);
			while (resultSet.next()) {
				PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl = new PT_AGENT_APF_WITHDRAWL();
				pt_agent_apf_withdrawl.setAPW_REASON_CODE(resultSet.getString(1));
				pt_agent_apf_withdrawl.setUI_M_REASON_DESC(resultSet.getString(2));
				reasonCodeList.add(pt_agent_apf_withdrawl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return reasonCodeList;
	}
	
	
	public String validateAgentCode(String agentCode)
	{
		String TEMP = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet =null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query= PT_AGENT_APF_WITHDRAWL_CONSTANTS.PT_AGENT_APF_WITHDRAWL_DELEGATE$AGENT_CODE$VALIDATION;
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{agentCode});
			while(resultSet.next())
			{
				TEMP = resultSet.getString(1);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return TEMP;
	}
	
	public String validateReasonCode(String agentCode)
	{
		String TEMP = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet =null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query= PT_AGENT_APF_WITHDRAWL_CONSTANTS.PT_AGENT_APF_WITHDRAWL_DELEGATE$REASON_CODE$VALIDATION;
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next())
			{
				TEMP = resultSet.getString(1);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return TEMP;
	}
	
	
	public void INS_AGENT_PF_WITHDRAWL(String sysId)throws Exception
	{
		
		System.out.println("Procedure INS_AGENT_PF_WITHDRAWL calling...............................");
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> resultList = new ArrayList<String>();
		Connection connection = null;
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",sysId);
		parameterList.add(param1);
		String value = null;
		try{
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		
			connection = CommonUtils.getConnection();
			outputList = procHandler.execute(parameterList, connection, "P9ILPK_AGENT_PF.INS_AGENT_PF_WITHDRAWL");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null)
				{
					value = oracleParameter.getValue();
					resultList.add(value);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void INS_WITH_ACNT_ENTRIES(String sysId)throws Exception
	{
		System.out.println("Procedure INS_WITH_ACNT_ENTRIES calling...............................");
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> resultList = new ArrayList<String>();
		Connection connection = null;
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",sysId);
		parameterList.add(param1);
		String value = null;
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try{
			connection = CommonUtils.getConnection();
			outputList = procHandler.execute(parameterList, connection, "P9ilpk_Agent_Pf.INS_WITH_ACNT_ENTRIES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null)
				{
					value = oracleParameter.getValue();
					resultList.add(value);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public String generateSysId()
	{
		String sysId = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet =null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query= PT_AGENT_APF_WITHDRAWL_CONSTANTS.PRE_INSERT$QUERY;
			resultSet = handler.executeSelectStatement(query, connection);
			if(resultSet.next())
			{
				sysId = resultSet.getString(1);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sysId;
	}
	
	
	public List<PT_AGENT_APF_WITHDRAWL_DTL> getAGENT_PF_WITHDRAWLDetails(String sysId) throws Exception
	{
		Connection connection = null;
		
		CRUDHandler dbHandler = new CRUDHandler();
		List<PT_AGENT_APF_WITHDRAWL_DTL> list = null;
		try {
			connection = CommonUtils.getConnection();
			list = new ArrayList<PT_AGENT_APF_WITHDRAWL_DTL>();
			String query = "SELECT APWD_ACC_TYPE,APWD_LC_COMM_AMT,APWD_FC_COMM_AMT,APWD_LC_COMM_INT_AMT," +
					"APWD_FC_COMM_INT_AMT,APWD_LC_BENF_AMT,APWD_FC_BENF_AMT,APWD_LC_BENF_INT_AMT,APWD_FC_BENF_INT_AMT " +
					"FROM PT_AGENT_APF_WITHDRAWL_DTL WHERE APWD_APW_SYS_ID = '"+sysId+"'";
			System.out.println("QUERY::::::"+query);
			list =dbHandler.fetch(query,"com.iii.pel.forms.PT001_A_TISB.PT_AGENT_APF_WITHDRAWL_DTL",connection);
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return list;
	}
	
	
	public int insertWithdrawalDetails(PT_AGENT_APF_WITHDRAWL pt_agent_apf_withdrawl) throws Exception {
		int rowUpdated = 0;
		try {
			Connection connection = CommonUtils.getConnection();
			if(pt_agent_apf_withdrawl.getROWID() == null){
				rowUpdated = new CRUDHandler().executeInsert(pt_agent_apf_withdrawl, connection);
			}else{
				rowUpdated = new CRUDHandler().executeUpdate(pt_agent_apf_withdrawl, connection);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return rowUpdated;
	}
	
	
}
