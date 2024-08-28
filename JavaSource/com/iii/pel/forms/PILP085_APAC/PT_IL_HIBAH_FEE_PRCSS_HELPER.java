package com.iii.pel.forms.PILP085_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_HIBAH_FEE_PRCSS_HELPER {

	public void whenCreateRecord(
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN) {
		PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_ACNT_YN("Y");
	}

	public void preInsert(PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN)
			throws Exception {
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String C1 = " SELECT P9IL_HFP_SYS_ID.NEXTVAL FROM DUAL";
		try {
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, CommonUtils
					.getConnection());
			if (C1_REC.next()) {
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFP_SYS_ID(C1_REC.getLong(1));
			}
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}
	}

	public boolean processButtonPressed(
			PILP085_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String C1 = "SELECT HFP_POL_NO,HFP_SYS_ID FROM PT_IL_HIBAH_FEE_PRCSS "
				+ " WHERE  HFP_PRCSS_YN='Y' AND HFP_POL_NO BETWEEN "
				+ " ? AND ? AND HFP_ACNT_YEAR = ? ";

		String C2 = "SELECT 1 FROM PT_IL_HIBAH_FEE_PRCSS "
				+ " WHERE  HFP_POL_NO = ? AND HFP_PRCSS_YN = ? "
				+ " AND HFP_ACNT_YEAR = ?	AND HFP_SYS_ID<> ? ";

		boolean valid = false;
		PT_IL_HIBAH_FEE_PRCSS_ACTION PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN = compositeAction
				.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN();

		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		try {
			Connection connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] {
							PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN.getPT_IL_HIBAH_FEE_PRCSS_BEAN().getHFH_POL_NO_FM(),
							PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN.getPT_IL_HIBAH_FEE_PRCSS_BEAN().getHFH_POL_NO_TO(),
							PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN.getPT_IL_HIBAH_FEE_PRCSS_BEAN().getHFH_ACNT_YEAR() });
			while (C1_REC.next()) {
				String HFP_POL_NO = C1_REC.getString("HFP_POL_NO");
				Long HFP_SYS_ID = C1_REC.getLong("HFP_SYS_ID");
				Date HFH_DATE_FM = PT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN.getPT_IL_HIBAH_FEE_PRCSS_BEAN().getHFH_DATE_FM();

				new P9ILPK_CLAIM().P_HIBAH_FEE_PRCSS(HFP_POL_NO, CommonUtils
						.getProcedureValue(HFP_SYS_ID), CommonUtils
						.getProcedureValue(HFH_DATE_FM), "F");
				valid = true;
				
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}
		return valid;
	}

	public void preBlock(CTRL CTRL_BEAN) {
		CTRL_BEAN.setUI_M_COMM_DEL("Y");
	}

	public void whenValidatePolicyNoFrom(
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN) throws Exception {
		String C1 = " SELECT POL_ADDL_STATUS FROM PT_IL_POLICY"
				+ " WHERE POL_NO = ? ";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String M_POL_ADDL_STATUS = null;
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_HIBAH_FEE_PRCSS_BEAN
							.getHFH_POL_NO_FM() });
			if (C1_REC.next()) {
				M_POL_ADDL_STATUS = C1_REC.getString(1);
			}
			if ("H".equals(M_POL_ADDL_STATUS)) {
				throw new Exception("Policy Already Settled for Hibah");
			}

		} catch (Exception exception) {
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}

	public void whenValidatePolicyNoTo(
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN) throws Exception {

		String C1 = " SELECT POL_ADDL_STATUS FROM PT_IL_POLICY"
				+ " WHERE POL_NO = ? ";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String M_POL_ADDL_STATUS = null;
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_HIBAH_FEE_PRCSS_BEAN
							.getHFH_POL_NO_TO() });
			if (C1_REC.next()) {
				M_POL_ADDL_STATUS = C1_REC.getString(1);
			}
			if ("H".equals(M_POL_ADDL_STATUS)) {
				throw new Exception("Policy Already Settled for Hibah");
			}

		} catch (Exception exception) {
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}

	public void whenValidateAccountingYear(
			PT_IL_HIBAH_FEE_PRCSS PT_IL_HIBAH_FEE_PRCSS_BEAN) throws Exception {

		String C1 = " SELECT CAY_FRM_DT, CAY_TO_DT FROM FM_COMP_ACNT_YEAR"
				+ " WHERE CAY_ACNT_YEAR = ? ";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();

			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_HIBAH_FEE_PRCSS_BEAN
							.getHFH_ACNT_YEAR() });
			if (C1_REC.next()) {
				Date DATE_FROM = C1_REC.getDate(1);
				Date DATE_TO = C1_REC.getDate(2);

				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_DATE_FM(DATE_FROM);
				PT_IL_HIBAH_FEE_PRCSS_BEAN.setHFH_DATE_TO(DATE_TO);

			}

		} catch (Exception exception) {
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
}