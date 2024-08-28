package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.DUMMY;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_SETUP_HELPER extends CommonAction {
	PILM013_APAC_DBProcedures procedures = null;
	String bundleName = PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH;

	/**
	 * Type When Validate Item
	 * 
	 * @param dsCode
	 * @param pm_il_doc_setup_action
	 * @throws Exception
	 */
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public void DS_TYPE_WHEN_VALIDATE_ITEM(String dsType,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		procedures = new PILM013_APAC_DBProcedures();
		try {
			if (!dsType.isEmpty()&& dsType != null) {
				String isExists = fetchDSType(dsType);
				if (isExists == null) {
					throw new Exception(
							Messages.getString(
											PELConstants.pelErrorMessagePath,
											"71107"));
					
				}
				L_DISP_END_POL(dsType, pm_il_doc_setup_action);

				ArrayList list;
				list = procedures.P_VAL_SYSTEM("IL_DOC_TYP", dsType,
						"E");

				pm_il_doc_setup_action.getCOMP_UI_M_DS_TYPE_DESC()
						.setSubmittedValue((String) list.get(0));

				
				if (dsType.equalsIgnoreCase("3")) {
					if (pm_il_doc_setup_action.getCOMP_DS_END_TYPE()
							.getSubmittedValue() != null) {
						if (dsType.equalsIgnoreCase("3")
								&& pm_il_doc_setup_action.getCOMP_DS_END_TYPE()
										.getSubmittedValue().equals("009")) {
							setCANCELLATION_DETAILS_BLOCK_ENABLE(false,
									pm_il_doc_setup_action);
							setCLAIM_DETAILS_BLOCK_ENABLED(true,
									pm_il_doc_setup_action);
						}
					}
				} else if (dsType.equals("4")) {
					setCLAIM_DETAILS_BLOCK_ENABLED(false,
							pm_il_doc_setup_action);
					setCANCELLATION_DETAILS_BLOCK_ENABLE(true,
							pm_il_doc_setup_action);
					pm_il_doc_setup_action.getCOMP_DS_END_TYPE()
							.setSubmittedValue("");
				} else {
					setCANCELLATION_DETAILS_BLOCK_ENABLE(true,
							pm_il_doc_setup_action);
					setCLAIM_DETAILS_BLOCK_ENABLED(true, pm_il_doc_setup_action);
					pm_il_doc_setup_action.getCOMP_DS_END_TYPE()
							.setSubmittedValue("");
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void setCANCELLATION_DETAILS_BLOCK_ENABLE(boolean flag,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) {
		pm_il_doc_setup_action.getCOMP_DS_FUND_TYPE().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_DS_REFUND_PREM_FLAG().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_DS_REFUND_DEP_FLAG().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_DS_REFUND_SURPLUS_FLAG().setDisabled(
				flag);
		pm_il_doc_setup_action.getCOMP_DS_RECVR_CHRG_FLAG().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_DS_RECVR_COMM_FLAG().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_DS_RECVR_MEDFEE_YN().setDisabled(flag);
	}

	public void setCLAIM_DETAILS_BLOCK_ENABLED(boolean flag,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) {

		pm_il_doc_setup_action.getCOMP_DS_CLM_FULSET().setSubmittedValue("");
		pm_il_doc_setup_action.getCOMP_DS_CLM_PARSET().setSubmittedValue("");
		pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_FULSET_DESC()
				.setSubmittedValue("");
		pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_PARSET_DESC()
				.setSubmittedValue("");
		/*
		 * pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN().setDS_CLM_FULSET(null);
		 * pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN().setDS_CLM_PARSET(null);
		 * pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN().setUI_M_DS_CLM_FULSET_DESC(null);
		 * pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN().setUI_M_DS_CLM_PARSET_DESC(null);
		 */
		pm_il_doc_setup_action.getCOMP_DS_CLM_FULSET().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_DS_CLM_PARSET().setDisabled(flag);
		pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_FULSET_DESC().setDisabled(
				flag);
		pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_PARSET_DESC().setDisabled(
				flag);
	}

	public String fetchDSType(String type) throws Exception {
		ResultSet resultSet = null;
		String result = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_TYPE;
			Object[] values = { type };

			resultSet = handler.executeSelectStatement(queryString, connection,
					values);
			while (resultSet.next()) {
				result = resultSet.getString(1);
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
		return result;
	}

	public void L_DISP_END_POL(String dsType,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) {
		if ("3".equalsIgnoreCase(dsType)) {
			pm_il_doc_setup_action.getCOMP_DS_END_TYPE().setRequired(true);
			pm_il_doc_setup_action.getCOMP_DS_END_TYPE().setDisabled(false);
			pm_il_doc_setup_action.getCOMP_DS_POL_CODE().setDisabled(true);
			pm_il_doc_setup_action.getCOMP_DS_POL_CODE()
					.setSubmittedValue(null);
		} else if ("1".equalsIgnoreCase(dsType)) {
			/*pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN().setDS_END_TYPE("");
			pm_il_doc_setup_action.getCOMP_DS_END_TYPE()
					.setSubmittedValue(null);*/
			//pm_il_doc_setup_action.getCOMP_DS_END_TYPE().setRequired(false);
			pm_il_doc_setup_action.getCOMP_DS_POL_CODE().setRequired(true);
			pm_il_doc_setup_action.getCOMP_DS_POL_CODE().setDisabled(false);
			pm_il_doc_setup_action.getCOMP_DS_END_TYPE().setDisabled(true);

		} else {
			pm_il_doc_setup_action.getCOMP_DS_POL_CODE()
					.setSubmittedValue(null);
			/*pm_il_doc_setup_action.getCOMP_DS_END_TYPE()
					.setSubmittedValue(null);*/
			pm_il_doc_setup_action.getCOMP_DS_END_TYPE().setRequired(false);
			pm_il_doc_setup_action.getCOMP_DS_POL_CODE().setDisabled(true);
			pm_il_doc_setup_action.getCOMP_DS_END_TYPE().setDisabled(true);
		}
	}

	public void DS_END_TYPE_WHEN_VALIDATE_ITEM(Object endType,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		String M_CODE_DESC = null;
		String CODE_DESC = null;
		try {
			if (pm_il_doc_setup_action.getCOMP_DS_TYPE().getSubmittedValue() != null) {
				if (pm_il_doc_setup_action.getCOMP_DS_TYPE()
						.getSubmittedValue().equals("3")) {
					M_CODE_DESC = fetchEndorsementType(endType.toString());
					if (M_CODE_DESC == null) {
						throw new Exception(Messages.getString(
								bundleName, "71108"));
					}
					if (M_CODE_DESC.length() > 30) {
						CODE_DESC = com.vembu.plsql.runtime.functions.StringFunctions
								.substr(M_CODE_DESC, 1, 30);
					} else {
						CODE_DESC = M_CODE_DESC;
					}
					// pm_il_doc_setup_action.getCOMP_DS_DESC().setSubmittedValue(CODE_DESC);
					pm_il_doc_setup_action.getCOMP_UI_M_DS_END_DESC()
							.setSubmittedValue(CODE_DESC);
				}
				if (pm_il_doc_setup_action.getCOMP_DS_TYPE()
						.getSubmittedValue().equals("3")
						&& endType.toString().equals("009")) {
					setCANCELLATION_DETAILS_BLOCK_ENABLE(false,
							pm_il_doc_setup_action);
					setCLAIM_DETAILS_BLOCK_ENABLED(true, pm_il_doc_setup_action);
				} else if (pm_il_doc_setup_action.getCOMP_DS_TYPE()
						.getSubmittedValue().equals("4")) {
					setCLAIM_DETAILS_BLOCK_ENABLED(false,
							pm_il_doc_setup_action);
					setCANCELLATION_DETAILS_BLOCK_ENABLE(true,
							pm_il_doc_setup_action);
				} else {
					setCANCELLATION_DETAILS_BLOCK_ENABLE(true,
							pm_il_doc_setup_action);
					setCLAIM_DETAILS_BLOCK_ENABLED(true, pm_il_doc_setup_action);
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String fetchEndorsementType(String dsType) throws Exception {
		ResultSet resultSet = null;
		String result = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_END_TYPE;
			Object[] values = { dsType };

			resultSet = handler.executeSelectStatement(queryString, connection,
					values);
			while (resultSet.next()) {
				result = resultSet.getString(1);
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
		return result;
	}

	/**
	 * Code When Validate Item
	 * 
	 * @param dsCode
	 * @param pm_il_doc_setup_action
	 * @throws Exception 
	 */
	public void DS_CODE_WHEN_VALIDATE_ITEM(Object dsCode,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		try {
			if (dsCode != null
					&& pm_il_doc_setup_action.getCOMP_DS_TYPE()
							.getSubmittedValue() != null) {
				String type = pm_il_doc_setup_action.getCOMP_DS_TYPE()
						.getSubmittedValue().toString();

				String isExists;
				isExists = L_UNIQUE_DOC_CODE(type, dsCode.toString());
				if (isExists != null) {
					throw new Exception(Messages.getString(
							bundleName, "71106"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		}
	}

	public String L_UNIQUE_DOC_CODE(String type, String code) throws Exception {
		ResultSet resultSet = null;
		String result = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_CODE;
			Object[] values = { type, code };

			resultSet = handler.executeSelectStatement(queryString, connection,
					values);
			if (resultSet.next()) {
				result = resultSet.getString(1);
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
		return result;
	}

	/**
	 * Policy Link Code Validation
	 * 
	 * @param dsCode
	 * @param pm_il_doc_setup_action
	 * @throws Exception 
	 */
	public void DS_POL_CODE_WHEN_VALIDATE_ITEM(Object linkCode,
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		try {
			String DS_TYPE = pm_il_doc_setup_action.getCOMP_DS_TYPE()
					.getSubmittedValue().toString();
			if (DS_TYPE.equals("1") && linkCode != null) {
				if (pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
						.getUI_M_CALC_METHOD().equals("1")) {
					String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_POL_CODE$WHEN_VALIDATE_ITEM_QUERY2;
					String result = fetchPOL_CODE(queryString, linkCode
							.toString());
					if (result == null) {
						throw new Exception(Messages.getString(
								bundleName, "1802"));
					}
				} else {
					String queryString = PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_SETUP$DS_POL_CODE$WHEN_VALIDATE_ITEM_QUERY1;
					String result = fetchPOL_CODE(queryString, linkCode
							.toString());
					if (result == null) {
						throw new Exception(Messages.getString(
								bundleName, "1802"));
					}
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String fetchPOL_CODE(String query, String linkCode) throws Exception {
		String result = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();

			Object[] values = { linkCode };

			resultSet = handler.executeSelectStatement(query, connection,
					values);
			while (resultSet.next()) {
				result = resultSet.getString(1);
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

		return result;
	}

	/**
	 * From Date When Validate item
	 * 
	 * @param fromDate
	 * @param toDate
	 * @throws Exception 
	 */
	public void DS_EFF_FM_DT_WHEN_VALIDATE_ITEM(Date fromDate, Date toDate) throws Exception {
		Date date = new Date("01/01/1900");
		try {
			if (fromDate != null && toDate != null) {

				if (fromDate.after(toDate)) {
					Object[] params = { "FROM DATE", "<=", "TO DATE" };
					throw new Exception(Messages.getString(bundleName, "91014",
							params));
				} else if (fromDate.before(date)) {
					Object[] params = { "FROM DATE", ">=", "01/01/1900" };
					throw new Exception(Messages.getString(bundleName, "91014",
							params));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void DS_EFF_TO_DT_WHEN_VALIDATE_ITEM(Date fromDate, Date toDate)
			throws Exception {
		Date date = new Date("31/12/2999");
		try {
			if (fromDate != null && toDate != null) {
				if (fromDate.after(toDate)) {
					Object[] params = { "FROM DATE", "<=", "TO DATE" };
					throw new Exception(Messages.getString(bundleName, "91014",
							params));
				} else if (toDate.after(date)) {
					Object[] params = { "TO DATE", "<=", "31/12/2999" };
					throw new Exception(Messages.getString(bundleName, "91014",
							params));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void DS_CLM_PARSET_WHEN_VALIDATE_ITEM(
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		try {
			if (pm_il_doc_setup_action.getCOMP_DS_CLM_PARSET()
					.getSubmittedValue() != null) {
				procedures.P_VAL_SYSTEM("IL_ADDL_STAT",
						pm_il_doc_setup_action.getCOMP_DS_CLM_PARSET()
								.getSubmittedValue().toString(), "E");

			} else {
				pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_PARSET_DESC()
						.setSubmittedValue(null);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void DS_CLM_FULSET_WHEN_VALIDATE_ITEM(
			PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		try {
			if (pm_il_doc_setup_action.getCOMP_DS_CLM_FULSET()
					.getSubmittedValue() != null) {
				ArrayList<String> desc = procedures.P_VAL_SYSTEM(
						"IL_ADDL_STAT", pm_il_doc_setup_action
								.getCOMP_DS_CLM_FULSET().getSubmittedValue()
								.toString(), "E");
				System.out
						.println("DESC************************" + desc.get(0));
				pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_FULSET_DESC()
						.setSubmittedValue((String) desc.get(0));
			} else {
				pm_il_doc_setup_action.getCOMP_UI_M_DS_CLM_FULSET_DESC()
						.setSubmittedValue(null);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void callErrorMap(UIInput input) {
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PRE_INSERT(PM_IL_DOC_SETUP_ACTION pm_il_doc_setup_action) throws Exception {
		String type = pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
				.getDS_TYPE();
		String code = pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
				.getDS_CODE();
		String result = null;
		try {
			result = L_UNIQUE_DOC_CODE(type, code);
			if (result != null) {
				throw new Exception(Messages.getString(bundleName,
						"71106"));
			}
			pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
					.setDS_CR_DT(
							new java.sql.Date(Calendar.getInstance()
									.getTimeInMillis()));
			pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
					.setDS_FRZ_FLAG("N");
			pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN().setDS_CR_UID(
					CommonUtils.getControlBean().getM_USER_ID());
			if (pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
					.getDS_REFUND_PREM_FLAG() != null) {
				if (pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
						.getDS_REFUND_PREM_FLAG().equals("N")) {
					pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
							.setDS_REFUND_DEP_FLAG("N");
					pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
							.setDS_RECVR_CHRG_FLAG("N");
					pm_il_doc_setup_action.getPM_IL_DOC_SETUP_BEAN()
							.setDS_RECVR_MEDFEE_YN("N");

				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
