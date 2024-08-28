/**
 * 
 */
package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

/**
 * @author 55221
 * 
 */
public class PILQ003_LOCAL_PROCEDURES {

	public void IL_ENDT_002_PROPS(PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		try {

			if (!"A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| !"S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				if ("P".equals(dummy_bean.getUI_M_COVER_SA_CALC())
						|| "V".equals(dummy_bean.getUI_M_COVER_SA_CALC())
						|| "A".equals(dummy_bean.getUI_M_COVER_SA_CALC())) {
					pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED()
					.setDisabled(true);// ', UPDATEABLE
					// ,PROPERTY_FALSE);
					pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED()
					.setDisabled(true);// ', UPDATEABLE
					// ,PROPERTY_FALSE);
				} else {

					if ("Y".equals(CommonUtils.getGlobalVariable(
					"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						if (pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED()
								.isDisabled() == false) {
							pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED()
							.setDisabled(false); // ', UPDATEABLE
							// ,PROPERTY_TRUE);
						}
						if (pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED()
								.isDisabled() == false) {
							pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED()
							.setDisabled(false);// ', UPDATEABLE
							// ,PROPERTY_TRUE);
						}
					}
				}
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);
			} else if ("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true);// ', UPDATEABLE ,PROPERTY_FALSE);
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true); // ', UPDATEABLE ,PROPERTY_FALSE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {

					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
					.setDisabled(false);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(false);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(false);
				}
			}

