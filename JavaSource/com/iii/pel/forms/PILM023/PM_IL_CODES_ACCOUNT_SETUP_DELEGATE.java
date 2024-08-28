package com.iii.pel.forms.PILM023;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_IL_CODES_ACCOUNT_SETUP_DELEGATE {

	/**
	 * Gets List of SelectItem from ListItemUtil for itemName and sysParam
	 * for Module PILM023 and Block PM_IL_CODES_ACCOUNT_SETUP
	 * @param itemName			String LI_ITEM_NAME
	 * @param sysParam			String LI_SYS_PARAM
	 * @return					List<SelectItem>
	 */
	public List<SelectItem> getList(String itemName, String sysParam) {
		Connection connection;
		List<SelectItem> itemList = null;
		try {
			connection = CommonUtils.getConnection();
			itemList = ListItemUtil
					.getDropDownListValue(
							connection,
							PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_MODULE_NAME,
							PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_BLOCK_NAME,
							itemName, sysParam);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemList;
	}
	
	/**
	 * 
	 * @param cacsSrcBusFm
	 * @param cacsSrcBusFmList
	 * @return
	 */
	public List prepareCacsSrcBusFmList(String cacsSrcBusFm, List cacsSrcBusFmList) {

		String query = null;
		if ("*".equalsIgnoreCase(cacsSrcBusFm)) {
			query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_SRC_BUS_FM_LOV;
				Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				cacsSrcBusFmList = cacsSrcBusFmLOV(query,object);

		} else {
				cacsSrcBusFm=cacsSrcBusFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("cacsSrcBusFm :"+cacsSrcBusFm);
				Object[] object={cacsSrcBusFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_SRC_BUS_FM_LOV_LIKE;
				System.out.println("Query :"+query);
				cacsSrcBusFmList = cacsSrcBusFmLOV(query,object);
		}
		return cacsSrcBusFmList;
	}
	
	/**
	 * 
	 * @param query
	 * @param object
	 * @return
	 */
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsSrcBusFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsSrcBusFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_SRC_BUS_FM(resultSet.getString(1));
					System.out.println("pm_il_codes_account_setup :"+pm_il_codes_account_setup.getCACS_BUS_FM_CODE());
					pm_il_codes_account_setup.setUI_M_CACS_SRC_BUS_FM_DESC(resultSet.getString(2));
					cacsSrcBusFmList.add(pm_il_codes_account_setup);
					
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
		return cacsSrcBusFmList;
	}
	 
	 public List prepareCacsSrcBusToList(String cacsSrcBusTo, List cacsSrcBusToList) {

			String query = null;
			if ("*".equalsIgnoreCase(cacsSrcBusTo)) {
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_SRC_BUS_FM_LOV;
					Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					cacsSrcBusToList = cacsSrcBusToLOV(query,object);

			} else {
					cacsSrcBusTo=cacsSrcBusTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
					System.out.println("cacsSrcBusTo :"+cacsSrcBusTo);
					Object[] object={cacsSrcBusTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_SRC_BUS_FM_LOV_LIKE;
					System.out.println("Query :"+query);
					cacsSrcBusToList = cacsSrcBusToLOV(query,object);
			}
			return cacsSrcBusToList;
		}
	 
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsSrcBusToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsSrcBusToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_SRC_BUS_TO(resultSet.getString(1));
					System.out.println("pm_il_codes_account_setup :"+pm_il_codes_account_setup.getCACS_SRC_BUS_TO());
					pm_il_codes_account_setup.setUI_M_CACS_SRC_BUS_TO_DESC(resultSet.getString(2));
					cacsSrcBusToList.add(pm_il_codes_account_setup);
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
		return cacsSrcBusToList;
	}
	 
	 public List prepareCacsBusFmList(String cacsBusFm, List cacsBusFmList) {

			String query = null;
			if ("*".equalsIgnoreCase(cacsBusFm)) {
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_BUS_FM_LOV;
					Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					cacsBusFmList = cacsBusFmLOV(query,object);

			} else {
					cacsBusFm=cacsBusFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
					System.out.println("cacsSrcBusFm :"+cacsBusFm);
					Object[] object={cacsBusFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_BUS_FM_LOV_LIKE;
					System.out.println("Query :"+query);
					cacsBusFmList = cacsBusFmLOV(query,object);
			}
			return cacsBusFmList;
		}
	 
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsBusFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsBusFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_BUS_FM_CODE(resultSet.getString(1));
					System.out.println("pm_il_codes_account_setup :"+pm_il_codes_account_setup.getCACS_BUS_TO_CODE());
					pm_il_codes_account_setup.setUI_M_CACS_BUS_FM_CODE_DESC(resultSet.getString(2));
					cacsBusFmList.add(pm_il_codes_account_setup);
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
		return cacsBusFmList;
	}
	
	 public List prepareCacsBusToList(String cacsBusTo, List cacsBusToList) {

		String query = null;
		if ("*".equalsIgnoreCase(cacsBusTo)) {
			query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_BUS_FM_LOV;
				Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				cacsBusToList = cacsBusToLOV(query,object);

		} else {
				cacsBusTo=cacsBusTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("cacsBusTo :"+cacsBusTo);
				Object[] object={cacsBusTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_BUS_FM_LOV_LIKE;
				System.out.println("Query :"+query);
				cacsBusToList = cacsBusToLOV(query,object);
		}
		return cacsBusToList;
	}
	 
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsBusToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsBusToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_BUS_TO_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_BUS_TO_CODE_DESC(resultSet.getString(2));
					cacsBusToList.add(pm_il_codes_account_setup);
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
		return cacsBusToList;
	}
	
	 public List prepareCacsDivnFmList(String cacsDivnFm, List cacsDivnFmList) {

		String query = null;
		
		//TODO COMMENTS TO BE REMOVED FOR GETTING CONTROL BEAN VALUES
		/*String  divisionCode=CommonUtils.getControlBean().getM_COMP_CODE();
		String userId=CommonUtils.getControlBean().getM_USER_ID();*/
		String  divisionCode="001";
		
		if ("*".equalsIgnoreCase(cacsDivnFm)) {
				Object[] object={divisionCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DIVN_FM_CODE_LOV;//
				///DIVISION CODE,USERID TO BE PASSED FROM CONTROL BEAN AND ROWID ALSO HAS TO BE PASSED
				cacsDivnFmList = cacsDivnFmLOV(query,object);

		} else {
				cacsDivnFm=cacsDivnFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("cacsDivnFm :"+cacsDivnFm);
				Object[] object={divisionCode,cacsDivnFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DIVN_FM_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				cacsDivnFmList = cacsDivnFmLOV(query,object);
		}
		return cacsDivnFmList;
	}
	 
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDivnFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDivnFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_DIVN_FM_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_DIVN_FM_CODE_DESC(resultSet.getString(2));
					cacsDivnFmList.add(pm_il_codes_account_setup);
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
		return cacsDivnFmList;
	}
	
	 public List prepareCacsDivnToList(String cacsDivnTo, List cacsDivnToList) {

		String query = null;
		
		//TODO COMMENTS TO BE REMOVED FOR GETTING CONTROL BEAN VALUES
		/*String  compCode=CommonUtils.getControlBean().getM_COMP_CODE();
		String userId=CommonUtils.getControlBean().getM_USER_ID();*/
		String  compCode="001";
		
		if ("*".equalsIgnoreCase(cacsDivnTo)) {
				Object[] object={compCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DIVN_FM_CODE_LOV;//
				///DIVISION CODE,USERID(which is set to Null) TO BE PASSED FROM CONTROL BEAN AND ROWID ALSO HAS TO BE PASSED
				cacsDivnToList = cacsDivnToLOV(query,object);

		} else {
			cacsDivnTo=cacsDivnTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("cacsDivnFm :"+cacsDivnTo);
				Object[] object={compCode,cacsDivnTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DIVN_FM_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				cacsDivnToList = cacsDivnToLOV(query,object);
		}
		return cacsDivnToList;
	}
	 
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDivnToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDivnToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_DIVN_TO_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_DIVN_TO_CODE_DESC(resultSet.getString(2));
					cacsDivnToList.add(pm_il_codes_account_setup);
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
		return cacsDivnToList;
	}
	
	
	public List prepareCacsDeptFmList(String divisionCode,String cacsDeptFm, List cacsDeptFmList) {

		String query = null;
		
		//TODO COMMENTS TO BE REMOVED FOR GETTING CONTROL BEAN VALUES
		/*String  divisionCode=CommonUtils.getControlBean().getM_COMP_CODE();*/
		CommonUtils commonUtils = new CommonUtils();
		
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction  = 
			(PM_IL_CODES_ACCOUNT_SETUP_ACTION)(commonUtils.getMappedBeanFromSession
										("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		String  compCode="001";
		
		System.out.println("divisionCode :"+divisionCode);
		if(divisionCode!=null){
			if ("*".equalsIgnoreCase(cacsDeptFm)) {
					Object[] object={compCode,divisionCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DEPT_FM_CODE_LOV;
					cacsDeptFmList = cacsDeptFmLOV(query,object);
	
			} else {
					cacsDeptFm=cacsDeptFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
					System.out.println("cacsDeptFm :"+cacsDeptFm);
					Object[] object={compCode,divisionCode,cacsDeptFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DEPT_FM_CODE_LOV_LIKE;
					System.out.println("Query :"+query);
					cacsDeptFmList = cacsDeptFmLOV(query,object);
			}
		}	
		return cacsDeptFmList;
	}
	
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDeptFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDeptFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_DEPT_FM_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_DEPT_FM_CODE_DESC(resultSet.getString(2));
					cacsDeptFmList.add(pm_il_codes_account_setup);
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
		return cacsDeptFmList;
	}
	
	
	public List prepareCacsDeptToList(String divisionCode,String cacsDeptTo, List cacsDeptToList) {

		String query = null;
		
		//TODO COMMENTS TO BE REMOVED FOR GETTING CONTROL BEAN VALUES
		/*String  divisionCode=CommonUtils.getControlBean().getM_COMP_CODE();*/
		CommonUtils commonUtils = new CommonUtils();
		
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction  = 
			(PM_IL_CODES_ACCOUNT_SETUP_ACTION)(commonUtils.getMappedBeanFromSession
										("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		String  compCode="001";
		
		System.out.println("divisionCode :"+divisionCode);
		if(divisionCode!=null){
			if ("*".equalsIgnoreCase(cacsDeptTo)) {
					Object[] object={compCode,divisionCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DEPT_FM_CODE_LOV;
					cacsDeptToList = cacsDeptToLOV(query,object);
	
			} else {
					cacsDeptTo=cacsDeptTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
					System.out.println("cacsDeptFm :"+cacsDeptTo);
					Object[] object={compCode,divisionCode,cacsDeptTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DEPT_FM_CODE_LOV_LIKE;
					System.out.println("Query :"+query);
					cacsDeptToList = cacsDeptToLOV(query,object);
			}
		}	
		return cacsDeptToList;
	}
	
	
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDeptToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDeptToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_DEPT_TO_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_DEPT_TO_CODE_DESC(resultSet.getString(2));
					cacsDeptToList.add(pm_il_codes_account_setup);
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
		return cacsDeptToList;
	}
	
	public List prepareCacsDocFmList(String cacsDocFm, List cacsDocFmList) {

		String query = null;
		
			
			if ("*".equalsIgnoreCase(cacsDocFm)) {
					Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DOC_FM_TYPE_LOV;
					cacsDocFmList = cacsDocFmLOV(query,object);
	
			} else {
					cacsDocFm=cacsDocFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
					System.out.println("cacsDocFmLOV :"+cacsDocFm);
					Object[] object={cacsDocFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DOC_FM_TYPE_LOV_LIKE;
					System.out.println("Query :"+query);
					cacsDocFmList = cacsDocFmLOV(query,object);
			}
		
		return cacsDocFmList;
	}
	
	 public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDocFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDocFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				Connection connection=CommonUtils.getConnection();

				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_DOC_FM_TYPE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_DOC_FM_TYPE_DESC(resultSet.getString(2));
					cacsDocFmList.add(pm_il_codes_account_setup);
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
		return cacsDocFmList;
	}
	
	
	public List prepareCacsDocToList(String cacsDocTo, List cacsDocToList) {

		String query = null;
		
			
			if ("*".equalsIgnoreCase(cacsDocTo)) {
					Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DOC_FM_TYPE_LOV;
					cacsDocToList = cacsDocToLOV(query,object);
	
			} else {
					cacsDocTo=cacsDocTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
					System.out.println("cacsDocFmLOV :"+cacsDocTo);
					Object[] object={cacsDocTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
					query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DOC_FM_TYPE_LOV_LIKE;
					System.out.println("Query :"+query);
					cacsDocToList = cacsDocToLOV(query,object);
			}
		
		return cacsDocToList;
	}
	
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDocToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDocToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_DOC_TO_TYPE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_DOC_TO_TYPE_DESC(resultSet.getString(2));
					cacsDocToList.add(pm_il_codes_account_setup);
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
			return cacsDocToList;
		}
		
		public List prepareCacsCustFmList(String cacsCustFm, List cacsCustFmList) {

			String query = null;
			
				
				if ("*".equalsIgnoreCase(cacsCustFm)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_CUST_CLS_FM_CODE_LOV;
						cacsCustFmList = cacsCustFmLOV(query,object);
		
				} else {
						cacsCustFm=cacsCustFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsCustFm :"+cacsCustFm);
						Object[] object={cacsCustFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_CUST_CLS_FM_CODE_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsCustFmList = cacsCustFmLOV(query,object);
				}
			
			return cacsCustFmList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsCustFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsCustFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_CUST_CLS_FM_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_CUST_CLS_FM_CODE_DESC(resultSet.getString(2));
					cacsCustFmList.add(pm_il_codes_account_setup);
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
			return cacsCustFmList;
		}

		public List prepareCacsCustToList(String cacsCustTo, List cacsCustToList) {

			String query = null;
			
				
				if ("*".equalsIgnoreCase(cacsCustTo)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_CUST_CLS_FM_CODE_LOV;
						cacsCustToList = cacsCustToLOV(query,object);
		
				} else {
					cacsCustTo=cacsCustTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsCustFm :"+cacsCustTo);
						Object[] object={cacsCustTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_CUST_CLS_FM_CODE_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsCustToList = cacsCustToLOV(query,object);
				}
			
			return cacsCustToList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsCustToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsCustToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_CUST_CLS_TO_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_CUST_CLS_TO_CODE_DESC(resultSet.getString(2));
					cacsCustToList.add(pm_il_codes_account_setup);
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
			return cacsCustToList;
		}
		
		
		public List prepareCacsProdFmList(String cacsProdFm, List cacsProdFmList) {

			String query = null;
			
				
				if ("*".equalsIgnoreCase(cacsProdFm)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_PROD_CODE_FM_LOV;
						cacsProdFmList = cacsProdFmLOV(query,object);
		
				} else {
						cacsProdFm=cacsProdFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsProdFm :"+cacsProdFm);
						Object[] object={cacsProdFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_PROD_CODE_FM_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsProdFmList = cacsProdFmLOV(query,object);
				}
			
			return cacsProdFmList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsProdFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsProdFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_PROD_CODE_FM(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_PROD_CODE_FM_DESC(resultSet.getString(2));
					cacsProdFmList.add(pm_il_codes_account_setup);
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
			return cacsProdFmList;
		}
		
		public List prepareCacsProdToList(String cacsProdTo, List cacsProdToList) {

			String query = null;
			
				
				if ("*".equalsIgnoreCase(cacsProdTo)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_PROD_CODE_FM_LOV;
						cacsProdToList = cacsProdToLOV(query,object);
		
				} else {
						cacsProdTo=cacsProdTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsProdTo :"+cacsProdTo);
						Object[] object={cacsProdTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_PROD_CODE_FM_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsProdToList = cacsProdToLOV(query,object);
				}
			
			return cacsProdToList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsProdToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsProdToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_PROD_CODE_TO(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_PROD_CODE_TO_DESC(resultSet.getString(2));
					cacsProdToList.add(pm_il_codes_account_setup);
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
			return cacsProdToList;
		}
		
		
		public List prepareCacsCoverFmList(String cacsCoverFm, List cacsCoverFmList) {

			String query = null;
				if ("*".equalsIgnoreCase(cacsCoverFm)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_COVER_CODE_FM_LOV;
						cacsCoverFmList = cacsCoverFmLOV(query,object);
		
				} else {
						cacsCoverFm=cacsCoverFm+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsCoverFm :"+cacsCoverFm);
						Object[] object={cacsCoverFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_COVER_CODE_FM_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsCoverFmList = cacsCoverFmLOV(query,object);
				}
			return cacsCoverFmList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsCoverFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsCoverFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_COVER_CODE_FM(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_COVER_CODE_FM_DESC(resultSet.getString(2));
					cacsCoverFmList.add(pm_il_codes_account_setup);
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
			return cacsCoverFmList;
		}
		
		public List prepareCacsCoverToList(String cacsCoverTo, List cacsCoverToList) {

			String query = null;
				if ("*".equalsIgnoreCase(cacsCoverTo)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_COVER_CODE_FM_LOV;
						cacsCoverToList = cacsCoverToLOV(query,object);
		
				} else {
						cacsCoverTo=cacsCoverTo+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsCoverTo :"+cacsCoverTo);
						Object[] object={cacsCoverTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_COVER_CODE_FM_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsCoverToList = cacsCoverToLOV(query,object);
				}
			return cacsCoverToList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsCoverToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsCoverToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					//System.out.println("CODE:"+resultSet.getString(1)+ "   DESC:"+resultSet.getString(2));
					pm_il_codes_account_setup.setCACS_COVER_CODE_TO(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_COVER_CODE_TO_DESC(resultSet.getString(2));
					cacsCoverToList.add(pm_il_codes_account_setup);
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
			return cacsCoverToList;
		}//prepareCacsTypeCodeFmList
		
		public List prepareCacsTypeCodeFmList
					(String cacsTypeCodeFm, List cacsTypeCodeFmList,
							PM_IL_CODES_ACCOUNT_SETUP accountSetupBean) throws DBException {

			String query = null;
			String setUpType=accountSetupBean.getCACS_SETUP_TYPE();
			System.out.println("setUp Type :"+setUpType);
			String M_TYPE=null; 
			String M_PS_DESC=null;
			int M_PS_VALUE=-1;
			
			if(setUpType!=null){
				
				if(setUpType.equals("D")){
					M_TYPE="IL_DEF_DIS";
				}else if(setUpType.equals("C")){
					M_TYPE="IL_CHARGE";
				}else if(setUpType.equals("B")){
					M_TYPE="COMMISSION";
				}else if(setUpType.equals("T")){
					M_TYPE="TAX";
				}else if(setUpType.equals("MF")){
					M_TYPE="IL_MED_EXM";
				}
				System.out.println("M_type"+M_TYPE);
				ArrayList valSystemList;
				try {
					valSystemList = DBProcedures.P_VAL_SYSTEM("IL_BROK_CALC", "IL_BROK_CALC",
										null, PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_P_ERR_FLAG_E, null);
					if(valSystemList!=null && valSystemList.size()!=0){
						M_PS_DESC=valSystemList.get(0).toString();
						M_PS_VALUE=Integer.parseInt(valSystemList.get(1).toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				 //P_VAL_SYSTEM('IL_BROK_CALC', 'IL_BROK_CALC', M_PS_DESC, 'E', M_PS_VALUE) ;
				if(M_PS_VALUE!=-1){
					System.out.println("M_PS_VALUE :"+M_PS_VALUE);
					if(setUpType.equals("B")||setUpType.equals("O") && MigratingFunctions.nvl(M_PS_VALUE, 1)==2){
						if("*".equalsIgnoreCase(cacsTypeCodeFm)){
							query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_LOV_PILH005;
							Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
							cacsTypeCodeFmList=cacsTypeCodeFmLOV(query,object);
						}else{
							query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_LOV_PILH005_LIKE;
							Object[] object={cacsTypeCodeFm,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
							cacsTypeCodeFmList=cacsTypeCodeFmLOV(query,object);
						}
					}if(setUpType.equals("FB")){
						//TODO QURIES NOT AVAILABLE
					}if(setUpType.equals("AB")){
						//TODO QURIES NOT AVAILABLE
					}else{
						if("*".equalsIgnoreCase(cacsTypeCodeFm)){
							query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_FM_LOV_PGLH044;
							Object[] object={M_TYPE,M_TYPE};
							cacsTypeCodeFmList=cacsTypeCodeFmLOV(query,object);
						}else{
							query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_FM_LOV_PGLH044_LIKE;
							Object[] object={cacsTypeCodeFm,M_TYPE,M_TYPE};
							cacsTypeCodeFmList=cacsTypeCodeFmLOV(query,object);
						}
					}
					
				}
			}
			System.out.println("Query :"+query);
			return cacsTypeCodeFmList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsTypeCodeFmLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsTypeCodeFmList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_TYPE_FM_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_TYPE_FM_CODE_DESC(resultSet.getString(2));
					cacsTypeCodeFmList.add(pm_il_codes_account_setup);
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
			return cacsTypeCodeFmList;
		}
		
				
		
		public List prepareCacsMainAcntList(String cacsMainAcnt, List cacsMainAcntList) {

			String query = null;
				if ("*".equalsIgnoreCase(cacsMainAcnt)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_MAIN_ACNT_CODE;
						cacsMainAcntList = cacsMainAcntLOV(query,object);
		
				} else {
						cacsMainAcnt=cacsMainAcnt+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsCoverTo :"+cacsMainAcnt);
						Object[] object={cacsMainAcnt,cacsMainAcnt,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_MAIN_ACNT_CODE_LIKE;
						cacsMainAcntList = cacsMainAcntLOV(query,object);
				}
			return cacsMainAcntList;
		}
		
		public List prepareCacsTypeCodeToList(String cacsTypeCodeTo, List cacsTypeCodeToList,
				PM_IL_CODES_ACCOUNT_SETUP accountSetupBean) throws DBException {

				String query = null;
				String setUpType=accountSetupBean.getCACS_SETUP_TYPE();
				System.out.println("setUp Type :"+setUpType);
				String M_TYPE=null; 
				String M_PS_DESC=null;
				int M_PS_VALUE=-1;
				
				if(setUpType!=null){
					
					if(setUpType.equals("D")){
						M_TYPE="IL_DEF_DIS";
					}else if(setUpType.equals("C")){
						M_TYPE="IL_CHARGE";
					}else if(setUpType.equals("B")){
						M_TYPE="COMMISSION";
					}else if(setUpType.equals("T")){
						M_TYPE="TAX";
					}else if(setUpType.equals("MF")){
						M_TYPE="IL_MED_EXM";
					}
					System.out.println("M_type"+M_TYPE);
					ArrayList valSystemList;
					try {
						valSystemList = DBProcedures.P_VAL_SYSTEM("IL_BROK_CALC", "IL_BROK_CALC",
											null, PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_P_ERR_FLAG_E, null);
						if(valSystemList!=null && valSystemList.size()!=0){
							M_PS_DESC=valSystemList.get(0).toString();
							M_PS_VALUE=Integer.parseInt(valSystemList.get(1).toString());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 //P_VAL_SYSTEM('IL_BROK_CALC', 'IL_BROK_CALC', M_PS_DESC, 'E', M_PS_VALUE) ;
					if(M_PS_VALUE!=-1){
						System.out.println("M_PS_VALUE :"+M_PS_VALUE);
						if(setUpType.equals("B")||setUpType.equals("O") && MigratingFunctions.nvl(M_PS_VALUE, 1)==2){
							if("*".equalsIgnoreCase(cacsTypeCodeTo)){
								query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_LOV_PILH005;
								Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
								cacsTypeCodeToList=cacsTypeCodeToLOV(query,object);
							}else{
								query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_LOV_PILH005_LIKE;
								Object[] object={cacsTypeCodeTo,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
								cacsTypeCodeToList=cacsTypeCodeToLOV(query,object);
							}
						}if(setUpType.equals("FB")){
							//TODO QURIES NOT AVAILABLE
						}if(setUpType.equals("AB")){
							//TODO QURIES NOT AVAILABLE
						}else{
							if("*".equalsIgnoreCase(cacsTypeCodeTo)){
								query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_FM_LOV_PGLH044;
								Object[] object={M_TYPE,M_TYPE};
								cacsTypeCodeToList=cacsTypeCodeToLOV(query,object);
							}else{
								query=PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_FM_LOV_PGLH044_LIKE;
								Object[] object={cacsTypeCodeTo,M_TYPE,M_TYPE};
								cacsTypeCodeToList=cacsTypeCodeToLOV(query,object);
							}
						}
						
					}
				}
				System.out.println("Query :"+query);
				return cacsTypeCodeToList;
		}
		
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsMainAcntLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsMainAcntList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_MAIN_ACNT_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_MAIN_ACNT_NAME(resultSet.getString(2));
					cacsMainAcntList.add(pm_il_codes_account_setup);
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
			return cacsMainAcntList;
		}
		
		public String getMainAcntNameForCode(String mainAcntCode,List mainAcntCodeList)
		 {
			Iterator iterator = mainAcntCodeList.iterator();
			String mainAcntName = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(mainAcntCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_MAIN_ACNT_CODE()))
		 		{
		 			mainAcntName = pm_il_codes_account_setup.getUI_M_MAIN_ACNT_NAME();
				}
			}
			return mainAcntName;
		}
		
		
		public List prepareCacsSubAcntList(String mainAcntCode,String cacsSubAcnt, List cacsSubAcntList) {

			String query = null;
				if ("*".equalsIgnoreCase(cacsSubAcnt)) {
						Object[] object={mainAcntCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_SUB_ACNT_CODE;
						cacsSubAcntList = cacsSubAcntLOV(query,object);
		
				} else {
						cacsSubAcnt=cacsSubAcnt+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsSubAcnt :"+cacsSubAcnt);
						Object[] object={mainAcntCode,cacsSubAcnt,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_SUB_ACNT_CODE_LIKE;
						System.out.println("Query :"+query);
						cacsSubAcntList = cacsSubAcntLOV(query,object);
				}
			return cacsSubAcntList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsSubAcntLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsSubAcntList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_SUB_ACNT_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_SUB_ACNT_NAME(resultSet.getString(2));
					cacsSubAcntList.add(pm_il_codes_account_setup);
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
			return cacsSubAcntList;
		}
		
		public String getSubAcntNameForCode(String subAcntCode,List subAcntCodeList)
		 {
			Iterator iterator = subAcntCodeList.iterator();
			String subAcntName = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(subAcntCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_SUB_ACNT_CODE()))
		 		{
		 			subAcntName = pm_il_codes_account_setup.getUI_M_SUB_ACNT_NAME();
				}
			}
			return subAcntName;
		}
		
		public List prepareCacsDivnCodeList(String cacsDivnCode, List cacsDivnCodeList) {

			String query = null;
			//TODO COMMENTS TO BE REMOVED FOR GETTING CONTROL BEAN VALUES
			/*String  compCode=CommonUtils.getControlBean().getM_COMP_CODE();
			String userId=CommonUtils.getControlBean().getM_USER_ID();*/
			String  compCode="001";
				if ("*".equalsIgnoreCase(cacsDivnCode)) {
						Object[] object={compCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DIVN_FM_CODE_LOV;
						cacsDivnCodeList = cacsDivnCodeLOV(query,object);
		
				} else {
						cacsDivnCode=cacsDivnCode+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsCoverTo :"+cacsDivnCode);
						Object[] object={compCode,cacsDivnCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DIVN_FM_CODE_LOV_LIKE;
						System.out.println("Query :"+query);
						cacsDivnCodeList = cacsDivnCodeLOV(query,object);
				}
			return cacsDivnCodeList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDivnCodeLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDivnCodeList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_DIVN_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_DIVN_NAME(resultSet.getString(2));
					cacsDivnCodeList.add(pm_il_codes_account_setup);
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
			return cacsDivnCodeList;
		}
		
		public String getDivnNameForCode(String divnCode,List divnCodeList)
		 {
			Iterator iterator = divnCodeList.iterator();
			String divnName = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(divnCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_DIVN_CODE()))
		 		{
		 			divnName = pm_il_codes_account_setup.getUI_M_DIVN_NAME();
				}
			}
			return divnName;
		}
		
		public List prepareCacsDeptCodeList(String divisionCode,String deptCode,List deptCodeList) {

			String query = null;
			//TODO COMMENTS TO BE REMOVED FOR GETTING CONTROL BEAN VALUES
			CommonUtils commonUtils = new CommonUtils();
			
			PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction  = 
				(PM_IL_CODES_ACCOUNT_SETUP_ACTION)(commonUtils.getMappedBeanFromSession
											("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
			String  compCode="001";
				if ("*".equalsIgnoreCase(deptCode)) {
						Object[] object={compCode,divisionCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DEPT_FM_CODE_LOV;
						deptCodeList = cacsDeptLOV(query,object);
		
				} else {
						deptCode=deptCode+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("deptCode :"+deptCode);
						Object[] object={compCode,divisionCode,deptCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_DEPT_FM_CODE_LOV_LIKE;
						System.out.println("Query :"+query);
						deptCodeList = cacsDeptLOV(query,object);
				}
			return deptCodeList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsDeptLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsDeptCodeList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_DEPT_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_DEPT_NAME(resultSet.getString(2));
					cacsDeptCodeList.add(pm_il_codes_account_setup);
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
			return cacsDeptCodeList;
		}
		
		public String getDeptNameForCode(String deptCode,List deptCodeList)
		 {
			Iterator iterator = deptCodeList.iterator();
			String deptName = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(deptCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_DEPT_CODE()))
		 		{
		 			deptName = pm_il_codes_account_setup.getUI_M_DEPT_NAME();
				}
			}
			return deptName;
		}
		
		public List prepareCacsAnlyCodeList(String cacsAnlyCode, List cacsAnlyCodeList) {
			
			String query = null;
				if ("*".equalsIgnoreCase(cacsAnlyCode)) {
						Object[] object={PELConstants.suggetionRecordSize};
						query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM< ? ORDER BY 1 ASC";
						cacsAnlyCodeList = cacsAnlyCodeLOV(query,object);
				} else {
		
						cacsAnlyCode=cacsAnlyCode+"%";
						
						Object[] object={cacsAnlyCode,PELConstants.suggetionRecordSize};
						query ="SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE LIKE ?   ROWNUM< ? ORDER BY 1 ASC ";
						cacsAnlyCodeList = cacsAnlyCodeLOV(query,object);
				}
				return cacsAnlyCodeList;
		}
						
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsAnlyCodeLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsAnlycodeList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_ANLY_CODE_1(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_ANLY_NAME(resultSet.getString(2));
					cacsAnlycodeList.add(pm_il_codes_account_setup);
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
			return cacsAnlycodeList;
		}
		
		public String getAnlyNameForCode(String anlyCode,List anlyCodeList)
		 {
			Iterator iterator = anlyCodeList.iterator();
			String anlyName = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(anlyCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_ANLY_CODE_1()))
		 		{
		 			anlyName = pm_il_codes_account_setup.getUI_M_ANLY_NAME();
				}
			}
			return anlyName;
		}
		
		public List prepareCacsAnly1CodeList(String cacsAnly1Code, List cacsAnly1CodeList) {
			
			String query = null;
				if ("*".equalsIgnoreCase(cacsAnly1Code)) {
						Object[] object={PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_ANLY_CODE_2;
						cacsAnly1CodeList = cacsAnly1CodeLOV(query,object);
		
				} else {
						cacsAnly1Code=cacsAnly1Code+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsAnly1Code :"+cacsAnly1Code);
						Object[] object={cacsAnly1Code,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_ANLY_CODE_2_LIKE;
						System.out.println("Query :"+query);
						cacsAnly1CodeList = cacsAnly1CodeLOV(query,object);
				}
			return cacsAnly1CodeList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsAnly1CodeLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsAnly1codeList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_ANLY_CODE_2(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_ANLY_NAME_1(resultSet.getString(2));
					cacsAnly1codeList.add(pm_il_codes_account_setup);
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
			return cacsAnly1codeList;
		}
		
		public String getAnly1NameForCode(String anlyCode,List anlyCodeList)
		 {
			Iterator iterator = anlyCodeList.iterator();
			String anly1Name = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(anlyCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_ANLY_CODE_2()))
		 		{
		 			anly1Name = pm_il_codes_account_setup.getUI_M_ANLY_NAME_1();
				}
			}
			return anly1Name;
		}
		
		public List prepareCacsActyCodeList(String m_acty_1,String cacsActyCode, List cacsActyCodeList) {
			
			String query = null;
				if ("*".equalsIgnoreCase(cacsActyCode)) {
						Object[] object={m_acty_1,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_ACTY_CODE;
						cacsActyCodeList = cacsActyCodeLOV(query,object);
		
				} else {
						cacsActyCode=cacsActyCode+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsActyCode :"+cacsActyCode);
						Object[] object={m_acty_1,cacsActyCode,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_ACTY_CODE;
						System.out.println("Query :"+query);
						cacsActyCodeList = cacsActyCodeLOV(query,object);
				}
			return cacsActyCodeList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsActyCodeLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsAnly1codeList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next()){
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_ACTY_CODE_1(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_ACTY_NAME(resultSet.getString(2));
					cacsAnly1codeList.add(pm_il_codes_account_setup);
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
			return cacsAnly1codeList;
		}
		
		public String getActyNameForCode(String actyCode,List actyCodeList)
		 {
			Iterator iterator = actyCodeList.iterator();
			String anly1Name = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(actyCode.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_ACTY_CODE_1()))
		 		{
		 			anly1Name = pm_il_codes_account_setup.getUI_M_ACTY_NAME();
				}
			}
			return anly1Name;
		}
		
	public List prepareCacsActy1CodeList(String m_acty_2,String cacsActy1Code, List cacsActy1CodeList) {
			
			String query = null;
				if ("*".equalsIgnoreCase(cacsActy1Code)) {
						Object[] object={m_acty_2,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_ACTY_CODE;
						cacsActy1CodeList = cacsActy1CodeLOV(query,object);
		
				} else {
						cacsActy1Code=cacsActy1Code+PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_PERCENTILE_FOR_SELECT_LIKE;
						System.out.println("cacsActyCode :"+cacsActy1Code);
						Object[] object={m_acty_2,cacsActy1Code,PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN};
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_ACTY_CODE;
						System.out.println("Query :"+query);
						cacsActy1CodeList = cacsActy1CodeLOV(query,object);
				}
			return cacsActy1CodeList;
		}
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsActy1CodeLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsAnly2codeList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_ACTY_CODE_2(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_ACTY_NAME_1(resultSet.getString(2));
					cacsAnly2codeList.add(pm_il_codes_account_setup);
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
			return cacsAnly2codeList;
		}
		
		public String getActy1NameForCode(String acty1Code,List acty1CodeList)
		 {
			Iterator iterator = acty1CodeList.iterator();
			String anly2Name = null;
		 	while(iterator.hasNext())
		 	{
		 		PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup=(PM_IL_CODES_ACCOUNT_SETUP)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
		 		if(acty1Code.equalsIgnoreCase(pm_il_codes_account_setup.getCACS_ACTY_CODE_2()))
		 		{
		 			anly2Name = pm_il_codes_account_setup.getUI_M_ACTY_NAME_1();
				}
			}
			return anly2Name;
		}
		
		public ArrayList fetchAccountSetupDetailsFromDatabase(PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE pm_il_codes_account_setup_search_page) throws DBException {
			
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;
			connection = CommonUtils.getConnection();
			ArrayList accountSetupList = new ArrayList();

			try {

					String query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE_QUERY+" WHERE ROWNUM<500";
					if (pm_il_codes_account_setup_search_page.getMainAccount() != null
							&& pm_il_codes_account_setup_search_page.getMainAccount().trim().length() > 0) {
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE_QUERY + " WHERE UPPER(CACS_MAIN_ACNT_CODE) LIKE " + "'"
								+ pm_il_codes_account_setup_search_page.getMainAccount().toUpperCase() + "%'"+" AND ROWNUM<500";
					}
					System.out.println("Query :"+query);
					resultSet = handler.executeSelectStatement(query, connection);
					if (resultSet != null) {
						while (resultSet.next()) {
							PM_IL_CODES_ACCOUNT_SETUP beanClass = new PM_IL_CODES_ACCOUNT_SETUP();

							beanClass.setCACS_MAIN_ACNT_CODE(resultSet.getString("CACS_MAIN_ACNT_CODE"));
							beanClass.setCACS_SUB_ACNT_CODE(resultSet.getString("CACS_SUB_ACNT_CODE"));
							beanClass.setCACS_DIVN_CODE(resultSet.getString("CACS_DIVN_CODE"));
							beanClass.setROWID(resultSet.getString("ROWID"));
							accountSetupList.add(beanClass);
						}
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			return accountSetupList;
		}
		
		public Object fetchAccountSetupDetails(String rowId, Object obj) throws DBException {

			PM_IL_CODES_ACCOUNT_SETUP beanClass = (PM_IL_CODES_ACCOUNT_SETUP) obj;
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;
			connection = CommonUtils.getConnection();
			
			try {
				String query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_NAVIGATE_TO_MAIN_QUERY;
				System.out.println("Query:::"+query+"   ROWID:::::::"+rowId);
				
				Object[] values = {rowId};
				resultSet = handler.executeSelectStatement(query, connection, values);

				while (resultSet.next()) {
	
					
					beanClass.setROWID(resultSet.getString("ROWID"));
					beanClass.setCACS_SETUP_TYPE(resultSet.getString("CACS_SETUP_TYPE"));
					beanClass.setCACS_BUS_FM_CODE(resultSet.getString("CACS_BUS_FM_CODE"));
					beanClass.setCACS_BUS_TO_CODE(resultSet.getString("CACS_BUS_TO_CODE"));
					beanClass.setCACS_DIVN_FM_CODE(resultSet.getString("CACS_DIVN_FM_CODE"));
					beanClass.setCACS_DIVN_TO_CODE(resultSet.getString("CACS_DIVN_TO_CODE"));
					beanClass.setCACS_DEPT_FM_CODE(resultSet.getString("CACS_DEPT_FM_CODE"));
					beanClass.setCACS_DEPT_TO_CODE(resultSet.getString("CACS_DEPT_TO_CODE"));
					beanClass.setCACS_DOC_FM_TYPE(resultSet.getString("CACS_DOC_FM_TYPE"));
					beanClass.setCACS_DOC_TO_TYPE(resultSet.getString("CACS_DOC_TO_TYPE"));
					beanClass.setCACS_TYPE_FM_CODE(resultSet.getString("CACS_TYPE_FM_CODE"));
					beanClass.setCACS_TYPE_TO_CODE(resultSet.getString("CACS_TYPE_TO_CODE"));
					beanClass.setCACS_FORCE_DIVN_YN(resultSet.getString("CACS_FORCE_DIVN_YN"));
					beanClass.setCACS_FORCE_DEPT_YN(resultSet.getString("CACS_FORCE_DEPT_YN"));
					beanClass.setCACS_MAIN_ACNT_CODE(resultSet.getString("CACS_MAIN_ACNT_CODE"));
					beanClass.setCACS_SUB_ACNT_CODE(resultSet.getString("CACS_SUB_ACNT_CODE"));
					beanClass.setCACS_DIVN_CODE(resultSet.getString("CACS_DIVN_CODE"));
					beanClass.setCACS_DEPT_CODE(resultSet.getString("CACS_DEPT_CODE"));
					beanClass.setCACS_ANLY_CODE_1(resultSet.getString("CACS_ANLY_CODE_1"));
					beanClass.setCACS_ANLY_CODE_2(resultSet.getString("CACS_ANLY_CODE_2"));
					beanClass.setCACS_ACTY_CODE_1(resultSet.getString("CACS_ACTY_CODE_1"));
					beanClass.setCACS_ACTY_CODE_2(resultSet.getString("CACS_ACTY_CODE_2"));
					beanClass.setCACS_FRZ_FLAG(resultSet.getString("CACS_FRZ_FLAG"));
					beanClass.setCACS_SETUP_FOR(resultSet.getString("CACS_SETUP_FOR"));
					beanClass.setCACS_ASSURED_TYPE(resultSet.getString("CACS_ASSURED_TYPE"));
					beanClass.setCACS_SRC_BUS_FM(resultSet.getString("CACS_SRC_BUS_FM"));
					beanClass.setCACS_SRC_BUS_TO(resultSet.getString("CACS_SRC_BUS_TO"));
					beanClass.setCACS_PROD_CODE_FM(resultSet.getString("CACS_PROD_CODE_FM"));
					beanClass.setCACS_PROD_CODE_TO(resultSet.getString("CACS_PROD_CODE_TO"));
					beanClass.setCACS_COVER_CODE_FM(resultSet.getString("CACS_COVER_CODE_FM"));
					beanClass.setCACS_COVER_CODE_TO(resultSet.getString("CACS_COVER_CODE_TO"));
					beanClass.setCACS_FIRST_PREM_YN(resultSet.getString("CACS_FIRST_PREM_YN"));
					beanClass.setCACS_CUST_CLS_FM_CODE(resultSet.getString("CACS_CUST_CLS_FM_CODE"));
					beanClass.setCACS_CUST_CLS_TO_CODE(resultSet.getString("CACS_CUST_CLS_TO_CODE"));
					beanClass.setCACS_YRS_FM(resultSet.getInt("CACS_YRS_FM"));
					beanClass.setCACS_YRS_TO(resultSet.getInt("CACS_YRS_TO"));
					
					if(beanClass.getCACS_FRZ_FLAG().equals("Y")){
						beanClass.setFRZ_FLAG(true);
						System.out.println("frz falg is true");
					}else if(beanClass.getCACS_FRZ_FLAG().equals("N")){
						beanClass.setFRZ_FLAG(false);
						System.out.println("frz falg is false");
					}
					new PM_IL_CODES_ACCOUNT_SETUP_ACTION().postQuery(beanClass);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return beanClass;
		}
		
		public int insertAccountSetupDetails(PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup) {
			CRUDHandler handler = new CRUDHandler();
			CommonUtils commonUtils = new CommonUtils();
			ResultSet resultSet = null;
			Connection connection = null;
			int recordsInserted=-1;
			try {
					connection = CommonUtils.getConnection();
					if(pm_il_codes_account_setup.getROWID()!=null){
						
						pm_il_codes_account_setup.setCACS_UPD_DT(commonUtils.getCurrentDate());
						//pm_il_codes_account_setup.setCACS_UPD_UID(commonUtils.getControlBean().getM_USER_ID());//TODO
						pm_il_codes_account_setup.setCACS_UPD_UID("LIFEALL");
					}else{
						pm_il_codes_account_setup.setCACS_CR_DT(commonUtils.getCurrentDate());
						//pm_il_codes_account_setup.setCACS_CR_UID(commonUtils.getControlBean().getM_USER_ID());//TODO
						pm_il_codes_account_setup.setCACS_CR_UID("LIFEALL");
					}
					recordsInserted=handler.executeInsert(pm_il_codes_account_setup, connection);
					
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
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					connection.commit();
					CommonUtils.closeCursor(resultSet);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return recordsInserted;
		}
		
		
		public List<PM_IL_CODES_ACCOUNT_SETUP> cacsTypeCodeToLOV(String query,Object[] object)
		{
		List<PM_IL_CODES_ACCOUNT_SETUP> cacsTypeCodeToList = new ArrayList<PM_IL_CODES_ACCOUNT_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
			{
				Connection connection=CommonUtils.getConnection();
	
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = new PM_IL_CODES_ACCOUNT_SETUP();
					pm_il_codes_account_setup.setCACS_TYPE_TO_CODE(resultSet.getString(1));
					pm_il_codes_account_setup.setUI_M_CACS_TYPE_TO_CODE_DESC(resultSet.getString(2));
					cacsTypeCodeToList.add(pm_il_codes_account_setup);
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
			return cacsTypeCodeToList;
		}
}
