package com.iii.pel.forms.PILM013_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_ACTION_DELEGATE extends CommonAction {

	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	Connection connection = null;
	
	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) {
		
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
			connection = CommonUtils.getConnection();
			queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$COMBO_BOX$QUERY;
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
		return drpDwn;
	}
	
	public ArrayList fetchDocumentSetupDetails(PM_IL_DOC_SEARCH_PAGE pm_il_doc_search_page) throws ValidatorException{
		handler = new CRUDHandler();
		ArrayList documentSetupList = new ArrayList();
		try {
			connection = CommonUtils.getConnection();

			String query = null;
//			if (pm_il_doc_search_page.getDocumentCode() != null
//					&& pm_il_doc_search_page.getDocumentCode().trim().length() > 0) {
//				query = query + " WHERE UPPER(PLAN_CODE) LIKE " + "'"
//						+ pm_il_doc_search_page.getDocumentCode().toUpperCase() + "%'";
//			}
			if(pm_il_doc_search_page.getDocumentType()!="" && pm_il_doc_search_page.getDocumentCode()=="")
			{
				query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$SEARCH_PAGE$FETCH1;
				Object[] values = {pm_il_doc_search_page.getDocumentType().trim()};
				resultSet = handler.executeSelectStatement(query, connection,values);
			}else if(pm_il_doc_search_page.getDocumentCode()!="" && pm_il_doc_search_page.getDocumentType()=="")
			{
				query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$SEARCH_PAGE$FETCH2;
				Object[] values = {pm_il_doc_search_page.getDocumentCode().trim()};
				resultSet = handler.executeSelectStatement(query, connection,values);
			}else if(pm_il_doc_search_page.getDocumentType()!="" && pm_il_doc_search_page.getDocumentCode()!="")
			{
				query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$SEARCH_PAGE$FETCH3;
				Object[] values = {pm_il_doc_search_page.getDocumentType().trim(),pm_il_doc_search_page.getDocumentCode().trim()};
				resultSet = handler.executeSelectStatement(query, connection,values);
			}
			else{
				query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$SEARCH_PAGE$FETCH4;
				resultSet = handler.executeSelectStatement(query, connection);
			}
			
			if (resultSet != null) {
				while (resultSet.next()) {
					PM_IL_DOC_SETUP beanClass = new PM_IL_DOC_SETUP();
					beanClass.setDS_TYPE(resultSet.getString(1));
					beanClass.setDS_CODE(resultSet.getString(2));
					beanClass.setDS_DESC(resultSet.getString(3));
					beanClass.setROWID(resultSet.getString(4));
					documentSetupList.add(beanClass);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return documentSetupList;
	}
	
	public Object fetchDocumentSetupDetails(String rowId, Object obj) {

		PM_IL_DOC_SETUP beanClass = (PM_IL_DOC_SETUP) obj;
		try {
			String query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$SEARCH_PAGE$NAVIGATE;
			System.out.println("CODE::::::::::::"+rowId);
			Object values[] = {rowId};
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);

			while (resultSet.next()) {
				String type= resultSet.getString(1);
				beanClass.setDS_TYPE(type);
				beanClass.setDS_CODE(resultSet.getString(2));
				beanClass.setDS_DESC(resultSet.getString(3));
				beanClass.setDS_SHORT_DESC(resultSet.getString(4));
				beanClass.setDS_PRN_BEFORE_APPR(resultSet.getString(5));
				beanClass.setDS_REPRINT_YN(resultSet.getString(6));
				beanClass.setDS_POST_BO(resultSet.getString(7));
				beanClass.setDS_CURR_RATE_BS(resultSet.getString(8));
				beanClass.setDS_POL_CODE(resultSet.getString(9));
				beanClass.setDS_END_TYPE(resultSet.getString(10));
				beanClass.setDS_BROKER_YN(resultSet.getString(11));
				beanClass.setDS_CR_DT(resultSet.getDate(12));
				beanClass.setDS_UPD_DT(resultSet.getDate(13));
				
				beanClass.setDS_FUND_TYPE(resultSet.getString(14));
				beanClass.setDS_REFUND_PREM_FLAG(resultSet.getString(15));
				beanClass.setDS_REFUND_SURPLUS_FLAG(resultSet.getString(16));
				beanClass.setDS_REFUND_DEP_FLAG(resultSet.getString(17));
				beanClass.setDS_RECVR_CHRG_FLAG(resultSet.getString(18));
				beanClass.setDS_RECVR_MEDFEE_YN(resultSet.getString(19));
				beanClass.setDS_RECVR_COMM_FLAG(resultSet.getString(20));
				beanClass.setDS_AGE_RECALC_YN(resultSet.getString(21));
				beanClass.setDS_USE_SEQ_YN(resultSet.getString(22));
				beanClass.setDS_CLM_PARSET(resultSet.getString(23));
				beanClass.setDS_CLM_FULSET(resultSet.getString(24));
				beanClass.setROWID(resultSet.getString(25));
				beanClass.setDS_EFF_FM_DT(resultSet.getDate(26));
				beanClass.setDS_EFF_TO_DT(resultSet.getDate(27));
				//added by saritha for endorsment description in master
				beanClass.setDS_END_REASON(resultSet.getString(28));

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
	
	/**
	 * For inserting records.
	 * @param pm_il_doc_setup
	 * @return int (0)
	 */
	public int insertDocumentSetupDetails(PM_IL_DOC_SETUP pm_il_doc_setup) {
		int rowsUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowsUpdated = handler.executeInsert(pm_il_doc_setup, connection);
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

/* LOV Actions */
	
	public List prepareDSTypeList(String catgCode, List catgCodeList) throws DBException {

		String query = null;
		Connection connection = CommonUtils.getConnection();
		try {
			
			if ("*".equalsIgnoreCase(catgCode)) {
				query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_TYPE$LOV1;
				Object[] object = {};
				catgCodeList = catgLOV(connection, query, object);

			} else {
				catgCode = catgCode + "%";
				Object[] object = { catgCode };
				query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_TYPE$LOV2;
				catgCodeList = catgLOV(connection, query, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catgCodeList;
	}
	 public List<PM_IL_DOC_SETUP> catgLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_DOC_SETUP> catgCodeList = new ArrayList<PM_IL_DOC_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_DOC_SETUP pm_il_doc_setup = new PM_IL_DOC_SETUP();
					pm_il_doc_setup.setDS_TYPE(resultSet.getString(1));
					pm_il_doc_setup.setUI_M_DS_TYPE_DESC(resultSet.getString(2));
					catgCodeList.add(pm_il_doc_setup);
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
		return catgCodeList;
	}
	
	
	 
	 
	 public List prepareEndorsementTypeList(String catgCode, List catgCodeList) throws DBException {

			String query = null;
			Connection connection = CommonUtils.getConnection();
			try {
				
				if ("*".equalsIgnoreCase(catgCode)) {
					query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_END_TYPE$LOV1;
					Object[] object = {};
					catgCodeList = endorsementLOV(connection, query, object);

				} else {
					catgCode = catgCode + "%";
					Object[] object = { catgCode };
					query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_END_TYPE$LOV2;
					catgCodeList = endorsementLOV(connection, query, object);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return catgCodeList;
		}
		 public List<PM_IL_DOC_SETUP> endorsementLOV(Connection connection,String query,Object[] object)
			{
			List<PM_IL_DOC_SETUP> catgCodeList = new ArrayList<PM_IL_DOC_SETUP>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query,connection,object);
					while(resultSet.next())
					{
						PM_IL_DOC_SETUP pm_il_doc_setup = new PM_IL_DOC_SETUP();
						pm_il_doc_setup.setDS_END_TYPE(resultSet.getString(1));
						pm_il_doc_setup.setUI_M_DS_END_DESC(resultSet.getString(2));
						catgCodeList.add(pm_il_doc_setup);
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
			return catgCodeList;
		}
		 
		 /* Policy Link Code */
		 public List preparePolicyLinkCodeList(String linkCode, List catgCodeList) throws DBException {

				String query = null;
				Connection connection = CommonUtils.getConnection();
				try {
					
					if ("*".equalsIgnoreCase(linkCode)) {
						query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_POL_CODE$LOV1;
						Object[] object = {};
						catgCodeList = linkCodeLOV(connection, query, object);

					} else {
						linkCode = linkCode + "%";
						Object[] object = { linkCode };
						query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_POL_CODE$LOV2;
						catgCodeList = linkCodeLOV(connection, query, object);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return catgCodeList;
			}
			 public List<PM_IL_DOC_SETUP> linkCodeLOV(Connection connection,String query,Object[] object)
				{
				List<PM_IL_DOC_SETUP> catgCodeList = new ArrayList<PM_IL_DOC_SETUP>();
				CRUDHandler handler = new CRUDHandler();
				ResultSet resultSet = null;
					try
					{
						resultSet=handler.executeSelectStatement(query,connection,object);
						while(resultSet.next())
						{
							PM_IL_DOC_SETUP pm_il_doc_setup = new PM_IL_DOC_SETUP();
							pm_il_doc_setup.setDS_POL_CODE(resultSet.getString(1));
							
							pm_il_doc_setup.setDS_POL_CODE_DESC(resultSet.getString(2));
							catgCodeList.add(pm_il_doc_setup);
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
				return catgCodeList;
			}
			 
			 /* Partial settlement */
			 public List preparePartSettleCodeList(String partSettleCode, List catgCodeList) throws DBException {

					String query = null;
					Connection connection = CommonUtils.getConnection();
					try {
						
						if ("*".equalsIgnoreCase(partSettleCode)) {
							query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_CLM_PAR_SET$LOV1;
							Object[] object = {};
							catgCodeList = partSettleLOV(connection, query, object);

						} else {
							partSettleCode = partSettleCode + "%";
							Object[] object = { partSettleCode };
							query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_CLM_PAR_SET$LOV2;
							catgCodeList = partSettleLOV(connection, query, object);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return catgCodeList;
				}
				 public List<PM_IL_DOC_SETUP> partSettleLOV(Connection connection,String query,Object[] object)
					{
					List<PM_IL_DOC_SETUP> catgCodeList = new ArrayList<PM_IL_DOC_SETUP>();
					CRUDHandler handler = new CRUDHandler();
					ResultSet resultSet = null;
						try
						{
							resultSet=handler.executeSelectStatement(query,connection,object);
							while(resultSet.next())
							{
								PM_IL_DOC_SETUP pm_il_doc_setup = new PM_IL_DOC_SETUP();
								pm_il_doc_setup.setDS_CLM_PARSET(resultSet.getString(1));
								
								pm_il_doc_setup.setUI_M_DS_CLM_PARSET_DESC(resultSet.getString(2));
								catgCodeList.add(pm_il_doc_setup);
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
					return catgCodeList;
				}
				 
				 
				 /* Full Settlement */
				 public List prepareFullSettleList(String partSettleCode, List catgCodeList) throws DBException {

						String query = null;
						Connection connection = CommonUtils.getConnection();
						try {
							
							if ("*".equalsIgnoreCase(partSettleCode)) {
								query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_CLM_PAR_SET$LOV1;
								Object[] object = {};
								catgCodeList = fullSettleLOV(connection, query, object);

							} else {
								partSettleCode = partSettleCode + "%";
								Object[] object = { partSettleCode };
								query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_CLM_PAR_SET$LOV2;
								catgCodeList = fullSettleLOV(connection, query, object);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						return catgCodeList;
					}
					 public List<PM_IL_DOC_SETUP> fullSettleLOV(Connection connection,String query,Object[] object)
						{
						List<PM_IL_DOC_SETUP> catgCodeList = new ArrayList<PM_IL_DOC_SETUP>();
						CRUDHandler handler = new CRUDHandler();
						ResultSet resultSet = null;
							try
							{
								resultSet=handler.executeSelectStatement(query,connection,object);
								while(resultSet.next())
								{
									PM_IL_DOC_SETUP pm_il_doc_setup = new PM_IL_DOC_SETUP();
									pm_il_doc_setup.setDS_CLM_FULSET(resultSet.getString(1));
									
									pm_il_doc_setup.setUI_M_DS_CLM_FULSET_DESC(resultSet.getString(2));
									catgCodeList.add(pm_il_doc_setup);
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
						return catgCodeList;
					}
					 
					 
					 public int DOC_SETUP_PRE_DELETE(String DNS_TYPE,String DNS_CODE)
					 {
						 
						 	/*
							 * Code Added by AMEETT BENDRE on 31.10.2008 at 12:32 PM
							 */
						 
						 	 Object[] params = {DNS_TYPE,DNS_CODE};
						 	 
							 String DOC_NO_SETUP = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$DOC_NO_SETUP;
							 preDeleteAction(DOC_NO_SETUP, params);
							 //-------------------------------------------------
							 
							 String DOC_NO_RANGE = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$DOC_NO_RANGE;
							 preDeleteAction(DOC_NO_RANGE, params);
							 
							 String DFLT_CHRG = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$DOC_DFLT_CHRG;
							 preDeleteAction(DFLT_CHRG, params);
							 
							 String MED_HIST = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$MED_HIST;
							 preDeleteAction(MED_HIST, params);
							 
							 String TODO_GROUP = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$TODO_GROUP;
							 preDeleteAction(TODO_GROUP, params);
							 
							 String REMINDERS = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$REMINDERS;
							 preDeleteAction(REMINDERS, params);
							 
							 String DOC_SETUP = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$PRE_DELETE$DOC_SETUP;
							 
//							 System.out.println("QUERY::::::"+DOC_SETUP+" PARAMS::::::::"+DNS_TYPE+"  "+DNS_CODE);
							 int rowsDeleted = preDeleteAction(DOC_SETUP, params);
							
						return rowsDeleted;
					 }
					 
					 public int preDeleteAction(String query, Object[] params)
					 {
						 	int rowsDeleted = 0;
						 	Connection connection = null;
							CRUDHandler handler = new CRUDHandler();
							int deletedRows = 0;
							try {
								connection = CommonUtils.getConnection();
								
								deletedRows = handler.executeDeleteStatement(query, connection, params);
								connection.commit();
							} catch (Exception e) {
								e.printStackTrace();
							}
							return deletedRows;
					 }
}
