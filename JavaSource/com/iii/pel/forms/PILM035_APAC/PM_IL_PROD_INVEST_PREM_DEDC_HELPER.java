package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_INVEST_PREM_DEDC_HELPER {

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String C1 = "SELECT 'X' " + "FROM   PM_IL_PROD_INVEST_PREM_DEDC "
				+ "WHERE  PIPD_TYPE            = ? "
				+ "AND		 PIPD_PROD_CODE       = ?";

		String C2 = "SELECT * FROM   PM_IL_PROD_INVEST_PREM_DEDC "
			+ "WHERE PIPD_CODE = ? AND PIPD_PROD_CODE = ?";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN = compositeAction
				.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
				.getPM_IL_PROD_INVEST_PREM_DEDC_BEAN();
		PM_IL_PRODUCT PM_IL_PRODUCT_BEAN = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		// L_INVEST_SRNO_UNIQUE;
		// L_VAL_BASIC_COVER;
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_CR_DT(new CommonUtils()
				.getCurrentDate());
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_CR_UID((String) CommonUtils
				.getGlobalObject("GLOBAL.M_USER_ID"));
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE()); 

		try {
			con = CommonUtils.getConnection();
			if ("1".equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_BEAN
					.getPIPD_TYPE())) {
				// L_VAL_UNIQUE_DEDC_CODE;
			} else {
				if (PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_CODE() != null) {
					// L_VAL_UNIQUE_DEDC_CODE;
					rs2 = handler.executeSelectStatement(C2, con, new Object[] {
							PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_CODE(),
							PM_IL_PRODUCT_BEAN.getPROD_CODE() });
					if (rs2.next()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71018"));
					}
				} else {
					rs1 = handler.executeSelectStatement(C1, con, new Object[] {
							PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE(),
							PM_IL_PRODUCT_BEAN.getPROD_CODE() });
					if (rs1.next()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71018"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_bean = compositeAction
				.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
				.getPM_IL_PROD_INVEST_PREM_DEDC_BEAN();
		PM_IL_PRODUCT PM_IL_PRODUCT_BEAN = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT 'X' " + "FROM   PM_IL_PROD_INVEST_PREM_DEDC "
					+ "WHERE  PIPD_TYPE            = ? "
					+ "AND		 PIPD_PROD_CODE       = ? "
					+ "AND    ROWID                <> ?";

			String C2 = "SELECT 'X' " + "FROM   PM_IL_PROD_INVEST_PREM_DEDC "
					+ "WHERE  PIPD_TYPE            = ? "
					+ "AND		 PIPD_PROD_CODE       = ? "
					+ "AND    PIPD_CODE						= NULL";

			// L_INVEST_SRNO_UNIQUE;
			// L_VAL_BASIC_COVER;
			PM_IL_PROD_INVEST_PREM_DEDC_bean.setPIPD_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_INVEST_PREM_DEDC_bean
					.setPIPD_CR_UID((String) CommonUtils
							.getGlobalObject("GLOBAL.M_USER_ID"));
			if ("1".equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
					.getPIPD_TYPE())) {
				// L_VAL_UNIQUE_DEDC_CODE;
			} else {
				if (PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_CODE() != null) {
					// L_VAL_UNIQUE_DEDC_CODE;
					rs2 = handler.executeSelectStatement(C2, con, new Object[] {
							PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_TYPE(),
							PM_IL_PRODUCT_BEAN.getPROD_CODE()});
					if (rs2.next()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71018"));
					}
				} else {
					rs1 = handler.executeSelectStatement(C1, con, new Object[] {
							PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_TYPE(),
							PM_IL_PRODUCT_BEAN.getPROD_CODE(),
							PM_IL_PROD_INVEST_PREM_DEDC_bean.getROWID() });
					if (rs1.next()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71018"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	
	/*change the argument of method by raja on 30-05-2017 for ZBILQC-1726955*/
	
	/*public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)*/
	public void POST_QUERY(PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_bean)
			throws Exception {
		
		/*added by raja on 30-05-2017 for ZBILQC-1726955 */
		/*PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_bean = compositeAction
				.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
				.getPM_IL_PROD_INVEST_PREM_DEDC_BEAN();*/
		/*end*/
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_TYPE() != null) {
				if ("3".equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
						.getPIPD_TYPE())
						|| "8"
								.equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
										.getPIPD_TYPE())) {
					
					list = DBProcedures.callP_VAL_CODES("IL_CHARGE",
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_CODE(),
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getUI_M_PIPD_CODE_DESC(), "N", "N");
					if(list.get(0) != null){
						PM_IL_PROD_INVEST_PREM_DEDC_bean.setUI_M_PIPD_CODE_DESC(list.get(0));
					}
					 
				} else if ("7"
						.equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
								.getPIPD_TYPE())) {
					/*
					 * P_VAL_CODES('IL_LOAN_CODE',
					 * :PM_IL_PROD_INVEST_PREM_DEDC.PIPD_CODE,
					 * :PM_IL_PROD_INVEST_PREM_DEDC.M_PIPD_CODE_DESC, 'N', 'N',
					 * NULL);
					 */
					list = DBProcedures.callP_VAL_CODES("IL_LOAN_CODE",
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_CODE(),
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getUI_M_PIPD_CODE_DESC(), "N", "N");
					if(list.get(0) != null){
						PM_IL_PROD_INVEST_PREM_DEDC_bean.setUI_M_PIPD_CODE_DESC(list.get(0));
					}
				} else if ("4"
						.equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
								.getPIPD_TYPE())) {
					/*
					 * P_VAL_CODES('IL_LOAD',
					 * :PM_IL_PROD_INVEST_PREM_DEDC.PIPD_CODE,
					 * :PM_IL_PROD_INVEST_PREM_DEDC.M_PIPD_CODE_DESC, 'N', 'N',
					 * NULL);
					 */
					list = DBProcedures.callP_VAL_CODES("IL_LOAD",
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_CODE(),
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getUI_M_PIPD_CODE_DESC(), "N", "N");
					if(list.get(0) != null){
						PM_IL_PROD_INVEST_PREM_DEDC_bean.setUI_M_PIPD_CODE_DESC(list.get(0));
					}
					
				} else if ("5"
						.equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
								.getPIPD_TYPE())) {
					/*
					 * P_VAL_CODES('IL_DISC',
					 * :PM_IL_PROD_INVEST_PREM_DEDC.PIPD_CODE,
					 * :PM_IL_PROD_INVEST_PREM_DEDC.M_PIPD_CODE_DESC, 'N', 'N',
					 * NULL);
					 */
					list = DBProcedures.callP_VAL_CODES("IL_DISC",
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getPIPD_CODE(),
							  PM_IL_PROD_INVEST_PREM_DEDC_bean.getUI_M_PIPD_CODE_DESC(), "N", "N");
					if(list.get(0) != null){
						PM_IL_PROD_INVEST_PREM_DEDC_bean.setUI_M_PIPD_CODE_DESC(list.get(0));
					}
				} else if ("1"
						.equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
								.getPIPD_TYPE())) {
					/*
					 * L_VAL_COVER_BASIC(:PM_IL_PROD_INVEST_PREM_DEDC.PIPD_CODE,
					 * :PM_IL_PROD_INVEST_PREM_DEDC.M_PIPD_CODE_DESC, 'N', 'N');
					 */
				} else if ("2"
						.equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_bean
								.getPIPD_TYPE())) {
					/*
					 * L_VAL_COVER_ADDL(:PM_IL_PROD_INVEST_PREM_DEDC.PIPD_CODE,
					 * :PM_IL_PROD_INVEST_PREM_DEDC.M_PIPD_CODE_DESC, 'N', 'N');
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_INVEST_PREM_DEDC_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_INVEST_PREM_DEDC> dataList = compositeAction
					.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
					.getDataList_PM_IL_PROD_INVEST_PREM_DEDC();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN = dataList
						.get(0);
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN()
						.setPM_IL_PROD_INVEST_PREM_DEDC_BEAN(
								PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenCreateRecord(
			PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN) {
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_INCL_PREM_YN("Y");
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_DEDC_YN("N");
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_TYPE("8");
	}

	public void whenNewRecordInstance(
			PM_IL_PROD_INVEST_PREM_DEDC_ACTION PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN) {
		PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN = PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN
				.getPM_IL_PROD_INVEST_PREM_DEDC_BEAN();
		if ("1".equalsIgnoreCase(PM_IL_PROD_INVEST_PREM_DEDC_BEAN
				.getPIPD_TYPE())) {
			PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN.getCOMP_PIPD_CODE()
					.setDisabled(true);
		} else {
			PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN.getCOMP_PIPD_CODE()
					.setDisabled(false);
		}
	}

	public void whenValidateItem_PIPD_SR_NO(String prodCode,
			String rowId,PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN) {
		//new PILM035_APAC_DBProcedures().L_INVEST_SRNO_UNIQUE(srNo, prodCode,
				//rowId);
		/*if (PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_SRNO() <= 0) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91296"));
		}*/
	}
	
	
	public void whenValidatePIPD_CODE(String pipdCode,
			PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN)
			throws Exception {
		ArrayList<String> list = null;
		try {
			if (pipdCode != null) {
				list = new DBProcedures().P_VAL_CODES("IL_CHARGE",
						PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_CODE(), null,
						"N", "E", null);
				if (list != null && list.size() > 0) {
					PM_IL_PROD_INVEST_PREM_DEDC_BEAN
							.setUI_M_PIPD_CODE_DESC(list.get(0));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
/*Newly added By Dhinesh on 12-06-2017 */
	
	public void whenValidatePIPD_TYPE(String pipdType,
			PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN)
			throws Exception {
		String selectStatement = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM='IL_DEDC_TYP' AND LIV_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pipdType });
			while (resultSet.next()) {
					
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN
				.setUI_M_PIPD_TYPE_DESC(resultSet.getString("LIV_CODE_DESC"));
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/* End */
	/*NEWLY ADDED BY DHINESH ON 11-07-2017  for ssp call id : ZBILQC-1731235 */
	public void whenvalidate_defaultpipe_code(String pipdType,PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT COVER_CODE, COVER_DESC  FROM PM_IL_COVER WHERE COVER_CODE IN" + " (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = ? )   AND ? = '1' ORDER BY 1";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_PLAN_CODE(),pipdType });
			while (resultSet.next()) {
				compositeAction.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN().getPM_IL_PROD_INVEST_PREM_DEDC_BEAN().setPIPD_CODE(resultSet.getString("COVER_CODE"));
				compositeAction.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN().getPM_IL_PROD_INVEST_PREM_DEDC_BEAN().setUI_M_PIPD_CODE_DESC(resultSet.getString("COVER_DESC"));
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/* End */
	
	
	/*PIPD_CODE
	UI_M_PIPD_CODE_DESC*/
	
}
