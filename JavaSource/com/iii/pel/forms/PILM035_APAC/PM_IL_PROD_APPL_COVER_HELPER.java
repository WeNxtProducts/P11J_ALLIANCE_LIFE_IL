package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.ValidationException;




import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_APPL_COVER_HELPER {
	DBProcedures dbProcedures = new DBProcedures();

	public void PRE_BLOCK() throws Exception {
		CommonUtils.setGlobalVariable("M_DELETE_MSG_FLAG", "N");
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (("1".equals(pm_il_product_bean.getPROD_BROK_CALC_MTHD()))
					|| ("5".equalsIgnoreCase(pm_il_product_bean
							.getPROD_BROK_CALC_MTHD()))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		try {
			pm_il_prod_appl_cover_bean.setPAC_MANDATORY_YN("Y");
			pm_il_prod_appl_cover_bean.setPAC_DEFAULT_YN("Y");
			pm_il_prod_appl_cover_bean.setPAC_TARIFF_TERM_FLAG("1");
			pm_il_prod_appl_cover_bean.setPAC_PRODUCTION_PERC(100.0);
			pm_il_prod_appl_cover_bean.setPAC_THRESHOLD_PERC(100.0);
			pm_il_prod_appl_cover_bean.setPAC_GRP_THRESHOLD_PERC(100.0);
			pm_il_prod_appl_cover_bean.setPAC_RSA_CALC_YN("N");
			pm_il_prod_appl_cover_bean.setPAC_COVER_ASSR_TYPE("R");

			if ("1".equalsIgnoreCase(pm_il_product_bean.getPROD_BROK_CALC_MTHD())
					|| "5".equalsIgnoreCase(pm_il_product_bean.getPROD_BROK_CALC_MTHD())) {
				pm_il_prod_appl_cover_bean.setPAC_BCH_CODE(pm_il_product_bean
						.getPROD_BCH_CODE());
				pm_il_prod_appl_cover_bean
						.setUI_M_PAC_BCH_CODE_DESC(pm_il_product_bean
								.getPROD_BCH_CODE_DESC());
			}
			pm_il_prod_appl_cover_bean.setPAC_BCH_TERM("2");
			compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getCOMP_PAC_DEFAULT_YN().setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PROD_APPL_COVER_DELEGATE()
				.executeSelectStatement(compositeAction);

		try {
			List<PM_IL_PROD_APPL_COVER> dataList = compositeAction
					.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getDataList_PM_IL_PROD_APPL_COVER();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_APPL_COVER PM_IL_PROD_APPL_COVER_BEAN = dataList
						.get(0);
				
				//added by soundarya for additional cover 11-05-2016
				String age_basis=compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getPM_IL_PROD_APPL_COVER_BEAN().getPAC_AGE_BASIS();
				if ("E".equalsIgnoreCase(age_basis)) {
							compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
							.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(true);
							compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
							.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(false);
							
				} else if ("R".equalsIgnoreCase(age_basis)) {
					compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
					compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
					/*compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
					compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
							.getCOMP_PAC_MAT_PAYER_AGE().setRequired(true);
					compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
					compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
							.getCOMP_PAC_MAT_PAYEE_AGE().setRequired(false);		*/		
				
				}
				
				
				
				PM_IL_PROD_APPL_COVER_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.setPM_IL_PROD_APPL_COVER_BEAN(
								PM_IL_PROD_APPL_COVER_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		String M_PAC_BCH_CODE_DESC = null;
		String M_COVER_CLASS = null;
		String M_COVER_SA_CALC = null;
		String M_COVER_SA_CALC_1 = null;

		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();

		String c1 = "SELECT 'X'  FROM   PT_IL_POL_ADDL_COVER,PT_IL_POLICY WHERE  POAC_COVER_CODE = ? and "
				+ "POAC_POL_SYS_ID = POL_SYS_ID  AND  POL_PROD_CODE = ?";

		String c2 = "SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR WHERE  BCH_CODE = ?";

		// rs = handler.executeSelectStatement(c2, con, c2values);
		String c3 = "SELECT COVER_CLASS, NVL(COVER_SA_CALC,'X') FROM   PM_IL_COVER WHERE  COVER_CODE = ?";

		String C4 = "SELECT NVL(COVER_SA_CALC,'X') " + "FROM   PM_IL_COVER "
				+ "WHERE  COVER_CODE = ?";
		ArrayList<String> retList = null;
		try {

			con = CommonUtils.getConnection();
			retList = PILM035_PROCEDURES.P_VAL_COVER_1(
					pm_il_prod_appl_cover_bean.getPAC_COVER_CODE(),
					pm_il_prod_appl_cover_bean.getUI_M_PAC_COVER_CODE_DESC(),
					"N", "N");
			if (retList != null) {
				pm_il_prod_appl_cover_bean.setUI_M_PAC_COVER_CODE_DESC(retList
						.get(0));
			}
			Object[] c1values = {
					pm_il_prod_appl_cover_bean.getPAC_COVER_CODE(),
					pm_il_product_bean.getPROD_CODE() };

			rs1 = handler.executeSelectStatement(c1, con, c1values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
			}

			Object[] c2values = { pm_il_prod_appl_cover_bean.getPAC_BCH_CODE() };
			rs2 = handler.executeSelectStatement(c2, con, c2values);
			while (rs2.next()) {
				M_PAC_BCH_CODE_DESC = rs2.getString(1);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getPM_IL_PROD_APPL_COVER_BEAN()
						.setUI_M_PAC_BCH_CODE_DESC(M_PAC_BCH_CODE_DESC);
			}
			if (("1".equalsIgnoreCase(pm_il_product_bean
					.getPROD_BROK_CALC_MTHD()))
					|| ("5".equalsIgnoreCase(pm_il_product_bean
							.getPROD_BROK_CALC_MTHD()))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(false);
			}
			Object[] c4values = { pm_il_product_bean.getPROD_PLAN_CODE() };
			rs4 = handler.executeSelectStatement(C4, con, c4values);

			if (pm_il_prod_appl_cover_bean.getPAC_COVER_CODE() != null) {
				while (rs4.next()) {
					M_COVER_SA_CALC_1 = rs4.getString(1);
				}
			}
			Object[] c3values = { pm_il_prod_appl_cover_bean
					.getPAC_COVER_CODE() };
			rs3 = handler.executeSelectStatement(c3, con, c3values);
			if (pm_il_prod_appl_cover_bean.getPAC_COVER_CODE() != null) {
				while (rs3.next()) {
					M_COVER_CLASS = rs3.getString(1);
					M_COVER_SA_CALC = rs3.getString(2);
				}
			}
			
			//as discussed with siva sir cover sa calc  "S" added by gopi for toi on 11/06/2018
			if (("M".equalsIgnoreCase(M_COVER_CLASS))||("D".equalsIgnoreCase(M_COVER_SA_CALC_1)&&("G".equalsIgnoreCase( M_COVER_SA_CALC )))
					||("S".equalsIgnoreCase( M_COVER_SA_CALC ))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(false);
			}
			else if (("M".equalsIgnoreCase(M_COVER_CLASS))||("H".equalsIgnoreCase(M_COVER_SA_CALC_1)&&("G".equalsIgnoreCase( M_COVER_SA_CALC )))||("S".equalsIgnoreCase( M_COVER_SA_CALC ))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(false);
			}
			else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setRequired(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setRequired(false);
			}
			if ((("D".equalsIgnoreCase(M_COVER_SA_CALC))
					|| ("M".equalsIgnoreCase(CommonUtils
							.nvl(M_COVER_CLASS, "X"))))||("D".equalsIgnoreCase(M_COVER_SA_CALC_1)&&("G".equalsIgnoreCase( M_COVER_SA_CALC )))
							||("S".equalsIgnoreCase( M_COVER_SA_CALC ))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(false);
				
			}
			//newly added 
			else if ((("H".equalsIgnoreCase(M_COVER_SA_CALC))
					|| ("M".equalsIgnoreCase(CommonUtils
							.nvl(M_COVER_CLASS, "X"))))||("H".equalsIgnoreCase(M_COVER_SA_CALC_1)&&("G".equalsIgnoreCase( M_COVER_SA_CALC )))
							||("S".equalsIgnoreCase( M_COVER_SA_CALC ))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_SA_ADD_FACTOR()
				.setDisabled(false);
			} 
			//ends here
			else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_SA_ADD_FACTOR()
				.setDisabled(true);
			}
			if (pm_il_prod_appl_cover_bean.getPAC_SA_FACTOR() != null) {
				ArrayList<String> PAC_SA_FACTOR_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_SA_FACTOR(), dummy_bean
								.getUI_M_PAC_SA_FACTOR(), "N", "N", null);
				if (PAC_SA_FACTOR_DESC_LIST.get(0) != null) {
					dummy_bean.setUI_M_PAC_SA_FACTOR(PAC_SA_FACTOR_DESC_LIST
							.get(0));
				}

			} else {
				dummy_bean.setUI_M_PAC_SA_FACTOR(null);

			}

			if (pm_il_prod_appl_cover_bean.getPAC_SA_ADD_FACTOR() != null) {
				ArrayList<String> UI_M_PAC_SA_ADD_FACTOR_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_SA_ADD_FACTOR(), dummy_bean
								.getUI_M_PAC_SA_ADD_FACTOR(), "N", "N", null);
				if (UI_M_PAC_SA_ADD_FACTOR_DESC_LIST.get(0) != null) {
					dummy_bean
							.setUI_M_PAC_SA_ADD_FACTOR(UI_M_PAC_SA_ADD_FACTOR_DESC_LIST
									.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_SA_ADD_FACTOR("");
			}

			if (pm_il_prod_appl_cover_bean.getPAC_SA_TARIFF() != null) {
				ArrayList<String> PAC_SA_TARIFF_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_SA_TARIFF(), dummy_bean
								.getUI_M_PAC_SA_TARIFF(), "N", "N", null);
				dummy_bean
						.setUI_M_PAC_SA_TARIFF(PAC_SA_TARIFF_DESC_LIST.get(0));
			} else {
				dummy_bean.setUI_M_PAC_SA_TARIFF("");
			}

			if (pm_il_prod_appl_cover_bean.getPAC_PREM_TARIFF() != null) {
				ArrayList<String> PAC_PREM_TARIFF_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_PREM_TARIFF(), dummy_bean
								.getUI_M_PAC_PREM_TARIFF(), "N", "N", null);
				dummy_bean.setUI_M_PAC_PREM_TARIFF(PAC_PREM_TARIFF_DESC_LIST
						.get(0));
			} else {
				dummy_bean.setUI_M_PAC_PREM_TARIFF(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
				CommonUtils.closeCursor(rs4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = null;
		String c1 = "SELECT COVER_CLASS, NVL(COVER_SA_CALC,'X') FROM   PM_IL_COVER WHERE  COVER_CODE = ?";
		Object[] values = { pm_il_prod_appl_cover_bean.getPAC_COVER_CODE() };

		String M_COVER_CLASS = null;
		String M_COVER_SA_CALC = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rs = handler.executeSelectStatement(c1, con, values);

			while (rs.next()) {
				M_COVER_CLASS = rs.getString(1);
				M_COVER_SA_CALC = rs.getString(2);
			}
			if ("M".equalsIgnoreCase(M_COVER_CLASS)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setRequired(true);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_DAYS().setRequired(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MED_AMT().setRequired(false);
			}
			if (("D".equalsIgnoreCase(M_COVER_SA_CALC))
					|| ("M".equalsIgnoreCase(CommonUtils
							.nvl(M_COVER_CLASS, "X")))||("S".equalsIgnoreCase( M_COVER_SA_CALC ))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setRequired(true);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_SA_FACTOR().setRequired(false);
			}

			if (pm_il_prod_appl_cover_bean.getPAC_SA_FACTOR() != null) {
				ArrayList<String> PAC_SA_FACTOR_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_SA_FACTOR(), dummy_bean
								.getUI_M_PAC_SA_FACTOR(), "N", "N", null);
				if (PAC_SA_FACTOR_DESC_LIST.get(0) != null) {
					dummy_bean.setUI_M_PAC_SA_FACTOR(PAC_SA_FACTOR_DESC_LIST
							.get(0));
				}

			} else {

				dummy_bean.setUI_M_PAC_SA_FACTOR(null);
			}
			if (pm_il_prod_appl_cover_bean.getPAC_SA_TARIFF() != null) {
				ArrayList<String> PAC_SA_TARIFF_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_SA_TARIFF(), dummy_bean
								.getUI_M_PAC_SA_TARIFF(), "N", "N", null);
				if (PAC_SA_TARIFF_DESC_LIST.get(0) != null) {
					dummy_bean.setUI_M_PAC_SA_TARIFF(PAC_SA_TARIFF_DESC_LIST
							.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_SA_TARIFF(null);
			}

			if (pm_il_prod_appl_cover_bean.getPAC_PREM_TARIFF() != null) {
				ArrayList<String> PAC_PREM_TARIFF_DESC_LIST = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", pm_il_prod_appl_cover_bean
								.getPAC_PREM_TARIFF(), dummy_bean
								.getUI_M_PAC_PREM_TARIFF(), "N", "N", null);
				if (PAC_PREM_TARIFF_DESC_LIST.get(0) != null) {
					dummy_bean
							.setUI_M_PAC_PREM_TARIFF(PAC_PREM_TARIFF_DESC_LIST
									.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_PREM_TARIFF("");
			}

		} catch (SQLException e) {
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

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
					.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
					.getPM_IL_PROD_APPL_COVER_BEAN();
			PM_IL_PRODUCT pm_il_product_bean = compositeAction
					.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

			pm_il_prod_appl_cover_bean
			.setPAC_GROUP_CVR_CODE(compositeAction
					.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN()
					.getPM_IL_PROD_APPL_CVR_GRP_BEAN()
					.getPACG_CVR_GROUP_CODE());
			L_VAL_COVER_UNIQUE(compositeAction);
			L_VAL_WOP_COVER_UNIQUE(compositeAction);
			pm_il_prod_appl_cover_bean.setPAC_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			pm_il_prod_appl_cover_bean.setPAC_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_cover_bean.setPAC_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());

		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		String M_COVER_CLASS = null;
		String C1 = "SELECT 'X' FROM PM_IL_PROD_APPL_COVER,PM_IL_COVER  WHERE  PAC_PROD_CODE  = ? AND "
				+ "PAC_COVER_CODE = COVER_CODE AND  COVER_CLASS='W' AND PM_IL_PROD_APPL_COVER.ROWID != ? AND PAC_DEFAULT_YN='Y'";

		String C2 = "SELECT COVER_CLASS FROM   PM_IL_COVER WHERE  COVER_CODE = ?";

		try {
			L_VAL_COVER_UNIQUE(compositeAction);
			con = CommonUtils.getConnection();
			pm_il_prod_appl_cover_bean.setPAC_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_cover_bean.setPAC_UPD_UID(CommonUtils
					.getControlBean().getUSER_ID());

			Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_cover_bean.getROWID() };
			resultSet1 = handler.executeSelectStatement(C1, con, c1values);
			while (resultSet1.next()) {
				M_DUMMY = resultSet1.getString(1);
			}
			if (M_DUMMY != null) {
				Object[] c2values = { pm_il_prod_appl_cover_bean
						.getPAC_COVER_CODE() };
				resultSet2 = handler.executeSelectStatement(C2, con, c2values);
				while (resultSet2.next()) {
					M_COVER_CLASS = resultSet2.getString(1);
				}
				if ("W".equalsIgnoreCase(M_COVER_CLASS)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91407"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void PRE_DELETE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws ValidationException, SQLException, DBException {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		ResultSet rs1 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		String c1 = "SELECT 'X'  FROM   PT_IL_POL_ADDL_COVER,PT_IL_POLICY WHERE  POAC_COVER_CODE = ? AND "
				+ "POAC_POL_SYS_ID = POL_SYS_ID  AND    POL_PROD_CODE = ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = {
					pm_il_prod_appl_cover_bean.getPAC_COVER_CODE(),
					pm_il_product_bean.getPROD_CODE() };
			rs1 = handler.executeSelectStatement(c1, con, c1values);
			if(rs1.next()) {
				M_DUMMY = rs1.getString(1);
				throw new ValidationException(Messages.getString(
						PELConstants.pelErrorMessagePath, "91060"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_VAL_COVER_UNIQUE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String M_DUMMY = null;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		String C1 = "SELECT 'X'  FROM   PM_IL_PROD_APPL_COVER  WHERE PAC_PROD_CODE = ? AND PAC_GROUP_CVR_CODE = ?  AND "
				+ "PAC_COVER_CODE = ?";

		String C2 = "SELECT 'X'  FROM   PM_IL_PROD_APPL_COVER  WHERE PAC_PROD_CODE = ? AND PAC_GROUP_CVR_CODE = ?  AND "
				+ "PAC_COVER_CODE = ? AND  ROWID  <> ?";
		try {

			con = CommonUtils.getConnection();

			if (pm_il_prod_appl_cover_bean.getROWID() == null) {
				Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_appl_cover_bean.getPAC_GROUP_CVR_CODE(),
						pm_il_prod_appl_cover_bean.getPAC_COVER_CODE(),
						};
				rs1 = handler.executeSelectStatement(C1, con, c1values);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1502"));
				}
			} else {
				Object[] c2values = { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_appl_cover_bean.getPAC_GROUP_CVR_CODE(),
						pm_il_prod_appl_cover_bean.getPAC_COVER_CODE(),
						pm_il_prod_appl_cover_bean.getROWID() };
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1502"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_VAL_WOP_COVER_UNIQUE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		String currValue = pm_il_prod_appl_cover_bean.getPAC_COVER_CODE();
		Connection con = null;
		CommonUtils utility = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_DUMMY = null;
		String M_COVER_CLASS = null;
		String C1 = "SELECT 'X'  FROM   PM_IL_PROD_APPL_COVER,PM_IL_COVER  WHERE PAC_PROD_CODE = ? AND "
				+ "PAC_COVER_CODE = COVER_CODE AND  COVER_CLASS='W' AND PAC_DEFAULT_YN='Y' ";

		String C2 = "SELECT COVER_CLASS  FROM   PM_IL_COVER  WHERE COVER_CODE = ?";
		try {
			con = CommonUtils.getConnection();

			Object[] c1values = { pm_il_product_bean.getPROD_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, c1values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
				Object[] c2values = { currValue };
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				if(rs2.next()) {
					M_COVER_CLASS = rs2.getString("COVER_CLASS");
				}
				if ("W".equalsIgnoreCase(M_COVER_CLASS)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91407"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_PERIOD(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		int PAC_PERIOD = (Integer) currValue;
		int PROD_PERIOD = (Integer) currValue;

		try {
			if ((CommonUtils.nvl(PAC_PERIOD, 0) <= 0)
					|| (PAC_PERIOD > PROD_PERIOD)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Cover Policy term Period ",
								" Greater than 0 ",
								" and Less Than or Equal to " + PROD_PERIOD }));

			} else {
				pm_il_prod_appl_cover_bean.setPAC_PREM_PAY_YRS(PAC_PERIOD);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_LIST_CHANGED_PAC_MANDATORY_YN(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		String PAC_MANDATORY_YN = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(PAC_MANDATORY_YN)) {
				pm_il_prod_appl_cover_bean.setPAC_DEFAULT_YN("Y");
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_DEFAULT_YN().setDisabled(true);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_DEFAULT_YN().setDisabled(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<String> P_VAL_COVER_1(String P_COVER_CODE,
			String P_COVER_DESC, String P_NAME_FLAG, String P_ERR_FLAG)
			throws SQLException, Exception {
		Connection con = null;

		ArrayList<String> returnList;

		try {
			con = CommonUtils.getConnection();
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			returnList = new ArrayList<String>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					P_COVER_CODE);
			OracleParameter param2 = new OracleParameter("in out2", "STRING",
					"IN OUT", P_COVER_DESC);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					P_NAME_FLAG);
			OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
					P_ERR_FLAG);
			parameterList.add(param1);
			parameterList.add(param2);
			parameterList.add(param3);
			parameterList.add(param4);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, con,
					"P_VAL_COVER_1");
			Iterator<OracleParameter> it = outputList.iterator();
			while (it.hasNext()) {
				OracleParameter oracleParameter = it.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				returnList.add(oracleParameter.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(con);
            throw new ProcedureException(e.getMessage());
		}
		return returnList;

	}

	public void WHEN_VALIDATE_ITEM_PAC_COVER_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		Date M_COVER_EFF_FM_DT = null;
		Date M_COVER_EFF_TO_DT = null;
		String M_COVER_CLASS = null;
		String M_COVER_SA_CALC = null;
		String PAC_COVER_CODE = (String) currValue;
		DateFormat dateFormatter = null;
		Date coverEffFromDate = null;
		Date prodEffFromDate = null;
		Date prodEffToDate = null;
		ArrayList<String> pList = new ArrayList<String>();

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();

		String C1 = "SELECT NVL(COVER_EFF_FM_DT,SYSDATE) COVER_EFF_FM_DT , "
				+ "NVL(COVER_EFF_TO_DT,SYSDATE) COVER_EFF_TO_DT ,COVER_CLASS, NVL(COVER_SA_CALC,'X') COVER_SA_CALC "
				+ "FROM   PM_IL_COVER WHERE  COVER_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { (String) currValue };
			rs = handler.executeSelectStatement(C1, con, c1values);

			if (PAC_COVER_CODE != null) {
				while (rs.next()) {
					M_COVER_EFF_FM_DT = CommonUtils.timeStampToMonthDateYear(rs.getDate("COVER_EFF_FM_DT"));
					M_COVER_EFF_TO_DT = CommonUtils.timeStampToMonthDateYear(rs.getDate("COVER_EFF_TO_DT"));
					M_COVER_CLASS = rs.getString("COVER_CLASS");
					M_COVER_SA_CALC = rs.getString("COVER_SA_CALC");
				}
			}

			CommonUtils commonUtils = new CommonUtils();
			if(pm_il_product_bean.getPROD_EFF_FM_DT() != null){
			 prodEffFromDate = CommonUtils.timeStampToMonthDateYear(pm_il_product_bean.getPROD_EFF_FM_DT());
			 }
			Date currentDate = commonUtils.getCurrentDate();
			if(M_COVER_EFF_FM_DT != null){
			 coverEffFromDate = M_COVER_EFF_FM_DT;
			}
			Date refFromDate =CommonUtils.timeStampToMonthDateYear(CommonUtils.stringToUtilDate("01-JAN-1900"));
			Date prodEffRefDate = CommonUtils.nvl(prodEffFromDate, currentDate);
			Date coverEffToDate = M_COVER_EFF_TO_DT;
			Date refToDate = CommonUtils.timeStampToMonthDateYear(CommonUtils.stringToUtilDate("31-DEC-2999"));
			if(pm_il_product_bean.getPROD_EFF_TO_DT() != null){
			 prodEffToDate =CommonUtils.timeStampToMonthDateYear(pm_il_product_bean.getPROD_EFF_TO_DT());
			}
			if((prodEffRefDate!=null) && (prodEffToDate!=null)){
			if (((prodEffRefDate.after(CommonUtils.nvl(coverEffFromDate,refFromDate)) 
					&& prodEffRefDate.before(CommonUtils.nvl(coverEffToDate, refToDate)))
					&& (prodEffToDate.after(CommonUtils.nvl(coverEffFromDate,refFromDate))
							&& prodEffToDate.before(CommonUtils.nvl(coverEffToDate, refToDate))))) {

				pm_il_prod_appl_cover_bean.setPAC_COVER_CODE((String) currValue);
				L_VAL_WOP_COVER_UNIQUE(compositeAction);
				pList = P_VAL_COVER_1((String) currValue, 
										pm_il_prod_appl_cover_bean.getUI_M_PAC_COVER_CODE_DESC(),
															"N", 
															"E");
				if(!pList.isEmpty() && pList.size() > 0){
					pm_il_prod_appl_cover_bean.setUI_M_PAC_COVER_CODE_DESC(pList.get(0));
				}
			}
			}else {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91065"));
			}

			if ("M".equals(M_COVER_CLASS)) {

				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_DAYS().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_DAYS().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_AMT().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_AMT().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_SA_FACTOR().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_DAYS().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_DAYS().setRequired(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_AMT().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_MED_AMT().setRequired(false);
			}
			if (("D".equals(M_COVER_SA_CALC)) || ("M".equals(CommonUtils.nvl(M_COVER_CLASS, "X")))||("S".equalsIgnoreCase( M_COVER_SA_CALC ))) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_SA_FACTOR().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getCOMP_PAC_SA_FACTOR().setDisabled(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
				e.printStackTrace();
				throw e;
		}finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_PREM_PAY_YRS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		int PAC_PREM_PAY_YRS = (Integer) currValue;
		int PAC_PERIOD = (Integer) currValue;
		try {
			if ((CommonUtils.nvl(PAC_PREM_PAY_YRS, 0) <= 0)
					|| (CommonUtils.nvl(PAC_PREM_PAY_YRS, 0)) > (PAC_PERIOD)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Cover Premium Paying term Period ",
								" Greater than 0 ",
								" and Less Than or Equal to " + PAC_PERIOD }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_MAX_AGE_ON_MAT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		int PAC_MAX_AGE_ON_MAT = (Integer) currValue;
		try {
			if(dummy_bean
					.getUI_M_PLAN_MAX_AGE_ON_MAT() != null){
			if ((CommonUtils.nvl(PAC_MAX_AGE_ON_MAT, 0) <= 0)
					|| (((CommonUtils.nvl(PAC_MAX_AGE_ON_MAT, 0)) > (dummy_bean
							.getUI_M_PLAN_MAX_AGE_ON_MAT())))) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] {
												"Maximum Age on Maturity",
												"Greater than 0 ",
												" and Less Than or Equal to "
														+ dummy_bean
																.getUI_M_PLAN_MAX_AGE_ON_MAT() }));
							}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_BCH_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		String M_PAC_BCH_CODE_DESC = null;
		String PAC_BCH_CODE = (String) currValue;

		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		String C1 = " SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR  WHERE  BCH_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			Object[] values = { PAC_BCH_CODE };
			rs = handler.executeSelectStatement(C1, con, values);
			if (PAC_BCH_CODE != null) {
				while (rs.next()) {
					M_PAC_BCH_CODE_DESC = rs.getString("BCH_DESC");
				}
				if (M_PAC_BCH_CODE_DESC == null) {

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Invalid Commission Code" }));

				} else {
					pm_il_prod_appl_cover_bean
							.setUI_M_PAC_BCH_CODE_DESC(M_PAC_BCH_CODE_DESC);
				}
			} else {
				pm_il_prod_appl_cover_bean.setUI_M_PAC_BCH_CODE_DESC("");
			}
		} catch (SQLException e) {
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

	public void WHEN_VALIDATE_ITEM_PAC_PRODUCTION_PERC(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Double PAC_PRODUCTION_PERC = (Double) currValue;
		try {
			if (CommonUtils.nvl(PAC_PRODUCTION_PERC, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));
			}
			if (CommonUtils.nvl(PAC_PRODUCTION_PERC, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71017"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_THRESHOLD_PERC(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Double PAC_THRESHOLD_PERC = (Double) currValue;
		try {
			if (CommonUtils.nvl(PAC_THRESHOLD_PERC, 0) < 0) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));
			}
			if (CommonUtils.nvl(PAC_THRESHOLD_PERC, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71017"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_MED_DAYS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		int PAC_MED_DAYS = (Integer) currValue;
		try {
			if (PAC_MED_DAYS <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_MED_AMT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Double PAC_MED_AMT = (Double) currValue;
		try {
			if (PAC_MED_AMT <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_GRP_THRESHOLD_PERC(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Double PAC_GRP_THRESHOLD_PERC = (Double) currValue;
		try {
			if (CommonUtils.nvl(PAC_GRP_THRESHOLD_PERC, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));

			}
			if (CommonUtils.nvl(PAC_GRP_THRESHOLD_PERC, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71017"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_SA_FACTOR(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String PAC_SA_FACTOR = (String) currValue;

		try {
			if (PAC_SA_FACTOR != null) {
				ArrayList<String> pac_sa_factor_dummy = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", PAC_SA_FACTOR, dummy_bean
								.getUI_M_PAC_SA_FACTOR(), "N", "N", null);
				if (pac_sa_factor_dummy.get(0) != null) {
					dummy_bean
							.setUI_M_PAC_SA_FACTOR(pac_sa_factor_dummy.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_SA_FACTOR("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_SA_TARIFF(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String PAC_SA_TARIFF = (String) currValue;

		try {
			if (PAC_SA_TARIFF != null) {
				ArrayList<String> pac_sa_tariff_dummy = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", PAC_SA_TARIFF, dummy_bean
								.getUI_M_PAC_SA_TARIFF(), "N", "N", null);
				if (pac_sa_tariff_dummy.get(0) != null) {
					dummy_bean
							.setUI_M_PAC_SA_TARIFF(pac_sa_tariff_dummy.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_SA_TARIFF("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_SA_ADD_FACTOR(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String PAC_SA_ADD_FACTOR = (String) currValue;
		try {
			if (PAC_SA_ADD_FACTOR != null) {
				ArrayList<String> pac_sa_add_factor_dummy = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", PAC_SA_ADD_FACTOR,
								dummy_bean.getUI_M_PAC_SA_ADD_FACTOR(), "N",
								"N", null);
				if (pac_sa_add_factor_dummy.get(0) != null) {
					dummy_bean
							.setUI_M_PAC_SA_ADD_FACTOR(pac_sa_add_factor_dummy
									.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_SA_ADD_FACTOR("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_PREM_TARIFF(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String PAC_PREM_TARIFF = (String) currValue;
		try {
			if (PAC_PREM_TARIFF != null) {
				ArrayList<String> pac_prem_tariff_dummy = PILM035_PROCEDURES
						.P_VAL_CODES("IL_VAL_TAR", PAC_PREM_TARIFF, dummy_bean
								.getUI_M_PAC_PREM_TARIFF(), "N", "N", null);
				if (pac_prem_tariff_dummy.get(0) != null) {
					dummy_bean.setUI_M_PAC_PREM_TARIFF(pac_prem_tariff_dummy
							.get(0));
				}
			} else {
				dummy_bean.setUI_M_PAC_PREM_TARIFF("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_COVER_ASSR_TYPE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_PAC_COVER_CODE = null;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		String C1 = "SELECT PAC_COVER_CODE FROM   PM_IL_PROD_APPL_COVER "
				+ "WHERE  PAC_PROD_CODE  = ? " + "AND		 PAC_COVER_CODE = ? "
				+ "AND    PAC_COVER_ASSR_TYPE IN('E','R') ";
		String C2 = "SELECT PAC_COVER_CODE FROM   PM_IL_PROD_APPL_COVER "
				+ "WHERE  PAC_PROD_CODE  = ? " + "AND		 PAC_COVER_CODE = ? "
				+ "AND    PAC_COVER_ASSR_TYPE IN('E','R') "
				+ "AND    ROWID <> ? ";
		String PAC_COVER_ASSR_TYPE = (String) currValue;
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_cover_bean.getPAC_COVER_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, c1values);
			Object[] c2values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_cover_bean.getPAC_COVER_CODE() };
			rs2 = handler.executeSelectStatement(C2, con, c2values);
			if ("B".equalsIgnoreCase(PAC_COVER_ASSR_TYPE)) {
				while (rs1.next()) {
					M_PAC_COVER_CODE = rs1.getString(1);
				}
				if ("M_PAC_COVER_CODE"
						.equalsIgnoreCase(pm_il_prod_appl_cover_bean
								.getPAC_COVER_CODE())) {
					pm_il_prod_appl_cover_bean.setPAC_COVER_ASSR_TYPE("R");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1502"));
				}
			} else {
				while (rs2.next()) {
					M_PAC_COVER_CODE = rs2.getString(1);
				}
				if ("M_PAC_COVER_CODE"
						.equalsIgnoreCase(pm_il_prod_appl_cover_bean
								.getPAC_COVER_CODE())) {
					pm_il_prod_appl_cover_bean.setPAC_COVER_ASSR_TYPE("R");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1502"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_AGE_BASIS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		String PAC_AGE_BASIS = (String) currValue;
		try {
			if ("E".equalsIgnoreCase(PAC_AGE_BASIS)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setRequired(true);
				//pm_il_prod_appl_cover_bean.setPAC_MAT_PAYER_AGE(null);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setRequired(false);
			} else if ("R".equalsIgnoreCase(PAC_AGE_BASIS)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setRequired(true);
				//pm_il_prod_appl_cover_bean.setPAC_MAT_PAYEE_AGE(null);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setRequired(false);
			} else if ("M".equalsIgnoreCase(PAC_AGE_BASIS)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYER_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_MAT_PAYEE_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYEE_AGE().setRequired(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_MAT_PAYER_AGE().setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_COVER_START_AGE_VAL_YN(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();
		String PAC_COVER_START_AGE_VAL_YN = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(PAC_COVER_START_AGE_VAL_YN)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_COVER_START_AGE().setDisabled(false);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_COVER_START_AGE().setRequired(true);
			} else if ("N".equalsIgnoreCase(PAC_COVER_START_AGE_VAL_YN)) {
			/*	pm_il_prod_appl_cover_bean.setPAC_COVER_START_AGE(null);*/
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getCOMP_PAC_COVER_START_AGE().setDisabled(true);
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_COVER_START_AGE().setRequired(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_COVER_START_AGE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		
		/*Modified by Janani on 28.04.2018*/
		//Double PAC_COVER_START_AGE = (Double) currValue;
		
		int PAC_COVER_START_AGE = (int) currValue;
		
		/*End*/
		try {
			if (PAC_COVER_START_AGE < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91341"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_MAT_PAYER_AGE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Integer PAC_MAT_PAYER_AGE = (Integer) currValue;
		try {
			if (PAC_MAT_PAYER_AGE < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91341"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PAC_MAT_PAYEE_AGE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Integer PAC_MAT_PAYEE_AGE = (Integer) currValue;
		try {
			if (PAC_MAT_PAYEE_AGE < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91341"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<LovBean> callLov(String query, Object[] obj) throws Exception {
		PM_IL_PROD_APPL_COVER_DELEGATE delegate = new PM_IL_PROD_APPL_COVER_DELEGATE();
		List<LovBean> suggestionList = null;
		try {
			suggestionList = delegate.prepareLovList(query, obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return suggestionList;
	}
	public void onPopulateDetail(PILM035_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	    PM_IL_PROD_APPL_COVER PM_IL_PROD_APPL_COVER = compositeAction
    		.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
    		.getPM_IL_PROD_APPL_COVER_BEAN();
    	try {
    	    if ((PM_IL_PROD_APPL_COVER.getPAC_COVER_CODE() != null) ){
    		PM_IL_PROD_APPL_COVER_DELEGATE delegate = new PM_IL_PROD_APPL_COVER_DELEGATE();
    		delegate.executeSelectStatement(compositeAction);
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    throw new Exception(e.getMessage());
    	}
	}

}
