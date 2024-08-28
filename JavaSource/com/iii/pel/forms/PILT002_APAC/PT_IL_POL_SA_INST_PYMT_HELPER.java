package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_SA_INST_PYMT_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_POL_SA_INST_PYMT_DELEGATE()
					.executeSelectStatement(compositeAction);

			List<PT_IL_POL_SA_INST_PYMT> dataList = compositeAction
					.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN()
					.getDataList_PT_IL_POL_SA_INST_PYMT();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_POL_SA_INST_PYMT PT_IL_POL_SA_INST_PYMT_BEAN = dataList
						.get(0);
				PT_IL_POL_SA_INST_PYMT_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN()
						.setPT_IL_POL_SA_INST_PYMT_BEAN(
								PT_IL_POL_SA_INST_PYMT_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}

	public void PRE_QUERY(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_SA_INST_PYMT pt_il_pol_sa_inst_pymt_bean = compositeAction
				.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN()
				.getPT_IL_POL_SA_INST_PYMT_BEAN();

		try {
			pt_il_pol_sa_inst_pymt_bean.setSIPD_POL_SYS_ID(pt_il_policy_bean
					.getPOL_SYS_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_SA_INST_PYMT pt_il_pol_sa_inst_pymt_bean = compositeAction
				.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN()
				.getPT_IL_POL_SA_INST_PYMT_BEAN();
		PT_IL_POL_SA_INST_PYMT_DELEGATE pt_il_pol_sa_inst_pymt_delegate = new PT_IL_POL_SA_INST_PYMT_DELEGATE();
		try {
			// PENDING POST
			/*
			 * IF :SYSTEM.FORM_STATUS IN ('CHANGED') THEN :CTRL.M_COMM_DEL :=
			 * 'P'; COPY('20','SYSTEM.MESSAGE_LEVEL'); POST; :CTRL.M_COMM_DEL :=
			 * NULL; :PT_IL_POLICY.POL_RES_ADDRESS_1 :=
			 * :PT_IL_POLICY.POL_RES_ADDRESS_1; // -- EXECUTE_QUERY;
			 * COPY('0','SYSTEM.MESSAGE_LEVEL'); END IF;
			 */

			// COPY('20','SYSTEM.MESSAGE_LEVEL');
			pt_il_pol_sa_inst_pymt_delegate
					.executeSelectStatement(compositeAction);
			// COPY('0','SYSTEM.MESSAGE_LEVEL');

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_SA_INST_PYMT pt_il_pol_sa_inst_pymt_bean = compositeAction
				.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN()
				.getPT_IL_POL_SA_INST_PYMT_BEAN();
		PT_IL_POL_SA_INST_PYMT_ACTION pt_il_pol_sa_inst_pymt_action = compositeAction
				.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		Object[] values = {};
		ArrayList<String> pValList = new ArrayList<String>();
		String M_ASD_CHAR_VALUE = null;
		String M_USER_PERM = null;
		String query1 = "  SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET  WHERE  "
				+ " ASD_USER_ID = ?  AND   ASD_CODE    = 'CHG_MAT_YN' "
				+ " AND     ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') "
				+ "AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')  ";
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();
			if (pt_il_pol_sa_inst_pymt_bean.getROWID() != null) {
				/*
				 * COPY('P','CTRL.M_COMM_DEL') ;
				 * COPY('20','SYSTEM.MESSAGE_LEVEL'); POST;
				 * COPY('','CTRL.M_COMM_DEL') ;
				 * COPY('0','SYSTEM.MESSAGE_LEVEL');
				 */
			}
			values = new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),pt_il_policy_bean.getPOL_PROD_CODE() };

			rs = new CRUDHandler().executeSelectStatement(query1, connection,
					values);
			if (rs.next()) {
				M_ASD_CHAR_VALUE = rs.getString(1);
			}

			if ("Y".equals(M_ASD_CHAR_VALUE)) {
				if ("Y".equals(CommonUtils.SUBSTR(CommonUtils
						.getGlobalVariable("GLOBAL.M_PRIVILEGE"), 2, 1))) {
					pt_il_pol_sa_inst_pymt_action.setUPDATE_ALLOWED(true);
				}
				if ("Y".equals(CommonUtils.SUBSTR(CommonUtils
						.getGlobalVariable("GLOBAL.M_PRIVILEGE"), 3, 1))) {
					pt_il_pol_sa_inst_pymt_action.setDELETE_ALLOWED(true);

				}
			} else {
				pt_il_pol_sa_inst_pymt_action.setINSERT_ALLOWED(false);
				pt_il_pol_sa_inst_pymt_action.setUPDATE_ALLOWED(false);
				pt_il_pol_sa_inst_pymt_action.setDELETE_ALLOWED(false);
			}

			if ("A".equals(CommonUtils.nvl(pt_il_policy_bean
					.getPOL_APPRV_STATUS(), "N"))) {
				pt_il_pol_sa_inst_pymt_action.setINSERT_ALLOWED(false);
				pt_il_pol_sa_inst_pymt_action.setUPDATE_ALLOWED(false);
				pt_il_pol_sa_inst_pymt_action.setDELETE_ALLOWED(false);

			}
			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) > 0
					&& "001".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))
					&& !"A".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_APPRV_STATUS(), "N"))) {

				pValList = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(CommonUtils
						.getControlBean().getM_USER_ID(), "CHG_MAT_YN",
						pt_il_policy_bean.getPOL_PROD_CODE(), "2", M_USER_PERM,
						pt_il_policy_bean.getPOL_END_CODE());

				if (pValList.size() > 0) {
					M_USER_PERM = pValList.get(0);
				}
				if ("N".equals(CommonUtils.nvl(M_USER_PERM, "X"))) {
					pt_il_pol_sa_inst_pymt_action.setINSERT_ALLOWED(false);
					pt_il_pol_sa_inst_pymt_action.setUPDATE_ALLOWED(false);
					pt_il_pol_sa_inst_pymt_action.setDELETE_ALLOWED(false);
				} else {
					pt_il_pol_sa_inst_pymt_action.setUPDATE_ALLOWED(true);
					pt_il_pol_sa_inst_pymt_action.setDELETE_ALLOWED(true);
				}

			}
			if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) > 0
					&& !"001".equals(CommonUtils.nvl(pt_il_policy_bean
							.getPOL_END_TYPE(), "000"))) {
				pt_il_pol_sa_inst_pymt_action.setINSERT_ALLOWED(false);
				pt_il_pol_sa_inst_pymt_action.setUPDATE_ALLOWED(false);
				pt_il_pol_sa_inst_pymt_action.setDELETE_ALLOWED(false);

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
}
