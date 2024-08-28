package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILM003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RED_SA_HELPER {

	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_RED_SA_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_RED_SA> dataList = compositeAction
				.getPM_IL_RED_SA_ACTION_BEAN().getDataList_PM_IL_RED_SA();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_RED_SA PM_IL_RED_SA_BEAN = dataList.get(0);
			PM_IL_RED_SA_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_RED_SA_ACTION_BEAN().setPM_IL_RED_SA_BEAN(
					PM_IL_RED_SA_BEAN);
		}
	}

	public void WHEN_VALIDATE_RECORD(String RSA_PLAN_CODE, int RSA_YEAR_FROM,
			int RSA_YEAR_TO, String ROWID, int RSA_PERIOD_FM, int RSA_PERIOD_TO)
			throws Exception {
		String CURSOR_C1 = "SELECT RSA_YEAR_FROM,RSA_YEAR_TO,RSA_PERIOD_FROM,RSA_PERIOD_TO "
				+ "FROM PM_IL_RED_SA WHERE RSA_PLAN_CODE = ? AND (? BETWEEN RSA_YEAR_FROM "
				+ "AND RSA_YEAR_TO OR ? BETWEEN RSA_YEAR_FROM AND RSA_YEAR_TO OR "
				+ "RSA_YEAR_TO BETWEEN ? AND ?)";
		String CURSOR_C2 = "SELECT RSA_YEAR_FROM,RSA_YEAR_TO,RSA_PERIOD_FROM,RSA_PERIOD_TO "
				+ "FROM PM_IL_RED_SA WHERE RSA_PLAN_CODE = ? AND (? BETWEEN RSA_YEAR_FROM "
				+ "AND RSA_YEAR_TO OR	? BETWEEN RSA_YEAR_FROM AND RSA_YEAR_TO OR "
				+ "RSA_YEAR_TO BETWEEN ? AND ?) AND ROWID != ?";

		int YEAR_FM = 0;
		int YEAR_TO = 0;
		int PERIOD_FM = 0;
		int PERIOD_TO = 0;
		int rsa_year_fm = 0;
		int rsa_year_to = 0;
		int rsa_period_fm = 0;
		int rsa_period_to = 0;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { RSA_PLAN_CODE, RSA_YEAR_FROM, RSA_YEAR_TO,
							RSA_YEAR_FROM, RSA_YEAR_TO, ROWID });
			if (resultSet.next()) {
				YEAR_FM = resultSet.getInt(1);
				YEAR_TO = resultSet.getInt(2);
				PERIOD_FM = resultSet.getInt(3);
				PERIOD_TO = resultSet.getInt(4);
			}
			if (ROWID == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { RSA_PLAN_CODE,
								RSA_YEAR_FROM, RSA_YEAR_TO, RSA_YEAR_FROM,
								RSA_YEAR_TO });
				while (resultSet.next()) {
					rsa_year_fm = resultSet.getInt(1);
					rsa_year_to = resultSet.getInt(2);
					rsa_period_fm = resultSet.getInt(3);
					rsa_period_to = resultSet.getInt(4);
				}
				if ((RSA_YEAR_FROM > rsa_year_fm && RSA_YEAR_FROM < rsa_year_to)
						|| (RSA_YEAR_TO > rsa_year_fm && RSA_YEAR_TO < rsa_year_to)
						|| (rsa_year_to > RSA_YEAR_FROM && rsa_year_to < RSA_YEAR_TO)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71205"));
				} else if ((RSA_PERIOD_FM > rsa_period_fm && RSA_PERIOD_FM < rsa_period_to)
						|| (RSA_PERIOD_TO > rsa_period_fm && RSA_PERIOD_TO < rsa_period_to)
						|| (rsa_period_to > RSA_PERIOD_FM && rsa_period_to < RSA_PERIOD_TO)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71010"));
				} else if (rsa_year_fm != RSA_YEAR_FROM
						|| rsa_year_to != RSA_YEAR_TO) {
					if (rsa_year_fm == RSA_YEAR_FROM
							|| rsa_year_fm == RSA_YEAR_TO
							|| rsa_year_to == RSA_YEAR_FROM
							|| rsa_year_to == RSA_YEAR_TO
							|| rsa_year_fm == RSA_YEAR_TO) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71047"));
					}
				}
			} else if (ROWID != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { RSA_PLAN_CODE,
								RSA_YEAR_FROM, RSA_YEAR_TO, RSA_YEAR_FROM,
								RSA_YEAR_TO, ROWID });
				while (resultSet.next()) {
					YEAR_FM = resultSet.getInt(1);
					YEAR_TO = resultSet.getInt(2);
					PERIOD_FM = resultSet.getInt(3);
					PERIOD_TO = resultSet.getInt(4);
				}
				if ((RSA_YEAR_FROM > YEAR_FM && RSA_YEAR_FROM < YEAR_TO)
						|| (RSA_YEAR_TO > YEAR_FM && RSA_YEAR_TO < rsa_year_to)
						|| (YEAR_TO > RSA_YEAR_FROM && YEAR_TO < RSA_YEAR_TO)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71205"));
				} else if ((RSA_PERIOD_FM > PERIOD_FM && RSA_PERIOD_FM < PERIOD_TO)
						|| (RSA_PERIOD_TO > PERIOD_FM && RSA_PERIOD_TO < PERIOD_TO)
						|| (rsa_period_to > PERIOD_FM && rsa_period_to < PERIOD_TO)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71010"));
				} else if (YEAR_FM != RSA_YEAR_FROM || YEAR_TO != RSA_YEAR_TO) {
					if (YEAR_FM == RSA_YEAR_FROM || YEAR_FM == RSA_YEAR_TO
							|| YEAR_TO == RSA_YEAR_FROM
							|| YEAR_TO == RSA_YEAR_TO || YEAR_FM == RSA_YEAR_TO) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71047"));
					}
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_NEW_BLOCK_INSTANCE(PM_IL_RED_SA PM_IL_RED_SA_BEAN , PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		/*if (PM_IL_RED_SA_BEAN.getROWID() == null) {
			try {
				new PKG_PILM003().L_RSA_INSERT(
						planBean.getPLAN_PERIOD_FROM(),planBean.getPLAN_PERIOD_TO(),planBean.getPLAN_CODE());
				// EXECUTE_QUERY(NO_VALIDATE);
			} catch (ProcedureException e) {
				throw new Exception(e.getMessage());
			}
		}*/
	}
	public void PRE_INSERT(String RSA_PLAN_CODE, int RSA_PERIOD_FROM,
			int RSA_PERIOD_TO, int RSA_YEAR_FROM, int RSA_YEAR_TO,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		String CURSOR_C1 = "SELECT RSA_YEAR_FROM, RSA_YEAR_TO FROM PM_IL_RED_SA "
				+ "WHERE RSA_PLAN_CODE = ? AND RSA_PERIOD_FROM = ? AND RSA_PERIOD_TO = ?";

		String CURSOR_C2 = "SELECT RSA_PERIOD_FROM, RSA_PERIOD_TO FROM PM_IL_RED_SA "
				+ "WHERE RSA_PLAN_CODE = ? AND RSA_YEAR_FROM = ? AND RSA_YEAR_TO = ?";

		int PERIOD_FM = 0;
		int PERIOD_TO = 0;
		int YEAR_FM = 0;
		int YEAR_TO = 0;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { RSA_PLAN_CODE, RSA_PERIOD_FROM,
							RSA_PERIOD_TO });
			if (resultSet.next()) {
				PERIOD_FM = resultSet.getInt(1);
				PERIOD_TO = resultSet.getInt(2);
			}
			PM_IL_RED_SA_BEAN.setRSA_CR_DT(new CommonUtils().getCurrentDate());
			PM_IL_RED_SA_BEAN.setRSA_CR_UID(CommonUtils.getControlBean()
					.getUSER_ID());
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { RSA_PLAN_CODE, RSA_YEAR_FROM, RSA_YEAR_TO });
			while (resultSet.next()) {
				YEAR_FM = resultSet.getInt(1);
				YEAR_TO = resultSet.getInt(2);
			}
			if (RSA_YEAR_FROM >= YEAR_FM && RSA_YEAR_FROM <= YEAR_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205"));
			}
			if (RSA_YEAR_TO >= YEAR_FM && RSA_YEAR_TO <= YEAR_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205"));
			}
			if (RSA_YEAR_TO < YEAR_FM && RSA_YEAR_FROM > YEAR_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71047"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { RSA_PLAN_CODE, RSA_PERIOD_FROM,
							RSA_PERIOD_TO });
			while (resultSet.next()) {
				PERIOD_FM = resultSet.getInt(1);
				PERIOD_TO = resultSet.getInt(2);
			}
			if (RSA_PERIOD_FROM >= PERIOD_FM && RSA_PERIOD_FROM <= PERIOD_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71010"));
				// CHECK_PACKAGE_FAILURE;
			}
			if (RSA_PERIOD_TO < PERIOD_FM && RSA_PERIOD_FROM > PERIOD_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71014"));
			}

		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_NEW_RECORD_INSTANCE() {
		/*IF :SYSTEM.BLOCK_STATUS = 'CHANGED' THEN
		   :CTRL.M_COMM_DEL := 'P';
		   POST;
		   :PM_IL_RED_SA.RSA_YEAR_FROM :=  :PM_IL_RED_SA.RSA_YEAR_FROM;
		   :CTRL.M_COMM_DEL := NULL;
		END IF;*/
	}
	public void PRE_BLOCK(){
	/*	IF FORM_FAILURE THEN
		 :GLOBAL.M_FAILURE := 'TRUE';
	END IF;
	:CTRL.M_DELETE_MSG_FLAG := 'N';*/
	}
	public void PRE_UPDATE(String RSA_PLAN_CODE, int RSA_PERIOD_FROM,
			int RSA_PERIOD_TO, int RSA_YEAR_FROM, int RSA_YEAR_TO,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		String CURSOR_C1 = "SELECT RSA_YEAR_FROM,RSA_YEAR_TO FROM PM_IL_RED_SA "
				+ "WHERE RSA_PLAN_CODE = ? AND RSA_PERIOD_FROM = ? AND RSA_PERIOD_TO = ? "
				+ "AND ROWID != ?";

		String CURSOR_C2 = "SELECT RSA_PERIOD_FROM,RSA_PERIOD_TO FROM PM_IL_RED_SA "
				+ "WHERE RSA_PLAN_CODE = ? AND RSA_YEAR_FROM = ? AND RSA_YEAR_TO = ? "
				+ "AND ROWID != ?";
		int PERIOD_FM = 0;
		int PERIOD_TO = 0;
		int YEAR_FM = 0;
		int YEAR_TO = 0;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { RSA_PLAN_CODE, RSA_YEAR_FROM, RSA_YEAR_TO,
							PM_IL_RED_SA_BEAN.getROWID() });
			if (resultSet.next()) {
				PERIOD_FM = resultSet.getInt(1);
				PERIOD_TO = resultSet.getInt(2);
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { RSA_PLAN_CODE, RSA_PERIOD_FROM,
							RSA_PERIOD_TO, PM_IL_RED_SA_BEAN.getROWID() });
			while (resultSet.next()) {
				YEAR_FM = resultSet.getInt(1);
				YEAR_TO = resultSet.getInt(2);
			}
			if (RSA_YEAR_FROM >= YEAR_FM && RSA_YEAR_FROM <= YEAR_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205"));
			}
			if (RSA_YEAR_TO >= YEAR_FM && RSA_YEAR_TO <= YEAR_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { RSA_PLAN_CODE, RSA_YEAR_FROM, RSA_YEAR_TO,
							PM_IL_RED_SA_BEAN.getROWID() });
			while (resultSet.next()) {
				PERIOD_FM = resultSet.getInt(1);
				PERIOD_TO = resultSet.getInt(2);
			}
			if (RSA_PERIOD_FROM >= PERIOD_FM && RSA_PERIOD_FROM <= PERIOD_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71010"));
			}
			if (RSA_PERIOD_TO >= PERIOD_FM && RSA_PERIOD_TO <= PERIOD_TO) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71010"));
			}
			PM_IL_RED_SA_BEAN.setRSA_UPD_DT(new CommonUtils().getCurrentDate());
			PM_IL_RED_SA_BEAN.setRSA_UPD_UID(CommonUtils.getControlBean()
					.getUSER_ID());
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_CREATE_RECORD(PM_IL_RED_SA PM_IL_RED_SA_BEAN,PILM003_APAC_COMPOSITE_ACTION compositeAction) {
		PM_IL_RED_SA_BEAN.setRSA_CQS_RATE(0d);
		PM_IL_RED_SA_BEAN.setRSA_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
	}
	public void WHEN_VALIDATE_RSA_YEAR_FROM(Integer RSA_YEAR_FROM ,PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		if(PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM() != null ){
		if(RSA_YEAR_FROM > PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM()){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71094"));
		}
		}
	}
	public void WHEN_VALIDATE_RSA_YEAR_TO( Integer RSA_YEAR_TO,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		if(PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM() != null){
		if (RSA_YEAR_TO < PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM() && 
							PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM() > RSA_YEAR_TO) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71047"));
		}
		PM_IL_RED_SA_BEAN.setRSA_YEAR_TO(PM_IL_RED_SA_BEAN.getRSA_YEAR_FROM());
		}
	}

	public void WHEN_VALIDATE_RSA_PERIOD_FROM(Integer RSA_PERIOD_FROM,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN, Integer PLAN_PERIOD_FROM) throws Exception {
		int M_DIFF = 0;
		if (RSA_PERIOD_FROM < PLAN_PERIOD_FROM) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71130"));
		}
		if(PM_IL_RED_SA_BEAN.getRSA_PERIOD_TO() != null){
		if (RSA_PERIOD_FROM < PM_IL_RED_SA_BEAN.getRSA_PERIOD_TO()) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71214"));
		}
		}
		/*
		 * :PM_IL_RED_SA.RSA_YEAR_FROM := :PM_IL_RED_SA.RSA_YEAR_FROM;
		 * :PM_IL_RED_SA.RSA_YEAR_TO := :PM_IL_RED_SA.RSA_YEAR_TO;
		 */
	}

	public void WHEN_VALIDATE_RSA_PERIOD_TO(
			Integer RSA_PERIOD_TO, Integer PLAN_PERIOD_FROM,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		if(PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM() != null){
		if (RSA_PERIOD_TO < PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM() && PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM()
				> RSA_PERIOD_TO) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71014"));
		}
		PM_IL_RED_SA_BEAN.setRSA_PERIOD_TO(PM_IL_RED_SA_BEAN.getRSA_PERIOD_FROM());
		}
	}

	public void WHEN_VALIDATE_RSA_RI_RATE(Double RSA_RI_RATE,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		if (RSA_RI_RATE != null) {
			if (RSA_RI_RATE < 0) {
				throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "RI Rate", ">=", "0" }));
			}
		} else {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91014", new Object[] {
					"RI Rate", "Entered", "!" }));
		}
		PM_IL_RED_SA_BEAN.setRSA_CQS_RATE(RSA_RI_RATE);
	}
	public void WHEN_VALIDATE_RSA_CQS_RATE(Double RSA_CQS_RATE,
			PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		if (RSA_CQS_RATE != null) {
			if (RSA_CQS_RATE < 0) {
				throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "CQS Rate", ">=", "0" }));
			}
		} else {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91014", new Object[] {
					"CQS Rate", "Entered", "!" }));
		}
	}
	public void WHEN_VALIDATE_RSA_RATE_PER(PM_IL_RED_SA PM_IL_RED_SA_BEAN) throws Exception {
		if (PM_IL_RED_SA_BEAN.getRSA_RATE_PER() != null) {
			if (PM_IL_RED_SA_BEAN.getRSA_RATE_PER() < 0) {
				throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Rate Per", ">=", "0" }));
			}
		} else {
			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "91014", new Object[] {
					"Rate Per", "Entered", "!" }));
		}
	}
}
