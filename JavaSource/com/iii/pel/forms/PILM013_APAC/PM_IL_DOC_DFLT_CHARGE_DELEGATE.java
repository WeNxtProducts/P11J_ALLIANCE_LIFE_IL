package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_DFLT_CHARGE_DELEGATE extends CommonAction {

	public PM_IL_DOC_DFLT_CHARGE_DELEGATE() {
	}

	public List getDocumentDefaultChargeValues() throws DBException {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			if (getSessionValue() != null) {
				String type = getSessionValue()
						.getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
				String code = getSessionValue()
						.getPM_IL_DOC_SETUP_ACTION_BEAN()
						.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();

				String query = "select DDCHG_CHARGE_MAX_LMT,DDCHG_DS_TYPE,DDCHG_DS_CODE,DDCHG_SR_NO,DDCHG_CODE,DDCHG_RATE,"
						+ "DDCHG_RATE_PER,DDCHG_APPLIED_ON,DDCHG_CUST_SHARE_PERC,DDCHG_EFF_FM_DT,DDCHG_EFF_TO_DT,"
						+ "DDCHG_CR_DT,DDCHG_CR_UID,DDCHG_UPD_DT,DDCHG_UPD_UID,DDCHG_APPLY_PERIOD,DDCHG_DS_CHG_TAR_CODE,DDCHG_PROD_CODE_TO,"
						+ "DDCHG_PROD_CODE_FM,ROWID from PM_IL_DOC_DFLT_CHARGE "
						+ "WHERE DDCHG_DS_TYPE='"
						+ type
						+ "' AND DDCHG_DS_CODE='"
						+ code
						+ "' ORDER BY DDCHG_SR_NO";
				list = dbHandler.fetch(query,
						"com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE",
						connection);
				connection.commit();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}

	public int updateData(PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge)
			throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_doc_dflt_charge,
					connection);

		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_doc_dflt_charge,
					connection);
			connection.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	/* Fetch Applied On Combobox values */

	public ArrayList<SelectItem> fetchComboBoxValues(String formName,
			String blockName, String fieldName) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;

		try {
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
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}

	/* LOV Actions */

	public List prepareCatgCodeList(String catgCode, List catgCodeList)
			throws Exception {

		String query = null;
		Connection connection = CommonUtils.getConnection();
		try {

			if ("*".equalsIgnoreCase(catgCode)) {
				query = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.QUERY$PILM013_APAC$DFLT_CHRG_CODE;
				Object[] object = {};
				catgCodeList = catgLOV(connection, query, object);

			} else {
				catgCode = catgCode + "%";
				Object[] object = { catgCode };
				query = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.QUERY1$PILM013_APAC$DFLT_CHRG_CODE;
				catgCodeList = catgLOV(connection, query, object);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return catgCodeList;
	}

	public List<PM_IL_DOC_DFLT_CHARGE> catgLOV(Connection connection,
			String query, Object[] object) throws Exception {
		List<PM_IL_DOC_DFLT_CHARGE> catgCodeList = new ArrayList<PM_IL_DOC_DFLT_CHARGE>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			resultSet = handler.executeSelectStatement(query, connection,
					object);
			while (resultSet.next()) {
				PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = new PM_IL_DOC_DFLT_CHARGE();
				pm_il_doc_dflt_charge.setDDCHG_CODE(resultSet.getString(1));
				pm_il_doc_dflt_charge.setUI_M_DDCHG_CODE_DESC(resultSet
						.getString(2));
				catgCodeList.add(pm_il_doc_dflt_charge);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return catgCodeList;
	}

	public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue() {
		PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if (actionBean == null) {
			return null;
		} else {
			PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
					.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			return pm_il_doc_setup_composite_action;

		}
	}

	/* Field Level Validations */

	/* Charge Code When Validate Item */

	public void chargeCodeP_VAL_CODES(String codeType, String code)
			throws DBException {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Connection connection = CommonUtils.getConnection();
		ArrayList parameterList = new ArrayList();
		ArrayList outputList = new ArrayList();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				codeType);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				code);
		OracleParameter param3 = new OracleParameter("inout1", "STRING",
				"IN OUT", "1");
		OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
				null);
		OracleParameter param5 = new OracleParameter("in4", "STRING", "IN", "E");
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
			// [ removed commented PCOPK_SYS_VARS procedure calling : added by:
			// Shankar bodduluri Dated: 19-Mar-2009 ]
			// new DBProcedures().PCOPK_SYS_VARS(connection);
			// [ removed commented PCOPK_SYS_VARS procedure calling : added by:
			// Shankar bodduluri Dated: 19-Mar-2009 ]
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out
						.println("Output value:" + oracleParameter.getValue());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		/*
		 * finally {
		 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
		 * ctx,getSubmit().getClientId(FacesContext.getCurrentInstance()),getErrorMap(),getWarningMap()); }
		 */
	}

	public void chargeCodeValidation(String chargeCode,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action,
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) throws Exception {
		String M_PC_VALLUE = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String query = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$DDCHG_CODE$QUERY;
			Object values[] = { chargeCode };
			resultSet = handler.executeSelectStatement(query, connection,
					values);
			if (resultSet.next()) {
				M_PC_VALLUE = resultSet.getString(1);
			}
			/*
			 * if(!resultSet.isLast()) {
			 */
			/*
			 * int rowIndex =
			 * pm_il_doc_dflt_charge_action.getDataTable().getRowIndex();
			 * PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge =
			 * (PM_IL_DOC_DFLT_CHARGE)pm_il_doc_dflt_charge_action.getDataTableList().get(rowIndex);
			 */
			System.out.println("PC VALUE::::::::::::" + M_PC_VALLUE);
			if (null != M_PC_VALLUE && M_PC_VALLUE.equalsIgnoreCase("1")) {
				pm_il_doc_dflt_charge.setDDCHG_CUST_SHARE_PERC(100.0);
				pm_il_doc_dflt_charge_action.getCOMP_DDCHG_CUST_SHARE_PERC()
						.setSubmittedValue("" + 100.0);
			} else if (null != M_PC_VALLUE && M_PC_VALLUE.equalsIgnoreCase("2")) {
				pm_il_doc_dflt_charge.setDDCHG_CUST_SHARE_PERC(0.0);
			}
			// }
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_DUP_CHARGE(PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge)
			throws Exception {
		ResultSet resultSet = null;
		String result = null;
		Connection connection = null;
		String queryString = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String DS_CODE = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
					.getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
			String DS_TYPE = getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN()
					.getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
			if (pm_il_doc_dflt_charge.getROWID() != null) {
				queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_CHARGE$QUERY2;
				Object[] values = { DS_CODE, DS_TYPE,
						pm_il_doc_dflt_charge.getDDCHG_CODE(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_FM_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_FM_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_FM_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_TO_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_TO_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_TO_DT(),
						pm_il_doc_dflt_charge.getROWID() };
				resultSet = handler.executeSelectStatement(queryString,
						connection, values);
			} else {
				queryString = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_CHARGE$QUERY1;
				Object[] values = { DS_CODE, DS_TYPE,
						pm_il_doc_dflt_charge.getDDCHG_CODE(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_FM_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_FM_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_FM_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_TO_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_TO_DT(),
						pm_il_doc_dflt_charge.getDDCHG_EFF_TO_DT() };
				resultSet = handler.executeSelectStatement(queryString,
						connection, values);
			}

			if (resultSet.next()) {
				result = resultSet.getString(1);
				if (result != null) {
					throw new ValidatorException(Messages
							.getMessage(
									PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH,
									"91002"));
				}
			}

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void L_DUP_SRLNO(String blockName,int rowIndex) throws
	 * ValidatorException, SQLException, Exception { ResultSet resultSet = null;
	 * String result = null; Connection connection = null; String queryString =
	 * null; CRUDHandler handler = new CRUDHandler(); try { connection = new
	 * CommonUtils().getConnection(); String DS_CODE =
	 * getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_CODE();
	 * String DS_TYPE=
	 * getSessionValue().getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	 * 
	 * if(blockName.equalsIgnoreCase("PM_IL_DOC_DFLT_CHARGE")) {
	 * PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = (PM_IL_DOC_DFLT_CHARGE)
	 * getSessionValue().getPM_IL_DOC_DFLT_CHARGE_ACTION_BEAN().getDataTableList().get(rowIndex);
	 * System.out.println(pm_il_doc_dflt_charge.getDDCHG_SR_NO()+"
	 * "+pm_il_doc_dflt_charge.getROWID());
	 * if(pm_il_doc_dflt_charge.getROWID()!=null) { queryString =
	 * PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE2;
	 * Object[] values =
	 * {DS_CODE,DS_TYPE,pm_il_doc_dflt_charge.getDDCHG_SR_NO(),
	 * pm_il_doc_dflt_charge.getROWID()}; resultSet =
	 * handler.executeSelectStatement(queryString, connection, values); }else{
	 * queryString =
	 * PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE1;
	 * Object[] values =
	 * {DS_CODE,DS_TYPE,pm_il_doc_dflt_charge.getDDCHG_SR_NO()}; resultSet =
	 * handler.executeSelectStatement(queryString, connection, values); } }else
	 * if(blockName.equalsIgnoreCase("PM_IL_DOC_TODO_LIST")) {
	 * PM_IL_DOC_TODO_LIST pm_il_doc_todo_list = (PM_IL_DOC_TODO_LIST)
	 * getSessionValue().getPM_IL_DOC_TODO_LIST_ACTION_BEAN().getDataTableList().get(rowIndex);
	 * if(pm_il_doc_todo_list.getROWID()!=null) { queryString =
	 * PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE2;
	 * Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_todo_list.getDTL_SR_NO(),
	 * pm_il_doc_todo_list.getROWID()}; resultSet =
	 * handler.executeSelectStatement(queryString, connection, values); }else{
	 * queryString =
	 * PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_DFLT_CHARGE1;
	 * Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_todo_list.getDTL_SR_NO()};
	 * resultSet = handler.executeSelectStatement(queryString, connection,
	 * values); } }else if(blockName.equalsIgnoreCase("PM_IL_DOC_MED_HIST")) {
	 * PM_IL_DOC_MED_HIST pm_il_doc_med_hist = (PM_IL_DOC_MED_HIST)
	 * getSessionValue().getPM_IL_DOC_MED_HIST_ACTION_BEAN().getDataTableList().get(rowIndex);
	 * if(pm_il_doc_med_hist.getROWID()!=null) { queryString =
	 * PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_MED_HIST2;
	 * Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_med_hist.getDMH_SR_NO(),
	 * pm_il_doc_med_hist.getROWID()}; resultSet =
	 * handler.executeSelectStatement(queryString, connection, values); }else{
	 * queryString =
	 * PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$L_DUP_SRLNO$PM_IL_DOC_MED_HIST1;
	 * Object[] values = {DS_CODE,DS_TYPE,pm_il_doc_med_hist.getDMH_SR_NO()};
	 * resultSet = handler.executeSelectStatement(queryString, connection,
	 * values); } }
	 * 
	 * 
	 * if (resultSet.next()) { result = resultSet.getString(1); if(result!=null) {
	 * throw new ValidatorException(Messages.getMessage("PELErrorMessages",
	 * "91000")); } }
	 * 
	 * resultSet.close(); connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } catch (DBException e) { e.printStackTrace(); } }
	 */

	public void DFLT_CHARGE_POST_DELETE(
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge, int rowIndex)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			Object[] values = { pm_il_doc_dflt_charge.getUI_M_SR_NO(),
					pm_il_doc_dflt_charge.getDDCHG_DS_TYPE(),
					pm_il_doc_dflt_charge.getDDCHG_DS_CODE() };
			String query = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.PILM013_APAC$PM_IL_DOC_DFLT_CHARGE$POST_DELETE$QUERY;
			handler.executeUpdateStatement(query, connection, values);
			connection.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String saveData(
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			/*
			 * int rowCount =
			 * pm_il_doc_dflt_charge_action.getDataTable().getRowCount();
			 * for(int index = 0;index<rowCount; index++) {
			 * PM_IL_DOC_DFLT_CHARGE gridValueBean =
			 * (PM_IL_DOC_DFLT_CHARGE)pm_il_doc_dflt_charge_action.getDataTableList().get(index);
			 * pm_il_doc_dflt_charge_action.PRE_INSERT(gridValueBean,index);
			 * handler.executeInsert(gridValueBean, connection); }
			 */

			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
}
