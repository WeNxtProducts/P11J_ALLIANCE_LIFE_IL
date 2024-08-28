package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_NO_RANGE_DELEGATE {


		public PM_IL_DOC_NO_RANGE_DELEGATE()
		{
		}
		public List getDocumentNoRangeValues()
		{
			Connection connection = null;
			CRUDHandler dbHandler = new CRUDHandler();
			List list = null;
			try {
				connection = CommonUtils.getConnection();
				list = new ArrayList();
				if(getSessionValue()!=null)
				{
					String type =getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
					String code = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
					
					String query = "select DNR_TYPE,DNR_CODE,DNR_LEVEL_1,DNR_LEVEL_2,DNR_LEVEL_3,DNR_LEVEL_4,DNR_FIRST_NO," +
							"DNR_CURR_NO,DNR_LAST_NO,DNR_DISABLE_YN,DNR_FRZ_FLAG,DNR_CR_DT,DNR_CR_UID," +
							"DNR_UPD_DT,DNR_UPD_UID,DNR_SEQ_NAME,DNR_LEVEL_5,ROWID from PM_IL_DOC_NO_RANGE WHERE DNR_TYPE='"+type+"' AND DNR_CODE='"+code+"'";
					System.out.println("QUERY::::::"+query);
					list = dbHandler.fetch(query,"com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_NO_RANGE",connection);
					connection.commit();
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			return list;
		}
	
	public int updateData(PM_IL_DOC_NO_RANGE pm_il_doc_no_range) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_doc_no_range, connection);
			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	
	public int deleteData(PM_IL_DOC_NO_RANGE pm_il_doc_no_range)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_doc_no_range, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
/* Fetch Applied On Combobox values */
	
	public ArrayList<SelectItem> fetchComboBoxValues(String formName,
			String blockName, String fieldName) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
			connection = CommonUtils.getConnection();
			queryString = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME = '{0}' AND LI_BLOCK_NAME = '{1}' AND LI_ITEM_NAME = '{2}'";
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);

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
		}catch(Exception e)
		{
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
	
	
	/* LOV Actions */
	
	public List prepareLevel1List(String catgCode, List catgCodeList, String query1,String query2) {

		String query = null;
		try {
			Connection connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(catgCode)) {
				//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
				Object[] object = {};
				catgCodeList = catLevel1LOV(connection, query1, object);

			} else {
				catgCode = catgCode + "%";
				Object[] object = { catgCode };
				//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
				catgCodeList = catLevel1LOV(connection, query2, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catgCodeList;
	}
	 public List<PM_IL_DOC_NO_RANGE> catLevel1LOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_DOC_NO_RANGE> catgCodeList = new ArrayList<PM_IL_DOC_NO_RANGE>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query,connection,object);
				while(resultSet.next())
				{
					PM_IL_DOC_NO_RANGE pm_il_doc_no_range = new PM_IL_DOC_NO_RANGE();
					pm_il_doc_no_range.setDNR_LEVEL_1(resultSet.getString(1));
					pm_il_doc_no_range.setUI_M_DNR_LEVEL_1_DESC(resultSet.getString(2));
					catgCodeList.add(pm_il_doc_no_range);
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
	 
	 /* level2 */
	 public List prepareLevel2List(String catgCode, List catgCodeList, String query1,String query2) {

			String query = null;
			try {
				Connection connection = CommonUtils.getConnection();
				if ("*".equalsIgnoreCase(catgCode)) {
					//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
					Object[] object = {};
					catgCodeList = catLevel2LOV(connection, query1, object);

				} else {
					catgCode = catgCode + "%";
					Object[] object = { catgCode };
					//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
					catgCodeList = catLevel2LOV(connection, query2, object);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return catgCodeList;
		}
		 public List<PM_IL_DOC_NO_RANGE> catLevel2LOV(Connection connection,String query,Object[] object)
			{
			List<PM_IL_DOC_NO_RANGE> catgCodeList = new ArrayList<PM_IL_DOC_NO_RANGE>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
				try
				{
					resultSet=handler.executeSelectStatement(query,connection,object);
					while(resultSet.next())
					{
						PM_IL_DOC_NO_RANGE pm_il_doc_no_range = new PM_IL_DOC_NO_RANGE();
						pm_il_doc_no_range.setDNR_LEVEL_2(resultSet.getString(1));
						pm_il_doc_no_range.setUI_M_DNR_LEVEL_2_DESC(resultSet.getString(2));
						catgCodeList.add(pm_il_doc_no_range);
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
		 
		 
		 /* level3 */
		 
		 public List prepareLevel3List(String catgCode, List catgCodeList, String query1,String query2) {

				String query = null;
				try {
					Connection connection = CommonUtils.getConnection();
					if ("*".equalsIgnoreCase(catgCode)) {
						//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
						Object[] object = {};
						catgCodeList = catLevel3LOV(connection, query1, object);

					} else {
						catgCode = catgCode + "%";
						Object[] object = { catgCode };
						//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
						catgCodeList = catLevel3LOV(connection, query2, object);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return catgCodeList;
			}
			 public List<PM_IL_DOC_NO_RANGE> catLevel3LOV(Connection connection,String query,Object[] object)
				{
				List<PM_IL_DOC_NO_RANGE> catgCodeList = new ArrayList<PM_IL_DOC_NO_RANGE>();
				CRUDHandler handler = new CRUDHandler();
				ResultSet resultSet = null;
					try
					{
						resultSet=handler.executeSelectStatement(query,connection,object);
						while(resultSet.next())
						{
							PM_IL_DOC_NO_RANGE pm_il_doc_no_range = new PM_IL_DOC_NO_RANGE();
							pm_il_doc_no_range.setDNR_LEVEL_3(resultSet.getString(1));
							pm_il_doc_no_range.setUI_M_DNR_LEVEL_3_DESC(resultSet.getString(2));
							catgCodeList.add(pm_il_doc_no_range);
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
			 
			 /* level4 */
			 
			 public List prepareLevel4List(String catgCode, List catgCodeList, String query1,String query2) {

					String query = null;
					try {
						Connection connection = CommonUtils.getConnection();
						if ("*".equalsIgnoreCase(catgCode)) {
							//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
							Object[] object = {};
							catgCodeList = catLevel4LOV(connection, query1, object);

						} else {
							catgCode = catgCode + "%";
							Object[] object = { catgCode };
							//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
							catgCodeList = catLevel4LOV(connection, query2, object);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return catgCodeList;
				}
				 public List<PM_IL_DOC_NO_RANGE> catLevel4LOV(Connection connection,String query,Object[] object)
					{
					List<PM_IL_DOC_NO_RANGE> catgCodeList = new ArrayList<PM_IL_DOC_NO_RANGE>();
					CRUDHandler handler = new CRUDHandler();
					ResultSet resultSet = null;
						try
						{
							resultSet=handler.executeSelectStatement(query,connection,object);
							while(resultSet.next())
							{
								PM_IL_DOC_NO_RANGE pm_il_doc_no_range = new PM_IL_DOC_NO_RANGE();
								pm_il_doc_no_range.setDNR_LEVEL_4(resultSet.getString(1));
								pm_il_doc_no_range.setUI_M_DNR_LEVEL_4_DESC(resultSet.getString(2));
								catgCodeList.add(pm_il_doc_no_range);
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
		
				 /* level5 */
				 
				 public List prepareLevel5List(String catgCode, List catgCodeList, String query1,String query2) {

						String query = null;
						try {
							Connection connection = CommonUtils.getConnection();
							if ("*".equalsIgnoreCase(catgCode)) {
								//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY1;
								Object[] object = {};
								catgCodeList = catLevel5LOV(connection, query1, object);

							} else {
								catgCode = catgCode + "%";
								Object[] object = { catgCode };
								//query = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY2;
								catgCodeList = catLevel5LOV(connection, query2, object);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						return catgCodeList;
					}
					 public List<PM_IL_DOC_NO_RANGE> catLevel5LOV(Connection connection,String query,Object[] object)
						{
						List<PM_IL_DOC_NO_RANGE> catgCodeList = new ArrayList<PM_IL_DOC_NO_RANGE>();
						CRUDHandler handler = new CRUDHandler();
						ResultSet resultSet = null;
							try
							{
								resultSet=handler.executeSelectStatement(query,connection,object);
								while(resultSet.next())
								{
									PM_IL_DOC_NO_RANGE pm_il_doc_no_range = new PM_IL_DOC_NO_RANGE();
									pm_il_doc_no_range.setDNR_LEVEL_5(resultSet.getString(1));
									pm_il_doc_no_range.setUI_M_DNR_LEVEL_5_DESC(resultSet.getString(2));
									catgCodeList.add(pm_il_doc_no_range);
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
			
					 /*P_VAL_DIVN */
					 public String P_VAL_DIVN(String code,String flag1,String flag2)throws ValidatorException
					 {
						 Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							ArrayList outputList  = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",code);
							OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
							OracleParameter param3 = new OracleParameter("in3","STRING","IN", flag1);
							OracleParameter param4 = new OracleParameter("in4","STRING","IN",flag2);
							parameterList.add(param1);
							parameterList.add(param2);
							parameterList.add(param3);
							parameterList.add(param4);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								outputList = procHandler.execute(parameterList, connection, "P_VAL_DIVN");
								Iterator<OracleParameter> iterator = outputList.iterator();
								while(iterator.hasNext())
								{
									OracleParameter oracleParameter = iterator.next();
									outputValue = oracleParameter.getValue();
								}
							} catch (Exception e1) {
								
								throw new ValidatorException(new FacesMessage(e1.getMessage()));
								
							}
							return outputValue;
							
					 }
					 
					 /*P_VAL_DIVN */
					 public String P_VAL_DIVN1(String code,String flag1,String flag2,UIInput input,FacesContext facesContext, PM_IL_DOC_NO_RANGE_ACTION action, String id)throws ValidatorException
					 {
						 
						 
						 	Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							ArrayList outputList  = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",code);
							OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
							OracleParameter param3 = new OracleParameter("in3","STRING","IN", flag1);
							OracleParameter param4 = new OracleParameter("in4","STRING","IN",flag2);
							parameterList.add(param1);
							parameterList.add(param2);
							parameterList.add(param3);
							parameterList.add(param4);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								outputList = procHandler.execute(parameterList, connection, "P_VAL_DIVN");
								Iterator<OracleParameter> iterator = outputList.iterator();
								while(iterator.hasNext())
								{
									OracleParameter oracleParameter = iterator.next();
									outputValue = oracleParameter.getValue();
								}
							} catch (Exception e1) {
								
								ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(), 
										id, action.getWarningMap());
								//throw new ValidatorException(new FacesMessage("Branch Code does not exists"));
								
							}
							return outputValue;
							
					 }
					 
					 /* P_VAL_PLAN */
					 
					 public String P_VAL_PLAN(String code,String flag1,String flag2)throws ValidatorException
					 {
						 Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							ArrayList outputList  = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",code);
							OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
							OracleParameter param3 = new OracleParameter("in2","STRING","IN", flag1);
							OracleParameter param4 = new OracleParameter("in3","STRING","IN",flag2);
							parameterList.add(param1);
							parameterList.add(param2);
							parameterList.add(param3);
							parameterList.add(param4);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								outputList = procHandler.execute(parameterList, connection, "P_VAL_PLAN");
								Iterator<OracleParameter> iterator = outputList.iterator();
								while(iterator.hasNext())
								{
									OracleParameter oracleParameter = iterator.next();
									outputValue = oracleParameter.getValue();
								}
							} catch (Exception e1) {
								//e1.printStackTrace();
								throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "71008")));
							}
							return outputValue;
							
					 }
					 
					 /* P_VAL_CLASS */
					 
					 public String P_VAL_CLASS(String code,String flag1,String flag2)throws ValidatorException
					 {
						 	Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							ArrayList outputList  = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",code);
							OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
							OracleParameter param3 = new OracleParameter("in3","STRING","IN", flag1);
							OracleParameter param4 = new OracleParameter("in4","STRING","IN",flag2);
							parameterList.add(param1);
							parameterList.add(param2);
							parameterList.add(param3);
							parameterList.add(param4);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								outputList = procHandler.execute(parameterList, connection, "P_VAL_CLASS");
								Iterator<OracleParameter> iterator = outputList.iterator();
								while(iterator.hasNext())
								{
									OracleParameter oracleParameter = iterator.next();
									outputValue = oracleParameter.getValue();
								}
							} catch (Exception e1) {
								//e1.printStackTrace();
								throw new ValidatorException(new FacesMessage(e1.getMessage()));
								//throw new ValidatorException(new FacesMessage("Class Code Does Not Exist"));
							}
							return outputValue;
							
					 }
					 
					 
					 public String P_VAL_CLASS1(String code,String flag1,String flag2, UIInput input,FacesContext facesContext, PM_IL_DOC_NO_RANGE_ACTION action, String id)throws ValidatorException
					 {
						 	Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							ArrayList outputList  = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",code);
							OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
							OracleParameter param3 = new OracleParameter("in3","STRING","IN", flag1);
							OracleParameter param4 = new OracleParameter("in4","STRING","IN",flag2);
							parameterList.add(param1);
							parameterList.add(param2);
							parameterList.add(param3);
							parameterList.add(param4);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								outputList = procHandler.execute(parameterList, connection, "P_VAL_CLASS");
								Iterator<OracleParameter> iterator = outputList.iterator();
								while(iterator.hasNext())
								{
									OracleParameter oracleParameter = iterator.next();
									outputValue = oracleParameter.getValue();
								}
							} catch (Exception e1) {
								//e1.printStackTrace();
//								throw new ValidatorException(new FacesMessage(e1.getMessage()));
								//throw new ValidatorException(new FacesMessage("Class Code Does Not Exist"));
								ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(), 
										id, action.getWarningMap());
							}
							return outputValue;
							
					 }

					 	/* P_VAL_YEAR */
					 
					 public String P_VAL_YEAR(String code)throws ValidatorException
					 {
						 	Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",code);
							parameterList.add(param1);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								procHandler.execute(parameterList, connection, "P_VAL_UWYEAR");
								
							} catch (Exception e1) {
								throw new ValidatorException(new FacesMessage(e1.getMessage()));
							}
							return outputValue;
							
					 }
					 
					 public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
						{
							PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
							if(actionBean == null)
							{
								return null;
							}else{
								PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
								return pm_il_doc_setup_composite_action;
								
							}
						}
					 
					 public PM_IL_DOC_NO_SETUP_ACTION getDOC_NO_ACTION_SessionValue()
						{
							PM_IL_DOC_NO_SETUP_ACTION actionBean = (PM_IL_DOC_NO_SETUP_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_NO_SETUP_ACTION");
							if(actionBean == null)
							{
								return null;
							}else{
								PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action = (PM_IL_DOC_NO_SETUP_ACTION)new CommonUtils().getMappedBeanFromSession("PM_IL_DOC_NO_SETUP_ACTION");
								return pm_il_doc_no_setup_action;
								
							}
						}
					 
					 
					 public String POST_QUERY_EXECUTION(PM_IL_DOC_NO_RANGE pm_il_doc_no_range)
					 {
						 String query = PM_IL_DOC_NO_RANGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$POST_QUERY;
						 Connection connection = null;
						 String outputValue = null;
						 ResultSet resultSet = null;
						CRUDHandler dbHandler = new CRUDHandler();
							try {
								connection = CommonUtils.getConnection();
								Object[] values={pm_il_doc_no_range.getDNR_SEQ_NAME()};
								
								resultSet = dbHandler.executeSelectStatement(query, connection, values);
								while(resultSet.next())
								{
									outputValue = resultSet.getString(1);
								}
								
							} catch (Exception exc) {
								exc.printStackTrace();
							}finally{
								try {
									new CommonUtils().closeCursor(resultSet);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							
							return outputValue;
					 }
					 
					 
					 public String saveData(PM_IL_DOC_NO_RANGE_ACTION pm_il_doc_no_range_action)
						{
							Connection connection = null;
							CRUDHandler handler = new CRUDHandler();
							try {
								connection = CommonUtils.getConnection();
								/*int rowCount = pm_il_doc_no_range_action.getDataTable().getRowCount();
								for(int index = 0;index<rowCount; index++)
								{
									PM_IL_DOC_NO_RANGE gridValueBean = (PM_IL_DOC_NO_RANGE)pm_il_doc_no_range_action.getDataTableList().get(index);
									if(pm_il_doc_no_range_action.getCOMP_DNR_FRZ_FLAG().getSubmittedValue().equals("false"))
									{
										gridValueBean.setDNR_FRZ_FLAG("N");
									}else{
										gridValueBean.setDNR_FRZ_FLAG("N");
									//}
									pm_il_doc_no_range_action.PRE_INSERT(gridValueBean);
									handler.executeInsert(gridValueBean, connection);
								}*/
								
								connection.commit();
							} catch (Exception exc) {
								exc.printStackTrace();
							}
							return "";
						}
					 
					 
					 public String P_CRT_TDOC_SEQ(PM_IL_DOC_NO_RANGE pm_il_doc_no_range)
					 {
						 Connection connection = null;
						 	String outputValue = null;
							ArrayList parameterList = new ArrayList();
							ArrayList outputList  = new ArrayList();
							OracleParameter param1 = new OracleParameter("in1","STRING","IN",pm_il_doc_no_range.getDNR_SEQ_NAME());
							OracleParameter param2 = new OracleParameter("in2","STRING","IN",""+pm_il_doc_no_range.getDNR_CURR_NO());
							OracleParameter param3 = new OracleParameter("in3","STRING","IN", ""+pm_il_doc_no_range.getDNR_LAST_NO());
							parameterList.add(param1);
							parameterList.add(param2);
							parameterList.add(param3);
							
							OracleProcedureHandler procHandler = new OracleProcedureHandler();
							try {
								connection = CommonUtils.getConnection();
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								//new DBProcedures().PCOPK_SYS_VARS(connection);
								//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
								outputList = procHandler.execute(parameterList, connection, "P_CRT_TDOC_SEQ");
								Iterator<OracleParameter> iterator = outputList.iterator();
								while(iterator.hasNext())
								{
									OracleParameter oracleParameter = iterator.next();
									outputValue = oracleParameter.getValue();
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							return outputValue;
							
					 }
					 
 public String checkProductCode(String productCode)
 {
   ResultSet resultSet = null;
   String result = null;
   Connection connection = null;
   CRUDHandler handler = new CRUDHandler();
   try {
	   	connection = new CommonUtils().getConnection();
		String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY10;
		Object[] values = {productCode};
			
		resultSet = handler.executeSelectStatement(queryString, connection, values);
		while (resultSet.next()) {
			result = resultSet.getString(1);
		}
			
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (DBException e) {
		e.printStackTrace();
	}finally{
		try {
			new CommonUtils().closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return result;
 }
 
 public String checkUWYearCode(String UWYearCode)
 {
   ResultSet resultSet = null;
   String result = null;
   Connection connection = null;
   CRUDHandler handler = new CRUDHandler();
   try {
	   	connection = new CommonUtils().getConnection();
		String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$DNR_LEVEL1_QUERY12;
		Object[] values = {UWYearCode};
			
		resultSet = handler.executeSelectStatement(queryString, connection, values);
		while (resultSet.next()) {
			result = resultSet.getString(1);
		}
			
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (DBException e) {
		e.printStackTrace();
	}finally{
		try {
			new CommonUtils().closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return result;
 }
 
 
 public String getDocumentCodeDesc(String docCode)
 {
   ResultSet resultSet = null;
   String result = null;
   Connection connection = null;
   CRUDHandler handler = new CRUDHandler();
   try {
	   	connection = new CommonUtils().getConnection();
		String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$POST_QUERY$DOC_CODE;
		Object[] values = {docCode};
			
		resultSet = handler.executeSelectStatement(queryString, connection, values);
		while (resultSet.next()) {
			result = resultSet.getString(1);
		}
			
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (DBException e) {
		e.printStackTrace();
	}finally{
		try {
			new CommonUtils().closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return result;
 }
 
 public String getProductCodeDesc(String productCode)
 {
   ResultSet resultSet = null;
   String result = null;
   Connection connection = null;
   CRUDHandler handler = new CRUDHandler();
   try {
	   	connection = new CommonUtils().getConnection();
		String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO_RANGE$POST_QUERY$PROD_CODE;
		Object[] values = {productCode};
			
		resultSet = handler.executeSelectStatement(queryString, connection, values);
		while (resultSet.next()) {
			result = resultSet.getString(1);
		}
			
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (DBException e) {
		e.printStackTrace();
	}finally{
		try {
			new CommonUtils().closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return result;
 }
}
