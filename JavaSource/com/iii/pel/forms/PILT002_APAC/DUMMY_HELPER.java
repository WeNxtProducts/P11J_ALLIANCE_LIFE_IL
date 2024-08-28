package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP002_APAC.DB_Procedures;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_BUS_RULE;
import com.iii.pel.utils.P9ILPK_ENDORSE;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POL_APPROVAL;
import com.iii.pel.utils.P9ILPK_RI_ALLOC;
import com.iii.pel.utils.PILPK_PILT002;
import com.iii.pel.utils.PILPK_PILT002_STATUS_OK;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY_HELPER {

	P9ILPK_POLICY_SP_REVIVAL sp_revival = new P9ILPK_POLICY_SP_REVIVAL();
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	public void UI_M_BUT_PRMDTLS_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		System.out.println("********    Enter the DUMMY_HELPER Procedure UI_M_BUT_PRMDTLS_WHEN_BUTTON_PRESSED ******** ");

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		String M_CURRENT_BLOCK = null;
		String M_COVER_DISC_AGE_YN = null;
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		P9ILPK_POL_APPROVAL p9ilpk_pol_approval = new P9ILPK_POL_APPROVAL();
		PT_IL_POLICY_HELPER pt_il_policy_helper = new PT_IL_POLICY_HELPER();
		String query1 = "  SELECT COVER_DISC_AGE_YN  FROM   PM_IL_COVER"
				+ "  WHERE  COVER_CODE =? ";
		PILT002_APAC_LOCAL_PROCEDURES local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();
		try {
			connection = CommonUtils.getConnection();

			values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, values);
			while (resultSet.next()) {
				M_COVER_DISC_AGE_YN = resultSet.getString("COVER_DISC_AGE_YN");
			}

			if (pt_il_policy_bean.getPOL_JOINT_LIFE_YN().equals("Y")
					&& dummy_bean.getUI_M_CALC_METHOD() == 2) {
				local_procedures.IL_PREM_CAL_JL_AGE(pt_il_policy_bean
						.getPOL_JOINT_LIFE_AGE(),
						CommonUtils.dateToStringFormat(pt_il_policy_bean
								.getPOL_START_DT()), pt_il_policy_bean
								.getPOL_PLAN_CODE(), pt_il_policy_bean
								.getPOL_SYS_ID());
			} else {
				if (CommonUtils.nvl(M_COVER_DISC_AGE_YN, "N").equals("N")) {
					pt_il_policy_bean
							.setPOL_JOINT_LIFE_AGE(pt_il_pol_assured_dtls_bean
									.getPOAD_AGE());
				} else if (CommonUtils.nvl(M_COVER_DISC_AGE_YN, "N")
						.equals("Y")) {
					pt_il_policy_bean
							.setPOL_JOINT_LIFE_AGE(pt_il_pol_assured_dtls_bean
									.getPOAD_DISC_AGE());
				}
			}

			/*
			 * COPY('P','CTRL.M_COMM_DEL') ; COPY('20','SYSTEM.MESSAGE_LEVEL');
			 * POST; COPY('0','SYSTEM.MESSAGE_LEVEL');
			 * COPY('','CTRL.M_COMM_DEL') ;
			 */

			p9ilpk_pol_approval.P_VAL_POL_ASSR_NOS(pt_il_policy_bean
					.getPOL_SYS_ID().toString());
			if (pt_il_policy_bean.getPOL_FRZ_FLAG().equals("N")
					&& dummy_bean.getUI_M_CALC_METHOD() == 2) {
				pValOrclList = p9ilpk_policy.P_CALC_PREMIUM(CommonUtils
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
								.getUI_M_POL_LC_GR_ANN_PREM()), "Y");

				if (pValOrclList != null && !pValOrclList.isEmpty()) {
					if (pValOrclList.get(0).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_FC_TOT_PREM(Double
								.parseDouble(pValOrclList.get(0).getValue()));
					}
					if (pValOrclList.get(1).getValue() != null) {
						pt_il_policy_bean.setUI_M_POL_LC_TOT_PREM(Double
								.parseDouble(pValOrclList.get(1).getValue()));

					}
					if (pValOrclList.get(2).getValue() != null) {
						if (pt_il_policy_bean.getPOL_FC_SUM_ASSURED() != null
								&& pt_il_policy_bean.getPOL_FC_SUM_ASSURED() > 0) {
							pt_il_policy_bean
									.setUI_M_POL_FC_TOT_LOADING(Double
											.parseDouble(pValOrclList.get(2)
													.getValue()));
						} else {
							pt_il_policy_bean.setUI_M_POL_FC_TOT_LOADING(0.0);
						}
					}
					if (pValOrclList.get(3).getValue() != null) {
						if (pt_il_policy_bean.getPOL_FC_SUM_ASSURED() != null
								&& pt_il_policy_bean.getPOL_FC_SUM_ASSURED() > 0) {
							pt_il_policy_bean
									.setUI_M_POL_LC_TOT_LOADING(Double
											.parseDouble(pValOrclList.get(3)
													.getValue()));
						} else {
							pt_il_policy_bean.setUI_M_POL_LC_TOT_LOADING(0.0);
						}
					}
					if (pValOrclList.get(4).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_FC_TOT_DISCOUNT(Double
								.parseDouble(pValOrclList.get(4).getValue()));
					}
					if (pValOrclList.get(5).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_LC_TOT_DISCOUNT(Double
								.parseDouble(pValOrclList.get(5).getValue()));
					}
					if (pValOrclList.get(6).getValue() != null) {

						pt_il_policy_bean.setUI_M_FC_PCHARGES_BORNE_CUST(Double
								.parseDouble(pValOrclList.get(6).getValue()));
					}
					if (pValOrclList.get(7).getValue() != null) {

						pt_il_policy_bean.setUI_M_LC_PCHARGES_BORNE_CUST(Double
								.parseDouble(pValOrclList.get(7).getValue()));
					}
					if (pValOrclList.get(8).getValue() != null) {

						pt_il_policy_bean.setUI_M_FC_PCHARGES_BORNE_COMP(Double
								.parseDouble(pValOrclList.get(8).getValue()));
					}
					if (pValOrclList.get(9).getValue() != null) {

						pt_il_policy_bean.setUI_M_LC_PCHARGES_BORNE_COMP(Double
								.parseDouble(pValOrclList.get(9).getValue()));
					}
					if (pValOrclList.get(10).getValue() != null) {

						pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_CUST(Double
								.parseDouble(pValOrclList.get(10).getValue()));
					}
					if (pValOrclList.get(11).getValue() != null) {

						pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_CUST(Double
								.parseDouble(pValOrclList.get(11).getValue()));
					}
					if (pValOrclList.get(12).getValue() != null) {

						pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_COMP(Double
								.parseDouble(pValOrclList.get(12).getValue()));
					}
					if (pValOrclList.get(13).getValue() != null) {

						pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_COMP(Double
								.parseDouble(pValOrclList.get(13).getValue()));
					}
					if (pValOrclList.get(14).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_FC_NET_PREM(Double
								.parseDouble(pValOrclList.get(14).getValue()));
					}
					if (pValOrclList.get(15).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_LC_NET_PREM(Double
								.parseDouble(pValOrclList.get(15).getValue()));
					}
					if (pValOrclList.get(16).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_INST_FC_PREM(Double
								.parseDouble(pValOrclList.get(16).getValue()));
					}
					if (pValOrclList.get(17).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_INST_LC_PREM(Double
								.parseDouble(pValOrclList.get(17).getValue()));
					}
					if (pValOrclList.get(18).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_FC_MOP(Double
								.parseDouble(pValOrclList.get(18).getValue()));
					}
					if (pValOrclList.get(19).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_LC_MOP(Double
								.parseDouble(pValOrclList.get(19).getValue()));
					}
					if (pValOrclList.get(20).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_FC_GR_ANN_PREM(Double
								.parseDouble(pValOrclList.get(20).getValue()));
					}
					if (pValOrclList.get(21).getValue() != null) {

						pt_il_policy_bean.setUI_M_POL_LC_GR_ANN_PREM(Double
								.parseDouble(pValOrclList.get(21).getValue()));
					}

				}
			}
			/*
			 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE; RAISE
			 * FORM_TRIGGER_FAILURE; END;
			 */
			pt_il_policy_bean.setUI_M_POL_FC_SA(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_FC_SUM_ASSURED(), 0));

			pt_il_policy_bean.setUI_M_POL_LC_SA(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_LC_SUM_ASSURED(), 0));
			pt_il_policy_bean.setUI_M_POL_MODE_OF_PYMT_RATE(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_MODE_OF_PYMT_RATE(), 0));

			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
					pt_il_policy_bean.getPOL_SYS_ID().toString());
			// CLEAR_BLOCK(NO_VALIDATE);

			/*
			 * Start - Code Modified By A.SubbuLakshmi with reference to
			 * PRIL-IMPALY-007-TISB4
			 */
			// GO_ITEM('PT_IL_POLICY.POL_PROD_CODE');
			/*
			 * End - Code Modified By A.SubbuLakshmi with reference to
			 * PRIL-IMPALY-007-TISB4
			 */

			// COPY('20','SYSTEM.MESSAGE_LEVEL');
			pt_il_policy_helper.executeQuery(compositeAction);

			// COPY('0','SYSTEM.MESSAGE_LEVEL');
			/*
			 * COPY('P','CTRL.M_COMM_DEL') ; POST; COPY('','CTRL.M_COMM_DEL') ;
			 */
			// pt_il_policy_bean.setPOL_RES_ADDRESS_1( ) :=
			// :PT_IL_POLICY.POL_RES_ADDRESS_1;
			if (pt_il_policy_bean.getPOL_BASIC_RATE() != null) {
				if (pt_il_policy_action.getCOMP_POL_BASIC_RATE().isDisabled() == false) {
					pt_il_policy_action.getCOMP_POL_BASIC_RATE().setRequired(
							true);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void UI_M_BUT_UDDATE_STAT_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		int M_VALUE = 0;
		String M_CODE_DESC = null;
		DB_Procedures procedures = new DB_Procedures();
		try {
			connection = CommonUtils.getConnection();

			//MODIFIED BY AKASH TO MAKE NORMAL FLOW TO BE WORK

			if (/*dummy_bean.getUI_M_CALC_METHOD() == 1*/dummy_bean
					.getUI_M_CALC_METHOD() != null
					&& (dummy_bean.getUI_M_POL_PLAN_TYPE().equals("M") || dummy_bean
							.getUI_M_POL_PLAN_TYPE().equals("T")))

				pValList = procedures.callP_VAL_SYSTEM("IL_TLMT_MTHD",
						"IL_TLMT_MTHD", M_CODE_DESC, "E", null);
			// --ADDED BY SARVINDER FOR FSD 008 STM
			if (pValList.size() > 0) {
				M_CODE_DESC = pValList.get(0);
				M_VALUE = Integer.parseInt(pValList.get(1));
			}
			if (M_VALUE == 1) {
				// PENDING TODO
				// L_UPDATE_MRTA_STATUS ;

				//MODIFIED BY AKASH TO MAKE NORMAL FLOW TO BE WORK

			} else if (/*dummy_bean.getUI_M_CALC_METHOD() == 1*/dummy_bean
					.getUI_M_CALC_METHOD() != null
					&& (!dummy_bean.getUI_M_POL_PLAN_TYPE().equals("M") || !dummy_bean
							.getUI_M_POL_PLAN_TYPE().equals("T"))) {

				// L_UPDATE_JE_STATUS ;
			}

		} catch (Exception e) {
			// TODO: handle exception
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

	public void UI_M_BUT_CONVERT_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String query1 = " SELECT DS_POL_CODE  FROM   PM_IL_DOC_SETUP,PT_IL_POLICY"
				+ "  WHERE  POL_NO = ? "
				+ "  AND    POL_DS_CODE = DS_CODE  AND    DS_TYPE = '1'";

		try {
			connection = CommonUtils.getConnection();

			dummy_bean.setUI_M_PROP_NO(pt_il_policy_bean.getPOL_NO());

			if ((!CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2).equals("Y") || !CommonUtils
					.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(0, 1)
					.equals("Y"))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91498",
						new Object[] { "Convert" }));
			}

			values = new Object[] { dummy_bean.getUI_M_PROP_NO() };
			rs = new CRUDHandler().executeSelectStatement(query1, connection,
					values);
			if (rs.next()) {
				dummy_bean.setUI_M_POL_DOC_CODE(rs.getString("DS_POL_CODE"));
			}

			dummy_bean.setUI_M_CONV_DT(new CommonUtils().getCurrentDate());
			dummy_bean.setUI_M_POL_DOC_DESC(null);
			dummy_bean.setUI_M_POL_NO(null);
			dummy_action.getCOMP_UI_M_POL_DOC_CODE().setRequired(true);
			if (!pt_il_policy_bean.getPOL_PROP_QUOT_FLAG().equals("Q")) {

				pValList = new LIFELIB().P_GEN_DOC_NO("2", dummy_bean
						.getUI_M_POL_DOC_CODE(), pt_il_policy_bean
						.getPOL_DIVN_CODE(), pt_il_policy_bean
						.getPOL_CLASS_CODE(), pt_il_policy_bean
						.getPOL_PLAN_CODE(), pt_il_policy_bean
						.getPOL_PROD_CODE(), CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_UW_YEAR()),
						"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ISSUE_DT()), null, null,
										
										/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
										CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
										/*End*/
						
						);
				if (!pValList.isEmpty()) {
					dummy_bean.setUI_M_POL_NO(pValList.get(0).getValue());
				}

				dummy_action.getCOMP_UI_M_PROP_NO_LABEL().setValue(
						"Proposal No");
				dummy_action.getCOMP_UI_M_CONV_DT_LABEL().setValue(
						"Conversion Date");
				dummy_action.getCOMP_UI_M_POL_DOC_CODE_LABEL().setValue(
						"Pol Doc Code");
				dummy_action.getCOMP_UI_M_POL_NO_LABEL().setValue("Policy No");
			} else {

				pValList = new LIFELIB().P_GEN_DOC_NO("1", CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_1"),
						pt_il_policy_bean.getPOL_DIVN_CODE(), pt_il_policy_bean
								.getPOL_CLASS_CODE(), pt_il_policy_bean
								.getPOL_PLAN_CODE(), pt_il_policy_bean
								.getPOL_PROD_CODE(), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_UW_YEAR()),
						"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ISSUE_DT()), null, null,
										
										/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
										CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
										/*End*/
						);
				if (!pValList.isEmpty()) {
					dummy_bean.setUI_M_POL_NO((String) pValList.get(0)
							.getValueObject());
				}
				dummy_action.getCOMP_UI_M_PROP_NO_LABEL().setValue(
						"Quotation No");
				dummy_action.getCOMP_UI_M_CONV_DT_LABEL().setValue(
						"Conversion Date");
				dummy_action.getCOMP_UI_M_POL_DOC_CODE_LABEL().setValue(
						"Prop Doc Code");
				dummy_action.getCOMP_UI_M_POL_NO_LABEL()
						.setValue("Proposal No");
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

	public void UI_M_BUT_FUND_DTL_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			// PENDING
			// GO_ITEM('PT_IL_POL_FUND_DTL.POFD_FUND_CODE');
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public String UI_M_BUT_ENDT_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String claimType = null;
		
		/*Commentted &Modified by saritha on 05-09-2017 for ssp call id ZBILQC-1735997 as suggested by ajoy sir*/
		
		/*String C1 = "SELECT CLAIM_TYPE FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = ?"
				+ "AND NVL(CLAIM_ASSR_CODE,'XXX') = NVL(CLAIM_MED_CODE,CLAIM_ASSR_CODE)";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { pt_il_policy_bean.getPOL_NO() });
			if (resultSet.next()) {
				claimType = resultSet.getString(1);
			}
			if ("A".equalsIgnoreCase(claimType)
					|| "D".equalsIgnoreCase(claimType)) {
				throw new Exception(
						"Death Claim Already Registered Cannot Proceed For Endorsements");
			}*/
		
		String C1 = "SELECT 'X' FROM PT_IL_POL_FUNERAL_MEMB_DTLS,PT_IL_POLICY,PM_IL_PLAN,PT_IL_CLAIM WHERE PFMD_POL_SYS_ID = CLAIM_POL_SYS_ID"
				+ " AND PFMD_POL_SYS_ID = POL_SYS_ID AND PLAN_CODE = POL_PLAN_CODE AND PFMD_POL_SYS_ID = ?"
				+ " AND PFMD_RELATION_TYPE ='01' AND PLAN_CODE = POL_PLAN_CODE AND "
				+ "NVL(CLAIM_ASSR_CODE, 'XXX') =NVL(CLAIM_MEMB_CODE, CLAIM_ASSR_CODE) AND PLAN_TYPE IN ('L', 'H') UNION "
				+ "SELECT 'X' FROM PT_IL_POL_ASSURED_DTLS,PT_IL_POLICY,PM_IL_PLAN,PT_IL_CLAIM WHERE POAD_POL_SYS_ID = ? "
				+ "AND POL_SYS_ID = CLAIM_POL_SYS_ID AND PLAN_CODE = POL_PLAN_CODE "
				+ "AND POAD_POL_SYS_ID = POL_SYS_ID AND PLAN_TYPE NOT IN ('L', 'H')";

		try {
			connection = CommonUtils.getConnection();
			System.out.println("polSysId "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]
					{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
					 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			if (resultSet.next()) {
				throw new Exception("Death Claim Register for Main member Endorsement not allowed for this policy");
			}
			
		/*End*/
		
		
			dummy_action.getCOMP_UI_M_ICON_HINT().setRendered(false);// ',DISPLAYED,PROPERTY_FALSE);

			dummy_bean.setUI_M_ICON_HINT("");

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_STATUS(), "X").equals(
					"T")) { // ----FOR
				// REINSTATEMENT
				// ISSUE
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Cannot Pass the Endorsement for Expired Policy" }));
			}

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_STATUS(), "X").equals(
					"C")) { // ----FOR
				// CANCELLED
				// POLICIES
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Cannot Pass the Endorsement for Cancelled Policy" }));

			}
			// PENDING
			// IF :SYSTEM.CURSOR_ITEM != 'PT_IL_POLICY.POL_END_CODE' THEN
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					1, 2).equals("Y")) {
				pt_il_policy_action.setUPDATE_ALLOWED(true);
				pt_il_policy_action.disableAllComponent(false);
				// SET_BLOCK_PROPERTY('PT_IL_POLICY',UPDATE_ALLOWED,PROPERTY_TRUE);
			}
			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N")
					.equals("A")) {
				if (pt_il_policy_bean.getPOL_END_TYPE() != null) {
					pt_il_policy_bean.setPOL_END_TYPE(null);
				}
				if (pt_il_policy_bean.getPOL_END_CODE() != null) {
					pt_il_policy_bean.setPOL_END_CODE(null);
				}
				if (pt_il_policy_bean.getPOL_END_NO() != null) {
					pt_il_policy_bean.setPOL_END_NO(null);
				}
				if (pt_il_policy_bean.getUI_M_POL_END_CODE_DESC() != null) {
					pt_il_policy_bean.setUI_M_POL_END_CODE_DESC(null);
				}
				if (pt_il_policy_bean.getPOL_END_DT() != null) {
					pt_il_policy_bean.setPOL_END_DT(null);
				}
				if (pt_il_policy_bean.getPOL_END_EFF_FROM_DT() != null) {
					pt_il_policy_bean.setPOL_END_EFF_FROM_DT(null);
				}
				if (pt_il_policy_bean.getPOL_END_EFF_TO_DT() != null) {
					pt_il_policy_bean.setPOL_END_EFF_TO_DT(null);
				}
				if (pt_il_policy_bean.getPOL_END_DESC() != null) {
					pt_il_policy_bean.setPOL_END_DESC(null);
				}
			}
			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N")
					.equals("N")
					&& CommonUtils
							.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) != 0) {

				pt_il_policy_action.getCOMP_POL_END_CODE().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_END_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_END_CODE().setRequired(false);
				pt_il_policy_action.getCOMP_POL_END_NO().setRequired(false);

				if (pt_il_policy_bean.getPOL_STATUS().equals("S")) {
					pt_il_policy_bean.setUI_M_SURR_MAT("S");
				} else if (pt_il_policy_bean.getPOL_STATUS().equals("P")) {
					pt_il_policy_bean.setUI_M_SURR_MAT("P");
				} else {
					pt_il_policy_bean.setUI_M_SURR_MAT(null);
				}

			} else {
				pt_il_policy_action.getCOMP_POL_END_CODE().setDisabled(true);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_policy_action.getCOMP_POL_END_CODE().setDisabled(
							false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_policy_action.getCOMP_POL_END_CODE().setDisabled(
							false);
				}
				pt_il_policy_action.getCOMP_POL_END_CODE().setRequired(true);
				pt_il_policy_action.getCOMP_POL_END_NO().setDisabled(false);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {

					pt_il_policy_action.getCOMP_POL_END_NO().setDisabled(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_policy_action.getCOMP_POL_END_NO().setDisabled(false);
				}
				pt_il_policy_action.getCOMP_POL_END_NO().setRequired(false);
				pt_il_policy_bean.setPOL_END_NO(pt_il_policy_bean
						.getPOL_END_NO());
				// :PT_IL_POLICY.POL_END_NO := :PT_IL_POLICY.POL_END_NO;
			}

			pt_il_policy_action.getCOMP_POL_END_DT().setDisabled(false);
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				pt_il_policy_action.getCOMP_POL_END_DT().setDisabled(false);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {

				pt_il_policy_action.getCOMP_POL_END_DT().setDisabled(false);
			}
			pt_il_policy_action.getCOMP_POL_END_DT().setRequired(false);

			pt_il_policy_action.getCOMP_POL_END_DESC().setDisabled(false);
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {

				pt_il_policy_action.getCOMP_POL_END_DESC().setDisabled(false);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {

				pt_il_policy_action.getCOMP_POL_END_DESC().setDisabled(false);
			}

			pt_il_policy_action.getCOMP_POL_MED_FEE_RECOVER_YN().setDisabled(
					true);

			// PENDING
			/*
			 * if(pt_il_policy_action.getCOMP_POL_END_CODE().isDisabled()==false){
			 * GO_ITEM('PT_IL_POLICY.POL_END_CODE'); CHK_PKG_FAILURE; }else{
			 * GO_ITEM('PT_IL_POLICY.POL_END_DT'); CHK_PKG_FAILURE; } } else{
			 * SHOW_WINDOW('PT_ENDT'); }
			 */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return "PILT002_APAC_PT_IL_POLICY_ENDORSEMENT";
	}

	public void UI_M_BUT_HOLD_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		String M_DUMMY1 = null;

		String query1 = "   SELECT 'X'    FROM   PT_IL_POLICY "
				+ " WHERE  POL_SYS_ID =?   AND    POL_ADDL_STATUS IN ('B05','C05','B06')    ";
		try {

			connection = CommonUtils.getConnection();
			if (!"Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) { // <> 'Y' THEN--ADDED BY SARVINDER

				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91498",
										new Object[] {
												CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE"),
												"Change Status" }));

			}
			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs = new CRUDHandler().executeSelectStatement(query1, connection,
					values);
			if (rs.next()) {
				M_DUMMY1 = rs.getString(1);
			}

			if (CommonUtils.nvl(M_DUMMY1, "N").equals("X")) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91487",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

			/*commented and added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes
			 * 
			 * dummy_bean.setUI_M_PS_STATUS_DT(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.getPOL_ISSUE_DT());*/
			 dummy_bean.setUI_M_PS_STATUS_DT(new CommonUtils().getCurrentDate());
			 /*End*/

			dummy_action.getCOMP_UI_M_PS_STATUS().setDisabled(false);
			dummy_action.getCOMP_UI_M_PS_STATUS_DT().setRequired(true);
			// SHOW_VIEW('PT_IL_POL_STATUS');
			// GO_ITEM('DUMMY.M_PS_STATUS_DT');
			// :DUMMY.M_PS_STATUS := :DUMMY.M_PS_STATUS;

		} catch (Exception e) {
			// TODO: handle exception
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

	public String UI_M_BUT_APPROVAL_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String M_APPRV_STATUS = null;
		String M_CHAR_CODE = null;
		String M_NUM_CODE = null;
		String M_PRO_STDAP_YN = null;
		String M_PR_SSTDAP_YN = null;
		String M_POL_STDAP_YN = null;
		String M_PO_SSTDAP_YN = null;
		Double M_PRO_NUM_VALUE = 0.0;
		Double M_POL_NUM_VALUE = 0.0;

		String M_PREMIUM_WITHIN_LIMIT_YN = null;
		String M_POL_MODE_OF_PYMT = null;
		String M_CODE_DESC = null;
		String M_PS_CODE_DESC = null;
		String M_PS_VALUE = null;
		String M_VALUE = null;
		Double M_SHORT_COLL_VALUE = null;
		Double M_CONT_LC_PROP_DEP_AMT = 0d;
		Double M_FC_FIRST_PREM = 0d;
		Double M_LC_FIRST_PREM = 0d;
		String M_DEP_GROSS_NET_FLAG = null;
		Double M_CONT_LC_POL_DEP_AMT = 0d;

		String M_POL_ADDL_STATUS = null;
		String M_POC_FC_VALUE = null;
		int M_CONT_LC_PROP_DEP_AMT_1 = 0;
		String M_PROD_AGENT_HIRE_YN = null;

		Double M_PMOP_SHORT_RATE = 0d;
		Double M_PMOP_SHORT_RATE_PER = 0d;
		String M_PMOP_TOLL_TYP = null;
		String M_POL_PLAN_CODE = null;
		String M_CLINIC = null;
		Double M_POL_ORG_LC_TOT_SA = 0d;
		Double M_POL_ORG_LC_SUM_ASSURED = 0d;
		Double M_POAD_ORG_LC_THRESHOLD_LMT = 0d;
		Double M_MAX_SSTD_TL = 0d;
		Double M_MAX_STD_TL = 0d;
		Double M_BUT_ENABLE = 0d;
		String M_BREM_ERR_FLAG = null;
		String M_BREM_ERR_FLAG_APP = null;
		String query1 = "SELECT POL_APPRV_STATUS ,POL_ADDL_STATUS FROM PT_IL_POLICY WHERE  POL_SYS_ID = ? AND POL_DS_TYPE = ? ";

		String query2 = "SELECT  ASD_CHAR_VALUE  FROM  PM_IL_APPR_SETUP_DET WHERE  ASD_USER_ID = ?  AND ASD_CODE =  ?  AND "
				+ " ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND  NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";

		String query3 = " SELECT  ASD_NUM_VALUE  FROM PM_IL_APPR_SETUP_DET  WHERE  ASD_USER_ID = ? AND ASD_CODE =  ?  AND "
				+ " ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0')  AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')  ";

		String query4 = " SELECT NVL(CONT_LC_PROP_DEP_AMT,0) - NVL(CONT_LC_PROP_UTIL_AMT,0),"
				+ " NVL(CONT_LC_POL_DEP_AMT,0)  -  NVL(CONT_LC_POL_UTIL_AMT,0) FROM   PM_IL_CONTRACTOR"
				+ " WHERE  CONT_CODE = (SELECT POL_CONT_CODE  FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ? ) ";

		String query5 = " SELECT DEP_GROSS_NET_FLAG  FROM  PT_IL_DEPOSIT  WHERE  DEP_REF_NO  = NVL( ?, ?)"
				+ "  AND  NVL(DEP_REC_REV_YN,'N') = 'N'  AND   DEP_TXN_CODE IS NOT NULL  AND DEP_DOC_NO IS NOT NULL  AND   DEP_DOC_DT IS NOT NULL ";

		String query5a = " SELECT DEP_GROSS_NET_FLAG  FROM   PT_IL_DEPOSIT  WHERE  DEP_REF_NO  = ?  AND    NVL(DEP_REC_REV_YN,'N') = 'N' "
				+ "  AND   DEP_TXN_CODE IS NOT NULL  AND   DEP_DOC_NO IS NOT NULL    AND   DEP_DOC_DT IS NOT NULL";

		String query8 = " SELECT PROD_AGENT_HIRE_YN    FROM   PM_IL_PRODUCT  WHERE PROD_CODE =  ? ";

		String query16 = " SELECT PMOP_SHORT_RATE, PMOP_SHORT_RATE_PER, PMOP_TOLL_TYP FROM  PM_IL_PLAN_MOP"
				+ " WHERE PMOP_PLAN_CODE=?  AND PMOP_TYPE=? ";

		String query10 = " SELECT 'X' FROM  PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID =?  AND  "
				+ " PMED_CLINIC_CODE IS NULL AND   PMED_EXAM_CODE IS NOT NULL  AND   NVL(PMED_DEL_FLAG,'N') <> 'Y' ";

		String query11 = "  SELECT POL_ORG_LC_TOT_SA, POL_ORG_LC_SUM_ASSURED  FROM   PT_IL_POLICY WHERE  POL_SYS_ID =?  ";

		String query12 = " SELECT POAD_ORG_LC_THRESHOLD_LMT    FROM   PT_IL_POL_ASSURED_DTLS   WHERE  POAD_POL_SYS_ID = ? ";

		/*Modified by Ram on 16/11/2016 for enabling Business rule
		 * String query13 = "  SELECT BREM_ERR_FLAG  FROM   PT_BUS_RULE_ERROR_MSG  WHERE  BREM_POL_SYS_ID  = ?   AND    "
				+ " BREM_OVERRIDE_YN = 'N'  AND    BREM_APPLY_LEVEL =?  AND BREM_GRP_ID  = 'IL'";*/
		
		String query13 = "  SELECT BREM_ERR_FLAG  FROM   PT_BUS_RULE_ERROR_MSG  WHERE  BREM_POL_SYS_ID  = ?   AND    "
				+ "     BREM_APPLY_LEVEL =?  AND BREM_GRP_ID  = 'IL'";
		

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		Connection connection = null;
		ResultSet rs13 = null, rs1 = null, rs12 = null, rs5 = null, rs5a = null, rs2 = null, rs3 = null, rs11 = null, rs16 = null, rs10 = null, rs8 = null, rs4 = null,rs14 = null;
		Object[] values = {};
		ArrayList<String> pValList = null;
		ArrayList<String> pValList2 = null;
		ArrayList<OracleParameter> pValOrclList = null;
		DB_Procedures procedures = new DB_Procedures();
		CRUDHandler handler = new CRUDHandler();
		String outcome = null;

		try {
			connection = CommonUtils.getConnection();
			if ("I".equalsIgnoreCase(pt_il_policy_bean.getPOL_APPRV_STATUS())
					|| "W".equalsIgnoreCase(pt_il_policy_bean
							.getPOL_APPRV_STATUS())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91155"));
			}

			if (!CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					1, 2).equals("Y")) {
				if (pt_il_policy_bean.getPOL_DS_TYPE().equals("1")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91137"));
				} else if (pt_il_policy_bean.getPOL_DS_TYPE().equals("2")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71182"));
				}
			}

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(), "T" };
			rs13 = handler.executeSelectStatement(query13, connection, values);
			if (rs13.next()) {
				M_BREM_ERR_FLAG = rs13.getString(1);
				 dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false); 
				 
				M_BUT_ENABLE = 1d;
			} else {
				dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(true);
				/*dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);*/
				M_BUT_ENABLE = 0d;
			}
