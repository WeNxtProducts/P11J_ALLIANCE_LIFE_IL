package com.iii.pel.forms.PILM064_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.StringFunctions;

public class PM_MISC_ITEM_SETUP_HELPER {

	public void preInsert(PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN)
			throws Exception {
		try {
			PM_MISC_ITEM_SETUP_BEAN.setMIS_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_MISC_ITEM_SETUP_BEAN.setMIS_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			L_OVERLAP_CHECK(PM_MISC_ITEM_SETUP_BEAN);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void L_OVERLAP_CHECK(PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN)
			throws Exception {
		String CursorC1 = " SELECT 'X' FROM   PM_MISC_ITEM_SETUP WHERE (? BETWEEN "
				+ " MIS_BUS_FM_CODE AND MIS_BUS_TO_CODE OR ? BETWEEN "
				+ " MIS_BUS_FM_CODE AND MIS_BUS_TO_CODE OR MIS_BUS_FM_CODE BETWEEN ? AND "
				+ " ? OR MIS_BUS_TO_CODE BETWEEN ? AND"
				+ " ?) AND (? BETWEEN"
				+ " MIS_DIVN_FM_CODE AND MIS_DIVN_TO_CODE OR ? BETWEEN"
				+ " MIS_DIVN_FM_CODE AND MIS_DIVN_TO_CODE OR MIS_DIVN_FM_CODE BETWEEN ? AND ?"
				+ " OR MIS_DIVN_TO_CODE BETWEEN ? AND ?)"
				+ " AND (? BETWEEN MIS_DEPT_FM_CODE AND MIS_DEPT_TO_CODE"
				+ " OR ? BETWEEN MIS_DEPT_FM_CODE AND MIS_DEPT_TO_CODE"
				+ " OR MIS_DEPT_FM_CODE BETWEEN ? AND ?"
				+ " OR MIS_DEPT_TO_CODE BETWEEN ? AND ?)"
				+ " AND (NVL(?,'0')   BETWEEN NVL(MIS_DOC_FM_TYPE,'0') "
				+ " AND NVL(MIS_DOC_TO_TYPE,'Z') OR NVL(?,'Z') "
				+ " BETWEEN NVL(MIS_DOC_FM_TYPE,'0') AND NVL(MIS_DOC_TO_TYPE,'Z') OR NVL(MIS_DOC_FM_TYPE,'0')"
				+ " BETWEEN NVL(?,'0') AND NVL"
				+ " (?,'Z')OR NVL(MIS_DOC_TO_TYPE,'Z') "
				+ " BETWEEN NVL(?,'0') AND NVL"
				+ " (?,'Z'))"
				+ " AND(? = MIS_SETUP_TYPE)"
				+ " AND (? = MIS_SETUP_FOR)"
				+ " AND (NVL(?,'0') BETWEEN NVL(MIS_TYPE_FM_CODE,'0')"
				+ " AND NVL(MIS_TYPE_TO_CODE,'0')OR NVL(?,'0') "
				+ " BETWEEN NVL(MIS_TYPE_FM_CODE,'0') AND NVL(MIS_TYPE_TO_CODE,'0')"
				+ " OR NVL(MIS_TYPE_FM_CODE,'0') BETWEEN NVL(?,'0') AND "
				+ " NVL(?,'0')OR NVL(MIS_TYPE_TO_CODE,'0') BETWEEN NVL"
				+ " (?,'0') AND NVL(?,'0'))"
				+ " AND(NVL(?,0) BETWEEN NVL(MIS_YRS_FM,0) AND NVL(MIS_YRS_TO,9999)"
				+ " OR NVL(?,9999) BETWEEN NVL(MIS_YRS_FM,0) AND NVL(MIS_YRS_TO,9999)"
				+ " OR NVL(MIS_YRS_FM,0)BETWEEN NVL(?,0) AND "
				+ " NVL(?,9999) OR NVL(MIS_YRS_TO,9999) BETWEEN "
				+ " NVL(?,0) AND NVL(?,9999))"
				+ " AND (? BETWEEN MIS_SRC_BUS_FM   AND MIS_SRC_BUS_TO"
				+ " OR ? BETWEEN MIS_SRC_BUS_FM AND MIS_SRC_BUS_TO"
				+ " OR MIS_SRC_BUS_FM BETWEEN ? AND ?"
				+ " OR MIS_SRC_BUS_TO BETWEEN ? AND ?)"
				+ " AND (? BETWEEN MIS_PROD_CODE_FM   AND MIS_PROD_CODE_TO"
				+ " OR ? BETWEEN MIS_PROD_CODE_FM AND MIS_PROD_CODE_TO"
				+ " OR MIS_PROD_CODE_FM BETWEEN ? AND"
				+ " ? OR MIS_PROD_CODE_TO BETWEEN"
				+ " ? AND ?)"
				+ " AND (? BETWEEN MIS_COVER_CODE_FM   AND MIS_COVER_CODE_TO"
				+ " OR ? BETWEEN MIS_COVER_CODE_FM AND MIS_COVER_CODE_TO"
				+ " OR MIS_COVER_CODE_FM BETWEEN ? AND"
				+ " ? OR MIS_COVER_CODE_TO BETWEEN "
				+ " ? AND ?)"
				+ " AND MIS_ASSURED_TYPE = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			PM_MISC_ITEM_SETUP_BEAN.setMIS_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_MISC_ITEM_SETUP_BEAN.setMIS_UPD_DT(new CommonUtils()
					.getCurrentDate());
			values = new Object[] {
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_FOR(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_ASSURED_TYPE(), };
			resultSet = handler.executeSelectStatement(CursorC1, connection,
					values);
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80031"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}

	public void preUpdate(PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN)
			throws Exception {

		String C1 = " SELECT 'X' FROM   PM_MISC_ITEM_SETUP "
				+ "  WHERE  (? "
				+ " BETWEEN MIS_BUS_FM_CODE AND MIS_BUS_TO_CODE "
				+ " OR ? BETWEEN MIS_BUS_FM_CODE AND MIS_BUS_TO_CODE"
				+ " OR MIS_BUS_FM_CODE BETWEEN ? AND "
				+ "  ?  "
				+ " OR MIS_BUS_TO_CODE BETWEEN ? AND "
				+ " ?)"
				+ " AND(? BETWEEN MIS_DIVN_FM_CODE   AND MIS_DIVN_TO_CODE"
				+ " OR ? BETWEEN MIS_DIVN_FM_CODE "
				+ "  AND MIS_DIVN_TO_CODE"
				+ " OR MIS_DIVN_FM_CODE BETWEEN ? "
				+ " AND ?"
				+ " OR MIS_DIVN_TO_CODE BETWEEN ? "
				+ " AND ?)"
				+ " AND(? BETWEEN MIS_DEPT_FM_CODE   AND MIS_DEPT_TO_CODE"
				+ " OR ? BETWEEN MIS_DEPT_FM_CODE AND MIS_DEPT_TO_CODE"
				+ " OR MIS_DEPT_FM_CODE BETWEEN ?"
				+ "  AND ?"
				+ " OR MIS_DEPT_TO_CODE BETWEEN ?"
				+ " AND ?)"
				+ " AND(NVL(LPAD(?,12,'0'),'0')"
				+ "   BETWEEN NVL(LPAD(MIS_DOC_FM_TYPE,12,'0'),'0')  "
				+ " AND NVL(LPAD(MIS_DOC_TO_TYPE,12,'Z'),'Z')OR "
				+ " NVL(LPAD(?,12,'Z'),'Z')"
				+ "  BETWEEN NVL(LPAD(MIS_DOC_FM_TYPE,12,'0'),'0')"
				+ " AND NVL(LPAD(MIS_DOC_TO_TYPE,12,'Z'),'Z')OR "
				+ " NVL(LPAD(MIS_DOC_FM_TYPE,12,'0'),'0') BETWEEN "
				+ "  NVL(LPAD(?,12,'0'),'0')"
				+ " AND NVL(LPAD(?,12,'Z'),'Z')"
				+ " OR NVL(LPAD(MIS_DOC_TO_TYPE,12,'Z'),'Z') BETWEEN "
				+ " NVL(LPAD(?,12,'0'),'0')"
				+ " AND NVL(LPAD(?,12,'Z'),'Z'))"
				+ " AND(? = MIS_SETUP_TYPE)"
				+ " AND(? = MIS_SETUP_FOR)"
				+ " AND (NVL(?,'0') "
				+ " BETWEEN NVL(MIS_TYPE_FM_CODE,'0') AND NVL(MIS_TYPE_TO_CODE,'0')"
				+ " OR NVL(?,'0') BETWEEN NVL(MIS_TYPE_FM_CODE,'0') "
				+ " AND NVL(MIS_TYPE_TO_CODE,'0')OR NVL(MIS_TYPE_FM_CODE,'0') BETWEEN "
				+ " NVL(?,'0') " + " AND NVL(?,'0')"
				+ " OR NVL(MIS_TYPE_TO_CODE,'0') BETWEEN " + " NVL(?,'0')"
				+ " AND NVL(?,'0'))" + "  AND(NVL(?,0) "
				+ " BETWEEN NVL(MIS_YRS_FM,0) AND NVL(MIS_YRS_TO,9999)"
				+ " OR NVL(?,9999) "
				+ " BETWEEN NVL(MIS_YRS_FM,0) AND NVL(MIS_YRS_TO,9999)"
				+ " OR NVL(MIS_YRS_FM,0)   BETWEEN NVL(?,0)"
				+ " AND NVL(?,9999)"
				+ " OR NVL(MIS_YRS_TO,9999) BETWEEN NVL(?,0)"
				+ " AND NVL(?,9999))"
				+ " AND(? BETWEEN MIS_SRC_BUS_FM   AND MIS_SRC_BUS_TO"
				+ " OR ? BETWEEN MIS_SRC_BUS_FM "
				+ " AND MIS_SRC_BUS_TO OR MIS_SRC_BUS_FM BETWEEN " + " ? AND ?"
				+ " OR MIS_SRC_BUS_TO BETWEEN ?" + " AND ?)"
				+ " AND(? BETWEEN "
				+ " MIS_PROD_CODE_FM   AND MIS_PROD_CODE_TO" + " OR ? BETWEEN"
				+ " MIS_PROD_CODE_FM AND MIS_PROD_CODE_TO"
				+ " OR MIS_PROD_CODE_FM BETWEEN ?" + " AND ? "
				+ " OR MIS_PROD_CODE_TO BETWEEN ?" + " AND ?)              "
				+ " AND (? BETWEEN"
				+ " MIS_COVER_CODE_FM AND MIS_COVER_CODE_TO  "
				+ " OR ? BETWEEN "
				+ " MIS_COVER_CODE_FM AND MIS_COVER_CODE_TO "
				+ " OR MIS_COVER_CODE_FM BETWEEN ? " + " AND ?"
				+ " OR MIS_COVER_CODE_TO BETWEEN ?" + " AND ?)"
				+ " AND MIS_ASSURED_TYPE = ?" + " AND ROWID != ?";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			PM_MISC_ITEM_SETUP_BEAN.setMIS_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_MISC_ITEM_SETUP_BEAN.setMIS_UPD_DT(new CommonUtils()
					.getCurrentDate());
			values = new Object[] {
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_FOR(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_FM_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_ASSURED_TYPE(),
					PM_MISC_ITEM_SETUP_BEAN.getROWID() };
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80031"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void whenCreateRecord(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		try {
			PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_TYPE("C");
			PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DIVN_YN("N");
			PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DEPT_YN("N");
			PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_FOR("M");
			PM_MISC_ITEM_SETUP_BEAN.setMIS_ASSURED_TYPE("R");
			PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE().setRequired(
					true);
			PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE().setRequired(
					true);
			PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_FORCE_DEPT_YN()
					.setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void whenNewRecordInstance(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();

		String CursorC1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT"
				+ "WHERE MAIN_ACNT_CODE = ?";
		String CursorC2 = "SELECT ACTY_NAME FROM FM_ACTIVITY WHERE  ACTY_CODE = ? ";
		String CursorC3 = "SELECT ACTY_NAME FROM FM_ACTIVITY WHERE  ACTY_CODE = ?";
		String CursorC4 = "SELECT PS_CODE_DESC,PS_VALUE FROM PP_SYSTEM "
				+ "WHERE  PS_TYPE = 'IL_MISC_SET' AND PS_CODE = ?";
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		String M_DESC = null;
		Double M_VALUE = null;

		try {
			if ("C".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_SETUP_FOR()
						.setDisabled(false);
			} else {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_SETUP_FOR()
						.setDisabled(true);
			}
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(CursorC1, connection,
					new Object[] { PM_MISC_ITEM_SETUP_BEAN
							.getMIS_MAIN_ACNT_CODE() });
			if (resultSet1.next()) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_1(resultSet1.getString(1));
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_2(resultSet1.getString(2));
			}

			// TODO
			// L_SET_TYPE_BL Need Clarification
			if (PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_1() != null) {
				resultSet2 = handler.executeSelectStatement(CursorC2,
						connection, new Object[] { PM_MISC_ITEM_SETUP_BEAN
								.getUI_M_ACTY_1() });
				if (resultSet2.next()) {
					M_TEMP1 = resultSet2.getString(1);
					PM_MISC_ITEM_SETUP_ACTION_BEAN
							.getCOMP_MIS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
				} else {
					PM_MISC_ITEM_SETUP_ACTION_BEAN
							.getCOMP_MIS_ACTY_CODE_1_LABEL().setValue(
									"Activity code1");
				}
			}
			if (PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_2() != null) {
				resultSet3 = handler.executeSelectStatement(CursorC3,
						connection, new Object[] { PM_MISC_ITEM_SETUP_BEAN
								.getUI_M_ACTY_2() });
				if (resultSet3.next()) {
					M_TEMP2 = resultSet3.getString(1);
					PM_MISC_ITEM_SETUP_ACTION_BEAN
							.getCOMP_MIS_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
				} else {
					PM_MISC_ITEM_SETUP_ACTION_BEAN
							.getCOMP_MIS_ACTY_CODE_2_LABEL().setValue(
									"Activity code2");
				}

			}
			resultSet4 = handler
					.executeSelectStatement(CursorC4, connection,
							new Object[] { PM_MISC_ITEM_SETUP_BEAN
									.getMIS_SETUP_TYPE() });
			if (resultSet4.next()) {
				M_DESC = resultSet4.getString(1);
				M_VALUE = resultSet4.getDouble(2);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_YRS_FM_LABEL()
						.setValue(M_DESC + " " + "Years Fm");
			}
			if (M_VALUE == 1) {

				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE()
						.setDisabled(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE()
						.setDisabled(false);
			} else {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE()
						.setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE()
						.setDisabled(true);
			}

			PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_FORCE_DEPT_YN()
					.setDisabled(true);
			if ("Y".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DIVN_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE()
						.setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE()
						.setRequired(false);
			}
			if ("N".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DIVN_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE()
						.setDisabled(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE()
						.setRequired(true);
			}
			if ("Y".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DEPT_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(false);
			}
			if ("N".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DEPT_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setDisabled(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}

			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet4);
			} catch (Exception e) {
			}
		}
	}

	public void postQuery(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
			list = new DBProcedures().P_VAL_MAIN_ACNT(
					PM_MISC_ITEM_SETUP_BEAN.getMIS_MAIN_ACNT_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(list.get(0));
			}
			list.clear();
			list = new DBProcedures().P_VAL_SUB_ACNT(
					PM_MISC_ITEM_SETUP_BEAN.getMIS_MAIN_ACNT_CODE(),
					PM_MISC_ITEM_SETUP_BEAN.getMIS_SUB_ACNT_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(list.get(0));
			}
			list.clear();
			L_GET_ACTY_DETAILS(PM_MISC_ITEM_SETUP_ACTION_BEAN);

			list=  new DBProcedures().callP_VAL_DIVN(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_DIVN_CODE(),"N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_DIVN_NAME(list.get(0));
			}
			list.clear();
			list = new DBProcedures().callP_VAL_DEPT(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_DIVN_CODE(),PM_MISC_ITEM_SETUP_BEAN
					.getMIS_DEPT_CODE(),"N", "N");
			if (list!= null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_DEPT_NAME(list.get(0));
			}
			
			list = new DBProcedures().P_VAL_ANLY("1", PM_MISC_ITEM_SETUP_BEAN
					.getMIS_ANLY_CODE_1(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
			}
			list.clear();
			list = new DBProcedures().P_VAL_ANLY("2", PM_MISC_ITEM_SETUP_BEAN
					.getMIS_ANLY_CODE_2(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ANLY_NAME_1(list.get(0));
			}
			list.clear();
			list =  DBProcedures.P_VAL_ACTY(PM_MISC_ITEM_SETUP_BEAN
					.getUI_M_ACTY_1(), PM_MISC_ITEM_SETUP_BEAN
					.getMIS_ACTY_CODE_1(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_NAME(list.get(0));
			}
			list.clear();
			list =  DBProcedures.P_VAL_ACTY(PM_MISC_ITEM_SETUP_BEAN
					.getUI_M_ACTY_2(), PM_MISC_ITEM_SETUP_BEAN
					.getMIS_ACTY_CODE_2(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_NAME_1(list.get(0));
			}
			list.clear();
			list.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void L_GET_ACTY_DETAILS(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		String CURSORC1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT"
				+ " WHERE MAIN_ACNT_CODE = ?";
		String M_ACTY_HEAD_1 = null;
		String M_ACTY_HEAD_2 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSORC1, connection,
					new Object[] { PM_MISC_ITEM_SETUP_BEAN
							.getMIS_MAIN_ACNT_CODE() });
			if (resultSet.next()) {
				M_ACTY_HEAD_1 = resultSet.getString(1);
				M_ACTY_HEAD_2 = resultSet.getString(2);
			}
			PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
			PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void L_VAL_FROM_TO(String P_FROM_CODE, String P_TO_CODE)
			throws Exception {

		try {
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateMIS_Setup_Type(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {

		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		String M_CODE_DESC = null;
		Integer M_VALUE = null;
		ArrayList<String> list=new ArrayList<String>();
		try {

			list = L_VAL_SYSTEM("IL_MISC_SET", PM_MISC_ITEM_SETUP_BEAN
					.getMIS_SETUP_TYPE(), "E");

			if (list != null && !(list.isEmpty())) {
				M_CODE_DESC = list.get(0);
				M_VALUE = Integer.parseInt(list.get(1));
				if (M_VALUE == 1) {
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE()
					.setDisabled(false);
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE()
					.setDisabled(false);
				} else {
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE()
					.setDisabled(true);
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE()
					.setDisabled(true);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_FM_CODE(null);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_TO_CODE(null);
				}
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE_LABEL()
				.setValue(M_CODE_DESC + " " + "Range From");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE_LABEL()
				.setValue(M_CODE_DESC + " " + "Range Upto");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_YRS_FM_LABEL()
						.setValue(M_CODE_DESC + " " + "Years From");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_YRS_TO_LABEL()
				.setValue(M_CODE_DESC + " " + "Years Upto");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> L_VAL_SYSTEM(String P_TYPE, String P_CODE,
			String P_ERR_FLAG) {

		Connection connection = null;
		CRUDHandler handler = null;
		String M_NAME = null;
		ArrayList<String> list  = new ArrayList<String>();
		String M_BL_NAME = null;
		String M_VALUE = null;
		String selectQuery = "SELECT    PS_CODE_DESC,    PS_BL_CODE_DESC,    PS_VALUE FROM  PP_SYSTEM  "
				+ "WHERE  PS_TYPE  = ?  AND PS_CODE  = ? ";
		ResultSet rst = null;
		String P_CODE_DESC = "";
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				handler = new CRUDHandler();
				Object[] values = { P_TYPE, P_CODE };
				rst = handler.executeSelectStatement(selectQuery, connection,
						values);
				if (rst.next()) {
					M_NAME = rst.getString(1);
					M_BL_NAME = rst.getString(2);
					M_VALUE = rst.getString(3);
				}

				if (rst.isAfterLast() || rst.isBeforeFirst()) {
					if (P_ERR_FLAG == ("W") || P_ERR_FLAG == ("E")) {
						// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1000,NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"),P_TYPE,P_CODE);
						if (P_ERR_FLAG.equals("" + "E")) {
							throw new ValidatorException(new FacesMessage(
									"ERROR FROM FETCH"));
						}
					}
				}

			}

			// if(StringFunctions.substr(commonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),5,1)=="1"
			// || commonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")=="ENG")
			if (StringFunctions.substr("ARBR2", 5, 1) == "1" || "ENG" == "ENG") {
				P_CODE_DESC = M_NAME;
			} else {
				P_CODE_DESC = M_BL_NAME;
			}
			
			list.add(P_CODE_DESC);
			list.add(String.valueOf(M_VALUE));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	public void whenValidateMIS_Setup_TypeOnChange(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		String CURSORC1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_MISC_SET' AND"
				+ " PS_CODE = ?";
		String M_CODE_DESC = null;
		Integer M_VALUE = null;
		String M_DESC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> list=new ArrayList<String>();
		try {
			list=L_VAL_SYSTEM("IL_MISC_SET", PM_MISC_ITEM_SETUP_BEAN
					.getMIS_SETUP_TYPE(), "E");
			if (list != null && !(list.isEmpty())) {
				M_DESC = list.get(0);
				M_VALUE=Integer.parseInt(list.get(1));		
				if (M_VALUE == 1) {
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE()
					.setDisabled(false);
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE()
						.setDisabled(false);
				} else {
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE()
					.setDisabled(true);
					PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE()
					.setDisabled(true);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_FM_CODE(null);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_TO_CODE(null);
				}
			}

			connection = CommonUtils.getConnection();
			resultSet = handler
					.executeSelectStatement(CURSORC1, connection,
							new Object[] { PM_MISC_ITEM_SETUP_BEAN
									.getMIS_SETUP_TYPE() });
			if (resultSet.next()) {
				M_DESC = resultSet.getString(1);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_FM_CODE_LABEL()
				.setValue(M_DESC + " " + "Range From");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_TYPE_TO_CODE_LABEL()
				.setValue(M_DESC + " " + "Range Upto");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_YRS_FM_LABEL()
						.setValue(M_DESC + " " + "Years From");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_YRS_TO_LABEL()
				.setValue(M_DESC + " " + "Years Upto");
			}

			// L_SET_TYPE_BL;
			if ("C".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {

				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_SETUP_FOR()
						.setDisabled(false);
			} else {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_SETUP_FOR()
						.setDisabled(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}

	public void whenValidateMIS_FORCE_DIVN_YN(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		try {

			if ("Y".equalsIgnoreCase(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DIVN_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DEPT_YN("Y");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_FORCE_DEPT_YN().setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE().setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE().setRequired(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE().setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE().setRequired(false);
			}
			if ("N".equalsIgnoreCase(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN.getMIS_FORCE_DIVN_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DEPT_YN("N");
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_FORCE_DEPT_YN().setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE().setDisabled(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE().setRequired(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE().setDisabled(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE().setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void whenValidateMIS_FORCE_DEPT_YN(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		try {
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DEPT_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setDisabled(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(false);
			}
			if ("N".equalsIgnoreCase(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DEPT_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setDisabled(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void whenValidateMIS_MAIN_ACNT_CODE(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) throws Exception {

		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();

		String CURSORC1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2"
				+ " FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE = ?";
		String CURSORC2 = "SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ? ";
		String CURSORC3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ?";
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> list = new ArrayList<String>();
		try {
			connection=CommonUtils.getConnection();
			list = new DBProcedures().P_VAL_MAIN_ACNT(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_MAIN_ACNT_CODE(), "N", "E");
			if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(list.get(0));
			}
			list.clear();
			resultSet1 = handler.executeSelectStatement(CURSORC1, connection,
					new Object[] { PM_MISC_ITEM_SETUP_BEAN
							.getMIS_MAIN_ACNT_CODE() });
			if (resultSet1.next()) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_1(resultSet1.getString(1));
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_2(resultSet1.getString(2));
				System.out.println(PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_1());
				System.out.println(PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_2());

				if (PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_1() != null) {

					resultSet2 = handler.executeSelectStatement(CURSORC2,
							connection, new Object[] { PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_1() });
					if (resultSet2.next()) {
						M_TEMP1 = resultSet2.getString(1);
						PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
					} else {
						PM_MISC_ITEM_SETUP_ACTION_BEAN
								.getCOMP_MIS_ACTY_CODE_1_LABEL().setValue("Activity Code1");
					}
				}
				if (PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_2() != null) {
					resultSet3 = handler.executeSelectStatement(CURSORC3,
							connection, new Object[] { PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_2() });
					if (resultSet3.next()) {
						M_TEMP2 = resultSet3.getString(1);
						PM_MISC_ITEM_SETUP_ACTION_BEAN
								.getCOMP_MIS_ACTY_CODE_2_LABEL().setValue(M_TEMP2);
					} else {
						PM_MISC_ITEM_SETUP_ACTION_BEAN
								.getCOMP_MIS_ACTY_CODE_1_LABEL().setValue("Activity Code2");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}
	}

	public void whenValidateMIS_SUB_ACNT_CODE(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {

		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
			PM_MISC_ITEM_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_SUB_ACNT_CODE() != null) {
				list = new DBProcedures().P_VAL_SUB_ACNT(
						PM_MISC_ITEM_SETUP_BEAN.getMIS_MAIN_ACNT_CODE(),
						PM_MISC_ITEM_SETUP_BEAN.getMIS_SUB_ACNT_CODE(), "N",
						"E");
				if (list != null && !(list.isEmpty())) {
					PM_MISC_ITEM_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(list.get(0));
				}
				list.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void whenValidateMIS_DIVN_CODE(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) throws Exception {

		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();

		ArrayList<String> list=new ArrayList<String>();
		try {

			PM_MISC_ITEM_SETUP_BEAN.setUI_M_DIVN_NAME(null);
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_CODE() != null) {
				list = new DBProcedures().callP_VAL_DIVN(PM_MISC_ITEM_SETUP_BEAN
						.getMIS_DIVN_CODE(),"N", "E");
				if (list != null && !(list.isEmpty())) {
					PM_MISC_ITEM_SETUP_BEAN.setUI_M_DIVN_NAME(list.get(0));
					
				}
			}
			if ("N".equalsIgnoreCase(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DIVN_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DIVN_CODE()
						.setRequired(true);
			}

			L_SET_DEPT_ATTR(PM_MISC_ITEM_SETUP_ACTION_BEAN);
			// :PM_MISC_ITEM_SETUP.MIS_DEPT_CODE :=
			// :PM_MISC_ITEM_SETUP.MIS_DEPT_CODE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateMIS_DEPT_CODE(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {

		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();

		ArrayList<String> list = new ArrayList<String>();
		String list1 = null;
		try {

			PM_MISC_ITEM_SETUP_BEAN.setUI_M_DEPT_NAME(null);
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_CODE() != null) {
				list = new DBProcedures().callP_VAL_DEPT(PM_MISC_ITEM_SETUP_BEAN
						.getMIS_DIVN_CODE(), PM_MISC_ITEM_SETUP_BEAN
						.getMIS_DEPT_CODE(), "N", "E");
					if(list !=null &&!(list.isEmpty())){
						PM_MISC_ITEM_SETUP_BEAN.setUI_M_DEPT_NAME(list.get(0));
					}
			}
			if ("N".equalsIgnoreCase(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN
					.getMIS_FORCE_DEPT_YN(), "N"))) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void L_SET_DEPT_ATTR(
			PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();

		try {
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_CODE() == null) {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(false);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setDisabled(true);
				if (PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_CODE() != null) {
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_CODE(null);
					PM_MISC_ITEM_SETUP_BEAN.setUI_M_DEPT_NAME(null);
				}
			} else {
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setRequired(true);
				PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_DEPT_CODE()
						.setDisabled(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void whenNewItemInstanceMIS_DEPT_CODE(PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN){
		try{
			L_SET_DEPT_ATTR(PM_MISC_ITEM_SETUP_ACTION_BEAN);
		}catch (Exception e) {
			e.printStackTrace();		
			}
	}
	
	public void whenValidateMIS_ANLY_CODE_1(PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_MISC_ITEM_SETUP_BEAN.setUI_M_ANLY_NAME(null);
	if(PM_MISC_ITEM_SETUP_BEAN.getMIS_ANLY_CODE_1() !=null){
		 list= new DBProcedures().P_VAL_ANLY("1",PM_MISC_ITEM_SETUP_BEAN.getMIS_ANLY_CODE_1(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
				list.clear();
			} 
	}
	L_SET_ANALYSIS_ATTR(PM_MISC_ITEM_SETUP_ACTION_BEAN);
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void whenValidateMIS_ANLY_CODE_2(PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_MISC_ITEM_SETUP_BEAN.setUI_M_ANLY_NAME_1(null);
	if(PM_MISC_ITEM_SETUP_BEAN.getMIS_ANLY_CODE_2() !=null){
		 list= new DBProcedures().P_VAL_ANLY("2",PM_MISC_ITEM_SETUP_BEAN.getMIS_ANLY_CODE_2(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ANLY_NAME_1(list.get(0));
				list.clear();
			} 
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void L_SET_ANALYSIS_ATTR (PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN){
		PM_MISC_ITEM_SETUP  PM_MISC_ITEM_SETUP_BEAN=PM_MISC_ITEM_SETUP_ACTION_BEAN.getPM_MISC_ITEM_SETUP_BEAN();
		
	try{
	if(PM_MISC_ITEM_SETUP_BEAN.getMIS_ANLY_CODE_1()==null){
		 PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_ANLY_CODE_2().setDisabled(true);
	}  
	else{
		PM_MISC_ITEM_SETUP_ACTION_BEAN.getCOMP_MIS_ANLY_CODE_2().setDisabled(false);
	}
	}
	catch (Exception e) {
		e.printStackTrace();}
	
	}
	public void whenNewItemInstanceMIS_ANLY_CODE_2(PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN){
		try{
			L_SET_ANALYSIS_ATTR(PM_MISC_ITEM_SETUP_ACTION_BEAN);
		}catch (Exception e) {
			e.printStackTrace();		
			}
	}

	public void whenValidateMIS_ACTY_CODE_1(PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_NAME(null);
	if(PM_MISC_ITEM_SETUP_BEAN.getMIS_ACTY_CODE_1() !=null){
		 list= DBProcedures.P_VAL_ACTY(PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_1(),
                 PM_MISC_ITEM_SETUP_BEAN.getMIS_ACTY_CODE_1(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_NAME(list.get(0));
				list.clear();
			} 
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	public void whenValidateMIS_ACTY_CODE_2(PM_MISC_ITEM_SETUP_ACTION PM_MISC_ITEM_SETUP_ACTION_BEAN) {
		PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_ACTION_BEAN
				.getPM_MISC_ITEM_SETUP_BEAN();
		ArrayList<String> list = new ArrayList<String>();
		try {
	PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
	if(PM_MISC_ITEM_SETUP_BEAN.getMIS_ACTY_CODE_2() !=null){
		 list=  DBProcedures.P_VAL_ACTY(PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_2(),
                 PM_MISC_ITEM_SETUP_BEAN.getMIS_ACTY_CODE_2(),"N","E");
		 if (list != null && !(list.isEmpty())) {
				PM_MISC_ITEM_SETUP_BEAN.setUI_M_ACTY_NAME_1(list.get(0));
				list.clear();
			} 
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
}