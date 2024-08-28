package com.iii.pel.forms.PILM022;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PREM_ACCOUNT_SETUP_ACTION_DELEGATE {

	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) throws DBException {
	
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
			connection = CommonUtils.getConnection();
			queryString = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$COMBO_BOX$QUERY;
			Object[] values = {formName, blockName, fieldName};
			
			resultSet = handler.executeSelectStatement(queryString, connection, values);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
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
	
		public ArrayList<SelectItem> selectValueForComboBox_PAS_ASSURED_TYPE() throws DBException {
		
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;
			ArrayList<SelectItem> drpDwn = null;
			String queryString = null;

			try {
				connection = CommonUtils.getConnection();
				queryString = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$COMBO_BOX$QUERY$PAS_ASSURED_TYPE;
				Object[] values = {};
				
				resultSet = handler.executeSelectStatement(queryString, connection, values);
				drpDwn = new ArrayList<SelectItem>();
				while (resultSet.next()) {
					SelectItem selectItem = new SelectItem();
					selectItem.setValue(resultSet.getString(1));
					selectItem.setLabel(resultSet.getString(2));
					drpDwn.add(selectItem);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Check Box " +drpDwn);
			return drpDwn;
		}
				
	/**
	 * For inserting records.
	 * @param pm_il_doc_setup
	 * @return int (0)
	 */
	public int insertDocumentSetupDetails(PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup) {
		int rowsUpdated = 0;
		try {
				CRUDHandler handler = new CRUDHandler();
				Connection connection = null;
				connection = CommonUtils.getConnection();
				rowsUpdated = handler.executeInsert(pm_il_prem_account_setup, connection);
				connection.commit();
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
		}
		return rowsUpdated;
	}

	public ArrayList fetchPremiumAccountSetupDetails(PM_IL_PREM_ACCOUNT_SETUP_SEARCH_PAGE pm_il_prem_account_setup_search_page) throws ValidatorException {
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		ArrayList premiumAccountSetupList = new ArrayList();

		try {
			connection = CommonUtils.getConnection();
				String query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$SEARCH_PAGE$QUERY;
				if (pm_il_prem_account_setup_search_page.getMainAccount() != null
						&& pm_il_prem_account_setup_search_page.getMainAccount().trim().length() > 0) {
					if(pm_il_prem_account_setup_search_page.getMainAccount().substring(0, 1).equalsIgnoreCase("%"))
					{
						query = query + " WHERE UPPER(PAS_MAIN_ACNT_CODE) LIKE " + "'%"
						+ pm_il_prem_account_setup_search_page.getMainAccount().toUpperCase() + "'";
					}else{
						query = query + " WHERE UPPER(PAS_MAIN_ACNT_CODE) LIKE " + "'"
							+ pm_il_prem_account_setup_search_page.getMainAccount().toUpperCase() + "%'";
					}
				}
				resultSet = handler.executeSelectStatement(query, connection);
				if (resultSet != null) {
					while (resultSet.next()) {
						PM_IL_PREM_ACCOUNT_SETUP beanClass = new PM_IL_PREM_ACCOUNT_SETUP();

						beanClass.setPAS_MAIN_ACNT_CODE(resultSet.getString("PAS_MAIN_ACNT_CODE"));
						beanClass.setPAS_SUB_ACNT_CODE(resultSet.getString("PAS_SUB_ACNT_CODE"));
						beanClass.setPAS_DIVN_CODE(resultSet.getString("PAS_DIVN_CODE"));
						beanClass.setROWID(resultSet.getString("ROWID"));
						premiumAccountSetupList.add(beanClass);
					}
				}
			} catch (Exception e) {
				//e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return premiumAccountSetupList;
	}
	
	public Object fetchPremiumSetupDetails(String rowId, Object obj) throws DBException {

		PM_IL_PREM_ACCOUNT_SETUP beanClass = (PM_IL_PREM_ACCOUNT_SETUP) obj;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		
		try {
			connection = CommonUtils.getConnection();
			String query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$SEARCH_PAGE$NAVIGATETOMAIN$QUERY;
			System.out.println("Query:::"+query+"   ROWID:::::::"+rowId);
			
			Object values[] = {rowId};
			resultSet = handler.executeSelectStatement(query, connection, values);
			while (resultSet.next()) {
				
				beanClass.setPAS_BUS_FM_CODE(resultSet.getString("PAS_BUS_FM_CODE"));
				beanClass.setPAS_BUS_TO_CODE(resultSet.getString("PAS_BUS_TO_CODE"));
				beanClass.setPAS_DIVN_FM_CODE(resultSet.getString("PAS_DIVN_FM_CODE"));
				beanClass.setPAS_DIVN_TO_CODE(resultSet.getString("PAS_DIVN_TO_CODE"));
				beanClass.setPAS_DEPT_FM_CODE(resultSet.getString("PAS_DEPT_FM_CODE"));
				beanClass.setPAS_DEPT_TO_CODE(resultSet.getString("PAS_DEPT_TO_CODE"));
				beanClass.setPAS_DOC_FM_TYPE(resultSet.getString("PAS_DOC_FM_TYPE"));
				beanClass.setPAS_DOC_TO_TYPE(resultSet.getString("PAS_DOC_TO_TYPE"));
				beanClass.setPAS_FORCE_DIVN_YN(resultSet.getString("PAS_FORCE_DIVN_YN"));
				beanClass.setPAS_FORCE_DEPT_YN(resultSet.getString("PAS_FORCE_DEPT_YN"));
				beanClass.setPAS_MAIN_ACNT_CODE(resultSet.getString("PAS_MAIN_ACNT_CODE"));
				beanClass.setPAS_SUB_ACNT_CODE(resultSet.getString("PAS_SUB_ACNT_CODE"));
				beanClass.setPAS_DIVN_CODE(resultSet.getString("PAS_DIVN_CODE"));
				beanClass.setPAS_DEPT_CODE(resultSet.getString("PAS_DEPT_CODE"));
				beanClass.setPAS_ANLY_CODE_1(resultSet.getString("PAS_ANLY_CODE_1"));
				beanClass.setPAS_ANLY_CODE_2(resultSet.getString("PAS_ANLY_CODE_2"));
				beanClass.setPAS_ACTY_CODE_1(resultSet.getString("PAS_ACTY_CODE_1"));
				beanClass.setPAS_ACTY_CODE_2(resultSet.getString("PAS_ACTY_CODE_2"));
				beanClass.setPAS_FRZ_FLAG(resultSet.getString("PAS_FRZ_FLAG"));
				beanClass.setPAS_CR_DT(resultSet.getDate("PAS_CR_DT"));
				beanClass.setPAS_CR_UID(resultSet.getString("PAS_CR_UID"));
				beanClass.setPAS_UPD_DT(resultSet.getDate("PAS_UPD_DT"));
				beanClass.setPAS_UPD_UID(resultSet.getString("PAS_UPD_UID"));
				beanClass.setPAS_PLAN_TYPE(resultSet.getString("PAS_PLAN_TYPE"));
				beanClass.setPAS_PLAN_CODE_FM(resultSet.getString("PAS_PLAN_CODE_FM"));
				beanClass.setPAS_PLAN_CODE_TO(resultSet.getString("PAS_PLAN_CODE_TO"));
				beanClass.setPAS_PLAN_YRS_FM(resultSet.getInt("PAS_PLAN_YRS_FM"));
				beanClass.setPAS_PLAN_YRS_TO(resultSet.getInt("PAS_PLAN_YRS_TO"));
				beanClass.setPAS_ASSURED_TYPE(resultSet.getString("PAS_ASSURED_TYPE"));
				beanClass.setPAS_SRC_BUS_FM(resultSet.getString("PAS_SRC_BUS_FM"));
				beanClass.setPAS_SRC_BUS_TO(resultSet.getString("PAS_SRC_BUS_TO"));
				beanClass.setPAS_PROD_CODE_FM(resultSet.getString("PAS_PROD_CODE_FM"));
				beanClass.setPAS_PROD_CODE_TO(resultSet.getString("PAS_PROD_CODE_TO"));
				beanClass.setPAS_END_FM_CODE(resultSet.getString("PAS_END_FM_CODE"));
				beanClass.setPAS_END_TO_CODE(resultSet.getString("PAS_END_TO_CODE"));
				beanClass.setPAS_NB_END_FLAG(resultSet.getString("PAS_NB_END_FLAG"));
				beanClass.setPAS_FIRST_PREM_YN(resultSet.getString("PAS_FIRST_PREM_YN"));
				beanClass.setPAS_CUST_CLS_FM_CODE(resultSet.getString("PAS_CUST_CLS_FM_CODE"));
				beanClass.setPAS_CUST_CLS_TO_CODE(resultSet.getString("PAS_CUST_CLS_TO_CODE"));
				beanClass.setROWID(resultSet.getString("ROWID"));
				
				filedDescriptionSet(beanClass);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanClass;
	}

	/*
	 * Suggestion Box for Source Business Range
	 */
	public List prepareSourceBusinessRangeList(String sourceBusinessRangeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
		String query = null;
		Connection connection = CommonUtils.getConnection();
		if ("*".equalsIgnoreCase(sourceBusinessRangeCode)) {
			query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_SRC_BUS_FM$LOV1;
			Object[] object={};
			PM_IL_PREM_ACCOUNT_SETUP_LIST = sourceBusinessRangeLOV(connection, query, object);

		} else {
			sourceBusinessRangeCode = sourceBusinessRangeCode + "%";
			Object[] object={sourceBusinessRangeCode.toUpperCase()};
			query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_SRC_BUS_FM$LOV2;
			PM_IL_PREM_ACCOUNT_SETUP_LIST = sourceBusinessRangeLOV(connection, query, object);
		}
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	 public List sourceBusinessRangeLOV(Connection connection, String query, Object[] object)
		{
		 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
					pm_il_prem_account_setup.setPAS_SRC_BUS_FM(resultSet.getString(1));
					pm_il_prem_account_setup.setPAS_SRC_BUS_FM_DESC(resultSet.getString(2));
					PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
				}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PM_IL_PREM_ACCOUNT_SETUP_LIST;
	}
	
	 /*
	  * Suggestion Box for Source Business Range Upto 
	  */
		public List prepareSourceBusinessRangeUptoList(String sourceBusinessRangeUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(sourceBusinessRangeUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_SRC_BUS_TO$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = sourceBusinessRangeUptoLOV(connection, query, object);

			} else {
				sourceBusinessRangeUptoCode = sourceBusinessRangeUptoCode + "%";
				Object[] object={sourceBusinessRangeUptoCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_SRC_BUS_TO$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = sourceBusinessRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		 public List sourceBusinessRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_SRC_BUS_TO(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_SRC_BUS_TO_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		 
		/*
		 * Suggestion Box for Business Range
		 */ 
		public List prepareBusinessRangeList(String businessRangeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
				String query = null;
				CRUDHandler handler = new CRUDHandler();
				CRUDHandler dbHandler = new CRUDHandler();
				Connection connection = CommonUtils.getConnection();
				if ("*".equalsIgnoreCase(businessRangeCode)) {
					query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_BUS_FM_CODE$LOV1;
					Object[] object={};
					PM_IL_PREM_ACCOUNT_SETUP_LIST = businessRangeLOV(connection, query, object);

				} else {
					businessRangeCode = businessRangeCode + "%";
					Object[] object={businessRangeCode.toUpperCase()};
					query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_BUS_FM_CODE$LOV2;
					PM_IL_PREM_ACCOUNT_SETUP_LIST = businessRangeLOV(connection, query, object);
				}
				return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
			
		public List businessRangeLOV(Connection connection, String query, Object[] object)
				{
				 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
				 	CRUDHandler handler = new CRUDHandler();
				 	ResultSet resultSet = null;
					try
					{
						resultSet=handler.executeSelectStatement(query, connection, object);
						while(resultSet.next())
						{
							PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
							pm_il_prem_account_setup.setPAS_BUS_FM_CODE(resultSet.getString(1));
							pm_il_prem_account_setup.setPAS_BUS_FM_CODE_DESC(resultSet.getString(2));
							PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
						}
					}
					catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						new CommonUtils().closeCursor(resultSet);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
				return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Business Range Upto.
		 */
		public List prepareBusinessRangeUptoList(String businessRangeUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(businessRangeUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_BUS_TO_CODE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = businessRangeUptoLOV(connection, query, object);

			} else {
				businessRangeUptoCode = businessRangeUptoCode + "%";
				Object[] object={businessRangeUptoCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_BUS_TO_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = businessRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List businessRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_BUS_TO_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_BUS_TO_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Branch Range
		 */
		public List prepareBranchRangeList(String branchRangeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String companyCode = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$COMPANY_CODE;
			if ("*".equalsIgnoreCase(branchRangeCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$LOV1;
				Object[] object={companyCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = branchRangeLOV(connection, query, object);

			} else {
				branchRangeCode = branchRangeCode + "%";
				Object[] object={companyCode, branchRangeCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = branchRangeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List branchRangeLOV(Connection connection, String query, Object[] object)
		{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DIVN_FM_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_DIVN_FM_CODE_DESC(resultSet.getString(2));
						System.out.println("COde" +resultSet.getString(1));
						System.out.println("" +resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Business Range Upto.
		 */
		public List prepareBranchRangeUptoList(String branchRangeUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String companyCode = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$COMPANY_CODE;
			if ("*".equalsIgnoreCase(branchRangeUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_TO_CODE$LOV1;
				Object[] object={companyCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = branchRangeUptoLOV(connection, query, object);

			} else {
				branchRangeUptoCode = branchRangeUptoCode + "%";
				Object[] object={companyCode, branchRangeUptoCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_TO_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = branchRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List branchRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DIVN_TO_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_DIVN_TO_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}

		/*
		 * Suggestion Box for Department Range.
		 */
		public List prepareDeptRangeList(String deptRangeCode, String branchRangeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String companyCode = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$COMPANY_CODE;
			if ("*".equalsIgnoreCase(deptRangeCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DEPT_FM_CODE$LOV1;
				Object[] object={companyCode, branchRangeCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = deptRangeLOV(connection, query, object);

			} else {
				deptRangeCode = deptRangeCode + "%";
				Object[] object={companyCode, branchRangeCode, deptRangeCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DEPT_FM_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = deptRangeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List deptRangeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DEPT_FM_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_DEPT_FM_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}

		/*
		 * Suggestion Box for Department Range Upto.
		 */
		public List prepareDeptRangeUptoList(String deptRangeUptoCode, String branchRangeUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String companyCode = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$COMPANY_CODE;
			if ("*".equalsIgnoreCase(deptRangeUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DEPT_TO_CODE$LOV1;
				Object[] object={companyCode, branchRangeUptoCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = deptRangeUptoLOV(connection, query, object);

			} else {
				deptRangeUptoCode = deptRangeUptoCode + "%";
				Object[] object={companyCode, branchRangeUptoCode, deptRangeUptoCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DEPT_TO_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = deptRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List deptRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DEPT_TO_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_DEPT_TO_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Document Type Range.
		 */
		public List prepareDocTypeRangeList(String docTypeRangeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(docTypeRangeCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DOC_FM_TYPE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = docTypeRangeLOV(connection, query, object);

			} else {
				docTypeRangeCode = docTypeRangeCode + "%";
				Object[] object={docTypeRangeCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DOC_FM_TYPE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = docTypeRangeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List docTypeRangeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DOC_FM_TYPE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_DOC_FM_TYPE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}

		/*
		 * Suggestion Box for Document Type Range Upto.
		 */
		public List prepareDocTypeRangeUptoList(String docTypeRangeUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(docTypeRangeUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DOC_TO_TYPE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = docTypeRangeUptoLOV(connection, query, object);

			} else {
				docTypeRangeUptoCode = docTypeRangeUptoCode + "%";
				Object[] object={docTypeRangeUptoCode.toUpperCase()};
				System.out.println("docTypeRangeUptoCode.toUpperCase()" +docTypeRangeUptoCode.toUpperCase());
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DOC_TO_TYPE$LOV2;
				System.out.println("QUERY" +query);
				PM_IL_PREM_ACCOUNT_SETUP_LIST = docTypeRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List docTypeRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DOC_TO_TYPE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_DOC_TO_TYPE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Product Range.
		 */
		public List prepareProductRangeList(String productCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(productCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PROD_CODE_FM$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = productRangeLOV(connection, query, object);

			} else {
				productCode = productCode + "%";
				Object[] object={productCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PROD_CODE_FM$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = productRangeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List productRangeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_PROD_CODE_FM(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_PROD_CODE_FM_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Product Range Upto.
		 */
		public List prepareProductRangeUptoList(String productUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(productUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PROD_CODE_TO$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = productRangeUptoLOV(connection, query, object);

			} else {
				productUptoCode = productUptoCode + "%";
				Object[] object={productUptoCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PROD_CODE_TO$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = productRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List productRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_PROD_CODE_TO(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_PROD_CODE_TO_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Plan Code.
		 */
		public List preparePlanCodeList(String planCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST,
				PM_IL_PREM_ACCOUNT_SETUP_ACTION action) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String productFrom = action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_FM();
			String productTo = action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_TO();
			if ("*".equalsIgnoreCase(planCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PLAN_CODE_FM$LOV1;
				Object[] object={productFrom,productTo};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = planCodeLOV(connection, query, object);

			} else {
				planCode = planCode + "%";
				Object[] object={planCode.toUpperCase(),productFrom,productTo};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PLAN_CODE_FM$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = planCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List planCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_PLAN_CODE_FM(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_PLAN_CODE_FM_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Plan Code Upto.
		 */
		public List preparePlanCodeUptoList(String planCodeUpto, List PM_IL_PREM_ACCOUNT_SETUP_LIST, PM_IL_PREM_ACCOUNT_SETUP_ACTION action) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String productFrom = action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_FM();
			String productTo = action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_TO();
			if ("*".equalsIgnoreCase(planCodeUpto)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PLAN_CODE_TO$LOV1;
				Object[] object={productFrom,productTo};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = planCodeUptoLOV(connection, query, object);

			} else {
				planCodeUpto = planCodeUpto + "%";
				Object[] object={planCodeUpto.toUpperCase(),productFrom,productTo};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PLAN_CODE_TO$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = planCodeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List planCodeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_PLAN_CODE_TO(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_PLAN_CODE_TO_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		
		/*
		 * Suggestion Box for Class Range.
		 */
		public List prepareClassRangeList(String classRangeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(classRangeCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_CUST_CLS_FM_CODE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = classRangeLOV(connection, query, object);

			} else {
				classRangeCode = classRangeCode + "%";
				Object[] object={classRangeCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_CUST_CLS_FM_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = classRangeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List classRangeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_CUST_CLS_FM_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_CUST_CLS_FM_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Class Range Upto.
		 */
		public List prepareClassRangeUptoList(String classRangeUptoCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(classRangeUptoCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_CUST_CLS_TO_CODE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = classRangeUptoLOV(connection, query, object);

			} else {
				classRangeUptoCode = classRangeUptoCode + "%";
				Object[] object={classRangeUptoCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_CUST_CLS_TO_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = classRangeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List classRangeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_CUST_CLS_TO_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_CUST_CLS_TO_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Endorsement Code.
		 */
		public List prepareEndorsementCodeList(String endorsementCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(endorsementCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_END_FM_CODE$LOV1;
				System.out.println("QUERY:::"+query);
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = endorsementCodeLOV(connection, query, object);

			} else {
				endorsementCode = endorsementCode + "%";
				Object[] object={endorsementCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_END_FM_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = endorsementCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List endorsementCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_END_FM_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_END_FM_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Endorsement Code Upto.
		 */
		public List prepareEndorsementCodeUptoList(String endorsementCodeUpto, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(endorsementCodeUpto)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_END_TO_CODE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = endorsementCodeUptoLOV(connection, query, object);

			} else {
				endorsementCodeUpto = endorsementCodeUpto + "%";
				Object[] object={endorsementCodeUpto.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_END_TO_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = endorsementCodeUptoLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List endorsementCodeUptoLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_END_TO_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setPAS_END_TO_CODE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Plan Code.
		 */
		public List preparePlanTypeCodeList(String planTypeCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(planTypeCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PLAN_TYPE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = planTypeCodeLOV(connection, query, object);

			} else {
				planTypeCode = planTypeCode + "%";
				Object[] object={planTypeCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_PLAN_TYPE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = planTypeCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List planTypeCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_PLAN_TYPE(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_PAS_PLAN_TYPE_DESC(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Main Account.
		 */
		public List prepareMainAccountCodeList(String mainAccountCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(mainAccountCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_MAIN_ACNT_CODE$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = mainAccountCodeLOV(connection, query, object);
 
			} else {
				mainAccountCode = mainAccountCode + "%";
				Object[] object={mainAccountCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_MAIN_ACNT_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = mainAccountCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List mainAccountCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_MAIN_ACNT_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_MAIN_ACNT_NAME(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Sub Account.
		 */
		public List prepareSubAccountCodeList(String mainAccountCode, String subAccountCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(subAccountCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_SUB_ACNT_CODE$LOV1;
				System.out.println("mainAccountCode%%%%%%%%%%%%%%%%%%%**************"+mainAccountCode);
				Object[] object={mainAccountCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = subAccountCodeLOV(connection, query, object);
				
			} else {
				subAccountCode = subAccountCode + "%";
				Object[] object={mainAccountCode, subAccountCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_SUB_ACNT_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = subAccountCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List subAccountCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					System.out.println("Query:"+query);
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_SUB_ACNT_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_SUB_ACNT_NAME(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Division Account.
		 */
		public List prepareDivisionCodeList(String divisionCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String companyCode = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$COMPANY_CODE;
			if ("*".equalsIgnoreCase(divisionCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_CODE$LOV1;
				Object[] object={companyCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = divisionCodeLOV(connection, query, object);
 
			} else {
				divisionCode = divisionCode + "%";
				Object[] object={companyCode, divisionCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = divisionCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List divisionCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DIVN_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_DIVN_NAME(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Dept Code.
		 */
		public List prepareDeptCodeList(String divisionCode, String deptCode, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			String companyCode = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DIVN_FM_CODE$COMPANY_CODE;
			if ("*".equalsIgnoreCase(deptCode)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DEPT_CODE$LOV1;
				Object[] object={companyCode, divisionCode};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = deptCodeLOV(connection, query, object);
 
			} else {
				deptCode = deptCode + "%";
				Object[] object={companyCode, divisionCode, deptCode.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_DEPT_CODE$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = deptCodeLOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List deptCodeLOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_DEPT_CODE(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_DEPT_NAME(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Analysis Code 1.
		 */
		public List prepareAnalysisCode1List(String analysisCode1, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(analysisCode1)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ANLY_CODE_1$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = analysisCode1LOV(connection, query, object);
 
			} else {
				analysisCode1 = analysisCode1 + "%";
				Object[] object={analysisCode1.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ANLY_CODE_1$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = analysisCode1LOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List analysisCode1LOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_ANLY_CODE_1(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_ANLY_NAME(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Analysis Code 2.
		 */
		public List prepareAnalysisCode2List(String analysisCode2, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(analysisCode2)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ANLY_CODE_2$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = analysisCode2LOV(connection, query, object);
 
			} else {
				analysisCode2 = analysisCode2 + "%";
				Object[] object={analysisCode2.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ANLY_CODE_2$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = analysisCode2LOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List analysisCode2LOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_ANLY_CODE_2(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_ANLY_NAME_1(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Activity Code 1.
		 */
		public List prepareActivityCode1List(String activityCode1, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(activityCode1)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ACTY_CODE_1$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = activityCode1LOV(connection, query, object);
 
			} else {
				activityCode1 = activityCode1 + "%";
				Object[] object={activityCode1.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ACTY_CODE_1$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = activityCode1LOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List activityCode1LOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_ACTY_CODE_1(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_ACTY_NAME(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		/*
		 * Suggestion Box for Activity Code 2.
		 */
		public List prepareActivityCode2List(String activityCode2, List PM_IL_PREM_ACCOUNT_SETUP_LIST) throws DBException{
			String query = null;
			CRUDHandler handler = new CRUDHandler();
			CRUDHandler dbHandler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(activityCode2)) {
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ACTY_CODE_2$LOV1;
				Object[] object={};
				PM_IL_PREM_ACCOUNT_SETUP_LIST = activityCode2LOV(connection, query, object);
 
			} else {
				activityCode2 = activityCode2 + "%";
				Object[] object={activityCode2.toUpperCase()};
				query = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_ACTY_CODE_2$LOV2;
				PM_IL_PREM_ACCOUNT_SETUP_LIST = activityCode2LOV(connection, query, object);
			}
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public List activityCode2LOV(Connection connection, String query, Object[] object)
			{
			 	List PM_IL_PREM_ACCOUNT_SETUP_LIST = new ArrayList();
			 	CRUDHandler handler = new CRUDHandler();
			 	ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query, connection, object);
					while(resultSet.next())
					{
						PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
						pm_il_prem_account_setup.setPAS_ACTY_CODE_2(resultSet.getString(1));
						pm_il_prem_account_setup.setUI_M_ACTY_NAME_1(resultSet.getString(2));
						PM_IL_PREM_ACCOUNT_SETUP_LIST.add(pm_il_prem_account_setup);
					}
				}
				catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Size" +PM_IL_PREM_ACCOUNT_SETUP_LIST.size());
			return PM_IL_PREM_ACCOUNT_SETUP_LIST;
		}
		
		public ArrayList endorsementCodeQuery(String PAS_END_FM_CODE_STRING) throws DBException {
		
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;
			connection = CommonUtils.getConnection();
			ArrayList endorsementArraylist = null;
			String queryString = null;

			try {
				queryString = PM_IL_PREM_ACCOUNT_SETUP_CONSTANTS.PILM022$PM_IL_PREM_ACCOUNT$PAS_END_CODE;
				Object[] values = {PAS_END_FM_CODE_STRING};
				
				resultSet = handler.executeSelectStatement(queryString, connection, values);
				endorsementArraylist = new ArrayList();
				while (resultSet.next()) {
					
					endorsementArraylist.add(resultSet.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return endorsementArraylist;
		}
		
		public ArrayList<String> P_VAL_ACTY(String PAS_ACTY_CODE_1)
	            throws SQLException, Exception {
	        Connection connection = null;
	        connection = CommonUtils.getConnection();

	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        ArrayList<String> returnList = new ArrayList<String>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN","1");
	        OracleParameter param2 = new OracleParameter("IN1", "STRING", "IN",PAS_ACTY_CODE_1);
	        OracleParameter param3 = new OracleParameter("IN OUT2", "STRING", "IN OUT","1");
	        OracleParameter param4 = new OracleParameter("IN3", "STRING", "IN","N");
	        OracleParameter param5 = new OracleParameter("IN4", "STRING", "IN","E");
	        parameterList.add(param1);
	        parameterList.add(param2);
	        parameterList.add(param3);
	        parameterList.add(param4);
	        parameterList.add(param5);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.execute(parameterList, connection,
	                "P_VAL_ACTY");
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            if (oracleParameter.getValue() != null) {
	                returnList.add(oracleParameter.getValue());
	            }
	        }
	        return returnList;
	    }
		
		public ArrayList L_OVERLAP_CHECK(PM_IL_PREM_ACCOUNT_SETUP_ACTION pm_il_prem_account_setup_action) throws DBException{
		
			String PAS_BUS_FM_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_BUS_FM_CODE();
			String PAS_BUS_TO_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_BUS_TO_CODE();
			String PAS_DIVN_FM_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DIVN_FM_CODE();
			String PAS_DIVN_TO_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DIVN_TO_CODE();
			String PAS_DEPT_FM_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DEPT_FM_CODE();
			String PAS_DEPT_TO_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DEPT_TO_CODE();
			String PAS_DOC_FM_TYPE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DOC_FM_TYPE();
			String PAS_DOC_TO_TYPE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_DOC_TO_TYPE();
			String PAS_PROD_CODE_FM_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_FM();
			String PAS_PROD_CODE_TO_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PROD_CODE_TO();
			String PAS_PLAN_CODE_FM_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PLAN_CODE_FM();
			String PAS_PLAN_CODE_TO_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PLAN_CODE_TO();
			String PAS_SRC_BUS_FM_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_SRC_BUS_FM();
			String PAS_SRC_BUS_TO_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_SRC_BUS_TO();
			String PAS_END_FM_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_FM_CODE();
			String PAS_END_TO_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_END_TO_CODE();
			String PAS_CUST_CLS_FM_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_CUST_CLS_FM_CODE();
			String PAS_CUST_CLS_TO_CODE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_CUST_CLS_TO_CODE();
			String PAS_ASSURED_TYPE_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_ASSURED_TYPE();
			String PAS_FIRST_PREM_YN_STRING = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_FIRST_PREM_YN();
			int PAS_PLAN_YRS_FM_DOUBLE = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PLAN_YRS_FM();
			int PAS_PLAN_YRS_TO_DOUBLE = pm_il_prem_account_setup_action.getPM_IL_PREM_ACCOUNT_SETUP_BEAN().getPAS_PLAN_YRS_TO();
				
			String PILM022$PM_IL_PREM_ACCOUNT$PRE_INSERT = "SELECT 'X' FROM  PM_IL_PREM_ACCOUNT_SETUP  WHERE  (PAS_BUS_FM_CODE  BETWEEN '"+PAS_BUS_FM_CODE_STRING+"'  AND  '"+PAS_BUS_TO_CODE_STRING+"'  OR PAS_BUS_TO_CODE  BETWEEN '"+PAS_BUS_FM_CODE_STRING+"'  AND  '"+PAS_BUS_TO_CODE_STRING+"'  OR PAS_BUS_FM_CODE BETWEEN '"+PAS_BUS_FM_CODE_STRING+"' AND '"+PAS_BUS_TO_CODE_STRING+"'  OR PAS_BUS_TO_CODE BETWEEN '"+PAS_BUS_FM_CODE_STRING+"' AND '"+PAS_BUS_TO_CODE_STRING+"')  " +
			"	AND (PAS_DIVN_FM_CODE  BETWEEN '"+PAS_DIVN_FM_CODE_STRING+"'  AND '"+PAS_DIVN_TO_CODE_STRING+"'   OR PAS_DIVN_TO_CODE  BETWEEN '"+PAS_DIVN_FM_CODE_STRING+"'  AND '"+PAS_DIVN_TO_CODE_STRING+"'   OR PAS_DIVN_FM_CODE BETWEEN '"+PAS_DIVN_FM_CODE_STRING+"'   AND '"+PAS_DIVN_TO_CODE_STRING+"'   OR PAS_DIVN_TO_CODE BETWEEN '"+PAS_DIVN_FM_CODE_STRING+"'   AND '"+PAS_DIVN_TO_CODE_STRING+"')  " +
			"   AND (PAS_DEPT_FM_CODE  BETWEEN '"+PAS_DEPT_FM_CODE_STRING+"'  AND '"+PAS_DEPT_TO_CODE_STRING+"'   OR PAS_DEPT_TO_CODE  BETWEEN '"+PAS_DEPT_FM_CODE_STRING+"'  AND  '"+PAS_DEPT_TO_CODE_STRING+"'  OR PAS_DEPT_FM_CODE  BETWEEN '"+PAS_DEPT_FM_CODE_STRING+"'  AND  '"+PAS_DEPT_TO_CODE_STRING+"'  OR PAS_DEPT_TO_CODE  BETWEEN  '"+PAS_DEPT_FM_CODE_STRING+"'  AND  '"+PAS_DEPT_TO_CODE_STRING+"')  " +
			"	AND (PAS_DOC_FM_TYPE   BETWEEN '"+PAS_DOC_FM_TYPE_STRING+"'   AND '"+PAS_DOC_TO_TYPE_STRING+"'    OR PAS_DOC_TO_TYPE BETWEEN '"+PAS_DOC_FM_TYPE_STRING+"' AND  '"+PAS_DOC_TO_TYPE_STRING+"'   OR PAS_DOC_FM_TYPE   BETWEEN '"+PAS_DOC_FM_TYPE_STRING+"'   AND  '"+PAS_DOC_TO_TYPE_STRING+"'   OR PAS_DOC_TO_TYPE   BETWEEN '"+PAS_DOC_FM_TYPE_STRING+"'   AND  '"+PAS_DOC_TO_TYPE_STRING+"')  " +
			"	AND (PAS_PROD_CODE_FM  BETWEEN '"+PAS_PROD_CODE_FM_STRING+"'  AND  '"+PAS_PROD_CODE_TO_STRING+"'  OR PAS_PROD_CODE_TO  BETWEEN '"+PAS_PROD_CODE_FM_STRING+"'  AND  '"+PAS_PROD_CODE_TO_STRING+"'  OR PAS_PROD_CODE_FM  BETWEEN '"+PAS_PROD_CODE_FM_STRING+"'  AND  '"+PAS_PROD_CODE_TO_STRING+"'  OR PAS_PROD_CODE_TO  BETWEEN '"+PAS_PROD_CODE_FM_STRING+"'  AND  '"+PAS_PROD_CODE_TO_STRING+"')  " +
			"	AND (PAS_PLAN_CODE_FM  BETWEEN '"+PAS_PLAN_CODE_FM_STRING+"'  AND  '"+PAS_PLAN_CODE_TO_STRING+"'  OR PAS_PLAN_CODE_TO  BETWEEN '"+PAS_PLAN_CODE_FM_STRING+"'  AND  '"+PAS_PLAN_CODE_TO_STRING+"'  OR PAS_PLAN_CODE_FM  BETWEEN '"+PAS_PLAN_CODE_FM_STRING+"'     AND  '"+PAS_PLAN_CODE_TO_STRING+"'  OR PAS_PLAN_CODE_TO  BETWEEN '"+PAS_PLAN_CODE_FM_STRING+"'  AND  '"+PAS_PLAN_CODE_TO_STRING+"')  " +
			"	AND (PAS_PLAN_YRS_FM   BETWEEN '"+PAS_PLAN_YRS_FM_DOUBLE+"'   AND  '"+PAS_PLAN_YRS_TO_DOUBLE+"'   OR PAS_PLAN_YRS_TO   BETWEEN '"+PAS_PLAN_YRS_FM_DOUBLE+"'   AND  '"+PAS_PLAN_YRS_TO_DOUBLE+"'   OR PAS_PLAN_YRS_FM   BETWEEN '"+PAS_PLAN_YRS_FM_DOUBLE+"'   AND  '"+PAS_PLAN_YRS_TO_DOUBLE+"'   OR PAS_PLAN_YRS_TO   BETWEEN '"+PAS_PLAN_YRS_FM_DOUBLE+"'   AND  '"+PAS_PLAN_YRS_TO_DOUBLE+"')  " +
			"	AND (PAS_SRC_BUS_FM    BETWEEN '"+PAS_SRC_BUS_FM_STRING+"'    AND  '"+PAS_SRC_BUS_TO_STRING+"'    OR PAS_SRC_BUS_TO    BETWEEN '"+PAS_SRC_BUS_FM_STRING+"'    AND  '"+PAS_SRC_BUS_TO_STRING+"'    OR PAS_SRC_BUS_FM    BETWEEN '"+PAS_SRC_BUS_FM_STRING+"'    AND  '"+PAS_SRC_BUS_TO_STRING+"'    OR PAS_SRC_BUS_TO    BETWEEN '"+PAS_SRC_BUS_FM_STRING+"'    AND  '"+PAS_SRC_BUS_TO_STRING+"')  " +
			"	AND (PAS_END_FM_CODE   BETWEEN '"+PAS_END_FM_CODE_STRING+"'   AND  '"+PAS_END_TO_CODE_STRING+"'   OR PAS_END_TO_CODE   BETWEEN '"+PAS_END_FM_CODE_STRING+"'   AND  '"+PAS_END_TO_CODE_STRING+"'   OR PAS_END_FM_CODE   BETWEEN '"+PAS_END_FM_CODE_STRING+"'   AND  '"+PAS_END_TO_CODE_STRING+"'   OR PAS_END_TO_CODE   BETWEEN '"+PAS_END_FM_CODE_STRING+"'   AND  '"+PAS_END_TO_CODE_STRING+"' OR PAS_NB_END_FLAG  = 'N')  " +
			"	AND (PAS_CUST_CLS_FM_CODE  BETWEEN '"+PAS_CUST_CLS_FM_CODE_STRING+"'  AND  '"+PAS_CUST_CLS_TO_CODE_STRING+"'  OR PAS_CUST_CLS_TO_CODE  BETWEEN '"+PAS_CUST_CLS_FM_CODE_STRING+"'  AND  '"+PAS_CUST_CLS_FM_CODE_STRING+"'  OR PAS_CUST_CLS_FM_CODE  BETWEEN '"+PAS_CUST_CLS_FM_CODE_STRING+"'  AND  '"+PAS_CUST_CLS_TO_CODE_STRING+"'  OR PAS_CUST_CLS_TO_CODE  BETWEEN '"+PAS_CUST_CLS_FM_CODE_STRING+"'  AND  '"+PAS_CUST_CLS_TO_CODE_STRING+"')  " +
			"	AND PAS_ASSURED_TYPE  = '"+PAS_CUST_CLS_TO_CODE_STRING+"'   AND PAS_FIRST_PREM_YN  = '"+PAS_FIRST_PREM_YN_STRING+"' ";

			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;
			connection = CommonUtils.getConnection();
			ArrayList overLapArraylist = null;
			String queryString = null;

			try {
				queryString = PILM022$PM_IL_PREM_ACCOUNT$PRE_INSERT;
				Object[] values = {};
				resultSet = handler.executeSelectStatement(queryString, connection, values);
				overLapArraylist = new ArrayList();
				while (resultSet.next()) {
					
					overLapArraylist.add(resultSet.getString(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Array List  " +overLapArraylist);
			return overLapArraylist;
		}
		
		public ArrayList P_VAL_MAIN_ACNT(String P_MAIN_ACNT_CODE, String P_NAME_FLAG, String P_ERR_FLAG)
	            throws SQLException, Exception {
	        Connection connection = null;
//	        ConnectionAgent connectionAgent = new ConnectionAgent();
	        connection = CommonUtils.getConnection();

	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        ArrayList<String> returnList = new ArrayList<String>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MAIN_ACNT_CODE);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT","1");
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	        parameterList.add(param4);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        outputList = procHandler.execute(parameterList, connection,
	                "P_VAL_MAIN_ACNT");
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	            if (oracleParameter.getValue() != null) {
	                returnList.add(oracleParameter.getValue());
	            }
	        }
	        return returnList;
	    }

		public void filedDescriptionSet(PM_IL_PREM_ACCOUNT_SETUP setupBean){
			String mainAccountDesc = null;
			String subAcntCodeDesc = null;
			String divnCodeDesc = null;
			String deptCodeDesc = null;
			String analysisDesc = null;
			String activityDesc01 = null;
			String activityDesc02 = null;
			
			String mainAccountQuery = "SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE = ?";
			String subAcntQuery = "SELECT SUB_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE NVL(SUB_FRZ_FLAG,'N') = 'N' AND SUB_ACNT_CODE = ?";
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
			String divnCodeQuery = "SELECT DIVN_NAME FROM FM_DIVISION WHERE NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE=?";
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			String deptCodeQuery = "SELECT DEPT_NAME FROM FM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND DEPT_CODE =  ?";
			String analysisQuery = "SELECT ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND ANLY_CODE = ?";
			String activityQuery01 = "SELECT PROD_DESC FROM PM_GL_PRODUCT WHERE 1=1 AND PROD_CODE LIKE ?";
			String activityQuery02 = "SELECT PROD_DESC FROM PM_GL_PRODUCT WHERE 1=1 AND PROD_CODE LIKE ?";
			
			mainAccountDesc = fetchMainAccountDesc(setupBean.getPAS_MAIN_ACNT_CODE(), mainAccountQuery, "MAIN_ACNT_NAME");
			subAcntCodeDesc = fetchMainAccountDesc(setupBean.getPAS_SUB_ACNT_CODE(), subAcntQuery, "SUB_ACNT_NAME");
			divnCodeDesc = fetchMainAccountDesc(setupBean.getPAS_DIVN_CODE(), divnCodeQuery, "DIVN_NAME");
			deptCodeDesc = fetchMainAccountDesc(setupBean.getPAS_DEPT_CODE(), deptCodeQuery, "DEPT_NAME");
			analysisDesc = fetchMainAccountDesc(setupBean.getPAS_ANLY_CODE_1(), analysisQuery, "ANLY_NAME");
			activityDesc01 = fetchMainAccountDesc(setupBean.getPAS_ACTY_CODE_1(), activityQuery01, "PROD_DESC");
			activityDesc02 = fetchMainAccountDesc(setupBean.getPAS_ACTY_CODE_2(), activityQuery02, "PROD_DESC");
			
			System.out.println("divnCodeDesc`````````````````~~~~~~~~~~~~~~~~~~"+divnCodeDesc);
			System.out.println("deptCodeDesc#################################"+deptCodeDesc);
			setupBean.setUI_M_MAIN_ACNT_NAME(mainAccountDesc);
			setupBean.setUI_M_SUB_ACNT_NAME(subAcntCodeDesc);
			setupBean.setUI_M_DIVN_NAME(divnCodeDesc);
			setupBean.setUI_M_DEPT_NAME(deptCodeDesc);
			setupBean.setUI_M_ANLY_NAME(analysisDesc);
			setupBean.setUI_M_ACTY_NAME(activityDesc01);
			setupBean.setUI_M_ACTY_NAME_1(activityDesc02);
		}
		public String fetchMainAccountDesc(String mainAccountCode,String selectQuery,String filedValue){
			String assignValue = null;
			Connection con = null;
			ResultSet rst = null;
			CRUDHandler handler = null;
			try {
				con = CommonUtils.getConnection();
				if(con!= null){
					handler = new CRUDHandler();
					Object[] values = {mainAccountCode};
					rst = handler.executeSelectStatement(selectQuery, con, values);
					if(rst.next()){
						assignValue = rst.getString(filedValue);
						assignValue = assignValue == null ? "" : assignValue;
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
			return assignValue;
		}
}	