System.out.println("M_BREM_ERR_FLAG          "+M_BREM_ERR_FLAG);
			if (CommonUtils.nvl(M_BREM_ERR_FLAG, "X").equals("E")) {
				pValList = procedures.callP_VAL_SYSTEM("BUSRUL_STAT", "E",
						dummy_bean.getUI_M_BUS_STATUS(), "N", M_VALUE);
				if (pValList.size() > 0) {
					dummy_bean.setUI_M_BUS_STATUS(pValList.get(0));
					M_VALUE = pValList.get(1);
				}
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "92052",
						new Object[] { "at Transaction level" }));

			} else if (CommonUtils.nvl(M_BREM_ERR_FLAG, "X").equals("W")) {
				pValList = new ArrayList<String>();

				pValList = procedures.callP_VAL_SYSTEM("BUSRUL_STAT", "W",
						dummy_bean.getUI_M_BUS_STATUS(), "N", M_VALUE);
				if (pValList.size() > 0) {
					dummy_bean.setUI_M_BUS_STATUS(pValList.get(0));
					M_VALUE = pValList.get(1);
				}
				
				/*Commented by Ram on 12/12/2016 for Business rule validation control for Warning types
				 * 
				 * throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "92051",
						new Object[] { "at Transaction level" }));
						
						End
						*/
			}

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_FRZ_FLAG(), "N")
					.equals("Y")) {

				new P9ILPK_BUS_RULE().L_VAL_IL_BUS_RULE("IL", "A", CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()));

				values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(), "A" };
				rs13 = handler.executeSelectStatement(query13, connection,
						values);
				if (rs13.next()) {
					M_BREM_ERR_FLAG_APP = rs13.getString(1);
					 dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false); 
					 
					M_BUT_ENABLE = 1d;
				} else if (M_BUT_ENABLE == 0) {
					dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(true);
					/*dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);*/
				}

				if (CommonUtils.nvl(M_BREM_ERR_FLAG_APP, "X").equals("E")) {

					pValList = procedures.callP_VAL_SYSTEM("BUSRUL_STAT", "E",
							dummy_bean.getUI_M_BUS_STATUS(), "N", M_VALUE);
					if (pValList.size() > 0) {
						dummy_bean.setUI_M_BUS_STATUS(pValList.get(0));
						M_VALUE = pValList.get(1);
					}
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "92052",
							new Object[] { "at Approval level" }));

				} else if (CommonUtils.nvl(M_BREM_ERR_FLAG_APP, "X")
						.equals("W")) {
					pValList = new ArrayList<String>();
					pValList = procedures.callP_VAL_SYSTEM("BUSRUL_STAT", "W",
							dummy_bean.getUI_M_BUS_STATUS(), "N", M_VALUE);
					if (pValList.size() > 0) {
						dummy_bean.setUI_M_BUS_STATUS(pValList.get(0));
						M_VALUE = pValList.get(1);
					}

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "92051",
							new Object[] { "at Approval level" }));
				}
			}

			CommonUtils.setGlobalObject("GLOBAL.M_POL_START_DT",
					pt_il_policy_bean.getPOL_START_DT());
			/* Code changes added by PIDUGU RAJ DT:07-08-2018 for PMED_STATUS if waived option selected
			 */
			String query14 =" SELECT PMED_STATUS FROM  PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID=?";
			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs14 = handler.executeSelectStatement(query14, connection, values);
			String pmed_status = null;
			if(rs14 .next()){
			pmed_status = rs14.getString(1);
			System.out.println("Value set for waived is: "+pmed_status);
			}
			if(pmed_status != null && pmed_status.equalsIgnoreCase("NA")){
				
				
				
			}else{

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			rs10 = handler.executeSelectStatement(query10, connection, values);
			if (rs10.next()) {
				M_CLINIC = rs10.getString(1);
			}

			if (CommonUtils.nvl(M_CLINIC, "N").equals("X")) {
				
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Clinic code should be entered for medical examination details" }));
			}
			}
			/*End*/

			if ("E".equalsIgnoreCase(pt_il_policy_bean.getPOL_STATUS())
					&& "2".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE())
					&& pt_il_policy_bean.getPOL_END_NO() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91207"));

			}

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
			String delMED_EXAM_DTL = "   DELETE PT_IL_POL_MED_EXAM_DTL  WHERE  "
					+ " PMED_POL_SYS_ID = ?  AND  NVL(PMED_DEL_FLAG,'N') = 'Y'";
			handler.executeDeleteStatement(delMED_EXAM_DTL, connection, values);

			String delFUND_DTL = "  DELETE FROM PT_IL_POL_FUND_DTL    WHERE "
					+ " POFD_POL_SYS_ID = ?  AND NVL(POFD_DEL_FLAG,'N') = 'Y'";
			handler.executeDeleteStatement(delFUND_DTL, connection, values);

			if ("1".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE())) {

				pValOrclList = new ArrayList<OracleParameter>();
				pValOrclList = pkg_pilt002_apac.IL_FREE_CVR_LMT_CHK(
						pt_il_policy_bean.getPOL_SYS_ID().toString(),
						pt_il_policy_bean.getPOL_END_NO_IDX().toString(),
						pt_il_policy_bean.getPOL_DS_CODE(), pt_il_policy_bean
								.getPOL_DS_TYPE(), pt_il_policy_bean
								.getPOL_CUST_CODE(), pt_il_policy_bean
								.getPOL_CONT_CODE(), pt_il_policy_bean
								.getPOL_PROD_CODE(), pt_il_policy_bean
								.getPOL_MASTER_POL_NO(), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_LC_TOT_SA()), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_7"), null);

				if (pValOrclList.size() > 0) {
					CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
							(String) pValOrclList.get(0).getValueObject());

				}

				pValOrclList.clear();// = new ArrayList<OracleParameter>();
				pValOrclList = pkg_pilt002_apac.IL_PREMIUM_VAL_CAL(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_END_NO_IDX()), pt_il_policy_bean
								.getPOL_END_TYPE(), dummy_bean
								.getUI_M_PROD_PREM_TARIFF(), pt_il_policy_bean
								.getPOL_PLAN_CODE(), CommonUtils
								.getProcedureValue(pt_il_pol_assured_dtls_bean
										.getPOAD_SYS_ID()), dummy_bean
								.getUI_M_COVER_SA_CALC(), pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_FC_MODAL_PREM()));

				if (pValOrclList.size() > 0) {
					pt_il_policy_bean
							.setPOL_FC_MODAL_PREM((Double) (pValOrclList.get(0)
									.getValueObject()));
				}

				pValOrclList.clear();// = new ArrayList<OracleParameter>();
				pValOrclList = new P9ILPK_POLICY().CHECK_LC_PREMIUM_LIMIT(
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_SYS_ID()), M_PREMIUM_WITHIN_LIMIT_YN);

				if (!pValOrclList.isEmpty()) {
					/*
					 *CODE CHANGED BY DHIENSH FOR SSP CALL ID :FALCONLIFE-1344109  ON 30.9.2016 
					 * if (pValOrclList.get(0).getValueObject() != null) {
						M_PREMIUM_WITHIN_LIMIT_YN = (String) pValOrclList
								.get(0).getValueObject();
					}*/
					if (pValOrclList.get(0).getValue() != null) {
						M_PREMIUM_WITHIN_LIMIT_YN = (String) pValOrclList
								.get(0).getValue();
					}
				}

				if (CommonUtils.nvl(M_PREMIUM_WITHIN_LIMIT_YN, "X").equals("N")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91330"));
				}
			}

			//CALC MTHD COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK

			if (dummy_bean.getUI_M_CALC_METHOD() != null
			//&& dummy_bean.getUI_M_CALC_METHOD() == 1
			) {

				if (CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(), "X")
						.equals("M")
						&& CommonUtils.nvl(
								dummy_bean.getUI_M_PROD_PREM_CALC_MTHD(), "Y")
								.equals("X")) {
					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_FC_NET_PREM(),
							0) <= 0
							&& CommonUtils.nvl(pt_il_policy_bean
									.getPOL_END_NO_IDX(), 0) == 0) {

						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91178",
								new Object[] { "Approve" }));
					}
				}

				if ("1".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE())) {
					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_STD_RISK_YN(),
							"N").equals("Y")) {
						values = new Object[] {
								CommonUtils.getControlBean().getM_USER_ID(),
								"PRO_STDAP_YN",
								pt_il_policy_bean.getPOL_PROD_CODE() };

						rs2 = handler.executeSelectStatement(query2,
								connection, values);
						if (rs2.next()) {
							M_PRO_STDAP_YN = rs2.getString(1);
						}

						if (CommonUtils.nvl(M_PRO_STDAP_YN, "N").equals("Y")) {
							values = new Object[] {
									CommonUtils.getControlBean().getM_USER_ID(),
									"PROP_STD_SA",
									pt_il_policy_bean.getPOL_PROD_CODE() };

							rs3 = handler.executeSelectStatement(query3,
									connection, values);
							if (rs3.next()) {
								M_PRO_NUM_VALUE = rs3.getDouble(1);
							}

							if (CommonUtils.nvl(pt_il_policy_bean
									.getPOL_LC_SUM_ASSURED(), 0) > CommonUtils
									.nvl(M_PRO_NUM_VALUE, 0)) {
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91160"));
							}

						} else if (CommonUtils.nvl(M_PRO_STDAP_YN, "N").equals(
								"N")) {

							values = new Object[] { pt_il_policy_bean
									.getPOL_SYS_ID() };
							String updatePolicy = "UPDATE PT_IL_POLICY  SET   POL_ADDL_STATUS ='B20'   WHERE POL_SYS_ID =? ";
							handler.executeUpdateStatement(updatePolicy,
									connection, values);

							//COMMENTED BY AKASH TO MAKE NORMAL FLOW TO WORK.
							// dummy_bean.getUI_M_CALC_METHOD() == 1

							if (dummy_bean.getUI_M_CALC_METHOD() != null
							//&& dummy_bean.getUI_M_CALC_METHOD() == 1
							) {
								values = new Object[] {
										pt_il_policy_bean.getPOL_SYS_ID(),
										pt_il_policy_bean.getPOL_END_NO_IDX(),
										new CommonUtils().getCurrentDate(),
										"B20",
										dummy_bean.getUI_M_PS_REASON_CODE(),
										dummy_bean.getUI_M_PS_REMARKS(),
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										"S",
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										new CommonUtils().getCurrentDate() };

								String insPol_Status = "   INSERT INTO PT_IL_POL_STATUS"
										+ "(PS_POL_SYS_ID, PS_END_NO_IDX, PS_STATUS_DT,"
										+ " PS_STATUS, PS_REASON_CODE, PS_REMARKS,"
										+ " PS_STATUS_UID, PS_STATUS_TYPE, PS_CR_UID, PS_CR_DT)"
										+ " VALUES(?,? ,  ?,?, ?, "
										+ "?,?, ?, ?, ?)";
								handler.executeInsertStatement(insPol_Status,
										connection, values);
							}
							CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
									pt_il_policy_bean.getPOL_SYS_ID());
							new PT_IL_POLICY_HELPER()
									.executeQuery(compositeAction);
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91162"));
						}
					} else if (CommonUtils.nvl(
							pt_il_policy_bean.getPOL_STD_RISK_YN(), "N")
							.equals("N")) {

						values = new Object[] {
								CommonUtils.getControlBean().getM_USER_ID(),
								"PR_TRSS_YN",
								pt_il_policy_bean.getPOL_PROD_CODE() };
						rs2 = handler.executeSelectStatement(query2,
								connection, values);
						if (rs2.next()) {
							M_PR_SSTDAP_YN = rs2.getString(1);
						}

						if (CommonUtils.nvl(M_PR_SSTDAP_YN, "N").equals("Y")) {
							values = new Object[] {
									CommonUtils.getControlBean().getM_USER_ID(),
									"PR_TRSS_SA",
									pt_il_policy_bean.getPOL_PROD_CODE() };
							rs3 = handler.executeSelectStatement(query3,
									connection, values);
							if (rs3.next()) {
								M_PRO_NUM_VALUE = rs3.getDouble(1);
							}

							if (CommonUtils.nvl(pt_il_policy_bean
									.getPOL_LC_SUM_ASSURED(), 0) > CommonUtils
									.nvl(M_PRO_NUM_VALUE, 0)) {
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91161"));
							}

						} else if (CommonUtils.nvl(M_PR_SSTDAP_YN, "N").equals(
								"N")) {
							// --Added by Anamika for changing the status to B20
							// for user not authorise to approve the policy

							values = new Object[] { pt_il_policy_bean
									.getPOL_SYS_ID() };
							String updatePolicy = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS ='B20' WHERE POL_SYS_ID =? ";
							handler.executeUpdateStatement(updatePolicy,
									connection, values);

							//CALC MTHD COMMENTED BY AKASH TO MAKE NORMAL FLOW TO WORK.

							if (dummy_bean.getUI_M_CALC_METHOD() != null
							//&& dummy_bean.getUI_M_CALC_METHOD() == 1
							) {
								values = new Object[] {
										pt_il_policy_bean.getPOL_SYS_ID(),
										pt_il_policy_bean.getPOL_END_NO_IDX(),
										new CommonUtils().getCurrentDate(),
										"B20",
										dummy_bean.getUI_M_PS_REASON_CODE(),
										dummy_bean.getUI_M_PS_REMARKS(),
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										"S",
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										new CommonUtils().getCurrentDate() };

								String insPol_Status = "   INSERT INTO PT_IL_POL_STATUS"
										+ "(PS_POL_SYS_ID, PS_END_NO_IDX, PS_STATUS_DT,"
										+ " PS_STATUS, PS_REASON_CODE, PS_REMARKS,"
										+ " PS_STATUS_UID, PS_STATUS_TYPE, PS_CR_UID, PS_CR_DT)"
										+ " VALUES(?,? ,  ?,?, ?, "
										+ "?,?, ?, ?, ?)";
								handler.executeInsertStatement(insPol_Status,
										connection, values);
							}
							CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
									pt_il_policy_bean.getPOL_SYS_ID());
							new PT_IL_POLICY_HELPER()
									.executeQuery(compositeAction);
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91163"));
						}

						values = new Object[] {
								CommonUtils.getControlBean().getM_USER_ID(),
								"PR_SSTDAP_YN",
								pt_il_policy_bean.getPOL_PROD_CODE() };
						rs2 = handler.executeSelectStatement(query2,
								connection, values);
						if (rs2.next()) {
							M_PR_SSTDAP_YN = rs2.getString(1);
						}

						if (CommonUtils.nvl(M_PR_SSTDAP_YN, "N").equals("Y")) {
							values = new Object[] {
									CommonUtils.getControlBean().getM_USER_ID(),
									"PROP_SSTD_SA",
									pt_il_policy_bean.getPOL_PROD_CODE() };
							rs3 = handler.executeSelectStatement(query3,
									connection, values);
							if (rs3.next()) {
								M_PRO_NUM_VALUE = rs3.getDouble(1);
							}

							if (CommonUtils.nvl(pt_il_policy_bean
									.getPOL_LC_SUM_ASSURED(), 0) > CommonUtils
									.nvl(M_PRO_NUM_VALUE, 0)) {
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91161"));

							} else if (CommonUtils.nvl(M_PR_SSTDAP_YN, "N")
									.equals("N")) {
								// --Added by Anamika for changing the status to
								// B20 for user not authorise to approve the
								// policy
								values = new Object[] { pt_il_policy_bean
										.getPOL_SYS_ID() };
								String updatePolicy = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS ='B20' WHERE POL_SYS_ID =? ";
								handler.executeUpdateStatement(updatePolicy,
										connection, values);

								//CALC METHOD COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK. 

								if (dummy_bean.getUI_M_CALC_METHOD() != null
								//&& dummy_bean.getUI_M_CALC_METHOD() == 1
								) {
									values = new Object[] {
											pt_il_policy_bean.getPOL_SYS_ID(),
											pt_il_policy_bean
													.getPOL_END_NO_IDX(),
											new CommonUtils().getCurrentDate(),
											"B20",
											dummy_bean.getUI_M_PS_REASON_CODE(),
											dummy_bean.getUI_M_PS_REMARKS(),
											CommonUtils
													.getGlobalVariable("GLOBAL.M_USER_ID"),
											"S",
											CommonUtils
													.getGlobalVariable("GLOBAL.M_USER_ID"),
											new CommonUtils().getCurrentDate() };

									String insPol_Status = "INSERT INTO PT_IL_POL_STATUS"
											+ "(PS_POL_SYS_ID, PS_END_NO_IDX, PS_STATUS_DT,"
											+ " PS_STATUS, PS_REASON_CODE, PS_REMARKS,"
											+ " PS_STATUS_UID, PS_STATUS_TYPE, PS_CR_UID, PS_CR_DT)"
											+ " VALUES(?,? ,  ?,?, ?, "
											+ "?,?, ?, ?, ?)";
									handler.executeInsertStatement(
											insPol_Status, connection, values);
								}

								CommonUtils.setGlobalObject(
										"GLOBAL.M_POL_SYS_ID",
										pt_il_policy_bean.getPOL_SYS_ID());
								new PT_IL_POLICY_HELPER()
										.executeQuery(compositeAction);
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91163"));
							}
						}

					}
				} else if ("2".equalsIgnoreCase(pt_il_policy_bean
						.getPOL_DS_TYPE())) {
					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_STD_RISK_YN(),
							"N").equals("Y")) {

						if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0
								&& pt_il_policy_bean.getPOL_END_TYPE().equals(
										"002")) {

							values = new Object[] { pt_il_policy_bean
									.getPOL_SYS_ID() };
							rs12 = handler.executeSelectStatement(query12,
									connection, values);
							if (rs12.next()) {
								M_POAD_ORG_LC_THRESHOLD_LMT = rs12.getDouble(1);
							}

							pValList = new ArrayList<String>();
							pValList = pkg_pilt002_apac
									.P_VAL_ENDT_APPROVAL(CommonUtils
											.getControlBean().getM_USER_ID(),
											"MAX_STD_TL", pt_il_policy_bean
													.getPOL_PROD_CODE(), "1",
											M_MAX_STD_TL + "",
											pt_il_policy_bean.getPOL_END_CODE());

							if (pValList.size() > 0)
								M_MAX_STD_TL = Double.parseDouble(pValList
										.get(0));
							if ((CommonUtils
									.nvl(M_POAD_ORG_LC_THRESHOLD_LMT, 0) + CommonUtils
									.nvl(pt_il_pol_assured_dtls_bean
											.getPOAD_LC_THRESHOLD_LMT(), 0)) > CommonUtils
									.nvl(M_MAX_STD_TL, 0)) {
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91331"));
							}

							pValList = new ArrayList<String>();
							pValList = pkg_pilt002_apac
									.P_VAL_ENDT_APPROVAL(CommonUtils
											.getControlBean().getM_USER_ID(),
											"POL_STDAP_YN", pt_il_policy_bean
													.getPOL_PROD_CODE(), "2",
											M_POL_STDAP_YN, pt_il_policy_bean
													.getPOL_END_CODE());
							if (pValList.size() > 0)
								M_POL_STDAP_YN = pValList.get(0);
						} else {
							values = new Object[] {
									CommonUtils.getControlBean().getM_USER_ID(),
									"POL_STDAP_YN",
									pt_il_policy_bean.getPOL_PROD_CODE() };
							rs2 = handler.executeSelectStatement(query2,
									connection, values);
							if (rs2.next()) {
								M_POL_STDAP_YN = rs2.getString(1);
							}
						}

						if (CommonUtils.nvl(M_POL_STDAP_YN, "N").equals("Y")) {
							if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0) {
								values = new Object[] { pt_il_policy_bean
										.getPOL_SYS_ID() };
								rs11 = handler.executeSelectStatement(query11,
										connection, values);
								if (rs11.next()) {
									M_POL_ORG_LC_TOT_SA = rs11.getDouble(1);
									M_POL_ORG_LC_SUM_ASSURED = rs11
											.getDouble(2);
								}

								ArrayList<String> Pvallist = new ArrayList<String>();
								Pvallist = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(
										CommonUtils.getControlBean()
												.getM_USER_ID(), "POL_STD_SA",
										pt_il_policy_bean.getPOL_PROD_CODE(),
										"1", M_POL_NUM_VALUE + "",
										pt_il_policy_bean.getPOL_END_CODE());
								if(Pvallist.size()>0)
									M_POL_NUM_VALUE = Double.parseDouble(Pvallist.get(0));

								if ((CommonUtils.nvl(M_POL_ORG_LC_TOT_SA, 0) + CommonUtils
										.nvl(pt_il_policy_bean
												.getPOL_LC_SUM_ASSURED(), 0)) > CommonUtils
										.nvl(M_POL_NUM_VALUE, 0.0)) {
									throw new Exception(Messages.getString(
											PELConstants.pelErrorMessagePath,
											"91160"));
								}
							} else {

								values = new Object[] {
										CommonUtils.getControlBean()
												.getM_USER_ID(), "POL_STD_SA",
										pt_il_policy_bean.getPOL_PROD_CODE() };

								rs3 = handler.executeSelectStatement(query3,
										connection, values);
								if (rs3.next()) {
									M_POL_NUM_VALUE = rs3.getDouble(1);
								}

								if (CommonUtils.nvl(pt_il_policy_bean
										.getPOL_LC_SUM_ASSURED(), 0) > CommonUtils
										.nvl(M_POL_NUM_VALUE, 0.0)) {
									throw new Exception(Messages.getString(
											PELConstants.pelErrorMessagePath,
											"91160"));
								}
							}

						} else if (CommonUtils.nvl(M_POL_STDAP_YN, "N").equals(
								"N")) {

							// --Added by Anamika for changing the status to
							// B20 for user not authorise to approve the
							// policy
							values = new Object[] { pt_il_policy_bean
									.getPOL_SYS_ID() };
							String updatePolicy = "UPDATE PT_IL_POLICY  SET POL_ADDL_STATUS ='B20' WHERE POL_SYS_ID = ? ";
							handler.executeUpdateStatement(updatePolicy,
									connection, values);

							//CALC METHOD COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK. 

							if (pt_il_policy_bean.getPOL_DS_TYPE() != null
							//&& dummy_bean.getUI_M_CALC_METHOD() == 1
							) {
								values = new Object[] {
										pt_il_policy_bean.getPOL_SYS_ID(),
										pt_il_policy_bean.getPOL_END_NO_IDX(),
										new CommonUtils().getCurrentDate(),
										"B20",
										dummy_bean.getUI_M_PS_REASON_CODE(),
										dummy_bean.getUI_M_PS_REMARKS(),
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										"S",
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										new CommonUtils().getCurrentDate() };

								String insPol_Status = " INSERT INTO PT_IL_POL_STATUS"
										+ "(PS_POL_SYS_ID, PS_END_NO_IDX, PS_STATUS_DT,"
										+ " PS_STATUS, PS_REASON_CODE, PS_REMARKS,"
										+ " PS_STATUS_UID, PS_STATUS_TYPE, PS_CR_UID, PS_CR_DT)"
										+ " VALUES(?,? ,  ?,?, ?, "
										+ "?,?, ?, ?, ?)";
								handler.executeInsertStatement(insPol_Status,
										connection, values);
							}
							new PT_IL_POLICY_HELPER()
									.executeQuery(compositeAction);
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91162"));

						} else if (CommonUtils.nvl(
								pt_il_policy_bean.getPOL_STD_RISK_YN(), "N")
								.equals("N")) {

							if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0
									&& "002".equals(pt_il_policy_bean
											.getPOL_END_TYPE())) {

								values = new Object[] { pt_il_policy_bean
										.getPOL_SYS_ID() };
								rs12 = handler.executeSelectStatement(query12,
										connection, values);
								if (rs12.next()) {
									M_POAD_ORG_LC_THRESHOLD_LMT = rs12
											.getDouble(1);
								}

								pValList = new ArrayList<String>();
								pValList = pkg_pilt002_apac
										.P_VAL_ENDT_APPROVAL(CommonUtils
												.getControlBean()
												.getM_USER_ID(), "MAX_SSTD_TL",
												pt_il_policy_bean
														.getPOL_PROD_CODE(),
												"1", M_MAX_SSTD_TL + "",
												pt_il_policy_bean
														.getPOL_END_CODE());

								if (pValList.size() > 0)
									M_MAX_SSTD_TL = Double.parseDouble(pValList
											.get(0));
								if ((CommonUtils.nvl(
										M_POAD_ORG_LC_THRESHOLD_LMT, 0) + CommonUtils
										.nvl(pt_il_pol_assured_dtls_bean
												.getPOAD_LC_THRESHOLD_LMT(), 0)) > CommonUtils
										.nvl(M_MAX_SSTD_TL, 0)) {
									throw new Exception(Messages.getString(
											PELConstants.pelErrorMessagePath,
											"91331"));

								}

								pValList = new ArrayList<String>();
								pValList = pkg_pilt002_apac
										.P_VAL_ENDT_APPROVAL(CommonUtils
												.getControlBean()
												.getM_USER_ID(),
												"PO_SSTDAP_YN",
												pt_il_policy_bean
														.getPOL_PROD_CODE(),
												"2", M_PO_SSTDAP_YN,
												pt_il_policy_bean
														.getPOL_END_CODE());

								if (pValList.size() > 0)
									M_PO_SSTDAP_YN = pValList.get(0);
							} else {

								values = new Object[] {
										CommonUtils.getControlBean()
												.getM_USER_ID(),
										"PO_SSTDAP_YN",
										pt_il_policy_bean.getPOL_PROD_CODE() };
								rs2 = handler.executeSelectStatement(query2,
										connection, values);
								if (rs2.next()) {
									M_PO_SSTDAP_YN = rs2.getString(1);
								}
							}

							if (CommonUtils.nvl(M_PO_SSTDAP_YN, "N")
									.equals("Y")) {
								if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0) {

									values = new Object[] { pt_il_policy_bean
											.getPOL_SYS_ID() };
									rs11 = handler.executeSelectStatement(
											query11, connection, values);
									if (rs11.next()) {
										M_POL_ORG_LC_TOT_SA = rs11.getDouble(1);
										M_POL_ORG_LC_SUM_ASSURED = rs11
												.getDouble(2);
									}


									

									pValList2 = new ArrayList<String>();
									pValList2=pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(
													CommonUtils
															.getControlBean()
															.getM_USER_ID(),
													"POL_SSTD_SA",
													pt_il_policy_bean
															.getPOL_PROD_CODE(),
													"1", M_POL_NUM_VALUE + "",
													pt_il_policy_bean
															.getPOL_END_CODE());
									
									if (pValList2.size() > 0)
										M_POL_NUM_VALUE =Double.parseDouble(pValList2.get(0));

									if ("002".equals(pt_il_policy_bean
											.getPOL_END_TYPE())) {
										if ((CommonUtils.nvl(
												M_POL_ORG_LC_TOT_SA, 0) + CommonUtils
												.nvl(
														pt_il_policy_bean
																.getPOL_LC_SUM_ASSURED(),
														0)) > CommonUtils.nvl(
												M_POL_NUM_VALUE, 0.0))

											throw new Exception(
													Messages
															.getString(
																	PELConstants.pelErrorMessagePath,
																	"91161"));
									} else if ("009".equals(pt_il_policy_bean
											.getPOL_END_TYPE())) {
										if ((CommonUtils.nvl(
												M_POL_ORG_LC_SUM_ASSURED, 0) + CommonUtils
												.nvl(
														pt_il_policy_bean
																.getPOL_LC_SUM_ASSURED(),
														0)) > CommonUtils.nvl(
												M_POL_NUM_VALUE, 0.0)) {
											throw new Exception(
													Messages
															.getString(
																	PELConstants.pelErrorMessagePath,
																	"91161"));
										}
									}
								}
							} else {

								values = new Object[] {
										CommonUtils.getControlBean()
												.getM_USER_ID(), "POL_SSTD_SA",
										pt_il_policy_bean.getPOL_PROD_CODE() };

								rs3 = handler.executeSelectStatement(query3,
										connection, values);
								if (rs3.next()) {
									M_POL_NUM_VALUE = rs3.getDouble(1);
								}

								if (CommonUtils.nvl(pt_il_policy_bean
										.getPOL_LC_SUM_ASSURED(), 0) > CommonUtils
										.nvl(M_POL_NUM_VALUE, 0.0)) {
									throw new Exception(Messages.getString(
											PELConstants.pelErrorMessagePath,
											"91161"));
								}
							}
						} else if (CommonUtils.nvl(M_PO_SSTDAP_YN, "N").equals(
								"N")) {
							// --Added by Anamika for changing the status to
							// B20 for user not authorise to approve the
							// policy
							values = new Object[] { pt_il_policy_bean
									.getPOL_SYS_ID() };
							String updatePolicy = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS ='B20' WHERE POL_SYS_ID = ? ";
							handler.executeUpdateStatement(updatePolicy,
									connection, values);

							//CALC METHOD COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK. 

							if (dummy_bean.getUI_M_CALC_METHOD() != null
							//&& dummy_bean.getUI_M_CALC_METHOD() == 1
							) {

								values = new Object[] {
										pt_il_policy_bean.getPOL_SYS_ID(),
										pt_il_policy_bean.getPOL_END_NO_IDX(),
										new CommonUtils().getCurrentDate(),
										"B20",
										dummy_bean.getUI_M_PS_REASON_CODE(),
										dummy_bean.getUI_M_PS_REMARKS(),
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										"S",
										CommonUtils
												.getGlobalVariable("GLOBAL.M_USER_ID"),
										new CommonUtils().getCurrentDate() };

								String insPol_Status = "INSERT INTO PT_IL_POL_STATUS"
										+ "(PS_POL_SYS_ID, PS_END_NO_IDX, PS_STATUS_DT,"
										+ " PS_STATUS, PS_REASON_CODE, PS_REMARKS,"
										+ " PS_STATUS_UID, PS_STATUS_TYPE, PS_CR_UID, PS_CR_DT)"
										+ " VALUES(?,? ,  ?,?, ?, "
										+ "?,?, ?, ?, ?)";
								handler.executeInsertStatement(insPol_Status,
										connection, values);
							}

							new PT_IL_POLICY_HELPER()
									.executeQuery(compositeAction);
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91165"));
						}
					}
					if ("009".equalsIgnoreCase(CommonUtils.nvl(
							pt_il_policy_bean.getPOL_END_TYPE(), "000"))) {
						ArrayList<String> pValLists = new ArrayList<String>();
						pValLists = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(
								CommonUtils.getControlBean().getM_USER_ID(),
								"MAX_REFD_AMT", pt_il_policy_bean
										.getPOL_PROD_CODE(), "1",
								M_POL_NUM_VALUE + "", pt_il_policy_bean
										.getPOL_END_CODE());
						if (pValLists.size() > 0)
							M_POL_NUM_VALUE = Double.parseDouble(pValLists.get(0));

						if (CommonUtils.nvl(pt_il_policy_bean
								.getPOL_FC_FIRST_PREM(), 0.0) > CommonUtils
								.nvl(M_POL_NUM_VALUE, 0.0)) {
							throw new Exception(/*Messages.getString(
									PELConstants.pelErrorMessagePath, "80328",
									new Object[] { CommonUtils.getControlBean()
											.getM_USER_ID() })*/"Refund amount Exceeds maximum limit "+  M_POL_NUM_VALUE);
						}
					}
				}

			}

			if ("1".equalsIgnoreCase(pt_il_policy_bean.getPOL_DS_TYPE())
					|| ("2"
							.equalsIgnoreCase(pt_il_policy_bean
									.getPOL_DS_TYPE()) && "E"
							.equalsIgnoreCase(pt_il_policy_bean.getPOL_STATUS()))
					&& "N".equalsIgnoreCase(pt_il_policy_bean
							.getPOL_STD_RISK_YN())) {

				new P9ILPK_POL_APPROVAL()
						.P_VAL_TREATY_PROP_LIMIT(pt_il_policy_bean
								.getPOL_SYS_ID().toString());
			}

			if (pt_il_policy_bean.getPOL_NO() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Policy Number must be entered" }));
			}

			new P9ILPK_POLICY().P_HLTH_LOAD_CHK(pt_il_policy_bean
					.getPOL_SYS_ID().toString());

			dummy_action.getCOMP_UI_M_ICON_HINT().setRendered(false);

			pkg_pilt002_apac.L_CHECK_FUND_PERC_TOTAL(pt_il_policy_bean
					.getPOL_SYS_ID(), pt_il_policy_bean.getPOL_EXPIRY_DT(),
					dummy_bean.getUI_M_POL_PLAN_TYPE(), dummy_bean
							.getUI_M_PROD_TOPUP_YN());

			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", pt_il_policy_bean
					.getPOL_NO());
			CommonUtils.setGlobalObject("GLOBAL.M_POL_ISSUE_DT",
					pt_il_policy_bean.getPOL_ISSUE_DT());
			CommonUtils.setGlobalVariable("GLOBAL.M_PROCESS_TYPE", CommonUtils
					.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_8"),
							"NO"));
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
					pt_il_policy_bean.getPOL_SYS_ID());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_PROD_CODE",
					pt_il_policy_bean.getPOL_PROD_CODE());
			CommonUtils.setGlobalObject("GLOBAL.POL_FC_FIRST_PREM",
					pt_il_policy_bean.getPOL_FC_FIRST_PREM());

			// Modified below code to inc frz flag and complete status
			if ("1".equals(pt_il_policy_bean.getPOL_DS_TYPE())) {

				//ADDED BY AKASH TO MAKE NORMAL FLOW TO WORK.

				if (dummy_bean.getUI_M_CALC_METHOD() == 1
						|| dummy_bean.getUI_M_CALC_METHOD() == 2) {
					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_FRZ_FLAG(),
							"N").equals("Y")
							&& (CommonUtils.nvl(
									pt_il_policy_bean.getPOL_ADDL_STATUS(),
									"001").equals("B08")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B12")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B13")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B14")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B15")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B16")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("C01")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("C08")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B07")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("N01")
									|| CommonUtils.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("W01") || CommonUtils
									.nvl(
											pt_il_policy_bean
													.getPOL_ADDL_STATUS(),
											"001").equals("B20"))) {

						if (CommonUtils.nvl(dummy_bean
								.getUI_M_CSVSD_PARA_VALUE(), 0) == 1
								&& CommonUtils.nvl(
										dummy_bean.getUI_M_COVER_FUND_TYPE(),
										"X").equals("B")
								&& CommonUtils.nvl(
										dummy_bean.getUI_M_COVER_FUND_MTHD(),
										"X").equals("T")
								&& pt_il_policy_bean.getPOL_HEALTH_RATE() == null) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91419"));
						}
						outcome = "PILP001_APAC";
						CommonUtils.setGlobalVariable("CALLING_FORM",
								"PILP001_APAC");
						CommonUtils
								.setGlobalVariable("CALLING", "PILT002_APAC");
						return outcome;
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91155"));
					}
				} else {
					CommonUtils.setGlobalVariable("CALLING_FORM",
							"PILP001_APAC");
					CommonUtils.setGlobalVariable("CALLING", "PILT002_APAC");
					return outcome = "PILP001_APAC";
				}
			} else {
				if ("002".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {
					new P9ILPK_RI_ALLOC().P_CHK_TTY_LIMIT(pt_il_policy_bean
							.getPOL_SYS_ID().toString());
				}
			}
			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0) {

				ArrayList<String> list = procedures.callP_VAL_SYSTEM(
						"IL_TOLL_TYPE", "IL_TOLL_TYPE", M_PS_CODE_DESC, "N",
						M_PS_VALUE);
				if (list != null && !list.isEmpty()) {
					M_PS_CODE_DESC = list.get(0);
					M_PS_VALUE = list.get(1);
				}

				ArrayList<String> list1 = procedures.callP_VAL_SYSTEM(
						"IL_SHORT_COL",
						pt_il_policy_bean.getPOL_MODE_OF_PYMT(), M_CODE_DESC,
						"N", M_VALUE);

				if (list1 != null && !list1.isEmpty()) {
					M_CODE_DESC = list1.get(0);
					M_VALUE = list1.get(1);
				}

				if (M_PS_VALUE != null && Integer.parseInt(M_PS_VALUE) == 1) {
					M_SHORT_COLL_VALUE = (CommonUtils.nvl(pt_il_policy_bean
							.getPOL_FC_FIRST_PREM(), 0) * CommonUtils.nvl(
							Double.parseDouble(M_VALUE), 0)) / 100;
				} else {
					M_SHORT_COLL_VALUE = CommonUtils.nvl(Double
							.parseDouble(M_VALUE), 0);
				}

				M_POL_PLAN_CODE = pt_il_policy_bean.getPOL_PLAN_CODE();
				M_POL_MODE_OF_PYMT = pt_il_policy_bean.getPOL_MODE_OF_PYMT();

				values = new Object[] { M_POL_PLAN_CODE, M_POL_MODE_OF_PYMT };
				rs16 = handler.executeSelectStatement(query16, connection,
						values);
				if (rs16.next()) {
					M_PMOP_SHORT_RATE = rs16.getDouble(1);
					M_PMOP_SHORT_RATE_PER = rs16.getDouble(2);
					M_PMOP_TOLL_TYP = rs16.getString(3);
				}

				if ("P".equalsIgnoreCase(M_PMOP_TOLL_TYP)) {
					M_SHORT_COLL_VALUE = (CommonUtils.nvl(pt_il_policy_bean
							.getPOL_FC_FIRST_PREM(), 0) * (CommonUtils.nvl(
							M_PMOP_SHORT_RATE, 0) / CommonUtils.nvl(
							M_PMOP_SHORT_RATE_PER, 0)));
				} else {
					M_SHORT_COLL_VALUE = CommonUtils.nvl(M_PMOP_SHORT_RATE, 0);
				}

				values = new Object[] { pt_il_policy_bean.getPOL_PROP_NO(),
						pt_il_policy_bean.getPOL_NO() };
				rs5 = handler
						.executeSelectStatement(query5, connection, values);
				if (rs5.next()) {
					M_DEP_GROSS_NET_FLAG = rs5.getString(1);
				}

				if (M_DEP_GROSS_NET_FLAG == null) {
					values = new Object[] { pt_il_policy_bean.getPOL_NO() };
					rs5a = handler.executeSelectStatement(query5a, connection,
							values);

					if (rs5a.next()) {
						M_DEP_GROSS_NET_FLAG = rs5a.getString(1);
					}
				}

				values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
				rs8 = handler
						.executeSelectStatement(query8, connection, values);
				if (rs8.next()) {
					M_PROD_AGENT_HIRE_YN = rs8.getString(1);
				}

				if (CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(), "0")
						.equals("M")
						&& CommonUtils.nvl(
								dummy_bean.getUI_M_PROD_PREM_CALC_MTHD(), "T")
								.equals("X")) {

					pkg_pilt002_apac.L_GET_FIRST_PREM(pt_il_policy_bean
							.getPOL_SYS_ID().toString(), M_DEP_GROSS_NET_FLAG,
							pt_il_policy_bean.getPOL_PROD_CODE(), CommonUtils
									.getProcedureValue(M_FC_FIRST_PREM),
							CommonUtils.getProcedureValue(M_LC_FIRST_PREM),
							null, null, null, null, null, null, null, null);

				} else if ((CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
						"0").equals("M") && CommonUtils.nvl(
						dummy_bean.getUI_M_PROD_PREM_CALC_MTHD(), "T").equals(
						"T"))
						|| !CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
								"0").equals("M")
						&& "N".equalsIgnoreCase(M_PROD_AGENT_HIRE_YN)) {
					new P9ILPK_POLICY().P_GET_FIRST_PREM(pt_il_policy_bean
							.getPOL_PROP_SYS_ID().toString(),
							M_DEP_GROSS_NET_FLAG, CommonUtils
									.getProcedureValue(M_FC_FIRST_PREM),
							CommonUtils.getProcedureValue(M_LC_FIRST_PREM));
				} else {
					M_FC_FIRST_PREM = CommonUtils.nvl(pt_il_policy_bean
							.getPOL_FC_FIRST_PREM(), 0.0);
					M_LC_FIRST_PREM = CommonUtils.nvl(pt_il_policy_bean
							.getPOL_LC_FIRST_PREM(), 0.0);
				}

				values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };
				rs4 = handler
						.executeSelectStatement(query4, connection, values);

				if (rs4.next()) {
					M_CONT_LC_PROP_DEP_AMT = rs4.getDouble(1);
					M_CONT_LC_POL_DEP_AMT = rs4.getDouble(2);
				}

				/*if (CommonUtils.nvl(M_CONT_LC_PROP_DEP_AMT, 0) == 0) {
					if (CommonUtils.nvl(M_CONT_LC_POL_DEP_AMT, 0) >= CommonUtils
							.nvl(M_FC_FIRST_PREM, 0)
							|| (CommonUtils.nvl(M_CONT_LC_POL_DEP_AMT, 0)
									+ CommonUtils.nvl(M_SHORT_COLL_VALUE, 0) >= CommonUtils
									.nvl(M_FC_FIRST_PREM, 0))) {
						outcome = "PILP002_APAC";
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91151"));
					}
				} else { // -- PROPOSAL DEPOSIT AMOUNT NOT EQUAL TO ZERO

					if (CommonUtils.nvl(M_CONT_LC_PROP_DEP_AMT, 0)
							+ CommonUtils.nvl(M_CONT_LC_POL_DEP_AMT, 0) >= CommonUtils
							.nvl(M_FC_FIRST_PREM, 0)
							|| (CommonUtils.nvl(M_CONT_LC_PROP_DEP_AMT, 0)
									+ CommonUtils.nvl(M_SHORT_COLL_VALUE, 0) >= CommonUtils
									.nvl(M_FC_FIRST_PREM, 0))) {
						outcome = "PILP002_APAC";
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91151"));
					}
				}*/
				outcome = "PILP002_APAC";
			} else {
				outcome = "PILP002_APAC";
			}
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILP002_APAC");

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(),
					pt_il_policy_bean.getPOL_DS_TYPE() };
			rs1 = handler.executeSelectStatement(query1, connection, values);

			if (rs1.next()) {
				M_APPRV_STATUS = rs1.getString(1);
				M_POL_ADDL_STATUS = rs1.getString(2);
			}

			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N") != CommonUtils
					.nvl(M_APPRV_STATUS, "N")
					|| (CommonUtils.nvl(pt_il_policy_bean.getPOL_ADDL_STATUS(),
							"X") != CommonUtils.nvl(M_POL_ADDL_STATUS, "0"))) {

				CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
						pt_il_policy_bean.getPOL_SYS_ID());
				pkg_pilt002_apac.IL_BLOCK_POL_ENABLED(compositeAction);
				new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
			}
			CommonUtils.setGlobalVariable("CALLING", "PILT002_APAC");
			// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return outcome;
	}

	public void UI_M_BUT_POL_AMDT_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		PT_IL_POLICY_HELPER pt_il_policy_helper = new PT_IL_POLICY_HELPER();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String M_NEW_POL_SYS_ID = null;
		String M_POL_AMEND_IDX = null;
		String query1 = "SELECT  MAX(POL_END_NO_IDX)  FROM    PT_IL_POLICY"
				+ "   WHERE   POL_NO = ?    ";
		try {


			/*Added by ganesh on 14-04-2017 for amendment functionality */
			connection = CommonUtils.getConnection();			
			
			
			values = new Object[] { pt_il_policy_bean.getPOL_NO() };
			rs = new CRUDHandler().executeSelectStatement(query1, connection,
					values);
			while (rs.next()) {
				M_POL_AMEND_IDX = rs.getString(1);
			}
			/*Modifed by Ganesh on 14/04/2017
			 * 
			 * pValList = p9ilpk_policy.COPY_POLICY(pt_il_policy_bean
					.getPOL_SYS_ID().toString(), pt_il_policy_bean.getPOL_NO(),
					(M_POL_AMEND_IDX + 1), "N", "Y", "Y", "Y", "Y", "Y", "Y",
					"Y", "Y", "Y", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_UW_YEAR()), new CommonUtils()
							.getCurrentDate().toString(), "A",
					M_NEW_POL_SYS_ID, "Y");*/
			
			pValList = p9ilpk_policy.COPY_POLICY(pt_il_policy_bean
					.getPOL_SYS_ID().toString(), pt_il_policy_bean.getPOL_NO(),
					(M_POL_AMEND_IDX + 1), "N", "Y", "Y", "Y", "Y", "Y", "Y",
					"Y", "Y", "Y", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_UW_YEAR()), CommonUtils.getDateAsStringForOracleProcedureCall(new CommonUtils().getCurrentDate()), "A",
					M_NEW_POL_SYS_ID, "Y");
			if (pValList.size() > 0)
				M_NEW_POL_SYS_ID = pValList.get(0).getValue();

			/*
			 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE; RAISE
			 * FORM_TRIGGER_FAILURE; END;
			 */

			String insQuery = "INSERT INTO PT_IL_POL_STATUS(PS_POL_SYS_ID,"
					+ "  PS_END_NO_IDX,  PS_STATUS_DT,  PS_STATUS,     PS_STATUS_UID,"
					+ "  PS_CR_UID, PS_CR_DT, PS_STATUS_TYPE)"
					+ "   VALUES(?,? ,?,?," + "  ?,  ?,    ?, ?)";

			values = new Object[] { M_NEW_POL_SYS_ID, (M_POL_AMEND_IDX + 1),
					new CommonUtils().getCurrentDate(), "001",
					CommonUtils.getControlBean().getM_USER_ID(),
					CommonUtils.getControlBean().getM_USER_ID(),
					new CommonUtils().getCurrentDate(), "S" };

			CommonUtils.setGlobalVariable("GLOBAL.M_GLOBAL_POL_SYS_ID",
					M_NEW_POL_SYS_ID);
			// CLEAR_BLOCK(NO_VALIDATE);
			// GO_BLOCK('PT_IL_POLICY');
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", CommonUtils
					.getGlobalVariable("GLOBAL.M_GLOBAL_POL_SYS_ID"));
			pt_il_policy_helper.executeQuery(compositeAction);
			// :PT_IL_POLICY.POL_REMARKS := :PT_IL_POLICY.POL_REMARKS;

		} catch (Exception e) {
			// TODO: handle exception
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

	public void UI_M_BUT_CALC_DISC_LOAD_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		ArrayList<String> pValList = new ArrayList<String>();
		// POST PENDING
		try {
			connection = CommonUtils.getConnection();
			if (!CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N")
					.equals("A")
					&& CommonUtils
							.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0) {

				if (pt_il_policy_bean.getROWID() != null) {
					/*
					 * COPY('20','SYSTEM.MESSAGE_LEVEL');
					 * COPY('P','CTRL.M_COMM_DEL') ; POST;
					 * COPY('0','SYSTEM.MESSAGE_LEVEL');
					 * COPY('','CTRL.M_COMM_DEL') ;
					 */
				}
				p9ilpk_policy
						.P_INS_DISC_LOAD(pt_il_policy_bean.getPOL_PROD_CODE(),
								pt_il_policy_bean.getPOL_SYS_ID().toString(),
								CommonUtils.getProcedureValue(pt_il_policy_bean
										.getPOL_START_DT()));

				/*
				 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE; RAISE
				 * FORM_TRIGGER_FAILURE; END;
				 */
				/*
				 * GO_BLOCK('PT_IL_POL_DISC_LOAD');
				 * COPY('20','SYSTEM.MESSAGE_LEVEL');
				 */
				// new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
				// COPY('0','SYSTEM.MESSAGE_LEVEL');
			}

		} catch (Exception e) {
			// TODO: handle exception
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

	public String UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String outcome = null;
		Date M_DATE = null;
		Date M_START_DT = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		ResultSet rs6 = null;
		ResultSet rs7 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		int M_SURR_YRS = 0;
		String M_POL_MODE_OF_PYMT = null;
		String M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_VALUE = null;
		String M_PLAN_TYPE = null;
		String M_ENDT_PS_VALUE = null;
		int M_PROD_COOLOFF_DAYS = 0;
		int M_NO_OF_DAYS = 0;
		int M_NO_OF_PAY = 0;
		String M_END_CODE = null;
		String M_USER_PERM = null;
		String M_DS_AGE_RECALC_YN = null;
		String M_TEMP = null;
		ResultSet rs8 = null;
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		PT_IL_POLICY_HELPER pt_il_policy_helper = new PT_IL_POLICY_HELPER();
		String SURR_YRS = "SELECT NVL(PLAN_SURR_YRS, 0),PLAN_TYPE "
				+ "FROM   PM_IL_PLAN " + "WHERE  PLAN_CODE = ? ";

		String C1 = "SELECT PLAN_SURR_YRS " + "FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE = ? ";

		String C2 = "SELECT DISTINCT 'X' " + "FROM   PT_IL_SURR_MAT_VALUES "
				+ "WHERE  SMV_POL_SYS_ID = ? " + "AND    SMV_TYPE  ='R'";

		String C3 = "SELECT NVL(DS_AGE_RECALC_YN,'N') "
				+ "FROM   PM_IL_DOC_SETUP " + "WHERE  DS_CODE = ? ";

		String C4 = "SELECT TRUNC(?)-TRUNC(?) " + "FROM   DUAL ";

		String C5 = "SELECT COUNT(PC_SYS_ID) " + "FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID = ? "
				+ "AND    PC_PAID_DT IS NOT NULL " + "AND    PC_PAID_FLAG='A' ";

		String C6 = "SELECT PROD_COOLOFF_DAYS " + "FROM   PM_IL_PRODUCT "
				+ "WHERE  PROD_CODE = ? ";

		String C7 = "SELECT PS_CODE " + "FROM   PP_SYSTEM "
				+ "WHERE  PS_TYPE='IL_REP_CANCL' ";
		String M_REINSTATE = null;

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<String> pValList = new ArrayList<String>();
		ArrayList<OracleParameter> pValList8 = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		PILT002_APAC_LOCAL_PROCEDURES pilt002_apac_local_procedures = new PILT002_APAC_LOCAL_PROCEDURES();

 /*Added by Janani on 12.04.2018 for KIC as suggested by Gaurav*/
		
		String C8 = "SELECT PROD_REG_EXCESS_APP_YN FROM PM_IL_PRODUCT WHERE PROD_CODE= ?";
		ResultSet rs9 = null;
		String PROD_REG_EXCESS_APP_YN = null;
		/*End*/
		
		
		/*Added by Janani on 04.05.2018 for Fidelity endorsement setup issue as suggested by Sivaram*/
		
		String C9 = "SELECT DS_TYPE FROM PM_IL_DOC_SETUP WHERE DS_CODE = ?";
		ResultSet rs10 = null;
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		BigDecimal END_NUM_PTRN = null;
		ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();
		String ds_type= null;
		
		/*End*/
		
		try {
			System.out.println("********  ENTER THE UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED ***************");
			con = CommonUtils.getConnection();
		
			 /*Added by Janani on 12.04.2018 for KIC as suggested by Gaurav*/
			
			rs8 = handler.executeSelectStatement(C8, con, new Object[] {pt_il_policy_bean.getPOL_PROD_CODE()});

			if (rs8.next()) {
				 PROD_REG_EXCESS_APP_YN = rs8.getString(1);
			}
			
			
			if("N".equalsIgnoreCase(CommonUtils.nvl(PROD_REG_EXCESS_APP_YN, "N")))
			
			{
				if(pt_il_policy_bean.getPOL_END_CODE() != null && pt_il_policy_bean.getPOL_END_CODE().equalsIgnoreCase("EXCESS-PREM") )
				{
					throw new Exception("Not a valid Endorsement");
				}
			}
			
			/*End*/
			
			
			if (("D".equalsIgnoreCase(pt_il_policy_bean.getPOL_STATUS()) || "S"
					.equalsIgnoreCase(pt_il_policy_bean.getPOL_STATUS()))
					&& "A".equalsIgnoreCase(pt_il_policy_bean
							.getPOL_APPRV_STATUS())) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"3206",
										new Object[] { "Endorsement Not Possible for the Death Claim/Surrender Policy" }));
			}

			//newly added to check deposit amount > unpaid during revival endorsement 
			if ("006".equalsIgnoreCase(pt_il_policy_bean.getPOL_END_TYPE())) {

				pValList8 = pkg_pilt002_apac.P_VALIDATE_DEP(pt_il_policy_bean
						.getPOL_SYS_ID(), pt_il_policy_bean
						.getPOL_END_EFF_FROM_DT(), null);
				if (!pValList8.isEmpty()) {
					M_REINSTATE = pValList8.get(0).getValueObject().toString();
				}
				if ("N".equalsIgnoreCase(M_REINSTATE)) {
					throw new Exception(
							"No sufficient Deposit amount Endorsement cannot be Processed");
				}
			}

			// SET_APPLICATION_PROPERTY(CURSOR_STYLE,'BUSY');
			if ("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if (pt_il_policy_bean.getPOL_END_EFF_FROM_DT() == null) {
					// SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT');
					throw new Exception("Please enter the Eff From Date !!");
					// DISP_ALERT ('Please enter the Eff From Date !!');
					// GO_ITEM ('PT_IL_POLICY.POL_END_EFF_FROM_DT');
				}
				Object[] c2values = { pt_il_policy_bean.getPOL_SYS_ID() };
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if ("X".equalsIgnoreCase(M_DUMMY)) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Survival Benefits already paid for the Policy" }));
				}
				pValList = new ArrayList<String>();

				pValList = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(CommonUtils
						.getControlBean().getM_USER_ID(), "FAC_YN",
						pt_il_policy_bean.getPOL_PROD_CODE(), "2", M_USER_PERM,
						pt_il_policy_bean.getPOL_END_CODE());
				if (!pValList.isEmpty() && pValList.get(0) != null)
					M_USER_PERM = pValList.get(0);

				if ("N".equalsIgnoreCase(M_USER_PERM)) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_FAC_YN().setDisabled(false);
				} else {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_FAC_YN().setDisabled(false);
				}
			}
			Object[] values = { pt_il_policy_bean.getPOL_PLAN_CODE() };
			rs = handler.executeSelectStatement(SURR_YRS, con, values);

			while (rs.next()) {
				M_ENDT_PS_VALUE = rs.getString(1);
				M_PLAN_TYPE = rs.getString(2);
			}
			pValList = new ArrayList<String>();
			pValList = DBProcedures.P_VAL_SYSTEM("IL_ENDEXCHRT",
					"IL_ENDEXCHRT", M_DUMMY1, "N", M_PS_VALUE);
			if (!pValList.isEmpty()) {
				M_DUMMY1 = pValList.get(0);
				M_PS_VALUE = pValList.get(1);
			}

			if (!("1".equalsIgnoreCase(M_PS_VALUE))) {

				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(CommonUtils
						.getProcedureValue(pt_il_policy_bean
								.getPOL_SA_CURR_CODE()), CommonUtils
						.getProcedureValue(dummyBean.getUI_M_BUY_SELL()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_END_DT()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_SA_EXCH_RATE()), "E");
				if (!pValList.isEmpty())
					pt_il_policy_bean.setPOL_SA_EXCH_RATE(Double
							.parseDouble(pValList.get(0)));

				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_GET_EXCHANGE_RATE(CommonUtils
						.getProcedureValue(pt_il_policy_bean
								.getPOL_CUST_CURR_CODE()), CommonUtils
						.getProcedureValue(dummyBean.getUI_M_BUY_SELL()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_END_DT()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_CUST_EXCH_RATE()), "E");
				if (!pValList.isEmpty())
					pt_il_policy_bean.setPOL_CUST_EXCH_RATE(Double
							.parseDouble(pValList.get(0)));

			}

			if ("A".equalsIgnoreCase(pt_il_policy_bean.getPOL_APPRV_STATUS())) {
				if ("001".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getCOMP_POL_FLEX_03().setDisabled(false);
					if ("Y".equals(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getCOMP_POL_FLEX_03().setDisabled(false);
					}
					if ("Y".equals(CommonUtils.getGlobalVariable(
							"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getCOMP_POL_FLEX_03().setDisabled(false);
					}
					pt_il_policy_bean.setPOL_STATUS("E");
					pt_il_policy_bean.setPOL_FRZ_FLAG("N");
					//pt_il_policy_bean.setPOL_APPRV_STATUS("N");
					pilt002_apac_local_procedures
							.IL_ENDT_001_CHANGES(compositeAction);
				}
			} else {
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_FLEX_03().setDisabled(true);
			}
			if (("011".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000")))) {
				pt_il_policy_bean.setPOL_STATUS("E");
			}
			if (("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000")))) {
				if ("M".equalsIgnoreCase(CommonUtils.nvl(dummyBean
						.getUI_M_POL_PLAN_TYPE(), "X"))
						&& (CommonUtils.nvl(dummyBean.getUI_M_IL_RED_SA_END(),
								"000")).equalsIgnoreCase(CommonUtils.nvl(
								pt_il_policy_bean.getPOL_END_CODE(), "000"))) {
					pt_il_policy_bean.setPOL_FRZ_FLAG("Y");
				} else {
					pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				}
				pt_il_policy_bean.setPOL_STATUS("E");
				pilt002_apac_local_procedures
						.IL_ENDT_002_CHANGES(compositeAction);
			}

			if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					|| "013".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				pt_il_policy_bean.setPOL_STATUS("E");
				pilt002_apac_local_procedures
						.IL_ENDT_012_CHANGES(compositeAction);
			}
			if ("015".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				pt_il_policy_bean.setPOL_STATUS("E");
				pilt002_apac_local_procedures
						.IL_ENDT_015_CHANGES(compositeAction);
			}
			if ("016".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				pt_il_policy_bean.setPOL_STATUS("E");
				pilt002_apac_local_procedures
						.IL_ENDT_016_BLK_DISABLE(compositeAction);
			}
			/*Added by Janani on 12.04.2018 for KIC as suggested by Gaurav*/
			if ("021".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				pt_il_policy_bean.setPOL_STATUS("E");
				
			}
			/*End*/
			
			if ("007".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if ("S".equals(pt_il_policy_bean.getPOL_MODE_OF_PYMT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91105"));
				}

				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				pt_il_policy_bean.setPOL_STATUS("E");
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(
						false);

				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(
							false);
					pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE()
							.setDisabled(false);
				}
			}

			pt_il_policy_bean.setPOL_END_NO_IDX(CommonUtils.nvl(
					pt_il_policy_bean.getPOL_END_NO_IDX(), 0) + 1);
			pt_il_policy_bean.setPOL_APPRV_STATUS("N");
			String POL_END_TYPE = CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000");
			if ("001".equalsIgnoreCase(POL_END_TYPE)
					|| "002".equalsIgnoreCase(POL_END_TYPE)
					|| "012".equalsIgnoreCase(POL_END_TYPE)
					|| "013".equalsIgnoreCase(POL_END_TYPE)
					|| "015".equalsIgnoreCase(POL_END_TYPE)
					|| "016".equalsIgnoreCase(POL_END_TYPE)
					|| "020".equalsIgnoreCase(POL_END_TYPE)) {

				// IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
				if (pt_il_policy_bean.getROWID() != null) {
					savePolicy(pt_il_policy_bean);
					/*
					 * COPY('P','CTRL.M_COMM_DEL') ; POST;
					 * COPY('','CTRL.M_COMM_DEL') ;
					 */
				}
				if ("001".equalsIgnoreCase(POL_END_TYPE)) {

					/*Added by Janani on 13.03.2018 for FSD_FLA_IL_008*/
					
					String end_code = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getChkEndCode();

					System.out.println("getPOL_END_CODE               "+pt_il_policy_bean.getPOL_END_CODE()+"   end_code     "+end_code);
					
					/*Modified by Janani for null issue on 04.05.2018 for fidelity*/
					
					/*if (pt_il_policy_bean.getPOL_END_CODE() != null && 
							end_code.equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE())) {*/

					if (pt_il_policy_bean.getPOL_END_CODE() != null && (end_code != null && 
							end_code.equalsIgnoreCase(pt_il_policy_bean.getPOL_END_CODE()))) {
						
						/*End*/

						new P9ILPK_ENDORSE().P_TRANS_ORG_FIELDS(CommonUtils
								.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()));

					}
					else
					{
					
					/*End of FSD_FLA_IL_008*/
					
					new P9ILPK_ENDORSE().P_TRANS_CHG_ORG_TRAN(pt_il_policy_bean
							.getPOL_SYS_ID());
					new P9ILPK_POLICY().P_INS_POL_CHARGES(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()));

					new P9ILPK_POLICY().P_INS_POL_DOLIST(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), null, "N", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()));
					
					}
					/*
					 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
					 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
					 * FORM_TRIGGER_FAILURE; END;
					 */
				} else if ("016".equalsIgnoreCase(POL_END_TYPE)) {
					// BEGIN

					new P9ILPK_POLICY().P_INS_POL_DOLIST(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), null, "N", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()));

					/*
					 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
					 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
					 * FORM_TRIGGER_FAILURE; END ;
					 */

				} else {

					/*
					 * new
					 * CRUDHandler().executeInsert(pt_il_policy_action.getPT_IL_POLICY_BEAN(),CommonUtils.getConnection());
					 * CommonUtils.getConnection().commit();
					 */
					savePolicy(pt_il_policy_bean);
					new P9ILPK_ENDORSE().P_TRANS_ORG_FIELDS(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()));
					new P9ILPK_POLICY().P_INS_POL_CHARGES(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()));
					new P9ILPK_POLICY().P_INS_POL_DOLIST(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()), null, "N", CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_START_DT()));
					/*
					 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
					 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
					 * FORM_TRIGGER_FAILURE; END;
					 */
				}
				outcome = "PILT002_APAC_PT_IL_POLICY";
				// PENDING
				// CHK_PKG_FAILURE;
				CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID",
						pt_il_policy_bean.getPOL_SYS_ID());
				pilt002_apac_local_procedures
						.IL_BLOCK_POL_ENABLED(compositeAction);
				// CommonUtils.getConnection().commit();
				new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
				pt_il_policy_bean = compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			}

			// SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT');

			if ("006".equalsIgnoreCase(POL_END_TYPE)
					|| "007".equalsIgnoreCase(POL_END_TYPE)
					|| "010".equalsIgnoreCase(POL_END_TYPE)
					|| "020".equalsIgnoreCase(POL_END_TYPE)) {
				// IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
				if (pt_il_policy_bean.getROWID() != null) {

					savePolicy(pt_il_policy_bean);
					/*
					 * COPY('P','CTRL.M_COMM_DEL') ; POST;
					 * COPY('','CTRL.M_COMM_DEL') ;
					 */
				}
				if ("007".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {

					new P9ILPK_ENDORSE().P_TRANS_ORG_FIELDS_007(CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_SYS_ID()));
					/*
					 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
					 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
					 * FORM_TRIGGER_FAILURE; END;
					 */
				} else if ("006".equalsIgnoreCase(POL_END_TYPE)
				//confirmed by joy it is commented
				/*|| "020".equalsIgnoreCase(POL_END_TYPE)*/) {
					new P9ILPK_ENDORSE().P_TRANS_CHG_ORG_TRAN(pt_il_policy_bean
							.getPOL_SYS_ID());
				}

				new P9ILPK_POLICY().P_INS_POL_CHARGES(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_START_DT()));
				new P9ILPK_POLICY().P_INS_POL_DOLIST(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						null, "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_START_DT()));
				/*
				 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
				 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
				 * FORM_TRIGGER_FAILURE; END;
				 */
				if (((CommonUtils.nvl(pt_il_policy_bean.getPOL_END_TYPE(),
						"000").equalsIgnoreCase("020")) || (CommonUtils.nvl(
						pt_il_policy_bean.getPOL_END_TYPE(), "000")
						.equalsIgnoreCase("006")))
						&& CommonUtils.nvl(
								pt_il_policy_bean.getPOL_ADDL_STATUS(), "N")
								.equalsIgnoreCase("L02")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "92288",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
					//STD_MESSAGE_ROUTINE(92288,NAME_IN('GLOBAL.M_LANG_CODE'));*/
				}

				outcome = "PILT002_APAC_PT_IL_POLICY";// GO_BLOCK('PT_IL_POLICY')
				// ;
				// CHK_PKG_FAILURE;

				CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
						pt_il_policy_bean.getPOL_SYS_ID().toString());
				pilt002_apac_local_procedures
						.IL_BLOCK_POL_ENABLED(compositeAction);
				new PT_IL_POLICY_HELPER().executeQuery(compositeAction);

				/*
				 * :SYSTEM.MESSAGE_LEVEL := '10'; IL_BLOCK_POL_ENABLED;
				 * EXECUTE_QUERY; :SYSTEM.MESSAGE_LEVEL := '0';
				 */

			}
			// SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT');
			if ("011".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if (pt_il_policy_bean.getROWID() != null) {
					// IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
					/*
					 * COPY('P','CTRL.M_COMM_DEL') ; POST;
					 * COPY('','CTRL.M_COMM_DEL') ;
					 */
				}
				new P9ILPK_POLICY().P_INS_POL_DOLIST(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						null, "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_START_DT()));

				/*
				 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
				 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
				 * FORM_TRIGGER_FAILURE; END;
				 */
				outcome = "PILT002_APAC_PT_IL_POLICY";// GO_BLOCK('PT_IL_POLICY')
				// ;
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
						pt_il_policy_bean.getPOL_SYS_ID().toString());
				pilt002_apac_local_procedures
						.IL_BLOCK_POL_ENABLED(compositeAction);
				new PT_IL_POLICY_HELPER().executeQuery(compositeAction);

				/*
				 * CHK_PKG_FAILURE; :GLOBAL.M_POL_SYS_ID :=
				 * pt_il_policy_bean.getPOL_SYS_ID; :SYSTEM.MESSAGE_LEVEL :=
				 * '10'; IL_BLOCK_POL_ENABLED; EXECUTE_QUERY;
				 * :SYSTEM.MESSAGE_LEVEL := '0';
				 */
			}
			if ("011".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {

				pilt002_apac_local_procedures
						.IL_ENDT_011_CHANGES(compositeAction);
			}
			if ("003".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				values = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };

				rs1 = handler.executeSelectStatement(C1, con, values);
				if (rs1.next()) {
					M_SURR_YRS = rs1.getInt(1);
				}

				if (M_SURR_YRS != 0) {
					if (CommonUtils.addMonthsToDate(
							pt_il_policy_bean.getPOL_START_DT(),
							M_SURR_YRS * 12).before(
							pt_il_policy_bean.getPOL_END_EFF_FROM_DT())) {

						throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"71239",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
					}
				}

				if ("S".equalsIgnoreCase(pt_il_policy_bean.getUI_M_SURR_MAT())) {
					pt_il_policy_bean.setPOL_STATUS("S");
				} else {
					pt_il_policy_bean.setPOL_STATUS("P");
					String updateAddlCover = "  UPDATE PT_IL_POL_ADDL_COVER    SET    POAC_DEL_FLAG     = 'Y'"
							+ "      WHERE  POAC_POL_SYS_ID   = ? ";
					handler.executeUpdateStatement(updateAddlCover, con,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
				}

				pilt002_apac_local_procedures
						.IL_ENDT_003_004_UPDATE_LC_FC(pt_il_policy_bean
								.getPOL_SYS_ID());
				pilt002_apac_local_procedures
						.IL_ENDT_003_004_BLK_DISABLE(compositeAction);
				pilt002_apac_local_procedures
						.IL_ENDT_003_SV_VALUES(compositeAction);

				dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(false);
				// compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_SURR_MAT_VALUES);
				// SET_TAB_PAGE_PROPERTY('TAB_PT_IL_SURR_MAT_VALUES',ENABLED,PROPERTY_TRUE);
			}
			if ("A".equalsIgnoreCase(dummyBean.getUI_M_POL_PLAN_TYPE())
					|| "S".equalsIgnoreCase(dummyBean.getUI_M_POL_PLAN_TYPE())
					&& "008".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {
				pilt002_apac_local_procedures
						.IL_ENDT_003_004_UPDATE_LC_FC(pt_il_policy_bean
								.getPOL_SYS_ID());
				pilt002_apac_local_procedures
						.IL_ENDT_003_004_BLK_DISABLE(compositeAction);
				pilt002_apac_local_procedures
						.IL_ENDT_003_SV_VALUES(compositeAction);
				dummyAction.getCOMP_UI_M_BUT_SURR_MAT().setDisabled(false);
				// compositeAction.getTabbedBar().setTabEnabled(compositeAction.TAB_PT_IL_SURR_MAT_VALUES);
			}

			/*
			 * -- Endorsement Type '004' - Maturity - has been removed as an
			 * endorsement -- and has been incorporated as a separate Processing
			 * form -- But the code has not been removed - The endt type 004 has
			 * been removed from parameter. -- if this needs to be used, then
			 * should check the processing form for further changes
			 */
			if ("009".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {

				if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {
					Object[] c4values = { pt_il_policy_bean.getPOL_END_DT(),
							pt_il_policy_bean.getPOL_START_DT() };
					rs4 = handler.executeSelectStatement(C4, con, c4values);
					if (rs4.next()) {
						M_NO_OF_DAYS = rs4.getInt(1);
					}

					Object[] c5values = { pt_il_policy_bean.getPOL_SYS_ID() };
					rs5 = handler.executeSelectStatement(C5, con, c5values);
					if (rs5.next()) {
						M_NO_OF_PAY = rs5.getInt(1);
					}
					Object[] c6values = { pt_il_policy_bean.getPOL_PROD_CODE() };
					rs6 = handler.executeSelectStatement(C6, con, c6values);
					if (rs6.next()) {
						M_PROD_COOLOFF_DAYS = rs6.getInt(1);
					}

					if (M_NO_OF_PAY > 1
							|| CommonUtils.nvl(M_NO_OF_DAYS, 0) > CommonUtils
									.nvl(M_PROD_COOLOFF_DAYS, 0)) {
						/*throw new Exception(
								Messages
										.getString(
												PELConstants.pelErrorMessagePath,
												"91472",
												new Object[] { CommonUtils
														.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
												// STD_MESSAGE_ROUTINE(91472,:CTRL.M_LANG_CODE );*/
						throw new Exception(
								" Endorsement date should be within cool off period days");
					}
				}

				pt_il_policy_bean.setPOL_STATUS("E");

				rs7 = handler.executeSelectStatement(C7, con);
				if (rs7.next()) {
					M_END_CODE = rs7.getString(1);
				}

				pilt002_apac_local_procedures
						.IL_ENDT_001_CHANGES(compositeAction);
			}
			if ("004".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {

				pt_il_policy_bean.setPOL_STATUS("M");
				pilt002_apac_local_procedures
						.IL_ENDT_003_004_UPDATE_LC_FC(pt_il_policy_bean
								.getPOL_SYS_ID());
				pilt002_apac_local_procedures
						.IL_ENDT_003_004_BLK_DISABLE(compositeAction);
				pilt002_apac_local_procedures
						.IL_ENDT_004_GR_MAT_VALUE(compositeAction);
			}
			/*
			 * -- Endorsement Type '005' - Cancellation/paidup - has been
			 * removed as an endorsement -- and has been incorporated as a
			 * separate Processing form -- But the code has not been removed -
			 * The endt type 005 has been removed from parameter. -- if this
			 * needs to be used, then should check the processing form for
			 * further changes
			 */

			if ("006".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					|| "020".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {
				if ("006".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {
					pt_il_policy_bean.setPOL_STATUS("R");
				} else if ("020".equalsIgnoreCase(CommonUtils.nvl(
						pt_il_policy_bean.getPOL_END_TYPE(), "000"))) {
					pt_il_policy_bean.setPOL_STATUS("E");
				}
				pt_il_policy_bean.setPOL_FC_CURR_SA(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED());
				pt_il_policy_bean.setPOL_LC_CURR_SA(pt_il_policy_bean
						.getPOL_LC_SUM_ASSURED());
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				if (pt_il_policy_bean.getROWID() != null) {
					/*
					 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
					 * COPY('P','CTRL.M_COMM_DEL') ; POST;
					 * COPY('','CTRL.M_COMM_DEL') ; END IF;
					 */
				}
				pilt002_apac_local_procedures
						.IL_ENDT_006_CHANGES(compositeAction);
				dummyAction.getCOMP_UI_M_BUT_UPI().setDisabled(false);
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
						.setDisabled(true);
			}

			if ("005".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_STATUS("C");
				if (CommonUtils.nvl(
						pt_il_policy_bean.getPOL_NO_YRS_PREM_PAID(), 0) >= dummyBean
						.getUI_M_ENDT_PS_VALUE()) {
					pilt002_apac_local_procedures
							.IL_ENDT_005_GR_MAT_VAL(compositeAction);
					pilt002_apac_local_procedures
							.IL_ENDT_005_BLK_DISABLE(compositeAction);
				} else {

					String updateAddlCover = " UPDATE PT_IL_POL_ADDL_COVER  SET    POAC_DEL_FLAG     = 'Y' "
							+ " WHERE  POAC_POL_SYS_ID   = ?   ";
					handler.executeUpdateStatement(updateAddlCover, con,
							new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
					pilt002_apac_local_procedures
							.IL_ENDT_005_BLK_DISABLE(compositeAction);
				}

			}
			if ("010".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {

				pValOrclList = new P9ILPK_ENDORSE().P_GET_NEW_SDATE(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_END_DT()), CommonUtils
								.getProcedureValue(M_START_DT));

				if (!pValOrclList.isEmpty()) {
					M_START_DT = CommonUtils.stringToUtilDate(pValOrclList.get(
							0).getValue());
				}
				/*
				 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
				 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
				 * FORM_TRIGGER_FAILURE; END;
				 */
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
							.setDELETE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
							.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
							.setINSERT_ALLOWED(true);
				}

				pt_il_policy_bean.setPOL_START_DT(M_START_DT);
				pt_il_policy_bean.setPOL_BASIC_RATE(0d);

				pilt002_apac_local_procedures
						.IL_SPL_REV_CHANGE(compositeAction);
				if (pt_il_policy_bean.getROWID() != null) {
				}
				/*
				 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
				 * COPY('P','CTRL.M_COMM_DEL') ; POST;
				 * COPY('','CTRL.M_COMM_DEL') ; END IF;
				 */
			}

			if ("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
							.setDELETE_ALLOWED(true);
				}

			}

			// --Added by Anamika on 22/09/2005 for recalculating assured age
			// based on doc setup start
			if ("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					|| "015".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {

				Object[] c3values = { pt_il_policy_bean.getPOL_END_CODE() };
				rs3 = handler.executeSelectStatement(C3, con, c3values);
				if (rs3.next()) {
					M_DS_AGE_RECALC_YN = rs3.getString(1);
				}
				if ("Y".equalsIgnoreCase(M_DS_AGE_RECALC_YN)) {
					pValOrclList = new ArrayList<OracleParameter>();
					pValOrclList = pkg_pilt002_apac.P_CALC_ANB(
							pt_il_policy_bean.getPOL_END_EFF_FROM_DT(),
							compositeAction
									.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_DOB(), dummyBean
									.getUI_M_PROD_AGE_CALC_FLAG(),
							compositeAction
									.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_DISC_AGE());
					if (pValOrclList != null && !pValOrclList.isEmpty())
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN()
								.setPOAD_DISC_AGE(
										(Integer) pValOrclList.get(0)
												.getValueObject());
				}

			}
			// for recalculating assured age based on doc setup start
			if ("014".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_FRZ_FLAG("N");
				pt_il_policy_bean.setPOL_STATUS("E");

				/*
				 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
				 * COPY('P','CTRL.M_COMM_DEL') ; POST;
				 * COPY('','CTRL.M_COMM_DEL') ; END IF;
				 */

				new P9ILPK_ENDORSE().P_TRANS_ORG_FIELDS(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()));
				new P9ILPK_POLICY().P_INS_POL_CHARGES(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_START_DT()));
				new P9ILPK_POLICY().P_INS_POL_DOLIST(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						null, "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_START_DT()));
				/*
				 * EXCEPTION WHEN OTHERS THEN L_DISPLAY_ERROR_MESSAGE;
				 * SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT'); RAISE
				 * FORM_TRIGGER_FAILURE; END;
				 */

				pilt002_apac_local_procedures
						.IL_ENDT_001_CHANGES(compositeAction);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
							.setDELETE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
							.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
							.setINSERT_ALLOWED(true);
				}
			}
			if ("002".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
						.setINSERT_ALLOWED(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
			} else {
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
						.setINSERT_ALLOWED(false);
				compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
						.setUPDATE_ALLOWED(true);
			}
			pt_il_policy_action.getCOMP_POL_END_CODE().setRequired(false);
			pt_il_policy_action.getCOMP_POL_END_NO().setRequired(false);
			pt_il_policy_action.getCOMP_POL_END_DT().setRequired(false);

			/*
			 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
			 * COPY('P','CTRL.M_COMM_DEL'); POST; COPY('','CTRL.M_COMM_DEL');
			 * END IF;
			 */
			pilt002_apac_local_procedures.L_UPDATE_TABLES(pt_il_policy_bean
					.getPOL_SYS_ID());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
					pt_il_policy_bean.getPOL_SYS_ID().toString());

			// SET_APPLICATION_PROPERTY(CURSOR_STYLE,'DEFAULT');

			/*
			 * HIDE_VIEW('PT_ENDT'); HIDE_WINDOW('PT_ENDT'); CHK_PKG_FAILURE;
			 */
			// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
			
			
			
			pValOrclList = new ArrayList<OracleParameter>();
			
			/*Added by Janani on 04.05.2018 for Fidelity endorsement setup issue as suggested by Sivaram*/
			END_NUM_PTRN = (BigDecimal)CommonUtils.getPPSystemParameterValue("END_NUM_PTRN");
			
			rs9 = handler.executeSelectStatement(C9, con, new Object[] {pt_il_policy_bean.getPOL_END_CODE()});

			if (rs9.next()) {
				ds_type = rs9.getString(1);
			}
			
			
			System.out.println("END_NUM_PTRN               "+END_NUM_PTRN+"    ds_type         "+ds_type);
			if(END_NUM_PTRN.intValue() == 2){
				
				System.out.println("P_GEN_DOC_NO  Procedure call    :   ");
				pValList1 = new LIFELIB().P_GEN_DOC_NO(ds_type,pt_il_policy_bean
						.getPOL_END_CODE(), pt_il_policy_bean
						.getPOL_DIVN_CODE(), pt_il_policy_bean
						.getPOL_CLASS_CODE(), pt_il_policy_bean
						.getPOL_PLAN_CODE(), pt_il_policy_bean
						.getPOL_PROD_CODE(), CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_UW_YEAR()),
						"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N", CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ISSUE_DT()),null,
										null,
										
										/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
										CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
										/*End*/
						);
				if (!pValList1.isEmpty()) {
				
				System.out.println("pt_il_policy_bean.getPOL_END_NO from gen_doc_no            :"+(String) pValList1.get(0)
						.getValue());
				
				pt_il_policy_bean.setPOL_END_NO((String) pValList1.get(0)
						.getValue());
				
				}
			}
			else
			{
				
				System.out.println("P_GEN_END_NO  Procedure call    :   ");
			pValOrclList = new LIFELIB().P_GEN_END_NO(pt_il_policy_bean
					.getPOL_END_NO_IDX(), pt_il_policy_bean.getPOL_END_NO());
			
			/*pValOrclList = new LIFELIB().P_GEN_END_NO(pt_il_policy_bean.getPOL_END_CODE(),
					pt_il_policy_bean.getPOL_DIVN_CODE(),pt_il_policy_bean.getPOL_CLASS_CODE(),
					pt_il_policy_bean.getPOL_PLAN_CODE(),pt_il_policy_bean.getPOL_PROD_CODE(),
					pt_il_policy_bean.getPOL_UW_YEAR(),pt_il_policy_bean.getPOL_NO(),
					"N",pt_il_policy_bean.getPOL_END_DT(),
					pt_il_policy_bean.getPOL_END_NO_IDX(), pt_il_policy_bean.getPOL_END_NO());*/
			
			
			System.out.println("pt_il_policy_bean.getPOL_END_NO    :   "+(String) pValOrclList.get(0)
					.getValueObject());
			
			pt_il_policy_bean.setPOL_END_NO((String) pValOrclList.get(0)
					.getValueObject());
			
			}
			
			// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setPT_IL_POLICY_BEAN(pt_il_policy_bean);
			savePolicy(pt_il_policy_bean);
			new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
			pt_il_policy_helper.PRE_RECORD(compositeAction);
			//	pt_il_policy_helper.whenNewRecordInstance(compositeAction);

			// new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
			if ("009".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				// pt_il_policy_bean.getPOL_RES_ADDRESS_1 :=
				// pt_il_policy_bean.getPOL_RES_ADDRESS_1;
			}
			if ("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_bean.setPOL_PERIOD(0);
				String updateQuery = "UPDATE PT_IL_POL_ADDL_COVER SET POAC_PERIOD = ? " +
						"WHERE POAC_POL_SYS_ID = ?";
				handler.executeUpdateStatement(updateQuery, 
						CommonUtils.getConnection(), 
						new Object[]{null,pt_il_policy_bean.getPOL_SYS_ID()});
				/*if (compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.getDataList_PT_IL_POL_ADDL_COVER().size() > 0) {
					for (int i = 0; i < compositeAction
							.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
							.getDataList_PT_IL_POL_ADDL_COVER().size(); i++) {
						compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
								.getPT_IL_POL_ADDL_COVER_BEAN().setPOAC_PERIOD(
										0);
					}
				}*/
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_NO_OF_UNIT().setDisabled(true);
			}

			premCalcClicked(compositeAction);
			if ("020".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					&& "N".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_APPRV_STATUS(), "N"))) {
				sp_revival.upd_del_flag_rein_redate_agent(pt_il_policy_bean
						.getPOL_SYS_ID());
				sp_revival.P_UPD_REDATE_ST_DATE(pt_il_policy_bean
						.getPOL_SYS_ID());
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getHelper()
						.executeQuery(compositeAction);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getCOMP_POL_FRZ_FLAG().setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_KEY_COMMIT().setDisabled(true);
			}



			if("012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))&& "N".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(),"N")))
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			con.commit();
			CommonUtils.closeCursor(rs);
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
			CommonUtils.closeCursor(rs3);
			CommonUtils.closeCursor(rs4);
			CommonUtils.closeCursor(rs5);
			CommonUtils.closeCursor(rs6);
			CommonUtils.closeCursor(rs7);
		}
		return outcome;
	}

	//added for checking premcalc is clicked on endo 002,012
	public void premCalcClicked(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		String endoType = PT_IL_POLICY_BEAN.getPOL_END_TYPE();
		String updateQuery = "UPDATE PT_IL_POLICY SET POL_FLEX_20 = 'N' WHERE POL_SYS_ID = ? ";
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			if (endoType.equalsIgnoreCase("002")
					|| endoType.equalsIgnoreCase("012")) {
				handler.executeUpdateStatement(updateQuery, connection,
						new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePolicy(PT_IL_POLICY pt_il_policy_bean) {
		try {
			new CRUDHandler().executeUpdate(pt_il_policy_bean, CommonUtils
					.getConnection());
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void UI_M_BUT_DOC_GEN_NO_WHEN_BUTTON_PRESSED(
			PT_IL_POLICY pt_il_policy_bean, DUMMY dummy_bean,
			DUMMY_ACTION dummy_action) throws Exception {

		LIFELIB lifelib = new LIFELIB();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		try {
			
			System.out.println("1.ENTER THE UI_M_BUT_DOC_GEN_NO_WHEN_BUTTON_PRESSED ***********");
			
			if (pt_il_policy_bean.getPOL_END_NO_IDX() != null
					&& pt_il_policy_bean.getPOL_END_NO_IDX() > 0) {

				pValList = lifelib.P_GEN_DOC_NO("3", pt_il_policy_bean
						.getPOL_END_CODE(), pt_il_policy_bean
						.getPOL_DIVN_CODE(), pt_il_policy_bean
						.getPOL_CLASS_CODE(), pt_il_policy_bean
						.getPOL_PLAN_CODE(), pt_il_policy_bean
						.getPOL_PROD_CODE(), CommonUtils
						.getProcedureValue(CommonUtils
								.getYearFromDate(pt_il_policy_bean
										.getPOL_END_DT())),
						"PT_IL_POLICY.POL_END_NO", "PT_IL_POLICY", "N",
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_END_DT()), null, null,
								
								/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
								CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
								/*End*/
						
						);
				
				System.out.println("PT_IL_POLICY_BEAN.GETPOL_END_NO()   : "+pValList.get(0).getValue());
				
				if (!pValList.isEmpty()) {
					pt_il_policy_bean.setPOL_END_NO(pValList.get(0).getValue());
				}

				dummy_bean.setUI_M_END_IDX_TYPE_NO(pt_il_policy_bean
						.getPOL_END_NO_IDX()
						+ "-"
						+ pt_il_policy_bean.getPOL_END_TYPE()
						+ "-"
						+ pt_il_policy_bean.getPOL_END_NO());
				/*Newly Added By Dhinesh on 12-06-2017 */
				CommonUtils.setGlobalVariable("GLOBAL.APPRV_SCRN_END_IDX_NO",dummy_bean.getUI_M_END_IDX_TYPE_NO());
				/*End*/
			} else {
				
				System.out.println("PT_IL_POLICY_BEAN.GETPOL_DS_TYPE()   :  "+pt_il_policy_bean.getPOL_DS_TYPE());
				if ("1".equals(pt_il_policy_bean.getPOL_DS_TYPE())) {

					pValList = new ArrayList<OracleParameter>();
					pValList = lifelib.P_GEN_DOC_NO("1", CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"),
							pt_il_policy_bean.getPOL_DIVN_CODE(),
							pt_il_policy_bean.getPOL_CLASS_CODE(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_PROD_CODE(), CommonUtils
									.getProcedureValue(pt_il_policy_bean
											.getPOL_UW_YEAR()),
							"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N",
							CommonUtils.getProcedureValue(pt_il_policy_bean
									.getPOL_ISSUE_DT()), null, null,
									/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
									CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
									/*End*/		
							
							);
					if (!pValList.isEmpty()) {
						pt_il_policy_bean.setPOL_NO(pValList.get(0).getValue());
					}
				} else {
					pValList = new ArrayList<OracleParameter>();
					pValList = lifelib.P_GEN_DOC_NO("2", CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"),
							pt_il_policy_bean.getPOL_DIVN_CODE(),
							pt_il_policy_bean.getPOL_CLASS_CODE(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_PROD_CODE(), CommonUtils
									.getProcedureValue(pt_il_policy_bean
											.getPOL_UW_YEAR()),
							"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N",
							CommonUtils.getProcedureValue(pt_il_policy_bean
									.getPOL_ISSUE_DT()), null, null,
									
									/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
									CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
									/*End*/
							
							);
					if (!pValList.isEmpty()) {
						pt_il_policy_bean.setPOL_NO(pValList.get(0).getValue());
					}
				}
			}
			/*
			 * Start - Code Modified By A.SubbuLakshmi with reference to
			 * PRIL-IMPALY-007-TISB4
			 */
			// GO_ITEM('PT_IL_POLICY.POL_PROD_CODE');
			/*
			 * End - Code Modified By A.SubbuLakshmi with reference to
			 * PRIL-IMPALY-007-TISB4
			 */

			dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setDisabled(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * public void dummy_m_but_ok_when_button_pressed(
	 * PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	 * 
	 * PT_IL_POLICY PT_IL_POLICY = compositeAction
	 * .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	 * 
	 * DBProcedures procedures = new DBProcedures(); CommonUtils commonUtils =
	 * new CommonUtils(); CRUDHandler handler = new CRUDHandler(); Connection
	 * connection = null; ArrayList<String> returnList = new ArrayList<String>();
	 * 
	 * String GLOBAL_PARA_13 = CommonUtils.nvl(commonUtils
	 * .getGlobalVariable("GLOBAL.M_PARAM_13"), ""); String GLOBAL_PARA_11 =
	 * CommonUtils.nvl(commonUtils .getGlobalVariable("GLOBAL.M_PARAM_11"), "");
	 * String M_CONT_LC_PROP_DEP_AMT = null; String M_PROD_AUTO_APPROV = null;
	 * String M_PMOP_SHORT_RATE = null; String M_PMOP_SHORT_RATE_PER = null;
	 * String M_PMOP_TOLL_TYP = null; String M_SHORT_COLL_VALUE = null;
	 * 
	 * ResultSet c1 = null; ResultSet c2 = null; ResultSet c3 = null;
	 * 
	 * try {
	 * 
	 * connection = CommonUtils.getConnection(); returnList =
	 * procedures.callPKG_PILT002_M_BUT_OK(PT_IL_POLICY .getPOL_NO(),
	 * PT_IL_POLICY.getPOL_PROD_CODE(), PT_IL_POLICY .getPOL_CONT_CODE(),
	 * PT_IL_POLICY.getPOL_PROP_NO(), PT_IL_POLICY.getPOL_PLAN_CODE(),
	 * CommonUtils .floorDoubleAsString(PT_IL_POLICY.getPOL_SYS_ID()),
	 * CommonUtils.floorDoubleAsString(PT_IL_POLICY .getPOL_END_NO_IDX()),
	 * CommonUtils .dateToStringFormatter(PT_IL_POLICY .getPOL_ISSUE_DT()),
	 * PT_IL_POLICY .getUI_M_PS_REASON_CODE(), PT_IL_POLICY
	 * .getUI_M_PS_REMARKS(), GLOBAL_PARA_13, GLOBAL_PARA_11, CommonUtils
	 * .floorDoubleAsString(PT_IL_POLICY .getUI_M_CALC_METHOD()), PT_IL_POLICY
	 * .getUI_M_PROD_PREM_CALC_MTHD(), PT_IL_POLICY .getUI_M_POL_PLAN_TYPE(),
	 * CommonUtils .floorDoubleAsString(PT_IL_POLICY .getPOL_PREM_PAY_YRS()),
	 * PT_IL_POLICY .getPOL_LC_FIRST_PREM() + "",
	 * PT_IL_POLICY.getPOL_MODE_OF_PYMT(), PT_IL_POLICY.getPOL_FC_FIRST_PREM() +
	 * "", PT_IL_POLICY .getPOL_ADDL_STATUS(), PT_IL_POLICY.getUI_POL_NO());
	 * 
	 * if (returnList != null && returnList.size() > 0 && returnList.get(0) !=
	 * null) { PT_IL_POLICY.setUI_POL_NO(returnList.get(0)); // Setting the
	 * Converted Policy Number in Gui and Bean
	 * PT_IL_CONVERT_ACTION.getCOMP_M_POL_NO().setSubmittedValue(
	 * returnList.get(0)); PT_IL_CONVERT.setM_POL_NO(returnList.get(0));
	 * PT_IL_POLICY.setUI_M_FLAG(returnList.get(1));
	 * commonUtils.setGlobalVariable("GLOBAL.M_POL_NO", returnList .get(2));
	 * commonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", returnList .get(3));
	 * 
	 * String sql_c1 =
	 * PILT002_APAC_QUERY_CONSTANTS.PT_IL_CONVERT_OK_BUT_WHEN_BUT_PRESSED_C1;
	 * Object[] c1Objects = { PT_IL_POLICY.getPOL_CONT_CODE() };
	 * 
	 * String sql_c2 =
	 * PILT002_APAC_QUERY_CONSTANTS.PT_IL_CONVERT_OK_BUT_WHEN_BUT_PRESSED_C2;
	 * Object[] c2Objects = { PT_IL_POLICY.getPOL_PROD_CODE() };
	 * 
	 * String sql_c3 =
	 * PILT002_APAC_QUERY_CONSTANTS.PT_IL_CONVERT_OK_BUT_WHEN_BUT_PRESSED_C3;
	 * Object[] c3Objects = { PT_IL_POLICY.getPOL_PLAN_CODE(),
	 * PT_IL_POLICY.getPOL_MODE_OF_PYMT() };
	 * 
	 * c1 = handler.executeSelectStatement(sql_c1, connection, c1Objects); c2 =
	 * handler.executeSelectStatement(sql_c2, connection, c2Objects); c3 =
	 * handler.executeSelectStatement(sql_c3, connection, c3Objects);
	 * 
	 * if (c1.next()) {
	 * 
	 * M_CONT_LC_PROP_DEP_AMT = c1.getString(1); }
	 * 
	 * if (c2.next()) {
	 * 
	 * M_PROD_AUTO_APPROV = c2.getString(1); }
	 * 
	 * if (c3.next()) {
	 * 
	 * M_PMOP_SHORT_RATE = c3.getString(1); M_PMOP_SHORT_RATE_PER =
	 * c3.getString(2); M_PMOP_TOLL_TYP = c3.getString(3); }
	 * 
	 * if ("P".equals(M_PMOP_TOLL_TYP)) { M_SHORT_COLL_VALUE = (Double
	 * .parseDouble(CommonUtils.nvl(PT_IL_POLICY .getPOL_FC_FIRST_PREM() + "",
	 * "0")) Double.parseDouble(CommonUtils.nvl( M_PMOP_SHORT_RATE, "0")) /
	 * Double .parseDouble(CommonUtils.nvl( M_PMOP_SHORT_RATE_PER, "0"))) + ""; }
	 * else {
	 * 
	 * M_SHORT_COLL_VALUE = CommonUtils.nvl( M_PMOP_SHORT_RATE, ""); }
	 * 
	 * if ("Y".equals(CommonUtils.nvl(M_PROD_AUTO_APPROV, "N"))) { if
	 * (Double.parseDouble(CommonUtils.nvl( M_CONT_LC_PROP_DEP_AMT, "0")) >=
	 * Double .parseDouble(CommonUtils.nvl(PT_IL_POLICY .getPOL_LC_FIRST_PREM() +
	 * "", "0")) || (Double.parseDouble(CommonUtils.nvl( M_CONT_LC_PROP_DEP_AMT,
	 * "0")) + Double .parseDouble(CommonUtils.nvl( M_SHORT_COLL_VALUE, "0"))) >=
	 * Double .parseDouble(CommonUtils.nvl( PT_IL_POLICY.getPOL_LC_FIRST_PREM() +
	 * "", "0"))) { // TODO:: introduce proper method //
	 * CALL_FORM('PILP002_APAC',NO_HIDE,NO_REPLACE); } } } else { throw new
	 * ValidatorException(new FacesMessage( "problem occured while
	 * converting")); } // resetting all values from bean //
	 * compositeAction.resetAllValues(); //[PREMIAGDC-277595-VijayAnand
	 * 22-JUL-09 ResultSet rs = handler .executeSelectStatement(
	 * PILT002_APAC_QUERY_CONSTANTS.CONVERT_YN_FLAG_UPDATING_QUERY,
	 * CommonUtils.getConnection(), new Object[] { PT_IL_POLICY.getPOL_NO() });
	 * if (rs.next()) { compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().setPOL_CONVERT_YN(
	 * rs.getString("POL_CONVERT_YN")); } //[PREMIAGDC-277595-VijayAnand
	 * 22-JUL-09 } catch (Exception e) { e.printStackTrace(); throw new
	 * Exception(e.getMessage()); } finally { CommonUtils.closeCursor(c1);
	 * CommonUtils.closeCursor(c2); CommonUtils.closeCursor(c3); } }
	 */

	public String UI_M_BUT_OK_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();

		String CALLING_FORM = "PILT002_APAC_PT_IL_CONVERT";

		try {

			ArrayList<OracleParameter> orclList = pkg_pilt002_apac.M_BUT_OK(
					pt_il_policy.getPOL_NO(), pt_il_policy.getPOL_PROD_CODE(),
					pt_il_policy.getPOL_CONT_CODE(), pt_il_policy
							.getPOL_PROP_NO(), pt_il_policy.getPOL_PLAN_CODE(),
					pt_il_policy.getPOL_SYS_ID(), pt_il_policy
							.getPOL_END_NO_IDX(), pt_il_policy
							.getPOL_ISSUE_DT(), dummy_bean
							.getUI_M_PS_REASON_CODE(), dummy_bean
							.getUI_M_PS_REMARKS(), CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_13"),
					CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"),
					dummy_bean.getUI_M_CALC_METHOD(), dummy_bean
							.getUI_M_PROD_PREM_CALC_MTHD(), dummy_bean
							.getUI_M_POL_PLAN_TYPE(), pt_il_policy
							.getPOL_LC_FIRST_PREM(), pt_il_policy
							.getPOL_MODE_OF_PYMT(), pt_il_policy
							.getPOL_FC_FIRST_PREM(), pt_il_policy
							.getPOL_ADDL_STATUS(), dummy_bean.getUI_M_POL_NO(),
					null, null, null, null, null, null, null, null, null, null,
					null, null);

			dummy_bean
					.setUI_M_POL_NO((String) orclList.get(0).getValueObject());
			dummy_bean.setUI_M_FLAG((String) orclList.get(1).getValueObject());

			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", (String) orclList
					.get(2).getValueObject());
			if (orclList.get(3).getValueObject() != null)
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", orclList
						.get(3).getValueObject().toString());
			CALLING_FORM = (String) orclList.get(4).getValueObject();

			/*
			 * if (pValList.get(0).getValueObject() != null) {
			 * dummy_bean.setUI_M_POL_NO((String) pValList.get(0)
			 * .getValueObject()); } if (pValList.get(1).getValueObject() !=
			 * null) { dummy_bean.setUI_M_FLAG((String) pValList.get(1)
			 * .getValueObject()); } if (pValList.get(2).getValueObject() !=
			 * null) { CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", (String)
			 * pValList.get(0).getValueObject()); } if
			 * (pValList.get(3).getValueObject() != null) {
			 * CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", (String)
			 * pValList.get(0).getValueObject()); } if
			 * (pValList.get(4).getValueObject() != null) { CALLING_FORM =
			 * (String) pValList.get(4).getValueObject(); }
			 */

			// [PREMIAGDC-277595-VijayAnand 22-JUL-09
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return CALLING_FORM;
	}

	public String keyCommit(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER pt_il_pol_addl_cover = compositeAction
				.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.getPT_IL_POL_ADDL_COVER_BEAN();
		DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY pt_il_pol_beneficiary = compositeAction
				.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.getPT_IL_POL_BENEFICIARY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PILPK_PILT002 pilpk_pilt002 = new PILPK_PILT002();
		ArrayList<OracleParameter> pvalList = new ArrayList<OracleParameter>();
		String outCome = "PILT002_APAC_PT_IL_POLICY";
		try {
			
			System.out.println("Dhinesh123 Enter the keyCommit ");
			
			if (!("Q".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_PROP_QUOT_FLAG(), "N")))
					&& (!"F".equals(dummy.getUI_M_COVER_SA_CALC()))) {
				PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
				ArrayList<String> pValListStr = new ArrayList<String>();
				pValListStr = pkg_pilt002_apac.IL_CALC_SA_VALID(CommonUtils
						.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
						CommonUtils
								.getProcedureValue(pt_il_pol_assured_dtls
										.getPOAD_SYS_ID()), pt_il_policy_bean
								.getPOL_END_TYPE(), pt_il_policy_bean
								.getPOL_PLAN_CODE(), dummy
								.getUI_M_PROD_SA_FACTOR(), dummy
								.getUI_M_COVER_SA_CALC(), pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), dummy
								.getUI_M_PROD_SA_TARIFF(), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_FC_MODAL_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_NO_OF_INST()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_FC_SUM_ASSURED()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ORG_FC_SUM_ASSURED()),
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_ORG_FC_MODAL_PREM()), CommonUtils
								.getProcedureValue(pt_il_policy_bean
										.getPOL_ORG_NO_OF_INST()));
			}
			//SA-VALIDATION HANDLED HERE TOP
			pvalList = pilpk_pilt002.KEY_COMMIT(pt_il_policy_bean
					.getPOL_SYS_ID(),
					pt_il_pol_addl_cover.getPOAC_POL_SYS_ID(), dummy
							.getUI_M_PROD_SA_FACTOR(), dummy
							.getUI_M_COVER_SA_CALC(), pt_il_pol_assured_dtls
							.getPOAD_HEALTH_CODE(), pt_il_pol_assured_dtls
							.getPOAD_SYS_ID(), dummy.getUI_M_TD_MIN_RATE(),
					dummy.getUI_M_BASE_CURR(), dummy
							.getUI_M_PROD_SA_ADD_FACTOR(), dummy
							.getUI_M_POL_PLAN_TYPE(), dummy
							.getUI_M_CALC_METHOD(), dummy
							.getUI_M_PROD_AUTO_UW(), dummy
							.getUI_M_COVER_VAR_VALUE(), dummy
							.getUI_M_IL_BROK_CALC(), dummy
							.getUI_M_PROD_PREM_TARIFF(), !pt_il_policy_bean
							.getROWID().equals(null) ? "CHANGED" : null,
					pt_il_policy_bean.getPOL_ISSUE_DT(), dummy
							.getUI_M_PROD_SA_TARIFF(), dummy.getUI_M_PS_CODE(),
					dummy.getUI_M_EXACT_AGE(), dummy.getUI_M_AMAN_PLAN_CODE(),
					dummy.getUI_M_PLAN_CALC_TYPE(), pt_il_pol_assured_dtls
							.getPOAD_OCC_CLASS(), pt_il_pol_assured_dtls
							.getPOAD_OCC_CODE(), dummy.getUI_M_BROKER_YN(),
					pt_il_pol_assured_dtls.getPOAD_DISC_AGE(), dummy
							.getUI_M_IL_DOC_GEN(), CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"), dummy
							.getUI_M_CHANGE_SA_YN(), dummy
							.getUI_M_PLAN_AGE_TERM_FLAG(), dummy
							.getUI_M_PROD_PREM_CALC_MTHD(), CommonUtils
							.getControlBean().getM_USER_ID(), CommonUtils
							.getGlobalVariable("CALLING_FORM"), dummy
							.getUI_M_PROD_TOPUP_YN(), pt_il_policy_bean
							.getPOL_FC_CLIENT_ALLOC_AMT(), pt_il_policy_bean
							.getPOL_ORG_LC_SUM_ASSURED(),
					pt_il_pol_assured_dtls.getPOAD_HEIGHT(),
					pt_il_pol_assured_dtls.getPOAD_WEIGHT(),
					pt_il_pol_beneficiary.getPBEN_SR_NO(), pt_il_policy_bean
							.getPOL_FC_MON_ANNU_AMT(), pt_il_policy_bean
							.getPOL_MODE_OF_PYMT(), pt_il_policy_bean
							.getPOL_LAST_INST_DT(), pt_il_policy_bean
							.getPOL_APPRV_STATUS(), pt_il_policy_bean
							.getPOL_FC_SUM_ASSURED(), pt_il_policy_bean
							.getPOL_FRZ_FLAG(), pt_il_policy_bean
							.getPOL_RES_ADDRESS_1(), pt_il_policy_bean
							.getPOL_NEW_FC_SA(), pt_il_policy_bean
							.getPOL_JOINT_LIFE_AGE(), pt_il_policy_bean
							.getPOL_FLEX_03(), pt_il_policy_bean
							.getPOL_END_NO(), pt_il_policy_bean
							.getPOL_ORG_NEW_FC_SA(), pt_il_pol_assured_dtls
							.getPOAD_AGE(), pt_il_policy_bean
							.getUI_M_POL_FC_PREM_PAYABLE(), pt_il_policy_bean
							.getUI_M_POL_LC_PREM_PAYABLE(), pt_il_policy_bean
							.getPOL_FC_DEPOSIT_AMOUNT(), pt_il_policy_bean
							.getPOL_LC_DEPOSIT_AMOUNT(), pt_il_policy_bean
							.getUI_M_POL_FC_TOT_CHARGE(), pt_il_policy_bean
							.getUI_M_POL_LC_TOT_CHARGE(), pt_il_policy_bean
							.getPOL_FC_AMAN_PREM(), pt_il_policy_bean
							.getPOL_LC_AMAN_PREM(), pt_il_policy_bean
							.getPOL_LC_HEALTH_LOAD(), pt_il_policy_bean
							.getPOL_FC_HEALTH_LOAD(), pt_il_policy_bean
							.getPOL_FC_SENABEL_PREM(), pt_il_policy_bean
							.getPOL_LC_SENABEL_PREM(), pt_il_policy_bean
							.getUI_M_POL_FC_SA(), pt_il_policy_bean
							.getUI_M_POL_LC_SA(), pt_il_policy_bean
							.getPOL_BASIC_RATE(), pt_il_policy_bean
							.getPOL_HEALTH_RATE(), pt_il_policy_bean
							.getPOL_LC_ADDL_PREM(), pt_il_policy_bean
							.getPOL_FC_ADDL_PREM(), pt_il_surr_mat_values
							.getSMV_FC_GROSS_VALUE(),

					pt_il_policy_bean.getPOL_LC_SUM_ASSURED(),/*72*/
					pt_il_policy_bean.getPOL_FC_CURR_SA(), pt_il_policy_bean
							.getPOL_NEW_LC_SA(), pt_il_policy_bean
							.getPOL_LC_CURR_SA(), pt_il_policy_bean
							.getUI_M_POL_FC_TOT_PREM(), pt_il_policy_bean
							.getUI_M_POL_LC_TOT_PREM(), pt_il_policy_bean
							.getUI_M_POL_FC_TOT_LOADING(), pt_il_policy_bean
							.getUI_M_POL_LC_TOT_LOADING(), pt_il_policy_bean
							.getUI_M_POL_FC_TOT_DISCOUNT(), pt_il_policy_bean
							.getUI_M_POL_LC_TOT_DISCOUNT(), pt_il_policy_bean
							.getUI_M_FC_PCHARGES_BORNE_CUST(),
					pt_il_policy_bean.getUI_M_LC_PCHARGES_BORNE_CUST(),
					pt_il_policy_bean.getUI_M_FC_PCHARGES_BORNE_COMP(),
					pt_il_policy_bean.getUI_M_LC_PCHARGES_BORNE_COMP(),
					pt_il_policy_bean.getUI_M_FC_SCHARGES_BORNE_CUST(),
					pt_il_policy_bean.getUI_M_LC_SCHARGES_BORNE_CUST(),
					pt_il_policy_bean.getUI_M_FC_SCHARGES_BORNE_COMP(),
					pt_il_policy_bean.getUI_M_LC_SCHARGES_BORNE_COMP(),
					pt_il_policy_bean.getUI_M_POL_FC_NET_PREM(),
					pt_il_policy_bean.getUI_M_POL_LC_NET_PREM(),
					pt_il_policy_bean.getUI_M_POL_INST_FC_PREM(),
					pt_il_policy_bean.getUI_M_POL_INST_LC_PREM(),
					pt_il_policy_bean.getUI_M_POL_FC_MOP(), pt_il_policy_bean
							.getUI_M_POL_LC_MOP(), pt_il_policy_bean
							.getUI_M_POL_FC_GR_ANN_PREM(), pt_il_policy_bean
							.getUI_M_POL_LC_GR_ANN_PREM(), pt_il_policy_bean
							.getPOL_FC_NETT_PREM(), pt_il_policy_bean
							.getPOL_LC_NETT_PREM(), pt_il_policy_bean
							.getPOL_FC_BASIC_PREM(), pt_il_policy_bean
							.getPOL_LC_BASIC_PREM(), pt_il_policy_bean
							.getPOL_ORG_NEW_LC_SA(), dummy
							.getUI_M_TD_MIN_RATE(),
					dummy.getUI_M_TD_MAX_RATE(), pt_il_policy_bean
							.getPOL_LC_MON_ANNU_AMT(), pt_il_policy_bean
							.getPOL_NO_OF_UNIT(), pt_il_policy_bean
							.getUI_M_FC_OCC_LOAD(), pt_il_policy_bean
							.getUI_M_LC_OCC_LOAD(), pt_il_policy_bean
							.getUI_M_FC_DEATH_LOAD(), pt_il_policy_bean
							.getUI_M_LC_DEATH_LOAD(), pt_il_policy_bean
							.getUI_M_FC_TPD_LOAD(), pt_il_policy_bean
							.getUI_M_LC_TPD_LOAD(), pt_il_policy_bean
							.getUI_M_FC_MED_LOAD(), pt_il_policy_bean
							.getUI_M_LC_MED_LOAD(), pt_il_policy_bean
							.getUI_M_FC_GROSS_CONT(), pt_il_policy_bean
							.getUI_M_LC_GROSS_CONT(), pt_il_policy_bean
							.getUI_M_FC_CHARGE(), pt_il_policy_bean
							.getUI_M_LC_CHARGE(), dummy
							.getUI_M_COMPY_FC_CHARGE(), dummy
							.getUI_M_COMPY_LC_CHARGE(), pt_il_policy_bean
							.getUI_M_LC_BROK_COMM(), pt_il_policy_bean
							.getUI_M_FC_BROK_COMM(), pt_il_policy_bean
							.getUI_M_FC_INST_PREM(), pt_il_policy_bean
							.getUI_M_LC_INST_PREM(), pt_il_policy_bean
							.getPOL_NO(), pt_il_policy_bean
							.getPOL_MODE_OF_PYMT_RATE(), CommonUtils
							.getGlobalVariable("GLOBAL.M_AGENT_RATE"), null,
					null, null, null, null, dummy.getUI_M_ENDT_QUOT_FLAG(),
					CommonUtils.getGlobalVariable("GLOBAL.M_LC_CHECK"),
					CommonUtils.getGlobalObject("GLOBAL.M_LC_CHECK"),
					CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID"), null,
					CommonUtils.getGlobalObject("GLOBAL.M_PARAM_18"));

			
			pt_il_pol_assured_dtls.setPOAD_HEIGHT((Double) pvalList.get(0)
					.getValueObject());
			pt_il_pol_assured_dtls.setPOAD_WEIGHT((Double) pvalList.get(1)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_MON_ANNU_AMT((Double) pvalList.get(2)
					.getValueObject());
			pt_il_policy_bean.setPOL_MODE_OF_PYMT((String) pvalList.get(3)
					.getValueObject());
			pt_il_policy_bean.setPOL_LAST_INST_DT((Date) pvalList.get(4)
					.getValueObject());
			pt_il_policy_bean.setPOL_APPRV_STATUS((String) pvalList.get(5)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_SUM_ASSURED((Double) pvalList.get(6)
					.getValueObject());
			pt_il_policy_bean.setPOL_FRZ_FLAG((String) pvalList.get(7)
					.getValueObject());
			pt_il_policy_bean.setPOL_RES_ADDRESS_1((String) pvalList.get(8)
					.getValueObject());
			pt_il_policy_bean.setPOL_NEW_FC_SA((Double) pvalList.get(9)
					.getValueObject());
			pt_il_policy_bean.setPOL_JOINT_LIFE_AGE((Integer) pvalList.get(10)
					.getValueObject());
			pt_il_policy_bean.setPOL_FLEX_03((String) pvalList.get(11)
					.getValueObject());
			pt_il_policy_bean.setPOL_END_NO((String) pvalList.get(12)
					.getValueObject());
			pt_il_policy_bean.setPOL_ORG_NEW_FC_SA((Double) pvalList.get(13)
					.getValueObject());
			pt_il_pol_assured_dtls.setPOAD_AGE((Integer) pvalList.get(14)
					.getValueObject());
			System.out.println("pt_il_policy_bean.getPOL_END_NO()    :  "+pt_il_policy_bean.getPOL_END_NO());
			System.out.println("Dhinesh123 END keyCommit ");
			pt_il_policy_bean.setUI_M_POL_FC_PREM_PAYABLE((Double) pvalList
					.get(15).getValueObject());
			pt_il_policy_bean.setUI_M_POL_LC_PREM_PAYABLE((Double) pvalList
					.get(16).getValueObject());
			pt_il_policy_bean.setPOL_FC_DEPOSIT_AMOUNT((Double) pvalList
					.get(17).getValueObject());
			pt_il_policy_bean.setPOL_LC_DEPOSIT_AMOUNT((Double) pvalList
					.get(18).getValueObject());
			pt_il_policy_bean.setUI_M_POL_FC_TOT_CHARGE((Double) pvalList.get(
					19).getValueObject());
			pt_il_policy_bean.setUI_M_POL_LC_TOT_CHARGE((Double) pvalList.get(
					20).getValueObject());
			pt_il_policy_bean.setPOL_FC_AMAN_PREM((Double) pvalList.get(21)
					.getValueObject());
			pt_il_policy_bean.setPOL_LC_AMAN_PREM((Double) pvalList.get(22)
					.getValueObject());

			pt_il_policy_bean.setPOL_LC_HEALTH_LOAD((Double) pvalList.get(23)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_HEALTH_LOAD((Double) pvalList.get(24)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_SENABEL_PREM((Double) pvalList.get(25)
					.getValueObject());
			pt_il_policy_bean.setPOL_LC_SENABEL_PREM((Double) pvalList.get(26)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_FC_SA((Double) pvalList.get(27)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_LC_SA((Double) pvalList.get(28)
					.getValueObject());
			pt_il_policy_bean.setPOL_BASIC_RATE((Double) pvalList.get(29)
					.getValueObject());
			pt_il_policy_bean.setPOL_HEALTH_RATE((Double) pvalList.get(30)
					.getValueObject());
			pt_il_policy_bean.setPOL_LC_ADDL_PREM((Double) pvalList.get(31)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_ADDL_PREM((Double) pvalList.get(32)
					.getValueObject());

			pt_il_surr_mat_values.setSMV_FC_GROSS_VALUE((Double) pvalList.get(
					33).getValueObject());
			pt_il_policy_bean.setPOL_LC_SUM_ASSURED((Double) pvalList.get(34)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_CURR_SA((Double) pvalList.get(35)
					.getValueObject());
			pt_il_policy_bean.setPOL_NEW_LC_SA((Double) pvalList.get(36)
					.getValueObject());
			pt_il_policy_bean.setPOL_LC_CURR_SA((Double) pvalList.get(37)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_FC_TOT_PREM((Double) pvalList.get(38)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_LC_TOT_PREM((Double) pvalList.get(39)
					.getValueObject());
			if (pt_il_policy_bean.getPOL_FC_SUM_ASSURED() != null
					&& pt_il_policy_bean.getPOL_FC_SUM_ASSURED() > 0) {
				pt_il_policy_bean.setUI_M_POL_FC_TOT_LOADING((Double) pvalList
						.get(40).getValueObject());
				pt_il_policy_bean.setUI_M_POL_LC_TOT_LOADING((Double) pvalList
						.get(41).getValueObject());
			} else {
				pt_il_policy_bean.setUI_M_POL_FC_TOT_LOADING(0.0);
				pt_il_policy_bean.setUI_M_POL_LC_TOT_LOADING(0.0);
			}
			pt_il_policy_bean.setUI_M_POL_FC_TOT_DISCOUNT((Double) pvalList
					.get(42).getValueObject());

			pt_il_policy_bean.setUI_M_POL_LC_TOT_DISCOUNT((Double) pvalList
					.get(43).getValueObject());
			pt_il_policy_bean.setUI_M_FC_PCHARGES_BORNE_CUST((Double) pvalList
					.get(44).getValueObject());
			pt_il_policy_bean.setUI_M_LC_PCHARGES_BORNE_CUST((Double) pvalList
					.get(45).getValueObject());
			pt_il_policy_bean.setUI_M_FC_PCHARGES_BORNE_COMP((Double) pvalList
					.get(46).getValueObject());
			pt_il_policy_bean.setUI_M_LC_PCHARGES_BORNE_COMP((Double) pvalList
					.get(47).getValueObject());
			pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_CUST((Double) pvalList
					.get(48).getValueObject());
			pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_CUST((Double) pvalList
					.get(49).getValueObject());
			pt_il_policy_bean.setUI_M_FC_SCHARGES_BORNE_COMP((Double) pvalList
					.get(50).getValueObject());
			pt_il_policy_bean.setUI_M_LC_SCHARGES_BORNE_COMP((Double) pvalList
					.get(51).getValueObject());
			pt_il_policy_bean.setUI_M_POL_FC_NET_PREM((Double) pvalList.get(52)
					.getValueObject());

			pt_il_policy_bean.setUI_M_POL_LC_NET_PREM((Double) pvalList.get(53)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_INST_FC_PREM((Double) pvalList
					.get(54).getValueObject());
			pt_il_policy_bean.setUI_M_POL_INST_LC_PREM((Double) pvalList
					.get(55).getValueObject());
			pt_il_policy_bean.setUI_M_POL_FC_MOP((Double) pvalList.get(56)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_LC_MOP((Double) pvalList.get(57)
					.getValueObject());
			pt_il_policy_bean.setUI_M_POL_FC_GR_ANN_PREM((Double) pvalList.get(
					58).getValueObject());
			pt_il_policy_bean.setUI_M_POL_LC_GR_ANN_PREM((Double) pvalList.get(
					59).getValueObject());
			pt_il_policy_bean.setPOL_FC_NETT_PREM((Double) pvalList.get(60)
					.getValueObject());
			pt_il_policy_bean.setPOL_LC_NETT_PREM((Double) pvalList.get(61)
					.getValueObject());
			pt_il_policy_bean.setPOL_FC_BASIC_PREM((Double) pvalList.get(62)
					.getValueObject());

			pt_il_policy_bean.setPOL_LC_BASIC_PREM((Double) pvalList.get(63)
					.getValueObject());
			pt_il_policy_bean.setPOL_ORG_NEW_LC_SA((Double) pvalList.get(64)
					.getValueObject());
			dummy.setUI_M_TD_MIN_RATE((Double) pvalList.get(65)
					.getValueObject());
			dummy.setUI_M_TD_MAX_RATE((Double) pvalList.get(66)
					.getValueObject());
			pt_il_policy_bean.setPOL_LC_MON_ANNU_AMT((Double) pvalList.get(67)
					.getValueObject());
			pt_il_policy_bean.setPOL_NO_OF_UNIT((Double) pvalList.get(68)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_OCC_LOAD((Double) pvalList.get(69)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_OCC_LOAD((Double) pvalList.get(70)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_DEATH_LOAD((Double) pvalList.get(71)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_DEATH_LOAD((Double) pvalList.get(72)
					.getValueObject());

			pt_il_policy_bean.setUI_M_FC_TPD_LOAD((Double) pvalList.get(73)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_TPD_LOAD((Double) pvalList.get(74)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_MED_LOAD((Double) pvalList.get(75)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_MED_LOAD((Double) pvalList.get(76)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_GROSS_CONT((Double) pvalList.get(77)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_GROSS_CONT((Double) pvalList.get(78)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_CHARGE((Double) pvalList.get(79)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_CHARGE((Double) pvalList.get(80)
					.getValueObject());
			dummy.setUI_M_COMPY_FC_CHARGE((Double) pvalList.get(81)
					.getValueObject());
			dummy.setUI_M_COMPY_LC_CHARGE((Double) pvalList.get(82)
					.getValueObject());

			pt_il_policy_bean.setUI_M_LC_BROK_COMM((Double) pvalList.get(83)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_BROK_COMM((Double) pvalList.get(84)
					.getValueObject());
			pt_il_policy_bean.setUI_M_FC_INST_PREM((Double) pvalList.get(85)
					.getValueObject());
			pt_il_policy_bean.setUI_M_LC_INST_PREM((Double) (pvalList.get(86)
					.getValueObject()));
			pt_il_policy_bean.setPOL_NO((String) (pvalList.get(87)
					.getValueObject()));
			pt_il_policy_bean.setPOL_MODE_OF_PYMT_RATE((Double) (pvalList
					.get(88).getValueObject()));
			CommonUtils.setGlobalVariable("GLOBAL.M_AGENT_RATE",
					(String) pvalList.get(89).getValueObject());
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT().setRequired(
					booleanValue((String) pvalList.get(90).getValueObject()));
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT().setRequired(
					booleanValue((String) pvalList.get(91).getValueObject()));
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS().setRequired(
					booleanValue((String) pvalList.get(92).getValueObject()));

			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE().setRequired(
					booleanValue((String) pvalList.get(93).getValueObject()));
			if ("N"
					.equalsIgnoreCase((String) pvalList.get(94)
							.getValueObject())) {
				dummy_action.getCOMP_UI_M_BUT_APPROVAL().setDisabled(false);
			} else {
				dummy_action.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
			}
			dummy.setUI_M_ENDT_QUOT_FLAG((String) pvalList.get(95)
					.getValueObject());
			CommonUtils.setGlobalObject("GLOBAL.M_LC_CHECK", (String) pvalList
					.get(96).getValueObject());
			CommonUtils.setGlobalVariable("GLOBAL.M_LC_CHECK",
					(String) (pvalList.get(97).getValueObject()));
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", (Long) (pvalList
					.get(98).getValueObject()));
			outCome = (String) (pvalList.get(99).getValueObject());
			/*P_M_POL_REG_EXCESS_PREM add by Ameen on 10-03-2018 for FSD_IL_04_GOLDA*/
			pt_il_policy_bean.setPOL_REG_EXCESS_PREM((Double) pvalList.get(100).getValueObject());
			/*End for FSD_IL_04_GOLDA*/
			
			 
		} catch (Exception e) {
			e.printStackTrace();
			
			/*Added by sankara narayanan for business rule issue on 04-03-2017*/
			String query13 = "  SELECT BREM_ERR_FLAG  FROM   PT_BUS_RULE_ERROR_MSG  WHERE  BREM_POL_SYS_ID  = ?   AND    "
					+ "     BREM_APPLY_LEVEL =?  AND BREM_GRP_ID  = 'IL'";
			Object[] values  = new Object[] { pt_il_policy_bean.getPOL_SYS_ID(), "T" };
			ResultSet rs13 = new CRUDHandler().executeSelectStatement(query13, CommonUtils.getConnection(), values);
			if (rs13.next()) {
				
				 dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false); 
				 
				 throw new Exception("Please Check the Business Rule.");
			} else {
				dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(true);
				/*dummy_action.getCOMP_UI_M_BUS_RUL().setDisabled(false);*/
				throw new Exception(e.getMessage());
			}
			/*end*/
			
			
			
		}
		return outCome;
	}

	public boolean booleanValue(String value) {

		boolean flag = false;
		try {

			if ("Y".equals(value)) {
				flag = true;
			} else if ("N".equals(value)) {
				flag = false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public String UI_M_BUT_CUSTOMER_WHEN_BUTTON_PRESSED(
			PT_IL_POLICY pt_il_policy) throws Exception {

		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String CALLING_FORM = null;
		String M_GLOBAL_M_PARA_2 = null;

		try {

			if (pt_il_policy.getPOL_NO() != null) {

				if (pt_il_policy.getROWID() != null) {
					/*
					 * throw new Exception( Messages.getString(
					 * PELConstants.pelErrorMessagePath,"71048" ));
					 */
					// STD_MESSAGE_ROUTINE(71048,:CTRL.M_LANG_CODE);
					// RAISE FORM_TRIGGER_FAILURE;
				}
				if (!"A".equals(CommonUtils.nvl(pt_il_policy
						.getPOL_APPRV_STATUS(), "N"))) {
					CommonUtils.setGlobalVariable(
							"GLOBAL.M_PREV_POL_CUST_CODE", pt_il_policy
									.getPOL_CUST_CODE());
					CommonUtils.setGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE",
							pt_il_policy.getPOL_CUST_CODE());
					CommonUtils.setGlobalVariable("GLOBAL.M_POL_CUST_CODE",
							pt_il_policy.getPOL_CUST_CODE());
				} else {
					CommonUtils.setGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE",
							pt_il_policy.getPOL_CUST_CODE());// GLOBAL.M_POL_CUST_CODE
					CommonUtils.setGlobalVariable("GLOBAL.M_POL_CUST_CODE",
							pt_il_policy.getPOL_CUST_CODE());
				}

				M_GLOBAL_M_PARA_2 = CommonUtils
						.getGlobalVariable("GLOBAL.M_PARA_2"); // --ADDED
				// BY
				// SARVINDER
				CALLING_FORM = "loadCustomerMaster";
				CommonUtils.setGlobalVariable("GLOBAL.M_PARA_2",
						M_GLOBAL_M_PARA_2);

				if ((CommonUtils
						.getGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE") != null && !"A"
						.equals(CommonUtils.nvl(pt_il_policy
								.getPOL_APPRV_STATUS(), "N")))
						|| (pt_il_policy.getPOL_CUST_CODE() == null && !"A"
								.equals(CommonUtils.nvl(pt_il_policy
										.getPOL_APPRV_STATUS(), "N")))) {

					pt_il_policy.setPOL_CUST_CODE(CommonUtils
							.getGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE"));

					CommonUtils.setGlobalVariable("GLOBAL.M_POL_CUST_CODE",
							pt_il_policy.getPOL_CUST_CODE());
				}
			} else {
				CommonUtils.setGlobalVariable("GLOBAL.M_NEW_POL_CUST_CODE",
						pt_il_policy.getPOL_CUST_CODE());
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_CUST_CODE",
						pt_il_policy.getPOL_CUST_CODE());
				M_GLOBAL_M_PARA_2 = CommonUtils
						.getGlobalVariable("GLOBAL.M_PARA_2");
				CALLING_FORM = "loadCustomerMaster";
				CommonUtils.setGlobalVariable("GLOBAL.M_PARA_2",
						M_GLOBAL_M_PARA_2);
			}

			CommonUtils.setGlobalVariable("CALL_FORM_FOR_CUST", "PILT002_APAC");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return CALLING_FORM;
	}

	public String UI_M_BUT_CONTRACTOR_WHEN_BUTTON_PRESSED(
			PT_IL_POLICY pt_il_policy) throws Exception {

		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		String CALLING_FORM = null;
		String M_GLOBAL_M_PARA_2 = null;
		String CALLING_FORM_OUTCOME = null;

		try {

			if (pt_il_policy.getPOL_CONT_CODE() != null) {
				CALLING_FORM = "PILM016_APAC_PM_IL_CONTRACTOR";
				CALLING_FORM_OUTCOME = "PILT002_APAC_PT_IL_POLICY";
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_CONT_CODE",
						pt_il_policy.getPOL_CONT_CODE());
				CommonUtils.setGlobalVariable("CALLING_FORM_OUTCOME",
						CALLING_FORM_OUTCOME);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return CALLING_FORM;
	}

	public void UI_M_POL_DOC_CODE_WHEN_VALIDATE_ITEM(DUMMY dummy_bean,
			PT_IL_POLICY pt_il_policy_bean, String currValue) throws Exception {
		dummy_bean.setUI_M_POL_DOC_CODE(currValue);
		try {

			if (dummy_bean.getUI_M_POL_DOC_CODE() != null) {

				new PILT002_APAC_LOCAL_PROCEDURES().L_DOC_DESC(dummy_bean);
				if ("1".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARA_11"))
						&& "Q".equals(CommonUtils
								.getGlobalVariable("GLOBAL.M_PARA_13"))) { // THEN--IF
					// CONDITION
					// ADDED
					// BY
					// INDRANEEL.K
					ArrayList<String> arrlist = new LIFELIB()
							.P_SET_DOC_NO_PROP(
									"1",
									dummy_bean.getUI_M_POL_DOC_CODE(),
									pt_il_policy_bean.getPOL_DIVN_CODE(),
									pt_il_policy_bean.getPOL_CLASS_CODE(),
									pt_il_policy_bean.getPOL_PLAN_CODE(),
									pt_il_policy_bean.getPOL_PROD_CODE(),
									CommonUtils
											.getProcedureValue(pt_il_policy_bean
													.getPOL_UW_YEAR()),
									"DUMMY.M_POL_NO",
									"DUMMY",
									"Y",
									CommonUtils
											.getProcedureValue(pt_il_policy_bean
													.getPOL_ISSUE_DT()), null,
									null, null, null);
				} else {
					new LIFELIB().P_SET_DOC_NO_PROP("2", dummy_bean
							.getUI_M_POL_DOC_CODE(), pt_il_policy_bean
							.getPOL_DIVN_CODE(), pt_il_policy_bean
							.getPOL_CLASS_CODE(), pt_il_policy_bean
							.getPOL_PLAN_CODE(), pt_il_policy_bean
							.getPOL_PROD_CODE(), CommonUtils
							.getProcedureValue(pt_il_policy_bean
									.getPOL_UW_YEAR()), "DUMMY.M_POL_NO",
							"DUMMY", "Y", CommonUtils
									.getProcedureValue(pt_il_policy_bean
											.getPOL_ISSUE_DT()), null, null,
							null, null);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void UI_M_BUT_STATUS_OK_WHEN_BUTTON_PRESSED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws ProcedureException {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		try {
			pValOrclList = new PILPK_PILT002_STATUS_OK().STATUS_OK_BUT_PRESSED(
					pt_il_policy_bean.getPOL_SYS_ID(), pt_il_policy_bean
							.getPOL_PROD_CODE(), pt_il_policy_bean
							.getPOL_END_NO_IDX(), pt_il_policy_bean
							.getPOL_DS_TYPE(), pt_il_policy_bean
							.getPOL_DS_CODE(), pt_il_policy_bean
							.getPOL_CONT_CODE(), pt_il_policy_bean
							.getPOL_PROP_NO(), pt_il_policy_bean
							.getPOL_END_CODE(), dummy_bean
							.getUI_M_POL_MEDICAL_FLAG(), dummy_bean
							.getUI_M_CALC_METHOD(), dummy_bean
							.getUI_M_POL_POSTPONE_DAYS(), pt_il_policy_bean
							.getPOL_CUST_CURR_CODE(), pt_il_policy_bean
							.getPOL_FC_FIRST_PREM(), pt_il_policy_bean
							.getPOL_LC_FIRST_PREM(), pt_il_policy_bean
							.getPOL_ISSUE_DT(), pt_il_policy_bean
							.getPOL_STD_RISK_YN(), pt_il_policy_bean
							.getPOL_LC_SUM_ASSURED(), pt_il_policy_bean
							.getPOL_LC_DEPOSIT_AMOUNT(), pt_il_policy_bean
							.getPOL_NO(), pt_il_policy_bean.getPOL_END_TYPE(),
					CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"), null,
					compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
							.getPT_IL_POL_BROKER_HEAD_BEAN()
							.getPOBH_COMM_CODE(), pt_il_policy_bean
							.getPOL_FRZ_FLAG(), pt_il_policy_bean
							.getPOL_END_DT(), pt_il_policy_bean
							.getPOL_ISSUE_DT(), pt_il_policy_bean
							.getPOL_JOINT_LIFE_YN(), dummy_bean
							.getUI_M_PS_STATUS_DT(), dummy_bean
							.getUI_M_POL_PLAN_TYPE(), pt_il_policy_bean
							.getPOL_APPRV_STATUS(), pt_il_policy_bean
							.getPOL_ADDL_STATUS(), pt_il_policy_bean
							.getPOL_HOLD_YN(), pt_il_policy_bean
							.getPOL_STATUS(), dummy_bean.getUI_M_PS_STATUS(),
					pt_il_policy_bean.getPOL_APPRV_DT(), dummy_bean
							.getUI_M_PS_REASON_CODE(), dummy_bean
							.getUI_M_PS_REMARKS(), dummy_bean
							.getUI_M_REASON_DESC(), pt_il_policy_bean
							.getPOL_CUST_CODE(), CommonUtils.getControlBean()
							.getM_COMM_DEL(), pt_il_policy_bean
							.getPOL_POSTPONE_EXPIRY_DT(), pt_il_policy_bean
							.getPOL_POSTPONE_DAYS(), null, null, null, null,
							 /*added by raja on 02-08-2017 for ZBILQC-1731915 */
							dummy_bean.getPS_RI_CODE());
			/*end*/

			pt_il_policy_bean.setPOL_APPRV_STATUS((String) pValOrclList.get(0)
					.getValueObject());
			pt_il_policy_bean.setPOL_ADDL_STATUS((String) pValOrclList.get(1)
					.getValueObject());
			pt_il_policy_bean.setPOL_HOLD_YN((String) pValOrclList.get(2)
					.getValueObject());
			pt_il_policy_bean.setPOL_STATUS((String) pValOrclList.get(3)
					.getValueObject());
			dummy_bean.setUI_M_PS_STATUS((String) pValOrclList.get(4)
					.getValueObject());
			pt_il_policy_bean.setPOL_APPRV_DT((Date) pValOrclList.get(5)
					.getValueObject());
			dummy_bean.setUI_M_PS_REASON_CODE((String) pValOrclList.get(6)
					.getValueObject());
			dummy_bean.setUI_M_PS_REMARKS((String) pValOrclList.get(7)
					.getValueObject());
			dummy_bean.setUI_M_REASON_DESC((String) pValOrclList.get(8)
					.getValueObject());
			CommonUtils.getControlBean().setM_COMM_DEL(
					(String) pValOrclList.get(9).getValueObject());
			pt_il_policy_bean.setPOL_POSTPONE_EXPIRY_DT((Date) (pValOrclList
					.get(10).getValueObject()));
			pt_il_policy_bean.setPOL_POSTPONE_DAYS((Double) pValOrclList
					.get(11).getValueObject());
			if ("Y".equals(pValOrclList.get(12).getValueObject()))
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_PS_STATUS()
						.setRequired(true);
			if ("Y".equals(pValOrclList.get(13).getValueObject()))
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_PS_REASON_CODE().setRequired(true);
			else if ("N".equals(pValOrclList.get(13).getValueObject()))
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_PS_REASON_CODE().setRequired(false);
			if ("Y".equals(pValOrclList.get(14).getValueObject()))
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_PS_STATUS_DT().setRequired(true);
			else if ("N".equals(pValOrclList.get(14).getValueObject()))
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_PS_STATUS_DT().setRequired(false);
			dummy_bean.setUI_M_PRINT_TYPE((String) pValOrclList.get(15)
					.getValueObject());

		} catch (Exception e) {
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
	}

	public void PS_STATUS_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Date POL_START_DT = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_START_DT();
		Date PS_STATUS_DT = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN().getUI_M_PS_STATUS_DT();
		Date POL_EXPIRT_DT = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT();

		//Commented for AS demo
		/*Connection connection = null;
		ResultSet rs = null;
		Date LAST_STATUS_DT=null;
		String query1 = "  SELECT MAX(PS_STATUS_DT) FROM PT_IL_POL_STATUS WHERE PS_POL_SYS_ID=   ? ";*/

		if ((PS_STATUS_DT.before(POL_START_DT))
				|| (PS_STATUS_DT.after(POL_EXPIRT_DT))) {
			try {
				throw new Exception("Status Date should Be in Policy Period");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}
		/*connection = CommonUtils.getConnection();
		 
		rs = new CRUDHandler().executeSelectStatement(query1, connection, new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
		if (rs.next()) {
			LAST_STATUS_DT = rs.getDate(1);
		}
		if(LAST_STATUS_DT!=null && PS_STATUS_DT.before(LAST_STATUS_DT)){
			try {
				throw new Exception("Status Date should Be after "+ CommonUtils.dateToStringFormat(LAST_STATUS_DT));
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}*/

	}
	
	
	public void autoUnderwritingValidate(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		String M_AUTO_UW = null;
		String C1 = "SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT WHERE PROD_CODE= (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?)";
		try {
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(C1, connection,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			if (resultSet1.next()) {
				M_AUTO_UW = resultSet1.getString(1);
			}
			/*
			 * commented by Ameen on 15-03-2018 as per siva sugg.
			 * if ("Y".equalsIgnoreCase(M_AUTO_UW)) {
				pkg_pilt002_apac.L_UPDATE_JE_STATUS_MED(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_SYS_ID());
			}*/
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} /*catch (ProcedureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}*/
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	/*Added by saranya on 17-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes*/
	public static ArrayList<String> callProcP_POL_ISSUE_DT(Long P_POL_SYS_ID)throws SQLException, Exception 
	{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
			connection = CommonUtils.getConnection();
			int value=Integer.parseInt(P_POL_SYS_ID.toString());
			parameterList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, value);
			OracleParameter param2 = new OracleParameter("OUT1",OracleParameter.DATA_TYPE.DATE,OracleParameter.DIRECTION_TYPE.OUT,"");
			OracleParameter param3 = new OracleParameter("OUT2",OracleParameter.DATA_TYPE.DATE,OracleParameter.DIRECTION_TYPE.OUT,"");
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList=procHandler.executeProc(parameterList, connection,
					"P_POL_ISSUE_DT");
			
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
			
				System.out.println("Output value:::" + oracleParameter.getValueObject());
				returnList.add(oracleParameter.getValueObject().toString());
				
			}
			return returnList;
		
	}
	/*END*/
	

}
