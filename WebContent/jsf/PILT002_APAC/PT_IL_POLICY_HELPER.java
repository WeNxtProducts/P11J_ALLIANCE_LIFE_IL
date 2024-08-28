package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.pel.utils.P9ILPK_CHECK_OFF_PROPOSAL;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.pel.utils.PCOPK_SYS_VARS;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POLICY_HELPER extends CommonAction {
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	DBProcedures procedures = new DBProcedures();
	LIFELIB lifelibProcedures = new LIFELIB();
	CRUDHandler handler = new CRUDHandler();
	P9ILPK_POLICY_SP_REVIVAL sp_revival = new P9ILPK_POLICY_SP_REVIVAL();

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_POLICY_DELEGATE().executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POST_INSERT(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		System.out.println("--------------- Enter POST_INSERT Method -----------------");
		
		
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet rst = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		DBProcedures procedures = new DBProcedures();
		String M_ENCRYPTED_NO = null;
		String M_PLAN_TYPE = null;
		String M_FOUND = null;
		String M_CREDIT_CARD_UPD_YN = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String C1 = " SELECT PLAN_TYPE   FROM   PM_IL_PLAN WHERE"
				+ "  PLAN_CODE = ? AND    PLAN_FRZ_FLAG = 'N' ";

		String C1A = " SELECT 'X'   FROM   PT_IL_POL_BENEFICIARY "
				+ " WHERE  PBEN_POL_SYS_ID = ? ";

		String C2 = " SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N') FROM MENU_USER"
				+ "		 WHERE USER_ID = ? ";
		String queryEncrypt = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		P9ILPK_AGENCY_MGMT p9ilpk_agency_mgmt = new P9ILPK_AGENCY_MGMT();
		try {
			connection = CommonUtils.getConnection();
			p9ilpk_policy.P_INS_POL_CHARGES(CommonUtils
					.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_START_DT()));

			if (!"Q".equalsIgnoreCase(CommonUtils.nvl(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_13"), "P"))) {

				p9ilpk_policy.P_INS_POL_DOLIST(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						null, "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_START_DT()));

				p9ilpk_policy.P_INS_ADDL_COND(pt_il_policy_bean
						.getPOL_PROD_CODE(), CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()));

			}
			values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };

			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				M_PLAN_TYPE = resultSet.getString(1);
			}

			if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {

				p9ilpk_policy.P_INS_POL_FUND_DTL(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()));

			}

			// IL_CALC_MTHD commented by akash to make normal flow with takaful
			// way.

			if (dummy_bean.getUI_M_CALC_METHOD() != null
			/* && dummy_bean.getUI_M_CALC_METHOD() == 1 */) {
				if (CommonUtils.nvl(dummy_bean.getUI_M_IL_BROK_CALC(), 1) == 1
						&& "M".equalsIgnoreCase(CommonUtils.nvl(M_PLAN_TYPE,
								"X"))) {
					p9ilpk_policy.P_INS_POL_BROKER(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()));

				}
				// Commented by akash MRTA Agent is specific for STMB dated
				// 31-jan-2013

				/*
				 * else if ("M".equalsIgnoreCase(CommonUtils.nvl(M_PLAN_TYPE,
				 * "X"))) { p9ilpk_agency_mgmt.INS_MRTA_AGENT(CommonUtils
				 * .getProcedureValue(pt_il_policy_bean .getPOL_SYS_ID())); }
				 */
			}
			
			System.out.println("dummy_bean.getUI_M_CALC_METHOD()   : "+dummy_bean.getUI_M_CALC_METHOD());
			if (dummy_bean.getUI_M_CALC_METHOD() != null
			/* && dummy_bean.getUI_M_CALC_METHOD() == 1 */) {

				new PT_IL_POL_ASSURED_DTLS_HELPER()
						.L_INSERT_PT_IL_POL_ASSUR_DTLS(
								dummy_bean.getUI_M_CONT_REF_ID1(),
								dummy_bean,
								dummy_bean.getUI_M_CONT_REF_ID2(),
								pt_il_policy_bean,
								compositeAction
										.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
										.getPT_IL_POL_ASSURED_DTLS_BEAN());

			}
			String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();
			if (!"AD".equals(POL_PYMT_TYPE) || !"SC".equals(POL_PYMT_TYPE)
					|| !"CC".equals(POL_PYMT_TYPE)
					|| !"C1".equals(POL_PYMT_TYPE)
					|| !"C2".equals(POL_PYMT_TYPE)
					|| !"C3".equals(POL_PYMT_TYPE)
					|| !"C4".equals(POL_PYMT_TYPE)
					|| !"C5".equals(POL_PYMT_TYPE)
					|| !"C6".equals(POL_PYMT_TYPE)) {

				/*
				 * values = new Object[] {
				 * pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO(),
				 * pt_il_policy_bean.getPOL_SYS_ID(), "PE",
				 * pt_il_policy_bean.getPOL_PYMT_TYPE() }; resultSet = new
				 * CRUDHandler().executeSelectStatement(queryEncrypt,
				 * connection, values); while (resultSet.next()) {
				 * M_ENCRYPTED_NO = resultSet.getString(1); }
				 */
			} else if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)) {

				values = new Object[] { CommonUtils.getControlBean()
						.getM_USER_ID() };
				resultSet = handler.executeSelectStatement(C2, connection,
						values);
				if (resultSet.next()) {
					M_CREDIT_CARD_UPD_YN = resultSet.getString(1);
				}

				if (!"XXXXXXXXXXXX".equalsIgnoreCase(CommonUtils.SUBSTR(
						pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO()
								.toString(), 1, 12))) {
					values = new Object[] {
							pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO(),
							pt_il_policy_bean.getPOL_SYS_ID(), "PE",
							pt_il_policy_bean.getPOL_PYMT_TYPE() };
					resultSet = new CRUDHandler().executeSelectStatement(
							queryEncrypt, connection, values);
					while (resultSet.next()) {
						M_ENCRYPTED_NO = resultSet.getString(1);
					}
				} else if ("XXXXXXXXXXXX".equalsIgnoreCase(CommonUtils.SUBSTR(
						pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO_1()
								.toString(), 1, 12))) {
					values = new Object[] {
							pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO_1(),
							pt_il_policy_bean.getPOL_SYS_ID(), "PE",
							pt_il_policy_bean.getPOL_PYMT_TYPE() };
					resultSet = new CRUDHandler().executeSelectStatement(
							queryEncrypt, connection, values);
					while (resultSet.next()) {
						M_ENCRYPTED_NO = resultSet.getString(1);
					}

				}
			}

			new PILT002_APAC_LOCAL_PROCEDURES()
					.L_INST_MAT_DTLS(compositeAction);
			/*
			 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE; RAISE
			 * FORM_TRIGGER_FAILURE; END;
			 * 
			 */

			/*Added by ganesh on 06-06-2017-17:10, as reported by Kuzhandaivel */
			if ((!("A".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N")))
					&& (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(),0) == 0)
					&& (CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"), "P") != "Q"))) {
				p9ilpk_policy.P_INS_DISC_LOAD(
						pt_il_policy_bean.getPOL_PROD_CODE(),
						CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_START_DT()));
			}
			
			/*end*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(rst);
		}
	}

	public void P_CONVERT_YN_STATUS(PT_IL_POLICY pt_il_policy_bean,
			DUMMY_ACTION dummy_action) throws Exception {
		Connection connection = null;
		ResultSet rs1 = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		Integer M_POL_END_NO_IDX = 0;
		String query1 = "SELECT  MAX(POL_END_NO_IDX)  FROM  PT_IL_POLICY   WHERE  POL_NO  =  ?";
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_NO() };
			rs1 = handler.executeSelectStatement(query1, connection, values);
			if (rs1.next()) {
				M_POL_END_NO_IDX = rs1.getInt(1);
			}
			if ("A".equalsIgnoreCase(pt_il_policy_bean.getPOL_STATUS())
					&& pt_il_policy_bean.getPOL_END_NO_IDX() == M_POL_END_NO_IDX) {
				if ("Y".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_CONVERT_YN(), "N"))) {
					dummy_action.getCOMP_UI_M_POL_CONVERT_YN().setValue(
							"Converted to Cert");
				} else {
					dummy_action.getCOMP_UI_M_POL_CONVERT_YN().setValue(
							"Not Converted to Cert");
				}
			} else {
				dummy_action.getCOMP_UI_M_POL_CONVERT_YN().setValue(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POST_QUERY(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String M_VAR1 = null;
		Date M_SCHD_PYMT_DT = null;
		String delBrokerDtl = " DELETE FROM PT_IL_POL_BROKER_DTL  "
				+ " WHERE POBD_POBH_SYS_ID IN (SELECT POBH_SYS_ID   FROM PT_IL_POL_BROKER_HEAD "
				+ " WHERE POBH_POL_SYS_ID = ? ) ";

		String delBrokerHead = " DELETE FROM PT_IL_POL_BROKER_HEAD  WHERE "
				+ " POBH_POL_SYS_ID =? ";

		String query1 = " SELECT DS_DESC    FROM   PM_IL_DOC_SETUP   WHERE  DS_TYPE = '3'"
				+ "      AND    DS_FRZ_FLAG = 'N'     AND    DS_CODE = ? ";

		String query2 = " SELECT 'X'  FROM   PT_IL_POLICY  WHERE  "
				+ " POL_NO = :PT_IL_POLICY.POL_PROP_NO  AND    POL_DS_TYPE = '1'";

		String query3 = " SELECT CUST_NAME FROM   PM_CUSTOMER  WHERE  "
				+ " CUST_CODE= ? AND  " + "     CUST_GROUP_CODE =? ";

		String query4 = "SELECT POAD_ASSURED_NAME FROM   PT_IL_POL_ASSURED_DTLS "
				+ " WHERE  POAD_REF_ID1 = :PT_IL_POLICY.POL_INTRODUCER_REF_ID1 ";

		String query5 = " SELECT  RPS_DESC   FROM    PM_IL_RI_POOL_SETUP  WHERE"
				+ "   RPS_CODE = ? ";

		String query6 = "     SELECT CUST_DOB  FROM   PM_CUSTOMER  WHERE  "
				+ "CUST_CODE =? ";

		String query7 = " SELECT PROD_AGE_CALC_FLAG,PROD_PREM_CALC_MTHD "
				+ "  FROM   PM_IL_PRODUCT      WHERE  PROD_CODE = ? ";

		String query8 = " SELECT 'X' FROM   PT_IL_PREM_COLL   WHERE "
				+ " PC_POL_SYS_ID = ?  AND    NVL(PC_FAC_CLOSE_FLAG,'N') = 'Y'";

		
		/*changed the query by raja on 12-08-2017 for eneble the endorsement button*/
		String query9 = "  SELECT 'X'  FROM   PT_IL_CLAIM WHERE "
				+ " CLAIM_POL_SYS_ID = ?  AND    CLAIM_TYPE IN ('A','D')"
				+ "AND NVL(CLAIM_MEMB_CODE,CLAIM_ASSR_CODE) = NVL(CLAIM_ASSR_CODE,'XXX')";
		/*end*/

		String query10 = " SELECT DECODE(? ,'ENG',BANK_NAME,BANK_NAME_BL)"
				+ " FROM   FM_BANK    WHERE  BANK_CODE= ? ";

		String query12 = " SELECT PS_VALUE   FROM   PP_SYSTEM    WHERE  PS_TYPE = 'IL_COPY_ED' ";

		String query13 = " SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')   FROM MENU_USER"
				+ " WHERE USER_ID = ? ";

		String query13a = "  SELECT PC_SYS_ID   FROM  PT_IL_PREM_COLL  WHERE PC_PREM_TYPE = 'N' "
				+ "	AND   PC_POL_SYS_ID = ? ";

		String query14 = "   SELECT ACV_LC_VALUE, ACV_FC_VALUE  FROM PT_AGENT_COMM_VALUES WHERE ACV_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID "
				+ "  AND   ACV_PC_SYS_ID = M_PC_SYS_ID";

		String query11 = "   SELECT 'X' FROM  PP_SYSTEM WHERE  PS_TYPE = 'IL_EX_SRCBUS' AND PS_CODE = 'IL_EX_SRCBUS'"
				+ "   AND    INSTR (PS_CODE_DESC, ? ) > 0 ";
		String queryEncrypt = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";

		String query_charge = "SELECT SUM(POC_FC_VALUE) FROM PT_IL_POL_CHARGE WHERE POC_APPLY_PERIOD='S' AND POC_TYPE='C' AND POC_POL_SYS_ID= ? ";

		String query17 = "SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL"
				+ " WHERE PC_POL_SYS_ID = ?" + " AND PC_PAID_DT IS NULL"
				+ " AND PC_SCHD_PYMT_DT <=?";

		// String E1="SELECT SUM(POC_LC_VALUE),SUM(POC_FC_VALUE) FROM
		// PT_IL_POL_CHARGE WHERE POC_POL_SYS_ID=? AND POC_TYPE='C' ";

		String M_ENCRYPTED_NO = null;
		Date M_CUST_DOB = null;
		String M_POAD_ASSURED_NAME = null;
		String M_ASSR_NAME = null;
		String M_ASSR_BL_NAME = null;
		String M_PROD_PREM_CALC_MTHD = null;
		String M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_DUMMY2 = null;
		String M_PS_CODE_DESC = null;
		String M_CUST_NAME = null;
		String M_CREDIT_CARD_UPD_YN = null;
		Double M_PS_VALUE_1 = null;
		String M_ACV_LC_VALUE = null;
		String M_ACV_FC_VALUE = null;
		String M_PC_SYS_ID = null;
		Double fcvalue = 0.0;
		Double lcvalue = 0.0;
		Double fcsCharge = 0.0;
		Connection connection = null;
		ResultSet rs12 = null, rs10 = null, rs13 = null, rs3 = null, rs1 = null, rs8 = null, rs9 = null, rsEncrypt = null, rs5 = null, rs6 = null, rs7 = null, rs11 = null, rsCharge = null, rs17 = null,rs18 = null;
		Object[] values = {};
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();
		DBProcedures procedures = new DBProcedures();
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		ArrayList<OracleParameter> pvalOrclList = new ArrayList<OracleParameter>();
		ArrayList<String> pvalList = new ArrayList<String>();
		try {
			connection = CommonUtils.getConnection();
			rs12 = handler.executeSelectStatement(query12, connection);
			if (rs12.next()) {
				M_PS_VALUE_1 = rs12.getDouble(1);
			}
			if (M_PS_VALUE_1 == 1) {
				pt_il_policy_action.getCOMP_UI_M_BUT_COPY().setRendered(true);
			} else if (M_PS_VALUE_1 == 2) {
				pt_il_policy_action.getCOMP_UI_M_BUT_COPY().setRendered(false);
			}
			/*
			 * condition modified by Ameen on 04-04-2018
			 * if (pt_il_policy_bean.getPOL_CONT_AD_BANK_CODE() != null) {*/
			if (pt_il_policy_bean.getPOL_CONT_AD_BANK_CODE() != null && !"".equals(pt_il_policy_bean.getPOL_CONT_AD_BANK_CODE().trim())) {
				values = new Object[] {
						CommonUtils.getControlBean().getM_LANG_CODE(),
						pt_il_policy_bean.getPOL_CONT_AD_BANK_CODE() };
				rs10 = handler.executeSelectStatement(query10, connection,
						values);
				if (rs10.next()) {
					pt_il_policy_bean.setUI_M_BANK_CODE_DESC(rs10.getString(1));
				} else {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Invalid Bank . Please re-enter.." }));
				}
			}

			rsCharge = handler.executeSelectStatement(query_charge, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			if (rsCharge.next()) {
				fcsCharge = rsCharge.getDouble(1);
			}
			pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_CUST(fcsCharge);
			pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_CUST(fcsCharge);

			if ("N".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				// P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE);
				// //TODO PENDING
			}

			values = new Object[] { pt_il_policy_bean.getPOL_END_CODE() };

			rs1 = handler.executeSelectStatement(query1, connection, values);
			if (rs1.next()) {
				pt_il_policy_bean.setUI_M_POL_END_CODE_DESC(rs1.getString(1));
			}

			pvalOrclList = lifelib.P_VAL_DIVN(pt_il_policy_bean
					.getPOL_DIVN_CODE(), pt_il_policy_bean
					.getUI_M_POL_DIVN_DESC(), "N", "N");
			if (pvalOrclList != null && !pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_DIVN_DESC(pvalOrclList.get(0)
						.getValue());
				/*Modified by Saranya on 04/04/2017 
				 * 
				 * CommonUtils.setGlobalVariable("GLOBAL.M_DIVN_CODE",
						pt_il_policy_bean.getPOL_DIVN_CODE());*/
			}

			// --REV1.0 TO VALIDATE THE POL_GROUP_CODE
			if ("PG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				ArrayList<OracleParameter> pgcList = new PCOPK_GENERAL()
						.P_VAL_GRP_CODE(pt_il_policy_bean
								.getPOL_PROD_GROUP_CODE(), "N", CommonUtils
								.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),
								CommonUtils.getControlBean().getM_LANG_CODE(),
								pt_il_policy_bean.getUI_M_POL_PROD_GROUP_CODE());
				if (pgcList != null) {
					pt_il_policy_bean
							.setUI_M_POL_PROD_GROUP_CODE((String) pgcList
									.get(0).getValueObject());
				}
			}
			// --REV1.0 ENDS HERE

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs8 = handler.executeSelectStatement(query8, connection, values);
			if (rs8.next()) {
				M_DUMMY = rs8.getString(1);
				dummy_action.getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
			}
			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs9 = handler.executeSelectStatement(query9, connection, values);
			if (rs9.next()) {
				M_DUMMY1 = rs9.getString(1);
				dummy_action.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
			}
			System.out.println("PT_IL_POLICY_HELPER ----- POST QUERY() ");
			System.out.println("POL_DIVN_CODE        : "+pt_il_policy_bean.getPOL_DIVN_CODE());
			
			System.out.println("POL_DEPT_CODE        : "+pt_il_policy_bean.getPOL_DEPT_CODE());
			
			System.out.println("UI_M_POL_DEPT_DESC   : "+pt_il_policy_bean.getUI_M_POL_DEPT_DESC());
			
			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = lifelib.P_VAL_DEPT(pt_il_policy_bean
					.getPOL_DIVN_CODE(), pt_il_policy_bean.getPOL_DEPT_CODE(),
					pt_il_policy_bean.getUI_M_POL_DEPT_DESC(), "N", "N");
			if (pvalOrclList != null && !pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_DEPT_DESC(pvalOrclList.get(0)
						.getValue());
			}

			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = lifelib.P_VAL_CLASS(pt_il_policy_bean
					.getPOL_CLASS_CODE(), pt_il_policy_bean
					.getUI_M_POL_CLASS_DESC(), "N", "N");
			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_CLASS_DESC(pvalOrclList.get(0)
						.getValue());
			}
			pvalList = new ArrayList<String>();
			pvalList = procedures.callP_VAL_PLAN(pt_il_policy_bean
					.getPOL_PLAN_CODE(), "N", "N");

			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_PLAN_DESC(pvalList.get(0));
			}

			pvalList = new ArrayList<String>();
			/*changed by raja on 09-06-2017 for ZBILQC-1724894*/
			pvalList = lifelib.P_VAL_CUST_NAME(pt_il_policy_bean.getPOL_CUST_CODE(),
					pt_il_policy_bean.getUI_M_POL_CUST_DESC(), "N", "N",
					pt_il_policy_bean.getPOL_DIVN_CODE());
			if (!pvalList.isEmpty()) {
				// newly added the below if condition alone for general
				// endorsement
				/*
				 * if(!("001".equals(CommonUtils.nvl(pt_il_policy_bean
				 * .getPOL_END_TYPE(), "000")))){//ended here
				 */pt_il_policy_bean.setUI_M_POL_CUST_DESC(pvalList.get(0));
				// }
			}

			pvalList = new ArrayList<String>();
			pvalList = pkg_pilt002_apac.P_VAL_CURR(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), pt_il_policy_bean
					.getUI_M_POL_SA_CURR_DESC(), "N", "N", pt_il_policy_bean
					.getPOL_CUST_CODE());
			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_SA_CURR_DESC(pvalList.get(0));
			}

			pvalList = new ArrayList<String>();
			pvalList = pkg_pilt002_apac.P_VAL_CURR(pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(), pt_il_policy_bean
					.getUI_M_POL_CUST_CURR_DESC(), "N", "N", pt_il_policy_bean
					.getPOL_CUST_CODE());
			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_CUST_CURR_DESC(pvalList.get(0));
			}
			pvalList = new ArrayList<String>();
			pvalList = pkg_pilt002_apac.P_VAL_PRODUCT(pt_il_policy_bean
					.getPOL_PROD_CODE(), CommonUtils
					.getProcedureValue(pt_il_policy_bean.getPOL_ISSUE_DT()),
					"N");
			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_PROD_DESC(pvalList.get(0));
			}

			pvalList = new ArrayList<String>();
			pvalList = pkg_pilt002_apac.P_VAL_STAFF_CLASS_CODE(
					pt_il_policy_bean.getPOL_STAFF_CCLASS_CODE(),
					pt_il_policy_bean.getUI_M_CCLAS_CLASS_DESC(), "N");

			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_CCLAS_CLASS_DESC(pvalList.get(0));
			}
			pvalList = new ArrayList<String>();
			pvalList = pkg_pilt002_apac.P_VAL_CONT_CODE(pt_il_policy_bean
					.getPOL_EMPLOYER_CODE(), pt_il_policy_bean
					.getUI_M_CONT_NAME(), "N");
			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_CONT_NAME(pvalList.get(0));
			}
			// --Added by Indra on 18/10/2008
			pvalList = new ArrayList<String>();
			/*changed by raja on 09-06-2017 for ZBILQC-1724894*/
			pvalList = lifelib.P_VAL_CUST_NAME(pt_il_policy_bean
					.getPOL_PAYOR_SDCODE(), pt_il_policy_bean
					.getUI_M_PAYOR_CONT_NAME(), "N", "N", pt_il_policy_bean
					.getPOL_DIVN_CODE());
			if (!pvalList.isEmpty()) {
				pt_il_policy_bean.setUI_M_PAYOR_CONT_NAME(pvalList.get(0));
			}

			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("IL_DVP_CODE",
					pt_il_policy_bean.getPOL_DEVELOPER_CODE(),
					pt_il_policy_bean.getUI_M_DEVELOPER_CODE_DESC(), "N", "N",
					null);
			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_DEVELOPER_CODE_DESC(pvalOrclList.get(
						0).getValue());
			}
			// -- ADDED BY DHAMODHARAN FOR POSTAL CODE ON 01/NOV/2007
			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("POSTAL",
					pt_il_policy_bean.getPOL_OFF_AREA_CODE(), pt_il_policy_bean
							.getUI_M_POSTAL_NAME(), "N", "N", null);
			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POSTAL_NAME(pvalOrclList.get(0)
						.getValue());
			}

			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("POSTAL",
					pt_il_policy_bean.getPOL_RES_AREA_CODE(), pt_il_policy_bean
							.getUI_M_POL_RES_AREA_CODE_DESC(),
					PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_NAME_FLAG, null);
			if (pvalOrclList != null && !pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_RES_AREA_CODE_DESC(pvalOrclList
						.get(0).getValue());
			}

			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("IL_PROJ_CODE",
					pt_il_policy_bean.getPOL_PROJECT_CODE(), pt_il_policy_bean
							.getUI_M_PROJECT_CODE_DESC(), "N", "N", null);
			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_PROJECT_CODE_DESC(pvalOrclList.get(0)
						.getValue());
			}
			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("SRC_BUS_TY",
					pt_il_policy_bean.getPOL_SRC_OF_BUS(), pt_il_policy_bean
							.getUI_M_POL_SRC_OF_BUS_DESC(), "N", "N", null);

			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_SRC_OF_BUS_DESC(pvalOrclList.get(
						0).getValue());
			}
			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("STATE",
					pt_il_policy_bean.getPOL_STATE_CODE(), pt_il_policy_bean
							.getUI_M_POL_STATE_NAME(), "N", "N", null);
			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_STATE_NAME(pvalOrclList.get(0)
						.getValue());
			}
			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("COUNTRY",
					pt_il_policy_bean.getPOL_COUNT_CODE(), pt_il_policy_bean
							.getUI_M_POL_COUNT_NAME(), "N", "N", null);

			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_COUNT_NAME(pvalOrclList.get(0)
						.getValue());
			}
			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("IL_SUB_PLAN",
					pt_il_policy_bean.getPOL_SUB_PLAN_CODE(), pt_il_policy_bean
							.getUI_M_POL_SUB_PLAN_CODE_DESC(), "N", "N", null);

			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_SUB_PLAN_CODE_DESC(pvalOrclList
						.get(0).getValue());
			}

			pvalOrclList = new ArrayList<OracleParameter>();
			pvalOrclList = pkg_pilt002_apac.P_VAL_CODES("CITY",
					pt_il_policy_bean.getPOL_CITY_CODE(), pt_il_policy_bean
							.getUI_M_POL_CITY_NAME(), "N", "N", null);

			if (!pvalOrclList.isEmpty()) {
				pt_il_policy_bean.setUI_M_POL_CITY_NAME(pvalOrclList.get(0)
						.getValue());
			}

			if (pt_il_policy_bean.getPOL_INTRODUCER_REF_ID1() != null) {
				pvalList = new ArrayList<String>();
				pvalList = pkg_pilt002_apac
						.P_VAL_CLASS_CUST("BROKER", pt_il_policy_bean
								.getPOL_INTRODUCER_REF_ID1(), pt_il_policy_bean
								.getUI_M_POL_INTRODUCER_REF_ID1_DESC(), "N",
								"N", pt_il_policy_bean.getPOL_DIVN_CODE());
				if (pvalList.isEmpty()) {
					pt_il_policy_bean
							.setUI_M_POL_INTRODUCER_REF_ID1_DESC(pvalList
									.get(0));
				}
			} else {
				pt_il_policy_bean.setUI_M_POL_INTRODUCER_REF_ID1_DESC(null);
			}

			if ("AG".equalsIgnoreCase(pt_il_policy_bean.getPOL_PYMT_TYPE())
					|| "NG".equalsIgnoreCase(pt_il_policy_bean
							.getPOL_PYMT_TYPE())) {
				pt_il_policy_action.getCOMP_POL_PAYOR_SDCODE()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);

			} else {
				pt_il_policy_action.getCOMP_POL_PAYOR_SDCODE().setRequired(
						false);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						false);
			}
			String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();
			if ("AD".equals(POL_PYMT_TYPE) || "SC".equals(POL_PYMT_TYPE)
					|| "CC".equals(POL_PYMT_TYPE) || "C1".equals(POL_PYMT_TYPE)
					|| "C2".equals(POL_PYMT_TYPE) || "C3".equals(POL_PYMT_TYPE)
					|| "C4".equals(POL_PYMT_TYPE) || "C5".equals(POL_PYMT_TYPE)
					|| "C6".equals(POL_PYMT_TYPE)) {

				// if( pt_il_policy_bean.getPOL_PYMT_TYPE() IN ('AD',
				// 'SC','CC','C1','C2','C3','C4','C5','C6') THEN
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setRequired(true);

			}
			if ("AD".equals(POL_PYMT_TYPE)) {
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRendered(
						false);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setRendered(false);

				/*Commented by ganesh on 24-10-2017 as suggested by ajoy*/
				/*pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRendered(true);
				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT_LABEL().setRendered(
						true);

				if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().isRendered() == true) {
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(
							false);
				}

				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(true);*/
				/*end*/

			} else if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)) {

				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRendered(false);
				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT_LABEL().setRendered(
						false);

				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRendered(
						true);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setRendered(true);

				if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
						.isRendered() == true) {
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setDisabled(false);
				}
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(
						true);
			} else {

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setRequired(false);

				if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
						.isRendered() == true) {
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRequired(false);
				}
				if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().isRendered() == true) {
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(
							false);
				}
			}
			POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();

			/* Added by piyush for encrypt decrypt */
			/*
			 * commented by Ameen on 01-04-2018 for KIC method of collection as per Siva sugg. no decrypt is required
			 * if ("AD".equals(POL_PYMT_TYPE) || "SC".equals(POL_PYMT_TYPE)
					|| "CC".equals(POL_PYMT_TYPE) || "C1".equals(POL_PYMT_TYPE)
					|| "C2".equals(POL_PYMT_TYPE) || "C3".equals(POL_PYMT_TYPE)
					|| "C4".equals(POL_PYMT_TYPE) || "C5".equals(POL_PYMT_TYPE)
					|| "C6".equals(POL_PYMT_TYPE) || "BS".equals(POL_PYMT_TYPE)) {

				if ("AD".equals(POL_PYMT_TYPE) || "BS".equals(POL_PYMT_TYPE)) {

					values = new Object[] {
							pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO(),
							pt_il_policy_bean.getPOL_SYS_ID(), "PD",
							pt_il_policy_bean.getPOL_PYMT_TYPE() };
					rsEncrypt = new CRUDHandler().executeSelectStatement(
							queryEncrypt, connection, values);
					if (rsEncrypt.next()) {
						M_ENCRYPTED_NO = rsEncrypt.getString(1);
						if (M_ENCRYPTED_NO != null) {
							pt_il_policy_bean
									.setUI_M_POL_CONT_AD_ACC_NO(Long
											.parseLong(M_ENCRYPTED_NO));
						}
					}

				} else if ("SC".equals(POL_PYMT_TYPE)
						|| "CC".equals(POL_PYMT_TYPE)
						|| "C1".equals(POL_PYMT_TYPE)
						|| "C2".equals(POL_PYMT_TYPE)
						|| "C3".equals(POL_PYMT_TYPE)
						|| "C4".equals(POL_PYMT_TYPE)
						|| "C5".equals(POL_PYMT_TYPE)
						|| "C6".equals(POL_PYMT_TYPE)) {
					values = new Object[] { CommonUtils.getControlBean()
							.getM_USER_ID() };
					rs13 = new CRUDHandler().executeSelectStatement(query13,
							connection, values);
					while (rs13.next()) {
						M_CREDIT_CARD_UPD_YN = rs13.getString(1);
					}

					if ("Y".equalsIgnoreCase(M_CREDIT_CARD_UPD_YN)
							&& pt_il_policy_bean.getPOL_CONT_AD_ACC_NO() != null) {
						values = new Object[] {
								pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO(),
								pt_il_policy_bean.getPOL_SYS_ID(), "PD",
								pt_il_policy_bean.getPOL_PYMT_TYPE() };
						rsEncrypt = new CRUDHandler().executeSelectStatement(
								queryEncrypt, connection, values);
						while (rsEncrypt.next()) {
							M_ENCRYPTED_NO = rsEncrypt.getString(1);
						}
						pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(Long
								.parseLong(M_ENCRYPTED_NO));
					} else if ("N".equalsIgnoreCase(M_CREDIT_CARD_UPD_YN)
							&& pt_il_policy_bean.getPOL_CONT_AD_ACC_NO() != null) {
						values = new Object[] {
								pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO(),
								pt_il_policy_bean.getPOL_SYS_ID(), "PD",
								pt_il_policy_bean.getPOL_PYMT_TYPE() };
						rsEncrypt = new CRUDHandler().executeSelectStatement(
								queryEncrypt, connection, values);
						while (rsEncrypt.next()) {
							M_ENCRYPTED_NO = rsEncrypt.getString(1);
						}
						pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(Long
								.parseLong(M_ENCRYPTED_NO));

						pt_il_policy_bean
								.setUI_M_POL_CONT_AD_ACC_NO(Long
										.parseLong(CommonUtils
												.lpad(
														pt_il_policy_bean
																.getUI_M_POL_CONT_AD_ACC_NO()
																.toString()
																.substring(12,
																		28),
														16, "X")));

					}
				}
			}*/

			if (!"SC".equals(POL_PYMT_TYPE) || !"CC".equals(POL_PYMT_TYPE)
					|| !"C1".equals(POL_PYMT_TYPE)
					|| !"C2".equals(POL_PYMT_TYPE)
					|| !"C3".equals(POL_PYMT_TYPE)
					|| !"C4".equals(POL_PYMT_TYPE)
					|| !"C5".equals(POL_PYMT_TYPE)
					|| !"C6".equals(POL_PYMT_TYPE)) {
				pt_il_policy_action.getCOMP_UI_M_BUT_CC_LOV()
						.setRendered(false);

			} else if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)) {
				pt_il_policy_action.getCOMP_UI_M_BUT_CC_LOV().setRendered(true);
			}

			if (pt_il_policy_bean.getPOL_BANK_BRANCH_NAME() != null) {
				values = new Object[] {
						pt_il_policy_bean.getPOL_BANK_BRANCH_NAME(),
						pt_il_policy_bean.getPOL_CUST_CODE() };
				rs3 = new CRUDHandler().executeSelectStatement(query3,
						connection, values);
				while (rs3.next()) {
					M_ASSR_NAME = rs3.getString(1);
				}
				pt_il_policy_bean.setUI_M_BRANCH_CODE_DESC(M_ASSR_NAME);
			} else {
				pt_il_policy_bean.setUI_M_BRANCH_CODE_DESC(null);
			}

			if (pt_il_policy_bean.getPOL_RI_POOL_CODE() != null) {
				values = new Object[] { pt_il_policy_bean.getPOL_RI_POOL_CODE() };
				rs5 = new CRUDHandler().executeSelectStatement(query5,
						connection, values);
				while (rs5.next()) {
					pt_il_policy_bean.setUI_M_POL_RI_POOL_CODE_DESC(rs5
							.getString(1));
				}
			}

			if (pt_il_policy_bean.getPOL_CUST_CODE() != null) {
				values = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE() };
				rs6 = new CRUDHandler().executeSelectStatement(query6,
						connection, values);
				while (rs6.next()) {
					M_CUST_DOB = rs6.getDate(1);
				}
				values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
				rs7 = new CRUDHandler().executeSelectStatement(query7,
						connection, values);
				while (rs7.next()) {
					dummy_bean.setUI_M_PROD_AGE_CALC_FLAG(rs7.getString(1));
					M_PROD_PREM_CALC_MTHD = rs7.getString(2);
				}
			}

			if (Integer.parseInt(dummy_bean.getUI_M_IL_DOC_GEN()) == 2) {
				if ((pt_il_policy_bean.getPOL_NO() == null)
						|| ((pt_il_policy_bean.getPOL_END_NO_IDX() > 0) && (pt_il_policy_bean
								.getPOL_END_NO() == null))) {
					dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setDisabled(
							false);
				} else {
					dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO()
							.setDisabled(true);
				}
			}

			values = new Object[] { pt_il_policy_bean.getPOL_SRC_OF_BUS() };
			rs11 = new CRUDHandler().executeSelectStatement(query11,
					connection, values);
			while (rs11.next()) {
				M_DUMMY2 = rs11.getString(1);
			}

			if ("Y".equalsIgnoreCase(pt_il_policy_bean.getPOL_STAFF_YN())) {
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setDisabled(false);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
							.setDisabled(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
							.setDisabled(false);
				}
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setRequired(true);
				// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
				values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
				handler
						.executeDeleteStatement(delBrokerDtl, connection,
								values);
				handler.executeDeleteStatement(delBrokerHead, connection,
						values);
			} else {
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setRequired(false);
				if (CommonUtils.nvl(M_DUMMY2, "N").equalsIgnoreCase("X")) {
					// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
					compositeAction.getWizard().disableWizardItem(
							"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
					values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
					handler.executeDeleteStatement(delBrokerDtl, connection,
							values);
					handler.executeDeleteStatement(delBrokerHead, connection,
							values);
				} else {
					// compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_BROKER_HEAD");

				}
			}

			if (pt_il_policy_bean.getPOL_CONT_CODE() != null) {
				dummy_action.getCOMP_UI_M_BUT_ADD_DETAILS().setDisabled(false);
			}

			pt_il_policy_bean.setUI_M_POL_FC_SA(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_FC_SUM_ASSURED(), 0));
			pt_il_policy_bean.setUI_M_POL_LC_SA(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_LC_SUM_ASSURED(), 0));
			pt_il_policy_bean.setUI_M_POL_MODE_OF_PYMT_RATE(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_MODE_OF_PYMT_RATE(), 0));

			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK

			if (dummy_bean.getUI_M_CALC_METHOD() == 2
					|| (dummy_bean.getUI_M_CALC_METHOD() == 1 && !"M"
							.equalsIgnoreCase(CommonUtils.nvl(dummy_bean
									.getUI_M_POL_PLAN_TYPE(), "X")))
					|| ((dummy_bean.getUI_M_CALC_METHOD() == 1 || dummy_bean
							.getUI_M_CALC_METHOD() == 2)
							&& "M".equalsIgnoreCase(CommonUtils.nvl(dummy_bean
									.getUI_M_POL_PLAN_TYPE(), "X")) && "T"
							.equalsIgnoreCase(CommonUtils.nvl(
									M_PROD_PREM_CALC_MTHD, "X")))) {

				pvalList = new ArrayList<String>();
				pvalList = new P9ILPK_POLICY().P_DISPLAY_PREMIUM(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_FC_TOT_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_LC_TOT_PREM()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_FC_TOT_LOADING()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_LC_TOT_LOADING()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_FC_TOT_DISCOUNT()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_LC_TOT_DISCOUNT()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_FC_PCHARGES_BORNE_CUST()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_LC_PCHARGES_BORNE_CUST()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_FC_PCHARGES_BORNE_COMP()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_LC_PCHARGES_BORNE_COMP()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_FC_SCHARGES_BORNE_CUST()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_LC_SCHARGES_BORNE_CUST()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_FC_SCHARGES_BORNE_COMP()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_LC_SCHARGES_BORNE_COMP()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_FC_NET_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_LC_NET_PREM()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_INST_FC_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_INST_LC_PREM()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_FC_MOP()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_LC_MOP()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_FC_GR_ANN_PREM()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_LC_GR_ANN_PREM()));

				if (pvalList != null || !pvalList.isEmpty()) {
					if (pvalList.get(0) != null) {
						pt_il_policy_bean.setUI_M_POL_FC_TOT_PREM(Double
								.parseDouble(pvalList.get(0)));
					}
					if (pvalList.get(1) != null) {
						pt_il_policy_bean.setUI_M_POL_LC_TOT_PREM(Double
								.parseDouble(pvalList.get(1)));
					}
					
					
					if (pvalList.get(2) != null) {
						if (pt_il_policy_bean.getPOL_FC_SUM_ASSURED() != null
								&& pt_il_policy_bean.getPOL_FC_SUM_ASSURED() > 0) {
							pt_il_policy_bean.setUI_M_POL_FC_TOT_LOADING(Double
									.parseDouble(pvalList.get(2)));
						} else {
							pt_il_policy_bean.setUI_M_POL_FC_TOT_LOADING(0.0);
						}
					}
					
					
					if (pvalList.get(3) != null) {
						if (pt_il_policy_bean.getPOL_FC_SUM_ASSURED() != null
								&& pt_il_policy_bean.getPOL_FC_SUM_ASSURED() > 0) {
							pt_il_policy_bean.setUI_M_POL_LC_TOT_LOADING(Double
									.parseDouble(pvalList.get(3)));
						} else {
							pt_il_policy_bean.setUI_M_POL_LC_TOT_LOADING(0.0);
						}
					}
					if (pvalList.get(4) != null) {
						pt_il_policy_bean.setUI_M_POL_FC_TOT_DISCOUNT(Double
								.parseDouble(pvalList.get(4)));
					}
					if (pvalList.get(5) != null) {
						pt_il_policy_bean.setUI_M_POL_LC_TOT_DISCOUNT(Double
								.parseDouble(pvalList.get(5)));
					}
					if (pvalList.get(6) != null) {
						pt_il_policy_bean.setUI_M_FC_PCHARGES_BORNE_CUST(Double
								.parseDouble(pvalList.get(6)));
					}
					if (pvalList.get(7) != null) {
						pt_il_policy_bean.setUI_M_LC_PCHARGES_BORNE_CUST(Double
								.parseDouble(pvalList.get(7)));
					}
					if (pvalList.get(8) != null) {
						pt_il_policy_bean.setUI_M_FC_PCHARGES_BORNE_COMP(Double
								.parseDouble(pvalList.get(8)));
					}
					if (pvalList.get(9) != null) {
						pt_il_policy_bean.setUI_M_LC_PCHARGES_BORNE_COMP(Double
								.parseDouble(pvalList.get(9)));
					}
					/*
					 * if (pvalList.get(10) != null) {
					 * pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_CUST(Double
					 * .parseDouble(pvalList.get(10))); } if (pvalList.get(11) !=
					 * null) {
					 * pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_CUST(Double
					 * .parseDouble(pvalList.get(11))); }
					 */
					if (pvalList.get(12) != null) {
						pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_COMP(Double
								.parseDouble(pvalList.get(12)));
					}
					if (pvalList.get(13) != null) {
						pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_COMP(Double
								.parseDouble(pvalList.get(13)));
					}
					if (pvalList.get(14) != null) {
						pt_il_policy_bean.setUI_M_POL_FC_NET_PREM(Double
								.parseDouble(pvalList.get(14)));
					}
					if (pvalList.get(15) != null) {
						pt_il_policy_bean.setUI_M_POL_LC_NET_PREM(Double
								.parseDouble(pvalList.get(15)));
					}
					if (pvalList.get(16) != null) {
						pt_il_policy_bean.setUI_M_POL_INST_FC_PREM(Double
								.parseDouble(pvalList.get(16)));
					}
					if (pvalList.get(17) != null) {
						pt_il_policy_bean.setUI_M_POL_INST_LC_PREM(Double
								.parseDouble(pvalList.get(17)));
					}
					if (pvalList.get(18) != null) {
						pt_il_policy_bean.setUI_M_POL_FC_MOP(Double
								.parseDouble(pvalList.get(18)));
					}
					if (pvalList.get(19) != null) {
						pt_il_policy_bean.setUI_M_POL_LC_MOP(Double
								.parseDouble(pvalList.get(19)));
					}
					if (pvalList.get(20) != null) {
						pt_il_policy_bean.setUI_M_POL_FC_GR_ANN_PREM(Double
								.parseDouble(pvalList.get(20)));
					}
					if (pvalList.get(21) != null) {
						pt_il_policy_bean.setUI_M_POL_LC_GR_ANN_PREM(Double
								.parseDouble(pvalList.get(21)));
					}
					
					/* Newly Added By Dhinesh on 24-7-2017 for ssp call id : ZBILQC-1732815 */
					
					String CURSOR_C18 = " SELECT PROD_PRODUCT_TYPE,PROD_UNIT_LINK_TYPE FROM PM_IL_PRODUCT  WHERE PROD_CODE= ? ";
					String PROD_PRODUCT_TYPE= null;
					String PROD_UNIT_LINK_TYPE = null;

					connection = CommonUtils.getConnection();
					rs18 = new CRUDHandler().executeSelectStatement(CURSOR_C18,
							connection, new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() });
					while (rs18.next()) {
						PROD_PRODUCT_TYPE   = rs18.getString("PROD_PRODUCT_TYPE");
						PROD_UNIT_LINK_TYPE = rs18.getString("PROD_UNIT_LINK_TYPE");
					}


					if ("U".equalsIgnoreCase(PROD_PRODUCT_TYPE) 
							&& "NA".equalsIgnoreCase(PROD_UNIT_LINK_TYPE)) {
						pt_il_policy_bean.setUI_M_POL_FC_TOT_LOADING(Double
								.parseDouble(pvalList.get(2)));
						pt_il_policy_bean.setUI_M_POL_LC_TOT_LOADING(Double
								.parseDouble(pvalList.get(3)));
					}								

								
					/* End */
				}
				
				
				

				// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK

			} else if (((dummy_bean.getUI_M_CALC_METHOD() == 1 || dummy_bean
					.getUI_M_CALC_METHOD() == 2)
					&& !"N".equalsIgnoreCase(CommonUtils.nvl(dummy_bean
							.getUI_M_POL_PLAN_TYPE(), "X")) && "X"
					.equalsIgnoreCase(CommonUtils.nvl(dummy_bean
							.getUI_M_PROD_PREM_CALC_MTHD(), "Y")))) {

				local_procedures.L_DISPLAY_TAKAFUL_SUMMARY(pt_il_policy_bean,
						dummy_bean);

			}
			if ("Y".equalsIgnoreCase(pt_il_policy_bean.getPOL_NET_PREM_YN())) {
				pvalOrclList = new ArrayList<OracleParameter>();
				pvalOrclList = pkg_pilt002_apac.L_CALC_NET_PREMIUM(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_PROD_CODE()), CommonUtils
								.getProcedureValue(dummy_bean
										.getUI_M_BASE_CURR()), CommonUtils
								.getProcedureValue(dummy_bean
										.getUI_M_POL_PLAN_TYPE()), CommonUtils
								.getProcedureValue(dummy_bean
										.getUI_M_PROD_PREM_CALC_MTHD()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_DS_TYPE()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_APPRV_STATUS()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_PREM_PAY_YRS()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_BASIC_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getUI_M_POL_LC_TOT_LOADING()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getUI_M_POL_LC_TOT_DISCOUNT()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_ADDL_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_MODE_OF_PYMT_RATE()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_CUST_EXCH_RATE()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_FIRST_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_NETT_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_FC_NETT_PREM()));

				if (pvalOrclList != null && !pvalOrclList.isEmpty()) {
					if (pvalOrclList.get(0).getValue() != null) {
						pt_il_policy_bean.setPOL_LC_NETT_PREM(Double
								.parseDouble(pvalOrclList.get(0).getValue()));
					}
					if (pvalList.get(1) != null) {
						pt_il_policy_bean.setPOL_FC_NETT_PREM(Double
								.parseDouble(pvalOrclList.get(1).getValue()));
					}
				}

			}

			if ("A".equalsIgnoreCase(pt_il_policy_bean.getPOL_APPRV_STATUS())) {
				dummy_action.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
			} else if ("Y"
					.equalsIgnoreCase(pt_il_policy_bean.getPOL_FRZ_FLAG())) {
				dummy_action.getCOMP_UI_M_BUT_HOLD().setDisabled(false);
			}

			if ("C".equalsIgnoreCase(pt_il_policy_bean.getPOL_STATUS())) {
				local_procedures.IL_BLOCK_POL_DISABLED(compositeAction);
			}

			pt_il_policy_action.getCOMP_POL_LC_NETT_PREM().setRendered(true);
			pt_il_policy_action.getCOMP_POL_FC_NETT_PREM().setRendered(true);
			pt_il_policy_action.getCOMP_POL_LC_NETT_PREM_LABEL().setRendered(
					true);
			pt_il_policy_action.getCOMP_POL_FC_NETT_PREM_LABEL().setRendered(
					true);

			if ("1".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE())) {
				P_CONVERT_YN_STATUS(pt_il_policy_bean, dummy_action);
			}
			// newly added for defaulting charges in premium details
			/*
			 * E1resultSet = handler.executeSelectStatement(E1, connection, new
			 * Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			 * if(E1resultSet.next()){ fcvalue = E1resultSet.getDouble(1);
			 * lcvalue = E1resultSet.getDouble(2); }
			 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_FC_SCHARGES_BORNE_CUST((Double)fcvalue);
			 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setUI_M_LC_SCHARGES_BORNE_CUST((Double)lcvalue);
			 */
			if (pt_il_policy_bean.getPOL_DS_TYPE().equalsIgnoreCase("2")) {
				rs17 = handler.executeSelectStatement(query17, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
								pt_il_policy_bean.getPOL_LAST_INST_DT() });
				if (rs17.next()) {
					M_SCHD_PYMT_DT = rs17.getDate(1);
				}
				sp_revival.P_PAID_TO_DATE(pt_il_policy_bean.getPOL_SYS_ID());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	// completed
	public void PRE_UPDATE(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		String M_AGE1 = (String) session.get("DUMMY.M_AGE");

		String query1 = "SELECT COUNT(POAD_SYS_ID) VAL FROM PT_IL_POL_ASSURED_DTLS"
				+ "   WHERE POAD_POL_SYS_ID = ? ";

		String query2 = "SELECT COVER_DISC_AGE_YN  FROM  PM_IL_COVER WHERE  COVER_CODE =?  ";
		Connection connection = null;
		Object[] object = {};
		ResultSet resultSet = null;
		int M_COUNT = 0;
		String M_COVER_DISC_AGE_YN = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		try {
			object = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			connection = CommonUtils.getConnection();

			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object);
			while (resultSet.next()) {
				M_COUNT = resultSet.getInt("VAL");
			}
			CommonUtils.closeCursor(resultSet);
			object = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };

			resultSet = new CRUDHandler().executeSelectStatement(query2,
					connection, object);
			while (resultSet.next()) {
				M_COVER_DISC_AGE_YN = resultSet.getString("COVER_DISC_AGE_YN");
			}

			if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
					.getUI_M_AGE() != null) {

				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE(
								compositeAction.getDUMMY_ACTION_BEAN()
										.getDUMMY_BEAN().getUI_M_AGE());

				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_M_AGE(null);
			}

			if (pt_il_policy_bean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("Y")
					&& M_COUNT == 2
					&& compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.getUI_M_CALC_METHOD() == 2)

			{
				local_procedures.IL_PREM_CAL_JL_AGE(pt_il_policy_bean
						.getPOL_JOINT_LIFE_AGE(),
						CommonUtils.dateToStringFormat(pt_il_policy_bean
								.getPOL_START_DT()), pt_il_policy_bean
								.getPOL_PLAN_CODE(), pt_il_policy_bean
								.getPOL_SYS_ID());
			} else if (M_COUNT == 1
					&& "R".equals(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_TYPE())) {

				if (CommonUtils.nvl(M_COVER_DISC_AGE_YN, "N").equalsIgnoreCase(
						"N")) {
					// :PT_IL_POLICY.POL_JOINT_LIFE_AGE :=
					// :PT_IL_POL_ASSURED_DTLS_1.POAD_AGE;
					pt_il_policy_bean.setPOL_JOINT_LIFE_AGE(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE());
				} else if (CommonUtils.nvl(M_COVER_DISC_AGE_YN, "N")
						.equalsIgnoreCase("Y")) {
					/*
					 * Commenetd By Haneef/Mohan to fix : P11JLIFEQC-1678043
					 */
					pt_il_policy_bean.setPOL_JOINT_LIFE_AGE(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_DISC_AGE());
				}
			} else if (M_COUNT == 1
					|| M_COUNT == 2
					&& "E".equals(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_TYPE())) {

				if (CommonUtils.nvl(M_COVER_DISC_AGE_YN, "N").equalsIgnoreCase(
						"N")) {
					pt_il_policy_bean.setPOL_JOINT_LIFE_AGE(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE());
				} else if (CommonUtils.nvl(M_COVER_DISC_AGE_YN, "N")
						.equalsIgnoreCase("Y")) {
					pt_il_policy_bean.setPOL_JOINT_LIFE_AGE(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN()
							.getPOAD_DISC_AGE());
				}
			}
			pt_il_policy_bean.setPOL_UPD_DT(new CommonUtils().getCurrentDate());
			pt_il_policy_bean.setPOL_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public boolean checkmedstatus(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		boolean pmed_status = false;

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = pt_il_policy_action
				.getPT_IL_POLICY_BEAN();
		/*
		 * PT_IL_POL_MED_EXAM_DTL_ACTION
		 * pt_il_pol_med_exam_dtl_action=compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		 * PT_IL_POL_MED_EXAM_DTL
		 * pt_il_pol_med_exam_dtl=pt_il_pol_med_exam_dtl_action.getPT_IL_POL_MED_EXAM_DTL_BEAN();
		 */
		Connection connection = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		try {

			Object[] values = { pt_il_policy_bean.getPOL_SYS_ID() };
			String query1 = "SELECT PMED_STATUS FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID like ?";
			rs1 = handler.executeSelectStatement(query1, connection, values);
			while (rs1.next()) {
				String med_status = rs1.getString(1);
				if (med_status.equalsIgnoreCase("n")) {
					pmed_status = true;
					break;
				} else {
					pmed_status = false;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return pmed_status;
	}
	
	

		/*End*/

	public void PRE_INSERT(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = pt_il_policy_action
				.getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String query1 = " SELECT PIL_POL_SYS_ID.NEXTVAL  FROM DUAL";
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();

		String P_POL_PROD_CODE = null;
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		ArrayList<String> list = null;
		try {

			if (pt_il_policy_bean.getPOL_END_NO() != null) {
				local_procedures.IL_UNIQUE_END_NO(pt_il_policy_bean);
			}

			local_procedures.IL_CUST_CURR_EXIST(pt_il_policy_bean);
			local_procedures.IL_POL_PERIOD_CHECK(compositeAction,
					pt_il_policy_bean);
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query1, connection);

			if (rs.next()) {
				pt_il_policy_bean.setPOL_SYS_ID(rs.getLong(1));
			}

			pt_il_policy_bean.setPOL_CR_DT(new CommonUtils().getCurrentDate());
			
			/*Newly Added By Dhinesh on 20.3.2017*/
			pt_il_policy_bean.setUI_M_POL_CR_DT(CommonUtils.dateToStringFormat(pt_il_policy_bean.getPOL_CR_DT()));
			/*End*/
			
			pt_il_policy_bean.setPOL_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pt_il_policy_bean.setPOL_END_NO_IDX(0);
			pt_il_policy_bean.setPOL_FACIN_YN("N");
			pt_il_policy_bean.setPOL_ADDL_STATUS("001");
			pt_il_policy_bean.setPOL_PROP_QUOT_FLAG("P");
			pt_il_policy_bean.setPOL_MED_FEE_RECOVER_YN("N");

			if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
					.getUI_M_CALC_METHOD() == 2) {
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				
				/*Added by sankara narayanan for uicomponent frz flag on 21-03-2017*/
				pt_il_policy_bean.setUI_POL_FRZ_FLAG("N");
				/*end*/
				
				pt_il_policy_bean.setPOL_GRANTEE_TYPE("B");
				pt_il_policy_bean.setPOL_HOME_OWNER_FLAG("N");
				pt_il_policy_bean.setPOL_INCORPORATED_YN("N");
				pt_il_policy_bean.setPOL_MODE_OF_CALC("A");
				pt_il_policy_bean.setPOL_NET_PREM_YN("N");
			/*	As per siva sir suggested for this ssp call id ZBILQC-1718566 changing default value is p*/
				/*pt_il_policy_bean.setPOL_PYMT_TYPE("C");*/
			/*commentted by saranya for ssp call id ZBILQC-1718616 on 20-03-2017*/
				//pt_il_policy_bean.setPOL_PYMT_TYPE("P");
				/*End*/
				/*End*/
			}

			if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
					.getUI_M_AGE() != null) {
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE(
								compositeAction.getDUMMY_ACTION_BEAN()
										.getDUMMY_BEAN().getUI_M_AGE());
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_M_AGE(null);
			}

			P_POL_PROD_CODE = pt_il_policy_bean.getPOL_PROD_CODE();

			list = pkg_pilt002_apac.L_CALC_TAKAFUL_PREM(CommonUtils
					.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_DS_TYPE()), CommonUtils
							.getProcedureValue(pt_il_policy_bean.getPOL_NO()),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_PROP_NO()), "", "", "", "", "", "", "",
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_CUST_CURR_CODE()), "", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_INCORPORATED_YN()), "", "", "", "",
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_NET_PREM_YN()), "", "", CommonUtils
							.getProcedureValue(dummy_bean.getUI_M_BASE_CURR()),
					"", "", "", "", "", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_FC_SUM_ASSURED()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_LC_SUM_ASSURED()), "");

			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					pt_il_policy_bean.setUI_M_LC_DEATH_LOAD(Double
							.parseDouble(list.get(0)));
				}
				if (list.get(1) != null) {
					pt_il_policy_bean.setUI_M_LC_TPD_LOAD(Double
							.parseDouble(list.get(1)));
				}
				if (list.get(2) != null) {
					pt_il_policy_bean.setUI_M_FC_OCC_LOAD(Double
							.parseDouble(list.get(2)));
				}
				if (list.get(3) != null) {
					pt_il_policy_bean.setUI_M_LC_OCC_LOAD(Double
							.parseDouble(list.get(3)));
				}
				if (list.get(4) != null) {
					pt_il_policy_bean.setUI_M_FC_DEATH_LOAD(Double
							.parseDouble(list.get(4)));
				}
				if (list.get(5) != null) {
					pt_il_policy_bean.setUI_M_FC_TPD_LOAD(Double
							.parseDouble(list.get(5)));
				}
				if (list.get(6) != null) {
					pt_il_policy_bean.setUI_M_FC_MED_LOAD(Double
							.parseDouble(list.get(6)));
				}
				if (list.get(7) != null) {
					pt_il_policy_bean.setUI_M_LC_MED_LOAD(Double
							.parseDouble(list.get(7)));
				}
				if (list.get(8) != null) {
					pt_il_policy_bean.setUI_M_FC_GROSS_CONT(Double
							.parseDouble(list.get(8)));
				}
				if (list.get(9) != null) {
					pt_il_policy_bean.setUI_M_LC_GROSS_CONT(Double
							.parseDouble(list.get(9)));
				}
				if (list.get(10) != null) {
					pt_il_policy_bean.setUI_M_FC_CHARGE(Double.parseDouble(list
							.get(10)));
				}
				if (list.get(11) != null) {
					pt_il_policy_bean.setUI_M_LC_CHARGE(Double.parseDouble(list
							.get(11)));
				}
				if (list.get(12) != null) {
					pt_il_policy_bean.setUI_M_LC_BROK_COMM(Double
							.parseDouble(list.get(12)));
				}
				if (list.get(13) != null) {
					pt_il_policy_bean.setUI_M_FC_BROK_COMM(Double
							.parseDouble(list.get(13)));
				}
				if (list.get(14) != null) {
					dummy_bean.setUI_M_COMPY_FC_CHARGE(Double.parseDouble(list
							.get(14)));
				}
				if (list.get(15) != null) {
					dummy_bean.setUI_M_COMPY_LC_CHARGE(Double.parseDouble(list
							.get(15)));
				}
				if (list.get(16) != null) {
					pt_il_policy_bean.setUI_M_FC_INST_PREM(Double
							.parseDouble(list.get(16)));
				}
				if (list.get(17) != null) {
					pt_il_policy_bean.setUI_M_LC_INST_PREM(Double
							.parseDouble(list.get(17)));
				}
				if (list.get(18) != null) {
					pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(Double
							.parseDouble(list.get(18)));
				}
				if (list.get(19) != null) {
					pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(Double
							.parseDouble(list.get(19)));
				}
			}

			if ("Q".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13"))
					&& "1".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_11"))) {

				pt_il_policy_bean.setPOL_PROP_QUOT_FLAG("Q");
				pt_il_policy_bean.setPOL_STATUS("N");
				pt_il_policy_bean.setPOL_ADDL_STATUS("002");
				pt_il_policy_bean.setPOL_MED_FEE_RECOVER_YN("N");
			}
			
			/*Added by saritha on 04-03-2017 for RM018T - DEV_IL_ZB Life_027-Replacement Policy*/
			pt_il_policy_bean.setPOL_REPL_POLICY_YN("N");
			/*End*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	/*
	 * public void P_SET_FC_NUM_FMT_MASK(String P_CURR_CODE) {
	 * 
	 * String query1 =" SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE =
	 * 'PR_SI_CURR'";
	 * 
	 * int M_PS_VALUE =0; String M_FORMAT_MASK=null; String M_MASK =null; String
	 * M_ITEM_NAME =null; String M_ORG_FMT_MASK =
	 * "999,999,999,999,999,999,999,999,999,999"; String M_FIELD_LENGTH =null;
	 * String M_BASE_DEC =null; String M_MODULE_NAME =null; String M_ITEM_ID
	 * =null; String M_ITEM_TYPE =null; String M_BLOCK_NAME =null; String
	 * M_BASE_CURR =null; ResultSet rs1=null; Connection connection = null;
	 * CRUDHandler handler = new CRUDHandler(); try { connection =
	 * CommonUtils.getConnection(); rs1 = handler.executeSelectStatement(query1,
	 * connection); while(rs1.next()){ M_PS_VALUE = rs1.getInt("PS_VALUE"); }
	 * if(CommonUtils.nvl(M_PS_VALUE, 0)!=1) { }
	 * 
	 * M_BASE_CURR = P_CURR_CODE; P_GET_NO_OF_DEC(M_BASE_CURR, M_BASE_DEC, 'E') ;
	 * P_GET_FORMAT_MASK(M_BASE_CURR, M_ORG_FMT_MASK);
	 * 
	 * M_MODULE_NAME = GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME); IF
	 * NVL(M_MODULE_NAME,'***') LIKE 'PT%' OR NVL(M_MODULE_NAME,'***') LIKE
	 * 'PP%' OR NVL(M_MODULE_NAME,'***') LIKE 'PQ%' OR M_MODULE_NAME LIKE
	 * 'TEST%' THEN M_BLOCK_NAME := GET_FORM_PROPERTY(M_MODULE_NAME,
	 * FIRST_BLOCK); LOOP M_ITEM_NAME := GET_BLOCK_PROPERTY(M_BLOCK_NAME,
	 * FIRST_ITEM); LOOP M_ITEM_NAME := M_BLOCK_NAME||'.'||M_ITEM_NAME;
	 * M_ITEM_ID := FIND_ITEM(M_ITEM_NAME); IF NOT ID_NULL(M_ITEM_ID) THEN
	 * M_ITEM_TYPE := GET_ITEM_PROPERTY(M_ITEM_ID, ITEM_TYPE); IF M_ITEM_TYPE =
	 * 'TEXT ITEM' THEN IF GET_ITEM_PROPERTY(M_ITEM_ID, DATATYPE) = 'NUMBER' AND
	 * GET_ITEM_PROPERTY(M_ITEM_NAME,ITEM_CANVAS) IS NOT NULL THEN -- IF
	 * INSTR(M_ITEM_NAME,'PREM',1,1) > 0 THEN IF INSTR(M_ITEM_NAME, '_FC_', 1,1) >
	 * 0 THEN -- Set the format mask . M_MASK := M_ORG_FMT_MASK;
	 * L_REVERSE(M_ITEM_NAME, M_MASK); SET_ITEM_PROPERTY(M_ITEM_NAME,
	 * FORMAT_MASK, M_MASK); END IF; --END IF; END IF; END IF; END IF;
	 * M_ITEM_NAME := GET_ITEM_PROPERTY(M_ITEM_ID, NEXTITEM); EXIT WHEN
	 * M_ITEM_NAME IS NULL; END LOOP; M_BLOCK_NAME :=
	 * GET_BLOCK_PROPERTY(M_BLOCK_NAME, NEXTBLOCK); EXIT WHEN M_BLOCK_NAME IS
	 * NULL; END LOOP; END IF; END; } catch (Exception e) { // TODO: handle
	 * exception e.printStackTrace(); } }
	 */

	public void PRE_RECORD(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String M_VALUE = null;
		String M_BREM_ERR_FLAG;
		int M_DUMMY_ENABLE = 0;

		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		String query1 = " SELECT BREM_ERR_FLAG  FROM  PT_BUS_RULE_ERROR_MSG "
				+ "    WHERE BREM_POL_SYS_ID  = ? "
				+ "    AND   BREM_ERR_FLAG    = 'E'    AND   BREM_OVERRIDE_YN = 'N'"
				+ "   AND   BREM_GRP_ID      = 'IL'";

		String query1a = " SELECT BREM_ERR_FLAG FROM  PT_BUS_RULE_ERROR_MSG"
				+ "  WHERE BREM_POL_SYS_ID  =  ? "
				+ "  AND   BREM_ERR_FLAG    = 'W' AND   BREM_OVERRIDE_YN = 'N'"
				+ "  AND   BREM_GRP_ID      = 'IL'";

		Object[] object = {};
		ResultSet rs1 = null, rs1a = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ArrayList<String> pValArrayList = null;
		try {

			object = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			connection = CommonUtils.getConnection();
			dummy_bean.setUI_M_END_STATUS(null);
			dummy_bean.setUI_M_APPRV_STATUS(null);
			dummy_bean.setUI_M_END_IDX_TYPE_NO(null);
			dummy_bean.setUI_M_BUS_STATUS(null);

			rs1 = handler.executeSelectStatement(query1, connection, object);

			if (rs1.next()) {
				M_BREM_ERR_FLAG = rs1.getString(1);

				pValArrayList = DBProcedures.P_VAL_SYSTEM("BUSRUL_STAT", "E",
						dummy_bean.getUI_M_BUS_STATUS(), "N", M_VALUE);

				if (!pValArrayList.isEmpty() && pValArrayList != null) {
					dummy_bean.setUI_M_BUS_STATUS(pValArrayList.get(0));
					M_VALUE = pValArrayList.get(1);

				}
				M_DUMMY_ENABLE = 1;
			} else {
				rs1a = handler.executeSelectStatement(query1a, connection,
						object);

				while (rs1a.next()) {
					M_BREM_ERR_FLAG = rs1a.getString(1);

					pValArrayList = new ArrayList<String>();
					pValArrayList = DBProcedures.P_VAL_SYSTEM("BUSRUL_STAT",
							"W", dummy_bean.getUI_M_BUS_STATUS(), "N", M_VALUE);

					if (!pValArrayList.isEmpty() && pValArrayList != null) {
						dummy_bean.setUI_M_BUS_STATUS(pValArrayList.get(0));
						M_VALUE = pValArrayList.get(1);

					}

					M_DUMMY_ENABLE = 1;
				}
			}

			if (CommonUtils.nvl(M_DUMMY_ENABLE, 0) == 1) {
				dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);
				// SET_ITEM_PROPERTY('DUMMY.M_BUS_RUL',ENABLED,PROPERTY_TRUE);
			} else {
				dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(true);
				/*dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);*/
				// SET_ITEM_PROPERTY('DUMMY.M_BUS_RUL',ENABLED,PROPERTY_FALSE);
			}

			pValArrayList = new ArrayList<String>();
			pValArrayList = procedures.callP_VAL_SYSTEM("IL_REC_STA",
					CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(),
							"N"), dummy_bean.getUI_M_APPRV_STATUS(), "N",
					M_VALUE);

			if (pValArrayList.size() > 0) {
				dummy_bean.setUI_M_APPRV_STATUS(pValArrayList.get(0));
				M_VALUE = pValArrayList.get(1);

			}

			if (!"M".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_STATUS(),
					"N"))) {

				pValArrayList = new ArrayList<String>();
				pValArrayList = procedures
						.callP_VAL_SYSTEM("IL_REC_STA", CommonUtils.nvl(
								pt_il_policy_bean.getPOL_STATUS(), "N"),
								dummy_bean.getUI_M_END_STATUS(), "N", M_VALUE);

				if (!pValArrayList.isEmpty() && pValArrayList != null) {
					dummy_bean.setUI_M_END_STATUS(pValArrayList.get(0));
					M_VALUE = pValArrayList.get(1);

				}
				if (pt_il_policy_bean.getPOL_END_NO_IDX() != null
						&& pt_il_policy_bean.getPOL_END_NO_IDX() > 0) {
					if ("2".equals(pt_il_policy_bean.getPOL_DS_TYPE())
							|| "3".equals(pt_il_policy_bean.getPOL_DS_TYPE())) {
						// IF :PT_IL_POLICY.POL_DS_TYPE IN ('2','3')
						// THEN

						String endIdxTypeNo = pt_il_policy_bean
								.getPOL_END_NO_IDX()
								+ "-"
								+ pt_il_policy_bean.getPOL_END_TYPE()
								+ "-" + pt_il_policy_bean.getPOL_END_NO();
						dummy_bean.setUI_M_END_IDX_TYPE_NO(endIdxTypeNo);
					
						CommonUtils.setGlobalVariable("GLOBAL.APPRV_SCRN_END_IDX_NO",endIdxTypeNo);
						
						
					}
				}
			} else {

				pValArrayList = new ArrayList<String>();
				pValArrayList = procedures
						.callP_VAL_SYSTEM("IL_REC_STA", CommonUtils.nvl(
								pt_il_policy_bean.getPOL_STATUS(), "N"),
								dummy_bean.getUI_M_END_STATUS(), "N", M_VALUE);

				if (!pValArrayList.isEmpty() && pValArrayList != null) {
					dummy_bean.setUI_M_END_STATUS(pValArrayList.get(0));
					M_VALUE = pValArrayList.get(1);

				}

			}

			if ("Q".equals(pt_il_policy_bean.getPOL_PROP_QUOT_FLAG())) {
				dummy_bean.setUI_M_END_STATUS(pt_il_policy_bean
						.getPOL_END_DESC());

				dummy_bean.setUI_M_END_IDX_TYPE_NO(pt_il_policy_bean
						.getPOL_PROP_END_TYPE());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1a);
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POST_UPDATE(PT_IL_POLICY pt_il_policy_bean, DUMMY dummy_bean,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String query1 = " SELECT 'X' FROM   PT_IL_POL_ADDL_COVER WHERE  POAC_POL_SYS_ID = ? ";

		String query2 = "SELECT 'X' FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ? "
				+ "   AND    POBH_BROKER_CODE = NVL(?, ?)";

		String query3 = " SELECT POAD_AGE  FROM   PT_IL_POL_ASSURED_DTLS  WHERE  "
				+ " POAD_POL_SYS_ID = ? AND    POAD_TYPE =? ";

		String query4 = "SELECT PLAN_TYPE  FROM   PM_IL_PLAN   WHERE  PLAN_CODE = ? "
				+ "  AND    PLAN_FRZ_FLAG = ";

		String query5 = " SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N') FROM MENU_USER   "
				+ " WHERE USER_ID =  ? ";

		String query6 = " SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET WHERE   ASD_USER_ID = ? "
				+ "   AND     ASD_CODE    = 'CHG_MAT_YN' "
				+ "  AND   ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND"
				+ "  NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')  ";

		String query = " SELECT F_CC_ENCRYPT(?,?,?,?) FROM DUAL ";
		String query11 = "  SELECT PS_CODE   FROM   PP_SYSTEM  WHERE  PS_TYPE = ? ";

		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null, rs = null;

		Object[] object = {}, object1 = {}, object2 = {}, object3 = {}, object4 = {}, object5 = {}, object6 = {};
		Connection connection = null;
		String M_PLAN_TYPE = null;
		String M_DUMMY;
		String M_TEMP;
		Integer M_MED_AGE = null;
		String M_ENCRYPTED_NO;
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		String M_CREDIT_CARD_UPD_YN;
		String M_ASD_CHAR_VALUE;

		String M_PS_CODE_1 = null;
		String M_PS_CODE_2 = null;
		Object[] values = {};

		try {
			/*Added by saranya for charge detail issue*/
			if(pt_il_policy_bean.getPOL_NO()!=null){	
			P9ILPK_POLICY.P_INS_POL_CHRG(CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()));
			}
			/*End*/
			
			connection = CommonUtils.getConnection();
			values = new Object[] { "IL_DEL_RIDER" };
			rs = handler.executeSelectStatement(query11, connection, values);
			if (rs.next()) {
				M_PS_CODE_1 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);

			values = new Object[] { "IL_ADD_RIDER" };
			rs = handler.executeSelectStatement(query11, connection, values);
			if (rs.next()) {
				M_PS_CODE_2 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);
			PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls = compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN();
			object6 = new Object[] {
					CommonUtils.getGlobalObject("GLOBAL.M_USER_ID"),
					pt_il_policy_bean.getPOL_PROD_CODE() };

			String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();

			if (!("SC".equals(POL_PYMT_TYPE)) || (!"CC".equals(POL_PYMT_TYPE))
					|| (!"C1".equals(POL_PYMT_TYPE))
					|| !"C2".equals(POL_PYMT_TYPE)
					|| !"C3".equals(POL_PYMT_TYPE)
					|| !"C4".equals(POL_PYMT_TYPE)
					|| !"C5".equals(POL_PYMT_TYPE)
					|| !"C6".equals(POL_PYMT_TYPE)) {

				/*
				 * rs = new CRUDHandler().executeSelectStatement(query,
				 * connection, object);
				 * 
				 * rs = new
				 * CRUDHandler().executeSelectStatement(query,connection,
				 * object);
				 * 
				 * while (rs.next()) { M_ENCRYPTED_NO = rs.getString(1); }
				 */

				// M_ENCRYPTED_NO =
				// F_CC_ENCRYPT(:PT_IL_POLICY.M_POL_CONT_AD_ACC_NO,:PT_IL_POLICY.POL_SYS_ID,'PE',:PT_IL_POLICY.POL_PYMT_TYPE);
			} else if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)) 
			{
				object5 = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_USER_ID") };
				rs5 = new CRUDHandler().executeSelectStatement(query5,
						connection, object5);
				while (rs5.next()) {
					M_CREDIT_CARD_UPD_YN = rs5.getString(1);
				}

				if (!"XXXXXXXXXXXX".equals(String.valueOf(
						pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO())
						.substring(0, 12))) {
					/*
					 * rs = new CRUDHandler().executeSelectStatement(query,
					 * 
					 * if
					 * (!"XXXXXXXXXXXX".equals(String.valueOf(pt_il_policy_bean
					 * .getUI_M_POL_CONT_AD_ACC_NO()).substring(0, 12))) {
					 */
					object = new Object[] {
							pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO(),
							pt_il_policy_bean.getPOL_SYS_ID(), "PE",
							pt_il_policy_bean.getPOL_PYMT_TYPE() };
					rs = new CRUDHandler().executeSelectStatement(query,
							connection, object);
					while (rs.next()) {
						M_ENCRYPTED_NO = rs.getString(1);
					}
					// M_ENCRYPTED_NO:=
					// F_CC_ENCRYPT(:PT_IL_POLICY.M_POL_CONT_AD_ACC_NO,:PT_IL_POLICY.POL_SYS_ID,'PE',:PT_IL_POLICY.POL_PYMT_TYPE);
				} else if ("XXXXXXXXXXXX".equals(String.valueOf(
						pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO())
						.substring(0, 12))) {
					object = new Object[] {
							pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO_1(),
							pt_il_policy_bean.getPOL_SYS_ID(), "PE",
							pt_il_policy_bean.getPOL_PYMT_TYPE() };
					rs = new CRUDHandler().executeSelectStatement(query,
							connection, object);
					while (rs.next()) {
						M_ENCRYPTED_NO = rs.getString(1);
					}
					// M_ENCRYPTED_NO:=
					// F_CC_ENCRYPT(:PT_IL_POLICY.M_POL_CONT_AD_ACC_NO_1,:PT_IL_POLICY.POL_SYS_ID,'PE',:PT_IL_POLICY.POL_PYMT_TYPE);
				}
			}
			String nvlVal = CommonUtils.nvl(
					pt_il_policy_bean.getPOL_END_TYPE(), "000");
			if ("000".equals(nvlVal) || "002".equals(nvlVal)
					|| "012".equals(nvlVal) || "013".equals(nvlVal)) {
				object1 = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
				rs1 = new CRUDHandler().executeSelectStatement(query1,
						connection, object1);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);

					if (("Y".equals(CommonUtils.nvl(CommonUtils
							.getGlobalVariable("GLOBAL.M_LC_CHECK"), "N")) || "N"
							.equals(dummy_bean.getUI_M_COVER_SA_CALC()))
							|| ("013".equals(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_END_TYPE(), "000")))) {
						if (!"A".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_STATUS(), "N"))
								&& !"A".equals(CommonUtils
										.nvl(pt_il_policy_bean
												.getPOL_APPRV_STATUS(), "N"))) {
							if (!"012"
									.equalsIgnoreCase(CommonUtils
											.nvl(pt_il_policy_bean
													.getPOL_END_TYPE(), "000"))) {
								p9ilpk_policy.P_UPD_ADDL_COVER(
										pt_il_policy_bean.getPOL_SYS_ID()
												.toString(), pt_il_policy_bean
												.getPOL_PROD_CODE(), dummy_bean
												.getUI_M_CHANGE_SA_YN());
							}
						}
					}
					CommonUtils.setGlobalVariable("GLOBAL.M_LC_CHECK", "N");
				}

				/*
				 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE; RAISE
				 * FORM_TRIGGER_FAILURE; END;
				 */
			}
			object3 = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(), "R" };
			rs3 = new CRUDHandler().executeSelectStatement(query3, connection,
					object3);
			while (rs3.next()) {
				M_MED_AGE = rs3.getInt(1);
			}
			/*
			 * Added By Haneef
			 */
			if (!M_PS_CODE_1.equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_CODE(), "000"))
					&& !M_PS_CODE_2.equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_CODE(), "000"))) {
				pkg_pilt002_apac.L_INS_MED_EXAM_DTL(M_MED_AGE,
						pt_il_policy_bean.getPOL_LC_SUM_ASSURED(),
						pt_il_policy_bean.getPOL_SYS_ID(),
						pt_il_pol_assured_dtls.getPOAD_SYS_ID(),
						pt_il_policy_bean.getPOL_PROD_CODE(),
						pt_il_pol_assured_dtls.getPOAD_REF_ID1(),
						pt_il_pol_assured_dtls.getPOAD_REF_ID2(),
						pt_il_pol_assured_dtls.getPOAD_ASSR_CODE(), 2,
						CommonUtils.getControlBean().getUSER_ID(),
						pt_il_policy_bean.getPOL_CONT_CODE(), pt_il_policy_bean
								.getPOL_DIVN_CODE(), pt_il_policy_bean
								.getPOL_LC_SUM_ASSURED());

			}
			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			// "2".equals(dummy_bean.getUI_M_CALC_METHOD())

			if ("1".equals(dummy_bean.getUI_M_CALC_METHOD())
					|| "2".equals(dummy_bean.getUI_M_CALC_METHOD())) {
				object2 = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
						pt_il_policy_bean.getPOL_BANK_BRANCH_NAME(),
						pt_il_policy_bean.getPOL_CUST_CODE() };
				rs2 = new CRUDHandler().executeSelectStatement(query2,
						connection, object2);
				while (rs2.next()) {
					M_TEMP = rs2.getString(1);
				}
				object4 = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE(),
						"N" };
				rs4 = new CRUDHandler().executeSelectStatement(query4,
						connection, object4);
				while (rs4.next()) {
					M_PLAN_TYPE = rs4.getString(1);
				}
				if ("1".equals((CommonUtils.nvl(dummy_bean
						.getUI_M_IL_BROK_CALC(), 1)))
						&& "M".equals(CommonUtils.nvl(M_PLAN_TYPE, "X"))) {
					p9ilpk_policy.P_INS_POL_BROKER(pt_il_policy_bean
							.getPOL_SYS_ID().toString(), pt_il_policy_bean
							.getPOL_START_DT().toString());
				} else if ("M".equals(CommonUtils.nvl(M_PLAN_TYPE, "X"))) {
					// P9ILPK_AGENCY_MGMT.INS_MRTA_AGENT(:PT_IL_POLICY.POL_SYS_ID);
				}
			}

			// [added by akash to change the record on update in assured block

			/*
			 * new PT_IL_POL_ASSURED_DTLS_HELPER()
			 * .L_INSERT_PT_IL_POL_ASSUR_DTLS(
			 * dummy_bean.getUI_M_CONT_REF_ID1(), dummy_bean,
			 * dummy_bean.getUI_M_CONT_REF_ID2(), pt_il_policy_bean,
			 * compositeAction .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
			 * .getPT_IL_POL_ASSURED_DTLS_BEAN());
			 */

			// added by akash to change the record on update in assured block]
			/*
			 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE; RAISE
			 * FORM_TRIGGER_FAILURE; END; END;
			 */

			// commented for med exam dtl repopulation as its handled in prem
			// calc
			/*
			 * if((("002").equals(pt_il_policy_bean.getPOL_END_TYPE()) &&
			 * "N".equalsIgnoreCase(pt_il_policy_bean.getPOL_FRZ_FLAG()))){
			 * 
			 * deleteExistRecords(pt_il_policy_bean); double fc_sa=EndMedRec(
			 * pt_il_policy_bean ); if(!M_PS_CODE_1.equals(CommonUtils.nvl(
			 * pt_il_policy_bean.getPOL_END_CODE(), "000")) &&
			 * !M_PS_CODE_2.equals(CommonUtils.nvl(
			 * pt_il_policy_bean.getPOL_END_CODE(), "000"))) { new
			 * P9ILPK_POLICY().INS_MED_EXAM_DTL(CommonUtils.getProcedureValue(fc_sa),
			 * CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
			 * CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_PROD_CODE()),
			 * CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_CONT_CODE())); } }
			 */

			/*Added by saritha on 28-07-2017 for ssp call id ZBILQC-1733319*/
			if("N".equalsIgnoreCase(pt_il_policy_bean.getPOL_FRZ_FLAG())){
				p9ilpk_policy.P_INS_POL_DOLIST(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						null, "N", CommonUtils
						.getProcedureValue(pt_il_policy_bean
								.getPOL_START_DT()));

			}
			/*End*/	
			/*
			 * Added by ganesh to update the dependant mainmember alone while changing Life
			 * assured code/Contractor code on 24-01-2018 as suggested by sivaram
			 */
			if(pt_il_policy_bean.getPOL_END_NO_IDX()==0){
				p9ilpk_policy.P_UPD_DEP_MEMBER(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()), pt_il_policy_bean.getPOL_CONT_CODE());
			}
			/*end*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void deleteExistRecords(PT_IL_POLICY policyBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String delQuery = "DELETE FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			handler.executeDeleteStatement(delQuery, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			CommonUtils.getConnection().commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public Double EndMedRec(PT_IL_POLICY policyBean) throws Exception {
		Double ORG_SA = null;
		Double total_sa = null;

		String CURSOR_C1 = "SELECT POL_ORG_FC_SUM_ASSURED FROM PT_IL_POLICY WHERE POL_SYS_ID=?";

		ResultSet rs1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] obj1 = { policyBean.getPOL_SYS_ID() };

		try {
			connection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(CURSOR_C1, connection, obj1);
			if (rs1.next()) {
				ORG_SA = rs1.getDouble(1);
				total_sa = policyBean.getPOL_FC_SUM_ASSURED() + ORG_SA;

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
			}
		}
		return total_sa;
	}

	public void POL_JOINT_LIFE_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		try {
			if ("N".equals(currValue)) {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PT_IL_POL_ASSURED_DTLS_1);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
				// compositeAction.TAB_PT_IL_POL_PAYEE_DTLS);
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PT_IL_POL_MED_EXAM_DTL_1);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");

			} else {

				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");

				/*
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * compositeAction.TAB_PT_IL_POL_ASSURED_DTLS_1); //
				 * compositeAction.TAB_PT_IL_POL_PAYEE_DTLS);
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * compositeAction.TAB_PT_IL_POL_MED_EXAM_DTL_1);
				 */}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_ISSUE_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue)
			throws Exception {

		Connection connection = null;

		String query1 = "SELECT PT_UW_YEAR,PT_SYS_ID   FROM   PM_IL_PROP_TREATY "
				+ " WHERE  ?  BETWEEN PT_START_DT AND   PT_END_DT "
				+ " AND    PT_CLASS_CODE = ?  ";

		String query2 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET "
				+ " WHERE ASD_CODE =?  AND   "
				+ " ASD_USER_ID = ?  AND  ?  "
				+ " BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";

		String query3 = " SELECT PT_CQS_PERC  FROM   PM_IL_PROP_TREATY   WHERE"
				+ "  ?  BETWEEN PT_START_DT AND   PT_END_DT"
				+ "    AND    PT_CLASS_CODE = ? "
				+ "     AND    PT_CQS_YN     = ? ";
		String query4 = "SELECT ASD_NUM_VALUE FROM   PM_IL_APPR_SETUP_DET WHERE  "
				+ " ASD_CODE =? AND    ASD_USER_ID =? "
				+ " AND   ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') "
				+ " AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";

		String query5 = "  SELECT 'X'  FROM   PT_IL_POL_ADDL_COVER   WHERE  POAC_POL_SYS_ID  =? ";

		String query6 = "  SELECT POAC_SYS_ID,POAC_COVER_CODE,POAC_PERIOD "
				+ "  FROM   PT_IL_POL_ADDL_COVER  WHERE  POAC_POL_SYS_ID =? ";

		Object[] object1 = {}, object2 = {}, object3 = {}, object1a = {}, object4 = {}, object5 = {}, object6 = {};
		ResultSet rs1 = null, rs1a = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null;
		DBProcedures procedures = new DBProcedures();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		Integer M_UW_YEAR = null;
		String M_PT_CQS_YN = null;
		String M_AS_ISS_BACK_DT = null;
		Double M_AS_BACK_NOOF_DAYS = null;
		String M_POAC_COVER_CODE = null;
		Date M_POAC_TO_DT = null;
		Double M_POAC_PERIOD = null;
		Double M_POAC_SYS_ID = null;
		String M_CHAR = null;
		String VAR = null;
		/*commented by gopi for toi on 01/06/18*/
		Date sysDate = new CommonUtils().getCurrentDateAndTimeNew();////added by dhinesh for FALCONLIFE-1349311 on 17-10-16
		/*Date sysDate = new CommonUtils().getCurrentDateAndTimeWithSec();*/
		//END
		try {

			connection = CommonUtils.getConnection();
			if (currValue.after(sysDate)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71030",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

			object1 = new Object[] { currValue,
					pt_il_policy_bean.getPOL_CLASS_CODE() };
			rs1 = new CRUDHandler().executeSelectStatement(query1, connection,
					object1);

			if (rs1.next()) {
				M_UW_YEAR = rs1.getInt(1);
				dummy_bean.setUI_M_PT_SYS_ID(rs1.getLong(2));
				if (!(currValue.equals(pt_il_policy_bean.getPOL_ISSUE_DT()))
						|| pt_il_policy_bean.getPOL_UW_YEAR() == null) {
					if (pt_il_policy_bean.getPOL_FC_BASIC_PREM() == null) {
						if (pt_il_policy_bean.getPOL_UW_YEAR() == null
								|| pt_il_policy_bean.getPOL_END_TYPE() == null) {
							pt_il_policy_bean.setPOL_UW_YEAR(M_UW_YEAR);
						}
					}
				}
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71171",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

			object3 = new Object[] { currValue,
					pt_il_policy_bean.getPOL_CLASS_CODE(), "Y" };
			rs3 = new CRUDHandler().executeSelectStatement(query3, connection,
					object3);

			if (rs3.next()) {
				dummy_bean.setUI_M_PT_CQS_PERC(rs3.getDouble(1));
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(false);

				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					// pt_il_policy_action.getCOMP_POL_CQS_YN',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				// pt_il_policy_action.getCOMP_POL_CQS_YN',NAVIGABLE,PROPERTY_TRUE);
			} else {
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);

			}
			object2 = new Object[] { "POL_BACK_DT",
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
					pt_il_policy_bean.getPOL_PROD_CODE() };
			rs2 = new CRUDHandler().executeSelectStatement(query2, connection,
					object2);
			while (rs2.next()) {
				M_AS_ISS_BACK_DT = rs2.getString(1);
			}

			object4 = new Object[] { "POL_BACK_DAY",
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
					pt_il_policy_bean.getPOL_PROD_CODE() };
			rs4 = new CRUDHandler().executeSelectStatement(query4, connection,
					object4);
			while (rs4.next()) {
				M_AS_BACK_NOOF_DAYS = rs4.getDouble(1);
			}

			if ("N".equals(CommonUtils.nvl(M_AS_ISS_BACK_DT, "N"))) {

				if ((currValue.before(sysDate))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "900051",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			} else if ("Y".equals(CommonUtils.nvl(M_AS_ISS_BACK_DT, "N"))) {

				if (M_AS_BACK_NOOF_DAYS != null) {

					if (currValue.before(CommonUtils.addDaysToDate(sysDate,
							0 - M_AS_BACK_NOOF_DAYS.intValue()))) {

						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90006",
								new Object[] { // CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
								CommonUtils.dateToPELStringFormatter(CommonUtils.addDaysToDate(sysDate,
										0 - M_AS_BACK_NOOF_DAYS.intValue()) )}));
					}
				}
			}
			
			/*Commented and Added by saranya for ssp call ZBILQC-1718566 on 19-01-2017*/
			/*if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getChkFlag() == true) {
			pt_il_policy_bean.setPOL_START_DT(currValue);
			}*/
			System.out.println("POL_ISSUE_DT  :"+pt_il_policy_bean.getPOL_ISSUE_DT());
			 Trunc_st_dt(compositeAction);
			 start_dt_sys_pram(compositeAction);
			 System.out.println("M_SYS_PARAM inside validatePOL_ISSUE_DT  :"+M_SYS_PARAM);
			 if("1".equalsIgnoreCase(M_SYS_PARAM))
			 {
				//MODIFIED BY GOPI FOR TOI
				 /*pt_il_policy_bean.setPOL_START_DT(M_POL_START_DT);*/				
				 /*Date getFirstDateOfMonth=getFirstDateOfMonth(new CommonUtils().getCurrentDateAndTimeWithSec());*/
				 Date getFirstDateOfMonth=getFirstDateOfMonth(new CommonUtils().getCurrentDateAndTimeNew());
				 pt_il_policy_bean.setPOL_START_DT(getFirstDateOfMonth);
				 System.out.println("------->>>pol_start_date_when_create<<-----"+pt_il_policy_bean.getPOL_START_DT());
			 }
			 else
			 {
				 if (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getChkFlag() == true){
				 pt_il_policy_bean.setPOL_START_DT(currValue);
				 }
			 }
			 /*End*/
			
			pt_il_policy_bean.setPOL_PROP_RECV_DT(currValue);
			pt_il_policy_bean.setPOL_PROP_STAMP_DT(currValue);
			if (pt_il_policy_bean.getPOL_START_DT() != null
					&& pt_il_policy_bean.getPOL_PERIOD() != null) {		
				if ("O".equals(dummy_bean.getUI_M_PROD_MATU_DT())) {
					System.out.println("BEFORE condition date value"+dummy_bean.getUI_M_PROD_MATU_DT());
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addDaysToDate(CommonUtils.addMonthsToDate(
									pt_il_policy_bean.getPOL_START_DT(),
									(pt_il_policy_bean.getPOL_PERIOD()
											.intValue() * 12)), -1));
					System.out.println("if condition date value"+pt_il_policy_bean.getPOL_EXPIRY_DT());
				} else {
					System.out.println("BEFORE condition date value"+pt_il_policy_bean.getPOL_EXPIRY_DT());
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addMonthsToDate(pt_il_policy_bean
									.getPOL_START_DT(), pt_il_policy_bean
									.getPOL_PERIOD().intValue() * 12));
					System.out.println("else condition date value"+pt_il_policy_bean.getPOL_EXPIRY_DT());
				}
				
				
				
				if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_DOB() != null) {

					pValList = pkg_pilt002_apac.P_CALC_ANB(pt_il_policy_bean
							.getPOL_START_DT(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_DOB(),
							dummy_bean.getUI_M_PROD_AGE_CALC_FLAG(), dummy_bean
									.getUI_M_AGE());
					if (pValList.get(0).getValueObject() != null) {

						dummy_bean.setUI_M_AGE((Integer) pValList.get(0)
								.getValueObject());
					}

				}
			}
			ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();

			pValList1 = pkg_pilt002_apac.P_SET_DOC_NO_PROP(pt_il_policy_bean
					.getPOL_DS_TYPE(), CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"), pt_il_policy_bean
					.getPOL_DIVN_CODE(), pt_il_policy_bean.getPOL_CLASS_CODE(),
					pt_il_policy_bean.getPOL_PLAN_CODE(), pt_il_policy_bean
							.getPOL_PROD_CODE(), pt_il_policy_bean
							.getPOL_UW_YEAR(), pt_il_policy_bean.getPOL_NO(),
					"PT_IL_POLICY", "Y", currValue, null, null,
					pt_il_policy_bean.getROWID(), null);

			if ("Y".equals((String) pValList1.get(1).getValueObject())) {
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(false);
				pt_il_policy_action.getCOMP_POL_NO().setRequired(true);
			}

			object5 = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs5 = new CRUDHandler().executeSelectStatement(query5, connection,
					object5);
			while (rs5.next()) {
				M_CHAR = rs5.getString(1);
			}

			object6 = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs6 = new CRUDHandler().executeSelectStatement(query6, connection,
					object6);

			while (rs6.next()) {
				// M_POAC_TO_DT = null;
				M_POAC_SYS_ID = rs6.getDouble(1);
				M_POAC_COVER_CODE = rs6.getString(2);
				M_POAC_PERIOD = rs6.getDouble(3);
				if (CommonUtils.addMonthsToDate(currValue,
						M_POAC_PERIOD.intValue() * 12).after(
						pt_il_policy_bean.getPOL_EXPIRY_DT()))
					M_POAC_TO_DT = pt_il_policy_bean.getPOL_EXPIRY_DT();
				else
					M_POAC_TO_DT = CommonUtils.addMonthsToDate(CommonUtils
							.addMonthsToDate(currValue, (M_POAC_PERIOD
									.intValue() * 12)), -1);

				String query = "UPDATE PT_IL_POL_ADDL_COVER SET    "
						+ " POAC_FM_DT  = ?, POAC_TO_DT       = ? "
						+ " WHERE  POAC_SYS_ID      = ? AND   "
						+ " POAC_POL_SYS_ID  = ?  AND "
						+ "   POAC_COVER_CODE  = ?  ";

				new CRUDHandler().executeUpdateStatement(query, connection,
						new Object[] { currValue, M_POAC_TO_DT, M_POAC_SYS_ID,
								pt_il_policy_bean.getPOL_SYS_ID(),
								M_POAC_COVER_CODE });
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1a);
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs6);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void POL_PLAN_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		Connection connection = null;
		String query1 = "SELECT PLAN_TYPE  FROM   PM_IL_PLAN WHERE  "
				+ " PLAN_CODE  = ? AND  PLAN_FRZ_FLAG = ? ";
		Object[] object1 = {};
		ResultSet rs1 = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> pValList = null;
		try {
			connection = CommonUtils.getConnection();
			object1 = new Object[] { currValue,
					PILT002_APAC_CONSTANTS.PLAN_FRZ_FLAG };
			pValList = new ArrayList<String>();
			pValList = procedures.callP_VAL_PLAN(currValue,
					PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_ERR_FLAG);

			pt_il_policy_bean.setUI_M_POL_PLAN_DESC(pValList.get(0));
			// :PT_IL_POLICY.POL_ISSUE_DT := :PT_IL_POLICY.POL_ISSUE_DT;

			rs1 = new CRUDHandler().executeSelectStatement(query1, connection,
					object1);
			while (rs1.next()) {
				dummy_bean.setUI_M_POL_PLAN_TYPE(rs1.getString(1));
			}

			if ("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM()
						.setRendered(true);
				/*
				 * SET_ITEM_PROPERTY('BP.B_ASS_FC_VALUES',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_LC_VALUES',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_SUM_ASSURED',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_PREM',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_LOAD_PREM',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_SENABEL_PREM',VISIBLE,PROPERTY_TRUE);
				 */

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
						.setRendered(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
						.setRendered(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_1_action
						.getCOMP_POAD_FC_AMAN_LOAD_PREM().setRendered(true);
				pt_il_pol_assured_dtls_1_action
						.getCOMP_POAD_LC_AMAN_LOAD_PREM().setRendered(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM()
						.setRendered(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM()
						.setRendered(true);

				/*
				 * SET_ITEM_PROPERTY('BP.B_ASS_SUM_ASSURED_1',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_PREM_1',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_LOAD_PREM_1',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_SENABEL_PREM_1',VISIBLE,PROPERTY_TRUE);
				 */
			} else {
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM()
						.setRendered(false);
				/*
				 * SET_ITEM_PROPERTY('BP.B_ASS_FC_VALUES',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_LC_VALUES',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_SUM_ASSURED',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_PREM',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_LOAD_PREM',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_SENABEL_PREM',VISIBLE,PROPERTY_FALSE);
				 */

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
						.setRendered(false);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
						.setRendered(false);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_1_action
						.getCOMP_POAD_FC_AMAN_LOAD_PREM().setRendered(false);
				pt_il_pol_assured_dtls_1_action
						.getCOMP_POAD_LC_AMAN_LOAD_PREM().setRendered(false);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM()
						.setRendered(false);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM()
						.setRendered(false);

				/*
				 * SET_ITEM_PROPERTY('BP.B_ASS_SUM_ASSURED_1',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_PREM_1',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_AMAN_LOAD_PREM_1',VISIBLE,PROPERTY_FALSE);
				 * SET_ITEM_PROPERTY('BP.B_ASS_SENABEL_PREM_1',VISIBLE,PROPERTY_FALSE);
				 */
			}
			if ("M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE().setRequired(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE_MANDATORY().setRendered(
								true);

			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE().setRequired(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE_MANDATORY().setRendered(
								false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_PROD_GROUP_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY_ACTION pt_il_policy_action, PT_IL_POLICY pt_il_policy,
			String currValue) throws Exception {
		String CURSOR_C1 = " SELECT PGD_PROD_CODE FROM   PM_IL_PROD_GROUP_DTL"
				+ " WHERE  PGD_GROUP_CODE   = ? "
				+ " AND    PGD_MAIN_PROD_YN = 'Y' ";
		ResultSet rs1 = null;
		Connection connection = null;
		pt_il_policy.setPOL_PROD_GROUP_CODE(currValue);
		try {
			connection = CommonUtils.getConnection();
			ArrayList<OracleParameter> pvalList = new PCOPK_GENERAL()
					.P_VAL_GRP_CODE(
							pt_il_policy.getPOL_PROD_GROUP_CODE(),
							"E",
							CommonUtils
									.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),
							CommonUtils.getControlBean().getM_LANG_CODE(),
							pt_il_policy.getUI_M_POL_PROD_GROUP_CODE());
			pt_il_policy.setUI_M_POL_PROD_GROUP_CODE((String) pvalList.get(0)
					.getValueObject());

			rs1 = new CRUDHandler().executeSelectStatement(CURSOR_C1,
					connection, new Object[] { pt_il_policy
							.getPOL_PROD_GROUP_CODE() });
			while (rs1.next()) {
				pt_il_policy.setPOL_PROD_CODE(rs1.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_PROD_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue,
			String oldValue) throws Exception {

		Integer M_PROD_PREM_PAY_YRS = null;
		String M_PROD_JOINT_LIFE_YN = null;
		String M_PROD_DESC = null;
		String M_PROD_BL_DESC = null;
		String M_POL_PLAN_CODE = null;
		String M_POL_TARIFF_TERM_FLAG = null;
		String M_POL_PERIOD = null;
		String M_PLAN_SA_INST_PYMT_YN = null;
		String M_PROD_SA_INST_PYMT_TYPE = null;
		Double M_PPL_LC_MIN_PREM = 0d;
		String M_PROD_MASTER_CERT_YN = null;
		String M_PROD_CBC_YN = null;

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String query1 = " SELECT PROD_DESC,PROD_BL_DESC,PROD_PLAN_CODE,PROD_PREM_PAY_YRS, "
				+ " PROD_JOINT_LIFE_YN,PROD_TARIFF_TERM_FLAG, PROD_PERIOD,"
				+ " PROD_AGE_CALC_FLAG,NVL(PROD_MAX_DEFER_MONTHS,0),  PROD_SA_INST_PYMT_TYPE"
				+ " FROM   PM_IL_PRODUCT  WHERE  PROD_CODE = ? ";

		String query2 = " SELECT NVL(PLAN_SA_INST_PYMT_YN,'N')  FROM   PM_IL_PLAN   "
				+ " WHERE  PLAN_CODE =? ";

		String query3 = " SELECT MP_POL_NO  FROM   PM_IL_MASTER_POLICY WHERE "
				+ " MP_PROD_CODE =  ?  AND    MP_CUST_CODE = ? ";

		String query4 = " SELECT  PPL_LC_MIN_PREM   FROM    PM_IL_PROD_PREM_LIMIT    WHERE   "
				+ " PPL_PROD_CODE  =  ?  AND     "
				+ " PPL_MODE_OF_PYMT  = ?  AND  ?  "
				+ " BETWEEN  PPL_FM_TERM AND PPL_TO_TERM ";

		String query5 = " SELECT PROD_MASTER_CERT_YN FROM   PM_IL_PRODUCT  WHERE "
				+ " PROD_CODE = ? ";

		String query1a = " SELECT PROD_CBC_YN  FROM PM_IL_PRODUCT  WHERE PROD_CODE = ? ";

		Connection connection = null;

		Object[] object1 = {}, object2 = {}, object3 = {}, object1a = {}, object4 = {}, object5 = {};
		ResultSet rs1 = null, rs1a = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null;
		DBProcedures dbProcedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> pValList = new ArrayList<String>();

		try {
			connection = CommonUtils.getConnection();

			object2 = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };

			object1a = new Object[] { currValue };
			object5 = new Object[] { currValue };

			if ("2".equalsIgnoreCase(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_11"))) {

				rs1a = new CRUDHandler().executeSelectStatement(query1a,
						connection, object1a);
				if (rs1a.next()) {
					M_PROD_CBC_YN = rs1a.getString(1);
				}

				if ("Y".equalsIgnoreCase(M_PROD_CBC_YN)) {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91574",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));

				}
			}
			/*
			 * if (pt_il_policy_bean.getPOL_ISSUE_DT() != null) {
			 * pt_il_policy_bean.setPOL_ISSUE_DT(new CommonUtils()
			 * .getCurrentDate()); }
			 */

			pValList = procedures.PILT002_APAC_P_VAL_PRODUCT(currValue,
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_ISSUE_DT()),
					PILT002_APAC_CONSTANTS.P_ERR_FLAG);
			if (pValList != null && !pValList.isEmpty()) {
				if (pValList.get(0) != null) {
					pt_il_policy_bean.setUI_M_PROD_DESC(pValList.get(0));
				}
			}

			if (pt_il_policy_bean.getPOL_CUST_CODE() != null) {
				rs5 = new CRUDHandler().executeSelectStatement(query5,
						connection, object5);
				while (rs5.next()) {
					M_PROD_MASTER_CERT_YN = rs5.getString(1);
				}
				object3 = new Object[] { currValue,
						pt_il_policy_bean.getPOL_CUST_CODE() };
				if ("Y".equals(CommonUtils.nvl(M_PROD_MASTER_CERT_YN, "N"))) {
					rs3 = new CRUDHandler().executeSelectStatement(query3,
							connection, object3);
					if (rs3.next()) {
						pt_il_policy_bean
								.setPOL_MASTER_POL_NO(rs3.getString(1));
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91145",
								new Object[] { CommonUtils.getControlBean()
										.getM_LANG_CODE() }));

					}
				} else {
					pt_il_policy_bean.setPOL_MASTER_POL_NO(null);
				}
			}
			object1 = new Object[] { currValue };
			rs1 = new CRUDHandler().executeSelectStatement(query1, connection,
					object1);

			while (rs1.next()) {
				M_PROD_DESC = rs1.getString(1);
				M_PROD_BL_DESC = rs1.getString(2);
				M_POL_PLAN_CODE = rs1.getString(3);
				M_PROD_PREM_PAY_YRS = rs1.getInt(4);
				M_PROD_JOINT_LIFE_YN = rs1.getString(5);
				M_POL_TARIFF_TERM_FLAG = rs1.getString(6);
				dummy_bean.setUI_M_POL_PERIOD(rs1.getInt(7));
				dummy_bean.setUI_M_PROD_AGE_CALC_FLAG(rs1.getString(8));
				pt_il_policy_bean.setPOL_DEFER_PRD(rs1.getDouble(9));
				M_PROD_SA_INST_PYMT_TYPE = rs1.getString(10);
			}

			// commented by Mohan.This is handled in when create record method

			/*
			 * if ("Y".equals(M_PROD_JOINT_LIFE_YN)) {
			 * pt_il_policy_bean.setPOL_JOINT_LIFE_YN("Y");
			 * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			 * .getCOMP_POL_JOINT_LIFE_YN().setDisabled(false);
			 * pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
			 * true); //
			 * compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_PAYEE_DTLS); //
			 * compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_ASSURED_DTLS_1); //
			 * compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_MED_EXAM_DTL_1);
			 *  // PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1
			 * compositeAction.getWizard().enableWizardItem(
			 * "PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
			 * compositeAction.getWizard().enableWizardItem(
			 * "PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");
			 *  } else { //
			 * compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_PAYEE_DTLS); //
			 * compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_ASSURED_DTLS_1); //
			 * compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_MED_EXAM_DTL_1);
			 * compositeAction.getWizard().disableWizardItem(
			 * "PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
			 * compositeAction.getWizard().disableWizardItem(
			 * "PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");
			 * pt_il_policy_bean.setPOL_JOINT_LIFE_YN("N");
			 * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
			 * .getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			 *  }
			 */
			if (pt_il_policy_bean.getPOL_PREM_PAY_YRS() == null)
				
				/*Commented by Janani on 04.04.2018 as per Sivaram suggestion for KIC*/
				//pt_il_policy_bean.setPOL_PREM_PAY_YRS(M_PROD_PREM_PAY_YRS);
				
				/*End*/
			pt_il_policy_bean.setPOL_PLAN_CODE(M_POL_PLAN_CODE);

			/*
			 * if ("Y".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT()) ||
			 * "H".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT()) ||
			 * "M".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT()) ||
			 * "Q".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
			 * 
			 * pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
			 * false);
			 * pt_il_policy_bean.setPOL_PREM_PAY_YRS(M_PROD_PREM_PAY_YRS); }
			 * 
			 * else { pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS()
			 * .setDisabled(true); pt_il_policy_bean.setPOL_PREM_PAY_YRS(1); }
			 */

			pValList = new ArrayList<String>();
			pValList = dbProcedures.callP_VAL_PLAN(pt_il_policy_bean
					.getPOL_PLAN_CODE(), PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_ERR_FLAG);
			if (pValList != null && !pValList.isEmpty()) {
				if (pValList.get(0) != null) {

					pt_il_policy_bean.setUI_M_POL_PLAN_DESC(pValList.get(0));
				}
			}
			String prev = CommonUtils.nvl(pt_il_policy_bean.getPOL_PROD_CODE(),
					"n");
			if (!prev.equalsIgnoreCase(currValue)) {
				pt_il_policy_bean
						.setPOL_TARIFF_TERM_FLAG(M_POL_TARIFF_TERM_FLAG);
			}
			if (pt_il_policy_bean.getPOL_PERIOD() == null) {
				
				/*Commented by Janani on 04.04.2018 as per Sivaram suggestion for KIC*/
				//pt_il_policy_bean.setPOL_PERIOD(dummy_bean.getUI_M_POL_PERIOD());
				/*End*/
			}

			compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getCOMP_POL_PLAN_CODE().setDisabled(true);

			if ("A".equals(M_PROD_SA_INST_PYMT_TYPE)) {
				// compositeAction.getPT_IL_POLICY_ACTION_BEAN() commented by
				// vinoj to fix P11JLIFEQC-1676569
				// .getCOMP_POL_PERIOD().setDisabled(true);
			} else if ("B".equals(M_PROD_SA_INST_PYMT_TYPE)
					|| "C".equals(M_PROD_SA_INST_PYMT_TYPE)) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_PERIOD().setDisabled(false);
				// pt_il_policy_action.getCOMP_POL_PERIOD',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					// pt_il_policy_action.getCOMP_POL_PERIOD',UPDATE_ALLOWED,PROPERTY_TRUE);
				}

			}
			if ("M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE().setRequired(true);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE_MANDATORY().setRendered(
								true);

			} else if ("U".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(
						true);

				pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME().setDisabled(
						true);

			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE().setRequired(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CREDIT_INT_RATE_MANDATORY().setRendered(
								false);
			}

			if ("P".equals(dummy_bean.getUI_M_COVER_SA_CALC())
					|| "V".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
				object4 = new Object[] { currValue,
						pt_il_policy_bean.getPOL_MODE_OF_PYMT(),
						M_PROD_PREM_PAY_YRS };
				rs4 = new CRUDHandler().executeSelectStatement(query4,
						connection, object4);

				while (rs4.next()) {
					M_PPL_LC_MIN_PREM = rs4.getDouble(1);
				}
				if (!(currValue.equalsIgnoreCase(oldValue))) {
					pt_il_policy_bean.setPOL_FC_MODAL_PREM(CommonUtils.nvl(
							M_PPL_LC_MIN_PREM, 0));
					pt_il_policy_bean.setPOL_LC_MODAL_PREM(pt_il_policy_bean
							.getPOL_FC_MODAL_PREM());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs1a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			if (CommonUtils.getGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE") != null
					&& compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE() == null) {
				compositeAction
						.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN()
						.setPOL_CUST_CODE(
								CommonUtils
										.getGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE"));

			}
			if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
					.getUI_M_CHANGE_SA_YN() == null) {
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setUI_M_CHANGE_SA_YN("Y");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void PRE_QUERY(PT_IL_POLICY pt_il_policy_bean) {
		try {

			pt_il_policy_bean.setPOL_DS_CODE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));

			pt_il_policy_bean.setPOL_DS_TYPE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_11"));
			if (CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID") != null) {
				
				/*commented by raja on 22-05-2017*/
				/*pt_il_policy_bean.setPOL_SYS_ID((Long) CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID"));*/
				
				pt_il_policy_bean.setPOL_SYS_ID(Long.valueOf(CommonUtils
						.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString()));
				/*end*/
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", null);

			if ("IL_END_QUOT".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"))
					|| ("Q".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13")) && "1"
							.equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_11")))) {
				pt_il_policy_bean.setPOL_PROP_QUOT_FLAG("Q");
			}

			if ("PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))) {
				// SET_BLOCK_PROPERTY('PT_IL_POLICY',DEFAULT_WHERE,'
				// POL_SYS_ID='||:PT_IL_POLICY.POL_SYS_ID);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void POL_NO_WHEN_VALIDATE_ITEM(String POL_DS_TYPE, String currValue,PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		try {
			
			if(pt_il_policy_bean.getROWID()==null){
				local_procedures.IL_UNIQUE_POL_NO(POL_DS_TYPE, currValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}

	}

	public void POL_SRC_OF_BUS_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String query1 = " SELECT 'X' FROM   PP_SYSTEM  WHERE  PS_TYPE = ? "
				+ " AND    PS_CODE = ?  AND    "
				+ " INSTR (PS_CODE_DESC,  ? ) > 0 ";
		String delQ1 = " DELETE FROM PT_IL_POL_BROKER_DTL   WHERE POBD_POBH_SYS_ID"
				+ " IN (SELECT POBH_SYS_ID FROM PT_IL_POL_BROKER_HEAD "
				+ " WHERE POBH_POL_SYS_ID = ? )";
		String delQ2 = " DELETE FROM PT_IL_POL_BROKER_HEAD   WHERE POBH_POL_SYS_ID =  ? ";

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String M_DUMMY = null;

		try {
			connection = CommonUtils.getConnection();
			pValList = pkg_pilt002_apac.P_VAL_CODES("SRC_BUS_TY", currValue,
					pt_il_policy_bean.getUI_M_POL_SRC_OF_BUS_DESC(),
					PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
			
			pt_il_policy_bean.setUI_M_POL_SRC_OF_BUS_DESC(pValList.get(0)
					.getValue());
			rs = handler.executeSelectStatement(query1, connection,
					new Object[] { "IL_EX_SRCBUS", "IL_EX_SRCBUS", currValue });
			while (rs.next()) {
				M_DUMMY = rs.getString(1);
			}

			if ("X".equals(CommonUtils.nvl(M_DUMMY, "N"))) {
				// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
				// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_BROKER_HEAD',ENABLED,PROPERTY_FALSE);
				handler.executeDeleteStatement(delQ1, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				handler.executeDeleteStatement(delQ2, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			} else {
				// compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
				// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_BROKER_HEAD',ENABLED,PROPERTY_TRUE);
			}
			// Added By Haneef, To default the HosingCampgihn as Y in MoreInfo3,
			// if src of bus is broker
			if ("075".equalsIgnoreCase(currValue)) {
				pt_il_policy_bean.setPOL_HOME_OWNER_FLAG("Y");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void POL_FC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_DEPOSIT_AMOUNT(Double
					.parseDouble(pValList.get(0)));

			pt_il_policy_bean.setPOL_LC_DEPOSIT_AMOUNT(pt_il_policy_bean
					.getPOL_FC_DEPOSIT_AMOUNT()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());
			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_DEPOSIT_AMOUNT().toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_DEPOSIT_AMOUNT(Double
					.parseDouble(pValList.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}

	public void POL_CUST_CURR_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		try {
			//  
			// P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE);

			pValList = pkg_pilt002_apac.P_VAL_CURR(currValue, pt_il_policy_bean
					.getUI_M_POL_CUST_CURR_DESC(),
					PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_ERR_FLAG, pt_il_policy_bean
							.getPOL_CUST_CODE());

			pt_il_policy_bean.setUI_M_POL_CUST_CURR_DESC(pValList.get(0));

			pkg_pilt002_apac.IL_CUST_CURR_EXIST(pt_il_policy_bean
					.getPOL_CUST_CODE(), currValue);

			pValList = new ArrayList<String>();
			/*Modified POL_ISSUE_DATE to POL_START_DT by ganesh */
			pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(currValue,
					dummy_bean.getUI_M_BUY_SELL(), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_CUST_EXCH_RATE()), "E");

			pt_il_policy_bean.setPOL_CUST_EXCH_RATE(Double.parseDouble(pValList
					.get(0)));
			if (currValue.equals(dummy_bean.getUI_M_BASE_CURR())) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_CUST_EXCH_RATE().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
			}
		}

	}

	public void POL_START_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue)
			throws Exception {

		Integer M_UW_YEAR = null;
		String M_DUM_VALUE = null;
		String M_DUM_DESC = null;
		String M_AS_ISS_BACK_DT = null;
		Double M_AS_BACK_NOOF_DAYS = null;
		Date sysDate = new CommonUtils().getCurrentDate();

		String query1 = " SELECT PT_UW_YEAR  FROM   PM_IL_PROP_TREATY "
				+ " WHERE  ?  BETWEEN PT_START_DT "
				+ " AND  PT_END_DT  AND  PT_CLASS_CODE = ?   ";
		String query2 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET "
				+ " WHERE ASD_CODE =?  AND   "
				+ " ASD_USER_ID = ?  AND  ?  "
				+ " BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";
		String query4 = "SELECT ASD_NUM_VALUE FROM   PM_IL_APPR_SETUP_DET WHERE  "
				+ " ASD_CODE =? AND    ASD_USER_ID =? "
				+ " AND   ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') "
				+ " AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs4 = null;
		try {
			values = new Object[] { currValue,
					pt_il_policy_bean.getPOL_CLASS_CODE() };
			pValList = procedures.callP_VAL_SYSTEM("IL_UW_DATE", "IL_UW_DATE",
					M_DUM_DESC, "N", M_DUM_VALUE);

			if (pValList.size() > 0) {
				M_DUM_DESC = pValList.get(0);
				M_DUM_VALUE = pValList.get(1);
			}

			if ("1".equals(M_DUM_VALUE)) {
				connection = CommonUtils.getConnection();
				rs = handler.executeSelectStatement(query1, connection, values);
				if (rs.next()) {
					M_UW_YEAR = rs.getInt(1);
					pt_il_policy_bean.setPOL_UW_YEAR(M_UW_YEAR);
				} else {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71171",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

				}
			}

			if ("O".equals(dummy_bean.getUI_M_PROD_MATU_DT())) {
				if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addDaysToDate(CommonUtils.addMonthsToDate(
									currValue,
									(pt_il_policy_bean.getPOL_PERIOD()
											.intValue() + pt_il_policy_bean
											.getPOL_ORG_PERIOD()) * 12), -1));
				} else {
					//MODIFIED BY GOPI FOR TOI ON 26/07/2018
					String policy_aaprove=getPolicyApprove(pt_il_policy_bean.getPOL_PROD_CODE());
					if(policy_aaprove!=null && "B".equalsIgnoreCase(policy_aaprove)){
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addDaysToDate(CommonUtils.addMonthsToDate(
									currValue, pt_il_policy_bean
											.getPOL_PERIOD().intValue() * 12),
									-1));
					}else if(policy_aaprove!=null && "O".equalsIgnoreCase(policy_aaprove)){
					Calendar cal = Calendar.getInstance();
					cal.setTime(currValue);
					cal.set(Calendar.HOUR_OF_DAY,23);
					cal.set(Calendar.MINUTE,59);
					
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addDaysToDate(CommonUtils.addMonthsToDate(
									cal.getTime(), pt_il_policy_bean
											.getPOL_PERIOD().intValue() * 12),
									-1));
					
					}
				//END	
				}
			} else {
				if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addMonthsToDate(currValue,
									(pt_il_policy_bean.getPOL_PERIOD()
											.intValue() + pt_il_policy_bean
											.getPOL_ORG_PERIOD()) * 12));
				} else {
					pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
							.addMonthsToDate(currValue, pt_il_policy_bean
									.getPOL_PERIOD().intValue() * 12));
				}
			}

			//ADDED BY GOPI FOR TOI
			
			Date policy_start_date =currValue;
			DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
			String poldate = dateformate.format(policy_start_date);
			Date FIRST_INS_DT = dateformate.parse(poldate);
			
			pt_il_policy_bean.setPOL_FIRST_INST_DT(FIRST_INS_DT);
			//pt_il_policy_bean.setPOL_FIRST_INST_DT(currValue);

			if (pt_il_policy_bean.getPOL_EXPIRY_DT() != null
					&& pt_il_policy_bean.getPOL_EXPIRY_DT().before(currValue)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"Policy Start date", "<=", "Policy Expiry Date" }));
			}
			// CHANGES
			// Object object2 =
			rs2 = handler.executeSelectStatement(query2, connection,
					new Object[] { "POL_BACK_DT",
							CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
							pt_il_policy_bean.getPOL_PROD_CODE() });
			while (rs2.next()) {
				M_AS_ISS_BACK_DT = rs2.getString(1);
			}
			Object[] object4 = new Object[] { "POL_BACK_DAY",
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
					pt_il_policy_bean.getPOL_PROD_CODE() };
			rs4 = handler.executeSelectStatement(query4, connection, object4);
			while (rs4.next()) {
				M_AS_BACK_NOOF_DAYS = rs4.getDouble(1);
			}
			if ("N".equals(CommonUtils.nvl(M_AS_ISS_BACK_DT, "N"))) {

				if ((currValue.before(sysDate))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "900051",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			} else if ("Y".equals(CommonUtils.nvl(M_AS_ISS_BACK_DT, "N"))) {

				if (M_AS_BACK_NOOF_DAYS != null) {

					if (currValue.before(CommonUtils.addDaysToDate(sysDate,
							0 - M_AS_BACK_NOOF_DAYS.intValue()))) {

						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "900052",
								new Object[] { // CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
								CommonUtils.addDaysToDate(sysDate,
										0 - M_AS_BACK_NOOF_DAYS.intValue()) }));

					}
				}
			}
			pt_il_policy_bean.setPOL_START_DT(currValue);

			
			/*Added by Ram on 06/11/2016 for FALCONLIFE-1353959*/
			ArrayList<String> list = null;
			ArrayList<OracleParameter> list1 = null;
			Integer M_DUM_VALUE_AGE = null;
			String M_DUM_DESC_AGE = null;
			PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
			Date assuredDOB = null;
			ResultSet ageRS = null;
			String ageQuery = "SELECT CUST_DOB FROM PM_CUSTOMER WHERE CUST_CODE = ?";
			
			ageRS = handler.executeSelectStatement(ageQuery, connection,new Object[]{pt_il_policy_bean.getPOL_CONT_CODE()});
			while(ageRS.next())
			{
				assuredDOB = ageRS.getDate(1);
			}
			System.out.println("assuredDOB       "+assuredDOB);
			
			list = DBProcedures.P_VAL_SYSTEM("IL_AGE_CAL", "IL_AGE_CAL",
					CommonUtils.getProcedureValue(M_DUM_DESC_AGE), "N",
					CommonUtils.getProcedureValue(M_DUM_VALUE));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_DUM_DESC_AGE = list.get(0);
				}
				if (list.get(1) != null) {
					M_DUM_VALUE_AGE = Integer.parseInt(list.get(1));
				}
			}
					
				System.out.println("M_DUM_DESC_AGE    "+M_DUM_DESC_AGE+"  M_DUM_VALUE_AGE   "+M_DUM_VALUE_AGE);	
			if (M_DUM_VALUE_AGE == 1) {
				if (pt_il_policy_bean.getPOL_START_DT().before(currValue)) {
					throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
				}
				list1 = localProcedure.P_CALC_ANB(
						pt_il_policy_bean.getPOL_START_DT(),
						assuredDOB, 
						compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN().getUI_M_PROD_AGE_CALC_FLAG(),
						pt_il_policy_bean.getPOL_JOINT_LIFE_AGE());
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						
						/*Added by Janani on 28.04.2018 for Fidelity Joint life issue*/
						if(pt_il_policy_bean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("n"))
						{
						/*End*/	
						
						pt_il_policy_bean.setPOL_JOINT_LIFE_AGE((Integer)list1.get(0).getValueObject());
						}
					}
				}
			}  else {
				if (pt_il_policy_bean.getPOL_ISSUE_DT().before(currValue)) {
					throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
				}
				list1 = localProcedure.P_CALC_ANB(
						pt_il_policy_bean.getPOL_START_DT(),
						assuredDOB, 
						compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN().getUI_M_PROD_AGE_CALC_FLAG(),
						pt_il_policy_bean.getPOL_JOINT_LIFE_AGE());
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						/*Added by Janani on 28.04.2018 for Fidelity Joint life issue*/
						if(pt_il_policy_bean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("n"))
						{
						/*End*/	
						
						pt_il_policy_bean.setPOL_JOINT_LIFE_AGE((Integer)list1.get(0).getValueObject());
						
						}
					}
				}
			} 
			
			System.out.println("pt_il_policy_bean.getPOL_JOINT_LIFE_AGE    "+pt_il_policy_bean.getPOL_JOINT_LIFE_AGE());	
			
			/*End*/
			  
			// CHANGES

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Double POL_SA_EXCH_RATE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		try {

			pValList = lifelibProcedures.P_VAL_EXCHANGE_RATE(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), dummy_bean.getUI_M_BUY_SELL(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_ISSUE_DT()), CommonUtils
							.getProcedureValue(currValue), "E");
			if (!pValList.isEmpty() && pValList != null)
				currValue = Double.parseDouble(pValList.get(0));
			if (pt_il_policy_bean.getPOL_FC_SUM_ASSURED() != null) {

				pt_il_policy_bean.setPOL_LC_SUM_ASSURED(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED()
						* currValue);
				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), CommonUtils
						.getProcedureValue(pt_il_policy_bean
								.getPOL_LC_SUM_ASSURED()), "R",
						pt_il_policy_bean.getPOL_PROD_CODE());
				if (!pValList.isEmpty() && pValList != null)
					pt_il_policy_bean.setPOL_LC_SUM_ASSURED(Double
							.parseDouble(pValList.get(0)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
		return currValue;
	}

	public void POL_SA_CURR_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		ArrayList<String> pValList = new ArrayList<String>();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		try {
			pValList = procedures.callP_VAL_CURR(currValue,
					PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_ERR_FLAG, pt_il_policy_bean
							.getPOL_CUST_CODE());

			pt_il_policy_bean.setUI_M_POL_SA_CURR_DESC(pValList.get(0));

			pValList = new ArrayList<String>();
			/*Modified POL_ISSUE_DATE to POL_START_DT by ganesh */
			pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(currValue,
					dummy_bean.getUI_M_BUY_SELL(), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SA_EXCH_RATE()), "E");
			if (pValList != null) {
				if (pValList.get(0) != null) {
					pt_il_policy_bean.setPOL_SA_EXCH_RATE(Double
							.parseDouble(pValList.get(0)));
				}
			}
			if (currValue.equals(dummy_bean.getUI_M_BASE_CURR())) {
				pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE()
						.setDisabled(true);
			} else {
				pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(
						false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			} catch (Exception e) {
			}
		}

	}

	public void POL_EXPIRY_DT_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY pt_il_policy_bean, Date currValue) throws Exception {

		try {
			if (currValue != null)
				if (pt_il_policy_bean.getPOL_START_DT() != null
						&& currValue
								.before(pt_il_policy_bean.getPOL_START_DT())) {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { /* CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"), */
							"Policy Expiry date", ">=", "Policy Start Date" }));
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}

	public Integer POL_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Integer currValue)
			throws Exception {

		Connection connection = null;

		ResultSet rs = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
		/*Modified by ganesh on 26-04-2018 last installment date issue*/
		//String query1 = " SELECT ADD_MONTHS(ADD_MONTHS(?,? * 12),DECODE(? ,'Y', -12, 'M', -6, 'Q', -3, 'M', -1))  FROM DUAL ";
		String query1 = " SELECT ADD_MONTHS(ADD_MONTHS(?,? * 12),DECODE(? ,'Y', -12, 'H', -6, 'Q', -3, 'M', -1))  FROM DUAL ";
		/*end*/
		String query2 = " SELECT PROD_PREM_PAY_YRS  FROM    PM_IL_PRODUCT WHERE   PROD_CODE = ?  AND PROD_PLAN_CODE = ?  ";
		Integer M_PROD_PREM_PAY_YRS = null;
		pt_il_policy_bean.setPOL_PREM_PAY_YRS(currValue);
		try {
			connection = CommonUtils.getConnection();
			Integer pol_prd = CommonUtils.nvl(
					pt_il_policy_bean.getPOL_PERIOD(), 0)
					+ CommonUtils.nvl(pt_il_policy_bean.getPOL_ORG_PERIOD(), 0);
			/*Commented by Ram on 26/11/2016 for Policy Period validation handling
			 * 
			 * if (currValue > pt_il_policy_bean.getPOL_PERIOD()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {
								"Premium Paying Years",
								"less than or equal to Policy Period  "
										+ pol_prd }));
			}*/

			if (pt_il_policy_bean.getPOL_START_DT() != null) {
				if ("0".equals(dummy_bean.getUI_M_PROD_MATU_DT())) {
					if ("012".equalsIgnoreCase(CommonUtils.nvl(
							pt_il_policy_bean.getPOL_END_TYPE(), "000"))) {
						pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
								.addDaysToDate((CommonUtils.addMonthsToDate(
										pt_il_policy_bean.getPOL_START_DT(),
										(pt_il_policy_bean.getPOL_PERIOD()
												.intValue() + pt_il_policy_bean
												.getPOL_ORG_PERIOD()) * 12)),
										-1));
					} else {
						pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
								.addDaysToDate((CommonUtils.addMonthsToDate(
										pt_il_policy_bean.getPOL_START_DT(),
										pt_il_policy_bean.getPOL_PERIOD()
												.intValue() * 12)), -1));
					}
				} else {
					if ("012".equalsIgnoreCase(CommonUtils.nvl(
							pt_il_policy_bean.getPOL_END_TYPE(), "000"))) {
						pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
								.addDaysToDate((CommonUtils.addMonthsToDate(
										pt_il_policy_bean.getPOL_START_DT(),
										(pt_il_policy_bean.getPOL_PERIOD()
												.intValue() + pt_il_policy_bean
												.getPOL_ORG_PERIOD()) * 12)),
										-1));
					} else {
						pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
								.addMonthsToDate(pt_il_policy_bean
										.getPOL_START_DT(), pt_il_policy_bean
										.getPOL_PERIOD().intValue() * 12));
					}
				}
			}

			if (pt_il_policy_bean.getPOL_FIRST_INST_DT() != null) {
				values = new Object[] {
						pt_il_policy_bean.getPOL_FIRST_INST_DT(), currValue,
						pt_il_policy_bean.getPOL_MODE_OF_PYMT() };
				rs = handler.executeSelectStatement(query1, connection, values);
				if (rs.next())
					pt_il_policy_bean.setPOL_LAST_INST_DT(rs.getDate(1));
			}
			CommonUtils.closeCursor(rs);

			if (pt_il_policy_bean.getPOL_FIRST_INST_DT() != null
					&& pt_il_policy_bean.getPOL_START_DT() != null) {
				if (pt_il_policy_bean.getPOL_FIRST_INST_DT().before(
						pt_il_policy_bean.getPOL_START_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71035"));
				}
			}

			if ("S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
				pt_il_policy_bean.setPOL_LAST_INST_DT(pt_il_policy_bean
						.getPOL_FIRST_INST_DT());
			}
			/*Commented by Ram on 26/11/2016 for Policy Period validation handling
			 * 
			 * if (currValue > pt_il_policy_bean.getPOL_PERIOD()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91076"));
			}*/
			if (!("G".equals(CommonUtils.nvl(
					dummy_bean.getUI_M_COVER_SA_CALC(), "X")))
					&& !"N".equals(CommonUtils.nvl(dummy_bean
							.getUI_M_COVER_SA_CALC(), "X"))) {
				if (!("F".equals(dummy_bean.getUI_M_COVER_SA_CALC()))) {
					if (!("007".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_END_TYPE(), "000")))) {
						if (!("016".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_TYPE(), "000")))) {
							pOrclValList = new ArrayList<OracleParameter>();
							if (("NR".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18")) || CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18") == null)
									&& pt_il_policy_bean
											.getPOL_FC_SUM_ASSURED() != null
									&& pt_il_policy_bean
											.getPOL_FC_SUM_ASSURED() < 1) {

								pOrclValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL(
												pt_il_policy_bean
														.getPOL_SYS_ID(),
												pt_il_policy_bean
														.getPOL_END_NO_IDX(),
												pt_il_policy_bean
														.getPOL_END_CODE(),
												pt_il_policy_bean
														.getPOL_END_TYPE(),
												pt_il_policy_bean
														.getPOL_PREM_PAY_YRS(),
												pt_il_policy_bean
														.getPOL_ORG_NO_OF_INST(),
												pt_il_policy_bean
														.getPOL_SA_CURR_CODE(),
												pt_il_policy_bean
														.getPOL_SA_EXCH_RATE(),
												pt_il_policy_bean
														.getPOL_NO_OF_UNIT(),
												pt_il_policy_bean
														.getPOL_NO_OF_INST(),
												pt_il_policy_bean
														.getPOL_ORG_FC_SUM_ASSURED(),
												pt_il_policy_bean
														.getPOL_PLAN_CODE(),
												pt_il_pol_assured_dtls_bean
														.getPOAD_SYS_ID(),
												pt_il_policy_bean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummy_bean.getUI_M_BASE_CURR(),
												dummy_bean
														.getUI_M_COVER_VAR_VALUE(),
												pt_il_policy_bean.getROWID(),
												dummy_bean
														.getUI_M_PROD_SA_FACTOR(),
												dummy_bean
														.getUI_M_PROD_SA_TARIFF(),
												dummy_bean
														.getUI_M_COVER_SA_CALC(),
												dummy_bean.getUI_M_PS_CODE(),
												dummy_bean
														.getUI_M_POL_PLAN_TYPE(),
												pt_il_policy_bean
														.getPOL_START_DT(),
												compositeAction
														.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
														.getPT_IL_POL_ASSURED_DTLS_BEAN()
														.getPOAD_AGE(),
												dummy_bean.getUI_M_EXACT_AGE(),
												pt_il_policy_bean
														.getPOL_DEF_PERIOD_TO(),
												dummy_bean
														.getUI_M_TD_MIN_RATE(),
												dummy_bean
														.getUI_M_TD_MAX_RATE(),
												pt_il_policy_bean
														.getPOL_NEW_FC_SA(),
												pt_il_policy_bean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);
							} else if ("PG".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18"))) {

								pOrclValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL_PGC(
												pt_il_policy_bean
														.getPOL_PROD_GROUP_CODE(),
												dummy_bean
														.getUI_M_PROD_PREM_TARIFF(),
												pt_il_policy_bean
														.getPOL_SYS_ID(),
												pt_il_policy_bean
														.getPOL_END_NO_IDX(),
												pt_il_policy_bean
														.getPOL_END_CODE(),
												pt_il_policy_bean
														.getPOL_END_TYPE(),
												pt_il_policy_bean
														.getPOL_PREM_PAY_YRS(),
												pt_il_policy_bean
														.getPOL_ORG_NO_OF_INST(),
												pt_il_policy_bean
														.getPOL_SA_CURR_CODE(),
												pt_il_policy_bean
														.getPOL_SA_EXCH_RATE(),
												pt_il_policy_bean
														.getPOL_NO_OF_UNIT(),
												pt_il_policy_bean
														.getPOL_NO_OF_INST(),
												pt_il_policy_bean
														.getPOL_ORG_FC_SUM_ASSURED(),
												pt_il_policy_bean
														.getPOL_PLAN_CODE(),
												pt_il_pol_assured_dtls_bean
														.getPOAD_SYS_ID(),
												pt_il_policy_bean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummy_bean.getUI_M_BASE_CURR(),
												dummy_bean
														.getUI_M_COVER_VAR_VALUE(),
												pt_il_policy_bean.getROWID(),
												dummy_bean
														.getUI_M_PROD_SA_FACTOR(),
												dummy_bean
														.getUI_M_PROD_SA_TARIFF(),
												dummy_bean
														.getUI_M_COVER_SA_CALC(),
												dummy_bean.getUI_M_PS_CODE(),
												dummy_bean
														.getUI_M_POL_PLAN_TYPE(),
												pt_il_policy_bean
														.getPOL_START_DT(),
												compositeAction
														.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
														.getPT_IL_POL_ASSURED_DTLS_BEAN()
														.getPOAD_AGE(),
												dummy_bean.getUI_M_EXACT_AGE(),
												pt_il_policy_bean
														.getPOL_DEF_PERIOD_TO(),
												dummy_bean
														.getUI_M_TD_MIN_RATE(),
												dummy_bean
														.getUI_M_TD_MAX_RATE(),
												pt_il_policy_bean
														.getPOL_NEW_FC_SA(),
												pt_il_policy_bean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);
							}

							if (!pOrclValList.isEmpty() && pOrclValList != null) {
								dummy_bean
										.setUI_M_TD_MIN_RATE((Double) (pOrclValList
												.get(0).getValueObject()));
								dummy_bean
										.setUI_M_TD_MAX_RATE((Double) (pOrclValList
												.get(1).getValueObject()));
								pt_il_policy_bean
										.setPOL_NEW_FC_SA((Double) (pOrclValList
												.get(2).getValueObject()));
								pt_il_policy_bean
										.setPOL_FC_MODAL_PREM((Double) (pOrclValList
												.get(3).getValueObject()));
								pt_il_policy_bean
										.setPOL_FC_BASIC_PREM((Double) (pOrclValList
												.get(4).getValueObject()));
								pt_il_policy_bean
										.setPOL_LC_BASIC_PREM((Double) (pOrclValList
												.get(5).getValueObject()));
								pt_il_policy_bean
										.setPOL_FC_SUM_ASSURED((Double) (pOrclValList
												.get(6).getValueObject()));
								pt_il_policy_bean
										.setPOL_LC_SUM_ASSURED((Double) (pOrclValList
												.get(7).getValueObject()));
								pt_il_policy_bean
										.setPOL_FC_CURR_SA((Double) (pOrclValList
												.get(8).getValueObject()));
								pt_il_policy_bean
										.setPOL_LC_CURR_SA((Double) (pOrclValList
												.get(9).getValueObject()));
								pt_il_policy_bean
										.setPOL_ORG_NEW_LC_SA((Double) (pOrclValList
												.get(10).getValueObject()));
								pt_il_policy_bean
										.setPOL_ORG_NEW_FC_SA((Double) (pOrclValList
												.get(11).getValueObject()));
								pt_il_policy_bean
										.setPOL_NEW_LC_SA((Double) (pOrclValList
												.get(12).getValueObject()));
								pt_il_policy_bean
										.setPOL_FC_MON_ANNU_AMT((Double) (pOrclValList
												.get(13).getValueObject()));
								pt_il_policy_bean
										.setPOL_LC_MON_ANNU_AMT((Double) (pOrclValList
												.get(14).getValueObject()));
							}
						}
					} else if ("F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
						if (!("007".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_PROP_END_TYPE(), "000")))) {
							if ("N".equals(CommonUtils.nvl(dummy_bean
									.getUI_M_PLAN_CALC_TYPE(), "N"))) {

								pOrclValList = new ArrayList<OracleParameter>();
								pOrclValList = pkg_pilt002_apac
										.IL_CALC_SA_FACT_VALID(
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_SYS_ID()),
												pt_il_policy_bean
														.getPOL_PLAN_CODE(),
												pt_il_policy_bean
														.getPOL_END_TYPE(),
												pt_il_policy_bean.getROWID(),
												dummy_bean
														.getUI_M_PROD_SA_FACTOR(),
												CommonUtils
														.getProcedureValue(pt_il_pol_assured_dtls_bean
																.getPOAD_SYS_ID()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_FC_MODAL_PREM()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_ORG_FC_MODAL_PREM()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_ORG_NO_OF_INST()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_ORG_NO_OF_UNIT()),
												dummy_bean
														.getUI_M_PLAN_CALC_TYPE(),
												pt_il_policy_bean
														.getPOL_SA_CURR_CODE(),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_NO_OF_INST()),
												pt_il_policy_bean
														.getPOL_PROD_CODE(),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_ORG_FC_SUM_ASSURED()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_SA_EXCH_RATE()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_NO_OF_UNIT()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_NEW_FC_SA()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_NEW_LC_SA()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_ORG_NEW_FC_SA()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_ORG_NEW_LC_SA()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_FC_SUM_ASSURED()),
												CommonUtils
														.getProcedureValue(pt_il_policy_bean
																.getPOL_LC_SUM_ASSURED()));
								if (pOrclValList != null
										&& !(pOrclValList.isEmpty())) {
									pt_il_policy_bean
											.setPOL_NO_OF_UNIT((Double) pOrclValList
													.get(0).getValueObject());
									pt_il_policy_bean
											.setPOL_NEW_FC_SA((Double) pOrclValList
													.get(1).getValueObject());
									pt_il_policy_bean
											.setPOL_NEW_LC_SA((Double) pOrclValList
													.get(2).getValueObject());
									pt_il_policy_bean
											.setPOL_ORG_NEW_FC_SA((Double) pOrclValList
													.get(3).getValueObject());
									pt_il_policy_bean
											.setPOL_ORG_NEW_LC_SA((Double) pOrclValList
													.get(4).getValueObject());
									pt_il_policy_bean
											.setPOL_FC_SUM_ASSURED((Double) pOrclValList
													.get(5).getValueObject());
									pt_il_policy_bean
											.setPOL_LC_SUM_ASSURED((Double) pOrclValList
													.get(6).getValueObject());
								}
							}
						}
					}
				}

				if ("M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
						&& currValue > 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91422"));
				}

				values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE(),
						pt_il_policy_bean.getPOL_PLAN_CODE() };
				rs = handler.executeSelectStatement(query2, connection, values);
				while (rs.next()) {
					M_PROD_PREM_PAY_YRS = rs.getInt(1);
					if (currValue > M_PROD_PREM_PAY_YRS) {
						currValue = M_PROD_PREM_PAY_YRS;
					}
				}
			}
			/*Added by Ameen on 08-05-2018 as per Chandramohan Sugg. to add GEN013 end. in condition*/
			if("001".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_TYPE(), "000"))){
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
						"GEN013".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
								.getPOL_END_CODE()))
				{
					ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();

					pValList1 = pkg_pilt002_apac.P_PR_UPD_RIDER_TERM(pt_il_policy_bean.getPOL_SYS_ID(),
							0,currValue);

				}
			}
			/*End*/
			
			
			/*Added by Janani on 19.06.2018 for FLA(EAT, ELE, LCTF - Premium paying term should default to the policy term) 
			 * as suggested by Sivaram*/
			
			if(CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(), "EAT","ELE","LCTF"))
			{
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_PREM_PAY_YRS() < compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_PERIOD())
				{
					throw new Exception("Premium Paying Term should be same as Policy Term");
				}
			}
			
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return currValue;
	}

	public Double POL_FC_MODAL_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		Connection connection = null;
		ResultSet rs = null;

		String query1 = "  SELECT PS_CODE   FROM   PP_SYSTEM  WHERE  PS_TYPE = ? ";
		String query8 = "SELECT MAS_MOP_VALUE  FROM PM_MUDHARBAH_MOP WHERE  MAS_MH_PROD_CODE =?  AND  MAS_MOP= ? ";
		String query9 = "SELECT PLAN_TYPE    FROM   PM_IL_PLAN   WHERE  PLAN_CODE = ? ";
		String query10 = "SELECT COVER_PREM_TYPE FROM   PM_IL_COVER  WHERE   COVER_CODE = ? ";
		String query11 = " SELECT 'X'   FROM   PT_IL_DMSRCPT  WHERE  DRP_PROP_NO =? ";
		String M_PS_CODE = null;
		String M_PS_CODE_1 = null;
		String M_PS_CODE_2 = null;
		Double M_MAS_MOP_VALUE = 0.0;
		String M_PLAN_TYPE = null;
		String M_COVER_PREM_TYPE = null;
		String M_TEMP = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		ArrayList<String> pValListArr = new ArrayList<String>();
		ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
		Double prevFcSA = pt_il_policy_bean.getPOL_FC_SUM_ASSURED();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { "IL_OCC_CHG" };
			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_PS_CODE = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);

			values = new Object[] { "IL_DEL_RIDER" };
			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_PS_CODE_1 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);

			values = new Object[] { "IL_ADD_RIDER" };
			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_PS_CODE_2 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);

			String M_COVER_SA_CALC = dummy_bean.getUI_M_COVER_SA_CALC();

			if ("P".equals(M_COVER_SA_CALC) || "V".equals(M_COVER_SA_CALC)
					|| "D".equals(M_COVER_SA_CALC)
					|| "H".equals(M_COVER_SA_CALC)) {
				if (!dummy_bean.getUI_M_PS_CODE().equals(
						CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),
								"000"))
						|| !M_PS_CODE.equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_CODE(), "000"))
						|| !M_PS_CODE_1.equals(CommonUtils.nvl(
								pt_il_policy_bean.getPOL_END_CODE(), "000"))
						|| !M_PS_CODE_2.equals(CommonUtils.nvl(
								pt_il_policy_bean.getPOL_END_CODE(), "000"))) {

					if ((CommonUtils.nvl(currValue, 0.0) + CommonUtils.nvl(
							pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(), 0)) <= 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71043"));
					}
				}
			}

			if ("F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {

				pValList = new ArrayList<OracleParameter>();

				pValList = pkg_pilt002_apac.IL_CALC_SA_FACT_VALID(
						pt_il_policy_bean.getPOL_SYS_ID(), pt_il_policy_bean
								.getPOL_PLAN_CODE(), pt_il_policy_bean
								.getPOL_END_TYPE(), pt_il_policy_bean
								.getROWID(), dummy_bean
								.getUI_M_PROD_SA_FACTOR(),
						pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
						currValue,
						pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
						pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
						pt_il_policy_bean.getPOL_ORG_NO_OF_UNIT(), dummy_bean
								.getUI_M_PLAN_CALC_TYPE(), pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), pt_il_policy_bean
								.getPOL_NO_OF_INST(), pt_il_policy_bean
								.getPOL_PROD_CODE(), pt_il_policy_bean
								.getPOL_ORG_FC_SUM_ASSURED(), pt_il_policy_bean
								.getPOL_SA_EXCH_RATE(), pt_il_policy_bean
								.getPOL_NO_OF_UNIT(), pt_il_policy_bean
								.getPOL_NEW_FC_SA(), pt_il_policy_bean
								.getPOL_NEW_LC_SA(), pt_il_policy_bean
								.getPOL_ORG_NEW_FC_SA(), pt_il_policy_bean
								.getPOL_ORG_NEW_LC_SA(), pt_il_policy_bean
								.getPOL_FC_SUM_ASSURED(), pt_il_policy_bean
								.getPOL_LC_SUM_ASSURED());
				if (pValList != null) {
					if (pValList.get(0) != null) {
						pt_il_policy_bean.setPOL_NO_OF_UNIT((Double) pValList
								.get(0).getValueObject());
					}
					if (pValList.get(1) != null) {
						pt_il_policy_bean.setPOL_NEW_FC_SA((Double) pValList
								.get(1).getValueObject());
					}
					if (pValList.get(2) != null) {
						pt_il_policy_bean.setPOL_NEW_LC_SA((Double) pValList
								.get(2).getValueObject());
					}
					if (pValList.get(3) != null) {
						pt_il_policy_bean
								.setPOL_ORG_NEW_FC_SA((Double) pValList.get(3)
										.getValueObject());
					}
					if (pValList.get(4) != null) {
						pt_il_policy_bean
								.setPOL_ORG_NEW_LC_SA((Double) pValList.get(4)
										.getValueObject());
					}
					/*Commentted & Modified by saritha on 23-08-2017 for Endowment & Education Product Issues*/ 
					
					/*if (pValList.get(5) != null) {
						pt_il_policy_bean
								.setPOL_FC_SUM_ASSURED((Double) pValList.get(5)
										.getValueObject());
					}*/
					
					if (pValList.get(5) != null ) {
						pt_il_policy_bean
								.setPOL_FC_SUM_ASSURED((Double) pValList.get(5)
										.getValueObject());
						
						pt_il_policy_bean
						.setPOL_LC_SUM_ASSURED((Double) pValList.get(5)
								.getValueObject());
					}
					
					/*
					 * 
					 * if (pValList.get(6) != null ) {
						pt_il_policy_bean
								.setPOL_LC_SUM_ASSURED((Double) pValList.get(6)
										.getValueObject());
					}
					
					*/
					/*End*/
				}
			}

			pValListArr = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), CommonUtils
					.getProcedureValue(currValue), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_MODAL_PREM(Double
					.parseDouble(pValListArr.get(0)));

			pt_il_policy_bean.setPOL_LC_MODAL_PREM(pt_il_policy_bean
					.getPOL_FC_MODAL_PREM()
					* pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

			pValListArr = new ArrayList<String>();

			pValListArr = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_LC_MODAL_PREM()), "R", pt_il_policy_bean
							.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_MODAL_PREM(Double
					.parseDouble(pValListArr.get(0)));
			values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
			rs = handler.executeSelectStatement(query9, connection, values);
			while (rs.next()) {
				M_PLAN_TYPE = rs.getString(1);
			}

			CommonUtils.closeCursor(rs);

			if ("U".equals(CommonUtils.nvl(M_PLAN_TYPE, "N"))) {
				values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE(),
						pt_il_policy_bean.getPOL_MODE_OF_PYMT() };
				rs = handler.executeSelectStatement(query8, connection, values);
				while (rs.next()) {
					M_MAS_MOP_VALUE = rs.getDouble(1);
				}
				CommonUtils.closeCursor(rs);

				pValListArr = new ArrayList<String>();
				pValListArr = procedures
						.callPCOPK_GENERAL_P_VAL_PROD_ROUND(
								pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
								CommonUtils.getProcedureValue(M_MAS_MOP_VALUE),
								pt_il_policy_bean.getPOL_PROD_CODE(),
								"R",
								CommonUtils
										.getGlobalVariable("GLOBAL.M_LANG_CODE"),
								CommonUtils
										.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));

				M_MAS_MOP_VALUE = Double.parseDouble(pValListArr.get(0));

				if ("000".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {
					pt_il_policy_bean.setPOL_LC_MIN_PREM(CommonUtils.nvl(
							M_MAS_MOP_VALUE, 0.0));
					pt_il_policy_bean.setPOL_FC_MIN_PREM(CommonUtils.nvl(
							M_MAS_MOP_VALUE, 0.0));
					pt_il_policy_bean.setPOL_FC_EXTRA_PREM(currValue
							- CommonUtils.nvl(pt_il_policy_bean
									.getPOL_FC_MIN_PREM(), 0.0));
					pt_il_policy_bean.setPOL_LC_EXTRA_PREM(currValue
							- CommonUtils.nvl(pt_il_policy_bean
									.getPOL_LC_MIN_PREM(), 0.0));

				} else if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {
					pt_il_policy_bean.setPOL_LC_MIN_PREM(0d);
					pt_il_policy_bean.setPOL_FC_MIN_PREM(0d);
					pt_il_policy_bean.setPOL_FC_EXTRA_PREM(currValue
							- CommonUtils.nvl(pt_il_policy_bean
									.getPOL_FC_MIN_PREM(), 0.0));
					pt_il_policy_bean.setPOL_LC_EXTRA_PREM(currValue
							- CommonUtils.nvl(pt_il_policy_bean
									.getPOL_LC_MIN_PREM(), 0.0));
				}
			}

			values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
			rs = handler.executeSelectStatement(query10, connection, values);
			while (rs.next()) {
				M_COVER_PREM_TYPE = rs.getString(1);
			}

			CommonUtils.closeCursor(rs);

			if ("D".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
				if ("U".equals(dummy_bean.getUI_M_COVER_SA_CALC())
						&& "D".equals(dummy_bean.getUI_M_COVER_PREM_TYPE())) {
					if ((CommonUtils.nvl(currValue, 0.0) + CommonUtils.nvl(
							pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(), 0.0)) <= 0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71043"));
					}
				}
			}

			values = new Object[] { pt_il_policy_bean.getPOL_NO() };
			rs = handler.executeSelectStatement(query11, connection, values);
			if (rs.next()) {
				M_TEMP = rs.getString(1);

				pOrclValList = new ArrayList<OracleParameter>();
				// 'NR' for normal and 'PG' for package policy using
				// menu parameter_18

				if (("NR".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18")) || CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18") == null)
						&& !"N".equals(CommonUtils.nvl(dummy_bean
								.getUI_M_COVER_SA_CALC(), "X"))) {

					pOrclValList = pkg_pilt002_apac.IL_SUM_ASURED_CAL(
							pt_il_policy_bean.getPOL_SYS_ID(),
							pt_il_policy_bean.getPOL_END_NO_IDX(),
							pt_il_policy_bean.getPOL_END_CODE(),
							pt_il_policy_bean.getPOL_END_TYPE(),
							pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
							pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
							pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
							pt_il_policy_bean.getPOL_NO_OF_UNIT(),
							pt_il_policy_bean.getPOL_NO_OF_INST(),
							pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
							pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
							dummy_bean.getUI_M_BASE_CURR(), dummy_bean
									.getUI_M_COVER_VAR_VALUE(),
							pt_il_policy_bean.getROWID(), dummy_bean
									.getUI_M_PROD_SA_FACTOR(), dummy_bean
									.getUI_M_PROD_SA_TARIFF(), dummy_bean
									.getUI_M_COVER_SA_CALC(), dummy_bean
									.getUI_M_PS_CODE(), dummy_bean
									.getUI_M_POL_PLAN_TYPE(), pt_il_policy_bean
									.getPOL_START_DT(), compositeAction
									.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_AGE(), dummy_bean
									.getUI_M_EXACT_AGE(), pt_il_policy_bean
									.getPOL_DEF_PERIOD_TO(), dummy_bean
									.getUI_M_TD_MIN_RATE(), dummy_bean
									.getUI_M_TD_MAX_RATE(), pt_il_policy_bean
									.getPOL_NEW_FC_SA(), pt_il_policy_bean
									.getPOL_FC_MODAL_PREM(), null, null, null,
							null, null, null, null, null, null, null, null);

				} else if ("PG".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18"))) {

					pOrclValList = pkg_pilt002_apac.IL_SUM_ASURED_CAL_PGC(
							pt_il_policy_bean.getPOL_PROD_GROUP_CODE(),
							dummy_bean.getUI_M_PROD_PREM_TARIFF(),
							pt_il_policy_bean.getPOL_SYS_ID(),
							pt_il_policy_bean.getPOL_END_NO_IDX(),
							pt_il_policy_bean.getPOL_END_CODE(),
							pt_il_policy_bean.getPOL_END_TYPE(),
							pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
							pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
							pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
							pt_il_policy_bean.getPOL_NO_OF_UNIT(),
							pt_il_policy_bean.getPOL_NO_OF_INST(),
							pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
							pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
							dummy_bean.getUI_M_BASE_CURR(), dummy_bean
									.getUI_M_COVER_VAR_VALUE(),
							pt_il_policy_bean.getROWID(), dummy_bean
									.getUI_M_PROD_SA_FACTOR(), dummy_bean
									.getUI_M_PROD_SA_TARIFF(), dummy_bean
									.getUI_M_COVER_SA_CALC(), dummy_bean
									.getUI_M_PS_CODE(), dummy_bean
									.getUI_M_POL_PLAN_TYPE(), pt_il_policy_bean
									.getPOL_START_DT(), compositeAction
									.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_AGE(), dummy_bean
									.getUI_M_EXACT_AGE(), pt_il_policy_bean
									.getPOL_DEF_PERIOD_TO(), dummy_bean
									.getUI_M_TD_MIN_RATE(), dummy_bean
									.getUI_M_TD_MAX_RATE(), pt_il_policy_bean
									.getPOL_NEW_FC_SA(), pt_il_policy_bean
									.getPOL_FC_MODAL_PREM(), null, null, null,
							null, null, null, null, null, null, null, null);
				}
				if (!pOrclValList.isEmpty() && pOrclValList != null) {

					dummy_bean.setUI_M_TD_MIN_RATE((Double) (pOrclValList
							.get(0).getValueObject()));
					dummy_bean.setUI_M_TD_MAX_RATE((Double) (pOrclValList
							.get(1).getValueObject()));
					pt_il_policy_bean.setPOL_NEW_FC_SA((Double) (pOrclValList
							.get(2).getValueObject()));
					pt_il_policy_bean
							.setPOL_FC_MODAL_PREM((Double) (pOrclValList.get(3)
									.getValueObject()));
					pt_il_policy_bean
							.setPOL_FC_BASIC_PREM((Double) (pOrclValList.get(4)
									.getValueObject()));
					pt_il_policy_bean
							.setPOL_LC_BASIC_PREM((Double) (pOrclValList.get(5)
									.getValueObject()));
					pt_il_policy_bean
							.setPOL_FC_SUM_ASSURED((Double) (pOrclValList
									.get(6).getValueObject()));
					pt_il_policy_bean
							.setPOL_LC_SUM_ASSURED((Double) (pOrclValList
									.get(7).getValueObject()));
					pt_il_policy_bean.setPOL_FC_CURR_SA((Double) (pOrclValList
							.get(8).getValueObject()));
					pt_il_policy_bean.setPOL_LC_CURR_SA((Double) (pOrclValList
							.get(9).getValueObject()));
					pt_il_policy_bean
							.setPOL_ORG_NEW_LC_SA((Double) (pOrclValList
									.get(10).getValueObject()));
					pt_il_policy_bean
							.setPOL_ORG_NEW_FC_SA((Double) (pOrclValList
									.get(11).getValueObject()));
					pt_il_policy_bean.setPOL_NEW_LC_SA((Double) (pOrclValList
							.get(12).getValueObject()));
					pt_il_policy_bean
							.setPOL_FC_MON_ANNU_AMT((Double) (pOrclValList
									.get(13).getValueObject()));
					pt_il_policy_bean
							.setPOL_LC_MON_ANNU_AMT((Double) (pOrclValList
									.get(14).getValueObject()));
				}

			}
			/*
			 * if("U".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())){
			 * thresholdLimitAddingForUlip(pt_il_policy_bean, compositeAction,
			 * pt_il_policy_bean.getPOL_FC_SUM_ASSURED(),prevFcSA); }
			 */
			if (("NR"
					.equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18")) || CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_18") == null)
					&& "P".equals(CommonUtils.nvl(dummy_bean
							.getUI_M_COVER_SA_CALC(), "X"))) {

				pOrclValList = pkg_pilt002_apac
						.IL_SUM_ASURED_CAL(
								pt_il_policy_bean.getPOL_SYS_ID(),
								pt_il_policy_bean.getPOL_END_NO_IDX(),
								pt_il_policy_bean.getPOL_END_CODE(),
								pt_il_policy_bean.getPOL_END_TYPE(),
								pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
								pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
								pt_il_policy_bean.getPOL_SA_CURR_CODE(),
								pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
								pt_il_policy_bean.getPOL_NO_OF_UNIT(),
								pt_il_policy_bean.getPOL_NO_OF_INST(),
								pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
								pt_il_policy_bean.getPOL_PLAN_CODE(),
								pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
								pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
								dummy_bean.getUI_M_BASE_CURR(),
								dummy_bean.getUI_M_COVER_VAR_VALUE(),
								pt_il_policy_bean.getROWID(),
								dummy_bean.getUI_M_PROD_SA_FACTOR(),
								dummy_bean.getUI_M_PROD_SA_TARIFF(),
								dummy_bean.getUI_M_COVER_SA_CALC(),
								dummy_bean.getUI_M_PS_CODE(),
								dummy_bean.getUI_M_POL_PLAN_TYPE(),
								pt_il_policy_bean.getPOL_START_DT(),
								compositeAction
										.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
										.getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_AGE(), dummy_bean
										.getUI_M_EXACT_AGE(), pt_il_policy_bean
										.getPOL_DEF_PERIOD_TO(), dummy_bean
										.getUI_M_TD_MIN_RATE(), dummy_bean
										.getUI_M_TD_MAX_RATE(),
								pt_il_policy_bean.getPOL_NEW_FC_SA(),
								pt_il_policy_bean.getPOL_FC_MODAL_PREM(), null,
								null, null, null, null, null, null, null, null,
								null, null);

			} else if ("PG".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_18"))) {

				pOrclValList = pkg_pilt002_apac
						.IL_SUM_ASURED_CAL_PGC(
								pt_il_policy_bean.getPOL_PROD_GROUP_CODE(),
								dummy_bean.getUI_M_PROD_PREM_TARIFF(),
								pt_il_policy_bean.getPOL_SYS_ID(),
								pt_il_policy_bean.getPOL_END_NO_IDX(),
								pt_il_policy_bean.getPOL_END_CODE(),
								pt_il_policy_bean.getPOL_END_TYPE(),
								pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
								pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
								pt_il_policy_bean.getPOL_SA_CURR_CODE(),
								pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
								pt_il_policy_bean.getPOL_NO_OF_UNIT(),
								pt_il_policy_bean.getPOL_NO_OF_INST(),
								pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
								pt_il_policy_bean.getPOL_PLAN_CODE(),
								pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
								pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
								dummy_bean.getUI_M_BASE_CURR(),
								dummy_bean.getUI_M_COVER_VAR_VALUE(),
								pt_il_policy_bean.getROWID(),
								dummy_bean.getUI_M_PROD_SA_FACTOR(),
								dummy_bean.getUI_M_PROD_SA_TARIFF(),
								dummy_bean.getUI_M_COVER_SA_CALC(),
								dummy_bean.getUI_M_PS_CODE(),
								dummy_bean.getUI_M_POL_PLAN_TYPE(),
								pt_il_policy_bean.getPOL_START_DT(),
								compositeAction
										.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
										.getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_AGE(), dummy_bean
										.getUI_M_EXACT_AGE(), pt_il_policy_bean
										.getPOL_DEF_PERIOD_TO(), dummy_bean
										.getUI_M_TD_MIN_RATE(), dummy_bean
										.getUI_M_TD_MAX_RATE(),
								pt_il_policy_bean.getPOL_NEW_FC_SA(),
								pt_il_policy_bean.getPOL_FC_MODAL_PREM(), null,
								null, null, null, null, null, null, null, null,
								null, null);
			}
			if (!pOrclValList.isEmpty() && pOrclValList != null) {

				dummy_bean.setUI_M_TD_MIN_RATE((Double) (pOrclValList.get(0)
						.getValueObject()));
				dummy_bean.setUI_M_TD_MAX_RATE((Double) (pOrclValList.get(1)
						.getValueObject()));
				pt_il_policy_bean.setPOL_NEW_FC_SA((Double) (pOrclValList
						.get(2).getValueObject()));
				pt_il_policy_bean.setPOL_FC_MODAL_PREM((Double) (pOrclValList
						.get(3).getValueObject()));
				pt_il_policy_bean.setPOL_FC_BASIC_PREM((Double) (pOrclValList
						.get(4).getValueObject()));
				pt_il_policy_bean.setPOL_LC_BASIC_PREM((Double) (pOrclValList
						.get(5).getValueObject()));
				pt_il_policy_bean.setPOL_FC_SUM_ASSURED((Double) (pOrclValList
						.get(6).getValueObject()));
				pt_il_policy_bean.setPOL_LC_SUM_ASSURED((Double) (pOrclValList
						.get(7).getValueObject()));
				pt_il_policy_bean.setPOL_FC_CURR_SA((Double) (pOrclValList
						.get(8).getValueObject()));
				pt_il_policy_bean.setPOL_LC_CURR_SA((Double) (pOrclValList
						.get(9).getValueObject()));
				pt_il_policy_bean.setPOL_ORG_NEW_LC_SA((Double) (pOrclValList
						.get(10).getValueObject()));
				pt_il_policy_bean.setPOL_ORG_NEW_FC_SA((Double) (pOrclValList
						.get(11).getValueObject()));
				pt_il_policy_bean.setPOL_NEW_LC_SA((Double) (pOrclValList
						.get(12).getValueObject()));
				pt_il_policy_bean.setPOL_FC_MON_ANNU_AMT((Double) (pOrclValList
						.get(13).getValueObject()));
				pt_il_policy_bean.setPOL_LC_MON_ANNU_AMT((Double) (pOrclValList
						.get(14).getValueObject()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return currValue;
	}

	public Double POL_NO_OF_UNIT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		String query4 = " SELECT COVER_SA_CALC,COVER_MIN_UNIT,COVER_MAX_UNIT  FROM  PM_IL_COVER  WHERE COVER_CODE= ? ";
		String query5 = "select NVL(COVER_MIN_SA,0),NVL(COVER_MAX_SA,0) FROM  PM_IL_COVER  WHERE COVER_CODE= ? ";
		String query1 = "   SELECT PLAN_MIN_SA, PLAN_MAX_SA  FROM   PM_IL_PLAN  WHERE  PLAN_CODE = ? ";
		String query1_PGC = "   SELECT  PROD_MIN_SA ,PROD_MAX_SA   FROM    PM_IL_PRODUCT"
				+ "   WHERE   PROD_CODE = (SELECT PGD_PROD_CODE  FROM   PM_IL_PROD_GROUP_DTL"
				+ "  WHERE  PGD_GROUP_CODE   = ? "
				+ "   AND    PGD_MAIN_PROD_YN = 'Y')";

		String query2 = "SELECT PS_CODE  FROM   PP_SYSTEM  WHERE  PS_TYPE = ? ";
		String query3 = " SELECT POL_FC_SUM_ASSURED,POL_ORG_FC_SUM_ASSURED  FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
		String M_COVER_SA_CALC = null;
		Double M_DUMMY_MIN = 0.0;
		Double M_DUMMY_MAX = 0.0;
		Double M_PLAN_MIN_SA = 0.0;
		Double M_PLAN_MAX_SA = 0.0;
		Double M_POL_FC_SUM_ASSURED = 0.0;
		String M_PS_CODE = null;
		String M_CHECK_FC_SA = null;
		String M_CH_FC_SA = null;
		Double M_FC_SUM_ASSURED = 0.0;
		Double M_ORG_FC_SUM_ASSURED = 0.0;
		Double M_CVR_MIN_SA = 0.0;
		Double M_CVR_MAX_SA = 0.0;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();

		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = null;
		Double prevFcSA = pt_il_policy_bean.getPOL_FC_SUM_ASSURED();
		try {
			connection = CommonUtils.getConnection();
			if (!"G".equals(CommonUtils.nvl(dummy_bean.getUI_M_COVER_SA_CALC(),
					"X"))) {
				if (!"F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
					if (!"007".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_END_TYPE(), "000"))) {
						if (!"016".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_TYPE(), "000"))) {
							if (!(currValue
									.equals(CommonUtils.nvl(pt_il_policy_bean
											.getPOL_NO_OF_UNIT(), 0.0)))) {

								pValList = new ArrayList<OracleParameter>();
								pValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL(
												pt_il_policy_bean
														.getPOL_SYS_ID(),
												pt_il_policy_bean
														.getPOL_END_NO_IDX(),
												pt_il_policy_bean
														.getPOL_END_CODE(),
												pt_il_policy_bean
														.getPOL_END_TYPE(),
												pt_il_policy_bean
														.getPOL_PREM_PAY_YRS(),
												pt_il_policy_bean
														.getPOL_ORG_NO_OF_INST(),
												pt_il_policy_bean
														.getPOL_SA_CURR_CODE(),
												pt_il_policy_bean
														.getPOL_SA_EXCH_RATE(),
												currValue,
												pt_il_policy_bean
														.getPOL_NO_OF_INST(),
												pt_il_policy_bean
														.getPOL_ORG_FC_SUM_ASSURED(),
												pt_il_policy_bean
														.getPOL_PLAN_CODE(),
												pt_il_pol_assured_dtls_bean
														.getPOAD_SYS_ID(),
												pt_il_policy_bean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummy_bean.getUI_M_BASE_CURR(),
												dummy_bean
														.getUI_M_COVER_VAR_VALUE(),
												pt_il_policy_bean.getROWID(),
												dummy_bean
														.getUI_M_PROD_SA_FACTOR(),
												dummy_bean
														.getUI_M_PROD_SA_TARIFF(),
												dummy_bean
														.getUI_M_COVER_SA_CALC(),
												dummy_bean.getUI_M_PS_CODE(),
												dummy_bean
														.getUI_M_POL_PLAN_TYPE(),
												pt_il_policy_bean
														.getPOL_START_DT(),
												compositeAction
														.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
														.getPT_IL_POL_ASSURED_DTLS_BEAN()
														.getPOAD_AGE(),
												dummy_bean.getUI_M_EXACT_AGE(),
												pt_il_policy_bean
														.getPOL_DEF_PERIOD_TO(),
												dummy_bean
														.getUI_M_TD_MIN_RATE(),
												dummy_bean
														.getUI_M_TD_MAX_RATE(),
												pt_il_policy_bean
														.getPOL_NEW_FC_SA(),
												pt_il_policy_bean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);
								if (pValList != null && !pValList.isEmpty()) {

									dummy_bean
											.setUI_M_TD_MIN_RATE((Double) (pValList
													.get(0).getValueObject()));
									dummy_bean
											.setUI_M_TD_MAX_RATE((Double) (pValList
													.get(1).getValueObject()));
									pt_il_policy_bean
											.setPOL_NEW_FC_SA((Double) (pValList
													.get(2).getValueObject()));
									pt_il_policy_bean
											.setPOL_FC_MODAL_PREM((Double) (pValList
													.get(3).getValueObject()));
									pt_il_policy_bean
											.setPOL_FC_BASIC_PREM((Double) (pValList
													.get(4).getValueObject()));
									pt_il_policy_bean
											.setPOL_LC_BASIC_PREM((Double) (pValList
													.get(5).getValueObject()));
									pt_il_policy_bean
											.setPOL_FC_SUM_ASSURED((Double) (pValList
													.get(6).getValueObject()));
									pt_il_policy_bean
											.setPOL_LC_SUM_ASSURED((Double) (pValList
													.get(7).getValueObject()));
									pt_il_policy_bean
											.setPOL_FC_CURR_SA((Double) (pValList
													.get(8).getValueObject()));
									pt_il_policy_bean
											.setPOL_LC_CURR_SA((Double) (pValList
													.get(9).getValueObject()));
									pt_il_policy_bean
											.setPOL_ORG_NEW_LC_SA((Double) (pValList
													.get(10).getValueObject()));
									pt_il_policy_bean
											.setPOL_ORG_NEW_FC_SA((Double) (pValList
													.get(11).getValueObject()));
									pt_il_policy_bean
											.setPOL_NEW_LC_SA((Double) (pValList
													.get(12).getValueObject()));
									pt_il_policy_bean
											.setPOL_FC_MON_ANNU_AMT((Double) (pValList
													.get(13).getValueObject()));
									pt_il_policy_bean
											.setPOL_LC_MON_ANNU_AMT((Double) (pValList
													.get(14).getValueObject()));
								}
							}
						}
					}
				} else if ("F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {

					pValList = new ArrayList<OracleParameter>();
					pValList = pkg_pilt002_apac.IL_CALC_SA_FACT_VALID(
							pt_il_policy_bean.getPOL_SYS_ID(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_END_TYPE(),
							pt_il_policy_bean.getROWID(), dummy_bean
									.getUI_M_PROD_SA_FACTOR(),
							pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
							pt_il_policy_bean.getPOL_FC_MODAL_PREM(),
							pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
							pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
							pt_il_policy_bean.getPOL_ORG_NO_OF_UNIT(),
							dummy_bean.getUI_M_PLAN_CALC_TYPE(),
							pt_il_policy_bean.getPOL_SA_CURR_CODE(),
							pt_il_policy_bean.getPOL_NO_OF_INST(),
							pt_il_policy_bean.getPOL_PROD_CODE(),
							pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
							pt_il_policy_bean.getPOL_SA_EXCH_RATE(), currValue,
							pt_il_policy_bean.getPOL_NEW_FC_SA(),
							pt_il_policy_bean.getPOL_NEW_LC_SA(),
							pt_il_policy_bean.getPOL_ORG_NEW_FC_SA(),
							pt_il_policy_bean.getPOL_ORG_NEW_LC_SA(),
							pt_il_policy_bean.getPOL_FC_SUM_ASSURED(),
							pt_il_policy_bean.getPOL_LC_SUM_ASSURED());

					if (pValList != null && !pValList.isEmpty()) {
						if (pValList.get(0) != null) {
							currValue = (Double) pValList.get(0)
									.getValueObject();
						}
						if (pValList.get(1) != null) {
							pt_il_policy_bean
									.setPOL_NEW_FC_SA((Double) pValList.get(1)
											.getValueObject());
						}
						if (pValList.get(2) != null) {
							pt_il_policy_bean
									.setPOL_NEW_LC_SA((Double) pValList.get(2)
											.getValueObject());
						}
						if (pValList.get(3) != null) {
							pt_il_policy_bean
									.setPOL_ORG_NEW_FC_SA((Double) pValList
											.get(3).getValueObject());
						}
						if (pValList.get(4) != null) {
							pt_il_policy_bean
									.setPOL_ORG_NEW_LC_SA((Double) pValList
											.get(4).getValueObject());
						}
						if (pValList.get(5).getValueObject() != null) {
							Double M_FC_SA = (Double) pValList.get(5)
									.getValueObject();
							Object[] value = new Object[] { pt_il_policy_bean
									.getPOL_PLAN_CODE() };
							rs = handler.executeSelectStatement(query5,
									connection, value);
							while (rs.next()) {
								M_CVR_MIN_SA = rs.getDouble(1);
								M_CVR_MAX_SA = rs.getDouble(2);
							}
							/*
							 * CommonUtils.setGlobalVariable("M_FC_SA",
							 * M_FC_SA.toString());
							 * CommonUtils.setGlobalVariable("M_CVR_MIN_SA",
							 * M_CVR_MIN_SA.toString());
							 * CommonUtils.setGlobalVariable("M_CVR_MAX_SA",
							 * M_CVR_MAX_SA.toString());
							 */
							/*Modified  by saranya*/
							CommonUtils.setGlobalObject("M_FC_SA", M_FC_SA==null?0.0:M_FC_SA);
							CommonUtils.setGlobalObject("M_CVR_MIN_SA",
									M_CVR_MIN_SA);
							CommonUtils.setGlobalObject("M_CVR_MAX_SA",
									M_CVR_MAX_SA);
							CommonUtils.closeCursor(rs);
							if (!("002".equalsIgnoreCase(pt_il_policy_bean
									.getPOL_END_TYPE()))) {
								if ((M_FC_SA < M_CVR_MIN_SA)
										|| (M_FC_SA > M_CVR_MAX_SA)) {
									String cvr_max_sa = (BigDecimal
											.valueOf(M_CVR_MAX_SA)
											.toPlainString());
									
									/*Commented by saranya nas per the Girish Suggessted for Unit link product on 13-02-2017*/
									/*throw new Exception(
											" Sum Assured Should be between "
													+ M_CVR_MIN_SA + " and "
													+ cvr_max_sa);*/
								}
							} else {
								pt_il_policy_bean
										.setPOL_FC_SUM_ASSURED((Double) pValList
												.get(5).getValueObject());

							}
						}

						if (pValList.get(6) != null) {
							pt_il_policy_bean
									.setPOL_LC_SUM_ASSURED((Double) pValList
											.get(6).getValueObject());
						}
					}
				}
			}
			pt_il_policy_bean.setPOL_NO_OF_UNIT(currValue);
			values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
			rs = handler.executeSelectStatement(query4, connection, values);
			while (rs.next()) {
				M_COVER_SA_CALC = rs.getString(1);
				M_DUMMY_MIN = rs.getDouble(2);
				M_DUMMY_MAX = rs.getDouble(3);
			}
			CommonUtils.closeCursor(rs);

			if ("U".equals(M_COVER_SA_CALC)) {
				Double M_TEMP = CommonUtils.nvl(currValue, 0.0)
						+ CommonUtils.nvl(pt_il_policy_bean
								.getPOL_ORG_NO_OF_UNIT(), 0.0);
				if (!(M_TEMP > M_DUMMY_MIN && M_TEMP < M_DUMMY_MAX)) {
					if ("000".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))
							|| "002".equals(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_END_TYPE(), "000"))) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91014",
								new Object[] {
										"Cover Unit",
										"Between Units " + M_DUMMY_MIN
												+ " and " + M_DUMMY_MAX }));
					}
				}
				// 'NR' for normal and 'PG' for package policy using menu
				// parameter_18

				if ("NR".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18"))
						|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18") == null) {
					values = new Object[] { pt_il_policy_bean
							.getPOL_PLAN_CODE() };
					rs = handler.executeSelectStatement(query1, connection,
							values);

				} else if ("PG".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
					values = new Object[] { pt_il_policy_bean
							.getPOL_PROD_GROUP_CODE() };
					rs = handler.executeSelectStatement(query1_PGC, connection,
							values);
				}

				while (rs.next()) {
					M_PLAN_MIN_SA = rs.getDouble(1);
					M_PLAN_MAX_SA = rs.getDouble(2);
				}
				CommonUtils.closeCursor(rs);
				values = new Object[] { "IL_OCC_CHG" };
				rs = handler.executeSelectStatement(query2, connection, values);
				while (rs.next()) {
					M_PS_CODE = rs.getString(1);
				}
				CommonUtils.closeCursor(rs);
				values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
				rs = handler.executeSelectStatement(query3, connection, values);
				while (rs.next()) {
					M_FC_SUM_ASSURED = rs.getDouble(1);
					M_ORG_FC_SUM_ASSURED = rs.getDouble(2);
				}
				CommonUtils.closeCursor(rs);

				if ((!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE()) || !"S"
						.equals(dummy_bean.getUI_M_POL_PLAN_TYPE()))
						&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(),
								"XXX").equals(
								CommonUtils.nvl(pt_il_policy_bean
										.getPOL_END_CODE(), "000")) || !CommonUtils
								.nvl(M_PS_CODE, "XXX").equals(
										CommonUtils.nvl(pt_il_policy_bean
												.getPOL_END_CODE(), "000")))
						&& !"Q".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_PROP_QUOT_FLAG(), "N"))
						&& "007".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_TYPE(), "000"))) {
					if ((CommonUtils.nvl(pt_il_policy_bean
							.getPOL_FC_SUM_ASSURED(), 0.0) + CommonUtils.nvl(
							pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(), 0.0)) <= 0.0) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71043"));
					} else {
						M_POL_FC_SUM_ASSURED = CommonUtils.nvl(
								pt_il_policy_bean.getPOL_FC_SUM_ASSURED(), 0.0)
								+ CommonUtils.nvl(pt_il_policy_bean
										.getPOL_ORG_FC_SUM_ASSURED(), 0.0);
						if (CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) < CommonUtils
								.nvl(M_PLAN_MIN_SA, 0.0)
								|| CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) > CommonUtils
										.nvl(M_PLAN_MAX_SA, 0.0)) {
							String plan_max_sa = (BigDecimal
									.valueOf(M_PLAN_MAX_SA).toPlainString());
							throw new Exception(
									Messages
											.getString(
													PELConstants.pelErrorMessagePath,
													"3206",
													new Object[] { M_PLAN_MIN_SA
															+ " and Sum Assured Should be between "
															+ plan_max_sa }));
						}
					}
				}

				pkg_pilt002_apac.L_CHECK_MULTIPLE_SA("B", CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						pt_il_policy_bean.getPOL_PLAN_CODE(), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_SUM_ASSURED()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ORG_LC_SUM_ASSURED()));
			}
			/*
			 * if("U".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())){
			 * thresholdLimitAddingForUlip(pt_il_policy_bean, compositeAction,
			 * pt_il_policy_bean.getPOL_FC_SUM_ASSURED(),prevFcSA); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
		return currValue;

	}

	public void POL_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		ArrayList<String> pValListStr = new ArrayList<String>();
		String query1 = "   SELECT PLAN_MIN_SA, PLAN_MAX_SA  FROM  PM_IL_PLAN WHERE  PLAN_CODE = ? ";
		String query1_PGC = "  SELECT  PROD_MIN_SA ,PROD_MAX_SA  FROM    PM_IL_PRODUCT"
				+ "   WHERE   PROD_CODE = (SELECT PGD_PROD_CODE  FROM   PM_IL_PROD_GROUP_DTL"
				+ "  WHERE  PGD_GROUP_CODE   = ? AND  PGD_MAIN_PROD_YN = 'Y') ";
		String query2 = "  SELECT PS_CODE   FROM   PP_SYSTEM  WHERE  PS_TYPE =? ";
		String query3 = "  SELECT POL_FC_SUM_ASSURED,POL_ORG_FC_SUM_ASSURED FROM PT_IL_POLICY  WHERE POL_SYS_ID = ? ";
		String query4 = " SELECT NVL(COVER_MIN_SA,0),NVL(COVER_MAX_SA,0) FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		String del_end = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_DEL_RIDER'";
		/*Added by ganesh on 10-08-2017, to avoid cover SA getting zero(0) suggested by Ajoy*/
		String endoParamQuery = "SELECT NVL(PARA_VALUE, 0) FROM PCOM_APP_PARAMETER WHERE PARA_CODE = 'IL_END_LOGIC' AND PARA_SUB_CODE = 'IL_END_LOGIC'";
		/*end*/
		Double M_COVER_MIN_SA = 0.0;
		Double M_COVER_MAX_SA = 0.0;
		Double M_TEMP_COVER_SA = 0.0;
		Double M_PLAN_MIN_SA = 0.0;
		Double M_PLAN_MAX_SA = 0.0;
		Double M_POL_FC_SUM_ASSURED = 0.0;
		String M_PS_CODE = null;
		Double M_CHECK_FC_SA = 0.0;
		Double M_CH_FC_SA = 0.0;
		Double M_FC_SUM_ASSURED = null;
		Double M_ORG_FC_SUM_ASSURED = 0.0;
		ResultSet rs10 = null;
		String del_end_code = null;
		ResultSet rsdel_end = null;
		/*Added by saritha on 10-04-2018 for KIC Proposal(Golda) 
		 * Deposit amount validation is not applicable in case the currency os sum assured is Gold pound*/
		ResultSet resultMinMaxSA = null;
		Double M_POL_LC_SUM_ASSURED = 0.0;
		/*End*/
		
		
		/*Added by Janani on 09.05.2018 for Fidelity SA zero validation at the 
		 * time of proposal creation for BEnefit to premium issue*/

		BigDecimal SA_zero_validation = null;
		
		/*End*/
		
		/*Added by Janani on 11.07.2018 for FLALIFEQC-1756799 */
		ArrayList<OracleParameter> pValList_sa = new ArrayList<OracleParameter>();
		String SA_check = null;
        /*End*/
		
		try {

			connection = CommonUtils.getConnection();
			rsdel_end = handler.executeSelectStatement(del_end, connection);
			if (rsdel_end.next()) {
				del_end_code = rsdel_end.getString(1);
			}
			pt_il_policy_bean.setPOL_FC_SUM_ASSURED(currValue);
			dummy_bean.setUI_M_CHANGE_SA_YN("N");

			/*Moved by dhinesh on 10-04-2017 */
			ResultSet rsEndo=new CRUDHandler().executeSelectStatement(endoParamQuery, CommonUtils.getConnection());
			String endoParamValue = null;
			if(rsEndo.next()){
				endoParamValue = rsEndo.getString(1);
			}
			/*end*/
			M_POL_LC_SUM_ASSURED = pt_il_policy_bean.getPOL_LC_SUM_ASSURED();
			
			// 'NR' for normal and 'PG' for package policy using menu
			// parameter_18
			if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))
					|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18") == null) {
				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
				rs = handler.executeSelectStatement(query1, connection, values);
			} else if ("PG".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				values = new Object[] { pt_il_policy_bean
						.getPOL_PROD_GROUP_CODE() };
				rs = handler.executeSelectStatement(query1_PGC, connection,
						values);
			}
			while (rs.next()) {
				M_PLAN_MIN_SA = rs.getDouble(1);
				M_PLAN_MAX_SA = rs.getDouble(2);
			}

			CommonUtils.closeCursor(rs);
			values = new Object[] { "IL_OCC_CHG" };
			rs = handler.executeSelectStatement(query2, connection, values);
			while (rs.next()) {
				M_PS_CODE = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs = handler.executeSelectStatement(query3, connection, values);
			while (rs.next()) {
				M_FC_SUM_ASSURED = rs.getDouble(1);
				M_ORG_FC_SUM_ASSURED = rs.getDouble(2);
			}
			CommonUtils.closeCursor(rs);

			if ((!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE()) || (!"S"
					.equals(dummy_bean.getUI_M_POL_PLAN_TYPE())))
					&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(), "XXX")
							.equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_END_CODE(), "000")) || !CommonUtils
							.nvl(M_PS_CODE, "XXX").equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_END_CODE(), "000")))
					&& !"Q".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_QUOT_FLAG(), "N"))
					&& !"007".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))
					&& !"F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {

				if ((CommonUtils.nvl(currValue, 0.0) + CommonUtils.nvl(
						pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(), 0.0)) <= 0.0   && !"L".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
					throw new Exception("Fc Sum Assured : "
							+ Messages.getString(
									PELConstants.pelErrorMessagePath, "71043"));
				} else {
					/*
					 * commented By Dhinesh on 4-10-2017
					 * M_POL_FC_SUM_ASSURED = CommonUtils.nvl(currValue, 0)
							+ CommonUtils.nvl(pt_il_policy_bean
									.getPOL_ORG_FC_SUM_ASSURED(), 0);*/
					
				/* Modified By Dhinesh on 4-10-2017 */
					if(endoParamValue!=null && endoParamValue.equals("2"))
					{
						M_POL_FC_SUM_ASSURED = CommonUtils.nvl(currValue, 0);
					}else
					{
						M_POL_FC_SUM_ASSURED = CommonUtils.nvl(currValue, 0)
								+ CommonUtils.nvl(pt_il_policy_bean
										.getPOL_ORG_FC_SUM_ASSURED(), 0);
					}
					
					/* End */
					
					if ((CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) < CommonUtils
							.nvl(M_PLAN_MIN_SA, 0.0))
							|| (CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) > CommonUtils
									.nvl(M_PLAN_MAX_SA, 0))) {

						String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
								.toPlainString());
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"3206",
												new Object[] { " Sum Assured Should be between "
														+ M_PLAN_MIN_SA
														+ " and " + plan_max_sa }));
					}
				}
			}
			
			/*Added by ganesh on 09-11-2017 for 215 product not showing sum assured validation */
			if ("F".equals(dummy_bean.getUI_M_COVER_SA_CALC()) && "A".equalsIgnoreCase(pt_il_policy_bean.getPOL_UL_PREM_CALC())) {
				
				if ((CommonUtils.nvl(currValue, 0.0) + CommonUtils.nvl(
						pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(), 0.0)) == 0.0
						&& !"L".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
					throw new Exception("Fc Sum Assured : "
							+ Messages.getString(
									PELConstants.pelErrorMessagePath, "71043"));
				}
				
				/*Added by Janani on 11.07.2018 for FLALIFEQC-1756799 */
				
				
				/*if ((CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) < CommonUtils
						.nvl(M_PLAN_MIN_SA, 0.0))
						|| (CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) > CommonUtils
								.nvl(M_PLAN_MAX_SA, 0))) {

					String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
							.toPlainString());
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { " Sum Assured Should be between "
													+ M_PLAN_MIN_SA
													+ " and " + plan_max_sa }));
				}*/
				
				System.out.println("getPOL_FC_SUM_ASSURED             "+pt_il_policy_bean.getPOL_FC_SUM_ASSURED()
						+"  getPOL_SA_CURR_CODE  "+pt_il_policy_bean.getPOL_SA_CURR_CODE()+"     getPOL_CUST_CURR_CODE  "
						+pt_il_policy_bean.getPOL_CUST_CURR_CODE()+"   getPOL_SA_EXCH_RATE   "+pt_il_policy_bean.getPOL_SA_EXCH_RATE());
				
				
			if(pt_il_policy_bean.getPOL_CUST_CURR_CODE() == pt_il_policy_bean.getPOL_SA_CURR_CODE())
			{
				pt_il_policy_bean.setPOL_LC_SUM_ASSURED(pt_il_policy_bean.getPOL_FC_SUM_ASSURED());
			}else
			{
				pt_il_policy_bean.setPOL_LC_SUM_ASSURED(
						pt_il_policy_bean.getPOL_FC_SUM_ASSURED() * pt_il_policy_bean.getPOL_SA_EXCH_RATE());
			}
					
			System.out.println("getPOL_LC_SUM_ASSURED           "+pt_il_policy_bean.getPOL_LC_SUM_ASSURED());
			
					   
				pValList_sa = new PKG_PILT002_APAC().P_MIN_MAX_SA_VALID(
						CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_FC_SUM_ASSURED()),
						pt_il_policy_bean.getPOL_PLAN_CODE(), 
						null);
			
				if (!pValList_sa.isEmpty()) {
					SA_check = pValList_sa.get(0).getValue();
				}

				if(SA_check.equalsIgnoreCase("y"))
				{
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { " Sum Assured Should be between "
													+ M_PLAN_MIN_SA
													+ " and " + M_PLAN_MAX_SA }));
				}
				
				
				
				/*End of FLALIFEQC-1756799 */
				
			}
			/*end*/
			
			/*Added by Janani on 09.05.2018 for Fidelity SA zero validation at the 
			 * time of proposal creation for BEnefit to premium issue*/
			
			//SA_zero_validation = (BigDecimal)CommonUtils.getPPSystemParameterValue("IL_SA_ZERO");
			
			/*End*/
			
						
			/*Modifed !Q and !F by ganesh on 06-04-2018 as suggested by chandramohan*/
			/*if ((!("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) || !("S"
					.equals(dummy_bean.getUI_M_POL_PLAN_TYPE())))
					&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(), "XXX")
							.equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_PROP_END_CODE(), "000")) || !CommonUtils
							.nvl(M_PS_CODE, "XXX").equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_PROP_END_CODE(), "000")))
					&& ((SA_zero_validation.intValue() == 1 && "Q".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_QUOT_FLAG(), "P"))) || (SA_zero_validation.intValue() != 1 && !"Q".equals(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_PROP_QUOT_FLAG(), "P"))))
					&& !"F".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_QUOT_FLAG(), "P")))*/
			
			
			/*Modified !Q to Q as discussed with Ajay for fidelity on 14.05.2015*/
			
			if ((!("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) || !("S"
					.equals(dummy_bean.getUI_M_POL_PLAN_TYPE())))
					&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(), "XXX")
							.equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_PROP_END_CODE(), "000")) || !CommonUtils
							.nvl(M_PS_CODE, "XXX").equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_PROP_END_CODE(), "000")))
					&& "Q".equals(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_PROP_QUOT_FLAG(), "P"))
					&& !"F".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_QUOT_FLAG(), "P")))
				
				/*End*/
			
			{

				if ((CommonUtils.nvl(currValue, 0.0) + CommonUtils.nvl(
						pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(), 0.0)) <= 0.0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71043"));
				} else {
					M_POL_FC_SUM_ASSURED = CommonUtils.nvl(currValue, 0)
							+ CommonUtils.nvl(pt_il_policy_bean
									.getPOL_ORG_FC_SUM_ASSURED(), 0);
					/*Added by Ameen on 11-04-2018 for KIC*/
					M_POL_LC_SUM_ASSURED = M_POL_FC_SUM_ASSURED* pt_il_policy_bean.getPOL_SA_EXCH_RATE();
					pt_il_policy_bean.setPOL_LC_SUM_ASSURED(M_POL_LC_SUM_ASSURED);
					/*End*/
					
					/*Commentted &Modified by saritha on 10-04-2018 for KIC Proposal(Golda) 
					 * Deposit amount validation is not applicable in case the currency os sum assured is Gold pound*/
					
					/*if ((CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) < CommonUtils
							.nvl(M_PLAN_MIN_SA, 0.0))
							|| (CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) > CommonUtils
									.nvl(M_PLAN_MAX_SA, 0))) {
						String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
								.toPlainString());
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"3206",
												new Object[] { " Sum Assured Should be between "
														+ M_PLAN_MIN_SA
														+ " and " + plan_max_sa }));
					}*/
					
					values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
					resultMinMaxSA = new CRUDHandler().executeSelectStatement(query4, connection, values);
					while (resultMinMaxSA.next()) {
						M_COVER_MIN_SA = resultMinMaxSA.getDouble(1);
						M_COVER_MAX_SA = resultMinMaxSA.getDouble(2);
					}

					if(pt_il_policy_bean.getPOL_SA_CURR_CODE().equalsIgnoreCase(pt_il_policy_bean.getPOL_CUST_CURR_CODE())){

						if ((CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) < CommonUtils
								.nvl(M_PLAN_MIN_SA, 0.0))
								|| (CommonUtils.nvl(M_POL_FC_SUM_ASSURED, 0.0) > CommonUtils
										.nvl(M_PLAN_MAX_SA, 0))) {
							String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
									.toPlainString());
							throw new Exception(
									Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { " Sum Assured Should be between "
													+ M_PLAN_MIN_SA
													+ " and " + plan_max_sa }));
						}

					}else{

						if ((CommonUtils.nvl(M_POL_LC_SUM_ASSURED, 0.0) < CommonUtils
								.nvl(M_COVER_MIN_SA, 0.0))
								|| (CommonUtils.nvl(M_POL_LC_SUM_ASSURED, 0.0) > CommonUtils
										.nvl(M_COVER_MAX_SA, 0))) {
							String cover_max_sa = (BigDecimal.valueOf(M_COVER_MAX_SA)
									.toPlainString());
							throw new Exception(
									Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { " LC Sum Assured Should be between "
													+ M_COVER_MIN_SA
													+ " and " + cover_max_sa }));


						}

					}

					/*End*/	
				}
			}

			if (M_FC_SUM_ASSURED != currValue) {
				CommonUtils.setGlobalVariable("GLOBAL.M_LC_CHECK", "Y");
			} else {
				CommonUtils.setGlobalVariable("GLOBAL.M_LC_CHECK", "N");
			}
			pValListStr = new ArrayList<String>();
			pValListStr = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), CommonUtils
					.getProcedureValue(currValue), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());

			if (!pValListStr.isEmpty() && pValListStr != null) {
				if (pValListStr.get(0) != null) {
					currValue = Double.parseDouble(pValListStr.get(0));
				}
			}

			if (currValue != null) {
				pt_il_policy_bean.setPOL_FC_CURR_SA(currValue);
				pt_il_policy_bean.setPOL_LC_SUM_ASSURED(currValue
						* pt_il_policy_bean.getPOL_SA_EXCH_RATE());
			}

			pValListStr = new ArrayList<String>();
			pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_LC_SUM_ASSURED()), "R", pt_il_policy_bean
							.getPOL_PROD_CODE());
			if (pValListStr != null && !pValListStr.isEmpty()) {
				if (pValListStr.get(0) != null) {
					pt_il_policy_bean.setPOL_LC_SUM_ASSURED(Double
							.parseDouble(pValListStr.get(0)));
				}
			}

			pt_il_policy_bean.setPOL_LC_CURR_SA(pt_il_policy_bean
					.getPOL_LC_SUM_ASSURED());

			if ("N".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
				pt_il_policy_bean.setPOL_NEW_FC_SA(currValue);
				pt_il_policy_bean.setPOL_NEW_LC_SA(pt_il_policy_bean
						.getPOL_LC_SUM_ASSURED());
			}

			if (!("Q".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_PROP_QUOT_FLAG(), "N")))
					&& (!"F".equals(dummy_bean.getUI_M_COVER_SA_CALC()))) {

				if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID() != null) {

					pValListStr = new ArrayList<String>();
					pValListStr = pkg_pilt002_apac.IL_CALC_SA_VALID(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(pt_il_pol_assured_dtls_bean
									.getPOAD_SYS_ID()), pt_il_policy_bean
							.getPOL_END_TYPE(), pt_il_policy_bean
							.getPOL_PLAN_CODE(), dummy_bean
							.getUI_M_PROD_SA_FACTOR(), dummy_bean
							.getUI_M_COVER_SA_CALC(), pt_il_policy_bean
							.getPOL_SA_CURR_CODE(), dummy_bean
							.getUI_M_PROD_SA_TARIFF(), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_FC_MODAL_PREM()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_NO_OF_INST()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_FC_SUM_ASSURED()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_ORG_FC_SUM_ASSURED()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_ORG_FC_MODAL_PREM()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_ORG_NO_OF_INST()));
				}
			}

			if (!"F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
				pkg_pilt002_apac.L_CHECK_MULTIPLE_SA("B", CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						pt_il_policy_bean.getPOL_PLAN_CODE(), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_SUM_ASSURED()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ORG_LC_SUM_ASSURED()));
			}

			CommonUtils.setGlobalVariable("GLOBAL.M_GRP_THRESHOLD", "Y");
			CommonUtils.setGlobalVariable("GLOBAL.M_AGENT_RATE", "N");

			if ("E".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {

				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
				rs = handler.executeSelectStatement(query4, connection, values);
				while (rs.next()) {
					M_COVER_MIN_SA = rs.getDouble(1);
					M_COVER_MAX_SA = rs.getDouble(2);
				}

				M_TEMP_COVER_SA = (CommonUtils.nvl(currValue, 0.0) + CommonUtils
						.nvl(pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(), 0.0));

				if ((M_TEMP_COVER_SA < M_COVER_MIN_SA)
						|| (M_TEMP_COVER_SA > M_COVER_MAX_SA)) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { " Sum Assured Should be between "
													+ M_COVER_MIN_SA
													+ " and "
													+ M_COVER_MAX_SA
													+ " for Cover SA Calc. Type SA By Parts " }));
				}
			}

			if ("Y".equals(CommonUtils.nvl(dummy_bean.getUI_M_PLAN_CALC_TYPE(),
					"N"))
					&& "F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {

				pValList = new ArrayList<OracleParameter>();

				pValList = pkg_pilt002_apac.IL_CALC_SA_FACT_VALID(
						pt_il_policy_bean.getPOL_SYS_ID(), pt_il_policy_bean
								.getPOL_PLAN_CODE(), pt_il_policy_bean
								.getPOL_END_TYPE(), pt_il_policy_bean
								.getROWID(), dummy_bean
								.getUI_M_PROD_SA_TARIFF(),
						pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
						pt_il_policy_bean.getPOL_FC_MODAL_PREM(),
						pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
						pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
						pt_il_policy_bean.getPOL_ORG_NO_OF_UNIT(), dummy_bean
								.getUI_M_PLAN_CALC_TYPE(), pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), pt_il_policy_bean
								.getPOL_NO_OF_INST(), pt_il_policy_bean
								.getPOL_PROD_CODE(), pt_il_policy_bean
								.getPOL_ORG_FC_SUM_ASSURED(), pt_il_policy_bean
								.getPOL_SA_EXCH_RATE(), pt_il_policy_bean
								.getPOL_NO_OF_UNIT(), pt_il_policy_bean
								.getPOL_NEW_FC_SA(), pt_il_policy_bean
								.getPOL_NEW_LC_SA(), pt_il_policy_bean
								.getPOL_ORG_NEW_FC_SA(), pt_il_policy_bean
								.getPOL_ORG_NEW_LC_SA(), pt_il_policy_bean
								.getPOL_FC_SUM_ASSURED(), pt_il_policy_bean
								.getPOL_LC_SUM_ASSURED());

				if (pValList != null && !pValList.isEmpty()) {
					if (pValList.get(0) != null) {
						pt_il_policy_bean.setPOL_NO_OF_UNIT((Double) pValList
								.get(0).getValueObject());
					}
					if (pValList.get(1) != null) {
						pt_il_policy_bean.setPOL_NEW_FC_SA((Double) pValList
								.get(1).getValueObject());
					}
					if (pValList.get(2) != null) {
						pt_il_policy_bean.setPOL_NEW_LC_SA((Double) pValList
								.get(2).getValueObject());
					}
					if (pValList.get(3) != null) {
						pt_il_policy_bean
								.setPOL_ORG_NEW_FC_SA((Double) pValList.get(3)
										.getValueObject());
					}
					if (pValList.get(4) != null) {
						pt_il_policy_bean
								.setPOL_ORG_NEW_LC_SA((Double) pValList.get(4)
										.getValueObject());
					}
					if (pValList.get(5) != null) {
						pt_il_policy_bean
								.setPOL_FC_SUM_ASSURED((Double) pValList.get(5)
										.getValueObject());
					}
					if (pValList.get(6) != null) {
						pt_il_policy_bean
								.setPOL_LC_SUM_ASSURED((Double) pValList.get(6)
										.getValueObject());
					}
				}
			}
			
			/*Added by ganesh on 10-08-2017, to avoid cover SA getting zero(0) using below Flag suggested by Ajoy*/
			/*ResultSet rsEndo=new CRUDHandler().executeSelectStatement(endoParamQuery, CommonUtils.getConnection());
			String endoParamValue = null;
			if(rsEndo.next()){
				endoParamValue = rsEndo.getString(1);
			}*/
			
			
			if(endoParamValue!=null && !endoParamValue.equals("2")){
				
			
			/*
			 * Adde By Haneef:55283 , As suggested by Rajasundarm, to fix
			 * Addition of Rider Endorsement issue, taken from P10.
			 */
			if ("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if (!(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(), "X")
						.equalsIgnoreCase(del_end_code))) {

/*Modified by Ram on 14/02/2017 for update Rider sumassured values
					 * 
					 * String C10 = "SELECT POAC_COVER_CODE,COVER_SA_PERC FROM PT_IL_POL_ADDL_COVER,PM_IL_COVER WHERE "
							+ "POAC_POL_SYS_ID   = ? "
							+ "AND POAC_COVER_CODE = COVER_CODE "
							+ "AND COVER_SA_CALC = 'S'";*/
					String C10 = "SELECT POAC_COVER_CODE,COVER_SA_PERC FROM PT_IL_POL_ADDL_COVER,PM_IL_COVER WHERE "
							+ "POAC_POL_SYS_ID   = ? "
							+ "AND POAC_COVER_CODE = COVER_CODE "
							+ "AND COVER_SA_CALC IN ('S','N')";
					/*End*/
					rs10 = handler.executeSelectStatement(C10, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					while (rs10.next()) {
						String updateStmt = "UPDATE PT_IL_POL_ADDL_COVER "
								+ "SET    POAC_FC_SA       = ?, "
								+ "POAC_LC_SA       = ? "
								+ "WHERE  POAC_POL_SYS_ID  = ? "
								+ "AND    POAC_COVER_CODE  = ?";

						handler.executeUpdateStatement(updateStmt, connection,
								new Object[] {
										pt_il_policy_bean
												.getPOL_FC_SUM_ASSURED()
												* (rs10.getDouble(2) / 100),
										pt_il_policy_bean
												.getPOL_LC_SUM_ASSURED()
												* (rs10.getDouble(2) / 100),
										pt_il_policy_bean.getPOL_SYS_ID(),
										rs10.getString(1) });

					}
				}
			}
			}
			/*end*/

			/*Added by Dhinesh on 27/03/2017 for Alteration Term issue*/
			else if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if (!(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(), "X")
						.equalsIgnoreCase(del_end_code))) {

					String C11 = "SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER,PM_IL_COVER WHERE "
							+ "POAC_POL_SYS_ID   = ? "
							+ "AND POAC_COVER_CODE = COVER_CODE ";
					/*End*/
					rs10 = handler.executeSelectStatement(C11, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					while (rs10.next()) {
						/*Modified by Dhinesh on 29/03/20
						 * 17 for Alteration Term issue 
						 * 
						 * String updateStmt = "UPDATE PT_IL_POL_ADDL_COVER "
								+ "SET    POAC_PERIOD      = ? "
								+ "WHERE  POAC_POL_SYS_ID  = ? "
								+ "AND    POAC_COVER_CODE  = ? ";
								handler.executeUpdateStatement(updateStmt, connection,
								new Object[] {
										pt_il_policy_bean
												.getPOL_PERIOD(),
										pt_il_policy_bean.getPOL_SYS_ID(),
										rs10.getString(1) });
								*/
						
						
						
						if(CommonUtils.getPPSystemParameterValue("IL_CHG_TERM").toString().equalsIgnoreCase("1"))
								{
							String updateStmt = "UPDATE PT_IL_POL_ADDL_COVER "
									+ "SET    POAC_PERIOD      = ?, "
									+ "POAC_PREM_PAY_YRS       = ?  "
									+ "WHERE  POAC_POL_SYS_ID  = ?  "
									+ "AND    POAC_COVER_CODE  = ?  ";
							handler.executeUpdateStatement(updateStmt, connection,
									new Object[] {
									pt_il_policy_bean
									.getPOL_PERIOD(),pt_il_policy_bean
									.getPOL_PREM_PAY_YRS(),
									pt_il_policy_bean.getPOL_SYS_ID(),
									rs10.getString(1) });
								}else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
										CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
												.getPOL_END_CODE(), "INCTERM","DECTERM"))
								{
									ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();

									pValList1 = pkg_pilt002_apac.P_PR_UPD_RIDER_TERM(pt_il_policy_bean.getPOL_SYS_ID(),pt_il_policy_bean.getPOL_PERIOD(),0);

								}
						
						
						

					}
				}
			}
			/*End*/
			/*Added by Ameen on 27-04-2018 as per chandramohan sugg.*/
			 if(null != pt_il_policy_bean.getPOL_END_NO_IDX() && pt_il_policy_bean.getPOL_END_NO_IDX() > 0 && null != pt_il_policy_bean.getPOL_END_CODE()){
				 if("INCSA".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE()) || "DECSA".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE())){
					 pkg_pilt002_apac.PR_ENDO_VALIDATE(
							 pt_il_policy_bean.getPOL_SYS_ID(), 
							 pt_il_policy_bean.getPOL_END_CODE(),
							 0,currValue);
				 }
			 }
			 /*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			connection.commit();
		}
	}

	public void POL_FC_SUM_ASSURED_WHEN_NEW_ITEM_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue) {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			if (CommonUtils.nvl(currValue, 0.0) <= 0.0
					&& !"012".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_FC_SUM_ASSURED(currValue);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void POL_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		Double M_PLAN_MIN_SA = 0.0;
		Double M_PLAN_MAX_SA = 0.0;
		String query1 = " SELECT PLAN_MIN_SA, PLAN_MAX_SA  FROM   PM_IL_PLAN "
				+ " WHERE  PLAN_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			if ((!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE()) || !"S"
					.equals(dummy_bean.getUI_M_POL_PLAN_TYPE()))
					&& !dummy_bean.getUI_M_PS_CODE()
							.equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_END_CODE(), "000"))) {
				if (CommonUtils.nvl(currValue, 0) <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71043",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					/*
					 * STD_MESSAGE_ROUTINE(71043,NAME_IN('GLOBAL.M_LANG_CODE'));
					 * RAISE FORM_TRIGGER_FAILURE;
					 */
				} else {
					values = new Object[] { pt_il_policy_bean
							.getPOL_PLAN_CODE() };
					rs = handler.executeSelectStatement(query1, connection,
							values);

					while (rs.next()) {
						M_PLAN_MIN_SA = rs.getDouble(1);
						M_PLAN_MAX_SA = rs.getDouble(2);
					}

					if ((CommonUtils.nvl(currValue, 0.0) < CommonUtils.nvl(
							M_PLAN_MIN_SA, 0))
							|| CommonUtils.nvl(currValue, 0.0) > CommonUtils
									.nvl(M_PLAN_MAX_SA, 0)) {
						String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
								.toPlainString());
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"3206",
												new Object[] { " Sum Assured Should be between "
														+ M_PLAN_MIN_SA
														+ " and " + plan_max_sa }));

						/*
						 * STD_MESSAGE_ROUTINE(3206,NAME_IN('GLOBAL.M_LANG_CODE'),'Sum
						 * Assured Should be between
						 * '||TO_CHAR(M_PLAN_MIN_SA)||' and
						 * '||TO_CHAR(M_PLAN_MAX_SA)); RAISE
						 * FORM_TRIGGER_FAILURE;
						 */
					}
				}
			}

			pValList = new ArrayList<String>();
			pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_SUM_ASSURED(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean.setPOL_FC_CURR_SA(pt_il_policy_bean
					.getPOL_FC_SUM_ASSURED());

			pt_il_policy_bean.setPOL_LC_SUM_ASSURED(pt_il_policy_bean
					.getPOL_FC_SUM_ASSURED()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			pValList = new ArrayList<String>();
			pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(),
					pt_il_policy_bean.getPOL_LC_SUM_ASSURED().toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_SUM_ASSURED(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean.setPOL_LC_CURR_SA(pt_il_policy_bean
					.getPOL_LC_SUM_ASSURED());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void POL_LC_SUM_ASSURED_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String M_PS_CODE = null;
		String query1 = "  SELECT PS_CODE   FROM   PP_SYSTEM  WHERE  PS_TYPE =? ";

		try {
			connection = CommonUtils.getConnection();
			dummy_bean.setUI_M_CHANGE_SA_YN("N");

			values = new Object[] { "IL_OCC_CHG" };
			rs = handler.executeSelectStatement(query1, connection, values);

			while (rs.next()) {
				M_PS_CODE = rs.getString(1);
			}
			if ((!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE()) || !"S"
					.equals(dummy_bean.getUI_M_POL_PLAN_TYPE()))
					&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(), "XXX")
							.equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_END_CODE(), "000")) || !CommonUtils
							.nvl(M_PS_CODE, "XXX").equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_END_CODE(), "000")))
					&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(), "XXX")
							.equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_PROP_END_CODE(), "000")) || !CommonUtils
							.nvl(M_PS_CODE, "XXX").equals(
									CommonUtils.nvl(pt_il_policy_bean
											.getPOL_PROP_END_CODE(), "000")))
					&& "002".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_END_TYPE(), "000"))) {

				if ((CommonUtils.nvl(currValue, 0.0) + CommonUtils.nvl(
						pt_il_policy_bean.getPOL_ORG_LC_SUM_ASSURED(), 0.0)) <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71043",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}
			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), CommonUtils
					.getProcedureValue(currValue), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());
			if (pValList != null && !pValList.isEmpty()) {
				if (pValList.get(0) != null) {
					pt_il_policy_bean.setPOL_LC_SUM_ASSURED(Double
							.parseDouble(pValList.get(0)));
				}
			}

			lifelibProcedures.P_VAL_FC_LC_TOLERANCE(CommonUtils
					.getProcedureValue(pt_il_policy_bean
							.getPOL_FC_SUM_ASSURED()), CommonUtils
					.getProcedureValue(currValue),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_SA_EXCH_RATE()), "E");

			pt_il_policy_bean.setPOL_LC_CURR_SA(currValue);
			CommonUtils.setGlobalVariable("GLOBAL.M_GRP_THRESHOLD", "Y");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Double POL_FC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		try {
			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), CommonUtils
					.getProcedureValue(currValue), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());
			if (pValList != null && !pValList.isEmpty()) {
				if (pValList.get(0) != null) {
					currValue = Double.parseDouble(pValList.get(0));
				}
			}

			pt_il_policy_bean.setPOL_LC_DEPOSIT_AMOUNT(currValue
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());
			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), CommonUtils
					.getProcedureValue(pt_il_policy_bean
							.getPOL_LC_DEPOSIT_AMOUNT()), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());
			if (pValList != null && !pValList.isEmpty()) {
				if (pValList.get(0) != null) {
					pt_il_policy_bean.setPOL_LC_DEPOSIT_AMOUNT(Double
							.parseDouble(pValList.get(0)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return currValue;
	}

	public Double POL_LC_DEPOSIT_AMOUNT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();

		try {

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_FC_DEPOSIT_AMOUNT(),
					0.0) > 0.0) {

				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), CommonUtils
						.getProcedureValue(currValue), "V", pt_il_policy_bean
						.getPOL_PROD_CODE());
				if (pValList != null && !pValList.isEmpty()) {
					if (pValList.get(0) != null) {
						currValue = Double.parseDouble(pValList.get(0));
					}
				}

				lifelibProcedures.P_VAL_FC_LC_TOLERANCE(pt_il_policy_bean
						.getPOL_FC_DEPOSIT_AMOUNT().toString(), currValue
						.toString(), pt_il_policy_bean.getPOL_SA_EXCH_RATE()
						.toString(), "E");
			} else {
				pt_il_policy_bean.setPOL_LC_DEPOSIT_AMOUNT(0.0);
				pt_il_policy_bean.setPOL_FC_DEPOSIT_AMOUNT(0.0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return currValue;
	}

	public void POL_FIRST_INST_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String query1 = " SELECT  ADD_MONTHS(ADD_MONTHS(?,? * 12), DECODE(? ,'Y', -12, 'H', -6, 'Q', -3, 'M', -1))  FROM DUAL ";
		Object[] values = {};
		Connection connection = null;
		ResultSet rs = null;
		Date date = null;
		pt_il_policy_bean.setPOL_FIRST_INST_DT(currValue);
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { currValue,
					pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
					pt_il_policy_bean.getPOL_MODE_OF_PYMT() };
			rs = handler.executeSelectStatement(query1, connection, values);

			while (rs.next()) {
				date = rs.getDate(1);
				pt_il_policy_bean.setPOL_LAST_INST_DT((date));
			}
			if (CommonUtils.timeStampToMonthDateYear(currValue).before(
					CommonUtils.timeStampToMonthDateYear(pt_il_policy_bean
							.getPOL_START_DT()))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71035",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}
			if (CommonUtils.timeStampToMonthDateYear(currValue).after(
					CommonUtils.timeStampToMonthDateYear(pt_il_policy_bean
							.getPOL_START_DT()))) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { // CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						" First Installment Date ", " <= ",
								" Policy Start Date " }));
			}

			if ("S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
				pt_il_policy_bean.setPOL_LAST_INST_DT(currValue);
			}
			if (currValue != null
					&& pt_il_policy_bean.getPOL_LAST_INST_DT().before(
							pt_il_policy_bean.getPOL_FIRST_INST_DT())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { " First Installment Date", " <= ",
								" Last Installment Date " }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_LAST_INST_DT_WHEN_VALIDATE_ITEM(Date POL_FIRST_INST_DT,
			Date currValue) throws Exception {
		try {

			if (POL_FIRST_INST_DT.after(currValue)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {// CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						" Last Installment Date", " >= ",
								" First Installment Date " }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FC_MON_ANNU_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		try {

			if ("D".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
					"X"))
					&& "G".equals(CommonUtils.nvl(dummy_bean
							.getUI_M_COVER_SA_CALC(), "X"))
					&& !"007".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_END_TYPE(), "000"))) {

				if (!"Q".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_PROP_QUOT_FLAG(), "N"))
						&& !CommonUtils
								.nvl(dummy_bean.getUI_M_PS_CODE(), "XXX")
								.equals(
										CommonUtils.nvl(pt_il_policy_bean
												.getPOL_END_CODE(), "XXX"))) {

					if (CommonUtils.nvl(currValue, 0)
							+ CommonUtils.nvl(pt_il_policy_bean
									.getPOL_ORG_FC_MON_ANNU_AMT(), 0) <= 0) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71043",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					}
				}
				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), currValue.toString(), "V",
						pt_il_policy_bean.getPOL_PROD_CODE());

				pt_il_policy_bean.setPOL_FC_MON_ANNU_AMT(Double
						.parseDouble(pValList.get(0)));

				pt_il_policy_bean.setPOL_LC_MON_ANNU_AMT(pt_il_policy_bean
						.getPOL_FC_MON_ANNU_AMT()
						* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), pt_il_policy_bean
						.getPOL_LC_MON_ANNU_AMT().toString(), "R",
						pt_il_policy_bean.getPOL_PROD_CODE());

				pt_il_policy_bean.setPOL_LC_MON_ANNU_AMT(Double
						.parseDouble(pValList.get(0)));

				/*
				 * P_VAL_ROUND_AMT (:DUMMY.M_BASE_CURR,
				 * :PT_IL_POLICY.POL_LC_MON_ANNU_AMT, 'R');
				 */

				local_procedures.IL_CALC_ANNUITY_SA(pt_il_policy_bean,
						dummy_bean);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public int F_GET_MOP_VALUE(String P_MODE_OF_PYMT) {

		if ("S".equals(P_MODE_OF_PYMT) || "Y".equals(P_MODE_OF_PYMT)) {
			return 1;
		} else if ("H".equals(P_MODE_OF_PYMT)) {
			return 2;
		} else if ("Q".equals(P_MODE_OF_PYMT)) {
			return 4;
		} else if ("M".equals(P_MODE_OF_PYMT)) {
			return 12;
		}
		return 0;
	}

	public void POL_MODE_OF_PYMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION policyAction = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POL_ASSURED_DTLS assuredBean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs7 = null, rs4 = null, rs1 = null, rs8 = null, rs5 = null, rs9 = null, rs_mop = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		ArrayList<String> pValListStr = new ArrayList<String>();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
		policyBean.setPOL_MODE_OF_PYMT(currValue);

		String query1 = "  SELECT ADD_MONTHS(ADD_MONTHS( ? ," + " ? * 12),"
				+ " DECODE(?,'Y', -12, 'H', -6, 'Q', -3, 'M', -1))"
				+ " FROM   DUAL ";

		String query4 = "  SELECT  PPL_LC_MIN_PREM FROM    PM_IL_PROD_PREM_LIMIT"
				+ "  WHERE   PPL_PROD_CODE   = ? "
				+ " AND     PPL_MODE_OF_PYMT  =? "
				+ " AND   ?    "
				+ " BETWEEN  PPL_FM_TERM AND PPL_TO_TERM";

		String query5 = " SELECT NVL(POL_ORG_FC_MODAL_PREM ,0),NVL(POL_ORG_LC_MODAL_PREM ,0),"
				+ " POL_NO_OF_INST, POL_ORG_NO_OF_INST   FROM   PT_IL_POLICY"
				+ "  WHERE  POL_SYS_ID = ? ";

		String query7 = "  SELECT PROD_ROUND_OPTION  FROM   PM_IL_PRODUCT "
				+ "  WHERE  PROD_CODE =? ";

		String query8 = " SELECT  MAS_MOP_VALUE  FROM    PM_MUDHARBAH_MOP"
				+ " WHERE   MAS_MH_PROD_CODE =? "
				+ " AND     MAS_MOP          =? ";

		String query9 = " SELECT PLAN_TYPE  FROM   PM_IL_PLAN   WHERE  "
				+ " PLAN_CODE =? ";
		String query_mop = " SELECT PROD_PREM_PAY_YRS  FROM    PM_IL_PRODUCT WHERE   PROD_CODE = ? ";

		Double M_RATE_PER = null;
		Double M_RATE = null;
		Double M_PPL_LC_MIN_PREM = 0d;
		Double M_POL_ORG_FC_MODAL_PREM = 0d;
		Double M_POL_ORG_LC_MODAL_PREM = 0d;
		Double M_POL_NO_OF_INST = 0d;
		Double M_POL_ORG_NO_OF_INST = 0d;
		String M_TEMP = null;
		String M_PROD_ROUND_OPTION = null;
		Double M_MAS_MOP_VALUE = 0d;
		String M_PLAN_TYPE = null;
		Integer M_PROD1_PREM_PAY_YRS = null;

		Double prevFcSA = policyBean.getPOL_FC_SUM_ASSURED();

		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		PCOPK_GENERAL pcopk_general = new PCOPK_GENERAL();
		try {
			connection = CommonUtils.getConnection();

			pValListStr = p9ilpk_policy
					.P_GET_MOP_RATE(policyBean.getPOL_PLAN_CODE(), policyBean
							.getPOL_MODE_OF_PYMT(), CommonUtils
							.getProcedureValue(policyBean.getPOL_START_DT()),
							null, null);
			if (pValListStr != null && !pValListStr.isEmpty()) {
				if (pValListStr.get(0) != null) {
					M_RATE = Double.parseDouble(pValListStr.get(0));
				}
				if (pValListStr.get(1) != null) {
					M_RATE_PER = Double.parseDouble(pValListStr.get(1));
				}
			}
			if (M_RATE != null && M_RATE_PER != null) {

				Double rateValue = CommonUtils.nvl(M_RATE, 0.0d);
				Double ratePerValue = CommonUtils.nvl(M_RATE_PER, 1.0d);
				if (rateValue > 0.0 && ratePerValue > 0.0) {
					policyBean.setPOL_MODE_OF_PYMT_RATE(CommonUtils
							.roundDouble((rateValue / ratePerValue)));
				} else {
					policyBean.setPOL_MODE_OF_PYMT_RATE(CommonUtils
							.roundDouble(rateValue));
				}

			} else {
				policyBean.setPOL_MODE_OF_PYMT_RATE(null);
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "MOP rate is not defined in Plan Master" }));
			}
			if (policyBean.getPOL_START_DT() != null) {

				if ("O".equals(dummyBean.getUI_M_PROD_MATU_DT())) {
					if ("012".equalsIgnoreCase(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))) {
						policyBean.setPOL_EXPIRY_DT(CommonUtils.addDaysToDate(
								(CommonUtils.addMonthsToDate(policyBean
										.getPOL_START_DT(), ((policyBean
										.getPOL_PERIOD() + policyBean
										.getPOL_ORG_PERIOD()) * 12))), -1));
					} else {
						if ("012".equalsIgnoreCase(CommonUtils.nvl(policyBean
								.getPOL_END_TYPE(), "000"))) {
							policyBean
									.setPOL_EXPIRY_DT(CommonUtils
											.addDaysToDate(
													(CommonUtils
															.addMonthsToDate(
																	policyBean
																			.getPOL_START_DT(),
																	((policyBean
																			.getPOL_PERIOD() + policyBean
																			.getPOL_ORG_PERIOD()) * 12))),
													-1));
						} else {
							//MODIFIED BY GOPI FOR TOI ON 26/07/2018
							String policy_aaprove=getPolicyApprove(policyBean.getPOL_PROD_CODE());
							if(policy_aaprove!=null && "B".equalsIgnoreCase(policy_aaprove)){
							policyBean
									.setPOL_EXPIRY_DT(CommonUtils
											.addDaysToDate(
													(CommonUtils
															.addMonthsToDate(
																	policyBean
																			.getPOL_START_DT(),
																	(policyBean
																			.getPOL_PERIOD() * 12))),
													-1));
							}else if(policy_aaprove!=null && "O".equalsIgnoreCase(policy_aaprove)){
							
							Calendar cal = Calendar.getInstance();
							cal.setTime(policyBean.getPOL_START_DT());
							cal.set(Calendar.HOUR_OF_DAY,23);
							cal.set(Calendar.MINUTE,59);
							
							policyBean
							.setPOL_EXPIRY_DT(CommonUtils
									.addDaysToDate(
											(CommonUtils
													.addMonthsToDate(cal.getTime(),
															(policyBean
																	.getPOL_PERIOD() * 12))),
											-1));
							
							}
							//END
							
						}
					}
				} else {
					policyBean.setPOL_EXPIRY_DT(CommonUtils.addMonthsToDate(
							policyBean.getPOL_START_DT(), (policyBean
									.getPOL_PERIOD() * 12)));
				}
			}
			if (policyBean.getPOL_FIRST_INST_DT() != null) {

				values = new Object[] { policyBean.getPOL_FIRST_INST_DT(),
						policyBean.getPOL_PREM_PAY_YRS(),
						policyBean.getPOL_MODE_OF_PYMT() };

				rs1 = handler
						.executeSelectStatement(query1, connection, values);
				if (rs1.next()) {
					policyBean.setPOL_LAST_INST_DT(rs1.getDate(1));
				}
				CommonUtils.closeCursor(rs1);
				if ("S".equals(policyBean.getPOL_MODE_OF_PYMT())) {
					policyBean.setPOL_LAST_INST_DT(policyBean
							.getPOL_FIRST_INST_DT());
				}

				if ("000".equalsIgnoreCase(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000"))) {

					if (policyBean.getPOL_PREM_PAY_YRS() > policyBean
							.getPOL_PERIOD()) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91076"));
					}
				}
				if (policyBean.getPOL_END_NO_IDX() != null) {
					if (policyBean.getPOL_END_NO_IDX() > 0
							&& "007".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| ("007".equals(CommonUtils.nvl(policyBean
									.getPOL_PROP_END_TYPE(), "000")))) {
						if ("S".equals(dummyBean.getUI_M_POL_MODE_OF_PYMT())
								&& !"S"
										.equals(policyBean
												.getPOL_MODE_OF_PYMT())) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91092"));
						}
						if (!"S".equals(dummyBean.getUI_M_POL_MODE_OF_PYMT1())
								&& "S".equals(policyBean.getPOL_MODE_OF_PYMT())) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91093"));
						}
					}
				}
			}

			if ("S".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "Y".equals(policyBean.getPOL_MODE_OF_PYMT())) {

				policyBean.setPOL_NO_OF_INST(1);
			} else if ("H".equals(policyBean.getPOL_MODE_OF_PYMT())) {
				policyBean.setPOL_NO_OF_INST(2);
			} else if ("M".equals(policyBean.getPOL_MODE_OF_PYMT())) {
				policyBean.setPOL_NO_OF_INST(12);
			} else if ("Q".equals(policyBean.getPOL_MODE_OF_PYMT())) {
				policyBean.setPOL_NO_OF_INST(4);
			}
			
			if ("Y".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "H".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "M".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "Q".equals(policyBean.getPOL_MODE_OF_PYMT())) {
				rs_mop = handler.executeSelectStatement(query_mop, connection,
						new Object[] { policyBean.getPOL_PROD_CODE() });

				if (rs_mop.next()) {
					policyAction.getCOMP_POL_PREM_PAY_YRS().setDisabled(false);
					M_PROD1_PREM_PAY_YRS = rs_mop.getInt(1);
				}
				if (policyBean.getPOL_PREM_PAY_YRS() == null) {
					//policyBean.setPOL_PREM_PAY_YRS(M_PROD1_PREM_PAY_YRS);
					policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PERIOD());
				}else{
					//policyBean.setPOL_PREM_PAY_YRS(M_PROD1_PREM_PAY_YRS);//ADDED BY GOPI
					//policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PERIOD());
					// Added BY SARANYA 17/10/2016 for policy paying years
					policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PREM_PAY_YRS());  
					/*Commentted by saritha on 07-09-2017 for Premium paying years*/
					/*if(policyBean.getPOL_PERIOD()!= policyBean.getPOL_PREM_PAY_YRS()){
						System.out.println("TRUE BLOCK ");
						commented and added below by dhinesh for MOP term issue on 26-10-2016
						 * 
						 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
								"current","Term and Premium Paying Term is not same");
						policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PERIOD());
					}*/
					//end
					/*policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PREM_PAY_YRS());
					if(policyBean.getPOL_PREM_PAY_YRS() == 1){
						policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PERIOD());
					}*/
				}
				System.out.println("inside mop if*****aaaaa*****************"+policyBean.getPOL_PREM_PAY_YRS()+"M_PROD1_PREM_PAY_YRS ^^^^^^^^^^^^"+M_PROD1_PREM_PAY_YRS);
			} else {
				policyAction.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
				policyBean.setPOL_PREM_PAY_YRS(1);
			}

			/*if(PT_IL_POLICY_ACTION.mopCheck){
			if ("Y".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "H".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "M".equals(policyBean.getPOL_MODE_OF_PYMT())
					|| "Q".equals(policyBean.getPOL_MODE_OF_PYMT())) {
				rs_mop = handler.executeSelectStatement(query_mop, connection,
						new Object[] { policyBean.getPOL_PROD_CODE() });

				if (rs_mop.next()) {
					policyAction.getCOMP_POL_PREM_PAY_YRS().setDisabled(false);
					M_PROD1_PREM_PAY_YRS = rs_mop.getInt(1);
				}
				if (policyBean.getPOL_PREM_PAY_YRS() == null) {
					policyBean.setPOL_PREM_PAY_YRS(M_PROD1_PREM_PAY_YRS);
				}else{
					//policyBean.setPOL_PREM_PAY_YRS(M_PROD1_PREM_PAY_YRS);//ADDED BY GOPI
					policyBean.setPOL_PREM_PAY_YRS(policyBean.getPOL_PREM_PAY_YRS());
					System.out.println("if (isINSERT_ALLOWED()) { ******"+isINSERT_ALLOWED());
					if(("Y".equals(policyBean.getPOL_MODE_OF_PYMT())
							|| "H".equals(policyBean.getPOL_MODE_OF_PYMT())
							|| "M".equals(policyBean.getPOL_MODE_OF_PYMT())
							|| "Q".equals(policyBean.getPOL_MODE_OF_PYMT()))){
						System.out.println("second dropdown M_PROD1_PREM_PAY_YRS ^*"+M_PROD1_PREM_PAY_YRS);
						policyBean.setPOL_PREM_PAY_YRS(M_PROD1_PREM_PAY_YRS);
					}
					
				}
				System.out.println("inside mop if*****aaaaa*****************"+policyBean.getPOL_PREM_PAY_YRS()+"M_PROD1_PREM_PAY_YRS ^^^^^^^^^^^^"+M_PROD1_PREM_PAY_YRS);
			} else {
				policyAction.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
				policyBean.setPOL_PREM_PAY_YRS(1);
			}

			PT_IL_POLICY_ACTION.mopCheck=false;
		}*/
			if ("007".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
					"000"))
					|| "007".equals(CommonUtils.nvl(policyBean
							.getPOL_PROP_END_TYPE(), "007"))) {

				values = new Object[] { policyBean.getPOL_SYS_ID() };

				rs5 = handler
						.executeSelectStatement(query5, connection, values);
				if (rs5.next()) {
					M_POL_ORG_FC_MODAL_PREM = rs5.getDouble(1);
					M_POL_ORG_LC_MODAL_PREM = rs5.getDouble(2);
					M_POL_NO_OF_INST = rs5.getDouble(3);
					M_POL_ORG_NO_OF_INST = rs5.getDouble(4);
				}

				if (M_POL_ORG_FC_MODAL_PREM > 0) {
					policyBean
							.setPOL_FC_MODAL_PREM(M_POL_ORG_FC_MODAL_PREM
									* (CommonUtils.nvl(M_POL_ORG_NO_OF_INST, 0) / CommonUtils
											.nvl(
													policyBean
															.getPOL_NO_OF_INST(),
													0)));
					policyBean
							.setPOL_LC_MODAL_PREM(M_POL_ORG_LC_MODAL_PREM
									* (CommonUtils.nvl(M_POL_ORG_NO_OF_INST, 0) / CommonUtils
											.nvl(
													policyBean
															.getPOL_NO_OF_INST(),
													0)));

				}

				values = new Object[] { policyBean.getPOL_PROD_CODE() };

				rs7 = handler
						.executeSelectStatement(query7, connection, values);
				if (rs7.next()) {
					M_PROD_ROUND_OPTION = rs7.getString(1);
				}

				if (!"N".equals(M_PROD_ROUND_OPTION)) {
					pValOrclList = new ArrayList<OracleParameter>();
					pValOrclList = pcopk_general
							.P_VAL_PROD_ROUND(
									policyBean.getPOL_CUST_CURR_CODE(),
									CommonUtils.getProcedureValue(policyBean
											.getPOL_FC_MODAL_PREM()),
									policyBean.getPOL_PROD_CODE(),
									"R",
									CommonUtils
											.getGlobalVariable("GLOBAL.M_LANG_CODE"),
									CommonUtils
											.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (!pValOrclList.isEmpty() && pValOrclList != null) {
						if (pValOrclList.get(0).getValue() != null) {
							policyBean
									.setPOL_FC_MODAL_PREM(Double
											.parseDouble(pValOrclList.get(0)
													.getValue()));

						}
					}

					pValOrclList = new ArrayList<OracleParameter>();
					pValOrclList = pcopk_general
							.P_VAL_PROD_ROUND(
									policyBean.getPOL_SA_CURR_CODE(),
									CommonUtils.getProcedureValue(policyBean
											.getPOL_LC_MODAL_PREM()),
									policyBean.getPOL_PROD_CODE(),
									"R",
									CommonUtils
											.getGlobalVariable("GLOBAL.M_LANG_CODE"),
									CommonUtils
											.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (!pValOrclList.isEmpty() && pValOrclList != null) {
						if (pValOrclList.get(0).getValue() != null) {
							policyBean
									.setPOL_LC_MODAL_PREM(Double
											.parseDouble(pValOrclList.get(0)
													.getValue()));
						}
					}

				} else {
					pValListStr = new ArrayList<String>();
					pValListStr = pkg_pilt002_apac.P_VAL_ROUND_AMT(policyBean
							.getPOL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(policyBean
									.getPOL_FC_MODAL_PREM()), "R", policyBean
							.getPOL_PROD_CODE());
					if (!pValListStr.isEmpty() && pValListStr != null) {
						if (pValListStr.get(0) != null) {
							policyBean.setPOL_FC_MODAL_PREM(Double
									.parseDouble(pValListStr.get(0)));
						}
					}
				}
			}

			if (!"G".equals(CommonUtils.nvl(dummyBean.getUI_M_COVER_SA_CALC(),
					"X"))
					&& !"N".equals(CommonUtils.nvl(dummyBean
							.getUI_M_COVER_SA_CALC(), "X"))) {
				if (!"F".equals(dummyBean.getUI_M_COVER_SA_CALC())) {
					if (!"007".equals(CommonUtils.nvl(policyBean
							.getPOL_PROP_END_TYPE(), "000"))) {
						if (!"016".equals(CommonUtils.nvl(policyBean
								.getPOL_END_TYPE(), "000"))) {

							pOrclValList = new ArrayList<OracleParameter>();
							// 'NR' for normal and 'PG' for package policy using
							// menu parameter_18

							if (("NR".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18")) || CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18") == null)
									&& (("P".equals(dummyBean
											.getUI_M_COVER_SA_CALC())) || (policyBean
											.getPOL_FC_SUM_ASSURED() != null && policyBean
											.getPOL_FC_SUM_ASSURED() < 1))) {
								pOrclValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL(
												policyBean.getPOL_SYS_ID(),
												policyBean.getPOL_END_NO_IDX(),
												policyBean.getPOL_END_CODE(),
												policyBean.getPOL_END_TYPE(),
												policyBean
														.getPOL_PREM_PAY_YRS(),
												policyBean
														.getPOL_ORG_NO_OF_INST(),
												policyBean
														.getPOL_SA_CURR_CODE(),
												policyBean
														.getPOL_SA_EXCH_RATE(),
												policyBean.getPOL_NO_OF_UNIT(),
												policyBean.getPOL_NO_OF_INST(),
												policyBean
														.getPOL_ORG_FC_SUM_ASSURED(),
												policyBean.getPOL_PLAN_CODE(),
												assuredBean.getPOAD_SYS_ID(),
												policyBean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummyBean.getUI_M_BASE_CURR(),
												dummyBean
														.getUI_M_COVER_VAR_VALUE(),
												policyBean.getROWID(),
												dummyBean
														.getUI_M_PROD_SA_FACTOR(),
												dummyBean
														.getUI_M_PROD_SA_TARIFF(),
												dummyBean
														.getUI_M_COVER_SA_CALC(),
												dummyBean.getUI_M_PS_CODE(),
												dummyBean
														.getUI_M_POL_PLAN_TYPE(),
												policyBean.getPOL_START_DT(),
												compositeAction
														.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
														.getPT_IL_POL_ASSURED_DTLS_BEAN()
														.getPOAD_AGE(),
												dummyBean.getUI_M_EXACT_AGE(),
												policyBean
														.getPOL_DEF_PERIOD_TO(),
												dummyBean.getUI_M_TD_MIN_RATE(),
												dummyBean.getUI_M_TD_MAX_RATE(),
												policyBean.getPOL_NEW_FC_SA(),
												policyBean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);

							} else if ("PG".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
								pOrclValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL_PGC(
												policyBean
														.getPOL_PROD_GROUP_CODE(),
												dummyBean
														.getUI_M_PROD_PREM_TARIFF(),
												policyBean.getPOL_SYS_ID(),
												policyBean.getPOL_END_NO_IDX(),
												policyBean.getPOL_END_CODE(),
												policyBean.getPOL_END_TYPE(),
												policyBean
														.getPOL_PREM_PAY_YRS(),
												policyBean
														.getPOL_ORG_NO_OF_INST(),
												policyBean
														.getPOL_SA_CURR_CODE(),
												policyBean
														.getPOL_SA_EXCH_RATE(),
												policyBean.getPOL_NO_OF_UNIT(),
												policyBean.getPOL_NO_OF_INST(),
												policyBean
														.getPOL_ORG_FC_SUM_ASSURED(),
												policyBean.getPOL_PLAN_CODE(),
												assuredBean.getPOAD_SYS_ID(),
												policyBean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummyBean.getUI_M_BASE_CURR(),
												dummyBean
														.getUI_M_COVER_VAR_VALUE(),
												policyBean.getROWID(),
												dummyBean
														.getUI_M_PROD_SA_FACTOR(),
												dummyBean
														.getUI_M_PROD_SA_TARIFF(),
												dummyBean
														.getUI_M_COVER_SA_CALC(),
												dummyBean.getUI_M_PS_CODE(),
												dummyBean
														.getUI_M_POL_PLAN_TYPE(),
												policyBean.getPOL_START_DT(),
												assuredBean.getPOAD_AGE(),
												dummyBean.getUI_M_EXACT_AGE(),
												policyBean
														.getPOL_DEF_PERIOD_TO(),
												dummyBean.getUI_M_TD_MIN_RATE(),
												dummyBean.getUI_M_TD_MAX_RATE(),
												policyBean.getPOL_NEW_FC_SA(),
												policyBean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);
							}

							if (!pOrclValList.isEmpty() && pOrclValList != null) {
								dummyBean
										.setUI_M_TD_MIN_RATE((Double) (pOrclValList
												.get(0).getValueObject()));
								dummyBean
										.setUI_M_TD_MAX_RATE((Double) (pOrclValList
												.get(1).getValueObject()));
								policyBean
										.setPOL_NEW_FC_SA((Double) (pOrclValList
												.get(2).getValueObject()));
								policyBean
										.setPOL_FC_MODAL_PREM((Double) (pOrclValList
												.get(3).getValueObject()));
								policyBean
										.setPOL_FC_BASIC_PREM((Double) (pOrclValList
												.get(4).getValueObject()));
								policyBean
										.setPOL_LC_BASIC_PREM((Double) (pOrclValList
												.get(5).getValueObject()));
								policyBean
										.setPOL_FC_SUM_ASSURED((Double) (pOrclValList
												.get(6).getValueObject()));
								policyBean
										.setPOL_LC_SUM_ASSURED((Double) (pOrclValList
												.get(7).getValueObject()));
								policyBean
										.setPOL_FC_CURR_SA((Double) (pOrclValList
												.get(8).getValueObject()));
								policyBean
										.setPOL_LC_CURR_SA((Double) (pOrclValList
												.get(9).getValueObject()));
								policyBean
										.setPOL_ORG_NEW_LC_SA((Double) (pOrclValList
												.get(10).getValueObject()));
								policyBean
										.setPOL_ORG_NEW_FC_SA((Double) (pOrclValList
												.get(11).getValueObject()));
								policyBean
										.setPOL_NEW_LC_SA((Double) (pOrclValList
												.get(12).getValueObject()));
								policyBean
										.setPOL_FC_MON_ANNU_AMT((Double) (pOrclValList
												.get(13).getValueObject()));
								policyBean
										.setPOL_LC_MON_ANNU_AMT((Double) (pOrclValList
												.get(14).getValueObject()));
							}
						}
					}
				} else if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())) {
					pValList = new ArrayList<OracleParameter>();
					pValList = pkg_pilt002_apac.IL_CALC_SA_FACT_VALID(
							policyBean.getPOL_SYS_ID(), policyBean
									.getPOL_PLAN_CODE(), policyBean
									.getPOL_END_TYPE(), policyBean.getROWID(),
							dummyBean.getUI_M_PROD_SA_FACTOR(), assuredBean
									.getPOAD_SYS_ID(), policyBean
									.getPOL_FC_MODAL_PREM(), policyBean
									.getPOL_ORG_FC_MODAL_PREM(), policyBean
									.getPOL_ORG_NO_OF_INST(), policyBean
									.getPOL_ORG_NO_OF_UNIT(), dummyBean
									.getUI_M_PLAN_CALC_TYPE(), policyBean
									.getPOL_SA_CURR_CODE(), policyBean
									.getPOL_NO_OF_INST(), policyBean
									.getPOL_PROD_CODE(), policyBean
									.getPOL_ORG_FC_SUM_ASSURED(), policyBean
									.getPOL_SA_EXCH_RATE(), policyBean
									.getPOL_NO_OF_UNIT(), policyBean
									.getPOL_NEW_FC_SA(), policyBean
									.getPOL_NEW_LC_SA(), policyBean
									.getPOL_ORG_NEW_FC_SA(), policyBean
									.getPOL_ORG_NEW_LC_SA(), policyBean
									.getPOL_FC_SUM_ASSURED(), policyBean
									.getPOL_LC_SUM_ASSURED());
					if (pValList != null && !pValList.isEmpty()) {
						if (pValList.get(0) != null) {
							policyBean.setPOL_NO_OF_UNIT((Double) pValList.get(
									0).getValueObject());
						}
						if (pValList.get(1) != null) {
							policyBean.setPOL_NEW_FC_SA((Double) pValList
									.get(1).getValueObject());
						}
						if (pValList.get(2) != null) {
							policyBean.setPOL_NEW_LC_SA((Double) pValList
									.get(2).getValueObject());
						}
						if (pValList.get(3) != null) {
							policyBean.setPOL_ORG_NEW_FC_SA((Double) pValList
									.get(3).getValueObject());
						}
						if (pValList.get(4) != null) {
							policyBean.setPOL_ORG_NEW_LC_SA((Double) pValList
									.get(4).getValueObject());
						}
						
						/* Newly Added by saritha on 12-07-2017 for Endowment &Education Product Issues */
						/*Commentted &Modified by saritha on 18-08-2017 for Endowment &Education Product Issues*/ 
						/*if(! "END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))*/
						
						if(! "END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())&&
								! "EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ()))
						{
						/*End*/
							if (pValList.get(5) != null) {

								policyBean.setPOL_FC_SUM_ASSURED((Double) pValList
										.get(5).getValueObject());
							}
							if (pValList.get(6) != null) {
								policyBean.setPOL_LC_SUM_ASSURED((Double) pValList
										.get(6).getValueObject());
							}
						}
						/* End */
					}
				}
			}

			if (("P".equals(dummyBean.getUI_M_COVER_SA_CALC()) || "V"
					.equals(dummyBean.getUI_M_COVER_SA_CALC()))
					&& CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) == 0
					&& CommonUtils.nvl(policyBean.getPOL_FC_MODAL_PREM(), 0) == 0) {

				values = new Object[] { policyBean.getPOL_PROD_CODE(),
						policyBean.getPOL_MODE_OF_PYMT(),
						policyBean.getPOL_PREM_PAY_YRS() };

				rs4 = handler
						.executeSelectStatement(query4, connection, values);
				if (rs4.next()) {
					M_PPL_LC_MIN_PREM = rs4.getDouble(1);
				}
				policyBean.setPOL_FC_MODAL_PREM(CommonUtils.nvl(
						M_PPL_LC_MIN_PREM, 0));
				policyBean.setPOL_LC_MODAL_PREM(policyBean
						.getPOL_FC_MODAL_PREM());
			}

			values = new Object[] { policyBean.getPOL_PLAN_CODE() };
			rs9 = handler.executeSelectStatement(query9, connection, values);
			if (rs9.next()) {
				M_PLAN_TYPE = rs9.getString(1);
			}

			if ("D".equals(M_PLAN_TYPE)) {
				if (!"S".equals(policyBean.getPOL_MODE_OF_PYMT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91105"));
				}
			}

			if ("U".equals(CommonUtils.nvl(M_PLAN_TYPE, "N"))) {
				if (CommonUtils.nvl(policyBean.getPOL_FC_MODAL_PREM(), 0) > 0) {

					values = new Object[] { policyBean.getPOL_PROD_CODE(),
							policyBean.getPOL_MODE_OF_PYMT() };

					rs8 = handler.executeSelectStatement(query8, connection,
							values);
					if (rs8.next()) {
						M_MAS_MOP_VALUE = rs8.getDouble(1);
					}
					pValListStr = new ArrayList<String>();
					pcopk_general
							.P_VAL_PROD_ROUND(
									policyBean.getPOL_CUST_CURR_CODE(),
									CommonUtils
											.getProcedureValue(M_MAS_MOP_VALUE),
									policyBean.getPOL_PROD_CODE(),
									"R",
									CommonUtils
											.getGlobalVariable("GLOBAL.M_LANG_CODE"),
									CommonUtils
											.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
					if (pValListStr != null && !pValListStr.isEmpty()) {
						if (pValListStr.get(0) != null) {
							M_MAS_MOP_VALUE = Double.parseDouble(pValListStr
									.get(0));
						}
					}

					if ("000".equals(CommonUtils.nvl(policyBean
							.getPOL_PROP_END_TYPE(), "000"))) {

						policyBean.setPOL_LC_MIN_PREM(CommonUtils.nvl(
								M_MAS_MOP_VALUE, 0));
						policyBean.setPOL_FC_MIN_PREM(CommonUtils.nvl(
								M_MAS_MOP_VALUE, 0));
						policyBean.setPOL_FC_EXTRA_PREM(policyBean
								.getPOL_FC_MODAL_PREM()
								- CommonUtils.nvl(policyBean
										.getPOL_FC_MIN_PREM(), 0));
						policyBean.setPOL_LC_EXTRA_PREM(policyBean
								.getPOL_LC_MODAL_PREM()
								- CommonUtils.nvl(policyBean
										.getPOL_LC_MIN_PREM(), 0));

					} else if ("002".equals(CommonUtils.nvl(policyBean
							.getPOL_PROP_END_TYPE(), "000"))) {
						policyBean.setPOL_LC_MIN_PREM(0d);
						policyBean.setPOL_FC_MIN_PREM(0d);
						policyBean.setPOL_FC_EXTRA_PREM(policyBean
								.getPOL_FC_MODAL_PREM()
								- CommonUtils.nvl(policyBean
										.getPOL_FC_MIN_PREM(), 0));
						policyBean.setPOL_LC_EXTRA_PREM(policyBean
								.getPOL_FC_MODAL_PREM()
								- CommonUtils.nvl(policyBean
										.getPOL_LC_MIN_PREM(), 0));

					}
				}
			}
			/*
			 * if("U".equalsIgnoreCase(dummyBean.getUI_M_POL_PLAN_TYPE())){
			 * thresholdLimitAddingForUlip(policyBean, compositeAction,
			 * policyBean.getPOL_FC_SUM_ASSURED(),prevFcSA); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs7);
				CommonUtils.closeCursor(rs8);
				CommonUtils.closeCursor(rs9);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/*
	 * public void POL_MODE_OF_PYMT_WHEN_LIST_CHANGED(
	 * PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {
	 * 
	 * PT_IL_POLICY pt_il_policy_bean = compositeAction
	 * .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	 * PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
	 * .getPT_IL_POLICY_ACTION_BEAN(); PT_IL_POL_ASSURED_DTLS
	 * pt_il_pol_assured_dtls_bean = compositeAction
	 * .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN(); DUMMY dummy_bean =
	 * compositeAction.getDUMMY_ACTION_BEAN() .getDUMMY_BEAN(); Connection
	 * connection = null; ResultSet rs2 = null, rs6 = null, rs3 = null, rs7 =
	 * null, rs4 = null, rs1 = null, rs8 = null, rs5 = null, rs9 = null;
	 * Object[] values = {}; ArrayList<String> pValList = new ArrayList<String>();
	 * ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
	 * ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
	 * pt_il_policy_bean.setPOL_MODE_OF_PYMT(currValue);
	 * 
	 * String query1 = " SELECT ADD_MONTHS(ADD_MONTHS( ? ," + " ? * 12)," + "
	 * DECODE(?,'Y', -12, 'H', -6, 'Q', -3, 'M', -1))" + " FROM DUAL ";
	 * 
	 * String query2 = " SELECT PC_SCHD_PYMT_DT FROM PT_IL_PREM_COLL WHERE " + "
	 * PC_POL_SYS_ID =? AND PC_PREM_TYPE = 'R' " + " AND NVL(PC_PAID_FLAG,'N') !=
	 * 'A' ";
	 * 
	 * String query3 = " SELECT COUNT(PC_SYS_ID) FROM PT_IL_PREM_COLL WHERE " + "
	 * PC_POL_SYS_ID =? AND PC_PREM_TYPE <> 'R'" + " AND NVL(PC_PAID_FLAG,'N') !=
	 * 'A' ";
	 * 
	 * String query4 = " SELECT PPL_LC_MIN_PREM FROM PM_IL_PROD_PREM_LIMIT" + "
	 * WHERE PPL_PROD_CODE = ? " + " AND PPL_MODE_OF_PYMT =? " + " AND ? " + "
	 * BETWEEN PPL_FM_TERM AND PPL_TO_TERM";
	 * 
	 * String query5 = " SELECT NVL(POL_ORG_FC_MODAL_PREM
	 * ,0),NVL(POL_ORG_LC_MODAL_PREM ,0)," + " POL_NO_OF_INST,
	 * POL_ORG_NO_OF_INST FROM PT_IL_POLICY" + " WHERE POL_SYS_ID = ? ";
	 * 
	 * String query6 = " SELECT
	 * POL_MODE_OF_PYMT,POL_FC_MODAL_PREM,POL_NO_OF_INST FROM " + " PT_IL_POLICY
	 * WHERE POL_LINK_SYS_ID = (SELECT POL_LINK_SYS_ID" + " FROM PT_IL_POLICY
	 * WHERE POL_SYS_ID =? )";
	 * 
	 * String query7 = " SELECT PROD_ROUND_OPTION FROM PM_IL_PRODUCT " + " WHERE
	 * PROD_CODE =? ";
	 * 
	 * String query8 = " SELECT MAS_MOP_VALUE FROM PM_MUDHARBAH_MOP" + " WHERE
	 * MAS_MH_PROD_CODE =? " + " AND MAS_MOP =? ";
	 * 
	 * String query9 = " SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE " + " PLAN_CODE =? ";
	 * 
	 * Double M_RATE_PER = 0.0; Double M_RATE = 0.0; Date M_PC_SCHD_PYMT_DT =
	 * null; int M_NEW_PAY_MODE = 0; int M_OLD_PAY_MODE = 0; Double M_NO_PYMT =
	 * null; Double M_PPL_LC_MIN_PREM = 0d; Double M_POL_ORG_LC_MODAL_PREM = 0d;
	 * Double M_POL_ORG_FC_MODAL_PREM = 0d; Double M_POL_NO_OF_INST = 0d; Double
	 * M_POL_ORG_NO_OF_INST = 0d; String M_TEMP = null; Double
	 * M_POL_FC_MODAL_PREM = 0d; Double M_PROD_ROUND_OPTION = 0d; Double
	 * M_MAS_MOP_VALUE = 0d; String M_PLAN_TYPE = null; P9ILPK_POLICY
	 * p9ilpk_policy = new P9ILPK_POLICY(); PCOPK_GENERAL pcopk_general = new
	 * PCOPK_GENERAL(); try { connection = CommonUtils.getConnection();
	 * 
	 * if ("007".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_END_TYPE(),
	 * "000")) || "007".equals(CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_PROP_END_TYPE(), "000")) &&
	 * "N".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_APPRV_STATUS(),
	 * "N"))) {
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
	 * 
	 * rs2 = handler .executeSelectStatement(query2, connection, values); if
	 * (rs2.next()) { M_PC_SCHD_PYMT_DT = rs2.getDate(1); }
	 * 
	 * if ("PILP052_APAC".equals(CommonUtils
	 * .getGlobalVariable("CALLING_FORM"))) {
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
	 * 
	 * rs6 = handler.executeSelectStatement(query6, connection, values); if
	 * (rs6.next()) { dummy_bean.setUI_M_POL_MODE_OF_PYMT1(rs6.getString(1));
	 * M_POL_FC_MODAL_PREM = rs6.getDouble(2); M_POL_NO_OF_INST =
	 * rs6.getDouble(3); } } if
	 * (pt_il_policy_bean.getPOL_END_EFF_FROM_DT().equals( M_PC_SCHD_PYMT_DT)) { //
	 * null; } else { M_OLD_PAY_MODE = F_GET_MOP_VALUE(dummy_bean
	 * .getUI_M_POL_MODE_OF_PYMT1()); M_NEW_PAY_MODE =
	 * F_GET_MOP_VALUE(pt_il_policy_bean .getPOL_MODE_OF_PYMT());
	 * 
	 * if (M_OLD_PAY_MODE > M_NEW_PAY_MODE) { values = new Object[] {
	 * pt_il_policy_bean .getPOL_SYS_ID() };
	 * 
	 * rs3 = handler.executeSelectStatement(query3, connection, values); if
	 * (rs3.next()) { M_NO_PYMT = rs3.getDouble(1); }
	 * 
	 * if ("Y".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) { if (M_NO_PYMT !=
	 * 0 & M_NO_PYMT != M_OLD_PAY_MODE) {
	 * 
	 * pt_il_policy_bean .setPOL_MODE_OF_PYMT(dummy_bean
	 * .getUI_M_POL_MODE_OF_PYMT1()); throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "91014", new Object[] { "Endorsement",
	 * "done only from Next Renewal Date " + M_PC_SCHD_PYMT_DT })); } else { if
	 * (false)// M_NO_PYMT MOD // (M_OLD_PAY_MODE/M_NEW_PAY_MODE))<>0 // ) {
	 * 
	 * pt_il_policy_bean .setPOL_MODE_OF_PYMT(dummy_bean
	 * .getUI_M_POL_MODE_OF_PYMT1()); throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "91014", new Object[] {
	 * 
	 * "Endorsement", "done only from Next Renewal Date " + M_PC_SCHD_PYMT_DT
	 * })); } } } } } pValList = new ArrayList<String>(); pValList =
	 * p9ilpk_policy.P_GET_MOP_RATE(pt_il_policy_bean .getPOL_PLAN_CODE(),
	 * pt_il_policy_bean .getPOL_MODE_OF_PYMT(),
	 * pt_il_policy_bean.getPOL_START_DT() .toString(), null, null); M_RATE =
	 * Double.parseDouble(pValList.get(0)); M_RATE_PER =
	 * Double.parseDouble(pValList.get(1));
	 * 
	 * pt_il_policy_bean.setPOL_MODE_OF_PYMT_RATE(CommonUtils.ROUND(
	 * (CommonUtils.nvl(M_RATE, 0) / CommonUtils .nvl(M_RATE_PER, 1)), 7));
	 * 
	 * if (pt_il_policy_bean.getPOL_START_DT() != null) {
	 * 
	 * --:PT_IL_POLICY.POL_EXPIRY_DT :=
	 * ADD_MONTHS(:PT_IL_POLICY.POL_START_DT,(:PT_IL_POLICY.POL_PERIOD * 12)) -
	 * 1; --GOKILA -- IF :DUMMY.M_MATU_DATE = 1 THEN --COMMENTED AND CHANGED BY
	 * SRIDHAR.R
	 * 
	 * if ("O".equals(dummy_bean.getUI_M_PROD_MATU_DT())) {
	 * pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
	 * .addDaysToDate((CommonUtils.addMonthsToDate(
	 * pt_il_policy_bean.getPOL_START_DT(), (pt_il_policy_bean.getPOL_PERIOD()
	 * .intValue() * 12))), -1)); } else {
	 * pt_il_policy_bean.setPOL_EXPIRY_DT(CommonUtils
	 * .addMonthsToDate(pt_il_policy_bean .getPOL_START_DT(), (pt_il_policy_bean
	 * .getPOL_PERIOD().intValue() * 12))); } }
	 * 
	 * if (pt_il_policy_bean.getPOL_FIRST_INST_DT() != null) {
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_FIRST_INST_DT(),
	 * pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
	 * pt_il_policy_bean.getPOL_MODE_OF_PYMT() };
	 * 
	 * rs1 = handler .executeSelectStatement(query1, connection, values); if
	 * (rs1.next()) { pt_il_policy_bean.setPOL_LAST_INST_DT(rs1.getDate(1)); }
	 * else { }
	 * 
	 * if ("S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
	 * pt_il_policy_bean.setPOL_LAST_INST_DT(pt_il_policy_bean
	 * .getPOL_FIRST_INST_DT()); }
	 * 
	 * if (pt_il_policy_bean.getPOL_PREM_PAY_YRS() > pt_il_policy_bean
	 * .getPOL_PERIOD()) { throw new Exception(Messages.getString(
	 * PELConstants.pelErrorMessagePath, "91076", new Object[] { CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE") })); //
	 * STD_MESSAGE_ROUTINE(91076,NAME_IN('GLOBAL.M_LANG_CODE')); }
	 * 
	 * if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0 &&
	 * "007".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_END_TYPE(),
	 * "000")) || ("007".equals(CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_PROP_END_TYPE(), "007")))) { if
	 * ("S".equals(dummy_bean.getUI_M_POL_MODE_OF_PYMT()) &&
	 * !"S".equals(pt_il_policy_bean .getPOL_MODE_OF_PYMT())) { throw new
	 * Exception( Messages .getString( PELConstants.pelErrorMessagePath,
	 * "91092", new Object[] { CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE") })); } if
	 * (!"S".equals(dummy_bean.getUI_M_POL_MODE_OF_PYMT1()) &&
	 * "S".equals(pt_il_policy_bean .getPOL_MODE_OF_PYMT())) { throw new
	 * Exception( Messages .getString( PELConstants.pelErrorMessagePath,
	 * "91093", new Object[] { CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE") })); } } } if
	 * ("S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT()) ||
	 * "Y".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
	 * pt_il_policy_bean.setPOL_NO_OF_INST(1); } else if
	 * ("H".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
	 * pt_il_policy_bean.setPOL_NO_OF_INST(2); } else if
	 * ("M".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
	 * pt_il_policy_bean.setPOL_NO_OF_INST(12); } else if
	 * ("Q".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
	 * pt_il_policy_bean.setPOL_NO_OF_INST(4); } // -- Start Added by Anamika
	 * for modal premium updation in 007 // endorsement if
	 * ("007".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_END_TYPE(),
	 * "000"))) { values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
	 * rs5 = handler .executeSelectStatement(query5, connection, values); if
	 * (rs5.next()) { M_POL_ORG_FC_MODAL_PREM = rs5.getDouble(1);
	 * M_POL_ORG_LC_MODAL_PREM = rs5.getDouble(2); M_POL_NO_OF_INST =
	 * rs5.getDouble(3); M_POL_ORG_NO_OF_INST = rs5.getDouble(4); }
	 * 
	 * if (M_POL_ORG_FC_MODAL_PREM > 0) { pt_il_policy_bean
	 * .setPOL_FC_MODAL_PREM(M_POL_ORG_FC_MODAL_PREM
	 * (CommonUtils.nvl(M_POL_ORG_NO_OF_INST, 0) / CommonUtils
	 * .nvl(pt_il_policy_bean .getPOL_NO_OF_INST(), 0))); pt_il_policy_bean
	 * .setPOL_LC_MODAL_PREM(M_POL_ORG_LC_MODAL_PREM
	 * (CommonUtils.nvl(M_POL_ORG_NO_OF_INST, 0) / CommonUtils
	 * .nvl(pt_il_policy_bean .getPOL_NO_OF_INST(), 0))); values = new Object[] {
	 * pt_il_policy_bean .getPOL_PROD_CODE() }; rs7 =
	 * handler.executeSelectStatement(query7, connection, values); if
	 * (rs7.next()) M_PROD_ROUND_OPTION = rs7.getDouble(1);
	 * 
	 * if (!"N".equals(M_PROD_ROUND_OPTION)) { pValOrclList = new ArrayList<OracleParameter>();
	 * pValOrclList = pcopk_general .P_VAL_PROD_ROUND( pt_il_policy_bean
	 * .getPOL_CUST_CURR_CODE(), pt_il_policy_bean .getPOL_FC_MODAL_PREM()
	 * .toString(), pt_il_policy_bean.getPOL_PROD_CODE(), "R", CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
	 * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE")); if
	 * (!pValOrclList.isEmpty()) pt_il_policy_bean .setPOL_FC_MODAL_PREM(Double
	 * .parseDouble(pValOrclList.get(0) .getValue()));
	 * 
	 * pValOrclList = new ArrayList<OracleParameter>(); pValOrclList =
	 * pcopk_general .P_VAL_PROD_ROUND( pt_il_policy_bean.getPOL_SA_CURR_CODE(),
	 * pt_il_policy_bean .getPOL_LC_MODAL_PREM() .toString(),
	 * pt_il_policy_bean.getPOL_PROD_CODE(), "R", CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
	 * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE")); if
	 * (!pValOrclList.isEmpty()) pt_il_policy_bean .setPOL_LC_MODAL_PREM(Double
	 * .parseDouble(pValOrclList.get(0) .getValue())); } else { pValList = new
	 * ArrayList<String>();
	 * 
	 * pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
	 * .getPOL_SA_CURR_CODE(), pt_il_policy_bean
	 * .getPOL_FC_MODAL_PREM().toString(), "R",
	 * pt_il_policy_bean.getPOL_PROD_CODE()); } } } // --for endt processing
	 * else if ("007".equals(CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_PROP_END_TYPE(), "000"))) {
	 * pt_il_policy_bean.setPOL_FC_MODAL_PREM((M_POL_FC_MODAL_PREM
	 * CommonUtils.nvl(M_POL_NO_OF_INST, 0) / CommonUtils
	 * .nvl(pt_il_policy_bean.getPOL_NO_OF_INST(), 0)));
	 * pt_il_policy_bean.setPOL_LC_MODAL_PREM((M_POL_FC_MODAL_PREM
	 * CommonUtils.nvl(M_POL_NO_OF_INST, 0) / CommonUtils
	 * .nvl(pt_il_policy_bean.getPOL_NO_OF_INST(), 0)));
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() }; rs7 =
	 * handler .executeSelectStatement(query7, connection, values); if
	 * (rs7.next()) M_PROD_ROUND_OPTION = rs7.getDouble(1);
	 * 
	 * if (!"N".equals(M_PROD_ROUND_OPTION)) {
	 * 
	 * pValOrclList = new ArrayList<OracleParameter>(); pValOrclList =
	 * pcopk_general .P_VAL_PROD_ROUND(
	 * pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
	 * pt_il_policy_bean.getPOL_FC_MODAL_PREM() .toString(),
	 * pt_il_policy_bean.getPOL_PROD_CODE(), "R", CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
	 * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE")); if
	 * (!pValOrclList.isEmpty()) pt_il_policy_bean.setPOL_FC_MODAL_PREM(Double
	 * .parseDouble(pValOrclList.get(0).getValue()));
	 * 
	 * pValOrclList = new ArrayList<OracleParameter>(); pValOrclList =
	 * pcopk_general .P_VAL_PROD_ROUND( pt_il_policy_bean.getPOL_SA_CURR_CODE(),
	 * pt_il_policy_bean.getPOL_LC_MODAL_PREM() .toString(),
	 * pt_il_policy_bean.getPOL_PROD_CODE(), "R", CommonUtils
	 * .getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
	 * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE")); if
	 * (!pValOrclList.isEmpty()) pt_il_policy_bean.setPOL_LC_MODAL_PREM(Double
	 * .parseDouble(pValOrclList.get(0).getValue())); } else { pValList = new
	 * ArrayList<String>(); pValList = pkg_pilt002_apac
	 * .P_VAL_ROUND_AMT(pt_il_policy_bean .getPOL_SA_CURR_CODE(),
	 * pt_il_policy_bean .getPOL_FC_MODAL_PREM().toString(), "R",
	 * pt_il_policy_bean.getPOL_PROD_CODE()); } } // -- end Added by Anamika for
	 * modal premium updation in 007 // endorsement if
	 * (!"007".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_PROP_END_TYPE(),
	 * "000"))) { if (!"G".equals(CommonUtils.nvl(dummy_bean
	 * .getUI_M_COVER_SA_CALC(), "X"))) { // if
	 * ("F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
	 * 
	 * pValList = new ArrayList<String>();
	 * 
	 * pValList = pkg_pilt002_apac .IL_CALC_SA_FACT_VALID(
	 * pt_il_policy_bean.getPOL_SYS_ID() .toString(),
	 * pt_il_policy_bean.getPOL_PLAN_CODE(),
	 * pt_il_policy_bean.getPOL_END_TYPE(), pt_il_policy_bean.getROWID(),
	 * dummy_bean.getUI_M_PROD_SA_TARIFF(), pt_il_pol_assured_dtls_bean
	 * .getPOAD_SYS_ID().toString(), pt_il_policy_bean .getPOL_FC_MODAL_PREM()
	 * .toString(), pt_il_policy_bean .getPOL_ORG_FC_MODAL_PREM() .toString(),
	 * pt_il_policy_bean .getPOL_ORG_NO_OF_INST() .toString(), pt_il_policy_bean
	 * .getPOL_ORG_NO_OF_UNIT() .toString(),
	 * dummy_bean.getUI_M_PLAN_CALC_TYPE(),
	 * pt_il_policy_bean.getPOL_SA_CURR_CODE(),
	 * pt_il_policy_bean.getPOL_NO_OF_INST() .toString(), pt_il_policy_bean
	 * .getPOL_PROD_CODE(), pt_il_policy_bean .getPOL_ORG_FC_SUM_ASSURED()
	 * .toString(), pt_il_policy_bean .getPOL_SA_EXCH_RATE() .toString(),
	 * pt_il_policy_bean.getPOL_NO_OF_UNIT() .toString(), pt_il_policy_bean
	 * .getPOL_NEW_FC_SA().toString(), pt_il_policy_bean.getPOL_NEW_LC_SA()
	 * .toString(), pt_il_policy_bean .getPOL_ORG_NEW_FC_SA() .toString(),
	 * pt_il_policy_bean .getPOL_ORG_NEW_LC_SA() .toString(), pt_il_policy_bean
	 * .getPOL_FC_SUM_ASSURED() .toString(), pt_il_policy_bean
	 * .getPOL_LC_SUM_ASSURED() .toString());
	 * 
	 * pt_il_policy_bean.setPOL_NO_OF_UNIT(Double
	 * .parseDouble(pValList.get(0))); pt_il_policy_bean.setPOL_NEW_FC_SA(Double
	 * .parseDouble(pValList.get(1))); pt_il_policy_bean.setPOL_NEW_LC_SA(Double
	 * .parseDouble(pValList.get(2)));
	 * pt_il_policy_bean.setPOL_ORG_NEW_FC_SA(Double
	 * .parseDouble(pValList.get(3)));
	 * pt_il_policy_bean.setPOL_ORG_NEW_LC_SA(Double
	 * .parseDouble(pValList.get(4)));
	 * pt_il_policy_bean.setPOL_FC_SUM_ASSURED(Double
	 * .parseDouble(pValList.get(5)));
	 * pt_il_policy_bean.setPOL_LC_SUM_ASSURED(Double
	 * .parseDouble(pValList.get(6))); } else { if
	 * (!"016".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_END_TYPE(),
	 * "000"))) {
	 * 
	 * 
	 * pOrclValList = new ArrayList<OracleParameter>(); // 'NR' for normal and
	 * 'PG' for package policy using // menu parameter_18
	 * 
	 * if ("NR".equals(CommonUtils .getGlobalVariable("GLOBAL.M_PARAM_18")) ||
	 * CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18")==null) { pOrclValList =
	 * pkg_pilt002_apac.IL_SUM_ASURED_CAL( pt_il_policy_bean.getPOL_SYS_ID(),
	 * pt_il_policy_bean.getPOL_END_NO_IDX(),
	 * pt_il_policy_bean.getPOL_END_CODE(), pt_il_policy_bean.getPOL_END_TYPE(),
	 * pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
	 * pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
	 * pt_il_policy_bean.getPOL_SA_CURR_CODE(),
	 * pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
	 * pt_il_policy_bean.getPOL_NO_OF_UNIT(),
	 * pt_il_policy_bean.getPOL_NO_OF_INST(),
	 * pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
	 * pt_il_policy_bean.getPOL_PLAN_CODE(),
	 * pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
	 * pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
	 * dummy_bean.getUI_M_BASE_CURR(), dummy_bean.getUI_M_COVER_VAR_VALUE(),
	 * pt_il_policy_bean.getROWID(), dummy_bean.getUI_M_PROD_SA_FACTOR(),
	 * dummy_bean.getUI_M_PROD_SA_TARIFF(), dummy_bean.getUI_M_COVER_SA_CALC(),
	 * dummy_bean.getUI_M_PS_CODE(), dummy_bean.getUI_M_POL_PLAN_TYPE(),
	 * pt_il_policy_bean.getPOL_START_DT(), compositeAction
	 * .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN() .getPOAD_AGE(),
	 * dummy_bean.getUI_M_EXACT_AGE(), pt_il_policy_bean.getPOL_DEF_PERIOD_TO(),
	 * dummy_bean.getUI_M_TD_MIN_RATE(), dummy_bean.getUI_M_TD_MAX_RATE(),
	 * pt_il_policy_bean.getPOL_NEW_FC_SA(),
	 * pt_il_policy_bean.getPOL_FC_MODAL_PREM(), null, null, null, null, null,
	 * null, null, null, null, null, null); } else if ("PG".equals(CommonUtils
	 * .getGlobalVariable("GLOBAL.M_PARAM_18"))) { pOrclValList =
	 * pkg_pilt002_apac.IL_SUM_ASURED_CAL_PGC(
	 * pt_il_policy_bean.getPOL_PROD_GROUP_CODE(),
	 * dummy_bean.getUI_M_PROD_PREM_TARIFF(), pt_il_policy_bean.getPOL_SYS_ID(),
	 * pt_il_policy_bean.getPOL_END_NO_IDX(),
	 * pt_il_policy_bean.getPOL_END_CODE(), pt_il_policy_bean.getPOL_END_TYPE(),
	 * pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
	 * pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
	 * pt_il_policy_bean.getPOL_SA_CURR_CODE(),
	 * pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
	 * pt_il_policy_bean.getPOL_NO_OF_UNIT(),
	 * pt_il_policy_bean.getPOL_NO_OF_INST(),
	 * pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
	 * pt_il_policy_bean.getPOL_PLAN_CODE(),
	 * pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
	 * pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
	 * dummy_bean.getUI_M_BASE_CURR(), dummy_bean .getUI_M_COVER_VAR_VALUE(),
	 * pt_il_policy_bean.getROWID(), dummy_bean .getUI_M_PROD_SA_FACTOR(),
	 * dummy_bean .getUI_M_PROD_SA_TARIFF(), dummy_bean
	 * .getUI_M_COVER_SA_CALC(), dummy_bean .getUI_M_PS_CODE(), dummy_bean
	 * .getUI_M_POL_PLAN_TYPE(), pt_il_policy_bean.getPOL_START_DT(),
	 * compositeAction .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
	 * .getPT_IL_POL_ASSURED_DTLS_BEAN() .getPOAD_AGE(),
	 * dummy_bean.getUI_M_EXACT_AGE(), pt_il_policy_bean.getPOL_DEF_PERIOD_TO(),
	 * dummy_bean.getUI_M_TD_MIN_RATE(), dummy_bean.getUI_M_TD_MAX_RATE(),
	 * pt_il_policy_bean.getPOL_NEW_FC_SA(),
	 * pt_il_policy_bean.getPOL_FC_MODAL_PREM(), null, null, null, null, null,
	 * null, null, null, null, null, null); } if (!pOrclValList.isEmpty() &&
	 * pOrclValList != null) {
	 * 
	 * dummy_bean.setUI_M_TD_MIN_RATE((Double) (pOrclValList
	 * .get(0).getValueObject())); dummy_bean.setUI_M_TD_MAX_RATE((Double)
	 * (pOrclValList .get(1).getValueObject()));
	 * pt_il_policy_bean.setPOL_NEW_FC_SA((Double) (pOrclValList
	 * .get(2).getValueObject())); pt_il_policy_bean
	 * .setPOL_FC_MODAL_PREM((Double) (pOrclValList.get(3) .getValueObject()));
	 * pt_il_policy_bean .setPOL_FC_BASIC_PREM((Double) (pOrclValList.get(4)
	 * .getValueObject())); pt_il_policy_bean .setPOL_LC_BASIC_PREM((Double)
	 * (pOrclValList.get(5) .getValueObject())); pt_il_policy_bean
	 * .setPOL_FC_SUM_ASSURED((Double) (pOrclValList .get(6).getValueObject()));
	 * pt_il_policy_bean .setPOL_LC_SUM_ASSURED((Double) (pOrclValList
	 * .get(7).getValueObject())); pt_il_policy_bean.setPOL_FC_CURR_SA((Double)
	 * (pOrclValList .get(8).getValueObject()));
	 * pt_il_policy_bean.setPOL_LC_CURR_SA((Double) (pOrclValList
	 * .get(9).getValueObject())); pt_il_policy_bean
	 * .setPOL_ORG_NEW_LC_SA((Double) (pOrclValList .get(10).getValueObject()));
	 * pt_il_policy_bean .setPOL_ORG_NEW_FC_SA((Double) (pOrclValList
	 * .get(11).getValueObject())); pt_il_policy_bean.setPOL_NEW_LC_SA((Double)
	 * (pOrclValList .get(12).getValueObject())); pt_il_policy_bean
	 * .setPOL_FC_MON_ANNU_AMT((Double) (pOrclValList
	 * .get(13).getValueObject())); pt_il_policy_bean
	 * .setPOL_LC_MON_ANNU_AMT((Double) (pOrclValList
	 * .get(14).getValueObject())); } } } } }
	 * 
	 * if (("P".equals(dummy_bean.getUI_M_COVER_SA_CALC()) || "V"
	 * .equals(dummy_bean.getUI_M_COVER_SA_CALC())) && CommonUtils
	 * .nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0 && CommonUtils.nvl(
	 * pt_il_policy_bean.getPOL_FC_MODAL_PREM(), 0) == 0) {
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE(),
	 * pt_il_policy_bean.getPOL_MODE_OF_PYMT(),
	 * pt_il_policy_bean.getPOL_PREM_PAY_YRS() };
	 * 
	 * rs4 = handler .executeSelectStatement(query4, connection, values); if
	 * (rs4.next()) { M_PPL_LC_MIN_PREM = rs4.getDouble(1); }
	 * pt_il_policy_bean.setPOL_FC_MODAL_PREM(CommonUtils.nvl(
	 * M_PPL_LC_MIN_PREM, 0));
	 * pt_il_policy_bean.setPOL_LC_MODAL_PREM(pt_il_policy_bean
	 * .getPOL_FC_MODAL_PREM()); }
	 * 
	 * if ("S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) { if
	 * (pt_il_policy_action.getCOMP_POL_NET_PREM_YN().isDisabled() == true) {
	 * pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled( false);//
	 * ',ENABLED,PROPERTY_TRUE); } } else { if
	 * (pt_il_policy_action.getCOMP_POL_NET_PREM_YN().isDisabled() == false) {
	 * 
	 * pt_il_policy_bean.setPOL_NET_PREM_YN("N");
	 * pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled( true); //
	 * pt_il_policy_action.getCOMP_POL_NET_PREM_YN',ENABLED,PROPERTY_FALSE); } }
	 * 
	 * --added aman for fsd2-009 on 24/04/2008 --Currently plan type ¿S¿ is
	 * senebal plan which we do not use. Let us map this ¿S¿ ¿ --This may be
	 * temporary approach.
	 * 
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
	 * 
	 * rs9 = handler.executeSelectStatement(query9, connection, values); if
	 * (rs9.next()) { M_PLAN_TYPE = rs9.getString(1); } // ---ADDED BY SIVARAM
	 * FOR ANNUITY PRODUCTS if ("D".equals(M_PLAN_TYPE)) { if
	 * (!"S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) { throw new
	 * Exception(Messages.getString( PELConstants.pelErrorMessagePath, "91105",
	 * new Object[] { CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE") })); //
	 * STD_MESSAGE_ROUTINE(91105, :CTRL.M_LANG_CODE); } } if
	 * ("U".equals(M_PLAN_TYPE)) {
	 * 
	 * if (pt_il_policy_bean.getPOL_FC_MODAL_PREM() > 0) {
	 * 
	 * values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE(),
	 * pt_il_policy_bean.getPOL_MODE_OF_PYMT() };
	 * 
	 * rs8 = handler.executeSelectStatement(query8, connection, values); if
	 * (rs8.next()) { M_MAS_MOP_VALUE = rs8.getDouble(1); } pcopk_general
	 * .P_VAL_PROD_ROUND( pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
	 * M_MAS_MOP_VALUE.toString(), pt_il_policy_bean.getPOL_PROD_CODE(), "R",
	 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
	 * .getGlobalVariable("GLOBAL.M_FOR_LANG_CODE")); M_MAS_MOP_VALUE =
	 * Double.parseDouble(pValList.get(0));
	 * 
	 * if ("000".equals(CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_PROP_END_TYPE(), "000"))) {
	 * pt_il_policy_bean.setPOL_LC_MIN_PREM(CommonUtils.nvl( M_MAS_MOP_VALUE,
	 * 0)); pt_il_policy_bean.setPOL_FC_MIN_PREM(CommonUtils.nvl(
	 * M_MAS_MOP_VALUE, 0)); pt_il_policy_bean
	 * .setPOL_FC_EXTRA_PREM(pt_il_policy_bean .getPOL_FC_MODAL_PREM() -
	 * CommonUtils.nvl(pt_il_policy_bean .getPOL_FC_MIN_PREM(), 0));
	 * pt_il_policy_bean .setPOL_LC_EXTRA_PREM(pt_il_policy_bean
	 * .getPOL_LC_MODAL_PREM() - CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_LC_MIN_PREM(), 0)); } else if
	 * ("002".equals(CommonUtils.nvl(pt_il_policy_bean .getPOL_PROP_END_TYPE(),
	 * "000"))) { pt_il_policy_bean.setPOL_LC_MIN_PREM(0d);
	 * pt_il_policy_bean.setPOL_FC_MIN_PREM(0d);
	 * 
	 * pt_il_policy_bean .setPOL_FC_EXTRA_PREM(pt_il_policy_bean
	 * .getPOL_FC_MODAL_PREM() - CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_FC_MIN_PREM(), 0));
	 * 
	 * pt_il_policy_bean .setPOL_LC_EXTRA_PREM(pt_il_policy_bean
	 * .getPOL_FC_MODAL_PREM() - CommonUtils.nvl(pt_il_policy_bean
	 * .getPOL_LC_MIN_PREM(), 0)); } } } } catch (Exception e) { // TODO: handle
	 * exception e.printStackTrace(); } finally { try {
	 * CommonUtils.closeCursor(rs1); CommonUtils.closeCursor(rs2);
	 * CommonUtils.closeCursor(rs3); CommonUtils.closeCursor(rs4);
	 * CommonUtils.closeCursor(rs5); CommonUtils.closeCursor(rs6);
	 * CommonUtils.closeCursor(rs7); CommonUtils.closeCursor(rs8);
	 * CommonUtils.closeCursor(rs9); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } }
	 */

	public void POL_PYMT_TYPE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		String M_CREDIT_CARD_UPD_YN = null;
		String query1 = "SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N')  FROM MENU_USER WHERE USER_ID = ? ";
		Object[] values = {};
		Connection connection = null;
		ResultSet rs = null;

		P9ILPK_CHECK_OFF_PROPOSAL p9ilpk_check_off_proposal = new P9ILPK_CHECK_OFF_PROPOSAL();

		try {
			connection = CommonUtils.getConnection();

			if ("B".equals(currValue)) {
				pValList = p9ilpk_check_off_proposal.GEN_DEDUCTION_CODE(
						pt_il_policy_bean.getPOL_CONT_CODE(), pt_il_policy_bean
								.getPOL_FLEX_03());
				if (pValList != null && !pValList.isEmpty()) {
					if (pValList.get(0) != null) {
						pt_il_policy_bean.setPOL_FLEX_03(pValList.get(0));
					}
				}
			}

			if ("AG".equals(currValue) || "NG".equals(currValue)) {
				pt_il_policy_action.getCOMP_POL_PAYOR_SDCODE()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);
			} else {
				pt_il_policy_action.getCOMP_POL_PAYOR_SDCODE().setRequired(
						false);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						false);

				pt_il_policy_bean.setUI_M_PAYOR_CONT_NAME(null);
				pt_il_policy_bean.setPOL_PAYOR_SDCODE(null);
				pt_il_policy_bean.setUI_M_CONT_NAME(null);
				/* CHANGED BY RAJA ON 19-08-2017 FRO ZBILQC-1719674 */
				//pt_il_policy_bean.setPOL_EMPLOYER_CODE(null);
				/*END*/
			}
			if ("AD".equals(currValue) || "SC".equals(currValue)
					|| "CC".equals(currValue) || "C1".equals(currValue)
					|| "C2".equals(currValue) || "C3".equals(currValue)
					|| "C4".equals(currValue) || "C5".equals(currValue)
					|| "C6".equals(currValue)) {

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setRequired(true);
				
				/*added by raja on 15-05-2017*/
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(false);
				/*end*/

				if ("AD".equals(currValue)) {

					String label = "Customer A/C No.";
					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
							.setValue(label);
					pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue("Bank Name");
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRendered(false);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setRendered(false);
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT_LABEL()
							.setRendered(true);
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRendered(
							true);

					if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
								.setDisabled(false);
					}

					/*pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(
							true);*/

					if (pt_il_policy_bean.getROWID() != null)
						pt_il_policy_bean.setPOL_CARD_HOLDER_NAME(null);
					pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(null);
					pt_il_policy_bean.setPOL_CONT_AD_BANK_CODE(null);
					pt_il_policy_bean.setUI_M_BANK_CODE_DESC(null);
				}
			} else if ("SC".equals(currValue) || "CC".equals(currValue)
					|| "C1".equals(currValue) || "C2".equals(currValue)
					|| "C3".equals(currValue) || "C4".equals(currValue)
					|| "C5".equals(currValue) || "C6".equals(currValue)) {

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
						.setValue("Credit Card No.");
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
						.setValue(" Credit Card Merchant Clearing Bank ");
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setValue(" Credit Card Holder Name ");

				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRendered(false);
				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT_LABEL().setRendered(
						false);

				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRendered(
						true);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setRendered(true);
				/*added by raja on 15-05-2017*/
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(false);
				/*end*/
				if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
						.isRendered() == true) {

					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setDisabled(false);
				}

				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(
						true);

				values = new Object[] { CommonUtils
						.getGlobalObject("GLOBAL.M_USER_ID") };
				rs = handler.executeSelectStatement(query1, connection, values);
				while (rs.next()) {
					M_CREDIT_CARD_UPD_YN = rs.getString(1);
				}

				if ("N".equals(M_CREDIT_CARD_UPD_YN)
						&& pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO() != null) {

					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
							.setDisabled(true);
				}
			}

			if (pt_il_policy_bean.getROWID() != null) {
				pt_il_policy_bean.setPOL_AUTH_LIMIT(null);
				pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(null);
				pt_il_policy_bean.setPOL_CONT_AD_BANK_CODE(null);
				pt_il_policy_bean.setUI_M_BANK_CODE_DESC(null);
			} else if ("BS".equals(currValue)) {
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
						.setValue(" Account Holder Bank A/C No.");
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
						.setValue(" Bank Name");
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setValue(" Account Holder Name");

				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRendered(
						true);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(
						false);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setRendered(true);

				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(false);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
						.setRendered(true);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(
						false);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(
						false);
			} else {
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setRequired(false);

				if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
						.isRendered() == true) {
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRequired(false);
				}
				if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().isRendered() == true) {
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(
							false);
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(
							true);
				}
				pt_il_policy_bean.setPOL_CARD_HOLDER_NAME(null);
				pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(null);
				pt_il_policy_bean.setPOL_CONT_AD_BANK_CODE(null);
				pt_il_policy_bean.setPOL_AUTH_LIMIT(null);
				pt_il_policy_bean.setUI_M_BANK_CODE_DESC(null);
			}

			if (!"SC".equals(currValue) || !"CC".equals(currValue)
					|| !"C1".equals(currValue) || !"C2".equals(currValue)
					|| !"C3".equals(currValue) || !"C4".equals(currValue)
					|| !"C5".equals(currValue) || !"C6".equals(currValue)) {

			} else if ("SC".equals(currValue) || "CC".equals(currValue)
					|| "C1".equals(currValue) || "C2".equals(currValue)
					|| "C3".equals(currValue) || "C4".equals(currValue)
					|| "C5".equals(currValue) || "C6".equals(currValue)) {

			}
			
			/*Commentted by saritha on 14-Jun-2017 for ssp call id ZBILQC-1720514*/
			/*if ("S".equals(currValue) || "BS".equals(currValue)) {
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);
			}*/
			/*End*/
			
			/*Added by saritha on 14-Jun-2017 for ssp call id ZBILQC-1720514*/
						if(!pt_il_policy_action.getPT_IL_POLICY_BEAN().getPOL_PYMT_TYPE().equalsIgnoreCase(currValue))
			{
				pt_il_policy_bean.setPOL_EMPLOYER_CODE(null);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().resetValue();
				pt_il_policy_bean.setUI_M_CONT_NAME(null);
				pt_il_policy_action.getCOMP_UI_M_CONT_NAME().resetValue();
			}
			
			/*Modified by Janani on 27.06.2018 for FLA as per Chandramohan sugges*/
			//if (("AD".equals(currValue))||("BS".equals(currValue))&&("S".equals(currValue)))
			
			if (("AD".equals(currValue))||("BS".equals(currValue))&&("S".equals(currValue) || "AO".equals(currValue)))
				
			/*End*/	
			{
				
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(false);	
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);
				
			}
			
			else if(("A".equals(currValue))||("P".equals(currValue))){
			
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
				pt_il_policy_bean.setPOL_EMPLOYER_CODE(null);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().resetValue();
				
	
			}
			
			if (("AD".equals(currValue))||("BS".equals(currValue))){
				
			
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE_LABEL().setValue("Bank Code");
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(false);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);
				
			}
			
			/*Modified by Janani on 27.06.2018 for FLA as per Chandramohan sugges*/
			//else if("S".equals(currValue))
			
			else if("S".equals(currValue) || "AO".equals(currValue))
			{
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE_LABEL().setValue("Employer Code");	
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(false);
				
			}
		  
		  else {
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE_LABEL().setValue("Employer/Bank Code");
				
			}
			
			/*End*/
			
			/*Added by saritha on 21-11-2017 for Due date for debit order by each policy is required*/ 
			
			/*Modified by Janani on 28.06.2018 for FLA as per Chandramohan sugges*/
			//if (("AD".equals(currValue)))
			if (("AD".equals(currValue) || "AO".equals(currValue)))
			
			/*End*/	
				
			{
				pt_il_policy_action.getCOMP_POL_DEBIT_DAY().setDisabled(false);
				pt_il_policy_action.getCOMP_POL_DEBIT_DAY().setRequired(true);

			}

			else{
				pt_il_policy_action.getCOMP_POL_DEBIT_DAY().setDisabled(true);
				pt_il_policy_bean.setPOL_DEBIT_DAY(null);
				pt_il_policy_action.getCOMP_POL_DEBIT_DAY().setRequired(false);
			}
	
			/*End*/
			
			/*Added by Ameen on 12-10-2017 as per chandramohan sugg. for ZBLIFE-1447440*/
			if("N".equalsIgnoreCase(currValue)){
				throw new Exception("Choose valid Method of collection");
			}
			/*End*/
			 /* Newly Added By Dhinesh on 11-01-2018 for KIC Changes */
				 if (!CommonUtils.isIN(currValue, "AD","BS","SC")) {
					 pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(
								false);
					}
			 
			 /*Added by Ameen on 09-02-2018 for KIC to check credit and knet and handle those fields*/
			 
				 if ("SC".equalsIgnoreCase(currValue)) {
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
						.setValue("Credit Card No.");
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
								.setValue(" Credit Card Merchant Bank ");
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
								.setValue(" Credit Card Holder Name ");
						
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CARD_EXP_DT().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CVV_NO().setDisabled(false);
						
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CARD_EXP_DT().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CVV_NO().setRequired(false);
						
					}else if ("B".equalsIgnoreCase(currValue)) {
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
						.setValue("Knet Card No.");
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
								.setValue(" Knet Card Merchant Bank ");
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
								.setValue(" Knet Card Holder Name ");
						
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CARD_EXP_DT().setDisabled(false);
						pt_il_policy_action.getCOMP_POL_CVV_NO().setDisabled(false);
						
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CARD_EXP_DT().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CVV_NO().setRequired(false);
						
					}else{
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(true);
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(true);
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(true);
						pt_il_policy_action.getCOMP_POL_CARD_EXP_DT().setDisabled(true);
						pt_il_policy_action.getCOMP_POL_CVV_NO().setDisabled(true);
						
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CARD_EXP_DT().setRequired(false);
						pt_il_policy_action.getCOMP_POL_CVV_NO().setRequired(false);
					}
				 
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void POL_PYMT_TYPE_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		String M_CREDIT_CARD_UPD_YN = null;
		String query1 = "SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N') FROM MENU_USER  "
				+ " WHERE USER_ID = ? ";
		Object[] values = {};
		Connection connection = null;
		ResultSet rs = null;

		P9ILPK_CHECK_OFF_PROPOSAL p9ilpk_check_off_proposal = new P9ILPK_CHECK_OFF_PROPOSAL();

		try {
			connection = CommonUtils.getConnection();

			if ("B".equals(currValue)) {
				pValList = p9ilpk_check_off_proposal.GEN_DEDUCTION_CODE(
						pt_il_policy_bean.getPOL_CONT_CODE(), pt_il_policy_bean
								.getPOL_FLEX_03());
				pt_il_policy_bean.setPOL_FLEX_03(pValList.get(0));
			} else {
				pt_il_policy_bean.setPOL_FLEX_03(null);
			}

			if ("AG".equals(currValue) || "NG".equals(currValue)) {

				pt_il_policy_action.getCOMP_POL_PAYOR_SDCODE()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						true);
			} else {
				pt_il_policy_action.getCOMP_POL_PAYOR_SDCODE().setRequired(
						false);
				pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setRequired(
						false);

				pt_il_policy_bean.setUI_M_PAYOR_CONT_NAME(null);
				pt_il_policy_bean.setPOL_PAYOR_SDCODE(null);
				pt_il_policy_bean.setUI_M_CONT_NAME(null);
				pt_il_policy_bean.setPOL_EMPLOYER_CODE(null);
			}
			if ("AD".equals(currValue) || "SC".equals(currValue)
					|| "CC".equals(currValue) || "C1".equals(currValue)
					|| "C2".equals(currValue) || "C3".equals(currValue)
					|| "C4".equals(currValue) || "C5".equals(currValue)
					|| "C6".equals(currValue)) {

				/*
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',UPDATE_ALLOWED,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',INSERT_ALLOWED,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
				 */
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
						.setRequired(true);

				if ("AD".equals(currValue)) {

					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
							.setValue("Customer A/C No.");
					pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue("Bank Name");
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRendered(false);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setRendered(false);

					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT_LABEL()
							.setRendered(true);
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRendered(
							true);

					if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
								.setDisabled(false);
						/*
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_AUTH_LIMIT',INSERT_ALLOWED,PROPERTY_TRUE);
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_AUTH_LIMIT',UPDATE_ALLOWED,PROPERTY_TRUE);
						 */}

					/*pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(
							true);*/

					if (pt_il_policy_bean.getROWID() != null) {// :SYSTEM.RECORD_STATUS
						// ='CHANGED'
						// THEN
						pt_il_policy_bean.setPOL_CARD_HOLDER_NAME(null);
						pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(null);
						pt_il_policy_bean.setPOL_CONT_AD_BANK_CODE(null);
						pt_il_policy_bean.setUI_M_BANK_CODE_DESC(null);
					}
				} else if ("SC".equals(currValue) || "CC".equals(currValue)
						|| "C1".equals(currValue) || "C2".equals(currValue)
						|| "C3".equals(currValue) || "C4".equals(currValue)
						|| "C5".equals(currValue) || "C6".equals(currValue)) {

					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
							.setValue("Credit Card No.");
					pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue(" Credit Card Merchant Clearing Bank ");
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setValue(" Credit Card Holder Name ");

					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRendered(
							false);
					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT_LABEL()
							.setRendered(false);

					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRendered(true);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setRendered(true);

					if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.isRendered() == true) {

						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
								.setDisabled(false);

						/*
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME',INSERT_ALLOWED,PROPERTY_TRUE);
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME',UPDATE_ALLOWED,PROPERTY_TRUE);
						 */
					}

					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRequired(true);

					values = new Object[] { CommonUtils
							.getGlobalObject("GLOBAL.M_USER_ID") };
					rs = handler.executeSelectStatement(query1, connection,
							values);
					while (rs.next())
						M_CREDIT_CARD_UPD_YN = rs.getString(1);

					if ("N".equals(M_CREDIT_CARD_UPD_YN)
							&& pt_il_policy_bean.getUI_M_POL_CONT_AD_ACC_NO() != null) {
						pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
								.setRequired(false);
						/*
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',UPDATE_ALLOWED,PROPERTY_FALSE);
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',INSERT_ALLOWED,PROPERTY_FALSE);
						 */
					}
				}
				if (pt_il_policy_bean.getROWID() != null) { // SYSTEM.RECORD_STATUS
					// ='CHANGED' THEN

					pt_il_policy_bean.setPOL_AUTH_LIMIT(null);
					pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(null);
					pt_il_policy_bean.setPOL_CONT_AD_BANK_CODE(null);
					pt_il_policy_bean.setUI_M_BANK_CODE_DESC(null);
				} else if ("BS".equals(currValue)) { // -FOR BANK STANDING
					// INSTUCTION PYMT MODE

					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
							.setValue(" Account Holder Bank A/C No.");
					pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue(" Bank Name");
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setValue(" Account Holder Name");

					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRendered(true);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setDisabled(false);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setRendered(true);

					pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setRequired(
							false);

					/*
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',UPDATE_ALLOWED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',INSERT_ALLOWED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME',UPDATE_ALLOWED,PROPERTY_TRUE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME',INSERT_ALLOWED,PROPERTY_TRUE);
					 */

					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
							.setRequired(false);
					pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
							.setRequired(false);
					pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.setRequired(false);

					/*
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO().setRequired(false);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE().setRequired(false);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME().setRequired(false);
					 */
				} else {
					/*
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',UPDATE_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_POL_CONT_AD_ACC_NO',INSERT_ALLOWED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CONT_AD_BANK_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
					 */
					pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
							.setRequired(false);
					pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
							.setRequired(false);

					if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
								.setRequired(false);

						/*
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME',INSERT_ALLOWED,PROPERTY_FALSE);
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_CARD_HOLDER_NAME',UPDATE_ALLOWED,PROPERTY_FALSE);
						 */
					}
					if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
								.setRequired(false);

						/*
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_AUTH_LIMIT',INSERT_ALLOWED,PROPERTY_FALSE);
						 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_AUTH_LIMIT',UPDATE_ALLOWED,PROPERTY_FALSE);
						 */
					}
					pt_il_policy_bean.setPOL_CARD_HOLDER_NAME(null);
					pt_il_policy_bean.setUI_M_POL_CONT_AD_ACC_NO(null);
					pt_il_policy_bean.setPOL_CONT_AD_BANK_CODE(null);
					pt_il_policy_bean.setPOL_AUTH_LIMIT(null);
					pt_il_policy_bean.setUI_M_BANK_CODE_DESC(null);
				}
			}
			if (!"SC".equals(currValue) || !"CC".equals(currValue)
					|| !"C1".equals(currValue) || !"C2".equals(currValue)
					|| !"C3".equals(currValue) || !"C4".equals(currValue)
					|| !"C5".equals(currValue) || !"C6".equals(currValue)) {

				// SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_CC_LOV',VISIBLE,PROPERTY_FALSE);
			} else if ("SC".equals(currValue) || "CC".equals(currValue)
					|| "C1".equals(currValue) || "C2".equals(currValue)
					|| "C3".equals(currValue) || "C4".equals(currValue)
					|| "C5".equals(currValue) || "C6".equals(currValue)) {

				/*
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_CC_LOV',VISIBLE,PROPERTY_TRUE);
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_CC_LOV',ENABLED,
				 * PROPERTY_TRUE);
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void POL_INTRODUCER_REF_ID1_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		try {
			connection = CommonUtils.getConnection();

			if (currValue != null) {

				pValList = pkg_pilt002_apac
						.P_VAL_CLASS_CUST("BROKER", CommonUtils
								.getProcedureValue(currValue),
								pt_il_policy_bean
										.getUI_M_POL_INTRODUCER_REF_ID1_DESC(),
								PILT002_APAC_CONSTANTS.P_NAME_FLAG,
								PILT002_APAC_CONSTANTS.P_ERR_FLAG,
								pt_il_policy_bean.getPOL_DIVN_CODE());
				if (pValList != null && !pValList.isEmpty()) {
					if (pValList.get(0) != null) {
						pt_il_policy_bean
								.setUI_M_POL_INTRODUCER_REF_ID1_DESC(pValList
										.get(0));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void POL_STAFF_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs2 = null, rs1 = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		String query1 = " SELECT CCLAS_CODE FROM   PM_CUST_CLASS "
				+ " WHERE  CCLAS_TYPE IN (SELECT PM_CUST_CLASS.CCLAS_TYPE "
				+ " FROM PP_SYSTEM  WHERE PS_TYPE ='LOV_CUST'    AND PS_CODE = 'STAFF' "
				+ "   AND INSTR(PS_CODE_DESC,PM_CUST_CLASS.CCLAS_TYPE)>0) AND    ROWNUM = 1 ";

		String query2 = "  SELECT 'X'  FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_EX_SRCBUS'"
				+ " AND    PS_CODE = 'IL_EX_SRCBUS'  AND  "
				+ " INSTR (PS_CODE_DESC,? ) > 0 ";

		String delQuery1 = " DELETE FROM PT_IL_POL_BROKER_DTL  WHERE POBD_POBH_SYS_ID IN "
				+ "(SELECT POBH_SYS_ID  FROM PT_IL_POL_BROKER_HEAD "
				+ " WHERE POBH_POL_SYS_ID =? ) ";

		String delQuery2 = " DELETE FROM PT_IL_POL_BROKER_HEAD  WHERE POBH_POL_SYS_ID =?  ";

		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_SRC_OF_BUS() };
			rs2 = handler.executeSelectStatement(query2, connection, values);
			while (rs2.next()) {
				M_DUMMY = rs2.getString(1);
			}

			if ("Y".equalsIgnoreCase(currValue)) {
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setRequired(true);
				// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);

				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_BROKER_HEAD");

				handler.executeDeleteStatement(delQuery1, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				handler.executeDeleteStatement(delQuery2, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });

				rs1 = handler.executeSelectStatement(query1, connection);
				while (rs1.next()) {
					pt_il_policy_bean
							.setPOL_STAFF_CCLASS_CODE(rs1.getString(1));
				}
			} else {
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setRequired(false);
				pt_il_policy_bean.setPOL_STAFF_CCLASS_CODE(null);
				pt_il_policy_bean.setUI_M_CCLAS_CLASS_DESC(null);
				pt_il_policy_bean.setPOL_FC_DISC_AMT(0.0);
				pt_il_policy_bean.setPOL_LC_DISC_AMT(0.0);

				if ("X".equalsIgnoreCase(CommonUtils.nvl(M_DUMMY, "N"))) {
					// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);

					compositeAction.getWizard().disableWizardItem(
							"PILT002_APAC_PT_IL_POL_BROKER_HEAD");

					handler.executeDeleteStatement(delQuery1, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					handler.executeDeleteStatement(delQuery2, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });

				} else {
					// compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);

					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
					// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_BROKER_HEAD',ENABLED,PROPERTY_TRUE);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_STAFF_YN_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs2 = null, rs1 = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		String query1 = "  SELECT 'X'  FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_EX_SRCBUS'"
				+ " AND    PS_CODE = 'IL_EX_SRCBUS'  AND  "
				+ " INSTR (PS_CODE_DESC,? ) > 0 ";

		String delQuery1 = " DELETE FROM PT_IL_POL_BROKER_DTL  WHERE POBD_POBH_SYS_ID IN "
				+ "(SELECT POBH_SYS_ID  FROM PT_IL_POL_BROKER_HEAD "
				+ " WHERE POBH_POL_SYS_ID =? ) ";

		String delQuery2 = " DELETE FROM PT_IL_POL_BROKER_HEAD  WHERE POBH_POL_SYS_ID =?  ";

		String M_DUMMY = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_SRC_OF_BUS() };
			rs1 = handler.executeSelectStatement(query1, connection, values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
			}

			if ("Y".equalsIgnoreCase(currValue)) {

				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setDisabled(false);
				// SET_ITEM_PROPERTY
				// ('PT_IL_POLICY.POL_STAFF_CCLASS_CODE',NAVIGABLE,PROPERTY_TRUE);

				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					// SET_ITEM_PROPERTY
					// ('PT_IL_POLICY.POL_STAFF_CCLASS_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {

					// SET_ITEM_PROPERTY
					// ('PT_IL_POLICY.POL_STAFF_CCLASS_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
				}
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setRequired(true);
				// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_BROKER_HEAD");

				handler.executeDeleteStatement(delQuery1, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				handler.executeDeleteStatement(delQuery2, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });

			} else {

				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
						.setRequired(false);
				pt_il_policy_bean.setPOL_STAFF_CCLASS_CODE(null);
				pt_il_policy_bean.setUI_M_CCLAS_CLASS_DESC(null);

				if ("X".equalsIgnoreCase(CommonUtils.nvl(M_DUMMY, "N"))) {
					// compositeAction.getTabbedBar().setTabDisabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);

					compositeAction.getWizard().disableWizardItem(
							"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
					// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_BROKER_HEAD',ENABLED,PROPERTY_FALSE);

					handler.executeDeleteStatement(delQuery1, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					handler.executeDeleteStatement(delQuery2, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });

				} else {
					// compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_POL_BROKER_HEAD);

					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_BROKER_HEAD");
					// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_POL_BROKER_HEAD',ENABLED,PROPERTY_TRUE);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_STAFF_CCLASS_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		try {
			if ("Y".equalsIgnoreCase(pt_il_policy_bean.getPOL_STAFF_YN())) {
				pValList = pkg_pilt002_apac.P_VAL_STAFF_CLASS_CODE(currValue,
						pt_il_policy_bean.getUI_M_CCLAS_CLASS_DESC(),
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);
				pt_il_policy_bean.setUI_M_CCLAS_CLASS_DESC(pValList.get(0));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_FAC_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<String> pValList = new ArrayList<String>();
		String M_ASD_CHAR_VALUE = null;
		Integer M_POL_END_NO_IDX = 0;
		Connection connection = null;
		ResultSet rs1 = null;
		Object[] values = {};
		String query1 = " SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET" +
		"  WHERE   ASD_USER_ID =?     AND     ASD_CODE    =? AND  " +
		" ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		try {
          connection = CommonUtils.getConnection();
          if(M_POL_END_NO_IDX.equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(),0))){
          values = new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
      		    "FAC_YN", CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6") };
          
           rs1 = handler.executeSelectStatement(query1, connection, values);
           
           while (rs1.next()) {

       		M_ASD_CHAR_VALUE = rs1.getString("ASD_CHAR_VALUE");
       	    }
          }else{
        		pValList = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(CommonUtils
						.getControlBean().getM_USER_ID(), "FAC_YN",
						pt_il_policy_bean.getPOL_PROD_CODE(), "2", M_ASD_CHAR_VALUE,
						pt_il_policy_bean.getPOL_END_CODE());
        		
        		if (!pValList.isEmpty() && pValList.get(0) != null){
        			M_ASD_CHAR_VALUE = pValList.get(0);
        		}
          }

       	    if ("Y".equals(CommonUtils.nvl(M_ASD_CHAR_VALUE, "N"))) {
       		
       	   

           
			if ("Y".equalsIgnoreCase(currValue)) {
				if (!"PILT041_APAC".equalsIgnoreCase(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) {
					pt_il_policy_action.getCOMP_POL_FAC_BASIS().setDisabled(
							false);

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FAC_BASIS',NAVIGABLE,PROPERTY_TRUE);
					if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

						// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FAC_BASIS',UPDATE_ALLOWED,PROPERTY_TRUE);
					}
					pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().setDisabled(
							false);
					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_RI_POOL_CODE',NAVIGABLE,PROPERTY_TRUE);
					if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

						// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_RI_POOL_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
					}
					// TODO
					// SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_RI_POOL_CODE_LOV',ENABLED,PROPERTY_TRUE);
				}
			} else {
				pt_il_policy_action.getCOMP_POL_FAC_BASIS().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE()
						.setDisabled(true);
				// pt_il_policy_action.getCOMP_UI_M_BUT_RI_POOL_CODE_LOV().setDisabled(
				// true);
				// TODO
				// SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_RI_POOL_CODE_LOV',ENABLED,PROPERTY_FALSE);
			}
			if ("Y".equalsIgnoreCase(currValue)) {
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().setDisabled(
						false);
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().resetValue();

			} else {
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().setRequired(
						false);
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().resetValue();
			}
       	 } 
       	    else {
       	    	if("Y".equalsIgnoreCase(currValue)){
       		  pt_il_policy_bean.setPOL_FAC_YN("N");
       		  throw new Exception(" User not authorised to change FAC ");
       	    	}
       	    }

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FAC_YN_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();

		try {

			if ("Y".equalsIgnoreCase(currValue)) {
				if (!"PILT041_APAC".equalsIgnoreCase(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) {
					pt_il_policy_action.getCOMP_POL_FAC_BASIS().setDisabled(
							false);

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FAC_BASIS',NAVIGABLE,PROPERTY_TRUE);
					if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(2, 1))) {

						// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FAC_BASIS',UPDATE_ALLOWED,PROPERTY_TRUE);
					}
					pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().setDisabled(
							false);
					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_RI_POOL_CODE',NAVIGABLE,PROPERTY_TRUE);
					if ("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(2, 1))) {

						// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_RI_POOL_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
					}
					// TODO
					// SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_RI_POOL_CODE_LOV',ENABLED,PROPERTY_TRUE);
				}
			} else {
				pt_il_policy_action.getCOMP_POL_FAC_BASIS().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE()
						.setDisabled(true);
				// pt_il_policy_action.getCOMP_UI_M_BUT_RI_POOL_CODE_LOV().setDisabled(
				// true);
				// TODO
				// SET_ITEM_PROPERTY('PT_IL_POLICY.M_BUT_RI_POOL_CODE_LOV',ENABLED,PROPERTY_FALSE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void POL_FAC_BASIS_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		try {
			if ((!"A".equals(currValue) && !"B".equals(currValue))
					|| currValue == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "20326",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

			}
			if ("B".equals(currValue)) {

				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE()
						.setRequired(true);
				// :PT_IL_POLICY.POL_RI_POOL_CODE :=
				// :PT_IL_POLICY.POL_RI_POOL_CODE;
			} else if ("A".equals(currValue)) {
				pt_il_policy_action.getCOMP_POL_RI_POOL_CODE().setRequired(
						false);

				// :PT_IL_POLICY.POL_RI_POOL_CODE :=
				// :PT_IL_POLICY.POL_RI_POOL_CODE;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void POL_RI_POOL_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = "   SELECT  RPS_CODE,RPS_DESC  FROM    PM_IL_RI_POOL_SETUP"
				+ "  WHERE   RPS_CODE = ? "
				+ "   AND   ?  BETWEEN "
				+ " NVL(RPS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) "
				+ " AND NVL(RPS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))  ";
		String M_POL_RI_POOL_CODE = null;
		try {

			connection = CommonUtils.getConnection();
			values = new Object[] { currValue,
					pt_il_policy_bean.getPOL_ISSUE_DT() };
			if (currValue != null) {
				rs = handler.executeSelectStatement(query1, connection, values);
				if (rs.next()) {
					M_POL_RI_POOL_CODE = rs.getString(1);
					pt_il_policy_bean.setUI_M_POL_RI_POOL_CODE_DESC(rs
							.getString(2));
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "2210",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

					/*
					 * STD_MESSAGE_ROUTINE(2210,:CTRL.M_LANG_CODE); RAISE
					 * FORM_TRIGGER_FAILURE;
					 */
				}
			} else {
				pt_il_policy_bean.setUI_M_POL_RI_POOL_CODE_DESC(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void POL_CQS_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {

			if ("Y".equals(currValue)) {
				pt_il_policy_bean.setPOL_CQS_PERC(CommonUtils.nvl(dummy_bean
						.getUI_M_PT_CQS_PERC(), 1));
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(false);

				// SET_ITEM_PROPERTY
				// ('PT_IL_POLICY.POL_CQS_PERC',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					// SET_ITEM_PROPERTY
					// ('PT_IL_POLICY.POL_CQS_PERC',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {

					// SET_ITEM_PROPERTY
					// ('PT_IL_POLICY.POL_CQS_PERC',INSERT_ALLOWED,PROPERTY_TRUE);
				}
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setRequired(true);
			} else {
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setRequired(false);

				pt_il_policy_bean.setPOL_CQS_PERC(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void POL_CQS_YN_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		POL_CQS_YN_WHEN_VALIDATE_ITEM(compositeAction, currValue);
	}

	public void POL_CQS_PERC_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		try {
			if (currValue <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { " CQS %", "Greater than 0 " }));

				/*
				 * STD_MESSAGE_ROUTINE(91014,:GLOBAL.M_LANG_CODE,'CQS
				 * %','Greater than 0'); RAISE FORM_TRIGGER_FAILURE;
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void UI_M_POL_CONT_AD_ACC_NO_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Long currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		ArrayList<OracleParameter> pValList = null;
		try {

			pValList = pkg_pilt002_apac.P_M_POL_CONT_AD_ACC_NO_W_VAL_I(
					pt_il_policy_bean.getPOL_CUST_CODE(), currValue,
					pt_il_policy_bean.getPOL_PYMT_TYPE(), pt_il_policy_bean
							.getPOL_END_NO_IDX(), pt_il_policy_bean
							.getPOL_END_TYPE(), pt_il_policy_bean
							.getUI_M_POL_CONT_AD_ACC_NO_1());
			if (pValList != null) {
				pt_il_policy_bean
						.setUI_M_POL_CONT_AD_ACC_NO_1((Long) pValList.get(0)
								.getValueObject());

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_CONT_AD_BANK_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		String M_DUMMY = null;
		String query1 = "  SELECT DECODE(? ,'ENG',BANK_NAME,BANK_NAME_BL)  "
				+ " FROM   FM_BANK    WHERE  BANK_CODE= ? ";

		try {
			connection = CommonUtils.getConnection();

			if (currValue != null) {
				values = new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						currValue };

				rs = handler.executeSelectStatement(query1, connection, values);
				if (rs.next()) {
					pt_il_policy_bean.setUI_M_BANK_CODE_DESC(rs.getString(1));
				} else if (rs == null) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Invalid Bank . Please re-enter.." }));

				}
			}

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0
					|| "001".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {

				String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();
				if ("SC".equals(POL_PYMT_TYPE) || "AD".equals(POL_PYMT_TYPE)
						|| "CC".equals(POL_PYMT_TYPE)
						|| "C1".equals(POL_PYMT_TYPE)
						|| "C2".equals(POL_PYMT_TYPE)
						|| "C3".equals(POL_PYMT_TYPE)
						|| "C4".equals(POL_PYMT_TYPE)
						|| "C5".equals(POL_PYMT_TYPE)
						|| "C6".equals(POL_PYMT_TYPE)) {

					if (currValue == null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "Please Enter Bank code" }));

					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_CARD_HOLDER_NAME_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {

			String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();
			if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)) {

				if (currValue == null) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Please Enter the Card holder Name" }));
					/*
					 * STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Please Enter
					 * the Card holder Name'); RAISE FORM_TRIGGER_FAILURE;
					 */
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void POL_AUTH_LIMIT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			if ("AD".equals(pt_il_policy_bean.getPOL_PYMT_TYPE())) {

				if (currValue == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Please Enter Authorized Limit " }));
					/*
					 * STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Please Enter
					 * Authorized Limit'); RAISE FORM_TRIGGER_FAILURE;
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void POL_PROJECT_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		pt_il_policy_bean.setPOL_PROJECT_CODE(currValue);
		try {
			if (pt_il_policy_bean.getPOL_PROJECT_CODE() != null) {

				pValOrclList = pkg_pilt002_apac.P_VAL_CODES("IL_PROJ_CODE",
						pt_il_policy_bean.getPOL_PROJECT_CODE(),
						pt_il_policy_bean.getUI_M_PROJECT_CODE_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				if (!pValOrclList.isEmpty())
					pt_il_policy_bean.setUI_M_PROJECT_CODE_DESC(pValOrclList
							.get(0).getValue());

				pt_il_policy_action.getCOMP_POL_DEVELOPER_CODE().setDisabled(
						false);
				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_DEVELOPER_CODE',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					// pt_il_policy_action.getCOMP_POL_DEVELOPER_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {

					// pt_il_policy_action.getCOMP_POL_DEVELOPER_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
				}
			} else {
				pt_il_policy_bean.setPOL_DEVELOPER_CODE(null);
				pt_il_policy_bean.setUI_M_PROJECT_CODE_DESC(null);
				pt_il_policy_action.getCOMP_POL_DEVELOPER_CODE().setDisabled(
						true);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void POL_PROP_RECV_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {

			System.out.println("enters into POL_PROP_RECV_DT_WHEN_VALIDATE_ITEM");
			
			
			System.out.println("currValue            "+currValue);
			System.out.println("getPOL_PROP_STAMP_DT            "+pt_il_policy_bean.getPOL_PROP_STAMP_DT());
			
			/*Added by ganesh on 28-03-2018 to avoid validation for ZB suggestd by ajoy from onsite after live*/
			String IL_POL_STDT = CommonUtils.getPPSystemParameterValue("IL_POL_STDT").toString();
			
			if (currValue != null && "1".equalsIgnoreCase(IL_POL_STDT)) {
				if (currValue.after(new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80268",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
				if (pt_il_policy_bean.getPOL_PROP_STAMP_DT() != null) {

					if (pt_il_policy_bean.getPOL_PROP_STAMP_DT().after(
							currValue)) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"3206",
												/* ADDED BY RAJA ON 04-08-2017 FOR ZBILQC-1733315 */
												/*Messaged modified by ganesh on 09-11-2017 as suggested by ajoy*/
												//new Object[] { "Received date should be greater than or equal to Signed Date " }));
												new Object[] { "Received date should be greater or equal to Signed Date " }));
												/*END*/
						/*
						 * STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE, 'Received
						 * date should be less then Stamp Date'); RAISE
						 * FORM_TRIGGER_FAILURE;
						 */
					}
				}
			}
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POL_PROP_STAMP_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		Date issue_date = pt_il_policy_bean.getPOL_ISSUE_DT();
		
		try {
			
			System.out.println("enters into POL_PROP_STAMP_DT_WHEN_VALIDATE_ITEM");
			System.out.println("issue_date            "+issue_date);
			System.out.println("currValue            "+currValue);
			System.out.println("getPOL_PROP_RECV_DT            "+pt_il_policy_bean.getPOL_PROP_RECV_DT());
			
			/*Added by ganesh on 28-03-2018 to avoid validation for ZB suggestd by ajoy from onsite after live*/
			String IL_POL_STDT = CommonUtils.getPPSystemParameterValue("IL_POL_STDT").toString();		
			
			if (currValue != null && "1".equalsIgnoreCase(IL_POL_STDT)) {
				if (currValue.after(new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80268",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
				
				
				/*Added by Janani on 10.07.2017 for ZBILQC-1731112 */
				
				int duration_days =	getPropAcceptanceDuration();
				
				System.out.println("duration_days         "+duration_days);
				
				if(CommonUtils.subtractDate(issue_date, currValue) > duration_days)
				
				{
					System.out.println("value > "+duration_days+ "days");
					throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath,
									"2313",
									new Object[] {duration_days}));

				}
				
				/*End*/
				
				if (currValue.after(pt_il_policy_bean.getPOL_PROP_RECV_DT())) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											/* ADDED BY RAJA ON 04-08-2017 FOR ZBILQC-1733315 */
											/*Messaged modified by ganesh on 09-11-2017 as suggested by ajoy*/
											//new Object[] { " Signed date should be lesser than or equal to Received Date " }));
											new Object[] { " Signed date should be lesser or equal to Received Date " }));
					
											/*END*/
					
				}
					
					
					
					/*
					 * STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE, 'Stamp date
					 * should be greater then Received Date'); RAISE
					 * FORM_TRIGGER_FAILURE;
					 */
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POL_PROP_DECL_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {

			if (currValue != null) {
				if (currValue.after(new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80268",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void POL_EXC_INT_PERC_WHEN_VALIDATE_ITEM(Double currValue) {
		try {
			if (currValue != null) {
				if (!(currValue >= 0 && currValue <= 100)) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"91014", new Object[] { "Discount% ",
											">= 0", "AND <= 100" }));
					/*
					 * STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,'Discount%','>=
					 * 0','AND <= 100'); RAISE FORM_TRIGGER_FAILURE;
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void POL_LOAD_PERC_WHEN_VALIDATE_ITEM(Double currValue) {
		try {
			if (currValue != null) {
				if (!(currValue >= 0 && currValue <= 100)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Loading % ", "0", "100" }));
					/*
					 * STD_MESSAGE_ROUTINE(91014,:GLOBAL.M_LANG_CODE,'Loading
					 * %','0','100'); RAISE FORM_TRIGGER_FAILURE;
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void POL_CREDIT_DISCOUNT_PERC_WHEN_VALIDATE_ITEM(Double currValue) {
		try {

			if (currValue != null) {
				if (currValue < 0 || currValue > 100) {
					Messages.getString(PELConstants.pelErrorMessagePath,
							"91014", new Object[] { "Discount% ", ">= 0",
									"AND <= 100" });

					/*
					 * STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,'Discount%','>=
					 * 0','AND <= 100'); RAISE FORM_TRIGGER_FAILURE;
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void POL_PROP_REF_NO_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		Connection connection = null;
		ResultSet rs0 = null, rs1 = null, rs2 = null;
		Object[] values = {};
		String M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_DUMMY2 = null;

		String query0 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_PROP_REF_NO IS NOT NULL "
				+ " AND POL_CUST_CODE = ?  ";

		String query1 = " SELECT 'X'  FROM PT_IL_POLICY  "
				+ " WHERE POL_PROP_REF_NO = ? " + " AND POL_CUST_CODE = ? ";

		String query2 = " SELECT 'X' FROM PT_IL_POLICY WHERE POL_PROP_REF_NO =? ";

		try {
			connection = CommonUtils.getConnection();

			pt_il_policy_bean.getPOL_PROP_REF_NO();

			if (currValue != null) {
				values = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE() };

				rs0 = handler
						.executeSelectStatement(query0, connection, values);
				if (rs0.next()) {
					M_DUMMY1 = rs0.getString(1);

					values = new Object[] { currValue,
							pt_il_policy_bean.getPOL_CUST_CODE() };
					rs1 = handler.executeSelectStatement(query1, connection,
							values);
					if (rs1.next())
						M_DUMMY = rs1.getString(1);
					else if (rs1 == null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90015",
								new Object[] { "EPF Number" }));
					}

				} else {
					values = new Object[] { currValue };
					rs2 = handler.executeSelectStatement(query2, connection,
							values);
					if (rs2.next()) {
						M_DUMMY2 = rs2.getString(1);
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90015",
								new Object[] { "EPF Number" }));

						// STD_MESSAGE_ROUTINE(90015,:CTRL.M_LANG_CODE,'EPF
						// Number');
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs0);
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_FRZ_FLAG_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		/*Added by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_assued_action=compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_assued_bean = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();
		/*End*/
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		Double M_POC_LC_VALUE = null;
		Double M_POL_LC_FIRST_PREM = null;
		CRUDHandler handler = new CRUDHandler();
		
		/*Commentted &Modified by saritha on 10-05-2018 for KIC Query add Fund Allocation Charge*/
		
		//String C3 = "SELECT SUM(POC_LC_VALUE) FROM PT_IL_POL_CHARGE WHERE POC_POL_SYS_ID = ?";
		
		/*Modified by Janani on 23.07.2018 as per Vinoth suggstion for product feature
		 *  Total Charges must not exceed the Premium Amount*/ 
		//String C3 = "SELECT SUM(POC_LC_VALUE) FROM PT_IL_POL_CHARGE WHERE POC_APPLY_PERIOD <> 'F' AND POC_POL_SYS_ID = ?";
		
		String C3 = "SELECT SUM(POC_LC_VALUE) FROM PT_IL_POL_CHARGE WHERE POC_APPLY_PERIOD <> 'F' AND POC_POL_SYS_ID = ? AND POC_CUST_SHARE_PERC <> 0";
		
		/*End*/
		
		/*End*/
		
		String C4 = "SELECT POL_LC_FIRST_PREM FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		String C5 = "SELECT COUNT(PBEN_SYS_ID) FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ?";
		
		/*Added by Janani on 30.04.2018 for Fidelity as suggested by Vinoth*/
		
		BigDecimal ht_wt_sys_param = null;
		
		/*End*/
		
		try {
			
			
			/*Added by Janani on 30.04.2018 for Fidelity as suggested by Vinoth*/
			
			ht_wt_sys_param = (BigDecimal)CommonUtils.getPPSystemParameterValue("IL_HTWT_YN");
			
			/*End*/
			
			Connection connection = CommonUtils.getConnection();
			/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
			String POL_STATUS=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS();
			System.out.println("POL_STATUS*******************"+POL_STATUS);
			/*End*/
			/*Added by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
			Double POAD_HEIGHT=compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_HEIGHT();
			Double POAD_WEIGHT=compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_WEIGHT();
			Double POAD_BMI=compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BMI();
			/*End*/
			/*Added by Ram on 15/11/2016 for Business Rule Master Enabling*/
			String query13 = "  SELECT BREM_ERR_FLAG  FROM   PT_BUS_RULE_ERROR_MSG  WHERE  BREM_POL_SYS_ID  = ?   AND    "
					+ "    BREM_APPLY_LEVEL =?  AND BREM_GRP_ID  = 'IL'";
			
			Object[] values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(), "T" };
			ResultSet rs13 = handler.executeSelectStatement(query13, connection, values);
			String M_BREM_ERR_FLAG = null;
			System.out.println("pt_il_policy_bean.getPOL_SYS_ID()     "+pt_il_policy_bean.getPOL_SYS_ID()+" "+CommonUtils.getGlobalObject("M_POL_SYS_ID"));
			 
			/*End*/
			
			/*Added by Ameen on 14-03-2018 for kic as per Sree Ram sir sugg*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			/*End*/
			if ("Y".equals(currValue)) {
				
				/*Added by Ram on 15/11/2016 for Business Rule Master Enabling*/
				if (rs13.next()) {
					M_BREM_ERR_FLAG = rs13.getString(1);
					dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);
					 
					 if(M_BREM_ERR_FLAG != null && M_BREM_ERR_FLAG.equals("E"))
					 {
						 throw new Exception(
									"Business Rules are validated"); 
					 }
					
					
					/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"Business Rule Fired");*/
					
				} else {
					dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(true);
				/*	dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);*/
				}
				System.out.println("M_BREM_ERR_FLAG          "+M_BREM_ERR_FLAG);
				
				 
					/*End*/
				dummy_action.getCOMP_UI_M_BUT_HOLD().setDisabled(false);
				boolean pmed = checkmedstatus(compositeAction);
				/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
				if(!(POL_STATUS.equalsIgnoreCase("R")))
				{
					
				/*End*/
					
					if (pmed == true) {
						/*
						 * Commentted by Janani on 06.02.2017 
						 * 
						 * throw new Exception(
								"payor medical examination status must be yes");*/
						
						/*Changed notification by Janani on 06.02.2017 as per Girish suggestion*/
						throw new Exception(
								"All medical examinations are not yet received");
						/*end*/
						
					}
				}
				
				/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
				else{
					boolean pmedical = checkmedicalstatus(compositeAction);
					if ((pmedical == true)&&(POL_STATUS.equalsIgnoreCase("R"))){
						throw new Exception("Please undergo medical examination for re-instating the policy");		

					}
				}	
				
				 /*End*/
				
				/*Added by saritha on 04-01-2017 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
				
			  /*	if((pt_il_policy_bean.getPOL_PROP_NO() != null)&&(pt_il_policy_bean.getPOL_NO() != null)&&(pt_il_policy_bean.getPOL_END_TYPE() != null)
						    &&(pt_il_policy_bean.getPOL_END_TYPE().equals("001"))&&(pt_il_policy_bean.getPOL_FRZ_FLAG().equals("N"))){
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getCOMP_POL_LAPS_OVR_YN().setDisabled(true);	
					 
				 }
				
				if((pt_il_policy_bean.getPOL_PROP_NO() != null)&&(pt_il_policy_bean.getPOL_NO() != null)&&(pt_il_policy_bean.getPOL_END_TYPE() != null)
					    &&(pt_il_policy_bean.getPOL_END_TYPE().equals("001"))&&(pt_il_policy_bean.getPOL_FRZ_FLAG().equals("Y"))){
					 compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
					 
				 }*/
				
				 
				 /*End*/
			
				
				/* Newly Added By Dhinesh on 12-06-2017 for Change in lapsation Overriding Endorsement Issues */
				
				/*if(("001".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE()) && ("GEN008".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE())) && ("Y".equalsIgnoreCase(currValue))))
				{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);	
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
				}
				else
				{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(false);
					
				}*/
				
				/*Modified by saritha on 20-07-2017 for ssp call id ZBILQC-1732158*/
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equalsIgnoreCase("1")){
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setDisabled(true);
					
				}else{
					
					/*Commented &Modified by saritha on 03-10-2017 for Lapsation Override*/
					/*if((("001".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) && ("GEN008".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE()))))
					{*/
					
					if(("001".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) && 
							(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()).equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getLap_ovr_sys_param()))
					{
					/*End*/
						
						System.out.println("inside freez............");
						/*Added by saritha on 08-09-2017*/ 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
						
						if("Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_LAPS_OVR_YN()))
						{
							
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(false);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setDisabled(false);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setRequired(true);
							
						}
						
						else 
						{
							
							if("N".equalsIgnoreCase(CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_LAPS_OVR_YN(),"N"))){
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setDisabled(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(false);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setRequired(false);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_LAPS_OVR_FRM_DT(null);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().resetValue();
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_LAPS_OVR_TO_DT(null);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().resetValue();
						}
						}
						/*End*/
						
						if("Y".equalsIgnoreCase(pt_il_policy_bean.getPOL_FRZ_FLAG())){
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_FRM_DT().setDisabled(true);
							
							
						}else if("N".equalsIgnoreCase(pt_il_policy_bean.getPOL_FRZ_FLAG())){
							
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
						}
						
					}
					
					else {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);
						
					}
						
				}
				
				/*End*/
				
				/*Added by sankara narayanan on 28/03/2017*/
				if(!("L".equalsIgnoreCase(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())) && (!("H".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())))){
					if(("U".equalsIgnoreCase(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()))){
							if(("Y".equalsIgnoreCase(compositeAction
									.getPT_IL_POLICY_ACTION_BEAN().getPROD_RISK_FLG()))|| (new PILT002_APAC_LOCAL_PROCEDURES().L_RIDER_CHECK(pt_il_policy_bean.getPOL_SYS_ID()))){
						//end
						/*Added by saritha on 11-01-2017 for Payer Details Height and Weight &BMI is Mantatory*/
						if((pt_il_policy_bean.getPOL_FRZ_FLAG().equals("Y"))
								&&(pt_il_assued_bean.getPOAD_HEIGHT()<=0)&&(pt_il_assued_bean.getPOAD_WEIGHT()<=0)&&(pt_il_assued_bean.getPOAD_BMI()<=0))
						{
							pt_il_assued_action.getCOMP_POAD_WEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_HEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_BMI().setRequired(true);
							throw new Exception(
									"payor details Height,weight & BMI is mandatory");

						}
						else if((pt_il_policy_bean.getPOL_FRZ_FLAG().equals("Y")&&(pt_il_assued_bean.getPOAD_HEIGHT()!=null)&&(pt_il_assued_bean.getPOAD_WEIGHT()!=null)&&(pt_il_assued_bean.getPOAD_BMI()!=null))){
							pt_il_assued_action.getCOMP_POAD_WEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_HEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_BMI().setRequired(true);
						}
							}else{}
						/*Added by sankara narayanan on 28/03/2017*/
					}else{
						
						/*Added by Janani on 30.04.2018 for Fidelity as suggested by Vinoth*/
						
						if(ht_wt_sys_param != null &&  ht_wt_sys_param.equals("1"))
						{
						
						/*End*/
						if((pt_il_policy_bean.getPOL_FRZ_FLAG().equals("Y"))
								&&(pt_il_assued_bean.getPOAD_HEIGHT()<=0)&&(pt_il_assued_bean.getPOAD_WEIGHT()<=0)&&(pt_il_assued_bean.getPOAD_BMI()<=0))
						{
							pt_il_assued_action.getCOMP_POAD_WEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_HEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_BMI().setRequired(true);
							throw new Exception(
									"payor details Height,weight & BMI is mandatory");

						}
						else if((pt_il_policy_bean.getPOL_FRZ_FLAG().equals("Y")&&(pt_il_assued_bean.getPOAD_HEIGHT()!=null)&&(pt_il_assued_bean.getPOAD_WEIGHT()!=null)&&(pt_il_assued_bean.getPOAD_BMI()!=null))){
							pt_il_assued_action.getCOMP_POAD_WEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_HEIGHT().setRequired(true);
							pt_il_assued_action.getCOMP_POAD_BMI().setRequired(true);
						}
						}
					}
				}
				
				/*End*/
				
				// SET_ITEM_PROPERTY('DUMMY.M_BUT_HOLD',ENABLED,PROPERTY_TRUE);
				resultSet3 = handler.executeSelectStatement(C3, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				if (resultSet3.next()) {
					M_POC_LC_VALUE = resultSet3.getDouble(1);
					
					System.out.println("M_POC_LC_VALUE          "+M_POC_LC_VALUE+"getPOL_MODE_OF_PYMT_RATE     "+compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT_RATE());
					
					M_POC_LC_VALUE = (M_POC_LC_VALUE * compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT_RATE());
				}
				resultSet4 = handler.executeSelectStatement(C4, connection,
						new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });

				if (resultSet4.next()) {
					M_POL_LC_FIRST_PREM = resultSet4.getDouble(1);
				}
				if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0) {
					if ((M_POC_LC_VALUE == M_POL_LC_FIRST_PREM)
							|| (M_POC_LC_VALUE > M_POL_LC_FIRST_PREM)) {
						throw new Exception(
								"Total Charges must not exceed the Premium Amount.");
					}
				}
				/*benfField validation handled by Ameen on 14-03-2018 for kic as per Sree Ram sir sugg*/
				if(benfField == 0){
					resultSet5 = handler.executeSelectStatement(C5, connection,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					if (resultSet5.next()) {
						int num = resultSet5.getInt(1);
						if (0 == num) {
							String message = "No Beneficiary is Added";
							throw new Exception(message);
						}
					}
				}
				 /*End*/
				
			} else {
				dummy_action.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
				// SET_ITEM_PROPERTY('DUMMY.M_BUT_HOLD',ENABLED,PROPERTY_FALSE);
			}
			
			System.out.println("M_BREM_ERR_FLAG         "+M_BREM_ERR_FLAG);
			 if(M_BREM_ERR_FLAG != null && M_BREM_ERR_FLAG.equals("W"))
			 {
				 compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"Business Rules are Validated");
			 }
			 
			// added to throw warning if no beneficiary is there
			if(benfField != 0){
			resultSet5 = handler.executeSelectStatement(C5, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			if (resultSet5.next()) {
				int num = resultSet5.getInt(1);
				if (0 == num) {
					String message = "No Beneficiary is Added";
											
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				}
			}
			
		}
			
			/*Added by saritha on 08-Jun-2017 for ssp call id ZBILQC-1721836*/
			
			if((pt_il_policy_bean.getPOL_FRZ_FLAG().equals("Y"))&&(compositeAction.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_BUS_RULE_ERROR_MSG().size()>0))
			{
			System.out.println("inside method call------------------------");
			/*Modified by ganesh on 10-08-2017, avoid null issue on changing freeze flag */
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().businessModalPanel(compositeAction);
			/*end*/
			}
			
			/*End*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet3);
			CommonUtils.closeCursor(resultSet4);
		}

	}

	public void POL_RES_AREA_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String query1 = " SELECT PCM_CITY_CODE, PCM_STATE_CODE  FROM PM_POST_CODE_MASTER "
				+ " WHERE PCM_POSTAL_CODE =?";

		try {
			connection = CommonUtils.getConnection();

			if (currValue != null) {

				pValList = pkg_pilt002_apac.P_VAL_CODES("POSTAL", currValue,
						pt_il_policy_bean.getUI_M_POL_RES_AREA_CODE_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				pt_il_policy_bean.setUI_M_POL_RES_AREA_CODE_DESC(pValList
						.get(0).getValue());
			} else {
				pt_il_policy_bean.setUI_M_POL_RES_AREA_CODE_DESC(null);
			}
			if (currValue != null) {
				values = new Object[] { currValue };

				rs = handler.executeSelectStatement(query1, connection, values);
				if (rs.next()) {
					pt_il_policy_bean.setPOL_CITY_CODE(rs.getString(1));
					pt_il_policy_bean.setPOL_STATE_CODE(rs.getString(2));
				}
			} else {
				pt_il_policy_bean.setPOL_CITY_CODE(null);
				pt_il_policy_bean.setPOL_STATE_CODE(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_CITY_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();

		try {
			if (currValue != null) {

				pValList = pkg_pilt002_apac.P_VAL_CODES("CITY", currValue,
						pt_il_policy_bean.getUI_M_POL_CITY_NAME(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				pt_il_policy_bean.setUI_M_POL_CITY_NAME(pValList.get(0)
						.getValue());
			} else
				pt_il_policy_bean.setUI_M_POL_CITY_NAME(null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_STATE_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();

		try {
			if (currValue != null) {

				pValList = pkg_pilt002_apac.P_VAL_CODES("STATE", currValue,
						pt_il_policy_bean.getUI_M_POL_STATE_NAME(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				pt_il_policy_bean.setUI_M_POL_STATE_NAME(pValList.get(0)
						.getValue());
			} else
				pt_il_policy_bean.setUI_M_POL_STATE_NAME(null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_COUNT_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		try {
			if (currValue != null) {

				pValList = pkg_pilt002_apac.P_VAL_CODES("COUNTRY", currValue,
						pt_il_policy_bean.getUI_M_POL_COUNT_NAME(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				pt_il_policy_bean.setUI_M_POL_COUNT_NAME(pValList.get(0)
						.getValue());
			} else
				pt_il_policy_bean.setUI_M_POL_COUNT_NAME(null);

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_OFF_AREA_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		try {
			if (currValue != null) {

				pValList = pkg_pilt002_apac.P_VAL_CODES("POSTAL", currValue,
						pt_il_policy_bean.getUI_M_POSTAL_NAME(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, null);
				if (!pValList.isEmpty())
					pt_il_policy_bean.setUI_M_POSTAL_NAME(pValList.get(0)
							.getValue());
			} else
				pt_il_policy_bean.setUI_M_POSTAL_NAME(null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}

	public void POL_BASIC_RATE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = " SELECT  NVL(TAR_RATE_PER,1000)  FROM   PM_IL_TARIFF"
				+ "  WHERE  TAR_PLAN_CODE  = ? "
				+ "   AND  ? BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO"
				+ "   AND ? BETWEEN TAR_AGE_FROM AND TAR_AGE_TO"
				+ "   AND    TAR_FRZ_FLAG   = 'N'";
		try {
			connection = CommonUtils.getConnection();

			if (currValue < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71038",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

				/*
				 * STD_MESSAGE_ROUTINE(71038,NAME_IN('GLOBAL.M_LANG_CODE'));
				 * RAISE FORM_TRIGGER_FAILURE;
				 */
			}
			values = new Object[] {
					pt_il_policy_bean.getPOL_PLAN_CODE(),
					pt_il_policy_bean.getPOL_PERIOD(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE() };

			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				dummy_bean.setUI_M_TAR_RATE_PER(rs.getDouble(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_BANK_BRANCH_NAME_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		String query1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE  CUST_CODE= ? AND CUST_GROUP_CODE = ? ";
		String query2 = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE= ? ";
		String M_ASSR_NAME = null;
		String M_ASSR_BL_NAME = null;

		try {
			con = CommonUtils.getConnection();
			if (!("C".equalsIgnoreCase(pt_il_policy_bean.getPOL_GRANTEE_TYPE()))) {
				if (pt_il_policy_bean.getPOL_BANK_BRANCH_NAME() != null) {

					Object[] values1 = { currValue,
							pt_il_policy_bean.getPOL_CUST_CODE() };
					rs1 = handler.executeSelectStatement(query1, con, values1);
					if (rs1.next()) {
						M_ASSR_NAME = rs1.getString(1);
						pt_il_policy_bean.setUI_M_BANK_CODE_DESC(M_ASSR_NAME);
					} else {
						pt_il_policy_bean.setUI_M_BRANCH_CODE_DESC(null);
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "Not a Valid Branch" }));
					}

				} else {
					Object[] values2 = { currValue };
					rs2 = handler.executeSelectStatement(query2, con, values2);
					if (rs2.next()) {
						M_ASSR_NAME = rs2.getString(2);
						pt_il_policy_bean.setUI_M_BANK_CODE_DESC(M_ASSR_NAME);
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "Not a Valid Customer Code" }));

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void POL_FC_BASIC_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		try {

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_BASIC_PREM(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean.setPOL_LC_BASIC_PREM(pt_il_policy_bean
					.getPOL_FC_BASIC_PREM()
					* pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_BASIC_PREM().toString(), "R", pt_il_policy_bean
					.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_BASIC_PREM(Double.parseDouble(pValList
					.get(0)));

			/*
			 * P_VAL_ROUND_AMT (:DUMMY.M_BASE_CURR,
			 * :PT_IL_POLICY.POL_LC_BASIC_PREM, 'R');
			 */

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_OCC_RATE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = "SELECT NVL((:PT_IL_POLICY.M_POL_LC_GR_ANN_PREM /  "
				+ " DECODE(:PT_IL_POLICY.POL_MODE_OF_PYMT, 'S',1,'Y', 1, 'S', 1, 'H', 2, 'Q', 4, 'M', 12)),0),"
				+ " NVL((:PT_IL_POLICY.M_POL_FC_GR_ANN_PREM /"
				+ " DECODE(:PT_IL_POLICY.POL_MODE_OF_PYMT, 'S',1,'Y', 1, 'S', 1, 'H', 2, 'Q', 4, 'M', 12)),0)"
				+ "   FROM   DUAL    ";
		String query2 = "  SELECT NVL(SUM(POC_LC_VALUE),0),NVL(SUM(POC_FC_VALUE),0) "
				+ " FROM   PT_IL_POL_CHARGE WHERE  POC_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID ";
		String query3 = "     SELECT NVL(SUM(POD_LC_VALUE),0),NVL(SUM(POD_FC_VALUE),0) "
				+ " FROM   PT_IL_POL_DISCOUNT  WHERE  POD_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID;	 ";
		try {
			connection = CommonUtils.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_HEALTH_RATE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = " SELECT NVL((? / "
				+ "  DECODE(:PT_IL_POLICY.POL_MODE_OF_PYMT, 'S',1,'Y', 1, 'S', 1, 'H', 2, 'Q', 4, 'M', 12)),0),"
				+ "  NVL((:PT_IL_POLICY.M_POL_FC_GR_ANN_PREM /"
				+ " DECODE(:PT_IL_POLICY.POL_MODE_OF_PYMT, 'S',1,'Y', 1, 'S', 1, 'H', 2, 'Q', 4, 'M', 12)),0)"
				+ "   FROM   DUAL    ";
		String query2 = "   SELECT NVL(SUM(POC_LC_VALUE),0), NVL(SUM(POC_FC_VALUE),0) "
				+ " FROM   PT_IL_POL_CHARGE   WHERE  POC_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID	 ";

		String query3 = "    SELECT NVL(SUM(POD_LC_VALUE),0),NVL(SUM(POD_FC_VALUE),0) "
				+ "   FROM   PT_IL_POL_DISCOUNT  WHERE  POD_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID ";
		try {

			connection = CommonUtils.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_END_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null, rs25 = null, rs6 = null, rs7 = null, rs8 = null, rs9 = null, rs10 = null, rs11 = null, rs12 = null, rs13 = null, rs14 = null, rs15 = null, rs16 = null, rs19 = null, rs23 = null, rs17 = null, rs18A = null, rs18B = null, rs20 = null, rs21 = null, rs22 = null, rs_SURR_YRS = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();

		String M_SURR_YN = null;
		String M_PYMT_MAT_YN = null;
		String M_PLAN_REVIVAL_YN = null;
		String M_PLAN_SPL_REVIVAL_YN = null;
		String M_PROD_JOINT_LIFE_YN = null;
		Double M_PS_VALUE = 0d;
		Double M_DUMMY = 0d;
		Double M_END_DUMMY = 0d;
		String M_CHAR_CODE = null;
		String M_CANCEL_POL = null;
		String M_EAS_END_PROC_YN = null;
		String M_END_TYPE = null;

		String query1 = " SELECT DS_DESC FROM   PM_IL_DOC_SETUP WHERE  DS_TYPE = '3' "
				+ "  AND    DS_FRZ_FLAG = 'N'  AND   DS_CODE = ? ";

		String query2 = " SELECT DS_END_TYPE   FROM   PM_IL_DOC_SETUP   WHERE  DS_TYPE = '3' "
				+ " AND    DS_FRZ_FLAG = 'N'   AND    DS_CODE = ?  ";

		String query3 = " SELECT PLAN_SURR_YN , PLAN_PYMT_ON_MAT_YN,"
				+ " FROM   PM_IL_PLAN  WHERE  PLAN_CODE = ? "
				+ " AND    PLAN_FRZ_FLAG = 'N'     AND   "
				+ " ? BETWEEN PLAN_PERIOD_FROM AND PLAN_PERIOD_TO"
				+ "  AND    ? BETWEEN PLAN_AGE_FROM AND PLAN_AGE_TO ";
		String query_SURR_YRS = "  SELECT NVL(PLAN_SURR_YRS, 0)  FROM   PM_IL_PLAN"
				+ "   WHERE  PLAN_CODE = ? ";

		String query4 = "  SELECT PLAN_REVIVAL_YN,PLAN_SPL_REVIVAL_YN   FROM   PM_IL_PLAN"
				+ "   WHERE  PLAN_CODE =? ";

		String query5 = " SELECT PLAN_SPL_REVIVAL_YN    FROM   PM_IL_PLAN "
				+ "   WHERE  PLAN_CODE = ?    ";
		String query6 = "SELECT NVL(PLAN_SA_INST_PYMT_YN,'N')   FROM   PM_IL_PLAN  "
				+ "  WHERE  PLAN_CODE =?  ";
		String query7 = " SELECT COUNT(*)   FROM   PT_IL_SURR_MAT_VALUES "
				+ "   WHERE  SMV_POL_SYS_ID = ?  AND    SMV_TYPE = 'R'";

		String query8 = "  SELECT  ASD_CHAR_VALUE    FROM    PM_IL_APPR_SETUP_DET WHERE   "
				+ " ASD_USER_ID = ?   AND     ASD_CODE    = ?  "
				+ " AND    ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') "
				+ " AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')   ";

		String query9 = "  SELECT PS_VALUE   FROM   PP_SYSTEM  WHERE  PS_TYPE='IL_END_TYP' "
				+ "  AND    PS_CODE='006'";

		String query10 = "  SELECT COUNT(*)    FROM   PH_IL_POLICY  WHERE "
				+ " POLH_SYS_ID= ? AND  POLH_O_END_TYPE='006' ";

		String query12 = "  SELECT NVL(EAS_END_PROC_YN,'N')  FROM   PM_IL_END_APPR_SETUP "
				+ "  WHERE  EAS_AS_USER_ID =?   "
				+ "  AND  ? BETWEEN EAS_AS_FM_PROD_CODE "
				+ " AND EAS_AS_TO_PROD_CODE    AND   ? "
				+ " BETWEEN NVL(EAS_FM_END_CODE,'0') AND NVL(EAS_TO_END_CODE,'zzzzzzzzzzzz') ";

		String query13 = "SELECT DS_RECVR_MEDFEE_YN    FROM   PM_IL_DOC_SETUP  "
				+ "  WHERE  DS_CODE =?  AND    DS_TYPE = '3'  "
				+ " AND    DS_END_TYPE = '009' ";

		String query14 = " SELECT DET_END_TEXT   FROM   PM_IL_DOC_END_TEXT   WHERE"
				+ "  DET_PROD_CODE = ?   AND    "
				+ " DET_DS_CODE =?  AND    DET_DS_TYPE   ='3'    ";

		String query15 = " SELECT PROD_SA_BY_PLAN_BASIS_YN   FROM PM_IL_PRODUCT  "
				+ " WHERE PROD_CODE=? ";

		String query16 = " SELECT PS_CODE  FROM   PP_SYSTEM   WHERE PS_TYPE ='IL_SUBPLAN'";

		String query17 = "SELECT PS_VALUE  FROM PP_SYSTEM WHERE PS_TYPE = 'INCSA_BKDAY'";

		String query18A = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_INC_SA'";

		String query18B = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_DEC_SA'";

		String query19 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'ILCHNGADDR'";

		String query20 = " SELECT 'X' FROM PT_IL_POL_DISC_LOAD WHERE PDL_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID";

		String query21 = " SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL"
				+ "WHERE PC_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID"
				+ "AND   PC_PAID_FLAG = 'A'" + "AND   PC_PAID_DT IS NOT NULL";

		String query22 = "SELECT MONTHS_BETWEEN(:PT_IL_POLICY.POL_LAST_INST_DT, M_MAX_PC_SCHD_PYMT_DT) FROM DUAL";

		String query23 = "SELECT ESD_CHAR_VALUE FROM PM_IL_END_SETUP_DET WHERE ESD_USER_ID = ?"
				+ "AND ESD_CODE =  'POL_RED_INST' ";

		String query25 = "SELECT POLH_N_END_TYPE FROM PH_IL_POLICY WHERE POLH_SYS_ID=?";

		String query26 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";

		String query27 = "SELECT 'X' FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = ?";

		String query28 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = ? AND NVL(POL_END_TYPE,'000') IN ('002','006','007','012','013','020')";
		ResultSet rs26 = null;
		ResultSet rs27 = null;
		ResultSet rs28 = null;
		String m_plan_type = null;

		String M_INCSA_CODE = null;
		String M_DECSA_CODE = null;
		String M_PS_CODE_1 = null;
		Integer M_REM_MONTHS = null;
		Date M_MAX_PC_SCHD_PYMT_DT = null;
		String M_DISC_AVAIL = null;
		String M_ESD_CHAR_VALUE = null;
		String M_PROD_SA_BY_PLAN_BASIS_YN = null;
		String M_PS_CODE = null;
		String M_C17PS_VALUE = null;
		String M_CHAR = null;
		String M_ENDO_CHAR = null;
		pt_il_policy_bean.setPOL_END_CODE(currValue);
		List<String> endolist = new ArrayList<String>();
		try {
			connection = CommonUtils.getConnection();

			rs26 = handler.executeSelectStatement(query26, connection,
					new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() });
			if (rs26.next()) {
				m_plan_type = rs26.getString(1);
			}
			// CURSOR C8(M_CHAR_CODE IN VARCHAR2) IS

			if (currValue != null) {

				values = new Object[] {
						CommonUtils.getControlBean().getM_USER_ID(),
						pt_il_policy_bean.getPOL_PROD_CODE(), currValue };

				rs12 = handler.executeSelectStatement(query12, connection,
						values);
				if (rs12.next()) {
					M_EAS_END_PROC_YN = rs12.getString(1);
				}
				if (CommonUtils.nvl(M_EAS_END_PROC_YN, "N").equals("N")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91564",
							new Object[] {
							/*
							 * CommonUtils
							 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
							 */
							CommonUtils.getControlBean().getM_USER_ID() }));
				}
				rs19 = handler.executeSelectStatement(query19, connection);
				if (rs19.next()) {
					M_PS_CODE_1 = rs19.getString(1);
				}
				if (pt_il_policy_bean.getPOL_END_CODE().equalsIgnoreCase(
						M_PS_CODE_1)) {
					/*
					 * :PT_IL_POLICY.POL_RTS_YN := 'N';
					 * :PT_IL_POLICY.POL_RTS_DATE := NULL;
					 * :PT_IL_POLICY.POL_RTS_REASON := NULL;
					 * :PT_IL_POLICY.POL_RTS_TYPE_OF_CORR := NULL;
					 */
				}

				if (currValue != null) {
					values = new Object[] { currValue };

					rs13 = handler.executeSelectStatement(query13, connection,
							values);
					if (rs13.next()) {
						pt_il_policy_bean.setPOL_MED_FEE_RECOVER_YN(rs13
								.getString(1));
					}

				}
				if (currValue != null) {
					values = new Object[] {
							pt_il_policy_bean.getPOL_PROD_CODE(), currValue };
					rs14 = handler.executeSelectStatement(query14, connection,
							values);
					if (rs14.next()) {
						pt_il_policy_bean.setPOL_END_DESC(rs14.getString(1));
					} else if (rs14 == null) {
						pt_il_policy_bean.setPOL_END_DESC(null);
					}
				}
				if (currValue != null) {
					values = new Object[] { pt_il_policy_bean
							.getPOL_PROD_CODE() };
					rs15 = handler.executeSelectStatement(query15, connection,
							values);
					if (rs15.next()) {
						M_PROD_SA_BY_PLAN_BASIS_YN = rs15.getString(1);
					}
					rs16 = handler.executeSelectStatement(query16, connection);
					if (rs16.next()) {
						M_PS_CODE = rs16.getString(1);
					}

					if (currValue.equals(CommonUtils.nvl(M_PS_CODE, "N"))
							&& !"Y".equals(CommonUtils.nvl(
									M_PROD_SA_BY_PLAN_BASIS_YN, "N"))) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91954",
								new Object[] {
								/*
								 * CommonUtils
								 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
								 */
								currValue }));
					}
				}

				values = new Object[] { currValue };
				rs1 = handler
						.executeSelectStatement(query1, connection, values);
				if (rs1.next()) {
					pt_il_policy_bean.setUI_M_POL_END_CODE_DESC(rs1
							.getString(1));
				}
				values = new Object[] { pt_il_policy_bean.getPOL_END_CODE() };
				rs2 = handler
						.executeSelectStatement(query2, connection, values);
				if (rs2.next()) {
					pt_il_policy_bean.setPOL_END_TYPE(rs2.getString(1));
				}
				
				/*plan_type = "U" Commentted by saritha on 27-11-2017 as suggested by Ajoy sir*/
				if (currValue != null) {
					if ("012".equalsIgnoreCase(pt_il_policy_bean
							.getPOL_END_TYPE())) {
						if (("B".equalsIgnoreCase(m_plan_type))
								/*|| ("U".equalsIgnoreCase(m_plan_type))*/) {
							throw new Exception(
									"Alteration in Term is not applicable for this policy");
						}
					}
				}
				/*End*/
				
				if (rs1 == null) {
					dummy_bean.setUI_M_CHECK_FLAG("Y");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71059",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

				}

				if ("006".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))
						|| "020".equalsIgnoreCase(CommonUtils.nvl(
								pt_il_policy_bean.getPOL_END_TYPE(), "000"))) {
					if ("I08".equalsIgnoreCase(pt_il_policy_bean
							.getPOL_ADDL_STATUS())
							|| "I09".equalsIgnoreCase(pt_il_policy_bean
									.getPOL_ADDL_STATUS())) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71059",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
						// STD_MESSAGE_ROUTINE(3206,NAME_IN('GLOBAL.M_LANG_CODE'),'Policy
						// is already Fully paid');
					}

					rs23 = handler.executeSelectStatement(query23, connection,
							new Object[] { CommonUtils.getControlBean()
									.getM_USER_ID() });
					if (rs23.next()) {
						M_ESD_CHAR_VALUE = rs23.getString(1);
					}
					if (CommonUtils.nvl(M_ESD_CHAR_VALUE, "N")
							.equalsIgnoreCase("N")
							&& CommonUtils
									.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(), "N")
									.equalsIgnoreCase("L02")) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"92287",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
						// STD_MESSAGE_ROUTINE(92287,NAME_IN('GLOBAL.M_LANG_CODE'));
					}
				}

				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
				rs6 = handler
						.executeSelectStatement(query6, connection, values);
				if (rs6.next()) {
					M_PROD_JOINT_LIFE_YN = rs6.getString(1);
				}

				if (M_PROD_JOINT_LIFE_YN.equals("Y")
						&& CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(),
								"000").equals("012")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91131",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}

				if ((CommonUtils.nvl(pt_il_policy_bean.getPOL_STATUS(), "A")
						.equalsIgnoreCase("L") || CommonUtils.nvl(
						pt_il_policy_bean.getPOL_STATUS(), "A")
						.equalsIgnoreCase("Q"))
						&& !(CommonUtils
								.isIN(CommonUtils.nvl(pt_il_policy_bean
										.getPOL_END_TYPE(), "000"), "001",
										"006", "020"))) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] {
											/*
											 * CommonUtils
											 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
											 */
											"Policy Lapsed cannot pass Financial Endorsement" }));
				}

				if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000")
						.equals("009")) {

					values = new Object[] {
							CommonUtils.getControlBean().getM_USER_ID(),
							"CANCEL_POL", pt_il_policy_bean.getPOL_PROD_CODE() };

					rs8 = handler.executeSelectStatement(query8, connection,
							values);
					if (rs8.next()) {
						M_CANCEL_POL = rs8.getString(1);
					}

					if (CommonUtils.nvl(M_CANCEL_POL, "N").equals("N")) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] {
								/*
								 * CommonUtils
								 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
								 */
								"User not authorised to cancel this Policy" }));
					}
					// --ADDED FOR PRFM-FSD-008-STM ON 06/11/2007 BY AMAN
					// -- FOR MEDICAL FEES RECOVERY AT THE TIME OF POLICY
					// CANCELLATION
					pt_il_policy_action.getCOMP_POL_MED_FEE_RECOVER_YN()
							.setDisabled(false);
					if ("Y".equals(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
						pt_il_policy_action.getCOMP_POL_MED_FEE_RECOVER_YN()
								.setDisabled(false);
						// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',INSERT_ALLOWED
						// ,PROPERTY_TRUE);
					}
					if ("Y".equals(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						pt_il_policy_action.getCOMP_POL_MED_FEE_RECOVER_YN()
								.setDisabled(false);
						// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',UPDATEABLE
						// ,PROPERTY_TRUE);
					}
					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',NAVIGABLE
					// ,PROPERTY_TRUE);
				} else {
					pt_il_policy_action.getCOMP_POL_MED_FEE_RECOVER_YN()
							.setDisabled(true);
					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',ENABLED
					// ,PROPERTY_FALSE);
					/*
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',INSERT_ALLOWED
					 * ,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',UPDATEABLE
					 * ,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_MED_FEE_RECOVER_YN',NAVIGABLE
					 * ,PROPERTY_FALSE);
					 */
				}

				if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000")
						.equals("002")) {
					values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
					rs7 = handler.executeSelectStatement(query7, connection,
							values);
					if (rs7.next()) {
						M_DUMMY = rs7.getDouble(1);
					}

					if (M_DUMMY > 0) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"91134",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					}
				}
			}
			if (currValue != null) {
				if (pt_il_policy_bean.getPOL_STATUS().equals("P")) {
					/*
					 * modified by Ameen on 21-11-2017 to put REIN end. for paidup policies.
					 * if (!"003".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))
							|| !"006".equals(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_END_TYPE(), "000"))) {*/ // --
					/*Modified if condtion by ganesh on 08-12-2017 as suggested by ajoy*/
					/*if(!CommonUtils.isIN(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000"), "003","006")){*/
					if(!CommonUtils.isIN(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000"), "003","006") && !CommonUtils.isIN(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(), "XXX"), "DMWP")){
						// Modified
						// on
						// 09-NOV-99
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71133",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
						// -- to Incl '006'(Re-Instatement).
					}
				}
			}

			if (currValue != null) {
				if (pt_il_policy_bean.getPOL_STATUS().equals("P")) {
					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(),
							"000").equals("003")) {
						pt_il_policy_bean.setUI_M_SURR_MAT("S");
						// -- SET_ITEM_PROPERTY('M_SURR_MAT', ENABLED,
						// PROPERTY_FALSE);
						// -- SET_ITEM_PROPERTY('M_SURR_MAT',ENABLED,
						// PROPERTY_FALSE);
					}
				}
			}

			if (currValue != null) {
				if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000")
						.equals("003")) {
					// ---- Changed after Mods in plan master.
					values = new Object[] { pt_il_policy_bean
							.getPOL_PLAN_CODE() };
					rs_SURR_YRS = handler.executeSelectStatement(
							query_SURR_YRS, connection, values);
					if (rs_SURR_YRS.next()) {
						dummy_bean.setUI_M_ENDT_PS_VALUE(rs_SURR_YRS
								.getDouble(1));
					}
					values = new Object[] {
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_PERIOD(),
							pt_il_pol_assured_dtls_bean.getPOAD_AGE() };
					rs3 = handler.executeSelectStatement(query3, connection,
							values);
					if (rs3.next()) {
						M_SURR_YN = rs3.getString(1);
						M_PYMT_MAT_YN = rs3.getString(2);
					}

					if (CommonUtils.nvl(M_SURR_YN, "N").equals("Y")) {
						if (CommonUtils.nvl(pt_il_policy_bean
								.getPOL_NO_YRS_PREM_PAID(), 0) < dummy_bean
								.getUI_M_ENDT_PS_VALUE()) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "71069",
									new Object[] {
									/*
									 * CommonUtils
									 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
									 */
									dummy_bean.getUI_M_ENDT_PS_VALUE() }));
							// STD_MESSAGE_ROUTINE(71069,NAME_IN('GLOBAL.M_LANG_CODE'),TO_CHAR(:DUMMY.M_ENDT_PS_VALUE));
						} else {
							// -- SET_ITEM_PROPERTY('M_SURR_MAT', ENABLED,
							// PROPERTY_TRUE);
							// -- SET_ITEM_PROPERTY('M_SURR_MAT',
							// NAVIGABLE,PROPERTY_TRUE);
							// --SET_RADIO_BUTTON_PROPERTY('M_SURR_MAT','M_RB_SURR',
							// ENABLED, PROPERTY_TRUE);
							// -- SET_ITEM_PROPERTY('M_SURR_MAT',ENABLED,
							// PROPERTY_TRUE);
							pt_il_policy_bean.setUI_M_SURR_MAT("S");
							// --SET_RADIO_BUTTON_PROPERTY('M_SURR_MAT','M_RB_PAIDUP',ENABLED,
							// PROPERTY_TRUE);
							// ----
							// SET_RADIO_BUTTON_PROPERTY('M_SURR_MAT','M_RB_PAIDUP',NAVIGABLE,PROPERTY_TRUE);
						}
					} else {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71068",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					}
				} else {
					// null;
					// -- SET_ITEM_PROPERTY('M_SURR_MAT', ENABLED,
					// PROPERTY_FALSE);

				}
			}
			if (pt_il_policy_bean.getPOL_END_CODE() != null) {
				if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000")
						.equals("004")) {

					values = new Object[] {
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_PERIOD(),
							pt_il_pol_assured_dtls_bean.getPOAD_AGE() };
					rs3 = handler.executeSelectStatement(query3, connection,
							values);
					if (rs3.next()) {
						M_SURR_YN = rs3.getString(1);
						M_PYMT_MAT_YN = rs3.getString(2);
					}
					/*
					 * IF C3%NOTFOUND THEN NULL; END IF;
					 */
					if (!"Y".equals(CommonUtils.nvl(M_PYMT_MAT_YN, "N"))) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71087",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

					}
				}
			}

			if (currValue != null) {
				if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000")
						.equals("006")) { // --ASHOK KUMAR

					values = new Object[] { pt_il_policy_bean
							.getPOL_PLAN_CODE() };
					rs4 = handler.executeSelectStatement(query4, connection,
							values);
					if (rs4.next()) {
						M_PLAN_REVIVAL_YN = rs4.getString(1);
					}

					if (CommonUtils.nvl(M_PLAN_REVIVAL_YN, "N").equals("N")) {

						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"91096",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					}
					rs9 = handler.executeSelectStatement(query9, connection);
					if (rs9.next()) {
						M_PS_VALUE = rs9.getDouble(1);
					}
					values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
					rs10 = handler.executeSelectStatement(query10, connection,
							values);
					if (rs10.next()) {
						M_END_DUMMY = rs10.getDouble(1);
					}

					if (CommonUtils.nvl(M_END_DUMMY, 0) >= CommonUtils.nvl(
							M_PS_VALUE, 0)) {

						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"91387",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

					}

					if ("S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
							|| "A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
						if (!"C".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_STATUS(), "X"))
								|| !"S"
										.equals(CommonUtils.nvl(
												pt_il_policy_bean
														.getPOL_STATUS(), "X"))) {
							throw new Exception(
									Messages
											.getString(
													PELConstants.pelErrorMessagePath,
													"71142",
													new Object[] { CommonUtils
															.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
						}
					} else {
						if (!CommonUtils.isIN(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_STATUS(), "X"), "C", "P", "L")) {// THEN
							// Modified on 09-NOV-99 to Incl 'P'(Paid-Up).
							/*modified and pup handled by gopi as suggested by siva sir on 23/01/18*/
							if(!pt_il_policy_bean.getPOL_ADDL_STATUS().equalsIgnoreCase("PUP"))
							{
							throw new Exception(
									Messages
											.getString(
													PELConstants.pelErrorMessagePath,
													"71142",
													new Object[] { CommonUtils
															.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
							}
							//end
						}
					}
				}
			}

			if (pt_il_policy_bean.getPOL_END_CODE() != null) {
				if (pt_il_policy_bean.getPOL_END_DT() == null) {
					pt_il_policy_bean.setPOL_END_DT(new CommonUtils()
							.getCurrentDate());
				}
			}
			if (pt_il_policy_bean.getPOL_END_CODE() != null
					&& "010".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_CODE(), "000"))) {
				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
				rs5 = handler
						.executeSelectStatement(query5, connection, values);
				if (rs5.next()) {
					M_PLAN_SPL_REVIVAL_YN = rs5.getString(1);
				}

				if (CommonUtils.nvl(M_PLAN_SPL_REVIVAL_YN, "N").equals("N")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91097",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}

			rs18A = handler.executeSelectStatement(query18A, connection);
			if (rs18A.next()) {
				M_INCSA_CODE = rs18A.getString(1);
			}
			rs18B = handler.executeSelectStatement(query18A, connection);
			if (rs18B.next()) {
				M_DECSA_CODE = rs18B.getString(1);
			}

			/*
			 * if(pt_il_policy_bean.getPOL_END_CODE()!=null) {
			 * P_REINS_REDATE_VAL(pt_il_policy_bean) ; }
			 */

			// :DUMMY.M_POL_ORG_LC_INST_PREM :=
			// :PT_IL_POLICY.M_POL_INST_FC_PREM;
			rs25 = handler.executeSelectStatement(query25, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			if (rs25.next()) {
				M_END_TYPE = rs25.getString(1);
				endolist.add(M_END_TYPE);
			}
			if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0) {
				if ("020".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {
					if (endolist.contains(pt_il_policy_bean.getPOL_END_TYPE()))
					// if("020".equalsIgnoreCase(M_END_TYPE))
					{
						throw new Exception(
								"Special Revival Endorsement already passed for this policy");
					}
				}
			}
			if ("020".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {
				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
				rs5 = handler
						.executeSelectStatement(query5, connection, values);
				if (rs5.next()) {
					M_PLAN_SPL_REVIVAL_YN = rs5.getString(1);
				}

				if (CommonUtils.nvl(M_PLAN_SPL_REVIVAL_YN, "N").equals("N")) {
					throw new Exception(
							"Special Revival Endorsement is not applicable for this Plan");
				}
			}
			
			/*commented by raja on 23-05-2017 for ZBILQC-1727275*/

			/*if ("012".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {
				rs27 = handler.executeSelectStatement(query27, connection,
						new Object[] { pt_il_policy_bean.getPOL_NO() });
				if (rs27.next()) {
					M_CHAR = rs27.getString(1);
				}

				rs28 = handler.executeSelectStatement(query28, connection,
						new Object[] { pt_il_policy_bean.getPOL_NO() });
				if (rs28.next()) {
					M_ENDO_CHAR = rs28.getString(1);
				}
				if (("X".equalsIgnoreCase(CommonUtils.nvl(M_ENDO_CHAR, "N")))
						|| "X".equalsIgnoreCase(CommonUtils.nvl(M_CHAR, "N"))) {
					throw new Exception(
							"Alteration in Term Endorsement is not applicable");
				}
			}
*/
			
			/*end*/
			
			if ("020".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {
				rs27 = handler.executeSelectStatement(query27, connection,
						new Object[] { pt_il_policy_bean.getPOL_NO() });
				if (rs27.next()) {
					M_CHAR = rs27.getString(1);
				}

				rs28 = handler.executeSelectStatement(query28, connection,
						new Object[] { pt_il_policy_bean.getPOL_NO() });
				if (rs28.next()) {
					M_ENDO_CHAR = rs28.getString(1);
				}
				if (("X".equalsIgnoreCase(CommonUtils.nvl(M_ENDO_CHAR, "N")))
						|| "X".equalsIgnoreCase(CommonUtils.nvl(M_CHAR, "N"))) {
					throw new Exception(
							"Special Revival Endorsement is not applicable");
				}
			}
			
			/* Newly Added By Dhinesh on 12-06-2017 for Change in lapsation Overriding Endorsement Issues */
			
			/*if(("001".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE()) && "GEN008".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE())))
					{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(false);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(false);
					}else
					{
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_YN().setDisabled(true);	
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LAPS_OVR_DT().setDisabled(true);
					}	*/
			
			/* End */
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs6);
				CommonUtils.closeCursor(rs7);
				CommonUtils.closeCursor(rs8);
				CommonUtils.closeCursor(rs9);
				CommonUtils.closeCursor(rs10);
				CommonUtils.closeCursor(rs11);
				CommonUtils.closeCursor(rs12);
				CommonUtils.closeCursor(rs13);
				CommonUtils.closeCursor(rs14);
				CommonUtils.closeCursor(rs15);
				CommonUtils.closeCursor(rs16);
				CommonUtils.closeCursor(rs_SURR_YRS);
				CommonUtils.closeCursor(rs17);
				CommonUtils.closeCursor(rs18A);
				CommonUtils.closeCursor(rs18B);
				CommonUtils.closeCursor(rs19);
				CommonUtils.closeCursor(rs20);
				CommonUtils.closeCursor(rs21);
				CommonUtils.closeCursor(rs22);
				CommonUtils.closeCursor(rs23);
				CommonUtils.closeCursor(rs27);
				CommonUtils.closeCursor(rs28);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_END_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue)
			throws Exception {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs1 = null, rs2 = null, rs2_2 = null, rs2_3 = null, rs2_4 = null, rs3 = null, rs4 = null, rs5 = null, rs6 = null, rs7 = null, rs8a = null, rs8b = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();

		String query1 = "  SELECT 'X'  FROM   PT_IL_POLICY"
				+ "  WHERE  POL_SYS_ID   = ? "
				+ "  AND    NVL(POL_END_DT, POL_ISSUE_DT) <= ? ";

		String query2 = " SELECT PS_CODE  FROM   PP_SYSTEM   WHERE  PS_TYPE IN 'IL_DEC_SA' ";

		String query2_2 = " SELECT PS_CODE  FROM   PP_SYSTEM   WHERE  PS_TYPE IN 'IL_INC_SA' ";

		String query2_3 = " SELECT PS_CODE  FROM   PP_SYSTEM   WHERE  PS_TYPE IN 'IL_ADD_RIDER' ";

		String query2_4 = " SELECT PS_CODE  FROM   PP_SYSTEM   WHERE  PS_TYPE IN 'IL_DEL_RIDER' ";

		String query3 = " SELECT PROD_ENDT_VAL_DAYS,PROD_COOLOFF_DAYS  FROM   PM_IL_PRODUCT"
				+ " WHERE  PROD_CODE = ? ";

		String query4 = "    SELECT MAX(PC_PAID_DT)  FROM   PT_IL_PREM_COLL"
				+ " WHERE  PC_POL_SYS_ID IN (SELECT MAX(B.PC_POL_SYS_ID)"
				+ " FROM   PT_IL_PREM_COLL B  WHERE  B.PC_POL_SYS_ID   = ? "
				+ " AND    B.PC_PAID_FLAG    ='A' 	AND    B.PC_PREM_TYPE    ='R'"
				+ " AND    B.PC_PAID_DT IS NOT NULL) ";

		String query5 = " SELECT  PS_VALUE    FROM    PP_SYSTEM"
				+ "   WHERE   PS_TYPE = 'END_NUM_PTRN' 	";

		String query6 = "  SELECT 'X'     FROM   PM_LIFE_ENDT_NUMBER_SETUP";

		String query7 = " SELECT PC_SCHD_PYMT_DT FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID= ? "
				+ " AND PC_PAID_FLAG ='N' " + " ORDER BY PC_SCHD_PYMT_DT ASC ";

		Date M_DATE = null;
		String M_DUMMY = null;
		Double M_VALUE = 0d;
		String M_CODE_DESC = null;
		String M_PS_VALUE1 = null;
		String M_PS_CODE_DESC = null;
		String M_END_CODE = null;
		String M_END_CODE_2 = null;
		String M_END_CODE_3 = null;
		String M_END_CODE_4 = null;
		Double M_PROD_ENDT_VAL_DAYS = null;
		Date M_PC_PAID_DT = null;
		Date renewalDate = null;
		Double M_PS_VALUE = 0d;
		Double M_PROD_COOLOFF_DAYS = null;
		String M_INCSA = null;
		String M_DECSA = null;
		String M_ADBT_CODE = null;
		String M_ADBT_END_DAY = null;
		Date M_MIN_SCHD_DT = null;
		Date M_MIN_REDATE_EFF_DT = null;
		Date M_MIN_REDATE_EFF_FM_DT = null;

		pt_il_policy_bean.setPOL_END_DT(currValue);
		try {
			connection = CommonUtils.getConnection();

			if (currValue != null) {

				// Commented by Akash because these condition always returns
				// true...

				if (!(pt_il_policy_bean.getPOL_END_DT().after(
						pt_il_policy_bean.getPOL_START_DT()) || pt_il_policy_bean
						.getPOL_END_DT().equals(
								pt_il_policy_bean.getPOL_START_DT())
						&& pt_il_policy_bean.getPOL_END_DT().before(
								pt_il_policy_bean.getPOL_EXPIRY_DT()))) {

					// Added By Akash
					/*
					 * if(pt_il_policy_bean.getPOL_END_DT().before(pt_il_policy_bean.getPOL_START_DT()) ||
					 * pt_il_policy_bean.getPOL_END_DT().after(pt_il_policy_bean.getPOL_EXPIRY_DT())){
					 */

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71141",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}

				/*
				 * if (!("001".equals(CommonUtils.nvl(pt_il_policy_bean //[Added
				 * by Vinoj to fix P11JLIFEQC-1677620] .getPOL_END_TYPE(),
				 * "000")))) {
				 */
				/*
				 * if(!(CommonUtils.isIN(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(),"000"),
				 * "001","009"))){ values = new Object[] {
				 * pt_il_policy_bean.getPOL_SYS_ID() };
				 * 
				 * rs7 = handler.executeSelectStatement(query7, connection,
				 * values); if (rs7.next()) { renewalDate = rs7.getDate(1); }
				 * if(renewalDate != null){ if (currValue.before(renewalDate)) {
				 * throw new Exception("Enter Valid Endorsement Date."); } } }
				 */
				/*if (pt_il_policy_bean.getPOL_END_DT().before(
						pt_il_policy_bean.getPOL_ISSUE_DT())) {*/
				
/*				Added by Ameen as per sugg. of Siva for policy issue date and endorsement date are same issue validation rises on 17-11-2016*/
				
				Date date1 = pt_il_policy_bean.getPOL_ISSUE_DT();
				System.out.println("date1     : "+date1);
				Date date2= pt_il_policy_bean.getPOL_END_DT();
				System.out.println("datee1    : "+date1+" datee2    : "+date2);
				
				long diff = date2.getTime() - date1.getTime();
	 
				long diffDays = diff / (24 * 60 * 60 * 1000);

				System.out.print(diffDays + "days, endorsement different"); 
				
					if(diffDays < 0){

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71060",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
				values = new Object[] {
						pt_il_policy_bean.getPOL_SYS_ID(),
						CommonUtils.stringToDate(CommonUtils
								.dateToPELStringFormatter(currValue)) };

				rs1 = handler
						.executeSelectStatement(query1, connection, values);
				if (rs1.next()) {
					M_DATE = rs1.getDate(1);
				} else if (rs1 == null && M_DATE == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71061",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
				rs2 = handler.executeSelectStatement(query2, connection);
				if (rs2.next()) {
					M_END_CODE = rs2.getString(1);
				}
				// NEWLY ADDED TO CHECK THE ENDORSEMENT DATE BASED ON POLICY
				// START DATE

				rs2_2 = handler.executeSelectStatement(query2_2, connection);
				if (rs2_2.next()) {
					M_END_CODE_2 = rs2_2.getString(1);
				}

				rs2_3 = handler.executeSelectStatement(query2_3, connection);
				if (rs2_3.next()) {
					M_END_CODE_3 = rs2_3.getString(1);
				}

				rs2_4 = handler.executeSelectStatement(query2_4, connection);
				if (rs2_4.next()) {
					M_END_CODE_4 = rs2_4.getString(1);
				}

				if (M_END_CODE.equalsIgnoreCase(pt_il_policy_bean
						.getPOL_END_CODE())
						|| M_END_CODE_2.equalsIgnoreCase(pt_il_policy_bean
								.getPOL_END_CODE())
						|| M_END_CODE_3.equalsIgnoreCase(pt_il_policy_bean
								.getPOL_END_CODE())
						|| M_END_CODE_4.equalsIgnoreCase(pt_il_policy_bean
								.getPOL_END_CODE())) {
					// ADDED ENDS
					values = new Object[] { pt_il_policy_bean
							.getPOL_PROD_CODE() };
					rs3 = handler.executeSelectStatement(query3, connection,
							values);
					if (rs3.next()) {
						M_PROD_ENDT_VAL_DAYS = rs3.getDouble(1);
						M_PROD_COOLOFF_DAYS = rs3.getDouble(2);
					}
					values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };

					rs4 = handler.executeSelectStatement(query4, connection,
							values);
					if (rs4.next()) {
						M_PC_PAID_DT = rs4.getDate(1);
					}

					if (M_PC_PAID_DT != null) {
						if (CommonUtils.addDaysToDate(
								pt_il_policy_bean.getPOL_START_DT(),// M_PC_PAID_DT,
								CommonUtils.nvl(M_PROD_ENDT_VAL_DAYS, 0)
										.intValue()).before(currValue)) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91201",
									new Object[] {
									/*
									 * CommonUtils
									 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
									 */
									M_PROD_ENDT_VAL_DAYS }));

						}
					}
				}

				if (pt_il_policy_bean.getPOL_END_NO() == null) {

					rs5 = handler.executeSelectStatement(query5, connection);
					if (rs5.next()) {
						M_PS_VALUE1 = rs5.getString(1);
					}

					if ("1".equals(M_PS_VALUE1)) {
						pValOrclList = new ArrayList<OracleParameter>();
						pValOrclList = pkg_pilt002_apac.P_SET_DOC_NO_PROP("3",
								pt_il_policy_bean.getPOL_END_CODE(),
								pt_il_policy_bean.getPOL_DIVN_CODE(),
								pt_il_policy_bean.getPOL_CLASS_CODE(),
								pt_il_policy_bean.getPOL_PLAN_CODE(),
								pt_il_policy_bean.getPOL_PROD_CODE(),
								pt_il_policy_bean.getPOL_UW_YEAR(),
								pt_il_policy_bean.getPOL_END_NO(),
								"PT_IL_POLICY", "N", currValue, null, null,
								pt_il_policy_bean.getROWID(), null);

						if ("Y".equals(pValOrclList.get(1))) {
							pt_il_policy_action.getCOMP_POL_END_NO()
									.setDisabled(false);
							pt_il_policy_action.getCOMP_POL_END_NO()
									.setRequired(true);
						}

					} else if ("2".equals(M_PS_VALUE1)) {

						rs6 = handler
								.executeSelectStatement(query6, connection);
						if (rs6.next()) {
							M_DUMMY = rs6.getString(1);
							pt_il_policy_action.getCOMP_POL_END_NO()
									.setDisabled(true);
						}

					}
				}
			}

			/*
			 * pValList = new ArrayList<String>(); pValList =
			 * procedures.callP_VAL_SYSTEM("IL_MOP_DAYS", "IL_MOP_DAYS",
			 * M_CODE_DESC, "N", M_VALUE.toString());
			 * 
			 * if (pValList.size() > 0) { M_CODE_DESC = pValList.get(0); M_VALUE =
			 * Double.parseDouble(pValList.get(1)); }
			 * 
			 * 
			 * if(CommonUtils.subtractDate(pt_il_policy_bean.getPOL_END_DT(),pt_il_policy_bean.getPOL_START_DT())<=
			 * M_VALUE) {
			 * pt_il_policy_bean.setPOL_END_EFF_FROM_DT(pt_il_policy_bean.getPOL_START_DT());
			 * 
			 * }else if(pt_il_policy_bean.getPOL_END_CODE()!=M_INCSA &&
			 * ((CommonUtils.subtractDate(pt_il_policy_bean.getPOL_END_DT(),pt_il_policy_bean.getPOL_START_DT()))<=
			 * M_VALUE)) {
			 * if(!(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(),
			 * "000").equalsIgnoreCase("020")) &&
			 * (pt_il_policy_bean.getPOL_END_EFF_FROM_DT()==null)) {
			 * pt_il_policy_bean.setPOL_END_EFF_FROM_DT(pt_il_policy_bean.getPOL_END_DT()); }
			 */
			
			/*
			 * Commented by Ameen on 28-03-2017 as per Ajoy suggestion not to default endorsment from date.
			 * if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(), "000")

				// sp_revival.P_CHECK_PREM_COLL_UPTODATE_RED(
				// pt_il_policy_bean.getPOL_SYS_ID(),pt_il_policy_bean.getPOL_END_DT());
				if (pt_il_policy_bean.getPOL_END_EFF_FROM_DT() == null) {
				pt_il_policy_bean.setPOL_END_EFF_FROM_DT(new CommonUtils()
						.getCurrentDate());
				}
			}

			if (pt_il_policy_bean.getPOL_END_EFF_FROM_DT() == null) {
				pt_il_policy_bean.setPOL_END_EFF_FROM_DT(pt_il_policy_bean
						.getPOL_END_DT());
			}*/
			/*end*/
			
			pValList = new ArrayList<String>();
			pValList = procedures.callP_VAL_SYSTEM("IL_BUF_DAY", "IL_BUF_DAY",
					M_PS_CODE_DESC, "N", M_PS_VALUE.toString());

			if (pValList.size() > 0) {
				M_PS_CODE_DESC = pValList.get(0);
				M_PS_VALUE = Double.parseDouble(pValList.get(1));
			}

			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
			rs3 = handler.executeSelectStatement(query3, connection, values);
			if (rs3.next()) {
				M_PROD_ENDT_VAL_DAYS = rs3.getDouble(1);
				M_PROD_COOLOFF_DAYS = rs3.getDouble(2);
			}

			if ("009".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if (CommonUtils.nvl(CommonUtils.subtractDate(pt_il_policy_bean
						.getPOL_END_DT(), pt_il_policy_bean.getPOL_START_DT()),
						0) > (CommonUtils.nvl(M_PROD_COOLOFF_DAYS, 0) + CommonUtils
						.nvl(M_PS_VALUE, 0))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91429",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
				CommonUtils.closeCursor(rs6);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_END_NO_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;

		ArrayList<String> pValList = new ArrayList<String>();
		String M_PS_VALUE1 = null;
		String query1 = "    SELECT  PS_VALUE FROM    PP_SYSTEM    WHERE   PS_TYPE = 'END_NUM_PTRN' ";

		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query1, connection);
			if (rs.next()) {
				M_PS_VALUE1 = rs.getString(1);
			}
			if (currValue != null) {
				if ("1".equals(M_PS_VALUE1)) {// -- ADDED IF CONDITION BY
					// ABHINAV FOR STM FSD 12
					pkg_pilt002_apac.IL_UNIQUE_END_NO(pt_il_policy_bean
							.getPOL_NO(), pt_il_policy_bean.getPOL_END_NO());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_END_EFF_FROM_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		Connection connection = null;
		ResultSet rs = null, rs7 = null;
		ResultSet prodres = null;
		Date renewalDate = null;
		Object[] values = {};
		Integer COOL_OFF_DAYS = 0;
		Integer NO_OF_DAYS = 0;
		Integer COVR_COOL_OF_DAYS = 0;
		String M_TEMP = null;
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String query7 = " select max(pc_schd_pymt_dt) from pt_il_prem_coll"
				+ " where pc_prem_type='R' and pc_paid_flag='N' "
				+ " and pc_pol_sys_id = ?";
		String prod = "SELECT PROD_COOLOFF_DAYS FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		String riclosingChkQry = "SELECT 'X' FROM   PT_IL_RI_PREM_ALLOC "
				+ "WHERE  RPA_POL_SYS_ID = ? " + "AND    RPA_PRD_TO_DT < = ? "
				+ "AND    NVL(RPA_FRZ_FLAG,'N') != 'Y' ";
		ResultSet rsRiCl = null, rs8 = null, rs9 = null;
		try {
			connection = CommonUtils.getConnection();
			rsRiCl = handler.executeSelectStatement(riclosingChkQry,
					connection, new Object[] {
							pt_il_policy_bean.getPOL_SYS_ID(),
							CommonUtils.addDaysToDate(currValue, -1) });
			if (rsRiCl.next()) {
				// throw new Exception("RI not closed for previous renewal for
				// this policy. Cannot Endorse!.");
			}
			prodres = handler.executeSelectStatement(prod, connection,
					new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() });
			while (prodres.next()) {
				COOL_OFF_DAYS = prodres.getInt(1);
			}
			NO_OF_DAYS = CommonUtils.subtractDate(pt_il_policy_bean
					.getPOL_END_DT(), pt_il_policy_bean.getPOL_START_DT());
			if (("009".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE()))
					&& (NO_OF_DAYS <= COOL_OFF_DAYS)) {

				if (!(currValue.equals(pt_il_policy_bean.getPOL_START_DT()))) {
					throw new Exception(
							"Endorsement Effective From Date should be Policy Inception Date");
				}

			}

/*	Commented by pidugu raj dt:16-08-2018 for KIC-	1761314	
 
 * pValList = pkg_pilt002_apac.POL_END_EFF_FROM_DT_W_V_I(
					pt_il_policy_bean.getPOL_SYS_ID(), pt_il_policy_bean
							.getPOL_PLAN_CODE(), pt_il_policy_bean
							.getPOL_END_CODE(), pt_il_policy_bean
							.getPOL_PROD_CODE(), pt_il_policy_bean
							.getPOL_END_TYPE(), pt_il_policy_bean
							.getPOL_START_DT(), dummy_bean
							.getUI_M_CALC_METHOD(), pt_il_policy_bean
							.getPOL_END_DT(), pt_il_policy_bean
							.getPOL_ISSUE_DT(), pt_il_pol_assured_dtls_bean
							.getPOAD_DOB(), dummy_bean
							.getUI_M_PROD_AGE_CALC_FLAG(), dummy_bean
							.getUI_M_POL_PLAN_TYPE(), CommonUtils
							.getGlobalVariable("GLOBAL.M_PRIVILEGE"),
					CommonUtils.getGlobalVariable("GLOBAL.M_PAYER_FOUND"),
					pt_il_policy_bean.getPOL_PERIOD(), pt_il_policy_bean
							.getPOL_EXPIRY_DT(), pt_il_policy_bean
							.getPOL_MODE_OF_PYMT(), pt_il_policy_bean
							.getPOL_JOINT_LIFE_YN(),
					pt_il_pol_assured_dtls_bean.getPOAD_CATG_CODE(),
					pt_il_pol_assured_dtls_1bean.getPOAD_CATG_CODE(),
					dummy_bean.getUI_M_PLAN_AGE_TERM_FLAG(),
					pt_il_pol_assured_dtls_bean.getPOAD_AGE(),
					pt_il_pol_assured_dtls_1bean.getPOAD_AGE(),
					pt_il_policy_bean.getPOL_END_EFF_FROM_DT(),
					pt_il_policy_bean.getPOL_END_EFF_TO_DT(), null, null, null,
					null,pt_il_policy_bean.getUI_M_MOP_END());

			if (pValList.get(0) != null) {
				pt_il_pol_assured_dtls_bean.setPOAD_AGE((Integer) pValList.get(
						0).getValueObject());
			}
			if (pValList.get(1) != null) {
				pt_il_pol_assured_dtls_1bean.setPOAD_AGE((Integer) pValList
						.get(1).getValueObject());
			}
			if (pValList.get(2) != null) {
				pt_il_policy_bean.setPOL_END_EFF_TO_DT((Date) pValList.get(2)
						.getValueObject());
			}
			if (pValList.get(3) != null && pValList.get(3).equals("TRUE")) {
				pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE().setDisabled(
						false);
			}
			if (pValList.get(4) != null && pValList.get(4).equals("TRUE")) {
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE().setDisabled(
						false);
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_FOUND_PAYER",
					(String) pValList.get(5).getValueObject());
					
					End*/
			if (!(CommonUtils.isIN(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"), "001", "009"))) {
				values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };

				rs7 = handler
						.executeSelectStatement(query7, connection, values);
				if (rs7.next()) {
					renewalDate = rs7.getDate(1);
				}
				if (!(("012".equals(pt_il_policy_bean.getPOL_END_TYPE()))
						|| ("020").equals(pt_il_policy_bean.getPOL_END_TYPE()) || ("006")
						.equals(pt_il_policy_bean.getPOL_END_TYPE()))) {

					
					
					
					//commented by soundarya for endorsement issue 
					
					/*if (renewalDate != null) {
						if (currValue.before(renewalDate)) {
							throw new Exception("Enter Valid Endorsement Date.");
						}
					}*/
				}
			}
			String updateQuery = "UPDATE PT_IL_POL_ASSURED_DTLS SET POAD_POL_SYS_ID = ? "
					+ "WHERE POAD_POL_SYS_ID = ?";
			handler.executeUpdateStatement(updateQuery, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
							pt_il_policy_bean.getPOL_SYS_ID() });

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

			// ErrorHelpUtil.getErrorForProcedure(connection);
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_END_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_END_EFF_TO_DT(currValue);
		try {
			connection = CommonUtils.getConnection();
			// ---Endt eff to dt >= endt eff from dt and endt_eff_to_dt <=
			// pol_to_dt.
			if (currValue != null) {

				if (pt_il_policy_bean.getPOL_END_EFF_FROM_DT() != null
						&& currValue.before(pt_il_policy_bean
								.getPOL_END_EFF_FROM_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71195",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					/*
					 * STD_MESSAGE_ROUTINE(71195,NAME_IN('GLOBAL.M_LANG_CODE'));
					 * RAISE FORM_TRIGGER_FAILURE;
					 */
				}
			}

			if (currValue.after(pt_il_policy_bean.getPOL_EXPIRY_DT())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71196",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						pt_il_policy_bean.getPOL_EXPIRY_DT() }));
				// PENDING date format
				/*
				 * STD_MESSAGE_ROUTINE(71196,NAME_IN('GLOBAL.M_LANG_CODE'),TO_CHAR(:PT_IL_POLICY.POL_EXPIRY_DT,'DD/MM/RRRR'));
				 * RAISE FORM_TRIGGER_FAILURE;
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void FC_LC_AMAN_SENABEL_PERM_COMMON(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		try {

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(), pt_il_policy_bean
					.getPOL_FC_BASIC_PREM().toString(), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_BASIC_PREM(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean.setPOL_LC_BASIC_PREM(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_FC_BASIC_PREM(), 0)
					* pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_BASIC_PREM().toString(), "R", pt_il_policy_bean
					.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_BASIC_PREM(Double.parseDouble(pValList
					.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FC_AMAN_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			FC_LC_AMAN_SENABEL_PERM_COMMON(compositeAction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_LC_AMAN_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			FC_LC_AMAN_SENABEL_PERM_COMMON(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_LC_SENABEL_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			FC_LC_AMAN_SENABEL_PERM_COMMON(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FC_SENABEL_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			FC_LC_AMAN_SENABEL_PERM_COMMON(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FC_NET_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_FC_NET_PREM(currValue);
		try {

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), currValue.toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_NET_PREM(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean.setPOL_LC_NET_PREM(pt_il_policy_bean
					.getPOL_FC_NET_PREM()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), CommonUtils
					.doubleAsString(pt_il_policy_bean.getPOL_LC_NET_PREM()),
					"R", pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_NET_PREM(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean
					.setUI_M_FC_INST_PREM(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_FC_NET_PREM(), 0)
							/ CommonUtils.nvl(pt_il_policy_bean
									.getPOL_NO_OF_INST(), 1));

			pt_il_policy_bean
					.setUI_M_LC_INST_PREM(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_LC_NET_PREM(), 0)
							/ CommonUtils.nvl(pt_il_policy_bean
									.getPOL_NO_OF_INST(), 1));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_LC_NET_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_LC_NET_PREM(currValue);
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_NET_PREM(Double.parseDouble(pValList
					.get(0)));

			lifelibProcedures.P_VAL_FC_LC_TOLERANCE(pt_il_policy_bean
					.getPOL_FC_NET_PREM().toString(), currValue.toString(),
					CommonUtils.doubleAsString(pt_il_policy_bean
							.getPOL_SA_EXCH_RATE()), "E");
			pt_il_policy_bean
					.setUI_M_LC_INST_PREM(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_LC_NET_PREM(), 0)
							/ CommonUtils.nvl(pt_il_policy_bean
									.getPOL_NO_OF_INST(), 1));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_LC_BANK_ALLOC_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_LC_NET_PREM(currValue);
		try {

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_BANK_ALLOC_AMT(Double
					.parseDouble(pValList.get(0)));

			lifelibProcedures.P_VAL_FC_LC_TOLERANCE(pt_il_policy_bean
					.getPOL_FC_BANK_ALLOC_AMT().toString(), currValue
					.toString(), pt_il_policy_bean.getPOL_SA_EXCH_RATE()
					.toString(), "E");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_FC_BANK_ALLOC_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_FC_BANK_ALLOC_AMT(currValue);
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), currValue.toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_BANK_ALLOC_AMT(Double
					.parseDouble(pValList.get(0)));
			pt_il_policy_bean.setPOL_LC_BANK_ALLOC_AMT(pt_il_policy_bean
					.getPOL_FC_BANK_ALLOC_AMT()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_BANK_ALLOC_AMT().toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_BANK_ALLOC_AMT(Double
					.parseDouble(pValList.get(0)));

			if ("Y".equals(pt_il_policy_bean.getPOL_INCORPORATED_YN())) {

				if (CommonUtils.nvl(pt_il_policy_bean
						.getPOL_FC_BANK_ALLOC_AMT(), 0) > 0) {
					pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(CommonUtils
							.nvl(pt_il_policy_bean.getUI_M_FC_GROSS_CONT(), 0)
							- CommonUtils.nvl(pt_il_policy_bean
									.getPOL_FC_BANK_ALLOC_AMT(), 0));
					pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(CommonUtils
							.nvl(pt_il_policy_bean.getUI_M_LC_GROSS_CONT(), 0)
							- CommonUtils.nvl(pt_il_policy_bean
									.getPOL_LC_BANK_ALLOC_AMT(), 0));
				} else {
					pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(0.0);
					pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(0.0);

				}

				pt_il_policy_bean.setPOL_FC_TOT_SA(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED()
						+ CommonUtils.nvl(pt_il_policy_bean
								.getPOL_ORG_FC_SUM_ASSURED(), 0)
						+ pt_il_policy_bean.getUI_M_FC_GROSS_CONT()
						- pt_il_policy_bean.getPOL_FC_CLIENT_ALLOC_AMT());

				pValList = new ArrayList<String>();

				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), pt_il_policy_bean
						.getPOL_FC_TOT_SA().toString(), "R", pt_il_policy_bean
						.getPOL_PROD_CODE());

				pt_il_policy_bean.setPOL_FC_TOT_SA(Double.parseDouble(pValList
						.get(0)));

				pt_il_policy_bean.setPOL_LC_TOT_SA(pt_il_policy_bean
						.getPOL_LC_SUM_ASSURED()
						+ CommonUtils.nvl(pt_il_policy_bean
								.getPOL_ORG_LC_SUM_ASSURED(), 0)
						+ pt_il_policy_bean.getUI_M_LC_GROSS_CONT()
						- pt_il_policy_bean.getPOL_LC_CLIENT_ALLOC_AMT());

				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), pt_il_policy_bean
						.getPOL_LC_TOT_SA().toString(), "R", pt_il_policy_bean
						.getPOL_PROD_CODE());

				pt_il_policy_bean.setPOL_LC_TOT_SA(Double.parseDouble(pValList
						.get(0)));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FC_CLIENT_ALLOC_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(currValue);
		try {

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), currValue.toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(Double
					.parseDouble(pValList.get(0)));

			pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(pt_il_policy_bean
					.getPOL_FC_CLIENT_ALLOC_AMT()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_CLIENT_ALLOC_AMT().toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(Double
					.parseDouble(pValList.get(0)));

			if (CommonUtils
					.nvl(pt_il_policy_bean.getPOL_FC_BANK_ALLOC_AMT(), 0) > 0) {
				if ((pt_il_policy_bean.getPOL_FC_BANK_ALLOC_AMT() + pt_il_policy_bean
						.getPOL_FC_CLIENT_ALLOC_AMT()) != pt_il_policy_bean
						.getUI_M_FC_GROSS_CONT()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91142",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_LC_CLIENT_ALLOC_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(currValue);
		try {

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(Double
					.parseDouble(pValList.get(0)));

			lifelibProcedures.P_VAL_FC_LC_TOLERANCE(pt_il_policy_bean
					.getPOL_FC_CLIENT_ALLOC_AMT().toString(), pt_il_policy_bean
					.getPOL_LC_CLIENT_ALLOC_AMT().toString(), pt_il_policy_bean
					.getPOL_SA_EXCH_RATE().toString(), "E");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_FC_PRE_TPD_BNF_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_FC_PRE_TPD_BNF(currValue);
		try {

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), currValue.toString(), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_FC_PRE_TPD_BNF(Double.parseDouble(pValList
					.get(0)));

			pt_il_policy_bean.setPOL_LC_PRE_TPD_BNF(pt_il_policy_bean
					.getPOL_FC_PRE_TPD_BNF()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_PRE_TPD_BNF().toString(), "R", pt_il_policy_bean
					.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_PRE_TPD_BNF(Double.parseDouble(pValList
					.get(0)));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_LC_PRE_TPD_BNF_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_LC_PRE_TPD_BNF(currValue);
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), currValue.toString(), "V",
					pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_policy_bean.setPOL_LC_PRE_TPD_BNF(Double.parseDouble(pValList
					.get(0)));

			lifelibProcedures.P_VAL_FC_LC_TOLERANCE(pt_il_policy_bean
					.getPOL_FC_PRE_TPD_BNF().toString(), pt_il_policy_bean
					.getPOL_LC_PRE_TPD_BNF().toString(), pt_il_policy_bean
					.getPOL_SA_EXCH_RATE().toString(), "E");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_DIVN_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		pt_il_policy_bean.setPOL_DIVN_CODE(currValue);
		try {
			connection = CommonUtils.getConnection();
			pValList = lifelibProcedures.P_VAL_DIVN(pt_il_policy_bean
					.getPOL_DIVN_CODE(), pt_il_policy_bean
					.getUI_M_POL_DIVN_DESC(), "N", "E");
			if (pValList != null && pValList.size() > 0) {

				pt_il_policy_bean.setUI_M_POL_DIVN_DESC(pValList.get(0)
						.getValue());

			}

			/*Modified by Saranya on 04/04/2017
			 * 
			 * CommonUtils.setGlobalVariable("GLOBAL.M_DIVN_CODE",
					pt_il_policy_bean.getPOL_DIVN_CODE());*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_DEPT_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		pt_il_policy_bean.setPOL_DEPT_CODE(currValue);
		try {
			connection = CommonUtils.getConnection();
			
			
			pValList = lifelibProcedures.P_VAL_DEPT(pt_il_policy_bean
					.getPOL_DIVN_CODE(), currValue, null, "N", "E");

			if (pValList != null && pValList.size() > 0) {
				pt_il_policy_bean.setUI_M_POL_DEPT_DESC(pValList.get(0)
						.getValue());
			}

			// :PT_IL_POLICY.POL_ISSUE_DT := :PT_IL_POLICY.POL_ISSUE_DT;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_CLASS_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String query1 = " SELECT 'X'  FROM   PM_IL_PROP_TREATY "
				+ " WHERE  ? BETWEEN PT_START_DT AND   PT_END_DT"
				+ " AND    PT_CLASS_CODE = ?  ";
		String M_CHAR = null;
		try {
			connection = CommonUtils.getConnection();

			pValList = lifelibProcedures.P_VAL_CLASS(pt_il_policy_bean
					.getPOL_CLASS_CODE(), null, "N", "E");
			if (pValList != null && pValList.size() > 0) {
				pt_il_policy_bean.setUI_M_POL_CLASS_DESC(pValList.get(0)
						.getValue());
			}

			// :PT_IL_POLICY.POL_ISSUE_DT := :PT_IL_POLICY.POL_ISSUE_DT;
			values = new Object[] { pt_il_policy_bean.getPOL_ISSUE_DT(),
					pt_il_policy_bean.getPOL_CLASS_CODE() };

			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_CHAR = rs.getString(1);
			} else if (rs == null) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71171",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_PERIOD_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Integer currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		ArrayList<String> pValList = null;
		ArrayList<OracleParameter> pValList1 = null;
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();

		/*
		 * if("012".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())){
		 * 
		 * if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		 * .getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE() != null) {
		 * pt_il_policy_bean.setUI_M_MAT_AGE(currValue+pt_il_policy_bean.getUI_M_MAT_AGE()); }
		 */

		try {
			System.out.println("pt_il_policy_bean.getPOL_END_TYPE()  "+pt_il_policy_bean
					.getPOL_END_TYPE()+"   currValue           "+currValue);
			if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				/* Commented by Dhinesh on 27.3.2017 for ALTERM ENDORSEMENT POLICY COVER PERIOD CHANGE
				if (CommonUtils.nvl(currValue, 0) > 0) {
				throw new Exception(
							"Increasing the policy term is not allowed");
			}*/
				}
			// added for alterm
			if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				/*Modified by Raja on 27/03/2017 for Alteration Term issue*/
				/*currValue = CommonUtils.nvl(currValue, 0)
						+ CommonUtils.nvl(
								pt_il_policy_bean.getPOL_ORG_PERIOD(), 0);*/
				/*End*/
				updatePolPremYrsToTable(pt_il_policy_bean);
			}// added for alterm ends
			if (!(currValue.equals(pt_il_policy_bean.getPOL_PERIOD()))) {
				pValList1 = pkg_pilt002_apac.POL_PERIOD_W_V_I(pt_il_policy_bean
						.getPOL_JOINT_LIFE_YN(), pt_il_pol_assured_dtls_bean
						.getPOAD_AGE(), pt_il_pol_assured_dtls_1_bean
						.getPOAD_AGE(), dummy_bean.getUI_M_POL_PERIOD(),
						dummy_bean.getUI_M_PLAN_AGE_TERM_FLAG(),
						pt_il_pol_assured_dtls_bean.getPOAD_DOB(), dummy_bean
								.getUI_M_PROD_AGE_CALC_FLAG(),
						pt_il_policy_bean.getROWID(), dummy_bean
								.getUI_M_POL_PLAN_TYPE(), dummy_bean
								.getUI_M_COVER_SA_CALC(), pt_il_policy_bean
								.getPOL_PROP_END_TYPE(), dummy_bean
								.getUI_M_BASE_CURR(), pt_il_policy_bean
								.getPOL_NO(), pt_il_policy_bean
								.getPOL_ISSUE_DT(), pt_il_pol_assured_dtls_bean
								.getPOAD_CATG_CODE(),
						pt_il_pol_assured_dtls_1_bean.getPOAD_CATG_CODE(),
						pt_il_policy_bean.getPOL_PLAN_CODE(), pt_il_policy_bean
								.getPOL_SYS_ID(), pt_il_policy_bean
								.getPOL_PROD_CODE(), pt_il_policy_bean
								.getPOL_END_NO_IDX(), dummy_bean
								.getUI_M_PROD_PERIOD_MULTIPLE(),
						pt_il_policy_bean.getPOL_END_TYPE(), dummy_bean
								.getUI_M_PROD_MATU_DT(), pt_il_policy_bean
								.getPOL_MODE_OF_PYMT(), pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), pt_il_policy_bean
								.getPOL_FC_MON_ANNU_AMT(), pt_il_policy_bean
								.getPOL_ORG_FC_SUM_ASSURED(), pt_il_policy_bean
								.getPOL_ORG_FC_MON_ANNU_AMT(),
						pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
						pt_il_policy_bean.getPOL_PREM_PAY_YRS(),
						pt_il_policy_bean.getPOL_FIRST_INST_DT(),
						pt_il_policy_bean.getPOL_START_DT(), pt_il_policy_bean
								.getPOL_EXPIRY_DT(), pt_il_policy_bean
								.getPOL_LAST_INST_DT(), null, null, currValue,
						pt_il_policy_bean.getPOL_FC_SUM_ASSURED(),
						pt_il_policy_bean.getPOL_LC_SUM_ASSURED(),
						pt_il_policy_bean.getPOL_FC_CURR_SA(),
						pt_il_policy_bean.getPOL_LC_CURR_SA());

				if (pValList1 != null || !pValList1.isEmpty()) {

					if (pValList1.get(1) != null) {
						pt_il_policy_bean.setPOL_FIRST_INST_DT((Date) pValList1
								.get(1).getValueObject());
					}
					// if
					// (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getChkFlag()
					// == true)
					{
						if (pValList1.get(2) != null) {
							pt_il_policy_bean.setPOL_START_DT((Date) pValList1
									.get(2).getValueObject());
						}
						if (pValList1.get(3) != null) {
							pt_il_policy_bean.setPOL_EXPIRY_DT((Date) pValList1
									.get(3).getValueObject());
						}
					}

					if (pValList1.get(4).getValueObject() != null) {
						pt_il_policy_bean.setPOL_LAST_INST_DT((Date) pValList1
								.get(4).getValueObject());
					}
					if (pValList1.get(5) != null) {
						CommonUtils.setGlobalVariable("GLOBAL.M_AGENT_RATE",
								(String) pValList1.get(5).getValueObject());
					}

				}
			}
			/*Added by Ameen on 27-04-2018 as per chandramohan sugg.*/
			 if(null != pt_il_policy_bean.getPOL_END_NO_IDX() && pt_il_policy_bean.getPOL_END_NO_IDX() > 0 && null != pt_il_policy_bean.getPOL_END_CODE()){
				 if("INCTERM".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE()) || "DECTERM".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE())){
					 pkg_pilt002_apac.PR_ENDO_VALIDATE(
							 pt_il_policy_bean.getPOL_SYS_ID(), 
							 pt_il_policy_bean.getPOL_END_CODE(),
							 currValue ,0.0);
				 }
			 }
			 /*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_CONT_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();

		ArrayList<String> pValList = new ArrayList<String>();
		ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();
		
		/*Added by Janani on 18.04.2018 for Fidelity period calc*/
		Connection connection = null;
		ResultSet rs = null,rs1 = null;
		Object[] values = {};
		String PROD_CALC_TERM_YN = null ,POL_CONT_CODE = null ,PROD_PREM_PAYING_YRS = null;
		int prod_period = 0;
		ArrayList<OracleParameter> pValList2 = new ArrayList<OracleParameter>();
		
		BigDecimal term_disb_SysParam = null;
		
		/*End*/

		try {
			
			
			
			/*Added by Janani on 18.04.2018 for Fidelity period calc*/

			String query1 = " SELECT PROD_CALC_TERM_YN,PROD_PREM_PAYING_YRS FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";

			String query3 = "UPDATE PT_IL_POL_ASSURED_DTLS SET POAD_AGE = ? WHERE POAD_POL_SYS_ID = ? AND POAD_TYPE = 'R'";
			
			connection = CommonUtils.getConnection();

			rs = handler.executeSelectStatement(query1, connection,new Object[] {pt_il_policy_bean.getPOL_PROD_CODE()} );
			if (rs.next()) {

				PROD_CALC_TERM_YN = rs.getString("PROD_CALC_TERM_YN");
				PROD_PREM_PAYING_YRS = rs.getString("PROD_PREM_PAYING_YRS");
			}

			System.out.println("PROD_CALC_TERM_YN       "+PROD_CALC_TERM_YN);

			String query2 = "SELECT POL_CONT_CODE FROM PT_IL_POLICY WHERE POL_NO = ? ";
			
			rs1 = handler.executeSelectStatement(query2, connection,new Object[] {pt_il_policy_bean.getPOL_NO()} );
			if (rs1.next()) {

				POL_CONT_CODE = rs1.getString("POL_CONT_CODE");
			}
			
			/*End*/
			
		pValList = pkg_pilt002_apac.POL_CONT_CODE_W_V_I(CommonUtils
					.getProcedureValue(dummy_bean.getUI_M_IL_ASSRIND()),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_PLAN_CODE()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_JOINT_LIFE_YN()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_CUST_CODE()), CommonUtils
							.getProcedureValue(pt_il_pol_assured_dtls_bean
									.getPOAD_CATG_CODE()), CommonUtils
							.getProcedureValue(pt_il_pol_assured_dtls_1_bean
									.getPOAD_CATG_CODE()), CommonUtils
							.getProcedureValue(pt_il_pol_assured_dtls_1_bean
									.getPOAD_AGE()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()), CommonUtils
							.getProcedureValue(dummy_bean
									.getUI_M_PROD_AGE_CALC_FLAG()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_ISSUE_DT()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_ASSRD_REF_ID1()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_ASSRD_REF_ID2()), CommonUtils
							.getProcedureValue(dummy_bean
									.getUI_M_POL_PLAN_TYPE()), CommonUtils
							.getProcedureValue(dummy_bean
									.getUI_M_PROD_PERIOD_MULTIPLE()),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_END_TYPE()), pt_il_policy_bean.getROWID(),
					currValue,
					
					/*Modified by Janani on 04.04.2018 as per SIvarams suggestion*/
					//CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_PREM_PAY_YRS())
					CommonUtils.getProcedureValue(dummy_bean.getUI_M_POL_PERIOD()),
					/*End*/
					
					null, null, null, null,
					null, null, null, null, null, null, null, null, null, null,
					null, null, null, null, null,
					
					/*Modified by Janani on 04.04.2018 as per SIvarams suggestion*/
					//CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_PERIOD()),
					//CommonUtils.getProcedureValue(dummy_bean.getUI_M_POL_PERIOD()),
					/*Modifed by ganesh on 19-04-2018 for INCTERM endorsement as suggested by ajoy*/
					CommonUtils.getProcedureValue(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0)!=0?pt_il_policy_bean.getPOL_PERIOD():dummy_bean.getUI_M_POL_PERIOD()),
					/*End*/
					
					CommonUtils.getProcedureValue(dummy_bean
							.getUI_M_CALC_METHOD()));

			if (pValList != null && pValList.size() > 0) {
				if (pValList.get(0) != null) {
					currValue = pValList.get(0);
				}
				if (pValList.get(1) != null) {
					
					/*Modified by Janani on 23.04.2018 for Fidelity period calc*/
					
					//System.out.println("         POL_CONT_CODE        "+POL_CONT_CODE.trim()+"     currValue       "+currValue.trim());
					//if (pt_il_policy_bean.getPOL_PREM_PAY_YRS() == null)
						if (pt_il_policy_bean.getPOL_PREM_PAY_YRS() == null || ((POL_CONT_CODE != null) && !POL_CONT_CODE.equalsIgnoreCase(currValue.trim())))
							
						{
					/*End*/	
						pt_il_policy_bean.setPOL_PREM_PAY_YRS(Integer
								.parseInt(pValList.get(1)));
						}
				}
				/*if (pValList.get(2) != null) {
					pt_il_policy_bean.setPOL_ASSURED_NAME(pValList.get(2));}  
				
				
					
				
				if (pValList.get(3) != null) {
					pt_il_policy_bean.setPOL_RES_ADDRESS_1(pValList.get(3));
				}
				if (pValList.get(4) != null) {
					pt_il_policy_bean.setPOL_RES_ADDRESS_2(pValList.get(4));
				}
				if (pValList.get(5) != null) {
					pt_il_policy_bean.setPOL_RES_ADDRESS_3(pValList.get(5));
				}
				if (pValList.get(6) != null) {
					pt_il_policy_bean.setPOL_RES_AREA_CODE(pValList.get(6));
				}
				if (pValList.get(7) != null) {
					pt_il_policy_bean.setPOL_RES_PHONE_NO(pValList.get(7));
				}
				if (pValList.get(8) != null) {
					pt_il_policy_bean.setPOL_FAX_NO(pValList.get(8));
				}
				if (pValList.get(9) != null) {
					pt_il_policy_bean.setPOL_RES_AREA_CODE(pValList.get(9));
				}
				if (pValList.get(10) != null) {
					pt_il_policy_bean.setPOL_FAX_AREA_CODE(pValList.get(10));
				}
				if (pValList.get(11) != null) {
					pt_il_policy_bean.setPOL_CITY_CODE(pValList.get(11));
				}
				if (pValList.get(12) != null) {
					pt_il_policy_bean.setPOL_STATE_CODE(pValList.get(12));
				}
				if (pValList.get(13) != null) {
					pt_il_policy_bean.setPOL_COUNT_CODE(pValList.get(13));
				}  commented by ameen for ssp call id  :FALCONQC-1714579  */	
				if (pValList.get(2) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						/*Handled nvl by ganesh on 28-07-2017,ZBILQC-1731155 for the 1st issue */
						if(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),"XXXXX") != null && !(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),"XXXXX").equals("GEN001")))
						{
							pt_il_policy_bean.setPOL_ASSURED_NAME(pValList.get(2));	
						}
							 
					}
					
					/*End*/
				}
				if (pValList.get(3) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_RES_ADDRESS_1(pValList.get(3));
						}
					}
				}
				if (pValList.get(4) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_RES_ADDRESS_2(pValList.get(4));
						}
					}
				}
				if (pValList.get(5) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_RES_ADDRESS_3(pValList.get(5));
						}
					}
				}
				System.out.println("pValList.get(6) -->>"+pValList.get(6));
				if (pValList.get(6) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_RES_AREA_CODE(pValList.get(6));
						}
					}
				}
				if (pValList.get(7) != null) {
					pt_il_policy_bean.setPOL_RES_PHONE_NO(pValList.get(7));
				}
				if (pValList.get(8) != null) {
					pt_il_policy_bean.setPOL_FAX_NO(pValList.get(8));
				}
				if (pValList.get(9) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_RES_AREA_CODE(pValList.get(9));
						}
					}
				}
				if (pValList.get(10) != null) {
					pt_il_policy_bean.setPOL_FAX_AREA_CODE(pValList.get(10));
				}
				if (pValList.get(11) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_CITY_CODE(pValList.get(11));
						}
					}
				}
				if (pValList.get(12) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_STATE_CODE(pValList.get(12));
						}
					}
				}
				if (pValList.get(13) != null) {
					/*Changed by Ram on 07/09/2016 for General Endorsement*/
					System.out.println("pt_il_policy_bean.getPOL_STATUS()  "+pt_il_policy_bean.getPOL_STATUS());
					System.out.println("pt_il_policy_bean.getPOL_END_CODE()  "+pt_il_policy_bean.getPOL_END_CODE());
					
					if(pt_il_policy_bean.getPOL_STATUS() != null && !(pt_il_policy_bean.getPOL_STATUS().equals("E")))
					{
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN005")))
						{
					pt_il_policy_bean.setPOL_COUNT_CODE(pValList.get(13));
						}
					}
				}
				if (pValList.get(14) != null) {
					pt_il_policy_bean.setUI_M_POL_COUNT_NAME(pValList.get(14));
				}
				if (pValList.get(15) != null) {
					pt_il_policy_bean.setUI_M_POL_CITY_NAME(pValList.get(15));
				}
				if (pValList.get(16) != null) {
					pt_il_policy_bean.setUI_M_POL_STATE_NAME(pValList.get(16));
				}
				if (pValList.get(17) != null) {
					pt_il_policy_bean.setPOL_MOBILE_NO(pValList.get(17));
				}
				if (pValList.get(18) != null) {
					dummy_bean.setUI_M_CONT_REF_ID1(pValList.get(18));
				}
				if (pValList.get(19) != null) {
					dummy_bean.setUI_M_CONT_REF_ID2(pValList.get(19));
				}
				if (pValList.get(20) != null) {
					dummy_bean.setUI_M_CUST_AGE(pValList.get(20));
				}
				if (pValList.get(21) != null) {
					/*
					 *  commented by Ameen on 21-11-2017 for policy term not to set default value
					 * pt_il_policy_bean.setPOL_PERIOD(Integer.parseInt(pValList
							.get(21)));
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_PERIOD().setSubmittedValue(
									Integer.parseInt(pValList.get(21)));*/
					//pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
					
					
					/*Modified by Janani on 04.04.2018 as per Sivarams suggestion*/
					
					//pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
					
					/*Added by Janani on 18.04.2018 for Fidelity period calc*/
					/*system parameter handled by Ameen for KIC*/
					/*if(pt_il_policy_bean.getPOL_PERIOD() == null || ((POL_CONT_CODE != null) && !POL_CONT_CODE.equalsIgnoreCase(currValue.trim())))
					{
						pt_il_policy_bean.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
						pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
					}*/
					term_disb_SysParam = (BigDecimal)CommonUtils.getPPSystemParameterValue("IL_TERM_DFLT");
					
					if(term_disb_SysParam.intValue() == 1){
						
						/*Added by Janani on 31.05.2018 for Fidelity as discussed with SIvaram for Period not getting changed based on assured age*/ 
						
						System.out.println("getPOL_PREM_PAY_YRS          "+pt_il_policy_bean.getPOL_PREM_PAY_YRS()+
								"getPOL_PERIOD               "+pt_il_policy_bean.getPOL_PERIOD());
						
						if(PROD_CALC_TERM_YN!=null && !PROD_CALC_TERM_YN.equalsIgnoreCase("Y"))
						{
						
							
						if(pt_il_policy_bean.getPOL_PERIOD() == null || ((POL_CONT_CODE != null) && !POL_CONT_CODE.equalsIgnoreCase(currValue.trim())))
						{
							pt_il_policy_bean.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
							//pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
						}
						
						}else
						{
							pt_il_policy_bean.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
							if(pt_il_policy_bean.getPOL_PREM_PAY_YRS() > pt_il_policy_bean.getPOL_PERIOD())
							{
								pt_il_policy_bean.setPOL_PREM_PAY_YRS(Integer.parseInt(pValList.get(21)));
							}
							
							
						}
						
						/*End*/	
						pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
						
						
						
						
						
					}
					//Dt: 26-07-2018 Commented else if block by Pidugu Raj for KIC Policy Term issue.
					/*uncommented & modified by Ameen on 27-07-2018 for KIC To change pol_period KICLIFEQC-1759635 - 2,6*/
					   	else if(term_disb_SysParam.intValue() == 2){
					   		if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().isPOL_PERIOD_CHNG() == false){
								pt_il_policy_bean.setPOL_PERIOD(Integer.parseInt(pValList.get(21)));
								pt_il_policy_bean.setUI_M_POL_PERIOD(Integer.parseInt(pValList.get(21)));
					   		}
					}
					
					
					System.out.println("POL_PERIOD       "+pt_il_policy_bean.getPOL_PERIOD()+"    getUI_M_POL_PERIOD    "+pt_il_policy_bean.getUI_M_POL_PERIOD());
					
					/*End of 18.04.2018 for Fidelity period calc*/
					
					/*End*/

					
				/*Newly Added By Dhinesh on 27-06-2017 for ssp call id : ZBILQC-1728495*/
					
				/*Commentted by saritha on 07-09-2017 for ssp call id ZBILQC-1736358 as suggestted by siva sir*/ 	
				/*	pt_il_policy_bean.setPOL_PREM_PAY_YRS(Integer.parseInt(pValList
							.get(21)));
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_PREM_PAY_YRS().setSubmittedValue(
									Integer.parseInt(pValList.get(21)));*/
				/* End */
					
				}
			}
			
			/*Added by Janani for Fidelity joint life issue on 31.05.2018*/

			System.out.println("getUI_M_CUST_AGE                     "+dummy_bean.getUI_M_CUST_AGE());
		
			new CRUDHandler().executeUpdateStatement(query3, connection,new Object[] {dummy_bean.getUI_M_CUST_AGE(),pt_il_policy_bean.getPOL_SYS_ID()});
			CommonUtils.getConnection().commit();
			System.out.println("getPOAD_AGE                "+pt_il_pol_assured_dtls_bean.getPOAD_AGE());
			/*pt_il_pol_assured_dtls_bean.setPOAD_AGE(Integer
					.parseInt(dummy_bean.getUI_M_CUST_AGE()));*/
			
			if(pt_il_policy_bean.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("n"))
			{
				/*End*/
			if (null != dummy_bean.getUI_M_CUST_AGE()
					&& !dummy_bean.getUI_M_CUST_AGE().isEmpty()) {
				pt_il_policy_bean.setPOL_JOINT_LIFE_AGE(Integer
							.parseInt(dummy_bean.getUI_M_CUST_AGE()));
				
			}
			}
			
			/*Added by Janani for Fidelity joint life issue on 31.05.2018*/
			else
			{
				
			/*End*/	
				if (null == pt_il_policy_bean.getPOL_JOINT_LIFE_AGE()) {
					pt_il_policy_bean.setPOL_JOINT_LIFE_AGE(Integer
								.parseInt(dummy_bean.getUI_M_CUST_AGE()));
					
				}
			}
			
			/*Added by Janani on 18.04.2018 for Fidelity period calc*/
			
			//term_disb_SysParam = (BigDecimal)CommonUtils.getPPSystemParameterValue("IL_TERM_DFLT");
			
			
			/*Added by Janani on 06.07.2018 for FLALIFEQC-1512859(EAT, ELE, LCTF - Premium paying term should default to the policy term) 
			 * as suggested by Sivaram*/

			if(PROD_PREM_PAYING_YRS != null && PROD_PREM_PAYING_YRS.equalsIgnoreCase("s"))
			{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().setPOL_PREM_PAY_YRS(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_PERIOD());
					
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			}
			else if(PROD_PREM_PAYING_YRS != null && PROD_PREM_PAYING_YRS.equalsIgnoreCase("v"))
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(false);
			}
			else
			{
			/*End*/
			
			
			if(PROD_CALC_TERM_YN != null && PROD_CALC_TERM_YN.equalsIgnoreCase("n"))
			{
				System.out.println("POL_PERIOD       "+pt_il_policy_bean.getPOL_PERIOD());
													
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PERIOD().setDisabled(false);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(false);
			
			}
			else
			{
				if(term_disb_SysParam.intValue() == 1){
					
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PERIOD().setDisabled(true);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
					}
			}
			}
			/*End of FLA*/
			

		
			
			
			/*Added by Janani on 09.06.2017 for ZBILQC-1728495*/

			assuredAgeCheck(compositeAction);

			/*End*/
			
			/*Added by Janani on 12.05.2017 for Hands-on-feedback point*/
			
			System.out.println("before PR_IL_WARNING_MSG_SUB_STD_REG proc call");
				String status_msg = null;
			pValList1 = pkg_pilt002_apac.PR_IL_WARNING_MSG_SUB_STD_REG(currValue,null);
				
				if (pValList1.get(0) != null) {
					//pt_il_policy_bean.setP_STATUS((String) pValList1.get(0).getValueObject());
					status_msg = (String) pValList1.get(0).getValueObject();
				}
				
				System.out.println("after PR_IL_WARNING_MSG_SUB_STD_REG proc call");
				
				//System.out.println("getP_STATUS                :"+pt_il_policy_bean.getP_STATUS());
				
				
			//	throw new Exception(pt_il_policy_bean.getP_STATUS());
							
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								status_msg);
				
				/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Double POL_LC_EXC_INT_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), CommonUtils
					.getProcedureValue(currValue), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());
			if (pValList != null) {
				if (pValList.get(0) != null) {
					currValue = Double.parseDouble(pValList.get(0));
				}
			}

			lifelibProcedures.P_VAL_FC_LC_TOLERANCE(CommonUtils
					.getProcedureValue(pt_il_policy_bean
							.getPOL_FC_EXC_INT_AMT()), CommonUtils
					.getProcedureValue(currValue),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_SA_EXCH_RATE()), "E");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return currValue;
	}

	public void POL_FC_EXC_INT_AMT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		pt_il_policy_bean.setPOL_FC_EXC_INT_AMT(currValue);
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), CommonUtils
					.doubleAsString(currValue), "V", pt_il_policy_bean
					.getPOL_PROD_CODE());
			if (pValList != null && pValList.size() > 0) {
				pt_il_policy_bean.setPOL_FC_EXC_INT_AMT(Double
						.parseDouble(pValList.get(0)));
			}
			pt_il_policy_bean.setPOL_FC_CURR_SA(pt_il_policy_bean
					.getPOL_FC_SUM_ASSURED());
			pt_il_policy_bean.setPOL_LC_EXC_INT_AMT(pt_il_policy_bean
					.getPOL_FC_EXC_INT_AMT()
					* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), pt_il_policy_bean
					.getPOL_LC_EXC_INT_AMT().toString(), "R", pt_il_policy_bean
					.getPOL_PROD_CODE());
			if (pValList != null && pValList.size() > 0) {
				pt_il_policy_bean.setPOL_LC_EXC_INT_AMT(Double
						.parseDouble(pValList.get(0)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_PROFIT_RATE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = "    SELECT NVL(PP_PROFIT_RATE, 0) FROM   PM_IL_PROP_PROFIT"
				+ "  WHERE  PP_PLAN_CODE =? "
				+ "  AND   ? BETWEEN PP_PERIOD_FROM AND PP_PERIOD_TO ";
		pt_il_policy_bean.setPOL_PROFIT_RATE(currValue);
		try {
			connection = CommonUtils.getConnection();

			if (dummy_bean.getUI_M_CALC_METHOD() == 2) {
				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE(),
						pt_il_policy_bean.getPOL_PERIOD() };

				rs = handler.executeSelectStatement(query1, connection, values);
				if (rs.next()) {
					pt_il_policy_bean.setPOL_PROFIT_RATE(rs.getDouble(1));
				} else if (rs == null) {
					pt_il_policy_bean.setPOL_PROFIT_RATE(0.0);
				}
				if (pt_il_policy_bean.getPOL_SA_CURR_CODE() == pt_il_policy_bean
						.getPOL_CUST_CURR_CODE()) {

					pt_il_policy_bean.setPOL_FC_PROFIT(CommonUtils.nvl(
							CommonUtils.nvl(pt_il_policy_bean
									.getPOL_PROFIT_RATE(), 0)
									* pt_il_policy_bean.getPOL_FC_SUM_ASSURED()
									/ 1000, 0));

					pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(
							pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
							pt_il_policy_bean.getPOL_FC_PROFIT().toString(),
							"R", pt_il_policy_bean.getPOL_PROD_CODE());

					pt_il_policy_bean.setPOL_FC_PROFIT(Double
							.parseDouble(pValList.get(0)));
					pt_il_policy_bean.setPOL_LC_PROFIT(pt_il_policy_bean
							.getPOL_FC_PROFIT()
							* pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

					pValList = new ArrayList<String>();
					pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
							.getUI_M_BASE_CURR(), pt_il_policy_bean
							.getPOL_LC_PROFIT().toString(), "R",
							pt_il_policy_bean.getPOL_PROD_CODE());

					pt_il_policy_bean.setPOL_LC_PROFIT(Double
							.parseDouble(pValList.get(0)));

				} else {
					pt_il_policy_bean.setPOL_LC_PROFIT((pt_il_policy_bean
							.getPOL_LC_SUM_ASSURED() * CommonUtils.nvl(
							pt_il_policy_bean.getPOL_PROFIT_RATE(), 0)) / 1000);

					pValList = new ArrayList<String>();
					pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
							.getUI_M_BASE_CURR(), pt_il_policy_bean
							.getPOL_LC_PROFIT().toString(), "R",
							pt_il_policy_bean.getPOL_PROD_CODE());

					pt_il_policy_bean.setPOL_LC_PROFIT(Double
							.parseDouble(pValList.get(0)));

					pt_il_policy_bean.setPOL_FC_PROFIT(pt_il_policy_bean
							.getPOL_LC_PROFIT()
							/ pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

					pValList = new ArrayList<String>();
					pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(
							pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
							pt_il_policy_bean.getPOL_FC_PROFIT().toString(),
							"R", pt_il_policy_bean.getPOL_PROD_CODE());

					pt_il_policy_bean.setPOL_FC_PROFIT(Double
							.parseDouble(pValList.get(0)));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void POL_GRANTEE_TYPE_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		Connection connection = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		String query1 = " SELECT CUST_NAME " + "FROM   PM_CUSTOMER "
				+ "WHERE  CUST_CODE = ? ";
		String query2 = "SELECT CONT_NAME " + "FROM   PM_IL_CONTRACTOR "
				+ "WHERE  CONT_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			Object[] values1 = { pt_il_policy_bean.getPOL_CUST_CODE() };
			rs1 = handler.executeSelectStatement(query1, connection, values1);

			Object[] values2 = { pt_il_policy_bean.getPOL_CONT_CODE() };
			rs2 = handler.executeSelectStatement(query2, connection, values2);

			if ("B".equalsIgnoreCase(currValue)) {
				while (rs1.next()) {
					pt_il_policy_bean.setPOL_GRANTEE_NAME(rs1.getString(1));
				}
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_BANK_BRANCH_NAME().setRequired(true);
			} else if ("I".equalsIgnoreCase(currValue)) {
				while (rs2.next()) {
					pt_il_policy_bean.setPOL_GRANTEE_NAME(rs2.getString(1));
				}
				pt_il_policy_bean.setPOL_BANK_BRANCH_NAME(null);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_BANK_BRANCH_NAME().setRequired(false);
			} else if ("C".equalsIgnoreCase(currValue)) {
				pt_il_policy_bean.setPOL_BANK_BRANCH_NAME(pt_il_policy_bean
						.getPOL_CUST_CODE());
				values1 = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE() };
				rs1 = handler.executeSelectStatement(query1, connection,
						values1);
				while (rs1.next()) {
					pt_il_policy_bean.setPOL_GRANTEE_NAME(rs1.getString(1));
				}
			} else {
				pt_il_policy_bean.setPOL_GRANTEE_NAME(null);
				pt_il_policy_bean.setPOL_BANK_BRANCH_NAME(null);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_BANK_BRANCH_NAME().setRequired(false);
			}
			if ("B".equalsIgnoreCase(currValue)) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_GRANTEE_NAME().setDisabled(false);
				/*
				 * IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_GRANTEE_NAME',UPDATE_ALLOWED,PROPERTY_TRUE);
				 * END IF;
				 * SET_ITEM_PROPERTY('PT_IL_POLICY.POL_GRANTEE_NAME',NAVIGABLE,PROPERTY_TRUE);
				 */
			}
			if ("PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))
					&& "C".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_GRANTEE_TYPE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		Connection connection = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		String query1 = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ? ";
		String query2 = "SELECT CONT_NAME FROM   PM_IL_CONTRACTOR  WHERE  CONT_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			Object[] values1 = { pt_il_policy_bean.getPOL_CUST_CODE() };
			rs1 = handler.executeSelectStatement(query1, connection, values1);

			Object[] values2 = { pt_il_policy_bean.getPOL_CONT_CODE() };
			rs2 = handler.executeSelectStatement(query2, connection, values2);

			if ("B".equalsIgnoreCase(currValue)) {
				while (rs1.next()) {
					pt_il_policy_bean.setPOL_GRANTEE_NAME(rs1.getString(1));
				}
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_BANK_BRANCH_NAME().setRequired(true);
			} else if ("I".equalsIgnoreCase(currValue)) {
				while (rs2.next()) {
					pt_il_policy_bean.setPOL_GRANTEE_NAME(rs2.getString(1));
				}
				pt_il_policy_bean.setPOL_BANK_BRANCH_NAME(null);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_BANK_BRANCH_NAME().setRequired(false);
			} else if ("C".equalsIgnoreCase(currValue)) {
				pt_il_policy_bean.setPOL_BANK_BRANCH_NAME(pt_il_policy_bean
						.getPOL_CUST_CODE());
				values1 = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE() };
				rs1 = handler.executeSelectStatement(query1, connection,
						values1);
				while (rs1.next()) {
					pt_il_policy_bean.setPOL_GRANTEE_NAME(rs1.getString(1));
				}
			} else {
				pt_il_policy_bean.setPOL_GRANTEE_NAME(null);
				pt_il_policy_bean.setPOL_BANK_BRANCH_NAME(null);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_BANK_BRANCH_NAME().setRequired(false);
			}
			if ("B".equalsIgnoreCase(currValue)) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_GRANTEE_NAME().setDisabled(false);
			}
			if ("PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))
					&& "C".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void POL_PAYOR_SDCODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		try {

			if (currValue != null) {
				pValList = pkg_pilt002_apac.P_VAL_CLASS_CUST("CASH", currValue,
						pt_il_policy_bean.getUI_M_PAYOR_CONT_NAME(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, pt_il_policy_bean
								.getPOL_DIVN_CODE());
				if (pValList != null && !pValList.isEmpty()) {
					if (pValList.get(0) != null) {
						pt_il_policy_bean.setUI_M_PAYOR_CONT_NAME(pValList
								.get(0));
					}
				} else {
					pt_il_policy_bean.setUI_M_PAYOR_CONT_NAME(null);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_NO_OF_INST_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Integer currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		Integer M_POL_NO_OF_INST = 0;
		try {

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0
					&& CommonUtils.nvl(currValue, 0) == 0) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

			}

			if ("007".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				M_POL_NO_OF_INST = CommonUtils.nvl(currValue, 0);
			} else {
				M_POL_NO_OF_INST = CommonUtils.nvl(currValue, 0)
						+ CommonUtils.nvl(pt_il_policy_bean
								.getPOL_ORG_NO_OF_INST(), 0);
			}

			if ("Y".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())
					|| "S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {

				if (CommonUtils.nvl(M_POL_NO_OF_INST, 0) > 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91144",
							new Object[] {
							/*
							 * CommonUtils
							 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
							 */
							1 }));

					/*
					 * STD_MESSAGE_ROUTINE(91144,:CTRL.M_LANG_CODE,1); RAISE
					 * FORM_TRIGGER_FAILURE;
					 */
				}
			} else if ("H".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
				if (CommonUtils.nvl(M_POL_NO_OF_INST, 0) > 2) {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91144",
							new Object[] {
							/*
							 * CommonUtils
							 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
							 */
							2 }));
					/*
					 * STD_MESSAGE_ROUTINE(91144,:CTRL.M_LANG_CODE,2); RAISE
					 * FORM_TRIGGER_FAILURE;
					 */
				}
			} else if ("M".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
				if (!(pt_il_policy_bean.getPOL_PREM_PAY_YRS() == 1 && "M"
						.equals(dummy_bean.getUI_M_POL_PLAN_TYPE()))
						&& CommonUtils.nvl(M_POL_NO_OF_INST, 0) > 12) {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91144",
							new Object[] {
							/*
							 * CommonUtils
							 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
							 */
							12 }));
					/*
					 * STD_MESSAGE_ROUTINE(91144,:CTRL.M_LANG_CODE,12); RAISE
					 * FORM_TRIGGER_FAILURE;
					 */
				}
			} else if ("Q".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
				if (CommonUtils.nvl(M_POL_NO_OF_INST, 0) > 4) {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91144",
							new Object[] {
							/*
							 * CommonUtils
							 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
							 */
							4 }));
					/*
					 * STD_MESSAGE_ROUTINE(91144,:CTRL.M_LANG_CODE,4); RAISE
					 * FORM_TRIGGER_FAILURE;
					 */
				}
			}
			// --Added by Rajavel.S on 10/7/2003

			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			// "2".equals(dummy_bean.getUI_M_CALC_METHOD()

			if ("R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())
					&& ("1".equals(dummy_bean.getUI_M_CALC_METHOD()) || "2"
							.equals(dummy_bean.getUI_M_CALC_METHOD()))) {// THEN
				// --CONDITION
				// MODIFIED
				// BY
				// SIVARAM
				// :PT_IL_POLICY.POL_MODE_OF_PYMT_RATE :=
				// ROUND(1/NVL(M_POL_NO_OF_INST,1),5);
				pt_il_policy_bean.setPOL_MODE_OF_PYMT_RATE(CommonUtils.ROUND(
						((1d / CommonUtils.nvl(M_POL_NO_OF_INST, 1))), 5));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Double POL_LC_MODAL_PREM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		Connection connection = null;
		ResultSet rs = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = "SELECT PS_CODE  FROM   PP_SYSTEM  WHERE  PS_TYPE = ? ";
		String query2 = "  SELECT NVL(POL_ORG_FC_MODAL_PREM ,0) FROM   PT_IL_POLICY  WHERE  POL_SYS_ID =? ";
		String M_PS_CODE = null;
		String M_PS_CODE_1 = null;
		String M_PS_CODE_2 = null;
		Double M_POL_ORG_FC_MODAL_PREM = 0.0;
		Double M_TEMP = 0.0;

		try {

			connection = CommonUtils.getConnection();
			values = new Object[] { "IL_OCC_CHG" };
			rs = handler.executeSelectStatement(query1, connection, values);
			while (rs.next()) {
				M_PS_CODE = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);
			values = new Object[] { "IL_DEL_RIDER" };
			rs = handler.executeSelectStatement(query1, connection, values);
			while (rs.next()) {
				M_PS_CODE_1 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);
			values = new Object[] { "IL_ADD_RIDER" };
			rs = handler.executeSelectStatement(query1, connection, values);
			while (rs.next()) {
				M_PS_CODE_2 = rs.getString(1);
			}
			CommonUtils.closeCursor(rs);
			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs = handler.executeSelectStatement(query2, connection, values);
			while (rs.next()) {
				M_POL_ORG_FC_MODAL_PREM = rs.getDouble(1);
			}
			CommonUtils.closeCursor(rs);

			if ("P".equals(dummy_bean.getUI_M_COVER_SA_CALC())
					|| "V".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
				if ((!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE()) || !"S"
						.equals(dummy_bean.getUI_M_POL_PLAN_TYPE()))
						&& (!CommonUtils.nvl(dummy_bean.getUI_M_PS_CODE(),
								"000").equals(
								CommonUtils.nvl(pt_il_policy_bean
										.getPOL_END_CODE(), "000"))
								|| !CommonUtils.nvl(M_PS_CODE, "000").equals(
										CommonUtils.nvl(pt_il_policy_bean
												.getPOL_END_CODE(), "000"))
								|| !CommonUtils.nvl(M_PS_CODE_1, "000").equals(
										CommonUtils.nvl(pt_il_policy_bean
												.getPOL_END_CODE(), "000")) || !CommonUtils
								.nvl(M_PS_CODE_2, "000").equals(
										CommonUtils.nvl(pt_il_policy_bean
												.getPOL_END_CODE(), "000")))) {

					if ("013".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {
						M_TEMP = CommonUtils.nvl(pt_il_policy_bean
								.getPOL_FC_MODAL_PREM(), 0.0)
								+ CommonUtils.nvl(M_POL_ORG_FC_MODAL_PREM, 0.0);
					} else {
						M_TEMP = CommonUtils.nvl(pt_il_policy_bean
								.getPOL_FC_MODAL_PREM(), 0.0);
					}

					if (M_TEMP <= 0) {
						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71043",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					}
				}
			}
			if (pt_il_policy_bean.getPOL_FC_MODAL_PREM() != null) {
				ArrayList<String> list = pkg_pilt002_apac.P_VAL_ROUND_AMT(
						dummy_bean.getUI_M_BASE_CURR(), CommonUtils
								.doubleAsString(currValue), "V",
						pt_il_policy_bean.getPOL_PROD_CODE());

				currValue = Double.parseDouble(list.get(0));

				lifelibProcedures.P_VAL_FC_LC_TOLERANCE(CommonUtils
						.getProcedureValue(pt_il_policy_bean
								.getPOL_FC_MODAL_PREM()), CommonUtils
						.getProcedureValue(currValue), CommonUtils
						.getProcedureValue(pt_il_policy_bean
								.getPOL_SA_EXCH_RATE()), "E");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return currValue;
	}

	public void POL_SUB_PLAN_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		/*Modified by kavitha on 20.07.2018. Table has been changed from  PM_IL_PROD_APPL_PLANS to PM_IL_PROD_APPL_SUB_PLAN*/
		
		/*String query1 = "  SELECT 'X' FROM PM_IL_PROD_APPL_PLANS WHERE  PAP_SUB_PLAN_CODE =? AND  PAP_PROD_CODE =? ";
		String query2 = "  SELECT PAP_SUB_PLAN_CODE FROM PM_IL_PROD_APPL_PLANS  WHERE  PAP_SUB_PLAN_CODE  =? AND PAP_PROD_CODE =?";*/
		
		String query1 = "  SELECT 'X' FROM PM_IL_PROD_APPL_SUB_PLAN WHERE  PAP_SUB_PLAN_CODE =? AND  PAP_PROD_CODE =? ";
		String query2 = "  SELECT PAP_SUB_PLAN_CODE FROM PM_IL_PROD_APPL_SUB_PLAN  WHERE  PAP_SUB_PLAN_CODE  =? AND PAP_PROD_CODE =?";
		/*End*/
		String query3 = " SELECT  NVL(PLAN_MIN_SA,0) FROM  PM_IL_PLAN WHERE  PLAN_CODE =?  ";

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		Object[] object = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String M_DUMMY = null;
		try {
			object = new Object[] { currValue,
					pt_il_policy_bean.getPOL_PROD_CODE() };
			connection = CommonUtils.getConnection();
			if (currValue != null) {
				rs = handler.executeSelectStatement(query1, connection, object);
				if (rs.next()) {
					M_DUMMY = rs.getString(1);
				} else if (rs == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91948",
							new Object[] {
							/*
							 * CommonUtils
							 * .getGlobalVariable("GLOBAL.M_LANG_CODE"),
							 */
							currValue }));
				}

				if (compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_ASSR_CODE() != null) {

					// :PT_IL_POL_ASSURED_DTLS.POAD_BIRTH_PLACE :=
					// :PT_IL_POL_ASSURED_DTLS.POAD_BIRTH_PLACE;
				}
				if ("0".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_NO_IDX(), 0))) {
					rs = handler.executeSelectStatement(query2, connection,
							object);
					if (rs.next()) {
						pt_il_policy_bean.setUI_M_POL_SUB_PLAN_CODE_DESC(rs
								.getString(1));
					}
				}
				if ("0".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED(), 0))) {
					object = new Object[] { pt_il_policy_bean
							.getPOL_PLAN_CODE() };
					rs = handler.executeSelectStatement(query3, connection,
							object);
					if (rs.next()) {
						pt_il_policy_bean
								.setPOL_FC_SUM_ASSURED(rs.getDouble(1));
					}
				}
				
				/*NVL handled by Janani on 19.05.2018 for exchange rate null issue*/
				/*pt_il_policy_bean.setPOL_LC_SUM_ASSURED(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED()
						* pt_il_policy_bean.getPOL_SA_EXCH_RATE());*/
				
				/*
				 * 
				 * Added By Dhinesh on 05-06-2018 for FLA Funeral Changes
				 * 
				 * 
				 * pt_il_policy_bean.setPOL_LC_SUM_ASSURED(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED()
						* CommonUtils.nvl(pt_il_policy_bean.getPOL_SA_EXCH_RATE(), 0.0));*/

				/*End*/
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_DEF_PERIOD_FM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			if ((currValue > 100) || (currValue < 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"Deferred Period From", "between 0 and 100" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_DEF_PERIOD_TO_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			if ((currValue > 100) || (currValue < 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"Deferred Period To", "between 0 and 100" }));
			}
			if (currValue < pt_il_policy_bean.getPOL_DEF_PERIOD_FM()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90008",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"To Year", "From Year" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_WAQAF_PERIOD_FM_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double curValue)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		try {
			if ((curValue > 100) || (curValue < 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"Waqaf Period From", "between 0 and 100" }));
			}
			if ((curValue > pt_il_policy_bean.getPOL_DEF_PERIOD_FM())
					&& (curValue < pt_il_policy_bean.getPOL_DEF_PERIOD_TO())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_BASIC_RATE1_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		String query1 = "SELECT  NVL(TAR_RATE_PER,1000) FROM   PM_IL_TARIFF "
				+ " WHERE  TAR_PLAN_CODE  = ? "
				+ "AND   ? BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO "
				+ " AND   ? BETWEEN TAR_AGE_FROM AND TAR_AGE_TO "
				+ "  AND    TAR_FRZ_FLAG   = 'N';";
		Object[] values = {};
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		try {
			values = new Object[] {
					pt_il_policy_bean.getPOL_PLAN_CODE(),
					pt_il_policy_bean.getPOL_PERIOD(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE() };

			if (currValue < 0) { // :PT_IL_POLICY.POL_BASIC_RATE
				// < 0 THEN
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71038",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}
			rs = handler.executeSelectStatement(query1, connection, values);
			while (rs.next())
				dummy_bean.setUI_M_TAR_RATE_PER(rs.getDouble(1));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_WAQAF_PERIOD_TO_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		Double POL_WAQAF_PERIOD_TO = currValue;

		try {
			if ((POL_WAQAF_PERIOD_TO > 100) || (POL_WAQAF_PERIOD_TO < 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"Waqaf Period To", "between 0 and 100" }));
			}

			if ((POL_WAQAF_PERIOD_TO < pt_il_policy_bean
					.getPOL_WAQAF_PERIOD_FM())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90008",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						"Waqaf Period To", "To Year", "From Year" }));
			}

			if ((POL_WAQAF_PERIOD_TO > pt_il_policy_bean.getPOL_DEF_PERIOD_FM())
					&& (POL_WAQAF_PERIOD_TO < pt_il_policy_bean
							.getPOL_DEF_PERIOD_TO())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_CUST_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		Date M_CUST_EFF_FM_DT = null;
		Date M_CUST_EFF_TO_DT = null;
		String M_CUST_SRC_BUS = null;
		String M_CUST_STATUS = null;
		String M_CUST_CODE = null;
		String M_DUMMY = null;
		String M_CUST_VALID = null;
		String M_PROD_MASTER_CERT_YN = null;
		String M_CONT_REF_ID1 = null;
		String M_CONT_REF_ID2 = null;
		String M_CONT_PASS_NO = null;

		Object[] values = {};
		/*
		 * String query1 = " SELECT CONT_CODE," + " DECODE(:GLOBAL.M_LANG_CODE,
		 * 'ENG', CONT_NAME, CONT_BL_NAME)," + " DECODE(:GLOBAL.M_LANG_CODE,
		 * 'ENG', CONT_ADDR1, CONT_BL_ADDR1)," + " DECODE(:GLOBAL.M_LANG_CODE,
		 * 'ENG', CONT_ADDR2, CONT_BL_ADDR2)," + " DECODE(:GLOBAL.M_LANG_CODE,
		 * 'ENG', CONT_ADDR3, CONT_BL_ADDR3)" + " FROM PM_IL_CONTRACTOR " + "
		 * WHERE NVL(CONT_CUST_CODE,'X') = " + "DECODE(:DUMMY.M_IL_ASSRIND,1,
		 * NVL(CONT_CUST_CODE,'X')," + " NVL(:PT_IL_POLICY.POL_CUST_CODE,
		 * CONT_CUST_CODE)) AND CONT_FRZ_FLAG = 'N'";
		 */
		String query2 = "  SELECT MP_POL_NO FROM   PM_IL_MASTER_POLICY "
				+ " WHERE  MP_PROD_CODE = ? " + "   AND    MP_CUST_CODE =? ";

		String query3 = " SELECT NVL(CUST_EFF_FM_DT, TO_DATE(?)), "
				+ " NVL(CUST_EFF_TO_DT, TO_DATE(?)), CUST_STATUS"
				+ " FROM   PM_CUSTOMER" + " WHERE  CUST_CODE = ? ";

		String query4 = " SELECT CONT_REF_ID1,CONT_REF_ID2,CONT_PASS_NO FROM   PM_IL_CONTRACTOR"
				+ "  WHERE   CONT_CODE = DECODE(? ,'M',"
				+ " ?, ?)"
				+ "  AND    (CONT_REF_ID1 IS NOT NULL OR  CONT_REF_ID2 IS NOT NULL "
				+ " OR CONT_PASS_NO IS NOT NULL) ";

		String query5 = "   SELECT   CONT_CODE,  DECODE(? , 'ENG',"
				+ " CONT_NAME, CONT_BL_NAME),  "
				+ " DECODE(? ,   'ENG', CONT_ADDR1, CONT_BL_ADDR1), "
				+ "  DECODE( ? , 'ENG', CONT_ADDR2, CONT_BL_ADDR2),"
				+ "  DECODE(? , 'ENG', CONT_ADDR3, CONT_BL_ADDR3),"
				+ "   CONT_TEL_AREA_CODE||'-'||CONT_PHONE, CONT_FAX, CONT_POSTAL_CODE,"
				+ "  CONT_FAX_AREA_CODE   FROM    PM_IL_CONTRACTOR"
				+ "      WHERE   CONT_REF_ID1 = ?  ORDER BY CONT_CR_DT DESC ";

		String query6 = "   SELECT   CONT_CODE, "
				+ " DECODE(? , 'ENG', CONT_NAME, CONT_BL_NAME),"
				+ " DECODE(? , 'ENG', CONT_ADDR1, CONT_BL_ADDR1),"
				+ " DECODE(? , 'ENG', CONT_ADDR2, CONT_BL_ADDR2),"
				+ " DECODE(? , 'ENG', CONT_ADDR3, CONT_BL_ADDR3),"
				+ " CONT_TEL_AREA_CODE||'-'||CONT_PHONE,    CONT_FAX,"
				+ "   CONT_POSTAL_CODE,  CONT_FAX_AREA_CODE FROM    PM_IL_CONTRACTOR"
				+ "    WHERE   CONT_REF_ID2 = ?  ORDER BY CONT_CR_DT DESC ";

		String query7 = "    SELECT CUST_SRC_BUS   FROM   PM_CUSTOMER WHERE "
				+ " CUST_CODE = ? ";

		String query8 = " SELECT 'X'  FROM   PT_LIFE_LIA_INFO "
				+ " WHERE  NVL(LI_CUST_REF_ID1,'Y') = NVL(?,'Y')"
				+ " AND    NVL(LI_CUST_REF_ID2,'Y') = NVL( ?,'Y') ";

		String query9 = "    SELECT   CONT_CODE, "
				+ " DECODE(? , 'ENG', CONT_NAME, CONT_BL_NAME),"
				+ "  DECODE(? , 'ENG', CONT_ADDR1, CONT_BL_ADDR1),"
				+ "  DECODE(? , 'ENG', CONT_ADDR2, CONT_BL_ADDR2),"
				+ " DECODE(? , 'ENG', CONT_ADDR3, CONT_BL_ADDR3),"
				+ "  CONT_TEL_AREA_CODE||' '||CONT_PHONE,  CONT_FAX,  CONT_POSTAL_CODE, "
				+ " CONT_FAX_AREA_CODE   FROM    PM_IL_CONTRACTOR"
				+ "  WHERE   CONT_PASS_NO = ?  ORDER BY CONT_CR_DT DESC ";

		String query10 = "  SELECT 'X' FROM  PM_CUSTOMER  "
				+ " WHERE CUST_CODE= ? " + "  AND ((CUST_REF_ID1 = ? )"
				+ "  OR  (CUST_REF_ID2  = ? )" + "  OR  (CUST_PASS_NO  = ? )"
				+ " OR  (CUST_ROC_NO   = ? )) ";

		String query11 = "  SELECT PROD_MASTER_CERT_YN   FROM   PM_IL_PRODUCT  "
				+ "  WHERE  PROD_CODE =? ";

		String query12 = " SELECT CUST_NAME   FROM   PM_CUSTOMER"
				+ "  WHERE  CUST_CODE = ? ";

		ArrayList<String> pValList = new ArrayList<String>();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		//added by gopi for toi on 265/05/18
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		//end
		Connection connection = null;
		ResultSet rs = null, rs2 = null, rs3 = null, rs8 = null, rs4 = null, rs5 = null, rs6 = null, rs9 = null, rs7 = null, rs10 = null, rs12 = null;

		try {
			connection = CommonUtils.getConnection();

			String M_LANG_CODE = CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE");

			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };

			rs = handler.executeSelectStatement(query11, connection, values);
			while (rs.next()) {
				M_PROD_MASTER_CERT_YN = rs.getString(1);
			}
			if ("Y".equals(CommonUtils.nvl(M_PROD_MASTER_CERT_YN, "N"))) {

				values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE(),
						currValue };

				rs2 = handler
						.executeSelectStatement(query2, connection, values);
				if (rs2.next()) {
					pt_il_policy_bean.setPOL_MASTER_POL_NO(rs2.getString(1));
				} else if (rs2 == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91145",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			} else {
				pt_il_policy_bean.setPOL_MASTER_POL_NO(null);
			}
			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.

			if ("C".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_7"))
					&& ("1".equals(dummy_bean.getUI_M_CALC_METHOD()) || "2"
							.equals(dummy_bean.getUI_M_CALC_METHOD()))) {
				// newly added the below if condition alone for general
				// endorsement
				/*
				 * if(!("001".equals(CommonUtils.nvl(pt_il_policy_bean
				 * .getPOL_END_TYPE(), "000")))){//ended here
				 */pValList = pkg_pilt002_apac.P_VAL_CLASS_CUST("BANK",
						currValue, pt_il_policy_bean.getUI_M_POL_CUST_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG, pt_il_policy_bean
								.getPOL_DIVN_CODE());

				pt_il_policy_bean.setUI_M_POL_CUST_DESC(pValList.get(0));
				// }
			} else /* for non certificates */{

				pt_il_policy_bean.setPOL_CASH_YN(CommonUtils.nvl(
						pt_il_policy_bean.getPOL_CASH_YN(), "N"));
				if ("Y".equals(pt_il_policy_bean.getPOL_CASH_YN())) {
					pValList = new ArrayList<String>();
					/*
					 * //newly added the below if condition alone for general
					 * endorsement
					 * if(!("001".equals(CommonUtils.nvl(pt_il_policy_bean
					 * .getPOL_END_TYPE(), "000")))){//ended here
					 */pValList = pkg_pilt002_apac.P_VAL_CLASS_CUST("CASH",
							currValue, pt_il_policy_bean
									.getUI_M_POL_CUST_DESC(),
							PILT002_APAC_CONSTANTS.P_NAME_FLAG,
							PILT002_APAC_CONSTANTS.P_ERR_FLAG,
							pt_il_policy_bean.getPOL_DIVN_CODE());

					pt_il_policy_bean.setUI_M_POL_CUST_DESC(pValList.get(0));
					// }
				} else {

					pValList = new ArrayList<String>();
					// newly added the below if condition by sujatha for general
					// endorsement
					/*
					 * if(!("001".equals(CommonUtils.nvl(pt_il_policy_bean
					 * .getPOL_END_TYPE(), "000")))){//ended here
					 */pValList = pkg_pilt002_apac.P_VAL_CLASS_CUST("CUSTOMER",
							currValue, pt_il_policy_bean
									.getUI_M_POL_CUST_DESC(),
							PILT002_APAC_CONSTANTS.P_NAME_FLAG,
							PILT002_APAC_CONSTANTS.P_ERR_FLAG,
							pt_il_policy_bean.getPOL_DIVN_CODE());

					pt_il_policy_bean.setUI_M_POL_CUST_DESC(pValList.get(0));
					// }
				}
			}

			values = new Object[] { "01-JAN-1900", "12-DEC-2999", currValue };
			rs3 = handler.executeSelectStatement(query3, connection, values);
			if (rs3.next()) {
				M_CUST_EFF_FM_DT = rs3.getDate(1);
				M_CUST_EFF_TO_DT = rs3.getDate(2);
				M_CUST_STATUS = rs3.getString(3);
			}

			if ("B".equals(M_CUST_STATUS)
					&& "Y".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_8"))) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91350",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						currValue }));
			}
			if (!(pt_il_policy_bean.getPOL_ISSUE_DT().after(M_CUST_EFF_FM_DT) && pt_il_policy_bean
					.getPOL_ISSUE_DT().before(M_CUST_EFF_TO_DT))) {
				// IF :PT_IL_POLICY.POL_ISSUE_DT NOT BETWEEN M_CUST_EFF_FM_DT
				// AND M_CUST_EFF_TO_DT THEN
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91005",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}
			values = new Object[] { pt_il_policy_bean.getPOL_ASSRD_REF_ID1(),
					pt_il_policy_bean.getPOL_ASSRD_REF_ID2() };
			rs8 = handler.executeSelectStatement(query8, connection, values);
			if (rs8.next()) {
				M_DUMMY = rs8.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91350",
						new Object[] {
						/*
						 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE"),
						 */
						currValue }));
			}

			if (/* 1 == dummy_bean.getUI_M_CALC_METHOD() */dummy_bean
					.getUI_M_CALC_METHOD() != null) {

				values = new Object[] { dummy_bean.getUI_M_POL_PLAN_TYPE(),
						pt_il_policy_bean.getPOL_CONT_CODE(), currValue };
				rs4 = handler
						.executeSelectStatement(query4, connection, values);
				if (rs4.next()) {
					M_CONT_REF_ID1 = rs4.getString(1);
					M_CONT_REF_ID2 = rs4.getString(2);
					M_CONT_PASS_NO = rs4.getString(3);
				}
				if (M_CONT_REF_ID1 != null) {// &&
					// pt_il_policy_bean.getPOL_CONT_CODE()
					// == null) { //commented for
					// pol_res_address null error
					values = new Object[] { M_LANG_CODE, M_LANG_CODE,
							M_LANG_CODE, M_LANG_CODE, M_CONT_REF_ID1 };
					rs5 = handler.executeSelectStatement(query5, connection,
							values);
					if (rs5.next()) {
						/*commented by raja on 02-06-2017 for hands on feedback points*/
						/*pt_il_policy_bean.setPOL_CONT_CODE(rs5.getString(1));*/
						/*end*/
						/*modified by gopi for toi on 26/05/18*/
						String Benef_cust_flag =pt_il_policy_action.getBeneficiary_as_customer();
						 if(Benef_cust_flag!=null && !"Y".equalsIgnoreCase(Benef_cust_flag)){
						pt_il_policy_bean.setPOL_ASSURED_NAME(rs5.getString(2));
						 }
						 //end
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_1(rs5.getString(3));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_2(rs5.getString(4));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_3(rs5.getString(5));
						pt_il_policy_bean.setPOL_RES_PHONE_NO(rs5.getString(6));
						pt_il_policy_bean.setPOL_FAX_NO(rs5.getString(7));
						pt_il_policy_bean
								.setPOL_RES_AREA_CODE(rs5.getString(8));
						pt_il_policy_bean
								.setPOL_FAX_AREA_CODE(rs5.getString(9));
					}
				} else if (M_CONT_REF_ID2 != null) {// &&
					// pt_il_policy_bean.getPOL_CONT_CODE()
					// == null) {

					values = new Object[] { M_LANG_CODE, M_LANG_CODE,
							M_LANG_CODE, M_LANG_CODE, M_CONT_REF_ID2 };
					rs6 = handler.executeSelectStatement(query6, connection,
							values);
					if (rs6.next()) {
						pt_il_policy_bean.setPOL_CONT_CODE(rs6.getString(1));
						pt_il_policy_bean.setPOL_ASSURED_NAME(rs6.getString(2));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_1(rs6.getString(3));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_2(rs6.getString(4));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_3(rs6.getString(5));
						pt_il_policy_bean.setPOL_RES_PHONE_NO(rs6.getString(6));
						pt_il_policy_bean.setPOL_FAX_NO(rs6.getString(7));
						pt_il_policy_bean
								.setPOL_RES_AREA_CODE(rs6.getString(8));
						pt_il_policy_bean
								.setPOL_FAX_AREA_CODE(rs6.getString(9));
					}
				} else if (M_CONT_PASS_NO != null
						&& pt_il_policy_bean.getPOL_CONT_CODE() == null) {

					values = new Object[] { M_LANG_CODE, M_LANG_CODE,
							M_LANG_CODE, M_LANG_CODE, M_CONT_PASS_NO };
					rs9 = handler.executeSelectStatement(query9, connection,
							values);
					if (rs9.next()) {
						pt_il_policy_bean.setPOL_CONT_CODE(rs9.getString(1));
						pt_il_policy_bean.setPOL_ASSURED_NAME(rs9.getString(2));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_1(rs9.getString(3));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_2(rs9.getString(4));
						pt_il_policy_bean
								.setPOL_RES_ADDRESS_3(rs9.getString(5));
						pt_il_policy_bean.setPOL_RES_PHONE_NO(rs9.getString(6));
						pt_il_policy_bean.setPOL_FAX_NO(rs9.getString(7));
						pt_il_policy_bean
								.setPOL_RES_AREA_CODE(rs9.getString(8));
						pt_il_policy_bean
								.setPOL_FAX_AREA_CODE(rs9.getString(9));
					}
				}
				dummy_bean.setUI_M_CONT_REF_ID1(M_CONT_REF_ID1);
				dummy_bean.setUI_M_CONT_REF_ID2(M_CONT_REF_ID2);
			}

			if ("000".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				values = new Object[] { currValue };
				rs7 = handler
						.executeSelectStatement(query7, connection, values);
				if (rs7.next()) {
					M_CUST_SRC_BUS = rs7.getString(1);
				}
			}
			if (!"M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
					"X"))
					&& "N".equals(CommonUtils.nvl(M_PROD_MASTER_CERT_YN, "N"))) {
				values = new Object[] { currValue,
						pt_il_policy_bean.getPOL_ASSRD_REF_ID1(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID2(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID2(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID2() };
				rs10 = handler.executeSelectStatement(query10, connection,
						values);
				if (rs10.next()) {
					M_CUST_VALID = rs10.getString(1);
				} else if (rs10 == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91005",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}
			if ("B".equals(pt_il_policy_bean.getPOL_GRANTEE_TYPE())) {
				values = new Object[] { currValue };
				rs12 = handler.executeSelectStatement(query12, connection,
						values);
				if (pt_il_policy_bean.getPOL_GRANTEE_TYPE() != null)
					if (rs12.next()) {
						pt_il_policy_bean
								.setPOL_GRANTEE_NAME(rs12.getString(1));
					}
			}
			
			/*added by raja on 30-05-2017 for ZBILQC-1730358 */
			String custStatus=null;
			int min_age=0;
			int max_age=0;
			Date DOB=null;
			int age=0;
			ArrayList<OracleParameter> list2 = null;
			PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
			DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN();
			
			String freezQuery="SELECT PLAN_PROP_AGE_FM,PLAN_PROP_AGE_TO,CUST_DOB FROM PM_IL_PLAN ,PM_CUSTOMER WHERE PLAN_CODE=? AND CUST_CODE=?";
			ResultSet freezRS=new CRUDHandler().executeSelectStatement(freezQuery, connection, 
					new Object[]{pt_il_policy_bean.getPOL_PLAN_CODE(),pt_il_policy_bean.getPOL_CUST_CODE()});
			while(freezRS.next())
			{
				min_age=freezRS.getInt("PLAN_PROP_AGE_FM");
				max_age=freezRS.getInt("PLAN_PROP_AGE_TO");
				DOB=freezRS.getDate("CUST_DOB");
			}
			/*Added by Ameen on 30-06-2018 for FLA as per Siva sugg.*/
			Date ageDate = null;
			int ageCalc = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_AGE_CAL")).intValue();
			System.out.println("ageCalc ====>>" +ageCalc);
			if(ageCalc == 1){
				ageDate = pt_il_policy_bean.getPOL_START_DT();
			}else if(ageCalc == 2){
				ageDate = pt_il_policy_bean.getPOL_ISSUE_DT();
			}
			/*end*/
			list2 = localProcedure.P_CALC_ANB(
					//new CommonUtils().getCurrentDate(), modified by Ameen on 30-06-2018 for FLA as per Siva sugg.
					ageDate,
					DOB,
					dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
					age);
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0).getValueObject() != null) {
					age=(Integer)list2.get(0).getValueObject();
				}
			}
			
			if(age<min_age || age>max_age)
			{
				/*changed by raja on 25-07-2017 for ZBILQC-1730358*/
				throw new Exception("Customer/Policy holder code : Proposer age should between "+ min_age +" and "+ max_age);
			}
			/*end*/

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_MODE_OF_PYMT_RATE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();

		ResultSet rs = null;
		Object[] values = {};
		try {

			if (!"G".equals(CommonUtils.nvl(dummy_bean.getUI_M_COVER_SA_CALC(),
					"X"))
					&& !"N".equals(CommonUtils.nvl(dummy_bean
							.getUI_M_COVER_SA_CALC(), "X"))) {
				if (!"F".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
					if (!"007".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_PROP_END_TYPE(), "000"))) {
						if ("016".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_TYPE(), "000"))) {
							pOrclValList = new ArrayList<OracleParameter>();

							// 'NR' for normal and 'PG' for package policy using
							// menu parameter_18

							if ("NR".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18"))
									|| CommonUtils
											.getGlobalVariable("GLOBAL.M_PARAM_18") == null
									&& pt_il_policy_bean
											.getPOL_FC_SUM_ASSURED() != null
									&& pt_il_policy_bean
											.getPOL_FC_SUM_ASSURED() < 1) {
								pOrclValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL(
												pt_il_policy_bean
														.getPOL_SYS_ID(),

												pt_il_policy_bean
														.getPOL_END_NO_IDX(),

												pt_il_policy_bean
														.getPOL_END_CODE(),

												pt_il_policy_bean
														.getPOL_END_TYPE(),

												pt_il_policy_bean
														.getPOL_PREM_PAY_YRS(),

												pt_il_policy_bean
														.getPOL_ORG_NO_OF_INST(),

												pt_il_policy_bean
														.getPOL_SA_CURR_CODE(),

												pt_il_policy_bean
														.getPOL_SA_EXCH_RATE(),

												pt_il_policy_bean
														.getPOL_NO_OF_UNIT(),

												pt_il_policy_bean
														.getPOL_NO_OF_INST(),

												pt_il_policy_bean
														.getPOL_ORG_FC_SUM_ASSURED(),

												pt_il_policy_bean
														.getPOL_PLAN_CODE(),

												pt_il_pol_assured_dtls_bean
														.getPOAD_SYS_ID(),

												pt_il_policy_bean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummy_bean.getUI_M_BASE_CURR(),
												dummy_bean
														.getUI_M_COVER_VAR_VALUE(),
												pt_il_policy_bean.getROWID(),
												dummy_bean
														.getUI_M_PROD_SA_FACTOR(),
												dummy_bean
														.getUI_M_PROD_SA_TARIFF(),
												dummy_bean
														.getUI_M_COVER_SA_CALC(),
												dummy_bean.getUI_M_PS_CODE(),
												dummy_bean
														.getUI_M_POL_PLAN_TYPE(),

												pt_il_policy_bean
														.getPOL_START_DT(),

												compositeAction
														.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
														.getPT_IL_POL_ASSURED_DTLS_BEAN()
														.getPOAD_AGE(),

												dummy_bean.getUI_M_EXACT_AGE(),

												pt_il_policy_bean
														.getPOL_DEF_PERIOD_TO(),

												dummy_bean
														.getUI_M_TD_MIN_RATE(),

												dummy_bean
														.getUI_M_TD_MAX_RATE(),

												pt_il_policy_bean
														.getPOL_NEW_FC_SA(),

												pt_il_policy_bean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);

							} else if ("PG".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
								pOrclValList = pkg_pilt002_apac
										.IL_SUM_ASURED_CAL_PGC(
												pt_il_policy_bean
														.getPOL_PROD_GROUP_CODE(),
												dummy_bean
														.getUI_M_PROD_PREM_TARIFF(),

												pt_il_policy_bean
														.getPOL_SYS_ID(),

												pt_il_policy_bean
														.getPOL_END_NO_IDX(),

												pt_il_policy_bean
														.getPOL_END_CODE(),

												pt_il_policy_bean
														.getPOL_END_TYPE(),

												pt_il_policy_bean
														.getPOL_PREM_PAY_YRS(),

												pt_il_policy_bean
														.getPOL_ORG_NO_OF_INST(),

												pt_il_policy_bean
														.getPOL_SA_CURR_CODE(),

												pt_il_policy_bean
														.getPOL_SA_EXCH_RATE(),

												pt_il_policy_bean
														.getPOL_NO_OF_UNIT(),

												pt_il_policy_bean
														.getPOL_NO_OF_INST(),

												pt_il_policy_bean
														.getPOL_ORG_FC_SUM_ASSURED(),

												pt_il_policy_bean
														.getPOL_PLAN_CODE(),

												pt_il_pol_assured_dtls_bean
														.getPOAD_SYS_ID(),

												pt_il_policy_bean
														.getPOL_ORG_FC_MODAL_PREM(),
												dummy_bean.getUI_M_BASE_CURR(),
												dummy_bean
														.getUI_M_COVER_VAR_VALUE(),
												pt_il_policy_bean.getROWID(),
												dummy_bean
														.getUI_M_PROD_SA_FACTOR(),
												dummy_bean
														.getUI_M_PROD_SA_TARIFF(),
												dummy_bean
														.getUI_M_COVER_SA_CALC(),
												dummy_bean.getUI_M_PS_CODE(),
												dummy_bean
														.getUI_M_POL_PLAN_TYPE(),

												pt_il_policy_bean
														.getPOL_START_DT(),

												compositeAction
														.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
														.getPT_IL_POL_ASSURED_DTLS_BEAN()
														.getPOAD_AGE(),

												dummy_bean.getUI_M_EXACT_AGE(),

												pt_il_policy_bean
														.getPOL_DEF_PERIOD_TO(),

												dummy_bean
														.getUI_M_TD_MIN_RATE(),

												dummy_bean
														.getUI_M_TD_MAX_RATE(),

												pt_il_policy_bean
														.getPOL_NEW_FC_SA(),

												pt_il_policy_bean
														.getPOL_FC_MODAL_PREM(),
												null, null, null, null, null,
												null, null, null, null, null,
												null);

							}
							if (!pOrclValList.isEmpty() && pOrclValList != null) {

								dummy_bean
										.setUI_M_TD_MIN_RATE((Double) (pOrclValList
												.get(0).getValueObject()));

								dummy_bean
										.setUI_M_TD_MAX_RATE((Double) (pOrclValList
												.get(1).getValueObject()));

								pt_il_policy_bean
										.setPOL_NEW_FC_SA((Double) (pOrclValList
												.get(2).getValueObject()));

								pt_il_policy_bean
										.setPOL_FC_MODAL_PREM((Double) (pOrclValList
												.get(3).getValueObject()));

								pt_il_policy_bean
										.setPOL_FC_BASIC_PREM((Double) (pOrclValList
												.get(4).getValueObject()));

								pt_il_policy_bean
										.setPOL_LC_BASIC_PREM((Double) (pOrclValList
												.get(5).getValueObject()));

								pt_il_policy_bean
										.setPOL_FC_SUM_ASSURED((Double) (pOrclValList
												.get(6).getValueObject()));

								pt_il_policy_bean
										.setPOL_LC_SUM_ASSURED((Double) (pOrclValList
												.get(7).getValueObject()));

								pt_il_policy_bean
										.setPOL_FC_CURR_SA((Double) (pOrclValList
												.get(8).getValueObject()));

								pt_il_policy_bean
										.setPOL_LC_CURR_SA((Double) (pOrclValList
												.get(9).getValueObject()));

								pt_il_policy_bean
										.setPOL_ORG_NEW_LC_SA((Double) (pOrclValList
												.get(10).getValueObject()));

								pt_il_policy_bean
										.setPOL_ORG_NEW_FC_SA((Double) (pOrclValList
												.get(11).getValueObject()));

								pt_il_policy_bean
										.setPOL_NEW_LC_SA((Double) (pOrclValList
												.get(12).getValueObject()));

								pt_il_policy_bean
										.setPOL_FC_MON_ANNU_AMT((Double) (pOrclValList
												.get(13).getValueObject()));

								pt_il_policy_bean
										.setPOL_LC_MON_ANNU_AMT((Double) (pOrclValList
												.get(14).getValueObject()));
							}

						} else if ("F".equals(dummy_bean
								.getUI_M_COVER_SA_CALC()))

							pValList = new ArrayList<OracleParameter>();

						pValList = pkg_pilt002_apac.IL_CALC_SA_FACT_VALID(
								pt_il_policy_bean.getPOL_SYS_ID(),
								pt_il_policy_bean.getPOL_PLAN_CODE(),
								pt_il_policy_bean.getPOL_END_TYPE(),
								pt_il_policy_bean.getROWID(), dummy_bean
										.getUI_M_PROD_SA_FACTOR(),
								pt_il_pol_assured_dtls_bean.getPOAD_SYS_ID(),
								pt_il_policy_bean.getPOL_FC_MODAL_PREM(),
								pt_il_policy_bean.getPOL_ORG_FC_MODAL_PREM(),
								pt_il_policy_bean.getPOL_ORG_NO_OF_INST(),
								pt_il_policy_bean.getPOL_ORG_NO_OF_UNIT(),
								dummy_bean.getUI_M_PLAN_CALC_TYPE(),
								pt_il_policy_bean.getPOL_SA_CURR_CODE(),
								pt_il_policy_bean.getPOL_NO_OF_INST(),
								pt_il_policy_bean.getPOL_PROD_CODE(),
								pt_il_policy_bean.getPOL_ORG_FC_SUM_ASSURED(),
								pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
								pt_il_policy_bean.getPOL_NO_OF_UNIT(),
								pt_il_policy_bean.getPOL_NEW_FC_SA(),
								pt_il_policy_bean.getPOL_NEW_LC_SA(),
								pt_il_policy_bean.getPOL_ORG_NEW_FC_SA(),
								pt_il_policy_bean.getPOL_ORG_NEW_LC_SA(),
								pt_il_policy_bean.getPOL_FC_SUM_ASSURED(),
								pt_il_policy_bean.getPOL_LC_SUM_ASSURED());
						if (!pValList.isEmpty() && pValList != null) {
							if (pValList.get(0) != null) {
								pt_il_policy_bean
										.setPOL_NO_OF_UNIT((Double) pValList
												.get(0).getValueObject());
							}
							if (pValList.get(1) != null) {
								pt_il_policy_bean
										.setPOL_NEW_FC_SA((Double) pValList
												.get(1).getValueObject());
							}
							if (pValList.get(2) != null) {
								pt_il_policy_bean
										.setPOL_NEW_LC_SA((Double) pValList
												.get(2).getValueObject());
							}
							if (pValList.get(3) != null) {
								pt_il_policy_bean
										.setPOL_ORG_NEW_FC_SA((Double) pValList
												.get(3).getValueObject());
							}
							if (pValList.get(4) != null) {
								pt_il_policy_bean
										.setPOL_ORG_NEW_LC_SA((Double) pValList
												.get(4).getValueObject());
							}
							if (pValList.get(5) != null) {
								pt_il_policy_bean
										.setPOL_FC_SUM_ASSURED((Double) pValList
												.get(5).getValueObject());
							}
							if (pValList.get(6) != null) {
								pt_il_policy_bean
										.setPOL_LC_SUM_ASSURED((Double) pValList
												.get(6).getValueObject());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_ASSRD_REF_ID2_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		String M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_PS_VALUE = null;
		String M_DATE_CHAR = null;
		Double M_GENDER = null;
		String M_VALUE = null;
		String M_EXIST = null;
		Date M_TEMP_DATE = null;
		String M_CUST_TYPE_DESC = null;
		String M_CUST_TYPE = null;
		Double M_NEW_IC_NO_LENGTH = null;
		String M_CODE_DESC = null;
		Date M_CUST_DOB = null;
		String M_CONT_PASS_NO = null;
		String M_CONT_REF_ID2 = null;

		String query12 = "  SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER  WHERE "
				+ " NVL(CUST_REF_ID1,'X') = NVL(? ,'X');";
		String query13 = "SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER   WHERE"
				+ "  NVL(CUST_REF_ID2,'X') = NVL(?,'X') ";
		String query14 = "SELECT CUST_CODE,CUST_DOB FROM   PM_CUSTOMER "
				+ " WHERE  NVL(CUST_REF_ID1,'X') = NVL(? ,'X') "
				+ "  AND   NVL(CUST_REF_ID2,'X') = NVL( ?,'X')";

		String query15 = " SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER  "
				+ " WHERE  NVL(CUST_PASS_NO,'X') = NVL(? ,'X') ";

		String query16 = "SELECT CONT_REF_ID2,CONT_PASS_NO FROM  PM_IL_CONTRACTOR WHERE  "
				+ " CONT_CODE = ? ";
		String query17 = " SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER "
				+ " WHERE  NVL(CUST_ROC_NO,'X') = NVL(? ,'X')";

		ResultSet rs8 = null, rs1a = null, rs12 = null, rs13 = null, rs14 = null, rs15 = null, rs17 = null, rs16 = null;

		ArrayList<String> pValList = null;
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		pt_il_policy_bean.setPOL_ASSRD_REF_ID2(currValue);
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();

			if (pt_il_policy_bean.getPOL_CONT_CODE() != null
					&& "M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
				rs16 = handler.executeSelectStatement(query16, connection,
						new Object[] { pt_il_policy_bean.getPOL_CONT_CODE() });
				if (rs16.next()) {
					M_CONT_REF_ID2 = rs16.getString(1);
					M_CONT_PASS_NO = rs16.getString(2);
				}
				if (currValue != null) {
					if ((null != M_CONT_REF_ID2 && M_CONT_REF_ID2
							.equals(currValue))
							|| (null != M_CONT_PASS_NO && M_CONT_PASS_NO
									.equals(currValue))) {

					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91920"));
					}
				}
			}

			pValList = new DBProcedures().callP_VAL_SYSTEM("CUSTREFMAN",
					"CUSTREFMAN", M_CUST_TYPE_DESC, "N", M_CUST_TYPE);
			if (pValList.size() > 0) {
				M_CUST_TYPE_DESC = pValList.get(0);
				M_CUST_TYPE = pValList.get(1);
			}

			if (pt_il_policy_bean.getPOL_ASSRD_REF_ID1() == null
					&& currValue == null) {
				if (!"C".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_7"))
						&& "1".equals(M_CUST_TYPE)) {
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2()
							.setRequired(true);
				} else {
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID1()
							.setRequired(false);
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2()
							.setRequired(false);
				}
			} else {
				pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID1().setRequired(
						false);
				pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2().setRequired(
						false);
			}

			if (pt_il_policy_bean.getPOL_ASSRD_REF_ID1() == null
					&& currValue == null) {
				if ("R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())
						&& "1".equals(M_CUST_TYPE)) {
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID1()
							.setRequired(true);
				}
			}

			if (!"C".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_7"))
					&& "1".equals(M_CUST_TYPE)) {

				if (pt_il_policy_bean.getPOL_ASSRD_REF_ID1() != null
						&& currValue == null) {
					rs12 = handler.executeSelectStatement(query12, connection,
							new Object[] { pt_il_policy_bean
									.getPOL_ASSRD_REF_ID1() });
					if (rs12.next()) {
						pt_il_policy_bean.setPOL_CUST_CODE(rs12.getString(1));
						M_CUST_DOB = rs12.getDate(2);
					}
				}

				if (pt_il_policy_bean.getPOL_ASSRD_REF_ID1() == null
						&& currValue != null) {
					rs13 = handler.executeSelectStatement(query13, connection,
							new Object[] { currValue });
					if (rs13.next()) {
						System.out.println("rs13.getString(1)   : "+rs13.getString(1));
						pt_il_policy_bean.setPOL_CUST_CODE(rs13.getString(1));
						M_CUST_DOB = rs13.getDate(2);
					} else {
						rs15 = handler.executeSelectStatement(query15,
								connection, new Object[] { currValue });
						if (rs15.next()) {
							pt_il_policy_bean.setPOL_CUST_CODE(rs15
									.getString(1));
							M_CUST_DOB = rs15.getDate(2);
						} else {
							rs17 = handler.executeSelectStatement(query17,
									connection, new Object[] { currValue });
							if (rs17.next()) {
								pt_il_policy_bean.setPOL_CUST_CODE(rs17
										.getString(1));
								M_CUST_DOB = rs17.getDate(2);
							}
						}
					}
				}

				if (pt_il_policy_bean.getPOL_ASSRD_REF_ID1() != null
						&& currValue != null) {
					rs14 = handler.executeSelectStatement(query14, connection,
							new Object[] {
									pt_il_policy_bean.getPOL_ASSRD_REF_ID1(),
									currValue });
					while (rs14.next()) {
						pt_il_policy_bean.setPOL_CUST_CODE(rs14.getString(1));
						M_CUST_DOB = rs14.getDate(2);
					}
				}

				if (!(pt_il_policy_bean.getPOL_ASSRD_REF_ID1() == null && currValue == null)) {// &&
					// pt_il_policy_bean.getPOL_CUST_CODE()
					// !=
					// null

					ArrayList<OracleParameter> list = null;
					list = pkg_pilt002_apac.P_DISP_CONT_DETAILS(dummy_bean
							.getUI_M_IL_ASSRIND(), pt_il_policy_bean
							.getPOL_PROD_CODE(), pt_il_policy_bean
							.getPOL_CUST_CODE(), pt_il_policy_bean
							.getPOL_CONT_CODE(), pt_il_policy_bean
							.getPOL_MASTER_POL_NO(), CommonUtils
							.integerToString(dummy_bean.getUI_M_CALC_METHOD()),
							pt_il_policy_bean.getPOL_DIVN_CODE(),
							pt_il_policy_bean.getUI_M_POL_CUST_DESC(),
							pt_il_policy_bean.getPOL_CASH_YN(), CommonUtils
									.getProcedureValue(pt_il_policy_bean
											.getPOL_ISSUE_DT()), CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_7"),
							null, null, null, null, null, null, null, null,
							null, null, null, null, null, null, null, null,
							null, null);
					if (list != null && !list.isEmpty()) {
						if (list.get(0).getValueObject() != null) {
							pt_il_policy_bean.setPOL_CONT_CODE((String) list
									.get(0).getValueObject());
						}
						if (list.get(1).getValueObject() != null) {
							pt_il_policy_bean
									.setPOL_MASTER_POL_NO((String) list.get(1)
											.getValueObject());
						}
						if (list.get(2).getValueObject() != null) {
							// newly added the below if condition alone for
							// general endorsement
							/*
							 * if(!("001".equals(CommonUtils.nvl(pt_il_policy_bean
							 * .getPOL_END_TYPE(), "000")))){//ended here
							 */pt_il_policy_bean
									.setUI_M_POL_CUST_DESC((String) list.get(2)
											.getValueObject());
							// }
						}
						if (list.get(3).getValueObject() != null) {
							pt_il_policy_bean.setPOL_CASH_YN((String) list.get(
									3).getValueObject());
						}
						if (list.get(4).getValueObject() != null) {
							pt_il_policy_bean.setPOL_ASSURED_NAME((String) list
									.get(4).getValueObject());
						}
						if (list.get(5).getValueObject() != null) {
							pt_il_policy_bean
									.setPOL_RES_ADDRESS_1((String) list.get(5)
											.getValueObject());
						}
						if (list.get(6).getValueObject() != null) {
							pt_il_policy_bean
									.setPOL_RES_ADDRESS_2((String) list.get(6)
											.getValueObject());
						}
						if (list.get(7).getValueObject() != null) {
							pt_il_policy_bean
									.setPOL_RES_ADDRESS_3((String) list.get(7)
											.getValueObject());
						}
						if (list.get(8).getValueObject() != null) {
							pt_il_policy_bean.setPOL_RES_PHONE_NO((String) list
									.get(8).getValueObject());
						}
						if (list.get(9).getValueObject() != null) {
							pt_il_policy_bean.setPOL_FAX_NO((String) list
									.get(9).getValueObject());
						}
						if (list.get(10).getValueObject() != null) {
							pt_il_policy_bean
									.setPOL_RES_AREA_CODE((String) list.get(10)
											.getValueObject());
						}
						if (list.get(11).getValueObject() != null) {
							pt_il_policy_bean
									.setPOL_FAX_AREA_CODE((String) list.get(11)
											.getValueObject());
						}
						if (list.get(12).getValueObject() != null) {
							pt_il_policy_bean.setPOL_CITY_CODE((String) list
									.get(12).getValueObject());
						}
						if (list.get(13).getValueObject() != null) {
							pt_il_policy_bean.setPOL_STATE_CODE((String) list
									.get(13).getValueObject());
						}
						if (list.get(14).getValueObject() != null) {
							pt_il_policy_bean.setPOL_COUNT_CODE((String) list
									.get(14).getValueObject());
						}
						if (list.get(15).getValueObject() != null) {
							pt_il_policy_bean.setPOL_MOBILE_NO((String) list
									.get(15).getValueObject());
						}
						if (list.get(16).getValueObject() != null) {
							pt_il_policy_bean
									.setUI_M_POL_CITY_NAME((String) list
											.get(16).getValueObject());
						}
						if (list.get(17).getValueObject() != null) {
							pt_il_policy_bean
									.setUI_M_POL_STATE_NAME((String) list.get(
											17).getValueObject());
						}
						if (list.get(18).getValueObject() != null) {
							pt_il_policy_bean
									.setUI_M_POL_COUNT_NAME((String) list.get(
											18).getValueObject());
						}
						if (list.get(19).getValueObject() != null) {
							dummy_bean.setUI_M_CONT_REF_ID1((String) list.get(
									19).getValueObject());
						}
						if (list.get(20).getValueObject() != null) {
							dummy_bean.setUI_M_CONT_REF_ID2((String) list.get(
									20).getValueObject());
						}
						if (list.get(21).getValueObject() != null) {
							pt_il_policy_bean.setPOL_SRC_OF_BUS((String) list
									.get(21).getValueObject());
						}
					}
				}
			}
			/*Added by Ameen on 23-04-2018 for KIC cust and assured same issue*/
			String contCodeQry = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE "
					+ "NVL(CUST_REF_ID1,'X') = NVL(?,'X') ";
			ResultSet contCodeRS = null;
			
				if(pt_il_policy_bean.getPOL_ASSRD_REF_ID1()!=null && pt_il_policy_bean.getPOL_ASSRD_REF_ID2()!=null){
					if(!pt_il_policy_bean.getPOL_ASSRD_REF_ID1().equalsIgnoreCase(pt_il_policy_bean.getPOL_ASSRD_REF_ID2())){
						
						contCodeRS = handler.executeSelectStatement(contCodeQry, connection,
									new Object[]{pt_il_policy_bean.getPOL_ASSRD_REF_ID2()});
						if(contCodeRS.next()) {
							pt_il_policy_bean.setPOL_CONT_CODE(contCodeRS.getString(1));
						}
					}
				}
			/*End*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs12);
				CommonUtils.closeCursor(rs13);
				CommonUtils.closeCursor(rs14);
				CommonUtils.closeCursor(rs16);
				CommonUtils.closeCursor(rs17);
				CommonUtils.closeCursor(rs15);
				CommonUtils.closeCursor(rs1a);
				CommonUtils.closeCursor(rs8);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*Added By Dhinesh 5.8.2016    */ 
	
	/*public  void P_POL_ASSR_DELT(	String Pol_sys_id,String AssuredRefID,String P_ASSRD_REF_ID)
			throws SQLException, Exception {


		System.out.println("Enter the P_POL_ASSR_DELT  procedure ");
		System.out.println("Pol_sys_id   : "+Pol_sys_id);
		System.out.println("AssuredRefID : "+AssuredRefID);
		

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",Pol_sys_id);
		parameterList.add(param1);	
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",AssuredRefID);
		parameterList.add(param2);	
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, CommonUtils.getConnection(),"P_POL_ASSR_DELT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		
	}*/
	
	/*Modified by saritha on 02-Feb-2018 Feneral Plan(207) Dependant save Record inserted &updated null error as per siva sir sugg.*/
	public  ArrayList<OracleParameter> P_POL_ASSR_DELT
	(Object Pol_sys_id,
			Object  AssuredRefID,
			Object  Pol_Old_AssuredRefId)throws ProcedureException {

		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();

			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, Pol_sys_id);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, AssuredRefID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, Pol_Old_AssuredRefId);
			parameterList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_POL_ASSR_DELT");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}	
	/*End*/
	
	
	public void POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		String M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_PS_VALUE = null;

		String M_DATE_CHAR = null;
		Double M_GENDER = null;
		String M_VALUE = null;
		String M_EXIST = null;
		Date M_TEMP_DATE = null;

		String M_CUST_TYPE_DESC = null;
		String M_CUST_TYPE = null;

		Double M_LENGTH_1 = null;
		Double M_NEW_IC_NO_LENGTH = null;
		Double M_REF_ID_1_LENGTH = null;
		String M_CODE_DESC = "";
		Date M_CUST_DOB = null;
		String M_CONT_REF_ID1 = null;
		String M_CUST_REF_ID1 = null;
		String PM_IL_CONTRACTOR = null;

		String LENTH_QUERY = "SELECT DATA_LENGTH  FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PT_IL_POLICY'  AND COLUMN_NAME = 'POL_ASSRD_REF_ID1'";

		String query8 = " SELECT SUBSTR(? ,1,6) FROM   DUAL; ";
		/*Changed by raja on 02-06-2017 for hands on points*/
		/*Modified by Janani on 23.08.2017 for ZBILQC-1736019*/
		/*String query12 = "SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER  WHERE UPPER(CUST_CODE) LIKE UPPER('IND%') AND"
				+ " NVL(CUST_REF_ID1,'X') = NVL(? ,'X')";*/
		
		String query12 = "SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER  WHERE UPPER(CUST_CLASS) IN UPPER('INDL') AND"
				+ " NVL(CUST_REF_ID1,'X') = NVL(? ,'X')";
		
		/*End of ZBILQC-1736019*/
		/*end*/
		String query13 = "SELECT CUST_CODE,CUST_DOB  FROM   PM_CUSTOMER   WHERE"
				+ "  NVL(CUST_REF_ID2,'X') = NVL(?,'X') ";
		String query14 = "SELECT CUST_CODE,CUST_DOB FROM   PM_CUSTOMER "
				+ " WHERE  NVL(CUST_REF_ID1,'X') = NVL(? ,'X') ";
		// + " AND NVL(CUST_REF_ID2,'X') = NVL( ?,'X') ";
		String query16 = " SELECT   CONT_REF_ID1  FROM  PM_IL_CONTRACTOR WHERE  "
				+ " CONT_CODE = ? ";
		String query17 = " SELECT CUST_REF_ID1      FROM   PM_CUSTOMER "
				+ "  WHERE  CUST_CODE =? ";

		String query10 = "  SELECT 'X' FROM  PM_CUSTOMER  "
				+ " WHERE CUST_CODE= ? " + "  OR ((CUST_REF_ID1 = ? )"
				+ "  OR  (CUST_REF_ID2  = ? )" + "  OR  (CUST_PASS_NO  = ? )"
				+ " OR  (CUST_ROC_NO   = ? )) ";

		String query19 = "SELECT CUST_PASS_NO FROM   PM_CUSTOMER  WHERE "
				+ " NVL(CUST_REF_ID1,'X') = NVL(? ,'X')";
		
		
		/*Added by Janani on 16.06.2018 as per Sivaram's sugg for KIC assured
		 *  dtsl not getting defaulted from tabbing out of customer civil id*/
		String query20 = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_CALC_MTHD'";
		ResultSet rst25 = null;
		Double ps_value = 0.0;
		/*End*/

		Object[] object8 = {}, object12 = {}, object13 = {}, object1a = {}, object14 = {}, object5 = {}, object16 = {}, object17 = {};
		ResultSet rs8 = null, rs19 = null, rs1a = null, rs12 = null, rs13 = null, rs14 = null, rs17 = null, rs16 = null, rs10 = null;

		ArrayList<String> pValList = new ArrayList<String>();

		ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			ResultSet resultSet = handler.executeSelectStatement(LENTH_QUERY,
					connection);
			if (resultSet.next()) {
				M_REF_ID_1_LENGTH = resultSet.getDouble(1);

			}
			CommonUtils.closeCursor(resultSet);
			object8 = new Object[] { currValue };
			object12 = new Object[] { currValue };

			object16 = new Object[] { pt_il_policy_bean.getPOL_CONT_CODE() };
			object17 = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE() };

			pValList = procedures.callP_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
					M_CODE_DESC, "N",// PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					CommonUtils.doubleAsString(M_NEW_IC_NO_LENGTH));

			M_CODE_DESC = pValList.get(0);
			M_NEW_IC_NO_LENGTH = Double.parseDouble(pValList.get(1));
			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
					M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);

			/*if (currValue.length() != M_LENGTH_1) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91915",
						new Object[] { M_LENGTH_1 }));
			}*/
			pValList = new ArrayList<String>();
			pValList = procedures.callP_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", M_PS_VALUE);
			if (!(pValList.isEmpty()) && pValList != null) {
				M_CODE_DESC = pValList.get(0);
				M_PS_VALUE = pValList.get(1);
			}

			if ("1".equals(M_PS_VALUE)) {
				if (!"N".equals(CommonUtils.nvl(M_EXIST, "N"))
						&& "1".equals(pt_il_policy_bean.getPOL_DS_TYPE())
						|| ("2".equals(pt_il_policy_bean.getPOL_DS_TYPE()) && "0"
								.equals(pt_il_policy_bean.getPOL_END_NO_IDX()))) {

					rs8 = new CRUDHandler().executeSelectStatement(query8,
							connection, object8);
					while (rs8.next()) {
						M_DATE_CHAR = rs8.getString(1);
					}
				}
			}

			pValList = new ArrayList<String>();
			pValList = procedures.callP_VAL_SYSTEM("CUSTREFMAN", "CUSTREFMAN",
					M_CUST_TYPE_DESC, "N", M_CUST_TYPE);
			if (pValList != null && !(pValList.isEmpty())) {
				M_CUST_TYPE_DESC = pValList.get(0);
				M_CUST_TYPE = pValList.get(1);
			}

			if (currValue == null
					&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() == null) {
				if (!"C".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_7"))
						&& "1".equals(M_CUST_TYPE)) {
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2()
							.setRequired(true);
				} else {
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID1()
							.setRequired(false);
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2()
							.setRequired(false);
				}
			} else {
				pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID1().setRequired(
						false);
				pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2().setRequired(
						false);
			}

			if (currValue == null
					&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() == null) {
				if ("R".equals(dummy_bean.getUI_M_PLAN_RED_SA_BASIS())
						&& "1".equals(M_CUST_TYPE)) {
					pt_il_policy_action.getCOMP_POL_ASSRD_REF_ID2()
							.setRequired(true);
				}
			}
			
			if (/*
				 * "M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE()) &&
				 */"1".equals(M_CUST_TYPE)) {
				if (currValue != null
						&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() == null) {

					pValList = new ArrayList<String>();
					pValList = pkg_pilt002_apac.P_DISP_CONT_DETAILS_1(
							dummy_bean.getUI_M_IL_ASSRIND(), pt_il_policy_bean
									.getPOL_CUST_CODE(), pt_il_policy_bean
									.getPOL_PROD_CODE(), currValue,
							pt_il_policy_bean.getPOL_ASSRD_REF_ID2(),
							CommonUtils.integerToString(dummy_bean
									.getUI_M_CALC_METHOD()), pt_il_policy_bean
									.getPOL_CONT_CODE(), null, null, null,
							null, null, null, null, null, null, null, null,
							null, null, null, null, null, null);
					if (pValList != null && !(pValList.isEmpty())) {
						
						//Commented By Raja 29.6.2016
						/* pt_il_policy_bean.setPOL_CONT_CODE(pValList.get(0));
						pt_il_policy_bean.setPOL_ASSURED_NAME(pValList.get(1));
						*/
						
						/*Added By Raja 29.6.2016*/
						
						if(!(pt_il_policy_bean.isASSURED_NAME_FLAG()))
						{
							
							/*changed by raja on 06-06-2017 for hands on feedback points*/
						/*pt_il_policy_bean.setPOL_CONT_CODE(pValList.get(0));
						
						pt_il_policy_bean.setPOL_ASSURED_NAME(pValList.get(1));*/
							
							rs12 = handler.executeSelectStatement(query12, connection,
									object12);
							LIFELIB lifelib = new LIFELIB();
							List<String>pvalList = new ArrayList<String>();
							while (rs12.next()) {
								/*modified by gopi for toi on 26/05/18*/
								String Benef_cust_flag =pt_il_policy_action.getBeneficiary_as_customer();
								 if(Benef_cust_flag!=null && !"Y".equalsIgnoreCase(Benef_cust_flag)){
								/*Newly Added By Dhinesh on 12-04-2018*/
								if(pt_il_policy_bean.getPOL_CONT_CODE()==null)
								{
									pt_il_policy_bean.setPOL_CONT_CODE(rs12.getString(1));	
								}
							/*	End*/
								
								 }
								}
														
								System.out.println("premium payer code == >"+pt_il_policy_bean.getPOL_CONT_CODE());
								if(pt_il_policy_bean.getPOL_CONT_CODE()!=null)
								{
									/*changed by raja on 09-06-2017 for ZBILQC-1724894*/
									pvalList = lifelib.P_VAL_CUST_NAME(pt_il_policy_bean.getPOL_CONT_CODE(),
											pt_il_policy_bean.getPOL_ASSURED_NAME(), "N", "N",
											pt_il_policy_bean.getPOL_DIVN_CODE());
										/*
										 * 
										 * COMMENTED BY DHINESH ON 14-06-2017 FOR ENDORSEMENT ISSUE - CHANGE IN NAME - AFTER CHANGED ASSURED NAME - WHILE CLICK SAVE BUTON CUSTOMER NAME DEFAULT 
										 * 
										 * if (!pvalList.isEmpty()) {
											
											pt_il_policy_bean.setPOL_ASSURED_NAME(pvalList.get(0).toString());
										
										}*/
									
									if (!pvalList.isEmpty())
									{

										if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN001")))
										{
											pt_il_policy_bean.setPOL_ASSURED_NAME(pvalList.get(0).toString());	
										}
									}
									
										
								}
						/*end*/		
						}
						
						/*End*/
						
						if (!currValue.equalsIgnoreCase(pt_il_policy_bean
								.getPOL_ASSRD_REF_ID1())) {
							// pt_il_policy_bean.setPOL_RES_ADDRESS_1(pValList.get(2));
							pt_il_policy_bean.setPOL_RES_ADDRESS_1("CHN");
							pt_il_policy_bean.setPOL_RES_ADDRESS_2(pValList
									.get(3));
							pt_il_policy_bean.setPOL_RES_ADDRESS_3(pValList
									.get(4));
							pt_il_policy_bean.setPOL_RES_PHONE_NO(pValList
									.get(5));
							pt_il_policy_bean.setPOL_FAX_NO(pValList.get(6));
							pt_il_policy_bean.setPOL_RES_AREA_CODE(pValList
									.get(7));
							pt_il_policy_bean.setPOL_FAX_AREA_CODE(pValList
									.get(8));
							pt_il_policy_bean.setPOL_CITY_CODE(pValList.get(9));
							pt_il_policy_bean.setPOL_STATE_CODE(pValList
									.get(10));
							pt_il_policy_bean.setPOL_COUNT_CODE(pValList
									.get(11));
							pt_il_policy_bean
									.setPOL_MOBILE_NO(pValList.get(12));
							pt_il_policy_bean.setUI_M_POL_CITY_NAME(pValList
									.get(13));
							pt_il_policy_bean.setUI_M_POL_STATE_NAME(pValList
									.get(14));
							pt_il_policy_bean.setUI_M_POL_COUNT_NAME(pValList
									.get(15));
							dummy_bean.setUI_M_CONT_REF_ID1(pValList.get(16));
							dummy_bean.setUI_M_CONT_REF_ID2(pValList.get(17));
						}
					}
				}

				if (currValue != null
						&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() != null) {

					pValList = new ArrayList<String>();
					pValList = pkg_pilt002_apac.P_DISP_CONT_DETAILS_1(
							dummy_bean.getUI_M_IL_ASSRIND(), pt_il_policy_bean
									.getPOL_CUST_CODE(), pt_il_policy_bean
									.getPOL_PROD_CODE(), currValue,
							pt_il_policy_bean.getPOL_ASSRD_REF_ID2(),
							CommonUtils.integerToString(dummy_bean
									.getUI_M_CALC_METHOD()), pt_il_policy_bean
									.getPOL_CONT_CODE(), null, null, null,
							null, null, null, null, null, null, null, null,
							null, null, null, null, null, null);
					if (pValList != null && !(pValList.isEmpty())) {
						/*Newly Added By Dhinesh on 12-04-2018*/	
						if(pt_il_policy_bean.getPOL_CONT_CODE() == null)
						{
							pt_il_policy_bean.setPOL_CONT_CODE(pValList.get(0));
						}
							/*End*/
					
						
						/*added by raja on 02-06-2017 for hands on points*/
						if(CommonUtils.nvl( pt_il_policy_bean.getUI_M_CUST_FLAG(), "N").equalsIgnoreCase("N"))
						{
						pt_il_policy_bean.setPOL_CUST_CODE(pValList.get(0));
						}
						/*end*/
						
						/*pt_il_policy_bean.setPOL_ASSURED_NAME(pValList.get(1));*/
						
						/*if(pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN001")))*/
						if(pt_il_policy_bean.getPOL_END_CODE() != null && !(CommonUtils.isIN(pt_il_policy_bean.getPOL_END_CODE(), "GEN001","GEN012")))
						{
							pt_il_policy_bean.setPOL_ASSURED_NAME(pValList.get(1).toString());	
						}
						
						/* Newly Added By Dhinesh on 25-04-2018 */
						if(pt_il_policy_bean.getPOL_END_CODE() == null || (pt_il_policy_bean.getPOL_END_CODE() != null && !(pt_il_policy_bean.getPOL_END_CODE().equals("GEN015"))))
						{
						pt_il_policy_bean.setPOL_RES_ADDRESS_1(pValList.get(2));
						pt_il_policy_bean.setPOL_RES_ADDRESS_2(pValList.get(3));
						pt_il_policy_bean.setPOL_RES_ADDRESS_3(pValList.get(4));
						pt_il_policy_bean.setPOL_RES_PHONE_NO(pValList.get(5));
						pt_il_policy_bean.setPOL_FAX_NO(pValList.get(6));
						pt_il_policy_bean.setPOL_RES_AREA_CODE(pValList.get(7));
						pt_il_policy_bean.setPOL_FAX_AREA_CODE(pValList.get(8));
						pt_il_policy_bean.setPOL_CITY_CODE(pValList.get(9));
						pt_il_policy_bean.setPOL_STATE_CODE(pValList.get(10));
						pt_il_policy_bean.setPOL_COUNT_CODE(pValList.get(11));
						pt_il_policy_bean.setPOL_MOBILE_NO(pValList.get(12));
						pt_il_policy_bean.setUI_M_POL_CITY_NAME(pValList
								.get(13));
						pt_il_policy_bean.setUI_M_POL_STATE_NAME(pValList
								.get(14));
						pt_il_policy_bean.setUI_M_POL_COUNT_NAME(pValList
								.get(15));
						}
						/* End */
						dummy_bean.setUI_M_CONT_REF_ID1(pValList.get(16));
						dummy_bean.setUI_M_CONT_REF_ID2(pValList.get(17));
					}
				}
			}

			if (!"C".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_7"))
					&& "1".equals(M_CUST_TYPE)) {
				System.out.println("<<<<<<<<<<<<GlobalVariableGLOBAL.M_PARAM_7>>>>>>>>>>>>"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_7"));
				/*Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_002-Customer Master Changes COMMENTS*/
				LIFELIB lifelib = new LIFELIB();
				List<String>pvalList = new ArrayList<String>();
				/*end*/
				if (currValue != null
						&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() == null) {
					rs12 = handler.executeSelectStatement(query12, connection,
							object12);
					while (rs12.next()) {
						
						/*added by raja on 02-06-2017 for hands on points*/
						if(CommonUtils.nvl( pt_il_policy_bean.getUI_M_CUST_FLAG(), "N").equalsIgnoreCase("N"))
						{
						pt_il_policy_bean.setPOL_CUST_CODE(rs12.getString(1));
						}
						/*end*/
						/*Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_002-Customer Master Changes COMMENTS*/
						/*if condition Added by R. Raja on 01-06-2017 for ZBILQC-1724387*/
						/*if(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.POL_PREM_CODE"),"false").equalsIgnoreCase("false"))
						{*/
						if( CommonUtils.nvl(pt_il_policy_bean.getUI_M_PREM_PAYR_FLAG(), "N").equalsIgnoreCase("N"))
						{
						/*end*/
						pt_il_policy_bean.setPOL_PREM_PAYER_CODE(rs12.getString(1));
						System.out.println("premium payer code == >"+pt_il_policy_bean.getPOL_PREM_PAYER_CODE());
						if(pt_il_policy_bean.getPOL_PREM_PAYER_CODE()!=null)
						{
							/*changed by raja on 09-06-2017 for ZBILQC-1724894*/
							pvalList = lifelib.P_VAL_CUST_NAME(pt_il_policy_bean.getPOL_PREM_PAYER_CODE(),
									pt_il_policy_bean.getUI_M_POL_PREM_PAYER_CODE_DESC(), "N", "N",
									pt_il_policy_bean.getPOL_DIVN_CODE());
								if (!pvalList.isEmpty()) {
									
									pt_il_policy_bean.setUI_M_POL_PREM_PAYER_CODE_DESC(pvalList.get(0).toString());
								
								}
						}
						/*}*/
						}
						/*end*/
						M_CUST_DOB = rs12.getDate(2);
					}
				}

				if (currValue == null
						&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() != null
						&& !pt_il_policy_bean.getPOL_ASSRD_REF_ID2().isEmpty()) {
					object13 = new Object[] { pt_il_policy_bean
							.getPOL_ASSRD_REF_ID2() };
					rs13 = handler.executeSelectStatement(query13, connection,
							object13);
					while (rs13.next()) {
						pt_il_policy_bean.setPOL_CUST_CODE(rs13.getString(1));
						M_CUST_DOB = rs13.getDate(2);
					}
				}
				/*
				 * if (currValue != null &&
				 * pt_il_policy_bean.getPOL_ASSRD_REF_ID2() != null &&
				 * !(pt_il_policy_bean.getPOL_ASSRD_REF_ID2().isEmpty())) {
				 * 
				 * object14 = new Object[] { currValue,
				 * pt_il_policy_bean.getPOL_ASSRD_REF_ID2() }; rs14 =
				 * handler.executeSelectStatement(query14, connection,
				 * object14); while (rs14.next()) {
				 * pt_il_policy_bean.setPOL_CUST_CODE(rs14.getString(1));
				 * M_CUST_DOB = rs14.getDate(2); } }
				 * 
				 * if (currValue != null &&
				 * pt_il_policy_bean.getPOL_ASSRD_REF_ID2() != null &&
				 * !pt_il_policy_bean.getPOL_ASSRD_REF_ID2().isEmpty()) {// && //
				 * pt_il_policy_bean.getPOL_CUST_CODE()!=null) // {//commented //
				 * for // pol_res_address_1 // null // error
				 * 
				 * pValList = new ArrayList<String>(); pValList1 = new
				 * ArrayList<OracleParameter>();
				 * 
				 * pValList1 = pkg_pilt002_apac.P_DISP_CONT_DETAILS(dummy_bean
				 * .getUI_M_IL_ASSRIND(), pt_il_policy_bean .getPOL_PROD_CODE(),
				 * pt_il_policy_bean .getPOL_CUST_CODE(), pt_il_policy_bean
				 * .getPOL_CONT_CODE(), pt_il_policy_bean
				 * .getPOL_MASTER_POL_NO(), CommonUtils
				 * .integerToString(dummy_bean.getUI_M_CALC_METHOD()),
				 * pt_il_policy_bean.getPOL_DIVN_CODE(),
				 * pt_il_policy_bean.getUI_M_POL_CUST_DESC(),
				 * pt_il_policy_bean.getPOL_CASH_YN(), CommonUtils
				 * .getProcedureValue(pt_il_policy_bean .getPOL_ISSUE_DT()),
				 * CommonUtils .getGlobalVariable("GLOBAL.M_PARAM_7"), null,
				 * null, null, null, null, null, null, null, null, null, null,
				 * null, null, null, null, null, null, null);
				 * 
				 * if (pValList1 != null && !(pValList1.isEmpty())) {
				 * pt_il_policy_bean.setPOL_CONT_CODE((String) pValList1
				 * .get(0).getValueObject()); pt_il_policy_bean
				 * .setPOL_MASTER_POL_NO((String) pValList1.get(1)
				 * .getValueObject()); //newly added the below if condition
				 * alone for general endorsement
				 * if(!("001".equals(CommonUtils.nvl(pt_il_policy_bean
				 * .getPOL_END_TYPE(), "000")))){//ended here pt_il_policy_bean
				 * .setUI_M_POL_CUST_DESC((String) pValList1
				 * .get(2).getValueObject()); //}
				 * pt_il_policy_bean.setPOL_CASH_YN((String) pValList1
				 * .get(3).getValueObject()); pt_il_policy_bean
				 * .setPOL_ASSURED_NAME((String) pValList1.get(4)
				 * .getValueObject()); pt_il_policy_bean
				 * .setPOL_RES_ADDRESS_1((String) pValList1.get(5)
				 * .getValueObject()); pt_il_policy_bean
				 * .setPOL_RES_ADDRESS_2((String) pValList1.get(6)
				 * .getValueObject()); pt_il_policy_bean
				 * .setPOL_RES_ADDRESS_3((String) pValList1.get(7)
				 * .getValueObject()); pt_il_policy_bean
				 * .setPOL_RES_PHONE_NO((String) pValList1.get(8)
				 * .getValueObject()); pt_il_policy_bean.setPOL_FAX_NO((String)
				 * pValList1.get( 9).getValueObject()); pt_il_policy_bean
				 * .setPOL_RES_AREA_CODE((String) pValList1
				 * .get(10).getValueObject()); pt_il_policy_bean
				 * .setPOL_FAX_AREA_CODE((String) pValList1
				 * .get(11).getValueObject());
				 * pt_il_policy_bean.setPOL_CITY_CODE((String) pValList1
				 * .get(12).getValueObject());
				 * pt_il_policy_bean.setPOL_STATE_CODE((String) pValList1
				 * .get(13).getValueObject());
				 * pt_il_policy_bean.setPOL_COUNT_CODE((String) pValList1
				 * .get(14).getValueObject());
				 * pt_il_policy_bean.setPOL_MOBILE_NO((String) pValList1
				 * .get(15).getValueObject()); pt_il_policy_bean
				 * .setUI_M_POL_CITY_NAME((String) pValList1.get(
				 * 16).getValueObject()); pt_il_policy_bean
				 * .setUI_M_POL_STATE_NAME((String) pValList1.get(
				 * 17).getValueObject()); pt_il_policy_bean
				 * .setUI_M_POL_COUNT_NAME((String) pValList1.get(
				 * 18).getValueObject());
				 * dummy_bean.setUI_M_CONT_REF_ID1((String) pValList1.get(
				 * 19).getValueObject());
				 * dummy_bean.setUI_M_CONT_REF_ID2((String) pValList1.get(
				 * 20).getValueObject());
				 * pt_il_policy_bean.setPOL_SRC_OF_BUS(CommonUtils.nvl( (String)
				 * pValList1.get(21).getValueObject(),
				 * pt_il_policy_bean.getPOL_SRC_OF_BUS())); } }
				 */
			}

			if (pt_il_policy_bean.getPOL_CONT_CODE() != null
					&& "M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
				rs16 = handler.executeSelectStatement(query16, connection,
						object16);
				while (rs16.next()) {
					M_CONT_REF_ID1 = rs16.getString(1);
				}

				if ("0".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_NO_IDX(), 0))) {
					if (currValue != null) {
						if (currValue != M_CONT_REF_ID1) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91919"));
						}
					}
				}

				if ("001".equals(pt_il_policy_bean.getPOL_END_TYPE())
						&& currValue != null) {
					if (!M_CONT_REF_ID1.substring(0, 5).equals(
							currValue.substring(0, 5))) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91919"));
					}
				}
			} else if (pt_il_policy_bean.getPOL_CONT_CODE() != null
					&& !"M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
				rs17 = handler.executeSelectStatement(query17, connection,
						object17);
				while (rs17.next()) {
					M_CUST_REF_ID1 = rs17.getString(1);
				}

				if ("0".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_NO_IDX(), 0))) {
					if (currValue != null) {
						if (currValue != M_CUST_REF_ID1) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91919"));
						}
					}
				} else {

					if ("001".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))
							&& currValue != null && M_CONT_REF_ID1 != null) {
						if (!(currValue.substring(0, 5).equals(M_CONT_REF_ID1
								.substring(0, 5)))) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91919"));
						}
					}
				}
			}

			if (pt_il_policy_bean.getPOL_CUST_CODE() == null
					&& !"M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				Object[] values = new Object[] {
						pt_il_policy_bean.getPOL_CUST_CODE(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID1(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID2(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID2(),
						pt_il_policy_bean.getPOL_ASSRD_REF_ID2() };
				rs10 = handler.executeSelectStatement(query10, connection,
						values);
				if (rs10.next()) {
					// M_CUST_VALID = rs10.getString(1);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91173",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}
			
			/*Modified by Janani on 16.06.2018 as per Sivaram's sugg for KIC assured
			 *  dtsl not getting defaulted from tabbing out of customer civil id*/			
			/*if (currValue != null
					&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() == null)*/
			
			rst25 = handler.executeSelectStatement(query20, connection);
			if (rst25.next()) {
				
				ps_value = rst25.getDouble(1);
			}
			
			if (currValue != null
					&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() == null && ps_value == 1)
			{
				rs19 = handler.executeSelectStatement(query19, connection,
						object12);
				if (rs19.next()) {
					pt_il_policy_bean.setPOL_ASSRD_REF_ID2(rs19.getString(1));

				}
			}
			/*
			 * commented By Dhinesh on 12-04-2018 
			 * 
			 * else if (currValue != null
					&& pt_il_policy_bean.getPOL_ASSRD_REF_ID2() != null) {
				rs19 = handler.executeSelectStatement(query19, connection,
						object12);
				if (rs19.next()) {
					pt_il_policy_bean.setPOL_ASSRD_REF_ID2(rs19.getString(1));

				}
			}*/
			
			/*added by raja on 30-05-2017 for ZBILQC-1724894 */
			/*String freezFlag=null;
			String custStatus=null;
			String freezQuery="SELECT CUST_FRZ_FLAG,CUST_STATUS FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
			ResultSet freezRS=new CRUDHandler().executeSelectStatement(freezQuery, connection, 
					new Object[]{pt_il_policy_bean.getPOL_ASSRD_REF_ID1()});
			
			while(freezRS.next())
			{
				freezFlag=freezRS.getString("CUST_FRZ_FLAG");
				custStatus=freezRS.getString("CUST_STATUS");
			}
			
			if(custStatus.equalsIgnoreCase("D") && freezFlag.equalsIgnoreCase("Y"))
			{
				throw new Exception("Customer Code is Inactive");
			}
			*/
			/*end*/
			
			/*added by raja on 30-05-2017 for ZBILQC-1730358 */
			/*String custStatus=null;
			int min_age=0;
			int max_age=0;
			Date DOB=null;
			int age=0;
			ArrayList<OracleParameter> list2 = null;
			PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
			DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN();
			
			String freezQuery="SELECT PLAN_PROP_AGE_FM,PLAN_PROP_AGE_TO,CUST_DOB FROM PM_IL_PLAN ,PM_CUSTOMER WHERE PLAN_CODE=? AND CUST_REF_ID1=?";
			ResultSet freezRS=new CRUDHandler().executeSelectStatement(freezQuery, connection, 
					new Object[]{pt_il_policy_bean.getPOL_PLAN_CODE(),pt_il_policy_bean.getPOL_ASSRD_REF_ID1()});
			while(freezRS.next())
			{
				min_age=freezRS.getInt("PLAN_PROP_AGE_FM");
				max_age=freezRS.getInt("PLAN_PROP_AGE_TO");
				DOB=freezRS.getDate("CUST_DOB");
			}
			list2 = localProcedure.P_CALC_ANB(
					new CommonUtils().getCurrentDate(), 
					DOB,
					dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
					age);
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0).getValueObject() != null) {
					age=(Integer)list2.get(0).getValueObject();
				}
			}
			
			if(age<min_age || age>max_age)
			{
				changed by raja on 25-07-2017 for ZBILQC-1730358
				throw new Exception("Proposer age should between "+ min_age +" and "+ max_age);
			}*/
			/*end*/
			/*Added by Ameen on 23-04-2018 for KIC cust and assured same issue*/
			/*String custCodeQry = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE "
					+ "NVL(CUST_REF_ID1,'X') = NVL(?,'X') ";*/
			String custCodeQry = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE "
					+ "NVL(CUST_REF_ID1,'X') = NVL(?,'X') ";
			ResultSet contCodeRS = null;
			if(pt_il_policy_bean.getPOL_END_NO_IDX() != null && pt_il_policy_bean.getPOL_END_NO_IDX() > 0 && 
					pt_il_policy_bean.getPOL_END_CODE()!=null && "GEN012".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE())){
				contCodeRS = handler.executeSelectStatement(custCodeQry, connection,
						new Object[]{pt_il_policy_bean.getPOL_ASSRD_REF_ID1()});
				if(contCodeRS.next()) {
					if(CommonUtils.getGlobalVariable("GLOBAL.M_POL_ASSRD_REF_ID1").toString().equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.M_POL_ASSRD_REF_ID2").toString()))
					{
					//pt_il_policy_bean.setPOL_ASSRD_REF_ID2(pt_il_policy_bean.getPOL_ASSRD_REF_ID1());
					pt_il_policy_bean.setPOL_CUST_CODE(contCodeRS.getString(1));
					pt_il_policy_bean.setUI_M_POL_CUST_DESC(contCodeRS.getString(2));
					/*pt_il_policy_bean.setPOL_CONT_CODE(contCodeRS.getString(1));
					pt_il_policy_bean.setPOL_ASSURED_NAME(contCodeRS.getString(2));*/
					pt_il_policy_bean.setPOL_PREM_PAYER_CODE(contCodeRS.getString(1));
					pt_il_policy_bean.setUI_M_POL_PREM_PAYER_CODE_DESC(contCodeRS.getString(2));
					
					}else
					{
						pt_il_policy_bean.setPOL_CUST_CODE(contCodeRS.getString(1));
						pt_il_policy_bean.setUI_M_POL_CUST_DESC(contCodeRS.getString(2));
						pt_il_policy_bean.setPOL_PREM_PAYER_CODE(contCodeRS.getString(1));
						pt_il_policy_bean.setUI_M_POL_PREM_PAYER_CODE_DESC(contCodeRS.getString(2));
					}	
				}
			}
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs12);
				CommonUtils.closeCursor(rs13);
				CommonUtils.closeCursor(rs14);
				CommonUtils.closeCursor(rs16);
				CommonUtils.closeCursor(rs1a);
				CommonUtils.closeCursor(rs17);
				CommonUtils.closeCursor(rs8);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void POL_PROP_NO_WHEN_VALIDATE_ITEM(String POL_DS_TYPE,
			String currValue) throws Exception {
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		try {
			local_procedures.IL_UNIQUE_POL_PROP_NO(POL_DS_TYPE, currValue);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POL_EMPLOYER_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY pt_il_policy_bean, String currValue) throws Exception {
		ArrayList<String> pValList = new ArrayList<String>();
		try {

			if (currValue != null) {
				pValList = pkg_pilt002_apac.P_VAL_CONT_CODE(currValue,
						pt_il_policy_bean.getUI_M_CONT_NAME(),
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);
				pt_il_policy_bean.setUI_M_CONT_NAME(pValList.get(0));
			} else {
				pt_il_policy_bean.setUI_M_CONT_NAME(null);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_INCORPORATED_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		ArrayList<String> pValList = new ArrayList<String>();

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		try {

			if ("Y".equals(CommonUtils.nvl(currValue, "N"))) {
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setRequired(true);

				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setDisabled(false);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setRequired(true);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(false);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(false);
			} else if ("N".equals(CommonUtils.nvl(currValue, "N"))) {

				pt_il_policy_bean.setPOL_FC_BANK_ALLOC_AMT(0.0);
				pt_il_policy_bean.setPOL_LC_BANK_ALLOC_AMT(0.0);
				pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(0.0);
				pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(0.0);
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_INCORPORATED_YN_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		ArrayList<String> pValList = new ArrayList<String>();

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		try {

			if ("Y".equals(CommonUtils.nvl(currValue, "N"))) {
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setDisabled(false);

				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_BANK_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);

				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_BANK_ALLOC_AMT',UPDATE_ALLOWED,PROPERTY_TRUE);
				}

				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setRequired(true);

				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setDisabled(false);

				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_BANK_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_BANK_ALLOC_AMT',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setRequired(true);

				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setDisabled(false);

				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_CLIENT_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_CLIENT_ALLOC_AMT',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setRequired(true);

				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setDisabled(false);

				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_CLIENT_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_CLIENT_ALLOC_AMT',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setRequired(true);

				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(false);

				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_TOT_SA',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_TOT_SA',UPDATE_ALLOWED,PROPERTY_TRUE);
				}

				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(false);

				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_TOT_SA',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_TOT_SA',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
			} else if ("N".equals(CommonUtils.nvl(currValue, "N"))) {
				pt_il_policy_bean.setPOL_FC_BANK_ALLOC_AMT(0.0);
				pt_il_policy_bean.setPOL_LC_BANK_ALLOC_AMT(0.0);
				pt_il_policy_bean.setPOL_FC_CLIENT_ALLOC_AMT(0.0);
				pt_il_policy_bean.setPOL_LC_CLIENT_ALLOC_AMT(0.0);

				pt_il_policy_bean.setPOL_FC_TOT_SA(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED());
				pt_il_policy_bean.setPOL_LC_TOT_SA(pt_il_policy_bean
						.getPOL_LC_SUM_ASSURED());

				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setDisabled(true);

				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setDisabled(true);

				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
						.setRequired(false);

				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POL_DEFER_PRD_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY pt_il_policy_bean, Double currValue) throws Exception {
		ArrayList<String> pValList = new ArrayList<String>();
		String query1 = " SELECT NVL(PROD_MAX_DEFER_MONTHS,0) FROM   PM_IL_PRODUCT  "
				+ "  WHERE  PROD_CODE =?  ";
		Double M_PROD_MAX_DEFER_MONTHS = 0.0;

		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};

		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
			rs = handler.executeSelectStatement(query1, connection, values);
			while (rs.next())
				M_PROD_MAX_DEFER_MONTHS = rs.getDouble(1);

			if (CommonUtils.nvl(currValue, 0.0) > CommonUtils.nvl(
					M_PROD_MAX_DEFER_MONTHS, 0.0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91154",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void PRE_DELETE(PT_IL_POLICY pt_il_policy_bean) throws Exception {

		Object[] object = {}, objectPT_IL_DOC_TODO_LIST_STATUS = {};
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			object = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			objectPT_IL_DOC_TODO_LIST_STATUS = new Object[] {
					pt_il_policy_bean.getPOL_SYS_ID(),
					pt_il_policy_bean.getPOL_END_NO_IDX() };
			handler.executeDeleteStatement(
					PT_IL_POLICY_QUERY_CONSTANTS.preDeletePT_IL_POL_CHARGE,
					connection, object);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_CREATE_RECORD(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_POLICY_ACTION policyAction = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY policyBean = policyAction.getPT_IL_POLICY_BEAN();

		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String query1 = " SELECT NVL(PLAN_CREDIT_YN,'N')    FROM   PM_IL_PLAN "
				+ " WHERE  PLAN_CODE     = ?  AND    PLAN_FRZ_FLAG =? ";

		String query2 = " SELECT PROD_DEF_PERIOD_FM, PROD_DEF_PERIOD_TO, PROD_WAQAF_PERIOD_FM, "
				+ " PROD_WAQAF_PERIOD_TO  FROM   PM_IL_PRODUCT"
				+ "   WHERE  PROD_CODE =? ";

		String query3 = " SELECT NVL(COVER_MIN_SA,0) FROM   PM_IL_COVER"
				+ " WHERE  COVER_CODE = ? ";

		String query4 = " SELECT PROD_TARIFF_TERM_FLAG  FROM   PM_IL_PRODUCT"
				+ "   WHERE  PROD_CODE =? ";
		
		//added by gopi for toi on 25/05/2018
		String query5 = "SELECT COVER_SA_FIXED,COVER_SA_CALC FROM PM_IL_COVER WHERE COVER_CODE= ? ";
		//end
		
		PCOPK_SYS_VARS pcopk_sys_vars = new PCOPK_SYS_VARS();
		Double M_RATE_PER = null;
		Double M_RATE = null;
		Double M_COVER_MIN_SA = null;
		Connection connection = null;
		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5=null,rs6=null;
		Object[] object1 = {}, object2 = {}, object3 = {}, object4 = {},object5={},object6={};
		CRUDHandler handler = new CRUDHandler();

		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC localProcedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> arrayList = null;
		ArrayList<String> pvalList = null;
		/*ADDED BY GOPI FOR TOI ON 25/05/18*/
		Double COVER_FIXED_AMOUNT = null;
		String Cover_SA_cal=null;
		String Benef_cust_flag=null;
		//END
		try {

			pcopk_sys_vars.P_SET_PARA_VALUES(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"), CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DIVN_CODE"), CommonUtils
					.getGlobalVariable("GLOBAL.M_DEPT_CODE"), dummy_bean
					.getUI_M_BASE_CURR(), "2", CommonUtils.getControlBean()
					.getM_PROG_NAME());

			connection = CommonUtils.getConnection();
			object1 = new Object[] {
					CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3"),
					PILT002_APAC_CONSTANTS.PLAN_FRZ_FLAG };
			object2 = new Object[] { CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_6") };
			object3 = new Object[] { policyBean.getPOL_PLAN_CODE() };

			object4 = new Object[] { CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_6") };

			if (policyAction.isINSERT_ALLOWED() == true) {
				policyBean.setPOL_DIVN_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_DIVN_CODE"));
				policyBean.setPOL_DEPT_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_DEPT_CODE"));
				policyBean.setPOL_CLASS_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_2"));

				arrayList = lifelibProcedures.P_VAL_DIVN(policyBean
						.getPOL_DIVN_CODE(),
						policyBean.getUI_M_POL_DIVN_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);

				if (arrayList != null && arrayList.size() > 0) {
					policyBean.setUI_M_POL_DIVN_DESC((String) arrayList.get(0)
							.getValue());
				}

				/*Modified by Saranya on 04/04/2017
				 * 
				 * CommonUtils.setGlobalVariable("GLOBAL.M_DIVN_CODE", policyBean
						.getPOL_DIVN_CODE());*/
				System.out.println("PT_IL_POLICY_HELPER ----- WHEN_CREATE_RECORD() ");
				System.out.println("POL_DIVN_CODE        : "+policyBean.getPOL_DIVN_CODE());
				
				System.out.println("POL_DEPT_CODE        : "+policyBean.getPOL_DEPT_CODE());
				
				System.out.println("UI_M_POL_DEPT_DESC   : "+policyBean.getUI_M_POL_DEPT_DESC());
				
				arrayList = new ArrayList<OracleParameter>();
				arrayList = lifelibProcedures.P_VAL_DEPT(policyBean
						.getPOL_DIVN_CODE(), policyBean.getPOL_DEPT_CODE(),
						policyBean.getUI_M_POL_DEPT_DESC(),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);

				if (arrayList != null && arrayList.size() > 0) {
					policyBean.setUI_M_POL_DEPT_DESC((String) arrayList.get(0)
							.getValue());
				}

				if (!("PILP052_APAC").equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))
						&& !"Q".equals(policyBean.getPOL_PROP_QUOT_FLAG())) {

					arrayList = new ArrayList<OracleParameter>();

					arrayList = lifelibProcedures.P_VAL_CLASS(policyBean
							.getPOL_CLASS_CODE(), policyBean
							.getUI_M_POL_CLASS_DESC(),
							PILT002_APAC_CONSTANTS.P_NAME_FLAG,
							PILT002_APAC_CONSTANTS.P_ERR_FLAG);

					if (arrayList != null && arrayList.size() > 0) {
						policyBean.setUI_M_POL_CLASS_DESC((String) arrayList
								.get(0).getValue());
					}
				}

				policyBean.setPOL_PROD_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_6"));

				// added for setting the description in POL_PROD_CODE when form
				// is initialised
				pvalList = localProcedures.PILT002_APAC_P_VAL_PRODUCT(
						CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6"),
						CommonUtils.getProcedureValue(new CommonUtils()
								.getCurrentDate()),
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);
				if (pvalList != null && !pvalList.isEmpty()) {
					if (pvalList.get(0) != null) {
						policyBean.setUI_M_PROD_DESC(pvalList.get(0));
					}

				}
				policyBean.setPOL_PLAN_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_3"));

				// added for setting the description in POL_PLAN_CODE when form
				// is initialised
				pvalList = procedures.callP_VAL_PLAN(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_3"),
						PILT002_APAC_CONSTANTS.P_NAME_FLAG,
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);

				policyBean.setUI_M_POL_PLAN_DESC(pvalList.get(0));

				policyBean.setPOL_SA_CURR_CODE(dummy_bean.getUI_M_BASE_CURR());

				// COMMENTED BY HANEEF,AKASH ,THE DESC SET ON ONBLUR .

				// added for setting the description in POL_SA_CURR_CODE when
				// form is initialised
				/*
				 * pvalList = procedures.callP_VAL_CURR(dummy_bean
				 * .getUI_M_BASE_CURR(), PILT002_APAC_CONSTANTS.P_NAME_FLAG,
				 * PILT002_APAC_CONSTANTS.P_ERR_FLAG, policyBean
				 * .getPOL_CUST_CODE());
				 * policyBean.setUI_M_POL_SA_CURR_DESC(pvalList.get(0));
				 */

				policyBean
						.setPOL_CUST_CURR_CODE(dummy_bean.getUI_M_BASE_CURR());

				// added for setting the description for CUST_CURR_CODE when
				// form is initialised
				/*
				 * pvalList = pkg_pilt002_apac.P_VAL_CURR(dummy_bean
				 * .getUI_M_BASE_CURR(), policyBean
				 * .getUI_M_POL_CUST_CURR_DESC(),
				 * PILT002_APAC_CONSTANTS.P_NAME_FLAG,
				 * PILT002_APAC_CONSTANTS.P_ERR_FLAG, policyBean
				 * .getPOL_CUST_CODE());
				 * policyBean.setUI_M_POL_CUST_CURR_DESC(pvalList.get(0));
				 */

				/*policyBean.setPOL_ISSUE_DT(new CommonUtils().getCurrentDate());*/
				//modified by gopi for toi on 01/06/18
				policyBean.setPOL_ISSUE_DT(new CommonUtils().getCurrentDateAndTimeNew());
				/*policyBean.setPOL_ISSUE_DT(new CommonUtils().getCurrentDateAndTimeWithSec());*/
				//end
				
				policyBean.setPOL_PROP_RECV_DT(new CommonUtils()
						.getCurrentDate());
				policyBean.setPOL_PROP_STAMP_DT(new CommonUtils()
						.getCurrentDate());
				policyBean.setPOL_PROD_GROUP_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARA_14"));
				policyBean.setPOL_MODE_OF_PYMT(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_5"));
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_5").equals(
						"S")) {
					policyBean.setPOL_PREM_PAY_YRS(1);
				}
				policyBean.setPOL_DS_CODE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_1"));
				policyBean.setPOL_DS_TYPE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_11"));

				rs1 = handler.executeSelectStatement(query1, connection,
						object1);
				if (rs1.next()) {
					policyBean.setPOL_CREDIT_YN(rs1.getString(1));
				}
				if (!"M".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
					policyBean.setPOL_CREDIT_INT_RATE(0d);
				}

				if ("D".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
					rs2 = handler.executeSelectStatement(query2, connection,
							object2);
					if (rs2.next()) {
						policyBean.setPOL_DEF_PERIOD_FM(rs2.getDouble(1));
						policyBean.setPOL_DEF_PERIOD_TO(rs2.getDouble(2));
						policyBean.setPOL_WAQAF_PERIOD_FM(rs2.getDouble(3));
						policyBean.setPOL_WAQAF_PERIOD_TO(rs2.getDouble(4));
					}
				}

			}

			rs4 = handler.executeSelectStatement(query4, connection, object4);
			if (rs4.next()) {

				policyBean.setPOL_TARIFF_TERM_FLAG(rs4.getString(1));
			}

			policyBean.setUI_M_SURR_MAT("S");
			policyBean.setPOL_CASH_YN("Y");
			policyBean.setPOL_FAC_YN("N");
			policyBean.setPOL_FAC_BASIS("A");
			policyBean.setPOL_CREDIT_YN("N");
			policyBean.setPOL_RATE_APPLIED_ON("S");
			policyBean.setPOL_JOINT_LIFE_YN("N");
			// policyBean.setPOL_TARIFF_TERM_FLAG("2");
			policyBean.setPOL_STAFF_YN("N");
			policyBean.setPOL_STD_RISK_YN("Y");
			policyBean.setPOL_CQS_YN("N");
			policyBean.setPOL_PREM_WAIVE_YN("N");
			policyBean.setPOL_INCORPORATED_YN("N");
			policyBean.setPOL_NET_PREM_YN("N");
			policyBean.setPOL_MODE_OF_CALC(CommonUtils.nvl(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_9"), "S"));
			/*	As per siva sir suggested for this ssp call id ZBILQC-1718566 changing default value is p*/
			/*pt_il_policy_bean.setPOL_PYMT_TYPE("C");*/
			/*
			 * modified by Ameen on 12-10-2017 as per chandramohan sugg. for ZBLIFE-1447440
			 * policyBean.setPOL_PYMT_TYPE("P");*/
			policyBean.setPOL_PYMT_TYPE("N");
			/*End*/
			policyBean.setPOL_FRZ_FLAG("N");
			
			
			/*Added by sankara narayanan for uicomponent frz flag on 21-03-2017*/
			policyBean.setUI_POL_FRZ_FLAG("N");
			/*end*/
			
			policyBean.setPOL_NO_OF_INST(1);
			policyBean.setPOL_HOME_OWNER_FLAG("N");
			policyBean.setPOL_ORG_PROP_RECV_YN("Y");
			policyBean.setPOL_FC_BANK_ALLOC_AMT(0d);
			policyBean.setPOL_LC_BANK_ALLOC_AMT(0d);
			policyBean.setPOL_FC_CLIENT_ALLOC_AMT(0d);
			policyBean.setPOL_LC_CLIENT_ALLOC_AMT(0d);
			policyBean.setPOL_MED_FEE_RECOVER_YN("N");
			policyBean.setPOL_FLEX_14("N");
			policyBean.setPOL_FLEX_09("N");
			policyBean.setPOL_FLEX_11("1");
			// ---ADDED BY SIVARAM FOR ANNUITY PRODUCTS
			policyBean.setPOL_DEF_IMM_FLAG("D");

			if ("I".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_10"))) {
				policyBean.setPOL_GRANTEE_TYPE("I");
			} else {
				policyBean.setPOL_GRANTEE_TYPE("B");
			}

			policyAction.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			policyAction.getCOMP_POL_TARIFF_TERM_FLAG().setDisabled(true);
			policyAction.getCOMP_POL_FC_DISC_AMT().setDisabled(true);
			policyAction.getCOMP_POL_LC_DISC_AMT().setDisabled(true);

			if ("1".equals(policyBean.getPOL_DS_TYPE())) {
				if (!"Q".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_13"))
						&& !"1".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_11"))) {
					dummyAction.getCOMP_UI_M_BUT_HOLD().setRendered(true);
				}
				dummyAction.getCOMP_UI_M_BUT_CONVERT().setRendered(true);
				policyAction.getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL().setValue(
						"Prop LC Dep. Amt");
				policyAction.getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL().setValue(
						"Prop FC Dep. Amt");
				policyBean.setPOL_FC_DEPOSIT_AMOUNT(0.000);
				policyBean.setPOL_LC_DEPOSIT_AMOUNT(0.000);
				policyBean.setPOL_CONVERT_YN("N");
			} else {
				dummyAction.getCOMP_UI_M_BUT_HOLD().setRendered(true);
				dummyAction.getCOMP_UI_M_BUT_CONVERT().setRendered(false);
				policyAction.getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL().setValue(
						"LC First Premium");
				policyAction.getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL().setValue(
						"FC First Premium");
			}

			if ("1".equalsIgnoreCase(policyBean.getPOL_DS_TYPE())
					|| ("2".equalsIgnoreCase(policyBean.getPOL_DS_TYPE()) && !"010"
							.equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000")))) {

				policyAction.getCOMP_POL_EXC_INT_PERC().setDisabled(true);
				policyAction.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
				policyAction.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true);
			}

			if ("2".equals(policyBean.getPOL_DS_TYPE())
					&& "010".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))) {
				policyAction.getCOMP_POL_EXC_INT_PERC().setDisabled(false);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_EXC_INT_PERC',UPDATE_ALLOWED,PROPERTY_TRUE);
				}
				// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_EXC_INT_PERC',NAVIGABLE,PROPERTY_TRUE);
				policyAction.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
				policyAction.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true);

			} else {
				policyAction.getCOMP_POL_EXC_INT_PERC().setDisabled(true);
				policyAction.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
				policyAction.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true);
			}

			if ("E".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
				rs3 = handler.executeSelectStatement(query3, connection,
						object3);
				if (rs3.next()) {
					M_COVER_MIN_SA = rs3.getDouble(1);
				}
				policyBean.setPOL_FC_SUM_ASSURED(M_COVER_MIN_SA);
				policyBean.setPOL_LC_SUM_ASSURED(M_COVER_MIN_SA);
			}

			pvalList = new P9ILPK_POLICY().P_GET_MOP_RATE(CommonUtils
					.getProcedureValue(policyBean.getPOL_PLAN_CODE()),
					CommonUtils.getProcedureValue(policyBean
							.getPOL_MODE_OF_PYMT()), CommonUtils
							.getProcedureValue(policyBean.getPOL_START_DT()),
					CommonUtils.getProcedureValue(M_RATE), CommonUtils
							.getProcedureValue(M_RATE_PER));
			// new
			if (pvalList != null && !pvalList.isEmpty()) {
				M_RATE = pvalList.get(0) != null ? Double.parseDouble(pvalList
						.get(0)) : null;
				M_RATE_PER = pvalList.get(1) != null ? Double
						.parseDouble(pvalList.get(1)) : null;
			}

			policyBean.setPOL_MODE_OF_PYMT_RATE(CommonUtils.ROUND((CommonUtils
					.nvl(M_RATE, 0) / CommonUtils.nvl(M_RATE_PER, 1)), 5));

			policyBean.setPOL_PROFIT_RATE(4d);
			policyAction.getCOMP_POL_PROFIT_RATE().setDisabled(true);

			enabledisableJointlife(compositeAction);
			
			
			policyBean.setPOL_DISPATCH_MTD("P");
			
			/*Added by saritha on 10-07-2017 for ssp call id ZBILQC-1731155*/
			String Mode_Of_Payment = policyBean.getPOL_MODE_OF_PYMT();
			System.out.println("MOP  "+Mode_Of_Payment);
			
			if("M".equalsIgnoreCase(Mode_Of_Payment)){
				policyBean.setPOL_NO_OF_INST(12);
				
			}
			/*End*/
			/*Added by ganesh on 01-02-2018 for APL field should based on product master APL Flag suggested by siva*/
			String pol_apl_flag = policyAction.POl_APL();
			if (pol_apl_flag != null) {
				policyBean.setPOL_APL_YN(pol_apl_flag);
				policyAction.getCOMP_PROD_INS_APL_YN().setDisabled(
						("N".equalsIgnoreCase(pol_apl_flag)) ? true : false);
			}
			/*end*/
			
			//added by gopi for toi on 25/05/18
			object5 = new Object[] { policyBean.getPOL_PROD_CODE()};
			rs5 = handler.executeSelectStatement(query5, connection, object5);
			if (rs5.next()) {

				COVER_FIXED_AMOUNT=rs5.getDouble("COVER_SA_FIXED");
				Cover_SA_cal=rs5.getString("COVER_SA_CALC");
			}
			if(Cover_SA_cal!=null && "I".equalsIgnoreCase(Cover_SA_cal))
			{
				policyBean.setPOL_FC_SUM_ASSURED(COVER_FIXED_AMOUNT);
				policyAction.getCOMP_POL_FC_SUM_ASSURED().resetValue();	
			}
			
			//end
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewRecordInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		Double M_VALUE = null;
		Integer M_MAX_POL_END_NO_IDX = null;
		Double M_TEMP_VAL = null;
		Double M_COUNT = null;
		Double M_MAX_END_NO_IDX = null;
		String M_CODE_DESC = null;
		String M_PS_CODE = null;
		String M_DUMMY = null;
		String M_CONVERT = null;
		Boolean M_TEMP = null;
		String M_CODE_DESCRIPTION = null;
		String M_CODE_DESCRIPTION_1 = null;
		String M_USER_PERM = null;
		String M_CURR_BLK = null;
		String M_CURR_ITEM = null;
		String M_DUMMY1 = null;
		String M_TEMP_ITEM = null;
		String M_DUMMY2 = null;
		String M_COVER_SA_CALC = null;
		String M_PROD_AUTO_UW = null;
		String M_LAPSED = null;
		String M_CREDIT_CARD_UPD_YN = null;
		Double M_PS_VALUE_1 = null;
		String M_COVER_PREM_TYPE = null;
		String CURSOR_C1 = "SELECT PS_CODE FROM   PP_SYSTEM WHERE  PS_TYPE ='IL_CIC_CVR'";
		String CURSOR_C2 = "SELECT DISTINCT 'X' FROM PT_IL_CLAIM_COVER_DTLS,PT_IL_CLAIM  WHERE  CCD_COVER_CODE = ? "
				+ "AND CCD_CLAIM_SYS_ID = CLAIM_SYS_ID AND  CLAIM_POL_SYS_ID = ? AND CCD_FRZ_FLAG = 'Y' AND CCD_CONFIRM_FLAG = 'Y'";
		String CURSOR_C2A = "SELECT COUNT(POL_SYS_ID) FROM   PT_IL_POLICY WHERE  POL_NO =  ? AND POL_DS_TYPE = ? ";
		/*
		 * MODIFIED BY AMEEN ON 02-06-2017 AS PER SIVA SUGG. TO ENABLE APPROVAL BTN IF CHECKLIST IS IN WAIVED STATUS
		 * String CURSOR_C3 = "SELECT DISTINCT 'X' FROM   PT_IL_DOC_TODO_LIST_STATUS WHERE  DTLS_POL_SYS_ID = ? AND"
				+ "  DTLS_END_NO_IDX = ?  AND DTLS_GROUP_CODE IN (SELECT DTG_GROUP_CODE FROM PM_IL_DOC_TODO_GROUP"
				+ " WHERE DTG_DS_TYPE = DECODE( ? ,'1',?,DECODE(?,0,?,'3')) AND   DTG_DS_CODE = NVL( ? , ?) AND DTG_GROUP_TYPE ='CHKLST')"
				+ " AND  DTLS_APPR_STS IN ('NA','N') AND    NVL(DTLS_MANDATORY_YN,'N') ='Y' ";*/
		String CURSOR_C3 = "SELECT DISTINCT 'X'  FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_POL_SYS_ID = ? AND DTLS_END_NO_IDX = ? AND "
				+ "DTLS_GROUP_CODE IN (SELECT DTG_GROUP_CODE FROM PM_IL_DOC_TODO_GROUP WHERE DTG_DS_TYPE = DECODE(?, '1', ?, DECODE(?, 0, ?, '3'))"
				+ " AND DTG_DS_CODE = NVL(?, ?) AND DTG_GROUP_TYPE = 'CHKLST') AND DTLS_APPR_STS IN ('N') AND NVL(DTLS_MANDATORY_YN, 'N') = 'Y'";
		String CURSOR_C3A = "SELECT MAX(POL_END_NO_IDX) FROM  PT_IL_POLICY  WHERE  POL_NO = ? AND POL_DS_TYPE = ? ";
		String CURSOR_C5 = "SELECT PROD_PERIOD,PROD_AGE_CALC_FLAG,NVL(PROD_AUTO_UW,'N') FROM   PM_IL_PRODUCT "
				+ " WHERE  PROD_CODE =  ? ";
		String CURSOR_C6 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  PLAN_CODE = ? AND  PLAN_FRZ_FLAG = 'N' ";
		String CURSOR_C8 = "SELECT NVL(POLH_O_MODE_OF_PYMT,'M') FROM  PH_IL_POLICY WHERE  POLH_SYS_ID = ? AND POLH_N_END_NO_IDX = ? ";
		String CURSOR_C10 = "SELECT PS_CODE FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_DEC_SA' ";
		String CURSOR_C12 = "SELECT  ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE  ASD_USER_ID =  ?  AND     ASD_CODE = 'CHG_PRO_STAT' "
				+ "AND  ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";
		String CURSOR_C13 = "SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET WHERE  ASD_USER_ID = ? AND ASD_CODE = 'CHG_POL_STAT'"
				+ "AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
		String CURSOR_C14 = "SELECT  'X' FROM    PT_IL_POLICY,PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = POL_SYS_ID "
				+ "AND     NVL(POL_STATUS,'N') = 'P' AND     POAD_TYPE = 'R' AND  POAD_REF_ID2 IN(SELECT POAD_REF_ID2 FROM  PT_IL_POL_ASSURED_DTLS "
				+ "WHERE  POAD_TYPE = 'R' AND POAD_POL_SYS_ID =  ? )";
		String CURSOR_C15 = "SELECT COUNT(CLAIM_SYS_ID) FROM  PT_IL_CLAIM  WHERE CLAIM_POL_SYS_ID = ? ";
		String CURSOR_C16 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND NVL(PC_FAC_CLOSE_FLAG,'N') = 'Y' ";
		String CURSOR_C17 = "SELECT 'X' FROM   PT_IL_CLAIM WHERE  CLAIM_POL_SYS_ID = ? AND  CLAIM_TYPE IN ('A','D') ";
		String CURSOR_C18 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_COPY_ED' ";
		String CURSOR_C19 = "SELECT NVL(USER_CREDIT_CARD_UPD_YN,'N') FROM MENU_USER WHERE USER_ID =  ? ";
		String CURSOR_C20 = "SELECT MAX(POL_END_NO_IDX) FROM PT_IL_POLICY WHERE POL_NO = ? AND POL_DS_TYPE = 1 ";
		String CURSOR_C21 = "SELECT COVER_PREM_TYPE FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		ResultSet resultSet3 = null;
		String M_PROD_CBC_YN = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		// ArrayList<String> list = new ArrayList<String>();
		// ArrayList<String> list1 = new ArrayList<String>();
		// ArrayList<String> list2 = new ArrayList<String>();
		// ArrayList<String> list3 = new ArrayList<String>();
		
		/*Added by saritha on 14-FEB-2017 for Handson Feedback Point,
		 * In additional status to be changed based on the situation Additional Status date to be changed.
		 *
		 */ 
		PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = new PT_IL_POL_STATUS();
		Connection conn = null;
		ResultSet resultset = null;
		Date statusdate =new Date();
		CRUDHandler handler1 = new CRUDHandler();
		conn= CommonUtils.getConnection();
		/*End*/	
		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		COPY_ACTION copyAction = compositeAction.getCOPY_ACTION_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		
		
		PT_IL_POLICY_ACTION policyAction = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION brokerHeadAction = compositeAction
				.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();

		PT_IL_POL_ASSR_MED_HIST_1_ACTION medicalHistry1 = compositeAction
				.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION assured1Action = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
 		PT_IL_POL_ASSURED_DTLS_ACTION assuredAction = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		
		
		try {
  			connection = CommonUtils.getConnection();
 			resultSet = handler.executeSelectStatement(CURSOR_C18, connection);
			if (resultSet.next()) {
				M_PS_VALUE_1 = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);

			if (M_PS_VALUE_1 == 1) {
				policyAction.getCOMP_UI_M_BUT_COPY().setRendered(true);
			} else {
				policyAction.getCOMP_UI_M_BUT_COPY().setRendered(false);
			}

			resultSet = handler.executeSelectStatement(CURSOR_C10, connection);
			if (resultSet.next()) {
				dummyBean.setUI_M_PS_CODE(resultSet.getString(1));
			}
			CommonUtils.closeCursor(resultSet);

			resultSet = handler.executeSelectStatement(CURSOR_C5, connection,
					new Object[] { policyBean.getPOL_PROD_CODE() });
 			if (resultSet.next()) {
				dummyBean.setUI_M_POL_PERIOD(resultSet.getInt(1));
 				dummyBean.setUI_M_PROD_AGE_CALC_FLAG(resultSet.getString(2));
 				M_PROD_AUTO_UW = resultSet.getString(3);
			}
 			CommonUtils.closeCursor(resultSet);

 			if ("Y".equals(policyBean.getPOL_JOINT_LIFE_YN())) {
				// compositeAction.getTabbedBar().setTabEnabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_POL_ASSURED_DTLS_1);
				// .getTabbedBar().setTabEnabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_POL_MED_EXAM_DTL_1);

				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");
			} else {
				// compositeAction.getTabbedBar().setTabDisabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_POL_ASSURED_DTLS_1);
				// compositeAction.getTabbedBar().setTabDisabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_POL_MED_EXAM_DTL_1);

				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");
			}

			if ("2".equals(policyBean.getPOL_DS_TYPE())
					&& "Q".equals(CommonUtils.nvl(policyBean
							.getPOL_PROP_QUOT_FLAG(), "N"))) {
				dummyAction.getCOMP_UI_M_ENDT_QUOT().setRendered(true);
				dummyAction.getCOMP_UI_M_ENDT_QUOT().setDisabled(false);
			} else {
				dummyAction.getCOMP_UI_M_ENDT_QUOT().setRendered(false);
				dummyAction.getCOMP_UI_M_ENDT_QUOT().setDisabled(true);
			}

			ArrayList<String> list = procedures.callP_VAL_SYSTEM("IL_BRK_COM",
					"IL_BRK_COM", M_CODE_DESC, "E", commonUtils
							.getProcedureValue(M_VALUE));

			if (list != null && !list.isEmpty()) {
				M_CODE_DESC = list.get(0);
				if (list.get(1) != null)
					M_VALUE = Double.parseDouble(list.get(1));
			}
			if (M_VALUE == 1) {
				brokerHeadAction.getCOMP_POBH_COVER_CODE().setRequired(true);
			} else {
				brokerHeadAction.getCOMP_POBH_COVER_CODE().setRequired(false);
			}

			ArrayList<String> list1 = procedures.callP_VAL_SYSTEM(
					"IL_ADDL_STAT", policyBean.getPOL_ADDL_STATUS(),
					M_CODE_DESCRIPTION, "N", commonUtils
							.getProcedureValue(M_TEMP_VAL));

			if (list1 != null && list1.size() > 0 && !list1.isEmpty()) {
				M_CODE_DESCRIPTION = list1.get(0);
				if (list1.get(1) != null)
					M_TEMP_VAL = Double.parseDouble(list1.get(1));
			}

			ArrayList<String> list2 = procedures.callP_VAL_SYSTEM(
					"IL_ADDL_STAT", policyBean.getPOL_CLM_ADDL_STATUS(),
					M_CODE_DESCRIPTION_1, "N", commonUtils
							.getProcedureValue(M_TEMP_VAL));

			if (list2 != null && list2.size() > 0 && !list2.isEmpty()) {
				M_CODE_DESCRIPTION_1 = list2.get(0);
				if (list2.get(1) != null)
					M_TEMP_VAL = Double.parseDouble(list2.get(1));
			}

			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			// 2 == dummyBean.getUI_M_CALC_METHOD()

			if (1 == dummyBean.getUI_M_CALC_METHOD()
					|| 2 == dummyBean.getUI_M_CALC_METHOD()) {
				if (M_CODE_DESCRIPTION != null)
					dummyAction.getDUMMY_BEAN().setUI_M_ADDL_STATUS_DESC(
							policyBean.getPOL_ADDL_STATUS().concat(":").concat(
									M_CODE_DESCRIPTION));
				if (M_CODE_DESCRIPTION_1 != null)
					dummyAction.getDUMMY_BEAN().setUI_M_CLM_ADDL_STATUS(
							policyBean.getPOL_CLM_ADDL_STATUS().concat(":")
									.concat(M_CODE_DESCRIPTION_1));

				pilt002Procedures.IL_AMEND_IDX(policyBean.getPOL_SYS_ID(),
						policyBean.getPOL_NO(), policyBean.getPOL_DS_TYPE(),
						null);

				if ("1".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_11"))
						&& "Q".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_13"))
						&& "N".equals(CommonUtils.nvl(policyBean
								.getPOL_CONVERT_YN(), "N"))
						&& policyBean.getPOL_NO() != null) {

					dummyBean.setUI_M_ADDL_STATUS_DESC(policyBean
							.getPOL_ADDL_STATUS()
							+ " : " + M_CODE_DESCRIPTION);
					dummyAction.getCOMP_UI_M_BUT_CONVERT().setDisabled(false);
					dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(false);

				} else if ("1".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_11"))
						&& "Q".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_13"))
						&& "Y".equals(CommonUtils.nvl(policyBean
								.getPOL_CONVERT_YN(), "N"))) {

					dummyBean.setUI_M_ADDL_STATUS_DESC(policyBean
							.getPOL_ADDL_STATUS()
							+ " : " + M_CODE_DESCRIPTION);
					System.out.println("ADABOINA DISABLE 22222222");
					dummyAction.getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
					dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(true);

				}
			}

			/*Added by saritha on 14-FEB-2017 for Handson Feedback Point,
			 * In additional status to be changed based on the situation Additional Status date to be changed.
			 *
			 */ 
			System.out.println("Policy Sysid"+policyBean.getPOL_SYS_ID());
			System.out.println("Addtional Status"+policyBean.getPOL_ADDL_STATUS());
			String C3="SELECT PS_STATUS_DT FROM PT_IL_POL_STATUS WHERE PT_IL_POL_STATUS.PS_POL_SYS_ID =? AND PS_STATUS_TYPE = 'S' AND PS_STATUS= ?";
			resultset = handler1.executeSelectStatement(C3, conn,
						new Object[] {policyBean.getPOL_SYS_ID(),policyBean.getPOL_ADDL_STATUS()});
			while (resultset.next()) {
				statusdate = resultset.getDate("PS_STATUS_DT");	
				System.out.println("Status Date:::::::::"+statusdate);
			}
			policyBean.setUI_M_ADDL_STATUS_DT(CommonUtils.dateToStringFormat(statusdate));
		
			/*End*/
			
			resultSet = handler.executeSelectStatement(CURSOR_C20, connection,
					new Object[] { policyBean.getPOL_NO() });
			if (resultSet.next()) {
				M_MAX_POL_END_NO_IDX = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);

			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			// 2 == dummyBean.getUI_M_CALC_METHOD()

			if ((1 == dummyBean.getUI_M_CALC_METHOD() || 2 == dummyBean
					.getUI_M_CALC_METHOD())
					&& "A".equals(CommonUtils.nvl(policyBean
							.getPOL_APPRV_STATUS(), "N"))
					&& "1".equals(policyBean.getPOL_DS_TYPE())
					&& CommonUtils.nvl(policyBean.getPOL_CONVERT_YN(), "X") != "Y"
					&& CommonUtils.nvl(policyBean.getPOL_STATUS(), "X") != "C"
					&& policyBean.getPOL_END_NO_IDX() == M_MAX_POL_END_NO_IDX) {

				dummyAction.getCOMP_UI_M_BUT_POL_AMDT().setDisabled(false);
			} else {
				dummyAction.getCOMP_UI_M_BUT_POL_AMDT().setDisabled(true);
			}

			if ("1".equals(policyBean.getPOL_DS_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C12,
						connection, new Object[] {
								commonUtils.getControlBean().getM_USER_ID(),
								policyBean.getPOL_PROD_CODE() });

				if (resultSet.next()) {
					M_USER_PERM = resultSet.getString(1);
				}

			} else if ("2".equals(policyBean.getPOL_DS_TYPE())) {
				if ((policyBean.getPOL_END_NO_IDX() != null && policyBean
						.getPOL_END_NO_IDX() > 0)
						&& "002".equals(policyBean.getPOL_END_TYPE())
						&& CommonUtils.nvl(policyBean.getPOL_APPRV_STATUS(),
								"N") != "A") {

					/*ArrayList<String> list3 = pilt002Procedures
							.P_VAL_ENDT_APPROVAL(commonUtils.getControlBean()
									.getM_USER_ID(), "CHG_POL_STAT", policyBean
									.getPOL_PROD_CODE(), "2", M_USER_PERM);
					if (list3.size() > 0) {
						M_USER_PERM = list3.get(0);
					}*/
				} else {
					resultSet1 = handler
							.executeSelectStatement(CURSOR_C13, connection,
									new Object[] {
											commonUtils.getControlBean()
													.getM_USER_ID(),
											policyBean.getPOL_PROD_CODE() });
					if (resultSet1.next()) {
						M_USER_PERM = resultSet1.getString(1);
					}
				}
			}

			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet);

			resultSet = handler.executeSelectStatement(CURSOR_C14, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_LAPSED = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);

			M_TEMP = dummyAction.getCOMP_UI_M_BUT_UDDATE_STAT().isRendered();

			if (M_TEMP == true
					&& "N".equals(CommonUtils.nvl(M_USER_PERM, "N"))
					&& "N".equals(M_PROD_AUTO_UW)
					|| "N".equals(CommonUtils.nvl(policyBean.getPOL_FRZ_FLAG(),
							"N"))
					|| CommonUtils.nvl(policyBean.getPOL_APPRV_STATUS(), "N") != "N"
					|| "X".equals(CommonUtils.nvl(M_LAPSED, "N"))
					|| "N".equals(M_PROD_AUTO_UW)
					|| "C".equals(policyBean.getPOL_STATUS())) {

				dummyAction.getCOMP_UI_M_BUT_UDDATE_STAT().setDisabled(true);

			} else if (M_TEMP == true
					&& "Y".equals(CommonUtils.nvl(M_USER_PERM, "N"))
					&& "Y".equals(CommonUtils.nvl(policyBean.getPOL_FRZ_FLAG(),
							"N")) && "1".equals(policyBean.getPOL_DS_TYPE())
					&& !"X".equals(CommonUtils.nvl(M_LAPSED, "N"))
					&& "Y".equals(M_PROD_AUTO_UW)) {
				dummyAction.getCOMP_UI_M_BUT_UDDATE_STAT().setDisabled(false);

			} else {
				dummyAction.getCOMP_UI_M_BUT_UDDATE_STAT().setDisabled(true);
			}

			if (policyBean.getPOL_PROJECT_CODE() != null) {
				policyAction.getCOMP_POL_DEVELOPER_CODE().setDisabled(false);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_DEVELOPER_CODE().setDisabled(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_DEVELOPER_CODE().setDisabled(false);
				}
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_DEVELOPER_CODE().setDisabled(true);
			}

			if ("Y".equals(CommonUtils.nvl(policyBean.getPOL_INCORPORATED_YN(),
					"N"))) {

				policyAction.getCOMP_POL_FC_BANK_ALLOC_AMT().setDisabled(false);
				policyAction.getCOMP_POL_FC_BANK_ALLOC_AMT().setRequired(true);
				policyAction.getCOMP_POL_LC_BANK_ALLOC_AMT().setDisabled(false);
				policyAction.getCOMP_POL_LC_BANK_ALLOC_AMT().setRequired(true);
				policyAction.getCOMP_POL_FC_CLIENT_ALLOC_AMT().setDisabled(
						false);
				policyAction.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
						.setRequired(true);
				policyAction.getCOMP_POL_LC_CLIENT_ALLOC_AMT().setDisabled(
						false);
				policyAction.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
						.setRequired(true);
				policyAction.getCOMP_POL_FC_TOT_SA().setDisabled(false);
				policyAction.getCOMP_POL_FC_TOT_SA().setRequired(true);
				policyAction.getCOMP_POL_LC_TOT_SA().setDisabled(false);
				policyAction.getCOMP_POL_LC_TOT_SA().setRequired(true);

			} else if ("N".equals(CommonUtils.nvl(policyBean
					.getPOL_INCORPORATED_YN(), "N"))) {

				policyAction.getCOMP_POL_FC_BANK_ALLOC_AMT().setDisabled(false);
				policyAction.getCOMP_POL_LC_BANK_ALLOC_AMT().setDisabled(false);
				policyAction.getCOMP_POL_FC_CLIENT_ALLOC_AMT().setDisabled(
						false);
				policyAction.getCOMP_POL_LC_CLIENT_ALLOC_AMT().setDisabled(
						false);
				policyAction.getCOMP_POL_FC_TOT_SA().setDisabled(false);
				policyAction.getCOMP_POL_LC_TOT_SA().setDisabled(false);
			}

			if ("A".equals(CommonUtils.nvl(policyBean.getPOL_APPRV_STATUS(),
					"N"))) {

				if (CommonUtils.getGlobalVariable("CALLING_FORM") != "PILT041_APAC") {
					policyAction.getCOMP_POL_FAC_BASIS().setDisabled(false);
					policyAction.getCOMP_POL_RI_POOL_CODE().setDisabled(false);
				}

				if ("Y"
						.equals(CommonUtils
								.nvl(policyBean.getPOL_FAC_YN(), "N"))) {
					if (CommonUtils.getGlobalVariable("CALLING_FORM") != "PILT041_APAC") {
						policyAction.getCOMP_POL_FAC_BASIS().setDisabled(false);
						policyAction.getCOMP_POL_RI_POOL_CODE().setDisabled(
								false);
					}
				} else {
					policyAction.getCOMP_POL_FAC_BASIS().setDisabled(true);
					policyAction.getCOMP_POL_RI_POOL_CODE().setDisabled(true);
				}
				if ("Y"
						.equals(CommonUtils
								.nvl(policyBean.getPOL_CQS_YN(), "N"))) {
					policyAction.getCOMP_POL_CQS_PERC().setDisabled(false);
				} else {
					policyAction.getCOMP_POL_CQS_PERC().setDisabled(true);
				}

			} else {

				if ("Y"
						.equals(CommonUtils
								.nvl(policyBean.getPOL_FAC_YN(), "N"))) {
					if (CommonUtils.getGlobalVariable("CALLING_FORM") != "PILT041_APAC") {
						policyAction.getCOMP_POL_FAC_BASIS().setDisabled(false);
						policyAction.getCOMP_POL_RI_POOL_CODE().setDisabled(
								false);
					}
				} else {
					policyAction.getCOMP_POL_FAC_BASIS().setDisabled(true);
					policyAction.getCOMP_POL_RI_POOL_CODE().setDisabled(true);
				}

				if ("Y"
						.equals(CommonUtils
								.nvl(policyBean.getPOL_CQS_YN(), "N"))) {
					policyAction.getCOMP_POL_CQS_PERC().setDisabled(false);
				} else {
					policyAction.getCOMP_POL_CQS_PERC().setDisabled(true);
				}
			}

			/*Modified by ganesh on 12-04-2018 for hide and show 
			 * the quotation number in policy screen*/
			/*if ("1".equals(policyBean.getPOL_DS_TYPE())
					&& "Q".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13"))) {
				policyAction.getCOMP_POL_PROP_NO().setRendered(false);
				policyAction.getCOMP_POL_PROP_NO_LABEL().setRendered(false);
			} else if ("1".equals(policyBean.getPOL_DS_TYPE())
					&& "P".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13"))) {

				policyAction.getCOMP_POL_PROP_NO().setRendered(true);
				policyAction.getCOMP_POL_PROP_NO_LABEL().setRendered(true);

			}*/
			if ("1".equals(policyBean.getPOL_DS_TYPE())
					&& ("Q".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13")) || "P".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_13")))) {
				policyAction.getCOMP_POL_PROP_NO().setRendered(false);
				policyAction.getCOMP_POL_PROP_NO_LABEL().setRendered(false);
			} else if ("1".equals(policyBean.getPOL_DS_TYPE())
					&& "P".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13"))) {

				policyAction.getCOMP_POL_PROP_NO().setRendered(true);
				policyAction.getCOMP_POL_PROP_NO_LABEL().setRendered(true);

			}
			

			if ("1".equals(policyBean.getPOL_DS_TYPE())
					&& (policyBean.getPOL_END_NO_IDX() != null && policyBean
							.getPOL_END_NO_IDX() > 0)) {
				policyAction.getCOMP_POL_NO().setDisabled(true);
			}

			if ("2".equals(policyBean.getPOL_DS_TYPE())) {
				dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);

			} else if ("1".equals(policyBean.getPOL_DS_TYPE())) {
				dummyAction.getCOMP_UI_M_BUT_ENDT().setRendered(false);
			}

			if (policyBean.getROWID() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection);

				if (resultSet.next()) {
					M_PS_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);

				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { M_PS_CODE,
								policyBean.getPOL_SYS_ID() });

				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);

				if ("X".equals(M_DUMMY)) {
					dummyAction.getCOMP_UI_M_CIC_STATUS().setValue(
							"Critical Illness Cover Claimed");
				} else {
					dummyAction.getCOMP_UI_M_CIC_STATUS().setValue("");
				}

				if ("Y".equals(CommonUtils.nvl(policyBean
						.getPOL_PREM_WAIVE_YN(), "N"))) {
					dummyAction.getCOMP_UI_M_WAI_STATUS().setValue(
							"Premium Waived");
				} else {
					dummyAction.getCOMP_UI_M_WAI_STATUS().setValue("");
				}

				if (policyBean.getPOL_BASIC_RATE() != null) {
					policyAction.getCOMP_POL_BASIC_RATE().setRequired(false);
				}

				resultSet = handler.executeSelectStatement(CURSOR_C3,
						connection, new Object[] { policyBean.getPOL_SYS_ID(),
								policyBean.getPOL_END_NO_IDX(),
								policyBean.getPOL_DS_TYPE(),
								policyBean.getPOL_DS_TYPE(),
								policyBean.getPOL_END_NO_IDX(),
								policyBean.getPOL_DS_TYPE(),
								policyBean.getPOL_END_CODE(),
								policyBean.getPOL_DS_CODE() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				} else {
					M_DUMMY = "Y";
				}
				CommonUtils.closeCursor(resultSet);
				 
				 if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))
						|| ("A".equals(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N")) || "C"
								.equals(CommonUtils.nvl(policyBean
										.getPOL_APPRV_STATUS(), "N")))
						|| "Y".equals(CommonUtils.nvl(policyBean
								.getPOL_HOLD_YN(), "N"))
						|| "N".equals(CommonUtils.nvl(policyBean
								.getPOL_FRZ_FLAG(), "N"))) {

					 
					 
					if (dummyAction.getCOMP_UI_M_BUT_APPROVAL().isRendered() == true) {
						
						/*Modified and Added by Janani on 15.03.2018 for KIC Disaptch dtls screen*/
					
						String uw_status = policyAction.getAutoUnderwriting();

						if(uw_status.equalsIgnoreCase("y"))
						{
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().approveLinkDisable();

						}
						else
						{
							dummyAction.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
						}
						/*End*/
					}
				} else {
					if (dummyAction.getCOMP_UI_M_BUT_APPROVAL().isRendered() == true) {
						
						/*Modified and Added by Janani on 15.03.2018 for KIC Disaptch dtls screen*/
						
						String uw_status = policyAction.getAutoUnderwriting();
						if(uw_status.equalsIgnoreCase("y"))
						{

						compositeAction.getPT_IL_POLICY_ACTION_BEAN().approveLinkDisable();
						
						/*End*/
						
					}else
					{
						dummyAction.getCOMP_UI_M_BUT_APPROVAL().setDisabled(
						false);
					}
				}
				}

				if ("1".equals(policyBean.getPOL_DS_TYPE())) {
					if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))
							|| "C".equals(CommonUtils.nvl(policyBean
									.getPOL_APPRV_STATUS(), "N"))
							|| "Y".equals(CommonUtils.nvl(policyBean
									.getPOL_HOLD_YN(), "N"))
							|| "N".equals(CommonUtils.nvl(policyBean
									.getPOL_FRZ_FLAG(), "N"))) {
						if (dummyAction.getCOMP_UI_M_BUT_APPROVAL()
								.isRendered() == true) {
							dummyAction.getCOMP_UI_M_BUT_APPROVAL()
									.setDisabled(true);
						}
					} else {
						if (dummyAction.getCOMP_UI_M_BUT_APPROVAL()
								.isRendered() == true) {
							dummyAction.getCOMP_UI_M_BUT_APPROVAL()
									.setDisabled(false);
						}
					}
				}

				if (!"PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) {
					if (!"001".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))) {
						if (!"Q".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_13"))
								&& !"1"
										.equals(CommonUtils
												.getGlobalVariable("GLOBAL.M_PARAM_11"))) {
							if ("Y".equals(CommonUtils.getGlobalVariable(
									"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
								policyAction.getCOMP_POL_FRZ_FLAG()
										.setDisabled(false);
							}
						}
					}
				}

				if ("N".equals(CommonUtils.nvl(
						policyBean.getPOL_APPRV_STATUS(), "N"))) {
					if (!"PILT041_APAC".equals(CommonUtils
							.getGlobalVariable("CALLING_FORM"))) {
						if ("S".equals(policyBean.getPOL_STATUS())) {
							dummyAction.getCOMP_UI_M_APPRV_STATUS()
									.setRendered(true);
						} else {
							dummyAction.getCOMP_UI_M_APPRV_STATUS()
									.setRendered(false);
						}
						if ("000".equals(CommonUtils.nvl(policyBean
								.getPOL_END_TYPE(), "000"))
								&& !"Q"
										.equals(CommonUtils
												.getGlobalVariable("GLOBAL.M_PARAM_13"))) {
							local_procedures
									.IL_BLOCK_POL_ENABLED(compositeAction);
						}
					}
				} else {
					dummyAction.getCOMP_UI_M_APPRV_STATUS().setRendered(true);
					local_procedures.IL_BLOCK_POL_DISABLED(compositeAction);
				}

				if ("1".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_11"))
						&& "Q".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_13"))
						&& ("Y".equals(CommonUtils.nvl(policyBean
								.getPOL_CONVERT_YN(), "N")))
						|| "C".equals(policyBean.getPOL_STATUS())) {

					local_procedures.IL_BLOCK_POL_DISABLED(compositeAction);

				} else if ("1".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_11"))
						&& "Q".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_13"))
						&& ("N".equals(CommonUtils.nvl(policyBean
								.getPOL_CONVERT_YN(), "N")))) {

					local_procedures.IL_BLOCK_POL_ENABLED(compositeAction);
				}

				if ("2".equals(policyBean.getPOL_DS_TYPE())
						&& "A".equals(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N"))) {
					dummyAction.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
					dummyAction.getCOMP_UI_M_BUT_PRMDTLS().setDisabled(true);
				} else {
					if (dummyAction.getCOMP_UI_M_BUT_PRMDTLS().isRendered() == true) {
						dummyAction.getCOMP_UI_M_BUT_PRMDTLS().setDisabled(
								false);
					}
				}
				/*
				 * Commented By Haneef:- to fix the issue, prem calc buttion is
				 * disabled afetr paasing the endowrsement
				 */

				/*
				 * if (1 == dummyBean.getUI_M_CALC_METHOD()) {
				 * dummyAction.getCOMP_UI_M_BUT_PRMDTLS().setDisabled(true); }
				 * else {
				 * dummyAction.getCOMP_UI_M_BUT_PRMDTLS().setDisabled(false); }
				 */

				if ("1".equals(policyBean.getPOL_DS_TYPE())) {
					dummyAction.getCOMP_UI_M_BUT_HOLD().setRendered(true);
					if ("A".equals(policyBean.getPOL_APPRV_STATUS())) {
						dummyAction.getCOMP_UI_M_BUT_APPROVAL().setDisabled(
								true);
					}

					dummyAction.getCOMP_UI_M_BUT_CONVERT().setRendered(true);
					if ("A".equals(policyBean.getPOL_APPRV_STATUS())
							&& "Y".equals(CommonUtils.nvl(policyBean
									.getPOL_CONVERT_YN(), "X"))
							|| "N".equals(policyBean.getPOL_FRZ_FLAG())) {
						dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
					} else {
						if (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13") != "Q"
								&& CommonUtils
										.getGlobalVariable("GLOBAL.M_PARAM_11") != "1"
								&& "Y".equals(policyBean.getPOL_FRZ_FLAG())) {
							if (!"PILT041_APAC".equals(CommonUtils
									.getGlobalVariable("CALLING_FORM"))) {

								dummyAction.getCOMP_UI_M_BUT_HOLD()
										.setDisabled(false);
							}
						}
					}

					// ADDED BY AKASH TO MAKE NORMAL AND TAKAFUL WORK.
					// WE HAVE TO EXECUTE THE ELSE PART I.E WE PAASS 3 IN CALC
					// METHOD INSTAED OF 2
					if (3 == dummyBean.getUI_M_CALC_METHOD()) {
						if ("A".equals(policyBean.getPOL_APPRV_STATUS())
								&& CommonUtils.nvl(policyBean
										.getPOL_CONVERT_YN(), "X") != "Y") {
							dummyAction.getCOMP_UI_M_BUT_CONVERT().setDisabled(
									false);
						} else {
							if (!CommonUtils.getGlobalObject(
									"GLOBAL.M_PARAM_13").equals("Q")
									&& !CommonUtils.getGlobalObject(
											"GLOBAL.M_PARAM_11").equals("1")) {
								System.out
										.println("ADABOINA DISABLE 333333333");
								dummyAction.getCOMP_UI_M_BUT_CONVERT()
										.setDisabled(true);
							}
						}
					} else {

						if ("A".equals(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N"))
								&& !"Y".equals(CommonUtils.nvl(policyBean
										.getPOL_CONVERT_YN(), "X"))
								&& ("CO1".equals(policyBean
										.getPOL_ADDL_STATUS())
										|| "CO2".equals(policyBean
												.getPOL_ADDL_STATUS())
										|| "CO8".equals(policyBean
												.getPOL_ADDL_STATUS()) || "CO4"
										.equals(policyBean.getPOL_ADDL_STATUS()))) {

							resultSet = handler.executeSelectStatement(
									CURSOR_C2A, connection, new Object[] {
											policyBean.getPOL_NO(),
											policyBean.getPOL_DS_TYPE() });
							if (resultSet.next()) {
								M_COUNT = resultSet.getDouble(1);
							}
							CommonUtils.closeCursor(resultSet);

							if (M_COUNT > 1) {
								resultSet = handler.executeSelectStatement(
										CURSOR_C3A, connection, new Object[] {
												policyBean.getPOL_NO(),
												policyBean.getPOL_DS_TYPE() });
								if (resultSet.next()) {
									M_MAX_END_NO_IDX = resultSet.getDouble(1);
								}
								CommonUtils.closeCursor(resultSet);
								if (M_MAX_END_NO_IDX.equals(policyBean
										.getPOL_END_NO_IDX())) {
									dummyAction.getCOMP_UI_M_BUT_CONVERT()
											.setDisabled(false);
								} else {
									// System.out.println("ADABOINA DISABLE
									// 44444");
									dummyAction.getCOMP_UI_M_BUT_CONVERT()
											.setDisabled(true);
								}
							} else {
								// System.out.println("ADABOINA DISABLE
								// 5555555");
								dummyAction.getCOMP_UI_M_BUT_CONVERT()
										.setDisabled(false);
							}

						} else {
							if (!CommonUtils.getGlobalVariable(
									"GLOBAL.M_PARAM_13").equals("Q")
									&& "1"
											.equals(CommonUtils
													.getGlobalVariable("GLOBAL.M_PARAM_11"))) {
								System.out.println("ADABOINA DISABLE 66666666");
								dummyAction.getCOMP_UI_M_BUT_CONVERT()
										.setDisabled(true);
							}

							if (("1".equals(CommonUtils
									.getGlobalVariable("GLOBAL.M_PARAM_11"))
									&& policyBean.getPOL_END_NO_IDX() > 0 && !"A"
									.equals(policyBean.getPOL_APPRV_STATUS()))
									|| ("B05".equalsIgnoreCase(policyBean
											.getPOL_ADDL_STATUS()) || "B06"
											.equalsIgnoreCase(policyBean
													.getPOL_ADDL_STATUS()))) {
								System.out.println("ADABOINA DISABLE 777777");
								dummyAction.getCOMP_UI_M_BUT_CONVERT()
										.setDisabled(true);
							}
						}
					}

				} else if ("2".equals(policyBean.getPOL_DS_TYPE())) {
					dummyAction.getCOMP_UI_M_BUT_HOLD().setRendered(true);
					if ("A".equals(policyBean.getPOL_APPRV_STATUS())
							&& "N".equals(policyBean.getPOL_FRZ_FLAG())) {
						dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
					} else {
						if (!"PILT041_APAC".equals(CommonUtils
								.getGlobalVariable("CALLING_FORM"))) {
							dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(
									false);
						}
					}
				}

				resultSet = handler.executeSelectStatement(CURSOR_C5,
						connection, new Object[] { policyBean
								.getPOL_PROD_CODE() });

				if (resultSet.next()) {
					dummyBean.setUI_M_POL_PERIOD(resultSet.getInt(1));
					dummyBean
							.setUI_M_PROD_AGE_CALC_FLAG(resultSet.getString(2));
					M_PROD_AUTO_UW = resultSet.getString(3);
				}
				CommonUtils.closeCursor(resultSet);
				if ((policyBean.getPOL_END_NO_IDX() != null
						&& policyBean.getPOL_END_NO_IDX() > 0 && "2"
						.equals(policyBean.getPOL_DS_TYPE()))
						|| "A".equals(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N"))) {
					brokerHeadAction.getCOMP_UI_M_BUT_SHOW_AGENT().setDisabled(
							true);
				} else {
					if (brokerHeadAction.getCOMP_UI_M_BUT_SHOW_AGENT()
							.isRendered() == true) {
						brokerHeadAction.getCOMP_UI_M_BUT_SHOW_AGENT()
								.setDisabled(false);
					}
				}

			} else {
				policyAction.getCOMP_POL_BASIC_RATE().setRequired(false);
				dummyAction.getCOMP_UI_M_APPRV_STATUS().setRendered(false);
				dummyAction.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
				dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(true);
				dummyAction.getCOMP_UI_M_BUT_UPI().setDisabled(true);

				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					policyAction.setINSERT_ALLOWED(true);
				}
				local_procedures.IL_BLOCK_POL_ENABLED(compositeAction);
			}

			if (policyBean.getROWID() != null) {
				if (CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) == 0
						&& "A".equals(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N"))) {
					if ("2".equals(policyBean.getPOL_DS_TYPE())) {
						if ("PILT041_APAC".equals(CommonUtils
								.getGlobalVariable("CALLING_FORM"))) {
							dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(
									false);
						} else {
							dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(
									true);
						}

					}
				} else if (policyBean.getPOL_END_NO_IDX() != null
						&& CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) > 0
						&& "2".equals(policyBean.getPOL_DS_TYPE())) {
					if (!"C".equalsIgnoreCase(policyBean.getPOL_STATUS())) {
						if ("PILT041_APAC".equals(CommonUtils
								.getGlobalVariable("CALLING_FORM"))) {
							dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(
									false);
						} else {
							dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(
									true);
						}
					} else {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					}
				} else {
					if ("2".equals(policyBean.getPOL_DS_TYPE())) {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					}
				}
			}

			if (policyBean.getROWID() != null) {
				if (CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) != 0
						&& "S".equals(CommonUtils.nvl(policyBean
								.getPOL_STATUS(), "X"))) {
					if ("2".equals(policyBean.getPOL_DS_TYPE())) {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					}
				}
			}

			if (policyBean.getROWID() != null) {
				if ("001".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))) {
					local_procedures.IL_ENDT_001_CHANGES(compositeAction);
					if ("M".equals(dummyBean.getUI_M_POL_PLAN_TYPE())) {
						policyAction.getCOMP_POL_BANK_BRANCH_NAME()
								.setDisabled(false);
					}
				}
				if ("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))
						|| "013".equals(CommonUtils.nvl(policyBean
								.getPOL_END_TYPE(), "000"))) {
					local_procedures.IL_ENDT_002_PROPS(compositeAction);
					local_procedures.IL_ENDT_002_CHANGES(compositeAction);
				}
				if ("015".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))) {
					local_procedures.IL_ENDT_015_CHANGES(compositeAction);
				}
				if ("011".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))) {
					local_procedures.IL_ENDT_011_CHANGES(compositeAction);
				}
				if ("003".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))
						&& "S".equals(policyBean.getPOL_STATUS())) {
					dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(false);

					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_SA_INST_PYMT");

					// compositeAction.getTabbedBar().setTabEnabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_SURR_MAT_VALUES);
					if ("2".equals(policyBean.getPOL_DS_TYPE())) {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					}

					local_procedures
							.IL_ENDT_003_004_BLK_DISABLE(compositeAction);
				} else if ("003".equals(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000"))
						&& "P".equals(policyBean.getPOL_STATUS())) {

					dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(false);
					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_SA_INST_PYMT");

					// compositeAction.getTabbedBar().setTabEnabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_SURR_MAT_VALUES);
					if ("2".equals(policyBean.getPOL_DS_TYPE())) {
						if ("PILT041_APAC".equals(CommonUtils
								.getGlobalVariable("CALLING_FORM"))) {
							dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(
									false);
						} else {
							dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(
									true);
						}
					}
					local_procedures
							.IL_ENDT_003_004_BLK_DISABLE(compositeAction);

				} else {
					dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(true);
					compositeAction.getWizard().disableWizardItem(
							"PILT002_APAC_PT_IL_POL_SA_INST_PYMT");
					// compositeAction.getTabbedBar().setTabDisabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_SURR_MAT_VALUES);
				}

				if ("M".equals(policyBean.getPOL_STATUS())) {
					dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(false);
					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_SA_INST_PYMT");
					// compositeAction.getTabbedBar().setTabEnabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_SURR_MAT_VALUES);
					dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					local_procedures
							.IL_ENDT_003_004_BLK_DISABLE(compositeAction);
				}
				if ("005".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))) {
					local_procedures.IL_ENDT_005_BLK_DISABLE(compositeAction);
				}
				if ("016".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))) {
					local_procedures.IL_ENDT_016_BLK_DISABLE(compositeAction);
				}
				if ("006".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000"))) {
					dummyAction.getCOMP_UI_M_BUT_UPI().setDisabled(false);
					policyAction.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
					local_procedures.IL_ENDT_006_CHANGES(compositeAction);
				} else {
					dummyAction.getCOMP_UI_M_BUT_UPI().setDisabled(true);
				}
			} else {
				if ("2".equals(policyBean.getPOL_DS_TYPE())) {
					dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
				}
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_SA_INST_PYMT");

				// compositeAction.getTabbedBar().setTabDisabled(PILT002_APAC_COMPOSITE_ACTION.TAB_PT_IL_SURR_MAT_VALUES);
			}

			if ("007".equals(policyBean.getPOL_END_TYPE())) {
				local_procedures.L_IL_END_007_CHANGES(compositeAction);
			}

			if ("2".equals(policyBean.getPOL_DS_TYPE())) {
				if ("M"
						.equals(CommonUtils
								.nvl(policyBean.getPOL_STATUS(), "N"))) {

					dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(false);
					compositeAction.getWizard().enableWizardItem(
							"PILT002_APAC_PT_IL_POL_SA_INST_PYMT");

				} else if (policyBean.getPOL_END_NO_IDX() != null
						&& policyBean.getPOL_END_NO_IDX() > 0
						&& policyBean.getPOL_STATUS() != "C") {
					if ("PILT041_APAC".equals(CommonUtils
							.getGlobalVariable("CALLING_FORM"))) {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(false);
					} else {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					}
				} else if (policyBean.getPOL_END_NO_IDX() != null
						&& policyBean.getPOL_END_NO_IDX() > 0
						&& "A".equals(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N"))) {
					if ("PILT041_APAC".equals(CommonUtils
							.getGlobalVariable("CALLING_FORM"))) {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(false);
					} else {
						dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
					}
				} else {
					dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
				}
			}

			if (CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) > 0
					&& CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000") != "002") {
				assuredAction.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(true);
				assuredAction.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(true);
				assuredAction.getCOMP_POAD_CATG_CODE().setDisabled(true);

				assured1Action.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(true);
				assured1Action.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(true);
				assured1Action.getCOMP_POAD_CATG_CODE().setDisabled(true);
			}

			if (policyBean.getROWID() != null) {
				if ("1".equals(policyBean.getPOL_DS_TYPE())) {

					policyAction.getCOMP_POL_FC_EXC_INT_AMT().setDisabled(true);
					policyAction.getCOMP_POL_EXC_INT_PERC().setDisabled(true);
					policyAction.getCOMP_POL_LC_EXC_INT_AMT().setDisabled(true);
				}
				if ("2".equals(policyBean.getPOL_DS_TYPE())
						&& "010".equals(CommonUtils.nvl(policyBean
								.getPOL_END_TYPE(), "000"))) {
					policyAction.getCOMP_POL_EXC_INT_PERC().setDisabled(false);
					policyAction.getCOMP_POL_FC_EXC_INT_AMT()
							.setDisabled(false);
					policyAction.getCOMP_POL_LC_EXC_INT_AMT()
							.setDisabled(false);
				}

				dummyBean.setUI_M_POL_MODE_OF_PYMT(policyBean
						.getPOL_MODE_OF_PYMT());
				if (policyBean.getPOL_END_NO_IDX() != null
						&& policyBean.getPOL_END_NO_IDX() > 0) {
					resultSet = handler.executeSelectStatement(CURSOR_C8,
							connection, new Object[] {
									policyBean.getPOL_SYS_ID(),
									policyBean.getPOL_END_NO_IDX() });
					if (resultSet.next()) {
						dummyBean.setUI_M_POL_MODE_OF_PYMT1(resultSet
								.getString(1));
					}
					CommonUtils.closeCursor(resultSet);
				}
			}

			if (policyBean.getROWID() == null) {
				if ("1".equals(policyBean.getPOL_DS_TYPE())) {
					dummyAction.getCOMP_UI_M_BUT_ENDT().setRendered(false);
					if (!CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13")
							.equalsIgnoreCase("Q")
							&& !CommonUtils.getGlobalVariable(
									"GLOBAL.M_PARAM_11").equalsIgnoreCase("1")) {
						dummyAction.getCOMP_UI_M_BUT_HOLD().setRendered(true);
						dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
						System.out.println("ADABOINA DISABLE 888888");
						dummyAction.getCOMP_UI_M_BUT_CONVERT()
								.setDisabled(true);
						dummyAction.getCOMP_UI_M_BUT_CONVERT()
								.setRendered(true);
					}
					policyAction.getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL()
							.setValue("Prop LC Deposit Amt");
					policyAction.getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL()
							.setValue("Prop FC Deposit Amt");
				} else if ("2".equals(policyBean.getPOL_DS_TYPE())) {
					dummyAction.getCOMP_UI_M_BUT_CONVERT().setRendered(false);
					dummyAction.getCOMP_UI_M_BUT_ENDT().setRendered(true);
					policyAction.getCOMP_POL_LC_DEPOSIT_AMOUNT_LABEL()
							.setValue("LC First Premium");
					policyAction.getCOMP_POL_FC_DEPOSIT_AMOUNT_LABEL()
							.setValue("FC First Premium");
				}

				if ("N".equals(policyBean.getPOL_JOINT_LIFE_YN())) {
					policyAction.getCOMP_POL_JOINT_LIFE_AGE_LABEL().setValue(
							"Assured Age");
				} else {
					policyAction.getCOMP_POL_JOINT_LIFE_AGE_LABEL().setValue(
							"Joint Life Age");
				}
				resultSet = handler.executeSelectStatement(CURSOR_C6,
						connection, new Object[] { policyBean
								.getPOL_PLAN_CODE() });
				if (resultSet.next()) {
					dummyBean.setUI_M_POL_PLAN_TYPE(resultSet.getString(1));
				}
				CommonUtils.closeCursor(resultSet);

				if ("A".equals(dummyBean.getUI_M_POL_PLAN_TYPE())
						|| "S".equals(dummyBean.getUI_M_POL_PLAN_TYPE())) {

					assuredAction.getCOMP_POAD_FC_SUM_ASSURED().setRendered(
							true);
					assuredAction.getCOMP_POAD_LC_SUM_ASSURED().setRendered(
							true);
					assuredAction.getCOMP_POAD_FC_AMAN_PREM().setRendered(true);
					assuredAction.getCOMP_POAD_LC_AMAN_PREM().setRendered(true);
					assuredAction.getCOMP_POAD_FC_AMAN_LOAD_PREM().setRendered(
							true);
					assuredAction.getCOMP_POAD_LC_AMAN_LOAD_PREM().setRendered(
							true);
					assuredAction.getCOMP_POAD_FC_SENABEL_PREM().setRendered(
							true);
					assuredAction.getCOMP_POAD_LC_SENABEL_PREM().setRendered(
							true);
					assuredAction.getCOMP_POAD_FC_SUM_ASSURED_LABEL()
							.setRendered(true);
					assuredAction.getCOMP_POAD_LC_SUM_ASSURED_LABEL()
							.setRendered(true);

					assuredAction.getCOMP_POAD_FC_AMAN_PREM_LABEL()
							.setRendered(true);
					assuredAction.getCOMP_POAD_LC_AMAN_PREM_LABEL()
							.setRendered(true);
					assuredAction.getCOMP_POAD_FC_AMAN_LOAD_PREM_LABEL()
							.setRendered(true);
					assuredAction.getCOMP_POAD_LC_AMAN_LOAD_PREM_LABEL()
							.setRendered(true);
					assuredAction.getCOMP_POAD_FC_SENABEL_PREM_LABEL()
							.setRendered(true);
					assuredAction.getCOMP_POAD_LC_SENABEL_PREM_LABEL()
							.setRendered(true);

					assured1Action.getCOMP_POAD_FC_SUM_ASSURED().setRendered(
							true);
					assured1Action.getCOMP_POAD_LC_SUM_ASSURED().setRendered(
							true);
					assured1Action.getCOMP_POAD_FC_AMAN_PREM()
							.setRendered(true);
					assured1Action.getCOMP_POAD_LC_AMAN_PREM()
							.setRendered(true);
					assured1Action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
							.setRendered(true);
					assured1Action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
							.setRendered(true);
					assured1Action.getCOMP_POAD_FC_SENABEL_PREM().setRendered(
							true);
					assured1Action.getCOMP_POAD_LC_SENABEL_PREM().setRendered(
							true);
					assured1Action.getCOMP_POAD_FC_SUM_ASSURED_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_LC_SUM_ASSURED_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_FC_AMAN_PREM_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_LC_AMAN_PREM_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_FC_AMAN_LOAD_PREM_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_LC_AMAN_LOAD_PREM_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_FC_SENABEL_PREM_LABEL()
							.setRendered(true);
					assured1Action.getCOMP_POAD_LC_SENABEL_PREM_LABEL()
							.setRendered(true);

				} else {

					assuredAction.getCOMP_POAD_FC_SUM_ASSURED().setRendered(
							false);
					assuredAction.getCOMP_POAD_LC_SUM_ASSURED().setRendered(
							false);
					assuredAction.getCOMP_POAD_FC_AMAN_PREM()
							.setRendered(false);
					assuredAction.getCOMP_POAD_LC_AMAN_PREM()
							.setRendered(false);
					assuredAction.getCOMP_POAD_FC_AMAN_LOAD_PREM().setRendered(
							false);
					assuredAction.getCOMP_POAD_LC_AMAN_LOAD_PREM().setRendered(
							false);
					assuredAction.getCOMP_POAD_FC_SENABEL_PREM().setRendered(
							false);
					assuredAction.getCOMP_POAD_LC_SENABEL_PREM().setRendered(
							false);
					assuredAction.getCOMP_POAD_FC_SUM_ASSURED_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_LC_SUM_ASSURED_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_FC_AMAN_PREM_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_LC_AMAN_PREM_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_FC_AMAN_LOAD_PREM_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_LC_AMAN_LOAD_PREM_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_FC_SENABEL_PREM_LABEL()
							.setRendered(false);
					assuredAction.getCOMP_POAD_LC_SENABEL_PREM_LABEL()
							.setRendered(false);

					assured1Action.getCOMP_POAD_FC_SUM_ASSURED().setRendered(
							false);
					assured1Action.getCOMP_POAD_LC_SUM_ASSURED().setRendered(
							false);
					assured1Action.getCOMP_POAD_FC_AMAN_PREM().setRendered(
							false);
					assured1Action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
							.setRendered(false);
					assured1Action.getCOMP_POAD_LC_AMAN_PREM().setRendered(
							false);
					assured1Action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
							.setRendered(false);
					assured1Action.getCOMP_POAD_FC_SENABEL_PREM().setRendered(
							false);
					assured1Action.getCOMP_POAD_LC_SENABEL_PREM().setRendered(
							false);
					assured1Action.getCOMP_POAD_FC_SUM_ASSURED_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_LC_SUM_ASSURED_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_FC_AMAN_PREM_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_LC_AMAN_PREM_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_FC_AMAN_LOAD_PREM_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_LC_AMAN_LOAD_PREM_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_FC_SENABEL_PREM_LABEL()
							.setRendered(false);
					assured1Action.getCOMP_POAD_LC_SENABEL_PREM_LABEL()
							.setRendered(false);
				}
			}

			// ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			// 2 == dummyBean.getUI_M_CALC_METHOD()

			if (1 == dummyBean.getUI_M_CALC_METHOD()
					|| 2 == dummyBean.getUI_M_CALC_METHOD()) {

				if ("B".equals(policyBean.getPOL_GRANTEE_TYPE())) {
					policyAction.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
				} else {
					policyAction.getCOMP_POL_GRANTEE_NAME().setDisabled(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					policyAction.getCOMP_POL_GRANTEE_NAME().setDisabled(false);
				}

				if ("PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))
						&& "C".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_18"))) {

					policyAction.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
				}
			}
			/*----------------------------------------------------------------------------------------------------------------*/
			if (policyBean.getPOL_END_NO_IDX() != null
					&& policyBean.getPOL_END_NO_IDX() > 0) {

				if ("PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))
						&& "C".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
					policyAction.getCOMP_POL_FC_TOP_UP_AMT().setDisabled(true);
				} else {
					policyAction.getCOMP_POL_FC_TOP_UP_AMT().setDisabled(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					policyAction.getCOMP_POL_FC_TOP_UP_AMT().setDisabled(false);
				}
				policyAction.getCOMP_POL_LC_TOP_UP_AMT().setDisabled(false);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					policyAction.getCOMP_POL_LC_TOP_UP_AMT().setDisabled(false);
				}

			} else {
				policyAction.getCOMP_POL_FC_TOP_UP_AMT().setDisabled(true);
				policyAction.getCOMP_POL_LC_TOP_UP_AMT().setDisabled(true);
			}

			resultSet = handler.executeSelectStatement(CURSOR_C21, connection,
					new Object[] { policyBean.getPOL_PLAN_CODE() });
			if (resultSet.next()) {
				M_COVER_PREM_TYPE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);

			/*-----------------------------------------------------------------------------------------------------------*/
			if ("D".equals(dummyBean.getUI_M_POL_PLAN_TYPE())) {
				if ("D".equals(CommonUtils.nvl(M_COVER_PREM_TYPE, "N"))
						&& "U".equals(dummyBean.getUI_M_COVER_SA_CALC())) {

					if (policyAction.getCOMP_POL_FC_MODAL_PREM().isDisabled() == true) {
						policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(
								false);
					}
					policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(false);

					if (policyAction.getCOMP_POL_LC_MODAL_PREM().isDisabled() == true) {
						policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(
								false);
					}
					policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(false);

				} else {
					policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(true);
					policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(true);
				}
			}

			/*-----------------------------------------------------------------------------------------------------------*/
			if (dummyBean.getUI_M_POL_PLAN_TYPE() != "D") {
				if ("P".equals(dummyBean.getUI_M_COVER_SA_CALC())
						|| "V".equals(dummyBean.getUI_M_COVER_SA_CALC())
						|| "D".equals(dummyBean.getUI_M_COVER_SA_CALC())
						|| "F".equals(dummyBean.getUI_M_COVER_SA_CALC())
						|| "H".equals(dummyBean.getUI_M_COVER_SA_CALC())) {

					if (policyAction.getCOMP_POL_FC_MODAL_PREM().isDisabled() == true) {
						policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(
								false);
					}
					if ("Y".equals(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
						policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(
								false);
					}
					if (policyAction.getCOMP_POL_FC_MODAL_PREM().isDisabled() == true) {
						policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(
								false);
					}

					if ("Y".equals(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
						policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(
								false);
					}

					if ("001".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))
							|| "003".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "012".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "007".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "009".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "010".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "011".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "006".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))
							|| "015".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))) {

						policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(
								true);
						policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(
								true);

					} else if ("000".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))
							|| "002".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))) {
						if ("Y"
								.equals(CommonUtils
										.SUBSTR(
												commonUtils
														.getGlobalVariable("GLOBAL.M_PRIVILEGE"),
												2, 1))) {

							policyAction.getCOMP_POL_FC_MODAL_PREM()
									.setDisabled(false);
							policyAction.getCOMP_POL_LC_MODAL_PREM()
									.setDisabled(false);
						}
					}

					if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())
							&& "013".equals(CommonUtils.nvl(policyBean
									.getPOL_END_TYPE(), "000"))) {
						policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(
								true);
						policyAction.getCOMP_POL_LC_MODAL_PREM().setDisabled(
								true);
					}
					if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())
							|| "P".equals(dummyBean.getUI_M_COVER_SA_CALC())
							|| "V".equals(dummyBean.getUI_M_COVER_SA_CALC())
							|| "D".equals(dummyBean.getUI_M_COVER_SA_CALC())
							|| "H".equals(dummyBean.getUI_M_COVER_SA_CALC())) {
						policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
								true);
						policyAction.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
								true);
					}
				} else {
					/*modified by saranya on 17-03-2017*/
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setDisabled(true);
					
					/*Added by Saranya on 07/04/2017*/

					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FC_MODAL_PREM().setRequired(false);
					/*End*/
					
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_LC_MODAL_PREM().setDisabled(true);
					/*End*/
					if ("U".equals(dummyBean.getUI_M_COVER_SA_CALC())) {
						policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
								true);
						policyAction.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
								true);
					}
				}
			}
			/*---------------------------------------------------------------------------------------------------------------------*/

			resultSet = handler.executeSelectStatement(CURSOR_C15, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				dummyBean.setUI_M_DUMMY_CLAIMS(resultSet.getInt(1));
			}
			CommonUtils.closeCursor(resultSet);

			if (CommonUtils.nvl(dummyBean.getUI_M_DUMMY_CLAIMS(), 0) == 0) {
				dummyAction.getCOMP_UI_M_BUT_CLAIM().setDisabled(true);
				dummyAction.getCOMP_UI_M_BUT_CLAIM().setValue(
						"Claims" + " (" + dummyBean.getUI_M_DUMMY_CLAIMS()
								+ ") ");
			} else {
				dummyAction.getCOMP_UI_M_BUT_CLAIM().setDisabled(false);
				dummyAction.getCOMP_UI_M_BUT_CLAIM().setValue(
						dummyBean.getUI_M_DUMMY_CLAIMS() + "Claims");
			}

			if ("U".equals(dummyBean.getUI_M_POL_PLAN_TYPE())) {
				if ("PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) {
					dummyAction.getCOMP_UI_M_BUT_FUND_DTL().setDisabled(false);
				}
			} else {
				dummyAction.getCOMP_UI_M_BUT_FUND_DTL().setDisabled(true);
			}

			if (("Q".equals(CommonUtils.nvl(policyBean.getPOL_PROP_QUOT_FLAG(),
					"X")) || "IL_END_QUOT".equals("GLOBAL.M_PARAM_1"))
					&& (CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_13") != "Q" || CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13") != "1")) {

				local_procedures.IL_ENDT_QUOT_CHANGES(compositeAction);
			}

			if ("IL_END_QUOT".equals("GLOBAL.M_PARAM_1")) {
				local_procedures.IL_BLOCK_POL_DISABLED(compositeAction);
			}
			/*--------------------------------------------------------------------------------------------------------------*/
			if ("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"))
					&& "Q".equals(CommonUtils.nvl(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13"), "P"))) {
				if ("QN01".equals(policyBean.getPOL_ADDL_STATUS())) {
					dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
					System.out.println("ADABOINA DISABLE 99999999");
					dummyAction.getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
				}
			}

			if ("A".equals(policyBean.getPOL_APPRV_STATUS())) {
				dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(true);
			} else if ("Y".equals(policyBean.getPOL_FRZ_FLAG())) {
				dummyAction.getCOMP_UI_M_BUT_HOLD().setDisabled(false);
			}

			/*---------------------------------------------------------------------------------------------------------------------*/
			if ("C".equals(policyBean.getPOL_STATUS())) {
				local_procedures.IL_BLOCK_POL_DISABLED(compositeAction);
			}

			resultSet = handler.executeSelectStatement(CURSOR_C16, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY1 = resultSet.getString(1);
				dummyAction.getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(false);
			}
			CommonUtils.closeCursor(resultSet);
			/*-----------------------------------------------------------------------------------------------------------------------------*/
			resultSet = handler.executeSelectStatement(CURSOR_C17, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY2 = resultSet.getString(1);
				dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
			}
			CommonUtils.closeCursor(resultSet);
			/*-----------------------------------------------------------------------------------------------------------------------------*/

			if (CommonUtils.nvl(policyBean.getPOL_STATUS(), "N") != "A") {
				if (("013".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
						"000")) || "011".equals(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000")))
						|| "1".equals(policyBean.getPOL_DS_TYPE())) {
					policyAction.getCOMP_POL_ASSRD_REF_ID1().setDisabled(false);
				} else if (!("001".equals(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000")))) {
					policyAction.getCOMP_POL_ASSRD_REF_ID1().setDisabled(false);
				}

			}
			/*-----------------------------------------------------------------------------------------------------------------------------*/
			if (policyBean.getPOL_FRZ_FLAG() != "Y"
					&& "1".equals(policyBean.getPOL_DS_TYPE())) {
				policyAction.getCOMP_POL_DEPT_CODE().setDisabled(false);
				policyAction.getCOMP_POL_DIVN_CODE().setDisabled(false);
			} else {
				policyAction.getCOMP_POL_DEPT_CODE().setDisabled(true);
				policyAction.getCOMP_POL_DIVN_CODE().setDisabled(true);
			}

			/*--------------------------------------------------------------------------------------------------------------------------- */
			if ("U".equals(dummyBean.getUI_M_COVER_SA_CALC())
					|| "F".equals(dummyBean.getUI_M_COVER_SA_CALC())) {
				if ("Y".equals(policyBean.getPOL_FRZ_FLAG())) {
					policyAction.getCOMP_POL_NO_OF_UNIT().setDisabled(true);
				} else {
					policyAction.getCOMP_POL_NO_OF_UNIT().setDisabled(false);
					policyAction.getCOMP_POL_NO_OF_UNIT().setRequired(true);
				}
			} else {
				policyAction.getCOMP_POL_NO_OF_UNIT().setDisabled(true);
			}

			/*--------------------------------------------------------------------------------------------------------------------------- */
			if ("AG".equals(policyBean.getPOL_PYMT_TYPE())
					|| "NG".equals(policyBean.getPOL_PYMT_TYPE())) {
				policyAction.getCOMP_POL_PAYOR_SDCODE().setRequired(true);
				policyAction.getCOMP_POL_EMPLOYER_CODE().setRequired(true);
			} else {
				policyAction.getCOMP_POL_PAYOR_SDCODE().setRequired(false);
				policyAction.getCOMP_POL_EMPLOYER_CODE().setRequired(false);
			}

			/*--------------------------------------------------------------------------------------------------------------------------- */
			if (CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) == 0) {
				if ("AD".equals(policyBean.getPOL_PYMT_TYPE())
						|| "SC".equals(policyBean.getPOL_PYMT_TYPE())
						|| "CC".equals(policyBean.getPOL_PYMT_TYPE())
						|| "C1".equals(policyBean.getPOL_PYMT_TYPE())
						|| "C2".equals(policyBean.getPOL_PYMT_TYPE())
						|| "C3".equals(policyBean.getPOL_PYMT_TYPE())
						|| "C4".equals(policyBean.getPOL_PYMT_TYPE())
						|| "C5".equals(policyBean.getPOL_PYMT_TYPE())
						|| "C6".equals(policyBean.getPOL_PYMT_TYPE())) {
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
							false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
							false);
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
							false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(
							true);
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(
							true);

					if ("AD".equals(policyBean.getPOL_PYMT_TYPE())) {

						policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
								.setValue("Customer A/c No.");
						policyAction.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
								.setValue("Bank Name");
						policyAction.getCOMP_POL_CARD_HOLDER_NAME()
								.setRendered(true);
						policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
								.setRendered(true);
						/*Commented by ganesh on 24-10-2017 as suggested by ajoy*/
						/*policyAction.getCOMP_POL_AUTH_LIMIT().setRendered(true);
						policyAction.getCOMP_POL_AUTH_LIMIT_LABEL()
								.setRendered(true);

						if (policyAction.getCOMP_POL_AUTH_LIMIT().isRendered() == true) {
							policyAction.getCOMP_POL_AUTH_LIMIT().setDisabled(
									false);
						}*/
						/*end*/

					} else if ("SC".equals(policyBean.getPOL_PYMT_TYPE())
							|| "CC".equals(policyBean.getPOL_PYMT_TYPE())
							|| "C1".equals(policyBean.getPOL_PYMT_TYPE())
							|| "C2".equals(policyBean.getPOL_PYMT_TYPE())
							|| "C3".equals(policyBean.getPOL_PYMT_TYPE())
							|| "C4".equals(policyBean.getPOL_PYMT_TYPE())
							|| "C5".equals(policyBean.getPOL_PYMT_TYPE())
							|| "C6".equals(policyBean.getPOL_PYMT_TYPE())) {

						policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
								.setValue("Credit Card No.");
						policyAction.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
								.setValue("Credit Card Marchant Clearing Bank");
						policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
								.setValue("Credit Card Holder Name");
						policyAction.getCOMP_POL_AUTH_LIMIT()
								.setRendered(false);
						policyAction.getCOMP_POL_AUTH_LIMIT()
								.setRendered(false);
						policyAction.getCOMP_UI_M_BUT_CC_LOV()
								.setRendered(true);
						policyAction.getCOMP_UI_M_BUT_CC_LOV().setDisabled(
								false);
						policyAction.getCOMP_POL_CARD_HOLDER_NAME()
								.setRendered(true);
						policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
								.setRendered(true);
						if (policyAction.getCOMP_POL_CARD_HOLDER_NAME()
								.isRendered() == true) {
							policyAction.getCOMP_POL_CARD_HOLDER_NAME()
									.setDisabled(false);
						}

						policyAction.getCOMP_POL_CARD_HOLDER_NAME()
								.setRequired(true);
						resultSet = handler.executeSelectStatement(CURSOR_C19,
								connection, new Object[] { commonUtils
										.getControlBean().getM_USER_ID() });
						if (resultSet.next()) {
							M_CREDIT_CARD_UPD_YN = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);

						if ("M".equals(M_CREDIT_CARD_UPD_YN)
								&& policyBean.getUI_M_POL_CONT_AD_ACC_NO() != null) {
							policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
									.setDisabled(true);
						}
					}

				} else if ("BS".equals(policyBean.getPOL_PYMT_TYPE())) {

					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
							.setValue("Account Holder Bank A/c No.");
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue("Bank Name");
					policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL().setValue(
							"Account Holder Name");
					policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setRendered(true);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setRendered(
							true);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setRendered(true);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(
							false);
					policyAction.getCOMP_POL_AUTH_LIMIT().setRequired(false);
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
							false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
							false);
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(
							false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(
							false);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setRequired(
							false);

				} else {

					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
							true);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
							true);

					if (policyAction.getCOMP_POL_CARD_HOLDER_NAME()
							.isRendered() == true) {
						policyAction.getCOMP_POL_CARD_HOLDER_NAME()
								.setDisabled(true);
						policyAction.getCOMP_POL_CARD_HOLDER_NAME()
								.setRequired(false);
					}

					if (policyAction.getCOMP_POL_AUTH_LIMIT().isRendered() == true) {
						policyAction.getCOMP_POL_AUTH_LIMIT().setDisabled(true);
						policyAction.getCOMP_POL_AUTH_LIMIT()
								.setRequired(false);
					}

				}
			}

			if ("A".equals(CommonUtils.nvl(policyBean.getPOL_APPRV_STATUS(),
					"N"))) {
				compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
						.setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
						.setUPDATE_ALLOWED(false);
				compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
						.setDELETE_ALLOWED(false);

				medicalHistry1.setINSERT_ALLOWED(false);
				medicalHistry1.setUPDATE_ALLOWED(false);
				medicalHistry1.setDELETE_ALLOWED(false);
			}

			if ("SC".equals(policyBean.getPOL_PYMT_TYPE())
					|| "CC".equals(policyBean.getPOL_PYMT_TYPE())
					|| "C1".equals(policyBean.getPOL_PYMT_TYPE())
					|| "C2".equals(policyBean.getPOL_PYMT_TYPE())
					|| "C3".equals(policyBean.getPOL_PYMT_TYPE())
					|| "C4".equals(policyBean.getPOL_PYMT_TYPE())
					|| "C5".equals(policyBean.getPOL_PYMT_TYPE())
					|| "C6".equals(policyBean.getPOL_PYMT_TYPE())) {
				resultSet = handler.executeSelectStatement(CURSOR_C19,
						connection, new Object[] { commonUtils.getControlBean()
								.getM_USER_ID() });
				if (resultSet.next()) {
					M_CREDIT_CARD_UPD_YN = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);

				if ("N".equals(M_CREDIT_CARD_UPD_YN)) {
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
							true);
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(
							true);

				}
			}

			if ("2".equals(policyBean.getPOL_DS_TYPE())) {
				if ("PILQ121_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) {
					dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(true);
				} else {
					dummyAction.getCOMP_UI_M_BUT_ENDT().setDisabled(false);
				}
			}

			if (!("SC".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("CC".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("C1".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("C2".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("C3".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("C4".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("C5".equals(policyBean.getPOL_PYMT_TYPE()))
					|| !("C6".equals(policyBean.getPOL_PYMT_TYPE()))) {

				policyAction.getCOMP_UI_M_BUT_CC_LOV().setRendered(false);
			} else if (("SC".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("CC".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("C1".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("C2".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("C3".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("C4".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("C5".equals(policyBean.getPOL_PYMT_TYPE()))
					|| ("C6".equals(policyBean.getPOL_PYMT_TYPE()))) {

				policyAction.getCOMP_UI_M_BUT_CC_LOV().setRendered(true);
			}
			if ("016".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),
					"000"))) {
				policyAction.getCOMP_POL_NO_OF_UNIT().setDisabled(true);
			}

			if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())
					&& "Y".equals(CommonUtils.nvl(dummyBean
							.getUI_M_PLAN_CALC_TYPE(), "N"))) {
				policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(false);
				policyAction.getCOMP_POL_FC_SUM_ASSURED().setRequired(true);
				policyAction.getCOMP_POL_NO_OF_UNIT().setDisabled(true);
			}
			
			
			/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
			/*System.out.println( "policyAction.getUnit_link_typ()  :"+policyAction.getUnit_link_typ());
			if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())&&(!"NA".equalsIgnoreCase(policyAction.getUnit_link_typ()))){
				policyAction.getCOMP_POL_UL_PREM_CALC().setDisabled(false);

				policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
				policyAction.getCOMP_POL_FC_SUM_ASSURED().setRequired(false);*/
				/*Commented by Saranya on 28/03/2017
				 * 
				 * policyAction.getCOMP_POL_ANN_BNF_AMT().setDisabled(false);*/
				/*policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(true);
				policyAction.getCOMP_POL_FC_MODAL_PREM().setRequired(false);*/
			/*}*//*
			
Commeneted by Saranya on 07/04/2017
			else{
				Added by Saranya on 28/03/2017
				policyAction.getCOMP_POL_UL_PREM_CALC().setDisabled(true);
				
				policyAction.getCOMP_POL_ANN_BNF_AMT().setDisabled(true);
				policyAction.getCOMP_POL_ANN_BNF_AMT().setRequired(false);
//				policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(false);
//				policyAction.getCOMP_POL_FC_MODAL_PREM().setRequired(true);
				
			}*/
			
			/*End*/
			
			/*ReModified by  saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 12/04/2017*/
			policyAction.Unit_link_typ();
			System.out.println( "policyAction.getUnit_link_typ()  :"+policyAction.getUnit_link_typ()+"COVER_SA_CALC  :"+dummyBean.getUI_M_COVER_SA_CALC());
			if ("F".equals(dummyBean.getUI_M_COVER_SA_CALC())&&(!"NA".equalsIgnoreCase(policyAction.getUnit_link_typ()))){
				policyAction.getCOMP_POL_UL_PREM_CALC().setDisabled(false);
				policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
				policyAction.getCOMP_POL_FC_SUM_ASSURED().setRequired(false);
				policyAction.getCOMP_POL_ANN_BNF_AMT().setDisabled(false);
				policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(false);
				policyAction.getCOMP_POL_FC_MODAL_PREM().setRequired(true);
		
			}else
			{
				policyAction.getCOMP_POL_UL_PREM_CALC().setDisabled(true);
				
				/*
				 * 
				 * commented by Dhinesh on 01-06-2018 
				 * 
				 * 	policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(false);
					policyAction.getCOMP_POL_FC_SUM_ASSURED().setRequired(true);
				*/
				
				/* Newly Added By Dhinesh on 01-06-2018 */
				if("Y".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.PROD_SA_BY_PLAN_BASIS_YN")))
				{
					policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
					policyAction.getCOMP_POL_FC_SUM_ASSURED().setRequired(false);
					policyAction.getCOMP_POL_FC_SUM_ASSURED().resetValue();
				}else
				{
					policyAction.getCOMP_POL_FC_SUM_ASSURED().setDisabled(false);
					policyAction.getCOMP_POL_FC_SUM_ASSURED().setRequired(true);
				}
				
				/*  End */
				
				
				
				policyAction.getCOMP_POL_ANN_BNF_AMT().setDisabled(true);
				policyAction.getCOMP_POL_FC_MODAL_PREM().setDisabled(true);
				policyAction.getCOMP_POL_FC_MODAL_PREM().setRequired(false);
				
			}
			
			

			
			/*End*/

			// Added by Dileshwar B. Patle Dated : - 19th July 2012
			// PROD_CBC_YN handling
			// Scenario : - when converted proposal quering in policy menu
			// Condition : - if prod_code have CBC flag yes then product get
			// Disbled (Discussed with Vishnu and Fixed)

			if (policyBean.getPOL_NO() != null) {
				if ("2".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_11"))) {
					if (policyBean.getPOL_PROD_CODE().equals(
							CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6"))) {
						String QUERY = "SELECT PROD_CBC_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
						resultSet3 = new CRUDHandler().executeSelectStatement(
								QUERY, CommonUtils.getConnection(),
								new Object[] { policyBean.getPOL_PROD_CODE() });
						if (resultSet3.next()) {
							M_PROD_CBC_YN = resultSet3.getString(1);
							if ("Y".equals(M_PROD_CBC_YN)) {
								policyAction.getCOMP_POL_PROD_CODE()
										.setDisabled(true);
							}
						}
					}
				}
			}
			if ("Y".equals(policyBean.getPOL_ESC_YN())) {
				policyAction.getCOMP_POL_CVR_ESC_PERC().setDisabled(false);
				policyAction.getCOMP_POL_FLEX_14().setDisabled(false);
				policyAction.getCOMP_POL_FLEX_09().setDisabled(false);
				policyAction.getCOMP_POL_FLEX_18().setDisabled(false);
				policyBean.setPOL_CVR_ESC_PERC(3);
			} else {
				policyBean.setPOL_CVR_ESC_PERC(0);
				policyAction.getCOMP_POL_CVR_ESC_PERC().setDisabled(true);
				policyAction.getCOMP_POL_FLEX_14().setDisabled(true);
				policyAction.getCOMP_POL_FLEX_09().setDisabled(true);
				policyAction.getCOMP_POL_FLEX_18().setDisabled(true);

			}
			if(!((policyBean.getPOL_APPRV_STATUS().equalsIgnoreCase("N")&&policyBean.getPOL_FRZ_FLAG().equalsIgnoreCase("Y")&&(
					policyBean.getPOL_DS_TYPE().equalsIgnoreCase("1")||policyBean.getPOL_DS_TYPE().equalsIgnoreCase("2")))||
					(policyBean.getPOL_APPRV_STATUS().equalsIgnoreCase("A")&&policyBean.getPOL_DS_TYPE().equalsIgnoreCase("2"))))
			{
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
				
			}
			
			/*Added by Ameen on 09-02-2018 for KIC to check credit and knet and handle those fields*/
			
			 if ("SC".equalsIgnoreCase(policyBean.getPOL_PYMT_TYPE())) {
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
					.setValue("Credit Card No.");
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue(" Credit Card Bank ");
					policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setValue(" Credit Card Holder Name ");
					
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(false);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(false);
					policyAction.getCOMP_POL_CARD_EXP_DT().setDisabled(false);
					policyAction.getCOMP_POL_CVV_NO().setDisabled(false);
					
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(false);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setRequired(false);
					policyAction.getCOMP_POL_CARD_EXP_DT().setRequired(false);
					policyAction.getCOMP_POL_CVV_NO().setRequired(false);
					
				}else  if ("B".equalsIgnoreCase(policyBean.getPOL_PYMT_TYPE())) {
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO_LABEL()
					.setValue("Knet Card No.");
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE_LABEL()
							.setValue(" Knet Card Merchant Bank ");
					policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL()
							.setValue(" Knet Card Holder Name ");
					
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(false);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(false);
					policyAction.getCOMP_POL_CARD_EXP_DT().setDisabled(false);
					policyAction.getCOMP_POL_CVV_NO().setDisabled(false);
					
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(false);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setRequired(false);
					policyAction.getCOMP_POL_CARD_EXP_DT().setRequired(false);
					policyAction.getCOMP_POL_CVV_NO().setRequired(false);
					
				}else{
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(true);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(true);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(true);
					policyAction.getCOMP_POL_CARD_EXP_DT().setDisabled(true);
					policyAction.getCOMP_POL_CVV_NO().setDisabled(true);
					
					policyAction.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setRequired(false);
					policyAction.getCOMP_POL_CONT_AD_BANK_CODE().setRequired(false);
					policyAction.getCOMP_POL_CARD_HOLDER_NAME().setRequired(false);
					policyAction.getCOMP_POL_CARD_EXP_DT().setRequired(false);
					policyAction.getCOMP_POL_CVV_NO().setRequired(false);
				}
			 System.out.println("COMP_POL_CARD_HOLDER_NAME_LABEL - isRendered"+ policyAction.getCOMP_POL_CARD_HOLDER_NAME_LABEL().isRendered());
			 System.out.println("COMP_POL_CARD_HOLDER_NAME - isRendered"+ policyAction.getCOMP_POL_CARD_HOLDER_NAME().isRendered());
			 
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}
	}

	public String getPlanType(String planCode) throws Exception {
		String selectQuery = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ? ";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String planType = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { planCode });
			if (rs.next()) {
				planType = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return planType;
	}

	public void onPopulateDetails(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		PT_IL_POL_CHARGE_DELEGATE chargeDelegate = new PT_IL_POL_CHARGE_DELEGATE();
		PT_IL_POL_CONDITION_DELEGATE conditionDelegate = new PT_IL_POL_CONDITION_DELEGATE();
		PT_IL_POL_RED_SA_DELEGATE redSaDelegate = new PT_IL_POL_RED_SA_DELEGATE();
		PT_IL_SURR_MAT_VALUES_DELEGATE matValuesDelegate = new PT_IL_SURR_MAT_VALUES_DELEGATE();
		PT_IL_POL_BROKER_HEAD_DELEGATE brokerHeadDelegate = new PT_IL_POL_BROKER_HEAD_DELEGATE();
		PT_IL_UNPAID_PREM_DTLS_DELEGATE unpaidPremiumDelegate = new PT_IL_UNPAID_PREM_DTLS_DELEGATE();
		PT_IL_DOC_TODO_LIST_STATUS_DELEGATE todoListDelegate = new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE();
		PT_IL_POLICY_1_DELEGATE policy1Delegate = new PT_IL_POLICY_1_DELEGATE();
		PT_IL_POL_STATUS_DELEGATE statusDelegate = new PT_IL_POL_STATUS_DELEGATE();
		PT_IL_POL_STATUS_1_DELEGATE status1Delegate = new PT_IL_POL_STATUS_1_DELEGATE();
		PT_IL_POL_STATUS_2_DELEGATE status2Delegate = new PT_IL_POL_STATUS_2_DELEGATE();
		PT_IL_POL_BENEFICIARY_DELEGATE beneficiaryDelegate = new PT_IL_POL_BENEFICIARY_DELEGATE();
		PT_IL_POL_DISC_LOAD_DELEGATE discLoadDelegate = new PT_IL_POL_DISC_LOAD_DELEGATE();
		PT_IL_POL_ASSURED_DTLS_DELEGATE assuredDelegate = new PT_IL_POL_ASSURED_DTLS_DELEGATE();
		PT_IL_POL_ASSURED_DTLS_1_DELEGATE assured1Delegate = new PT_IL_POL_ASSURED_DTLS_1_DELEGATE();
		PT_IL_POL_FUND_DTL_DELEGATE fundDelegate = new PT_IL_POL_FUND_DTL_DELEGATE();
		PT_IL_POL_FUND_DTL_1_DELEGATE fund1Delegate = new PT_IL_POL_FUND_DTL_1_DELEGATE();
		PT_IL_POL_ASSR_MED_HIST_DELEGATE medicalhistryDelegate = new PT_IL_POL_ASSR_MED_HIST_DELEGATE();
		PT_IL_POL_ASSR_MED_HIST_1_DELEGATE medicalhistry1Delegate = new PT_IL_POL_ASSR_MED_HIST_1_DELEGATE();
		PT_IL_POL_SA_INST_PYMT_HEAD_DELEGATE pymentDelegate = new PT_IL_POL_SA_INST_PYMT_HEAD_DELEGATE();

		try {
			if (policyBean.getROWID() != null) {

				if (policyBean.getROWID() != null) {
					chargeDelegate.executeSelectStatement(compositeAction);
					conditionDelegate.executeSelectStatement(compositeAction);
					redSaDelegate.executeSelectStatement(compositeAction);
					matValuesDelegate.executeSelectStatement(compositeAction);
					brokerHeadDelegate.executeSelectStatement(compositeAction);
					unpaidPremiumDelegate
							.executeSelectStatement(compositeAction);
					todoListDelegate.executeSelectStatement(compositeAction);
					policy1Delegate.executeSelectStatement(compositeAction);
					statusDelegate.executeSelectStatement(compositeAction);
					status1Delegate.executeSelectStatement(compositeAction);
					beneficiaryDelegate.executeSelectStatement(compositeAction);
					assuredDelegate.executeSelectStatement(compositeAction);
					discLoadDelegate.executeSelectStatement(compositeAction);
					fundDelegate.executeSelectStatement(compositeAction);
					fund1Delegate.executeSelectStatement(compositeAction);
					assured1Delegate.executeSelectStatement(compositeAction);
					status2Delegate.executeSelectStatement(compositeAction);
					medicalhistryDelegate.executeSelectStatement(
							compositeAction, policyBean.getPOL_SYS_ID(), null);
					medicalhistry1Delegate.executeSelectStatement(
							compositeAction, policyBean.getPOL_SYS_ID(), null);
					pymentDelegate.executeSelectStatement(compositeAction);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void ON_CHECK_DELETE_MASTER(PT_IL_POLICY pt_il_policy_bean) {
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};

		String Dummy_Define = null;
		String PT_IL_POL_RED_SA_cur = "    SELECT 1 FROM PT_IL_POL_RED_SA P    "
				+ "   WHERE P.PRS_POL_SYS_ID = ?  ";
		String PT_IL_POL_FUND_DTL_1_cur = "   SELECT 1 FROM PT_IL_POL_FUND_DTL P "
				+ "     WHERE P.POFD_POL_SYS_ID = ? ";
		String PT_IL_POL_ASSURED_DTLS_1_cur = " SELECT 1 FROM PT_IL_POL_ASSURED_DTLS P  "
				+ " WHERE P.POAD_POL_SYS_ID = ? ";

		String PT_IL_POL_ASSR_MED_HIST_1_cur = " SELECT 1 FROM PT_IL_POL_ASSR_MED_HIST P "
				+ " WHERE P.PAMH_POL_SYS_ID = ? ";
		try {

			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };

			rs = handler.executeSelectStatement(PT_IL_POL_RED_SA_cur,
					connection, values);
			if (rs.next()) {
				Dummy_Define = rs.getString(1);
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");

			}

			rs = handler.executeSelectStatement(PT_IL_POL_FUND_DTL_1_cur,
					connection, values);
			if (rs.next()) {
				Dummy_Define = rs.getString(1);
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");

			}

			rs = handler.executeSelectStatement(PT_IL_POL_ASSURED_DTLS_1_cur,
					connection, values);
			if (rs.next()) {
				Dummy_Define = rs.getString(1);
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");

			}

			rs = handler.executeSelectStatement(PT_IL_POL_ASSR_MED_HIST_1_cur,
					connection, values);
			if (rs.next()) {
				Dummy_Define = rs.getString(1);
				throw new Exception(
						"Cannot delete master record when matching detail records exist.");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void dummyButtonEnableDisable(DUMMY_ACTION dummy_action) {
		System.out.println("ADABOINA DISABLE 111111");
		dummy_action.getCOMP_UI_M_BUT_CONVERT().setDisabled(true);
		dummy_action.getCOMP_UI_M_BUT_PREM_ALLOC().setDisabled(true);
		dummy_action.getCOMP_UI_M_BUT_HOLD().setDisabled(true);

	}

	public void chkNormalOrPackagePolicy(PT_IL_POLICY_ACTION pt_il_policy_action) {
		try {
			// 'NR' for normal and 'PG' for package policy using menu
			// parameter_18

			if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))
					|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18") == null) {
				pt_il_policy_action.getCOMP_POL_PROD_GROUP_CODE().setRendered(
						false);
				pt_il_policy_action.getCOMP_MANDATORY().setRendered(false);
				pt_il_policy_action.getCOMP_POL_PROD_GROUP_CODE().setRequired(
						false);
				pt_il_policy_action.getCOMP_UI_M_POL_PROD_GROUP_CODE()
						.setRendered(false);
				pt_il_policy_action.setPOL_PROD_GROUP_CODE_REQ(false);

				pt_il_policy_action.getCOMP_UI_M_POL_PROD_GROUP_CODE()
						.setRequired(false);
				pt_il_policy_action.getCOMP_POL_PROD_GROUP_CODE_LABEL()
						.setRendered(false);

				// pt_il_policy_action.getCOMP_POL_PROD_CODE().setRendered(false);
				pt_il_policy_action.getCOMP_POL_PROD_CODE().setRequired(true);
			} else if ("PG".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
				pt_il_policy_action.getCOMP_POL_PROD_GROUP_CODE().setRendered(
						true);
				pt_il_policy_action.getCOMP_MANDATORY().setRendered(true);
				pt_il_policy_action.getCOMP_POL_PROD_GROUP_CODE().setRequired(
						true);
				pt_il_policy_action.getCOMP_UI_M_POL_PROD_GROUP_CODE()
						.setRendered(true);
				pt_il_policy_action.getCOMP_UI_M_POL_PROD_GROUP_CODE()
						.setRequired(true);
				pt_il_policy_action.setPOL_PROD_GROUP_CODE_REQ(true);
				pt_il_policy_action.getCOMP_POL_PROD_GROUP_CODE_LABEL()
						.setRendered(true);

				// pt_il_policy_action.getCOMP_POL_PROD_CODE().setRendered(false);
				pt_il_policy_action.getCOMP_POL_PROD_CODE().setRequired(false);
			}

			// ADDED BY DILESHWAR DATED 19TH JULY 2012

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public String buttonPressPrint(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		CRUDHandler handler = null;
		Connection connection = null;
		String C1 = "SELECT PC_DESC, PC_BL_DESC FROM   PM_CODES	WHERE  PC_TYPE = 'IL_REMIN_RPT'	AND    PC_CODE = 'END/011'";

		String C2 = "SELECT CONT_PREFERRED_LANG     FROM   PM_IL_CONTRACTOR  	WHERE  CONT_CODE = ? ";
		String C3 = " SELECT PS_VALUE     FROM PP_SYSTEM    WHERE PS_TYPE = 'IL_RDF_MMRG'";
		String C4 = "SELECT  DS_PRN_BEFORE_APPR "
				+ "FROM PM_IL_DOC_SETUP WHERE   DS_TYPE = ? AND     DS_CODE = ?";
		String C5 = "	SELECT DS_PRN_BEFORE_APPR " + "FROM PM_IL_DOC_SETUP "
				+ "WHERE DS_TYPE = '3' " + "AND DS_END_TYPE = ? "
				+ "AND DS_CODE = ? ";

		String C6 = "SELECT NVL(POL_FLEX_05,'N') FROM PT_IL_POLICY WHERE POL_NO=?";

		String updateQry = "UPDATE PT_IL_POLICY SET POL_FLEX_05 ='Y' WHERE POL_NO=?";

		String C7 = " SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE = 'POL_REPRINT' "
				+ "  AND ASD_USER_ID = ? AND ? BETWEEN NVL(ASD_FM_PROD_CODE, '0') AND NVL(ASD_TO_PROD_CODE, 'zzzzzzzzzzzz')";
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;

		int M_PS_VALUE = 0;
		String outcome = null;
		String M_DS_PRN_BEFORE_APPR = null;
		String M_PC_DESC = null;
		String M_PC_BL_DESC = null;
		String M_CONT_PREFERRED_LANG = null;
		String M_REP_NAME = null;
		String M_FLEX05 = null;
		String M_polreprint = null;

		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C6_REC = handler.executeSelectStatement(C6, connection,
					new Object[] { policyBean.getPOL_NO() });
			if (C6_REC.next()) {
				M_FLEX05 = C6_REC.getString(1);
			}
			C7_REC = handler.executeSelectStatement(C7, connection,
					new Object[] {
							CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
							policyBean.getPOL_PROD_CODE() });
			if (C7_REC.next()) {
				M_polreprint = C7_REC.getString(1);
			}
			/*
			 * if("N".equalsIgnoreCase(M_FLEX05)){
			 * handler.executeUpdateStatement(updateQry, connection, new
			 * Object[]{policyBean.getPOL_NO()}); connection.commit(); }else{
			 */
			if ("Y".equalsIgnoreCase(M_FLEX05)) {
				if ("N".equalsIgnoreCase(M_polreprint)) {
					throw new Exception("User not authorized to Reprint");
				}
			}
			C3_REC = handler.executeSelectStatement(C3, connection);
			if (C3_REC.next()) {
				M_PS_VALUE = C3_REC.getInt(1);
			}
			// CALC MTHD ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			if (compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
					.getUI_M_CALC_METHOD() == 1
					|| compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.getUI_M_CALC_METHOD() == 2) {
				if ("1".equalsIgnoreCase(policyBean.getPOL_DS_TYPE())
						&& !"Q".equalsIgnoreCase(policyBean
								.getPOL_PROP_QUOT_FLAG())) {
					if (CommonUtils.nvl(M_PS_VALUE, 0) == 2) {
						// L_PRINT_STATUS;
					} else {
						CommonUtils.setGlobalVariable("GLOBAL.G_DOC_NO",
								policyBean.getPOL_NO());
						CommonUtils.setGlobalVariable("GLOBAL.G_SYS_ID",
								policyBean.getPOL_SYS_ID().toString());
						CommonUtils.setGlobalVariable("GLOBAL.G_PROD_CODE",
								policyBean.getPOL_PROD_CODE());
						CommonUtils.setGlobalVariable("GLOBAL.G_DS_TYPE",
								policyBean.getPOL_DS_TYPE());
						CommonUtils.setGlobalVariable("GLOBAL.G_DS_CODE",
								policyBean.getPOL_DS_CODE());
						CommonUtils.setGlobalVariable("GLOBAL.G_REP_FOR", "P");
						CommonUtils
								.setGlobalVariable("GLOBAL.G_SURR_MAT", null);
						
						/*added b y nathiya on 18.3.2016 for quotation letter*/
						
						System.out.println("policyBean.getPOL_PROP_NO()         "+policyBean
								.getPOL_PROP_NO());
						CommonUtils.setGlobalVariable("GLOBAL.M_POL_PROP_NO", policyBean
								.getPOL_PROP_NO());
						
						/*end*/
						
						// M_MODULE_NAME := NAME_IN('GLOBAL.M_MODULE_NAME') ;
						CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
								policyBean.getPOL_SYS_ID().toString());
						//outcome = "PILP100_APAC_DUMMY";
						outcome = "PILP016_PRINT";
					}
				}
			} else if (("2".equalsIgnoreCase(policyBean.getPOL_DS_TYPE()) && !"S"
					.equalsIgnoreCase(policyBean.getPOL_STATUS()))
					|| ("1".equalsIgnoreCase(policyBean.getPOL_DS_TYPE()) && "Q"
							.equalsIgnoreCase(policyBean
									.getPOL_PROP_QUOT_FLAG()))) {
				if (CommonUtils.nvl(M_PS_VALUE, 0) == 2) {
					// L_PRINT_STATUS;
				}
				if ("000".equalsIgnoreCase(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000"))) {
					C4_REC = handler.executeSelectStatement(C4, connection,
							new Object[] { policyBean.getPOL_DS_TYPE(),
									policyBean.getPOL_DS_CODE() });
					if (C4_REC.next()) {
						M_DS_PRN_BEFORE_APPR = C4_REC.getString(1);
					}
					if ("Y".equalsIgnoreCase(CommonUtils.nvl(
							M_DS_PRN_BEFORE_APPR, "N"))
							|| ("N".equalsIgnoreCase(CommonUtils.nvl(
									M_DS_PRN_BEFORE_APPR, "N")) && "A"
									.equalsIgnoreCase(policyBean
											.getPOL_APPRV_STATUS()))) {
						CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
								policyBean.getPOL_SYS_ID().toString());
						outcome = "PILP016_PRINT";
					} else if ("Y".equalsIgnoreCase(CommonUtils.nvl(
							M_DS_PRN_BEFORE_APPR, "N"))
							&& "A".equalsIgnoreCase(policyBean
									.getPOL_APPRV_STATUS())) {
						throw new Exception("22003");
					}
				} else if (!"000".equalsIgnoreCase(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000"))) {
					C5_REC = handler.executeSelectStatement(C4, connection,
							new Object[] { policyBean.getPOL_DS_TYPE(),
									policyBean.getPOL_DS_CODE() });
					if (C5_REC.next()) {
						M_DS_PRN_BEFORE_APPR = C5_REC.getString(1);
					}

					if (!"A".equalsIgnoreCase(policyBean.getPOL_APPRV_STATUS())
							&& "Y".equalsIgnoreCase(CommonUtils.nvl(
									M_DS_PRN_BEFORE_APPR, "N"))
							&& ("R"
									.equalsIgnoreCase(policyBean
											.getPOL_STATUS()) || "E"
									.equalsIgnoreCase(policyBean
											.getPOL_STATUS()))) {
						CommonUtils.setGlobalVariable("GLOBAL.G_DOC_NO",
								policyBean.getPOL_NO());
						CommonUtils.setGlobalVariable("GLOBAL.G_SYS_ID",
								policyBean.getPOL_SYS_ID().toString());
						CommonUtils.setGlobalVariable("GLOBAL.G_PROD_CODE",
								policyBean.getPOL_PROD_CODE());
						CommonUtils.setGlobalVariable("GLOBAL.G_DS_TYPE",
								policyBean.getPOL_DS_TYPE());
						CommonUtils.setGlobalVariable("GLOBAL.G_DS_CODE",
								policyBean.getPOL_DS_CODE());
						CommonUtils.setGlobalVariable("GLOBAL.G_REP_FOR", "P");
						CommonUtils
								.setGlobalVariable("GLOBAL.G_SURR_MAT", null);
						// M_MODULE_NAME := NAME_IN('GLOBAL.M_MODULE_NAME') ;
						CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
								policyBean.getPOL_SYS_ID().toString());
						//outcome = "PILP100_APAC_DUMMY";
						outcome = "PILP016_PRINT";
					} else if ("A".equalsIgnoreCase(policyBean
							.getPOL_APPRV_STATUS())) {
						CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
								policyBean.getPOL_SYS_ID().toString());
						outcome = "PILP016_PRINT";
					} else if ("N".equalsIgnoreCase(CommonUtils.nvl(
							M_DS_PRN_BEFORE_APPR, "N"))
							&& !"A".equalsIgnoreCase(policyBean
									.getPOL_APPRV_STATUS())) {
						throw new Exception("22003");
					}
				}

				if ("011".equalsIgnoreCase(CommonUtils.nvl(policyBean
						.getPOL_END_TYPE(), "000"))
						&& "A".equalsIgnoreCase(CommonUtils.nvl(policyBean
								.getPOL_APPRV_STATUS(), "N"))) {
					C1_REC = handler.executeSelectStatement(C1, connection);
					if (C1_REC.next()) {
						M_PC_DESC = C1_REC.getString(1);
						M_PC_BL_DESC = C1_REC.getString(2);
					}

					C2_REC = handler.executeSelectStatement(C2, connection,
							new Object[] { policyBean.getPOL_CONT_CODE() });
					if (C2_REC.next()) {
						M_CONT_PREFERRED_LANG = C2_REC.getString(1);
					}

					if ("E".equalsIgnoreCase(CommonUtils.nvl(
							M_CONT_PREFERRED_LANG, "E"))) {
						M_REP_NAME = M_PC_DESC;
					} else {
						M_REP_NAME = M_PC_BL_DESC;
					}
					/*
					 * P9ILPK_UW_LETTERS.GEN_JE_ASSIGNMENT_LETTER(M_DSRC_SYS_ID,M_REP_NAME,:PT_IL_POLICY.POL_SYS_ID);
					 * P_LIFE_LETTER( M_DSRC_SYS_ID,M_REP_NAME,'O','UW');
					 */
				}

				if (!"M".equalsIgnoreCase(compositeAction
						.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.getUI_M_POL_PLAN_TYPE())) {
					if ("006".equalsIgnoreCase(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))) {
						if (policyBean.getPOL_END_NO_IDX() > 0) {
							if ("B09".equalsIgnoreCase(policyBean
									.getPOL_ADDL_STATUS())
									|| "B10".equalsIgnoreCase(policyBean
											.getPOL_ADDL_STATUS())) {
								/*
								 * :DUMMY.M_PRINT_TYPE := 'O';
								 * L_GEN_ENDORSE_COUNT_OFFER;
								 */
							}

							/*
							 * IF :PT_IL_POLICY.POL_APPRV_STATUS = 'A' THEN
							 * :DUMMY.M_PRINT_TYPE := 'O'; IF
							 * NVL(:PT_IL_POLICY.POL_END_TYPE,'000') = '006'
							 * THEN L_GEN_ENDORSEMENT_LETTER; END IF;
							 */
						}
					}
				}

			}
			CommonUtils.setGlobalVariable("GLOBAL.G_PROD_CODE", policyBean
					.getPOL_PROD_CODE());
			CommonUtils.setGlobalVariable("GLOBAL.G_DS_TYPE", policyBean
					.getPOL_DS_TYPE());
			CommonUtils.setGlobalVariable("GLOBAL.G_DS_CODE", policyBean
					.getPOL_DS_CODE());
			CommonUtils.setGlobalVariable("GLOBAL.G_SYS_ID", policyBean
					.getPOL_SYS_ID().toString());
			CommonUtils.setGlobalVariable("GLOBAL.G_REP_FOR", "P");
			CommonUtils.setGlobalVariable("GLOBAL.G_SURR_MAT", null);
			// M_MODULE_NAME := NAME_IN('GLOBAL.M_MODULE_NAME') ;
			CommonUtils.setGlobalVariable("GLOBAL.M_REC_POL_SYS_ID", policyBean
					.getPOL_SYS_ID().toString());
			if (policyBean.getPOL_NO() != null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_POLICY_POL_NO",
						policyBean.getPOL_NO());
			}
			if ("A".equalsIgnoreCase(policyBean.getPOL_APPRV_STATUS())) {
				outcome = "PILP016_PRINT";
			} else if ("N".equalsIgnoreCase(policyBean.getPOL_APPRV_STATUS())) {
				//outcome = "PILP100_APAC_DUMMY";
				outcome = "PILP016_PRINT";
			}
			// COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ;
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", policyBean
					.getPOL_SYS_ID().toString());
			CommonUtils
					.setGlobalVariable("GLOBAL.CALLING_FORM", "PILT002_APAC");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);

		}
		return outcome;
	}

	/**
	 * 
	 * @param PT_IL_POLICY_BEAN
	 * @return
	 */
	public String enableDisableForAPLYN(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		Connection connection = null;
		ResultSet rs1 = null;
		Object[] values = {};

		String query1 = " SELECT PROD_FLEX_01 FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";

		String aplYN = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() };
			rs1 = handler.executeSelectStatement(query1, connection, values);
			if (rs1.next()) {
				aplYN = rs1.getString(1);
			}

			if (aplYN != null && "Y".equalsIgnoreCase(aplYN)) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOM_POL_APL_LIST().setDisabled(false);
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOM_POL_APL_LIST().setDisabled(true);
			}

			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOM_POL_APL_LIST()
					.resetValue();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aplYN;
	}

	/**
	 * 
	 * @param P_PROD_CODE
	 * @param P_AGE
	 * @param P_TERM
	 * @param P_SA
	 * @throws Exception
	 */
	public void F_validate_term(String P_PROD_CODE, Integer P_AGE,
			Integer P_TERM, Double P_SA) throws Exception {
		Connection connection = null;
		ResultSet rs1 = null;
		Object[] values = {};

		String query1 = "SELECT 1 FROM PM_IL_PROD_APPL_TERM  "
				+ "WHERE  PAT_PROD_CODE  = ? "
				+ "AND ? BETWEEN PAT_AGE_FM AND PAT_AGE_TO "
				+ "AND ? BETWEEN PAT_TERM_FM AND PAT_TERM_TO "
				+ "AND ? BETWEEN PAT_SA_FM AND PAT_SA_TO ";

		int M_RESULT = 0;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { P_PROD_CODE, P_AGE, P_TERM, P_SA };
			rs1 = handler.executeSelectStatement(query1, connection, values);
			if (rs1.next()) {
				M_RESULT = rs1.getInt(1);
			}

			if (M_RESULT != 1) {// OK
				throw new Exception(
						"Age,Term,Sum Assurred doesn't match with product");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void POL_ESC_YN_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN) {
		try {

			if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_ESC_YN())) {
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_CVR_ESC_PERC()
						.setDisabled(false);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_14().setDisabled(
						false);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_09().setDisabled(
						false);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_18().setDisabled(
						false);
				PT_IL_POLICY_BEAN.setPOL_CVR_ESC_PERC(3);
			} else {
				PT_IL_POLICY_BEAN.setPOL_CVR_ESC_PERC(0);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_CVR_ESC_PERC()
						.setDisabled(true);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_14()
						.setDisabled(true);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_09()
						.setDisabled(true);
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_18()
						.setDisabled(true);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void Applied_On_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN) {
		try {

			if ("N".equals(PT_IL_POLICY_BEAN.getPOL_FLEX_09())) {
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_18()
						.setDisabled(true);
			} else {
				PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_FLEX_18().setDisabled(
						false);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void POL_CVR_ESC_PERC_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY PT_IL_POLICY_BEAN) {
		try {

			if ("019".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
					.getPOL_END_TYPE(), "000"))) {
				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_CVR_ESC_PERC(), 0) > 0) {

				} else {
					throw new Exception(
							"Please Enter Valid Cover Escalation Percentage");

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



     public void checkFreeze(PT_IL_POLICY pt_il_policy_bean,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		String M_CLINIC = null;
		String M_STATUS = null;
		String M_BROCKER = "N";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		/*Added by saranya on 07-12-2016 for  RM018T - FSD_IL_ZB Life_013_Underwriting changes */
		String SHORT_TYP=null;
		Double SHORT_RATE=null;
		Double SHORT_RATE_PER=null;
		Double AGENT_FC_PREM=null;
		Double POL_FC_PREM=null;
		Double EXTRA_PREMIUM_VALUE=null;
		Double EXTRA_PREMIUM=null;
		AGENT_FC_PREM=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_AGENT_PREM();
		POL_FC_PREM=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_FIRST_PREM();
	/*	DecimalFormat myFormatter = new DecimalFormat("00.00");
		String POL_PREM_VALUE = myFormatter.format(Premium_value);
		Double POL_FC_PREM=Double.valueOf(POL_PREM_VALUE);*/
		System.out.println("Premium_value  :"+POL_FC_PREM);
		System.out.println("SHORT_TYP value in save method  :"+SHORT_TYP);
		/*End*/
		try {
			/*Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes*/ 
			String query = "SELECT PMOP_TOLL_TYP, PMOP_SHORT_RATE, PMOP_SHORT_RATE_PER FROM PM_IL_PLAN_MOP WHERE PMOP_PLAN_CODE = ? AND PMOP_TYPE=?";
			/*End*/
			/*
			 * query modified by Ameen on 17-05-2018 for medical waived status
			 * String C1 = " SELECT 'X' FROM  PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID =?  AND  "
					+ " PMED_CLINIC_CODE IS NULL AND   PMED_EXAM_CODE IS NOT NULL  AND   NVL(PMED_DEL_FLAG,'N') <> 'Y' ";*/
			
			String C1 = "SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND PMED_CLINIC_CODE IS NULL AND PMED_EXAM_CODE IS NOT NULL "
					+ "AND NVL(PMED_DEL_FLAG, 'N') <> 'Y' AND PMED_STATUS <>'NA'";

			String C2 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS,PM_IL_DOC_TODO_GROUP WHERE DTLS_MANDATORY_YN = 'Y' "
					+ "AND DTLS_APPR_STS = 'N' AND DTLS_POL_SYS_ID = ? AND PT_IL_DOC_TODO_LIST_STATUS.DTLS_GROUP_CODE = PM_IL_DOC_TODO_GROUP.DTG_GROUP_CODE "
					+ " AND PM_IL_DOC_TODO_GROUP.DTG_DS_CODE = ?  AND   PM_IL_DOC_TODO_GROUP.DTG_DS_TYPE = ? ";
			//added by shankar for broker detail issue
			String C3="SELECT 'X' FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ?";
            //end
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(C1, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			if (resultSet1.next()) {
				M_CLINIC = resultSet1.getString(1);
			}
/*Added by saranya on 07-12-2016 for  RM018T - FSD_IL_ZB Life_013_Underwriting changes */
			if((("1".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE()))||("2".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE())))
					&&(pt_il_policy_bean.getPOL_END_NO_IDX()==0)){
			System.out.println("Entered into Underwriting changes if Condition ");	
			
			/*Added by Ram on 13/03/2017 for Agent Premium Calculation for Customer wise*/
		 
			String agentPremChkQuery = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_AGPRM_MT'";
			ResultSet agentPremChkRS = handler.executeSelectStatement(agentPremChkQuery, connection);
			boolean agentPremChk = false; 
			int PS_VALUE = -1;
			while(agentPremChkRS.next())
			{
				PS_VALUE = agentPremChkRS.getInt(1);
				if(PS_VALUE == 1)
				{
					agentPremChk = true;	
				}
				
			}
			System.out.println("PS_VALUE         "+PS_VALUE);
			if(agentPremChk)
			{
			/*End*/ 
			/*KIC condition handled by Ameen on 26-03-2018 for agent prem. less thencalculated prem. error not to come in KIC*/
			/*if("075".equalsIgnoreCase(pt_il_policy_bean.getPOL_SRC_OF_BUS()) && !"KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")))*/
				if("075".equalsIgnoreCase(pt_il_policy_bean.getPOL_SRC_OF_BUS()) && !CommonUtils.isIN(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"), "KIC/","TOI/"))
				{
				resultSet4 = handler.executeSelectStatement(query, connection,
						new Object[] {pt_il_policy_bean.getPOL_PLAN_CODE(),pt_il_policy_bean.getPOL_MODE_OF_PYMT()});
				if (resultSet4.next()) {
					SHORT_TYP=resultSet4.getString("PMOP_TOLL_TYP");
					SHORT_RATE =resultSet4.getDouble("PMOP_SHORT_RATE");
					SHORT_RATE_PER= resultSet4.getDouble("PMOP_SHORT_RATE_PER");
					System.out.println("SHORT_TYP :"+SHORT_TYP);
					System.out.println("SHORT_RATE :"+SHORT_RATE);
					System.out.println("SHORT_RATE_PER :"+SHORT_RATE_PER);

				}
			/*	if(AGENT_FC_PREM>=POL_FC_PREM)
				{
					EXTRA_PREMIUM_VALUE=AGENT_FC_PREM-POL_FC_PREM;
				}else
				{*/
					EXTRA_PREMIUM_VALUE=AGENT_FC_PREM-POL_FC_PREM;
					DecimalFormat myFormatter = new DecimalFormat("###.00");
					String value = myFormatter.format(EXTRA_PREMIUM_VALUE);
					EXTRA_PREMIUM=Double.parseDouble(value);
				/*	NumberFormat formatter = NumberFormat.getInstance();
					//formatter.setMaximumFractionDigits(3);
					formatter.setMinimumFractionDigits(2);
					//System.out.println(fmtLocale.toLanguageTag());
					String X=String.valueOf(EXTRA_PREMIUM_VALUE);
					if ((X != null) && (Double.parseDouble(X) < 0.0D))
					{
						Double value=Double.parseDouble(X);
						System.out.println("assads"+formatter.format(value));
						EXTRA_PREMIUM=Double.parseDouble(formatter.format(value));
					}*/
				System.out.println("PREMIUM_VALUE  :"+EXTRA_PREMIUM);
			if("F".equalsIgnoreCase(SHORT_TYP))
				{
					System.out.println("inside fixed if 1 Agent prem value :"+ AGENT_FC_PREM  +"POL_FC_PREM["+POL_FC_PREM+"]");
					//SHORT_RATE=(-SHORT_RATE);
								/*	if(EXTRA_PREMIUM_VALUE>=SHORT_RATE)
									{
										compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Agent Premium and Policy First Premium Both are Equal. you can Proceed");
									}*/
								 if((EXTRA_PREMIUM>=-(SHORT_RATE)))
									{
									 /*Modified by saranya for ssp call id FSD_IL_ZB Life_013 on 08-02-2017*/
										compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Agent Premium ("+AGENT_FC_PREM+") and Policy First Premium ("+POL_FC_PREM+")requirements are met. Please proceed");
										/*End*/
									}
									else
									{
										throw new Exception(
												Messages
														.getString(
																PELConstants.pelErrorMessagePath,
																"3206",
																/*
																 * modified by Ameen on 17-07-2017 for ZBILQC-1731923
																 * new Object[] { "Your Agent premium ("+AGENT_FC_PREM+") and Policy First Premium ("+POL_FC_PREM+") are Not Equal. Please check then Proceed" }*/
																new Object[] { "Cannot Proceed as Agent Premium is less than the Calculated Premium" }));
										//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Your Agent premium and Policy First Premium are Not Equal. Please check then Proceed");
									}
				}else{
					Double SHORT_RATE_VALUE=SHORT_RATE_PER/100;
					System.out.println("inside Percentage else 1 Agent prem value :"+ AGENT_FC_PREM  +"POL_FC_PREM["+POL_FC_PREM+"]");
									if(EXTRA_PREMIUM>=-(SHORT_RATE*SHORT_RATE_VALUE))
									{
										 /*Modified by saranya for ssp call id FSD_IL_ZB Life_013 on 08-02-2017*/
										compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Agent Premium ("+AGENT_FC_PREM+") and Policy First Premium ("+POL_FC_PREM+") requirements are met. Please proceed");
										/*End*/
									}else
									{
										throw new Exception(
												Messages
														.getString(
																PELConstants.pelErrorMessagePath,
																"3206",
																/*
																 * modified by Ameen on 17-07-2017 for ZBILQC-1731923
																 * new Object[] { "Your Agent premium ("+AGENT_FC_PREM+") and Policy First Premium ("+POL_FC_PREM+") are Not Equal. Please check then Proceed" }*/
																new Object[] { "Cannot Aroceed as Agent Premium is less than the Calculated Premium" }));
										//getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Your Agent premium and Policy First Premium are Not Equal. Please check then Proceed");
									}
				}
			}
			
			}
			
			}
			/*end*/

			if (CommonUtils.nvl(M_CLINIC, "N").equals("X")) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Clinic code should be entered for medical examination details" }));
			}
			resultSet2 = handler.executeSelectStatement(C2, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
							pt_il_policy_bean.getPOL_DS_CODE(),
							pt_il_policy_bean.getPOL_DS_TYPE() });
			if (resultSet2.next()) {
				M_STATUS = resultSet2.getString(1);
			}
			if (CommonUtils.nvl(M_STATUS, "N").equals("X")) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Mandatory Checklist verification is pending." }));
			}
			
			//added by shankar for broker detail issue
			if("075".equalsIgnoreCase(pt_il_policy_bean.getPOL_SRC_OF_BUS())){
			resultSet3 = handler.executeSelectStatement(C3, connection,
					new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
			if (resultSet3.next()) {
				M_BROCKER = resultSet3.getString(1);
			}
			if (!"X".equalsIgnoreCase(M_BROCKER)) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Agent / Broker details not available. Cannot proceed." }));
			}
			
			
			}
			//end
			
			/*added by raja on 24-04-2017*/
			int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BRKR_SHAR")).intValue();
			if(shareRatioSystemParam == 1){
				Double UI_M_SUM_POBH_SHARE_PERC = 0.0 ;
			if (compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getDataList_PT_IL_POL_BROKER_HEAD().size()!= 0) {
				//Added to check share Ratio percentage during save
				for(PT_IL_POL_BROKER_HEAD  obj: compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getDataList_PT_IL_POL_BROKER_HEAD()) {
					if(obj.getPOBH_SRNO()==1){
						Double value=CommonUtils.nvl(obj.getPOBH_SHARE_PERC(), 0);
						UI_M_SUM_POBH_SHARE_PERC = UI_M_SUM_POBH_SHARE_PERC +value;
					}
				}
				if(UI_M_SUM_POBH_SHARE_PERC != null){
					if (!(UI_M_SUM_POBH_SHARE_PERC == 100.00)){
						throw new Exception("Total Broker Share Ratio % Should be 100%");
					}
				}
			}
			}
			/*end*/

		} catch (Exception e) {
			e.printStackTrace();
			// compositeAction.getWizard().setImmediate("true");
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			CommonUtils.closeCursor(resultSet3);

		}
	}
	public Boolean enableDisablePremiumcalc(PT_IL_POLICY pt_il_policy_bean)
			throws Exception {
		try {

			boolean chkflag = false;
			Connection connection = null;
			Object[] values = {};
			ResultSet rs1 = null;
			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			String ass_id = null;
			connection = CommonUtils.getConnection();

			String C1 = "SELECT POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
			rs1 = handler.executeSelectStatement(C1, connection, values);
			if (rs1.next()) {
				ass_id = rs1.getString(1);

			}
			System.out.println("ass_id         "+ass_id+"      "+pt_il_policy_bean.getPOL_SYS_ID());
			if (ass_id != null) {
				chkflag = true;
			}
			return chkflag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void enabledisableJointlife(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			Connection con = null;
			Object[] values = {};
			ResultSet rs1 = null;

			String M_PROD_JOINT_LIFE_YN = null;
			con = CommonUtils.getConnection();

			String query5 = " SELECT PROD_JOINT_LIFE_YN FROM   PM_IL_PRODUCT  WHERE "
					+ " PROD_CODE = ? ";

			if (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() == null) {
				compositeAction
						.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN()
						.setPOL_PROD_CODE(
								(CommonUtils
										.getGlobalVariable("GLOBAL.M_PARAM_6")));
				values = new Object[] { compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_PROD_CODE() };
			} else {
				values = new Object[] { compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_PROD_CODE() };
			}

			rs1 = new CRUDHandler().executeSelectStatement(query5, con, values);

			while (rs1.next()) {
				M_PROD_JOINT_LIFE_YN = rs1.getString(1);

			}
			if ("Y".equals(M_PROD_JOINT_LIFE_YN)) {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().setPOL_JOINT_LIFE_YN("Y");
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_JOINT_LIFE_YN().setDisabled(false);
				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");

			} else {

				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().setPOL_JOINT_LIFE_YN("N");
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1");
				compositeAction.getWizard().disableWizardItem(
						"PILT002_APAC_PT_IL_POL_MED_EXAM_DTL_1");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}

	// Newly added to update the threshold value

	public void updateThresholdLimit(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String updateQuery = "UPDATE PT_IL_POL_ASSURED_DTLS SET POAD_FC_SUM_ASSURED = ?,"
				+ "POAD_LC_SUM_ASSURED = ?,POAD_LC_THRESHOLD_LMT = ? WHERE POAD_POL_SYS_ID = ? AND POAD_TYPE='R'  ";
		try {
			connection = CommonUtils.getConnection();
			int i = handler.executeUpdateStatement(updateQuery, connection,
					new Object[] {
							PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED(),
							PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED(),
							PT_IL_POL_ASSURED_DTLS_BEAN
									.getPOAD_LC_THRESHOLD_LMT(),
							PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			System.out.println(i + " rows upadated");
			/*Added by saritha on 05-Aug-2017 for ssp call id ZBILQC-1733319*/
			CommonUtils.getConnection().commit();
			/*End*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void chkPolPeriodAftrEndo(PT_IL_POLICY PT_IL_POLICY_BEAN)
			throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT PROD_PERIOD FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		Integer prodperiod = 0;
		String prodcode = PT_IL_POLICY_BEAN.getPOL_PROD_CODE();
		value = new Object[] { prodcode };
		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection, value);

			if (rs.next()) {
				prodperiod = rs.getInt(1);

				/*Modifed by Raja on 27/03/2017
				 * 
				 * if (prodperiod < (PT_IL_POLICY_BEAN.getPOL_PERIOD() + CommonUtils
				.nvl(PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD(), 0))) {
			throw new Exception(
					"The period should not be greater than  "
							+ (prodperiod - PT_IL_POLICY_BEAN
									.getPOL_ORG_PERIOD()));
		}*/
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void chkMaturityAge(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		String query = " SELECT PLAN_MAX_AGE_ON_MAT FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		Integer matruityAge = 0;
		String plancode = PT_IL_POLICY_BEAN.getPOL_PLAN_CODE();
		value = new Object[] { plancode };
		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection, value);

			if (rs.next()) {
				matruityAge = rs.getInt(1);
				if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
					if (matruityAge < (PT_IL_POLICY_BEAN.getPOL_PERIOD() + CommonUtils
							.nvl(PT_IL_POLICY_BEAN.getUI_M_MAT_AGE(), 0))) {
						throw new Exception(
								"The Maturity Age should not be greater than "
										+ matruityAge);
					}
				} else if (compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE() != null) {
					if (matruityAge < (PT_IL_POLICY_BEAN.getPOL_PERIOD() + compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE())) {
						throw new Exception(
								"The Maturity Age should not be greater than "
										+ matruityAge);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void thresholdLimitAdding(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double value)
			throws Exception {
		String M_VALUE = null;
		String M_CODE_DESC = null;
		Double changedValue = null;
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		if (PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED() != null) {
			changedValue = value - PT_IL_POLICY_BEAN.getPOL_FC_SUM_ASSURED();
		} else {
			changedValue = value;
		}
		ArrayList<String> list = new ArrayList<String>();
		try {
			list = DBProcedures.P_VAL_SYSTEM("IL_TLMT_MTHD", "IL_TLMT_MTHD",
					M_CODE_DESC, "E", M_VALUE);
			M_CODE_DESC = list.get(0);
			M_VALUE = list.get(1);
			Double L_GET_THRESHOLD_LIMIT_VAL = null;
			L_GET_THRESHOLD_LIMIT_VAL = new PT_IL_POL_ASSURED_DTLS_HELPER()
					.L_GET_THRESHOLD_LIMIT(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN(),
							PT_IL_POLICY_BEAN, compositeAction
									.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			if ("1".equals(M_VALUE)) {
				if ("P".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG())) {
					if (!(value.equals(PT_IL_POLICY_BEAN
							.getPOL_FC_SUM_ASSURED()))) {
						PT_IL_POL_ASSURED_DTLS_BEAN
								.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
										L_GET_THRESHOLD_LIMIT_VAL, 0)
										+ changedValue);
					} else {
						PT_IL_POL_ASSURED_DTLS_BEAN
								.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
										L_GET_THRESHOLD_LIMIT_VAL, 0));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void thresholdLimitAddingForUlip(PT_IL_POLICY PT_IL_POLICY_BEAN,
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Double currValue,
			Double prevVlaue) throws Exception {
		String M_VALUE = null;
		String M_CODE_DESC = null;
		Double changedValue = null;
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		if (prevVlaue != null) {
			changedValue = currValue - prevVlaue;
		} else {
			changedValue = currValue;
		}
		ArrayList<String> list = new ArrayList<String>();
		try {
			list = DBProcedures.P_VAL_SYSTEM("IL_TLMT_MTHD", "IL_TLMT_MTHD",
					M_CODE_DESC, "E", M_VALUE);
			M_CODE_DESC = list.get(0);
			M_VALUE = list.get(1);
			Double L_GET_THRESHOLD_LIMIT_VAL = null;
			L_GET_THRESHOLD_LIMIT_VAL = new PT_IL_POL_ASSURED_DTLS_HELPER()
					.L_GET_THRESHOLD_LIMIT(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN(),
							PT_IL_POLICY_BEAN, compositeAction
									.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			if ("1".equals(M_VALUE)) {
				if ("P".equals(PT_IL_POLICY_BEAN.getPOL_PROP_QUOT_FLAG())) {
					if (!(currValue.equals(prevVlaue))) {
						PT_IL_POL_ASSURED_DTLS_BEAN
								.setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
										L_GET_THRESHOLD_LIMIT_VAL, 0)
										+ changedValue);
					}
					/*
					 * } else { PT_IL_POL_ASSURED_DTLS_BEAN
					 * .setPOAD_LC_THRESHOLD_LMT(CommonUtils.nvl(
					 * L_GET_THRESHOLD_LIMIT_VAL, 0)); }
					 */
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	/*Modified by saranya for Unit Link Product as per Suggessted by Girish on 13/02/2017*/
	public void chkNo_of_units(PT_IL_POLICY PT_IL_POLICY_BEAN) throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		ResultSet rs1= null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		String query = " SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		String query1="SELECT PROD_RISK_FACTOR_YN FROM PM_IL_PRODUCT WHERE PROD_CODE =?";
		String M_plantype = null;
		String M_RISK_FACTOR_YN = null;
		double no_of_units = 0.0;
		String plancode = PT_IL_POLICY_BEAN.getPOL_PLAN_CODE();
		value = new Object[] { plancode };
		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection, value);
			rs1 = handler.executeSelectStatement(query1, connection, value);
			if (rs1.next()) {
				M_RISK_FACTOR_YN = rs1.getString(1);
			}
			if (rs.next()) {
				M_plantype = rs.getString(1);
			}
			if ("U".equalsIgnoreCase(M_plantype)) {
			  if("Y".equalsIgnoreCase(M_RISK_FACTOR_YN)){
				if (PT_IL_POLICY_BEAN.getPOL_PERIOD() != null) {
					no_of_units = PT_IL_POLICY_BEAN.getPOL_PERIOD();
					PT_IL_POLICY_BEAN.setPOL_NO_OF_UNIT(no_of_units);
				}
			}else{
					PT_IL_POLICY_BEAN.setPOL_NO_OF_UNIT(0.0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	/*End*/

	public void checkSA(PT_IL_POLICY PT_IL_POLICY_BEAN) throws Exception {
		double M_FC_SA = 0;
if(CommonUtils.getGlobalObject("M_FC_SA")!=null){
		 M_FC_SA = (Double) CommonUtils.getGlobalObject("M_FC_SA");
}
		double M_CVR_MIN_SA = CommonUtils.nvl((Double) CommonUtils
				.getGlobalObject("M_CVR_MIN_SA"),0.0);
		double M_CVR_MAX_SA =  CommonUtils.nvl((Double) CommonUtils
				.getGlobalObject("M_CVR_MAX_SA"),0.0);

		if (!("002".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE()))) {
			if ((M_FC_SA < M_CVR_MIN_SA) || (M_FC_SA > M_CVR_MAX_SA)) {
				String CVR_MAX_SA = (BigDecimal.valueOf(M_CVR_MAX_SA)
						.toPlainString());
			/*Commented by saranya nas per the Girish Suggessted for Unit link product on 13-02-2017*/
			/*	throw new Exception(" Sum Assured Should be between "
						+ M_CVR_MIN_SA + " and " + CVR_MAX_SA);*/
			}
		}
	}

	public void IL_WAIT_DAYS(PT_IL_POLICY PT_IL_POLICY_BEAN) throws Exception {

		String C1 = "SELECT PD_PAY_MODE,DEP_DOC_DT FROM PT_IL_PYMT_DTLS,PT_IL_DEPOSIT A,"
				+ "PP_SYSTEM WHERE DEP_REF_NO=DECODE(DEP_TYPE,'Q',NVL(:PT_IL_POLICY.POL_PROP_NO,:PT_IL_POLICY.POL_NO),'P',:PT_IL_POLICY.POL_NO)"
				+ "AND DEP_SYS_ID =PD_TXN_SYS_ID"
				+ " AND PD_TXN_TYPE IN('QD','PD')"
				+ "AND DEP_DOC_NO IS NOT NULL"
				+ "AND DEP_TXN_CODE  IS NOT NULL"
				+ "AND NVL(DEP_REC_REV_YN,'N') ='N'"
				+ "AND PS_TYPE = 'IL_WAIT_DAYS'"
				+ "AND PS_CODE =  PD_PAY_MODE"
				+ "ORDER BY DEP_SYS_ID  ASC";

		String C2 = "SELECT PS_VALUE FROM PP_SYSTEM"
				+ "WHERE PS_TYPE = 'IL_WAIT_DAYS'"
				+ "AND PS_CODE =M_PD_PAY_MODE ";

		String M_PD_PAY_MODE = null;
		Integer M_DAYS = null;
		Date M_DEP_DOC_DT = null;
		Date M_POL_APPRV_CHK_DT = null;
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_PROP_NO(),
					PT_IL_POLICY_BEAN.getPOL_NO() });
			if (rs.next()) {
				M_PD_PAY_MODE = rs.getString(1);
				M_DEP_DOC_DT = rs.getDate(2);
				/*
				 * throw new Exception(Messages.getString(
				 * PELConstants.pelErrorMessagePath, "3206", new Object[] {
				 * CommonUtils .getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				 */
				// STD_MESSAGE_ROUTINE(3206,NAME_IN('GLOBAL.M_LANG_CODE'),'Proposal
				// is paid by check. For check verification with TMD');
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	public void P_REINS_REDATE_VAL(PT_IL_POLICY PT_IL_POLICY_BEAN)
			throws Exception {

		String M_MIB_DUMMY = null;
		String M_PROD_AGE_CALC_FLAG = null;
		Integer M_AGE = null;
		String M_PS_TYPE = null;
		String M_PLAN_AGE_TO = null;
		Connection con = null;
		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null;
		CRUDHandler handler = new CRUDHandler();

		String C1 = " SELECT DS_END_TYPE FROM   PM_IL_DOC_SETUP"
				+ "   WHERE  DS_TYPE = '3'" + " AND    DS_FRZ_FLAG = 'N'"
				+ " AND    DS_CODE = ?";

		String C2 = "SELECT 'X' FROM  PT_IL_MIB_DTLS, PM_CUSTOMER"
				+ " WHERE CUST_CODE = ?" + " AND   MID_NAME  =  CUST_NAME"
				+ " AND   MID_DOB   =  CUST_DOB";

		String C3 = "SELECT PROD_AGE_CALC_FLAG FROM   PM_IL_PRODUCT"
				+ " WHERE  PROD_CODE = ?";

		String C4 = "SELECT PS_TYPE FROM PP_SYSTEM" + " WHERE PS_CODE =?";

		String C5 = "SELECT PLAN_AGE_TO FROM   PM_IL_PLAN"
				+ "  WHERE  PLAN_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			rs4 = handler.executeSelectStatement(C4, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_END_CODE() });
			if (rs4.next()) {
				M_PS_TYPE = rs4.getString(1);
			}

			if (("L".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS()) || "R"
					.equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS()))
					&& (!"ILCHNGADDR".equalsIgnoreCase(M_PS_TYPE))
					&& ("006".equalsIgnoreCase(CommonUtils.nvl(
							PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000")) || "020"
							.equalsIgnoreCase(CommonUtils.nvl(PT_IL_POLICY_BEAN
									.getPOL_END_TYPE(), "000")))) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] {
												CommonUtils.getControlBean()
														.getM_LANG_CODE(),
												"Only change of Address endorsement is allowed for Lapsed/QPU policies" }));
				// STD_MESSAGE_ROUTINE(3206, :CTRL.M_LANG_CODE, 'Only change of
				// Address endorsement is allowed for Lapsed/QPU policies');
			}
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_END_CODE() });
			if (rs1.next()) {
				PT_IL_POLICY_BEAN.setPOL_END_TYPE(rs1.getString(1));
			}
			if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000")
					.equalsIgnoreCase("006")
					|| CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(),
							"000").equalsIgnoreCase("020")) {
				rs3 = handler.executeSelectStatement(C3, con,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
				if (rs3.next()) {
					M_PROD_AGE_CALC_FLAG = rs3.getString(1);
				}
				rs5 = handler.executeSelectStatement(C3, con,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
				if (rs5.next()) {
					M_PLAN_AGE_TO = rs5.getString(1);
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * newly added by sujatha to update the pol prem yrs directly to table in
	 * case of alterm endo
	 */
	public void updatePolPremYrsToTable(PT_IL_POLICY PT_IL_POLICY_BEAN)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1 = "UPDATE PT_IL_POLICY SET POL_PREM_PAY_YRS = ? WHERE POL_SYS_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			handler.executeUpdateStatement(C1, connection, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_PREM_PAY_YRS(),
					PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			CommonUtils.getConnection().commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void disableMortageTabs(PT_IL_POLICY_ACTION pt_il_policy_action) {
		PT_IL_POLICY policyBean = pt_il_policy_action.getPT_IL_POLICY_BEAN();
		String planCode = policyBean.getPOL_PLAN_CODE();
		String query = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		String planType = null;
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { planCode });
			if (resultSet.next()) {
				planType = resultSet.getString("PLAN_TYPE");
			}
			if ("M".equalsIgnoreCase(planType)) {
				pt_il_policy_action.getCOMP_MORE_INFO_2().setRendered(true);
				pt_il_policy_action.getCOMP_MORE_INFO_3().setRendered(true);
			} else {
				pt_il_policy_action.getCOMP_MORE_INFO_2().setRendered(false);
				pt_il_policy_action.getCOMP_MORE_INFO_3().setRendered(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void specialRevivalCheck(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String query1 = "  SELECT ADD_MONTHS(ADD_MONTHS( ? ," + " ? * 12),"
				+ " DECODE(?,'Y', -12, 'H', -6, 'Q', -3, 'M', -1))"
				+ " FROM   DUAL ";

		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query1, connection,
					new Object[] { policyBean.getPOL_FIRST_INST_DT(),
							policyBean.getPOL_PREM_PAY_YRS(),
							policyBean.getPOL_MODE_OF_PYMT() });

			if (resultSet.next()) {
				policyBean.setPOL_LAST_INST_DT(resultSet.getDate(1));
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	public void ChkPrdAgeSetup(PT_IL_POLICY PT_IL_POLICY_BEAN) throws Exception {
		String C1 = "SELECT PLAN_AGE_TERM_FLAG FROM PM_IL_PLAN WHERE PLAN_CODE=?";
		String C5 ="SELECT CUST_CATG_CODE FROM PM_CUSTOMER WHERE CUST_CODE =? ";
		String C2 = "SELECT PAS_MIN_PERIOD, PAS_MAX_PERIOD FROM PM_IL_PLAN_AGE_SETUP,PM_IL_PLAN WHERE PAS_PLAN_CODE = PLAN_CODE AND PLAN_AGE_TERM_FLAG='S'AND  ? BETWEEN PAS_CATG_FM_CODE AND PAS_CATG_TO_CODE AND PAS_PLAN_CODE = ? AND PAS_AGE_BASIS = DECODE(?,'N','R','E')";
		String C3 = "SELECT 'X' FROM PM_IL_PLAN_AGE_SETUP,PM_IL_PLAN WHERE PAS_PLAN_CODE = PLAN_CODE AND PLAN_AGE_TERM_FLAG='S' AND ? BETWEEN PAS_CATG_FM_CODE AND PAS_CATG_TO_CODE  AND PAS_PLAN_CODE = ?  AND PAS_AGE_BASIS = DECODE(?,'N','R','E')";
		String plan_term_flg = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet5 = null;
		Double M_PROD_PERIOD_MULTIPLE = null;
		String cat_code =null;
		Integer minprd = 0;
		Integer maxprd = 0;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {PT_IL_POLICY_BEAN.getPOL_PROD_CODE() });
			while (resultSet.next()) {
				plan_term_flg = resultSet.getString(1);
			}
			if ("S".equalsIgnoreCase(plan_term_flg)) {
				resultSet5 = handler.executeSelectStatement(C5, connection,
						new Object[]{PT_IL_POLICY_BEAN.getPOL_CUST_CODE()}	);{
					if(resultSet5.next()){
					cat_code = resultSet5.getString(1);
					}		
						}
						Object[] values = new Object[] {cat_code,PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
								PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN() };
				resultSet3 = handler.executeSelectStatement(C3, connection,
						values);
				if (!resultSet3.next()) {
					throw new Exception(
							"Setup not found in PlanMaster Agesetup");
				}

				resultSet1 = handler.executeSelectStatement(C2, connection,
						values);
				while (resultSet1.next()) {
					minprd = resultSet1.getInt(1);
					maxprd = resultSet1.getInt(2);

					if ((minprd > PT_IL_POLICY_BEAN.getPOL_PERIOD())
							|| (maxprd < PT_IL_POLICY_BEAN.getPOL_PERIOD())) {
						throw new Exception("Policy period must be between "
								+ minprd + " and " + maxprd);
					}
				}
				/*
				 * while(resultSet3.next()){ M_PROD_PERIOD_MULTIPLE
				 * =resultSet3.getDouble(1); }
				 * if((PT_IL_POLICY_BEAN.getPOL_PERIOD() %
				 * M_PROD_PERIOD_MULTIPLE) != 0){ throw new Exception("Policy
				 * Period should be a multiple of "+M_PROD_PERIOD_MULTIPLE); }
				 */

			}

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	public void checkMaxAgeOnMaturity(PT_IL_POLICY PT_IL_POLICY_BEAN,
			Integer currValue) throws Exception {
		String C1 = "SELECT PLAN_AGE_TERM_FLAG FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		String C2 = "SELECT PLAN_MIN_AGE_ON_MAT,PLAN_MAX_AGE_ON_MAT FROM PM_IL_PLAN  WHERE PLAN_CODE = ?";
		String C3 = "SELECT PAS_MIN_AGE_ON_MAT,PAS_MAX_AGE_ON_MAT FROM PM_IL_PLAN_AGE_SETUP WHERE PAS_PLAN_CODE = ? AND PAS_AGE_BASIS= DECODE(?,'N','R','E')";
		String M_PLAN_AGE_TERM_FLAG = null;
		int M_MIN_AGE_ON_MAT = 0;
		int M_MAX_AGE_ON_MAT = 0;
		int PMA_MAT_MIN_PAYER_AGE = 0;
		int PMA_MAT_MAX_PAYER_AGE = 0;
		int M_CAL_AGE = 0;
		try {
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			ResultSet rs1 = null, rs2 = null, rs3 = null;
			rs1 = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
			if (rs1.next()) {
				M_PLAN_AGE_TERM_FLAG = rs1.getString(1);
			}
			if ("H".equalsIgnoreCase(M_PLAN_AGE_TERM_FLAG)) {
				rs2 = handler.executeSelectStatement(C2, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE() });
				while (rs2.next()) {
					M_MIN_AGE_ON_MAT = rs2.getInt(1);
					M_MAX_AGE_ON_MAT = rs2.getInt(2);
				}

				M_CAL_AGE = currValue
						+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
				if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_END_TYPE())) {
					
					if(PT_IL_POLICY_BEAN.getPOL_ENDO_PARAM()==1)
					{
					M_CAL_AGE = PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD()
							+ currValue
							+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
					}
					else
					{
						M_CAL_AGE = currValue
								+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
					}
				}
				if (M_CAL_AGE > M_MAX_AGE_ON_MAT
						|| M_CAL_AGE < M_MIN_AGE_ON_MAT) {
					throw new Exception("Age + PolicyPeriod " + M_CAL_AGE
							+ " should be <= " + M_MAX_AGE_ON_MAT + " and  >= "
							+ M_MIN_AGE_ON_MAT);
				}
			} else {
				rs3 = handler.executeSelectStatement(C3, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_PLAN_CODE(),
								PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN() });
				while (rs3.next()) {
					PMA_MAT_MIN_PAYER_AGE = rs3.getInt(1);
					PMA_MAT_MAX_PAYER_AGE = rs3.getInt(2);
				}
				if ("N".equalsIgnoreCase(PT_IL_POLICY_BEAN
						.getPOL_JOINT_LIFE_YN())) {
					M_CAL_AGE = currValue
							+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
					if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN
							.getPOL_END_TYPE())) {
						
						if(PT_IL_POLICY_BEAN.getPOL_ENDO_PARAM()==1)
						{
						
						M_CAL_AGE = currValue
								+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
						}
						else
						{
							M_CAL_AGE = PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD()
									+ currValue
									+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
						}
					}
					if (M_CAL_AGE > PMA_MAT_MAX_PAYER_AGE
							|| M_CAL_AGE < PMA_MAT_MIN_PAYER_AGE) {
						throw new Exception("Age + PolicyPeriod " + M_CAL_AGE
								+ " should be <= " + PMA_MAT_MAX_PAYER_AGE
								+ " and  >= " + PMA_MAT_MIN_PAYER_AGE);
					}
				} else {
					M_CAL_AGE = currValue
							+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
					if ("012".equalsIgnoreCase(PT_IL_POLICY_BEAN
							.getPOL_END_TYPE())) {
						if(PT_IL_POLICY_BEAN.getPOL_ENDO_PARAM()==1)
						{
						M_CAL_AGE = currValue
								+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
						}
						else
						{
							M_CAL_AGE = PT_IL_POLICY_BEAN.getPOL_ORG_PERIOD()
									+ currValue
									+ PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_AGE();
						}
					}
					if (M_CAL_AGE > PMA_MAT_MAX_PAYER_AGE
							|| M_CAL_AGE < PMA_MAT_MIN_PAYER_AGE) {
						throw new Exception("Age + PolicyPeriod " + M_CAL_AGE
								+ " should be <= " + PMA_MAT_MAX_PAYER_AGE
								+ " and  >= " + PMA_MAT_MIN_PAYER_AGE);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/*added by janani on 10.2.2016*/

	public void POL_PREM_OPTION_WHEN_VALIDATE_ITEM(
			PT_IL_POLICY pt_il_policy_bean, String currValue) throws Exception {
		ArrayList<String> pValList = new ArrayList<String>();
		try {

			if (currValue != null) {
				pValList = pkg_pilt002_apac.P_VAL_CONT_CODE(currValue,
						pt_il_policy_bean.getUI_M_CONT_NAME(),
						PILT002_APAC_CONSTANTS.P_ERR_FLAG);
				pt_il_policy_bean.setUI_M_CONT_NAME(pValList.get(0));
			} else {
				pt_il_policy_bean.setUI_M_CONT_NAME(null);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	/*END*/
	
	
	public static void main(String[] args) {
		try {
			System.out.println(CommonUtils.getDate(CommonUtils.addDaysToDate(new CommonUtils().getCurrentDate(),
					0 - 200)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void POL_END_DESC_WHEN_VALIDATE_ITEM(PT_IL_POLICY pt_IL_POLICY_BEAN) {
		// TODO Auto-generated method stub
		
	}
	
	//added by saranya for Endosment issue ssp call id FALCONQC-1716236
	 public void P_VALIDATE_END_EFF_DT(String POL_SYS_ID,String POL_END_DT,String POL_END_TYPE) throws ProcedureException
	 {
		 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
			 System.out.println("Enter into  Endos dt validation");
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
            OracleParameter param1 = new OracleParameter("IN1", "LONG", "IN",POL_SYS_ID);
            parameterList.add(param1);
            OracleParameter param2 = new OracleParameter("IN2", "DATE", "IN",POL_END_DT);
            parameterList.add(param2);
            OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",POL_END_TYPE);
            parameterList.add(param3);
            OracleProcedureHandler procHandler = new OracleProcedureHandler();
            outputList = procHandler.execute(parameterList, connection,
                   "PKG_PILT002_APAC.P_VALIDATE_END_EFF_DT");
            CommonUtils.getConnection().commit();
         /*   Iterator<OracleParameter> iterator = outputList.iterator();
            while (iterator.hasNext()) {
                OracleParameter oracleParameter = iterator.next();
                System.out.println("Output value:::" + oracleParameter.getValue());
            } */  	
         } catch(Exception e) {
         	ErrorHelpUtil.getErrorForProcedure(connection);
                throw new ProcedureException(e.getMessage());
         }
        //return outputList;
    }
	 
  //End
	 /*Added by saritha on 09-Dec-2016 RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
		public boolean checkmedicalstatus(PILT002_APAC_COMPOSITE_ACTION compositeAction)
				throws Exception {
			boolean pmedical_status = false;

			PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
					.getPT_IL_POLICY_ACTION_BEAN();
			PT_IL_POLICY pt_il_policy_bean = pt_il_policy_action
					.getPT_IL_POLICY_BEAN();
			Connection connection = null;
			ResultSet rs2 = null;
			String medical_status=null;
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			try {
				System.out.println("Policy sysid::::::::::::::::::"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				System.out.println("Policy End_no_idx:::::::::::::"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX());
				String query2 = "SELECT PMED_STATUS FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID= ? AND PMED_END_NO_IDX = ?";
				rs2 = handler.executeSelectStatement(query2, connection,
						new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()});
				while (rs2.next()) {
					medical_status = rs2.getString(1);
					System.out.println("Medical status*******************"+medical_status);
					if (medical_status.equalsIgnoreCase("n")) {
						pmedical_status = true;
						break;
					} else {
						pmedical_status = false;
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				try {
					CommonUtils.closeCursor(rs2);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			return pmedical_status;
		}

			/*End*/
	 
	 /*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	 
	 	public void POL_LAPS_OVR_YN_WHEN_VALIDATE_ITEM(
			 PILT002_APAC_COMPOSITE_ACTION compositeAction,String value)
					 throws Exception {
		 
		 PT_IL_POLICY pt_il_policy_bean = compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		 
		 PT_IL_POLICY_ACTION policyAction = compositeAction
					.getPT_IL_POLICY_ACTION_BEAN();
		
		 CRUDHandler handler = new CRUDHandler();
		 Connection connection = CommonUtils.getConnection();
		 Date sysDate = new CommonUtils().getCurrentDate();
		 ResultSet rs1 = null; 
		 String ASD_CHAR_VALUE=" ";
		 String C1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =?  AND" +
					" ASD_CODE = 'POL_LAPS_OVD' AND " +
					" ? BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE";
		 
		 try {
			 
			 if ("N".equals(pt_il_policy_bean.getPOL_LAPS_OVR_YN())){
					 policyAction.getCOMP_POL_LAPS_OVR_DT()
					 .setDisabled(true); 
					 pt_il_policy_bean.setPOL_LAPS_OVR_TO_DT(null);
					 policyAction.getCOMP_POL_LAPS_OVR_DT().resetValue();
					 policyAction.getCOMP_POL_LAPS_OVR_FRM_DT()
					 .setDisabled(true);
					 pt_il_policy_bean.setPOL_LAPS_OVR_FRM_DT(null);
					 policyAction.getCOMP_POL_LAPS_OVR_FRM_DT().resetValue();
					 policyAction.getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(false);
					 policyAction.getCOMP_POL_LAPS_OVR_DT().setRequired(false);
			 }
			 
			 
			 else if ("Y".equals(pt_il_policy_bean.getPOL_LAPS_OVR_YN())){
				 pt_il_policy_bean.setPOL_LAPS_OVR_FRM_DT(new CommonUtils()
				 .getCurrentDate());
				 System.out.println("current date:::::::::::::::"+new CommonUtils().getCurrentDate());
				 policyAction.getCOMP_POL_LAPS_OVR_DT()
				 .setDisabled(false);
				 policyAction.getCOMP_POL_LAPS_OVR_FRM_DT()
				 .setDisabled(false);	
				 policyAction.getCOMP_POL_LAPS_OVR_FRM_DT().setRequired(true);
				 policyAction.getCOMP_POL_LAPS_OVR_DT().setRequired(true);

			 } 
			 
			 String Userid=CommonUtils
					 .getGlobalVariable("GLOBAL.M_USER_ID");
			 String Productcode=policyAction.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
			 System.out.println("User Id*************"+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			 rs1 = handler.executeSelectStatement(C1, connection,
					 new Object[] { Userid,Productcode});
			 System.out.println("User id:::::"+Userid);
			 System.out.println("Product Code:::::"+Productcode);
			 if (rs1.next()) {
				 ASD_CHAR_VALUE = rs1.getString(1);
				 System.out.println("ASD_CHAR_VALUE::::::::::::::::::::::::"+ASD_CHAR_VALUE);
			 }

			 if("Y".equalsIgnoreCase(ASD_CHAR_VALUE)){

				 policyAction.getCOMP_POL_LAPS_OVR_YN()
				 .setDisabled(false);
				 
			 }
			 else if("N".equalsIgnoreCase(ASD_CHAR_VALUE)){
				 
				 throw new Exception(
						 "The User doesn't have privilege");
			 }
				
		
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new Exception(e.getMessage());
		 }

	 	}
	 	
	 	/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/

	 	public void POL_LAPS_OVR_DT_WHEN_VALIDATE_ITEM(
	 			PILT002_APAC_COMPOSITE_ACTION compositeAction,Date value)
	 					throws Exception {

	 		PT_IL_POLICY pt_il_policy_bean = compositeAction
	 				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

	 		Date sysDate = new CommonUtils().getCurrentDate();
	 		try
	 		{
	 			
	 			if(pt_il_policy_bean.getPOL_LAPS_OVR_TO_DT().before(sysDate)) {
	 				throw new Exception(
	 						"Back date not allowed");
	 			}

	 		}catch (Exception e) {
	 			e.printStackTrace();
	 			throw new Exception(e.getMessage());
	 		}

	 	}	
	 	
	 	/*End*/

	 	
	 	public void memberEndosement(PILT002_APAC_COMPOSITE_ACTION compositeAction)
		{
			try{
				PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN();
				Connection connection=CommonUtils.getConnection();
				if("N".equalsIgnoreCase(policyBean.getPOL_APPRV_STATUS() )&& ("002".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),"000"))))
						{
					/*compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(false);
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setINSERT_ALLOWED(true);
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setUPDATE_ALLOWED(true);
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setDELETE_ALLOWED(true);
						}*/
				// added by raja on 04-01-2017
				
				String query5 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE ='IL_INC_SA'";
				String M_PS_CODE_3=null;
				ResultSet rs5 = null;
				
				String query6 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE ='IL_DEC_SA'";
				String M_PS_CODE_4=null;
				ResultSet rs6 = null;
								
				/*end*/


		// added by raja
					
					rs5 = handler.executeSelectStatement(query5, connection);
					if (rs5.next()) {
						M_PS_CODE_3 = rs5.getString(1);
					}
					if ("002".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))
							&& M_PS_CODE_3
							.equals(policyBean.getPOL_END_CODE())) {
						
						compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(false);
							
					}
					
					
					rs6 = handler.executeSelectStatement(query6, connection);
					if (rs6.next()) {
						M_PS_CODE_4 = rs6.getString(1);
					}
					if ("002".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))	&& M_PS_CODE_4.equals(policyBean.getPOL_END_CODE())) {
						
						compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(false);
								
					}
					/*end*/
						}
				if( "012".equalsIgnoreCase(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),"000")) )
				{
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().disableAllComponents(false);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		/* Added by saranya for ssp call ZBILQC-1718566 on 19-01-2017*/
		String M_SYS_PARAM = null;
		Date M_POL_START_DT=null;
		
		public String start_dt_sys_pram(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
			PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN();
			Connection connection = null;
			ResultSet rs = null;

			String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='IL_POL_ST_DT'";
			try {
				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query, connection,
						new Object[] {});
				if(rs.next()) {
					M_SYS_PARAM = rs.getString(1);
					System.out.println("M_SYS_PARAM  :"+M_SYS_PARAM);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} 
			return M_SYS_PARAM;
		}
		
		public Date Trunc_st_dt(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
			PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN();
			Connection connection = null;
			ResultSet rs = null;
			String query = "SELECT trunc(?,'MONTH') FROM DUAL";
			try {
				connection = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query, connection,
						new Object[] { policyBean.getPOL_ISSUE_DT()});
				if(rs.next()) {
					M_POL_START_DT = rs.getDate(1);
					System.out.println("M_POL_START_DT  :"+M_POL_START_DT);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return M_POL_START_DT;
		}
		/*End*/
		
		/*Commented by ganesh on 10-08-2017, to avoid null issue on changing freeze flag */
		/*Added bys saritha on 08-Jun-2017 for ssp call id ZBILQC-1721836*/
		/*public String businessModalPanel() {
			 try {
				 
				 System.out.println("inside businessModalPanel call------------------------");
				 setBlockFlag(true);
				 if(compositeAction.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_BUS_RULE_ERROR_MSG().size()>0)
				 {
				 compositeAction.getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN().onLoad(null);
				 compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
				 .getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered(
						 false);
				 compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
				 .getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered(
						 false); 
				 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			 }
				 
			 }catch (Exception e) {
				 compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
				 .getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered(
						 false);
				 e.printStackTrace();
				 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						 e.getMessage());
				 getErrorMap().put("AssuredModalPanel", e.getMessage());
			 }
			 return "";
			 
		 }*/
		
		/*End*/
		/*end*/
		
		/*Added by Janani on 09.06.2017 for ZBILQC-1728495*/
		
		public int assuredAgeCheck(
				PILT002_APAC_COMPOSITE_ACTION compositeAction)
				throws Exception {
			
			
			System.out.println("enters into assuredAgeCheck");
			
			PT_IL_POLICY_ACTION policy_action_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN();
			
			Connection con = null;
			ResultSet rs1 = null;
			String query1 = "SELECT PLAN_AGE_FROM,PLAN_AGE_TO,PLAN_PERIOD_FROM,PLAN_PERIOD_TO,PLAN_MIN_AGE_ON_MAT,PLAN_MAX_AGE_ON_MAT "
					+ "FROM PM_IL_PLAN WHERE PLAN_CODE=?";
			
			Integer plan_age_from = 0;
			Integer plan_age_to = 0;
			Integer plan_period_from = 0;
			Integer plan_period_to = 0;
			Integer plan_min_age_on_mat = 0;
			Integer plan_max_age_on_mat = 0;
			Integer POL_JOINT_LIFE_AGE = policy_action_bean.getPT_IL_POLICY_BEAN().getPOL_JOINT_LIFE_AGE();
			
			try
			{
				con = CommonUtils.getConnection();
				
				System.out.println("getPOL_PROD_CODE                 :"+policy_action_bean.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE());
				
				System.out.println("getPOL_PLAN_CODE                 :"+policy_action_bean.getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE());
				
				/*Modified by Janani on 24.04.2018 for Fidelity since plan and prod code are different*/
				
				/*rs1 = new CRUDHandler().executeSelectStatement(query1, con, new Object[]
						{policy_action_bean.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});*/
				
				rs1 = new CRUDHandler().executeSelectStatement(query1, con, new Object[]
						{policy_action_bean.getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
				
				/*End*/
				
				while(rs1.next())
				{
					plan_age_from = rs1.getInt("PLAN_AGE_FROM");
					plan_age_to = rs1.getInt("PLAN_AGE_TO");
					plan_period_from = rs1.getInt("PLAN_PERIOD_FROM");
					plan_period_to = rs1.getInt("PLAN_PERIOD_TO");
					plan_min_age_on_mat = rs1.getInt("PLAN_MIN_AGE_ON_MAT");
					plan_max_age_on_mat = rs1.getInt("PLAN_MAX_AGE_ON_MAT");
				}
				
				
				System.out.println("plan_age_from                :"+plan_age_from);
				System.out.println("plan_age_to                  :"+plan_age_to);
				System.out.println("plan_period_from             :"+plan_period_from);
				System.out.println("plan_period_to               :"+plan_period_to);
				System.out.println("plan_min_age_on_mat          :"+plan_min_age_on_mat);
				System.out.println("plan_max_age_on_mat          :"+plan_max_age_on_mat);
				System.out.println("POL_JOINT_LIFE_AGE          :"+POL_JOINT_LIFE_AGE);
				
				
				/*Added by Janani on 28.04.2018 for joint life null issue*/
				if(POL_JOINT_LIFE_AGE != null)
				{
					
				/*end*/	
				if(POL_JOINT_LIFE_AGE < plan_age_from || POL_JOINT_LIFE_AGE > plan_age_to )
				{
					System.out.println("inside age validation condition");
					
					/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"Age Should lie between "+plan_age_from+" and "+plan_age_to+" Years");
					*/
					/* changed by raja on 08-08-2017 for ZBILQC-1730358 */
					throw new Exception(" Assured Age Should lie between "+plan_age_from+" and "+plan_age_to+" Years");
					
					/*end*/
				}
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
				
				throw e;
				
				
			}
			
			return 0;
			
		}
		
		/*End*/
		
		
		/*Added by Janani on 14.07.2017 for ZBILQC-1731112 */
		
		 public int getPropAcceptanceDuration()
					throws Exception {
			  System.out.println("*******enter into getPropAcceptanceDuration***");
			
				String C1 ="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_PRO_ACPT' AND PS_CODE = 'IL_PRO_ACPT'";
				ResultSet C1_REC = null;
				int ps_value=0;
				try {
					Connection connection = CommonUtils.getConnection();
					CRUDHandler handler = new CRUDHandler();
					C1_REC = handler.executeSelectStatement(C1, connection);
					if (C1_REC.next()) {
						ps_value =C1_REC.getInt(1);
					}
					} catch (SQLException e) {
					throw new Exception(e.getMessage());
				} 
				System.out.println("**************value of ProposalAcceptanceDuration***"+ps_value);
				return ps_value;
				
			}
		
			/*End*/
		 
		 public void POL_LAPS_OVR_FRM_DT_WHEN_VALIDATE_ITEM(
		 			PILT002_APAC_COMPOSITE_ACTION compositeAction,Date value)
		 					throws Exception {

		 		PT_IL_POLICY pt_il_policy_bean = compositeAction
		 				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		 		Date sysDate = new CommonUtils().getCurrentDate();
		 		try
		 		{
		 			
		 			if(pt_il_policy_bean.getPOL_LAPS_OVR_FRM_DT().before(sysDate)) {
		 				throw new Exception(
		 						"Back date not allowed");
		 			}

		 		}catch (Exception e) {
		 			e.printStackTrace();
		 			throw new Exception(e.getMessage());
		 		}

		 	}	
		
		 
		 /*Added by saritha on 14-12-2017 for ssp call id : ZBLIFE-1461947*/
		 
		 public void userMedicalAccessValidation(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception
		 {
			 PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			 
			 String flag=null;
			 ResultSet rs = null;
			 try{
				 Map<String, Object> session = FacesContext.getCurrentInstance()
						 .getExternalContext().getSessionMap();

				 String userID=session.get("GLOBAL.M_USER_ID").toString();
				 String query="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "
						 + "ASD_FLAG = '2' AND ASD_CODE='MED_EXAM_INS' AND "
						 + "ASD_USER_ID = ? AND ASD_FM_PROD_CODE = ? AND "
						 + "ASD_TO_PROD_CODE = ?";

				 rs=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{userID,
					 policyBean.getPOL_PROD_CODE(),
					 policyBean.getPOL_PROD_CODE()});

				 while(rs.next())
				 {
					 flag=rs.getString("ASD_CHAR_VALUE");
				 }

				 if(flag!=null && flag.equalsIgnoreCase("Y") && policyBean.getPOL_FLEX_20()!=null && "Y".equalsIgnoreCase(policyBean.getPOL_FLEX_20()))
				 {
					 compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");	

				 }
				 
				 else {

					 compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");	

				 }
			
				 
			 }catch(Exception e)
			 {
				 e.printStackTrace();
				 throw e;
			 }finally{
				 CommonUtils.closeCursor(rs);
				 
			 }

		 }
		 
		  /*End*/	 
		 
		 /* added by gopi for toi on 31/05/18*/
		 public Date getFirstDateOfMonth(Date date){
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(date);
		        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		        return cal.getTime();
		    }
		 
		 //end
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 /*Added by saritha on 16-04-2018 for KIC Customer address Details to defalut policy level address*/ 
		 
		 public void getAddressDetails(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception
		 {
			 
			 PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			 String addrDtlQuery="";
			 ResultSet rs = null;

			 try{

				 if("H".equalsIgnoreCase(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().getCOMM_ADDRS())){
					 addrDtlQuery="SELECT CUST_ADDR1, CUST_ADDR2, CUST_ADDR3,CUST_CITY_CODE,CUST_CITY,CUST_COUNT_CODE,CUST_COUNTRY,"
					 		+ "CUST_TEL_AREA_CODE,CUST_PHONE,CUST_FAX_AREA_CODE,CUST_FAX,CUST_PHONE2,"
					 		+ "CUST_EMAIL_ID_PER FROM PM_CUSTOMER WHERE CUST_CODE = ?";
					 rs=new CRUDHandler().executeSelectStatement(addrDtlQuery, CommonUtils.getConnection(), new Object[]{policyBean.getPOL_CUST_CODE()});
					 if(rs.next())
					 {
						 policyBean.setPOL_RES_ADDRESS_1(rs.getString("CUST_ADDR1"));
						 policyBean.setPOL_RES_ADDRESS_2(rs.getString("CUST_ADDR2"));
						 policyBean.setPOL_RES_ADDRESS_3(rs.getString("CUST_ADDR3"));
						 //policyBean.setPOL_RES_AREA_CODE(rs.getString("CUST_POSTAL_CODE"));
						 policyBean.setPOL_CITY_CODE(rs.getString("CUST_CITY_CODE"));
						 policyBean.setUI_M_POL_CITY_NAME(rs.getString("CUST_CITY"));
						 policyBean.setPOL_COUNT_CODE(rs.getString("CUST_COUNT_CODE"));
						 policyBean.setUI_M_POL_COUNT_NAME(rs.getString("CUST_COUNTRY"));
						 policyBean.setPOL_RES_PHONE_NO(rs.getString("CUST_PHONE"));
						 policyBean.setPOL_MOBILE_NO(rs.getString("CUST_PHONE2"));
						 policyBean.setPOL_RES_EMAIL_ID(rs.getString("CUST_EMAIL_ID_PER"));
						 policyBean.setPOL_FAX_AREA_CODE(rs.getString("CUST_FAX_AREA_CODE"));
						 policyBean.setPOL_FAX_NO(rs.getString("CUST_FAX"));

					 }
				 }else if("O".equalsIgnoreCase(compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getPM006_QE_CUSTOMER_BEAN().getCOMM_ADDRS())){
					 addrDtlQuery="SELECT CUST_PHY_ADDR1, CUST_PHY_ADDR2, CUST_PHY_ADDR3,CUST_PHY_CITY_CODE,CUST_PHY_COUNTRY,"
					 		+ "CUST_MOBILE_NO,CUST_OFFICE_PHONE,CUST_PHY_EMAIL_ID_OFF,CUST_FAX_AREA_CODE2,"
					 		+ "CUST_PHY_FAX FROM PM_CUSTOMER WHERE CUST_CODE = ?";
					 rs=new CRUDHandler().executeSelectStatement(addrDtlQuery, CommonUtils.getConnection(), new Object[]{policyBean.getPOL_CUST_CODE()});
					 if(rs.next())
					 {
						 policyBean.setPOL_RES_ADDRESS_1(rs.getString("CUST_PHY_ADDR1"));
						 policyBean.setPOL_RES_ADDRESS_2(rs.getString("CUST_PHY_ADDR2"));
						 policyBean.setPOL_RES_ADDRESS_3(rs.getString("CUST_PHY_ADDR3"));
						 //policyBean.setPOL_RES_AREA_CODE(rs.getString("CUST_POST_BOX_NO"));
						 policyBean.setPOL_CITY_CODE(rs.getString("CUST_PHY_CITY_CODE"));
						 policyBean.setPOL_COUNT_CODE(rs.getString("CUST_PHY_COUNTRY"));
						 policyBean.setPOL_MOBILE_NO(rs.getString("CUST_MOBILE_NO"));
						 policyBean.setPOL_RES_PHONE_NO(rs.getString("CUST_OFFICE_PHONE"));
						 policyBean.setPOL_RES_EMAIL_ID(rs.getString("CUST_PHY_EMAIL_ID_OFF"));
						 policyBean.setPOL_FAX_AREA_CODE(rs.getString("CUST_FAX_AREA_CODE2"));
						 policyBean.setPOL_FAX_NO(rs.getString("CUST_PHY_FAX"));

					 }
				 }else {
					 addrDtlQuery="SELECT CUST_CORR_ADDR1,CUST_CORR_ADDR2,CUST_CORR_ADDR3,CUST_CORR_CITY_CODE,CUST_CORR_COUNTRY,"
					 		+ "CUST_CORR_OFFICE_PHONE,CUST_CORR_EMAIL_ID_OFF,CUST_CORR_FAX_AREA_CODE,CUST_CORR_MOBILE_NO,"
					 		+ "CUST_CORR_FAX FROM PM_CUSTOMER WHERE CUST_CODE = ?";
					 rs=new CRUDHandler().executeSelectStatement(addrDtlQuery, CommonUtils.getConnection(), new Object[]{policyBean.getPOL_CUST_CODE()});
					 if(rs.next())
					 {
						 policyBean.setPOL_RES_ADDRESS_1(rs.getString("CUST_CORR_ADDR1"));
						 policyBean.setPOL_RES_ADDRESS_2(rs.getString("CUST_CORR_ADDR2"));
						 policyBean.setPOL_RES_ADDRESS_3(rs.getString("CUST_CORR_ADDR3"));
						 //policyBean.setPOL_RES_AREA_CODE(rs.getString("CUST_CORR_POST_BOX_NO"));
						 policyBean.setPOL_CITY_CODE(rs.getString("CUST_CORR_CITY_CODE"));
						 policyBean.setPOL_COUNT_CODE(rs.getString("CUST_CORR_COUNTRY"));
						 policyBean.setPOL_RES_PHONE_NO(rs.getString("CUST_CORR_OFFICE_PHONE"));
						 policyBean.setPOL_MOBILE_NO(rs.getString("CUST_CORR_MOBILE_NO"));
						 policyBean.setPOL_RES_EMAIL_ID(rs.getString("CUST_CORR_EMAIL_ID_OFF"));
						 policyBean.setPOL_FAX_AREA_CODE(rs.getString("CUST_CORR_FAX_AREA_CODE"));
						 policyBean.setPOL_FAX_NO(rs.getString("CUST_CORR_FAX"));
					 }
				 }

			 }catch(Exception e)
			 {
				 e.printStackTrace();
				 throw e;
			 }finally{
				 CommonUtils.closeCursor(rs);

			 }

		 }
		 
		 /*End*/	 
		 
		 /* Newly Added By Dhinesh on 31/05/2018*/
		 public ArrayList<OracleParameter> callP_FUNERAL_SUB_PLAN_DFLT_SA(String  POL_PROD_CODE,String Sub_Plan_Code) throws Exception {
				Connection connection = null;
				ArrayList<OracleParameter> parameterList = null;
				ArrayList<OracleParameter> outputList = null;
				try {
					connection = CommonUtils.getConnection();
					parameterList = new ArrayList<OracleParameter>();
					outputList = new ArrayList<OracleParameter>();
					OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, POL_PROD_CODE);
					parameterList.add(param1);
					OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, Sub_Plan_Code);
					parameterList.add(param2);
					OracleParameter param3 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.DOUBLE,	OracleParameter.DIRECTION_TYPE.OUT, "");
					parameterList.add(param3);
					OracleParameter param4 = new OracleParameter("OUT2", OracleParameter.DATA_TYPE.DOUBLE,	OracleParameter.DIRECTION_TYPE.OUT, "");
					parameterList.add(param4);

					OracleProcedureHandler procHandler = new OracleProcedureHandler();
					outputList = procHandler.executeProc(parameterList, connection,
							"P9ilpk_F_Policy.P_FUNERAL_SUB_PLAN_DFLT_SA");
				} catch(Exception e) {
					ErrorHelpUtil.getErrorForProcedure(connection);
					e.printStackTrace();
					throw new ProcedureException(e.getMessage());
				}
				return outputList;
			}
		 
		 /*End*/
		 
		 
		 
		/*Added by Ameen on 26-07-2018 for TOI */ 
		 public String getPolicyApprove(String prod_code) {

			 String Policy_approve = null;
			 Connection connection = null;
			 ResultSet rs = null;
			String query="SELECT PROD_POL_APPROVAL_YN FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";	
				try {
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] {prod_code});
				 if(rs.next()) {
					 Policy_approve = rs.getString(1);
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return Policy_approve;
		 }
		 /*Added by pidugu raj dt: 27-08-2018 for KICLIFEQC-1762428*/
		public void doDeleteFundDetailRecords(
				PILT002_APAC_COMPOSITE_ACTION compositeAction) {

			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			String  CURSOR_C1 = "DELETE FROM PT_IL_POL_FUND_DTL where pofd_pol_sys_id = ? AND POFD_FUND_DIR_TYPE = ?";
			try{
				connection = CommonUtils.getConnection();
				String POFD_FUND_DIR_TYPE = "P";
				handler.executeDeleteStatement(CURSOR_C1, connection, new Object[] {compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN().getPOFD_POL_SYS_ID(),POFD_FUND_DIR_TYPE});
				connection.commit();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public PM_IL_PLAN doGetPlanType(String pol_PROD_CODE) {
			 Connection connection = null;
			 ResultSet rs = null;
			 PM_IL_PLAN planObj = new PM_IL_PLAN();
			String query="select plan_type from pm_il_plan where plan_code=? ";	
				try {
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] {pol_PROD_CODE});
				 if(rs.next()) {
					 planObj.setPLAN_TYPE(rs.getString(1));
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } finally{
				 try {
					connection.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
			 return planObj;
		 }
		/*End added by pidugu raj dt: 27-08-2018 for KICLIFEQC-1762428*/
		
		}