			if ("PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))
					&& "C".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_18"))) {

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
				.setDisabled(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
				.setDisabled(true);
			}

			// -- pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT', UPDATEABLE
			// ,PROPERTY_TRUE);
			// -- pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE', UPDATEABLE
			// ,PROPERTY_TRUE);
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(false);
			}
			// -- pt_il_policy_action.getCOMP_POL_OCC_RATE', UPDATEABLE
			// ,PROPERTY_TRUE);
			// -- pt_il_policy_action.getCOMP_POL_HEALTH_RATE', UPDATEABLE
			// ,PROPERTY_TRUE);

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true); // -----changed by piyush

			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void IL_ENDT_003_004_BLK_DISABLE(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		try {
			if (!"PILT041_APAC".equals(CommonUtils
					.getGlobalVariable("CALLING_FORM"))) {

				pt_il_policy_action.setUPDATE_ALLOWED(false);
				pt_il_policy_action.setDELETE_ALLOWED(false);

				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

				pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

				pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

				pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
				pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
				pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void IL_ENDT_005_BLK_DISABLE(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();

		try {

			pt_il_policy_action.setUPDATE_ALLOWED(false);
			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_charge_action.setINSERT_ALLOWED(false);
			pt_il_pol_charge_action.setUPDATE_ALLOWED(false);
			pt_il_pol_charge_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
			pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
			pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void IL_ENDT_016_BLK_DISABLE(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();

		try {
			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);

			pt_il_pol_assr_med_hist_action.getCOMP_PAMH_FIELD_01().setDisabled(
					true);
			pt_il_pol_assr_med_hist_action.getCOMP_PAMH_FIELD_01().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);
			// --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled( true);
			pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			// --pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled( true);
			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ASSURED_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_UNIT().setDisabled(true);

			// --
			// SET_BLOCK_PROPERTY('PT_IL_POLICY',UPDATE_ALLOWED,PROPERTY_FALSE);
			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

			pt_il_pol_charge_action.setINSERT_ALLOWED(false);
			pt_il_pol_charge_action.setUPDATE_ALLOWED(false);
			pt_il_pol_charge_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
			pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
			pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_FM_DT()
			.setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_TO_DT()
			.setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_PERIOD().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PERIOD().setDisabled(
					true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FC_SA().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_LC_SA().setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);
			// -- pt_il_pol_addl_cover_action.getCOMP_POAC_FC_SA().setDisabled(
					// true);
			// -- pt_il_pol_addl_cover_action.getCOMP_POAC_LC_SA().setDisabled(
			// true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_RATE().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_RATE_PER().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_WOP_FLAG().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_MED_DAYS().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_LC_MED_AMT().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void L_IL_END_007_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_UNPAID_PREM_DTLS_ACTION pt_il_unpaid_prem_dtls_action = compositeAction
		.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();

		try {
			pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			// --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled( true);
			// --pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(
			// true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			// --
			// SET_BLOCK_PROPERTY('PT_IL_POLICY',UPDATE_ALLOWED,PROPERTY_FALSE);

			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_surr_mat_values_action.setINSERT_ALLOWED(false);
			pt_il_surr_mat_values_action.setUPDATE_ALLOWED(false);
			pt_il_surr_mat_values_action.setDELETE_ALLOWED(false);

			pt_il_unpaid_prem_dtls_action.setINSERT_ALLOWED(false);
			pt_il_unpaid_prem_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_unpaid_prem_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void IL_BLOCK_POL_DISABLED(
		PILQ003_COMPOSITE_ACTION compositeAction) {
	 
	   /* SET_BLOCK_PROPERTY('PT_IL_POLICY',UPDATE_ALLOWED,PROPERTY_FALSE); 
	    SET_BLOCK_PROPERTY('PT_IL_POLICY',DELETE_ALLOWED,PROPERTY_FALSE); */

	    compositeAction.getPT_IL_POLICY_ACTION_BEAN().setUPDATE_ALLOWED(false);
	    compositeAction.getPT_IL_POLICY_ACTION_BEAN().setDELETE_ALLOWED(false);
	  //  compositeAction.getPT_IL_POLICY_ACTION_BEAN().disableAllComponent(true);
	    
	    compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_POLICY2_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().disableAllComponent(true);
	    compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().disableAllComponent(true);

	    	if ("S".equals(CommonUtils.nvl(compositeAction
	    		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
	    			.getPOL_STATUS(), "N"))) {
	    		if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
	    				.substring(2, 3))) {
	    			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
	    			.setUPDATE_ALLOWED(true);
	    		}
	    	} else {
	    			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
	    			.setINSERT_ALLOWED(false);
	    			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
	    			.setUPDATE_ALLOWED(false);
	    			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
	    			.setDELETE_ALLOWED(false);
	    	 }

	    		compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
	    		.setDELETE_ALLOWED(false);
	}
	
	public void IL_BLOCK_POL_DISABLEDOld(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_CONDITION_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_STATUS_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().setINSERT_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().setUPDATE_ALLOWED(
				false);
		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().setDELETE_ALLOWED(
				false);

		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_POLICY2_ACTION_BEAN().setDELETE_ALLOWED(false);

		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		 

		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.setINSERT_ALLOWED(false);
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.setUPDATE_ALLOWED(false);
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

		if ("S".equals(CommonUtils.nvl(compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_STATUS(), "N"))) {
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.setUPDATE_ALLOWED(true);
			}
		} else {
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.setINSERT_ALLOWED(false);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.setUPDATE_ALLOWED(false);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
			.setDELETE_ALLOWED(false);
		}

		compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN()
		.setDELETE_ALLOWED(false);

	}

	public void IL_ENDT_006_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_UNPAID_PREM_DTLS_ACTION pt_il_unpaid_prem_dtls_action = compositeAction
		.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();

		try {

			// -- pt_il_policy_action.getCOMP_POL_CUST_CODE'().setDisabled(
			// true); commented on29/9/2003 suggessted by Subbu

			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);

			/*
			 * --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled( true);
			 * --pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(
			 * true);
			 */
			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				pt_il_pol_disc_load_action.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_disc_load_action.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				pt_il_pol_disc_load_action.setDELETE_ALLOWED(true);
			}

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				pt_il_pol_charge_action.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_charge_action.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				pt_il_pol_charge_action.setDELETE_ALLOWED(true);
			}
			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_status_action.setINSERT_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);
			pt_il_pol_status_action.setDELETE_ALLOWED(false);

			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',UPDATE_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
			 */

			// --BY Rajavel on 10/2/2003
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);
			// -- BY Rajavel on 7/9/2003 impact 43
			pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			// -- pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled( true);
			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);

			pt_il_doc_todo_list_status_action.getCOMP_DTLS_SR_NO().setDisabled(
					true);
			if ("Y".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_INCORPORATED_YN(), "N"))) {
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
			}

			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --BY Gopal.S on 6-MAY-2003
			 * for Issue Id KEN-IL-023
			 */

			pt_il_pol_beneficiary_action.setINSERT_ALLOWED(false);
			pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(false);
			pt_il_pol_beneficiary_action.setDELETE_ALLOWED(false);

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true); // ----Changed by piyush
			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);

			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void IL_ENDT_QUOT_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		COPY_ACTION copy_action = new COPY_ACTION();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();

		try {
			if ("Q".equals(pt_il_policy_bean.getPOL_PROP_QUOT_FLAG())) {
				dummy_action.getCOMP_UI_M_BUT_APPROVAL().setRendered(false);
				//pt_il_policy_action.getCOMP_UI_M_BUT_COPY().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_ENDT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_SURR_MAT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_PRMDTLS().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_UPI().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_UDDATE_STAT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD().setRendered(
						false);
				dummy_action.getCOMP_UI_M_BUT_POL_AMDT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_HOLD().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CONVERT().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_UPLOAD().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CLAIM().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CONTRACTOR().setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_CUSTOMER().setRendered(false);
				pt_il_pol_broker_head_action.getCOMP_UI_M_BUT_SHOW_AGENT()
				.setRendered(false);
				dummy_action.getCOMP_UI_M_BUT_REPLACE_POLICY().setRendered(
						false);
				dummy_action.getCOMP_UI_M_BUT_ASSR_MORE_INFO().setRendered(
						false);
				dummy_bean.setUI_M_ADDL_STATUS_DESC(null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void IL_ENDT_011_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		try {

			pt_il_policy_action.setINSERT_ALLOWED(false);
			pt_il_policy_action.setUPDATE_ALLOWED(false);
			pt_il_policy_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				pt_il_pol_charge_action.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_charge_action.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				pt_il_pol_charge_action.setDELETE_ALLOWED(true);
			}

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_status_action.setINSERT_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);
			pt_il_pol_status_action.setDELETE_ALLOWED(false);

			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS().setDisabled(
			 * true);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
			 */

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {
				pt_il_pol_beneficiary_action.setINSERT_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(true);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(2, 3))) {
				pt_il_pol_beneficiary_action.setDELETE_ALLOWED(true);
			}

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true);// ---------Changed by piyush

			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);

			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void IL_BLOCK_POL_ENABLED(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();
		PT_IL_POL_FUND_DTL_ACTION pt_il_pol_fund_dtl_action = compositeAction
		.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
		PT_IL_UNPAID_PREM_DTLS_ACTION pt_il_unpaid_prem_dtls_action = compositeAction
		.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PM_IL_DOC_TODO_GROUP_ACTION pm_il_doc_todo_group_action = compositeAction
		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		String M_ASD_CHAR_VALUE = null;
		String query1 = "  SELECT  ASD_CHAR_VALUE  FROM    PM_IL_APPR_SETUP_DET"
			+ "  WHERE   ASD_USER_ID =?  AND  ASD_CODE  = ? "
			+ "  AND  ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND  "
			+ "  NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')  ";
		Object[] values = {};
		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					0, 1).equals("Y")) {
			   // pt_il_policy_action.disableAllComponent(false);
			    pt_il_policy_action.setINSERT_ALLOWED(true);
				pt_il_pol_assured_dtls_action.disableAllComponent(false);
				pt_il_pol_assured_dtls_1_action.disableAllComponent(false);
				pt_il_pol_addl_cover_action.disableAllComponent(false);
				pt_il_pol_addl_cover_1_action.disableAllComponent(false);
				pt_il_pol_beneficiary_action.disableAllComponent(false);
				pt_il_pol_assr_med_hist_action.disableAllComponent(false);
				pt_il_pol_charge_action.disableAllComponent(false);
				pt_il_pol_broker_head_action.disableAllComponent(false);
				
				/*pt_il_policy_action.setINSERT_ALLOWED(true);
				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(true);
				pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_beneficiary_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
				pt_il_pol_charge_action.setINSERT_ALLOWED(true);
				pt_il_pol_broker_head_action.setINSERT_ALLOWED(true);*/

			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					1, 2).equals("Y")) {
			    //pt_il_policy_action.disableAllComponent(false);
			    pt_il_policy_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assured_dtls_action.disableAllComponent(false);
				pt_il_pol_assured_dtls_1_action.disableAllComponent(false);
				pt_il_pol_addl_cover_action.disableAllComponent(false);
				pt_il_pol_addl_cover_1_action.disableAllComponent(false);
				pt_il_pol_beneficiary_action.disableAllComponent(false);
				pt_il_pol_assr_med_hist_action.disableAllComponent(false);
				pt_il_pol_charge_action.disableAllComponent(false);
				pt_il_pol_broker_head_action.disableAllComponent(false);
				/*pt_il_policy_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
				pt_il_pol_charge_action.setUPDATE_ALLOWED(true);
				pt_il_pol_broker_head_action.setUPDATE_ALLOWED(true);*/
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					2, 3).equals("Y")) {
			    //pt_il_policy_action.disableAllComponent(false);
			    pt_il_policy_action.setDELETE_ALLOWED(true);
				pt_il_pol_assured_dtls_action.disableAllComponent(false);
				pt_il_pol_assured_dtls_1_action.disableAllComponent(false);
				pt_il_pol_addl_cover_action.disableAllComponent(false);
				pt_il_pol_addl_cover_1_action.disableAllComponent(false);
				pt_il_pol_beneficiary_action.disableAllComponent(false);
				pt_il_pol_assr_med_hist_action.disableAllComponent(false);
				pt_il_pol_charge_action.disableAllComponent(false);
				pt_il_pol_broker_head_action.disableAllComponent(false);
				/*pt_il_policy_action.setDELETE_ALLOWED(true);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(true);
				pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(true);
				pt_il_pol_beneficiary_action.setDELETE_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);
				pt_il_pol_charge_action.setDELETE_ALLOWED(true);
				pt_il_pol_broker_head_action.setDELETE_ALLOWED(true);*/
			}
			values = new Object[] {
					CommonUtils.getControlBean().getM_USER_ID(), "MOD_COMM_YN",
					pt_il_policy_bean.getPOL_PROD_CODE() };

			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_ASD_CHAR_VALUE = rs.getString(1);
			}

			if ("Y".equalsIgnoreCase(M_ASD_CHAR_VALUE)) {
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
						.substring(0, 1).equals("Y")) {

					pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(true);
				}
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
						.substring(1, 2).equals("Y")) {

					pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(true);
				}
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
						.substring(2, 3).equals("Y")) {

					pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(true);
				}
			} else {
				/*pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);*/
			    pt_il_pol_broker_dtl_action.disableAllComponent( true);
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					0, 1).equals("Y")) {

				pt_il_pol_condition_action.disableAllComponent(false);
				pt_il_pol_disc_load_action.disableAllComponent(false);
				pt_il_surr_mat_values_action.disableAllComponent(false);
				pt_il_unpaid_prem_dtls_action.disableAllComponent(false);
				pt_il_pol_assr_illness_dtls_action.disableAllComponent(false);
				pt_il_pol_med_exam_dtl_action.disableAllComponent(false);
				pm_il_doc_todo_group_action.disableAllComponent(false);
				pt_il_doc_todo_list_status_action.disableAllComponent(false);
				
			/*	pt_il_pol_condition_action.setINSERT_ALLOWED(true);
				pt_il_pol_disc_load_action.setINSERT_ALLOWED(true);
				pt_il_surr_mat_values_action.setINSERT_ALLOWED(true);
				pt_il_unpaid_prem_dtls_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_illness_dtls_action.setINSERT_ALLOWED(true);
				pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(true);
				pm_il_doc_todo_group_action.setINSERT_ALLOWED(true);
				pt_il_doc_todo_list_status_action.setINSERT_ALLOWED(true);*/
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					1, 2).equals("Y")) {
			    pt_il_pol_condition_action.disableAllComponent(false);
				pt_il_pol_disc_load_action.disableAllComponent(false);
				pt_il_surr_mat_values_action.disableAllComponent(false);
				pt_il_unpaid_prem_dtls_action.disableAllComponent(false);
				pt_il_pol_assr_illness_dtls_action.disableAllComponent(false);
				pt_il_pol_med_exam_dtl_action.disableAllComponent(false);
				pm_il_doc_todo_group_action.disableAllComponent(false);
				pt_il_doc_todo_list_status_action.disableAllComponent(false);
				
				/*pt_il_pol_condition_action.setUPDATE_ALLOWED(true);
				pt_il_pol_disc_load_action.setUPDATE_ALLOWED(true);
				pt_il_surr_mat_values_action.setUPDATE_ALLOWED(true);
				pt_il_unpaid_prem_dtls_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_illness_dtls_action.setUPDATE_ALLOWED(true);
				pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(true);
				pm_il_doc_todo_group_action.setUPDATE_ALLOWED(true);
				pt_il_doc_todo_list_status_action.setUPDATE_ALLOWED(true);*/
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(
					2, 3).equals("Y")) {
			    pt_il_pol_condition_action.disableAllComponent(false);
				pt_il_pol_disc_load_action.disableAllComponent(false);
				pt_il_surr_mat_values_action.disableAllComponent(false);
				pt_il_unpaid_prem_dtls_action.disableAllComponent(false);
				pt_il_pol_assr_illness_dtls_action.disableAllComponent(false);
				pt_il_pol_med_exam_dtl_action.disableAllComponent(false);
				pm_il_doc_todo_group_action.disableAllComponent(false);
				pt_il_doc_todo_list_status_action.disableAllComponent(false);

				/*pt_il_pol_condition_action.setDELETE_ALLOWED(true);
				pt_il_pol_disc_load_action.setDELETE_ALLOWED(true);
				pt_il_surr_mat_values_action.setDELETE_ALLOWED(true);
				pt_il_unpaid_prem_dtls_action.setDELETE_ALLOWED(true);
				pt_il_pol_assr_illness_dtls_action.setDELETE_ALLOWED(true);
				pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(true);
				pm_il_doc_todo_group_action.setDELETE_ALLOWED(true);
				pt_il_doc_todo_list_status_action.setDELETE_ALLOWED(true);*/
			}

			if ( "N".equalsIgnoreCase(dummy_bean.getUI_M_NOTIONAL())) {
				/*pt_il_pol_fund_dtl_action.setINSERT_ALLOWED(false);
				pt_il_pol_fund_dtl_action.setUPDATE_ALLOWED(false);
				pt_il_pol_fund_dtl_action.setDELETE_ALLOWED(false);*/
			    pt_il_pol_fund_dtl_action.disableAllComponent( true);

			} else if ("O".equals(dummy_bean.getUI_M_NOTIONAL())) {
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")!=null && 
						CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
						.substring(0, 1).equals("Y")) {
					pt_il_pol_fund_dtl_action.setINSERT_ALLOWED(true);
					pt_il_pol_fund_dtl_action.disableAllComponent( false);
				}
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")!=null &&
						CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
						.substring(1, 2).equals("Y")) {
					pt_il_pol_fund_dtl_action.setUPDATE_ALLOWED(true);
					pt_il_pol_fund_dtl_action.disableAllComponent( false);

				}
				if (CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")!=null &&
						CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
						.substring(2, 3).equals("Y")) {
					pt_il_pol_fund_dtl_action.setDELETE_ALLOWED(true);
					pt_il_pol_fund_dtl_action.disableAllComponent( false);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void IL_ENDT_015_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();

		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		try {

			if ("M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
			"X"))
			&& CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),
			"000").equals(
					CommonUtils.nvl(dummy_bean.getUI_M_IL_RED_SA_END(),
							"000"))) {
				pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
			} else {
				if (!"PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) { // --ADDED BY
					// SARVINDER
					if ("Y".equals(CommonUtils.getGlobalVariable(
					"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
								false);
					}
				} else {
					pt_il_policy_action.getCOMP_POL_FRZ_FLAG()
					.setDisabled(true);
				}
			}

			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);
			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --
			 * pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled( true);
			 */
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);

			// -- pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(
			// true);

			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);

			if ("Y".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_INCORPORATED_YN(), "N"))) {// = 'Y' THEN
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
			}
			dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD().setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_DISC_AGE().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			// --added by anamika
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DISC_AGE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			/*
			 * --end -- pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT',
			 * UPDATEABLE ,PROPERTY_TRUE);
			 * 
			 * --added for QIIC on 25/10/01
			 */
			/*
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_FC_AMAN_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_LC_AMAN_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_FC_SENABEL_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_LC_SENABEL_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_FC_AMAN_LOAD_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 * SET_ITEM_PROPERTY('PT_IL_POL_ASSURED_DTLS.POAD_LC_AMAN_LOAD_PREM',
			 * UPDATEABLE ,PROPERTY_FALSE);
			 */
			// --upto this
			pt_il_pol_beneficiary_action.setINSERT_ALLOWED(false);
			pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(false);
			pt_il_pol_beneficiary_action.setDELETE_ALLOWED(false);

			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS().setDisabled(
			 * true);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
			 */

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_condition_action.setINSERT_ALLOWED(false);
			pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
			pt_il_pol_condition_action.setDELETE_ALLOWED(false);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE()
				.setDisabled(false);
			}
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE_PROOF_FLAG()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE_PROOF_OTHERS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE_PROOF_FLAG()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE_PROOF_OTHERS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_NO_OF_CIGAR()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_NO_OF_CIGAR()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_RELIGION_CODE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_RELIGION_CODE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SALARY().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SALARY()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SALARY().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SALARY()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_BIRTH_PLACE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_BIRTH_PLACE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_RACE().setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_RACE().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_REMARKS().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_REMARKS().setDisabled(
					true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {

				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CODE()
				.setDisabled(false);
			}
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);

			pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE().setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
			.setDisabled(true);

			// --Added by Rajavel.s on 8/9/2003 IMPACT 43

			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true); // ----Changed by piyush
			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);

			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);

			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void IL_ENDT_002_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		PT_IL_POL_BENEFICIARY_ACTION pt_il_pol_beneficiary_action = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();

		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null;
		Connection connection = null;
		Object[] values = {};

		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		String query1 = "  SELECT PS_CODE   FROM   PP_SYSTEM    WHERE PS_TYPE ='IL_SUBPLAN' ";
		String query2 = "  SELECT PROD_SA_BY_PLAN_BASIS_YN  FROM PM_IL_PRODUCT"
			+ "  WHERE PROD_CODE= ? ";
		String query3 = "  SELECT PS_CODE   FROM   PP_SYSTEM    WHERE PS_TYPE ='IL_ADD_RIDER' ";
		String query4 = "  SELECT PS_CODE   FROM   PP_SYSTEM    WHERE PS_TYPE ='IL_DEL_RIDER' ";
		CRUDHandler handler = new CRUDHandler();
		String M_FC_VALUE = null;
		String M_LC_VALUE = null;
		String M_PS_CODE = null;
		String M_PS_CODE_1 = null;
		String M_PS_CODE_2 = null;
		String M_PROD_SA_BY_PLAN_BASIS_YN = null;
		try {
			if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {// -----ADDED BY
				// VANITHA----GEN END----
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
				.setDisabled(true);
			}

			rs1 = handler.executeSelectStatement(query1, connection);
			if (rs1.next()) {
				M_PS_CODE = rs1.getString(1);
			}
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };

			rs2 = handler.executeSelectStatement(query2, connection, values);
			if (rs2.next()) {
				M_PROD_SA_BY_PLAN_BASIS_YN = rs2.getString(1);
			}
			if ("Y".equals(CommonUtils.nvl(M_PROD_SA_BY_PLAN_BASIS_YN, "N"))) {

				if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))
						&& M_PS_CODE
						.equals(pt_il_policy_bean.getPOL_END_TYPE())) { // ---ADDED
					// BY
					// VANITHA---GEN
					// END---

					// --pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(
					// true);
					// --pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
					// true);
					pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_ISSUE_DT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
					pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
					pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_STAFF_YN()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
					pt_il_policy_action.getCOMP_POL_CQS_PERC()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_START_DT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_FIRST_INST_DT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(
							true);
					// -- pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(
					// true);
					pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
					pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
					pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

					pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
					pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
					pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

					pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
					pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
					pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

					pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
					pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(false);
					pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

					pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
					pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
					pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

					pt_il_pol_condition_action.setINSERT_ALLOWED(false);
					pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
					pt_il_pol_condition_action.setDELETE_ALLOWED(false);
				}
			}

			/*
			 * --ADDES BY AMANA ON 13/08/2008 -- Reason : Additional covers are
			 * not able to delete during INCSA
			 */
			rs3 = handler.executeSelectStatement(query3, connection);
			if (rs3.next()) {
				M_PS_CODE_1 = rs3.getString(1);
			}
			rs4 = handler.executeSelectStatement(query4, connection);
			if (rs4.next()) {
				M_PS_CODE_2 = rs4.getString(1);
			}

			if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					&& M_PS_CODE_1.equals(pt_il_policy_bean.getPOL_END_CODE())) {
				// --pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(
				// true);
				// --pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LAST_INST_DT()
				.setDisabled(true);
				// --pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(
						true);

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true); // ',ENABLED,PROPERTY_FALSE); -- ADDED BY
				// ABHINAV TO RESTRICT DURING ADDRIDER
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true);// ',ENABLED,PROPERTY_FALSE); --

				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(true);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

				pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
				pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
				pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

				pt_il_pol_condition_action.setINSERT_ALLOWED(false);
				pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
				pt_il_pol_condition_action.setDELETE_ALLOWED(false);

				pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);

				pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(true);
			} else if ("002".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					&& M_PS_CODE_2.equals(pt_il_policy_bean.getPOL_END_CODE())) {
				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(true);

				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(true);
			} else if (!"013".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {

				// --pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(
				// true);
				// --pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LAST_INST_DT()
				.setDisabled(true);
				// --pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(
				// true);
				pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(
						true);

				pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

				pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
				pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
				pt_il_pol_addl_cover_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

				pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
				pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
				pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

				pt_il_pol_condition_action.setINSERT_ALLOWED(false);
				pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
				pt_il_pol_condition_action.setDELETE_ALLOWED(false);

			}

			if ("M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),
			"X"))
			&& CommonUtils.nvl(pt_il_policy_bean.getPOL_END_CODE(),
			"000").equals(
					CommonUtils.nvl(dummy_bean.getUI_M_IL_RED_SA_END(),
							"000"))) {
				pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
			} else {
				if (!"PILT041_APAC".equals(CommonUtils
						.getGlobalVariable("CALLING_FORM"))) { // --ADDED BY
					// SARVINDER FOR
					// POLICY
					// CORRECTION
					if ("Y".equals(CommonUtils.getGlobalVariable(
					"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
								false);
					} else {
						pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(
								true);
					}
				}

				pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_NO().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE()
				.setDisabled(true);
				// --pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(
				// true); ---commented by sivaram for FSD-25
				pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);

				dummy_action.getCOMP_UI_M_BUT_CALC_DISC_LOAD()
				.setDisabled(true);

				pt_il_pol_assured_dtls_action.getCOMP_POAD_DISC_AGE()
				.setDisabled(true);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
				.setDisabled(true);
				// --added by anamika
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DISC_AGE()
				.setDisabled(true);
				pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
				.setDisabled(true);

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_pol_beneficiary_action.setINSERT_ALLOWED(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_pol_beneficiary_action.setUPDATE_ALLOWED(false);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					pt_il_pol_beneficiary_action.setDELETE_ALLOWED(false);
				}

				/*
				 * IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
				 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',INSERT_ALLOWED,PROPERTY_FALSE);
				 * END IF; IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y'
				 * THEN
				 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS().setDisabled(
				 * true); END IF; IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) =
				 * 'Y' THEN
				 * SET_BLOCK_PROPERTY('PT_IL_POL_ASSR_ILLNESS_DTLS',DELETE_ALLOWED,PROPERTY_FALSE);
				 * END IF;
				 */

				// --COMMENTED AND ADDED BY DHAMODHARAN
				/*
				 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',INSERT_ALLOWED,PROPERTY_FALSE);
				 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL().setDisabled(
				 * true);
				 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',DELETE_ALLOWED,PROPERTY_FALSE);
				 */

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(true);
				}
				pt_il_pol_condition_action.setINSERT_ALLOWED(false);
				pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
				pt_il_pol_condition_action.setDELETE_ALLOWED(false);

				if ("013".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {

					// --Added by Indra on 26/08/2008
					pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID1()
					.setDisabled(false);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_ASSURED_NAME()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE_PROOF_FLAG()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_NO_OF_CIGAR()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_NATIONALITY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_RELIGION_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_BIRTH_PLACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_RACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_NATURE_OF_WORK()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_REMARKS()
					.setDisabled(true);

					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_REF_ID1()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ASSURED_NAME()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_AGE_PROOF_FLAG().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_NO_OF_CIGAR()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_NATIONALITY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_MAR_STATUS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_RELIGION_CODE().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SALARY()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_BIRTH_PLACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_RACE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_NATURE_OF_WORK().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_REMARKS()
					.setDisabled(true);
					// --Added by end Indra on 26/08/2008

					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_FC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_LC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_FC_AMAN_LOAD_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_action
					.getCOMP_POAD_LC_AMAN_LOAD_PREM().setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
					.setDisabled(true);

					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_SUM_ASSURED().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_SUM_ASSURED().setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_SENABEL_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_FC_AMAN_LOAD_PREM().setDisabled(true);
					pt_il_pol_assured_dtls_1_action
					.getCOMP_POAD_LC_AMAN_LOAD_PREM().setDisabled(true);

					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT()
					.setDisabled(true);

					pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_INCORPORATED_YN()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG()
					.setDisabled(true);

					pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(
							true);
					pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(
							true);

					pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF()
					.setDisabled(true);

					pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB()
					.setDisabled(false);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
					.setDisabled(false);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
					.setDisabled(false);
				} else {
					pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB()
					.setDisabled(true);
					pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
					.setDisabled(true);
					pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
					.setDisabled(true);
				}

				// --Added by Rajavel.s on 8/9/2003 IMPACT 43

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
				.setDisabled(true); // -----changed by piyush ---
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);
				/** * Added for PRFM-FSD3-004-STM requirement 2 **** */

				if ("D".equals(CommonUtils.nvl(dummy_bean
						.getUI_M_POL_PLAN_TYPE(), "X"))
						&& "G".equals(CommonUtils.nvl(dummy_bean
								.getUI_M_COVER_SA_CALC(), "X"))
								&& "002".equals(CommonUtils.nvl(pt_il_policy_bean
										.getPOL_END_TYPE(), "000"))) {
					if (!M_PS_CODE_1
							.equals(pt_il_policy_bean.getPOL_END_CODE())
							|| !M_PS_CODE_2.equals(pt_il_policy_bean
									.getPOL_END_CODE()))
						pt_il_policy_action.getCOMP_POL_FC_MON_ANNU_AMT()
						.setDisabled(false);
				} else if (M_PS_CODE_1.equals(pt_il_policy_bean
						.getPOL_END_CODE())
						|| M_PS_CODE_2.equals(pt_il_policy_bean
								.getPOL_END_CODE())) {

					pt_il_policy_action.getCOMP_POL_FC_MON_ANNU_AMT()
					.setDisabled(true);
					pt_il_policy_action.getCOMP_POL_LC_MON_ANNU_AMT()
					.setDisabled(true);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// completed
	public void IL_UNIQUE_END_NO(PT_IL_POLICY pt_il_policy_bean)
	throws Exception {

		int M_POL_NO = 0;

		String query1 = "  SELECT 1 FROM   PT_IL_POLICY "
			+ " WHERE  POL_NO = ? " + " AND    POL_END_NO =? ";

		Connection connection = null;
		Object[] object1 = {};
		ResultSet resultSet = null;
		try {
			object1 = new Object[] { pt_il_policy_bean.getPOL_NO(),
					pt_il_policy_bean.getPOL_END_NO() };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object1);
			while (resultSet.next()) {
				M_POL_NO = resultSet.getInt(1);
			}
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71062",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}

		} catch (Exception e) {
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

	// completed
	public void IL_UNIQUE_POL_NO(String POL_DS_TYPE, String currValue) {

		int M_POL_NO = 0;

		String query1 = " SELECT 1   FROM   PT_IL_POLICY WHERE  POL_NO = ?   AND    POL_DS_TYPE  =? ";

		Connection connection = null;
		Object[] object1 = {};
		ResultSet resultSet = null;
		try {
			object1 = new Object[] { currValue, POL_DS_TYPE };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object1);
			while (resultSet.next()) {
				M_POL_NO = resultSet.getInt(1);
			}
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71031",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				// STD_MESSAGE_ROUTINE(71031,NAME_IN('GLOBAL.M_LANG_CODE'));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void L_INST_MAT_DTLS( PILQ003_COMPOSITE_ACTION compositeAction) {
	String M_PROD_MAT_AMT_TYPE=null;
	Double M_PROD_MAT_RATE= 0d;
	Double  M_PROD_MAT_RATE_PER=0d;
	String  M_PROD_SURR_PLUS_FACTOR=null;
	String M_PROD_CODE =null;
	String  M_PLAN_CODE=null;
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	CRUDHandler handler = new CRUDHandler();
	PT_IL_POLICY pt_il_policy_bean = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	PT_IL_POL_SA_INST_PYMT_HEAD pt_il_pol_sa_inst_pymt_head = compositeAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN().getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
	PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();

	try {

	    connection = CommonUtils.getConnection();

	    String  C1  ="  SELECT PROD_MAT_AMT_TYPE,PROD_MAT_RATE,PROD_MAT_RATE_PER," +
	    		"PROD_SURR_PLUS_FACTOR,PROD_CODE,PROD_PLAN_CODE ,PROD_SA_INST_PYMT_TYPE " +
	    		"  FROM  PM_IL_PRODUCT  WHERE PROD_CODE= ? "; 
 
	    values = new Object[]{  CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6") };
	     
	     rs = handler.executeSelectStatement(C1, connection,values);
	     if(rs.next()){
		 M_PROD_MAT_AMT_TYPE = rs.getString(1);
		 M_PROD_MAT_RATE  = rs.getDouble(2);
		 M_PROD_MAT_RATE_PER  = rs.getDouble(3);
		 M_PROD_SURR_PLUS_FACTOR = rs.getString(4);
		 M_PROD_CODE  = rs.getString(5);
		 M_PLAN_CODE = rs.getString(6);
		dummy_bean.setUI_M_PROD_SA_INST_PYMT_TYPE(rs.getString(7));
		   
	     }
 
	    	if("C".equalsIgnoreCase(dummy_bean.getUI_M_PROD_SA_INST_PYMT_TYPE())){
	    	 	 pt_il_pol_sa_inst_pymt_head.setSIPH_NAV_TYPE("A");
	    	 	 dummy_bean.setUI_M_PROD_SA_INST_PYMT_TYPE(pt_il_pol_sa_inst_pymt_head.getSIPH_NAV_TYPE()) ;
	    	}
	    	else if("A".equalsIgnoreCase(dummy_bean.getUI_M_PROD_SA_INST_PYMT_TYPE())){
	    	pt_il_pol_sa_inst_pymt_head.setSIPH_NAV_TYPE("I");
	    	 dummy_bean.setUI_M_PROD_SA_INST_PYMT_TYPE(pt_il_pol_sa_inst_pymt_head.getSIPH_NAV_TYPE()) ;
		    		  
	    	}else{
	 	pt_il_pol_sa_inst_pymt_head.setSIPH_NAV_TYPE( dummy_bean.getUI_M_PROD_SA_INST_PYMT_TYPE());	
	    	}
	     pt_il_pol_sa_inst_pymt_head.setSIPH_PROD_MAT_AMT_TYPE(M_PROD_MAT_AMT_TYPE) ;
	     pt_il_pol_sa_inst_pymt_head.setSIPH_PROD_MAT_RATE(CommonUtils.nvl(M_PROD_MAT_RATE,0));
	     pt_il_pol_sa_inst_pymt_head.setSIPH_PROD_MAT_RATE_PER(CommonUtils.nvl(M_PROD_MAT_RATE_PER,0)) ;
	     pt_il_pol_sa_inst_pymt_head.setSIPH_PROD_SURR_PLUS_FACTOR(M_PROD_SURR_PLUS_FACTOR);
	     pt_il_pol_sa_inst_pymt_head.setSIPH_PROD_CODE (M_PROD_CODE) ;
	     pt_il_pol_sa_inst_pymt_head.setSIPH_PLAN_CODE(M_PLAN_CODE); 
	     
	     if(pt_il_pol_assured_dtls_bean.getPOAD_AGE() !=null)
	     pt_il_pol_sa_inst_pymt_head.setSIPH_MAT_AGE(CommonUtils.nvl((pt_il_pol_assured_dtls_bean.getPOAD_AGE() 
		     		+ pt_il_policy_bean.getPOL_PERIOD()) ,0));

	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    
	// completed
	public void IL_UNIQUE_POL_PROP_NO(String POL_DS_TYPE, String currValue) {
	 
		int M_POL_PROP_NO = 0;

		String query1 = " SELECT 1  FROM   PT_IL_POLICY  WHERE  POL_PROP_NO   =  ?   AND  POL_DS_TYPE  =  ?";

		Connection connection = null;
		Object[] object1 = {};
		ResultSet resultSet = null;
		try {
			object1 = new Object[] { currValue, POL_DS_TYPE };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object1);
			while (resultSet.next()) {
				M_POL_PROP_NO = resultSet.getInt(1);
			}
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71031",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				// STD_MESSAGE_ROUTINE(71031,NAME_IN('GLOBAL.M_LANG_CODE'));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// completed
	public void IL_CUST_CURR_EXIST(PT_IL_POLICY pt_il_policy_bean) {

		int M_POL_NO = 0;

		String query1 = "  SELECT 1  FROM   PM_CUST_CURR  "
			+ " WHERE  CCUR_CUST_CODE  = ?  	AND  CCUR_CURR_CODE  = ? "
			+ "  AND    NVL(CCUR_FRZ_FLAG,'N')= 'N' ";

		Connection connection = null;
		Object[] object1 = {};
		ResultSet resultSet = null;
		try {

			object1 = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE(),
					pt_il_policy_bean.getPOL_CUST_CURR_CODE() };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object1);
			while (resultSet.next()) {
				M_POL_NO = resultSet.getInt(1);
			}
			if (resultSet == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71032"));
				// STD_MESSAGE_ROUTINE(71062,NAME_IN('GLOBAL.M_LANG_CODE'));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// completed
	public void IL_POL_PERIOD_CHECK(
			PILQ003_COMPOSITE_ACTION compositeAction,
			PT_IL_POLICY pt_il_policy_bean) {

		int M_POL_NO = 0;
		Double M_FM = null;
		Double M_TO = null;
		Double M_MP = null;
		int M_POL_PERIOD = 0;
		String M_DIFF = null;
		String M_PLAN_AGE_TERM_FLAG = null;
		Double M_PROD_PERIOD_MULTIPLE = null;
		Double M_PAS_MIN_PERIOD = null;
		Double M_PAS_MAX_PERIOD = null;

		String query1 = "  SELECT PLAN_PERIOD_FROM, PLAN_PERIOD_TO FROM   PM_IL_PLAN"
			+ " WHERE  PLAN_CODE   = ? " + "  AND    PLAN_FRZ_FLAG = 'N' ";

		String query2 = " SELECT PLAN_PERIOD_FROM, PLAN_PERIOD_TO, PROD_PERIOD_MULTIPLE"
			+ " FROM   PM_IL_PLAN,PM_IL_PRODUCT WHERE  PLAN_CODE   = ? "
			+ " AND    PROD_CODE   = ?  AND    PLAN_CODE   = PROD_PLAN_CODE"
			+ " AND    PLAN_FRZ_FLAG = 'N' ";

		String query3 = "  SELECT PAS_MIN_PERIOD,PAS_MAX_PERIOD FROM   PM_IL_PLAN_AGE_SETUP"
			+ " WHERE  PAS_PLAN_CODE = ? "
			+ " AND    PAS_JOINT_LIFE_YN =? "
			+ "  AND    DECODE(PAS_AGE_BASIS,'R',? , ?) "
			+ " BETWEEN PAS_CATG_FM_CODE AND PAS_CATG_TO_CODE  AND   "
			+ " DECODE(PAS_AGE_BASIS,'R',? ,? ) "
			+ "  BETWEEN PAS_ASSRD_AGE_FM AND PAS_ASSRD_AGE_TO ";

		String query4 = "  SELECT PAS_MIN_PERIOD,PAS_MAX_PERIOD,PROD_PERIOD_MULTIPLE"
			+ "  FROM   PM_IL_PLAN_AGE_SETUP,PM_IL_PRODUCT"
			+ "  WHERE  PAS_PLAN_CODE = PROD_PLAN_CODE  AND   "
			+ " PAS_JOINT_LIFE_YN = ?  AND"
			+ "  PROD_CODE     = ?  AND    "
			+ " PAS_PLAN_CODE =?  AND   "
			+ " DECODE(PAS_AGE_BASIS,'R',? ,? )"
			+ " BETWEEN PAS_CATG_FM_CODE AND PAS_CATG_TO_CODE   AND "
			+ "   DECODE(PAS_AGE_BASIS,'R',? ,? )"
			+ " BETWEEN PAS_ASSRD_AGE_FM AND PAS_ASSRD_AGE_TO  ";

		Connection connection = null;
		Object[] object1 = {}, object2 = {}, object3 = {}, object4 = {}, objectErr = {};
		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null;

		try {

			object1 = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE() };
			object2 = new Object[] { pt_il_policy_bean.getPOL_PLAN_CODE(),
					pt_il_policy_bean.getPOL_PROD_CODE() };

			object3 = new Object[] {
					pt_il_policy_bean.getPOL_PLAN_CODE(),
					pt_il_policy_bean.getPOL_JOINT_LIFE_YN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN()
					.getPOAD_CATG_CODE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN()
					.getPOAD_CATG_CODE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE() };

			object4 = new Object[] {
					pt_il_policy_bean.getPOL_JOINT_LIFE_YN(),
					pt_il_policy_bean.getPOL_PROD_CODE(),
					pt_il_policy_bean.getPOL_PLAN_CODE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN()
					.getPOAD_CATG_CODE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN()
					.getPOAD_CATG_CODE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE() };

			M_POL_PERIOD = pt_il_policy_bean.getPOL_PERIOD();

			connection = CommonUtils.getConnection();
			if ("H".equals(compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN().getUI_M_PLAN_AGE_TERM_FLAG())) {

				rs1 = new CRUDHandler().executeSelectStatement(query1,
						connection, object1);
				if (rs1.next()) {
					// M_FM = rs1.getDouble("1");
					// M_TO = rs1.getDouble("2");
					rs2 = new CRUDHandler().executeSelectStatement(query2,
							connection, object2);
					while (rs2.next()) {
						M_FM = rs2.getDouble(1);
						M_TO = rs2.getDouble(2);
						M_MP = rs2.getDouble(3);
					}
					if (!(pt_il_policy_bean.getPOL_PERIOD() >= M_FM && pt_il_policy_bean
							.getPOL_PERIOD() <= M_TO)) {
						objectErr = new Object[] { "Policy Period", M_FM, M_TO };
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90010",
								objectErr));
					}

					if ((M_POL_PERIOD % M_MP) != 0) {
						objectErr = new Object[] { M_FM, M_TO, M_MP };
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71033",
								objectErr));
					}
				} else {
					rs2 = new CRUDHandler().executeSelectStatement(query2,
							connection, object2);
					while (rs2.next()) {
						M_FM = rs2.getDouble(1);
						M_TO = rs2.getDouble(2);
						M_MP = rs2.getDouble(3);
					}
					objectErr = new Object[] { M_FM, M_TO, M_MP };
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71033",
							objectErr));

				}
			} else if ("S".equals(compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN().getUI_M_PLAN_AGE_TERM_FLAG())) {
				rs3 = new CRUDHandler().executeSelectStatement(query3,
						connection, object3);
				if (rs3.next()) {
					// M_PAS_MIN_PERIOD = rs3.getDouble("1");
					// M_PAS_MAX_PERIOD = rs3.getDouble("2");

					rs4 = new CRUDHandler().executeSelectStatement(query4,
							connection, object4);
					while (rs4.next()) {
						M_PAS_MIN_PERIOD = rs4.getDouble(1);
						M_PAS_MAX_PERIOD = rs4.getDouble(2);
						M_PROD_PERIOD_MULTIPLE = rs4.getDouble(3);
					}

					if (!(pt_il_policy_bean.getPOL_PERIOD() >= M_PAS_MIN_PERIOD && pt_il_policy_bean
							.getPOL_PERIOD() <= M_PAS_MAX_PERIOD)) {
						objectErr = new Object[] { "Policy Period",
								M_PAS_MIN_PERIOD, M_PAS_MAX_PERIOD };
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90010",
								objectErr));
					}

					if ((M_POL_PERIOD % M_PROD_PERIOD_MULTIPLE) != 0) {
						objectErr = new Object[] { M_PAS_MIN_PERIOD,
								M_PAS_MAX_PERIOD, M_PROD_PERIOD_MULTIPLE };
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71033",
								objectErr));
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void IL_ENDT_001_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {
		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
		PT_IL_POL_CHARGE_ACTION pt_il_pol_charge_action = compositeAction
		.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();
		PT_IL_POL_MED_EXAM_DTL_ACTION pt_il_pol_med_exam_dtl_action = compositeAction
		.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN();
		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION pt_il_pol_assr_illness_dtls_action = compositeAction
		.getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
		.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION pt_il_pol_assr_med_hist_1_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();

		ResultSet rs = null;
		Connection connection = null;
		Object[] values = {};
		CRUDHandler handler = new CRUDHandler();
		DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy_bean = dummy_action.getDUMMY_BEAN();
		String query1 = "   SELECT  ASD_CHAR_VALUE   FROM    PM_IL_APPR_SETUP_DET "
			+ "   WHERE   ASD_USER_ID = ?    AND     "
			+ " ASD_CODE    = 'MOD_COMM_YN'   AND    ? "
			+ " BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";

		String M_ASD_CHAR_VALUE = null;
		try {
			connection = CommonUtils.getConnection();
			if (pt_il_policy_bean.getPOL_END_NO() == null) { // -- ADDED BY
				// ABHINAV FOR
				// STM
				// -- TO MAKE APPRV BUTTON DISABLED IN GENERAL ENDT
				// SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVAL',ENABLED,PROPERTY_FALSE);
				dummy_action.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
			}
			// -- pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true)
			// ; commented on29/9/2003 suggessted by Subbu

			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			// --pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			// -- pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);

			/*
			 * --pt_il_policy_action.getCOMP_POL_OCC_RATE().setDisabled(true);
			 * --pt_il_policy_action.getCOMP_POL_HEALTH_RATE().setDisabled(true);
			 */

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(true);
			}

			pt_il_pol_assured_dtls_action.getCOMP_POAD_DOB().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_AGE().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_TYPE().setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);
			// --
			// pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS().setDisabled(
			// true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CODE().setDisabled(
					true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);
			// --added for QIIC on 25/10/01
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);
			/*
			 * --upto this -- BY Rajavel on 7/9/2003 impact 43
			 */
			pt_il_pol_assured_dtls_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);

			// --Added By Anamika
			pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);

			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(true);
			}
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_DOB()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_AGE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_TYPE().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_ADDL_RISK_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CODE()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEALTH_CODE()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SUM_ASSURED()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_SENABEL_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_FC_AMAN_LOAD_PREM()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_LC_AMAN_LOAD_PREM()
			.setDisabled(true);

			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_HEIGHT_UNIT()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_WEIGHT_UNIT()
			.setDisabled(true);
			// --end

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setUPDATE_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setDELETE_ALLOWED(false);

			if (!"001".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) {// -----ADDED BY
				// VANITHA----GEN END----

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_pol_charge_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_pol_charge_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					pt_il_pol_charge_action.setDELETE_ALLOWED(true);
				}

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_pol_broker_head_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_pol_broker_head_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					pt_il_pol_broker_head_action.setDELETE_ALLOWED(true);
				}

			} else {

				pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);

				pt_il_pol_charge_action.setINSERT_ALLOWED(false);
				pt_il_pol_charge_action.setUPDATE_ALLOWED(false);
				pt_il_pol_charge_action.setDELETE_ALLOWED(false);

			}
			values = new Object[] {CommonUtils.getControlBean().getM_USER_ID(),
						pt_il_policy_bean.getPOL_PROD_CODE() };

			rs = handler.executeSelectStatement(query1, connection, values);
			if (rs.next()) {
				M_ASD_CHAR_VALUE = rs.getString(1);
			}

			if ("Y".equals(M_ASD_CHAR_VALUE)
					&& "001".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) { // ---ADDED BY
				// VANITHA---GEN
				// END---

				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {
					pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(true);
				}
			} else {
				pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
				pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			}

			pt_il_pol_med_exam_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_med_exam_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_status_action.setINSERT_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);
			pt_il_pol_status_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_illness_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_illness_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_illness_dtls_action.setDELETE_ALLOWED(false);

			// --BY Rajavel on 10/2/2003
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);
			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --
			 * pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);
			 */
			pt_il_policy_action.getCOMP_POL_NO_OF_INST().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_INCORPORATED_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_NET_PREM_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_INT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROFIT_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_CALC().setDisabled(true);

			// -- pt_il_policy_action.getCOMP_POL_PYMT_TYPE().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_DEFER_PRD().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_TYPE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BANK_BRANCH_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_GRANTEE_NAME().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_HOME_OWNER_FLAG().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FRZ_FLAG().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_NET_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_NET_PREM().setDisabled(true);

			pt_il_policy_action.getCOMP_POL_FC_PRE_TPD_BNF().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_PRE_TPD_BNF().setDisabled(true);

			pt_il_doc_todo_list_status_action.getCOMP_DTLS_SR_NO().setDisabled(
					true);

			if ("Y".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_INCORPORATED_YN(), "N"))) {
				pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT()
				.setDisabled(true);
				pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled(true);
				pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled(true);
			}

			/*
			 * -- BY Rajavel on 7/9/2003 impact 43 --BY Gopal.S on 6-MAY-2003
			 * for Issue Id KEN-IL-023 --commented by dhamodharan for stm issue
			 * id is STMB-190004
			 */
			/*
			 * SET_BLOCK_PROPERTY('PT_IL_POL_BENEFICIARY',INSERT_ALLOWED,PROPERTY_FALSE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_BENEFICIARY().setDisabled(true);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_BENEFICIARY',DELETE_ALLOWED,PROPERTY_FALSE);
			 */
			// --- ended by dhamodharan for stm issue id is STMB-190004
			// --Added by Paul Joseph on 13/12/2003 as per Impact(003-TISB3)
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(0, 1))) {

				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID1()
				.setDisabled(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID2()
				.setDisabled(false);
			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {

				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID1()
				.setDisabled(false);
				pt_il_pol_assured_dtls_action.getCOMP_POAD_REF_ID2()
				.setDisabled(false);
			}
			// --Added by Paul Joseph on 13/12/2003 as per Impact(003-TISB3)

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(true);
			pt_il_pol_assr_med_hist_action.setDELETE_ALLOWED(true);

			if ("Y".equals(pt_il_policy_bean.getPOL_JOINT_LIFE_YN())) {

				pt_il_pol_assr_med_hist_1_action.setINSERT_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setUPDATE_ALLOWED(true);
				pt_il_pol_assr_med_hist_1_action.setDELETE_ALLOWED(true);
			}

			/*
			 * --ADDED FOR PRFM-FSD-008-STM ON 06/11/2007 BY AMAN -- FOR MEDICAL
			 * FEES RECOVERY AT THE TIME OF POLICY CANCELLATION
			 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL().setDisabled( false);
			 * SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',DELETE_ALLOWED,PROPERTY_TRUE);
			 * ----END HERE-------
			 */
			String POL_PYMT_TYPE = pt_il_policy_bean.getPOL_PYMT_TYPE();

			if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
					|| "C1".equals(POL_PYMT_TYPE) || "C2".equals(POL_PYMT_TYPE)
					|| "C3".equals(POL_PYMT_TYPE) || "C4".equals(POL_PYMT_TYPE)
					|| "C5".equals(POL_PYMT_TYPE) || "C6".equals(POL_PYMT_TYPE)
					|| "AD".equals(POL_PYMT_TYPE)) {

				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
				.setDisabled(false); // ----Changed by Piyush
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
				.setDisabled(false);
				pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO()
				.setDisabled(false);// ----Changed by Piyush
				pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE()
				.setDisabled(false);

				if ("SC".equals(POL_PYMT_TYPE) || "CC".equals(POL_PYMT_TYPE)
						|| "C1".equals(POL_PYMT_TYPE)
						|| "C2".equals(POL_PYMT_TYPE)
						|| "C3".equals(POL_PYMT_TYPE)
						|| "C4".equals(POL_PYMT_TYPE)
						|| "C5".equals(POL_PYMT_TYPE)
						|| "C6".equals(POL_PYMT_TYPE)) {

					if (pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
						.setDisabled(false);
					}
				}

				if ("AD".equals(POL_PYMT_TYPE)) {
					if (pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
							.isRendered() == true) {
						pt_il_policy_action.getCOMP_POL_AUTH_LIMIT()
						.setDisabled(false);
					}
				}
			}

			pt_il_pol_assured_dtls_action.getCOMP_POAD_SMOKE_YN().setDisabled(
					true);// ---------ADDED BY VANITHA----GEN END
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_SMOKE_YN()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_MAR_STATUS()
			.setDisabled(true);
			pt_il_pol_assured_dtls_action.getCOMP_POAD_OCC_CLASS().setDisabled(
					true);
			pt_il_pol_assured_dtls_1_action.getCOMP_POAD_OCC_CLASS()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SUB_PLAN_CODE().setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_FM_DT()
			.setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_TO_DT()
			.setDisabled(true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_PERIOD().setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PREM_PAY_YRS()
			.setDisabled(true);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_PERIOD().setDisabled(
					true);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FC_SA().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_LC_SA().setDisabled(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// completed
	public void IL_PREM_CAL_JL_AGE(Integer P_POAD_AGE, String P_EFF_DT,
			String POL_PLAN_CODE, Long POL_SYS_ID) throws Exception {

		int M_POAD_AGE_1 = 0;
		int M_POAD_AGE_2 = 0;
		int M_ABS_AGE_DIFF = 0;
		int M_MIN_ASS_AGE = 0;
		int M_MAX_ASS_AGE = 0;
		int M_JL_AGE_FTR = 0;
		String M_CODE_DESC = null;
		String M_COVER_DISC_AGE_YN = null;
		int M_IL_JL_AGE = 0;
		int M_IL_JLAGEFCTR = 0;

		String query = " SELECT COVER_DISC_AGE_YN  FROM  PM_IL_COVER   WHERE "
			+ " COVER_CODE = ?";

		String query1 = " SELECT  DECODE(NVL( ?,'N'),'Y',NVL(POAD_DISC_AGE,0),"
			+ " NVL(POAD_AGE,0)) PROD_AGE  FROM    PT_IL_POL_ASSURED_DTLS "
			+ " WHERE   POAD_POL_SYS_ID = ?";

		String queryJL_AGE_FTR = "  SELECT  NVL(JAF_AGE_FACTOR,0) JL_AGE_FTR "
			+ "   FROM    PM_IL_JL_AGE_FACTOR "
			+ "   WHERE   ?  BETWEEN JAF_DIFF_AGE_FROM AND JAF_DIFF_AGE_TO ";

		String query2 = " SELECT JAM_JL_AGE  FROM   PM_IL_JL_AGE_MATRIX "
			+ "    WHERE ?  BETWEEN JAM_AGE_1_FROM AND JAM_AGE_1_TO "
			+ " AND ?  BETWEEN JAM_AGE_2_FROM AND JAM_AGE_2_TO "
			+ " AND  P_EFF_DT  BETWEEN NVL(JAM_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/YYYY'))"
			+ " AND NVL(JAM_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/YYYY'))";

		Connection connection = null;
		Object[] object = {};
		ResultSet resultSet = null;
		ArrayList<String> pValArrayList = new ArrayList<String>();
		try {
			object = new Object[] { POL_PLAN_CODE };
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query,
					connection, object);
			while (resultSet.next()) {
				M_COVER_DISC_AGE_YN = resultSet.getString("COVER_DISC_AGE_YN");
			}

			object = new Object[] { M_COVER_DISC_AGE_YN, POL_SYS_ID };
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection, object);
			while (resultSet.next()) {
				M_POAD_AGE_1 = Integer
				.parseInt(resultSet.getString("PROD_AGE"));
				M_POAD_AGE_2 = Integer
				.parseInt(resultSet.getString("PROD_AGE"));
			}

			/* Calculating the ABS age diff value & assigning the min age */
			String strM_IL_JL_AGE = M_IL_JL_AGE + "";

			pValArrayList = DBProcedures.P_VAL_SYSTEM("IL_JL_AGE", "IL_JL_AGE",
					M_CODE_DESC, "E", strM_IL_JL_AGE);

			if (pValArrayList.size() > 0) {
				M_CODE_DESC = pValArrayList.get(0);
				M_IL_JL_AGE = Integer.parseInt(pValArrayList.get(1));
			}

			if (M_IL_JL_AGE == 1) {
				if ((M_POAD_AGE_1 - M_POAD_AGE_2) < 0) {
					M_ABS_AGE_DIFF = M_POAD_AGE_2 - M_POAD_AGE_1;
					M_MIN_ASS_AGE = M_POAD_AGE_1;
					M_MAX_ASS_AGE = M_POAD_AGE_2;
				} else {
					M_ABS_AGE_DIFF = M_POAD_AGE_1 - M_POAD_AGE_2;
					M_MIN_ASS_AGE = M_POAD_AGE_2;
					M_MAX_ASS_AGE = M_POAD_AGE_1;
				}

				object = new Object[] { M_ABS_AGE_DIFF };
				resultSet = new CRUDHandler().executeSelectStatement(
						queryJL_AGE_FTR, connection, object);
				while (resultSet.next()) {
					M_JL_AGE_FTR = resultSet.getInt("JL_AGE_FTR");
				}

				// P_VAL_SYSTEM('IL_JLAGEFCTR', 'IL_JLAGEFCTR', M_CODE_DESC,
				// 'E', M_IL_JLAGEFCTR) ;

				String strM_IL_JLAGEFCTR = "" + M_IL_JLAGEFCTR;
				pValArrayList = new ArrayList<String>();
				pValArrayList = DBProcedures.P_VAL_SYSTEM("IL_JLAGEFCTR",
						"IL_JLAGEFCTR", M_CODE_DESC, "E", strM_IL_JLAGEFCTR);

				if (pValArrayList.size() > 0) {
					M_CODE_DESC = pValArrayList.get(0);
					M_IL_JLAGEFCTR = Integer.parseInt(pValArrayList.get(1));
				}

				if (M_IL_JLAGEFCTR == 1) {
					P_POAD_AGE = CommonUtils.nvl(M_JL_AGE_FTR, 0)
					+ M_MIN_ASS_AGE; // age factor is added to
					// the
					// min age of the assured
				} else if (M_IL_JLAGEFCTR == 2) {
					P_POAD_AGE = CommonUtils.nvl(M_JL_AGE_FTR, 0)
					+ M_MAX_ASS_AGE; // age factor is added to
					// the
					// min age of the assured
				}
			} else if (M_IL_JL_AGE == 2) {
				object = new Object[] { M_POAD_AGE_1, M_POAD_AGE_2 };
				resultSet = new CRUDHandler().executeSelectStatement(query2,
						connection, object);
				while (resultSet.next()) {
					P_POAD_AGE = resultSet.getInt("JAM_JL_AGE");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	// For post_query

	public void L_DISPLAY_TAKAFUL_SUMMARY(PT_IL_POLICY pt_il_policy_bean,
			DUMMY dummy_bean) {

		String query1 = " SELECT NVL(PDL_FC_DISC_LOAD_VALUE,0), NVL(PDL_LC_DISC_LOAD_VALUE,0)"
			+ " FROM   PT_IL_POL_DISC_LOAD,   PP_SYSTEM  WHERE PS_TYPE = 'IL_MTLD_CODE'"
			+ " AND   PS_CODE = ? AND   PS_CODE_DESC = PDL_DISC_LOAD_CODE  "
			+ " AND   PDL_POL_SYS_ID = ? ";

		String query2 = "SELECT NVL(SUM(POC_FC_VALUE),0) , NVL(SUM(POC_LC_VALUE),0) "
			+ " FROM PT_IL_POL_CHARGE  WHERE POC_POL_SYS_ID = ?  ";

		String query3 = "SELECT NVL(PDL_FC_DISC_LOAD_VALUE,0),   NVL(PDL_LC_DISC_LOAD_VALUE,0)  "
			+ " FROM   PT_IL_POL_DISC_LOAD,  PP_SYSTEM  WHERE PS_TYPE = 'IL_UWOC_LOAD' "
			+ " AND   PS_CODE_DESC = PDL_DISC_LOAD_CODE  AND   "
			+ " PDL_POL_SYS_ID = ?   ";

		String query4 = "  SELECT POL_FC_BASIC_PREM,  POL_LC_BASIC_PREM,   POL_FC_ADDL_PREM, "
			+ " POL_LC_ADDL_PREM,  POL_FC_NET_PREM,   POL_LC_NET_PREM, POL_NO_OF_INST, "
			+ " POL_ORG_NO_OF_INST, POL_FC_SUM_ASSURED,  POL_LC_SUM_ASSURED "
			+ " FROM   PT_IL_POLICY  WHERE  POL_SYS_ID =? ";

		String query5 = " SELECT NVL(SUM(POC_FC_VALUE * POC_CUST_SHARE_PERC /100),0) , "
			+ " NVL(SUM(POC_LC_VALUE * POC_CUST_SHARE_PERC /100),0) FROM PT_IL_POL_CHARGE "
			+ " WHERE POC_POL_SYS_ID = ? ";

		Double M_POL_FC_BASIC_PREM = 0d;
		Double M_POL_LC_BASIC_PREM = 0d;
		Double M_POL_FC_ADDL_PREM = 0d;
		Double M_POL_LC_ADDL_PREM = 0d;
		Double M_POL_NO_OF_INST = 0d;
		Double M_POL_ORG_NO_OF_INST = 0d;
		Double M_POL_FC_NET_PREM = 0d;
		Double M_POL_LC_NET_PREM = 0d;
		Double M_FC_TEMP_GROSS_CONT = 0d;
		Double M_LC_TEMP_GROSS_CONT = 0d;
		Double M_POL_FC_SUM_ASSURED = 0d;
		Double M_POL_LC_SUM_ASSURED = 0d;
		Double M_BROK_PER = 0d;
		Double M_FC_VALUE = 0d;
		Double M_LC_VALUE = 0d;
		Connection connection = null;
		ResultSet rs1 = null, rs2 = null, rs5 = null, rs4 = null, rs3 = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();
			pt_il_policy_bean.setUI_M_FC_OCC_LOAD(0d);
			pt_il_policy_bean.setUI_M_LC_OCC_LOAD(0d);
			pt_il_policy_bean.setUI_M_FC_DEATH_LOAD(0d);
			pt_il_policy_bean.setUI_M_LC_DEATH_LOAD(0d);
			pt_il_policy_bean.setUI_M_FC_TPD_LOAD(0d);
			pt_il_policy_bean.setUI_M_LC_TPD_LOAD(0d);

			values = new Object[] { "IL_MLOD_DTH",
					pt_il_policy_bean.getPOL_SYS_ID() };

			rs1 = handler.executeSelectStatement(query1, connection, values);
			if (rs1.next()) {
				pt_il_policy_bean.setUI_M_FC_DEATH_LOAD(rs1.getDouble(1));
				pt_il_policy_bean.setUI_M_LC_DEATH_LOAD(rs1.getDouble(2));
			}
			values = new Object[] { "IL_MLOD_TPD",
					pt_il_policy_bean.getPOL_SYS_ID() };

			rs1 = handler.executeSelectStatement(query1, connection, values);
			if (rs1.next()) {
				pt_il_policy_bean.setUI_M_FC_TPD_LOAD(rs1.getDouble(1));
				pt_il_policy_bean.setUI_M_LC_TPD_LOAD(rs1.getDouble(2));
			}

			pt_il_policy_bean.setUI_M_FC_MED_LOAD(CommonUtils.nvl(
					pt_il_policy_bean.getUI_M_FC_DEATH_LOAD(), 0)
					+ CommonUtils.nvl(pt_il_policy_bean.getUI_M_FC_TPD_LOAD(),
							0));

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getUI_M_FC_MED_LOAD()), "R", pt_il_policy_bean
							.getPOL_PROD_CODE());
			if (!pValList.isEmpty()) {
				pt_il_policy_bean.setUI_M_FC_MED_LOAD(Double
						.parseDouble(pValList.get(0)));
			}

			pt_il_policy_bean.setUI_M_LC_MED_LOAD(CommonUtils.nvl(
					pt_il_policy_bean.getUI_M_LC_DEATH_LOAD(), 0)
					+ CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_TPD_LOAD(),
							0));

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getUI_M_FC_MED_LOAD()), "R", pt_il_policy_bean
							.getPOL_PROD_CODE());

			if (!pValList.isEmpty()) {
				pt_il_policy_bean.setUI_M_FC_MED_LOAD(Double
						.parseDouble(pValList.get(0)));
			}

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };

			rs3 = handler.executeSelectStatement(query3, connection, values);
			if (rs3.next()) {
				pt_il_policy_bean.setUI_M_FC_OCC_LOAD(rs3.getDouble(1));
				pt_il_policy_bean.setUI_M_LC_OCC_LOAD(rs3.getDouble(2));
			}

			rs4 = handler.executeSelectStatement(query4, connection, values);
			if (rs4.next()) {
				M_POL_FC_BASIC_PREM = rs4.getDouble(1);
				M_POL_LC_BASIC_PREM = rs4.getDouble(2);
				M_POL_FC_ADDL_PREM = rs4.getDouble(3);
				M_POL_LC_ADDL_PREM = rs4.getDouble(4);
				M_POL_FC_NET_PREM = rs4.getDouble(5);
				M_POL_LC_NET_PREM = rs4.getDouble(6);
				M_POL_NO_OF_INST = rs4.getDouble(7);
				M_POL_ORG_NO_OF_INST = rs4.getDouble(8);
				M_POL_FC_SUM_ASSURED = rs4.getDouble(9);
				M_POL_LC_SUM_ASSURED = rs4.getDouble(10);
			}

			/*
			 * The Total Gross Contribution is independant of Whether Net
			 * Contribution is Yes or NO, The Total Gross Contribution formula
			 * varies when the Premium Incorporated Flag is Yes/No Modified the
			 * Below lines of Code to Accommodate the same by Sudha R on
			 * 20/06/2003
			 */

			M_FC_TEMP_GROSS_CONT = CommonUtils.nvl(M_POL_FC_BASIC_PREM, 0)
			+ CommonUtils.nvl(pt_il_policy_bean.getUI_M_FC_MED_LOAD(),
					0)
					+ CommonUtils.nvl(pt_il_policy_bean.getUI_M_FC_OCC_LOAD(),
							0);

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(), CommonUtils
					.getProcedureValue(M_FC_TEMP_GROSS_CONT), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			if (!pValList.isEmpty()) {
				M_FC_TEMP_GROSS_CONT = Double.parseDouble(pValList.get(0));
			}

			M_LC_TEMP_GROSS_CONT = CommonUtils.nvl(M_POL_LC_BASIC_PREM, 0)
			+ CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_MED_LOAD(),
					0)
					+ CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_OCC_LOAD(),
							0);

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), CommonUtils
					.getProcedureValue(M_LC_TEMP_GROSS_CONT), "R",
					pt_il_policy_bean.getPOL_PROD_CODE());

			if (!pValList.isEmpty()) {
				M_LC_TEMP_GROSS_CONT = Double.parseDouble(pValList.get(0));
			}

			pt_il_policy_bean.setUI_M_FC_GROSS_CONT(CommonUtils.nvl(
					M_FC_TEMP_GROSS_CONT, 0));

			pt_il_policy_bean.setUI_M_LC_GROSS_CONT(CommonUtils.nvl(
					M_LC_TEMP_GROSS_CONT, 0));

			values = new Object[] { pt_il_policy_bean.getPOL_SYS_ID() };

			rs2 = handler.executeSelectStatement(query2, connection, values);
			if (rs2.next()) {
				pt_il_policy_bean.setUI_M_FC_CHARGE(rs2.getDouble(1));
				pt_il_policy_bean.setUI_M_LC_CHARGE(rs2.getDouble(1));
			}
			// PENDING // IF :SYSTEM.RECORD_STATUS = 'QUERY' THEN

			values = new Object[] { pt_il_policy_bean.getPOL_CUST_CODE() };

			rs5 = handler.executeSelectStatement(query5, connection, values);
			if (rs5.next()) {
				dummy_bean.setUI_M_COMPY_FC_CHARGE(rs5.getDouble(1));
				dummy_bean.setUI_M_COMPY_LC_CHARGE(rs5.getDouble(1));
			}
			// END IF;

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.L_CAL_BROKER_RATE(CommonUtils
					.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getPOL_CUST_CURR_CODE()), CommonUtils
							.getProcedureValue(dummy_bean.getUI_M_BASE_CURR()),
							CommonUtils.getProcedureValue(pt_il_policy_bean
									.getUI_M_FC_GROSS_CONT()), CommonUtils
									.getProcedureValue(pt_il_policy_bean
											.getUI_M_LC_GROSS_CONT()), CommonUtils
											.getProcedureValue(pt_il_policy_bean
													.getUI_M_FC_BROK_COMM()), CommonUtils
													.getProcedureValue(pt_il_policy_bean
															.getUI_M_LC_BROK_COMM()), CommonUtils
															.getProcedureValue(M_BROK_PER));

			if (!pValList.isEmpty()) {
				pt_il_policy_bean.setUI_M_FC_GROSS_CONT(Double
						.parseDouble(pValList.get(0)));
				pt_il_policy_bean.setUI_M_LC_GROSS_CONT(Double
						.parseDouble(pValList.get(1)));
				pt_il_policy_bean.setUI_M_FC_BROK_COMM(Double
						.parseDouble(pValList.get(2)));
				pt_il_policy_bean.setUI_M_LC_BROK_COMM(Double
						.parseDouble(pValList.get(3)));
				M_BROK_PER = Double.parseDouble(pValList.get(4));

			}

			if ("Y".equalsIgnoreCase(pt_il_policy_bean.getPOL_NET_PREM_YN())) {
				pt_il_policy_bean.setUI_M_LC_BROK_COMM(0d);
				pt_il_policy_bean.setUI_M_FC_BROK_COMM(0d);
			}

			M_POL_NO_OF_INST = CommonUtils.nvl(M_POL_NO_OF_INST, 0)
			+ CommonUtils.nvl(M_POL_ORG_NO_OF_INST, 0);

			if (M_POL_NO_OF_INST == 0) {
				M_POL_NO_OF_INST = 1d;
			}

			pt_il_policy_bean.setUI_M_FC_INST_PREM((CommonUtils.nvl(
					pt_il_policy_bean.getUI_M_FC_GROSS_CONT(), 0))
					/ CommonUtils.nvl(M_POL_NO_OF_INST, 1));

			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getUI_M_FC_INST_PREM()), "R", pt_il_policy_bean
							.getPOL_PROD_CODE());

			if (!pValList.isEmpty()) {
				pt_il_policy_bean.setUI_M_FC_INST_PREM(Double
						.parseDouble(pValList.get(0)));
			}

			pt_il_policy_bean.setUI_M_LC_INST_PREM((CommonUtils.nvl(
					pt_il_policy_bean.getUI_M_LC_GROSS_CONT(), 0))
					/ CommonUtils.nvl(M_POL_NO_OF_INST, 1));
			pValList = new ArrayList<String>();
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(pt_il_policy_bean
							.getUI_M_LC_INST_PREM()), "R", pt_il_policy_bean
							.getPOL_PROD_CODE());

			if (!pValList.isEmpty()) {
				pt_il_policy_bean.setUI_M_LC_INST_PREM(Double
						.parseDouble(pValList.get(0)));
			}

			M_FC_VALUE = pt_il_policy_bean.getUI_M_FC_CHARGE()
			- dummy_bean.getUI_M_COMPY_FC_CHARGE();
			M_LC_VALUE = pt_il_policy_bean.getUI_M_LC_CHARGE()
			- dummy_bean.getUI_M_COMPY_LC_CHARGE();

			pt_il_policy_bean.setUI_M_FC_CHARGE(dummy_bean
					.getUI_M_COMPY_FC_CHARGE());
			pt_il_policy_bean.setUI_M_LC_CHARGE(dummy_bean
					.getUI_M_COMPY_LC_CHARGE());
			dummy_bean.setUI_M_COMPY_FC_CHARGE(M_FC_VALUE);
			dummy_bean.setUI_M_COMPY_LC_CHARGE(M_LC_VALUE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
				CommonUtils.closeCursor(rs5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void IL_CALC_ANNUITY_SA(PT_IL_POLICY pt_il_policy_bean,
			DUMMY dummy_bean) {
		ArrayList<String> pValList = new ArrayList<String>();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {

			if ("000".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))
					|| "002".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))
							|| "012".equals(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_END_TYPE(), "000"))) {

				if ("012".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))) {

					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_PERIOD(), 0) > 0
							&& CommonUtils.nvl(pt_il_policy_bean
									.getPOL_ORG_FC_MON_ANNU_AMT(), 0) != 0) {
						pt_il_policy_bean
						.setPOL_FC_SUM_ASSURED(pt_il_policy_bean
								.getPOL_PERIOD()
								* pt_il_policy_bean
								.getPOL_ORG_FC_MON_ANNU_AMT()
								* 12);
						pt_il_policy_bean
						.setPOL_FC_SUM_ASSURED(pt_il_policy_bean
								.getPOL_FC_SUM_ASSURED()
								- CommonUtils
								.nvl(
										pt_il_policy_bean
										.getPOL_ORG_FC_SUM_ASSURED(),
										0));
					}
				} else if ("000".equals(CommonUtils.nvl(pt_il_policy_bean
						.getPOL_END_TYPE(), "000"))
						|| "002".equals(CommonUtils.nvl(pt_il_policy_bean
								.getPOL_END_TYPE(), "000"))) {
					if (CommonUtils.nvl(pt_il_policy_bean.getPOL_PERIOD(), 0) > 0
							&& CommonUtils.nvl(pt_il_policy_bean
									.getPOL_FC_MON_ANNU_AMT(), 0) != 0) {
						pt_il_policy_bean
						.setPOL_FC_SUM_ASSURED(pt_il_policy_bean
								.getPOL_PERIOD()
								* pt_il_policy_bean
								.getPOL_FC_MON_ANNU_AMT() * 12);
					}
				}
				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED().toString(), "V",
						pt_il_policy_bean.getPOL_PROD_CODE());

				pt_il_policy_bean.setPOL_FC_SUM_ASSURED(Double
						.parseDouble(pValList.get(0)));

				/*
				 * P_VAL_ROUND_AMT (:PT_IL_POLICY.POL_SA_CURR_CODE,
				 * :PT_IL_POLICY.POL_FC_SUM_ASSURED, 'V');
				 */

				pt_il_policy_bean
				.setPOL_FC_SUM_ASSURED(CommonUtils
						.roundDouble(pt_il_policy_bean
								.getPOL_FC_SUM_ASSURED()));

				pt_il_policy_bean.setPOL_FC_CURR_SA(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED());

				pt_il_policy_bean.setPOL_LC_SUM_ASSURED(pt_il_policy_bean
						.getPOL_FC_SUM_ASSURED()
						* pt_il_policy_bean.getPOL_SA_EXCH_RATE());

				/*
				 * P_VAL_ROUND_AMT (:DUMMY.M_BASE_CURR,
				 * :PT_IL_POLICY.POL_LC_SUM_ASSURED, 'R');
				 */

				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), pt_il_policy_bean
						.getPOL_LC_SUM_ASSURED().toString(), "R",
						pt_il_policy_bean.getPOL_PROD_CODE());

				pt_il_policy_bean.setPOL_LC_SUM_ASSURED(Double
						.parseDouble(pValList.get(0)));

				pt_il_policy_bean
				.setPOL_LC_SUM_ASSURED(CommonUtils
						.roundDouble(pt_il_policy_bean
								.getPOL_LC_SUM_ASSURED()));

				pt_il_policy_bean.setPOL_LC_CURR_SA(pt_il_policy_bean
						.getPOL_LC_SUM_ASSURED());

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void IL_ENDT_012_CHANGES(
			PILQ003_COMPOSITE_ACTION compositeAction) {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();

		PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION pt_il_pol_assured_dtls_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_ACTION pt_il_pol_assured_dtls_1_action = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION pt_il_pol_addl_cover_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		PT_IL_POL_ADDL_COVER_1_ACTION pt_il_pol_addl_cover_1_action = compositeAction
		.getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN();
		PT_IL_POL_DISC_LOAD_ACTION pt_il_pol_disc_load_action = compositeAction
		.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();

		PT_IL_POL_BROKER_HEAD_ACTION pt_il_pol_broker_head_action = compositeAction
		.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN();
		PT_IL_POL_BROKER_DTL_ACTION pt_il_pol_broker_dtl_action = compositeAction
		.getPT_IL_POL_BROKER_DTL_ACTION_BEAN();

		PT_IL_POL_STATUS_ACTION pt_il_pol_status_action = compositeAction
		.getPT_IL_POL_STATUS_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_ACTION pt_il_pol_assr_med_hist_action = compositeAction
		.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN();
		PT_IL_POL_CONDITION_ACTION pt_il_pol_condition_action = compositeAction
		.getPT_IL_POL_CONDITION_ACTION_BEAN();
		try {

			pt_il_policy_action.getCOMP_POL_CUST_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_CURR_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_SA_EXCH_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CUST_EXCH_RATE().setDisabled(true);
			if (pt_il_policy_action.getCOMP_POL_PERIOD().isDisabled() == true) {
				pt_il_policy_action.getCOMP_POL_PERIOD().setDisabled(false);
			}
			pt_il_policy_action.getCOMP_POL_SRC_OF_BUS().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_START_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EXPIRY_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_MODE_OF_PYMT_RATE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_FIRST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LAST_INST_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_BASIC_RATE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_ISSUE_DT().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_PROP_NO().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CONT_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_EMPLOYER_CODE().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CREDIT_DISCOUNT_PERC().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_LOAD_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FAC_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CASH_YN().setDisabled(true);

			pt_il_pol_assured_dtls_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_action.getCOMP_POAC_FM_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_RATE().setDisabled(true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_RATE_PER().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_WOP_FLAG().setDisabled(
					true);
			pt_il_pol_addl_cover_action.getCOMP_POAC_TO_DT().setDisabled(true);

			pt_il_pol_assured_dtls_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_assured_dtls_1_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assured_dtls_1_action.setDELETE_ALLOWED(false);
			pt_il_pol_addl_cover_1_action.setINSERT_ALLOWED(false);
			pt_il_pol_addl_cover_1_action.setDELETE_ALLOWED(false);

			pt_il_pol_addl_cover_1_action.getCOMP_POAC_FM_DT()
			.setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_TO_DT()
			.setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_RATE().setDisabled(true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_RATE_PER().setDisabled(
					true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_WOP_FLAG().setDisabled(
					true);
			pt_il_pol_addl_cover_1_action.getCOMP_POAC_TO_DT()
			.setDisabled(true);

			pt_il_pol_disc_load_action.setINSERT_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);
			pt_il_pol_disc_load_action.setUPDATE_ALLOWED(false);

			pt_il_pol_broker_head_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_head_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_head_action.setDELETE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setINSERT_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setUPDATE_ALLOWED(false);
			pt_il_pol_broker_dtl_action.setDELETE_ALLOWED(false);

			pt_il_pol_assr_med_hist_action.setINSERT_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(false);
			pt_il_pol_assr_med_hist_action.setUPDATE_ALLOWED(false);

			pt_il_pol_status_action.setINSERT_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);
			pt_il_pol_status_action.setUPDATE_ALLOWED(false);

			pt_il_pol_condition_action.setINSERT_ALLOWED(false);
			pt_il_pol_condition_action.setUPDATE_ALLOWED(false);
			pt_il_pol_condition_action.setUPDATE_ALLOWED(false);

			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_JOINT_LIFE_AGE().setDisabled(true);
			if (pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().isDisabled() == false) {
				pt_il_policy_action.getCOMP_POL_PREM_PAY_YRS().setDisabled(
						false);
			}
			pt_il_policy_action.getCOMP_POL_TARIFF_TERM_FLAG()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_RATE_APPLIED_ON().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_STAFF_CCLASS_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_STD_RISK_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_YN().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_CQS_PERC().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_FIRST_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_FC_BASIC_PREM().setDisabled(true);
			pt_il_policy_action.getCOMP_POL_LC_BASIC_PREM().setDisabled(true);

			if ("013".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_END_TYPE(), "000"))) { // -- ADDED BY ABHINAV TO
				// RESTRICT DURING CDOB

				pt_il_policy_action.getCOMP_POL_FC_SUM_ASSURED().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LC_SUM_ASSURED().setDisabled(
						true);

			} // -- END ADDED BY ABHINAV

			/** * Added for PRFM-FSD3-004-STM requirement 2 **** */
			if ("D".equalsIgnoreCase(CommonUtils.nvl(dummy_bean
					.getUI_M_POL_PLAN_TYPE(), "X"))
					&& "G".equalsIgnoreCase(CommonUtils.nvl(dummy_bean
							.getUI_M_COVER_SA_CALC(), "X"))
							&& "012".equalsIgnoreCase(CommonUtils.nvl(pt_il_policy_bean
									.getPOL_END_TYPE(), "000"))) {
				pt_il_policy_action.getCOMP_POL_FC_MON_ANNU_AMT().setDisabled(
						true);
				pt_il_policy_action.getCOMP_POL_LC_MON_ANNU_AMT().setDisabled(
						true);
			}
			pt_il_policy_action.getCOMP_UI_M_POL_CONT_AD_ACC_NO().setDisabled(
					true); // ----Changed by piyush
			pt_il_policy_action.getCOMP_POL_CONT_AD_BANK_CODE().setDisabled(
					true);
			pt_il_policy_action.getCOMP_POL_CARD_HOLDER_NAME()
			.setDisabled(true);
			pt_il_policy_action.getCOMP_POL_AUTH_LIMIT().setDisabled(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void IL_ENDT_003_004_UPDATE_LC_FC(Long POL_SYS_ID)
				throws SQLException, Exception {
		Connection connection = null;

		CRUDHandler handler = null;

		int update1 = -1;
		int update2 = -1;
		String update_pol_charge = " UPDATE PT_IL_POL_CHARGE  SET    POC_ORG_FC_VALUE = POC_FC_VALUE,"
			+ "	          POC_ORG_LC_VALUE = POC_LC_VALUE,"
			+ "	          POC_FC_VALUE     =  0,"
			+ "	          POC_LC_VALUE     =  0"
			+ "	   WHERE  POC_POL_SYS_ID   =?";

		String update_pol_discount = "  UPDATE PT_IL_POL_DISCOUNT"
			+ "	   SET    POD_ORG_FC_VALUE = POD_FC_VALUE,"
			+ "	          POD_ORG_LC_VALUE = POD_LC_VALUE,"
			+ "	          POD_FC_VALUE     = 0,"
			+ "	          POD_LC_VALUE     = 0"
			+ "	   WHERE  POD_POL_SYS_ID   =?";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			Object[] object_sys_id = { POL_SYS_ID };
			update1 = handler.executeUpdateStatement(update_pol_charge,
					connection, object_sys_id);

			Object[] object_sys_id1 = { POL_SYS_ID };
			update2 = handler.executeUpdateStatement(update_pol_discount,
					connection, object_sys_id1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void IL_ENDT_005_GR_MAT_VAL(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

		Double M_LC_PROFIT = null;
		Double M_FC_PROFIT = null;
		Double M_FC_SP = null;
		Double M_LC_SP = null;
		Double M_FC_GR_VAL = null;
		Double M_LC_GR_VAL = null;
		String M_COUNT = null;
		Double M_LOAN_INT_RATE = null;
		Double M_SMV_FC_UNPAID_PREM = null;
		Double M_SMV_LC_UNPAID_PREM = null;
		Double M_SMV_FC_LOAN_INT = null;
		Double M_SMV_LC_LOAN_INT = null;
		Double M_SMV_FC_BAL_LOAN = null;
		Double M_SMV_LC_BAL_LOAN = null;

		String C1 = "SELECT 'X' FROM PT_IL_SURR_MAT_VALUES  WHERE SMV_POL_SYS_ID = ? "
			+ " AND SMV_TYPE != 'R'";
		ResultSet rs = null;
		Object[] values = {};

		PT_IL_POLICY pt_il_policy = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
		.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();
		CRUDHandler handler = null;
		Connection connection = null;
		String updatePol_addl_cover = " UPDATE PT_IL_POL_ADDL_COVER "
			+ " SET    POAC_DEL_FLAG     = 'Y'  WHERE "
			+ " POAC_POL_SYS_ID = ? ";
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		DBProcedures procedures = new DBProcedures();
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();

			handler.executeUpdateStatement(updatePol_addl_cover, connection,
					new Object[] { pt_il_policy.getPOL_SYS_ID() });

			pValOrclList = new PKG_PILT002_APAC().P_CALC_SV_AMT(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(pt_il_policy
							.getPOL_PLAN_CODE()), CommonUtils
							.getProcedureValue(pt_il_policy.getPOL_PERIOD()),
							CommonUtils.getProcedureValue(pt_il_policy
									.getPOL_NO_YRS_PREM_PAID()),
									CommonUtils.getProcedureValue(pt_il_policy
											.getPOL_FC_CURR_SA()), CommonUtils
											.dateToStringFormatter(pt_il_policy
													.getPOL_START_DT()), CommonUtils
													.dateToStringFormatter(pt_il_policy
															.getPOL_EXPIRY_DT()), pt_il_policy
															.getPOL_SA_CURR_CODE(), dummy_bean
															.getUI_M_BASE_CURR(), CommonUtils
															.getProcedureValue(pt_il_policy
																	.getPOL_SA_EXCH_RATE()), "P", null, null,
																	null, null, null, null);

			if (pValOrclList != null) {
				M_FC_PROFIT = Double
				.parseDouble(pValOrclList.get(0).getValue());
				M_LC_PROFIT = Double
				.parseDouble(pValOrclList.get(1).getValue());
				M_FC_SP = Double.parseDouble(pValOrclList.get(2).getValue());
				M_LC_SP = Double.parseDouble(pValOrclList.get(3).getValue());
				M_FC_GR_VAL = Double
				.parseDouble(pValOrclList.get(4).getValue());
				M_LC_GR_VAL = Double
				.parseDouble(pValOrclList.get(5).getValue());
			}
			ArrayList<String> list_prem = procedures
			.callP_CALC_UNPAID_PREM(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT()), CommonUtils
							.getProcedureValue(M_SMV_FC_UNPAID_PREM),
							CommonUtils.getProcedureValue(M_SMV_LC_UNPAID_PREM));

			if (list_prem != null && list_prem.size() > 0) {
				M_SMV_FC_UNPAID_PREM = CommonUtils.parseToDouble(list_prem
						.get(0));
				M_SMV_LC_UNPAID_PREM = CommonUtils.parseToDouble(list_prem
						.get(1));
			}

			ArrayList<String> list_int = procedures
			.callP_CALC_OS_LOAN_INT(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT()), pt_il_policy
							.getPOL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(pt_il_policy
									.getPOL_CUST_CURR_CODE()),
									CommonUtils.getProcedureValue(dummy_bean
											.getUI_M_BASE_CURR()), CommonUtils
											.getProcedureValue(pt_il_policy
													.getPOL_CUST_EXCH_RATE()),
													CommonUtils.getProcedureValue(M_SMV_FC_LOAN_INT),
													CommonUtils.getProcedureValue(M_SMV_LC_LOAN_INT));
			if (list_int != null && list_int.size() > 0) {
				M_SMV_FC_LOAN_INT = CommonUtils.parseToDouble(list_int.get(0));
				M_SMV_LC_LOAN_INT = CommonUtils.parseToDouble(list_int.get(1));
			}

			ArrayList<String> list_amt = procedures
			.callP_CALC_OS_LOAN_AMT(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(M_SMV_FC_BAL_LOAN),
					CommonUtils.getProcedureValue(M_SMV_LC_BAL_LOAN),
					CommonUtils.getProcedureValue(M_LOAN_INT_RATE));
			if (list_amt != null && list_amt.size() > 0) {
				M_SMV_FC_BAL_LOAN = CommonUtils.parseToDouble(list_amt.get(0));
				M_SMV_LC_BAL_LOAN = CommonUtils.parseToDouble(list_amt.get(1));
				M_LOAN_INT_RATE = Double.parseDouble(list_amt.get(2));
			}
			values = new Object[] { pt_il_policy.getPOL_SYS_ID() };

			rs = handler.executeSelectStatement(C1, connection, values);
			if (rs.next()) {
				M_COUNT = rs.getString(1);
				String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SMV_DATE='"
					+ CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT())
							+ "',SMV_FC_GROSS_VALUE= NVL(" + M_FC_GR_VAL
							+ ",0),SMV_LC_GROSS_VALUE= NVL(" + M_LC_GR_VAL
							+ ",0),SMV_FC_UNPAID_PREM=NVL(" + M_SMV_FC_UNPAID_PREM
							+ ",0),SMV_LC_UNPAID_PREM=NVL(" + M_SMV_LC_UNPAID_PREM
							+ ",0),SMV_FC_LOAN_INT=NVL(" + M_SMV_FC_LOAN_INT
							+ ",0),SMV_LC_LOAN_INT=NVL(" + M_SMV_LC_LOAN_INT
							+ ",0),SMV_FC_BAL_LOAN=NVL(" + M_SMV_FC_BAL_LOAN
							+ ",0),SMV_LC_BAL_LOAN=NVL(" + M_SMV_LC_BAL_LOAN
							+ ",0),SMV_TYPE='" + pt_il_policy.getUI_M_SURR_MAT()
							+ "',SMV_UPD_DT=SYSDATE,SMV_UPD_UID='"
							+ CommonUtils.getControlBean().getM_USER_ID()
							+ "' WHERE SMV_POL_SYS_ID='"
							+ pt_il_policy.getPOL_SYS_ID()
							+ "' AND    SMV_TYPE   !=  'R' ";

				handler.executeUpdateStatement(updateQuery, connection);

			} else {
				String insertQuery = "INSERT INTO PT_IL_SURR_MAT_VALUES "
					+ " (SMV_SYS_ID         ,	    SMV_POL_SYS_ID, "
					+ "     	      SMV_DATE           ,"
					+ "            SMV_FC_GROSS_VALUE ,      SMV_LC_GROSS_VALUE,"
					+ "            SMV_FC_UNPAID_PREM ,      SMV_LC_UNPAID_PREM,"
					+ "           SMV_FC_LOAN_INT    ,      SMV_LC_LOAN_INT   ,"
					+ "          SMV_FC_BAL_LOAN    ,      SMV_LC_BAL_LOAN   ,"
					+ "          SMV_TYPE           ,"
					+ "         SMV_CR_DT          ,	    SMV_CR_UID) "
					+ "	 VALUES(PIL_SMV_SYS_ID.NEXTVAL, '"
					+ pt_il_policy.getPOL_SYS_ID()
					+ ",'"
					+ CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT())
							+ "',  NVL("
							+ M_FC_GR_VAL
							+ ",0),NVL("
							+ M_LC_GR_VAL
							+ ",0),NVL("
							+ M_SMV_FC_UNPAID_PREM
							+ ",0),NVL("
							+ M_SMV_LC_UNPAID_PREM
							+ ",0),NVL("
							+ M_SMV_FC_LOAN_INT
							+ ",0),NVL("
							+ M_SMV_LC_LOAN_INT
							+ ",0),NVL("
							+ M_SMV_FC_BAL_LOAN
							+ ",0),NVL("
							+ M_SMV_LC_BAL_LOAN
							+ ",0),'C',SYSDATE,'"
							+ CommonUtils.getControlBean().getM_USER_ID() + "')";
				handler.executeInsertStatement(insertQuery, connection);
			}

			pt_il_policy.setPOL_FC_CURR_SA(compositeAction
					.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE());
			pt_il_policy.setPOL_LC_CURR_SA(compositeAction
					.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_LC_GROSS_VALUE());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void L_UPDATE_TABLES(Long POL_SYS_ID) throws SQLException, Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			Object[] object1 = { POL_SYS_ID };
			int upd1 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_ASSURED_DTLS,
					connection, object1);

			Object[] object2 = { POL_SYS_ID };
			int upd2 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_ADDL_COVER,
					connection, object2);

			Object[] object3 = { POL_SYS_ID };
			int upd3 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_BENEFICIARY,
					connection, object3);

			Object[] object4 = { POL_SYS_ID };
			int upd4 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_ASSR_MED_HIST,
					connection, object4);

			Object[] object5 = { POL_SYS_ID };
			int upd5 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_ASSR_ILLNESS_DTLS,
					connection, object5);

			Object[] object6 = { POL_SYS_ID };
			int upd6 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_MED_EXAM_DTL,
					connection, object6);

			Object[] object7 = { POL_SYS_ID };
			int upd7 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_CHARGE,
					connection, object7);

			Object[] object8 = { POL_SYS_ID };
			int upd8 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_BROKER_HEAD,
					connection, object8);

			Object[] object9 = { POL_SYS_ID };
			int upd9 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_BROKER_DTL,
					connection, object9);

			Object[] object10 = { POL_SYS_ID };
			int upd10 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_DISC_LOAD,
					connection, object10);

			Object[] object11 = { POL_SYS_ID };
			int upd11 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_CONDITION,
					connection, object11);

			Object[] object12 = { POL_SYS_ID };
			int upd12 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_RED_SA,
					connection, object12);

			Object[] object13 = { POL_SYS_ID };
			int upd13 = handler.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_FUND_DTL,
					connection, object12);

			Object[] object14 = { POL_SYS_ID };
			int upd14 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_SA_INST_PYMT_HEAD,
					connection, object12);

			Object[] object15 = { POL_SYS_ID };
			int upd15 = handler
			.executeUpdateStatement(
					PILQ003_QUERY_CONSTANTS.L_UPDATE_PT_IL_POL_SA_INST_PYMT,
					connection, object12);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
		    connection.commit();
		}
	}

	public void IL_SPL_REV_CHANGE(PILQ003_COMPOSITE_ACTION compositeAction)
					throws SQLException, Exception {
		PT_IL_POLICY_ACTION action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS_ACTION assdDtlsAction = compositeAction
		.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PT_IL_POL_ASSURED_DTLS assdDtlsBean = assdDtlsAction
		.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY pt_il_policy = action.getPT_IL_POLICY_BEAN();
		PT_IL_POL_ADDL_COVER_ACTION addlCover = compositeAction
		.getPT_IL_POL_ADDL_COVER_ACTION_BEAN();
		DBProcedures dbProcedures = new DBProcedures();
		String M_CURR_BLK = null;
		String M_CURR_ITEM = null;
		String M_CURR_RECORD = null;
		// String M_CURRENT_BLOCK=:SYSTEM.CURSOR_BLOCK;
		String M_ITEM = null;
		String M_DUM_VALUE = null;
		String M_DUM_DESC = null;
		/*
		 * M_ITEM=NAME_IN.NAME_IN("SYSTEM.CURSOR_ITEM");
		 * M_CURR_BLK=:SYSTEM.CURSOR_BLOCK; M_CURR_ITEM=:SYSTEM.CURSOR_ITEM;
		 * M_CURR_RECORD=:SYSTEM.CURSOR_RECORD;
		 * GO_BLOCK.GO_BLOCK("PT_IL_POL_ASSURED_DTLS");
		 */
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		try {
			ArrayList<String> list = dbProcedures.callP_VAL_SYSTEM(
					"IL_AGE_CAL", "IL_AGE_CAL", "N");
			if (list != null && list.size() > 0) {
				M_DUM_DESC = list.get(0);
				M_DUM_VALUE = list.get(1);
			}
			while ((true)) {
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(0, 1))) {

					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.setINSERT_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.getGlobalVariable(
				"GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.setDELETE_ALLOWED(true);
				}
				if (M_DUM_VALUE.equals(1)) {
					pValOrclList = new ArrayList<OracleParameter>();
					pValOrclList = pkg_pilt002_apac.P_CALC_ANB(CommonUtils
							.dateToStringFormatter(pt_il_policy
									.getPOL_START_DT()), CommonUtils
									.dateToStringFormatter(assdDtlsBean.getPOAD_DOB()),
									dummy_bean.getUI_M_PROD_AGE_CALC_FLAG(),
									CommonUtils.getProcedureValue(assdDtlsBean
											.getPOAD_AGE()));
					if (pValOrclList != null && pValOrclList.size() > 0) {
						assdDtlsBean.setPOAD_AGE(CommonUtils
								.parseToInt(pValOrclList.get(0).getValue()));
					}
					pValOrclList = new ArrayList<OracleParameter>();
					pValOrclList = pkg_pilt002_apac.IL_POAD_AGE_CHECK("R",
							pt_il_policy.getPOL_PLAN_CODE(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.getPOAD_CATG_CODE(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN()
							.getPOAD_CATG_CODE(), pt_il_policy
							.getPOL_JOINT_LIFE_YN(),
							CommonUtils.getProcedureValue(compositeAction
									.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
									.getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_AGE()),CommonUtils.getProcedureValue(compositeAction
											.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
											.getPT_IL_POL_ASSURED_DTLS_1_BEAN()
											.getPOAD_AGE()), CommonUtils
									.getProcedureValue(pt_il_policy
											.getPOL_PERIOD()), CommonUtils
											.getProcedureValue(dummy_bean
													.getUI_M_CALC_METHOD()), dummy_bean
													.getUI_M_PLAN_AGE_TERM_FLAG(), CommonUtils
													.getGlobalVariable("GLOBAL.M_PAYER_FOUND"));
					if (pValOrclList != null && pValOrclList.size() > 0) {
						CommonUtils.setGlobalVariable("GLOBAL.M_PAYER_FOUND",
								pValOrclList.get(0).getValue());
					}

					// IL_POAD_AGE_CHECK.IL_POAD_AGE_CHECK("R");
				} else {

					ArrayList<OracleParameter> list2 = pkg_pilt002_apac
					.P_CALC_ANB(CommonUtils
							.dateToStringFormatter(pt_il_policy
									.getPOL_ISSUE_DT()), CommonUtils
									.dateToStringFormatter(assdDtlsBean
											.getPOAD_DOB()), dummy_bean
											.getUI_M_PROD_AGE_CALC_FLAG(),
											CommonUtils.integerToString(assdDtlsBean
													.getPOAD_AGE()));
					if (list2 != null && list2.size() > 0) {
						assdDtlsBean.setPOAD_AGE(CommonUtils.parseToInt(list2
								.get(0).getValue()));
					}
				}
				break;
				/*
				 * if(:SYSTEM.LAST_RECORD=="TRUE"){
				 * GO_ITEM.GO_ITEM(M_CURR_ITEM); }else{
				 * //NEXT_RECORD.NEXT_RECORD(); }
				 */
			}
			// GO_ITEM.GO_ITEM(M_CURR_ITEM);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void IL_ENDT_004_GR_MAT_VALUE(
			PILQ003_COMPOSITE_ACTION compositeAction) throws SQLException,
			Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();
		PT_IL_POLICY_ACTION action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES matBean = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
		.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_POLICY pt_il_policy = action.getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		Double P_LC_PROFIT = null;
		Double P_FC_PROFIT = null;
		try {
			ArrayList<String> list_profit = new DBProcedures()
			.callP_CALC_ACC_PROFIT(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					pt_il_policy.getPOL_PLAN_CODE(), CommonUtils
					.dateToStringFormatter(pt_il_policy
							.getPOL_START_DT()), CommonUtils
							.dateToStringFormatter(pt_il_policy
									.getPOL_EXPIRY_DT()), CommonUtils
									.getProcedureValue(pt_il_policy
											.getPOL_FC_CURR_SA()), CommonUtils
											.getProcedureValue(pt_il_policy
													.getPOL_SA_CURR_CODE()),
													CommonUtils.getProcedureValue(pt_il_policy
															.getPOL_SA_EXCH_RATE()), dummy_bean
															.getUI_M_BASE_CURR(), CommonUtils
															.getProcedureValue(P_FC_PROFIT),
															CommonUtils.getProcedureValue(P_LC_PROFIT));
			if (list_profit != null && list_profit.size() > 0) {
				P_FC_PROFIT = CommonUtils.parseToDouble(list_profit.get(0));
				P_LC_PROFIT = CommonUtils.parseToDouble(list_profit.get(1));
			}
			String sql_insert1 = "INSERT INTO  PT_IL_SURR_PROFIT ( SP_SYS_ID ,SP_POL_SYS_ID ,SP_SURR_DT ,SP_LC_SURR_PROFIT ,SP_FC_SURR_PROFIT ,SP_SURR_APPRV_FLAG ,SP_CR_DT ,SP_CR_UID ) VALUES   ( PIL_SP_SYS_ID.NEXTVAL ,    ? ,    ? ,    NVL(?, 0) ,    NVL(?, 0) ,    'M' ,    SYSDATE ,   ? )   ";

			Object[] object = { pt_il_policy.getPOL_SYS_ID(),
					pt_il_policy.getPOL_END_DT(), P_LC_PROFIT, P_FC_PROFIT,
					CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID") };
			int upd = handler.executeInsertStatement(sql_insert1, connection,
					object);

			if (pt_il_policy.getPOL_SA_CURR_CODE().equals(
					pt_il_policy.getPOL_CUST_CURR_CODE())) {
				matBean.setSMV_FC_GROSS_VALUE(CommonUtils.nvl(pt_il_policy
						.getPOL_FC_SUM_ASSURED(), 0)
						+ CommonUtils.nvl(P_FC_PROFIT, 0));
				ArrayList<String> list1 = pkg_pilt002_apac.P_VAL_ROUND_AMT(
						pt_il_policy.getPOL_CUST_CURR_CODE(), CommonUtils
						.getProcedureValue(matBean
								.getSMV_FC_GROSS_VALUE()), "R");
				if (list1 != null && list1.size() > 0) {
					matBean.setSMV_FC_GROSS_VALUE(CommonUtils
							.parseToDouble(list1.get(0)));
				}
				matBean.setSMV_LC_GROSS_VALUE(matBean.getSMV_FC_GROSS_VALUE()
						* pt_il_policy.getPOL_CUST_EXCH_RATE());
				ArrayList<String> list2 = pkg_pilt002_apac.P_VAL_ROUND_AMT(
						dummy_bean.getUI_M_BASE_CURR(), CommonUtils
						.getProcedureValue(matBean
								.getSMV_LC_GROSS_VALUE()), "R");
				if (list2 != null && list2.size() > 0) {
					matBean.setSMV_LC_GROSS_VALUE(CommonUtils
							.parseToDouble(list2.get(0)));
				}
			} else {
				matBean.setSMV_LC_GROSS_VALUE(CommonUtils.nvl(pt_il_policy
						.getPOL_LC_SUM_ASSURED(), 0)
						+ CommonUtils.nvl(P_LC_PROFIT, 0));
				ArrayList<String> list3 = pkg_pilt002_apac.P_VAL_ROUND_AMT(
						dummy_bean.getUI_M_BASE_CURR(), CommonUtils
						.getProcedureValue(matBean
								.getSMV_LC_GROSS_VALUE()), "R");
				if (list3 != null && list3.size() > 0) {
					matBean.setSMV_LC_GROSS_VALUE(CommonUtils
							.parseToDouble(list3.get(0)));
				}
				matBean.setSMV_FC_GROSS_VALUE(matBean.getSMV_LC_GROSS_VALUE()
						/ pt_il_policy.getPOL_CUST_EXCH_RATE());
				ArrayList<String> list4 = pkg_pilt002_apac.P_VAL_ROUND_AMT(
						pt_il_policy.getPOL_CUST_CURR_CODE(), CommonUtils
						.getProcedureValue(matBean
								.getSMV_FC_GROSS_VALUE()), "R");
				if (list4 != null && list4.size() > 0) {
					matBean.setSMV_FC_GROSS_VALUE(CommonUtils
							.parseToDouble(list4.get(0)));
				}
			}
			IL_ENDT_003_NET_SURR_VAL_CAL(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void IL_ENDT_003_NET_SURR_VAL_CAL(
			PILQ003_COMPOSITE_ACTION compositeAction) throws SQLException,
			Exception {
		String M_LOAN_INT_RATE = null;
		DBProcedures dbProcedures = new DBProcedures();
		PT_IL_POLICY_ACTION action = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES matBean = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
		.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_POLICY pt_il_policy = action.getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();

		try {
			ArrayList<String> list_prem = dbProcedures
			.callP_CALC_UNPAID_PREM(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT()), CommonUtils
							.getProcedureValue(matBean
									.getSMV_FC_UNPAID_PREM()),
									CommonUtils.getProcedureValue(matBean
											.getSMV_LC_UNPAID_PREM()));
			if (list_prem != null && list_prem.size() > 0) {
				matBean.setSMV_FC_UNPAID_PREM(CommonUtils
						.parseToDouble(list_prem.get(0)));
				matBean.setSMV_LC_UNPAID_PREM(CommonUtils
						.parseToDouble(list_prem.get(1)));
			}

			ArrayList<String> list_int = dbProcedures
			.callP_CALC_OS_LOAN_INT(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT()), pt_il_policy
							.getPOL_SA_CURR_CODE(), CommonUtils
							.getProcedureValue(pt_il_policy
									.getPOL_CUST_CURR_CODE()),
									CommonUtils.getProcedureValue(dummy_bean
											.getUI_M_BASE_CURR()), CommonUtils
											.getProcedureValue(pt_il_policy
													.getPOL_CUST_EXCH_RATE()),
													CommonUtils.getProcedureValue(matBean
															.getSMV_FC_LOAN_INT()), CommonUtils
															.getProcedureValue(matBean
																	.getSMV_LC_LOAN_INT()));
			if (list_int != null && list_int.size() > 0) {
				matBean.setSMV_FC_LOAN_INT(CommonUtils.parseToDouble(list_int
						.get(0)));
				matBean.setSMV_LC_LOAN_INT(CommonUtils.parseToDouble(list_int
						.get(1)));
			}

			ArrayList<String> list_amt = dbProcedures
			.callP_CALC_OS_LOAN_AMT(CommonUtils
					.getProcedureValue(pt_il_policy.getPOL_SYS_ID()),
					CommonUtils.getProcedureValue(matBean
							.getSMV_FC_BAL_LOAN()), CommonUtils
							.getProcedureValue(matBean
									.getSMV_LC_BAL_LOAN()),
									M_LOAN_INT_RATE);
			if (list_amt != null && list_amt.size() > 0) {
				matBean.setSMV_FC_BAL_LOAN(CommonUtils.parseToDouble(list_amt
						.get(0)));
				matBean.setSMV_LC_BAL_LOAN(CommonUtils.parseToDouble(list_amt
						.get(1)));
				M_LOAN_INT_RATE = list_amt.get(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void IL_ENDT_003_SV_VALUES(
			PILQ003_COMPOSITE_ACTION pilq003_composite_action) {
		Double M_LC_PROFIT = null;
		Double M_FC_PROFIT = null;
		Double M_FC_SP = null;
		Double M_LC_SP = null;
		Double M_FC_SURR_POL = null;
		Double M_LC_SURR_POL = null;
		Double M_FC_GR_VAL = null;
		Double M_LC_GR_VAL = null;
		String M_COUNT = null;
		Double M_LOAN_INT_RATE = null;
		Double M_SMV_FC_UNPAID_PREM = null;
		Double M_SMV_LC_UNPAID_PREM = null;
		String M_SMV_FC_LOAN_INT = null;
		String M_SMV_LC_LOAN_INT = null;
		String M_SMV_FC_BAL_LOAN = null;
		String M_SMV_LC_BAL_LOAN = null;
		String sql_C1 = "SELECT 'X' FROM PT_IL_SURR_MAT_VALUES  WHERE SMV_POL_SYS_ID = ? "
			+ " AND SMV_TYPE != 'R'";
		ResultSet rs_C1 = null;

		PT_IL_POLICY pt_il_policy = pilq003_composite_action
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values = pilq003_composite_action
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
		.getPT_IL_SURR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = pilq003_composite_action.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			if ("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "S".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {

				ArrayList p_calc_sv_amt_outputList = new PKG_PILT002_APAC()
				.P_CALC_SV_AMT(
						CommonUtils.getProcedureValue(pt_il_policy
								.getPOL_SYS_ID()), CommonUtils
								.getProcedureValue(pt_il_policy
										.getPOL_PLAN_CODE()),
										CommonUtils.getProcedureValue(pt_il_policy
												.getPOL_PERIOD()), CommonUtils
												.getProcedureValue(pt_il_policy
														.getPOL_NO_YRS_PREM_PAID()),
														CommonUtils.getProcedureValue(pt_il_policy
																.getPOL_FC_CURR_SA()), CommonUtils
																.dateToStringFormatter(pt_il_policy
																		.getPOL_START_DT()),
																		CommonUtils.dateToStringFormatter(pt_il_policy
																				.getPOL_END_DT()), pt_il_policy
																				.getPOL_SA_CURR_CODE(), dummy_bean
																				.getUI_M_BASE_CURR(), CommonUtils
																				.getProcedureValue(pt_il_policy
																						.getPOL_SA_EXCH_RATE()),
																						pt_il_policy.getUI_M_SURR_MAT(), null, null,
																						null, null, null, null);

				if (p_calc_sv_amt_outputList != null) {
					M_FC_PROFIT = (Double) p_calc_sv_amt_outputList.get(0);
					M_LC_PROFIT = (Double) p_calc_sv_amt_outputList.get(1);
					M_FC_SP = (Double) p_calc_sv_amt_outputList.get(2);
					M_LC_SP = (Double) p_calc_sv_amt_outputList.get(3);
					M_FC_SURR_POL = (Double) p_calc_sv_amt_outputList.get(4);
					M_LC_SURR_POL = (Double) p_calc_sv_amt_outputList.get(5);
				}

				ArrayList outputList = new DBProcedures()
				.callP_CALC_UNPAID_PREM(
						CommonUtils.getProcedureValue(pt_il_policy
								.getPOL_SYS_ID()), CommonUtils
								.dateToStringFormatter(pt_il_policy
										.getPOL_END_DT()), null, null);
				if (outputList != null) {
					M_SMV_FC_UNPAID_PREM = (Double) outputList.get(0);
					M_SMV_LC_UNPAID_PREM = (Double) outputList.get(1);
				}
				if (pt_il_policy.getPOL_FC_CURR_SA() != pt_il_policy
						.getPOL_FC_SUM_ASSURED()
						&& pt_il_policy.getPOL_LC_CURR_SA() != pt_il_policy
						.getPOL_LC_SUM_ASSURED()) {
					M_FC_SP = 0.0;
					M_LC_SP = 0.0;
					M_SMV_FC_UNPAID_PREM = 0.0;
					M_SMV_LC_UNPAID_PREM = 0.0;
				}
				M_FC_GR_VAL = M_FC_SURR_POL + M_FC_SP;
				M_LC_GR_VAL = M_LC_SURR_POL + M_LC_SP;
				ArrayList outputList_os_loan_int = new DBProcedures()
				.callP_CALC_OS_LOAN_INT(
						CommonUtils.getProcedureValue(pt_il_policy
								.getPOL_SYS_ID()), CommonUtils
								.dateToStringFormatter(pt_il_policy
										.getPOL_END_DT()), pt_il_policy
										.getPOL_SA_CURR_CODE(), pt_il_policy
										.getPOL_CUST_CURR_CODE(), dummy_bean
										.getUI_M_BASE_CURR(), CommonUtils
										.getProcedureValue(pt_il_policy
												.getPOL_CUST_EXCH_RATE()),
												null, null);
				if (outputList_os_loan_int != null) {
					M_SMV_FC_LOAN_INT = (String) outputList_os_loan_int.get(0);
					M_SMV_LC_LOAN_INT = (String) outputList_os_loan_int.get(1);
				}
				ArrayList outputList_os_loan_amt = new DBProcedures()
				.callP_CALC_OS_LOAN_AMT(
						CommonUtils.getProcedureValue(pt_il_policy
								.getPOL_SYS_ID()), null, null, null);
				if (outputList_os_loan_amt != null) {
					M_SMV_FC_BAL_LOAN = (String) outputList_os_loan_amt.get(0);
					M_SMV_LC_BAL_LOAN = (String) outputList_os_loan_amt.get(1);
					M_LOAN_INT_RATE = (Double) outputList_os_loan_amt.get(2);
				}
				rs_C1 = handler.executeSelectStatement(sql_C1, connection,
						new Object[] { pt_il_policy.getPOL_SYS_ID() });
				if (rs_C1.next()) {
					String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_DATE='"
						+ new java.sql.Date(pt_il_policy.getPOL_END_DT()
								.getTime())
					+ "',SMV_FC_RED_SA='"
					+ M_FC_SURR_POL
					+ "',SMV_LC_RED_SA='"
					+ M_LC_SURR_POL
					+ "',SMV_FC_ACC_PROFIT='"
					+ M_FC_SP
					+ "',SMV_LC_ACC_PROFIT='"
					+ M_LC_SP
					+ "',SMV_FC_GROSS_VALUE=NVL("
					+ M_FC_GR_VAL
					+ ",0),SMV_LC_GROSS_VALUE=NVL("
					+ M_LC_GR_VAL
					+ ",0),SMV_FC_UNPAID_PREM=NVL("
					+ M_SMV_FC_UNPAID_PREM
					+ ",0),SMV_LC_UNPAID_PREM=NVL("
					+ M_SMV_LC_UNPAID_PREM
					+ ",0),SMV_FC_LOAN_INT=NVL("
					+ M_SMV_FC_LOAN_INT
					+ ",0),SMV_LC_LOAN_INT=NVL("
					+ M_SMV_LC_LOAN_INT
					+ ",0),SMV_FC_BAL_LOAN=NVL("
					+ M_SMV_FC_BAL_LOAN
					+ ",0),SMV_LC_BAL_LOAN=NVL("
					+ M_SMV_LC_BAL_LOAN
					+ ",0),SMV_TYPE='"
					+ pt_il_policy.getUI_M_SURR_MAT()
					+ "',SMV_UPD_DT=SYSDATE, SMV_UPD_UID='"
					+ CommonUtils.getControlBean().getM_USER_ID()
					+ "' WHERE SMV_POL_SYS_ID="
					+ pt_il_policy.getPOL_SYS_ID()
					+ " AND SMV_TYPE='R'";
					handler.executeUpdateStatement(updateQuery, connection);
				} else {
					String insertQuery = "INSERT INTO PT_IL_SURR_MAT_VALUES(SMV_SYS_ID,SMV_POL_SYS_ID,SMV_DATE,SMV_FC_RED_SA,SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT,SMV_FC_GROSS_VALUE,SMV_LC_GROSS_VALUE,SMV_FC_UNPAID_PREM,SMV_LC_UNPAID_PREM,SMV_FC_LOAN_INT,SMV_LC_LOAN_INT,SMV_FC_BAL_LOAN,SMV_LC_BAL_LOAN,SMV_TYPE,"
						+ "SMV_CR_DT,SMV_CR_UID) VALUES(PIL_SMV_SYS_ID.NEXTVAL,'"
						+ pt_il_policy.getPOL_SYS_ID()
						+ "',"
						+ M_FC_SURR_POL
						+ ","
						+ M_LC_SURR_POL
						+ ","
						+ M_FC_SP
						+ ","
						+ M_LC_SP
						+ ",NVL("
						+ M_FC_GR_VAL
						+ ",0),NVL("
						+ M_LC_GR_VAL
						+ ",0),NVL("
						+ M_SMV_FC_UNPAID_PREM
						+ ",0),NVL("
						+ M_SMV_LC_UNPAID_PREM
						+ ",0),NVL("
						+ M_SMV_FC_LOAN_INT
						+ ",0),NVL("
						+ M_SMV_LC_LOAN_INT
						+ ",0),NVL("
						+ M_SMV_FC_BAL_LOAN
						+ ",0),NVL("
						+ M_SMV_LC_BAL_LOAN
						+ ",0),'"
						+ pt_il_policy.getUI_M_SURR_MAT()
						+ "',SYSDATE,'"
						+ CommonUtils.getControlBean().getM_USER_ID()
						+ "')";
					handler.executeInsertStatement(insertQuery, connection);
				}
				if ("P".equals(pt_il_policy.getUI_M_SURR_MAT())) {
					pt_il_policy.setPOL_FC_CURR_SA(pt_il_surr_mat_values
							.getSMV_FC_GROSS_VALUE());
					pt_il_policy.setPOL_LC_CURR_SA(pt_il_surr_mat_values
							.getSMV_LC_GROSS_VALUE());
				}
				if ("S".equals(pt_il_policy.getUI_M_SURR_MAT())) {
					String insertQuery = "INSERT INTO PT_IL_SURR_PROFIT(SP_SYS_ID,SP_POL_SYS_ID,SP_SURR_DT,SP_LC_ACC_PROFIT,SP_FC_ACC_PROFIT,SP_LC_SURR_PROFIT,SP_FC_SURR_PROFIT,SP_SURR_APPRV_FLAG,SP_CR_DT,SP_CR_UID) VALUES (PIL_SP_SYS_ID.NEXTVAL,"
						+ pt_il_policy.getPOL_SYS_ID()
						+ ",'"
						+ new java.sql.Date(pt_il_policy.getPOL_END_DT()
								.getTime())
					+ "',NVL("
					+ M_LC_PROFIT
					+ ",0),NVL("
					+ M_FC_PROFIT
					+ ",0),NVL("
					+ M_LC_SP
					+ ",0),NVL("
					+ M_LC_SP
					+ ",0),'"
					+ pt_il_policy.getUI_M_SURR_MAT()
					+ "',SYSDATE,'"
					+ CommonUtils.getControlBean().getM_USER_ID()
					+ "')";
					handler.executeInsertStatement(insertQuery, connection);
				}
			} else {
				IL_CALC_ISLM_SURR_VALUE(pilq003_composite_action);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void IL_CALC_ISLM_SURR_VALUE(
			PILQ003_COMPOSITE_ACTION compositeAction) {
		Double M_LC_PROFIT = null;
		Double M_FC_PROFIT = null;
		Double M_FC_SP = null;
		Double M_LC_SP = null;
		Double M_FC_SURR_POL = null;
		Double M_LC_SURR_POL = null;
		Double M_FC_GR_VAL = null;
		Double M_LC_GR_VAL = null;
		String M_COUNT = null;
		String M_LOAN_INT_RATE = null;
		Double M_SMV_FC_UNPAID_PREM = null;
		String M_SMV_LC_UNPAID_PREM = null;
		String M_SMV_FC_LOAN_INT = null;
		String M_SMV_LC_LOAN_INT = null;
		String M_SMV_FC_BAL_LOAN = null;
		String M_SMV_LC_BAL_LOAN = null;
		Double M_TOT_PC_FC_SENABEL_PREM = null;
		Double M_TOT_PC_LC_SENABEL_PREM = null;
		String M_CALC_DT = null;
		Double M_AMAN_REFUND_RATE = null;

		ResultSet resultSet_C1 = null;
		ResultSet resultSet_C2 = null;
		ResultSet resultSet_C3 = null;
		ResultSet resultSet_C4 = null;
		String sql_C1 = "SELECT 'X' FROM   PT_IL_SURR_MAT_VALUES "
			+ "WHERE  SMV_POL_SYS_ID = ?  AND    SMV_TYPE != 'R'";
		String sql_C2 = "SELECT NVL(SUM(PC_FC_SENABEL_PREM),0),"
			+ "NVL(SUM(PC_LC_SENABEL_PREM),0) FROM PT_IL_PREM_COLL "
			+ " WHERE PC_POL_SYS_ID=? AND PC_PAID_FLAG IN ('A','R')";
		String sql_C3 = "SELECT MIN(PC_SCHD_PYMT_DT)+ 30 "
			+ "FROM PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? "
			+ "  AND PC_PAID_FLAG	NOT IN ('A','R')";
		String sql_C4 = "SELECT	(ADD_MONTHS(POL_ISSUE_DT,12)- "
			+ "ADD_MONTHS(POL_ISSUE_DT,(12-FLOOR(MONTHS_BETWEEN("
			+ " ADD_MONTHS(POL_ISSUE_DT,12),POL_END_DT)))))/("
			+ " ADD_MONTHS(POL_ISSUE_DT,12)- POL_ISSUE_DT) "
			+ " FROM PT_IL_POLICY WHERE   POL_SYS_ID = ?";
		String sql_C5 = "SELECT NVL(SUM(PC_FC_AMAN_PREM),0),NVL(SUM(PC_LC_AMAN_PREM),0) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID	= ? AND  PC_PAID_FLAG	NOT IN ('A','R')";

		PT_IL_POLICY pt_il_policy = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();

		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler crudHandler = new CRUDHandler();
			resultSet_C2 = crudHandler.executeSelectStatement(sql_C2,
					connection, new Object[] { pt_il_policy.getPOL_SYS_ID() });
			while (resultSet_C2.next()) {
				M_TOT_PC_FC_SENABEL_PREM = resultSet_C2.getDouble(1);
				M_TOT_PC_LC_SENABEL_PREM = resultSet_C2.getDouble(2);
			}
			CommonUtils.closeCursor(resultSet_C2);
			if ("A".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())
					|| "S".equalsIgnoreCase(dummy_bean.getUI_M_POL_PLAN_TYPE())
					&& "008".equals(pt_il_policy.getPOL_END_TYPE())) {
				resultSet_C3 = crudHandler.executeSelectStatement(sql_C3,
						connection,
						new Object[] { pt_il_policy.getPOL_SYS_ID() });
				while (resultSet_C3.next()) {
					M_CALC_DT = resultSet_C3.getString(1);
				}
				CommonUtils.closeCursor(resultSet_C3);
				if ("A".equals(dummy_bean.getUI_M_POL_PLAN_TYPE())) {
					resultSet_C4 = crudHandler.executeSelectStatement(sql_C4,
							connection, new Object[] { pt_il_policy
							.getPOL_SYS_ID() });
					if (resultSet_C4.next()) {
						M_AMAN_REFUND_RATE = resultSet_C4.getDouble(1);
					}
				}
				pValOrclList = new ArrayList<OracleParameter>();
				pValOrclList = new PKG_PILT002_APAC().IL_CALC_ISLM_ACC_PROFIT(
						CommonUtils.getProcedureValue(pt_il_policy
								.getPOL_SYS_ID()), pt_il_policy
								.getPOL_PLAN_CODE(), CommonUtils
								.dateToStringFormatter(pt_il_policy
										.getPOL_START_DT()), CommonUtils
										.dateToStringFormatter(pt_il_policy
												.getPOL_END_DT()), CommonUtils
												.getProcedureValue(pt_il_policy
														.getPOL_FC_CURR_SA()), pt_il_policy
														.getPOL_SA_CURR_CODE(), CommonUtils
														.getProcedureValue(pt_il_policy
																.getPOL_SA_EXCH_RATE()), dummy_bean
																.getUI_M_BASE_CURR(), null, null);

				if (pValOrclList != null && !pValOrclList.isEmpty()) {
					M_CALC_DT = pValOrclList.get(0).getValue();
					M_FC_PROFIT = Double.parseDouble(pValOrclList.get(1)
							.getValue());
					M_LC_PROFIT = Double.parseDouble(pValOrclList.get(2)
							.getValue());
				}
			} else {
				pValOrclList = new ArrayList<OracleParameter>();
				pValOrclList = new PKG_PILT002_APAC().IL_CALC_ISLM_ACC_PROFIT(
						CommonUtils.getProcedureValue(pt_il_policy
								.getPOL_SYS_ID()), pt_il_policy
								.getPOL_PLAN_CODE(), CommonUtils
								.dateToStringFormatter(pt_il_policy
										.getPOL_START_DT()), CommonUtils
										.dateToStringFormatter(pt_il_policy
												.getPOL_END_DT()), CommonUtils
												.getProcedureValue(pt_il_policy
														.getPOL_FC_CURR_SA()), pt_il_policy
														.getPOL_SA_CURR_CODE(), CommonUtils
														.getProcedureValue(pt_il_policy
																.getPOL_SA_EXCH_RATE()), dummy_bean
																.getUI_M_BASE_CURR(), null, null);
				if (pValOrclList != null) {
					pt_il_policy.setPOL_END_DT(CommonUtils
							.stringToUtilDate(pValOrclList.get(0).getValue()));
					M_FC_PROFIT = Double.parseDouble(pValOrclList.get(1)
							.getValue());
					M_LC_PROFIT = Double.parseDouble(pValOrclList.get(2)
							.getValue());
				}
			}
			M_FC_GR_VAL = M_TOT_PC_FC_SENABEL_PREM + M_FC_PROFIT;
			M_LC_GR_VAL = M_TOT_PC_LC_SENABEL_PREM + M_LC_PROFIT;
			resultSet_C1 = crudHandler.executeSelectStatement(sql_C1,
					connection, new Object[] { pt_il_policy.getPOL_SYS_ID() });
			if (resultSet_C1.next()) {
				String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SMV_DATE='"
					+ CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT()) + "',SMV_FC_RED_SA="
							+ M_TOT_PC_FC_SENABEL_PREM + ",SMV_LC_RED_SA="
							+ M_TOT_PC_LC_SENABEL_PREM + ",SMV_FC_ACC_PROFIT="
							+ M_FC_PROFIT + ",SMV_LC_ACC_PROFIT=" + M_LC_PROFIT
							+ ",SMV_FC_GROSS_VALUE= NVL(" + M_FC_GR_VAL
							+ ",0),SMV_LC_GROSS_VALUE= NVL(" + M_LC_GR_VAL
							+ ",0),SMV_FC_UNPAID_PREM=NVL(" + M_SMV_FC_UNPAID_PREM
							+ ",0),SMV_LC_UNPAID_PREM=NVL(" + M_SMV_LC_UNPAID_PREM
							+ ",0),SMV_FC_LOAN_INT=NVL(" + M_SMV_FC_LOAN_INT
							+ ",0),SMV_LC_LOAN_INT=NVL(" + M_SMV_LC_LOAN_INT
							+ ",0),SMV_FC_BAL_LOAN=NVL(" + M_SMV_FC_BAL_LOAN
							+ ",0),SMV_LC_BAL_LOAN=NVL(" + M_SMV_LC_BAL_LOAN
							+ ",0),SMV_TYPE='" + pt_il_policy.getUI_M_SURR_MAT()
							+ "',SMV_UPD_DT=SYSDATE,SMV_UPD_UID='"
							+ CommonUtils.getControlBean().getM_USER_ID()
							+ "' WHERE SMV_POL_SYS_ID='"
							+ pt_il_policy.getPOL_SYS_ID()
							+ "' AND    SMV_TYPE   !=  'R' ";
				crudHandler.executeUpdateStatement(updateQuery, connection);

			} else {
				String insertQuery = "INSERT INTO PT_IL_SURR_MAT_VALUES(SMV_SYS_ID,SMV_POL_SYS_ID,SMV_DATE,SMV_FC_RED_SA,"
					+ " SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT,"
					+ "SMV_FC_GROSS_VALUE,SMV_LC_GROSS_VALUE,"
					+ "SMV_FC_UNPAID_PREM,SMV_LC_UNPAID_PREM,"
					+ " SMV_FC_LOAN_INT,SMV_LC_LOAN_INT, "
					+ "SMV_FC_BAL_LOAN,SMV_LC_BAL_LOAN,SMV_TYPE,"
					+ " SMV_CR_DT,SMV_CR_UID) VALUES(PIL_SMV_SYS_ID.NEXTVAL,"
					+ pt_il_policy.getPOL_SYS_ID()
					+ ",'"
					+ CommonUtils.dateToStringFormatter(pt_il_policy
							.getPOL_END_DT())
							+ "',"
							+ M_TOT_PC_FC_SENABEL_PREM
							+ ","
							+ M_TOT_PC_LC_SENABEL_PREM
							+ ","
							+ M_FC_PROFIT
							+ ","
							+ M_LC_PROFIT
							+ ",NVL("
							+ M_FC_GR_VAL
							+ ",0),NVL("
							+ M_LC_GR_VAL
							+ ",0),NVL("
							+ M_SMV_FC_UNPAID_PREM
							+ ",0),NVL("
							+ M_SMV_LC_UNPAID_PREM
							+ ",0),NVL("
							+ M_SMV_FC_LOAN_INT
							+ ",0),NVL("
							+ M_SMV_LC_LOAN_INT
							+ ",0),NVL("
							+ M_SMV_FC_BAL_LOAN
							+ ",0),NVL("
							+ M_SMV_LC_BAL_LOAN
							+ ",0),'"
							+ pt_il_policy.getUI_M_SURR_MAT()
							+ "',SYSDATE,'"
							+ CommonUtils.getControlBean().getM_USER_ID() + "')";
				crudHandler.executeInsertStatement(insertQuery, connection);
			}
			CommonUtils.closeCursor(resultSet_C1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet_C1);
				CommonUtils.closeCursor(resultSet_C2);
				CommonUtils.closeCursor(resultSet_C3);
				CommonUtils.closeCursor(resultSet_C4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void IL_UNIQUE_CONDITION_CODE(
			PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN, Long POL_SYS_ID)
					throws Exception {
		String M_CONDITION_CODE = null;
		String cursor1 = "SELECT 'X' FROM PT_IL_POL_CONDITION WHERE PLCOND_CODE = ? AND PLCOND_POL_SYS_ID = ?";
		String cursor2 = "SELECT 'X' FROM PT_IL_POL_CONDITION WHERE PLCOND_CODE = ? "
			+ "AND PLCOND_POL_SYS_ID = ? AND ROWID <> ?";
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if (PT_IL_POL_CONDITION_BEAN.getROWID() == null) {
				resultSet1 = handler.executeSelectStatement(cursor1,
						connection, new Object[] {
						PT_IL_POL_CONDITION_BEAN.getPLCOND_CODE(),
						POL_SYS_ID });
				if (resultSet1.next()) {
					M_CONDITION_CODE = resultSet1.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90015",
							new Object[] { "Condition Code" }));
				}
			} else {
				resultSet2 = handler
				.executeSelectStatement(cursor2, connection,
						new Object[] {
						PT_IL_POL_CONDITION_BEAN
						.getPLCOND_CODE(), POL_SYS_ID,
						PT_IL_POL_CONDITION_BEAN.getROWID() });
				if (resultSet2.next()) {
					M_CONDITION_CODE = resultSet2.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90015",
							new Object[] { "Condition Code" }));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void IL_VAL_POLICY_COVER(String POBH_COVER_CODE, String POL_PLAN_CODE, 
			Long POL_SYS_ID) throws Exception {
		String M_DUMMY = null;
		String cursor1 = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE POAC_COVER_CODE  = ? " +
				"AND POAC_POL_SYS_ID  = ?";
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if(!POL_PLAN_CODE.equals(POBH_COVER_CODE)){
				resultSet1 = handler.executeSelectStatement(cursor1, connection, 
						new Object[]{POBH_COVER_CODE, POL_SYS_ID});
				if(resultSet1.next()){
					M_DUMMY = resultSet1.getString(1);
				}else{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71206"));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try{CommonUtils.closeCursor(resultSet1);}catch(Exception e){}
		}
	}

	public void L_DOC_DESC(DUMMY  dummy_bean) {
	    
	    String CURSOR_C1=" SELECT DS_DESC FROM  PM_IL_DOC_SETUP   WHERE " +
	    			"    DS_CODE = ? " ;
	    
	    ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		 
				resultSet1 = handler.executeSelectStatement(CURSOR_C1, connection, 
						new Object[]{dummy_bean.getUI_M_POL_DOC_CODE()});
				if(resultSet1.next()){
					dummy_bean.setUI_M_POL_DOC_DESC( resultSet1.getString(1));
				}else{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "11910"));
				}
			
		
        	  } catch (Exception e) {
        		// TODO: handle exception
        		e.printStackTrace();
        	   }
	     
	}
	
}
