package com.iii.pel.forms.PM094_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BONUS_SETUP_DELEGATE {

	public void executeInsertForAgentBonusSetup(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup){
		CRUDHandler handler=new CRUDHandler();
		
		try {
			Connection connection=CommonUtils.getConnection();
			handler.executeInsert(pm_agent_bonus_setup, connection);
			System.out.println("DELEGATE -----------------> ROWID: "+pm_agent_bonus_setup.getROWID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List bonusTyepLOV(String query, Object[] object) {
		List<PM_AGENT_BONUS_SETUP> bonusTypeList = new ArrayList<PM_AGENT_BONUS_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection=null;
		try
			{
			connection=CommonUtils.getConnection();
			System.out.println("qUERY :"+query);
			System.out.println(" Object :"+object);
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_AGENT_BONUS_SETUP pm_agent_bonus_setup = new PM_AGENT_BONUS_SETUP();
				pm_agent_bonus_setup.setABS_BONUS_TYPE(resultSet.getString(1));
				System.out.println("abs COde : "+pm_agent_bonus_setup.getABS_CODE());
				pm_agent_bonus_setup.setUI_M_ABS_BONUS_TYPE_DESC(resultSet.getString(2));
				bonusTypeList.add(pm_agent_bonus_setup);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bonusTypeList;
	}
	
	
	public void executeDeleteForAgentBonusSetup(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup){
		CRUDHandler handler=new CRUDHandler();
		
		try {
			Connection connection=CommonUtils.getConnection();
			handler.executeDelete(pm_agent_bonus_setup, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<PM_AGENT_BONUS_SETUP> searchAgentBonusSetupRecord(String searchBonusCode,
																		String searchBonusType) throws SQLException, DBException {
		
		ArrayList<PM_AGENT_BONUS_SETUP> agentBonusList = null;
		Connection connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=null;
		String query=null;
		String PERCENTILE_LIKE=PM094_A_PM_AGENT_BONUS_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
		System.out.println("bonus_code :"+searchBonusCode+" ::: bonus Type :"+searchBonusType+" EMPTY CHK :"+searchBonusCode.isEmpty() );
		query=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_SETUP_SEARCH_QUERY;
		if(searchBonusCode.isEmpty() && searchBonusType.isEmpty()){
				resultSet=handler.executeSelectStatement(query, connection, new Object[]{});
		}else{
				System.out.println("ITS HERE :::::");
		
				query=query+" WHERE ABS_CODE LIKE ? AND ABS_BONUS_TYPE LIKE ? ";
				System.out.println("QUERY :"+query);
				resultSet=handler.executeSelectStatement(query, connection, new Object[]{searchBonusCode+PERCENTILE_LIKE,searchBonusType+PERCENTILE_LIKE});
				
		}
		agentBonusList=new ArrayList<PM_AGENT_BONUS_SETUP>();
		while(resultSet.next()){
			pm_agent_bonus_setup=new PM_AGENT_BONUS_SETUP();
			pm_agent_bonus_setup.setROWID(resultSet.getString("ROWID"));
			pm_agent_bonus_setup.setABS_CODE(resultSet.getString("ABS_CODE"));
			pm_agent_bonus_setup.setABS_DESC(resultSet.getString("ABS_DESC"));
			pm_agent_bonus_setup.setABS_BONUS_TYPE(resultSet.getString("ABS_BONUS_TYPE"));
			
			agentBonusList.add(pm_agent_bonus_setup);
		}
			
		
		return agentBonusList;
	}

	public void fetchAgentBonusSetupDetails(PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction) throws DBException, SQLException {
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup = compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN();
		String selectQuery=PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM_AGENT_BONUS_SETUP_SEARCH_FETCH_QUERY;
		resultSet=handler.executeSelectStatement(selectQuery, connection, new Object[]{pm_agent_bonus_setup.getROWID()});
		
		if(resultSet.next()){
			pm_agent_bonus_setup.setROWID(resultSet.getString("ROWID"));
			pm_agent_bonus_setup.setABS_CODE(resultSet.getString("ABS_CODE"));
			pm_agent_bonus_setup.setABS_DESC(resultSet.getString("ABS_DESC"));
			pm_agent_bonus_setup.setABS_SHORT_DESC(resultSet.getString("ABS_SHORT_DESC"));
			pm_agent_bonus_setup.setABS_LONG_DESC(resultSet.getString("ABS_LONG_DESC"));
			pm_agent_bonus_setup.setABS_BL_DESC(resultSet.getString("ABS_BL_DESC"));
			pm_agent_bonus_setup.setABS_BL_SHORT_DESC(resultSet.getString("ABS_BL_SHORT_DESC"));
			pm_agent_bonus_setup.setABS_BL_LONG_DESC(resultSet.getString("ABS_BL_LONG_DESC"));
			pm_agent_bonus_setup.setABS_BONUS_TYPE(resultSet.getString("ABS_BONUS_TYPE"));
			pm_agent_bonus_setup.setABS_YRS_FM(resultSet.getInt("ABS_YRS_FM"));
			pm_agent_bonus_setup.setABS_YRS_TO(resultSet.getInt("ABS_YRS_TO"));
			pm_agent_bonus_setup.setABS_BONUS_FREQ(resultSet.getString("ABS_BONUS_FREQ"));
			pm_agent_bonus_setup.setABS_PRORATA_YN(resultSet.getString("ABS_PRORATA_YN"));
			pm_agent_bonus_setup.setABS_POL_RENEWAL_YR(resultSet.getDouble("ABS_POL_RENEWAL_YR"));
			pm_agent_bonus_setup.setABS_EFF_FM_DT(resultSet.getDate("ABS_EFF_FM_DT"));
			pm_agent_bonus_setup.setABS_EFF_TO_DT(resultSet.getDate("ABS_EFF_TO_DT"));
			pm_agent_bonus_setup.setABS_CR_DT(resultSet.getDate("ABS_CR_DT"));
			pm_agent_bonus_setup.setABS_CR_UID(resultSet.getString("ABS_CR_UID"));
			pm_agent_bonus_setup.setABS_UPD_DT(resultSet.getDate("ABS_UPD_DT"));
			pm_agent_bonus_setup.setABS_UPD_UID(resultSet.getString("ABS_UPD_UID"));
			pm_agent_bonus_setup.setABS_TAXABLE_YN(resultSet.getString("ABS_TAXABLE_YN"));
			compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().setPM_AGENT_BONUS_SETUP_BEAN(pm_agent_bonus_setup);
		}
	}

}
