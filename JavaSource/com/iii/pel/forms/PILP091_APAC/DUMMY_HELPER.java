package com.iii.pel.forms.PILP091_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_WAK_DRIP;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	public void WHEN_VALIDATE_ITEM_M_FROD_FROM() throws Exception{
		CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils.SET_REP_FIRST_FIELD("M_FROD_FROM", "String");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void WHEN_VALIDATE_ITEM_M_PROD_TO() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils
						.SET_REP_SECOND_FIELD("M_PROD_FM", "M_PROD_TO", "String");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void WHEN_VALIDATE_ITEM_M_POL_NO_FROM() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils.SET_REP_FIRST_FIELD("M_POL_NO_FROM", "String");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void WHEN_VALIDATE_ITEM_M_POL_NO_TO() throws Exception{
		CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils.SET_REP_SECOND_FIELD("M_POL_NO_FM", "M_POL_NO_TO",
						"String");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void WHEN_VALIDATE_ITEM_M_ACNT_YEAR_FM() throws Exception{
		CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils.SET_REP_FIRST_FIELD("M_ACNT_YEAR_FM", "String");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void WHEN_VALIDATE_ITEM_M_ACNT_YEAR_TO() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
			try {
				commonUtils.SET_REP_SECOND_FIELD("M_ACNT_YEAR_FM",
						"M_ACNT_YEAR_TO", "String");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public String WHEN_BUTTON_PRESSED_M_BUT_ACCEPT(DUMMY dummy_bean,
			PILP091_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PS_IL_CONT_PAID_HDR_HELPER helper = new PS_IL_CONT_PAID_HDR_HELPER();
			try {
				P9ILPK_WAK_DRIP.P_APPROVE_PA_PROFIT(dummy_bean
						.getUI_M_POL_NO_FROM(), dummy_bean.getUI_M_POL_NO_TO());
				helper.executeQuery(compositeAction);
			} catch (ProcedureException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		return "PILP091_PS_IL_CONT_PAID_HDR";
	}

	public void WHEN_BUTTON_PRESSED_SELECT_ALL(DUMMY dummyBean,
			DUMMY_ACTION dummyAction,PS_IL_CONT_PAID_HDR_ACTION paidHdrAction) throws Exception {
		String M_FLAG = null;
		String M_VAR = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Object[] values = null;
		PS_IL_CONT_PAID_HDR_HELPER hdrHelper = new PS_IL_CONT_PAID_HDR_HELPER();
		try {
			connection = CommonUtils.getConnection();
			// IF(GET_ITEM_PROPERTY('DUMMY.SELECT_ALL',LABEL)='Select All'
			if ("Select All".equalsIgnoreCase((String) dummyAction
					.getCOMP_SELECT_ALL().getValue())) {
				M_FLAG = "A";
				String C1 = "UPDATE PS_IL_CONT_PAID_HDR "
						+ "SET CPH_FREEZE_FLAG = 'Y' ,"
						+ "CPH_CONFIRM_FLAG = 'Y' "
						+ "WHERE  CPH_POL_NO BETWEEN  ? AND ? "
						+ "AND  CPH_PROD_CODE BETWEEN ? AND ? "
						+ "AND CPH_ACNT_YEAR BETWEEN  ? AND  ? "
						+ "AND CPH_APPROVE_YN = 'N'";
				values = new Object[]{dummyBean.getUI_M_POL_NO_FROM(),
						dummyBean.getUI_M_POL_NO_TO(),
						dummyBean.getUI_M_PROD_FM(),
						dummyBean.getUI_M_PROD_TO(),
						dummyBean.getUI_M_ACNT_YEAR_FM(),
						dummyBean.getUI_M_ACNT_YEAR_TO() };
				resultSet1 = handler.executeSelectStatement(C1, connection, values);
				dummyAction.getCOMP_SELECT_ALL().setValue("Deselect All");
				//SET_ITEM_PROPERTY('DUMMY.SELECT_ALL',LABEL,'Deselect All');
			}
			if (M_FLAG == null) {
				String C2 = "UPDATE PS_IL_CONT_PAID_HDR "
						+ "SET CPH_FREEZE_FLAG = 'N', "
						+ "CPH_CONFIRM_FLAG = 'N' "
						+ "WHERE CPH_POL_NO BETWEEN ? AND ? "
						+ "AND CPH_PROD_CODE BETWEEN ? AND ? "
						+ "AND CPH_ACNT_YEAR BETWEEN  ? AND  ? "
						+ "AND CPH_APPROVE_YN = 'N'";
				values = new Object[]{dummyBean.getUI_M_POL_NO_FROM(),
						dummyBean.getUI_M_POL_NO_TO(),
						dummyBean.getUI_M_PROD_FM(),
						dummyBean.getUI_M_PROD_TO(),
						dummyBean.getUI_M_ACNT_YEAR_FM(),
						dummyBean.getUI_M_ACNT_YEAR_TO() };
				resultSet2 = handler.executeSelectStatement(C2, connection, values);
				dummyAction.getCOMP_SELECT_ALL().setValue("Select All");
				//SET_ITEM_PROPERTY('DUMMY.SELECT_ALL',LABEL,'Select All');
			}
			M_VAR = " CPH_POL_NO BETWEEN '" + dummyBean.getUI_M_POL_NO_FROM()
					+ "' AND '" + dummyBean.getUI_M_POL_NO_TO() + "' "
					+ " AND CPH_PROD_CODE BETWEEN '"
					+ dummyBean.getUI_M_PROD_FM() + "' AND '"
					+ dummyBean.getUI_M_PROD_TO() + "' "
					+ " AND CPH_ACNT_YEAR BETWEEN '"
					+ dummyBean.getUI_M_ACNT_YEAR_FM() + "' AND '"
					+ dummyBean.getUI_M_ACNT_YEAR_TO() + "' "
					+ " AND CPH_APPROVE_YN = 'N' ";

			paidHdrAction.setDEFAULT_WHERE(M_VAR);
			hdrHelper.executeQuery(paidHdrAction.compositeAction);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet1);}catch (Exception e) {}
			try {CommonUtils.closeCursor(resultSet1);}catch (Exception e) {}
		}
	}

	public void keyNextItemM_ACNT_YEAR_TO(DUMMY dummyBean,
			PS_IL_CONT_PAID_HDR_ACTION paidHdrAction) throws Exception {
		String M_VAR = null;
		PS_IL_CONT_PAID_HDR_HELPER hdrHelper = new PS_IL_CONT_PAID_HDR_HELPER();

		if (dummyBean.getUI_M_POL_NO_TO() == null
				|| dummyBean.getUI_M_POL_NO_TO().trim().isEmpty()) {
			dummyBean.setUI_M_POL_NO_TO("ZZZZZZZZ");
		}

		if (dummyBean.getUI_M_PROD_TO() == null
				|| dummyBean.getUI_M_PROD_TO().trim().isEmpty()) {
			dummyBean.setUI_M_PROD_TO("ZZZZZZZZ");
		}

		if (dummyBean.getUI_M_ACNT_YEAR_TO() == null) {
			dummyBean.setUI_M_ACNT_YEAR_TO(99);
		}

		M_VAR = " CPH_POL_NO BETWEEN '" + dummyBean.getUI_M_POL_NO_FROM()
				+ "' AND '" + dummyBean.getUI_M_POL_NO_TO() + "' "
				+ " AND CPH_PROD_CODE BETWEEN '" + dummyBean.getUI_M_PROD_FM()
				+ "' AND '" + dummyBean.getUI_M_PROD_TO() + "' "
				+ " AND CPH_ACNT_YEAR BETWEEN '"
				+ dummyBean.getUI_M_ACNT_YEAR_FM() + "' AND '"
				+ dummyBean.getUI_M_ACNT_YEAR_TO() + "' "
				+ " AND CPH_APPROVE_YN = 'N' ";

		paidHdrAction.setDEFAULT_WHERE(M_VAR);
		hdrHelper.executeQuery(paidHdrAction.compositeAction);
	}

}
